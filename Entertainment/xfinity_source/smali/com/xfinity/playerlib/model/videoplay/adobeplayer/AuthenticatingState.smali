.class public Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;
.super Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;
.source "AuthenticatingState.java"

# interfaces
.implements Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$VPMediaAuthorizationListener;


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private pin:Ljava/lang/String;

.field private validationCompletedListener:Lcom/comcast/cim/android/view/common/PinKeypadFragment$PinValidationCompletedListener;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 23
    const-class v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;Lcom/comcast/cim/android/view/common/PinKeypadFragment$PinValidationCompletedListener;Ljava/lang/String;)V
    .locals 0
    .param p1, "stateController"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    .param p2, "validationCompletedListener"    # Lcom/comcast/cim/android/view/common/PinKeypadFragment$PinValidationCompletedListener;
    .param p3, "pin"    # Ljava/lang/String;

    .prologue
    .line 29
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)V

    .line 30
    iput-object p2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->validationCompletedListener:Lcom/comcast/cim/android/view/common/PinKeypadFragment$PinValidationCompletedListener;

    .line 31
    iput-object p3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->pin:Ljava/lang/String;

    .line 32
    return-void
.end method

.method static synthetic access$000(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;Lcom/xfinity/playerlib/model/consumable/VideoFacade;)Z
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;
    .param p1, "x1"    # Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;
    .param p2, "x2"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    .prologue
    .line 22
    invoke-direct {p0, p1, p2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->pinRequiredForVideo(Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;Lcom/xfinity/playerlib/model/consumable/VideoFacade;)Z

    move-result v0

    return v0
.end method

.method private checkHidePinPadFragment()V
    .locals 2

    .prologue
    .line 179
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->validationCompletedListener:Lcom/comcast/cim/android/view/common/PinKeypadFragment$PinValidationCompletedListener;

    if-eqz v0, :cond_0

    .line 180
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->validationCompletedListener:Lcom/comcast/cim/android/view/common/PinKeypadFragment$PinValidationCompletedListener;

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->hidePinPadFragment(Lcom/comcast/cim/android/view/common/PinKeypadFragment$PinValidationCompletedListener;)V

    .line 182
    :cond_0
    return-void
.end method

.method private performAMSAuthentication(Ljava/lang/String;)V
    .locals 2
    .param p1, "pin"    # Ljava/lang/String;

    .prologue
    .line 116
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getVideoFacade()Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->setLaunchMaturityRating(Lcom/xfinity/playerlib/model/consumable/VideoFacade;)V

    .line 117
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    sget v1, Lcom/xfinity/playerlib/R$string;->player_launch_authenticating:I

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->setLaunchScreenMessage(I)V

    .line 118
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaStreamExecutor()Ljava/util/concurrent/Executor;

    move-result-object v0

    new-instance v1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState$1;

    invoke-direct {v1, p0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState$1;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;Ljava/lang/String;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 171
    return-void
.end method

.method private pinRequiredForVideo(Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;Lcom/xfinity/playerlib/model/consumable/VideoFacade;)Z
    .locals 4
    .param p1, "pcSettings"    # Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;
    .param p2, "video"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    .prologue
    .line 185
    invoke-virtual {p1}, Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;->getProtectedRatings()Ljava/util/List;

    move-result-object v0

    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getVideoRating()Lcom/comcast/cim/model/Rating;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-virtual {p1}, Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;->getProtectedNetworkIds()Ljava/util/List;

    move-result-object v0

    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getNetworkInfo()Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->getNetworkId()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public getStateName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 47
    const-string v0, "AuthenticatingState"

    return-object v0
.end method

.method public onAmsAuthenticationException(Ljava/lang/Exception;)V
    .locals 0
    .param p1, "e"    # Ljava/lang/Exception;

    .prologue
    .line 65
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->checkHidePinPadFragment()V

    .line 67
    invoke-virtual {p0, p1, p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->handleExceptionCaughtDuringAmsOperation(Ljava/lang/Exception;Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    .line 68
    return-void
.end method

.method public onAmsAuthenticationSuccess()V
    .locals 6

    .prologue
    .line 73
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->checkHidePinPadFragment()V

    .line 76
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->shouldUseDownloadFile()Z

    move-result v3

    if-nez v3, :cond_3

    .line 77
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->isLiveStream()Z

    move-result v3

    if-eqz v3, :cond_2

    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getLiveStream()Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    move-result-object v3

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->isEspn()Z

    move-result v3

    if-nez v3, :cond_0

    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getLiveStream()Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    move-result-object v3

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->isDisney()Z

    move-result v3

    if-eqz v3, :cond_2

    .line 78
    :cond_0
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    iget-object v4, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v4}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getVideoAuthManager()Lcom/xfinity/playerlib/authorization/VideoAuthManager;

    move-result-object v4

    invoke-virtual {v4}, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->getVideoAuthToken()Lcom/xfinity/playerlib/authorization/VideoAuthToken;

    move-result-object v4

    invoke-virtual {v4}, Lcom/xfinity/playerlib/authorization/VideoAuthToken;->getRawData()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->setDrmKey(Ljava/lang/String;)V

    .line 86
    :goto_0
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->shouldUseDownloadFile()Z

    move-result v3

    if-nez v3, :cond_1

    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->isLiveStream()Z

    move-result v3

    if-nez v3, :cond_1

    .line 87
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getVideoAuthManager()Lcom/xfinity/playerlib/authorization/VideoAuthManager;

    move-result-object v3

    invoke-virtual {v3}, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->getSmil()Lcom/xfinity/playerlib/authorization/SMILResource;

    move-result-object v3

    invoke-virtual {v3}, Lcom/xfinity/playerlib/authorization/SMILResource;->getAdsType()Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;

    move-result-object v1

    .line 90
    .local v1, "adsType":Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;
    :try_start_0
    sget-object v3, Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;->C3_ADS:Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;

    invoke-virtual {v1, v3}, Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    .line 91
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getVideoAuthManager()Lcom/xfinity/playerlib/authorization/VideoAuthManager;

    move-result-object v3

    invoke-virtual {v3}, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->getSmil()Lcom/xfinity/playerlib/authorization/SMILResource;

    move-result-object v3

    invoke-virtual {v3}, Lcom/xfinity/playerlib/authorization/SMILResource;->getC3Blocks()Ljava/util/List;

    move-result-object v0

    .line 92
    .local v0, "adBreaks":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;>;"
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v3

    invoke-virtual {v3, v0}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->configureC3Ads(Ljava/util/List;)V
    :try_end_0
    .catch Ljava/lang/ClassCastException; {:try_start_0 .. :try_end_0} :catch_0

    .line 101
    .end local v0    # "adBreaks":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;>;"
    .end local v1    # "adsType":Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;
    :cond_1
    :goto_1
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->shouldUseDownloadFile()Z

    move-result v3

    if-eqz v3, :cond_5

    .line 102
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "http://127.0.0.1:"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v5}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getHttpPort()I

    move-result v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "/variant.m3u8"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->setManifestUrl(Ljava/lang/String;)V

    .line 103
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    new-instance v4, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InitializeLocalHostState;

    iget-object v5, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-direct {v4, v5}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InitializeLocalHostState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)V

    invoke-virtual {v3, v4}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    .line 112
    :goto_2
    return-void

    .line 80
    :cond_2
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    iget-object v4, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v4}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getVideoAuthManager()Lcom/xfinity/playerlib/authorization/VideoAuthManager;

    move-result-object v4

    invoke-virtual {v4}, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->getDrmToken()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->setDrmKey(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 83
    :cond_3
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->setDrmKey(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 94
    .restart local v1    # "adsType":Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;
    :cond_4
    :try_start_1
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v3

    invoke-virtual {v3}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->configureAuditudeAds()V
    :try_end_1
    .catch Ljava/lang/ClassCastException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_1

    .line 96
    :catch_0
    move-exception v2

    .line 97
    .local v2, "e":Ljava/lang/ClassCastException;
    sget-object v3, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->LOG:Lorg/slf4j/Logger;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Everything we know is wrong. "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v2}, Ljava/lang/ClassCastException;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v3, v4}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    goto :goto_1

    .line 105
    .end local v1    # "adsType":Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;
    .end local v2    # "e":Ljava/lang/ClassCastException;
    :cond_5
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->isLiveStream()Z

    move-result v3

    if-eqz v3, :cond_7

    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getLiveStream()Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    move-result-object v3

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->isEspn()Z

    move-result v3

    if-nez v3, :cond_7

    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getLiveStream()Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    move-result-object v3

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->isDisney()Z

    move-result v3

    if-nez v3, :cond_7

    .line 106
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    iget-object v4, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v4}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getLiveStream()Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    move-result-object v4

    invoke-virtual {v4}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getPlaybackLink()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->setManifestUrl(Ljava/lang/String;)V

    .line 110
    :cond_6
    :goto_3
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    new-instance v4, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;

    iget-object v5, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-direct {v4, v5}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)V

    invoke-virtual {v3, v4}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    goto :goto_2

    .line 107
    :cond_7
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->isLiveStream()Z

    move-result v3

    if-nez v3, :cond_6

    .line 108
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    iget-object v4, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v4}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getVideoAuthManager()Lcom/xfinity/playerlib/authorization/VideoAuthManager;

    move-result-object v4

    invoke-virtual {v4}, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->getSmil()Lcom/xfinity/playerlib/authorization/SMILResource;

    move-result-object v4

    invoke-virtual {v4}, Lcom/xfinity/playerlib/authorization/SMILResource;->getSignedManifestUrl()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->setManifestUrl(Ljava/lang/String;)V

    goto :goto_3
.end method

.method public onAmsPinRequired()V
    .locals 3

    .prologue
    .line 57
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->validationCompletedListener:Lcom/comcast/cim/android/view/common/PinKeypadFragment$PinValidationCompletedListener;

    if-eqz v0, :cond_0

    .line 58
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->validationCompletedListener:Lcom/comcast/cim/android/view/common/PinKeypadFragment$PinValidationCompletedListener;

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->showErrorInPinPadFragment(Lcom/comcast/cim/android/view/common/PinKeypadFragment$PinValidationCompletedListener;)V

    .line 60
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    new-instance v1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/CheckPinState;

    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-direct {v1, v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/CheckPinState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)V

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    .line 61
    return-void
.end method

.method public onAuthorizationFailure(Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;Ljava/lang/String;)V
    .locals 4
    .param p1, "media"    # Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    .param p2, "failureMessage"    # Ljava/lang/String;

    .prologue
    .line 215
    new-instance v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;

    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Disney Media Authorization failed with message: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;Ljava/lang/String;)V

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    .line 216
    return-void
.end method

.method public onAuthorizationSuccess(Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;)V
    .locals 3
    .param p1, "media"    # Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    .prologue
    .line 208
    if-eqz p1, :cond_0

    .line 209
    sget-object v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->LOG:Lorg/slf4j/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Disney Media Authorization success. Token: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getCurrentToken()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 211
    :cond_0
    return-void
.end method

.method public onAuthorizationTokenRequest(Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;)V
    .locals 2
    .param p1, "media"    # Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    .prologue
    .line 190
    sget-object v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->LOG:Lorg/slf4j/Logger;

    const-string v1, "Disney Player Auth Token request received"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 192
    new-instance v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState$2;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState$2;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;)V

    invoke-virtual {p1, v0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->authorizeMediaWithAuthToken(Lcom/disney/datg/videoplatforms/sdk/common/VPAuthToken;)V

    .line 204
    return-void
.end method

.method public onPinCanceled()V
    .locals 0

    .prologue
    .line 175
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->checkHidePinPadFragment()V

    .line 176
    return-void
.end method

.method public run()V
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->pin:Ljava/lang/String;

    invoke-direct {p0, v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->performAMSAuthentication(Ljava/lang/String;)V

    .line 53
    return-void
.end method

.method public transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V
    .locals 1
    .param p1, "newState"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    .prologue
    .line 36
    instance-of v0, p1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/CheckPinState;

    if-nez v0, :cond_0

    instance-of v0, p1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InitializeLocalHostState;

    if-nez v0, :cond_0

    instance-of v0, p1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;

    if-eqz v0, :cond_1

    .line 39
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->setState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    .line 43
    :goto_0
    return-void

    .line 41
    :cond_1
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    goto :goto_0
.end method
