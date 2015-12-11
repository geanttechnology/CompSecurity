.class Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedResponseSuitabilityChecker;
.super Ljava/lang/Object;
.source "CachedResponseSuitabilityChecker.java"


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/Immutable;
.end annotation


# instance fields
.field private final heuristicCoefficient:F

.field private final heuristicDefaultLifetime:J

.field private final log:Lorg/apache/commons/logging/Log;

.field private final sharedCache:Z

.field private final useHeuristicCaching:Z

.field private final validityStrategy:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheValidityPolicy;


# direct methods
.method constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheValidityPolicy;Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheConfig;)V
    .locals 2
    .param p1, "validityStrategy"    # Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheValidityPolicy;
    .param p2, "config"    # Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheConfig;

    .prologue
    .line 62
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 52
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-static {v0}, Lorg/apache/commons/logging/LogFactory;->getLog(Ljava/lang/Class;)Lorg/apache/commons/logging/Log;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedResponseSuitabilityChecker;->log:Lorg/apache/commons/logging/Log;

    .line 63
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedResponseSuitabilityChecker;->validityStrategy:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheValidityPolicy;

    .line 64
    invoke-virtual {p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheConfig;->isSharedCache()Z

    move-result v0

    iput-boolean v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedResponseSuitabilityChecker;->sharedCache:Z

    .line 65
    invoke-virtual {p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheConfig;->isHeuristicCachingEnabled()Z

    move-result v0

    iput-boolean v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedResponseSuitabilityChecker;->useHeuristicCaching:Z

    .line 66
    invoke-virtual {p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheConfig;->getHeuristicCoefficient()F

    move-result v0

    iput v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedResponseSuitabilityChecker;->heuristicCoefficient:F

    .line 67
    invoke-virtual {p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheConfig;->getHeuristicDefaultLifetime()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedResponseSuitabilityChecker;->heuristicDefaultLifetime:J

    .line 68
    return-void
.end method

.method private etagValidatorMatches(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)Z
    .locals 13
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p2, "entry"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;

    .prologue
    .line 274
    const-string v12, "ETag"

    invoke-virtual {p2, v12}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;->getFirstHeader(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v4

    .line 275
    .local v4, "etagHeader":Lcom/comcast/cim/httpcomponentsandroid/Header;
    if-eqz v4, :cond_2

    invoke-interface {v4}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getValue()Ljava/lang/String;

    move-result-object v3

    .line 276
    .local v3, "etag":Ljava/lang/String;
    :goto_0
    const-string v12, "If-None-Match"

    invoke-interface {p1, v12}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getHeaders(Ljava/lang/String;)[Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v8

    .line 277
    .local v8, "ifNoneMatch":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    if-eqz v8, :cond_5

    .line 278
    move-object v0, v8

    .local v0, "arr$":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    array-length v9, v0

    .local v9, "len$":I
    const/4 v6, 0x0

    .local v6, "i$":I
    move v7, v6

    .end local v0    # "arr$":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    .end local v6    # "i$":I
    .end local v9    # "len$":I
    .local v7, "i$":I
    :goto_1
    if-ge v7, v9, :cond_5

    aget-object v5, v0, v7

    .line 279
    .local v5, "h":Lcom/comcast/cim/httpcomponentsandroid/Header;
    invoke-interface {v5}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getElements()[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;

    move-result-object v1

    .local v1, "arr$":[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    array-length v10, v1

    .local v10, "len$":I
    const/4 v6, 0x0

    .end local v7    # "i$":I
    .restart local v6    # "i$":I
    :goto_2
    if-ge v6, v10, :cond_4

    aget-object v2, v1, v6

    .line 280
    .local v2, "elt":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v11

    .line 281
    .local v11, "reqEtag":Ljava/lang/String;
    const-string v12, "*"

    invoke-virtual {v12, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v12

    if-eqz v12, :cond_0

    if-nez v3, :cond_1

    :cond_0
    invoke-virtual {v11, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v12

    if-eqz v12, :cond_3

    .line 283
    :cond_1
    const/4 v12, 0x1

    .line 288
    .end local v1    # "arr$":[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .end local v2    # "elt":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .end local v5    # "h":Lcom/comcast/cim/httpcomponentsandroid/Header;
    .end local v6    # "i$":I
    .end local v10    # "len$":I
    .end local v11    # "reqEtag":Ljava/lang/String;
    :goto_3
    return v12

    .line 275
    .end local v3    # "etag":Ljava/lang/String;
    .end local v8    # "ifNoneMatch":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    :cond_2
    const/4 v3, 0x0

    goto :goto_0

    .line 279
    .restart local v1    # "arr$":[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .restart local v2    # "elt":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .restart local v3    # "etag":Ljava/lang/String;
    .restart local v5    # "h":Lcom/comcast/cim/httpcomponentsandroid/Header;
    .restart local v6    # "i$":I
    .restart local v8    # "ifNoneMatch":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    .restart local v10    # "len$":I
    .restart local v11    # "reqEtag":Ljava/lang/String;
    :cond_3
    add-int/lit8 v6, v6, 0x1

    goto :goto_2

    .line 278
    .end local v2    # "elt":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .end local v11    # "reqEtag":Ljava/lang/String;
    :cond_4
    add-int/lit8 v6, v7, 0x1

    move v7, v6

    .end local v6    # "i$":I
    .restart local v7    # "i$":I
    goto :goto_1

    .line 288
    .end local v1    # "arr$":[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .end local v5    # "h":Lcom/comcast/cim/httpcomponentsandroid/Header;
    .end local v7    # "i$":I
    .end local v10    # "len$":I
    :cond_5
    const/4 v12, 0x0

    goto :goto_3
.end method

.method private getMaxStale(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)J
    .locals 18
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;

    .prologue
    .line 93
    const-wide/16 v10, -0x1

    .line 94
    .local v10, "maxstale":J
    const-string v13, "Cache-Control"

    move-object/from16 v0, p1

    invoke-interface {v0, v13}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getHeaders(Ljava/lang/String;)[Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v2

    .local v2, "arr$":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    array-length v8, v2

    .local v8, "len$":I
    const/4 v6, 0x0

    .local v6, "i$":I
    move v7, v6

    .end local v2    # "arr$":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    .end local v6    # "i$":I
    .end local v8    # "len$":I
    .local v7, "i$":I
    :goto_0
    if-ge v7, v8, :cond_6

    aget-object v5, v2, v7

    .line 95
    .local v5, "h":Lcom/comcast/cim/httpcomponentsandroid/Header;
    invoke-interface {v5}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getElements()[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;

    move-result-object v3

    .local v3, "arr$":[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    array-length v9, v3

    .local v9, "len$":I
    const/4 v6, 0x0

    .end local v7    # "i$":I
    .restart local v6    # "i$":I
    :goto_1
    if-ge v6, v9, :cond_5

    aget-object v4, v3, v6

    .line 96
    .local v4, "elt":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    const-string v13, "max-stale"

    invoke-interface {v4}, Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;->getName()Ljava/lang/String;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-virtual {v13, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v13

    if-eqz v13, :cond_1

    .line 97
    invoke-interface {v4}, Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;->getValue()Ljava/lang/String;

    move-result-object v13

    if-eqz v13, :cond_0

    const-string v13, ""

    invoke-interface {v4}, Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;->getValue()Ljava/lang/String;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-virtual {v13, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v13

    if-eqz v13, :cond_2

    :cond_0
    const-wide/16 v16, -0x1

    cmp-long v13, v10, v16

    if-nez v13, :cond_2

    .line 99
    const-wide v10, 0x7fffffffffffffffL

    .line 95
    :cond_1
    :goto_2
    add-int/lit8 v6, v6, 0x1

    goto :goto_1

    .line 102
    :cond_2
    :try_start_0
    invoke-interface {v4}, Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;->getValue()Ljava/lang/String;

    move-result-object v13

    invoke-static {v13}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-wide v14

    .line 103
    .local v14, "val":J
    const-wide/16 v16, 0x0

    cmp-long v13, v14, v16

    if-gez v13, :cond_3

    const-wide/16 v14, 0x0

    .line 104
    :cond_3
    const-wide/16 v16, -0x1

    cmp-long v13, v10, v16

    if-eqz v13, :cond_4

    cmp-long v13, v14, v10

    if-gez v13, :cond_1

    .line 105
    :cond_4
    move-wide v10, v14

    goto :goto_2

    .line 107
    .end local v14    # "val":J
    :catch_0
    move-exception v12

    .line 109
    .local v12, "nfe":Ljava/lang/NumberFormatException;
    const-wide/16 v10, 0x0

    goto :goto_2

    .line 94
    .end local v4    # "elt":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .end local v12    # "nfe":Ljava/lang/NumberFormatException;
    :cond_5
    add-int/lit8 v6, v7, 0x1

    move v7, v6

    .end local v6    # "i$":I
    .restart local v7    # "i$":I
    goto :goto_0

    .line 115
    .end local v3    # "arr$":[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .end local v5    # "h":Lcom/comcast/cim/httpcomponentsandroid/Header;
    .end local v9    # "len$":I
    :cond_6
    return-wide v10
.end method

.method private hasSupportedEtagValidator(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Z
    .locals 1
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;

    .prologue
    .line 260
    const-string v0, "If-None-Match"

    invoke-interface {p1, v0}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->containsHeader(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method private hasSupportedLastModifiedValidator(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Z
    .locals 1
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;

    .prologue
    .line 264
    const-string v0, "If-Modified-Since"

    invoke-direct {p0, p1, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedResponseSuitabilityChecker;->hasValidDateField(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method private hasUnsupportedConditionalHeaders(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Z
    .locals 1
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;

    .prologue
    .line 254
    const-string v0, "If-Range"

    invoke-interface {p1, v0}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getFirstHeader(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v0

    if-nez v0, :cond_0

    const-string v0, "If-Match"

    invoke-interface {p1, v0}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getFirstHeader(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v0

    if-nez v0, :cond_0

    const-string v0, "If-Unmodified-Since"

    invoke-direct {p0, p1, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedResponseSuitabilityChecker;->hasValidDateField(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private hasValidDateField(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Ljava/lang/String;)Z
    .locals 5
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p2, "headerName"    # Ljava/lang/String;

    .prologue
    .line 328
    invoke-interface {p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getHeaders(Ljava/lang/String;)[Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v0

    .local v0, "arr$":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    array-length v3, v0

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_0
    if-ge v2, v3, :cond_0

    aget-object v1, v0, v2

    .line 330
    .local v1, "h":Lcom/comcast/cim/httpcomponentsandroid/Header;
    :try_start_0
    invoke-interface {v1}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getValue()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/DateUtils;->parseDate(Ljava/lang/String;)Ljava/util/Date;
    :try_end_0
    .catch Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/DateParseException; {:try_start_0 .. :try_end_0} :catch_0

    .line 331
    const/4 v4, 0x1

    .line 336
    .end local v1    # "h":Lcom/comcast/cim/httpcomponentsandroid/Header;
    :goto_1
    return v4

    .line 332
    .restart local v1    # "h":Lcom/comcast/cim/httpcomponentsandroid/Header;
    :catch_0
    move-exception v4

    .line 328
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 336
    .end local v1    # "h":Lcom/comcast/cim/httpcomponentsandroid/Header;
    :cond_0
    const/4 v4, 0x0

    goto :goto_1
.end method

.method private isFreshEnough(Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Ljava/util/Date;)Z
    .locals 10
    .param p1, "entry"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    .param p2, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p3, "now"    # Ljava/util/Date;

    .prologue
    const/4 v8, 0x1

    const/4 v9, 0x0

    .line 75
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedResponseSuitabilityChecker;->validityStrategy:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheValidityPolicy;

    invoke-virtual {v0, p1, p3}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheValidityPolicy;->isResponseFresh(Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;Ljava/util/Date;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 82
    :cond_0
    :goto_0
    return v8

    .line 76
    :cond_1
    iget-boolean v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedResponseSuitabilityChecker;->useHeuristicCaching:Z

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedResponseSuitabilityChecker;->validityStrategy:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheValidityPolicy;

    iget v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedResponseSuitabilityChecker;->heuristicCoefficient:F

    iget-wide v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedResponseSuitabilityChecker;->heuristicDefaultLifetime:J

    move-object v1, p1

    move-object v2, p3

    invoke-virtual/range {v0 .. v5}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheValidityPolicy;->isResponseHeuristicallyFresh(Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;Ljava/util/Date;FJ)Z

    move-result v0

    if-nez v0, :cond_0

    .line 79
    :cond_2
    invoke-direct {p0, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedResponseSuitabilityChecker;->originInsistsOnFreshness(Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)Z

    move-result v0

    if-eqz v0, :cond_3

    move v8, v9

    goto :goto_0

    .line 80
    :cond_3
    invoke-direct {p0, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedResponseSuitabilityChecker;->getMaxStale(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)J

    move-result-wide v6

    .line 81
    .local v6, "maxstale":J
    const-wide/16 v0, -0x1

    cmp-long v0, v6, v0

    if-nez v0, :cond_4

    move v8, v9

    goto :goto_0

    .line 82
    :cond_4
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedResponseSuitabilityChecker;->validityStrategy:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheValidityPolicy;

    invoke-virtual {v0, p1, p3}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheValidityPolicy;->getStalenessSecs(Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;Ljava/util/Date;)J

    move-result-wide v0

    cmp-long v0, v6, v0

    if-lez v0, :cond_5

    move v0, v8

    :goto_1
    move v8, v0

    goto :goto_0

    :cond_5
    move v0, v9

    goto :goto_1
.end method

.method private lastModifiedValidatorMatches(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;Ljava/util/Date;)Z
    .locals 9
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p2, "entry"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    .param p3, "now"    # Ljava/util/Date;

    .prologue
    const/4 v7, 0x0

    .line 300
    const-string v8, "Last-Modified"

    invoke-virtual {p2, v8}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;->getFirstHeader(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v5

    .line 301
    .local v5, "lastModifiedHeader":Lcom/comcast/cim/httpcomponentsandroid/Header;
    const/4 v4, 0x0

    .line 303
    .local v4, "lastModified":Ljava/util/Date;
    if-eqz v5, :cond_0

    .line 304
    :try_start_0
    invoke-interface {v5}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getValue()Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/DateUtils;->parseDate(Ljava/lang/String;)Ljava/util/Date;
    :try_end_0
    .catch Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/DateParseException; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v4

    .line 310
    :cond_0
    :goto_0
    if-nez v4, :cond_2

    .line 324
    :cond_1
    :goto_1
    return v7

    .line 314
    :cond_2
    const-string v8, "If-Modified-Since"

    invoke-interface {p1, v8}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getHeaders(Ljava/lang/String;)[Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v0

    .local v0, "arr$":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    array-length v6, v0

    .local v6, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_2
    if-ge v2, v6, :cond_3

    aget-object v1, v0, v2

    .line 316
    .local v1, "h":Lcom/comcast/cim/httpcomponentsandroid/Header;
    :try_start_1
    invoke-interface {v1}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getValue()Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/DateUtils;->parseDate(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v3

    .line 317
    .local v3, "ifModifiedSince":Ljava/util/Date;
    invoke-virtual {v3, p3}, Ljava/util/Date;->after(Ljava/util/Date;)Z

    move-result v8

    if-nez v8, :cond_1

    invoke-virtual {v4, v3}, Ljava/util/Date;->after(Ljava/util/Date;)Z
    :try_end_1
    .catch Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/DateParseException; {:try_start_1 .. :try_end_1} :catch_0

    move-result v8

    if-nez v8, :cond_1

    .line 314
    .end local v3    # "ifModifiedSince":Ljava/util/Date;
    :goto_3
    add-int/lit8 v2, v2, 0x1

    goto :goto_2

    .line 324
    .end local v1    # "h":Lcom/comcast/cim/httpcomponentsandroid/Header;
    :cond_3
    const/4 v7, 0x1

    goto :goto_1

    .line 320
    .restart local v1    # "h":Lcom/comcast/cim/httpcomponentsandroid/Header;
    :catch_0
    move-exception v8

    goto :goto_3

    .line 306
    .end local v0    # "arr$":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    .end local v1    # "h":Lcom/comcast/cim/httpcomponentsandroid/Header;
    .end local v2    # "i$":I
    .end local v6    # "len$":I
    :catch_1
    move-exception v8

    goto :goto_0
.end method

.method private originInsistsOnFreshness(Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)Z
    .locals 4
    .param p1, "entry"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;

    .prologue
    const/4 v1, 0x1

    const/4 v0, 0x0

    .line 86
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedResponseSuitabilityChecker;->validityStrategy:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheValidityPolicy;

    invoke-virtual {v2, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheValidityPolicy;->mustRevalidate(Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)Z

    move-result v2

    if-eqz v2, :cond_1

    move v0, v1

    .line 88
    :cond_0
    :goto_0
    return v0

    .line 87
    :cond_1
    iget-boolean v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedResponseSuitabilityChecker;->sharedCache:Z

    if-eqz v2, :cond_0

    .line 88
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedResponseSuitabilityChecker;->validityStrategy:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheValidityPolicy;

    invoke-virtual {v2, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheValidityPolicy;->proxyRevalidate(Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)Z

    move-result v2

    if-nez v2, :cond_2

    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedResponseSuitabilityChecker;->validityStrategy:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheValidityPolicy;

    const-string v3, "s-maxage"

    invoke-virtual {v2, p1, v3}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheValidityPolicy;->hasCacheControlDirective(Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    :cond_2
    move v0, v1

    goto :goto_0
.end method


# virtual methods
.method public allConditionalsMatch(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;Ljava/util/Date;)Z
    .locals 7
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p2, "entry"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    .param p3, "now"    # Ljava/util/Date;

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 234
    invoke-direct {p0, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedResponseSuitabilityChecker;->hasSupportedEtagValidator(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Z

    move-result v1

    .line 235
    .local v1, "hasEtagValidator":Z
    invoke-direct {p0, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedResponseSuitabilityChecker;->hasSupportedLastModifiedValidator(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Z

    move-result v2

    .line 237
    .local v2, "hasLastModifiedValidator":Z
    if-eqz v1, :cond_1

    invoke-direct {p0, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedResponseSuitabilityChecker;->etagValidatorMatches(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)Z

    move-result v6

    if-eqz v6, :cond_1

    move v0, v5

    .line 238
    .local v0, "etagValidatorMatches":Z
    :goto_0
    if-eqz v2, :cond_2

    invoke-direct {p0, p1, p2, p3}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedResponseSuitabilityChecker;->lastModifiedValidatorMatches(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;Ljava/util/Date;)Z

    move-result v6

    if-eqz v6, :cond_2

    move v3, v5

    .line 240
    .local v3, "lastModifiedValidatorMatches":Z
    :goto_1
    if-eqz v1, :cond_3

    if-eqz v2, :cond_3

    if-eqz v0, :cond_0

    if-nez v3, :cond_3

    .line 250
    :cond_0
    :goto_2
    return v4

    .end local v0    # "etagValidatorMatches":Z
    .end local v3    # "lastModifiedValidatorMatches":Z
    :cond_1
    move v0, v4

    .line 237
    goto :goto_0

    .restart local v0    # "etagValidatorMatches":Z
    :cond_2
    move v3, v4

    .line 238
    goto :goto_1

    .line 243
    .restart local v3    # "lastModifiedValidatorMatches":Z
    :cond_3
    if-eqz v1, :cond_4

    if-eqz v0, :cond_0

    .line 247
    :cond_4
    if-eqz v2, :cond_5

    if-eqz v3, :cond_0

    :cond_5
    move v4, v5

    .line 250
    goto :goto_2
.end method

.method public canCachedResponseBeUsed(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;Ljava/util/Date;)Z
    .locals 26
    .param p1, "host"    # Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    .param p2, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p3, "entry"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    .param p4, "now"    # Ljava/util/Date;

    .prologue
    .line 134
    move-object/from16 v0, p0

    move-object/from16 v1, p3

    move-object/from16 v2, p2

    move-object/from16 v3, p4

    invoke-direct {v0, v1, v2, v3}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedResponseSuitabilityChecker;->isFreshEnough(Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Ljava/util/Date;)Z

    move-result v19

    if-nez v19, :cond_0

    .line 135
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedResponseSuitabilityChecker;->log:Lorg/apache/commons/logging/Log;

    move-object/from16 v19, v0

    const-string v22, "Cache entry was not fresh enough"

    move-object/from16 v0, v19

    move-object/from16 v1, v22

    invoke-interface {v0, v1}, Lorg/apache/commons/logging/Log;->trace(Ljava/lang/Object;)V

    .line 136
    const/16 v19, 0x0

    .line 214
    :goto_0
    return v19

    .line 139
    :cond_0
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedResponseSuitabilityChecker;->validityStrategy:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheValidityPolicy;

    move-object/from16 v19, v0

    move-object/from16 v0, v19

    move-object/from16 v1, p3

    invoke-virtual {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheValidityPolicy;->contentLengthHeaderMatchesActualLength(Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)Z

    move-result v19

    if-nez v19, :cond_1

    .line 140
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedResponseSuitabilityChecker;->log:Lorg/apache/commons/logging/Log;

    move-object/from16 v19, v0

    const-string v22, "Cache entry Content-Length and header information do not match"

    move-object/from16 v0, v19

    move-object/from16 v1, v22

    invoke-interface {v0, v1}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    .line 141
    const/16 v19, 0x0

    goto :goto_0

    .line 144
    :cond_1
    move-object/from16 v0, p0

    move-object/from16 v1, p2

    invoke-direct {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedResponseSuitabilityChecker;->hasUnsupportedConditionalHeaders(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Z

    move-result v19

    if-eqz v19, :cond_2

    .line 145
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedResponseSuitabilityChecker;->log:Lorg/apache/commons/logging/Log;

    move-object/from16 v19, v0

    const-string v22, "Request contained conditional headers we don\'t handle"

    move-object/from16 v0, v19

    move-object/from16 v1, v22

    invoke-interface {v0, v1}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    .line 146
    const/16 v19, 0x0

    goto :goto_0

    .line 149
    :cond_2
    move-object/from16 v0, p0

    move-object/from16 v1, p2

    invoke-virtual {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedResponseSuitabilityChecker;->isConditional(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Z

    move-result v19

    if-eqz v19, :cond_3

    move-object/from16 v0, p0

    move-object/from16 v1, p2

    move-object/from16 v2, p3

    move-object/from16 v3, p4

    invoke-virtual {v0, v1, v2, v3}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedResponseSuitabilityChecker;->allConditionalsMatch(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;Ljava/util/Date;)Z

    move-result v19

    if-nez v19, :cond_3

    .line 150
    const/16 v19, 0x0

    goto :goto_0

    .line 153
    :cond_3
    const-string v19, "Cache-Control"

    move-object/from16 v0, p2

    move-object/from16 v1, v19

    invoke-interface {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getHeaders(Ljava/lang/String;)[Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v6

    .local v6, "arr$":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    array-length v15, v6

    .local v15, "len$":I
    const/4 v11, 0x0

    .local v11, "i$":I
    move v14, v11

    .end local v6    # "arr$":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    .end local v11    # "i$":I
    .end local v15    # "len$":I
    .local v14, "i$":I
    :goto_1
    if-ge v14, v15, :cond_b

    aget-object v8, v6, v14

    .line 154
    .local v8, "ccHdr":Lcom/comcast/cim/httpcomponentsandroid/Header;
    invoke-interface {v8}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getElements()[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;

    move-result-object v7

    .local v7, "arr$":[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    array-length v0, v7

    move/from16 v16, v0

    .local v16, "len$":I
    const/4 v11, 0x0

    .end local v14    # "i$":I
    .restart local v11    # "i$":I
    :goto_2
    move/from16 v0, v16

    if-ge v11, v0, :cond_a

    aget-object v9, v7, v11

    .line 155
    .local v9, "elt":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    const-string v19, "no-cache"

    invoke-interface {v9}, Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;->getName()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v19

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v19

    if-eqz v19, :cond_4

    .line 156
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedResponseSuitabilityChecker;->log:Lorg/apache/commons/logging/Log;

    move-object/from16 v19, v0

    const-string v22, "Response contained NO CACHE directive, cache was not suitable"

    move-object/from16 v0, v19

    move-object/from16 v1, v22

    invoke-interface {v0, v1}, Lorg/apache/commons/logging/Log;->trace(Ljava/lang/Object;)V

    .line 157
    const/16 v19, 0x0

    goto/16 :goto_0

    .line 160
    :cond_4
    const-string v19, "no-store"

    invoke-interface {v9}, Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;->getName()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v19

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v19

    if-eqz v19, :cond_5

    .line 161
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedResponseSuitabilityChecker;->log:Lorg/apache/commons/logging/Log;

    move-object/from16 v19, v0

    const-string v22, "Response contained NO STORE directive, cache was not suitable"

    move-object/from16 v0, v19

    move-object/from16 v1, v22

    invoke-interface {v0, v1}, Lorg/apache/commons/logging/Log;->trace(Ljava/lang/Object;)V

    .line 162
    const/16 v19, 0x0

    goto/16 :goto_0

    .line 165
    :cond_5
    const-string v19, "max-age"

    invoke-interface {v9}, Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;->getName()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v19

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v19

    if-eqz v19, :cond_6

    .line 167
    :try_start_0
    invoke-interface {v9}, Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;->getValue()Ljava/lang/String;

    move-result-object v19

    invoke-static/range {v19 .. v19}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v17

    .line 168
    .local v17, "maxage":I
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedResponseSuitabilityChecker;->validityStrategy:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheValidityPolicy;

    move-object/from16 v19, v0

    move-object/from16 v0, v19

    move-object/from16 v1, p3

    move-object/from16 v2, p4

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheValidityPolicy;->getCurrentAgeSecs(Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;Ljava/util/Date;)J

    move-result-wide v22

    move/from16 v0, v17

    int-to-long v0, v0

    move-wide/from16 v24, v0

    cmp-long v19, v22, v24

    if-lez v19, :cond_6

    .line 169
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedResponseSuitabilityChecker;->log:Lorg/apache/commons/logging/Log;

    move-object/from16 v19, v0

    const-string v22, "Response from cache was NOT suitable due to max age"

    move-object/from16 v0, v19

    move-object/from16 v1, v22

    invoke-interface {v0, v1}, Lorg/apache/commons/logging/Log;->trace(Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    .line 170
    const/16 v19, 0x0

    goto/16 :goto_0

    .line 172
    .end local v17    # "maxage":I
    :catch_0
    move-exception v10

    .line 174
    .local v10, "ex":Ljava/lang/NumberFormatException;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedResponseSuitabilityChecker;->log:Lorg/apache/commons/logging/Log;

    move-object/from16 v19, v0

    new-instance v22, Ljava/lang/StringBuilder;

    invoke-direct/range {v22 .. v22}, Ljava/lang/StringBuilder;-><init>()V

    const-string v23, "Response from cache was malformed"

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    invoke-virtual {v10}, Ljava/lang/NumberFormatException;->getMessage()Ljava/lang/String;

    move-result-object v23

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v19

    move-object/from16 v1, v22

    invoke-interface {v0, v1}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    .line 175
    const/16 v19, 0x0

    goto/16 :goto_0

    .line 179
    .end local v10    # "ex":Ljava/lang/NumberFormatException;
    :cond_6
    const-string v19, "max-stale"

    invoke-interface {v9}, Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;->getName()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v19

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v19

    if-eqz v19, :cond_7

    .line 181
    :try_start_1
    invoke-interface {v9}, Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;->getValue()Ljava/lang/String;

    move-result-object v19

    invoke-static/range {v19 .. v19}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v18

    .line 182
    .local v18, "maxstale":I
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedResponseSuitabilityChecker;->validityStrategy:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheValidityPolicy;

    move-object/from16 v19, v0

    move-object/from16 v0, v19

    move-object/from16 v1, p3

    invoke-virtual {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheValidityPolicy;->getFreshnessLifetimeSecs(Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)J

    move-result-wide v22

    move/from16 v0, v18

    int-to-long v0, v0

    move-wide/from16 v24, v0

    cmp-long v19, v22, v24

    if-lez v19, :cond_7

    .line 183
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedResponseSuitabilityChecker;->log:Lorg/apache/commons/logging/Log;

    move-object/from16 v19, v0

    const-string v22, "Response from cache was not suitable due to Max stale freshness"

    move-object/from16 v0, v19

    move-object/from16 v1, v22

    invoke-interface {v0, v1}, Lorg/apache/commons/logging/Log;->trace(Ljava/lang/Object;)V
    :try_end_1
    .catch Ljava/lang/NumberFormatException; {:try_start_1 .. :try_end_1} :catch_1

    .line 184
    const/16 v19, 0x0

    goto/16 :goto_0

    .line 186
    .end local v18    # "maxstale":I
    :catch_1
    move-exception v10

    .line 188
    .restart local v10    # "ex":Ljava/lang/NumberFormatException;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedResponseSuitabilityChecker;->log:Lorg/apache/commons/logging/Log;

    move-object/from16 v19, v0

    new-instance v22, Ljava/lang/StringBuilder;

    invoke-direct/range {v22 .. v22}, Ljava/lang/StringBuilder;-><init>()V

    const-string v23, "Response from cache was malformed: "

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    invoke-virtual {v10}, Ljava/lang/NumberFormatException;->getMessage()Ljava/lang/String;

    move-result-object v23

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v19

    move-object/from16 v1, v22

    invoke-interface {v0, v1}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    .line 189
    const/16 v19, 0x0

    goto/16 :goto_0

    .line 193
    .end local v10    # "ex":Ljava/lang/NumberFormatException;
    :cond_7
    const-string v19, "min-fresh"

    invoke-interface {v9}, Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;->getName()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v19

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v19

    if-eqz v19, :cond_9

    .line 195
    :try_start_2
    invoke-interface {v9}, Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;->getValue()Ljava/lang/String;

    move-result-object v19

    invoke-static/range {v19 .. v19}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v20

    .line 196
    .local v20, "minfresh":J
    const-wide/16 v22, 0x0

    cmp-long v19, v20, v22

    if-gez v19, :cond_8

    const/16 v19, 0x0

    goto/16 :goto_0

    .line 197
    :cond_8
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedResponseSuitabilityChecker;->validityStrategy:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheValidityPolicy;

    move-object/from16 v19, v0

    move-object/from16 v0, v19

    move-object/from16 v1, p3

    move-object/from16 v2, p4

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheValidityPolicy;->getCurrentAgeSecs(Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;Ljava/util/Date;)J

    move-result-wide v4

    .line 198
    .local v4, "age":J
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedResponseSuitabilityChecker;->validityStrategy:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheValidityPolicy;

    move-object/from16 v19, v0

    move-object/from16 v0, v19

    move-object/from16 v1, p3

    invoke-virtual {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheValidityPolicy;->getFreshnessLifetimeSecs(Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)J

    move-result-wide v12

    .line 199
    .local v12, "freshness":J
    sub-long v22, v12, v4

    cmp-long v19, v22, v20

    if-gez v19, :cond_9

    .line 200
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedResponseSuitabilityChecker;->log:Lorg/apache/commons/logging/Log;

    move-object/from16 v19, v0

    const-string v22, "Response from cache was not suitable due to min fresh freshness requirement"

    move-object/from16 v0, v19

    move-object/from16 v1, v22

    invoke-interface {v0, v1}, Lorg/apache/commons/logging/Log;->trace(Ljava/lang/Object;)V
    :try_end_2
    .catch Ljava/lang/NumberFormatException; {:try_start_2 .. :try_end_2} :catch_2

    .line 202
    const/16 v19, 0x0

    goto/16 :goto_0

    .line 204
    .end local v4    # "age":J
    .end local v12    # "freshness":J
    .end local v20    # "minfresh":J
    :catch_2
    move-exception v10

    .line 206
    .restart local v10    # "ex":Ljava/lang/NumberFormatException;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedResponseSuitabilityChecker;->log:Lorg/apache/commons/logging/Log;

    move-object/from16 v19, v0

    new-instance v22, Ljava/lang/StringBuilder;

    invoke-direct/range {v22 .. v22}, Ljava/lang/StringBuilder;-><init>()V

    const-string v23, "Response from cache was malformed: "

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    invoke-virtual {v10}, Ljava/lang/NumberFormatException;->getMessage()Ljava/lang/String;

    move-result-object v23

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v19

    move-object/from16 v1, v22

    invoke-interface {v0, v1}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    .line 207
    const/16 v19, 0x0

    goto/16 :goto_0

    .line 154
    .end local v10    # "ex":Ljava/lang/NumberFormatException;
    :cond_9
    add-int/lit8 v11, v11, 0x1

    goto/16 :goto_2

    .line 153
    .end local v9    # "elt":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    :cond_a
    add-int/lit8 v11, v14, 0x1

    move v14, v11

    .end local v11    # "i$":I
    .restart local v14    # "i$":I
    goto/16 :goto_1

    .line 213
    .end local v7    # "arr$":[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .end local v8    # "ccHdr":Lcom/comcast/cim/httpcomponentsandroid/Header;
    .end local v16    # "len$":I
    :cond_b
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedResponseSuitabilityChecker;->log:Lorg/apache/commons/logging/Log;

    move-object/from16 v19, v0

    const-string v22, "Response from cache was suitable"

    move-object/from16 v0, v19

    move-object/from16 v1, v22

    invoke-interface {v0, v1}, Lorg/apache/commons/logging/Log;->trace(Ljava/lang/Object;)V

    .line 214
    const/16 v19, 0x1

    goto/16 :goto_0
.end method

.method public isConditional(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Z
    .locals 1
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;

    .prologue
    .line 223
    invoke-direct {p0, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedResponseSuitabilityChecker;->hasSupportedEtagValidator(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-direct {p0, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachedResponseSuitabilityChecker;->hasSupportedLastModifiedValidator(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method
