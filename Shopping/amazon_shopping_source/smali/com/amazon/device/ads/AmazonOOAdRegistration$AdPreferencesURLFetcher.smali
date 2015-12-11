.class Lcom/amazon/device/ads/AmazonOOAdRegistration$AdPreferencesURLFetcher;
.super Lcom/amazon/device/ads/StartUpWaiter;
.source "AmazonOOAdRegistration.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/device/ads/AmazonOOAdRegistration;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "AdPreferencesURLFetcher"
.end annotation


# instance fields
.field private listener:Lcom/amazon/device/ads/AmazonOOAdPreferencesURLListener;


# direct methods
.method protected constructor <init>(Lcom/amazon/device/ads/AmazonOOAdPreferencesURLListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/amazon/device/ads/AmazonOOAdPreferencesURLListener;

    .prologue
    .line 420
    invoke-direct {p0}, Lcom/amazon/device/ads/StartUpWaiter;-><init>()V

    .line 421
    iput-object p1, p0, Lcom/amazon/device/ads/AmazonOOAdRegistration$AdPreferencesURLFetcher;->listener:Lcom/amazon/device/ads/AmazonOOAdPreferencesURLListener;

    .line 422
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/device/ads/AmazonOOAdRegistration$AdPreferencesURLFetcher;)Lcom/amazon/device/ads/AmazonOOAdPreferencesURLListener;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/device/ads/AmazonOOAdRegistration$AdPreferencesURLFetcher;

    .prologue
    .line 415
    iget-object v0, p0, Lcom/amazon/device/ads/AmazonOOAdRegistration$AdPreferencesURLFetcher;->listener:Lcom/amazon/device/ads/AmazonOOAdPreferencesURLListener;

    return-object v0
.end method

.method private onFetched(Ljava/lang/String;)V
    .locals 2
    .param p1, "adPreferencesURL"    # Ljava/lang/String;

    .prologue
    .line 427
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 428
    .local v0, "handler":Landroid/os/Handler;
    new-instance v1, Lcom/amazon/device/ads/AmazonOOAdRegistration$AdPreferencesURLFetcher$1;

    invoke-direct {v1, p0, p1}, Lcom/amazon/device/ads/AmazonOOAdRegistration$AdPreferencesURLFetcher$1;-><init>(Lcom/amazon/device/ads/AmazonOOAdRegistration$AdPreferencesURLFetcher;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 436
    return-void
.end method


# virtual methods
.method protected startUpFailed()V
    .locals 1

    .prologue
    .line 474
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/amazon/device/ads/AmazonOOAdRegistration$AdPreferencesURLFetcher;->onFetched(Ljava/lang/String;)V

    .line 475
    return-void
.end method

.method protected startUpReady()V
    .locals 7

    .prologue
    .line 441
    new-instance v1, Lcom/amazon/device/ads/AdvertisingIdentifier;

    invoke-direct {v1}, Lcom/amazon/device/ads/AdvertisingIdentifier;-><init>()V

    .line 442
    .local v1, "advertisingIdentifier":Lcom/amazon/device/ads/AdvertisingIdentifier;
    invoke-virtual {v1}, Lcom/amazon/device/ads/AdvertisingIdentifier;->getAdvertisingIdentifierInfo()Lcom/amazon/device/ads/AdvertisingIdentifier$Info;

    move-result-object v2

    .line 444
    .local v2, "advertisingIdentifierInfo":Lcom/amazon/device/ads/AdvertisingIdentifier$Info;
    invoke-static {}, Lcom/amazon/device/ads/Configuration;->getInstance()Lcom/amazon/device/ads/Configuration;

    move-result-object v5

    sget-object v6, Lcom/amazon/device/ads/Configuration$ConfigOption;->AD_PREF_URL:Lcom/amazon/device/ads/Configuration$ConfigOption;

    invoke-virtual {v5, v6}, Lcom/amazon/device/ads/Configuration;->getString(Lcom/amazon/device/ads/Configuration$ConfigOption;)Ljava/lang/String;

    move-result-object v3

    .line 445
    .local v3, "baseURL":Ljava/lang/String;
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 446
    .local v4, "preferencesURL":Ljava/lang/StringBuilder;
    const/16 v5, 0x3f

    invoke-virtual {v3, v5}, Ljava/lang/String;->indexOf(I)I

    move-result v5

    const/4 v6, -0x1

    if-ne v5, v6, :cond_1

    .line 448
    const-string/jumbo v5, "?"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 454
    :goto_0
    const-string/jumbo v5, "adId="

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 455
    invoke-virtual {v2}, Lcom/amazon/device/ads/AdvertisingIdentifier$Info;->getSISDeviceIdentifier()Ljava/lang/String;

    move-result-object v0

    .line 456
    .local v0, "adID":Ljava/lang/String;
    invoke-virtual {v2}, Lcom/amazon/device/ads/AdvertisingIdentifier$Info;->hasSISDeviceIdentifier()Z

    move-result v5

    if-nez v5, :cond_0

    .line 461
    const-string/jumbo v5, "AmazonOOAdRegistration"

    const-string/jumbo v6, "Ad-id not found, using blank"

    invoke-static {v5, v6}, Lcom/amazon/device/ads/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 462
    const-string/jumbo v0, ""

    .line 464
    :cond_0
    invoke-static {v0}, Lcom/amazon/device/ads/Utils;->getURLEncodedString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 465
    const-string/jumbo v5, "&appId="

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 466
    invoke-static {}, Lcom/amazon/device/ads/InternalAdRegistration;->getInstance()Lcom/amazon/device/ads/IInternalAdRegistration;

    move-result-object v5

    invoke-interface {v5}, Lcom/amazon/device/ads/IInternalAdRegistration;->getRegistrationInfo()Lcom/amazon/device/ads/RegistrationInfo;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/device/ads/RegistrationInfo;->getAppKey()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Lcom/amazon/device/ads/Utils;->getURLEncodedString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 468
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {p0, v5}, Lcom/amazon/device/ads/AmazonOOAdRegistration$AdPreferencesURLFetcher;->onFetched(Ljava/lang/String;)V

    .line 469
    return-void

    .line 452
    .end local v0    # "adID":Ljava/lang/String;
    :cond_1
    const-string/jumbo v5, "&"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0
.end method
