.class public Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;
.super Lcom/comcast/cim/tracking/TrackingService;
.source "PlayNowTrackingService.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/tracking/TrackingService",
        "<",
        "Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;",
        ">;"
    }
.end annotation


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private final productName:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 15
    const-class v0, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Lcom/xfinity/playerlib/model/user/PlayNowUserManager;Ljava/lang/String;Ljava/lang/String;Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;Lcom/comcast/cim/cmasl/utils/provider/Provider;)V
    .locals 0
    .param p1, "userManager"    # Lcom/xfinity/playerlib/model/user/PlayNowUserManager;
    .param p2, "productName"    # Ljava/lang/String;
    .param p3, "applicationVersion"    # Ljava/lang/String;
    .param p4, "androidDevice"    # Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/xfinity/playerlib/model/user/PlayNowUserManager;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;",
            "Lcom/comcast/cim/cmasl/utils/provider/Provider",
            "<",
            "Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 59
    .local p5, "appMeasurementProvider":Lcom/comcast/cim/cmasl/utils/provider/Provider;, "Lcom/comcast/cim/cmasl/utils/provider/Provider<Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;>;"
    invoke-direct {p0, p1, p3, p4, p5}, Lcom/comcast/cim/tracking/TrackingService;-><init>(Lcom/comcast/cim/model/user/UserManager;Ljava/lang/String;Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;Lcom/comcast/cim/cmasl/utils/provider/Provider;)V

    .line 60
    iput-object p2, p0, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->productName:Ljava/lang/String;

    .line 61
    return-void
.end method

.method private buildAppMeasurement(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;
    .locals 3
    .param p1, "event"    # Ljava/lang/String;
    .param p2, "networkName"    # Ljava/lang/String;
    .param p3, "contentType"    # Ljava/lang/String;
    .param p4, "assetName"    # Ljava/lang/String;

    .prologue
    .line 166
    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->getAppMeasurement(Ljava/lang/String;)Lcom/comcast/cim/tracking/CimAppMeasurement;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;

    .line 167
    .local v0, "m":Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;
    const-string v1, "contentType"

    invoke-virtual {v0, v1, p3}, Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;->putCdata(Ljava/lang/String;Ljava/lang/Object;)V

    .line 168
    const-string v1, "networkName"

    invoke-virtual {v0, v1, p2}, Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;->putCdata(Ljava/lang/String;Ljava/lang/Object;)V

    .line 169
    const-string v1, "contentTitle"

    invoke-virtual {v0, v1, p4}, Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;->putCdata(Ljava/lang/String;Ljava/lang/Object;)V

    .line 170
    const-string v1, "authenticationStatus"

    const-string v2, "authenticated"

    invoke-virtual {v0, v1, v2}, Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;->putCdata(Ljava/lang/String;Ljava/lang/Object;)V

    .line 172
    return-object v0
.end method

.method private getAssetType(Lcom/xfinity/playerlib/model/consumable/VideoFacade;)Ljava/lang/String;
    .locals 1
    .param p1, "videoFacade"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    .prologue
    .line 284
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->isMovie()Z

    move-result v0

    if-eqz v0, :cond_0

    const-string v0, "movie"

    :goto_0
    return-object v0

    :cond_0
    const-string v0, "tvEpisode"

    goto :goto_0
.end method

.method private getNetworkName(Lcom/xfinity/playerlib/model/consumable/VideoFacade;)Ljava/lang/String;
    .locals 1
    .param p1, "videoFacade"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    .prologue
    .line 288
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getNetworkInfo()Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    move-result-object v0

    if-nez v0, :cond_0

    const-string v0, ""

    :goto_0
    return-object v0

    :cond_0
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getNetworkInfo()Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->getName()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method private getTrackableTitle(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)Ljava/lang/String;
    .locals 2
    .param p1, "videoFacade"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .param p2, "watchable"    # Lcom/xfinity/playerlib/model/consumable/Watchable;

    .prologue
    .line 276
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->isMovie()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 277
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getTitle()Ljava/lang/String;

    move-result-object v0

    .line 279
    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-interface {p2}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getSeriesInfoIfApplicable()Lcom/xfinity/playerlib/model/consumable/SeriesWatchableInfo;

    move-result-object v1

    invoke-interface {v1}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchableInfo;->getSeriesTitle()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " - "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getTitle()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method private trackDownload(Ljava/lang/String;Ljava/lang/String;Lcom/xfinity/playerlib/model/consumable/VideoFacade;)V
    .locals 11
    .param p1, "event"    # Ljava/lang/String;
    .param p2, "action"    # Ljava/lang/String;
    .param p3, "video"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    .prologue
    .line 260
    invoke-virtual {p3}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getNetworkInfo()Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    move-result-object v5

    if-nez v5, :cond_0

    const-string v3, ""

    .line 261
    .local v3, "networkName":Ljava/lang/String;
    :goto_0
    const-string v1, "video"

    .line 262
    .local v1, "assetType":Ljava/lang/String;
    invoke-virtual {p3}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getTitle()Ljava/lang/String;

    move-result-object v0

    .line 263
    .local v0, "assetName":Ljava/lang/String;
    invoke-virtual {p3}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getVideoId()J

    move-result-wide v6

    .line 265
    .local v6, "videoId":J
    const-string v5, "%s %s"

    const/4 v8, 0x2

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    iget-object v10, p0, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->productName:Ljava/lang/String;

    aput-object v10, v8, v9

    const/4 v9, 0x1

    aput-object v1, v8, v9

    invoke-static {v5, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    .line 266
    .local v4, "products":Ljava/lang/String;
    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->getAppMeasurement(Ljava/lang/String;)Lcom/comcast/cim/tracking/CimAppMeasurement;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;

    .line 268
    .local v2, "m":Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;
    const-string v5, "mediaID"

    invoke-static {v6, v7}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v2, v5, v8}, Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;->putCdata(Ljava/lang/String;Ljava/lang/Object;)V

    .line 269
    const-string v5, "contentName"

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v8, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, " : "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, " ("

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, ")"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v2, v5, v8}, Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;->putCdata(Ljava/lang/String;Ljava/lang/Object;)V

    .line 270
    const-string v5, "hashedGUID"

    iget-object v8, p0, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->userManager:Lcom/comcast/cim/model/user/UserManager;

    invoke-virtual {v8}, Lcom/comcast/cim/model/user/UserManager;->getHashedOmnitureGuid()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v2, v5, v8}, Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;->putCdata(Ljava/lang/String;Ljava/lang/Object;)V

    .line 271
    const-string v5, "deviceBrand"

    sget-object v8, Landroid/os/Build;->BRAND:Ljava/lang/String;

    invoke-virtual {v2, v5, v8}, Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;->putCdata(Ljava/lang/String;Ljava/lang/Object;)V

    .line 272
    invoke-virtual {v2, p2}, Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;->trackAction(Ljava/lang/String;)V

    .line 273
    return-void

    .line 260
    .end local v0    # "assetName":Ljava/lang/String;
    .end local v1    # "assetType":Ljava/lang/String;
    .end local v2    # "m":Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;
    .end local v3    # "networkName":Ljava/lang/String;
    .end local v4    # "products":Ljava/lang/String;
    .end local v6    # "videoId":J
    :cond_0
    invoke-virtual {p3}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getNetworkInfo()Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    move-result-object v5

    invoke-virtual {v5}, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->getName()Ljava/lang/String;

    move-result-object v3

    goto :goto_0
.end method

.method private trackEvent(Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;Ljava/lang/String;I)V
    .locals 3
    .param p1, "m"    # Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;
    .param p2, "assetType"    # Ljava/lang/String;
    .param p3, "position"    # I

    .prologue
    .line 177
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->productName:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " - "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " - "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " seconds watched"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 178
    .local v0, "action":Ljava/lang/String;
    invoke-virtual {p1, v0}, Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;->trackAction(Ljava/lang/String;)V

    .line 179
    return-void
.end method

.method private trackState(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "event"    # Ljava/lang/String;
    .param p2, "state"    # Ljava/lang/String;

    .prologue
    .line 202
    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->getAppMeasurement(Ljava/lang/String;)Lcom/comcast/cim/tracking/CimAppMeasurement;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;

    .line 203
    .local v0, "m":Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;
    invoke-virtual {v0, p2}, Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;->trackState(Ljava/lang/String;)V

    .line 204
    return-void
.end method


# virtual methods
.method public trackAMSRelatedVideoError(Ljava/lang/String;)V
    .locals 4
    .param p1, "errorMessage"    # Ljava/lang/String;

    .prologue
    .line 230
    sget-object v2, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->LOG:Lorg/slf4j/Logger;

    const-string v3, "trackAMSRelatedVideoError"

    invoke-interface {v2, v3}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 232
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->productName:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " video error : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 234
    .local v1, "state":Ljava/lang/String;
    iget-object v2, p0, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->appMeasurementProvider:Lcom/comcast/cim/cmasl/utils/provider/Provider;

    invoke-interface {v2}, Lcom/comcast/cim/cmasl/utils/provider/Provider;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;

    .line 236
    .local v0, "m":Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;
    const-string v2, "playbackError"

    invoke-virtual {v0, v2}, Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;->setEvents(Ljava/lang/String;)V

    .line 237
    const-string v2, "errorMessage"

    invoke-virtual {v0, v2, p1}, Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;->putCdata(Ljava/lang/String;Ljava/lang/Object;)V

    .line 238
    const-string v2, "t1"

    invoke-virtual {v0, v2, v1}, Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;->putCdata(Ljava/lang/String;Ljava/lang/Object;)V

    .line 244
    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;->trackState(Ljava/lang/String;)V

    .line 245
    return-void
.end method

.method public trackDownloadRequest(Lcom/xfinity/playerlib/model/consumable/VideoFacade;)V
    .locals 2
    .param p1, "video"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    .prologue
    .line 249
    sget-object v0, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->LOG:Lorg/slf4j/Logger;

    const-string v1, "trackDownloadRequest"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 250
    const-string v0, "downloadStarted"

    const-string v1, "downloadReuest"

    invoke-direct {p0, v0, v1, p1}, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->trackDownload(Ljava/lang/String;Ljava/lang/String;Lcom/xfinity/playerlib/model/consumable/VideoFacade;)V

    .line 251
    return-void
.end method

.method public trackDownloadSuccess(Lcom/xfinity/playerlib/model/consumable/VideoFacade;)V
    .locals 2
    .param p1, "video"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    .prologue
    .line 255
    sget-object v0, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->LOG:Lorg/slf4j/Logger;

    const-string v1, "trackDownloadSuccess"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 256
    const-string v0, "downloadCompleted"

    const-string v1, "downloadSuccess"

    invoke-direct {p0, v0, v1, p1}, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->trackDownload(Ljava/lang/String;Ljava/lang/String;Lcom/xfinity/playerlib/model/consumable/VideoFacade;)V

    .line 257
    return-void
.end method

.method public trackLiveStreamEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    .locals 3
    .param p1, "event"    # Ljava/lang/String;
    .param p2, "networkName"    # Ljava/lang/String;
    .param p3, "assetType"    # Ljava/lang/String;
    .param p4, "assetName"    # Ljava/lang/String;
    .param p5, "streamId"    # Ljava/lang/String;
    .param p6, "position"    # I

    .prologue
    .line 136
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->buildAppMeasurement(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;

    move-result-object v0

    .line 137
    .local v0, "m":Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;
    const-string v1, "VODID"

    const-string v2, "live stream - no associated ID"

    invoke-virtual {v0, v1, v2}, Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;->putCdata(Ljava/lang/String;Ljava/lang/Object;)V

    .line 138
    const-string v1, "playbackType"

    const-string v2, "live"

    invoke-virtual {v0, v1, v2}, Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;->putCdata(Ljava/lang/String;Ljava/lang/Object;)V

    .line 139
    const-string v1, "liveID"

    invoke-virtual {v0, v1, p5}, Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;->putCdata(Ljava/lang/String;Ljava/lang/Object;)V

    .line 141
    invoke-direct {p0, v0, p3, p6}, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->trackEvent(Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;Ljava/lang/String;I)V

    .line 142
    return-void
.end method

.method public trackLiveStreamIncremental(Ljava/lang/String;Ljava/lang/String;II)V
    .locals 3
    .param p1, "networkName"    # Ljava/lang/String;
    .param p2, "streamId"    # Ljava/lang/String;
    .param p3, "position"    # I
    .param p4, "interval"    # I

    .prologue
    .line 119
    const-string v1, "event39"

    const-string v2, "liveStream"

    invoke-direct {p0, v1, p1, v2, p1}, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->buildAppMeasurement(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;

    move-result-object v0

    .line 121
    .local v0, "m":Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;
    const-string v1, "VODID"

    const-string v2, "live stream - no associated ID"

    invoke-virtual {v0, v1, v2}, Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;->putCdata(Ljava/lang/String;Ljava/lang/Object;)V

    .line 122
    const-string v1, "playbackType"

    const-string v2, "live"

    invoke-virtual {v0, v1, v2}, Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;->putCdata(Ljava/lang/String;Ljava/lang/Object;)V

    .line 123
    const-string v1, "liveID"

    invoke-virtual {v0, v1, p2}, Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;->putCdata(Ljava/lang/String;Ljava/lang/Object;)V

    .line 124
    const-string v1, "secondswatched"

    invoke-static {p4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;->putCdata(Ljava/lang/String;Ljava/lang/Object;)V

    .line 126
    const-string v1, "liveStream"

    invoke-direct {p0, v0, v1, p3}, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->trackEvent(Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;Ljava/lang/String;I)V

    .line 127
    return-void
.end method

.method public trackLiveStreamPlaybackMilestone(Lcom/xfinity/playerlib/tracking/VideoMilestone;Ljava/lang/String;Ljava/lang/String;I)V
    .locals 7
    .param p1, "milestone"    # Lcom/xfinity/playerlib/tracking/VideoMilestone;
    .param p2, "networkName"    # Ljava/lang/String;
    .param p3, "streamId"    # Ljava/lang/String;
    .param p4, "position"    # I

    .prologue
    .line 86
    sget-object v0, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->LOG:Lorg/slf4j/Logger;

    const-string v1, "trackVideoPlaybackMilestone() milestone={} assetName={}"

    const-string v2, "liveStream"

    invoke-interface {v0, v1, p1, v2}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 88
    sget-object v0, Lcom/xfinity/playerlib/tracking/VideoMilestone;->NOT_STARTED:Lcom/xfinity/playerlib/tracking/VideoMilestone;

    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/tracking/VideoMilestone;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 89
    sget-object v0, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->LOG:Lorg/slf4j/Logger;

    const-string v1, "trackVideoPlaybackMilestone() don\'t track not started; returning"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 94
    :goto_0
    return-void

    .line 93
    :cond_0
    invoke-virtual {p1}, Lcom/xfinity/playerlib/tracking/VideoMilestone;->getEvent()Ljava/lang/String;

    move-result-object v1

    const-string v3, "liveStream"

    move-object v0, p0

    move-object v2, p2

    move-object v4, p2

    move-object v5, p3

    move v6, p4

    invoke-virtual/range {v0 .. v6}, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->trackLiveStreamEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V

    goto :goto_0
.end method

.method public trackParentalControlsPinPadRendered()V
    .locals 2

    .prologue
    .line 188
    sget-object v0, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->LOG:Lorg/slf4j/Logger;

    const-string v1, "trackParentalControlsPinPadRendered"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 189
    const-string v0, "parentalPinRendered"

    const-string v1, "parental controls pin pad"

    invoke-direct {p0, v0, v1}, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->trackState(Ljava/lang/String;Ljava/lang/String;)V

    .line 190
    return-void
.end method

.method public trackSignInScreenRendered()V
    .locals 3

    .prologue
    .line 182
    sget-object v0, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->LOG:Lorg/slf4j/Logger;

    const-string v1, "trackSignInScreenRendered()"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 183
    const-string v0, "sign in"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->productName:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " - sign in"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v0, v1}, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->trackState(Ljava/lang/String;Ljava/lang/String;)V

    .line 184
    return-void
.end method

.method public trackTabRendered(Lcom/xfinity/playerlib/tracking/PlayNowTab;)V
    .locals 5
    .param p1, "tab"    # Lcom/xfinity/playerlib/tracking/PlayNowTab;

    .prologue
    .line 193
    sget-object v2, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->LOG:Lorg/slf4j/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "trackTabRendered() tab="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 195
    const-string v2, "sectionTapped"

    invoke-virtual {p0, v2}, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->getAppMeasurement(Ljava/lang/String;)Lcom/comcast/cim/tracking/CimAppMeasurement;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;

    .line 196
    .local v0, "m":Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->productName:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " - "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p1}, Lcom/xfinity/playerlib/tracking/PlayNowTab;->getTabName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 197
    .local v1, "pageName":Ljava/lang/String;
    const-string v2, "pageName"

    invoke-virtual {v0, v2, v1}, Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;->putCdata(Ljava/lang/String;Ljava/lang/Object;)V

    .line 198
    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;->trackState(Ljava/lang/String;)V

    .line 199
    return-void
.end method

.method public trackTapMovieAsset(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 6
    .param p1, "movieName"    # Ljava/lang/String;
    .param p2, "merlinId"    # Ljava/lang/String;
    .param p3, "networkName"    # Ljava/lang/String;

    .prologue
    .line 207
    sget-object v2, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->LOG:Lorg/slf4j/Logger;

    const-string v3, "trackTapMovieAsset() movieName={} merlinId={} networkName={}"

    const/4 v4, 0x3

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    aput-object p1, v4, v5

    const/4 v5, 0x1

    aput-object p2, v4, v5

    const/4 v5, 0x2

    aput-object p3, v4, v5

    invoke-interface {v2, v3, v4}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 209
    const-string v2, "browseEntity"

    invoke-virtual {p0, v2}, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->getAppMeasurement(Ljava/lang/String;)Lcom/comcast/cim/tracking/CimAppMeasurement;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;

    .line 211
    .local v1, "m":Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;
    const-string v2, "entityID"

    invoke-virtual {v1, v2, p2}, Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;->putCdata(Ljava/lang/String;Ljava/lang/Object;)V

    .line 212
    const-string v2, "contentType"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v4, p0, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->productName:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " movie"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;->putCdata(Ljava/lang/String;Ljava/lang/Object;)V

    .line 213
    const-string v2, "networkName"

    invoke-virtual {v1, v2, p3}, Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;->putCdata(Ljava/lang/String;Ljava/lang/Object;)V

    .line 214
    const-string v2, "contentTitle"

    invoke-virtual {v1, v2, p1}, Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;->putCdata(Ljava/lang/String;Ljava/lang/Object;)V

    .line 215
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->productName:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " \u2013 movie selected"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 217
    .local v0, "action":Ljava/lang/String;
    invoke-virtual {v1, v0}, Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;->trackAction(Ljava/lang/String;)V

    .line 218
    return-void
.end method

.method public trackTapNetworkLogo(Ljava/lang/String;)V
    .locals 5
    .param p1, "networkName"    # Ljava/lang/String;

    .prologue
    .line 221
    sget-object v2, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->LOG:Lorg/slf4j/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "trackTapNetworkLogo() networkName="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 223
    const-string v2, "networkView"

    invoke-virtual {p0, v2}, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->getAppMeasurement(Ljava/lang/String;)Lcom/comcast/cim/tracking/CimAppMeasurement;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;

    .line 224
    .local v1, "m":Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "android app : network tab click \u2013 Play Now : Premium Networks - "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 226
    .local v0, "action":Ljava/lang/String;
    invoke-virtual {v1, v0}, Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;->trackAction(Ljava/lang/String;)V

    .line 227
    return-void
.end method

.method public trackVideoIncremental(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;II)V
    .locals 6
    .param p1, "videoFacade"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .param p2, "watchable"    # Lcom/xfinity/playerlib/model/consumable/Watchable;
    .param p3, "position"    # I
    .param p4, "interval"    # I

    .prologue
    .line 101
    invoke-direct {p0, p1, p2}, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->getTrackableTitle(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)Ljava/lang/String;

    move-result-object v0

    .line 102
    .local v0, "assetName":Ljava/lang/String;
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->getAssetType(Lcom/xfinity/playerlib/model/consumable/VideoFacade;)Ljava/lang/String;

    move-result-object v1

    .line 104
    .local v1, "assetType":Ljava/lang/String;
    const-string v3, "event39"

    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->getNetworkName(Lcom/xfinity/playerlib/model/consumable/VideoFacade;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {p0, v3, v4, v1, v0}, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->buildAppMeasurement(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;

    move-result-object v2

    .line 106
    .local v2, "m":Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;
    const-string v3, "VODID"

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getVideoId()J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;->putCdata(Ljava/lang/String;Ljava/lang/Object;)V

    .line 107
    const-string v3, "playbackType"

    const-string v4, "standard"

    invoke-virtual {v2, v3, v4}, Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;->putCdata(Ljava/lang/String;Ljava/lang/Object;)V

    .line 108
    const-string v3, "liveID"

    const-string v4, "vod asset \u2013 no associated live stream ID"

    invoke-virtual {v2, v3, v4}, Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;->putCdata(Ljava/lang/String;Ljava/lang/Object;)V

    .line 109
    const-string v3, "secondswatched"

    invoke-static {p4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;->putCdata(Ljava/lang/String;Ljava/lang/Object;)V

    .line 111
    invoke-direct {p0, v2, v1, p3}, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->trackEvent(Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;Ljava/lang/String;I)V

    .line 112
    return-void
.end method

.method public trackVideoPlaybackMilestone(Lcom/xfinity/playerlib/tracking/VideoMilestone;Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;I)V
    .locals 8
    .param p1, "milestone"    # Lcom/xfinity/playerlib/tracking/VideoMilestone;
    .param p2, "videoFacade"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .param p3, "watchable"    # Lcom/xfinity/playerlib/model/consumable/Watchable;
    .param p4, "position"    # I

    .prologue
    .line 68
    invoke-direct {p0, p2, p3}, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->getTrackableTitle(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)Ljava/lang/String;

    move-result-object v4

    .line 69
    .local v4, "assetName":Ljava/lang/String;
    sget-object v0, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->LOG:Lorg/slf4j/Logger;

    const-string v1, "trackVideoPlaybackMilestone() milestone={} assetName={}"

    invoke-interface {v0, v1, p1, v4}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 71
    sget-object v0, Lcom/xfinity/playerlib/tracking/VideoMilestone;->NOT_STARTED:Lcom/xfinity/playerlib/tracking/VideoMilestone;

    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/tracking/VideoMilestone;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 72
    sget-object v0, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->LOG:Lorg/slf4j/Logger;

    const-string v1, "trackVideoPlaybackMilestone() don\'t track not started; returning"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 79
    :goto_0
    return-void

    .line 76
    :cond_0
    invoke-direct {p0, p2}, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->getAssetType(Lcom/xfinity/playerlib/model/consumable/VideoFacade;)Ljava/lang/String;

    move-result-object v3

    .line 77
    .local v3, "assetType":Ljava/lang/String;
    invoke-virtual {p1}, Lcom/xfinity/playerlib/tracking/VideoMilestone;->getEvent()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, p2}, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->getNetworkName(Lcom/xfinity/playerlib/model/consumable/VideoFacade;)Ljava/lang/String;

    move-result-object v2

    .line 78
    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getVideoId()J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v5

    move-object v0, p0

    move v6, p4

    .line 77
    invoke-virtual/range {v0 .. v6}, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->trackVodEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V

    goto :goto_0
.end method

.method public trackVodEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    .locals 3
    .param p1, "event"    # Ljava/lang/String;
    .param p2, "networkName"    # Ljava/lang/String;
    .param p3, "assetType"    # Ljava/lang/String;
    .param p4, "assetName"    # Ljava/lang/String;
    .param p5, "vodId"    # Ljava/lang/String;
    .param p6, "position"    # I

    .prologue
    .line 152
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->buildAppMeasurement(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;

    move-result-object v0

    .line 154
    .local v0, "m":Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;
    const-string v1, "VODID"

    invoke-virtual {v0, v1, p5}, Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;->putCdata(Ljava/lang/String;Ljava/lang/Object;)V

    .line 155
    const-string v1, "playbackType"

    const-string v2, "standard"

    invoke-virtual {v0, v1, v2}, Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;->putCdata(Ljava/lang/String;Ljava/lang/Object;)V

    .line 156
    const-string v1, "liveID"

    const-string v2, "vod asset \u2013 no associated live stream ID"

    invoke-virtual {v0, v1, v2}, Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;->putCdata(Ljava/lang/String;Ljava/lang/Object;)V

    .line 158
    invoke-direct {p0, v0, p3, p6}, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->trackEvent(Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;Ljava/lang/String;I)V

    .line 159
    return-void
.end method
