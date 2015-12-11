.class public Lcom/comcast/cim/httpcomponentsandroid/protocol/RequestContent;
.super Ljava/lang/Object;
.source "RequestContent.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 54
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 55
    return-void
.end method


# virtual methods
.method public process(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)V
    .locals 6
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p2, "context"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/HttpException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 59
    if-nez p1, :cond_0

    .line 60
    new-instance v2, Ljava/lang/IllegalArgumentException;

    const-string v3, "HTTP request may not be null"

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 62
    :cond_0
    instance-of v2, p1, Lcom/comcast/cim/httpcomponentsandroid/HttpEntityEnclosingRequest;

    if-eqz v2, :cond_3

    .line 63
    const-string v2, "Transfer-Encoding"

    invoke-interface {p1, v2}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->containsHeader(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 64
    new-instance v2, Lcom/comcast/cim/httpcomponentsandroid/ProtocolException;

    const-string v3, "Transfer-encoding header already present"

    invoke-direct {v2, v3}, Lcom/comcast/cim/httpcomponentsandroid/ProtocolException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 66
    :cond_1
    const-string v2, "Content-Length"

    invoke-interface {p1, v2}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->containsHeader(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 67
    new-instance v2, Lcom/comcast/cim/httpcomponentsandroid/ProtocolException;

    const-string v3, "Content-Length header already present"

    invoke-direct {v2, v3}, Lcom/comcast/cim/httpcomponentsandroid/ProtocolException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 69
    :cond_2
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getRequestLine()Lcom/comcast/cim/httpcomponentsandroid/RequestLine;

    move-result-object v2

    invoke-interface {v2}, Lcom/comcast/cim/httpcomponentsandroid/RequestLine;->getProtocolVersion()Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;

    move-result-object v1

    .local v1, "ver":Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;
    move-object v2, p1

    .line 70
    check-cast v2, Lcom/comcast/cim/httpcomponentsandroid/HttpEntityEnclosingRequest;

    invoke-interface {v2}, Lcom/comcast/cim/httpcomponentsandroid/HttpEntityEnclosingRequest;->getEntity()Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    move-result-object v0

    .line 71
    .local v0, "entity":Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;
    if-nez v0, :cond_4

    .line 72
    const-string v2, "Content-Length"

    const-string v3, "0"

    invoke-interface {p1, v2, v3}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 96
    .end local v0    # "entity":Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;
    .end local v1    # "ver":Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;
    :cond_3
    :goto_0
    return-void

    .line 76
    .restart local v0    # "entity":Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;
    .restart local v1    # "ver":Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;
    :cond_4
    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;->isChunked()Z

    move-result v2

    if-nez v2, :cond_5

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;->getContentLength()J

    move-result-wide v2

    const-wide/16 v4, 0x0

    cmp-long v2, v2, v4

    if-gez v2, :cond_8

    .line 77
    :cond_5
    sget-object v2, Lcom/comcast/cim/httpcomponentsandroid/HttpVersion;->HTTP_1_0:Lcom/comcast/cim/httpcomponentsandroid/HttpVersion;

    invoke-virtual {v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;->lessEquals(Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;)Z

    move-result v2

    if-eqz v2, :cond_6

    .line 78
    new-instance v2, Lcom/comcast/cim/httpcomponentsandroid/ProtocolException;

    new-instance v3, Ljava/lang/StringBuffer;

    invoke-direct {v3}, Ljava/lang/StringBuffer;-><init>()V

    const-string v4, "Chunked transfer encoding not allowed for "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/Object;)Ljava/lang/StringBuffer;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Lcom/comcast/cim/httpcomponentsandroid/ProtocolException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 81
    :cond_6
    const-string v2, "Transfer-Encoding"

    const-string v3, "chunked"

    invoke-interface {p1, v2, v3}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 86
    :goto_1
    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;->getContentType()Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v2

    if-eqz v2, :cond_7

    const-string v2, "Content-Type"

    invoke-interface {p1, v2}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->containsHeader(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_7

    .line 88
    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;->getContentType()Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v2

    invoke-interface {p1, v2}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->addHeader(Lcom/comcast/cim/httpcomponentsandroid/Header;)V

    .line 91
    :cond_7
    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;->getContentEncoding()Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v2

    if-eqz v2, :cond_3

    const-string v2, "Content-Encoding"

    invoke-interface {p1, v2}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->containsHeader(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_3

    .line 93
    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;->getContentEncoding()Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v2

    invoke-interface {p1, v2}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->addHeader(Lcom/comcast/cim/httpcomponentsandroid/Header;)V

    goto :goto_0

    .line 83
    :cond_8
    const-string v2, "Content-Length"

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;->getContentLength()J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v3

    invoke-interface {p1, v2, v3}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1
.end method
