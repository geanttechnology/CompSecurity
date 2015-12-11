.class public abstract Lcom/amazon/identity/auth/device/callback/AsyncToSyncAdapter;
.super Ljava/lang/Object;
.source "AsyncToSyncAdapter.java"

# interfaces
.implements Ljava/lang/Runnable;


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private volatile mAsyncTaskDoneLatch:Ljava/util/concurrent/CountDownLatch;

.field private mHasRun:Ljava/util/concurrent/atomic/AtomicBoolean;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 18
    const-class v0, Lcom/amazon/identity/auth/device/callback/AsyncToSyncAdapter;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/callback/AsyncToSyncAdapter;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    new-instance v0, Ljava/util/concurrent/CountDownLatch;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Ljava/util/concurrent/CountDownLatch;-><init>(I)V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/callback/AsyncToSyncAdapter;->mAsyncTaskDoneLatch:Ljava/util/concurrent/CountDownLatch;

    .line 21
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/callback/AsyncToSyncAdapter;->mHasRun:Ljava/util/concurrent/atomic/AtomicBoolean;

    return-void
.end method


# virtual methods
.method protected asyncOperationComplete()V
    .locals 1

    .prologue
    .line 103
    iget-object v0, p0, Lcom/amazon/identity/auth/device/callback/AsyncToSyncAdapter;->mAsyncTaskDoneLatch:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v0}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    .line 104
    return-void
.end method

.method protected interruptAsyncOperation()V
    .locals 0

    .prologue
    .line 86
    return-void
.end method

.method protected onTimeout()V
    .locals 0

    .prologue
    .line 95
    return-void
.end method

.method public declared-synchronized run()V
    .locals 3

    .prologue
    .line 29
    monitor-enter p0

    const/4 v0, 0x0

    const/4 v1, 0x0

    const/4 v2, 0x0

    :try_start_0
    invoke-virtual {p0, v0, v1, v2}, Lcom/amazon/identity/auth/device/callback/AsyncToSyncAdapter;->run(Ljava/lang/Long;Ljava/util/concurrent/TimeUnit;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 30
    monitor-exit p0

    return-void

    .line 29
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized run(Ljava/lang/Long;Ljava/util/concurrent/TimeUnit;Ljava/lang/String;)V
    .locals 4
    .param p1, "timeout"    # Ljava/lang/Long;
    .param p2, "unit"    # Ljava/util/concurrent/TimeUnit;
    .param p3, "operation"    # Ljava/lang/String;

    .prologue
    .line 38
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/callback/AsyncToSyncAdapter;->mHasRun:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;->getAndSet(Z)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 40
    sget-object v0, Lcom/amazon/identity/auth/device/callback/AsyncToSyncAdapter;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Attempted to call run() more than once on the same object."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 71
    :goto_0
    monitor-exit p0

    return-void

    .line 44
    :cond_0
    :try_start_1
    sget-object v0, Lcom/amazon/identity/auth/device/callback/AsyncToSyncAdapter;->TAG:Ljava/lang/String;

    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    aput-object p3, v0, v1

    .line 45
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/callback/AsyncToSyncAdapter;->startAsyncOperation()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 50
    :cond_1
    if-eqz p1, :cond_3

    .line 52
    :try_start_2
    iget-object v0, p0, Lcom/amazon/identity/auth/device/callback/AsyncToSyncAdapter;->mAsyncTaskDoneLatch:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {p1}, Ljava/lang/Long;->longValue()J

    move-result-wide v1

    invoke-virtual {v0, v1, v2, p2}, Ljava/util/concurrent/CountDownLatch;->await(JLjava/util/concurrent/TimeUnit;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 54
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/callback/AsyncToSyncAdapter;->onTimeout()V
    :try_end_2
    .catch Ljava/lang/InterruptedException; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 69
    :cond_2
    :goto_1
    :try_start_3
    iget-object v0, p0, Lcom/amazon/identity/auth/device/callback/AsyncToSyncAdapter;->mAsyncTaskDoneLatch:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v0}, Ljava/util/concurrent/CountDownLatch;->getCount()J

    move-result-wide v0

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-gtz v0, :cond_1

    .line 70
    sget-object v0, Lcom/amazon/identity/auth/device/callback/AsyncToSyncAdapter;->TAG:Ljava/lang/String;

    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    aput-object p3, v0, v1
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_0

    .line 38
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    .line 59
    :cond_3
    :try_start_4
    iget-object v0, p0, Lcom/amazon/identity/auth/device/callback/AsyncToSyncAdapter;->mAsyncTaskDoneLatch:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v0}, Ljava/util/concurrent/CountDownLatch;->await()V
    :try_end_4
    .catch Ljava/lang/InterruptedException; {:try_start_4 .. :try_end_4} :catch_0
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    goto :goto_1

    .line 66
    :catch_0
    move-exception v0

    :try_start_5
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/callback/AsyncToSyncAdapter;->interruptAsyncOperation()V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    goto :goto_1
.end method

.method protected abstract startAsyncOperation()V
.end method
