.class Lcom/aio/downloader/activity/Mp3DownloadedActivity$SeekBarChangeEvent;
.super Ljava/lang/Object;
.source "Mp3DownloadedActivity.java"

# interfaces
.implements Landroid/widget/SeekBar$OnSeekBarChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/Mp3DownloadedActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "SeekBarChangeEvent"
.end annotation


# instance fields
.field progress:I

.field final synthetic this$0:Lcom/aio/downloader/activity/Mp3DownloadedActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/Mp3DownloadedActivity;)V
    .locals 0

    .prologue
    .line 380
    iput-object p1, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity$SeekBarChangeEvent;->this$0:Lcom/aio/downloader/activity/Mp3DownloadedActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onProgressChanged(Landroid/widget/SeekBar;IZ)V
    .locals 2
    .param p1, "seekBar"    # Landroid/widget/SeekBar;
    .param p2, "progress"    # I
    .param p3, "fromUser"    # Z

    .prologue
    .line 387
    iget-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity$SeekBarChangeEvent;->this$0:Lcom/aio/downloader/activity/Mp3DownloadedActivity;

    # getter for: Lcom/aio/downloader/activity/Mp3DownloadedActivity;->player:Lcom/aio/downloader/utils/Player;
    invoke-static {v0}, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->access$3(Lcom/aio/downloader/activity/Mp3DownloadedActivity;)Lcom/aio/downloader/utils/Player;

    move-result-object v0

    iget-object v0, v0, Lcom/aio/downloader/utils/Player;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->getDuration()I

    move-result v0

    mul-int/2addr v0, p2

    .line 388
    invoke-virtual {p1}, Landroid/widget/SeekBar;->getMax()I

    move-result v1

    div-int/2addr v0, v1

    .line 387
    iput v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity$SeekBarChangeEvent;->progress:I

    .line 391
    return-void
.end method

.method public onStartTrackingTouch(Landroid/widget/SeekBar;)V
    .locals 0
    .param p1, "seekBar"    # Landroid/widget/SeekBar;

    .prologue
    .line 396
    return-void
.end method

.method public onStopTrackingTouch(Landroid/widget/SeekBar;)V
    .locals 2
    .param p1, "seekBar"    # Landroid/widget/SeekBar;

    .prologue
    .line 401
    iget-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity$SeekBarChangeEvent;->this$0:Lcom/aio/downloader/activity/Mp3DownloadedActivity;

    # getter for: Lcom/aio/downloader/activity/Mp3DownloadedActivity;->player:Lcom/aio/downloader/utils/Player;
    invoke-static {v0}, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->access$3(Lcom/aio/downloader/activity/Mp3DownloadedActivity;)Lcom/aio/downloader/utils/Player;

    move-result-object v0

    iget-object v0, v0, Lcom/aio/downloader/utils/Player;->mediaPlayer:Landroid/media/MediaPlayer;

    iget v1, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity$SeekBarChangeEvent;->progress:I

    invoke-virtual {v0, v1}, Landroid/media/MediaPlayer;->seekTo(I)V

    .line 402
    return-void
.end method
