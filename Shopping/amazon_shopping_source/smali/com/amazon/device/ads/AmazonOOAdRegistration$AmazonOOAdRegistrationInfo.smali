.class public Lcom/amazon/device/ads/AmazonOOAdRegistration$AmazonOOAdRegistrationInfo;
.super Ljava/lang/Object;
.source "AmazonOOAdRegistration.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/device/ads/AmazonOOAdRegistration;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AmazonOOAdRegistrationInfo"
.end annotation


# instance fields
.field private final advertisingIdentifierInfo:Lcom/amazon/device/ads/AdvertisingIdentifier$Info;


# direct methods
.method private constructor <init>()V
    .locals 2

    .prologue
    .line 486
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 487
    new-instance v0, Lcom/amazon/device/ads/AdvertisingIdentifier;

    invoke-direct {v0}, Lcom/amazon/device/ads/AdvertisingIdentifier;-><init>()V

    .line 488
    .local v0, "advertisingIdentifier":Lcom/amazon/device/ads/AdvertisingIdentifier;
    invoke-virtual {v0}, Lcom/amazon/device/ads/AdvertisingIdentifier;->getAdvertisingIdentifierInfo()Lcom/amazon/device/ads/AdvertisingIdentifier$Info;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/device/ads/AmazonOOAdRegistration$AmazonOOAdRegistrationInfo;->advertisingIdentifierInfo:Lcom/amazon/device/ads/AdvertisingIdentifier$Info;

    .line 489
    return-void
.end method

.method protected static getAmazonOOAdRegistrationInfo()Lcom/amazon/device/ads/AmazonOOAdRegistration$AmazonOOAdRegistrationInfo;
    .locals 1

    .prologue
    .line 493
    new-instance v0, Lcom/amazon/device/ads/AmazonOOAdRegistration$AmazonOOAdRegistrationInfo;

    invoke-direct {v0}, Lcom/amazon/device/ads/AmazonOOAdRegistration$AmazonOOAdRegistrationInfo;-><init>()V

    return-object v0
.end method

.method private getLastIdentifyUserWithSISTime()J
    .locals 4

    .prologue
    const-wide/16 v2, 0x0

    .line 568
    sget-wide v0, Lcom/amazon/device/ads/AmazonOOAdRegistration;->sLastIdentifyUserWithSisTime:J

    cmp-long v0, v0, v2

    if-gtz v0, :cond_0

    .line 570
    invoke-static {}, Lcom/amazon/device/ads/Settings;->getInstance()Lcom/amazon/device/ads/Settings;

    move-result-object v0

    const-string/jumbo v1, "lastIdentifyUserWithSisTime"

    invoke-virtual {v0, v1, v2, v3}, Lcom/amazon/device/ads/Settings;->getLong(Ljava/lang/String;J)J

    move-result-wide v0

    sput-wide v0, Lcom/amazon/device/ads/AmazonOOAdRegistration;->sLastIdentifyUserWithSisTime:J

    .line 572
    :cond_0
    sget-wide v0, Lcom/amazon/device/ads/AmazonOOAdRegistration;->sLastIdentifyUserWithSisTime:J

    return-wide v0
.end method


# virtual methods
.method public getAmazonDeviceID()Ljava/lang/String;
    .locals 1

    .prologue
    .line 504
    iget-object v0, p0, Lcom/amazon/device/ads/AmazonOOAdRegistration$AmazonOOAdRegistrationInfo;->advertisingIdentifierInfo:Lcom/amazon/device/ads/AdvertisingIdentifier$Info;

    invoke-virtual {v0}, Lcom/amazon/device/ads/AdvertisingIdentifier$Info;->getSISDeviceIdentifier()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getDeviceInfoAsJSON()Ljava/lang/String;
    .locals 1

    .prologue
    .line 552
    invoke-static {}, Lcom/amazon/device/ads/InternalAdRegistration;->getInstance()Lcom/amazon/device/ads/IInternalAdRegistration;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/device/ads/IInternalAdRegistration;->getDeviceInfo()Lcom/amazon/device/ads/DeviceInfo;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/device/ads/DeviceInfo;->toJsonString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getDeviceInfoParams(Z)Ljava/util/Map;
    .locals 6
    .param p1, "shouldURLDecode"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(Z)",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 516
    invoke-static {}, Lcom/amazon/device/ads/InternalAdRegistration;->getInstance()Lcom/amazon/device/ads/IInternalAdRegistration;

    move-result-object v3

    invoke-interface {v3}, Lcom/amazon/device/ads/IInternalAdRegistration;->getDeviceInfo()Lcom/amazon/device/ads/DeviceInfo;

    move-result-object v0

    .line 517
    .local v0, "deviceInfo":Lcom/amazon/device/ads/DeviceInfo;
    invoke-static {}, Lcom/amazon/device/ads/InternalAdRegistration;->getInstance()Lcom/amazon/device/ads/IInternalAdRegistration;

    move-result-object v3

    invoke-interface {v3}, Lcom/amazon/device/ads/IInternalAdRegistration;->getRegistrationInfo()Lcom/amazon/device/ads/RegistrationInfo;

    move-result-object v2

    .line 519
    .local v2, "registrationInfo":Lcom/amazon/device/ads/RegistrationInfo;
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 520
    .local v1, "deviceInfoParams":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const-string/jumbo v3, "dt"

    invoke-static {}, Lcom/amazon/device/ads/DeviceInfo;->getDeviceType()Ljava/lang/String;

    move-result-object v4

    # invokes: Lcom/amazon/device/ads/AmazonOOAdRegistration;->addParam(Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/String;Z)V
    invoke-static {v1, v3, v4, p1}, Lcom/amazon/device/ads/AmazonOOAdRegistration;->access$100(Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/String;Z)V

    .line 521
    const-string/jumbo v3, "app"

    invoke-virtual {v2}, Lcom/amazon/device/ads/RegistrationInfo;->getAppName()Ljava/lang/String;

    move-result-object v4

    # invokes: Lcom/amazon/device/ads/AmazonOOAdRegistration;->addParam(Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/String;Z)V
    invoke-static {v1, v3, v4, p1}, Lcom/amazon/device/ads/AmazonOOAdRegistration;->access$100(Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/String;Z)V

    .line 522
    const-string/jumbo v3, "aud"

    invoke-static {}, Lcom/amazon/device/ads/Configuration;->getInstance()Lcom/amazon/device/ads/Configuration;

    move-result-object v4

    sget-object v5, Lcom/amazon/device/ads/Configuration$ConfigOption;->SIS_DOMAIN:Lcom/amazon/device/ads/Configuration$ConfigOption;

    invoke-virtual {v4, v5}, Lcom/amazon/device/ads/Configuration;->getString(Lcom/amazon/device/ads/Configuration$ConfigOption;)Ljava/lang/String;

    move-result-object v4

    # invokes: Lcom/amazon/device/ads/AmazonOOAdRegistration;->addParam(Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/String;Z)V
    invoke-static {v1, v3, v4, p1}, Lcom/amazon/device/ads/AmazonOOAdRegistration;->access$100(Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/String;Z)V

    .line 523
    const-string/jumbo v3, "appId"

    invoke-virtual {v2}, Lcom/amazon/device/ads/RegistrationInfo;->getAppKey()Ljava/lang/String;

    move-result-object v4

    # invokes: Lcom/amazon/device/ads/AmazonOOAdRegistration;->addParam(Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/String;Z)V
    invoke-static {v1, v3, v4, p1}, Lcom/amazon/device/ads/AmazonOOAdRegistration;->access$100(Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/String;Z)V

    .line 525
    iget-object v3, p0, Lcom/amazon/device/ads/AmazonOOAdRegistration$AmazonOOAdRegistrationInfo;->advertisingIdentifierInfo:Lcom/amazon/device/ads/AdvertisingIdentifier$Info;

    invoke-virtual {v3}, Lcom/amazon/device/ads/AdvertisingIdentifier$Info;->canDo()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 527
    iget-object v3, p0, Lcom/amazon/device/ads/AmazonOOAdRegistration$AmazonOOAdRegistrationInfo;->advertisingIdentifierInfo:Lcom/amazon/device/ads/AdvertisingIdentifier$Info;

    invoke-virtual {v3}, Lcom/amazon/device/ads/AdvertisingIdentifier$Info;->hasAdvertisingIdentifier()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 529
    const-string/jumbo v3, "idfa"

    iget-object v4, p0, Lcom/amazon/device/ads/AmazonOOAdRegistration$AmazonOOAdRegistrationInfo;->advertisingIdentifierInfo:Lcom/amazon/device/ads/AdvertisingIdentifier$Info;

    invoke-virtual {v4}, Lcom/amazon/device/ads/AdvertisingIdentifier$Info;->getAdvertisingIdentifier()Ljava/lang/String;

    move-result-object v4

    # invokes: Lcom/amazon/device/ads/AmazonOOAdRegistration;->addParam(Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/String;Z)V
    invoke-static {v1, v3, v4, p1}, Lcom/amazon/device/ads/AmazonOOAdRegistration;->access$100(Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/String;Z)V

    .line 530
    const-string/jumbo v3, "oo"

    iget-object v4, p0, Lcom/amazon/device/ads/AmazonOOAdRegistration$AmazonOOAdRegistrationInfo;->advertisingIdentifierInfo:Lcom/amazon/device/ads/AdvertisingIdentifier$Info;

    invoke-virtual {v4}, Lcom/amazon/device/ads/AdvertisingIdentifier$Info;->isLimitAdTrackingEnabled()Z

    move-result v4

    invoke-static {v4}, Ljava/lang/Boolean;->toString(Z)Ljava/lang/String;

    move-result-object v4

    # invokes: Lcom/amazon/device/ads/AmazonOOAdRegistration;->addParam(Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/String;Z)V
    invoke-static {v1, v3, v4, p1}, Lcom/amazon/device/ads/AmazonOOAdRegistration;->access$100(Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/String;Z)V

    .line 543
    :cond_0
    :goto_0
    return-object v1

    .line 534
    :cond_1
    const-string/jumbo v3, "sha1_mac"

    invoke-virtual {v0}, Lcom/amazon/device/ads/DeviceInfo;->getMacSha1()Ljava/lang/String;

    move-result-object v4

    # invokes: Lcom/amazon/device/ads/AmazonOOAdRegistration;->addParam(Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/String;Z)V
    invoke-static {v1, v3, v4, p1}, Lcom/amazon/device/ads/AmazonOOAdRegistration;->access$100(Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/String;Z)V

    .line 535
    const-string/jumbo v3, "md5_mac"

    invoke-virtual {v0}, Lcom/amazon/device/ads/DeviceInfo;->getMacMd5()Ljava/lang/String;

    move-result-object v4

    # invokes: Lcom/amazon/device/ads/AmazonOOAdRegistration;->addParam(Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/String;Z)V
    invoke-static {v1, v3, v4, p1}, Lcom/amazon/device/ads/AmazonOOAdRegistration;->access$100(Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/String;Z)V

    .line 536
    const-string/jumbo v3, "sha1_serial"

    invoke-virtual {v0}, Lcom/amazon/device/ads/DeviceInfo;->getSerialSha1()Ljava/lang/String;

    move-result-object v4

    # invokes: Lcom/amazon/device/ads/AmazonOOAdRegistration;->addParam(Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/String;Z)V
    invoke-static {v1, v3, v4, p1}, Lcom/amazon/device/ads/AmazonOOAdRegistration;->access$100(Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/String;Z)V

    .line 537
    const-string/jumbo v3, "md5_serial"

    invoke-virtual {v0}, Lcom/amazon/device/ads/DeviceInfo;->getSerialMd5()Ljava/lang/String;

    move-result-object v4

    # invokes: Lcom/amazon/device/ads/AmazonOOAdRegistration;->addParam(Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/String;Z)V
    invoke-static {v1, v3, v4, p1}, Lcom/amazon/device/ads/AmazonOOAdRegistration;->access$100(Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/String;Z)V

    .line 538
    const-string/jumbo v3, "sha1_udid"

    invoke-virtual {v0}, Lcom/amazon/device/ads/DeviceInfo;->getUdidSha1()Ljava/lang/String;

    move-result-object v4

    # invokes: Lcom/amazon/device/ads/AmazonOOAdRegistration;->addParam(Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/String;Z)V
    invoke-static {v1, v3, v4, p1}, Lcom/amazon/device/ads/AmazonOOAdRegistration;->access$100(Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/String;Z)V

    .line 539
    const-string/jumbo v3, "md5_udid"

    invoke-virtual {v0}, Lcom/amazon/device/ads/DeviceInfo;->getUdidMd5()Ljava/lang/String;

    move-result-object v4

    # invokes: Lcom/amazon/device/ads/AmazonOOAdRegistration;->addParam(Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/String;Z)V
    invoke-static {v1, v3, v4, p1}, Lcom/amazon/device/ads/AmazonOOAdRegistration;->access$100(Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/String;Z)V

    goto :goto_0
.end method

.method public shouldIdentifyUser()Z
    .locals 6

    .prologue
    .line 562
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    .line 563
    .local v0, "now":J
    invoke-direct {p0}, Lcom/amazon/device/ads/AmazonOOAdRegistration$AmazonOOAdRegistrationInfo;->getLastIdentifyUserWithSISTime()J

    move-result-wide v2

    sub-long v2, v0, v2

    const-wide/32 v4, 0x1b77400

    cmp-long v2, v2, v4

    if-lez v2, :cond_0

    const/4 v2, 0x1

    :goto_0
    return v2

    :cond_0
    const/4 v2, 0x0

    goto :goto_0
.end method
