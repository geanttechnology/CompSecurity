.class public Lcom/amazon/mShop/recommendations/RecommendationsResultsView;
.super Landroid/widget/LinearLayout;
.source "RecommendationsResultsView.java"

# interfaces
.implements Lcom/amazon/mShop/TitleProvider;
.implements Lcom/amazon/mShop/control/ObjectSubscriber;
.implements Lcom/amazon/mShop/control/recommendations/RecommendationsRatingSubscriber;
.implements Lcom/amazon/mShop/control/recommendations/RecommendationsSubscriber;
.implements Lcom/amazon/mShop/control/search/QueryProvider;
.implements Lcom/amazon/mShop/ui/BottomToolBar$ToolBarParent;


# instance fields
.field private mActivity:Lcom/amazon/mShop/AmazonActivity;

.field private mAdapter:Lcom/amazon/mShop/recommendations/RecommendationsAdapter;

.field private mBottomToolBar:Lcom/amazon/mShop/ui/BottomToolBar;

.field protected final mBrowser:Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;

.field protected mCategoryResult:Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;

.field private mChangeDepartment:Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;

.field private final mFooter:Landroid/view/View;

.field protected mListView:Landroid/widget/ListView;

.field protected mNoRecommendation:Landroid/widget/TextView;

.field private final mProgress:Landroid/widget/ProgressBar;

.field protected final mRefineAdapter:Lcom/amazon/mShop/recommendations/RecommendationsDepartmentAdapter;

.field private final mStatus:Landroid/widget/TextView;

.field private mWaitingForRecsRatingResponse:Z


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/AmazonActivity;Ljava/lang/String;Ljava/lang/String;)V
    .locals 6
    .param p1, "activity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p2, "browseNode"    # Ljava/lang/String;
    .param p3, "categoryName"    # Ljava/lang/String;

    .prologue
    const/4 v5, 0x0

    const/16 v1, 0x8

    const/4 v4, 0x0

    .line 89
    invoke-direct {p0, p1}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 90
    iput-object p1, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    .line 92
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    sget v2, Lcom/amazon/mShop/android/lib/R$layout;->recs_results_view:I

    invoke-static {v0, v2, p0}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    .line 93
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->items_list:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    iput-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mListView:Landroid/widget/ListView;

    .line 95
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mListView:Landroid/widget/ListView;

    invoke-virtual {v0, v4}, Landroid/widget/ListView;->setHeaderDividersEnabled(Z)V

    .line 96
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mListView:Landroid/widget/ListView;

    invoke-virtual {v0, v4}, Landroid/widget/ListView;->setFooterDividersEnabled(Z)V

    .line 98
    sget v0, Lcom/amazon/mShop/android/lib/R$layout;->search_results_footer:I

    invoke-static {p1, v0, v5}, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mFooter:Landroid/view/View;

    .line 99
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mFooter:Landroid/view/View;

    sget v2, Lcom/amazon/mShop/android/lib/R$id;->search_results_progress:I

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ProgressBar;

    iput-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mProgress:Landroid/widget/ProgressBar;

    .line 100
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mFooter:Landroid/view/View;

    sget v2, Lcom/amazon/mShop/android/lib/R$id;->search_results_status:I

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mStatus:Landroid/widget/TextView;

    .line 102
    invoke-static {p2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 103
    new-instance v0, Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;

    invoke-direct {v0}, Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mCategoryResult:Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;

    .line 104
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mCategoryResult:Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;

    invoke-virtual {v0, p2}, Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;->setCategory(Ljava/lang/String;)V

    .line 105
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mCategoryResult:Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;

    invoke-virtual {v0, p3}, Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;->setDisplayName(Ljava/lang/String;)V

    .line 108
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mListView:Landroid/widget/ListView;

    iget-object v2, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mFooter:Landroid/view/View;

    invoke-virtual {v0, v2, v5, v4}, Landroid/widget/ListView;->addFooterView(Landroid/view/View;Ljava/lang/Object;Z)V

    .line 110
    new-instance v0, Lcom/amazon/mShop/recommendations/RecommendationsAdapter;

    invoke-direct {v0, p1, p0}, Lcom/amazon/mShop/recommendations/RecommendationsAdapter;-><init>(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/recommendations/RecommendationsResultsView;)V

    iput-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mAdapter:Lcom/amazon/mShop/recommendations/RecommendationsAdapter;

    .line 111
    invoke-virtual {p0}, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v2, Lcom/amazon/mShop/android/lib/R$dimen;->item_row_height:I

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    invoke-virtual {p0}, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v4, Lcom/amazon/mShop/android/lib/R$dimen;->padding:I

    invoke-virtual {v2, v4}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v2

    sub-int v3, v0, v2

    .line 114
    .local v3, "dimension":I
    new-instance v0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;

    const/4 v2, 0x3

    move-object v4, p0

    move-object v5, p2

    invoke-direct/range {v0 .. v5}, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;-><init>(IIILcom/amazon/mShop/control/search/QueryProvider;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mBrowser:Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;

    .line 115
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mAdapter:Lcom/amazon/mShop/recommendations/RecommendationsAdapter;

    iget-object v2, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mBrowser:Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;

    invoke-virtual {v0, v2}, Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->setBrowser(Lcom/amazon/mShop/control/PagedListingBrowser;)V

    .line 117
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mBrowser:Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;

    invoke-virtual {v0, p0}, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->setSecondarySubscriber(Lcom/amazon/mShop/control/ObjectSubscriber;)V

    .line 118
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mBrowser:Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;

    invoke-virtual {v0, p0}, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->setRecSubscriber(Lcom/amazon/mShop/control/recommendations/RecommendationsSubscriber;)V

    .line 120
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mListView:Landroid/widget/ListView;

    const/4 v2, 0x1

    invoke-virtual {v0, v2}, Landroid/widget/ListView;->setItemsCanFocus(Z)V

    .line 122
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->no_recommendation:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mNoRecommendation:Landroid/widget/TextView;

    .line 123
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mNoRecommendation:Landroid/widget/TextView;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 125
    new-instance v0, Lcom/amazon/mShop/recommendations/RecommendationsDepartmentAdapter;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/recommendations/RecommendationsDepartmentAdapter;-><init>(Lcom/amazon/mShop/recommendations/RecommendationsResultsView;)V

    iput-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mRefineAdapter:Lcom/amazon/mShop/recommendations/RecommendationsDepartmentAdapter;

    .line 126
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mAdapter:Lcom/amazon/mShop/recommendations/RecommendationsAdapter;

    iget-object v1, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mListView:Landroid/widget/ListView;

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->setListView(Landroid/widget/ListView;)V

    .line 128
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->bottom_tool_bar:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/ui/BottomToolBar;

    iput-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mBottomToolBar:Lcom/amazon/mShop/ui/BottomToolBar;

    .line 129
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mBottomToolBar:Lcom/amazon/mShop/ui/BottomToolBar;

    invoke-virtual {v0, p0}, Lcom/amazon/mShop/ui/BottomToolBar;->setToolBarParent(Lcom/amazon/mShop/ui/BottomToolBar$ToolBarParent;)V

    .line 130
    invoke-direct {p0}, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->initToolBar()V

    .line 131
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/recommendations/RecommendationsResultsView;)Landroid/widget/ProgressBar;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/recommendations/RecommendationsResultsView;

    .prologue
    .line 36
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mProgress:Landroid/widget/ProgressBar;

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/mShop/recommendations/RecommendationsResultsView;)Landroid/widget/TextView;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/recommendations/RecommendationsResultsView;

    .prologue
    .line 36
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mStatus:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/mShop/recommendations/RecommendationsResultsView;)Lcom/amazon/mShop/AmazonActivity;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/recommendations/RecommendationsResultsView;

    .prologue
    .line 36
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    return-object v0
.end method

.method static synthetic access$300(Lcom/amazon/mShop/recommendations/RecommendationsResultsView;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/recommendations/RecommendationsResultsView;

    .prologue
    .line 36
    invoke-direct {p0}, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->refresh()V

    return-void
.end method

.method private initToolBar()V
    .locals 5

    .prologue
    .line 430
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 433
    .local v0, "toolBarItemsList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;>;"
    new-instance v1, Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;

    sget v2, Lcom/amazon/mShop/android/lib/R$id;->refine_recs:I

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->search_refine_by_category:I

    const/4 v4, 0x0

    invoke-direct {v1, v2, v3, v4}, Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;-><init>(IIZ)V

    iput-object v1, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mChangeDepartment:Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;

    .line 434
    iget-object v1, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mChangeDepartment:Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 435
    iget-object v1, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mBottomToolBar:Lcom/amazon/mShop/ui/BottomToolBar;

    invoke-virtual {v1, v0}, Lcom/amazon/mShop/ui/BottomToolBar;->init(Ljava/util/List;)V

    .line 436
    return-void
.end method

.method private refresh()V
    .locals 3

    .prologue
    .line 361
    invoke-virtual {p0}, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->resetViewStatus()V

    .line 362
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mCategoryResult:Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;

    if-eqz v0, :cond_0

    .line 363
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mCategoryResult:Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->refine(Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;)V

    .line 367
    :goto_0
    return-void

    .line 365
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mBrowser:Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;

    const v1, 0x7fffffff

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->startFirstPageRequest(ILjava/util/List;)Z

    goto :goto_0
.end method


# virtual methods
.method public dispatchKeyEvent(Landroid/view/KeyEvent;)Z
    .locals 4
    .param p1, "event"    # Landroid/view/KeyEvent;

    .prologue
    const/4 v2, 0x1

    .line 374
    iget-object v1, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v1, p1}, Lcom/amazon/mShop/AmazonActivity;->menuDispatchedKeyEvent(Landroid/view/KeyEvent;)Z

    move-result v1

    if-eqz v1, :cond_0

    move v1, v2

    .line 404
    :goto_0
    return v1

    .line 378
    :cond_0
    const/4 v1, 0x4

    invoke-virtual {p1}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v3

    if-ne v1, v3, :cond_1

    invoke-virtual {p1}, Landroid/view/KeyEvent;->getAction()I

    move-result v1

    if-nez v1, :cond_1

    .line 396
    iget-object v1, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    check-cast v1, Lcom/amazon/mShop/recommendations/RecommendationsActivity;

    invoke-virtual {v1}, Lcom/amazon/mShop/recommendations/RecommendationsActivity;->needShowErrorInfo()Z

    move-result v1

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v1}, Lcom/amazon/mShop/AmazonActivity;->isErrorBoxShowing()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 398
    iget-object v1, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    check-cast v1, Lcom/amazon/mShop/recommendations/RecommendationsActivity;

    invoke-virtual {v1}, Lcom/amazon/mShop/recommendations/RecommendationsActivity;->constructUserUniqueInfo()Ljava/lang/String;

    move-result-object v0

    .line 399
    .local v0, "userKey":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/control/recommendations/RecommendationsController;->getInstance()Lcom/amazon/mShop/control/recommendations/RecommendationsController;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/amazon/mShop/control/recommendations/RecommendationsController;->eraseRatingRequestErrorInfo(Ljava/lang/String;)V

    .line 400
    iget-object v1, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v1}, Lcom/amazon/mShop/AmazonActivity;->finish()V

    move v1, v2

    .line 401
    goto :goto_0

    .line 404
    .end local v0    # "userKey":Ljava/lang/String;
    :cond_1
    invoke-super {p0, p1}, Landroid/widget/LinearLayout;->dispatchKeyEvent(Landroid/view/KeyEvent;)Z

    move-result v1

    goto :goto_0
.end method

.method public getBrowser()Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;
    .locals 1

    .prologue
    .line 160
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mBrowser:Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;

    return-object v0
.end method

.method public getCategoryResult()Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;
    .locals 1

    .prologue
    .line 212
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mCategoryResult:Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;

    return-object v0
.end method

.method public getQuery()Ljava/lang/String;
    .locals 1

    .prologue
    .line 207
    const/4 v0, 0x0

    return-object v0
.end method

.method public bridge synthetic getTitle()Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 36
    invoke-virtual {p0}, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->getTitle()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 3

    .prologue
    .line 168
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mCategoryResult:Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mCategoryResult:Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;->getDisplayName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 169
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->getContext()Landroid/content/Context;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->recommendations_title:I

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, " - "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mCategoryResult:Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;->getDisplayName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 172
    :goto_0
    return-object v0

    :cond_0
    invoke-virtual {p0}, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->getContext()Landroid/content/Context;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->recommendations_title:I

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method protected onAttachedToWindow()V
    .locals 3

    .prologue
    .line 177
    invoke-super {p0}, Landroid/widget/LinearLayout;->onAttachedToWindow()V

    .line 178
    invoke-static {}, Lcom/amazon/mShop/control/recommendations/RecommendationsController;->getInstance()Lcom/amazon/mShop/control/recommendations/RecommendationsController;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/amazon/mShop/control/recommendations/RecommendationsController;->addSubscriber(Lcom/amazon/mShop/control/recommendations/RecommendationsRatingSubscriber;)V

    .line 179
    invoke-static {}, Lcom/amazon/mShop/control/recommendations/RecommendationsController;->getInstance()Lcom/amazon/mShop/control/recommendations/RecommendationsController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/control/recommendations/RecommendationsController;->recsItemsRequestShouldWait()Z

    move-result v0

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->setWaitingForRecsRatingResponse(Z)V

    .line 180
    iget-boolean v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mWaitingForRecsRatingResponse:Z

    if-nez v0, :cond_0

    .line 181
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    check-cast v0, Lcom/amazon/mShop/recommendations/RecommendationsActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/recommendations/RecommendationsActivity;->needShowErrorInfo()Z

    move-result v0

    if-nez v0, :cond_0

    .line 182
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mBrowser:Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;

    const v1, 0x7fffffff

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->startFirstPageRequest(ILjava/util/List;)Z

    .line 185
    :cond_0
    return-void
.end method

.method public onAvailableCountReceived(I)V
    .locals 0
    .param p1, "availableCount"    # I

    .prologue
    .line 238
    return-void
.end method

.method public onCancelled()V
    .locals 0

    .prologue
    .line 253
    return-void
.end method

.method protected onDetachedFromWindow()V
    .locals 2

    .prologue
    .line 190
    invoke-super {p0}, Landroid/widget/LinearLayout;->onDetachedFromWindow()V

    .line 191
    invoke-static {}, Lcom/amazon/mShop/control/recommendations/RecommendationsController;->getInstance()Lcom/amazon/mShop/control/recommendations/RecommendationsController;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/amazon/mShop/control/recommendations/RecommendationsController;->removeSubscriber(Lcom/amazon/mShop/control/recommendations/RecommendationsRatingSubscriber;)V

    .line 195
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mProgress:Landroid/widget/ProgressBar;

    if-eqz v0, :cond_0

    .line 196
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mProgress:Landroid/widget/ProgressBar;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 199
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mAdapter:Lcom/amazon/mShop/recommendations/RecommendationsAdapter;

    invoke-virtual {v0}, Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->dismissDialog()V

    .line 200
    return-void
.end method

.method public onError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 3
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 220
    const-string/jumbo v1, "AmazonActivity"

    invoke-virtual {p1}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 222
    new-instance v0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView$1;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/recommendations/RecommendationsResultsView$1;-><init>(Lcom/amazon/mShop/recommendations/RecommendationsResultsView;)V

    .line 232
    .local v0, "errorHandler":Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;
    iget-object v1, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-static {v1, v0, p0, p1}, Lcom/amazon/mShop/util/AmazonErrorUtils;->reportMShopServerError(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;Landroid/view/View;Ljava/lang/Exception;)V

    .line 233
    return-void
.end method

.method public onObjectReceived(Ljava/lang/Object;I)V
    .locals 0
    .param p1, "o"    # Ljava/lang/Object;
    .param p2, "index"    # I

    .prologue
    .line 243
    return-void
.end method

.method public onObjectsReceived()V
    .locals 0

    .prologue
    .line 248
    return-void
.end method

.method public onPageComplete()V
    .locals 9

    .prologue
    const/4 v8, 0x1

    const/16 v4, 0x8

    const/4 v7, 0x0

    .line 258
    iget-object v2, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mBrowser:Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;

    invoke-virtual {v2}, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->getReceivedCount()I

    move-result v2

    iget-object v3, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mBrowser:Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;

    invoke-virtual {v3}, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->getRatingPendingIndexSet()Ljava/util/Set;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Set;->size()I

    move-result v3

    add-int v0, v2, v3

    .line 259
    .local v0, "receivedCount":I
    iget-object v2, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mBrowser:Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;

    invoke-virtual {v2}, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->getAvailableCount()I

    move-result v2

    if-nez v2, :cond_1

    if-nez v0, :cond_1

    .line 261
    iget-object v2, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mProgress:Landroid/widget/ProgressBar;

    invoke-virtual {v2, v4}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 262
    iget-object v2, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mStatus:Landroid/widget/TextView;

    invoke-virtual {v2, v7}, Landroid/widget/TextView;->setVisibility(I)V

    .line 284
    :goto_0
    iget-object v2, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mBrowser:Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;

    invoke-virtual {v2}, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->hasCategoryResult()Z

    move-result v2

    if-nez v2, :cond_0

    .line 286
    iget-object v2, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mBrowser:Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;

    invoke-virtual {v2}, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->getRefinements()Ljava/util/List;

    move-result-object v1

    .line 287
    .local v1, "refinements":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;>;"
    if-eqz v1, :cond_0

    invoke-interface {v1}, Ljava/util/List;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_0

    .line 289
    iget-object v2, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mRefineAdapter:Lcom/amazon/mShop/recommendations/RecommendationsDepartmentAdapter;

    invoke-virtual {v2, v1}, Lcom/amazon/mShop/recommendations/RecommendationsDepartmentAdapter;->update(Ljava/util/List;)V

    .line 290
    iget-object v2, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mBottomToolBar:Lcom/amazon/mShop/ui/BottomToolBar;

    iget-object v3, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mChangeDepartment:Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;

    invoke-virtual {v2, v3, v8}, Lcom/amazon/mShop/ui/BottomToolBar;->setToolBarItemEnabled(Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;Z)V

    .line 294
    .end local v1    # "refinements":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;>;"
    :cond_0
    return-void

    .line 263
    :cond_1
    iget-object v2, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mBrowser:Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;

    invoke-virtual {v2}, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->getAvailableCount()I

    move-result v2

    if-gt v2, v0, :cond_4

    .line 265
    iget-object v2, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mProgress:Landroid/widget/ProgressBar;

    invoke-virtual {v2, v4}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 266
    iget-object v2, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mBrowser:Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;

    invoke-virtual {v2}, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->hasCategoryResult()Z

    move-result v2

    if-nez v2, :cond_2

    .line 267
    iget-object v2, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mStatus:Landroid/widget/TextView;

    invoke-virtual {v2, v7}, Landroid/widget/TextView;->setVisibility(I)V

    .line 268
    iget-object v2, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mStatus:Landroid/widget/TextView;

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->search_for_more_results:I

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(I)V

    goto :goto_0

    .line 270
    :cond_2
    iget-object v2, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mCategoryResult:Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;

    if-eqz v2, :cond_3

    iget-object v2, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mCategoryResult:Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;

    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;->getDisplayName()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_3

    .line 271
    iget-object v2, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mStatus:Landroid/widget/TextView;

    invoke-virtual {v2, v7}, Landroid/widget/TextView;->setVisibility(I)V

    .line 272
    iget-object v2, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mStatus:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->search_end_of_x_top_results_for_y:I

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/Object;

    iget-object v6, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mBrowser:Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;

    invoke-virtual {v6}, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->getReceivedCount()I

    move-result v6

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v5, v7

    iget-object v6, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mCategoryResult:Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;

    invoke-virtual {v6}, Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;->getDisplayName()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v5, v8

    invoke-virtual {v3, v4, v5}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 275
    :cond_3
    iget-object v2, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mStatus:Landroid/widget/TextView;

    invoke-virtual {v2, v4}, Landroid/widget/TextView;->setVisibility(I)V

    goto/16 :goto_0

    .line 279
    :cond_4
    iget-object v2, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mProgress:Landroid/widget/ProgressBar;

    invoke-virtual {v2, v7}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 280
    iget-object v2, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mStatus:Landroid/widget/TextView;

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->loading:I

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(I)V

    goto/16 :goto_0
.end method

.method public onReceivedNoRecommendationsExplanation(Ljava/lang/String;)V
    .locals 2
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    .line 412
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mNoRecommendation:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 413
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mNoRecommendation:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 414
    return-void
.end method

.method public onRecsRatingCallCancelled()V
    .locals 1

    .prologue
    .line 342
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->setWaitingForRecsRatingResponse(Z)V

    .line 343
    return-void
.end method

.method public onRecsRatingCallCompleted()V
    .locals 3

    .prologue
    .line 325
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->setWaitingForRecsRatingResponse(Z)V

    .line 326
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mCategoryResult:Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;

    if-eqz v0, :cond_0

    .line 327
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mCategoryResult:Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->refine(Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;)V

    .line 331
    :goto_0
    return-void

    .line 329
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mBrowser:Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;

    const v1, 0x7fffffff

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->startFirstPageRequest(ILjava/util/List;)Z

    goto :goto_0
.end method

.method public onRecsRatingCallError()V
    .locals 1

    .prologue
    .line 335
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->setWaitingForRecsRatingResponse(Z)V

    .line 336
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonActivity;->getCurrentView()Landroid/view/View;

    move-result-object v0

    instance-of v0, v0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;

    if-eqz v0, :cond_0

    .line 337
    invoke-virtual {p0}, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->showErrorDialog()V

    .line 338
    :cond_0
    return-void
.end method

.method public onRecsRatingCallStarted()V
    .locals 1

    .prologue
    .line 302
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->setWaitingForRecsRatingResponse(Z)V

    .line 303
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mBrowser:Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;

    invoke-virtual {v0}, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->cancel()Z

    .line 304
    invoke-virtual {p0}, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->resetViewStatus()V

    .line 305
    return-void
.end method

.method public onToolBarItemSelected(Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;)V
    .locals 7
    .param p1, "toolBarItem"    # Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;

    .prologue
    .line 419
    invoke-virtual {p1}, Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;->getItemId()I

    move-result v0

    sget v2, Lcom/amazon/mShop/android/lib/R$id;->refine_recs:I

    if-ne v0, v2, :cond_0

    .line 420
    new-instance v6, Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-direct {v6, v0}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 421
    .local v6, "builder":Lcom/amazon/mShop/AmazonAlertDialog$Builder;
    invoke-virtual {v6}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->create()Lcom/amazon/mShop/AmazonAlertDialog;

    move-result-object v1

    .line 422
    .local v1, "dialog":Lcom/amazon/mShop/AmazonAlertDialog;
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mRefineAdapter:Lcom/amazon/mShop/recommendations/RecommendationsDepartmentAdapter;

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/recommendations/RecommendationsDepartmentAdapter;->bindAmazonAlertDialog(Lcom/amazon/mShop/AmazonAlertDialog;)V

    .line 423
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {p0}, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->search_refine_by_category:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mRefineAdapter:Lcom/amazon/mShop/recommendations/RecommendationsDepartmentAdapter;

    iget-object v4, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mRefineAdapter:Lcom/amazon/mShop/recommendations/RecommendationsDepartmentAdapter;

    iget-object v5, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mRefineAdapter:Lcom/amazon/mShop/recommendations/RecommendationsDepartmentAdapter;

    invoke-virtual {v5}, Lcom/amazon/mShop/recommendations/RecommendationsDepartmentAdapter;->getSelectedPosition()I

    move-result v5

    invoke-static/range {v0 .. v5}, Lcom/amazon/mShop/AmazonAlertDialog;->customizeAlertDialog(Landroid/content/Context;Lcom/amazon/mShop/AmazonAlertDialog;Ljava/lang/String;Landroid/widget/ListAdapter;Landroid/widget/AdapterView$OnItemClickListener;I)V

    .line 425
    invoke-virtual {v1}, Lcom/amazon/mShop/AmazonAlertDialog;->show()V

    .line 427
    .end local v1    # "dialog":Lcom/amazon/mShop/AmazonAlertDialog;
    .end local v6    # "builder":Lcom/amazon/mShop/AmazonAlertDialog$Builder;
    :cond_0
    return-void
.end method

.method public refine(Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;)V
    .locals 3
    .param p1, "categoryResult"    # Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;

    .prologue
    const/4 v2, 0x0

    .line 140
    iput-object p1, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mCategoryResult:Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;

    .line 141
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mNoRecommendation:Landroid/widget/TextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 143
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v0, p0}, Lcom/amazon/mShop/AmazonActivity;->updateTitle(Landroid/view/View;)V

    .line 145
    iget-boolean v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mWaitingForRecsRatingResponse:Z

    if-nez v0, :cond_1

    .line 147
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;->getCategory()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_0

    .line 148
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mCategoryResult:Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;

    .line 150
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mProgress:Landroid/widget/ProgressBar;

    invoke-virtual {v0, v2}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 151
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mStatus:Landroid/widget/TextView;

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->loading:I

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 152
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mStatus:Landroid/widget/TextView;

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 154
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mBrowser:Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;

    iget-object v1, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mCategoryResult:Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->refine(Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;)Z

    .line 155
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mAdapter:Lcom/amazon/mShop/recommendations/RecommendationsAdapter;

    invoke-virtual {v0}, Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->notifyDataSetChanged()V

    .line 157
    :cond_1
    return-void
.end method

.method public resetViewStatus()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 311
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mBrowser:Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;

    invoke-virtual {v0}, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->clearRatingPendingIndexSet()V

    .line 312
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mBrowser:Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;

    invoke-virtual {v0}, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->clearAllList()V

    .line 313
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mAdapter:Lcom/amazon/mShop/recommendations/RecommendationsAdapter;

    invoke-virtual {v0}, Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->notifyDataSetChanged()V

    .line 314
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mNoRecommendation:Landroid/widget/TextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 315
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mProgress:Landroid/widget/ProgressBar;

    invoke-virtual {v0, v2}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 316
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mStatus:Landroid/widget/TextView;

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->loading:I

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 317
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mStatus:Landroid/widget/TextView;

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 318
    return-void
.end method

.method public setWaitingForRecsRatingResponse(Z)V
    .locals 0
    .param p1, "waitingForRecsRatingResponse"    # Z

    .prologue
    .line 85
    iput-boolean p1, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mWaitingForRecsRatingResponse:Z

    .line 86
    return-void
.end method

.method public showErrorDialog()V
    .locals 6

    .prologue
    .line 346
    invoke-static {}, Lcom/amazon/mShop/net/NetInfo;->hasNetworkConnection()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v1, 0x4

    .line 348
    .local v1, "errorCode":I
    :goto_0
    new-instance v2, Lcom/amazon/mShop/recommendations/RecommendationsResultsView$2;

    invoke-direct {v2, p0}, Lcom/amazon/mShop/recommendations/RecommendationsResultsView$2;-><init>(Lcom/amazon/mShop/recommendations/RecommendationsResultsView;)V

    .line 357
    .local v2, "errorHandler":Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->recommendations_alert_info:I

    sget v5, Lcom/amazon/mShop/android/lib/R$string;->recommendations_ok:I

    move-object v3, p0

    invoke-static/range {v0 .. v5}, Lcom/amazon/mShop/util/AmazonErrorUtils;->reportError(Lcom/amazon/mShop/AmazonActivity;ILcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;Landroid/view/View;II)V

    .line 358
    return-void

    .line 346
    .end local v1    # "errorCode":I
    .end local v2    # "errorHandler":Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;
    :cond_0
    const/4 v1, 0x1

    goto :goto_0
.end method
