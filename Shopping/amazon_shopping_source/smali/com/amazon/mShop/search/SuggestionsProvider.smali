.class public Lcom/amazon/mShop/search/SuggestionsProvider;
.super Landroid/content/ContentProvider;
.source "SuggestionsProvider.java"

# interfaces
.implements Lcom/amazon/mShop/control/search/AdvSearchSuggestionsSubscriber;


# instance fields
.field private final COLUMN:[Ljava/lang/String;

.field private final mSSC:Lcom/amazon/mShop/control/search/AdvSearchSuggestionsController;

.field private mValues:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/SearchSuggestion;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 3

    .prologue
    .line 44
    invoke-direct {p0}, Landroid/content/ContentProvider;-><init>()V

    .line 39
    const/4 v0, 0x5

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string/jumbo v2, "_id"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string/jumbo v2, "suggest_text_1"

    aput-object v2, v0, v1

    const/4 v1, 0x2

    const-string/jumbo v2, "suggest_text_2"

    aput-object v2, v0, v1

    const/4 v1, 0x3

    const-string/jumbo v2, "suggest_intent_data"

    aput-object v2, v0, v1

    const/4 v1, 0x4

    const-string/jumbo v2, "intent_extra_data_key"

    aput-object v2, v0, v1

    iput-object v0, p0, Lcom/amazon/mShop/search/SuggestionsProvider;->COLUMN:[Ljava/lang/String;

    .line 45
    new-instance v0, Lcom/amazon/mShop/control/search/AdvSearchSuggestionsController;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/control/search/AdvSearchSuggestionsController;-><init>(Lcom/amazon/mShop/control/search/AdvSearchSuggestionsSubscriber;)V

    iput-object v0, p0, Lcom/amazon/mShop/search/SuggestionsProvider;->mSSC:Lcom/amazon/mShop/control/search/AdvSearchSuggestionsController;

    .line 46
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/search/SuggestionsProvider;->mValues:Ljava/util/List;

    .line 47
    return-void
.end method

.method private getBarcodeEntryCursor()Landroid/database/Cursor;
    .locals 15

    .prologue
    const/4 v14, 0x4

    const/4 v13, 0x3

    const/4 v12, 0x2

    const/4 v11, 0x1

    const/4 v10, 0x0

    .line 149
    const/4 v7, 0x5

    new-array v0, v7, [Ljava/lang/String;

    const-string/jumbo v7, "_id"

    aput-object v7, v0, v10

    const-string/jumbo v7, "suggest_icon_1"

    aput-object v7, v0, v11

    const-string/jumbo v7, "suggest_text_1"

    aput-object v7, v0, v12

    const-string/jumbo v7, "suggest_text_2"

    aput-object v7, v0, v13

    const-string/jumbo v7, "suggest_intent_data"

    aput-object v7, v0, v14

    .line 150
    .local v0, "COLUMN_BARCODE_ENTRY":[Ljava/lang/String;
    new-instance v1, Landroid/database/MatrixCursor;

    invoke-direct {v1, v0}, Landroid/database/MatrixCursor;-><init>([Ljava/lang/String;)V

    .line 152
    .local v1, "barcodeEntryCursor":Landroid/database/MatrixCursor;
    const/4 v3, 0x0

    .line 153
    .local v3, "scanItFooterDescription":Ljava/lang/String;
    const/4 v4, 0x0

    .line 154
    .local v4, "snapItFooterDescription":Ljava/lang/String;
    const/4 v6, 0x0

    .line 155
    .local v6, "snapItTitle":Ljava/lang/String;
    const/4 v5, 0x0

    .line 156
    .local v5, "snapItIconResId":I
    invoke-virtual {p0}, Lcom/amazon/mShop/search/SuggestionsProvider;->getContext()Landroid/content/Context;

    move-result-object v7

    invoke-virtual {v7}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    .line 157
    .local v2, "res":Landroid/content/res/Resources;
    invoke-virtual {p0}, Lcom/amazon/mShop/search/SuggestionsProvider;->getContext()Landroid/content/Context;

    move-result-object v7

    invoke-static {v7}, Lcom/amazon/mShop/util/ActivityUtils;->isFlowEnabled(Landroid/content/Context;)Z

    move-result v7

    if-eqz v7, :cond_1

    .line 158
    sget v7, Lcom/amazon/mShop/android/lib/R$string;->view_it_scan_it_description:I

    invoke-virtual {v2, v7}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 159
    sget v7, Lcom/amazon/mShop/android/lib/R$string;->view_it_flow_description:I

    invoke-virtual {v2, v7}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 160
    sget v7, Lcom/amazon/mShop/android/lib/R$string;->view_it_flow:I

    invoke-virtual {v2, v7}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v6

    .line 161
    sget v5, Lcom/amazon/mShop/android/lib/R$drawable;->flow_icon:I

    .line 167
    :goto_0
    const/4 v7, 0x5

    new-array v7, v7, [Ljava/lang/String;

    const-string/jumbo v8, "0"

    aput-object v8, v7, v10

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    sget v9, Lcom/amazon/mShop/android/lib/R$drawable;->search_suggestion_barcode:I

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string/jumbo v9, ""

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v7, v11

    invoke-virtual {p0}, Lcom/amazon/mShop/search/SuggestionsProvider;->getContext()Landroid/content/Context;

    move-result-object v8

    invoke-virtual {v8}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    sget v9, Lcom/amazon/mShop/android/lib/R$string;->bc_search_button:I

    invoke-virtual {v8, v9}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v8

    aput-object v8, v7, v12

    aput-object v3, v7, v13

    const-string/jumbo v8, "BARCODE_SEARCH_QUERY_KEYWORD"

    aput-object v8, v7, v14

    invoke-virtual {v1, v7}, Landroid/database/MatrixCursor;->addRow([Ljava/lang/Object;)V

    .line 169
    invoke-virtual {p0}, Lcom/amazon/mShop/search/SuggestionsProvider;->getContext()Landroid/content/Context;

    move-result-object v7

    sget v8, Lcom/amazon/mShop/android/lib/R$string;->config_hasSnapIt:I

    invoke-static {v7, v8}, Lcom/amazon/mShop/util/ConfigUtils;->isEnabled(Landroid/content/Context;I)Z

    move-result v7

    if-eqz v7, :cond_0

    .line 170
    const/4 v7, 0x5

    new-array v7, v7, [Ljava/lang/String;

    const-string/jumbo v8, "1"

    aput-object v8, v7, v10

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v8, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string/jumbo v9, ""

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v7, v11

    aput-object v6, v7, v12

    aput-object v4, v7, v13

    const-string/jumbo v8, "IMAGE_SEARCH_QUERY_KEYWORD"

    aput-object v8, v7, v14

    invoke-virtual {v1, v7}, Landroid/database/MatrixCursor;->addRow([Ljava/lang/Object;)V

    .line 173
    :cond_0
    return-object v1

    .line 163
    :cond_1
    sget v7, Lcom/amazon/mShop/android/lib/R$string;->snapit:I

    invoke-virtual {v2, v7}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v6

    .line 164
    sget v5, Lcom/amazon/mShop/android/lib/R$drawable;->search_suggestion_snapit:I

    goto :goto_0
.end method

.method private makeSuggestionRow(ILcom/amazon/rio/j2me/client/services/mShop/SearchSuggestion;)[Ljava/lang/String;
    .locals 12
    .param p1, "id"    # I
    .param p2, "s"    # Lcom/amazon/rio/j2me/client/services/mShop/SearchSuggestion;

    .prologue
    const/4 v11, 0x1

    const/4 v10, 0x0

    .line 177
    invoke-virtual {p2}, Lcom/amazon/rio/j2me/client/services/mShop/SearchSuggestion;->getQuery()Ljava/lang/String;

    move-result-object v4

    .line 178
    .local v4, "query":Ljava/lang/String;
    new-instance v3, Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;

    invoke-direct {v3}, Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;-><init>()V

    .line 179
    .local v3, "intentUriBuilder":Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;
    invoke-virtual {v3, v4}, Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;->query(Ljava/lang/String;)Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;

    .line 180
    invoke-virtual {p2}, Lcom/amazon/rio/j2me/client/services/mShop/SearchSuggestion;->getDepartment()Ljava/lang/String;

    move-result-object v0

    .line 181
    .local v0, "departmentName":Ljava/lang/String;
    move-object v5, v0

    .line 182
    .local v5, "rawDepartmentName":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_0

    .line 183
    invoke-virtual {p0}, Lcom/amazon/mShop/search/SuggestionsProvider;->getContext()Landroid/content/Context;

    move-result-object v8

    invoke-virtual {v8}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    sget v9, Lcom/amazon/mShop/android/lib/R$string;->search_suggestions_department_text:I

    invoke-virtual {v8, v9}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 184
    .local v2, "format":Ljava/lang/String;
    new-array v8, v11, [Ljava/lang/Object;

    aput-object v0, v8, v10

    invoke-static {v2, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 186
    .end local v2    # "format":Ljava/lang/String;
    :cond_0
    invoke-virtual {p2}, Lcom/amazon/rio/j2me/client/services/mShop/SearchSuggestion;->getFilters()Ljava/lang/String;

    move-result-object v1

    .line 187
    .local v1, "filters":Ljava/lang/String;
    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_1

    invoke-static {v5}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_1

    .line 196
    invoke-virtual {v3, v1}, Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;->filter(Ljava/lang/String;)Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;

    .line 197
    invoke-virtual {v3, v5}, Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;->categoryName(Ljava/lang/String;)Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;

    .line 201
    :cond_1
    invoke-virtual {p2}, Lcom/amazon/rio/j2me/client/services/mShop/SearchSuggestion;->getAutoSearch()Ljava/lang/Boolean;

    move-result-object v8

    if-eqz v8, :cond_2

    invoke-virtual {p2}, Lcom/amazon/rio/j2me/client/services/mShop/SearchSuggestion;->getAutoSearch()Ljava/lang/Boolean;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/Boolean;->toString()Ljava/lang/String;

    move-result-object v6

    .line 202
    .local v6, "strAutoSearch":Ljava/lang/String;
    :goto_0
    invoke-virtual {v3}, Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;->build()Landroid/net/Uri;

    move-result-object v7

    .line 203
    .local v7, "uri":Landroid/net/Uri;
    const/4 v8, 0x5

    new-array v9, v8, [Ljava/lang/String;

    invoke-static {p1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v8

    aput-object v8, v9, v10

    aput-object v4, v9, v11

    const/4 v8, 0x2

    aput-object v0, v9, v8

    const/4 v10, 0x3

    if-eqz v7, :cond_3

    invoke-virtual {v7}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v8

    :goto_1
    aput-object v8, v9, v10

    const/4 v8, 0x4

    aput-object v6, v9, v8

    return-object v9

    .line 201
    .end local v6    # "strAutoSearch":Ljava/lang/String;
    .end local v7    # "uri":Landroid/net/Uri;
    :cond_2
    const-string/jumbo v6, ""

    goto :goto_0

    .line 203
    .restart local v6    # "strAutoSearch":Ljava/lang/String;
    .restart local v7    # "uri":Landroid/net/Uri;
    :cond_3
    const-string/jumbo v8, ""

    goto :goto_1
.end method


# virtual methods
.method public delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "selection"    # Ljava/lang/String;
    .param p3, "selectionArgs"    # [Ljava/lang/String;

    .prologue
    .line 52
    const/4 v0, 0x0

    return v0
.end method

.method public getType(Landroid/net/Uri;)Ljava/lang/String;
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;

    .prologue
    .line 77
    const-string/jumbo v0, "vnd.android.cursor.dir/vnd.android.search.suggest"

    return-object v0
.end method

.method public insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "values"    # Landroid/content/ContentValues;

    .prologue
    .line 58
    const/4 v0, 0x0

    return-object v0
.end method

.method public onCreate()Z
    .locals 1

    .prologue
    .line 64
    const/4 v0, 0x0

    return v0
.end method

.method public onError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 1
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 217
    monitor-enter p0

    .line 218
    :try_start_0
    invoke-virtual {p0}, Ljava/lang/Object;->notify()V

    .line 219
    monitor-exit p0

    .line 220
    return-void

    .line 219
    :catchall_0
    move-exception v0

    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public onSearchSuggestionsReceived(Ljava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/SearchSuggestion;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 208
    .local p1, "suggestions":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/SearchSuggestion;>;"
    iput-object p1, p0, Lcom/amazon/mShop/search/SuggestionsProvider;->mValues:Ljava/util/List;

    .line 209
    monitor-enter p0

    .line 210
    :try_start_0
    invoke-virtual {p0}, Ljava/lang/Object;->notify()V

    .line 211
    monitor-exit p0

    .line 212
    return-void

    .line 211
    :catchall_0
    move-exception v0

    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    .locals 12
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "projection"    # [Ljava/lang/String;
    .param p3, "selection"    # Ljava/lang/String;
    .param p4, "selectionArgs"    # [Ljava/lang/String;
    .param p5, "sortOrder"    # Ljava/lang/String;

    .prologue
    .line 89
    iget-object v10, p0, Lcom/amazon/mShop/search/SuggestionsProvider;->mValues:Ljava/util/List;

    invoke-interface {v10}, Ljava/util/List;->clear()V

    .line 92
    invoke-virtual {p1}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v9

    .line 93
    .local v9, "uriString":Ljava/lang/String;
    const-string/jumbo v10, "/search_suggest_query/"

    invoke-virtual {v9, v10}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v10

    const-string/jumbo v11, "/search_suggest_query/"

    invoke-virtual {v11}, Ljava/lang/String;->length()I

    move-result v11

    add-int v8, v10, v11

    .line 94
    .local v8, "start":I
    const-string/jumbo v10, "?"

    invoke-virtual {v9, v10}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v2

    .line 103
    .local v2, "end":I
    const/4 v10, -0x1

    if-ne v2, v10, :cond_0

    .line 104
    invoke-virtual {v9}, Ljava/lang/String;->length()I

    move-result v2

    .line 107
    :cond_0
    invoke-virtual {v9, v8, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v6

    .line 109
    .local v6, "queryString":Ljava/lang/String;
    invoke-virtual {v6}, Ljava/lang/String;->length()I

    move-result v10

    if-nez v10, :cond_1

    .line 111
    const/4 v10, 0x1

    invoke-static {v10}, Lcom/amazon/mShop/search/SearchActivity;->setShouldShowBarcodeEntry(Z)V

    .line 114
    const-string/jumbo v10, ""

    invoke-static {v10}, Lcom/amazon/mShop/search/SearchActivity;->setPreviousSearchTerm(Ljava/lang/String;)V

    .line 117
    :cond_1
    invoke-static {}, Lcom/amazon/mShop/search/SearchActivity;->getShouldShowBarcodeEntry()Z

    move-result v10

    if-eqz v10, :cond_4

    .line 119
    const/4 v10, 0x0

    invoke-static {v10}, Lcom/amazon/mShop/search/SearchActivity;->setShouldShowBarcodeEntry(Z)V

    .line 121
    invoke-static {}, Lcom/amazon/mShop/search/SearchActivity;->getCurrentDepartmentName()Ljava/lang/String;

    move-result-object v10

    invoke-static {v10}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v10

    if-nez v10, :cond_3

    .line 123
    new-instance v0, Landroid/database/MatrixCursor;

    iget-object v10, p0, Lcom/amazon/mShop/search/SuggestionsProvider;->COLUMN:[Ljava/lang/String;

    invoke-direct {v0, v10}, Landroid/database/MatrixCursor;-><init>([Ljava/lang/String;)V

    .line 144
    :cond_2
    :goto_0
    return-object v0

    .line 125
    :cond_3
    invoke-direct {p0}, Lcom/amazon/mShop/search/SuggestionsProvider;->getBarcodeEntryCursor()Landroid/database/Cursor;

    move-result-object v0

    goto :goto_0

    .line 129
    :cond_4
    new-instance v0, Landroid/database/MatrixCursor;

    iget-object v10, p0, Lcom/amazon/mShop/search/SuggestionsProvider;->COLUMN:[Ljava/lang/String;

    invoke-direct {v0, v10}, Landroid/database/MatrixCursor;-><init>([Ljava/lang/String;)V

    .line 130
    .local v0, "c":Landroid/database/MatrixCursor;
    invoke-virtual {v6}, Ljava/lang/String;->length()I

    move-result v10

    if-lez v10, :cond_2

    .line 131
    iget-object v10, p0, Lcom/amazon/mShop/search/SuggestionsProvider;->mSSC:Lcom/amazon/mShop/control/search/AdvSearchSuggestionsController;

    invoke-virtual {p1}, Landroid/net/Uri;->getLastPathSegment()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Lcom/amazon/mShop/control/search/AdvSearchSuggestionsController;->getSearchSuggestions(Ljava/lang/String;)V

    .line 132
    const/4 v3, 0x0

    .line 133
    .local v3, "i":I
    monitor-enter p0

    .line 135
    :try_start_0
    invoke-virtual {p0}, Ljava/lang/Object;->wait()V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 139
    :try_start_1
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 140
    iget-object v10, p0, Lcom/amazon/mShop/search/SuggestionsProvider;->mValues:Ljava/util/List;

    invoke-interface {v10}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v5

    .local v5, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v10

    if-eqz v10, :cond_2

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/amazon/rio/j2me/client/services/mShop/SearchSuggestion;

    .line 141
    .local v7, "s":Lcom/amazon/rio/j2me/client/services/mShop/SearchSuggestion;
    add-int/lit8 v4, v3, 0x1

    .end local v3    # "i":I
    .local v4, "i":I
    invoke-direct {p0, v3, v7}, Lcom/amazon/mShop/search/SuggestionsProvider;->makeSuggestionRow(ILcom/amazon/rio/j2me/client/services/mShop/SearchSuggestion;)[Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v0, v10}, Landroid/database/MatrixCursor;->addRow([Ljava/lang/Object;)V

    move v3, v4

    .end local v4    # "i":I
    .restart local v3    # "i":I
    goto :goto_1

    .line 136
    .end local v5    # "i$":Ljava/util/Iterator;
    .end local v7    # "s":Lcom/amazon/rio/j2me/client/services/mShop/SearchSuggestion;
    :catch_0
    move-exception v1

    .line 137
    .local v1, "e":Ljava/lang/InterruptedException;
    const/4 v0, 0x0

    :try_start_2
    monitor-exit p0

    goto :goto_0

    .line 139
    .end local v0    # "c":Landroid/database/MatrixCursor;
    .end local v1    # "e":Ljava/lang/InterruptedException;
    :catchall_0
    move-exception v10

    monitor-exit p0
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v10
.end method

.method public update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "values"    # Landroid/content/ContentValues;
    .param p3, "selection"    # Ljava/lang/String;
    .param p4, "selectionArgs"    # [Ljava/lang/String;

    .prologue
    .line 71
    const/4 v0, 0x0

    return v0
.end method
