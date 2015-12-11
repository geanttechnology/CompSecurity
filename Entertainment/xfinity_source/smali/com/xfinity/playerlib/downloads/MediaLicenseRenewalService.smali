.class public Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalService;
.super Landroid/app/IntentService;
.source "MediaLicenseRenewalService.java"


# static fields
.field private static final LOG:Lorg/slf4j/Logger;

.field public static final NAME:Ljava/lang/String;


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
    .line 26
    const-class v0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalService;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalService;->LOG:Lorg/slf4j/Logger;

    .line 28
    const-class v0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalService;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalService;->NAME:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 49
    sget-object v0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalService;->NAME:Ljava/lang/String;

    invoke-direct {p0, v0}, Landroid/app/IntentService;-><init>(Ljava/lang/String;)V

    .line 30
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getInternetConnection()Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalService;->internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    .line 31
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getDownloadServiceManager()Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalService;->downloadsManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    .line 32
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getUserManager()Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalService;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    .line 33
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getNonDegradingVideoEntitlementCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalService;->entitlementCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 34
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getTitaniumTicketClient()Lcom/xfinity/playerlib/downloads/TitaniumTicketClient;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalService;->titaniumTicketClient:Lcom/xfinity/playerlib/downloads/TitaniumTicketClient;

    .line 35
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getMediaLicenseClient()Lcom/xfinity/playerlib/downloads/MediaLicenseClient;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalService;->mediaLicenseClient:Lcom/xfinity/playerlib/downloads/MediaLicenseClient;

    .line 36
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getMediaLicenseRenewalScheduler()Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalService;->scheduler:Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler;

    .line 37
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getWatchableClient()Lcom/xfinity/playerlib/model/consumable/WatchableClient;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalService;->watchableClient:Lcom/xfinity/playerlib/model/consumable/WatchableClient;

    .line 38
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getApplication()Lcom/xfinity/playerlib/PlayerApplication;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalService;->applicationContext:Landroid/app/Application;

    .line 39
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getHttpClient()Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalService;->httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    .line 40
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getCimAssetFactory()Lcom/xfinity/playerlib/model/videoplay/adobeplayer/CimAssetFactory;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalService;->cimAssetFactory:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/CimAssetFactory;

    .line 41
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getPlayerConfigUtil()Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalService;->playerConfigUtil:Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;

    .line 42
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getUiThreadExecutor()Lcom/comcast/cim/android/concurrent/UIThreadExecutor;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalService;->uiThreadExecutor:Ljava/util/concurrent/Executor;

    .line 50
    return-void
.end method

.method public static createIntent(Landroid/content/Context;)Landroid/content/Intent;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 45
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalService;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    return-object v0
.end method


# virtual methods
.method protected onHandleIntent(Landroid/content/Intent;)V
    .locals 15
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 55
    :try_start_0
    new-instance v0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;

    iget-object v1, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalService;->internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    iget-object v2, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalService;->downloadsManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    iget-object v3, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalService;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    iget-object v4, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalService;->entitlementCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    iget-object v5, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalService;->titaniumTicketClient:Lcom/xfinity/playerlib/downloads/TitaniumTicketClient;

    iget-object v6, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalService;->mediaLicenseClient:Lcom/xfinity/playerlib/downloads/MediaLicenseClient;

    iget-object v7, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalService;->watchableClient:Lcom/xfinity/playerlib/model/consumable/WatchableClient;

    iget-object v8, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalService;->scheduler:Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler;

    iget-object v9, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalService;->applicationContext:Landroid/app/Application;

    iget-object v10, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalService;->httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    iget-object v11, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalService;->cimAssetFactory:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/CimAssetFactory;

    iget-object v12, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalService;->playerConfigUtil:Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;

    iget-object v13, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalService;->uiThreadExecutor:Ljava/util/concurrent/Executor;

    invoke-direct/range {v0 .. v13}, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;-><init>(Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;Lcom/xfinity/playerlib/model/user/PlayNowUserManager;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/xfinity/playerlib/downloads/TitaniumTicketClient;Lcom/xfinity/playerlib/downloads/MediaLicenseClient;Lcom/xfinity/playerlib/model/consumable/WatchableClient;Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler;Landroid/app/Application;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;Lcom/xfinity/playerlib/model/videoplay/adobeplayer/CimAssetFactory;Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;Ljava/util/concurrent/Executor;)V

    .line 58
    invoke-virtual {v0}, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->run()V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    .line 62
    :goto_0
    return-void

    .line 59
    :catch_0
    move-exception v14

    .line 60
    .local v14, "e":Ljava/lang/Throwable;
    sget-object v0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalService;->LOG:Lorg/slf4j/Logger;

    const-string v1, "Caught exception trying to renew licenses"

    invoke-interface {v0, v1, v14}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method
