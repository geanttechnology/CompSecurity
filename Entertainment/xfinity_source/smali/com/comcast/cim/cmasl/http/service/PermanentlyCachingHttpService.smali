.class public Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService;
.super Ljava/lang/Object;
.source "PermanentlyCachingHttpService.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/http/service/HttpService;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService$StreamStoringResponseHandler;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/comcast/cim/cmasl/http/service/HttpService",
        "<TT;",
        "Lcom/comcast/cim/cmasl/http/request/CacheableRequestProvider",
        "<TT;>;>;"
    }
.end annotation


# instance fields
.field private final LOG:Lorg/slf4j/Logger;

.field private final delegate:Lcom/comcast/cim/cmasl/http/service/HttpService;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/http/service/HttpService",
            "<TT;",
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<TT;>;>;"
        }
    .end annotation
.end field

.field private final storageCache:Lcom/comcast/cim/cmasl/utils/StorageCache;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/cmasl/http/service/HttpService;Lcom/comcast/cim/cmasl/utils/StorageCache;)V
    .locals 1
    .param p2, "storageCache"    # Lcom/comcast/cim/cmasl/utils/StorageCache;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/http/service/HttpService",
            "<TT;",
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<TT;>;>;",
            "Lcom/comcast/cim/cmasl/utils/StorageCache;",
            ")V"
        }
    .end annotation

    .prologue
    .line 25
    .local p0, "this":Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService;, "Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService<TT;>;"
    .local p1, "delegate":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<TT;Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService;->LOG:Lorg/slf4j/Logger;

    .line 26
    iput-object p1, p0, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService;->delegate:Lcom/comcast/cim/cmasl/http/service/HttpService;

    .line 27
    iput-object p2, p0, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService;->storageCache:Lcom/comcast/cim/cmasl/utils/StorageCache;

    .line 28
    return-void
.end method

.method static synthetic access$000(Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService;)Lcom/comcast/cim/cmasl/utils/StorageCache;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService;

    .prologue
    .line 18
    iget-object v0, p0, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService;->storageCache:Lcom/comcast/cim/cmasl/utils/StorageCache;

    return-object v0
.end method

.method static synthetic access$300(Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService;)Lorg/slf4j/Logger;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService;

    .prologue
    .line 18
    iget-object v0, p0, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService;->LOG:Lorg/slf4j/Logger;

    return-object v0
.end method

.method static synthetic access$400(Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService;Lcom/comcast/cim/cmasl/http/response/ResponseHandler;Ljava/io/InputStream;)V
    .locals 0
    .param p0, "x0"    # Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService;
    .param p1, "x1"    # Lcom/comcast/cim/cmasl/http/response/ResponseHandler;
    .param p2, "x2"    # Ljava/io/InputStream;

    .prologue
    .line 18
    invoke-direct {p0, p1, p2}, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService;->feedCachedContentToResponseHandler(Lcom/comcast/cim/cmasl/http/response/ResponseHandler;Ljava/io/InputStream;)V

    return-void
.end method

.method private feedCachedContentToResponseHandler(Lcom/comcast/cim/cmasl/http/response/ResponseHandler;Ljava/io/InputStream;)V
    .locals 2
    .param p1, "responseHandler"    # Lcom/comcast/cim/cmasl/http/response/ResponseHandler;
    .param p2, "stream"    # Ljava/io/InputStream;

    .prologue
    .line 96
    .local p0, "this":Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService;, "Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService<TT;>;"
    iget-object v0, p0, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService;->LOG:Lorg/slf4j/Logger;

    const-string v1, "Reading stream from permanent cache"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 98
    :try_start_0
    invoke-interface {p1, p2}, Lcom/comcast/cim/cmasl/http/response/ResponseHandler;->handleResponseBody(Ljava/io/InputStream;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 100
    invoke-static {p2}, Lorg/apache/commons/io/IOUtils;->closeQuietly(Ljava/io/InputStream;)V

    .line 102
    return-void

    .line 100
    :catchall_0
    move-exception v0

    invoke-static {p2}, Lorg/apache/commons/io/IOUtils;->closeQuietly(Ljava/io/InputStream;)V

    throw v0
.end method


# virtual methods
.method public executeRequest(Lcom/comcast/cim/cmasl/http/request/CacheableRequestProvider;Lcom/comcast/cim/cmasl/utils/provider/Provider;)Lcom/comcast/cim/cmasl/http/response/ResponseHandler;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<RS::",
            "Lcom/comcast/cim/cmasl/http/response/ResponseHandler;",
            ">(",
            "Lcom/comcast/cim/cmasl/http/request/CacheableRequestProvider",
            "<TT;>;",
            "Lcom/comcast/cim/cmasl/utils/provider/Provider",
            "<TRS;>;)TRS;"
        }
    .end annotation

    .prologue
    .line 34
    .local p0, "this":Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService;, "Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService<TT;>;"
    .local p1, "requestProvider":Lcom/comcast/cim/cmasl/http/request/CacheableRequestProvider;, "Lcom/comcast/cim/cmasl/http/request/CacheableRequestProvider<TT;>;"
    .local p2, "responseHandlerProvider":Lcom/comcast/cim/cmasl/utils/provider/Provider;, "Lcom/comcast/cim/cmasl/utils/provider/Provider<TRS;>;"
    :try_start_0
    iget-object v3, p0, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService;->delegate:Lcom/comcast/cim/cmasl/http/service/HttpService;

    new-instance v4, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService$1;

    invoke-direct {v4, p0, p1, p2}, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService$1;-><init>(Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService;Lcom/comcast/cim/cmasl/http/request/CacheableRequestProvider;Lcom/comcast/cim/cmasl/utils/provider/Provider;)V

    invoke-interface {v3, p1, v4}, Lcom/comcast/cim/cmasl/http/service/HttpService;->executeRequest(Lcom/comcast/cim/cmasl/http/request/RequestProvider;Lcom/comcast/cim/cmasl/utils/provider/Provider;)Lcom/comcast/cim/cmasl/http/response/ResponseHandler;

    move-result-object v3

    check-cast v3, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService$StreamStoringResponseHandler;

    # invokes: Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService$StreamStoringResponseHandler;->getDelegate()Lcom/comcast/cim/cmasl/http/response/ResponseHandler;
    invoke-static {v3}, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService$StreamStoringResponseHandler;->access$200(Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService$StreamStoringResponseHandler;)Lcom/comcast/cim/cmasl/http/response/ResponseHandler;
    :try_end_0
    .catch Lcom/comcast/cim/cmasl/http/exceptions/CimIOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 52
    .local v1, "responseHandler":Lcom/comcast/cim/cmasl/http/response/ResponseHandler;, "TRS;"
    :goto_0
    return-object v1

    .line 39
    .end local v1    # "responseHandler":Lcom/comcast/cim/cmasl/http/response/ResponseHandler;, "TRS;"
    :catch_0
    move-exception v0

    .line 40
    .local v0, "e":Lcom/comcast/cim/cmasl/http/exceptions/CimIOException;
    iget-object v3, p0, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService;->LOG:Lorg/slf4j/Logger;

    const-string v4, "Caught IO error, we may be offline, attempt to fall back to permanent cache"

    invoke-interface {v3, v4, v0}, Lorg/slf4j/Logger;->warn(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 41
    iget-object v4, p0, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService;->storageCache:Lcom/comcast/cim/cmasl/utils/StorageCache;

    monitor-enter v4

    .line 42
    :try_start_1
    iget-object v3, p0, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService;->storageCache:Lcom/comcast/cim/cmasl/utils/StorageCache;

    invoke-interface {p1}, Lcom/comcast/cim/cmasl/http/request/CacheableRequestProvider;->getCacheKey()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v3, v5}, Lcom/comcast/cim/cmasl/utils/StorageCache;->retrieve(Ljava/lang/String;)Ljava/io/InputStream;

    move-result-object v2

    .line 43
    .local v2, "stream":Ljava/io/InputStream;
    if-nez v2, :cond_0

    .line 44
    iget-object v3, p0, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService;->LOG:Lorg/slf4j/Logger;

    const-string v5, "Cached stream not available, rethrowing"

    invoke-interface {v3, v5}, Lorg/slf4j/Logger;->warn(Ljava/lang/String;)V

    .line 45
    throw v0

    .line 50
    .end local v2    # "stream":Ljava/io/InputStream;
    :catchall_0
    move-exception v3

    monitor-exit v4
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v3

    .line 47
    .restart local v2    # "stream":Ljava/io/InputStream;
    :cond_0
    :try_start_2
    invoke-interface {p2}, Lcom/comcast/cim/cmasl/utils/provider/Provider;->get()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/comcast/cim/cmasl/http/response/ResponseHandler;

    .line 48
    .restart local v1    # "responseHandler":Lcom/comcast/cim/cmasl/http/response/ResponseHandler;, "TRS;"
    invoke-direct {p0, v1, v2}, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService;->feedCachedContentToResponseHandler(Lcom/comcast/cim/cmasl/http/response/ResponseHandler;Ljava/io/InputStream;)V

    .line 50
    monitor-exit v4
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0
.end method

.method public bridge synthetic executeRequest(Lcom/comcast/cim/cmasl/http/request/RequestProvider;Lcom/comcast/cim/cmasl/utils/provider/Provider;)Lcom/comcast/cim/cmasl/http/response/ResponseHandler;
    .locals 1
    .param p1, "x0"    # Lcom/comcast/cim/cmasl/http/request/RequestProvider;
    .param p2, "x1"    # Lcom/comcast/cim/cmasl/utils/provider/Provider;

    .prologue
    .line 18
    .local p0, "this":Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService;, "Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService<TT;>;"
    check-cast p1, Lcom/comcast/cim/cmasl/http/request/CacheableRequestProvider;

    .end local p1    # "x0":Lcom/comcast/cim/cmasl/http/request/RequestProvider;
    invoke-virtual {p0, p1, p2}, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService;->executeRequest(Lcom/comcast/cim/cmasl/http/request/CacheableRequestProvider;Lcom/comcast/cim/cmasl/utils/provider/Provider;)Lcom/comcast/cim/cmasl/http/response/ResponseHandler;

    move-result-object v0

    return-object v0
.end method
