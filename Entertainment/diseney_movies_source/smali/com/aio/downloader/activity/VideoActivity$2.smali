.class Lcom/aio/downloader/activity/VideoActivity$2;
.super Ljava/lang/Object;
.source "VideoActivity.java"

# interfaces
.implements Landroid/view/View$OnKeyListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/VideoActivity;->buildListener()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/VideoActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/VideoActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/VideoActivity$2;->this$0:Lcom/aio/downloader/activity/VideoActivity;

    .line 201
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onKey(Landroid/view/View;ILandroid/view/KeyEvent;)Z
    .locals 4
    .param p1, "v"    # Landroid/view/View;
    .param p2, "keyCode"    # I
    .param p3, "event"    # Landroid/view/KeyEvent;

    .prologue
    const/4 v1, 0x1

    .line 204
    invoke-virtual {p3}, Landroid/view/KeyEvent;->getAction()I

    move-result v2

    if-nez v2, :cond_2

    .line 205
    const/4 v2, 0x4

    if-ne p2, v2, :cond_2

    .line 206
    iget-object v2, p0, Lcom/aio/downloader/activity/VideoActivity$2;->this$0:Lcom/aio/downloader/activity/VideoActivity;

    # getter for: Lcom/aio/downloader/activity/VideoActivity;->videowebview:Landroid/webkit/WebView;
    invoke-static {v2}, Lcom/aio/downloader/activity/VideoActivity;->access$5(Lcom/aio/downloader/activity/VideoActivity;)Landroid/webkit/WebView;

    move-result-object v2

    invoke-virtual {v2}, Landroid/webkit/WebView;->canGoBack()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 208
    iget-object v2, p0, Lcom/aio/downloader/activity/VideoActivity$2;->this$0:Lcom/aio/downloader/activity/VideoActivity;

    # getter for: Lcom/aio/downloader/activity/VideoActivity;->videowebview:Landroid/webkit/WebView;
    invoke-static {v2}, Lcom/aio/downloader/activity/VideoActivity;->access$5(Lcom/aio/downloader/activity/VideoActivity;)Landroid/webkit/WebView;

    move-result-object v2

    invoke-virtual {v2}, Landroid/webkit/WebView;->goBack()V

    .line 210
    iget-object v2, p0, Lcom/aio/downloader/activity/VideoActivity$2;->this$0:Lcom/aio/downloader/activity/VideoActivity;

    # getter for: Lcom/aio/downloader/activity/VideoActivity;->videowebview:Landroid/webkit/WebView;
    invoke-static {v2}, Lcom/aio/downloader/activity/VideoActivity;->access$5(Lcom/aio/downloader/activity/VideoActivity;)Landroid/webkit/WebView;

    move-result-object v2

    invoke-virtual {v2}, Landroid/webkit/WebView;->getUrl()Ljava/lang/String;

    move-result-object v2

    const-string v3, "//m.youtube.com"

    invoke-virtual {v2, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 211
    iget-object v2, p0, Lcom/aio/downloader/activity/VideoActivity$2;->this$0:Lcom/aio/downloader/activity/VideoActivity;

    # getter for: Lcom/aio/downloader/activity/VideoActivity;->videowebview:Landroid/webkit/WebView;
    invoke-static {v2}, Lcom/aio/downloader/activity/VideoActivity;->access$5(Lcom/aio/downloader/activity/VideoActivity;)Landroid/webkit/WebView;

    move-result-object v2

    invoke-virtual {v2}, Landroid/webkit/WebView;->getUrl()Ljava/lang/String;

    move-result-object v2

    const-string v3, "v="

    invoke-virtual {v2, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 212
    new-instance v0, Landroid/os/Message;

    invoke-direct {v0}, Landroid/os/Message;-><init>()V

    .line 213
    .local v0, "msg":Landroid/os/Message;
    iput v1, v0, Landroid/os/Message;->what:I

    .line 214
    iget-object v2, p0, Lcom/aio/downloader/activity/VideoActivity$2;->this$0:Lcom/aio/downloader/activity/VideoActivity;

    iget-object v2, v2, Lcom/aio/downloader/activity/VideoActivity;->hander:Landroid/os/Handler;

    invoke-virtual {v2, v0}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 224
    .end local v0    # "msg":Landroid/os/Message;
    :cond_0
    :goto_0
    return v1

    .line 216
    :cond_1
    new-instance v0, Landroid/os/Message;

    invoke-direct {v0}, Landroid/os/Message;-><init>()V

    .line 217
    .restart local v0    # "msg":Landroid/os/Message;
    const/4 v2, 0x2

    iput v2, v0, Landroid/os/Message;->what:I

    .line 218
    iget-object v2, p0, Lcom/aio/downloader/activity/VideoActivity$2;->this$0:Lcom/aio/downloader/activity/VideoActivity;

    iget-object v2, v2, Lcom/aio/downloader/activity/VideoActivity;->hander:Landroid/os/Handler;

    invoke-virtual {v2, v0}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    goto :goto_0

    .line 224
    .end local v0    # "msg":Landroid/os/Message;
    :cond_2
    const/4 v1, 0x0

    goto :goto_0
.end method
