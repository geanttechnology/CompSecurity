.class Lcom/aio/downloader/activity/PaidforFreeActivity1$7;
.super Ljava/util/TimerTask;
.source "PaidforFreeActivity1.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/PaidforFreeActivity1;->onResume()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/PaidforFreeActivity1;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$7;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    .line 627
    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 632
    new-instance v0, Landroid/os/Message;

    invoke-direct {v0}, Landroid/os/Message;-><init>()V

    .line 633
    .local v0, "mymsg":Landroid/os/Message;
    const/16 v1, 0x7530

    iput v1, v0, Landroid/os/Message;->what:I

    .line 634
    iget-object v1, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$7;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    # getter for: Lcom/aio/downloader/activity/PaidforFreeActivity1;->handler:Landroid/os/Handler;
    invoke-static {v1}, Lcom/aio/downloader/activity/PaidforFreeActivity1;->access$20(Lcom/aio/downloader/activity/PaidforFreeActivity1;)Landroid/os/Handler;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 636
    return-void
.end method
