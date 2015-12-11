.class Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$VolumeSliderOnSeekBarChangeListener;
.super Ljava/lang/Object;
.source "VideoPlayerFragment.java"

# interfaces
.implements Landroid/widget/SeekBar$OnSeekBarChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "VolumeSliderOnSeekBarChangeListener"
.end annotation


# instance fields
.field private startVolume:I

.field final synthetic this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .prologue
    .line 2367
    iput-object p1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$VolumeSliderOnSeekBarChangeListener;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onProgressChanged(Landroid/widget/SeekBar;IZ)V
    .locals 3
    .param p1, "seekBar"    # Landroid/widget/SeekBar;
    .param p2, "progress"    # I
    .param p3, "fromUser"    # Z

    .prologue
    const/4 v0, 0x0

    .line 2372
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$VolumeSliderOnSeekBarChangeListener;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->isMuted:Z
    invoke-static {v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$5100(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Z

    move-result v1

    if-nez v1, :cond_2

    .line 2373
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$VolumeSliderOnSeekBarChangeListener;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->mAudioManager:Landroid/media/AudioManager;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$200(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/media/AudioManager;

    move-result-object v1

    const/4 v2, 0x3

    invoke-virtual {v1, v2, p2, v0}, Landroid/media/AudioManager;->setStreamVolume(III)V

    .line 2374
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$VolumeSliderOnSeekBarChangeListener;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->isPhone:Z
    invoke-static {v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$5300(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 2375
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$VolumeSliderOnSeekBarChangeListener;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    iget-object v1, v1, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->volumeIndicator:Lcom/xfinity/playerlib/view/CustomStateImageView;

    if-lez p2, :cond_0

    const/4 v0, 0x1

    :cond_0
    invoke-virtual {v1, v0}, Lcom/xfinity/playerlib/view/CustomStateImageView;->setAppearEnabled(Z)V

    .line 2380
    :cond_1
    :goto_0
    return-void

    .line 2378
    :cond_2
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$VolumeSliderOnSeekBarChangeListener;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    invoke-virtual {p1}, Landroid/widget/SeekBar;->getProgress()I

    move-result v1

    # setter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->mutedVolume:I
    invoke-static {v0, v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$5402(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;I)I

    goto :goto_0
.end method

.method public onStartTrackingTouch(Landroid/widget/SeekBar;)V
    .locals 2
    .param p1, "seekBar"    # Landroid/widget/SeekBar;

    .prologue
    .line 2384
    invoke-virtual {p1}, Landroid/widget/SeekBar;->getProgress()I

    move-result v0

    .line 2385
    .local v0, "progress":I
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$VolumeSliderOnSeekBarChangeListener;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playerUIController:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$900(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->removeMainControlTimeout()V

    .line 2386
    iput v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$VolumeSliderOnSeekBarChangeListener;->startVolume:I

    .line 2387
    return-void
.end method

.method public onStopTrackingTouch(Landroid/widget/SeekBar;)V
    .locals 3
    .param p1, "seekBar"    # Landroid/widget/SeekBar;

    .prologue
    .line 2391
    invoke-virtual {p1}, Landroid/widget/SeekBar;->getProgress()I

    move-result v0

    .line 2392
    .local v0, "progress":I
    iget v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$VolumeSliderOnSeekBarChangeListener;->startVolume:I

    if-le v0, v1, :cond_0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$VolumeSliderOnSeekBarChangeListener;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->isMuted:Z
    invoke-static {v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$5100(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 2393
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$VolumeSliderOnSeekBarChangeListener;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->setMuteState(Z)V

    .line 2396
    :cond_0
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$VolumeSliderOnSeekBarChangeListener;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->onVolumeChanged()V

    .line 2397
    return-void
.end method
