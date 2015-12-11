.class public Lco/vine/android/BaseArrayListFragment;
.super Lco/vine/android/BaseAdapterFragment;
.source "BaseArrayListFragment.java"

# interfaces
.implements Landroid/widget/AbsListView$OnScrollListener;
.implements Lco/vine/android/widget/OnTabChangedListener;
.implements Lcom/twitter/android/widget/RefreshListener;
.implements Lco/vine/android/widget/PinnedHeaderListView$ScrollDeltaListener;


# static fields
.field public static final ARG_BG_COLOR:Ljava/lang/String; = "bg_color"

.field public static final ARG_CHOICE_MODE:Ljava/lang/String; = "chmode"

.field public static final ARG_DATA:Ljava/lang/String; = "data"

.field public static final ARG_EMPTY_DESC:Ljava/lang/String; = "empty_desc"

.field public static final ARG_OWNER_ID:Ljava/lang/String; = "owner_id"

.field public static final ARG_REFRESHABLE:Ljava/lang/String; = "refresh"

.field public static final ARG_TAKE_FOCUS:Ljava/lang/String; = "take_focus"

.field private static final STATE_SCROLL_OFF_KEY:Ljava/lang/String; = "scroll_off"

.field private static final STATE_SCROLL_POS_KEY:Ljava/lang/String; = "scroll_pos"


# instance fields
.field protected mAdapter:Landroid/widget/BaseAdapter;

.field protected mAnchor:J

.field protected mBgColor:I

.field private mChildFormerTop:I

.field private mChildObservedForScrollDistance:Landroid/view/View;

.field protected mChoiceMode:I

.field protected mEmptyProgress:Landroid/widget/ProgressBar;

.field protected mEmptyText:Landroid/widget/TextView;

.field protected mEmptyTextStringRes:I

.field private mEmptyView:Landroid/view/View;

.field protected mFocused:Z

.field private mIsSadFaceHeaderAdded:Z

.field private mIsSadFacePartOfHeader:Z

.field protected mListState:Lco/vine/android/ListState;

.field protected mListView:Landroid/widget/ListView;

.field protected mNextPage:I

.field private final mOnItemClickListener:Landroid/widget/AdapterView$OnItemClickListener;

.field private final mOnItemLongClickListenerClickListener:Landroid/widget/AdapterView$OnItemLongClickListener;

.field protected mOwnerId:J

.field protected mRefreshable:Z

.field private final mRequestFocus:Ljava/lang/Runnable;

.field private mRootView:Landroid/view/View;

.field protected mSadface:Landroid/view/View;

.field private mScrollListener:Lco/vine/android/widget/tabs/TabScrollListener;

.field private mScrollOffset:I

.field private mScrollPos:I


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 42
    invoke-direct {p0}, Lco/vine/android/BaseAdapterFragment;-><init>()V

    .line 69
    const/4 v0, 0x1

    iput v0, p0, Lco/vine/android/BaseArrayListFragment;->mNextPage:I

    .line 70
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lco/vine/android/BaseArrayListFragment;->mAnchor:J

    .line 81
    new-instance v0, Lco/vine/android/BaseArrayListFragment$1;

    invoke-direct {v0, p0}, Lco/vine/android/BaseArrayListFragment$1;-><init>(Lco/vine/android/BaseArrayListFragment;)V

    iput-object v0, p0, Lco/vine/android/BaseArrayListFragment;->mOnItemClickListener:Landroid/widget/AdapterView$OnItemClickListener;

    .line 88
    new-instance v0, Lco/vine/android/BaseArrayListFragment$2;

    invoke-direct {v0, p0}, Lco/vine/android/BaseArrayListFragment$2;-><init>(Lco/vine/android/BaseArrayListFragment;)V

    iput-object v0, p0, Lco/vine/android/BaseArrayListFragment;->mOnItemLongClickListenerClickListener:Landroid/widget/AdapterView$OnItemLongClickListener;

    .line 95
    new-instance v0, Lco/vine/android/BaseArrayListFragment$3;

    invoke-direct {v0, p0}, Lco/vine/android/BaseArrayListFragment$3;-><init>(Lco/vine/android/BaseArrayListFragment;)V

    iput-object v0, p0, Lco/vine/android/BaseArrayListFragment;->mRequestFocus:Ljava/lang/Runnable;

    .line 105
    const/4 v0, -0x1

    iput v0, p0, Lco/vine/android/BaseArrayListFragment;->mChildFormerTop:I

    return-void
.end method

.method public static prepareArguments(Landroid/content/Intent;Z)Landroid/os/Bundle;
    .locals 3
    .param p0, "intent"    # Landroid/content/Intent;
    .param p1, "refreshable"    # Z

    .prologue
    .line 604
    invoke-virtual {p0}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 605
    .local v0, "args":Landroid/os/Bundle;
    if-nez v0, :cond_0

    .line 606
    new-instance v0, Landroid/os/Bundle;

    .end local v0    # "args":Landroid/os/Bundle;
    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 608
    .restart local v0    # "args":Landroid/os/Bundle;
    :cond_0
    const-string v1, "data"

    invoke-virtual {p0}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 609
    const-string v1, "refresh"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 610
    return-object v0
.end method

.method private showLoading(Z)V
    .locals 4
    .param p1, "show"    # Z

    .prologue
    const/4 v3, 0x0

    const/16 v2, 0x8

    .line 441
    if-eqz p1, :cond_2

    .line 442
    iget-object v0, p0, Lco/vine/android/BaseArrayListFragment;->mListView:Landroid/widget/ListView;

    .line 443
    .local v0, "l":Landroid/widget/ListView;
    invoke-virtual {v0, v2}, Landroid/widget/ListView;->setVisibility(I)V

    .line 444
    iget-object v1, p0, Lco/vine/android/BaseArrayListFragment;->mSadface:Landroid/view/View;

    if-eqz v1, :cond_0

    .line 445
    iget-object v1, p0, Lco/vine/android/BaseArrayListFragment;->mSadface:Landroid/view/View;

    invoke-virtual {v1, v2}, Landroid/view/View;->setVisibility(I)V

    .line 447
    :cond_0
    iget-object v1, p0, Lco/vine/android/BaseArrayListFragment;->mEmptyProgress:Landroid/widget/ProgressBar;

    if-eqz v1, :cond_1

    .line 448
    iget-object v1, p0, Lco/vine/android/BaseArrayListFragment;->mEmptyProgress:Landroid/widget/ProgressBar;

    invoke-virtual {v1, v3}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 460
    :cond_1
    :goto_0
    return-void

    .line 451
    .end local v0    # "l":Landroid/widget/ListView;
    :cond_2
    iget-object v0, p0, Lco/vine/android/BaseArrayListFragment;->mListView:Landroid/widget/ListView;

    .line 452
    .restart local v0    # "l":Landroid/widget/ListView;
    invoke-virtual {p0}, Lco/vine/android/BaseArrayListFragment;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_3

    .line 453
    invoke-virtual {v0, v3}, Landroid/widget/ListView;->setVisibility(I)V

    goto :goto_0

    .line 455
    :cond_3
    iget-object v1, p0, Lco/vine/android/BaseArrayListFragment;->mEmptyProgress:Landroid/widget/ProgressBar;

    if-eqz v1, :cond_1

    .line 456
    iget-object v1, p0, Lco/vine/android/BaseArrayListFragment;->mEmptyProgress:Landroid/widget/ProgressBar;

    invoke-virtual {v1, v2}, Landroid/widget/ProgressBar;->setVisibility(I)V

    goto :goto_0
.end method


# virtual methods
.method protected createDefaultView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 1
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;

    .prologue
    .line 226
    const v0, 0x7f03005f

    invoke-virtual {p0, p1, v0, p2}, Lco/vine/android/BaseArrayListFragment;->createView(Landroid/view/LayoutInflater;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public createView(Landroid/view/LayoutInflater;ILandroid/view/ViewGroup;)Landroid/view/View;
    .locals 7
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "layout"    # I
    .param p3, "container"    # Landroid/view/ViewGroup;

    .prologue
    .line 175
    const/4 v5, 0x0

    invoke-virtual {p1, p2, p3, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v4

    .line 177
    .local v4, "v":Landroid/view/View;
    iput-object v4, p0, Lco/vine/android/BaseArrayListFragment;->mRootView:Landroid/view/View;

    .line 179
    const v5, 0x102000a

    invoke-virtual {v4, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ListView;

    .line 180
    .local v2, "listView":Landroid/widget/ListView;
    iget-object v5, p0, Lco/vine/android/BaseArrayListFragment;->mOnItemClickListener:Landroid/widget/AdapterView$OnItemClickListener;

    invoke-virtual {v2, v5}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 181
    iget-object v5, p0, Lco/vine/android/BaseArrayListFragment;->mOnItemLongClickListenerClickListener:Landroid/widget/AdapterView$OnItemLongClickListener;

    invoke-virtual {v2, v5}, Landroid/widget/ListView;->setOnItemLongClickListener(Landroid/widget/AdapterView$OnItemLongClickListener;)V

    .line 182
    const/4 v5, 0x1

    invoke-virtual {v2, v5}, Landroid/widget/ListView;->setScrollbarFadingEnabled(Z)V

    .line 183
    invoke-virtual {v2, p0}, Landroid/widget/ListView;->setOnScrollListener(Landroid/widget/AbsListView$OnScrollListener;)V

    .line 184
    iget v5, p0, Lco/vine/android/BaseArrayListFragment;->mChoiceMode:I

    invoke-virtual {v2, v5}, Landroid/widget/ListView;->setChoiceMode(I)V

    .line 185
    iget v0, p0, Lco/vine/android/BaseArrayListFragment;->mBgColor:I

    .line 186
    .local v0, "bgColor":I
    if-eqz v0, :cond_0

    .line 187
    invoke-virtual {v2, v0}, Landroid/widget/ListView;->setBackgroundColor(I)V

    .line 188
    invoke-virtual {v2, v0}, Landroid/widget/ListView;->setCacheColorHint(I)V

    .line 191
    :cond_0
    const v5, 0x1020004

    invoke-virtual {v4, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    .line 192
    .local v1, "emptyView":Landroid/view/View;
    if-eqz v1, :cond_1

    .line 193
    invoke-virtual {v2, v1}, Landroid/widget/ListView;->setEmptyView(Landroid/view/View;)V

    .line 194
    const v5, 0x7f0a00f1

    invoke-virtual {v1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/ProgressBar;

    iput-object v5, p0, Lco/vine/android/BaseArrayListFragment;->mEmptyProgress:Landroid/widget/ProgressBar;

    .line 195
    invoke-virtual {p0}, Lco/vine/android/BaseArrayListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v5

    instance-of v5, v5, Lco/vine/android/HomeTabActivity;

    if-eqz v5, :cond_1

    .line 196
    iget-object v5, p0, Lco/vine/android/BaseArrayListFragment;->mEmptyProgress:Landroid/widget/ProgressBar;

    invoke-virtual {v5}, Landroid/widget/ProgressBar;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v3

    check-cast v3, Landroid/view/ViewGroup$MarginLayoutParams;

    .line 197
    .local v3, "params":Landroid/view/ViewGroup$MarginLayoutParams;
    invoke-virtual {p0}, Lco/vine/android/BaseArrayListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v5

    invoke-virtual {v5}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    const v6, 0x7f0b0084

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v5

    iput v5, v3, Landroid/view/ViewGroup$MarginLayoutParams;->topMargin:I

    .line 201
    .end local v3    # "params":Landroid/view/ViewGroup$MarginLayoutParams;
    :cond_1
    iput-object v1, p0, Lco/vine/android/BaseArrayListFragment;->mEmptyView:Landroid/view/View;

    .line 203
    const v5, 0x7f0a007f

    invoke-virtual {v4, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/TextView;

    iput-object v5, p0, Lco/vine/android/BaseArrayListFragment;->mEmptyText:Landroid/widget/TextView;

    .line 204
    iget v5, p0, Lco/vine/android/BaseArrayListFragment;->mEmptyTextStringRes:I

    if-lez v5, :cond_2

    .line 205
    iget-object v5, p0, Lco/vine/android/BaseArrayListFragment;->mEmptyText:Landroid/widget/TextView;

    if-eqz v5, :cond_2

    .line 206
    iget-object v5, p0, Lco/vine/android/BaseArrayListFragment;->mEmptyText:Landroid/widget/TextView;

    iget v6, p0, Lco/vine/android/BaseArrayListFragment;->mEmptyTextStringRes:I

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setText(I)V

    .line 210
    :cond_2
    const v5, 0x7f0a007e

    invoke-virtual {v4, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    iput-object v5, p0, Lco/vine/android/BaseArrayListFragment;->mSadface:Landroid/view/View;

    .line 212
    iget-boolean v5, p0, Lco/vine/android/BaseArrayListFragment;->mRefreshable:Z

    if-eqz v5, :cond_3

    move-object v5, v2

    .line 213
    check-cast v5, Lcom/twitter/android/widget/RefreshableListView;

    invoke-virtual {v5, p0}, Lcom/twitter/android/widget/RefreshableListView;->setRefreshListener(Lcom/twitter/android/widget/RefreshListener;)V

    .line 216
    :cond_3
    iput-object v2, p0, Lco/vine/android/BaseArrayListFragment;->mListView:Landroid/widget/ListView;

    .line 218
    iget-object v5, p0, Lco/vine/android/BaseArrayListFragment;->mListView:Landroid/widget/ListView;

    instance-of v5, v5, Lco/vine/android/widget/PinnedHeaderListView;

    if-eqz v5, :cond_4

    .line 219
    iget-object v5, p0, Lco/vine/android/BaseArrayListFragment;->mListView:Landroid/widget/ListView;

    check-cast v5, Lco/vine/android/widget/PinnedHeaderListView;

    invoke-virtual {v5, p0}, Lco/vine/android/widget/PinnedHeaderListView;->setScrollDeltaListener(Lco/vine/android/widget/PinnedHeaderListView$ScrollDeltaListener;)V

    .line 222
    :cond_4
    return-object v4
.end method

.method public getFirstItemPosition()Lcom/twitter/android/widget/ItemPosition;
    .locals 9

    .prologue
    const/4 v5, 0x0

    .line 566
    iget-object v3, p0, Lco/vine/android/BaseArrayListFragment;->mListView:Landroid/widget/ListView;

    .line 567
    .local v3, "l":Landroid/widget/ListView;
    invoke-virtual {v3}, Landroid/widget/ListView;->getCount()I

    move-result v6

    const/4 v7, 0x1

    if-ge v6, v7, :cond_0

    const/4 v5, 0x0

    .line 586
    :goto_0
    return-object v5

    .line 568
    :cond_0
    invoke-virtual {v3}, Landroid/widget/ListView;->getFirstVisiblePosition()I

    move-result v1

    .line 569
    .local v1, "firstPos":I
    invoke-virtual {v3}, Landroid/widget/ListView;->getHeaderViewsCount()I

    move-result v2

    .line 571
    .local v2, "headerCount":I
    iget-boolean v6, p0, Lco/vine/android/BaseArrayListFragment;->mRefreshing:Z

    if-eqz v6, :cond_1

    .line 572
    add-int/lit8 v2, v2, 0x1

    .line 578
    :cond_1
    if-ge v1, v2, :cond_3

    .line 579
    move v4, v2

    .line 580
    .local v4, "position":I
    sub-int v6, v4, v1

    invoke-virtual {v3, v6}, Landroid/widget/ListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 586
    .local v0, "child":Landroid/view/View;
    :goto_1
    new-instance v6, Lcom/twitter/android/widget/ItemPosition;

    invoke-virtual {v3, v4}, Landroid/widget/ListView;->getItemIdAtPosition(I)J

    move-result-wide v7

    if-eqz v0, :cond_2

    invoke-virtual {v0}, Landroid/view/View;->getTop()I

    move-result v5

    :cond_2
    invoke-direct {v6, v4, v7, v8, v5}, Lcom/twitter/android/widget/ItemPosition;-><init>(IJI)V

    move-object v5, v6

    goto :goto_0

    .line 582
    .end local v0    # "child":Landroid/view/View;
    .end local v4    # "position":I
    :cond_3
    move v4, v1

    .line 583
    .restart local v4    # "position":I
    invoke-virtual {v3, v5}, Landroid/widget/ListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .restart local v0    # "child":Landroid/view/View;
    goto :goto_1
.end method

.method public getPositionForItemId(J)I
    .locals 3
    .param p1, "id"    # J

    .prologue
    .line 532
    iget-object v1, p0, Lco/vine/android/BaseArrayListFragment;->mAdapter:Landroid/widget/BaseAdapter;

    if-eqz v1, :cond_1

    .line 533
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v1, p0, Lco/vine/android/BaseArrayListFragment;->mAdapter:Landroid/widget/BaseAdapter;

    invoke-virtual {v1}, Landroid/widget/BaseAdapter;->getCount()I

    move-result v1

    if-ge v0, v1, :cond_1

    .line 534
    iget-object v1, p0, Lco/vine/android/BaseArrayListFragment;->mAdapter:Landroid/widget/BaseAdapter;

    invoke-virtual {v1, v0}, Landroid/widget/BaseAdapter;->getItemId(I)J

    move-result-wide v1

    cmp-long v1, v1, p1

    if-nez v1, :cond_0

    .line 539
    .end local v0    # "i":I
    :goto_1
    return v0

    .line 533
    .restart local v0    # "i":I
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 539
    .end local v0    # "i":I
    :cond_1
    const/4 v0, 0x0

    goto :goto_1
.end method

.method public getRootView()Landroid/view/View;
    .locals 1

    .prologue
    .line 171
    iget-object v0, p0, Lco/vine/android/BaseArrayListFragment;->mRootView:Landroid/view/View;

    return-object v0
.end method

.method protected hideProgress(I)V
    .locals 2
    .param p1, "progressType"    # I

    .prologue
    const/4 v1, 0x0

    .line 397
    packed-switch p1, :pswitch_data_0

    .line 424
    :cond_0
    :goto_0
    return-void

    .line 399
    :pswitch_0
    invoke-direct {p0, v1}, Lco/vine/android/BaseArrayListFragment;->showLoading(Z)V

    goto :goto_0

    .line 405
    :pswitch_1
    invoke-direct {p0, v1}, Lco/vine/android/BaseArrayListFragment;->showLoading(Z)V

    .line 406
    iget-boolean v0, p0, Lco/vine/android/BaseArrayListFragment;->mRefreshable:Z

    if-eqz v0, :cond_0

    .line 407
    iget-object v0, p0, Lco/vine/android/BaseArrayListFragment;->mListView:Landroid/widget/ListView;

    check-cast v0, Lcom/twitter/android/widget/RefreshableListView;

    invoke-virtual {v0}, Lcom/twitter/android/widget/RefreshableListView;->stopRefresh()V

    .line 408
    iput-boolean v1, p0, Lco/vine/android/BaseArrayListFragment;->mRefreshing:Z

    goto :goto_0

    .line 414
    :pswitch_2
    iget-boolean v0, p0, Lco/vine/android/BaseArrayListFragment;->mRefreshable:Z

    if-eqz v0, :cond_0

    .line 415
    iget-object v0, p0, Lco/vine/android/BaseArrayListFragment;->mListView:Landroid/widget/ListView;

    check-cast v0, Lcom/twitter/android/widget/RefreshableListView;

    invoke-virtual {v0, v1}, Lcom/twitter/android/widget/RefreshableListView;->refreshMore(Z)V

    goto :goto_0

    .line 397
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_2
        :pswitch_1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method invokeScrollFirstItem()V
    .locals 1

    .prologue
    .line 591
    iget-object v0, p0, Lco/vine/android/BaseArrayListFragment;->mScrollListener:Lco/vine/android/widget/tabs/TabScrollListener;

    if-eqz v0, :cond_0

    .line 592
    iget-object v0, p0, Lco/vine/android/BaseArrayListFragment;->mScrollListener:Lco/vine/android/widget/tabs/TabScrollListener;

    invoke-virtual {v0}, Lco/vine/android/widget/tabs/TabScrollListener;->onScrollFirstItem()V

    .line 594
    :cond_0
    return-void
.end method

.method protected isEmpty()Z
    .locals 3

    .prologue
    .line 436
    iget-object v0, p0, Lco/vine/android/BaseArrayListFragment;->mListView:Landroid/widget/ListView;

    .line 437
    .local v0, "l":Landroid/widget/ListView;
    invoke-virtual {v0}, Landroid/widget/ListView;->getCount()I

    move-result v1

    invoke-virtual {v0}, Landroid/widget/ListView;->getHeaderViewsCount()I

    move-result v2

    sub-int/2addr v1, v2

    invoke-virtual {v0}, Landroid/widget/ListView;->getFooterViewsCount()I

    move-result v2

    sub-int/2addr v1, v2

    if-nez v1, :cond_0

    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method protected isFocused()Z
    .locals 1

    .prologue
    .line 118
    iget-boolean v0, p0, Lco/vine/android/BaseArrayListFragment;->mFocused:Z

    return v0
.end method

.method public isSadFacePartOfHeader()Z
    .locals 1

    .prologue
    .line 133
    iget-boolean v0, p0, Lco/vine/android/BaseArrayListFragment;->mIsSadFacePartOfHeader:Z

    return v0
.end method

.method public declared-synchronized makeSadFaceHeaderView()V
    .locals 8

    .prologue
    .line 327
    monitor-enter p0

    :try_start_0
    iget-boolean v4, p0, Lco/vine/android/BaseArrayListFragment;->mIsSadFacePartOfHeader:Z

    if-nez v4, :cond_2

    .line 328
    const/4 v4, 0x1

    iput-boolean v4, p0, Lco/vine/android/BaseArrayListFragment;->mIsSadFacePartOfHeader:Z

    .line 329
    const/4 v4, 0x1

    iput-boolean v4, p0, Lco/vine/android/BaseArrayListFragment;->mIsSadFaceHeaderAdded:Z

    .line 330
    iget-object v4, p0, Lco/vine/android/BaseArrayListFragment;->mSadface:Landroid/view/View;

    if-eqz v4, :cond_2

    .line 331
    const/4 v0, 0x0

    .line 332
    .local v0, "alreadyAttached":Z
    iget-object v4, p0, Lco/vine/android/BaseArrayListFragment;->mSadface:Landroid/view/View;

    invoke-virtual {v4}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v3

    .line 333
    .local v3, "parent":Landroid/view/ViewParent;
    if-eqz v3, :cond_0

    .line 334
    instance-of v4, v3, Landroid/view/ViewGroup;

    if-eqz v4, :cond_4

    .line 335
    iget-object v4, p0, Lco/vine/android/BaseArrayListFragment;->mListView:Landroid/widget/ListView;

    if-eq v3, v4, :cond_3

    .line 336
    check-cast v3, Landroid/view/ViewGroup;

    .end local v3    # "parent":Landroid/view/ViewParent;
    iget-object v4, p0, Lco/vine/android/BaseArrayListFragment;->mSadface:Landroid/view/View;

    invoke-virtual {v3, v4}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    .line 344
    :cond_0
    :goto_0
    if-nez v0, :cond_2

    .line 345
    iget-object v4, p0, Lco/vine/android/BaseArrayListFragment;->mSadface:Landroid/view/View;

    invoke-virtual {v4}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    .line 346
    .local v1, "params":Landroid/view/ViewGroup$LayoutParams;
    if-eqz v1, :cond_1

    .line 347
    new-instance v2, Landroid/widget/AbsListView$LayoutParams;

    iget v4, v1, Landroid/view/ViewGroup$LayoutParams;->width:I

    iget v5, v1, Landroid/view/ViewGroup$LayoutParams;->height:I

    invoke-direct {v2, v4, v5}, Landroid/widget/AbsListView$LayoutParams;-><init>(II)V

    .line 348
    .end local v1    # "params":Landroid/view/ViewGroup$LayoutParams;
    .local v2, "params":Landroid/view/ViewGroup$LayoutParams;
    iget-object v4, p0, Lco/vine/android/BaseArrayListFragment;->mSadface:Landroid/view/View;

    invoke-virtual {v4, v2}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    move-object v1, v2

    .line 350
    .end local v2    # "params":Landroid/view/ViewGroup$LayoutParams;
    .restart local v1    # "params":Landroid/view/ViewGroup$LayoutParams;
    :cond_1
    iget-object v4, p0, Lco/vine/android/BaseArrayListFragment;->mListView:Landroid/widget/ListView;

    iget-object v5, p0, Lco/vine/android/BaseArrayListFragment;->mSadface:Landroid/view/View;

    const/4 v6, 0x0

    const/4 v7, 0x0

    invoke-virtual {v4, v5, v6, v7}, Landroid/widget/ListView;->addHeaderView(Landroid/view/View;Ljava/lang/Object;Z)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 354
    .end local v0    # "alreadyAttached":Z
    .end local v1    # "params":Landroid/view/ViewGroup$LayoutParams;
    :cond_2
    monitor-exit p0

    return-void

    .line 338
    .restart local v0    # "alreadyAttached":Z
    .restart local v3    # "parent":Landroid/view/ViewParent;
    :cond_3
    const/4 v0, 0x1

    goto :goto_0

    .line 341
    :cond_4
    :try_start_1
    new-instance v4, Ljava/lang/IllegalStateException;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "The sad face does not belong to a valid parent: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v4
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 327
    .end local v0    # "alreadyAttached":Z
    .end local v3    # "parent":Landroid/view/ViewParent;
    :catchall_0
    move-exception v4

    monitor-exit p0

    throw v4
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 1
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 645
    iget-object v0, p0, Lco/vine/android/BaseArrayListFragment;->mPendingRequestHelper:Lco/vine/android/PendingRequestHelper;

    invoke-virtual {v0, p1, p2, p3}, Lco/vine/android/PendingRequestHelper;->onActivityResult(IILandroid/content/Intent;)Z

    .line 646
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 5
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v2, 0x1

    const/4 v4, 0x0

    .line 139
    invoke-super {p0, p1}, Lco/vine/android/BaseAdapterFragment;->onCreate(Landroid/os/Bundle;)V

    .line 141
    new-instance v1, Lco/vine/android/ListState;

    invoke-direct {v1}, Lco/vine/android/ListState;-><init>()V

    iput-object v1, p0, Lco/vine/android/BaseArrayListFragment;->mListState:Lco/vine/android/ListState;

    .line 143
    if-eqz p1, :cond_1

    .line 144
    const-string v1, "scroll_pos"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v1

    iput v1, p0, Lco/vine/android/BaseArrayListFragment;->mScrollPos:I

    .line 145
    const-string v1, "scroll_off"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v1

    iput v1, p0, Lco/vine/android/BaseArrayListFragment;->mScrollOffset:I

    .line 146
    iget-object v1, p0, Lco/vine/android/BaseArrayListFragment;->mPendingRequestHelper:Lco/vine/android/PendingRequestHelper;

    invoke-virtual {v1, p1}, Lco/vine/android/PendingRequestHelper;->restorePendingCaptchaRequest(Landroid/os/Bundle;)V

    .line 152
    :goto_0
    invoke-virtual {p0}, Lco/vine/android/BaseArrayListFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    .line 153
    .local v0, "args":Landroid/os/Bundle;
    if-eqz v0, :cond_2

    .line 154
    const-string v1, "refresh"

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    iput-boolean v1, p0, Lco/vine/android/BaseArrayListFragment;->mRefreshable:Z

    .line 155
    const-string v1, "owner_id"

    iget-object v2, p0, Lco/vine/android/BaseArrayListFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v2}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v2

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Bundle;->getLong(Ljava/lang/String;J)J

    move-result-wide v1

    iput-wide v1, p0, Lco/vine/android/BaseArrayListFragment;->mOwnerId:J

    .line 157
    const-string v1, "chmode"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 158
    const-string v1, "chmode"

    invoke-virtual {v0, v1, v4}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v1

    iput v1, p0, Lco/vine/android/BaseArrayListFragment;->mChoiceMode:I

    .line 160
    :cond_0
    const-string v1, "bg_color"

    invoke-virtual {v0, v1, v4}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v1

    iput v1, p0, Lco/vine/android/BaseArrayListFragment;->mBgColor:I

    .line 161
    const-string v1, "empty_desc"

    invoke-virtual {v0, v1, v4}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v1

    iput v1, p0, Lco/vine/android/BaseArrayListFragment;->mEmptyTextStringRes:I

    .line 168
    :goto_1
    return-void

    .line 148
    .end local v0    # "args":Landroid/os/Bundle;
    :cond_1
    iput v4, p0, Lco/vine/android/BaseArrayListFragment;->mScrollPos:I

    .line 149
    iput v4, p0, Lco/vine/android/BaseArrayListFragment;->mScrollOffset:I

    goto :goto_0

    .line 163
    .restart local v0    # "args":Landroid/os/Bundle;
    :cond_2
    iput-boolean v2, p0, Lco/vine/android/BaseArrayListFragment;->mRefreshable:Z

    .line 164
    iget-object v1, p0, Lco/vine/android/BaseArrayListFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v1}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v1

    iput-wide v1, p0, Lco/vine/android/BaseArrayListFragment;->mOwnerId:J

    .line 165
    iput v4, p0, Lco/vine/android/BaseArrayListFragment;->mChoiceMode:I

    .line 166
    iput v4, p0, Lco/vine/android/BaseArrayListFragment;->mBgColor:I

    goto :goto_1
.end method

.method protected onCreateDialog(I)Landroid/app/Dialog;
    .locals 1
    .param p1, "dialog"    # I

    .prologue
    .line 624
    const/4 v0, 0x0

    return-object v0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 1
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 233
    invoke-virtual {p0, p1, p2}, Lco/vine/android/BaseArrayListFragment;->createDefaultView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onDestroyView()V
    .locals 2

    .prologue
    .line 244
    iget-object v0, p0, Lco/vine/android/BaseArrayListFragment;->mHandler:Landroid/os/Handler;

    iget-object v1, p0, Lco/vine/android/BaseArrayListFragment;->mRequestFocus:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 245
    invoke-super {p0}, Lco/vine/android/BaseAdapterFragment;->onDestroyView()V

    .line 246
    return-void
.end method

.method protected onListItemClick(Landroid/widget/ListView;Landroid/view/View;IJ)V
    .locals 0
    .param p1, "l"    # Landroid/widget/ListView;
    .param p2, "v"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "id"    # J

    .prologue
    .line 126
    return-void
.end method

.method protected onListItemLongClick(Landroid/widget/ListView;Landroid/view/View;IJ)Z
    .locals 1
    .param p1, "parent"    # Landroid/widget/ListView;
    .param p2, "view"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "id"    # J

    .prologue
    .line 129
    const/4 v0, 0x0

    return v0
.end method

.method public onMoveAway(I)V
    .locals 1
    .param p1, "newPosition"    # I

    .prologue
    .line 109
    const/4 v0, 0x0

    iput-boolean v0, p0, Lco/vine/android/BaseArrayListFragment;->mFocused:Z

    .line 110
    return-void
.end method

.method public onMoveTo(I)V
    .locals 1
    .param p1, "oldPosition"    # I

    .prologue
    .line 114
    const/4 v0, 0x1

    iput-boolean v0, p0, Lco/vine/android/BaseArrayListFragment;->mFocused:Z

    .line 115
    return-void
.end method

.method public onPause()V
    .locals 1

    .prologue
    .line 257
    invoke-super {p0}, Lco/vine/android/BaseAdapterFragment;->onPause()V

    .line 261
    iget-object v0, p0, Lco/vine/android/BaseArrayListFragment;->mListView:Landroid/widget/ListView;

    invoke-virtual {v0}, Landroid/widget/ListView;->getCount()I

    move-result v0

    if-lez v0, :cond_0

    .line 262
    invoke-virtual {p0}, Lco/vine/android/BaseArrayListFragment;->savePosition()V

    .line 264
    :cond_0
    return-void
.end method

.method public onRefreshCancelled()V
    .locals 0

    .prologue
    .line 513
    return-void
.end method

.method public onRefreshFinished()V
    .locals 0

    .prologue
    .line 529
    return-void
.end method

.method public onRefreshFinishedNewData()V
    .locals 0

    .prologue
    .line 523
    return-void
.end method

.method public onRefreshFinishedNoChange()V
    .locals 0

    .prologue
    .line 526
    return-void
.end method

.method public onRefreshPulled()V
    .locals 0

    .prologue
    .line 509
    return-void
.end method

.method public onRefreshReleased(Z)V
    .locals 1
    .param p1, "shouldStartRefresh"    # Z

    .prologue
    .line 516
    if-eqz p1, :cond_0

    .line 517
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lco/vine/android/util/FlurryUtils;->trackValidPullToRefreshRelease(Ljava/lang/String;)V

    .line 518
    invoke-virtual {p0}, Lco/vine/android/BaseArrayListFragment;->refresh()V

    .line 520
    :cond_0
    return-void
.end method

.method public onResume()V
    .locals 1

    .prologue
    .line 250
    invoke-super {p0}, Lco/vine/android/BaseAdapterFragment;->onResume()V

    .line 251
    invoke-virtual {p0}, Lco/vine/android/BaseArrayListFragment;->restorePosition()V

    .line 252
    iget-object v0, p0, Lco/vine/android/BaseArrayListFragment;->mPendingRequestHelper:Lco/vine/android/PendingRequestHelper;

    invoke-virtual {v0}, Lco/vine/android/PendingRequestHelper;->handlePendingCaptchaRequest()V

    .line 253
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 268
    invoke-super {p0, p1}, Lco/vine/android/BaseAdapterFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 269
    invoke-virtual {p0}, Lco/vine/android/BaseArrayListFragment;->savePosition()V

    .line 270
    const-string v0, "scroll_pos"

    iget v1, p0, Lco/vine/android/BaseArrayListFragment;->mScrollPos:I

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 271
    const-string v0, "scroll_off"

    iget v1, p0, Lco/vine/android/BaseArrayListFragment;->mScrollOffset:I

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 272
    return-void
.end method

.method public onScroll(I)V
    .locals 2
    .param p1, "delta"    # I

    .prologue
    .line 650
    invoke-virtual {p0}, Lco/vine/android/BaseArrayListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    .line 651
    .local v0, "activity":Landroid/support/v4/app/FragmentActivity;
    instance-of v1, v0, Lco/vine/android/ScrollListener;

    if-eqz v1, :cond_0

    .line 652
    check-cast v0, Lco/vine/android/ScrollListener;

    .end local v0    # "activity":Landroid/support/v4/app/FragmentActivity;
    invoke-interface {v0, p1}, Lco/vine/android/ScrollListener;->onScroll(I)V

    .line 654
    :cond_0
    return-void
.end method

.method public onScroll(Landroid/widget/AbsListView;III)V
    .locals 3
    .param p1, "view"    # Landroid/widget/AbsListView;
    .param p2, "firstVisibleItem"    # I
    .param p3, "visibleItemCount"    # I
    .param p4, "totalItemCount"    # I

    .prologue
    .line 278
    iget-object v1, p0, Lco/vine/android/BaseArrayListFragment;->mListState:Lco/vine/android/ListState;

    iput p2, v1, Lco/vine/android/ListState;->firstVisibleItem:I

    .line 279
    iget-object v1, p0, Lco/vine/android/BaseArrayListFragment;->mListState:Lco/vine/android/ListState;

    iput p3, v1, Lco/vine/android/ListState;->visibleItemCount:I

    .line 280
    iget-object v1, p0, Lco/vine/android/BaseArrayListFragment;->mListState:Lco/vine/android/ListState;

    iput p4, v1, Lco/vine/android/ListState;->totalItemCount:I

    .line 282
    if-nez p3, :cond_1

    .line 296
    :cond_0
    :goto_0
    return-void

    .line 286
    :cond_1
    if-lez p2, :cond_0

    iget-object v1, p0, Lco/vine/android/BaseArrayListFragment;->mAdapter:Landroid/widget/BaseAdapter;

    if-eqz v1, :cond_0

    .line 287
    add-int v0, p2, p3

    .line 289
    .local v0, "position":I
    add-int/lit8 v1, p4, -0x1

    if-lt v0, v1, :cond_0

    iget-object v1, p0, Lco/vine/android/BaseArrayListFragment;->mAdapter:Landroid/widget/BaseAdapter;

    invoke-virtual {v1}, Landroid/widget/BaseAdapter;->getCount()I

    move-result v1

    if-lez v1, :cond_0

    .line 290
    iget-object v1, p0, Lco/vine/android/BaseArrayListFragment;->mListState:Lco/vine/android/ListState;

    iget-boolean v1, v1, Lco/vine/android/ListState;->hasNewScrollState:Z

    if-eqz v1, :cond_0

    .line 291
    iget-object v1, p0, Lco/vine/android/BaseArrayListFragment;->mListState:Lco/vine/android/ListState;

    const/4 v2, 0x0

    iput-boolean v2, v1, Lco/vine/android/ListState;->hasNewScrollState:Z

    .line 292
    invoke-virtual {p0}, Lco/vine/android/BaseArrayListFragment;->onScrollLastItem()V

    goto :goto_0
.end method

.method protected onScrollLastItem()V
    .locals 0

    .prologue
    .line 298
    return-void
.end method

.method protected onScrollLastItem(Landroid/database/Cursor;)V
    .locals 0
    .param p1, "cursor"    # Landroid/database/Cursor;

    .prologue
    .line 360
    return-void
.end method

.method public onScrollStateChanged(Landroid/widget/AbsListView;I)V
    .locals 3
    .param p1, "view"    # Landroid/widget/AbsListView;
    .param p2, "scrollState"    # I

    .prologue
    .line 308
    iget-object v0, p0, Lco/vine/android/BaseArrayListFragment;->mListState:Lco/vine/android/ListState;

    const/4 v1, 0x1

    iput-boolean v1, v0, Lco/vine/android/ListState;->hasNewScrollState:Z

    .line 309
    iget-object v0, p0, Lco/vine/android/BaseArrayListFragment;->mListState:Lco/vine/android/ListState;

    invoke-virtual {v0, p2}, Lco/vine/android/ListState;->setScrollState(I)V

    .line 312
    if-nez p2, :cond_0

    .line 313
    iget-object v0, p0, Lco/vine/android/BaseArrayListFragment;->mListState:Lco/vine/android/ListState;

    iget v0, v0, Lco/vine/android/ListState;->firstVisibleItem:I

    iget-object v1, p0, Lco/vine/android/BaseArrayListFragment;->mListState:Lco/vine/android/ListState;

    iget v1, v1, Lco/vine/android/ListState;->visibleItemCount:I

    iget-object v2, p0, Lco/vine/android/BaseArrayListFragment;->mListState:Lco/vine/android/ListState;

    iget v2, v2, Lco/vine/android/ListState;->totalItemCount:I

    invoke-virtual {p0, p1, v0, v1, v2}, Lco/vine/android/BaseArrayListFragment;->onScroll(Landroid/widget/AbsListView;III)V

    .line 316
    :cond_0
    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;
    .param p2, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 238
    invoke-super {p0, p1, p2}, Lco/vine/android/BaseAdapterFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 239
    iget-object v0, p0, Lco/vine/android/BaseArrayListFragment;->mHandler:Landroid/os/Handler;

    iget-object v1, p0, Lco/vine/android/BaseArrayListFragment;->mRequestFocus:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 240
    return-void
.end method

.method protected processPostOptionsResult(Lco/vine/android/PostOptionsDialogActivity$Result;)V
    .locals 1
    .param p1, "result"    # Lco/vine/android/PostOptionsDialogActivity$Result;

    .prologue
    .line 427
    iget-object v0, p1, Lco/vine/android/PostOptionsDialogActivity$Result;->request:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 428
    iget-object v0, p1, Lco/vine/android/PostOptionsDialogActivity$Result;->request:Ljava/lang/String;

    invoke-virtual {p0, v0}, Lco/vine/android/BaseArrayListFragment;->addRequest(Ljava/lang/String;)Ljava/lang/String;

    .line 430
    :cond_0
    iget-object v0, p1, Lco/vine/android/PostOptionsDialogActivity$Result;->intent:Landroid/content/Intent;

    if-eqz v0, :cond_1

    .line 431
    iget-object v0, p1, Lco/vine/android/PostOptionsDialogActivity$Result;->intent:Landroid/content/Intent;

    invoke-virtual {p0, v0}, Lco/vine/android/BaseArrayListFragment;->startActivity(Landroid/content/Intent;)V

    .line 433
    :cond_1
    return-void
.end method

.method protected refresh()V
    .locals 0

    .prologue
    .line 324
    return-void
.end method

.method protected restorePosition()V
    .locals 3

    .prologue
    .line 543
    iget-object v0, p0, Lco/vine/android/BaseArrayListFragment;->mListView:Landroid/widget/ListView;

    iget v1, p0, Lco/vine/android/BaseArrayListFragment;->mScrollPos:I

    iget v2, p0, Lco/vine/android/BaseArrayListFragment;->mScrollOffset:I

    invoke-virtual {v0, v1, v2}, Landroid/widget/ListView;->setSelectionFromTop(II)V

    .line 544
    return-void
.end method

.method protected savePosition()V
    .locals 4

    .prologue
    .line 549
    iget-object v0, p0, Lco/vine/android/BaseArrayListFragment;->mListView:Landroid/widget/ListView;

    .line 550
    .local v0, "l":Landroid/widget/ListView;
    if-eqz v0, :cond_0

    .line 552
    const/4 v3, 0x0

    invoke-virtual {v0, v3}, Landroid/widget/ListView;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    .line 554
    .local v2, "v":Landroid/view/View;
    if-eqz v2, :cond_1

    .line 555
    invoke-virtual {v2}, Landroid/view/View;->getTop()I

    move-result v1

    .line 560
    .local v1, "offset":I
    :goto_0
    invoke-virtual {v0}, Landroid/widget/ListView;->getFirstVisiblePosition()I

    move-result v3

    iput v3, p0, Lco/vine/android/BaseArrayListFragment;->mScrollPos:I

    .line 561
    iput v1, p0, Lco/vine/android/BaseArrayListFragment;->mScrollOffset:I

    .line 563
    .end local v1    # "offset":I
    .end local v2    # "v":Landroid/view/View;
    :cond_0
    return-void

    .line 557
    .restart local v2    # "v":Landroid/view/View;
    :cond_1
    const/4 v1, 0x0

    .restart local v1    # "offset":I
    goto :goto_0
.end method

.method protected setEmptyStringMessage(I)V
    .locals 2
    .param p1, "res"    # I

    .prologue
    .line 504
    iget-object v0, p0, Lco/vine/android/BaseArrayListFragment;->mEmptyText:Landroid/widget/TextView;

    invoke-virtual {p0, p1}, Lco/vine/android/BaseArrayListFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 505
    return-void
.end method

.method public setFocused(Z)V
    .locals 0
    .param p1, "focused"    # Z

    .prologue
    .line 122
    iput-boolean p1, p0, Lco/vine/android/BaseArrayListFragment;->mFocused:Z

    .line 123
    return-void
.end method

.method public setNavBottom(I)V
    .locals 1
    .param p1, "offset"    # I

    .prologue
    .line 657
    iget-object v0, p0, Lco/vine/android/BaseArrayListFragment;->mListView:Landroid/widget/ListView;

    instance-of v0, v0, Lco/vine/android/widget/PinnedHeaderListView;

    if-eqz v0, :cond_0

    .line 658
    iget-object v0, p0, Lco/vine/android/BaseArrayListFragment;->mListView:Landroid/widget/ListView;

    check-cast v0, Lco/vine/android/widget/PinnedHeaderListView;

    invoke-virtual {v0, p1}, Lco/vine/android/widget/PinnedHeaderListView;->setNavBottom(I)V

    .line 660
    :cond_0
    return-void
.end method

.method public setOwnerId(J)V
    .locals 0
    .param p1, "ownerId"    # J

    .prologue
    .line 640
    iput-wide p1, p0, Lco/vine/android/BaseArrayListFragment;->mOwnerId:J

    .line 641
    return-void
.end method

.method public setRefreshableHeaderOffset(I)V
    .locals 1
    .param p1, "offset"    # I

    .prologue
    .line 301
    iget-boolean v0, p0, Lco/vine/android/BaseArrayListFragment;->mRefreshable:Z

    if-eqz v0, :cond_0

    .line 302
    iget-object v0, p0, Lco/vine/android/BaseArrayListFragment;->mListView:Landroid/widget/ListView;

    check-cast v0, Lcom/twitter/android/widget/RefreshableListView;

    invoke-virtual {v0, p1}, Lcom/twitter/android/widget/RefreshableListView;->setViewYOffset(I)V

    .line 304
    :cond_0
    return-void
.end method

.method public setScrollListener(Lco/vine/android/widget/tabs/TabScrollListener;)V
    .locals 0
    .param p1, "listener"    # Lco/vine/android/widget/tabs/TabScrollListener;

    .prologue
    .line 614
    iput-object p1, p0, Lco/vine/android/BaseArrayListFragment;->mScrollListener:Lco/vine/android/widget/tabs/TabScrollListener;

    .line 615
    return-void
.end method

.method public showDialog(I)V
    .locals 1
    .param p1, "dialog"    # I

    .prologue
    .line 633
    invoke-virtual {p0, p1}, Lco/vine/android/BaseArrayListFragment;->onCreateDialog(I)Landroid/app/Dialog;

    move-result-object v0

    .line 634
    .local v0, "d":Landroid/app/Dialog;
    if-eqz v0, :cond_0

    .line 635
    invoke-virtual {v0}, Landroid/app/Dialog;->show()V

    .line 637
    :cond_0
    return-void
.end method

.method protected showProgress(I)V
    .locals 2
    .param p1, "progressType"    # I

    .prologue
    const/4 v1, 0x1

    .line 368
    packed-switch p1, :pswitch_data_0

    .line 394
    :cond_0
    :goto_0
    return-void

    .line 370
    :pswitch_0
    iget-boolean v0, p0, Lco/vine/android/BaseArrayListFragment;->mRefreshable:Z

    if-eqz v0, :cond_0

    .line 371
    iget-object v0, p0, Lco/vine/android/BaseArrayListFragment;->mListView:Landroid/widget/ListView;

    check-cast v0, Lcom/twitter/android/widget/RefreshableListView;

    invoke-virtual {v0, v1}, Lcom/twitter/android/widget/RefreshableListView;->refreshMore(Z)V

    goto :goto_0

    .line 378
    :pswitch_1
    iget-boolean v0, p0, Lco/vine/android/BaseArrayListFragment;->mRefreshable:Z

    if-eqz v0, :cond_0

    .line 379
    iget-object v0, p0, Lco/vine/android/BaseArrayListFragment;->mListView:Landroid/widget/ListView;

    check-cast v0, Lcom/twitter/android/widget/RefreshableListView;

    invoke-virtual {v0}, Lcom/twitter/android/widget/RefreshableListView;->startRefresh()V

    .line 380
    iput-boolean v1, p0, Lco/vine/android/BaseArrayListFragment;->mRefreshing:Z

    goto :goto_0

    .line 386
    :pswitch_2
    invoke-direct {p0, v1}, Lco/vine/android/BaseArrayListFragment;->showLoading(Z)V

    goto :goto_0

    .line 368
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_1
    .end packed-switch
.end method

.method protected showSadface(Z)V
    .locals 0
    .param p1, "show"    # Z

    .prologue
    .line 463
    invoke-virtual {p0, p1, p1}, Lco/vine/android/BaseArrayListFragment;->showSadface(ZZ)V

    .line 464
    return-void
.end method

.method protected showSadface(ZZ)V
    .locals 5
    .param p1, "show"    # Z
    .param p2, "showFrown"    # Z

    .prologue
    const/16 v2, 0x8

    const/4 v1, 0x0

    .line 467
    if-eqz p1, :cond_4

    .line 468
    iget-object v3, p0, Lco/vine/android/BaseArrayListFragment;->mListView:Landroid/widget/ListView;

    if-eqz v3, :cond_1

    iget-object v3, p0, Lco/vine/android/BaseArrayListFragment;->mSadface:Landroid/view/View;

    if-eqz v3, :cond_1

    .line 469
    iget-object v3, p0, Lco/vine/android/BaseArrayListFragment;->mEmptyProgress:Landroid/widget/ProgressBar;

    invoke-virtual {v3, v2}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 470
    iget-boolean v3, p0, Lco/vine/android/BaseArrayListFragment;->mIsSadFacePartOfHeader:Z

    if-nez v3, :cond_2

    .line 471
    iget-object v3, p0, Lco/vine/android/BaseArrayListFragment;->mListView:Landroid/widget/ListView;

    invoke-virtual {v3, v2}, Landroid/widget/ListView;->setVisibility(I)V

    .line 479
    :cond_0
    :goto_0
    iget-object v3, p0, Lco/vine/android/BaseArrayListFragment;->mSadface:Landroid/view/View;

    invoke-virtual {v3, v1}, Landroid/view/View;->setVisibility(I)V

    .line 482
    iget-object v3, p0, Lco/vine/android/BaseArrayListFragment;->mSadface:Landroid/view/View;

    const v4, 0x7f0a00e3

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 483
    .local v0, "sadFace":Landroid/view/View;
    if-eqz v0, :cond_1

    .line 484
    if-eqz p2, :cond_3

    :goto_1
    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 501
    .end local v0    # "sadFace":Landroid/view/View;
    :cond_1
    :goto_2
    return-void

    .line 473
    :cond_2
    iget-object v3, p0, Lco/vine/android/BaseArrayListFragment;->mListView:Landroid/widget/ListView;

    invoke-virtual {v3, v1}, Landroid/widget/ListView;->setVisibility(I)V

    .line 474
    iget-boolean v3, p0, Lco/vine/android/BaseArrayListFragment;->mIsSadFaceHeaderAdded:Z

    if-nez v3, :cond_0

    .line 475
    iget-object v3, p0, Lco/vine/android/BaseArrayListFragment;->mListView:Landroid/widget/ListView;

    iget-object v4, p0, Lco/vine/android/BaseArrayListFragment;->mSadface:Landroid/view/View;

    invoke-virtual {v3, v4}, Landroid/widget/ListView;->addHeaderView(Landroid/view/View;)V

    .line 476
    const/4 v3, 0x1

    iput-boolean v3, p0, Lco/vine/android/BaseArrayListFragment;->mIsSadFaceHeaderAdded:Z

    goto :goto_0

    .restart local v0    # "sadFace":Landroid/view/View;
    :cond_3
    move v1, v2

    .line 484
    goto :goto_1

    .line 488
    .end local v0    # "sadFace":Landroid/view/View;
    :cond_4
    iget-object v3, p0, Lco/vine/android/BaseArrayListFragment;->mListView:Landroid/widget/ListView;

    if-eqz v3, :cond_1

    iget-object v3, p0, Lco/vine/android/BaseArrayListFragment;->mSadface:Landroid/view/View;

    if-eqz v3, :cond_1

    .line 489
    iget-object v3, p0, Lco/vine/android/BaseArrayListFragment;->mListView:Landroid/widget/ListView;

    invoke-virtual {v3, v1}, Landroid/widget/ListView;->setVisibility(I)V

    .line 490
    iget-boolean v3, p0, Lco/vine/android/BaseArrayListFragment;->mIsSadFacePartOfHeader:Z

    if-eqz v3, :cond_5

    .line 491
    iget-boolean v3, p0, Lco/vine/android/BaseArrayListFragment;->mIsSadFaceHeaderAdded:Z

    if-eqz v3, :cond_1

    .line 492
    iget-object v3, p0, Lco/vine/android/BaseArrayListFragment;->mListView:Landroid/widget/ListView;

    iget-object v4, p0, Lco/vine/android/BaseArrayListFragment;->mSadface:Landroid/view/View;

    invoke-virtual {v3, v4}, Landroid/widget/ListView;->removeHeaderView(Landroid/view/View;)Z

    .line 493
    iget-object v3, p0, Lco/vine/android/BaseArrayListFragment;->mSadface:Landroid/view/View;

    invoke-virtual {v3, v2}, Landroid/view/View;->setVisibility(I)V

    .line 494
    iput-boolean v1, p0, Lco/vine/android/BaseArrayListFragment;->mIsSadFacePartOfHeader:Z

    goto :goto_2

    .line 497
    :cond_5
    iget-object v1, p0, Lco/vine/android/BaseArrayListFragment;->mSadface:Landroid/view/View;

    invoke-virtual {v1, v2}, Landroid/view/View;->setVisibility(I)V

    goto :goto_2
.end method
