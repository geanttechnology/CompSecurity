.class Lcom/aio/downloader/fragments/Mp3SearchFragment$SeekBarChangeEvent;
.super Ljava/lang/Object;
.source "Mp3SearchFragment.java"

# interfaces
.implements Landroid/widget/SeekBar$OnSeekBarChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/fragments/Mp3SearchFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "SeekBarChangeEvent"
.end annotation


# instance fields
.field progress:I

.field final synthetic this$0:Lcom/aio/downloader/fragments/Mp3SearchFragment;


# direct methods
.method constructor <init>(Lcom/aio/downloader/fragments/Mp3SearchFragment;)V
    .locals 0

    .prologue
    .line 440
    iput-object p1, p0, Lcom/aio/downloader/fragments/Mp3SearchFragment$SeekBarChangeEvent;->this$0:Lcom/aio/downloader/fragments/Mp3SearchFragment;

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
    .line 449
    :try_start_0
    iget-object v0, p0, Lcom/aio/downloader/fragments/Mp3SearchFragment$SeekBarChangeEvent;->this$0:Lcom/aio/downloader/fragments/Mp3SearchFragment;

    # getter for: Lcom/aio/downloader/fragments/Mp3SearchFragment;->player:Lcom/aio/downloader/utils/Player;
    invoke-static {v0}, Lcom/aio/downloader/fragments/Mp3SearchFragment;->access$2(Lcom/aio/downloader/fragments/Mp3SearchFragment;)Lcom/aio/downloader/utils/Player;

    move-result-object v0

    iget-object v0, v0, Lcom/aio/downloader/utils/Player;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->getDuration()I

    move-result v0

    mul-int/2addr v0, p2

    .line 450
    invoke-virtual {p1}, Landroid/widget/SeekBar;->getMax()I

    move-result v1

    div-int/2addr v0, v1

    .line 449
    iput v0, p0, Lcom/aio/downloader/fragments/Mp3SearchFragment$SeekBarChangeEvent;->progress:I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 455
    :goto_0
    return-void

    .line 451
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method public onStartTrackingTouch(Landroid/widget/SeekBar;)V
    .locals 0
    .param p1, "seekBar"    # Landroid/widget/SeekBar;

    .prologue
    .line 460
    return-void
.end method

.method public onStopTrackingTouch(Landroid/widget/SeekBar;)V
    .locals 2
    .param p1, "seekBar"    # Landroid/widget/SeekBar;

    .prologue
    .line 465
    iget-object v0, p0, Lcom/aio/downloader/fragments/Mp3SearchFragment$SeekBarChangeEvent;->this$0:Lcom/aio/downloader/fragments/Mp3SearchFragment;

    # getter for: Lcom/aio/downloader/fragments/Mp3SearchFragment;->player:Lcom/aio/downloader/utils/Player;
    invoke-static {v0}, Lcom/aio/downloader/fragments/Mp3SearchFragment;->access$2(Lcom/aio/downloader/fragments/Mp3SearchFragment;)Lcom/aio/downloader/utils/Player;

    move-result-object v0

    iget-object v0, v0, Lcom/aio/downloader/utils/Player;->mediaPlayer:Landroid/media/MediaPlayer;

    iget v1, p0, Lcom/aio/downloader/fragments/Mp3SearchFragment$SeekBarChangeEvent;->progress:I

    invoke-virtual {v0, v1}, Landroid/media/MediaPlayer;->seekTo(I)V

    .line 466
    return-void
.end method
