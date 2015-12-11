.class public Lcom/poshmark/ui/customviews/PMListView;
.super Landroid/widget/ListView;
.source "PMListView.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/ui/customviews/PMListView$LoadMoreItemsListener;
    }
.end annotation


# instance fields
.field adapter:Landroid/widget/CursorAdapter;

.field emptyContentView:Landroid/view/View;

.field private fetchingMoreItemsOnScroll:Z

.field footerView:Landroid/view/View;

.field listData:Lcom/poshmark/data_model/models/PMData;

.field loadMoreItemsListener:Lcom/poshmark/ui/customviews/PMListView$LoadMoreItemsListener;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v2, 0x0

    .line 34
    invoke-direct {p0, p1, p2}, Landroid/widget/ListView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 24
    const/4 v1, 0x0

    iput-boolean v1, p0, Lcom/poshmark/ui/customviews/PMListView;->fetchingMoreItemsOnScroll:Z

    .line 29
    iput-object v2, p0, Lcom/poshmark/ui/customviews/PMListView;->listData:Lcom/poshmark/data_model/models/PMData;

    .line 36
    invoke-direct {p0}, Lcom/poshmark/ui/customviews/PMListView;->setupScrollHandler()V

    .line 39
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    .line 40
    .local v0, "vi":Landroid/view/LayoutInflater;
    const v1, 0x7f03004d

    invoke-virtual {v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/ui/customviews/PMListView;->footerView:Landroid/view/View;

    .line 41
    iget-object v1, p0, Lcom/poshmark/ui/customviews/PMListView;->footerView:Landroid/view/View;

    invoke-super {p0, v1}, Landroid/widget/ListView;->addFooterView(Landroid/view/View;)V

    .line 42
    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/ui/customviews/PMListView;)Z
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/customviews/PMListView;

    .prologue
    .line 21
    iget-boolean v0, p0, Lcom/poshmark/ui/customviews/PMListView;->fetchingMoreItemsOnScroll:Z

    return v0
.end method

.method static synthetic access$002(Lcom/poshmark/ui/customviews/PMListView;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/customviews/PMListView;
    .param p1, "x1"    # Z

    .prologue
    .line 21
    iput-boolean p1, p0, Lcom/poshmark/ui/customviews/PMListView;->fetchingMoreItemsOnScroll:Z

    return p1
.end method

.method private setupScrollHandler()V
    .locals 1

    .prologue
    .line 76
    new-instance v0, Lcom/poshmark/ui/customviews/PMListView$1;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/customviews/PMListView$1;-><init>(Lcom/poshmark/ui/customviews/PMListView;)V

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/customviews/PMListView;->setOnScrollListener(Landroid/widget/AbsListView$OnScrollListener;)V

    .line 105
    return-void
.end method


# virtual methods
.method public addFooterView(Landroid/view/View;)V
    .locals 2
    .param p1, "footerView"    # Landroid/view/View;

    .prologue
    .line 72
    new-instance v0, Ljava/lang/IllegalAccessError;

    const-string v1, "Footer should be added using the setup method"

    invoke-direct {v0, v1}, Ljava/lang/IllegalAccessError;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public addHeaderView(Landroid/view/View;)V
    .locals 2
    .param p1, "headerView"    # Landroid/view/View;

    .prologue
    .line 67
    new-instance v0, Ljava/lang/IllegalAccessError;

    const-string v1, "Header should be added using the setup method"

    invoke-direct {v0, v1}, Ljava/lang/IllegalAccessError;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public removeEmptyContentView()V
    .locals 1

    .prologue
    .line 129
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMListView;->emptyContentView:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 130
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMListView;->emptyContentView:Landroid/view/View;

    invoke-super {p0, v0}, Landroid/widget/ListView;->removeHeaderView(Landroid/view/View;)Z

    .line 131
    :cond_0
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/ui/customviews/PMListView;->emptyContentView:Landroid/view/View;

    .line 132
    return-void
.end method

.method public resetScrollState()V
    .locals 4

    .prologue
    .line 135
    iget-object v1, p0, Lcom/poshmark/ui/customviews/PMListView;->footerView:Landroid/view/View;

    const v2, 0x7f0c012d

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    .line 136
    .local v0, "footerLayout":Landroid/widget/LinearLayout;
    invoke-virtual {v0}, Landroid/widget/LinearLayout;->removeAllViews()V

    .line 137
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMListView;->getContext()Landroid/content/Context;

    move-result-object v1

    const/16 v2, 0xf

    const/4 v3, 0x0

    invoke-static {v1, v0, v2, v3}, Lcom/poshmark/utils/ViewUtils;->addEmptyView(Landroid/content/Context;Landroid/view/ViewGroup;IZ)V

    .line 138
    return-void
.end method

.method public setListData(Lcom/poshmark/data_model/models/PMData;)V
    .locals 0
    .param p1, "data"    # Lcom/poshmark/data_model/models/PMData;

    .prologue
    .line 62
    iput-object p1, p0, Lcom/poshmark/ui/customviews/PMListView;->listData:Lcom/poshmark/data_model/models/PMData;

    .line 63
    return-void
.end method

.method public setup(Landroid/widget/CursorAdapter;Landroid/view/View;Landroid/view/View;Lcom/poshmark/ui/customviews/PMListView$LoadMoreItemsListener;)V
    .locals 2
    .param p1, "adapter"    # Landroid/widget/CursorAdapter;
    .param p2, "headerView"    # Landroid/view/View;
    .param p3, "footerView"    # Landroid/view/View;
    .param p4, "loadMoreItemsListener"    # Lcom/poshmark/ui/customviews/PMListView$LoadMoreItemsListener;

    .prologue
    .line 46
    iput-object p1, p0, Lcom/poshmark/ui/customviews/PMListView;->adapter:Landroid/widget/CursorAdapter;

    .line 47
    iput-object p4, p0, Lcom/poshmark/ui/customviews/PMListView;->loadMoreItemsListener:Lcom/poshmark/ui/customviews/PMListView$LoadMoreItemsListener;

    .line 49
    if-eqz p2, :cond_0

    .line 50
    invoke-super {p0, p2}, Landroid/widget/ListView;->addHeaderView(Landroid/view/View;)V

    .line 53
    :cond_0
    if-eqz p3, :cond_1

    .line 54
    const v1, 0x7f0c012d

    invoke-virtual {p3, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    .line 55
    .local v0, "footerLayout":Landroid/widget/LinearLayout;
    invoke-virtual {v0, p3}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 58
    .end local v0    # "footerLayout":Landroid/widget/LinearLayout;
    :cond_1
    invoke-virtual {p0, p1}, Lcom/poshmark/ui/customviews/PMListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 59
    return-void
.end method

.method public showDefaultEmptyContentView()V
    .locals 4

    .prologue
    .line 118
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMListView;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    .line 119
    .local v0, "inflater":Landroid/view/LayoutInflater;
    const v1, 0x7f030090

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/ui/customviews/PMListView;->emptyContentView:Landroid/view/View;

    .line 120
    iget-object v1, p0, Lcom/poshmark/ui/customviews/PMListView;->emptyContentView:Landroid/view/View;

    invoke-super {p0, v1}, Landroid/widget/ListView;->addHeaderView(Landroid/view/View;)V

    .line 121
    return-void
.end method

.method public showEmptyContentView(Landroid/view/View;)V
    .locals 0
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 124
    iput-object p1, p0, Lcom/poshmark/ui/customviews/PMListView;->emptyContentView:Landroid/view/View;

    .line 125
    invoke-super {p0, p1}, Landroid/widget/ListView;->addHeaderView(Landroid/view/View;)V

    .line 126
    return-void
.end method

.method public updateList()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 108
    iget-object v1, p0, Lcom/poshmark/ui/customviews/PMListView;->listData:Lcom/poshmark/data_model/models/PMData;

    if-eqz v1, :cond_0

    .line 109
    new-instance v0, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/String;

    sget-object v2, Lcom/poshmark/data_model/models/PMData;->ID_COL:Ljava/lang/String;

    aput-object v2, v1, v4

    const/4 v2, 0x1

    sget-object v3, Lcom/poshmark/data_model/models/PMData;->DATA_COL:Ljava/lang/String;

    aput-object v3, v1, v2

    invoke-direct {v0, v1}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;-><init>([Ljava/lang/String;)V

    .line 110
    .local v0, "cursor":Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;
    iget-object v1, p0, Lcom/poshmark/ui/customviews/PMListView;->listData:Lcom/poshmark/data_model/models/PMData;

    invoke-virtual {v1, v0}, Lcom/poshmark/data_model/models/PMData;->fillCursor(Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;)V

    .line 111
    iget-object v1, p0, Lcom/poshmark/ui/customviews/PMListView;->adapter:Landroid/widget/CursorAdapter;

    invoke-virtual {v1, v0}, Landroid/widget/CursorAdapter;->changeCursor(Landroid/database/Cursor;)V

    .line 112
    iget-object v1, p0, Lcom/poshmark/ui/customviews/PMListView;->adapter:Landroid/widget/CursorAdapter;

    invoke-virtual {v1}, Landroid/widget/CursorAdapter;->notifyDataSetChanged()V

    .line 113
    iput-boolean v4, p0, Lcom/poshmark/ui/customviews/PMListView;->fetchingMoreItemsOnScroll:Z

    .line 115
    .end local v0    # "cursor":Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;
    :cond_0
    return-void
.end method
