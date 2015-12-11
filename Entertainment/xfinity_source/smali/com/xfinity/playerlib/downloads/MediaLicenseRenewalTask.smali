.class public Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;
.super Ljava/lang/Object;
.source "MediaLicenseRenewalTask.java"

# interfaces
.implements Ljava/lang/Runnable;


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private final applicationContext:Landroid/app/Application;

.field private final cimAssetFactory:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/CimAssetFactory;

.field private final downloadsManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

.field private final entitlementCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            ">;"
        }
    .end annotation
.end field

.field private final httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

.field private final internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

.field private final mediaLicenseClient:Lcom/xfinity/playerlib/downloads/MediaLicenseClient;

.field private final playerConfigUtil:Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;

.field private final scheduler:Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler;

.field private final titaniumTicketClient:Lcom/xfinity/playerlib/downloads/TitaniumTicketClient;

.field private final uiThreadExecutor:Ljava/util/concurrent/Executor;

.field private final userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

.field private final watchableClient:Lcom/xfinity/playerlib/model/consumable/WatchableClient;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 43
    const-class v0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;Lcom/xfinity/playerlib/model/user/PlayNowUserManager;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/xfinity/playerlib/downloads/TitaniumTicketClient;Lcom/xfinity/playerlib/downloads/MediaLicenseClient;Lcom/xfinity/playerlib/model/consumable/WatchableClient;Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler;Landroid/app/Application;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;Lcom/xfinity/playerlib/model/videoplay/adobeplayer/CimAssetFactory;Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;Ljava/util/concurrent/Executor;)V
    .locals 0
    .param p1, "internetConnection"    # Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;
    .param p2, "downloadsManager"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;
    .param p3, "userManager"    # Lcom/xfinity/playerlib/model/user/PlayNowUserManager;
    .param p5, "titaniumTicketClient"    # Lcom/xfinity/playerlib/downloads/TitaniumTicketClient;
    .param p6, "mediaLicenseClient"    # Lcom/xfinity/playerlib/downloads/MediaLicenseClient;
    .param p7, "watchableClient"    # Lcom/xfinity/playerlib/model/consumable/WatchableClient;
    .param p8, "scheduler"    # Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler;
    .param p9, "applicationContext"    # Landroid/app/Application;
    .param p10, "httpClient"    # Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;
    .param p11, "cimAssetFactory"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/CimAssetFactory;
    .param p12, "playerConfigUtil"    # Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;
    .param p13, "uiThreadExecutor"    # Ljava/util/concurrent/Executor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;",
            "Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;",
            "Lcom/xfinity/playerlib/model/user/PlayNowUserManager;",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            ">;",
            "Lcom/xfinity/playerlib/downloads/TitaniumTicketClient;",
            "Lcom/xfinity/playerlib/downloads/MediaLicenseClient;",
            "Lcom/xfinity/playerlib/model/consumable/WatchableClient;",
            "Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler;",
            "Landroid/app/Application;",
            "Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;",
            "Lcom/xfinity/playerlib/model/videoplay/adobeplayer/CimAssetFactory;",
            "Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;",
            "Ljava/util/concurrent/Executor;",
            ")V"
        }
    .end annotation

    .prologue
    .line 71
    .local p4, "entitlementCache":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 73
    iput-object p1, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    .line 74
    iput-object p2, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->downloadsManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    .line 75
    iput-object p3, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    .line 76
    iput-object p4, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->entitlementCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 77
    iput-object p5, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->titaniumTicketClient:Lcom/xfinity/playerlib/downloads/TitaniumTicketClient;

    .line 78
    iput-object p6, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->mediaLicenseClient:Lcom/xfinity/playerlib/downloads/MediaLicenseClient;

    .line 79
    iput-object p7, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->watchableClient:Lcom/xfinity/playerlib/model/consumable/WatchableClient;

    .line 80
    iput-object p8, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->scheduler:Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler;

    .line 81
    iput-object p9, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->applicationContext:Landroid/app/Application;

    .line 82
    iput-object p10, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    .line 83
    iput-object p11, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->cimAssetFactory:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/CimAssetFactory;

    .line 84
    iput-object p12, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->playerConfigUtil:Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;

    .line 85
    iput-object p13, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->uiThreadExecutor:Ljava/util/concurrent/Executor;

    .line 86
    return-void
.end method

.method static synthetic access$000(Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;)Landroid/app/Application;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;

    .prologue
    .line 42
    iget-object v0, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->applicationContext:Landroid/app/Application;

    return-object v0
.end method

.method static synthetic access$100(Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;)Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;

    .prologue
    .line 42
    iget-object v0, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    return-object v0
.end method

.method private handleDeviceNotRegistered(Lcom/xfinity/playerlib/model/user/PlayNowUser;Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;)V
    .locals 5
    .param p1, "user"    # Lcom/xfinity/playerlib/model/user/PlayNowUser;
    .param p2, "exception"    # Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;

    .prologue
    .line 285
    sget-object v3, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->LOG:Lorg/slf4j/Logger;

    const-string v4, "Device is not registered, wiping all content"

    invoke-interface {v3, v4, p2}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 287
    :try_start_0
    iget-object v3, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->downloadsManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->deleteAllContent()Ljava/util/Map;

    move-result-object v3

    invoke-direct {p0, v3}, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->waitForPendingDeletes(Ljava/util/Map;)V
    :try_end_0
    .catch Lcom/comcast/cim/downloads/DownloadServiceException; {:try_start_0 .. :try_end_0} :catch_0

    .line 291
    :goto_0
    iget-object v3, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    .line 292
    .local v2, "userSettings":Lcom/xfinity/playerlib/model/user/PlayerUserSettings;
    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->setDeviceRegistration(Lcom/xfinity/playerlib/downloads/DeviceRegistration;)V

    .line 294
    :try_start_1
    iget-object v3, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {v3, p1, v2}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->saveUser(Lcom/comcast/cim/model/user/User;Lcom/comcast/cim/model/user/service/UserSettings;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    .line 298
    :goto_1
    return-void

    .line 288
    .end local v2    # "userSettings":Lcom/xfinity/playerlib/model/user/PlayerUserSettings;
    :catch_0
    move-exception v0

    .line 289
    .local v0, "de":Lcom/comcast/cim/downloads/DownloadServiceException;
    sget-object v3, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->LOG:Lorg/slf4j/Logger;

    const-string v4, "Caught exception trying to delete all content"

    invoke-interface {v3, v4, v0}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 295
    .end local v0    # "de":Lcom/comcast/cim/downloads/DownloadServiceException;
    .restart local v2    # "userSettings":Lcom/xfinity/playerlib/model/user/PlayerUserSettings;
    :catch_1
    move-exception v1

    .line 296
    .local v1, "ue":Ljava/lang/Exception;
    sget-object v3, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->LOG:Lorg/slf4j/Logger;

    const-string v4, "Caught exception trying to clear saved device registration"

    invoke-interface {v3, v4, v1}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_1
.end method

.method private handleNotEntitled(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;)V
    .locals 3
    .param p1, "file"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    .param p2, "exception"    # Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;

    .prologue
    .line 276
    sget-object v1, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->LOG:Lorg/slf4j/Logger;

    const-string v2, "Caught entitlement exception trying to renew license, attempting to delete file"

    invoke-interface {v1, v2, p2}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 278
    :try_start_0
    iget-object v1, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->downloadsManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    invoke-virtual {v1, p1}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->deleteFile(Lcom/comcast/cim/downloads/DownloadFile;)Ljava/util/Map;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->waitForPendingDeletes(Ljava/util/Map;)V
    :try_end_0
    .catch Lcom/comcast/cim/downloads/DownloadServiceException; {:try_start_0 .. :try_end_0} :catch_0

    .line 282
    :goto_0
    return-void

    .line 279
    :catch_0
    move-exception v0

    .line 280
    .local v0, "de":Lcom/comcast/cim/downloads/DownloadServiceException;
    sget-object v1, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->LOG:Lorg/slf4j/Logger;

    const-string v2, "Caught exception trying to delete file"

    invoke-interface {v1, v2, v0}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method private waitForPendingDeletes(Ljava/util/Map;)V
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;",
            "Ljava/util/concurrent/CountDownLatch;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 301
    .local p1, "latchMap":Ljava/util/Map;, "Ljava/util/Map<Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;Ljava/util/concurrent/CountDownLatch;>;"
    invoke-interface {p1}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_1

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 302
    .local v0, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;Ljava/util/concurrent/CountDownLatch;>;"
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    .line 303
    .local v1, "file":Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/concurrent/CountDownLatch;

    .line 304
    .local v2, "latch":Ljava/util/concurrent/CountDownLatch;
    const/4 v3, 0x0

    .line 306
    .local v3, "success":Z
    const-wide/16 v6, 0x4e20

    :try_start_0
    sget-object v5, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v2, v6, v7, v5}, Ljava/util/concurrent/CountDownLatch;->await(JLjava/util/concurrent/TimeUnit;)Z
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v3

    .line 309
    :goto_0
    if-nez v3, :cond_0

    .line 310
    sget-object v4, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->LOG:Lorg/slf4j/Logger;

    const-string v5, "Timeout waiting for {} to be deleted"

    invoke-interface {v4, v5, v1}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Object;)V

    .line 314
    .end local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;Ljava/util/concurrent/CountDownLatch;>;"
    .end local v1    # "file":Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    .end local v2    # "latch":Ljava/util/concurrent/CountDownLatch;
    .end local v3    # "success":Z
    :cond_1
    return-void

    .line 307
    .restart local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;Ljava/util/concurrent/CountDownLatch;>;"
    .restart local v1    # "file":Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    .restart local v2    # "latch":Ljava/util/concurrent/CountDownLatch;
    .restart local v3    # "success":Z
    :catch_0
    move-exception v5

    goto :goto_0
.end method


# virtual methods
.method public run()V
    .locals 30

    .prologue
    .line 90
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    move-object/from16 v25, v0

    invoke-virtual/range {v25 .. v25}, Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;->isConnected()Z

    move-result v25

    if-nez v25, :cond_0

    .line 91
    sget-object v25, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->LOG:Lorg/slf4j/Logger;

    const-string v26, "No internet connection"

    invoke-interface/range {v25 .. v26}, Lorg/slf4j/Logger;->warn(Ljava/lang/String;)V

    .line 92
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->scheduler:Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler;

    move-object/from16 v25, v0

    invoke-virtual/range {v25 .. v25}, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler;->runWhenConnectionIsAvailable()V

    .line 273
    :goto_0
    return-void

    .line 96
    :cond_0
    const-wide/32 v12, 0x5265c00

    .line 98
    .local v12, "nextRunInterval":J
    :try_start_0
    sget-object v25, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->LOG:Lorg/slf4j/Logger;

    const-string v26, "Starting license renewal task"

    invoke-interface/range {v25 .. v26}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 99
    new-instance v14, Ljava/util/Date;

    invoke-direct {v14}, Ljava/util/Date;-><init>()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 102
    .local v14, "now":Ljava/util/Date;
    :try_start_1
    sget-object v25, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->LOG:Lorg/slf4j/Logger;

    const-string v26, "Waiting for download manager initialization"

    invoke-interface/range {v25 .. v26}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 103
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->downloadsManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    move-object/from16 v25, v0

    const-wide/16 v26, 0x1388

    invoke-virtual/range {v25 .. v27}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->waitForInitialization(J)V
    :try_end_1
    .catch Lcom/comcast/cim/downloads/DownloadServiceException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 110
    :try_start_2
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->downloadsManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    move-object/from16 v25, v0

    invoke-virtual/range {v25 .. v25}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->getFilesList()Ljava/util/List;

    move-result-object v4

    .line 111
    .local v4, "allFiles":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;>;"
    invoke-interface {v4}, Ljava/util/List;->isEmpty()Z
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    move-result v25

    if-eqz v25, :cond_1

    .line 270
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->scheduler:Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler;

    move-object/from16 v25, v0

    move-object/from16 v0, v25

    invoke-virtual {v0, v12, v13}, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler;->runAtInterval(J)V

    goto :goto_0

    .line 104
    .end local v4    # "allFiles":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;>;"
    :catch_0
    move-exception v8

    .line 105
    .local v8, "e":Lcom/comcast/cim/downloads/DownloadServiceException;
    :try_start_3
    sget-object v25, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->LOG:Lorg/slf4j/Logger;

    const-string v26, "Wait for download manager initialization failed, aborting renewal"

    move-object/from16 v0, v25

    move-object/from16 v1, v26

    invoke-interface {v0, v1, v8}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 106
    const-wide/32 v12, 0x1b7740

    .line 270
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->scheduler:Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler;

    move-object/from16 v25, v0

    move-object/from16 v0, v25

    invoke-virtual {v0, v12, v13}, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler;->runAtInterval(J)V

    goto :goto_0

    .line 113
    .end local v8    # "e":Lcom/comcast/cim/downloads/DownloadServiceException;
    .restart local v4    # "allFiles":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;>;"
    :cond_1
    :try_start_4
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-object/from16 v25, v0

    invoke-virtual/range {v25 .. v25}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUser()Lcom/comcast/cim/model/user/User;

    move-result-object v22

    check-cast v22, Lcom/xfinity/playerlib/model/user/PlayNowUser;

    .line 114
    .local v22, "user":Lcom/xfinity/playerlib/model/user/PlayNowUser;
    if-nez v22, :cond_2

    .line 115
    sget-object v25, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->LOG:Lorg/slf4j/Logger;

    const-string v26, "No user currently signed in, skipping license renewal"

    invoke-interface/range {v25 .. v26}, Lorg/slf4j/Logger;->warn(Ljava/lang/String;)V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 270
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->scheduler:Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler;

    move-object/from16 v25, v0

    move-object/from16 v0, v25

    invoke-virtual {v0, v12, v13}, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler;->runAtInterval(J)V

    goto :goto_0

    .line 118
    :cond_2
    :try_start_5
    sget-object v25, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->LOG:Lorg/slf4j/Logger;

    const-string v26, "Renewing licenses for user {}"

    invoke-virtual/range {v22 .. v22}, Lcom/xfinity/playerlib/model/user/PlayNowUser;->getUserName()Ljava/lang/String;

    move-result-object v27

    invoke-interface/range {v25 .. v27}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;Ljava/lang/Object;)V

    .line 120
    invoke-virtual/range {v22 .. v22}, Lcom/xfinity/playerlib/model/user/PlayNowUser;->getAuthKeys()Lcom/comcast/cim/model/user/AuthKeys;
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    move-result-object v6

    .line 121
    .local v6, "authKeys":Lcom/comcast/cim/model/user/AuthKeys;
    const/4 v9, 0x0

    .line 123
    .local v9, "entitlement":Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    :try_start_6
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->entitlementCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-object/from16 v25, v0

    invoke-interface/range {v25 .. v25}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->execute()Ljava/lang/Object;

    move-result-object v25

    move-object/from16 v0, v25

    check-cast v0, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    move-object v9, v0
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_1
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    .line 130
    :goto_1
    const/4 v15, 0x0

    .line 131
    .local v15, "platformAPI":Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;
    :try_start_7
    invoke-static {}, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->getInstance()Lcom/comcast/playerplatform/util/android/ConfigurationManager;

    move-result-object v25

    invoke-virtual/range {v25 .. v25}, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->isReady()Z
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    move-result v25

    if-nez v25, :cond_3

    .line 133
    :try_start_8
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->playerConfigUtil:Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;

    move-object/from16 v25, v0

    const-wide/16 v26, 0x5

    invoke-virtual/range {v25 .. v27}, Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;->configureSynchronous(J)V
    :try_end_8
    .catch Lcom/comcast/cim/cmasl/utils/exceptions/CimException; {:try_start_8 .. :try_end_8} :catch_2
    .catchall {:try_start_8 .. :try_end_8} :catchall_0

    .line 140
    :cond_3
    :goto_2
    :try_start_9
    invoke-static {}, Lcom/google/common/util/concurrent/SettableFuture;->create()Lcom/google/common/util/concurrent/SettableFuture;

    move-result-object v16

    .line 141
    .local v16, "platformAPIFuture":Lcom/google/common/util/concurrent/SettableFuture;, "Lcom/google/common/util/concurrent/SettableFuture<Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;>;"
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->uiThreadExecutor:Ljava/util/concurrent/Executor;

    move-object/from16 v25, v0

    new-instance v26, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask$1;

    move-object/from16 v0, v26

    move-object/from16 v1, p0

    move-object/from16 v2, v16

    invoke-direct {v0, v1, v2}, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask$1;-><init>(Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;Lcom/google/common/util/concurrent/SettableFuture;)V

    invoke-interface/range {v25 .. v26}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_0

    .line 149
    const-wide/16 v26, 0x5

    :try_start_a
    sget-object v25, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    move-object/from16 v0, v16

    move-wide/from16 v1, v26

    move-object/from16 v3, v25

    invoke-virtual {v0, v1, v2, v3}, Lcom/google/common/util/concurrent/SettableFuture;->get(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;

    move-result-object v25

    move-object/from16 v0, v25

    check-cast v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    move-object v15, v0
    :try_end_a
    .catch Ljava/lang/Exception; {:try_start_a .. :try_end_a} :catch_3
    .catchall {:try_start_a .. :try_end_a} :catchall_0

    .line 156
    :goto_3
    :try_start_b
    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v25

    :goto_4
    invoke-interface/range {v25 .. v25}, Ljava/util/Iterator;->hasNext()Z

    move-result v26

    if-eqz v26, :cond_a

    invoke-interface/range {v25 .. v25}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    .line 159
    .local v10, "file":Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    invoke-virtual {v10}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getAsset()Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    move-result-object v26

    invoke-interface/range {v26 .. v26}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->downloadStatus()Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    move-result-object v26

    sget-object v27, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kvDE_Expired:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    if-ne v0, v1, :cond_4

    .line 160
    sget-object v26, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->LOG:Lorg/slf4j/Logger;

    const-string v27, "{} is expired, skipping"

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-interface {v0, v1, v10}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;Ljava/lang/Object;)V
    :try_end_b
    .catchall {:try_start_b .. :try_end_b} :catchall_0

    goto :goto_4

    .line 270
    .end local v4    # "allFiles":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;>;"
    .end local v6    # "authKeys":Lcom/comcast/cim/model/user/AuthKeys;
    .end local v9    # "entitlement":Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    .end local v10    # "file":Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    .end local v14    # "now":Ljava/util/Date;
    .end local v15    # "platformAPI":Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;
    .end local v16    # "platformAPIFuture":Lcom/google/common/util/concurrent/SettableFuture;, "Lcom/google/common/util/concurrent/SettableFuture<Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;>;"
    .end local v22    # "user":Lcom/xfinity/playerlib/model/user/PlayNowUser;
    :catchall_0
    move-exception v25

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->scheduler:Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler;

    move-object/from16 v26, v0

    move-object/from16 v0, v26

    invoke-virtual {v0, v12, v13}, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler;->runAtInterval(J)V

    throw v25

    .line 124
    .restart local v4    # "allFiles":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;>;"
    .restart local v6    # "authKeys":Lcom/comcast/cim/model/user/AuthKeys;
    .restart local v9    # "entitlement":Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    .restart local v14    # "now":Ljava/util/Date;
    .restart local v22    # "user":Lcom/xfinity/playerlib/model/user/PlayNowUser;
    :catch_1
    move-exception v8

    .line 125
    .local v8, "e":Ljava/lang/Exception;
    :try_start_c
    sget-object v25, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->LOG:Lorg/slf4j/Logger;

    const-string v26, "Caught exception trying to fetch user entitlement"

    move-object/from16 v0, v25

    move-object/from16 v1, v26

    invoke-interface {v0, v1, v8}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 126
    const-wide/32 v12, 0x1b7740

    goto/16 :goto_1

    .line 134
    .end local v8    # "e":Ljava/lang/Exception;
    .restart local v15    # "platformAPI":Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;
    :catch_2
    move-exception v8

    .line 135
    .local v8, "e":Lcom/comcast/cim/cmasl/utils/exceptions/CimException;
    sget-object v25, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->LOG:Lorg/slf4j/Logger;

    const-string v26, "Failed to Instantiate Media Player for License Renewal"

    move-object/from16 v0, v25

    move-object/from16 v1, v26

    invoke-interface {v0, v1, v8}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 136
    const-wide/32 v12, 0x1b7740

    goto/16 :goto_2

    .line 150
    .end local v8    # "e":Lcom/comcast/cim/cmasl/utils/exceptions/CimException;
    .restart local v16    # "platformAPIFuture":Lcom/google/common/util/concurrent/SettableFuture;, "Lcom/google/common/util/concurrent/SettableFuture<Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;>;"
    :catch_3
    move-exception v8

    .line 151
    .local v8, "e":Ljava/lang/Exception;
    sget-object v25, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->LOG:Lorg/slf4j/Logger;

    const-string v26, "Caught Exception trying to create PlayerPlatformAPI"

    move-object/from16 v0, v25

    move-object/from16 v1, v26

    invoke-interface {v0, v1, v8}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_c
    .catchall {:try_start_c .. :try_end_c} :catchall_0

    .line 152
    const-wide/32 v12, 0x1b7740

    goto :goto_3

    .line 165
    .end local v8    # "e":Ljava/lang/Exception;
    .restart local v10    # "file":Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    :cond_4
    :try_start_d
    invoke-virtual {v10}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getExpirationStatus()Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile$ExpirationStatus;

    move-result-object v26

    sget-object v27, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile$ExpirationStatus;->AAW_EXPIRED:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile$ExpirationStatus;

    invoke-virtual/range {v26 .. v27}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile$ExpirationStatus;->equals(Ljava/lang/Object;)Z

    move-result v26

    if-eqz v26, :cond_5

    .line 167
    sget-object v26, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->LOG:Lorg/slf4j/Logger;

    const-string v27, "File is AAW expired, expiring content"

    invoke-interface/range {v26 .. v27}, Lorg/slf4j/Logger;->info(Ljava/lang/String;)V
    :try_end_d
    .catchall {:try_start_d .. :try_end_d} :catchall_1

    .line 169
    :try_start_e
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->downloadsManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    move-object/from16 v26, v0

    move-object/from16 v0, v26

    invoke-virtual {v0, v10}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->expireFile(Lcom/comcast/cim/downloads/DownloadFile;)V
    :try_end_e
    .catch Lcom/comcast/cim/downloads/DownloadServiceException; {:try_start_e .. :try_end_e} :catch_5
    .catchall {:try_start_e .. :try_end_e} :catchall_1

    .line 262
    :goto_5
    :try_start_f
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->downloadsManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    move-object/from16 v26, v0

    move-object/from16 v0, v26

    invoke-virtual {v0, v10}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->updateFile(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V
    :try_end_f
    .catch Lcom/comcast/cim/downloads/DownloadServiceException; {:try_start_f .. :try_end_f} :catch_4
    .catchall {:try_start_f .. :try_end_f} :catchall_0

    goto/16 :goto_4

    .line 263
    :catch_4
    move-exception v8

    .line 264
    .local v8, "e":Lcom/comcast/cim/downloads/DownloadServiceException;
    const-wide/32 v12, 0x1b7740

    .line 265
    :try_start_10
    sget-object v26, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->LOG:Lorg/slf4j/Logger;

    const-string v27, "Caught exception while trying to update file, ignoring"

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-interface {v0, v1, v8}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_10
    .catchall {:try_start_10 .. :try_end_10} :catchall_0

    goto/16 :goto_4

    .line 170
    .end local v8    # "e":Lcom/comcast/cim/downloads/DownloadServiceException;
    :catch_5
    move-exception v8

    .line 171
    .restart local v8    # "e":Lcom/comcast/cim/downloads/DownloadServiceException;
    :try_start_11
    sget-object v26, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->LOG:Lorg/slf4j/Logger;

    const-string v27, "Caught exception trying to expire file"

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-interface {v0, v1, v8}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 172
    const-wide/32 v12, 0x1b7740

    goto :goto_5

    .line 177
    .end local v8    # "e":Lcom/comcast/cim/downloads/DownloadServiceException;
    :cond_5
    if-nez v9, :cond_6

    .line 178
    sget-object v26, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->LOG:Lorg/slf4j/Logger;

    const-string v27, "Skipping license renewal because we failed to get user entitlements"

    invoke-interface/range {v26 .. v27}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V
    :try_end_11
    .catchall {:try_start_11 .. :try_end_11} :catchall_1

    .line 262
    :try_start_12
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->downloadsManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    move-object/from16 v26, v0

    move-object/from16 v0, v26

    invoke-virtual {v0, v10}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->updateFile(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V
    :try_end_12
    .catch Lcom/comcast/cim/downloads/DownloadServiceException; {:try_start_12 .. :try_end_12} :catch_6
    .catchall {:try_start_12 .. :try_end_12} :catchall_0

    goto/16 :goto_4

    .line 263
    :catch_6
    move-exception v8

    .line 264
    .restart local v8    # "e":Lcom/comcast/cim/downloads/DownloadServiceException;
    const-wide/32 v12, 0x1b7740

    .line 265
    :try_start_13
    sget-object v26, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->LOG:Lorg/slf4j/Logger;

    const-string v27, "Caught exception while trying to update file, ignoring"

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-interface {v0, v1, v8}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_13
    .catchall {:try_start_13 .. :try_end_13} :catchall_0

    goto/16 :goto_4

    .line 182
    .end local v8    # "e":Lcom/comcast/cim/downloads/DownloadServiceException;
    :cond_6
    if-nez v15, :cond_7

    .line 183
    :try_start_14
    sget-object v26, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->LOG:Lorg/slf4j/Logger;

    const-string v27, "Skipping license renewal because we failed to get platform API"

    invoke-interface/range {v26 .. v27}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V
    :try_end_14
    .catchall {:try_start_14 .. :try_end_14} :catchall_1

    .line 262
    :try_start_15
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->downloadsManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    move-object/from16 v26, v0

    move-object/from16 v0, v26

    invoke-virtual {v0, v10}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->updateFile(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V
    :try_end_15
    .catch Lcom/comcast/cim/downloads/DownloadServiceException; {:try_start_15 .. :try_end_15} :catch_7
    .catchall {:try_start_15 .. :try_end_15} :catchall_0

    goto/16 :goto_4

    .line 263
    :catch_7
    move-exception v8

    .line 264
    .restart local v8    # "e":Lcom/comcast/cim/downloads/DownloadServiceException;
    const-wide/32 v12, 0x1b7740

    .line 265
    :try_start_16
    sget-object v26, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->LOG:Lorg/slf4j/Logger;

    const-string v27, "Caught exception while trying to update file, ignoring"

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-interface {v0, v1, v8}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_16
    .catchall {:try_start_16 .. :try_end_16} :catchall_0

    goto/16 :goto_4

    .line 187
    .end local v8    # "e":Lcom/comcast/cim/downloads/DownloadServiceException;
    :cond_7
    :try_start_17
    invoke-virtual {v14}, Ljava/util/Date;->getTime()J

    move-result-wide v26

    invoke-virtual {v10}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getLastLicenseRenewalDate()Ljava/util/Date;

    move-result-object v28

    invoke-virtual/range {v28 .. v28}, Ljava/util/Date;->getTime()J

    move-result-wide v28

    sub-long v18, v26, v28

    .line 188
    .local v18, "timeSinceRenewal":J
    invoke-virtual {v10}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getLicenseExpirationDate()Ljava/util/Date;

    move-result-object v26

    invoke-virtual/range {v26 .. v26}, Ljava/util/Date;->getTime()J

    move-result-wide v26

    invoke-virtual {v14}, Ljava/util/Date;->getTime()J

    move-result-wide v28

    sub-long v20, v26, v28

    .line 189
    .local v20, "timeTillExpiration":J
    const-wide/32 v26, 0x5265c00

    cmp-long v26, v18, v26

    if-gez v26, :cond_8

    const-wide/32 v26, 0x5265c00

    cmp-long v26, v20, v26

    if-lez v26, :cond_8

    .line 191
    sget-object v26, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->LOG:Lorg/slf4j/Logger;

    const-string v27, "{} has been renewed recently ({}), skipping"

    invoke-virtual {v10}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getLastLicenseRenewalDate()Ljava/util/Date;

    move-result-object v28

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    move-object/from16 v2, v28

    invoke-interface {v0, v1, v10, v2}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    :try_end_17
    .catchall {:try_start_17 .. :try_end_17} :catchall_1

    .line 262
    :try_start_18
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->downloadsManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    move-object/from16 v26, v0

    move-object/from16 v0, v26

    invoke-virtual {v0, v10}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->updateFile(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V
    :try_end_18
    .catch Lcom/comcast/cim/downloads/DownloadServiceException; {:try_start_18 .. :try_end_18} :catch_8
    .catchall {:try_start_18 .. :try_end_18} :catchall_0

    goto/16 :goto_4

    .line 263
    :catch_8
    move-exception v8

    .line 264
    .restart local v8    # "e":Lcom/comcast/cim/downloads/DownloadServiceException;
    const-wide/32 v12, 0x1b7740

    .line 265
    :try_start_19
    sget-object v26, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->LOG:Lorg/slf4j/Logger;

    const-string v27, "Caught exception while trying to update file, ignoring"

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-interface {v0, v1, v8}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_19
    .catchall {:try_start_19 .. :try_end_19} :catchall_0

    goto/16 :goto_4

    .line 196
    .end local v8    # "e":Lcom/comcast/cim/downloads/DownloadServiceException;
    :cond_8
    :try_start_1a
    sget-object v26, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->LOG:Lorg/slf4j/Logger;

    const-string v27, "Starting renewal for {}"

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-interface {v0, v1, v10}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;Ljava/lang/Object;)V

    .line 197
    sget-object v26, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->LOG:Lorg/slf4j/Logger;

    const-string v27, "Refreshing consumable data"

    invoke-interface/range {v26 .. v27}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 198
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->watchableClient:Lcom/xfinity/playerlib/model/consumable/WatchableClient;

    move-object/from16 v26, v0

    invoke-virtual {v10}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getWatchableKey()Lcom/xfinity/playerlib/model/consumable/WatchableKey;

    move-result-object v27

    invoke-virtual/range {v26 .. v27}, Lcom/xfinity/playerlib/model/consumable/WatchableClient;->fetchWatchable(Lcom/xfinity/playerlib/model/consumable/WatchableKey;)Lcom/xfinity/playerlib/model/consumable/Watchable;

    move-result-object v24

    .line 199
    .local v24, "watchable":Lcom/xfinity/playerlib/model/consumable/Watchable;
    move-object/from16 v0, v24

    invoke-virtual {v10, v0}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->downloadVideoExistsInWatchable(Lcom/xfinity/playerlib/model/consumable/Watchable;)Z

    move-result v26

    if-eqz v26, :cond_9

    .line 200
    move-object/from16 v0, v24

    invoke-virtual {v10, v0}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->setWatchable(Lcom/xfinity/playerlib/model/consumable/Watchable;)V

    .line 204
    :goto_6
    sget-object v26, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->LOG:Lorg/slf4j/Logger;

    const-string v27, "Consumable refresh complete"

    invoke-interface/range {v26 .. v27}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V
    :try_end_1a
    .catch Ljava/lang/Exception; {:try_start_1a .. :try_end_1a} :catch_a
    .catchall {:try_start_1a .. :try_end_1a} :catchall_1

    .line 211
    .end local v24    # "watchable":Lcom/xfinity/playerlib/model/consumable/Watchable;
    :goto_7
    :try_start_1b
    sget-object v26, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->LOG:Lorg/slf4j/Logger;

    const-string v27, "Fetching titanium ticket"

    invoke-interface/range {v26 .. v27}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 212
    invoke-virtual {v10}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getVideo()Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    :try_end_1b
    .catchall {:try_start_1b .. :try_end_1b} :catchall_1

    move-result-object v23

    .line 215
    .local v23, "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    :try_start_1c
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->titaniumTicketClient:Lcom/xfinity/playerlib/downloads/TitaniumTicketClient;

    move-object/from16 v26, v0

    invoke-virtual/range {v23 .. v23}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getDefaultDownloadProfile()Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;

    move-result-object v27

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-virtual {v0, v6, v9, v1}, Lcom/xfinity/playerlib/downloads/TitaniumTicketClient;->getTitaniumTicket(Lcom/comcast/cim/model/user/AuthKeys;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;)Lcom/xfinity/playerlib/downloads/TitaniumTicket;
    :try_end_1c
    .catch Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException; {:try_start_1c .. :try_end_1c} :catch_b
    .catch Lcom/comcast/cim/cmasl/http/exceptions/CimIOException; {:try_start_1c .. :try_end_1c} :catch_e
    .catchall {:try_start_1c .. :try_end_1c} :catchall_1

    move-result-object v17

    .line 240
    .local v17, "titaniumTicket":Lcom/xfinity/playerlib/downloads/TitaniumTicket;
    :try_start_1d
    sget-object v26, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->LOG:Lorg/slf4j/Logger;

    const-string v27, "Titanium ticket fetched"

    invoke-interface/range {v26 .. v27}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 242
    sget-object v26, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->LOG:Lorg/slf4j/Logger;

    const-string v27, "Renewing media license"

    invoke-interface/range {v26 .. v27}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V
    :try_end_1d
    .catchall {:try_start_1d .. :try_end_1d} :catchall_1

    .line 246
    :try_start_1e
    invoke-virtual {v10}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getPlaylistUri()Ljava/lang/String;

    move-result-object v5

    .line 248
    .local v5, "assetUri":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->cimAssetFactory:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/CimAssetFactory;

    move-object/from16 v26, v0

    sget-object v27, Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;->STREAMING:Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;

    move-object/from16 v0, v26

    move-object/from16 v1, v17

    move-object/from16 v2, v23

    move-object/from16 v3, v27

    invoke-virtual {v0, v5, v1, v2, v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/CimAssetFactory;->create(Ljava/lang/String;Lcom/xfinity/playerlib/downloads/TitaniumTicket;Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;)Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    move-result-object v7

    .line 249
    .local v7, "cimAsset":Lcom/comcast/playerplatform/primetime/android/asset/Asset;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->mediaLicenseClient:Lcom/xfinity/playerlib/downloads/MediaLicenseClient;

    move-object/from16 v26, v0

    move-object/from16 v0, v26

    invoke-virtual {v0, v15, v7}, Lcom/xfinity/playerlib/downloads/MediaLicenseClient;->getOrRefreshMediaLicense(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;Lcom/comcast/playerplatform/primetime/android/asset/Asset;)Ljava/util/Date;
    :try_end_1e
    .catch Lcom/comcast/cim/cmasl/utils/exceptions/CimException; {:try_start_1e .. :try_end_1e} :catch_10
    .catchall {:try_start_1e .. :try_end_1e} :catchall_1

    move-result-object v11

    .line 256
    .local v11, "licenseExpirationDate":Ljava/util/Date;
    :try_start_1f
    sget-object v26, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->LOG:Lorg/slf4j/Logger;

    const-string v27, "Media license renewed"

    invoke-interface/range {v26 .. v27}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 258
    invoke-virtual {v10, v11}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->setLicenseExpirationDate(Ljava/util/Date;)V

    .line 259
    invoke-virtual {v10, v14}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->setLastLicenseRenewalDate(Ljava/util/Date;)V
    :try_end_1f
    .catchall {:try_start_1f .. :try_end_1f} :catchall_1

    .line 262
    :try_start_20
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->downloadsManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    move-object/from16 v26, v0

    move-object/from16 v0, v26

    invoke-virtual {v0, v10}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->updateFile(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V
    :try_end_20
    .catch Lcom/comcast/cim/downloads/DownloadServiceException; {:try_start_20 .. :try_end_20} :catch_9
    .catchall {:try_start_20 .. :try_end_20} :catchall_0

    goto/16 :goto_4

    .line 263
    :catch_9
    move-exception v8

    .line 264
    .restart local v8    # "e":Lcom/comcast/cim/downloads/DownloadServiceException;
    const-wide/32 v12, 0x1b7740

    .line 265
    :try_start_21
    sget-object v26, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->LOG:Lorg/slf4j/Logger;

    const-string v27, "Caught exception while trying to update file, ignoring"

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-interface {v0, v1, v8}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_21
    .catchall {:try_start_21 .. :try_end_21} :catchall_0

    goto/16 :goto_4

    .line 202
    .end local v5    # "assetUri":Ljava/lang/String;
    .end local v7    # "cimAsset":Lcom/comcast/playerplatform/primetime/android/asset/Asset;
    .end local v8    # "e":Lcom/comcast/cim/downloads/DownloadServiceException;
    .end local v11    # "licenseExpirationDate":Ljava/util/Date;
    .end local v17    # "titaniumTicket":Lcom/xfinity/playerlib/downloads/TitaniumTicket;
    .end local v23    # "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .restart local v24    # "watchable":Lcom/xfinity/playerlib/model/consumable/Watchable;
    :cond_9
    :try_start_22
    sget-object v26, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->LOG:Lorg/slf4j/Logger;

    const-string v27, "Our consumable isn\'t in the most up to date watchable, keeping our cached version"

    invoke-interface/range {v26 .. v27}, Lorg/slf4j/Logger;->warn(Ljava/lang/String;)V
    :try_end_22
    .catch Ljava/lang/Exception; {:try_start_22 .. :try_end_22} :catch_a
    .catchall {:try_start_22 .. :try_end_22} :catchall_1

    goto/16 :goto_6

    .line 205
    .end local v24    # "watchable":Lcom/xfinity/playerlib/model/consumable/Watchable;
    :catch_a
    move-exception v8

    .line 206
    .local v8, "e":Ljava/lang/Exception;
    :try_start_23
    sget-object v26, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->LOG:Lorg/slf4j/Logger;

    const-string v27, "Caught exception while trying to refresh consumable, continuing with cached version"

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-interface {v0, v1, v8}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 207
    const-wide/32 v12, 0x1b7740

    goto/16 :goto_7

    .line 216
    .end local v8    # "e":Ljava/lang/Exception;
    .restart local v23    # "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    :catch_b
    move-exception v8

    .line 217
    .local v8, "e":Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;
    invoke-virtual {v8}, Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;->getDetailedStatusCode()I

    move-result v26

    sparse-switch v26, :sswitch_data_0

    .line 232
    throw v8
    :try_end_23
    .catchall {:try_start_23 .. :try_end_23} :catchall_1

    .line 261
    .end local v8    # "e":Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;
    .end local v18    # "timeSinceRenewal":J
    .end local v20    # "timeTillExpiration":J
    .end local v23    # "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    :catchall_1
    move-exception v25

    .line 262
    :try_start_24
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->downloadsManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    move-object/from16 v26, v0

    move-object/from16 v0, v26

    invoke-virtual {v0, v10}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->updateFile(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V
    :try_end_24
    .catch Lcom/comcast/cim/downloads/DownloadServiceException; {:try_start_24 .. :try_end_24} :catch_12
    .catchall {:try_start_24 .. :try_end_24} :catchall_0

    .line 266
    :goto_8
    :try_start_25
    throw v25
    :try_end_25
    .catchall {:try_start_25 .. :try_end_25} :catchall_0

    .line 223
    .restart local v8    # "e":Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;
    .restart local v18    # "timeSinceRenewal":J
    .restart local v20    # "timeTillExpiration":J
    .restart local v23    # "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    :sswitch_0
    :try_start_26
    move-object/from16 v0, p0

    invoke-direct {v0, v10, v8}, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->handleNotEntitled(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;)V
    :try_end_26
    .catchall {:try_start_26 .. :try_end_26} :catchall_1

    .line 262
    :try_start_27
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->downloadsManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    move-object/from16 v26, v0

    move-object/from16 v0, v26

    invoke-virtual {v0, v10}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->updateFile(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V
    :try_end_27
    .catch Lcom/comcast/cim/downloads/DownloadServiceException; {:try_start_27 .. :try_end_27} :catch_c
    .catchall {:try_start_27 .. :try_end_27} :catchall_0

    goto/16 :goto_4

    .line 263
    :catch_c
    move-exception v8

    .line 264
    .local v8, "e":Lcom/comcast/cim/downloads/DownloadServiceException;
    const-wide/32 v12, 0x1b7740

    .line 265
    :try_start_28
    sget-object v26, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->LOG:Lorg/slf4j/Logger;

    const-string v27, "Caught exception while trying to update file, ignoring"

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-interface {v0, v1, v8}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_28
    .catchall {:try_start_28 .. :try_end_28} :catchall_0

    goto/16 :goto_4

    .line 227
    .local v8, "e":Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;
    :sswitch_1
    :try_start_29
    move-object/from16 v0, p0

    move-object/from16 v1, v22

    invoke-direct {v0, v1, v8}, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->handleDeviceNotRegistered(Lcom/xfinity/playerlib/model/user/PlayNowUser;Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;)V

    .line 229
    sget-object v25, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->LOG:Lorg/slf4j/Logger;

    const-string v26, "Aborting remaining renewals"

    invoke-interface/range {v25 .. v26}, Lorg/slf4j/Logger;->error(Ljava/lang/String;)V
    :try_end_29
    .catchall {:try_start_29 .. :try_end_29} :catchall_1

    .line 262
    :try_start_2a
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->downloadsManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    move-object/from16 v25, v0

    move-object/from16 v0, v25

    invoke-virtual {v0, v10}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->updateFile(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V
    :try_end_2a
    .catch Lcom/comcast/cim/downloads/DownloadServiceException; {:try_start_2a .. :try_end_2a} :catch_d
    .catchall {:try_start_2a .. :try_end_2a} :catchall_0

    .line 270
    .end local v8    # "e":Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;
    .end local v10    # "file":Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    .end local v18    # "timeSinceRenewal":J
    .end local v20    # "timeTillExpiration":J
    .end local v23    # "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    :cond_a
    :goto_9
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->scheduler:Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler;

    move-object/from16 v25, v0

    move-object/from16 v0, v25

    invoke-virtual {v0, v12, v13}, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler;->runAtInterval(J)V

    .line 272
    sget-object v25, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->LOG:Lorg/slf4j/Logger;

    const-string v26, "License renewal task complete"

    invoke-interface/range {v25 .. v26}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 263
    .restart local v8    # "e":Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;
    .restart local v10    # "file":Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    .restart local v18    # "timeSinceRenewal":J
    .restart local v20    # "timeTillExpiration":J
    .restart local v23    # "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    :catch_d
    move-exception v8

    .line 264
    .local v8, "e":Lcom/comcast/cim/downloads/DownloadServiceException;
    const-wide/32 v12, 0x1b7740

    .line 265
    :try_start_2b
    sget-object v25, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->LOG:Lorg/slf4j/Logger;

    const-string v26, "Caught exception while trying to update file, ignoring"

    move-object/from16 v0, v25

    move-object/from16 v1, v26

    invoke-interface {v0, v1, v8}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_2b
    .catchall {:try_start_2b .. :try_end_2b} :catchall_0

    goto :goto_9

    .line 234
    .end local v8    # "e":Lcom/comcast/cim/downloads/DownloadServiceException;
    :catch_e
    move-exception v8

    .line 235
    .local v8, "e":Lcom/comcast/cim/cmasl/http/exceptions/CimIOException;
    :try_start_2c
    sget-object v26, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->LOG:Lorg/slf4j/Logger;

    const-string v27, "Caught IO exception fetching titanium ticket"

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-interface {v0, v1, v8}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_2c
    .catchall {:try_start_2c .. :try_end_2c} :catchall_1

    .line 237
    const-wide/32 v12, 0x1b7740

    .line 262
    :try_start_2d
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->downloadsManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    move-object/from16 v26, v0

    move-object/from16 v0, v26

    invoke-virtual {v0, v10}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->updateFile(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V
    :try_end_2d
    .catch Lcom/comcast/cim/downloads/DownloadServiceException; {:try_start_2d .. :try_end_2d} :catch_f
    .catchall {:try_start_2d .. :try_end_2d} :catchall_0

    goto/16 :goto_4

    .line 263
    :catch_f
    move-exception v8

    .line 264
    .local v8, "e":Lcom/comcast/cim/downloads/DownloadServiceException;
    const-wide/32 v12, 0x1b7740

    .line 265
    :try_start_2e
    sget-object v26, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->LOG:Lorg/slf4j/Logger;

    const-string v27, "Caught exception while trying to update file, ignoring"

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-interface {v0, v1, v8}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_2e
    .catchall {:try_start_2e .. :try_end_2e} :catchall_0

    goto/16 :goto_4

    .line 250
    .end local v8    # "e":Lcom/comcast/cim/downloads/DownloadServiceException;
    .restart local v17    # "titaniumTicket":Lcom/xfinity/playerlib/downloads/TitaniumTicket;
    :catch_10
    move-exception v8

    .line 251
    .local v8, "e":Lcom/comcast/cim/cmasl/utils/exceptions/CimException;
    :try_start_2f
    sget-object v26, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->LOG:Lorg/slf4j/Logger;

    const-string v27, "Caught exception refreshing media license, skipping file"

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-interface {v0, v1, v8}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_2f
    .catchall {:try_start_2f .. :try_end_2f} :catchall_1

    .line 253
    const-wide/32 v12, 0x1b7740

    .line 262
    :try_start_30
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->downloadsManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    move-object/from16 v26, v0

    move-object/from16 v0, v26

    invoke-virtual {v0, v10}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->updateFile(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V
    :try_end_30
    .catch Lcom/comcast/cim/downloads/DownloadServiceException; {:try_start_30 .. :try_end_30} :catch_11
    .catchall {:try_start_30 .. :try_end_30} :catchall_0

    goto/16 :goto_4

    .line 263
    :catch_11
    move-exception v8

    .line 264
    .local v8, "e":Lcom/comcast/cim/downloads/DownloadServiceException;
    const-wide/32 v12, 0x1b7740

    .line 265
    :try_start_31
    sget-object v26, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->LOG:Lorg/slf4j/Logger;

    const-string v27, "Caught exception while trying to update file, ignoring"

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-interface {v0, v1, v8}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto/16 :goto_4

    .line 263
    .end local v8    # "e":Lcom/comcast/cim/downloads/DownloadServiceException;
    .end local v17    # "titaniumTicket":Lcom/xfinity/playerlib/downloads/TitaniumTicket;
    .end local v18    # "timeSinceRenewal":J
    .end local v20    # "timeTillExpiration":J
    .end local v23    # "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    :catch_12
    move-exception v8

    .line 264
    .restart local v8    # "e":Lcom/comcast/cim/downloads/DownloadServiceException;
    const-wide/32 v12, 0x1b7740

    .line 265
    sget-object v26, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->LOG:Lorg/slf4j/Logger;

    const-string v27, "Caught exception while trying to update file, ignoring"

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-interface {v0, v1, v8}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_31
    .catchall {:try_start_31 .. :try_end_31} :catchall_0

    goto/16 :goto_8

    .line 217
    nop

    :sswitch_data_0
    .sparse-switch
        0x195 -> :sswitch_0
        0x197 -> :sswitch_0
        0x19f -> :sswitch_0
        0x1a4 -> :sswitch_0
        0x76d -> :sswitch_0
        0x7d1 -> :sswitch_1
    .end sparse-switch
.end method
