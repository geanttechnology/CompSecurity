.class Lcom/aio/downloader/refresh/PullToRefreshLayout$MyTimer$MyTask;
.super Ljava/util/TimerTask;
.source "PullToRefreshLayout.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/refresh/PullToRefreshLayout$MyTimer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "MyTask"
.end annotation


# instance fields
.field private handler:Landroid/os/Handler;

.field final synthetic this$1:Lcom/aio/downloader/refresh/PullToRefreshLayout$MyTimer;


# direct methods
.method public constructor <init>(Lcom/aio/downloader/refresh/PullToRefreshLayout$MyTimer;Landroid/os/Handler;)V
    .locals 0
    .param p2, "handler"    # Landroid/os/Handler;

    .prologue
    .line 360
    iput-object p1, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout$MyTimer$MyTask;->this$1:Lcom/aio/downloader/refresh/PullToRefreshLayout$MyTimer;

    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    .line 361
    iput-object p2, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout$MyTimer$MyTask;->handler:Landroid/os/Handler;

    .line 362
    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 366
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout$MyTimer$MyTask;->handler:Landroid/os/Handler;

    invoke-virtual {v0}, Landroid/os/Handler;->obtainMessage()Landroid/os/Message;

    move-result-object v0

    invoke-virtual {v0}, Landroid/os/Message;->sendToTarget()V

    .line 367
    return-void
.end method
