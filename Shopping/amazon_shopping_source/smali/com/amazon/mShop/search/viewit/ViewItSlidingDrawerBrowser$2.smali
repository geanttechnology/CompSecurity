.class Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser$2;
.super Ljava/lang/Object;
.source "ViewItSlidingDrawerBrowser.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->completed(Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsResponse;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

.field final synthetic val$response:Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsResponse;

.field final synthetic val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsResponse;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0

    .prologue
    .line 393
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser$2;->this$0:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    iput-object p2, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser$2;->val$response:Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsResponse;

    iput-object p3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser$2;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 19

    .prologue
    .line 395
    new-instance v14, Ljava/util/ArrayList;

    invoke-direct {v14}, Ljava/util/ArrayList;-><init>()V

    .line 396
    .local v14, "objectReceived":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;>;"
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser$2;->val$response:Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsResponse;

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsResponse;->getProducts()Ljava/util/List;

    move-result-object v15

    .line 397
    .local v15, "productResults":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;>;"
    invoke-interface {v15}, Ljava/util/List;->size()I

    move-result v16

    .line 399
    .local v16, "productResultsSize":I
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser$2;->this$0:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mCurrentRequestDBObjects:Ljava/util/List;
    invoke-static {v1}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->access$100(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v11

    .local v11, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v11}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_5

    invoke-interface {v11}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lcom/amazon/mShop/search/viewit/ViewItDBResultWrapper;

    .line 401
    .local v8, "dbObject":Lcom/amazon/mShop/search/viewit/ViewItDBResultWrapper;
    new-instance v3, Ljava/util/Vector;

    invoke-direct {v3}, Ljava/util/Vector;-><init>()V

    .line 402
    .local v3, "resultsVector":Ljava/util/Vector;, "Ljava/util/Vector<Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;>;"
    invoke-virtual {v8}, Lcom/amazon/mShop/search/viewit/ViewItDBResultWrapper;->getAsinList()Ljava/util/List;

    move-result-object v7

    .line 403
    .local v7, "asinList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-static {v7}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v1

    if-eqz v1, :cond_2

    const/4 v9, 0x0

    .line 405
    .local v9, "dbObjectSearchResultSize":I
    :goto_1
    const/4 v10, 0x0

    .local v10, "i":I
    :goto_2
    if-ge v10, v9, :cond_4

    .line 406
    invoke-interface {v7, v10}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Ljava/lang/String;

    .line 407
    .local v13, "objectAsin":Ljava/lang/String;
    const/4 v12, 0x0

    .local v12, "j":I
    :goto_3
    move/from16 v0, v16

    if-ge v12, v0, :cond_1

    .line 408
    invoke-interface {v15, v12}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v17

    check-cast v17, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    .line 409
    .local v17, "reponse":Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    invoke-virtual/range {v17 .. v17}, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getAsin()Ljava/lang/String;

    move-result-object v18

    .line 410
    .local v18, "responseAsin":Ljava/lang/String;
    move-object/from16 v0, v18

    invoke-virtual {v13, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 411
    move-object/from16 v0, v17

    invoke-virtual {v3, v0}, Ljava/util/Vector;->add(Ljava/lang/Object;)Z

    .line 405
    .end local v17    # "reponse":Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    .end local v18    # "responseAsin":Ljava/lang/String;
    :cond_1
    add-int/lit8 v10, v10, 0x1

    goto :goto_2

    .line 403
    .end local v9    # "dbObjectSearchResultSize":I
    .end local v10    # "i":I
    .end local v12    # "j":I
    .end local v13    # "objectAsin":Ljava/lang/String;
    :cond_2
    invoke-interface {v7}, Ljava/util/List;->size()I

    move-result v9

    goto :goto_1

    .line 407
    .restart local v9    # "dbObjectSearchResultSize":I
    .restart local v10    # "i":I
    .restart local v12    # "j":I
    .restart local v13    # "objectAsin":Ljava/lang/String;
    .restart local v17    # "reponse":Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    .restart local v18    # "responseAsin":Ljava/lang/String;
    :cond_3
    add-int/lit8 v12, v12, 0x1

    goto :goto_3

    .line 417
    .end local v12    # "j":I
    .end local v13    # "objectAsin":Ljava/lang/String;
    .end local v17    # "reponse":Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    .end local v18    # "responseAsin":Ljava/lang/String;
    :cond_4
    invoke-static {v3}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 418
    new-instance v1, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;

    invoke-virtual {v8}, Lcom/amazon/mShop/search/viewit/ViewItDBResultWrapper;->getOriginalScannedOutput()Ljava/lang/String;

    move-result-object v2

    const/4 v4, 0x0

    invoke-virtual {v8}, Lcom/amazon/mShop/search/viewit/ViewItDBResultWrapper;->getScannedDate()Ljava/util/Date;

    move-result-object v5

    const/4 v6, 0x0

    invoke-direct/range {v1 .. v6}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;-><init>(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/Date;Z)V

    invoke-interface {v14, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 422
    .end local v3    # "resultsVector":Ljava/util/Vector;, "Ljava/util/Vector<Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;>;"
    .end local v7    # "asinList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v8    # "dbObject":Lcom/amazon/mShop/search/viewit/ViewItDBResultWrapper;
    .end local v9    # "dbObjectSearchResultSize":I
    .end local v10    # "i":I
    :cond_5
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser$2;->this$0:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser$2;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    invoke-virtual {v1, v14, v2}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->objectsReceived(Ljava/util/List;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    .line 423
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser$2;->this$0:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mCurrentRequestDBObjects:Ljava/util/List;
    invoke-static {v1}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->access$100(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->clear()V

    .line 424
    return-void
.end method
