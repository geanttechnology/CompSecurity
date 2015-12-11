.class public Lcom/comcast/cim/httpcomponentsandroid/impl/entity/EntityDeserializer;
.super Ljava/lang/Object;
.source "EntityDeserializer.java"


# instance fields
.field private final lenStrategy:Lcom/comcast/cim/httpcomponentsandroid/entity/ContentLengthStrategy;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/entity/ContentLengthStrategy;)V
    .locals 2
    .param p1, "lenStrategy"    # Lcom/comcast/cim/httpcomponentsandroid/entity/ContentLengthStrategy;

    .prologue
    .line 65
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 66
    if-nez p1, :cond_0

    .line 67
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Content length strategy may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 69
    :cond_0
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/entity/EntityDeserializer;->lenStrategy:Lcom/comcast/cim/httpcomponentsandroid/entity/ContentLengthStrategy;

    .line 70
    return-void
.end method


# virtual methods
.method public deserialize(Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;Lcom/comcast/cim/httpcomponentsandroid/HttpMessage;)Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;
    .locals 2
    .param p1, "inbuffer"    # Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;
    .param p2, "message"    # Lcom/comcast/cim/httpcomponentsandroid/HttpMessage;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/HttpException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 135
    if-nez p1, :cond_0

    .line 136
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Session input buffer may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 138
    :cond_0
    if-nez p2, :cond_1

    .line 139
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "HTTP message may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 141
    :cond_1
    invoke-virtual {p0, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/entity/EntityDeserializer;->doDeserialize(Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;Lcom/comcast/cim/httpcomponentsandroid/HttpMessage;)Lcom/comcast/cim/httpcomponentsandroid/entity/BasicHttpEntity;

    move-result-object v0

    return-object v0
.end method

.method protected doDeserialize(Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;Lcom/comcast/cim/httpcomponentsandroid/HttpMessage;)Lcom/comcast/cim/httpcomponentsandroid/entity/BasicHttpEntity;
    .locals 11
    .param p1, "inbuffer"    # Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;
    .param p2, "message"    # Lcom/comcast/cim/httpcomponentsandroid/HttpMessage;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/HttpException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v10, 0x0

    const-wide/16 v8, -0x1

    .line 90
    new-instance v2, Lcom/comcast/cim/httpcomponentsandroid/entity/BasicHttpEntity;

    invoke-direct {v2}, Lcom/comcast/cim/httpcomponentsandroid/entity/BasicHttpEntity;-><init>()V

    .line 92
    .local v2, "entity":Lcom/comcast/cim/httpcomponentsandroid/entity/BasicHttpEntity;
    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/entity/EntityDeserializer;->lenStrategy:Lcom/comcast/cim/httpcomponentsandroid/entity/ContentLengthStrategy;

    invoke-interface {v3, p2}, Lcom/comcast/cim/httpcomponentsandroid/entity/ContentLengthStrategy;->determineLength(Lcom/comcast/cim/httpcomponentsandroid/HttpMessage;)J

    move-result-wide v4

    .line 93
    .local v4, "len":J
    const-wide/16 v6, -0x2

    cmp-long v3, v4, v6

    if-nez v3, :cond_2

    .line 94
    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Lcom/comcast/cim/httpcomponentsandroid/entity/BasicHttpEntity;->setChunked(Z)V

    .line 95
    invoke-virtual {v2, v8, v9}, Lcom/comcast/cim/httpcomponentsandroid/entity/BasicHttpEntity;->setContentLength(J)V

    .line 96
    new-instance v3, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;

    invoke-direct {v3, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;-><init>(Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;)V

    invoke-virtual {v2, v3}, Lcom/comcast/cim/httpcomponentsandroid/entity/BasicHttpEntity;->setContent(Ljava/io/InputStream;)V

    .line 107
    :goto_0
    const-string v3, "Content-Type"

    invoke-interface {p2, v3}, Lcom/comcast/cim/httpcomponentsandroid/HttpMessage;->getFirstHeader(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v1

    .line 108
    .local v1, "contentTypeHeader":Lcom/comcast/cim/httpcomponentsandroid/Header;
    if-eqz v1, :cond_0

    .line 109
    invoke-virtual {v2, v1}, Lcom/comcast/cim/httpcomponentsandroid/entity/BasicHttpEntity;->setContentType(Lcom/comcast/cim/httpcomponentsandroid/Header;)V

    .line 111
    :cond_0
    const-string v3, "Content-Encoding"

    invoke-interface {p2, v3}, Lcom/comcast/cim/httpcomponentsandroid/HttpMessage;->getFirstHeader(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v0

    .line 112
    .local v0, "contentEncodingHeader":Lcom/comcast/cim/httpcomponentsandroid/Header;
    if-eqz v0, :cond_1

    .line 113
    invoke-virtual {v2, v0}, Lcom/comcast/cim/httpcomponentsandroid/entity/BasicHttpEntity;->setContentEncoding(Lcom/comcast/cim/httpcomponentsandroid/Header;)V

    .line 115
    :cond_1
    return-object v2

    .line 97
    .end local v0    # "contentEncodingHeader":Lcom/comcast/cim/httpcomponentsandroid/Header;
    .end local v1    # "contentTypeHeader":Lcom/comcast/cim/httpcomponentsandroid/Header;
    :cond_2
    cmp-long v3, v4, v8

    if-nez v3, :cond_3

    .line 98
    invoke-virtual {v2, v10}, Lcom/comcast/cim/httpcomponentsandroid/entity/BasicHttpEntity;->setChunked(Z)V

    .line 99
    invoke-virtual {v2, v8, v9}, Lcom/comcast/cim/httpcomponentsandroid/entity/BasicHttpEntity;->setContentLength(J)V

    .line 100
    new-instance v3, Lcom/comcast/cim/httpcomponentsandroid/impl/io/IdentityInputStream;

    invoke-direct {v3, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/io/IdentityInputStream;-><init>(Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;)V

    invoke-virtual {v2, v3}, Lcom/comcast/cim/httpcomponentsandroid/entity/BasicHttpEntity;->setContent(Ljava/io/InputStream;)V

    goto :goto_0

    .line 102
    :cond_3
    invoke-virtual {v2, v10}, Lcom/comcast/cim/httpcomponentsandroid/entity/BasicHttpEntity;->setChunked(Z)V

    .line 103
    invoke-virtual {v2, v4, v5}, Lcom/comcast/cim/httpcomponentsandroid/entity/BasicHttpEntity;->setContentLength(J)V

    .line 104
    new-instance v3, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ContentLengthInputStream;

    invoke-direct {v3, p1, v4, v5}, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ContentLengthInputStream;-><init>(Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;J)V

    invoke-virtual {v2, v3}, Lcom/comcast/cim/httpcomponentsandroid/entity/BasicHttpEntity;->setContent(Ljava/io/InputStream;)V

    goto :goto_0
.end method
