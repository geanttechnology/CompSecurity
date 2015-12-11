.class public Lcom/amazon/mShop/search/viewit/ViewItHistoryListView;
.super Landroid/widget/ListView;
.source "ViewItHistoryListView.java"


# instance fields
.field private mFirstItemIndex:I

.field private mLastMotionPositionY:F

.field private mSlidingDrawer:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 15
    invoke-direct {p0, p1, p2}, Landroid/widget/ListView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 12
    const/4 v0, -0x1

    iput v0, p0, Lcom/amazon/mShop/search/viewit/ViewItHistoryListView;->mFirstItemIndex:I

    .line 13
    const/4 v0, 0x0

    iput v0, p0, Lcom/amazon/mShop/search/viewit/ViewItHistoryListView;->mLastMotionPositionY:F

    .line 17
    new-instance v0, Lcom/amazon/mShop/search/viewit/ViewItHistoryListView$1;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/search/viewit/ViewItHistoryListView$1;-><init>(Lcom/amazon/mShop/search/viewit/ViewItHistoryListView;)V

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/search/viewit/ViewItHistoryListView;->setOnScrollListener(Landroid/widget/AbsListView$OnScrollListener;)V

    .line 29
    return-void
.end method

.method static synthetic access$002(Lcom/amazon/mShop/search/viewit/ViewItHistoryListView;I)I
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItHistoryListView;
    .param p1, "x1"    # I

    .prologue
    .line 9
    iput p1, p0, Lcom/amazon/mShop/search/viewit/ViewItHistoryListView;->mFirstItemIndex:I

    return p1
.end method


# virtual methods
.method public isListViewScrolledToTop()Z
    .locals 1

    .prologue
    .line 52
    iget v0, p0, Lcom/amazon/mShop/search/viewit/ViewItHistoryListView;->mFirstItemIndex:I

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 4
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 37
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v1

    .line 38
    .local v1, "y":F
    iget v2, p0, Lcom/amazon/mShop/search/viewit/ViewItHistoryListView;->mLastMotionPositionY:F

    cmpl-float v2, v1, v2

    if-lez v2, :cond_1

    const/4 v0, 0x1

    .line 39
    .local v0, "isMoveDown":Z
    :goto_0
    iput v1, p0, Lcom/amazon/mShop/search/viewit/ViewItHistoryListView;->mLastMotionPositionY:F

    .line 44
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v2

    const/4 v3, 0x2

    if-ne v2, v3, :cond_0

    iget v2, p0, Lcom/amazon/mShop/search/viewit/ViewItHistoryListView;->mFirstItemIndex:I

    if-nez v2, :cond_0

    if-eqz v0, :cond_0

    .line 45
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItHistoryListView;->mSlidingDrawer:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    invoke-virtual {v2}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->requestInterceptTouchEvent()V

    .line 48
    :cond_0
    invoke-super {p0, p1}, Landroid/widget/ListView;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v2

    return v2

    .line 38
    .end local v0    # "isMoveDown":Z
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public setSlidingDrawerView(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;)V
    .locals 0
    .param p1, "view"    # Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    .prologue
    .line 32
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItHistoryListView;->mSlidingDrawer:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    .line 33
    return-void
.end method
