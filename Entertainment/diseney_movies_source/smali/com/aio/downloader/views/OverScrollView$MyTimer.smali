.class Lcom/aio/downloader/views/OverScrollView$MyTimer;
.super Ljava/lang/Object;
.source "OverScrollView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/views/OverScrollView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "MyTimer"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/views/OverScrollView$MyTimer$MyTask;
    }
.end annotation


# instance fields
.field private handler:Landroid/os/Handler;

.field private mTask:Lcom/aio/downloader/views/OverScrollView$MyTimer$MyTask;

.field final synthetic this$0:Lcom/aio/downloader/views/OverScrollView;

.field private timer:Ljava/util/Timer;


# direct methods
.method public constructor <init>(Lcom/aio/downloader/views/OverScrollView;Landroid/os/Handler;)V
    .locals 1
    .param p2, "handler"    # Landroid/os/Handler;

    .prologue
    .line 227
    iput-object p1, p0, Lcom/aio/downloader/views/OverScrollView$MyTimer;->this$0:Lcom/aio/downloader/views/OverScrollView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 228
    iput-object p2, p0, Lcom/aio/downloader/views/OverScrollView$MyTimer;->handler:Landroid/os/Handler;

    .line 229
    new-instance v0, Ljava/util/Timer;

    invoke-direct {v0}, Ljava/util/Timer;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/views/OverScrollView$MyTimer;->timer:Ljava/util/Timer;

    .line 230
    return-void
.end method


# virtual methods
.method public cancel()V
    .locals 1

    .prologue
    .line 242
    iget-object v0, p0, Lcom/aio/downloader/views/OverScrollView$MyTimer;->mTask:Lcom/aio/downloader/views/OverScrollView$MyTimer$MyTask;

    if-eqz v0, :cond_0

    .line 243
    iget-object v0, p0, Lcom/aio/downloader/views/OverScrollView$MyTimer;->mTask:Lcom/aio/downloader/views/OverScrollView$MyTimer$MyTask;

    invoke-virtual {v0}, Lcom/aio/downloader/views/OverScrollView$MyTimer$MyTask;->cancel()Z

    .line 244
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/aio/downloader/views/OverScrollView$MyTimer;->mTask:Lcom/aio/downloader/views/OverScrollView$MyTimer$MyTask;

    .line 246
    :cond_0
    return-void
.end method

.method public schedule(J)V
    .locals 6
    .param p1, "period"    # J

    .prologue
    .line 233
    iget-object v0, p0, Lcom/aio/downloader/views/OverScrollView$MyTimer;->mTask:Lcom/aio/downloader/views/OverScrollView$MyTimer$MyTask;

    if-eqz v0, :cond_0

    .line 234
    iget-object v0, p0, Lcom/aio/downloader/views/OverScrollView$MyTimer;->mTask:Lcom/aio/downloader/views/OverScrollView$MyTimer$MyTask;

    invoke-virtual {v0}, Lcom/aio/downloader/views/OverScrollView$MyTimer$MyTask;->cancel()Z

    .line 235
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/aio/downloader/views/OverScrollView$MyTimer;->mTask:Lcom/aio/downloader/views/OverScrollView$MyTimer$MyTask;

    .line 237
    :cond_0
    new-instance v0, Lcom/aio/downloader/views/OverScrollView$MyTimer$MyTask;

    iget-object v1, p0, Lcom/aio/downloader/views/OverScrollView$MyTimer;->handler:Landroid/os/Handler;

    invoke-direct {v0, p0, v1}, Lcom/aio/downloader/views/OverScrollView$MyTimer$MyTask;-><init>(Lcom/aio/downloader/views/OverScrollView$MyTimer;Landroid/os/Handler;)V

    iput-object v0, p0, Lcom/aio/downloader/views/OverScrollView$MyTimer;->mTask:Lcom/aio/downloader/views/OverScrollView$MyTimer$MyTask;

    .line 238
    iget-object v0, p0, Lcom/aio/downloader/views/OverScrollView$MyTimer;->timer:Ljava/util/Timer;

    iget-object v1, p0, Lcom/aio/downloader/views/OverScrollView$MyTimer;->mTask:Lcom/aio/downloader/views/OverScrollView$MyTimer$MyTask;

    const-wide/16 v2, 0x0

    move-wide v4, p1

    invoke-virtual/range {v0 .. v5}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;JJ)V

    .line 239
    return-void
.end method
