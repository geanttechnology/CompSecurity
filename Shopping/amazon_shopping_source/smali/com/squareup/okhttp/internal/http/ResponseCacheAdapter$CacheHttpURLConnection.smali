.class final Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter$CacheHttpURLConnection;
.super Ljava/net/HttpURLConnection;
.source "ResponseCacheAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "CacheHttpURLConnection"
.end annotation


# instance fields
.field private final request:Lcom/squareup/okhttp/internal/http/Request;

.field private final response:Lcom/squareup/okhttp/internal/http/Response;


# direct methods
.method public constructor <init>(Lcom/squareup/okhttp/internal/http/Response;)V
    .locals 2
    .param p1, "response"    # Lcom/squareup/okhttp/internal/http/Response;

    .prologue
    const/4 v0, 0x1

    .line 248
    invoke-virtual {p1}, Lcom/squareup/okhttp/internal/http/Response;->request()Lcom/squareup/okhttp/internal/http/Request;

    move-result-object v1

    invoke-virtual {v1}, Lcom/squareup/okhttp/internal/http/Request;->url()Ljava/net/URL;

    move-result-object v1

    invoke-direct {p0, v1}, Ljava/net/HttpURLConnection;-><init>(Ljava/net/URL;)V

    .line 249
    invoke-virtual {p1}, Lcom/squareup/okhttp/internal/http/Response;->request()Lcom/squareup/okhttp/internal/http/Request;

    move-result-object v1

    iput-object v1, p0, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter$CacheHttpURLConnection;->request:Lcom/squareup/okhttp/internal/http/Request;

    .line 250
    iput-object p1, p0, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter$CacheHttpURLConnection;->response:Lcom/squareup/okhttp/internal/http/Response;

    .line 253
    iput-boolean v0, p0, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter$CacheHttpURLConnection;->connected:Z

    .line 254
    invoke-virtual {p1}, Lcom/squareup/okhttp/internal/http/Response;->body()Lcom/squareup/okhttp/internal/http/Response$Body;

    move-result-object v1

    if-nez v1, :cond_0

    :goto_0
    iput-boolean v0, p0, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter$CacheHttpURLConnection;->doOutput:Z

    .line 257
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter$CacheHttpURLConnection;->request:Lcom/squareup/okhttp/internal/http/Request;

    invoke-virtual {v0}, Lcom/squareup/okhttp/internal/http/Request;->method()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter$CacheHttpURLConnection;->method:Ljava/lang/String;

    .line 258
    return-void

    .line 254
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method static synthetic access$300(Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter$CacheHttpURLConnection;)Lcom/squareup/okhttp/internal/http/Response;
    .locals 1
    .param p0, "x0"    # Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter$CacheHttpURLConnection;

    .prologue
    .line 242
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter$CacheHttpURLConnection;->response:Lcom/squareup/okhttp/internal/http/Response;

    return-object v0
.end method


# virtual methods
.method public addRequestProperty(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 281
    # invokes: Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;->throwRequestModificationException()Ljava/lang/RuntimeException;
    invoke-static {}, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;->access$000()Ljava/lang/RuntimeException;

    move-result-object v0

    throw v0
.end method

.method public connect()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 264
    # invokes: Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;->throwRequestModificationException()Ljava/lang/RuntimeException;
    invoke-static {}, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;->access$000()Ljava/lang/RuntimeException;

    move-result-object v0

    throw v0
.end method

.method public disconnect()V
    .locals 1

    .prologue
    .line 269
    # invokes: Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;->throwRequestModificationException()Ljava/lang/RuntimeException;
    invoke-static {}, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;->access$000()Ljava/lang/RuntimeException;

    move-result-object v0

    throw v0
.end method

.method public getAllowUserInteraction()Z
    .locals 1

    .prologue
    .line 463
    const/4 v0, 0x0

    return v0
.end method

.method public getConnectTimeout()I
    .locals 1

    .prologue
    .line 402
    const/4 v0, 0x0

    return v0
.end method

.method public getContent()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 418
    # invokes: Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;->throwResponseBodyAccessException()Ljava/lang/RuntimeException;
    invoke-static {}, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;->access$200()Ljava/lang/RuntimeException;

    move-result-object v0

    throw v0
.end method

.method public getContent([Ljava/lang/Class;)Ljava/lang/Object;
    .locals 1
    .param p1, "classes"    # [Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 423
    # invokes: Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;->throwResponseBodyAccessException()Ljava/lang/RuntimeException;
    invoke-static {}, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;->access$200()Ljava/lang/RuntimeException;

    move-result-object v0

    throw v0
.end method

.method public getDefaultUseCaches()Z
    .locals 1

    .prologue
    .line 488
    invoke-super {p0}, Ljava/net/HttpURLConnection;->getDefaultUseCaches()Z

    move-result v0

    return v0
.end method

.method public getDoInput()Z
    .locals 1

    .prologue
    .line 443
    const/4 v0, 0x1

    return v0
.end method

.method public getDoOutput()Z
    .locals 1

    .prologue
    .line 453
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter$CacheHttpURLConnection;->request:Lcom/squareup/okhttp/internal/http/Request;

    invoke-virtual {v0}, Lcom/squareup/okhttp/internal/http/Request;->body()Lcom/squareup/okhttp/internal/http/Request$Body;

    move-result-object v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getErrorStream()Ljava/io/InputStream;
    .locals 1

    .prologue
    .line 380
    const/4 v0, 0x0

    return-object v0
.end method

.method public getHeaderField(I)Ljava/lang/String;
    .locals 3
    .param p1, "position"    # I

    .prologue
    .line 349
    if-gez p1, :cond_0

    .line 350
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "Invalid header index: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 352
    :cond_0
    if-nez p1, :cond_1

    .line 353
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter$CacheHttpURLConnection;->response:Lcom/squareup/okhttp/internal/http/Response;

    invoke-virtual {v0}, Lcom/squareup/okhttp/internal/http/Response;->statusLine()Ljava/lang/String;

    move-result-object v0

    .line 355
    :goto_0
    return-object v0

    :cond_1
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter$CacheHttpURLConnection;->response:Lcom/squareup/okhttp/internal/http/Response;

    invoke-virtual {v0}, Lcom/squareup/okhttp/internal/http/Response;->headers()Lcom/squareup/okhttp/internal/http/Headers;

    move-result-object v0

    add-int/lit8 v1, p1, -0x1

    invoke-virtual {v0, v1}, Lcom/squareup/okhttp/internal/http/Headers;->value(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public getHeaderField(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "fieldName"    # Ljava/lang/String;

    .prologue
    .line 360
    if-nez p1, :cond_0

    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter$CacheHttpURLConnection;->response:Lcom/squareup/okhttp/internal/http/Response;

    invoke-virtual {v0}, Lcom/squareup/okhttp/internal/http/Response;->statusLine()Ljava/lang/String;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter$CacheHttpURLConnection;->response:Lcom/squareup/okhttp/internal/http/Response;

    invoke-virtual {v0}, Lcom/squareup/okhttp/internal/http/Response;->headers()Lcom/squareup/okhttp/internal/http/Headers;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/squareup/okhttp/internal/http/Headers;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public getHeaderFieldKey(I)Ljava/lang/String;
    .locals 3
    .param p1, "position"    # I

    .prologue
    .line 337
    if-gez p1, :cond_0

    .line 338
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "Invalid header index: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 340
    :cond_0
    if-nez p1, :cond_1

    .line 341
    const/4 v0, 0x0

    .line 343
    :goto_0
    return-object v0

    :cond_1
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter$CacheHttpURLConnection;->response:Lcom/squareup/okhttp/internal/http/Response;

    invoke-virtual {v0}, Lcom/squareup/okhttp/internal/http/Response;->headers()Lcom/squareup/okhttp/internal/http/Headers;

    move-result-object v0

    add-int/lit8 v1, p1, -0x1

    invoke-virtual {v0, v1}, Lcom/squareup/okhttp/internal/http/Headers;->name(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public getHeaderFields()Ljava/util/Map;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 365
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter$CacheHttpURLConnection;->response:Lcom/squareup/okhttp/internal/http/Response;

    invoke-virtual {v0}, Lcom/squareup/okhttp/internal/http/Response;->headers()Lcom/squareup/okhttp/internal/http/Headers;

    move-result-object v0

    iget-object v1, p0, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter$CacheHttpURLConnection;->response:Lcom/squareup/okhttp/internal/http/Response;

    invoke-virtual {v1}, Lcom/squareup/okhttp/internal/http/Response;->statusLine()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/squareup/okhttp/internal/http/OkHeaders;->toMultimap(Lcom/squareup/okhttp/internal/http/Headers;Ljava/lang/String;)Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method public getIfModifiedSince()J
    .locals 2

    .prologue
    .line 483
    const-wide/16 v0, 0x0

    return-wide v0
.end method

.method public getInputStream()Ljava/io/InputStream;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 428
    # invokes: Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;->throwResponseBodyAccessException()Ljava/lang/RuntimeException;
    invoke-static {}, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;->access$200()Ljava/lang/RuntimeException;

    move-result-object v0

    throw v0
.end method

.method public getInstanceFollowRedirects()Z
    .locals 1

    .prologue
    .line 319
    invoke-super {p0}, Ljava/net/HttpURLConnection;->getInstanceFollowRedirects()Z

    move-result v0

    return v0
.end method

.method public getOutputStream()Ljava/io/OutputStream;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 433
    # invokes: Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;->throwRequestModificationException()Ljava/lang/RuntimeException;
    invoke-static {}, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;->access$000()Ljava/lang/RuntimeException;

    move-result-object v0

    throw v0
.end method

.method public getReadTimeout()I
    .locals 1

    .prologue
    .line 413
    const/4 v0, 0x0

    return v0
.end method

.method public getRequestMethod()Ljava/lang/String;
    .locals 1

    .prologue
    .line 329
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter$CacheHttpURLConnection;->request:Lcom/squareup/okhttp/internal/http/Request;

    invoke-virtual {v0}, Lcom/squareup/okhttp/internal/http/Request;->method()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getRequestProperties()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 293
    # invokes: Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;->throwRequestHeaderAccessException()Ljava/lang/RuntimeException;
    invoke-static {}, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;->access$100()Ljava/lang/RuntimeException;

    move-result-object v0

    throw v0
.end method

.method public getRequestProperty(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 286
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter$CacheHttpURLConnection;->request:Lcom/squareup/okhttp/internal/http/Request;

    invoke-virtual {v0, p1}, Lcom/squareup/okhttp/internal/http/Request;->header(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getResponseCode()I
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 370
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter$CacheHttpURLConnection;->response:Lcom/squareup/okhttp/internal/http/Response;

    invoke-virtual {v0}, Lcom/squareup/okhttp/internal/http/Response;->code()I

    move-result v0

    return v0
.end method

.method public getResponseMessage()Ljava/lang/String;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 375
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter$CacheHttpURLConnection;->response:Lcom/squareup/okhttp/internal/http/Response;

    invoke-virtual {v0}, Lcom/squareup/okhttp/internal/http/Response;->statusMessage()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getUseCaches()Z
    .locals 1

    .prologue
    .line 473
    invoke-super {p0}, Ljava/net/HttpURLConnection;->getUseCaches()Z

    move-result v0

    return v0
.end method

.method public setAllowUserInteraction(Z)V
    .locals 1
    .param p1, "allowUserInteraction"    # Z

    .prologue
    .line 458
    # invokes: Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;->throwRequestModificationException()Ljava/lang/RuntimeException;
    invoke-static {}, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;->access$000()Ljava/lang/RuntimeException;

    move-result-object v0

    throw v0
.end method

.method public setChunkedStreamingMode(I)V
    .locals 1
    .param p1, "chunklen"    # I

    .prologue
    .line 308
    # invokes: Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;->throwRequestModificationException()Ljava/lang/RuntimeException;
    invoke-static {}, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;->access$000()Ljava/lang/RuntimeException;

    move-result-object v0

    throw v0
.end method

.method public setConnectTimeout(I)V
    .locals 1
    .param p1, "timeout"    # I

    .prologue
    .line 396
    # invokes: Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;->throwRequestModificationException()Ljava/lang/RuntimeException;
    invoke-static {}, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;->access$000()Ljava/lang/RuntimeException;

    move-result-object v0

    throw v0
.end method

.method public setDefaultUseCaches(Z)V
    .locals 0
    .param p1, "defaultUseCaches"    # Z

    .prologue
    .line 493
    invoke-super {p0, p1}, Ljava/net/HttpURLConnection;->setDefaultUseCaches(Z)V

    .line 494
    return-void
.end method

.method public setDoInput(Z)V
    .locals 1
    .param p1, "doInput"    # Z

    .prologue
    .line 438
    # invokes: Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;->throwRequestModificationException()Ljava/lang/RuntimeException;
    invoke-static {}, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;->access$000()Ljava/lang/RuntimeException;

    move-result-object v0

    throw v0
.end method

.method public setDoOutput(Z)V
    .locals 1
    .param p1, "doOutput"    # Z

    .prologue
    .line 448
    # invokes: Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;->throwRequestModificationException()Ljava/lang/RuntimeException;
    invoke-static {}, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;->access$000()Ljava/lang/RuntimeException;

    move-result-object v0

    throw v0
.end method

.method public setFixedLengthStreamingMode(I)V
    .locals 1
    .param p1, "contentLength"    # I

    .prologue
    .line 298
    # invokes: Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;->throwRequestModificationException()Ljava/lang/RuntimeException;
    invoke-static {}, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;->access$000()Ljava/lang/RuntimeException;

    move-result-object v0

    throw v0
.end method

.method public setFixedLengthStreamingMode(J)V
    .locals 1
    .param p1, "contentLength"    # J

    .prologue
    .line 303
    # invokes: Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;->throwRequestModificationException()Ljava/lang/RuntimeException;
    invoke-static {}, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;->access$000()Ljava/lang/RuntimeException;

    move-result-object v0

    throw v0
.end method

.method public setIfModifiedSince(J)V
    .locals 1
    .param p1, "ifModifiedSince"    # J

    .prologue
    .line 478
    # invokes: Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;->throwRequestModificationException()Ljava/lang/RuntimeException;
    invoke-static {}, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;->access$000()Ljava/lang/RuntimeException;

    move-result-object v0

    throw v0
.end method

.method public setInstanceFollowRedirects(Z)V
    .locals 1
    .param p1, "followRedirects"    # Z

    .prologue
    .line 313
    # invokes: Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;->throwRequestModificationException()Ljava/lang/RuntimeException;
    invoke-static {}, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;->access$000()Ljava/lang/RuntimeException;

    move-result-object v0

    throw v0
.end method

.method public setReadTimeout(I)V
    .locals 1
    .param p1, "timeout"    # I

    .prologue
    .line 407
    # invokes: Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;->throwRequestModificationException()Ljava/lang/RuntimeException;
    invoke-static {}, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;->access$000()Ljava/lang/RuntimeException;

    move-result-object v0

    throw v0
.end method

.method public setRequestMethod(Ljava/lang/String;)V
    .locals 1
    .param p1, "method"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/net/ProtocolException;
        }
    .end annotation

    .prologue
    .line 324
    # invokes: Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;->throwRequestModificationException()Ljava/lang/RuntimeException;
    invoke-static {}, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;->access$000()Ljava/lang/RuntimeException;

    move-result-object v0

    throw v0
.end method

.method public setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 276
    # invokes: Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;->throwRequestModificationException()Ljava/lang/RuntimeException;
    invoke-static {}, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;->access$000()Ljava/lang/RuntimeException;

    move-result-object v0

    throw v0
.end method

.method public setUseCaches(Z)V
    .locals 1
    .param p1, "useCaches"    # Z

    .prologue
    .line 468
    # invokes: Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;->throwRequestModificationException()Ljava/lang/RuntimeException;
    invoke-static {}, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;->access$000()Ljava/lang/RuntimeException;

    move-result-object v0

    throw v0
.end method

.method public usingProxy()Z
    .locals 1

    .prologue
    .line 389
    const/4 v0, 0x0

    return v0
.end method
