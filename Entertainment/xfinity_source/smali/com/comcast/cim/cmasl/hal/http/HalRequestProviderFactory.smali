.class public Lcom/comcast/cim/cmasl/hal/http/HalRequestProviderFactory;
.super Ljava/lang/Object;
.source "HalRequestProviderFactory.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory",
        "<",
        "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
        "<TT;>;>;"
    }
.end annotation


# instance fields
.field private final requestProviderFactory:Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory",
            "<",
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<TT;>;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory",
            "<",
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<TT;>;>;)V"
        }
    .end annotation

    .prologue
    .line 10
    .local p0, "this":Lcom/comcast/cim/cmasl/hal/http/HalRequestProviderFactory;, "Lcom/comcast/cim/cmasl/hal/http/HalRequestProviderFactory<TT;>;"
    .local p1, "requestProviderFactory":Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;, "Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory<Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 11
    iput-object p1, p0, Lcom/comcast/cim/cmasl/hal/http/HalRequestProviderFactory;->requestProviderFactory:Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;

    .line 12
    return-void
.end method


# virtual methods
.method public create(Ljava/lang/String;)Lcom/comcast/cim/cmasl/hal/http/HalRequestProvider;
    .locals 2
    .param p1, "url"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Lcom/comcast/cim/cmasl/hal/http/HalRequestProvider",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 16
    .local p0, "this":Lcom/comcast/cim/cmasl/hal/http/HalRequestProviderFactory;, "Lcom/comcast/cim/cmasl/hal/http/HalRequestProviderFactory<TT;>;"
    new-instance v0, Lcom/comcast/cim/cmasl/hal/http/HalRequestProvider;

    iget-object v1, p0, Lcom/comcast/cim/cmasl/hal/http/HalRequestProviderFactory;->requestProviderFactory:Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;

    invoke-interface {v1, p1}, Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;->create(Ljava/lang/String;)Lcom/comcast/cim/cmasl/http/request/RequestProvider;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/comcast/cim/cmasl/hal/http/HalRequestProvider;-><init>(Lcom/comcast/cim/cmasl/http/request/RequestProvider;)V

    return-object v0
.end method

.method public bridge synthetic create(Ljava/lang/String;)Lcom/comcast/cim/cmasl/http/request/RequestProvider;
    .locals 1
    .param p1, "x0"    # Ljava/lang/String;

    .prologue
    .line 6
    .local p0, "this":Lcom/comcast/cim/cmasl/hal/http/HalRequestProviderFactory;, "Lcom/comcast/cim/cmasl/hal/http/HalRequestProviderFactory<TT;>;"
    invoke-virtual {p0, p1}, Lcom/comcast/cim/cmasl/hal/http/HalRequestProviderFactory;->create(Ljava/lang/String;)Lcom/comcast/cim/cmasl/hal/http/HalRequestProvider;

    move-result-object v0

    return-object v0
.end method

.method public create(Ljava/lang/String;Ljava/lang/String;)Lcom/comcast/cim/cmasl/http/request/RequestProvider;
    .locals 2
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "method"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")",
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 21
    .local p0, "this":Lcom/comcast/cim/cmasl/hal/http/HalRequestProviderFactory;, "Lcom/comcast/cim/cmasl/hal/http/HalRequestProviderFactory<TT;>;"
    new-instance v0, Lcom/comcast/cim/cmasl/hal/http/HalRequestProvider;

    iget-object v1, p0, Lcom/comcast/cim/cmasl/hal/http/HalRequestProviderFactory;->requestProviderFactory:Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;

    invoke-interface {v1, p1, p2}, Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;->create(Ljava/lang/String;Ljava/lang/String;)Lcom/comcast/cim/cmasl/http/request/RequestProvider;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/comcast/cim/cmasl/hal/http/HalRequestProvider;-><init>(Lcom/comcast/cim/cmasl/http/request/RequestProvider;)V

    return-object v0
.end method
