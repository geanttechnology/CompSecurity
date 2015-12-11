.class public Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;
.super Lcom/amazon/mShop/search/viewit/ResultWrapper;
.source "ViewItSearchResultWrapper.java"


# instance fields
.field private mDeletedAsin:Ljava/lang/String;

.field private mIsRecentlyScanned:Z

.field private mSearchResults:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/Date;Z)V
    .locals 1
    .param p1, "originalScannedOutput"    # Ljava/lang/String;
    .param p3, "deletedAsin"    # Ljava/lang/String;
    .param p4, "scannedDate"    # Ljava/util/Date;
    .param p5, "recentlyScanned"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;",
            ">;",
            "Ljava/lang/String;",
            "Ljava/util/Date;",
            "Z)V"
        }
    .end annotation

    .prologue
    .line 81
    .local p2, "results":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;>;"
    invoke-direct {p0, p1, p4}, Lcom/amazon/mShop/search/viewit/ResultWrapper;-><init>(Ljava/lang/String;Ljava/util/Date;)V

    .line 71
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->mIsRecentlyScanned:Z

    .line 83
    iput-object p2, p0, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->mSearchResults:Ljava/util/List;

    .line 84
    iput-object p3, p0, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->mDeletedAsin:Ljava/lang/String;

    .line 85
    iput-boolean p5, p0, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->mIsRecentlyScanned:Z

    .line 86
    return-void
.end method


# virtual methods
.method public getAsinList()Ljava/util/List;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 90
    const/4 v0, 0x0

    .line 91
    .local v0, "asinList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->mSearchResults:Ljava/util/List;

    invoke-static {v3}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 92
    new-instance v0, Ljava/util/ArrayList;

    .end local v0    # "asinList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 93
    .restart local v0    # "asinList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->mSearchResults:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    .line 94
    .local v2, "result":Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getAsin()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 97
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v2    # "result":Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    :cond_0
    return-object v0
.end method

.method public getDeletedAsin()Ljava/lang/String;
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->mDeletedAsin:Ljava/lang/String;

    return-object v0
.end method

.method public getLatestScannedOutput(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "asinString"    # Ljava/lang/String;

    .prologue
    .line 31
    const/4 v0, 0x0

    .line 32
    .local v0, "seriesAsinString":Ljava/lang/String;
    invoke-static {p1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 33
    move-object v0, p1

    .line 38
    :goto_0
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_2

    .line 39
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->getResultType()Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;

    move-result-object v1

    sget-object v2, Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;->IMAGE:Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 40
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->getResultType()Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;->getTypeValue()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 45
    :goto_1
    return-object v1

    .line 35
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->getSeriesAsinString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 42
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->getOriginalScannedOutput()Ljava/lang/String;

    move-result-object v1

    goto :goto_1

    .line 45
    :cond_2
    const/4 v1, 0x0

    goto :goto_1
.end method

.method public getSearchResults()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;",
            ">;"
        }
    .end annotation

    .prologue
    .line 54
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->mSearchResults:Ljava/util/List;

    return-object v0
.end method

.method public getSeriesAsinString()Ljava/lang/String;
    .locals 5

    .prologue
    .line 102
    const/4 v2, 0x0

    .line 103
    .local v2, "seriesAsinString":Ljava/lang/String;
    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->mSearchResults:Ljava/util/List;

    invoke-static {v3}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 104
    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->mSearchResults:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    .line 105
    .local v1, "item":Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    if-eqz v2, :cond_0

    .line 106
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, ","

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getAsin()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 108
    :cond_0
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getAsin()Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 113
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "item":Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    :cond_1
    return-object v2
.end method

.method public isRecentlyScanned()Z
    .locals 1

    .prologue
    .line 73
    iget-boolean v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->mIsRecentlyScanned:Z

    return v0
.end method

.method public setDeletedAsin(Ljava/lang/String;)V
    .locals 0
    .param p1, "deletedAsin"    # Ljava/lang/String;

    .prologue
    .line 65
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->mDeletedAsin:Ljava/lang/String;

    .line 66
    return-void
.end method

.method public setRecentlyScanned(Z)V
    .locals 0
    .param p1, "isRecentlyScanned"    # Z

    .prologue
    .line 76
    iput-boolean p1, p0, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->mIsRecentlyScanned:Z

    .line 77
    return-void
.end method
