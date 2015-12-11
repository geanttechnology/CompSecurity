.class public Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;
.super Ljava/lang/Object;
.source "HalHttpClient.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        "RQ::",
        "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
        "<TT;>;>",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field private final halHttpService:Lcom/comcast/cim/cmasl/http/service/HttpService;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/http/service/HttpService",
            "<TT;TRQ;>;"
        }
    .end annotation
.end field

.field private final hypermediaClient:Lcom/comcast/cim/microdata/client/HypermediaClient;

.field private final requestProviderFactory:Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory",
            "<TRQ;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/comcast/cim/cmasl/http/service/HttpService;Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;Lcom/comcast/cim/microdata/client/HypermediaClient;)V
    .locals 0
    .param p3, "hypermediaClient"    # Lcom/comcast/cim/microdata/client/HypermediaClient;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/http/service/HttpService",
            "<TT;TRQ;>;",
            "Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory",
            "<TRQ;>;",
            "Lcom/comcast/cim/microdata/client/HypermediaClient;",
            ")V"
        }
    .end annotation

    .prologue
    .line 15
    .local p0, "this":Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;, "Lcom/comcast/cim/cmasl/hal/http/HalHttpClient<TT;TRQ;>;"
    .local p1, "halHttpService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<TT;TRQ;>;"
    .local p2, "requestProviderFactory":Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;, "Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory<TRQ;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    iput-object p1, p0, Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;->halHttpService:Lcom/comcast/cim/cmasl/http/service/HttpService;

    .line 17
    iput-object p2, p0, Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;->requestProviderFactory:Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;

    .line 18
    iput-object p3, p0, Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;->hypermediaClient:Lcom/comcast/cim/microdata/client/HypermediaClient;

    .line 19
    return-void
.end method

.method static synthetic access$000(Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;)Lcom/comcast/cim/microdata/client/HypermediaClient;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;

    .prologue
    .line 10
    iget-object v0, p0, Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;->hypermediaClient:Lcom/comcast/cim/microdata/client/HypermediaClient;

    return-object v0
.end method


# virtual methods
.method public fetchMicroData(Ljava/lang/String;)Lcom/comcast/cim/microdata/model/MicrodataItem;
    .locals 4
    .param p1, "halSource"    # Ljava/lang/String;

    .prologue
    .line 22
    .local p0, "this":Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;, "Lcom/comcast/cim/cmasl/hal/http/HalHttpClient<TT;TRQ;>;"
    iget-object v1, p0, Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;->halHttpService:Lcom/comcast/cim/cmasl/http/service/HttpService;

    iget-object v2, p0, Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;->requestProviderFactory:Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;

    invoke-interface {v2, p1}, Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;->create(Ljava/lang/String;)Lcom/comcast/cim/cmasl/http/request/RequestProvider;

    move-result-object v2

    new-instance v3, Lcom/comcast/cim/cmasl/hal/http/HalHttpClient$1;

    invoke-direct {v3, p0, p1}, Lcom/comcast/cim/cmasl/hal/http/HalHttpClient$1;-><init>(Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;Ljava/lang/String;)V

    invoke-interface {v1, v2, v3}, Lcom/comcast/cim/cmasl/http/service/HttpService;->executeRequest(Lcom/comcast/cim/cmasl/http/request/RequestProvider;Lcom/comcast/cim/cmasl/utils/provider/Provider;)Lcom/comcast/cim/cmasl/http/response/ResponseHandler;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/cmasl/hal/http/HalResponseHandler;

    .line 27
    .local v0, "responseHandler":Lcom/comcast/cim/cmasl/hal/http/HalResponseHandler;
    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/hal/http/HalResponseHandler;->getMicrodataResource()Lcom/comcast/cim/microdata/model/MicrodataItem;

    move-result-object v1

    return-object v1
.end method
