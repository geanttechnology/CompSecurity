.class public Lcom/amazon/client/metrics/AndroidDeviceInfoManager;
.super Ljava/lang/Object;
.source "AndroidDeviceInfoManager.java"

# interfaces
.implements Lcom/amazon/client/metrics/DeviceInfoManager;


# static fields
.field private static final TAG:Ljava/lang/String; = "Metrics.AndroidDeviceInfoManager"

.field protected static final log:Lcom/amazon/dp/logger/DPLogger;


# instance fields
.field protected final mDeviceUtil:Lcom/amazon/device/utils/DeviceUtil;

.field protected final mMetricsDeviceInfo:Lcom/amazon/client/metrics/MetricsDeviceInfo;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 42
    new-instance v0, Lcom/amazon/dp/logger/DPLogger;

    invoke-direct {v0}, Lcom/amazon/dp/logger/DPLogger;-><init>()V

    sput-object v0, Lcom/amazon/client/metrics/AndroidDeviceInfoManager;->log:Lcom/amazon/dp/logger/DPLogger;

    return-void
.end method

.method public constructor <init>(Lcom/amazon/device/utils/DeviceUtil;)V
    .locals 7
    .param p1, "deviceUtil"    # Lcom/amazon/device/utils/DeviceUtil;

    .prologue
    .line 52
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 53
    if-nez p1, :cond_0

    .line 54
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "Device Util must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 56
    :cond_0
    iput-object p1, p0, Lcom/amazon/client/metrics/AndroidDeviceInfoManager;->mDeviceUtil:Lcom/amazon/device/utils/DeviceUtil;

    .line 58
    new-instance v0, Lcom/amazon/client/metrics/MetricsDeviceInfo;

    invoke-direct {v0}, Lcom/amazon/client/metrics/MetricsDeviceInfo;-><init>()V

    iput-object v0, p0, Lcom/amazon/client/metrics/AndroidDeviceInfoManager;->mMetricsDeviceInfo:Lcom/amazon/client/metrics/MetricsDeviceInfo;

    .line 59
    const-string/jumbo v0, "softwareVersion"

    sget-object v1, Landroid/os/Build$VERSION;->INCREMENTAL:Ljava/lang/String;

    invoke-direct {p0, v0, v1}, Lcom/amazon/client/metrics/AndroidDeviceInfoManager;->addToMetricsDeviceInfo(Ljava/lang/String;Ljava/lang/String;)V

    .line 60
    const-string/jumbo v0, "hardware"

    sget-object v1, Landroid/os/Build;->HARDWARE:Ljava/lang/String;

    invoke-direct {p0, v0, v1}, Lcom/amazon/client/metrics/AndroidDeviceInfoManager;->addToMetricsDeviceInfo(Ljava/lang/String;Ljava/lang/String;)V

    .line 61
    const-string/jumbo v0, "buildType"

    sget-object v1, Landroid/os/Build;->TYPE:Ljava/lang/String;

    invoke-direct {p0, v0, v1}, Lcom/amazon/client/metrics/AndroidDeviceInfoManager;->addToMetricsDeviceInfo(Ljava/lang/String;Ljava/lang/String;)V

    .line 62
    const-string/jumbo v0, "platform"

    sget-object v1, Landroid/os/Build;->DEVICE:Ljava/lang/String;

    invoke-direct {p0, v0, v1}, Lcom/amazon/client/metrics/AndroidDeviceInfoManager;->addToMetricsDeviceInfo(Ljava/lang/String;Ljava/lang/String;)V

    .line 63
    const-string/jumbo v0, "model"

    sget-object v1, Landroid/os/Build;->MODEL:Ljava/lang/String;

    invoke-direct {p0, v0, v1}, Lcom/amazon/client/metrics/AndroidDeviceInfoManager;->addToMetricsDeviceInfo(Ljava/lang/String;Ljava/lang/String;)V

    .line 65
    sget-object v0, Lcom/amazon/client/metrics/AndroidDeviceInfoManager;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v1, "Metrics.AndroidDeviceInfoManager"

    const-string/jumbo v2, "deviceInfo"

    const/16 v3, 0xa

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    const-string/jumbo v5, "softwareVersion"

    aput-object v5, v3, v4

    const/4 v4, 0x1

    iget-object v5, p0, Lcom/amazon/client/metrics/AndroidDeviceInfoManager;->mMetricsDeviceInfo:Lcom/amazon/client/metrics/MetricsDeviceInfo;

    const-string/jumbo v6, "softwareVersion"

    invoke-virtual {v5, v6}, Lcom/amazon/client/metrics/MetricsDeviceInfo;->getDeviceInfo(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x2

    const-string/jumbo v5, "hardware"

    aput-object v5, v3, v4

    const/4 v4, 0x3

    iget-object v5, p0, Lcom/amazon/client/metrics/AndroidDeviceInfoManager;->mMetricsDeviceInfo:Lcom/amazon/client/metrics/MetricsDeviceInfo;

    const-string/jumbo v6, "hardware"

    invoke-virtual {v5, v6}, Lcom/amazon/client/metrics/MetricsDeviceInfo;->getDeviceInfo(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x4

    const-string/jumbo v5, "buildType"

    aput-object v5, v3, v4

    const/4 v4, 0x5

    iget-object v5, p0, Lcom/amazon/client/metrics/AndroidDeviceInfoManager;->mMetricsDeviceInfo:Lcom/amazon/client/metrics/MetricsDeviceInfo;

    const-string/jumbo v6, "buildType"

    invoke-virtual {v5, v6}, Lcom/amazon/client/metrics/MetricsDeviceInfo;->getDeviceInfo(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x6

    const-string/jumbo v5, "platform"

    aput-object v5, v3, v4

    const/4 v4, 0x7

    iget-object v5, p0, Lcom/amazon/client/metrics/AndroidDeviceInfoManager;->mMetricsDeviceInfo:Lcom/amazon/client/metrics/MetricsDeviceInfo;

    const-string/jumbo v6, "platform"

    invoke-virtual {v5, v6}, Lcom/amazon/client/metrics/MetricsDeviceInfo;->getDeviceInfo(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    const/16 v4, 0x8

    const-string/jumbo v5, "model"

    aput-object v5, v3, v4

    const/16 v4, 0x9

    iget-object v5, p0, Lcom/amazon/client/metrics/AndroidDeviceInfoManager;->mMetricsDeviceInfo:Lcom/amazon/client/metrics/MetricsDeviceInfo;

    const-string/jumbo v6, "model"

    invoke-virtual {v5, v6}, Lcom/amazon/client/metrics/MetricsDeviceInfo;->getDeviceInfo(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-virtual {v0, v1, v2, v3}, Lcom/amazon/dp/logger/DPLogger;->verbose(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 71
    return-void
.end method

.method public constructor <init>(Lcom/amazon/device/utils/DeviceUtil;Ljava/util/Map;)V
    .locals 8
    .param p1, "deviceUtil"    # Lcom/amazon/device/utils/DeviceUtil;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/device/utils/DeviceUtil;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 81
    .local p2, "extraInfo":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-direct {p0, p1}, Lcom/amazon/client/metrics/AndroidDeviceInfoManager;-><init>(Lcom/amazon/device/utils/DeviceUtil;)V

    .line 82
    if-nez p2, :cond_0

    .line 83
    new-instance v2, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v3, "Extra info must not be null."

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 85
    :cond_0
    invoke-interface {p2}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 86
    .local v0, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-direct {p0, v2, v3}, Lcom/amazon/client/metrics/AndroidDeviceInfoManager;->addToMetricsDeviceInfo(Ljava/lang/String;Ljava/lang/String;)V

    .line 87
    sget-object v2, Lcom/amazon/client/metrics/AndroidDeviceInfoManager;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v3, "Metrics.AndroidDeviceInfoManager"

    const-string/jumbo v4, "extraInfo"

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v7

    aput-object v7, v5, v6

    const/4 v6, 0x1

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-virtual {v2, v3, v4, v5}, Lcom/amazon/dp/logger/DPLogger;->verbose(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0

    .line 89
    .end local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_1
    return-void
.end method

.method private addToMetricsDeviceInfo(Ljava/lang/String;Ljava/lang/String;)V
    .locals 4
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 92
    if-nez p1, :cond_0

    .line 93
    sget-object v0, Lcom/amazon/client/metrics/AndroidDeviceInfoManager;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v1, "Metrics.AndroidDeviceInfoManager"

    const-string/jumbo v2, "Not adding key-value to metrics device info as key is null"

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Object;

    invoke-virtual {v0, v1, v2, v3}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 98
    :goto_0
    return-void

    .line 97
    :cond_0
    iget-object v0, p0, Lcom/amazon/client/metrics/AndroidDeviceInfoManager;->mMetricsDeviceInfo:Lcom/amazon/client/metrics/MetricsDeviceInfo;

    invoke-virtual {v0, p1, p2}, Lcom/amazon/client/metrics/MetricsDeviceInfo;->addDeviceInfoData(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method private getCountryOfResidence()Ljava/lang/String;
    .locals 1

    .prologue
    .line 131
    iget-object v0, p0, Lcom/amazon/client/metrics/AndroidDeviceInfoManager;->mDeviceUtil:Lcom/amazon/device/utils/DeviceUtil;

    invoke-interface {v0}, Lcom/amazon/device/utils/DeviceUtil;->fetchCountryOfResidence()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private getDeviceLanguage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 139
    iget-object v0, p0, Lcom/amazon/client/metrics/AndroidDeviceInfoManager;->mDeviceUtil:Lcom/amazon/device/utils/DeviceUtil;

    invoke-interface {v0}, Lcom/amazon/device/utils/DeviceUtil;->fetchDeviceLanguage()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private getDeviceMode()Ljava/lang/String;
    .locals 1

    .prologue
    .line 143
    iget-object v0, p0, Lcom/amazon/client/metrics/AndroidDeviceInfoManager;->mDeviceUtil:Lcom/amazon/device/utils/DeviceUtil;

    invoke-interface {v0}, Lcom/amazon/device/utils/DeviceUtil;->fetchDeviceMode()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private getPreferredMarketplace()Ljava/lang/String;
    .locals 1

    .prologue
    .line 135
    iget-object v0, p0, Lcom/amazon/client/metrics/AndroidDeviceInfoManager;->mDeviceUtil:Lcom/amazon/device/utils/DeviceUtil;

    invoke-interface {v0}, Lcom/amazon/device/utils/DeviceUtil;->fetchPreferredMarketplace()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private getRsmGroup()Ljava/lang/String;
    .locals 1

    .prologue
    .line 181
    iget-object v0, p0, Lcom/amazon/client/metrics/AndroidDeviceInfoManager;->mDeviceUtil:Lcom/amazon/device/utils/DeviceUtil;

    invoke-interface {v0}, Lcom/amazon/device/utils/DeviceUtil;->fetchRsmGroupName()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public getCustomerID()Ljava/lang/String;
    .locals 1

    .prologue
    .line 161
    iget-object v0, p0, Lcom/amazon/client/metrics/AndroidDeviceInfoManager;->mDeviceUtil:Lcom/amazon/device/utils/DeviceUtil;

    invoke-interface {v0}, Lcom/amazon/device/utils/DeviceUtil;->fetchCustomerID()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getDeviceInfo()Lcom/amazon/client/metrics/MetricsDeviceInfo;
    .locals 2

    .prologue
    .line 107
    const-string/jumbo v0, "deviceId"

    invoke-virtual {p0}, Lcom/amazon/client/metrics/AndroidDeviceInfoManager;->getDeviceSerialNumber()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v0, v1}, Lcom/amazon/client/metrics/AndroidDeviceInfoManager;->addToMetricsDeviceInfo(Ljava/lang/String;Ljava/lang/String;)V

    .line 108
    const-string/jumbo v0, "deviceType"

    invoke-virtual {p0}, Lcom/amazon/client/metrics/AndroidDeviceInfoManager;->getDeviceType()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v0, v1}, Lcom/amazon/client/metrics/AndroidDeviceInfoManager;->addToMetricsDeviceInfo(Ljava/lang/String;Ljava/lang/String;)V

    .line 109
    const-string/jumbo v0, "countryOfResidence"

    invoke-direct {p0}, Lcom/amazon/client/metrics/AndroidDeviceInfoManager;->getCountryOfResidence()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v0, v1}, Lcom/amazon/client/metrics/AndroidDeviceInfoManager;->addToMetricsDeviceInfo(Ljava/lang/String;Ljava/lang/String;)V

    .line 110
    const-string/jumbo v0, "MarketplaceID"

    invoke-direct {p0}, Lcom/amazon/client/metrics/AndroidDeviceInfoManager;->getPreferredMarketplace()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v0, v1}, Lcom/amazon/client/metrics/AndroidDeviceInfoManager;->addToMetricsDeviceInfo(Ljava/lang/String;Ljava/lang/String;)V

    .line 111
    const-string/jumbo v0, "deviceLanguage"

    invoke-direct {p0}, Lcom/amazon/client/metrics/AndroidDeviceInfoManager;->getDeviceLanguage()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v0, v1}, Lcom/amazon/client/metrics/AndroidDeviceInfoManager;->addToMetricsDeviceInfo(Ljava/lang/String;Ljava/lang/String;)V

    .line 112
    const-string/jumbo v0, "deviceMode"

    invoke-direct {p0}, Lcom/amazon/client/metrics/AndroidDeviceInfoManager;->getDeviceMode()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v0, v1}, Lcom/amazon/client/metrics/AndroidDeviceInfoManager;->addToMetricsDeviceInfo(Ljava/lang/String;Ljava/lang/String;)V

    .line 113
    const-string/jumbo v0, "remoteSettingsGroup"

    invoke-direct {p0}, Lcom/amazon/client/metrics/AndroidDeviceInfoManager;->getRsmGroup()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v0, v1}, Lcom/amazon/client/metrics/AndroidDeviceInfoManager;->addToMetricsDeviceInfo(Ljava/lang/String;Ljava/lang/String;)V

    .line 115
    const-string/jumbo v0, "Session"

    invoke-virtual {p0}, Lcom/amazon/client/metrics/AndroidDeviceInfoManager;->getSessionID()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v0, v1}, Lcom/amazon/client/metrics/AndroidDeviceInfoManager;->addToMetricsDeviceInfo(Ljava/lang/String;Ljava/lang/String;)V

    .line 116
    const-string/jumbo v0, "CustomerId"

    invoke-virtual {p0}, Lcom/amazon/client/metrics/AndroidDeviceInfoManager;->getCustomerID()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v0, v1}, Lcom/amazon/client/metrics/AndroidDeviceInfoManager;->addToMetricsDeviceInfo(Ljava/lang/String;Ljava/lang/String;)V

    .line 117
    const-string/jumbo v0, "HTTP_USER_AGENT"

    invoke-virtual {p0}, Lcom/amazon/client/metrics/AndroidDeviceInfoManager;->getUserAgent()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v0, v1}, Lcom/amazon/client/metrics/AndroidDeviceInfoManager;->addToMetricsDeviceInfo(Ljava/lang/String;Ljava/lang/String;)V

    .line 118
    const-string/jumbo v0, "REMOTE_ADDR"

    invoke-virtual {p0}, Lcom/amazon/client/metrics/AndroidDeviceInfoManager;->getIPAddress()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v0, v1}, Lcom/amazon/client/metrics/AndroidDeviceInfoManager;->addToMetricsDeviceInfo(Ljava/lang/String;Ljava/lang/String;)V

    .line 119
    iget-object v0, p0, Lcom/amazon/client/metrics/AndroidDeviceInfoManager;->mMetricsDeviceInfo:Lcom/amazon/client/metrics/MetricsDeviceInfo;

    return-object v0
.end method

.method protected getDeviceSerialNumber()Ljava/lang/String;
    .locals 1

    .prologue
    .line 123
    iget-object v0, p0, Lcom/amazon/client/metrics/AndroidDeviceInfoManager;->mDeviceUtil:Lcom/amazon/device/utils/DeviceUtil;

    invoke-interface {v0}, Lcom/amazon/device/utils/DeviceUtil;->fetchDeviceSerialNumberOrAnonymous()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected getDeviceType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 127
    iget-object v0, p0, Lcom/amazon/client/metrics/AndroidDeviceInfoManager;->mDeviceUtil:Lcom/amazon/device/utils/DeviceUtil;

    invoke-interface {v0}, Lcom/amazon/device/utils/DeviceUtil;->fetchDeviceType()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getIPAddress()Ljava/lang/String;
    .locals 1

    .prologue
    .line 177
    iget-object v0, p0, Lcom/amazon/client/metrics/AndroidDeviceInfoManager;->mDeviceUtil:Lcom/amazon/device/utils/DeviceUtil;

    invoke-interface {v0}, Lcom/amazon/device/utils/DeviceUtil;->fetchRemoteIP()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getSessionID()Ljava/lang/String;
    .locals 1

    .prologue
    .line 153
    iget-object v0, p0, Lcom/amazon/client/metrics/AndroidDeviceInfoManager;->mDeviceUtil:Lcom/amazon/device/utils/DeviceUtil;

    invoke-interface {v0}, Lcom/amazon/device/utils/DeviceUtil;->fetchSessionID()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getUserAgent()Ljava/lang/String;
    .locals 1

    .prologue
    .line 169
    iget-object v0, p0, Lcom/amazon/client/metrics/AndroidDeviceInfoManager;->mDeviceUtil:Lcom/amazon/device/utils/DeviceUtil;

    invoke-interface {v0}, Lcom/amazon/device/utils/DeviceUtil;->fetchUserAgent()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
