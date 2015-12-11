.class Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidator;
.super Ljava/lang/Object;
.source "AsynchronousValidator.java"


# instance fields
.field private final cacheKeyGenerator:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheKeyGenerator;

.field private final cachingClient:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;

.field private final executor:Ljava/util/concurrent/ExecutorService;

.field private final log:Lorg/apache/commons/logging/Log;

.field private final queued:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheConfig;)V
    .locals 8
    .param p1, "cachingClient"    # Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;
    .param p2, "config"    # Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheConfig;

    .prologue
    .line 71
    new-instance v1, Ljava/util/concurrent/ThreadPoolExecutor;

    invoke-virtual {p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheConfig;->getAsynchronousWorkersCore()I

    move-result v2

    invoke-virtual {p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheConfig;->getAsynchronousWorkersMax()I

    move-result v3

    invoke-virtual {p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheConfig;->getAsynchronousWorkerIdleLifetimeSecs()I

    move-result v0

    int-to-long v4, v0

    sget-object v6, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    new-instance v7, Ljava/util/concurrent/ArrayBlockingQueue;

    invoke-virtual {p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheConfig;->getRevalidationQueueSize()I

    move-result v0

    invoke-direct {v7, v0}, Ljava/util/concurrent/ArrayBlockingQueue;-><init>(I)V

    invoke-direct/range {v1 .. v7}, Ljava/util/concurrent/ThreadPoolExecutor;-><init>(IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;)V

    invoke-direct {p0, p1, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidator;-><init>(Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;Ljava/util/concurrent/ExecutorService;)V

    .line 78
    return-void
.end method

.method constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;Ljava/util/concurrent/ExecutorService;)V
    .locals 1
    .param p1, "cachingClient"    # Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;
    .param p2, "executor"    # Ljava/util/concurrent/ExecutorService;

    .prologue
    .line 88
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 55
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-static {v0}, Lorg/apache/commons/logging/LogFactory;->getLog(Ljava/lang/Class;)Lorg/apache/commons/logging/Log;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidator;->log:Lorg/apache/commons/logging/Log;

    .line 89
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidator;->cachingClient:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;

    .line 90
    iput-object p2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidator;->executor:Ljava/util/concurrent/ExecutorService;

    .line 91
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidator;->queued:Ljava/util/Set;

    .line 92
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheKeyGenerator;

    invoke-direct {v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheKeyGenerator;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidator;->cacheKeyGenerator:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheKeyGenerator;

    .line 93
    return-void
.end method


# virtual methods
.method declared-synchronized markComplete(Ljava/lang/String;)V
    .locals 1
    .param p1, "identifier"    # Ljava/lang/String;

    .prologue
    .line 130
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidator;->queued:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 131
    monitor-exit p0

    return-void

    .line 130
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized revalidateCacheEntry(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)V
    .locals 9
    .param p1, "target"    # Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    .param p2, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p3, "context"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    .param p4, "entry"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;

    .prologue
    .line 106
    monitor-enter p0

    :try_start_0
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidator;->cacheKeyGenerator:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheKeyGenerator;

    invoke-virtual {v1, p1, p2, p4}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheKeyGenerator;->getVariantURI(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)Ljava/lang/String;

    move-result-object v7

    .line 108
    .local v7, "uri":Ljava/lang/String;
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidator;->queued:Ljava/util/Set;

    invoke-interface {v1, v7}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 109
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidationRequest;

    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidator;->cachingClient:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;

    move-object v1, p0

    move-object v3, p1

    move-object v4, p2

    move-object v5, p3

    move-object v6, p4

    invoke-direct/range {v0 .. v7}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidationRequest;-><init>(Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidator;Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 114
    .local v0, "revalidationRequest":Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidationRequest;
    :try_start_1
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidator;->executor:Ljava/util/concurrent/ExecutorService;

    invoke-interface {v1, v0}, Ljava/util/concurrent/ExecutorService;->execute(Ljava/lang/Runnable;)V

    .line 115
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidator;->queued:Ljava/util/Set;

    invoke-interface {v1, v7}, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    :try_end_1
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 120
    .end local v0    # "revalidationRequest":Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidationRequest;
    :cond_0
    :goto_0
    monitor-exit p0

    return-void

    .line 116
    .restart local v0    # "revalidationRequest":Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidationRequest;
    :catch_0
    move-exception v8

    .line 117
    .local v8, "ree":Ljava/util/concurrent/RejectedExecutionException;
    :try_start_2
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidator;->log:Lorg/apache/commons/logging/Log;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Revalidation for ["

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "] not scheduled: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0

    .line 106
    .end local v0    # "revalidationRequest":Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidationRequest;
    .end local v7    # "uri":Ljava/lang/String;
    .end local v8    # "ree":Ljava/util/concurrent/RejectedExecutionException;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method
