.class Lcom/aio/downloader/activity/AcquireWebview$2;
.super Landroid/webkit/WebViewClient;
.source "AcquireWebview.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/AcquireWebview;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/AcquireWebview;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/AcquireWebview;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/AcquireWebview$2;->this$0:Lcom/aio/downloader/activity/AcquireWebview;

    .line 49
    invoke-direct {p0}, Landroid/webkit/WebViewClient;-><init>()V

    return-void
.end method


# virtual methods
.method public onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V
    .locals 2
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 61
    iget-object v0, p0, Lcom/aio/downloader/activity/AcquireWebview$2;->this$0:Lcom/aio/downloader/activity/AcquireWebview;

    # getter for: Lcom/aio/downloader/activity/AcquireWebview;->progress_wheel_video:Lcom/aio/downloader/utils/ProgressWheel;
    invoke-static {v0}, Lcom/aio/downloader/activity/AcquireWebview;->access$0(Lcom/aio/downloader/activity/AcquireWebview;)Lcom/aio/downloader/utils/ProgressWheel;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 62
    invoke-super {p0, p1, p2}, Landroid/webkit/WebViewClient;->onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V

    .line 63
    return-void
.end method

.method public onPageStarted(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V
    .locals 2
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;
    .param p3, "favicon"    # Landroid/graphics/Bitmap;

    .prologue
    .line 54
    iget-object v0, p0, Lcom/aio/downloader/activity/AcquireWebview$2;->this$0:Lcom/aio/downloader/activity/AcquireWebview;

    # getter for: Lcom/aio/downloader/activity/AcquireWebview;->progress_wheel_video:Lcom/aio/downloader/utils/ProgressWheel;
    invoke-static {v0}, Lcom/aio/downloader/activity/AcquireWebview;->access$0(Lcom/aio/downloader/activity/AcquireWebview;)Lcom/aio/downloader/utils/ProgressWheel;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 55
    invoke-super {p0, p1, p2, p3}, Landroid/webkit/WebViewClient;->onPageStarted(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V

    .line 56
    return-void
.end method
