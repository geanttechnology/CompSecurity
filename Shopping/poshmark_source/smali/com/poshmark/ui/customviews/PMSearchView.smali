.class public Lcom/poshmark/ui/customviews/PMSearchView;
.super Landroid/widget/SearchView;
.source "PMSearchView.java"


# instance fields
.field activity:Landroid/app/Activity;

.field adapter:Lcom/poshmark/data_model/adapters/SearchSuggestionsAdapter;

.field bShowRecentsByDefault:Z

.field clearAllButtonListener:Landroid/view/View$OnClickListener;

.field currentSearchString:Ljava/lang/String;

.field parentListener:Lcom/poshmark/utils/PMSearchViewListener;

.field searchEditText:Landroid/widget/AutoCompleteTextView;

.field searchListener:Landroid/widget/SearchView$OnQueryTextListener;

.field suggestionListener:Landroid/widget/SearchView$OnSuggestionListener;

.field suggestionsData:Lcom/poshmark/data_model/models/SearchSuggestionsManager;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 49
    invoke-direct {p0, p1, p2}, Landroid/widget/SearchView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 45
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/ui/customviews/PMSearchView;->bShowRecentsByDefault:Z

    .line 131
    new-instance v0, Lcom/poshmark/ui/customviews/PMSearchView$2;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/customviews/PMSearchView$2;-><init>(Lcom/poshmark/ui/customviews/PMSearchView;)V

    iput-object v0, p0, Lcom/poshmark/ui/customviews/PMSearchView;->searchListener:Landroid/widget/SearchView$OnQueryTextListener;

    .line 162
    new-instance v0, Lcom/poshmark/ui/customviews/PMSearchView$3;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/customviews/PMSearchView$3;-><init>(Lcom/poshmark/ui/customviews/PMSearchView;)V

    iput-object v0, p0, Lcom/poshmark/ui/customviews/PMSearchView;->suggestionListener:Landroid/widget/SearchView$OnSuggestionListener;

    .line 181
    new-instance v0, Lcom/poshmark/ui/customviews/PMSearchView$4;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/customviews/PMSearchView$4;-><init>(Lcom/poshmark/ui/customviews/PMSearchView;)V

    iput-object v0, p0, Lcom/poshmark/ui/customviews/PMSearchView;->clearAllButtonListener:Landroid/view/View$OnClickListener;

    move-object v0, p1

    .line 50
    check-cast v0, Landroid/app/Activity;

    iput-object v0, p0, Lcom/poshmark/ui/customviews/PMSearchView;->activity:Landroid/app/Activity;

    .line 51
    new-instance v0, Lcom/poshmark/data_model/adapters/SearchSuggestionsAdapter;

    const/4 v1, 0x0

    const/high16 v2, -0x80000000

    iget-object v3, p0, Lcom/poshmark/ui/customviews/PMSearchView;->clearAllButtonListener:Landroid/view/View$OnClickListener;

    invoke-direct {v0, p1, v1, v2, v3}, Lcom/poshmark/data_model/adapters/SearchSuggestionsAdapter;-><init>(Landroid/content/Context;Landroid/database/Cursor;ILandroid/view/View$OnClickListener;)V

    iput-object v0, p0, Lcom/poshmark/ui/customviews/PMSearchView;->adapter:Lcom/poshmark/data_model/adapters/SearchSuggestionsAdapter;

    .line 52
    invoke-direct {p0}, Lcom/poshmark/ui/customviews/PMSearchView;->setupSearchBar()V

    .line 54
    return-void
.end method

.method private setupSearchBar()V
    .locals 7

    .prologue
    const/4 v6, 0x0

    .line 57
    iget-object v4, p0, Lcom/poshmark/ui/customviews/PMSearchView;->activity:Landroid/app/Activity;

    const-string v5, "search"

    invoke-virtual {v4, v5}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/app/SearchManager;

    .line 59
    .local v2, "searchManager":Landroid/app/SearchManager;
    iget-object v4, p0, Lcom/poshmark/ui/customviews/PMSearchView;->activity:Landroid/app/Activity;

    invoke-virtual {v4}, Landroid/app/Activity;->getComponentName()Landroid/content/ComponentName;

    move-result-object v0

    .line 60
    .local v0, "compName":Landroid/content/ComponentName;
    invoke-virtual {v2, v0}, Landroid/app/SearchManager;->getSearchableInfo(Landroid/content/ComponentName;)Landroid/app/SearchableInfo;

    move-result-object v1

    .line 61
    .local v1, "info":Landroid/app/SearchableInfo;
    invoke-virtual {p0, v1}, Lcom/poshmark/ui/customviews/PMSearchView;->setSearchableInfo(Landroid/app/SearchableInfo;)V

    .line 64
    new-instance v4, Lcom/poshmark/data_model/models/SearchSuggestionsManager;

    invoke-direct {v4}, Lcom/poshmark/data_model/models/SearchSuggestionsManager;-><init>()V

    iput-object v4, p0, Lcom/poshmark/ui/customviews/PMSearchView;->suggestionsData:Lcom/poshmark/data_model/models/SearchSuggestionsManager;

    .line 65
    iget-object v4, p0, Lcom/poshmark/ui/customviews/PMSearchView;->suggestionsData:Lcom/poshmark/data_model/models/SearchSuggestionsManager;

    iget-object v5, p0, Lcom/poshmark/ui/customviews/PMSearchView;->adapter:Lcom/poshmark/data_model/adapters/SearchSuggestionsAdapter;

    invoke-virtual {v4, v5}, Lcom/poshmark/data_model/models/SearchSuggestionsManager;->setListAdapter(Lcom/poshmark/data_model/adapters/SearchSuggestionsAdapter;)V

    .line 66
    invoke-direct {p0}, Lcom/poshmark/ui/customviews/PMSearchView;->updateAutoCompleteView()V

    .line 67
    iget-object v4, p0, Lcom/poshmark/ui/customviews/PMSearchView;->adapter:Lcom/poshmark/data_model/adapters/SearchSuggestionsAdapter;

    invoke-virtual {p0, v4}, Lcom/poshmark/ui/customviews/PMSearchView;->setSuggestionsAdapter(Landroid/widget/CursorAdapter;)V

    .line 68
    iget-object v4, p0, Lcom/poshmark/ui/customviews/PMSearchView;->searchListener:Landroid/widget/SearchView$OnQueryTextListener;

    invoke-virtual {p0, v4}, Lcom/poshmark/ui/customviews/PMSearchView;->setOnQueryTextListener(Landroid/widget/SearchView$OnQueryTextListener;)V

    .line 69
    iget-object v4, p0, Lcom/poshmark/ui/customviews/PMSearchView;->suggestionListener:Landroid/widget/SearchView$OnSuggestionListener;

    invoke-virtual {p0, v4}, Lcom/poshmark/ui/customviews/PMSearchView;->setOnSuggestionListener(Landroid/widget/SearchView$OnSuggestionListener;)V

    .line 70
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMSearchView;->clearFocus()V

    .line 72
    iget-object v4, p0, Lcom/poshmark/ui/customviews/PMSearchView;->activity:Landroid/app/Activity;

    invoke-virtual {v4}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const-string v5, "android:id/search_src_text"

    invoke-virtual {v4, v5, v6, v6}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v3

    .line 73
    .local v3, "searchPlateId":I
    if-eqz v3, :cond_0

    .line 74
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMSearchView;->clearFocus()V

    .line 75
    invoke-virtual {p0, v3}, Lcom/poshmark/ui/customviews/PMSearchView;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/AutoCompleteTextView;

    iput-object v4, p0, Lcom/poshmark/ui/customviews/PMSearchView;->searchEditText:Landroid/widget/AutoCompleteTextView;

    .line 79
    :cond_0
    return-void
.end method

.method private updateAutoCompleteView()V
    .locals 2

    .prologue
    .line 82
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMSearchView;->adapter:Lcom/poshmark/data_model/adapters/SearchSuggestionsAdapter;

    new-instance v1, Lcom/poshmark/ui/customviews/PMSearchView$1;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/customviews/PMSearchView$1;-><init>(Lcom/poshmark/ui/customviews/PMSearchView;)V

    invoke-virtual {v0, v1}, Lcom/poshmark/data_model/adapters/SearchSuggestionsAdapter;->setFilterQueryProvider(Landroid/widget/FilterQueryProvider;)V

    .line 129
    return-void
.end method


# virtual methods
.method public commit()V
    .locals 0

    .prologue
    .line 191
    return-void
.end method

.method public getUserInput()Ljava/lang/String;
    .locals 1

    .prologue
    .line 257
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMSearchView;->currentSearchString:Ljava/lang/String;

    return-object v0
.end method

.method public launchSearch(Lcom/poshmark/data_model/models/SuggestedSearchItem;Z)V
    .locals 8
    .param p1, "searchItem"    # Lcom/poshmark/data_model/models/SuggestedSearchItem;
    .param p2, "userTypedQuery"    # Z

    .prologue
    .line 194
    iget-object v6, p0, Lcom/poshmark/ui/customviews/PMSearchView;->adapter:Lcom/poshmark/data_model/adapters/SearchSuggestionsAdapter;

    invoke-virtual {v6}, Lcom/poshmark/data_model/adapters/SearchSuggestionsAdapter;->getCursor()Landroid/database/Cursor;

    move-result-object v2

    .line 195
    .local v2, "oldCursor":Landroid/database/Cursor;
    if-eqz v2, :cond_0

    .line 196
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    .line 198
    :cond_0
    invoke-static {}, Lcom/poshmark/controllers/GlobalDbController;->getGlobalDbController()Lcom/poshmark/controllers/GlobalDbController;

    move-result-object v6

    iget-object v7, p1, Lcom/poshmark/data_model/models/SuggestedSearchItem;->kw:Ljava/lang/String;

    invoke-virtual {v6, v7}, Lcom/poshmark/controllers/GlobalDbController;->isKeywordInSavedSearches(Ljava/lang/String;)Z

    move-result v0

    .line 199
    .local v0, "isSavedSearchSelected":Z
    invoke-static {}, Lcom/poshmark/controllers/GlobalDbController;->getGlobalDbController()Lcom/poshmark/controllers/GlobalDbController;

    move-result-object v6

    iget-object v7, p1, Lcom/poshmark/data_model/models/SuggestedSearchItem;->kw:Ljava/lang/String;

    invoke-virtual {v6, v7}, Lcom/poshmark/controllers/GlobalDbController;->addNewSearchToSavedSearches(Ljava/lang/String;)V

    .line 200
    new-instance v1, Lcom/poshmark/utils/SearchFilterModel;

    invoke-direct {v1}, Lcom/poshmark/utils/SearchFilterModel;-><init>()V

    .line 201
    .local v1, "model":Lcom/poshmark/utils/SearchFilterModel;
    const-string v6, "available"

    invoke-virtual {v1, v6}, Lcom/poshmark/utils/SearchFilterModel;->setAvailability(Ljava/lang/String;)V

    .line 203
    invoke-static {}, Lcom/poshmark/controllers/UserStateSummaryController;->getGlobalInteractionsController()Lcom/poshmark/controllers/UserStateSummaryController;

    move-result-object v6

    invoke-virtual {v6}, Lcom/poshmark/controllers/UserStateSummaryController;->getUserStateSummary()Lcom/poshmark/data_model/models/UserStateSummary;

    move-result-object v5

    .line 204
    .local v5, "userStateSummary":Lcom/poshmark/data_model/models/UserStateSummary;
    if-eqz v5, :cond_1

    iget-object v6, v5, Lcom/poshmark/data_model/models/UserStateSummary;->user_info:Lcom/poshmark/data_model/models/UserStateSummary$UserInfo;

    invoke-virtual {v6}, Lcom/poshmark/data_model/models/UserStateSummary$UserInfo;->isMySizeAvailable()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 205
    const/4 v6, 0x1

    invoke-virtual {v1, v6}, Lcom/poshmark/utils/SearchFilterModel;->enableMySizeFilter(Z)V

    .line 208
    :cond_1
    iget-object v6, p1, Lcom/poshmark/data_model/models/SuggestedSearchItem;->kw:Ljava/lang/String;

    invoke-virtual {v1, v6}, Lcom/poshmark/utils/SearchFilterModel;->setQueryText(Ljava/lang/String;)V

    .line 209
    const-string v6, "sl"

    invoke-virtual {v1, v6}, Lcom/poshmark/utils/SearchFilterModel;->setSearchTrigger(Ljava/lang/String;)V

    .line 210
    const-string v6, "category_v2"

    invoke-virtual {v1, v6}, Lcom/poshmark/utils/SearchFilterModel;->setFacet(Ljava/lang/String;)V

    .line 211
    const-string v6, "brand"

    invoke-virtual {v1, v6}, Lcom/poshmark/utils/SearchFilterModel;->setFacet(Ljava/lang/String;)V

    .line 212
    const-string v6, "size"

    invoke-virtual {v1, v6}, Lcom/poshmark/utils/SearchFilterModel;->setFacet(Ljava/lang/String;)V

    .line 213
    iget-object v3, p0, Lcom/poshmark/ui/customviews/PMSearchView;->activity:Landroid/app/Activity;

    check-cast v3, Lcom/poshmark/ui/PMContainerActivity;

    .line 215
    .local v3, "pmActivity":Lcom/poshmark/ui/PMContainerActivity;
    new-instance v4, Landroid/os/Bundle;

    invoke-direct {v4}, Landroid/os/Bundle;-><init>()V

    .line 216
    .local v4, "searchTrigger":Landroid/os/Bundle;
    const-string v6, "SEARCH_TRIGGER"

    const-string v7, "sl"

    invoke-virtual {v4, v6, v7}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 217
    if-eqz p2, :cond_3

    .line 218
    const-string v6, "KEYWORD_SOURCE"

    const-string v7, "dir"

    invoke-virtual {v4, v6, v7}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 224
    :goto_0
    iget-object v6, p0, Lcom/poshmark/ui/customviews/PMSearchView;->parentListener:Lcom/poshmark/utils/PMSearchViewListener;

    if-eqz v6, :cond_2

    .line 225
    iget-object v6, p0, Lcom/poshmark/ui/customviews/PMSearchView;->parentListener:Lcom/poshmark/utils/PMSearchViewListener;

    const/4 v7, 0x0

    invoke-interface {v6, v4, v1, v7}, Lcom/poshmark/utils/PMSearchViewListener;->fireKeywordSearch(Landroid/os/Bundle;Lcom/poshmark/utils/SearchFilterModel;Z)V

    .line 227
    :cond_2
    return-void

    .line 219
    :cond_3
    if-eqz v0, :cond_4

    .line 220
    const-string v6, "KEYWORD_SOURCE"

    const-string v7, "hst"

    invoke-virtual {v4, v6, v7}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 222
    :cond_4
    const-string v6, "KEYWORD_SOURCE"

    const-string v7, "ac"

    invoke-virtual {v4, v6, v7}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public setParentListener(Lcom/poshmark/utils/PMSearchViewListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/poshmark/utils/PMSearchViewListener;

    .prologue
    .line 261
    iput-object p1, p0, Lcom/poshmark/ui/customviews/PMSearchView;->parentListener:Lcom/poshmark/utils/PMSearchViewListener;

    .line 262
    return-void
.end method

.method public setSilentText(Ljava/lang/String;)V
    .locals 1
    .param p1, "txt"    # Ljava/lang/String;

    .prologue
    .line 241
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMSearchView;->clearFocus()V

    .line 242
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/customviews/PMSearchView;->setSuggestionsAdapter(Landroid/widget/CursorAdapter;)V

    .line 243
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Lcom/poshmark/ui/customviews/PMSearchView;->setQuery(Ljava/lang/CharSequence;Z)V

    .line 244
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMSearchView;->adapter:Lcom/poshmark/data_model/adapters/SearchSuggestionsAdapter;

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/customviews/PMSearchView;->setSuggestionsAdapter(Landroid/widget/CursorAdapter;)V

    .line 254
    return-void
.end method

.method public setupEditView()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 230
    iget-object v2, p0, Lcom/poshmark/ui/customviews/PMSearchView;->activity:Landroid/app/Activity;

    invoke-virtual {v2}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const-string v3, "android:id/search_src_text"

    invoke-virtual {v2, v3, v4, v4}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v1

    .line 231
    .local v1, "searchPlateId":I
    if-eqz v1, :cond_0

    .line 232
    invoke-virtual {p0, v1}, Lcom/poshmark/ui/customviews/PMSearchView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    .line 233
    .local v0, "searchEditText":Landroid/widget/EditText;
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMSearchView;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f090035

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getColor(I)I

    move-result v2

    invoke-virtual {v0, v2}, Landroid/widget/EditText;->setTextColor(I)V

    .line 234
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMSearchView;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f090039

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getColor(I)I

    move-result v2

    invoke-virtual {v0, v2}, Landroid/widget/EditText;->setHintTextColor(I)V

    .line 235
    const/16 v2, 0x4000

    invoke-virtual {v0, v2}, Landroid/widget/EditText;->setInputType(I)V

    .line 236
    const/4 v2, 0x2

    const/high16 v3, 0x41500000    # 13.0f

    invoke-virtual {v0, v2, v3}, Landroid/widget/EditText;->setTextSize(IF)V

    .line 238
    .end local v0    # "searchEditText":Landroid/widget/EditText;
    :cond_0
    return-void
.end method

.method public showRecentsAsDefault(Z)V
    .locals 1
    .param p1, "bShow"    # Z

    .prologue
    .line 265
    iput-boolean p1, p0, Lcom/poshmark/ui/customviews/PMSearchView;->bShowRecentsByDefault:Z

    .line 266
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMSearchView;->searchEditText:Landroid/widget/AutoCompleteTextView;

    invoke-virtual {v0}, Landroid/widget/AutoCompleteTextView;->showDropDown()V

    .line 267
    return-void
.end method
