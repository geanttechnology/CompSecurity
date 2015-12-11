.class Lcom/aio/downloader/activity/MyMainActivity$42$1;
.super Ljava/util/TimerTask;
.source "MyMainActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/MyMainActivity$42;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/aio/downloader/activity/MyMainActivity$42;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/MyMainActivity$42;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/MyMainActivity$42$1;->this$1:Lcom/aio/downloader/activity/MyMainActivity$42;

    .line 4067
    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 4072
    new-instance v0, Landroid/os/Message;

    invoke-direct {v0}, Landroid/os/Message;-><init>()V

    .line 4073
    .local v0, "mymsg":Landroid/os/Message;
    const/16 v1, 0x14

    iput v1, v0, Landroid/os/Message;->what:I

    .line 4074
    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity$42$1;->this$1:Lcom/aio/downloader/activity/MyMainActivity$42;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity$42;->this$0:Lcom/aio/downloader/activity/MyMainActivity;
    invoke-static {v1}, Lcom/aio/downloader/activity/MyMainActivity$42;->access$0(Lcom/aio/downloader/activity/MyMainActivity$42;)Lcom/aio/downloader/activity/MyMainActivity;

    move-result-object v1

    iget-object v1, v1, Lcom/aio/downloader/activity/MyMainActivity;->handlertimer:Landroid/os/Handler;

    invoke-virtual {v1, v0}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 4076
    return-void
.end method
