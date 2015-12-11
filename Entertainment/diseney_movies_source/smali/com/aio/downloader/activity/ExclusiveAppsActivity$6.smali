.class Lcom/aio/downloader/activity/ExclusiveAppsActivity$6;
.super Ljava/util/TimerTask;
.source "ExclusiveAppsActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/ExclusiveAppsActivity;->onResume()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/ExclusiveAppsActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$6;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    .line 508
    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 513
    new-instance v0, Landroid/os/Message;

    invoke-direct {v0}, Landroid/os/Message;-><init>()V

    .line 514
    .local v0, "mymsg":Landroid/os/Message;
    const/16 v1, 0x7530

    iput v1, v0, Landroid/os/Message;->what:I

    .line 515
    iget-object v1, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$6;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    # getter for: Lcom/aio/downloader/activity/ExclusiveAppsActivity;->handler:Landroid/os/Handler;
    invoke-static {v1}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->access$13(Lcom/aio/downloader/activity/ExclusiveAppsActivity;)Landroid/os/Handler;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 517
    return-void
.end method
