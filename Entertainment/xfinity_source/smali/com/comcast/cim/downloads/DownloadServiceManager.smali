.class public Lcom/comcast/cim/downloads/DownloadServiceManager;
.super Ljava/lang/Object;
.source "DownloadServiceManager.java"

# interfaces
.implements Lcom/comcast/cim/model/user/UserManager$UserManagerListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/cim/downloads/DownloadServiceManager$UpdateDownloadableFileMapTask;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<D:",
        "Lcom/comcast/cim/downloads/DownloadFile;",
        "T::",
        "Lcom/comcast/cim/model/user/User;",
        "S::",
        "Lcom/comcast/cim/model/user/service/UserSettings;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/comcast/cim/model/user/UserManager$UserManagerListener",
        "<TT;TS;>;"
    }
.end annotation


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field protected final backgroundExecutor:Ljava/util/concurrent/Executor;

.field protected final context:Landroid/content/Context;

.field private final downloadFileFactory:Lcom/comcast/cim/downloads/DownloadFileFactory;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/downloads/DownloadFileFactory",
            "<TD;>;"
        }
    .end annotation
.end field

.field private final downloadMetaDataSerializer:Lcom/comcast/cim/utils/JsonSerializer;

.field private final downloadsMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "TD;>;"
        }
    .end annotation
.end field

.field private volatile externalStorageAvailable:Z

.field private externalStorageReceiver:Landroid/content/BroadcastReceiver;

.field protected final foregroundExecutor:Ljava/util/concurrent/Executor;

.field private hasOldFiles:Z

.field private volatile initialDownloadFilesMapRetrieved:Z

.field private volatile initialQueuedFilesMapRetrieved:Z

.field private final initializationLatch:Ljava/util/concurrent/CountDownLatch;

.field private final listeners:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/comcast/cim/downloads/DownloadServiceListener",
            "<TD;>;>;"
        }
    .end annotation
.end field

.field private pauseCalled:Z

.field private final pendingDeletes:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<TD;",
            "Ljava/util/concurrent/CountDownLatch;",
            ">;"
        }
    .end annotation
.end field

.field private final queuedFilesMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "TD;>;"
        }
    .end annotation
.end field

.field private resumeCalled:Z

.field protected final sharedPreferences:Landroid/content/SharedPreferences;

.field private final userManager:Lcom/comcast/cim/model/user/UserManager;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/model/user/UserManager",
            "<TT;TS;>;"
        }
    .end annotation
.end field

.field private final virtuosoDownloadQueueCallback:Lcom/penthera/virtuososdk/client/IQueueObserver;

.field private final virtuosoDownloadedCallback:Lcom/penthera/virtuososdk/client/IDownloadedObserver;

.field private virtuosoEngineCallback:Lcom/penthera/virtuososdk/client/IEngineObserver;

.field private final virtuosoService:Lcom/penthera/virtuososdk/client/Virtuoso;

.field private final volatileDownloadFileCache:Ljava/util/LinkedHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/LinkedHashMap",
            "<",
            "Ljava/lang/String;",
            "TD;>;"
        }
    .end annotation
.end field

.field private waitingForPause:Z

.field private waitingForResume:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 66
    const-class v0, Lcom/comcast/cim/downloads/DownloadServiceManager;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/comcast/cim/downloads/DownloadServiceManager;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Landroid/app/Application;Lcom/comcast/cim/utils/JsonSerializer;Lcom/comcast/cim/downloads/DownloadFileFactory;Lcom/comcast/cim/model/user/UserManager;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;Landroid/content/SharedPreferences;)V
    .locals 3
    .param p1, "applicationContext"    # Landroid/app/Application;
    .param p2, "downloadMetaDataSerializer"    # Lcom/comcast/cim/utils/JsonSerializer;
    .param p5, "backgroundExecutor"    # Ljava/util/concurrent/Executor;
    .param p6, "foregroundExecutor"    # Ljava/util/concurrent/Executor;
    .param p7, "sharedPreferences"    # Landroid/content/SharedPreferences;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Application;",
            "Lcom/comcast/cim/utils/JsonSerializer;",
            "Lcom/comcast/cim/downloads/DownloadFileFactory",
            "<TD;>;",
            "Lcom/comcast/cim/model/user/UserManager",
            "<TT;TS;>;",
            "Ljava/util/concurrent/Executor;",
            "Ljava/util/concurrent/Executor;",
            "Landroid/content/SharedPreferences;",
            ")V"
        }
    .end annotation

    .prologue
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager;, "Lcom/comcast/cim/downloads/DownloadServiceManager<TD;TT;TS;>;"
    .local p3, "downloadFileFactory":Lcom/comcast/cim/downloads/DownloadFileFactory;, "Lcom/comcast/cim/downloads/DownloadFileFactory<TD;>;"
    .local p4, "userManager":Lcom/comcast/cim/model/user/UserManager;, "Lcom/comcast/cim/model/user/UserManager<TT;TS;>;"
    const/4 v2, 0x0

    .line 114
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 79
    new-instance v0, Ljava/util/concurrent/CountDownLatch;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Ljava/util/concurrent/CountDownLatch;-><init>(I)V

    iput-object v0, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->initializationLatch:Ljava/util/concurrent/CountDownLatch;

    .line 81
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    invoke-static {v0}, Ljava/util/Collections;->synchronizedSet(Ljava/util/Set;)Ljava/util/Set;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->listeners:Ljava/util/Set;

    .line 91
    iput-boolean v2, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->externalStorageAvailable:Z

    .line 92
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->externalStorageReceiver:Landroid/content/BroadcastReceiver;

    .line 95
    iput-boolean v2, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->initialQueuedFilesMapRetrieved:Z

    .line 96
    iput-boolean v2, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->initialDownloadFilesMapRetrieved:Z

    .line 99
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    invoke-static {v0}, Ljava/util/Collections;->synchronizedMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->queuedFilesMap:Ljava/util/Map;

    .line 100
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    invoke-static {v0}, Ljava/util/Collections;->synchronizedMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->downloadsMap:Ljava/util/Map;

    .line 101
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->pendingDeletes:Ljava/util/Map;

    .line 102
    new-instance v0, Ljava/util/LinkedHashMap;

    const/16 v1, 0xa

    invoke-direct {v0, v1}, Ljava/util/LinkedHashMap;-><init>(I)V

    iput-object v0, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->volatileDownloadFileCache:Ljava/util/LinkedHashMap;

    .line 160
    new-instance v0, Lcom/comcast/cim/downloads/DownloadServiceManager$2;

    invoke-direct {v0, p0}, Lcom/comcast/cim/downloads/DownloadServiceManager$2;-><init>(Lcom/comcast/cim/downloads/DownloadServiceManager;)V

    iput-object v0, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->virtuosoEngineCallback:Lcom/penthera/virtuososdk/client/IEngineObserver;

    .line 173
    new-instance v0, Lcom/comcast/cim/downloads/DownloadServiceManager$3;

    invoke-direct {v0, p0}, Lcom/comcast/cim/downloads/DownloadServiceManager$3;-><init>(Lcom/comcast/cim/downloads/DownloadServiceManager;)V

    iput-object v0, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->virtuosoDownloadedCallback:Lcom/penthera/virtuososdk/client/IDownloadedObserver;

    .line 187
    new-instance v0, Lcom/comcast/cim/downloads/DownloadServiceManager$4;

    invoke-direct {v0, p0}, Lcom/comcast/cim/downloads/DownloadServiceManager$4;-><init>(Lcom/comcast/cim/downloads/DownloadServiceManager;)V

    iput-object v0, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->virtuosoDownloadQueueCallback:Lcom/penthera/virtuososdk/client/IQueueObserver;

    .line 115
    iput-object p1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->context:Landroid/content/Context;

    .line 116
    iput-object p2, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->downloadMetaDataSerializer:Lcom/comcast/cim/utils/JsonSerializer;

    .line 117
    iput-object p3, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->downloadFileFactory:Lcom/comcast/cim/downloads/DownloadFileFactory;

    .line 118
    iput-object p4, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->userManager:Lcom/comcast/cim/model/user/UserManager;

    .line 119
    iput-object p5, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->backgroundExecutor:Ljava/util/concurrent/Executor;

    .line 120
    iput-object p6, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->foregroundExecutor:Ljava/util/concurrent/Executor;

    .line 121
    iput-object p7, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->sharedPreferences:Landroid/content/SharedPreferences;

    .line 123
    new-instance v0, Lcom/penthera/virtuososdk/client/Virtuoso;

    new-instance v1, Lcom/comcast/cim/downloads/DownloadServiceManager$1;

    invoke-direct {v1, p0}, Lcom/comcast/cim/downloads/DownloadServiceManager$1;-><init>(Lcom/comcast/cim/downloads/DownloadServiceManager;)V

    invoke-direct {v0, p1, v1}, Lcom/penthera/virtuososdk/client/Virtuoso;-><init>(Landroid/content/Context;Lcom/penthera/virtuososdk/client/IServiceConnectedCallback;)V

    iput-object v0, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->virtuosoService:Lcom/penthera/virtuososdk/client/Virtuoso;

    .line 153
    iget-object v0, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->virtuosoService:Lcom/penthera/virtuososdk/client/Virtuoso;

    iget-object v1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->virtuosoDownloadedCallback:Lcom/penthera/virtuososdk/client/IDownloadedObserver;

    invoke-virtual {v0, v1}, Lcom/penthera/virtuososdk/client/Virtuoso;->addDownloadedObserver(Lcom/penthera/virtuososdk/client/IDownloadedObserver;)V

    .line 154
    iget-object v0, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->virtuosoService:Lcom/penthera/virtuososdk/client/Virtuoso;

    iget-object v1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->virtuosoDownloadQueueCallback:Lcom/penthera/virtuososdk/client/IQueueObserver;

    invoke-virtual {v0, v1}, Lcom/penthera/virtuososdk/client/Virtuoso;->addQueueObserver(Lcom/penthera/virtuososdk/client/IQueueObserver;)V

    .line 155
    iget-object v0, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->virtuosoService:Lcom/penthera/virtuososdk/client/Virtuoso;

    iget-object v1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->virtuosoEngineCallback:Lcom/penthera/virtuososdk/client/IEngineObserver;

    invoke-virtual {v0, v1}, Lcom/penthera/virtuososdk/client/Virtuoso;->addEngineObserver(Lcom/penthera/virtuososdk/client/IEngineObserver;)V

    .line 156
    iget-object v0, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->virtuosoService:Lcom/penthera/virtuososdk/client/Virtuoso;

    invoke-virtual {v0}, Lcom/penthera/virtuososdk/client/Virtuoso;->onResume()V

    .line 157
    return-void
.end method

.method static synthetic access$000()Lorg/slf4j/Logger;
    .locals 1

    .prologue
    .line 64
    sget-object v0, Lcom/comcast/cim/downloads/DownloadServiceManager;->LOG:Lorg/slf4j/Logger;

    return-object v0
.end method

.method static synthetic access$100(Lcom/comcast/cim/downloads/DownloadServiceManager;)V
    .locals 0
    .param p0, "x0"    # Lcom/comcast/cim/downloads/DownloadServiceManager;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/penthera/virtuososdk/client/ServiceException;
        }
    .end annotation

    .prologue
    .line 64
    invoke-direct {p0}, Lcom/comcast/cim/downloads/DownloadServiceManager;->setupServiceSettings()V

    return-void
.end method

.method static synthetic access$1002(Lcom/comcast/cim/downloads/DownloadServiceManager;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/comcast/cim/downloads/DownloadServiceManager;
    .param p1, "x1"    # Z

    .prologue
    .line 64
    iput-boolean p1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->initialQueuedFilesMapRetrieved:Z

    return p1
.end method

.method static synthetic access$1100(Lcom/comcast/cim/downloads/DownloadServiceManager;)Ljava/util/Map;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/downloads/DownloadServiceManager;

    .prologue
    .line 64
    iget-object v0, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->pendingDeletes:Ljava/util/Map;

    return-object v0
.end method

.method static synthetic access$1200(Lcom/comcast/cim/downloads/DownloadServiceManager;)Ljava/util/Set;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/downloads/DownloadServiceManager;

    .prologue
    .line 64
    iget-object v0, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->listeners:Ljava/util/Set;

    return-object v0
.end method

.method static synthetic access$1300(Lcom/comcast/cim/downloads/DownloadServiceManager;)Z
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/downloads/DownloadServiceManager;

    .prologue
    .line 64
    iget-boolean v0, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->externalStorageAvailable:Z

    return v0
.end method

.method static synthetic access$1302(Lcom/comcast/cim/downloads/DownloadServiceManager;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/comcast/cim/downloads/DownloadServiceManager;
    .param p1, "x1"    # Z

    .prologue
    .line 64
    iput-boolean p1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->externalStorageAvailable:Z

    return p1
.end method

.method static synthetic access$1400(Lcom/comcast/cim/downloads/DownloadServiceManager;)V
    .locals 0
    .param p0, "x0"    # Lcom/comcast/cim/downloads/DownloadServiceManager;

    .prologue
    .line 64
    invoke-direct {p0}, Lcom/comcast/cim/downloads/DownloadServiceManager;->resetFilesWithSDCardError()V

    return-void
.end method

.method static synthetic access$1500(Lcom/comcast/cim/downloads/DownloadServiceManager;)V
    .locals 0
    .param p0, "x0"    # Lcom/comcast/cim/downloads/DownloadServiceManager;

    .prologue
    .line 64
    invoke-direct {p0}, Lcom/comcast/cim/downloads/DownloadServiceManager;->forceRetryDownloads()V

    return-void
.end method

.method static synthetic access$1602(Lcom/comcast/cim/downloads/DownloadServiceManager;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/comcast/cim/downloads/DownloadServiceManager;
    .param p1, "x1"    # Z

    .prologue
    .line 64
    iput-boolean p1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->hasOldFiles:Z

    return p1
.end method

.method static synthetic access$1700(Lcom/comcast/cim/downloads/DownloadServiceManager;)Ljava/util/concurrent/CountDownLatch;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/downloads/DownloadServiceManager;

    .prologue
    .line 64
    iget-object v0, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->initializationLatch:Ljava/util/concurrent/CountDownLatch;

    return-object v0
.end method

.method static synthetic access$200(Lcom/comcast/cim/downloads/DownloadServiceManager;)V
    .locals 0
    .param p0, "x0"    # Lcom/comcast/cim/downloads/DownloadServiceManager;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/penthera/virtuososdk/client/ServiceException;
        }
    .end annotation

    .prologue
    .line 64
    invoke-direct {p0}, Lcom/comcast/cim/downloads/DownloadServiceManager;->fetchFileList()V

    return-void
.end method

.method static synthetic access$300(Lcom/comcast/cim/downloads/DownloadServiceManager;)Lcom/comcast/cim/model/user/UserManager;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/downloads/DownloadServiceManager;

    .prologue
    .line 64
    iget-object v0, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->userManager:Lcom/comcast/cim/model/user/UserManager;

    return-object v0
.end method

.method static synthetic access$400(Lcom/comcast/cim/downloads/DownloadServiceManager;)V
    .locals 0
    .param p0, "x0"    # Lcom/comcast/cim/downloads/DownloadServiceManager;

    .prologue
    .line 64
    invoke-direct {p0}, Lcom/comcast/cim/downloads/DownloadServiceManager;->startWatchingExternalStorage()V

    return-void
.end method

.method static synthetic access$500(Lcom/comcast/cim/downloads/DownloadServiceManager;)Lcom/penthera/virtuososdk/client/Virtuoso;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/downloads/DownloadServiceManager;

    .prologue
    .line 64
    iget-object v0, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->virtuosoService:Lcom/penthera/virtuososdk/client/Virtuoso;

    return-object v0
.end method

.method static synthetic access$600(Lcom/comcast/cim/downloads/DownloadServiceManager;)Ljava/util/Map;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/downloads/DownloadServiceManager;

    .prologue
    .line 64
    iget-object v0, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->downloadsMap:Ljava/util/Map;

    return-object v0
.end method

.method static synthetic access$702(Lcom/comcast/cim/downloads/DownloadServiceManager;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/comcast/cim/downloads/DownloadServiceManager;
    .param p1, "x1"    # Z

    .prologue
    .line 64
    iput-boolean p1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->initialDownloadFilesMapRetrieved:Z

    return p1
.end method

.method static synthetic access$800(Lcom/comcast/cim/downloads/DownloadServiceManager;Lcom/penthera/virtuososdk/client/IVirtuosoAsset;)Lcom/comcast/cim/downloads/DownloadFile;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/downloads/DownloadServiceManager;
    .param p1, "x1"    # Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    .prologue
    .line 64
    invoke-direct {p0, p1}, Lcom/comcast/cim/downloads/DownloadServiceManager;->getDownloadFile(Lcom/penthera/virtuososdk/client/IVirtuosoAsset;)Lcom/comcast/cim/downloads/DownloadFile;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$900(Lcom/comcast/cim/downloads/DownloadServiceManager;)Ljava/util/Map;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/downloads/DownloadServiceManager;

    .prologue
    .line 64
    iget-object v0, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->queuedFilesMap:Ljava/util/Map;

    return-object v0
.end method

.method private declared-synchronized configureHttpSettings()V
    .locals 5

    .prologue
    .line 931
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager;, "Lcom/comcast/cim/downloads/DownloadServiceManager<TD;TT;TS;>;"
    monitor-enter p0

    :try_start_0
    invoke-static {}, Lcom/comcast/cim/container/CALContainer;->getInstance()Lcom/comcast/cim/container/CALContainer;

    move-result-object v3

    invoke-virtual {v3}, Lcom/comcast/cim/container/CALContainer;->getDownloadUserAgent()Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeader;

    move-result-object v2

    .line 932
    .local v2, "userAgent":Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeader;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 933
    .local v0, "bundle":Landroid/os/Bundle;
    invoke-virtual {v2}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeader;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeader;->getValue()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 934
    const/16 v3, 0x2710

    const/16 v4, 0x7530

    invoke-virtual {p0, v0, v3, v4}, Lcom/comcast/cim/downloads/DownloadServiceManager;->configureService(Landroid/os/Bundle;II)V
    :try_end_0
    .catch Lcom/comcast/cim/downloads/DownloadServiceException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 940
    monitor-exit p0

    return-void

    .line 937
    .end local v0    # "bundle":Landroid/os/Bundle;
    .end local v2    # "userAgent":Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeader;
    :catch_0
    move-exception v1

    .line 938
    .local v1, "e":Lcom/comcast/cim/downloads/DownloadServiceException;
    :try_start_1
    new-instance v3, Ljava/lang/RuntimeException;

    invoke-direct {v3, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 931
    .end local v1    # "e":Lcom/comcast/cim/downloads/DownloadServiceException;
    :catchall_0
    move-exception v3

    monitor-exit p0

    throw v3
.end method

.method private fetchFileList()V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/penthera/virtuososdk/client/ServiceException;
        }
    .end annotation

    .prologue
    .line 713
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager;, "Lcom/comcast/cim/downloads/DownloadServiceManager<TD;TT;TS;>;"
    iget-object v0, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->backgroundExecutor:Ljava/util/concurrent/Executor;

    new-instance v1, Lcom/comcast/cim/downloads/DownloadServiceManager$16;

    iget-object v2, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->virtuosoService:Lcom/penthera/virtuososdk/client/Virtuoso;

    invoke-virtual {v2}, Lcom/penthera/virtuososdk/client/Virtuoso;->downloadedRootList()Ljava/util/List;

    move-result-object v2

    iget-object v3, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->downloadsMap:Ljava/util/Map;

    invoke-direct {v1, p0, v2, v3}, Lcom/comcast/cim/downloads/DownloadServiceManager$16;-><init>(Lcom/comcast/cim/downloads/DownloadServiceManager;Ljava/util/List;Ljava/util/Map;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 719
    iget-object v0, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->backgroundExecutor:Ljava/util/concurrent/Executor;

    new-instance v1, Lcom/comcast/cim/downloads/DownloadServiceManager$17;

    iget-object v2, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->virtuosoService:Lcom/penthera/virtuososdk/client/Virtuoso;

    invoke-virtual {v2}, Lcom/penthera/virtuososdk/client/Virtuoso;->queuedRootList()Ljava/util/List;

    move-result-object v2

    iget-object v3, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->queuedFilesMap:Ljava/util/Map;

    invoke-direct {v1, p0, v2, v3}, Lcom/comcast/cim/downloads/DownloadServiceManager$17;-><init>(Lcom/comcast/cim/downloads/DownloadServiceManager;Ljava/util/List;Ljava/util/Map;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 725
    return-void
.end method

.method private forceRetryDownloads()V
    .locals 4

    .prologue
    .line 626
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager;, "Lcom/comcast/cim/downloads/DownloadServiceManager<TD;TT;TS;>;"
    :try_start_0
    iget-object v1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->virtuosoService:Lcom/penthera/virtuososdk/client/Virtuoso;

    const-wide v2, 0x3fc1eb851eb851ebL    # 0.13999999999999999

    invoke-virtual {v1, v2, v3}, Lcom/penthera/virtuososdk/client/Virtuoso;->overrideBatteryThreshold(D)V

    .line 627
    iget-object v1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->virtuosoService:Lcom/penthera/virtuososdk/client/Virtuoso;

    const-wide v2, 0x3fc3333333333333L    # 0.15

    invoke-virtual {v1, v2, v3}, Lcom/penthera/virtuososdk/client/Virtuoso;->overrideBatteryThreshold(D)V
    :try_end_0
    .catch Lcom/penthera/virtuososdk/client/ServiceException; {:try_start_0 .. :try_end_0} :catch_0

    .line 631
    :goto_0
    return-void

    .line 628
    :catch_0
    move-exception v0

    .line 629
    .local v0, "e":Lcom/penthera/virtuososdk/client/ServiceException;
    sget-object v1, Lcom/comcast/cim/downloads/DownloadServiceManager;->LOG:Lorg/slf4j/Logger;

    const-string v2, "Failed to trigger downloads"

    invoke-interface {v1, v2, v0}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method private getDownloadFile(Lcom/penthera/virtuososdk/client/IVirtuosoAsset;)Lcom/comcast/cim/downloads/DownloadFile;
    .locals 4
    .param p1, "asset"    # Lcom/penthera/virtuososdk/client/IVirtuosoAsset;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/penthera/virtuososdk/client/IVirtuosoAsset;",
            ")TD;"
        }
    .end annotation

    .prologue
    .line 728
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager;, "Lcom/comcast/cim/downloads/DownloadServiceManager<TD;TT;TS;>;"
    invoke-interface {p1}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->uuid()Ljava/lang/String;

    move-result-object v0

    .line 730
    .local v0, "cacheKey":Ljava/lang/String;
    iget-object v3, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->volatileDownloadFileCache:Ljava/util/LinkedHashMap;

    monitor-enter v3

    .line 731
    :try_start_0
    iget-object v2, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->volatileDownloadFileCache:Ljava/util/LinkedHashMap;

    invoke-virtual {v2, v0}, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/comcast/cim/downloads/DownloadFile;

    .line 732
    .local v1, "downloadableFile":Lcom/comcast/cim/downloads/DownloadFile;, "TD;"
    if-nez v1, :cond_0

    .line 733
    iget-object v2, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->downloadFileFactory:Lcom/comcast/cim/downloads/DownloadFileFactory;

    invoke-virtual {v2, p1}, Lcom/comcast/cim/downloads/DownloadFileFactory;->create(Lcom/penthera/virtuososdk/client/IVirtuosoAsset;)Lcom/comcast/cim/downloads/DownloadFile;

    move-result-object v1

    .line 734
    iget-object v2, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->volatileDownloadFileCache:Ljava/util/LinkedHashMap;

    invoke-virtual {v2, v0, v1}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 738
    :goto_0
    monitor-exit v3

    .line 739
    return-object v1

    .line 736
    :cond_0
    invoke-virtual {v1, p1}, Lcom/comcast/cim/downloads/DownloadFile;->setAsset(Lcom/penthera/virtuososdk/client/IVirtuosoAsset;)V

    goto :goto_0

    .line 738
    .end local v1    # "downloadableFile":Lcom/comcast/cim/downloads/DownloadFile;, "TD;"
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2
.end method

.method private declared-synchronized handleDownloadEngineStatusChange(Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;)V
    .locals 3
    .param p1, "status"    # Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;

    .prologue
    .line 590
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager;, "Lcom/comcast/cim/downloads/DownloadServiceManager<TD;TT;TS;>;"
    monitor-enter p0

    :try_start_0
    invoke-interface {p1}, Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;->status()Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    move-result-object v1

    sget-object v2, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Paused:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    if-ne v1, v2, :cond_1

    .line 591
    const/4 v1, 0x0

    iput-boolean v1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->waitingForPause:Z

    .line 592
    iget-boolean v1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->resumeCalled:Z

    if-eqz v1, :cond_0

    .line 593
    invoke-virtual {p0}, Lcom/comcast/cim/downloads/DownloadServiceManager;->resumeDownloading()V
    :try_end_0
    .catch Lcom/comcast/cim/downloads/DownloadServiceException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 604
    :cond_0
    :goto_0
    monitor-exit p0

    return-void

    .line 596
    :cond_1
    const/4 v1, 0x0

    :try_start_1
    iput-boolean v1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->waitingForResume:Z

    .line 597
    iget-boolean v1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->pauseCalled:Z

    if-eqz v1, :cond_0

    .line 598
    invoke-virtual {p0}, Lcom/comcast/cim/downloads/DownloadServiceManager;->pauseDownloading()V
    :try_end_1
    .catch Lcom/comcast/cim/downloads/DownloadServiceException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 601
    :catch_0
    move-exception v0

    .line 602
    .local v0, "e":Lcom/comcast/cim/downloads/DownloadServiceException;
    :try_start_2
    sget-object v1, Lcom/comcast/cim/downloads/DownloadServiceManager;->LOG:Lorg/slf4j/Logger;

    const-string v2, "Pause/Resume Error"

    invoke-interface {v1, v2, v0}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0

    .line 590
    .end local v0    # "e":Lcom/comcast/cim/downloads/DownloadServiceException;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method private resetFilesWithSDCardError()V
    .locals 18

    .prologue
    .line 634
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager;, "Lcom/comcast/cim/downloads/DownloadServiceManager<TD;TT;TS;>;"
    invoke-virtual/range {p0 .. p0}, Lcom/comcast/cim/downloads/DownloadServiceManager;->getFilesList()Ljava/util/List;

    move-result-object v5

    .line 635
    .local v5, "files":Ljava/util/List;, "Ljava/util/List<TD;>;"
    invoke-interface {v5}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v12

    :cond_0
    :goto_0
    invoke-interface {v12}, Ljava/util/Iterator;->hasNext()Z

    move-result v11

    if-eqz v11, :cond_3

    invoke-interface {v12}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/comcast/cim/downloads/DownloadFile;

    .line 638
    .local v4, "file":Lcom/comcast/cim/downloads/DownloadFile;, "TD;"
    invoke-virtual {v4}, Lcom/comcast/cim/downloads/DownloadFile;->getAsset()Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    move-result-object v2

    .line 639
    .local v2, "currentAsset":Lcom/penthera/virtuososdk/client/IVirtuosoAsset;
    invoke-interface {v2}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->downloadStatus()Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    move-result-object v10

    .line 640
    .local v10, "status":Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;
    sget-object v11, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_File_Corrupt:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    if-eq v10, v11, :cond_1

    sget-object v11, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_File_Copy_Error:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    if-ne v10, v11, :cond_0

    .line 642
    invoke-interface {v2}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->currentSize()D

    move-result-wide v14

    const-wide/16 v16, 0x0

    cmpl-double v11, v14, v16

    if-nez v11, :cond_0

    .line 646
    :cond_1
    :try_start_0
    move-object/from16 v0, p0

    iget-object v11, v0, Lcom/comcast/cim/downloads/DownloadServiceManager;->virtuosoService:Lcom/penthera/virtuososdk/client/Virtuoso;

    invoke-interface {v2}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->assetURL()Ljava/lang/String;

    move-result-object v13

    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/comcast/cim/downloads/DownloadServiceManager;->downloadMetaDataSerializer:Lcom/comcast/cim/utils/JsonSerializer;

    invoke-virtual {v4}, Lcom/comcast/cim/downloads/DownloadFile;->getDownloadMetaData()Lcom/comcast/cim/downloads/DownloadMetaData;

    move-result-object v15

    invoke-virtual {v14, v15}, Lcom/comcast/cim/utils/JsonSerializer;->serialize(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v11, v13, v14}, Lcom/penthera/virtuososdk/client/Virtuoso;->virtuosoHLSFile(Ljava/lang/String;Ljava/lang/String;)Lcom/penthera/virtuososdk/client/IVirtuosoHLSFile;

    move-result-object v9

    .line 647
    .local v9, "newAsset":Lcom/penthera/virtuososdk/client/IVirtuosoAsset;
    move-object v0, v2

    check-cast v0, Lcom/penthera/virtuososdk/client/IVirtuosoHLSFile;

    move-object v11, v0

    invoke-interface {v11}, Lcom/penthera/virtuososdk/client/IVirtuosoHLSFile;->fragments()Ljava/util/List;

    move-result-object v8

    .line 648
    .local v8, "fragments":Ljava/util/List;, "Ljava/util/List<Lcom/penthera/virtuososdk/client/IFileFragment;>;"
    new-instance v7, Ljava/util/ArrayList;

    invoke-interface {v8}, Ljava/util/List;->size()I

    move-result v11

    invoke-direct {v7, v11}, Ljava/util/ArrayList;-><init>(I)V

    .line 649
    .local v7, "fragmentPaths":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {v8}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v11

    :goto_1
    invoke-interface {v11}, Ljava/util/Iterator;->hasNext()Z

    move-result v13

    if-eqz v13, :cond_2

    invoke-interface {v11}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/penthera/virtuososdk/client/IFileFragment;

    .line 650
    .local v6, "fragment":Lcom/penthera/virtuososdk/client/IFileFragment;
    invoke-interface {v6}, Lcom/penthera/virtuososdk/client/IFileFragment;->remotePath()Ljava/lang/String;

    move-result-object v13

    invoke-interface {v7, v13}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Lcom/penthera/virtuososdk/client/ServiceException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 655
    .end local v6    # "fragment":Lcom/penthera/virtuososdk/client/IFileFragment;
    .end local v7    # "fragmentPaths":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v8    # "fragments":Ljava/util/List;, "Ljava/util/List<Lcom/penthera/virtuososdk/client/IFileFragment;>;"
    .end local v9    # "newAsset":Lcom/penthera/virtuososdk/client/IVirtuosoAsset;
    :catch_0
    move-exception v3

    .line 657
    .local v3, "e":Lcom/penthera/virtuososdk/client/ServiceException;
    sget-object v11, Lcom/comcast/cim/downloads/DownloadServiceManager;->LOG:Lorg/slf4j/Logger;

    const-string v13, "Failed to fix corrupted file!  User removal will be required at this point..."

    invoke-interface {v11, v13}, Lorg/slf4j/Logger;->error(Ljava/lang/String;)V

    goto :goto_0

    .line 652
    .end local v3    # "e":Lcom/penthera/virtuososdk/client/ServiceException;
    .restart local v7    # "fragmentPaths":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .restart local v8    # "fragments":Ljava/util/List;, "Ljava/util/List<Lcom/penthera/virtuososdk/client/IFileFragment;>;"
    .restart local v9    # "newAsset":Lcom/penthera/virtuososdk/client/IVirtuosoAsset;
    :cond_2
    :try_start_1
    move-object v0, v9

    check-cast v0, Lcom/penthera/virtuososdk/client/IVirtuosoHLSFile;

    move-object v11, v0

    invoke-interface {v11, v7}, Lcom/penthera/virtuososdk/client/IVirtuosoHLSFile;->addFragments(Ljava/util/List;)I

    .line 653
    move-object/from16 v0, p0

    iget-object v11, v0, Lcom/comcast/cim/downloads/DownloadServiceManager;->virtuosoService:Lcom/penthera/virtuososdk/client/Virtuoso;

    invoke-virtual {v11, v2}, Lcom/penthera/virtuososdk/client/Virtuoso;->delete(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V

    .line 654
    move-object/from16 v0, p0

    iget-object v11, v0, Lcom/comcast/cim/downloads/DownloadServiceManager;->virtuosoService:Lcom/penthera/virtuososdk/client/Virtuoso;

    invoke-virtual {v11, v9}, Lcom/penthera/virtuososdk/client/Virtuoso;->addToQueue(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V
    :try_end_1
    .catch Lcom/penthera/virtuososdk/client/ServiceException; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_0

    .line 661
    .end local v2    # "currentAsset":Lcom/penthera/virtuososdk/client/IVirtuosoAsset;
    .end local v4    # "file":Lcom/comcast/cim/downloads/DownloadFile;, "TD;"
    .end local v7    # "fragmentPaths":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v8    # "fragments":Ljava/util/List;, "Ljava/util/List<Lcom/penthera/virtuososdk/client/IFileFragment;>;"
    .end local v9    # "newAsset":Lcom/penthera/virtuososdk/client/IVirtuosoAsset;
    .end local v10    # "status":Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;
    :cond_3
    return-void
.end method

.method private setupServiceSettings()V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/penthera/virtuososdk/client/ServiceException;
        }
    .end annotation

    .prologue
    .line 705
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager;, "Lcom/comcast/cim/downloads/DownloadServiceManager<TD;TT;TS;>;"
    invoke-direct {p0}, Lcom/comcast/cim/downloads/DownloadServiceManager;->configureHttpSettings()V

    .line 706
    iget-object v0, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->virtuosoService:Lcom/penthera/virtuososdk/client/Virtuoso;

    const-wide/high16 v2, 0x4049000000000000L    # 50.0

    invoke-virtual {v0, v2, v3}, Lcom/penthera/virtuososdk/client/Virtuoso;->overrideHeadroom(D)V

    .line 707
    iget-object v0, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->virtuosoService:Lcom/penthera/virtuososdk/client/Virtuoso;

    const-wide v2, 0x3fc3333333333333L    # 0.15

    invoke-virtual {v0, v2, v3}, Lcom/penthera/virtuososdk/client/Virtuoso;->overrideBatteryThreshold(D)V

    .line 708
    iget-object v0, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->virtuosoService:Lcom/penthera/virtuososdk/client/Virtuoso;

    const-wide/high16 v2, -0x4010000000000000L    # -1.0

    invoke-virtual {v0, v2, v3}, Lcom/penthera/virtuososdk/client/Virtuoso;->overrideMaxStorageAllowed(D)V

    .line 709
    return-void
.end method

.method private startWatchingExternalStorage()V
    .locals 3

    .prologue
    .line 664
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager;, "Lcom/comcast/cim/downloads/DownloadServiceManager<TD;TT;TS;>;"
    new-instance v1, Lcom/comcast/cim/downloads/DownloadServiceManager$15;

    invoke-direct {v1, p0}, Lcom/comcast/cim/downloads/DownloadServiceManager$15;-><init>(Lcom/comcast/cim/downloads/DownloadServiceManager;)V

    iput-object v1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->externalStorageReceiver:Landroid/content/BroadcastReceiver;

    .line 695
    new-instance v0, Landroid/content/IntentFilter;

    invoke-direct {v0}, Landroid/content/IntentFilter;-><init>()V

    .line 696
    .local v0, "filter":Landroid/content/IntentFilter;
    const-string v1, "android.intent.action.MEDIA_MOUNTED"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 697
    const-string v1, "android.intent.action.MEDIA_UNMOUNTED"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 698
    const-string v1, "android.intent.action.MEDIA_REMOVED"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 699
    const-string v1, "file"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addDataScheme(Ljava/lang/String;)V

    .line 700
    iget-object v1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->context:Landroid/content/Context;

    iget-object v2, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->externalStorageReceiver:Landroid/content/BroadcastReceiver;

    invoke-virtual {v1, v2, v0}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 701
    invoke-virtual {p0}, Lcom/comcast/cim/downloads/DownloadServiceManager;->isExternalStorageConnected()Z

    move-result v1

    iput-boolean v1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->externalStorageAvailable:Z

    .line 702
    return-void
.end method


# virtual methods
.method public addDownloadServiceListener(Lcom/comcast/cim/downloads/DownloadServiceListener;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/downloads/DownloadServiceListener",
            "<TD;>;)V"
        }
    .end annotation

    .prologue
    .line 488
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager;, "Lcom/comcast/cim/downloads/DownloadServiceManager<TD;TT;TS;>;"
    .local p1, "listener":Lcom/comcast/cim/downloads/DownloadServiceListener;, "Lcom/comcast/cim/downloads/DownloadServiceListener<TD;>;"
    iget-object v0, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->listeners:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 489
    return-void
.end method

.method public configureService(Landroid/os/Bundle;II)V
    .locals 3
    .param p1, "headers"    # Landroid/os/Bundle;
    .param p2, "connectTimeout"    # I
    .param p3, "socketTimeout"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/downloads/DownloadServiceException;
        }
    .end annotation

    .prologue
    .line 293
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager;, "Lcom/comcast/cim/downloads/DownloadServiceManager<TD;TT;TS;>;"
    :try_start_0
    iget-object v1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->virtuosoService:Lcom/penthera/virtuososdk/client/Virtuoso;

    invoke-virtual {v1, p1, p2, p3}, Lcom/penthera/virtuososdk/client/Virtuoso;->configure(Landroid/os/Bundle;II)V
    :try_end_0
    .catch Lcom/penthera/virtuososdk/client/ServiceException; {:try_start_0 .. :try_end_0} :catch_0

    .line 297
    return-void

    .line 294
    :catch_0
    move-exception v0

    .line 295
    .local v0, "e":Lcom/penthera/virtuososdk/client/ServiceException;
    new-instance v1, Lcom/comcast/cim/downloads/DownloadServiceException;

    const-string v2, "Download Service failed to configure Http Connection"

    invoke-direct {v1, v2, v0}, Lcom/comcast/cim/downloads/DownloadServiceException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
.end method

.method protected createHlsFile(Ljava/util/List;Ljava/lang/String;Lcom/comcast/cim/downloads/DownloadMetaData;)Lcom/penthera/virtuososdk/client/IVirtuosoHLSFile;
    .locals 3
    .param p2, "assetId"    # Ljava/lang/String;
    .param p3, "metadata"    # Lcom/comcast/cim/downloads/DownloadMetaData;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            "Lcom/comcast/cim/downloads/DownloadMetaData;",
            ")",
            "Lcom/penthera/virtuososdk/client/IVirtuosoHLSFile;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/penthera/virtuososdk/client/ServiceException;
        }
    .end annotation

    .prologue
    .line 743
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager;, "Lcom/comcast/cim/downloads/DownloadServiceManager<TD;TT;TS;>;"
    .local p1, "assetUrls":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-static {p1}, Lorg/apache/commons/lang3/Validate;->notNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 744
    invoke-static {p2}, Lorg/apache/commons/lang3/Validate;->notNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 745
    invoke-static {p3}, Lorg/apache/commons/lang3/Validate;->notNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 748
    iget-object v1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->virtuosoService:Lcom/penthera/virtuososdk/client/Virtuoso;

    iget-object v2, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->downloadMetaDataSerializer:Lcom/comcast/cim/utils/JsonSerializer;

    invoke-virtual {v2, p3}, Lcom/comcast/cim/utils/JsonSerializer;->serialize(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, p2, v2}, Lcom/penthera/virtuososdk/client/Virtuoso;->virtuosoHLSFile(Ljava/lang/String;Ljava/lang/String;)Lcom/penthera/virtuososdk/client/IVirtuosoHLSFile;

    move-result-object v0

    .line 749
    .local v0, "hlsFile":Lcom/penthera/virtuososdk/client/IVirtuosoHLSFile;
    invoke-interface {v0, p1}, Lcom/penthera/virtuososdk/client/IVirtuosoHLSFile;->addFragments(Ljava/util/List;)I

    .line 751
    return-object v0
.end method

.method public deleteAllContent()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<TD;",
            "Ljava/util/concurrent/CountDownLatch;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/downloads/DownloadServiceException;
        }
    .end annotation

    .prologue
    .line 442
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager;, "Lcom/comcast/cim/downloads/DownloadServiceManager<TD;TT;TS;>;"
    invoke-virtual {p0}, Lcom/comcast/cim/downloads/DownloadServiceManager;->getFilesList()Ljava/util/List;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/comcast/cim/downloads/DownloadServiceManager;->deleteFiles(Ljava/util/List;)Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method public deleteAllContentForUpgrade()V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/downloads/DownloadServiceException;
        }
    .end annotation

    .prologue
    .line 613
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager;, "Lcom/comcast/cim/downloads/DownloadServiceManager<TD;TT;TS;>;"
    :try_start_0
    iget-object v1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->virtuosoService:Lcom/penthera/virtuososdk/client/Virtuoso;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/client/Virtuoso;->deleteAllFiles()V
    :try_end_0
    .catch Lcom/penthera/virtuososdk/client/ServiceException; {:try_start_0 .. :try_end_0} :catch_0

    .line 618
    return-void

    .line 614
    :catch_0
    move-exception v0

    .line 615
    .local v0, "e":Lcom/penthera/virtuososdk/client/ServiceException;
    sget-object v1, Lcom/comcast/cim/downloads/DownloadServiceManager;->LOG:Lorg/slf4j/Logger;

    const-string v2, "Failed to clear out the downloads file list"

    invoke-interface {v1, v2, v0}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 616
    new-instance v1, Lcom/comcast/cim/downloads/DownloadServiceException;

    invoke-direct {v1, v0}, Lcom/comcast/cim/downloads/DownloadServiceException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method public deleteFile(Lcom/comcast/cim/downloads/DownloadFile;)Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TD;)",
            "Ljava/util/Map",
            "<TD;",
            "Ljava/util/concurrent/CountDownLatch;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/downloads/DownloadServiceException;
        }
    .end annotation

    .prologue
    .line 392
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager;, "Lcom/comcast/cim/downloads/DownloadServiceManager<TD;TT;TS;>;"
    .local p1, "file":Lcom/comcast/cim/downloads/DownloadFile;, "TD;"
    invoke-static {p1}, Lcom/comcast/cim/cmasl/utils/collections/CollectionUtils;->createList(Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/comcast/cim/downloads/DownloadServiceManager;->deleteFiles(Ljava/util/List;)Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method public deleteFiles(Ljava/util/List;)Ljava/util/Map;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<TD;>;)",
            "Ljava/util/Map",
            "<TD;",
            "Ljava/util/concurrent/CountDownLatch;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/downloads/DownloadServiceException;
        }
    .end annotation

    .prologue
    .line 396
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager;, "Lcom/comcast/cim/downloads/DownloadServiceManager<TD;TT;TS;>;"
    .local p1, "files":Ljava/util/List;, "Ljava/util/List<TD;>;"
    invoke-static {}, Lcom/google/common/collect/Maps;->newHashMap()Ljava/util/HashMap;

    move-result-object v0

    .line 398
    .local v0, "completionLatches":Ljava/util/Map;, "Ljava/util/Map<TD;Ljava/util/concurrent/CountDownLatch;>;"
    iget-object v4, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->pendingDeletes:Ljava/util/Map;

    monitor-enter v4

    .line 399
    :try_start_0
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/comcast/cim/downloads/DownloadFile;

    .line 400
    .local v1, "file":Lcom/comcast/cim/downloads/DownloadFile;, "TD;"
    new-instance v2, Ljava/util/concurrent/CountDownLatch;

    const/4 v5, 0x1

    invoke-direct {v2, v5}, Ljava/util/concurrent/CountDownLatch;-><init>(I)V

    .line 401
    .local v2, "latch":Ljava/util/concurrent/CountDownLatch;
    iget-object v5, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->pendingDeletes:Ljava/util/Map;

    invoke-interface {v5, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 402
    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 404
    .end local v1    # "file":Lcom/comcast/cim/downloads/DownloadFile;, "TD;"
    .end local v2    # "latch":Ljava/util/concurrent/CountDownLatch;
    :catchall_0
    move-exception v3

    monitor-exit v4
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v3

    :cond_0
    :try_start_1
    monitor-exit v4
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 406
    iget-object v3, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->backgroundExecutor:Ljava/util/concurrent/Executor;

    new-instance v4, Lcom/comcast/cim/downloads/DownloadServiceManager$6;

    invoke-direct {v4, p0, p1}, Lcom/comcast/cim/downloads/DownloadServiceManager$6;-><init>(Lcom/comcast/cim/downloads/DownloadServiceManager;Ljava/util/List;)V

    invoke-interface {v3, v4}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 428
    iget-object v3, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->foregroundExecutor:Ljava/util/concurrent/Executor;

    new-instance v4, Lcom/comcast/cim/downloads/DownloadServiceManager$7;

    invoke-direct {v4, p0}, Lcom/comcast/cim/downloads/DownloadServiceManager$7;-><init>(Lcom/comcast/cim/downloads/DownloadServiceManager;)V

    invoke-interface {v3, v4}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 438
    return-object v0
.end method

.method protected deleteUnusedHlsFile(Lcom/penthera/virtuososdk/client/IVirtuosoHLSFile;)V
    .locals 3
    .param p1, "hlsFile"    # Lcom/penthera/virtuososdk/client/IVirtuosoHLSFile;

    .prologue
    .line 755
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager;, "Lcom/comcast/cim/downloads/DownloadServiceManager<TD;TT;TS;>;"
    invoke-static {p1}, Lorg/apache/commons/lang3/Validate;->notNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 758
    :try_start_0
    iget-object v1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->virtuosoService:Lcom/penthera/virtuososdk/client/Virtuoso;

    invoke-virtual {v1, p1}, Lcom/penthera/virtuososdk/client/Virtuoso;->delete(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V
    :try_end_0
    .catch Lcom/penthera/virtuososdk/client/ServiceException; {:try_start_0 .. :try_end_0} :catch_0

    .line 763
    :goto_0
    return-void

    .line 759
    :catch_0
    move-exception v0

    .line 760
    .local v0, "e":Lcom/penthera/virtuososdk/client/ServiceException;
    sget-object v1, Lcom/comcast/cim/downloads/DownloadServiceManager;->LOG:Lorg/slf4j/Logger;

    const-string v2, "Failed to delete Unused Virtuoso HLS file"

    invoke-interface {v1, v2, v0}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method protected downloadHlsFileWithMetadata(Ljava/lang/String;Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;Lcom/comcast/cim/downloads/DownloadMetaData;Ljava/lang/Runnable;Lcom/google/common/util/concurrent/FutureCallback;)V
    .locals 10
    .param p1, "assetId"    # Ljava/lang/String;
    .param p2, "simplePlaylist"    # Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;
    .param p3, "variantPlaylist"    # Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;
    .param p4, "alternateAudioPlaylist"    # Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;
    .param p5, "metaData"    # Lcom/comcast/cim/downloads/DownloadMetaData;
    .param p6, "extraTask"    # Ljava/lang/Runnable;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;",
            "Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;",
            "Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;",
            "Lcom/comcast/cim/downloads/DownloadMetaData;",
            "Ljava/lang/Runnable;",
            "Lcom/google/common/util/concurrent/FutureCallback",
            "<",
            "Ljava/lang/Void;",
            ">;)V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/downloads/DownloadServiceException;
        }
    .end annotation

    .prologue
    .line 766
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager;, "Lcom/comcast/cim/downloads/DownloadServiceManager<TD;TT;TS;>;"
    .local p7, "resultCallback":Lcom/google/common/util/concurrent/FutureCallback;, "Lcom/google/common/util/concurrent/FutureCallback<Ljava/lang/Void;>;"
    iget-object v9, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->backgroundExecutor:Ljava/util/concurrent/Executor;

    new-instance v0, Lcom/comcast/cim/downloads/DownloadServiceManager$18;

    move-object v1, p0

    move-object v2, p2

    move-object v3, p4

    move-object v4, p1

    move-object v5, p5

    move-object v6, p3

    move-object/from16 v7, p6

    move-object/from16 v8, p7

    invoke-direct/range {v0 .. v8}, Lcom/comcast/cim/downloads/DownloadServiceManager$18;-><init>(Lcom/comcast/cim/downloads/DownloadServiceManager;Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;Ljava/lang/String;Lcom/comcast/cim/downloads/DownloadMetaData;Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;Ljava/lang/Runnable;Lcom/google/common/util/concurrent/FutureCallback;)V

    invoke-interface {v9, v0}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 905
    return-void
.end method

.method public expireFile(Lcom/comcast/cim/downloads/DownloadFile;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TD;)V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/downloads/DownloadServiceException;
        }
    .end annotation

    .prologue
    .line 385
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager;, "Lcom/comcast/cim/downloads/DownloadServiceManager<TD;TT;TS;>;"
    .local p1, "file":Lcom/comcast/cim/downloads/DownloadFile;, "TD;"
    :try_start_0
    iget-object v1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->virtuosoService:Lcom/penthera/virtuososdk/client/Virtuoso;

    invoke-virtual {p1}, Lcom/comcast/cim/downloads/DownloadFile;->getAsset()Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/penthera/virtuososdk/client/Virtuoso;->expire(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V
    :try_end_0
    .catch Lcom/penthera/virtuososdk/client/ServiceException; {:try_start_0 .. :try_end_0} :catch_0

    .line 389
    return-void

    .line 386
    :catch_0
    move-exception v0

    .line 387
    .local v0, "e":Lcom/penthera/virtuososdk/client/ServiceException;
    new-instance v1, Lcom/comcast/cim/downloads/DownloadServiceException;

    const-string v2, "Download Service failed to expire file."

    invoke-direct {v1, v2, v0}, Lcom/comcast/cim/downloads/DownloadServiceException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
.end method

.method public getDownloadEngineStatus()Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/downloads/DownloadServiceException;
        }
    .end annotation

    .prologue
    .line 332
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager;, "Lcom/comcast/cim/downloads/DownloadServiceManager<TD;TT;TS;>;"
    :try_start_0
    iget-object v1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->virtuosoService:Lcom/penthera/virtuososdk/client/Virtuoso;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/client/Virtuoso;->status()Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;
    :try_end_0
    .catch Lcom/penthera/virtuososdk/client/ServiceException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    return-object v1

    .line 333
    :catch_0
    move-exception v0

    .line 334
    .local v0, "e":Lcom/penthera/virtuososdk/client/ServiceException;
    new-instance v1, Lcom/comcast/cim/downloads/DownloadServiceException;

    const-string v2, "Download Service failed to return Engine Status"

    invoke-direct {v1, v2, v0}, Lcom/comcast/cim/downloads/DownloadServiceException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
.end method

.method public getDownloadedFileList()Ljava/util/List;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<TD;>;"
        }
    .end annotation

    .prologue
    .line 360
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager;, "Lcom/comcast/cim/downloads/DownloadServiceManager<TD;TT;TS;>;"
    iget-object v3, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->downloadsMap:Ljava/util/Map;

    monitor-enter v3

    .line 361
    :try_start_0
    new-instance v1, Ljava/util/ArrayList;

    iget-object v2, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->downloadsMap:Ljava/util/Map;

    invoke-interface {v2}, Ljava/util/Map;->size()I

    move-result v2

    invoke-direct {v1, v2}, Ljava/util/ArrayList;-><init>(I)V

    .line 362
    .local v1, "files":Ljava/util/List;, "Ljava/util/List<TD;>;"
    iget-object v2, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->downloadsMap:Ljava/util/Map;

    invoke-interface {v2}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 363
    iget-object v4, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->pendingDeletes:Ljava/util/Map;

    monitor-enter v4
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 364
    :try_start_1
    iget-object v2, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->pendingDeletes:Ljava/util/Map;

    invoke-interface {v2}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/downloads/DownloadFile;

    .line 365
    .local v0, "deletedFile":Lcom/comcast/cim/downloads/DownloadFile;, "TD;"
    invoke-interface {v1, v0}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    goto :goto_0

    .line 367
    .end local v0    # "deletedFile":Lcom/comcast/cim/downloads/DownloadFile;, "TD;"
    :catchall_0
    move-exception v2

    monitor-exit v4
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    :try_start_2
    throw v2

    .line 369
    .end local v1    # "files":Ljava/util/List;, "Ljava/util/List<TD;>;"
    :catchall_1
    move-exception v2

    monitor-exit v3
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    throw v2

    .line 367
    .restart local v1    # "files":Ljava/util/List;, "Ljava/util/List<TD;>;"
    :cond_0
    :try_start_3
    monitor-exit v4
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 368
    :try_start_4
    monitor-exit v3
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    return-object v1
.end method

.method public getFilesList()Ljava/util/List;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<TD;>;"
        }
    .end annotation

    .prologue
    .line 343
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager;, "Lcom/comcast/cim/downloads/DownloadServiceManager<TD;TT;TS;>;"
    iget-object v3, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->queuedFilesMap:Ljava/util/Map;

    monitor-enter v3

    .line 344
    :try_start_0
    iget-object v4, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->downloadsMap:Ljava/util/Map;

    monitor-enter v4
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_2

    .line 345
    :try_start_1
    new-instance v1, Ljava/util/ArrayList;

    iget-object v2, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->downloadsMap:Ljava/util/Map;

    invoke-interface {v2}, Ljava/util/Map;->size()I

    move-result v2

    iget-object v5, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->queuedFilesMap:Ljava/util/Map;

    invoke-interface {v5}, Ljava/util/Map;->size()I

    move-result v5

    add-int/2addr v2, v5

    invoke-direct {v1, v2}, Ljava/util/ArrayList;-><init>(I)V

    .line 346
    .local v1, "files":Ljava/util/List;, "Ljava/util/List<TD;>;"
    iget-object v2, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->queuedFilesMap:Ljava/util/Map;

    invoke-interface {v2}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 347
    iget-object v2, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->downloadsMap:Ljava/util/Map;

    invoke-interface {v2}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 349
    iget-object v5, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->pendingDeletes:Ljava/util/Map;

    monitor-enter v5
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 350
    :try_start_2
    iget-object v2, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->pendingDeletes:Ljava/util/Map;

    invoke-interface {v2}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/downloads/DownloadFile;

    .line 351
    .local v0, "deletedFile":Lcom/comcast/cim/downloads/DownloadFile;, "TD;"
    invoke-interface {v1, v0}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    goto :goto_0

    .line 353
    .end local v0    # "deletedFile":Lcom/comcast/cim/downloads/DownloadFile;, "TD;"
    :catchall_0
    move-exception v2

    monitor-exit v5
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    :try_start_3
    throw v2

    .line 355
    .end local v1    # "files":Ljava/util/List;, "Ljava/util/List<TD;>;"
    :catchall_1
    move-exception v2

    monitor-exit v4
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    :try_start_4
    throw v2

    .line 356
    :catchall_2
    move-exception v2

    monitor-exit v3
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_2

    throw v2

    .line 353
    .restart local v1    # "files":Ljava/util/List;, "Ljava/util/List<TD;>;"
    :cond_0
    :try_start_5
    monitor-exit v5
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 354
    :try_start_6
    monitor-exit v4
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    :try_start_7
    monitor-exit v3
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_2

    return-object v1
.end method

.method public hasOldFiles()Z
    .locals 1

    .prologue
    .line 608
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager;, "Lcom/comcast/cim/downloads/DownloadServiceManager<TD;TT;TS;>;"
    iget-boolean v0, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->hasOldFiles:Z

    return v0
.end method

.method public isExternalStorageConnected()Z
    .locals 2

    .prologue
    .line 279
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager;, "Lcom/comcast/cim/downloads/DownloadServiceManager<TD;TT;TS;>;"
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v0

    .line 280
    .local v0, "file":Ljava/io/File;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/io/File;->canWrite()Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public isFileListReady()Z
    .locals 1

    .prologue
    .line 339
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager;, "Lcom/comcast/cim/downloads/DownloadServiceManager<TD;TT;TS;>;"
    iget-boolean v0, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->initialQueuedFilesMapRetrieved:Z

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->initialDownloadFilesMapRetrieved:Z

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected onDownloadEngineStatusChanged(Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;)V
    .locals 2
    .param p1, "status"    # Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;

    .prologue
    .line 575
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager;, "Lcom/comcast/cim/downloads/DownloadServiceManager<TD;TT;TS;>;"
    iget-object v0, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->foregroundExecutor:Ljava/util/concurrent/Executor;

    new-instance v1, Lcom/comcast/cim/downloads/DownloadServiceManager$14;

    invoke-direct {v1, p0, p1}, Lcom/comcast/cim/downloads/DownloadServiceManager$14;-><init>(Lcom/comcast/cim/downloads/DownloadServiceManager;Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 585
    invoke-direct {p0, p1}, Lcom/comcast/cim/downloads/DownloadServiceManager;->handleDownloadEngineStatusChange(Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;)V

    .line 586
    return-void
.end method

.method protected onDownloadServiceConnected()V
    .locals 2

    .prologue
    .line 497
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager;, "Lcom/comcast/cim/downloads/DownloadServiceManager<TD;TT;TS;>;"
    iget-object v0, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->foregroundExecutor:Ljava/util/concurrent/Executor;

    new-instance v1, Lcom/comcast/cim/downloads/DownloadServiceManager$8;

    invoke-direct {v1, p0}, Lcom/comcast/cim/downloads/DownloadServiceManager$8;-><init>(Lcom/comcast/cim/downloads/DownloadServiceManager;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 506
    return-void
.end method

.method protected onFileDeleted(Lcom/comcast/cim/downloads/DownloadFile;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TD;)V"
        }
    .end annotation

    .prologue
    .line 557
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager;, "Lcom/comcast/cim/downloads/DownloadServiceManager<TD;TT;TS;>;"
    .local p1, "file":Lcom/comcast/cim/downloads/DownloadFile;, "TD;"
    iget-object v1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->volatileDownloadFileCache:Ljava/util/LinkedHashMap;

    monitor-enter v1

    .line 558
    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->volatileDownloadFileCache:Ljava/util/LinkedHashMap;

    invoke-virtual {p1}, Lcom/comcast/cim/downloads/DownloadFile;->getAsset()Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    move-result-object v2

    invoke-interface {v2}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->uuid()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/util/LinkedHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 559
    monitor-exit v1

    .line 560
    return-void

    .line 559
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method protected onFileDownloadError(Lcom/comcast/cim/downloads/DownloadFile;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TD;)V"
        }
    .end annotation

    .prologue
    .line 545
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager;, "Lcom/comcast/cim/downloads/DownloadServiceManager<TD;TT;TS;>;"
    .local p1, "file":Lcom/comcast/cim/downloads/DownloadFile;, "TD;"
    iget-object v0, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->foregroundExecutor:Ljava/util/concurrent/Executor;

    new-instance v1, Lcom/comcast/cim/downloads/DownloadServiceManager$12;

    invoke-direct {v1, p0, p1}, Lcom/comcast/cim/downloads/DownloadServiceManager$12;-><init>(Lcom/comcast/cim/downloads/DownloadServiceManager;Lcom/comcast/cim/downloads/DownloadFile;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 554
    return-void
.end method

.method protected onFileDownloadFinished(Lcom/comcast/cim/downloads/DownloadFile;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TD;)V"
        }
    .end annotation

    .prologue
    .line 521
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager;, "Lcom/comcast/cim/downloads/DownloadServiceManager<TD;TT;TS;>;"
    .local p1, "file":Lcom/comcast/cim/downloads/DownloadFile;, "TD;"
    iget-object v0, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->foregroundExecutor:Ljava/util/concurrent/Executor;

    new-instance v1, Lcom/comcast/cim/downloads/DownloadServiceManager$10;

    invoke-direct {v1, p0, p1}, Lcom/comcast/cim/downloads/DownloadServiceManager$10;-><init>(Lcom/comcast/cim/downloads/DownloadServiceManager;Lcom/comcast/cim/downloads/DownloadFile;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 530
    return-void
.end method

.method protected onFileDownloadStarted(Lcom/comcast/cim/downloads/DownloadFile;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TD;)V"
        }
    .end annotation

    .prologue
    .line 509
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager;, "Lcom/comcast/cim/downloads/DownloadServiceManager<TD;TT;TS;>;"
    .local p1, "file":Lcom/comcast/cim/downloads/DownloadFile;, "TD;"
    iget-object v0, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->foregroundExecutor:Ljava/util/concurrent/Executor;

    new-instance v1, Lcom/comcast/cim/downloads/DownloadServiceManager$9;

    invoke-direct {v1, p0, p1}, Lcom/comcast/cim/downloads/DownloadServiceManager$9;-><init>(Lcom/comcast/cim/downloads/DownloadServiceManager;Lcom/comcast/cim/downloads/DownloadFile;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 518
    return-void
.end method

.method protected onFileListUpdated()V
    .locals 2

    .prologue
    .line 563
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager;, "Lcom/comcast/cim/downloads/DownloadServiceManager<TD;TT;TS;>;"
    iget-object v0, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->foregroundExecutor:Ljava/util/concurrent/Executor;

    new-instance v1, Lcom/comcast/cim/downloads/DownloadServiceManager$13;

    invoke-direct {v1, p0}, Lcom/comcast/cim/downloads/DownloadServiceManager$13;-><init>(Lcom/comcast/cim/downloads/DownloadServiceManager;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 572
    return-void
.end method

.method protected onFileProgressUpdated(Lcom/comcast/cim/downloads/DownloadFile;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TD;)V"
        }
    .end annotation

    .prologue
    .line 533
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager;, "Lcom/comcast/cim/downloads/DownloadServiceManager<TD;TT;TS;>;"
    .local p1, "file":Lcom/comcast/cim/downloads/DownloadFile;, "TD;"
    iget-object v0, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->foregroundExecutor:Ljava/util/concurrent/Executor;

    new-instance v1, Lcom/comcast/cim/downloads/DownloadServiceManager$11;

    invoke-direct {v1, p0, p1}, Lcom/comcast/cim/downloads/DownloadServiceManager$11;-><init>(Lcom/comcast/cim/downloads/DownloadServiceManager;Lcom/comcast/cim/downloads/DownloadFile;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 542
    return-void
.end method

.method public onUserChanged(Lcom/comcast/cim/model/user/User;Lcom/comcast/cim/model/user/service/UserSettings;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;TS;)V"
        }
    .end annotation

    .prologue
    .line 962
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager;, "Lcom/comcast/cim/downloads/DownloadServiceManager<TD;TT;TS;>;"
    .local p1, "newUser":Lcom/comcast/cim/model/user/User;, "TT;"
    .local p2, "settings":Lcom/comcast/cim/model/user/service/UserSettings;, "TS;"
    return-void
.end method

.method public onUserLoaded(Lcom/comcast/cim/model/user/User;Lcom/comcast/cim/model/user/service/UserSettings;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;TS;)V"
        }
    .end annotation

    .prologue
    .line 911
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager;, "Lcom/comcast/cim/downloads/DownloadServiceManager<TD;TT;TS;>;"
    .local p1, "user":Lcom/comcast/cim/model/user/User;, "TT;"
    .local p2, "settings":Lcom/comcast/cim/model/user/service/UserSettings;, "TS;"
    return-void
.end method

.method public onUserLoggedIn(Lcom/comcast/cim/model/user/User;Lcom/comcast/cim/model/user/service/UserSettings;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;TS;)V"
        }
    .end annotation

    .prologue
    .line 916
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager;, "Lcom/comcast/cim/downloads/DownloadServiceManager<TD;TT;TS;>;"
    .local p1, "user":Lcom/comcast/cim/model/user/User;, "TT;"
    .local p2, "settings":Lcom/comcast/cim/model/user/service/UserSettings;, "TS;"
    :try_start_0
    iget-object v2, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->sharedPreferences:Landroid/content/SharedPreferences;

    const-string v3, "PausedBySignout"

    invoke-interface {v2, v3}, Landroid/content/SharedPreferences;->contains(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 917
    sget-object v2, Lcom/comcast/cim/downloads/DownloadServiceManager;->LOG:Lorg/slf4j/Logger;

    const-string v3, "Signed into the app, resuming downloads!"

    invoke-interface {v2, v3}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 918
    invoke-virtual {p0}, Lcom/comcast/cim/downloads/DownloadServiceManager;->resumeDownloading()V

    .line 919
    iget-object v2, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->sharedPreferences:Landroid/content/SharedPreferences;

    invoke-interface {v2}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    .line 920
    .local v1, "spEdit":Landroid/content/SharedPreferences$Editor;
    const-string v2, "PausedBySignout"

    invoke-interface {v1, v2}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 921
    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->commit()Z
    :try_end_0
    .catch Lcom/comcast/cim/downloads/DownloadServiceException; {:try_start_0 .. :try_end_0} :catch_0

    .line 927
    .end local v1    # "spEdit":Landroid/content/SharedPreferences$Editor;
    :cond_0
    :goto_0
    return-void

    .line 923
    :catch_0
    move-exception v0

    .line 925
    .local v0, "e":Lcom/comcast/cim/downloads/DownloadServiceException;
    sget-object v2, Lcom/comcast/cim/downloads/DownloadServiceManager;->LOG:Lorg/slf4j/Logger;

    const-string v3, "Failed to Resume Downloading for Sign-In!"

    invoke-interface {v2, v3}, Lorg/slf4j/Logger;->error(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onUserLoggedOut()V
    .locals 4

    .prologue
    .line 944
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager;, "Lcom/comcast/cim/downloads/DownloadServiceManager<TD;TT;TS;>;"
    sget-object v2, Lcom/comcast/cim/downloads/DownloadServiceManager;->LOG:Lorg/slf4j/Logger;

    const-string v3, "onUserLoggedOut"

    invoke-interface {v2, v3}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 946
    :try_start_0
    invoke-virtual {p0}, Lcom/comcast/cim/downloads/DownloadServiceManager;->getDownloadEngineStatus()Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;

    move-result-object v2

    invoke-interface {v2}, Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;->status()Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    move-result-object v2

    sget-object v3, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Paused:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    if-eq v2, v3, :cond_0

    .line 947
    sget-object v2, Lcom/comcast/cim/downloads/DownloadServiceManager;->LOG:Lorg/slf4j/Logger;

    const-string v3, "Signed Out of the app, pausing downloads!"

    invoke-interface {v2, v3}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 948
    invoke-virtual {p0}, Lcom/comcast/cim/downloads/DownloadServiceManager;->pauseDownloading()V

    .line 949
    iget-object v2, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->sharedPreferences:Landroid/content/SharedPreferences;

    invoke-interface {v2}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    .line 950
    .local v1, "spEdit":Landroid/content/SharedPreferences$Editor;
    const-string v2, "PausedBySignout"

    const/4 v3, 0x1

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 951
    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->commit()Z
    :try_end_0
    .catch Lcom/comcast/cim/downloads/DownloadServiceException; {:try_start_0 .. :try_end_0} :catch_0

    .line 957
    .end local v1    # "spEdit":Landroid/content/SharedPreferences$Editor;
    :cond_0
    :goto_0
    return-void

    .line 953
    :catch_0
    move-exception v0

    .line 954
    .local v0, "e":Lcom/comcast/cim/downloads/DownloadServiceException;
    sget-object v2, Lcom/comcast/cim/downloads/DownloadServiceManager;->LOG:Lorg/slf4j/Logger;

    const-string v3, "Failed to Pause Downloading for Sign-Out!"

    invoke-interface {v2, v3}, Lorg/slf4j/Logger;->error(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public declared-synchronized pauseDownloading()V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/downloads/DownloadServiceException;
        }
    .end annotation

    .prologue
    .line 471
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager;, "Lcom/comcast/cim/downloads/DownloadServiceManager<TD;TT;TS;>;"
    monitor-enter p0

    :try_start_0
    iget-boolean v1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->waitingForResume:Z

    if-eqz v1, :cond_1

    .line 472
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->pauseCalled:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 485
    :cond_0
    :goto_0
    monitor-exit p0

    return-void

    .line 477
    :cond_1
    const/4 v1, 0x0

    :try_start_1
    iput-boolean v1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->pauseCalled:Z

    .line 478
    iget-boolean v1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->waitingForPause:Z

    if-nez v1, :cond_0

    .line 479
    iget-object v1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->virtuosoService:Lcom/penthera/virtuososdk/client/Virtuoso;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/client/Virtuoso;->pauseDownloads()V

    .line 480
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->waitingForPause:Z
    :try_end_1
    .catch Lcom/penthera/virtuososdk/client/ServiceException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 482
    :catch_0
    move-exception v0

    .line 483
    .local v0, "e":Lcom/penthera/virtuososdk/client/ServiceException;
    :try_start_2
    new-instance v1, Lcom/comcast/cim/downloads/DownloadServiceException;

    const-string v2, "Download Service failed to pause downloading."

    invoke-direct {v1, v2, v0}, Lcom/comcast/cim/downloads/DownloadServiceException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 471
    .end local v0    # "e":Lcom/penthera/virtuososdk/client/ServiceException;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public removeDownloadServiceListener(Lcom/comcast/cim/downloads/DownloadServiceListener;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/downloads/DownloadServiceListener",
            "<TD;>;)V"
        }
    .end annotation

    .prologue
    .line 492
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager;, "Lcom/comcast/cim/downloads/DownloadServiceManager<TD;TT;TS;>;"
    .local p1, "listener":Lcom/comcast/cim/downloads/DownloadServiceListener;, "Lcom/comcast/cim/downloads/DownloadServiceListener<TD;>;"
    iget-object v0, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->listeners:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 493
    return-void
.end method

.method public declared-synchronized resumeDownloading()V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/downloads/DownloadServiceException;
        }
    .end annotation

    .prologue
    .line 454
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager;, "Lcom/comcast/cim/downloads/DownloadServiceManager<TD;TT;TS;>;"
    monitor-enter p0

    :try_start_0
    iget-boolean v1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->waitingForPause:Z

    if-eqz v1, :cond_1

    .line 455
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->resumeCalled:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 468
    :cond_0
    :goto_0
    monitor-exit p0

    return-void

    .line 460
    :cond_1
    const/4 v1, 0x0

    :try_start_1
    iput-boolean v1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->resumeCalled:Z

    .line 461
    iget-boolean v1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->waitingForResume:Z

    if-nez v1, :cond_0

    .line 462
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->waitingForResume:Z

    .line 463
    iget-object v1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->virtuosoService:Lcom/penthera/virtuososdk/client/Virtuoso;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/client/Virtuoso;->resumeDownloads()V
    :try_end_1
    .catch Lcom/penthera/virtuososdk/client/ServiceException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 465
    :catch_0
    move-exception v0

    .line 466
    .local v0, "e":Lcom/penthera/virtuososdk/client/ServiceException;
    :try_start_2
    new-instance v1, Lcom/comcast/cim/downloads/DownloadServiceException;

    const-string v2, "Download Service failed to resume downloading."

    invoke-direct {v1, v2, v0}, Lcom/comcast/cim/downloads/DownloadServiceException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 454
    .end local v0    # "e":Lcom/penthera/virtuososdk/client/ServiceException;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public setCellularDataThreshold(D)V
    .locals 3
    .param p1, "threshold"    # D
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/downloads/DownloadServiceException;
        }
    .end annotation

    .prologue
    .line 285
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager;, "Lcom/comcast/cim/downloads/DownloadServiceManager<TD;TT;TS;>;"
    :try_start_0
    iget-object v1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->virtuosoService:Lcom/penthera/virtuososdk/client/Virtuoso;

    invoke-virtual {v1, p1, p2}, Lcom/penthera/virtuososdk/client/Virtuoso;->overrideCellularDataQuota(D)V
    :try_end_0
    .catch Lcom/penthera/virtuososdk/client/ServiceException; {:try_start_0 .. :try_end_0} :catch_0

    .line 289
    return-void

    .line 286
    :catch_0
    move-exception v0

    .line 287
    .local v0, "e":Lcom/penthera/virtuososdk/client/ServiceException;
    new-instance v1, Lcom/comcast/cim/downloads/DownloadServiceException;

    const-string v2, "Download Service failed to change Cellular Data Setting"

    invoke-direct {v1, v2, v0}, Lcom/comcast/cim/downloads/DownloadServiceException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
.end method

.method public showCrashDialog(Landroid/content/Context;Ljava/lang/Exception;)V
    .locals 4
    .param p1, "androidContext"    # Landroid/content/Context;
    .param p2, "e"    # Ljava/lang/Exception;

    .prologue
    .line 300
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager;, "Lcom/comcast/cim/downloads/DownloadServiceManager<TD;TT;TS;>;"
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    .line 301
    .local v0, "resources":Landroid/content/res/Resources;
    new-instance v1, Landroid/app/AlertDialog$Builder;

    invoke-direct {v1, p1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    sget v2, Lcom/comcast/cim/android/R$string;->download_service_restart_title:I

    .line 302
    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v1

    sget v2, Lcom/comcast/cim/android/R$string;->download_service_restart_message:I

    .line 303
    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v1

    sget v2, Lcom/comcast/cim/android/R$string;->dlg_btn_ok:I

    .line 304
    invoke-virtual {p1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lcom/comcast/cim/downloads/DownloadServiceManager$5;

    invoke-direct {v3, p0, p2}, Lcom/comcast/cim/downloads/DownloadServiceManager$5;-><init>(Lcom/comcast/cim/downloads/DownloadServiceManager;Ljava/lang/Exception;)V

    invoke-virtual {v1, v2, v3}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v1

    const/4 v2, 0x0

    .line 310
    invoke-virtual {v1, v2}, Landroid/app/AlertDialog$Builder;->setCancelable(Z)Landroid/app/AlertDialog$Builder;

    move-result-object v1

    .line 311
    invoke-virtual {v1}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    .line 312
    return-void
.end method

.method public startDownloadImmediately(Lcom/comcast/cim/downloads/DownloadFile;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TD;)V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/downloads/DownloadServiceException;
        }
    .end annotation

    .prologue
    .line 447
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager;, "Lcom/comcast/cim/downloads/DownloadServiceManager<TD;TT;TS;>;"
    .local p1, "file":Lcom/comcast/cim/downloads/DownloadFile;, "TD;"
    :try_start_0
    iget-object v1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->virtuosoService:Lcom/penthera/virtuososdk/client/Virtuoso;

    invoke-virtual {p1}, Lcom/comcast/cim/downloads/DownloadFile;->getAsset()Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Lcom/penthera/virtuososdk/client/Virtuoso;->move(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;I)V
    :try_end_0
    .catch Lcom/penthera/virtuososdk/client/ServiceException; {:try_start_0 .. :try_end_0} :catch_0

    .line 451
    return-void

    .line 448
    :catch_0
    move-exception v0

    .line 449
    .local v0, "e":Lcom/penthera/virtuososdk/client/ServiceException;
    new-instance v1, Lcom/comcast/cim/downloads/DownloadServiceException;

    const-string v2, "Download Service failed to move the file to the top of the queue."

    invoke-direct {v1, v2, v0}, Lcom/comcast/cim/downloads/DownloadServiceException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
.end method

.method public updateFileMetadata(Lcom/comcast/cim/downloads/DownloadFile;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TD;)V"
        }
    .end annotation

    .prologue
    .line 378
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager;, "Lcom/comcast/cim/downloads/DownloadServiceManager<TD;TT;TS;>;"
    .local p1, "file":Lcom/comcast/cim/downloads/DownloadFile;, "TD;"
    invoke-virtual {p1}, Lcom/comcast/cim/downloads/DownloadFile;->getAsset()Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    move-result-object v0

    .line 379
    .local v0, "virtuosoAsset":Lcom/penthera/virtuososdk/client/IVirtuosoAsset;
    iget-object v1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->downloadMetaDataSerializer:Lcom/comcast/cim/utils/JsonSerializer;

    invoke-virtual {p1}, Lcom/comcast/cim/downloads/DownloadFile;->getDownloadMetaData()Lcom/comcast/cim/downloads/DownloadMetaData;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/comcast/cim/utils/JsonSerializer;->serialize(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->setMetadata(Ljava/lang/String;)V

    .line 380
    iget-object v1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->virtuosoService:Lcom/penthera/virtuososdk/client/Virtuoso;

    invoke-virtual {v1, v0}, Lcom/penthera/virtuososdk/client/Virtuoso;->update(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)Z

    .line 381
    return-void
.end method

.method public waitForInitialization(J)V
    .locals 3
    .param p1, "timeoutInMillis"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/downloads/DownloadServiceException;
        }
    .end annotation

    .prologue
    .line 320
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager;, "Lcom/comcast/cim/downloads/DownloadServiceManager<TD;TT;TS;>;"
    const/4 v0, 0x0

    .line 322
    .local v0, "successful":Z
    :try_start_0
    iget-object v1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager;->initializationLatch:Ljava/util/concurrent/CountDownLatch;

    sget-object v2, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v1, p1, p2, v2}, Ljava/util/concurrent/CountDownLatch;->await(JLjava/util/concurrent/TimeUnit;)Z
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    .line 325
    :goto_0
    if-nez v0, :cond_0

    .line 326
    new-instance v1, Lcom/comcast/cim/downloads/DownloadServiceException;

    const-string v2, "Service connection failed"

    invoke-direct {v1, v2}, Lcom/comcast/cim/downloads/DownloadServiceException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 328
    :cond_0
    return-void

    .line 323
    :catch_0
    move-exception v1

    goto :goto_0
.end method
