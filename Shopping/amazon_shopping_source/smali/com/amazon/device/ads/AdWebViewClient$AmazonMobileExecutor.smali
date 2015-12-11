.class Lcom/amazon/device/ads/AdWebViewClient$AmazonMobileExecutor;
.super Ljava/lang/Object;
.source "AdWebViewClient.java"

# interfaces
.implements Lcom/amazon/device/ads/AdWebViewClient$UrlExecutor;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/device/ads/AdWebViewClient;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "AmazonMobileExecutor"
.end annotation


# instance fields
.field private final adView:Lcom/amazon/device/ads/AdView;

.field private final context:Landroid/content/Context;


# direct methods
.method constructor <init>(Lcom/amazon/device/ads/AdView;Landroid/content/Context;)V
    .locals 0
    .param p1, "adView"    # Lcom/amazon/device/ads/AdView;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 254
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 255
    iput-object p1, p0, Lcom/amazon/device/ads/AdWebViewClient$AmazonMobileExecutor;->adView:Lcom/amazon/device/ads/AdView;

    .line 256
    iput-object p2, p0, Lcom/amazon/device/ads/AdWebViewClient$AmazonMobileExecutor;->context:Landroid/content/Context;

    .line 257
    return-void
.end method


# virtual methods
.method public execute(Ljava/lang/String;)Z
    .locals 1
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 262
    invoke-virtual {p0, p1}, Lcom/amazon/device/ads/AdWebViewClient$AmazonMobileExecutor;->specialUrlClicked(Ljava/lang/String;)V

    .line 263
    const/4 v0, 0x1

    return v0
.end method

.method protected handleApplicationDefinedSpecialURL(Ljava/lang/String;)V
    .locals 4
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 368
    # getter for: Lcom/amazon/device/ads/AdWebViewClient;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/device/ads/AdWebViewClient;->access$100()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "Special url clicked, but was not handled by SDK. Url: %s"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p1, v2, v3

    invoke-static {v0, v1, v2}, Lcom/amazon/device/ads/Log;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 369
    return-void
.end method

.method protected launchExternalActivity(Ljava/lang/String;)Z
    .locals 6
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 380
    new-instance v2, Landroid/content/Intent;

    invoke-direct {v2}, Landroid/content/Intent;-><init>()V

    .line 381
    .local v2, "intent":Landroid/content/Intent;
    const-string/jumbo v5, "intent:"

    invoke-virtual {p1, v5}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 386
    const/4 v5, 0x1

    :try_start_0
    invoke-static {p1, v5}, Landroid/content/Intent;->parseUri(Ljava/lang/String;I)Landroid/content/Intent;
    :try_end_0
    .catch Ljava/net/URISyntaxException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    .line 400
    :goto_0
    :try_start_1
    const-string/jumbo v5, "android.intent.action.VIEW"

    invoke-virtual {v2, v5}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 401
    const/high16 v5, 0x10000000

    invoke-virtual {v2, v5}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 402
    iget-object v5, p0, Lcom/amazon/device/ads/AdWebViewClient$AmazonMobileExecutor;->context:Landroid/content/Context;

    invoke-virtual {v5, v2}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    :try_end_1
    .catch Landroid/content/ActivityNotFoundException; {:try_start_1 .. :try_end_1} :catch_1

    move v3, v4

    .line 407
    :goto_1
    return v3

    .line 388
    :catch_0
    move-exception v0

    .line 390
    .local v0, "e":Ljava/net/URISyntaxException;
    goto :goto_1

    .line 396
    .end local v0    # "e":Ljava/net/URISyntaxException;
    :cond_0
    invoke-static {p1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v5

    invoke-virtual {v2, v5}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    goto :goto_0

    .line 405
    :catch_1
    move-exception v1

    .line 407
    .local v1, "exe":Landroid/content/ActivityNotFoundException;
    goto :goto_1
.end method

.method public specialUrlClicked(Ljava/lang/String;)V
    .locals 10
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 283
    iget-object v8, p0, Lcom/amazon/device/ads/AdWebViewClient$AmazonMobileExecutor;->adView:Lcom/amazon/device/ads/AdView;

    if-eqz v8, :cond_0

    iget-object v8, p0, Lcom/amazon/device/ads/AdWebViewClient$AmazonMobileExecutor;->adView:Lcom/amazon/device/ads/AdView;

    invoke-interface {v8}, Lcom/amazon/device/ads/AdView;->isAdViewRenderable()Z

    move-result v8

    if-nez v8, :cond_2

    .line 285
    :cond_0
    # getter for: Lcom/amazon/device/ads/AdWebViewClient;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/device/ads/AdWebViewClient;->access$100()Ljava/lang/String;

    move-result-object v8

    const-string/jumbo v9, "AdView is Null"

    invoke-static {v8, v9}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 356
    :cond_1
    :goto_0
    return-void

    .line 288
    :cond_2
    # getter for: Lcom/amazon/device/ads/AdWebViewClient;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/device/ads/AdWebViewClient;->access$100()Ljava/lang/String;

    move-result-object v8

    const-string/jumbo v9, "Executing AmazonMobile Intent"

    invoke-static {v8, v9}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 289
    invoke-static {p1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v7

    .line 290
    .local v7, "uri":Landroid/net/Uri;
    const/4 v5, 0x0

    .line 293
    .local v5, "intents":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :try_start_0
    const-string/jumbo v8, "intent"

    invoke-virtual {v7, v8}, Landroid/net/Uri;->getQueryParameters(Ljava/lang/String;)Ljava/util/List;
    :try_end_0
    .catch Ljava/lang/UnsupportedOperationException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v5

    .line 299
    :goto_1
    if-eqz v5, :cond_5

    invoke-interface {v5}, Ljava/util/List;->size()I

    move-result v8

    if-lez v8, :cond_5

    .line 301
    invoke-interface {v5}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :cond_3
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_4

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    .line 303
    .local v4, "intent":Ljava/lang/String;
    invoke-virtual {p0, v4}, Lcom/amazon/device/ads/AdWebViewClient$AmazonMobileExecutor;->launchExternalActivity(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_3

    goto :goto_0

    .line 295
    .end local v3    # "i$":Ljava/util/Iterator;
    .end local v4    # "intent":Ljava/lang/String;
    :catch_0
    move-exception v2

    .line 297
    .local v2, "e":Ljava/lang/UnsupportedOperationException;
    const/4 v5, 0x0

    goto :goto_1

    .line 310
    .end local v2    # "e":Ljava/lang/UnsupportedOperationException;
    .restart local v3    # "i$":Ljava/util/Iterator;
    :cond_4
    invoke-virtual {p0, p1}, Lcom/amazon/device/ads/AdWebViewClient$AmazonMobileExecutor;->handleApplicationDefinedSpecialURL(Ljava/lang/String;)V

    goto :goto_0

    .line 312
    .end local v3    # "i$":Ljava/util/Iterator;
    :cond_5
    iget-object v8, p0, Lcom/amazon/device/ads/AdWebViewClient$AmazonMobileExecutor;->context:Landroid/content/Context;

    invoke-static {v8}, Lcom/amazon/device/ads/AmazonDeviceLauncher;->isWindowshopPresent(Landroid/content/Context;)Z

    move-result v8

    if-eqz v8, :cond_8

    .line 314
    invoke-virtual {v7}, Landroid/net/Uri;->getHost()Ljava/lang/String;

    move-result-object v8

    const-string/jumbo v9, "shopping"

    invoke-virtual {v8, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_1

    .line 316
    const-string/jumbo v8, "app-action"

    invoke-virtual {v7, v8}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 317
    .local v0, "action":Ljava/lang/String;
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v8

    if-eqz v8, :cond_1

    .line 321
    const-string/jumbo v8, "detail"

    invoke-virtual {v0, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_6

    .line 323
    const-string/jumbo v8, "asin"

    invoke-virtual {v7, v8}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 324
    .local v1, "asin":Ljava/lang/String;
    if-eqz v1, :cond_1

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v8

    if-eqz v8, :cond_1

    .line 328
    iget-object v8, p0, Lcom/amazon/device/ads/AdWebViewClient$AmazonMobileExecutor;->context:Landroid/content/Context;

    invoke-static {v8, v1}, Lcom/amazon/device/ads/AmazonDeviceLauncher;->launchWindowshopDetailPage(Landroid/content/Context;Ljava/lang/String;)V

    goto :goto_0

    .line 330
    .end local v1    # "asin":Ljava/lang/String;
    :cond_6
    const-string/jumbo v8, "search"

    invoke-virtual {v0, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_7

    .line 332
    const-string/jumbo v8, "keyword"

    invoke-virtual {v7, v8}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 333
    .local v6, "keyword":Ljava/lang/String;
    if-eqz v6, :cond_1

    invoke-virtual {v6}, Ljava/lang/String;->length()I

    move-result v8

    if-eqz v8, :cond_1

    .line 337
    iget-object v8, p0, Lcom/amazon/device/ads/AdWebViewClient$AmazonMobileExecutor;->context:Landroid/content/Context;

    invoke-static {v8, v6}, Lcom/amazon/device/ads/AmazonDeviceLauncher;->launchWindowshopSearchPage(Landroid/content/Context;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 339
    .end local v6    # "keyword":Ljava/lang/String;
    :cond_7
    const-string/jumbo v8, "webview"

    invoke-virtual {v0, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_1

    .line 348
    invoke-virtual {p0, p1}, Lcom/amazon/device/ads/AdWebViewClient$AmazonMobileExecutor;->handleApplicationDefinedSpecialURL(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 354
    .end local v0    # "action":Ljava/lang/String;
    :cond_8
    invoke-virtual {p0, p1}, Lcom/amazon/device/ads/AdWebViewClient$AmazonMobileExecutor;->handleApplicationDefinedSpecialURL(Ljava/lang/String;)V

    goto/16 :goto_0
.end method
