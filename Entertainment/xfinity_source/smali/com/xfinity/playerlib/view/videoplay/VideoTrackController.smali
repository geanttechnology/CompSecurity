.class public Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;
.super Ljava/lang/Object;
.source "VideoTrackController.java"


# static fields
.field private static final foxNetworks:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private final LOG:Lorg/slf4j/Logger;

.field private MIN_RESUMABLE_PROGRESS:I

.field private foxLogger:Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;

.field private hasSavedResumePoint:Z

.field private lastTrackedPosition:I

.field private liveStream:Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

.field private liveStreamBookmarkDAO:Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;

.field private resumePoint:J

.field private trackingPosition:J

.field private trackingService:Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

.field private userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

.field private videoBookmarkDAO:Lcom/xfinity/playerlib/model/database/VideoBookmarkDAO;

.field private videoFacade:Lcom/xfinity/playerlib/model/consumable/VideoFacade;

.field private watchable:Lcom/xfinity/playerlib/model/consumable/Watchable;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    .line 50
    new-instance v0, Ljava/util/ArrayList;

    const/16 v1, 0x11

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    const-string v3, "utilisma"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string v3, "20th century fox"

    aput-object v3, v1, v2

    const/4 v2, 0x2

    const-string v3, "fox"

    aput-object v3, v1, v2

    const/4 v2, 0x3

    const-string v3, "bigtennetwork"

    aput-object v3, v1, v2

    const/4 v2, 0x4

    const-string v3, "foxbusiness"

    aput-object v3, v1, v2

    const/4 v2, 0x5

    const-string v3, "foxnews"

    aput-object v3, v1, v2

    const/4 v2, 0x6

    const-string v3, "foxsports"

    aput-object v3, v1, v2

    const/4 v2, 0x7

    const-string v3, "fx"

    aput-object v3, v1, v2

    const/16 v2, 0x8

    const-string v3, "fox"

    aput-object v3, v1, v2

    const/16 v2, 0x9

    const-string v3, "fx"

    aput-object v3, v1, v2

    const/16 v2, 0xa

    const-string v3, "fxm"

    aput-object v3, v1, v2

    const/16 v2, 0xb

    const-string v3, "fxx"

    aput-object v3, v1, v2

    const/16 v2, 0xc

    const-string v3, "mundofox"

    aput-object v3, v1, v2

    const/16 v2, 0xd

    const-string v3, "nat geo wild"

    aput-object v3, v1, v2

    const/16 v2, 0xe

    const-string v3, "national geographic"

    aput-object v3, v1, v2

    const/16 v2, 0xf

    const-string v3, "fox sports 1"

    aput-object v3, v1, v2

    const/16 v2, 0x10

    const-string v3, "foxdeportes"

    aput-object v3, v1, v2

    invoke-static {v1}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    sput-object v0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->foxNetworks:Ljava/util/List;

    return-void
.end method

.method public constructor <init>(Lcom/xfinity/playerlib/model/database/VideoBookmarkDAO;Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;Lcom/xfinity/playerlib/model/user/PlayNowUserManager;Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;)V
    .locals 3
    .param p1, "videoBookmarkDAO"    # Lcom/xfinity/playerlib/model/database/VideoBookmarkDAO;
    .param p2, "liveStreamBookmarkDAO"    # Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;
    .param p3, "userManager"    # Lcom/xfinity/playerlib/model/user/PlayNowUserManager;
    .param p4, "trackingService"    # Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;
    .param p5, "foxLogger"    # Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;

    .prologue
    const/4 v2, 0x0

    .line 52
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 24
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->LOG:Lorg/slf4j/Logger;

    .line 27
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->trackingPosition:J

    .line 41
    iput-boolean v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->hasSavedResumePoint:Z

    .line 44
    const/16 v0, 0x2710

    iput v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->MIN_RESUMABLE_PROGRESS:I

    .line 47
    iput v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->lastTrackedPosition:I

    .line 53
    iput-object p1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->videoBookmarkDAO:Lcom/xfinity/playerlib/model/database/VideoBookmarkDAO;

    .line 54
    iput-object p2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->liveStreamBookmarkDAO:Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;

    .line 55
    iput-object p3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    .line 56
    iput-object p4, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->trackingService:Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

    .line 57
    iput-object p5, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->foxLogger:Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;

    .line 58
    return-void
.end method

.method private isFox()Z
    .locals 5

    .prologue
    .line 227
    iget-object v3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->videoFacade:Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getNetworkInfo()Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    move-result-object v3

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->getParentCompany()Ljava/lang/String;

    move-result-object v2

    .line 228
    .local v2, "parentCompany":Ljava/lang/String;
    iget-object v3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->videoFacade:Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getNetworkInfo()Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    move-result-object v3

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->getName()Ljava/lang/String;

    move-result-object v1

    .line 229
    .local v1, "name":Ljava/lang/String;
    iget-object v3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->videoFacade:Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getNetworkInfo()Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    move-result-object v3

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->getBrand()Ljava/lang/String;

    move-result-object v0

    .line 231
    .local v0, "brand":Ljava/lang/String;
    if-eqz v2, :cond_0

    .line 232
    const-string v3, "FOX"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    .line 236
    :goto_0
    return v3

    .line 235
    :cond_0
    if-eqz v1, :cond_1

    sget-object v3, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->foxNetworks:Ljava/util/List;

    invoke-virtual {v1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v3, v4}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_2

    :cond_1
    if-eqz v0, :cond_3

    sget-object v3, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->foxNetworks:Ljava/util/List;

    .line 236
    invoke-virtual {v0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v3, v4}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3

    :cond_2
    const/4 v3, 0x1

    goto :goto_0

    :cond_3
    const/4 v3, 0x0

    goto :goto_0
.end method

.method private resetTrackingItems()V
    .locals 4

    .prologue
    const-wide/16 v2, 0x0

    const/4 v0, 0x0

    .line 204
    iput-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->videoFacade:Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    .line 205
    iput-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->watchable:Lcom/xfinity/playerlib/model/consumable/Watchable;

    .line 206
    iput-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->liveStream:Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    .line 207
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->hasSavedResumePoint:Z

    .line 208
    iput-wide v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->trackingPosition:J

    .line 209
    iput-wide v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->resumePoint:J

    .line 210
    return-void
.end method

.method private saveLiveStreamTrackingPositionAndLastWatched(J)V
    .locals 5
    .param p1, "duration"    # J

    .prologue
    const/4 v4, 0x1

    .line 105
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->liveStreamBookmarkDAO:Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->liveStream:Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    invoke-interface {v1, v2, v4}, Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;->getOrCreateBookmarkWithLiveStream(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;Z)Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;

    move-result-object v0

    .line 106
    .local v0, "bookmark":Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;
    if-nez v0, :cond_1

    .line 121
    :cond_0
    :goto_0
    return-void

    .line 110
    :cond_1
    invoke-virtual {v0}, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;->getDuration()I

    move-result v1

    int-to-long v2, v1

    cmp-long v1, v2, p1

    if-eqz v1, :cond_2

    .line 111
    long-to-int v1, p1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;->setDuration(I)V

    .line 114
    :cond_2
    iget-wide v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->trackingPosition:J

    long-to-int v1, v2

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;->setPosition(I)V

    .line 115
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->liveStreamBookmarkDAO:Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;

    invoke-interface {v1, v0, v4}, Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;->saveBookmark(Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;Z)Z

    .line 117
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getShowLastWatched()Z

    move-result v1

    if-nez v1, :cond_0

    .line 118
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    invoke-virtual {v1, v4}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->setShowLastWatched(Z)V

    .line 119
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->saveUserAsync()V

    goto :goto_0
.end method

.method private saveResumePoint(JJ)V
    .locals 3
    .param p1, "position"    # J
    .param p3, "duration"    # J

    .prologue
    .line 87
    iget v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->MIN_RESUMABLE_PROGRESS:I

    int-to-long v0, v0

    cmp-long v0, p1, v0

    if-gez v0, :cond_0

    .line 88
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->trackingPosition:J

    .line 92
    :goto_0
    invoke-direct {p0, p3, p4}, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->saveTrackingPositionAndLastWatched(J)V

    .line 93
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->hasSavedResumePoint:Z

    .line 94
    return-void

    .line 90
    :cond_0
    iput-wide p1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->trackingPosition:J

    goto :goto_0
.end method

.method private saveTrackingPositionAndLastWatched(J)V
    .locals 1
    .param p1, "duration"    # J

    .prologue
    .line 97
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->liveStream:Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    if-eqz v0, :cond_0

    .line 98
    invoke-direct {p0, p1, p2}, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->saveLiveStreamTrackingPositionAndLastWatched(J)V

    .line 102
    :goto_0
    return-void

    .line 100
    :cond_0
    invoke-direct {p0, p1, p2}, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->saveVideoTrackingPositionAndLastWatched(J)V

    goto :goto_0
.end method

.method private saveVideoTrackingPositionAndLastWatched(J)V
    .locals 7
    .param p1, "duration"    # J

    .prologue
    .line 124
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->videoBookmarkDAO:Lcom/xfinity/playerlib/model/database/VideoBookmarkDAO;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->videoFacade:Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    iget-object v3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->watchable:Lcom/xfinity/playerlib/model/consumable/Watchable;

    invoke-interface {v1, v2, v3}, Lcom/xfinity/playerlib/model/database/VideoBookmarkDAO;->getOrCreateBookmarkWithVideo(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    move-result-object v0

    .line 126
    .local v0, "bookmark":Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    iget-wide v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->trackingPosition:J

    const-wide/16 v4, 0x0

    cmp-long v1, v2, v4

    if-nez v1, :cond_0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getLastTrackedMilestone()Lcom/xfinity/playerlib/tracking/VideoMilestone;

    move-result-object v1

    sget-object v2, Lcom/xfinity/playerlib/tracking/VideoMilestone;->NOT_STARTED:Lcom/xfinity/playerlib/tracking/VideoMilestone;

    if-eq v1, v2, :cond_0

    .line 128
    sget-object v1, Lcom/xfinity/playerlib/tracking/VideoMilestone;->NOT_STARTED:Lcom/xfinity/playerlib/tracking/VideoMilestone;

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->setLastTrackedMilestone(Lcom/xfinity/playerlib/tracking/VideoMilestone;)V

    .line 129
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->videoBookmarkDAO:Lcom/xfinity/playerlib/model/database/VideoBookmarkDAO;

    invoke-interface {v1, v0}, Lcom/xfinity/playerlib/model/database/VideoBookmarkDAO;->saveBookmark(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)V

    .line 132
    :cond_0
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->videoFacade:Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    invoke-direct {p0, v1, v0}, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->trackOmnitureVideoMilestone(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)V

    .line 134
    invoke-virtual {v0}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getDuration()I

    move-result v1

    int-to-long v2, v1

    cmp-long v1, v2, p1

    if-eqz v1, :cond_1

    .line 135
    long-to-int v1, p1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->setDuration(I)V

    .line 138
    :cond_1
    iget-wide v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->trackingPosition:J

    long-to-int v1, v2

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->setPosition(I)V

    .line 140
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->videoFacade:Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->isAdult()Z

    move-result v1

    if-nez v1, :cond_2

    .line 141
    sget-object v1, Lcom/xfinity/playerlib/bookmarks/VideoBookmark$BookmarkCategory;->CATEGORY_RECENT:Lcom/xfinity/playerlib/bookmarks/VideoBookmark$BookmarkCategory;

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->addCategory(Lcom/xfinity/playerlib/bookmarks/VideoBookmark$BookmarkCategory;)V

    .line 143
    :cond_2
    sget-object v1, Lcom/xfinity/playerlib/bookmarks/VideoBookmark$BookmarkCategory;->CATEGORY_RESUMEPOINT:Lcom/xfinity/playerlib/bookmarks/VideoBookmark$BookmarkCategory;

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->addCategory(Lcom/xfinity/playerlib/bookmarks/VideoBookmark$BookmarkCategory;)V

    .line 145
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->videoBookmarkDAO:Lcom/xfinity/playerlib/model/database/VideoBookmarkDAO;

    invoke-interface {v1, v0}, Lcom/xfinity/playerlib/model/database/VideoBookmarkDAO;->saveBookmark(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)V

    .line 147
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getShowLastWatched()Z

    move-result v1

    if-nez v1, :cond_3

    .line 148
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->setShowLastWatched(Z)V

    .line 149
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->saveUserAsync()V

    .line 151
    :cond_3
    return-void
.end method

.method private setResumePoint()V
    .locals 8

    .prologue
    .line 217
    iget-object v4, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->videoBookmarkDAO:Lcom/xfinity/playerlib/model/database/VideoBookmarkDAO;

    iget-object v5, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->videoFacade:Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    iget-object v6, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->watchable:Lcom/xfinity/playerlib/model/consumable/Watchable;

    invoke-interface {v4, v5, v6}, Lcom/xfinity/playerlib/model/database/VideoBookmarkDAO;->getOrCreateBookmarkWithVideo(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    move-result-object v0

    .line 218
    .local v0, "bookmark":Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    invoke-virtual {v0}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getPosition()I

    move-result v4

    int-to-long v4, v4

    iput-wide v4, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->resumePoint:J

    .line 219
    invoke-virtual {v0}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getDuration()I

    move-result v1

    .line 220
    .local v1, "duration":I
    iget-wide v4, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->resumePoint:J

    long-to-double v4, v4

    int-to-double v6, v1

    div-double v2, v4, v6

    .line 221
    .local v2, "progressPercent":D
    const-wide v4, 0x3fef5c28f5c28f5cL    # 0.98

    cmpl-double v4, v2, v4

    if-lez v4, :cond_0

    .line 222
    const-wide/16 v4, 0x0

    iput-wide v4, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->resumePoint:J

    .line 224
    :cond_0
    return-void
.end method

.method private trackFox(Ljava/lang/String;Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)V
    .locals 2
    .param p1, "event"    # Ljava/lang/String;
    .param p2, "videoFacade"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .param p3, "bookmark"    # Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    .prologue
    .line 252
    new-instance v0, Lcom/xfinity/playerlib/tracking/FoxAnalyticsEventData;

    invoke-direct {v0, p1, p2, p3}, Lcom/xfinity/playerlib/tracking/FoxAnalyticsEventData;-><init>(Ljava/lang/String;Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)V

    .line 253
    .local v0, "eventData":Lcom/xfinity/playerlib/tracking/FoxAnalyticsEventData;
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->foxLogger:Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;

    invoke-interface {v1, v0}, Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;->logData(Lcom/comcast/cim/cmasl/analytics/EventData;)V

    .line 254
    return-void
.end method

.method private trackFoxProgress(JLcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)V
    .locals 7
    .param p1, "trackingPosition"    # J
    .param p3, "videoFacade"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .param p4, "bookmark"    # Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x5

    .line 241
    const-wide/32 v2, 0xea60

    div-long v2, p1, v2

    long-to-int v0, v2

    .line 243
    .local v0, "positionInMinutes":I
    if-ge v0, v4, :cond_0

    if-lt v0, v5, :cond_0

    iget v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->lastTrackedPosition:I

    sub-int v1, v0, v1

    if-ge v1, v5, :cond_1

    :cond_0
    if-lt v0, v4, :cond_2

    iget v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->lastTrackedPosition:I

    sub-int v1, v0, v1

    if-lt v1, v4, :cond_2

    .line 245
    :cond_1
    const-string v1, "event39"

    invoke-direct {p0, v1, p3, p4}, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->trackFox(Ljava/lang/String;Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)V

    .line 246
    iput v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->lastTrackedPosition:I

    .line 248
    :cond_2
    return-void
.end method

.method private trackOmnitureVideoMilestone(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)V
    .locals 8
    .param p1, "videoFacade"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .param p2, "bookmark"    # Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    .prologue
    .line 155
    invoke-virtual {p2}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getLastTrackedMilestone()Lcom/xfinity/playerlib/tracking/VideoMilestone;

    move-result-object v1

    .line 156
    .local v1, "lastTrackedMilestone":Lcom/xfinity/playerlib/tracking/VideoMilestone;
    iget-wide v4, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->trackingPosition:J

    long-to-int v4, v4

    invoke-static {v4, p1}, Lcom/xfinity/playerlib/tracking/VideoMilestone;->decodePosition(ILcom/xfinity/playerlib/model/consumable/VideoFacade;)Lcom/xfinity/playerlib/tracking/VideoMilestone;

    move-result-object v0

    .line 158
    .local v0, "currentMilestone":Lcom/xfinity/playerlib/tracking/VideoMilestone;
    iget-object v4, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->LOG:Lorg/slf4j/Logger;

    const-string v5, "trackVideoMilestone() lastTrackedMilestone={} currentMilestone={}"

    invoke-interface {v4, v5, v1, v0}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 160
    invoke-virtual {v1, v0}, Lcom/xfinity/playerlib/tracking/VideoMilestone;->valuesBetween(Lcom/xfinity/playerlib/tracking/VideoMilestone;)Ljava/util/List;

    move-result-object v3

    .line 162
    .local v3, "milestones":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/tracking/VideoMilestone;>;"
    iget-object v4, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->LOG:Lorg/slf4j/Logger;

    const-string v5, "trackVideoMilestone() milestones={}"

    invoke-interface {v4, v5, v3}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;Ljava/lang/Object;)V

    .line 164
    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_0
    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_1

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/tracking/VideoMilestone;

    .line 166
    .local v2, "milestone":Lcom/xfinity/playerlib/tracking/VideoMilestone;
    sget-object v5, Lcom/xfinity/playerlib/tracking/VideoMilestone;->NOT_STARTED:Lcom/xfinity/playerlib/tracking/VideoMilestone;

    if-eq v2, v5, :cond_0

    .line 167
    iget-object v5, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->trackingService:Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

    iget-object v6, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->watchable:Lcom/xfinity/playerlib/model/consumable/Watchable;

    const/4 v7, 0x0

    invoke-virtual {v5, v2, p1, v6, v7}, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->trackVideoPlaybackMilestone(Lcom/xfinity/playerlib/tracking/VideoMilestone;Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;I)V

    .line 168
    invoke-virtual {p2, v2}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->setLastTrackedMilestone(Lcom/xfinity/playerlib/tracking/VideoMilestone;)V

    .line 170
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->isFox()Z

    move-result v5

    if-eqz v5, :cond_0

    .line 171
    invoke-virtual {v2}, Lcom/xfinity/playerlib/tracking/VideoMilestone;->getEvent()Ljava/lang/String;

    move-result-object v5

    invoke-direct {p0, v5, p1, p2}, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->trackFox(Ljava/lang/String;Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)V

    goto :goto_0

    .line 176
    .end local v2    # "milestone":Lcom/xfinity/playerlib/tracking/VideoMilestone;
    :cond_1
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->isFox()Z

    move-result v4

    if-eqz v4, :cond_2

    .line 177
    iget-wide v4, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->trackingPosition:J

    invoke-direct {p0, v4, v5, p1, p2}, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->trackFoxProgress(JLcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)V

    .line 179
    :cond_2
    return-void
.end method


# virtual methods
.method public getResumePoint()J
    .locals 2

    .prologue
    .line 213
    iget-wide v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->resumePoint:J

    return-wide v0
.end method

.method public onCustomUpdateEvent(JJ)V
    .locals 5
    .param p1, "newPosition"    # J
    .param p3, "duration"    # J

    .prologue
    .line 72
    iget v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->MIN_RESUMABLE_PROGRESS:I

    int-to-long v0, v0

    cmp-long v0, p1, v0

    if-gtz v0, :cond_0

    iget-wide v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->trackingPosition:J

    iget v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->MIN_RESUMABLE_PROGRESS:I

    int-to-long v2, v2

    cmp-long v0, v0, v2

    if-lez v0, :cond_1

    .line 73
    :cond_0
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->saveResumePoint(JJ)V

    .line 75
    :cond_1
    return-void
.end method

.method public onEndPlayback(JJ)V
    .locals 1
    .param p1, "endPosition"    # J
    .param p3, "duration"    # J

    .prologue
    .line 81
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->hasSavedResumePoint:Z

    if-eqz v0, :cond_0

    .line 82
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->saveResumePoint(JJ)V

    .line 84
    :cond_0
    return-void
.end method

.method public onPlayerProgress(JJ)V
    .locals 5
    .param p1, "currentPosition"    # J
    .param p3, "duration"    # J

    .prologue
    .line 63
    iget v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->MIN_RESUMABLE_PROGRESS:I

    int-to-long v0, v0

    cmp-long v0, p1, v0

    if-gez v0, :cond_0

    iget-wide v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->trackingPosition:J

    iget v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->MIN_RESUMABLE_PROGRESS:I

    int-to-long v2, v2

    cmp-long v0, v0, v2

    if-gtz v0, :cond_1

    :cond_0
    iget-wide v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->trackingPosition:J

    sub-long v0, p1, v0

    .line 64
    invoke-static {v0, v1}, Ljava/lang/Math;->abs(J)J

    move-result-wide v0

    iget v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->MIN_RESUMABLE_PROGRESS:I

    int-to-long v2, v2

    cmp-long v0, v0, v2

    if-lez v0, :cond_2

    .line 65
    :cond_1
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->saveResumePoint(JJ)V

    .line 67
    :cond_2
    return-void
.end method

.method public setTrackingItems(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)V
    .locals 2
    .param p1, "videoFacade"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .param p2, "watchable"    # Lcom/xfinity/playerlib/model/consumable/Watchable;

    .prologue
    .line 188
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->resetTrackingItems()V

    .line 190
    iput-object p1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->videoFacade:Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    .line 191
    iput-object p2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->watchable:Lcom/xfinity/playerlib/model/consumable/Watchable;

    .line 192
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->setResumePoint()V

    .line 193
    iget-wide v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->resumePoint:J

    iput-wide v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->trackingPosition:J

    .line 194
    return-void
.end method

.method public setTrackingItems(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;)V
    .locals 2
    .param p1, "liveStream"    # Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    .prologue
    .line 197
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->resetTrackingItems()V

    .line 198
    iput-object p1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->liveStream:Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    .line 200
    iget-wide v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->resumePoint:J

    iput-wide v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->trackingPosition:J

    .line 201
    return-void
.end method

.method public trackOmnitureLiveStreamStartedMilestone()V
    .locals 5

    .prologue
    .line 184
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->trackingService:Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

    sget-object v1, Lcom/xfinity/playerlib/tracking/VideoMilestone;->LIVE_STREAM_STARTED:Lcom/xfinity/playerlib/tracking/VideoMilestone;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->liveStream:Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getTitle()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->liveStream:Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getStreamId()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->trackLiveStreamPlaybackMilestone(Lcom/xfinity/playerlib/tracking/VideoMilestone;Ljava/lang/String;Ljava/lang/String;I)V

    .line 185
    return-void
.end method
