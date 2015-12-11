.class public Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;
.super Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;
.source "ViewItSlidingDrawerView.java"

# interfaces
.implements Lcom/amazon/mShop/TitleProvider;
.implements Lcom/amazon/mShop/ui/BottomToolBar$ToolBarParent;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;
    }
.end annotation


# instance fields
.field private mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

.field private mAdapter:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;

.field private mBottomToolBar:Lcom/amazon/mShop/ui/BottomToolBar;

.field private mBrowser:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

.field private mDeleteAllButton:Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;

.field private mEmptyBottonOffset:I

.field private mHandle:Landroid/view/View;

.field private mHeaderContent:Landroid/view/View;

.field private mListView:Lcom/amazon/mShop/search/viewit/ViewItHistoryListView;

.field private mProgress:Landroid/widget/ProgressBar;

.field private mProgressSpinnerMinimumHeight:I

.field private mStatus:Landroid/widget/TextView;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 88
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 89
    check-cast p1, Lcom/amazon/mShop/search/viewit/ViewItActivity;

    .end local p1    # "context":Landroid/content/Context;
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    .line 90
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$dimen;->view_it_vertical_bottom_empty_offset:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    neg-int v0, v0

    iput v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mEmptyBottonOffset:I

    .line 91
    iget v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mEmptyBottonOffset:I

    iput v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mProgressSpinnerMinimumHeight:I

    .line 92
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;)Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    .prologue
    .line 37
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mBrowser:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    .prologue
    .line 37
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->hideProgressBar()V

    return-void
.end method

.method static synthetic access$200(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    .prologue
    .line 37
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mHeaderContent:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$300(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;)Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    .prologue
    .line 37
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mDeleteAllButton:Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;

    return-object v0
.end method

.method static synthetic access$400(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;)Lcom/amazon/mShop/ui/BottomToolBar;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    .prologue
    .line 37
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mBottomToolBar:Lcom/amazon/mShop/ui/BottomToolBar;

    return-object v0
.end method

.method static synthetic access$500(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;)Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    .prologue
    .line 37
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mAdapter:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;

    return-object v0
.end method

.method static synthetic access$600(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    .prologue
    .line 37
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->updateHeaderVisibilityAndBottomOffset()V

    return-void
.end method

.method static synthetic access$700(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;)Lcom/amazon/mShop/search/viewit/ViewItActivity;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    .prologue
    .line 37
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    return-object v0
.end method

.method static synthetic access$800(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    .prologue
    .line 37
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->showProgressBar()V

    return-void
.end method

.method private hideProgressBar()V
    .locals 2

    .prologue
    const/16 v1, 0x8

    .line 262
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mProgress:Landroid/widget/ProgressBar;

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 263
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mStatus:Landroid/widget/TextView;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 264
    return-void
.end method

.method private showProgressBar()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 255
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mHeaderContent:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 256
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mProgress:Landroid/widget/ProgressBar;

    invoke-virtual {v0, v2}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 257
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mStatus:Landroid/widget/TextView;

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->loading:I

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 258
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mStatus:Landroid/widget/TextView;

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 259
    return-void
.end method

.method private startBottomToolBarTransitionAnimation(Landroid/view/View;Z)V
    .locals 9
    .param p1, "view"    # Landroid/view/View;
    .param p2, "tansitionUp"    # Z

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x1

    .line 221
    const/4 v6, 0x0

    .line 222
    .local v6, "fromYValue":F
    const/4 v8, 0x0

    .line 223
    .local v8, "toYValue":F
    if-eqz p2, :cond_0

    .line 224
    const/high16 v6, 0x3f800000    # 1.0f

    .line 229
    :goto_0
    new-instance v0, Landroid/view/animation/TranslateAnimation;

    move v3, v1

    move v4, v2

    move v5, v1

    move v7, v1

    invoke-direct/range {v0 .. v8}, Landroid/view/animation/TranslateAnimation;-><init>(IFIFIFIF)V

    .line 233
    .local v0, "animation":Landroid/view/animation/Animation;
    const-wide/16 v1, 0x12c

    invoke-virtual {v0, v1, v2}, Landroid/view/animation/Animation;->setDuration(J)V

    .line 234
    new-instance v1, Landroid/view/animation/LinearInterpolator;

    invoke-direct {v1}, Landroid/view/animation/LinearInterpolator;-><init>()V

    invoke-virtual {v0, v1}, Landroid/view/animation/Animation;->setInterpolator(Landroid/view/animation/Interpolator;)V

    .line 235
    invoke-virtual {p1, v0}, Landroid/view/View;->startAnimation(Landroid/view/animation/Animation;)V

    .line 236
    return-void

    .line 226
    .end local v0    # "animation":Landroid/view/animation/Animation;
    :cond_0
    const/high16 v8, 0x3f800000    # 1.0f

    goto :goto_0
.end method

.method private updateHeaderVisibilityAndBottomOffset()V
    .locals 2

    .prologue
    .line 340
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mBrowser:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->getObjectsCount()I

    move-result v0

    if-nez v0, :cond_0

    .line 341
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->setListViewHeaderVisibility(I)V

    .line 342
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$dimen;->view_it_vertical_bottom_empty_offset:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->updateBottomOffset(I)V

    .line 344
    :cond_0
    return-void
.end method


# virtual methods
.method public getBottomOffset()I
    .locals 1

    .prologue
    .line 72
    iget v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mBottomOffset:I

    return v0
.end method

.method public getBrowser()Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;
    .locals 1

    .prologue
    .line 64
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mBrowser:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    return-object v0
.end method

.method public getListView()Landroid/widget/ListView;
    .locals 1

    .prologue
    .line 68
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mListView:Lcom/amazon/mShop/search/viewit/ViewItHistoryListView;

    return-object v0
.end method

.method public getListViewHeaderContent()Landroid/view/View;
    .locals 1

    .prologue
    .line 84
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mHeaderContent:Landroid/view/View;

    return-object v0
.end method

.method public getTitle()Ljava/lang/CharSequence;
    .locals 2

    .prologue
    .line 275
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->history_title:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getViewItSlidingDrawerItemAdapter()Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;
    .locals 1

    .prologue
    .line 60
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mAdapter:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;

    return-object v0
.end method

.method public isProgressBarDisplayed()Z
    .locals 1

    .prologue
    .line 267
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mProgress:Landroid/widget/ProgressBar;

    invoke-virtual {v0}, Landroid/widget/ProgressBar;->getVisibility()I

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected isScrolledToTop()Z
    .locals 1

    .prologue
    .line 103
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mListView:Lcom/amazon/mShop/search/viewit/ViewItHistoryListView;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItHistoryListView;->isListViewScrolledToTop()Z

    move-result v0

    return v0
.end method

.method protected onDetachedFromWindow()V
    .locals 1

    .prologue
    .line 96
    invoke-super {p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->onDetachedFromWindow()V

    .line 98
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mBrowser:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->cancel()Z

    .line 99
    return-void
.end method

.method protected onFinishInflate()V
    .locals 9

    .prologue
    const/16 v8, 0x8

    const/4 v7, 0x0

    const/4 v6, 0x0

    .line 130
    sget v3, Lcom/amazon/mShop/android/lib/R$id;->drawer_handle:I

    invoke-virtual {p0, v3}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->findViewById(I)Landroid/view/View;

    move-result-object v3

    iput-object v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mHandle:Landroid/view/View;

    .line 132
    sget v3, Lcom/amazon/mShop/android/lib/R$id;->items_list:I

    invoke-virtual {p0, v3}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Lcom/amazon/mShop/search/viewit/ViewItHistoryListView;

    iput-object v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mListView:Lcom/amazon/mShop/search/viewit/ViewItHistoryListView;

    .line 133
    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mListView:Lcom/amazon/mShop/search/viewit/ViewItHistoryListView;

    invoke-virtual {v3, p0}, Lcom/amazon/mShop/search/viewit/ViewItHistoryListView;->setSlidingDrawerView(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;)V

    .line 135
    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mListView:Lcom/amazon/mShop/search/viewit/ViewItHistoryListView;

    invoke-virtual {v3, v7}, Lcom/amazon/mShop/search/viewit/ViewItHistoryListView;->setDividerHeight(I)V

    .line 136
    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mListView:Lcom/amazon/mShop/search/viewit/ViewItHistoryListView;

    const/4 v4, 0x1

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/search/viewit/ViewItHistoryListView;->setItemsCanFocus(Z)V

    .line 138
    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    sget v4, Lcom/amazon/mShop/android/lib/R$layout;->view_it_sliding_drawer_header:I

    invoke-static {v3, v4, v6}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    .line 139
    .local v1, "header":Landroid/view/View;
    sget v3, Lcom/amazon/mShop/android/lib/R$id;->view_it_sliding_drawer_empty_indication:I

    invoke-virtual {v1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    iput-object v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mHeaderContent:Landroid/view/View;

    .line 140
    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mListView:Lcom/amazon/mShop/search/viewit/ViewItHistoryListView;

    invoke-virtual {v3, v1, v6, v7}, Lcom/amazon/mShop/search/viewit/ViewItHistoryListView;->addHeaderView(Landroid/view/View;Ljava/lang/Object;Z)V

    .line 142
    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    sget v4, Lcom/amazon/mShop/android/lib/R$layout;->view_it_item_loading_progress:I

    invoke-static {v3, v4, v6}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 143
    .local v0, "footer":Landroid/view/View;
    sget v3, Lcom/amazon/mShop/android/lib/R$id;->loading_progress:I

    invoke-virtual {v0, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/ProgressBar;

    iput-object v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mProgress:Landroid/widget/ProgressBar;

    .line 144
    sget v3, Lcom/amazon/mShop/android/lib/R$id;->loading_results_status:I

    invoke-virtual {v0, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    iput-object v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mStatus:Landroid/widget/TextView;

    .line 145
    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mListView:Lcom/amazon/mShop/search/viewit/ViewItHistoryListView;

    invoke-virtual {v3, v0, v6, v7}, Lcom/amazon/mShop/search/viewit/ViewItHistoryListView;->addFooterView(Landroid/view/View;Ljava/lang/Object;Z)V

    .line 147
    new-instance v3, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    const/4 v5, 0x3

    invoke-direct {v3, v4, v8, v5}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;-><init>(Lcom/amazon/mShop/search/viewit/ViewItActivity;II)V

    iput-object v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mBrowser:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    .line 148
    new-instance v4, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;

    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->getContext()Landroid/content/Context;

    move-result-object v3

    check-cast v3, Lcom/amazon/mShop/AmazonActivity;

    sget v5, Lcom/amazon/mShop/android/lib/R$layout;->view_it_item_row:I

    invoke-direct {v4, p0, v3, v5}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;-><init>(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;Lcom/amazon/mShop/AmazonActivity;I)V

    iput-object v4, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mAdapter:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;

    .line 149
    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mAdapter:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;

    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mBrowser:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;->setBrowser(Lcom/amazon/mShop/control/PagedListingBrowser;)V

    .line 150
    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mAdapter:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;

    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mListView:Lcom/amazon/mShop/search/viewit/ViewItHistoryListView;

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;->setListView(Landroid/widget/ListView;)V

    .line 153
    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mListView:Lcom/amazon/mShop/search/viewit/ViewItHistoryListView;

    invoke-virtual {v3, v6}, Lcom/amazon/mShop/search/viewit/ViewItHistoryListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 156
    new-instance v3, Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;

    sget v4, Lcom/amazon/mShop/android/lib/R$id;->view_it_delete_all_history:I

    sget v5, Lcom/amazon/mShop/android/lib/R$string;->view_it_history_delete_all:I

    invoke-direct {v3, v4, v5, v7}, Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;-><init>(IIZ)V

    iput-object v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mDeleteAllButton:Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;

    .line 157
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 158
    .local v2, "toolBarItemsList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;>;"
    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mDeleteAllButton:Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;

    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 159
    sget v3, Lcom/amazon/mShop/android/lib/R$id;->bottom_tool_bar:I

    invoke-virtual {p0, v3}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Lcom/amazon/mShop/ui/BottomToolBar;

    iput-object v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mBottomToolBar:Lcom/amazon/mShop/ui/BottomToolBar;

    .line 160
    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mBottomToolBar:Lcom/amazon/mShop/ui/BottomToolBar;

    invoke-virtual {v3, p0}, Lcom/amazon/mShop/ui/BottomToolBar;->setToolBarParent(Lcom/amazon/mShop/ui/BottomToolBar$ToolBarParent;)V

    .line 161
    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mBottomToolBar:Lcom/amazon/mShop/ui/BottomToolBar;

    invoke-virtual {v3, v2}, Lcom/amazon/mShop/ui/BottomToolBar;->init(Ljava/util/List;)V

    .line 162
    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mBottomToolBar:Lcom/amazon/mShop/ui/BottomToolBar;

    invoke-virtual {v3, v8}, Lcom/amazon/mShop/ui/BottomToolBar;->setVisibility(I)V

    .line 165
    invoke-super {p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->onFinishInflate()V

    .line 166
    const/high16 v3, 0x3f800000    # 1.0f

    invoke-virtual {p0, v3}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->updateHandleBackground(F)V

    .line 167
    return-void
.end method

.method public onToolBarItemSelected(Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;)V
    .locals 6
    .param p1, "toolBarItem"    # Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;

    .prologue
    .line 279
    invoke-virtual {p1}, Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;->getItemId()I

    move-result v4

    sget v5, Lcom/amazon/mShop/android/lib/R$id;->view_it_delete_all_history:I

    if-ne v4, v5, :cond_0

    .line 281
    const-string/jumbo v4, "fl_del_all"

    invoke-static {v4}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 283
    new-instance v0, Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->getContext()Landroid/content/Context;

    move-result-object v4

    invoke-direct {v0, v4}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 284
    .local v0, "builder":Lcom/amazon/mShop/AmazonAlertDialog$Builder;
    const/4 v4, 0x1

    invoke-virtual {v0, v4}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setCancelable(Z)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    .line 285
    new-instance v4, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$1;

    invoke-direct {v4, p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$1;-><init>(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;)V

    invoke-virtual {v0, v4}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    .line 292
    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->create()Lcom/amazon/mShop/AmazonAlertDialog;

    move-result-object v3

    .line 293
    .local v3, "dialog":Lcom/amazon/mShop/AmazonAlertDialog;
    invoke-virtual {v3}, Lcom/amazon/mShop/AmazonAlertDialog;->show()V

    .line 294
    invoke-virtual {v3}, Lcom/amazon/mShop/AmazonAlertDialog;->getWindow()Landroid/view/Window;

    move-result-object v4

    sget v5, Lcom/amazon/mShop/android/lib/R$layout;->view_it_delete_all_history_dialog:I

    invoke-virtual {v4, v5}, Landroid/view/Window;->setContentView(I)V

    .line 295
    sget v4, Lcom/amazon/mShop/android/lib/R$id;->delete_all_cancel:I

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/AmazonAlertDialog;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    .line 296
    .local v1, "deleteCancelButton":Landroid/widget/Button;
    new-instance v4, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$2;

    invoke-direct {v4, p0, v3}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$2;-><init>(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;Lcom/amazon/mShop/AmazonAlertDialog;)V

    invoke-virtual {v1, v4}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 303
    sget v4, Lcom/amazon/mShop/android/lib/R$id;->delete_all_ok:I

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/AmazonAlertDialog;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/Button;

    .line 304
    .local v2, "deleteOKButton":Landroid/widget/Button;
    new-instance v4, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$3;

    invoke-direct {v4, p0, v3}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$3;-><init>(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;Lcom/amazon/mShop/AmazonAlertDialog;)V

    invoke-virtual {v2, v4}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 323
    .end local v0    # "builder":Lcom/amazon/mShop/AmazonAlertDialog$Builder;
    .end local v1    # "deleteCancelButton":Landroid/widget/Button;
    .end local v2    # "deleteOKButton":Landroid/widget/Button;
    .end local v3    # "dialog":Lcom/amazon/mShop/AmazonAlertDialog;
    :cond_0
    return-void
.end method

.method protected prepareContent()V
    .locals 1

    .prologue
    .line 111
    invoke-super {p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->prepareContent()V

    .line 113
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->isOpened()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 115
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->isEngineStopped()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 116
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->startScanning()V

    .line 124
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->disableLoading()V

    .line 125
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->disableDrawing()V

    .line 126
    return-void

    .line 117
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->isEnginePaused()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 118
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->unpauseEngine()V

    goto :goto_0
.end method

.method protected refresh()V
    .locals 3

    .prologue
    .line 242
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mBrowser:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    invoke-virtual {v1}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->getViewItDBHelper()Lcom/amazon/mShop/search/viewit/ViewItDBHelper;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/search/viewit/ViewItDBHelper;->getAllHistoryItems()Ljava/util/List;

    move-result-object v0

    .line 243
    .local v0, "allAsins":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/search/viewit/ViewItDBResultWrapper;>;"
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    if-nez v1, :cond_0

    .line 244
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->hideProgressBar()V

    .line 245
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mHeaderContent:Landroid/view/View;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/view/View;->setVisibility(I)V

    .line 246
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mAdapter:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;

    invoke-virtual {v1}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;->notifyDataSetChanged()V

    .line 252
    :goto_0
    return-void

    .line 248
    :cond_0
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->showProgressBar()V

    .line 249
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mBrowser:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    invoke-virtual {v1, v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->startFirstPageRequest(Ljava/util/List;)Z

    .line 250
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mAdapter:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;

    invoke-virtual {v1}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;->notifyDataSetChanged()V

    goto :goto_0
.end method

.method public setBottomOffsetToFirstItemHeight(Lcom/amazon/mShop/search/viewit/ViewItItemView;)V
    .locals 5
    .param p1, "firstItemView"    # Lcom/amazon/mShop/search/viewit/ViewItItemView;

    .prologue
    .line 170
    iget v2, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mBottomOffset:I

    iget v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mEmptyBottonOffset:I

    if-ne v2, v3, :cond_1

    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mHeaderContent:Landroid/view/View;

    invoke-virtual {v2}, Landroid/view/View;->getVisibility()I

    move-result v2

    if-nez v2, :cond_1

    .line 195
    :cond_0
    :goto_0
    return-void

    .line 172
    :cond_1
    if-eqz p1, :cond_0

    .line 173
    invoke-virtual {p1}, Lcom/amazon/mShop/search/viewit/ViewItItemView;->getHeight()I

    move-result v1

    .line 174
    .local v1, "itemHeight":I
    invoke-virtual {p1}, Lcom/amazon/mShop/search/viewit/ViewItItemView;->getDeleteButtonHeight()I

    move-result v0

    .line 175
    .local v0, "deleteButtonHeight":I
    if-lez v0, :cond_2

    .line 177
    sub-int v2, v1, v0

    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$dimen;->view_it_item_button_padding:I

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v3

    mul-int/lit8 v3, v3, 0x2

    sub-int/2addr v2, v3

    add-int/lit8 v1, v2, -0x2

    .line 183
    :cond_2
    iget v2, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mBottomOffset:I

    neg-int v2, v2

    if-eq v1, v2, :cond_0

    .line 184
    iget v2, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mProgressSpinnerMinimumHeight:I

    if-ge v1, v2, :cond_3

    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    invoke-virtual {v2}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->getPhotoCaptureView()Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->getViewItScannedItemAnimationFrame()Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->isLoading()Z

    move-result v2

    if-eqz v2, :cond_3

    .line 185
    iget v2, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mProgressSpinnerMinimumHeight:I

    neg-int v2, v2

    invoke-virtual {p0, v2}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->updateBottomOffset(I)V

    .line 190
    :goto_1
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->isClosed()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 191
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mAdapter:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;

    invoke-virtual {v2}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;->notifyDataSetChanged()V

    goto :goto_0

    .line 187
    :cond_3
    neg-int v2, v1

    invoke-virtual {p0, v2}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->updateBottomOffset(I)V

    goto :goto_1
.end method

.method public setListViewHeaderVisibility(I)V
    .locals 1
    .param p1, "visibility"    # I

    .prologue
    .line 80
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mHeaderContent:Landroid/view/View;

    invoke-virtual {v0, p1}, Landroid/view/View;->setVisibility(I)V

    .line 81
    return-void
.end method

.method public updateBottomOffset(I)V
    .locals 0
    .param p1, "offset"    # I

    .prologue
    .line 198
    iput p1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mBottomOffset:I

    .line 199
    return-void
.end method

.method public updateBottomToolBar()V
    .locals 5

    .prologue
    const/16 v4, 0x8

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 202
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->isOpened()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 203
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mBrowser:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->getObjectsCount()I

    move-result v0

    if-lez v0, :cond_1

    .line 205
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mBottomToolBar:Lcom/amazon/mShop/ui/BottomToolBar;

    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mDeleteAllButton:Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;

    invoke-virtual {v0, v1, v3}, Lcom/amazon/mShop/ui/BottomToolBar;->setToolBarItemEnabled(Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;Z)V

    .line 210
    :goto_0
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mBottomToolBar:Lcom/amazon/mShop/ui/BottomToolBar;

    invoke-virtual {v0}, Lcom/amazon/mShop/ui/BottomToolBar;->getVisibility()I

    move-result v0

    if-ne v0, v4, :cond_0

    .line 211
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mBottomToolBar:Lcom/amazon/mShop/ui/BottomToolBar;

    invoke-virtual {v0, v2}, Lcom/amazon/mShop/ui/BottomToolBar;->setVisibility(I)V

    .line 212
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mBottomToolBar:Lcom/amazon/mShop/ui/BottomToolBar;

    invoke-direct {p0, v0, v3}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->startBottomToolBarTransitionAnimation(Landroid/view/View;Z)V

    .line 218
    :cond_0
    :goto_1
    return-void

    .line 207
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mBottomToolBar:Lcom/amazon/mShop/ui/BottomToolBar;

    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mDeleteAllButton:Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;

    invoke-virtual {v0, v1, v2}, Lcom/amazon/mShop/ui/BottomToolBar;->setToolBarItemEnabled(Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;Z)V

    goto :goto_0

    .line 214
    :cond_2
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mBottomToolBar:Lcom/amazon/mShop/ui/BottomToolBar;

    invoke-virtual {v0}, Lcom/amazon/mShop/ui/BottomToolBar;->getVisibility()I

    move-result v0

    if-nez v0, :cond_0

    .line 215
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mBottomToolBar:Lcom/amazon/mShop/ui/BottomToolBar;

    invoke-direct {p0, v0, v2}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->startBottomToolBarTransitionAnimation(Landroid/view/View;Z)V

    .line 216
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mBottomToolBar:Lcom/amazon/mShop/ui/BottomToolBar;

    invoke-virtual {v0, v4}, Lcom/amazon/mShop/ui/BottomToolBar;->setVisibility(I)V

    goto :goto_1
.end method

.method public updateHandleBackground(F)V
    .locals 4
    .param p1, "percent"    # F

    .prologue
    .line 331
    const v1, 0xdddddd

    .line 332
    .local v1, "backgroundColor":I
    const/4 v2, 0x0

    cmpl-float v2, p1, v2

    if-ltz v2, :cond_0

    const/high16 v2, 0x3f800000    # 1.0f

    cmpg-float v2, p1, v2

    if-gtz v2, :cond_0

    .line 333
    const/high16 v2, 0x437f0000    # 255.0f

    const/high16 v3, 0x42fe0000    # 127.0f

    mul-float/2addr v3, p1

    sub-float/2addr v2, v3

    float-to-int v0, v2

    .line 334
    .local v0, "alpha":I
    shl-int/lit8 v2, v0, 0x18

    or-int/2addr v1, v2

    .line 336
    .end local v0    # "alpha":I
    :cond_0
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mHandle:Landroid/view/View;

    invoke-virtual {v2, v1}, Landroid/view/View;->setBackgroundColor(I)V

    .line 337
    return-void
.end method
