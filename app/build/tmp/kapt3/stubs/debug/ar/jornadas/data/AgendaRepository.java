package ar.jornadas.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0086@\u00a2\u0006\u0002\u0010\u001dJ\u000e\u0010\u001e\u001a\u00020\u0013H\u0086@\u00a2\u0006\u0002\u0010\u001fJ\u000e\u0010 \u001a\u00020\u001aH\u0086@\u00a2\u0006\u0002\u0010\u001fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R$\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00138F@BX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006!"}, d2 = {"Lar/jornadas/data/AgendaRepository;", "", "api", "Lar/jornadas/data/ProgramaApi;", "dao", "Lar/jornadas/data/CarteleraDao;", "context", "Landroid/content/Context;", "(Lar/jornadas/data/ProgramaApi;Lar/jornadas/data/CarteleraDao;Landroid/content/Context;)V", "prefs", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "programa", "Lkotlinx/coroutines/flow/Flow;", "", "Lar/jornadas/data/Charla;", "getPrograma", "()Lkotlinx/coroutines/flow/Flow;", "value", "", "tieneEdicionPrevia", "getTieneEdicionPrevia", "()Z", "setTieneEdicionPrevia", "(Z)V", "cambiarFavorita", "", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hayDatosGuardados", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sincronizar", "app_debug"})
public final class AgendaRepository {
    @org.jetbrains.annotations.NotNull()
    private final ar.jornadas.data.ProgramaApi api = null;
    @org.jetbrains.annotations.NotNull()
    private final ar.jornadas.data.CarteleraDao dao = null;
    private final android.content.SharedPreferences prefs = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.util.List<ar.jornadas.data.Charla>> programa = null;
    
    public AgendaRepository(@org.jetbrains.annotations.NotNull()
    ar.jornadas.data.ProgramaApi api, @org.jetbrains.annotations.NotNull()
    ar.jornadas.data.CarteleraDao dao, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    public final boolean getTieneEdicionPrevia() {
        return false;
    }
    
    private final void setTieneEdicionPrevia(boolean value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<ar.jornadas.data.Charla>> getPrograma() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object hayDatosGuardados(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object sincronizar(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object cambiarFavorita(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}