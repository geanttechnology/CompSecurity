.class public Lcom/amazon/searchapp/retailsearch/client/RefinementsServiceCall;
.super Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall;
.source "RefinementsServiceCall.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall",
        "<",
        "Lcom/amazon/searchapp/retailsearch/model/SearchResult;",
        ">;"
    }
.end annotation


# instance fields
.field private collection:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;
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

.field private isPathNull:Z

.field private ref:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;Ljava/lang/String;)V
    .locals 9
    .param p1, "client"    # Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;
    .param p3, "path"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;",
            "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/SearchResult;",
            ">;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .local p2, "listener":Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;, "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener<Lcom/amazon/searchapp/retailsearch/model/SearchResult;>;"
    const/4 v8, 0x1

    .line 40
    sget-object v0, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;->GET:Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;

    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;->getName()Ljava/lang/String;

    move-result-object v3

    const-string/jumbo v4, "/s/browse"

    const-class v5, Lcom/amazon/searchapp/retailsearch/model/SearchResult;

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    invoke-direct/range {v0 .. v5}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall;-><init>(Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;)V

    .line 41
    if-eqz p3, :cond_1

    .line 43
    :try_start_0
    new-instance v7, Ljava/net/URI;

    invoke-direct {v7, p3}, Ljava/net/URI;-><init>(Ljava/lang/String;)V

    .line 44
    .local v7, "uri":Ljava/net/URI;
    invoke-virtual {v7}, Ljava/net/URI;->getQuery()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;->parseQuery(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/RefinementsServiceCall;->collection:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    .line 45
    invoke-virtual {v7}, Ljava/net/URI;->getPath()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "="

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 46
    invoke-virtual {v7}, Ljava/net/URI;->getPath()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "="

    invoke-virtual {v0, v1}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x1

    aget-object v0, v0, v1

    iput-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/RefinementsServiceCall;->ref:Ljava/lang/String;
    :try_end_0
    .catch Ljava/net/URISyntaxException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_1

    .line 55
    .end local v7    # "uri":Ljava/net/URI;
    :goto_0
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/searchapp/retailsearch/client/RefinementsServiceCall;->isPathNull:Z

    .line 59
    :goto_1
    return-void

    .line 48
    .restart local v7    # "uri":Ljava/net/URI;
    :cond_0
    const/4 v0, 0x0

    :try_start_1
    iput-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/RefinementsServiceCall;->ref:Ljava/lang/String;
    :try_end_1
    .catch Ljava/net/URISyntaxException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_0

    .line 50
    .end local v7    # "uri":Ljava/net/URI;
    :catch_0
    move-exception v6

    .line 51
    .local v6, "e":Ljava/net/URISyntaxException;
    invoke-virtual {v6}, Ljava/net/URISyntaxException;->printStackTrace()V

    goto :goto_0

    .line 52
    .end local v6    # "e":Ljava/net/URISyntaxException;
    :catch_1
    move-exception v6

    .line 53
    .local v6, "e":Ljava/io/UnsupportedEncodingException;
    invoke-virtual {v6}, Ljava/io/UnsupportedEncodingException;->printStackTrace()V

    goto :goto_0

    .line 57
    .end local v6    # "e":Ljava/io/UnsupportedEncodingException;
    :cond_1
    iput-boolean v8, p0, Lcom/amazon/searchapp/retailsearch/client/RefinementsServiceCall;->isPathNull:Z

    goto :goto_1
.end method


# virtual methods
.method protected buildParameters(Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;)V
    .locals 4
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
    .line 66
    .local p1, "parameters":Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;, "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap<Ljava/lang/String;Ljava/lang/String;>;"
    iget-boolean v2, p0, Lcom/amazon/searchapp/retailsearch/client/RefinementsServiceCall;->isPathNull:Z

    if-nez v2, :cond_1

    .line 67
    iget-object v2, p0, Lcom/amazon/searchapp/retailsearch/client/RefinementsServiceCall;->collection:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    invoke-virtual {v2}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->entrySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 68
    .local v0, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/List;

    invoke-virtual {p1, v3, v2}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->set(Ljava/lang/Object;Ljava/util/List;)V

    goto :goto_0

    .line 70
    .end local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    :cond_0
    iget-object v2, p0, Lcom/amazon/searchapp/retailsearch/client/RefinementsServiceCall;->ref:Ljava/lang/String;

    if-eqz v2, :cond_1

    .line 71
    const-string/jumbo v2, "ref"

    iget-object v3, p0, Lcom/amazon/searchapp/retailsearch/client/RefinementsServiceCall;->ref:Ljava/lang/String;

    invoke-virtual {p1, v2, v3}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 74
    .end local v1    # "i$":Ljava/util/Iterator;
    :cond_1
    invoke-super {p0, p1}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall;->buildParameters(Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;)V

    .line 75
    return-void
.end method
