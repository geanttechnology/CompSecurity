.class public Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;
.super Lcom/comcast/cim/downloads/DownloadServiceManager;
.source "PlayerDownloadServiceManager.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/downloads/DownloadServiceManager",
        "<",
        "Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;",
        "Lcom/xfinity/playerlib/model/user/PlayNowUser;",
        "Lcom/xfinity/playerlib/model/user/PlayerUserSettings;",
        ">;"
    }
.end annotation


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private final entityCache:Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;

.field private final trackingService:Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

.field private final watchableCodec:Lcom/xfinity/playerlib/model/consumable/WatchableCodec;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 44
    const-class v0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Lcom/xfinity/playerlib/PlayerApplication;Lcom/comcast/cim/utils/JsonSerializer;Lcom/xfinity/playerlib/model/downloads/DownloadableFileFactory;Lcom/xfinity/playerlib/model/user/PlayNowUserManager;Lcom/xfinity/playerlib/model/consumable/WatchableCodec;Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;Landroid/content/SharedPreferences;)V
    .locals 9
    .param p1, "applicationContext"    # Lcom/xfinity/playerlib/PlayerApplication;
    .param p2, "downloadMetaDataSerializer"    # Lcom/comcast/cim/utils/JsonSerializer;
    .param p3, "downloadableFileFactory"    # Lcom/xfinity/playerlib/model/downloads/DownloadableFileFactory;
    .param p4, "userManager"    # Lcom/xfinity/playerlib/model/user/PlayNowUserManager;
    .param p5, "watchableCodec"    # Lcom/xfinity/playerlib/model/consumable/WatchableCodec;
    .param p6, "entityCache"    # Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;
    .param p7, "backgroundExecutor"    # Ljava/util/concurrent/Executor;
    .param p8, "foregroundExecutor"    # Ljava/util/concurrent/Executor;
    .param p9, "trackingService"    # Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;
    .param p10, "sharedPreferences"    # Landroid/content/SharedPreferences;

    .prologue
    .line 56
    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    move-object/from16 v6, p7

    move-object/from16 v7, p8

    move-object/from16 v8, p10

    invoke-direct/range {v1 .. v8}, Lcom/comcast/cim/downloads/DownloadServiceManager;-><init>(Landroid/app/Application;Lcom/comcast/cim/utils/JsonSerializer;Lcom/comcast/cim/downloads/DownloadFileFactory;Lcom/comcast/cim/model/user/UserManager;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;Landroid/content/SharedPreferences;)V

    .line 58
    iput-object p5, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->watchableCodec:Lcom/xfinity/playerlib/model/consumable/WatchableCodec;

    .line 59
    iput-object p6, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->entityCache:Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;

    .line 60
    move-object/from16 v0, p9

    iput-object v0, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->trackingService:Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

    .line 61
    return-void
.end method

.method static synthetic access$000(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;)Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    .prologue
    .line 39
    iget-object v0, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->trackingService:Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

    return-object v0
.end method

.method static synthetic access$100(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;)Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    .prologue
    .line 39
    iget-object v0, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->entityCache:Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;

    return-object v0
.end method

.method static synthetic access$200(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;Ljava/lang/String;Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;Lcom/comcast/cim/downloads/DownloadMetaData;Ljava/lang/Runnable;Lcom/google/common/util/concurrent/FutureCallback;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;
    .param p1, "x1"    # Ljava/lang/String;
    .param p2, "x2"    # Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;
    .param p3, "x3"    # Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;
    .param p4, "x4"    # Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;
    .param p5, "x5"    # Lcom/comcast/cim/downloads/DownloadMetaData;
    .param p6, "x6"    # Ljava/lang/Runnable;
    .param p7, "x7"    # Lcom/google/common/util/concurrent/FutureCallback;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/downloads/DownloadServiceException;
        }
    .end annotation

    .prologue
    .line 39
    invoke-virtual/range {p0 .. p7}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->downloadHlsFileWithMetadata(Ljava/lang/String;Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;Lcom/comcast/cim/downloads/DownloadMetaData;Ljava/lang/Runnable;Lcom/google/common/util/concurrent/FutureCallback;)V

    return-void
.end method

.method private declared-synchronized setCellularDataQuotaForCurrentUser(Lcom/xfinity/playerlib/model/user/PlayerUserSettings;)V
    .locals 4
    .param p1, "settings"    # Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    .prologue
    .line 99
    monitor-enter p0

    :try_start_0
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getUseCellularWhenAvailable()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 100
    const-wide/high16 v2, -0x4010000000000000L    # -1.0

    invoke-virtual {p0, v2, v3}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->setCellularDataThreshold(D)V
    :try_end_0
    .catch Lcom/comcast/cim/downloads/DownloadServiceException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 107
    :goto_0
    monitor-exit p0

    return-void

    .line 102
    :cond_0
    const-wide/16 v2, 0x0

    :try_start_1
    invoke-virtual {p0, v2, v3}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->setCellularDataThreshold(D)V
    :try_end_1
    .catch Lcom/comcast/cim/downloads/DownloadServiceException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 104
    :catch_0
    move-exception v0

    .line 105
    .local v0, "exception":Lcom/comcast/cim/downloads/DownloadServiceException;
    :try_start_2
    new-instance v1, Ljava/lang/RuntimeException;

    invoke-direct {v1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v1
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 99
    .end local v0    # "exception":Lcom/comcast/cim/downloads/DownloadServiceException;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method


# virtual methods
.method public downloadHlsFileWithWatchable(Lcom/xfinity/playerlib/model/consumable/Watchable;Lcom/xfinity/playerlib/model/consumable/VideoFacade;Ljava/util/Date;Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;Lcom/google/common/util/concurrent/FutureCallback;)V
    .locals 29
    .param p1, "watchable"    # Lcom/xfinity/playerlib/model/consumable/Watchable;
    .param p2, "video"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .param p3, "licenseExpirationDate"    # Ljava/util/Date;
    .param p4, "simplePlaylist"    # Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;
    .param p5, "variantPlaylist"    # Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;
    .param p6, "alternateAudioPlaylist"    # Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;
    .param p7, "videoProfile"    # Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/xfinity/playerlib/model/consumable/Watchable;",
            "Lcom/xfinity/playerlib/model/consumable/VideoFacade;",
            "Ljava/util/Date;",
            "Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;",
            "Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;",
            "Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;",
            "Lcom/google/common/util/concurrent/FutureCallback",
            "<",
            "Ljava/lang/Void;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 163
    .local p8, "resultCallback":Lcom/google/common/util/concurrent/FutureCallback;, "Lcom/google/common/util/concurrent/FutureCallback<Ljava/lang/Void;>;"
    sget-object v10, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->LOG:Lorg/slf4j/Logger;

    const-string v11, "Attempting to download a file"

    invoke-interface {v10, v11}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 164
    invoke-static/range {p1 .. p1}, Lorg/apache/commons/lang3/Validate;->notNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 165
    invoke-static/range {p2 .. p2}, Lorg/apache/commons/lang3/Validate;->notNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 166
    invoke-static/range {p8 .. p8}, Lorg/apache/commons/lang3/Validate;->notNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 169
    invoke-virtual/range {p0 .. p0}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->isFileListReady()Z

    move-result v10

    invoke-static {v10}, Lorg/apache/commons/lang3/Validate;->isTrue(Z)V

    .line 170
    invoke-virtual/range {p0 .. p0}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->getFilesList()Ljava/util/List;

    move-result-object v26

    .line 171
    .local v26, "files":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;>;"
    const/16 v23, 0x0

    .line 172
    .local v23, "count":I
    invoke-interface/range {v26 .. v26}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v10

    :cond_0
    :goto_0
    invoke-interface {v10}, Ljava/util/Iterator;->hasNext()Z

    move-result v11

    if-eqz v11, :cond_1

    invoke-interface {v10}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v25

    check-cast v25, Lcom/comcast/cim/downloads/DownloadFile;

    .local v25, "file":Lcom/comcast/cim/downloads/DownloadFile;
    move-object/from16 v27, v25

    .line 173
    check-cast v27, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    .line 174
    .local v27, "playerFile":Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    invoke-virtual/range {v27 .. v27}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getExpirationStatus()Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile$ExpirationStatus;

    move-result-object v11

    sget-object v12, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile$ExpirationStatus;->AAW_EXPIRED:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile$ExpirationStatus;

    if-eq v11, v12, :cond_0

    .line 175
    add-int/lit8 v23, v23, 0x1

    goto :goto_0

    .line 179
    .end local v25    # "file":Lcom/comcast/cim/downloads/DownloadFile;
    .end local v27    # "playerFile":Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    :cond_1
    const/16 v10, 0xa

    move/from16 v0, v23

    if-lt v0, v10, :cond_2

    .line 180
    new-instance v10, Lcom/comcast/cim/downloads/MaxDownloadsReachedException;

    const-string v11, "Max Downloads Reached!"

    invoke-direct {v10, v11}, Lcom/comcast/cim/downloads/MaxDownloadsReachedException;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p8

    invoke-interface {v0, v10}, Lcom/google/common/util/concurrent/FutureCallback;->onFailure(Ljava/lang/Throwable;)V

    .line 212
    :goto_1
    return-void

    .line 184
    :cond_2
    invoke-virtual/range {p2 .. p2}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getVideoId()J

    move-result-wide v7

    .line 187
    .local v7, "videoId":J
    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->watchableCodec:Lcom/xfinity/playerlib/model/consumable/WatchableCodec;

    move-object/from16 v0, p1

    move-object/from16 v1, p2

    invoke-virtual {v10, v0, v1}, Lcom/xfinity/playerlib/model/consumable/WatchableCodec;->encode(Lcom/xfinity/playerlib/model/consumable/Watchable;Lcom/xfinity/playerlib/model/consumable/VideoFacade;)Lcom/xfinity/playerlib/model/consumable/EncodedWatchable;

    move-result-object v24

    .line 188
    .local v24, "encodedWatchable":Lcom/xfinity/playerlib/model/consumable/EncodedWatchable;
    invoke-virtual/range {v24 .. v24}, Lcom/xfinity/playerlib/model/consumable/EncodedWatchable;->getBackingEntity()Lcom/comcast/cim/cmasl/utils/container/Either;

    move-result-object v22

    .line 189
    .local v22, "backingEntity":Lcom/comcast/cim/cmasl/utils/container/Either;, "Lcom/comcast/cim/cmasl/utils/container/Either<Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;>;"
    new-instance v9, Ljava/util/Date;

    invoke-direct {v9}, Ljava/util/Date;-><init>()V

    .line 190
    .local v9, "now":Ljava/util/Date;
    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v5

    .line 191
    .local v5, "uuid":Ljava/util/UUID;
    invoke-virtual/range {v24 .. v24}, Lcom/xfinity/playerlib/model/consumable/EncodedWatchable;->getWatchableKey()Lcom/xfinity/playerlib/model/consumable/WatchableKey;

    move-result-object v6

    .line 192
    .local v6, "watchableKey":Lcom/xfinity/playerlib/model/consumable/WatchableKey;
    new-instance v4, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;

    invoke-virtual/range {p7 .. p7}, Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;->getContentSizeInBytes()J

    move-result-wide v10

    move-object v12, v9

    move-object/from16 v13, p3

    invoke-direct/range {v4 .. v13}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;-><init>(Ljava/util/UUID;Lcom/xfinity/playerlib/model/consumable/WatchableKey;JLjava/util/Date;JLjava/util/Date;Ljava/util/Date;)V

    .line 194
    .local v4, "metaData":Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;
    new-instance v20, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager$1;

    move-object/from16 v0, v20

    move-object/from16 v1, p0

    move-object/from16 v2, p2

    invoke-direct {v0, v1, v2}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager$1;-><init>(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;Lcom/xfinity/playerlib/model/consumable/VideoFacade;)V

    .line 201
    .local v20, "extraTask":Ljava/lang/Runnable;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->backgroundExecutor:Ljava/util/concurrent/Executor;

    move-object/from16 v28, v0

    new-instance v10, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager$2;

    move-object/from16 v11, p0

    move-object v12, v5

    move-object/from16 v13, v22

    move-wide v14, v7

    move-object/from16 v16, p4

    move-object/from16 v17, p5

    move-object/from16 v18, p6

    move-object/from16 v19, v4

    move-object/from16 v21, p8

    invoke-direct/range {v10 .. v21}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager$2;-><init>(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;Ljava/util/UUID;Lcom/comcast/cim/cmasl/utils/container/Either;JLcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;Ljava/lang/Runnable;Lcom/google/common/util/concurrent/FutureCallback;)V

    move-object/from16 v0, v28

    invoke-interface {v0, v10}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    goto :goto_1
.end method

.method public findFileWithMerlinData(Lcom/xfinity/playerlib/model/MerlinId;Lcom/xfinity/playerlib/model/MerlinId;Ljava/lang/Long;)Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    .locals 12
    .param p1, "merlinId"    # Lcom/xfinity/playerlib/model/MerlinId;
    .param p2, "parentMerlinId"    # Lcom/xfinity/playerlib/model/MerlinId;
    .param p3, "companyId"    # Ljava/lang/Long;

    .prologue
    .line 231
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->getFilesList()Ljava/util/List;

    move-result-object v1

    .line 232
    .local v1, "files":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;>;"
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :cond_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_3

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/downloads/DownloadFile;

    .local v0, "file":Lcom/comcast/cim/downloads/DownloadFile;
    move-object v2, v0

    .line 233
    check-cast v2, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    .line 234
    .local v2, "playerFile":Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getWatchable()Lcom/xfinity/playerlib/model/consumable/Watchable;

    move-result-object v4

    .line 237
    .local v4, "watchable":Lcom/xfinity/playerlib/model/consumable/Watchable;
    invoke-interface {v4}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v6

    invoke-virtual {v6, p1}, Lcom/xfinity/playerlib/model/MerlinId;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_0

    invoke-interface {v4}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getParentMerlinIdIfApplicable()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v6

    invoke-virtual {v6, p2}, Lcom/xfinity/playerlib/model/MerlinId;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 238
    invoke-interface {v4}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getVideos()Ljava/util/Set;

    move-result-object v6

    invoke-interface {v6}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v6

    :cond_1
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_0

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    .line 239
    .local v3, "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    if-eqz p3, :cond_2

    invoke-virtual {p3}, Ljava/lang/Long;->longValue()J

    move-result-wide v8

    const-wide/16 v10, 0x0

    cmp-long v7, v8, v10

    if-lez v7, :cond_2

    .line 240
    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getNetworkInfo()Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    move-result-object v7

    invoke-virtual {v7}, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->getCompanyId()J

    move-result-wide v8

    invoke-virtual {p3}, Ljava/lang/Long;->longValue()J

    move-result-wide v10

    cmp-long v7, v8, v10

    if-nez v7, :cond_1

    .line 252
    .end local v0    # "file":Lcom/comcast/cim/downloads/DownloadFile;
    .end local v2    # "playerFile":Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    .end local v3    # "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .end local v4    # "watchable":Lcom/xfinity/playerlib/model/consumable/Watchable;
    :cond_2
    :goto_0
    return-object v2

    :cond_3
    const/4 v2, 0x0

    goto :goto_0
.end method

.method public findFileWithVideoId(J)Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    .locals 7
    .param p1, "videoId"    # J

    .prologue
    .line 219
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->getFilesList()Ljava/util/List;

    move-result-object v1

    .line 220
    .local v1, "files":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;>;"
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/downloads/DownloadFile;

    .local v0, "file":Lcom/comcast/cim/downloads/DownloadFile;
    move-object v2, v0

    .line 221
    check-cast v2, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    .line 222
    .local v2, "playerFile":Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getVideoId()J

    move-result-wide v4

    cmp-long v4, v4, p1

    if-nez v4, :cond_0

    .line 227
    .end local v0    # "file":Lcom/comcast/cim/downloads/DownloadFile;
    .end local v2    # "playerFile":Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    :goto_0
    return-object v2

    :cond_1
    const/4 v2, 0x0

    goto :goto_0
.end method

.method public getStoredEntity(Ljava/util/UUID;)Lcom/comcast/cim/cmasl/utils/container/Either;
    .locals 1
    .param p1, "key"    # Ljava/util/UUID;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/UUID;",
            ")",
            "Lcom/comcast/cim/cmasl/utils/container/Either",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;",
            ">;"
        }
    .end annotation

    .prologue
    .line 215
    iget-object v0, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->entityCache:Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;

    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;->retrieve(Ljava/util/UUID;)Lcom/comcast/cim/cmasl/utils/container/Either;

    move-result-object v0

    return-object v0
.end method

.method public initiateTemporaryPause()V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/downloads/DownloadServiceException;
        }
    .end annotation

    .prologue
    .line 130
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->getDownloadEngineStatus()Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;

    move-result-object v1

    invoke-interface {v1}, Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;->status()Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    move-result-object v1

    sget-object v2, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Paused:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    if-eq v1, v2, :cond_0

    .line 131
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->getDownloadEngineStatus()Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;

    move-result-object v1

    invoke-interface {v1}, Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;->status()Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    move-result-object v1

    sget-object v2, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Idle:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    if-eq v1, v2, :cond_0

    .line 132
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->pauseDownloading()V

    .line 133
    iget-object v1, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->sharedPreferences:Landroid/content/SharedPreferences;

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 134
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v1, "DownloadsTemporarilyPaused"

    const/4 v2, 0x1

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 135
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 137
    .end local v0    # "editor":Landroid/content/SharedPreferences$Editor;
    :cond_0
    return-void
.end method

.method public isTemporarilyPaused()Z
    .locals 3

    .prologue
    .line 140
    iget-object v0, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->sharedPreferences:Landroid/content/SharedPreferences;

    const-string v1, "DownloadsTemporarilyPaused"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method protected bridge synthetic onFileDeleted(Lcom/comcast/cim/downloads/DownloadFile;)V
    .locals 0

    .prologue
    .line 39
    check-cast p1, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->onFileDeleted(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V

    return-void
.end method

.method protected onFileDeleted(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V
    .locals 2
    .param p1, "file"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    .prologue
    .line 122
    iget-object v0, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->entityCache:Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getUuid()Ljava/util/UUID;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;->remove(Ljava/util/UUID;)V

    .line 123
    invoke-super {p0, p1}, Lcom/comcast/cim/downloads/DownloadServiceManager;->onFileDeleted(Lcom/comcast/cim/downloads/DownloadFile;)V

    .line 124
    return-void
.end method

.method protected bridge synthetic onFileDownloadFinished(Lcom/comcast/cim/downloads/DownloadFile;)V
    .locals 0

    .prologue
    .line 39
    check-cast p1, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->onFileDownloadFinished(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V

    return-void
.end method

.method protected onFileDownloadFinished(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V
    .locals 2
    .param p1, "file"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    .prologue
    .line 116
    invoke-super {p0, p1}, Lcom/comcast/cim/downloads/DownloadServiceManager;->onFileDownloadFinished(Lcom/comcast/cim/downloads/DownloadFile;)V

    .line 117
    iget-object v0, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->trackingService:Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getVideo()Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->trackDownloadSuccess(Lcom/xfinity/playerlib/model/consumable/VideoFacade;)V

    .line 118
    return-void
.end method

.method public bridge synthetic onUserChanged(Lcom/comcast/cim/model/user/User;Lcom/comcast/cim/model/user/service/UserSettings;)V
    .locals 0

    .prologue
    .line 39
    check-cast p1, Lcom/xfinity/playerlib/model/user/PlayNowUser;

    check-cast p2, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    invoke-virtual {p0, p1, p2}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->onUserChanged(Lcom/xfinity/playerlib/model/user/PlayNowUser;Lcom/xfinity/playerlib/model/user/PlayerUserSettings;)V

    return-void
.end method

.method public onUserChanged(Lcom/xfinity/playerlib/model/user/PlayNowUser;Lcom/xfinity/playerlib/model/user/PlayerUserSettings;)V
    .locals 4
    .param p1, "newUser"    # Lcom/xfinity/playerlib/model/user/PlayNowUser;
    .param p2, "settings"    # Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    .prologue
    .line 71
    sget-object v1, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->LOG:Lorg/slf4j/Logger;

    const-string v2, "New user {} logged in, deleting previous user\'s content"

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/user/PlayNowUser;->getUserName()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Lorg/slf4j/Logger;->warn(Ljava/lang/String;Ljava/lang/Object;)V

    .line 73
    :try_start_0
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->deleteAllContent()Ljava/util/Map;
    :try_end_0
    .catch Lcom/comcast/cim/downloads/DownloadServiceException; {:try_start_0 .. :try_end_0} :catch_0

    .line 78
    :goto_0
    invoke-super {p0, p1, p2}, Lcom/comcast/cim/downloads/DownloadServiceManager;->onUserChanged(Lcom/comcast/cim/model/user/User;Lcom/comcast/cim/model/user/service/UserSettings;)V

    .line 79
    return-void

    .line 74
    :catch_0
    move-exception v0

    .line 75
    .local v0, "e":Lcom/comcast/cim/downloads/DownloadServiceException;
    sget-object v1, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->LOG:Lorg/slf4j/Logger;

    const-string v2, "Caught exception attempting to delete content on user change"

    invoke-interface {v1, v2, v0}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public bridge synthetic onUserLoaded(Lcom/comcast/cim/model/user/User;Lcom/comcast/cim/model/user/service/UserSettings;)V
    .locals 0

    .prologue
    .line 39
    check-cast p1, Lcom/xfinity/playerlib/model/user/PlayNowUser;

    check-cast p2, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    invoke-virtual {p0, p1, p2}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->onUserLoaded(Lcom/xfinity/playerlib/model/user/PlayNowUser;Lcom/xfinity/playerlib/model/user/PlayerUserSettings;)V

    return-void
.end method

.method public onUserLoaded(Lcom/xfinity/playerlib/model/user/PlayNowUser;Lcom/xfinity/playerlib/model/user/PlayerUserSettings;)V
    .locals 3
    .param p1, "newUser"    # Lcom/xfinity/playerlib/model/user/PlayNowUser;
    .param p2, "settings"    # Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    .prologue
    .line 65
    sget-object v0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->LOG:Lorg/slf4j/Logger;

    const-string v1, "onUserLoaded {}"

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/user/PlayNowUser;->getUserName()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;Ljava/lang/Object;)V

    .line 66
    invoke-super {p0, p1, p2}, Lcom/comcast/cim/downloads/DownloadServiceManager;->onUserLoaded(Lcom/comcast/cim/model/user/User;Lcom/comcast/cim/model/user/service/UserSettings;)V

    .line 67
    return-void
.end method

.method public bridge synthetic onUserLoggedIn(Lcom/comcast/cim/model/user/User;Lcom/comcast/cim/model/user/service/UserSettings;)V
    .locals 0

    .prologue
    .line 39
    check-cast p1, Lcom/xfinity/playerlib/model/user/PlayNowUser;

    check-cast p2, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    invoke-virtual {p0, p1, p2}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->onUserLoggedIn(Lcom/xfinity/playerlib/model/user/PlayNowUser;Lcom/xfinity/playerlib/model/user/PlayerUserSettings;)V

    return-void
.end method

.method public onUserLoggedIn(Lcom/xfinity/playerlib/model/user/PlayNowUser;Lcom/xfinity/playerlib/model/user/PlayerUserSettings;)V
    .locals 4
    .param p1, "user"    # Lcom/xfinity/playerlib/model/user/PlayNowUser;
    .param p2, "settings"    # Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    .prologue
    .line 83
    sget-object v1, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->LOG:Lorg/slf4j/Logger;

    const-string v2, "onUserLoggedIn {}"

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/user/PlayNowUser;->getUserName()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;Ljava/lang/Object;)V

    .line 84
    invoke-direct {p0, p2}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->setCellularDataQuotaForCurrentUser(Lcom/xfinity/playerlib/model/user/PlayerUserSettings;)V

    .line 85
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->triggerMediaLicenseRenewal()V

    .line 86
    iget-object v1, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->sharedPreferences:Landroid/content/SharedPreferences;

    const-string v2, "DownloadsTemporarilyPaused"

    const/4 v3, 0x0

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 89
    :try_start_0
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->resumeDownloading()V
    :try_end_0
    .catch Lcom/comcast/cim/downloads/DownloadServiceException; {:try_start_0 .. :try_end_0} :catch_0

    .line 94
    :cond_0
    :goto_0
    invoke-super {p0, p1, p2}, Lcom/comcast/cim/downloads/DownloadServiceManager;->onUserLoggedIn(Lcom/comcast/cim/model/user/User;Lcom/comcast/cim/model/user/service/UserSettings;)V

    .line 95
    return-void

    .line 90
    :catch_0
    move-exception v0

    .line 91
    .local v0, "e":Lcom/comcast/cim/downloads/DownloadServiceException;
    sget-object v1, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->LOG:Lorg/slf4j/Logger;

    const-string v2, "Caught exception attempting to un-pause downloads"

    invoke-interface {v1, v2, v0}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public onUserLoggedOut()V
    .locals 0

    .prologue
    .line 111
    invoke-super {p0}, Lcom/comcast/cim/downloads/DownloadServiceManager;->onUserLoggedOut()V

    .line 112
    return-void
.end method

.method public resumeDownloading()V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/downloads/DownloadServiceException;
        }
    .end annotation

    .prologue
    .line 145
    invoke-super {p0}, Lcom/comcast/cim/downloads/DownloadServiceManager;->resumeDownloading()V

    .line 149
    iget-object v1, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->sharedPreferences:Landroid/content/SharedPreferences;

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 150
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v1, "DownloadsTemporarilyPaused"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 151
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 152
    return-void
.end method

.method public triggerMediaLicenseRenewal()V
    .locals 2

    .prologue
    .line 155
    iget-object v0, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->context:Landroid/content/Context;

    iget-object v1, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->context:Landroid/content/Context;

    invoke-static {v1}, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalService;->createIntent(Landroid/content/Context;)Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Context;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 156
    return-void
.end method

.method public updateFile(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V
    .locals 5
    .param p1, "file"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/downloads/DownloadServiceException;
        }
    .end annotation

    .prologue
    .line 261
    iget-object v2, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->watchableCodec:Lcom/xfinity/playerlib/model/consumable/WatchableCodec;

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getWatchable()Lcom/xfinity/playerlib/model/consumable/Watchable;

    move-result-object v3

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getVideo()Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lcom/xfinity/playerlib/model/consumable/WatchableCodec;->encode(Lcom/xfinity/playerlib/model/consumable/Watchable;Lcom/xfinity/playerlib/model/consumable/VideoFacade;)Lcom/xfinity/playerlib/model/consumable/EncodedWatchable;

    move-result-object v1

    .line 262
    .local v1, "encodedWatchable":Lcom/xfinity/playerlib/model/consumable/EncodedWatchable;
    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/EncodedWatchable;->getBackingEntity()Lcom/comcast/cim/cmasl/utils/container/Either;

    move-result-object v0

    .line 263
    .local v0, "backingEntity":Lcom/comcast/cim/cmasl/utils/container/Either;, "Lcom/comcast/cim/cmasl/utils/container/Either<Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;>;"
    iget-object v2, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->entityCache:Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getUuid()Ljava/util/UUID;

    move-result-object v3

    invoke-virtual {v2, v3, v0}, Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;->store(Ljava/util/UUID;Lcom/comcast/cim/cmasl/utils/container/Either;)V

    .line 264
    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->updateFileMetadata(Lcom/comcast/cim/downloads/DownloadFile;)V

    .line 265
    return-void
.end method
