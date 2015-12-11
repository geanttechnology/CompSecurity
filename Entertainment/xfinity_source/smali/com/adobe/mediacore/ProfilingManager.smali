.class final Lcom/adobe/mediacore/ProfilingManager;
.super Ljava/lang/Object;


# static fields
.field private static final LOG_TAG:Ljava/lang/String;

.field public static final PROFILING_ENABLED:Z

.field private static final _logger:Lcom/adobe/mediacore/logging/Logger;

.field private static _registeredProfilers:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/adobe/mediacore/Profiler;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "[PSDK]::[PROFILING]::"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-class v1, Lcom/adobe/mediacore/ProfilingManager;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/adobe/mediacore/ProfilingManager;->LOG_TAG:Ljava/lang/String;

    sget-object v0, Lcom/adobe/mediacore/ProfilingManager;->LOG_TAG:Ljava/lang/String;

    invoke-static {v0}, Lcom/adobe/mediacore/logging/Log;->getLogger(Ljava/lang/String;)Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    sput-object v0, Lcom/adobe/mediacore/ProfilingManager;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    sput-object v0, Lcom/adobe/mediacore/ProfilingManager;->_registeredProfilers:Ljava/util/Map;

    return-void
.end method

.method constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static getElapsedTime(Ljava/lang/String;)J
    .locals 2

    sget-object v0, Lcom/adobe/mediacore/ProfilingManager;->_registeredProfilers:Ljava/util/Map;

    invoke-interface {v0, p0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    sget-object v0, Lcom/adobe/mediacore/ProfilingManager;->_registeredProfilers:Ljava/util/Map;

    invoke-interface {v0, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/Profiler;

    invoke-virtual {v0}, Lcom/adobe/mediacore/Profiler;->getElapsedTime()J

    move-result-wide v0

    :goto_0
    return-wide v0

    :cond_0
    const-wide/16 v0, 0x0

    goto :goto_0
.end method

.method static getTotalElapsedTime(Ljava/lang/String;)J
    .locals 2

    sget-object v0, Lcom/adobe/mediacore/ProfilingManager;->_registeredProfilers:Ljava/util/Map;

    invoke-interface {v0, p0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    sget-object v0, Lcom/adobe/mediacore/ProfilingManager;->_registeredProfilers:Ljava/util/Map;

    invoke-interface {v0, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/Profiler;

    invoke-virtual {v0}, Lcom/adobe/mediacore/Profiler;->getTotalElapsedTime()J

    move-result-wide v0

    :goto_0
    return-wide v0

    :cond_0
    const-wide/16 v0, 0x0

    goto :goto_0
.end method

.method static log(Ljava/lang/String;Ljava/lang/String;)V
    .locals 6

    sget-object v0, Lcom/adobe/mediacore/ProfilingManager;->_logger:Lcom/adobe/mediacore/logging/Logger;

    sget-object v1, Lcom/adobe/mediacore/ProfilingManager;->LOG_TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Elapsed/Total time for "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " is "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {p0}, Lcom/adobe/mediacore/ProfilingManager;->getElapsedTime(Ljava/lang/String;)J

    move-result-wide v4

    invoke-virtual {v2, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " ms "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {p0}, Lcom/adobe/mediacore/ProfilingManager;->getTotalElapsedTime(Ljava/lang/String;)J

    move-result-wide v4

    invoke-virtual {v2, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method static recordElapsedTime(Ljava/lang/String;)V
    .locals 1

    sget-object v0, Lcom/adobe/mediacore/ProfilingManager;->_registeredProfilers:Ljava/util/Map;

    invoke-interface {v0, p0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    sget-object v0, Lcom/adobe/mediacore/ProfilingManager;->_registeredProfilers:Ljava/util/Map;

    invoke-interface {v0, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/Profiler;

    invoke-virtual {v0}, Lcom/adobe/mediacore/Profiler;->registerElapsedTime()V

    :cond_0
    return-void
.end method

.method static recordStartElapsedTime(Ljava/lang/String;)V
    .locals 1

    sget-object v0, Lcom/adobe/mediacore/ProfilingManager;->_registeredProfilers:Ljava/util/Map;

    invoke-interface {v0, p0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    sget-object v0, Lcom/adobe/mediacore/ProfilingManager;->_registeredProfilers:Ljava/util/Map;

    invoke-interface {v0, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/Profiler;

    invoke-virtual {v0}, Lcom/adobe/mediacore/Profiler;->registerStartElapsedTime()V

    :cond_0
    return-void
.end method

.method static registerProfiler(Ljava/lang/String;)V
    .locals 2

    sget-object v0, Lcom/adobe/mediacore/ProfilingManager;->_registeredProfilers:Ljava/util/Map;

    invoke-interface {v0, p0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    sget-object v0, Lcom/adobe/mediacore/ProfilingManager;->_registeredProfilers:Ljava/util/Map;

    new-instance v1, Lcom/adobe/mediacore/Profiler;

    invoke-direct {v1}, Lcom/adobe/mediacore/Profiler;-><init>()V

    invoke-interface {v0, p0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_0
    return-void
.end method

.method static unregisterProfiler(Ljava/lang/String;)V
    .locals 1

    sget-object v0, Lcom/adobe/mediacore/ProfilingManager;->_registeredProfilers:Ljava/util/Map;

    invoke-interface {v0, p0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    sget-object v0, Lcom/adobe/mediacore/ProfilingManager;->_registeredProfilers:Ljava/util/Map;

    invoke-interface {v0, p0}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    :cond_0
    return-void
.end method
