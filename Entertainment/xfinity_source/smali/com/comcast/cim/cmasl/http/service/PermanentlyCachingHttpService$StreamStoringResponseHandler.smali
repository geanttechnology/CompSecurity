.class Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService$StreamStoringResponseHandler;
.super Ljava/lang/Object;
.source "PermanentlyCachingHttpService.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/http/response/ResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "StreamStoringResponseHandler"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<RS::",
        "Lcom/comcast/cim/cmasl/http/response/ResponseHandler;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/comcast/cim/cmasl/http/response/ResponseHandler;"
    }
.end annotation


# instance fields
.field private final cacheKey:Ljava/lang/String;

.field private final delegate:Lcom/comcast/cim/cmasl/http/response/ResponseHandler;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TRS;"
        }
    .end annotation
.end field

.field private final storageCache:Lcom/comcast/cim/cmasl/utils/StorageCache;

.field final synthetic this$0:Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService;


# direct methods
.method private constructor <init>(Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService;Lcom/comcast/cim/cmasl/utils/StorageCache;Ljava/lang/String;Lcom/comcast/cim/cmasl/http/response/ResponseHandler;)V
    .locals 0
    .param p2, "storageCache"    # Lcom/comcast/cim/cmasl/utils/StorageCache;
    .param p3, "cacheKey"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/utils/StorageCache;",
            "Ljava/lang/String;",
            "TRS;)V"
        }
    .end annotation

    .prologue
    .line 62
    .local p0, "this":Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService$StreamStoringResponseHandler;, "Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService<TT;>.StreamStoringResponseHandler<TRS;>;"
    .local p4, "delegate":Lcom/comcast/cim/cmasl/http/response/ResponseHandler;, "TRS;"
    iput-object p1, p0, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService$StreamStoringResponseHandler;->this$0:Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 63
    iput-object p4, p0, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService$StreamStoringResponseHandler;->delegate:Lcom/comcast/cim/cmasl/http/response/ResponseHandler;

    .line 64
    iput-object p3, p0, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService$StreamStoringResponseHandler;->cacheKey:Ljava/lang/String;

    .line 65
    iput-object p2, p0, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService$StreamStoringResponseHandler;->storageCache:Lcom/comcast/cim/cmasl/utils/StorageCache;

    .line 66
    return-void
.end method

.method synthetic constructor <init>(Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService;Lcom/comcast/cim/cmasl/utils/StorageCache;Ljava/lang/String;Lcom/comcast/cim/cmasl/http/response/ResponseHandler;Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService;
    .param p2, "x1"    # Lcom/comcast/cim/cmasl/utils/StorageCache;
    .param p3, "x2"    # Ljava/lang/String;
    .param p4, "x3"    # Lcom/comcast/cim/cmasl/http/response/ResponseHandler;
    .param p5, "x4"    # Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService$1;

    .prologue
    .line 55
    .local p0, "this":Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService$StreamStoringResponseHandler;, "Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService<TT;>.StreamStoringResponseHandler<TRS;>;"
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService$StreamStoringResponseHandler;-><init>(Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService;Lcom/comcast/cim/cmasl/utils/StorageCache;Ljava/lang/String;Lcom/comcast/cim/cmasl/http/response/ResponseHandler;)V

    return-void
.end method

.method static synthetic access$200(Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService$StreamStoringResponseHandler;)Lcom/comcast/cim/cmasl/http/response/ResponseHandler;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService$StreamStoringResponseHandler;

    .prologue
    .line 55
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService$StreamStoringResponseHandler;->getDelegate()Lcom/comcast/cim/cmasl/http/response/ResponseHandler;

    move-result-object v0

    return-object v0
.end method

.method private getDelegate()Lcom/comcast/cim/cmasl/http/response/ResponseHandler;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TRS;"
        }
    .end annotation

    .prologue
    .line 90
    .local p0, "this":Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService$StreamStoringResponseHandler;, "Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService<TT;>.StreamStoringResponseHandler<TRS;>;"
    iget-object v0, p0, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService$StreamStoringResponseHandler;->delegate:Lcom/comcast/cim/cmasl/http/response/ResponseHandler;

    return-object v0
.end method


# virtual methods
.method public handleResponseBody(Ljava/io/InputStream;)V
    .locals 6
    .param p1, "bodyStream"    # Ljava/io/InputStream;

    .prologue
    .line 70
    .local p0, "this":Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService$StreamStoringResponseHandler;, "Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService<TT;>.StreamStoringResponseHandler<TRS;>;"
    iget-object v1, p0, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService$StreamStoringResponseHandler;->storageCache:Lcom/comcast/cim/cmasl/utils/StorageCache;

    monitor-enter v1

    .line 71
    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService$StreamStoringResponseHandler;->this$0:Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService;

    # getter for: Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService;->LOG:Lorg/slf4j/Logger;
    invoke-static {v0}, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService;->access$300(Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService;)Lorg/slf4j/Logger;

    move-result-object v0

    const-string v2, "Storing stream to permanent cache"

    invoke-interface {v0, v2}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 72
    iget-object v0, p0, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService$StreamStoringResponseHandler;->storageCache:Lcom/comcast/cim/cmasl/utils/StorageCache;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService$StreamStoringResponseHandler;->cacheKey:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "-temp"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, p1, v2}, Lcom/comcast/cim/cmasl/utils/StorageCache;->store(Ljava/io/InputStream;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 74
    :try_start_1
    iget-object v0, p0, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService$StreamStoringResponseHandler;->this$0:Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService;

    iget-object v2, p0, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService$StreamStoringResponseHandler;->delegate:Lcom/comcast/cim/cmasl/http/response/ResponseHandler;

    iget-object v3, p0, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService$StreamStoringResponseHandler;->storageCache:Lcom/comcast/cim/cmasl/utils/StorageCache;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v5, p0, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService$StreamStoringResponseHandler;->cacheKey:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "-temp"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v3, v4}, Lcom/comcast/cim/cmasl/utils/StorageCache;->retrieve(Ljava/lang/String;)Ljava/io/InputStream;

    move-result-object v3

    # invokes: Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService;->feedCachedContentToResponseHandler(Lcom/comcast/cim/cmasl/http/response/ResponseHandler;Ljava/io/InputStream;)V
    invoke-static {v0, v2, v3}, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService;->access$400(Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService;Lcom/comcast/cim/cmasl/http/response/ResponseHandler;Ljava/io/InputStream;)V

    .line 75
    iget-object v0, p0, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService$StreamStoringResponseHandler;->storageCache:Lcom/comcast/cim/cmasl/utils/StorageCache;

    iget-object v2, p0, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService$StreamStoringResponseHandler;->storageCache:Lcom/comcast/cim/cmasl/utils/StorageCache;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v4, p0, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService$StreamStoringResponseHandler;->cacheKey:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "-temp"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3}, Lcom/comcast/cim/cmasl/utils/StorageCache;->retrieve(Ljava/lang/String;)Ljava/io/InputStream;

    move-result-object v2

    iget-object v3, p0, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService$StreamStoringResponseHandler;->cacheKey:Ljava/lang/String;

    invoke-interface {v0, v2, v3}, Lcom/comcast/cim/cmasl/utils/StorageCache;->store(Ljava/io/InputStream;Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 77
    :try_start_2
    iget-object v0, p0, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService$StreamStoringResponseHandler;->storageCache:Lcom/comcast/cim/cmasl/utils/StorageCache;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService$StreamStoringResponseHandler;->cacheKey:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "-temp"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v2}, Lcom/comcast/cim/cmasl/utils/StorageCache;->remove(Ljava/lang/String;)V

    .line 79
    monitor-exit v1

    .line 80
    return-void

    .line 77
    :catchall_0
    move-exception v0

    iget-object v2, p0, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService$StreamStoringResponseHandler;->storageCache:Lcom/comcast/cim/cmasl/utils/StorageCache;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v4, p0, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService$StreamStoringResponseHandler;->cacheKey:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "-temp"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3}, Lcom/comcast/cim/cmasl/utils/StorageCache;->remove(Ljava/lang/String;)V

    throw v0

    .line 79
    :catchall_1
    move-exception v0

    monitor-exit v1
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    throw v0
.end method

.method public handleResponseHeaders(Ljava/lang/String;Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;Ljava/util/Map;)V
    .locals 1
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "detailedRequestStatus"    # Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 86
    .local p0, "this":Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService$StreamStoringResponseHandler;, "Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService<TT;>.StreamStoringResponseHandler<TRS;>;"
    .local p3, "responseHeaders":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    iget-object v0, p0, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService$StreamStoringResponseHandler;->delegate:Lcom/comcast/cim/cmasl/http/response/ResponseHandler;

    invoke-interface {v0, p1, p2, p3}, Lcom/comcast/cim/cmasl/http/response/ResponseHandler;->handleResponseHeaders(Ljava/lang/String;Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;Ljava/util/Map;)V

    .line 87
    return-void
.end method
