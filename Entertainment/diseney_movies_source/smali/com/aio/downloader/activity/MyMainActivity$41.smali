.class Lcom/aio/downloader/activity/MyMainActivity$41;
.super Ljava/util/TimerTask;
.source "MyMainActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/MyMainActivity;->onResume()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/MyMainActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/MyMainActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/MyMainActivity$41;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    .line 3942
    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 3947
    new-instance v0, Landroid/os/Message;

    invoke-direct {v0}, Landroid/os/Message;-><init>()V

    .line 3948
    .local v0, "mymsg":Landroid/os/Message;
    const/16 v1, 0x7530

    iput v1, v0, Landroid/os/Message;->what:I

    .line 3949
    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity$41;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    iget-object v1, v1, Lcom/aio/downloader/activity/MyMainActivity;->handler:Landroid/os/Handler;

    invoke-virtual {v1, v0}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 3951
    return-void
.end method
