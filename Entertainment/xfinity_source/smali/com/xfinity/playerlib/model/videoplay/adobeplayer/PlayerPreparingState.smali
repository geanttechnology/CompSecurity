.class public Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;
.super Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;
.source "PlayerPreparingState.java"


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 14
    const-class v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)V
    .locals 0
    .param p1, "stateController"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    .prologue
    .line 18
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)V

    .line 19
    return-void
.end method

.method private lockBitrate()V
    .locals 8

    .prologue
    .line 156
    iget-object v4, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v4}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v4

    invoke-virtual {v4}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->getAvailableBitrates()Ljava/util/List;

    move-result-object v0

    .line 157
    .local v0, "availableBitrates":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Integer;>;"
    const/4 v3, 0x0

    .line 158
    .local v3, "constantBitrate":I
    if-eqz v0, :cond_2

    .line 159
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :cond_0
    :goto_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/Integer;

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v1

    .line 160
    .local v1, "bitrate":I
    const v4, 0x16e360

    if-gt v1, v4, :cond_0

    if-le v1, v3, :cond_0

    .line 161
    move v3, v1

    goto :goto_0

    .line 165
    .end local v1    # "bitrate":I
    :cond_1
    if-nez v3, :cond_2

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v4

    if-nez v4, :cond_2

    .line 166
    const/4 v4, 0x0

    invoke-interface {v0, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/Integer;

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v3

    .line 170
    :cond_2
    if-nez v3, :cond_3

    .line 171
    new-instance v4, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;

    iget-object v5, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    iget-object v6, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v6}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getActivityContext()Landroid/app/Activity;

    move-result-object v6

    sget v7, Lcom/xfinity/playerlib/R$string;->player_platform_error_msg_playlist_problem:I

    invoke-virtual {v6, v7}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-direct {v4, v5, v6}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;Ljava/lang/String;)V

    invoke-virtual {p0, v4}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    .line 178
    :goto_1
    return-void

    .line 175
    :cond_3
    new-instance v2, Lcom/comcast/playerplatform/util/android/BitrateParameters;

    invoke-direct {v2, v3, v3, v3}, Lcom/comcast/playerplatform/util/android/BitrateParameters;-><init>(III)V

    .line 176
    .local v2, "bitrateParameters":Lcom/comcast/playerplatform/util/android/BitrateParameters;
    iget-object v4, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v4}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v4

    invoke-virtual {v4, v2}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->setBitrateParameters(Lcom/comcast/playerplatform/util/android/BitrateParameters;)V

    .line 177
    iget-object v4, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v4}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v4

    invoke-virtual {v4}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->play()V

    goto :goto_1
.end method

.method private preparePlayer()V
    .locals 7

    .prologue
    .line 45
    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v1

    sget v4, Lcom/xfinity/playerlib/R$string;->player_launch_preparing:I

    invoke-virtual {v1, v4}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->setLaunchScreenMessage(I)V

    .line 47
    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getVideoTrackController()Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->getResumePoint()J

    move-result-wide v2

    .line 48
    .local v2, "resumePoint":J
    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->createAsset()Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    move-result-object v0

    .line 49
    .local v0, "asset":Lcom/comcast/playerplatform/primetime/android/asset/Asset;
    if-nez v0, :cond_0

    .line 50
    new-instance v1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;

    iget-object v4, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    iget-object v5, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v5}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getActivityContext()Landroid/app/Activity;

    move-result-object v5

    sget v6, Lcom/xfinity/playerlib/R$string;->video_playback_error_msg_default:I

    invoke-virtual {v5, v6}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v1, v4, v5}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;Ljava/lang/String;)V

    invoke-virtual {p0, v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    .line 54
    :goto_0
    return-void

    .line 52
    :cond_0
    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v1

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-virtual {v1, v0, v4}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->prepare(Lcom/comcast/playerplatform/primetime/android/asset/Asset;Ljava/lang/Long;)V

    goto :goto_0
.end method


# virtual methods
.method public getStateName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 32
    const-string v0, "PlayerPreparingState"

    return-object v0
.end method

.method public onAcquiringLicense(Ljava/lang/String;)V
    .locals 2
    .param p1, "manifestUri"    # Ljava/lang/String;

    .prologue
    .line 146
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    sget v1, Lcom/xfinity/playerlib/R$string;->player_launch_acquiring_license:I

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->setLaunchScreenMessage(I)V

    .line 147
    return-void
.end method

.method public onMediaOpened(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;JJDZ)V
    .locals 0
    .param p1, "type"    # Ljava/lang/String;
    .param p2, "mediaType"    # Ljava/lang/String;
    .param p3, "playbackSpeeds"    # Ljava/util/List;
    .param p4, "availableAudioLanguages"    # Ljava/util/List;
    .param p5, "width"    # J
    .param p7, "height"    # J
    .param p9, "openingLatency"    # D
    .param p11, "hasCC"    # Z

    .prologue
    .line 181
    return-void
.end method

.method public onPlayStateChanged(Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;)V
    .locals 9
    .param p1, "status"    # Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    .prologue
    const/16 v8, 0x8

    const/4 v5, 0x0

    const/4 v4, 0x1

    .line 58
    sget-object v3, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->PREPARED:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    if-ne p1, v3, :cond_4

    .line 59
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getLiveStream()Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    move-result-object v3

    if-nez v3, :cond_0

    .line 60
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v3

    iget-object v4, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v4}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v4

    invoke-virtual {v4}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->getTimeline()Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->setupAdBreaks(Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;)V

    .line 63
    :cond_0
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getAndroidDevice()Lcom/comcast/cim/model/system/PlayerAndroidDevice;

    move-result-object v3

    invoke-virtual {v3}, Lcom/comcast/cim/model/system/PlayerAndroidDevice;->wantsStaticBitrate()Z

    move-result v3

    if-nez v3, :cond_1

    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUserManager()Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v3

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v3

    check-cast v3, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getWantsStaticBitrate()Z

    move-result v3

    if-eqz v3, :cond_3

    .line 64
    :cond_1
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->lockBitrate()V

    .line 142
    :cond_2
    :goto_0
    return-void

    .line 65
    :cond_3
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v3

    invoke-virtual {v3}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->getAutoPlay()Z

    move-result v3

    if-nez v3, :cond_2

    .line 66
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v3

    invoke-virtual {v3}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->play()V

    .line 67
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v3

    invoke-virtual {v3}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->hideSpinner()V

    goto :goto_0

    .line 70
    :cond_4
    sget-object v3, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->PAUSED:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    if-ne p1, v3, :cond_5

    .line 73
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v3

    invoke-virtual {v3}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->play()V

    goto :goto_0

    .line 74
    :cond_5
    sget-object v3, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->PLAYING:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    if-ne p1, v3, :cond_2

    .line 75
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v3

    iget-object v6, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v6}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v6

    invoke-virtual {v6}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->getDuration()J

    move-result-wide v6

    invoke-virtual {v3, v6, v7}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->setVideoDuration(J)V

    .line 76
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v3

    invoke-virtual {v3}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->hideLaunchScreen()V

    .line 78
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->hasPreroll()Z

    move-result v3

    if-nez v3, :cond_b

    move v2, v4

    .line 80
    .local v2, "showControls":Z
    :goto_1
    if-eqz v2, :cond_6

    .line 81
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v3

    invoke-virtual {v3}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->startRatingsBug()V

    .line 83
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v3

    invoke-virtual {v3}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->startMainControlTimeout()V

    .line 84
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v3

    invoke-virtual {v3}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->showMainControlsWithPauseButton()V

    .line 88
    :cond_6
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getDownloadedFile()Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    move-result-object v3

    if-nez v3, :cond_7

    .line 89
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->scheduleAmsContinueCalls()V

    .line 92
    :cond_7
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v3

    invoke-virtual {v3}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->styleClosedCaptions()V

    .line 94
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->isCC()Z

    move-result v3

    if-eqz v3, :cond_c

    .line 95
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v3

    invoke-virtual {v3, v5}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->setCCButtonVisibility(I)V

    .line 96
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v3

    invoke-virtual {v3, v4}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->setCCButtonEnabled(Z)V

    .line 99
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUserManager()Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v3

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v3

    check-cast v3, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getWantsClosedCaptions()Z

    move-result v3

    if-eqz v3, :cond_8

    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v3

    invoke-virtual {v3}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->hasCC()Z

    move-result v3

    if-eqz v3, :cond_8

    .line 100
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v3

    invoke-virtual {v3, v4}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->setCCEnabled(Z)V

    .line 101
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v3

    invoke-virtual {v3, v4}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->setCCButtonSelected(Z)V

    .line 112
    :cond_8
    :goto_2
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v3

    invoke-virtual {v3}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->getAvailableLanguages()Ljava/util/List;

    move-result-object v1

    .line 113
    .local v1, "languageList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v3

    if-le v3, v4, :cond_e

    .line 114
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v3

    invoke-virtual {v3, v5}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->setSAPButtonVisibility(I)V

    .line 115
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v3

    invoke-virtual {v3, v4}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->setSAPButtonEnabled(Z)V

    .line 117
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUserManager()Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v3

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v3

    check-cast v3, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getAudioTrackIndex()I

    move-result v0

    .line 118
    .local v0, "audioTrackIndex":I
    if-ltz v0, :cond_9

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v3

    if-le v3, v0, :cond_9

    .line 119
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v3

    invoke-virtual {v3, v0}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->setLanguage(I)V

    .line 120
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v3

    invoke-virtual {v3, v4}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->setSAPButtonSelected(Z)V

    .line 132
    .end local v0    # "audioTrackIndex":I
    :cond_9
    :goto_3
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    new-instance v6, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;

    iget-object v7, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-direct {v6, v7}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)V

    invoke-virtual {v3, v6}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    .line 134
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->isLiveStream()Z

    move-result v3

    if-eqz v3, :cond_a

    .line 135
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getVideoTrackController()Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;

    move-result-object v3

    invoke-virtual {v3}, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->trackOmnitureLiveStreamStartedMilestone()V

    .line 139
    :cond_a
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v6

    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->isCC()Z

    move-result v7

    .line 140
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v3

    if-le v3, v4, :cond_10

    move v3, v4

    .line 139
    :goto_4
    invoke-virtual {v6, v7, v3}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->announceSapAndCcStates(ZZ)V

    goto/16 :goto_0

    .end local v1    # "languageList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v2    # "showControls":Z
    :cond_b
    move v2, v5

    .line 78
    goto/16 :goto_1

    .line 104
    .restart local v2    # "showControls":Z
    :cond_c
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->isLiveStream()Z

    move-result v3

    if-eqz v3, :cond_d

    .line 105
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v3

    invoke-virtual {v3, v5}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->setCCButtonVisibility(I)V

    .line 106
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v3

    invoke-virtual {v3, v5}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->setCCButtonEnabled(Z)V

    goto/16 :goto_2

    .line 108
    :cond_d
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v3

    invoke-virtual {v3, v8}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->setCCButtonVisibility(I)V

    goto/16 :goto_2

    .line 123
    .restart local v1    # "languageList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :cond_e
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->isLiveStream()Z

    move-result v3

    if-eqz v3, :cond_f

    .line 124
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v3

    invoke-virtual {v3, v5}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->setSAPButtonVisibility(I)V

    .line 125
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v3

    invoke-virtual {v3, v5}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->setSAPButtonEnabled(Z)V

    goto :goto_3

    .line 127
    :cond_f
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v3

    invoke-virtual {v3, v8}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->setSAPButtonVisibility(I)V

    goto/16 :goto_3

    :cond_10
    move v3, v5

    .line 140
    goto :goto_4
.end method

.method public run()V
    .locals 2

    .prologue
    .line 37
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->getPlayerStatus()Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    move-result-object v0

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->IDLE:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    if-ne v0, v1, :cond_0

    .line 38
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->preparePlayer()V

    .line 42
    :goto_0
    return-void

    .line 40
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->getPlayerStatus()Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->onPlayStateChanged(Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;)V

    goto :goto_0
.end method

.method public transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V
    .locals 1
    .param p1, "videoState"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    .prologue
    .line 23
    instance-of v0, p1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;

    if-eqz v0, :cond_0

    .line 24
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->setState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    .line 28
    :goto_0
    return-void

    .line 26
    :cond_0
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    goto :goto_0
.end method
