.class public Lcom/amazon/device/ads/ThreadUtils;
.super Ljava/lang/Object;
.source "ThreadUtils.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/device/ads/ThreadUtils$ThreadVerify;,
        Lcom/amazon/device/ads/ThreadUtils$ThreadPoolRunnableExecutor;,
        Lcom/amazon/device/ads/ThreadUtils$MainThreadRunnableExecutor;,
        Lcom/amazon/device/ads/ThreadUtils$RunnableExecutor;
    }
.end annotation


# static fields
.field private static runnableExecutor:Lcom/amazon/device/ads/ThreadUtils$RunnableExecutor;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 20
    new-instance v0, Lcom/amazon/device/ads/ThreadUtils$ThreadPoolRunnableExecutor;

    invoke-direct {v0}, Lcom/amazon/device/ads/ThreadUtils$ThreadPoolRunnableExecutor;-><init>()V

    sput-object v0, Lcom/amazon/device/ads/ThreadUtils;->runnableExecutor:Lcom/amazon/device/ads/ThreadUtils$RunnableExecutor;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 118
    return-void
.end method

.method public static final varargs executeAsyncTask(Landroid/os/AsyncTask;[Ljava/lang/Object;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Landroid/os/AsyncTask",
            "<TT;**>;[TT;)V"
        }
    .end annotation

    .prologue
    .line 34
    .local p0, "task":Landroid/os/AsyncTask;, "Landroid/os/AsyncTask<TT;**>;"
    .local p1, "params":[Ljava/lang/Object;, "[TT;"
    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v2

    if-ne v1, v2, :cond_0

    .line 36
    invoke-static {p0, p1}, Lcom/amazon/device/ads/AndroidTargetUtils;->executeAsyncTask(Landroid/os/AsyncTask;[Ljava/lang/Object;)V

    .line 50
    :goto_0
    return-void

    .line 40
    :cond_0
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 41
    .local v0, "handler":Landroid/os/Handler;
    new-instance v1, Lcom/amazon/device/ads/ThreadUtils$1;

    invoke-direct {v1, p0, p1}, Lcom/amazon/device/ads/ThreadUtils$1;-><init>(Landroid/os/AsyncTask;[Ljava/lang/Object;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    goto :goto_0
.end method

.method public static executeRunnable(Ljava/lang/Runnable;)V
    .locals 1
    .param p0, "proc"    # Ljava/lang/Runnable;

    .prologue
    .line 58
    sget-object v0, Lcom/amazon/device/ads/ThreadUtils;->runnableExecutor:Lcom/amazon/device/ads/ThreadUtils$RunnableExecutor;

    invoke-interface {v0, p0}, Lcom/amazon/device/ads/ThreadUtils$RunnableExecutor;->execute(Ljava/lang/Runnable;)V

    .line 59
    return-void
.end method

.method public static isOnMainThread()Z
    .locals 1

    .prologue
    .line 24
    invoke-static {}, Lcom/amazon/device/ads/ThreadUtils$ThreadVerify;->getInstance()Lcom/amazon/device/ads/ThreadUtils$ThreadVerify;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/device/ads/ThreadUtils$ThreadVerify;->isOnMainThread()Z

    move-result v0

    return v0
.end method

.method static setRunnableExecutor(Lcom/amazon/device/ads/ThreadUtils$RunnableExecutor;)V
    .locals 0
    .param p0, "runnableExecutor"    # Lcom/amazon/device/ads/ThreadUtils$RunnableExecutor;

    .prologue
    .line 63
    sput-object p0, Lcom/amazon/device/ads/ThreadUtils;->runnableExecutor:Lcom/amazon/device/ads/ThreadUtils$RunnableExecutor;

    .line 64
    return-void
.end method
