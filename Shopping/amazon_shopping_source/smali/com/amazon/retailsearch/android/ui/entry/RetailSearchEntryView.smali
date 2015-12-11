.class public Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;
.super Landroid/widget/LinearLayout;
.source "RetailSearchEntryView.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/ui/DelayedInitView;


# static fields
.field public static final KEY_SEARCH_SELECT_INITIAL_QUERY:Ljava/lang/String; = "selectInitialQuery"

.field public static final SEARCH_PARAM_TEXT:Ljava/lang/String; = "paramText"

.field public static final SEARCH_SUGGESTION_DEPARTMENT_FILTER:Ljava/lang/String; = "paramSuggestionDepartmentFilter"

.field public static final SEARCH_SUGGESTION_DEPARTMENT_NAME:Ljava/lang/String; = "paramSuggestionDepartmentName"


# instance fields
.field private currentDepartmentName:Ljava/lang/String;

.field private hasSnapIt:Z

.field private isFlowEnabled:Z

.field private listener:Lcom/amazon/retailsearch/android/ui/entry/SearchEntryViewListener;

.field protected mSearchEditText:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;

.field protected mSuggestionListView:Landroid/widget/ListView;

.field platform:Lcom/amazon/retailsearch/j2me/client/util/RetailSearchAndroidPlatform;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field

.field private previousSearchTerm:Ljava/lang/String;

.field private searchAlias:Ljava/lang/String;

.field protected searchBar:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryBar;

.field private searchTerm:Ljava/lang/String;

.field private searchUrl:Ljava/lang/String;

.field private showBarcodeEntry:Z

.field private showVisualScan:Z

.field private textWatcher:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

.field private voiceEnabled:Z


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v0, 0x0

    .line 69
    invoke-direct {p0, p1, p2}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 60
    iput-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->showBarcodeEntry:Z

    .line 61
    iput-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->hasSnapIt:Z

    .line 62
    iput-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->isFlowEnabled:Z

    .line 70
    invoke-static {p0}, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->inject(Ljava/lang/Object;)V

    .line 71
    return-void
.end method

.method private checkForSpecialtyAps()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 138
    const-string/jumbo v0, "APS"

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->searchAlias:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 140
    iput-object v2, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->searchUrl:Ljava/lang/String;

    .line 141
    iput-object v2, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->currentDepartmentName:Ljava/lang/String;

    .line 143
    :cond_0
    return-void
.end method

.method private showSoftKeyBoard()V
    .locals 3

    .prologue
    .line 344
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->getContext()Landroid/content/Context;

    move-result-object v1

    const-string/jumbo v2, "input_method"

    invoke-virtual {v1, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/inputmethod/InputMethodManager;

    .line 346
    .local v0, "inputManager":Landroid/view/inputmethod/InputMethodManager;
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->mSearchEditText:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/inputmethod/InputMethodManager;->showSoftInput(Landroid/view/View;I)Z

    .line 347
    return-void
.end method


# virtual methods
.method protected createSearchTextWatcher()Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;
    .locals 5

    .prologue
    .line 384
    new-instance v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->getContext()Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->mSuggestionListView:Landroid/widget/ListView;

    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->mSearchEditText:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;

    const/4 v4, 0x0

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;-><init>(Landroid/content/Context;Landroid/widget/ListView;Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;Ljava/lang/String;)V

    return-object v0
.end method

.method protected doSearch(Ljava/lang/String;)V
    .locals 4
    .param p1, "query"    # Ljava/lang/String;

    .prologue
    .line 356
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->searchUrl:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 358
    new-instance v2, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;

    invoke-direct {v2, p1}, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;-><init>(Ljava/lang/String;)V

    .line 359
    .local v2, "rsQuery":Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->searchUrl:Ljava/lang/String;

    invoke-virtual {v2, v3}, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->setSearchUrl(Ljava/lang/String;)V

    .line 366
    :goto_0
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->mSuggestionListView:Landroid/widget/ListView;

    invoke-virtual {v3}, Landroid/widget/ListView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v3

    if-eqz v3, :cond_0

    .line 368
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->mSuggestionListView:Landroid/widget/ListView;

    invoke-virtual {v3}, Landroid/widget/ListView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v3

    check-cast v3, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter;

    invoke-virtual {v3}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter;->getCursor()Landroid/database/Cursor;

    move-result-object v0

    .line 369
    .local v0, "cursor":Landroid/database/Cursor;
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->searchAlias:Ljava/lang/String;

    invoke-static {v0, v3, p1}, Lcom/amazon/retailsearch/metrics/IssLogger;->createLogData(Landroid/database/Cursor;Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;

    move-result-object v1

    .line 370
    .local v1, "issEngagementData":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-virtual {v2, v1}, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->setIssEngagementData(Ljava/util/Map;)V

    .line 373
    .end local v0    # "cursor":Landroid/database/Cursor;
    .end local v1    # "issEngagementData":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_0
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->listener:Lcom/amazon/retailsearch/android/ui/entry/SearchEntryViewListener;

    invoke-interface {v3, v2}, Lcom/amazon/retailsearch/android/ui/entry/SearchEntryViewListener;->onQuerySubmit(Lcom/amazon/retailsearch/android/api/query/Query;)V

    .line 374
    return-void

    .line 363
    .end local v2    # "rsQuery":Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;
    :cond_1
    new-instance v2, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;

    invoke-direct {v2, p1}, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;-><init>(Ljava/lang/String;)V

    .restart local v2    # "rsQuery":Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;
    goto :goto_0
.end method

.method protected getCurrentDepartmentName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 394
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->currentDepartmentName:Ljava/lang/String;

    return-object v0
.end method

.method protected getPreviousSearchTerm()Ljava/lang/String;
    .locals 1

    .prologue
    .line 404
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->previousSearchTerm:Ljava/lang/String;

    return-object v0
.end method

.method public isFlowEnabled()Z
    .locals 1

    .prologue
    .line 412
    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->isFlowEnabled:Z

    return v0
.end method

.method protected onDetachedFromWindow()V
    .locals 0

    .prologue
    .line 251
    invoke-super {p0}, Landroid/widget/LinearLayout;->onDetachedFromWindow()V

    .line 252
    return-void
.end method

.method protected onFinishInflate()V
    .locals 4

    .prologue
    .line 180
    invoke-super {p0}, Landroid/widget/LinearLayout;->onFinishInflate()V

    .line 181
    sget v1, Lcom/amazon/retailsearch/R$id;->rs_search_entry_bar:I

    invoke-virtual {p0, v1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryBar;

    iput-object v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->searchBar:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryBar;

    .line 182
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->searchBar:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryBar;

    sget v2, Lcom/amazon/retailsearch/R$id;->rs_search_go_btn:I

    invoke-virtual {v1, v2}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryBar;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    .line 183
    .local v0, "goButton":Landroid/widget/Button;
    new-instance v1, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView$1;

    invoke-direct {v1, p0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView$1;-><init>(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 202
    new-instance v1, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView$2;

    invoke-direct {v1, p0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView$2;-><init>(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 212
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->searchBar:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryBar;

    sget v2, Lcom/amazon/retailsearch/R$id;->rs_search_src_text:I

    invoke-virtual {v1, v2}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryBar;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;

    iput-object v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->mSearchEditText:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;

    .line 213
    sget v1, Lcom/amazon/retailsearch/R$id;->rs_search_suggestion_list_view:I

    invoke-virtual {p0, v1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ListView;

    iput-object v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->mSuggestionListView:Landroid/widget/ListView;

    .line 214
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->mSearchEditText:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->enableClearTextButton(Z)V

    .line 217
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->mSearchEditText:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;

    new-instance v2, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView$3;

    invoke-direct {v2, p0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView$3;-><init>(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;)V

    invoke-virtual {v1, v2}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->setOnEditorActionListener(Landroid/widget/TextView$OnEditorActionListener;)V

    .line 239
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->searchBar:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryBar;

    sget v2, Lcom/amazon/retailsearch/R$id;->rs_search_plate:I

    invoke-virtual {v1, v2}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryBar;->findViewById(I)Landroid/view/View;

    move-result-object v1

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/amazon/retailsearch/R$color;->rs_action_bar_end_color:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getColor(I)I

    move-result v2

    invoke-virtual {v1, v2}, Landroid/view/View;->setBackgroundColor(I)V

    .line 240
    return-void
.end method

.method public onPushViewCompleted()V
    .locals 0

    .prologue
    .line 245
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->showSoftKeyBoard()V

    .line 246
    return-void
.end method

.method public setCurrentDepartmentName(Ljava/lang/String;)V
    .locals 0
    .param p1, "currentDepartmentName"    # Ljava/lang/String;

    .prologue
    .line 100
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->currentDepartmentName:Ljava/lang/String;

    .line 101
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->checkForSpecialtyAps()V

    .line 102
    return-void
.end method

.method public setFlowEnabled(Z)V
    .locals 0
    .param p1, "isFlowEnabled"    # Z

    .prologue
    .line 420
    iput-boolean p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->isFlowEnabled:Z

    .line 421
    return-void
.end method

.method public setHasSnapIt(Z)V
    .locals 0
    .param p1, "hasSnapIt"    # Z

    .prologue
    .line 166
    iput-boolean p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->hasSnapIt:Z

    .line 167
    return-void
.end method

.method public setListener(Lcom/amazon/retailsearch/android/ui/entry/SearchEntryViewListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/retailsearch/android/ui/entry/SearchEntryViewListener;

    .prologue
    .line 80
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->listener:Lcom/amazon/retailsearch/android/ui/entry/SearchEntryViewListener;

    .line 81
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->mSearchEditText:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;

    invoke-virtual {v0, p1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->setListener(Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener;)V

    .line 82
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->searchBar:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryBar;

    invoke-virtual {v0, p1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryBar;->setListener(Lcom/amazon/retailsearch/android/ui/entry/SearchEntryBarListener;)V

    .line 83
    return-void
.end method

.method public setPreviousSearchTerm(Ljava/lang/String;)V
    .locals 0
    .param p1, "previousSearchTerm"    # Ljava/lang/String;

    .prologue
    .line 110
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->previousSearchTerm:Ljava/lang/String;

    .line 111
    return-void
.end method

.method public setSearchAlias(Ljava/lang/String;)V
    .locals 0
    .param p1, "alias"    # Ljava/lang/String;

    .prologue
    .line 127
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->searchAlias:Ljava/lang/String;

    .line 128
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->checkForSpecialtyAps()V

    .line 129
    return-void
.end method

.method public setSearchTerm(Ljava/lang/String;)V
    .locals 0
    .param p1, "searchTerm"    # Ljava/lang/String;

    .prologue
    .line 91
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->searchTerm:Ljava/lang/String;

    .line 92
    return-void
.end method

.method public setSearchUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 118
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->searchUrl:Ljava/lang/String;

    .line 119
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->checkForSpecialtyAps()V

    .line 120
    return-void
.end method

.method public setShowBarcodeEntry(Z)V
    .locals 0
    .param p1, "showBarcodeEntry"    # Z

    .prologue
    .line 158
    iput-boolean p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->showBarcodeEntry:Z

    .line 159
    return-void
.end method

.method public setShowVisualScan(Z)V
    .locals 0
    .param p1, "showVisualScan"    # Z

    .prologue
    .line 174
    iput-boolean p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->showVisualScan:Z

    .line 175
    return-void
.end method

.method public setVoiceEnabled(Z)V
    .locals 0
    .param p1, "voiceEnabled"    # Z

    .prologue
    .line 150
    iput-boolean p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->voiceEnabled:Z

    .line 151
    return-void
.end method

.method public updateEntryView()V
    .locals 8

    .prologue
    const/4 v5, 0x1

    const/4 v7, 0x0

    .line 256
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->searchTerm:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 258
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->mSearchEditText:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->getText()Landroid/text/Editable;

    move-result-object v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->mSearchEditText:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    :goto_0
    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->searchTerm:Ljava/lang/String;

    .line 262
    :cond_0
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->textWatcher:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    if-nez v0, :cond_1

    .line 264
    new-instance v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->getContext()Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->mSuggestionListView:Landroid/widget/ListView;

    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->mSearchEditText:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;

    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->searchAlias:Ljava/lang/String;

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;-><init>(Landroid/content/Context;Landroid/widget/ListView;Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->textWatcher:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    .line 265
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->textWatcher:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->listener:Lcom/amazon/retailsearch/android/ui/entry/SearchEntryViewListener;

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->setListener(Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener;)V

    .line 266
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->textWatcher:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->listener:Lcom/amazon/retailsearch/android/ui/entry/SearchEntryViewListener;

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->setListener(Lcom/amazon/retailsearch/android/ui/entry/TransientSearchChangeListener;)V

    .line 268
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->mSearchEditText:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->mSearchEditText:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->getTextChangedListener()Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->removeTextChangedListener(Landroid/text/TextWatcher;)V

    .line 269
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->mSearchEditText:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->textWatcher:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->addTextChangedListener(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;)V

    .line 272
    :cond_1
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->mSearchEditText:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;

    iget-boolean v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->voiceEnabled:Z

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->setVoiceEnabled(Z)V

    .line 273
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->mSearchEditText:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;

    iget-boolean v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->hasSnapIt:Z

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->setHasSnapIt(Z)V

    .line 274
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->mSearchEditText:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;

    iget-boolean v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->showBarcodeEntry:Z

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->setShowBarcodeEntry(Z)V

    .line 275
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->mSearchEditText:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->currentDepartmentName:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->setCurrentDepartmentName(Ljava/lang/String;)V

    .line 276
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->mSearchEditText:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;

    iget-boolean v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->isFlowEnabled:Z

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->setFlowEnabled(Z)V

    .line 277
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->mSearchEditText:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;

    iget-boolean v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->showVisualScan:Z

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->setShowVisualScan(Z)V

    .line 279
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->searchTerm:Ljava/lang/String;

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->updateSearchEditText(Ljava/lang/String;)V

    .line 285
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->platform:Lcom/amazon/retailsearch/j2me/client/util/RetailSearchAndroidPlatform;

    new-instance v1, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView$4;

    invoke-direct {v1, p0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView$4;-><init>(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;)V

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/j2me/client/util/RetailSearchAndroidPlatform;->invokeLater(Ljava/lang/Runnable;)V

    .line 299
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->currentDepartmentName:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_3

    .line 301
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->mSearchEditText:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/amazon/retailsearch/R$string;->rs_search_menu_item:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/amazon/retailsearch/R$string;->rs_search_suggestions_department_text:I

    new-array v4, v5, [Ljava/lang/Object;

    iget-object v5, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->currentDepartmentName:Ljava/lang/String;

    aput-object v5, v4, v7

    invoke-virtual {v2, v3, v4}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->setHint(Ljava/lang/CharSequence;)V

    .line 314
    :goto_1
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->showSoftKeyBoard()V

    .line 315
    return-void

    .line 258
    :cond_2
    const/4 v0, 0x0

    goto/16 :goto_0

    .line 308
    :cond_3
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->mSearchEditText:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/amazon/retailsearch/R$string;->rs_search_menu_item:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/amazon/retailsearch/R$string;->rs_search_suggestions_department_text:I

    new-array v4, v5, [Ljava/lang/Object;

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    sget v6, Lcom/amazon/retailsearch/R$string;->rs_search_all_departments:I

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v7

    invoke-virtual {v2, v3, v4}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->setHint(Ljava/lang/CharSequence;)V

    goto :goto_1
.end method

.method protected updateSearchEditText(Ljava/lang/String;)V
    .locals 3
    .param p1, "searchTerm"    # Ljava/lang/String;

    .prologue
    .line 319
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->mSearchEditText:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 334
    :cond_0
    :goto_0
    return-void

    .line 324
    :cond_1
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_2

    .line 326
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->mSearchEditText:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;

    invoke-virtual {v1, p1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 329
    :cond_2
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->currentDepartmentName:Ljava/lang/String;

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 331
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->getPreviousSearchTerm()Ljava/lang/String;

    move-result-object v0

    .line 332
    .local v0, "previousSearchTerm":Ljava/lang/String;
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->mSearchEditText:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_3

    const-string/jumbo v0, ""

    .end local v0    # "previousSearchTerm":Ljava/lang/String;
    :cond_3
    invoke-virtual {v1, v0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0
.end method
