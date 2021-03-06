.class public Lorg/springframework/http/converter/ByteArrayHttpMessageConverter;
.super Lorg/springframework/http/converter/AbstractHttpMessageConverter;
.source "ByteArrayHttpMessageConverter.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/springframework/http/converter/AbstractHttpMessageConverter",
        "<[B>;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 5

    .prologue
    .line 42
    const/4 v0, 0x2

    new-array v0, v0, [Lorg/springframework/http/MediaType;

    const/4 v1, 0x0

    new-instance v2, Lorg/springframework/http/MediaType;

    const-string v3, "application"

    const-string v4, "octet-stream"

    invoke-direct {v2, v3, v4}, Lorg/springframework/http/MediaType;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    aput-object v2, v0, v1

    const/4 v1, 0x1

    sget-object v2, Lorg/springframework/http/MediaType;->ALL:Lorg/springframework/http/MediaType;

    aput-object v2, v0, v1

    invoke-direct {p0, v0}, Lorg/springframework/http/converter/AbstractHttpMessageConverter;-><init>([Lorg/springframework/http/MediaType;)V

    .line 43
    return-void
.end method


# virtual methods
.method protected bridge synthetic getContentLength(Ljava/lang/Object;Lorg/springframework/http/MediaType;)Ljava/lang/Long;
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;
    .param p2, "x1"    # Lorg/springframework/http/MediaType;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 38
    check-cast p1, [B

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lorg/springframework/http/converter/ByteArrayHttpMessageConverter;->getContentLength([BLorg/springframework/http/MediaType;)Ljava/lang/Long;

    move-result-object v0

    return-object v0
.end method

.method protected getContentLength([BLorg/springframework/http/MediaType;)Ljava/lang/Long;
    .locals 2
    .param p1, "bytes"    # [B
    .param p2, "contentType"    # Lorg/springframework/http/MediaType;

    .prologue
    .line 65
    array-length v0, p1

    int-to-long v0, v0

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic readInternal(Ljava/lang/Class;Lorg/springframework/http/HttpInputMessage;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Ljava/lang/Class;
    .param p2, "x1"    # Lorg/springframework/http/HttpInputMessage;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lorg/springframework/http/converter/HttpMessageNotReadableException;
        }
    .end annotation

    .prologue
    .line 38
    invoke-virtual {p0, p1, p2}, Lorg/springframework/http/converter/ByteArrayHttpMessageConverter;->readInternal(Ljava/lang/Class;Lorg/springframework/http/HttpInputMessage;)[B

    move-result-object v0

    return-object v0
.end method

.method public readInternal(Ljava/lang/Class;Lorg/springframework/http/HttpInputMessage;)[B
    .locals 6
    .param p2, "inputMessage"    # Lorg/springframework/http/HttpInputMessage;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<+[B>;",
            "Lorg/springframework/http/HttpInputMessage;",
            ")[B"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 52
    .local p1, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<+[B>;"
    invoke-interface {p2}, Lorg/springframework/http/HttpInputMessage;->getHeaders()Lorg/springframework/http/HttpHeaders;

    move-result-object v1

    invoke-virtual {v1}, Lorg/springframework/http/HttpHeaders;->getContentLength()J

    move-result-wide v2

    .line 53
    .local v2, "contentLength":J
    const-wide/16 v4, 0x0

    cmp-long v1, v2, v4

    if-ltz v1, :cond_0

    .line 54
    new-instance v0, Ljava/io/ByteArrayOutputStream;

    long-to-int v1, v2

    invoke-direct {v0, v1}, Ljava/io/ByteArrayOutputStream;-><init>(I)V

    .line 55
    .local v0, "bos":Ljava/io/ByteArrayOutputStream;
    invoke-interface {p2}, Lorg/springframework/http/HttpInputMessage;->getBody()Ljava/io/InputStream;

    move-result-object v1

    invoke-static {v1, v0}, Lorg/springframework/util/FileCopyUtils;->copy(Ljava/io/InputStream;Ljava/io/OutputStream;)I

    .line 56
    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v1

    .line 59
    .end local v0    # "bos":Ljava/io/ByteArrayOutputStream;
    :goto_0
    return-object v1

    :cond_0
    invoke-interface {p2}, Lorg/springframework/http/HttpInputMessage;->getBody()Ljava/io/InputStream;

    move-result-object v1

    invoke-static {v1}, Lorg/springframework/util/FileCopyUtils;->copyToByteArray(Ljava/io/InputStream;)[B

    move-result-object v1

    goto :goto_0
.end method

.method public supports(Ljava/lang/Class;)Z
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;)Z"
        }
    .end annotation

    .prologue
    .line 47
    .local p1, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const-class v0, [B

    invoke-virtual {v0, p1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method protected bridge synthetic writeInternal(Ljava/lang/Object;Lorg/springframework/http/HttpOutputMessage;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;
    .param p2, "x1"    # Lorg/springframework/http/HttpOutputMessage;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lorg/springframework/http/converter/HttpMessageNotWritableException;
        }
    .end annotation

    .prologue
    .line 38
    check-cast p1, [B

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lorg/springframework/http/converter/ByteArrayHttpMessageConverter;->writeInternal([BLorg/springframework/http/HttpOutputMessage;)V

    return-void
.end method

.method protected writeInternal([BLorg/springframework/http/HttpOutputMessage;)V
    .locals 1
    .param p1, "bytes"    # [B
    .param p2, "outputMessage"    # Lorg/springframework/http/HttpOutputMessage;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 70
    invoke-interface {p2}, Lorg/springframework/http/HttpOutputMessage;->getBody()Ljava/io/OutputStream;

    move-result-object v0

    invoke-static {p1, v0}, Lorg/springframework/util/FileCopyUtils;->copy([BLjava/io/OutputStream;)V

    .line 71
    return-void
.end method
