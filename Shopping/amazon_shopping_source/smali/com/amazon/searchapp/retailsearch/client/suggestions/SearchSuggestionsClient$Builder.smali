.class public Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;
.super Ljava/lang/Object;
.source "SearchSuggestionsClient.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
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

.field private realm:Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

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
    .line 166
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 128
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;->secure:Z

    .line 167
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;)Lcom/amazon/searchapp/retailsearch/client/web/WebClientFactory;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;

    .prologue
    .line 120
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;->webClientFactory:Lcom/amazon/searchapp/retailsearch/client/web/WebClientFactory;

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;

    .prologue
    .line 120
    iget-boolean v0, p0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;->secure:Z

    return v0
.end method

.method static synthetic access$1000(Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;

    .prologue
    .line 120
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;->realm:Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    return-object v0
.end method

.method static synthetic access$1100(Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;

    .prologue
    .line 120
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;->clientId:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$1200(Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;)Ljava/util/Map;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;

    .prologue
    .line 120
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;->weblabs:Ljava/util/Map;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;

    .prologue
    .line 120
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;->method:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$300(Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;

    .prologue
    .line 120
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;->baseUrl:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$400(Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;)Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;

    .prologue
    .line 120
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;->parameters:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    return-object v0
.end method

.method static synthetic access$500(Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;)Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;

    .prologue
    .line 120
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;->headers:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    return-object v0
.end method

.method static synthetic access$600(Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;

    .prologue
    .line 120
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;->userAgent:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$700(Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;)Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;

    .prologue
    .line 120
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;->cookies:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    return-object v0
.end method

.method static synthetic access$800(Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;)Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallInterceptor;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;

    .prologue
    .line 120
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;->serviceCallInterceptor:Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallInterceptor;

    return-object v0
.end method

.method static synthetic access$900(Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;)Lcom/amazon/searchapp/retailsearch/client/web/ObjectParser;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;

    .prologue
    .line 120
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;->objectParser:Lcom/amazon/searchapp/retailsearch/client/web/ObjectParser;

    return-object v0
.end method


# virtual methods
.method public build()Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient;
    .locals 2

    .prologue
    .line 417
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;->webClientFactory:Lcom/amazon/searchapp/retailsearch/client/web/WebClientFactory;

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;->webClient:Lcom/amazon/searchapp/retailsearch/client/web/WebClient;

    if-eqz v0, :cond_0

    .line 418
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;->webClient:Lcom/amazon/searchapp/retailsearch/client/web/WebClient;

    invoke-static {v0}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;->createWebClientFactory(Lcom/amazon/searchapp/retailsearch/client/web/WebClient;)Lcom/amazon/searchapp/retailsearch/client/web/WebClientFactory;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;->webClientFactory:Lcom/amazon/searchapp/retailsearch/client/web/WebClientFactory;

    .line 421
    :cond_0
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;->realm:Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    if-nez v0, :cond_1

    .line 422
    invoke-static {}, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;->getConfiguration()Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;->getRealm()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;->realm:Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    .line 425
    :cond_1
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;->baseUrl:Ljava/lang/String;

    if-nez v0, :cond_2

    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;->realm:Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    if-eqz v0, :cond_2

    .line 426
    iget-boolean v0, p0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;->secure:Z

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;->realm:Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm;->getSecureCompletionServiceUrl()Ljava/lang/String;

    move-result-object v0

    :goto_0
    iput-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;->baseUrl:Ljava/lang/String;

    .line 429
    :cond_2
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient;-><init>(Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$1;)V

    return-object v0

    .line 426
    :cond_3
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;->realm:Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm;->getCompletionServiceUrl()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public setClientId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;
    .locals 0
    .param p1, "clientId"    # Ljava/lang/String;

    .prologue
    .line 391
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;->clientId:Ljava/lang/String;

    .line 392
    return-object p0
.end method

.method public setWebClient(Lcom/amazon/searchapp/retailsearch/client/web/WebClient;)Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;
    .locals 0
    .param p1, "webClient"    # Lcom/amazon/searchapp/retailsearch/client/web/WebClient;

    .prologue
    .line 197
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;->webClient:Lcom/amazon/searchapp/retailsearch/client/web/WebClient;

    .line 198
    return-object p0
.end method
