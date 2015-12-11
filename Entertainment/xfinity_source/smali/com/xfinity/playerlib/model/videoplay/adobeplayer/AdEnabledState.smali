.class public abstract Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;
.super Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;
.source "AdEnabledState.java"


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private backgrounded:Z

.field private bufferingWarnings:I

.field private isBuffering:Z

.field private isClickableAdButtonVisible:Z

.field protected isSeeking:Z

.field private pausedForBackground:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 13
    const-class v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)V
    .locals 1
    .param p1, "stateController"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    .prologue
    const/4 v0, 0x0

    .line 25
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)V

    .line 16
    iput-boolean v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->isBuffering:Z

    .line 17
    iput-boolean v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->isSeeking:Z

    .line 18
    iput v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->bufferingWarnings:I

    .line 20
    iput-boolean v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->pausedForBackground:Z

    .line 21
    iput-boolean v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->backgrounded:Z

    .line 26
    return-void
.end method


# virtual methods
.method public adBreakComplete(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;)V
    .locals 8
    .param p1, "adBreak"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    .prologue
    const-wide/16 v4, 0x0

    .line 84
    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v2

    invoke-virtual {v2, v4, v5}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->updateAdTimeLeft(J)V

    .line 85
    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->hideAdControls()V

    .line 86
    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->hasShownRatingsBug()Z

    move-result v2

    if-nez v2, :cond_1

    .line 88
    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->startRatingsBug()V

    .line 91
    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getVideoTrackController()Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->getResumePoint()J

    move-result-wide v0

    .line 93
    .local v0, "resumePoint":J
    cmp-long v2, v0, v4

    if-lez v2, :cond_0

    .line 94
    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v2

    const/4 v3, 0x1

    invoke-virtual {v2, v0, v1, v3}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->setPosition(JZ)V

    .line 98
    :cond_0
    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->startMainControlTimeout()V

    .line 99
    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->showMainControlsWithPauseButton()V

    .line 104
    .end local v0    # "resumePoint":J
    :goto_0
    return-void

    .line 102
    :cond_1
    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getVideoTrackController()Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;

    move-result-object v2

    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v3

    invoke-virtual {v3}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->getPosition()J

    move-result-wide v4

    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v3

    invoke-virtual {v3}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->getDuration()J

    move-result-wide v6

    invoke-virtual {v2, v4, v5, v6, v7}, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->onCustomUpdateEvent(JJ)V

    goto :goto_0
.end method

.method public adBreakStart(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;)V
    .locals 6
    .param p1, "adBreak"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
    .param p2, "ad"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    .prologue
    .line 68
    invoke-virtual {p2}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->isClickable()Z

    move-result v0

    if-nez v0, :cond_1

    .line 69
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->hideAllControls()V

    .line 74
    :goto_0
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->dismissDialogs()V

    .line 75
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {p1}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->getDuration()J

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->showAdControlsWithTimeLeft(J)V

    .line 77
    invoke-virtual {p1}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->getStartTime()J

    move-result-wide v0

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-eqz v0, :cond_0

    .line 78
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getVideoTrackController()Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;

    move-result-object v0

    invoke-virtual {p1}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->getStartTime()J

    move-result-wide v2

    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->getDuration()J

    move-result-wide v4

    invoke-virtual {v0, v2, v3, v4, v5}, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->onCustomUpdateEvent(JJ)V

    .line 80
    :cond_0
    return-void

    .line 71
    :cond_1
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->hideMainControlsAndActionBar()V

    goto :goto_0
.end method

.method public adComplete(J)V
    .locals 1
    .param p1, "id"    # J

    .prologue
    .line 136
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->hideClickableAdButton()V

    .line 137
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->isClickableAdButtonVisible:Z

    .line 139
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->isAdViewVisible()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 140
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->pause()V

    .line 142
    :cond_0
    return-void
.end method

.method public adProgress(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;IJ)V
    .locals 4
    .param p1, "adBreak"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
    .param p2, "ad"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;
    .param p3, "progress"    # I
    .param p4, "timeRemaining"    # J

    .prologue
    .line 126
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0, p4, p5}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->updateAdTimeLeft(J)V

    .line 128
    invoke-virtual {p2}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->isClickable()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->isClickableAdButtonVisible:Z

    if-nez v0, :cond_0

    if-lez p3, :cond_0

    .line 129
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {p2}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->getClickTitle()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p2}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->getClickUrl()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->showClickableAdButtonForUrl(Ljava/lang/String;Ljava/lang/String;)V

    .line 130
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->isClickableAdButtonVisible:Z

    .line 132
    :cond_0
    return-void
.end method

.method public adStart(Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;)V
    .locals 2
    .param p1, "ad"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    .prologue
    const/4 v1, 0x0

    .line 108
    invoke-virtual {p1}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->isClickable()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 109
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->turnLightsOn()V

    .line 110
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->removeMainControlTimeout()V

    .line 112
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->isAdsActionBarAdjustedForStatusBar()Z

    move-result v0

    if-nez v0, :cond_0

    .line 113
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->moveAdsActionBarDown(Z)V

    .line 122
    :cond_0
    :goto_0
    return-void

    .line 116
    :cond_1
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->isAdsActionBarAdjustedForStatusBar()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 117
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->moveAdsActionBarUp(Z)V

    .line 119
    :cond_2
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->hideClickableAdButton()V

    .line 120
    iput-boolean v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->isClickableAdButtonVisible:Z

    goto :goto_0
.end method

.method public onAMSContinueException(Ljava/lang/Exception;)V
    .locals 3
    .param p1, "e"    # Ljava/lang/Exception;

    .prologue
    .line 146
    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v0

    .line 147
    .local v0, "player":Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;
    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->PLAYING:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->getPlayerStatus()Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 148
    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->pause()V

    .line 150
    :cond_0
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;->onAMSContinueException(Ljava/lang/Exception;)V

    .line 151
    return-void
.end method

.method public onActivityPaused()V
    .locals 6

    .prologue
    const/4 v2, 0x1

    .line 228
    iput-boolean v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->backgrounded:Z

    .line 229
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 230
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->getPlayerStatus()Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    move-result-object v0

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->PLAYING:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    if-ne v0, v1, :cond_0

    .line 231
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->pause()V

    .line 232
    iput-boolean v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->pausedForBackground:Z

    .line 235
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->isAdPlaying()Z

    move-result v0

    if-nez v0, :cond_1

    .line 236
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getVideoTrackController()Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->getPosition()J

    move-result-wide v2

    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->getDuration()J

    move-result-wide v4

    invoke-virtual {v0, v2, v3, v4, v5}, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->onCustomUpdateEvent(JJ)V

    .line 240
    :cond_1
    invoke-super {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;->onActivityPaused()V

    .line 241
    return-void
.end method

.method public onBitrateChanged(JLjava/lang/String;II)V
    .locals 3
    .param p1, "bitrate"    # J
    .param p3, "changeReason"    # Ljava/lang/String;
    .param p4, "videoHeight"    # I
    .param p5, "videoWidth"    # I

    .prologue
    .line 155
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->updateCurrentBitrate(J)V

    .line 156
    sget-object v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->LOG:Lorg/slf4j/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Changing Bitrate to "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1, p2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", reason: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 157
    sget-object v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->LOG:Lorg/slf4j/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Current Height/Width: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 158
    return-void
.end method

.method public onBufferComplete()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 174
    iput-boolean v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->isBuffering:Z

    .line 175
    iput v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->bufferingWarnings:I

    .line 176
    iget-boolean v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->isSeeking:Z

    if-nez v0, :cond_0

    .line 177
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->hideSpinner()V

    .line 179
    :cond_0
    return-void
.end method

.method public onBufferStart()V
    .locals 1

    .prologue
    .line 164
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->shouldUseDownloadFile()Z

    move-result v0

    if-nez v0, :cond_0

    .line 165
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->isBuffering:Z

    .line 166
    iget-boolean v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->isSeeking:Z

    if-nez v0, :cond_0

    .line 167
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->showBuffering()V

    .line 170
    :cond_0
    return-void
.end method

.method public onConnectivityChanged()V
    .locals 3

    .prologue
    .line 211
    iget-boolean v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->isBuffering:Z

    if-eqz v0, :cond_0

    .line 212
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getInternetConnection()Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;->isConnected()Z

    move-result v0

    if-nez v0, :cond_2

    .line 213
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->setWaitingForInternetText()V

    .line 221
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->shouldUseDownloadFile()Z

    move-result v0

    if-nez v0, :cond_1

    .line 222
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    new-instance v1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;

    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-direct {v1, v2, p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    .line 224
    :cond_1
    return-void

    .line 215
    :cond_2
    const/4 v0, 0x0

    iput v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->bufferingWarnings:I

    .line 216
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->showBuffering()V

    goto :goto_0
.end method

.method public onHeadsetButtonEvent(I)V
    .locals 3
    .param p1, "keyEventCode"    # I

    .prologue
    const/16 v2, 0x55

    .line 245
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->isAdPlaying()Z

    move-result v0

    if-nez v0, :cond_1

    .line 246
    const/16 v0, 0x7e

    if-eq p1, v0, :cond_0

    if-ne p1, v2, :cond_2

    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    .line 247
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->getPlayerStatus()Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    move-result-object v0

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->PAUSED:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    if-ne v0, v1, :cond_2

    .line 248
    :cond_0
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->onPlayButton()V

    .line 254
    :cond_1
    :goto_0
    return-void

    .line 249
    :cond_2
    const/16 v0, 0x7f

    if-eq p1, v0, :cond_3

    if-ne p1, v2, :cond_1

    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    .line 250
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->getPlayerStatus()Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    move-result-object v0

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->PLAYING:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    if-ne v0, v1, :cond_1

    .line 251
    :cond_3
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->onPauseButton()V

    goto :goto_0
.end method

.method public onHeadsetNoiseDetected()V
    .locals 2

    .prologue
    .line 257
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->isAdPlaying()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    .line 258
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->getPlayerStatus()Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    move-result-object v0

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->PLAYING:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    if-ne v0, v1, :cond_0

    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->isLiveStream()Z

    move-result v0

    if-nez v0, :cond_0

    .line 259
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->onPauseButton()V

    .line 261
    :cond_0
    return-void
.end method

.method public onMediaWarning(Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "code"    # Ljava/lang/String;
    .param p2, "description"    # Ljava/lang/String;

    .prologue
    .line 198
    new-instance v0, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformErrorException;

    invoke-direct {v0, p1, p2}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformErrorException;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 199
    .local v0, "platformError":Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformErrorException;
    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformErrorException;->getMajorCode()I

    move-result v1

    const v2, 0x330cc

    if-ne v1, v2, :cond_0

    iget-boolean v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->isBuffering:Z

    if-eqz v1, :cond_0

    .line 200
    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getInternetConnection()Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    move-result-object v1

    invoke-virtual {v1}, Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;->isConnected()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 201
    iget v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->bufferingWarnings:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->bufferingWarnings:I

    .line 202
    iget v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->bufferingWarnings:I

    const/4 v2, 0x3

    if-lt v1, v2, :cond_0

    .line 203
    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->setWaitingForInternetText()V

    .line 207
    :cond_0
    return-void
.end method

.method public onVideoSeekComplete()V
    .locals 1

    .prologue
    .line 189
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->isSeeking:Z

    .line 190
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->hideSpinner()V

    .line 191
    iget-boolean v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->isBuffering:Z

    if-eqz v0, :cond_0

    .line 192
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->showBuffering()V

    .line 194
    :cond_0
    return-void
.end method

.method public onVideoSeekStart()V
    .locals 1

    .prologue
    .line 183
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->isSeeking:Z

    .line 184
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->showSeeking()V

    .line 185
    return-void
.end method

.method public run()V
    .locals 4

    .prologue
    const/4 v1, 0x0

    .line 39
    iget-boolean v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->backgrounded:Z

    if-eqz v0, :cond_0

    .line 40
    iget-boolean v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->pausedForBackground:Z

    if-eqz v0, :cond_3

    .line 41
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->play()V

    .line 50
    :goto_0
    iput-boolean v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->backgrounded:Z

    .line 51
    iput-boolean v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->pausedForBackground:Z

    .line 52
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->isAdPlaying()Z

    move-result v0

    if-nez v0, :cond_0

    .line 53
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->startRatingsBug()V

    .line 54
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->setupAccessibilityControlToggle()V

    .line 58
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->isAdPlaying()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 59
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->isClickableAdsButtonVisibile()Z

    move-result v0

    if-nez v0, :cond_1

    .line 60
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->hideAllControls()V

    .line 62
    :cond_1
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getAdDuration()J

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->showAdControlsWithTimeLeft(J)V

    .line 64
    :cond_2
    return-void

    .line 46
    :cond_3
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->PAUSED:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->onPlayStateChanged(Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;)V

    goto :goto_0
.end method

.method public transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V
    .locals 1
    .param p1, "videoState"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    .prologue
    .line 30
    instance-of v0, p1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ResetPlayerState;

    if-eqz v0, :cond_0

    .line 31
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->setState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    .line 35
    :goto_0
    return-void

    .line 33
    :cond_0
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    goto :goto_0
.end method
