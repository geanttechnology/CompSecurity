.class Lcom/bestbuy/android/activities/mybby/CIALoginFragment$1;
.super Landroid/webkit/WebViewClient;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/bestbuy/android/activities/mybby/CIALoginFragment;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/mybby/CIALoginFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/mybby/CIALoginFragment;)V
    .locals 0

    .prologue
    .line 50
    iput-object p1, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment$1;->a:Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

    invoke-direct {p0}, Landroid/webkit/WebViewClient;-><init>()V

    return-void
.end method


# virtual methods
.method public onFormResubmission(Landroid/webkit/WebView;Landroid/os/Message;Landroid/os/Message;)V
    .locals 0

    .prologue
    .line 54
    invoke-virtual {p3}, Landroid/os/Message;->sendToTarget()V

    .line 55
    return-void
.end method

.method public onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 106
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment$1;->a:Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    const-string v0, "bestbuy.com/cart"

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 107
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment$1;->a:Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->b(Lcom/bestbuy/android/activities/mybby/CIALoginFragment;)Lcm;

    move-result-object v0

    invoke-virtual {v0, p2}, Lcm;->updateCartCount(Ljava/lang/String;)V

    .line 109
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment$1;->a:Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment$1;->a:Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

    const v1, 0x7f08012d

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 110
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment$1;->a:Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->b(Lcom/bestbuy/android/activities/mybby/CIALoginFragment;)Lcm;

    move-result-object v0

    invoke-virtual {v0}, Lcm;->executeMainCSS()V

    .line 112
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment$1;->a:Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_2

    const-string v0, "tokenInfo?authenticationDataToken="

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 113
    const-string v0, "javascript:window.CIAJavaScriptInterface.showHTML(\'<html>\'+document.getElementsByTagName(\'html\')[0].innerHTML+\'</html>\');"

    invoke-virtual {p1, v0}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 121
    :goto_0
    return-void

    .line 116
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment$1;->a:Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_3

    const-string v0, "bestbuy.com/cart"

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 117
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment$1;->a:Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->a(Lcom/bestbuy/android/activities/mybby/CIALoginFragment;)Landroid/view/View;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0

    .line 119
    :cond_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment$1;->a:Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->a(Lcom/bestbuy/android/activities/mybby/CIALoginFragment;)Landroid/view/View;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0
.end method

.method public onPageStarted(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V
    .locals 8

    .prologue
    const/4 v7, 0x0

    const/4 v6, 0x1

    .line 70
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment$1;->a:Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->a(Lcom/bestbuy/android/activities/mybby/CIALoginFragment;)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v7}, Landroid/view/View;->setVisibility(I)V

    .line 71
    const-string v0, "http://www.bestbuy.com/"

    invoke-virtual {p2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 72
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment$1;->a:Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

    iget-object v0, v0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->f:Lnb;

    invoke-virtual {v0}, Lnb;->F()Z

    move-result v0

    .line 73
    if-nez v0, :cond_0

    .line 74
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment$1;->a:Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

    iget-object v1, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment$1;->a:Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->b(Lcom/bestbuy/android/activities/mybby/CIALoginFragment;)Lcm;

    move-result-object v1

    const-string v2, ".bestbuy.com"

    const-string v3, "ut"

    invoke-virtual {v1, v2, v3}, Lcm;->a(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->a(Lcom/bestbuy/android/activities/mybby/CIALoginFragment;Ljava/lang/String;)Ljava/lang/String;

    .line 75
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment$1;->a:Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->c(Lcom/bestbuy/android/activities/mybby/CIALoginFragment;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment$1;->a:Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->c(Lcom/bestbuy/android/activities/mybby/CIALoginFragment;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 76
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment$1;->a:Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

    iget-object v1, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment$1;->a:Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->b(Lcom/bestbuy/android/activities/mybby/CIALoginFragment;)Lcm;

    move-result-object v1

    const-string v2, "https://www-ssl.bestbuy.com"

    const-string v3, "at"

    invoke-virtual {v1, v2, v3}, Lcm;->a(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->b(Lcom/bestbuy/android/activities/mybby/CIALoginFragment;Ljava/lang/String;)Ljava/lang/String;

    .line 79
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment$1;->a:Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->d(Lcom/bestbuy/android/activities/mybby/CIALoginFragment;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment$1;->a:Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->d(Lcom/bestbuy/android/activities/mybby/CIALoginFragment;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1

    .line 80
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment$1;->a:Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

    iget-object v0, v0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->f:Lnb;

    invoke-virtual {v0, v6}, Lnb;->d(Z)V

    .line 81
    new-instance v0, Lio;

    iget-object v1, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment$1;->a:Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

    iget-object v1, v1, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->d:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment$1;->a:Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

    iget-object v3, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment$1;->a:Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

    invoke-static {v3}, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->a(Lcom/bestbuy/android/activities/mybby/CIALoginFragment;)Landroid/view/View;

    move-result-object v3

    iget-object v4, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment$1;->a:Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

    invoke-static {v4}, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->c(Lcom/bestbuy/android/activities/mybby/CIALoginFragment;)Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment$1;->a:Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

    invoke-static {v5}, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->d(Lcom/bestbuy/android/activities/mybby/CIALoginFragment;)Ljava/lang/String;

    move-result-object v5

    invoke-direct/range {v0 .. v5}, Lio;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    new-array v2, v7, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lio;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 84
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment$1;->a:Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

    iget-object v0, v0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->d:Landroid/app/Activity;

    const v1, 0x7f08016c

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_2

    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment$1;->a:Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

    iget-object v0, v0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->d:Landroid/app/Activity;

    const v1, 0x7f080288

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_2

    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment$1;->a:Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

    iget-object v0, v0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->d:Landroid/app/Activity;

    const v1, 0x7f08012d

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_2

    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment$1;->a:Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

    iget-object v0, v0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->d:Landroid/app/Activity;

    const v1, 0x7f080179

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_2

    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment$1;->a:Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

    iget-object v0, v0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->d:Landroid/app/Activity;

    const v1, 0x7f0800b7

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_2

    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment$1;->a:Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

    iget-object v0, v0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->d:Landroid/app/Activity;

    const v1, 0x7f08035e

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_2

    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment$1;->a:Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

    iget-object v0, v0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->d:Landroid/app/Activity;

    const v1, 0x7f080295

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_2

    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment$1;->a:Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

    iget-object v0, v0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->d:Landroid/app/Activity;

    const v1, 0x7f080316

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_2

    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment$1;->a:Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

    iget-object v0, v0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->d:Landroid/app/Activity;

    const v1, 0x7f080202

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_2

    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment$1;->a:Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

    iget-object v0, v0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->d:Landroid/app/Activity;

    const v1, 0x7f080319

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_2

    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment$1;->a:Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

    iget-object v0, v0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->d:Landroid/app/Activity;

    const v1, 0x7f0801b9

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_2

    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment$1;->a:Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

    iget-object v0, v0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->d:Landroid/app/Activity;

    const v1, 0x7f080355

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_2

    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment$1;->a:Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

    iget-object v0, v0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->d:Landroid/app/Activity;

    const v1, 0x7f080257

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 97
    :cond_2
    invoke-virtual {p1}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v0

    invoke-virtual {v0, v6}, Landroid/webkit/WebSettings;->setLoadWithOverviewMode(Z)V

    .line 98
    invoke-virtual {p1}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v0

    invoke-virtual {v0, v6}, Landroid/webkit/WebSettings;->setUseWideViewPort(Z)V

    .line 99
    invoke-virtual {p1}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v0

    invoke-virtual {v0, v6}, Landroid/webkit/WebSettings;->setBuiltInZoomControls(Z)V

    .line 100
    invoke-virtual {p1}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v0

    invoke-virtual {v0, v6}, Landroid/webkit/WebSettings;->setSupportZoom(Z)V

    .line 101
    const/16 v0, 0x32

    invoke-virtual {p1, v0}, Landroid/webkit/WebView;->setInitialScale(I)V

    .line 103
    :cond_3
    return-void
.end method

.method public onReceivedError(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 64
    const/4 v0, -0x6

    if-eq p2, v0, :cond_0

    const/4 v0, -0x2

    if-eq p2, v0, :cond_0

    const/4 v0, -0x7

    if-ne p2, v0, :cond_1

    .line 65
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment$1;->a:Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->a(Lcom/bestbuy/android/activities/mybby/CIALoginFragment;)Landroid/view/View;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 67
    :cond_1
    return-void
.end method

.method public onReceivedSslError(Landroid/webkit/WebView;Landroid/webkit/SslErrorHandler;Landroid/net/http/SslError;)V
    .locals 0

    .prologue
    .line 59
    invoke-virtual {p2}, Landroid/webkit/SslErrorHandler;->proceed()V

    .line 60
    return-void
.end method
