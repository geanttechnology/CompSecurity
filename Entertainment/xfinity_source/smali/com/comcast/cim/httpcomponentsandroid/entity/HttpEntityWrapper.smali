.class public Lcom/comcast/cim/httpcomponentsandroid/entity/HttpEntityWrapper;
.super Ljava/lang/Object;
.source "HttpEntityWrapper.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;


# instance fields
.field protected wrappedEntity:Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;)V
    .locals 2
    .param p1, "wrapped"    # Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    .prologue
    .line 58
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 60
    if-nez p1, :cond_0

    .line 61
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "wrapped entity must not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 64
    :cond_0
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/entity/HttpEntityWrapper;->wrappedEntity:Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    .line 66
    return-void
.end method


# virtual methods
.method public getContent()Ljava/io/InputStream;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 91
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/entity/HttpEntityWrapper;->wrappedEntity:Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;->getContent()Ljava/io/InputStream;

    move-result-object v0

    return-object v0
.end method

.method public getContentEncoding()Lcom/comcast/cim/httpcomponentsandroid/Header;
    .locals 1

    .prologue
    .line 86
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/entity/HttpEntityWrapper;->wrappedEntity:Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;->getContentEncoding()Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v0

    return-object v0
.end method

.method public getContentLength()J
    .locals 2

    .prologue
    .line 78
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/entity/HttpEntityWrapper;->wrappedEntity:Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;->getContentLength()J

    move-result-wide v0

    return-wide v0
.end method

.method public getContentType()Lcom/comcast/cim/httpcomponentsandroid/Header;
    .locals 1

    .prologue
    .line 82
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/entity/HttpEntityWrapper;->wrappedEntity:Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;->getContentType()Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v0

    return-object v0
.end method

.method public isChunked()Z
    .locals 1

    .prologue
    .line 74
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/entity/HttpEntityWrapper;->wrappedEntity:Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;->isChunked()Z

    move-result v0

    return v0
.end method

.method public isRepeatable()Z
    .locals 1

    .prologue
    .line 70
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/entity/HttpEntityWrapper;->wrappedEntity:Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;->isRepeatable()Z

    move-result v0

    return v0
.end method

.method public isStreaming()Z
    .locals 1

    .prologue
    .line 100
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/entity/HttpEntityWrapper;->wrappedEntity:Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;->isStreaming()Z

    move-result v0

    return v0
.end method

.method public writeTo(Ljava/io/OutputStream;)V
    .locals 1
    .param p1, "outstream"    # Ljava/io/OutputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 96
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/entity/HttpEntityWrapper;->wrappedEntity:Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    invoke-interface {v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;->writeTo(Ljava/io/OutputStream;)V

    .line 97
    return-void
.end method
