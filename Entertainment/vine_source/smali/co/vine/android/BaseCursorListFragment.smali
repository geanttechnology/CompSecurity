.class public Lco/vine/android/BaseCursorListFragment;
.super Lco/vine/android/BaseCursorAdapterFragment;
.source "BaseCursorListFragment.java"

# interfaces
.implements Landroid/widget/AbsListView$OnScrollListener;
.implements Lco/vine/android/widget/OnTabChangedListener;
.implements Lcom/twitter/android/widget/RefreshListener;


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
.field protected mBgColor:I

.field protected mChoiceMode:I

.field private mEmptyProgress:Landroid/widget/ProgressBar;

.field protected mEmptyText:Landroid/widget/TextView;

.field protected mEmptyTextStringRes:I

.field private mEmptyView:Landroid/view/View;

.field protected mFocused:Z

.field private mIsSadFaceHeaderAdded:Z

.field private mIsSadFacePartOfHeader:Z

.field protected mListState:Lco/vine/android/ListState;

.field protected mListView:Landroid/widget/ListView;

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
    .locals 1

    .prologue
    .line 40
    invoke-direct {p0}, Lco/vine/android/BaseCursorAdapterFragment;-><init>()V

    .line 74
    new-instance v0, Lco/vine/android/BaseCursorListFragment$1;

    invoke-direct {v0, p0}, Lco/vine/android/BaseCursorListFragment$1;-><init>(Lco/vine/android/BaseCursorListFragment;)V

    iput-object v0, p0, Lco/vine/android/BaseCursorListFragment;->mOnItemClickListener:Landroid/widget/AdapterView$OnItemClickListener;

    .line 81
    new-instance v0, Lco/vine/android/BaseCursorListFragment$2;

    invoke-direct {v0, p0}, Lco/vine/android/BaseCursorListFragment$2;-><init>(Lco/vine/android/BaseCursorListFragment;)V

    iput-object v0, p0, Lco/vine/android/BaseCursorListFragment;->mOnItemLongClickListenerClickListener:Landroid/widget/AdapterView$OnItemLongClickListener;

    .line 88
    new-instance v0, Lco/vine/android/BaseCursorListFragment$3;

    invoke-direct {v0, p0}, Lco/vine/android/BaseCursorListFragment$3;-><init>(Lco/vine/android/BaseCursorListFragment;)V

    iput-object v0, p0, Lco/vine/android/BaseCursorListFragment;->mRequestFocus:Ljava/lang/Runnable;

    return-void
.end method

.method public static prepareArguments(Landroid/content/Intent;Z)Landroid/os/Bundle;
    .locals 3
    .param p0, "intent"    # Landroid/content/Intent;
    .param p1, "refreshable"    # Z

    .prologue
    .line 666
    invoke-virtual {p0}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 667
    .local v0, "args":Landroid/os/Bundle;
    if-nez v0, :cond_0

    .line 668
    new-instance v0, Landroid/os/Bundle;

    .end local v0    # "args":Landroid/os/Bundle;
    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 670
    .restart local v0    # "args":Landroid/os/Bundle;
    :cond_0
    const-string v1, "data"

    invoke-virtual {p0}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 671
    const-string v1, "refresh"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 672
    return-object v0
.end method

.method private showLoading(Z)V
    .locals 4
    .param p1, "show"    # Z

    .prologue
    const/4 v3, 0x0

    const/16 v2, 0x8

    .line 429
    if-eqz p1, :cond_2

    .line 430
    iget-object v0, p0, Lco/vine/android/BaseCursorListFragment;->mListView:Landroid/widget/ListView;

    .line 431
    .local v0, "l":Landroid/widget/ListView;
    invoke-virtual {v0, v2}, Landroid/widget/ListView;->setVisibility(I)V

    .line 432
    iget-object v1, p0, Lco/vine/android/BaseCursorListFragment;->mSadface:Landroid/view/View;

    if-eqz v1, :cond_0

    .line 433
    iget-object v1, p0, Lco/vine/android/BaseCursorListFragment;->mSadface:Landroid/view/View;

    invoke-virtual {v1, v2}, Landroid/view/View;->setVisibility(I)V

    .line 435
    :cond_0
    iget-object v1, p0, Lco/vine/android/BaseCursorListFragment;->mEmptyProgress:Landroid/widget/ProgressBar;

    if-eqz v1, :cond_1

    .line 436
    iget-object v1, p0, Lco/vine/android/BaseCursorListFragment;->mEmptyProgress:Landroid/widget/ProgressBar;

    invoke-virtual {v1, v3}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 448
    :cond_1
    :goto_0
    return-void

    .line 439
    .end local v0    # "l":Landroid/widget/ListView;
    :cond_2
    iget-object v0, p0, Lco/vine/android/BaseCursorListFragment;->mListView:Landroid/widget/ListView;

    .line 440
    .restart local v0    # "l":Landroid/widget/ListView;
    invoke-virtual {p0}, Lco/vine/android/BaseCursorListFragment;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_3

    .line 441
    invoke-virtual {v0, v3}, Landroid/widget/ListView;->setVisibility(I)V

    goto :goto_0

    .line 443
    :cond_3
    iget-object v1, p0, Lco/vine/android/BaseCursorListFragment;->mEmptyProgress:Landroid/widget/ProgressBar;

    if-eqz v1, :cond_1

    .line 444
    iget-object v1, p0, Lco/vine/android/BaseCursorListFragment;->mEmptyProgress:Landroid/widget/ProgressBar;

    invoke-virtual {v1, v2}, Landroid/widget/ProgressBar;->setVisibility(I)V

    goto :goto_0
.end method


# virtual methods
.method protected createDefaultView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 1
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;

    .prologue
    .line 209
    const v0, 0x7f03005f

    invoke-virtual {p0, p1, v0, p2}, Lco/vine/android/BaseCursorListFragment;->createView(Landroid/view/LayoutInflater;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public createView(Landroid/view/LayoutInflater;ILandroid/view/ViewGroup;)Landroid/view/View;
    .locals 6
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "layout"    # I
    .param p3, "container"    # Landroid/view/ViewGroup;

    .prologue
    .line 166
    const/4 v4, 0x0

    invoke-virtual {p1, p2, p3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v3

    .line 168
    .local v3, "v":Landroid/view/View;
    iput-object v3, p0, Lco/vine/android/BaseCursorListFragment;->mRootView:Landroid/view/View;

    .line 170
    const v4, 0x102000a

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ListView;

    .line 171
    .local v2, "listView":Landroid/widget/ListView;
    iget-object v4, p0, Lco/vine/android/BaseCursorListFragment;->mOnItemClickListener:Landroid/widget/AdapterView$OnItemClickListener;

    invoke-virtual {v2, v4}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 172
    iget-object v4, p0, Lco/vine/android/BaseCursorListFragment;->mOnItemLongClickListenerClickListener:Landroid/widget/AdapterView$OnItemLongClickListener;

    invoke-virtual {v2, v4}, Landroid/widget/ListView;->setOnItemLongClickListener(Landroid/widget/AdapterView$OnItemLongClickListener;)V

    .line 173
    const/4 v4, 0x1

    invoke-virtual {v2, v4}, Landroid/widget/ListView;->setScrollbarFadingEnabled(Z)V

    .line 174
    invoke-virtual {v2, p0}, Landroid/widget/ListView;->setOnScrollListener(Landroid/widget/AbsListView$OnScrollListener;)V

    .line 175
    iget v4, p0, Lco/vine/android/BaseCursorListFragment;->mChoiceMode:I

    invoke-virtual {v2, v4}, Landroid/widget/ListView;->setChoiceMode(I)V

    .line 176
    iget v0, p0, Lco/vine/android/BaseCursorListFragment;->mBgColor:I

    .line 177
    .local v0, "bgColor":I
    if-eqz v0, :cond_0

    .line 178
    invoke-virtual {v2, v0}, Landroid/widget/ListView;->setBackgroundColor(I)V

    .line 179
    invoke-virtual {v2, v0}, Landroid/widget/ListView;->setCacheColorHint(I)V

    .line 182
    :cond_0
    const v4, 0x1020004

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    .line 183
    .local v1, "emptyView":Landroid/view/View;
    if-eqz v1, :cond_1

    .line 184
    invoke-virtual {v2, v1}, Landroid/widget/ListView;->setEmptyView(Landroid/view/View;)V

    .line 185
    const v4, 0x7f0a00f1

    invoke-virtual {v1, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/ProgressBar;

    iput-object v4, p0, Lco/vine/android/BaseCursorListFragment;->mEmptyProgress:Landroid/widget/ProgressBar;

    .line 188
    :cond_1
    iput-object v1, p0, Lco/vine/android/BaseCursorListFragment;->mEmptyView:Landroid/view/View;

    .line 190
    const v4, 0x7f0a007f

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/TextView;

    iput-object v4, p0, Lco/vine/android/BaseCursorListFragment;->mEmptyText:Landroid/widget/TextView;

    .line 191
    iget v4, p0, Lco/vine/android/BaseCursorListFragment;->mEmptyTextStringRes:I

    if-lez v4, :cond_2

    .line 192
    iget-object v4, p0, Lco/vine/android/BaseCursorListFragment;->mEmptyText:Landroid/widget/TextView;

    if-eqz v4, :cond_2

    .line 193
    iget-object v4, p0, Lco/vine/android/BaseCursorListFragment;->mEmptyText:Landroid/widget/TextView;

    iget v5, p0, Lco/vine/android/BaseCursorListFragment;->mEmptyTextStringRes:I

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(I)V

    .line 197
    :cond_2
    const v4, 0x7f0a007e

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    iput-object v4, p0, Lco/vine/android/BaseCursorListFragment;->mSadface:Landroid/view/View;

    .line 199
    iget-boolean v4, p0, Lco/vine/android/BaseCursorListFragment;->mRefreshable:Z

    if-eqz v4, :cond_3

    move-object v4, v2

    .line 200
    check-cast v4, Lcom/twitter/android/widget/RefreshableListView;

    invoke-virtual {v4, p0}, Lcom/twitter/android/widget/RefreshableListView;->setRefreshListener(Lcom/twitter/android/widget/RefreshListener;)V

    .line 203
    :cond_3
    iput-object v2, p0, Lco/vine/android/BaseCursorListFragment;->mListView:Landroid/widget/ListView;

    .line 205
    return-object v3
.end method

.method public getFirstItemPosition()Lcom/twitter/android/widget/ItemPosition;
    .locals 9

    .prologue
    const/4 v5, 0x0

    .line 628
    iget-object v3, p0, Lco/vine/android/BaseCursorListFragment;->mListView:Landroid/widget/ListView;

    .line 629
    .local v3, "l":Landroid/widget/ListView;
    invoke-virtual {v3}, Landroid/widget/ListView;->getCount()I

    move-result v6

    const/4 v7, 0x1

    if-ge v6, v7, :cond_0

    const/4 v5, 0x0

    .line 648
    :goto_0
    return-object v5

    .line 630
    :cond_0
    invoke-virtual {v3}, Landroid/widget/ListView;->getFirstVisiblePosition()I

    move-result v1

    .line 631
    .local v1, "firstPos":I
    invoke-virtual {v3}, Landroid/widget/ListView;->getHeaderViewsCount()I

    move-result v2

    .line 633
    .local v2, "headerCount":I
    iget-boolean v6, p0, Lco/vine/android/BaseCursorListFragment;->mRefreshing:Z

    if-eqz v6, :cond_1

    .line 634
    add-int/lit8 v2, v2, 0x1

    .line 640
    :cond_1
    if-ge v1, v2, :cond_3

    .line 641
    move v4, v2

    .line 642
    .local v4, "position":I
    sub-int v6, v4, v1

    invoke-virtual {v3, v6}, Landroid/widget/ListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 648
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

    .line 644
    .end local v0    # "child":Landroid/view/View;
    .end local v4    # "position":I
    :cond_3
    move v4, v1

    .line 645
    .restart local v4    # "position":I
    invoke-virtual {v3, v5}, Landroid/widget/ListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .restart local v0    # "child":Landroid/view/View;
    goto :goto_1
.end method

.method protected getIdColumnIndex()I
    .locals 1

    .prologue
    .line 580
    const/4 v0, -0x1

    return v0
.end method

.method public getPositionForItemId(J)I
    .locals 5
    .param p1, "id"    # J

    .prologue
    .line 545
    invoke-virtual {p0}, Lco/vine/android/BaseCursorListFragment;->getIdColumnIndex()I

    move-result v1

    .line 547
    .local v1, "idColumnIndex":I
    if-ltz v1, :cond_3

    .line 548
    iget-object v3, p0, Lco/vine/android/BaseCursorListFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    invoke-virtual {v3}, Landroid/support/v4/widget/CursorAdapter;->getCursor()Landroid/database/Cursor;

    move-result-object v0

    .line 549
    .local v0, "cursor":Landroid/database/Cursor;
    if-eqz v0, :cond_3

    .line 550
    invoke-interface {v0}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v3

    if-eqz v3, :cond_3

    .line 552
    :cond_0
    invoke-interface {v0, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v3

    cmp-long v3, v3, p1

    if-nez v3, :cond_2

    .line 553
    invoke-interface {v0}, Landroid/database/Cursor;->getPosition()I

    move-result v3

    iget-object v4, p0, Lco/vine/android/BaseCursorListFragment;->mListView:Landroid/widget/ListView;

    invoke-virtual {v4}, Landroid/widget/ListView;->getHeaderViewsCount()I

    move-result v4

    add-int v2, v3, v4

    .line 558
    .local v2, "pos":I
    iget-boolean v3, p0, Lco/vine/android/BaseCursorListFragment;->mRefreshing:Z

    if-eqz v3, :cond_1

    .line 559
    add-int/lit8 v2, v2, 0x1

    .line 568
    .end local v0    # "cursor":Landroid/database/Cursor;
    .end local v2    # "pos":I
    :cond_1
    :goto_0
    return v2

    .line 563
    .restart local v0    # "cursor":Landroid/database/Cursor;
    :cond_2
    invoke-interface {v0}, Landroid/database/Cursor;->moveToNext()Z

    move-result v3

    if-nez v3, :cond_0

    .line 568
    .end local v0    # "cursor":Landroid/database/Cursor;
    :cond_3
    const/4 v2, 0x0

    goto :goto_0
.end method

.method public getRootView()Landroid/view/View;
    .locals 1

    .prologue
    .line 162
    iget-object v0, p0, Lco/vine/android/BaseCursorListFragment;->mRootView:Landroid/view/View;

    return-object v0
.end method

.method protected handleContentChanged()V
    .locals 0

    .prologue
    .line 533
    invoke-virtual {p0}, Lco/vine/android/BaseCursorListFragment;->onContentChanged()V

    .line 538
    return-void
.end method

.method protected hideProgress(I)V
    .locals 2
    .param p1, "progressType"    # I

    .prologue
    const/4 v1, 0x0

    .line 384
    packed-switch p1, :pswitch_data_0

    .line 412
    :cond_0
    :goto_0
    return-void

    .line 387
    :pswitch_0
    invoke-direct {p0, v1}, Lco/vine/android/BaseCursorListFragment;->showLoading(Z)V

    goto :goto_0

    .line 393
    :pswitch_1
    invoke-direct {p0, v1}, Lco/vine/android/BaseCursorListFragment;->showLoading(Z)V

    .line 394
    iget-boolean v0, p0, Lco/vine/android/BaseCursorListFragment;->mRefreshable:Z

    if-eqz v0, :cond_0

    .line 395
    iget-object v0, p0, Lco/vine/android/BaseCursorListFragment;->mListView:Landroid/widget/ListView;

    check-cast v0, Lcom/twitter/android/widget/RefreshableListView;

    invoke-virtual {v0}, Lcom/twitter/android/widget/RefreshableListView;->stopRefresh()V

    .line 396
    iput-boolean v1, p0, Lco/vine/android/BaseCursorListFragment;->mRefreshing:Z

    goto :goto_0

    .line 402
    :pswitch_2
    iget-boolean v0, p0, Lco/vine/android/BaseCursorListFragment;->mRefreshable:Z

    if-eqz v0, :cond_0

    .line 403
    iget-object v0, p0, Lco/vine/android/BaseCursorListFragment;->mListView:Landroid/widget/ListView;

    check-cast v0, Lcom/twitter/android/widget/RefreshableListView;

    invoke-virtual {v0, v1}, Lcom/twitter/android/widget/RefreshableListView;->refreshMore(Z)V

    goto :goto_0

    .line 384
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_2
        :pswitch_1
        :pswitch_0
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method invokeScrollFirstItem()V
    .locals 1

    .prologue
    .line 653
    iget-object v0, p0, Lco/vine/android/BaseCursorListFragment;->mScrollListener:Lco/vine/android/widget/tabs/TabScrollListener;

    if-eqz v0, :cond_0

    .line 654
    iget-object v0, p0, Lco/vine/android/BaseCursorListFragment;->mScrollListener:Lco/vine/android/widget/tabs/TabScrollListener;

    invoke-virtual {v0}, Lco/vine/android/widget/tabs/TabScrollListener;->onScrollFirstItem()V

    .line 656
    :cond_0
    return-void
.end method

.method protected isEmpty()Z
    .locals 3

    .prologue
    .line 424
    iget-object v0, p0, Lco/vine/android/BaseCursorListFragment;->mListView:Landroid/widget/ListView;

    .line 425
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
    .line 109
    iget-boolean v0, p0, Lco/vine/android/BaseCursorListFragment;->mFocused:Z

    return v0
.end method

.method public isSadFacePartOfHeader()Z
    .locals 1

    .prologue
    .line 124
    iget-boolean v0, p0, Lco/vine/android/BaseCursorListFragment;->mIsSadFacePartOfHeader:Z

    return v0
.end method

.method public declared-synchronized makeSadFaceHeaderView()V
    .locals 8

    .prologue
    .line 312
    monitor-enter p0

    :try_start_0
    iget-boolean v4, p0, Lco/vine/android/BaseCursorListFragment;->mIsSadFacePartOfHeader:Z

    if-nez v4, :cond_2

    .line 313
    const/4 v4, 0x1

    iput-boolean v4, p0, Lco/vine/android/BaseCursorListFragment;->mIsSadFacePartOfHeader:Z

    .line 314
    const/4 v4, 0x1

    iput-boolean v4, p0, Lco/vine/android/BaseCursorListFragment;->mIsSadFaceHeaderAdded:Z

    .line 315
    iget-object v4, p0, Lco/vine/android/BaseCursorListFragment;->mSadface:Landroid/view/View;

    if-eqz v4, :cond_2

    .line 316
    const/4 v0, 0x0

    .line 317
    .local v0, "alreadyAttached":Z
    iget-object v4, p0, Lco/vine/android/BaseCursorListFragment;->mSadface:Landroid/view/View;

    invoke-virtual {v4}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v3

    .line 318
    .local v3, "parent":Landroid/view/ViewParent;
    if-eqz v3, :cond_0

    .line 319
    instance-of v4, v3, Landroid/view/ViewGroup;

    if-eqz v4, :cond_4

    .line 320
    iget-object v4, p0, Lco/vine/android/BaseCursorListFragment;->mListView:Landroid/widget/ListView;

    if-eq v3, v4, :cond_3

    .line 321
    check-cast v3, Landroid/view/ViewGroup;

    .end local v3    # "parent":Landroid/view/ViewParent;
    iget-object v4, p0, Lco/vine/android/BaseCursorListFragment;->mSadface:Landroid/view/View;

    invoke-virtual {v3, v4}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    .line 329
    :cond_0
    :goto_0
    if-nez v0, :cond_2

    .line 330
    iget-object v4, p0, Lco/vine/android/BaseCursorListFragment;->mSadface:Landroid/view/View;

    invoke-virtual {v4}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    .line 331
    .local v1, "params":Landroid/view/ViewGroup$LayoutParams;
    if-eqz v1, :cond_1

    .line 332
    new-instance v2, Landroid/widget/AbsListView$LayoutParams;

    iget v4, v1, Landroid/view/ViewGroup$LayoutParams;->width:I

    iget v5, v1, Landroid/view/ViewGroup$LayoutParams;->height:I

    invoke-direct {v2, v4, v5}, Landroid/widget/AbsListView$LayoutParams;-><init>(II)V

    .line 333
    .end local v1    # "params":Landroid/view/ViewGroup$LayoutParams;
    .local v2, "params":Landroid/view/ViewGroup$LayoutParams;
    iget-object v4, p0, Lco/vine/android/BaseCursorListFragment;->mSadface:Landroid/view/View;

    invoke-virtual {v4, v2}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    move-object v1, v2

    .line 335
    .end local v2    # "params":Landroid/view/ViewGroup$LayoutParams;
    .restart local v1    # "params":Landroid/view/ViewGroup$LayoutParams;
    :cond_1
    iget-object v4, p0, Lco/vine/android/BaseCursorListFragment;->mListView:Landroid/widget/ListView;

    iget-object v5, p0, Lco/vine/android/BaseCursorListFragment;->mSadface:Landroid/view/View;

    const/4 v6, 0x0

    const/4 v7, 0x0

    invoke-virtual {v4, v5, v6, v7}, Landroid/widget/ListView;->addHeaderView(Landroid/view/View;Ljava/lang/Object;Z)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 339
    .end local v0    # "alreadyAttached":Z
    .end local v1    # "params":Landroid/view/ViewGroup$LayoutParams;
    :cond_2
    monitor-exit p0

    return-void

    .line 323
    .restart local v0    # "alreadyAttached":Z
    .restart local v3    # "parent":Landroid/view/ViewParent;
    :cond_3
    const/4 v0, 0x1

    goto :goto_0

    .line 326
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

    .line 312
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
    .line 707
    iget-object v0, p0, Lco/vine/android/BaseCursorListFragment;->mPendingRequestHelper:Lco/vine/android/PendingRequestHelper;

    invoke-virtual {v0, p1, p2, p3}, Lco/vine/android/PendingRequestHelper;->onActivityResult(IILandroid/content/Intent;)Z

    .line 708
    return-void
.end method

.method protected onContentChanged()V
    .locals 0

    .prologue
    .line 541
    invoke-virtual {p0}, Lco/vine/android/BaseCursorListFragment;->onRefreshFinished()V

    .line 542
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 5
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v2, 0x1

    const/4 v4, 0x0

    .line 130
    invoke-super {p0, p1}, Lco/vine/android/BaseCursorAdapterFragment;->onCreate(Landroid/os/Bundle;)V

    .line 132
    new-instance v1, Lco/vine/android/ListState;

    invoke-direct {v1}, Lco/vine/android/ListState;-><init>()V

    iput-object v1, p0, Lco/vine/android/BaseCursorListFragment;->mListState:Lco/vine/android/ListState;

    .line 134
    if-eqz p1, :cond_1

    .line 135
    const-string v1, "scroll_pos"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v1

    iput v1, p0, Lco/vine/android/BaseCursorListFragment;->mScrollPos:I

    .line 136
    const-string v1, "scroll_off"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v1

    iput v1, p0, Lco/vine/android/BaseCursorListFragment;->mScrollOffset:I

    .line 137
    iget-object v1, p0, Lco/vine/android/BaseCursorListFragment;->mPendingRequestHelper:Lco/vine/android/PendingRequestHelper;

    invoke-virtual {v1, p1}, Lco/vine/android/PendingRequestHelper;->restorePendingCaptchaRequest(Landroid/os/Bundle;)V

    .line 143
    :goto_0
    invoke-virtual {p0}, Lco/vine/android/BaseCursorListFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    .line 144
    .local v0, "args":Landroid/os/Bundle;
    if-eqz v0, :cond_2

    .line 145
    const-string v1, "refresh"

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    iput-boolean v1, p0, Lco/vine/android/BaseCursorListFragment;->mRefreshable:Z

    .line 146
    const-string v1, "owner_id"

    iget-object v2, p0, Lco/vine/android/BaseCursorListFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v2}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v2

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Bundle;->getLong(Ljava/lang/String;J)J

    move-result-wide v1

    iput-wide v1, p0, Lco/vine/android/BaseCursorListFragment;->mOwnerId:J

    .line 148
    const-string v1, "chmode"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 149
    const-string v1, "chmode"

    invoke-virtual {v0, v1, v4}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v1

    iput v1, p0, Lco/vine/android/BaseCursorListFragment;->mChoiceMode:I

    .line 151
    :cond_0
    const-string v1, "bg_color"

    invoke-virtual {v0, v1, v4}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v1

    iput v1, p0, Lco/vine/android/BaseCursorListFragment;->mBgColor:I

    .line 152
    const-string v1, "empty_desc"

    invoke-virtual {v0, v1, v4}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v1

    iput v1, p0, Lco/vine/android/BaseCursorListFragment;->mEmptyTextStringRes:I

    .line 159
    :goto_1
    return-void

    .line 139
    .end local v0    # "args":Landroid/os/Bundle;
    :cond_1
    iput v4, p0, Lco/vine/android/BaseCursorListFragment;->mScrollPos:I

    .line 140
    iput v4, p0, Lco/vine/android/BaseCursorListFragment;->mScrollOffset:I

    goto :goto_0

    .line 154
    .restart local v0    # "args":Landroid/os/Bundle;
    :cond_2
    iput-boolean v2, p0, Lco/vine/android/BaseCursorListFragment;->mRefreshable:Z

    .line 155
    iget-object v1, p0, Lco/vine/android/BaseCursorListFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v1}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v1

    iput-wide v1, p0, Lco/vine/android/BaseCursorListFragment;->mOwnerId:J

    .line 156
    iput v4, p0, Lco/vine/android/BaseCursorListFragment;->mChoiceMode:I

    .line 157
    iput v4, p0, Lco/vine/android/BaseCursorListFragment;->mBgColor:I

    goto :goto_1
.end method

.method protected onCreateDialog(I)Landroid/app/Dialog;
    .locals 1
    .param p1, "dialog"    # I

    .prologue
    .line 686
    const/4 v0, 0x0

    return-object v0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 1
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 216
    invoke-virtual {p0, p1, p2}, Lco/vine/android/BaseCursorListFragment;->createDefaultView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onDestroyView()V
    .locals 2

    .prologue
    .line 227
    iget-object v0, p0, Lco/vine/android/BaseCursorListFragment;->mHandler:Landroid/os/Handler;

    iget-object v1, p0, Lco/vine/android/BaseCursorListFragment;->mRequestFocus:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 228
    invoke-super {p0}, Lco/vine/android/BaseCursorAdapterFragment;->onDestroyView()V

    .line 229
    return-void
.end method

.method protected onListItemClick(Landroid/widget/ListView;Landroid/view/View;IJ)V
    .locals 0
    .param p1, "l"    # Landroid/widget/ListView;
    .param p2, "v"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "id"    # J

    .prologue
    .line 117
    return-void
.end method

.method protected onListItemLongClick(Landroid/widget/ListView;Landroid/view/View;IJ)Z
    .locals 1
    .param p1, "parent"    # Landroid/widget/ListView;
    .param p2, "view"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "id"    # J

    .prologue
    .line 120
    const/4 v0, 0x0

    return v0
.end method

.method public onMoveAway(I)V
    .locals 1
    .param p1, "newPosition"    # I

    .prologue
    .line 100
    const/4 v0, 0x0

    iput-boolean v0, p0, Lco/vine/android/BaseCursorListFragment;->mFocused:Z

    .line 101
    return-void
.end method

.method public onMoveTo(I)V
    .locals 1
    .param p1, "oldPosition"    # I

    .prologue
    .line 105
    const/4 v0, 0x1

    iput-boolean v0, p0, Lco/vine/android/BaseCursorListFragment;->mFocused:Z

    .line 106
    return-void
.end method

.method public onPause()V
    .locals 0

    .prologue
    .line 240
    invoke-super {p0}, Lco/vine/android/BaseCursorAdapterFragment;->onPause()V

    .line 241
    invoke-virtual {p0}, Lco/vine/android/BaseCursorListFragment;->savePosition()V

    .line 242
    return-void
.end method

.method public onRefreshCancelled()V
    .locals 0

    .prologue
    .line 500
    return-void
.end method

.method public onRefreshFinished()V
    .locals 2

    .prologue
    .line 516
    iget-object v0, p0, Lco/vine/android/BaseCursorListFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    .line 518
    .local v0, "adapter":Landroid/support/v4/widget/CursorAdapter;
    if-eqz v0, :cond_0

    .line 519
    invoke-virtual {v0}, Landroid/support/v4/widget/CursorAdapter;->getCursor()Landroid/database/Cursor;

    move-result-object v1

    .line 520
    .local v1, "cursor":Landroid/database/Cursor;
    if-eqz v1, :cond_0

    .line 524
    .end local v1    # "cursor":Landroid/database/Cursor;
    :cond_0
    return-void
.end method

.method public onRefreshFinishedNewData()V
    .locals 0

    .prologue
    .line 510
    return-void
.end method

.method public onRefreshFinishedNoChange()V
    .locals 0

    .prologue
    .line 513
    return-void
.end method

.method public onRefreshPulled()V
    .locals 0

    .prologue
    .line 496
    return-void
.end method

.method public onRefreshReleased(Z)V
    .locals 1
    .param p1, "shouldStartRefresh"    # Z

    .prologue
    .line 503
    if-eqz p1, :cond_0

    .line 504
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lco/vine/android/util/FlurryUtils;->trackValidPullToRefreshRelease(Ljava/lang/String;)V

    .line 505
    invoke-virtual {p0}, Lco/vine/android/BaseCursorListFragment;->refresh()V

    .line 507
    :cond_0
    return-void
.end method

.method public onResume()V
    .locals 1

    .prologue
    .line 233
    invoke-super {p0}, Lco/vine/android/BaseCursorAdapterFragment;->onResume()V

    .line 234
    invoke-virtual {p0}, Lco/vine/android/BaseCursorListFragment;->restorePosition()V

    .line 235
    iget-object v0, p0, Lco/vine/android/BaseCursorListFragment;->mPendingRequestHelper:Lco/vine/android/PendingRequestHelper;

    invoke-virtual {v0}, Lco/vine/android/PendingRequestHelper;->handlePendingCaptchaRequest()V

    .line 236
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 246
    invoke-super {p0, p1}, Lco/vine/android/BaseCursorAdapterFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 247
    invoke-virtual {p0}, Lco/vine/android/BaseCursorListFragment;->savePosition()V

    .line 248
    const-string v0, "scroll_pos"

    iget v1, p0, Lco/vine/android/BaseCursorListFragment;->mScrollPos:I

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 249
    const-string v0, "scroll_off"

    iget v1, p0, Lco/vine/android/BaseCursorListFragment;->mScrollOffset:I

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 250
    return-void
.end method

.method public onScroll(Landroid/widget/AbsListView;III)V
    .locals 4
    .param p1, "view"    # Landroid/widget/AbsListView;
    .param p2, "firstVisibleItem"    # I
    .param p3, "visibleItemCount"    # I
    .param p4, "totalItemCount"    # I

    .prologue
    .line 256
    iget-object v2, p0, Lco/vine/android/BaseCursorListFragment;->mListState:Lco/vine/android/ListState;

    iput p2, v2, Lco/vine/android/ListState;->firstVisibleItem:I

    .line 257
    iget-object v2, p0, Lco/vine/android/BaseCursorListFragment;->mListState:Lco/vine/android/ListState;

    iput p3, v2, Lco/vine/android/ListState;->visibleItemCount:I

    .line 258
    iget-object v2, p0, Lco/vine/android/BaseCursorListFragment;->mListState:Lco/vine/android/ListState;

    iput p4, v2, Lco/vine/android/ListState;->totalItemCount:I

    .line 260
    if-nez p3, :cond_1

    .line 283
    :cond_0
    :goto_0
    return-void

    .line 264
    :cond_1
    if-nez p2, :cond_2

    .line 265
    iget-object v2, p0, Lco/vine/android/BaseCursorListFragment;->mScrollListener:Lco/vine/android/widget/tabs/TabScrollListener;

    if-eqz v2, :cond_2

    .line 266
    iget-object v2, p0, Lco/vine/android/BaseCursorListFragment;->mScrollListener:Lco/vine/android/widget/tabs/TabScrollListener;

    invoke-virtual {v2}, Lco/vine/android/widget/tabs/TabScrollListener;->onScrollFirstItem()V

    .line 270
    :cond_2
    if-lez p2, :cond_0

    iget-object v2, p0, Lco/vine/android/BaseCursorListFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    if-eqz v2, :cond_0

    .line 271
    add-int v1, p2, p3

    .line 273
    .local v1, "position":I
    add-int/lit8 v2, p4, -0x1

    if-lt v1, v2, :cond_0

    iget-object v2, p0, Lco/vine/android/BaseCursorListFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    invoke-virtual {v2}, Landroid/support/v4/widget/CursorAdapter;->getCount()I

    move-result v2

    if-lez v2, :cond_0

    .line 274
    iget-object v2, p0, Lco/vine/android/BaseCursorListFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    invoke-virtual {v2}, Landroid/support/v4/widget/CursorAdapter;->getCursor()Landroid/database/Cursor;

    move-result-object v0

    .line 275
    .local v0, "cursor":Landroid/database/Cursor;
    if-eqz v0, :cond_0

    .line 276
    invoke-interface {v0}, Landroid/database/Cursor;->moveToLast()Z

    move-result v2

    if-eqz v2, :cond_0

    iget-object v2, p0, Lco/vine/android/BaseCursorListFragment;->mListState:Lco/vine/android/ListState;

    iget-boolean v2, v2, Lco/vine/android/ListState;->hasNewScrollState:Z

    if-eqz v2, :cond_0

    .line 277
    iget-object v2, p0, Lco/vine/android/BaseCursorListFragment;->mListState:Lco/vine/android/ListState;

    const/4 v3, 0x0

    iput-boolean v3, v2, Lco/vine/android/ListState;->hasNewScrollState:Z

    .line 278
    invoke-virtual {p0, v0}, Lco/vine/android/BaseCursorListFragment;->onScrollLastItem(Landroid/database/Cursor;)V

    goto :goto_0
.end method

.method protected onScrollLastItem(Landroid/database/Cursor;)V
    .locals 0
    .param p1, "cursor"    # Landroid/database/Cursor;

    .prologue
    .line 345
    return-void
.end method

.method public onScrollStateChanged(Landroid/widget/AbsListView;I)V
    .locals 3
    .param p1, "view"    # Landroid/widget/AbsListView;
    .param p2, "scrollState"    # I

    .prologue
    .line 293
    iget-object v0, p0, Lco/vine/android/BaseCursorListFragment;->mListState:Lco/vine/android/ListState;

    const/4 v1, 0x1

    iput-boolean v1, v0, Lco/vine/android/ListState;->hasNewScrollState:Z

    .line 294
    iget-object v0, p0, Lco/vine/android/BaseCursorListFragment;->mListState:Lco/vine/android/ListState;

    invoke-virtual {v0, p2}, Lco/vine/android/ListState;->setScrollState(I)V

    .line 297
    if-nez p2, :cond_0

    .line 298
    iget-object v0, p0, Lco/vine/android/BaseCursorListFragment;->mListState:Lco/vine/android/ListState;

    iget v0, v0, Lco/vine/android/ListState;->firstVisibleItem:I

    iget-object v1, p0, Lco/vine/android/BaseCursorListFragment;->mListState:Lco/vine/android/ListState;

    iget v1, v1, Lco/vine/android/ListState;->visibleItemCount:I

    iget-object v2, p0, Lco/vine/android/BaseCursorListFragment;->mListState:Lco/vine/android/ListState;

    iget v2, v2, Lco/vine/android/ListState;->totalItemCount:I

    invoke-virtual {p0, p1, v0, v1, v2}, Lco/vine/android/BaseCursorListFragment;->onScroll(Landroid/widget/AbsListView;III)V

    .line 301
    :cond_0
    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;
    .param p2, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 221
    invoke-super {p0, p1, p2}, Lco/vine/android/BaseCursorAdapterFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 222
    iget-object v0, p0, Lco/vine/android/BaseCursorListFragment;->mHandler:Landroid/os/Handler;

    iget-object v1, p0, Lco/vine/android/BaseCursorListFragment;->mRequestFocus:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 223
    return-void
.end method

.method protected processPostOptionsResult(Lco/vine/android/PostOptionsDialogActivity$Result;)V
    .locals 1
    .param p1, "result"    # Lco/vine/android/PostOptionsDialogActivity$Result;

    .prologue
    .line 415
    iget-object v0, p1, Lco/vine/android/PostOptionsDialogActivity$Result;->request:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 416
    iget-object v0, p1, Lco/vine/android/PostOptionsDialogActivity$Result;->request:Ljava/lang/String;

    invoke-virtual {p0, v0}, Lco/vine/android/BaseCursorListFragment;->addRequest(Ljava/lang/String;)Ljava/lang/String;

    .line 418
    :cond_0
    iget-object v0, p1, Lco/vine/android/PostOptionsDialogActivity$Result;->intent:Landroid/content/Intent;

    if-eqz v0, :cond_1

    .line 419
    iget-object v0, p1, Lco/vine/android/PostOptionsDialogActivity$Result;->intent:Landroid/content/Intent;

    invoke-virtual {p0, v0}, Lco/vine/android/BaseCursorListFragment;->startActivity(Landroid/content/Intent;)V

    .line 421
    :cond_1
    return-void
.end method

.method protected refresh()V
    .locals 0

    .prologue
    .line 309
    return-void
.end method

.method protected restorePosition()V
    .locals 3

    .prologue
    .line 605
    iget-object v0, p0, Lco/vine/android/BaseCursorListFragment;->mListView:Landroid/widget/ListView;

    iget v1, p0, Lco/vine/android/BaseCursorListFragment;->mScrollPos:I

    iget v2, p0, Lco/vine/android/BaseCursorListFragment;->mScrollOffset:I

    invoke-virtual {v0, v1, v2}, Landroid/widget/ListView;->setSelectionFromTop(II)V

    .line 606
    return-void
.end method

.method protected saveItemPosition(Lcom/twitter/android/widget/ItemPosition;)V
    .locals 0
    .param p1, "itemPosition"    # Lcom/twitter/android/widget/ItemPosition;

    .prologue
    .line 591
    return-void
.end method

.method protected savePosition()V
    .locals 4

    .prologue
    .line 611
    iget-object v0, p0, Lco/vine/android/BaseCursorListFragment;->mListView:Landroid/widget/ListView;

    .line 612
    .local v0, "l":Landroid/widget/ListView;
    if-eqz v0, :cond_0

    .line 614
    const/4 v3, 0x0

    invoke-virtual {v0, v3}, Landroid/widget/ListView;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    .line 616
    .local v2, "v":Landroid/view/View;
    if-eqz v2, :cond_1

    .line 617
    invoke-virtual {v2}, Landroid/view/View;->getTop()I

    move-result v1

    .line 622
    .local v1, "offset":I
    :goto_0
    invoke-virtual {v0}, Landroid/widget/ListView;->getFirstVisiblePosition()I

    move-result v3

    iput v3, p0, Lco/vine/android/BaseCursorListFragment;->mScrollPos:I

    .line 623
    iput v1, p0, Lco/vine/android/BaseCursorListFragment;->mScrollOffset:I

    .line 625
    .end local v1    # "offset":I
    .end local v2    # "v":Landroid/view/View;
    :cond_0
    return-void

    .line 619
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
    .line 491
    iget-object v0, p0, Lco/vine/android/BaseCursorListFragment;->mEmptyText:Landroid/widget/TextView;

    invoke-virtual {p0, p1}, Lco/vine/android/BaseCursorListFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 492
    return-void
.end method

.method public setFocused(Z)V
    .locals 0
    .param p1, "focused"    # Z

    .prologue
    .line 113
    iput-boolean p1, p0, Lco/vine/android/BaseCursorListFragment;->mFocused:Z

    .line 114
    return-void
.end method

.method public setOwnerId(J)V
    .locals 0
    .param p1, "ownerId"    # J

    .prologue
    .line 702
    iput-wide p1, p0, Lco/vine/android/BaseCursorListFragment;->mOwnerId:J

    .line 703
    return-void
.end method

.method public setRefreshableHeaderOffset(I)V
    .locals 1
    .param p1, "offset"    # I

    .prologue
    .line 286
    iget-boolean v0, p0, Lco/vine/android/BaseCursorListFragment;->mRefreshable:Z

    if-eqz v0, :cond_0

    .line 287
    iget-object v0, p0, Lco/vine/android/BaseCursorListFragment;->mListView:Landroid/widget/ListView;

    check-cast v0, Lcom/twitter/android/widget/RefreshableListView;

    invoke-virtual {v0, p1}, Lcom/twitter/android/widget/RefreshableListView;->setViewYOffset(I)V

    .line 289
    :cond_0
    return-void
.end method

.method public setScrollListener(Lco/vine/android/widget/tabs/TabScrollListener;)V
    .locals 0
    .param p1, "listener"    # Lco/vine/android/widget/tabs/TabScrollListener;

    .prologue
    .line 676
    iput-object p1, p0, Lco/vine/android/BaseCursorListFragment;->mScrollListener:Lco/vine/android/widget/tabs/TabScrollListener;

    .line 677
    return-void
.end method

.method public showDialog(I)V
    .locals 1
    .param p1, "dialog"    # I

    .prologue
    .line 695
    invoke-virtual {p0, p1}, Lco/vine/android/BaseCursorListFragment;->onCreateDialog(I)Landroid/app/Dialog;

    move-result-object v0

    .line 696
    .local v0, "d":Landroid/app/Dialog;
    if-eqz v0, :cond_0

    .line 697
    invoke-virtual {v0}, Landroid/app/Dialog;->show()V

    .line 699
    :cond_0
    return-void
.end method

.method protected showProgress(I)V
    .locals 2
    .param p1, "progressType"    # I

    .prologue
    const/4 v1, 0x1

    .line 353
    packed-switch p1, :pswitch_data_0

    .line 381
    :cond_0
    :goto_0
    :pswitch_0
    return-void

    .line 356
    :pswitch_1
    iget-boolean v0, p0, Lco/vine/android/BaseCursorListFragment;->mRefreshable:Z

    if-eqz v0, :cond_0

    .line 357
    iget-object v0, p0, Lco/vine/android/BaseCursorListFragment;->mListView:Landroid/widget/ListView;

    check-cast v0, Lcom/twitter/android/widget/RefreshableListView;

    invoke-virtual {v0, v1}, Lcom/twitter/android/widget/RefreshableListView;->refreshMore(Z)V

    goto :goto_0

    .line 364
    :pswitch_2
    iget-boolean v0, p0, Lco/vine/android/BaseCursorListFragment;->mRefreshable:Z

    if-eqz v0, :cond_0

    .line 365
    iget-object v0, p0, Lco/vine/android/BaseCursorListFragment;->mListView:Landroid/widget/ListView;

    check-cast v0, Lcom/twitter/android/widget/RefreshableListView;

    invoke-virtual {v0}, Lcom/twitter/android/widget/RefreshableListView;->startRefresh()V

    .line 366
    iput-boolean v1, p0, Lco/vine/android/BaseCursorListFragment;->mRefreshing:Z

    goto :goto_0

    .line 373
    :pswitch_3
    invoke-direct {p0, v1}, Lco/vine/android/BaseCursorListFragment;->showLoading(Z)V

    goto :goto_0

    .line 353
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_2
        :pswitch_3
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method protected showSadface(Z)V
    .locals 0
    .param p1, "show"    # Z

    .prologue
    .line 451
    invoke-virtual {p0, p1, p1}, Lco/vine/android/BaseCursorListFragment;->showSadface(ZZ)V

    .line 452
    return-void
.end method

.method protected showSadface(ZZ)V
    .locals 5
    .param p1, "show"    # Z
    .param p2, "showFrown"    # Z

    .prologue
    const/16 v2, 0x8

    const/4 v1, 0x0

    .line 455
    if-eqz p1, :cond_4

    .line 456
    iget-object v3, p0, Lco/vine/android/BaseCursorListFragment;->mListView:Landroid/widget/ListView;

    if-eqz v3, :cond_1

    iget-object v3, p0, Lco/vine/android/BaseCursorListFragment;->mSadface:Landroid/view/View;

    if-eqz v3, :cond_1

    .line 457
    iget-boolean v3, p0, Lco/vine/android/BaseCursorListFragment;->mIsSadFacePartOfHeader:Z

    if-nez v3, :cond_2

    .line 458
    iget-object v3, p0, Lco/vine/android/BaseCursorListFragment;->mListView:Landroid/widget/ListView;

    invoke-virtual {v3, v2}, Landroid/widget/ListView;->setVisibility(I)V

    .line 466
    :cond_0
    :goto_0
    iget-object v3, p0, Lco/vine/android/BaseCursorListFragment;->mSadface:Landroid/view/View;

    invoke-virtual {v3, v1}, Landroid/view/View;->setVisibility(I)V

    .line 469
    iget-object v3, p0, Lco/vine/android/BaseCursorListFragment;->mSadface:Landroid/view/View;

    const v4, 0x7f0a00e3

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 470
    .local v0, "sadFace":Landroid/view/View;
    if-eqz v0, :cond_1

    .line 471
    if-eqz p2, :cond_3

    :goto_1
    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 488
    .end local v0    # "sadFace":Landroid/view/View;
    :cond_1
    :goto_2
    return-void

    .line 460
    :cond_2
    iget-object v3, p0, Lco/vine/android/BaseCursorListFragment;->mListView:Landroid/widget/ListView;

    invoke-virtual {v3, v1}, Landroid/widget/ListView;->setVisibility(I)V

    .line 461
    iget-boolean v3, p0, Lco/vine/android/BaseCursorListFragment;->mIsSadFaceHeaderAdded:Z

    if-nez v3, :cond_0

    .line 462
    iget-object v3, p0, Lco/vine/android/BaseCursorListFragment;->mListView:Landroid/widget/ListView;

    iget-object v4, p0, Lco/vine/android/BaseCursorListFragment;->mSadface:Landroid/view/View;

    invoke-virtual {v3, v4}, Landroid/widget/ListView;->addHeaderView(Landroid/view/View;)V

    .line 463
    const/4 v3, 0x1

    iput-boolean v3, p0, Lco/vine/android/BaseCursorListFragment;->mIsSadFaceHeaderAdded:Z

    goto :goto_0

    .restart local v0    # "sadFace":Landroid/view/View;
    :cond_3
    move v1, v2

    .line 471
    goto :goto_1

    .line 475
    .end local v0    # "sadFace":Landroid/view/View;
    :cond_4
    iget-object v3, p0, Lco/vine/android/BaseCursorListFragment;->mListView:Landroid/widget/ListView;

    if-eqz v3, :cond_1

    iget-object v3, p0, Lco/vine/android/BaseCursorListFragment;->mSadface:Landroid/view/View;

    if-eqz v3, :cond_1

    .line 476
    iget-object v3, p0, Lco/vine/android/BaseCursorListFragment;->mListView:Landroid/widget/ListView;

    invoke-virtual {v3, v1}, Landroid/widget/ListView;->setVisibility(I)V

    .line 477
    iget-boolean v3, p0, Lco/vine/android/BaseCursorListFragment;->mIsSadFacePartOfHeader:Z

    if-eqz v3, :cond_5

    .line 478
    iget-boolean v3, p0, Lco/vine/android/BaseCursorListFragment;->mIsSadFaceHeaderAdded:Z

    if-eqz v3, :cond_1

    .line 479
    iget-object v3, p0, Lco/vine/android/BaseCursorListFragment;->mListView:Landroid/widget/ListView;

    iget-object v4, p0, Lco/vine/android/BaseCursorListFragment;->mSadface:Landroid/view/View;

    invoke-virtual {v3, v4}, Landroid/widget/ListView;->removeHeaderView(Landroid/view/View;)Z

    .line 480
    iget-object v3, p0, Lco/vine/android/BaseCursorListFragment;->mSadface:Landroid/view/View;

    invoke-virtual {v3, v2}, Landroid/view/View;->setVisibility(I)V

    .line 481
    iput-boolean v1, p0, Lco/vine/android/BaseCursorListFragment;->mIsSadFacePartOfHeader:Z

    goto :goto_2

    .line 484
    :cond_5
    iget-object v1, p0, Lco/vine/android/BaseCursorListFragment;->mSadface:Landroid/view/View;

    invoke-virtual {v1, v2}, Landroid/view/View;->setVisibility(I)V

    goto :goto_2
.end method
