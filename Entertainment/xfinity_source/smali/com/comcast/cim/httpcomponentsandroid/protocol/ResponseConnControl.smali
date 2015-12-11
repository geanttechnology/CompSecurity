.class public Lcom/comcast/cim/httpcomponentsandroid/protocol/ResponseConnControl;
.super Ljava/lang/Object;
.source "ResponseConnControl.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/HttpResponseInterceptor;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 53
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 54
    return-void
.end method


# virtual methods
.method public process(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)V
    .locals 10
    .param p1, "response"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .param p2, "context"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/HttpException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 58
    if-nez p1, :cond_0

    .line 59
    new-instance v5, Ljava/lang/IllegalArgumentException;

    const-string v6, "HTTP response may not be null"

    invoke-direct {v5, v6}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 61
    :cond_0
    if-nez p2, :cond_1

    .line 62
    new-instance v5, Ljava/lang/IllegalArgumentException;

    const-string v6, "HTTP context may not be null"

    invoke-direct {v5, v6}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 65
    :cond_1
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getStatusLine()Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

    move-result-object v5

    invoke-interface {v5}, Lcom/comcast/cim/httpcomponentsandroid/StatusLine;->getStatusCode()I

    move-result v3

    .line 66
    .local v3, "status":I
    const/16 v5, 0x190

    if-eq v3, v5, :cond_2

    const/16 v5, 0x198

    if-eq v3, v5, :cond_2

    const/16 v5, 0x19b

    if-eq v3, v5, :cond_2

    const/16 v5, 0x19d

    if-eq v3, v5, :cond_2

    const/16 v5, 0x19e

    if-eq v3, v5, :cond_2

    const/16 v5, 0x1f7

    if-eq v3, v5, :cond_2

    const/16 v5, 0x1f5

    if-ne v3, v5, :cond_4

    .line 73
    :cond_2
    const-string v5, "Connection"

    const-string v6, "Close"

    invoke-interface {p1, v5, v6}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->setHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 98
    :cond_3
    :goto_0
    return-void

    .line 78
    :cond_4
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getEntity()Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    move-result-object v0

    .line 79
    .local v0, "entity":Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;
    if-eqz v0, :cond_6

    .line 80
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getStatusLine()Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

    move-result-object v5

    invoke-interface {v5}, Lcom/comcast/cim/httpcomponentsandroid/StatusLine;->getProtocolVersion()Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;

    move-result-object v4

    .line 81
    .local v4, "ver":Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;
    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;->getContentLength()J

    move-result-wide v6

    const-wide/16 v8, 0x0

    cmp-long v5, v6, v8

    if-gez v5, :cond_6

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;->isChunked()Z

    move-result v5

    if-eqz v5, :cond_5

    sget-object v5, Lcom/comcast/cim/httpcomponentsandroid/HttpVersion;->HTTP_1_0:Lcom/comcast/cim/httpcomponentsandroid/HttpVersion;

    invoke-virtual {v4, v5}, Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;->lessEquals(Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;)Z

    move-result v5

    if-eqz v5, :cond_6

    .line 83
    :cond_5
    const-string v5, "Connection"

    const-string v6, "Close"

    invoke-interface {p1, v5, v6}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->setHeader(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 88
    .end local v4    # "ver":Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;
    :cond_6
    const-string v5, "http.request"

    invoke-interface {p2, v5}, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;->getAttribute(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;

    .line 90
    .local v2, "request":Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    if-eqz v2, :cond_3

    .line 91
    const-string v5, "Connection"

    invoke-interface {v2, v5}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getFirstHeader(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v1

    .line 92
    .local v1, "header":Lcom/comcast/cim/httpcomponentsandroid/Header;
    if-eqz v1, :cond_7

    .line 93
    const-string v5, "Connection"

    invoke-interface {v1}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getValue()Ljava/lang/String;

    move-result-object v6

    invoke-interface {p1, v5, v6}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->setHeader(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 94
    :cond_7
    invoke-interface {v2}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getProtocolVersion()Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;

    move-result-object v5

    sget-object v6, Lcom/comcast/cim/httpcomponentsandroid/HttpVersion;->HTTP_1_0:Lcom/comcast/cim/httpcomponentsandroid/HttpVersion;

    invoke-virtual {v5, v6}, Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;->lessEquals(Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;)Z

    move-result v5

    if-eqz v5, :cond_3

    .line 95
    const-string v5, "Connection"

    const-string v6, "Close"

    invoke-interface {p1, v5, v6}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->setHeader(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method
