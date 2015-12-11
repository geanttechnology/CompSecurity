.class public Lcom/amazon/mShop/mash/context/MShopCapabilityManager;
.super Lcom/amazon/mobile/mash/appcontext/CapabilityManager;
.source "MShopCapabilityManager.java"


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 23
    invoke-direct {p0, p1}, Lcom/amazon/mobile/mash/appcontext/CapabilityManager;-><init>(Landroid/content/Context;)V

    .line 24
    return-void
.end method


# virtual methods
.method public isAvailableAivPlayback()Z
    .locals 3

    .prologue
    .line 55
    const/4 v1, 0x0

    .line 56
    .local v1, "isAIVSupported":Z
    invoke-static {}, Lcom/amazon/mShop/aiv/AIVAvailabilityUtils;->isAIVAvailable()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 62
    invoke-static {}, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->getInstance()Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;

    move-result-object v0

    .line 63
    .local v0, "amazonInstantVideo":Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;
    invoke-virtual {v0}, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->isSupported()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 65
    invoke-virtual {v0}, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->isPlaybackSustainable()Z

    move-result v1

    .line 68
    .end local v0    # "amazonInstantVideo":Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;
    :cond_0
    return v1
.end method

.method public isAvailableAppNavMenu()Z
    .locals 1

    .prologue
    .line 39
    const/4 v0, 0x1

    return v0
.end method

.method public isAvailableAppstore()Z
    .locals 1

    .prologue
    .line 87
    invoke-static {}, Lcom/amazon/mShop/appstore/AppstoreUtils;->isAppstoreAvailable()Z

    move-result v0

    return v0
.end method

.method public isAvailableEnforceParentalControls()Z
    .locals 1

    .prologue
    .line 50
    const/4 v0, 0x0

    return v0
.end method

.method public isAvailableShowAdsBrowser()Z
    .locals 1

    .prologue
    .line 73
    const/4 v0, 0x0

    return v0
.end method

.method public isAvailableShowAmazonPoints()Z
    .locals 2

    .prologue
    .line 28
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/platform/AndroidPlatform;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->config_hasPoints:I

    invoke-static {v0, v1}, Lcom/amazon/mShop/util/ConfigUtils;->isEnabled(Landroid/content/Context;I)Z

    move-result v0

    return v0
.end method

.method public isAvailableShowCardScannerCredit()Z
    .locals 2

    .prologue
    .line 79
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0xe

    if-lt v0, v1, :cond_0

    .line 80
    const/4 v0, 0x1

    .line 82
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isAvailableShowDeliveryDestinationPicker()Z
    .locals 1

    .prologue
    .line 34
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/platform/AndroidPlatform;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/opl/AddressPickerView;->hasCVSD(Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method public isAvailableShowNotificationSettings()Z
    .locals 1

    .prologue
    .line 44
    invoke-static {}, Lcom/amazon/mShop/util/MShopPushNotificationUtils;->isPushNotificationAvailable()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-static {}, Lcom/amazon/mShop/util/MShopPushNotificationUtils;->isMarketplaceSupportsNotification()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isAvailableSmile()Z
    .locals 1

    .prologue
    .line 92
    invoke-static {}, Lcom/amazon/mShop/util/ActivityUtils;->isSmileEnabled()Z

    move-result v0

    return v0
.end method
