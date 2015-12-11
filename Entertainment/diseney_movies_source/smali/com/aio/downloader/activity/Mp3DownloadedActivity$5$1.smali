.class Lcom/aio/downloader/activity/Mp3DownloadedActivity$5$1;
.super Ljava/lang/Object;
.source "Mp3DownloadedActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/Mp3DownloadedActivity$5;->onReceive(Landroid/content/Context;Landroid/content/Intent;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/aio/downloader/activity/Mp3DownloadedActivity$5;

.field private final synthetic val$mp3position:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/Mp3DownloadedActivity$5;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity$5$1;->this$1:Lcom/aio/downloader/activity/Mp3DownloadedActivity$5;

    iput-object p2, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity$5$1;->val$mp3position:Ljava/lang/String;

    .line 158
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/Mp3DownloadedActivity$5$1;)Lcom/aio/downloader/activity/Mp3DownloadedActivity$5;
    .locals 1

    .prologue
    .line 158
    iget-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity$5$1;->this$1:Lcom/aio/downloader/activity/Mp3DownloadedActivity$5;

    return-object v0
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    .line 163
    invoke-static {}, Landroid/os/Looper;->prepare()V

    .line 164
    iget-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity$5$1;->this$1:Lcom/aio/downloader/activity/Mp3DownloadedActivity$5;

    # getter for: Lcom/aio/downloader/activity/Mp3DownloadedActivity$5;->this$0:Lcom/aio/downloader/activity/Mp3DownloadedActivity;
    invoke-static {v0}, Lcom/aio/downloader/activity/Mp3DownloadedActivity$5;->access$0(Lcom/aio/downloader/activity/Mp3DownloadedActivity$5;)Lcom/aio/downloader/activity/Mp3DownloadedActivity;

    move-result-object v0

    # getter for: Lcom/aio/downloader/activity/Mp3DownloadedActivity;->player:Lcom/aio/downloader/utils/Player;
    invoke-static {v0}, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->access$3(Lcom/aio/downloader/activity/Mp3DownloadedActivity;)Lcom/aio/downloader/utils/Player;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity$5$1;->val$mp3position:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/utils/Player;->playUrl(Ljava/lang/String;)V

    .line 165
    iget-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity$5$1;->this$1:Lcom/aio/downloader/activity/Mp3DownloadedActivity$5;

    # getter for: Lcom/aio/downloader/activity/Mp3DownloadedActivity$5;->this$0:Lcom/aio/downloader/activity/Mp3DownloadedActivity;
    invoke-static {v0}, Lcom/aio/downloader/activity/Mp3DownloadedActivity$5;->access$0(Lcom/aio/downloader/activity/Mp3DownloadedActivity$5;)Lcom/aio/downloader/activity/Mp3DownloadedActivity;

    move-result-object v0

    new-instance v1, Ljava/util/Timer;

    invoke-direct {v1}, Ljava/util/Timer;-><init>()V

    invoke-static {v0, v1}, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->access$6(Lcom/aio/downloader/activity/Mp3DownloadedActivity;Ljava/util/Timer;)V

    .line 166
    iget-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity$5$1;->this$1:Lcom/aio/downloader/activity/Mp3DownloadedActivity$5;

    # getter for: Lcom/aio/downloader/activity/Mp3DownloadedActivity$5;->this$0:Lcom/aio/downloader/activity/Mp3DownloadedActivity;
    invoke-static {v0}, Lcom/aio/downloader/activity/Mp3DownloadedActivity$5;->access$0(Lcom/aio/downloader/activity/Mp3DownloadedActivity$5;)Lcom/aio/downloader/activity/Mp3DownloadedActivity;

    move-result-object v0

    new-instance v1, Lcom/aio/downloader/activity/Mp3DownloadedActivity$5$1$1;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/Mp3DownloadedActivity$5$1$1;-><init>(Lcom/aio/downloader/activity/Mp3DownloadedActivity$5$1;)V

    invoke-static {v0, v1}, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->access$7(Lcom/aio/downloader/activity/Mp3DownloadedActivity;Ljava/util/TimerTask;)V

    .line 177
    iget-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity$5$1;->this$1:Lcom/aio/downloader/activity/Mp3DownloadedActivity$5;

    # getter for: Lcom/aio/downloader/activity/Mp3DownloadedActivity$5;->this$0:Lcom/aio/downloader/activity/Mp3DownloadedActivity;
    invoke-static {v0}, Lcom/aio/downloader/activity/Mp3DownloadedActivity$5;->access$0(Lcom/aio/downloader/activity/Mp3DownloadedActivity$5;)Lcom/aio/downloader/activity/Mp3DownloadedActivity;

    move-result-object v0

    # getter for: Lcom/aio/downloader/activity/Mp3DownloadedActivity;->timer:Ljava/util/Timer;
    invoke-static {v0}, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->access$8(Lcom/aio/downloader/activity/Mp3DownloadedActivity;)Ljava/util/Timer;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity$5$1;->this$1:Lcom/aio/downloader/activity/Mp3DownloadedActivity$5;

    # getter for: Lcom/aio/downloader/activity/Mp3DownloadedActivity$5;->this$0:Lcom/aio/downloader/activity/Mp3DownloadedActivity;
    invoke-static {v1}, Lcom/aio/downloader/activity/Mp3DownloadedActivity$5;->access$0(Lcom/aio/downloader/activity/Mp3DownloadedActivity$5;)Lcom/aio/downloader/activity/Mp3DownloadedActivity;

    move-result-object v1

    # getter for: Lcom/aio/downloader/activity/Mp3DownloadedActivity;->task:Ljava/util/TimerTask;
    invoke-static {v1}, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->access$9(Lcom/aio/downloader/activity/Mp3DownloadedActivity;)Ljava/util/TimerTask;

    move-result-object v1

    const-wide/16 v2, 0x0

    const-wide/16 v4, 0x3e8

    invoke-virtual/range {v0 .. v5}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;JJ)V

    .line 179
    return-void
.end method
