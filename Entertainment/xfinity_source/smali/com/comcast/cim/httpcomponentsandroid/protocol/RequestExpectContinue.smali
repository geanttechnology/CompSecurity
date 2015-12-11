.class public Lcom/comcast/cim/httpcomponentsandroid/protocol/RequestExpectContinue;
.super Ljava/lang/Object;
.source "RequestExpectContinue.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 57
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 58
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
    .line 62
    if-nez p1, :cond_0

    .line 63
    new-instance v2, Ljava/lang/IllegalArgumentException;

    const-string v3, "HTTP request may not be null"

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 65
    :cond_0
    instance-of v2, p1, Lcom/comcast/cim/httpcomponentsandroid/HttpEntityEnclosingRequest;

    if-eqz v2, :cond_1

    move-object v2, p1

    .line 66
    check-cast v2, Lcom/comcast/cim/httpcomponentsandroid/HttpEntityEnclosingRequest;

    invoke-interface {v2}, Lcom/comcast/cim/httpcomponentsandroid/HttpEntityEnclosingRequest;->getEntity()Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    move-result-object v0

    .line 68
    .local v0, "entity":Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;
    if-eqz v0, :cond_1

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;->getContentLength()J

    move-result-wide v2

    const-wide/16 v4, 0x0

    cmp-long v2, v2, v4

    if-eqz v2, :cond_1

    .line 69
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getRequestLine()Lcom/comcast/cim/httpcomponentsandroid/RequestLine;

    move-result-object v2

    invoke-interface {v2}, Lcom/comcast/cim/httpcomponentsandroid/RequestLine;->getProtocolVersion()Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;

    move-result-object v1

    .line 70
    .local v1, "ver":Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getParams()Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    move-result-object v2

    invoke-static {v2}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpProtocolParams;->useExpectContinue(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)Z

    move-result v2

    if-eqz v2, :cond_1

    sget-object v2, Lcom/comcast/cim/httpcomponentsandroid/HttpVersion;->HTTP_1_0:Lcom/comcast/cim/httpcomponentsandroid/HttpVersion;

    invoke-virtual {v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;->lessEquals(Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 72
    const-string v2, "Expect"

    const-string v3, "100-continue"

    invoke-interface {p1, v2, v3}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 76
    .end local v0    # "entity":Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;
    .end local v1    # "ver":Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;
    :cond_1
    return-void
.end method
