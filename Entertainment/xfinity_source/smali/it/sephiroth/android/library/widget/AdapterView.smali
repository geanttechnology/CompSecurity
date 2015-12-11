.class public abstract Lit/sephiroth/android/library/widget/AdapterView;
.super Landroid/view/ViewGroup;
.source "AdapterView.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lit/sephiroth/android/library/widget/AdapterView$1;,
        Lit/sephiroth/android/library/widget/AdapterView$SelectionNotifier;,
        Lit/sephiroth/android/library/widget/AdapterView$AdapterDataSetObserver;,
        Lit/sephiroth/android/library/widget/AdapterView$AdapterContextMenuInfo;,
        Lit/sephiroth/android/library/widget/AdapterView$OnItemSelectedListener;,
        Lit/sephiroth/android/library/widget/AdapterView$OnItemLongClickListener;,
        Lit/sephiroth/android/library/widget/AdapterView$OnItemClickListener;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T::",
        "Landroid/widget/Adapter;",
        ">",
        "Landroid/view/ViewGroup;"
    }
.end annotation


# instance fields
.field mAccessibilityManager:Landroid/view/accessibility/AccessibilityManager;

.field protected mBlockLayoutRequests:Z

.field public mDataChanged:Z

.field private mDesiredFocusableInTouchModeState:Z

.field private mDesiredFocusableState:Z

.field private mEmptyView:Landroid/view/View;

.field protected mFirstPosition:I
    .annotation runtime Landroid/view/ViewDebug$ExportedProperty;
        category = "scrolling"
    .end annotation
.end field

.field protected mInLayout:Z

.field protected mItemCount:I
    .annotation runtime Landroid/view/ViewDebug$ExportedProperty;
        category = "list"
    .end annotation
.end field

.field private mLayoutWidth:I

.field protected mNeedSync:Z

.field protected mNextSelectedColId:J

.field protected mNextSelectedPosition:I
    .annotation runtime Landroid/view/ViewDebug$ExportedProperty;
        category = "list"
    .end annotation
.end field

.field protected mOldItemCount:I

.field protected mOldSelectedColId:J

.field protected mOldSelectedPosition:I

.field mOnItemClickListener:Lit/sephiroth/android/library/widget/AdapterView$OnItemClickListener;

.field mOnItemLongClickListener:Lit/sephiroth/android/library/widget/AdapterView$OnItemLongClickListener;

.field mOnItemSelectedListener:Lit/sephiroth/android/library/widget/AdapterView$OnItemSelectedListener;

.field protected mSelectedColId:J

.field protected mSelectedPosition:I
    .annotation runtime Landroid/view/ViewDebug$ExportedProperty;
        category = "list"
    .end annotation
.end field

.field private mSelectionNotifier:Lit/sephiroth/android/library/widget/AdapterView$SelectionNotifier;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lit/sephiroth/android/library/widget/AdapterView",
            "<TT;>.it/sephiroth/android/library/widget/AdapterView$SelectionNotifier;"
        }
    .end annotation
.end field

.field protected mSpecificLeft:I

.field protected mSyncColId:J

.field mSyncMode:I

.field protected mSyncPosition:I

.field protected mSyncWidth:J


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .local p0, "this":Lit/sephiroth/android/library/widget/AdapterView;, "Lit/sephiroth/android/library/widget/AdapterView<TT;>;"
    const/4 v1, -0x1

    const-wide/high16 v2, -0x8000000000000000L

    const/4 v0, 0x0

    .line 220
    invoke-direct {p0, p1}, Landroid/view/ViewGroup;-><init>(Landroid/content/Context;)V

    .line 61
    iput v0, p0, Lit/sephiroth/android/library/widget/AdapterView;->mFirstPosition:I

    .line 77
    iput-wide v2, p0, Lit/sephiroth/android/library/widget/AdapterView;->mSyncColId:J

    .line 87
    iput-boolean v0, p0, Lit/sephiroth/android/library/widget/AdapterView;->mNeedSync:Z

    .line 118
    iput-boolean v0, p0, Lit/sephiroth/android/library/widget/AdapterView;->mInLayout:Z

    .line 144
    iput v1, p0, Lit/sephiroth/android/library/widget/AdapterView;->mNextSelectedPosition:I

    .line 150
    iput-wide v2, p0, Lit/sephiroth/android/library/widget/AdapterView;->mNextSelectedColId:J

    .line 155
    iput v1, p0, Lit/sephiroth/android/library/widget/AdapterView;->mSelectedPosition:I

    .line 161
    iput-wide v2, p0, Lit/sephiroth/android/library/widget/AdapterView;->mSelectedColId:J

    .line 195
    iput v1, p0, Lit/sephiroth/android/library/widget/AdapterView;->mOldSelectedPosition:I

    .line 200
    iput-wide v2, p0, Lit/sephiroth/android/library/widget/AdapterView;->mOldSelectedColId:J

    .line 217
    iput-boolean v0, p0, Lit/sephiroth/android/library/widget/AdapterView;->mBlockLayoutRequests:Z

    .line 221
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .local p0, "this":Lit/sephiroth/android/library/widget/AdapterView;, "Lit/sephiroth/android/library/widget/AdapterView<TT;>;"
    const/4 v1, -0x1

    const-wide/high16 v2, -0x8000000000000000L

    const/4 v0, 0x0

    .line 224
    invoke-direct {p0, p1, p2}, Landroid/view/ViewGroup;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 61
    iput v0, p0, Lit/sephiroth/android/library/widget/AdapterView;->mFirstPosition:I

    .line 77
    iput-wide v2, p0, Lit/sephiroth/android/library/widget/AdapterView;->mSyncColId:J

    .line 87
    iput-boolean v0, p0, Lit/sephiroth/android/library/widget/AdapterView;->mNeedSync:Z

    .line 118
    iput-boolean v0, p0, Lit/sephiroth/android/library/widget/AdapterView;->mInLayout:Z

    .line 144
    iput v1, p0, Lit/sephiroth/android/library/widget/AdapterView;->mNextSelectedPosition:I

    .line 150
    iput-wide v2, p0, Lit/sephiroth/android/library/widget/AdapterView;->mNextSelectedColId:J

    .line 155
    iput v1, p0, Lit/sephiroth/android/library/widget/AdapterView;->mSelectedPosition:I

    .line 161
    iput-wide v2, p0, Lit/sephiroth/android/library/widget/AdapterView;->mSelectedColId:J

    .line 195
    iput v1, p0, Lit/sephiroth/android/library/widget/AdapterView;->mOldSelectedPosition:I

    .line 200
    iput-wide v2, p0, Lit/sephiroth/android/library/widget/AdapterView;->mOldSelectedColId:J

    .line 217
    iput-boolean v0, p0, Lit/sephiroth/android/library/widget/AdapterView;->mBlockLayoutRequests:Z

    .line 225
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I
    .annotation build Landroid/annotation/TargetApi;
        value = 0x10
    .end annotation

    .prologue
    .local p0, "this":Lit/sephiroth/android/library/widget/AdapterView;, "Lit/sephiroth/android/library/widget/AdapterView<TT;>;"
    const/4 v1, -0x1

    const-wide/high16 v2, -0x8000000000000000L

    const/4 v0, 0x0

    .line 229
    invoke-direct {p0, p1, p2, p3}, Landroid/view/ViewGroup;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 61
    iput v0, p0, Lit/sephiroth/android/library/widget/AdapterView;->mFirstPosition:I

    .line 77
    iput-wide v2, p0, Lit/sephiroth/android/library/widget/AdapterView;->mSyncColId:J

    .line 87
    iput-boolean v0, p0, Lit/sephiroth/android/library/widget/AdapterView;->mNeedSync:Z

    .line 118
    iput-boolean v0, p0, Lit/sephiroth/android/library/widget/AdapterView;->mInLayout:Z

    .line 144
    iput v1, p0, Lit/sephiroth/android/library/widget/AdapterView;->mNextSelectedPosition:I

    .line 150
    iput-wide v2, p0, Lit/sephiroth/android/library/widget/AdapterView;->mNextSelectedColId:J

    .line 155
    iput v1, p0, Lit/sephiroth/android/library/widget/AdapterView;->mSelectedPosition:I

    .line 161
    iput-wide v2, p0, Lit/sephiroth/android/library/widget/AdapterView;->mSelectedColId:J

    .line 195
    iput v1, p0, Lit/sephiroth/android/library/widget/AdapterView;->mOldSelectedPosition:I

    .line 200
    iput-wide v2, p0, Lit/sephiroth/android/library/widget/AdapterView;->mOldSelectedColId:J

    .line 217
    iput-boolean v0, p0, Lit/sephiroth/android/library/widget/AdapterView;->mBlockLayoutRequests:Z

    .line 231
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x10

    if-lt v0, v1, :cond_0

    .line 233
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AdapterView;->getImportantForAccessibility()I

    move-result v0

    if-nez v0, :cond_0

    .line 234
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lit/sephiroth/android/library/widget/AdapterView;->setImportantForAccessibility(I)V

    .line 238
    :cond_0
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AdapterView;->isInEditMode()Z

    move-result v0

    if-nez v0, :cond_1

    .line 239
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AdapterView;->getContext()Landroid/content/Context;

    move-result-object v0

    const-string v1, "accessibility"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/accessibility/AccessibilityManager;

    iput-object v0, p0, Lit/sephiroth/android/library/widget/AdapterView;->mAccessibilityManager:Landroid/view/accessibility/AccessibilityManager;

    .line 241
    :cond_1
    return-void
.end method

.method static synthetic access$000(Lit/sephiroth/android/library/widget/AdapterView;Landroid/os/Parcelable;)V
    .locals 0
    .param p0, "x0"    # Lit/sephiroth/android/library/widget/AdapterView;
    .param p1, "x1"    # Landroid/os/Parcelable;

    .prologue
    .line 42
    invoke-virtual {p0, p1}, Lit/sephiroth/android/library/widget/AdapterView;->onRestoreInstanceState(Landroid/os/Parcelable;)V

    return-void
.end method

.method static synthetic access$100(Lit/sephiroth/android/library/widget/AdapterView;)Landroid/os/Parcelable;
    .locals 1
    .param p0, "x0"    # Lit/sephiroth/android/library/widget/AdapterView;

    .prologue
    .line 42
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AdapterView;->onSaveInstanceState()Landroid/os/Parcelable;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$200(Lit/sephiroth/android/library/widget/AdapterView;)V
    .locals 0
    .param p0, "x0"    # Lit/sephiroth/android/library/widget/AdapterView;

    .prologue
    .line 42
    invoke-direct {p0}, Lit/sephiroth/android/library/widget/AdapterView;->fireOnSelected()V

    return-void
.end method

.method static synthetic access$300(Lit/sephiroth/android/library/widget/AdapterView;)V
    .locals 0
    .param p0, "x0"    # Lit/sephiroth/android/library/widget/AdapterView;

    .prologue
    .line 42
    invoke-direct {p0}, Lit/sephiroth/android/library/widget/AdapterView;->performAccessibilityActionsOnSelected()V

    return-void
.end method

.method private fireOnSelected()V
    .locals 6

    .prologue
    .line 919
    .local p0, "this":Lit/sephiroth/android/library/widget/AdapterView;, "Lit/sephiroth/android/library/widget/AdapterView<TT;>;"
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AdapterView;->mOnItemSelectedListener:Lit/sephiroth/android/library/widget/AdapterView$OnItemSelectedListener;

    if-nez v0, :cond_0

    .line 930
    :goto_0
    return-void

    .line 922
    :cond_0
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AdapterView;->getSelectedItemPosition()I

    move-result v3

    .line 923
    .local v3, "selection":I
    if-ltz v3, :cond_1

    .line 924
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AdapterView;->getSelectedView()Landroid/view/View;

    move-result-object v2

    .line 925
    .local v2, "v":Landroid/view/View;
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AdapterView;->mOnItemSelectedListener:Lit/sephiroth/android/library/widget/AdapterView$OnItemSelectedListener;

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AdapterView;->getAdapter()Landroid/widget/Adapter;

    move-result-object v1

    invoke-interface {v1, v3}, Landroid/widget/Adapter;->getItemId(I)J

    move-result-wide v4

    move-object v1, p0

    invoke-interface/range {v0 .. v5}, Lit/sephiroth/android/library/widget/AdapterView$OnItemSelectedListener;->onItemSelected(Lit/sephiroth/android/library/widget/AdapterView;Landroid/view/View;IJ)V

    goto :goto_0

    .line 928
    .end local v2    # "v":Landroid/view/View;
    :cond_1
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AdapterView;->mOnItemSelectedListener:Lit/sephiroth/android/library/widget/AdapterView$OnItemSelectedListener;

    invoke-interface {v0, p0}, Lit/sephiroth/android/library/widget/AdapterView$OnItemSelectedListener;->onNothingSelected(Lit/sephiroth/android/library/widget/AdapterView;)V

    goto :goto_0
.end method

.method private isScrollableForAccessibility()Z
    .locals 5

    .prologue
    .local p0, "this":Lit/sephiroth/android/library/widget/AdapterView;, "Lit/sephiroth/android/library/widget/AdapterView<TT;>;"
    const/4 v2, 0x0

    .line 997
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AdapterView;->getAdapter()Landroid/widget/Adapter;

    move-result-object v0

    .line 998
    .local v0, "adapter":Landroid/widget/Adapter;, "TT;"
    if-eqz v0, :cond_1

    .line 999
    invoke-interface {v0}, Landroid/widget/Adapter;->getCount()I

    move-result v1

    .line 1000
    .local v1, "itemCount":I
    if-lez v1, :cond_1

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AdapterView;->getFirstVisiblePosition()I

    move-result v3

    if-gtz v3, :cond_0

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AdapterView;->getLastVisiblePosition()I

    move-result v3

    add-int/lit8 v4, v1, -0x1

    if-ge v3, v4, :cond_1

    :cond_0
    const/4 v2, 0x1

    .line 1003
    .end local v1    # "itemCount":I
    :cond_1
    return v2
.end method

.method private performAccessibilityActionsOnSelected()V
    .locals 2

    .prologue
    .line 933
    .local p0, "this":Lit/sephiroth/android/library/widget/AdapterView;, "Lit/sephiroth/android/library/widget/AdapterView<TT;>;"
    iget-object v1, p0, Lit/sephiroth/android/library/widget/AdapterView;->mAccessibilityManager:Landroid/view/accessibility/AccessibilityManager;

    invoke-virtual {v1}, Landroid/view/accessibility/AccessibilityManager;->isEnabled()Z

    move-result v1

    if-nez v1, :cond_1

    .line 941
    :cond_0
    :goto_0
    return-void

    .line 936
    :cond_1
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AdapterView;->getSelectedItemPosition()I

    move-result v0

    .line 937
    .local v0, "position":I
    if-ltz v0, :cond_0

    .line 939
    const/4 v1, 0x4

    invoke-virtual {p0, v1}, Lit/sephiroth/android/library/widget/AdapterView;->sendAccessibilityEvent(I)V

    goto :goto_0
.end method

.method private updateEmptyStatus(Z)V
    .locals 6
    .param p1, "empty"    # Z
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "WrongCall"
        }
    .end annotation

    .prologue
    .local p0, "this":Lit/sephiroth/android/library/widget/AdapterView;, "Lit/sephiroth/android/library/widget/AdapterView<TT;>;"
    const/16 v2, 0x8

    const/4 v1, 0x0

    .line 744
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AdapterView;->isInFilterMode()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 745
    const/4 p1, 0x0

    .line 748
    :cond_0
    if-eqz p1, :cond_3

    .line 749
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AdapterView;->mEmptyView:Landroid/view/View;

    if-eqz v0, :cond_2

    .line 750
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AdapterView;->mEmptyView:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 751
    invoke-virtual {p0, v2}, Lit/sephiroth/android/library/widget/AdapterView;->setVisibility(I)V

    .line 760
    :goto_0
    iget-boolean v0, p0, Lit/sephiroth/android/library/widget/AdapterView;->mDataChanged:Z

    if-eqz v0, :cond_1

    .line 761
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AdapterView;->getLeft()I

    move-result v2

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AdapterView;->getTop()I

    move-result v3

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AdapterView;->getRight()I

    move-result v4

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AdapterView;->getBottom()I

    move-result v5

    move-object v0, p0

    invoke-virtual/range {v0 .. v5}, Lit/sephiroth/android/library/widget/AdapterView;->onLayout(ZIIII)V

    .line 767
    :cond_1
    :goto_1
    return-void

    .line 754
    :cond_2
    invoke-virtual {p0, v1}, Lit/sephiroth/android/library/widget/AdapterView;->setVisibility(I)V

    goto :goto_0

    .line 764
    :cond_3
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AdapterView;->mEmptyView:Landroid/view/View;

    if-eqz v0, :cond_4

    iget-object v0, p0, Lit/sephiroth/android/library/widget/AdapterView;->mEmptyView:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 765
    :cond_4
    invoke-virtual {p0, v1}, Lit/sephiroth/android/library/widget/AdapterView;->setVisibility(I)V

    goto :goto_1
.end method


# virtual methods
.method public addView(Landroid/view/View;)V
    .locals 2
    .param p1, "child"    # Landroid/view/View;

    .prologue
    .line 455
    .local p0, "this":Lit/sephiroth/android/library/widget/AdapterView;, "Lit/sephiroth/android/library/widget/AdapterView<TT;>;"
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "addView(View) is not supported in AdapterView"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public addView(Landroid/view/View;I)V
    .locals 2
    .param p1, "child"    # Landroid/view/View;
    .param p2, "index"    # I

    .prologue
    .line 471
    .local p0, "this":Lit/sephiroth/android/library/widget/AdapterView;, "Lit/sephiroth/android/library/widget/AdapterView<TT;>;"
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "addView(View, int) is not supported in AdapterView"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public addView(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V
    .locals 2
    .param p1, "child"    # Landroid/view/View;
    .param p2, "index"    # I
    .param p3, "params"    # Landroid/view/ViewGroup$LayoutParams;

    .prologue
    .line 506
    .local p0, "this":Lit/sephiroth/android/library/widget/AdapterView;, "Lit/sephiroth/android/library/widget/AdapterView<TT;>;"
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "addView(View, int, LayoutParams) is not supported in AdapterView"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    .locals 2
    .param p1, "child"    # Landroid/view/View;
    .param p2, "params"    # Landroid/view/ViewGroup$LayoutParams;

    .prologue
    .line 487
    .local p0, "this":Lit/sephiroth/android/library/widget/AdapterView;, "Lit/sephiroth/android/library/widget/AdapterView<TT;>;"
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "addView(View, LayoutParams) is not supported in AdapterView"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method protected canAnimate()Z
    .locals 1

    .prologue
    .line 1008
    .local p0, "this":Lit/sephiroth/android/library/widget/AdapterView;, "Lit/sephiroth/android/library/widget/AdapterView<TT;>;"
    invoke-super {p0}, Landroid/view/ViewGroup;->canAnimate()Z

    move-result v0

    if-eqz v0, :cond_0

    iget v0, p0, Lit/sephiroth/android/library/widget/AdapterView;->mItemCount:I

    if-lez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected checkFocus()V
    .locals 6

    .prologue
    .local p0, "this":Lit/sephiroth/android/library/widget/AdapterView;, "Lit/sephiroth/android/library/widget/AdapterView<TT;>;"
    const/4 v4, 0x1

    const/4 v5, 0x0

    .line 725
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AdapterView;->getAdapter()Landroid/widget/Adapter;

    move-result-object v0

    .line 726
    .local v0, "adapter":Landroid/widget/Adapter;, "TT;"
    if-eqz v0, :cond_0

    invoke-interface {v0}, Landroid/widget/Adapter;->getCount()I

    move-result v3

    if-nez v3, :cond_5

    :cond_0
    move v1, v4

    .line 727
    .local v1, "empty":Z
    :goto_0
    if-eqz v1, :cond_1

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AdapterView;->isInFilterMode()Z

    move-result v3

    if-eqz v3, :cond_6

    :cond_1
    move v2, v4

    .line 731
    .local v2, "focusable":Z
    :goto_1
    if-eqz v2, :cond_7

    iget-boolean v3, p0, Lit/sephiroth/android/library/widget/AdapterView;->mDesiredFocusableInTouchModeState:Z

    if-eqz v3, :cond_7

    move v3, v4

    :goto_2
    invoke-super {p0, v3}, Landroid/view/ViewGroup;->setFocusableInTouchMode(Z)V

    .line 732
    if-eqz v2, :cond_8

    iget-boolean v3, p0, Lit/sephiroth/android/library/widget/AdapterView;->mDesiredFocusableState:Z

    if-eqz v3, :cond_8

    move v3, v4

    :goto_3
    invoke-super {p0, v3}, Landroid/view/ViewGroup;->setFocusable(Z)V

    .line 733
    iget-object v3, p0, Lit/sephiroth/android/library/widget/AdapterView;->mEmptyView:Landroid/view/View;

    if-eqz v3, :cond_4

    .line 734
    if-eqz v0, :cond_2

    invoke-interface {v0}, Landroid/widget/Adapter;->isEmpty()Z

    move-result v3

    if-eqz v3, :cond_3

    :cond_2
    move v5, v4

    :cond_3
    invoke-direct {p0, v5}, Lit/sephiroth/android/library/widget/AdapterView;->updateEmptyStatus(Z)V

    .line 736
    :cond_4
    return-void

    .end local v1    # "empty":Z
    .end local v2    # "focusable":Z
    :cond_5
    move v1, v5

    .line 726
    goto :goto_0

    .restart local v1    # "empty":Z
    :cond_6
    move v2, v5

    .line 727
    goto :goto_1

    .restart local v2    # "focusable":Z
    :cond_7
    move v3, v5

    .line 731
    goto :goto_2

    :cond_8
    move v3, v5

    .line 732
    goto :goto_3
.end method

.method protected checkSelectionChanged()V
    .locals 4

    .prologue
    .line 1086
    .local p0, "this":Lit/sephiroth/android/library/widget/AdapterView;, "Lit/sephiroth/android/library/widget/AdapterView<TT;>;"
    iget v0, p0, Lit/sephiroth/android/library/widget/AdapterView;->mSelectedPosition:I

    iget v1, p0, Lit/sephiroth/android/library/widget/AdapterView;->mOldSelectedPosition:I

    if-ne v0, v1, :cond_0

    iget-wide v0, p0, Lit/sephiroth/android/library/widget/AdapterView;->mSelectedColId:J

    iget-wide v2, p0, Lit/sephiroth/android/library/widget/AdapterView;->mOldSelectedColId:J

    cmp-long v0, v0, v2

    if-eqz v0, :cond_1

    .line 1087
    :cond_0
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AdapterView;->selectionChanged()V

    .line 1088
    iget v0, p0, Lit/sephiroth/android/library/widget/AdapterView;->mSelectedPosition:I

    iput v0, p0, Lit/sephiroth/android/library/widget/AdapterView;->mOldSelectedPosition:I

    .line 1089
    iget-wide v0, p0, Lit/sephiroth/android/library/widget/AdapterView;->mSelectedColId:J

    iput-wide v0, p0, Lit/sephiroth/android/library/widget/AdapterView;->mOldSelectedColId:J

    .line 1091
    :cond_1
    return-void
.end method

.method public dispatchPopulateAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)Z
    .locals 2
    .param p1, "event"    # Landroid/view/accessibility/AccessibilityEvent;

    .prologue
    .line 945
    .local p0, "this":Lit/sephiroth/android/library/widget/AdapterView;, "Lit/sephiroth/android/library/widget/AdapterView<TT;>;"
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AdapterView;->getSelectedView()Landroid/view/View;

    move-result-object v0

    .line 946
    .local v0, "selectedView":Landroid/view/View;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/view/View;->getVisibility()I

    move-result v1

    if-nez v1, :cond_0

    invoke-virtual {v0, p1}, Landroid/view/View;->dispatchPopulateAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 948
    const/4 v1, 0x1

    .line 950
    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method protected dispatchRestoreInstanceState(Landroid/util/SparseArray;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/util/SparseArray",
            "<",
            "Landroid/os/Parcelable;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 805
    .local p0, "this":Lit/sephiroth/android/library/widget/AdapterView;, "Lit/sephiroth/android/library/widget/AdapterView<TT;>;"
    .local p1, "container":Landroid/util/SparseArray;, "Landroid/util/SparseArray<Landroid/os/Parcelable;>;"
    invoke-virtual {p0, p1}, Lit/sephiroth/android/library/widget/AdapterView;->dispatchThawSelfOnly(Landroid/util/SparseArray;)V

    .line 806
    return-void
.end method

.method protected dispatchSaveInstanceState(Landroid/util/SparseArray;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/util/SparseArray",
            "<",
            "Landroid/os/Parcelable;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 797
    .local p0, "this":Lit/sephiroth/android/library/widget/AdapterView;, "Lit/sephiroth/android/library/widget/AdapterView<TT;>;"
    .local p1, "container":Landroid/util/SparseArray;, "Landroid/util/SparseArray<Landroid/os/Parcelable;>;"
    invoke-virtual {p0, p1}, Lit/sephiroth/android/library/widget/AdapterView;->dispatchFreezeSelfOnly(Landroid/util/SparseArray;)V

    .line 798
    return-void
.end method

.method findSyncPosition()I
    .locals 20

    .prologue
    .line 1100
    .local p0, "this":Lit/sephiroth/android/library/widget/AdapterView;, "Lit/sephiroth/android/library/widget/AdapterView<TT;>;"
    move-object/from16 v0, p0

    iget v3, v0, Lit/sephiroth/android/library/widget/AdapterView;->mItemCount:I

    .line 1102
    .local v3, "count":I
    if-nez v3, :cond_1

    .line 1103
    const/4 v15, -0x1

    .line 1175
    :cond_0
    :goto_0
    return v15

    .line 1106
    :cond_1
    move-object/from16 v0, p0

    iget-wide v12, v0, Lit/sephiroth/android/library/widget/AdapterView;->mSyncColId:J

    .line 1107
    .local v12, "idToMatch":J
    move-object/from16 v0, p0

    iget v15, v0, Lit/sephiroth/android/library/widget/AdapterView;->mSyncPosition:I

    .line 1110
    .local v15, "seed":I
    const-wide/high16 v16, -0x8000000000000000L

    cmp-long v16, v12, v16

    if-nez v16, :cond_2

    .line 1111
    const/4 v15, -0x1

    goto :goto_0

    .line 1115
    :cond_2
    const/16 v16, 0x0

    move/from16 v0, v16

    invoke-static {v0, v15}, Ljava/lang/Math;->max(II)I

    move-result v15

    .line 1116
    add-int/lit8 v16, v3, -0x1

    move/from16 v0, v16

    invoke-static {v0, v15}, Ljava/lang/Math;->min(II)I

    move-result v15

    .line 1118
    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v16

    const-wide/16 v18, 0x64

    add-long v6, v16, v18

    .line 1123
    .local v6, "endTime":J
    move v8, v15

    .line 1126
    .local v8, "first":I
    move v11, v15

    .line 1129
    .local v11, "last":I
    const/4 v14, 0x0

    .line 1139
    .local v14, "next":Z
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AdapterView;->getAdapter()Landroid/widget/Adapter;

    move-result-object v2

    .line 1140
    .local v2, "adapter":Landroid/widget/Adapter;, "TT;"
    if-nez v2, :cond_5

    .line 1141
    const/4 v15, -0x1

    goto :goto_0

    .line 1159
    .local v4, "colId":J
    .local v9, "hitFirst":Z
    .local v10, "hitLast":Z
    :cond_3
    if-nez v9, :cond_4

    if-eqz v14, :cond_9

    if-nez v10, :cond_9

    .line 1161
    :cond_4
    add-int/lit8 v11, v11, 0x1

    .line 1162
    move v15, v11

    .line 1164
    const/4 v14, 0x0

    .line 1144
    .end local v4    # "colId":J
    .end local v9    # "hitFirst":Z
    .end local v10    # "hitLast":Z
    :cond_5
    :goto_1
    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v16

    cmp-long v16, v16, v6

    if-gtz v16, :cond_6

    .line 1145
    invoke-interface {v2, v15}, Landroid/widget/Adapter;->getItemId(I)J

    move-result-wide v4

    .line 1146
    .restart local v4    # "colId":J
    cmp-long v16, v4, v12

    if-eqz v16, :cond_0

    .line 1151
    add-int/lit8 v16, v3, -0x1

    move/from16 v0, v16

    if-ne v11, v0, :cond_7

    const/4 v10, 0x1

    .line 1152
    .restart local v10    # "hitLast":Z
    :goto_2
    if-nez v8, :cond_8

    const/4 v9, 0x1

    .line 1154
    .restart local v9    # "hitFirst":Z
    :goto_3
    if-eqz v10, :cond_3

    if-eqz v9, :cond_3

    .line 1175
    .end local v4    # "colId":J
    .end local v9    # "hitFirst":Z
    .end local v10    # "hitLast":Z
    :cond_6
    const/4 v15, -0x1

    goto :goto_0

    .line 1151
    .restart local v4    # "colId":J
    :cond_7
    const/4 v10, 0x0

    goto :goto_2

    .line 1152
    .restart local v10    # "hitLast":Z
    :cond_8
    const/4 v9, 0x0

    goto :goto_3

    .line 1165
    .restart local v9    # "hitFirst":Z
    :cond_9
    if-nez v10, :cond_a

    if-nez v14, :cond_5

    if-nez v9, :cond_5

    .line 1167
    :cond_a
    add-int/lit8 v8, v8, -0x1

    .line 1168
    move v15, v8

    .line 1170
    const/4 v14, 0x1

    goto :goto_1
.end method

.method public abstract getAdapter()Landroid/widget/Adapter;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation
.end method

.method public getCount()I
    .locals 1
    .annotation runtime Landroid/view/ViewDebug$CapturedViewProperty;
    .end annotation

    .prologue
    .line 596
    .local p0, "this":Lit/sephiroth/android/library/widget/AdapterView;, "Lit/sephiroth/android/library/widget/AdapterView<TT;>;"
    iget v0, p0, Lit/sephiroth/android/library/widget/AdapterView;->mItemCount:I

    return v0
.end method

.method public getEmptyView()Landroid/view/View;
    .locals 1

    .prologue
    .line 686
    .local p0, "this":Lit/sephiroth/android/library/widget/AdapterView;, "Lit/sephiroth/android/library/widget/AdapterView<TT;>;"
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AdapterView;->mEmptyView:Landroid/view/View;

    return-object v0
.end method

.method public getFirstVisiblePosition()I
    .locals 1

    .prologue
    .line 639
    .local p0, "this":Lit/sephiroth/android/library/widget/AdapterView;, "Lit/sephiroth/android/library/widget/AdapterView<TT;>;"
    iget v0, p0, Lit/sephiroth/android/library/widget/AdapterView;->mFirstPosition:I

    return v0
.end method

.method public getItemAtPosition(I)Ljava/lang/Object;
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 777
    .local p0, "this":Lit/sephiroth/android/library/widget/AdapterView;, "Lit/sephiroth/android/library/widget/AdapterView<TT;>;"
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AdapterView;->getAdapter()Landroid/widget/Adapter;

    move-result-object v0

    .line 778
    .local v0, "adapter":Landroid/widget/Adapter;, "TT;"
    if-eqz v0, :cond_0

    if-gez p1, :cond_1

    :cond_0
    const/4 v1, 0x0

    :goto_0
    return-object v1

    :cond_1
    invoke-interface {v0, p1}, Landroid/widget/Adapter;->getItem(I)Ljava/lang/Object;

    move-result-object v1

    goto :goto_0
.end method

.method public getItemIdAtPosition(I)J
    .locals 4
    .param p1, "position"    # I

    .prologue
    .line 782
    .local p0, "this":Lit/sephiroth/android/library/widget/AdapterView;, "Lit/sephiroth/android/library/widget/AdapterView<TT;>;"
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AdapterView;->getAdapter()Landroid/widget/Adapter;

    move-result-object v0

    .line 783
    .local v0, "adapter":Landroid/widget/Adapter;, "TT;"
    if-eqz v0, :cond_0

    if-gez p1, :cond_1

    :cond_0
    const-wide/high16 v2, -0x8000000000000000L

    :goto_0
    return-wide v2

    :cond_1
    invoke-interface {v0, p1}, Landroid/widget/Adapter;->getItemId(I)J

    move-result-wide v2

    goto :goto_0
.end method

.method public getLastVisiblePosition()I
    .locals 2

    .prologue
    .line 648
    .local p0, "this":Lit/sephiroth/android/library/widget/AdapterView;, "Lit/sephiroth/android/library/widget/AdapterView<TT;>;"
    iget v0, p0, Lit/sephiroth/android/library/widget/AdapterView;->mFirstPosition:I

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AdapterView;->getChildCount()I

    move-result v1

    add-int/2addr v0, v1

    add-int/lit8 v0, v0, -0x1

    return v0
.end method

.method public final getOnItemClickListener()Lit/sephiroth/android/library/widget/AdapterView$OnItemClickListener;
    .locals 1

    .prologue
    .line 279
    .local p0, "this":Lit/sephiroth/android/library/widget/AdapterView;, "Lit/sephiroth/android/library/widget/AdapterView<TT;>;"
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AdapterView;->mOnItemClickListener:Lit/sephiroth/android/library/widget/AdapterView$OnItemClickListener;

    return-object v0
.end method

.method public final getOnItemLongClickListener()Lit/sephiroth/android/library/widget/AdapterView$OnItemLongClickListener;
    .locals 1

    .prologue
    .line 348
    .local p0, "this":Lit/sephiroth/android/library/widget/AdapterView;, "Lit/sephiroth/android/library/widget/AdapterView<TT;>;"
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AdapterView;->mOnItemLongClickListener:Lit/sephiroth/android/library/widget/AdapterView$OnItemLongClickListener;

    return-object v0
.end method

.method public final getOnItemSelectedListener()Lit/sephiroth/android/library/widget/AdapterView$OnItemSelectedListener;
    .locals 1

    .prologue
    .line 396
    .local p0, "this":Lit/sephiroth/android/library/widget/AdapterView;, "Lit/sephiroth/android/library/widget/AdapterView<TT;>;"
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AdapterView;->mOnItemSelectedListener:Lit/sephiroth/android/library/widget/AdapterView$OnItemSelectedListener;

    return-object v0
.end method

.method public getPositionForView(Landroid/view/View;)I
    .locals 7
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .local p0, "this":Lit/sephiroth/android/library/widget/AdapterView;, "Lit/sephiroth/android/library/widget/AdapterView<TT;>;"
    const/4 v5, -0x1

    .line 610
    move-object v3, p1

    .line 613
    .local v3, "listItem":Landroid/view/View;
    :goto_0
    :try_start_0
    invoke-virtual {v3}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v4

    check-cast v4, Landroid/view/View;

    .local v4, "v":Landroid/view/View;
    invoke-virtual {v4, p0}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z
    :try_end_0
    .catch Ljava/lang/ClassCastException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v6

    if-nez v6, :cond_1

    .line 614
    move-object v3, v4

    goto :goto_0

    .line 616
    .end local v4    # "v":Landroid/view/View;
    :catch_0
    move-exception v1

    .line 630
    :cond_0
    :goto_1
    return v5

    .line 622
    .restart local v4    # "v":Landroid/view/View;
    :cond_1
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AdapterView;->getChildCount()I

    move-result v0

    .line 623
    .local v0, "childCount":I
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_2
    if-ge v2, v0, :cond_0

    .line 624
    invoke-virtual {p0, v2}, Lit/sephiroth/android/library/widget/AdapterView;->getChildAt(I)Landroid/view/View;

    move-result-object v6

    invoke-virtual {v6, v3}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_2

    .line 625
    iget v5, p0, Lit/sephiroth/android/library/widget/AdapterView;->mFirstPosition:I

    add-int/2addr v5, v2

    goto :goto_1

    .line 623
    :cond_2
    add-int/lit8 v2, v2, 0x1

    goto :goto_2
.end method

.method public getSelectedItem()Ljava/lang/Object;
    .locals 3

    .prologue
    .line 581
    .local p0, "this":Lit/sephiroth/android/library/widget/AdapterView;, "Lit/sephiroth/android/library/widget/AdapterView<TT;>;"
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AdapterView;->getAdapter()Landroid/widget/Adapter;

    move-result-object v0

    .line 582
    .local v0, "adapter":Landroid/widget/Adapter;, "TT;"
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AdapterView;->getSelectedItemPosition()I

    move-result v1

    .line 583
    .local v1, "selection":I
    if-eqz v0, :cond_0

    invoke-interface {v0}, Landroid/widget/Adapter;->getCount()I

    move-result v2

    if-lez v2, :cond_0

    if-ltz v1, :cond_0

    .line 584
    invoke-interface {v0, v1}, Landroid/widget/Adapter;->getItem(I)Ljava/lang/Object;

    move-result-object v2

    .line 586
    :goto_0
    return-object v2

    :cond_0
    const/4 v2, 0x0

    goto :goto_0
.end method

.method public getSelectedItemId()J
    .locals 2
    .annotation runtime Landroid/view/ViewDebug$CapturedViewProperty;
    .end annotation

    .prologue
    .line 569
    .local p0, "this":Lit/sephiroth/android/library/widget/AdapterView;, "Lit/sephiroth/android/library/widget/AdapterView<TT;>;"
    iget-wide v0, p0, Lit/sephiroth/android/library/widget/AdapterView;->mNextSelectedColId:J

    return-wide v0
.end method

.method public getSelectedItemPosition()I
    .locals 1
    .annotation runtime Landroid/view/ViewDebug$CapturedViewProperty;
    .end annotation

    .prologue
    .line 561
    .local p0, "this":Lit/sephiroth/android/library/widget/AdapterView;, "Lit/sephiroth/android/library/widget/AdapterView<TT;>;"
    iget v0, p0, Lit/sephiroth/android/library/widget/AdapterView;->mNextSelectedPosition:I

    return v0
.end method

.method public abstract getSelectedView()Landroid/view/View;
.end method

.method handleDataChanged()V
    .locals 10

    .prologue
    .local p0, "this":Lit/sephiroth/android/library/widget/AdapterView;, "Lit/sephiroth/android/library/widget/AdapterView<TT;>;"
    const-wide/high16 v8, -0x8000000000000000L

    const/4 v7, 0x1

    const/4 v6, -0x1

    const/4 v5, 0x0

    .line 1015
    iget v0, p0, Lit/sephiroth/android/library/widget/AdapterView;->mItemCount:I

    .line 1016
    .local v0, "count":I
    const/4 v1, 0x0

    .line 1018
    .local v1, "found":Z
    if-lez v0, :cond_4

    .line 1023
    iget-boolean v4, p0, Lit/sephiroth/android/library/widget/AdapterView;->mNeedSync:Z

    if-eqz v4, :cond_0

    .line 1026
    iput-boolean v5, p0, Lit/sephiroth/android/library/widget/AdapterView;->mNeedSync:Z

    .line 1030
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AdapterView;->findSyncPosition()I

    move-result v2

    .line 1031
    .local v2, "newPos":I
    if-ltz v2, :cond_0

    .line 1033
    invoke-virtual {p0, v2, v7}, Lit/sephiroth/android/library/widget/AdapterView;->lookForSelectablePosition(IZ)I

    move-result v3

    .line 1034
    .local v3, "selectablePos":I
    if-ne v3, v2, :cond_0

    .line 1036
    invoke-virtual {p0, v2}, Lit/sephiroth/android/library/widget/AdapterView;->setNextSelectedPositionInt(I)V

    .line 1037
    const/4 v1, 0x1

    .line 1041
    .end local v2    # "newPos":I
    .end local v3    # "selectablePos":I
    :cond_0
    if-nez v1, :cond_4

    .line 1043
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AdapterView;->getSelectedItemPosition()I

    move-result v2

    .line 1046
    .restart local v2    # "newPos":I
    if-lt v2, v0, :cond_1

    .line 1047
    add-int/lit8 v2, v0, -0x1

    .line 1049
    :cond_1
    if-gez v2, :cond_2

    .line 1050
    const/4 v2, 0x0

    .line 1054
    :cond_2
    invoke-virtual {p0, v2, v7}, Lit/sephiroth/android/library/widget/AdapterView;->lookForSelectablePosition(IZ)I

    move-result v3

    .line 1055
    .restart local v3    # "selectablePos":I
    if-gez v3, :cond_3

    .line 1057
    invoke-virtual {p0, v2, v5}, Lit/sephiroth/android/library/widget/AdapterView;->lookForSelectablePosition(IZ)I

    move-result v3

    .line 1059
    :cond_3
    if-ltz v3, :cond_4

    .line 1060
    invoke-virtual {p0, v3}, Lit/sephiroth/android/library/widget/AdapterView;->setNextSelectedPositionInt(I)V

    .line 1061
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AdapterView;->checkSelectionChanged()V

    .line 1062
    const/4 v1, 0x1

    .line 1066
    .end local v2    # "newPos":I
    .end local v3    # "selectablePos":I
    :cond_4
    if-nez v1, :cond_5

    .line 1068
    iput v6, p0, Lit/sephiroth/android/library/widget/AdapterView;->mSelectedPosition:I

    .line 1069
    iput-wide v8, p0, Lit/sephiroth/android/library/widget/AdapterView;->mSelectedColId:J

    .line 1070
    iput v6, p0, Lit/sephiroth/android/library/widget/AdapterView;->mNextSelectedPosition:I

    .line 1071
    iput-wide v8, p0, Lit/sephiroth/android/library/widget/AdapterView;->mNextSelectedColId:J

    .line 1072
    iput-boolean v5, p0, Lit/sephiroth/android/library/widget/AdapterView;->mNeedSync:Z

    .line 1073
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AdapterView;->checkSelectionChanged()V

    .line 1080
    :cond_5
    return-void
.end method

.method isInFilterMode()Z
    .locals 1

    .prologue
    .line 695
    .local p0, "this":Lit/sephiroth/android/library/widget/AdapterView;, "Lit/sephiroth/android/library/widget/AdapterView<TT;>;"
    const/4 v0, 0x0

    return v0
.end method

.method protected lookForSelectablePosition(IZ)I
    .locals 0
    .param p1, "position"    # I
    .param p2, "lookDown"    # Z

    .prologue
    .line 1189
    .local p0, "this":Lit/sephiroth/android/library/widget/AdapterView;, "Lit/sephiroth/android/library/widget/AdapterView<TT;>;"
    return p1
.end method

.method protected onDetachedFromWindow()V
    .locals 1

    .prologue
    .line 874
    .local p0, "this":Lit/sephiroth/android/library/widget/AdapterView;, "Lit/sephiroth/android/library/widget/AdapterView<TT;>;"
    invoke-super {p0}, Landroid/view/ViewGroup;->onDetachedFromWindow()V

    .line 875
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AdapterView;->mSelectionNotifier:Lit/sephiroth/android/library/widget/AdapterView$SelectionNotifier;

    invoke-virtual {p0, v0}, Lit/sephiroth/android/library/widget/AdapterView;->removeCallbacks(Ljava/lang/Runnable;)Z

    .line 876
    return-void
.end method

.method public onInitializeAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)V
    .locals 2
    .param p1, "event"    # Landroid/view/accessibility/AccessibilityEvent;
    .annotation build Landroid/annotation/TargetApi;
        value = 0xe
    .end annotation

    .prologue
    .line 983
    .local p0, "this":Lit/sephiroth/android/library/widget/AdapterView;, "Lit/sephiroth/android/library/widget/AdapterView<TT;>;"
    invoke-super {p0, p1}, Landroid/view/ViewGroup;->onInitializeAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)V

    .line 984
    const-class v1, Lit/sephiroth/android/library/widget/AdapterView;

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v1}, Landroid/view/accessibility/AccessibilityEvent;->setClassName(Ljava/lang/CharSequence;)V

    .line 985
    invoke-direct {p0}, Lit/sephiroth/android/library/widget/AdapterView;->isScrollableForAccessibility()Z

    move-result v1

    invoke-virtual {p1, v1}, Landroid/view/accessibility/AccessibilityEvent;->setScrollable(Z)V

    .line 986
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AdapterView;->getSelectedView()Landroid/view/View;

    move-result-object v0

    .line 987
    .local v0, "selectedView":Landroid/view/View;
    if-eqz v0, :cond_0

    .line 988
    invoke-virtual {v0}, Landroid/view/View;->isEnabled()Z

    move-result v1

    invoke-virtual {p1, v1}, Landroid/view/accessibility/AccessibilityEvent;->setEnabled(Z)V

    .line 990
    :cond_0
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AdapterView;->getSelectedItemPosition()I

    move-result v1

    invoke-virtual {p1, v1}, Landroid/view/accessibility/AccessibilityEvent;->setCurrentItemIndex(I)V

    .line 991
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AdapterView;->getFirstVisiblePosition()I

    move-result v1

    invoke-virtual {p1, v1}, Landroid/view/accessibility/AccessibilityEvent;->setFromIndex(I)V

    .line 992
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AdapterView;->getLastVisiblePosition()I

    move-result v1

    invoke-virtual {p1, v1}, Landroid/view/accessibility/AccessibilityEvent;->setToIndex(I)V

    .line 993
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AdapterView;->getCount()I

    move-result v1

    invoke-virtual {p1, v1}, Landroid/view/accessibility/AccessibilityEvent;->setItemCount(I)V

    .line 994
    return-void
.end method

.method public onInitializeAccessibilityNodeInfo(Landroid/view/accessibility/AccessibilityNodeInfo;)V
    .locals 2
    .param p1, "info"    # Landroid/view/accessibility/AccessibilityNodeInfo;
    .annotation build Landroid/annotation/TargetApi;
        value = 0xe
    .end annotation

    .prologue
    .line 971
    .local p0, "this":Lit/sephiroth/android/library/widget/AdapterView;, "Lit/sephiroth/android/library/widget/AdapterView<TT;>;"
    invoke-super {p0, p1}, Landroid/view/ViewGroup;->onInitializeAccessibilityNodeInfo(Landroid/view/accessibility/AccessibilityNodeInfo;)V

    .line 972
    const-class v1, Lit/sephiroth/android/library/widget/AdapterView;

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v1}, Landroid/view/accessibility/AccessibilityNodeInfo;->setClassName(Ljava/lang/CharSequence;)V

    .line 973
    invoke-direct {p0}, Lit/sephiroth/android/library/widget/AdapterView;->isScrollableForAccessibility()Z

    move-result v1

    invoke-virtual {p1, v1}, Landroid/view/accessibility/AccessibilityNodeInfo;->setScrollable(Z)V

    .line 974
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AdapterView;->getSelectedView()Landroid/view/View;

    move-result-object v0

    .line 975
    .local v0, "selectedView":Landroid/view/View;
    if-eqz v0, :cond_0

    .line 976
    invoke-virtual {v0}, Landroid/view/View;->isEnabled()Z

    move-result v1

    invoke-virtual {p1, v1}, Landroid/view/accessibility/AccessibilityNodeInfo;->setEnabled(Z)V

    .line 978
    :cond_0
    return-void
.end method

.method protected onLayout(ZIIII)V
    .locals 1
    .param p1, "changed"    # Z
    .param p2, "left"    # I
    .param p3, "top"    # I
    .param p4, "right"    # I
    .param p5, "bottom"    # I

    .prologue
    .line 551
    .local p0, "this":Lit/sephiroth/android/library/widget/AdapterView;, "Lit/sephiroth/android/library/widget/AdapterView<TT;>;"
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AdapterView;->getWidth()I

    move-result v0

    iput v0, p0, Lit/sephiroth/android/library/widget/AdapterView;->mLayoutWidth:I

    .line 552
    return-void
.end method

.method public onRequestSendAccessibilityEvent(Landroid/view/View;Landroid/view/accessibility/AccessibilityEvent;)Z
    .locals 2
    .param p1, "child"    # Landroid/view/View;
    .param p2, "event"    # Landroid/view/accessibility/AccessibilityEvent;
    .annotation build Landroid/annotation/TargetApi;
        value = 0xe
    .end annotation

    .prologue
    .line 956
    .local p0, "this":Lit/sephiroth/android/library/widget/AdapterView;, "Lit/sephiroth/android/library/widget/AdapterView<TT;>;"
    invoke-super {p0, p1, p2}, Landroid/view/ViewGroup;->onRequestSendAccessibilityEvent(Landroid/view/View;Landroid/view/accessibility/AccessibilityEvent;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 958
    invoke-static {}, Landroid/view/accessibility/AccessibilityEvent;->obtain()Landroid/view/accessibility/AccessibilityEvent;

    move-result-object v0

    .line 959
    .local v0, "record":Landroid/view/accessibility/AccessibilityEvent;
    invoke-virtual {p0, v0}, Lit/sephiroth/android/library/widget/AdapterView;->onInitializeAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)V

    .line 961
    invoke-virtual {p1, v0}, Landroid/view/View;->dispatchPopulateAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)Z

    .line 962
    invoke-virtual {p2, v0}, Landroid/view/accessibility/AccessibilityEvent;->appendRecord(Landroid/view/accessibility/AccessibilityRecord;)V

    .line 963
    const/4 v1, 0x1

    .line 965
    .end local v0    # "record":Landroid/view/accessibility/AccessibilityEvent;
    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public performItemClick(Landroid/view/View;IJ)Z
    .locals 7
    .param p1, "view"    # Landroid/view/View;
    .param p2, "position"    # I
    .param p3, "id"    # J

    .prologue
    .local p0, "this":Lit/sephiroth/android/library/widget/AdapterView;, "Lit/sephiroth/android/library/widget/AdapterView<TT;>;"
    const/4 v6, 0x1

    const/4 v0, 0x0

    .line 294
    iget-object v1, p0, Lit/sephiroth/android/library/widget/AdapterView;->mOnItemClickListener:Lit/sephiroth/android/library/widget/AdapterView$OnItemClickListener;

    if-eqz v1, :cond_1

    .line 295
    invoke-virtual {p0, v0}, Lit/sephiroth/android/library/widget/AdapterView;->playSoundEffect(I)V

    .line 296
    if-eqz p1, :cond_0

    .line 297
    invoke-virtual {p1, v6}, Landroid/view/View;->sendAccessibilityEvent(I)V

    .line 299
    :cond_0
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AdapterView;->mOnItemClickListener:Lit/sephiroth/android/library/widget/AdapterView$OnItemClickListener;

    move-object v1, p0

    move-object v2, p1

    move v3, p2

    move-wide v4, p3

    invoke-interface/range {v0 .. v5}, Lit/sephiroth/android/library/widget/AdapterView$OnItemClickListener;->onItemClick(Lit/sephiroth/android/library/widget/AdapterView;Landroid/view/View;IJ)V

    move v0, v6

    .line 303
    :cond_1
    return v0
.end method

.method public rememberSyncState()V
    .locals 6

    .prologue
    .local p0, "this":Lit/sephiroth/android/library/widget/AdapterView;, "Lit/sephiroth/android/library/widget/AdapterView<TT;>;"
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 1227
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AdapterView;->getChildCount()I

    move-result v2

    if-lez v2, :cond_1

    .line 1228
    iput-boolean v5, p0, Lit/sephiroth/android/library/widget/AdapterView;->mNeedSync:Z

    .line 1229
    iget v2, p0, Lit/sephiroth/android/library/widget/AdapterView;->mLayoutWidth:I

    int-to-long v2, v2

    iput-wide v2, p0, Lit/sephiroth/android/library/widget/AdapterView;->mSyncWidth:J

    .line 1230
    iget v2, p0, Lit/sephiroth/android/library/widget/AdapterView;->mSelectedPosition:I

    if-ltz v2, :cond_2

    .line 1232
    iget v2, p0, Lit/sephiroth/android/library/widget/AdapterView;->mSelectedPosition:I

    iget v3, p0, Lit/sephiroth/android/library/widget/AdapterView;->mFirstPosition:I

    sub-int/2addr v2, v3

    invoke-virtual {p0, v2}, Lit/sephiroth/android/library/widget/AdapterView;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    .line 1233
    .local v1, "v":Landroid/view/View;
    iget-wide v2, p0, Lit/sephiroth/android/library/widget/AdapterView;->mNextSelectedColId:J

    iput-wide v2, p0, Lit/sephiroth/android/library/widget/AdapterView;->mSyncColId:J

    .line 1234
    iget v2, p0, Lit/sephiroth/android/library/widget/AdapterView;->mNextSelectedPosition:I

    iput v2, p0, Lit/sephiroth/android/library/widget/AdapterView;->mSyncPosition:I

    .line 1235
    if-eqz v1, :cond_0

    .line 1236
    invoke-virtual {v1}, Landroid/view/View;->getLeft()I

    move-result v2

    iput v2, p0, Lit/sephiroth/android/library/widget/AdapterView;->mSpecificLeft:I

    .line 1238
    :cond_0
    iput v4, p0, Lit/sephiroth/android/library/widget/AdapterView;->mSyncMode:I

    .line 1255
    .end local v1    # "v":Landroid/view/View;
    :cond_1
    :goto_0
    return-void

    .line 1241
    :cond_2
    invoke-virtual {p0, v4}, Lit/sephiroth/android/library/widget/AdapterView;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    .line 1242
    .restart local v1    # "v":Landroid/view/View;
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AdapterView;->getAdapter()Landroid/widget/Adapter;

    move-result-object v0

    .line 1243
    .local v0, "adapter":Landroid/widget/Adapter;, "TT;"
    iget v2, p0, Lit/sephiroth/android/library/widget/AdapterView;->mFirstPosition:I

    if-ltz v2, :cond_4

    iget v2, p0, Lit/sephiroth/android/library/widget/AdapterView;->mFirstPosition:I

    invoke-interface {v0}, Landroid/widget/Adapter;->getCount()I

    move-result v3

    if-ge v2, v3, :cond_4

    .line 1244
    iget v2, p0, Lit/sephiroth/android/library/widget/AdapterView;->mFirstPosition:I

    invoke-interface {v0, v2}, Landroid/widget/Adapter;->getItemId(I)J

    move-result-wide v2

    iput-wide v2, p0, Lit/sephiroth/android/library/widget/AdapterView;->mSyncColId:J

    .line 1248
    :goto_1
    iget v2, p0, Lit/sephiroth/android/library/widget/AdapterView;->mFirstPosition:I

    iput v2, p0, Lit/sephiroth/android/library/widget/AdapterView;->mSyncPosition:I

    .line 1249
    if-eqz v1, :cond_3

    .line 1250
    invoke-virtual {v1}, Landroid/view/View;->getLeft()I

    move-result v2

    iput v2, p0, Lit/sephiroth/android/library/widget/AdapterView;->mSpecificLeft:I

    .line 1252
    :cond_3
    iput v5, p0, Lit/sephiroth/android/library/widget/AdapterView;->mSyncMode:I

    goto :goto_0

    .line 1246
    :cond_4
    const-wide/16 v2, -0x1

    iput-wide v2, p0, Lit/sephiroth/android/library/widget/AdapterView;->mSyncColId:J

    goto :goto_1
.end method

.method public removeAllViews()V
    .locals 2

    .prologue
    .line 546
    .local p0, "this":Lit/sephiroth/android/library/widget/AdapterView;, "Lit/sephiroth/android/library/widget/AdapterView<TT;>;"
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "removeAllViews() is not supported in AdapterView"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public removeView(Landroid/view/View;)V
    .locals 2
    .param p1, "child"    # Landroid/view/View;

    .prologue
    .line 521
    .local p0, "this":Lit/sephiroth/android/library/widget/AdapterView;, "Lit/sephiroth/android/library/widget/AdapterView<TT;>;"
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "removeView(View) is not supported in AdapterView"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public removeViewAt(I)V
    .locals 2
    .param p1, "index"    # I

    .prologue
    .line 535
    .local p0, "this":Lit/sephiroth/android/library/widget/AdapterView;, "Lit/sephiroth/android/library/widget/AdapterView<TT;>;"
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "removeViewAt(int) is not supported in AdapterView"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method selectionChanged()V
    .locals 2

    .prologue
    .line 900
    .local p0, "this":Lit/sephiroth/android/library/widget/AdapterView;, "Lit/sephiroth/android/library/widget/AdapterView<TT;>;"
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AdapterView;->mOnItemSelectedListener:Lit/sephiroth/android/library/widget/AdapterView$OnItemSelectedListener;

    if-nez v0, :cond_0

    iget-object v0, p0, Lit/sephiroth/android/library/widget/AdapterView;->mAccessibilityManager:Landroid/view/accessibility/AccessibilityManager;

    invoke-virtual {v0}, Landroid/view/accessibility/AccessibilityManager;->isEnabled()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 902
    :cond_0
    iget-boolean v0, p0, Lit/sephiroth/android/library/widget/AdapterView;->mInLayout:Z

    if-nez v0, :cond_1

    iget-boolean v0, p0, Lit/sephiroth/android/library/widget/AdapterView;->mBlockLayoutRequests:Z

    if-eqz v0, :cond_4

    .line 907
    :cond_1
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AdapterView;->mSelectionNotifier:Lit/sephiroth/android/library/widget/AdapterView$SelectionNotifier;

    if-nez v0, :cond_2

    .line 908
    new-instance v0, Lit/sephiroth/android/library/widget/AdapterView$SelectionNotifier;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lit/sephiroth/android/library/widget/AdapterView$SelectionNotifier;-><init>(Lit/sephiroth/android/library/widget/AdapterView;Lit/sephiroth/android/library/widget/AdapterView$1;)V

    iput-object v0, p0, Lit/sephiroth/android/library/widget/AdapterView;->mSelectionNotifier:Lit/sephiroth/android/library/widget/AdapterView$SelectionNotifier;

    .line 910
    :cond_2
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AdapterView;->mSelectionNotifier:Lit/sephiroth/android/library/widget/AdapterView$SelectionNotifier;

    invoke-virtual {p0, v0}, Lit/sephiroth/android/library/widget/AdapterView;->post(Ljava/lang/Runnable;)Z

    .line 916
    :cond_3
    :goto_0
    return-void

    .line 912
    :cond_4
    invoke-direct {p0}, Lit/sephiroth/android/library/widget/AdapterView;->fireOnSelected()V

    .line 913
    invoke-direct {p0}, Lit/sephiroth/android/library/widget/AdapterView;->performAccessibilityActionsOnSelected()V

    goto :goto_0
.end method

.method public abstract setAdapter(Landroid/widget/Adapter;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation
.end method

.method public setEmptyView(Landroid/view/View;)V
    .locals 4
    .param p1, "emptyView"    # Landroid/view/View;
    .annotation build Landroid/annotation/TargetApi;
        value = 0x10
    .end annotation

    .prologue
    .local p0, "this":Lit/sephiroth/android/library/widget/AdapterView;, "Lit/sephiroth/android/library/widget/AdapterView<TT;>;"
    const/4 v1, 0x1

    .line 665
    iput-object p1, p0, Lit/sephiroth/android/library/widget/AdapterView;->mEmptyView:Landroid/view/View;

    .line 667
    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v3, 0x10

    if-lt v2, v3, :cond_0

    .line 669
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Landroid/view/View;->getImportantForAccessibility()I

    move-result v2

    if-nez v2, :cond_0

    .line 670
    invoke-virtual {p1, v1}, Landroid/view/View;->setImportantForAccessibility(I)V

    .line 674
    :cond_0
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AdapterView;->getAdapter()Landroid/widget/Adapter;

    move-result-object v0

    .line 675
    .local v0, "adapter":Landroid/widget/Adapter;, "TT;"
    if-eqz v0, :cond_1

    invoke-interface {v0}, Landroid/widget/Adapter;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 676
    .local v1, "empty":Z
    :cond_1
    :goto_0
    invoke-direct {p0, v1}, Lit/sephiroth/android/library/widget/AdapterView;->updateEmptyStatus(Z)V

    .line 677
    return-void

    .line 675
    .end local v1    # "empty":Z
    :cond_2
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public setFocusable(Z)V
    .locals 5
    .param p1, "focusable"    # Z

    .prologue
    .local p0, "this":Lit/sephiroth/android/library/widget/AdapterView;, "Lit/sephiroth/android/library/widget/AdapterView<TT;>;"
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 700
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AdapterView;->getAdapter()Landroid/widget/Adapter;

    move-result-object v0

    .line 701
    .local v0, "adapter":Landroid/widget/Adapter;, "TT;"
    if-eqz v0, :cond_0

    invoke-interface {v0}, Landroid/widget/Adapter;->getCount()I

    move-result v4

    if-nez v4, :cond_3

    :cond_0
    move v1, v3

    .line 703
    .local v1, "empty":Z
    :goto_0
    iput-boolean p1, p0, Lit/sephiroth/android/library/widget/AdapterView;->mDesiredFocusableState:Z

    .line 704
    if-nez p1, :cond_1

    .line 705
    iput-boolean v2, p0, Lit/sephiroth/android/library/widget/AdapterView;->mDesiredFocusableInTouchModeState:Z

    .line 708
    :cond_1
    if-eqz p1, :cond_4

    if-eqz v1, :cond_2

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AdapterView;->isInFilterMode()Z

    move-result v4

    if-eqz v4, :cond_4

    :cond_2
    :goto_1
    invoke-super {p0, v3}, Landroid/view/ViewGroup;->setFocusable(Z)V

    .line 709
    return-void

    .end local v1    # "empty":Z
    :cond_3
    move v1, v2

    .line 701
    goto :goto_0

    .restart local v1    # "empty":Z
    :cond_4
    move v3, v2

    .line 708
    goto :goto_1
.end method

.method public setFocusableInTouchMode(Z)V
    .locals 5
    .param p1, "focusable"    # Z

    .prologue
    .local p0, "this":Lit/sephiroth/android/library/widget/AdapterView;, "Lit/sephiroth/android/library/widget/AdapterView<TT;>;"
    const/4 v2, 0x0

    const/4 v3, 0x1

    .line 713
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AdapterView;->getAdapter()Landroid/widget/Adapter;

    move-result-object v0

    .line 714
    .local v0, "adapter":Landroid/widget/Adapter;, "TT;"
    if-eqz v0, :cond_0

    invoke-interface {v0}, Landroid/widget/Adapter;->getCount()I

    move-result v4

    if-nez v4, :cond_3

    :cond_0
    move v1, v3

    .line 716
    .local v1, "empty":Z
    :goto_0
    iput-boolean p1, p0, Lit/sephiroth/android/library/widget/AdapterView;->mDesiredFocusableInTouchModeState:Z

    .line 717
    if-eqz p1, :cond_1

    .line 718
    iput-boolean v3, p0, Lit/sephiroth/android/library/widget/AdapterView;->mDesiredFocusableState:Z

    .line 721
    :cond_1
    if-eqz p1, :cond_4

    if-eqz v1, :cond_2

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AdapterView;->isInFilterMode()Z

    move-result v4

    if-eqz v4, :cond_4

    :cond_2
    :goto_1
    invoke-super {p0, v3}, Landroid/view/ViewGroup;->setFocusableInTouchMode(Z)V

    .line 722
    return-void

    .end local v1    # "empty":Z
    :cond_3
    move v1, v2

    .line 714
    goto :goto_0

    .restart local v1    # "empty":Z
    :cond_4
    move v3, v2

    .line 721
    goto :goto_1
.end method

.method protected setNextSelectedPositionInt(I)V
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 1210
    .local p0, "this":Lit/sephiroth/android/library/widget/AdapterView;, "Lit/sephiroth/android/library/widget/AdapterView<TT;>;"
    iput p1, p0, Lit/sephiroth/android/library/widget/AdapterView;->mNextSelectedPosition:I

    .line 1211
    invoke-virtual {p0, p1}, Lit/sephiroth/android/library/widget/AdapterView;->getItemIdAtPosition(I)J

    move-result-wide v0

    iput-wide v0, p0, Lit/sephiroth/android/library/widget/AdapterView;->mNextSelectedColId:J

    .line 1213
    iget-boolean v0, p0, Lit/sephiroth/android/library/widget/AdapterView;->mNeedSync:Z

    if-eqz v0, :cond_0

    iget v0, p0, Lit/sephiroth/android/library/widget/AdapterView;->mSyncMode:I

    if-nez v0, :cond_0

    if-ltz p1, :cond_0

    .line 1214
    iput p1, p0, Lit/sephiroth/android/library/widget/AdapterView;->mSyncPosition:I

    .line 1215
    iget-wide v0, p0, Lit/sephiroth/android/library/widget/AdapterView;->mNextSelectedColId:J

    iput-wide v0, p0, Lit/sephiroth/android/library/widget/AdapterView;->mSyncColId:J

    .line 1217
    :cond_0
    return-void
.end method

.method public setOnClickListener(Landroid/view/View$OnClickListener;)V
    .locals 2
    .param p1, "l"    # Landroid/view/View$OnClickListener;

    .prologue
    .line 788
    .local p0, "this":Lit/sephiroth/android/library/widget/AdapterView;, "Lit/sephiroth/android/library/widget/AdapterView<TT;>;"
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "Don\'t call setOnClickListener for an AdapterView. You probably want setOnItemClickListener instead"

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public setOnItemClickListener(Lit/sephiroth/android/library/widget/AdapterView$OnItemClickListener;)V
    .locals 0
    .param p1, "listener"    # Lit/sephiroth/android/library/widget/AdapterView$OnItemClickListener;

    .prologue
    .line 272
    .local p0, "this":Lit/sephiroth/android/library/widget/AdapterView;, "Lit/sephiroth/android/library/widget/AdapterView<TT;>;"
    iput-object p1, p0, Lit/sephiroth/android/library/widget/AdapterView;->mOnItemClickListener:Lit/sephiroth/android/library/widget/AdapterView$OnItemClickListener;

    .line 273
    return-void
.end method

.method public setOnItemLongClickListener(Lit/sephiroth/android/library/widget/AdapterView$OnItemLongClickListener;)V
    .locals 1
    .param p1, "listener"    # Lit/sephiroth/android/library/widget/AdapterView$OnItemLongClickListener;

    .prologue
    .line 337
    .local p0, "this":Lit/sephiroth/android/library/widget/AdapterView;, "Lit/sephiroth/android/library/widget/AdapterView<TT;>;"
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AdapterView;->isLongClickable()Z

    move-result v0

    if-nez v0, :cond_0

    .line 338
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lit/sephiroth/android/library/widget/AdapterView;->setLongClickable(Z)V

    .line 340
    :cond_0
    iput-object p1, p0, Lit/sephiroth/android/library/widget/AdapterView;->mOnItemLongClickListener:Lit/sephiroth/android/library/widget/AdapterView$OnItemLongClickListener;

    .line 341
    return-void
.end method

.method public setOnItemSelectedListener(Lit/sephiroth/android/library/widget/AdapterView$OnItemSelectedListener;)V
    .locals 0
    .param p1, "listener"    # Lit/sephiroth/android/library/widget/AdapterView$OnItemSelectedListener;

    .prologue
    .line 392
    .local p0, "this":Lit/sephiroth/android/library/widget/AdapterView;, "Lit/sephiroth/android/library/widget/AdapterView<TT;>;"
    iput-object p1, p0, Lit/sephiroth/android/library/widget/AdapterView;->mOnItemSelectedListener:Lit/sephiroth/android/library/widget/AdapterView$OnItemSelectedListener;

    .line 393
    return-void
.end method

.method protected setSelectedPositionInt(I)V
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 1199
    .local p0, "this":Lit/sephiroth/android/library/widget/AdapterView;, "Lit/sephiroth/android/library/widget/AdapterView<TT;>;"
    iput p1, p0, Lit/sephiroth/android/library/widget/AdapterView;->mSelectedPosition:I

    .line 1200
    invoke-virtual {p0, p1}, Lit/sephiroth/android/library/widget/AdapterView;->getItemIdAtPosition(I)J

    move-result-wide v0

    iput-wide v0, p0, Lit/sephiroth/android/library/widget/AdapterView;->mSelectedColId:J

    .line 1201
    return-void
.end method

.method public abstract setSelection(I)V
.end method
