.class Lcom/aio/downloader/fragments/RingtoneSearchFragment$SeekBarChangeEvent;
.super Ljava/lang/Object;
.source "RingtoneSearchFragment.java"

# interfaces
.implements Landroid/widget/SeekBar$OnSeekBarChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/fragments/RingtoneSearchFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "SeekBarChangeEvent"
.end annotation


# instance fields
.field progress:I

.field final synthetic this$0:Lcom/aio/downloader/fragments/RingtoneSearchFragment;


# direct methods
.method constructor <init>(Lcom/aio/downloader/fragments/RingtoneSearchFragment;)V
    .locals 0

    .prologue
    .line 449
    iput-object p1, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment$SeekBarChangeEvent;->this$0:Lcom/aio/downloader/fragments/RingtoneSearchFragment;

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
    .line 458
    :try_start_0
    iget-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment$SeekBarChangeEvent;->this$0:Lcom/aio/downloader/fragments/RingtoneSearchFragment;

    # getter for: Lcom/aio/downloader/fragments/RingtoneSearchFragment;->player:Lcom/aio/downloader/utils/Player;
    invoke-static {v0}, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->access$2(Lcom/aio/downloader/fragments/RingtoneSearchFragment;)Lcom/aio/downloader/utils/Player;

    move-result-object v0

    iget-object v0, v0, Lcom/aio/downloader/utils/Player;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->getDuration()I

    move-result v0

    mul-int/2addr v0, p2

    .line 459
    invoke-virtual {p1}, Landroid/widget/SeekBar;->getMax()I

    move-result v1

    div-int/2addr v0, v1

    .line 458
    iput v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment$SeekBarChangeEvent;->progress:I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 464
    :goto_0
    return-void

    .line 460
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method public onStartTrackingTouch(Landroid/widget/SeekBar;)V
    .locals 0
    .param p1, "seekBar"    # Landroid/widget/SeekBar;

    .prologue
    .line 469
    return-void
.end method

.method public onStopTrackingTouch(Landroid/widget/SeekBar;)V
    .locals 2
    .param p1, "seekBar"    # Landroid/widget/SeekBar;

    .prologue
    .line 474
    iget-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment$SeekBarChangeEvent;->this$0:Lcom/aio/downloader/fragments/RingtoneSearchFragment;

    # getter for: Lcom/aio/downloader/fragments/RingtoneSearchFragment;->player:Lcom/aio/downloader/utils/Player;
    invoke-static {v0}, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->access$2(Lcom/aio/downloader/fragments/RingtoneSearchFragment;)Lcom/aio/downloader/utils/Player;

    move-result-object v0

    iget-object v0, v0, Lcom/aio/downloader/utils/Player;->mediaPlayer:Landroid/media/MediaPlayer;

    iget v1, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment$SeekBarChangeEvent;->progress:I

    invoke-virtual {v0, v1}, Landroid/media/MediaPlayer;->seekTo(I)V

    .line 475
    return-void
.end method
