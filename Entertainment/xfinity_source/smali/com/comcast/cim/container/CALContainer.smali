.class public abstract Lcom/comcast/cim/container/CALContainer;
.super Ljava/lang/Object;
.source "CALContainer.java"


# static fields
.field private static final LOG:Lorg/slf4j/Logger;

.field private static instance:Lcom/comcast/cim/container/CALContainer;


# instance fields
.field private accessibilityManager:Landroid/view/accessibility/AccessibilityManager;

.field private accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

.field private alternateInterfaceUtil:Lcom/comcast/cim/android/accessibility/AlternateInterfaceUtil;

.field private analyticsTaskConverter:Lcom/squareup/tape/FileObjectQueue$Converter;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/squareup/tape/FileObjectQueue$Converter",
            "<",
            "Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;",
            ">;"
        }
    .end annotation
.end field

.field private analyticsTaskQueue:Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskQueue;

.field private analyticsTaskQueueFile:Ljava/io/File;

.field private appLauncher:Lcom/comcast/cim/utils/AppLauncher;

.field private authenticationClient:Lcom/comcast/cim/android/authentication/AuthenticationClient;

.field private currentUser:Lcom/comcast/cim/model/user/CurrentUser;

.field private defaultRevalidationPolicy:Lcom/comcast/cim/cmasl/taskexecutor/policy/MinimumIntervalRevalidationPolicy;

.field private downloadUserAgent:Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeader;

.field private errorDialogFactory:Lcom/comcast/cim/android/view/common/ErrorDialogFactory;

.field private errorFormatter:Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;

.field private fileCache:Lcom/comcast/cim/cmasl/cachelib/PermanentFileCache;

.field protected foxAnalyticsLogger:Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;

.field private gracefullyDegradingMinVersionCheckCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private hlsDownloadClient:Lcom/comcast/cim/cmasl/hls/HlsDownloadClient;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/hls/HlsDownloadClient",
            "<",
            "Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;",
            ">;"
        }
    .end annotation
.end field

.field private httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

.field private internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

.field private jsonSerializer:Lcom/comcast/cim/utils/JsonSerializer;

.field private minVersionCheckCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private objectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

.field private requestProviderFactory:Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory",
            "<",
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<",
            "Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;",
            ">;>;"
        }
    .end annotation
.end field

.field private signInListener:Lcom/comcast/cim/android/authentication/SignInListener;

.field private softKeyboard:Lcom/comcast/cim/cmasl/android/util/system/SoftKeyboard;

.field protected splunkLogger:Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;

.field private talkDelegateFactory:Lcom/comcast/cim/android/accessibility/TalkDelegateFactory;

.field private taskExecutorFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

.field private uiThreadExecutor:Lcom/comcast/cim/android/concurrent/UIThreadExecutor;

.field private uiUtil:Lcom/comcast/cim/utils/UIUtil;

.field private userAgent:Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeader;

.field private versionCode:Ljava/lang/Integer;

.field private xipRequestProviderFactory:Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory",
            "<",
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<",
            "Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;",
            ">;>;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 109
    const-class v0, Lcom/comcast/cim/container/CALContainer;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/comcast/cim/container/CALContainer;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 107
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private declared-synchronized getAnalyticsTaskConverter()Lcom/squareup/tape/FileObjectQueue$Converter;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/squareup/tape/FileObjectQueue$Converter",
            "<",
            "Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;",
            ">;"
        }
    .end annotation

    .prologue
    .line 472
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/CALContainer;->analyticsTaskConverter:Lcom/squareup/tape/FileObjectQueue$Converter;

    if-nez v0, :cond_0

    .line 473
    new-instance v0, Lcom/comcast/cim/analytics/JacksonConverter;

    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getObjectMapper()Lcom/fasterxml/jackson/databind/ObjectMapper;

    move-result-object v1

    const-class v2, Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;

    invoke-direct {v0, v1, v2}, Lcom/comcast/cim/analytics/JacksonConverter;-><init>(Lcom/fasterxml/jackson/databind/ObjectMapper;Ljava/lang/Class;)V

    iput-object v0, p0, Lcom/comcast/cim/container/CALContainer;->analyticsTaskConverter:Lcom/squareup/tape/FileObjectQueue$Converter;

    .line 475
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/CALContainer;->analyticsTaskConverter:Lcom/squareup/tape/FileObjectQueue$Converter;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 472
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method private declared-synchronized getAnalyticsTaskQueueDelegate()Lcom/squareup/tape/ObjectQueue;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/squareup/tape/ObjectQueue",
            "<",
            "Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;",
            ">;"
        }
    .end annotation

    .prologue
    .line 446
    monitor-enter p0

    const/4 v5, 0x0

    .line 447
    .local v5, "retryCount":I
    const/4 v0, 0x1

    .line 448
    .local v0, "MAX_RETRIES":I
    const/4 v1, 0x0

    .local v1, "analyticsTaskQueueDelegate":Lcom/squareup/tape/ObjectQueue;, "Lcom/squareup/tape/ObjectQueue<Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;>;"
    move-object v2, v1

    .line 449
    .end local v1    # "analyticsTaskQueueDelegate":Lcom/squareup/tape/ObjectQueue;, "Lcom/squareup/tape/ObjectQueue<Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;>;"
    .local v2, "analyticsTaskQueueDelegate":Lcom/squareup/tape/ObjectQueue;, "Lcom/squareup/tape/ObjectQueue<Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;>;"
    :goto_0
    if-nez v2, :cond_1

    const/4 v6, 0x1

    if-gt v5, v6, :cond_1

    .line 451
    :try_start_0
    new-instance v1, Lcom/squareup/tape/FileObjectQueue;

    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getAnalyticsTaskQueueFile()Ljava/io/File;

    move-result-object v6

    invoke-direct {p0}, Lcom/comcast/cim/container/CALContainer;->getAnalyticsTaskConverter()Lcom/squareup/tape/FileObjectQueue$Converter;

    move-result-object v7

    invoke-direct {v1, v6, v7}, Lcom/squareup/tape/FileObjectQueue;-><init>(Ljava/io/File;Lcom/squareup/tape/FileObjectQueue$Converter;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .end local v2    # "analyticsTaskQueueDelegate":Lcom/squareup/tape/ObjectQueue;, "Lcom/squareup/tape/ObjectQueue<Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;>;"
    .restart local v1    # "analyticsTaskQueueDelegate":Lcom/squareup/tape/ObjectQueue;, "Lcom/squareup/tape/ObjectQueue<Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;>;"
    move-object v2, v1

    .line 459
    .end local v1    # "analyticsTaskQueueDelegate":Lcom/squareup/tape/ObjectQueue;, "Lcom/squareup/tape/ObjectQueue<Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;>;"
    .restart local v2    # "analyticsTaskQueueDelegate":Lcom/squareup/tape/ObjectQueue;, "Lcom/squareup/tape/ObjectQueue<Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;>;"
    goto :goto_0

    .line 452
    :catch_0
    move-exception v3

    .line 453
    .local v3, "e":Ljava/io/IOException;
    :try_start_1
    sget-object v6, Lcom/comcast/cim/container/CALContainer;->LOG:Lorg/slf4j/Logger;

    const-string v7, "Failed to load the analytics queue! Wipe it and try again!"

    invoke-interface {v6, v7}, Lorg/slf4j/Logger;->error(Ljava/lang/String;)V

    .line 454
    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getAnalyticsTaskQueueFile()Ljava/io/File;

    move-result-object v4

    .line 455
    .local v4, "file":Ljava/io/File;
    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v6

    if-eqz v6, :cond_0

    .line 456
    invoke-virtual {v4}, Ljava/io/File;->delete()Z

    .line 458
    :cond_0
    add-int/lit8 v5, v5, 0x1

    .line 459
    goto :goto_0

    .line 462
    .end local v3    # "e":Ljava/io/IOException;
    .end local v4    # "file":Ljava/io/File;
    :cond_1
    if-nez v2, :cond_2

    .line 463
    sget-object v6, Lcom/comcast/cim/container/CALContainer;->LOG:Lorg/slf4j/Logger;

    const-string v7, "Falling back to an in-memory object queue.  some analytics may be lost on crashes and restarts"

    invoke-interface {v6, v7}, Lorg/slf4j/Logger;->error(Ljava/lang/String;)V

    .line 465
    new-instance v1, Lcom/squareup/tape/InMemoryObjectQueue;

    invoke-direct {v1}, Lcom/squareup/tape/InMemoryObjectQueue;-><init>()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 468
    .end local v2    # "analyticsTaskQueueDelegate":Lcom/squareup/tape/ObjectQueue;, "Lcom/squareup/tape/ObjectQueue<Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;>;"
    .restart local v1    # "analyticsTaskQueueDelegate":Lcom/squareup/tape/ObjectQueue;, "Lcom/squareup/tape/ObjectQueue<Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;>;"
    :goto_1
    monitor-exit p0

    return-object v1

    .line 446
    .end local v1    # "analyticsTaskQueueDelegate":Lcom/squareup/tape/ObjectQueue;, "Lcom/squareup/tape/ObjectQueue<Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;>;"
    .restart local v2    # "analyticsTaskQueueDelegate":Lcom/squareup/tape/ObjectQueue;, "Lcom/squareup/tape/ObjectQueue<Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;>;"
    :catchall_0
    move-exception v6

    monitor-exit p0

    throw v6

    :cond_2
    move-object v1, v2

    .end local v2    # "analyticsTaskQueueDelegate":Lcom/squareup/tape/ObjectQueue;, "Lcom/squareup/tape/ObjectQueue<Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;>;"
    .restart local v1    # "analyticsTaskQueueDelegate":Lcom/squareup/tape/ObjectQueue;, "Lcom/squareup/tape/ObjectQueue<Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;>;"
    goto :goto_1
.end method

.method public static declared-synchronized getInstance()Lcom/comcast/cim/container/CALContainer;
    .locals 2
    .annotation runtime Lcom/comcast/cim/container/ContainerTestIgnore;
    .end annotation

    .prologue
    .line 164
    const-class v0, Lcom/comcast/cim/container/CALContainer;

    monitor-enter v0

    :try_start_0
    sget-object v1, Lcom/comcast/cim/container/CALContainer;->instance:Lcom/comcast/cim/container/CALContainer;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v0

    return-object v1

    :catchall_0
    move-exception v1

    monitor-exit v0

    throw v1
.end method

.method protected static declared-synchronized setInstance(Lcom/comcast/cim/container/CALContainer;)V
    .locals 2
    .param p0, "instance"    # Lcom/comcast/cim/container/CALContainer;

    .prologue
    .line 168
    const-class v0, Lcom/comcast/cim/container/CALContainer;

    monitor-enter v0

    :try_start_0
    sput-object p0, Lcom/comcast/cim/container/CALContainer;->instance:Lcom/comcast/cim/container/CALContainer;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 169
    monitor-exit v0

    return-void

    .line 168
    :catchall_0
    move-exception v1

    monitor-exit v0

    throw v1
.end method


# virtual methods
.method public declared-synchronized getAccessibilityManager()Landroid/view/accessibility/AccessibilityManager;
    .locals 2

    .prologue
    .line 359
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/CALContainer;->accessibilityManager:Landroid/view/accessibility/AccessibilityManager;

    if-nez v0, :cond_0

    .line 360
    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getApplication()Landroid/app/Application;

    move-result-object v0

    const-string v1, "accessibility"

    invoke-virtual {v0, v1}, Landroid/app/Application;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/accessibility/AccessibilityManager;

    iput-object v0, p0, Lcom/comcast/cim/container/CALContainer;->accessibilityManager:Landroid/view/accessibility/AccessibilityManager;

    .line 362
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/CALContainer;->accessibilityManager:Landroid/view/accessibility/AccessibilityManager;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 359
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getAccessibilityUtil()Lcom/comcast/cim/android/accessibility/AccessibilityUtil;
    .locals 2

    .prologue
    .line 334
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/CALContainer;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    if-nez v0, :cond_0

    .line 335
    new-instance v0, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getAccessibilityManager()Landroid/view/accessibility/AccessibilityManager;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;-><init>(Landroid/view/accessibility/AccessibilityManager;)V

    iput-object v0, p0, Lcom/comcast/cim/container/CALContainer;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    .line 338
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/CALContainer;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 334
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getAlternateInterfaceUtil()Lcom/comcast/cim/android/accessibility/AlternateInterfaceUtil;
    .locals 1

    .prologue
    .line 343
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/CALContainer;->alternateInterfaceUtil:Lcom/comcast/cim/android/accessibility/AlternateInterfaceUtil;

    if-nez v0, :cond_0

    .line 344
    new-instance v0, Lcom/comcast/cim/android/accessibility/AlternateInterfaceUtil;

    invoke-direct {v0}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceUtil;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/container/CALContainer;->alternateInterfaceUtil:Lcom/comcast/cim/android/accessibility/AlternateInterfaceUtil;

    .line 347
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/CALContainer;->alternateInterfaceUtil:Lcom/comcast/cim/android/accessibility/AlternateInterfaceUtil;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 343
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method protected abstract getAnalyticsServiceClass()Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/lang/Class",
            "<+",
            "Lcom/comcast/cim/cmasl/analytics/AnalyticsService;",
            ">;"
        }
    .end annotation
.end method

.method public declared-synchronized getAnalyticsTaskQueue()Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskQueue;
    .locals 7
    .annotation runtime Lcom/comcast/cim/container/ContainerTestIgnore;
    .end annotation

    .prologue
    .line 425
    monitor-enter p0

    :try_start_0
    iget-object v3, p0, Lcom/comcast/cim/container/CALContainer;->analyticsTaskQueue:Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskQueue;

    if-nez v3, :cond_0

    .line 426
    new-instance v1, Lcom/comcast/cim/cmasl/apachehttp/service/DefaultHttpService;

    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getHttpClient()Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    move-result-object v3

    invoke-direct {v1, v3}, Lcom/comcast/cim/cmasl/apachehttp/service/DefaultHttpService;-><init>(Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;)V

    .line 427
    .local v1, "httpService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;Lcom/comcast/cim/cmasl/http/request/RequestProvider<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;>;>;"
    new-instance v2, Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory;

    new-instance v3, Lcom/comcast/cim/container/CALContainer$3;

    invoke-direct {v3, p0}, Lcom/comcast/cim/container/CALContainer$3;-><init>(Lcom/comcast/cim/container/CALContainer;)V

    invoke-direct {v2, v1, v3}, Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory;-><init>(Lcom/comcast/cim/cmasl/http/service/HttpService;Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;)V

    .line 438
    .local v2, "senderFactory":Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory;
    new-instance v0, Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskInjector;

    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getTaskExecutorFactory()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    move-result-object v3

    invoke-direct {v0, v2, v3}, Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskInjector;-><init>(Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory;Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;)V

    .line 439
    .local v0, "analyticsTaskInjector":Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskInjector;
    new-instance v3, Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskQueue;

    invoke-direct {p0}, Lcom/comcast/cim/container/CALContainer;->getAnalyticsTaskQueueDelegate()Lcom/squareup/tape/ObjectQueue;

    move-result-object v4

    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getApplication()Landroid/app/Application;

    move-result-object v5

    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getAnalyticsServiceClass()Ljava/lang/Class;

    move-result-object v6

    invoke-direct {v3, v4, v0, v5, v6}, Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskQueue;-><init>(Lcom/squareup/tape/ObjectQueue;Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskInjector;Landroid/content/Context;Ljava/lang/Class;)V

    iput-object v3, p0, Lcom/comcast/cim/container/CALContainer;->analyticsTaskQueue:Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskQueue;

    .line 442
    .end local v0    # "analyticsTaskInjector":Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskInjector;
    .end local v1    # "httpService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;Lcom/comcast/cim/cmasl/http/request/RequestProvider<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;>;>;"
    .end local v2    # "senderFactory":Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory;
    :cond_0
    iget-object v3, p0, Lcom/comcast/cim/container/CALContainer;->analyticsTaskQueue:Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskQueue;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v3

    .line 425
    :catchall_0
    move-exception v3

    monitor-exit p0

    throw v3
.end method

.method public declared-synchronized getAnalyticsTaskQueueFile()Ljava/io/File;
    .locals 3
    .annotation runtime Lcom/comcast/cim/container/ContainerTestIgnore;
    .end annotation

    .prologue
    .line 480
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/CALContainer;->analyticsTaskQueueFile:Ljava/io/File;

    if-nez v0, :cond_0

    .line 481
    new-instance v0, Ljava/io/File;

    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getApplication()Landroid/app/Application;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/Application;->getFilesDir()Ljava/io/File;

    move-result-object v1

    const-string v2, "analyticsqueue"

    invoke-direct {v0, v1, v2}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/comcast/cim/container/CALContainer;->analyticsTaskQueueFile:Ljava/io/File;

    .line 483
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/CALContainer;->analyticsTaskQueueFile:Ljava/io/File;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 480
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public abstract getAndroidDevice()Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;
.end method

.method public declared-synchronized getAppLauncher()Lcom/comcast/cim/utils/AppLauncher;
    .locals 2

    .prologue
    .line 574
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/CALContainer;->appLauncher:Lcom/comcast/cim/utils/AppLauncher;

    if-nez v0, :cond_0

    .line 575
    new-instance v0, Lcom/comcast/cim/utils/AppLauncher;

    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getAndroidDevice()Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/comcast/cim/utils/AppLauncher;-><init>(Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;)V

    iput-object v0, p0, Lcom/comcast/cim/container/CALContainer;->appLauncher:Lcom/comcast/cim/utils/AppLauncher;

    .line 578
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/CALContainer;->appLauncher:Lcom/comcast/cim/utils/AppLauncher;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 574
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public abstract getAppUpgradeHelper()Lcom/comcast/cim/android/application/AppUpgradeHelper;
.end method

.method public abstract getApplication()Landroid/app/Application;
.end method

.method public getAuthenticatingActivityDelegate(Landroid/app/Activity;Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate$InternalLifecycleRunner;)Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;
    .locals 11
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "internalLifecycleRunner"    # Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate$InternalLifecycleRunner;

    .prologue
    .line 501
    new-instance v0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;

    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getUserManager()Lcom/comcast/cim/model/user/UserManager;

    move-result-object v3

    .line 502
    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getLaunchStrategy()Lcom/comcast/cim/android/view/launch/LaunchStrategy;

    move-result-object v4

    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getAuthenticationStrategy()Lcom/comcast/cim/android/authentication/AuthenticationStrategy;

    move-result-object v5

    .line 503
    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getAppUpgradeHelper()Lcom/comcast/cim/android/application/AppUpgradeHelper;

    move-result-object v6

    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getUiThreadExecutor()Lcom/comcast/cim/android/concurrent/UIThreadExecutor;

    move-result-object v7

    .line 504
    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getGracefullyDegradingMinVersionCheckCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v8

    .line 505
    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getTaskExecutorFactory()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    move-result-object v9

    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getVersionCode()Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v10

    move-object v1, p1

    move-object v2, p2

    invoke-direct/range {v0 .. v10}, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;-><init>(Landroid/app/Activity;Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate$InternalLifecycleRunner;Lcom/comcast/cim/model/user/UserManager;Lcom/comcast/cim/android/view/launch/LaunchStrategy;Lcom/comcast/cim/android/authentication/AuthenticationStrategy;Lcom/comcast/cim/android/application/AppUpgradeHelper;Ljava/util/concurrent/Executor;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;I)V

    return-object v0
.end method

.method public getAuthenticatingFragmentDelegate(Lcom/comcast/cim/android/view/launch/AuthenticatingFragmentDelegate$InternalLifecycleRunner;)Lcom/comcast/cim/android/view/launch/AuthenticatingFragmentDelegate;
    .locals 2
    .param p1, "internalLifecycleRunner"    # Lcom/comcast/cim/android/view/launch/AuthenticatingFragmentDelegate$InternalLifecycleRunner;

    .prologue
    .line 509
    new-instance v0, Lcom/comcast/cim/android/view/launch/AuthenticatingFragmentDelegate;

    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getAuthenticationStrategy()Lcom/comcast/cim/android/authentication/AuthenticationStrategy;

    move-result-object v1

    invoke-direct {v0, p1, v1}, Lcom/comcast/cim/android/view/launch/AuthenticatingFragmentDelegate;-><init>(Lcom/comcast/cim/android/view/launch/AuthenticatingFragmentDelegate$InternalLifecycleRunner;Lcom/comcast/cim/android/authentication/AuthenticationStrategy;)V

    return-object v0
.end method

.method public declared-synchronized getAuthenticationClient()Lcom/comcast/cim/android/authentication/AuthenticationClient;
    .locals 5

    .prologue
    .line 209
    monitor-enter p0

    :try_start_0
    iget-object v1, p0, Lcom/comcast/cim/container/CALContainer;->authenticationClient:Lcom/comcast/cim/android/authentication/AuthenticationClient;

    if-nez v1, :cond_0

    .line 210
    new-instance v0, Lcom/comcast/cim/cmasl/apachehttp/service/DefaultHttpService;

    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getHttpClient()Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/comcast/cim/cmasl/apachehttp/service/DefaultHttpService;-><init>(Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;)V

    .line 211
    .local v0, "httpService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;Lcom/comcast/cim/cmasl/http/request/RequestProvider<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;>;>;"
    new-instance v1, Lcom/comcast/cim/android/authentication/AuthenticationClient;

    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getAndroidDevice()Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

    move-result-object v2

    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getXipRequestProviderFactory()Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;

    move-result-object v3

    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getObjectMapper()Lcom/fasterxml/jackson/databind/ObjectMapper;

    move-result-object v4

    invoke-direct {v1, v2, v0, v3, v4}, Lcom/comcast/cim/android/authentication/AuthenticationClient;-><init>(Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;Lcom/comcast/cim/cmasl/http/service/HttpService;Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;Lcom/fasterxml/jackson/databind/ObjectMapper;)V

    iput-object v1, p0, Lcom/comcast/cim/container/CALContainer;->authenticationClient:Lcom/comcast/cim/android/authentication/AuthenticationClient;

    .line 213
    .end local v0    # "httpService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;Lcom/comcast/cim/cmasl/http/request/RequestProvider<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;>;>;"
    :cond_0
    iget-object v1, p0, Lcom/comcast/cim/container/CALContainer;->authenticationClient:Lcom/comcast/cim/android/authentication/AuthenticationClient;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v1

    .line 209
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public abstract getAuthenticationStrategy()Lcom/comcast/cim/android/authentication/AuthenticationStrategy;
.end method

.method public getBaseActivityDelegate(Landroid/app/Activity;Lcom/comcast/cim/android/view/common/OrientationStrategyProvider;)Lcom/comcast/cim/android/view/common/BaseActivityDelegate;
    .locals 7
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "orientationStrategyProvider"    # Lcom/comcast/cim/android/view/common/OrientationStrategyProvider;

    .prologue
    .line 497
    new-instance v0, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;

    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getAndroidDevice()Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

    move-result-object v3

    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getAccessibilityUtil()Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    move-result-object v4

    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getInputMethodManager()Landroid/view/inputmethod/InputMethodManager;

    move-result-object v5

    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getTalkDelegateFactory()Lcom/comcast/cim/android/accessibility/TalkDelegateFactory;

    move-result-object v6

    move-object v1, p1

    move-object v2, p2

    invoke-direct/range {v0 .. v6}, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;-><init>(Landroid/app/Activity;Lcom/comcast/cim/android/view/common/OrientationStrategyProvider;Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;Lcom/comcast/cim/android/accessibility/AccessibilityUtil;Landroid/view/inputmethod/InputMethodManager;Lcom/comcast/cim/android/accessibility/TalkDelegateFactory;)V

    return-object v0
.end method

.method public abstract getConfiguration()Lcom/comcast/cim/config/CALConfiguration;
.end method

.method public declared-synchronized getConnectivityManager()Landroid/net/ConnectivityManager;
    .locals 2

    .prologue
    .line 325
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getApplication()Landroid/app/Application;

    move-result-object v0

    const-string v1, "connectivity"

    invoke-virtual {v0, v1}, Landroid/app/Application;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/ConnectivityManager;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getCurrentUser()Lcom/comcast/cim/model/user/CurrentUser;
    .locals 2

    .prologue
    .line 318
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/CALContainer;->currentUser:Lcom/comcast/cim/model/user/CurrentUser;

    if-nez v0, :cond_0

    .line 319
    new-instance v0, Lcom/comcast/cim/model/user/CurrentUser;

    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/comcast/cim/model/user/CurrentUser;-><init>(Landroid/content/SharedPreferences;)V

    iput-object v0, p0, Lcom/comcast/cim/container/CALContainer;->currentUser:Lcom/comcast/cim/model/user/CurrentUser;

    .line 321
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/CALContainer;->currentUser:Lcom/comcast/cim/model/user/CurrentUser;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 318
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public abstract getDefaultOrientationStrategy()Lcom/comcast/cim/android/view/common/OrientationStrategy;
.end method

.method public declared-synchronized getDefaultRevalidationPolicy()Lcom/comcast/cim/cmasl/taskexecutor/policy/MinimumIntervalRevalidationPolicy;
    .locals 4

    .prologue
    .line 174
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/CALContainer;->defaultRevalidationPolicy:Lcom/comcast/cim/cmasl/taskexecutor/policy/MinimumIntervalRevalidationPolicy;

    if-nez v0, :cond_0

    .line 175
    new-instance v0, Lcom/comcast/cim/cmasl/taskexecutor/policy/MinimumIntervalRevalidationPolicy;

    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getConfiguration()Lcom/comcast/cim/config/CALConfiguration;

    move-result-object v1

    invoke-interface {v1}, Lcom/comcast/cim/config/CALConfiguration;->getDataRevalidationIntervalInMillis()J

    move-result-wide v2

    invoke-direct {v0, v2, v3}, Lcom/comcast/cim/cmasl/taskexecutor/policy/MinimumIntervalRevalidationPolicy;-><init>(J)V

    iput-object v0, p0, Lcom/comcast/cim/container/CALContainer;->defaultRevalidationPolicy:Lcom/comcast/cim/cmasl/taskexecutor/policy/MinimumIntervalRevalidationPolicy;

    .line 177
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/CALContainer;->defaultRevalidationPolicy:Lcom/comcast/cim/cmasl/taskexecutor/policy/MinimumIntervalRevalidationPolicy;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 174
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getDownloadUserAgent()Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeader;
    .locals 8

    .prologue
    .line 294
    monitor-enter p0

    :try_start_0
    iget-object v2, p0, Lcom/comcast/cim/container/CALContainer;->downloadUserAgent:Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeader;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-nez v2, :cond_0

    .line 297
    :try_start_1
    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getApplication()Landroid/app/Application;

    move-result-object v2

    invoke-virtual {v2}, Landroid/app/Application;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getApplication()Landroid/app/Application;

    move-result-object v3

    invoke-virtual {v3}, Landroid/app/Application;->getPackageName()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    :try_end_1
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v1

    .line 301
    .local v1, "packageInfo":Landroid/content/pm/PackageInfo;
    :try_start_2
    new-instance v2, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeader;

    const-string v3, "User-Agent"

    const-string v4, "%1$s/%2$s (ANDROID %3$s; di=%4$s) DL2G"

    const/4 v5, 0x4

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    .line 302
    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getConfiguration()Lcom/comcast/cim/config/CALConfiguration;

    move-result-object v7

    invoke-interface {v7}, Lcom/comcast/cim/config/CALConfiguration;->getUserAgentPrefix()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    const/4 v6, 0x1

    iget-object v7, v1, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;

    aput-object v7, v5, v6

    const/4 v6, 0x2

    sget-object v7, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    aput-object v7, v5, v6

    const/4 v6, 0x3

    .line 305
    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getAndroidDevice()Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

    move-result-object v7

    invoke-virtual {v7}, Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;->getDeviceId()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    .line 301
    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v2, v3, v4}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeader;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    iput-object v2, p0, Lcom/comcast/cim/container/CALContainer;->downloadUserAgent:Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeader;

    .line 307
    .end local v1    # "packageInfo":Landroid/content/pm/PackageInfo;
    :cond_0
    iget-object v2, p0, Lcom/comcast/cim/container/CALContainer;->downloadUserAgent:Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeader;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    monitor-exit p0

    return-object v2

    .line 298
    :catch_0
    move-exception v0

    .line 299
    .local v0, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :try_start_3
    new-instance v2, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;

    invoke-direct {v2, v0}, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;-><init>(Ljava/lang/Throwable;)V

    throw v2
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 294
    .end local v0    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2
.end method

.method public getErrorDialogFactory()Lcom/comcast/cim/android/view/common/ErrorDialogFactory;
    .locals 4

    .prologue
    .line 527
    iget-object v0, p0, Lcom/comcast/cim/container/CALContainer;->errorDialogFactory:Lcom/comcast/cim/android/view/common/ErrorDialogFactory;

    if-nez v0, :cond_0

    .line 528
    new-instance v0, Lcom/comcast/cim/android/view/common/ErrorDialogFactory;

    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getErrorFormatter()Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;

    move-result-object v1

    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getInternetConnection()Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    move-result-object v2

    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3}, Lcom/comcast/cim/android/view/common/ErrorDialogFactory;-><init>(Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;Landroid/content/res/Resources;)V

    iput-object v0, p0, Lcom/comcast/cim/container/CALContainer;->errorDialogFactory:Lcom/comcast/cim/android/view/common/ErrorDialogFactory;

    .line 530
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/CALContainer;->errorDialogFactory:Lcom/comcast/cim/android/view/common/ErrorDialogFactory;

    return-object v0
.end method

.method public declared-synchronized getErrorFormatter()Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;
    .locals 3

    .prologue
    .line 513
    monitor-enter p0

    :try_start_0
    iget-object v2, p0, Lcom/comcast/cim/container/CALContainer;->errorFormatter:Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;

    if-nez v2, :cond_0

    .line 514
    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    .line 515
    .local v1, "resources":Landroid/content/res/Resources;
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v0

    .line 516
    .local v0, "formatters":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;>;"
    new-instance v2, Lcom/comcast/cim/android/view/common/errorformatter/XipErrorFormatter;

    invoke-direct {v2, v1}, Lcom/comcast/cim/android/view/common/errorformatter/XipErrorFormatter;-><init>(Landroid/content/res/Resources;)V

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 517
    new-instance v2, Lcom/comcast/cim/android/view/common/errorformatter/AmsErrorFormatter;

    invoke-direct {v2, v1}, Lcom/comcast/cim/android/view/common/errorformatter/AmsErrorFormatter;-><init>(Landroid/content/res/Resources;)V

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 518
    new-instance v2, Lcom/comcast/cim/android/view/common/errorformatter/CimHttpErrorFormatter;

    invoke-direct {v2, v1}, Lcom/comcast/cim/android/view/common/errorformatter/CimHttpErrorFormatter;-><init>(Landroid/content/res/Resources;)V

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 519
    new-instance v2, Lcom/comcast/cim/android/view/common/errorformatter/DownloadServiceErrorFormatter;

    invoke-direct {v2, v1}, Lcom/comcast/cim/android/view/common/errorformatter/DownloadServiceErrorFormatter;-><init>(Landroid/content/res/Resources;)V

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 520
    new-instance v2, Lcom/comcast/cim/android/view/common/errorformatter/GenericErrorFormatter;

    invoke-direct {v2, v1}, Lcom/comcast/cim/android/view/common/errorformatter/GenericErrorFormatter;-><init>(Landroid/content/res/Resources;)V

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 521
    new-instance v2, Lcom/comcast/cim/android/view/common/errorformatter/ChainedErrorFormatter;

    invoke-direct {v2, v0}, Lcom/comcast/cim/android/view/common/errorformatter/ChainedErrorFormatter;-><init>(Ljava/util/List;)V

    iput-object v2, p0, Lcom/comcast/cim/container/CALContainer;->errorFormatter:Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;

    .line 523
    .end local v0    # "formatters":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;>;"
    .end local v1    # "resources":Landroid/content/res/Resources;
    :cond_0
    iget-object v2, p0, Lcom/comcast/cim/container/CALContainer;->errorFormatter:Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v2

    .line 513
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2
.end method

.method public getGracefullyDegradingMinVersionCheckCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .prologue
    .line 534
    iget-object v0, p0, Lcom/comcast/cim/container/CALContainer;->gracefullyDegradingMinVersionCheckCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    if-nez v0, :cond_0

    .line 535
    new-instance v0, Lcom/comcast/cim/model/GracefullyDegradingMinVersionCheckCache;

    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getMinVersionCheckCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/comcast/cim/model/GracefullyDegradingMinVersionCheckCache;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)V

    iput-object v0, p0, Lcom/comcast/cim/container/CALContainer;->gracefullyDegradingMinVersionCheckCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 538
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/CALContainer;->gracefullyDegradingMinVersionCheckCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    return-object v0
.end method

.method public declared-synchronized getHlsDownloadClient()Lcom/comcast/cim/cmasl/hls/HlsDownloadClient;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/hls/HlsDownloadClient",
            "<",
            "Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;",
            ">;"
        }
    .end annotation

    .prologue
    .line 415
    monitor-enter p0

    :try_start_0
    iget-object v1, p0, Lcom/comcast/cim/container/CALContainer;->hlsDownloadClient:Lcom/comcast/cim/cmasl/hls/HlsDownloadClient;

    if-nez v1, :cond_0

    .line 416
    new-instance v0, Lcom/comcast/cim/cmasl/apachehttp/service/DefaultHttpService;

    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getHttpClient()Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/comcast/cim/cmasl/apachehttp/service/DefaultHttpService;-><init>(Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;)V

    .line 417
    .local v0, "httpService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;Lcom/comcast/cim/cmasl/http/request/RequestProvider<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;>;>;"
    new-instance v1, Lcom/comcast/cim/cmasl/hls/HlsDownloadClient;

    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getHttpRequestProviderFactory()Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;

    move-result-object v2

    invoke-direct {v1, v0, v2}, Lcom/comcast/cim/cmasl/hls/HlsDownloadClient;-><init>(Lcom/comcast/cim/cmasl/http/service/HttpService;Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;)V

    iput-object v1, p0, Lcom/comcast/cim/container/CALContainer;->hlsDownloadClient:Lcom/comcast/cim/cmasl/hls/HlsDownloadClient;

    .line 420
    .end local v0    # "httpService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;Lcom/comcast/cim/cmasl/http/request/RequestProvider<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;>;>;"
    :cond_0
    iget-object v1, p0, Lcom/comcast/cim/container/CALContainer;->hlsDownloadClient:Lcom/comcast/cim/cmasl/hls/HlsDownloadClient;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v1

    .line 415
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public declared-synchronized getHttpClient()Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;
    .locals 5

    .prologue
    .line 248
    monitor-enter p0

    :try_start_0
    iget-object v1, p0, Lcom/comcast/cim/container/CALContainer;->httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    if-nez v1, :cond_0

    .line 249
    new-instance v0, Lcom/comcast/cim/cmasl/apachehttp/client/HttpClientProvider;

    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->shouldDisableSSLVerification()Z

    move-result v1

    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getUserAgent()Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeader;

    move-result-object v2

    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getOptionalProxy()Lcom/comcast/cim/httpcomponentsandroid/HttpHost;

    move-result-object v3

    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getOptionalHttpRequestInterceptors()Ljava/util/List;

    move-result-object v4

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/comcast/cim/cmasl/apachehttp/client/HttpClientProvider;-><init>(ZLcom/comcast/cim/httpcomponentsandroid/message/BasicHeader;Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Ljava/util/List;)V

    .line 250
    .local v0, "httpClientProvider":Lcom/comcast/cim/cmasl/apachehttp/client/HttpClientProvider;
    new-instance v1, Lcom/comcast/cim/cmasl/apachehttp/client/DecompressingHttpClient;

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/apachehttp/client/HttpClientProvider;->get()Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    move-result-object v2

    invoke-direct {v1, v2}, Lcom/comcast/cim/cmasl/apachehttp/client/DecompressingHttpClient;-><init>(Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;)V

    iput-object v1, p0, Lcom/comcast/cim/container/CALContainer;->httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    .line 252
    .end local v0    # "httpClientProvider":Lcom/comcast/cim/cmasl/apachehttp/client/HttpClientProvider;
    :cond_0
    iget-object v1, p0, Lcom/comcast/cim/container/CALContainer;->httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v1

    .line 248
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public declared-synchronized getHttpRequestProviderFactory()Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory",
            "<",
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<",
            "Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 217
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/CALContainer;->requestProviderFactory:Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;

    if-nez v0, :cond_0

    .line 218
    new-instance v0, Lcom/comcast/cim/container/CALContainer$1;

    invoke-direct {v0, p0}, Lcom/comcast/cim/container/CALContainer$1;-><init>(Lcom/comcast/cim/container/CALContainer;)V

    iput-object v0, p0, Lcom/comcast/cim/container/CALContainer;->requestProviderFactory:Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;

    .line 231
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/CALContainer;->requestProviderFactory:Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 217
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getInputMethodManager()Landroid/view/inputmethod/InputMethodManager;
    .locals 2

    .prologue
    .line 263
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getApplication()Landroid/app/Application;

    move-result-object v0

    const-string v1, "input_method"

    invoke-virtual {v0, v1}, Landroid/app/Application;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/inputmethod/InputMethodManager;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getInternetConnection()Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;
    .locals 3

    .prologue
    .line 311
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/CALContainer;->internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    if-nez v0, :cond_0

    .line 312
    new-instance v0, Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getConnectivityManager()Landroid/net/ConnectivityManager;

    move-result-object v1

    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getTelephonyManager()Landroid/telephony/TelephonyManager;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;-><init>(Landroid/net/ConnectivityManager;Landroid/telephony/TelephonyManager;)V

    iput-object v0, p0, Lcom/comcast/cim/container/CALContainer;->internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    .line 314
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/CALContainer;->internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 311
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getJsonSerializer()Lcom/comcast/cim/utils/JsonSerializer;
    .locals 2

    .prologue
    .line 584
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/CALContainer;->jsonSerializer:Lcom/comcast/cim/utils/JsonSerializer;

    if-nez v0, :cond_0

    .line 585
    new-instance v0, Lcom/comcast/cim/utils/JsonSerializer;

    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getObjectMapper()Lcom/fasterxml/jackson/databind/ObjectMapper;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/comcast/cim/utils/JsonSerializer;-><init>(Lcom/fasterxml/jackson/databind/ObjectMapper;)V

    iput-object v0, p0, Lcom/comcast/cim/container/CALContainer;->jsonSerializer:Lcom/comcast/cim/utils/JsonSerializer;

    .line 587
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/CALContainer;->jsonSerializer:Lcom/comcast/cim/utils/JsonSerializer;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 584
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public abstract getLaunchIntentInterceptor()Lcom/comcast/cim/android/view/launch/LaunchIntentInterceptor;
.end method

.method public abstract getLaunchStrategy()Lcom/comcast/cim/android/view/launch/LaunchStrategy;
.end method

.method public getLayoutInflatorFactory()Landroid/view/LayoutInflater$Factory;
    .locals 1
    .annotation runtime Lcom/comcast/cim/container/NonSingleton;
    .end annotation

    .prologue
    .line 381
    new-instance v0, Lcom/comcast/cim/container/CALContainer$2;

    invoke-direct {v0, p0}, Lcom/comcast/cim/container/CALContainer$2;-><init>(Lcom/comcast/cim/container/CALContainer;)V

    return-object v0
.end method

.method public getMinVersionCheckCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .prologue
    .line 542
    iget-object v3, p0, Lcom/comcast/cim/container/CALContainer;->minVersionCheckCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    if-nez v3, :cond_0

    .line 545
    :try_start_0
    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getApplication()Landroid/app/Application;

    move-result-object v3

    invoke-virtual {v3}, Landroid/app/Application;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v3

    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getApplication()Landroid/app/Application;

    move-result-object v4

    invoke-virtual {v4}, Landroid/app/Application;->getPackageName()Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x0

    invoke-virtual {v3, v4, v5}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    .line 550
    .local v2, "packageInfo":Landroid/content/pm/PackageInfo;
    new-instance v1, Lcom/comcast/cim/cmasl/apachehttp/service/DefaultHttpService;

    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getHttpClient()Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    move-result-object v3

    invoke-direct {v1, v3}, Lcom/comcast/cim/cmasl/apachehttp/service/DefaultHttpService;-><init>(Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;)V

    .line 551
    .local v1, "httpService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;Lcom/comcast/cim/cmasl/http/request/RequestProvider<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;>;>;"
    new-instance v3, Lcom/comcast/cim/model/MinVersionTask;

    new-instance v4, Lcom/comcast/cim/cmasl/taskexecutor/policy/MinimumIntervalRevalidationPolicy;

    .line 552
    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getConfiguration()Lcom/comcast/cim/config/CALConfiguration;

    move-result-object v5

    invoke-interface {v5}, Lcom/comcast/cim/config/CALConfiguration;->getMinVersionCheckRevalidationIntervalInMillis()J

    move-result-wide v6

    invoke-direct {v4, v6, v7}, Lcom/comcast/cim/cmasl/taskexecutor/policy/MinimumIntervalRevalidationPolicy;-><init>(J)V

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    .line 553
    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getConfiguration()Lcom/comcast/cim/config/CALConfiguration;

    move-result-object v6

    invoke-interface {v6}, Lcom/comcast/cim/config/CALConfiguration;->getUserAgentPrefix()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "-"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget-object v6, v2, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    .line 554
    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getXipRequestProviderFactory()Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;

    move-result-object v6

    invoke-direct {v3, v1, v4, v5, v6}, Lcom/comcast/cim/model/MinVersionTask;-><init>(Lcom/comcast/cim/cmasl/http/service/HttpService;Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;Ljava/lang/String;Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;)V

    iput-object v3, p0, Lcom/comcast/cim/container/CALContainer;->minVersionCheckCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 557
    .end local v1    # "httpService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;Lcom/comcast/cim/cmasl/http/request/RequestProvider<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;>;>;"
    .end local v2    # "packageInfo":Landroid/content/pm/PackageInfo;
    :cond_0
    iget-object v3, p0, Lcom/comcast/cim/container/CALContainer;->minVersionCheckCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    return-object v3

    .line 546
    :catch_0
    move-exception v0

    .line 547
    .local v0, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    new-instance v3, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;

    invoke-direct {v3, v0}, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;-><init>(Ljava/lang/Throwable;)V

    throw v3
.end method

.method public declared-synchronized getObjectMapper()Lcom/fasterxml/jackson/databind/ObjectMapper;
    .locals 3

    .prologue
    .line 591
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/CALContainer;->objectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    if-nez v0, :cond_0

    .line 592
    new-instance v0, Lcom/fasterxml/jackson/databind/ObjectMapper;

    invoke-direct {v0}, Lcom/fasterxml/jackson/databind/ObjectMapper;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/container/CALContainer;->objectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    .line 593
    iget-object v0, p0, Lcom/comcast/cim/container/CALContainer;->objectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    sget-object v1, Lcom/fasterxml/jackson/databind/DeserializationFeature;->FAIL_ON_UNKNOWN_PROPERTIES:Lcom/fasterxml/jackson/databind/DeserializationFeature;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/fasterxml/jackson/databind/ObjectMapper;->configure(Lcom/fasterxml/jackson/databind/DeserializationFeature;Z)Lcom/fasterxml/jackson/databind/ObjectMapper;

    .line 594
    iget-object v0, p0, Lcom/comcast/cim/container/CALContainer;->objectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    sget-object v1, Lcom/comcast/cim/utils/EitherJacksonMixIn;->MIX_IN_CONFIG:Ljava/util/Map;

    invoke-virtual {v0, v1}, Lcom/fasterxml/jackson/databind/ObjectMapper;->setMixInAnnotations(Ljava/util/Map;)V

    .line 596
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/CALContainer;->objectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 591
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method protected getOptionalHttpRequestInterceptors()Ljava/util/List;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;",
            ">;"
        }
    .end annotation

    .prologue
    .line 366
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v0

    .line 367
    .local v0, "interceptorList":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;>;"
    new-instance v1, Lcom/comcast/cim/utils/AddNetworkTypeHeaderInterceptor;

    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getInternetConnection()Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    move-result-object v2

    invoke-direct {v1, v2}, Lcom/comcast/cim/utils/AddNetworkTypeHeaderInterceptor;-><init>(Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 368
    new-instance v1, Lcom/comcast/cim/cmasl/apachehttp/LogAllRequestsInterceptor;

    invoke-direct {v1}, Lcom/comcast/cim/cmasl/apachehttp/LogAllRequestsInterceptor;-><init>()V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 369
    return-object v0
.end method

.method protected declared-synchronized getOptionalProxy()Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    .locals 1

    .prologue
    .line 244
    monitor-enter p0

    const/4 v0, 0x0

    monitor-exit p0

    return-object v0
.end method

.method public declared-synchronized getPermanentFileCache()Lcom/comcast/cim/cmasl/cachelib/PermanentFileCache;
    .locals 2

    .prologue
    .line 373
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/CALContainer;->fileCache:Lcom/comcast/cim/cmasl/cachelib/PermanentFileCache;

    if-nez v0, :cond_0

    .line 374
    new-instance v0, Lcom/comcast/cim/cmasl/cachelib/PermanentFileCache;

    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getApplication()Landroid/app/Application;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/comcast/cim/cmasl/cachelib/PermanentFileCache;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/comcast/cim/container/CALContainer;->fileCache:Lcom/comcast/cim/cmasl/cachelib/PermanentFileCache;

    .line 376
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/CALContainer;->fileCache:Lcom/comcast/cim/cmasl/cachelib/PermanentFileCache;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 373
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getResources()Landroid/content/res/Resources;
    .locals 1

    .prologue
    .line 271
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getApplication()Landroid/app/Application;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Application;->getResources()Landroid/content/res/Resources;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getSharedPreferences()Landroid/content/SharedPreferences;
    .locals 1

    .prologue
    .line 329
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getApplication()Landroid/app/Application;

    move-result-object v0

    invoke-static {v0}, Landroid/preference/PreferenceManager;->getDefaultSharedPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getSignInListener()Lcom/comcast/cim/android/authentication/SignInListener;
    .locals 5

    .prologue
    .line 256
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/CALContainer;->signInListener:Lcom/comcast/cim/android/authentication/SignInListener;

    if-nez v0, :cond_0

    .line 257
    new-instance v0, Lcom/comcast/cim/android/authentication/SignInListener;

    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getAuthenticationClient()Lcom/comcast/cim/android/authentication/AuthenticationClient;

    move-result-object v1

    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getSoftKeyboard()Lcom/comcast/cim/cmasl/android/util/system/SoftKeyboard;

    move-result-object v2

    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getInternetConnection()Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    move-result-object v3

    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getErrorDialogFactory()Lcom/comcast/cim/android/view/common/ErrorDialogFactory;

    move-result-object v4

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/comcast/cim/android/authentication/SignInListener;-><init>(Lcom/comcast/cim/android/authentication/AuthenticationClient;Lcom/comcast/cim/cmasl/android/util/system/SoftKeyboard;Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;Lcom/comcast/cim/android/view/common/ErrorDialogFactory;)V

    iput-object v0, p0, Lcom/comcast/cim/container/CALContainer;->signInListener:Lcom/comcast/cim/android/authentication/SignInListener;

    .line 259
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/CALContainer;->signInListener:Lcom/comcast/cim/android/authentication/SignInListener;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 256
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getSoftKeyboard()Lcom/comcast/cim/cmasl/android/util/system/SoftKeyboard;
    .locals 1

    .prologue
    .line 202
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/CALContainer;->softKeyboard:Lcom/comcast/cim/cmasl/android/util/system/SoftKeyboard;

    if-nez v0, :cond_0

    .line 203
    new-instance v0, Lcom/comcast/cim/cmasl/android/util/system/SoftKeyboard;

    invoke-direct {v0}, Lcom/comcast/cim/cmasl/android/util/system/SoftKeyboard;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/container/CALContainer;->softKeyboard:Lcom/comcast/cim/cmasl/android/util/system/SoftKeyboard;

    .line 205
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/CALContainer;->softKeyboard:Lcom/comcast/cim/cmasl/android/util/system/SoftKeyboard;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 202
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public getSplunkLogger()Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;
    .locals 4
    .annotation runtime Lcom/comcast/cim/container/ContainerTestIgnore;
    .end annotation

    .prologue
    .line 488
    iget-object v0, p0, Lcom/comcast/cim/container/CALContainer;->splunkLogger:Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;

    if-nez v0, :cond_0

    .line 489
    new-instance v0, Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskQueueLogger;

    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getAnalyticsTaskQueue()Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskQueue;

    move-result-object v1

    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getConfiguration()Lcom/comcast/cim/config/CALConfiguration;

    move-result-object v2

    invoke-interface {v2}, Lcom/comcast/cim/config/CALConfiguration;->getSplunkAppName()Ljava/lang/String;

    move-result-object v2

    const-string v3, "http://xfinitytv.comcast.net/xtv/authkey/event/store/?"

    invoke-direct {v0, v1, v2, v3}, Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskQueueLogger;-><init>(Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskQueue;Ljava/lang/String;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/comcast/cim/container/CALContainer;->splunkLogger:Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;

    .line 491
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/CALContainer;->splunkLogger:Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;

    return-object v0
.end method

.method public declared-synchronized getTalkDelegateFactory()Lcom/comcast/cim/android/accessibility/TalkDelegateFactory;
    .locals 2

    .prologue
    .line 352
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/CALContainer;->talkDelegateFactory:Lcom/comcast/cim/android/accessibility/TalkDelegateFactory;

    if-nez v0, :cond_0

    .line 353
    new-instance v0, Lcom/comcast/cim/android/accessibility/TalkDelegateFactory;

    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getAccessibilityUtil()Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/comcast/cim/android/accessibility/TalkDelegateFactory;-><init>(Lcom/comcast/cim/android/accessibility/AccessibilityUtil;)V

    iput-object v0, p0, Lcom/comcast/cim/container/CALContainer;->talkDelegateFactory:Lcom/comcast/cim/android/accessibility/TalkDelegateFactory;

    .line 355
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/CALContainer;->talkDelegateFactory:Lcom/comcast/cim/android/accessibility/TalkDelegateFactory;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 352
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getTaskExecutorFactory()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;
    .locals 3

    .prologue
    .line 181
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/CALContainer;->taskExecutorFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    if-nez v0, :cond_0

    .line 182
    new-instance v0, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    new-instance v1, Lcom/comcast/cim/cmasl/utils/executor/SingleThreadedExecutorFactory;

    invoke-direct {v1}, Lcom/comcast/cim/cmasl/utils/executor/SingleThreadedExecutorFactory;-><init>()V

    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getUiThreadExecutor()Lcom/comcast/cim/android/concurrent/UIThreadExecutor;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;-><init>(Lcom/comcast/cim/cmasl/utils/executor/ExecutorFactory;Ljava/util/concurrent/Executor;)V

    iput-object v0, p0, Lcom/comcast/cim/container/CALContainer;->taskExecutorFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    .line 184
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/CALContainer;->taskExecutorFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 181
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getTelephonyManager()Landroid/telephony/TelephonyManager;
    .locals 2

    .prologue
    .line 267
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getApplication()Landroid/app/Application;

    move-result-object v0

    const-string v1, "phone"

    invoke-virtual {v0, v1}, Landroid/app/Application;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/telephony/TelephonyManager;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public abstract getTrackingService()Lcom/comcast/cim/tracking/TrackingService;
.end method

.method public declared-synchronized getTypefaceManager()Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceManager;
    .locals 1

    .prologue
    .line 390
    monitor-enter p0

    const/4 v0, 0x0

    monitor-exit p0

    return-object v0
.end method

.method public declared-synchronized getUIUtil()Lcom/comcast/cim/utils/UIUtil;
    .locals 2

    .prologue
    .line 195
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/CALContainer;->uiUtil:Lcom/comcast/cim/utils/UIUtil;

    if-nez v0, :cond_0

    .line 196
    new-instance v0, Lcom/comcast/cim/utils/UIUtil;

    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getInternetConnection()Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/comcast/cim/utils/UIUtil;-><init>(Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;)V

    iput-object v0, p0, Lcom/comcast/cim/container/CALContainer;->uiUtil:Lcom/comcast/cim/utils/UIUtil;

    .line 198
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/CALContainer;->uiUtil:Lcom/comcast/cim/utils/UIUtil;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 195
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getUiThreadExecutor()Lcom/comcast/cim/android/concurrent/UIThreadExecutor;
    .locals 3

    .prologue
    .line 188
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/CALContainer;->uiThreadExecutor:Lcom/comcast/cim/android/concurrent/UIThreadExecutor;

    if-nez v0, :cond_0

    .line 189
    new-instance v0, Lcom/comcast/cim/android/concurrent/UIThreadExecutor;

    new-instance v1, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v2

    invoke-direct {v1, v2}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    invoke-direct {v0, v1}, Lcom/comcast/cim/android/concurrent/UIThreadExecutor;-><init>(Landroid/os/Handler;)V

    iput-object v0, p0, Lcom/comcast/cim/container/CALContainer;->uiThreadExecutor:Lcom/comcast/cim/android/concurrent/UIThreadExecutor;

    .line 191
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/CALContainer;->uiThreadExecutor:Lcom/comcast/cim/android/concurrent/UIThreadExecutor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 188
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method protected declared-synchronized getUserAgent()Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeader;
    .locals 10

    .prologue
    .line 277
    monitor-enter p0

    :try_start_0
    iget-object v2, p0, Lcom/comcast/cim/container/CALContainer;->userAgent:Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeader;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-nez v2, :cond_0

    .line 280
    :try_start_1
    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getApplication()Landroid/app/Application;

    move-result-object v2

    invoke-virtual {v2}, Landroid/app/Application;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getApplication()Landroid/app/Application;

    move-result-object v3

    invoke-virtual {v3}, Landroid/app/Application;->getPackageName()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    :try_end_1
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v1

    .line 284
    .local v1, "packageInfo":Landroid/content/pm/PackageInfo;
    :try_start_2
    new-instance v3, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeader;

    const-string v4, "User-Agent"

    const-string v5, "%s %s / %s; %s %d / Android %s / %s / %s"

    const/16 v2, 0x8

    new-array v6, v2, [Ljava/lang/Object;

    const/4 v2, 0x0

    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getConfiguration()Lcom/comcast/cim/config/CALConfiguration;

    move-result-object v7

    invoke-interface {v7}, Lcom/comcast/cim/config/CALConfiguration;->getUserAgentPrefix()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v6, v2

    const/4 v2, 0x1

    iget-object v7, v1, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;

    aput-object v7, v6, v2

    const/4 v2, 0x2

    sget-object v7, Landroid/os/Build;->MANUFACTURER:Ljava/lang/String;

    aput-object v7, v6, v2

    const/4 v7, 0x3

    sget-object v2, Landroid/os/Build;->MODEL:Ljava/lang/String;

    if-eqz v2, :cond_1

    sget-object v2, Landroid/os/Build;->MODEL:Ljava/lang/String;

    const-string v8, " "

    const-string v9, "_"

    .line 286
    invoke-virtual {v2, v8, v9}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    :goto_0
    aput-object v2, v6, v7

    const/4 v2, 0x4

    .line 287
    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getAndroidDevice()Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

    move-result-object v7

    invoke-virtual {v7}, Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;->getScreenWidth()I

    move-result v7

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v6, v2

    const/4 v2, 0x5

    sget-object v7, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    aput-object v7, v6, v2

    const/4 v2, 0x6

    sget-object v7, Landroid/os/Build;->BRAND:Ljava/lang/String;

    aput-object v7, v6, v2

    const/4 v2, 0x7

    .line 288
    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getAndroidDevice()Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

    move-result-object v7

    invoke-virtual {v7}, Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;->getDeviceId()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v6, v2

    .line 284
    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v3, v4, v2}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeader;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    iput-object v3, p0, Lcom/comcast/cim/container/CALContainer;->userAgent:Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeader;

    .line 290
    .end local v1    # "packageInfo":Landroid/content/pm/PackageInfo;
    :cond_0
    iget-object v2, p0, Lcom/comcast/cim/container/CALContainer;->userAgent:Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeader;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    monitor-exit p0

    return-object v2

    .line 281
    :catch_0
    move-exception v0

    .line 282
    .local v0, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :try_start_3
    new-instance v2, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;

    invoke-direct {v2, v0}, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;-><init>(Ljava/lang/Throwable;)V

    throw v2
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 277
    .end local v0    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2

    .line 286
    .restart local v1    # "packageInfo":Landroid/content/pm/PackageInfo;
    :cond_1
    :try_start_4
    const-string v2, "null"
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    goto :goto_0
.end method

.method public abstract getUserManager()Lcom/comcast/cim/model/user/UserManager;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/model/user/UserManager",
            "<+",
            "Lcom/comcast/cim/model/user/User;",
            "+",
            "Lcom/comcast/cim/model/user/service/UserSettings;",
            ">;"
        }
    .end annotation
.end method

.method public getVersionCode()Ljava/lang/Integer;
    .locals 5

    .prologue
    .line 561
    iget-object v2, p0, Lcom/comcast/cim/container/CALContainer;->versionCode:Ljava/lang/Integer;

    if-nez v2, :cond_0

    .line 564
    :try_start_0
    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getApplication()Landroid/app/Application;

    move-result-object v2

    invoke-virtual {v2}, Landroid/app/Application;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getApplication()Landroid/app/Application;

    move-result-object v3

    invoke-virtual {v3}, Landroid/app/Application;->getPackageName()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 568
    .local v1, "packageInfo":Landroid/content/pm/PackageInfo;
    iget v2, v1, Landroid/content/pm/PackageInfo;->versionCode:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    iput-object v2, p0, Lcom/comcast/cim/container/CALContainer;->versionCode:Ljava/lang/Integer;

    .line 570
    .end local v1    # "packageInfo":Landroid/content/pm/PackageInfo;
    :cond_0
    iget-object v2, p0, Lcom/comcast/cim/container/CALContainer;->versionCode:Ljava/lang/Integer;

    return-object v2

    .line 565
    :catch_0
    move-exception v0

    .line 566
    .local v0, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    new-instance v2, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;

    invoke-direct {v2, v0}, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;-><init>(Ljava/lang/Throwable;)V

    throw v2
.end method

.method public declared-synchronized getXipRequestProviderFactory()Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory",
            "<",
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<",
            "Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 235
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/CALContainer;->xipRequestProviderFactory:Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;

    if-nez v0, :cond_0

    .line 236
    new-instance v0, Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;

    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getHttpRequestProviderFactory()Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;

    move-result-object v1

    .line 237
    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getXipServer()Lcom/comcast/cim/cmasl/xip/XipServer;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;-><init>(Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;Lcom/comcast/cim/cmasl/xip/XipServer;)V

    iput-object v0, p0, Lcom/comcast/cim/container/CALContainer;->xipRequestProviderFactory:Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;

    .line 240
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/CALContainer;->xipRequestProviderFactory:Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 235
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getXipServer()Lcom/comcast/cim/cmasl/xip/XipServer;
    .locals 2
    .annotation runtime Lcom/comcast/cim/container/NonSingleton;
    .end annotation

    .prologue
    .line 395
    monitor-enter p0

    :try_start_0
    new-instance v0, Lcom/comcast/cim/cmasl/xip/XipServer;

    invoke-virtual {p0}, Lcom/comcast/cim/container/CALContainer;->getConfiguration()Lcom/comcast/cim/config/CALConfiguration;

    move-result-object v1

    invoke-interface {v1}, Lcom/comcast/cim/config/CALConfiguration;->getXipUri()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/comcast/cim/cmasl/xip/XipServer;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method protected abstract shouldDisableSSLVerification()Z
.end method
