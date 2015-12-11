.class public abstract Lcom/comcast/cim/cmasl/http/response/DelegatingResponseHandler;
.super Ljava/lang/Object;
.source "DelegatingResponseHandler.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/http/response/ResponseHandler;


# instance fields
.field private final delegateHeadersHandlers:Ljava/util/LinkedHashSet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/LinkedHashSet",
            "<",
            "Lcom/comcast/cim/cmasl/http/response/ResponseHeadersHandler;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 7
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 8
    new-instance v0, Ljava/util/LinkedHashSet;

    invoke-direct {v0}, Ljava/util/LinkedHashSet;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/cmasl/http/response/DelegatingResponseHandler;->delegateHeadersHandlers:Ljava/util/LinkedHashSet;

    return-void
.end method


# virtual methods
.method protected addDefaultHeaderHandlers()V
    .locals 1

    .prologue
    .line 23
    new-instance v0, Lcom/comcast/cim/cmasl/http/response/DefaultHttpStatusCodeHandler;

    invoke-direct {v0}, Lcom/comcast/cim/cmasl/http/response/DefaultHttpStatusCodeHandler;-><init>()V

    invoke-virtual {p0, v0}, Lcom/comcast/cim/cmasl/http/response/DelegatingResponseHandler;->addDelegateHeadersHandler(Lcom/comcast/cim/cmasl/http/response/ResponseHeadersHandler;)V

    .line 24
    return-void
.end method

.method protected addDelegateHeadersHandler(Lcom/comcast/cim/cmasl/http/response/ResponseHeadersHandler;)V
    .locals 1
    .param p1, "delegate"    # Lcom/comcast/cim/cmasl/http/response/ResponseHeadersHandler;

    .prologue
    .line 11
    iget-object v0, p0, Lcom/comcast/cim/cmasl/http/response/DelegatingResponseHandler;->delegateHeadersHandlers:Ljava/util/LinkedHashSet;

    invoke-virtual {v0, p1}, Ljava/util/LinkedHashSet;->add(Ljava/lang/Object;)Z

    .line 12
    return-void
.end method

.method public handleResponseHeaders(Ljava/lang/String;Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;Ljava/util/Map;)V
    .locals 3
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "detailedRequestStatus"    # Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 30
    .local p3, "responseHeaders":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    iget-object v2, p0, Lcom/comcast/cim/cmasl/http/response/DelegatingResponseHandler;->delegateHeadersHandlers:Ljava/util/LinkedHashSet;

    invoke-virtual {v2}, Ljava/util/LinkedHashSet;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/cmasl/http/response/ResponseHeadersHandler;

    .line 31
    .local v0, "delegate":Lcom/comcast/cim/cmasl/http/response/ResponseHeadersHandler;
    invoke-interface {v0, p1, p2, p3}, Lcom/comcast/cim/cmasl/http/response/ResponseHeadersHandler;->handleResponseHeaders(Ljava/lang/String;Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;Ljava/util/Map;)V

    goto :goto_0

    .line 33
    .end local v0    # "delegate":Lcom/comcast/cim/cmasl/http/response/ResponseHeadersHandler;
    :cond_0
    return-void
.end method
