.class public Lcom/amazon/device/ads/AmazonOOHybridAdBridge$AmazonOOHybridAdBridgeInfo;
.super Ljava/lang/Object;
.source "AmazonOOHybridAdBridge.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/device/ads/AmazonOOHybridAdBridge;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AmazonOOHybridAdBridgeInfo"
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 61
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 62
    return-void
.end method

.method protected static getAmazonOOHybridAdBridgeInfo()Lcom/amazon/device/ads/AmazonOOHybridAdBridge$AmazonOOHybridAdBridgeInfo;
    .locals 1

    .prologue
    .line 69
    new-instance v0, Lcom/amazon/device/ads/AmazonOOHybridAdBridge$AmazonOOHybridAdBridgeInfo;

    invoke-direct {v0}, Lcom/amazon/device/ads/AmazonOOHybridAdBridge$AmazonOOHybridAdBridgeInfo;-><init>()V

    return-object v0
.end method


# virtual methods
.method public final getAppInfo()Ljava/util/HashMap;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation

    .prologue
    .line 79
    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    .line 81
    .local v2, "appInfoMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    new-instance v0, Lcom/amazon/device/ads/AdvertisingIdentifier;

    invoke-direct {v0}, Lcom/amazon/device/ads/AdvertisingIdentifier;-><init>()V

    .line 82
    .local v0, "advertisingIdentifier":Lcom/amazon/device/ads/AdvertisingIdentifier;
    invoke-virtual {v0}, Lcom/amazon/device/ads/AdvertisingIdentifier;->getAdvertisingIdentifierInfo()Lcom/amazon/device/ads/AdvertisingIdentifier$Info;

    move-result-object v1

    .line 84
    .local v1, "advertisingIdentifierInfo":Lcom/amazon/device/ads/AdvertisingIdentifier$Info;
    invoke-virtual {v1}, Lcom/amazon/device/ads/AdvertisingIdentifier$Info;->canDo()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 86
    const-string/jumbo v4, "stableIdentityServiceId"

    invoke-virtual {v1}, Lcom/amazon/device/ads/AdvertisingIdentifier$Info;->getSISDeviceIdentifier()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 87
    invoke-virtual {v1}, Lcom/amazon/device/ads/AdvertisingIdentifier$Info;->hasAdvertisingIdentifier()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 89
    const-string/jumbo v4, "advertisingIdentifier"

    invoke-virtual {v1}, Lcom/amazon/device/ads/AdvertisingIdentifier$Info;->getAdvertisingIdentifier()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 90
    const-string/jumbo v4, "advertisingTrackingEnabled"

    invoke-virtual {v1}, Lcom/amazon/device/ads/AdvertisingIdentifier$Info;->isLimitAdTrackingEnabled()Z

    move-result v5

    invoke-static {v5}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v5

    invoke-virtual {v2, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 102
    :cond_0
    :goto_0
    return-object v2

    .line 94
    :cond_1
    invoke-static {}, Lcom/amazon/device/ads/InternalAdRegistration;->getInstance()Lcom/amazon/device/ads/IInternalAdRegistration;

    move-result-object v4

    invoke-interface {v4}, Lcom/amazon/device/ads/IInternalAdRegistration;->getDeviceInfo()Lcom/amazon/device/ads/DeviceInfo;

    move-result-object v3

    .line 95
    .local v3, "deviceInfo":Lcom/amazon/device/ads/DeviceInfo;
    const-string/jumbo v4, "advertisingIdentifier"

    invoke-virtual {v3}, Lcom/amazon/device/ads/DeviceInfo;->getUdid()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 96
    const-string/jumbo v4, "advertisingIdentifierMD5"

    invoke-virtual {v3}, Lcom/amazon/device/ads/DeviceInfo;->getUdidMd5()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 97
    const-string/jumbo v4, "advertisingIdentifierSHA1"

    invoke-virtual {v3}, Lcom/amazon/device/ads/DeviceInfo;->getUdidSha1()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 98
    const-string/jumbo v4, "advertisingTrackingEnabled"

    const/4 v5, 0x1

    invoke-static {v5}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v5

    invoke-virtual {v2, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method

.method public openInAppBrowser(Landroid/content/Context;Ljava/lang/String;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 112
    new-instance v0, Lcom/amazon/device/ads/MraidBrowser$MraidBrowserBuilder;

    invoke-direct {v0}, Lcom/amazon/device/ads/MraidBrowser$MraidBrowserBuilder;-><init>()V

    invoke-virtual {v0, p1}, Lcom/amazon/device/ads/MraidBrowser$MraidBrowserBuilder;->withContext(Landroid/content/Context;)Lcom/amazon/device/ads/MraidBrowser$MraidBrowserBuilder;

    move-result-object v0

    invoke-virtual {v0, p2}, Lcom/amazon/device/ads/MraidBrowser$MraidBrowserBuilder;->withUrl(Ljava/lang/String;)Lcom/amazon/device/ads/MraidBrowser$MraidBrowserBuilder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/device/ads/MraidBrowser$MraidBrowserBuilder;->show()V

    .line 116
    return-void
.end method

.method public openInAppBrowserWithExternalBrowserButton(Landroid/content/Context;Ljava/lang/String;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 125
    new-instance v0, Lcom/amazon/device/ads/MraidBrowser$MraidBrowserBuilder;

    invoke-direct {v0}, Lcom/amazon/device/ads/MraidBrowser$MraidBrowserBuilder;-><init>()V

    invoke-virtual {v0, p1}, Lcom/amazon/device/ads/MraidBrowser$MraidBrowserBuilder;->withContext(Landroid/content/Context;)Lcom/amazon/device/ads/MraidBrowser$MraidBrowserBuilder;

    move-result-object v0

    invoke-virtual {v0, p2}, Lcom/amazon/device/ads/MraidBrowser$MraidBrowserBuilder;->withUrl(Ljava/lang/String;)Lcom/amazon/device/ads/MraidBrowser$MraidBrowserBuilder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/device/ads/MraidBrowser$MraidBrowserBuilder;->withExternalBrowserButton()Lcom/amazon/device/ads/MraidBrowser$MraidBrowserBuilder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/device/ads/MraidBrowser$MraidBrowserBuilder;->show()V

    .line 130
    return-void
.end method
