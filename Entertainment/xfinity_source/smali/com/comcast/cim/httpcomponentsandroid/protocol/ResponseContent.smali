.class public Lcom/comcast/cim/httpcomponentsandroid/protocol/ResponseContent;
.super Ljava/lang/Object;
.source "ResponseContent.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/HttpResponseInterceptor;


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
.method public process(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)V
    .locals 8
    .param p1, "response"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
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
    new-instance v5, Ljava/lang/IllegalArgumentException;

    const-string v6, "HTTP response may not be null"

    invoke-direct {v5, v6}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 62
    :cond_0
    const-string v5, "Transfer-Encoding"

    invoke-interface {p1, v5}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->containsHeader(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 63
    new-instance v5, Lcom/comcast/cim/httpcomponentsandroid/ProtocolException;

    const-string v6, "Transfer-encoding header already present"

    invoke-direct {v5, v6}, Lcom/comcast/cim/httpcomponentsandroid/ProtocolException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 65
    :cond_1
    const-string v5, "Content-Length"

    invoke-interface {p1, v5}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->containsHeader(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 66
    new-instance v5, Lcom/comcast/cim/httpcomponentsandroid/ProtocolException;

    const-string v6, "Content-Length header already present"

    invoke-direct {v5, v6}, Lcom/comcast/cim/httpcomponentsandroid/ProtocolException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 68
    :cond_2
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getStatusLine()Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

    move-result-object v5

    invoke-interface {v5}, Lcom/comcast/cim/httpcomponentsandroid/StatusLine;->getProtocolVersion()Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;

    move-result-object v4

    .line 69
    .local v4, "ver":Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getEntity()Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    move-result-object v0

    .line 70
    .local v0, "entity":Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;
    if-eqz v0, :cond_7

    .line 71
    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;->getContentLength()J

    move-result-wide v2

    .line 72
    .local v2, "len":J
    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;->isChunked()Z

    move-result v5

    if-eqz v5, :cond_6

    sget-object v5, Lcom/comcast/cim/httpcomponentsandroid/HttpVersion;->HTTP_1_0:Lcom/comcast/cim/httpcomponentsandroid/HttpVersion;

    invoke-virtual {v4, v5}, Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;->lessEquals(Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;)Z

    move-result v5

    if-nez v5, :cond_6

    .line 73
    const-string v5, "Transfer-Encoding"

    const-string v6, "chunked"

    invoke-interface {p1, v5, v6}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 78
    :cond_3
    :goto_0
    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;->getContentType()Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v5

    if-eqz v5, :cond_4

    const-string v5, "Content-Type"

    invoke-interface {p1, v5}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->containsHeader(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_4

    .line 80
    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;->getContentType()Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v5

    invoke-interface {p1, v5}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->addHeader(Lcom/comcast/cim/httpcomponentsandroid/Header;)V

    .line 83
    :cond_4
    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;->getContentEncoding()Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v5

    if-eqz v5, :cond_5

    const-string v5, "Content-Encoding"

    invoke-interface {p1, v5}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->containsHeader(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_5

    .line 85
    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;->getContentEncoding()Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v5

    invoke-interface {p1, v5}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->addHeader(Lcom/comcast/cim/httpcomponentsandroid/Header;)V

    .line 95
    .end local v2    # "len":J
    :cond_5
    :goto_1
    return-void

    .line 74
    .restart local v2    # "len":J
    :cond_6
    const-wide/16 v6, 0x0

    cmp-long v5, v2, v6

    if-ltz v5, :cond_3

    .line 75
    const-string v5, "Content-Length"

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;->getContentLength()J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v6

    invoke-interface {p1, v5, v6}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 88
    .end local v2    # "len":J
    :cond_7
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getStatusLine()Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

    move-result-object v5

    invoke-interface {v5}, Lcom/comcast/cim/httpcomponentsandroid/StatusLine;->getStatusCode()I

    move-result v1

    .line 89
    .local v1, "status":I
    const/16 v5, 0xcc

    if-eq v1, v5, :cond_5

    const/16 v5, 0x130

    if-eq v1, v5, :cond_5

    const/16 v5, 0xcd

    if-eq v1, v5, :cond_5

    .line 92
    const-string v5, "Content-Length"

    const-string v6, "0"

    invoke-interface {p1, v5, v6}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1
.end method
