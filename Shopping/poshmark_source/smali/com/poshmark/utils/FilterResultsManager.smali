.class public Lcom/poshmark/utils/FilterResultsManager;
.super Ljava/lang/Object;
.source "FilterResultsManager.java"


# instance fields
.field currentColors:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/PMColor;",
            ">;"
        }
    .end annotation
.end field

.field currentPrices:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/PriceInfo;",
            ">;"
        }
    .end annotation
.end field

.field currentSizes:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation
.end field

.field currentSubCategories:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation
.end field

.field facets:Lcom/poshmark/data_model/models/Facets;

.field model:Lcom/poshmark/utils/SearchFilterModel;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 34
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 29
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/FilterResultsManager;->currentSizes:Ljava/util/List;

    .line 30
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/FilterResultsManager;->currentPrices:Ljava/util/List;

    .line 31
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/FilterResultsManager;->currentColors:Ljava/util/List;

    .line 32
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/FilterResultsManager;->currentSubCategories:Ljava/util/List;

    .line 35
    new-instance v0, Lcom/poshmark/utils/SearchFilterModel;

    invoke-direct {v0}, Lcom/poshmark/utils/SearchFilterModel;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/FilterResultsManager;->model:Lcom/poshmark/utils/SearchFilterModel;

    .line 36
    return-void
.end method


# virtual methods
.method public clearPriceSelection()V
    .locals 1

    .prologue
    .line 218
    iget-object v0, p0, Lcom/poshmark/utils/FilterResultsManager;->currentPrices:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 219
    iget-object v0, p0, Lcom/poshmark/utils/FilterResultsManager;->model:Lcom/poshmark/utils/SearchFilterModel;

    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel;->clearPrices()V

    .line 220
    return-void
.end method

.method public clearSizeSelection()V
    .locals 1

    .prologue
    .line 213
    iget-object v0, p0, Lcom/poshmark/utils/FilterResultsManager;->currentSizes:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 214
    iget-object v0, p0, Lcom/poshmark/utils/FilterResultsManager;->model:Lcom/poshmark/utils/SearchFilterModel;

    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel;->clearSizes()V

    .line 215
    return-void
.end method

.method public clearsubCategories()V
    .locals 1

    .prologue
    .line 223
    iget-object v0, p0, Lcom/poshmark/utils/FilterResultsManager;->currentSubCategories:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 224
    iget-object v0, p0, Lcom/poshmark/utils/FilterResultsManager;->model:Lcom/poshmark/utils/SearchFilterModel;

    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel;->clearSubCategories()V

    .line 225
    return-void
.end method

.method public getCommaSeparatedColors()Ljava/lang/String;
    .locals 5

    .prologue
    .line 199
    const-string v1, ""

    .line 200
    .local v1, "colors":Ljava/lang/String;
    iget-object v3, p0, Lcom/poshmark/utils/FilterResultsManager;->currentColors:Ljava/util/List;

    if-eqz v3, :cond_1

    iget-object v3, p0, Lcom/poshmark/utils/FilterResultsManager;->currentColors:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    if-lez v3, :cond_1

    .line 201
    iget-object v3, p0, Lcom/poshmark/utils/FilterResultsManager;->currentColors:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .line 202
    .local v2, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/PMColor;>;"
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 203
    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/PMColor;

    .line 204
    .local v0, "color":Lcom/poshmark/data_model/models/PMColor;
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/PMColor;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 205
    goto :goto_0

    .end local v0    # "color":Lcom/poshmark/data_model/models/PMColor;
    :cond_0
    move-object v3, v1

    .line 209
    .end local v2    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/PMColor;>;"
    :goto_1
    return-object v3

    :cond_1
    const-string v3, ""

    goto :goto_1
.end method

.method public getCommaSeparatedPrices()Ljava/lang/String;
    .locals 5

    .prologue
    .line 184
    const-string v2, ""

    .line 185
    .local v2, "price":Ljava/lang/String;
    iget-object v3, p0, Lcom/poshmark/utils/FilterResultsManager;->currentPrices:Ljava/util/List;

    if-eqz v3, :cond_1

    iget-object v3, p0, Lcom/poshmark/utils/FilterResultsManager;->currentPrices:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    if-lez v3, :cond_1

    .line 186
    iget-object v3, p0, Lcom/poshmark/utils/FilterResultsManager;->currentPrices:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 187
    .local v0, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/PriceInfo;>;"
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 188
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/data_model/models/PriceInfo;

    .line 189
    .local v1, "pInfo":Lcom/poshmark/data_model/models/PriceInfo;
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/PriceInfo;->getDisplay()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 190
    goto :goto_0

    .end local v1    # "pInfo":Lcom/poshmark/data_model/models/PriceInfo;
    :cond_0
    move-object v3, v2

    .line 195
    .end local v0    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/PriceInfo;>;"
    :goto_1
    return-object v3

    :cond_1
    const-string v3, ""

    goto :goto_1
.end method

.method public getCurrentAvailability()Lcom/poshmark/data_model/models/MetaItem;
    .locals 1

    .prologue
    .line 303
    iget-object v0, p0, Lcom/poshmark/utils/FilterResultsManager;->model:Lcom/poshmark/utils/SearchFilterModel;

    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel;->getAvailabilityAsMetaItem()Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v0

    return-object v0
.end method

.method public getCurrentBrand()Lcom/poshmark/data_model/models/MetaItem;
    .locals 3

    .prologue
    .line 294
    const/4 v1, 0x0

    .line 295
    .local v1, "item":Lcom/poshmark/data_model/models/MetaItem;
    iget-object v2, p0, Lcom/poshmark/utils/FilterResultsManager;->model:Lcom/poshmark/utils/SearchFilterModel;

    invoke-virtual {v2}, Lcom/poshmark/utils/SearchFilterModel;->getBrand()Ljava/lang/String;

    move-result-object v0

    .line 296
    .local v0, "currentBrand":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 297
    new-instance v1, Lcom/poshmark/data_model/models/MetaItem;

    .end local v1    # "item":Lcom/poshmark/data_model/models/MetaItem;
    invoke-direct {v1, v0, v0}, Lcom/poshmark/data_model/models/MetaItem;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 299
    .restart local v1    # "item":Lcom/poshmark/data_model/models/MetaItem;
    :cond_0
    return-object v1
.end method

.method public getCurrentCategory()Lcom/poshmark/data_model/models/MetaItem;
    .locals 3

    .prologue
    .line 274
    const/4 v1, 0x0

    .line 275
    .local v1, "item":Lcom/poshmark/data_model/models/MetaItem;
    iget-object v2, p0, Lcom/poshmark/utils/FilterResultsManager;->model:Lcom/poshmark/utils/SearchFilterModel;

    invoke-virtual {v2}, Lcom/poshmark/utils/SearchFilterModel;->getCategory()Ljava/lang/String;

    move-result-object v0

    .line 277
    .local v0, "currentCategory":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 278
    invoke-static {v0}, Lcom/poshmark/db/DbApi;->getCurrentCategoryFromId(Ljava/lang/String;)Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v1

    .line 280
    :cond_0
    return-object v1
.end method

.method public getCurrentColorSelections()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/PMColor;",
            ">;"
        }
    .end annotation

    .prologue
    .line 176
    iget-object v0, p0, Lcom/poshmark/utils/FilterResultsManager;->currentColors:Ljava/util/List;

    return-object v0
.end method

.method public getCurrentCondition()Lcom/poshmark/data_model/models/MetaItem;
    .locals 1

    .prologue
    .line 307
    iget-object v0, p0, Lcom/poshmark/utils/FilterResultsManager;->model:Lcom/poshmark/utils/SearchFilterModel;

    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel;->getConditionAsMetaItem()Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v0

    return-object v0
.end method

.method public getCurrentPriceSelections()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/PriceInfo;",
            ">;"
        }
    .end annotation

    .prologue
    .line 172
    iget-object v0, p0, Lcom/poshmark/utils/FilterResultsManager;->currentPrices:Ljava/util/List;

    return-object v0
.end method

.method public getCurrentSizeSelections()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 168
    iget-object v0, p0, Lcom/poshmark/utils/FilterResultsManager;->currentSizes:Ljava/util/List;

    return-object v0
.end method

.method public getCurrentSubCategories()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 180
    iget-object v0, p0, Lcom/poshmark/utils/FilterResultsManager;->currentSubCategories:Ljava/util/List;

    return-object v0
.end method

.method public getCurrentSubCategory()Lcom/poshmark/data_model/models/MetaItem;
    .locals 3

    .prologue
    .line 284
    const/4 v1, 0x0

    .line 285
    .local v1, "item":Lcom/poshmark/data_model/models/MetaItem;
    iget-object v2, p0, Lcom/poshmark/utils/FilterResultsManager;->model:Lcom/poshmark/utils/SearchFilterModel;

    invoke-virtual {v2}, Lcom/poshmark/utils/SearchFilterModel;->getSubCategory()Ljava/lang/String;

    move-result-object v0

    .line 287
    .local v0, "currentSubCategory":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 288
    invoke-static {v0}, Lcom/poshmark/db/DbApi;->getSubCategoryFromId(Ljava/lang/String;)Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v1

    .line 290
    :cond_0
    return-object v1
.end method

.method public getSearchModel()Lcom/poshmark/utils/SearchFilterModel;
    .locals 1

    .prologue
    .line 88
    iget-object v0, p0, Lcom/poshmark/utils/FilterResultsManager;->model:Lcom/poshmark/utils/SearchFilterModel;

    return-object v0
.end method

.method public getSearchRequestString()Ljava/lang/String;
    .locals 5

    .prologue
    .line 261
    new-instance v1, Lcom/poshmark/utils/SearchFilterModel;

    iget-object v4, p0, Lcom/poshmark/utils/FilterResultsManager;->model:Lcom/poshmark/utils/SearchFilterModel;

    invoke-direct {v1, v4}, Lcom/poshmark/utils/SearchFilterModel;-><init>(Lcom/poshmark/utils/SearchFilterModel;)V

    .line 262
    .local v1, "copy":Lcom/poshmark/utils/SearchFilterModel;
    invoke-virtual {v1}, Lcom/poshmark/utils/SearchFilterModel;->adjustCategorySubCategory()V

    .line 263
    new-instance v0, Lcom/google/gson/GsonBuilder;

    invoke-direct {v0}, Lcom/google/gson/GsonBuilder;-><init>()V

    .line 264
    .local v0, "b":Lcom/google/gson/GsonBuilder;
    invoke-virtual {v0}, Lcom/google/gson/GsonBuilder;->create()Lcom/google/gson/Gson;

    move-result-object v2

    .line 265
    .local v2, "gson":Lcom/google/gson/Gson;
    instance-of v4, v2, Lcom/google/gson/Gson;

    if-nez v4, :cond_0

    invoke-virtual {v2, v1}, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    .line 266
    .end local v2    # "gson":Lcom/google/gson/Gson;
    .local v3, "searchString":Ljava/lang/String;
    :goto_0
    return-object v3

    .line 265
    .end local v3    # "searchString":Ljava/lang/String;
    .restart local v2    # "gson":Lcom/google/gson/Gson;
    :cond_0
    check-cast v2, Lcom/google/gson/Gson;

    .end local v2    # "gson":Lcom/google/gson/Gson;
    invoke-static {v2, v1}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->toJson(Lcom/google/gson/Gson;Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    goto :goto_0
.end method

.method public isMySizeEnabled()Z
    .locals 1

    .prologue
    .line 311
    iget-object v0, p0, Lcom/poshmark/utils/FilterResultsManager;->model:Lcom/poshmark/utils/SearchFilterModel;

    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel;->getFilters()Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->isMySizeEnabled()Z

    move-result v0

    return v0
.end method

.method public pullFromBundle(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "inState"    # Landroid/os/Bundle;

    .prologue
    .line 254
    const-string v1, "SAVED_FILTER_MODEL_JSON"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 255
    .local v0, "json":Ljava/lang/String;
    const-class v1, Lcom/poshmark/utils/SearchFilterModel;

    invoke-static {v0, v1}, Lcom/poshmark/utils/StringUtils;->fromJson(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/utils/SearchFilterModel;

    iput-object v1, p0, Lcom/poshmark/utils/FilterResultsManager;->model:Lcom/poshmark/utils/SearchFilterModel;

    .line 256
    iget-object v1, p0, Lcom/poshmark/utils/FilterResultsManager;->model:Lcom/poshmark/utils/SearchFilterModel;

    const-string v2, "SAVED_SEARCH_TRIGGER"

    invoke-virtual {p1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/poshmark/utils/SearchFilterModel;->setSearchTrigger(Ljava/lang/String;)V

    .line 257
    return-void
.end method

.method public saveToBundle(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 248
    iget-object v1, p0, Lcom/poshmark/utils/FilterResultsManager;->model:Lcom/poshmark/utils/SearchFilterModel;

    invoke-static {v1}, Lcom/poshmark/utils/StringUtils;->toJson(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 249
    .local v0, "json":Ljava/lang/String;
    const-string v1, "SAVED_FILTER_MODEL_JSON"

    invoke-virtual {p1, v1, v0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 250
    const-string v1, "SAVED_SEARCH_TRIGGER"

    iget-object v2, p0, Lcom/poshmark/utils/FilterResultsManager;->model:Lcom/poshmark/utils/SearchFilterModel;

    invoke-virtual {v2}, Lcom/poshmark/utils/SearchFilterModel;->getSearchTrigger()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 251
    return-void
.end method

.method public setFacet(Ljava/lang/String;)V
    .locals 1
    .param p1, "facet"    # Ljava/lang/String;

    .prologue
    .line 270
    iget-object v0, p0, Lcom/poshmark/utils/FilterResultsManager;->model:Lcom/poshmark/utils/SearchFilterModel;

    invoke-virtual {v0, p1}, Lcom/poshmark/utils/SearchFilterModel;->setFacet(Ljava/lang/String;)V

    .line 271
    return-void
.end method

.method public setSearchModel(Lcom/poshmark/utils/SearchFilterModel;)V
    .locals 18
    .param p1, "model"    # Lcom/poshmark/utils/SearchFilterModel;

    .prologue
    .line 39
    move-object/from16 v0, p1

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/poshmark/utils/FilterResultsManager;->model:Lcom/poshmark/utils/SearchFilterModel;

    .line 41
    invoke-virtual/range {p1 .. p1}, Lcom/poshmark/utils/SearchFilterModel;->getFilters()Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    move-result-object v14

    invoke-virtual {v14}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->getSizeList()Ljava/util/List;

    move-result-object v10

    .line 42
    .local v10, "sizes":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    if-eqz v10, :cond_0

    invoke-interface {v10}, Ljava/util/List;->size()I

    move-result v14

    if-lez v14, :cond_0

    .line 43
    invoke-interface {v10}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v6

    .line 44
    .local v6, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :goto_0
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v14

    if-eqz v14, :cond_0

    .line 45
    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/lang/String;

    .line 46
    .local v9, "sizeLabel":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/poshmark/utils/FilterResultsManager;->currentSizes:Ljava/util/List;

    new-instance v15, Lcom/poshmark/data_model/models/MetaItem;

    invoke-direct {v15, v9, v9}, Lcom/poshmark/data_model/models/MetaItem;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v14, v15}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 51
    .end local v6    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    .end local v9    # "sizeLabel":Ljava/lang/String;
    :cond_0
    invoke-virtual/range {p1 .. p1}, Lcom/poshmark/utils/SearchFilterModel;->getFilters()Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    move-result-object v14

    invoke-virtual {v14}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->getPriceRangeList()Ljava/util/List;

    move-result-object v8

    .line 52
    .local v8, "prices":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/PriceInfo;>;"
    if-eqz v8, :cond_1

    invoke-interface {v8}, Ljava/util/List;->size()I

    move-result v14

    if-lez v14, :cond_1

    .line 53
    invoke-interface {v8}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v5

    .line 54
    .local v5, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/PriceInfo;>;"
    :goto_1
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v14

    if-eqz v14, :cond_1

    .line 55
    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/poshmark/data_model/models/PriceInfo;

    .line 56
    .local v7, "priceInfo":Lcom/poshmark/data_model/models/PriceInfo;
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/poshmark/utils/FilterResultsManager;->currentPrices:Ljava/util/List;

    new-instance v15, Lcom/poshmark/data_model/models/PriceInfo;

    invoke-virtual {v7}, Lcom/poshmark/data_model/models/PriceInfo;->getMin()Ljava/lang/String;

    move-result-object v16

    invoke-virtual {v7}, Lcom/poshmark/data_model/models/PriceInfo;->getMax()Ljava/lang/String;

    move-result-object v17

    invoke-direct/range {v15 .. v17}, Lcom/poshmark/data_model/models/PriceInfo;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v14, v15}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 61
    .end local v5    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/PriceInfo;>;"
    .end local v7    # "priceInfo":Lcom/poshmark/data_model/models/PriceInfo;
    :cond_1
    invoke-virtual/range {p1 .. p1}, Lcom/poshmark/utils/SearchFilterModel;->getColorList()Ljava/util/List;

    move-result-object v4

    .line 62
    .local v4, "colors":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    if-eqz v4, :cond_3

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v14

    if-lez v14, :cond_3

    .line 63
    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v6

    .line 64
    .restart local v6    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :cond_2
    :goto_2
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v14

    if-eqz v14, :cond_3

    .line 65
    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 66
    .local v3, "colorLabel":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/controllers/GlobalDbController;->getGlobalDbController()Lcom/poshmark/controllers/GlobalDbController;

    move-result-object v14

    invoke-virtual {v14, v3}, Lcom/poshmark/controllers/GlobalDbController;->getColorFromName(Ljava/lang/String;)Lcom/poshmark/data_model/models/PMColor;

    move-result-object v2

    .line 67
    .local v2, "color":Lcom/poshmark/data_model/models/PMColor;
    if-eqz v2, :cond_2

    .line 68
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/poshmark/utils/FilterResultsManager;->currentColors:Ljava/util/List;

    invoke-interface {v14, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_2

    .line 74
    .end local v2    # "color":Lcom/poshmark/data_model/models/PMColor;
    .end local v3    # "colorLabel":Ljava/lang/String;
    .end local v6    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :cond_3
    invoke-virtual/range {p1 .. p1}, Lcom/poshmark/utils/SearchFilterModel;->getSubCategories()Ljava/util/List;

    move-result-object v13

    .line 75
    .local v13, "tags":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    if-eqz v13, :cond_5

    invoke-interface {v13}, Ljava/util/List;->size()I

    move-result v14

    if-lez v14, :cond_5

    .line 76
    invoke-interface {v13}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v6

    .line 77
    .restart local v6    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :cond_4
    :goto_3
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v14

    if-eqz v14, :cond_5

    .line 78
    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Ljava/lang/String;

    .line 79
    .local v12, "tag":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/controllers/GlobalDbController;->getGlobalDbController()Lcom/poshmark/controllers/GlobalDbController;

    move-result-object v14

    invoke-virtual {v14, v12}, Lcom/poshmark/controllers/GlobalDbController;->getSubCategoryFromId(Ljava/lang/String;)Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v11

    .line 80
    .local v11, "styleTag":Lcom/poshmark/data_model/models/MetaItem;
    if-eqz v11, :cond_4

    .line 81
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/poshmark/utils/FilterResultsManager;->currentSubCategories:Ljava/util/List;

    invoke-interface {v14, v11}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_3

    .line 85
    .end local v6    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    .end local v11    # "styleTag":Lcom/poshmark/data_model/models/MetaItem;
    .end local v12    # "tag":Ljava/lang/String;
    :cond_5
    return-void
.end method

.method public toggleMySize()V
    .locals 3

    .prologue
    .line 315
    iget-object v1, p0, Lcom/poshmark/utils/FilterResultsManager;->model:Lcom/poshmark/utils/SearchFilterModel;

    invoke-virtual {v1}, Lcom/poshmark/utils/SearchFilterModel;->getFilters()Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->isMySizeEnabled()Z

    move-result v0

    .line 316
    .local v0, "currentState":Z
    iget-object v1, p0, Lcom/poshmark/utils/FilterResultsManager;->model:Lcom/poshmark/utils/SearchFilterModel;

    invoke-virtual {v1}, Lcom/poshmark/utils/SearchFilterModel;->getFilters()Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    move-result-object v2

    if-nez v0, :cond_0

    const/4 v1, 0x1

    :goto_0
    invoke-virtual {v2, v1}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->enableMySize(Z)V

    .line 317
    return-void

    .line 316
    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public updateAvailability(Lcom/poshmark/data_model/models/MetaItem;)V
    .locals 3
    .param p1, "metaItem"    # Lcom/poshmark/data_model/models/MetaItem;

    .prologue
    .line 118
    iget-object v0, p0, Lcom/poshmark/utils/FilterResultsManager;->model:Lcom/poshmark/utils/SearchFilterModel;

    if-eqz v0, :cond_0

    .line 119
    iget-object v0, p0, Lcom/poshmark/utils/FilterResultsManager;->model:Lcom/poshmark/utils/SearchFilterModel;

    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel;->clearAvailability()V

    .line 120
    invoke-virtual {p1}, Lcom/poshmark/data_model/models/MetaItem;->getDisplay()Ljava/lang/String;

    move-result-object v0

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    const v2, 0x7f060040

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 121
    iget-object v0, p0, Lcom/poshmark/utils/FilterResultsManager;->model:Lcom/poshmark/utils/SearchFilterModel;

    invoke-virtual {p1}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/SearchFilterModel;->setAvailability(Ljava/lang/String;)V

    .line 124
    :cond_0
    return-void
.end method

.method public updateBrand(Lcom/poshmark/data_model/models/MetaItem;)V
    .locals 2
    .param p1, "brand"    # Lcom/poshmark/data_model/models/MetaItem;

    .prologue
    .line 92
    iget-object v0, p0, Lcom/poshmark/utils/FilterResultsManager;->model:Lcom/poshmark/utils/SearchFilterModel;

    if-eqz v0, :cond_0

    .line 95
    iget-object v0, p0, Lcom/poshmark/utils/FilterResultsManager;->model:Lcom/poshmark/utils/SearchFilterModel;

    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel;->clearBrand()V

    .line 96
    iget-object v0, p0, Lcom/poshmark/utils/FilterResultsManager;->model:Lcom/poshmark/utils/SearchFilterModel;

    invoke-virtual {p1}, Lcom/poshmark/data_model/models/MetaItem;->getDisplay()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/SearchFilterModel;->setBrand(Ljava/lang/String;)V

    .line 99
    :cond_0
    return-void
.end method

.method public updateCategory(Lcom/poshmark/data_model/models/MetaItem;)V
    .locals 2
    .param p1, "metaItem"    # Lcom/poshmark/data_model/models/MetaItem;

    .prologue
    .line 102
    iget-object v0, p0, Lcom/poshmark/utils/FilterResultsManager;->model:Lcom/poshmark/utils/SearchFilterModel;

    if-eqz v0, :cond_0

    .line 103
    iget-object v0, p0, Lcom/poshmark/utils/FilterResultsManager;->model:Lcom/poshmark/utils/SearchFilterModel;

    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel;->clearCategory()V

    .line 104
    iget-object v0, p0, Lcom/poshmark/utils/FilterResultsManager;->model:Lcom/poshmark/utils/SearchFilterModel;

    invoke-virtual {p1}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/SearchFilterModel;->setCategory(Ljava/lang/String;)V

    .line 106
    :cond_0
    return-void
.end method

.method public updateColors(Ljava/util/List;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/PMColor;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 153
    .local p1, "colors":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/PMColor;>;"
    iget-object v2, p0, Lcom/poshmark/utils/FilterResultsManager;->model:Lcom/poshmark/utils/SearchFilterModel;

    if-eqz v2, :cond_0

    .line 154
    iget-object v2, p0, Lcom/poshmark/utils/FilterResultsManager;->model:Lcom/poshmark/utils/SearchFilterModel;

    invoke-virtual {v2}, Lcom/poshmark/utils/SearchFilterModel;->clearColors()V

    .line 155
    iget-object v2, p0, Lcom/poshmark/utils/FilterResultsManager;->currentColors:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->clear()V

    .line 156
    if-eqz p1, :cond_0

    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v2

    if-lez v2, :cond_0

    .line 157
    iput-object p1, p0, Lcom/poshmark/utils/FilterResultsManager;->currentColors:Ljava/util/List;

    .line 158
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 159
    .local v1, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/PMColor;>;"
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 160
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/PMColor;

    .line 161
    .local v0, "color":Lcom/poshmark/data_model/models/PMColor;
    iget-object v2, p0, Lcom/poshmark/utils/FilterResultsManager;->model:Lcom/poshmark/utils/SearchFilterModel;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/PMColor;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/poshmark/utils/SearchFilterModel;->addColor(Ljava/lang/String;)V

    goto :goto_0

    .line 165
    .end local v0    # "color":Lcom/poshmark/data_model/models/PMColor;
    .end local v1    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/PMColor;>;"
    :cond_0
    return-void
.end method

.method public updateCondition(Lcom/poshmark/data_model/models/MetaItem;)V
    .locals 2
    .param p1, "metaItem"    # Lcom/poshmark/data_model/models/MetaItem;

    .prologue
    .line 109
    iget-object v0, p0, Lcom/poshmark/utils/FilterResultsManager;->model:Lcom/poshmark/utils/SearchFilterModel;

    if-eqz v0, :cond_0

    .line 110
    iget-object v0, p0, Lcom/poshmark/utils/FilterResultsManager;->model:Lcom/poshmark/utils/SearchFilterModel;

    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel;->clearCondition()V

    .line 111
    invoke-virtual {p1}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v0

    const-string v1, "not_nwt"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 112
    iget-object v0, p0, Lcom/poshmark/utils/FilterResultsManager;->model:Lcom/poshmark/utils/SearchFilterModel;

    invoke-virtual {p1}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/SearchFilterModel;->setCondition(Ljava/lang/String;)V

    .line 115
    :cond_0
    return-void
.end method

.method public updatePrices(Ljava/util/List;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/PriceInfo;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 229
    .local p1, "prices":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/PriceInfo;>;"
    iget-object v2, p0, Lcom/poshmark/utils/FilterResultsManager;->model:Lcom/poshmark/utils/SearchFilterModel;

    if-eqz v2, :cond_0

    .line 230
    iget-object v2, p0, Lcom/poshmark/utils/FilterResultsManager;->model:Lcom/poshmark/utils/SearchFilterModel;

    invoke-virtual {v2}, Lcom/poshmark/utils/SearchFilterModel;->getFilters()Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->clearPriceRangeList()V

    .line 231
    iget-object v2, p0, Lcom/poshmark/utils/FilterResultsManager;->currentPrices:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->clear()V

    .line 232
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v2

    if-lez v2, :cond_0

    .line 233
    iput-object p1, p0, Lcom/poshmark/utils/FilterResultsManager;->currentPrices:Ljava/util/List;

    .line 234
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 235
    .local v0, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/PriceInfo;>;"
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 236
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/data_model/models/PriceInfo;

    .line 237
    .local v1, "price":Lcom/poshmark/data_model/models/PriceInfo;
    iget-object v2, p0, Lcom/poshmark/utils/FilterResultsManager;->model:Lcom/poshmark/utils/SearchFilterModel;

    invoke-virtual {v2}, Lcom/poshmark/utils/SearchFilterModel;->getFilters()Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    move-result-object v2

    invoke-virtual {v2, v1}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->addPriceRange(Lcom/poshmark/data_model/models/PriceInfo;)V

    goto :goto_0

    .line 241
    .end local v0    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/PriceInfo;>;"
    .end local v1    # "price":Lcom/poshmark/data_model/models/PriceInfo;
    :cond_0
    return-void
.end method

.method public updateSizes(Ljava/util/List;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 127
    .local p1, "sizes":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    iget-object v2, p0, Lcom/poshmark/utils/FilterResultsManager;->model:Lcom/poshmark/utils/SearchFilterModel;

    if-eqz v2, :cond_0

    .line 128
    iget-object v2, p0, Lcom/poshmark/utils/FilterResultsManager;->model:Lcom/poshmark/utils/SearchFilterModel;

    invoke-virtual {v2}, Lcom/poshmark/utils/SearchFilterModel;->getFilters()Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->clearSizeList()V

    .line 129
    iget-object v2, p0, Lcom/poshmark/utils/FilterResultsManager;->currentSizes:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->clear()V

    .line 130
    if-eqz p1, :cond_0

    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v2

    if-lez v2, :cond_0

    .line 131
    iput-object p1, p0, Lcom/poshmark/utils/FilterResultsManager;->currentSizes:Ljava/util/List;

    .line 132
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 133
    .local v1, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/MetaItem;>;"
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 134
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/MetaItem;

    .line 135
    .local v0, "item":Lcom/poshmark/data_model/models/MetaItem;
    iget-object v2, p0, Lcom/poshmark/utils/FilterResultsManager;->model:Lcom/poshmark/utils/SearchFilterModel;

    invoke-virtual {v2}, Lcom/poshmark/utils/SearchFilterModel;->getFilters()Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    move-result-object v2

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->addSize(Ljava/lang/String;)V

    goto :goto_0

    .line 139
    .end local v0    # "item":Lcom/poshmark/data_model/models/MetaItem;
    .end local v1    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/MetaItem;>;"
    :cond_0
    return-void
.end method

.method public updateSubCatogories(Ljava/util/List;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 142
    .local p1, "tags":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    iget-object v0, p0, Lcom/poshmark/utils/FilterResultsManager;->model:Lcom/poshmark/utils/SearchFilterModel;

    if-eqz v0, :cond_0

    .line 143
    iget-object v0, p0, Lcom/poshmark/utils/FilterResultsManager;->model:Lcom/poshmark/utils/SearchFilterModel;

    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel;->clearSubCategories()V

    .line 144
    iget-object v0, p0, Lcom/poshmark/utils/FilterResultsManager;->currentSubCategories:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 145
    if-eqz p1, :cond_0

    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 146
    iput-object p1, p0, Lcom/poshmark/utils/FilterResultsManager;->currentSubCategories:Ljava/util/List;

    .line 147
    iget-object v0, p0, Lcom/poshmark/utils/FilterResultsManager;->model:Lcom/poshmark/utils/SearchFilterModel;

    iget-object v1, p0, Lcom/poshmark/utils/FilterResultsManager;->currentSubCategories:Ljava/util/List;

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/SearchFilterModel;->setSubCategories(Ljava/util/List;)V

    .line 150
    :cond_0
    return-void
.end method

.method public updateViews()V
    .locals 2

    .prologue
    .line 244
    const-string v0, "com.poshmark.intents.UPDATE_SEARCH_DRAWER"

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/poshmark/notifications/PMNotificationManager;->fireNotification(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 245
    return-void
.end method
