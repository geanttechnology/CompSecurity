.class Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;
.super Ljava/lang/Object;
.source "BasicHttpCache.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/HttpCache;


# instance fields
.field private final cacheEntryUpdater:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheEntryUpdater;

.field private final cacheInvalidator:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheInvalidator;

.field private final log:Lorg/apache/commons/logging/Log;

.field private final maxObjectSizeBytes:I

.field private final resourceFactory:Lcom/comcast/cim/httpcomponentsandroid/client/cache/ResourceFactory;

.field private final responseGenerator:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedHttpResponseGenerator;

.field private final storage:Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheStorage;

.field private final uriExtractor:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheKeyGenerator;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 78
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheConfig;

    invoke-direct {v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheConfig;-><init>()V

    invoke-direct {p0, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;-><init>(Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheConfig;)V

    .line 79
    return-void
.end method

.method public constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/client/cache/ResourceFactory;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheStorage;Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheConfig;)V
    .locals 3
    .param p1, "resourceFactory"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/ResourceFactory;
    .param p2, "storage"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheStorage;
    .param p3, "config"    # Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheConfig;

    .prologue
    .line 63
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 61
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-static {v0}, Lorg/apache/commons/logging/LogFactory;->getLog(Ljava/lang/Class;)Lorg/apache/commons/logging/Log;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;->log:Lorg/apache/commons/logging/Log;

    .line 64
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;->resourceFactory:Lcom/comcast/cim/httpcomponentsandroid/client/cache/ResourceFactory;

    .line 65
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheKeyGenerator;

    invoke-direct {v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheKeyGenerator;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;->uriExtractor:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheKeyGenerator;

    .line 66
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheEntryUpdater;

    invoke-direct {v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheEntryUpdater;-><init>(Lcom/comcast/cim/httpcomponentsandroid/client/cache/ResourceFactory;)V

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;->cacheEntryUpdater:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheEntryUpdater;

    .line 67
    invoke-virtual {p3}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheConfig;->getMaxObjectSizeBytes()I

    move-result v0

    iput v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;->maxObjectSizeBytes:I

    .line 68
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedHttpResponseGenerator;

    invoke-direct {v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedHttpResponseGenerator;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;->responseGenerator:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedHttpResponseGenerator;

    .line 69
    iput-object p2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;->storage:Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheStorage;

    .line 70
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheInvalidator;

    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;->uriExtractor:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheKeyGenerator;

    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;->storage:Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheStorage;

    invoke-direct {v0, v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheInvalidator;-><init>(Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheKeyGenerator;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheStorage;)V

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;->cacheInvalidator:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheInvalidator;

    .line 71
    return-void
.end method

.method public constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheConfig;)V
    .locals 2
    .param p1, "config"    # Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheConfig;

    .prologue
    .line 74
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/HeapResourceFactory;

    invoke-direct {v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/HeapResourceFactory;-><init>()V

    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCacheStorage;

    invoke-direct {v1, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCacheStorage;-><init>(Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheConfig;)V

    invoke-direct {p0, v0, v1, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;-><init>(Lcom/comcast/cim/httpcomponentsandroid/client/cache/ResourceFactory;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheStorage;Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheConfig;)V

    .line 75
    return-void
.end method

.method static synthetic access$000(Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;)Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheKeyGenerator;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;

    .prologue
    .line 51
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;->uriExtractor:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheKeyGenerator;

    return-object v0
.end method

.method private addVariantWithEtag(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
    .locals 4
    .param p1, "variantKey"    # Ljava/lang/String;
    .param p2, "variantCacheKey"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/Variant;",
            ">;)V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 296
    .local p3, "variants":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/Variant;>;"
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;->storage:Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheStorage;

    invoke-interface {v2, p2}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheStorage;->getEntry(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;

    move-result-object v0

    .line 297
    .local v0, "entry":Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    if-nez v0, :cond_1

    .line 301
    :cond_0
    :goto_0
    return-void

    .line 298
    :cond_1
    const-string v2, "ETag"

    invoke-virtual {v0, v2}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;->getFirstHeader(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v1

    .line 299
    .local v1, "etagHeader":Lcom/comcast/cim/httpcomponentsandroid/Header;
    if-eqz v1, :cond_0

    .line 300
    invoke-interface {v1}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getValue()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/Variant;

    invoke-direct {v3, p1, p2, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/Variant;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)V

    invoke-interface {p3, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method


# virtual methods
.method public cacheAndReturnResponse(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;Ljava/util/Date;Ljava/util/Date;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .locals 7
    .param p1, "host"    # Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    .param p2, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p3, "originResponse"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .param p4, "requestSent"    # Ljava/util/Date;
    .param p5, "responseReceived"    # Ljava/util/Date;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 239
    invoke-virtual {p0, p2, p3}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;->getResponseReader(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/SizeLimitedResponseReader;

    move-result-object v6

    .line 240
    .local v6, "responseReader":Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/SizeLimitedResponseReader;
    invoke-virtual {v6}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/SizeLimitedResponseReader;->readResponse()V

    .line 242
    invoke-virtual {v6}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/SizeLimitedResponseReader;->isLimitReached()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 243
    invoke-virtual {v6}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/SizeLimitedResponseReader;->getReconstructedResponse()Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    move-result-object v1

    .line 258
    :goto_0
    return-object v1

    .line 246
    :cond_0
    invoke-virtual {v6}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/SizeLimitedResponseReader;->getResource()Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;

    move-result-object v5

    .line 247
    .local v5, "resource":Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;
    invoke-virtual {p0, p3, v5}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;->isIncompleteResponse(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 248
    invoke-virtual {p0, p3, v5}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;->generateIncompleteResponseError(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    move-result-object v1

    goto :goto_0

    .line 251
    :cond_1
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;

    invoke-interface {p3}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getStatusLine()Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

    move-result-object v3

    invoke-interface {p3}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getAllHeaders()[Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v4

    move-object v1, p4

    move-object v2, p5

    invoke-direct/range {v0 .. v5}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;-><init>(Ljava/util/Date;Ljava/util/Date;Lcom/comcast/cim/httpcomponentsandroid/StatusLine;[Lcom/comcast/cim/httpcomponentsandroid/Header;Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;)V

    .line 257
    .local v0, "entry":Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    invoke-virtual {p0, p1, p2, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;->storeInCache(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)V

    .line 258
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;->responseGenerator:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedHttpResponseGenerator;

    invoke-virtual {v1, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedHttpResponseGenerator;->generateResponse(Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    move-result-object v1

    goto :goto_0
.end method

.method doGetUpdatedParentEntry(Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;Ljava/lang/String;Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    .locals 8
    .param p1, "requestId"    # Ljava/lang/String;
    .param p2, "existing"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    .param p3, "entry"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    .param p4, "variantKey"    # Ljava/lang/String;
    .param p5, "variantCacheKey"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 192
    move-object v7, p2

    .line 193
    .local v7, "src":Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    if-nez v7, :cond_0

    .line 194
    move-object v7, p3

    .line 197
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;->resourceFactory:Lcom/comcast/cim/httpcomponentsandroid/client/cache/ResourceFactory;

    invoke-virtual {v7}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;->getResource()Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;

    move-result-object v1

    invoke-interface {v0, p1, v1}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/ResourceFactory;->copy(Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;)Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;

    move-result-object v5

    .line 198
    .local v5, "resource":Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;
    new-instance v6, Ljava/util/HashMap;

    invoke-virtual {v7}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;->getVariantMap()Ljava/util/Map;

    move-result-object v0

    invoke-direct {v6, v0}, Ljava/util/HashMap;-><init>(Ljava/util/Map;)V

    .line 199
    .local v6, "variantMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v6, p4, p5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 200
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;

    invoke-virtual {v7}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;->getRequestDate()Ljava/util/Date;

    move-result-object v1

    invoke-virtual {v7}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;->getResponseDate()Ljava/util/Date;

    move-result-object v2

    invoke-virtual {v7}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;->getStatusLine()Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

    move-result-object v3

    invoke-virtual {v7}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;->getAllHeaders()[Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v4

    invoke-direct/range {v0 .. v6}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;-><init>(Ljava/util/Date;Ljava/util/Date;Lcom/comcast/cim/httpcomponentsandroid/StatusLine;[Lcom/comcast/cim/httpcomponentsandroid/Header;Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;Ljava/util/Map;)V

    return-object v0
.end method

.method public flushCacheEntriesFor(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)V
    .locals 2
    .param p1, "host"    # Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    .param p2, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 83
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;->uriExtractor:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheKeyGenerator;

    invoke-virtual {v1, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheKeyGenerator;->getURI(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Ljava/lang/String;

    move-result-object v0

    .line 84
    .local v0, "uri":Ljava/lang/String;
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;->storage:Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheStorage;

    invoke-interface {v1, v0}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheStorage;->removeEntry(Ljava/lang/String;)V

    .line 85
    return-void
.end method

.method public flushInvalidatedCacheEntriesFor(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)V
    .locals 1
    .param p1, "host"    # Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    .param p2, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 277
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;->cacheInvalidator:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheInvalidator;

    invoke-virtual {v0, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheInvalidator;->flushInvalidatedCacheEntries(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)V

    .line 278
    return-void
.end method

.method public flushInvalidatedCacheEntriesFor(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)V
    .locals 1
    .param p1, "host"    # Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    .param p2, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p3, "response"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    .prologue
    .line 88
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;->cacheInvalidator:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheInvalidator;

    invoke-virtual {v0, p1, p2, p3}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheInvalidator;->flushInvalidatedCacheEntries(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)V

    .line 89
    return-void
.end method

.method generateIncompleteResponseError(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .locals 10
    .param p1, "response"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .param p2, "resource"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;

    .prologue
    .line 173
    const-string v4, "Content-Length"

    invoke-interface {p1, v4}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getFirstHeader(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v4

    invoke-interface {v4}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getValue()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    .line 174
    .local v0, "contentLength":I
    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpResponse;

    sget-object v4, Lcom/comcast/cim/httpcomponentsandroid/HttpVersion;->HTTP_1_1:Lcom/comcast/cim/httpcomponentsandroid/HttpVersion;

    const/16 v5, 0x1f6

    const-string v6, "Bad Gateway"

    invoke-direct {v1, v4, v5, v6}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpResponse;-><init>(Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;ILjava/lang/String;)V

    .line 176
    .local v1, "error":Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    const-string v4, "Content-Type"

    const-string v5, "text/plain;charset=UTF-8"

    invoke-interface {v1, v4, v5}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->setHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 177
    const-string v4, "Received incomplete response with Content-Length %d but actual body length %d"

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v5, v6

    const/4 v6, 0x1

    invoke-interface {p2}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;->length()J

    move-result-wide v8

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    .line 180
    .local v2, "msg":Ljava/lang/String;
    invoke-virtual {v2}, Ljava/lang/String;->getBytes()[B

    move-result-object v3

    .line 181
    .local v3, "msgBytes":[B
    const-string v4, "Content-Length"

    array-length v5, v3

    invoke-static {v5}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v5

    invoke-interface {v1, v4, v5}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->setHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 182
    new-instance v4, Lcom/comcast/cim/httpcomponentsandroid/entity/ByteArrayEntity;

    invoke-direct {v4, v3}, Lcom/comcast/cim/httpcomponentsandroid/entity/ByteArrayEntity;-><init>([B)V

    invoke-interface {v1, v4}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->setEntity(Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;)V

    .line 183
    return-object v1
.end method

.method public getCacheEntry(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    .locals 5
    .param p1, "host"    # Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    .param p2, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 267
    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;->storage:Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheStorage;

    iget-object v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;->uriExtractor:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheKeyGenerator;

    invoke-virtual {v4, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheKeyGenerator;->getURI(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Ljava/lang/String;

    move-result-object v4

    invoke-interface {v3, v4}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheStorage;->getEntry(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;

    move-result-object v0

    .line 268
    .local v0, "root":Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    if-nez v0, :cond_1

    move-object v0, v2

    .line 272
    .end local v0    # "root":Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    :cond_0
    :goto_0
    return-object v0

    .line 269
    .restart local v0    # "root":Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    :cond_1
    invoke-virtual {v0}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;->hasVariants()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 270
    invoke-virtual {v0}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;->getVariantMap()Ljava/util/Map;

    move-result-object v3

    iget-object v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;->uriExtractor:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheKeyGenerator;

    invoke-virtual {v4, p2, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheKeyGenerator;->getVariantKey(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)Ljava/lang/String;

    move-result-object v4

    invoke-interface {v3, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 271
    .local v1, "variantCacheKey":Ljava/lang/String;
    if-nez v1, :cond_2

    move-object v0, v2

    goto :goto_0

    .line 272
    :cond_2
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;->storage:Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheStorage;

    invoke-interface {v2, v1}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheStorage;->getEntry(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;

    move-result-object v0

    goto :goto_0
.end method

.method getResponseReader(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/SizeLimitedResponseReader;
    .locals 6
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p2, "backEndResponse"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    .prologue
    .line 262
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/SizeLimitedResponseReader;

    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;->resourceFactory:Lcom/comcast/cim/httpcomponentsandroid/client/cache/ResourceFactory;

    iget v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;->maxObjectSizeBytes:I

    int-to-long v2, v2

    move-object v4, p1

    move-object v5, p2

    invoke-direct/range {v0 .. v5}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/SizeLimitedResponseReader;-><init>(Lcom/comcast/cim/httpcomponentsandroid/client/cache/ResourceFactory;JLcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)V

    return-object v0
.end method

.method public getVariantCacheEntriesWithEtags(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Ljava/util/Map;
    .locals 8
    .param p1, "host"    # Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    .param p2, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/httpcomponentsandroid/HttpHost;",
            "Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;",
            ")",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/Variant;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 282
    new-instance v5, Ljava/util/HashMap;

    invoke-direct {v5}, Ljava/util/HashMap;-><init>()V

    .line 283
    .local v5, "variants":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/Variant;>;"
    iget-object v6, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;->storage:Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheStorage;

    iget-object v7, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;->uriExtractor:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheKeyGenerator;

    invoke-virtual {v7, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheKeyGenerator;->getURI(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Ljava/lang/String;

    move-result-object v7

    invoke-interface {v6, v7}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheStorage;->getEntry(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;

    move-result-object v1

    .line 284
    .local v1, "root":Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;->hasVariants()Z

    move-result v6

    if-nez v6, :cond_1

    .line 290
    :cond_0
    return-object v5

    .line 285
    :cond_1
    invoke-virtual {v1}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;->getVariantMap()Ljava/util/Map;

    move-result-object v6

    invoke-interface {v6}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v6

    invoke-interface {v6}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map$Entry;

    .line 286
    .local v2, "variant":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v2}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    .line 287
    .local v4, "variantKey":Ljava/lang/String;
    invoke-interface {v2}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 288
    .local v3, "variantCacheKey":Ljava/lang/String;
    invoke-direct {p0, v4, v3, v5}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;->addVariantWithEtag(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V

    goto :goto_0
.end method

.method isIncompleteResponse(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;)Z
    .locals 10
    .param p1, "resp"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .param p2, "resource"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;

    .prologue
    const/4 v4, 0x0

    .line 155
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getStatusLine()Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

    move-result-object v5

    invoke-interface {v5}, Lcom/comcast/cim/httpcomponentsandroid/StatusLine;->getStatusCode()I

    move-result v3

    .line 156
    .local v3, "status":I
    const/16 v5, 0xc8

    if-eq v3, v5, :cond_1

    const/16 v5, 0xce

    if-eq v3, v5, :cond_1

    .line 168
    :cond_0
    :goto_0
    return v4

    .line 160
    :cond_1
    const-string v5, "Content-Length"

    invoke-interface {p1, v5}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getFirstHeader(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v1

    .line 161
    .local v1, "hdr":Lcom/comcast/cim/httpcomponentsandroid/Header;
    if-eqz v1, :cond_0

    .line 164
    :try_start_0
    invoke-interface {v1}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getValue()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    .line 168
    .local v0, "contentLength":I
    invoke-interface {p2}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;->length()J

    move-result-wide v6

    int-to-long v8, v0

    cmp-long v5, v6, v8

    if-gez v5, :cond_0

    const/4 v4, 0x1

    goto :goto_0

    .line 165
    .end local v0    # "contentLength":I
    :catch_0
    move-exception v2

    .line 166
    .local v2, "nfe":Ljava/lang/NumberFormatException;
    goto :goto_0
.end method

.method public reuseVariantEntryFor(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/Variant;)V
    .locals 9
    .param p1, "target"    # Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    .param p2, "req"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p3, "variant"    # Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/Variant;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 134
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;->uriExtractor:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheKeyGenerator;

    invoke-virtual {v1, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheKeyGenerator;->getURI(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Ljava/lang/String;

    move-result-object v7

    .line 135
    .local v7, "parentCacheKey":Ljava/lang/String;
    invoke-virtual {p3}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/Variant;->getEntry()Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;

    move-result-object v3

    .line 136
    .local v3, "entry":Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;->uriExtractor:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheKeyGenerator;

    invoke-virtual {v1, p2, v3}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheKeyGenerator;->getVariantKey(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)Ljava/lang/String;

    move-result-object v4

    .line 137
    .local v4, "variantKey":Ljava/lang/String;
    invoke-virtual {p3}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/Variant;->getCacheKey()Ljava/lang/String;

    move-result-object v5

    .line 139
    .local v5, "variantCacheKey":Ljava/lang/String;
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache$2;

    move-object v1, p0

    move-object v2, p2

    invoke-direct/range {v0 .. v5}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache$2;-><init>(Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;Ljava/lang/String;Ljava/lang/String;)V

    .line 148
    .local v0, "callback":Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheUpdateCallback;
    :try_start_0
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;->storage:Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheStorage;

    invoke-interface {v1, v7, v0}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheStorage;->updateEntry(Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheUpdateCallback;)V
    :try_end_0
    .catch Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheUpdateException; {:try_start_0 .. :try_end_0} :catch_0

    .line 152
    :goto_0
    return-void

    .line 149
    :catch_0
    move-exception v6

    .line 150
    .local v6, "e":Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheUpdateException;
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;->log:Lorg/apache/commons/logging/Log;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Could not update key ["

    invoke-virtual {v2, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v8, "]"

    invoke-virtual {v2, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2, v6}, Lorg/apache/commons/logging/Log;->warn(Ljava/lang/Object;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method storeInCache(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)V
    .locals 1
    .param p1, "target"    # Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    .param p2, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p3, "entry"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 93
    invoke-virtual {p3}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;->hasVariants()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 94
    invoke-virtual {p0, p1, p2, p3}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;->storeVariantEntry(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)V

    .line 98
    :goto_0
    return-void

    .line 96
    :cond_0
    invoke-virtual {p0, p1, p2, p3}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;->storeNonVariantEntry(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)V

    goto :goto_0
.end method

.method storeNonVariantEntry(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)V
    .locals 2
    .param p1, "target"    # Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    .param p2, "req"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p3, "entry"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 102
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;->uriExtractor:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheKeyGenerator;

    invoke-virtual {v1, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheKeyGenerator;->getURI(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Ljava/lang/String;

    move-result-object v0

    .line 103
    .local v0, "uri":Ljava/lang/String;
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;->storage:Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheStorage;

    invoke-interface {v1, v0, p3}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheStorage;->putEntry(Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)V

    .line 104
    return-void
.end method

.method storeVariantEntry(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)V
    .locals 7
    .param p1, "target"    # Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    .param p2, "req"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p3, "entry"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 110
    iget-object v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;->uriExtractor:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheKeyGenerator;

    invoke-virtual {v4, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheKeyGenerator;->getURI(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Ljava/lang/String;

    move-result-object v2

    .line 111
    .local v2, "parentURI":Ljava/lang/String;
    iget-object v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;->uriExtractor:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheKeyGenerator;

    invoke-virtual {v4, p1, p2, p3}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheKeyGenerator;->getVariantURI(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)Ljava/lang/String;

    move-result-object v3

    .line 112
    .local v3, "variantURI":Ljava/lang/String;
    iget-object v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;->storage:Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheStorage;

    invoke-interface {v4, v3, p3}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheStorage;->putEntry(Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)V

    .line 114
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache$1;

    invoke-direct {v0, p0, p2, p3, v3}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache$1;-><init>(Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;Ljava/lang/String;)V

    .line 126
    .local v0, "callback":Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheUpdateCallback;
    :try_start_0
    iget-object v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;->storage:Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheStorage;

    invoke-interface {v4, v2, v0}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheStorage;->updateEntry(Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheUpdateCallback;)V
    :try_end_0
    .catch Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheUpdateException; {:try_start_0 .. :try_end_0} :catch_0

    .line 130
    :goto_0
    return-void

    .line 127
    :catch_0
    move-exception v1

    .line 128
    .local v1, "e":Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheUpdateException;
    iget-object v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;->log:Lorg/apache/commons/logging/Log;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Could not update key ["

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "]"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5, v1}, Lorg/apache/commons/logging/Log;->warn(Ljava/lang/Object;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public updateCacheEntry(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;Ljava/util/Date;Ljava/util/Date;)Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    .locals 7
    .param p1, "target"    # Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    .param p2, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p3, "stale"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    .param p4, "originResponse"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .param p5, "requestSent"    # Ljava/util/Date;
    .param p6, "responseReceived"    # Ljava/util/Date;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 212
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;->cacheEntryUpdater:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheEntryUpdater;

    invoke-interface {p2}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getRequestLine()Lcom/comcast/cim/httpcomponentsandroid/RequestLine;

    move-result-object v1

    invoke-interface {v1}, Lcom/comcast/cim/httpcomponentsandroid/RequestLine;->getUri()Ljava/lang/String;

    move-result-object v1

    move-object v2, p3

    move-object v3, p5

    move-object v4, p6

    move-object v5, p4

    invoke-virtual/range {v0 .. v5}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheEntryUpdater;->updateCacheEntry(Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;Ljava/util/Date;Ljava/util/Date;Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;

    move-result-object v6

    .line 218
    .local v6, "updatedEntry":Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    invoke-virtual {p0, p1, p2, v6}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;->storeInCache(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)V

    .line 219
    return-object v6
.end method

.method public updateVariantCacheEntry(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;Ljava/util/Date;Ljava/util/Date;Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    .locals 7
    .param p1, "target"    # Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    .param p2, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p3, "stale"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    .param p4, "originResponse"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .param p5, "requestSent"    # Ljava/util/Date;
    .param p6, "responseReceived"    # Ljava/util/Date;
    .param p7, "cacheKey"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 225
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;->cacheEntryUpdater:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheEntryUpdater;

    invoke-interface {p2}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getRequestLine()Lcom/comcast/cim/httpcomponentsandroid/RequestLine;

    move-result-object v1

    invoke-interface {v1}, Lcom/comcast/cim/httpcomponentsandroid/RequestLine;->getUri()Ljava/lang/String;

    move-result-object v1

    move-object v2, p3

    move-object v3, p5

    move-object v4, p6

    move-object v5, p4

    invoke-virtual/range {v0 .. v5}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheEntryUpdater;->updateCacheEntry(Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;Ljava/util/Date;Ljava/util/Date;Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;

    move-result-object v6

    .line 231
    .local v6, "updatedEntry":Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;->storage:Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheStorage;

    invoke-interface {v0, p7, v6}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheStorage;->putEntry(Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)V

    .line 232
    return-object v6
.end method
