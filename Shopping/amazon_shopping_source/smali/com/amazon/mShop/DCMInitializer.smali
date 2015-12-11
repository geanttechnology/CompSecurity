.class public Lcom/amazon/mShop/DCMInitializer;
.super Ljava/lang/Object;
.source "DCMInitializer.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static initialize(Landroid/content/Context;Ljava/lang/String;)V
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "deviceTypeId"    # Ljava/lang/String;

    .prologue
    .line 26
    new-instance v0, Lcom/amazon/mShop/sso/MShopOAuthHelper;

    invoke-direct {v0}, Lcom/amazon/mShop/sso/MShopOAuthHelper;-><init>()V

    invoke-static {p0, v0}, Lcom/amazon/client/metrics/AndroidMetricsFactoryImpl;->setOAuthHelper(Landroid/content/Context;Lcom/amazon/client/metrics/transport/OAuthHelper;)V

    .line 27
    invoke-static {p0, p1}, Lcom/amazon/client/metrics/AndroidMetricsFactoryImpl;->setDeviceType(Landroid/content/Context;Ljava/lang/String;)V

    .line 28
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/platform/AndroidPlatform;->getDeviceId()Ljava/lang/String;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/amazon/client/metrics/AndroidMetricsFactoryImpl;->setDeviceId(Landroid/content/Context;Ljava/lang/String;)V

    .line 29
    invoke-static {p0}, Lcom/amazon/mShop/DCMInitializer;->updatePreferredMarketplace(Landroid/content/Context;)V

    .line 30
    return-void
.end method

.method public static updatePreferredMarketplace(Landroid/content/Context;)V
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 43
    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/platform/AppLocale;->getCurrentLocaleName()Ljava/lang/String;

    move-result-object v0

    .line 44
    .local v0, "currentLocaleName":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v2

    invoke-virtual {v2, v0}, Lcom/amazon/mShop/platform/AppLocale;->getMarketPlaceIdByLocale(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 45
    .local v1, "currentMarketplace":Ljava/lang/String;
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_0

    .line 47
    invoke-static {p0, v1}, Lcom/amazon/client/metrics/AndroidMetricsFactoryImpl;->setPreferredMarketplace(Landroid/content/Context;Ljava/lang/String;)V

    .line 49
    :cond_0
    return-void
.end method
