.class final Lcom/wishabi/flipp/app/fv;
.super Landroid/webkit/WebViewClient;
.source "SourceFile"


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/fu;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/fu;)V
    .locals 0

    .prologue
    .line 127
    iput-object p1, p0, Lcom/wishabi/flipp/app/fv;->a:Lcom/wishabi/flipp/app/fu;

    invoke-direct {p0}, Landroid/webkit/WebViewClient;-><init>()V

    return-void
.end method


# virtual methods
.method public final onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 132
    iget-object v0, p0, Lcom/wishabi/flipp/app/fv;->a:Lcom/wishabi/flipp/app/fu;

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/fu;->getActivity()Landroid/app/Activity;

    move-result-object v0

    if-nez v0, :cond_0

    .line 150
    :goto_0
    return-void

    .line 134
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/app/fv;->a:Lcom/wishabi/flipp/app/fu;

    invoke-virtual {p1}, Landroid/webkit/WebView;->getTitle()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/app/fu;->b(Ljava/lang/String;)V

    .line 136
    iget-object v0, p0, Lcom/wishabi/flipp/app/fv;->a:Lcom/wishabi/flipp/app/fu;

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/fu;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const/high16 v1, 0x10e0000

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v0

    .line 139
    iget-object v1, p0, Lcom/wishabi/flipp/app/fv;->a:Lcom/wishabi/flipp/app/fu;

    invoke-static {v1}, Lcom/wishabi/flipp/app/fu;->a(Lcom/wishabi/flipp/app/fu;)Landroid/webkit/WebView;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/webkit/WebView;->setVisibility(I)V

    .line 140
    iget-object v1, p0, Lcom/wishabi/flipp/app/fv;->a:Lcom/wishabi/flipp/app/fu;

    invoke-static {v1}, Lcom/wishabi/flipp/app/fu;->a(Lcom/wishabi/flipp/app/fu;)Landroid/webkit/WebView;

    move-result-object v1

    invoke-virtual {v1}, Landroid/webkit/WebView;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v1

    const/high16 v2, 0x3f800000    # 1.0f

    invoke-virtual {v1, v2}, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v1

    int-to-long v2, v0

    invoke-virtual {v1, v2, v3}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    .line 142
    iget-object v1, p0, Lcom/wishabi/flipp/app/fv;->a:Lcom/wishabi/flipp/app/fu;

    invoke-static {v1}, Lcom/wishabi/flipp/app/fu;->b(Lcom/wishabi/flipp/app/fu;)Landroid/widget/ProgressBar;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/ProgressBar;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v1

    int-to-long v2, v0

    invoke-virtual {v1, v2, v3}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    new-instance v1, Lcom/wishabi/flipp/app/fw;

    invoke-direct {v1, p0}, Lcom/wishabi/flipp/app/fw;-><init>(Lcom/wishabi/flipp/app/fv;)V

    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->setListener(Landroid/animation/Animator$AnimatorListener;)Landroid/view/ViewPropertyAnimator;

    goto :goto_0
.end method

.method public final onReceivedError(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 171
    const-string v0, "file:///android_asset/webview_error.html"

    invoke-virtual {p1, v0}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 172
    return-void
.end method

.method public final onReceivedHttpAuthRequest(Landroid/webkit/WebView;Landroid/webkit/HttpAuthHandler;Ljava/lang/String;Ljava/lang/String;)V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 156
    iget-object v0, p0, Lcom/wishabi/flipp/app/fv;->a:Lcom/wishabi/flipp/app/fu;

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/fu;->getActivity()Landroid/app/Activity;

    move-result-object v0

    if-nez v0, :cond_1

    .line 166
    :cond_0
    :goto_0
    return-void

    .line 157
    :cond_1
    if-eqz p2, :cond_0

    .line 160
    const-string v0, ":"

    invoke-virtual {p3, v0}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    aget-object v0, v0, v2

    .line 162
    invoke-static {}, Lcom/wishabi/flipp/app/fu;->c()Landroid/net/Uri;

    move-result-object v1

    invoke-virtual {v1}, Landroid/net/Uri;->getHost()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 163
    const-string v0, ""

    const-string v1, ":"

    invoke-virtual {v0, v1}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 164
    aget-object v1, v0, v2

    const/4 v2, 0x1

    aget-object v0, v0, v2

    invoke-virtual {p2, v1, v0}, Landroid/webkit/HttpAuthHandler;->proceed(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method
