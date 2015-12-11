.class Lcom/aio/downloader/activity/RingtoneDownloadedActivity$5$1$1;
.super Ljava/util/TimerTask;
.source "RingtoneDownloadedActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/RingtoneDownloadedActivity$5$1;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$2:Lcom/aio/downloader/activity/RingtoneDownloadedActivity$5$1;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/RingtoneDownloadedActivity$5$1;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$5$1$1;->this$2:Lcom/aio/downloader/activity/RingtoneDownloadedActivity$5$1;

    .line 170
    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 174
    new-instance v0, Landroid/os/Message;

    invoke-direct {v0}, Landroid/os/Message;-><init>()V

    .line 175
    .local v0, "msg":Landroid/os/Message;
    const/16 v1, 0x64

    iput v1, v0, Landroid/os/Message;->what:I

    .line 176
    iget-object v1, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$5$1$1;->this$2:Lcom/aio/downloader/activity/RingtoneDownloadedActivity$5$1;

    # getter for: Lcom/aio/downloader/activity/RingtoneDownloadedActivity$5$1;->this$1:Lcom/aio/downloader/activity/RingtoneDownloadedActivity$5;
    invoke-static {v1}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$5$1;->access$0(Lcom/aio/downloader/activity/RingtoneDownloadedActivity$5$1;)Lcom/aio/downloader/activity/RingtoneDownloadedActivity$5;

    move-result-object v1

    # getter for: Lcom/aio/downloader/activity/RingtoneDownloadedActivity$5;->this$0:Lcom/aio/downloader/activity/RingtoneDownloadedActivity;
    invoke-static {v1}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$5;->access$0(Lcom/aio/downloader/activity/RingtoneDownloadedActivity$5;)Lcom/aio/downloader/activity/RingtoneDownloadedActivity;

    move-result-object v1

    iget-object v1, v1, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->handler:Landroid/os/Handler;

    invoke-virtual {v1, v0}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 178
    return-void
.end method
