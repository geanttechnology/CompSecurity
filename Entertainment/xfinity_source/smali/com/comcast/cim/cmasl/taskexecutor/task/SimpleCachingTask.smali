.class public Lcom/comcast/cim/cmasl/taskexecutor/task/SimpleCachingTask;
.super Ljava/lang/Object;
.source "SimpleCachingTask.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/taskexecutor/task/Task;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
        "<TT;>;"
    }
.end annotation


# instance fields
.field private cachedResult:Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TT;"
        }
    .end annotation
.end field

.field private final delegate:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<TT;>;"
        }
    .end annotation
.end field

.field private final lock:Ljava/lang/Object;


# virtual methods
.method public clearCachedResult()V
    .locals 2

    .prologue
    .line 66
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/task/SimpleCachingTask;, "Lcom/comcast/cim/cmasl/taskexecutor/task/SimpleCachingTask<TT;>;"
    iget-object v1, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/SimpleCachingTask;->lock:Ljava/lang/Object;

    monitor-enter v1

    .line 67
    const/4 v0, 0x0

    :try_start_0
    iput-object v0, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/SimpleCachingTask;->cachedResult:Ljava/lang/Object;

    .line 68
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 69
    iget-object v0, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/SimpleCachingTask;->delegate:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v0}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->clearCachedResult()V

    .line 70
    return-void

    .line 68
    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method

.method public execute()Ljava/lang/Object;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .prologue
    .line 44
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/task/SimpleCachingTask;, "Lcom/comcast/cim/cmasl/taskexecutor/task/SimpleCachingTask<TT;>;"
    iget-object v2, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/SimpleCachingTask;->lock:Ljava/lang/Object;

    monitor-enter v2

    .line 45
    :try_start_0
    iget-object v1, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/SimpleCachingTask;->cachedResult:Ljava/lang/Object;

    if-eqz v1, :cond_0

    .line 46
    iget-object v0, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/SimpleCachingTask;->cachedResult:Ljava/lang/Object;

    monitor-exit v2

    .line 53
    :goto_0
    return-object v0

    .line 48
    :cond_0
    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 49
    iget-object v1, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/SimpleCachingTask;->delegate:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v1}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->execute()Ljava/lang/Object;

    move-result-object v0

    .line 50
    .local v0, "result":Ljava/lang/Object;, "TT;"
    iget-object v2, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/SimpleCachingTask;->lock:Ljava/lang/Object;

    monitor-enter v2

    .line 51
    :try_start_1
    iput-object v0, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/SimpleCachingTask;->cachedResult:Ljava/lang/Object;

    .line 52
    monitor-exit v2

    goto :goto_0

    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v1

    .line 48
    .end local v0    # "result":Ljava/lang/Object;, "TT;"
    :catchall_1
    move-exception v1

    :try_start_2
    monitor-exit v2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    throw v1
.end method

.method public getCachedResultIfAvailable()Ljava/lang/Object;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .prologue
    .line 16
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/task/SimpleCachingTask;, "Lcom/comcast/cim/cmasl/taskexecutor/task/SimpleCachingTask<TT;>;"
    iget-object v1, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/SimpleCachingTask;->lock:Ljava/lang/Object;

    monitor-enter v1

    .line 17
    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/SimpleCachingTask;->cachedResult:Ljava/lang/Object;

    if-nez v0, :cond_0

    .line 18
    iget-object v0, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/SimpleCachingTask;->delegate:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v0}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->getCachedResultIfAvailable()Ljava/lang/Object;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/SimpleCachingTask;->cachedResult:Ljava/lang/Object;

    .line 20
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/SimpleCachingTask;->cachedResult:Ljava/lang/Object;

    monitor-exit v1

    return-object v0

    .line 21
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public getSecondLevelStaleResultIfAvailable()Ljava/lang/Object;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .prologue
    .line 35
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/task/SimpleCachingTask;, "Lcom/comcast/cim/cmasl/taskexecutor/task/SimpleCachingTask<TT;>;"
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/taskexecutor/task/SimpleCachingTask;->getCachedResultIfAvailable()Ljava/lang/Object;

    move-result-object v0

    .line 36
    .local v0, "cachedResult":Ljava/lang/Object;, "TT;"
    if-eqz v0, :cond_0

    .line 39
    .end local v0    # "cachedResult":Ljava/lang/Object;, "TT;"
    :goto_0
    return-object v0

    .restart local v0    # "cachedResult":Ljava/lang/Object;, "TT;"
    :cond_0
    iget-object v1, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/SimpleCachingTask;->delegate:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v1}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->getSecondLevelStaleResultIfAvailable()Ljava/lang/Object;

    move-result-object v0

    goto :goto_0
.end method

.method public getStaleResultIfAvailable()Ljava/lang/Object;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .prologue
    .line 26
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/task/SimpleCachingTask;, "Lcom/comcast/cim/cmasl/taskexecutor/task/SimpleCachingTask<TT;>;"
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/taskexecutor/task/SimpleCachingTask;->getCachedResultIfAvailable()Ljava/lang/Object;

    move-result-object v0

    .line 27
    .local v0, "cachedResult":Ljava/lang/Object;, "TT;"
    if-eqz v0, :cond_0

    .line 30
    .end local v0    # "cachedResult":Ljava/lang/Object;, "TT;"
    :goto_0
    return-object v0

    .restart local v0    # "cachedResult":Ljava/lang/Object;, "TT;"
    :cond_0
    iget-object v1, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/SimpleCachingTask;->delegate:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v1}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->getStaleResultIfAvailable()Ljava/lang/Object;

    move-result-object v0

    goto :goto_0
.end method
