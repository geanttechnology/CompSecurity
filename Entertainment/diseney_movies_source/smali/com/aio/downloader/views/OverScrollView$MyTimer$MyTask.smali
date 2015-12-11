.class Lcom/aio/downloader/views/OverScrollView$MyTimer$MyTask;
.super Ljava/util/TimerTask;
.source "OverScrollView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/views/OverScrollView$MyTimer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "MyTask"
.end annotation


# instance fields
.field private handler:Landroid/os/Handler;

.field final synthetic this$1:Lcom/aio/downloader/views/OverScrollView$MyTimer;


# direct methods
.method public constructor <init>(Lcom/aio/downloader/views/OverScrollView$MyTimer;Landroid/os/Handler;)V
    .locals 0
    .param p2, "handler"    # Landroid/os/Handler;

    .prologue
    .line 251
    iput-object p1, p0, Lcom/aio/downloader/views/OverScrollView$MyTimer$MyTask;->this$1:Lcom/aio/downloader/views/OverScrollView$MyTimer;

    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    .line 252
    iput-object p2, p0, Lcom/aio/downloader/views/OverScrollView$MyTimer$MyTask;->handler:Landroid/os/Handler;

    .line 253
    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 257
    iget-object v0, p0, Lcom/aio/downloader/views/OverScrollView$MyTimer$MyTask;->handler:Landroid/os/Handler;

    invoke-virtual {v0}, Landroid/os/Handler;->obtainMessage()Landroid/os/Message;

    move-result-object v0

    invoke-virtual {v0}, Landroid/os/Message;->sendToTarget()V

    .line 258
    return-void
.end method
