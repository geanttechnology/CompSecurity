.class Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRedirectStrategyAdaptor;
.super Ljava/lang/Object;
.source "DefaultRedirectStrategyAdaptor.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/client/RedirectStrategy;


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/Immutable;
.end annotation

.annotation runtime Ljava/lang/Deprecated;
.end annotation


# instance fields
.field private final handler:Lcom/comcast/cim/httpcomponentsandroid/client/RedirectHandler;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/client/RedirectHandler;)V
    .locals 0
    .param p1, "handler"    # Lcom/comcast/cim/httpcomponentsandroid/client/RedirectHandler;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 53
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 54
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRedirectStrategyAdaptor;->handler:Lcom/comcast/cim/httpcomponentsandroid/client/RedirectHandler;

    .line 55
    return-void
.end method


# virtual methods
.method public getRedirect(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;
    .locals 3
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p2, "response"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .param p3, "context"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/ProtocolException;
        }
    .end annotation

    .prologue
    .line 68
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRedirectStrategyAdaptor;->handler:Lcom/comcast/cim/httpcomponentsandroid/client/RedirectHandler;

    invoke-interface {v2, p2, p3}, Lcom/comcast/cim/httpcomponentsandroid/client/RedirectHandler;->getLocationURI(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Ljava/net/URI;

    move-result-object v1

    .line 69
    .local v1, "uri":Ljava/net/URI;
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getRequestLine()Lcom/comcast/cim/httpcomponentsandroid/RequestLine;

    move-result-object v2

    invoke-interface {v2}, Lcom/comcast/cim/httpcomponentsandroid/RequestLine;->getMethod()Ljava/lang/String;

    move-result-object v0

    .line 70
    .local v0, "method":Ljava/lang/String;
    const-string v2, "HEAD"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 71
    new-instance v2, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpHead;

    invoke-direct {v2, v1}, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpHead;-><init>(Ljava/net/URI;)V

    .line 73
    :goto_0
    return-object v2

    :cond_0
    new-instance v2, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpGet;

    invoke-direct {v2, v1}, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpGet;-><init>(Ljava/net/URI;)V

    goto :goto_0
.end method

.method public isRedirected(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Z
    .locals 1
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p2, "response"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .param p3, "context"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/ProtocolException;
        }
    .end annotation

    .prologue
    .line 61
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRedirectStrategyAdaptor;->handler:Lcom/comcast/cim/httpcomponentsandroid/client/RedirectHandler;

    invoke-interface {v0, p2, p3}, Lcom/comcast/cim/httpcomponentsandroid/client/RedirectHandler;->isRedirectRequested(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Z

    move-result v0

    return v0
.end method
