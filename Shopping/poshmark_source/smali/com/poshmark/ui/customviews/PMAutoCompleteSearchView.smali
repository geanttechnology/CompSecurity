.class public Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;
.super Landroid/widget/AutoCompleteTextView;
.source "PMAutoCompleteSearchView.java"


# instance fields
.field adapter:Lcom/poshmark/data_model/adapters/SearchSuggestionsAdapter;

.field bShowRecentsByDefault:Z

.field clearButton:Landroid/graphics/drawable/BitmapDrawable;

.field currentSearchString:Ljava/lang/String;

.field parentWidget:Lcom/poshmark/ui/customviews/PMCustomSearchWidget;

.field suggestionsData:Lcom/poshmark/data_model/models/SearchSuggestionsManager;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 34
    invoke-direct {p0, p1}, Landroid/widget/AutoCompleteTextView;-><init>(Landroid/content/Context;)V

    .line 28
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;->bShowRecentsByDefault:Z

    .line 35
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 40
    invoke-direct {p0, p1, p2}, Landroid/widget/AutoCompleteTextView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 28
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;->bShowRecentsByDefault:Z

    .line 41
    invoke-direct {p0}, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;->setup()V

    .line 42
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    .line 48
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/AutoCompleteTextView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 28
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;->bShowRecentsByDefault:Z

    .line 49
    return-void
.end method

.method private setup()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 93
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f020089

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    check-cast v0, Landroid/graphics/drawable/BitmapDrawable;

    iput-object v0, p0, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;->clearButton:Landroid/graphics/drawable/BitmapDrawable;

    .line 94
    new-instance v0, Lcom/poshmark/data_model/adapters/SearchSuggestionsAdapter;

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;->getContext()Landroid/content/Context;

    move-result-object v1

    const/high16 v2, -0x80000000

    invoke-direct {v0, v1, v3, v2, v3}, Lcom/poshmark/data_model/adapters/SearchSuggestionsAdapter;-><init>(Landroid/content/Context;Landroid/database/Cursor;ILandroid/view/View$OnClickListener;)V

    iput-object v0, p0, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;->adapter:Lcom/poshmark/data_model/adapters/SearchSuggestionsAdapter;

    .line 95
    new-instance v0, Lcom/poshmark/data_model/models/SearchSuggestionsManager;

    invoke-direct {v0}, Lcom/poshmark/data_model/models/SearchSuggestionsManager;-><init>()V

    iput-object v0, p0, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;->suggestionsData:Lcom/poshmark/data_model/models/SearchSuggestionsManager;

    .line 96
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;->suggestionsData:Lcom/poshmark/data_model/models/SearchSuggestionsManager;

    iget-object v1, p0, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;->adapter:Lcom/poshmark/data_model/adapters/SearchSuggestionsAdapter;

    invoke-virtual {v0, v1}, Lcom/poshmark/data_model/models/SearchSuggestionsManager;->setListAdapter(Lcom/poshmark/data_model/adapters/SearchSuggestionsAdapter;)V

    .line 97
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;->adapter:Lcom/poshmark/data_model/adapters/SearchSuggestionsAdapter;

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 98
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;->setThreshold(I)V

    .line 100
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;->adapter:Lcom/poshmark/data_model/adapters/SearchSuggestionsAdapter;

    new-instance v1, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView$1;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView$1;-><init>(Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;)V

    invoke-virtual {v0, v1}, Lcom/poshmark/data_model/adapters/SearchSuggestionsAdapter;->setFilterQueryProvider(Landroid/widget/FilterQueryProvider;)V

    .line 146
    return-void
.end method


# virtual methods
.method public enoughToFilter()Z
    .locals 3

    .prologue
    const/4 v0, 0x1

    .line 58
    iget-boolean v1, p0, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;->bShowRecentsByDefault:Z

    if-eqz v1, :cond_1

    .line 61
    :cond_0
    :goto_0
    return v0

    :cond_1
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-interface {v1}, Landroid/text/Editable;->length()I

    move-result v1

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;->getThreshold()I

    move-result v2

    if-ge v1, v2, :cond_0

    const/4 v0, 0x0

    goto :goto_0
.end method

.method public bridge synthetic getAdapter()Landroid/widget/ListAdapter;
    .locals 1

    .prologue
    .line 24
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;->getAdapter()Lcom/poshmark/data_model/adapters/SearchSuggestionsAdapter;

    move-result-object v0

    return-object v0
.end method

.method public getAdapter()Lcom/poshmark/data_model/adapters/SearchSuggestionsAdapter;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;->adapter:Lcom/poshmark/data_model/adapters/SearchSuggestionsAdapter;

    return-object v0
.end method

.method public getCursor()Landroid/database/Cursor;
    .locals 1

    .prologue
    .line 161
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;->adapter:Lcom/poshmark/data_model/adapters/SearchSuggestionsAdapter;

    invoke-virtual {v0}, Lcom/poshmark/data_model/adapters/SearchSuggestionsAdapter;->getCursor()Landroid/database/Cursor;

    move-result-object v0

    return-object v0
.end method

.method public onKeyPreIme(ILandroid/view/KeyEvent;)Z
    .locals 4
    .param p1, "keyCode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;

    .prologue
    const/4 v1, 0x1

    .line 67
    const/4 v2, 0x4

    if-ne p1, v2, :cond_3

    .line 70
    invoke-virtual {p2}, Landroid/view/KeyEvent;->getAction()I

    move-result v2

    if-nez v2, :cond_1

    invoke-virtual {p2}, Landroid/view/KeyEvent;->getRepeatCount()I

    move-result v2

    if-nez v2, :cond_1

    .line 71
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;->getKeyDispatcherState()Landroid/view/KeyEvent$DispatcherState;

    move-result-object v0

    .line 72
    .local v0, "state":Landroid/view/KeyEvent$DispatcherState;
    if-eqz v0, :cond_0

    .line 73
    invoke-virtual {v0, p2, p0}, Landroid/view/KeyEvent$DispatcherState;->startTracking(Landroid/view/KeyEvent;Ljava/lang/Object;)V

    .line 88
    .end local v0    # "state":Landroid/view/KeyEvent$DispatcherState;
    :cond_0
    :goto_0
    return v1

    .line 76
    :cond_1
    invoke-virtual {p2}, Landroid/view/KeyEvent;->getAction()I

    move-result v2

    if-ne v2, v1, :cond_3

    .line 77
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;->getKeyDispatcherState()Landroid/view/KeyEvent$DispatcherState;

    move-result-object v0

    .line 78
    .restart local v0    # "state":Landroid/view/KeyEvent$DispatcherState;
    if-eqz v0, :cond_2

    .line 79
    invoke-virtual {v0, p2}, Landroid/view/KeyEvent$DispatcherState;->handleUpEvent(Landroid/view/KeyEvent;)V

    .line 81
    :cond_2
    invoke-virtual {p2}, Landroid/view/KeyEvent;->isTracking()Z

    move-result v2

    if-eqz v2, :cond_3

    invoke-virtual {p2}, Landroid/view/KeyEvent;->isCanceled()Z

    move-result v2

    if-nez v2, :cond_3

    .line 82
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;->clearFocus()V

    .line 83
    iget-object v2, p0, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;->parentWidget:Lcom/poshmark/ui/customviews/PMCustomSearchWidget;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->setImeVisibility(Z)V

    goto :goto_0

    .line 88
    .end local v0    # "state":Landroid/view/KeyEvent$DispatcherState;
    :cond_3
    invoke-super {p0, p1, p2}, Landroid/widget/AutoCompleteTextView;->onKeyPreIme(ILandroid/view/KeyEvent;)Z

    move-result v1

    goto :goto_0
.end method

.method public setParentWidget(Lcom/poshmark/ui/customviews/PMCustomSearchWidget;)V
    .locals 0
    .param p1, "pmCustomSearchWidget"    # Lcom/poshmark/ui/customviews/PMCustomSearchWidget;

    .prologue
    .line 166
    iput-object p1, p0, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;->parentWidget:Lcom/poshmark/ui/customviews/PMCustomSearchWidget;

    .line 167
    return-void
.end method

.method public setSilentText(Ljava/lang/String;)V
    .locals 1
    .param p1, "txt"    # Ljava/lang/String;

    .prologue
    .line 153
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;->clearFocus()V

    .line 155
    invoke-virtual {p0, p1}, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;->setText(Ljava/lang/CharSequence;)V

    .line 156
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;->adapter:Lcom/poshmark/data_model/adapters/SearchSuggestionsAdapter;

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 157
    return-void
.end method

.method public showRecentsAsDefault(Z)V
    .locals 0
    .param p1, "bShow"    # Z

    .prologue
    .line 149
    iput-boolean p1, p0, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;->bShowRecentsByDefault:Z

    .line 150
    return-void
.end method
