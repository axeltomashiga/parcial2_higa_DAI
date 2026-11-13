package ar.jornadas.ui

import android.app.Application
import androidx.lifecycle.*
import ar.jornadas.Servicios
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.io.IOException

class ProgramaModel(app: Application) : AndroidViewModel(app) {
    private val servicios = Servicios(app)
    val mesa = servicios.mesa
    private val repo = servicios.agenda
    val charlas = repo.programa.stateIn(viewModelScope, SharingStarted.Eagerly, emptyList())
    val dia = MutableStateFlow(0)
    val aviso = MutableStateFlow("")
    val cargando = MutableStateFlow(false)
    val tieneEdicion = MutableStateFlow(repo.tieneEdicionPrevia)

    init {
        viewModelScope.launch {
            if (repo.hayDatosGuardados()) {
                tieneEdicion.value = true
            }
        }
    }

    fun recargar() {
        viewModelScope.launch {
            cargando.value = true
            aviso.value = ""
            try {
                repo.sincronizar()
                tieneEdicion.value = true
                aviso.value = ""
            } catch (e: IOException) {
                if (repo.hayDatosGuardados()) {
                    tieneEdicion.value = true
                    aviso.value = "Se están usando datos guardados"
                } else {
                    aviso.value = "No se pudo consultar el programa"
                }
            } finally {
                cargando.value = false
            }
        }
    }

    fun marcar(id: String) { viewModelScope.launch { repo.cambiarFavorita(id) } }
}
