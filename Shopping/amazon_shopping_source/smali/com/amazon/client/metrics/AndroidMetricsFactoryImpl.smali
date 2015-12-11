.class public Lcom/amazon/client/metrics/AndroidMetricsFactoryImpl;
.super Lcom/amazon/client/metrics/AbstractMetricsFactoryImpl;
.source "AndroidMetricsFactoryImpl.java"


# instance fields
.field private final mContext:Landroid/content/Context;


# direct methods
.method private constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 131
    invoke-direct {p0}, Lcom/amazon/client/metrics/AbstractMetricsFactoryImpl;-><init>()V

    .line 132
    iput-object p1, p0, Lcom/amazon/client/metrics/AndroidMetricsFactoryImpl;->mContext:Landroid/content/Context;

    .line 133
    return-void
.end method

.method public static declared-synchronized getInstance(Landroid/content/Context;)Lcom/amazon/client/metrics/MetricsFactory;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 116
    const-class v1, Lcom/amazon/client/metrics/AndroidMetricsFactoryImpl;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/amazon/client/metrics/AndroidMetricsFactoryImpl;->sMetricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

    if-nez v0, :cond_0

    .line 117
    new-instance v0, Lcom/amazon/client/metrics/AndroidMetricsFactoryImpl;

    invoke-direct {v0, p0}, Lcom/amazon/client/metrics/AndroidMetricsFactoryImpl;-><init>(Landroid/content/Context;)V

    sput-object v0, Lcom/amazon/client/metrics/AndroidMetricsFactoryImpl;->sMetricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

    .line 119
    :cond_0
    sget-object v0, Lcom/amazon/client/metrics/AndroidMetricsFactoryImpl;->sMetricsFactory:Lcom/amazon/client/metrics/MetricsFactory;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 116
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public static declared-synchronized setCountryOfResidence(Landroid/content/Context;Ljava/lang/String;)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "countryOfResidence"    # Ljava/lang/String;

    .prologue
    .line 57
    const-class v1, Lcom/amazon/client/metrics/AndroidMetricsFactoryImpl;

    monitor-enter v1

    :try_start_0
    invoke-static {p0}, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;->getInstance(Landroid/content/Context;)Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;->setCountryOfResidence(Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 58
    monitor-exit v1

    return-void

    .line 57
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public static declared-synchronized setDeviceId(Landroid/content/Context;Ljava/lang/String;)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "deviceId"    # Ljava/lang/String;

    .prologue
    .line 48
    const-class v1, Lcom/amazon/client/metrics/AndroidMetricsFactoryImpl;

    monitor-enter v1

    :try_start_0
    invoke-static {p0}, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;->getInstance(Landroid/content/Context;)Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;->setDeviceSerialNumber(Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 49
    monitor-exit v1

    return-void

    .line 48
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public static declared-synchronized setDeviceType(Landroid/content/Context;Ljava/lang/String;)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "deviceType"    # Ljava/lang/String;

    .prologue
    .line 39
    const-class v1, Lcom/amazon/client/metrics/AndroidMetricsFactoryImpl;

    monitor-enter v1

    :try_start_0
    invoke-static {p0}, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;->getInstance(Landroid/content/Context;)Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;->setDeviceType(Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 40
    monitor-exit v1

    return-void

    .line 39
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public static declared-synchronized setMetricsConfiguration(Lcom/amazon/client/metrics/configuration/MetricsConfiguration;)V
    .locals 2
    .param p0, "metricsConfiguration"    # Lcom/amazon/client/metrics/configuration/MetricsConfiguration;

    .prologue
    .line 106
    const-class v0, Lcom/amazon/client/metrics/AndroidMetricsFactoryImpl;

    monitor-enter v0

    :try_start_0
    invoke-static {p0}, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;->setMetricsConfiguration(Lcom/amazon/client/metrics/configuration/MetricsConfiguration;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 107
    monitor-exit v0

    return-void

    .line 106
    :catchall_0
    move-exception v1

    monitor-exit v0

    throw v1
.end method

.method public static declared-synchronized setOAuthHelper(Landroid/content/Context;Lcom/amazon/client/metrics/transport/OAuthHelper;)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "oAuthHelper"    # Lcom/amazon/client/metrics/transport/OAuthHelper;

    .prologue
    .line 75
    const-class v1, Lcom/amazon/client/metrics/AndroidMetricsFactoryImpl;

    monitor-enter v1

    :try_start_0
    invoke-static {p0}, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;->getInstance(Landroid/content/Context;)Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;->setOAuthHelper(Lcom/amazon/client/metrics/transport/OAuthHelper;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 76
    monitor-exit v1

    return-void

    .line 75
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public static declared-synchronized setPreferredMarketplace(Landroid/content/Context;Ljava/lang/String;)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "preferredMarketplace"    # Ljava/lang/String;

    .prologue
    .line 66
    const-class v1, Lcom/amazon/client/metrics/AndroidMetricsFactoryImpl;

    monitor-enter v1

    :try_start_0
    invoke-static {p0}, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;->getInstance(Landroid/content/Context;)Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;->setPreferredMarketplace(Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 67
    monitor-exit v1

    return-void

    .line 66
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public static declared-synchronized shutdown()V
    .locals 2

    .prologue
    .line 83
    const-class v1, Lcom/amazon/client/metrics/AndroidMetricsFactoryImpl;

    monitor-enter v1

    :try_start_0
    invoke-static {}, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;->shutdownInstance()V

    .line 84
    const/4 v0, 0x0

    sput-object v0, Lcom/amazon/client/metrics/AndroidMetricsFactoryImpl;->sMetricsService:Lcom/amazon/client/metrics/IMetricsService;

    .line 85
    const/4 v0, 0x0

    sput-object v0, Lcom/amazon/client/metrics/AndroidMetricsFactoryImpl;->sMetricsFactory:Lcom/amazon/client/metrics/MetricsFactory;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 86
    monitor-exit v1

    return-void

    .line 83
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public static declared-synchronized shutdown(Landroid/content/Context;)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 94
    const-class v0, Lcom/amazon/client/metrics/AndroidMetricsFactoryImpl;

    monitor-enter v0

    :try_start_0
    invoke-static {}, Lcom/amazon/client/metrics/AndroidMetricsFactoryImpl;->shutdown()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 95
    monitor-exit v0

    return-void

    .line 94
    :catchall_0
    move-exception v1

    monitor-exit v0

    throw v1
.end method


# virtual methods
.method protected getService()Lcom/amazon/client/metrics/IMetricsService;
    .locals 1

    .prologue
    .line 124
    sget-object v0, Lcom/amazon/client/metrics/AndroidMetricsFactoryImpl;->sMetricsService:Lcom/amazon/client/metrics/IMetricsService;

    if-nez v0, :cond_0

    .line 125
    iget-object v0, p0, Lcom/amazon/client/metrics/AndroidMetricsFactoryImpl;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;->getInstance(Landroid/content/Context;)Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;->getMetricsService()Lcom/amazon/client/metrics/IMetricsService;

    move-result-object v0

    sput-object v0, Lcom/amazon/client/metrics/AndroidMetricsFactoryImpl;->sMetricsService:Lcom/amazon/client/metrics/IMetricsService;

    .line 127
    :cond_0
    sget-object v0, Lcom/amazon/client/metrics/AndroidMetricsFactoryImpl;->sMetricsService:Lcom/amazon/client/metrics/IMetricsService;

    return-object v0
.end method

.method public getSessionID()Ljava/lang/String;
    .locals 1

    .prologue
    .line 151
    const-string/jumbo v0, ""

    return-object v0
.end method

.method protected shouldRecordMetrics()Z
    .locals 1

    .prologue
    .line 144
    const/4 v0, 0x1

    return v0
.end method
