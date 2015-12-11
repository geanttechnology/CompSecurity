.class Lcom/amazon/device/ads/Configuration;
.super Ljava/lang/Object;
.source "Configuration.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/device/ads/Configuration$ConfigurationListener;,
        Lcom/amazon/device/ads/Configuration$ConfigOption;
    }
.end annotation


# static fields
.field private static final AAX_MSDK_CONFIG_ENDPOINT:Ljava/lang/String; = "/e/msdk/cfg"

.field private static final AAX_PROD_US_HOSTNAME:Ljava/lang/String; = "aax-us-east.amazon-adsystem.com"

.field protected static final CONFIG_APP_DEFINED_MARKETPLACE:Ljava/lang/String; = "config-appDefinedMarketplace"

.field protected static final CONFIG_LASTFETCHTIME:Ljava/lang/String; = "config-lastFetchTime"

.field protected static final CONFIG_TTL:Ljava/lang/String; = "config-ttl"

.field protected static final CONFIG_VERSION_NAME:Ljava/lang/String; = "configVersion"

.field protected static final CURRENT_CONFIG_VERSION:I = 0x1

.field private static final LOG_TAG:Ljava/lang/String;

.field protected static final MAX_CONFIG_TTL:I = 0x2a300

.field protected static final MAX_NO_RETRY_TTL:I = 0x493e0

.field protected static instance:Lcom/amazon/device/ads/Configuration;


# instance fields
.field private appDefinedMarketplace:Ljava/lang/String;

.field private isAppDefinedMarketplaceSet:Z

.field private isFetching:Ljava/util/concurrent/atomic/AtomicBoolean;

.field private isFirstParty:Z

.field private lastTestModeValue:Ljava/lang/Boolean;

.field private listeners:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/device/ads/Configuration$ConfigurationListener;",
            ">;"
        }
    .end annotation
.end field

.field private pfmRetriever:Lcom/amazon/device/ads/PreferredMarketplaceRetriever;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 26
    const-class v0, Lcom/amazon/device/ads/Configuration;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/device/ads/Configuration;->LOG_TAG:Ljava/lang/String;

    .line 39
    new-instance v0, Lcom/amazon/device/ads/Configuration;

    invoke-direct {v0}, Lcom/amazon/device/ads/Configuration;-><init>()V

    sput-object v0, Lcom/amazon/device/ads/Configuration;->instance:Lcom/amazon/device/ads/Configuration;

    return-void
.end method

.method protected constructor <init>()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    const/4 v0, 0x0

    .line 133
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 41
    iput-object v0, p0, Lcom/amazon/device/ads/Configuration;->appDefinedMarketplace:Ljava/lang/String;

    .line 42
    iput-boolean v2, p0, Lcom/amazon/device/ads/Configuration;->isAppDefinedMarketplaceSet:Z

    .line 43
    iput-object v0, p0, Lcom/amazon/device/ads/Configuration;->listeners:Ljava/util/List;

    .line 44
    iput-object v0, p0, Lcom/amazon/device/ads/Configuration;->isFetching:Ljava/util/concurrent/atomic/AtomicBoolean;

    .line 45
    iput-object v0, p0, Lcom/amazon/device/ads/Configuration;->lastTestModeValue:Ljava/lang/Boolean;

    .line 46
    iput-boolean v2, p0, Lcom/amazon/device/ads/Configuration;->isFirstParty:Z

    .line 47
    new-instance v0, Lcom/amazon/device/ads/PreferredMarketplaceRetriever$NullPreferredMarketplaceRetriever;

    invoke-direct {v0}, Lcom/amazon/device/ads/PreferredMarketplaceRetriever$NullPreferredMarketplaceRetriever;-><init>()V

    iput-object v0, p0, Lcom/amazon/device/ads/Configuration;->pfmRetriever:Lcom/amazon/device/ads/PreferredMarketplaceRetriever;

    .line 134
    new-instance v0, Ljava/util/ArrayList;

    const/4 v1, 0x5

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    iput-object v0, p0, Lcom/amazon/device/ads/Configuration;->listeners:Ljava/util/List;

    .line 135
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-direct {v0, v2}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V

    iput-object v0, p0, Lcom/amazon/device/ads/Configuration;->isFetching:Ljava/util/concurrent/atomic/AtomicBoolean;

    .line 136
    return-void
.end method

.method public static final getInstance()Lcom/amazon/device/ads/Configuration;
    .locals 1

    .prologue
    .line 144
    sget-object v0, Lcom/amazon/device/ads/Configuration;->instance:Lcom/amazon/device/ads/Configuration;

    return-object v0
.end method

.method public static getMaxNoRetryTtl()I
    .locals 2

    .prologue
    .line 228
    const-string/jumbo v0, "debug.noRetryTTLMax"

    const v1, 0x493e0

    invoke-static {v0, v1}, Lcom/amazon/device/ads/DebugProperties;->getDebugPropertyAsInteger(Ljava/lang/String;I)I

    move-result v0

    return v0
.end method

.method private getPreferredMarketplace()Ljava/lang/String;
    .locals 1

    .prologue
    .line 604
    iget-object v0, p0, Lcom/amazon/device/ads/Configuration;->pfmRetriever:Lcom/amazon/device/ads/PreferredMarketplaceRetriever;

    invoke-interface {v0}, Lcom/amazon/device/ads/PreferredMarketplaceRetriever;->retrievePreferredMarketplace()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private hasAppDefinedMarketplaceChanged()Z
    .locals 6

    .prologue
    .line 278
    invoke-static {}, Lcom/amazon/device/ads/Settings;->getInstance()Lcom/amazon/device/ads/Settings;

    move-result-object v1

    .line 279
    .local v1, "settings":Lcom/amazon/device/ads/Settings;
    const-string/jumbo v3, "config-appDefinedMarketplace"

    const/4 v4, 0x0

    invoke-virtual {v1, v3, v4}, Lcom/amazon/device/ads/Settings;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 280
    .local v2, "storedAppDefinedMarketplace":Ljava/lang/String;
    const/4 v0, 0x0

    .line 282
    .local v0, "appDefinedMarketplaceChanged":Z
    iget-boolean v3, p0, Lcom/amazon/device/ads/Configuration;->isAppDefinedMarketplaceSet:Z

    if-eqz v3, :cond_0

    .line 284
    const/4 v3, 0x0

    iput-boolean v3, p0, Lcom/amazon/device/ads/Configuration;->isAppDefinedMarketplaceSet:Z

    .line 286
    iget-object v3, p0, Lcom/amazon/device/ads/Configuration;->appDefinedMarketplace:Ljava/lang/String;

    if-eqz v3, :cond_1

    iget-object v3, p0, Lcom/amazon/device/ads/Configuration;->appDefinedMarketplace:Ljava/lang/String;

    invoke-virtual {v3, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 288
    const-string/jumbo v3, "config-lastFetchTime"

    const-wide/16 v4, 0x0

    invoke-virtual {v1, v3, v4, v5}, Lcom/amazon/device/ads/Settings;->putLongWithNoFlush(Ljava/lang/String;J)V

    .line 289
    const-string/jumbo v3, "config-appDefinedMarketplace"

    iget-object v4, p0, Lcom/amazon/device/ads/Configuration;->appDefinedMarketplace:Ljava/lang/String;

    invoke-virtual {v1, v3, v4}, Lcom/amazon/device/ads/Settings;->putStringWithNoFlush(Ljava/lang/String;Ljava/lang/String;)V

    .line 290
    invoke-virtual {v1}, Lcom/amazon/device/ads/Settings;->flush()V

    .line 293
    invoke-static {}, Lcom/amazon/device/ads/InternalAdRegistration;->getInstance()Lcom/amazon/device/ads/IInternalAdRegistration;

    move-result-object v3

    invoke-interface {v3}, Lcom/amazon/device/ads/IInternalAdRegistration;->getRegistrationInfo()Lcom/amazon/device/ads/RegistrationInfo;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/device/ads/RegistrationInfo;->requestNewSISDeviceIdentifier()V

    .line 294
    sget-object v3, Lcom/amazon/device/ads/Configuration;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v4, "New application-defined marketplace set. A new configuration will be retrieved."

    invoke-static {v3, v4}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 295
    const/4 v0, 0x1

    .line 307
    :cond_0
    :goto_0
    return v0

    .line 297
    :cond_1
    if-eqz v2, :cond_0

    iget-object v3, p0, Lcom/amazon/device/ads/Configuration;->appDefinedMarketplace:Ljava/lang/String;

    if-nez v3, :cond_0

    .line 299
    const-string/jumbo v3, "config-appDefinedMarketplace"

    invoke-virtual {v1, v3}, Lcom/amazon/device/ads/Settings;->remove(Ljava/lang/String;)V

    .line 302
    invoke-static {}, Lcom/amazon/device/ads/InternalAdRegistration;->getInstance()Lcom/amazon/device/ads/IInternalAdRegistration;

    move-result-object v3

    invoke-interface {v3}, Lcom/amazon/device/ads/IInternalAdRegistration;->getRegistrationInfo()Lcom/amazon/device/ads/RegistrationInfo;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/device/ads/RegistrationInfo;->requestNewSISDeviceIdentifier()V

    .line 303
    sget-object v3, Lcom/amazon/device/ads/Configuration;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v4, "Application-defined marketplace removed. A new configuration will be retrieved."

    invoke-static {v3, v4}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 304
    const/4 v0, 0x1

    goto :goto_0
.end method

.method private writeSettingFromConfigOption(Lcom/amazon/device/ads/Configuration$ConfigOption;Lorg/json/JSONObject;)V
    .locals 3
    .param p1, "configOption"    # Lcom/amazon/device/ads/Configuration$ConfigOption;
    .param p2, "json"    # Lorg/json/JSONObject;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 523
    invoke-virtual {p1}, Lcom/amazon/device/ads/Configuration$ConfigOption;->getDataType()Ljava/lang/Class;

    move-result-object v1

    const-class v2, Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 525
    invoke-virtual {p1}, Lcom/amazon/device/ads/Configuration$ConfigOption;->getResponseKey()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p2, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 526
    .local v0, "value":Ljava/lang/String;
    invoke-virtual {p1}, Lcom/amazon/device/ads/Configuration$ConfigOption;->getAllowEmpty()Z

    move-result v1

    if-nez v1, :cond_0

    invoke-static {v0}, Lcom/amazon/device/ads/Utils;->isNullOrWhiteSpace(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 528
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v2, "The configuration value must not be empty or contain only white spaces."

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 530
    :cond_0
    invoke-static {}, Lcom/amazon/device/ads/Settings;->getInstance()Lcom/amazon/device/ads/Settings;

    move-result-object v1

    invoke-virtual {p1}, Lcom/amazon/device/ads/Configuration$ConfigOption;->getSettingsName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2, v0}, Lcom/amazon/device/ads/Settings;->putStringWithNoFlush(Ljava/lang/String;Ljava/lang/String;)V

    .line 543
    .end local v0    # "value":Ljava/lang/String;
    :goto_0
    return-void

    .line 532
    :cond_1
    invoke-virtual {p1}, Lcom/amazon/device/ads/Configuration$ConfigOption;->getDataType()Ljava/lang/Class;

    move-result-object v1

    const-class v2, Ljava/lang/Boolean;

    invoke-virtual {v1, v2}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 534
    invoke-virtual {p1}, Lcom/amazon/device/ads/Configuration$ConfigOption;->getResponseKey()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p2, v1}, Lorg/json/JSONObject;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    .line 535
    .local v0, "value":Z
    invoke-static {}, Lcom/amazon/device/ads/Settings;->getInstance()Lcom/amazon/device/ads/Settings;

    move-result-object v1

    invoke-virtual {p1}, Lcom/amazon/device/ads/Configuration$ConfigOption;->getSettingsName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2, v0}, Lcom/amazon/device/ads/Settings;->putBooleanWithNoFlush(Ljava/lang/String;Z)V

    goto :goto_0

    .line 541
    .end local v0    # "value":Z
    :cond_2
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v2, "Undefined configuration option type."

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1
.end method


# virtual methods
.method protected beginFetch()V
    .locals 1

    .prologue
    .line 372
    new-instance v0, Lcom/amazon/device/ads/Configuration$1;

    invoke-direct {v0, p0}, Lcom/amazon/device/ads/Configuration$1;-><init>(Lcom/amazon/device/ads/Configuration;)V

    invoke-static {v0}, Lcom/amazon/device/ads/ThreadUtils;->executeRunnable(Ljava/lang/Runnable;)V

    .line 379
    return-void
.end method

.method createAdvertisingIdentifierInfo()Lcom/amazon/device/ads/AdvertisingIdentifier$Info;
    .locals 5

    .prologue
    const/4 v1, 0x0

    .line 582
    new-instance v2, Lcom/amazon/device/ads/AdvertisingIdentifier;

    invoke-direct {v2}, Lcom/amazon/device/ads/AdvertisingIdentifier;-><init>()V

    invoke-static {}, Lcom/amazon/device/ads/Settings;->getInstance()Lcom/amazon/device/ads/Settings;

    move-result-object v3

    const-string/jumbo v4, "configVersion"

    invoke-virtual {v3, v4, v1}, Lcom/amazon/device/ads/Settings;->getInt(Ljava/lang/String;I)I

    move-result v3

    if-eqz v3, :cond_0

    const/4 v1, 0x1

    :cond_0
    invoke-virtual {v2, v1}, Lcom/amazon/device/ads/AdvertisingIdentifier;->setShouldSetCurrentAdvertisingIdentifier(Z)Lcom/amazon/device/ads/AdvertisingIdentifier;

    move-result-object v0

    .line 584
    .local v0, "advertisingIdentifier":Lcom/amazon/device/ads/AdvertisingIdentifier;
    invoke-virtual {v0}, Lcom/amazon/device/ads/AdvertisingIdentifier;->getAdvertisingIdentifierInfo()Lcom/amazon/device/ads/AdvertisingIdentifier$Info;

    move-result-object v1

    return-object v1
.end method

.method protected createWebRequest(Lcom/amazon/device/ads/AdvertisingIdentifier$Info;)Lcom/amazon/device/ads/WebRequest;
    .locals 8
    .param p1, "advertisingIdentifierInfo"    # Lcom/amazon/device/ads/AdvertisingIdentifier$Info;

    .prologue
    const/4 v7, 0x0

    const/4 v6, 0x1

    .line 551
    invoke-static {}, Lcom/amazon/device/ads/WebRequest;->createJSONGetWebRequest()Lcom/amazon/device/ads/WebRequest;

    move-result-object v2

    .line 552
    .local v2, "request":Lcom/amazon/device/ads/WebRequest;
    sget-object v4, Lcom/amazon/device/ads/Configuration;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v4}, Lcom/amazon/device/ads/WebRequest;->setExternalLogTag(Ljava/lang/String;)V

    .line 553
    invoke-virtual {v2, v6}, Lcom/amazon/device/ads/WebRequest;->enableLogUrl(Z)V

    .line 554
    const-string/jumbo v4, "debug.aaxConfigHostname"

    const-string/jumbo v5, "aax-us-east.amazon-adsystem.com"

    invoke-static {v4, v5}, Lcom/amazon/device/ads/DebugProperties;->getDebugPropertyAsString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Lcom/amazon/device/ads/WebRequest;->setHost(Ljava/lang/String;)V

    .line 555
    const-string/jumbo v4, "/e/msdk/cfg"

    invoke-virtual {v2, v4}, Lcom/amazon/device/ads/WebRequest;->setPath(Ljava/lang/String;)V

    .line 556
    invoke-static {}, Lcom/amazon/device/ads/Metrics;->getInstance()Lcom/amazon/device/ads/Metrics;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/device/ads/Metrics;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v4

    invoke-virtual {v2, v4}, Lcom/amazon/device/ads/WebRequest;->setMetricsCollector(Lcom/amazon/device/ads/MetricsCollector;)V

    .line 557
    sget-object v4, Lcom/amazon/device/ads/Metrics$MetricType;->AAX_CONFIG_DOWNLOAD_LATENCY:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v2, v4}, Lcom/amazon/device/ads/WebRequest;->setServiceCallLatencyMetric(Lcom/amazon/device/ads/Metrics$MetricType;)V

    .line 559
    const-string/jumbo v4, "debug.aaxConfigUseSecure"

    invoke-static {v4, v6}, Lcom/amazon/device/ads/DebugProperties;->getDebugPropertyAsBoolean(Ljava/lang/String;Z)Z

    move-result v4

    invoke-virtual {v2, v4}, Lcom/amazon/device/ads/WebRequest;->setUseSecure(Z)V

    .line 561
    invoke-static {}, Lcom/amazon/device/ads/InternalAdRegistration;->getInstance()Lcom/amazon/device/ads/IInternalAdRegistration;

    move-result-object v4

    invoke-interface {v4}, Lcom/amazon/device/ads/IInternalAdRegistration;->getRegistrationInfo()Lcom/amazon/device/ads/RegistrationInfo;

    move-result-object v1

    .line 562
    .local v1, "registrationInfo":Lcom/amazon/device/ads/RegistrationInfo;
    invoke-static {}, Lcom/amazon/device/ads/InternalAdRegistration;->getInstance()Lcom/amazon/device/ads/IInternalAdRegistration;

    move-result-object v4

    invoke-interface {v4}, Lcom/amazon/device/ads/IInternalAdRegistration;->getDeviceInfo()Lcom/amazon/device/ads/DeviceInfo;

    move-result-object v0

    .line 563
    .local v0, "deviceInfo":Lcom/amazon/device/ads/DeviceInfo;
    const-string/jumbo v4, "appId"

    invoke-virtual {v1}, Lcom/amazon/device/ads/RegistrationInfo;->getAppKey()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v4, v5}, Lcom/amazon/device/ads/WebRequest;->putUnencodedQueryParameter(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 564
    const-string/jumbo v4, "dinfo"

    invoke-virtual {v0}, Lcom/amazon/device/ads/DeviceInfo;->getDInfoProperty()Lorg/json/JSONObject;

    move-result-object v5

    invoke-virtual {v5}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v4, v5}, Lcom/amazon/device/ads/WebRequest;->putUnencodedQueryParameter(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 565
    const-string/jumbo v4, "adId"

    invoke-virtual {p1}, Lcom/amazon/device/ads/AdvertisingIdentifier$Info;->getSISDeviceIdentifier()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v4, v5}, Lcom/amazon/device/ads/WebRequest;->putUnencodedQueryParameter(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 566
    const-string/jumbo v4, "sdkVer"

    invoke-static {}, Lcom/amazon/device/ads/Version;->getSDKVersion()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v4, v5}, Lcom/amazon/device/ads/WebRequest;->putUnencodedQueryParameter(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 567
    const-string/jumbo v4, "fp"

    iget-boolean v5, p0, Lcom/amazon/device/ads/Configuration;->isFirstParty:Z

    invoke-static {v5}, Ljava/lang/Boolean;->toString(Z)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v4, v5}, Lcom/amazon/device/ads/WebRequest;->putUnencodedQueryParameter(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 568
    const-string/jumbo v4, "mkt"

    invoke-static {}, Lcom/amazon/device/ads/Settings;->getInstance()Lcom/amazon/device/ads/Settings;

    move-result-object v5

    const-string/jumbo v6, "config-appDefinedMarketplace"

    invoke-virtual {v5, v6, v7}, Lcom/amazon/device/ads/Settings;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v4, v5}, Lcom/amazon/device/ads/WebRequest;->putUnencodedQueryParameter(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 569
    const-string/jumbo v4, "pfm"

    invoke-direct {p0}, Lcom/amazon/device/ads/Configuration;->getPreferredMarketplace()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v4, v5}, Lcom/amazon/device/ads/WebRequest;->putUnencodedQueryParameter(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 570
    invoke-static {}, Lcom/amazon/device/ads/Settings;->getInstance()Lcom/amazon/device/ads/Settings;

    move-result-object v4

    const-string/jumbo v5, "testingEnabled"

    const/4 v6, 0x0

    invoke-virtual {v4, v5, v6}, Lcom/amazon/device/ads/Settings;->getBoolean(Ljava/lang/String;Z)Z

    move-result v3

    .line 571
    .local v3, "testingEnabled":Z
    invoke-virtual {p0, v3}, Lcom/amazon/device/ads/Configuration;->setLastTestModeValue(Z)V

    .line 572
    if-eqz v3, :cond_0

    .line 574
    const-string/jumbo v4, "testMode"

    const-string/jumbo v5, "true"

    invoke-virtual {v2, v4, v5}, Lcom/amazon/device/ads/WebRequest;->putUnencodedQueryParameter(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 576
    :cond_0
    const-string/jumbo v4, "debug.aaxConfigParams"

    invoke-static {v4, v7}, Lcom/amazon/device/ads/DebugProperties;->getDebugPropertyAsString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Lcom/amazon/device/ads/WebRequest;->setAdditionalQueryParamsString(Ljava/lang/String;)V

    .line 577
    return-object v2
.end method

.method protected fetchConfigurationOnBackgroundThread()V
    .locals 18

    .prologue
    .line 430
    sget-object v13, Lcom/amazon/device/ads/Configuration;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v14, "In configuration fetcher background thread."

    invoke-static {v13, v14}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 431
    invoke-static {}, Lcom/amazon/device/ads/PermissionChecker;->getInstance()Lcom/amazon/device/ads/PermissionChecker;

    move-result-object v13

    invoke-static {}, Lcom/amazon/device/ads/InternalAdRegistration;->getInstance()Lcom/amazon/device/ads/IInternalAdRegistration;

    move-result-object v14

    invoke-interface {v14}, Lcom/amazon/device/ads/IInternalAdRegistration;->getApplicationContext()Landroid/content/Context;

    move-result-object v14

    sget-object v15, Lcom/amazon/device/ads/Configuration;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v13, v14, v15}, Lcom/amazon/device/ads/PermissionChecker;->passesInternetPermissionCheck(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v8

    .line 433
    .local v8, "passesInternetPermissionCheck":Z
    if-nez v8, :cond_0

    .line 435
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/device/ads/Configuration;->onFetchFailure()V

    .line 518
    :goto_0
    return-void

    .line 439
    :cond_0
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/device/ads/Configuration;->createAdvertisingIdentifierInfo()Lcom/amazon/device/ads/AdvertisingIdentifier$Info;

    move-result-object v1

    .line 440
    .local v1, "advertisingIdentifierInfo":Lcom/amazon/device/ads/AdvertisingIdentifier$Info;
    invoke-virtual {v1}, Lcom/amazon/device/ads/AdvertisingIdentifier$Info;->canDo()Z

    move-result v13

    if-nez v13, :cond_1

    .line 442
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/device/ads/Configuration;->onFetchFailure()V

    goto :goto_0

    .line 446
    :cond_1
    move-object/from16 v0, p0

    invoke-virtual {v0, v1}, Lcom/amazon/device/ads/Configuration;->createWebRequest(Lcom/amazon/device/ads/AdvertisingIdentifier$Info;)Lcom/amazon/device/ads/WebRequest;

    move-result-object v11

    .line 447
    .local v11, "webRequest":Lcom/amazon/device/ads/WebRequest;
    const/4 v12, 0x0

    .line 450
    .local v12, "webResponse":Lcom/amazon/device/ads/WebRequest$WebResponse;
    :try_start_0
    invoke-virtual {v11}, Lcom/amazon/device/ads/WebRequest;->makeCall()Lcom/amazon/device/ads/WebRequest$WebResponse;
    :try_end_0
    .catch Lcom/amazon/device/ads/WebRequest$WebRequestException; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v12

    .line 458
    sget-object v13, Lcom/amazon/device/ads/Configuration;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v14, "Response Body: %s"

    const/4 v15, 0x1

    new-array v15, v15, [Ljava/lang/Object;

    const/16 v16, 0x0

    invoke-virtual {v12}, Lcom/amazon/device/ads/WebRequest$WebResponse;->getBody()Ljava/lang/String;

    move-result-object v17

    aput-object v17, v15, v16

    invoke-static {v13, v14, v15}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 460
    invoke-virtual {v12}, Lcom/amazon/device/ads/WebRequest$WebResponse;->getJSONObjectBody()Lorg/json/JSONObject;

    move-result-object v6

    .line 461
    .local v6, "json":Lorg/json/JSONObject;
    invoke-static {}, Lcom/amazon/device/ads/Settings;->getInstance()Lcom/amazon/device/ads/Settings;

    move-result-object v9

    .line 463
    .local v9, "settings":Lcom/amazon/device/ads/Settings;
    const v10, 0x2a300

    .line 473
    .local v10, "ttl":I
    :try_start_1
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/device/ads/Configuration;->getConfigOptions()[Lcom/amazon/device/ads/Configuration$ConfigOption;

    move-result-object v2

    .local v2, "arr$":[Lcom/amazon/device/ads/Configuration$ConfigOption;
    array-length v7, v2

    .local v7, "len$":I
    const/4 v5, 0x0

    .local v5, "i$":I
    :goto_1
    if-ge v5, v7, :cond_4

    aget-object v3, v2, v5

    .line 475
    .local v3, "configOption":Lcom/amazon/device/ads/Configuration$ConfigOption;
    invoke-virtual {v3}, Lcom/amazon/device/ads/Configuration$ConfigOption;->getResponseKey()Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v6, v13}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v13

    if-eqz v13, :cond_3

    .line 477
    invoke-virtual {v3}, Lcom/amazon/device/ads/Configuration$ConfigOption;->getAllowEmpty()Z

    move-result v13

    if-nez v13, :cond_2

    .line 479
    new-instance v13, Ljava/lang/Exception;

    const-string/jumbo v14, "The configuration value must be present and not null."

    invoke-direct {v13, v14}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    throw v13
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_2

    .line 497
    .end local v2    # "arr$":[Lcom/amazon/device/ads/Configuration$ConfigOption;
    .end local v3    # "configOption":Lcom/amazon/device/ads/Configuration$ConfigOption;
    .end local v5    # "i$":I
    .end local v7    # "len$":I
    :catch_0
    move-exception v4

    .line 499
    .local v4, "e":Lorg/json/JSONException;
    sget-object v13, Lcom/amazon/device/ads/Configuration;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v14, "Unable to parse JSON response: %s"

    const/4 v15, 0x1

    new-array v15, v15, [Ljava/lang/Object;

    const/16 v16, 0x0

    invoke-virtual {v4}, Lorg/json/JSONException;->getMessage()Ljava/lang/String;

    move-result-object v17

    aput-object v17, v15, v16

    invoke-static {v13, v14, v15}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 500
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/device/ads/Configuration;->onFetchFailure()V

    goto :goto_0

    .line 452
    .end local v4    # "e":Lorg/json/JSONException;
    .end local v6    # "json":Lorg/json/JSONObject;
    .end local v9    # "settings":Lcom/amazon/device/ads/Settings;
    .end local v10    # "ttl":I
    :catch_1
    move-exception v4

    .line 454
    .local v4, "e":Lcom/amazon/device/ads/WebRequest$WebRequestException;
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/device/ads/Configuration;->onFetchFailure()V

    goto :goto_0

    .line 483
    .end local v4    # "e":Lcom/amazon/device/ads/WebRequest$WebRequestException;
    .restart local v2    # "arr$":[Lcom/amazon/device/ads/Configuration$ConfigOption;
    .restart local v3    # "configOption":Lcom/amazon/device/ads/Configuration$ConfigOption;
    .restart local v5    # "i$":I
    .restart local v6    # "json":Lorg/json/JSONObject;
    .restart local v7    # "len$":I
    .restart local v9    # "settings":Lcom/amazon/device/ads/Settings;
    .restart local v10    # "ttl":I
    :cond_2
    :try_start_2
    invoke-virtual {v3}, Lcom/amazon/device/ads/Configuration$ConfigOption;->getSettingsName()Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v9, v13}, Lcom/amazon/device/ads/Settings;->removeWithNoFlush(Ljava/lang/String;)V

    .line 473
    :goto_2
    add-int/lit8 v5, v5, 0x1

    goto :goto_1

    .line 488
    :cond_3
    move-object/from16 v0, p0

    invoke-direct {v0, v3, v6}, Lcom/amazon/device/ads/Configuration;->writeSettingFromConfigOption(Lcom/amazon/device/ads/Configuration$ConfigOption;Lorg/json/JSONObject;)V
    :try_end_2
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_0
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_2

    goto :goto_2

    .line 503
    .end local v2    # "arr$":[Lcom/amazon/device/ads/Configuration$ConfigOption;
    .end local v3    # "configOption":Lcom/amazon/device/ads/Configuration$ConfigOption;
    .end local v5    # "i$":I
    .end local v7    # "len$":I
    :catch_2
    move-exception v4

    .line 505
    .local v4, "e":Ljava/lang/Exception;
    sget-object v13, Lcom/amazon/device/ads/Configuration;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v14, "Unexpected error during parsing: %s"

    const/4 v15, 0x1

    new-array v15, v15, [Ljava/lang/Object;

    const/16 v16, 0x0

    invoke-virtual {v4}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v17

    aput-object v17, v15, v16

    invoke-static {v13, v14, v15}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 506
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/device/ads/Configuration;->onFetchFailure()V

    goto/16 :goto_0

    .line 491
    .end local v4    # "e":Ljava/lang/Exception;
    .restart local v2    # "arr$":[Lcom/amazon/device/ads/Configuration$ConfigOption;
    .restart local v5    # "i$":I
    .restart local v7    # "len$":I
    :cond_4
    :try_start_3
    const-string/jumbo v13, "ttl"

    invoke-virtual {v6, v13}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v13

    if-eqz v13, :cond_5

    .line 493
    new-instance v13, Ljava/lang/Exception;

    const-string/jumbo v14, "The configuration value must be present and not null."

    invoke-direct {v13, v14}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    throw v13

    .line 495
    :cond_5
    const-string/jumbo v13, "ttl"

    invoke-virtual {v6, v13}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I
    :try_end_3
    .catch Lorg/json/JSONException; {:try_start_3 .. :try_end_3} :catch_0
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_2

    move-result v10

    .line 510
    const v13, 0x2a300

    if-le v10, v13, :cond_6

    const v10, 0x2a300

    .line 511
    :cond_6
    const-string/jumbo v13, "config-ttl"

    invoke-virtual {v9, v13, v10}, Lcom/amazon/device/ads/Settings;->putIntWithNoFlush(Ljava/lang/String;I)V

    .line 512
    const-string/jumbo v13, "config-lastFetchTime"

    invoke-virtual/range {p0 .. p0}, Lcom/amazon/device/ads/Configuration;->nanoTime()J

    move-result-wide v14

    invoke-virtual {v9, v13, v14, v15}, Lcom/amazon/device/ads/Settings;->putLongWithNoFlush(Ljava/lang/String;J)V

    .line 513
    const-string/jumbo v13, "configVersion"

    const/4 v14, 0x1

    invoke-virtual {v9, v13, v14}, Lcom/amazon/device/ads/Settings;->putIntWithNoFlush(Ljava/lang/String;I)V

    .line 514
    invoke-virtual {v9}, Lcom/amazon/device/ads/Settings;->flush()V

    .line 516
    sget-object v13, Lcom/amazon/device/ads/Configuration;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v14, "Configuration fetched and saved."

    invoke-static {v13, v14}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 517
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/device/ads/Configuration;->onFetchSuccess()V

    goto/16 :goto_0
.end method

.method protected declared-synchronized getAndClearListeners()[Lcom/amazon/device/ads/Configuration$ConfigurationListener;
    .locals 2

    .prologue
    .line 412
    monitor-enter p0

    :try_start_0
    iget-object v1, p0, Lcom/amazon/device/ads/Configuration;->listeners:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    new-array v0, v1, [Lcom/amazon/device/ads/Configuration$ConfigurationListener;

    .line 413
    .local v0, "toCall":[Lcom/amazon/device/ads/Configuration$ConfigurationListener;
    iget-object v1, p0, Lcom/amazon/device/ads/Configuration;->listeners:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "toCall":[Lcom/amazon/device/ads/Configuration$ConfigurationListener;
    check-cast v0, [Lcom/amazon/device/ads/Configuration$ConfigurationListener;

    .line 414
    .restart local v0    # "toCall":[Lcom/amazon/device/ads/Configuration$ConfigurationListener;
    iget-object v1, p0, Lcom/amazon/device/ads/Configuration;->listeners:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->clear()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 415
    monitor-exit p0

    return-object v0

    .line 412
    .end local v0    # "toCall":[Lcom/amazon/device/ads/Configuration$ConfigurationListener;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public getAppDefinedMarketplace()Ljava/lang/String;
    .locals 1

    .prologue
    .line 154
    iget-object v0, p0, Lcom/amazon/device/ads/Configuration;->appDefinedMarketplace:Ljava/lang/String;

    return-object v0
.end method

.method public getBoolean(Lcom/amazon/device/ads/Configuration$ConfigOption;)Z
    .locals 1
    .param p1, "configOption"    # Lcom/amazon/device/ads/Configuration$ConfigOption;

    .prologue
    .line 202
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Lcom/amazon/device/ads/Configuration;->getBooleanWithDefault(Lcom/amazon/device/ads/Configuration$ConfigOption;Z)Z

    move-result v0

    return v0
.end method

.method public getBooleanWithDefault(Lcom/amazon/device/ads/Configuration$ConfigOption;Z)Z
    .locals 2
    .param p1, "configOption"    # Lcom/amazon/device/ads/Configuration$ConfigOption;
    .param p2, "defaultValue"    # Z

    .prologue
    .line 212
    invoke-virtual {p1}, Lcom/amazon/device/ads/Configuration$ConfigOption;->getDebugProperty()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/device/ads/DebugProperties;->containsDebugProperty(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 214
    invoke-virtual {p1}, Lcom/amazon/device/ads/Configuration$ConfigOption;->getDebugProperty()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, p2}, Lcom/amazon/device/ads/DebugProperties;->getDebugPropertyAsBoolean(Ljava/lang/String;Z)Z

    move-result v0

    .line 218
    :goto_0
    return v0

    :cond_0
    invoke-static {}, Lcom/amazon/device/ads/Settings;->getInstance()Lcom/amazon/device/ads/Settings;

    move-result-object v0

    invoke-virtual {p1}, Lcom/amazon/device/ads/Configuration$ConfigOption;->getSettingsName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1, p2}, Lcom/amazon/device/ads/Settings;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    goto :goto_0
.end method

.method protected getConfigOptions()[Lcom/amazon/device/ads/Configuration$ConfigOption;
    .locals 1

    .prologue
    .line 420
    sget-object v0, Lcom/amazon/device/ads/Configuration$ConfigOption;->configOptions:[Lcom/amazon/device/ads/Configuration$ConfigOption;

    return-object v0
.end method

.method getPreferredMarketplaceRetriever()Lcom/amazon/device/ads/PreferredMarketplaceRetriever;
    .locals 1

    .prologue
    .line 596
    iget-object v0, p0, Lcom/amazon/device/ads/Configuration;->pfmRetriever:Lcom/amazon/device/ads/PreferredMarketplaceRetriever;

    return-object v0
.end method

.method public getString(Lcom/amazon/device/ads/Configuration$ConfigOption;)Ljava/lang/String;
    .locals 4
    .param p1, "configOption"    # Lcom/amazon/device/ads/Configuration$ConfigOption;

    .prologue
    const/4 v3, 0x0

    .line 188
    invoke-virtual {p1}, Lcom/amazon/device/ads/Configuration$ConfigOption;->getDebugProperty()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, v3}, Lcom/amazon/device/ads/DebugProperties;->getDebugPropertyAsString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 189
    .local v0, "value":Ljava/lang/String;
    if-nez v0, :cond_0

    .line 191
    invoke-static {}, Lcom/amazon/device/ads/Settings;->getInstance()Lcom/amazon/device/ads/Settings;

    move-result-object v1

    invoke-virtual {p1}, Lcom/amazon/device/ads/Configuration$ConfigOption;->getSettingsName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2, v3}, Lcom/amazon/device/ads/Settings;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 193
    :cond_0
    return-object v0
.end method

.method protected isFetching()Z
    .locals 1

    .prologue
    .line 322
    iget-object v0, p0, Lcom/amazon/device/ads/Configuration;->isFetching:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    move-result v0

    return v0
.end method

.method isFirstParty()Z
    .locals 1

    .prologue
    .line 178
    iget-boolean v0, p0, Lcom/amazon/device/ads/Configuration;->isFirstParty:Z

    return v0
.end method

.method protected nanoTime()J
    .locals 2

    .prologue
    .line 317
    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v0

    return-wide v0
.end method

.method protected declared-synchronized onFetchFailure()V
    .locals 7

    .prologue
    .line 398
    monitor-enter p0

    :try_start_0
    invoke-static {}, Lcom/amazon/device/ads/Metrics;->getInstance()Lcom/amazon/device/ads/Metrics;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/device/ads/Metrics;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v5

    sget-object v6, Lcom/amazon/device/ads/Metrics$MetricType;->AAX_CONFIG_DOWNLOAD_FAILED:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v5, v6}, Lcom/amazon/device/ads/MetricsCollector;->incrementMetric(Lcom/amazon/device/ads/Metrics$MetricType;)V

    .line 399
    const/4 v5, 0x0

    invoke-virtual {p0, v5}, Lcom/amazon/device/ads/Configuration;->setIsFetching(Z)V

    .line 400
    invoke-virtual {p0}, Lcom/amazon/device/ads/Configuration;->getAndClearListeners()[Lcom/amazon/device/ads/Configuration$ConfigurationListener;

    move-result-object v4

    .line 401
    .local v4, "toCall":[Lcom/amazon/device/ads/Configuration$ConfigurationListener;
    move-object v0, v4

    .local v0, "arr$":[Lcom/amazon/device/ads/Configuration$ConfigurationListener;
    array-length v2, v0

    .local v2, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v2, :cond_0

    aget-object v3, v0, v1

    .line 403
    .local v3, "listener":Lcom/amazon/device/ads/Configuration$ConfigurationListener;
    invoke-interface {v3}, Lcom/amazon/device/ads/Configuration$ConfigurationListener;->onConfigurationFailure()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 401
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 405
    .end local v3    # "listener":Lcom/amazon/device/ads/Configuration$ConfigurationListener;
    :cond_0
    monitor-exit p0

    return-void

    .line 398
    .end local v0    # "arr$":[Lcom/amazon/device/ads/Configuration$ConfigurationListener;
    .end local v1    # "i$":I
    .end local v2    # "len$":I
    .end local v4    # "toCall":[Lcom/amazon/device/ads/Configuration$ConfigurationListener;
    :catchall_0
    move-exception v5

    monitor-exit p0

    throw v5
.end method

.method protected declared-synchronized onFetchSuccess()V
    .locals 6

    .prologue
    .line 386
    monitor-enter p0

    const/4 v5, 0x0

    :try_start_0
    invoke-virtual {p0, v5}, Lcom/amazon/device/ads/Configuration;->setIsFetching(Z)V

    .line 387
    invoke-virtual {p0}, Lcom/amazon/device/ads/Configuration;->getAndClearListeners()[Lcom/amazon/device/ads/Configuration$ConfigurationListener;

    move-result-object v4

    .line 388
    .local v4, "toCall":[Lcom/amazon/device/ads/Configuration$ConfigurationListener;
    move-object v0, v4

    .local v0, "arr$":[Lcom/amazon/device/ads/Configuration$ConfigurationListener;
    array-length v2, v0

    .local v2, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v2, :cond_0

    aget-object v3, v0, v1

    .line 390
    .local v3, "listener":Lcom/amazon/device/ads/Configuration$ConfigurationListener;
    invoke-interface {v3}, Lcom/amazon/device/ads/Configuration$ConfigurationListener;->onConfigurationReady()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 388
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 392
    .end local v3    # "listener":Lcom/amazon/device/ads/Configuration$ConfigurationListener;
    :cond_0
    monitor-exit p0

    return-void

    .line 386
    .end local v0    # "arr$":[Lcom/amazon/device/ads/Configuration$ConfigurationListener;
    .end local v1    # "i$":I
    .end local v2    # "len$":I
    .end local v4    # "toCall":[Lcom/amazon/device/ads/Configuration$ConfigurationListener;
    :catchall_0
    move-exception v5

    monitor-exit p0

    throw v5
.end method

.method public declared-synchronized queueConfigurationListener(Lcom/amazon/device/ads/Configuration$ConfigurationListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/device/ads/Configuration$ConfigurationListener;

    .prologue
    .line 337
    monitor-enter p0

    const/4 v0, 0x1

    :try_start_0
    invoke-virtual {p0, p1, v0}, Lcom/amazon/device/ads/Configuration;->queueConfigurationListener(Lcom/amazon/device/ads/Configuration$ConfigurationListener;Z)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 338
    monitor-exit p0

    return-void

    .line 337
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized queueConfigurationListener(Lcom/amazon/device/ads/Configuration$ConfigurationListener;Z)V
    .locals 2
    .param p1, "listener"    # Lcom/amazon/device/ads/Configuration$ConfigurationListener;
    .param p2, "allowFetch"    # Z

    .prologue
    .line 348
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lcom/amazon/device/ads/Configuration;->isFetching()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 351
    iget-object v0, p0, Lcom/amazon/device/ads/Configuration;->listeners:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 369
    :cond_0
    :goto_0
    monitor-exit p0

    return-void

    .line 353
    :cond_1
    :try_start_1
    invoke-virtual {p0}, Lcom/amazon/device/ads/Configuration;->shouldFetch()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 356
    iget-object v0, p0, Lcom/amazon/device/ads/Configuration;->listeners:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 358
    if-eqz p2, :cond_0

    .line 360
    sget-object v0, Lcom/amazon/device/ads/Configuration;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v1, "Starting configuration fetching..."

    invoke-static {v0, v1}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 361
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/amazon/device/ads/Configuration;->setIsFetching(Z)V

    .line 362
    invoke-virtual {p0}, Lcom/amazon/device/ads/Configuration;->beginFetch()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 348
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    .line 367
    :cond_2
    :try_start_2
    invoke-interface {p1}, Lcom/amazon/device/ads/Configuration$ConfigurationListener;->onConfigurationReady()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0
.end method

.method public setAppDefinedMarketplace(Ljava/lang/String;)V
    .locals 1
    .param p1, "appDefinedMarketplace"    # Ljava/lang/String;

    .prologue
    .line 163
    iput-object p1, p0, Lcom/amazon/device/ads/Configuration;->appDefinedMarketplace:Ljava/lang/String;

    .line 164
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/device/ads/Configuration;->isAppDefinedMarketplaceSet:Z

    .line 165
    return-void
.end method

.method protected setIsFetching(Z)V
    .locals 1
    .param p1, "isFetching"    # Z

    .prologue
    .line 326
    iget-object v0, p0, Lcom/amazon/device/ads/Configuration;->isFetching:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v0, p1}, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V

    .line 327
    return-void
.end method

.method public setIsFirstParty(Z)V
    .locals 0
    .param p1, "isFirstParty"    # Z

    .prologue
    .line 173
    iput-boolean p1, p0, Lcom/amazon/device/ads/Configuration;->isFirstParty:Z

    .line 174
    return-void
.end method

.method protected setLastTestModeValue(Z)V
    .locals 1
    .param p1, "testMode"    # Z

    .prologue
    .line 425
    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/device/ads/Configuration;->lastTestModeValue:Ljava/lang/Boolean;

    .line 426
    return-void
.end method

.method public setPreferredMarketplaceRetriever(Lcom/amazon/device/ads/PreferredMarketplaceRetriever;)V
    .locals 0
    .param p1, "pfmRetriever"    # Lcom/amazon/device/ads/PreferredMarketplaceRetriever;

    .prologue
    .line 592
    iput-object p1, p0, Lcom/amazon/device/ads/Configuration;->pfmRetriever:Lcom/amazon/device/ads/PreferredMarketplaceRetriever;

    .line 593
    return-void
.end method

.method protected shouldFetch()Z
    .locals 13

    .prologue
    const-wide/16 v11, 0x0

    const/4 v8, 0x0

    const/4 v7, 0x1

    .line 237
    invoke-static {}, Lcom/amazon/device/ads/Settings;->getInstance()Lcom/amazon/device/ads/Settings;

    move-result-object v4

    .line 238
    .local v4, "settings":Lcom/amazon/device/ads/Settings;
    invoke-direct {p0}, Lcom/amazon/device/ads/Configuration;->hasAppDefinedMarketplaceChanged()Z

    move-result v9

    if-eqz v9, :cond_1

    .line 273
    :cond_0
    :goto_0
    return v7

    .line 243
    :cond_1
    invoke-static {}, Lcom/amazon/device/ads/Settings;->getInstance()Lcom/amazon/device/ads/Settings;

    move-result-object v9

    const-string/jumbo v10, "configVersion"

    invoke-virtual {v9, v10, v8}, Lcom/amazon/device/ads/Settings;->getInt(Ljava/lang/String;I)I

    move-result v9

    if-ne v9, v7, :cond_0

    .line 248
    invoke-virtual {p0}, Lcom/amazon/device/ads/Configuration;->nanoTime()J

    move-result-wide v0

    .line 249
    .local v0, "currentTime":J
    const-string/jumbo v9, "config-lastFetchTime"

    invoke-virtual {v4, v9, v11, v12}, Lcom/amazon/device/ads/Settings;->getLong(Ljava/lang/String;J)J

    move-result-wide v2

    .line 250
    .local v2, "lastFetchTime":J
    const-string/jumbo v9, "config-ttl"

    const v10, 0x2a300

    invoke-virtual {v4, v9, v10}, Lcom/amazon/device/ads/Settings;->getInt(Ljava/lang/String;I)I

    move-result v9

    int-to-long v5, v9

    .line 252
    .local v5, "ttl":J
    cmp-long v9, v2, v11

    if-nez v9, :cond_2

    .line 254
    sget-object v8, Lcom/amazon/device/ads/Configuration;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v9, "No configuration found. A new configuration will be retrieved."

    invoke-static {v8, v9}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 257
    :cond_2
    sub-long v9, v0, v2

    invoke-static {v5, v6}, Lcom/amazon/device/ads/Utils;->convertToNsFromS(J)J

    move-result-wide v11

    cmp-long v9, v9, v11

    if-lez v9, :cond_3

    .line 259
    sget-object v8, Lcom/amazon/device/ads/Configuration;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v9, "The configuration has expired. A new configuration will be retrieved."

    invoke-static {v8, v9}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 262
    :cond_3
    iget-object v9, p0, Lcom/amazon/device/ads/Configuration;->lastTestModeValue:Ljava/lang/Boolean;

    if-eqz v9, :cond_4

    iget-object v9, p0, Lcom/amazon/device/ads/Configuration;->lastTestModeValue:Ljava/lang/Boolean;

    invoke-virtual {v9}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v9

    const-string/jumbo v10, "testingEnabled"

    invoke-virtual {v4, v10, v8}, Lcom/amazon/device/ads/Settings;->getBoolean(Ljava/lang/String;Z)Z

    move-result v10

    if-eq v9, v10, :cond_4

    .line 265
    sget-object v8, Lcom/amazon/device/ads/Configuration;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v9, "The testing mode has changed. A new configuration will be retrieved."

    invoke-static {v8, v9}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 269
    :cond_4
    const-string/jumbo v9, "debug.shouldFetchConfig"

    invoke-static {v9, v8}, Lcom/amazon/device/ads/DebugProperties;->getDebugPropertyAsBoolean(Ljava/lang/String;Z)Z

    move-result v9

    if-nez v9, :cond_0

    move v7, v8

    .line 273
    goto :goto_0
.end method
