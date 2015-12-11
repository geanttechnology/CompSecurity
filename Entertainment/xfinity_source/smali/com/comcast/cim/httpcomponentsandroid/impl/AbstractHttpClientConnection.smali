.class public abstract Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpClientConnection;
.super Ljava/lang/Object;
.source "AbstractHttpClientConnection.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/HttpClientConnection;


# instance fields
.field private final entitydeserializer:Lcom/comcast/cim/httpcomponentsandroid/impl/entity/EntityDeserializer;

.field private final entityserializer:Lcom/comcast/cim/httpcomponentsandroid/impl/entity/EntitySerializer;

.field private eofSensor:Lcom/comcast/cim/httpcomponentsandroid/io/EofSensor;

.field private inbuffer:Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;

.field private metrics:Lcom/comcast/cim/httpcomponentsandroid/impl/HttpConnectionMetricsImpl;

.field private outbuffer:Lcom/comcast/cim/httpcomponentsandroid/io/SessionOutputBuffer;

.field private requestWriter:Lcom/comcast/cim/httpcomponentsandroid/io/HttpMessageWriter;

.field private responseParser:Lcom/comcast/cim/httpcomponentsandroid/io/HttpMessageParser;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 93
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 77
    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpClientConnection;->inbuffer:Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;

    .line 78
    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpClientConnection;->outbuffer:Lcom/comcast/cim/httpcomponentsandroid/io/SessionOutputBuffer;

    .line 79
    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpClientConnection;->eofSensor:Lcom/comcast/cim/httpcomponentsandroid/io/EofSensor;

    .line 80
    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpClientConnection;->responseParser:Lcom/comcast/cim/httpcomponentsandroid/io/HttpMessageParser;

    .line 81
    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpClientConnection;->requestWriter:Lcom/comcast/cim/httpcomponentsandroid/io/HttpMessageWriter;

    .line 82
    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpClientConnection;->metrics:Lcom/comcast/cim/httpcomponentsandroid/impl/HttpConnectionMetricsImpl;

    .line 94
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpClientConnection;->createEntitySerializer()Lcom/comcast/cim/httpcomponentsandroid/impl/entity/EntitySerializer;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpClientConnection;->entityserializer:Lcom/comcast/cim/httpcomponentsandroid/impl/entity/EntitySerializer;

    .line 95
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpClientConnection;->createEntityDeserializer()Lcom/comcast/cim/httpcomponentsandroid/impl/entity/EntityDeserializer;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpClientConnection;->entitydeserializer:Lcom/comcast/cim/httpcomponentsandroid/impl/entity/EntityDeserializer;

    .line 96
    return-void
.end method


# virtual methods
.method protected abstract assertOpen()V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation
.end method

.method protected createConnectionMetrics(Lcom/comcast/cim/httpcomponentsandroid/io/HttpTransportMetrics;Lcom/comcast/cim/httpcomponentsandroid/io/HttpTransportMetrics;)Lcom/comcast/cim/httpcomponentsandroid/impl/HttpConnectionMetricsImpl;
    .locals 1
    .param p1, "inTransportMetric"    # Lcom/comcast/cim/httpcomponentsandroid/io/HttpTransportMetrics;
    .param p2, "outTransportMetric"    # Lcom/comcast/cim/httpcomponentsandroid/io/HttpTransportMetrics;

    .prologue
    .line 195
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/HttpConnectionMetricsImpl;

    invoke-direct {v0, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/HttpConnectionMetricsImpl;-><init>(Lcom/comcast/cim/httpcomponentsandroid/io/HttpTransportMetrics;Lcom/comcast/cim/httpcomponentsandroid/io/HttpTransportMetrics;)V

    return-object v0
.end method

.method protected createEntityDeserializer()Lcom/comcast/cim/httpcomponentsandroid/impl/entity/EntityDeserializer;
    .locals 2

    .prologue
    .line 117
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/entity/EntityDeserializer;

    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/impl/entity/LaxContentLengthStrategy;

    invoke-direct {v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/entity/LaxContentLengthStrategy;-><init>()V

    invoke-direct {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/entity/EntityDeserializer;-><init>(Lcom/comcast/cim/httpcomponentsandroid/entity/ContentLengthStrategy;)V

    return-object v0
.end method

.method protected createEntitySerializer()Lcom/comcast/cim/httpcomponentsandroid/impl/entity/EntitySerializer;
    .locals 2

    .prologue
    .line 132
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/entity/EntitySerializer;

    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/impl/entity/StrictContentLengthStrategy;

    invoke-direct {v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/entity/StrictContentLengthStrategy;-><init>()V

    invoke-direct {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/entity/EntitySerializer;-><init>(Lcom/comcast/cim/httpcomponentsandroid/entity/ContentLengthStrategy;)V

    return-object v0
.end method

.method protected createHttpResponseFactory()Lcom/comcast/cim/httpcomponentsandroid/HttpResponseFactory;
    .locals 1

    .prologue
    .line 146
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/DefaultHttpResponseFactory;

    invoke-direct {v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/DefaultHttpResponseFactory;-><init>()V

    return-object v0
.end method

.method protected createRequestWriter(Lcom/comcast/cim/httpcomponentsandroid/io/SessionOutputBuffer;Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)Lcom/comcast/cim/httpcomponentsandroid/io/HttpMessageWriter;
    .locals 2
    .param p1, "buffer"    # Lcom/comcast/cim/httpcomponentsandroid/io/SessionOutputBuffer;
    .param p2, "params"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .prologue
    .line 186
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/HttpRequestWriter;

    const/4 v1, 0x0

    invoke-direct {v0, p1, v1, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/io/HttpRequestWriter;-><init>(Lcom/comcast/cim/httpcomponentsandroid/io/SessionOutputBuffer;Lcom/comcast/cim/httpcomponentsandroid/message/LineFormatter;Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V

    return-object v0
.end method

.method protected createResponseParser(Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;Lcom/comcast/cim/httpcomponentsandroid/HttpResponseFactory;Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)Lcom/comcast/cim/httpcomponentsandroid/io/HttpMessageParser;
    .locals 2
    .param p1, "buffer"    # Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;
    .param p2, "responseFactory"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponseFactory;
    .param p3, "params"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .prologue
    .line 167
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/HttpResponseParser;

    const/4 v1, 0x0

    invoke-direct {v0, p1, v1, p2, p3}, Lcom/comcast/cim/httpcomponentsandroid/impl/io/HttpResponseParser;-><init>(Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;Lcom/comcast/cim/httpcomponentsandroid/message/LineParser;Lcom/comcast/cim/httpcomponentsandroid/HttpResponseFactory;Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V

    return-object v0
.end method

.method protected doFlush()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 271
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpClientConnection;->outbuffer:Lcom/comcast/cim/httpcomponentsandroid/io/SessionOutputBuffer;

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/io/SessionOutputBuffer;->flush()V

    .line 272
    return-void
.end method

.method public flush()V
    .locals 0
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 275
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpClientConnection;->assertOpen()V

    .line 276
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpClientConnection;->doFlush()V

    .line 277
    return-void
.end method

.method public getMetrics()Lcom/comcast/cim/httpcomponentsandroid/HttpConnectionMetrics;
    .locals 1

    .prologue
    .line 319
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpClientConnection;->metrics:Lcom/comcast/cim/httpcomponentsandroid/impl/HttpConnectionMetricsImpl;

    return-object v0
.end method

.method protected init(Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;Lcom/comcast/cim/httpcomponentsandroid/io/SessionOutputBuffer;Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V
    .locals 2
    .param p1, "inbuffer"    # Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;
    .param p2, "outbuffer"    # Lcom/comcast/cim/httpcomponentsandroid/io/SessionOutputBuffer;
    .param p3, "params"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .prologue
    .line 218
    if-nez p1, :cond_0

    .line 219
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Input session buffer may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 221
    :cond_0
    if-nez p2, :cond_1

    .line 222
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Output session buffer may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 224
    :cond_1
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpClientConnection;->inbuffer:Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;

    .line 225
    iput-object p2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpClientConnection;->outbuffer:Lcom/comcast/cim/httpcomponentsandroid/io/SessionOutputBuffer;

    .line 226
    instance-of v0, p1, Lcom/comcast/cim/httpcomponentsandroid/io/EofSensor;

    if-eqz v0, :cond_2

    move-object v0, p1

    .line 227
    check-cast v0, Lcom/comcast/cim/httpcomponentsandroid/io/EofSensor;

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpClientConnection;->eofSensor:Lcom/comcast/cim/httpcomponentsandroid/io/EofSensor;

    .line 229
    :cond_2
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpClientConnection;->createHttpResponseFactory()Lcom/comcast/cim/httpcomponentsandroid/HttpResponseFactory;

    move-result-object v0

    invoke-virtual {p0, p1, v0, p3}, Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpClientConnection;->createResponseParser(Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;Lcom/comcast/cim/httpcomponentsandroid/HttpResponseFactory;Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)Lcom/comcast/cim/httpcomponentsandroid/io/HttpMessageParser;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpClientConnection;->responseParser:Lcom/comcast/cim/httpcomponentsandroid/io/HttpMessageParser;

    .line 233
    invoke-virtual {p0, p2, p3}, Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpClientConnection;->createRequestWriter(Lcom/comcast/cim/httpcomponentsandroid/io/SessionOutputBuffer;Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)Lcom/comcast/cim/httpcomponentsandroid/io/HttpMessageWriter;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpClientConnection;->requestWriter:Lcom/comcast/cim/httpcomponentsandroid/io/HttpMessageWriter;

    .line 235
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;->getMetrics()Lcom/comcast/cim/httpcomponentsandroid/io/HttpTransportMetrics;

    move-result-object v0

    invoke-interface {p2}, Lcom/comcast/cim/httpcomponentsandroid/io/SessionOutputBuffer;->getMetrics()Lcom/comcast/cim/httpcomponentsandroid/io/HttpTransportMetrics;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpClientConnection;->createConnectionMetrics(Lcom/comcast/cim/httpcomponentsandroid/io/HttpTransportMetrics;Lcom/comcast/cim/httpcomponentsandroid/io/HttpTransportMetrics;)Lcom/comcast/cim/httpcomponentsandroid/impl/HttpConnectionMetricsImpl;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpClientConnection;->metrics:Lcom/comcast/cim/httpcomponentsandroid/impl/HttpConnectionMetricsImpl;

    .line 238
    return-void
.end method

.method protected isEof()Z
    .locals 1

    .prologue
    .line 300
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpClientConnection;->eofSensor:Lcom/comcast/cim/httpcomponentsandroid/io/EofSensor;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpClientConnection;->eofSensor:Lcom/comcast/cim/httpcomponentsandroid/io/EofSensor;

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/io/EofSensor;->isEof()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isResponseAvailable(I)Z
    .locals 1
    .param p1, "timeout"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 241
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpClientConnection;->assertOpen()V

    .line 242
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpClientConnection;->inbuffer:Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;

    invoke-interface {v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;->isDataAvailable(I)Z

    move-result v0

    return v0
.end method

.method public isStale()Z
    .locals 4

    .prologue
    const/4 v1, 0x1

    .line 304
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpClientConnection;->isOpen()Z

    move-result v2

    if-nez v2, :cond_1

    .line 314
    :cond_0
    :goto_0
    return v1

    .line 307
    :cond_1
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpClientConnection;->isEof()Z

    move-result v2

    if-nez v2, :cond_0

    .line 311
    :try_start_0
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpClientConnection;->inbuffer:Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;

    const/4 v3, 0x1

    invoke-interface {v2, v3}, Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;->isDataAvailable(I)Z

    .line 312
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpClientConnection;->isEof()Z
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v1

    goto :goto_0

    .line 313
    :catch_0
    move-exception v0

    .line 314
    .local v0, "ex":Ljava/io/IOException;
    goto :goto_0
.end method

.method public receiveResponseEntity(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)V
    .locals 3
    .param p1, "response"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/HttpException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 291
    if-nez p1, :cond_0

    .line 292
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "HTTP response may not be null"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 294
    :cond_0
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpClientConnection;->assertOpen()V

    .line 295
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpClientConnection;->entitydeserializer:Lcom/comcast/cim/httpcomponentsandroid/impl/entity/EntityDeserializer;

    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpClientConnection;->inbuffer:Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;

    invoke-virtual {v1, v2, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/entity/EntityDeserializer;->deserialize(Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;Lcom/comcast/cim/httpcomponentsandroid/HttpMessage;)Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    move-result-object v0

    .line 296
    .local v0, "entity":Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;
    invoke-interface {p1, v0}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->setEntity(Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;)V

    .line 297
    return-void
.end method

.method public receiveResponseHeader()Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/HttpException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 281
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpClientConnection;->assertOpen()V

    .line 282
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpClientConnection;->responseParser:Lcom/comcast/cim/httpcomponentsandroid/io/HttpMessageParser;

    invoke-interface {v1}, Lcom/comcast/cim/httpcomponentsandroid/io/HttpMessageParser;->parse()Lcom/comcast/cim/httpcomponentsandroid/HttpMessage;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    .line 283
    .local v0, "response":Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getStatusLine()Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

    move-result-object v1

    invoke-interface {v1}, Lcom/comcast/cim/httpcomponentsandroid/StatusLine;->getStatusCode()I

    move-result v1

    const/16 v2, 0xc8

    if-lt v1, v2, :cond_0

    .line 284
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpClientConnection;->metrics:Lcom/comcast/cim/httpcomponentsandroid/impl/HttpConnectionMetricsImpl;

    invoke-virtual {v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/HttpConnectionMetricsImpl;->incrementResponseCount()V

    .line 286
    :cond_0
    return-object v0
.end method

.method public sendRequestEntity(Lcom/comcast/cim/httpcomponentsandroid/HttpEntityEnclosingRequest;)V
    .locals 3
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpEntityEnclosingRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/HttpException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 257
    if-nez p1, :cond_0

    .line 258
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "HTTP request may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 260
    :cond_0
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpClientConnection;->assertOpen()V

    .line 261
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpEntityEnclosingRequest;->getEntity()Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    move-result-object v0

    if-nez v0, :cond_1

    .line 268
    :goto_0
    return-void

    .line 264
    :cond_1
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpClientConnection;->entityserializer:Lcom/comcast/cim/httpcomponentsandroid/impl/entity/EntitySerializer;

    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpClientConnection;->outbuffer:Lcom/comcast/cim/httpcomponentsandroid/io/SessionOutputBuffer;

    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpEntityEnclosingRequest;->getEntity()Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    move-result-object v2

    invoke-virtual {v0, v1, p1, v2}, Lcom/comcast/cim/httpcomponentsandroid/impl/entity/EntitySerializer;->serialize(Lcom/comcast/cim/httpcomponentsandroid/io/SessionOutputBuffer;Lcom/comcast/cim/httpcomponentsandroid/HttpMessage;Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;)V

    goto :goto_0
.end method

.method public sendRequestHeader(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)V
    .locals 2
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/HttpException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 247
    if-nez p1, :cond_0

    .line 248
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "HTTP request may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 250
    :cond_0
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpClientConnection;->assertOpen()V

    .line 251
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpClientConnection;->requestWriter:Lcom/comcast/cim/httpcomponentsandroid/io/HttpMessageWriter;

    invoke-interface {v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/io/HttpMessageWriter;->write(Lcom/comcast/cim/httpcomponentsandroid/HttpMessage;)V

    .line 252
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpClientConnection;->metrics:Lcom/comcast/cim/httpcomponentsandroid/impl/HttpConnectionMetricsImpl;

    invoke-virtual {v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/HttpConnectionMetricsImpl;->incrementRequestCount()V

    .line 253
    return-void
.end method
