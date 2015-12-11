.class public Lcom/amazon/mShop/mobileads/AdsHelper;
.super Ljava/lang/Object;
.source "AdsHelper.java"


# static fields
.field private static final AUTH_LOCALE_MAP:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 52
    new-instance v0, Lcom/amazon/mShop/mobileads/AdsHelper$1;

    const/16 v1, 0x8

    invoke-direct {v0, v1}, Lcom/amazon/mShop/mobileads/AdsHelper$1;-><init>(I)V

    sput-object v0, Lcom/amazon/mShop/mobileads/AdsHelper;->AUTH_LOCALE_MAP:Ljava/util/Map;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 29
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static isAdsClientConfigEnabled()Z
    .locals 1

    .prologue
    .line 117
    sget v0, Lcom/amazon/mShop/android/lib/R$string;->config_hasMobileAds:I

    invoke-static {v0}, Lcom/amazon/mShop/util/ConfigUtils;->isEnabled(I)Z

    move-result v0

    return v0
.end method

.method public static isAdsEnabled()Z
    .locals 1

    .prologue
    .line 113
    sget v0, Lcom/amazon/mShop/android/lib/R$string;->config_hasMobileAds:I

    invoke-static {v0}, Lcom/amazon/mShop/util/ConfigUtils;->isEnabled(I)Z

    move-result v0

    return v0
.end method

.method public static openUserPreferences(Lcom/amazon/mShop/AmazonActivity;)V
    .locals 3
    .param p0, "activity"    # Lcom/amazon/mShop/AmazonActivity;

    .prologue
    .line 86
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/mShop/platform/Platform;->getApplicationContext()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/Context;

    .line 87
    .local v0, "appContext":Landroid/content/Context;
    new-instance v1, Lcom/amazon/mShop/AmazonProgressDialog;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/AmazonProgressDialog;-><init>(Landroid/content/Context;)V

    .line 88
    .local v1, "progressDialog":Lcom/amazon/mShop/AmazonProgressDialog;
    sget v2, Lcom/amazon/mShop/android/lib/R$string;->web_view_loading:I

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/AmazonProgressDialog;->setTitle(I)V

    .line 89
    invoke-virtual {v1}, Lcom/amazon/mShop/AmazonProgressDialog;->show()V

    .line 90
    new-instance v2, Lcom/amazon/mShop/mobileads/AdsHelper$2;

    invoke-direct {v2, v1, p0}, Lcom/amazon/mShop/mobileads/AdsHelper$2;-><init>(Lcom/amazon/mShop/AmazonProgressDialog;Lcom/amazon/mShop/AmazonActivity;)V

    invoke-static {v0, v2}, Lcom/amazon/device/ads/AmazonOOAdRegistration;->prepareRegistrationInfo(Landroid/content/Context;Lcom/amazon/device/ads/AmazonOOAdRegistrationListener;)V

    .line 110
    return-void
.end method

.method private static registerApp(Landroid/content/Context;)V
    .locals 6
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 69
    sget v4, Lcom/amazon/mShop/android/lib/R$string;->config_mobileadsAppId:I

    invoke-static {p0, v4}, Lcom/amazon/mShop/util/ConfigUtils;->getString(Landroid/content/Context;I)Ljava/lang/String;

    move-result-object v0

    .line 70
    .local v0, "adAppId":Ljava/lang/String;
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    sget v5, Lcom/amazon/mShop/android/lib/R$string;->config_mobileadsAppName:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 71
    .local v1, "adAppName":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 73
    invoke-static {p0}, Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds;->isLogging(Landroid/content/Context;)Z

    move-result v4

    invoke-static {v4}, Lcom/amazon/device/ads/AmazonOOAdRegistration;->enableLogging(Z)V

    .line 75
    :cond_0
    invoke-static {v0}, Lcom/amazon/device/ads/AmazonOOAdRegistration;->setAppKey(Ljava/lang/String;)V

    .line 76
    invoke-static {v1}, Lcom/amazon/device/ads/AmazonOOAdRegistration;->setAppName(Ljava/lang/String;)V

    .line 77
    sget-object v4, Lcom/amazon/mShop/mobileads/AdsHelper;->AUTH_LOCALE_MAP:Ljava/util/Map;

    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/mShop/platform/AppLocale;->getCurrentLocaleName()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 78
    .local v2, "locale":Ljava/lang/String;
    invoke-static {v2}, Lcom/amazon/device/ads/AmazonOOAdRegistration;->setAppDefinedMarketplace(Ljava/lang/String;)V

    .line 81
    invoke-static {}, Lcom/amazon/mShop/AmazonApplication;->isWebViewCacheEmpty()Z

    move-result v4

    if-nez v4, :cond_1

    const/4 v3, 0x1

    .line 82
    .local v3, "shouldOperateWebViewTimers":Z
    :goto_0
    invoke-static {p0, v3}, Lcom/amazon/device/ads/AmazonOOAdRegistration;->setShouldPauseWebViewTimersInWebViewRelatedActivities(Landroid/content/Context;Z)V

    .line 83
    return-void

    .line 81
    .end local v3    # "shouldOperateWebViewTimers":Z
    :cond_1
    const/4 v3, 0x0

    goto :goto_0
.end method

.method public static resetIfNecessary(Landroid/content/Context;)V
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 45
    invoke-static {}, Lcom/amazon/mShop/mobileads/AdsHelper;->isAdsClientConfigEnabled()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 47
    invoke-static {p0}, Lcom/amazon/mShop/mobileads/AdsHelper;->registerApp(Landroid/content/Context;)V

    .line 48
    invoke-static {p0}, Lcom/amazon/mShop/util/SisUtil;->reset(Landroid/content/Context;)V

    .line 50
    :cond_0
    return-void
.end method
