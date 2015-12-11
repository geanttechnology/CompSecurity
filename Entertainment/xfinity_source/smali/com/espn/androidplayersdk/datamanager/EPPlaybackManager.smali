.class public Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;
.super Ljava/lang/Object;
.source "EPPlaybackManager.java"


# static fields
.field static final platform:Ljava/lang/String; = "&platform=android"

.field static final sdkVersion:Ljava/lang/String;

.field static final version:Ljava/lang/String; = "&v=2.0.0"


# instance fields
.field private affiliateID:Ljava/lang/String;

.field playbackManagerLsnr:Lcom/espn/androidplayersdk/playbackmanager/EPPlaybackManagerListener;

.field playbackSession:Lcom/espn/androidplayersdk/datamanager/PlaybackSession;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 32
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "&sdkVersion="

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v1, Lcom/espn/androidplayersdk/datamanager/ESPNPlayerSdk;->SDK_VERSION_FOR_API:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;->sdkVersion:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lcom/espn/androidplayersdk/playbackmanager/EPPlaybackManagerListener;)V
    .locals 1
    .param p1, "playbackManager"    # Lcom/espn/androidplayersdk/playbackmanager/EPPlaybackManagerListener;

    .prologue
    .line 34
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 29
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;->affiliateID:Ljava/lang/String;

    .line 35
    iput-object p1, p0, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;->playbackManagerLsnr:Lcom/espn/androidplayersdk/playbackmanager/EPPlaybackManagerListener;

    .line 36
    return-void
.end method

.method static synthetic access$0(Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 139
    invoke-direct {p0, p1, p2}, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;->initiateStartSessionRequest(Ljava/lang/String;Z)V

    return-void
.end method

.method public static getDefaultStartSessionUrl(Ljava/lang/String;)Ljava/lang/String;
    .locals 6
    .param p0, "eventId"    # Ljava/lang/String;

    .prologue
    const/4 v5, 0x0

    .line 308
    const-string v2, "EPPlaybackManager.getDefaultStartSessionUrl:"

    const/4 v3, 0x3

    const/4 v4, 0x0

    invoke-static {v2, v3, v4}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 309
    const/4 v1, 0x0

    .line 310
    .local v1, "videoUrl":Ljava/lang/String;
    sget-object v2, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    const-string v3, "videoURLDefault"

    const-string v4, "events"

    invoke-virtual {v2, p0, v3, v4}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->getVideoInfo(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 312
    .local v0, "info":[Ljava/lang/String;
    if-eqz v0, :cond_1

    .line 313
    aget-object v1, v0, v5

    .line 320
    :cond_0
    :goto_0
    return-object v1

    .line 315
    :cond_1
    sget-object v2, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    const-string v3, "videoURLDefault"

    const-string v4, "featuredEvents"

    invoke-virtual {v2, p0, v3, v4}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->getVideoInfo(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 316
    if-eqz v0, :cond_0

    .line 317
    aget-object v1, v0, v5

    goto :goto_0
.end method

.method private initiateStartSessionRequest(Ljava/lang/String;Z)V
    .locals 9
    .param p1, "eventId"    # Ljava/lang/String;
    .param p2, "pollSessionForLinearNetwork"    # Z

    .prologue
    .line 142
    :try_start_0
    invoke-virtual {p0, p1}, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;->getVideoInfoForDevice(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v5

    .line 143
    .local v5, "videoInfo":[Ljava/lang/String;
    if-eqz v5, :cond_2

    .line 145
    invoke-virtual {p0, p1}, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;->createEventForTracking(Ljava/lang/String;)Lcom/espn/androidplayersdk/datamanager/EPEvents;

    move-result-object v1

    .line 146
    .local v1, "event":Lcom/espn/androidplayersdk/datamanager/EPEvents;
    invoke-static {v1}, Lcom/espn/androidplayersdk/datamanager/EPVideoTrackingManager;->setEventObj(Lcom/espn/androidplayersdk/datamanager/EPEvents;)V

    .line 147
    invoke-static {v1}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->setEventObj(Lcom/espn/androidplayersdk/datamanager/EPEvents;)V

    .line 149
    const/4 v7, 0x0

    aget-object v6, v5, v7

    .line 150
    .local v6, "videoUrl":Ljava/lang/String;
    const/4 v7, 0x1

    aget-object v2, v5, v7

    .line 151
    .local v2, "eventType":Ljava/lang/String;
    const/4 v7, 0x2

    aget-object v3, v5, v7

    .line 152
    .local v3, "networkType":Ljava/lang/String;
    const/4 v4, 0x0

    .line 153
    .local v4, "pollSession":Z
    const-string v7, "live"

    invoke-virtual {v2, v7}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_0

    const-string v7, "linear"

    invoke-virtual {v3, v7}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_0

    .line 154
    const/4 v4, 0x1

    .line 158
    :goto_0
    iget-object v7, p0, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;->playbackSession:Lcom/espn/androidplayersdk/datamanager/PlaybackSession;

    if-nez v7, :cond_1

    .line 159
    new-instance v7, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;

    iget-object v8, p0, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;->playbackManagerLsnr:Lcom/espn/androidplayersdk/playbackmanager/EPPlaybackManagerListener;

    invoke-direct {v7, v6, v8, p0, v4}, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;-><init>(Ljava/lang/String;Lcom/espn/androidplayersdk/playbackmanager/EPPlaybackManagerListener;Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;Z)V

    iput-object v7, p0, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;->playbackSession:Lcom/espn/androidplayersdk/datamanager/PlaybackSession;

    .line 160
    iget-object v7, p0, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;->playbackSession:Lcom/espn/androidplayersdk/datamanager/PlaybackSession;

    invoke-virtual {v7}, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->start()V

    .line 203
    .end local v1    # "event":Lcom/espn/androidplayersdk/datamanager/EPEvents;
    .end local v2    # "eventType":Ljava/lang/String;
    .end local v3    # "networkType":Ljava/lang/String;
    .end local v4    # "pollSession":Z
    .end local v5    # "videoInfo":[Ljava/lang/String;
    .end local v6    # "videoUrl":Ljava/lang/String;
    :goto_1
    return-void

    .line 156
    .restart local v1    # "event":Lcom/espn/androidplayersdk/datamanager/EPEvents;
    .restart local v2    # "eventType":Ljava/lang/String;
    .restart local v3    # "networkType":Ljava/lang/String;
    .restart local v4    # "pollSession":Z
    .restart local v5    # "videoInfo":[Ljava/lang/String;
    .restart local v6    # "videoUrl":Ljava/lang/String;
    :cond_0
    move v4, p2

    goto :goto_0

    .line 162
    :cond_1
    iget-object v7, p0, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;->playbackSession:Lcom/espn/androidplayersdk/datamanager/PlaybackSession;

    invoke-virtual {v7, v6}, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->updateVideoUrlForSessionChange(Ljava/lang/String;)V

    .line 163
    iget-object v7, p0, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;->playbackSession:Lcom/espn/androidplayersdk/datamanager/PlaybackSession;

    invoke-virtual {v7}, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->initiateStartSessionRequest()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 199
    .end local v1    # "event":Lcom/espn/androidplayersdk/datamanager/EPEvents;
    .end local v2    # "eventType":Ljava/lang/String;
    .end local v3    # "networkType":Ljava/lang/String;
    .end local v4    # "pollSession":Z
    .end local v5    # "videoInfo":[Ljava/lang/String;
    .end local v6    # "videoUrl":Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 200
    .local v0, "e":Ljava/lang/Exception;
    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "PlaybackManager"

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    if-eqz v7, :cond_3

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v7

    :goto_2
    const/4 v8, 0x5

    invoke-static {v7, v8, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 201
    iget-object v7, p0, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;->playbackManagerLsnr:Lcom/espn/androidplayersdk/playbackmanager/EPPlaybackManagerListener;

    const-string v8, "Event can not be found"

    invoke-interface {v7, v8}, Lcom/espn/androidplayersdk/playbackmanager/EPPlaybackManagerListener;->streamDidFailAuthorizationWithMessage(Ljava/lang/String;)V

    goto :goto_1

    .line 166
    .end local v0    # "e":Ljava/lang/Exception;
    .restart local v5    # "videoInfo":[Ljava/lang/String;
    :cond_2
    :try_start_1
    new-instance v7, Lcom/espn/androidplayersdk/datamanager/EPCatalogManager;

    invoke-direct {v7}, Lcom/espn/androidplayersdk/datamanager/EPCatalogManager;-><init>()V

    new-instance v8, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager$1;

    invoke-direct {v8, p0, p2}, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager$1;-><init>(Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;Z)V

    invoke-virtual {v7, p1, v8}, Lcom/espn/androidplayersdk/datamanager/EPCatalogManager;->getEventByID(Ljava/lang/String;Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Callback;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_1

    .line 200
    .end local v5    # "videoInfo":[Ljava/lang/String;
    .restart local v0    # "e":Ljava/lang/Exception;
    :cond_3
    const-string v7, ""

    goto :goto_2
.end method


# virtual methods
.method createEventForTracking(Ljava/lang/String;)Lcom/espn/androidplayersdk/datamanager/EPEvents;
    .locals 5
    .param p1, "eventId"    # Ljava/lang/String;

    .prologue
    .line 85
    :try_start_0
    sget-object v3, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    invoke-virtual {v3, p1}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->getEventById(Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 86
    .local v0, "cursor":Landroid/database/Cursor;
    invoke-interface {v0}, Landroid/database/Cursor;->getCount()I

    move-result v3

    if-lez v3, :cond_0

    invoke-interface {v0}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 87
    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    .line 88
    .local v2, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v3, "eventName"

    const-string v4, "eventName"

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 89
    const-string v3, "eventId"

    const-string v4, "eventId"

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 90
    const-string v3, "simulcastAiringId"

    const-string v4, "simulcastAiringId"

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 91
    const-string v3, "eventType"

    const-string v4, "eventType"

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 92
    const-string v3, "showName"

    const-string v4, "showName"

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 93
    const-string v3, "broadcastStartTime"

    const-string v4, "broadcastStartTime"

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 94
    const-string v3, "startTime"

    const-string v4, "startTime"

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 95
    const-string v3, "endTime"

    const-string v4, "endTime"

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 96
    const-string v3, "imageLarge"

    const-string v4, "imageLarge"

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 97
    const-string v3, "imageMed"

    const-string v4, "imageMed"

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 98
    const-string v3, "imageSmall"

    const-string v4, "imageSmall"

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 99
    const-string v3, "parentalRating"

    const-string v4, "parentalRating"

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 100
    const-string v3, "seekInSeconds"

    const-string v4, "seekInSeconds"

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 101
    const-string v3, "networkCode"

    const-string v4, "networkCode"

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 102
    const-string v3, "description"

    const-string v4, "description"

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 103
    const-string v3, "networkName"

    const-string v4, "networkName"

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 104
    const-string v3, "league"

    const-string v4, "league"

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 105
    const-string v3, "leagueName"

    const-string v4, "leagueName"

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 106
    const-string v3, "SPORT"

    const-string v4, "SPORT"

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 107
    const-string v3, "sportCode"

    const-string v4, "sportCode"

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 108
    const-string v3, "programingCode"

    const-string v4, "programingCode"

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 109
    const-string v3, "coverageType"

    const-string v4, "coverageType"

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 110
    const-string v3, "networkResourceId"

    const-string v4, "networkResourceId"

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 112
    new-instance v3, Lcom/espn/androidplayersdk/datamanager/EPEvents;

    invoke-direct {v3, v2}, Lcom/espn/androidplayersdk/datamanager/EPEvents;-><init>(Ljava/util/HashMap;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 117
    .end local v0    # "cursor":Landroid/database/Cursor;
    .end local v2    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    :goto_0
    return-object v3

    .line 114
    :catch_0
    move-exception v1

    .line 115
    .local v1, "e":Ljava/lang/Exception;
    const-string v3, "PlaybackManager:Unable to set event for tracking"

    const/4 v4, 0x5

    invoke-static {v3, v4, v1}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 117
    .end local v1    # "e":Ljava/lang/Exception;
    :cond_0
    const/4 v3, 0x0

    goto :goto_0
.end method

.method protected getAffiliateID()Ljava/lang/String;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;->affiliateID:Ljava/lang/String;

    return-object v0
.end method

.method getVideoInfoForDevice(Ljava/lang/String;)[Ljava/lang/String;
    .locals 7
    .param p1, "eventId"    # Ljava/lang/String;

    .prologue
    .line 285
    :try_start_0
    new-instance v3, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v3}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v4, "config"

    const-string v5, "deviceOverride"

    const/4 v6, 0x0

    invoke-virtual {v3, v4, v5, v6}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getBooleanField(Ljava/lang/String;Ljava/lang/String;Z)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 286
    sget-object v3, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    const-string v4, "videoURLDefault"

    const-string v5, "events"

    invoke-virtual {v3, p1, v4, v5}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->getVideoInfo(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v3

    .line 303
    :goto_0
    return-object v3

    .line 289
    :cond_0
    sget-object v3, Lcom/espn/androidplayersdk/datamanager/ESPNPlayerSdk;->mCtx:Landroid/content/Context;

    invoke-static {v3}, Lcom/espn/androidplayersdk/utilities/Utils;->isTablet(Landroid/content/Context;)Ljava/lang/Boolean;

    move-result-object v0

    .line 290
    .local v0, "deviceType":Ljava/lang/Boolean;
    const-string v2, ""

    .line 291
    .local v2, "urlType":Ljava/lang/String;
    if-eqz v0, :cond_2

    .line 292
    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 293
    const-string v2, "videoURLLarge"

    .line 299
    :goto_1
    sget-object v3, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    const-string v4, "events"

    invoke-virtual {v3, p1, v2, v4}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->getVideoInfo(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v3

    goto :goto_0

    .line 295
    :cond_1
    const-string v2, "videoURLMed"

    .line 296
    goto :goto_1

    .line 297
    :cond_2
    const-string v2, "videoURLSmall"
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 301
    .end local v0    # "deviceType":Ljava/lang/Boolean;
    .end local v2    # "urlType":Ljava/lang/String;
    :catch_0
    move-exception v1

    .line 302
    .local v1, "e":Ljava/lang/Exception;
    const-string v3, "PlaybackManager:Error: Default to medium bitrate stream "

    const/4 v4, 0x5

    invoke-static {v3, v4, v1}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 303
    sget-object v3, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    const-string v4, "videoURLMed"

    const-string v5, "events"

    invoke-virtual {v3, p1, v4, v5}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->getVideoInfo(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v3

    goto :goto_0
.end method

.method public initWithAdobePassContentProviderId(Ljava/lang/String;Ljava/lang/String;)V
    .locals 4
    .param p1, "contentProviderId"    # Ljava/lang/String;
    .param p2, "resource"    # Ljava/lang/String;

    .prologue
    .line 62
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v1, "startSession"

    const-string v2, "adobepasscontentproviderid"

    invoke-virtual {v0, v1, v2, p1}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->putField(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 63
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v1, "startSession"

    const-string v2, "resource"

    invoke-virtual {v0, v1, v2, p2}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->putField(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 64
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v1, "startSession"

    const-string v2, "tokenType"

    const-string v3, "ADOBEPASS"

    invoke-virtual {v0, v1, v2, v3}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->putField(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 65
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v1, "startSession"

    const-string v2, "inittype"

    const-string v3, "3"

    invoke-virtual {v0, v1, v2, v3}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->putField(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 66
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v1, "startSession"

    const-string v2, "startsessioncookie"

    const-string v3, ""

    invoke-virtual {v0, v1, v2, v3}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->putField(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 68
    return-void
.end method

.method public initWithToken(Ljava/lang/String;)V
    .locals 4
    .param p1, "token"    # Ljava/lang/String;

    .prologue
    .line 55
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v1, "startSession"

    const-string v2, "token"

    invoke-virtual {v0, v1, v2, p1}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->putField(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 56
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v1, "startSession"

    const-string v2, "inittype"

    const-string v3, "2"

    invoke-virtual {v0, v1, v2, v3}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->putField(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 57
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v1, "startSession"

    const-string v2, "startsessioncookie"

    const-string v3, ""

    invoke-virtual {v0, v1, v2, v3}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->putField(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 59
    return-void
.end method

.method public initWithUDID(Ljava/lang/String;Ljava/lang/String;)V
    .locals 4
    .param p1, "udid"    # Ljava/lang/String;
    .param p2, "cookie"    # Ljava/lang/String;

    .prologue
    .line 47
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v1, "startSession"

    const-string v2, "udid"

    invoke-virtual {v0, v1, v2, p1}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->putField(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 48
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v1, "startSession"

    const-string v2, "startsessioncookie"

    invoke-virtual {v0, v1, v2, p2}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->putField(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 49
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v1, "startSession"

    const-string v2, "tokenType"

    const-string v3, "DEVICE"

    invoke-virtual {v0, v1, v2, v3}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->putField(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 50
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v1, "startSession"

    const-string v2, "inittype"

    const-string v3, "1"

    invoke-virtual {v0, v1, v2, v3}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->putField(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 52
    return-void
.end method

.method public initiateLiveEventSessionForLinearNetwork(Ljava/lang/String;)V
    .locals 2
    .param p1, "networkId"    # Ljava/lang/String;

    .prologue
    .line 214
    const-string v0, "espn1"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "espn2"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "espnu"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 215
    const-string v0, "espnews"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "espndeportes"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "sec"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 216
    const-string v0, "longhorn"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 218
    :cond_0
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;

    new-instance v1, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager$2;

    invoke-direct {v1, p0}, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager$2;-><init>(Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;)V

    invoke-direct {v0, v1}, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;-><init>(Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;)V

    .line 239
    invoke-virtual {v0, p1}, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->getLiveEventForLinearNetwork(Ljava/lang/String;)V

    .line 245
    :goto_0
    return-void

    .line 242
    :cond_1
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;->playbackManagerLsnr:Lcom/espn/androidplayersdk/playbackmanager/EPPlaybackManagerListener;

    const-string v1, "Invalid network id"

    invoke-interface {v0, v1}, Lcom/espn/androidplayersdk/playbackmanager/EPPlaybackManagerListener;->streamDidFailAuthorizationWithMessage(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public initiateStartSessionRequest(Ljava/lang/String;)V
    .locals 1
    .param p1, "eventId"    # Ljava/lang/String;

    .prologue
    .line 127
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;->initiateStartSessionRequest(Ljava/lang/String;Z)V

    .line 128
    return-void
.end method

.method parse(Lorg/json/JSONObject;)Ljava/lang/String;
    .locals 7
    .param p1, "object"    # Lorg/json/JSONObject;

    .prologue
    const/4 v4, 0x0

    .line 249
    const-string v5, "EPPlaybackManager.parse:"

    const/4 v6, 0x3

    invoke-static {v5, v6, v4}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 254
    :try_start_0
    const-string v5, "listings"

    invoke-virtual {p1, v5}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v2

    .line 255
    .local v2, "listingsArray":Lorg/json/JSONArray;
    invoke-virtual {v2}, Lorg/json/JSONArray;->length()I

    move-result v3

    .line 256
    .local v3, "listingsArrayLength":I
    if-lez v3, :cond_0

    .line 257
    const/4 v5, 0x0

    invoke-virtual {v2, v5}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v1

    .line 258
    .local v1, "eventsObject":Lorg/json/JSONObject;
    const-string v5, "id"

    invoke-virtual {v1, v5}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_0

    const-string v5, "id"

    invoke-virtual {v1, v5}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_0

    .line 259
    const-string v5, "id"

    invoke-virtual {v1, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v4

    .line 264
    .end local v1    # "eventsObject":Lorg/json/JSONObject;
    .end local v2    # "listingsArray":Lorg/json/JSONArray;
    .end local v3    # "listingsArrayLength":I
    :cond_0
    :goto_0
    return-object v4

    .line 261
    :catch_0
    move-exception v0

    .line 262
    .local v0, "e":Lorg/json/JSONException;
    const-string v5, "EPPlaybackManager.parse: Enable to parse linear event for network"

    const/4 v6, 0x5

    invoke-static {v5, v6, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method public releaseSession()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 271
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;->playbackSession:Lcom/espn/androidplayersdk/datamanager/PlaybackSession;

    if-eqz v0, :cond_0

    .line 272
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;->playbackSession:Lcom/espn/androidplayersdk/datamanager/PlaybackSession;

    invoke-virtual {v0}, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->removeMaintainRequest()V

    .line 274
    :cond_0
    invoke-static {v1}, Lcom/espn/androidplayersdk/datamanager/EPVideoTrackingManager;->setEventObj(Lcom/espn/androidplayersdk/datamanager/EPEvents;)V

    .line 275
    invoke-static {v1}, Lcom/espn/androidplayersdk/datamanager/EPVideoTrackingManager;->setStreamObj(Lcom/espn/androidplayersdk/datamanager/EPStream;)V

    .line 276
    invoke-static {v1}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->setEventObj(Lcom/espn/androidplayersdk/datamanager/EPEvents;)V

    .line 277
    return-void
.end method

.method public setAffiliateID(Ljava/lang/String;)V
    .locals 0
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 39
    iput-object p1, p0, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;->affiliateID:Ljava/lang/String;

    .line 40
    return-void
.end method

.method public updateAdobePassParamenter(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "contentProviderId"    # Ljava/lang/String;
    .param p2, "resource"    # Ljava/lang/String;

    .prologue
    .line 71
    invoke-virtual {p0, p1, p2}, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;->initWithAdobePassContentProviderId(Ljava/lang/String;Ljava/lang/String;)V

    .line 72
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;->playbackSession:Lcom/espn/androidplayersdk/datamanager/PlaybackSession;

    if-eqz v0, :cond_0

    .line 73
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;->playbackSession:Lcom/espn/androidplayersdk/datamanager/PlaybackSession;

    invoke-virtual {v0}, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->releaseWaitForUpdateToken()V

    .line 74
    :cond_0
    return-void
.end method

.method public updateAffiliateToken(Ljava/lang/String;)V
    .locals 1
    .param p1, "token"    # Ljava/lang/String;

    .prologue
    .line 77
    invoke-virtual {p0, p1}, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;->initWithToken(Ljava/lang/String;)V

    .line 78
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;->playbackSession:Lcom/espn/androidplayersdk/datamanager/PlaybackSession;

    if-eqz v0, :cond_0

    .line 79
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;->playbackSession:Lcom/espn/androidplayersdk/datamanager/PlaybackSession;

    invoke-virtual {v0}, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->releaseWaitForUpdateToken()V

    .line 80
    :cond_0
    return-void
.end method
