.class public Lcom/aio/downloader/activity/MiniGamePlayActivity$Mywebview;
.super Landroid/webkit/WebViewClient;
.source "MiniGamePlayActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/MiniGamePlayActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "Mywebview"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/MiniGamePlayActivity;


# direct methods
.method public constructor <init>(Lcom/aio/downloader/activity/MiniGamePlayActivity;)V
    .locals 0

    .prologue
    .line 170
    iput-object p1, p0, Lcom/aio/downloader/activity/MiniGamePlayActivity$Mywebview;->this$0:Lcom/aio/downloader/activity/MiniGamePlayActivity;

    invoke-direct {p0}, Landroid/webkit/WebViewClient;-><init>()V

    return-void
.end method


# virtual methods
.method public onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V
    .locals 2
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 181
    invoke-super {p0, p1, p2}, Landroid/webkit/WebViewClient;->onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V

    .line 182
    iget-object v0, p0, Lcom/aio/downloader/activity/MiniGamePlayActivity$Mywebview;->this$0:Lcom/aio/downloader/activity/MiniGamePlayActivity;

    # getter for: Lcom/aio/downloader/activity/MiniGamePlayActivity;->progress_wheel:Lcom/aio/downloader/utils/ProgressWheel;
    invoke-static {v0}, Lcom/aio/downloader/activity/MiniGamePlayActivity;->access$0(Lcom/aio/downloader/activity/MiniGamePlayActivity;)Lcom/aio/downloader/utils/ProgressWheel;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 187
    return-void
.end method

.method public onPageStarted(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V
    .locals 2
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;
    .param p3, "favicon"    # Landroid/graphics/Bitmap;

    .prologue
    .line 174
    iget-object v0, p0, Lcom/aio/downloader/activity/MiniGamePlayActivity$Mywebview;->this$0:Lcom/aio/downloader/activity/MiniGamePlayActivity;

    # getter for: Lcom/aio/downloader/activity/MiniGamePlayActivity;->progress_wheel:Lcom/aio/downloader/utils/ProgressWheel;
    invoke-static {v0}, Lcom/aio/downloader/activity/MiniGamePlayActivity;->access$0(Lcom/aio/downloader/activity/MiniGamePlayActivity;)Lcom/aio/downloader/utils/ProgressWheel;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 175
    invoke-super {p0, p1, p2, p3}, Landroid/webkit/WebViewClient;->onPageStarted(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V

    .line 176
    return-void
.end method

.method public onReceivedError(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V
    .locals 4
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "errorCode"    # I
    .param p3, "description"    # Ljava/lang/String;
    .param p4, "failingUrl"    # Ljava/lang/String;

    .prologue
    .line 193
    invoke-super {p0, p1, p2, p3, p4}, Landroid/webkit/WebViewClient;->onReceivedError(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V

    .line 194
    iget-object v0, p0, Lcom/aio/downloader/activity/MiniGamePlayActivity$Mywebview;->this$0:Lcom/aio/downloader/activity/MiniGamePlayActivity;

    # getter for: Lcom/aio/downloader/activity/MiniGamePlayActivity;->net_hint_img_pdt:Landroid/widget/ImageView;
    invoke-static {v0}, Lcom/aio/downloader/activity/MiniGamePlayActivity;->access$1(Lcom/aio/downloader/activity/MiniGamePlayActivity;)Landroid/widget/ImageView;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 195
    iget-object v0, p0, Lcom/aio/downloader/activity/MiniGamePlayActivity$Mywebview;->this$0:Lcom/aio/downloader/activity/MiniGamePlayActivity;

    # getter for: Lcom/aio/downloader/activity/MiniGamePlayActivity;->gameplaywebview:Landroid/webkit/WebView;
    invoke-static {v0}, Lcom/aio/downloader/activity/MiniGamePlayActivity;->access$2(Lcom/aio/downloader/activity/MiniGamePlayActivity;)Landroid/webkit/WebView;

    move-result-object v0

    const-string v1, ""

    const-string v2, "text/html"

    const-string v3, "UTF-8"

    invoke-virtual {v0, v1, v2, v3}, Landroid/webkit/WebView;->loadData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 196
    return-void
.end method

.method public shouldInterceptRequest(Landroid/webkit/WebView;Ljava/lang/String;)Landroid/webkit/WebResourceResponse;
    .locals 1
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 210
    invoke-super {p0, p1, p2}, Landroid/webkit/WebViewClient;->shouldInterceptRequest(Landroid/webkit/WebView;Ljava/lang/String;)Landroid/webkit/WebResourceResponse;

    move-result-object v0

    return-object v0
.end method

.method public shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z
    .locals 1
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 203
    invoke-super {p0, p1, p2}, Landroid/webkit/WebViewClient;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z

    move-result v0

    return v0
.end method
