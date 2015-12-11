.class public Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;
.super Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;
.source "RetailSearchClient.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/client/RetailSearchClientApi;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$1;,
        Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;
    }
.end annotation


# static fields
.field private static PARSER_CLASS:Ljava/lang/String;


# instance fields
.field private final apiVersion:Ljava/lang/String;

.field private final appId:Ljava/lang/String;

.field private final clientId:Ljava/lang/String;

.field private final platform:Ljava/lang/String;

.field private final realm:Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

.field private final responseFormat:Ljava/lang/String;

.field private final weblabs:Ljava/util/Map;
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
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 52
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-class v1, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;

    invoke-virtual {v1}, Ljava/lang/Class;->getPackage()Ljava/lang/Package;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Package;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ".jackson.StandardParser"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;->PARSER_CLASS:Ljava/lang/String;

    return-void
.end method

.method private constructor <init>(Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;)V
    .locals 11
    .param p1, "builder"    # Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;

    .prologue
    .line 61
    # getter for: Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->webClientFactory:Lcom/amazon/searchapp/retailsearch/client/web/WebClientFactory;
    invoke-static {p1}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->access$000(Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;)Lcom/amazon/searchapp/retailsearch/client/web/WebClientFactory;

    move-result-object v1

    # getter for: Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->secure:Z
    invoke-static {p1}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->access$100(Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;)Z

    move-result v2

    # getter for: Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->method:Ljava/lang/String;
    invoke-static {p1}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->access$200(Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;)Ljava/lang/String;

    move-result-object v3

    # getter for: Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->baseUrl:Ljava/lang/String;
    invoke-static {p1}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->access$300(Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;)Ljava/lang/String;

    move-result-object v4

    # getter for: Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->parameters:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;
    invoke-static {p1}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->access$400(Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;)Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    move-result-object v5

    # getter for: Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->headers:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;
    invoke-static {p1}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->access$500(Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;)Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    move-result-object v6

    # getter for: Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->userAgent:Ljava/lang/String;
    invoke-static {p1}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->access$600(Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;)Ljava/lang/String;

    move-result-object v7

    # getter for: Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->cookies:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;
    invoke-static {p1}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->access$700(Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;)Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    move-result-object v8

    # getter for: Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->serviceCallInterceptor:Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallInterceptor;
    invoke-static {p1}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->access$800(Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;)Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallInterceptor;

    move-result-object v9

    # getter for: Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->objectParser:Lcom/amazon/searchapp/retailsearch/client/web/ObjectParser;
    invoke-static {p1}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->access$900(Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;)Lcom/amazon/searchapp/retailsearch/client/web/ObjectParser;

    move-result-object v10

    move-object v0, p0

    invoke-direct/range {v0 .. v10}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;-><init>(Lcom/amazon/searchapp/retailsearch/client/web/WebClientFactory;ZLjava/lang/String;Ljava/lang/String;Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;Ljava/lang/String;Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallInterceptor;Lcom/amazon/searchapp/retailsearch/client/web/ObjectParser;)V

    .line 64
    # getter for: Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->realm:Lcom/amazon/searchapp/retailsearch/client/SearchRealm;
    invoke-static {p1}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->access$1000(Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;->realm:Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    .line 65
    # getter for: Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->apiVersion:Ljava/lang/String;
    invoke-static {p1}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->access$1100(Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;)Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_0

    const-string/jumbo v0, "v0.1"

    :goto_0
    iput-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;->apiVersion:Ljava/lang/String;

    .line 66
    # getter for: Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->clientId:Ljava/lang/String;
    invoke-static {p1}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->access$1200(Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;->clientId:Ljava/lang/String;

    .line 67
    # getter for: Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->responseFormat:Ljava/lang/String;
    invoke-static {p1}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->access$1300(Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;)Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_1

    const-string/jumbo v0, "json"

    :goto_1
    iput-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;->responseFormat:Ljava/lang/String;

    .line 68
    # getter for: Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->appId:Ljava/lang/String;
    invoke-static {p1}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->access$1400(Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;->appId:Ljava/lang/String;

    .line 69
    # getter for: Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->platform:Ljava/lang/String;
    invoke-static {p1}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->access$1500(Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;->platform:Ljava/lang/String;

    .line 70
    # getter for: Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->weblabs:Ljava/util/Map;
    invoke-static {p1}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->access$1600(Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;)Ljava/util/Map;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;->weblabs:Ljava/util/Map;

    .line 71
    return-void

    .line 65
    :cond_0
    # getter for: Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->apiVersion:Ljava/lang/String;
    invoke-static {p1}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->access$1100(Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 67
    :cond_1
    # getter for: Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->responseFormat:Ljava/lang/String;
    invoke-static {p1}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->access$1300(Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;)Ljava/lang/String;

    move-result-object v0

    goto :goto_1
.end method

.method synthetic constructor <init>(Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;
    .param p2, "x1"    # Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$1;

    .prologue
    .line 23
    invoke-direct {p0, p1}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;-><init>(Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;)V

    return-void
.end method


# virtual methods
.method public assets(Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;)Lcom/amazon/searchapp/retailsearch/client/AssetsServiceCall;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/Assets;",
            ">;)",
            "Lcom/amazon/searchapp/retailsearch/client/AssetsServiceCall;"
        }
    .end annotation

    .prologue
    .line 225
    .local p1, "listener":Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;, "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener<Lcom/amazon/searchapp/retailsearch/model/Assets;>;"
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/AssetsServiceCall;

    invoke-direct {v0, p0, p1}, Lcom/amazon/searchapp/retailsearch/client/AssetsServiceCall;-><init>(Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;)V

    return-object v0
.end method

.method public buildDefaultObjectParser()Lcom/amazon/searchapp/retailsearch/client/web/ObjectParser;
    .locals 1

    .prologue
    .line 241
    sget-object v0, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;->PARSER_CLASS:Ljava/lang/String;

    invoke-static {v0}, Lcom/amazon/searchapp/retailsearch/client/util/ClassUtil;->createInstance(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/searchapp/retailsearch/client/web/ObjectParser;

    return-object v0
.end method

.method public final getApiVersion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 84
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;->apiVersion:Ljava/lang/String;

    return-object v0
.end method

.method public final getAppId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 105
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;->appId:Ljava/lang/String;

    return-object v0
.end method

.method public final getClientId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 91
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;->clientId:Ljava/lang/String;

    return-object v0
.end method

.method public final getPlatform()Ljava/lang/String;
    .locals 1

    .prologue
    .line 112
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;->platform:Ljava/lang/String;

    return-object v0
.end method

.method public final getRealm()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;
    .locals 1

    .prologue
    .line 77
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;->realm:Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    return-object v0
.end method

.method public final getResponseFormat()Ljava/lang/String;
    .locals 1

    .prologue
    .line 98
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;->responseFormat:Ljava/lang/String;

    return-object v0
.end method

.method protected final getWeblabs()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 119
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;->weblabs:Ljava/util/Map;

    return-object v0
.end method

.method public personalizedSuggestions(Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;)Lcom/amazon/searchapp/retailsearch/client/PersonalizedSuggestionsServiceCall;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestionsResult;",
            ">;)",
            "Lcom/amazon/searchapp/retailsearch/client/PersonalizedSuggestionsServiceCall;"
        }
    .end annotation

    .prologue
    .line 184
    .local p1, "listener":Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;, "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener<Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestionsResult;>;"
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/PersonalizedSuggestionsServiceCall;

    invoke-direct {v0, p0, p1}, Lcom/amazon/searchapp/retailsearch/client/PersonalizedSuggestionsServiceCall;-><init>(Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;)V

    return-object v0
.end method

.method public personalizedSuggestions(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;)Lcom/amazon/searchapp/retailsearch/client/PersonalizedSuggestionsServiceCall;
    .locals 1
    .param p1, "deleteParamR"    # Ljava/lang/String;
    .param p2, "deleteParamK"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestionsResult;",
            ">;)",
            "Lcom/amazon/searchapp/retailsearch/client/PersonalizedSuggestionsServiceCall;"
        }
    .end annotation

    .prologue
    .line 193
    .local p3, "listener":Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;, "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener<Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestionsResult;>;"
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/PersonalizedSuggestionsServiceCall;

    invoke-direct {v0, p0, p1, p2, p3}, Lcom/amazon/searchapp/retailsearch/client/PersonalizedSuggestionsServiceCall;-><init>(Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;)V

    return-object v0
.end method

.method public refinements(Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/RefinementsServiceCall;
    .locals 1
    .param p2, "path"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/SearchResult;",
            ">;",
            "Ljava/lang/String;",
            ")",
            "Lcom/amazon/searchapp/retailsearch/client/RefinementsServiceCall;"
        }
    .end annotation

    .prologue
    .line 209
    .local p1, "listener":Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;, "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener<Lcom/amazon/searchapp/retailsearch/model/SearchResult;>;"
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/RefinementsServiceCall;

    invoke-direct {v0, p0, p1, p2}, Lcom/amazon/searchapp/retailsearch/client/RefinementsServiceCall;-><init>(Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;Ljava/lang/String;)V

    return-object v0
.end method

.method public search(Lcom/amazon/searchapp/retailsearch/client/SearchRequest;Lcom/amazon/searchapp/retailsearch/client/SearchListener;)Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;
    .locals 2
    .param p1, "searchRequest"    # Lcom/amazon/searchapp/retailsearch/client/SearchRequest;
    .param p2, "listener"    # Lcom/amazon/searchapp/retailsearch/client/SearchListener;

    .prologue
    .line 135
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;

    const/4 v1, 0x0

    invoke-direct {v0, p0, p1, p2, v1}, Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;-><init>(Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;Lcom/amazon/searchapp/retailsearch/client/SearchRequest;Lcom/amazon/searchapp/retailsearch/client/SearchListener;Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall$ResponseParser;)V

    return-object v0
.end method

.method public similarities(Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SimsServiceCall;
    .locals 1
    .param p2, "asin"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/SearchResult;",
            ">;",
            "Ljava/lang/String;",
            ")",
            "Lcom/amazon/searchapp/retailsearch/client/SimsServiceCall;"
        }
    .end annotation

    .prologue
    .line 233
    .local p1, "listener":Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;, "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener<Lcom/amazon/searchapp/retailsearch/model/SearchResult;>;"
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/SimsServiceCall;

    invoke-direct {v0, p0, p1, p2}, Lcom/amazon/searchapp/retailsearch/client/SimsServiceCall;-><init>(Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;Ljava/lang/String;)V

    return-object v0
.end method
