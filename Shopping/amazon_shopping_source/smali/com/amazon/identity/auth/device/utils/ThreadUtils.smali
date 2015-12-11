.class public final Lcom/amazon/identity/auth/device/utils/ThreadUtils;
.super Ljava/lang/Object;
.source "ThreadUtils.java"


# static fields
.field private static final LOCK:[Ljava/lang/Object;

.field public static final MAP_COMMON_THREAD_POOL:Ljava/util/concurrent/Executor;

.field private static sMapLooperHandler:Landroid/os/Handler;

.field private static sMapLooperThread:Ljava/lang/Thread;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 11
    new-instance v0, Lcom/amazon/identity/auth/device/utils/NamedCachedThreadPool;

    const-string/jumbo v1, "MAPCommonThreadPool"

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/utils/NamedCachedThreadPool;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/auth/device/utils/ThreadUtils;->MAP_COMMON_THREAD_POOL:Ljava/util/concurrent/Executor;

    .line 13
    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/Object;

    sput-object v0, Lcom/amazon/identity/auth/device/utils/ThreadUtils;->LOCK:[Ljava/lang/Object;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    return-void
.end method

.method static synthetic access$002(Landroid/os/Handler;)Landroid/os/Handler;
    .locals 0
    .param p0, "x0"    # Landroid/os/Handler;

    .prologue
    .line 9
    sput-object p0, Lcom/amazon/identity/auth/device/utils/ThreadUtils;->sMapLooperHandler:Landroid/os/Handler;

    return-object p0
.end method

.method public static getMapLooperHandler()Landroid/os/Handler;
    .locals 2

    .prologue
    .line 53
    sget-object v1, Lcom/amazon/identity/auth/device/utils/ThreadUtils;->LOCK:[Ljava/lang/Object;

    monitor-enter v1

    .line 55
    :try_start_0
    sget-object v0, Lcom/amazon/identity/auth/device/utils/ThreadUtils;->sMapLooperHandler:Landroid/os/Handler;

    if-eqz v0, :cond_0

    .line 57
    sget-object v0, Lcom/amazon/identity/auth/device/utils/ThreadUtils;->sMapLooperHandler:Landroid/os/Handler;

    monitor-exit v1

    .line 75
    :goto_0
    return-object v0

    .line 60
    :cond_0
    new-instance v0, Lcom/amazon/identity/auth/device/utils/ThreadUtils$1;

    invoke-direct {v0}, Lcom/amazon/identity/auth/device/utils/ThreadUtils$1;-><init>()V

    .line 73
    sput-object v0, Lcom/amazon/identity/auth/device/utils/ThreadUtils;->sMapLooperThread:Ljava/lang/Thread;

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 75
    sget-object v0, Lcom/amazon/identity/auth/device/utils/ThreadUtils;->sMapLooperHandler:Landroid/os/Handler;

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 76
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public static getNamedThreadFactory(Ljava/lang/String;)Lcom/amazon/identity/auth/device/utils/NamedThreadFactory;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 81
    new-instance v0, Lcom/amazon/identity/auth/device/utils/NamedThreadFactory;

    invoke-direct {v0, p0}, Lcom/amazon/identity/auth/device/utils/NamedThreadFactory;-><init>(Ljava/lang/String;)V

    return-object v0
.end method

.method public static isRunningOnMainThread()Z
    .locals 2

    .prologue
    .line 29
    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v0

    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    move-result-object v1

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static runOffMainThread(Ljava/lang/Runnable;)V
    .locals 1
    .param p0, "command"    # Ljava/lang/Runnable;

    .prologue
    .line 40
    invoke-static {}, Lcom/amazon/identity/auth/device/utils/ThreadUtils;->isRunningOnMainThread()Z

    move-result v0

    if-nez v0, :cond_0

    .line 42
    invoke-interface {p0}, Ljava/lang/Runnable;->run()V

    .line 49
    :goto_0
    return-void

    .line 46
    :cond_0
    invoke-static {p0}, Lcom/amazon/identity/auth/device/utils/ThreadUtils;->submitToBackgroundThread(Ljava/lang/Runnable;)V

    goto :goto_0
.end method

.method public static runOnMainThread(Ljava/lang/Runnable;)V
    .locals 2
    .param p0, "command"    # Ljava/lang/Runnable;

    .prologue
    .line 34
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 35
    invoke-virtual {v0, p0}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 36
    return-void
.end method

.method public static submitToBackgroundThread(Ljava/lang/Runnable;)V
    .locals 1
    .param p0, "command"    # Ljava/lang/Runnable;

    .prologue
    .line 24
    sget-object v0, Lcom/amazon/identity/auth/device/utils/ThreadUtils;->MAP_COMMON_THREAD_POOL:Ljava/util/concurrent/Executor;

    invoke-interface {v0, p0}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 25
    return-void
.end method
