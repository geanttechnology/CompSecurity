.class public Lcom/amazon/communication/HttpResponseDecompressor;
.super Ljava/lang/Object;
.source "HttpResponseDecompressor.java"


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 33
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 34
    return-void
.end method

.method public static decompressResponseIfNecessary(Lorg/apache/http/HttpResponse;)Z
    .locals 6
    .param p0, "response"    # Lorg/apache/http/HttpResponse;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v3, 0x0

    .line 49
    invoke-interface {p0}, Lorg/apache/http/HttpResponse;->getEntity()Lorg/apache/http/HttpEntity;

    move-result-object v1

    .line 50
    .local v1, "entity":Lorg/apache/http/HttpEntity;
    if-nez v1, :cond_1

    .line 68
    :cond_0
    :goto_0
    return v3

    .line 53
    :cond_1
    invoke-interface {v1}, Lorg/apache/http/HttpEntity;->getContentEncoding()Lorg/apache/http/Header;

    move-result-object v0

    .line 54
    .local v0, "encoding":Lorg/apache/http/Header;
    if-eqz v0, :cond_0

    .line 57
    const-string/jumbo v3, "gzip"

    invoke-interface {v0}, Lorg/apache/http/Header;->getValue()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_2

    .line 58
    new-instance v3, Ljava/lang/UnsupportedOperationException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, "Unsupported encoding type: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-interface {v0}, Lorg/apache/http/Header;->getValue()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 62
    :cond_2
    new-instance v2, Ljava/util/zip/GZIPInputStream;

    invoke-interface {v1}, Lorg/apache/http/HttpEntity;->getContent()Ljava/io/InputStream;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/util/zip/GZIPInputStream;-><init>(Ljava/io/InputStream;)V

    .line 63
    .local v2, "unzippedStream":Ljava/io/InputStream;
    new-instance v3, Lorg/apache/http/entity/InputStreamEntity;

    const-wide/16 v4, -0x1

    invoke-direct {v3, v2, v4, v5}, Lorg/apache/http/entity/InputStreamEntity;-><init>(Ljava/io/InputStream;J)V

    invoke-interface {p0, v3}, Lorg/apache/http/HttpResponse;->setEntity(Lorg/apache/http/HttpEntity;)V

    .line 65
    const-string/jumbo v3, "Content-Length"

    const-string/jumbo v4, "-1"

    invoke-interface {p0, v3, v4}, Lorg/apache/http/HttpResponse;->setHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 67
    const-string/jumbo v3, "Content-Encoding"

    invoke-interface {p0, v3}, Lorg/apache/http/HttpResponse;->removeHeaders(Ljava/lang/String;)V

    .line 68
    const/4 v3, 0x1

    goto :goto_0
.end method
