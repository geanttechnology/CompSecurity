.class public Lcom/xfinity/playerlib/model/videoplay/adobeplayer/SetupMediaPlayerState;
.super Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;
.source "SetupMediaPlayerState.java"


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private configurationEventListener:Lcom/xfinity/playerlib/model/videoplay/PlayerConfigurationListener;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 13
    const-class v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/SetupMediaPlayerState;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/SetupMediaPlayerState;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)V
    .locals 1
    .param p1, "stateController"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    .prologue
    .line 30
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)V

    .line 15
    new-instance v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/SetupMediaPlayerState$1;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/SetupMediaPlayerState$1;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/SetupMediaPlayerState;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/SetupMediaPlayerState;->configurationEventListener:Lcom/xfinity/playerlib/model/videoplay/PlayerConfigurationListener;

    .line 31
    return-void
.end method


# virtual methods
.method public getStateName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 44
    const-string v0, "SetupMediaPlayerState"

    return-object v0
.end method

.method public onActivityResumed()V
    .locals 0

    .prologue
    .line 49
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/SetupMediaPlayerState;->run()V

    .line 50
    return-void
.end method

.method public onConfigurationLoaded()V
    .locals 9

    .prologue
    const/4 v8, 0x0

    .line 54
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/SetupMediaPlayerState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->initPlayerPlatformMediaPlayer()V

    .line 57
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/SetupMediaPlayerState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->setupVideoView()V

    .line 60
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/SetupMediaPlayerState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getPlayerApplication()Lcom/xfinity/playerlib/PlayerApplication;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/PlayerApplication;->getInstallId()Ljava/lang/String;

    move-result-object v3

    .line 61
    .local v3, "deviceID":Ljava/lang/String;
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/SetupMediaPlayerState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v6

    .line 62
    .local v6, "mediaPlayer":Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/SetupMediaPlayerState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getPlayerApplication()Lcom/xfinity/playerlib/PlayerApplication;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/PlayerApplication;->getVersionNumber()Ljava/lang/String;

    move-result-object v2

    .line 64
    .local v2, "buildNumber":Ljava/lang/String;
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/util/HostInfo;

    const-string v1, "tvgo-android"

    sget-object v4, Landroid/os/Build;->MODEL:Ljava/lang/String;

    sget-object v5, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    invoke-direct/range {v0 .. v5}, Lcom/comcast/playerplatform/analytics/java/util/HostInfo;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v6, v0}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->configureAnalytics(Lcom/comcast/playerplatform/analytics/java/util/HostInfo;)V

    .line 66
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies;

    invoke-direct {v0}, Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies;-><init>()V

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;->REMOVE:Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;

    .line 67
    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies;->setPreRollPolicy(Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;)Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies;

    move-result-object v0

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;->KEEP:Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;

    .line 68
    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies;->setMidRollPolicy(Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;)Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies;

    move-result-object v0

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;->REMOVE:Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;

    .line 69
    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies;->setPostRollPolicy(Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;)Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies;

    move-result-object v0

    .line 66
    invoke-virtual {v6, v0}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->setPlayerAdBreakPolicies(Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies;)V

    .line 71
    const/4 v0, 0x0

    invoke-virtual {v6, v0}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->setAutoPlay(Z)V

    .line 73
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/SetupMediaPlayerState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    new-instance v1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;

    iget-object v4, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/SetupMediaPlayerState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    new-instance v5, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;

    iget-object v7, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/SetupMediaPlayerState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-direct {v5, v7, v8, v8}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;Lcom/comcast/cim/android/view/common/PinKeypadFragment$PinValidationCompletedListener;Ljava/lang/String;)V

    invoke-direct {v1, v4, v5}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    .line 74
    return-void
.end method

.method public run()V
    .locals 2

    .prologue
    .line 78
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/SetupMediaPlayerState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getPlayerConfigUtil()Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/SetupMediaPlayerState;->configurationEventListener:Lcom/xfinity/playerlib/model/videoplay/PlayerConfigurationListener;

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;->configurePlayerPlatform(Lcom/xfinity/playerlib/model/videoplay/PlayerConfigurationListener;)V

    .line 79
    return-void
.end method

.method public transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V
    .locals 1
    .param p1, "state"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    .prologue
    .line 35
    instance-of v0, p1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;

    if-eqz v0, :cond_0

    .line 36
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/SetupMediaPlayerState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->setState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    .line 40
    :goto_0
    return-void

    .line 38
    :cond_0
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    goto :goto_0
.end method
