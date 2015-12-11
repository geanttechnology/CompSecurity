.class public Lcom/amazon/mShop/mash/interception/AppStoreInterceptionHandler;
.super Lcom/amazon/mobile/mash/interception/UrlInterceptionHandler;
.source "AppStoreInterceptionHandler.java"


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/net/Uri;Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "uri"    # Landroid/net/Uri;
    .param p3, "configEntry"    # Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;

    .prologue
    .line 20
    invoke-direct {p0, p1, p2, p3}, Lcom/amazon/mobile/mash/interception/UrlInterceptionHandler;-><init>(Landroid/content/Context;Landroid/net/Uri;Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;)V

    .line 21
    return-void
.end method


# virtual methods
.method public handle()Z
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 28
    invoke-virtual {p0}, Lcom/amazon/mShop/mash/interception/AppStoreInterceptionHandler;->getUri()Landroid/net/Uri;

    move-result-object v2

    const-string/jumbo v3, "asin"

    invoke-virtual {v2, v3}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 29
    .local v0, "asin":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 30
    const/4 v2, 0x0

    .line 47
    :goto_0
    return v2

    .line 33
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/mShop/mash/interception/AppStoreInterceptionHandler;->getContext()Landroid/content/Context;

    move-result-object v1

    .line 35
    .local v1, "context":Landroid/content/Context;
    sget-object v2, Lcom/amazon/mShop/util/ActivityUtils;->ASIN_AMAZON_COINS:Ljava/util/HashSet;

    invoke-virtual {v2, v0}, Ljava/util/HashSet;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 36
    invoke-virtual {p0}, Lcom/amazon/mShop/mash/interception/AppStoreInterceptionHandler;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2, v0}, Lcom/amazon/mShop/util/ActivityUtils;->startAppstoreActivityToBuyCoins(Landroid/content/Context;Ljava/lang/String;)V

    .line 41
    :goto_1
    instance-of v2, v1, Lcom/amazon/mShop/details/web/WebProductDetailsActivity;

    if-eqz v2, :cond_1

    .line 44
    check-cast v1, Lcom/amazon/mShop/details/web/WebProductDetailsActivity;

    .end local v1    # "context":Landroid/content/Context;
    invoke-virtual {v1, v0}, Lcom/amazon/mShop/details/web/WebProductDetailsActivity;->finishIfAlreadyRedirectToAppStore(Ljava/lang/String;)V

    .line 47
    :cond_1
    const/4 v2, 0x1

    goto :goto_0

    .line 38
    .restart local v1    # "context":Landroid/content/Context;
    :cond_2
    invoke-virtual {p0}, Lcom/amazon/mShop/mash/interception/AppStoreInterceptionHandler;->getRefmarker()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v0, v2, v4, v4}, Lcom/amazon/mShop/util/ActivityUtils;->startAppstoreActivityWithAsin(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1
.end method
