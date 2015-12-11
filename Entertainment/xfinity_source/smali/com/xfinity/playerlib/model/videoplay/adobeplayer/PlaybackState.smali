.class public Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;
.super Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;
.source "PlaybackState.java"


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 11
    const-class v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)V
    .locals 0
    .param p1, "stateController"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    .prologue
    .line 18
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)V

    .line 19
    return-void
.end method


# virtual methods
.method public getStateName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 34
    const-string v0, "PlaybackState"

    return-object v0
.end method

.method public onBabyGuideButton()V
    .locals 4

    .prologue
    .line 105
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->isAdPlaying()Z

    move-result v0

    if-nez v0, :cond_0

    .line 106
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    new-instance v1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;

    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    sget-object v3, Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;->BABY_GUIDE:Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;

    invoke-direct {v1, v2, v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;)V

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    .line 108
    :cond_0
    return-void
.end method

.method public onBackButton()V
    .locals 6

    .prologue
    .line 45
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->isAdViewVisible()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 46
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->hideAdView()V

    .line 53
    :goto_0
    return-void

    .line 48
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->isLiveStream()Z

    move-result v0

    if-nez v0, :cond_1

    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->isAdPlaying()Z

    move-result v0

    if-nez v0, :cond_1

    .line 49
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getVideoTrackController()Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->getPosition()J

    move-result-wide v2

    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->getDuration()J

    move-result-wide v4

    invoke-virtual {v0, v2, v3, v4, v5}, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->onEndPlayback(JJ)V

    .line 52
    :cond_1
    invoke-super {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->onBackButton()V

    goto :goto_0
.end method

.method public onCCButton()V
    .locals 6

    .prologue
    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 138
    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->isAdPlaying()Z

    move-result v2

    if-nez v2, :cond_1

    .line 139
    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUserManager()Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getWantsClosedCaptions()Z

    move-result v1

    .line 141
    .local v1, "on":Z
    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v5

    if-nez v1, :cond_2

    move v2, v3

    :goto_0
    invoke-virtual {v5, v2}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->setCCEnabled(Z)V

    .line 142
    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v5

    if-nez v1, :cond_3

    move v2, v3

    :goto_1
    invoke-virtual {v5, v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->setCCButtonSelected(Z)V

    .line 143
    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUserManager()Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    if-nez v1, :cond_4

    :goto_2
    invoke-virtual {v2, v3}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->setWantsClosedCaptions(Z)V

    .line 144
    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUserManager()Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    if-eqz v1, :cond_0

    const/4 v4, -0x1

    :cond_0
    invoke-virtual {v2, v4}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->setCCTrackIndex(I)V

    .line 146
    new-instance v0, Lcom/comcast/cim/analytics/XfinityEventData;

    const-string v2, "Toggle CC"

    invoke-direct {v0, v2}, Lcom/comcast/cim/analytics/XfinityEventData;-><init>(Ljava/lang/String;)V

    .line 147
    .local v0, "eventData":Lcom/comcast/cim/cmasl/analytics/EventData;
    const-string v3, "State"

    if-nez v1, :cond_5

    const-string v2, "On"

    :goto_3
    invoke-virtual {v0, v3, v2}, Lcom/comcast/cim/cmasl/analytics/EventData;->addData(Ljava/lang/String;Ljava/lang/String;)V

    .line 148
    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getSplunker()Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;

    move-result-object v2

    invoke-interface {v2, v0}, Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;->logData(Lcom/comcast/cim/cmasl/analytics/EventData;)V

    .line 150
    .end local v0    # "eventData":Lcom/comcast/cim/cmasl/analytics/EventData;
    .end local v1    # "on":Z
    :cond_1
    return-void

    .restart local v1    # "on":Z
    :cond_2
    move v2, v4

    .line 141
    goto :goto_0

    :cond_3
    move v2, v4

    .line 142
    goto :goto_1

    :cond_4
    move v3, v4

    .line 143
    goto :goto_2

    .line 147
    .restart local v0    # "eventData":Lcom/comcast/cim/cmasl/analytics/EventData;
    :cond_5
    const-string v2, "Off"

    goto :goto_3
.end method

.method public onDurationChanged(J)V
    .locals 1
    .param p1, "duration"    # J

    .prologue
    .line 63
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->updateProgress()V

    .line 64
    return-void
.end method

.method public onFavoritesButton()V
    .locals 4

    .prologue
    .line 119
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->isAdPlaying()Z

    move-result v0

    if-nez v0, :cond_0

    .line 120
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    new-instance v1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;

    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    sget-object v3, Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;->FAVORITE:Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;

    invoke-direct {v1, v2, v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;)V

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    .line 122
    :cond_0
    return-void
.end method

.method public onHistoryButton()V
    .locals 4

    .prologue
    .line 112
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->isAdPlaying()Z

    move-result v0

    if-nez v0, :cond_0

    .line 113
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    new-instance v1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;

    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    sget-object v3, Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;->HISTORY:Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;

    invoke-direct {v1, v2, v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;)V

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    .line 115
    :cond_0
    return-void
.end method

.method public onMediaProgress(JDJJI)V
    .locals 1
    .param p1, "position"    # J
    .param p3, "playbackSpeed"    # D
    .param p5, "startPosition"    # J
    .param p7, "endPosition"    # J
    .param p9, "updateInterval"    # I

    .prologue
    .line 57
    invoke-super/range {p0 .. p9}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->onMediaProgress(JDJJI)V

    .line 58
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->updateProgress()V

    .line 59
    return-void
.end method

.method public onPauseButton()V
    .locals 2

    .prologue
    .line 173
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->isAdPlaying()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->getPlayerStatus()Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    move-result-object v0

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->PLAYING:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    if-ne v0, v1, :cond_0

    .line 174
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->pause()V

    .line 177
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->removeVolumeControlTimeout()V

    .line 178
    return-void
.end method

.method public onPlayButton()V
    .locals 2

    .prologue
    .line 164
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->isAdPlaying()Z

    move-result v0

    if-nez v0, :cond_1

    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    .line 165
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->getPlayerStatus()Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    move-result-object v0

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->PAUSED:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    if-eq v0, v1, :cond_0

    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    .line 166
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->getPlayerStatus()Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    move-result-object v0

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->SUSPENDED:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    if-ne v0, v1, :cond_1

    .line 167
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->play()V

    .line 169
    :cond_1
    return-void
.end method

.method public onPlayStateChanged(Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;)V
    .locals 6
    .param p1, "status"    # Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    .prologue
    .line 69
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->PLAYING:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    invoke-virtual {p1, v0}, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 70
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->isAdPlaying()Z

    move-result v0

    if-nez v0, :cond_0

    .line 72
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->isAccessibilityModeOn()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 74
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->removeMainControlTimeout()V

    .line 76
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->isManualControlToggleOn()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 77
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->showMainControlsWithPauseButton()V

    .line 101
    :cond_0
    :goto_0
    return-void

    .line 79
    :cond_1
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->hideAllControls()V

    goto :goto_0

    .line 83
    :cond_2
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->isMainControlShowing()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 84
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->removeMainControlTimeout()V

    .line 85
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->hideAllControls()V

    goto :goto_0

    .line 87
    :cond_3
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->startMainControlTimeout()V

    .line 88
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->showMainControlsWithPauseButton()V

    goto :goto_0

    .line 92
    :cond_4
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->PAUSED:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    invoke-virtual {p1, v0}, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 93
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->isAdPlaying()Z

    move-result v0

    if-nez v0, :cond_0

    .line 94
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->removeMainControlTimeout()V

    .line 95
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->showMainControlsWithPlayButton()V

    goto :goto_0

    .line 97
    :cond_5
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->COMPLETE:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    invoke-virtual {p1, v0}, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 98
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getVideoTrackController()Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->getPosition()J

    move-result-wide v2

    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->getDuration()J

    move-result-wide v4

    invoke-virtual {v0, v2, v3, v4, v5}, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->onEndPlayback(JJ)V

    .line 99
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    new-instance v1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/EndCardState;

    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-direct {v1, v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/EndCardState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)V

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    goto/16 :goto_0
.end method

.method public onSAPButton()V
    .locals 2

    .prologue
    .line 154
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->isAdPlaying()Z

    move-result v0

    if-nez v0, :cond_0

    .line 155
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->getAvailableLanguages()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    const/4 v1, 0x1

    if-le v0, v1, :cond_0

    .line 156
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->removeMainControlTimeout()V

    .line 157
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->showSAPSelectionDialog()V

    .line 160
    :cond_0
    return-void
.end method

.method public onScreenTouch()V
    .locals 1

    .prologue
    .line 126
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->isDialogShowing()Z

    move-result v0

    if-nez v0, :cond_0

    .line 127
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->isAdPlaying()Z

    move-result v0

    if-nez v0, :cond_1

    .line 128
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->getPlayerStatus()Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->onPlayStateChanged(Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;)V

    .line 134
    :cond_0
    :goto_0
    return-void

    .line 129
    :cond_1
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->isAdViewVisible()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->isCurrentAdClickable()Z

    move-result v0

    if-nez v0, :cond_0

    .line 130
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->startMainControlTimeout()V

    .line 131
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->startAdsActionBarTimeout()V

    goto :goto_0
.end method

.method public onSeekRequest(J)V
    .locals 3
    .param p1, "position"    # J

    .prologue
    .line 182
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->isAdPlaying()Z

    move-result v0

    if-nez v0, :cond_0

    .line 183
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, p1, p2, v1}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->setPosition(JZ)V

    .line 185
    :cond_0
    return-void
.end method

.method public onTimelineUpdated()V
    .locals 2

    .prologue
    .line 222
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->getTimeline()Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->setupAdBreaks(Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;)V

    .line 223
    return-void
.end method

.method public onUserMovedSeekBar(I)V
    .locals 1
    .param p1, "progress"    # I

    .prologue
    .line 207
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->showThumbTimeView(I)V

    .line 208
    return-void
.end method

.method public onUserSeekEnded(Z)V
    .locals 2
    .param p1, "willSeek"    # Z

    .prologue
    .line 195
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->getPlayerStatus()Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    move-result-object v0

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->PLAYING:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    if-ne v0, v1, :cond_0

    .line 196
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->startMainControlTimeout()V

    .line 198
    :cond_0
    if-nez p1, :cond_1

    iget-boolean v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->isSeeking:Z

    if-nez v0, :cond_1

    .line 201
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    const/4 v1, 0x0

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->setIsSeeking(Ljava/lang/Boolean;)V

    .line 203
    :cond_1
    return-void
.end method

.method public onUserSeekStarted()V
    .locals 2

    .prologue
    .line 189
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->removeMainControlTimeout()V

    .line 190
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    const/4 v1, 0x1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->setIsSeeking(Ljava/lang/Boolean;)V

    .line 191
    return-void
.end method

.method public onVolumeChanged()V
    .locals 2

    .prologue
    .line 213
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->getPlayerStatus()Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    move-result-object v0

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->PLAYING:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    if-ne v0, v1, :cond_0

    .line 214
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->isDialogShowing()Z

    move-result v0

    if-nez v0, :cond_0

    .line 215
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->startMainControlTimeout()V

    .line 218
    :cond_0
    return-void
.end method

.method public run()V
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->updateProgress()V

    .line 40
    invoke-super {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->run()V

    .line 41
    return-void
.end method

.method public transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V
    .locals 1
    .param p1, "videoState"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    .prologue
    .line 23
    instance-of v0, p1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;

    if-nez v0, :cond_0

    instance-of v0, p1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/EndCardState;

    if-nez v0, :cond_0

    instance-of v0, p1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;

    if-eqz v0, :cond_1

    .line 26
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->setState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    .line 30
    :goto_0
    return-void

    .line 28
    :cond_1
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    goto :goto_0
.end method
