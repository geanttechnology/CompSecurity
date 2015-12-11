.class public Lco/vine/android/views/HorizontalListView;
.super Landroid/widget/AdapterView;
.source "HorizontalListView.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/views/HorizontalListView$OnScrollListener;,
        Lco/vine/android/views/HorizontalListView$ChildWidthListener;,
        Lco/vine/android/views/HorizontalListView$FlingRunnable;,
        Lco/vine/android/views/HorizontalListView$PerformClick;,
        Lco/vine/android/views/HorizontalListView$CheckForLongPress;,
        Lco/vine/android/views/HorizontalListView$CheckForTap;,
        Lco/vine/android/views/HorizontalListView$Recycler;,
        Lco/vine/android/views/HorizontalListView$AdapterDataSetObserver;,
        Lco/vine/android/views/HorizontalListView$LayoutParams;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/AdapterView",
        "<",
        "Landroid/widget/ListAdapter;",
        ">;"
    }
.end annotation


# static fields
.field public static final NO_POSITION:I = -0x1

.field private static final TOUCH_MODE_DONE_WAITING:I = 0x2

.field private static final TOUCH_MODE_DOWN:I = 0x0

.field private static final TOUCH_MODE_FLING:I = 0x4

.field private static final TOUCH_MODE_REST:I = -0x1

.field private static final TOUCH_MODE_SCROLL:I = 0x3

.field private static final TOUCH_MODE_TAP:I = 0x1


# instance fields
.field private mAdapter:Landroid/widget/ListAdapter;

.field private mChildFillWidth:I

.field private mChildWidthListener:Lco/vine/android/views/HorizontalListView$ChildWidthListener;

.field private mClipToPadding:Z

.field private mDataChanged:Z

.field private mDataSetObserver:Landroid/database/DataSetObserver;

.field private mDivider:Landroid/graphics/drawable/Drawable;

.field private mDividerPaint:Landroid/graphics/Paint;

.field private mDividerWidth:I

.field private mDownPosition:I

.field private final mEdgePadding:I

.field private final mFillWidthHeightRatio:F

.field private mFingerScrollEnabled:Z

.field private mFirstVisiblePos:I

.field private final mFlingRunnable:Lco/vine/android/views/HorizontalListView$FlingRunnable;

.field private mHeightMeasureSpec:I

.field private final mIsRecycled:[Z

.field private mItemCount:I

.field private mLastX:I

.field private mLongPressMillis:I

.field private final mMaximumFlingVelocity:I

.field private final mMinimumFlingVelocity:I

.field private mMotionPosition:I

.field private mMotionX:I

.field private mMotionY:I

.field private mOnItemLongClickListener:Landroid/widget/AdapterView$OnItemLongClickListener;

.field private mOnScrollListener:Lco/vine/android/views/HorizontalListView$OnScrollListener;

.field private mPendingCheckForLongPress:Lco/vine/android/views/HorizontalListView$CheckForLongPress;

.field private mPendingCheckForTap:Lco/vine/android/views/HorizontalListView$CheckForTap;

.field private mPerformClick:Lco/vine/android/views/HorizontalListView$PerformClick;

.field private final mRecycler:Lco/vine/android/views/HorizontalListView$Recycler;

.field private mSelector:Landroid/graphics/drawable/Drawable;

.field private mTouchFrame:Landroid/graphics/Rect;

.field private mTouchMode:I

.field private mTouchModeReset:Ljava/lang/Runnable;

.field private final mTouchSlop:I

.field private mVelocityTracker:Landroid/view/VelocityTracker;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 194
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lco/vine/android/views/HorizontalListView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 195
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 198
    sget v0, Lco/vine/android/shared/R$attr;->horizontalListViewStyle:I

    invoke-direct {p0, p1, p2, v0}, Lco/vine/android/views/HorizontalListView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 199
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 8
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    const/4 v7, 0x1

    const/high16 v6, -0x80000000

    const/4 v5, 0x0

    .line 202
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/AdapterView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 96
    const/4 v4, -0x1

    iput v4, p0, Lco/vine/android/views/HorizontalListView;->mTouchMode:I

    .line 100
    new-instance v4, Lco/vine/android/views/HorizontalListView$Recycler;

    invoke-direct {v4, p0}, Lco/vine/android/views/HorizontalListView$Recycler;-><init>(Lco/vine/android/views/HorizontalListView;)V

    iput-object v4, p0, Lco/vine/android/views/HorizontalListView;->mRecycler:Lco/vine/android/views/HorizontalListView$Recycler;

    .line 106
    new-array v4, v7, [Z

    iput-object v4, p0, Lco/vine/android/views/HorizontalListView;->mIsRecycled:[Z

    .line 111
    iput v5, p0, Lco/vine/android/views/HorizontalListView;->mFirstVisiblePos:I

    .line 127
    iput v6, p0, Lco/vine/android/views/HorizontalListView;->mMotionX:I

    .line 132
    iput v6, p0, Lco/vine/android/views/HorizontalListView;->mMotionY:I

    .line 179
    iput-boolean v7, p0, Lco/vine/android/views/HorizontalListView;->mFingerScrollEnabled:Z

    .line 184
    iput v6, p0, Lco/vine/android/views/HorizontalListView;->mLastX:I

    .line 188
    new-instance v4, Lco/vine/android/views/HorizontalListView$FlingRunnable;

    invoke-direct {v4, p0}, Lco/vine/android/views/HorizontalListView$FlingRunnable;-><init>(Lco/vine/android/views/HorizontalListView;)V

    iput-object v4, p0, Lco/vine/android/views/HorizontalListView;->mFlingRunnable:Lco/vine/android/views/HorizontalListView$FlingRunnable;

    .line 190
    invoke-static {}, Landroid/view/ViewConfiguration;->getLongPressTimeout()I

    move-result v4

    iput v4, p0, Lco/vine/android/views/HorizontalListView;->mLongPressMillis:I

    .line 204
    sget-object v4, Lco/vine/android/shared/R$styleable;->HorizontalListView:[I

    invoke-virtual {p1, p2, v4, p3, v5}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 206
    .local v0, "a":Landroid/content/res/TypedArray;
    invoke-virtual {v0, v5}, Landroid/content/res/TypedArray;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    .line 207
    .local v2, "divider":Landroid/graphics/drawable/Drawable;
    if-eqz v2, :cond_0

    .line 208
    invoke-virtual {p0, v2}, Lco/vine/android/views/HorizontalListView;->setDivider(Landroid/graphics/drawable/Drawable;)V

    .line 210
    :cond_0
    invoke-virtual {v0, v7, v5}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result v3

    .line 212
    .local v3, "dividerWidth":I
    if-lez v3, :cond_1

    .line 213
    invoke-virtual {p0, v3}, Lco/vine/android/views/HorizontalListView;->setDividerWidth(I)V

    .line 216
    :cond_1
    const/4 v4, 0x2

    invoke-virtual {v0, v4, v5}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result v4

    iput v4, p0, Lco/vine/android/views/HorizontalListView;->mEdgePadding:I

    .line 217
    const/4 v4, 0x3

    const/4 v5, 0x0

    invoke-virtual {v0, v4, v5}, Landroid/content/res/TypedArray;->getFloat(IF)F

    move-result v4

    iput v4, p0, Lco/vine/android/views/HorizontalListView;->mFillWidthHeightRatio:F

    .line 219
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 221
    invoke-static {p1}, Landroid/view/ViewConfiguration;->get(Landroid/content/Context;)Landroid/view/ViewConfiguration;

    move-result-object v1

    .line 222
    .local v1, "configuration":Landroid/view/ViewConfiguration;
    invoke-virtual {v1}, Landroid/view/ViewConfiguration;->getScaledTouchSlop()I

    move-result v4

    iput v4, p0, Lco/vine/android/views/HorizontalListView;->mTouchSlop:I

    .line 223
    invoke-virtual {v1}, Landroid/view/ViewConfiguration;->getScaledMinimumFlingVelocity()I

    move-result v4

    iput v4, p0, Lco/vine/android/views/HorizontalListView;->mMinimumFlingVelocity:I

    .line 224
    invoke-virtual {v1}, Landroid/view/ViewConfiguration;->getScaledMaximumFlingVelocity()I

    move-result v4

    iput v4, p0, Lco/vine/android/views/HorizontalListView;->mMaximumFlingVelocity:I

    .line 225
    return-void
.end method

.method static synthetic access$000(Lco/vine/android/views/HorizontalListView;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/views/HorizontalListView;

    .prologue
    .line 48
    iget v0, p0, Lco/vine/android/views/HorizontalListView;->mTouchMode:I

    return v0
.end method

.method static synthetic access$002(Lco/vine/android/views/HorizontalListView;I)I
    .locals 0
    .param p0, "x0"    # Lco/vine/android/views/HorizontalListView;
    .param p1, "x1"    # I

    .prologue
    .line 48
    iput p1, p0, Lco/vine/android/views/HorizontalListView;->mTouchMode:I

    return p1
.end method

.method static synthetic access$100(Lco/vine/android/views/HorizontalListView;)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/views/HorizontalListView;

    .prologue
    .line 48
    iget-boolean v0, p0, Lco/vine/android/views/HorizontalListView;->mDataChanged:Z

    return v0
.end method

.method static synthetic access$1000(Lco/vine/android/views/HorizontalListView;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/views/HorizontalListView;

    .prologue
    .line 48
    iget v0, p0, Lco/vine/android/views/HorizontalListView;->mLongPressMillis:I

    return v0
.end method

.method static synthetic access$102(Lco/vine/android/views/HorizontalListView;Z)Z
    .locals 0
    .param p0, "x0"    # Lco/vine/android/views/HorizontalListView;
    .param p1, "x1"    # Z

    .prologue
    .line 48
    iput-boolean p1, p0, Lco/vine/android/views/HorizontalListView;->mDataChanged:Z

    return p1
.end method

.method static synthetic access$1100(Lco/vine/android/views/HorizontalListView;)Lco/vine/android/views/HorizontalListView$CheckForLongPress;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/views/HorizontalListView;

    .prologue
    .line 48
    iget-object v0, p0, Lco/vine/android/views/HorizontalListView;->mPendingCheckForLongPress:Lco/vine/android/views/HorizontalListView$CheckForLongPress;

    return-object v0
.end method

.method static synthetic access$1102(Lco/vine/android/views/HorizontalListView;Lco/vine/android/views/HorizontalListView$CheckForLongPress;)Lco/vine/android/views/HorizontalListView$CheckForLongPress;
    .locals 0
    .param p0, "x0"    # Lco/vine/android/views/HorizontalListView;
    .param p1, "x1"    # Lco/vine/android/views/HorizontalListView$CheckForLongPress;

    .prologue
    .line 48
    iput-object p1, p0, Lco/vine/android/views/HorizontalListView;->mPendingCheckForLongPress:Lco/vine/android/views/HorizontalListView$CheckForLongPress;

    return-object p1
.end method

.method static synthetic access$1300(Lco/vine/android/views/HorizontalListView;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/views/HorizontalListView;

    .prologue
    .line 48
    invoke-virtual {p0}, Lco/vine/android/views/HorizontalListView;->getWindowAttachCount()I

    move-result v0

    return v0
.end method

.method static synthetic access$1400(Lco/vine/android/views/HorizontalListView;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/views/HorizontalListView;

    .prologue
    .line 48
    invoke-virtual {p0}, Lco/vine/android/views/HorizontalListView;->getWindowAttachCount()I

    move-result v0

    return v0
.end method

.method static synthetic access$1500(Lco/vine/android/views/HorizontalListView;Landroid/view/View;IJ)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/views/HorizontalListView;
    .param p1, "x1"    # Landroid/view/View;
    .param p2, "x2"    # I
    .param p3, "x3"    # J

    .prologue
    .line 48
    invoke-direct {p0, p1, p2, p3, p4}, Lco/vine/android/views/HorizontalListView;->performLongPress(Landroid/view/View;IJ)Z

    move-result v0

    return v0
.end method

.method static synthetic access$1600(Lco/vine/android/views/HorizontalListView;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/views/HorizontalListView;

    .prologue
    .line 48
    invoke-virtual {p0}, Lco/vine/android/views/HorizontalListView;->getWindowAttachCount()I

    move-result v0

    return v0
.end method

.method static synthetic access$1700(Lco/vine/android/views/HorizontalListView;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/views/HorizontalListView;

    .prologue
    .line 48
    invoke-virtual {p0}, Lco/vine/android/views/HorizontalListView;->getWindowAttachCount()I

    move-result v0

    return v0
.end method

.method static synthetic access$1800(Lco/vine/android/views/HorizontalListView;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/views/HorizontalListView;

    .prologue
    .line 48
    invoke-direct {p0}, Lco/vine/android/views/HorizontalListView;->getOverflowLeft()I

    move-result v0

    return v0
.end method

.method static synthetic access$1900(Lco/vine/android/views/HorizontalListView;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/views/HorizontalListView;

    .prologue
    .line 48
    invoke-direct {p0}, Lco/vine/android/views/HorizontalListView;->getOverflowRight()I

    move-result v0

    return v0
.end method

.method static synthetic access$200(Lco/vine/android/views/HorizontalListView;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/views/HorizontalListView;

    .prologue
    .line 48
    iget v0, p0, Lco/vine/android/views/HorizontalListView;->mMotionPosition:I

    return v0
.end method

.method static synthetic access$300(Lco/vine/android/views/HorizontalListView;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/views/HorizontalListView;

    .prologue
    .line 48
    iget v0, p0, Lco/vine/android/views/HorizontalListView;->mDownPosition:I

    return v0
.end method

.method static synthetic access$400(Lco/vine/android/views/HorizontalListView;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/views/HorizontalListView;

    .prologue
    .line 48
    iget v0, p0, Lco/vine/android/views/HorizontalListView;->mItemCount:I

    return v0
.end method

.method static synthetic access$402(Lco/vine/android/views/HorizontalListView;I)I
    .locals 0
    .param p0, "x0"    # Lco/vine/android/views/HorizontalListView;
    .param p1, "x1"    # I

    .prologue
    .line 48
    iput p1, p0, Lco/vine/android/views/HorizontalListView;->mItemCount:I

    return p1
.end method

.method static synthetic access$500(Lco/vine/android/views/HorizontalListView;)Landroid/widget/ListAdapter;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/views/HorizontalListView;

    .prologue
    .line 48
    iget-object v0, p0, Lco/vine/android/views/HorizontalListView;->mAdapter:Landroid/widget/ListAdapter;

    return-object v0
.end method

.method static synthetic access$600(Lco/vine/android/views/HorizontalListView;Landroid/view/View;Z)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/views/HorizontalListView;
    .param p1, "x1"    # Landroid/view/View;
    .param p2, "x2"    # Z

    .prologue
    .line 48
    invoke-virtual {p0, p1, p2}, Lco/vine/android/views/HorizontalListView;->removeDetachedView(Landroid/view/View;Z)V

    return-void
.end method

.method static synthetic access$700(Lco/vine/android/views/HorizontalListView;Landroid/view/View;Z)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/views/HorizontalListView;
    .param p1, "x1"    # Landroid/view/View;
    .param p2, "x2"    # Z

    .prologue
    .line 48
    invoke-virtual {p0, p1, p2}, Lco/vine/android/views/HorizontalListView;->removeDetachedView(Landroid/view/View;Z)V

    return-void
.end method

.method static synthetic access$800(Lco/vine/android/views/HorizontalListView;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/views/HorizontalListView;

    .prologue
    .line 48
    iget v0, p0, Lco/vine/android/views/HorizontalListView;->mFirstVisiblePos:I

    return v0
.end method

.method static synthetic access$900(Lco/vine/android/views/HorizontalListView;)Landroid/graphics/drawable/Drawable;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/views/HorizontalListView;

    .prologue
    .line 48
    iget-object v0, p0, Lco/vine/android/views/HorizontalListView;->mSelector:Landroid/graphics/drawable/Drawable;

    return-object v0
.end method

.method private attachChild(IIIZ)Landroid/view/View;
    .locals 7
    .param p1, "position"    # I
    .param p2, "x"    # I
    .param p3, "y"    # I
    .param p4, "right"    # Z

    .prologue
    .line 857
    iget-boolean v0, p0, Lco/vine/android/views/HorizontalListView;->mDataChanged:Z

    if-nez v0, :cond_0

    .line 858
    iget-object v0, p0, Lco/vine/android/views/HorizontalListView;->mRecycler:Lco/vine/android/views/HorizontalListView$Recycler;

    invoke-virtual {v0, p1}, Lco/vine/android/views/HorizontalListView$Recycler;->getActiveView(I)Landroid/view/View;

    move-result-object v1

    .line 859
    .local v1, "child":Landroid/view/View;
    if-eqz v1, :cond_0

    .line 860
    const/4 v5, 0x1

    move-object v0, p0

    move v2, p2

    move v3, p3

    move v4, p4

    invoke-direct/range {v0 .. v5}, Lco/vine/android/views/HorizontalListView;->layoutChild(Landroid/view/View;IIZZ)V

    move-object v6, v1

    .line 866
    .end local v1    # "child":Landroid/view/View;
    .local v6, "child":Landroid/view/View;
    :goto_0
    return-object v6

    .line 864
    .end local v6    # "child":Landroid/view/View;
    :cond_0
    iget-object v0, p0, Lco/vine/android/views/HorizontalListView;->mIsRecycled:[Z

    invoke-direct {p0, p1, v0}, Lco/vine/android/views/HorizontalListView;->obtainView(I[Z)Landroid/view/View;

    move-result-object v1

    .line 865
    .restart local v1    # "child":Landroid/view/View;
    iget-object v0, p0, Lco/vine/android/views/HorizontalListView;->mIsRecycled:[Z

    const/4 v2, 0x0

    aget-boolean v5, v0, v2

    move-object v0, p0

    move v2, p2

    move v3, p3

    move v4, p4

    invoke-direct/range {v0 .. v5}, Lco/vine/android/views/HorizontalListView;->layoutChild(Landroid/view/View;IIZZ)V

    move-object v6, v1

    .line 866
    .end local v1    # "child":Landroid/view/View;
    .restart local v6    # "child":Landroid/view/View;
    goto :goto_0
.end method

.method private disallowParentIntercept(Z)V
    .locals 1
    .param p1, "disallow"    # Z

    .prologue
    .line 677
    invoke-virtual {p0}, Lco/vine/android/views/HorizontalListView;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    .line 678
    .local v0, "parent":Landroid/view/ViewParent;
    if-eqz v0, :cond_0

    .line 679
    invoke-interface {v0, p1}, Landroid/view/ViewParent;->requestDisallowInterceptTouchEvent(Z)V

    .line 681
    :cond_0
    return-void
.end method

.method private fillGap(Z)V
    .locals 5
    .param p1, "right"    # Z

    .prologue
    .line 797
    invoke-virtual {p0}, Lco/vine/android/views/HorizontalListView;->getChildCount()I

    move-result v0

    .line 798
    .local v0, "count":I
    if-eqz p1, :cond_1

    .line 800
    if-lez v0, :cond_0

    .line 801
    add-int/lit8 v3, v0, -0x1

    invoke-virtual {p0, v3}, Lco/vine/android/views/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v3

    invoke-virtual {v3}, Landroid/view/View;->getRight()I

    move-result v3

    iget v4, p0, Lco/vine/android/views/HorizontalListView;->mDividerWidth:I

    add-int v1, v3, v4

    .line 805
    .local v1, "nextLeft":I
    :goto_0
    iget v3, p0, Lco/vine/android/views/HorizontalListView;->mFirstVisiblePos:I

    add-int/2addr v3, v0

    invoke-direct {p0, v3, v1}, Lco/vine/android/views/HorizontalListView;->fillRight(II)V

    .line 817
    .end local v1    # "nextLeft":I
    :goto_1
    return-void

    .line 803
    :cond_0
    invoke-virtual {p0}, Lco/vine/android/views/HorizontalListView;->getPaddingLeft()I

    move-result v1

    .restart local v1    # "nextLeft":I
    goto :goto_0

    .line 809
    .end local v1    # "nextLeft":I
    :cond_1
    if-lez v0, :cond_2

    .line 810
    const/4 v3, 0x0

    invoke-virtual {p0, v3}, Lco/vine/android/views/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v3

    invoke-virtual {v3}, Landroid/view/View;->getLeft()I

    move-result v3

    iget v4, p0, Lco/vine/android/views/HorizontalListView;->mDividerWidth:I

    sub-int v2, v3, v4

    .line 814
    .local v2, "nextRight":I
    :goto_2
    iget v3, p0, Lco/vine/android/views/HorizontalListView;->mFirstVisiblePos:I

    add-int/lit8 v3, v3, -0x1

    invoke-direct {p0, v3, v2}, Lco/vine/android/views/HorizontalListView;->fillLeft(II)V

    goto :goto_1

    .line 812
    .end local v2    # "nextRight":I
    :cond_2
    const/4 v2, 0x0

    .restart local v2    # "nextRight":I
    goto :goto_2
.end method

.method private fillLeft(II)V
    .locals 6
    .param p1, "pos"    # I
    .param p2, "nextRight"    # I

    .prologue
    const/4 v5, 0x0

    .line 820
    invoke-virtual {p0}, Lco/vine/android/views/HorizontalListView;->getPaddingTop()I

    move-result v0

    .line 821
    .local v0, "childrenTop":I
    invoke-virtual {p0}, Lco/vine/android/views/HorizontalListView;->getPaddingLeft()I

    move-result v1

    .line 824
    .local v1, "listLeft":I
    :goto_0
    if-le p2, v1, :cond_0

    if-ltz p1, :cond_0

    .line 825
    invoke-direct {p0, p1, p2, v0, v5}, Lco/vine/android/views/HorizontalListView;->attachChild(IIIZ)Landroid/view/View;

    move-result-object v2

    .line 826
    .local v2, "v":Landroid/view/View;
    invoke-virtual {v2}, Landroid/view/View;->getLeft()I

    move-result v3

    iget v4, p0, Lco/vine/android/views/HorizontalListView;->mDividerWidth:I

    sub-int p2, v3, v4

    .line 827
    add-int/lit8 p1, p1, -0x1

    goto :goto_0

    .line 829
    .end local v2    # "v":Landroid/view/View;
    :cond_0
    iget v3, p0, Lco/vine/android/views/HorizontalListView;->mItemCount:I

    if-lez v3, :cond_1

    const/4 v3, -0x1

    if-ne p1, v3, :cond_1

    invoke-direct {p0}, Lco/vine/android/views/HorizontalListView;->getOverflowLeft()I

    move-result v3

    if-gez v3, :cond_1

    .line 830
    invoke-virtual {p0}, Lco/vine/android/views/HorizontalListView;->detachAllViewsFromParent()V

    .line 831
    iput v5, p0, Lco/vine/android/views/HorizontalListView;->mFirstVisiblePos:I

    .line 832
    invoke-virtual {p0}, Lco/vine/android/views/HorizontalListView;->getPaddingLeft()I

    move-result v3

    invoke-direct {p0, v5, v3}, Lco/vine/android/views/HorizontalListView;->fillRight(II)V

    .line 836
    :goto_1
    return-void

    .line 834
    :cond_1
    add-int/lit8 v3, p1, 0x1

    iput v3, p0, Lco/vine/android/views/HorizontalListView;->mFirstVisiblePos:I

    goto :goto_1
.end method

.method private fillRight(II)V
    .locals 5
    .param p1, "pos"    # I
    .param p2, "nextLeft"    # I

    .prologue
    .line 839
    invoke-virtual {p0}, Lco/vine/android/views/HorizontalListView;->getPaddingTop()I

    move-result v0

    .line 840
    .local v0, "childrenTop":I
    invoke-virtual {p0}, Lco/vine/android/views/HorizontalListView;->getWidth()I

    move-result v3

    invoke-virtual {p0}, Lco/vine/android/views/HorizontalListView;->getPaddingRight()I

    move-result v4

    sub-int v1, v3, v4

    .line 842
    .local v1, "listRight":I
    :goto_0
    if-ge p2, v1, :cond_0

    iget v3, p0, Lco/vine/android/views/HorizontalListView;->mItemCount:I

    if-ge p1, v3, :cond_0

    .line 843
    const/4 v3, 0x1

    invoke-direct {p0, p1, p2, v0, v3}, Lco/vine/android/views/HorizontalListView;->attachChild(IIIZ)Landroid/view/View;

    move-result-object v2

    .line 844
    .local v2, "v":Landroid/view/View;
    invoke-virtual {v2}, Landroid/view/View;->getRight()I

    move-result v3

    iget v4, p0, Lco/vine/android/views/HorizontalListView;->mDividerWidth:I

    add-int p2, v3, v4

    .line 845
    add-int/lit8 p1, p1, 0x1

    goto :goto_0

    .line 847
    .end local v2    # "v":Landroid/view/View;
    :cond_0
    iget v3, p0, Lco/vine/android/views/HorizontalListView;->mDividerWidth:I

    sub-int/2addr p2, v3

    .line 848
    iget v3, p0, Lco/vine/android/views/HorizontalListView;->mItemCount:I

    if-lez v3, :cond_2

    iget v3, p0, Lco/vine/android/views/HorizontalListView;->mItemCount:I

    if-ne p1, v3, :cond_2

    invoke-direct {p0}, Lco/vine/android/views/HorizontalListView;->getOverflowRight()I

    move-result v3

    if-gez v3, :cond_2

    iget v3, p0, Lco/vine/android/views/HorizontalListView;->mFirstVisiblePos:I

    if-gtz v3, :cond_1

    invoke-direct {p0}, Lco/vine/android/views/HorizontalListView;->getOverflowLeft()I

    move-result v3

    if-lez v3, :cond_2

    .line 850
    :cond_1
    invoke-virtual {p0}, Lco/vine/android/views/HorizontalListView;->detachAllViewsFromParent()V

    .line 851
    iget v3, p0, Lco/vine/android/views/HorizontalListView;->mItemCount:I

    add-int/lit8 v3, v3, -0x1

    iget v4, p0, Lco/vine/android/views/HorizontalListView;->mEdgePadding:I

    sub-int v4, v1, v4

    invoke-direct {p0, v3, v4}, Lco/vine/android/views/HorizontalListView;->fillLeft(II)V

    .line 853
    :cond_2
    return-void
.end method

.method private getOverflowLeft()I
    .locals 4

    .prologue
    .line 789
    invoke-virtual {p0}, Lco/vine/android/views/HorizontalListView;->getPaddingLeft()I

    move-result v2

    iget v3, p0, Lco/vine/android/views/HorizontalListView;->mEdgePadding:I

    add-int v1, v2, v3

    .line 790
    .local v1, "listLeft":I
    const/4 v2, 0x0

    invoke-virtual {p0, v2}, Lco/vine/android/views/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/View;->getLeft()I

    move-result v0

    .line 791
    .local v0, "firstChildLeft":I
    sub-int v2, v1, v0

    return v2
.end method

.method private getOverflowRight()I
    .locals 4

    .prologue
    .line 780
    invoke-virtual {p0}, Lco/vine/android/views/HorizontalListView;->getWidth()I

    move-result v2

    invoke-virtual {p0}, Lco/vine/android/views/HorizontalListView;->getPaddingRight()I

    move-result v3

    sub-int/2addr v2, v3

    iget v3, p0, Lco/vine/android/views/HorizontalListView;->mEdgePadding:I

    sub-int v1, v2, v3

    .line 781
    .local v1, "listRight":I
    invoke-virtual {p0}, Lco/vine/android/views/HorizontalListView;->getChildCount()I

    move-result v2

    add-int/lit8 v2, v2, -0x1

    invoke-virtual {p0, v2}, Lco/vine/android/views/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/View;->getRight()I

    move-result v0

    .line 782
    .local v0, "lastChildRight":I
    sub-int v2, v0, v1

    return v2
.end method

.method private layoutChild(Landroid/view/View;IIZZ)V
    .locals 14
    .param p1, "child"    # Landroid/view/View;
    .param p2, "x"    # I
    .param p3, "y"    # I
    .param p4, "right"    # Z
    .param p5, "recycled"    # Z

    .prologue
    .line 888
    invoke-virtual {p1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v9

    check-cast v9, Lco/vine/android/views/HorizontalListView$LayoutParams;

    .line 890
    .local v9, "p":Lco/vine/android/views/HorizontalListView$LayoutParams;
    if-nez v9, :cond_0

    .line 891
    invoke-virtual {p0}, Lco/vine/android/views/HorizontalListView;->generateDefaultLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v9

    .end local v9    # "p":Lco/vine/android/views/HorizontalListView$LayoutParams;
    check-cast v9, Lco/vine/android/views/HorizontalListView$LayoutParams;

    .line 892
    .restart local v9    # "p":Lco/vine/android/views/HorizontalListView$LayoutParams;
    invoke-virtual {p1, v9}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 894
    :cond_0
    if-eqz p5, :cond_3

    .line 895
    if-eqz p4, :cond_2

    const/4 v11, -0x1

    :goto_0
    invoke-virtual {p0, p1, v11, v9}, Lco/vine/android/views/HorizontalListView;->attachViewToParent(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V

    .line 900
    :goto_1
    if-eqz p5, :cond_1

    invoke-virtual {p1}, Landroid/view/View;->isLayoutRequested()Z

    move-result v11

    if-eqz v11, :cond_5

    :cond_1
    const/4 v8, 0x1

    .line 901
    .local v8, "needToMeasure":Z
    :goto_2
    if-eqz v8, :cond_8

    .line 902
    iget v11, p0, Lco/vine/android/views/HorizontalListView;->mHeightMeasureSpec:I

    invoke-virtual {p0}, Lco/vine/android/views/HorizontalListView;->getPaddingTop()I

    move-result v12

    invoke-virtual {p0}, Lco/vine/android/views/HorizontalListView;->getPaddingBottom()I

    move-result v13

    add-int/2addr v12, v13

    iget v13, v9, Lco/vine/android/views/HorizontalListView$LayoutParams;->height:I

    invoke-static {v11, v12, v13}, Landroid/view/ViewGroup;->getChildMeasureSpec(III)I

    move-result v2

    .line 904
    .local v2, "childHeightSpec":I
    iget v11, p0, Lco/vine/android/views/HorizontalListView;->mChildFillWidth:I

    if-lez v11, :cond_6

    iget v7, p0, Lco/vine/android/views/HorizontalListView;->mChildFillWidth:I

    .line 906
    .local v7, "lpWidth":I
    :goto_3
    if-lez v7, :cond_7

    .line 907
    const/high16 v11, 0x40000000    # 2.0f

    invoke-static {v7, v11}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v5

    .line 911
    .local v5, "childWidthSpec":I
    :goto_4
    invoke-virtual {p1, v5, v2}, Landroid/view/View;->measure(II)V

    .line 916
    .end local v2    # "childHeightSpec":I
    .end local v5    # "childWidthSpec":I
    .end local v7    # "lpWidth":I
    :goto_5
    invoke-virtual {p1}, Landroid/view/View;->getMeasuredWidth()I

    move-result v10

    .line 917
    .local v10, "w":I
    invoke-virtual {p1}, Landroid/view/View;->getMeasuredHeight()I

    move-result v6

    .line 918
    .local v6, "h":I
    if-eqz p4, :cond_9

    move/from16 v3, p2

    .line 920
    .local v3, "childLeft":I
    :goto_6
    if-eqz v8, :cond_a

    .line 921
    add-int v4, v3, v10

    .line 922
    .local v4, "childRight":I
    add-int v1, p3, v6

    .line 923
    .local v1, "childBottom":I
    move/from16 v0, p3

    invoke-virtual {p1, v3, v0, v4, v1}, Landroid/view/View;->layout(IIII)V

    .line 928
    .end local v1    # "childBottom":I
    .end local v4    # "childRight":I
    :goto_7
    return-void

    .line 895
    .end local v3    # "childLeft":I
    .end local v6    # "h":I
    .end local v8    # "needToMeasure":Z
    .end local v10    # "w":I
    :cond_2
    const/4 v11, 0x0

    goto :goto_0

    .line 897
    :cond_3
    if-eqz p4, :cond_4

    const/4 v11, -0x1

    :goto_8
    const/4 v12, 0x1

    invoke-virtual {p0, p1, v11, v9, v12}, Lco/vine/android/views/HorizontalListView;->addViewInLayout(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;Z)Z

    goto :goto_1

    :cond_4
    const/4 v11, 0x0

    goto :goto_8

    .line 900
    :cond_5
    const/4 v8, 0x0

    goto :goto_2

    .line 904
    .restart local v2    # "childHeightSpec":I
    .restart local v8    # "needToMeasure":Z
    :cond_6
    iget v7, v9, Lco/vine/android/views/HorizontalListView$LayoutParams;->width:I

    goto :goto_3

    .line 909
    .restart local v7    # "lpWidth":I
    :cond_7
    const/4 v11, 0x0

    const/4 v12, 0x0

    invoke-static {v11, v12}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v5

    .restart local v5    # "childWidthSpec":I
    goto :goto_4

    .line 913
    .end local v2    # "childHeightSpec":I
    .end local v5    # "childWidthSpec":I
    .end local v7    # "lpWidth":I
    :cond_8
    invoke-virtual {p0, p1}, Lco/vine/android/views/HorizontalListView;->cleanupLayoutState(Landroid/view/View;)V

    goto :goto_5

    .line 918
    .restart local v6    # "h":I
    .restart local v10    # "w":I
    :cond_9
    sub-int v3, p2, v10

    goto :goto_6

    .line 925
    .restart local v3    # "childLeft":I
    :cond_a
    invoke-virtual {p1}, Landroid/view/View;->getLeft()I

    move-result v11

    sub-int v11, v3, v11

    invoke-virtual {p1, v11}, Landroid/view/View;->offsetLeftAndRight(I)V

    .line 926
    invoke-virtual {p1}, Landroid/view/View;->getTop()I

    move-result v11

    sub-int v11, p3, v11

    invoke-virtual {p1, v11}, Landroid/view/View;->offsetTopAndBottom(I)V

    goto :goto_7
.end method

.method private measureChild(Landroid/view/View;I)V
    .locals 7
    .param p1, "child"    # Landroid/view/View;
    .param p2, "heightMeasureSpec"    # I

    .prologue
    const/4 v6, 0x0

    .line 354
    invoke-virtual {p1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v3

    check-cast v3, Lco/vine/android/views/HorizontalListView$LayoutParams;

    .line 355
    .local v3, "p":Lco/vine/android/views/HorizontalListView$LayoutParams;
    if-nez v3, :cond_0

    .line 356
    invoke-virtual {p0}, Lco/vine/android/views/HorizontalListView;->generateDefaultLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v3

    .end local v3    # "p":Lco/vine/android/views/HorizontalListView$LayoutParams;
    check-cast v3, Lco/vine/android/views/HorizontalListView$LayoutParams;

    .line 357
    .restart local v3    # "p":Lco/vine/android/views/HorizontalListView$LayoutParams;
    invoke-virtual {p1, v3}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 360
    :cond_0
    invoke-virtual {p0}, Lco/vine/android/views/HorizontalListView;->getPaddingTop()I

    move-result v4

    invoke-virtual {p0}, Lco/vine/android/views/HorizontalListView;->getPaddingBottom()I

    move-result v5

    add-int/2addr v4, v5

    iget v5, v3, Lco/vine/android/views/HorizontalListView$LayoutParams;->height:I

    invoke-static {p2, v4, v5}, Landroid/view/ViewGroup;->getChildMeasureSpec(III)I

    move-result v0

    .line 362
    .local v0, "childHeightSpec":I
    iget v2, v3, Lco/vine/android/views/HorizontalListView$LayoutParams;->width:I

    .line 364
    .local v2, "lpWidth":I
    if-lez v2, :cond_1

    .line 365
    const/high16 v4, 0x40000000    # 2.0f

    invoke-static {v2, v4}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v1

    .line 369
    .local v1, "childWidthSpec":I
    :goto_0
    invoke-virtual {p1, v1, v0}, Landroid/view/View;->measure(II)V

    .line 370
    return-void

    .line 367
    .end local v1    # "childWidthSpec":I
    :cond_1
    invoke-static {v6, v6}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v1

    .restart local v1    # "childWidthSpec":I
    goto :goto_0
.end method

.method private obtainView(I[Z)Landroid/view/View;
    .locals 4
    .param p1, "position"    # I
    .param p2, "isRecycled"    # [Z

    .prologue
    .line 871
    iget-object v2, p0, Lco/vine/android/views/HorizontalListView;->mRecycler:Lco/vine/android/views/HorizontalListView$Recycler;

    invoke-virtual {v2, p1}, Lco/vine/android/views/HorizontalListView$Recycler;->removeRecycleView(I)Landroid/view/View;

    move-result-object v1

    .line 872
    .local v1, "convertView":Landroid/view/View;
    if-eqz v1, :cond_1

    .line 873
    iget-object v2, p0, Lco/vine/android/views/HorizontalListView;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v2, p1, v1, p0}, Landroid/widget/ListAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 876
    .local v0, "child":Landroid/view/View;
    if-eq v0, v1, :cond_0

    .line 877
    iget-object v2, p0, Lco/vine/android/views/HorizontalListView;->mRecycler:Lco/vine/android/views/HorizontalListView$Recycler;

    invoke-virtual {v2, v1, p1}, Lco/vine/android/views/HorizontalListView$Recycler;->addRecycleView(Landroid/view/View;I)V

    .line 884
    :goto_0
    return-object v0

    .line 879
    :cond_0
    const/4 v2, 0x0

    const/4 v3, 0x1

    aput-boolean v3, p2, v2

    goto :goto_0

    .line 882
    .end local v0    # "child":Landroid/view/View;
    :cond_1
    iget-object v2, p0, Lco/vine/android/views/HorizontalListView;->mAdapter:Landroid/widget/ListAdapter;

    const/4 v3, 0x0

    invoke-interface {v2, p1, v3, p0}, Landroid/widget/ListAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .restart local v0    # "child":Landroid/view/View;
    goto :goto_0
.end method

.method private performLongPress(Landroid/view/View;IJ)Z
    .locals 7
    .param p1, "child"    # Landroid/view/View;
    .param p2, "longPressPosition"    # I
    .param p3, "longPressId"    # J

    .prologue
    .line 1353
    const/4 v6, 0x0

    .line 1355
    .local v6, "handled":Z
    iget-object v0, p0, Lco/vine/android/views/HorizontalListView;->mOnItemLongClickListener:Landroid/widget/AdapterView$OnItemLongClickListener;

    if-eqz v0, :cond_0

    .line 1356
    iget-object v0, p0, Lco/vine/android/views/HorizontalListView;->mOnItemLongClickListener:Landroid/widget/AdapterView$OnItemLongClickListener;

    move-object v1, p0

    move-object v2, p1

    move v3, p2

    move-wide v4, p3

    invoke-interface/range {v0 .. v5}, Landroid/widget/AdapterView$OnItemLongClickListener;->onItemLongClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)Z

    move-result v6

    .line 1359
    :cond_0
    if-eqz v6, :cond_1

    .line 1360
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lco/vine/android/views/HorizontalListView;->performHapticFeedback(I)Z

    .line 1362
    :cond_1
    return v6
.end method

.method private recycleVelocityTracker()V
    .locals 1

    .prologue
    .line 465
    iget-object v0, p0, Lco/vine/android/views/HorizontalListView;->mVelocityTracker:Landroid/view/VelocityTracker;

    invoke-virtual {v0}, Landroid/view/VelocityTracker;->recycle()V

    .line 466
    const/4 v0, 0x0

    iput-object v0, p0, Lco/vine/android/views/HorizontalListView;->mVelocityTracker:Landroid/view/VelocityTracker;

    .line 467
    return-void
.end method


# virtual methods
.method protected checkLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Z
    .locals 1
    .param p1, "p"    # Landroid/view/ViewGroup$LayoutParams;

    .prologue
    .line 964
    instance-of v0, p1, Lco/vine/android/views/HorizontalListView$LayoutParams;

    return v0
.end method

.method protected dispatchDraw(Landroid/graphics/Canvas;)V
    .locals 19
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 1013
    move-object/from16 v0, p0

    iget v6, v0, Lco/vine/android/views/HorizontalListView;->mDividerWidth:I

    .line 1014
    .local v6, "dividerWidth":I
    if-lez v6, :cond_3

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/views/HorizontalListView;->mDivider:Landroid/graphics/drawable/Drawable;

    move-object/from16 v17, v0

    if-eqz v17, :cond_3

    const/4 v7, 0x1

    .line 1016
    .local v7, "drawDividers":Z
    :goto_0
    if-eqz v7, :cond_8

    .line 1018
    new-instance v3, Landroid/graphics/Rect;

    invoke-direct {v3}, Landroid/graphics/Rect;-><init>()V

    .line 1019
    .local v3, "bounds":Landroid/graphics/Rect;
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/views/HorizontalListView;->getPaddingLeft()I

    move-result v17

    move/from16 v0, v17

    iput v0, v3, Landroid/graphics/Rect;->left:I

    .line 1020
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/views/HorizontalListView;->getWidth()I

    move-result v17

    invoke-virtual/range {p0 .. p0}, Lco/vine/android/views/HorizontalListView;->getPaddingRight()I

    move-result v18

    sub-int v17, v17, v18

    move/from16 v0, v17

    iput v0, v3, Landroid/graphics/Rect;->right:I

    .line 1022
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/views/HorizontalListView;->getChildCount()I

    move-result v5

    .line 1023
    .local v5, "count":I
    move-object/from16 v0, p0

    iget v11, v0, Lco/vine/android/views/HorizontalListView;->mFirstVisiblePos:I

    .line 1024
    .local v11, "first":I
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/views/HorizontalListView;->mAdapter:Landroid/widget/ListAdapter;

    .line 1025
    .local v2, "adapter":Landroid/widget/ListAdapter;
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/views/HorizontalListView;->getScrollX()I

    move-result v16

    .line 1030
    .local v16, "scrollX":I
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/views/HorizontalListView;->isOpaque()Z

    move-result v17

    if-eqz v17, :cond_4

    invoke-super/range {p0 .. p0}, Landroid/widget/AdapterView;->isOpaque()Z

    move-result v17

    if-nez v17, :cond_4

    const/4 v10, 0x1

    .line 1032
    .local v10, "fillForMissingDividers":Z
    :goto_1
    if-eqz v10, :cond_0

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/views/HorizontalListView;->mDividerPaint:Landroid/graphics/Paint;

    move-object/from16 v17, v0

    if-nez v17, :cond_0

    .line 1033
    new-instance v17, Landroid/graphics/Paint;

    invoke-direct/range {v17 .. v17}, Landroid/graphics/Paint;-><init>()V

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/views/HorizontalListView;->mDividerPaint:Landroid/graphics/Paint;

    .line 1035
    :cond_0
    move-object/from16 v0, p0

    iget-object v15, v0, Lco/vine/android/views/HorizontalListView;->mDividerPaint:Landroid/graphics/Paint;

    .line 1038
    .local v15, "paint":Landroid/graphics/Paint;
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lco/vine/android/views/HorizontalListView;->mClipToPadding:Z

    move/from16 v17, v0

    if-eqz v17, :cond_5

    .line 1039
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/views/HorizontalListView;->getPaddingLeft()I

    move-result v8

    .line 1040
    .local v8, "effectivePaddingLeft":I
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/views/HorizontalListView;->getPaddingRight()I

    move-result v9

    .line 1046
    .local v9, "effectivePaddingRight":I
    :goto_2
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/views/HorizontalListView;->getWidth()I

    move-result v17

    add-int v17, v17, v16

    sub-int v14, v17, v9

    .line 1049
    .local v14, "listRight":I
    const/4 v12, 0x0

    .local v12, "i":I
    :goto_3
    if-ge v12, v5, :cond_7

    .line 1050
    move-object/from16 v0, p0

    invoke-virtual {v0, v12}, Lco/vine/android/views/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v4

    .line 1051
    .local v4, "child":Landroid/view/View;
    invoke-virtual {v4}, Landroid/view/View;->getLeft()I

    move-result v13

    .line 1053
    .local v13, "left":I
    if-le v13, v8, :cond_2

    .line 1054
    add-int v17, v11, v12

    move/from16 v0, v17

    invoke-interface {v2, v0}, Landroid/widget/ListAdapter;->isEnabled(I)Z

    move-result v17

    if-eqz v17, :cond_6

    add-int/lit8 v17, v5, -0x1

    move/from16 v0, v17

    if-eq v12, v0, :cond_1

    add-int v17, v11, v12

    add-int/lit8 v17, v17, 0x1

    move/from16 v0, v17

    invoke-interface {v2, v0}, Landroid/widget/ListAdapter;->isEnabled(I)Z

    move-result v17

    if-eqz v17, :cond_6

    .line 1056
    :cond_1
    sub-int v17, v13, v6

    move/from16 v0, v17

    iput v0, v3, Landroid/graphics/Rect;->left:I

    .line 1057
    iput v13, v3, Landroid/graphics/Rect;->right:I

    .line 1062
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    invoke-virtual {v0, v1, v3}, Lco/vine/android/views/HorizontalListView;->drawDivider(Landroid/graphics/Canvas;Landroid/graphics/Rect;)V

    .line 1049
    :cond_2
    :goto_4
    add-int/lit8 v12, v12, 0x1

    goto :goto_3

    .line 1014
    .end local v2    # "adapter":Landroid/widget/ListAdapter;
    .end local v3    # "bounds":Landroid/graphics/Rect;
    .end local v4    # "child":Landroid/view/View;
    .end local v5    # "count":I
    .end local v7    # "drawDividers":Z
    .end local v8    # "effectivePaddingLeft":I
    .end local v9    # "effectivePaddingRight":I
    .end local v10    # "fillForMissingDividers":Z
    .end local v11    # "first":I
    .end local v12    # "i":I
    .end local v13    # "left":I
    .end local v14    # "listRight":I
    .end local v15    # "paint":Landroid/graphics/Paint;
    .end local v16    # "scrollX":I
    :cond_3
    const/4 v7, 0x0

    goto/16 :goto_0

    .line 1030
    .restart local v2    # "adapter":Landroid/widget/ListAdapter;
    .restart local v3    # "bounds":Landroid/graphics/Rect;
    .restart local v5    # "count":I
    .restart local v7    # "drawDividers":Z
    .restart local v11    # "first":I
    .restart local v16    # "scrollX":I
    :cond_4
    const/4 v10, 0x0

    goto :goto_1

    .line 1042
    .restart local v10    # "fillForMissingDividers":Z
    .restart local v15    # "paint":Landroid/graphics/Paint;
    :cond_5
    const/4 v8, 0x0

    .line 1043
    .restart local v8    # "effectivePaddingLeft":I
    const/4 v9, 0x0

    .restart local v9    # "effectivePaddingRight":I
    goto :goto_2

    .line 1063
    .restart local v4    # "child":Landroid/view/View;
    .restart local v12    # "i":I
    .restart local v13    # "left":I
    .restart local v14    # "listRight":I
    :cond_6
    if-eqz v10, :cond_2

    .line 1064
    sub-int v17, v13, v6

    move/from16 v0, v17

    iput v0, v3, Landroid/graphics/Rect;->left:I

    .line 1065
    iput v13, v3, Landroid/graphics/Rect;->right:I

    .line 1066
    move-object/from16 v0, p1

    invoke-virtual {v0, v3, v15}, Landroid/graphics/Canvas;->drawRect(Landroid/graphics/Rect;Landroid/graphics/Paint;)V

    goto :goto_4

    .line 1071
    .end local v4    # "child":Landroid/view/View;
    .end local v13    # "left":I
    :cond_7
    if-lez v5, :cond_8

    if-lez v16, :cond_8

    if-eqz v7, :cond_8

    .line 1072
    iput v14, v3, Landroid/graphics/Rect;->left:I

    .line 1073
    add-int v17, v14, v6

    move/from16 v0, v17

    iput v0, v3, Landroid/graphics/Rect;->right:I

    .line 1074
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    invoke-virtual {v0, v1, v3}, Lco/vine/android/views/HorizontalListView;->drawDivider(Landroid/graphics/Canvas;Landroid/graphics/Rect;)V

    .line 1079
    .end local v2    # "adapter":Landroid/widget/ListAdapter;
    .end local v3    # "bounds":Landroid/graphics/Rect;
    .end local v5    # "count":I
    .end local v8    # "effectivePaddingLeft":I
    .end local v9    # "effectivePaddingRight":I
    .end local v10    # "fillForMissingDividers":Z
    .end local v11    # "first":I
    .end local v12    # "i":I
    .end local v14    # "listRight":I
    .end local v15    # "paint":Landroid/graphics/Paint;
    .end local v16    # "scrollX":I
    :cond_8
    invoke-super/range {p0 .. p1}, Landroid/widget/AdapterView;->dispatchDraw(Landroid/graphics/Canvas;)V

    .line 1080
    return-void
.end method

.method drawDivider(Landroid/graphics/Canvas;Landroid/graphics/Rect;)V
    .locals 1
    .param p1, "canvas"    # Landroid/graphics/Canvas;
    .param p2, "bounds"    # Landroid/graphics/Rect;

    .prologue
    .line 1090
    iget-object v0, p0, Lco/vine/android/views/HorizontalListView;->mDivider:Landroid/graphics/drawable/Drawable;

    .line 1091
    .local v0, "divider":Landroid/graphics/drawable/Drawable;
    invoke-virtual {v0, p2}, Landroid/graphics/drawable/Drawable;->setBounds(Landroid/graphics/Rect;)V

    .line 1092
    invoke-virtual {v0, p1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 1093
    return-void
.end method

.method protected generateDefaultLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    .locals 3

    .prologue
    .line 959
    new-instance v0, Lco/vine/android/views/HorizontalListView$LayoutParams;

    const/4 v1, -0x2

    const/4 v2, -0x1

    invoke-direct {v0, v1, v2}, Lco/vine/android/views/HorizontalListView$LayoutParams;-><init>(II)V

    return-object v0
.end method

.method public bridge synthetic generateLayoutParams(Landroid/util/AttributeSet;)Landroid/view/ViewGroup$LayoutParams;
    .locals 1
    .param p1, "x0"    # Landroid/util/AttributeSet;

    .prologue
    .line 48
    invoke-virtual {p0, p1}, Lco/vine/android/views/HorizontalListView;->generateLayoutParams(Landroid/util/AttributeSet;)Lco/vine/android/views/HorizontalListView$LayoutParams;

    move-result-object v0

    return-object v0
.end method

.method protected generateLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Landroid/view/ViewGroup$LayoutParams;
    .locals 1
    .param p1, "p"    # Landroid/view/ViewGroup$LayoutParams;

    .prologue
    .line 974
    new-instance v0, Lco/vine/android/views/HorizontalListView$LayoutParams;

    invoke-direct {v0, p1}, Lco/vine/android/views/HorizontalListView$LayoutParams;-><init>(Landroid/view/ViewGroup$LayoutParams;)V

    return-object v0
.end method

.method public generateLayoutParams(Landroid/util/AttributeSet;)Lco/vine/android/views/HorizontalListView$LayoutParams;
    .locals 2
    .param p1, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 969
    new-instance v0, Lco/vine/android/views/HorizontalListView$LayoutParams;

    invoke-virtual {p0}, Lco/vine/android/views/HorizontalListView;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1, p1}, Lco/vine/android/views/HorizontalListView$LayoutParams;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    return-object v0
.end method

.method public bridge synthetic getAdapter()Landroid/widget/Adapter;
    .locals 1

    .prologue
    .line 48
    invoke-virtual {p0}, Lco/vine/android/views/HorizontalListView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    return-object v0
.end method

.method public getAdapter()Landroid/widget/ListAdapter;
    .locals 1

    .prologue
    .line 242
    iget-object v0, p0, Lco/vine/android/views/HorizontalListView;->mAdapter:Landroid/widget/ListAdapter;

    return-object v0
.end method

.method public getDividerWidth()I
    .locals 1

    .prologue
    .line 1511
    iget v0, p0, Lco/vine/android/views/HorizontalListView;->mDividerWidth:I

    return v0
.end method

.method public getFirstVisiblePosition()I
    .locals 1

    .prologue
    .line 229
    iget v0, p0, Lco/vine/android/views/HorizontalListView;->mFirstVisiblePos:I

    return v0
.end method

.method public getLastVisiblePosition()I
    .locals 2

    .prologue
    .line 234
    iget v0, p0, Lco/vine/android/views/HorizontalListView;->mFirstVisiblePos:I

    invoke-virtual {p0}, Lco/vine/android/views/HorizontalListView;->getChildCount()I

    move-result v1

    add-int/2addr v0, v1

    add-int/lit8 v0, v0, -0x1

    return v0
.end method

.method public getSelectedView()Landroid/view/View;
    .locals 1

    .prologue
    .line 282
    const/4 v0, 0x0

    return-object v0
.end method

.method protected layoutChildren()V
    .locals 9

    .prologue
    const/4 v8, 0x0

    .line 931
    iget-boolean v1, p0, Lco/vine/android/views/HorizontalListView;->mDataChanged:Z

    .line 932
    .local v1, "dataChanged":Z
    iget v2, p0, Lco/vine/android/views/HorizontalListView;->mFirstVisiblePos:I

    .line 933
    .local v2, "firstPos":I
    iget-object v5, p0, Lco/vine/android/views/HorizontalListView;->mRecycler:Lco/vine/android/views/HorizontalListView$Recycler;

    .line 934
    .local v5, "recyler":Lco/vine/android/views/HorizontalListView$Recycler;
    invoke-virtual {p0}, Lco/vine/android/views/HorizontalListView;->getChildCount()I

    move-result v0

    .line 935
    .local v0, "childCount":I
    invoke-virtual {p0, v8}, Lco/vine/android/views/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v4

    .line 937
    .local v4, "prevFirst":Landroid/view/View;
    if-eqz v1, :cond_0

    .line 939
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    if-ge v3, v0, :cond_1

    .line 940
    invoke-virtual {p0, v3}, Lco/vine/android/views/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v6

    add-int v7, v2, v3

    invoke-virtual {v5, v6, v7}, Lco/vine/android/views/HorizontalListView$Recycler;->addRecycleView(Landroid/view/View;I)V

    .line 939
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 943
    .end local v3    # "i":I
    :cond_0
    invoke-virtual {v5, v2, v0}, Lco/vine/android/views/HorizontalListView$Recycler;->fillActiveViews(II)V

    .line 946
    :cond_1
    invoke-virtual {p0}, Lco/vine/android/views/HorizontalListView;->detachAllViewsFromParent()V

    .line 948
    if-nez v4, :cond_2

    .line 949
    invoke-virtual {p0}, Lco/vine/android/views/HorizontalListView;->getPaddingLeft()I

    move-result v6

    iget v7, p0, Lco/vine/android/views/HorizontalListView;->mEdgePadding:I

    add-int/2addr v6, v7

    invoke-direct {p0, v2, v6}, Lco/vine/android/views/HorizontalListView;->fillRight(II)V

    .line 953
    :goto_1
    invoke-virtual {v5}, Lco/vine/android/views/HorizontalListView$Recycler;->recycleActiveViews()V

    .line 954
    iput-boolean v8, p0, Lco/vine/android/views/HorizontalListView;->mDataChanged:Z

    .line 955
    return-void

    .line 951
    :cond_2
    invoke-virtual {v4}, Landroid/view/View;->getLeft()I

    move-result v6

    invoke-direct {p0, v2, v6}, Lco/vine/android/views/HorizontalListView;->fillRight(II)V

    goto :goto_1
.end method

.method final measureWidthOfChildren(IIIII)I
    .locals 10
    .param p1, "heightMeasureSpec"    # I
    .param p2, "startPosition"    # I
    .param p3, "endPosition"    # I
    .param p4, "maxWidth"    # I
    .param p5, "disallowPartialChildPosition"    # I

    .prologue
    const/4 v9, -0x1

    .line 400
    iget-object v0, p0, Lco/vine/android/views/HorizontalListView;->mAdapter:Landroid/widget/ListAdapter;

    .line 401
    .local v0, "adapter":Landroid/widget/ListAdapter;
    if-nez v0, :cond_1

    .line 402
    invoke-virtual {p0}, Lco/vine/android/views/HorizontalListView;->getPaddingLeft()I

    move-result v7

    invoke-virtual {p0}, Lco/vine/android/views/HorizontalListView;->getPaddingRight()I

    move-result v8

    add-int v4, v7, v8

    .line 445
    :cond_0
    :goto_0
    return v4

    .line 406
    :cond_1
    invoke-virtual {p0}, Lco/vine/android/views/HorizontalListView;->getPaddingLeft()I

    move-result v7

    invoke-virtual {p0}, Lco/vine/android/views/HorizontalListView;->getPaddingRight()I

    move-result v8

    add-int v6, v7, v8

    .line 409
    .local v6, "returnedWidth":I
    const/4 v4, 0x0

    .line 413
    .local v4, "prevWidthWithoutPartialChild":I
    if-ne p3, v9, :cond_2

    invoke-interface {v0}, Landroid/widget/ListAdapter;->getCount()I

    move-result v7

    add-int/lit8 p3, v7, -0x1

    .line 414
    :cond_2
    iget-object v5, p0, Lco/vine/android/views/HorizontalListView;->mRecycler:Lco/vine/android/views/HorizontalListView$Recycler;

    .line 415
    .local v5, "recycleBin":Lco/vine/android/views/HorizontalListView$Recycler;
    iget-object v3, p0, Lco/vine/android/views/HorizontalListView;->mIsRecycled:[Z

    .line 417
    .local v3, "isRecycled":[Z
    move v2, p2

    .local v2, "i":I
    :goto_1
    if-gt v2, p3, :cond_6

    .line 418
    invoke-direct {p0, v2, v3}, Lco/vine/android/views/HorizontalListView;->obtainView(I[Z)Landroid/view/View;

    move-result-object v1

    .line 420
    .local v1, "child":Landroid/view/View;
    invoke-direct {p0, v1, p1}, Lco/vine/android/views/HorizontalListView;->measureChild(Landroid/view/View;I)V

    .line 423
    invoke-virtual {v5, v1, v9}, Lco/vine/android/views/HorizontalListView$Recycler;->addRecycleView(Landroid/view/View;I)V

    .line 425
    invoke-virtual {v1}, Landroid/view/View;->getMeasuredWidth()I

    move-result v7

    add-int/2addr v6, v7

    .line 427
    if-lt v6, p4, :cond_4

    .line 430
    if-ltz p5, :cond_3

    if-le v2, p5, :cond_3

    if-lez v4, :cond_3

    if-ne v6, p4, :cond_0

    :cond_3
    move v4, p4

    goto :goto_0

    .line 438
    :cond_4
    if-ltz p5, :cond_5

    if-lt v2, p5, :cond_5

    .line 439
    move v4, v6

    .line 417
    :cond_5
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .end local v1    # "child":Landroid/view/View;
    :cond_6
    move v4, v6

    .line 445
    goto :goto_0
.end method

.method protected onDetachedFromWindow()V
    .locals 1

    .prologue
    .line 247
    invoke-super {p0}, Landroid/widget/AdapterView;->onDetachedFromWindow()V

    .line 248
    iget-object v0, p0, Lco/vine/android/views/HorizontalListView;->mRecycler:Lco/vine/android/views/HorizontalListView$Recycler;

    invoke-virtual {v0}, Lco/vine/android/views/HorizontalListView$Recycler;->clear()V

    .line 249
    iget-object v0, p0, Lco/vine/android/views/HorizontalListView;->mPendingCheckForTap:Lco/vine/android/views/HorizontalListView$CheckForTap;

    if-eqz v0, :cond_0

    .line 250
    iget-object v0, p0, Lco/vine/android/views/HorizontalListView;->mPendingCheckForTap:Lco/vine/android/views/HorizontalListView$CheckForTap;

    invoke-virtual {p0, v0}, Lco/vine/android/views/HorizontalListView;->removeCallbacks(Ljava/lang/Runnable;)Z

    .line 252
    :cond_0
    return-void
.end method

.method protected onLayout(ZIIII)V
    .locals 0
    .param p1, "changed"    # Z
    .param p2, "left"    # I
    .param p3, "top"    # I
    .param p4, "right"    # I
    .param p5, "bottom"    # I

    .prologue
    .line 460
    invoke-super/range {p0 .. p5}, Landroid/widget/AdapterView;->onLayout(ZIIII)V

    .line 461
    invoke-virtual {p0, p1}, Lco/vine/android/views/HorizontalListView;->onLayoutCustom(Z)V

    .line 462
    return-void
.end method

.method protected onLayoutCustom(Z)V
    .locals 3
    .param p1, "changed"    # Z

    .prologue
    .line 449
    if-eqz p1, :cond_0

    .line 450
    invoke-virtual {p0}, Lco/vine/android/views/HorizontalListView;->getChildCount()I

    move-result v0

    .line 451
    .local v0, "childCount":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v0, :cond_0

    .line 452
    invoke-virtual {p0, v1}, Lco/vine/android/views/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/View;->forceLayout()V

    .line 451
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 455
    .end local v0    # "childCount":I
    .end local v1    # "i":I
    :cond_0
    invoke-virtual {p0}, Lco/vine/android/views/HorizontalListView;->layoutChildren()V

    .line 456
    return-void
.end method

.method protected onMeasure(II)V
    .locals 15
    .param p1, "widthMeasureSpec"    # I
    .param p2, "heightMeasureSpec"    # I

    .prologue
    .line 298
    invoke-static/range {p1 .. p1}, Landroid/view/View$MeasureSpec;->getMode(I)I

    move-result v14

    .line 299
    .local v14, "widthMode":I
    invoke-static/range {p2 .. p2}, Landroid/view/View$MeasureSpec;->getMode(I)I

    move-result v12

    .line 300
    .local v12, "heightMode":I
    invoke-static/range {p1 .. p1}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v5

    .line 301
    .local v5, "widthSize":I
    invoke-static/range {p2 .. p2}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v13

    .line 306
    .local v13, "heightSize":I
    iget-object v1, p0, Lco/vine/android/views/HorizontalListView;->mAdapter:Landroid/widget/ListAdapter;

    if-nez v1, :cond_5

    const/4 v1, 0x0

    :goto_0
    iput v1, p0, Lco/vine/android/views/HorizontalListView;->mItemCount:I

    .line 307
    iget v1, p0, Lco/vine/android/views/HorizontalListView;->mItemCount:I

    if-lez v1, :cond_6

    if-eqz v14, :cond_0

    if-nez v12, :cond_6

    .line 309
    :cond_0
    const/4 v1, 0x0

    iget-object v2, p0, Lco/vine/android/views/HorizontalListView;->mIsRecycled:[Z

    invoke-direct {p0, v1, v2}, Lco/vine/android/views/HorizontalListView;->obtainView(I[Z)Landroid/view/View;

    move-result-object v7

    .line 311
    .local v7, "child":Landroid/view/View;
    move/from16 v0, p2

    invoke-direct {p0, v7, v0}, Lco/vine/android/views/HorizontalListView;->measureChild(Landroid/view/View;I)V

    .line 313
    invoke-virtual {v7}, Landroid/view/View;->getMeasuredWidth()I

    move-result v10

    .line 314
    .local v10, "childWidth":I
    invoke-virtual {v7}, Landroid/view/View;->getMeasuredHeight()I

    move-result v9

    .line 317
    .local v9, "childHeight":I
    iget-object v1, p0, Lco/vine/android/views/HorizontalListView;->mRecycler:Lco/vine/android/views/HorizontalListView$Recycler;

    const/4 v2, -0x1

    invoke-virtual {v1, v7, v2}, Lco/vine/android/views/HorizontalListView$Recycler;->addRecycleView(Landroid/view/View;I)V

    .line 323
    .end local v7    # "child":Landroid/view/View;
    :goto_1
    if-nez v14, :cond_7

    .line 324
    invoke-virtual {p0}, Lco/vine/android/views/HorizontalListView;->getPaddingLeft()I

    move-result v1

    invoke-virtual {p0}, Lco/vine/android/views/HorizontalListView;->getPaddingRight()I

    move-result v2

    add-int/2addr v1, v2

    add-int v5, v1, v10

    .line 330
    :cond_1
    :goto_2
    if-nez v12, :cond_2

    .line 331
    invoke-virtual {p0}, Lco/vine/android/views/HorizontalListView;->getPaddingTop()I

    move-result v1

    invoke-virtual {p0}, Lco/vine/android/views/HorizontalListView;->getPaddingBottom()I

    move-result v2

    add-int/2addr v1, v2

    add-int v13, v1, v9

    .line 334
    :cond_2
    const/4 v1, 0x0

    iput v1, p0, Lco/vine/android/views/HorizontalListView;->mChildFillWidth:I

    .line 335
    iget v1, p0, Lco/vine/android/views/HorizontalListView;->mFillWidthHeightRatio:F

    const/4 v2, 0x0

    cmpl-float v1, v1, v2

    if-lez v1, :cond_3

    iget v1, p0, Lco/vine/android/views/HorizontalListView;->mItemCount:I

    if-lez v1, :cond_3

    .line 336
    iget v1, p0, Lco/vine/android/views/HorizontalListView;->mDividerWidth:I

    iget v2, p0, Lco/vine/android/views/HorizontalListView;->mItemCount:I

    add-int/lit8 v2, v2, -0x1

    mul-int v11, v1, v2

    .line 337
    .local v11, "dividersWidth":I
    iget v1, p0, Lco/vine/android/views/HorizontalListView;->mEdgePadding:I

    mul-int/lit8 v1, v1, 0x2

    sub-int v1, v5, v1

    sub-int/2addr v1, v11

    iget v2, p0, Lco/vine/android/views/HorizontalListView;->mItemCount:I

    div-int v8, v1, v2

    .line 340
    .local v8, "childFillWidth":I
    if-lt v8, v13, :cond_3

    int-to-float v1, v8

    iget v2, p0, Lco/vine/android/views/HorizontalListView;->mFillWidthHeightRatio:F

    int-to-float v3, v13

    mul-float/2addr v2, v3

    cmpg-float v1, v1, v2

    if-gtz v1, :cond_3

    .line 342
    iput v8, p0, Lco/vine/android/views/HorizontalListView;->mChildFillWidth:I

    .line 345
    .end local v8    # "childFillWidth":I
    .end local v11    # "dividersWidth":I
    :cond_3
    iget-object v1, p0, Lco/vine/android/views/HorizontalListView;->mChildWidthListener:Lco/vine/android/views/HorizontalListView$ChildWidthListener;

    if-eqz v1, :cond_4

    .line 346
    iget-object v1, p0, Lco/vine/android/views/HorizontalListView;->mChildWidthListener:Lco/vine/android/views/HorizontalListView$ChildWidthListener;

    iget v2, p0, Lco/vine/android/views/HorizontalListView;->mChildFillWidth:I

    invoke-interface {v1, v2}, Lco/vine/android/views/HorizontalListView$ChildWidthListener;->onChildWidthMeasured(I)V

    .line 349
    :cond_4
    invoke-virtual {p0, v5, v13}, Lco/vine/android/views/HorizontalListView;->setMeasuredDimension(II)V

    .line 350
    move/from16 v0, p2

    iput v0, p0, Lco/vine/android/views/HorizontalListView;->mHeightMeasureSpec:I

    .line 351
    return-void

    .line 306
    .end local v9    # "childHeight":I
    .end local v10    # "childWidth":I
    :cond_5
    iget-object v1, p0, Lco/vine/android/views/HorizontalListView;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v1}, Landroid/widget/ListAdapter;->getCount()I

    move-result v1

    goto/16 :goto_0

    .line 319
    :cond_6
    invoke-virtual {p0}, Lco/vine/android/views/HorizontalListView;->getSuggestedMinimumWidth()I

    move-result v10

    .line 320
    .restart local v10    # "childWidth":I
    invoke-virtual {p0}, Lco/vine/android/views/HorizontalListView;->getSuggestedMinimumHeight()I

    move-result v9

    .restart local v9    # "childHeight":I
    goto :goto_1

    .line 325
    :cond_7
    const/high16 v1, -0x80000000

    if-ne v14, v1, :cond_1

    .line 327
    const/4 v3, 0x0

    const/4 v4, -0x1

    const/4 v6, -0x1

    move-object v1, p0

    move/from16 v2, p2

    invoke-virtual/range {v1 .. v6}, Lco/vine/android/views/HorizontalListView;->measureWidthOfChildren(IIIII)I

    move-result v5

    goto :goto_2
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 22
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 471
    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/views/HorizontalListView;->mItemCount:I

    move/from16 v19, v0

    if-nez v19, :cond_1

    .line 472
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v19

    const/16 v20, 0x0

    cmpg-float v19, v19, v20

    if-ltz v19, :cond_0

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v19

    invoke-virtual/range {p0 .. p0}, Lco/vine/android/views/HorizontalListView;->getWidth()I

    move-result v20

    move/from16 v0, v20

    int-to-float v0, v0

    move/from16 v20, v0

    cmpl-float v19, v19, v20

    if-gtz v19, :cond_0

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v19

    const/16 v20, 0x0

    cmpg-float v19, v19, v20

    if-ltz v19, :cond_0

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v19

    invoke-virtual/range {p0 .. p0}, Lco/vine/android/views/HorizontalListView;->getHeight()I

    move-result v20

    move/from16 v0, v20

    int-to-float v0, v0

    move/from16 v20, v0

    cmpl-float v19, v19, v20

    if-gtz v19, :cond_0

    const/16 v19, 0x1

    .line 673
    :goto_0
    return v19

    .line 472
    :cond_0
    const/16 v19, 0x0

    goto :goto_0

    .line 476
    :cond_1
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/views/HorizontalListView;->mVelocityTracker:Landroid/view/VelocityTracker;

    move-object/from16 v19, v0

    if-nez v19, :cond_2

    .line 477
    invoke-static {}, Landroid/view/VelocityTracker;->obtain()Landroid/view/VelocityTracker;

    move-result-object v19

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/views/HorizontalListView;->mVelocityTracker:Landroid/view/VelocityTracker;

    .line 479
    :cond_2
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/views/HorizontalListView;->mVelocityTracker:Landroid/view/VelocityTracker;

    move-object/from16 v19, v0

    move-object/from16 v0, v19

    move-object/from16 v1, p1

    invoke-virtual {v0, v1}, Landroid/view/VelocityTracker;->addMovement(Landroid/view/MotionEvent;)V

    .line 481
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v19

    move/from16 v0, v19

    and-int/lit16 v4, v0, 0xff

    .line 482
    .local v4, "action":I
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v19

    move/from16 v0, v19

    float-to-int v0, v0

    move/from16 v17, v0

    .line 483
    .local v17, "x":I
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v19

    move/from16 v0, v19

    float-to-int v0, v0

    move/from16 v18, v0

    .line 485
    .local v18, "y":I
    packed-switch v4, :pswitch_data_0

    .line 673
    :cond_3
    :goto_1
    const/16 v19, 0x1

    goto :goto_0

    .line 487
    :pswitch_0
    move-object/from16 v0, p0

    move/from16 v1, v17

    move/from16 v2, v18

    invoke-virtual {v0, v1, v2}, Lco/vine/android/views/HorizontalListView;->pointToPosition(II)I

    move-result v11

    .line 488
    .local v11, "motionPosition":I
    move-object/from16 v0, p0

    iput v11, v0, Lco/vine/android/views/HorizontalListView;->mDownPosition:I

    .line 489
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lco/vine/android/views/HorizontalListView;->mDataChanged:Z

    move/from16 v19, v0

    if-nez v19, :cond_5

    .line 490
    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/views/HorizontalListView;->mTouchMode:I

    move/from16 v19, v0

    const/16 v20, 0x4

    move/from16 v0, v19

    move/from16 v1, v20

    if-eq v0, v1, :cond_5

    if-ltz v11, :cond_5

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/views/HorizontalListView;->mAdapter:Landroid/widget/ListAdapter;

    move-object/from16 v19, v0

    move-object/from16 v0, v19

    invoke-interface {v0, v11}, Landroid/widget/ListAdapter;->isEnabled(I)Z

    move-result v19

    if-eqz v19, :cond_5

    .line 494
    const/16 v19, 0x0

    move/from16 v0, v19

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/views/HorizontalListView;->mTouchMode:I

    .line 495
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/views/HorizontalListView;->mPendingCheckForTap:Lco/vine/android/views/HorizontalListView$CheckForTap;

    move-object/from16 v19, v0

    if-nez v19, :cond_4

    .line 496
    new-instance v19, Lco/vine/android/views/HorizontalListView$CheckForTap;

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lco/vine/android/views/HorizontalListView$CheckForTap;-><init>(Lco/vine/android/views/HorizontalListView;)V

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/views/HorizontalListView;->mPendingCheckForTap:Lco/vine/android/views/HorizontalListView$CheckForTap;

    .line 498
    :cond_4
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/views/HorizontalListView;->mPendingCheckForTap:Lco/vine/android/views/HorizontalListView$CheckForTap;

    move-object/from16 v19, v0

    invoke-static {}, Landroid/view/ViewConfiguration;->getTapTimeout()I

    move-result v20

    move/from16 v0, v20

    int-to-long v0, v0

    move-wide/from16 v20, v0

    move-object/from16 v0, p0

    move-object/from16 v1, v19

    move-wide/from16 v2, v20

    invoke-virtual {v0, v1, v2, v3}, Lco/vine/android/views/HorizontalListView;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 503
    :cond_5
    const/16 v19, 0x1

    move-object/from16 v0, p0

    move/from16 v1, v19

    invoke-direct {v0, v1}, Lco/vine/android/views/HorizontalListView;->disallowParentIntercept(Z)V

    .line 505
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/views/HorizontalListView;->mFlingRunnable:Lco/vine/android/views/HorizontalListView$FlingRunnable;

    move-object/from16 v19, v0

    invoke-virtual/range {v19 .. v19}, Lco/vine/android/views/HorizontalListView$FlingRunnable;->stop()V

    .line 507
    move/from16 v0, v17

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/views/HorizontalListView;->mMotionX:I

    .line 508
    move/from16 v0, v18

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/views/HorizontalListView;->mMotionY:I

    .line 509
    const/high16 v19, -0x80000000

    move/from16 v0, v19

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/views/HorizontalListView;->mLastX:I

    .line 510
    move-object/from16 v0, p0

    iput v11, v0, Lco/vine/android/views/HorizontalListView;->mMotionPosition:I

    goto/16 :goto_1

    .line 514
    .end local v11    # "motionPosition":I
    :pswitch_1
    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/views/HorizontalListView;->mTouchMode:I

    move/from16 v19, v0

    packed-switch v19, :pswitch_data_1

    .line 585
    move-object/from16 v0, p0

    iget-object v15, v0, Lco/vine/android/views/HorizontalListView;->mVelocityTracker:Landroid/view/VelocityTracker;

    .line 586
    .local v15, "velocityTracker":Landroid/view/VelocityTracker;
    const/16 v19, 0x3e8

    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/views/HorizontalListView;->mMaximumFlingVelocity:I

    move/from16 v20, v0

    move/from16 v0, v20

    int-to-float v0, v0

    move/from16 v20, v0

    move/from16 v0, v19

    move/from16 v1, v20

    invoke-virtual {v15, v0, v1}, Landroid/view/VelocityTracker;->computeCurrentVelocity(IF)V

    .line 587
    invoke-virtual {v15}, Landroid/view/VelocityTracker;->getXVelocity()F

    move-result v16

    .line 589
    .local v16, "velocityX":F
    invoke-static/range {v16 .. v16}, Ljava/lang/Math;->abs(F)F

    move-result v19

    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/views/HorizontalListView;->mMinimumFlingVelocity:I

    move/from16 v20, v0

    move/from16 v0, v20

    int-to-float v0, v0

    move/from16 v20, v0

    cmpl-float v19, v19, v20

    if-lez v19, :cond_6

    move-object/from16 v0, p0

    iget-boolean v0, v0, Lco/vine/android/views/HorizontalListView;->mFingerScrollEnabled:Z

    move/from16 v19, v0

    if-eqz v19, :cond_6

    .line 590
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/views/HorizontalListView;->mFlingRunnable:Lco/vine/android/views/HorizontalListView$FlingRunnable;

    move-object/from16 v19, v0

    move/from16 v0, v16

    neg-float v0, v0

    move/from16 v20, v0

    move/from16 v0, v20

    float-to-int v0, v0

    move/from16 v20, v0

    invoke-virtual/range {v19 .. v20}, Lco/vine/android/views/HorizontalListView$FlingRunnable;->start(I)V

    .line 595
    .end local v15    # "velocityTracker":Landroid/view/VelocityTracker;
    .end local v16    # "velocityX":F
    :cond_6
    :goto_2
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/views/HorizontalListView;->getHandler()Landroid/os/Handler;

    move-result-object v8

    .line 596
    .local v8, "handler":Landroid/os/Handler;
    if-eqz v8, :cond_7

    .line 597
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/views/HorizontalListView;->mPendingCheckForLongPress:Lco/vine/android/views/HorizontalListView$CheckForLongPress;

    move-object/from16 v19, v0

    move-object/from16 v0, v19

    invoke-virtual {v8, v0}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 599
    :cond_7
    invoke-direct/range {p0 .. p0}, Lco/vine/android/views/HorizontalListView;->recycleVelocityTracker()V

    .line 600
    const/high16 v19, -0x80000000

    move/from16 v0, v19

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/views/HorizontalListView;->mMotionY:I

    .line 601
    const/high16 v19, -0x80000000

    move/from16 v0, v19

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/views/HorizontalListView;->mMotionX:I

    .line 602
    const/high16 v19, -0x80000000

    move/from16 v0, v19

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/views/HorizontalListView;->mLastX:I

    goto/16 :goto_1

    .line 518
    .end local v8    # "handler":Landroid/os/Handler;
    :pswitch_2
    move-object/from16 v0, p0

    iget v11, v0, Lco/vine/android/views/HorizontalListView;->mMotionPosition:I

    .line 519
    .restart local v11    # "motionPosition":I
    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/views/HorizontalListView;->mFirstVisiblePos:I

    move/from16 v19, v0

    sub-int v19, v11, v19

    move-object/from16 v0, p0

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Lco/vine/android/views/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v5

    .line 521
    .local v5, "child":Landroid/view/View;
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/views/HorizontalListView;->getPaddingLeft()I

    move-result v19

    move/from16 v0, v17

    move/from16 v1, v19

    if-le v0, v1, :cond_e

    invoke-virtual/range {p0 .. p0}, Lco/vine/android/views/HorizontalListView;->getWidth()I

    move-result v19

    invoke-virtual/range {p0 .. p0}, Lco/vine/android/views/HorizontalListView;->getPaddingRight()I

    move-result v20

    sub-int v19, v19, v20

    move/from16 v0, v17

    move/from16 v1, v19

    if-ge v0, v1, :cond_e

    const/4 v9, 0x1

    .line 524
    .local v9, "inList":Z
    :goto_3
    if-eqz v5, :cond_11

    invoke-virtual {v5}, Landroid/view/View;->hasFocusable()Z

    move-result v19

    if-nez v19, :cond_11

    if-eqz v9, :cond_11

    .line 525
    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/views/HorizontalListView;->mTouchMode:I

    move/from16 v19, v0

    if-eqz v19, :cond_8

    .line 526
    const/16 v19, 0x0

    move/from16 v0, v19

    invoke-virtual {v5, v0}, Landroid/view/View;->setPressed(Z)V

    .line 529
    :cond_8
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/views/HorizontalListView;->mPerformClick:Lco/vine/android/views/HorizontalListView$PerformClick;

    move-object/from16 v19, v0

    if-nez v19, :cond_9

    .line 530
    new-instance v19, Lco/vine/android/views/HorizontalListView$PerformClick;

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lco/vine/android/views/HorizontalListView$PerformClick;-><init>(Lco/vine/android/views/HorizontalListView;)V

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/views/HorizontalListView;->mPerformClick:Lco/vine/android/views/HorizontalListView$PerformClick;

    .line 533
    :cond_9
    move-object/from16 v0, p0

    iget-object v12, v0, Lco/vine/android/views/HorizontalListView;->mPerformClick:Lco/vine/android/views/HorizontalListView$PerformClick;

    .line 534
    .local v12, "performClick":Lco/vine/android/views/HorizontalListView$PerformClick;
    iput v11, v12, Lco/vine/android/views/HorizontalListView$PerformClick;->clickMotionPosition:I

    .line 535
    invoke-virtual {v12}, Lco/vine/android/views/HorizontalListView$PerformClick;->rememberWindowAttachCount()V

    .line 537
    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/views/HorizontalListView;->mTouchMode:I

    move/from16 v19, v0

    if-eqz v19, :cond_a

    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/views/HorizontalListView;->mTouchMode:I

    move/from16 v19, v0

    const/16 v20, 0x1

    move/from16 v0, v19

    move/from16 v1, v20

    if-ne v0, v1, :cond_10

    .line 538
    :cond_a
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/views/HorizontalListView;->getHandler()Landroid/os/Handler;

    move-result-object v8

    .line 539
    .restart local v8    # "handler":Landroid/os/Handler;
    if-eqz v8, :cond_b

    .line 540
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/views/HorizontalListView;->mPendingCheckForTap:Lco/vine/android/views/HorizontalListView$CheckForTap;

    move-object/from16 v19, v0

    move-object/from16 v0, v19

    invoke-virtual {v8, v0}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 542
    :cond_b
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lco/vine/android/views/HorizontalListView;->mDataChanged:Z

    move/from16 v19, v0

    if-nez v19, :cond_f

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/views/HorizontalListView;->mAdapter:Landroid/widget/ListAdapter;

    move-object/from16 v19, v0

    move-object/from16 v0, v19

    invoke-interface {v0, v11}, Landroid/widget/ListAdapter;->isEnabled(I)Z

    move-result v19

    if-eqz v19, :cond_f

    .line 543
    const/16 v19, 0x1

    move/from16 v0, v19

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/views/HorizontalListView;->mTouchMode:I

    .line 545
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/views/HorizontalListView;->layoutChildren()V

    .line 546
    const/16 v19, 0x1

    move/from16 v0, v19

    invoke-virtual {v5, v0}, Landroid/view/View;->setPressed(Z)V

    .line 548
    const/16 v19, 0x1

    move-object/from16 v0, p0

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Lco/vine/android/views/HorizontalListView;->setPressed(Z)V

    .line 549
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/views/HorizontalListView;->mSelector:Landroid/graphics/drawable/Drawable;

    move-object/from16 v19, v0

    if-eqz v19, :cond_c

    .line 550
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/views/HorizontalListView;->mSelector:Landroid/graphics/drawable/Drawable;

    move-object/from16 v19, v0

    invoke-virtual/range {v19 .. v19}, Landroid/graphics/drawable/Drawable;->getCurrent()Landroid/graphics/drawable/Drawable;

    move-result-object v6

    .line 551
    .local v6, "d":Landroid/graphics/drawable/Drawable;
    if-eqz v6, :cond_c

    instance-of v0, v6, Landroid/graphics/drawable/TransitionDrawable;

    move/from16 v19, v0

    if-eqz v19, :cond_c

    .line 552
    check-cast v6, Landroid/graphics/drawable/TransitionDrawable;

    .end local v6    # "d":Landroid/graphics/drawable/Drawable;
    invoke-virtual {v6}, Landroid/graphics/drawable/TransitionDrawable;->resetTransition()V

    .line 555
    :cond_c
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/views/HorizontalListView;->mTouchModeReset:Ljava/lang/Runnable;

    move-object/from16 v19, v0

    if-eqz v19, :cond_d

    .line 556
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/views/HorizontalListView;->mTouchModeReset:Ljava/lang/Runnable;

    move-object/from16 v19, v0

    move-object/from16 v0, p0

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lco/vine/android/views/HorizontalListView;->removeCallbacks(Ljava/lang/Runnable;)Z

    .line 558
    :cond_d
    new-instance v19, Lco/vine/android/views/HorizontalListView$1;

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    invoke-direct {v0, v1, v5, v12}, Lco/vine/android/views/HorizontalListView$1;-><init>(Lco/vine/android/views/HorizontalListView;Landroid/view/View;Lco/vine/android/views/HorizontalListView$PerformClick;)V

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/views/HorizontalListView;->mTouchModeReset:Ljava/lang/Runnable;

    .line 568
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/views/HorizontalListView;->mTouchModeReset:Ljava/lang/Runnable;

    move-object/from16 v19, v0

    invoke-static {}, Landroid/view/ViewConfiguration;->getPressedStateDuration()I

    move-result v20

    move/from16 v0, v20

    int-to-long v0, v0

    move-wide/from16 v20, v0

    move-object/from16 v0, p0

    move-object/from16 v1, v19

    move-wide/from16 v2, v20

    invoke-virtual {v0, v1, v2, v3}, Lco/vine/android/views/HorizontalListView;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 573
    :goto_4
    const/16 v19, 0x1

    goto/16 :goto_0

    .line 521
    .end local v8    # "handler":Landroid/os/Handler;
    .end local v9    # "inList":Z
    .end local v12    # "performClick":Lco/vine/android/views/HorizontalListView$PerformClick;
    :cond_e
    const/4 v9, 0x0

    goto/16 :goto_3

    .line 571
    .restart local v8    # "handler":Landroid/os/Handler;
    .restart local v9    # "inList":Z
    .restart local v12    # "performClick":Lco/vine/android/views/HorizontalListView$PerformClick;
    :cond_f
    const/16 v19, -0x1

    move/from16 v0, v19

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/views/HorizontalListView;->mTouchMode:I

    goto :goto_4

    .line 574
    .end local v8    # "handler":Landroid/os/Handler;
    :cond_10
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lco/vine/android/views/HorizontalListView;->mDataChanged:Z

    move/from16 v19, v0

    if-nez v19, :cond_11

    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/views/HorizontalListView;->mDownPosition:I

    move/from16 v19, v0

    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/views/HorizontalListView;->mMotionPosition:I

    move/from16 v20, v0

    move/from16 v0, v19

    move/from16 v1, v20

    if-ne v0, v1, :cond_11

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/views/HorizontalListView;->mAdapter:Landroid/widget/ListAdapter;

    move-object/from16 v19, v0

    move-object/from16 v0, v19

    invoke-interface {v0, v11}, Landroid/widget/ListAdapter;->isEnabled(I)Z

    move-result v19

    if-eqz v19, :cond_11

    .line 576
    invoke-virtual {v12}, Lco/vine/android/views/HorizontalListView$PerformClick;->run()V

    .line 580
    .end local v12    # "performClick":Lco/vine/android/views/HorizontalListView$PerformClick;
    :cond_11
    const/16 v19, -0x1

    move/from16 v0, v19

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/views/HorizontalListView;->mTouchMode:I

    goto/16 :goto_2

    .line 606
    .end local v5    # "child":Landroid/view/View;
    .end local v9    # "inList":Z
    .end local v11    # "motionPosition":I
    :pswitch_3
    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/views/HorizontalListView;->mMotionX:I

    move/from16 v19, v0

    const/high16 v20, -0x80000000

    move/from16 v0, v19

    move/from16 v1, v20

    if-eq v0, v1, :cond_1a

    .line 607
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/views/HorizontalListView;->getChildCount()I

    move-result v19

    if-nez v19, :cond_12

    .line 608
    const/16 v19, -0x1

    move/from16 v0, v19

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/views/HorizontalListView;->mTouchMode:I

    .line 609
    invoke-super/range {p0 .. p1}, Landroid/widget/AdapterView;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v19

    goto/16 :goto_0

    .line 611
    :cond_12
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/views/HorizontalListView;->getHandler()Landroid/os/Handler;

    move-result-object v8

    .line 612
    .restart local v8    # "handler":Landroid/os/Handler;
    if-eqz v8, :cond_13

    .line 613
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/views/HorizontalListView;->mPendingCheckForLongPress:Lco/vine/android/views/HorizontalListView$CheckForLongPress;

    move-object/from16 v19, v0

    move-object/from16 v0, v19

    invoke-virtual {v8, v0}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 617
    :cond_13
    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/views/HorizontalListView;->mMotionX:I

    move/from16 v19, v0

    sub-int v13, v17, v19

    .line 618
    .local v13, "rawDeltaX":I
    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/views/HorizontalListView;->mTouchMode:I

    move/from16 v19, v0

    const/16 v20, 0x3

    move/from16 v0, v19

    move/from16 v1, v20

    if-eq v0, v1, :cond_18

    .line 619
    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/views/HorizontalListView;->mFirstVisiblePos:I

    move/from16 v19, v0

    if-nez v19, :cond_14

    invoke-direct/range {p0 .. p0}, Lco/vine/android/views/HorizontalListView;->getOverflowLeft()I

    move-result v19

    if-nez v19, :cond_14

    if-gtz v13, :cond_15

    :cond_14
    invoke-direct/range {p0 .. p0}, Lco/vine/android/views/HorizontalListView;->getOverflowRight()I

    move-result v19

    if-nez v19, :cond_16

    if-gez v13, :cond_16

    .line 621
    :cond_15
    const/16 v19, 0x0

    move-object/from16 v0, p0

    move/from16 v1, v19

    invoke-direct {v0, v1}, Lco/vine/android/views/HorizontalListView;->disallowParentIntercept(Z)V

    goto/16 :goto_1

    .line 624
    :cond_16
    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/views/HorizontalListView;->mMotionY:I

    move/from16 v19, v0

    const/high16 v20, -0x80000000

    move/from16 v0, v19

    move/from16 v1, v20

    if-eq v0, v1, :cond_17

    .line 625
    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/views/HorizontalListView;->mMotionY:I

    move/from16 v19, v0

    sub-int v14, v18, v19

    .line 626
    .local v14, "rawDeltaY":I
    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/views/HorizontalListView;->mTouchSlop:I

    move/from16 v19, v0

    invoke-static {v14}, Ljava/lang/Math;->abs(I)I

    move-result v20

    move/from16 v0, v19

    move/from16 v1, v20

    if-gt v0, v1, :cond_17

    .line 627
    const/16 v19, 0x0

    move-object/from16 v0, p0

    move/from16 v1, v19

    invoke-direct {v0, v1}, Lco/vine/android/views/HorizontalListView;->disallowParentIntercept(Z)V

    goto/16 :goto_1

    .line 631
    .end local v14    # "rawDeltaY":I
    :cond_17
    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/views/HorizontalListView;->mTouchSlop:I

    move/from16 v19, v0

    invoke-static {v13}, Ljava/lang/Math;->abs(I)I

    move-result v20

    move/from16 v0, v19

    move/from16 v1, v20

    if-gt v0, v1, :cond_3

    .line 634
    const/16 v19, 0x3

    move/from16 v0, v19

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/views/HorizontalListView;->mTouchMode:I

    .line 636
    :cond_18
    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/views/HorizontalListView;->mLastX:I

    move/from16 v19, v0

    move/from16 v0, v17

    move/from16 v1, v19

    if-eq v0, v1, :cond_3

    .line 641
    if-lez v13, :cond_1b

    .line 642
    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/views/HorizontalListView;->mTouchSlop:I

    move/from16 v19, v0

    sub-int v7, v13, v19

    .line 647
    .local v7, "deltaX":I
    :goto_5
    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/views/HorizontalListView;->mLastX:I

    move/from16 v19, v0

    const/high16 v20, -0x80000000

    move/from16 v0, v19

    move/from16 v1, v20

    if-eq v0, v1, :cond_1c

    .line 648
    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/views/HorizontalListView;->mLastX:I

    move/from16 v19, v0

    sub-int v10, v17, v19

    .line 652
    .local v10, "incrementalDeltaX":I
    :goto_6
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lco/vine/android/views/HorizontalListView;->mFingerScrollEnabled:Z

    move/from16 v19, v0

    if-eqz v19, :cond_19

    .line 653
    move-object/from16 v0, p0

    invoke-virtual {v0, v13, v10}, Lco/vine/android/views/HorizontalListView;->scroll(II)Z

    .line 655
    :cond_19
    move/from16 v0, v17

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/views/HorizontalListView;->mLastX:I

    .line 657
    .end local v7    # "deltaX":I
    .end local v8    # "handler":Landroid/os/Handler;
    .end local v10    # "incrementalDeltaX":I
    .end local v13    # "rawDeltaX":I
    :cond_1a
    move/from16 v0, v17

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/views/HorizontalListView;->mMotionX:I

    .line 658
    move/from16 v0, v18

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/views/HorizontalListView;->mMotionY:I

    goto/16 :goto_1

    .line 644
    .restart local v8    # "handler":Landroid/os/Handler;
    .restart local v13    # "rawDeltaX":I
    :cond_1b
    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/views/HorizontalListView;->mTouchSlop:I

    move/from16 v19, v0

    add-int v7, v13, v19

    .restart local v7    # "deltaX":I
    goto :goto_5

    .line 650
    :cond_1c
    move v10, v7

    .restart local v10    # "incrementalDeltaX":I
    goto :goto_6

    .line 662
    .end local v7    # "deltaX":I
    .end local v8    # "handler":Landroid/os/Handler;
    .end local v10    # "incrementalDeltaX":I
    .end local v13    # "rawDeltaX":I
    :pswitch_4
    invoke-direct/range {p0 .. p0}, Lco/vine/android/views/HorizontalListView;->recycleVelocityTracker()V

    .line 663
    const/high16 v19, -0x80000000

    move/from16 v0, v19

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/views/HorizontalListView;->mMotionX:I

    .line 664
    const/high16 v19, -0x80000000

    move/from16 v0, v19

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/views/HorizontalListView;->mMotionY:I

    .line 665
    const/high16 v19, -0x80000000

    move/from16 v0, v19

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/views/HorizontalListView;->mLastX:I

    .line 666
    const/16 v19, -0x1

    move/from16 v0, v19

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/views/HorizontalListView;->mTouchMode:I

    goto/16 :goto_1

    .line 485
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_3
        :pswitch_4
    .end packed-switch

    .line 514
    :pswitch_data_1
    .packed-switch 0x0
        :pswitch_2
        :pswitch_2
        :pswitch_2
    .end packed-switch
.end method

.method public pointToPosition(II)I
    .locals 5
    .param p1, "x"    # I
    .param p2, "y"    # I

    .prologue
    .line 986
    iget-object v2, p0, Lco/vine/android/views/HorizontalListView;->mTouchFrame:Landroid/graphics/Rect;

    .line 987
    .local v2, "frame":Landroid/graphics/Rect;
    if-nez v2, :cond_0

    .line 988
    new-instance v4, Landroid/graphics/Rect;

    invoke-direct {v4}, Landroid/graphics/Rect;-><init>()V

    iput-object v4, p0, Lco/vine/android/views/HorizontalListView;->mTouchFrame:Landroid/graphics/Rect;

    .line 989
    iget-object v2, p0, Lco/vine/android/views/HorizontalListView;->mTouchFrame:Landroid/graphics/Rect;

    .line 992
    :cond_0
    invoke-virtual {p0}, Lco/vine/android/views/HorizontalListView;->getChildCount()I

    move-result v1

    .line 993
    .local v1, "count":I
    add-int/lit8 v3, v1, -0x1

    .local v3, "i":I
    :goto_0
    if-ltz v3, :cond_2

    .line 994
    invoke-virtual {p0, v3}, Lco/vine/android/views/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 995
    .local v0, "child":Landroid/view/View;
    invoke-virtual {v0, v2}, Landroid/view/View;->getHitRect(Landroid/graphics/Rect;)V

    .line 996
    invoke-virtual {v2, p1, p2}, Landroid/graphics/Rect;->contains(II)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 997
    iget v4, p0, Lco/vine/android/views/HorizontalListView;->mFirstVisiblePos:I

    add-int/2addr v4, v3

    .line 1000
    .end local v0    # "child":Landroid/view/View;
    :goto_1
    return v4

    .line 993
    .restart local v0    # "child":Landroid/view/View;
    :cond_1
    add-int/lit8 v3, v3, -0x1

    goto :goto_0

    .line 1000
    .end local v0    # "child":Landroid/view/View;
    :cond_2
    const/4 v4, -0x1

    goto :goto_1
.end method

.method public scroll(II)Z
    .locals 16
    .param p1, "rawDeltaX"    # I
    .param p2, "incrementalDeltaX"    # I

    .prologue
    .line 693
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/views/HorizontalListView;->getChildCount()I

    move-result v2

    .line 696
    .local v2, "childCount":I
    if-gez p2, :cond_3

    const/4 v11, 0x1

    .line 697
    .local v11, "scrollRight":Z
    :goto_0
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/views/HorizontalListView;->getPaddingLeft()I

    move-result v8

    .line 698
    .local v8, "listLeft":I
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/views/HorizontalListView;->getWidth()I

    move-result v14

    invoke-virtual/range {p0 .. p0}, Lco/vine/android/views/HorizontalListView;->getPaddingRight()I

    move-result v15

    sub-int v9, v14, v15

    .line 699
    .local v9, "listRight":I
    add-int/lit8 v14, v2, -0x1

    move-object/from16 v0, p0

    invoke-virtual {v0, v14}, Lco/vine/android/views/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v14

    invoke-virtual {v14}, Landroid/view/View;->getRight()I

    move-result v7

    .line 700
    .local v7, "lastChildRight":I
    const/4 v14, 0x0

    move-object/from16 v0, p0

    invoke-virtual {v0, v14}, Lco/vine/android/views/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v14

    invoke-virtual {v14}, Landroid/view/View;->getLeft()I

    move-result v4

    .line 705
    .local v4, "firstChildLeft":I
    if-eqz v11, :cond_4

    .line 706
    invoke-direct/range {p0 .. p0}, Lco/vine/android/views/HorizontalListView;->getOverflowRight()I

    move-result v10

    .line 711
    .local v10, "overflowSpace":I
    :goto_1
    move-object/from16 v0, p0

    iget v5, v0, Lco/vine/android/views/HorizontalListView;->mFirstVisiblePos:I

    .line 712
    .local v5, "firstVisiblePos":I
    if-eqz v11, :cond_6

    .line 713
    add-int v14, v5, v2

    move-object/from16 v0, p0

    iget v15, v0, Lco/vine/android/views/HorizontalListView;->mItemCount:I

    if-lt v14, v15, :cond_0

    add-int v14, v7, p1

    move-object/from16 v0, p0

    iget v15, v0, Lco/vine/android/views/HorizontalListView;->mEdgePadding:I

    sub-int v15, v9, v15

    if-lt v14, v15, :cond_5

    :cond_0
    const/4 v12, 0x1

    .line 719
    .local v12, "shouldScroll":Z
    :goto_2
    if-eqz v12, :cond_d

    .line 720
    const/4 v13, 0x0

    .line 721
    .local v13, "start":I
    const/4 v3, 0x0

    .line 722
    .local v3, "count":I
    if-eqz v11, :cond_a

    .line 726
    const/4 v6, 0x0

    .local v6, "i":I
    :goto_3
    if-ge v6, v2, :cond_1

    .line 727
    move-object/from16 v0, p0

    invoke-virtual {v0, v6}, Lco/vine/android/views/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    .line 728
    .local v1, "child":Landroid/view/View;
    invoke-virtual {v1}, Landroid/view/View;->getRight()I

    move-result v14

    add-int v14, v14, p1

    if-lt v14, v8, :cond_9

    .line 747
    .end local v1    # "child":Landroid/view/View;
    :cond_1
    if-lez v3, :cond_2

    .line 749
    move-object/from16 v0, p0

    invoke-virtual {v0, v13, v3}, Lco/vine/android/views/HorizontalListView;->detachViewsFromParent(II)V

    .line 753
    if-eqz v11, :cond_2

    .line 754
    move-object/from16 v0, p0

    iget v14, v0, Lco/vine/android/views/HorizontalListView;->mFirstVisiblePos:I

    add-int/2addr v14, v3

    move-object/from16 v0, p0

    iput v14, v0, Lco/vine/android/views/HorizontalListView;->mFirstVisiblePos:I

    .line 757
    :cond_2
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/views/HorizontalListView;->getChildCount()I

    move-result v2

    .line 758
    const/4 v6, 0x0

    :goto_4
    if-ge v6, v2, :cond_b

    .line 759
    move-object/from16 v0, p0

    invoke-virtual {v0, v6}, Lco/vine/android/views/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v14

    move/from16 v0, p1

    invoke-virtual {v14, v0}, Landroid/view/View;->offsetLeftAndRight(I)V

    .line 758
    add-int/lit8 v6, v6, 0x1

    goto :goto_4

    .line 696
    .end local v3    # "count":I
    .end local v4    # "firstChildLeft":I
    .end local v5    # "firstVisiblePos":I
    .end local v6    # "i":I
    .end local v7    # "lastChildRight":I
    .end local v8    # "listLeft":I
    .end local v9    # "listRight":I
    .end local v10    # "overflowSpace":I
    .end local v11    # "scrollRight":Z
    .end local v12    # "shouldScroll":Z
    .end local v13    # "start":I
    :cond_3
    const/4 v11, 0x0

    goto/16 :goto_0

    .line 708
    .restart local v4    # "firstChildLeft":I
    .restart local v7    # "lastChildRight":I
    .restart local v8    # "listLeft":I
    .restart local v9    # "listRight":I
    .restart local v11    # "scrollRight":Z
    :cond_4
    invoke-direct/range {p0 .. p0}, Lco/vine/android/views/HorizontalListView;->getOverflowLeft()I

    move-result v10

    .restart local v10    # "overflowSpace":I
    goto :goto_1

    .line 713
    .restart local v5    # "firstVisiblePos":I
    :cond_5
    const/4 v12, 0x0

    goto :goto_2

    .line 716
    :cond_6
    if-gtz v5, :cond_7

    add-int v14, v4, p1

    move-object/from16 v0, p0

    iget v15, v0, Lco/vine/android/views/HorizontalListView;->mEdgePadding:I

    add-int/2addr v15, v8

    if-gt v14, v15, :cond_8

    :cond_7
    const/4 v12, 0x1

    .restart local v12    # "shouldScroll":Z
    :goto_5
    goto :goto_2

    .end local v12    # "shouldScroll":Z
    :cond_8
    const/4 v12, 0x0

    goto :goto_5

    .line 731
    .restart local v1    # "child":Landroid/view/View;
    .restart local v3    # "count":I
    .restart local v6    # "i":I
    .restart local v12    # "shouldScroll":Z
    .restart local v13    # "start":I
    :cond_9
    add-int/lit8 v3, v3, 0x1

    .line 732
    move-object/from16 v0, p0

    iget-object v14, v0, Lco/vine/android/views/HorizontalListView;->mRecycler:Lco/vine/android/views/HorizontalListView$Recycler;

    add-int v15, v5, v6

    invoke-virtual {v14, v1, v15}, Lco/vine/android/views/HorizontalListView$Recycler;->addRecycleView(Landroid/view/View;I)V

    .line 726
    add-int/lit8 v6, v6, 0x1

    goto :goto_3

    .line 737
    .end local v1    # "child":Landroid/view/View;
    .end local v6    # "i":I
    :cond_a
    add-int/lit8 v6, v2, -0x1

    .restart local v6    # "i":I
    :goto_6
    if-ltz v6, :cond_1

    .line 738
    move-object/from16 v0, p0

    invoke-virtual {v0, v6}, Lco/vine/android/views/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    .line 739
    .restart local v1    # "child":Landroid/view/View;
    invoke-virtual {v1}, Landroid/view/View;->getLeft()I

    move-result v14

    add-int v14, v14, p1

    if-le v14, v9, :cond_1

    .line 742
    move v13, v6

    .line 743
    add-int/lit8 v3, v3, 0x1

    .line 744
    move-object/from16 v0, p0

    iget-object v14, v0, Lco/vine/android/views/HorizontalListView;->mRecycler:Lco/vine/android/views/HorizontalListView$Recycler;

    add-int v15, v5, v6

    invoke-virtual {v14, v1, v15}, Lco/vine/android/views/HorizontalListView$Recycler;->addRecycleView(Landroid/view/View;I)V

    .line 737
    add-int/lit8 v6, v6, -0x1

    goto :goto_6

    .line 761
    .end local v1    # "child":Landroid/view/View;
    :cond_b
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/views/HorizontalListView;->invalidate()V

    .line 766
    invoke-static/range {p2 .. p2}, Ljava/lang/Math;->abs(I)I

    move-result v14

    if-ge v10, v14, :cond_c

    .line 767
    move-object/from16 v0, p0

    invoke-direct {v0, v11}, Lco/vine/android/views/HorizontalListView;->fillGap(Z)V

    .line 769
    :cond_c
    move-object/from16 v0, p0

    iget-object v14, v0, Lco/vine/android/views/HorizontalListView;->mOnScrollListener:Lco/vine/android/views/HorizontalListView$OnScrollListener;

    if-eqz v14, :cond_d

    .line 770
    move-object/from16 v0, p0

    iget-object v14, v0, Lco/vine/android/views/HorizontalListView;->mOnScrollListener:Lco/vine/android/views/HorizontalListView$OnScrollListener;

    invoke-interface {v14}, Lco/vine/android/views/HorizontalListView$OnScrollListener;->onScroll()V

    .line 773
    .end local v3    # "count":I
    .end local v6    # "i":I
    .end local v13    # "start":I
    :cond_d
    return v12
.end method

.method public bridge synthetic setAdapter(Landroid/widget/Adapter;)V
    .locals 0
    .param p1, "x0"    # Landroid/widget/Adapter;

    .prologue
    .line 48
    check-cast p1, Landroid/widget/ListAdapter;

    .end local p1    # "x0":Landroid/widget/Adapter;
    invoke-virtual {p0, p1}, Lco/vine/android/views/HorizontalListView;->setAdapter(Landroid/widget/ListAdapter;)V

    return-void
.end method

.method public setAdapter(Landroid/widget/ListAdapter;)V
    .locals 2
    .param p1, "listAdapter"    # Landroid/widget/ListAdapter;

    .prologue
    .line 259
    iget-object v0, p0, Lco/vine/android/views/HorizontalListView;->mAdapter:Landroid/widget/ListAdapter;

    if-eq p1, v0, :cond_2

    .line 260
    iget-object v0, p0, Lco/vine/android/views/HorizontalListView;->mDataSetObserver:Landroid/database/DataSetObserver;

    if-nez v0, :cond_0

    .line 261
    new-instance v0, Lco/vine/android/views/HorizontalListView$AdapterDataSetObserver;

    invoke-direct {v0, p0}, Lco/vine/android/views/HorizontalListView$AdapterDataSetObserver;-><init>(Lco/vine/android/views/HorizontalListView;)V

    iput-object v0, p0, Lco/vine/android/views/HorizontalListView;->mDataSetObserver:Landroid/database/DataSetObserver;

    .line 263
    :cond_0
    iget-object v0, p0, Lco/vine/android/views/HorizontalListView;->mAdapter:Landroid/widget/ListAdapter;

    if-eqz v0, :cond_1

    .line 264
    iget-object v0, p0, Lco/vine/android/views/HorizontalListView;->mAdapter:Landroid/widget/ListAdapter;

    iget-object v1, p0, Lco/vine/android/views/HorizontalListView;->mDataSetObserver:Landroid/database/DataSetObserver;

    invoke-interface {v0, v1}, Landroid/widget/ListAdapter;->unregisterDataSetObserver(Landroid/database/DataSetObserver;)V

    .line 266
    :cond_1
    iput-object p1, p0, Lco/vine/android/views/HorizontalListView;->mAdapter:Landroid/widget/ListAdapter;

    .line 267
    if-eqz p1, :cond_3

    .line 268
    iget-object v0, p0, Lco/vine/android/views/HorizontalListView;->mDataSetObserver:Landroid/database/DataSetObserver;

    invoke-interface {p1, v0}, Landroid/widget/ListAdapter;->registerDataSetObserver(Landroid/database/DataSetObserver;)V

    .line 269
    invoke-interface {p1}, Landroid/widget/ListAdapter;->getCount()I

    move-result v0

    iput v0, p0, Lco/vine/android/views/HorizontalListView;->mItemCount:I

    .line 274
    :cond_2
    :goto_0
    return-void

    .line 271
    :cond_3
    const/4 v0, 0x0

    iput v0, p0, Lco/vine/android/views/HorizontalListView;->mItemCount:I

    goto :goto_0
.end method

.method public setChildWidthListener(Lco/vine/android/views/HorizontalListView$ChildWidthListener;)V
    .locals 0
    .param p1, "widthListener"    # Lco/vine/android/views/HorizontalListView$ChildWidthListener;

    .prologue
    .line 1498
    iput-object p1, p0, Lco/vine/android/views/HorizontalListView;->mChildWidthListener:Lco/vine/android/views/HorizontalListView$ChildWidthListener;

    .line 1499
    return-void
.end method

.method public setClipToPadding(Z)V
    .locals 0
    .param p1, "clipToPadding"    # Z

    .prologue
    .line 1114
    invoke-super {p0, p1}, Landroid/widget/AdapterView;->setClipToPadding(Z)V

    .line 1115
    iput-boolean p1, p0, Lco/vine/android/views/HorizontalListView;->mClipToPadding:Z

    .line 1116
    return-void
.end method

.method public setDivider(Landroid/graphics/drawable/Drawable;)V
    .locals 1
    .param p1, "divider"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 1096
    if-eqz p1, :cond_0

    .line 1097
    invoke-virtual {p1}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v0

    iput v0, p0, Lco/vine/android/views/HorizontalListView;->mDividerWidth:I

    .line 1101
    :goto_0
    iput-object p1, p0, Lco/vine/android/views/HorizontalListView;->mDivider:Landroid/graphics/drawable/Drawable;

    .line 1102
    invoke-virtual {p0}, Lco/vine/android/views/HorizontalListView;->requestLayout()V

    .line 1103
    invoke-virtual {p0}, Lco/vine/android/views/HorizontalListView;->invalidate()V

    .line 1104
    return-void

    .line 1099
    :cond_0
    const/4 v0, 0x0

    iput v0, p0, Lco/vine/android/views/HorizontalListView;->mDividerWidth:I

    goto :goto_0
.end method

.method public setDividerWidth(I)V
    .locals 0
    .param p1, "dividerWidth"    # I

    .prologue
    .line 1107
    iput p1, p0, Lco/vine/android/views/HorizontalListView;->mDividerWidth:I

    .line 1108
    invoke-virtual {p0}, Lco/vine/android/views/HorizontalListView;->requestLayout()V

    .line 1109
    invoke-virtual {p0}, Lco/vine/android/views/HorizontalListView;->invalidate()V

    .line 1110
    return-void
.end method

.method public setFingerScrollEnabled(Z)V
    .locals 0
    .param p1, "shouldScroll"    # Z

    .prologue
    .line 1524
    iput-boolean p1, p0, Lco/vine/android/views/HorizontalListView;->mFingerScrollEnabled:Z

    .line 1525
    return-void
.end method

.method public setLongPressDuration(I)V
    .locals 0
    .param p1, "longPresMillis"    # I

    .prologue
    .line 1515
    iput p1, p0, Lco/vine/android/views/HorizontalListView;->mLongPressMillis:I

    .line 1516
    return-void
.end method

.method public setOnItemLongClickListener(Landroid/widget/AdapterView$OnItemLongClickListener;)V
    .locals 0
    .param p1, "listener"    # Landroid/widget/AdapterView$OnItemLongClickListener;

    .prologue
    .line 1507
    iput-object p1, p0, Lco/vine/android/views/HorizontalListView;->mOnItemLongClickListener:Landroid/widget/AdapterView$OnItemLongClickListener;

    .line 1508
    return-void
.end method

.method public setOnScrollListener(Lco/vine/android/dragsort/DragSortWidget;)V
    .locals 0
    .param p1, "onScrollListener"    # Lco/vine/android/dragsort/DragSortWidget;

    .prologue
    .line 1119
    iput-object p1, p0, Lco/vine/android/views/HorizontalListView;->mOnScrollListener:Lco/vine/android/views/HorizontalListView$OnScrollListener;

    .line 1120
    return-void
.end method

.method public setPressed(Z)V
    .locals 1
    .param p1, "pressed"    # Z

    .prologue
    .line 1005
    invoke-virtual {p0}, Lco/vine/android/views/HorizontalListView;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    if-nez v0, :cond_0

    .line 1006
    invoke-super {p0, p1}, Landroid/widget/AdapterView;->setPressed(Z)V

    .line 1008
    :cond_0
    return-void
.end method

.method public setSelection(I)V
    .locals 0
    .param p1, "position"    # I

    .prologue
    .line 290
    iput p1, p0, Lco/vine/android/views/HorizontalListView;->mFirstVisiblePos:I

    .line 291
    invoke-virtual {p0}, Lco/vine/android/views/HorizontalListView;->detachAllViewsFromParent()V

    .line 292
    invoke-virtual {p0}, Lco/vine/android/views/HorizontalListView;->layoutChildren()V

    .line 293
    invoke-virtual {p0}, Lco/vine/android/views/HorizontalListView;->invalidate()V

    .line 294
    return-void
.end method
