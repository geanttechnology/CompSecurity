.class public Lcom/amazon/searchapp/retailsearch/client/SimsServiceCall;
.super Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall;
.source "SimsServiceCall.java"


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
.field private final asin:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;Ljava/lang/String;)V
    .locals 6
    .param p1, "client"    # Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;
    .param p3, "asin"    # Ljava/lang/String;
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
    .line 22
    .local p2, "listener":Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;, "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener<Lcom/amazon/searchapp/retailsearch/model/SearchResult;>;"
    sget-object v0, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;->GET:Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;

    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;->getName()Ljava/lang/String;

    move-result-object v3

    const-string/jumbo v4, "/s/sims"

    const-class v5, Lcom/amazon/searchapp/retailsearch/model/SearchResult;

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    invoke-direct/range {v0 .. v5}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall;-><init>(Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;)V

    .line 23
    iput-object p3, p0, Lcom/amazon/searchapp/retailsearch/client/SimsServiceCall;->asin:Ljava/lang/String;

    .line 24
    return-void
.end method


# virtual methods
.method protected buildParameters(Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;)V
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
    .line 31
    .local p1, "parameters":Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;, "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap<Ljava/lang/String;Ljava/lang/String;>;"
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/SimsServiceCall;->asin:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 32
    sget-object v0, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->ASINS:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->getName()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/searchapp/retailsearch/client/SimsServiceCall;->asin:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->add(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 34
    :cond_0
    invoke-super {p0, p1}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall;->buildParameters(Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;)V

    .line 35
    return-void
.end method
