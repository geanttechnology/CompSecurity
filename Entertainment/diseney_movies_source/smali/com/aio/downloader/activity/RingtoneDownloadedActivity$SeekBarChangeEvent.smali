.class Lcom/aio/downloader/activity/RingtoneDownloadedActivity$SeekBarChangeEvent;
.super Ljava/lang/Object;
.source "RingtoneDownloadedActivity.java"

# interfaces
.implements Landroid/widget/SeekBar$OnSeekBarChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/RingtoneDownloadedActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "SeekBarChangeEvent"
.end annotation


# instance fields
.field progress:I

.field final synthetic this$0:Lcom/aio/downloader/activity/RingtoneDownloadedActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/RingtoneDownloadedActivity;)V
    .locals 0

    .prologue
    .line 393
    iput-object p1, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$SeekBarChangeEvent;->this$0:Lcom/aio/downloader/activity/RingtoneDownloadedActivity;

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
    .line 400
    iget-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$SeekBarChangeEvent;->this$0:Lcom/aio/downloader/activity/RingtoneDownloadedActivity;

    # getter for: Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->player:Lcom/aio/downloader/utils/Player;
    invoke-static {v0}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->access$3(Lcom/aio/downloader/activity/RingtoneDownloadedActivity;)Lcom/aio/downloader/utils/Player;

    move-result-object v0

    iget-object v0, v0, Lcom/aio/downloader/utils/Player;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->getDuration()I

    move-result v0

    mul-int/2addr v0, p2

    .line 401
    invoke-virtual {p1}, Landroid/widget/SeekBar;->getMax()I

    move-result v1

    div-int/2addr v0, v1

    .line 400
    iput v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$SeekBarChangeEvent;->progress:I

    .line 404
    return-void
.end method

.method public onStartTrackingTouch(Landroid/widget/SeekBar;)V
    .locals 0
    .param p1, "seekBar"    # Landroid/widget/SeekBar;

    .prologue
    .line 409
    return-void
.end method

.method public onStopTrackingTouch(Landroid/widget/SeekBar;)V
    .locals 2
    .param p1, "seekBar"    # Landroid/widget/SeekBar;

    .prologue
    .line 414
    iget-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$SeekBarChangeEvent;->this$0:Lcom/aio/downloader/activity/RingtoneDownloadedActivity;

    # getter for: Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->player:Lcom/aio/downloader/utils/Player;
    invoke-static {v0}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->access$3(Lcom/aio/downloader/activity/RingtoneDownloadedActivity;)Lcom/aio/downloader/utils/Player;

    move-result-object v0

    iget-object v0, v0, Lcom/aio/downloader/utils/Player;->mediaPlayer:Landroid/media/MediaPlayer;

    iget v1, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$SeekBarChangeEvent;->progress:I

    invoke-virtual {v0, v1}, Landroid/media/MediaPlayer;->seekTo(I)V

    .line 415
    return-void
.end method
