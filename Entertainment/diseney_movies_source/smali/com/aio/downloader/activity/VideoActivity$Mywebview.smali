.class public Lcom/aio/downloader/activity/VideoActivity$Mywebview;
.super Landroid/webkit/WebViewClient;
.source "VideoActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/VideoActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "Mywebview"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/VideoActivity;


# direct methods
.method public constructor <init>(Lcom/aio/downloader/activity/VideoActivity;)V
    .locals 0

    .prologue
    .line 282
    iput-object p1, p0, Lcom/aio/downloader/activity/VideoActivity$Mywebview;->this$0:Lcom/aio/downloader/activity/VideoActivity;

    invoke-direct {p0}, Landroid/webkit/WebViewClient;-><init>()V

    return-void
.end method


# virtual methods
.method public onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V
    .locals 2
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 294
    iget-object v0, p0, Lcom/aio/downloader/activity/VideoActivity$Mywebview;->this$0:Lcom/aio/downloader/activity/VideoActivity;

    # getter for: Lcom/aio/downloader/activity/VideoActivity;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;
    invoke-static {v0}, Lcom/aio/downloader/activity/VideoActivity;->access$3(Lcom/aio/downloader/activity/VideoActivity;)Lcom/aio/downloader/utils/ProgressWheel;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 297
    invoke-super {p0, p1, p2}, Landroid/webkit/WebViewClient;->onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V

    .line 298
    return-void
.end method

.method public onPageStarted(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V
    .locals 2
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;
    .param p3, "favicon"    # Landroid/graphics/Bitmap;

    .prologue
    .line 287
    iget-object v0, p0, Lcom/aio/downloader/activity/VideoActivity$Mywebview;->this$0:Lcom/aio/downloader/activity/VideoActivity;

    # getter for: Lcom/aio/downloader/activity/VideoActivity;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;
    invoke-static {v0}, Lcom/aio/downloader/activity/VideoActivity;->access$3(Lcom/aio/downloader/activity/VideoActivity;)Lcom/aio/downloader/utils/ProgressWheel;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 289
    invoke-super {p0, p1, p2, p3}, Landroid/webkit/WebViewClient;->onPageStarted(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V

    .line 290
    return-void
.end method

.method public onReceivedError(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V
    .locals 4
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "errorCode"    # I
    .param p3, "description"    # Ljava/lang/String;
    .param p4, "failingUrl"    # Ljava/lang/String;

    .prologue
    .line 304
    invoke-super {p0, p1, p2, p3, p4}, Landroid/webkit/WebViewClient;->onReceivedError(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V

    .line 305
    iget-object v0, p0, Lcom/aio/downloader/activity/VideoActivity$Mywebview;->this$0:Lcom/aio/downloader/activity/VideoActivity;

    # getter for: Lcom/aio/downloader/activity/VideoActivity;->videowebview:Landroid/webkit/WebView;
    invoke-static {v0}, Lcom/aio/downloader/activity/VideoActivity;->access$5(Lcom/aio/downloader/activity/VideoActivity;)Landroid/webkit/WebView;

    move-result-object v0

    const-string v1, ""

    const-string v2, "text/html"

    const-string v3, "UTF-8"

    invoke-virtual {v0, v1, v2, v3}, Landroid/webkit/WebView;->loadData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 306
    iget-object v0, p0, Lcom/aio/downloader/activity/VideoActivity$Mywebview;->this$0:Lcom/aio/downloader/activity/VideoActivity;

    # getter for: Lcom/aio/downloader/activity/VideoActivity;->net_hint_img_list:Landroid/widget/ImageView;
    invoke-static {v0}, Lcom/aio/downloader/activity/VideoActivity;->access$6(Lcom/aio/downloader/activity/VideoActivity;)Landroid/widget/ImageView;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 307
    return-void
.end method

.method public shouldInterceptRequest(Landroid/webkit/WebView;Ljava/lang/String;)Landroid/webkit/WebResourceResponse;
    .locals 7
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi"
        }
    .end annotation

    .prologue
    const/4 v6, 0x1

    .line 313
    const-string v3, "//m.youtube.com"

    invoke-virtual {p2, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 314
    const-string v3, "lklk"

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "load:"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 316
    const-string v3, "/watch\\?.*v=([^&]+)"

    invoke-static {v3}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v2

    .line 317
    .local v2, "p":Ljava/util/regex/Pattern;
    invoke-virtual {v2, p2}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v0

    .line 318
    .local v0, "m":Ljava/util/regex/Matcher;
    invoke-virtual {v0}, Ljava/util/regex/Matcher;->find()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 319
    const-string v3, "cvcv"

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "GOOD:"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "     id:"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v0, v6}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 320
    new-instance v1, Landroid/os/Message;

    invoke-direct {v1}, Landroid/os/Message;-><init>()V

    .line 321
    .local v1, "msg":Landroid/os/Message;
    iput v6, v1, Landroid/os/Message;->what:I

    .line 322
    iget-object v3, p0, Lcom/aio/downloader/activity/VideoActivity$Mywebview;->this$0:Lcom/aio/downloader/activity/VideoActivity;

    iget-object v3, v3, Lcom/aio/downloader/activity/VideoActivity;->hander:Landroid/os/Handler;

    invoke-virtual {v3, v1}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 323
    iget-object v3, p0, Lcom/aio/downloader/activity/VideoActivity$Mywebview;->this$0:Lcom/aio/downloader/activity/VideoActivity;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "http://www.youtube.com/get_video_info?&video_id="

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 324
    invoke-virtual {v0, v6}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "&asv=3&el=detailpage&hl=en_US"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 323
    invoke-static {v3, v4}, Lcom/aio/downloader/activity/VideoActivity;->access$7(Lcom/aio/downloader/activity/VideoActivity;Ljava/lang/String;)V

    .line 325
    const-string v3, "getUrl"

    iget-object v4, p0, Lcom/aio/downloader/activity/VideoActivity$Mywebview;->this$0:Lcom/aio/downloader/activity/VideoActivity;

    # getter for: Lcom/aio/downloader/activity/VideoActivity;->video_info_url:Ljava/lang/String;
    invoke-static {v4}, Lcom/aio/downloader/activity/VideoActivity;->access$8(Lcom/aio/downloader/activity/VideoActivity;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 338
    .end local v0    # "m":Ljava/util/regex/Matcher;
    .end local v1    # "msg":Landroid/os/Message;
    .end local v2    # "p":Ljava/util/regex/Pattern;
    :cond_0
    :goto_0
    invoke-super {p0, p1, p2}, Landroid/webkit/WebViewClient;->shouldInterceptRequest(Landroid/webkit/WebView;Ljava/lang/String;)Landroid/webkit/WebResourceResponse;

    move-result-object v3

    return-object v3

    .line 327
    .restart local v0    # "m":Ljava/util/regex/Matcher;
    .restart local v2    # "p":Ljava/util/regex/Pattern;
    :cond_1
    const-string v3, "/feed"

    invoke-virtual {p2, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_0

    const-string v3, "/_get_ads"

    invoke-virtual {p2, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 328
    const-string v3, "/guide_ajax"

    invoke-virtual {p2, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 329
    const-string v3, "cvcv"

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "BAD:"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 330
    new-instance v1, Landroid/os/Message;

    invoke-direct {v1}, Landroid/os/Message;-><init>()V

    .line 331
    .restart local v1    # "msg":Landroid/os/Message;
    const/4 v3, 0x2

    iput v3, v1, Landroid/os/Message;->what:I

    .line 332
    iget-object v3, p0, Lcom/aio/downloader/activity/VideoActivity$Mywebview;->this$0:Lcom/aio/downloader/activity/VideoActivity;

    iget-object v3, v3, Lcom/aio/downloader/activity/VideoActivity;->hander:Landroid/os/Handler;

    invoke-virtual {v3, v1}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    goto :goto_0
.end method
