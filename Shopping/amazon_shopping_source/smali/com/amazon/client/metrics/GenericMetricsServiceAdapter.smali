.class public Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;
.super Ljava/lang/Object;
.source "GenericMetricsServiceAdapter.java"


# static fields
.field private static final SHUTDOWN_TIMEOUT_MS:J = 0x1d4c0L

.field private static final THREAD_NAME:Ljava/lang/String; = "MetricsService"

.field private static final log:Lcom/amazon/dp/logger/DPLogger;

.field private static sGenericMetricsServiceAdapter:Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;

.field private static sMetricsConfiguration:Lcom/amazon/client/metrics/configuration/MetricsConfiguration;


# instance fields
.field private final mBinder:Lcom/amazon/client/metrics/IMetricsService;

.field private final mContext:Landroid/content/Context;

.field private final mDeviceUtil:Lcom/amazon/device/utils/CustomDeviceUtil;

.field private final mHandler:Landroid/os/Handler;

.field private final mMainThread:Landroid/os/HandlerThread;

.field private final mMetricsService:Lcom/amazon/client/metrics/MetricsService;

.field private final mMetricsServiceFactory:Lcom/amazon/client/metrics/BaseMetricsServiceFactory;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 39
    new-instance v0, Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v1, "MetricsServiceAdapter"

    invoke-direct {v0, v1}, Lcom/amazon/dp/logger/DPLogger;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;->log:Lcom/amazon/dp/logger/DPLogger;

    return-void
.end method

.method private constructor <init>(Landroid/content/Context;)V
    .locals 5
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 56
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 134
    new-instance v1, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter$2;

    invoke-direct {v1, p0}, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter$2;-><init>(Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;)V

    iput-object v1, p0, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;->mBinder:Lcom/amazon/client/metrics/IMetricsService;

    .line 57
    sget-object v1, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v2, "initialize"

    const-string/jumbo v3, "initialize(context) - Metrics service"

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Object;

    invoke-virtual {v1, v2, v3, v4}, Lcom/amazon/dp/logger/DPLogger;->debug(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 58
    iput-object p1, p0, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;->mContext:Landroid/content/Context;

    .line 59
    new-instance v1, Landroid/os/HandlerThread;

    const-string/jumbo v2, "MetricsService"

    invoke-direct {v1, v2}, Landroid/os/HandlerThread;-><init>(Ljava/lang/String;)V

    iput-object v1, p0, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;->mMainThread:Landroid/os/HandlerThread;

    .line 60
    iget-object v1, p0, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;->mMainThread:Landroid/os/HandlerThread;

    invoke-virtual {v1}, Landroid/os/HandlerThread;->start()V

    .line 61
    new-instance v1, Landroid/os/Handler;

    iget-object v2, p0, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;->mMainThread:Landroid/os/HandlerThread;

    invoke-virtual {v2}, Landroid/os/HandlerThread;->getLooper()Landroid/os/Looper;

    move-result-object v2

    new-instance v3, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter$1;

    invoke-direct {v3, p0}, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter$1;-><init>(Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;)V

    invoke-direct {v1, v2, v3}, Landroid/os/Handler;-><init>(Landroid/os/Looper;Landroid/os/Handler$Callback;)V

    iput-object v1, p0, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;->mHandler:Landroid/os/Handler;

    .line 69
    :try_start_0
    new-instance v1, Lcom/amazon/device/utils/CustomDeviceUtil;

    invoke-direct {v1, p1}, Lcom/amazon/device/utils/CustomDeviceUtil;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;->mDeviceUtil:Lcom/amazon/device/utils/CustomDeviceUtil;

    .line 70
    new-instance v1, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;

    iget-object v2, p0, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;->mDeviceUtil:Lcom/amazon/device/utils/CustomDeviceUtil;

    sget-object v3, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;->sMetricsConfiguration:Lcom/amazon/client/metrics/configuration/MetricsConfiguration;

    invoke-direct {v1, p1, v2, v3}, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;-><init>(Landroid/content/Context;Lcom/amazon/device/utils/DeviceUtil;Lcom/amazon/client/metrics/configuration/MetricsConfiguration;)V

    iput-object v1, p0, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;->mMetricsServiceFactory:Lcom/amazon/client/metrics/BaseMetricsServiceFactory;
    :try_end_0
    .catch Lcom/amazon/client/metrics/configuration/MetricsConfigurationException; {:try_start_0 .. :try_end_0} :catch_0

    .line 74
    iget-object v1, p0, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;->mMetricsServiceFactory:Lcom/amazon/client/metrics/BaseMetricsServiceFactory;

    invoke-virtual {v1}, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->createMetricsService()Lcom/amazon/client/metrics/MetricsService;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;->mMetricsService:Lcom/amazon/client/metrics/MetricsService;

    .line 75
    return-void

    .line 71
    :catch_0
    move-exception v0

    .line 72
    .local v0, "e":Lcom/amazon/client/metrics/configuration/MetricsConfigurationException;
    new-instance v1, Ljava/lang/RuntimeException;

    invoke-direct {v1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method static synthetic access$000()Lcom/amazon/dp/logger/DPLogger;
    .locals 1

    .prologue
    .line 31
    sget-object v0, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;->log:Lcom/amazon/dp/logger/DPLogger;

    return-object v0
.end method

.method public static getInstance(Landroid/content/Context;)Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 179
    sget-object v0, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;->sGenericMetricsServiceAdapter:Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;

    if-nez v0, :cond_0

    .line 180
    new-instance v0, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;

    invoke-direct {v0, p0}, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;-><init>(Landroid/content/Context;)V

    sput-object v0, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;->sGenericMetricsServiceAdapter:Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;

    .line 182
    :cond_0
    sget-object v0, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;->sGenericMetricsServiceAdapter:Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;

    return-object v0
.end method

.method public static setMetricsConfiguration(Lcom/amazon/client/metrics/configuration/MetricsConfiguration;)V
    .locals 0
    .param p0, "metricsConfiguration"    # Lcom/amazon/client/metrics/configuration/MetricsConfiguration;

    .prologue
    .line 244
    sput-object p0, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;->sMetricsConfiguration:Lcom/amazon/client/metrics/configuration/MetricsConfiguration;

    .line 245
    return-void
.end method

.method private shutdown()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 81
    iget-object v1, p0, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;->mMetricsServiceFactory:Lcom/amazon/client/metrics/BaseMetricsServiceFactory;

    invoke-virtual {v1}, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->shutdown()V

    .line 82
    iget-object v1, p0, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;->mMetricsService:Lcom/amazon/client/metrics/MetricsService;

    invoke-virtual {v1}, Lcom/amazon/client/metrics/MetricsService;->shutdown()V

    .line 83
    iget-object v1, p0, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;->mMainThread:Landroid/os/HandlerThread;

    if-nez v1, :cond_0

    .line 84
    sget-object v1, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v2, "shutdown"

    const-string/jumbo v3, "HandlerThread is null - nothing to do in shutdown."

    new-array v4, v4, [Ljava/lang/Object;

    invoke-virtual {v1, v2, v3, v4}, Lcom/amazon/dp/logger/DPLogger;->debug(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 96
    :goto_0
    return-void

    .line 88
    :cond_0
    iget-object v1, p0, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;->mMainThread:Landroid/os/HandlerThread;

    invoke-virtual {v1}, Landroid/os/HandlerThread;->quit()Z

    .line 91
    :try_start_0
    iget-object v1, p0, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;->mMainThread:Landroid/os/HandlerThread;

    const-wide/32 v2, 0x1d4c0

    invoke-virtual {v1, v2, v3}, Landroid/os/HandlerThread;->join(J)V

    .line 92
    sget-object v1, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v2, "shutdown"

    const-string/jumbo v3, "(super) Shutting down..."

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Object;

    invoke-virtual {v1, v2, v3, v4}, Lcom/amazon/dp/logger/DPLogger;->debug(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 93
    :catch_0
    move-exception v0

    .line 94
    .local v0, "e":Ljava/lang/InterruptedException;
    new-instance v1, Ljava/lang/RuntimeException;

    const-string/jumbo v2, "System service shutdown failed"

    invoke-direct {v1, v2, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
.end method

.method public static shutdownInstance()V
    .locals 1

    .prologue
    .line 169
    sget-object v0, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;->sGenericMetricsServiceAdapter:Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;

    if-eqz v0, :cond_0

    .line 170
    sget-object v0, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;->sGenericMetricsServiceAdapter:Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;

    invoke-direct {v0}, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;->shutdown()V

    .line 171
    const/4 v0, 0x0

    sput-object v0, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;->sGenericMetricsServiceAdapter:Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;

    .line 173
    :cond_0
    return-void
.end method


# virtual methods
.method protected getContext()Landroid/content/Context;
    .locals 1

    .prologue
    .line 106
    iget-object v0, p0, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;->mContext:Landroid/content/Context;

    return-object v0
.end method

.method public getHandler()Landroid/os/Handler;
    .locals 1

    .prologue
    .line 120
    iget-object v0, p0, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;->mHandler:Landroid/os/Handler;

    return-object v0
.end method

.method protected getMainThread()Landroid/os/HandlerThread;
    .locals 1

    .prologue
    .line 113
    iget-object v0, p0, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;->mMainThread:Landroid/os/HandlerThread;

    return-object v0
.end method

.method public getMetricsService()Lcom/amazon/client/metrics/IMetricsService;
    .locals 1

    .prologue
    .line 251
    sget-object v0, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;->sGenericMetricsServiceAdapter:Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;

    iget-object v0, v0, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;->mBinder:Lcom/amazon/client/metrics/IMetricsService;

    return-object v0
.end method

.method protected handleMessageForService(Landroid/os/Message;)Z
    .locals 7
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    const/4 v2, 0x0

    .line 124
    iget-object v3, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    if-eqz v3, :cond_0

    iget-object v3, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    instance-of v3, v3, Lcom/amazon/client/metrics/MetricEntry;

    if-eqz v3, :cond_0

    iget-object v3, p0, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;->mMetricsService:Lcom/amazon/client/metrics/MetricsService;

    if-eqz v3, :cond_0

    .line 125
    iget v2, p1, Landroid/os/Message;->arg1:I

    invoke-static {v2}, Lcom/amazon/client/metrics/Priority;->fromInt(I)Lcom/amazon/client/metrics/Priority;

    move-result-object v1

    .line 126
    .local v1, "priority":Lcom/amazon/client/metrics/Priority;
    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Lcom/amazon/client/metrics/MetricEntry;

    .line 127
    .local v0, "entry":Lcom/amazon/client/metrics/MetricEntry;
    iget-object v2, p0, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;->mMetricsService:Lcom/amazon/client/metrics/MetricsService;

    invoke-virtual {v2, v1, v0}, Lcom/amazon/client/metrics/MetricsService;->record(Lcom/amazon/client/metrics/Priority;Lcom/amazon/client/metrics/MetricEntry;)V

    .line 128
    const/4 v2, 0x1

    .line 131
    .end local v0    # "entry":Lcom/amazon/client/metrics/MetricEntry;
    .end local v1    # "priority":Lcom/amazon/client/metrics/Priority;
    :goto_0
    return v2

    .line 130
    :cond_0
    sget-object v3, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v4, "handleMessageForService"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "Received unknown android.os.Message "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    new-array v6, v2, [Ljava/lang/Object;

    invoke-virtual {v3, v4, v5, v6}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method

.method public onBind(Landroid/content/Intent;)Landroid/os/IBinder;
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 99
    iget-object v0, p0, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;->mBinder:Lcom/amazon/client/metrics/IMetricsService;

    invoke-interface {v0}, Lcom/amazon/client/metrics/IMetricsService;->asBinder()Landroid/os/IBinder;

    move-result-object v0

    return-object v0
.end method

.method public setCountryOfResidence(Ljava/lang/String;)V
    .locals 2
    .param p1, "countryOfResidence"    # Ljava/lang/String;

    .prologue
    .line 220
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 221
    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "countryOfResidence must not be null or empty"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 223
    :cond_1
    iget-object v0, p0, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;->mDeviceUtil:Lcom/amazon/device/utils/CustomDeviceUtil;

    invoke-virtual {v0, p1}, Lcom/amazon/device/utils/CustomDeviceUtil;->setCountryOfResidence(Ljava/lang/String;)V

    .line 224
    return-void
.end method

.method public setDeviceSerialNumber(Ljava/lang/String;)V
    .locals 2
    .param p1, "deviceId"    # Ljava/lang/String;

    .prologue
    .line 209
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 210
    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "deviceId must not be null or empty"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 212
    :cond_1
    iget-object v0, p0, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;->mDeviceUtil:Lcom/amazon/device/utils/CustomDeviceUtil;

    invoke-virtual {v0, p1}, Lcom/amazon/device/utils/CustomDeviceUtil;->setDeviceSerialNumber(Ljava/lang/String;)V

    .line 213
    return-void
.end method

.method public setDeviceType(Ljava/lang/String;)V
    .locals 2
    .param p1, "deviceType"    # Ljava/lang/String;

    .prologue
    .line 198
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 199
    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "deviceType must not be null or empty"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 201
    :cond_1
    iget-object v0, p0, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;->mDeviceUtil:Lcom/amazon/device/utils/CustomDeviceUtil;

    invoke-virtual {v0, p1}, Lcom/amazon/device/utils/CustomDeviceUtil;->setDeviceType(Ljava/lang/String;)V

    .line 202
    return-void
.end method

.method public setOAuthHelper(Lcom/amazon/client/metrics/transport/OAuthHelper;)V
    .locals 1
    .param p1, "oAuthHelper"    # Lcom/amazon/client/metrics/transport/OAuthHelper;

    .prologue
    .line 190
    iget-object v0, p0, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;->mMetricsServiceFactory:Lcom/amazon/client/metrics/BaseMetricsServiceFactory;

    invoke-virtual {v0, p1}, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->setOAuthHelper(Lcom/amazon/client/metrics/transport/OAuthHelper;)V

    .line 191
    return-void
.end method

.method public setPreferredMarketplace(Ljava/lang/String;)V
    .locals 2
    .param p1, "preferredMarketplace"    # Ljava/lang/String;

    .prologue
    .line 231
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 232
    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "preferredMarketplace must not be null or empty"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 234
    :cond_1
    iget-object v0, p0, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;->mDeviceUtil:Lcom/amazon/device/utils/CustomDeviceUtil;

    invoke-virtual {v0, p1}, Lcom/amazon/device/utils/CustomDeviceUtil;->setPreferredMarketplace(Ljava/lang/String;)V

    .line 235
    return-void
.end method
