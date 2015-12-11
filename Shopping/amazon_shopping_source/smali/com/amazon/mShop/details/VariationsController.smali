.class public Lcom/amazon/mShop/details/VariationsController;
.super Ljava/lang/Object;
.source "VariationsController.java"

# interfaces
.implements Lcom/amazon/mShop/control/home/BasicProductsSubscriber;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/details/VariationsController$DimensionNode;
    }
.end annotation


# instance fields
.field final mBasicProductController:Lcom/amazon/mShop/control/home/BasicProductsController;

.field private mBeginIndexForFetch:I

.field private mChildIndexMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private mFetchComplete:Z

.field private mRequestId:Ljava/lang/String;

.field private mRoot:Lcom/amazon/mShop/details/VariationsController$DimensionNode;

.field private mSelectedOptions:[I

.field private final mVariations:Lcom/amazon/mShop/control/item/Variations;


# direct methods
.method private continueToFetchInfosIfNeeded()Z
    .locals 7

    .prologue
    const/4 v5, 0x0

    .line 152
    invoke-direct {p0}, Lcom/amazon/mShop/details/VariationsController;->isIndexForFetchValid()Z

    move-result v6

    if-nez v6, :cond_1

    .line 173
    :cond_0
    :goto_0
    return v5

    .line 155
    :cond_1
    iget-object v6, p0, Lcom/amazon/mShop/details/VariationsController;->mVariations:Lcom/amazon/mShop/control/item/Variations;

    invoke-virtual {v6}, Lcom/amazon/mShop/control/item/Variations;->getVariationProductInfos()[Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;

    move-result-object v4

    .line 156
    .local v4, "infos":[Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;
    invoke-static {v4}, Lcom/amazon/mShop/util/Util;->isEmpty([Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_0

    .line 159
    invoke-direct {p0}, Lcom/amazon/mShop/details/VariationsController;->getBeginIndexForFetch()I

    move-result v2

    .line 160
    .local v2, "indexBegin":I
    add-int/lit8 v3, v2, 0x7f

    .line 161
    .local v3, "indexEnd":I
    add-int/lit8 v5, v3, 0x1

    array-length v6, v4

    if-le v5, v6, :cond_2

    .line 162
    const/4 v5, -0x1

    invoke-direct {p0, v5}, Lcom/amazon/mShop/details/VariationsController;->setBeginIndexForFetch(I)V

    .line 163
    array-length v5, v4

    add-int/lit8 v3, v5, -0x1

    .line 168
    :goto_1
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 169
    .local v0, "asins":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    move v1, v2

    .local v1, "i":I
    :goto_2
    if-gt v1, v3, :cond_3

    .line 170
    aget-object v5, v4, v1

    invoke-virtual {v5}, Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;->getAsin()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v0, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 169
    add-int/lit8 v1, v1, 0x1

    goto :goto_2

    .line 166
    .end local v0    # "asins":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v1    # "i":I
    :cond_2
    add-int/lit8 v5, v3, 0x1

    invoke-direct {p0, v5}, Lcom/amazon/mShop/details/VariationsController;->setBeginIndexForFetch(I)V

    goto :goto_1

    .line 172
    .restart local v0    # "asins":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .restart local v1    # "i":I
    :cond_3
    iget-object v5, p0, Lcom/amazon/mShop/details/VariationsController;->mBasicProductController:Lcom/amazon/mShop/control/home/BasicProductsController;

    iget-object v6, p0, Lcom/amazon/mShop/details/VariationsController;->mRequestId:Ljava/lang/String;

    invoke-virtual {v5, v0, v6}, Lcom/amazon/mShop/control/home/BasicProductsController;->requestBasicProducts(Ljava/util/List;Ljava/lang/String;)V

    .line 173
    const/4 v5, 0x1

    goto :goto_0
.end method

.method private getAttrForCurrentSelectionAndSpecDimen(II)Ljava/util/List;
    .locals 3
    .param p1, "dimen"    # I
    .param p2, "option"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(II)",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .prologue
    .line 52
    new-instance v0, Ljava/util/ArrayList;

    iget-object v2, p0, Lcom/amazon/mShop/details/VariationsController;->mSelectedOptions:[I

    array-length v2, v2

    invoke-direct {v0, v2}, Ljava/util/ArrayList;-><init>(I)V

    .line 53
    .local v0, "attr":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Integer;>;"
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget-object v2, p0, Lcom/amazon/mShop/details/VariationsController;->mSelectedOptions:[I

    array-length v2, v2

    if-ge v1, v2, :cond_0

    .line 54
    iget-object v2, p0, Lcom/amazon/mShop/details/VariationsController;->mSelectedOptions:[I

    aget v2, v2, v1

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 53
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 56
    :cond_0
    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, p1, v2}, Ljava/util/List;->set(ILjava/lang/Object;)Ljava/lang/Object;

    .line 57
    return-object v0
.end method

.method private getBeginIndexForFetch()I
    .locals 1

    .prologue
    .line 129
    iget v0, p0, Lcom/amazon/mShop/details/VariationsController;->mBeginIndexForFetch:I

    return v0
.end method

.method private isAvailableSubtree(Lcom/amazon/mShop/details/VariationsController$DimensionNode;)Z
    .locals 7
    .param p1, "node"    # Lcom/amazon/mShop/details/VariationsController$DimensionNode;

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 328
    iget-object v5, p0, Lcom/amazon/mShop/details/VariationsController;->mSelectedOptions:[I

    invoke-virtual {p1}, Lcom/amazon/mShop/details/VariationsController$DimensionNode;->getDimension()I

    move-result v6

    aget v1, v5, v6

    .line 331
    .local v1, "currentLevelSelection":I
    const/4 v5, -0x1

    if-eq v1, v5, :cond_0

    invoke-virtual {p1}, Lcom/amazon/mShop/details/VariationsController$DimensionNode;->getOption()I

    move-result v5

    if-eq v1, v5, :cond_0

    .line 348
    :goto_0
    return v3

    .line 337
    :cond_0
    invoke-virtual {p1}, Lcom/amazon/mShop/details/VariationsController$DimensionNode;->getNumChildren()I

    move-result v5

    if-nez v5, :cond_1

    move v3, v4

    .line 338
    goto :goto_0

    .line 342
    :cond_1
    const/4 v0, 0x0

    .line 343
    .local v0, "available":Z
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_1
    invoke-virtual {p1}, Lcom/amazon/mShop/details/VariationsController$DimensionNode;->getNumChildren()I

    move-result v5

    if-ge v2, v5, :cond_5

    .line 344
    invoke-virtual {p1, v2}, Lcom/amazon/mShop/details/VariationsController$DimensionNode;->getChildAt(I)Lcom/amazon/mShop/details/VariationsController$DimensionNode;

    move-result-object v5

    if-eqz v5, :cond_3

    .line 345
    if-nez v0, :cond_2

    invoke-virtual {p1, v2}, Lcom/amazon/mShop/details/VariationsController$DimensionNode;->getChildAt(I)Lcom/amazon/mShop/details/VariationsController$DimensionNode;

    move-result-object v5

    invoke-direct {p0, v5}, Lcom/amazon/mShop/details/VariationsController;->isAvailableSubtree(Lcom/amazon/mShop/details/VariationsController$DimensionNode;)Z

    move-result v5

    if-eqz v5, :cond_4

    :cond_2
    move v0, v4

    .line 343
    :cond_3
    :goto_2
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    :cond_4
    move v0, v3

    .line 345
    goto :goto_2

    :cond_5
    move v3, v0

    .line 348
    goto :goto_0
.end method

.method private isFetchComplete()Z
    .locals 1

    .prologue
    .line 110
    iget-boolean v0, p0, Lcom/amazon/mShop/details/VariationsController;->mFetchComplete:Z

    return v0
.end method

.method private isIndexForFetchValid()Z
    .locals 1

    .prologue
    .line 133
    invoke-direct {p0}, Lcom/amazon/mShop/details/VariationsController;->getBeginIndexForFetch()I

    move-result v0

    if-ltz v0, :cond_0

    .line 134
    const/4 v0, 0x1

    .line 136
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private setBeginIndexForFetch(I)V
    .locals 0
    .param p1, "index"    # I

    .prologue
    .line 125
    iput p1, p0, Lcom/amazon/mShop/details/VariationsController;->mBeginIndexForFetch:I

    .line 126
    return-void
.end method

.method private setFetchComplete(Z)V
    .locals 0
    .param p1, "done"    # Z

    .prologue
    .line 106
    iput-boolean p1, p0, Lcom/amazon/mShop/details/VariationsController;->mFetchComplete:Z

    .line 107
    return-void
.end method


# virtual methods
.method public cancelFetchInfos()V
    .locals 1

    .prologue
    .line 121
    iget-object v0, p0, Lcom/amazon/mShop/details/VariationsController;->mBasicProductController:Lcom/amazon/mShop/control/home/BasicProductsController;

    invoke-virtual {v0}, Lcom/amazon/mShop/control/home/BasicProductsController;->cancel()V

    .line 122
    return-void
.end method

.method public checkAvailabilitiesForDimension(I)Ljava/util/List;
    .locals 12
    .param p1, "dimension"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v11, -0x1

    .line 262
    iget-object v9, p0, Lcom/amazon/mShop/details/VariationsController;->mVariations:Lcom/amazon/mShop/control/item/Variations;

    invoke-virtual {v9}, Lcom/amazon/mShop/control/item/Variations;->getDimensions()[Lcom/amazon/rio/j2me/client/services/mShop/Dimension;

    move-result-object v9

    aget-object v9, v9, p1

    invoke-virtual {v9}, Lcom/amazon/rio/j2me/client/services/mShop/Dimension;->getValues()Ljava/util/List;

    move-result-object v9

    invoke-interface {v9}, Ljava/util/List;->size()I

    move-result v7

    .line 265
    .local v7, "numOptions":I
    new-instance v8, Ljava/util/ArrayList;

    invoke-direct {v8, v7}, Ljava/util/ArrayList;-><init>(I)V

    .line 266
    .local v8, "result":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Boolean;>;"
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    if-ge v3, v7, :cond_0

    .line 267
    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    invoke-interface {v8, v9}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 266
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 272
    :cond_0
    iget-object v9, p0, Lcom/amazon/mShop/details/VariationsController;->mSelectedOptions:[I

    aget v2, v9, p1

    .line 273
    .local v2, "currentOption":I
    iget-object v9, p0, Lcom/amazon/mShop/details/VariationsController;->mSelectedOptions:[I

    aput v11, v9, p1

    .line 277
    new-instance v6, Ljava/util/Stack;

    invoke-direct {v6}, Ljava/util/Stack;-><init>()V

    .line 278
    .local v6, "nodeStack":Ljava/util/Stack;, "Ljava/util/Stack<Lcom/amazon/mShop/details/VariationsController$DimensionNode;>;"
    const/4 v3, 0x0

    :goto_1
    iget-object v9, p0, Lcom/amazon/mShop/details/VariationsController;->mRoot:Lcom/amazon/mShop/details/VariationsController$DimensionNode;

    invoke-virtual {v9}, Lcom/amazon/mShop/details/VariationsController$DimensionNode;->getNumChildren()I

    move-result v9

    if-ge v3, v9, :cond_2

    .line 279
    iget-object v9, p0, Lcom/amazon/mShop/details/VariationsController;->mRoot:Lcom/amazon/mShop/details/VariationsController$DimensionNode;

    invoke-virtual {v9, v3}, Lcom/amazon/mShop/details/VariationsController$DimensionNode;->getChildAt(I)Lcom/amazon/mShop/details/VariationsController$DimensionNode;

    move-result-object v9

    if-eqz v9, :cond_1

    .line 280
    iget-object v9, p0, Lcom/amazon/mShop/details/VariationsController;->mRoot:Lcom/amazon/mShop/details/VariationsController$DimensionNode;

    invoke-virtual {v9, v3}, Lcom/amazon/mShop/details/VariationsController$DimensionNode;->getChildAt(I)Lcom/amazon/mShop/details/VariationsController$DimensionNode;

    move-result-object v9

    invoke-virtual {v6, v9}, Ljava/util/Stack;->push(Ljava/lang/Object;)Ljava/lang/Object;

    .line 278
    :cond_1
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 286
    :cond_2
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 290
    .local v0, "availableNodes":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/details/VariationsController$DimensionNode;>;"
    :cond_3
    :goto_2
    invoke-virtual {v6}, Ljava/util/Stack;->empty()Z

    move-result v9

    if-nez v9, :cond_7

    .line 291
    invoke-virtual {v6}, Ljava/util/Stack;->pop()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/amazon/mShop/details/VariationsController$DimensionNode;

    .line 292
    .local v5, "node":Lcom/amazon/mShop/details/VariationsController$DimensionNode;
    iget-object v9, p0, Lcom/amazon/mShop/details/VariationsController;->mSelectedOptions:[I

    invoke-virtual {v5}, Lcom/amazon/mShop/details/VariationsController$DimensionNode;->getDimension()I

    move-result v10

    aget v1, v9, v10

    .line 296
    .local v1, "currentLevelSelection":I
    invoke-virtual {v5}, Lcom/amazon/mShop/details/VariationsController$DimensionNode;->getDimension()I

    move-result v9

    if-ne v9, p1, :cond_4

    .line 297
    invoke-interface {v0, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_2

    .line 301
    :cond_4
    if-eq v1, v11, :cond_5

    invoke-virtual {v5}, Lcom/amazon/mShop/details/VariationsController$DimensionNode;->getOption()I

    move-result v9

    if-ne v1, v9, :cond_3

    .line 302
    :cond_5
    const/4 v3, 0x0

    :goto_3
    invoke-virtual {v5}, Lcom/amazon/mShop/details/VariationsController$DimensionNode;->getNumChildren()I

    move-result v9

    if-ge v3, v9, :cond_3

    .line 303
    invoke-virtual {v5, v3}, Lcom/amazon/mShop/details/VariationsController$DimensionNode;->getChildAt(I)Lcom/amazon/mShop/details/VariationsController$DimensionNode;

    move-result-object v9

    if-eqz v9, :cond_6

    .line 304
    invoke-virtual {v5, v3}, Lcom/amazon/mShop/details/VariationsController$DimensionNode;->getChildAt(I)Lcom/amazon/mShop/details/VariationsController$DimensionNode;

    move-result-object v9

    invoke-virtual {v6, v9}, Ljava/util/Stack;->push(Ljava/lang/Object;)Ljava/lang/Object;

    .line 302
    :cond_6
    add-int/lit8 v3, v3, 0x1

    goto :goto_3

    .line 312
    .end local v1    # "currentLevelSelection":I
    .end local v5    # "node":Lcom/amazon/mShop/details/VariationsController$DimensionNode;
    :cond_7
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .local v4, "i$":Ljava/util/Iterator;
    :cond_8
    :goto_4
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_9

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/amazon/mShop/details/VariationsController$DimensionNode;

    .line 313
    .restart local v5    # "node":Lcom/amazon/mShop/details/VariationsController$DimensionNode;
    invoke-direct {p0, v5}, Lcom/amazon/mShop/details/VariationsController;->isAvailableSubtree(Lcom/amazon/mShop/details/VariationsController$DimensionNode;)Z

    move-result v9

    if-eqz v9, :cond_8

    .line 314
    invoke-virtual {v5}, Lcom/amazon/mShop/details/VariationsController$DimensionNode;->getOption()I

    move-result v9

    sget-object v10, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    invoke-interface {v8, v9, v10}, Ljava/util/List;->set(ILjava/lang/Object;)Ljava/lang/Object;

    goto :goto_4

    .line 319
    .end local v5    # "node":Lcom/amazon/mShop/details/VariationsController$DimensionNode;
    :cond_9
    iget-object v9, p0, Lcom/amazon/mShop/details/VariationsController;->mSelectedOptions:[I

    aput v2, v9, p1

    .line 321
    return-object v8
.end method

.method public getAvailabeMessage(II)Ljava/lang/String;
    .locals 2
    .param p1, "dimen"    # I
    .param p2, "option"    # I

    .prologue
    .line 86
    invoke-direct {p0}, Lcom/amazon/mShop/details/VariationsController;->isFetchComplete()Z

    move-result v1

    if-nez v1, :cond_0

    .line 88
    const/4 v1, 0x0

    .line 91
    :goto_0
    return-object v1

    .line 90
    :cond_0
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/details/VariationsController;->getAttrForCurrentSelectionAndSpecDimen(II)Ljava/util/List;

    move-result-object v0

    .line 91
    .local v0, "attr":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Integer;>;"
    iget-object v1, p0, Lcom/amazon/mShop/details/VariationsController;->mVariations:Lcom/amazon/mShop/control/item/Variations;

    invoke-virtual {v1, v0}, Lcom/amazon/mShop/control/item/Variations;->getAvailableMessage(Ljava/util/List;)Ljava/lang/String;

    move-result-object v1

    goto :goto_0
.end method

.method public getCurrentSelection()Ljava/util/List;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .prologue
    .line 192
    new-instance v1, Ljava/util/ArrayList;

    iget-object v2, p0, Lcom/amazon/mShop/details/VariationsController;->mSelectedOptions:[I

    array-length v2, v2

    invoke-direct {v1, v2}, Ljava/util/ArrayList;-><init>(I)V

    .line 193
    .local v1, "result":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Integer;>;"
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v2, p0, Lcom/amazon/mShop/details/VariationsController;->mSelectedOptions:[I

    array-length v2, v2

    if-ge v0, v2, :cond_0

    .line 194
    iget-object v2, p0, Lcom/amazon/mShop/details/VariationsController;->mSelectedOptions:[I

    aget v2, v2, v0

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 193
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 196
    :cond_0
    return-object v1
.end method

.method public getPrice(II)Ljava/lang/String;
    .locals 2
    .param p1, "dimen"    # I
    .param p2, "option"    # I

    .prologue
    .line 69
    invoke-direct {p0}, Lcom/amazon/mShop/details/VariationsController;->isFetchComplete()Z

    move-result v1

    if-nez v1, :cond_0

    .line 71
    const/4 v1, 0x0

    .line 74
    :goto_0
    return-object v1

    .line 73
    :cond_0
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/details/VariationsController;->getAttrForCurrentSelectionAndSpecDimen(II)Ljava/util/List;

    move-result-object v0

    .line 74
    .local v0, "attr":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Integer;>;"
    iget-object v1, p0, Lcom/amazon/mShop/details/VariationsController;->mVariations:Lcom/amazon/mShop/control/item/Variations;

    invoke-virtual {v1, v0}, Lcom/amazon/mShop/control/item/Variations;->getPrice(Ljava/util/List;)Ljava/lang/String;

    move-result-object v1

    goto :goto_0
.end method

.method public getSelectedChild(Ljava/util/List;)Lcom/amazon/mShop/control/item/Variations$Child;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Integer;",
            ">;)",
            "Lcom/amazon/mShop/control/item/Variations$Child;"
        }
    .end annotation

    .prologue
    .line 355
    .local p1, "attributes":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Integer;>;"
    iget-object v1, p0, Lcom/amazon/mShop/details/VariationsController;->mChildIndexMap:Ljava/util/Map;

    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    if-nez v1, :cond_0

    .line 356
    const/4 v1, 0x0

    .line 360
    :goto_0
    return-object v1

    .line 359
    :cond_0
    iget-object v1, p0, Lcom/amazon/mShop/details/VariationsController;->mChildIndexMap:Ljava/util/Map;

    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Integer;

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v0

    .line 360
    .local v0, "childIndex":I
    iget-object v1, p0, Lcom/amazon/mShop/details/VariationsController;->mVariations:Lcom/amazon/mShop/control/item/Variations;

    invoke-virtual {v1}, Lcom/amazon/mShop/control/item/Variations;->getChildren()[Lcom/amazon/mShop/control/item/Variations$Child;

    move-result-object v1

    aget-object v1, v1, v0

    goto :goto_0
.end method

.method public onBasicProductsReceived(Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsResponse;)V
    .locals 11
    .param p1, "response"    # Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsResponse;

    .prologue
    const/4 v9, 0x0

    .line 410
    if-eqz p1, :cond_2

    .line 411
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsResponse;->getProducts()Ljava/util/List;

    move-result-object v8

    .line 412
    .local v8, "results":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;>;"
    if-eqz v8, :cond_2

    .line 413
    invoke-interface {v8}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .local v4, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v10

    if-eqz v10, :cond_2

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    .line 414
    .local v7, "result":Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    invoke-virtual {v7}, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v10

    invoke-virtual {v10}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getAsin()Ljava/lang/String;

    move-result-object v0

    .line 415
    .local v0, "asin":Ljava/lang/String;
    invoke-virtual {v7}, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;->getBasicOffer()Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    move-result-object v5

    .line 416
    .local v5, "offer":Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v10

    if-nez v10, :cond_0

    if-eqz v5, :cond_0

    .line 417
    invoke-virtual {v5}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->getPrice()Ljava/lang/String;

    move-result-object v6

    .line 418
    .local v6, "price":Ljava/lang/String;
    const/4 v1, 0x0

    .line 419
    .local v1, "availability":Ljava/lang/String;
    invoke-virtual {v5}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->getAvailabilityMessages()Ljava/util/List;

    move-result-object v10

    invoke-static {v10}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v10

    if-nez v10, :cond_1

    .line 420
    invoke-virtual {v5}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->getAvailabilityMessages()Ljava/util/List;

    move-result-object v10

    invoke-interface {v10, v9}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/rio/j2me/client/services/mShop/HyperText;

    .line 421
    .local v3, "hyper":Lcom/amazon/rio/j2me/client/services/mShop/HyperText;
    if-eqz v3, :cond_1

    .line 422
    invoke-virtual {v3}, Lcom/amazon/rio/j2me/client/services/mShop/HyperText;->getText()Ljava/lang/String;

    move-result-object v1

    .line 425
    .end local v3    # "hyper":Lcom/amazon/rio/j2me/client/services/mShop/HyperText;
    :cond_1
    iget-object v10, p0, Lcom/amazon/mShop/details/VariationsController;->mVariations:Lcom/amazon/mShop/control/item/Variations;

    invoke-virtual {v10, v0, v6}, Lcom/amazon/mShop/control/item/Variations;->setPrice(Ljava/lang/String;Ljava/lang/String;)V

    .line 426
    iget-object v10, p0, Lcom/amazon/mShop/details/VariationsController;->mVariations:Lcom/amazon/mShop/control/item/Variations;

    invoke-virtual {v10, v0, v1}, Lcom/amazon/mShop/control/item/Variations;->setAvailableMessage(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 431
    .end local v0    # "asin":Ljava/lang/String;
    .end local v1    # "availability":Ljava/lang/String;
    .end local v4    # "i$":Ljava/util/Iterator;
    .end local v5    # "offer":Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;
    .end local v6    # "price":Ljava/lang/String;
    .end local v7    # "result":Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    .end local v8    # "results":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;>;"
    :cond_2
    invoke-direct {p0}, Lcom/amazon/mShop/details/VariationsController;->continueToFetchInfosIfNeeded()Z

    move-result v2

    .line 432
    .local v2, "continueToFetch":Z
    if-nez v2, :cond_3

    const/4 v9, 0x1

    :cond_3
    invoke-direct {p0, v9}, Lcom/amazon/mShop/details/VariationsController;->setFetchComplete(Z)V

    .line 433
    return-void
.end method

.method public onError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 1
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 402
    const/4 v0, -0x1

    invoke-direct {p0, v0}, Lcom/amazon/mShop/details/VariationsController;->setBeginIndexForFetch(I)V

    .line 403
    return-void
.end method

.method public selectAndUpdate(II)Ljava/util/List;
    .locals 4
    .param p1, "dimension"    # I
    .param p2, "option"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(II)",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .prologue
    .line 204
    iget-object v2, p0, Lcom/amazon/mShop/details/VariationsController;->mSelectedOptions:[I

    aget v2, v2, p1

    if-ne v2, p2, :cond_0

    .line 205
    invoke-virtual {p0}, Lcom/amazon/mShop/details/VariationsController;->getCurrentSelection()Ljava/util/List;

    move-result-object v2

    .line 220
    :goto_0
    return-object v2

    .line 208
    :cond_0
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/details/VariationsController;->checkAvailabilitiesForDimension(I)Ljava/util/List;

    move-result-object v0

    .line 211
    .local v0, "availableSelections":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Boolean;>;"
    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Boolean;

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-nez v2, :cond_1

    .line 212
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_1
    iget-object v2, p0, Lcom/amazon/mShop/details/VariationsController;->mVariations:Lcom/amazon/mShop/control/item/Variations;

    invoke-virtual {v2}, Lcom/amazon/mShop/control/item/Variations;->getDimensions()[Lcom/amazon/rio/j2me/client/services/mShop/Dimension;

    move-result-object v2

    array-length v2, v2

    if-ge v1, v2, :cond_1

    .line 213
    iget-object v2, p0, Lcom/amazon/mShop/details/VariationsController;->mSelectedOptions:[I

    const/4 v3, -0x1

    aput v3, v2, v1

    .line 212
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 218
    .end local v1    # "i":I
    :cond_1
    iget-object v2, p0, Lcom/amazon/mShop/details/VariationsController;->mSelectedOptions:[I

    aput p2, v2, p1

    .line 220
    invoke-virtual {p0}, Lcom/amazon/mShop/details/VariationsController;->getCurrentSelection()Ljava/util/List;

    move-result-object v2

    goto :goto_0
.end method
