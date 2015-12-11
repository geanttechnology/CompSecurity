.class public final Lcom/squareup/okhttp/HttpResponseCache;
.super Ljava/net/ResponseCache;
.source "HttpResponseCache.java"

# interfaces
.implements Lcom/squareup/okhttp/OkResponseCache;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/squareup/okhttp/HttpResponseCache$1;,
        Lcom/squareup/okhttp/HttpResponseCache$CacheResponseBody;,
        Lcom/squareup/okhttp/HttpResponseCache$Entry;,
        Lcom/squareup/okhttp/HttpResponseCache$CacheRequestImpl;
    }
.end annotation


# static fields
.field private static final ENTRY_BODY:I = 0x1

.field private static final ENTRY_COUNT:I = 0x2

.field private static final ENTRY_METADATA:I = 0x0

.field private static final VERSION:I = 0x31191


# instance fields
.field private final cache:Lcom/squareup/okhttp/internal/DiskLruCache;

.field private hitCount:I

.field private networkCount:I

.field private requestCount:I

.field private writeAbortCount:I

.field private writeSuccessCount:I


# direct methods
.method public constructor <init>(Ljava/io/File;J)V
    .locals 2
    .param p1, "directory"    # Ljava/io/File;
    .param p2, "maxSize"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 127
    invoke-direct {p0}, Ljava/net/ResponseCache;-><init>()V

    .line 128
    const v0, 0x31191

    const/4 v1, 0x2

    invoke-static {p1, v0, v1, p2, p3}, Lcom/squareup/okhttp/internal/DiskLruCache;->open(Ljava/io/File;IIJ)Lcom/squareup/okhttp/internal/DiskLruCache;

    move-result-object v0

    iput-object v0, p0, Lcom/squareup/okhttp/HttpResponseCache;->cache:Lcom/squareup/okhttp/internal/DiskLruCache;

    .line 129
    return-void
.end method

.method private abortQuietly(Lcom/squareup/okhttp/internal/DiskLruCache$Editor;)V
    .locals 1
    .param p1, "editor"    # Lcom/squareup/okhttp/internal/DiskLruCache$Editor;

    .prologue
    .line 231
    if-eqz p1, :cond_0

    .line 232
    :try_start_0
    invoke-virtual {p1}, Lcom/squareup/okhttp/internal/DiskLruCache$Editor;->abort()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 236
    :cond_0
    :goto_0
    return-void

    .line 234
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method static synthetic access$208(Lcom/squareup/okhttp/HttpResponseCache;)I
    .locals 2
    .param p0, "x0"    # Lcom/squareup/okhttp/HttpResponseCache;

    .prologue
    .line 111
    iget v0, p0, Lcom/squareup/okhttp/HttpResponseCache;->writeSuccessCount:I

    add-int/lit8 v1, v0, 0x1

    iput v1, p0, Lcom/squareup/okhttp/HttpResponseCache;->writeSuccessCount:I

    return v0
.end method

.method static synthetic access$308(Lcom/squareup/okhttp/HttpResponseCache;)I
    .locals 2
    .param p0, "x0"    # Lcom/squareup/okhttp/HttpResponseCache;

    .prologue
    .line 111
    iget v0, p0, Lcom/squareup/okhttp/HttpResponseCache;->writeAbortCount:I

    add-int/lit8 v1, v0, 0x1

    iput v1, p0, Lcom/squareup/okhttp/HttpResponseCache;->writeAbortCount:I

    return v0
.end method

.method static synthetic access$400(Lcom/squareup/okhttp/internal/okio/BufferedSource;)I
    .locals 1
    .param p0, "x0"    # Lcom/squareup/okhttp/internal/okio/BufferedSource;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 111
    invoke-static {p0}, Lcom/squareup/okhttp/HttpResponseCache;->readInt(Lcom/squareup/okhttp/internal/okio/BufferedSource;)I

    move-result v0

    return v0
.end method

.method private static readInt(Lcom/squareup/okhttp/internal/okio/BufferedSource;)I
    .locals 5
    .param p0, "source"    # Lcom/squareup/okhttp/internal/okio/BufferedSource;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 543
    const/4 v2, 0x1

    invoke-interface {p0, v2}, Lcom/squareup/okhttp/internal/okio/BufferedSource;->readUtf8Line(Z)Ljava/lang/String;

    move-result-object v1

    .line 545
    .local v1, "line":Ljava/lang/String;
    :try_start_0
    invoke-static {v1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v2

    return v2

    .line 546
    :catch_0
    move-exception v0

    .line 547
    .local v0, "e":Ljava/lang/NumberFormatException;
    new-instance v2, Ljava/io/IOException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "Expected an integer but was \""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, "\""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v2
.end method

.method private static urlToKey(Lcom/squareup/okhttp/internal/http/Request;)Ljava/lang/String;
    .locals 1
    .param p0, "requst"    # Lcom/squareup/okhttp/internal/http/Request;

    .prologue
    .line 141
    invoke-virtual {p0}, Lcom/squareup/okhttp/internal/http/Request;->urlString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/squareup/okhttp/internal/Util;->hash(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public close()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 268
    iget-object v0, p0, Lcom/squareup/okhttp/HttpResponseCache;->cache:Lcom/squareup/okhttp/internal/DiskLruCache;

    invoke-virtual {v0}, Lcom/squareup/okhttp/internal/DiskLruCache;->close()V

    .line 269
    return-void
.end method

.method public delete()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 244
    iget-object v0, p0, Lcom/squareup/okhttp/HttpResponseCache;->cache:Lcom/squareup/okhttp/internal/DiskLruCache;

    invoke-virtual {v0}, Lcom/squareup/okhttp/internal/DiskLruCache;->delete()V

    .line 245
    return-void
.end method

.method public flush()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 264
    iget-object v0, p0, Lcom/squareup/okhttp/HttpResponseCache;->cache:Lcom/squareup/okhttp/internal/DiskLruCache;

    invoke-virtual {v0}, Lcom/squareup/okhttp/internal/DiskLruCache;->flush()V

    .line 265
    return-void
.end method

.method public get(Lcom/squareup/okhttp/internal/http/Request;)Lcom/squareup/okhttp/internal/http/Response;
    .locals 7
    .param p1, "request"    # Lcom/squareup/okhttp/internal/http/Request;

    .prologue
    const/4 v5, 0x0

    .line 145
    invoke-static {p1}, Lcom/squareup/okhttp/HttpResponseCache;->urlToKey(Lcom/squareup/okhttp/internal/http/Request;)Ljava/lang/String;

    move-result-object v2

    .line 149
    .local v2, "key":Ljava/lang/String;
    :try_start_0
    iget-object v6, p0, Lcom/squareup/okhttp/HttpResponseCache;->cache:Lcom/squareup/okhttp/internal/DiskLruCache;

    invoke-virtual {v6, v2}, Lcom/squareup/okhttp/internal/DiskLruCache;->get(Ljava/lang/String;)Lcom/squareup/okhttp/internal/DiskLruCache$Snapshot;

    move-result-object v4

    .line 150
    .local v4, "snapshot":Lcom/squareup/okhttp/internal/DiskLruCache$Snapshot;
    if-nez v4, :cond_1

    move-object v3, v5

    .line 166
    .end local v4    # "snapshot":Lcom/squareup/okhttp/internal/DiskLruCache$Snapshot;
    :cond_0
    :goto_0
    return-object v3

    .line 153
    .restart local v4    # "snapshot":Lcom/squareup/okhttp/internal/DiskLruCache$Snapshot;
    :cond_1
    new-instance v1, Lcom/squareup/okhttp/HttpResponseCache$Entry;

    const/4 v6, 0x0

    invoke-virtual {v4, v6}, Lcom/squareup/okhttp/internal/DiskLruCache$Snapshot;->getInputStream(I)Ljava/io/InputStream;

    move-result-object v6

    invoke-direct {v1, v6}, Lcom/squareup/okhttp/HttpResponseCache$Entry;-><init>(Ljava/io/InputStream;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 159
    .local v1, "entry":Lcom/squareup/okhttp/HttpResponseCache$Entry;
    invoke-virtual {v1, p1, v4}, Lcom/squareup/okhttp/HttpResponseCache$Entry;->response(Lcom/squareup/okhttp/internal/http/Request;Lcom/squareup/okhttp/internal/DiskLruCache$Snapshot;)Lcom/squareup/okhttp/internal/http/Response;

    move-result-object v3

    .line 161
    .local v3, "response":Lcom/squareup/okhttp/internal/http/Response;
    invoke-virtual {v1, p1, v3}, Lcom/squareup/okhttp/HttpResponseCache$Entry;->matches(Lcom/squareup/okhttp/internal/http/Request;Lcom/squareup/okhttp/internal/http/Response;)Z

    move-result v6

    if-nez v6, :cond_0

    .line 162
    invoke-virtual {v3}, Lcom/squareup/okhttp/internal/http/Response;->body()Lcom/squareup/okhttp/internal/http/Response$Body;

    move-result-object v6

    invoke-static {v6}, Lcom/squareup/okhttp/internal/Util;->closeQuietly(Ljava/io/Closeable;)V

    move-object v3, v5

    .line 163
    goto :goto_0

    .line 154
    .end local v1    # "entry":Lcom/squareup/okhttp/HttpResponseCache$Entry;
    .end local v3    # "response":Lcom/squareup/okhttp/internal/http/Response;
    .end local v4    # "snapshot":Lcom/squareup/okhttp/internal/DiskLruCache$Snapshot;
    :catch_0
    move-exception v0

    .local v0, "e":Ljava/io/IOException;
    move-object v3, v5

    .line 156
    goto :goto_0
.end method

.method public get(Ljava/net/URI;Ljava/lang/String;Ljava/util/Map;)Ljava/net/CacheResponse;
    .locals 2
    .param p1, "uri"    # Ljava/net/URI;
    .param p2, "s"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/net/URI;",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;>;)",
            "Ljava/net/CacheResponse;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 133
    .local p3, "stringListMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string/jumbo v1, "This is not a general purpose response cache."

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public getDirectory()Ljava/io/File;
    .locals 1

    .prologue
    .line 272
    iget-object v0, p0, Lcom/squareup/okhttp/HttpResponseCache;->cache:Lcom/squareup/okhttp/internal/DiskLruCache;

    invoke-virtual {v0}, Lcom/squareup/okhttp/internal/DiskLruCache;->getDirectory()Ljava/io/File;

    move-result-object v0

    return-object v0
.end method

.method public declared-synchronized getHitCount()I
    .locals 1

    .prologue
    .line 302
    monitor-enter p0

    :try_start_0
    iget v0, p0, Lcom/squareup/okhttp/HttpResponseCache;->hitCount:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public getMaxSize()J
    .locals 2

    .prologue
    .line 260
    iget-object v0, p0, Lcom/squareup/okhttp/HttpResponseCache;->cache:Lcom/squareup/okhttp/internal/DiskLruCache;

    invoke-virtual {v0}, Lcom/squareup/okhttp/internal/DiskLruCache;->getMaxSize()J

    move-result-wide v0

    return-wide v0
.end method

.method public declared-synchronized getNetworkCount()I
    .locals 1

    .prologue
    .line 298
    monitor-enter p0

    :try_start_0
    iget v0, p0, Lcom/squareup/okhttp/HttpResponseCache;->networkCount:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getRequestCount()I
    .locals 1

    .prologue
    .line 306
    monitor-enter p0

    :try_start_0
    iget v0, p0, Lcom/squareup/okhttp/HttpResponseCache;->requestCount:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public getSize()J
    .locals 2

    .prologue
    .line 256
    iget-object v0, p0, Lcom/squareup/okhttp/HttpResponseCache;->cache:Lcom/squareup/okhttp/internal/DiskLruCache;

    invoke-virtual {v0}, Lcom/squareup/okhttp/internal/DiskLruCache;->size()J

    move-result-wide v0

    return-wide v0
.end method

.method public declared-synchronized getWriteAbortCount()I
    .locals 1

    .prologue
    .line 248
    monitor-enter p0

    :try_start_0
    iget v0, p0, Lcom/squareup/okhttp/HttpResponseCache;->writeAbortCount:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getWriteSuccessCount()I
    .locals 1

    .prologue
    .line 252
    monitor-enter p0

    :try_start_0
    iget v0, p0, Lcom/squareup/okhttp/HttpResponseCache;->writeSuccessCount:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public isClosed()Z
    .locals 1

    .prologue
    .line 276
    iget-object v0, p0, Lcom/squareup/okhttp/HttpResponseCache;->cache:Lcom/squareup/okhttp/internal/DiskLruCache;

    invoke-virtual {v0}, Lcom/squareup/okhttp/internal/DiskLruCache;->isClosed()Z

    move-result v0

    return v0
.end method

.method public maybeRemove(Lcom/squareup/okhttp/internal/http/Request;)Z
    .locals 2
    .param p1, "request"    # Lcom/squareup/okhttp/internal/http/Request;

    .prologue
    .line 202
    invoke-virtual {p1}, Lcom/squareup/okhttp/internal/http/Request;->method()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/squareup/okhttp/internal/http/HttpMethod;->invalidatesCache(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 204
    :try_start_0
    iget-object v0, p0, Lcom/squareup/okhttp/HttpResponseCache;->cache:Lcom/squareup/okhttp/internal/DiskLruCache;

    invoke-static {p1}, Lcom/squareup/okhttp/HttpResponseCache;->urlToKey(Lcom/squareup/okhttp/internal/http/Request;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/squareup/okhttp/internal/DiskLruCache;->remove(Ljava/lang/String;)Z
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 208
    :goto_0
    const/4 v0, 0x1

    .line 210
    :goto_1
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_1

    .line 205
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method public put(Lcom/squareup/okhttp/internal/http/Response;)Ljava/net/CacheRequest;
    .locals 7
    .param p1, "response"    # Lcom/squareup/okhttp/internal/http/Response;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v4, 0x0

    .line 170
    invoke-virtual {p1}, Lcom/squareup/okhttp/internal/http/Response;->request()Lcom/squareup/okhttp/internal/http/Request;

    move-result-object v5

    invoke-virtual {v5}, Lcom/squareup/okhttp/internal/http/Request;->method()Ljava/lang/String;

    move-result-object v3

    .line 172
    .local v3, "requestMethod":Ljava/lang/String;
    invoke-virtual {p1}, Lcom/squareup/okhttp/internal/http/Response;->request()Lcom/squareup/okhttp/internal/http/Request;

    move-result-object v5

    invoke-virtual {p0, v5}, Lcom/squareup/okhttp/HttpResponseCache;->maybeRemove(Lcom/squareup/okhttp/internal/http/Request;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 197
    :cond_0
    :goto_0
    return-object v4

    .line 175
    :cond_1
    const-string/jumbo v5, "GET"

    invoke-virtual {v3, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 182
    invoke-virtual {p1}, Lcom/squareup/okhttp/internal/http/Response;->hasVaryAll()Z

    move-result v5

    if-nez v5, :cond_0

    .line 186
    new-instance v2, Lcom/squareup/okhttp/HttpResponseCache$Entry;

    invoke-direct {v2, p1}, Lcom/squareup/okhttp/HttpResponseCache$Entry;-><init>(Lcom/squareup/okhttp/internal/http/Response;)V

    .line 187
    .local v2, "entry":Lcom/squareup/okhttp/HttpResponseCache$Entry;
    const/4 v1, 0x0

    .line 189
    .local v1, "editor":Lcom/squareup/okhttp/internal/DiskLruCache$Editor;
    :try_start_0
    iget-object v5, p0, Lcom/squareup/okhttp/HttpResponseCache;->cache:Lcom/squareup/okhttp/internal/DiskLruCache;

    invoke-virtual {p1}, Lcom/squareup/okhttp/internal/http/Response;->request()Lcom/squareup/okhttp/internal/http/Request;

    move-result-object v6

    invoke-static {v6}, Lcom/squareup/okhttp/HttpResponseCache;->urlToKey(Lcom/squareup/okhttp/internal/http/Request;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/squareup/okhttp/internal/DiskLruCache;->edit(Ljava/lang/String;)Lcom/squareup/okhttp/internal/DiskLruCache$Editor;

    move-result-object v1

    .line 190
    if-eqz v1, :cond_0

    .line 193
    invoke-virtual {v2, v1}, Lcom/squareup/okhttp/HttpResponseCache$Entry;->writeTo(Lcom/squareup/okhttp/internal/DiskLruCache$Editor;)V

    .line 194
    new-instance v5, Lcom/squareup/okhttp/HttpResponseCache$CacheRequestImpl;

    invoke-direct {v5, p0, v1}, Lcom/squareup/okhttp/HttpResponseCache$CacheRequestImpl;-><init>(Lcom/squareup/okhttp/HttpResponseCache;Lcom/squareup/okhttp/internal/DiskLruCache$Editor;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-object v4, v5

    goto :goto_0

    .line 195
    :catch_0
    move-exception v0

    .line 196
    .local v0, "e":Ljava/io/IOException;
    invoke-direct {p0, v1}, Lcom/squareup/okhttp/HttpResponseCache;->abortQuietly(Lcom/squareup/okhttp/internal/DiskLruCache$Editor;)V

    goto :goto_0
.end method

.method public put(Ljava/net/URI;Ljava/net/URLConnection;)Ljava/net/CacheRequest;
    .locals 2
    .param p1, "uri"    # Ljava/net/URI;
    .param p2, "urlConnection"    # Ljava/net/URLConnection;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 137
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string/jumbo v1, "This is not a general purpose response cache."

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public declared-synchronized trackConditionalCacheHit()V
    .locals 1

    .prologue
    .line 294
    monitor-enter p0

    :try_start_0
    iget v0, p0, Lcom/squareup/okhttp/HttpResponseCache;->hitCount:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/squareup/okhttp/HttpResponseCache;->hitCount:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 295
    monitor-exit p0

    return-void

    .line 294
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized trackResponse(Lcom/squareup/okhttp/ResponseSource;)V
    .locals 2
    .param p1, "source"    # Lcom/squareup/okhttp/ResponseSource;

    .prologue
    .line 280
    monitor-enter p0

    :try_start_0
    iget v0, p0, Lcom/squareup/okhttp/HttpResponseCache;->requestCount:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/squareup/okhttp/HttpResponseCache;->requestCount:I

    .line 282
    sget-object v0, Lcom/squareup/okhttp/HttpResponseCache$1;->$SwitchMap$com$squareup$okhttp$ResponseSource:[I

    invoke-virtual {p1}, Lcom/squareup/okhttp/ResponseSource;->ordinal()I

    move-result v1

    aget v0, v0, v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    packed-switch v0, :pswitch_data_0

    .line 291
    :goto_0
    monitor-exit p0

    return-void

    .line 284
    :pswitch_0
    :try_start_1
    iget v0, p0, Lcom/squareup/okhttp/HttpResponseCache;->hitCount:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/squareup/okhttp/HttpResponseCache;->hitCount:I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 280
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    .line 288
    :pswitch_1
    :try_start_2
    iget v0, p0, Lcom/squareup/okhttp/HttpResponseCache;->networkCount:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/squareup/okhttp/HttpResponseCache;->networkCount:I
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0

    .line 282
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_1
    .end packed-switch
.end method

.method public update(Lcom/squareup/okhttp/internal/http/Response;Lcom/squareup/okhttp/internal/http/Response;)V
    .locals 5
    .param p1, "cached"    # Lcom/squareup/okhttp/internal/http/Response;
    .param p2, "network"    # Lcom/squareup/okhttp/internal/http/Response;

    .prologue
    .line 214
    new-instance v2, Lcom/squareup/okhttp/HttpResponseCache$Entry;

    invoke-direct {v2, p2}, Lcom/squareup/okhttp/HttpResponseCache$Entry;-><init>(Lcom/squareup/okhttp/internal/http/Response;)V

    .line 215
    .local v2, "entry":Lcom/squareup/okhttp/HttpResponseCache$Entry;
    invoke-virtual {p1}, Lcom/squareup/okhttp/internal/http/Response;->body()Lcom/squareup/okhttp/internal/http/Response$Body;

    move-result-object v4

    check-cast v4, Lcom/squareup/okhttp/HttpResponseCache$CacheResponseBody;

    # getter for: Lcom/squareup/okhttp/HttpResponseCache$CacheResponseBody;->snapshot:Lcom/squareup/okhttp/internal/DiskLruCache$Snapshot;
    invoke-static {v4}, Lcom/squareup/okhttp/HttpResponseCache$CacheResponseBody;->access$000(Lcom/squareup/okhttp/HttpResponseCache$CacheResponseBody;)Lcom/squareup/okhttp/internal/DiskLruCache$Snapshot;

    move-result-object v3

    .line 216
    .local v3, "snapshot":Lcom/squareup/okhttp/internal/DiskLruCache$Snapshot;
    const/4 v1, 0x0

    .line 218
    .local v1, "editor":Lcom/squareup/okhttp/internal/DiskLruCache$Editor;
    :try_start_0
    invoke-virtual {v3}, Lcom/squareup/okhttp/internal/DiskLruCache$Snapshot;->edit()Lcom/squareup/okhttp/internal/DiskLruCache$Editor;

    move-result-object v1

    .line 219
    if-eqz v1, :cond_0

    .line 220
    invoke-virtual {v2, v1}, Lcom/squareup/okhttp/HttpResponseCache$Entry;->writeTo(Lcom/squareup/okhttp/internal/DiskLruCache$Editor;)V

    .line 221
    invoke-virtual {v1}, Lcom/squareup/okhttp/internal/DiskLruCache$Editor;->commit()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 226
    :cond_0
    :goto_0
    return-void

    .line 223
    :catch_0
    move-exception v0

    .line 224
    .local v0, "e":Ljava/io/IOException;
    invoke-direct {p0, v1}, Lcom/squareup/okhttp/HttpResponseCache;->abortQuietly(Lcom/squareup/okhttp/internal/DiskLruCache$Editor;)V

    goto :goto_0
.end method
