.class public Lcom/amazon/searchapp/retailsearch/client/PersonalizedSuggestionsServiceCall;
.super Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall;
.source "PersonalizedSuggestionsServiceCall.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall",
        "<",
        "Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestionsResult;",
        ">;"
    }
.end annotation


# instance fields
.field private deleteParamK:Ljava/lang/String;

.field private deleteParamR:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;)V
    .locals 6
    .param p1, "client"    # Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;",
            "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestionsResult;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 32
    .local p2, "listener":Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;, "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener<Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestionsResult;>;"
    sget-object v0, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;->GET:Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;

    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;->getName()Ljava/lang/String;

    move-result-object v3

    const-string/jumbo v4, "/s/suggestions"

    const-class v5, Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestionsResult;

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    invoke-direct/range {v0 .. v5}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall;-><init>(Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;)V

    .line 34
    return-void
.end method

.method public constructor <init>(Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;)V
    .locals 6
    .param p1, "client"    # Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;
    .param p2, "deleteParamR"    # Ljava/lang/String;
    .param p3, "deleteParamK"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestionsResult;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 47
    .local p4, "listener":Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;, "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener<Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestionsResult;>;"
    sget-object v0, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;->GET:Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;

    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;->getName()Ljava/lang/String;

    move-result-object v3

    const-string/jumbo v4, "/s/suggestions"

    const-class v5, Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestionsResult;

    move-object v0, p0

    move-object v1, p1

    move-object v2, p4

    invoke-direct/range {v0 .. v5}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall;-><init>(Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;)V

    .line 49
    iput-object p2, p0, Lcom/amazon/searchapp/retailsearch/client/PersonalizedSuggestionsServiceCall;->deleteParamR:Ljava/lang/String;

    .line 50
    iput-object p3, p0, Lcom/amazon/searchapp/retailsearch/client/PersonalizedSuggestionsServiceCall;->deleteParamK:Ljava/lang/String;

    .line 51
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
    .line 59
    .local p1, "parameters":Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;, "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap<Ljava/lang/String;Ljava/lang/String;>;"
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/PersonalizedSuggestionsServiceCall;->deleteParamR:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 61
    const-string/jumbo v0, "r"

    iget-object v1, p0, Lcom/amazon/searchapp/retailsearch/client/PersonalizedSuggestionsServiceCall;->deleteParamR:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 63
    :cond_0
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/PersonalizedSuggestionsServiceCall;->deleteParamK:Ljava/lang/String;

    if-eqz v0, :cond_1

    .line 65
    const-string/jumbo v0, "k"

    iget-object v1, p0, Lcom/amazon/searchapp/retailsearch/client/PersonalizedSuggestionsServiceCall;->deleteParamK:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 68
    :cond_1
    invoke-super {p0, p1}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall;->buildParameters(Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;)V

    .line 69
    return-void
.end method
