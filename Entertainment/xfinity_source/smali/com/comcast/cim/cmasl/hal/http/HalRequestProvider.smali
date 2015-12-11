.class public Lcom/comcast/cim/cmasl/hal/http/HalRequestProvider;
.super Ljava/lang/Object;
.source "HalRequestProvider.java"

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
.field private final delegateProvider:Lcom/comcast/cim/cmasl/http/request/RequestProvider;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<TT;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/comcast/cim/cmasl/http/request/RequestProvider;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 9
    .local p0, "this":Lcom/comcast/cim/cmasl/hal/http/HalRequestProvider;, "Lcom/comcast/cim/cmasl/hal/http/HalRequestProvider<TT;>;"
    .local p1, "requestProvider":Lcom/comcast/cim/cmasl/http/request/RequestProvider;, "Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 10
    iput-object p1, p0, Lcom/comcast/cim/cmasl/hal/http/HalRequestProvider;->delegateProvider:Lcom/comcast/cim/cmasl/http/request/RequestProvider;

    .line 11
    iget-object v0, p0, Lcom/comcast/cim/cmasl/hal/http/HalRequestProvider;->delegateProvider:Lcom/comcast/cim/cmasl/http/request/RequestProvider;

    const-string v1, "Accept"

    const-string v2, "application/hal+json"

    invoke-interface {v0, v1, v2}, Lcom/comcast/cim/cmasl/http/request/RequestProvider;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 12
    return-void
.end method


# virtual methods
.method public addHeader(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 31
    .local p0, "this":Lcom/comcast/cim/cmasl/hal/http/HalRequestProvider;, "Lcom/comcast/cim/cmasl/hal/http/HalRequestProvider<TT;>;"
    iget-object v0, p0, Lcom/comcast/cim/cmasl/hal/http/HalRequestProvider;->delegateProvider:Lcom/comcast/cim/cmasl/http/request/RequestProvider;

    invoke-interface {v0, p1, p2}, Lcom/comcast/cim/cmasl/http/request/RequestProvider;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 32
    return-void
.end method

.method public addHttpEntityParameter(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 26
    .local p0, "this":Lcom/comcast/cim/cmasl/hal/http/HalRequestProvider;, "Lcom/comcast/cim/cmasl/hal/http/HalRequestProvider<TT;>;"
    iget-object v0, p0, Lcom/comcast/cim/cmasl/hal/http/HalRequestProvider;->delegateProvider:Lcom/comcast/cim/cmasl/http/request/RequestProvider;

    invoke-interface {v0, p1, p2}, Lcom/comcast/cim/cmasl/http/request/RequestProvider;->addHttpEntityParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 27
    return-void
.end method

.method public addQueryParameter(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 21
    .local p0, "this":Lcom/comcast/cim/cmasl/hal/http/HalRequestProvider;, "Lcom/comcast/cim/cmasl/hal/http/HalRequestProvider<TT;>;"
    iget-object v0, p0, Lcom/comcast/cim/cmasl/hal/http/HalRequestProvider;->delegateProvider:Lcom/comcast/cim/cmasl/http/request/RequestProvider;

    invoke-interface {v0, p1, p2}, Lcom/comcast/cim/cmasl/http/request/RequestProvider;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 22
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
    .line 16
    .local p0, "this":Lcom/comcast/cim/cmasl/hal/http/HalRequestProvider;, "Lcom/comcast/cim/cmasl/hal/http/HalRequestProvider<TT;>;"
    iget-object v0, p0, Lcom/comcast/cim/cmasl/hal/http/HalRequestProvider;->delegateProvider:Lcom/comcast/cim/cmasl/http/request/RequestProvider;

    invoke-interface {v0}, Lcom/comcast/cim/cmasl/http/request/RequestProvider;->createRequest()Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public setSocketTimeout(J)V
    .locals 1
    .param p1, "timeoutInMillis"    # J

    .prologue
    .line 36
    .local p0, "this":Lcom/comcast/cim/cmasl/hal/http/HalRequestProvider;, "Lcom/comcast/cim/cmasl/hal/http/HalRequestProvider<TT;>;"
    iget-object v0, p0, Lcom/comcast/cim/cmasl/hal/http/HalRequestProvider;->delegateProvider:Lcom/comcast/cim/cmasl/http/request/RequestProvider;

    invoke-interface {v0, p1, p2}, Lcom/comcast/cim/cmasl/http/request/RequestProvider;->setSocketTimeout(J)V

    .line 37
    return-void
.end method
