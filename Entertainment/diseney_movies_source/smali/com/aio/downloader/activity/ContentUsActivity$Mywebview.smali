.class public Lcom/aio/downloader/activity/ContentUsActivity$Mywebview;
.super Landroid/webkit/WebViewClient;
.source "ContentUsActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/ContentUsActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "Mywebview"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/ContentUsActivity;


# direct methods
.method public constructor <init>(Lcom/aio/downloader/activity/ContentUsActivity;)V
    .locals 0

    .prologue
    .line 104
    iput-object p1, p0, Lcom/aio/downloader/activity/ContentUsActivity$Mywebview;->this$0:Lcom/aio/downloader/activity/ContentUsActivity;

    invoke-direct {p0}, Landroid/webkit/WebViewClient;-><init>()V

    return-void
.end method


# virtual methods
.method public onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V
    .locals 2
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 116
    iget-object v0, p0, Lcom/aio/downloader/activity/ContentUsActivity$Mywebview;->this$0:Lcom/aio/downloader/activity/ContentUsActivity;

    # getter for: Lcom/aio/downloader/activity/ContentUsActivity;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;
    invoke-static {v0}, Lcom/aio/downloader/activity/ContentUsActivity;->access$0(Lcom/aio/downloader/activity/ContentUsActivity;)Lcom/aio/downloader/utils/ProgressWheel;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 118
    invoke-super {p0, p1, p2}, Landroid/webkit/WebViewClient;->onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V

    .line 119
    return-void
.end method

.method public onPageStarted(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V
    .locals 2
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;
    .param p3, "favicon"    # Landroid/graphics/Bitmap;

    .prologue
    .line 110
    iget-object v0, p0, Lcom/aio/downloader/activity/ContentUsActivity$Mywebview;->this$0:Lcom/aio/downloader/activity/ContentUsActivity;

    # getter for: Lcom/aio/downloader/activity/ContentUsActivity;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;
    invoke-static {v0}, Lcom/aio/downloader/activity/ContentUsActivity;->access$0(Lcom/aio/downloader/activity/ContentUsActivity;)Lcom/aio/downloader/utils/ProgressWheel;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 111
    invoke-super {p0, p1, p2, p3}, Landroid/webkit/WebViewClient;->onPageStarted(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V

    .line 112
    return-void
.end method

.method public shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z
    .locals 1
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 126
    invoke-super {p0, p1, p2}, Landroid/webkit/WebViewClient;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z

    .line 128
    invoke-virtual {p1, p2}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 130
    const/4 v0, 0x1

    return v0
.end method
