.class public Lcom/aio/downloader/activity/ShowAideoActivity;
.super Landroid/app/Activity;
.source "ShowAideoActivity.java"


# instance fields
.field private progress_wheel_video:Lcom/aio/downloader/utils/ProgressWheel;

.field private wv:Landroid/webkit/WebView;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/ShowAideoActivity;)Lcom/aio/downloader/utils/ProgressWheel;
    .locals 1

    .prologue
    .line 19
    iget-object v0, p0, Lcom/aio/downloader/activity/ShowAideoActivity;->progress_wheel_video:Lcom/aio/downloader/utils/ProgressWheel;

    return-object v0
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 23
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 24
    const v1, 0x7f03000e

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/ShowAideoActivity;->setContentView(I)V

    .line 26
    const v1, 0x7f07008e

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/ShowAideoActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/webkit/WebView;

    iput-object v1, p0, Lcom/aio/downloader/activity/ShowAideoActivity;->wv:Landroid/webkit/WebView;

    .line 27
    const v1, 0x7f07008f

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/ShowAideoActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/utils/ProgressWheel;

    iput-object v1, p0, Lcom/aio/downloader/activity/ShowAideoActivity;->progress_wheel_video:Lcom/aio/downloader/utils/ProgressWheel;

    .line 28
    invoke-virtual {p0}, Lcom/aio/downloader/activity/ShowAideoActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    const-string v2, "strurl"

    invoke-virtual {v1, v2}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 29
    .local v0, "path":Ljava/lang/String;
    const-string v1, "tag"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, "------------------------"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 30
    iget-object v1, p0, Lcom/aio/downloader/activity/ShowAideoActivity;->wv:Landroid/webkit/WebView;

    invoke-virtual {v1, v0}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 31
    iget-object v1, p0, Lcom/aio/downloader/activity/ShowAideoActivity;->wv:Landroid/webkit/WebView;

    invoke-virtual {v1}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Landroid/webkit/WebSettings;->setJavaScriptEnabled(Z)V

    .line 32
    iget-object v1, p0, Lcom/aio/downloader/activity/ShowAideoActivity;->wv:Landroid/webkit/WebView;

    new-instance v2, Landroid/webkit/WebChromeClient;

    invoke-direct {v2}, Landroid/webkit/WebChromeClient;-><init>()V

    invoke-virtual {v1, v2}, Landroid/webkit/WebView;->setWebChromeClient(Landroid/webkit/WebChromeClient;)V

    .line 33
    iget-object v1, p0, Lcom/aio/downloader/activity/ShowAideoActivity;->wv:Landroid/webkit/WebView;

    new-instance v2, Lcom/aio/downloader/activity/ShowAideoActivity$1;

    invoke-direct {v2, p0}, Lcom/aio/downloader/activity/ShowAideoActivity$1;-><init>(Lcom/aio/downloader/activity/ShowAideoActivity;)V

    invoke-virtual {v1, v2}, Landroid/webkit/WebView;->setWebViewClient(Landroid/webkit/WebViewClient;)V

    .line 51
    return-void
.end method

.method public onKeyDown(ILandroid/view/KeyEvent;)Z
    .locals 1
    .param p1, "keyCode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;

    .prologue
    .line 56
    const/4 v0, 0x4

    if-ne p1, v0, :cond_0

    iget-object v0, p0, Lcom/aio/downloader/activity/ShowAideoActivity;->wv:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->canGoBack()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 57
    iget-object v0, p0, Lcom/aio/downloader/activity/ShowAideoActivity;->wv:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->canGoBack()Z

    .line 58
    const/4 v0, 0x1

    .line 60
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
    .line 65
    iget-object v0, p0, Lcom/aio/downloader/activity/ShowAideoActivity;->wv:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->onPause()V

    .line 66
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onPause(Landroid/content/Context;)V

    .line 67
    invoke-super {p0}, Landroid/app/Activity;->onPause()V

    .line 68
    return-void
.end method

.method protected onResume()V
    .locals 1

    .prologue
    .line 72
    iget-object v0, p0, Lcom/aio/downloader/activity/ShowAideoActivity;->wv:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->onResume()V

    .line 73
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onResume(Landroid/content/Context;)V

    .line 74
    invoke-super {p0}, Landroid/app/Activity;->onResume()V

    .line 75
    return-void
.end method
