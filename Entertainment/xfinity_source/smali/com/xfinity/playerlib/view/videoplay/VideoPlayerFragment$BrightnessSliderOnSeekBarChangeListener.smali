.class Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BrightnessSliderOnSeekBarChangeListener;
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
    name = "BrightnessSliderOnSeekBarChangeListener"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .prologue
    .line 2329
    iput-object p1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BrightnessSliderOnSeekBarChangeListener;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

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
    .line 2333
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BrightnessSliderOnSeekBarChangeListener;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/Window;->getAttributes()Landroid/view/WindowManager$LayoutParams;

    move-result-object v0

    .line 2334
    .local v0, "lp":Landroid/view/WindowManager$LayoutParams;
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BrightnessSliderOnSeekBarChangeListener;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # invokes: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getAdjustedBrightness(I)F
    invoke-static {v1, p2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$5200(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;I)F

    move-result v1

    iput v1, v0, Landroid/view/WindowManager$LayoutParams;->screenBrightness:F

    .line 2335
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BrightnessSliderOnSeekBarChangeListener;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/view/Window;->setAttributes(Landroid/view/WindowManager$LayoutParams;)V

    .line 2337
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BrightnessSliderOnSeekBarChangeListener;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->isPhone:Z
    invoke-static {v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$5300(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 2338
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BrightnessSliderOnSeekBarChangeListener;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    iget-object v2, v1, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->brightnessIndicator:Lcom/xfinity/playerlib/view/CustomStateImageView;

    const/4 v1, 0x3

    if-le p2, v1, :cond_1

    const/4 v1, 0x1

    :goto_0
    invoke-virtual {v2, v1}, Lcom/xfinity/playerlib/view/CustomStateImageView;->setAppearEnabled(Z)V

    .line 2340
    :cond_0
    return-void

    .line 2338
    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public onStartTrackingTouch(Landroid/widget/SeekBar;)V
    .locals 1
    .param p1, "seekBar"    # Landroid/widget/SeekBar;

    .prologue
    .line 2344
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BrightnessSliderOnSeekBarChangeListener;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playerUIController:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$900(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->removeMainControlTimeout()V

    .line 2345
    return-void
.end method

.method public onStopTrackingTouch(Landroid/widget/SeekBar;)V
    .locals 2
    .param p1, "seekBar"    # Landroid/widget/SeekBar;

    .prologue
    .line 2349
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BrightnessSliderOnSeekBarChangeListener;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$2700(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    invoke-virtual {p1}, Landroid/widget/SeekBar;->getProgress()I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->setBrightnessValue(I)V

    .line 2351
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BrightnessSliderOnSeekBarChangeListener;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->getPlayerStatus()Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    move-result-object v0

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->PLAYING:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 2352
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BrightnessSliderOnSeekBarChangeListener;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playerUIController:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$900(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->startMainControlTimeout()V

    .line 2354
    :cond_0
    return-void
.end method
