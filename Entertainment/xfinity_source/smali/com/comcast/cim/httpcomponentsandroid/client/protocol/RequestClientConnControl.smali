.class public Lcom/comcast/cim/httpcomponentsandroid/client/protocol/RequestClientConnControl;
.super Ljava/lang/Object;
.source "RequestClientConnControl.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/Immutable;
.end annotation


# instance fields
.field private final log:Lorg/apache/commons/logging/Log;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 60
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 55
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-static {v0}, Lorg/apache/commons/logging/LogFactory;->getLog(Ljava/lang/Class;)Lorg/apache/commons/logging/Log;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/client/protocol/RequestClientConnControl;->log:Lorg/apache/commons/logging/Log;

    .line 61
    return-void
.end method


# virtual methods
.method public process(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)V
    .locals 5
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p2, "context"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/HttpException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 65
    if-nez p1, :cond_0

    .line 66
    new-instance v3, Ljava/lang/IllegalArgumentException;

    const-string v4, "HTTP request may not be null"

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 69
    :cond_0
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getRequestLine()Lcom/comcast/cim/httpcomponentsandroid/RequestLine;

    move-result-object v3

    invoke-interface {v3}, Lcom/comcast/cim/httpcomponentsandroid/RequestLine;->getMethod()Ljava/lang/String;

    move-result-object v1

    .line 70
    .local v1, "method":Ljava/lang/String;
    const-string v3, "CONNECT"

    invoke-virtual {v1, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 71
    const-string v3, "Proxy-Connection"

    const-string v4, "Keep-Alive"

    invoke-interface {p1, v3, v4}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->setHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 95
    :cond_1
    :goto_0
    return-void

    .line 76
    :cond_2
    const-string v3, "http.connection"

    invoke-interface {p2, v3}, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;->getAttribute(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/httpcomponentsandroid/conn/HttpRoutedConnection;

    .line 78
    .local v0, "conn":Lcom/comcast/cim/httpcomponentsandroid/conn/HttpRoutedConnection;
    if-nez v0, :cond_3

    .line 79
    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/client/protocol/RequestClientConnControl;->log:Lorg/apache/commons/logging/Log;

    const-string v4, "HTTP connection not set in the context"

    invoke-interface {v3, v4}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    goto :goto_0

    .line 83
    :cond_3
    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/conn/HttpRoutedConnection;->getRoute()Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;

    move-result-object v2

    .line 85
    .local v2, "route":Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;
    invoke-virtual {v2}, Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;->getHopCount()I

    move-result v3

    const/4 v4, 0x1

    if-eq v3, v4, :cond_4

    invoke-virtual {v2}, Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;->isTunnelled()Z

    move-result v3

    if-eqz v3, :cond_5

    .line 86
    :cond_4
    const-string v3, "Connection"

    invoke-interface {p1, v3}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->containsHeader(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_5

    .line 87
    const-string v3, "Connection"

    const-string v4, "Keep-Alive"

    invoke-interface {p1, v3, v4}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 90
    :cond_5
    invoke-virtual {v2}, Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;->getHopCount()I

    move-result v3

    const/4 v4, 0x2

    if-ne v3, v4, :cond_1

    invoke-virtual {v2}, Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;->isTunnelled()Z

    move-result v3

    if-nez v3, :cond_1

    .line 91
    const-string v3, "Proxy-Connection"

    invoke-interface {p1, v3}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->containsHeader(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 92
    const-string v3, "Proxy-Connection"

    const-string v4, "Keep-Alive"

    invoke-interface {p1, v3, v4}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method
