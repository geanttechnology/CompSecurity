.class public Lcom/aio/downloader/activity/AcquireWebview;
.super Landroid/app/Activity;
.source "AcquireWebview.java"


# instance fields
.field private acqu_fanhui:Landroid/widget/ImageView;

.field private acqu_title:Landroid/widget/TextView;

.field private progress_wheel_video:Lcom/aio/downloader/utils/ProgressWheel;

.field private wv_acqu:Landroid/webkit/WebView;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 20
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/AcquireWebview;)Lcom/aio/downloader/utils/ProgressWheel;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lcom/aio/downloader/activity/AcquireWebview;->progress_wheel_video:Lcom/aio/downloader/utils/ProgressWheel;

    return-object v0
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 29
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 30
    const v1, 0x7f030001

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/AcquireWebview;->setContentView(I)V

    .line 31
    const v1, 0x7f070020

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/AcquireWebview;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    iput-object v1, p0, Lcom/aio/downloader/activity/AcquireWebview;->acqu_fanhui:Landroid/widget/ImageView;

    .line 32
    const v1, 0x7f070021

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/AcquireWebview;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/aio/downloader/activity/AcquireWebview;->acqu_title:Landroid/widget/TextView;

    .line 33
    iget-object v1, p0, Lcom/aio/downloader/activity/AcquireWebview;->acqu_fanhui:Landroid/widget/ImageView;

    new-instance v2, Lcom/aio/downloader/activity/AcquireWebview$1;

    invoke-direct {v2, p0}, Lcom/aio/downloader/activity/AcquireWebview$1;-><init>(Lcom/aio/downloader/activity/AcquireWebview;)V

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 42
    const v1, 0x7f070022

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/AcquireWebview;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/webkit/WebView;

    iput-object v1, p0, Lcom/aio/downloader/activity/AcquireWebview;->wv_acqu:Landroid/webkit/WebView;

    .line 43
    const v1, 0x7f070023

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/AcquireWebview;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/utils/ProgressWheel;

    iput-object v1, p0, Lcom/aio/downloader/activity/AcquireWebview;->progress_wheel_video:Lcom/aio/downloader/utils/ProgressWheel;

    .line 44
    invoke-virtual {p0}, Lcom/aio/downloader/activity/AcquireWebview;->getIntent()Landroid/content/Intent;

    move-result-object v1

    const-string v2, "url_load"

    invoke-virtual {v1, v2}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 45
    .local v0, "url_load":Ljava/lang/String;
    iget-object v1, p0, Lcom/aio/downloader/activity/AcquireWebview;->acqu_title:Landroid/widget/TextView;

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 46
    iget-object v1, p0, Lcom/aio/downloader/activity/AcquireWebview;->wv_acqu:Landroid/webkit/WebView;

    invoke-virtual {v1, v0}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 47
    iget-object v1, p0, Lcom/aio/downloader/activity/AcquireWebview;->wv_acqu:Landroid/webkit/WebView;

    invoke-virtual {v1}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Landroid/webkit/WebSettings;->setJavaScriptEnabled(Z)V

    .line 48
    iget-object v1, p0, Lcom/aio/downloader/activity/AcquireWebview;->wv_acqu:Landroid/webkit/WebView;

    new-instance v2, Landroid/webkit/WebChromeClient;

    invoke-direct {v2}, Landroid/webkit/WebChromeClient;-><init>()V

    invoke-virtual {v1, v2}, Landroid/webkit/WebView;->setWebChromeClient(Landroid/webkit/WebChromeClient;)V

    .line 49
    iget-object v1, p0, Lcom/aio/downloader/activity/AcquireWebview;->wv_acqu:Landroid/webkit/WebView;

    new-instance v2, Lcom/aio/downloader/activity/AcquireWebview$2;

    invoke-direct {v2, p0}, Lcom/aio/downloader/activity/AcquireWebview$2;-><init>(Lcom/aio/downloader/activity/AcquireWebview;)V

    invoke-virtual {v1, v2}, Landroid/webkit/WebView;->setWebViewClient(Landroid/webkit/WebViewClient;)V

    .line 66
    return-void
.end method

.method public onKeyDown(ILandroid/view/KeyEvent;)Z
    .locals 1
    .param p1, "keyCode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;

    .prologue
    .line 71
    const/4 v0, 0x4

    if-ne p1, v0, :cond_0

    iget-object v0, p0, Lcom/aio/downloader/activity/AcquireWebview;->wv_acqu:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->canGoBack()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 72
    iget-object v0, p0, Lcom/aio/downloader/activity/AcquireWebview;->wv_acqu:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->canGoBack()Z

    .line 73
    const/4 v0, 0x1

    .line 75
    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1, p2}, Landroid/app/Activity;->onKeyDown(ILandroid/view/KeyEvent;)Z

    move-result v0

    goto :goto_0
.end method

.method protected onPause()V
    .locals 1

    .prologue
    .line 80
    iget-object v0, p0, Lcom/aio/downloader/activity/AcquireWebview;->wv_acqu:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->onPause()V

    .line 81
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onPause(Landroid/content/Context;)V

    .line 82
    invoke-super {p0}, Landroid/app/Activity;->onPause()V

    .line 83
    return-void
.end method

.method protected onResume()V
    .locals 1

    .prologue
    .line 87
    iget-object v0, p0, Lcom/aio/downloader/activity/AcquireWebview;->wv_acqu:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->onResume()V

    .line 88
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onResume(Landroid/content/Context;)V

    .line 89
    invoke-super {p0}, Landroid/app/Activity;->onResume()V

    .line 90
    return-void
.end method
