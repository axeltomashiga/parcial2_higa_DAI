package ar.jornadas.ui

import android.app.Application
import androidx.lifecycle.*
import ar.jornadas.Servicios
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.io.IOException

class ProgramaModel(app: Application, private val state: SavedStateHandle) : AndroidViewModel(app) {
    private val servicios = Servicios(app)
    val mesa = servicios.mesa
    private val repo = servicios.agenda
    val charlas = repo.programa.stateIn(viewModelScope, SharingStarted.Eagerly, emptyList())
    val dia = MutableStateFlow(state.get<Int>("dia") ?: 0)
    val tema = MutableStateFlow(state.get<String>("tema") ?: "Todos")
    val aviso = MutableStateFlow("")
    val cargando = MutableStateFlow(false)
    val tieneEdicion = MutableStateFlow(repo.tieneEdicionPrevia)

    private var cargaInicialIniciada = false
    private var intentoPendiente = false

    init {
        viewModelScope.launch {
            if (repo.hayDatosGuardados()) {
                tieneEdicion.value = true
            }
        }
        viewModelScope.launch {
            dia.collect { state["dia"] = it }
        }
        viewModelScope.launch {
            tema.collect { state["tema"] = it }
        }
    }

    fun cargaInicial() {
        if (!cargaInicialIniciada) {
            cargaInicialIniciada = true
            recargar()
        }
    }

    fun recargar() {
        if (cargando.value) {
            intentoPendiente = true
            return
        }
        viewModelScope.launch {
            try {
                cargando.value = true
                do {
                    intentoPendiente = false
                    ejecutarDescarga()
                } while (intentoPendiente)
            } finally {
                cargando.value = false
            }
        }
    }

    private suspend fun ejecutarDescarga() {
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
        }
    }

    fun marcar(id: String) { viewModelScope.launch { repo.cambiarFavorita(id) } }
}
