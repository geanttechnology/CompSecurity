.class public Lcom/poshmark/ui/fragments/SearchResultsFragment;
.super Lcom/poshmark/ui/fragments/PMFilterableFragment;
.source "SearchResultsFragment.java"

# interfaces
.implements Lcom/poshmark/notifications/PMNotificationListener;


# instance fields
.field private adapter:Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;

.field keywordSource:Ljava/lang/String;

.field resultsListView:Lcom/poshmark/ui/customviews/PMListView;

.field screenStackTag:Ljava/lang/String;

.field searchResultsData:Lcom/poshmark/data_model/models/SearchResults;

.field searchTrigger:Ljava/lang/String;

.field searchView:Lcom/poshmark/ui/customviews/PMCustomSearchWidget;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 41
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;-><init>()V

    .line 43
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->adapter:Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;

    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/ui/fragments/SearchResultsFragment;Z)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/SearchResultsFragment;
    .param p1, "x1"    # Z

    .prologue
    .line 41
    invoke-direct {p0, p1}, Lcom/poshmark/ui/fragments/SearchResultsFragment;->getSearchResults(Z)V

    return-void
.end method

.method static synthetic access$100(Lcom/poshmark/ui/fragments/SearchResultsFragment;Lcom/poshmark/http/api/PMApiResponse;Z)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/SearchResultsFragment;
    .param p1, "x1"    # Lcom/poshmark/http/api/PMApiResponse;
    .param p2, "x2"    # Z

    .prologue
    .line 41
    invoke-direct {p0, p1, p2}, Lcom/poshmark/ui/fragments/SearchResultsFragment;->handleResponse(Lcom/poshmark/http/api/PMApiResponse;Z)V

    return-void
.end method

.method private getSearchResults(Z)V
    .locals 6
    .param p1, "isPagination"    # Z

    .prologue
    const/4 v5, 0x0

    .line 235
    if-nez p1, :cond_2

    .line 236
    iget-object v2, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->filterWidget:Lcom/poshmark/ui/customviews/ListingsFilterWidget;

    if-eqz v2, :cond_0

    .line 237
    iget-object v2, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->filterWidget:Lcom/poshmark/ui/customviews/ListingsFilterWidget;

    const/16 v3, 0x8

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->setVisibility(I)V

    .line 238
    iget-object v2, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->filterWidget:Lcom/poshmark/ui/customviews/ListingsFilterWidget;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->updateFilterWidget()V

    .line 241
    :cond_0
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SearchResultsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f06023b

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/SearchResultsFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 242
    iget-object v2, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->resultsListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/PMListView;->removeEmptyContentView()V

    .line 243
    iget-object v2, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->searchManager:Lcom/poshmark/utils/FilterResultsManager;

    invoke-virtual {v2}, Lcom/poshmark/utils/FilterResultsManager;->getSearchRequestString()Ljava/lang/String;

    move-result-object v1

    .line 244
    .local v1, "searchString":Ljava/lang/String;
    iget-object v2, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->searchTrigger:Ljava/lang/String;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->keywordSource:Ljava/lang/String;

    new-instance v4, Lcom/poshmark/ui/fragments/SearchResultsFragment$3;

    invoke-direct {v4, p0}, Lcom/poshmark/ui/fragments/SearchResultsFragment$3;-><init>(Lcom/poshmark/ui/fragments/SearchResultsFragment;)V

    invoke-static {v1, v5, v2, v3, v4}, Lcom/poshmark/http/api/PMApi;->getSearchResults(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 270
    .end local v1    # "searchString":Ljava/lang/String;
    :cond_1
    :goto_0
    return-void

    .line 256
    :cond_2
    iget-object v2, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->searchResultsData:Lcom/poshmark/data_model/models/SearchResults;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/SearchResults;->getNextPageMaxValue()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_1

    .line 257
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SearchResultsFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v0

    .line 258
    .local v0, "model":Lcom/poshmark/utils/SearchFilterModel;
    iget-object v2, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->searchResultsData:Lcom/poshmark/data_model/models/SearchResults;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/SearchResults;->getNextPageMaxValue()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/poshmark/utils/SearchFilterModel;->setNextPageId(Ljava/lang/String;)V

    .line 259
    iget-object v2, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->searchManager:Lcom/poshmark/utils/FilterResultsManager;

    invoke-virtual {v2}, Lcom/poshmark/utils/FilterResultsManager;->getSearchRequestString()Ljava/lang/String;

    move-result-object v1

    .line 260
    .restart local v1    # "searchString":Ljava/lang/String;
    iget-object v2, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->searchResultsData:Lcom/poshmark/data_model/models/SearchResults;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/SearchResults;->getNextPageMaxValue()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lcom/poshmark/ui/fragments/SearchResultsFragment$4;

    invoke-direct {v3, p0}, Lcom/poshmark/ui/fragments/SearchResultsFragment$4;-><init>(Lcom/poshmark/ui/fragments/SearchResultsFragment;)V

    invoke-static {v1, v2, v5, v5, v3}, Lcom/poshmark/http/api/PMApi;->getSearchResults(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    goto :goto_0
.end method

.method private getSearchTitle()Ljava/lang/String;
    .locals 9

    .prologue
    .line 191
    const-string v6, ""

    .line 192
    .local v6, "title":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SearchResultsFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v4

    .line 193
    .local v4, "model":Lcom/poshmark/utils/SearchFilterModel;
    iget-object v7, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->searchTrigger:Ljava/lang/String;

    if-eqz v7, :cond_0

    if-eqz v4, :cond_0

    .line 194
    iget-object v7, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->searchTrigger:Ljava/lang/String;

    const-string v8, "br"

    invoke-virtual {v7, v8}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_1

    .line 195
    invoke-virtual {v4}, Lcom/poshmark/utils/SearchFilterModel;->getBrand()Ljava/lang/String;

    move-result-object v6

    .line 196
    if-nez v6, :cond_0

    .line 197
    const-string v6, "All Brands"

    .line 225
    :cond_0
    :goto_0
    return-object v6

    .line 199
    :cond_1
    iget-object v7, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->searchTrigger:Ljava/lang/String;

    const-string v8, "ct"

    invoke-virtual {v7, v8}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_3

    .line 200
    invoke-virtual {v4}, Lcom/poshmark/utils/SearchFilterModel;->getCategory()Ljava/lang/String;

    move-result-object v3

    .line 201
    .local v3, "id":Ljava/lang/String;
    invoke-static {v3}, Lcom/poshmark/db/DbApi;->getCurrentCategoryFromId(Ljava/lang/String;)Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v0

    .line 202
    .local v0, "category":Lcom/poshmark/data_model/models/MetaItem;
    if-eqz v0, :cond_2

    .line 203
    invoke-virtual {v0}, Lcom/poshmark/data_model/models/MetaItem;->getDisplay()Ljava/lang/String;

    move-result-object v6

    .line 205
    :cond_2
    if-nez v6, :cond_0

    .line 206
    const-string v6, "All Categories"

    goto :goto_0

    .line 208
    .end local v0    # "category":Lcom/poshmark/data_model/models/MetaItem;
    .end local v3    # "id":Ljava/lang/String;
    :cond_3
    iget-object v7, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->searchTrigger:Ljava/lang/String;

    const-string v8, "sl"

    invoke-virtual {v7, v8}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_4

    .line 209
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "\""

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v4}, Lcom/poshmark/utils/SearchFilterModel;->getQueryText()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, "\""

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    goto :goto_0

    .line 210
    :cond_4
    iget-object v7, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->searchTrigger:Ljava/lang/String;

    const-string v8, "clr"

    invoke-virtual {v7, v8}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_0

    .line 211
    invoke-virtual {v4}, Lcom/poshmark/utils/SearchFilterModel;->getColorList()Ljava/util/List;

    move-result-object v1

    .line 212
    .local v1, "colors":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    if-eqz v1, :cond_6

    invoke-interface {v1}, Ljava/util/List;->isEmpty()Z

    move-result v7

    if-nez v7, :cond_6

    .line 213
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v5

    .line 214
    .local v5, "numColors":I
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_1
    if-ge v2, v5, :cond_0

    .line 215
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v7, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/String;

    invoke-virtual {v8, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    .line 216
    add-int/lit8 v7, v2, 0x1

    if-ge v7, v5, :cond_5

    .line 217
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v7, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, ", "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    .line 214
    :cond_5
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 221
    .end local v2    # "i":I
    .end local v5    # "numColors":I
    :cond_6
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v7, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, "All Colors"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    goto/16 :goto_0
.end method

.method private handleResponse(Lcom/poshmark/http/api/PMApiResponse;Z)V
    .locals 6
    .param p2, "isPagination"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiResponse",
            "<",
            "Lcom/poshmark/data_model/models/SearchResults;",
            ">;Z)V"
        }
    .end annotation

    .prologue
    .line 273
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/data_model/models/SearchResults;>;"
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SearchResultsFragment;->hideProgressDialog()V

    .line 274
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v2

    if-nez v2, :cond_3

    .line 275
    if-nez p2, :cond_2

    .line 276
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SearchResultsFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/utils/SearchFilterModel;->getLabelForAnalytics()Ljava/lang/String;

    move-result-object v1

    .line 277
    .local v1, "label":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v2

    iget-object v3, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v4, "listing"

    const-string v5, "listings_filtered"

    invoke-virtual {v2, v3, v4, v5, v1}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 279
    iget-object v0, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v0, Lcom/poshmark/data_model/models/SearchResults;

    .line 280
    .local v0, "data":Lcom/poshmark/data_model/models/SearchResults;
    invoke-virtual {v0}, Lcom/poshmark/data_model/models/SearchResults;->getFacets()Lcom/poshmark/data_model/models/Facets;

    move-result-object v2

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/SearchResultsFragment;->saveFacetLists(Lcom/poshmark/data_model/models/Facets;)V

    .line 281
    iput-object v0, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->searchResultsData:Lcom/poshmark/data_model/models/SearchResults;

    .line 282
    iget-object v2, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->resultsListView:Lcom/poshmark/ui/customviews/PMListView;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->searchResultsData:Lcom/poshmark/data_model/models/SearchResults;

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/customviews/PMListView;->setListData(Lcom/poshmark/data_model/models/PMData;)V

    .line 283
    iget-object v2, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->resultsListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/PMListView;->updateList()V

    .line 284
    iget-object v2, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->resultsListView:Lcom/poshmark/ui/customviews/PMListView;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/customviews/PMListView;->setSelection(I)V

    .line 285
    invoke-virtual {v0}, Lcom/poshmark/data_model/models/SearchResults;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 286
    iget-object v2, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->resultsListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/PMListView;->showDefaultEmptyContentView()V

    .line 288
    :cond_0
    iget-object v2, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->searchView:Lcom/poshmark/ui/customviews/PMCustomSearchWidget;

    if-eqz v2, :cond_1

    .line 289
    iget-object v2, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->searchView:Lcom/poshmark/ui/customviews/PMCustomSearchWidget;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SearchResultsFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/utils/SearchFilterModel;->getQueryText()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->setSilentText(Ljava/lang/String;)V

    .line 290
    iget-object v2, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->searchView:Lcom/poshmark/ui/customviews/PMCustomSearchWidget;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->clearFocus()V

    .line 303
    .end local v0    # "data":Lcom/poshmark/data_model/models/SearchResults;
    .end local v1    # "label":Ljava/lang/String;
    :cond_1
    :goto_0
    return-void

    .line 293
    :cond_2
    iget-object v0, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v0, Lcom/poshmark/data_model/models/SearchResults;

    .line 294
    .restart local v0    # "data":Lcom/poshmark/data_model/models/SearchResults;
    iget-object v2, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->searchResultsData:Lcom/poshmark/data_model/models/SearchResults;

    invoke-virtual {v2, v0}, Lcom/poshmark/data_model/models/SearchResults;->append(Lcom/poshmark/data_model/models/PMData;)V

    .line 295
    iget-object v2, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->resultsListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/PMListView;->updateList()V

    goto :goto_0

    .line 300
    .end local v0    # "data":Lcom/poshmark/data_model/models/SearchResults;
    :cond_3
    if-nez p2, :cond_1

    .line 301
    new-instance v2, Lcom/poshmark/ui/model/ActionErrorContext;

    iget-object v3, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    sget-object v4, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->LOAD_LISTING:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    invoke-direct {v2, v3, v4}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;)V

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/SearchResultsFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;)V

    goto :goto_0
.end method

.method private setScreenTagBasedOnSearchType()V
    .locals 2

    .prologue
    .line 331
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SearchResultsFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v0

    .line 332
    .local v0, "model":Lcom/poshmark/utils/SearchFilterModel;
    if-eqz v0, :cond_0

    .line 333
    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel;->getSearchTrigger()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->screenStackTag:Ljava/lang/String;

    .line 336
    :cond_0
    iget-object v1, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->screenStackTag:Ljava/lang/String;

    if-eqz v1, :cond_1

    .line 337
    iget-object v1, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->screenStackTag:Ljava/lang/String;

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/SearchResultsFragment;->setTrackingLabel(Ljava/lang/String;)V

    .line 339
    :cond_1
    return-void
.end method

.method private setupSearchResultsList()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 306
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->resultsListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMListView;->removeEmptyContentView()V

    .line 307
    iget-boolean v0, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->bUpdateOnShow:Z

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->searchResultsData:Lcom/poshmark/data_model/models/SearchResults;

    if-nez v0, :cond_2

    .line 308
    :cond_0
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->resultsListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v0, v2}, Lcom/poshmark/ui/customviews/PMListView;->setSelection(I)V

    .line 309
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SearchResultsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f060190

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/SearchResultsFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 310
    invoke-direct {p0, v2}, Lcom/poshmark/ui/fragments/SearchResultsFragment;->getSearchResults(Z)V

    .line 322
    :cond_1
    :goto_0
    return-void

    .line 313
    :cond_2
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->resultsListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMListView;->updateList()V

    .line 314
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->searchResultsData:Lcom/poshmark/data_model/models/SearchResults;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/SearchResults;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 315
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->resultsListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMListView;->showDefaultEmptyContentView()V

    .line 317
    :cond_3
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->searchView:Lcom/poshmark/ui/customviews/PMCustomSearchWidget;

    if-eqz v0, :cond_1

    .line 318
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->searchView:Lcom/poshmark/ui/customviews/PMCustomSearchWidget;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SearchResultsFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/utils/SearchFilterModel;->getQueryText()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->setSilentText(Ljava/lang/String;)V

    .line 319
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->searchView:Lcom/poshmark/ui/customviews/PMCustomSearchWidget;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->clearFocus()V

    goto :goto_0
.end method


# virtual methods
.method public allowFilteringOnAllCategories()Z
    .locals 2

    .prologue
    .line 178
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->searchTrigger:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->searchTrigger:Ljava/lang/String;

    const-string v1, "ct"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 179
    const/4 v0, 0x0

    .line 181
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public filterContent()V
    .locals 1

    .prologue
    .line 357
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SearchResultsFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel;->clearNextPageId()V

    .line 358
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->searchResultsData:Lcom/poshmark/data_model/models/SearchResults;

    .line 359
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->isFilterApplied:Z

    .line 360
    return-void
.end method

.method public fireSearch()V
    .locals 2

    .prologue
    .line 325
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SearchResultsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMContainerActivity;

    .line 326
    .local v0, "parent":Lcom/poshmark/ui/PMContainerActivity;
    invoke-virtual {v0}, Lcom/poshmark/ui/PMContainerActivity;->closeDrawer()V

    .line 327
    const/4 v1, 0x0

    invoke-direct {p0, v1}, Lcom/poshmark/ui/fragments/SearchResultsFragment;->getSearchResults(Z)V

    .line 328
    return-void
.end method

.method public getFilterModel()Lcom/poshmark/utils/SearchFilterModel;
    .locals 1

    .prologue
    .line 342
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SearchResultsFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/utils/FilterResultsManager;->getSearchModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v0

    return-object v0
.end method

.method public getTrackingLabel()Ljava/lang/String;
    .locals 1

    .prologue
    .line 171
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->screenStackTag:Ljava/lang/String;

    return-object v0
.end method

.method public handleBack()Z
    .locals 2

    .prologue
    .line 229
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SearchResultsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMContainerActivity;

    .line 230
    .local v0, "parent":Lcom/poshmark/ui/PMContainerActivity;
    invoke-virtual {v0, p0}, Lcom/poshmark/ui/PMContainerActivity;->killDrawerFragment(Lcom/poshmark/ui/fragments/PMFragment;)V

    .line 231
    const/4 v1, 0x0

    return v1
.end method

.method public handleNotification(Landroid/content/Intent;)V
    .locals 2
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 346
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->handleNotification(Landroid/content/Intent;)V

    .line 347
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    const-string v1, "com.poshmark.intents.SEARCH_FILTER_ACTION"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 349
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SearchResultsFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel;->clearNextPageId()V

    .line 350
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SearchResultsFragment;->fireSearch()V

    .line 352
    :cond_0
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 55
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->onCreate(Landroid/os/Bundle;)V

    .line 57
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 5
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v4, 0x0

    .line 61
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 62
    const v1, 0x7f0300ad

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 63
    .local v0, "v":Landroid/view/View;
    const v1, 0x7f0c029a

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/PMListView;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->resultsListView:Lcom/poshmark/ui/customviews/PMListView;

    .line 64
    iget-object v1, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->resultsListView:Lcom/poshmark/ui/customviews/PMListView;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->adapter:Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;

    new-instance v3, Lcom/poshmark/ui/fragments/SearchResultsFragment$1;

    invoke-direct {v3, p0}, Lcom/poshmark/ui/fragments/SearchResultsFragment$1;-><init>(Lcom/poshmark/ui/fragments/SearchResultsFragment;)V

    invoke-virtual {v1, v2, v4, v4, v3}, Lcom/poshmark/ui/customviews/PMListView;->setup(Landroid/widget/CursorAdapter;Landroid/view/View;Landroid/view/View;Lcom/poshmark/ui/customviews/PMListView$LoadMoreItemsListener;)V

    .line 70
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SearchResultsFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v1

    const-string v2, "SEARCH_TRIGGER"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->searchTrigger:Ljava/lang/String;

    .line 71
    iget-object v1, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->searchTrigger:Ljava/lang/String;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->searchTrigger:Ljava/lang/String;

    const-string v2, "sl"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 72
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SearchResultsFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v1

    const-string v2, "KEYWORD_SOURCE"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->keywordSource:Ljava/lang/String;

    .line 73
    sget-object v1, Lcom/poshmark/utils/NewRelicCustomInteractions;->SEARCH_LISTINGS_BY_KEYWORD:Ljava/lang/String;

    invoke-static {v1}, Lcom/poshmark/config/NewRelicWrapper;->startCustomInteraction(Ljava/lang/String;)V

    .line 76
    :cond_0
    const v1, 0x7f0c006a

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/ListingsFilterWidget;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->filterWidget:Lcom/poshmark/ui/customviews/ListingsFilterWidget;

    .line 77
    iget-object v1, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->filterWidget:Lcom/poshmark/ui/customviews/ListingsFilterWidget;

    if-eqz v1, :cond_1

    .line 78
    iget-object v1, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->filterWidget:Lcom/poshmark/ui/customviews/ListingsFilterWidget;

    invoke-virtual {v1, p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->setOwnerFragment(Lcom/poshmark/ui/fragments/PMFragment;)V

    .line 80
    :cond_1
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SearchResultsFragment;->hideFilterButtonsForSingleFacet()V

    .line 81
    return-object v0
.end method

.method public onPMResume()V
    .locals 2

    .prologue
    .line 99
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->onPMResume()V

    .line 100
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SearchResultsFragment;->getUserVisibleHint()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 101
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/SearchResultsFragment;->setupSearchResultsList()V

    .line 102
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->bUpdateOnShow:Z

    .line 104
    :cond_0
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    const-string v1, "com.poshmark.intents.SEARCH_FILTER_ACTION"

    invoke-virtual {v0, v1, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 105
    return-void
.end method

.method public onPause()V
    .locals 1

    .prologue
    .line 109
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->onPause()V

    .line 110
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/poshmark/notifications/PMNotificationManager;->unregisterAllEvents(Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 111
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 121
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 123
    return-void
.end method

.method public onStop()V
    .locals 1

    .prologue
    .line 115
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->onStop()V

    .line 116
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->adapter:Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;

    invoke-virtual {v0}, Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;->clearImageList()V

    .line 117
    return-void
.end method

.method protected pullParametersFromState(Landroid/os/Bundle;)V
    .locals 5
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 86
    new-instance v1, Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SearchResultsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    const/4 v3, 0x0

    const/high16 v4, -0x80000000

    invoke-direct {v1, v2, p0, v3, v4}, Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;-><init>(Landroid/content/Context;Lcom/poshmark/ui/fragments/PMFragment;Landroid/database/Cursor;I)V

    iput-object v1, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->adapter:Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;

    .line 87
    sget-object v1, Lcom/poshmark/ui/fragments/PMFragment$FRAGMENT_TYPE;->HAS_DRAWER:Lcom/poshmark/ui/fragments/PMFragment$FRAGMENT_TYPE;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->fragmentType:Lcom/poshmark/ui/fragments/PMFragment$FRAGMENT_TYPE;

    .line 88
    if-eqz p1, :cond_0

    .line 94
    :goto_0
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/SearchResultsFragment;->setScreenTagBasedOnSearchType()V

    .line 95
    return-void

    .line 91
    :cond_0
    const-class v1, Lcom/poshmark/utils/SearchFilterModel;

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/SearchResultsFragment;->getFragmentDataOfType(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/utils/SearchFilterModel;

    .line 92
    .local v0, "currentSearchFilter":Lcom/poshmark/utils/SearchFilterModel;
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SearchResultsFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/poshmark/utils/FilterResultsManager;->setSearchModel(Lcom/poshmark/utils/SearchFilterModel;)V

    goto :goto_0
.end method

.method public setViewNameForAnalytics()V
    .locals 1

    .prologue
    .line 187
    const-string v0, "browse_listing_results_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->viewNameForAnalytics:Ljava/lang/String;

    .line 188
    return-void
.end method

.method public setupActionBar()V
    .locals 4

    .prologue
    .line 129
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SearchResultsFragment;->getUserVisibleHint()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 130
    iget-object v2, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->keywordSource:Ljava/lang/String;

    if-eqz v2, :cond_1

    .line 131
    const v2, 0x7f030006

    invoke-super {p0, v2}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->setupActionBar(I)V

    .line 132
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SearchResultsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-virtual {v2}, Landroid/support/v4/app/FragmentActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    .line 133
    .local v0, "actionBar":Landroid/app/ActionBar;
    invoke-virtual {v0}, Landroid/app/ActionBar;->getCustomView()Landroid/view/View;

    move-result-object v1

    .line 134
    .local v1, "customView":Landroid/view/View;
    if-eqz v1, :cond_0

    .line 135
    const v2, 0x7f0c0041

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;

    iput-object v2, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->searchView:Lcom/poshmark/ui/customviews/PMCustomSearchWidget;

    .line 136
    iget-object v2, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->searchView:Lcom/poshmark/ui/customviews/PMCustomSearchWidget;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SearchResultsFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/utils/SearchFilterModel;->getQueryText()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->setSilentText(Ljava/lang/String;)V

    .line 137
    iget-object v2, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment;->searchView:Lcom/poshmark/ui/customviews/PMCustomSearchWidget;

    new-instance v3, Lcom/poshmark/ui/fragments/SearchResultsFragment$2;

    invoke-direct {v3, p0}, Lcom/poshmark/ui/fragments/SearchResultsFragment$2;-><init>(Lcom/poshmark/ui/fragments/SearchResultsFragment;)V

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->setParentListener(Lcom/poshmark/utils/PMSearchViewListener;)V

    .line 167
    .end local v0    # "actionBar":Landroid/app/ActionBar;
    .end local v1    # "customView":Landroid/view/View;
    :cond_0
    :goto_0
    return-void

    .line 163
    :cond_1
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->setupActionBar()V

    .line 164
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/SearchResultsFragment;->getSearchTitle()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/SearchResultsFragment;->setTitle(Ljava/lang/String;)V

    goto :goto_0
.end method
