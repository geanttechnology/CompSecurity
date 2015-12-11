.class public Lcom/amazon/ansel/fetch/UiThreadExecutor;
.super Ljava/lang/Object;
.source "UiThreadExecutor.java"

# interfaces
.implements Ljava/util/concurrent/Executor;


# static fields
.field private static instance:Lcom/amazon/ansel/fetch/UiThreadExecutor;


# instance fields
.field private final handler:Landroid/os/Handler;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 12
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    iput-object v0, p0, Lcom/amazon/ansel/fetch/UiThreadExecutor;->handler:Landroid/os/Handler;

    return-void
.end method

.method public static declared-synchronized getInstance()Lcom/amazon/ansel/fetch/UiThreadExecutor;
    .locals 2

    .prologue
    .line 19
    const-class v1, Lcom/amazon/ansel/fetch/UiThreadExecutor;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/amazon/ansel/fetch/UiThreadExecutor;->instance:Lcom/amazon/ansel/fetch/UiThreadExecutor;

    if-nez v0, :cond_0

    .line 20
    new-instance v0, Lcom/amazon/ansel/fetch/UiThreadExecutor;

    invoke-direct {v0}, Lcom/amazon/ansel/fetch/UiThreadExecutor;-><init>()V

    sput-object v0, Lcom/amazon/ansel/fetch/UiThreadExecutor;->instance:Lcom/amazon/ansel/fetch/UiThreadExecutor;

    .line 23
    :cond_0
    sget-object v0, Lcom/amazon/ansel/fetch/UiThreadExecutor;->instance:Lcom/amazon/ansel/fetch/UiThreadExecutor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 19
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method


# virtual methods
.method public execute(Ljava/lang/Runnable;)V
    .locals 2
    .param p1, "runnable"    # Ljava/lang/Runnable;

    .prologue
    .line 31
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/ansel/fetch/UiThreadExecutor;->handler:Landroid/os/Handler;

    invoke-virtual {v1}, Landroid/os/Handler;->getLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-virtual {v1}, Landroid/os/Looper;->getThread()Ljava/lang/Thread;

    move-result-object v1

    if-ne v0, v1, :cond_0

    .line 32
    invoke-interface {p1}, Ljava/lang/Runnable;->run()V

    .line 36
    :goto_0
    return-void

    .line 34
    :cond_0
    iget-object v0, p0, Lcom/amazon/ansel/fetch/UiThreadExecutor;->handler:Landroid/os/Handler;

    invoke-virtual {v0, p1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    goto :goto_0
.end method
