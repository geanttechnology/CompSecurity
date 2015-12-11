.class Lcom/aio/downloader/activity/AppDetailsActivity$33;
.super Ljava/util/TimerTask;
.source "AppDetailsActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/AppDetailsActivity;->onResume()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/AppDetailsActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/AppDetailsActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$33;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 2114
    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 2119
    new-instance v0, Landroid/os/Message;

    invoke-direct {v0}, Landroid/os/Message;-><init>()V

    .line 2120
    .local v0, "mymsg":Landroid/os/Message;
    const/16 v1, 0x7530

    iput v1, v0, Landroid/os/Message;->what:I

    .line 2121
    iget-object v1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$33;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    iget-object v1, v1, Lcom/aio/downloader/activity/AppDetailsActivity;->handler:Landroid/os/Handler;

    invoke-virtual {v1, v0}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 2123
    return-void
.end method
