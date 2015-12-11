.class public Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient;
.super Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;
.source "SearchSuggestionsClient.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClientApi;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$1;,
        Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;
    }
.end annotation


# instance fields
.field private final clientId:Ljava/lang/String;

.field private final realm:Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

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
.method private constructor <init>(Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;)V
    .locals 11
    .param p1, "builder"    # Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;

    .prologue
    .line 36
    # getter for: Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;->webClientFactory:Lcom/amazon/searchapp/retailsearch/client/web/WebClientFactory;
    invoke-static {p1}, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;->access$000(Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;)Lcom/amazon/searchapp/retailsearch/client/web/WebClientFactory;

    move-result-object v1

    # getter for: Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;->secure:Z
    invoke-static {p1}, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;->access$100(Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;)Z

    move-result v2

    # getter for: Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;->method:Ljava/lang/String;
    invoke-static {p1}, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;->access$200(Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;)Ljava/lang/String;

    move-result-object v3

    # getter for: Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;->baseUrl:Ljava/lang/String;
    invoke-static {p1}, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;->access$300(Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;)Ljava/lang/String;

    move-result-object v4

    # getter for: Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;->parameters:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;
    invoke-static {p1}, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;->access$400(Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;)Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    move-result-object v5

    # getter for: Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;->headers:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;
    invoke-static {p1}, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;->access$500(Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;)Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    move-result-object v6

    # getter for: Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;->userAgent:Ljava/lang/String;
    invoke-static {p1}, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;->access$600(Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;)Ljava/lang/String;

    move-result-object v7

    # getter for: Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;->cookies:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;
    invoke-static {p1}, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;->access$700(Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;)Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    move-result-object v8

    # getter for: Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;->serviceCallInterceptor:Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallInterceptor;
    invoke-static {p1}, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;->access$800(Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;)Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallInterceptor;

    move-result-object v9

    # getter for: Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;->objectParser:Lcom/amazon/searchapp/retailsearch/client/web/ObjectParser;
    invoke-static {p1}, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;->access$900(Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;)Lcom/amazon/searchapp/retailsearch/client/web/ObjectParser;

    move-result-object v10

    move-object v0, p0

    invoke-direct/range {v0 .. v10}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;-><init>(Lcom/amazon/searchapp/retailsearch/client/web/WebClientFactory;ZLjava/lang/String;Ljava/lang/String;Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;Ljava/lang/String;Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallInterceptor;Lcom/amazon/searchapp/retailsearch/client/web/ObjectParser;)V

    .line 39
    # getter for: Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;->realm:Lcom/amazon/searchapp/retailsearch/client/SearchRealm;
    invoke-static {p1}, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;->access$1000(Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient;->realm:Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    .line 40
    # getter for: Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;->clientId:Ljava/lang/String;
    invoke-static {p1}, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;->access$1100(Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient;->clientId:Ljava/lang/String;

    .line 41
    # getter for: Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;->weblabs:Ljava/util/Map;
    invoke-static {p1}, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;->access$1200(Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;)Ljava/util/Map;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient;->weblabs:Ljava/util/Map;

    .line 42
    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;
    .param p2, "x1"    # Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$1;

    .prologue
    .line 20
    invoke-direct {p0, p1}, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient;-><init>(Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient$Builder;)V

    return-void
.end method


# virtual methods
.method protected final getClientId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient;->clientId:Ljava/lang/String;

    return-object v0
.end method

.method protected final getRealm()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient;->realm:Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    return-object v0
.end method

.method public searchSuggestions(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsListener;)Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsServiceCall;
    .locals 4
    .param p1, "searchAlias"    # Ljava/lang/String;
    .param p2, "queryPrefix"    # Ljava/lang/String;
    .param p3, "listener"    # Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsListener;

    .prologue
    .line 106
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsRequest$Builder;

    invoke-direct {v0, p2}, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsRequest$Builder;-><init>(Ljava/lang/String;)V

    .line 107
    .local v0, "builder":Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsRequest$Builder;
    if-eqz p1, :cond_0

    const-string/jumbo v1, ""

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 109
    invoke-virtual {v0, p1}, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsRequest$Builder;->setSearchAlias(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsRequest$Builder;

    .line 111
    :cond_0
    new-instance v1, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsServiceCall;

    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsRequest$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsRequest;

    move-result-object v2

    const/4 v3, 0x0

    invoke-direct {v1, p0, v2, p3, v3}, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsServiceCall;-><init>(Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsClient;Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsRequest;Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsListener;Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsServiceCall$ResponseParser;)V

    return-object v1
.end method
