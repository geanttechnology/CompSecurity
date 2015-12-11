.class public Lcom/comcast/playerplatform/util/android/ThreadManager;
.super Ljava/lang/Object;
.source "ThreadManager.java"


# static fields
.field private static instance:Lcom/comcast/playerplatform/util/android/ThreadManager;

.field private static uiThread:Landroid/os/Handler;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 19
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    sput-object v0, Lcom/comcast/playerplatform/util/android/ThreadManager;->uiThread:Landroid/os/Handler;

    .line 20
    return-void
.end method

.method public static declared-synchronized getInstance()Lcom/comcast/playerplatform/util/android/ThreadManager;
    .locals 2

    .prologue
    .line 23
    const-class v1, Lcom/comcast/playerplatform/util/android/ThreadManager;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/comcast/playerplatform/util/android/ThreadManager;->instance:Lcom/comcast/playerplatform/util/android/ThreadManager;

    if-nez v0, :cond_0

    .line 24
    new-instance v0, Lcom/comcast/playerplatform/util/android/ThreadManager;

    invoke-direct {v0}, Lcom/comcast/playerplatform/util/android/ThreadManager;-><init>()V

    sput-object v0, Lcom/comcast/playerplatform/util/android/ThreadManager;->instance:Lcom/comcast/playerplatform/util/android/ThreadManager;

    .line 27
    :cond_0
    sget-object v0, Lcom/comcast/playerplatform/util/android/ThreadManager;->instance:Lcom/comcast/playerplatform/util/android/ThreadManager;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 23
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
    .line 31
    sget-object v0, Lcom/comcast/playerplatform/util/android/ThreadManager;->uiThread:Landroid/os/Handler;

    invoke-virtual {v0, p1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 32
    return-void
.end method
