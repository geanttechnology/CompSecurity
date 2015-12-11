.class Lcom/aio/downloader/refresh/PullToRefreshLayout$MyTimer;
.super Ljava/lang/Object;
.source "PullToRefreshLayout.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/refresh/PullToRefreshLayout;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "MyTimer"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/refresh/PullToRefreshLayout$MyTimer$MyTask;
    }
.end annotation


# instance fields
.field private handler:Landroid/os/Handler;

.field private mTask:Lcom/aio/downloader/refresh/PullToRefreshLayout$MyTimer$MyTask;

.field final synthetic this$0:Lcom/aio/downloader/refresh/PullToRefreshLayout;

.field private timer:Ljava/util/Timer;


# direct methods
.method public constructor <init>(Lcom/aio/downloader/refresh/PullToRefreshLayout;Landroid/os/Handler;)V
    .locals 1
    .param p2, "handler"    # Landroid/os/Handler;

    .prologue
    .line 336
    iput-object p1, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout$MyTimer;->this$0:Lcom/aio/downloader/refresh/PullToRefreshLayout;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 337
    iput-object p2, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout$MyTimer;->handler:Landroid/os/Handler;

    .line 338
    new-instance v0, Ljava/util/Timer;

    invoke-direct {v0}, Ljava/util/Timer;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout$MyTimer;->timer:Ljava/util/Timer;

    .line 339
    return-void
.end method


# virtual methods
.method public cancel()V
    .locals 1

    .prologue
    .line 351
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout$MyTimer;->mTask:Lcom/aio/downloader/refresh/PullToRefreshLayout$MyTimer$MyTask;

    if-eqz v0, :cond_0

    .line 352
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout$MyTimer;->mTask:Lcom/aio/downloader/refresh/PullToRefreshLayout$MyTimer$MyTask;

    invoke-virtual {v0}, Lcom/aio/downloader/refresh/PullToRefreshLayout$MyTimer$MyTask;->cancel()Z

    .line 353
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout$MyTimer;->mTask:Lcom/aio/downloader/refresh/PullToRefreshLayout$MyTimer$MyTask;

    .line 355
    :cond_0
    return-void
.end method

.method public schedule(J)V
    .locals 6
    .param p1, "period"    # J

    .prologue
    .line 342
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout$MyTimer;->mTask:Lcom/aio/downloader/refresh/PullToRefreshLayout$MyTimer$MyTask;

    if-eqz v0, :cond_0

    .line 343
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout$MyTimer;->mTask:Lcom/aio/downloader/refresh/PullToRefreshLayout$MyTimer$MyTask;

    invoke-virtual {v0}, Lcom/aio/downloader/refresh/PullToRefreshLayout$MyTimer$MyTask;->cancel()Z

    .line 344
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout$MyTimer;->mTask:Lcom/aio/downloader/refresh/PullToRefreshLayout$MyTimer$MyTask;

    .line 346
    :cond_0
    new-instance v0, Lcom/aio/downloader/refresh/PullToRefreshLayout$MyTimer$MyTask;

    iget-object v1, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout$MyTimer;->handler:Landroid/os/Handler;

    invoke-direct {v0, p0, v1}, Lcom/aio/downloader/refresh/PullToRefreshLayout$MyTimer$MyTask;-><init>(Lcom/aio/downloader/refresh/PullToRefreshLayout$MyTimer;Landroid/os/Handler;)V

    iput-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout$MyTimer;->mTask:Lcom/aio/downloader/refresh/PullToRefreshLayout$MyTimer$MyTask;

    .line 347
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout$MyTimer;->timer:Ljava/util/Timer;

    iget-object v1, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout$MyTimer;->mTask:Lcom/aio/downloader/refresh/PullToRefreshLayout$MyTimer$MyTask;

    const-wide/16 v2, 0x0

    move-wide v4, p1

    invoke-virtual/range {v0 .. v5}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;JJ)V

    .line 348
    return-void
.end method
