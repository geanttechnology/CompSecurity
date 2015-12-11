.class Lcom/aio/downloader/refresh/PullToRefreshLayout$2;
.super Landroid/os/Handler;
.source "PullToRefreshLayout.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/refresh/PullToRefreshLayout;->refreshFinish(I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/refresh/PullToRefreshLayout;


# direct methods
.method constructor <init>(Lcom/aio/downloader/refresh/PullToRefreshLayout;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout$2;->this$0:Lcom/aio/downloader/refresh/PullToRefreshLayout;

    .line 182
    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 2
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    .line 185
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout$2;->this$0:Lcom/aio/downloader/refresh/PullToRefreshLayout;

    const/4 v1, 0x3

    # invokes: Lcom/aio/downloader/refresh/PullToRefreshLayout;->changeState(I)V
    invoke-static {v0, v1}, Lcom/aio/downloader/refresh/PullToRefreshLayout;->access$5(Lcom/aio/downloader/refresh/PullToRefreshLayout;I)V

    .line 186
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout$2;->this$0:Lcom/aio/downloader/refresh/PullToRefreshLayout;

    # getter for: Lcom/aio/downloader/refresh/PullToRefreshLayout;->isTouch:Z
    invoke-static {v0}, Lcom/aio/downloader/refresh/PullToRefreshLayout;->access$0(Lcom/aio/downloader/refresh/PullToRefreshLayout;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 187
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout$2;->this$0:Lcom/aio/downloader/refresh/PullToRefreshLayout;

    # invokes: Lcom/aio/downloader/refresh/PullToRefreshLayout;->hide()V
    invoke-static {v0}, Lcom/aio/downloader/refresh/PullToRefreshLayout;->access$6(Lcom/aio/downloader/refresh/PullToRefreshLayout;)V

    .line 189
    :cond_0
    return-void
.end method
