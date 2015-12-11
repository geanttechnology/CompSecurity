.class Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/SizeLimitedResponseReader;
.super Ljava/lang/Object;
.source "SizeLimitedResponseReader.java"


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/NotThreadSafe;
.end annotation


# instance fields
.field private consumed:Z

.field private instream:Ljava/io/InputStream;

.field private limit:Lcom/comcast/cim/httpcomponentsandroid/client/cache/InputLimit;

.field private final maxResponseSizeBytes:J

.field private final request:Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;

.field private resource:Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;

.field private final resourceFactory:Lcom/comcast/cim/httpcomponentsandroid/client/cache/ResourceFactory;

.field private final response:Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/client/cache/ResourceFactory;JLcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)V
    .locals 0
    .param p1, "resourceFactory"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/ResourceFactory;
    .param p2, "maxResponseSizeBytes"    # J
    .param p4, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p5, "response"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    .prologue
    .line 66
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 67
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/SizeLimitedResponseReader;->resourceFactory:Lcom/comcast/cim/httpcomponentsandroid/client/cache/ResourceFactory;

    .line 68
    iput-wide p2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/SizeLimitedResponseReader;->maxResponseSizeBytes:J

    .line 69
    iput-object p4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/SizeLimitedResponseReader;->request:Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;

    .line 70
    iput-object p5, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/SizeLimitedResponseReader;->response:Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    .line 71
    return-void
.end method

.method private doConsume()V
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 92
    invoke-direct {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/SizeLimitedResponseReader;->ensureNotConsumed()V

    .line 93
    const/4 v2, 0x1

    iput-boolean v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/SizeLimitedResponseReader;->consumed:Z

    .line 95
    new-instance v2, Lcom/comcast/cim/httpcomponentsandroid/client/cache/InputLimit;

    iget-wide v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/SizeLimitedResponseReader;->maxResponseSizeBytes:J

    invoke-direct {v2, v4, v5}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/InputLimit;-><init>(J)V

    iput-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/SizeLimitedResponseReader;->limit:Lcom/comcast/cim/httpcomponentsandroid/client/cache/InputLimit;

    .line 97
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/SizeLimitedResponseReader;->response:Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    invoke-interface {v2}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getEntity()Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    move-result-object v0

    .line 98
    .local v0, "entity":Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;
    if-nez v0, :cond_0

    .line 104
    :goto_0
    return-void

    .line 101
    :cond_0
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/SizeLimitedResponseReader;->request:Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;

    invoke-interface {v2}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getRequestLine()Lcom/comcast/cim/httpcomponentsandroid/RequestLine;

    move-result-object v2

    invoke-interface {v2}, Lcom/comcast/cim/httpcomponentsandroid/RequestLine;->getUri()Ljava/lang/String;

    move-result-object v1

    .line 102
    .local v1, "uri":Ljava/lang/String;
    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;->getContent()Ljava/io/InputStream;

    move-result-object v2

    iput-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/SizeLimitedResponseReader;->instream:Ljava/io/InputStream;

    .line 103
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/SizeLimitedResponseReader;->resourceFactory:Lcom/comcast/cim/httpcomponentsandroid/client/cache/ResourceFactory;

    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/SizeLimitedResponseReader;->instream:Ljava/io/InputStream;

    iget-object v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/SizeLimitedResponseReader;->limit:Lcom/comcast/cim/httpcomponentsandroid/client/cache/InputLimit;

    invoke-interface {v2, v1, v3, v4}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/ResourceFactory;->generate(Ljava/lang/String;Ljava/io/InputStream;Lcom/comcast/cim/httpcomponentsandroid/client/cache/InputLimit;)Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;

    move-result-object v2

    iput-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/SizeLimitedResponseReader;->resource:Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;

    goto :goto_0
.end method

.method private ensureConsumed()V
    .locals 2

    .prologue
    .line 86
    iget-boolean v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/SizeLimitedResponseReader;->consumed:Z

    if-nez v0, :cond_0

    .line 87
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Response has not been consumed"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 89
    :cond_0
    return-void
.end method

.method private ensureNotConsumed()V
    .locals 2

    .prologue
    .line 80
    iget-boolean v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/SizeLimitedResponseReader;->consumed:Z

    if-eqz v0, :cond_0

    .line 81
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Response has already been consumed"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 83
    :cond_0
    return-void
.end method


# virtual methods
.method getReconstructedResponse()Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 117
    invoke-direct {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/SizeLimitedResponseReader;->ensureConsumed()V

    .line 118
    new-instance v2, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpResponse;

    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/SizeLimitedResponseReader;->response:Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    invoke-interface {v3}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getStatusLine()Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

    move-result-object v3

    invoke-direct {v2, v3}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpResponse;-><init>(Lcom/comcast/cim/httpcomponentsandroid/StatusLine;)V

    .line 119
    .local v2, "reconstructed":Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/SizeLimitedResponseReader;->response:Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    invoke-interface {v3}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getAllHeaders()[Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v3

    invoke-interface {v2, v3}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->setHeaders([Lcom/comcast/cim/httpcomponentsandroid/Header;)V

    .line 121
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CombinedEntity;

    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/SizeLimitedResponseReader;->resource:Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;

    iget-object v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/SizeLimitedResponseReader;->instream:Ljava/io/InputStream;

    invoke-direct {v0, v3, v4}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CombinedEntity;-><init>(Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;Ljava/io/InputStream;)V

    .line 122
    .local v0, "combinedEntity":Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CombinedEntity;
    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/SizeLimitedResponseReader;->response:Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    invoke-interface {v3}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getEntity()Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    move-result-object v1

    .line 123
    .local v1, "entity":Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;
    if-eqz v1, :cond_0

    .line 124
    invoke-interface {v1}, Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;->getContentType()Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CombinedEntity;->setContentType(Lcom/comcast/cim/httpcomponentsandroid/Header;)V

    .line 125
    invoke-interface {v1}, Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;->getContentEncoding()Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CombinedEntity;->setContentEncoding(Lcom/comcast/cim/httpcomponentsandroid/Header;)V

    .line 126
    invoke-interface {v1}, Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;->isChunked()Z

    move-result v3

    invoke-virtual {v0, v3}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CombinedEntity;->setChunked(Z)V

    .line 128
    :cond_0
    invoke-interface {v2, v0}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->setEntity(Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;)V

    .line 129
    return-object v2
.end method

.method getResource()Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;
    .locals 1

    .prologue
    .line 112
    invoke-direct {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/SizeLimitedResponseReader;->ensureConsumed()V

    .line 113
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/SizeLimitedResponseReader;->resource:Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;

    return-object v0
.end method

.method isLimitReached()Z
    .locals 1

    .prologue
    .line 107
    invoke-direct {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/SizeLimitedResponseReader;->ensureConsumed()V

    .line 108
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/SizeLimitedResponseReader;->limit:Lcom/comcast/cim/httpcomponentsandroid/client/cache/InputLimit;

    invoke-virtual {v0}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/InputLimit;->isReached()Z

    move-result v0

    return v0
.end method

.method protected readResponse()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 74
    iget-boolean v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/SizeLimitedResponseReader;->consumed:Z

    if-nez v0, :cond_0

    .line 75
    invoke-direct {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/SizeLimitedResponseReader;->doConsume()V

    .line 77
    :cond_0
    return-void
.end method
