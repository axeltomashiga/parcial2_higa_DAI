package ar.jornadas.data

import android.content.Context

class AgendaRepository(
    private val api: ProgramaApi,
    private val dao: CarteleraDao,
    context: Context
) {
    private val prefs = context.getSharedPreferences("agenda", Context.MODE_PRIVATE)

    var tieneEdicionPrevia: Boolean
        get() = prefs.getBoolean("edicion_descargada", false)
        private set(value) = prefs.edit().putBoolean("edicion_descargada", value).apply()

    val programa = dao.observar()

    suspend fun hayDatosGuardados(): Boolean {
        if (tieneEdicionPrevia) return true
        if (dao.contar() > 0) {
            tieneEdicionPrevia = true
            return true
        }
        return false
    }

    suspend fun sincronizar() {
        val fichas = api.consultar().map {
            Charla(it.id, it.title, it.track, it.day, it.time, it.room, it.speaker, it.summary)
        }
        dao.reemplazar(fichas)
        tieneEdicionPrevia = true
    }

    suspend fun cambiarFavorita(id: String) = dao.alternar(id)
}
