.class public Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;
.super Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;
.source "InfoDetailState.java"


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private bookmark:Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

.field private depthNumber:I

.field private favorite:Lcom/xfinity/playerlib/model/VideoFavorite;

.field private previousState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

.field private transactionTag:Ljava/lang/String;

.field private type:Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;

.field private watchable:Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 16
    const-class v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)V
    .locals 2
    .param p1, "stateController"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    .param p2, "previousState"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;
    .param p3, "type"    # Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;
    .param p4, "bookmark"    # Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    .prologue
    const/4 v1, 0x0

    .line 36
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)V

    .line 20
    const/4 v0, 0x1

    iput v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->depthNumber:I

    .line 22
    iput-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->watchable:Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;

    .line 23
    iput-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->bookmark:Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    .line 24
    iput-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->favorite:Lcom/xfinity/playerlib/model/VideoFavorite;

    .line 37
    iput-object p4, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->bookmark:Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    .line 38
    iput-object p2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->previousState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    .line 39
    iput-object p3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->type:Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;

    .line 40
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->setTransactionInfo()V

    .line 41
    return-void
.end method

.method public constructor <init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;Lcom/xfinity/playerlib/model/VideoFavorite;)V
    .locals 2
    .param p1, "stateController"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    .param p2, "previousState"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;
    .param p3, "type"    # Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;
    .param p4, "favorite"    # Lcom/xfinity/playerlib/model/VideoFavorite;

    .prologue
    const/4 v1, 0x0

    .line 44
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)V

    .line 20
    const/4 v0, 0x1

    iput v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->depthNumber:I

    .line 22
    iput-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->watchable:Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;

    .line 23
    iput-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->bookmark:Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    .line 24
    iput-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->favorite:Lcom/xfinity/playerlib/model/VideoFavorite;

    .line 45
    iput-object p4, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->favorite:Lcom/xfinity/playerlib/model/VideoFavorite;

    .line 46
    iput-object p2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->previousState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    .line 47
    iput-object p3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->type:Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;

    .line 48
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->setTransactionInfo()V

    .line 49
    return-void
.end method

.method public constructor <init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;)V
    .locals 2
    .param p1, "stateController"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    .param p2, "previousState"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;
    .param p3, "type"    # Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;
    .param p4, "watchable"    # Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;

    .prologue
    const/4 v1, 0x0

    .line 28
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)V

    .line 20
    const/4 v0, 0x1

    iput v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->depthNumber:I

    .line 22
    iput-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->watchable:Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;

    .line 23
    iput-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->bookmark:Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    .line 24
    iput-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->favorite:Lcom/xfinity/playerlib/model/VideoFavorite;

    .line 29
    iput-object p4, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->watchable:Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;

    .line 30
    iput-object p2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->previousState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    .line 31
    iput-object p3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->type:Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;

    .line 32
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->setTransactionInfo()V

    .line 33
    return-void
.end method

.method private backupOneLevel()V
    .locals 2

    .prologue
    .line 147
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->transactionTag:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->popFragmentFromBackStack(Ljava/lang/String;)V

    .line 148
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->previousState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    .line 149
    return-void
.end method

.method private exitInfoPanel()V
    .locals 3

    .prologue
    .line 152
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->clearBackStack()V

    .line 153
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->hideInfoPanel()V

    .line 155
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->isAdPlaying()Z

    move-result v0

    if-nez v0, :cond_0

    .line 156
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->getPlayerStatus()Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    move-result-object v0

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->PAUSED:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    if-ne v0, v1, :cond_1

    .line 157
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->showMainControlsWithPlayButton()V

    .line 164
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    new-instance v1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;

    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-direct {v1, v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)V

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    .line 165
    return-void

    .line 158
    :cond_1
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->getPlayerStatus()Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    move-result-object v0

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->PLAYING:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    if-ne v0, v1, :cond_0

    .line 159
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->showMainControlsWithPauseButton()V

    .line 160
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->startMainControlTimeout()V

    goto :goto_0
.end method

.method private setTransactionInfo()V
    .locals 2

    .prologue
    .line 52
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->previousState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    instance-of v0, v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;

    if-eqz v0, :cond_0

    .line 53
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->previousState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    check-cast v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->getDepthNumber()I

    move-result v0

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->depthNumber:I

    .line 55
    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "InfoDetail"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->depthNumber:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->transactionTag:Ljava/lang/String;

    .line 56
    return-void
.end method

.method private showInfoPanel()V
    .locals 3

    .prologue
    .line 88
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->watchable:Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;

    if-eqz v0, :cond_1

    .line 89
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->watchable:Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;

    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->transactionTag:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->showSeriesWatchableDetail(Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;Ljava/lang/String;)V

    .line 95
    :cond_0
    :goto_0
    return-void

    .line 90
    :cond_1
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->bookmark:Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    if-eqz v0, :cond_2

    .line 91
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->bookmark:Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->transactionTag:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->showHistoryItemDetail(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;Ljava/lang/String;)V

    goto :goto_0

    .line 92
    :cond_2
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->favorite:Lcom/xfinity/playerlib/model/VideoFavorite;

    if-eqz v0, :cond_0

    .line 93
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->favorite:Lcom/xfinity/playerlib/model/VideoFavorite;

    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->transactionTag:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->showFavoriteDetail(Lcom/xfinity/playerlib/model/VideoFavorite;Ljava/lang/String;)V

    goto :goto_0
.end method


# virtual methods
.method public adBreakStart(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;)V
    .locals 0
    .param p1, "adBreak"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
    .param p2, "ad"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    .prologue
    .line 83
    invoke-super {p0, p1, p2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->adBreakStart(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;)V

    .line 84
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->exitInfoPanel()V

    .line 85
    return-void
.end method

.method public getDepthNumber()I
    .locals 1

    .prologue
    .line 143
    iget v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->depthNumber:I

    return v0
.end method

.method public getStateName()Ljava/lang/String;
    .locals 2

    .prologue
    .line 72
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "InfoDetailState"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->depthNumber:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public onBabyGuideButton()V
    .locals 4

    .prologue
    .line 99
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->type:Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;

    sget-object v1, Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;->BABY_GUIDE:Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;

    if-eq v0, v1, :cond_0

    .line 100
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    new-instance v1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;

    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    sget-object v3, Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;->BABY_GUIDE:Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;

    invoke-direct {v1, v2, v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;)V

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    .line 102
    :cond_0
    return-void
.end method

.method public onBackButton()V
    .locals 0

    .prologue
    .line 139
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->backupOneLevel()V

    .line 140
    return-void
.end method

.method public onFavoritesButton()V
    .locals 4

    .prologue
    .line 113
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->type:Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;

    sget-object v1, Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;->FAVORITE:Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;

    if-eq v0, v1, :cond_0

    .line 114
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    new-instance v1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;

    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    sget-object v3, Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;->FAVORITE:Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;

    invoke-direct {v1, v2, v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;)V

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    .line 116
    :cond_0
    return-void
.end method

.method public onHistoryButton()V
    .locals 4

    .prologue
    .line 106
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->type:Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;

    sget-object v1, Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;->HISTORY:Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;

    if-eq v0, v1, :cond_0

    .line 107
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    new-instance v1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;

    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    sget-object v3, Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;->HISTORY:Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;

    invoke-direct {v1, v2, v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;)V

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    .line 109
    :cond_0
    return-void
.end method

.method public onNewVideoPlayOrResumeSelected(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)V
    .locals 1
    .param p1, "video"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .param p2, "watchable"    # Lcom/xfinity/playerlib/model/consumable/Watchable;

    .prologue
    .line 123
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0, p1, p2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->setVideoAndWatchable(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)V

    .line 124
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->reset()V

    .line 125
    return-void
.end method

.method public onScreenTouch()V
    .locals 0

    .prologue
    .line 134
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->exitInfoPanel()V

    .line 135
    return-void
.end method

.method public onSeriesWatchableDetailSelected(Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;)V
    .locals 4
    .param p1, "seriesWatchable"    # Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;

    .prologue
    .line 129
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    new-instance v1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;

    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->type:Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;

    invoke-direct {v1, v2, p0, v3, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;)V

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    .line 130
    return-void
.end method

.method public onVolumeChanged()V
    .locals 1

    .prologue
    .line 169
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->startVolumeControlTimeout()V

    .line 170
    return-void
.end method

.method public run()V
    .locals 0

    .prologue
    .line 77
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->showInfoPanel()V

    .line 78
    invoke-super {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->run()V

    .line 79
    return-void
.end method

.method public transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V
    .locals 1
    .param p1, "videoState"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    .prologue
    .line 60
    instance-of v0, p1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;

    if-nez v0, :cond_0

    instance-of v0, p1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState;

    if-nez v0, :cond_0

    instance-of v0, p1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState;

    if-nez v0, :cond_0

    instance-of v0, p1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;

    if-eqz v0, :cond_1

    .line 64
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->setState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    .line 68
    :goto_0
    return-void

    .line 66
    :cond_1
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    goto :goto_0
.end method
