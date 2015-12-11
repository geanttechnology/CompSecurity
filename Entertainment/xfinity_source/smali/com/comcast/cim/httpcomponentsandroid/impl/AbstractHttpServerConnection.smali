.class public abstract Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpServerConnection;
.super Ljava/lang/Object;
.source "AbstractHttpServerConnection.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/HttpServerConnection;


# instance fields
.field private final entitydeserializer:Lcom/comcast/cim/httpcomponentsandroid/impl/entity/EntityDeserializer;

.field private final entityserializer:Lcom/comcast/cim/httpcomponentsandroid/impl/entity/EntitySerializer;

.field private eofSensor:Lcom/comcast/cim/httpcomponentsandroid/io/EofSensor;

.field private inbuffer:Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;

.field private metrics:Lcom/comcast/cim/httpcomponentsandroid/impl/HttpConnectionMetricsImpl;

.field private outbuffer:Lcom/comcast/cim/httpcomponentsandroid/io/SessionOutputBuffer;

.field private requestParser:Lcom/comcast/cim/httpcomponentsandroid/io/HttpMessageParser;

.field private responseWriter:Lcom/comcast/cim/httpcomponentsandroid/io/HttpMessageWriter;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 93
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 77
    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpServerConnection;->inbuffer:Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;

    .line 78
    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpServerConnection;->outbuffer:Lcom/comcast/cim/httpcomponentsandroid/io/SessionOutputBuffer;

    .line 79
    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpServerConnection;->eofSensor:Lcom/comcast/cim/httpcomponentsandroid/io/EofSensor;

    .line 80
    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpServerConnection;->requestParser:Lcom/comcast/cim/httpcomponentsandroid/io/HttpMessageParser;

    .line 81
    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpServerConnection;->responseWriter:Lcom/comcast/cim/httpcomponentsandroid/io/HttpMessageWriter;

    .line 82
    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpServerConnection;->metrics:Lcom/comcast/cim/httpcomponentsandroid/impl/HttpConnectionMetricsImpl;

    .line 94
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpServerConnection;->createEntitySerializer()Lcom/comcast/cim/httpcomponentsandroid/impl/entity/EntitySerializer;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpServerConnection;->entityserializer:Lcom/comcast/cim/httpcomponentsandroid/impl/entity/EntitySerializer;

    .line 95
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpServerConnection;->createEntityDeserializer()Lcom/comcast/cim/httpcomponentsandroid/impl/entity/EntityDeserializer;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpServerConnection;->entitydeserializer:Lcom/comcast/cim/httpcomponentsandroid/impl/entity/EntityDeserializer;

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

.method protected doFlush()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 259
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpServerConnection;->outbuffer:Lcom/comcast/cim/httpcomponentsandroid/io/SessionOutputBuffer;

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/io/SessionOutputBuffer;->flush()V

    .line 260
    return-void
.end method

.method public getMetrics()Lcom/comcast/cim/httpcomponentsandroid/HttpConnectionMetrics;
    .locals 1

    .prologue
    .line 310
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpServerConnection;->metrics:Lcom/comcast/cim/httpcomponentsandroid/impl/HttpConnectionMetricsImpl;

    return-object v0
.end method

.method protected isEof()Z
    .locals 1

    .prologue
    .line 291
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpServerConnection;->eofSensor:Lcom/comcast/cim/httpcomponentsandroid/io/EofSensor;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpServerConnection;->eofSensor:Lcom/comcast/cim/httpcomponentsandroid/io/EofSensor;

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

.method public isStale()Z
    .locals 4

    .prologue
    const/4 v1, 0x1

    .line 295
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpServerConnection;->isOpen()Z

    move-result v2

    if-nez v2, :cond_1

    .line 305
    :cond_0
    :goto_0
    return v1

    .line 298
    :cond_1
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpServerConnection;->isEof()Z

    move-result v2

    if-nez v2, :cond_0

    .line 302
    :try_start_0
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpServerConnection;->inbuffer:Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;

    const/4 v3, 0x1

    invoke-interface {v2, v3}, Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;->isDataAvailable(I)Z

    .line 303
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpServerConnection;->isEof()Z
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v1

    goto :goto_0

    .line 304
    :catch_0
    move-exception v0

    .line 305
    .local v0, "ex":Ljava/io/IOException;
    goto :goto_0
.end method
