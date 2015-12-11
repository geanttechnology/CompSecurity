.class public Lcom/comcast/cim/cmasl/http/request/RevalidatingRequestProvider;
.super Ljava/lang/Object;
.source "RevalidatingRequestProvider.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/http/request/RequestProvider;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
        "<TT;>;"
    }
.end annotation


# instance fields
.field private final lastResponseId:Lcom/comcast/cim/cmasl/http/response/ResponseId;

.field private requestProvider:Lcom/comcast/cim/cmasl/http/request/RequestProvider;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<TT;>;"
        }
    .end annotation
.end field


# virtual methods
.method public addHeader(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 37
    .local p0, "this":Lcom/comcast/cim/cmasl/http/request/RevalidatingRequestProvider;, "Lcom/comcast/cim/cmasl/http/request/RevalidatingRequestProvider<TT;>;"
    iget-object v0, p0, Lcom/comcast/cim/cmasl/http/request/RevalidatingRequestProvider;->requestProvider:Lcom/comcast/cim/cmasl/http/request/RequestProvider;

    invoke-interface {v0, p1, p2}, Lcom/comcast/cim/cmasl/http/request/RequestProvider;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 38
    return-void
.end method

.method public addHttpEntityParameter(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 32
    .local p0, "this":Lcom/comcast/cim/cmasl/http/request/RevalidatingRequestProvider;, "Lcom/comcast/cim/cmasl/http/request/RevalidatingRequestProvider<TT;>;"
    iget-object v0, p0, Lcom/comcast/cim/cmasl/http/request/RevalidatingRequestProvider;->requestProvider:Lcom/comcast/cim/cmasl/http/request/RequestProvider;

    invoke-interface {v0, p1, p2}, Lcom/comcast/cim/cmasl/http/request/RequestProvider;->addHttpEntityParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 33
    return-void
.end method

.method public addQueryParameter(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 27
    .local p0, "this":Lcom/comcast/cim/cmasl/http/request/RevalidatingRequestProvider;, "Lcom/comcast/cim/cmasl/http/request/RevalidatingRequestProvider<TT;>;"
    iget-object v0, p0, Lcom/comcast/cim/cmasl/http/request/RevalidatingRequestProvider;->requestProvider:Lcom/comcast/cim/cmasl/http/request/RequestProvider;

    invoke-interface {v0, p1, p2}, Lcom/comcast/cim/cmasl/http/request/RequestProvider;->addQueryParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 28
    return-void
.end method

.method public createRequest()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .prologue
    .line 22
    .local p0, "this":Lcom/comcast/cim/cmasl/http/request/RevalidatingRequestProvider;, "Lcom/comcast/cim/cmasl/http/request/RevalidatingRequestProvider<TT;>;"
    iget-object v0, p0, Lcom/comcast/cim/cmasl/http/request/RevalidatingRequestProvider;->requestProvider:Lcom/comcast/cim/cmasl/http/request/RequestProvider;

    invoke-interface {v0}, Lcom/comcast/cim/cmasl/http/request/RequestProvider;->createRequest()Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getLastResponseId()Lcom/comcast/cim/cmasl/http/response/ResponseId;
    .locals 1

    .prologue
    .line 17
    .local p0, "this":Lcom/comcast/cim/cmasl/http/request/RevalidatingRequestProvider;, "Lcom/comcast/cim/cmasl/http/request/RevalidatingRequestProvider<TT;>;"
    iget-object v0, p0, Lcom/comcast/cim/cmasl/http/request/RevalidatingRequestProvider;->lastResponseId:Lcom/comcast/cim/cmasl/http/response/ResponseId;

    return-object v0
.end method

.method public setSocketTimeout(J)V
    .locals 1
    .param p1, "timeoutInMillis"    # J

    .prologue
    .line 42
    .local p0, "this":Lcom/comcast/cim/cmasl/http/request/RevalidatingRequestProvider;, "Lcom/comcast/cim/cmasl/http/request/RevalidatingRequestProvider<TT;>;"
    iget-object v0, p0, Lcom/comcast/cim/cmasl/http/request/RevalidatingRequestProvider;->requestProvider:Lcom/comcast/cim/cmasl/http/request/RequestProvider;

    invoke-interface {v0, p1, p2}, Lcom/comcast/cim/cmasl/http/request/RequestProvider;->setSocketTimeout(J)V

    .line 43
    return-void
.end method
