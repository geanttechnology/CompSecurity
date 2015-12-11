.class public Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;
.super Ljava/lang/Object;
.source "ResultsController.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController$ModelMatcher;
    }
.end annotation


# instance fields
.field private modelMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Object;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private modelMapParkingLot:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private final results:Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList",
            "<",
            "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement",
            "<*>;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/16 v1, 0x10

    .line 58
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 38
    new-instance v0, Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList;

    invoke-direct {v0, v1}, Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList;-><init>(I)V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->results:Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList;

    .line 45
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0, v1}, Ljava/util/HashMap;-><init>(I)V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->modelMap:Ljava/util/Map;

    .line 51
    new-instance v0, Ljava/util/HashMap;

    const/4 v1, 0x4

    invoke-direct {v0, v1}, Ljava/util/HashMap;-><init>(I)V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->modelMapParkingLot:Ljava/util/Map;

    .line 59
    return-void
.end method

.method private addToModelMap(ILcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;)V
    .locals 1
    .param p1, "location"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .line 191
    .local p2, "object":Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;, "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement<*>;"
    invoke-virtual {p2}, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->getLayoutElementModel()Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;

    move-result-object v0

    invoke-direct {p0, p1, v0}, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->addToModelMap(ILcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;)V

    .line 192
    return-void
.end method

.method private addToModelMap(ILcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;)V
    .locals 7
    .param p1, "location"    # I
    .param p2, "layoutElementModel"    # Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;

    .prologue
    .line 206
    iget-object v5, p0, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->results:Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList;

    invoke-virtual {v5}, Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList;->getContent()Ljava/util/List;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/List;->size()I

    move-result v0

    .line 207
    .local v0, "contentLength":I
    if-ge p1, v0, :cond_1

    .line 209
    move v1, p1

    .local v1, "i":I
    :goto_0
    if-ge v1, v0, :cond_1

    .line 212
    invoke-virtual {p0, v1}, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->get(I)Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;

    move-result-object v3

    .line 213
    .local v3, "layoutElement":Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;, "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement<*>;"
    invoke-virtual {v3}, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->getLayoutElementModel()Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;

    move-result-object v5

    invoke-interface {v5}, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;->getAllModels()Ljava/util/List;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    .line 215
    .local v4, "model":Ljava/lang/Object;
    iget-object v5, p0, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->modelMap:Ljava/util/Map;

    add-int/lit8 v6, v1, 0x1

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-interface {v5, v4, v6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    .line 209
    .end local v4    # "model":Ljava/lang/Object;
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 219
    .end local v1    # "i":I
    .end local v2    # "i$":Ljava/util/Iterator;
    .end local v3    # "layoutElement":Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;, "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement<*>;"
    :cond_1
    invoke-direct {p0, p1, p2}, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->setInModelMap(ILcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;)V

    .line 220
    return-void
.end method

.method private removeFromModelMap(II)V
    .locals 8
    .param p1, "start"    # I
    .param p2, "end"    # I

    .prologue
    .line 255
    move v1, p1

    .local v1, "i":I
    :goto_0
    if-ge v1, p2, :cond_1

    .line 257
    invoke-virtual {p0, v1}, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->get(I)Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;

    move-result-object v3

    .line 258
    .local v3, "layoutElement":Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;, "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement<*>;"
    invoke-virtual {v3}, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->getLayoutElementModel()Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;

    move-result-object v6

    invoke-interface {v6}, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;->getAllModels()Ljava/util/List;

    move-result-object v6

    invoke-interface {v6}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    .line 260
    .local v5, "model":Ljava/lang/Object;
    iget-object v6, p0, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->modelMap:Ljava/util/Map;

    invoke-interface {v6, v5}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    .line 255
    .end local v5    # "model":Ljava/lang/Object;
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 266
    .end local v2    # "i$":Ljava/util/Iterator;
    .end local v3    # "layoutElement":Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;, "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement<*>;"
    :cond_1
    iget-object v6, p0, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->results:Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList;

    invoke-virtual {v6}, Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList;->getContent()Ljava/util/List;

    move-result-object v6

    invoke-interface {v6}, Ljava/util/List;->size()I

    move-result v4

    .line 267
    .local v4, "listSize":I
    if-ge p2, v4, :cond_3

    .line 269
    sub-int v0, p2, p1

    .line 270
    .local v0, "diff":I
    move v1, p2

    :goto_2
    if-ge v1, v4, :cond_3

    .line 273
    invoke-virtual {p0, v1}, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->get(I)Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;

    move-result-object v3

    .line 274
    .restart local v3    # "layoutElement":Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;, "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement<*>;"
    invoke-virtual {v3}, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->getLayoutElementModel()Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;

    move-result-object v6

    invoke-interface {v6}, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;->getAllModels()Ljava/util/List;

    move-result-object v6

    invoke-interface {v6}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .restart local v2    # "i$":Ljava/util/Iterator;
    :goto_3
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_2

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    .line 276
    .restart local v5    # "model":Ljava/lang/Object;
    iget-object v6, p0, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->modelMap:Ljava/util/Map;

    sub-int v7, v1, v0

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    invoke-interface {v6, v5, v7}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_3

    .line 270
    .end local v5    # "model":Ljava/lang/Object;
    :cond_2
    add-int/lit8 v1, v1, 0x1

    goto :goto_2

    .line 280
    .end local v0    # "diff":I
    .end local v2    # "i$":Ljava/util/Iterator;
    .end local v3    # "layoutElement":Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;, "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement<*>;"
    :cond_3
    return-void
.end method

.method private setInModelMap(ILcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;)V
    .locals 4
    .param p1, "location"    # I
    .param p2, "layoutElementModel"    # Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;

    .prologue
    .line 231
    invoke-interface {p2}, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;->getAllModels()Ljava/util/List;

    move-result-object v2

    invoke-static {v2}, Lcom/amazon/retailsearch/util/Utils;->isEmpty(Ljava/util/Collection;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 236
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->modelMapParkingLot:Ljava/util/Map;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-interface {v2, p2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 244
    :cond_0
    return-void

    .line 239
    :cond_1
    invoke-interface {p2}, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;->getAllModels()Ljava/util/List;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    .line 241
    .local v1, "model":Ljava/lang/Object;
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->modelMap:Ljava/util/Map;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-interface {v2, v1, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method


# virtual methods
.method public add(ILcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;)V
    .locals 1
    .param p1, "location"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .line 300
    .local p2, "object":Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;, "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement<*>;"
    invoke-direct {p0, p1, p2}, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->addToModelMap(ILcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;)V

    .line 301
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->results:Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList;->getContent()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, p1, p2}, Ljava/util/List;->add(ILjava/lang/Object;)V

    .line 302
    return-void
.end method

.method public add(Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;)Z
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement",
            "<*>;)Z"
        }
    .end annotation

    .prologue
    .line 306
    .local p1, "object":Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;, "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement<*>;"
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->results:Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList;->getContent()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    invoke-direct {p0, v0, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->addToModelMap(ILcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;)V

    .line 307
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->results:Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList;->getContent()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public binarySearch(Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;)I
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement",
            "<*>;)I"
        }
    .end annotation

    .prologue
    .line 287
    .local p1, "item":Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;, "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement<*>;"
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->results:Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList;->getContent()Ljava/util/List;

    move-result-object v0

    invoke-static {v0, p1}, Ljava/util/Collections;->binarySearch(Ljava/util/List;Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method public clear()V
    .locals 1

    .prologue
    .line 318
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->modelMap:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    .line 319
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->results:Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList;->getContent()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 320
    return-void
.end method

.method public clear(II)V
    .locals 1
    .param p1, "start"    # I
    .param p2, "end"    # I

    .prologue
    .line 292
    invoke-direct {p0, p1, p2}, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->removeFromModelMap(II)V

    .line 293
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->results:Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList;->getContent()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, p1, p2}, Ljava/util/List;->subList(II)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 294
    return-void
.end method

.method public contains(Ljava/lang/Object;)Z
    .locals 1
    .param p1, "object"    # Ljava/lang/Object;

    .prologue
    .line 324
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->results:Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList;->getContent()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, p1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public containsAll(Ljava/util/Collection;)Z
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<*>;)Z"
        }
    .end annotation

    .prologue
    .line 329
    .local p1, "collection":Ljava/util/Collection;, "Ljava/util/Collection<*>;"
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->results:Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList;->getContent()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, p1}, Ljava/util/List;->containsAll(Ljava/util/Collection;)Z

    move-result v0

    return v0
.end method

.method public finalizeModels(Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;)V
    .locals 1
    .param p1, "layoutElementModel"    # Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;

    .prologue
    .line 180
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->modelMapParkingLot:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 181
    return-void
.end method

.method public get(I)Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;
    .locals 1
    .param p1, "location"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)",
            "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement",
            "<*>;"
        }
    .end annotation

    .prologue
    .line 334
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->results:Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList;->getContent()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;

    return-object v0
.end method

.method public getByModel(Ljava/lang/Object;)Ljava/lang/Integer;
    .locals 1
    .param p1, "model"    # Ljava/lang/Object;

    .prologue
    .line 79
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->modelMap:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    return-object v0
.end method

.method public getLoadersFor(I)Ljava/util/List;
    .locals 3
    .param p1, "index"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/ansel/fetch/tools/collection/Factory",
            "<",
            "Lcom/amazon/ansel/fetch/ResourceLoader",
            "<*>;>;>;"
        }
    .end annotation

    .prologue
    .line 140
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->results:Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList;

    invoke-virtual {v2}, Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList;->getContent()Ljava/util/List;

    move-result-object v0

    .line 142
    .local v0, "content":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement<*>;>;"
    if-eqz v0, :cond_0

    if-ltz p1, :cond_0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v2

    if-ge p1, v2, :cond_0

    .line 144
    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;

    .line 145
    .local v1, "el":Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;, "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement<*>;"
    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->getLoaders()Ljava/util/List;

    move-result-object v2

    .line 147
    .end local v1    # "el":Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;, "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement<*>;"
    :goto_0
    return-object v2

    :cond_0
    const/4 v2, 0x0

    goto :goto_0
.end method

.method public getModel(Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController$ModelMatcher;II)Ljava/lang/Object;
    .locals 7
    .param p1, "matcher"    # Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController$ModelMatcher;
    .param p2, "startLocation"    # I
    .param p3, "endLocation"    # I

    .prologue
    const/4 v5, 0x0

    .line 104
    if-gt p2, p3, :cond_0

    if-ltz p2, :cond_0

    if-ltz p3, :cond_0

    iget-object v6, p0, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->results:Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList;

    invoke-virtual {v6}, Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList;->getContent()Ljava/util/List;

    move-result-object v6

    invoke-interface {v6}, Ljava/util/List;->size()I

    move-result v6

    if-lt p3, v6, :cond_1

    :cond_0
    move-object v4, v5

    .line 129
    :goto_0
    return-object v4

    .line 109
    :cond_1
    move v3, p2

    .local v3, "location":I
    :goto_1
    if-gt v3, p3, :cond_5

    .line 111
    iget-object v6, p0, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->results:Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList;

    invoke-virtual {v6}, Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList;->getContent()Ljava/util/List;

    move-result-object v6

    invoke-interface {v6, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;

    .line 112
    .local v1, "layoutElement":Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;, "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement<*>;"
    if-nez v1, :cond_3

    .line 109
    :cond_2
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 116
    :cond_3
    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->getLayoutElementModel()Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;

    move-result-object v2

    .line 117
    .local v2, "layoutElementModel":Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;
    if-eqz v2, :cond_2

    invoke-interface {v2}, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;->getAllModels()Ljava/util/List;

    move-result-object v6

    if-eqz v6, :cond_2

    .line 121
    invoke-interface {v2}, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;->getAllModels()Ljava/util/List;

    move-result-object v6

    invoke-interface {v6}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_4
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_2

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    .line 123
    .local v4, "object":Ljava/lang/Object;
    invoke-interface {p1, v4}, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController$ModelMatcher;->match(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_4

    goto :goto_0

    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "layoutElement":Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;, "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement<*>;"
    .end local v2    # "layoutElementModel":Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;
    .end local v4    # "object":Ljava/lang/Object;
    :cond_5
    move-object v4, v5

    .line 129
    goto :goto_0
.end method

.method public getViewGenerator()Lcom/amazon/retailsearch/android/ui/listadapter/ViewGenerator;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->results:Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList;

    return-object v0
.end method

.method public indexOf(Ljava/lang/Object;)I
    .locals 1
    .param p1, "object"    # Ljava/lang/Object;

    .prologue
    .line 339
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->results:Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList;->getContent()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, p1}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method public isEmpty()Z
    .locals 1

    .prologue
    .line 344
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->results:Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList;->getContent()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    return v0
.end method

.method public set(ILcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;)Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;
    .locals 1
    .param p1, "location"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement",
            "<*>;)",
            "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement",
            "<*>;"
        }
    .end annotation

    .prologue
    .line 312
    .local p2, "object":Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;, "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement<*>;"
    invoke-virtual {p2}, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->getLayoutElementModel()Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;

    move-result-object v0

    invoke-direct {p0, p1, v0}, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->setInModelMap(ILcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;)V

    .line 313
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->results:Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList;->getContent()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, p1, p2}, Ljava/util/List;->set(ILjava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;

    return-object v0
.end method

.method public size()I
    .locals 1

    .prologue
    .line 349
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->results:Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList;->getContent()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public updateModels(Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;)V
    .locals 4
    .param p1, "layoutElementModel"    # Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;

    .prologue
    .line 160
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->modelMapParkingLot:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    .line 161
    .local v0, "p":Ljava/lang/Integer;
    if-eqz v0, :cond_1

    .line 164
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->results:Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryList;->getContent()Ljava/util/List;

    move-result-object v1

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v2

    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->getLayoutElementModel()Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;

    move-result-object v1

    if-eq v1, p1, :cond_0

    .line 166
    new-instance v1, Ljava/lang/UnsupportedOperationException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "Cannot update models if element has moved. Element was originall saved at position "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 169
    :cond_0
    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v1

    invoke-direct {p0, v1, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->addToModelMap(ILcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;)V

    .line 171
    :cond_1
    return-void
.end method
