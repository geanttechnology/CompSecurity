.class public Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;
.super Ljava/lang/Object;
.source "MASHNavDelegateImpl.java"

# interfaces
.implements Lcom/amazon/mobile/mash/nav/MASHNavDelegate;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$1;,
        Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    return-void
.end method

.method private handleAppAction(Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;Landroid/net/Uri;Landroid/content/Context;)Z
    .locals 2
    .param p1, "action"    # Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;
    .param p2, "uri"    # Landroid/net/Uri;
    .param p3, "context"    # Landroid/content/Context;

    .prologue
    .line 139
    sget-object v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$1;->$SwitchMap$com$amazon$mobile$mash$nav$MASHNavDelegateImpl$Action:[I

    invoke-virtual {p1}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 215
    const/4 v0, 0x0

    :goto_0
    return v0

    .line 141
    :pswitch_0
    invoke-virtual {p0, p2, p3}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleAddToCart(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    goto :goto_0

    .line 143
    :pswitch_1
    invoke-virtual {p0, p2, p3}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleAddToWishlist(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    goto :goto_0

    .line 145
    :pswitch_2
    invoke-virtual {p0, p2, p3}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleBrowse(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    goto :goto_0

    .line 147
    :pswitch_3
    invoke-virtual {p0, p2, p3}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleBrowseHistory(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    goto :goto_0

    .line 149
    :pswitch_4
    invoke-virtual {p0, p2, p3}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleBrowserView(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    goto :goto_0

    .line 151
    :pswitch_5
    invoke-virtual {p0, p2, p3}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleBuyNow(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    goto :goto_0

    .line 153
    :pswitch_6
    invoke-virtual {p0, p2, p3}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleCancelOrder(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    goto :goto_0

    .line 155
    :pswitch_7
    invoke-virtual {p0, p2, p3}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleCheckout(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    goto :goto_0

    .line 157
    :pswitch_8
    invoke-virtual {p0, p2, p3}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleDealPage(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    goto :goto_0

    .line 159
    :pswitch_9
    invoke-virtual {p0, p2, p3}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleDeals(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    goto :goto_0

    .line 161
    :pswitch_a
    invoke-virtual {p0, p2, p3}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleDetailPage(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    goto :goto_0

    .line 163
    :pswitch_b
    invoke-virtual {p0, p2, p3}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleExternal(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    goto :goto_0

    .line 165
    :pswitch_c
    invoke-virtual {p0, p2, p3}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleFriendApp(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    goto :goto_0

    .line 167
    :pswitch_d
    invoke-virtual {p0, p2, p3}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleHome(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    goto :goto_0

    .line 169
    :pswitch_e
    invoke-virtual {p0, p2, p3}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleImageGallery(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    goto :goto_0

    .line 171
    :pswitch_f
    invoke-virtual {p0, p2, p3}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleLogin(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    goto :goto_0

    .line 173
    :pswitch_10
    invoke-virtual {p0, p2, p3}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleLogout(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    goto :goto_0

    .line 175
    :pswitch_11
    invoke-virtual {p0, p2, p3}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleMoreBuyingChoices(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    goto :goto_0

    .line 177
    :pswitch_12
    invoke-virtual {p0, p2, p3}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleOneClickSettings(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    goto :goto_0

    .line 179
    :pswitch_13
    invoke-virtual {p0, p2, p3}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleOrderHistory(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    goto :goto_0

    .line 181
    :pswitch_14
    invoke-virtual {p0, p2, p3}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handlePushNotificationSettings(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    goto :goto_0

    .line 183
    :pswitch_15
    invoke-virtual {p0, p2, p3}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleRecommendations(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    goto :goto_0

    .line 185
    :pswitch_16
    invoke-virtual {p0, p2, p3}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleScanIt(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    goto :goto_0

    .line 187
    :pswitch_17
    invoke-virtual {p0, p2, p3}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleSearch(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    goto :goto_0

    .line 189
    :pswitch_18
    invoke-virtual {p0, p2, p3}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleShare(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    goto :goto_0

    .line 191
    :pswitch_19
    invoke-virtual {p0, p2, p3}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleSnapIt(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    goto/16 :goto_0

    .line 193
    :pswitch_1a
    invoke-virtual {p0, p2, p3}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleTrackOrder(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    goto/16 :goto_0

    .line 195
    :pswitch_1b
    invoke-virtual {p0, p2, p3}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleUpdateCart(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    goto/16 :goto_0

    .line 197
    :pswitch_1c
    invoke-virtual {p0, p2, p3}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleVideo(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    goto/16 :goto_0

    .line 199
    :pswitch_1d
    invoke-virtual {p0, p2, p3}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleViewCart(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    goto/16 :goto_0

    .line 201
    :pswitch_1e
    invoke-virtual {p0, p2, p3}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleViewOrder(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    goto/16 :goto_0

    .line 203
    :pswitch_1f
    invoke-virtual {p0, p2, p3}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleViewWishlist(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    goto/16 :goto_0

    .line 205
    :pswitch_20
    invoke-virtual {p0, p2, p3}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleYourAccount(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    goto/16 :goto_0

    .line 207
    :pswitch_21
    invoke-virtual {p0, p2, p3}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleAddOnInterstitial(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    goto/16 :goto_0

    .line 209
    :pswitch_22
    invoke-virtual {p0, p2, p3}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleMobileAdsUserPreferences(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    goto/16 :goto_0

    .line 211
    :pswitch_23
    invoke-virtual {p0, p2, p3}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleWebView(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    goto/16 :goto_0

    .line 213
    :pswitch_24
    invoke-virtual {p0, p2, p3}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleGoBack(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    goto/16 :goto_0

    .line 139
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
        :pswitch_8
        :pswitch_9
        :pswitch_a
        :pswitch_b
        :pswitch_c
        :pswitch_d
        :pswitch_e
        :pswitch_f
        :pswitch_10
        :pswitch_11
        :pswitch_12
        :pswitch_13
        :pswitch_14
        :pswitch_15
        :pswitch_16
        :pswitch_17
        :pswitch_18
        :pswitch_19
        :pswitch_1a
        :pswitch_1b
        :pswitch_1c
        :pswitch_1d
        :pswitch_1e
        :pswitch_1f
        :pswitch_20
        :pswitch_21
        :pswitch_22
        :pswitch_23
        :pswitch_24
    .end packed-switch
.end method


# virtual methods
.method protected handleAddOnInterstitial(Landroid/net/Uri;Landroid/content/Context;)Z
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 654
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->unsupportedAction(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method protected handleAddToCart(Landroid/net/Uri;Landroid/content/Context;)Z
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 283
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleDefault(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method protected handleAddToWishlist(Landroid/net/Uri;Landroid/content/Context;)Z
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 295
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleDefault(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method protected handleAmznappScheme(Landroid/content/Context;Landroid/net/Uri;)Z
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "uri"    # Landroid/net/Uri;

    .prologue
    .line 720
    const/4 v0, 0x0

    return v0
.end method

.method protected handleBrowse(Landroid/net/Uri;Landroid/content/Context;)Z
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 307
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleDefault(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method protected handleBrowseHistory(Landroid/net/Uri;Landroid/content/Context;)Z
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 319
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleDefault(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method protected handleBrowserView(Landroid/net/Uri;Landroid/content/Context;)Z
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 330
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleDefault(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method protected handleBuyNow(Landroid/net/Uri;Landroid/content/Context;)Z
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 344
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleDefault(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method protected handleCancelOrder(Landroid/net/Uri;Landroid/content/Context;)Z
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 356
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleDefault(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method protected handleCheckout(Landroid/net/Uri;Landroid/content/Context;)Z
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 367
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleDefault(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method protected handleDealPage(Landroid/net/Uri;Landroid/content/Context;)Z
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 379
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleDefault(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method protected handleDeals(Landroid/net/Uri;Landroid/content/Context;)Z
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 391
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleDefault(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method protected handleDefault(Landroid/net/Uri;Landroid/content/Context;)Z
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 742
    const/4 v0, 0x0

    return v0
.end method

.method protected handleDetailPage(Landroid/net/Uri;Landroid/content/Context;)Z
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 403
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleDefault(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method protected handleDigitalStore(Landroid/net/Uri;Landroid/content/Context;)Z
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 708
    const/4 v0, 0x0

    return v0
.end method

.method protected handleExternal(Landroid/net/Uri;Landroid/content/Context;)Z
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 415
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleDefault(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method protected handleFriendApp(Landroid/net/Uri;Landroid/content/Context;)Z
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 427
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleDefault(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method protected handleGoBack(Landroid/net/Uri;Landroid/content/Context;)Z
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 686
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleDefault(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method protected handleHome(Landroid/net/Uri;Landroid/content/Context;)Z
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 271
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleDefault(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method protected handleImageGallery(Landroid/net/Uri;Landroid/content/Context;)Z
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 439
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleDefault(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method protected handleIntent(Landroid/net/Uri;Landroid/content/Context;)Z
    .locals 4
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/net/URISyntaxException;
        }
    .end annotation

    .prologue
    const/4 v3, 0x1

    .line 232
    invoke-virtual {p1}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2, v3}, Landroid/content/Intent;->parseUri(Ljava/lang/String;I)Landroid/content/Intent;

    move-result-object v0

    .line 233
    .local v0, "intent":Landroid/content/Intent;
    invoke-virtual {p2}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v1

    .line 234
    .local v1, "pm":Landroid/content/pm/PackageManager;
    const/high16 v2, 0x10000

    invoke-virtual {v1, v0, v2}, Landroid/content/pm/PackageManager;->resolveActivity(Landroid/content/Intent;I)Landroid/content/pm/ResolveInfo;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 235
    invoke-virtual {p2, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 237
    :cond_0
    return v3
.end method

.method protected handleLogin(Landroid/net/Uri;Landroid/content/Context;)Z
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 451
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleDefault(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method protected handleLogout(Landroid/net/Uri;Landroid/content/Context;)Z
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 463
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleDefault(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method protected handleMobileAdsUserPreferences(Landroid/net/Uri;Landroid/content/Context;)Z
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 665
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->unsupportedAction(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method protected handleModal(Landroid/net/Uri;Landroid/content/Context;)Z
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 248
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->unsupportedAction(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method protected handleMoreBuyingChoices(Landroid/net/Uri;Landroid/content/Context;)Z
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 475
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleDefault(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method protected handleOneClickSettings(Landroid/net/Uri;Landroid/content/Context;)Z
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 486
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleDefault(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method protected handleOrderHistory(Landroid/net/Uri;Landroid/content/Context;)Z
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 498
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleDefault(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method protected handlePushNotificationSettings(Landroid/net/Uri;Landroid/content/Context;)Z
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 697
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleDefault(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method protected handleRecommendations(Landroid/net/Uri;Landroid/content/Context;)Z
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 510
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleDefault(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method protected handleScanIt(Landroid/net/Uri;Landroid/content/Context;)Z
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 522
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->unsupportedAction(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method protected handleSearch(Landroid/net/Uri;Landroid/content/Context;)Z
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 534
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleDefault(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method protected handleShare(Landroid/net/Uri;Landroid/content/Context;)Z
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 546
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleDefault(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method protected handleSnapIt(Landroid/net/Uri;Landroid/content/Context;)Z
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 558
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->unsupportedAction(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method protected handleTrackOrder(Landroid/net/Uri;Landroid/content/Context;)Z
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 570
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleDefault(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method protected handleUpdateCart(Landroid/net/Uri;Landroid/content/Context;)Z
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 593
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleDefault(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method protected handleVideo(Landroid/net/Uri;Landroid/content/Context;)Z
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 582
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleDefault(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method protected handleViewCart(Landroid/net/Uri;Landroid/content/Context;)Z
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 606
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleDefault(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method protected handleViewOrder(Landroid/net/Uri;Landroid/content/Context;)Z
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 618
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleDefault(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method protected handleViewWishlist(Landroid/net/Uri;Landroid/content/Context;)Z
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 630
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleDefault(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method protected handleWebView(Landroid/net/Uri;Landroid/content/Context;)Z
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 676
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->unsupportedAction(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method protected handleYourAccount(Landroid/net/Uri;Landroid/content/Context;)Z
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 642
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleDefault(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method public navigate(Ljava/lang/String;Landroid/content/Context;)Z
    .locals 11
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    const/4 v7, 0x0

    .line 85
    invoke-static {p1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v6

    .line 86
    .local v6, "uri":Landroid/net/Uri;
    invoke-virtual {v6}, Landroid/net/Uri;->getScheme()Ljava/lang/String;

    move-result-object v5

    .line 88
    .local v5, "scheme":Ljava/lang/String;
    if-eqz p2, :cond_0

    if-nez v5, :cond_1

    .line 131
    :cond_0
    :goto_0
    return v7

    .line 92
    :cond_1
    const-string/jumbo v8, "intent"

    invoke-virtual {v8, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_2

    .line 94
    :try_start_0
    invoke-virtual {p0, v6, p2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleIntent(Landroid/net/Uri;Landroid/content/Context;)Z
    :try_end_0
    .catch Ljava/net/URISyntaxException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v7

    goto :goto_0

    .line 95
    :catch_0
    move-exception v2

    .line 96
    .local v2, "e":Ljava/net/URISyntaxException;
    goto :goto_0

    .line 102
    .end local v2    # "e":Ljava/net/URISyntaxException;
    :cond_2
    invoke-virtual {v6}, Landroid/net/Uri;->isHierarchical()Z

    move-result v8

    if-eqz v8, :cond_0

    .line 106
    const-string/jumbo v8, "amznapp"

    invoke-virtual {v8, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_3

    .line 107
    invoke-virtual {p0, p2, v6}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleAmznappScheme(Landroid/content/Context;Landroid/net/Uri;)Z

    move-result v7

    goto :goto_0

    .line 110
    :cond_3
    invoke-virtual {v6}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v4

    .line 111
    .local v4, "path":Ljava/lang/String;
    invoke-static {v4}, Lcom/amazon/mobile/mash/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_4

    const-string/jumbo v8, "/ap/signin"

    invoke-virtual {v4, v8}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v8

    if-eqz v8, :cond_4

    .line 112
    invoke-virtual {p0, v6, p2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleLogin(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v7

    goto :goto_0

    .line 115
    :cond_4
    const-string/jumbo v8, "app-nav-type"

    invoke-virtual {v6, v8}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 116
    .local v3, "navType":Ljava/lang/String;
    const-string/jumbo v8, "modal"

    invoke-virtual {v8, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_5

    .line 117
    invoke-virtual {p0, v6, p2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleModal(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v7

    goto :goto_0

    .line 120
    :cond_5
    const-string/jumbo v8, "app-action"

    invoke-virtual {v6, v8}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 121
    .local v1, "appAction":Ljava/lang/String;
    invoke-static {v1}, Lcom/amazon/mobile/mash/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_6

    .line 123
    :try_start_1
    sget-object v8, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {v1, v8}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v8

    const-string/jumbo v9, "-"

    const-string/jumbo v10, "_"

    invoke-virtual {v8, v9, v10}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->valueOf(Ljava/lang/String;)Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    move-result-object v0

    .line 124
    .local v0, "action":Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;
    invoke-direct {p0, v0, v6, p2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleAppAction(Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;Landroid/net/Uri;Landroid/content/Context;)Z
    :try_end_1
    .catch Ljava/lang/IllegalArgumentException; {:try_start_1 .. :try_end_1} :catch_1

    move-result v7

    goto :goto_0

    .line 125
    .end local v0    # "action":Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;
    :catch_1
    move-exception v2

    .line 127
    .local v2, "e":Ljava/lang/IllegalArgumentException;
    goto :goto_0

    .line 131
    .end local v2    # "e":Ljava/lang/IllegalArgumentException;
    :cond_6
    invoke-virtual {p0, v6, p2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;->handleDigitalStore(Landroid/net/Uri;Landroid/content/Context;)Z

    move-result v7

    goto :goto_0
.end method

.method protected unsupportedAction(Landroid/net/Uri;Landroid/content/Context;)Z
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 731
    const/4 v0, 0x0

    return v0
.end method
