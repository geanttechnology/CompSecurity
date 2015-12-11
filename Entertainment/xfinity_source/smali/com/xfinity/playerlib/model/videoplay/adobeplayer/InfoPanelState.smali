.class public Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;
.super Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;
.source "InfoPanelState.java"


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field showHasForcedBackground:Z

.field private transactionTag:Ljava/lang/String;

.field private type:Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 20
    const-class v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;)V
    .locals 1
    .param p1, "stateController"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    .param p2, "type"    # Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;

    .prologue
    .line 28
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)V

    .line 23
    const-string v0, "InfoPanel"

    iput-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->transactionTag:Ljava/lang/String;

    .line 25
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->showHasForcedBackground:Z

    .line 29
    iput-object p2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->type:Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;

    .line 30
    return-void
.end method

.method private exitInfoPanel()V
    .locals 3

    .prologue
    .line 125
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->clearBackStack()V

    .line 126
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->hideInfoPanel()V

    .line 128
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->isAdPlaying()Z

    move-result v0

    if-nez v0, :cond_0

    .line 129
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->getPlayerStatus()Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    move-result-object v0

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->PAUSED:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    if-ne v0, v1, :cond_1

    .line 130
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->showMainControlsWithPlayButton()V

    .line 137
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    new-instance v1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;

    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-direct {v1, v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)V

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    .line 138
    return-void

    .line 131
    :cond_1
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->getPlayerStatus()Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    move-result-object v0

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->PLAYING:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    if-ne v0, v1, :cond_0

    .line 132
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->showMainControlsWithPauseButton()V

    .line 133
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->startMainControlTimeout()V

    goto :goto_0
.end method

.method private showInfoPanel()V
    .locals 2

    .prologue
    .line 67
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->type:Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;

    sget-object v1, Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;->BABY_GUIDE:Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;

    if-ne v0, v1, :cond_1

    .line 68
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->transactionTag:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->showCurrentVideoInfo(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->showHasForcedBackground:Z

    .line 74
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->removeMainControlTimeout()V

    .line 75
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->hideMainControls()V

    .line 76
    return-void

    .line 69
    :cond_1
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->type:Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;

    sget-object v1, Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;->HISTORY:Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;

    if-ne v0, v1, :cond_2

    .line 70
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->transactionTag:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->showHistory(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->showHasForcedBackground:Z

    goto :goto_0

    .line 71
    :cond_2
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->type:Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;

    sget-object v1, Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;->FAVORITE:Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;

    if-ne v0, v1, :cond_0

    .line 72
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->transactionTag:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->showFavorite(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->showHasForcedBackground:Z

    goto :goto_0
.end method


# virtual methods
.method public adBreakStart(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;)V
    .locals 0
    .param p1, "adBreak"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
    .param p2, "ad"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    .prologue
    .line 62
    invoke-super {p0, p1, p2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->adBreakStart(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;)V

    .line 63
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->exitInfoPanel()V

    .line 64
    return-void
.end method

.method public getStateName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 45
    const-string v0, "InfoPanelState"

    return-object v0
.end method

.method public onBabyGuideButton()V
    .locals 2

    .prologue
    .line 80
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->type:Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;

    sget-object v1, Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;->BABY_GUIDE:Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;

    if-eq v0, v1, :cond_0

    .line 81
    sget-object v0, Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;->BABY_GUIDE:Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;

    iput-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->type:Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;

    .line 82
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->showInfoPanel()V

    .line 84
    :cond_0
    return-void
.end method

.method public onBackButton()V
    .locals 0

    .prologue
    .line 121
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->exitInfoPanel()V

    .line 122
    return-void
.end method

.method public onFavoriteItemDetailSelected(Lcom/xfinity/playerlib/model/VideoFavorite;)V
    .locals 4
    .param p1, "favorite"    # Lcom/xfinity/playerlib/model/VideoFavorite;

    .prologue
    .line 111
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    new-instance v1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;

    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->type:Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;

    invoke-direct {v1, v2, p0, v3, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;Lcom/xfinity/playerlib/model/VideoFavorite;)V

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    .line 112
    return-void
.end method

.method public onFavoritesButton()V
    .locals 2

    .prologue
    .line 96
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->type:Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;

    sget-object v1, Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;->FAVORITE:Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;

    if-eq v0, v1, :cond_0

    .line 97
    sget-object v0, Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;->FAVORITE:Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;

    iput-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->type:Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;

    .line 98
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->showInfoPanel()V

    .line 100
    :cond_0
    return-void
.end method

.method public onHistoryButton()V
    .locals 2

    .prologue
    .line 88
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->type:Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;

    sget-object v1, Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;->HISTORY:Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;

    if-eq v0, v1, :cond_0

    .line 89
    sget-object v0, Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;->HISTORY:Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;

    iput-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->type:Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;

    .line 90
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->showInfoPanel()V

    .line 92
    :cond_0
    return-void
.end method

.method public onHistoryItemDetailSelected(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)V
    .locals 4
    .param p1, "bookmark"    # Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    .prologue
    .line 107
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    new-instance v1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;

    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->type:Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;

    invoke-direct {v1, v2, p0, v3, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)V

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    .line 108
    return-void
.end method

.method public onLiveStreamPlaySelected(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;)V
    .locals 1
    .param p1, "liveStream"    # Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    .prologue
    .line 175
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->setLiveStream(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;)V

    .line 176
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->reset()V

    .line 177
    return-void
.end method

.method public onLiveStreamPlaySelected(Ljava/lang/String;)V
    .locals 3
    .param p1, "streamId"    # Ljava/lang/String;

    .prologue
    .line 182
    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getActivityContext()Landroid/app/Activity;

    move-result-object v2

    invoke-virtual {v2}, Landroid/app/Activity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    .line 183
    .local v1, "intent":Landroid/content/Intent;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 184
    .local v0, "arguments":Landroid/os/Bundle;
    const-string v2, "liveStreamID"

    invoke-virtual {v0, v2, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 185
    invoke-virtual {v1, v0}, Landroid/content/Intent;->replaceExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 187
    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getActivityContext()Landroid/app/Activity;

    move-result-object v2

    invoke-virtual {v2, v1}, Landroid/app/Activity;->setIntent(Landroid/content/Intent;)V

    .line 188
    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->resetVideoAndWatchable()V

    .line 189
    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->resetLiveStream()V

    .line 190
    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->reset()V

    .line 191
    return-void
.end method

.method public onNewVideoPlayOrResumeSelected(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)V
    .locals 6
    .param p1, "bookmark"    # Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    .prologue
    .line 153
    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getActivityContext()Landroid/app/Activity;

    move-result-object v2

    invoke-virtual {v2}, Landroid/app/Activity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    .line 154
    .local v1, "intent":Landroid/content/Intent;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 156
    .local v0, "arguments":Landroid/os/Bundle;
    invoke-virtual {p1}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->isMovie()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 157
    const-string v2, "merlinId"

    invoke-virtual {p1}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 163
    :goto_0
    const-string v2, "companyId"

    invoke-virtual {p1}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getCompanyId()J

    move-result-wide v4

    invoke-virtual {v0, v2, v4, v5}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 164
    invoke-virtual {v1, v0}, Landroid/content/Intent;->replaceExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 166
    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getActivityContext()Landroid/app/Activity;

    move-result-object v2

    invoke-virtual {v2, v1}, Landroid/app/Activity;->setIntent(Landroid/content/Intent;)V

    .line 167
    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->resetVideoAndWatchable()V

    .line 168
    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->resetLiveStream()V

    .line 169
    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->reset()V

    .line 170
    return-void

    .line 159
    :cond_0
    const-string v2, "videoId"

    invoke-virtual {p1}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getVideoId()J

    move-result-wide v4

    invoke-virtual {v0, v2, v4, v5}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 160
    const-string v2, "parentMerlinId"

    invoke-virtual {p1}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getParentMerlinIdIfApplicable()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    goto :goto_0
.end method

.method public onNewVideoPlayOrResumeSelected(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)V
    .locals 1
    .param p1, "video"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .param p2, "watchable"    # Lcom/xfinity/playerlib/model/consumable/Watchable;

    .prologue
    .line 142
    invoke-super {p0, p1, p2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->onNewVideoPlayOrResumeSelected(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)V

    .line 144
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0, p1, p2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->setVideoAndWatchable(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)V

    .line 145
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->resetLiveStream()V

    .line 146
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->reset()V

    .line 147
    return-void
.end method

.method public onScreenTouch()V
    .locals 0

    .prologue
    .line 116
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->exitInfoPanel()V

    .line 117
    return-void
.end method

.method public onSeriesWatchableDetailSelected(Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;)V
    .locals 4
    .param p1, "seriesWatchable"    # Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;

    .prologue
    .line 103
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    new-instance v1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;

    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->type:Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;

    invoke-direct {v1, v2, p0, v3, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;)V

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    .line 104
    return-void
.end method

.method public onVolumeChanged()V
    .locals 1

    .prologue
    .line 195
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->startVolumeControlTimeout()V

    .line 196
    return-void
.end method

.method public run()V
    .locals 3

    .prologue
    .line 50
    iget-boolean v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->showHasForcedBackground:Z

    if-eqz v0, :cond_0

    .line 53
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    new-instance v1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;

    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-direct {v1, v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)V

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    .line 57
    :goto_0
    invoke-super {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->run()V

    .line 58
    return-void

    .line 55
    :cond_0
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->showInfoPanel()V

    goto :goto_0
.end method

.method public transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V
    .locals 1
    .param p1, "videoState"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    .prologue
    .line 34
    instance-of v0, p1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;

    if-nez v0, :cond_0

    instance-of v0, p1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;

    if-nez v0, :cond_0

    instance-of v0, p1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;

    if-eqz v0, :cond_1

    .line 37
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->setState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    .line 41
    :goto_0
    return-void

    .line 39
    :cond_1
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    goto :goto_0
.end method
