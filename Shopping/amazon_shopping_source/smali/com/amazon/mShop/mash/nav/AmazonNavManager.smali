.class public Lcom/amazon/mShop/mash/nav/AmazonNavManager;
.super Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;
.source "AmazonNavManager.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 33
    invoke-direct {p0}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;-><init>()V

    return-void
.end method


# virtual methods
.method protected handleAmznappScheme(Landroid/content/Context;Landroid/net/Uri;)Z
    .locals 5
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "uri"    # Landroid/net/Uri;

    .prologue
    .line 260
    const-string/jumbo v3, "amznapp"

    invoke-virtual {p2}, Landroid/net/Uri;->getScheme()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_4

    const-string/jumbo v3, "page"

    invoke-virtual {p2}, Landroid/net/Uri;->getHost()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_4

    .line 261
    instance-of v3, p1, Lcom/amazon/mShop/web/MShopWebActivity;

    if-eqz v3, :cond_4

    .line 262
    check-cast p1, Lcom/amazon/mShop/web/MShopWebActivity;

    .end local p1    # "context":Landroid/content/Context;
    invoke-virtual {p1}, Lcom/amazon/mShop/web/MShopWebActivity;->getWebView()Landroid/webkit/WebView;

    move-result-object v2

    check-cast v2, Lcom/amazon/mShop/web/MShopWebView;

    .line 263
    .local v2, "view":Lcom/amazon/mShop/web/MShopWebView;
    const-string/jumbo v3, "app-action"

    invoke-virtual {p2, v3}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 264
    .local v0, "actionType":Ljava/lang/String;
    const-string/jumbo v3, "dismiss"

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 265
    invoke-virtual {v2}, Lcom/amazon/mShop/web/MShopWebView;->canGoBack()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 266
    invoke-static {p2}, Lcom/amazon/mShop/util/WebUtils;->parseQueryToJsObject(Landroid/net/Uri;)Ljava/lang/String;

    move-result-object v1

    .line 267
    .local v1, "jsObject":Ljava/lang/String;
    invoke-virtual {v2, v1}, Lcom/amazon/mShop/web/MShopWebView;->setParamtersToJS(Ljava/lang/String;)V

    .line 268
    invoke-virtual {v2}, Lcom/amazon/mShop/web/MShopWebView;->goBack()V

    .line 283
    .end local v1    # "jsObject":Ljava/lang/String;
    :cond_0
    :goto_0
    const/4 v3, 0x1

    .line 286
    .end local v0    # "actionType":Ljava/lang/String;
    .end local v2    # "view":Lcom/amazon/mShop/web/MShopWebView;
    :goto_1
    return v3

    .line 270
    .restart local v0    # "actionType":Ljava/lang/String;
    .restart local v2    # "view":Lcom/amazon/mShop/web/MShopWebView;
    :cond_1
    invoke-virtual {v2}, Lcom/amazon/mShop/web/MShopWebView;->getContext()Landroid/content/Context;

    move-result-object v3

    instance-of v3, v3, Lcom/amazon/mShop/AmazonActivity;

    if-eqz v3, :cond_0

    .line 271
    invoke-virtual {v2}, Lcom/amazon/mShop/web/MShopWebView;->getContext()Landroid/content/Context;

    move-result-object v3

    check-cast v3, Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v3}, Lcom/amazon/mShop/AmazonActivity;->popView()Z

    goto :goto_0

    .line 278
    :cond_2
    const-string/jumbo v3, "dismiss-all"

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 279
    invoke-virtual {p0, v2, p2}, Lcom/amazon/mShop/mash/nav/AmazonNavManager;->handleDismissAll(Landroid/webkit/WebView;Landroid/net/Uri;)V

    goto :goto_0

    .line 280
    :cond_3
    const-string/jumbo v3, "refresh"

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 281
    invoke-virtual {v2}, Lcom/amazon/mShop/web/MShopWebView;->reload()V

    goto :goto_0

    .line 286
    .end local v0    # "actionType":Ljava/lang/String;
    .end local v2    # "view":Lcom/amazon/mShop/web/MShopWebView;
    .restart local p1    # "context":Landroid/content/Context;
    :cond_4
    const/4 v3, 0x0

    goto :goto_1
.end method

.method protected handleBrowse(Landroid/net/Uri;Landroid/content/Context;)Z
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 43
    invoke-static {p2, p1}, Lcom/amazon/mShop/util/ActivityUtils;->startCategoryBrowseActivity(Landroid/content/Context;Landroid/net/Uri;)Z

    .line 44
    const/4 v0, 0x1

    return v0
.end method

.method protected handleCancelOrder(Landroid/net/Uri;Landroid/content/Context;)Z
    .locals 4
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 198
    const/4 v0, 0x0

    .line 199
    .local v0, "orderId":Ljava/lang/String;
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Landroid/net/Uri;->isHierarchical()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 200
    const-string/jumbo v1, "orderID"

    invoke-virtual {p1, v1}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 202
    :cond_0
    const-string/jumbo v1, "order_to_cancel"

    const/4 v2, 0x0

    const/4 v3, -0x1

    invoke-static {p2, v0, v1, v2, v3}, Lcom/amazon/mShop/util/ActivityUtils;->startYourOrdersActivity(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Z

    move-result v1

    return v1
.end method

.method protected handleCheckout(Landroid/net/Uri;Landroid/content/Context;)Z
    .locals 5
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    const/4 v4, 0x1

    .line 50
    const/4 v0, 0x0

    .line 54
    .local v0, "param":Lcom/amazon/mShop/opl/PurchaseParams;
    instance-of v3, p2, Lcom/amazon/mShop/cart/web/WebCartActivity;

    if-eqz v3, :cond_0

    if-eqz p1, :cond_0

    invoke-virtual {p1}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 57
    invoke-virtual {p1}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v2

    .line 58
    .local v2, "strUri":Ljava/lang/String;
    const-string/jumbo v1, "app-action=checkout"

    .line 60
    .local v1, "strTarget":Ljava/lang/String;
    invoke-virtual {v2, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 61
    const-string/jumbo v3, ""

    invoke-virtual {v2, v1, v3}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v2

    .line 62
    new-instance v0, Lcom/amazon/mShop/opl/PurchaseParams;

    .end local v0    # "param":Lcom/amazon/mShop/opl/PurchaseParams;
    invoke-direct {v0}, Lcom/amazon/mShop/opl/PurchaseParams;-><init>()V

    .line 63
    .restart local v0    # "param":Lcom/amazon/mShop/opl/PurchaseParams;
    invoke-virtual {v0, v2}, Lcom/amazon/mShop/opl/PurchaseParams;->setCheckoutUrl(Ljava/lang/String;)V

    .line 67
    .end local v1    # "strTarget":Ljava/lang/String;
    .end local v2    # "strUri":Ljava/lang/String;
    :cond_0
    if-nez v0, :cond_1

    .line 68
    new-instance v0, Lcom/amazon/mShop/opl/PurchaseParams;

    .end local v0    # "param":Lcom/amazon/mShop/opl/PurchaseParams;
    invoke-direct {v0}, Lcom/amazon/mShop/opl/PurchaseParams;-><init>()V

    .line 70
    .restart local v0    # "param":Lcom/amazon/mShop/opl/PurchaseParams;
    :cond_1
    invoke-virtual {v0, v4}, Lcom/amazon/mShop/opl/PurchaseParams;->setIsCartPurchase(Z)V

    .line 71
    invoke-static {p2, v0}, Lcom/amazon/mShop/util/ActivityUtils;->startPurchaseActivity(Landroid/content/Context;Lcom/amazon/mShop/opl/PurchaseParams;)V

    .line 72
    return v4
.end method

.method protected handleDeals(Landroid/net/Uri;Landroid/content/Context;)Z
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    const/4 v0, 0x0

    .line 235
    invoke-static {p2, v0, v0}, Lcom/amazon/mShop/util/ActivityUtils;->startDealsActivity(Landroid/content/Context;Lcom/amazon/mShop/goldbox/GoldboxLaunchParamters;Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method protected handleDetailPage(Landroid/net/Uri;Landroid/content/Context;)Z
    .locals 9
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 82
    const-string/jumbo v8, "asin"

    invoke-virtual {p1, v8}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 83
    .local v0, "asin":Ljava/lang/String;
    const-string/jumbo v8, "clickstream-tag"

    invoke-virtual {p1, v8}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 86
    .local v7, "tagFromUri":Ljava/lang/String;
    const-string/jumbo v8, "colid"

    invoke-virtual {p1, v8}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 87
    .local v2, "listId":Ljava/lang/String;
    const-string/jumbo v8, "coliid"

    invoke-virtual {p1, v8}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 90
    .local v3, "listItemId":Ljava/lang/String;
    const-string/jumbo v8, "m"

    invoke-virtual {p1, v8}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 93
    .local v4, "merchantId":Ljava/lang/String;
    const-string/jumbo v8, "offer-id"

    invoke-virtual {p1, v8}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 98
    .local v5, "offerId":Ljava/lang/String;
    invoke-static {v7}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_0

    .line 99
    new-instance v1, Lcom/amazon/mShop/control/item/ClickStreamTag;

    invoke-direct {v1, v7}, Lcom/amazon/mShop/control/item/ClickStreamTag;-><init>(Ljava/lang/String;)V

    .line 108
    .local v1, "clickStreamTag":Lcom/amazon/mShop/control/item/ClickStreamTag;
    :goto_0
    new-instance v6, Lcom/amazon/mShop/control/item/ProductController;

    invoke-direct {v6, v0, v1}, Lcom/amazon/mShop/control/item/ProductController;-><init>(Ljava/lang/String;Lcom/amazon/mShop/control/item/ClickStreamTag;)V

    .line 109
    .local v6, "productController":Lcom/amazon/mShop/control/item/ProductController;
    invoke-virtual {v6, v2}, Lcom/amazon/mShop/control/item/ProductController;->setListId(Ljava/lang/String;)V

    .line 110
    invoke-virtual {v6, v3}, Lcom/amazon/mShop/control/item/ProductController;->setListItemId(Ljava/lang/String;)V

    .line 111
    invoke-virtual {v6, v4}, Lcom/amazon/mShop/control/item/ProductController;->setMerchantId(Ljava/lang/String;)V

    .line 112
    invoke-virtual {v6, v5}, Lcom/amazon/mShop/control/item/ProductController;->setOfferId(Ljava/lang/String;)V

    .line 113
    const/4 v8, 0x0

    new-array v8, v8, [I

    invoke-static {p2, v6, v8}, Lcom/amazon/mShop/util/ActivityUtils;->launchDetailsPage(Landroid/content/Context;Lcom/amazon/mShop/control/item/ProductController;[I)Z

    .line 114
    const/4 v8, 0x1

    return v8

    .line 100
    .end local v1    # "clickStreamTag":Lcom/amazon/mShop/control/item/ClickStreamTag;
    .end local v6    # "productController":Lcom/amazon/mShop/control/item/ProductController;
    :cond_0
    instance-of v8, p2, Lcom/amazon/mShop/cart/web/WebCartActivity;

    if-eqz v8, :cond_1

    .line 101
    sget-object v1, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_CART:Lcom/amazon/mShop/control/item/ClickStreamTag;

    .restart local v1    # "clickStreamTag":Lcom/amazon/mShop/control/item/ClickStreamTag;
    goto :goto_0

    .line 102
    .end local v1    # "clickStreamTag":Lcom/amazon/mShop/control/item/ClickStreamTag;
    :cond_1
    instance-of v8, p2, Lcom/amazon/mShop/wishlist/web/WebWishListActivity;

    if-eqz v8, :cond_2

    .line 103
    sget-object v1, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_WISHLIST:Lcom/amazon/mShop/control/item/ClickStreamTag;

    .restart local v1    # "clickStreamTag":Lcom/amazon/mShop/control/item/ClickStreamTag;
    goto :goto_0

    .line 105
    .end local v1    # "clickStreamTag":Lcom/amazon/mShop/control/item/ClickStreamTag;
    :cond_2
    sget-object v1, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_DEFAULT:Lcom/amazon/mShop/control/item/ClickStreamTag;

    .restart local v1    # "clickStreamTag":Lcom/amazon/mShop/control/item/ClickStreamTag;
    goto :goto_0
.end method

.method protected handleDigitalStore(Landroid/net/Uri;Landroid/content/Context;)Z
    .locals 3
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 305
    invoke-virtual {p1}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {p2, v2}, Lcom/amazon/mShop/details/FriendAppProxy$Factory;->getProxy(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/details/FriendAppProxy;

    move-result-object v1

    .line 306
    .local v1, "proxy":Lcom/amazon/mShop/details/FriendAppProxy;
    if-eqz v1, :cond_1

    .line 308
    invoke-virtual {p1}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, p2, v2}, Lcom/amazon/mShop/details/FriendAppProxy;->getIntentForFriendApp(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    .line 309
    .local v0, "intent":Landroid/content/Intent;
    if-eqz v0, :cond_0

    .line 310
    invoke-static {v1}, Lcom/amazon/mShop/details/FriendAppAction;->logRefMarker(Lcom/amazon/mShop/details/FriendAppProxy;)V

    .line 311
    invoke-static {p2, v1, v0}, Lcom/amazon/mShop/details/FriendAppAction;->startProxyActivity(Landroid/content/Context;Lcom/amazon/mShop/details/FriendAppProxy;Landroid/content/Intent;)V

    .line 313
    :cond_0
    const/4 v2, 0x1

    .line 316
    .end local v0    # "intent":Landroid/content/Intent;
    :goto_0
    return v2

    :cond_1
    const/4 v2, 0x0

    goto :goto_0
.end method

.method protected handleDismissAll(Landroid/webkit/WebView;Landroid/net/Uri;)V
    .locals 2
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "uri"    # Landroid/net/Uri;

    .prologue
    .line 290
    invoke-virtual {p1}, Landroid/webkit/WebView;->getContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/AmazonActivity;

    .line 292
    .local v0, "activity":Lcom/amazon/mShop/AmazonActivity;
    const/4 v1, -0x1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/AmazonActivity;->setResult(I)V

    .line 293
    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonActivity;->finish()V

    .line 294
    return-void
.end method

.method protected handleHome(Landroid/net/Uri;Landroid/content/Context;)Z
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 37
    invoke-static {p2}, Lcom/amazon/mShop/util/ActivityUtils;->startHomeActivity(Landroid/content/Context;)Z

    .line 38
    const/4 v0, 0x1

    return v0
.end method

.method protected handleMobileAdsUserPreferences(Landroid/net/Uri;Landroid/content/Context;)Z
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 148
    invoke-static {p2, p1}, Lcom/amazon/mShop/util/ActivityUtils;->startAdsWebActivity(Landroid/content/Context;Landroid/net/Uri;)Z

    move-result v0

    return v0
.end method

.method protected handleModal(Landroid/net/Uri;Landroid/content/Context;)Z
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 162
    check-cast p2, Lcom/amazon/mShop/AmazonActivity;

    .end local p2    # "context":Landroid/content/Context;
    invoke-static {p2, p1}, Lcom/amazon/mShop/util/ActivityUtils;->startMShopModalWebActivity(Landroid/app/Activity;Landroid/net/Uri;)Z

    move-result v0

    return v0
.end method

.method protected handleOrderHistory(Landroid/net/Uri;Landroid/content/Context;)Z
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 178
    invoke-static {p2}, Lcom/amazon/mShop/util/ActivityUtils;->startYourOrdersActivity(Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method protected handlePushNotificationSettings(Landroid/net/Uri;Landroid/content/Context;)Z
    .locals 2
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 226
    const/4 v0, 0x0

    .line 227
    .local v0, "category":Ljava/lang/String;
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Landroid/net/Uri;->isHierarchical()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 228
    const-string/jumbo v1, "category"

    invoke-virtual {p1, v1}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 230
    :cond_0
    invoke-static {p2, v0}, Lcom/amazon/mShop/util/ActivityUtils;->startNotificationSettingActivity(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v1

    return v1
.end method

.method protected handleRecommendations(Landroid/net/Uri;Landroid/content/Context;)Z
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 77
    invoke-static {p2}, Lcom/amazon/mShop/util/ActivityUtils;->startRecommendationsActivity(Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method protected handleSearch(Landroid/net/Uri;Landroid/content/Context;)Z
    .locals 9
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 119
    const/4 v5, 0x0

    .line 120
    .local v5, "query":Ljava/lang/String;
    const/4 v4, 0x0

    .line 121
    .local v4, "filter":Ljava/lang/String;
    const/4 v1, 0x0

    .line 122
    .local v1, "categoryName":Ljava/lang/String;
    const/4 v3, 0x0

    .line 123
    .local v3, "dataUrl":Ljava/lang/String;
    const/4 v2, 0x0

    .local v2, "clickStreamOrigin":Ljava/lang/String;
    move-object v0, p2

    .line 124
    check-cast v0, Lcom/amazon/mShop/AmazonActivity;

    .line 125
    .local v0, "activity":Lcom/amazon/mShop/AmazonActivity;
    if-eqz p1, :cond_1

    invoke-virtual {p1}, Landroid/net/Uri;->isHierarchical()Z

    move-result v7

    if-eqz v7, :cond_1

    .line 126
    const-string/jumbo v7, "keyword"

    invoke-virtual {p1, v7}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 127
    const-string/jumbo v7, "filter"

    invoke-virtual {p1, v7}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 128
    if-eqz v4, :cond_0

    .line 129
    const/16 v7, 0x2b

    const/16 v8, 0xa

    invoke-virtual {v4, v7, v8}, Ljava/lang/String;->replace(CC)Ljava/lang/String;

    move-result-object v4

    .line 131
    :cond_0
    const-string/jumbo v7, "category-name"

    invoke-virtual {p1, v7}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 132
    const-string/jumbo v7, "clickstream-tag"

    invoke-virtual {p1, v7}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 133
    const-string/jumbo v7, "data-url"

    invoke-virtual {p1, v7}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 136
    :cond_1
    new-instance v7, Lcom/amazon/mShop/search/SearchIntentBuilder;

    invoke-direct {v7, v0}, Lcom/amazon/mShop/search/SearchIntentBuilder;-><init>(Landroid/content/Context;)V

    invoke-virtual {v7, v5}, Lcom/amazon/mShop/search/SearchIntentBuilder;->query(Ljava/lang/String;)Lcom/amazon/mShop/search/SearchIntentBuilder;

    move-result-object v7

    invoke-virtual {v7, v4}, Lcom/amazon/mShop/search/SearchIntentBuilder;->filter(Ljava/lang/String;)Lcom/amazon/mShop/search/SearchIntentBuilder;

    move-result-object v7

    invoke-virtual {v7, v1}, Lcom/amazon/mShop/search/SearchIntentBuilder;->categoryName(Ljava/lang/String;)Lcom/amazon/mShop/search/SearchIntentBuilder;

    move-result-object v7

    invoke-virtual {v7, v3}, Lcom/amazon/mShop/search/SearchIntentBuilder;->dataUrl(Ljava/lang/String;)Lcom/amazon/mShop/search/SearchIntentBuilder;

    move-result-object v7

    invoke-virtual {v7, v2}, Lcom/amazon/mShop/search/SearchIntentBuilder;->clickStreamOrigin(Ljava/lang/String;)Lcom/amazon/mShop/search/SearchIntentBuilder;

    move-result-object v7

    invoke-virtual {v7}, Lcom/amazon/mShop/search/SearchIntentBuilder;->build()Landroid/content/Intent;

    move-result-object v6

    .line 143
    .local v6, "searchIntent":Landroid/content/Intent;
    invoke-static {v0, v6}, Lcom/amazon/mShop/util/ActivityUtils;->startSearchActivity(Lcom/amazon/mShop/AmazonActivity;Landroid/content/Intent;)Z

    move-result v7

    return v7
.end method

.method protected handleViewCart(Landroid/net/Uri;Landroid/content/Context;)Z
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 212
    const-string/jumbo v0, "crt_html_nav"

    invoke-static {v0}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 214
    invoke-static {p2}, Lcom/amazon/mShop/util/ActivityUtils;->startCartActivity(Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method protected handleViewOrder(Landroid/net/Uri;Landroid/content/Context;)Z
    .locals 4
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 186
    const/4 v0, 0x0

    .line 187
    .local v0, "orderId":Ljava/lang/String;
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Landroid/net/Uri;->isHierarchical()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 188
    const-string/jumbo v1, "order-id"

    invoke-virtual {p1, v1}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 190
    :cond_0
    const-string/jumbo v1, "order_to_view"

    const/4 v2, 0x0

    const/4 v3, -0x1

    invoke-static {p2, v0, v1, v2, v3}, Lcom/amazon/mShop/util/ActivityUtils;->startYourOrdersActivity(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Z

    move-result v1

    return v1
.end method

.method protected handleViewWishlist(Landroid/net/Uri;Landroid/content/Context;)Z
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 220
    const-string/jumbo v0, "wl_html_nav"

    invoke-static {v0}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 221
    invoke-static {p2}, Lcom/amazon/mShop/util/ActivityUtils;->startWishListActivity(Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method protected handleWebView(Landroid/net/Uri;Landroid/content/Context;)Z
    .locals 3
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 153
    new-instance v0, Landroid/content/Intent;

    const-class v2, Lcom/amazon/mShop/web/MShopWebActivity;

    invoke-direct {v0, p2, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 154
    .local v0, "intent":Landroid/content/Intent;
    const-string/jumbo v2, "url"

    invoke-virtual {p1, v2}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 155
    .local v1, "url":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mobile/mash/constants/WebConstants;->getWebViewUrlKey()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 156
    invoke-virtual {p2, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 157
    const/4 v2, 0x1

    return v2
.end method

.method protected handleYourAccount(Landroid/net/Uri;Landroid/content/Context;)Z
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 170
    invoke-static {p2}, Lcom/amazon/mShop/util/ActivityUtils;->startYourAccountActivity(Landroid/content/Context;)Z

    move-result v0

    return v0
.end method
