.class abstract Lcom/amazon/device/ads/AmazonOOUserIdentifier;
.super Lcom/amazon/device/ads/StartUpWaiter;
.source "AmazonOOUserIdentifier.java"


# static fields
.field private static final IU_SERVICE_CHECKIN_INTERVAL:I = 0x5265c00

.field private static final IU_SERVICE_LAST_CHECKIN_PREF_NAME:Ljava/lang/String; = "amzn-ad-iu-last-checkin"

.field private static serviceCallLock:Ljava/util/concurrent/locks/ReentrantLock;


# instance fields
.field private advertisingIdentifierInfo:Lcom/amazon/device/ads/AdvertisingIdentifier$Info;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 20
    new-instance v0, Ljava/util/concurrent/locks/ReentrantLock;

    invoke-direct {v0}, Ljava/util/concurrent/locks/ReentrantLock;-><init>()V

    sput-object v0, Lcom/amazon/device/ads/AmazonOOUserIdentifier;->serviceCallLock:Ljava/util/concurrent/locks/ReentrantLock;

    return-void
.end method

.method constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Lcom/amazon/device/ads/StartUpWaiter;-><init>()V

    return-void
.end method


# virtual methods
.method protected createAdvertisingIdentifierInfo()Lcom/amazon/device/ads/AdvertisingIdentifier$Info;
    .locals 2

    .prologue
    .line 75
    new-instance v0, Lcom/amazon/device/ads/AdvertisingIdentifier;

    invoke-direct {v0}, Lcom/amazon/device/ads/AdvertisingIdentifier;-><init>()V

    .line 76
    .local v0, "advertisingIdentifier":Lcom/amazon/device/ads/AdvertisingIdentifier;
    invoke-virtual {v0}, Lcom/amazon/device/ads/AdvertisingIdentifier;->getAdvertisingIdentifierInfo()Lcom/amazon/device/ads/AdvertisingIdentifier$Info;

    move-result-object v1

    return-object v1
.end method

.method public executeRequest()V
    .locals 0

    .prologue
    .line 26
    invoke-virtual {p0}, Lcom/amazon/device/ads/AmazonOOUserIdentifier;->start()V

    .line 27
    return-void
.end method

.method protected getAdvertisingIdentifierInfo()Lcom/amazon/device/ads/AdvertisingIdentifier$Info;
    .locals 1

    .prologue
    .line 80
    iget-object v0, p0, Lcom/amazon/device/ads/AmazonOOUserIdentifier;->advertisingIdentifierInfo:Lcom/amazon/device/ads/AdvertisingIdentifier$Info;

    return-object v0
.end method

.method protected abstract identifyUser()Z
.end method

.method protected final setParametersAndHost(Lcom/amazon/device/ads/WebRequest;)V
    .locals 5
    .param p1, "webRequest"    # Lcom/amazon/device/ads/WebRequest;

    .prologue
    .line 85
    invoke-static {}, Lcom/amazon/device/ads/InternalAdRegistration;->getInstance()Lcom/amazon/device/ads/IInternalAdRegistration;

    move-result-object v3

    invoke-interface {v3}, Lcom/amazon/device/ads/IInternalAdRegistration;->getRegistrationInfo()Lcom/amazon/device/ads/RegistrationInfo;

    move-result-object v2

    .line 86
    .local v2, "registrationInfo":Lcom/amazon/device/ads/RegistrationInfo;
    invoke-static {}, Lcom/amazon/device/ads/InternalAdRegistration;->getInstance()Lcom/amazon/device/ads/IInternalAdRegistration;

    move-result-object v3

    invoke-interface {v3}, Lcom/amazon/device/ads/IInternalAdRegistration;->getDeviceInfo()Lcom/amazon/device/ads/DeviceInfo;

    move-result-object v1

    .line 87
    .local v1, "deviceInfo":Lcom/amazon/device/ads/DeviceInfo;
    invoke-static {}, Lcom/amazon/device/ads/Configuration;->getInstance()Lcom/amazon/device/ads/Configuration;

    move-result-object v0

    .line 89
    .local v0, "configuration":Lcom/amazon/device/ads/Configuration;
    sget-object v3, Lcom/amazon/device/ads/Configuration$ConfigOption;->MADS_HOSTNAME:Lcom/amazon/device/ads/Configuration$ConfigOption;

    invoke-virtual {v0, v3}, Lcom/amazon/device/ads/Configuration;->getString(Lcom/amazon/device/ads/Configuration$ConfigOption;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1, v3}, Lcom/amazon/device/ads/WebRequest;->setHost(Ljava/lang/String;)V

    .line 90
    const-string/jumbo v3, "debug.madsUseSecure"

    const/4 v4, 0x1

    invoke-static {v3, v4}, Lcom/amazon/device/ads/DebugProperties;->getDebugPropertyAsBoolean(Ljava/lang/String;Z)Z

    move-result v3

    invoke-virtual {p1, v3}, Lcom/amazon/device/ads/WebRequest;->setUseSecure(Z)V

    .line 92
    const-string/jumbo v3, "dt"

    const-string/jumbo v4, "android"

    invoke-virtual {p1, v3, v4}, Lcom/amazon/device/ads/WebRequest;->putUrlEncodedQueryParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 93
    const-string/jumbo v3, "app"

    invoke-virtual {v2}, Lcom/amazon/device/ads/RegistrationInfo;->getAppName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p1, v3, v4}, Lcom/amazon/device/ads/WebRequest;->putUnencodedQueryParameter(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 94
    const-string/jumbo v3, "aud"

    sget-object v4, Lcom/amazon/device/ads/Configuration$ConfigOption;->SIS_DOMAIN:Lcom/amazon/device/ads/Configuration$ConfigOption;

    invoke-virtual {v0, v4}, Lcom/amazon/device/ads/Configuration;->getString(Lcom/amazon/device/ads/Configuration$ConfigOption;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p1, v3, v4}, Lcom/amazon/device/ads/WebRequest;->putUrlEncodedQueryParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 95
    const-string/jumbo v3, "appId"

    invoke-virtual {v2}, Lcom/amazon/device/ads/RegistrationInfo;->getAppKey()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p1, v3, v4}, Lcom/amazon/device/ads/WebRequest;->putUnencodedQueryParameter(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 96
    const-string/jumbo v3, "sdkVer"

    invoke-static {}, Lcom/amazon/device/ads/Version;->getSDKVersion()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p1, v3, v4}, Lcom/amazon/device/ads/WebRequest;->putUrlEncodedQueryParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 98
    invoke-virtual {p0}, Lcom/amazon/device/ads/AmazonOOUserIdentifier;->getAdvertisingIdentifierInfo()Lcom/amazon/device/ads/AdvertisingIdentifier$Info;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/device/ads/AdvertisingIdentifier$Info;->hasAdvertisingIdentifier()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 100
    const-string/jumbo v3, "idfa"

    iget-object v4, p0, Lcom/amazon/device/ads/AmazonOOUserIdentifier;->advertisingIdentifierInfo:Lcom/amazon/device/ads/AdvertisingIdentifier$Info;

    invoke-virtual {v4}, Lcom/amazon/device/ads/AdvertisingIdentifier$Info;->getAdvertisingIdentifier()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p1, v3, v4}, Lcom/amazon/device/ads/WebRequest;->putUrlEncodedQueryParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 101
    const-string/jumbo v3, "oo"

    iget-object v4, p0, Lcom/amazon/device/ads/AmazonOOUserIdentifier;->advertisingIdentifierInfo:Lcom/amazon/device/ads/AdvertisingIdentifier$Info;

    invoke-virtual {v4}, Lcom/amazon/device/ads/AdvertisingIdentifier$Info;->isLimitAdTrackingEnabled()Z

    move-result v4

    invoke-static {v4}, Ljava/lang/Boolean;->toString(Z)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p1, v3, v4}, Lcom/amazon/device/ads/WebRequest;->putUrlEncodedQueryParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 109
    :goto_0
    const-string/jumbo v3, "ua"

    invoke-static {}, Lcom/amazon/device/ads/DeviceInfo;->getUserAgentString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p1, v3, v4}, Lcom/amazon/device/ads/WebRequest;->putUnencodedQueryParameter(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 110
    const-string/jumbo v3, "di"

    invoke-static {}, Lcom/amazon/device/ads/SISDeviceRequest;->getDInfoProperty()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p1, v3, v4}, Lcom/amazon/device/ads/WebRequest;->putUnencodedQueryParameter(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 111
    return-void

    .line 105
    :cond_0
    const-string/jumbo v3, "sm"

    invoke-virtual {v1}, Lcom/amazon/device/ads/DeviceInfo;->getMacSha1()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p1, v3, v4}, Lcom/amazon/device/ads/WebRequest;->putUrlEncodedQueryParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 106
    const-string/jumbo v3, "su"

    invoke-virtual {v1}, Lcom/amazon/device/ads/DeviceInfo;->getUdidSha1()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p1, v3, v4}, Lcom/amazon/device/ads/WebRequest;->putUrlEncodedQueryParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 107
    const-string/jumbo v3, "ss"

    invoke-virtual {v1}, Lcom/amazon/device/ads/DeviceInfo;->getSerialSha1()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p1, v3, v4}, Lcom/amazon/device/ads/WebRequest;->putUrlEncodedQueryParameter(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method protected startUpFailed()V
    .locals 0

    .prologue
    .line 71
    return-void
.end method

.method protected startUpReady()V
    .locals 10

    .prologue
    .line 34
    sget-object v7, Lcom/amazon/device/ads/AmazonOOUserIdentifier;->serviceCallLock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v7}, Ljava/util/concurrent/locks/ReentrantLock;->lock()V

    .line 37
    :try_start_0
    invoke-virtual {p0}, Lcom/amazon/device/ads/AmazonOOUserIdentifier;->createAdvertisingIdentifierInfo()Lcom/amazon/device/ads/AdvertisingIdentifier$Info;

    move-result-object v7

    iput-object v7, p0, Lcom/amazon/device/ads/AmazonOOUserIdentifier;->advertisingIdentifierInfo:Lcom/amazon/device/ads/AdvertisingIdentifier$Info;

    .line 38
    iget-object v7, p0, Lcom/amazon/device/ads/AmazonOOUserIdentifier;->advertisingIdentifierInfo:Lcom/amazon/device/ads/AdvertisingIdentifier$Info;

    invoke-virtual {v7}, Lcom/amazon/device/ads/AdvertisingIdentifier$Info;->canDo()Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v7

    if-nez v7, :cond_0

    .line 65
    sget-object v7, Lcom/amazon/device/ads/AmazonOOUserIdentifier;->serviceCallLock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v7}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    .line 67
    :goto_0
    return-void

    .line 43
    :cond_0
    :try_start_1
    invoke-static {}, Lcom/amazon/device/ads/Settings;->getInstance()Lcom/amazon/device/ads/Settings;

    move-result-object v5

    .line 44
    .local v5, "settings":Lcom/amazon/device/ads/Settings;
    const-string/jumbo v7, "amzn-ad-iu-last-checkin"

    const-wide/16 v8, 0x0

    invoke-virtual {v5, v7, v8, v9}, Lcom/amazon/device/ads/Settings;->getLong(Ljava/lang/String;J)J

    move-result-wide v3

    .line 46
    .local v3, "lastCheckinTime":J
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    .line 47
    .local v1, "currentTime":J
    const-wide/32 v7, 0x5265c00

    add-long/2addr v7, v3

    cmp-long v7, v1, v7

    if-lez v7, :cond_2

    const/4 v6, 0x1

    .line 48
    .local v6, "shouldIdentifyUser":Z
    :goto_1
    const-string/jumbo v7, "debug.shouldIdentifyUser"

    invoke-static {v7, v6}, Lcom/amazon/device/ads/DebugProperties;->getDebugPropertyAsBoolean(Ljava/lang/String;Z)Z

    move-result v7

    if-eqz v7, :cond_1

    .line 52
    invoke-static {}, Lcom/amazon/device/ads/Configuration;->getInstance()Lcom/amazon/device/ads/Configuration;

    move-result-object v7

    sget-object v8, Lcom/amazon/device/ads/Configuration$ConfigOption;->MADS_HOSTNAME:Lcom/amazon/device/ads/Configuration$ConfigOption;

    invoke-virtual {v7, v8}, Lcom/amazon/device/ads/Configuration;->getString(Lcom/amazon/device/ads/Configuration$ConfigOption;)Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Lcom/amazon/device/ads/Utils;->isNullOrWhiteSpace(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_1

    .line 55
    invoke-virtual {p0}, Lcom/amazon/device/ads/AmazonOOUserIdentifier;->identifyUser()Z

    move-result v0

    .line 56
    .local v0, "callSuccessful":Z
    if-eqz v0, :cond_1

    .line 58
    const-string/jumbo v7, "amzn-ad-iu-last-checkin"

    invoke-virtual {v5, v7, v1, v2}, Lcom/amazon/device/ads/Settings;->putLong(Ljava/lang/String;J)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 65
    .end local v0    # "callSuccessful":Z
    :cond_1
    sget-object v7, Lcom/amazon/device/ads/AmazonOOUserIdentifier;->serviceCallLock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v7}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    goto :goto_0

    .line 47
    .end local v6    # "shouldIdentifyUser":Z
    :cond_2
    const/4 v6, 0x0

    goto :goto_1

    .line 65
    .end local v1    # "currentTime":J
    .end local v3    # "lastCheckinTime":J
    .end local v5    # "settings":Lcom/amazon/device/ads/Settings;
    :catchall_0
    move-exception v7

    sget-object v8, Lcom/amazon/device/ads/AmazonOOUserIdentifier;->serviceCallLock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v8}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    throw v7
.end method
