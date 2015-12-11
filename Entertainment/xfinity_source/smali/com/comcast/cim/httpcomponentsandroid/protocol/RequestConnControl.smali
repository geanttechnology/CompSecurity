.class public Lcom/comcast/cim/httpcomponentsandroid/protocol/RequestConnControl;
.super Ljava/lang/Object;
.source "RequestConnControl.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 47
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 48
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
    .line 52
    if-nez p1, :cond_0

    .line 53
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "HTTP request may not be null"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 56
    :cond_0
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getRequestLine()Lcom/comcast/cim/httpcomponentsandroid/RequestLine;

    move-result-object v1

    invoke-interface {v1}, Lcom/comcast/cim/httpcomponentsandroid/RequestLine;->getMethod()Ljava/lang/String;

    move-result-object v0

    .line 57
    .local v0, "method":Ljava/lang/String;
    const-string v1, "CONNECT"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 66
    :cond_1
    :goto_0
    return-void

    .line 61
    :cond_2
    const-string v1, "Connection"

    invoke-interface {p1, v1}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->containsHeader(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 64
    const-string v1, "Connection"

    const-string v2, "Keep-Alive"

    invoke-interface {p1, v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method
