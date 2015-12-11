.class public abstract Lcom/amazon/ansel/fetch/LoaderTask;
.super Ljava/lang/Object;
.source "LoaderTask.java"

# interfaces
.implements Lcom/amazon/ansel/fetch/MutablePrioritized;
.implements Ljava/lang/Comparable;
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/ansel/fetch/LoaderTask$AbstractListener;,
        Lcom/amazon/ansel/fetch/LoaderTask$Listener;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<Result:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/amazon/ansel/fetch/MutablePrioritized;",
        "Ljava/lang/Comparable",
        "<",
        "Lcom/amazon/ansel/fetch/LoaderTask",
        "<TResult;>;>;",
        "Ljava/lang/Runnable;"
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final context:Lcom/amazon/ansel/fetch/LoaderContext;

.field private disposed:Ljava/util/concurrent/atomic/AtomicBoolean;

.field private final loaders:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/ansel/fetch/ResourceLoader",
            "<TResult;>;>;"
        }
    .end annotation
.end field

.field private volatile priority:J

.field private final resourceKey:Ljava/lang/Object;

.field private volatile state:I

.field private stateLock:Ljava/lang/Object;

.field private volatile submitted:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 22
    const-class v0, Lcom/amazon/ansel/fetch/LoaderTask;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/ansel/fetch/LoaderTask;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lcom/amazon/ansel/fetch/LoaderContext;Ljava/lang/Object;J)V
    .locals 2
    .param p1, "context"    # Lcom/amazon/ansel/fetch/LoaderContext;
    .param p2, "resourceKey"    # Ljava/lang/Object;
    .param p3, "priority"    # J

    .prologue
    .line 24
    .local p0, "this":Lcom/amazon/ansel/fetch/LoaderTask;, "Lcom/amazon/ansel/fetch/LoaderTask<TResult;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 14
    const/4 v0, 0x1

    iput v0, p0, Lcom/amazon/ansel/fetch/LoaderTask;->state:I

    .line 15
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/amazon/ansel/fetch/LoaderTask;->stateLock:Ljava/lang/Object;

    .line 18
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/amazon/ansel/fetch/LoaderTask;->priority:J

    .line 19
    new-instance v0, Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-direct {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/ansel/fetch/LoaderTask;->loaders:Ljava/util/List;

    .line 21
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V

    iput-object v0, p0, Lcom/amazon/ansel/fetch/LoaderTask;->disposed:Ljava/util/concurrent/atomic/AtomicBoolean;

    .line 25
    iput-object p1, p0, Lcom/amazon/ansel/fetch/LoaderTask;->context:Lcom/amazon/ansel/fetch/LoaderContext;

    .line 26
    iput-object p2, p0, Lcom/amazon/ansel/fetch/LoaderTask;->resourceKey:Ljava/lang/Object;

    .line 27
    iput-wide p3, p0, Lcom/amazon/ansel/fetch/LoaderTask;->priority:J

    .line 28
    return-void
.end method

.method private dispose()V
    .locals 3

    .prologue
    .line 267
    .local p0, "this":Lcom/amazon/ansel/fetch/LoaderTask;, "Lcom/amazon/ansel/fetch/LoaderTask<TResult;>;"
    iget-object v0, p0, Lcom/amazon/ansel/fetch/LoaderTask;->disposed:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x0

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Ljava/util/concurrent/atomic/AtomicBoolean;->compareAndSet(ZZ)Z

    move-result v0

    if-nez v0, :cond_0

    .line 278
    :goto_0
    return-void

    .line 271
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/ansel/fetch/LoaderTask;->removeFromTaskMap()V

    .line 272
    invoke-virtual {p0}, Lcom/amazon/ansel/fetch/LoaderTask;->getContext()Lcom/amazon/ansel/fetch/LoaderContext;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/ansel/fetch/LoaderContext;->getExecutor()Ljava/util/concurrent/ThreadPoolExecutor;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/util/concurrent/ThreadPoolExecutor;->remove(Ljava/lang/Runnable;)Z

    .line 273
    invoke-virtual {p0}, Lcom/amazon/ansel/fetch/LoaderTask;->sendDone()V

    .line 275
    iget-object v1, p0, Lcom/amazon/ansel/fetch/LoaderTask;->loaders:Ljava/util/List;

    monitor-enter v1

    .line 276
    :try_start_0
    iget-object v0, p0, Lcom/amazon/ansel/fetch/LoaderTask;->loaders:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 277
    monitor-exit v1

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method private log(Ljava/lang/String;)V
    .locals 3
    .param p1, "msg"    # Ljava/lang/String;

    .prologue
    .line 286
    .local p0, "this":Lcom/amazon/ansel/fetch/LoaderTask;, "Lcom/amazon/ansel/fetch/LoaderTask<TResult;>;"
    sget-object v0, Lcom/amazon/ansel/fetch/LoaderTask;->TAG:Ljava/lang/String;

    const/4 v1, 0x2

    invoke-static {v0, v1}, Lcom/amazon/ansel/fetch/log/AppLog;->isLoggable(Ljava/lang/String;I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 287
    sget-object v0, Lcom/amazon/ansel/fetch/LoaderTask;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, " (resource: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Lcom/amazon/ansel/fetch/LoaderTask;->getResourceKey()Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, ", thread: ["

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Lcom/amazon/ansel/fetch/ThreadUtil;->infoString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, "])"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/ansel/fetch/log/AppLog;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 289
    :cond_0
    return-void
.end method


# virtual methods
.method public abort()V
    .locals 2

    .prologue
    .line 247
    .local p0, "this":Lcom/amazon/ansel/fetch/LoaderTask;, "Lcom/amazon/ansel/fetch/LoaderTask<TResult;>;"
    iget v0, p0, Lcom/amazon/ansel/fetch/LoaderTask;->state:I

    and-int/lit8 v0, v0, 0x5

    if-nez v0, :cond_0

    .line 261
    :goto_0
    return-void

    .line 251
    :cond_0
    iget-object v1, p0, Lcom/amazon/ansel/fetch/LoaderTask;->stateLock:Ljava/lang/Object;

    monitor-enter v1

    .line 252
    :try_start_0
    iget v0, p0, Lcom/amazon/ansel/fetch/LoaderTask;->state:I

    and-int/lit8 v0, v0, 0x5

    if-nez v0, :cond_1

    .line 253
    monitor-exit v1

    goto :goto_0

    .line 257
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    .line 256
    :cond_1
    const/16 v0, 0x8

    :try_start_1
    iput v0, p0, Lcom/amazon/ansel/fetch/LoaderTask;->state:I

    .line 257
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 259
    invoke-virtual {p0}, Lcom/amazon/ansel/fetch/LoaderTask;->abortTask()V

    .line 260
    invoke-direct {p0}, Lcom/amazon/ansel/fetch/LoaderTask;->dispose()V

    goto :goto_0
.end method

.method protected abortTask()V
    .locals 0

    .prologue
    .line 264
    .local p0, "this":Lcom/amazon/ansel/fetch/LoaderTask;, "Lcom/amazon/ansel/fetch/LoaderTask<TResult;>;"
    return-void
.end method

.method public addLoader(Lcom/amazon/ansel/fetch/ResourceLoader;)Z
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/ansel/fetch/ResourceLoader",
            "<TResult;>;)Z"
        }
    .end annotation

    .prologue
    .local p0, "this":Lcom/amazon/ansel/fetch/LoaderTask;, "Lcom/amazon/ansel/fetch/LoaderTask<TResult;>;"
    .local p1, "loader":Lcom/amazon/ansel/fetch/ResourceLoader;, "Lcom/amazon/ansel/fetch/ResourceLoader<TResult;>;"
    const/4 v0, 0x0

    const/4 v1, 0x1

    .line 53
    iget v2, p0, Lcom/amazon/ansel/fetch/LoaderTask;->state:I

    if-eq v2, v1, :cond_0

    .line 67
    :goto_0
    return v0

    .line 57
    :cond_0
    iget-object v2, p0, Lcom/amazon/ansel/fetch/LoaderTask;->stateLock:Ljava/lang/Object;

    monitor-enter v2

    .line 58
    :try_start_0
    iget v3, p0, Lcom/amazon/ansel/fetch/LoaderTask;->state:I

    if-eq v3, v1, :cond_1

    .line 59
    monitor-exit v2

    goto :goto_0

    .line 63
    :catchall_0
    move-exception v0

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    .line 62
    :cond_1
    :try_start_1
    iget-object v0, p0, Lcom/amazon/ansel/fetch/LoaderTask;->loaders:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 63
    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 65
    invoke-virtual {p0}, Lcom/amazon/ansel/fetch/LoaderTask;->update()V

    move v0, v1

    .line 67
    goto :goto_0
.end method

.method public addToTaskMap()V
    .locals 3

    .prologue
    .line 83
    .local p0, "this":Lcom/amazon/ansel/fetch/LoaderTask;, "Lcom/amazon/ansel/fetch/LoaderTask<TResult;>;"
    invoke-virtual {p0}, Lcom/amazon/ansel/fetch/LoaderTask;->getContext()Lcom/amazon/ansel/fetch/LoaderContext;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/ansel/fetch/LoaderContext;->getTasks()Ljava/util/Map;

    move-result-object v0

    .line 85
    .local v0, "tasks":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/Object;Lcom/amazon/ansel/fetch/LoaderTask<*>;>;"
    monitor-enter v0

    .line 86
    :try_start_0
    iget-object v1, p0, Lcom/amazon/ansel/fetch/LoaderTask;->context:Lcom/amazon/ansel/fetch/LoaderContext;

    invoke-virtual {v1}, Lcom/amazon/ansel/fetch/LoaderContext;->getTasks()Ljava/util/Map;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/ansel/fetch/LoaderTask;->resourceKey:Ljava/lang/Object;

    invoke-interface {v1, v2, p0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 87
    monitor-exit v0

    .line 88
    return-void

    .line 87
    :catchall_0
    move-exception v1

    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method public cancel()V
    .locals 3

    .prologue
    .local p0, "this":Lcom/amazon/ansel/fetch/LoaderTask;, "Lcom/amazon/ansel/fetch/LoaderTask<TResult;>;"
    const/4 v2, 0x1

    .line 231
    iget v0, p0, Lcom/amazon/ansel/fetch/LoaderTask;->state:I

    if-eq v0, v2, :cond_0

    .line 244
    :goto_0
    return-void

    .line 235
    :cond_0
    iget-object v1, p0, Lcom/amazon/ansel/fetch/LoaderTask;->stateLock:Ljava/lang/Object;

    monitor-enter v1

    .line 236
    :try_start_0
    iget v0, p0, Lcom/amazon/ansel/fetch/LoaderTask;->state:I

    if-eq v0, v2, :cond_1

    .line 237
    monitor-exit v1

    goto :goto_0

    .line 241
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    .line 240
    :cond_1
    const/4 v0, 0x4

    :try_start_1
    iput v0, p0, Lcom/amazon/ansel/fetch/LoaderTask;->state:I

    .line 241
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 243
    invoke-direct {p0}, Lcom/amazon/ansel/fetch/LoaderTask;->dispose()V

    goto :goto_0
.end method

.method public compareTo(Lcom/amazon/ansel/fetch/LoaderTask;)I
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/ansel/fetch/LoaderTask",
            "<TResult;>;)I"
        }
    .end annotation

    .prologue
    .line 282
    .local p0, "this":Lcom/amazon/ansel/fetch/LoaderTask;, "Lcom/amazon/ansel/fetch/LoaderTask<TResult;>;"
    .local p1, "other":Lcom/amazon/ansel/fetch/LoaderTask;, "Lcom/amazon/ansel/fetch/LoaderTask<TResult;>;"
    iget-wide v0, p0, Lcom/amazon/ansel/fetch/LoaderTask;->priority:J

    iget-wide v2, p1, Lcom/amazon/ansel/fetch/LoaderTask;->priority:J

    cmp-long v0, v0, v2

    if-gez v0, :cond_0

    const/4 v0, -0x1

    :goto_0
    return v0

    :cond_0
    iget-wide v0, p0, Lcom/amazon/ansel/fetch/LoaderTask;->priority:J

    iget-wide v2, p1, Lcom/amazon/ansel/fetch/LoaderTask;->priority:J

    cmp-long v0, v0, v2

    if-nez v0, :cond_1

    const/4 v0, 0x0

    goto :goto_0

    :cond_1
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public bridge synthetic compareTo(Ljava/lang/Object;)I
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 13
    .local p0, "this":Lcom/amazon/ansel/fetch/LoaderTask;, "Lcom/amazon/ansel/fetch/LoaderTask<TResult;>;"
    check-cast p1, Lcom/amazon/ansel/fetch/LoaderTask;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/ansel/fetch/LoaderTask;->compareTo(Lcom/amazon/ansel/fetch/LoaderTask;)I

    move-result v0

    return v0
.end method

.method public execute()Ljava/lang/Object;
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TResult;"
        }
    .end annotation

    .prologue
    .local p0, "this":Lcom/amazon/ansel/fetch/LoaderTask;, "Lcom/amazon/ansel/fetch/LoaderTask<TResult;>;"
    const/4 v8, 0x1

    .line 113
    const/4 v2, 0x0

    .line 114
    .local v2, "result":Ljava/lang/Object;, "TResult;"
    const/4 v1, 0x0

    .line 117
    .local v1, "error":Ljava/lang/Throwable;
    :try_start_0
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "Executing with priority "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget-wide v6, p0, Lcom/amazon/ansel/fetch/LoaderTask;->priority:J

    invoke-virtual {v5, v6, v7}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {p0, v5}, Lcom/amazon/ansel/fetch/LoaderTask;->log(Ljava/lang/String;)V

    .line 119
    iget v5, p0, Lcom/amazon/ansel/fetch/LoaderTask;->state:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_2

    if-eq v5, v8, :cond_4

    .line 120
    const/4 v5, 0x0

    .line 136
    invoke-virtual {p0}, Lcom/amazon/ansel/fetch/LoaderTask;->removeFromTaskMap()V

    .line 137
    const/4 v4, 0x0

    .line 139
    .local v4, "updated":Z
    iget-object v6, p0, Lcom/amazon/ansel/fetch/LoaderTask;->stateLock:Ljava/lang/Object;

    monitor-enter v6

    .line 140
    :try_start_1
    iget v7, p0, Lcom/amazon/ansel/fetch/LoaderTask;->state:I

    if-ne v7, v8, :cond_0

    .line 141
    const/4 v7, 0x2

    iput v7, p0, Lcom/amazon/ansel/fetch/LoaderTask;->state:I

    .line 142
    const/4 v4, 0x1

    .line 144
    :cond_0
    monitor-exit v6
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 146
    if-eqz v4, :cond_1

    .line 147
    if-eqz v1, :cond_3

    .line 148
    invoke-virtual {p0, v1}, Lcom/amazon/ansel/fetch/LoaderTask;->sendError(Ljava/lang/Throwable;)V

    .line 153
    :goto_0
    invoke-direct {p0}, Lcom/amazon/ansel/fetch/LoaderTask;->dispose()V

    :cond_1
    move-object v2, v5

    .line 157
    .end local v2    # "result":Ljava/lang/Object;, "TResult;"
    :cond_2
    :goto_1
    return-object v2

    .line 144
    .restart local v2    # "result":Ljava/lang/Object;, "TResult;"
    :catchall_0
    move-exception v5

    :try_start_2
    monitor-exit v6
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v5

    .line 150
    :cond_3
    invoke-virtual {p0, v2}, Lcom/amazon/ansel/fetch/LoaderTask;->sendResult(Ljava/lang/Object;)V

    goto :goto_0

    .line 123
    .end local v4    # "updated":Z
    :cond_4
    const/4 v0, 0x0

    .line 126
    .local v0, "cacheValue":Lcom/amazon/ansel/fetch/cache/ResourceCacheValue;, "Lcom/amazon/ansel/fetch/cache/ResourceCacheValue<TResult;>;"
    :try_start_3
    invoke-virtual {p0}, Lcom/amazon/ansel/fetch/LoaderTask;->executeTask()Lcom/amazon/ansel/fetch/cache/ResourceCacheValue;

    move-result-object v0

    .line 128
    if-eqz v0, :cond_5

    .line 129
    invoke-virtual {p0, v0}, Lcom/amazon/ansel/fetch/LoaderTask;->putInPrimaryCache(Lcom/amazon/ansel/fetch/cache/ResourceCacheValue;)V

    .line 130
    invoke-virtual {v0}, Lcom/amazon/ansel/fetch/cache/ResourceCacheValue;->getValue()Ljava/lang/Object;
    :try_end_3
    .catch Ljava/lang/Throwable; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_2

    move-result-object v2

    .line 136
    .end local v2    # "result":Ljava/lang/Object;, "TResult;"
    :cond_5
    :goto_2
    invoke-virtual {p0}, Lcom/amazon/ansel/fetch/LoaderTask;->removeFromTaskMap()V

    .line 137
    const/4 v4, 0x0

    .line 139
    .restart local v4    # "updated":Z
    iget-object v6, p0, Lcom/amazon/ansel/fetch/LoaderTask;->stateLock:Ljava/lang/Object;

    monitor-enter v6

    .line 140
    :try_start_4
    iget v5, p0, Lcom/amazon/ansel/fetch/LoaderTask;->state:I

    if-ne v5, v8, :cond_6

    .line 141
    const/4 v5, 0x2

    iput v5, p0, Lcom/amazon/ansel/fetch/LoaderTask;->state:I

    .line 142
    const/4 v4, 0x1

    .line 144
    :cond_6
    monitor-exit v6
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .line 146
    if-eqz v4, :cond_2

    .line 147
    if-eqz v1, :cond_7

    .line 148
    invoke-virtual {p0, v1}, Lcom/amazon/ansel/fetch/LoaderTask;->sendError(Ljava/lang/Throwable;)V

    .line 153
    :goto_3
    invoke-direct {p0}, Lcom/amazon/ansel/fetch/LoaderTask;->dispose()V

    goto :goto_1

    .line 132
    .end local v4    # "updated":Z
    .restart local v2    # "result":Ljava/lang/Object;, "TResult;"
    :catch_0
    move-exception v3

    .line 133
    .local v3, "t":Ljava/lang/Throwable;
    move-object v1, v3

    goto :goto_2

    .line 144
    .end local v2    # "result":Ljava/lang/Object;, "TResult;"
    .end local v3    # "t":Ljava/lang/Throwable;
    .restart local v4    # "updated":Z
    :catchall_1
    move-exception v5

    :try_start_5
    monitor-exit v6
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    throw v5

    .line 150
    :cond_7
    invoke-virtual {p0, v2}, Lcom/amazon/ansel/fetch/LoaderTask;->sendResult(Ljava/lang/Object;)V

    goto :goto_3

    .line 136
    .end local v0    # "cacheValue":Lcom/amazon/ansel/fetch/cache/ResourceCacheValue;, "Lcom/amazon/ansel/fetch/cache/ResourceCacheValue<TResult;>;"
    .end local v4    # "updated":Z
    .restart local v2    # "result":Ljava/lang/Object;, "TResult;"
    :catchall_2
    move-exception v5

    invoke-virtual {p0}, Lcom/amazon/ansel/fetch/LoaderTask;->removeFromTaskMap()V

    .line 137
    const/4 v4, 0x0

    .line 139
    .restart local v4    # "updated":Z
    iget-object v6, p0, Lcom/amazon/ansel/fetch/LoaderTask;->stateLock:Ljava/lang/Object;

    monitor-enter v6

    .line 140
    :try_start_6
    iget v7, p0, Lcom/amazon/ansel/fetch/LoaderTask;->state:I

    if-ne v7, v8, :cond_8

    .line 141
    const/4 v7, 0x2

    iput v7, p0, Lcom/amazon/ansel/fetch/LoaderTask;->state:I

    .line 142
    const/4 v4, 0x1

    .line 144
    :cond_8
    monitor-exit v6
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_3

    .line 146
    if-eqz v4, :cond_9

    .line 147
    if-eqz v1, :cond_a

    .line 148
    invoke-virtual {p0, v1}, Lcom/amazon/ansel/fetch/LoaderTask;->sendError(Ljava/lang/Throwable;)V

    .line 153
    :goto_4
    invoke-direct {p0}, Lcom/amazon/ansel/fetch/LoaderTask;->dispose()V

    .line 155
    :cond_9
    throw v5

    .line 144
    :catchall_3
    move-exception v5

    :try_start_7
    monitor-exit v6
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_3

    throw v5

    .line 150
    :cond_a
    invoke-virtual {p0, v2}, Lcom/amazon/ansel/fetch/LoaderTask;->sendResult(Ljava/lang/Object;)V

    goto :goto_4
.end method

.method protected abstract executeTask()Lcom/amazon/ansel/fetch/cache/ResourceCacheValue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/amazon/ansel/fetch/cache/ResourceCacheValue",
            "<TResult;>;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/ansel/fetch/LoaderException;
        }
    .end annotation
.end method

.method public getContext()Lcom/amazon/ansel/fetch/LoaderContext;
    .locals 1

    .prologue
    .line 35
    .local p0, "this":Lcom/amazon/ansel/fetch/LoaderTask;, "Lcom/amazon/ansel/fetch/LoaderTask<TResult;>;"
    iget-object v0, p0, Lcom/amazon/ansel/fetch/LoaderTask;->context:Lcom/amazon/ansel/fetch/LoaderContext;

    return-object v0
.end method

.method public getPriority()J
    .locals 2

    .prologue
    .line 44
    .local p0, "this":Lcom/amazon/ansel/fetch/LoaderTask;, "Lcom/amazon/ansel/fetch/LoaderTask<TResult;>;"
    iget-wide v0, p0, Lcom/amazon/ansel/fetch/LoaderTask;->priority:J

    return-wide v0
.end method

.method public getResourceKey()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 39
    .local p0, "this":Lcom/amazon/ansel/fetch/LoaderTask;, "Lcom/amazon/ansel/fetch/LoaderTask<TResult;>;"
    iget-object v0, p0, Lcom/amazon/ansel/fetch/LoaderTask;->resourceKey:Ljava/lang/Object;

    return-object v0
.end method

.method protected putInPrimaryCache(Lcom/amazon/ansel/fetch/cache/ResourceCacheValue;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/ansel/fetch/cache/ResourceCacheValue",
            "<TResult;>;)V"
        }
    .end annotation

    .prologue
    .line 163
    .local p0, "this":Lcom/amazon/ansel/fetch/LoaderTask;, "Lcom/amazon/ansel/fetch/LoaderTask<TResult;>;"
    .local p1, "cacheValue":Lcom/amazon/ansel/fetch/cache/ResourceCacheValue;, "Lcom/amazon/ansel/fetch/cache/ResourceCacheValue<TResult;>;"
    invoke-virtual {p0}, Lcom/amazon/ansel/fetch/LoaderTask;->getContext()Lcom/amazon/ansel/fetch/LoaderContext;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/ansel/fetch/LoaderContext;->getUseCache()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/amazon/ansel/fetch/LoaderTask;->getContext()Lcom/amazon/ansel/fetch/LoaderContext;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/ansel/fetch/LoaderContext;->getWriteCache()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/amazon/ansel/fetch/LoaderTask;->getContext()Lcom/amazon/ansel/fetch/LoaderContext;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/ansel/fetch/LoaderContext;->getUsePrimaryCache()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/amazon/ansel/fetch/LoaderTask;->getContext()Lcom/amazon/ansel/fetch/LoaderContext;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/ansel/fetch/LoaderContext;->getWritePrimaryCache()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/amazon/ansel/fetch/LoaderTask;->getContext()Lcom/amazon/ansel/fetch/LoaderContext;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/ansel/fetch/LoaderContext;->getPrimaryCache()Lcom/amazon/ansel/fetch/cache/ResourceCache;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 166
    const-string/jumbo v0, "Putting in cache"

    invoke-direct {p0, v0}, Lcom/amazon/ansel/fetch/LoaderTask;->log(Ljava/lang/String;)V

    .line 167
    invoke-virtual {p0}, Lcom/amazon/ansel/fetch/LoaderTask;->getContext()Lcom/amazon/ansel/fetch/LoaderContext;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/ansel/fetch/LoaderContext;->getPrimaryCache()Lcom/amazon/ansel/fetch/cache/ResourceCache;

    move-result-object v0

    invoke-virtual {p0}, Lcom/amazon/ansel/fetch/LoaderTask;->getResourceKey()Ljava/lang/Object;

    move-result-object v1

    invoke-interface {v0, v1, p1}, Lcom/amazon/ansel/fetch/cache/ResourceCache;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 169
    :cond_0
    return-void
.end method

.method public removeFromTaskMap()V
    .locals 3

    .prologue
    .line 91
    .local p0, "this":Lcom/amazon/ansel/fetch/LoaderTask;, "Lcom/amazon/ansel/fetch/LoaderTask<TResult;>;"
    invoke-virtual {p0}, Lcom/amazon/ansel/fetch/LoaderTask;->getContext()Lcom/amazon/ansel/fetch/LoaderContext;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/ansel/fetch/LoaderContext;->getTasks()Ljava/util/Map;

    move-result-object v1

    .line 93
    .local v1, "tasks":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/Object;Lcom/amazon/ansel/fetch/LoaderTask<*>;>;"
    monitor-enter v1

    .line 94
    :try_start_0
    iget-object v2, p0, Lcom/amazon/ansel/fetch/LoaderTask;->resourceKey:Ljava/lang/Object;

    invoke-interface {v1, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/ansel/fetch/LoaderTask;

    .line 96
    .local v0, "task":Lcom/amazon/ansel/fetch/LoaderTask;, "Lcom/amazon/ansel/fetch/LoaderTask<*>;"
    if-ne v0, p0, :cond_0

    .line 97
    iget-object v2, p0, Lcom/amazon/ansel/fetch/LoaderTask;->resourceKey:Ljava/lang/Object;

    invoke-interface {v1, v2}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 99
    :cond_0
    monitor-exit v1

    .line 100
    return-void

    .line 99
    .end local v0    # "task":Lcom/amazon/ansel/fetch/LoaderTask;, "Lcom/amazon/ansel/fetch/LoaderTask<*>;"
    :catchall_0
    move-exception v2

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2
.end method

.method public removeLoader(Lcom/amazon/ansel/fetch/ResourceLoader;Z)V
    .locals 1
    .param p2, "abort"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/ansel/fetch/ResourceLoader",
            "<TResult;>;Z)V"
        }
    .end annotation

    .prologue
    .line 71
    .local p0, "this":Lcom/amazon/ansel/fetch/LoaderTask;, "Lcom/amazon/ansel/fetch/LoaderTask<TResult;>;"
    .local p1, "loader":Lcom/amazon/ansel/fetch/ResourceLoader;, "Lcom/amazon/ansel/fetch/ResourceLoader<TResult;>;"
    iget-object v0, p0, Lcom/amazon/ansel/fetch/LoaderTask;->loaders:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    .line 73
    iget-object v0, p0, Lcom/amazon/ansel/fetch/LoaderTask;->loaders:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 74
    if-eqz p2, :cond_1

    .line 75
    invoke-virtual {p0}, Lcom/amazon/ansel/fetch/LoaderTask;->abort()V

    .line 80
    :cond_0
    :goto_0
    return-void

    .line 77
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/ansel/fetch/LoaderTask;->cancel()V

    goto :goto_0
.end method

.method public run()V
    .locals 0

    .prologue
    .line 109
    .local p0, "this":Lcom/amazon/ansel/fetch/LoaderTask;, "Lcom/amazon/ansel/fetch/LoaderTask<TResult;>;"
    invoke-virtual {p0}, Lcom/amazon/ansel/fetch/LoaderTask;->execute()Ljava/lang/Object;

    .line 110
    return-void
.end method

.method protected sendDone()V
    .locals 3

    .prologue
    .line 188
    .local p0, "this":Lcom/amazon/ansel/fetch/LoaderTask;, "Lcom/amazon/ansel/fetch/LoaderTask<TResult;>;"
    const-string/jumbo v2, "Done"

    invoke-direct {p0, v2}, Lcom/amazon/ansel/fetch/LoaderTask;->log(Ljava/lang/String;)V

    .line 190
    iget-object v2, p0, Lcom/amazon/ansel/fetch/LoaderTask;->loaders:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/ansel/fetch/ResourceLoader;

    .line 191
    .local v1, "loader":Lcom/amazon/ansel/fetch/ResourceLoader;, "Lcom/amazon/ansel/fetch/ResourceLoader<TResult;>;"
    invoke-virtual {v1}, Lcom/amazon/ansel/fetch/ResourceLoader;->getTaskListener()Lcom/amazon/ansel/fetch/LoaderTask$Listener;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/ansel/fetch/LoaderTask$Listener;->done()V

    goto :goto_0

    .line 193
    .end local v1    # "loader":Lcom/amazon/ansel/fetch/ResourceLoader;, "Lcom/amazon/ansel/fetch/ResourceLoader<TResult;>;"
    :cond_0
    return-void
.end method

.method protected sendError(Ljava/lang/Throwable;)V
    .locals 4
    .param p1, "error"    # Ljava/lang/Throwable;

    .prologue
    .line 180
    .local p0, "this":Lcom/amazon/ansel/fetch/LoaderTask;, "Lcom/amazon/ansel/fetch/LoaderTask<TResult;>;"
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "Error: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p1}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0, v2}, Lcom/amazon/ansel/fetch/LoaderTask;->log(Ljava/lang/String;)V

    .line 182
    iget-object v2, p0, Lcom/amazon/ansel/fetch/LoaderTask;->loaders:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/ansel/fetch/ResourceLoader;

    .line 183
    .local v1, "loader":Lcom/amazon/ansel/fetch/ResourceLoader;, "Lcom/amazon/ansel/fetch/ResourceLoader<TResult;>;"
    invoke-virtual {v1}, Lcom/amazon/ansel/fetch/ResourceLoader;->getTaskListener()Lcom/amazon/ansel/fetch/LoaderTask$Listener;

    move-result-object v2

    invoke-interface {v2, p1}, Lcom/amazon/ansel/fetch/LoaderTask$Listener;->error(Ljava/lang/Throwable;)V

    goto :goto_0

    .line 185
    .end local v1    # "loader":Lcom/amazon/ansel/fetch/ResourceLoader;, "Lcom/amazon/ansel/fetch/ResourceLoader<TResult;>;"
    :cond_0
    return-void
.end method

.method protected sendResult(Ljava/lang/Object;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TResult;)V"
        }
    .end annotation

    .prologue
    .line 172
    .local p0, "this":Lcom/amazon/ansel/fetch/LoaderTask;, "Lcom/amazon/ansel/fetch/LoaderTask<TResult;>;"
    .local p1, "result":Ljava/lang/Object;, "TResult;"
    const-string/jumbo v2, "Sending result"

    invoke-direct {p0, v2}, Lcom/amazon/ansel/fetch/LoaderTask;->log(Ljava/lang/String;)V

    .line 174
    iget-object v2, p0, Lcom/amazon/ansel/fetch/LoaderTask;->loaders:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/ansel/fetch/ResourceLoader;

    .line 175
    .local v1, "loader":Lcom/amazon/ansel/fetch/ResourceLoader;, "Lcom/amazon/ansel/fetch/ResourceLoader<TResult;>;"
    invoke-virtual {v1}, Lcom/amazon/ansel/fetch/ResourceLoader;->getTaskListener()Lcom/amazon/ansel/fetch/LoaderTask$Listener;

    move-result-object v2

    invoke-interface {v2, p1}, Lcom/amazon/ansel/fetch/LoaderTask$Listener;->result(Ljava/lang/Object;)V

    goto :goto_0

    .line 177
    .end local v1    # "loader":Lcom/amazon/ansel/fetch/ResourceLoader;, "Lcom/amazon/ansel/fetch/ResourceLoader<TResult;>;"
    :cond_0
    return-void
.end method

.method public setExecutionPriority(J)V
    .locals 2
    .param p1, "priority"    # J

    .prologue
    .line 217
    .local p0, "this":Lcom/amazon/ansel/fetch/LoaderTask;, "Lcom/amazon/ansel/fetch/LoaderTask<TResult;>;"
    iget-wide v0, p0, Lcom/amazon/ansel/fetch/LoaderTask;->priority:J

    cmp-long v0, v0, p1

    if-nez v0, :cond_0

    .line 228
    :goto_0
    return-void

    .line 221
    :cond_0
    iget v0, p0, Lcom/amazon/ansel/fetch/LoaderTask;->state:I

    const/4 v1, 0x1

    if-ne v0, v1, :cond_1

    iget-boolean v0, p0, Lcom/amazon/ansel/fetch/LoaderTask;->submitted:Z

    if-eqz v0, :cond_1

    invoke-virtual {p0}, Lcom/amazon/ansel/fetch/LoaderTask;->getContext()Lcom/amazon/ansel/fetch/LoaderContext;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/ansel/fetch/LoaderContext;->getExecutor()Ljava/util/concurrent/ThreadPoolExecutor;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/util/concurrent/ThreadPoolExecutor;->remove(Ljava/lang/Runnable;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 222
    :cond_1
    iput-wide p1, p0, Lcom/amazon/ansel/fetch/LoaderTask;->priority:J

    goto :goto_0

    .line 226
    :cond_2
    iput-wide p1, p0, Lcom/amazon/ansel/fetch/LoaderTask;->priority:J

    .line 227
    invoke-virtual {p0}, Lcom/amazon/ansel/fetch/LoaderTask;->submit()V

    goto :goto_0
.end method

.method public submit()V
    .locals 1

    .prologue
    .line 103
    .local p0, "this":Lcom/amazon/ansel/fetch/LoaderTask;, "Lcom/amazon/ansel/fetch/LoaderTask<TResult;>;"
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/ansel/fetch/LoaderTask;->submitted:Z

    .line 104
    iget-object v0, p0, Lcom/amazon/ansel/fetch/LoaderTask;->context:Lcom/amazon/ansel/fetch/LoaderContext;

    invoke-virtual {v0}, Lcom/amazon/ansel/fetch/LoaderContext;->getExecutor()Ljava/util/concurrent/ThreadPoolExecutor;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/util/concurrent/ThreadPoolExecutor;->execute(Ljava/lang/Runnable;)V

    .line 105
    return-void
.end method

.method protected update()V
    .locals 7

    .prologue
    .line 199
    .local p0, "this":Lcom/amazon/ansel/fetch/LoaderTask;, "Lcom/amazon/ansel/fetch/LoaderTask<TResult;>;"
    const-wide/high16 v4, -0x8000000000000000L

    .line 201
    .local v4, "maxPriority":J
    iget-object v6, p0, Lcom/amazon/ansel/fetch/LoaderTask;->loaders:Ljava/util/List;

    invoke-interface {v6}, Ljava/util/List;->isEmpty()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 202
    const-wide/16 v4, 0x0

    .line 213
    :cond_0
    invoke-virtual {p0, v4, v5}, Lcom/amazon/ansel/fetch/LoaderTask;->setExecutionPriority(J)V

    .line 214
    return-void

    .line 204
    :cond_1
    iget-object v6, p0, Lcom/amazon/ansel/fetch/LoaderTask;->loaders:Ljava/util/List;

    invoke-interface {v6}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_2
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/ansel/fetch/ResourceLoader;

    .line 205
    .local v1, "loader":Lcom/amazon/ansel/fetch/ResourceLoader;, "Lcom/amazon/ansel/fetch/ResourceLoader<TResult;>;"
    invoke-virtual {v1}, Lcom/amazon/ansel/fetch/ResourceLoader;->getPriority()J

    move-result-wide v2

    .line 207
    .local v2, "loaderPriority":J
    cmp-long v6, v2, v4

    if-lez v6, :cond_2

    .line 208
    invoke-virtual {v1}, Lcom/amazon/ansel/fetch/ResourceLoader;->getPriority()J

    move-result-wide v4

    goto :goto_0
.end method
