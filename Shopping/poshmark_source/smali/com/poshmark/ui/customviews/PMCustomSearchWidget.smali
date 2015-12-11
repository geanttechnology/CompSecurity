.class public Lcom/poshmark/ui/customviews/PMCustomSearchWidget;
.super Landroid/widget/FrameLayout;
.source "PMCustomSearchWidget.java"


# instance fields
.field activity:Lcom/poshmark/ui/PMContainerActivity;

.field clearButton:Landroid/widget/ImageView;

.field private mShowImeRunnable:Ljava/lang/Runnable;

.field parentListener:Lcom/poshmark/utils/PMSearchViewListener;

.field searchView:Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v2, 0x1

    .line 45
    invoke-direct {p0, p1, p2}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 241
    new-instance v1, Lcom/poshmark/ui/customviews/PMCustomSearchWidget$7;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/customviews/PMCustomSearchWidget$7;-><init>(Lcom/poshmark/ui/customviews/PMCustomSearchWidget;)V

    iput-object v1, p0, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->mShowImeRunnable:Ljava/lang/Runnable;

    .line 46
    check-cast p1, Lcom/poshmark/ui/PMContainerActivity;

    .end local p1    # "context":Landroid/content/Context;
    iput-object p1, p0, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->activity:Lcom/poshmark/ui/PMContainerActivity;

    .line 47
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    .line 48
    .local v0, "inflater":Landroid/view/LayoutInflater;
    const v1, 0x7f030036

    invoke-virtual {v0, v1, p0, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    .line 49
    invoke-direct {p0}, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->setup()V

    .line 50
    invoke-virtual {p0, v2}, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->setFocusable(Z)V

    .line 51
    return-void
.end method

.method private setup()V
    .locals 3

    .prologue
    .line 54
    const v0, 0x7f0c00ec

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;

    iput-object v0, p0, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->searchView:Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;

    .line 55
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->searchView:Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f090039

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;->setHintTextColor(I)V

    .line 56
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->searchView:Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;

    invoke-virtual {v0, p0}, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;->setParentWidget(Lcom/poshmark/ui/customviews/PMCustomSearchWidget;)V

    .line 58
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->searchView:Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;

    new-instance v1, Lcom/poshmark/ui/customviews/PMCustomSearchWidget$1;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/customviews/PMCustomSearchWidget$1;-><init>(Lcom/poshmark/ui/customviews/PMCustomSearchWidget;)V

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 84
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->searchView:Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;

    new-instance v1, Lcom/poshmark/ui/customviews/PMCustomSearchWidget$2;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/customviews/PMCustomSearchWidget$2;-><init>(Lcom/poshmark/ui/customviews/PMCustomSearchWidget;)V

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 94
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->searchView:Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;

    new-instance v1, Lcom/poshmark/ui/customviews/PMCustomSearchWidget$3;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/customviews/PMCustomSearchWidget$3;-><init>(Lcom/poshmark/ui/customviews/PMCustomSearchWidget;)V

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;->setOnEditorActionListener(Landroid/widget/TextView$OnEditorActionListener;)V

    .line 109
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->searchView:Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;

    new-instance v1, Lcom/poshmark/ui/customviews/PMCustomSearchWidget$4;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/customviews/PMCustomSearchWidget$4;-><init>(Lcom/poshmark/ui/customviews/PMCustomSearchWidget;)V

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 122
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->searchView:Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;

    new-instance v1, Lcom/poshmark/ui/customviews/PMCustomSearchWidget$5;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/customviews/PMCustomSearchWidget$5;-><init>(Lcom/poshmark/ui/customviews/PMCustomSearchWidget;)V

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;->setOnFocusChangeListener(Landroid/view/View$OnFocusChangeListener;)V

    .line 139
    const v0, 0x7f0c00ed

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->clearButton:Landroid/widget/ImageView;

    .line 140
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->clearButton:Landroid/widget/ImageView;

    new-instance v1, Lcom/poshmark/ui/customviews/PMCustomSearchWidget$6;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/customviews/PMCustomSearchWidget$6;-><init>(Lcom/poshmark/ui/customviews/PMCustomSearchWidget;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 147
    return-void
.end method


# virtual methods
.method public clearFocus()V
    .locals 1

    .prologue
    .line 164
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->searchView:Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;->clearFocus()V

    .line 165
    return-void
.end method

.method public getUserInput()Ljava/lang/String;
    .locals 1

    .prologue
    .line 178
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->searchView:Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public launchSearch(Lcom/poshmark/data_model/models/SuggestedSearchItem;Z)V
    .locals 9
    .param p1, "searchItem"    # Lcom/poshmark/data_model/models/SuggestedSearchItem;
    .param p2, "userTypedQuery"    # Z

    .prologue
    .line 182
    const/4 v2, 0x0

    .line 183
    .local v2, "launchBrandSearch":Z
    iget-object v7, p0, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->searchView:Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;

    invoke-virtual {v7}, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;->getCursor()Landroid/database/Cursor;

    move-result-object v4

    .line 184
    .local v4, "oldCursor":Landroid/database/Cursor;
    if-eqz v4, :cond_0

    .line 185
    invoke-interface {v4}, Landroid/database/Cursor;->close()V

    .line 187
    :cond_0
    invoke-static {}, Lcom/poshmark/controllers/GlobalDbController;->getGlobalDbController()Lcom/poshmark/controllers/GlobalDbController;

    move-result-object v7

    iget-object v8, p1, Lcom/poshmark/data_model/models/SuggestedSearchItem;->kw:Ljava/lang/String;

    invoke-virtual {v7, v8}, Lcom/poshmark/controllers/GlobalDbController;->isKeywordInSavedSearches(Ljava/lang/String;)Z

    move-result v1

    .line 188
    .local v1, "isSavedSearchSelected":Z
    invoke-static {}, Lcom/poshmark/controllers/GlobalDbController;->getGlobalDbController()Lcom/poshmark/controllers/GlobalDbController;

    move-result-object v7

    iget-object v8, p1, Lcom/poshmark/data_model/models/SuggestedSearchItem;->kw:Ljava/lang/String;

    invoke-virtual {v7, v8}, Lcom/poshmark/controllers/GlobalDbController;->addNewSearchToSavedSearches(Ljava/lang/String;)V

    .line 189
    new-instance v3, Lcom/poshmark/utils/SearchFilterModel;

    invoke-direct {v3}, Lcom/poshmark/utils/SearchFilterModel;-><init>()V

    .line 190
    .local v3, "model":Lcom/poshmark/utils/SearchFilterModel;
    const-string v7, "available"

    invoke-virtual {v3, v7}, Lcom/poshmark/utils/SearchFilterModel;->setAvailability(Ljava/lang/String;)V

    .line 192
    invoke-static {}, Lcom/poshmark/controllers/UserStateSummaryController;->getGlobalInteractionsController()Lcom/poshmark/controllers/UserStateSummaryController;

    move-result-object v7

    invoke-virtual {v7}, Lcom/poshmark/controllers/UserStateSummaryController;->getUserStateSummary()Lcom/poshmark/data_model/models/UserStateSummary;

    move-result-object v6

    .line 193
    .local v6, "userStateSummary":Lcom/poshmark/data_model/models/UserStateSummary;
    if-eqz v6, :cond_1

    iget-object v7, v6, Lcom/poshmark/data_model/models/UserStateSummary;->user_info:Lcom/poshmark/data_model/models/UserStateSummary$UserInfo;

    invoke-virtual {v7}, Lcom/poshmark/data_model/models/UserStateSummary$UserInfo;->isMySizeAvailable()Z

    move-result v7

    if-eqz v7, :cond_1

    .line 194
    const/4 v7, 0x1

    invoke-virtual {v3, v7}, Lcom/poshmark/utils/SearchFilterModel;->enableMySizeFilter(Z)V

    .line 197
    :cond_1
    new-instance v5, Landroid/os/Bundle;

    invoke-direct {v5}, Landroid/os/Bundle;-><init>()V

    .line 198
    .local v5, "searchTrigger":Landroid/os/Bundle;
    iget-object v7, p1, Lcom/poshmark/data_model/models/SuggestedSearchItem;->type:Ljava/lang/String;

    if-eqz v7, :cond_3

    iget-object v7, p1, Lcom/poshmark/data_model/models/SuggestedSearchItem;->type:Ljava/lang/String;

    const-string v8, "brand"

    invoke-virtual {v7, v8}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_3

    .line 199
    const-string v7, "br"

    invoke-virtual {v3, v7}, Lcom/poshmark/utils/SearchFilterModel;->setSearchTrigger(Ljava/lang/String;)V

    .line 200
    const/4 v2, 0x1

    .line 201
    invoke-static {}, Lcom/poshmark/controllers/GlobalDbController;->getGlobalDbController()Lcom/poshmark/controllers/GlobalDbController;

    move-result-object v7

    iget-object v8, p1, Lcom/poshmark/data_model/models/SuggestedSearchItem;->kw:Ljava/lang/String;

    invoke-virtual {v7, v8}, Lcom/poshmark/controllers/GlobalDbController;->getBrandCanonicalName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 202
    .local v0, "brand_canonical_name":Ljava/lang/String;
    const-string v7, "ID"

    invoke-virtual {v5, v7, v0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 207
    .end local v0    # "brand_canonical_name":Ljava/lang/String;
    :goto_0
    const-string v7, "category_v2"

    invoke-virtual {v3, v7}, Lcom/poshmark/utils/SearchFilterModel;->setFacet(Ljava/lang/String;)V

    .line 208
    const-string v7, "brand"

    invoke-virtual {v3, v7}, Lcom/poshmark/utils/SearchFilterModel;->setFacet(Ljava/lang/String;)V

    .line 209
    const-string v7, "size"

    invoke-virtual {v3, v7}, Lcom/poshmark/utils/SearchFilterModel;->setFacet(Ljava/lang/String;)V

    .line 210
    const-string v7, "color"

    invoke-virtual {v3, v7}, Lcom/poshmark/utils/SearchFilterModel;->setFacet(Ljava/lang/String;)V

    .line 211
    const-string v7, "category_feature"

    invoke-virtual {v3, v7}, Lcom/poshmark/utils/SearchFilterModel;->setFacet(Ljava/lang/String;)V

    .line 213
    const-string v7, "SEARCH_TRIGGER"

    const-string v8, "sl"

    invoke-virtual {v5, v7, v8}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 214
    if-eqz p2, :cond_4

    .line 215
    const-string v7, "KEYWORD_SOURCE"

    const-string v8, "dir"

    invoke-virtual {v5, v7, v8}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 221
    :goto_1
    iget-object v7, p0, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->parentListener:Lcom/poshmark/utils/PMSearchViewListener;

    if-eqz v7, :cond_2

    .line 222
    iget-object v7, p1, Lcom/poshmark/data_model/models/SuggestedSearchItem;->kw:Ljava/lang/String;

    invoke-static {v7}, Lcom/poshmark/utils/FBDPAHelper;->trackSearch(Ljava/lang/String;)V

    .line 223
    iget-object v7, p0, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->parentListener:Lcom/poshmark/utils/PMSearchViewListener;

    invoke-interface {v7, v5, v3, v2}, Lcom/poshmark/utils/PMSearchViewListener;->fireKeywordSearch(Landroid/os/Bundle;Lcom/poshmark/utils/SearchFilterModel;Z)V

    .line 225
    :cond_2
    return-void

    .line 204
    :cond_3
    iget-object v7, p1, Lcom/poshmark/data_model/models/SuggestedSearchItem;->kw:Ljava/lang/String;

    invoke-virtual {v3, v7}, Lcom/poshmark/utils/SearchFilterModel;->setQueryText(Ljava/lang/String;)V

    .line 205
    const-string v7, "sl"

    invoke-virtual {v3, v7}, Lcom/poshmark/utils/SearchFilterModel;->setSearchTrigger(Ljava/lang/String;)V

    goto :goto_0

    .line 216
    :cond_4
    if-eqz v1, :cond_5

    .line 217
    const-string v7, "KEYWORD_SOURCE"

    const-string v8, "hst"

    invoke-virtual {v5, v7, v8}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 219
    :cond_5
    const-string v7, "KEYWORD_SOURCE"

    const-string v8, "ac"

    invoke-virtual {v5, v7, v8}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1
.end method

.method public setImeVisibility(Z)V
    .locals 3
    .param p1, "visible"    # Z

    .prologue
    .line 228
    if-eqz p1, :cond_1

    .line 229
    iget-object v1, p0, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->mShowImeRunnable:Ljava/lang/Runnable;

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->post(Ljava/lang/Runnable;)Z

    .line 239
    :cond_0
    :goto_0
    return-void

    .line 231
    :cond_1
    iget-object v1, p0, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->mShowImeRunnable:Ljava/lang/Runnable;

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->removeCallbacks(Ljava/lang/Runnable;)Z

    .line 232
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->getContext()Landroid/content/Context;

    move-result-object v1

    const-string v2, "input_method"

    invoke-virtual {v1, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/inputmethod/InputMethodManager;

    .line 235
    .local v0, "imm":Landroid/view/inputmethod/InputMethodManager;
    if-eqz v0, :cond_0

    .line 236
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->getWindowToken()Landroid/os/IBinder;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/inputmethod/InputMethodManager;->hideSoftInputFromWindow(Landroid/os/IBinder;I)Z

    goto :goto_0
.end method

.method public setParentListener(Lcom/poshmark/utils/PMSearchViewListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/poshmark/utils/PMSearchViewListener;

    .prologue
    .line 160
    iput-object p1, p0, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->parentListener:Lcom/poshmark/utils/PMSearchViewListener;

    .line 161
    return-void
.end method

.method public setSilentText(Ljava/lang/String;)V
    .locals 1
    .param p1, "txt"    # Ljava/lang/String;

    .prologue
    .line 168
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->searchView:Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;

    invoke-virtual {v0, p1}, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;->setSilentText(Ljava/lang/String;)V

    .line 169
    return-void
.end method

.method public setText(Ljava/lang/String;)V
    .locals 2
    .param p1, "searchKeyword"    # Ljava/lang/String;

    .prologue
    .line 172
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->searchView:Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;

    invoke-virtual {v0, p1}, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;->setText(Ljava/lang/CharSequence;)V

    .line 173
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->activity:Lcom/poshmark/ui/PMContainerActivity;

    invoke-virtual {v0}, Lcom/poshmark/ui/PMContainerActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/view/Window;->setSoftInputMode(I)V

    .line 174
    return-void
.end method

.method public showRecentsAsDefaults(Z)V
    .locals 4
    .param p1, "bShow"    # Z

    .prologue
    .line 150
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->searchView:Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;

    if-eqz v0, :cond_0

    .line 151
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->searchView:Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;

    invoke-virtual {v0, p1}, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;->showRecentsAsDefault(Z)V

    .line 152
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->searchView:Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;->requestFocus()Z

    .line 153
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->searchView:Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;

    const-string v1, ""

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;->setText(Ljava/lang/CharSequence;)V

    .line 155
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->searchView:Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;

    new-instance v1, Landroid/view/KeyEvent;

    const/4 v2, 0x0

    const/16 v3, 0x43

    invoke-direct {v1, v2, v3}, Landroid/view/KeyEvent;-><init>(II)V

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;->dispatchKeyEvent(Landroid/view/KeyEvent;)Z

    .line 157
    :cond_0
    return-void
.end method
