.class public Lcom/xfinity/playerlib/authorization/ThePlatformClient;
.super Ljava/lang/Object;
.source "ThePlatformClient.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field private final platformResponseService:Lcom/comcast/cim/cmasl/http/service/HttpService;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/http/service/HttpService",
            "<TT;",
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<TT;>;>;"
        }
    .end annotation
.end field

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
.method public constructor <init>(Lcom/comcast/cim/cmasl/http/service/HttpService;Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/http/service/HttpService",
            "<TT;",
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<TT;>;>;",
            "Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory",
            "<",
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<TT;>;>;)V"
        }
    .end annotation

    .prologue
    .line 16
    .local p0, "this":Lcom/xfinity/playerlib/authorization/ThePlatformClient;, "Lcom/xfinity/playerlib/authorization/ThePlatformClient<TT;>;"
    .local p1, "platformResponseService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<TT;Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;>;"
    .local p2, "requestProviderFactory":Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;, "Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory<Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    iput-object p1, p0, Lcom/xfinity/playerlib/authorization/ThePlatformClient;->platformResponseService:Lcom/comcast/cim/cmasl/http/service/HttpService;

    .line 18
    iput-object p2, p0, Lcom/xfinity/playerlib/authorization/ThePlatformClient;->requestProviderFactory:Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;

    .line 19
    return-void
.end method


# virtual methods
.method public getSMILResource(Ljava/lang/String;)Lcom/xfinity/playerlib/authorization/SMILResource;
    .locals 4
    .param p1, "smilUrl"    # Ljava/lang/String;

    .prologue
    .line 22
    .local p0, "this":Lcom/xfinity/playerlib/authorization/ThePlatformClient;, "Lcom/xfinity/playerlib/authorization/ThePlatformClient<TT;>;"
    iget-object v2, p0, Lcom/xfinity/playerlib/authorization/ThePlatformClient;->requestProviderFactory:Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;

    invoke-interface {v2, p1}, Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;->create(Ljava/lang/String;)Lcom/comcast/cim/cmasl/http/request/RequestProvider;

    move-result-object v1

    .line 23
    .local v1, "tpRequest":Lcom/comcast/cim/cmasl/http/request/RequestProvider;, "Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;"
    iget-object v2, p0, Lcom/xfinity/playerlib/authorization/ThePlatformClient;->platformResponseService:Lcom/comcast/cim/cmasl/http/service/HttpService;

    new-instance v3, Lcom/xfinity/playerlib/authorization/ThePlatformClient$1;

    invoke-direct {v3, p0}, Lcom/xfinity/playerlib/authorization/ThePlatformClient$1;-><init>(Lcom/xfinity/playerlib/authorization/ThePlatformClient;)V

    invoke-interface {v2, v1, v3}, Lcom/comcast/cim/cmasl/http/service/HttpService;->executeRequest(Lcom/comcast/cim/cmasl/http/request/RequestProvider;Lcom/comcast/cim/cmasl/utils/provider/Provider;)Lcom/comcast/cim/cmasl/http/response/ResponseHandler;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/authorization/ThePlatformResponseHandler;

    .line 30
    .local v0, "responseHandler":Lcom/xfinity/playerlib/authorization/ThePlatformResponseHandler;
    invoke-virtual {v0}, Lcom/xfinity/playerlib/authorization/ThePlatformResponseHandler;->getSMILResource()Lcom/xfinity/playerlib/authorization/SMILResource;

    move-result-object v2

    return-object v2
.end method
