.class public Lcom/amazon/searchapp/retailsearch/client/web/apache40/StreamableEntity;
.super Lorg/apache/http/entity/AbstractHttpEntity;
.source "StreamableEntity.java"


# instance fields
.field private final content:Lcom/amazon/searchapp/retailsearch/client/web/RequestContent;


# direct methods
.method constructor <init>(Lcom/amazon/searchapp/retailsearch/client/web/RequestContent;)V
    .locals 0
    .param p1, "content"    # Lcom/amazon/searchapp/retailsearch/client/web/RequestContent;

    .prologue
    .line 26
    invoke-direct {p0}, Lorg/apache/http/entity/AbstractHttpEntity;-><init>()V

    .line 27
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/web/apache40/StreamableEntity;->content:Lcom/amazon/searchapp/retailsearch/client/web/RequestContent;

    .line 28
    return-void
.end method


# virtual methods
.method public getContent()Ljava/io/InputStream;
    .locals 1

    .prologue
    .line 43
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method

.method public getContentLength()J
    .locals 2

    .prologue
    .line 35
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/apache40/StreamableEntity;->content:Lcom/amazon/searchapp/retailsearch/client/web/RequestContent;

    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/web/RequestContent;->getLength()J

    move-result-wide v0

    return-wide v0
.end method

.method public isRepeatable()Z
    .locals 1

    .prologue
    .line 59
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/apache40/StreamableEntity;->content:Lcom/amazon/searchapp/retailsearch/client/web/RequestContent;

    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/web/RequestContent;->isRepeatable()Z

    move-result v0

    return v0
.end method

.method public isStreaming()Z
    .locals 1

    .prologue
    .line 51
    const/4 v0, 0x1

    return v0
.end method

.method public writeTo(Ljava/io/OutputStream;)V
    .locals 4
    .param p1, "out"    # Ljava/io/OutputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 67
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/apache40/StreamableEntity;->content:Lcom/amazon/searchapp/retailsearch/client/web/RequestContent;

    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/web/RequestContent;->getLength()J

    move-result-wide v0

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-gtz v0, :cond_0

    .line 68
    invoke-virtual {p1}, Ljava/io/OutputStream;->close()V

    .line 72
    :goto_0
    return-void

    .line 70
    :cond_0
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/apache40/StreamableEntity;->content:Lcom/amazon/searchapp/retailsearch/client/web/RequestContent;

    invoke-virtual {v0, p1}, Lcom/amazon/searchapp/retailsearch/client/web/RequestContent;->writeTo(Ljava/io/OutputStream;)V

    goto :goto_0
.end method
