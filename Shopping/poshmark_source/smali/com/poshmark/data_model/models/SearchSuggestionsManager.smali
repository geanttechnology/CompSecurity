.class public Lcom/poshmark/data_model/models/SearchSuggestionsManager;
.super Ljava/lang/Object;
.source "SearchSuggestionsManager.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/poshmark/http/api/PMApiResponseHandler",
        "<",
        "Lcom/poshmark/data_model/models/SuggestedSearchResults;",
        ">;"
    }
.end annotation


# instance fields
.field dropdownListAdapter:Lcom/poshmark/data_model/adapters/SearchSuggestionsAdapter;

.field pendingResults:Z

.field searchString:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/poshmark/data_model/models/SearchSuggestionsManager;->pendingResults:Z

    .line 25
    return-void
.end method

.method private resetAdapterCursor()V
    .locals 3

    .prologue
    .line 52
    iget-object v1, p0, Lcom/poshmark/data_model/models/SearchSuggestionsManager;->dropdownListAdapter:Lcom/poshmark/data_model/adapters/SearchSuggestionsAdapter;

    invoke-virtual {v1}, Lcom/poshmark/data_model/adapters/SearchSuggestionsAdapter;->getCursor()Landroid/database/Cursor;

    move-result-object v0

    .line 53
    .local v0, "oldCursor":Landroid/database/Cursor;
    if-eqz v0, :cond_0

    .line 54
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .line 56
    :cond_0
    iget-object v1, p0, Lcom/poshmark/data_model/models/SearchSuggestionsManager;->dropdownListAdapter:Lcom/poshmark/data_model/adapters/SearchSuggestionsAdapter;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lcom/poshmark/data_model/adapters/SearchSuggestionsAdapter;->changeCursor(Landroid/database/Cursor;)V

    .line 57
    return-void
.end method


# virtual methods
.method public fillCursorWithRecents()Landroid/database/Cursor;
    .locals 5

    .prologue
    .line 96
    iget-object v2, p0, Lcom/poshmark/data_model/models/SearchSuggestionsManager;->dropdownListAdapter:Lcom/poshmark/data_model/adapters/SearchSuggestionsAdapter;

    invoke-virtual {v2}, Lcom/poshmark/data_model/adapters/SearchSuggestionsAdapter;->getCursor()Landroid/database/Cursor;

    move-result-object v1

    .line 97
    .local v1, "oldCursor":Landroid/database/Cursor;
    new-instance v0, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    sget-object v4, Lcom/poshmark/data_model/models/PMData;->ID_COL:Ljava/lang/String;

    aput-object v4, v2, v3

    const/4 v3, 0x1

    sget-object v4, Lcom/poshmark/data_model/models/PMData;->DATA_COL:Ljava/lang/String;

    aput-object v4, v2, v3

    invoke-direct {v0, v2}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;-><init>([Ljava/lang/String;)V

    .line 99
    .local v0, "cursor":Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;
    invoke-static {}, Lcom/poshmark/controllers/GlobalDbController;->getGlobalDbController()Lcom/poshmark/controllers/GlobalDbController;

    move-result-object v2

    const/4 v3, 0x5

    invoke-virtual {v2, v0, v3}, Lcom/poshmark/controllers/GlobalDbController;->populateCursorWithRecentSavedSearches(Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;I)V

    .line 100
    return-object v0
.end method

.method public fillFilteredCursor(Ljava/lang/CharSequence;)V
    .locals 5
    .param p1, "text"    # Ljava/lang/CharSequence;

    .prologue
    .line 28
    invoke-interface {p1}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/data_model/models/SearchSuggestionsManager;->searchString:Ljava/lang/String;

    .line 29
    invoke-static {}, Lcom/poshmark/utils/FeatureManager;->getGlobalFeatureManager()Lcom/poshmark/utils/FeatureManager;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/utils/FeatureManager;->isAutoCompleteSearchEnabled()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 30
    iget-object v2, p0, Lcom/poshmark/data_model/models/SearchSuggestionsManager;->searchString:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    if-lez v2, :cond_0

    .line 31
    invoke-interface {p1}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2, p0}, Lcom/poshmark/http/api/PMApi;->getSuggestedSearch(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 44
    :cond_0
    :goto_0
    return-void

    .line 35
    :cond_1
    iget-object v2, p0, Lcom/poshmark/data_model/models/SearchSuggestionsManager;->dropdownListAdapter:Lcom/poshmark/data_model/adapters/SearchSuggestionsAdapter;

    invoke-virtual {v2}, Lcom/poshmark/data_model/adapters/SearchSuggestionsAdapter;->getCursor()Landroid/database/Cursor;

    move-result-object v1

    .line 36
    .local v1, "oldCursor":Landroid/database/Cursor;
    new-instance v0, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    sget-object v4, Lcom/poshmark/data_model/models/PMData;->ID_COL:Ljava/lang/String;

    aput-object v4, v2, v3

    const/4 v3, 0x1

    sget-object v4, Lcom/poshmark/data_model/models/PMData;->DATA_COL:Ljava/lang/String;

    aput-object v4, v2, v3

    invoke-direct {v0, v2}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;-><init>([Ljava/lang/String;)V

    .line 38
    .local v0, "cursor":Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;
    invoke-static {}, Lcom/poshmark/controllers/GlobalDbController;->getGlobalDbController()Lcom/poshmark/controllers/GlobalDbController;

    move-result-object v2

    iget-object v3, p0, Lcom/poshmark/data_model/models/SearchSuggestionsManager;->searchString:Ljava/lang/String;

    invoke-virtual {v2, v0, v3}, Lcom/poshmark/controllers/GlobalDbController;->populateCursorWithRelevantSavedSearches(Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;Ljava/lang/String;)V

    .line 39
    iget-object v2, p0, Lcom/poshmark/data_model/models/SearchSuggestionsManager;->dropdownListAdapter:Lcom/poshmark/data_model/adapters/SearchSuggestionsAdapter;

    invoke-virtual {v2, v0}, Lcom/poshmark/data_model/adapters/SearchSuggestionsAdapter;->changeCursor(Landroid/database/Cursor;)V

    .line 40
    if-eqz v1, :cond_0

    .line 41
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    goto :goto_0
.end method

.method public handleResponse(Lcom/poshmark/http/api/PMApiResponse;)V
    .locals 12
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiResponse",
            "<",
            "Lcom/poshmark/data_model/models/SuggestedSearchResults;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p1, "response":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/data_model/models/SuggestedSearchResults;>;"
    const/4 v11, 0x2

    const/4 v10, 0x1

    const/4 v9, 0x0

    .line 62
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v6

    if-nez v6, :cond_3

    iget v6, p1, Lcom/poshmark/http/api/PMApiResponse;->httpCode:I

    const/16 v7, 0x1f7

    if-eq v6, v7, :cond_3

    .line 63
    iget-object v6, p1, Lcom/poshmark/http/api/PMApiResponse;->httpRequest:Lcom/poshmark/http/PMHttpRequest;

    iget-object v6, v6, Lcom/poshmark/http/PMHttpRequest;->queryParams:Ljava/util/Map;

    const-string v7, "query"

    invoke-interface {v6, v7}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 65
    .local v2, "keyword":Ljava/lang/String;
    iget-object v6, p0, Lcom/poshmark/data_model/models/SearchSuggestionsManager;->searchString:Ljava/lang/String;

    invoke-virtual {v6, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_2

    .line 66
    iget-object v4, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v4, Lcom/poshmark/data_model/models/SuggestedSearchResults;

    .line 67
    .local v4, "results":Lcom/poshmark/data_model/models/SuggestedSearchResults;
    iget-object v6, p0, Lcom/poshmark/data_model/models/SearchSuggestionsManager;->dropdownListAdapter:Lcom/poshmark/data_model/adapters/SearchSuggestionsAdapter;

    invoke-virtual {v6}, Lcom/poshmark/data_model/adapters/SearchSuggestionsAdapter;->getCursor()Landroid/database/Cursor;

    move-result-object v3

    .line 68
    .local v3, "oldCursor":Landroid/database/Cursor;
    new-instance v0, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    new-array v6, v11, [Ljava/lang/String;

    sget-object v7, Lcom/poshmark/data_model/models/PMData;->ID_COL:Ljava/lang/String;

    aput-object v7, v6, v9

    sget-object v7, Lcom/poshmark/data_model/models/PMData;->DATA_COL:Ljava/lang/String;

    aput-object v7, v6, v10

    invoke-direct {v0, v6}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;-><init>([Ljava/lang/String;)V

    .line 71
    .local v0, "cursor":Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;
    invoke-static {}, Lcom/poshmark/controllers/GlobalDbController;->getGlobalDbController()Lcom/poshmark/controllers/GlobalDbController;

    move-result-object v7

    iget-object v6, p1, Lcom/poshmark/http/api/PMApiResponse;->httpRequest:Lcom/poshmark/http/PMHttpRequest;

    iget-object v6, v6, Lcom/poshmark/http/PMHttpRequest;->queryParams:Ljava/util/Map;

    const-string v8, "query"

    invoke-interface {v6, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    invoke-virtual {v7, v0, v6}, Lcom/poshmark/controllers/GlobalDbController;->populateCursorWithRelevantSavedSearches(Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;Ljava/lang/String;)V

    .line 73
    iget-object v6, v4, Lcom/poshmark/data_model/models/SuggestedSearchResults;->data:Ljava/util/List;

    invoke-interface {v6}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 75
    .local v1, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/SuggestedSearchItem;>;"
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 76
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/poshmark/data_model/models/SuggestedSearchItem;

    .line 78
    .local v5, "searchItem":Lcom/poshmark/data_model/models/SuggestedSearchItem;
    invoke-static {}, Lcom/poshmark/controllers/GlobalDbController;->getGlobalDbController()Lcom/poshmark/controllers/GlobalDbController;

    move-result-object v6

    iget-object v7, v5, Lcom/poshmark/data_model/models/SuggestedSearchItem;->kw:Ljava/lang/String;

    invoke-virtual {v6, v7}, Lcom/poshmark/controllers/GlobalDbController;->isKeywordInSavedSearches(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_0

    .line 79
    new-array v6, v11, [Ljava/lang/Object;

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v6, v9

    aput-object v5, v6, v10

    invoke-virtual {v0, v6}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->addRow([Ljava/lang/Object;)V

    goto :goto_0

    .line 82
    .end local v5    # "searchItem":Lcom/poshmark/data_model/models/SuggestedSearchItem;
    :cond_1
    iget-object v6, p0, Lcom/poshmark/data_model/models/SearchSuggestionsManager;->dropdownListAdapter:Lcom/poshmark/data_model/adapters/SearchSuggestionsAdapter;

    invoke-virtual {v6, v0}, Lcom/poshmark/data_model/adapters/SearchSuggestionsAdapter;->changeCursor(Landroid/database/Cursor;)V

    .line 83
    if-eqz v3, :cond_2

    .line 84
    invoke-interface {v3}, Landroid/database/Cursor;->close()V

    .line 93
    .end local v0    # "cursor":Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;
    .end local v1    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/SuggestedSearchItem;>;"
    .end local v2    # "keyword":Ljava/lang/String;
    .end local v3    # "oldCursor":Landroid/database/Cursor;
    .end local v4    # "results":Lcom/poshmark/data_model/models/SuggestedSearchResults;
    :cond_2
    :goto_1
    return-void

    .line 90
    :cond_3
    invoke-direct {p0}, Lcom/poshmark/data_model/models/SearchSuggestionsManager;->resetAdapterCursor()V

    goto :goto_1
.end method

.method public setListAdapter(Lcom/poshmark/data_model/adapters/SearchSuggestionsAdapter;)V
    .locals 0
    .param p1, "adapter"    # Lcom/poshmark/data_model/adapters/SearchSuggestionsAdapter;

    .prologue
    .line 47
    iput-object p1, p0, Lcom/poshmark/data_model/models/SearchSuggestionsManager;->dropdownListAdapter:Lcom/poshmark/data_model/adapters/SearchSuggestionsAdapter;

    .line 48
    return-void
.end method
