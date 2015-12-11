.class public Lcom/comcast/cim/httpcomponentsandroid/protocol/RequestUserAgent;
.super Ljava/lang/Object;
.source "RequestUserAgent.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 52
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 53
    return-void
.end method


# virtual methods
.method public process(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)V
    .locals 3
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p2, "context"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/HttpException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 57
    if-nez p1, :cond_0

    .line 58
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "HTTP request may not be null"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 60
    :cond_0
    const-string v1, "User-Agent"

    invoke-interface {p1, v1}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->containsHeader(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 61
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getParams()Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    move-result-object v1

    invoke-static {v1}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpProtocolParams;->getUserAgent(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)Ljava/lang/String;

    move-result-object v0

    .line 62
    .local v0, "useragent":Ljava/lang/String;
    if-eqz v0, :cond_1

    .line 63
    const-string v1, "User-Agent"

    invoke-interface {p1, v1, v0}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 66
    .end local v0    # "useragent":Ljava/lang/String;
    :cond_1
    return-void
.end method
