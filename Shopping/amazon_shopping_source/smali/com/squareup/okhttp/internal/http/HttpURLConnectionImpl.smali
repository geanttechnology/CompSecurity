.class public Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;
.super Ljava/net/HttpURLConnection;
.source "HttpURLConnectionImpl.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl$Retry;
    }
.end annotation


# static fields
.field public static final MAX_REDIRECTS:I = 0x14


# instance fields
.field final client:Lcom/squareup/okhttp/OkHttpClient;

.field private fixedContentLength:J

.field handshake:Lcom/squareup/okhttp/Handshake;

.field protected httpEngine:Lcom/squareup/okhttp/internal/http/HttpEngine;

.field protected httpEngineFailure:Ljava/io/IOException;

.field private redirectionCount:I

.field private requestHeaders:Lcom/squareup/okhttp/internal/http/Headers$Builder;

.field private route:Lcom/squareup/okhttp/Route;


# direct methods
.method public constructor <init>(Ljava/net/URL;Lcom/squareup/okhttp/OkHttpClient;)V
    .locals 2
    .param p1, "url"    # Ljava/net/URL;
    .param p2, "client"    # Lcom/squareup/okhttp/OkHttpClient;

    .prologue
    .line 95
    invoke-direct {p0, p1}, Ljava/net/HttpURLConnection;-><init>(Ljava/net/URL;)V

    .line 74
    new-instance v0, Lcom/squareup/okhttp/internal/http/Headers$Builder;

    invoke-direct {v0}, Lcom/squareup/okhttp/internal/http/Headers$Builder;-><init>()V

    iput-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->requestHeaders:Lcom/squareup/okhttp/internal/http/Headers$Builder;

    .line 77
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->fixedContentLength:J

    .line 96
    iput-object p2, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->client:Lcom/squareup/okhttp/OkHttpClient;

    .line 97
    return-void
.end method

.method private execute(Z)Z
    .locals 3
    .param p1, "readResponse"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 375
    :try_start_0
    iget-object v2, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->httpEngine:Lcom/squareup/okhttp/internal/http/HttpEngine;

    invoke-virtual {v2}, Lcom/squareup/okhttp/internal/http/HttpEngine;->sendRequest()V

    .line 376
    iget-object v2, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->httpEngine:Lcom/squareup/okhttp/internal/http/HttpEngine;

    invoke-virtual {v2}, Lcom/squareup/okhttp/internal/http/HttpEngine;->getRoute()Lcom/squareup/okhttp/Route;

    move-result-object v2

    iput-object v2, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->route:Lcom/squareup/okhttp/Route;

    .line 377
    iget-object v2, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->httpEngine:Lcom/squareup/okhttp/internal/http/HttpEngine;

    invoke-virtual {v2}, Lcom/squareup/okhttp/internal/http/HttpEngine;->getConnection()Lcom/squareup/okhttp/Connection;

    move-result-object v2

    if-eqz v2, :cond_1

    iget-object v2, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->httpEngine:Lcom/squareup/okhttp/internal/http/HttpEngine;

    invoke-virtual {v2}, Lcom/squareup/okhttp/internal/http/HttpEngine;->getConnection()Lcom/squareup/okhttp/Connection;

    move-result-object v2

    invoke-virtual {v2}, Lcom/squareup/okhttp/Connection;->getHandshake()Lcom/squareup/okhttp/Handshake;

    move-result-object v2

    :goto_0
    iput-object v2, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->handshake:Lcom/squareup/okhttp/Handshake;

    .line 380
    if-eqz p1, :cond_0

    .line 381
    iget-object v2, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->httpEngine:Lcom/squareup/okhttp/internal/http/HttpEngine;

    invoke-virtual {v2}, Lcom/squareup/okhttp/internal/http/HttpEngine;->readResponse()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 384
    :cond_0
    const/4 v2, 0x1

    .line 389
    :goto_1
    return v2

    .line 377
    :cond_1
    const/4 v2, 0x0

    goto :goto_0

    .line 385
    :catch_0
    move-exception v0

    .line 386
    .local v0, "e":Ljava/io/IOException;
    iget-object v2, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->httpEngine:Lcom/squareup/okhttp/internal/http/HttpEngine;

    invoke-virtual {v2, v0}, Lcom/squareup/okhttp/internal/http/HttpEngine;->recover(Ljava/io/IOException;)Lcom/squareup/okhttp/internal/http/HttpEngine;

    move-result-object v1

    .line 387
    .local v1, "retryEngine":Lcom/squareup/okhttp/internal/http/HttpEngine;
    if-eqz v1, :cond_2

    .line 388
    iput-object v1, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->httpEngine:Lcom/squareup/okhttp/internal/http/HttpEngine;

    .line 389
    const/4 v2, 0x0

    goto :goto_1

    .line 393
    :cond_2
    iput-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->httpEngineFailure:Ljava/io/IOException;

    .line 394
    throw v0
.end method

.method private getResponse()Lcom/squareup/okhttp/internal/http/HttpEngine;
    .locals 7
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 321
    invoke-direct {p0}, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->initHttpEngine()V

    .line 323
    iget-object v5, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->httpEngine:Lcom/squareup/okhttp/internal/http/HttpEngine;

    invoke-virtual {v5}, Lcom/squareup/okhttp/internal/http/HttpEngine;->hasResponse()Z

    move-result v5

    if-eqz v5, :cond_0

    .line 324
    iget-object v5, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->httpEngine:Lcom/squareup/okhttp/internal/http/HttpEngine;

    .line 335
    :goto_0
    return-object v5

    .line 328
    :cond_0
    :goto_1
    const/4 v5, 0x1

    invoke-direct {p0, v5}, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->execute(Z)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 332
    invoke-direct {p0}, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->processResponseHeaders()Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl$Retry;

    move-result-object v3

    .line 333
    .local v3, "retry":Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl$Retry;
    sget-object v5, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl$Retry;->NONE:Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl$Retry;

    if-ne v3, v5, :cond_1

    .line 334
    iget-object v5, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->httpEngine:Lcom/squareup/okhttp/internal/http/HttpEngine;

    invoke-virtual {v5}, Lcom/squareup/okhttp/internal/http/HttpEngine;->releaseConnection()V

    .line 335
    iget-object v5, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->httpEngine:Lcom/squareup/okhttp/internal/http/HttpEngine;

    goto :goto_0

    .line 339
    :cond_1
    iget-object v4, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->method:Ljava/lang/String;

    .line 340
    .local v4, "retryMethod":Ljava/lang/String;
    iget-object v5, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->httpEngine:Lcom/squareup/okhttp/internal/http/HttpEngine;

    invoke-virtual {v5}, Lcom/squareup/okhttp/internal/http/HttpEngine;->getRequestBody()Lcom/squareup/okhttp/internal/okio/Sink;

    move-result-object v1

    .line 345
    .local v1, "requestBody":Lcom/squareup/okhttp/internal/okio/Sink;
    iget-object v5, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->httpEngine:Lcom/squareup/okhttp/internal/http/HttpEngine;

    invoke-virtual {v5}, Lcom/squareup/okhttp/internal/http/HttpEngine;->getResponse()Lcom/squareup/okhttp/internal/http/Response;

    move-result-object v5

    invoke-virtual {v5}, Lcom/squareup/okhttp/internal/http/Response;->code()I

    move-result v2

    .line 346
    .local v2, "responseCode":I
    const/16 v5, 0x12c

    if-eq v2, v5, :cond_2

    const/16 v5, 0x12d

    if-eq v2, v5, :cond_2

    const/16 v5, 0x12e

    if-eq v2, v5, :cond_2

    const/16 v5, 0x12f

    if-ne v2, v5, :cond_3

    .line 350
    :cond_2
    const-string/jumbo v4, "GET"

    .line 351
    iget-object v5, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->requestHeaders:Lcom/squareup/okhttp/internal/http/Headers$Builder;

    const-string/jumbo v6, "Content-Length"

    invoke-virtual {v5, v6}, Lcom/squareup/okhttp/internal/http/Headers$Builder;->removeAll(Ljava/lang/String;)Lcom/squareup/okhttp/internal/http/Headers$Builder;

    .line 352
    const/4 v1, 0x0

    .line 355
    :cond_3
    if-eqz v1, :cond_4

    instance-of v5, v1, Lcom/squareup/okhttp/internal/http/RetryableSink;

    if-nez v5, :cond_4

    .line 356
    new-instance v5, Ljava/net/HttpRetryException;

    const-string/jumbo v6, "Cannot retry streamed HTTP body"

    invoke-direct {v5, v6, v2}, Ljava/net/HttpRetryException;-><init>(Ljava/lang/String;I)V

    throw v5

    .line 359
    :cond_4
    sget-object v5, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl$Retry;->DIFFERENT_CONNECTION:Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl$Retry;

    if-ne v3, v5, :cond_5

    .line 360
    iget-object v5, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->httpEngine:Lcom/squareup/okhttp/internal/http/HttpEngine;

    invoke-virtual {v5}, Lcom/squareup/okhttp/internal/http/HttpEngine;->releaseConnection()V

    .line 363
    :cond_5
    iget-object v5, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->httpEngine:Lcom/squareup/okhttp/internal/http/HttpEngine;

    invoke-virtual {v5}, Lcom/squareup/okhttp/internal/http/HttpEngine;->close()Lcom/squareup/okhttp/Connection;

    move-result-object v0

    .line 364
    .local v0, "connection":Lcom/squareup/okhttp/Connection;
    check-cast v1, Lcom/squareup/okhttp/internal/http/RetryableSink;

    .end local v1    # "requestBody":Lcom/squareup/okhttp/internal/okio/Sink;
    invoke-direct {p0, v4, v0, v1}, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->newHttpEngine(Ljava/lang/String;Lcom/squareup/okhttp/Connection;Lcom/squareup/okhttp/internal/http/RetryableSink;)Lcom/squareup/okhttp/internal/http/HttpEngine;

    move-result-object v5

    iput-object v5, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->httpEngine:Lcom/squareup/okhttp/internal/http/HttpEngine;

    goto :goto_1
.end method

.method private initHttpEngine()V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 259
    iget-object v1, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->httpEngineFailure:Ljava/io/IOException;

    if-eqz v1, :cond_0

    .line 260
    iget-object v1, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->httpEngineFailure:Ljava/io/IOException;

    throw v1

    .line 261
    :cond_0
    iget-object v1, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->httpEngine:Lcom/squareup/okhttp/internal/http/HttpEngine;

    if-eqz v1, :cond_1

    .line 281
    :goto_0
    return-void

    .line 265
    :cond_1
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->connected:Z

    .line 267
    :try_start_0
    iget-boolean v1, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->doOutput:Z

    if-eqz v1, :cond_2

    .line 268
    iget-object v1, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->method:Ljava/lang/String;

    const-string/jumbo v2, "GET"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 270
    const-string/jumbo v1, "POST"

    iput-object v1, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->method:Ljava/lang/String;

    .line 276
    :cond_2
    iget-object v1, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->method:Ljava/lang/String;

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-direct {p0, v1, v2, v3}, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->newHttpEngine(Ljava/lang/String;Lcom/squareup/okhttp/Connection;Lcom/squareup/okhttp/internal/http/RetryableSink;)Lcom/squareup/okhttp/internal/http/HttpEngine;

    move-result-object v1

    iput-object v1, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->httpEngine:Lcom/squareup/okhttp/internal/http/HttpEngine;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 277
    :catch_0
    move-exception v0

    .line 278
    .local v0, "e":Ljava/io/IOException;
    iput-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->httpEngineFailure:Ljava/io/IOException;

    .line 279
    throw v0

    .line 271
    .end local v0    # "e":Ljava/io/IOException;
    :cond_3
    :try_start_1
    iget-object v1, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->method:Ljava/lang/String;

    invoke-static {v1}, Lcom/squareup/okhttp/internal/http/HttpMethod;->hasRequestBody(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_2

    .line 273
    new-instance v1, Ljava/net/ProtocolException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->method:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, " does not support writing"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/net/ProtocolException;-><init>(Ljava/lang/String;)V

    throw v1
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
.end method

.method private newHttpEngine(Ljava/lang/String;Lcom/squareup/okhttp/Connection;Lcom/squareup/okhttp/internal/http/RetryableSink;)Lcom/squareup/okhttp/internal/http/HttpEngine;
    .locals 12
    .param p1, "method"    # Ljava/lang/String;
    .param p2, "connection"    # Lcom/squareup/okhttp/Connection;
    .param p3, "requestBody"    # Lcom/squareup/okhttp/internal/http/RetryableSink;

    .prologue
    .line 285
    new-instance v0, Lcom/squareup/okhttp/internal/http/Request$Builder;

    invoke-direct {v0}, Lcom/squareup/okhttp/internal/http/Request$Builder;-><init>()V

    invoke-virtual {p0}, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->getURL()Ljava/net/URL;

    move-result-object v4

    invoke-virtual {v0, v4}, Lcom/squareup/okhttp/internal/http/Request$Builder;->url(Ljava/net/URL;)Lcom/squareup/okhttp/internal/http/Request$Builder;

    move-result-object v0

    const/4 v4, 0x0

    invoke-virtual {v0, p1, v4}, Lcom/squareup/okhttp/internal/http/Request$Builder;->method(Ljava/lang/String;Lcom/squareup/okhttp/internal/http/Request$Body;)Lcom/squareup/okhttp/internal/http/Request$Builder;

    move-result-object v7

    .line 288
    .local v7, "builder":Lcom/squareup/okhttp/internal/http/Request$Builder;
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->requestHeaders:Lcom/squareup/okhttp/internal/http/Headers$Builder;

    invoke-virtual {v0}, Lcom/squareup/okhttp/internal/http/Headers$Builder;->build()Lcom/squareup/okhttp/internal/http/Headers;

    move-result-object v8

    .line 289
    .local v8, "headers":Lcom/squareup/okhttp/internal/http/Headers;
    const/4 v9, 0x0

    .local v9, "i":I
    :goto_0
    invoke-virtual {v8}, Lcom/squareup/okhttp/internal/http/Headers;->size()I

    move-result v0

    if-ge v9, v0, :cond_0

    .line 290
    invoke-virtual {v8, v9}, Lcom/squareup/okhttp/internal/http/Headers;->name(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v8, v9}, Lcom/squareup/okhttp/internal/http/Headers;->value(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v7, v0, v4}, Lcom/squareup/okhttp/internal/http/Request$Builder;->addHeader(Ljava/lang/String;Ljava/lang/String;)Lcom/squareup/okhttp/internal/http/Request$Builder;

    .line 289
    add-int/lit8 v9, v9, 0x1

    goto :goto_0

    .line 293
    :cond_0
    const/4 v3, 0x0

    .line 294
    .local v3, "bufferRequestBody":Z
    invoke-static {p1}, Lcom/squareup/okhttp/internal/http/HttpMethod;->hasRequestBody(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 295
    iget-wide v4, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->fixedContentLength:J

    const-wide/16 v10, -0x1

    cmp-long v0, v4, v10

    if-eqz v0, :cond_3

    .line 296
    const-string/jumbo v0, "Content-Length"

    iget-wide v4, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->fixedContentLength:J

    invoke-static {v4, v5}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v7, v0, v4}, Lcom/squareup/okhttp/internal/http/Request$Builder;->header(Ljava/lang/String;Ljava/lang/String;)Lcom/squareup/okhttp/internal/http/Request$Builder;

    .line 304
    :cond_1
    :goto_1
    invoke-virtual {v7}, Lcom/squareup/okhttp/internal/http/Request$Builder;->build()Lcom/squareup/okhttp/internal/http/Request;

    move-result-object v2

    .line 307
    .local v2, "request":Lcom/squareup/okhttp/internal/http/Request;
    iget-object v1, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->client:Lcom/squareup/okhttp/OkHttpClient;

    .line 308
    .local v1, "engineClient":Lcom/squareup/okhttp/OkHttpClient;
    invoke-virtual {v1}, Lcom/squareup/okhttp/OkHttpClient;->getOkResponseCache()Lcom/squareup/okhttp/OkResponseCache;

    move-result-object v0

    if-eqz v0, :cond_2

    invoke-virtual {p0}, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->getUseCaches()Z

    move-result v0

    if-nez v0, :cond_2

    .line 309
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->client:Lcom/squareup/okhttp/OkHttpClient;

    invoke-virtual {v0}, Lcom/squareup/okhttp/OkHttpClient;->clone()Lcom/squareup/okhttp/OkHttpClient;

    move-result-object v0

    const/4 v4, 0x0

    invoke-virtual {v0, v4}, Lcom/squareup/okhttp/OkHttpClient;->setOkResponseCache(Lcom/squareup/okhttp/OkResponseCache;)Lcom/squareup/okhttp/OkHttpClient;

    move-result-object v1

    .line 312
    :cond_2
    new-instance v0, Lcom/squareup/okhttp/internal/http/HttpEngine;

    const/4 v5, 0x0

    move-object v4, p2

    move-object v6, p3

    invoke-direct/range {v0 .. v6}, Lcom/squareup/okhttp/internal/http/HttpEngine;-><init>(Lcom/squareup/okhttp/OkHttpClient;Lcom/squareup/okhttp/internal/http/Request;ZLcom/squareup/okhttp/Connection;Lcom/squareup/okhttp/internal/http/RouteSelector;Lcom/squareup/okhttp/internal/http/RetryableSink;)V

    return-object v0

    .line 297
    .end local v1    # "engineClient":Lcom/squareup/okhttp/OkHttpClient;
    .end local v2    # "request":Lcom/squareup/okhttp/internal/http/Request;
    :cond_3
    iget v0, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->chunkLength:I

    if-lez v0, :cond_4

    .line 298
    const-string/jumbo v0, "Transfer-Encoding"

    const-string/jumbo v4, "chunked"

    invoke-virtual {v7, v0, v4}, Lcom/squareup/okhttp/internal/http/Request$Builder;->header(Ljava/lang/String;Ljava/lang/String;)Lcom/squareup/okhttp/internal/http/Request$Builder;

    goto :goto_1

    .line 300
    :cond_4
    const/4 v3, 0x1

    goto :goto_1
.end method

.method private processResponseHeaders()Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl$Retry;
    .locals 12
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 410
    iget-object v9, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->httpEngine:Lcom/squareup/okhttp/internal/http/HttpEngine;

    invoke-virtual {v9}, Lcom/squareup/okhttp/internal/http/HttpEngine;->getConnection()Lcom/squareup/okhttp/Connection;

    move-result-object v0

    .line 411
    .local v0, "connection":Lcom/squareup/okhttp/Connection;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/squareup/okhttp/Connection;->getRoute()Lcom/squareup/okhttp/Route;

    move-result-object v9

    invoke-virtual {v9}, Lcom/squareup/okhttp/Route;->getProxy()Ljava/net/Proxy;

    move-result-object v7

    .line 414
    .local v7, "selectedProxy":Ljava/net/Proxy;
    :goto_0
    invoke-virtual {p0}, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->getResponseCode()I

    move-result v3

    .line 415
    .local v3, "responseCode":I
    sparse-switch v3, :sswitch_data_0

    .line 466
    sget-object v9, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl$Retry;->NONE:Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl$Retry;

    :goto_1
    return-object v9

    .line 411
    .end local v3    # "responseCode":I
    .end local v7    # "selectedProxy":Ljava/net/Proxy;
    :cond_0
    iget-object v9, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->client:Lcom/squareup/okhttp/OkHttpClient;

    invoke-virtual {v9}, Lcom/squareup/okhttp/OkHttpClient;->getProxy()Ljava/net/Proxy;

    move-result-object v7

    goto :goto_0

    .line 417
    .restart local v3    # "responseCode":I
    .restart local v7    # "selectedProxy":Ljava/net/Proxy;
    :sswitch_0
    invoke-virtual {v7}, Ljava/net/Proxy;->type()Ljava/net/Proxy$Type;

    move-result-object v9

    sget-object v10, Ljava/net/Proxy$Type;->HTTP:Ljava/net/Proxy$Type;

    if-eq v9, v10, :cond_1

    .line 418
    new-instance v9, Ljava/net/ProtocolException;

    const-string/jumbo v10, "Received HTTP_PROXY_AUTH (407) code while not using proxy"

    invoke-direct {v9, v10}, Ljava/net/ProtocolException;-><init>(Ljava/lang/String;)V

    throw v9

    .line 422
    :cond_1
    :sswitch_1
    iget-object v9, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->client:Lcom/squareup/okhttp/OkHttpClient;

    invoke-virtual {v9}, Lcom/squareup/okhttp/OkHttpClient;->getAuthenticator()Lcom/squareup/okhttp/OkAuthenticator;

    move-result-object v9

    iget-object v10, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->httpEngine:Lcom/squareup/okhttp/internal/http/HttpEngine;

    invoke-virtual {v10}, Lcom/squareup/okhttp/internal/http/HttpEngine;->getResponse()Lcom/squareup/okhttp/internal/http/Response;

    move-result-object v10

    invoke-static {v9, v10, v7}, Lcom/squareup/okhttp/internal/http/HttpAuthenticator;->processAuthHeader(Lcom/squareup/okhttp/OkAuthenticator;Lcom/squareup/okhttp/internal/http/Response;Ljava/net/Proxy;)Lcom/squareup/okhttp/internal/http/Request;

    move-result-object v8

    .line 424
    .local v8, "successorRequest":Lcom/squareup/okhttp/internal/http/Request;
    if-nez v8, :cond_2

    sget-object v9, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl$Retry;->NONE:Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl$Retry;

    goto :goto_1

    .line 425
    :cond_2
    invoke-virtual {v8}, Lcom/squareup/okhttp/internal/http/Request;->getHeaders()Lcom/squareup/okhttp/internal/http/Headers;

    move-result-object v9

    invoke-virtual {v9}, Lcom/squareup/okhttp/internal/http/Headers;->newBuilder()Lcom/squareup/okhttp/internal/http/Headers$Builder;

    move-result-object v9

    iput-object v9, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->requestHeaders:Lcom/squareup/okhttp/internal/http/Headers$Builder;

    .line 426
    sget-object v9, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl$Retry;->SAME_CONNECTION:Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl$Retry;

    goto :goto_1

    .line 433
    .end local v8    # "successorRequest":Lcom/squareup/okhttp/internal/http/Request;
    :sswitch_2
    invoke-virtual {p0}, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->getInstanceFollowRedirects()Z

    move-result v9

    if-nez v9, :cond_3

    .line 434
    sget-object v9, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl$Retry;->NONE:Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl$Retry;

    goto :goto_1

    .line 436
    :cond_3
    iget v9, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->redirectionCount:I

    add-int/lit8 v9, v9, 0x1

    iput v9, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->redirectionCount:I

    const/16 v10, 0x14

    if-le v9, v10, :cond_4

    .line 437
    new-instance v9, Ljava/net/ProtocolException;

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v11, "Too many redirects: "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    iget v11, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->redirectionCount:I

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-direct {v9, v10}, Ljava/net/ProtocolException;-><init>(Ljava/lang/String;)V

    throw v9

    .line 439
    :cond_4
    const/16 v9, 0x133

    if-ne v3, v9, :cond_5

    iget-object v9, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->method:Ljava/lang/String;

    const-string/jumbo v10, "GET"

    invoke-virtual {v9, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-nez v9, :cond_5

    iget-object v9, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->method:Ljava/lang/String;

    const-string/jumbo v10, "HEAD"

    invoke-virtual {v9, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-nez v9, :cond_5

    .line 442
    sget-object v9, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl$Retry;->NONE:Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl$Retry;

    goto/16 :goto_1

    .line 444
    :cond_5
    const-string/jumbo v9, "Location"

    invoke-virtual {p0, v9}, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->getHeaderField(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 445
    .local v1, "location":Ljava/lang/String;
    if-nez v1, :cond_6

    .line 446
    sget-object v9, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl$Retry;->NONE:Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl$Retry;

    goto/16 :goto_1

    .line 448
    :cond_6
    iget-object v2, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->url:Ljava/net/URL;

    .line 449
    .local v2, "previousUrl":Ljava/net/URL;
    new-instance v9, Ljava/net/URL;

    invoke-direct {v9, v2, v1}, Ljava/net/URL;-><init>(Ljava/net/URL;Ljava/lang/String;)V

    iput-object v9, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->url:Ljava/net/URL;

    .line 450
    iget-object v9, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->url:Ljava/net/URL;

    invoke-virtual {v9}, Ljava/net/URL;->getProtocol()Ljava/lang/String;

    move-result-object v9

    const-string/jumbo v10, "https"

    invoke-virtual {v9, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-nez v9, :cond_7

    iget-object v9, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->url:Ljava/net/URL;

    invoke-virtual {v9}, Ljava/net/URL;->getProtocol()Ljava/lang/String;

    move-result-object v9

    const-string/jumbo v10, "http"

    invoke-virtual {v9, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-nez v9, :cond_7

    .line 451
    sget-object v9, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl$Retry;->NONE:Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl$Retry;

    goto/16 :goto_1

    .line 453
    :cond_7
    invoke-virtual {v2}, Ljava/net/URL;->getProtocol()Ljava/lang/String;

    move-result-object v9

    iget-object v10, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->url:Ljava/net/URL;

    invoke-virtual {v10}, Ljava/net/URL;->getProtocol()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    .line 454
    .local v6, "sameProtocol":Z
    if-nez v6, :cond_8

    iget-object v9, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->client:Lcom/squareup/okhttp/OkHttpClient;

    invoke-virtual {v9}, Lcom/squareup/okhttp/OkHttpClient;->getFollowProtocolRedirects()Z

    move-result v9

    if-nez v9, :cond_8

    .line 455
    sget-object v9, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl$Retry;->NONE:Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl$Retry;

    goto/16 :goto_1

    .line 457
    :cond_8
    invoke-virtual {v2}, Ljava/net/URL;->getHost()Ljava/lang/String;

    move-result-object v9

    iget-object v10, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->url:Ljava/net/URL;

    invoke-virtual {v10}, Ljava/net/URL;->getHost()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    .line 458
    .local v4, "sameHost":Z
    invoke-static {v2}, Lcom/squareup/okhttp/internal/Util;->getEffectivePort(Ljava/net/URL;)I

    move-result v9

    iget-object v10, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->url:Ljava/net/URL;

    invoke-static {v10}, Lcom/squareup/okhttp/internal/Util;->getEffectivePort(Ljava/net/URL;)I

    move-result v10

    if-ne v9, v10, :cond_9

    const/4 v5, 0x1

    .line 459
    .local v5, "samePort":Z
    :goto_2
    if-eqz v4, :cond_a

    if-eqz v5, :cond_a

    if-eqz v6, :cond_a

    .line 460
    sget-object v9, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl$Retry;->SAME_CONNECTION:Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl$Retry;

    goto/16 :goto_1

    .line 458
    .end local v5    # "samePort":Z
    :cond_9
    const/4 v5, 0x0

    goto :goto_2

    .line 462
    .restart local v5    # "samePort":Z
    :cond_a
    sget-object v9, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl$Retry;->DIFFERENT_CONNECTION:Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl$Retry;

    goto/16 :goto_1

    .line 415
    :sswitch_data_0
    .sparse-switch
        0x12c -> :sswitch_2
        0x12d -> :sswitch_2
        0x12e -> :sswitch_2
        0x12f -> :sswitch_2
        0x133 -> :sswitch_2
        0x191 -> :sswitch_1
        0x197 -> :sswitch_0
    .end sparse-switch
.end method

.method private setProtocols(Ljava/lang/String;Z)V
    .locals 8
    .param p1, "protocolsString"    # Ljava/lang/String;
    .param p2, "append"    # Z

    .prologue
    .line 562
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    .line 563
    .local v5, "protocolsList":Ljava/util/List;, "Ljava/util/List<Lcom/squareup/okhttp/Protocol;>;"
    if-eqz p2, :cond_0

    .line 564
    iget-object v6, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->client:Lcom/squareup/okhttp/OkHttpClient;

    invoke-virtual {v6}, Lcom/squareup/okhttp/OkHttpClient;->getProtocols()Ljava/util/List;

    move-result-object v6

    invoke-interface {v5, v6}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 566
    :cond_0
    const-string/jumbo v6, ","

    const/4 v7, -0x1

    invoke-virtual {p1, v6, v7}, Ljava/lang/String;->split(Ljava/lang/String;I)[Ljava/lang/String;

    move-result-object v0

    .local v0, "arr$":[Ljava/lang/String;
    array-length v3, v0

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_0
    if-ge v2, v3, :cond_1

    aget-object v4, v0, v2

    .line 568
    .local v4, "protocol":Ljava/lang/String;
    :try_start_0
    invoke-static {v4}, Lcom/squareup/okhttp/internal/okio/ByteString;->encodeUtf8(Ljava/lang/String;)Lcom/squareup/okhttp/internal/okio/ByteString;

    move-result-object v6

    invoke-static {v6}, Lcom/squareup/okhttp/internal/Util;->getProtocol(Lcom/squareup/okhttp/internal/okio/ByteString;)Lcom/squareup/okhttp/Protocol;

    move-result-object v6

    invoke-interface {v5, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 566
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 569
    :catch_0
    move-exception v1

    .line 570
    .local v1, "e":Ljava/io/IOException;
    new-instance v6, Ljava/lang/IllegalStateException;

    invoke-direct {v6, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/Throwable;)V

    throw v6

    .line 573
    .end local v1    # "e":Ljava/io/IOException;
    .end local v4    # "protocol":Ljava/lang/String;
    :cond_1
    iget-object v6, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->client:Lcom/squareup/okhttp/OkHttpClient;

    invoke-virtual {v6, v5}, Lcom/squareup/okhttp/OkHttpClient;->setProtocols(Ljava/util/List;)Lcom/squareup/okhttp/OkHttpClient;

    .line 574
    return-void
.end method


# virtual methods
.method public final addRequestProperty(Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "field"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 531
    iget-boolean v0, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->connected:Z

    if-eqz v0, :cond_0

    .line 532
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string/jumbo v1, "Cannot add request property after connection is made"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 534
    :cond_0
    if-nez p1, :cond_1

    .line 535
    new-instance v0, Ljava/lang/NullPointerException;

    const-string/jumbo v1, "field == null"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 537
    :cond_1
    if-nez p2, :cond_2

    .line 543
    invoke-static {}, Lcom/squareup/okhttp/internal/Platform;->get()Lcom/squareup/okhttp/internal/Platform;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "Ignoring header "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, " because its value was null."

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/squareup/okhttp/internal/Platform;->logW(Ljava/lang/String;)V

    .line 553
    :goto_0
    return-void

    .line 548
    :cond_2
    const-string/jumbo v0, "X-Android-Transports"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_3

    const-string/jumbo v0, "X-Android-Protocols"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 549
    :cond_3
    const/4 v0, 0x1

    invoke-direct {p0, p2, v0}, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->setProtocols(Ljava/lang/String;Z)V

    goto :goto_0

    .line 551
    :cond_4
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->requestHeaders:Lcom/squareup/okhttp/internal/http/Headers$Builder;

    invoke-virtual {v0, p1, p2}, Lcom/squareup/okhttp/internal/http/Headers$Builder;->add(Ljava/lang/String;Ljava/lang/String;)Lcom/squareup/okhttp/internal/http/Headers$Builder;

    goto :goto_0
.end method

.method public final connect()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 100
    invoke-direct {p0}, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->initHttpEngine()V

    .line 103
    :cond_0
    const/4 v1, 0x0

    invoke-direct {p0, v1}, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->execute(Z)Z

    move-result v0

    .line 104
    .local v0, "success":Z
    if-eqz v0, :cond_0

    .line 105
    return-void
.end method

.method public final disconnect()V
    .locals 1

    .prologue
    .line 109
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->httpEngine:Lcom/squareup/okhttp/internal/http/HttpEngine;

    if-nez v0, :cond_0

    .line 121
    :goto_0
    return-void

    .line 112
    :cond_0
    :try_start_0
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->httpEngine:Lcom/squareup/okhttp/internal/http/HttpEngine;

    invoke-virtual {v0}, Lcom/squareup/okhttp/internal/http/HttpEngine;->disconnect()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 113
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method public getConnectTimeout()I
    .locals 1

    .prologue
    .line 247
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->client:Lcom/squareup/okhttp/OkHttpClient;

    invoke-virtual {v0}, Lcom/squareup/okhttp/OkHttpClient;->getConnectTimeout()I

    move-result v0

    return v0
.end method

.method public final getErrorStream()Ljava/io/InputStream;
    .locals 5

    .prologue
    const/4 v2, 0x0

    .line 129
    :try_start_0
    invoke-direct {p0}, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->getResponse()Lcom/squareup/okhttp/internal/http/HttpEngine;

    move-result-object v1

    .line 130
    .local v1, "response":Lcom/squareup/okhttp/internal/http/HttpEngine;
    invoke-virtual {v1}, Lcom/squareup/okhttp/internal/http/HttpEngine;->hasResponseBody()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-virtual {v1}, Lcom/squareup/okhttp/internal/http/HttpEngine;->getResponse()Lcom/squareup/okhttp/internal/http/Response;

    move-result-object v3

    invoke-virtual {v3}, Lcom/squareup/okhttp/internal/http/Response;->code()I

    move-result v3

    const/16 v4, 0x190

    if-lt v3, v4, :cond_0

    .line 131
    invoke-virtual {v1}, Lcom/squareup/okhttp/internal/http/HttpEngine;->getResponseBodyBytes()Ljava/io/InputStream;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    .line 135
    .end local v1    # "response":Lcom/squareup/okhttp/internal/http/HttpEngine;
    :cond_0
    :goto_0
    return-object v2

    .line 134
    :catch_0
    move-exception v0

    .line 135
    .local v0, "e":Ljava/io/IOException;
    goto :goto_0
.end method

.method public final getHeaderField(I)Ljava/lang/String;
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 145
    :try_start_0
    invoke-direct {p0}, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->getResponse()Lcom/squareup/okhttp/internal/http/HttpEngine;

    move-result-object v1

    invoke-virtual {v1}, Lcom/squareup/okhttp/internal/http/HttpEngine;->getResponse()Lcom/squareup/okhttp/internal/http/Response;

    move-result-object v1

    invoke-virtual {v1}, Lcom/squareup/okhttp/internal/http/Response;->headers()Lcom/squareup/okhttp/internal/http/Headers;

    move-result-object v1

    invoke-virtual {v1, p1}, Lcom/squareup/okhttp/internal/http/Headers;->value(I)Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 147
    :goto_0
    return-object v1

    .line 146
    :catch_0
    move-exception v0

    .line 147
    .local v0, "e":Ljava/io/IOException;
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public final getHeaderField(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "fieldName"    # Ljava/lang/String;

    .prologue
    .line 158
    :try_start_0
    invoke-direct {p0}, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->getResponse()Lcom/squareup/okhttp/internal/http/HttpEngine;

    move-result-object v2

    invoke-virtual {v2}, Lcom/squareup/okhttp/internal/http/HttpEngine;->getResponse()Lcom/squareup/okhttp/internal/http/Response;

    move-result-object v1

    .line 159
    .local v1, "response":Lcom/squareup/okhttp/internal/http/Response;
    if-nez p1, :cond_0

    invoke-virtual {v1}, Lcom/squareup/okhttp/internal/http/Response;->statusLine()Ljava/lang/String;

    move-result-object v2

    .line 161
    .end local v1    # "response":Lcom/squareup/okhttp/internal/http/Response;
    :goto_0
    return-object v2

    .line 159
    .restart local v1    # "response":Lcom/squareup/okhttp/internal/http/Response;
    :cond_0
    invoke-virtual {v1}, Lcom/squareup/okhttp/internal/http/Response;->headers()Lcom/squareup/okhttp/internal/http/Headers;

    move-result-object v2

    invoke-virtual {v2, p1}, Lcom/squareup/okhttp/internal/http/Headers;->get(Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    goto :goto_0

    .line 160
    .end local v1    # "response":Lcom/squareup/okhttp/internal/http/Response;
    :catch_0
    move-exception v0

    .line 161
    .local v0, "e":Ljava/io/IOException;
    const/4 v2, 0x0

    goto :goto_0
.end method

.method public final getHeaderFieldKey(I)Ljava/lang/String;
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 167
    :try_start_0
    invoke-direct {p0}, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->getResponse()Lcom/squareup/okhttp/internal/http/HttpEngine;

    move-result-object v1

    invoke-virtual {v1}, Lcom/squareup/okhttp/internal/http/HttpEngine;->getResponse()Lcom/squareup/okhttp/internal/http/Response;

    move-result-object v1

    invoke-virtual {v1}, Lcom/squareup/okhttp/internal/http/Response;->headers()Lcom/squareup/okhttp/internal/http/Headers;

    move-result-object v1

    invoke-virtual {v1, p1}, Lcom/squareup/okhttp/internal/http/Headers;->name(I)Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 169
    :goto_0
    return-object v1

    .line 168
    :catch_0
    move-exception v0

    .line 169
    .local v0, "e":Ljava/io/IOException;
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public final getHeaderFields()Ljava/util/Map;
    .locals 4
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
    .line 175
    :try_start_0
    invoke-direct {p0}, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->getResponse()Lcom/squareup/okhttp/internal/http/HttpEngine;

    move-result-object v2

    invoke-virtual {v2}, Lcom/squareup/okhttp/internal/http/HttpEngine;->getResponse()Lcom/squareup/okhttp/internal/http/Response;

    move-result-object v1

    .line 176
    .local v1, "response":Lcom/squareup/okhttp/internal/http/Response;
    invoke-virtual {v1}, Lcom/squareup/okhttp/internal/http/Response;->headers()Lcom/squareup/okhttp/internal/http/Headers;

    move-result-object v2

    invoke-virtual {v1}, Lcom/squareup/okhttp/internal/http/Response;->statusLine()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/squareup/okhttp/internal/http/OkHeaders;->toMultimap(Lcom/squareup/okhttp/internal/http/Headers;Ljava/lang/String;)Ljava/util/Map;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    .line 178
    .end local v1    # "response":Lcom/squareup/okhttp/internal/http/Response;
    :goto_0
    return-object v2

    .line 177
    :catch_0
    move-exception v0

    .line 178
    .local v0, "e":Ljava/io/IOException;
    invoke-static {}, Ljava/util/Collections;->emptyMap()Ljava/util/Map;

    move-result-object v2

    goto :goto_0
.end method

.method public final getInputStream()Ljava/io/InputStream;
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 192
    iget-boolean v2, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->doInput:Z

    if-nez v2, :cond_0

    .line 193
    new-instance v2, Ljava/net/ProtocolException;

    const-string/jumbo v3, "This protocol does not support input"

    invoke-direct {v2, v3}, Ljava/net/ProtocolException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 196
    :cond_0
    invoke-direct {p0}, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->getResponse()Lcom/squareup/okhttp/internal/http/HttpEngine;

    move-result-object v0

    .line 202
    .local v0, "response":Lcom/squareup/okhttp/internal/http/HttpEngine;
    invoke-virtual {p0}, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->getResponseCode()I

    move-result v2

    const/16 v3, 0x190

    if-lt v2, v3, :cond_1

    .line 203
    new-instance v2, Ljava/io/FileNotFoundException;

    iget-object v3, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->url:Ljava/net/URL;

    invoke-virtual {v3}, Ljava/net/URL;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/io/FileNotFoundException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 206
    :cond_1
    invoke-virtual {v0}, Lcom/squareup/okhttp/internal/http/HttpEngine;->getResponseBodyBytes()Ljava/io/InputStream;

    move-result-object v1

    .line 207
    .local v1, "result":Ljava/io/InputStream;
    if-nez v1, :cond_2

    .line 208
    new-instance v2, Ljava/net/ProtocolException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "No response body exists; responseCode="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p0}, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->getResponseCode()I

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/net/ProtocolException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 210
    :cond_2
    return-object v1
.end method

.method public final getOutputStream()Ljava/io/OutputStream;
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 214
    invoke-virtual {p0}, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->connect()V

    .line 216
    iget-object v1, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->httpEngine:Lcom/squareup/okhttp/internal/http/HttpEngine;

    invoke-virtual {v1}, Lcom/squareup/okhttp/internal/http/HttpEngine;->getBufferedRequestBody()Lcom/squareup/okhttp/internal/okio/BufferedSink;

    move-result-object v0

    .line 217
    .local v0, "sink":Lcom/squareup/okhttp/internal/okio/BufferedSink;
    if-nez v0, :cond_0

    .line 218
    new-instance v1, Ljava/net/ProtocolException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "method does not support a request body: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->method:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/net/ProtocolException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 219
    :cond_0
    iget-object v1, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->httpEngine:Lcom/squareup/okhttp/internal/http/HttpEngine;

    invoke-virtual {v1}, Lcom/squareup/okhttp/internal/http/HttpEngine;->hasResponse()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 220
    new-instance v1, Ljava/net/ProtocolException;

    const-string/jumbo v2, "cannot write request body after response has been read"

    invoke-direct {v1, v2}, Ljava/net/ProtocolException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 223
    :cond_1
    invoke-interface {v0}, Lcom/squareup/okhttp/internal/okio/BufferedSink;->outputStream()Ljava/io/OutputStream;

    move-result-object v1

    return-object v1
.end method

.method public final getPermission()Ljava/security/Permission;
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 227
    invoke-virtual {p0}, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->getURL()Ljava/net/URL;

    move-result-object v3

    invoke-virtual {v3}, Ljava/net/URL;->getHost()Ljava/lang/String;

    move-result-object v0

    .line 228
    .local v0, "hostName":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->getURL()Ljava/net/URL;

    move-result-object v3

    invoke-static {v3}, Lcom/squareup/okhttp/internal/Util;->getEffectivePort(Ljava/net/URL;)I

    move-result v1

    .line 229
    .local v1, "hostPort":I
    invoke-virtual {p0}, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->usingProxy()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 230
    iget-object v3, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->client:Lcom/squareup/okhttp/OkHttpClient;

    invoke-virtual {v3}, Lcom/squareup/okhttp/OkHttpClient;->getProxy()Ljava/net/Proxy;

    move-result-object v3

    invoke-virtual {v3}, Ljava/net/Proxy;->address()Ljava/net/SocketAddress;

    move-result-object v2

    check-cast v2, Ljava/net/InetSocketAddress;

    .line 231
    .local v2, "proxyAddress":Ljava/net/InetSocketAddress;
    invoke-virtual {v2}, Ljava/net/InetSocketAddress;->getHostName()Ljava/lang/String;

    move-result-object v0

    .line 232
    invoke-virtual {v2}, Ljava/net/InetSocketAddress;->getPort()I

    move-result v1

    .line 234
    .end local v2    # "proxyAddress":Ljava/net/InetSocketAddress;
    :cond_0
    new-instance v3, Ljava/net/SocketPermission;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, ":"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    const-string/jumbo v5, "connect, resolve"

    invoke-direct {v3, v4, v5}, Ljava/net/SocketPermission;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    return-object v3
.end method

.method public getReadTimeout()I
    .locals 1

    .prologue
    .line 255
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->client:Lcom/squareup/okhttp/OkHttpClient;

    invoke-virtual {v0}, Lcom/squareup/okhttp/OkHttpClient;->getReadTimeout()I

    move-result v0

    return v0
.end method

.method public final getRequestProperties()Ljava/util/Map;
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
    .line 183
    iget-boolean v0, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->connected:Z

    if-eqz v0, :cond_0

    .line 184
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string/jumbo v1, "Cannot access request header fields after connection is set"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 188
    :cond_0
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->requestHeaders:Lcom/squareup/okhttp/internal/http/Headers$Builder;

    invoke-virtual {v0}, Lcom/squareup/okhttp/internal/http/Headers$Builder;->build()Lcom/squareup/okhttp/internal/http/Headers;

    move-result-object v0

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/squareup/okhttp/internal/http/OkHeaders;->toMultimap(Lcom/squareup/okhttp/internal/http/Headers;Ljava/lang/String;)Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method public final getRequestProperty(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "field"    # Ljava/lang/String;

    .prologue
    .line 238
    if-nez p1, :cond_0

    const/4 v0, 0x0

    .line 239
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->requestHeaders:Lcom/squareup/okhttp/internal/http/Headers$Builder;

    invoke-virtual {v0, p1}, Lcom/squareup/okhttp/internal/http/Headers$Builder;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public final getResponseCode()I
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 493
    invoke-direct {p0}, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->getResponse()Lcom/squareup/okhttp/internal/http/HttpEngine;

    move-result-object v0

    invoke-virtual {v0}, Lcom/squareup/okhttp/internal/http/HttpEngine;->getResponse()Lcom/squareup/okhttp/internal/http/Response;

    move-result-object v0

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
    .line 489
    invoke-direct {p0}, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->getResponse()Lcom/squareup/okhttp/internal/http/HttpEngine;

    move-result-object v0

    invoke-virtual {v0}, Lcom/squareup/okhttp/internal/http/HttpEngine;->getResponse()Lcom/squareup/okhttp/internal/http/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/squareup/okhttp/internal/http/Response;->statusMessage()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public setConnectTimeout(I)V
    .locals 4
    .param p1, "timeoutMillis"    # I

    .prologue
    .line 243
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->client:Lcom/squareup/okhttp/OkHttpClient;

    int-to-long v1, p1

    sget-object v3, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v0, v1, v2, v3}, Lcom/squareup/okhttp/OkHttpClient;->setConnectTimeout(JLjava/util/concurrent/TimeUnit;)V

    .line 244
    return-void
.end method

.method public setFixedLengthStreamingMode(I)V
    .locals 2
    .param p1, "contentLength"    # I

    .prologue
    .line 585
    int-to-long v0, p1

    invoke-virtual {p0, v0, v1}, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->setFixedLengthStreamingMode(J)V

    .line 586
    return-void
.end method

.method public setFixedLengthStreamingMode(J)V
    .locals 2
    .param p1, "contentLength"    # J

    .prologue
    .line 590
    iget-boolean v0, p0, Ljava/net/HttpURLConnection;->connected:Z

    if-eqz v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string/jumbo v1, "Already connected"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 591
    :cond_0
    iget v0, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->chunkLength:I

    if-lez v0, :cond_1

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string/jumbo v1, "Already in chunked mode"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 592
    :cond_1
    const-wide/16 v0, 0x0

    cmp-long v0, p1, v0

    if-gez v0, :cond_2

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "contentLength < 0"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 593
    :cond_2
    iput-wide p1, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->fixedContentLength:J

    .line 594
    const-wide/32 v0, 0x7fffffff

    invoke-static {p1, p2, v0, v1}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v0

    long-to-int v0, v0

    iput v0, p0, Ljava/net/HttpURLConnection;->fixedContentLength:I

    .line 595
    return-void
.end method

.method public setIfModifiedSince(J)V
    .locals 5
    .param p1, "newValue"    # J

    .prologue
    .line 522
    invoke-super {p0, p1, p2}, Ljava/net/HttpURLConnection;->setIfModifiedSince(J)V

    .line 523
    iget-wide v0, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->ifModifiedSince:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-eqz v0, :cond_0

    .line 524
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->requestHeaders:Lcom/squareup/okhttp/internal/http/Headers$Builder;

    const-string/jumbo v1, "If-Modified-Since"

    new-instance v2, Ljava/util/Date;

    iget-wide v3, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->ifModifiedSince:J

    invoke-direct {v2, v3, v4}, Ljava/util/Date;-><init>(J)V

    invoke-static {v2}, Lcom/squareup/okhttp/internal/http/HttpDate;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/squareup/okhttp/internal/http/Headers$Builder;->set(Ljava/lang/String;Ljava/lang/String;)Lcom/squareup/okhttp/internal/http/Headers$Builder;

    .line 528
    :goto_0
    return-void

    .line 526
    :cond_0
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->requestHeaders:Lcom/squareup/okhttp/internal/http/Headers$Builder;

    const-string/jumbo v1, "If-Modified-Since"

    invoke-virtual {v0, v1}, Lcom/squareup/okhttp/internal/http/Headers$Builder;->removeAll(Ljava/lang/String;)Lcom/squareup/okhttp/internal/http/Headers$Builder;

    goto :goto_0
.end method

.method public setReadTimeout(I)V
    .locals 4
    .param p1, "timeoutMillis"    # I

    .prologue
    .line 251
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->client:Lcom/squareup/okhttp/OkHttpClient;

    int-to-long v1, p1

    sget-object v3, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v0, v1, v2, v3}, Lcom/squareup/okhttp/OkHttpClient;->setReadTimeout(JLjava/util/concurrent/TimeUnit;)V

    .line 252
    return-void
.end method

.method public setRequestMethod(Ljava/lang/String;)V
    .locals 3
    .param p1, "method"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/net/ProtocolException;
        }
    .end annotation

    .prologue
    .line 577
    sget-object v0, Lcom/squareup/okhttp/internal/http/HttpMethod;->METHODS:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 578
    new-instance v0, Ljava/net/ProtocolException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "Expected one of "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v2, Lcom/squareup/okhttp/internal/http/HttpMethod;->METHODS:Ljava/util/Set;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, " but was "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/net/ProtocolException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 581
    :cond_0
    iput-object p1, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->method:Ljava/lang/String;

    .line 582
    return-void
.end method

.method public final setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "field"    # Ljava/lang/String;
    .param p2, "newValue"    # Ljava/lang/String;

    .prologue
    .line 497
    iget-boolean v0, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->connected:Z

    if-eqz v0, :cond_0

    .line 498
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string/jumbo v1, "Cannot set request property after connection is made"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 500
    :cond_0
    if-nez p1, :cond_1

    .line 501
    new-instance v0, Ljava/lang/NullPointerException;

    const-string/jumbo v1, "field == null"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 503
    :cond_1
    if-nez p2, :cond_2

    .line 509
    invoke-static {}, Lcom/squareup/okhttp/internal/Platform;->get()Lcom/squareup/okhttp/internal/Platform;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "Ignoring header "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, " because its value was null."

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/squareup/okhttp/internal/Platform;->logW(Ljava/lang/String;)V

    .line 519
    :goto_0
    return-void

    .line 514
    :cond_2
    const-string/jumbo v0, "X-Android-Transports"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_3

    const-string/jumbo v0, "X-Android-Protocols"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 515
    :cond_3
    const/4 v0, 0x0

    invoke-direct {p0, p2, v0}, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->setProtocols(Ljava/lang/String;Z)V

    goto :goto_0

    .line 517
    :cond_4
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->requestHeaders:Lcom/squareup/okhttp/internal/http/Headers$Builder;

    invoke-virtual {v0, p1, p2}, Lcom/squareup/okhttp/internal/http/Headers$Builder;->set(Ljava/lang/String;Ljava/lang/String;)Lcom/squareup/okhttp/internal/http/Headers$Builder;

    goto :goto_0
.end method

.method public final usingProxy()Z
    .locals 3

    .prologue
    .line 482
    iget-object v1, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->route:Lcom/squareup/okhttp/Route;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->route:Lcom/squareup/okhttp/Route;

    invoke-virtual {v1}, Lcom/squareup/okhttp/Route;->getProxy()Ljava/net/Proxy;

    move-result-object v0

    .line 485
    .local v0, "proxy":Ljava/net/Proxy;
    :goto_0
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Ljava/net/Proxy;->type()Ljava/net/Proxy$Type;

    move-result-object v1

    sget-object v2, Ljava/net/Proxy$Type;->DIRECT:Ljava/net/Proxy$Type;

    if-eq v1, v2, :cond_1

    const/4 v1, 0x1

    :goto_1
    return v1

    .line 482
    .end local v0    # "proxy":Ljava/net/Proxy;
    :cond_0
    iget-object v1, p0, Lcom/squareup/okhttp/internal/http/HttpURLConnectionImpl;->client:Lcom/squareup/okhttp/OkHttpClient;

    invoke-virtual {v1}, Lcom/squareup/okhttp/OkHttpClient;->getProxy()Ljava/net/Proxy;

    move-result-object v0

    goto :goto_0

    .line 485
    .restart local v0    # "proxy":Ljava/net/Proxy;
    :cond_1
    const/4 v1, 0x0

    goto :goto_1
.end method
