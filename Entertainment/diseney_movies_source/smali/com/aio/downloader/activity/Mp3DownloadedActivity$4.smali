.class Lcom/aio/downloader/activity/Mp3DownloadedActivity$4;
.super Landroid/content/BroadcastReceiver;
.source "Mp3DownloadedActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/Mp3DownloadedActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/Mp3DownloadedActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/Mp3DownloadedActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity$4;->this$0:Lcom/aio/downloader/activity/Mp3DownloadedActivity;

    .line 129
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 4
    .param p1, "arg0"    # Landroid/content/Context;
    .param p2, "arg1"    # Landroid/content/Intent;

    .prologue
    .line 134
    :try_start_0
    iget-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity$4;->this$0:Lcom/aio/downloader/activity/Mp3DownloadedActivity;

    iget-object v0, v0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->totaltime:Landroid/widget/TextView;

    new-instance v1, Ljava/lang/StringBuilder;

    iget-object v2, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity$4;->this$0:Lcom/aio/downloader/activity/Mp3DownloadedActivity;

    # getter for: Lcom/aio/downloader/activity/Mp3DownloadedActivity;->player:Lcom/aio/downloader/utils/Player;
    invoke-static {v2}, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->access$3(Lcom/aio/downloader/activity/Mp3DownloadedActivity;)Lcom/aio/downloader/utils/Player;

    move-result-object v2

    iget-object v2, v2, Lcom/aio/downloader/utils/Player;->mediaPlayer:Landroid/media/MediaPlayer;

    .line 135
    invoke-virtual {v2}, Landroid/media/MediaPlayer;->getDuration()I

    move-result v2

    int-to-long v2, v2

    .line 134
    invoke-static {v2, v3}, Lcom/aio/downloader/utils/Player;->formatTime(J)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 142
    :goto_0
    return-void

    .line 137
    :catch_0
    move-exception v0

    goto :goto_0
.end method
