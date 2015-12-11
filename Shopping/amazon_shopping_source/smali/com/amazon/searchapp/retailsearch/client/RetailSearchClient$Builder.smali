.class public Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;
.super Ljava/lang/Object;
.source "RetailSearchClient.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field private apiVersion:Ljava/lang/String;

.field private appId:Ljava/lang/String;

.field private baseUrl:Ljava/lang/String;

.field private clientId:Ljava/lang/String;

.field private cookies:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private headers:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private method:Ljava/lang/String;

.field private objectParser:Lcom/amazon/searchapp/retailsearch/client/web/ObjectParser;

.field private parameters:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private platform:Ljava/lang/String;

.field private realm:Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

.field private responseFormat:Ljava/lang/String;

.field private secure:Z

.field private serviceCallInterceptor:Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallInterceptor;

.field private userAgent:Ljava/lang/String;

.field private webClient:Lcom/amazon/searchapp/retailsearch/client/web/WebClient;

.field private webClientFactory:Lcom/amazon/searchapp/retailsearch/client/web/WebClientFactory;

.field private weblabs:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 339
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 289
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->secure:Z

    .line 340
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;)Lcom/amazon/searchapp/retailsearch/client/web/WebClientFactory;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;

    .prologue
    .line 281
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->webClientFactory:Lcom/amazon/searchapp/retailsearch/client/web/WebClientFactory;

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;

    .prologue
    .line 281
    iget-boolean v0, p0, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->secure:Z

    return v0
.end method

.method static synthetic access$1000(Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;

    .prologue
    .line 281
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->realm:Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    return-object v0
.end method

.method static synthetic access$1100(Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;

    .prologue
    .line 281
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->apiVersion:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$1200(Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;

    .prologue
    .line 281
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->clientId:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$1300(Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;

    .prologue
    .line 281
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->responseFormat:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$1400(Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;

    .prologue
    .line 281
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->appId:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$1500(Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;

    .prologue
    .line 281
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->platform:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$1600(Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;)Ljava/util/Map;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;

    .prologue
    .line 281
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->weblabs:Ljava/util/Map;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;

    .prologue
    .line 281
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->method:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$300(Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;

    .prologue
    .line 281
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->baseUrl:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$400(Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;)Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;

    .prologue
    .line 281
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->parameters:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    return-object v0
.end method

.method static synthetic access$500(Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;)Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;

    .prologue
    .line 281
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->headers:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    return-object v0
.end method

.method static synthetic access$600(Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;

    .prologue
    .line 281
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->userAgent:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$700(Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;)Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;

    .prologue
    .line 281
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->cookies:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    return-object v0
.end method

.method static synthetic access$800(Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;)Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallInterceptor;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;

    .prologue
    .line 281
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->serviceCallInterceptor:Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallInterceptor;

    return-object v0
.end method

.method static synthetic access$900(Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;)Lcom/amazon/searchapp/retailsearch/client/web/ObjectParser;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;

    .prologue
    .line 281
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->objectParser:Lcom/amazon/searchapp/retailsearch/client/web/ObjectParser;

    return-object v0
.end method


# virtual methods
.method public build()Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;
    .locals 2

    .prologue
    .line 705
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->webClientFactory:Lcom/amazon/searchapp/retailsearch/client/web/WebClientFactory;

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->webClient:Lcom/amazon/searchapp/retailsearch/client/web/WebClient;

    if-eqz v0, :cond_0

    .line 706
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->webClient:Lcom/amazon/searchapp/retailsearch/client/web/WebClient;

    invoke-static {v0}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;->createWebClientFactory(Lcom/amazon/searchapp/retailsearch/client/web/WebClient;)Lcom/amazon/searchapp/retailsearch/client/web/WebClientFactory;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->webClientFactory:Lcom/amazon/searchapp/retailsearch/client/web/WebClientFactory;

    .line 709
    :cond_0
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->realm:Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    if-nez v0, :cond_1

    .line 710
    invoke-static {}, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;->getConfiguration()Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;->getRealm()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->realm:Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    .line 713
    :cond_1
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->baseUrl:Ljava/lang/String;

    if-nez v0, :cond_2

    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->realm:Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    if-eqz v0, :cond_2

    .line 714
    iget-boolean v0, p0, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->secure:Z

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->realm:Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm;->getSecureSearchServiceUrl()Ljava/lang/String;

    move-result-object v0

    :goto_0
    iput-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->baseUrl:Ljava/lang/String;

    .line 717
    :cond_2
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;-><init>(Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$1;)V

    return-object v0

    .line 714
    :cond_3
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->realm:Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm;->getSearchServiceUrl()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public setClientId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;
    .locals 0
    .param p1, "clientId"    # Ljava/lang/String;

    .prologue
    .line 620
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->clientId:Ljava/lang/String;

    .line 621
    return-object p0
.end method

.method public setServiceCallInterceptor(Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallInterceptor;)Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;
    .locals 0
    .param p1, "serviceCallInterceptor"    # Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallInterceptor;

    .prologue
    .line 556
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->serviceCallInterceptor:Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallInterceptor;

    .line 557
    return-object p0
.end method

.method public setUserAgent(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;
    .locals 0
    .param p1, "userAgent"    # Ljava/lang/String;

    .prologue
    .line 515
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->userAgent:Ljava/lang/String;

    .line 516
    return-object p0
.end method

.method public setWebClientFactory(Lcom/amazon/searchapp/retailsearch/client/web/WebClientFactory;)Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;
    .locals 0
    .param p1, "webClientFactory"    # Lcom/amazon/searchapp/retailsearch/client/web/WebClientFactory;

    .prologue
    .line 394
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->webClientFactory:Lcom/amazon/searchapp/retailsearch/client/web/WebClientFactory;

    .line 395
    return-object p0
.end method
