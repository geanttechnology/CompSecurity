.class public abstract Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall;
.super Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;
.source "RetailSearchServiceCall.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<TResult:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall",
        "<TTResult;>;"
    }
.end annotation


# instance fields
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
.method protected constructor <init>(Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;)V
    .locals 1
    .param p1, "client"    # Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;
    .param p3, "method"    # Ljava/lang/String;
    .param p4, "path"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;",
            "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener",
            "<TTResult;>;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/Class",
            "<TTResult;>;)V"
        }
    .end annotation

    .prologue
    .line 45
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall;, "Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall<TTResult;>;"
    .local p2, "listener":Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;, "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener<TTResult;>;"
    .local p5, "resultClass":Ljava/lang/Class;, "Ljava/lang/Class<TTResult;>;"
    invoke-direct/range {p0 .. p5}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;-><init>(Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;)V

    .line 22
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall;->weblabs:Ljava/util/Map;

    .line 46
    return-void
.end method


# virtual methods
.method protected final addApiParameters(Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 128
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall;, "Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall<TTResult;>;"
    .local p1, "parameters":Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;, "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-virtual {p0}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall;->getClient()Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;

    move-result-object v0

    .line 130
    .local v0, "searchClient":Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;
    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;->getApiVersion()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 131
    sget-object v1, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->API_VERSION:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    invoke-virtual {v1}, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;->getApiVersion()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v1, v2}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->add(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 135
    :cond_0
    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;->getClientId()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_1

    .line 136
    sget-object v1, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->CLIENT_ID:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    invoke-virtual {v1}, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;->getClientId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v1, v2}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->add(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 140
    :cond_1
    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;->getResponseFormat()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_2

    .line 141
    sget-object v1, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->RESPONSE_FORMAT:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    invoke-virtual {v1}, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;->getResponseFormat()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v1, v2}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->add(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 147
    :cond_2
    sget-object v1, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->CLIENT_REQUEST_ID:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    invoke-virtual {v1}, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->getName()Ljava/lang/String;

    move-result-object v1

    const/16 v2, 0x10

    invoke-static {v2}, Lcom/amazon/searchapp/retailsearch/client/RandomStringUtil;->generate(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v1, v2}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 148
    return-void
.end method

.method protected final addEncodingParameters(Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 107
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall;, "Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall<TTResult;>;"
    .local p1, "parameters":Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;, "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-virtual {p0}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall;->getClient()Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;

    move-result-object v0

    .line 109
    .local v0, "searchClient":Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;
    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;->getRealm()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v1

    if-nez v1, :cond_1

    .line 122
    :cond_0
    :goto_0
    return-void

    .line 113
    :cond_1
    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;->getRealm()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm;->getEncodingParam()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_2

    .line 114
    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;->getRealm()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm;->getEncodingParam()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;->getRealm()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm;->getEncodingValue()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v1, v2}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 118
    :cond_2
    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;->getRealm()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm;->getInputEncoding()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 119
    sget-object v1, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->IE:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    invoke-virtual {v1}, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;->getRealm()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm;->getInputEncoding()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v1, v2}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    goto :goto_0
.end method

.method protected buildHeaders(Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 168
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall;, "Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall<TTResult;>;"
    .local p1, "headers":Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;, "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-super {p0, p1}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->buildHeaders(Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;)V

    .line 170
    invoke-virtual {p0}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall;->getClient()Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;->getClientId()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 171
    sget-object v0, Lcom/amazon/searchapp/retailsearch/client/SearchHeaderName;->CLIENT_ID:Lcom/amazon/searchapp/retailsearch/client/SearchHeaderName;

    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/SearchHeaderName;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall;->getClient()Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;->getClientId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 174
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall;->getClient()Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;->getAppId()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 175
    sget-object v0, Lcom/amazon/searchapp/retailsearch/client/SearchHeaderName;->APP_ID:Lcom/amazon/searchapp/retailsearch/client/SearchHeaderName;

    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/SearchHeaderName;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall;->getClient()Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;->getAppId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 178
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall;->getClient()Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;->getPlatform()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_2

    .line 179
    sget-object v0, Lcom/amazon/searchapp/retailsearch/client/SearchHeaderName;->PLATFORM:Lcom/amazon/searchapp/retailsearch/client/SearchHeaderName;

    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/SearchHeaderName;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall;->getClient()Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;->getPlatform()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 181
    :cond_2
    return-void
.end method

.method protected buildParameters(Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 99
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall;, "Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall<TTResult;>;"
    .local p1, "parameters":Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;, "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-virtual {p0, p1}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall;->addEncodingParameters(Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;)V

    .line 100
    invoke-virtual {p0, p1}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall;->addApiParameters(Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;)V

    .line 101
    return-void
.end method

.method protected buildServiceCall()V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 79
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall;, "Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall<TTResult;>;"
    invoke-super {p0}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->buildServiceCall()V

    .line 81
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 83
    .local v0, "allWeblabs":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-virtual {p0}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall;->getClient()Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;->getWeblabs()Ljava/util/Map;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 84
    invoke-virtual {p0}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall;->getClient()Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;->getWeblabs()Ljava/util/Map;

    move-result-object v2

    invoke-interface {v0, v2}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 87
    :cond_0
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 88
    .local v1, "requestWeblabs":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-virtual {p0, v1}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall;->buildWeblabs(Ljava/util/Map;)V

    .line 89
    invoke-interface {v0, v1}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 90
    iget-object v2, p0, Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall;->weblabs:Ljava/util/Map;

    invoke-interface {v0, v2}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 91
    iput-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall;->weblabs:Ljava/util/Map;

    .line 92
    return-void
.end method

.method protected buildWebRequest()Lcom/amazon/searchapp/retailsearch/client/web/WebRequest;
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 188
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall;, "Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall<TTResult;>;"
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall;->weblabs:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    invoke-virtual {p0}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall;->getCookies()Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    move-result-object v0

    invoke-static {}, Lcom/amazon/searchapp/retailsearch/client/WeblabUtil;->getWeblabCookieName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 189
    invoke-virtual {p0}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall;->getCookies()Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    move-result-object v0

    invoke-static {}, Lcom/amazon/searchapp/retailsearch/client/WeblabUtil;->getWeblabCookieName()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall;->weblabs:Ljava/util/Map;

    invoke-static {v2}, Lcom/amazon/searchapp/retailsearch/client/WeblabUtil;->createWeblabCookie(Ljava/util/Map;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 192
    :cond_0
    invoke-super {p0}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->buildWebRequest()Lcom/amazon/searchapp/retailsearch/client/web/WebRequest;

    move-result-object v0

    return-object v0
.end method

.method protected buildWeblabs(Ljava/util/Map;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 156
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall;, "Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall<TTResult;>;"
    .local p1, "weblabs":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-virtual {p0}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall;->getClient()Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;->getSecure()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 157
    const-string/jumbo v0, "SEARCH_27665"

    const-string/jumbo v1, "T1"

    invoke-interface {p1, v0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 159
    :cond_0
    return-void
.end method

.method protected getClient()Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;
    .locals 1

    .prologue
    .line 53
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall;, "Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall<TTResult;>;"
    invoke-super {p0}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->getClient()Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;

    move-result-object v0

    check-cast v0, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;

    return-object v0
.end method

.method protected bridge synthetic getClient()Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;
    .locals 1

    .prologue
    .line 20
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall;, "Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall<TTResult;>;"
    invoke-virtual {p0}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall;->getClient()Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;

    move-result-object v0

    return-object v0
.end method
