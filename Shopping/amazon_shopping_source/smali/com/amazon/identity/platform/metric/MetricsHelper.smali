.class public final Lcom/amazon/identity/platform/metric/MetricsHelper;
.super Ljava/lang/Object;
.source "MetricsHelper.java"


# static fields
.field private static final TAG:Ljava/lang/String;

.field private static final VERBOSE_METRICS_ENABLED:Z

.field private static sContext:Landroid/content/Context;

.field private static sMetricsCollector:Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;

.field private static volatile sSupportsDcpMetrics:Ljava/lang/Boolean;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    const/4 v1, 0x0

    .line 19
    sput-object v1, Lcom/amazon/identity/platform/metric/MetricsHelper;->sMetricsCollector:Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;

    .line 21
    const-class v0, Lcom/amazon/identity/auth/device/framework/Tracer;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/platform/metric/MetricsHelper;->TAG:Ljava/lang/String;

    .line 23
    sput-object v1, Lcom/amazon/identity/platform/metric/MetricsHelper;->sSupportsDcpMetrics:Ljava/lang/Boolean;

    .line 25
    const-string/jumbo v0, "yes"

    new-instance v1, Lcom/amazon/identity/auth/device/framework/SystemPropertiesWrapper;

    invoke-direct {v1}, Lcom/amazon/identity/auth/device/framework/SystemPropertiesWrapper;-><init>()V

    const-string/jumbo v2, "com.amazon.map.verbose.metrics"

    invoke-virtual {v1, v2}, Lcom/amazon/identity/auth/device/framework/SystemPropertiesWrapper;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    sput-boolean v0, Lcom/amazon/identity/platform/metric/MetricsHelper;->VERBOSE_METRICS_ENABLED:Z

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 29
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 30
    return-void
.end method

.method public static declared-synchronized getMetricsCollectorInstance(Landroid/content/Context;)Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 39
    const-class v1, Lcom/amazon/identity/platform/metric/MetricsHelper;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/amazon/identity/platform/metric/MetricsHelper;->sMetricsCollector:Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;

    if-eqz v0, :cond_0

    .line 41
    sget-object v0, Lcom/amazon/identity/platform/metric/MetricsHelper;->sMetricsCollector:Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 60
    :goto_0
    monitor-exit v1

    return-object v0

    .line 44
    :cond_0
    :try_start_1
    invoke-static {}, Lcom/amazon/identity/auth/device/utils/UnitTestUtils;->isRunningInUnitTest()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 46
    sget-object v0, Lcom/amazon/identity/platform/metric/MetricsHelper;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Running in unit test, creating logging metrics collector"

    invoke-static {v0, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 47
    new-instance v0, Lcom/amazon/identity/platform/metric/PlatformLoggingMetricsCollector;

    const-string/jumbo v2, "UnitTest"

    invoke-direct {v0, v2}, Lcom/amazon/identity/platform/metric/PlatformLoggingMetricsCollector;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/platform/metric/MetricsHelper;->sMetricsCollector:Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;

    .line 60
    :goto_1
    sget-object v0, Lcom/amazon/identity/platform/metric/MetricsHelper;->sMetricsCollector:Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;

    goto :goto_0

    .line 49
    :cond_1
    invoke-static {}, Lcom/amazon/identity/platform/metric/MetricsHelper;->supportClientMetrics()Z

    move-result v0

    if-eqz v0, :cond_2

    if-eqz p0, :cond_2

    .line 51
    sget-object v0, Lcom/amazon/identity/platform/metric/MetricsHelper;->TAG:Ljava/lang/String;

    .line 52
    new-instance v0, Lcom/amazon/identity/platform/metric/PlatformDCPMetricsCollector;

    invoke-direct {v0, p0}, Lcom/amazon/identity/platform/metric/PlatformDCPMetricsCollector;-><init>(Landroid/content/Context;)V

    sput-object v0, Lcom/amazon/identity/platform/metric/MetricsHelper;->sMetricsCollector:Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_1

    .line 39
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0

    .line 56
    :cond_2
    :try_start_2
    sget-object v0, Lcom/amazon/identity/platform/metric/MetricsHelper;->TAG:Ljava/lang/String;

    .line 57
    new-instance v0, Lcom/amazon/identity/platform/metric/PlatformLoggingMetricsCollector;

    const/4 v2, 0x0

    invoke-direct {v0, v2}, Lcom/amazon/identity/platform/metric/PlatformLoggingMetricsCollector;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/platform/metric/MetricsHelper;->sMetricsCollector:Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_1
.end method

.method public static declared-synchronized getNewCollector(Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;
    .locals 3
    .param p0, "mApiName"    # Ljava/lang/String;

    .prologue
    .line 227
    const-class v1, Lcom/amazon/identity/platform/metric/MetricsHelper;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/amazon/identity/platform/metric/MetricsHelper;->sContext:Landroid/content/Context;

    if-eqz v0, :cond_0

    invoke-static {}, Lcom/amazon/identity/platform/metric/MetricsHelper;->supportClientMetrics()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 229
    sget-object v0, Lcom/amazon/identity/platform/metric/MetricsHelper;->TAG:Ljava/lang/String;

    .line 230
    new-instance v0, Lcom/amazon/identity/platform/metric/PlatformDCPMetricsCollector;

    sget-object v2, Lcom/amazon/identity/platform/metric/MetricsHelper;->sContext:Landroid/content/Context;

    invoke-direct {v0, v2, p0}, Lcom/amazon/identity/platform/metric/PlatformDCPMetricsCollector;-><init>(Landroid/content/Context;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 234
    :goto_0
    monitor-exit v1

    return-object v0

    .line 233
    :cond_0
    :try_start_1
    sget-object v0, Lcom/amazon/identity/platform/metric/MetricsHelper;->TAG:Ljava/lang/String;

    .line 234
    new-instance v0, Lcom/amazon/identity/platform/metric/PlatformLoggingMetricsCollector;

    const/4 v2, 0x0

    invoke-direct {v0, v2}, Lcom/amazon/identity/platform/metric/PlatformLoggingMetricsCollector;-><init>(Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 227
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public static getRegType(Lcom/amazon/identity/auth/device/api/RegistrationType;)Ljava/lang/String;
    .locals 1
    .param p0, "regType"    # Lcom/amazon/identity/auth/device/api/RegistrationType;

    .prologue
    .line 273
    if-nez p0, :cond_0

    const-string/jumbo v0, "NullRegType"

    :goto_0
    return-object v0

    :cond_0
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/api/RegistrationType;->name()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public static getTimer(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    .locals 3
    .param p0, "component"    # Ljava/lang/String;
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 71
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, "_"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 72
    .local v0, "timerName":Ljava/lang/String;
    sget-object v1, Lcom/amazon/identity/platform/metric/MetricsHelper;->sContext:Landroid/content/Context;

    invoke-static {v1}, Lcom/amazon/identity/platform/metric/MetricsHelper;->getMetricsCollectorInstance(Landroid/content/Context;)Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;

    move-result-object v1

    invoke-static {v1, v0}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->createPeriodicTimer(Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v1

    return-object v1
.end method

.method public static varargs increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V
    .locals 2
    .param p0, "counter"    # Ljava/lang/String;
    .param p1, "extraCounters"    # [Ljava/lang/String;

    .prologue
    .line 117
    sget-object v1, Lcom/amazon/identity/platform/metric/MetricsHelper;->sContext:Landroid/content/Context;

    invoke-static {v1}, Lcom/amazon/identity/platform/metric/MetricsHelper;->getMetricsCollectorInstance(Landroid/content/Context;)Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;

    move-result-object v0

    .line 119
    .local v0, "collector":Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;
    if-nez v0, :cond_0

    .line 125
    :goto_0
    return-void

    .line 124
    :cond_0
    invoke-interface {v0, p0, p1}, Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static init(Landroid/content/Context;)V
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 34
    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/platform/metric/MetricsHelper;->sContext:Landroid/content/Context;

    .line 35
    return-void
.end method

.method public static startTimer(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    .locals 4
    .param p0, "component"    # Ljava/lang/String;
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 83
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "_"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 84
    .local v1, "timerName":Ljava/lang/String;
    sget-object v2, Lcom/amazon/identity/platform/metric/MetricsHelper;->sContext:Landroid/content/Context;

    invoke-static {v2}, Lcom/amazon/identity/platform/metric/MetricsHelper;->getMetricsCollectorInstance(Landroid/content/Context;)Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;

    move-result-object v2

    invoke-static {v2, v1}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->createPeriodicTimer(Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v0

    .line 86
    .local v0, "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    invoke-virtual {v0}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->start()V

    .line 87
    return-object v0
.end method

.method public static startVerboseTimer(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    .locals 1
    .param p0, "component"    # Ljava/lang/String;
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 97
    sget-boolean v0, Lcom/amazon/identity/platform/metric/MetricsHelper;->VERBOSE_METRICS_ENABLED:Z

    if-eqz v0, :cond_0

    .line 99
    invoke-static {p0, p1}, Lcom/amazon/identity/platform/metric/MetricsHelper;->startTimer(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v0

    .line 103
    :goto_0
    return-object v0

    :cond_0
    sget-object v0, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->NULL_TIMER:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    goto :goto_0
.end method

.method public static supportClientMetrics()Z
    .locals 6

    .prologue
    const/4 v1, 0x0

    .line 240
    sget-object v0, Lcom/amazon/identity/platform/metric/MetricsHelper;->sSupportsDcpMetrics:Ljava/lang/Boolean;

    .line 241
    .local v0, "supportsDcpMetrics":Ljava/lang/Boolean;
    if-eqz v0, :cond_0

    .line 243
    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    .line 268
    :goto_0
    return v1

    .line 246
    :cond_0
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    .line 249
    :try_start_0
    const-string/jumbo v1, "com.amazon.client.metrics.AndroidMetricsFactoryImpl"

    invoke-static {v1}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    .line 250
    const-string/jumbo v1, "com.amazon.client.metrics.MetricsFactory"

    invoke-static {v1}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v1

    .line 254
    const-string/jumbo v2, "createConcurrentMetricEvent"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Class;

    const/4 v4, 0x0

    const-class v5, Ljava/lang/String;

    aput-object v5, v3, v4

    const/4 v4, 0x1

    const-class v5, Ljava/lang/String;

    aput-object v5, v3, v4

    invoke-virtual {v1, v2, v3}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    .line 256
    const/4 v1, 0x1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    .line 257
    sget-object v1, Lcom/amazon/identity/platform/metric/MetricsHelper;->TAG:Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/NoSuchMethodException; {:try_start_0 .. :try_end_0} :catch_1

    .line 267
    :goto_1
    sput-object v0, Lcom/amazon/identity/platform/metric/MetricsHelper;->sSupportsDcpMetrics:Ljava/lang/Boolean;

    .line 268
    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    goto :goto_0

    .line 261
    :catch_0
    move-exception v1

    sget-object v1, Lcom/amazon/identity/platform/metric/MetricsHelper;->TAG:Ljava/lang/String;

    goto :goto_1

    .line 265
    :catch_1
    move-exception v1

    sget-object v1, Lcom/amazon/identity/platform/metric/MetricsHelper;->TAG:Ljava/lang/String;

    goto :goto_1
.end method

.method public static wrapCallback(Lcom/amazon/identity/auth/device/framework/Tracer;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/Callback;
    .locals 1
    .param p0, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;
    .param p1, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;

    .prologue
    .line 222
    const/4 v0, 0x0

    invoke-static {p0, v0, p1}, Lcom/amazon/identity/platform/metric/MetricsHelper;->wrapCallback(Lcom/amazon/identity/auth/device/framework/Tracer;Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/Callback;

    move-result-object v0

    return-object v0
.end method

.method public static wrapCallback(Lcom/amazon/identity/auth/device/framework/Tracer;Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/Callback;
    .locals 1
    .param p0, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;
    .param p1, "timer"    # Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    .param p2, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;

    .prologue
    .line 178
    new-instance v0, Lcom/amazon/identity/platform/metric/MetricsHelper$2;

    invoke-direct {v0, p1, p0, p2}, Lcom/amazon/identity/platform/metric/MetricsHelper$2;-><init>(Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;Lcom/amazon/identity/auth/device/framework/Tracer;Lcom/amazon/identity/auth/device/api/Callback;)V

    return-object v0
.end method

.method public static wrapCallback(Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/Callback;
    .locals 1
    .param p0, "timer"    # Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    .param p1, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;

    .prologue
    .line 137
    new-instance v0, Lcom/amazon/identity/platform/metric/MetricsHelper$1;

    invoke-direct {v0, p0, p1}, Lcom/amazon/identity/platform/metric/MetricsHelper$1;-><init>(Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;Lcom/amazon/identity/auth/device/api/Callback;)V

    return-object v0
.end method

.method public static wrapRegistrationCallbackWithMetrics(Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;Ljava/lang/String;Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;)Lcom/amazon/identity/auth/device/api/Callback;
    .locals 1
    .param p0, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p1, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;
    .param p2, "errorCodeKey"    # Ljava/lang/String;
    .param p3, "defaultError"    # Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    .prologue
    .line 288
    new-instance v0, Lcom/amazon/identity/platform/metric/MetricsHelper$3;

    invoke-direct {v0, p1, p0, p2, p3}, Lcom/amazon/identity/platform/metric/MetricsHelper$3;-><init>(Lcom/amazon/identity/auth/device/framework/Tracer;Lcom/amazon/identity/auth/device/api/Callback;Ljava/lang/String;Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;)V

    return-object v0
.end method
