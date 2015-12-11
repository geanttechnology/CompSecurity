.class public abstract Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask;
.super Ljava/lang/Object;
.source "RevalidatingCachingTask.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/taskexecutor/task/Task;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<R:",
        "Ljava/lang/Object;",
        "RP:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
        "<TR;>;"
    }
.end annotation


# instance fields
.field private cacheVersion:Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TRP;"
        }
    .end annotation
.end field

.field private cachedResource:Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TR;"
        }
    .end annotation
.end field

.field private final fetchLock:Ljava/lang/Object;

.field private final resourceLock:Ljava/lang/Object;

.field private revalidationPolicy:Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy",
            "<TRP;>;"
        }
    .end annotation
.end field

.field private staleResource:Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TR;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy",
            "<TRP;>;)V"
        }
    .end annotation

    .prologue
    .line 16
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask;, "Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask<TR;TRP;>;"
    .local p1, "revalidationPolicy":Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;, "Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy<TRP;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 7
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask;->resourceLock:Ljava/lang/Object;

    .line 8
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask;->fetchLock:Ljava/lang/Object;

    .line 17
    iput-object p1, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask;->revalidationPolicy:Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;

    .line 18
    return-void
.end method


# virtual methods
.method public clearCachedResult()V
    .locals 2

    .prologue
    .line 83
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask;, "Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask<TR;TRP;>;"
    iget-object v1, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask;->resourceLock:Ljava/lang/Object;

    monitor-enter v1

    .line 84
    const/4 v0, 0x0

    :try_start_0
    iput-object v0, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask;->cachedResource:Ljava/lang/Object;

    .line 85
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask;->staleResource:Ljava/lang/Object;

    .line 86
    monitor-exit v1

    .line 87
    return-void

    .line 86
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public execute()Ljava/lang/Object;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TR;"
        }
    .end annotation

    .prologue
    .line 46
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask;, "Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask<TR;TRP;>;"
    iget-object v3, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask;->fetchLock:Ljava/lang/Object;

    monitor-enter v3

    .line 47
    :try_start_0
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask;->getCachedResultIfAvailable()Ljava/lang/Object;

    move-result-object v1

    .line 48
    .local v1, "resource":Ljava/lang/Object;, "TR;"
    if-eqz v1, :cond_0

    .line 49
    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-object v2, v1

    .line 67
    :goto_0
    return-object v2

    .line 53
    :cond_0
    :try_start_1
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask;->fetchResourceWithNoCache()Ljava/lang/Object;
    :try_end_1
    .catch Ljava/lang/RuntimeException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v1

    .line 63
    :try_start_2
    iget-object v4, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask;->resourceLock:Ljava/lang/Object;

    monitor-enter v4
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 64
    :try_start_3
    iput-object v1, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask;->cachedResource:Ljava/lang/Object;

    .line 65
    iput-object v1, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask;->staleResource:Ljava/lang/Object;

    .line 66
    iget-object v2, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask;->revalidationPolicy:Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;

    invoke-interface {v2}, Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;->getCurrentVersion()Ljava/lang/Object;

    move-result-object v2

    iput-object v2, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask;->cacheVersion:Ljava/lang/Object;

    .line 67
    iget-object v2, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask;->cachedResource:Ljava/lang/Object;

    monitor-exit v4
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_2

    :try_start_4
    monitor-exit v3

    goto :goto_0

    .line 69
    .end local v1    # "resource":Ljava/lang/Object;, "TR;"
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    throw v2

    .line 54
    .restart local v1    # "resource":Ljava/lang/Object;, "TR;"
    :catch_0
    move-exception v0

    .line 55
    .local v0, "e":Ljava/lang/RuntimeException;
    :try_start_5
    iget-object v4, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask;->resourceLock:Ljava/lang/Object;

    monitor-enter v4
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 56
    :try_start_6
    iget-object v2, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask;->revalidationPolicy:Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;

    iget-object v5, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask;->cacheVersion:Ljava/lang/Object;

    invoke-interface {v2, v5}, Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;->shouldFallBackToLastCached(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    iget-object v2, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask;->staleResource:Ljava/lang/Object;

    if-eqz v2, :cond_1

    .line 57
    iget-object v2, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask;->staleResource:Ljava/lang/Object;

    monitor-exit v4
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    :try_start_7
    monitor-exit v3
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    goto :goto_0

    .line 59
    :cond_1
    :try_start_8
    monitor-exit v4
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_1

    .line 60
    :try_start_9
    throw v0
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_0

    .line 59
    :catchall_1
    move-exception v2

    :try_start_a
    monitor-exit v4
    :try_end_a
    .catchall {:try_start_a .. :try_end_a} :catchall_1

    :try_start_b
    throw v2
    :try_end_b
    .catchall {:try_start_b .. :try_end_b} :catchall_0

    .line 68
    .end local v0    # "e":Ljava/lang/RuntimeException;
    :catchall_2
    move-exception v2

    :try_start_c
    monitor-exit v4
    :try_end_c
    .catchall {:try_start_c .. :try_end_c} :catchall_2

    :try_start_d
    throw v2
    :try_end_d
    .catchall {:try_start_d .. :try_end_d} :catchall_0
.end method

.method protected abstract fetchResourceWithNoCache()Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TR;"
        }
    .end annotation
.end method

.method public getCachedResultIfAvailable()Ljava/lang/Object;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TR;"
        }
    .end annotation

    .prologue
    .line 22
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask;, "Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask<TR;TRP;>;"
    iget-object v1, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask;->resourceLock:Ljava/lang/Object;

    monitor-enter v1

    .line 23
    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask;->cachedResource:Ljava/lang/Object;

    if-eqz v0, :cond_0

    .line 24
    iget-object v0, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask;->revalidationPolicy:Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;

    iget-object v2, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask;->cacheVersion:Ljava/lang/Object;

    invoke-interface {v0, v2}, Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;->shouldRevalidate(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 25
    iget-object v0, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask;->cachedResource:Ljava/lang/Object;

    monitor-exit v1

    .line 28
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    monitor-exit v1

    goto :goto_0

    .line 29
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public getSecondLevelStaleResultIfAvailable()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TR;"
        }
    .end annotation

    .prologue
    .line 41
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask;, "Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask<TR;TRP;>;"
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask;->getStaleResultIfAvailable()Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getStaleResultIfAvailable()Ljava/lang/Object;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TR;"
        }
    .end annotation

    .prologue
    .line 34
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask;, "Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask<TR;TRP;>;"
    iget-object v1, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask;->resourceLock:Ljava/lang/Object;

    monitor-enter v1

    .line 35
    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask;->staleResource:Ljava/lang/Object;

    monitor-exit v1

    return-object v0

    .line 36
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method
