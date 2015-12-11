.class Lcom/bestbuy/android/bbyobjects/BBYWebView$2;
.super Landroid/webkit/WebViewClient;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/bestbuy/android/bbyobjects/BBYWebView;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/bbyobjects/BBYWebView;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/bbyobjects/BBYWebView;)V
    .locals 0

    .prologue
    .line 180
    iput-object p1, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-direct {p0}, Landroid/webkit/WebViewClient;-><init>()V

    return-void
.end method


# virtual methods
.method public onFormResubmission(Landroid/webkit/WebView;Landroid/os/Message;Landroid/os/Message;)V
    .locals 0

    .prologue
    .line 184
    invoke-virtual {p3}, Landroid/os/Message;->sendToTarget()V

    .line 185
    return-void
.end method

.method public onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 427
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->h(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Lnu;

    move-result-object v0

    invoke-virtual {v0}, Lnu;->eventBusRegister()V

    .line 428
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->h(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Lnu;

    move-result-object v0

    invoke-virtual {v0}, Lnu;->orderEventBusRegister()V

    .line 429
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->h(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Lnu;

    move-result-object v0

    invoke-virtual {v0}, Lnu;->executeMainCSS()V

    .line 430
    const-string v0, "profile/orders"

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 431
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->h(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Lnu;

    move-result-object v0

    invoke-virtual {v0}, Lnu;->orderStatusCSS()V

    .line 433
    :cond_0
    const-string v0, "deals.bestbuy.com/"

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 434
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->h(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Lnu;

    move-result-object v0

    invoke-virtual {v0}, Lnu;->weeklyAdCSS()V

    .line 437
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->d(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    move-result-object v0

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->d(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->d(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->j()Z

    move-result v0

    if-nez v0, :cond_4

    .line 438
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->h(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Lnu;

    move-result-object v0

    const-string v1, ".bestbuy.com"

    const-string v2, "ut"

    invoke-virtual {v0, v1, v2}, Lnu;->a(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 439
    if-eqz v0, :cond_4

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_4

    .line 440
    iget-object v1, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v1}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->h(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Lnu;

    move-result-object v1

    const-string v2, "https://www-ssl.bestbuy.com/identity/status"

    const-string v3, "at"

    invoke-virtual {v1, v2, v3}, Lnu;->a(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 441
    if-eqz v1, :cond_4

    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_4

    .line 442
    invoke-static {}, Lfr;->b()Ljava/lang/String;

    move-result-object v2

    .line 443
    if-eqz v2, :cond_2

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_4

    .line 444
    :cond_2
    iget-object v3, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v3}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->i(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Lnb;

    move-result-object v3

    invoke-virtual {v3, v4}, Lnb;->d(Z)V

    .line 445
    if-nez v2, :cond_3

    .line 446
    iget-object v2, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v2}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->h(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Lnu;

    move-result-object v2

    const-string v3, ".bestbuy.com"

    invoke-virtual {v2, v3}, Lnu;->updateCartCount(Ljava/lang/String;)V

    .line 447
    :cond_3
    iget-object v2, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v2}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->d(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    move-result-object v2

    invoke-virtual {v2, v0, v1}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 448
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->d(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    move-result-object v0

    invoke-virtual {v0, v4}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->a(Z)V

    .line 455
    :cond_4
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->j(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 456
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->h(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Lnu;

    move-result-object v0

    const-string v1, ".bestbuy.com"

    invoke-virtual {v0, v1}, Lnu;->updateCartCount(Ljava/lang/String;)V

    .line 457
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->c(Lcom/bestbuy/android/bbyobjects/BBYWebView;Z)Z

    .line 460
    :cond_5
    invoke-super {p0, p1, p2}, Landroid/webkit/WebViewClient;->onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V

    .line 461
    const-string v0, "#"

    invoke-virtual {p2, v0}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 479
    :goto_0
    return-void

    .line 464
    :cond_6
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/app/Activity;

    move-result-object v0

    const v1, 0x7f080238

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_7

    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/app/Activity;

    move-result-object v0

    const v1, 0x7f0800f6

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_7

    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/app/Activity;

    move-result-object v0

    const v1, 0x7f0801e6

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_7

    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/app/Activity;

    move-result-object v0

    const v1, 0x7f0801da

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_7

    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/app/Activity;

    move-result-object v0

    const v1, 0x7f08037e

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_8

    .line 465
    :cond_7
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-virtual {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/webkit/WebSettings;->setLoadWithOverviewMode(Z)V

    .line 466
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-virtual {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/webkit/WebSettings;->setUseWideViewPort(Z)V

    .line 467
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-virtual {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/webkit/WebSettings;->setBuiltInZoomControls(Z)V

    .line 468
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-virtual {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/webkit/WebSettings;->setSupportZoom(Z)V

    .line 470
    :cond_8
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/app/Activity;

    move-result-object v0

    const v1, 0x7f08030d

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_9

    .line 471
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-virtual {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/webkit/WebSettings;->setLoadWithOverviewMode(Z)V

    .line 472
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-virtual {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/webkit/WebSettings;->setUseWideViewPort(Z)V

    .line 473
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-virtual {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/webkit/WebSettings;->setBuiltInZoomControls(Z)V

    .line 474
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-virtual {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/webkit/WebSettings;->setSupportZoom(Z)V

    .line 476
    :cond_9
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0, p2}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->c(Lcom/bestbuy/android/bbyobjects/BBYWebView;Ljava/lang/String;)Ljava/lang/String;

    .line 477
    invoke-static {}, Landroid/webkit/CookieSyncManager;->getInstance()Landroid/webkit/CookieSyncManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/webkit/CookieSyncManager;->sync()V

    .line 478
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->h(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Lnu;

    move-result-object v0

    invoke-virtual {v0}, Lnu;->executeHtmlContent()V

    goto/16 :goto_0
.end method

.method public onPageStarted(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V
    .locals 4

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x1

    .line 394
    invoke-super {p0, p1, p2, p3}, Landroid/webkit/WebViewClient;->onPageStarted(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V

    .line 395
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->b(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/view/View;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 396
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->b(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/view/View;->setVisibility(I)V

    .line 397
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->setVisibility(I)V

    .line 398
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->d(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->k()Landroid/widget/ImageView;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 400
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/app/Activity;

    move-result-object v0

    const-string v1, "input_method"

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/inputmethod/InputMethodManager;

    .line 401
    iget-object v1, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v1}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/app/Activity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/Activity;->getCurrentFocus()Landroid/view/View;

    move-result-object v1

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v1}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/app/Activity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/Activity;->getCurrentFocus()Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/View;->getWindowToken()Landroid/os/IBinder;

    move-result-object v1

    if-eqz v1, :cond_1

    .line 402
    iget-object v1, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v1}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/app/Activity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/Activity;->getCurrentFocus()Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/View;->getWindowToken()Landroid/os/IBinder;

    move-result-object v1

    invoke-virtual {v0, v1, v3}, Landroid/view/inputmethod/InputMethodManager;->hideSoftInputFromWindow(Landroid/os/IBinder;I)Z

    .line 404
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/app/Activity;

    move-result-object v0

    const v1, 0x7f08016c

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_3

    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/app/Activity;

    move-result-object v0

    const v1, 0x7f08012d

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_3

    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/app/Activity;

    move-result-object v0

    const v1, 0x7f080288

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_2

    const-string v0, "fastTrack=true"

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_2

    const-string v0, "visaCheckout=true"

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_3

    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/app/Activity;

    move-result-object v0

    const v1, 0x7f080179

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_3

    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/app/Activity;

    move-result-object v0

    const v1, 0x7f0800b7

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_3

    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/app/Activity;

    move-result-object v0

    const v1, 0x7f08035e

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_3

    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/app/Activity;

    move-result-object v0

    const v1, 0x7f080295

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_3

    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/app/Activity;

    move-result-object v0

    const v1, 0x7f080316

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_3

    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/app/Activity;

    move-result-object v0

    const v1, 0x7f080202

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_3

    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/app/Activity;

    move-result-object v0

    const v1, 0x7f080319

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_3

    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/app/Activity;

    move-result-object v0

    const v1, 0x7f0801b9

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_3

    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/app/Activity;

    move-result-object v0

    const v1, 0x7f080355

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_3

    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/app/Activity;

    move-result-object v0

    const v1, 0x7f080257

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 417
    :cond_3
    invoke-virtual {p1}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/webkit/WebSettings;->setLoadWithOverviewMode(Z)V

    .line 418
    invoke-virtual {p1}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/webkit/WebSettings;->setUseWideViewPort(Z)V

    .line 419
    invoke-virtual {p1}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/webkit/WebSettings;->setBuiltInZoomControls(Z)V

    .line 420
    invoke-virtual {p1}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/webkit/WebSettings;->setSupportZoom(Z)V

    .line 421
    const/16 v0, 0x32

    invoke-virtual {p1, v0}, Landroid/webkit/WebView;->setInitialScale(I)V

    .line 423
    :cond_4
    return-void
.end method

.method public onReceivedError(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V
    .locals 5

    .prologue
    .line 194
    const/4 v0, -0x6

    if-eq p2, v0, :cond_0

    const/4 v0, -0x2

    if-eq p2, v0, :cond_0

    const/4 v0, -0x7

    if-ne p2, v0, :cond_1

    .line 195
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/app/Activity;

    move-result-object v0

    new-instance v1, Lcom/bestbuy/android/bbyobjects/BBYWebView$2$1;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/bbyobjects/BBYWebView$2$1;-><init>(Lcom/bestbuy/android/bbyobjects/BBYWebView$2;)V

    new-instance v2, Lcom/bestbuy/android/bbyobjects/BBYWebView$2$2;

    invoke-direct {v2, p0}, Lcom/bestbuy/android/bbyobjects/BBYWebView$2$2;-><init>(Lcom/bestbuy/android/bbyobjects/BBYWebView$2;)V

    iget-object v3, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v3}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/app/Activity;

    move-result-object v3

    invoke-static {v3}, Llm;->a(Landroid/content/Context;)Z

    move-result v3

    const/4 v4, 0x0

    invoke-static {v0, v1, v2, v3, v4}, Lnm;->a(Landroid/content/Context;Lno;Lnn;ZI)V

    .line 209
    :cond_1
    return-void
.end method

.method public onReceivedSslError(Landroid/webkit/WebView;Landroid/webkit/SslErrorHandler;Landroid/net/http/SslError;)V
    .locals 0

    .prologue
    .line 189
    invoke-virtual {p2}, Landroid/webkit/SslErrorHandler;->proceed()V

    .line 190
    return-void
.end method

.method public shouldInterceptRequest(Landroid/webkit/WebView;Ljava/lang/String;)Landroid/webkit/WebResourceResponse;
    .locals 2

    .prologue
    .line 214
    .line 215
    const-string v0, "https://secure.opinionlab.com/rate40.asp"

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 217
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/app/Activity;

    move-result-object v0

    instance-of v0, v0, Lcom/bestbuy/android/activities/home/WebViewActivity;

    if-eqz v0, :cond_0

    .line 218
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/app/Activity;

    move-result-object v0

    new-instance v1, Lcom/bestbuy/android/bbyobjects/BBYWebView$2$3;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/bbyobjects/BBYWebView$2$3;-><init>(Lcom/bestbuy/android/bbyobjects/BBYWebView$2;)V

    invoke-virtual {v0, v1}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 233
    :cond_0
    invoke-super {p0, p1, p2}, Landroid/webkit/WebViewClient;->shouldInterceptRequest(Landroid/webkit/WebView;Ljava/lang/String;)Landroid/webkit/WebResourceResponse;

    move-result-object v0

    return-object v0
.end method

.method public shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z
    .locals 8

    .prologue
    const v5, 0x7f0802f3

    const v4, 0x7f0802f2

    const v2, 0x7f0800ef

    const/4 v6, 0x0

    const/4 v7, 0x1

    .line 238
    const-string v0, "https://adclick.g.doubleclick.net"

    invoke-virtual {p2, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    move v0, v6

    .line 388
    :goto_0
    return v0

    .line 241
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0, v6}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Lcom/bestbuy/android/bbyobjects/BBYWebView;Z)Z

    .line 242
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0, v6}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->b(Lcom/bestbuy/android/bbyobjects/BBYWebView;Z)Z

    .line 243
    const-string v0, ".pdf"

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 244
    new-instance v0, Lkr;

    iget-object v1, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v1}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/app/Activity;

    move-result-object v1

    invoke-direct {v0, v1, p2}, Lkr;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 245
    invoke-virtual {v0}, Lkr;->b()V

    move v0, v7

    .line 246
    goto :goto_0

    .line 248
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/app/Activity;

    move-result-object v0

    const v1, 0x7f080244

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 249
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0, v7}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Lcom/bestbuy/android/bbyobjects/BBYWebView;Z)Z

    .line 251
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/app/Activity;

    move-result-object v0

    const v1, 0x7f080289

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 252
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0, v7}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->b(Lcom/bestbuy/android/bbyobjects/BBYWebView;Z)Z

    .line 255
    :cond_3
    const-string v0, "tel:"

    invoke-virtual {p2, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 256
    invoke-virtual {p1}, Landroid/webkit/WebView;->stopLoading()V

    .line 257
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 258
    const-string v1, "android.intent.action.CALL"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 259
    invoke-static {p2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    .line 260
    iget-object v1, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v1}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/app/Activity;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    move v0, v7

    .line 261
    goto :goto_0

    .line 262
    :cond_4
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {v0, v5}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_5

    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_5

    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_c

    :cond_5
    const-string v0, "Current+Offers"

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_6

    const-string v0, "All+Categories"

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_c

    .line 266
    :cond_6
    const-string v3, ""

    .line 267
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {v0, v5}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_8

    .line 268
    const-string v0, "st="

    invoke-virtual {p2, v0}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v0

    add-int/lit8 v0, v0, 0x3

    const-string v1, "_mpromo"

    invoke-virtual {p2, v1}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v1

    invoke-virtual {p2, v0, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    .line 275
    :cond_7
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->c(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Z

    move-result v0

    if-eqz v0, :cond_a

    .line 276
    new-instance v0, Liu;

    iget-object v1, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v1}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/app/Activity;

    move-result-object v1

    iget-object v2, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v2}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->d(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    move-result-object v2

    iget-object v4, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v4}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->b(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/view/View;

    move-result-object v4

    iget-object v5, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-direct/range {v0 .. v5}, Liu;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Ljava/lang/String;Landroid/view/View;Lcom/bestbuy/android/bbyobjects/BBYWebView;)V

    .line 277
    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    new-array v2, v6, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Liu;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    move v0, v7

    .line 283
    goto/16 :goto_0

    .line 269
    :cond_8
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_9

    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/app/Activity;

    move-result-object v0

    const v1, 0x7f0801c9

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_9

    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_7

    .line 272
    :cond_9
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "&appvi="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v1

    invoke-virtual {v1}, Lnb;->r()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move v0, v6

    .line 273
    goto/16 :goto_0

    .line 279
    :cond_a
    const-string v0, "file:///android_asset/"

    invoke-virtual {p2, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_b

    .line 280
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "&appvi="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v1

    invoke-virtual {v1}, Lnb;->r()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    :cond_b
    move v0, v6

    .line 281
    goto/16 :goto_0

    .line 284
    :cond_c
    const-string v0, "mailto:"

    invoke-virtual {p2, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_d

    .line 285
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.VIEW"

    invoke-static {p2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 286
    iget-object v1, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v1}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/app/Activity;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    move v0, v7

    .line 287
    goto/16 :goto_0

    .line 288
    :cond_d
    const-string v0, "market://"

    invoke-virtual {p2, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_e

    .line 289
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.VIEW"

    invoke-static {p2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 290
    iget-object v1, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v1}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/app/Activity;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    move v0, v7

    .line 291
    goto/16 :goto_0

    .line 292
    :cond_e
    const-string v0, "youtube.com"

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_f

    const-string v0, "watch?"

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_f

    .line 293
    const-string v0, "v="

    invoke-virtual {p2, v0}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v0

    add-int/lit8 v0, v0, 0x2

    const-string v1, "v="

    invoke-virtual {p2, v1}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v1

    add-int/lit8 v1, v1, 0xd

    invoke-virtual {p2, v0, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    .line 294
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "vnd.youtube:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 295
    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    .line 296
    new-instance v1, Landroid/content/Intent;

    const-string v2, "android.intent.action.VIEW"

    invoke-direct {v1, v2, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 297
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    .line 298
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Activity;->finish()V

    move v0, v7

    .line 299
    goto/16 :goto_0

    .line 300
    :cond_f
    const-string v0, "geo:"

    invoke-virtual {p2, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_10

    .line 301
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.VIEW"

    invoke-static {p2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 302
    iget-object v1, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v1}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/app/Activity;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    move v0, v7

    .line 303
    goto/16 :goto_0

    .line 304
    :cond_10
    const-string v0, "http://wiki.github.com"

    invoke-virtual {p2, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_11

    .line 305
    invoke-static {p2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    .line 306
    new-instance v1, Landroid/content/Intent;

    const-string v2, "android.intent.action.VIEW"

    invoke-direct {v1, v2, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 307
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    move v0, v7

    .line 308
    goto/16 :goto_0

    .line 309
    :cond_11
    const-string v0, ".jsp"

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_12

    :cond_12
    const-string v0, "index.jsp"

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_13

    .line 310
    invoke-virtual {p1}, Landroid/webkit/WebView;->stopLoading()V

    move v0, v7

    .line 311
    goto/16 :goto_0

    .line 312
    :cond_13
    const-string v0, "browse.jsp?refreshSearch=true&id"

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_14

    .line 313
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    const-string v1, "browse.jsp?refreshSearch=true&id"

    const-string v2, "browse.jsp?refreshSearch=true&catid"

    invoke-virtual {p2, v1, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Lcom/bestbuy/android/bbyobjects/BBYWebView;Ljava/lang/String;)V

    move v0, v7

    .line 314
    goto/16 :goto_0

    .line 315
    :cond_14
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/app/Activity;

    move-result-object v0

    const v1, 0x7f08021d

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_16

    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/app/Activity;

    move-result-object v0

    const v1, 0x7f080176

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_16

    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/app/Activity;

    move-result-object v0

    const v1, 0x7f080175

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_15

    const-string v0, ".p?"

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1c

    :cond_15
    const-string v0, "skuId"

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1c

    const-string v0, "olstemplatemapper.jsp"

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1c

    .line 317
    :cond_16
    invoke-static {p2}, Ljava/net/URI;->create(Ljava/lang/String;)Ljava/net/URI;

    move-result-object v0

    const-string v1, "UTF-8"

    invoke-static {v0, v1}, Lorg/apache/http/client/utils/URLEncodedUtils;->parse(Ljava/net/URI;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 318
    const-string v1, "olspage.jsp"

    invoke-virtual {p2, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_17

    const-string v1, "listflag=true&pageMode=searchmode"

    invoke-virtual {p2, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_17

    move v0, v6

    .line 319
    goto/16 :goto_0

    .line 320
    :cond_17
    iget-object v1, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v1}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->e(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Z

    move-result v1

    if-eqz v1, :cond_19

    .line 321
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0, v6}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->b(Lcom/bestbuy/android/bbyobjects/BBYWebView;Z)Z

    .line 322
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->d(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/BaseTabContainer;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/BaseTabContainer;->a_()V

    :cond_18
    :goto_1
    move v0, v7

    .line 347
    goto/16 :goto_0

    .line 323
    :cond_19
    const-string v1, "dnmId"

    invoke-virtual {p2, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1a

    const-string v1, "dt"

    invoke-virtual {p2, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1a

    move v0, v6

    .line 337
    goto/16 :goto_0

    .line 339
    :cond_1a
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_1b
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_18

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/apache/http/NameValuePair;

    .line 340
    invoke-interface {v0}, Lorg/apache/http/NameValuePair;->getName()Ljava/lang/String;

    move-result-object v2

    const-string v3, "skuId"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1b

    .line 341
    invoke-interface {v0}, Lorg/apache/http/NameValuePair;->getValue()Ljava/lang/String;

    move-result-object v1

    .line 342
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/app/Activity;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v2, ""

    invoke-virtual {v0, v1, v2, v7}, Lcom/bestbuy/android/activities/home/HomeActivity;->openPDP(Ljava/lang/String;Ljava/lang/String;Z)V

    goto :goto_1

    .line 348
    :cond_1c
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/app/Activity;

    move-result-object v0

    const v1, 0x7f080286

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1d

    .line 349
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->d(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->a(Landroid/webkit/WebView;)V

    .line 350
    invoke-virtual {p1}, Landroid/webkit/WebView;->reload()V

    move v0, v7

    .line 351
    goto/16 :goto_0

    .line 352
    :cond_1d
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/app/Activity;

    move-result-object v0

    const v1, 0x7f080123

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1e

    .line 353
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0, p2}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->b(Lcom/bestbuy/android/bbyobjects/BBYWebView;Ljava/lang/String;)V

    move v0, v7

    .line 354
    goto/16 :goto_0

    .line 355
    :cond_1e
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/app/Activity;

    move-result-object v0

    const v1, 0x7f08021b

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1f

    .line 356
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/app/Activity;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->popCurrentFragment()V

    move v0, v7

    .line 357
    goto/16 :goto_0

    .line 358
    :cond_1f
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/app/Activity;

    move-result-object v0

    const v1, 0x7f08022e

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_22

    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/app/Activity;

    move-result-object v0

    const v1, 0x7f0802a3

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_22

    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/app/Activity;

    move-result-object v0

    const v1, 0x7f0802a4

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_22

    .line 361
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->f(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Z

    move-result v0

    if-eqz v0, :cond_20

    .line 362
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0, v6}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Lcom/bestbuy/android/bbyobjects/BBYWebView;Z)Z

    .line 363
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-virtual {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->goBack()V

    move v0, v7

    .line 364
    goto/16 :goto_0

    .line 366
    :cond_20
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/app/Activity;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    .line 367
    const v1, 0x7f0c0033

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 368
    instance-of v1, v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    if-eqz v1, :cond_21

    .line 369
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    .line 370
    invoke-virtual {v0, v6}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->a(I)V

    :goto_2
    move v0, v7

    .line 374
    goto/16 :goto_0

    .line 372
    :cond_21
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/app/Activity;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->popCurrentFragment()V

    goto :goto_2

    .line 376
    :cond_22
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->g(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f08001d

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_23

    const-string v0, "_requestid="

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_23

    .line 378
    invoke-virtual {p1}, Landroid/webkit/WebView;->reload()V

    move v0, v7

    .line 379
    goto/16 :goto_0

    .line 381
    :cond_23
    const-string v0, "file:///android_asset/"

    invoke-virtual {p2, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_24

    const-string v0, "appvi="

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_24

    .line 382
    const-string v0, "?"

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_25

    .line 383
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "&appvi="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v1

    invoke-virtual {v1}, Lnb;->r()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    :cond_24
    :goto_3
    move v0, v6

    .line 388
    goto/16 :goto_0

    .line 385
    :cond_25
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "?appvi="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v1

    invoke-virtual {v1}, Lnb;->r()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    goto :goto_3
.end method
