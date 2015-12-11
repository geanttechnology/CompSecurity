.class public Lcom/amazon/searchapp/retailsearch/client/AssetsServiceCall;
.super Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall;
.source "AssetsServiceCall.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall",
        "<",
        "Lcom/amazon/searchapp/retailsearch/model/Assets;",
        ">;"
    }
.end annotation


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
            "Lcom/amazon/searchapp/retailsearch/model/Assets;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 28
    .local p2, "listener":Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;, "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener<Lcom/amazon/searchapp/retailsearch/model/Assets;>;"
    sget-object v0, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;->GET:Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;

    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;->getName()Ljava/lang/String;

    move-result-object v3

    const-string/jumbo v4, "/s/assets/"

    const-class v5, Lcom/amazon/searchapp/retailsearch/model/Assets;

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    invoke-direct/range {v0 .. v5}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall;-><init>(Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;)V

    .line 29
    return-void
.end method
