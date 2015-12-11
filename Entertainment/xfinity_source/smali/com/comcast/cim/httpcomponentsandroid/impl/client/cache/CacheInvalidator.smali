.class Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheInvalidator;
.super Ljava/lang/Object;
.source "CacheInvalidator.java"


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/ThreadSafe;
.end annotation


# instance fields
.field private final cacheKeyGenerator:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheKeyGenerator;

.field private final log:Lorg/apache/commons/logging/Log;

.field private final storage:Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheStorage;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheKeyGenerator;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheStorage;)V
    .locals 1
    .param p1, "uriExtractor"    # Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheKeyGenerator;
    .param p2, "storage"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheStorage;

    .prologue
    .line 70
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 59
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-static {v0}, Lorg/apache/commons/logging/LogFactory;->getLog(Ljava/lang/Class;)Lorg/apache/commons/logging/Log;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheInvalidator;->log:Lorg/apache/commons/logging/Log;

    .line 71
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheInvalidator;->cacheKeyGenerator:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheKeyGenerator;

    .line 72
    iput-object p2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheInvalidator;->storage:Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheStorage;

    .line 73
    return-void
.end method

.method private flushEntry(Ljava/lang/String;)V
    .locals 3
    .param p1, "uri"    # Ljava/lang/String;

    .prologue
    .line 119
    :try_start_0
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheInvalidator;->storage:Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheStorage;

    invoke-interface {v1, p1}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheStorage;->removeEntry(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 123
    :goto_0
    return-void

    .line 120
    :catch_0
    move-exception v0

    .line 121
    .local v0, "ioe":Ljava/io/IOException;
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheInvalidator;->log:Lorg/apache/commons/logging/Log;

    const-string v2, "unable to flush cache entry"

    invoke-interface {v1, v2, v0}, Lorg/apache/commons/logging/Log;->warn(Ljava/lang/Object;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method private getAbsoluteURL(Ljava/lang/String;)Ljava/net/URL;
    .locals 3
    .param p1, "uri"    # Ljava/lang/String;

    .prologue
    .line 157
    const/4 v0, 0x0

    .line 159
    .local v0, "absURL":Ljava/net/URL;
    :try_start_0
    new-instance v1, Ljava/net/URL;

    invoke-direct {v1, p1}, Ljava/net/URL;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/net/MalformedURLException; {:try_start_0 .. :try_end_0} :catch_0

    .end local v0    # "absURL":Ljava/net/URL;
    .local v1, "absURL":Ljava/net/URL;
    move-object v0, v1

    .line 163
    .end local v1    # "absURL":Ljava/net/URL;
    .restart local v0    # "absURL":Ljava/net/URL;
    :goto_0
    return-object v0

    .line 160
    :catch_0
    move-exception v2

    goto :goto_0
.end method

.method private getContentLocationURL(Ljava/net/URL;Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)Ljava/net/URL;
    .locals 4
    .param p1, "reqURL"    # Ljava/net/URL;
    .param p2, "response"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    .prologue
    .line 208
    const-string v3, "Content-Location"

    invoke-interface {p2, v3}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getFirstHeader(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v1

    .line 209
    .local v1, "clHeader":Lcom/comcast/cim/httpcomponentsandroid/Header;
    if-nez v1, :cond_1

    const/4 v0, 0x0

    .line 213
    :cond_0
    :goto_0
    return-object v0

    .line 210
    :cond_1
    invoke-interface {v1}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getValue()Ljava/lang/String;

    move-result-object v2

    .line 211
    .local v2, "contentLocation":Ljava/lang/String;
    invoke-direct {p0, v2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheInvalidator;->getAbsoluteURL(Ljava/lang/String;)Ljava/net/URL;

    move-result-object v0

    .line 212
    .local v0, "canonURL":Ljava/net/URL;
    if-nez v0, :cond_0

    .line 213
    invoke-direct {p0, p1, v2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheInvalidator;->getRelativeURL(Ljava/net/URL;Ljava/lang/String;)Ljava/net/URL;

    move-result-object v0

    goto :goto_0
.end method

.method private getEntry(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    .locals 3
    .param p1, "theUri"    # Ljava/lang/String;

    .prologue
    .line 127
    :try_start_0
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheInvalidator;->storage:Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheStorage;

    invoke-interface {v1, p1}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheStorage;->getEntry(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 131
    :goto_0
    return-object v1

    .line 128
    :catch_0
    move-exception v0

    .line 129
    .local v0, "ioe":Ljava/io/IOException;
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheInvalidator;->log:Lorg/apache/commons/logging/Log;

    const-string v2, "could not retrieve entry from storage"

    invoke-interface {v1, v2, v0}, Lorg/apache/commons/logging/Log;->warn(Ljava/lang/Object;Ljava/lang/Throwable;)V

    .line 131
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private getRelativeURL(Ljava/net/URL;Ljava/lang/String;)Ljava/net/URL;
    .locals 3
    .param p1, "reqURL"    # Ljava/net/URL;
    .param p2, "relUri"    # Ljava/lang/String;

    .prologue
    .line 167
    const/4 v0, 0x0

    .line 169
    .local v0, "relURL":Ljava/net/URL;
    :try_start_0
    new-instance v1, Ljava/net/URL;

    invoke-direct {v1, p1, p2}, Ljava/net/URL;-><init>(Ljava/net/URL;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/net/MalformedURLException; {:try_start_0 .. :try_end_0} :catch_0

    .end local v0    # "relURL":Ljava/net/URL;
    .local v1, "relURL":Ljava/net/URL;
    move-object v0, v1

    .line 173
    .end local v1    # "relURL":Ljava/net/URL;
    .restart local v0    # "relURL":Ljava/net/URL;
    :goto_0
    return-object v0

    .line 170
    :catch_0
    move-exception v2

    goto :goto_0
.end method

.method private notGetOrHeadRequest(Ljava/lang/String;)Z
    .locals 1
    .param p1, "method"    # Ljava/lang/String;

    .prologue
    .line 182
    const-string v0, "GET"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "HEAD"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private responseAndEntryEtagsDiffer(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)Z
    .locals 5
    .param p1, "response"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .param p2, "entry"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;

    .prologue
    const/4 v2, 0x0

    .line 218
    const-string v3, "ETag"

    invoke-virtual {p2, v3}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;->getFirstHeader(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v0

    .line 219
    .local v0, "entryEtag":Lcom/comcast/cim/httpcomponentsandroid/Header;
    const-string v3, "ETag"

    invoke-interface {p1, v3}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getFirstHeader(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v1

    .line 220
    .local v1, "responseEtag":Lcom/comcast/cim/httpcomponentsandroid/Header;
    if-eqz v0, :cond_0

    if-nez v1, :cond_1

    .line 221
    :cond_0
    :goto_0
    return v2

    :cond_1
    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getValue()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getValue()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    const/4 v2, 0x1

    goto :goto_0
.end method

.method private responseDateNewerThanEntryDate(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)Z
    .locals 7
    .param p1, "response"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .param p2, "entry"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;

    .prologue
    const/4 v5, 0x0

    .line 226
    const-string v6, "Date"

    invoke-virtual {p2, v6}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;->getFirstHeader(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v2

    .line 227
    .local v2, "entryDateHeader":Lcom/comcast/cim/httpcomponentsandroid/Header;
    const-string v6, "Date"

    invoke-interface {p1, v6}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getFirstHeader(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v4

    .line 228
    .local v4, "responseDateHeader":Lcom/comcast/cim/httpcomponentsandroid/Header;
    if-eqz v2, :cond_0

    if-nez v4, :cond_1

    .line 236
    :cond_0
    :goto_0
    return v5

    .line 232
    :cond_1
    :try_start_0
    invoke-interface {v2}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getValue()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/DateUtils;->parseDate(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v1

    .line 233
    .local v1, "entryDate":Ljava/util/Date;
    invoke-interface {v4}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getValue()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/DateUtils;->parseDate(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v3

    .line 234
    .local v3, "responseDate":Ljava/util/Date;
    invoke-virtual {v3, v1}, Ljava/util/Date;->after(Ljava/util/Date;)Z
    :try_end_0
    .catch Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/DateParseException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v5

    goto :goto_0

    .line 235
    .end local v1    # "entryDate":Ljava/util/Date;
    .end local v3    # "responseDate":Ljava/util/Date;
    :catch_0
    move-exception v0

    .line 236
    .local v0, "e":Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/DateParseException;
    goto :goto_0
.end method


# virtual methods
.method protected flushAbsoluteUriFromSameHost(Ljava/net/URL;Ljava/lang/String;)Z
    .locals 2
    .param p1, "reqURL"    # Ljava/net/URL;
    .param p2, "uri"    # Ljava/lang/String;

    .prologue
    .line 150
    invoke-direct {p0, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheInvalidator;->getAbsoluteURL(Ljava/lang/String;)Ljava/net/URL;

    move-result-object v0

    .line 151
    .local v0, "absURL":Ljava/net/URL;
    if-nez v0, :cond_0

    const/4 v1, 0x0

    .line 153
    :goto_0
    return v1

    .line 152
    :cond_0
    invoke-virtual {p0, p1, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheInvalidator;->flushUriIfSameHost(Ljava/net/URL;Ljava/net/URL;)V

    .line 153
    const/4 v1, 0x1

    goto :goto_0
.end method

.method public flushInvalidatedCacheEntries(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)V
    .locals 11
    .param p1, "host"    # Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    .param p2, "req"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;

    .prologue
    .line 83
    invoke-virtual {p0, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheInvalidator;->requestShouldNotBeCached(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Z

    move-result v8

    if-eqz v8, :cond_2

    .line 84
    iget-object v8, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheInvalidator;->log:Lorg/apache/commons/logging/Log;

    const-string v9, "Request should not be cached"

    invoke-interface {v8, v9}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    .line 86
    iget-object v8, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheInvalidator;->cacheKeyGenerator:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheKeyGenerator;

    invoke-virtual {v8, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheKeyGenerator;->getURI(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Ljava/lang/String;

    move-result-object v6

    .line 88
    .local v6, "theUri":Ljava/lang/String;
    invoke-direct {p0, v6}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheInvalidator;->getEntry(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;

    move-result-object v4

    .line 90
    .local v4, "parent":Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    iget-object v8, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheInvalidator;->log:Lorg/apache/commons/logging/Log;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "parent entry: "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-interface {v8, v9}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    .line 92
    if-eqz v4, :cond_1

    .line 93
    invoke-virtual {v4}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;->getVariantMap()Ljava/util/Map;

    move-result-object v8

    invoke-interface {v8}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v8

    invoke-interface {v8}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/String;

    .line 94
    .local v7, "variantURI":Ljava/lang/String;
    invoke-direct {p0, v7}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheInvalidator;->flushEntry(Ljava/lang/String;)V

    goto :goto_0

    .line 96
    .end local v7    # "variantURI":Ljava/lang/String;
    :cond_0
    invoke-direct {p0, v6}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheInvalidator;->flushEntry(Ljava/lang/String;)V

    .line 98
    .end local v2    # "i$":Ljava/util/Iterator;
    :cond_1
    invoke-direct {p0, v6}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheInvalidator;->getAbsoluteURL(Ljava/lang/String;)Ljava/net/URL;

    move-result-object v5

    .line 99
    .local v5, "reqURL":Ljava/net/URL;
    if-nez v5, :cond_3

    .line 100
    iget-object v8, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheInvalidator;->log:Lorg/apache/commons/logging/Log;

    const-string v9, "Couldn\'t transform request into valid URL"

    invoke-interface {v8, v9}, Lorg/apache/commons/logging/Log;->error(Ljava/lang/Object;)V

    .line 115
    .end local v4    # "parent":Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    .end local v5    # "reqURL":Ljava/net/URL;
    .end local v6    # "theUri":Ljava/lang/String;
    :cond_2
    :goto_1
    return-void

    .line 103
    .restart local v4    # "parent":Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    .restart local v5    # "reqURL":Ljava/net/URL;
    .restart local v6    # "theUri":Ljava/lang/String;
    :cond_3
    const-string v8, "Content-Location"

    invoke-interface {p2, v8}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getFirstHeader(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v0

    .line 104
    .local v0, "clHdr":Lcom/comcast/cim/httpcomponentsandroid/Header;
    if-eqz v0, :cond_4

    .line 105
    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getValue()Ljava/lang/String;

    move-result-object v1

    .line 106
    .local v1, "contentLocation":Ljava/lang/String;
    invoke-virtual {p0, v5, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheInvalidator;->flushAbsoluteUriFromSameHost(Ljava/net/URL;Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_4

    .line 107
    invoke-virtual {p0, v5, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheInvalidator;->flushRelativeUriFromSameHost(Ljava/net/URL;Ljava/lang/String;)V

    .line 110
    .end local v1    # "contentLocation":Ljava/lang/String;
    :cond_4
    const-string v8, "Location"

    invoke-interface {p2, v8}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getFirstHeader(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v3

    .line 111
    .local v3, "lHdr":Lcom/comcast/cim/httpcomponentsandroid/Header;
    if-eqz v3, :cond_2

    .line 112
    invoke-interface {v3}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getValue()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {p0, v5, v8}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheInvalidator;->flushAbsoluteUriFromSameHost(Ljava/net/URL;Ljava/lang/String;)Z

    goto :goto_1
.end method

.method public flushInvalidatedCacheEntries(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)V
    .locals 7
    .param p1, "host"    # Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    .param p2, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p3, "response"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    .prologue
    .line 191
    invoke-interface {p3}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getStatusLine()Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

    move-result-object v5

    invoke-interface {v5}, Lcom/comcast/cim/httpcomponentsandroid/StatusLine;->getStatusCode()I

    move-result v4

    .line 192
    .local v4, "status":I
    const/16 v5, 0xc8

    if-lt v4, v5, :cond_0

    const/16 v5, 0x12b

    if-le v4, v5, :cond_1

    .line 205
    :cond_0
    :goto_0
    return-void

    .line 193
    :cond_1
    iget-object v5, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheInvalidator;->cacheKeyGenerator:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheKeyGenerator;

    invoke-virtual {v5, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheKeyGenerator;->getURI(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {p0, v5}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheInvalidator;->getAbsoluteURL(Ljava/lang/String;)Ljava/net/URL;

    move-result-object v3

    .line 194
    .local v3, "reqURL":Ljava/net/URL;
    if-eqz v3, :cond_0

    .line 195
    invoke-direct {p0, v3, p3}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheInvalidator;->getContentLocationURL(Ljava/net/URL;Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)Ljava/net/URL;

    move-result-object v1

    .line 196
    .local v1, "canonURL":Ljava/net/URL;
    if-eqz v1, :cond_0

    .line 197
    iget-object v5, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheInvalidator;->cacheKeyGenerator:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheKeyGenerator;

    invoke-virtual {v1}, Ljava/net/URL;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheKeyGenerator;->canonicalizeUri(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 198
    .local v0, "cacheKey":Ljava/lang/String;
    invoke-direct {p0, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheInvalidator;->getEntry(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;

    move-result-object v2

    .line 199
    .local v2, "entry":Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    if-eqz v2, :cond_0

    .line 201
    invoke-direct {p0, p3, v2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheInvalidator;->responseDateNewerThanEntryDate(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 202
    invoke-direct {p0, p3, v2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheInvalidator;->responseAndEntryEtagsDiffer(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 204
    invoke-virtual {p0, v3, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheInvalidator;->flushUriIfSameHost(Ljava/net/URL;Ljava/net/URL;)V

    goto :goto_0
.end method

.method protected flushRelativeUriFromSameHost(Ljava/net/URL;Ljava/lang/String;)V
    .locals 1
    .param p1, "reqURL"    # Ljava/net/URL;
    .param p2, "relUri"    # Ljava/lang/String;

    .prologue
    .line 143
    invoke-direct {p0, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheInvalidator;->getRelativeURL(Ljava/net/URL;Ljava/lang/String;)Ljava/net/URL;

    move-result-object v0

    .line 144
    .local v0, "relURL":Ljava/net/URL;
    if-nez v0, :cond_0

    .line 146
    :goto_0
    return-void

    .line 145
    :cond_0
    invoke-virtual {p0, p1, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheInvalidator;->flushUriIfSameHost(Ljava/net/URL;Ljava/net/URL;)V

    goto :goto_0
.end method

.method protected flushUriIfSameHost(Ljava/net/URL;Ljava/net/URL;)V
    .locals 3
    .param p1, "requestURL"    # Ljava/net/URL;
    .param p2, "targetURL"    # Ljava/net/URL;

    .prologue
    .line 135
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheInvalidator;->cacheKeyGenerator:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheKeyGenerator;

    invoke-virtual {p2}, Ljava/net/URL;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheKeyGenerator;->canonicalizeUri(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheInvalidator;->getAbsoluteURL(Ljava/lang/String;)Ljava/net/URL;

    move-result-object v0

    .line 136
    .local v0, "canonicalTarget":Ljava/net/URL;
    if-nez v0, :cond_1

    .line 140
    :cond_0
    :goto_0
    return-void

    .line 137
    :cond_1
    invoke-virtual {v0}, Ljava/net/URL;->getAuthority()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1}, Ljava/net/URL;->getAuthority()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 138
    invoke-virtual {v0}, Ljava/net/URL;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheInvalidator;->flushEntry(Ljava/lang/String;)V

    goto :goto_0
.end method

.method protected requestShouldNotBeCached(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Z
    .locals 2
    .param p1, "req"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;

    .prologue
    .line 177
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getRequestLine()Lcom/comcast/cim/httpcomponentsandroid/RequestLine;

    move-result-object v1

    invoke-interface {v1}, Lcom/comcast/cim/httpcomponentsandroid/RequestLine;->getMethod()Ljava/lang/String;

    move-result-object v0

    .line 178
    .local v0, "method":Ljava/lang/String;
    invoke-direct {p0, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheInvalidator;->notGetOrHeadRequest(Ljava/lang/String;)Z

    move-result v1

    return v1
.end method
