.class public Lcom/disney/datg/videoplatforms/sdk/common/ThreadPoolAccessor;
.super Ljava/lang/Object;
.source "ThreadPoolAccessor.java"


# static fields
.field private static final _instance:Lcom/disney/datg/videoplatforms/sdk/common/ThreadPoolAccessor;


# instance fields
.field private executorService:Ljava/util/concurrent/ThreadPoolExecutor;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 13
    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/common/ThreadPoolAccessor;

    invoke-direct {v0}, Lcom/disney/datg/videoplatforms/sdk/common/ThreadPoolAccessor;-><init>()V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/common/ThreadPoolAccessor;->_instance:Lcom/disney/datg/videoplatforms/sdk/common/ThreadPoolAccessor;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getManager()Lcom/disney/datg/videoplatforms/sdk/common/ThreadPoolAccessor;
    .locals 2

    .prologue
    .line 17
    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/common/ThreadPoolAccessor;->_instance:Lcom/disney/datg/videoplatforms/sdk/common/ThreadPoolAccessor;

    monitor-enter v1

    .line 18
    :try_start_0
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/common/ThreadPoolAccessor;->_instance:Lcom/disney/datg/videoplatforms/sdk/common/ThreadPoolAccessor;

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/common/ThreadPoolAccessor;->executorService:Ljava/util/concurrent/ThreadPoolExecutor;

    if-nez v0, :cond_0

    .line 19
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/common/ThreadPoolAccessor;->_instance:Lcom/disney/datg/videoplatforms/sdk/common/ThreadPoolAccessor;

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/common/ThreadPoolAccessor;->setUpPool()V

    .line 20
    :cond_0
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 21
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/common/ThreadPoolAccessor;->_instance:Lcom/disney/datg/videoplatforms/sdk/common/ThreadPoolAccessor;

    return-object v0

    .line 20
    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method


# virtual methods
.method public execute(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;
    .locals 1
    .param p1, "task"    # Ljava/util/concurrent/Callable;

    .prologue
    .line 36
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/common/ThreadPoolAccessor;->executorService:Ljava/util/concurrent/ThreadPoolExecutor;

    if-nez v0, :cond_0

    .line 37
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/common/ThreadPoolAccessor;->_instance:Lcom/disney/datg/videoplatforms/sdk/common/ThreadPoolAccessor;

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/common/ThreadPoolAccessor;->setUpPool()V

    .line 39
    :cond_0
    if-eqz p1, :cond_2

    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/common/ThreadPoolAccessor;->executorService:Ljava/util/concurrent/ThreadPoolExecutor;

    invoke-virtual {v0}, Ljava/util/concurrent/ThreadPoolExecutor;->isShutdown()Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/common/ThreadPoolAccessor;->executorService:Ljava/util/concurrent/ThreadPoolExecutor;

    invoke-virtual {v0}, Ljava/util/concurrent/ThreadPoolExecutor;->isTerminated()Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/common/ThreadPoolAccessor;->executorService:Ljava/util/concurrent/ThreadPoolExecutor;

    invoke-virtual {v0}, Ljava/util/concurrent/ThreadPoolExecutor;->isTerminating()Z

    move-result v0

    if-nez v0, :cond_2

    .line 40
    :cond_1
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/common/ThreadPoolAccessor;->executorService:Ljava/util/concurrent/ThreadPoolExecutor;

    invoke-virtual {v0, p1}, Ljava/util/concurrent/ThreadPoolExecutor;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    .line 42
    :goto_0
    return-object v0

    :cond_2
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public forceCancel()V
    .locals 1

    .prologue
    .line 60
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/common/ThreadPoolAccessor;->executorService:Ljava/util/concurrent/ThreadPoolExecutor;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/common/ThreadPoolAccessor;->executorService:Ljava/util/concurrent/ThreadPoolExecutor;

    invoke-virtual {v0}, Ljava/util/concurrent/ThreadPoolExecutor;->isShutdown()Z

    move-result v0

    if-nez v0, :cond_0

    .line 61
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/common/ThreadPoolAccessor;->executorService:Ljava/util/concurrent/ThreadPoolExecutor;

    invoke-virtual {v0}, Ljava/util/concurrent/ThreadPoolExecutor;->shutdownNow()Ljava/util/List;

    .line 62
    :cond_0
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/common/ThreadPoolAccessor;->executorService:Ljava/util/concurrent/ThreadPoolExecutor;

    .line 63
    return-void
.end method

.method public setUpPool()V
    .locals 8

    .prologue
    const/4 v2, 0x6

    .line 30
    new-instance v1, Ljava/util/concurrent/ThreadPoolExecutor;

    const-wide/16 v4, 0xa

    sget-object v6, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    new-instance v7, Ljava/util/concurrent/ArrayBlockingQueue;

    invoke-direct {v7, v2}, Ljava/util/concurrent/ArrayBlockingQueue;-><init>(I)V

    move v3, v2

    invoke-direct/range {v1 .. v7}, Ljava/util/concurrent/ThreadPoolExecutor;-><init>(IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;)V

    iput-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/common/ThreadPoolAccessor;->executorService:Ljava/util/concurrent/ThreadPoolExecutor;

    .line 31
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/common/ThreadPoolAccessor;->executorService:Ljava/util/concurrent/ThreadPoolExecutor;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Ljava/util/concurrent/ThreadPoolExecutor;->allowCoreThreadTimeOut(Z)V

    .line 32
    return-void
.end method
