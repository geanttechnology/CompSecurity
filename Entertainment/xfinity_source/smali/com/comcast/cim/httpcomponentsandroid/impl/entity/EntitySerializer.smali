.class public Lcom/comcast/cim/httpcomponentsandroid/impl/entity/EntitySerializer;
.super Ljava/lang/Object;
.source "EntitySerializer.java"


# instance fields
.field private final lenStrategy:Lcom/comcast/cim/httpcomponentsandroid/entity/ContentLengthStrategy;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/entity/ContentLengthStrategy;)V
    .locals 2
    .param p1, "lenStrategy"    # Lcom/comcast/cim/httpcomponentsandroid/entity/ContentLengthStrategy;

    .prologue
    .line 62
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 63
    if-nez p1, :cond_0

    .line 64
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Content length strategy may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 66
    :cond_0
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/entity/EntitySerializer;->lenStrategy:Lcom/comcast/cim/httpcomponentsandroid/entity/ContentLengthStrategy;

    .line 67
    return-void
.end method


# virtual methods
.method protected doSerialize(Lcom/comcast/cim/httpcomponentsandroid/io/SessionOutputBuffer;Lcom/comcast/cim/httpcomponentsandroid/HttpMessage;)Ljava/io/OutputStream;
    .locals 4
    .param p1, "outbuffer"    # Lcom/comcast/cim/httpcomponentsandroid/io/SessionOutputBuffer;
    .param p2, "message"    # Lcom/comcast/cim/httpcomponentsandroid/HttpMessage;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/HttpException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 86
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/entity/EntitySerializer;->lenStrategy:Lcom/comcast/cim/httpcomponentsandroid/entity/ContentLengthStrategy;

    invoke-interface {v2, p2}, Lcom/comcast/cim/httpcomponentsandroid/entity/ContentLengthStrategy;->determineLength(Lcom/comcast/cim/httpcomponentsandroid/HttpMessage;)J

    move-result-wide v0

    .line 87
    .local v0, "len":J
    const-wide/16 v2, -0x2

    cmp-long v2, v0, v2

    if-nez v2, :cond_0

    .line 88
    new-instance v2, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedOutputStream;

    invoke-direct {v2, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedOutputStream;-><init>(Lcom/comcast/cim/httpcomponentsandroid/io/SessionOutputBuffer;)V

    .line 92
    :goto_0
    return-object v2

    .line 89
    :cond_0
    const-wide/16 v2, -0x1

    cmp-long v2, v0, v2

    if-nez v2, :cond_1

    .line 90
    new-instance v2, Lcom/comcast/cim/httpcomponentsandroid/impl/io/IdentityOutputStream;

    invoke-direct {v2, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/io/IdentityOutputStream;-><init>(Lcom/comcast/cim/httpcomponentsandroid/io/SessionOutputBuffer;)V

    goto :goto_0

    .line 92
    :cond_1
    new-instance v2, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ContentLengthOutputStream;

    invoke-direct {v2, p1, v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ContentLengthOutputStream;-><init>(Lcom/comcast/cim/httpcomponentsandroid/io/SessionOutputBuffer;J)V

    goto :goto_0
.end method

.method public serialize(Lcom/comcast/cim/httpcomponentsandroid/io/SessionOutputBuffer;Lcom/comcast/cim/httpcomponentsandroid/HttpMessage;Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;)V
    .locals 3
    .param p1, "outbuffer"    # Lcom/comcast/cim/httpcomponentsandroid/io/SessionOutputBuffer;
    .param p2, "message"    # Lcom/comcast/cim/httpcomponentsandroid/HttpMessage;
    .param p3, "entity"    # Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/HttpException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 110
    if-nez p1, :cond_0

    .line 111
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "Session output buffer may not be null"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 113
    :cond_0
    if-nez p2, :cond_1

    .line 114
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "HTTP message may not be null"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 116
    :cond_1
    if-nez p3, :cond_2

    .line 117
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "HTTP entity may not be null"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 119
    :cond_2
    invoke-virtual {p0, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/entity/EntitySerializer;->doSerialize(Lcom/comcast/cim/httpcomponentsandroid/io/SessionOutputBuffer;Lcom/comcast/cim/httpcomponentsandroid/HttpMessage;)Ljava/io/OutputStream;

    move-result-object v0

    .line 120
    .local v0, "outstream":Ljava/io/OutputStream;
    invoke-interface {p3, v0}, Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;->writeTo(Ljava/io/OutputStream;)V

    .line 121
    invoke-virtual {v0}, Ljava/io/OutputStream;->close()V

    .line 122
    return-void
.end method
