.class public Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;
.super Ljava/lang/Object;
.source "CachingHttpClient.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/ThreadSafe;
.end annotation


# instance fields
.field private final asynchRevalidator:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidator;

.field private final backend:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

.field private final cacheHits:Ljava/util/concurrent/atomic/AtomicLong;

.field private final cacheMisses:Ljava/util/concurrent/atomic/AtomicLong;

.field private final cacheUpdates:Ljava/util/concurrent/atomic/AtomicLong;

.field private final cacheableRequestPolicy:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheableRequestPolicy;

.field private final conditionalRequestBuilder:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ConditionalRequestBuilder;

.field private final log:Lorg/apache/commons/logging/Log;

.field private final maxObjectSizeBytes:I

.field private final requestCompliance:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/RequestProtocolCompliance;

.field private final responseCache:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/HttpCache;

.field private final responseCachingPolicy:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ResponseCachingPolicy;

.field private final responseCompliance:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ResponseProtocolCompliance;

.field private final responseGenerator:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedHttpResponseGenerator;

.field private final sharedCache:Z

.field private final suitabilityChecker:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedResponseSuitabilityChecker;

.field private final validityPolicy:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheValidityPolicy;


# direct methods
.method public constructor <init>()V
    .locals 3

    .prologue
    .line 179
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultHttpClient;

    invoke-direct {v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultHttpClient;-><init>()V

    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;

    invoke-direct {v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;-><init>()V

    new-instance v2, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheConfig;

    invoke-direct {v2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheConfig;-><init>()V

    invoke-direct {p0, v0, v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;-><init>(Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/HttpCache;Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheConfig;)V

    .line 182
    return-void
.end method

.method public constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;Lcom/comcast/cim/httpcomponentsandroid/client/cache/ResourceFactory;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheStorage;Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheConfig;)V
    .locals 1
    .param p1, "client"    # Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;
    .param p2, "resourceFactory"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/ResourceFactory;
    .param p3, "storage"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheStorage;
    .param p4, "config"    # Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheConfig;

    .prologue
    .line 236
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;

    invoke-direct {v0, p2, p3, p4}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;-><init>(Lcom/comcast/cim/httpcomponentsandroid/client/cache/ResourceFactory;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheStorage;Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheConfig;)V

    invoke-direct {p0, p1, v0, p4}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;-><init>(Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/HttpCache;Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheConfig;)V

    .line 239
    return-void
.end method

.method constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/HttpCache;Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheConfig;)V
    .locals 3
    .param p1, "client"    # Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;
    .param p2, "cache"    # Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/HttpCache;
    .param p3, "config"    # Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheConfig;

    .prologue
    .line 146
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 118
    new-instance v0, Ljava/util/concurrent/atomic/AtomicLong;

    invoke-direct {v0}, Ljava/util/concurrent/atomic/AtomicLong;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->cacheHits:Ljava/util/concurrent/atomic/AtomicLong;

    .line 119
    new-instance v0, Ljava/util/concurrent/atomic/AtomicLong;

    invoke-direct {v0}, Ljava/util/concurrent/atomic/AtomicLong;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->cacheMisses:Ljava/util/concurrent/atomic/AtomicLong;

    .line 120
    new-instance v0, Ljava/util/concurrent/atomic/AtomicLong;

    invoke-direct {v0}, Ljava/util/concurrent/atomic/AtomicLong;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->cacheUpdates:Ljava/util/concurrent/atomic/AtomicLong;

    .line 140
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-static {v0}, Lorg/apache/commons/logging/LogFactory;->getLog(Ljava/lang/Class;)Lorg/apache/commons/logging/Log;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->log:Lorg/apache/commons/logging/Log;

    .line 147
    if-nez p1, :cond_0

    .line 148
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "HttpClient may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 150
    :cond_0
    if-nez p2, :cond_1

    .line 151
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "HttpCache may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 153
    :cond_1
    if-nez p3, :cond_2

    .line 154
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "CacheConfig may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 156
    :cond_2
    invoke-virtual {p3}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheConfig;->getMaxObjectSizeBytes()I

    move-result v0

    iput v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->maxObjectSizeBytes:I

    .line 157
    invoke-virtual {p3}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheConfig;->isSharedCache()Z

    move-result v0

    iput-boolean v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->sharedCache:Z

    .line 158
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->backend:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    .line 159
    iput-object p2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->responseCache:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/HttpCache;

    .line 160
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheValidityPolicy;

    invoke-direct {v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheValidityPolicy;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->validityPolicy:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheValidityPolicy;

    .line 161
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ResponseCachingPolicy;

    iget v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->maxObjectSizeBytes:I

    iget-boolean v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->sharedCache:Z

    invoke-direct {v0, v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ResponseCachingPolicy;-><init>(IZ)V

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->responseCachingPolicy:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ResponseCachingPolicy;

    .line 162
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedHttpResponseGenerator;

    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->validityPolicy:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheValidityPolicy;

    invoke-direct {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedHttpResponseGenerator;-><init>(Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheValidityPolicy;)V

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->responseGenerator:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedHttpResponseGenerator;

    .line 163
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheableRequestPolicy;

    invoke-direct {v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheableRequestPolicy;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->cacheableRequestPolicy:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheableRequestPolicy;

    .line 164
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedResponseSuitabilityChecker;

    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->validityPolicy:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheValidityPolicy;

    invoke-direct {v0, v1, p3}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedResponseSuitabilityChecker;-><init>(Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheValidityPolicy;Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheConfig;)V

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->suitabilityChecker:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedResponseSuitabilityChecker;

    .line 165
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ConditionalRequestBuilder;

    invoke-direct {v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ConditionalRequestBuilder;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->conditionalRequestBuilder:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ConditionalRequestBuilder;

    .line 167
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ResponseProtocolCompliance;

    invoke-direct {v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ResponseProtocolCompliance;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->responseCompliance:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ResponseProtocolCompliance;

    .line 168
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/RequestProtocolCompliance;

    invoke-direct {v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/RequestProtocolCompliance;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->requestCompliance:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/RequestProtocolCompliance;

    .line 170
    invoke-direct {p0, p3}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->makeAsynchronousValidator(Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheConfig;)Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidator;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->asynchRevalidator:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidator;

    .line 171
    return-void
.end method

.method private alreadyHaveNewerCacheEntry(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)Z
    .locals 7
    .param p1, "target"    # Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    .param p2, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p3, "backendResponse"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    .prologue
    const/4 v5, 0x0

    .line 903
    const/4 v2, 0x0

    .line 905
    .local v2, "existing":Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    :try_start_0
    iget-object v6, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->responseCache:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/HttpCache;

    invoke-interface {v6, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/HttpCache;->getCacheEntry(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v2

    .line 909
    :goto_0
    if-nez v2, :cond_1

    .line 920
    :cond_0
    :goto_1
    return v5

    .line 910
    :cond_1
    const-string v6, "Date"

    invoke-virtual {v2, v6}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;->getFirstHeader(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v1

    .line 911
    .local v1, "entryDateHeader":Lcom/comcast/cim/httpcomponentsandroid/Header;
    if-eqz v1, :cond_0

    .line 912
    const-string v6, "Date"

    invoke-interface {p3, v6}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getFirstHeader(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v4

    .line 913
    .local v4, "responseDateHeader":Lcom/comcast/cim/httpcomponentsandroid/Header;
    if-eqz v4, :cond_0

    .line 915
    :try_start_1
    invoke-interface {v1}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getValue()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/DateUtils;->parseDate(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v0

    .line 916
    .local v0, "entryDate":Ljava/util/Date;
    invoke-interface {v4}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getValue()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/DateUtils;->parseDate(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v3

    .line 917
    .local v3, "responseDate":Ljava/util/Date;
    invoke-virtual {v3, v0}, Ljava/util/Date;->before(Ljava/util/Date;)Z
    :try_end_1
    .catch Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/DateParseException; {:try_start_1 .. :try_end_1} :catch_0

    move-result v5

    goto :goto_1

    .line 918
    .end local v0    # "entryDate":Ljava/util/Date;
    .end local v3    # "responseDate":Ljava/util/Date;
    :catch_0
    move-exception v6

    goto :goto_1

    .line 906
    .end local v1    # "entryDateHeader":Lcom/comcast/cim/httpcomponentsandroid/Header;
    .end local v4    # "responseDateHeader":Lcom/comcast/cim/httpcomponentsandroid/Header;
    :catch_1
    move-exception v6

    goto :goto_0
.end method

.method private explicitFreshnessRequest(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;Ljava/util/Date;)Z
    .locals 22
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p2, "entry"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    .param p3, "now"    # Ljava/util/Date;

    .prologue
    .line 613
    const-string v18, "Cache-Control"

    move-object/from16 v0, p1

    move-object/from16 v1, v18

    invoke-interface {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getHeaders(Ljava/lang/String;)[Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v6

    .local v6, "arr$":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    array-length v12, v6

    .local v12, "len$":I
    const/4 v10, 0x0

    .local v10, "i$":I
    move v11, v10

    .end local v6    # "arr$":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    .end local v10    # "i$":I
    .end local v12    # "len$":I
    .local v11, "i$":I
    :goto_0
    if-ge v11, v12, :cond_4

    aget-object v9, v6, v11

    .line 614
    .local v9, "h":Lcom/comcast/cim/httpcomponentsandroid/Header;
    invoke-interface {v9}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getElements()[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;

    move-result-object v7

    .local v7, "arr$":[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    array-length v13, v7

    .local v13, "len$":I
    const/4 v10, 0x0

    .end local v11    # "i$":I
    .restart local v10    # "i$":I
    :goto_1
    if-ge v10, v13, :cond_3

    aget-object v8, v7, v10

    .line 615
    .local v8, "elt":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    const-string v18, "max-stale"

    invoke-interface {v8}, Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;->getName()Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v18

    if-eqz v18, :cond_0

    .line 617
    :try_start_0
    invoke-interface {v8}, Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;->getValue()Ljava/lang/String;

    move-result-object v18

    invoke-static/range {v18 .. v18}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v16

    .line 618
    .local v16, "maxstale":I
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->validityPolicy:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheValidityPolicy;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    move-object/from16 v1, p2

    move-object/from16 v2, p3

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheValidityPolicy;->getCurrentAgeSecs(Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;Ljava/util/Date;)J

    move-result-wide v4

    .line 619
    .local v4, "age":J
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->validityPolicy:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheValidityPolicy;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    move-object/from16 v1, p2

    invoke-virtual {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheValidityPolicy;->getFreshnessLifetimeSecs(Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)J
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-wide v14

    .line 620
    .local v14, "lifetime":J
    sub-long v18, v4, v14

    move/from16 v0, v16

    int-to-long v0, v0

    move-wide/from16 v20, v0

    cmp-long v18, v18, v20

    if-lez v18, :cond_2

    const/16 v18, 0x1

    .line 630
    .end local v4    # "age":J
    .end local v7    # "arr$":[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .end local v8    # "elt":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .end local v9    # "h":Lcom/comcast/cim/httpcomponentsandroid/Header;
    .end local v10    # "i$":I
    .end local v13    # "len$":I
    .end local v14    # "lifetime":J
    .end local v16    # "maxstale":I
    :goto_2
    return v18

    .line 621
    .restart local v7    # "arr$":[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .restart local v8    # "elt":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .restart local v9    # "h":Lcom/comcast/cim/httpcomponentsandroid/Header;
    .restart local v10    # "i$":I
    .restart local v13    # "len$":I
    :catch_0
    move-exception v17

    .line 622
    .local v17, "nfe":Ljava/lang/NumberFormatException;
    const/16 v18, 0x1

    goto :goto_2

    .line 624
    .end local v17    # "nfe":Ljava/lang/NumberFormatException;
    :cond_0
    const-string v18, "min-fresh"

    invoke-interface {v8}, Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;->getName()Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v18

    if-nez v18, :cond_1

    const-string v18, "max-age"

    invoke-interface {v8}, Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;->getName()Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v18

    if-eqz v18, :cond_2

    .line 626
    :cond_1
    const/16 v18, 0x1

    goto :goto_2

    .line 614
    :cond_2
    add-int/lit8 v10, v10, 0x1

    goto :goto_1

    .line 613
    .end local v8    # "elt":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    :cond_3
    add-int/lit8 v10, v11, 0x1

    move v11, v10

    .end local v10    # "i$":I
    .restart local v11    # "i$":I
    goto :goto_0

    .line 630
    .end local v7    # "arr$":[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .end local v9    # "h":Lcom/comcast/cim/httpcomponentsandroid/Header;
    .end local v13    # "len$":I
    :cond_4
    const/16 v18, 0x0

    goto :goto_2
.end method

.method private flushEntriesInvalidatedByRequest(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)V
    .locals 3
    .param p1, "target"    # Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    .param p2, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;

    .prologue
    .line 549
    :try_start_0
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->responseCache:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/HttpCache;

    invoke-interface {v1, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/HttpCache;->flushInvalidatedCacheEntriesFor(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 553
    :goto_0
    return-void

    .line 550
    :catch_0
    move-exception v0

    .line 551
    .local v0, "ioe":Ljava/io/IOException;
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->log:Lorg/apache/commons/logging/Log;

    const-string v2, "Unable to flush invalidated entries from cache"

    invoke-interface {v1, v2, v0}, Lorg/apache/commons/logging/Log;->warn(Ljava/lang/Object;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method private generateCachedResponse(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;Ljava/util/Date;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .locals 6
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p2, "context"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    .param p3, "entry"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    .param p4, "now"    # Ljava/util/Date;

    .prologue
    .line 558
    const-string v1, "If-None-Match"

    invoke-interface {p1, v1}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->containsHeader(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    const-string v1, "If-Modified-Since"

    invoke-interface {p1, v1}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->containsHeader(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 560
    :cond_0
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->responseGenerator:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedHttpResponseGenerator;

    invoke-virtual {v1, p3}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedHttpResponseGenerator;->generateNotModifiedResponse(Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    move-result-object v0

    .line 564
    .local v0, "cachedResponse":Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    :goto_0
    sget-object v1, Lcom/comcast/cim/httpcomponentsandroid/client/cache/CacheResponseStatus;->CACHE_HIT:Lcom/comcast/cim/httpcomponentsandroid/client/cache/CacheResponseStatus;

    invoke-direct {p0, p2, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->setResponseStatus(Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;Lcom/comcast/cim/httpcomponentsandroid/client/cache/CacheResponseStatus;)V

    .line 565
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->validityPolicy:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheValidityPolicy;

    invoke-virtual {v1, p3, p4}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheValidityPolicy;->getStalenessSecs(Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;Ljava/util/Date;)J

    move-result-wide v2

    const-wide/16 v4, 0x0

    cmp-long v1, v2, v4

    if-lez v1, :cond_1

    .line 566
    const-string v1, "Warning"

    const-string v2, "110 localhost \"Response is stale\""

    invoke-interface {v0, v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 568
    :cond_1
    return-object v0

    .line 562
    .end local v0    # "cachedResponse":Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    :cond_2
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->responseGenerator:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedHttpResponseGenerator;

    invoke-virtual {v1, p3}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedHttpResponseGenerator;->generateResponse(Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    move-result-object v0

    .restart local v0    # "cachedResponse":Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    goto :goto_0
.end method

.method private generateGatewayTimeout(Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .locals 4
    .param p1, "context"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;

    .prologue
    .line 581
    sget-object v0, Lcom/comcast/cim/httpcomponentsandroid/client/cache/CacheResponseStatus;->CACHE_MODULE_RESPONSE:Lcom/comcast/cim/httpcomponentsandroid/client/cache/CacheResponseStatus;

    invoke-direct {p0, p1, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->setResponseStatus(Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;Lcom/comcast/cim/httpcomponentsandroid/client/cache/CacheResponseStatus;)V

    .line 582
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpResponse;

    sget-object v1, Lcom/comcast/cim/httpcomponentsandroid/HttpVersion;->HTTP_1_1:Lcom/comcast/cim/httpcomponentsandroid/HttpVersion;

    const/16 v2, 0x1f8

    const-string v3, "Gateway Timeout"

    invoke-direct {v0, v1, v2, v3}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpResponse;-><init>(Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;ILjava/lang/String;)V

    return-object v0
.end method

.method private generateViaHeader(Lcom/comcast/cim/httpcomponentsandroid/HttpMessage;)Ljava/lang/String;
    .locals 10
    .param p1, "msg"    # Lcom/comcast/cim/httpcomponentsandroid/HttpMessage;

    .prologue
    const/4 v9, 0x3

    const/4 v8, 0x2

    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 634
    const-string v3, "com.comcast.cim.httpcomponentsandroid.client"

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/comcast/cim/httpcomponentsandroid/util/VersionInfo;->loadVersionInfo(Ljava/lang/String;Ljava/lang/ClassLoader;)Lcom/comcast/cim/httpcomponentsandroid/util/VersionInfo;

    move-result-object v2

    .line 635
    .local v2, "vi":Lcom/comcast/cim/httpcomponentsandroid/util/VersionInfo;
    if-eqz v2, :cond_0

    invoke-virtual {v2}, Lcom/comcast/cim/httpcomponentsandroid/util/VersionInfo;->getRelease()Ljava/lang/String;

    move-result-object v1

    .line 636
    .local v1, "release":Ljava/lang/String;
    :goto_0
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpMessage;->getProtocolVersion()Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;

    move-result-object v0

    .line 637
    .local v0, "pv":Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;
    const-string v3, "http"

    invoke-virtual {v0}, Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;->getProtocol()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 638
    const-string v3, "%d.%d localhost (Apache-HttpClient/%s (cache))"

    new-array v4, v9, [Ljava/lang/Object;

    invoke-virtual {v0}, Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;->getMajor()I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v4, v6

    invoke-virtual {v0}, Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;->getMinor()I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v4, v7

    aput-object v1, v4, v8

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    .line 641
    :goto_1
    return-object v3

    .line 635
    .end local v0    # "pv":Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;
    .end local v1    # "release":Ljava/lang/String;
    :cond_0
    const-string v1, "UNAVAILABLE"

    goto :goto_0

    .line 641
    .restart local v0    # "pv":Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;
    .restart local v1    # "release":Ljava/lang/String;
    :cond_1
    const-string v3, "%s/%d.%d localhost (Apache-HttpClient/%s (cache))"

    const/4 v4, 0x4

    new-array v4, v4, [Ljava/lang/Object;

    invoke-virtual {v0}, Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;->getProtocol()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v6

    invoke-virtual {v0}, Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;->getMajor()I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v4, v7

    invoke-virtual {v0}, Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;->getMinor()I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v4, v8

    aput-object v1, v4, v9

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    goto :goto_1
.end method

.method private getExistingCacheVariants(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Ljava/util/Map;
    .locals 4
    .param p1, "target"    # Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
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

    .prologue
    .line 516
    const/4 v1, 0x0

    .line 518
    .local v1, "variants":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/Variant;>;"
    :try_start_0
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->responseCache:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/HttpCache;

    invoke-interface {v2, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/HttpCache;->getVariantCacheEntriesWithEtags(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Ljava/util/Map;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 522
    :goto_0
    return-object v1

    .line 519
    :catch_0
    move-exception v0

    .line 520
    .local v0, "ioe":Ljava/io/IOException;
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->log:Lorg/apache/commons/logging/Log;

    const-string v3, "Unable to retrieve variant entries from cache"

    invoke-interface {v2, v3, v0}, Lorg/apache/commons/logging/Log;->warn(Ljava/lang/Object;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method private getFatallyNoncompliantResponse(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .locals 5
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p2, "context"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;

    .prologue
    .line 504
    const/4 v2, 0x0

    .line 505
    .local v2, "fatalErrorResponse":Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    iget-object v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->requestCompliance:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/RequestProtocolCompliance;

    invoke-virtual {v4, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/RequestProtocolCompliance;->requestIsFatallyNonCompliant(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Ljava/util/List;

    move-result-object v1

    .line 507
    .local v1, "fatalError":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/RequestProtocolError;>;"
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/RequestProtocolError;

    .line 508
    .local v0, "error":Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/RequestProtocolError;
    sget-object v4, Lcom/comcast/cim/httpcomponentsandroid/client/cache/CacheResponseStatus;->CACHE_MODULE_RESPONSE:Lcom/comcast/cim/httpcomponentsandroid/client/cache/CacheResponseStatus;

    invoke-direct {p0, p2, v4}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->setResponseStatus(Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;Lcom/comcast/cim/httpcomponentsandroid/client/cache/CacheResponseStatus;)V

    .line 509
    iget-object v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->requestCompliance:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/RequestProtocolCompliance;

    invoke-virtual {v4, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/RequestProtocolCompliance;->getErrorForRequest(Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/RequestProtocolError;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    move-result-object v2

    goto :goto_0

    .line 511
    .end local v0    # "error":Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/RequestProtocolError;
    :cond_0
    return-object v2
.end method

.method private getUpdatedVariantEntry(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Ljava/util/Date;Ljava/util/Date;Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/Variant;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    .locals 10
    .param p1, "target"    # Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    .param p2, "conditionalRequest"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p3, "requestDate"    # Ljava/util/Date;
    .param p4, "responseDate"    # Ljava/util/Date;
    .param p5, "backendResponse"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .param p6, "matchingVariant"    # Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/Variant;
    .param p7, "matchedEntry"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;

    .prologue
    .line 787
    move-object/from16 v9, p7

    .line 789
    .local v9, "responseEntry":Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->responseCache:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/HttpCache;

    invoke-virtual/range {p6 .. p6}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/Variant;->getCacheKey()Ljava/lang/String;

    move-result-object v7

    move-object v1, p1

    move-object v2, p2

    move-object/from16 v3, p7

    move-object v4, p5

    move-object v5, p3

    move-object v6, p4

    invoke-interface/range {v0 .. v7}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/HttpCache;->updateVariantCacheEntry(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;Ljava/util/Date;Ljava/util/Date;Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v9

    .line 794
    :goto_0
    return-object v9

    .line 791
    :catch_0
    move-exception v8

    .line 792
    .local v8, "ioe":Ljava/io/IOException;
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->log:Lorg/apache/commons/logging/Log;

    const-string v1, "Could not update cache entry"

    invoke-interface {v0, v1, v8}, Lorg/apache/commons/logging/Log;->warn(Ljava/lang/Object;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method private handleCacheHit(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .locals 6
    .param p1, "target"    # Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    .param p2, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p3, "context"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    .param p4, "entry"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/client/ClientProtocolException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 434
    invoke-direct {p0, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->recordCacheHit(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)V

    .line 436
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->getCurrentDate()Ljava/util/Date;

    move-result-object v5

    .line 437
    .local v5, "now":Ljava/util/Date;
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->suitabilityChecker:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedResponseSuitabilityChecker;

    invoke-virtual {v0, p1, p2, p4, v5}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedResponseSuitabilityChecker;->canCachedResponseBeUsed(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;Ljava/util/Date;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 438
    invoke-direct {p0, p2, p3, p4, v5}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->generateCachedResponse(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;Ljava/util/Date;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    move-result-object v0

    .line 448
    :goto_0
    return-object v0

    .line 441
    :cond_0
    invoke-direct {p0, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->mayCallBackend(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 442
    invoke-direct {p0, p3}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->generateGatewayTimeout(Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    move-result-object v0

    goto :goto_0

    .line 445
    :cond_1
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->validityPolicy:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheValidityPolicy;

    invoke-virtual {v0, p4}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheValidityPolicy;->isRevalidatable(Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)Z

    move-result v0

    if-eqz v0, :cond_2

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    .line 446
    invoke-direct/range {v0 .. v5}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->revalidateCacheEntry(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;Ljava/util/Date;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    move-result-object v0

    goto :goto_0

    .line 448
    :cond_2
    invoke-virtual {p0, p1, p2, p3}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->callBackend(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    move-result-object v0

    goto :goto_0
.end method

.method private handleCacheMiss(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .locals 5
    .param p1, "target"    # Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    .param p2, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p3, "context"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 476
    invoke-direct {p0, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->recordCacheMiss(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)V

    .line 478
    invoke-direct {p0, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->mayCallBackend(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 479
    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpResponse;

    sget-object v2, Lcom/comcast/cim/httpcomponentsandroid/HttpVersion;->HTTP_1_1:Lcom/comcast/cim/httpcomponentsandroid/HttpVersion;

    const/16 v3, 0x1f8

    const-string v4, "Gateway Timeout"

    invoke-direct {v1, v2, v3, v4}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpResponse;-><init>(Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;ILjava/lang/String;)V

    .line 489
    :goto_0
    return-object v1

    .line 483
    :cond_0
    invoke-direct {p0, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->getExistingCacheVariants(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Ljava/util/Map;

    move-result-object v0

    .line 485
    .local v0, "variants":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/Variant;>;"
    if-eqz v0, :cond_1

    invoke-interface {v0}, Ljava/util/Map;->size()I

    move-result v1

    if-lez v1, :cond_1

    .line 486
    invoke-virtual {p0, p1, p2, p3, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->negotiateResponseFromVariants(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;Ljava/util/Map;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    move-result-object v1

    goto :goto_0

    .line 489
    :cond_1
    invoke-virtual {p0, p1, p2, p3}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->callBackend(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    move-result-object v1

    goto :goto_0
.end method

.method private handleRevalidationFailure(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;Ljava/util/Date;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .locals 1
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p2, "context"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    .param p3, "entry"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    .param p4, "now"    # Ljava/util/Date;

    .prologue
    .line 573
    invoke-direct {p0, p1, p3, p4}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->staleResponseNotAllowed(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;Ljava/util/Date;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 574
    invoke-direct {p0, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->generateGatewayTimeout(Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    move-result-object v0

    .line 576
    :goto_0
    return-object v0

    :cond_0
    invoke-direct {p0, p2, p3}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->unvalidatedCacheHit(Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    move-result-object v0

    goto :goto_0
.end method

.method private makeAsynchronousValidator(Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheConfig;)Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidator;
    .locals 1
    .param p1, "config"    # Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheConfig;

    .prologue
    .line 287
    invoke-virtual {p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheConfig;->getAsynchronousWorkersMax()I

    move-result v0

    if-lez v0, :cond_0

    .line 288
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidator;

    invoke-direct {v0, p0, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidator;-><init>(Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheConfig;)V

    .line 290
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private mayCallBackend(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Z
    .locals 10
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;

    .prologue
    .line 602
    const-string v8, "Cache-Control"

    invoke-interface {p1, v8}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getHeaders(Ljava/lang/String;)[Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v0

    .local v0, "arr$":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    array-length v6, v0

    .local v6, "len$":I
    const/4 v4, 0x0

    .local v4, "i$":I
    move v5, v4

    .end local v0    # "arr$":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    .end local v4    # "i$":I
    .end local v6    # "len$":I
    .local v5, "i$":I
    :goto_0
    if-ge v5, v6, :cond_2

    aget-object v3, v0, v5

    .line 603
    .local v3, "h":Lcom/comcast/cim/httpcomponentsandroid/Header;
    invoke-interface {v3}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getElements()[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;

    move-result-object v1

    .local v1, "arr$":[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    array-length v7, v1

    .local v7, "len$":I
    const/4 v4, 0x0

    .end local v5    # "i$":I
    .restart local v4    # "i$":I
    :goto_1
    if-ge v4, v7, :cond_1

    aget-object v2, v1, v4

    .line 604
    .local v2, "elt":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    const-string v8, "only-if-cached"

    invoke-interface {v2}, Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;->getName()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_0

    .line 605
    const/4 v8, 0x0

    .line 609
    .end local v1    # "arr$":[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .end local v2    # "elt":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .end local v3    # "h":Lcom/comcast/cim/httpcomponentsandroid/Header;
    .end local v4    # "i$":I
    .end local v7    # "len$":I
    :goto_2
    return v8

    .line 603
    .restart local v1    # "arr$":[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .restart local v2    # "elt":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .restart local v3    # "h":Lcom/comcast/cim/httpcomponentsandroid/Header;
    .restart local v4    # "i$":I
    .restart local v7    # "len$":I
    :cond_0
    add-int/lit8 v4, v4, 0x1

    goto :goto_1

    .line 602
    .end local v2    # "elt":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    :cond_1
    add-int/lit8 v4, v5, 0x1

    move v5, v4

    .end local v4    # "i$":I
    .restart local v5    # "i$":I
    goto :goto_0

    .line 609
    .end local v1    # "arr$":[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .end local v3    # "h":Lcom/comcast/cim/httpcomponentsandroid/Header;
    .end local v7    # "len$":I
    :cond_2
    const/4 v8, 0x1

    goto :goto_2
.end method

.method private recordCacheHit(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)V
    .locals 4
    .param p1, "target"    # Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    .param p2, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;

    .prologue
    .line 534
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->cacheHits:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-virtual {v1}, Ljava/util/concurrent/atomic/AtomicLong;->getAndIncrement()J

    .line 535
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->log:Lorg/apache/commons/logging/Log;

    invoke-interface {v1}, Lorg/apache/commons/logging/Log;->isTraceEnabled()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 536
    invoke-interface {p2}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getRequestLine()Lcom/comcast/cim/httpcomponentsandroid/RequestLine;

    move-result-object v0

    .line 537
    .local v0, "rl":Lcom/comcast/cim/httpcomponentsandroid/RequestLine;
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->log:Lorg/apache/commons/logging/Log;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Cache hit [host: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "; uri: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/RequestLine;->getUri()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "]"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Lorg/apache/commons/logging/Log;->trace(Ljava/lang/Object;)V

    .line 539
    .end local v0    # "rl":Lcom/comcast/cim/httpcomponentsandroid/RequestLine;
    :cond_0
    return-void
.end method

.method private recordCacheMiss(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)V
    .locals 4
    .param p1, "target"    # Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    .param p2, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;

    .prologue
    .line 526
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->cacheMisses:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-virtual {v1}, Ljava/util/concurrent/atomic/AtomicLong;->getAndIncrement()J

    .line 527
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->log:Lorg/apache/commons/logging/Log;

    invoke-interface {v1}, Lorg/apache/commons/logging/Log;->isTraceEnabled()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 528
    invoke-interface {p2}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getRequestLine()Lcom/comcast/cim/httpcomponentsandroid/RequestLine;

    move-result-object v0

    .line 529
    .local v0, "rl":Lcom/comcast/cim/httpcomponentsandroid/RequestLine;
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->log:Lorg/apache/commons/logging/Log;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Cache miss [host: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "; uri: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/RequestLine;->getUri()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "]"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Lorg/apache/commons/logging/Log;->trace(Ljava/lang/Object;)V

    .line 531
    .end local v0    # "rl":Lcom/comcast/cim/httpcomponentsandroid/RequestLine;
    :cond_0
    return-void
.end method

.method private recordCacheUpdate(Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)V
    .locals 1
    .param p1, "context"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;

    .prologue
    .line 542
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->cacheUpdates:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicLong;->getAndIncrement()J

    .line 543
    sget-object v0, Lcom/comcast/cim/httpcomponentsandroid/client/cache/CacheResponseStatus;->VALIDATED:Lcom/comcast/cim/httpcomponentsandroid/client/cache/CacheResponseStatus;

    invoke-direct {p0, p1, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->setResponseStatus(Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;Lcom/comcast/cim/httpcomponentsandroid/client/cache/CacheResponseStatus;)V

    .line 544
    return-void
.end method

.method private retryRequestUnconditionally(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .locals 2
    .param p1, "target"    # Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    .param p2, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p3, "context"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    .param p4, "matchedEntry"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 778
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->conditionalRequestBuilder:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ConditionalRequestBuilder;

    invoke-virtual {v1, p2, p4}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ConditionalRequestBuilder;->buildUnconditionalRequest(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;

    move-result-object v0

    .line 780
    .local v0, "unconditional":Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    invoke-virtual {p0, p1, v0, p3}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->callBackend(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    move-result-object v1

    return-object v1
.end method

.method private revalidateCacheEntry(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;Ljava/util/Date;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .locals 5
    .param p1, "target"    # Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    .param p2, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p3, "context"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    .param p4, "entry"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    .param p5, "now"    # Ljava/util/Date;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/client/ClientProtocolException;
        }
    .end annotation

    .prologue
    .line 454
    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->log:Lorg/apache/commons/logging/Log;

    const-string v4, "Revalidating the cache entry"

    invoke-interface {v3, v4}, Lorg/apache/commons/logging/Log;->trace(Ljava/lang/Object;)V

    .line 457
    :try_start_0
    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->asynchRevalidator:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidator;

    if-eqz v3, :cond_0

    invoke-direct {p0, p2, p4, p5}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->staleResponseNotAllowed(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;Ljava/util/Date;)Z

    move-result v3

    if-nez v3, :cond_0

    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->validityPolicy:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheValidityPolicy;

    invoke-virtual {v3, p4, p5}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheValidityPolicy;->mayReturnStaleWhileRevalidating(Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;Ljava/util/Date;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 460
    invoke-direct {p0, p2, p3, p4, p5}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->generateCachedResponse(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;Ljava/util/Date;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    move-result-object v2

    .line 462
    .local v2, "resp":Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->asynchRevalidator:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidator;

    invoke-virtual {v3, p1, p2, p3, p4}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidator;->revalidateCacheEntry(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)V

    .line 468
    .end local v2    # "resp":Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    :goto_0
    return-object v2

    .line 466
    :cond_0
    invoke-virtual {p0, p1, p2, p3, p4}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->revalidateCacheEntry(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Lcom/comcast/cim/httpcomponentsandroid/ProtocolException; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v2

    goto :goto_0

    .line 467
    :catch_0
    move-exception v1

    .line 468
    .local v1, "ioex":Ljava/io/IOException;
    invoke-direct {p0, p2, p3, p4, p5}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->handleRevalidationFailure(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;Ljava/util/Date;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    move-result-object v2

    goto :goto_0

    .line 469
    .end local v1    # "ioex":Ljava/io/IOException;
    :catch_1
    move-exception v0

    .line 470
    .local v0, "e":Lcom/comcast/cim/httpcomponentsandroid/ProtocolException;
    new-instance v3, Lcom/comcast/cim/httpcomponentsandroid/client/ClientProtocolException;

    invoke-direct {v3, v0}, Lcom/comcast/cim/httpcomponentsandroid/client/ClientProtocolException;-><init>(Ljava/lang/Throwable;)V

    throw v3
.end method

.method private revalidationResponseIsTooOld(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)Z
    .locals 5
    .param p1, "backendResponse"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .param p2, "cacheEntry"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;

    .prologue
    .line 707
    const-string v4, "Date"

    invoke-virtual {p2, v4}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;->getFirstHeader(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v1

    .line 708
    .local v1, "entryDateHeader":Lcom/comcast/cim/httpcomponentsandroid/Header;
    const-string v4, "Date"

    invoke-interface {p1, v4}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getFirstHeader(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v3

    .line 709
    .local v3, "responseDateHeader":Lcom/comcast/cim/httpcomponentsandroid/Header;
    if-eqz v1, :cond_0

    if-eqz v3, :cond_0

    .line 711
    :try_start_0
    invoke-interface {v1}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getValue()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/DateUtils;->parseDate(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v0

    .line 712
    .local v0, "entryDate":Ljava/util/Date;
    invoke-interface {v3}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getValue()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/DateUtils;->parseDate(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v2

    .line 713
    .local v2, "respDate":Ljava/util/Date;
    invoke-virtual {v2, v0}, Ljava/util/Date;->before(Ljava/util/Date;)Z
    :try_end_0
    .catch Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/DateParseException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v4

    if-eqz v4, :cond_0

    const/4 v4, 0x1

    .line 721
    .end local v0    # "entryDate":Ljava/util/Date;
    .end local v2    # "respDate":Ljava/util/Date;
    :goto_0
    return v4

    .line 714
    :catch_0
    move-exception v4

    .line 721
    :cond_0
    const/4 v4, 0x0

    goto :goto_0
.end method

.method private satisfyFromCache(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    .locals 4
    .param p1, "target"    # Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    .param p2, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;

    .prologue
    .line 493
    const/4 v0, 0x0

    .line 495
    .local v0, "entry":Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    :try_start_0
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->responseCache:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/HttpCache;

    invoke-interface {v2, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/HttpCache;->getCacheEntry(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 499
    :goto_0
    return-object v0

    .line 496
    :catch_0
    move-exception v1

    .line 497
    .local v1, "ioe":Ljava/io/IOException;
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->log:Lorg/apache/commons/logging/Log;

    const-string v3, "Unable to retrieve entries from cache"

    invoke-interface {v2, v3, v1}, Lorg/apache/commons/logging/Log;->warn(Ljava/lang/Object;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method private setResponseStatus(Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;Lcom/comcast/cim/httpcomponentsandroid/client/cache/CacheResponseStatus;)V
    .locals 1
    .param p1, "context"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    .param p2, "value"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/CacheResponseStatus;

    .prologue
    .line 647
    if-eqz p1, :cond_0

    .line 648
    const-string v0, "http.cache.response.status"

    invoke-interface {p1, v0, p2}, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;->setAttribute(Ljava/lang/String;Ljava/lang/Object;)V

    .line 650
    :cond_0
    return-void
.end method

.method private shouldSendNotModifiedResponse(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)Z
    .locals 2
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p2, "responseEntry"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;

    .prologue
    .line 808
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->suitabilityChecker:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedResponseSuitabilityChecker;

    invoke-virtual {v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedResponseSuitabilityChecker;->isConditional(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->suitabilityChecker:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedResponseSuitabilityChecker;

    new-instance v1, Ljava/util/Date;

    invoke-direct {v1}, Ljava/util/Date;-><init>()V

    invoke-virtual {v0, p1, p2, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedResponseSuitabilityChecker;->allConditionalsMatch(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;Ljava/util/Date;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private staleIfErrorAppliesTo(I)Z
    .locals 1
    .param p1, "statusCode"    # I

    .prologue
    .line 864
    const/16 v0, 0x1f4

    if-eq p1, v0, :cond_0

    const/16 v0, 0x1f6

    if-eq p1, v0, :cond_0

    const/16 v0, 0x1f7

    if-eq p1, v0, :cond_0

    const/16 v0, 0x1f8

    if-ne p1, v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private staleResponseNotAllowed(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;Ljava/util/Date;)Z
    .locals 1
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p2, "entry"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    .param p3, "now"    # Ljava/util/Date;

    .prologue
    .line 596
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->validityPolicy:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheValidityPolicy;

    invoke-virtual {v0, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheValidityPolicy;->mustRevalidate(Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)Z

    move-result v0

    if-nez v0, :cond_1

    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->isSharedCache()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->validityPolicy:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheValidityPolicy;

    invoke-virtual {v0, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheValidityPolicy;->proxyRevalidate(Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)Z

    move-result v0

    if-nez v0, :cond_1

    :cond_0
    invoke-direct {p0, p1, p2, p3}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->explicitFreshnessRequest(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;Ljava/util/Date;)Z

    move-result v0

    if-eqz v0, :cond_2

    :cond_1
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_2
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private tryToUpdateVariantMap(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/Variant;)V
    .locals 3
    .param p1, "target"    # Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    .param p2, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p3, "matchingVariant"    # Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/Variant;

    .prologue
    .line 800
    :try_start_0
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->responseCache:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/HttpCache;

    invoke-interface {v1, p1, p2, p3}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/HttpCache;->reuseVariantEntryFor(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/Variant;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 804
    :goto_0
    return-void

    .line 801
    :catch_0
    move-exception v0

    .line 802
    .local v0, "ioe":Ljava/io/IOException;
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->log:Lorg/apache/commons/logging/Log;

    const-string v2, "Could not update cache entry to reuse variant"

    invoke-interface {v1, v2, v0}, Lorg/apache/commons/logging/Log;->warn(Ljava/lang/Object;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method private unvalidatedCacheHit(Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .locals 3
    .param p1, "context"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    .param p2, "entry"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;

    .prologue
    .line 588
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->responseGenerator:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedHttpResponseGenerator;

    invoke-virtual {v1, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedHttpResponseGenerator;->generateResponse(Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    move-result-object v0

    .line 589
    .local v0, "cachedResponse":Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    sget-object v1, Lcom/comcast/cim/httpcomponentsandroid/client/cache/CacheResponseStatus;->CACHE_HIT:Lcom/comcast/cim/httpcomponentsandroid/client/cache/CacheResponseStatus;

    invoke-direct {p0, p1, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->setResponseStatus(Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;Lcom/comcast/cim/httpcomponentsandroid/client/cache/CacheResponseStatus;)V

    .line 590
    const-string v1, "Warning"

    const-string v2, "111 localhost \"Revalidation failed\""

    invoke-interface {v0, v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 591
    return-object v0
.end method


# virtual methods
.method callBackend(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .locals 6
    .param p1, "target"    # Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    .param p2, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p3, "context"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 695
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->getCurrentDate()Ljava/util/Date;

    move-result-object v3

    .line 697
    .local v3, "requestDate":Ljava/util/Date;
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->log:Lorg/apache/commons/logging/Log;

    const-string v1, "Calling the backend"

    invoke-interface {v0, v1}, Lorg/apache/commons/logging/Log;->trace(Ljava/lang/Object;)V

    .line 698
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->backend:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    invoke-interface {v0, p1, p2, p3}, Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;->execute(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    move-result-object v5

    .line 699
    .local v5, "backendResponse":Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    const-string v0, "Via"

    invoke-direct {p0, v5}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->generateViaHeader(Lcom/comcast/cim/httpcomponentsandroid/HttpMessage;)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v5, v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 700
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->getCurrentDate()Ljava/util/Date;

    move-result-object v4

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    invoke-virtual/range {v0 .. v5}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->handleBackendResponse(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Ljava/util/Date;Ljava/util/Date;Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    move-result-object v0

    return-object v0
.end method

.method clientRequestsOurOptions(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Z
    .locals 4
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;

    .prologue
    const/4 v1, 0x0

    .line 678
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getRequestLine()Lcom/comcast/cim/httpcomponentsandroid/RequestLine;

    move-result-object v0

    .line 680
    .local v0, "line":Lcom/comcast/cim/httpcomponentsandroid/RequestLine;
    const-string v2, "OPTIONS"

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/RequestLine;->getMethod()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 689
    :cond_0
    :goto_0
    return v1

    .line 683
    :cond_1
    const-string v2, "*"

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/RequestLine;->getUri()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 686
    const-string v2, "0"

    const-string v3, "Max-Forwards"

    invoke-interface {p1, v3}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getFirstHeader(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v3

    invoke-interface {v3}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getValue()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 689
    const/4 v1, 0x1

    goto :goto_0
.end method

.method public execute(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .locals 4
    .param p1, "target"    # Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    .param p2, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p3, "context"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 401
    sget-object v3, Lcom/comcast/cim/httpcomponentsandroid/client/cache/CacheResponseStatus;->CACHE_MISS:Lcom/comcast/cim/httpcomponentsandroid/client/cache/CacheResponseStatus;

    invoke-direct {p0, p3, v3}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->setResponseStatus(Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;Lcom/comcast/cim/httpcomponentsandroid/client/cache/CacheResponseStatus;)V

    .line 403
    invoke-direct {p0, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->generateViaHeader(Lcom/comcast/cim/httpcomponentsandroid/HttpMessage;)Ljava/lang/String;

    move-result-object v2

    .line 405
    .local v2, "via":Ljava/lang/String;
    invoke-virtual {p0, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->clientRequestsOurOptions(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 406
    sget-object v3, Lcom/comcast/cim/httpcomponentsandroid/client/cache/CacheResponseStatus;->CACHE_MODULE_RESPONSE:Lcom/comcast/cim/httpcomponentsandroid/client/cache/CacheResponseStatus;

    invoke-direct {p0, p3, v3}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->setResponseStatus(Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;Lcom/comcast/cim/httpcomponentsandroid/client/cache/CacheResponseStatus;)V

    .line 407
    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/OptionsHttp11Response;

    invoke-direct {v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/OptionsHttp11Response;-><init>()V

    .line 428
    :cond_0
    :goto_0
    return-object v1

    .line 410
    :cond_1
    invoke-direct {p0, p2, p3}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->getFatallyNoncompliantResponse(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    move-result-object v1

    .line 412
    .local v1, "fatalErrorResponse":Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    if-nez v1, :cond_0

    .line 414
    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->requestCompliance:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/RequestProtocolCompliance;

    invoke-virtual {v3, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/RequestProtocolCompliance;->makeRequestCompliant(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;

    move-result-object p2

    .line 415
    const-string v3, "Via"

    invoke-interface {p2, v3, v2}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 417
    invoke-direct {p0, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->flushEntriesInvalidatedByRequest(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)V

    .line 419
    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->cacheableRequestPolicy:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheableRequestPolicy;

    invoke-virtual {v3, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheableRequestPolicy;->isServableFromCache(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Z

    move-result v3

    if-nez v3, :cond_2

    .line 420
    invoke-virtual {p0, p1, p2, p3}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->callBackend(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    move-result-object v1

    goto :goto_0

    .line 423
    :cond_2
    invoke-direct {p0, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->satisfyFromCache(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;

    move-result-object v0

    .line 424
    .local v0, "entry":Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    if-nez v0, :cond_3

    .line 425
    invoke-direct {p0, p1, p2, p3}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->handleCacheMiss(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    move-result-object v1

    goto :goto_0

    .line 428
    :cond_3
    invoke-direct {p0, p1, p2, p3, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->handleCacheHit(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    move-result-object v1

    goto :goto_0
.end method

.method public execute(Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .locals 2
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 337
    const/4 v0, 0x0

    .line 338
    .local v0, "context":Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    invoke-virtual {p0, p1, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->execute(Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    move-result-object v1

    return-object v1
.end method

.method public execute(Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .locals 5
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;
    .param p2, "context"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 342
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;->getURI()Ljava/net/URI;

    move-result-object v1

    .line 343
    .local v1, "uri":Ljava/net/URI;
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/HttpHost;

    invoke-virtual {v1}, Ljava/net/URI;->getHost()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1}, Ljava/net/URI;->getPort()I

    move-result v3

    invoke-virtual {v1}, Ljava/net/URI;->getScheme()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v0, v2, v3, v4}, Lcom/comcast/cim/httpcomponentsandroid/HttpHost;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    .line 344
    .local v0, "httpHost":Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    invoke-virtual {p0, v0, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->execute(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    move-result-object v2

    return-object v2
.end method

.method public getCacheHits()J
    .locals 2

    .prologue
    .line 299
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->cacheHits:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicLong;->get()J

    move-result-wide v0

    return-wide v0
.end method

.method public getCacheMisses()J
    .locals 2

    .prologue
    .line 308
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->cacheMisses:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicLong;->get()J

    move-result-wide v0

    return-wide v0
.end method

.method public getCacheUpdates()J
    .locals 2

    .prologue
    .line 317
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->cacheUpdates:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicLong;->get()J

    move-result-wide v0

    return-wide v0
.end method

.method public getConnectionManager()Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;
    .locals 1

    .prologue
    .line 390
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->backend:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;->getConnectionManager()Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;

    move-result-object v0

    return-object v0
.end method

.method getCurrentDate()Ljava/util/Date;
    .locals 1

    .prologue
    .line 674
    new-instance v0, Ljava/util/Date;

    invoke-direct {v0}, Ljava/util/Date;-><init>()V

    return-object v0
.end method

.method public getParams()Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
    .locals 1

    .prologue
    .line 394
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->backend:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;->getParams()Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    move-result-object v0

    return-object v0
.end method

.method handleBackendResponse(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Ljava/util/Date;Ljava/util/Date;Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .locals 8
    .param p1, "target"    # Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    .param p2, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p3, "requestDate"    # Ljava/util/Date;
    .param p4, "responseDate"    # Ljava/util/Date;
    .param p5, "backendResponse"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 877
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->log:Lorg/apache/commons/logging/Log;

    const-string v1, "Handling Backend response"

    invoke-interface {v0, v1}, Lorg/apache/commons/logging/Log;->trace(Ljava/lang/Object;)V

    .line 878
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->responseCompliance:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ResponseProtocolCompliance;

    invoke-virtual {v0, p2, p5}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ResponseProtocolCompliance;->ensureProtocolCompliance(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)V

    .line 880
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->responseCachingPolicy:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ResponseCachingPolicy;

    invoke-virtual {v0, p2, p5}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ResponseCachingPolicy;->isResponseCacheable(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)Z

    move-result v6

    .line 881
    .local v6, "cacheable":Z
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->responseCache:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/HttpCache;

    invoke-interface {v0, p1, p2, p5}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/HttpCache;->flushInvalidatedCacheEntriesFor(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)V

    .line 882
    if-eqz v6, :cond_1

    invoke-direct {p0, p1, p2, p5}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->alreadyHaveNewerCacheEntry(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 885
    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->responseCache:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/HttpCache;

    move-object v1, p1

    move-object v2, p2

    move-object v3, p5

    move-object v4, p3

    move-object v5, p4

    invoke-interface/range {v0 .. v5}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/HttpCache;->cacheAndReturnResponse(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;Ljava/util/Date;Ljava/util/Date;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object p5

    .line 898
    .end local p5    # "backendResponse":Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    :cond_0
    :goto_0
    return-object p5

    .line 887
    .restart local p5    # "backendResponse":Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    :catch_0
    move-exception v7

    .line 888
    .local v7, "ioe":Ljava/io/IOException;
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->log:Lorg/apache/commons/logging/Log;

    const-string v1, "Unable to store entries in cache"

    invoke-interface {v0, v1, v7}, Lorg/apache/commons/logging/Log;->warn(Ljava/lang/Object;Ljava/lang/Throwable;)V

    .line 891
    .end local v7    # "ioe":Ljava/io/IOException;
    :cond_1
    if-nez v6, :cond_0

    .line 893
    :try_start_1
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->responseCache:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/HttpCache;

    invoke-interface {v0, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/HttpCache;->flushCacheEntriesFor(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_0

    .line 894
    :catch_1
    move-exception v7

    .line 895
    .restart local v7    # "ioe":Ljava/io/IOException;
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->log:Lorg/apache/commons/logging/Log;

    const-string v1, "Unable to flush invalid cache entries"

    invoke-interface {v0, v1, v7}, Lorg/apache/commons/logging/Log;->warn(Ljava/lang/Object;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public isSharedCache()Z
    .locals 1

    .prologue
    .line 670
    iget-boolean v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->sharedCache:Z

    return v0
.end method

.method negotiateResponseFromVariants(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;Ljava/util/Map;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .locals 13
    .param p1, "target"    # Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    .param p2, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p3, "context"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/httpcomponentsandroid/HttpHost;",
            "Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;",
            "Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/Variant;",
            ">;)",
            "Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 727
    .local p4, "variants":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/Variant;>;"
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->conditionalRequestBuilder:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ConditionalRequestBuilder;

    move-object/from16 v0, p4

    invoke-virtual {v1, p2, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ConditionalRequestBuilder;->buildConditionalRequestFromVariants(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Ljava/util/Map;)Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;

    move-result-object v3

    .line 729
    .local v3, "conditionalRequest":Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->getCurrentDate()Ljava/util/Date;

    move-result-object v4

    .line 730
    .local v4, "requestDate":Ljava/util/Date;
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->backend:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    move-object/from16 v0, p3

    invoke-interface {v1, p1, v3, v0}, Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;->execute(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    move-result-object v6

    .line 731
    .local v6, "backendResponse":Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->getCurrentDate()Ljava/util/Date;

    move-result-object v5

    .line 733
    .local v5, "responseDate":Ljava/util/Date;
    const-string v1, "Via"

    invoke-direct {p0, v6}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->generateViaHeader(Lcom/comcast/cim/httpcomponentsandroid/HttpMessage;)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v6, v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 735
    invoke-interface {v6}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getStatusLine()Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

    move-result-object v1

    invoke-interface {v1}, Lcom/comcast/cim/httpcomponentsandroid/StatusLine;->getStatusCode()I

    move-result v1

    const/16 v2, 0x130

    if-eq v1, v2, :cond_1

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    .line 736
    invoke-virtual/range {v1 .. v6}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->handleBackendResponse(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Ljava/util/Date;Ljava/util/Date;Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    .end local v3    # "conditionalRequest":Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    move-result-object v9

    .line 772
    :cond_0
    :goto_0
    return-object v9

    .line 739
    .restart local v3    # "conditionalRequest":Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    :cond_1
    const-string v1, "ETag"

    invoke-interface {v6, v1}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getFirstHeader(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v12

    .line 740
    .local v12, "resultEtagHeader":Lcom/comcast/cim/httpcomponentsandroid/Header;
    if-nez v12, :cond_2

    .line 741
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->log:Lorg/apache/commons/logging/Log;

    const-string v2, "304 response did not contain ETag"

    invoke-interface {v1, v2}, Lorg/apache/commons/logging/Log;->warn(Ljava/lang/Object;)V

    .line 742
    invoke-virtual/range {p0 .. p3}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->callBackend(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    move-result-object v9

    goto :goto_0

    .line 745
    :cond_2
    invoke-interface {v12}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getValue()Ljava/lang/String;

    move-result-object v11

    .line 746
    .local v11, "resultEtag":Ljava/lang/String;
    move-object/from16 v0, p4

    invoke-interface {v0, v11}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/Variant;

    .line 747
    .local v7, "matchingVariant":Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/Variant;
    if-nez v7, :cond_3

    .line 748
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->log:Lorg/apache/commons/logging/Log;

    const-string v2, "304 response did not contain ETag matching one sent in If-None-Match"

    invoke-interface {v1, v2}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    .line 749
    invoke-virtual/range {p0 .. p3}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->callBackend(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    move-result-object v9

    goto :goto_0

    .line 752
    :cond_3
    invoke-virtual {v7}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/Variant;->getEntry()Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;

    move-result-object v8

    .line 754
    .local v8, "matchedEntry":Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    invoke-direct {p0, v6, v8}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->revalidationResponseIsTooOld(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 755
    move-object/from16 v0, p3

    invoke-direct {p0, p1, p2, v0, v8}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->retryRequestUnconditionally(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    move-result-object v9

    goto :goto_0

    .line 759
    :cond_4
    move-object/from16 v0, p3

    invoke-direct {p0, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->recordCacheUpdate(Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)V

    move-object v1, p0

    move-object v2, p1

    .line 761
    invoke-direct/range {v1 .. v8}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->getUpdatedVariantEntry(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Ljava/util/Date;Ljava/util/Date;Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/Variant;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;

    move-result-object v10

    .line 765
    .local v10, "responseEntry":Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->responseGenerator:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedHttpResponseGenerator;

    invoke-virtual {v1, v10}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedHttpResponseGenerator;->generateResponse(Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    move-result-object v9

    .line 766
    .local v9, "resp":Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    invoke-direct {p0, p1, p2, v7}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->tryToUpdateVariantMap(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/Variant;)V

    .line 768
    invoke-direct {p0, p2, v10}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->shouldSendNotModifiedResponse(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 769
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->responseGenerator:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedHttpResponseGenerator;

    invoke-virtual {v1, v10}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedHttpResponseGenerator;->generateNotModifiedResponse(Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    move-result-object v9

    goto :goto_0
.end method

.method revalidateCacheEntry(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .locals 21
    .param p1, "target"    # Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    .param p2, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p3, "context"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    .param p4, "cacheEntry"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/comcast/cim/httpcomponentsandroid/ProtocolException;
        }
    .end annotation

    .prologue
    .line 818
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->conditionalRequestBuilder:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ConditionalRequestBuilder;

    move-object/from16 v0, p2

    move-object/from16 v1, p4

    invoke-virtual {v3, v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ConditionalRequestBuilder;->buildConditionalRequest(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;

    move-result-object v12

    .line 820
    .local v12, "conditionalRequest":Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    invoke-virtual/range {p0 .. p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->getCurrentDate()Ljava/util/Date;

    move-result-object v8

    .line 821
    .local v8, "requestDate":Ljava/util/Date;
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->backend:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    move-object/from16 v0, p1

    move-object/from16 v1, p3

    invoke-interface {v3, v0, v12, v1}, Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;->execute(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    move-result-object v7

    .line 822
    .local v7, "backendResponse":Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    invoke-virtual/range {p0 .. p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->getCurrentDate()Ljava/util/Date;

    move-result-object v9

    .line 824
    .local v9, "responseDate":Ljava/util/Date;
    move-object/from16 v0, p0

    move-object/from16 v1, p4

    invoke-direct {v0, v7, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->revalidationResponseIsTooOld(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 825
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->conditionalRequestBuilder:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ConditionalRequestBuilder;

    move-object/from16 v0, p2

    move-object/from16 v1, p4

    invoke-virtual {v3, v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ConditionalRequestBuilder;->buildUnconditionalRequest(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;

    move-result-object v19

    .line 827
    .local v19, "unconditional":Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    invoke-virtual/range {p0 .. p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->getCurrentDate()Ljava/util/Date;

    move-result-object v8

    .line 828
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->backend:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    move-object/from16 v0, p1

    move-object/from16 v1, v19

    move-object/from16 v2, p3

    invoke-interface {v3, v0, v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;->execute(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    move-result-object v7

    .line 829
    invoke-virtual/range {p0 .. p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->getCurrentDate()Ljava/util/Date;

    move-result-object v9

    .line 832
    .end local v19    # "unconditional":Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    :cond_0
    const-string v3, "Via"

    move-object/from16 v0, p0

    invoke-direct {v0, v7}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->generateViaHeader(Lcom/comcast/cim/httpcomponentsandroid/HttpMessage;)Ljava/lang/String;

    move-result-object v4

    invoke-interface {v7, v3, v4}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 834
    invoke-interface {v7}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getStatusLine()Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

    move-result-object v3

    invoke-interface {v3}, Lcom/comcast/cim/httpcomponentsandroid/StatusLine;->getStatusCode()I

    move-result v18

    .line 835
    .local v18, "statusCode":I
    const/16 v3, 0x130

    move/from16 v0, v18

    if-eq v0, v3, :cond_1

    const/16 v3, 0xc8

    move/from16 v0, v18

    if-ne v0, v3, :cond_2

    .line 836
    :cond_1
    move-object/from16 v0, p0

    move-object/from16 v1, p3

    invoke-direct {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->recordCacheUpdate(Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)V

    .line 839
    :cond_2
    const/16 v3, 0x130

    move/from16 v0, v18

    if-ne v0, v3, :cond_5

    .line 840
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->responseCache:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/HttpCache;

    move-object/from16 v4, p1

    move-object/from16 v5, p2

    move-object/from16 v6, p4

    invoke-interface/range {v3 .. v9}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/HttpCache;->updateCacheEntry(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;Ljava/util/Date;Ljava/util/Date;)Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;

    move-result-object v20

    .line 842
    .local v20, "updatedEntry":Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->suitabilityChecker:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedResponseSuitabilityChecker;

    move-object/from16 v0, p2

    invoke-virtual {v3, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedResponseSuitabilityChecker;->isConditional(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Z

    move-result v3

    if-eqz v3, :cond_4

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->suitabilityChecker:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedResponseSuitabilityChecker;

    new-instance v4, Ljava/util/Date;

    invoke-direct {v4}, Ljava/util/Date;-><init>()V

    move-object/from16 v0, p2

    move-object/from16 v1, v20

    invoke-virtual {v3, v0, v1, v4}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedResponseSuitabilityChecker;->allConditionalsMatch(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;Ljava/util/Date;)Z

    move-result v3

    if-eqz v3, :cond_4

    .line 844
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->responseGenerator:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedHttpResponseGenerator;

    move-object/from16 v0, v20

    invoke-virtual {v3, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedHttpResponseGenerator;->generateNotModifiedResponse(Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    move-result-object v16

    .line 859
    .end local v20    # "updatedEntry":Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    :cond_3
    :goto_0
    return-object v16

    .line 846
    .restart local v20    # "updatedEntry":Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    :cond_4
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->responseGenerator:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedHttpResponseGenerator;

    move-object/from16 v0, v20

    invoke-virtual {v3, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedHttpResponseGenerator;->generateResponse(Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    move-result-object v16

    goto :goto_0

    .line 849
    .end local v20    # "updatedEntry":Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    :cond_5
    move-object/from16 v0, p0

    move/from16 v1, v18

    invoke-direct {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->staleIfErrorAppliesTo(I)Z

    move-result v3

    if-eqz v3, :cond_6

    invoke-virtual/range {p0 .. p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->getCurrentDate()Ljava/util/Date;

    move-result-object v3

    move-object/from16 v0, p0

    move-object/from16 v1, p2

    move-object/from16 v2, p4

    invoke-direct {v0, v1, v2, v3}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->staleResponseNotAllowed(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;Ljava/util/Date;)Z

    move-result v3

    if-nez v3, :cond_6

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->validityPolicy:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheValidityPolicy;

    move-object/from16 v0, p2

    move-object/from16 v1, p4

    invoke-virtual {v3, v0, v1, v9}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheValidityPolicy;->mayReturnStaleIfError(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;Ljava/util/Date;)Z

    move-result v3

    if-eqz v3, :cond_6

    .line 852
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->responseGenerator:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedHttpResponseGenerator;

    move-object/from16 v0, p4

    invoke-virtual {v3, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedHttpResponseGenerator;->generateResponse(Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    move-result-object v16

    .line 853
    .local v16, "cachedResponse":Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    const-string v3, "Warning"

    const-string v4, "110 localhost \"Response is stale\""

    move-object/from16 v0, v16

    invoke-interface {v0, v3, v4}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 854
    invoke-interface {v7}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getEntity()Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    move-result-object v17

    .line 855
    .local v17, "errorBody":Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;
    if-eqz v17, :cond_3

    invoke-static/range {v17 .. v17}, Lcom/comcast/cim/httpcomponentsandroid/util/EntityUtils;->consume(Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;)V

    goto :goto_0

    .end local v16    # "cachedResponse":Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .end local v17    # "errorBody":Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;
    :cond_6
    move-object/from16 v10, p0

    move-object/from16 v11, p1

    move-object v13, v8

    move-object v14, v9

    move-object v15, v7

    .line 859
    invoke-virtual/range {v10 .. v15}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->handleBackendResponse(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Ljava/util/Date;Ljava/util/Date;Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    move-result-object v16

    goto :goto_0
.end method
