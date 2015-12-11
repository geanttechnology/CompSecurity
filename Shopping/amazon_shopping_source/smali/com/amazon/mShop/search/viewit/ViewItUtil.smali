.class public Lcom/amazon/mShop/search/viewit/ViewItUtil;
.super Ljava/lang/Object;
.source "ViewItUtil.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getScreenSize(Lcom/amazon/mShop/AmazonActivity;)Landroid/graphics/Point;
    .locals 4
    .param p0, "activity"    # Lcom/amazon/mShop/AmazonActivity;

    .prologue
    .line 291
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->getWindowManager()Landroid/view/WindowManager;

    move-result-object v2

    invoke-interface {v2}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v0

    .line 292
    .local v0, "display":Landroid/view/Display;
    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v3, 0xd

    if-lt v2, v3, :cond_0

    .line 293
    new-instance v1, Landroid/graphics/Point;

    invoke-direct {v1}, Landroid/graphics/Point;-><init>()V

    .line 294
    .local v1, "size":Landroid/graphics/Point;
    invoke-virtual {v0, v1}, Landroid/view/Display;->getSize(Landroid/graphics/Point;)V

    .line 298
    .end local v1    # "size":Landroid/graphics/Point;
    :goto_0
    return-object v1

    :cond_0
    new-instance v1, Landroid/graphics/Point;

    invoke-virtual {v0}, Landroid/view/Display;->getWidth()I

    move-result v2

    invoke-virtual {v0}, Landroid/view/Display;->getHeight()I

    move-result v3

    invoke-direct {v1, v2, v3}, Landroid/graphics/Point;-><init>(II)V

    goto :goto_0
.end method

.method public static getSeriesAsinString(Ljava/util/List;)Ljava/lang/String;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 35
    .local p0, "asins":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const/4 v1, 0x0

    .line 36
    .local v1, "asinSeriesString":Ljava/lang/String;
    invoke-static {p0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 37
    invoke-interface {p0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 38
    .local v0, "asin":Ljava/lang/String;
    if-eqz v1, :cond_0

    .line 39
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, ","

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    goto :goto_0

    .line 41
    :cond_0
    move-object v1, v0

    goto :goto_0

    .line 46
    .end local v0    # "asin":Ljava/lang/String;
    .end local v2    # "i$":Ljava/util/Iterator;
    :cond_1
    return-object v1
.end method

.method public static hasMultipleResults(Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;)Z
    .locals 2
    .param p0, "wrapper"    # Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;

    .prologue
    const/4 v0, 0x1

    .line 53
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->getSearchResults()Ljava/util/List;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v1

    if-nez v1, :cond_0

    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->getSearchResults()Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-le v1, v0, :cond_0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static isOverlappedWithTopFiveResults(Ljava/util/List;Ljava/util/List;)Z
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)Z"
        }
    .end annotation

    .prologue
    .local p0, "items1":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .local p1, "items2":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const/4 v5, 0x5

    .line 60
    invoke-static {p0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v6

    if-nez v6, :cond_4

    invoke-static {p1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v6

    if-nez v6, :cond_4

    .line 61
    invoke-interface {p0}, Ljava/util/List;->size()I

    move-result v6

    if-le v6, v5, :cond_0

    move v2, v5

    .line 62
    .local v2, "size1":I
    :goto_0
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v6

    if-le v6, v5, :cond_1

    move v3, v5

    .line 64
    .local v3, "size2":I
    :goto_1
    new-instance v1, Ljava/util/HashSet;

    invoke-direct {v1}, Ljava/util/HashSet;-><init>()V

    .line 65
    .local v1, "set2":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_2
    if-ge v0, v3, :cond_2

    .line 66
    invoke-interface {p1, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    invoke-interface {v1, v5}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 65
    add-int/lit8 v0, v0, 0x1

    goto :goto_2

    .line 61
    .end local v0    # "i":I
    .end local v1    # "set2":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    .end local v2    # "size1":I
    .end local v3    # "size2":I
    :cond_0
    invoke-interface {p0}, Ljava/util/List;->size()I

    move-result v2

    goto :goto_0

    .line 62
    .restart local v2    # "size1":I
    :cond_1
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v3

    goto :goto_1

    .line 69
    .restart local v0    # "i":I
    .restart local v1    # "set2":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    .restart local v3    # "size2":I
    :cond_2
    const/4 v0, 0x0

    :goto_3
    if-ge v0, v2, :cond_4

    .line 70
    invoke-interface {p0, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    .line 71
    .local v4, "str1":Ljava/lang/String;
    invoke-interface {v1, v4}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_3

    .line 72
    const/4 v5, 0x1

    .line 77
    .end local v0    # "i":I
    .end local v1    # "set2":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    .end local v2    # "size1":I
    .end local v3    # "size2":I
    .end local v4    # "str1":Ljava/lang/String;
    :goto_4
    return v5

    .line 69
    .restart local v0    # "i":I
    .restart local v1    # "set2":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    .restart local v2    # "size1":I
    .restart local v3    # "size2":I
    .restart local v4    # "str1":Ljava/lang/String;
    :cond_3
    add-int/lit8 v0, v0, 0x1

    goto :goto_3

    .line 77
    .end local v0    # "i":I
    .end local v1    # "set2":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    .end local v2    # "size1":I
    .end local v3    # "size2":I
    .end local v4    # "str1":Ljava/lang/String;
    :cond_4
    const/4 v5, 0x0

    goto :goto_4
.end method

.method public static isSimilarObject(Ljava/util/List;Lcom/amazon/mShop/search/viewit/ResultWrapper;Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;Z)Z
    .locals 7
    .param p1, "object"    # Lcom/amazon/mShop/search/viewit/ResultWrapper;
    .param p2, "outPutType"    # Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;
    .param p3, "beforeLoading"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Lcom/amazon/mShop/search/viewit/ResultWrapper;",
            "Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;",
            "Z)Z"
        }
    .end annotation

    .prologue
    .local p0, "scannedOutput":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 125
    invoke-static {p0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v5

    if-nez v5, :cond_3

    if-eqz p1, :cond_3

    .line 126
    sget-object v5, Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;->BARCODE:Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;

    invoke-virtual {p2, v5}, Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_2

    if-eqz p3, :cond_2

    .line 128
    invoke-interface {p0, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 131
    .local v1, "barcode":Ljava/lang/String;
    invoke-virtual {p1}, Lcom/amazon/mShop/search/viewit/ResultWrapper;->getResultType()Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;

    move-result-object v5

    sget-object v6, Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;->BARCODE:Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;

    invoke-virtual {v5, v6}, Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 132
    invoke-virtual {p1}, Lcom/amazon/mShop/search/viewit/ResultWrapper;->getOriginalScannedOutput()Ljava/lang/String;

    move-result-object v5

    sget-object v6, Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;->BARCODE:Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;

    invoke-virtual {v6}, Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;->getTypeValue()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/amazon/mShop/search/viewit/ViewItUtil;->removePrefix(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 133
    .local v2, "itemBarcode":Ljava/lang/String;
    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 151
    .end local v1    # "barcode":Ljava/lang/String;
    .end local v2    # "itemBarcode":Ljava/lang/String;
    :cond_0
    :goto_0
    return v3

    .restart local v1    # "barcode":Ljava/lang/String;
    :cond_1
    move v3, v4

    .line 138
    goto :goto_0

    .line 143
    .end local v1    # "barcode":Ljava/lang/String;
    :cond_2
    invoke-virtual {p1}, Lcom/amazon/mShop/search/viewit/ResultWrapper;->getAsinList()Ljava/util/List;

    move-result-object v0

    .line 144
    .local v0, "asinList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-static {p0, v0}, Lcom/amazon/mShop/search/viewit/ViewItUtil;->isOverlappedWithTopFiveResults(Ljava/util/List;Ljava/util/List;)Z

    move-result v5

    if-nez v5, :cond_0

    move v3, v4

    .line 147
    goto :goto_0

    .end local v0    # "asinList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :cond_3
    move v3, v4

    .line 151
    goto :goto_0
.end method

.method public static isSimilarObject(Ljava/util/List;Ljava/util/List;)Z
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)Z"
        }
    .end annotation

    .prologue
    .line 162
    .local p0, "scannedOutput1":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .local p1, "scannedOutput2":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-static {p0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-static {p1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 163
    invoke-static {p0, p1}, Lcom/amazon/mShop/search/viewit/ViewItUtil;->isOverlappedWithTopFiveResults(Ljava/util/List;Ljava/util/List;)Z

    move-result v0

    .line 165
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static mergeSimilarObejcts(Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;)V
    .locals 12
    .param p0, "newObject"    # Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;
    .param p1, "existingObject"    # Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;

    .prologue
    .line 247
    if-eqz p0, :cond_5

    if-eqz p1, :cond_5

    .line 248
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->getAsinList()Ljava/util/List;

    move-result-object v10

    invoke-virtual {p1}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->getAsinList()Ljava/util/List;

    move-result-object v11

    invoke-static {v10, v11}, Lcom/amazon/mShop/search/viewit/ViewItUtil;->isOverlappedWithTopFiveResults(Ljava/util/List;Ljava/util/List;)Z

    move-result v10

    if-eqz v10, :cond_5

    .line 250
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->getSearchResults()Ljava/util/List;

    move-result-object v3

    .line 251
    .local v3, "newObjectResults":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;>;"
    invoke-virtual {p1}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->getSearchResults()Ljava/util/List;

    move-result-object v0

    .line 253
    .local v0, "existingObjectResults":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;>;"
    invoke-static {v3}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v10

    if-nez v10, :cond_5

    .line 254
    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v8

    .line 255
    .local v8, "size1":I
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v9

    .line 256
    .local v9, "size2":I
    new-instance v6, Ljava/util/ArrayList;

    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    .line 257
    .local v6, "resultsNeedToMerge":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;>;"
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v8, :cond_3

    .line 258
    const/4 v7, 0x1

    .line 259
    .local v7, "shouldMerge":Z
    invoke-interface {v3, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    .line 260
    .local v4, "result1":Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    const/4 v2, 0x0

    .local v2, "j":I
    :goto_1
    if-ge v2, v9, :cond_0

    .line 261
    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    .line 262
    .local v5, "result2":Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    invoke-virtual {v4}, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v10

    invoke-virtual {v10}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getAsin()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v5}, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v11

    invoke-virtual {v11}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getAsin()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_2

    .line 263
    const/4 v7, 0x0

    .line 268
    .end local v5    # "result2":Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    :cond_0
    if-eqz v7, :cond_1

    .line 269
    invoke-interface {v6, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 257
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 260
    .restart local v5    # "result2":Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    :cond_2
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 274
    .end local v2    # "j":I
    .end local v4    # "result1":Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    .end local v5    # "result2":Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    .end local v7    # "shouldMerge":Z
    :cond_3
    invoke-static {v6}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v10

    if-nez v10, :cond_4

    .line 275
    invoke-interface {v0, v6}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 279
    :cond_4
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->getResultType()Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;

    move-result-object v10

    sget-object v11, Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;->BARCODE:Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;

    invoke-virtual {v10, v11}, Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_5

    invoke-virtual {p1}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->getResultType()Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;

    move-result-object v10

    sget-object v11, Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;->BARCODE:Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;

    invoke-virtual {v10, v11}, Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-nez v10, :cond_5

    .line 280
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->getOriginalScannedOutput()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {p1, v10}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->updateOriginalScannedOutput(Ljava/lang/String;)V

    .line 285
    .end local v0    # "existingObjectResults":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;>;"
    .end local v1    # "i":I
    .end local v3    # "newObjectResults":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;>;"
    .end local v6    # "resultsNeedToMerge":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;>;"
    .end local v8    # "size1":I
    .end local v9    # "size2":I
    :cond_5
    return-void
.end method

.method public static removeIfContained(Ljava/util/List;Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;)Z
    .locals 5
    .param p1, "item"    # Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;",
            ">;",
            "Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;",
            ")Z"
        }
    .end annotation

    .prologue
    .line 104
    .local p0, "items":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;>;"
    invoke-static {p0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v3

    if-nez v3, :cond_1

    if-eqz p1, :cond_1

    .line 105
    invoke-interface {p0}, Ljava/util/List;->size()I

    move-result v2

    .line 106
    .local v2, "size":I
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, v2, :cond_1

    .line 107
    invoke-interface {p0, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    .line 108
    .local v1, "object":Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getAsin()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getAsin()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 109
    invoke-interface {p0, v0}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    .line 110
    const/4 v3, 0x1

    .line 114
    .end local v0    # "i":I
    .end local v1    # "object":Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    .end local v2    # "size":I
    :goto_1
    return v3

    .line 106
    .restart local v0    # "i":I
    .restart local v1    # "object":Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    .restart local v2    # "size":I
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 114
    .end local v0    # "i":I
    .end local v1    # "object":Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    .end local v2    # "size":I
    :cond_1
    const/4 v3, 0x0

    goto :goto_1
.end method

.method public static removePrefix(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p0, "originalString"    # Ljava/lang/String;
    .param p1, "prefix"    # Ljava/lang/String;

    .prologue
    .line 22
    invoke-static {p0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-static {p1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 23
    invoke-virtual {p0, p1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 24
    const-string/jumbo v0, ""

    invoke-virtual {p0, p1, v0}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object p0

    .line 27
    .end local p0    # "originalString":Ljava/lang/String;
    :cond_0
    return-object p0
.end method

.method public static removeSimilarObject(Ljava/util/List;Ljava/util/List;Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;Z)Lcom/amazon/mShop/search/viewit/ResultWrapper;
    .locals 4
    .param p2, "outPutType"    # Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;
    .param p3, "beforeLoading"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<+",
            "Lcom/amazon/mShop/search/viewit/ResultWrapper;",
            ">;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;",
            "Z)",
            "Lcom/amazon/mShop/search/viewit/ResultWrapper;"
        }
    .end annotation

    .prologue
    .line 91
    .local p0, "items":Ljava/util/List;, "Ljava/util/List<+Lcom/amazon/mShop/search/viewit/ResultWrapper;>;"
    .local p1, "scannedOutput":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-static {p0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v3

    if-nez v3, :cond_1

    invoke-static {p1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 92
    invoke-interface {p0}, Ljava/util/List;->size()I

    move-result v2

    .line 93
    .local v2, "size":I
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, v2, :cond_1

    .line 94
    invoke-interface {p0, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/search/viewit/ResultWrapper;

    .line 95
    .local v1, "item":Lcom/amazon/mShop/search/viewit/ResultWrapper;
    invoke-static {p1, v1, p2, p3}, Lcom/amazon/mShop/search/viewit/ViewItUtil;->isSimilarObject(Ljava/util/List;Lcom/amazon/mShop/search/viewit/ResultWrapper;Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;Z)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 96
    invoke-interface {p0, v0}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/mShop/search/viewit/ResultWrapper;

    .line 100
    .end local v0    # "i":I
    .end local v1    # "item":Lcom/amazon/mShop/search/viewit/ResultWrapper;
    .end local v2    # "size":I
    :goto_1
    return-object v3

    .line 93
    .restart local v0    # "i":I
    .restart local v1    # "item":Lcom/amazon/mShop/search/viewit/ResultWrapper;
    .restart local v2    # "size":I
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 100
    .end local v0    # "i":I
    .end local v1    # "item":Lcom/amazon/mShop/search/viewit/ResultWrapper;
    .end local v2    # "size":I
    :cond_1
    const/4 v3, 0x0

    goto :goto_1
.end method

.method public static removeSimilarObjectFromHistory(Ljava/util/List;Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;Lcom/amazon/mShop/search/viewit/ViewItDBHelper;Z)Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;
    .locals 13
    .param p1, "outPutType"    # Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;
    .param p2, "browser"    # Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;
    .param p3, "dBHelper"    # Lcom/amazon/mShop/search/viewit/ViewItDBHelper;
    .param p4, "beforeLoading"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;",
            "Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;",
            "Lcom/amazon/mShop/search/viewit/ViewItDBHelper;",
            "Z)",
            "Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;"
        }
    .end annotation

    .prologue
    .line 180
    .local p0, "scannedOutput":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const/4 v8, 0x0

    .line 183
    .local v8, "removedObject":Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;
    invoke-virtual {p2}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->getRecentlyScannedObjects()Ljava/util/List;

    move-result-object v6

    .line 184
    .local v6, "recentlyScannedObjects":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;>;"
    move/from16 v0, p4

    invoke-static {v6, p0, p1, v0}, Lcom/amazon/mShop/search/viewit/ViewItUtil;->removeSimilarObject(Ljava/util/List;Ljava/util/List;Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;Z)Lcom/amazon/mShop/search/viewit/ResultWrapper;

    move-result-object v8

    .end local v8    # "removedObject":Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;
    check-cast v8, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;

    .line 187
    .restart local v8    # "removedObject":Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;
    if-nez v8, :cond_0

    .line 188
    invoke-virtual {p2}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->getHistoryListingObjects()Ljava/util/List;

    move-result-object v4

    .line 189
    .local v4, "listingObjects":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;>;"
    move/from16 v0, p4

    invoke-static {v4, p0, p1, v0}, Lcom/amazon/mShop/search/viewit/ViewItUtil;->removeSimilarObject(Ljava/util/List;Ljava/util/List;Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;Z)Lcom/amazon/mShop/search/viewit/ResultWrapper;

    move-result-object v8

    .end local v8    # "removedObject":Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;
    check-cast v8, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;

    .line 190
    .restart local v8    # "removedObject":Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;
    if-eqz v8, :cond_0

    .line 191
    iget v11, p2, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mHistoryObjectsDeletedCount:I

    add-int/lit8 v11, v11, 0x1

    iput v11, p2, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mHistoryObjectsDeletedCount:I

    .line 196
    .end local v4    # "listingObjects":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;>;"
    :cond_0
    invoke-virtual {p2}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->getObjectToDelete()Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;

    move-result-object v5

    .line 197
    .local v5, "objectToDelete":Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;
    if-eqz v8, :cond_1

    if-eqz v5, :cond_1

    invoke-virtual {v5}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->getOriginalScannedOutput()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v8}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->getOriginalScannedOutput()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-eqz v11, :cond_1

    .line 199
    const/4 v5, 0x0

    .line 203
    :cond_1
    if-nez v8, :cond_3

    .line 204
    const/4 v7, 0x0

    .line 209
    .local v7, "removedDBObject":Lcom/amazon/mShop/search/viewit/ViewItDBResultWrapper;
    invoke-virtual {p2}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->getCurrentRequestDBObjects()Ljava/util/List;

    move-result-object v2

    .line 210
    .local v2, "currentRequestDBObjects":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/search/viewit/ViewItDBResultWrapper;>;"
    move/from16 v0, p4

    invoke-static {v2, p0, p1, v0}, Lcom/amazon/mShop/search/viewit/ViewItUtil;->removeSimilarObject(Ljava/util/List;Ljava/util/List;Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;Z)Lcom/amazon/mShop/search/viewit/ResultWrapper;

    move-result-object v7

    .end local v7    # "removedDBObject":Lcom/amazon/mShop/search/viewit/ViewItDBResultWrapper;
    check-cast v7, Lcom/amazon/mShop/search/viewit/ViewItDBResultWrapper;

    .line 211
    .restart local v7    # "removedDBObject":Lcom/amazon/mShop/search/viewit/ViewItDBResultWrapper;
    if-eqz v7, :cond_2

    .line 212
    move-object/from16 v0, p3

    invoke-virtual {v0, v7}, Lcom/amazon/mShop/search/viewit/ViewItDBHelper;->delete(Lcom/amazon/mShop/search/viewit/ResultWrapper;)V

    .line 213
    iget v11, p2, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mHistoryObjectsDeletedCount:I

    add-int/lit8 v11, v11, 0x1

    iput v11, p2, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mHistoryObjectsDeletedCount:I

    .line 217
    :cond_2
    invoke-virtual {p2}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->getAllHistoryDBObjects()Ljava/util/List;

    move-result-object v1

    .line 218
    .local v1, "allHistoryDBObjects":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/search/viewit/ViewItDBResultWrapper;>;"
    if-nez v7, :cond_3

    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v11

    if-nez v11, :cond_3

    .line 219
    invoke-virtual {p2}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->getNextPageStartIndex()I

    move-result v9

    .line 220
    .local v9, "start":I
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v3

    .line 221
    .local v3, "end":I
    if-ge v9, v3, :cond_3

    .line 222
    invoke-interface {v1, v9, v3}, Ljava/util/List;->subList(II)Ljava/util/List;

    move-result-object v10

    .line 223
    .local v10, "unloadedHistoryDBObjects":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/search/viewit/ViewItDBResultWrapper;>;"
    move/from16 v0, p4

    invoke-static {v10, p0, p1, v0}, Lcom/amazon/mShop/search/viewit/ViewItUtil;->removeSimilarObject(Ljava/util/List;Ljava/util/List;Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;Z)Lcom/amazon/mShop/search/viewit/ResultWrapper;

    move-result-object v7

    .end local v7    # "removedDBObject":Lcom/amazon/mShop/search/viewit/ViewItDBResultWrapper;
    check-cast v7, Lcom/amazon/mShop/search/viewit/ViewItDBResultWrapper;

    .line 224
    .restart local v7    # "removedDBObject":Lcom/amazon/mShop/search/viewit/ViewItDBResultWrapper;
    if-eqz v7, :cond_3

    .line 225
    invoke-virtual {p2}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->getAvailableCount()I

    move-result v11

    add-int/lit8 v11, v11, -0x1

    invoke-virtual {p2, v11}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->setAvailableCount(I)V

    .line 226
    move-object/from16 v0, p3

    invoke-virtual {v0, v7}, Lcom/amazon/mShop/search/viewit/ViewItDBHelper;->delete(Lcom/amazon/mShop/search/viewit/ResultWrapper;)V

    .line 232
    .end local v1    # "allHistoryDBObjects":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/search/viewit/ViewItDBResultWrapper;>;"
    .end local v2    # "currentRequestDBObjects":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/search/viewit/ViewItDBResultWrapper;>;"
    .end local v3    # "end":I
    .end local v7    # "removedDBObject":Lcom/amazon/mShop/search/viewit/ViewItDBResultWrapper;
    .end local v9    # "start":I
    .end local v10    # "unloadedHistoryDBObjects":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/search/viewit/ViewItDBResultWrapper;>;"
    :cond_3
    return-object v8
.end method
