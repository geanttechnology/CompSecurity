.class public Lcom/comcast/playerplatform/drm/java/util/ThreadManager;
.super Ljava/lang/Object;
.source "ThreadManager.java"


# static fields
.field private static final executorService:Ljava/util/concurrent/ExecutorService;

.field private static instance:Lcom/comcast/playerplatform/drm/java/util/ThreadManager;

.field private static uiThread:Landroid/os/Handler;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 17
    invoke-static {}, Ljava/util/concurrent/Executors;->newSingleThreadExecutor()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    sput-object v0, Lcom/comcast/playerplatform/drm/java/util/ThreadManager;->executorService:Ljava/util/concurrent/ExecutorService;

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 22
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    sput-object v0, Lcom/comcast/playerplatform/drm/java/util/ThreadManager;->uiThread:Landroid/os/Handler;

    .line 23
    return-void
.end method

.method public static declared-synchronized getInstance()Lcom/comcast/playerplatform/drm/java/util/ThreadManager;
    .locals 2

    .prologue
    .line 26
    const-class v1, Lcom/comcast/playerplatform/drm/java/util/ThreadManager;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/comcast/playerplatform/drm/java/util/ThreadManager;->instance:Lcom/comcast/playerplatform/drm/java/util/ThreadManager;

    if-nez v0, :cond_0

    .line 27
    new-instance v0, Lcom/comcast/playerplatform/drm/java/util/ThreadManager;

    invoke-direct {v0}, Lcom/comcast/playerplatform/drm/java/util/ThreadManager;-><init>()V

    sput-object v0, Lcom/comcast/playerplatform/drm/java/util/ThreadManager;->instance:Lcom/comcast/playerplatform/drm/java/util/ThreadManager;

    .line 30
    :cond_0
    sget-object v0, Lcom/comcast/playerplatform/drm/java/util/ThreadManager;->instance:Lcom/comcast/playerplatform/drm/java/util/ThreadManager;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 26
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method


# virtual methods
.method public executeOnUIThread(Ljava/lang/Runnable;)V
    .locals 1
    .param p1, "runnable"    # Ljava/lang/Runnable;

    .prologue
    .line 38
    sget-object v0, Lcom/comcast/playerplatform/drm/java/util/ThreadManager;->uiThread:Landroid/os/Handler;

    invoke-virtual {v0, p1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 39
    return-void
.end method

.method public executeRunnable(Ljava/lang/Runnable;)V
    .locals 1
    .param p1, "runnable"    # Ljava/lang/Runnable;

    .prologue
    .line 34
    sget-object v0, Lcom/comcast/playerplatform/drm/java/util/ThreadManager;->executorService:Ljava/util/concurrent/ExecutorService;

    invoke-interface {v0, p1}, Ljava/util/concurrent/ExecutorService;->execute(Ljava/lang/Runnable;)V

    .line 35
    return-void
.end method
