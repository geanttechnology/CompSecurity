.class public Lcom/poshmark/data_model/adapters/SearchSuggestionsAdapter;
.super Landroid/widget/CursorAdapter;
.source "SearchSuggestionsAdapter.java"


# instance fields
.field clearButtonListener:Landroid/view/View$OnClickListener;

.field cntx:Landroid/content/Context;

.field footerView:Landroid/view/View;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/database/Cursor;ILandroid/view/View$OnClickListener;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "c"    # Landroid/database/Cursor;
    .param p3, "flags"    # I
    .param p4, "listener"    # Landroid/view/View$OnClickListener;

    .prologue
    .line 30
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/CursorAdapter;-><init>(Landroid/content/Context;Landroid/database/Cursor;I)V

    .line 31
    iput-object p1, p0, Lcom/poshmark/data_model/adapters/SearchSuggestionsAdapter;->cntx:Landroid/content/Context;

    .line 32
    iput-object p4, p0, Lcom/poshmark/data_model/adapters/SearchSuggestionsAdapter;->clearButtonListener:Landroid/view/View$OnClickListener;

    .line 33
    return-void
.end method

.method private addFooterClearButton(Landroid/widget/ListView;)V
    .locals 5
    .param p1, "parent"    # Landroid/widget/ListView;

    .prologue
    const/4 v4, 0x0

    .line 49
    invoke-virtual {p1}, Landroid/widget/ListView;->getHeaderViewsCount()I

    move-result v2

    if-nez v2, :cond_0

    .line 50
    iget-object v2, p0, Lcom/poshmark/data_model/adapters/SearchSuggestionsAdapter;->cntx:Landroid/content/Context;

    const-string v3, "layout_inflater"

    invoke-virtual {v2, v3}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/view/LayoutInflater;

    .line 51
    .local v1, "vi":Landroid/view/LayoutInflater;
    const v2, 0x7f0300af

    invoke-virtual {v1, v2, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/data_model/adapters/SearchSuggestionsAdapter;->footerView:Landroid/view/View;

    .line 52
    invoke-virtual {p1, v4}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 53
    iget-object v2, p0, Lcom/poshmark/data_model/adapters/SearchSuggestionsAdapter;->footerView:Landroid/view/View;

    invoke-virtual {p1, v2}, Landroid/widget/ListView;->addHeaderView(Landroid/view/View;)V

    .line 54
    invoke-virtual {p1, p0}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 57
    iget-object v2, p0, Lcom/poshmark/data_model/adapters/SearchSuggestionsAdapter;->footerView:Landroid/view/View;

    const v3, 0x7f0c029b

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    .line 58
    .local v0, "clearButton":Landroid/widget/Button;
    iget-object v2, p0, Lcom/poshmark/data_model/adapters/SearchSuggestionsAdapter;->clearButtonListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 60
    .end local v0    # "clearButton":Landroid/widget/Button;
    .end local v1    # "vi":Landroid/view/LayoutInflater;
    :cond_0
    return-void
.end method


# virtual methods
.method public bindView(Landroid/view/View;Landroid/content/Context;Landroid/database/Cursor;)V
    .locals 6
    .param p1, "view"    # Landroid/view/View;
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "cursor"    # Landroid/database/Cursor;

    .prologue
    .line 65
    move-object v1, p3

    check-cast v1, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    .line 66
    .local v1, "matrixCursor":Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;
    sget-object v4, Lcom/poshmark/data_model/models/PMData;->DATA_COL:Ljava/lang/String;

    invoke-virtual {v1, v4}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    .line 69
    .local v0, "idCol":I
    invoke-virtual {v1, v0}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/poshmark/data_model/models/SuggestedSearchItem;

    .line 70
    .local v2, "suggestion":Lcom/poshmark/data_model/models/SuggestedSearchItem;
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/poshmark/utils/view_holders/SearchSuggestionsViewHolder;

    .line 71
    .local v3, "viewHolder":Lcom/poshmark/utils/view_holders/SearchSuggestionsViewHolder;
    iget-object v4, v3, Lcom/poshmark/utils/view_holders/SearchSuggestionsViewHolder;->searchSuggestion:Lcom/poshmark/ui/customviews/PMTextView;

    iget-object v5, v2, Lcom/poshmark/data_model/models/SuggestedSearchItem;->kw:Ljava/lang/String;

    invoke-virtual {v4, v5}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 74
    invoke-static {}, Lcom/poshmark/controllers/GlobalDbController;->getGlobalDbController()Lcom/poshmark/controllers/GlobalDbController;

    move-result-object v4

    iget-object v5, v2, Lcom/poshmark/data_model/models/SuggestedSearchItem;->kw:Ljava/lang/String;

    invoke-virtual {v4, v5}, Lcom/poshmark/controllers/GlobalDbController;->isBrand(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 75
    const-string v4, "brand"

    iput-object v4, v2, Lcom/poshmark/data_model/models/SuggestedSearchItem;->type:Ljava/lang/String;

    .line 76
    iget-object v4, v3, Lcom/poshmark/utils/view_holders/SearchSuggestionsViewHolder;->brandIndicatorLabel:Lcom/poshmark/ui/customviews/PMTextView;

    const/4 v5, 0x0

    invoke-virtual {v4, v5}, Lcom/poshmark/ui/customviews/PMTextView;->setVisibility(I)V

    .line 81
    :goto_0
    return-void

    .line 78
    :cond_0
    const/4 v4, 0x0

    iput-object v4, v2, Lcom/poshmark/data_model/models/SuggestedSearchItem;->type:Ljava/lang/String;

    .line 79
    iget-object v4, v3, Lcom/poshmark/utils/view_holders/SearchSuggestionsViewHolder;->brandIndicatorLabel:Lcom/poshmark/ui/customviews/PMTextView;

    const/16 v5, 0x8

    invoke-virtual {v4, v5}, Lcom/poshmark/ui/customviews/PMTextView;->setVisibility(I)V

    goto :goto_0
.end method

.method public convertToString(Landroid/database/Cursor;)Ljava/lang/CharSequence;
    .locals 4
    .param p1, "cursor"    # Landroid/database/Cursor;

    .prologue
    .line 86
    move-object v1, p1

    check-cast v1, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    .line 88
    .local v1, "matrixCursor":Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;
    sget-object v3, Lcom/poshmark/data_model/models/PMData;->DATA_COL:Ljava/lang/String;

    invoke-virtual {v1, v3}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    .line 89
    .local v0, "idCol":I
    invoke-virtual {v1, v0}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/poshmark/data_model/models/SuggestedSearchItem;

    .line 90
    .local v2, "suggestion":Lcom/poshmark/data_model/models/SuggestedSearchItem;
    iget-object v3, v2, Lcom/poshmark/data_model/models/SuggestedSearchItem;->kw:Ljava/lang/String;

    return-object v3
.end method

.method public newView(Landroid/content/Context;Landroid/database/Cursor;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 6
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "cursor"    # Landroid/database/Cursor;
    .param p3, "viewGroup"    # Landroid/view/ViewGroup;

    .prologue
    .line 37
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    .line 38
    .local v0, "inflater":Landroid/view/LayoutInflater;
    const v4, 0x7f0300b0

    const/4 v5, 0x0

    invoke-virtual {v0, v4, p3, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v2

    .local v2, "v":Landroid/view/View;
    move-object v1, p3

    .line 39
    check-cast v1, Landroid/widget/ListView;

    .line 41
    .local v1, "parent":Landroid/widget/ListView;
    new-instance v3, Lcom/poshmark/utils/view_holders/SearchSuggestionsViewHolder;

    invoke-direct {v3}, Lcom/poshmark/utils/view_holders/SearchSuggestionsViewHolder;-><init>()V

    .line 42
    .local v3, "viewHolder":Lcom/poshmark/utils/view_holders/SearchSuggestionsViewHolder;
    const v4, 0x7f0c029c

    invoke-virtual {v2, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Lcom/poshmark/ui/customviews/PMTextView;

    iput-object v4, v3, Lcom/poshmark/utils/view_holders/SearchSuggestionsViewHolder;->searchSuggestion:Lcom/poshmark/ui/customviews/PMTextView;

    .line 43
    const v4, 0x7f0c029d

    invoke-virtual {v2, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Lcom/poshmark/ui/customviews/PMTextView;

    iput-object v4, v3, Lcom/poshmark/utils/view_holders/SearchSuggestionsViewHolder;->brandIndicatorLabel:Lcom/poshmark/ui/customviews/PMTextView;

    .line 44
    invoke-virtual {v2, v3}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 45
    return-object v2
.end method
