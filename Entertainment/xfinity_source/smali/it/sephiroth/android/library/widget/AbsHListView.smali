.class public abstract Lit/sephiroth/android/library/widget/AbsHListView;
.super Lit/sephiroth/android/library/widget/AdapterView;
.source "AbsHListView.java"

# interfaces
.implements Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;
.implements Landroid/view/ViewTreeObserver$OnTouchModeChangeListener;


# annotations
.annotation build Landroid/annotation/TargetApi;
    value = 0xb
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;,
        Lit/sephiroth/android/library/widget/AbsHListView$RecyclerListener;,
        Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;,
        Lit/sephiroth/android/library/widget/AbsHListView$AdapterDataSetObserver;,
        Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;,
        Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;,
        Lit/sephiroth/android/library/widget/AbsHListView$CheckForTap;,
        Lit/sephiroth/android/library/widget/AbsHListView$CheckForKeyLongPress;,
        Lit/sephiroth/android/library/widget/AbsHListView$CheckForLongPress;,
        Lit/sephiroth/android/library/widget/AbsHListView$PerformClick;,
        Lit/sephiroth/android/library/widget/AbsHListView$WindowRunnnable;,
        Lit/sephiroth/android/library/widget/AbsHListView$ListItemAccessibilityDelegate;,
        Lit/sephiroth/android/library/widget/AbsHListView$SavedState;,
        Lit/sephiroth/android/library/widget/AbsHListView$SelectionBoundsAdjuster;,
        Lit/sephiroth/android/library/widget/AbsHListView$OnScrollListener;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lit/sephiroth/android/library/widget/AdapterView",
        "<",
        "Landroid/widget/ListAdapter;",
        ">;",
        "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;",
        "Landroid/view/ViewTreeObserver$OnTouchModeChangeListener;"
    }
.end annotation


# static fields
.field public static final STATESET_NOTHING:[I

.field static final sLinearInterpolator:Landroid/view/animation/Interpolator;


# instance fields
.field private mAccessibilityDelegate:Lit/sephiroth/android/library/widget/AbsHListView$ListItemAccessibilityDelegate;

.field private mActivePointerId:I

.field protected mAdapter:Landroid/widget/ListAdapter;

.field mAdapterHasStableIds:Z

.field private mCacheColorHint:I

.field protected mCachingActive:Z

.field protected mCachingStarted:Z

.field protected mCheckStates:Landroid/support/v4/util/SparseArrayCompat;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/support/v4/util/SparseArrayCompat",
            "<",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation
.end field

.field mCheckedIdStates:Landroid/support/v4/util/LongSparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/support/v4/util/LongSparseArray",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field mCheckedItemCount:I

.field public mChoiceActionMode:Ljava/lang/Object;

.field protected mChoiceMode:I

.field private mClearScrollingCache:Ljava/lang/Runnable;

.field private mContextMenuInfo:Landroid/view/ContextMenu$ContextMenuInfo;

.field protected mDataSetObserver:Lit/sephiroth/android/library/widget/AbsHListView$AdapterDataSetObserver;

.field private mDirection:I

.field mDrawSelectorOnTop:Z

.field private mEdgeGlowBottom:Lit/sephiroth/android/library/widget/EdgeEffect;

.field private mEdgeGlowTop:Lit/sephiroth/android/library/widget/EdgeEffect;

.field private mFirstPositionDistanceGuess:I

.field private mFlingRunnable:Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;

.field private mForceTranscriptScroll:Z

.field private mGlowPaddingBottom:I

.field private mGlowPaddingTop:I

.field protected mHeightMeasureSpec:I

.field private mHorizontalScrollFactor:F

.field protected mIsAttached:Z

.field private mIsChildViewEnabled:Z

.field protected final mIsScrap:[Z

.field private mLastAccessibilityScrollEventFromIndex:I

.field private mLastAccessibilityScrollEventToIndex:I

.field private mLastHandledItemCount:I

.field private mLastPositionDistanceGuess:I

.field private mLastScrollState:I

.field private mLastTouchMode:I

.field mLastX:I

.field protected mLayoutMode:I

.field protected mListPadding:Landroid/graphics/Rect;

.field private mMaximumVelocity:I

.field private mMinimumVelocity:I

.field mMotionCorrection:I

.field protected mMotionPosition:I

.field mMotionViewNewLeft:I

.field mMotionViewOriginalLeft:I

.field mMotionX:I

.field mMotionY:I

.field mMultiChoiceModeCallback:Ljava/lang/Object;

.field private mOnScrollListener:Lit/sephiroth/android/library/widget/AbsHListView$OnScrollListener;

.field mOverflingDistance:I

.field mOverscrollDistance:I

.field protected mOverscrollMax:I

.field private mPendingCheckForKeyLongPress:Lit/sephiroth/android/library/widget/AbsHListView$CheckForKeyLongPress;

.field private mPendingCheckForLongPress:Lit/sephiroth/android/library/widget/AbsHListView$CheckForLongPress;

.field private mPendingCheckForTap:Ljava/lang/Runnable;

.field private mPendingSync:Lit/sephiroth/android/library/widget/AbsHListView$SavedState;

.field private mPerformClick:Lit/sephiroth/android/library/widget/AbsHListView$PerformClick;

.field protected mPositionScrollAfterLayout:Ljava/lang/Runnable;

.field protected mPositionScroller:Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;

.field protected final mRecycler:Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;

.field protected mResurrectToPosition:I

.field mScrollLeft:Landroid/view/View;

.field mScrollRight:Landroid/view/View;

.field mScrollingCacheEnabled:Z

.field protected mSelectedLeft:I

.field mSelectionBottomPadding:I

.field mSelectionLeftPadding:I

.field mSelectionRightPadding:I

.field mSelectionTopPadding:I

.field mSelector:Landroid/graphics/drawable/Drawable;

.field mSelectorPosition:I

.field protected mSelectorRect:Landroid/graphics/Rect;

.field private mSmoothScrollbarEnabled:Z

.field protected mStackFromRight:Z

.field private mTouchFrame:Landroid/graphics/Rect;

.field protected mTouchMode:I

.field private mTouchModeReset:Ljava/lang/Runnable;

.field private mTouchSlop:I

.field private mTranscriptMode:I

.field private mVelocityScale:F

.field private mVelocityTracker:Landroid/view/VelocityTracker;

.field mViewHelper:Lit/sephiroth/android/library/util/ViewHelperFactory$ViewHelper;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 544
    new-instance v0, Landroid/view/animation/LinearInterpolator;

    invoke-direct {v0}, Landroid/view/animation/LinearInterpolator;-><init>()V

    sput-object v0, Lit/sephiroth/android/library/widget/AbsHListView;->sLinearInterpolator:Landroid/view/animation/Interpolator;

    .line 2286
    const/4 v0, 0x1

    new-array v0, v0, [I

    aput v1, v0, v1

    sput-object v0, Lit/sephiroth/android/library/widget/AbsHListView;->STATESET_NOTHING:[I

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v3, 0x1

    const/4 v2, -0x1

    const/4 v1, 0x0

    .line 620
    invoke-direct {p0, p1}, Lit/sephiroth/android/library/widget/AdapterView;-><init>(Landroid/content/Context;)V

    .line 165
    iput v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mChoiceMode:I

    .line 199
    iput v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mLayoutMode:I

    .line 219
    iput-boolean v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mDrawSelectorOnTop:Z

    .line 229
    iput v2, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectorPosition:I

    .line 234
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    iput-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectorRect:Landroid/graphics/Rect;

    .line 239
    new-instance v0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;

    invoke-direct {v0, p0}, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;-><init>(Lit/sephiroth/android/library/widget/AbsHListView;)V

    iput-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mRecycler:Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;

    .line 244
    iput v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectionLeftPadding:I

    .line 249
    iput v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectionTopPadding:I

    .line 254
    iput v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectionRightPadding:I

    .line 259
    iput v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectionBottomPadding:I

    .line 264
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    iput-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mListPadding:Landroid/graphics/Rect;

    .line 269
    iput v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mHeightMeasureSpec:I

    .line 315
    iput v2, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mTouchMode:I

    .line 346
    iput v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectedLeft:I

    .line 371
    iput-boolean v3, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSmoothScrollbarEnabled:Z

    .line 381
    iput v2, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mResurrectToPosition:I

    .line 383
    const/4 v0, 0x0

    iput-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mContextMenuInfo:Landroid/view/ContextMenu$ContextMenuInfo;

    .line 408
    iput v2, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mLastTouchMode:I

    .line 453
    iput v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mLastScrollState:I

    .line 461
    const/high16 v0, 0x3f800000    # 1.0f

    iput v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mVelocityScale:F

    .line 463
    new-array v0, v3, [Z

    iput-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mIsScrap:[Z

    .line 468
    iput v2, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mActivePointerId:I

    .line 513
    iput v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mDirection:I

    .line 621
    invoke-direct {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->initAbsListView()V

    .line 622
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 625
    sget v0, Lit/sephiroth/android/library/R$attr;->hlv_absHListViewStyle:I

    invoke-direct {p0, p1, p2, v0}, Lit/sephiroth/android/library/widget/AbsHListView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 626
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 12
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    .line 629
    invoke-direct {p0, p1, p2, p3}, Lit/sephiroth/android/library/widget/AdapterView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 165
    const/4 v10, 0x0

    iput v10, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mChoiceMode:I

    .line 199
    const/4 v10, 0x0

    iput v10, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mLayoutMode:I

    .line 219
    const/4 v10, 0x0

    iput-boolean v10, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mDrawSelectorOnTop:Z

    .line 229
    const/4 v10, -0x1

    iput v10, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectorPosition:I

    .line 234
    new-instance v10, Landroid/graphics/Rect;

    invoke-direct {v10}, Landroid/graphics/Rect;-><init>()V

    iput-object v10, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectorRect:Landroid/graphics/Rect;

    .line 239
    new-instance v10, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;

    invoke-direct {v10, p0}, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;-><init>(Lit/sephiroth/android/library/widget/AbsHListView;)V

    iput-object v10, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mRecycler:Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;

    .line 244
    const/4 v10, 0x0

    iput v10, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectionLeftPadding:I

    .line 249
    const/4 v10, 0x0

    iput v10, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectionTopPadding:I

    .line 254
    const/4 v10, 0x0

    iput v10, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectionRightPadding:I

    .line 259
    const/4 v10, 0x0

    iput v10, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectionBottomPadding:I

    .line 264
    new-instance v10, Landroid/graphics/Rect;

    invoke-direct {v10}, Landroid/graphics/Rect;-><init>()V

    iput-object v10, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mListPadding:Landroid/graphics/Rect;

    .line 269
    const/4 v10, 0x0

    iput v10, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mHeightMeasureSpec:I

    .line 315
    const/4 v10, -0x1

    iput v10, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mTouchMode:I

    .line 346
    const/4 v10, 0x0

    iput v10, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectedLeft:I

    .line 371
    const/4 v10, 0x1

    iput-boolean v10, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSmoothScrollbarEnabled:Z

    .line 381
    const/4 v10, -0x1

    iput v10, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mResurrectToPosition:I

    .line 383
    const/4 v10, 0x0

    iput-object v10, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mContextMenuInfo:Landroid/view/ContextMenu$ContextMenuInfo;

    .line 408
    const/4 v10, -0x1

    iput v10, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mLastTouchMode:I

    .line 453
    const/4 v10, 0x0

    iput v10, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mLastScrollState:I

    .line 461
    const/high16 v10, 0x3f800000    # 1.0f

    iput v10, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mVelocityScale:F

    .line 463
    const/4 v10, 0x1

    new-array v10, v10, [Z

    iput-object v10, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mIsScrap:[Z

    .line 468
    const/4 v10, -0x1

    iput v10, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mActivePointerId:I

    .line 513
    const/4 v10, 0x0

    iput v10, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mDirection:I

    .line 635
    invoke-direct {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->initAbsListView()V

    .line 637
    invoke-virtual {p1}, Landroid/content/Context;->getTheme()Landroid/content/res/Resources$Theme;

    move-result-object v8

    .line 639
    .local v8, "theme":Landroid/content/res/Resources$Theme;
    sget-object v10, Lit/sephiroth/android/library/R$styleable;->AbsHListView:[I

    const/4 v11, 0x0

    invoke-virtual {v8, p2, v10, p3, v11}, Landroid/content/res/Resources$Theme;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 641
    .local v0, "array":Landroid/content/res/TypedArray;
    const/4 v4, 0x0

    .line 642
    .local v4, "listSelector":Landroid/graphics/drawable/Drawable;
    const/4 v3, 0x0

    .line 643
    .local v3, "drawSelectorOnTop":Z
    const/4 v7, 0x0

    .line 644
    .local v7, "stackFromRight":Z
    const/4 v5, 0x1

    .line 645
    .local v5, "scrollingCacheEnabled":Z
    const/4 v9, 0x0

    .line 646
    .local v9, "transcriptMode":I
    const/4 v2, 0x0

    .line 647
    .local v2, "color":I
    const/4 v6, 0x1

    .line 648
    .local v6, "smoothScrollbar":Z
    const/4 v1, 0x0

    .line 650
    .local v1, "choiceMode":I
    if-eqz v0, :cond_0

    .line 651
    const/4 v10, 0x0

    invoke-virtual {v0, v10}, Landroid/content/res/TypedArray;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v4

    .line 652
    const/4 v10, 0x1

    const/4 v11, 0x0

    invoke-virtual {v0, v10, v11}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v3

    .line 653
    const/4 v10, 0x6

    const/4 v11, 0x0

    invoke-virtual {v0, v10, v11}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v7

    .line 654
    const/4 v10, 0x2

    const/4 v11, 0x1

    invoke-virtual {v0, v10, v11}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v5

    .line 655
    const/4 v10, 0x7

    const/4 v11, 0x0

    invoke-virtual {v0, v10, v11}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v9

    .line 656
    const/4 v10, 0x3

    const/4 v11, 0x0

    invoke-virtual {v0, v10, v11}, Landroid/content/res/TypedArray;->getColor(II)I

    move-result v2

    .line 657
    const/4 v10, 0x5

    const/4 v11, 0x1

    invoke-virtual {v0, v10, v11}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v6

    .line 658
    const/4 v10, 0x4

    const/4 v11, 0x0

    invoke-virtual {v0, v10, v11}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v1

    .line 659
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 673
    :cond_0
    if-eqz v4, :cond_1

    .line 674
    invoke-virtual {p0, v4}, Lit/sephiroth/android/library/widget/AbsHListView;->setSelector(Landroid/graphics/drawable/Drawable;)V

    .line 677
    :cond_1
    iput-boolean v3, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mDrawSelectorOnTop:Z

    .line 678
    invoke-virtual {p0, v7}, Lit/sephiroth/android/library/widget/AbsHListView;->setStackFromRight(Z)V

    .line 679
    invoke-virtual {p0, v5}, Lit/sephiroth/android/library/widget/AbsHListView;->setScrollingCacheEnabled(Z)V

    .line 680
    invoke-virtual {p0, v9}, Lit/sephiroth/android/library/widget/AbsHListView;->setTranscriptMode(I)V

    .line 681
    invoke-virtual {p0, v2}, Lit/sephiroth/android/library/widget/AbsHListView;->setCacheColorHint(I)V

    .line 682
    invoke-virtual {p0, v6}, Lit/sephiroth/android/library/widget/AbsHListView;->setSmoothScrollbarEnabled(Z)V

    .line 683
    invoke-virtual {p0, v1}, Lit/sephiroth/android/library/widget/AbsHListView;->setChoiceMode(I)V

    .line 684
    return-void
.end method

.method static synthetic access$1100(Lit/sephiroth/android/library/widget/AbsHListView;)I
    .locals 1
    .param p0, "x0"    # Lit/sephiroth/android/library/widget/AbsHListView;

    .prologue
    .line 59
    iget v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mMaximumVelocity:I

    return v0
.end method

.method static synthetic access$1200(Lit/sephiroth/android/library/widget/AbsHListView;)I
    .locals 1
    .param p0, "x0"    # Lit/sephiroth/android/library/widget/AbsHListView;

    .prologue
    .line 59
    iget v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mMinimumVelocity:I

    return v0
.end method

.method static synthetic access$1300(Lit/sephiroth/android/library/widget/AbsHListView;)Z
    .locals 1
    .param p0, "x0"    # Lit/sephiroth/android/library/widget/AbsHListView;

    .prologue
    .line 59
    invoke-direct {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->contentFits()Z

    move-result v0

    return v0
.end method

.method static synthetic access$1400(Lit/sephiroth/android/library/widget/AbsHListView;)Lit/sephiroth/android/library/widget/EdgeEffect;
    .locals 1
    .param p0, "x0"    # Lit/sephiroth/android/library/widget/AbsHListView;

    .prologue
    .line 59
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mEdgeGlowTop:Lit/sephiroth/android/library/widget/EdgeEffect;

    return-object v0
.end method

.method static synthetic access$1500(Lit/sephiroth/android/library/widget/AbsHListView;)Lit/sephiroth/android/library/widget/EdgeEffect;
    .locals 1
    .param p0, "x0"    # Lit/sephiroth/android/library/widget/AbsHListView;

    .prologue
    .line 59
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mEdgeGlowBottom:Lit/sephiroth/android/library/widget/EdgeEffect;

    return-object v0
.end method

.method static synthetic access$1600(Lit/sephiroth/android/library/widget/AbsHListView;)V
    .locals 0
    .param p0, "x0"    # Lit/sephiroth/android/library/widget/AbsHListView;

    .prologue
    .line 59
    invoke-direct {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->clearScrollingCache()V

    return-void
.end method

.method static synthetic access$1700(Lit/sephiroth/android/library/widget/AbsHListView;IIIIIIIIZ)Z
    .locals 1
    .param p0, "x0"    # Lit/sephiroth/android/library/widget/AbsHListView;
    .param p1, "x1"    # I
    .param p2, "x2"    # I
    .param p3, "x3"    # I
    .param p4, "x4"    # I
    .param p5, "x5"    # I
    .param p6, "x6"    # I
    .param p7, "x7"    # I
    .param p8, "x8"    # I
    .param p9, "x9"    # Z

    .prologue
    .line 59
    invoke-virtual/range {p0 .. p9}, Lit/sephiroth/android/library/widget/AbsHListView;->overScrollBy(IIIIIIIIZ)Z

    move-result v0

    return v0
.end method

.method static synthetic access$1800(Lit/sephiroth/android/library/widget/AbsHListView;IIIIIIIIZ)Z
    .locals 1
    .param p0, "x0"    # Lit/sephiroth/android/library/widget/AbsHListView;
    .param p1, "x1"    # I
    .param p2, "x2"    # I
    .param p3, "x3"    # I
    .param p4, "x4"    # I
    .param p5, "x5"    # I
    .param p6, "x6"    # I
    .param p7, "x7"    # I
    .param p8, "x8"    # I
    .param p9, "x9"    # Z

    .prologue
    .line 59
    invoke-virtual/range {p0 .. p9}, Lit/sephiroth/android/library/widget/AbsHListView;->overScrollBy(IIIIIIIIZ)Z

    move-result v0

    return v0
.end method

.method static synthetic access$1900(Lit/sephiroth/android/library/widget/AbsHListView;IIIIIIIIZ)Z
    .locals 1
    .param p0, "x0"    # Lit/sephiroth/android/library/widget/AbsHListView;
    .param p1, "x1"    # I
    .param p2, "x2"    # I
    .param p3, "x3"    # I
    .param p4, "x4"    # I
    .param p5, "x5"    # I
    .param p6, "x6"    # I
    .param p7, "x7"    # I
    .param p8, "x8"    # I
    .param p9, "x9"    # Z

    .prologue
    .line 59
    invoke-virtual/range {p0 .. p9}, Lit/sephiroth/android/library/widget/AbsHListView;->overScrollBy(IIIIIIIIZ)Z

    move-result v0

    return v0
.end method

.method static synthetic access$200(Lit/sephiroth/android/library/widget/AbsHListView;)I
    .locals 1
    .param p0, "x0"    # Lit/sephiroth/android/library/widget/AbsHListView;

    .prologue
    .line 59
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getWindowAttachCount()I

    move-result v0

    return v0
.end method

.method static synthetic access$2000(Lit/sephiroth/android/library/widget/AbsHListView;Z)V
    .locals 0
    .param p0, "x0"    # Lit/sephiroth/android/library/widget/AbsHListView;
    .param p1, "x1"    # Z

    .prologue
    .line 59
    invoke-virtual {p0, p1}, Lit/sephiroth/android/library/widget/AbsHListView;->setChildrenDrawnWithCacheEnabled(Z)V

    return-void
.end method

.method static synthetic access$2100(Lit/sephiroth/android/library/widget/AbsHListView;Z)V
    .locals 0
    .param p0, "x0"    # Lit/sephiroth/android/library/widget/AbsHListView;
    .param p1, "x1"    # Z

    .prologue
    .line 59
    invoke-virtual {p0, p1}, Lit/sephiroth/android/library/widget/AbsHListView;->setChildrenDrawingCacheEnabled(Z)V

    return-void
.end method

.method static synthetic access$2300(Lit/sephiroth/android/library/widget/AbsHListView;Landroid/view/View;Z)V
    .locals 0
    .param p0, "x0"    # Lit/sephiroth/android/library/widget/AbsHListView;
    .param p1, "x1"    # Landroid/view/View;
    .param p2, "x2"    # Z

    .prologue
    .line 59
    invoke-virtual {p0, p1, p2}, Lit/sephiroth/android/library/widget/AbsHListView;->removeDetachedView(Landroid/view/View;Z)V

    return-void
.end method

.method static synthetic access$2400(Lit/sephiroth/android/library/widget/AbsHListView;Landroid/view/View;Z)V
    .locals 0
    .param p0, "x0"    # Lit/sephiroth/android/library/widget/AbsHListView;
    .param p1, "x1"    # Landroid/view/View;
    .param p2, "x2"    # Z

    .prologue
    .line 59
    invoke-virtual {p0, p1, p2}, Lit/sephiroth/android/library/widget/AbsHListView;->removeDetachedView(Landroid/view/View;Z)V

    return-void
.end method

.method static synthetic access$2500(Lit/sephiroth/android/library/widget/AbsHListView;Landroid/view/View;Z)V
    .locals 0
    .param p0, "x0"    # Lit/sephiroth/android/library/widget/AbsHListView;
    .param p1, "x1"    # Landroid/view/View;
    .param p2, "x2"    # Z

    .prologue
    .line 59
    invoke-virtual {p0, p1, p2}, Lit/sephiroth/android/library/widget/AbsHListView;->removeDetachedView(Landroid/view/View;Z)V

    return-void
.end method

.method static synthetic access$2600(Lit/sephiroth/android/library/widget/AbsHListView;Landroid/view/View;Z)V
    .locals 0
    .param p0, "x0"    # Lit/sephiroth/android/library/widget/AbsHListView;
    .param p1, "x1"    # Landroid/view/View;
    .param p2, "x2"    # Z

    .prologue
    .line 59
    invoke-virtual {p0, p1, p2}, Lit/sephiroth/android/library/widget/AbsHListView;->removeDetachedView(Landroid/view/View;Z)V

    return-void
.end method

.method static synthetic access$2700(Lit/sephiroth/android/library/widget/AbsHListView;Landroid/view/View;Z)V
    .locals 0
    .param p0, "x0"    # Lit/sephiroth/android/library/widget/AbsHListView;
    .param p1, "x1"    # Landroid/view/View;
    .param p2, "x2"    # Z

    .prologue
    .line 59
    invoke-virtual {p0, p1, p2}, Lit/sephiroth/android/library/widget/AbsHListView;->removeDetachedView(Landroid/view/View;Z)V

    return-void
.end method

.method static synthetic access$300(Lit/sephiroth/android/library/widget/AbsHListView;)I
    .locals 1
    .param p0, "x0"    # Lit/sephiroth/android/library/widget/AbsHListView;

    .prologue
    .line 59
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getWindowAttachCount()I

    move-result v0

    return v0
.end method

.method static synthetic access$500(Lit/sephiroth/android/library/widget/AbsHListView;)Lit/sephiroth/android/library/widget/AbsHListView$CheckForLongPress;
    .locals 1
    .param p0, "x0"    # Lit/sephiroth/android/library/widget/AbsHListView;

    .prologue
    .line 59
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mPendingCheckForLongPress:Lit/sephiroth/android/library/widget/AbsHListView$CheckForLongPress;

    return-object v0
.end method

.method static synthetic access$502(Lit/sephiroth/android/library/widget/AbsHListView;Lit/sephiroth/android/library/widget/AbsHListView$CheckForLongPress;)Lit/sephiroth/android/library/widget/AbsHListView$CheckForLongPress;
    .locals 0
    .param p0, "x0"    # Lit/sephiroth/android/library/widget/AbsHListView;
    .param p1, "x1"    # Lit/sephiroth/android/library/widget/AbsHListView$CheckForLongPress;

    .prologue
    .line 59
    iput-object p1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mPendingCheckForLongPress:Lit/sephiroth/android/library/widget/AbsHListView$CheckForLongPress;

    return-object p1
.end method

.method static synthetic access$800(Lit/sephiroth/android/library/widget/AbsHListView;)I
    .locals 1
    .param p0, "x0"    # Lit/sephiroth/android/library/widget/AbsHListView;

    .prologue
    .line 59
    iget v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mActivePointerId:I

    return v0
.end method

.method static synthetic access$900(Lit/sephiroth/android/library/widget/AbsHListView;)Landroid/view/VelocityTracker;
    .locals 1
    .param p0, "x0"    # Lit/sephiroth/android/library/widget/AbsHListView;

    .prologue
    .line 59
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mVelocityTracker:Landroid/view/VelocityTracker;

    return-object v0
.end method

.method private clearScrollingCache()V
    .locals 1

    .prologue
    .line 4523
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mViewHelper:Lit/sephiroth/android/library/util/ViewHelperFactory$ViewHelper;

    invoke-virtual {v0}, Lit/sephiroth/android/library/util/ViewHelperFactory$ViewHelper;->isHardwareAccelerated()Z

    move-result v0

    if-nez v0, :cond_1

    .line 4524
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mClearScrollingCache:Ljava/lang/Runnable;

    if-nez v0, :cond_0

    .line 4525
    new-instance v0, Lit/sephiroth/android/library/widget/AbsHListView$2;

    invoke-direct {v0, p0}, Lit/sephiroth/android/library/widget/AbsHListView$2;-><init>(Lit/sephiroth/android/library/widget/AbsHListView;)V

    iput-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mClearScrollingCache:Ljava/lang/Runnable;

    .line 4542
    :cond_0
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mClearScrollingCache:Ljava/lang/Runnable;

    invoke-virtual {p0, v0}, Lit/sephiroth/android/library/widget/AbsHListView;->post(Ljava/lang/Runnable;)Z

    .line 4544
    :cond_1
    return-void
.end method

.method private contentFits()Z
    .locals 6

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 1071
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildCount()I

    move-result v0

    .line 1072
    .local v0, "childCount":I
    if-nez v0, :cond_1

    .line 1075
    :cond_0
    :goto_0
    return v1

    .line 1073
    :cond_1
    iget v3, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mItemCount:I

    if-eq v0, v3, :cond_2

    move v1, v2

    goto :goto_0

    .line 1075
    :cond_2
    invoke-virtual {p0, v2}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildAt(I)Landroid/view/View;

    move-result-object v3

    invoke-virtual {v3}, Landroid/view/View;->getLeft()I

    move-result v3

    iget-object v4, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mListPadding:Landroid/graphics/Rect;

    iget v4, v4, Landroid/graphics/Rect;->left:I

    if-lt v3, v4, :cond_3

    add-int/lit8 v3, v0, -0x1

    invoke-virtual {p0, v3}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildAt(I)Landroid/view/View;

    move-result-object v3

    invoke-virtual {v3}, Landroid/view/View;->getRight()I

    move-result v3

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getWidth()I

    move-result v4

    iget-object v5, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mListPadding:Landroid/graphics/Rect;

    iget v5, v5, Landroid/graphics/Rect;->right:I

    sub-int/2addr v4, v5

    if-le v3, v4, :cond_0

    :cond_3
    move v1, v2

    goto :goto_0
.end method

.method private createScrollingCache()V
    .locals 2

    .prologue
    const/4 v1, 0x1

    .line 4515
    iget-boolean v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mScrollingCacheEnabled:Z

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCachingStarted:Z

    if-nez v0, :cond_0

    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mViewHelper:Lit/sephiroth/android/library/util/ViewHelperFactory$ViewHelper;

    invoke-virtual {v0}, Lit/sephiroth/android/library/util/ViewHelperFactory$ViewHelper;->isHardwareAccelerated()Z

    move-result v0

    if-nez v0, :cond_0

    .line 4516
    invoke-virtual {p0, v1}, Lit/sephiroth/android/library/widget/AbsHListView;->setChildrenDrawnWithCacheEnabled(Z)V

    .line 4517
    invoke-virtual {p0, v1}, Lit/sephiroth/android/library/widget/AbsHListView;->setChildrenDrawingCacheEnabled(Z)V

    .line 4518
    iput-boolean v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCachingActive:Z

    iput-boolean v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCachingStarted:Z

    .line 4520
    :cond_0
    return-void
.end method

.method private drawSelector(Landroid/graphics/Canvas;)V
    .locals 2
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 2184
    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectorRect:Landroid/graphics/Rect;

    invoke-virtual {v1}, Landroid/graphics/Rect;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_0

    .line 2185
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelector:Landroid/graphics/drawable/Drawable;

    .line 2186
    .local v0, "selector":Landroid/graphics/drawable/Drawable;
    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectorRect:Landroid/graphics/Rect;

    invoke-virtual {v0, v1}, Landroid/graphics/drawable/Drawable;->setBounds(Landroid/graphics/Rect;)V

    .line 2187
    invoke-virtual {v0, p1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 2189
    .end local v0    # "selector":Landroid/graphics/drawable/Drawable;
    :cond_0
    return-void
.end method

.method private finishGlows()V
    .locals 1

    .prologue
    .line 5334
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mEdgeGlowTop:Lit/sephiroth/android/library/widget/EdgeEffect;

    if-eqz v0, :cond_0

    .line 5335
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mEdgeGlowTop:Lit/sephiroth/android/library/widget/EdgeEffect;

    invoke-virtual {v0}, Lit/sephiroth/android/library/widget/EdgeEffect;->finish()V

    .line 5336
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mEdgeGlowBottom:Lit/sephiroth/android/library/widget/EdgeEffect;

    invoke-virtual {v0}, Lit/sephiroth/android/library/widget/EdgeEffect;->finish()V

    .line 5338
    :cond_0
    return-void
.end method

.method public static getDistance(Landroid/graphics/Rect;Landroid/graphics/Rect;I)I
    .locals 8
    .param p0, "source"    # Landroid/graphics/Rect;
    .param p1, "dest"    # Landroid/graphics/Rect;
    .param p2, "direction"    # I

    .prologue
    .line 5160
    sparse-switch p2, :sswitch_data_0

    .line 5193
    new-instance v6, Ljava/lang/IllegalArgumentException;

    const-string v7, "direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT, FOCUS_FORWARD, FOCUS_BACKWARD}."

    invoke-direct {v6, v7}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v6

    .line 5162
    :sswitch_0
    iget v4, p0, Landroid/graphics/Rect;->right:I

    .line 5163
    .local v4, "sX":I
    iget v6, p0, Landroid/graphics/Rect;->top:I

    invoke-virtual {p0}, Landroid/graphics/Rect;->height()I

    move-result v7

    div-int/lit8 v7, v7, 0x2

    add-int v5, v6, v7

    .line 5164
    .local v5, "sY":I
    iget v0, p1, Landroid/graphics/Rect;->left:I

    .line 5165
    .local v0, "dX":I
    iget v6, p1, Landroid/graphics/Rect;->top:I

    invoke-virtual {p1}, Landroid/graphics/Rect;->height()I

    move-result v7

    div-int/lit8 v7, v7, 0x2

    add-int v1, v6, v7

    .line 5197
    .local v1, "dY":I
    :goto_0
    sub-int v2, v0, v4

    .line 5198
    .local v2, "deltaX":I
    sub-int v3, v1, v5

    .line 5199
    .local v3, "deltaY":I
    mul-int v6, v3, v3

    mul-int v7, v2, v2

    add-int/2addr v6, v7

    return v6

    .line 5168
    .end local v0    # "dX":I
    .end local v1    # "dY":I
    .end local v2    # "deltaX":I
    .end local v3    # "deltaY":I
    .end local v4    # "sX":I
    .end local v5    # "sY":I
    :sswitch_1
    iget v6, p0, Landroid/graphics/Rect;->left:I

    invoke-virtual {p0}, Landroid/graphics/Rect;->width()I

    move-result v7

    div-int/lit8 v7, v7, 0x2

    add-int v4, v6, v7

    .line 5169
    .restart local v4    # "sX":I
    iget v5, p0, Landroid/graphics/Rect;->bottom:I

    .line 5170
    .restart local v5    # "sY":I
    iget v6, p1, Landroid/graphics/Rect;->left:I

    invoke-virtual {p1}, Landroid/graphics/Rect;->width()I

    move-result v7

    div-int/lit8 v7, v7, 0x2

    add-int v0, v6, v7

    .line 5171
    .restart local v0    # "dX":I
    iget v1, p1, Landroid/graphics/Rect;->top:I

    .line 5172
    .restart local v1    # "dY":I
    goto :goto_0

    .line 5174
    .end local v0    # "dX":I
    .end local v1    # "dY":I
    .end local v4    # "sX":I
    .end local v5    # "sY":I
    :sswitch_2
    iget v4, p0, Landroid/graphics/Rect;->left:I

    .line 5175
    .restart local v4    # "sX":I
    iget v6, p0, Landroid/graphics/Rect;->top:I

    invoke-virtual {p0}, Landroid/graphics/Rect;->height()I

    move-result v7

    div-int/lit8 v7, v7, 0x2

    add-int v5, v6, v7

    .line 5176
    .restart local v5    # "sY":I
    iget v0, p1, Landroid/graphics/Rect;->right:I

    .line 5177
    .restart local v0    # "dX":I
    iget v6, p1, Landroid/graphics/Rect;->top:I

    invoke-virtual {p1}, Landroid/graphics/Rect;->height()I

    move-result v7

    div-int/lit8 v7, v7, 0x2

    add-int v1, v6, v7

    .line 5178
    .restart local v1    # "dY":I
    goto :goto_0

    .line 5180
    .end local v0    # "dX":I
    .end local v1    # "dY":I
    .end local v4    # "sX":I
    .end local v5    # "sY":I
    :sswitch_3
    iget v6, p0, Landroid/graphics/Rect;->left:I

    invoke-virtual {p0}, Landroid/graphics/Rect;->width()I

    move-result v7

    div-int/lit8 v7, v7, 0x2

    add-int v4, v6, v7

    .line 5181
    .restart local v4    # "sX":I
    iget v5, p0, Landroid/graphics/Rect;->top:I

    .line 5182
    .restart local v5    # "sY":I
    iget v6, p1, Landroid/graphics/Rect;->left:I

    invoke-virtual {p1}, Landroid/graphics/Rect;->width()I

    move-result v7

    div-int/lit8 v7, v7, 0x2

    add-int v0, v6, v7

    .line 5183
    .restart local v0    # "dX":I
    iget v1, p1, Landroid/graphics/Rect;->bottom:I

    .line 5184
    .restart local v1    # "dY":I
    goto :goto_0

    .line 5187
    .end local v0    # "dX":I
    .end local v1    # "dY":I
    .end local v4    # "sX":I
    .end local v5    # "sY":I
    :sswitch_4
    iget v6, p0, Landroid/graphics/Rect;->right:I

    invoke-virtual {p0}, Landroid/graphics/Rect;->width()I

    move-result v7

    div-int/lit8 v7, v7, 0x2

    add-int v4, v6, v7

    .line 5188
    .restart local v4    # "sX":I
    iget v6, p0, Landroid/graphics/Rect;->top:I

    invoke-virtual {p0}, Landroid/graphics/Rect;->height()I

    move-result v7

    div-int/lit8 v7, v7, 0x2

    add-int v5, v6, v7

    .line 5189
    .restart local v5    # "sY":I
    iget v6, p1, Landroid/graphics/Rect;->left:I

    invoke-virtual {p1}, Landroid/graphics/Rect;->width()I

    move-result v7

    div-int/lit8 v7, v7, 0x2

    add-int v0, v6, v7

    .line 5190
    .restart local v0    # "dX":I
    iget v6, p1, Landroid/graphics/Rect;->top:I

    invoke-virtual {p1}, Landroid/graphics/Rect;->height()I

    move-result v7

    div-int/lit8 v7, v7, 0x2

    add-int v1, v6, v7

    .line 5191
    .restart local v1    # "dY":I
    goto :goto_0

    .line 5160
    nop

    :sswitch_data_0
    .sparse-switch
        0x1 -> :sswitch_4
        0x2 -> :sswitch_4
        0x11 -> :sswitch_2
        0x21 -> :sswitch_3
        0x42 -> :sswitch_0
        0x82 -> :sswitch_1
    .end sparse-switch
.end method

.method private initAbsListView()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x1

    .line 687
    invoke-virtual {p0, v1}, Lit/sephiroth/android/library/widget/AbsHListView;->setClickable(Z)V

    .line 688
    invoke-virtual {p0, v1}, Lit/sephiroth/android/library/widget/AbsHListView;->setFocusableInTouchMode(Z)V

    .line 689
    invoke-virtual {p0, v2}, Lit/sephiroth/android/library/widget/AbsHListView;->setWillNotDraw(Z)V

    .line 690
    invoke-virtual {p0, v2}, Lit/sephiroth/android/library/widget/AbsHListView;->setAlwaysDrawnWithCacheEnabled(Z)V

    .line 691
    invoke-virtual {p0, v1}, Lit/sephiroth/android/library/widget/AbsHListView;->setScrollingCacheEnabled(Z)V

    .line 693
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Landroid/view/ViewConfiguration;->get(Landroid/content/Context;)Landroid/view/ViewConfiguration;

    move-result-object v0

    .line 694
    .local v0, "configuration":Landroid/view/ViewConfiguration;
    invoke-virtual {v0}, Landroid/view/ViewConfiguration;->getScaledTouchSlop()I

    move-result v1

    iput v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mTouchSlop:I

    .line 695
    invoke-virtual {v0}, Landroid/view/ViewConfiguration;->getScaledMinimumFlingVelocity()I

    move-result v1

    iput v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mMinimumVelocity:I

    .line 696
    invoke-virtual {v0}, Landroid/view/ViewConfiguration;->getScaledMaximumFlingVelocity()I

    move-result v1

    iput v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mMaximumVelocity:I

    .line 697
    invoke-virtual {v0}, Landroid/view/ViewConfiguration;->getScaledOverscrollDistance()I

    move-result v1

    iput v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mOverscrollDistance:I

    .line 698
    invoke-virtual {v0}, Landroid/view/ViewConfiguration;->getScaledOverflingDistance()I

    move-result v1

    iput v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mOverflingDistance:I

    .line 699
    invoke-static {p0}, Lit/sephiroth/android/library/util/ViewHelperFactory;->create(Landroid/view/View;)Lit/sephiroth/android/library/util/ViewHelperFactory$ViewHelper;

    move-result-object v1

    iput-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mViewHelper:Lit/sephiroth/android/library/util/ViewHelperFactory$ViewHelper;

    .line 700
    return-void
.end method

.method private initOrResetVelocityTracker()V
    .locals 1

    .prologue
    .line 3499
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mVelocityTracker:Landroid/view/VelocityTracker;

    if-nez v0, :cond_0

    .line 3500
    invoke-static {}, Landroid/view/VelocityTracker;->obtain()Landroid/view/VelocityTracker;

    move-result-object v0

    iput-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mVelocityTracker:Landroid/view/VelocityTracker;

    .line 3504
    :goto_0
    return-void

    .line 3502
    :cond_0
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mVelocityTracker:Landroid/view/VelocityTracker;

    invoke-virtual {v0}, Landroid/view/VelocityTracker;->clear()V

    goto :goto_0
.end method

.method private initVelocityTrackerIfNotExists()V
    .locals 1

    .prologue
    .line 3507
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mVelocityTracker:Landroid/view/VelocityTracker;

    if-nez v0, :cond_0

    .line 3508
    invoke-static {}, Landroid/view/VelocityTracker;->obtain()Landroid/view/VelocityTracker;

    move-result-object v0

    iput-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mVelocityTracker:Landroid/view/VelocityTracker;

    .line 3510
    :cond_0
    return-void
.end method

.method private onSecondaryPointerUp(Landroid/view/MotionEvent;)V
    .locals 6
    .param p1, "ev"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v3, 0x0

    .line 3615
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v4

    const v5, 0xff00

    and-int/2addr v4, v5

    shr-int/lit8 v2, v4, 0x8

    .line 3617
    .local v2, "pointerIndex":I
    invoke-virtual {p1, v2}, Landroid/view/MotionEvent;->getPointerId(I)I

    move-result v1

    .line 3618
    .local v1, "pointerId":I
    iget v4, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mActivePointerId:I

    if-ne v1, v4, :cond_0

    .line 3622
    if-nez v2, :cond_1

    const/4 v0, 0x1

    .line 3623
    .local v0, "newPointerIndex":I
    :goto_0
    invoke-virtual {p1, v0}, Landroid/view/MotionEvent;->getX(I)F

    move-result v4

    float-to-int v4, v4

    iput v4, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mMotionX:I

    .line 3624
    invoke-virtual {p1, v0}, Landroid/view/MotionEvent;->getY(I)F

    move-result v4

    float-to-int v4, v4

    iput v4, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mMotionY:I

    .line 3625
    iput v3, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mMotionCorrection:I

    .line 3626
    invoke-virtual {p1, v0}, Landroid/view/MotionEvent;->getPointerId(I)I

    move-result v3

    iput v3, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mActivePointerId:I

    .line 3628
    .end local v0    # "newPointerIndex":I
    :cond_0
    return-void

    :cond_1
    move v0, v3

    .line 3622
    goto :goto_0
.end method

.method private positionSelector(IIII)V
    .locals 5
    .param p1, "l"    # I
    .param p2, "t"    # I
    .param p3, "r"    # I
    .param p4, "b"    # I

    .prologue
    .line 2105
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectorRect:Landroid/graphics/Rect;

    iget v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectionLeftPadding:I

    sub-int v1, p1, v1

    iget v2, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectionTopPadding:I

    sub-int v2, p2, v2

    iget v3, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectionRightPadding:I

    add-int/2addr v3, p3

    iget v4, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectionBottomPadding:I

    add-int/2addr v4, p4

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/graphics/Rect;->set(IIII)V

    .line 2107
    return-void
.end method

.method private recycleVelocityTracker()V
    .locals 1

    .prologue
    .line 3513
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mVelocityTracker:Landroid/view/VelocityTracker;

    if-eqz v0, :cond_0

    .line 3514
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mVelocityTracker:Landroid/view/VelocityTracker;

    invoke-virtual {v0}, Landroid/view/VelocityTracker;->recycle()V

    .line 3515
    const/4 v0, 0x0

    iput-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mVelocityTracker:Landroid/view/VelocityTracker;

    .line 3517
    :cond_0
    return-void
.end method

.method static retrieveFromScrap(Ljava/util/ArrayList;I)Landroid/view/View;
    .locals 4
    .param p1, "position"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Landroid/view/View;",
            ">;I)",
            "Landroid/view/View;"
        }
    .end annotation

    .prologue
    .line 5844
    .local p0, "scrapViews":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    invoke-virtual {p0}, Ljava/util/ArrayList;->size()I

    move-result v1

    .line 5845
    .local v1, "size":I
    if-lez v1, :cond_2

    .line 5847
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, v1, :cond_1

    .line 5848
    invoke-virtual {p0, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/view/View;

    .line 5849
    .local v2, "view":Landroid/view/View;
    invoke-virtual {v2}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v3

    check-cast v3, Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;

    iget v3, v3, Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;->scrappedFromPosition:I

    if-ne v3, p1, :cond_0

    .line 5850
    invoke-virtual {p0, v0}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    .line 5856
    .end local v0    # "i":I
    .end local v2    # "view":Landroid/view/View;
    :goto_1
    return-object v2

    .line 5847
    .restart local v0    # "i":I
    .restart local v2    # "view":Landroid/view/View;
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 5854
    .end local v2    # "view":Landroid/view/View;
    :cond_1
    add-int/lit8 v3, v1, -0x1

    invoke-virtual {p0, v3}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/view/View;

    move-object v2, v3

    goto :goto_1

    .line 5856
    .end local v0    # "i":I
    :cond_2
    const/4 v2, 0x0

    goto :goto_1
.end method

.method private scrollIfNeeded(I)V
    .locals 29
    .param p1, "x"    # I

    .prologue
    .line 2811
    move-object/from16 v0, p0

    iget v3, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mMotionX:I

    sub-int v28, p1, v3

    .line 2812
    .local v28, "rawDeltaX":I
    move-object/from16 v0, p0

    iget v3, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mMotionCorrection:I

    sub-int v16, v28, v3

    .line 2813
    .local v16, "deltaX":I
    move-object/from16 v0, p0

    iget v3, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mLastX:I

    const/high16 v5, -0x80000000

    if-eq v3, v5, :cond_9

    move-object/from16 v0, p0

    iget v3, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mLastX:I

    sub-int v17, p1, v3

    .line 2815
    .local v17, "incrementalDeltaX":I
    :goto_0
    move-object/from16 v0, p0

    iget v3, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mTouchMode:I

    const/4 v5, 0x3

    if-ne v3, v5, :cond_d

    .line 2817
    move-object/from16 v0, p0

    iget v3, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mLastX:I

    move/from16 v0, p1

    if-eq v0, v3, :cond_8

    .line 2821
    invoke-static/range {v28 .. v28}, Ljava/lang/Math;->abs(I)I

    move-result v3

    move-object/from16 v0, p0

    iget v5, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mTouchSlop:I

    if-le v3, v5, :cond_0

    .line 2822
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getParent()Landroid/view/ViewParent;

    move-result-object v27

    .line 2823
    .local v27, "parent":Landroid/view/ViewParent;
    if-eqz v27, :cond_0

    .line 2824
    const/4 v3, 0x1

    move-object/from16 v0, v27

    invoke-interface {v0, v3}, Landroid/view/ViewParent;->requestDisallowInterceptTouchEvent(Z)V

    .line 2829
    .end local v27    # "parent":Landroid/view/ViewParent;
    :cond_0
    move-object/from16 v0, p0

    iget v3, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mMotionPosition:I

    if-ltz v3, :cond_a

    .line 2830
    move-object/from16 v0, p0

    iget v3, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mMotionPosition:I

    move-object/from16 v0, p0

    iget v5, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mFirstPosition:I

    sub-int v18, v3, v5

    .line 2837
    .local v18, "motionIndex":I
    :goto_1
    const/16 v21, 0x0

    .line 2838
    .local v21, "motionViewPrevLeft":I
    move-object/from16 v0, p0

    move/from16 v1, v18

    invoke-virtual {v0, v1}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildAt(I)Landroid/view/View;

    move-result-object v20

    .line 2839
    .local v20, "motionView":Landroid/view/View;
    if-eqz v20, :cond_1

    .line 2840
    invoke-virtual/range {v20 .. v20}, Landroid/view/View;->getLeft()I

    move-result v21

    .line 2844
    :cond_1
    const/4 v15, 0x0

    .line 2845
    .local v15, "atEdge":Z
    if-eqz v17, :cond_2

    .line 2846
    move-object/from16 v0, p0

    move/from16 v1, v16

    move/from16 v2, v17

    invoke-virtual {v0, v1, v2}, Lit/sephiroth/android/library/widget/AbsHListView;->trackMotionScroll(II)Z

    move-result v15

    .line 2850
    :cond_2
    move-object/from16 v0, p0

    move/from16 v1, v18

    invoke-virtual {v0, v1}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildAt(I)Landroid/view/View;

    move-result-object v20

    .line 2851
    if-eqz v20, :cond_7

    .line 2854
    invoke-virtual/range {v20 .. v20}, Landroid/view/View;->getLeft()I

    move-result v22

    .line 2855
    .local v22, "motionViewRealLeft":I
    if-eqz v15, :cond_6

    .line 2858
    move/from16 v0, v17

    neg-int v3, v0

    sub-int v5, v22, v21

    sub-int v4, v3, v5

    .line 2859
    .local v4, "overscroll":I
    const/4 v5, 0x0

    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getScrollX()I

    move-result v6

    const/4 v7, 0x0

    const/4 v8, 0x0

    const/4 v9, 0x0

    move-object/from16 v0, p0

    iget v10, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mOverscrollDistance:I

    const/4 v11, 0x0

    const/4 v12, 0x1

    move-object/from16 v3, p0

    invoke-virtual/range {v3 .. v12}, Lit/sephiroth/android/library/widget/AbsHListView;->overScrollBy(IIIIIIIIZ)Z

    .line 2860
    move-object/from16 v0, p0

    iget v3, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mOverscrollDistance:I

    invoke-static {v3}, Ljava/lang/Math;->abs(I)I

    move-result v3

    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getScrollX()I

    move-result v5

    invoke-static {v5}, Ljava/lang/Math;->abs(I)I

    move-result v5

    if-ne v3, v5, :cond_3

    .line 2862
    move-object/from16 v0, p0

    iget-object v3, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mVelocityTracker:Landroid/view/VelocityTracker;

    if-eqz v3, :cond_3

    .line 2863
    move-object/from16 v0, p0

    iget-object v3, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mVelocityTracker:Landroid/view/VelocityTracker;

    invoke-virtual {v3}, Landroid/view/VelocityTracker;->clear()V

    .line 2867
    :cond_3
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getOverScrollMode()I

    move-result v26

    .line 2869
    .local v26, "overscrollMode":I
    if-eqz v26, :cond_4

    const/4 v3, 0x1

    move/from16 v0, v26

    if-ne v0, v3, :cond_6

    invoke-direct/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->contentFits()Z

    move-result v3

    if-nez v3, :cond_6

    .line 2871
    :cond_4
    const/4 v3, 0x0

    move-object/from16 v0, p0

    iput v3, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mDirection:I

    .line 2872
    const/4 v3, 0x5

    move-object/from16 v0, p0

    iput v3, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mTouchMode:I

    .line 2873
    if-lez v28, :cond_b

    .line 2874
    move-object/from16 v0, p0

    iget-object v3, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mEdgeGlowTop:Lit/sephiroth/android/library/widget/EdgeEffect;

    int-to-float v5, v4

    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getWidth()I

    move-result v7

    int-to-float v7, v7

    div-float/2addr v5, v7

    invoke-virtual {v3, v5}, Lit/sephiroth/android/library/widget/EdgeEffect;->onPull(F)V

    .line 2875
    move-object/from16 v0, p0

    iget-object v3, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mEdgeGlowBottom:Lit/sephiroth/android/library/widget/EdgeEffect;

    invoke-virtual {v3}, Lit/sephiroth/android/library/widget/EdgeEffect;->isFinished()Z

    move-result v3

    if-nez v3, :cond_5

    .line 2876
    move-object/from16 v0, p0

    iget-object v3, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mEdgeGlowBottom:Lit/sephiroth/android/library/widget/EdgeEffect;

    invoke-virtual {v3}, Lit/sephiroth/android/library/widget/EdgeEffect;->onRelease()V

    .line 2878
    :cond_5
    move-object/from16 v0, p0

    iget-object v3, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mEdgeGlowTop:Lit/sephiroth/android/library/widget/EdgeEffect;

    const/4 v5, 0x0

    invoke-virtual {v3, v5}, Lit/sephiroth/android/library/widget/EdgeEffect;->getBounds(Z)Landroid/graphics/Rect;

    move-result-object v3

    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Lit/sephiroth/android/library/widget/AbsHListView;->invalidate(Landroid/graphics/Rect;)V

    .line 2888
    .end local v4    # "overscroll":I
    .end local v26    # "overscrollMode":I
    :cond_6
    :goto_2
    move/from16 v0, p1

    move-object/from16 v1, p0

    iput v0, v1, Lit/sephiroth/android/library/widget/AbsHListView;->mMotionX:I

    .line 2890
    .end local v22    # "motionViewRealLeft":I
    :cond_7
    move/from16 v0, p1

    move-object/from16 v1, p0

    iput v0, v1, Lit/sephiroth/android/library/widget/AbsHListView;->mLastX:I

    .line 2955
    .end local v15    # "atEdge":Z
    .end local v18    # "motionIndex":I
    .end local v20    # "motionView":Landroid/view/View;
    .end local v21    # "motionViewPrevLeft":I
    :cond_8
    :goto_3
    return-void

    .end local v17    # "incrementalDeltaX":I
    :cond_9
    move/from16 v17, v16

    .line 2813
    goto/16 :goto_0

    .line 2834
    .restart local v17    # "incrementalDeltaX":I
    :cond_a
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildCount()I

    move-result v3

    div-int/lit8 v18, v3, 0x2

    .restart local v18    # "motionIndex":I
    goto/16 :goto_1

    .line 2879
    .restart local v4    # "overscroll":I
    .restart local v15    # "atEdge":Z
    .restart local v20    # "motionView":Landroid/view/View;
    .restart local v21    # "motionViewPrevLeft":I
    .restart local v22    # "motionViewRealLeft":I
    .restart local v26    # "overscrollMode":I
    :cond_b
    if-gez v28, :cond_6

    .line 2880
    move-object/from16 v0, p0

    iget-object v3, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mEdgeGlowBottom:Lit/sephiroth/android/library/widget/EdgeEffect;

    int-to-float v5, v4

    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getWidth()I

    move-result v7

    int-to-float v7, v7

    div-float/2addr v5, v7

    invoke-virtual {v3, v5}, Lit/sephiroth/android/library/widget/EdgeEffect;->onPull(F)V

    .line 2881
    move-object/from16 v0, p0

    iget-object v3, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mEdgeGlowTop:Lit/sephiroth/android/library/widget/EdgeEffect;

    invoke-virtual {v3}, Lit/sephiroth/android/library/widget/EdgeEffect;->isFinished()Z

    move-result v3

    if-nez v3, :cond_c

    .line 2882
    move-object/from16 v0, p0

    iget-object v3, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mEdgeGlowTop:Lit/sephiroth/android/library/widget/EdgeEffect;

    invoke-virtual {v3}, Lit/sephiroth/android/library/widget/EdgeEffect;->onRelease()V

    .line 2884
    :cond_c
    move-object/from16 v0, p0

    iget-object v3, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mEdgeGlowBottom:Lit/sephiroth/android/library/widget/EdgeEffect;

    const/4 v5, 0x1

    invoke-virtual {v3, v5}, Lit/sephiroth/android/library/widget/EdgeEffect;->getBounds(Z)Landroid/graphics/Rect;

    move-result-object v3

    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Lit/sephiroth/android/library/widget/AbsHListView;->invalidate(Landroid/graphics/Rect;)V

    goto :goto_2

    .line 2892
    .end local v4    # "overscroll":I
    .end local v15    # "atEdge":Z
    .end local v18    # "motionIndex":I
    .end local v20    # "motionView":Landroid/view/View;
    .end local v21    # "motionViewPrevLeft":I
    .end local v22    # "motionViewRealLeft":I
    .end local v26    # "overscrollMode":I
    :cond_d
    move-object/from16 v0, p0

    iget v3, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mTouchMode:I

    const/4 v5, 0x5

    if-ne v3, v5, :cond_8

    .line 2893
    move-object/from16 v0, p0

    iget v3, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mLastX:I

    move/from16 v0, p1

    if-eq v0, v3, :cond_8

    .line 2894
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getScrollX()I

    move-result v25

    .line 2895
    .local v25, "oldScroll":I
    sub-int v24, v25, v17

    .line 2896
    .local v24, "newScroll":I
    move-object/from16 v0, p0

    iget v3, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mLastX:I

    move/from16 v0, p1

    if-le v0, v3, :cond_16

    const/16 v23, 0x1

    .line 2898
    .local v23, "newDirection":I
    :goto_4
    move-object/from16 v0, p0

    iget v3, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mDirection:I

    if-nez v3, :cond_e

    .line 2899
    move/from16 v0, v23

    move-object/from16 v1, p0

    iput v0, v1, Lit/sephiroth/android/library/widget/AbsHListView;->mDirection:I

    .line 2902
    :cond_e
    move/from16 v0, v17

    neg-int v6, v0

    .line 2903
    .local v6, "overScrollDistance":I
    if-gez v24, :cond_f

    if-gez v25, :cond_10

    :cond_f
    if-lez v24, :cond_17

    if-gtz v25, :cond_17

    .line 2904
    :cond_10
    move/from16 v0, v25

    neg-int v6, v0

    .line 2905
    add-int v17, v17, v6

    .line 2910
    :goto_5
    if-eqz v6, :cond_13

    .line 2911
    const/4 v7, 0x0

    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getScrollX()I

    move-result v8

    const/4 v9, 0x0

    const/4 v10, 0x0

    const/4 v11, 0x0

    move-object/from16 v0, p0

    iget v12, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mOverscrollDistance:I

    const/4 v13, 0x0

    const/4 v14, 0x1

    move-object/from16 v5, p0

    invoke-virtual/range {v5 .. v14}, Lit/sephiroth/android/library/widget/AbsHListView;->overScrollBy(IIIIIIIIZ)Z

    .line 2912
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getOverScrollMode()I

    move-result v26

    .line 2913
    .restart local v26    # "overscrollMode":I
    if-eqz v26, :cond_11

    const/4 v3, 0x1

    move/from16 v0, v26

    if-ne v0, v3, :cond_13

    invoke-direct/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->contentFits()Z

    move-result v3

    if-nez v3, :cond_13

    .line 2914
    :cond_11
    if-lez v28, :cond_18

    .line 2915
    move-object/from16 v0, p0

    iget-object v3, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mEdgeGlowTop:Lit/sephiroth/android/library/widget/EdgeEffect;

    int-to-float v5, v6

    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getWidth()I

    move-result v7

    int-to-float v7, v7

    div-float/2addr v5, v7

    invoke-virtual {v3, v5}, Lit/sephiroth/android/library/widget/EdgeEffect;->onPull(F)V

    .line 2916
    move-object/from16 v0, p0

    iget-object v3, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mEdgeGlowBottom:Lit/sephiroth/android/library/widget/EdgeEffect;

    invoke-virtual {v3}, Lit/sephiroth/android/library/widget/EdgeEffect;->isFinished()Z

    move-result v3

    if-nez v3, :cond_12

    .line 2917
    move-object/from16 v0, p0

    iget-object v3, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mEdgeGlowBottom:Lit/sephiroth/android/library/widget/EdgeEffect;

    invoke-virtual {v3}, Lit/sephiroth/android/library/widget/EdgeEffect;->onRelease()V

    .line 2919
    :cond_12
    move-object/from16 v0, p0

    iget-object v3, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mEdgeGlowTop:Lit/sephiroth/android/library/widget/EdgeEffect;

    const/4 v5, 0x0

    invoke-virtual {v3, v5}, Lit/sephiroth/android/library/widget/EdgeEffect;->getBounds(Z)Landroid/graphics/Rect;

    move-result-object v3

    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Lit/sephiroth/android/library/widget/AbsHListView;->invalidate(Landroid/graphics/Rect;)V

    .line 2930
    .end local v26    # "overscrollMode":I
    :cond_13
    :goto_6
    if-eqz v17, :cond_15

    .line 2932
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getScrollX()I

    move-result v3

    if-eqz v3, :cond_14

    .line 2933
    move-object/from16 v0, p0

    iget-object v3, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mViewHelper:Lit/sephiroth/android/library/util/ViewHelperFactory$ViewHelper;

    const/4 v5, 0x0

    invoke-virtual {v3, v5}, Lit/sephiroth/android/library/util/ViewHelperFactory$ViewHelper;->setScrollX(I)V

    .line 2934
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->invalidateParentIfNeeded()V

    .line 2937
    :cond_14
    move-object/from16 v0, p0

    move/from16 v1, v17

    move/from16 v2, v17

    invoke-virtual {v0, v1, v2}, Lit/sephiroth/android/library/widget/AbsHListView;->trackMotionScroll(II)Z

    .line 2939
    const/4 v3, 0x3

    move-object/from16 v0, p0

    iput v3, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mTouchMode:I

    .line 2943
    invoke-virtual/range {p0 .. p1}, Lit/sephiroth/android/library/widget/AbsHListView;->findClosestMotionCol(I)I

    move-result v19

    .line 2945
    .local v19, "motionPosition":I
    const/4 v3, 0x0

    move-object/from16 v0, p0

    iput v3, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mMotionCorrection:I

    .line 2946
    move-object/from16 v0, p0

    iget v3, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mFirstPosition:I

    sub-int v3, v19, v3

    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildAt(I)Landroid/view/View;

    move-result-object v20

    .line 2947
    .restart local v20    # "motionView":Landroid/view/View;
    if-eqz v20, :cond_1a

    invoke-virtual/range {v20 .. v20}, Landroid/view/View;->getLeft()I

    move-result v3

    :goto_7
    move-object/from16 v0, p0

    iput v3, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mMotionViewOriginalLeft:I

    .line 2948
    move/from16 v0, p1

    move-object/from16 v1, p0

    iput v0, v1, Lit/sephiroth/android/library/widget/AbsHListView;->mMotionX:I

    .line 2949
    move/from16 v0, v19

    move-object/from16 v1, p0

    iput v0, v1, Lit/sephiroth/android/library/widget/AbsHListView;->mMotionPosition:I

    .line 2951
    .end local v19    # "motionPosition":I
    .end local v20    # "motionView":Landroid/view/View;
    :cond_15
    move/from16 v0, p1

    move-object/from16 v1, p0

    iput v0, v1, Lit/sephiroth/android/library/widget/AbsHListView;->mLastX:I

    .line 2952
    move/from16 v0, v23

    move-object/from16 v1, p0

    iput v0, v1, Lit/sephiroth/android/library/widget/AbsHListView;->mDirection:I

    goto/16 :goto_3

    .line 2896
    .end local v6    # "overScrollDistance":I
    .end local v23    # "newDirection":I
    :cond_16
    const/16 v23, -0x1

    goto/16 :goto_4

    .line 2907
    .restart local v6    # "overScrollDistance":I
    .restart local v23    # "newDirection":I
    :cond_17
    const/16 v17, 0x0

    goto/16 :goto_5

    .line 2920
    .restart local v26    # "overscrollMode":I
    :cond_18
    if-gez v28, :cond_13

    .line 2921
    move-object/from16 v0, p0

    iget-object v3, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mEdgeGlowBottom:Lit/sephiroth/android/library/widget/EdgeEffect;

    int-to-float v5, v6

    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getWidth()I

    move-result v7

    int-to-float v7, v7

    div-float/2addr v5, v7

    invoke-virtual {v3, v5}, Lit/sephiroth/android/library/widget/EdgeEffect;->onPull(F)V

    .line 2922
    move-object/from16 v0, p0

    iget-object v3, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mEdgeGlowTop:Lit/sephiroth/android/library/widget/EdgeEffect;

    invoke-virtual {v3}, Lit/sephiroth/android/library/widget/EdgeEffect;->isFinished()Z

    move-result v3

    if-nez v3, :cond_19

    .line 2923
    move-object/from16 v0, p0

    iget-object v3, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mEdgeGlowTop:Lit/sephiroth/android/library/widget/EdgeEffect;

    invoke-virtual {v3}, Lit/sephiroth/android/library/widget/EdgeEffect;->onRelease()V

    .line 2925
    :cond_19
    move-object/from16 v0, p0

    iget-object v3, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mEdgeGlowBottom:Lit/sephiroth/android/library/widget/EdgeEffect;

    const/4 v5, 0x1

    invoke-virtual {v3, v5}, Lit/sephiroth/android/library/widget/EdgeEffect;->getBounds(Z)Landroid/graphics/Rect;

    move-result-object v3

    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Lit/sephiroth/android/library/widget/AbsHListView;->invalidate(Landroid/graphics/Rect;)V

    goto/16 :goto_6

    .line 2947
    .end local v26    # "overscrollMode":I
    .restart local v19    # "motionPosition":I
    .restart local v20    # "motionView":Landroid/view/View;
    :cond_1a
    const/4 v3, 0x0

    goto :goto_7
.end method

.method private startScrollIfNeeded(I)Z
    .locals 10
    .param p1, "x"    # I

    .prologue
    const/4 v8, 0x1

    const/4 v7, 0x0

    .line 2772
    iget v6, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mMotionX:I

    sub-int v0, p1, v6

    .line 2773
    .local v0, "deltaX":I
    invoke-static {v0}, Ljava/lang/Math;->abs(I)I

    move-result v1

    .line 2774
    .local v1, "distance":I
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getScrollX()I

    move-result v6

    if-eqz v6, :cond_4

    move v4, v8

    .line 2775
    .local v4, "overscroll":Z
    :goto_0
    if-nez v4, :cond_0

    iget v6, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mTouchSlop:I

    if-le v1, v6, :cond_7

    .line 2776
    :cond_0
    invoke-direct {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->createScrollingCache()V

    .line 2777
    if-eqz v4, :cond_5

    .line 2778
    const/4 v6, 0x5

    iput v6, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mTouchMode:I

    .line 2779
    iput v7, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mMotionCorrection:I

    .line 2784
    :goto_1
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getHandler()Landroid/os/Handler;

    move-result-object v2

    .line 2788
    .local v2, "handler":Landroid/os/Handler;
    if-eqz v2, :cond_1

    .line 2789
    iget-object v6, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mPendingCheckForLongPress:Lit/sephiroth/android/library/widget/AbsHListView$CheckForLongPress;

    invoke-virtual {v2, v6}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 2791
    :cond_1
    invoke-virtual {p0, v7}, Lit/sephiroth/android/library/widget/AbsHListView;->setPressed(Z)V

    .line 2792
    iget v6, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mMotionPosition:I

    iget v9, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mFirstPosition:I

    sub-int/2addr v6, v9

    invoke-virtual {p0, v6}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildAt(I)Landroid/view/View;

    move-result-object v3

    .line 2793
    .local v3, "motionView":Landroid/view/View;
    if-eqz v3, :cond_2

    .line 2794
    invoke-virtual {v3, v7}, Landroid/view/View;->setPressed(Z)V

    .line 2796
    :cond_2
    invoke-virtual {p0, v8}, Lit/sephiroth/android/library/widget/AbsHListView;->reportScrollStateChange(I)V

    .line 2799
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getParent()Landroid/view/ViewParent;

    move-result-object v5

    .line 2800
    .local v5, "parent":Landroid/view/ViewParent;
    if-eqz v5, :cond_3

    .line 2801
    invoke-interface {v5, v8}, Landroid/view/ViewParent;->requestDisallowInterceptTouchEvent(Z)V

    .line 2803
    :cond_3
    invoke-direct {p0, p1}, Lit/sephiroth/android/library/widget/AbsHListView;->scrollIfNeeded(I)V

    move v6, v8

    .line 2807
    .end local v2    # "handler":Landroid/os/Handler;
    .end local v3    # "motionView":Landroid/view/View;
    .end local v5    # "parent":Landroid/view/ViewParent;
    :goto_2
    return v6

    .end local v4    # "overscroll":Z
    :cond_4
    move v4, v7

    .line 2774
    goto :goto_0

    .line 2781
    .restart local v4    # "overscroll":Z
    :cond_5
    const/4 v6, 0x3

    iput v6, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mTouchMode:I

    .line 2782
    if-lez v0, :cond_6

    iget v6, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mTouchSlop:I

    :goto_3
    iput v6, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mMotionCorrection:I

    goto :goto_1

    :cond_6
    iget v6, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mTouchSlop:I

    neg-int v6, v6

    goto :goto_3

    :cond_7
    move v6, v7

    .line 2807
    goto :goto_2
.end method

.method private updateOnScreenCheckedViews()V
    .locals 9

    .prologue
    const/4 v7, 0x0

    .line 983
    iget v2, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mFirstPosition:I

    .line 984
    .local v2, "firstPos":I
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildCount()I

    move-result v1

    .line 985
    .local v1, "count":I
    sget v6, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v8, 0xb

    if-lt v6, v8, :cond_1

    const/4 v5, 0x1

    .line 986
    .local v5, "useActivated":Z
    :goto_0
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_1
    if-ge v3, v1, :cond_3

    .line 987
    invoke-virtual {p0, v3}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 988
    .local v0, "child":Landroid/view/View;
    add-int v4, v2, v3

    .line 990
    .local v4, "position":I
    instance-of v6, v0, Landroid/widget/Checkable;

    if-eqz v6, :cond_2

    .line 991
    check-cast v0, Landroid/widget/Checkable;

    .end local v0    # "child":Landroid/view/View;
    iget-object v6, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckStates:Landroid/support/v4/util/SparseArrayCompat;

    invoke-static {v7}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v8

    invoke-virtual {v6, v4, v8}, Landroid/support/v4/util/SparseArrayCompat;->get(ILjava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/Boolean;

    invoke-virtual {v6}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v6

    invoke-interface {v0, v6}, Landroid/widget/Checkable;->setChecked(Z)V

    .line 986
    :cond_0
    :goto_2
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .end local v3    # "i":I
    .end local v4    # "position":I
    .end local v5    # "useActivated":Z
    :cond_1
    move v5, v7

    .line 985
    goto :goto_0

    .line 992
    .restart local v0    # "child":Landroid/view/View;
    .restart local v3    # "i":I
    .restart local v4    # "position":I
    .restart local v5    # "useActivated":Z
    :cond_2
    if-eqz v5, :cond_0

    .line 993
    iget-object v6, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckStates:Landroid/support/v4/util/SparseArrayCompat;

    invoke-static {v7}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v8

    invoke-virtual {v6, v4, v8}, Landroid/support/v4/util/SparseArrayCompat;->get(ILjava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/Boolean;

    invoke-virtual {v6}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v6

    invoke-virtual {v0, v6}, Landroid/view/View;->setActivated(Z)V

    goto :goto_2

    .line 996
    .end local v0    # "child":Landroid/view/View;
    .end local v4    # "position":I
    :cond_3
    return-void
.end method

.method private useDefaultSelector()V
    .locals 2

    .prologue
    .line 1256
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x1080062

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    invoke-virtual {p0, v0}, Lit/sephiroth/android/library/widget/AbsHListView;->setSelector(Landroid/graphics/drawable/Drawable;)V

    .line 1257
    return-void
.end method


# virtual methods
.method public addTouchables(Ljava/util/ArrayList;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Landroid/view/View;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 3635
    .local p1, "views":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildCount()I

    move-result v2

    .line 3636
    .local v2, "count":I
    iget v3, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mFirstPosition:I

    .line 3637
    .local v3, "firstPosition":I
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mAdapter:Landroid/widget/ListAdapter;

    .line 3639
    .local v0, "adapter":Landroid/widget/ListAdapter;
    if-nez v0, :cond_1

    .line 3650
    :cond_0
    return-void

    .line 3643
    :cond_1
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_0
    if-ge v4, v2, :cond_0

    .line 3644
    invoke-virtual {p0, v4}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    .line 3645
    .local v1, "child":Landroid/view/View;
    add-int v5, v3, v4

    invoke-interface {v0, v5}, Landroid/widget/ListAdapter;->isEnabled(I)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 3646
    invoke-virtual {p1, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 3648
    :cond_2
    invoke-virtual {v1, p1}, Landroid/view/View;->addTouchables(Ljava/util/ArrayList;)V

    .line 3643
    add-int/lit8 v4, v4, 0x1

    goto :goto_0
.end method

.method public checkInputConnectionProxy(Landroid/view/View;)Z
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 5215
    const/4 v0, 0x0

    return v0
.end method

.method protected checkLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Z
    .locals 1
    .param p1, "p"    # Landroid/view/ViewGroup$LayoutParams;

    .prologue
    .line 5236
    instance-of v0, p1, Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;

    return v0
.end method

.method public clearChoices()V
    .locals 1

    .prologue
    .line 829
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckStates:Landroid/support/v4/util/SparseArrayCompat;

    if-eqz v0, :cond_0

    .line 830
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckStates:Landroid/support/v4/util/SparseArrayCompat;

    invoke-virtual {v0}, Landroid/support/v4/util/SparseArrayCompat;->clear()V

    .line 832
    :cond_0
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckedIdStates:Landroid/support/v4/util/LongSparseArray;

    if-eqz v0, :cond_1

    .line 833
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckedIdStates:Landroid/support/v4/util/LongSparseArray;

    invoke-virtual {v0}, Landroid/support/v4/util/LongSparseArray;->clear()V

    .line 835
    :cond_1
    const/4 v0, 0x0

    iput v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckedItemCount:I

    .line 836
    return-void
.end method

.method protected computeHorizontalScrollExtent()I
    .locals 8

    .prologue
    const/4 v6, 0x0

    .line 1648
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildCount()I

    move-result v0

    .line 1649
    .local v0, "count":I
    if-lez v0, :cond_3

    .line 1650
    iget-boolean v7, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSmoothScrollbarEnabled:Z

    if-eqz v7, :cond_2

    .line 1651
    mul-int/lit8 v1, v0, 0x64

    .line 1653
    .local v1, "extent":I
    invoke-virtual {p0, v6}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildAt(I)Landroid/view/View;

    move-result-object v4

    .line 1654
    .local v4, "view":Landroid/view/View;
    invoke-virtual {v4}, Landroid/view/View;->getLeft()I

    move-result v2

    .line 1655
    .local v2, "left":I
    invoke-virtual {v4}, Landroid/view/View;->getWidth()I

    move-result v5

    .line 1656
    .local v5, "width":I
    if-lez v5, :cond_0

    .line 1657
    mul-int/lit8 v6, v2, 0x64

    div-int/2addr v6, v5

    add-int/2addr v1, v6

    .line 1660
    :cond_0
    add-int/lit8 v6, v0, -0x1

    invoke-virtual {p0, v6}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildAt(I)Landroid/view/View;

    move-result-object v4

    .line 1661
    invoke-virtual {v4}, Landroid/view/View;->getRight()I

    move-result v3

    .line 1662
    .local v3, "right":I
    invoke-virtual {v4}, Landroid/view/View;->getWidth()I

    move-result v5

    .line 1663
    if-lez v5, :cond_1

    .line 1664
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getWidth()I

    move-result v6

    sub-int v6, v3, v6

    mul-int/lit8 v6, v6, 0x64

    div-int/2addr v6, v5

    sub-int/2addr v1, v6

    .line 1672
    .end local v1    # "extent":I
    .end local v2    # "left":I
    .end local v3    # "right":I
    .end local v4    # "view":Landroid/view/View;
    .end local v5    # "width":I
    :cond_1
    :goto_0
    return v1

    .line 1669
    :cond_2
    const/4 v1, 0x1

    goto :goto_0

    :cond_3
    move v1, v6

    .line 1672
    goto :goto_0
.end method

.method protected computeHorizontalScrollOffset()I
    .locals 11

    .prologue
    const/4 v7, 0x0

    .line 1677
    iget v2, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mFirstPosition:I

    .line 1678
    .local v2, "firstPosition":I
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildCount()I

    move-result v0

    .line 1679
    .local v0, "childCount":I
    if-ltz v2, :cond_0

    if-lez v0, :cond_0

    .line 1680
    iget-boolean v8, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSmoothScrollbarEnabled:Z

    if-eqz v8, :cond_1

    .line 1681
    invoke-virtual {p0, v7}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildAt(I)Landroid/view/View;

    move-result-object v5

    .line 1682
    .local v5, "view":Landroid/view/View;
    invoke-virtual {v5}, Landroid/view/View;->getLeft()I

    move-result v4

    .line 1683
    .local v4, "left":I
    invoke-virtual {v5}, Landroid/view/View;->getWidth()I

    move-result v6

    .line 1684
    .local v6, "width":I
    if-lez v6, :cond_0

    .line 1685
    mul-int/lit8 v8, v2, 0x64

    mul-int/lit8 v9, v4, 0x64

    div-int/2addr v9, v6

    sub-int/2addr v8, v9

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getScrollX()I

    move-result v9

    int-to-float v9, v9

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getWidth()I

    move-result v10

    int-to-float v10, v10

    div-float/2addr v9, v10

    iget v10, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mItemCount:I

    int-to-float v10, v10

    mul-float/2addr v9, v10

    const/high16 v10, 0x42c80000    # 100.0f

    mul-float/2addr v9, v10

    float-to-int v9, v9

    add-int/2addr v8, v9

    invoke-static {v8, v7}, Ljava/lang/Math;->max(II)I

    move-result v7

    .line 1701
    .end local v4    # "left":I
    .end local v5    # "view":Landroid/view/View;
    .end local v6    # "width":I
    :cond_0
    :goto_0
    return v7

    .line 1690
    :cond_1
    iget v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mItemCount:I

    .line 1691
    .local v1, "count":I
    if-nez v2, :cond_2

    .line 1692
    const/4 v3, 0x0

    .line 1698
    .local v3, "index":I
    :goto_1
    int-to-float v7, v2

    int-to-float v8, v0

    int-to-float v9, v3

    int-to-float v10, v1

    div-float/2addr v9, v10

    mul-float/2addr v8, v9

    add-float/2addr v7, v8

    float-to-int v7, v7

    goto :goto_0

    .line 1693
    .end local v3    # "index":I
    :cond_2
    add-int v7, v2, v0

    if-ne v7, v1, :cond_3

    .line 1694
    move v3, v1

    .restart local v3    # "index":I
    goto :goto_1

    .line 1696
    .end local v3    # "index":I
    :cond_3
    div-int/lit8 v7, v0, 0x2

    add-int v3, v2, v7

    .restart local v3    # "index":I
    goto :goto_1
.end method

.method protected computeHorizontalScrollRange()I
    .locals 3

    .prologue
    .line 1707
    iget-boolean v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSmoothScrollbarEnabled:Z

    if-eqz v1, :cond_1

    .line 1708
    iget v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mItemCount:I

    mul-int/lit8 v1, v1, 0x64

    const/4 v2, 0x0

    invoke-static {v1, v2}, Ljava/lang/Math;->max(II)I

    move-result v0

    .line 1709
    .local v0, "result":I
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getScrollX()I

    move-result v1

    if-eqz v1, :cond_0

    .line 1711
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getScrollX()I

    move-result v1

    int-to-float v1, v1

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getWidth()I

    move-result v2

    int-to-float v2, v2

    div-float/2addr v1, v2

    iget v2, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mItemCount:I

    int-to-float v2, v2

    mul-float/2addr v1, v2

    const/high16 v2, 0x42c80000    # 100.0f

    mul-float/2addr v1, v2

    float-to-int v1, v1

    invoke-static {v1}, Ljava/lang/Math;->abs(I)I

    move-result v1

    add-int/2addr v0, v1

    .line 1716
    :cond_0
    :goto_0
    return v0

    .line 1714
    .end local v0    # "result":I
    :cond_1
    iget v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mItemCount:I

    .restart local v0    # "result":I
    goto :goto_0
.end method

.method confirmCheckedPositionsById()V
    .locals 18

    .prologue
    .line 4952
    move-object/from16 v0, p0

    iget-object v3, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckStates:Landroid/support/v4/util/SparseArrayCompat;

    invoke-virtual {v3}, Landroid/support/v4/util/SparseArrayCompat;->clear()V

    .line 4954
    const/4 v2, 0x0

    .line 4955
    .local v2, "checkedCountChanged":Z
    const/4 v9, 0x0

    .local v9, "checkedIndex":I
    :goto_0
    move-object/from16 v0, p0

    iget-object v3, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckedIdStates:Landroid/support/v4/util/LongSparseArray;

    invoke-virtual {v3}, Landroid/support/v4/util/LongSparseArray;->size()I

    move-result v3

    if-ge v9, v3, :cond_4

    .line 4956
    move-object/from16 v0, p0

    iget-object v3, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckedIdStates:Landroid/support/v4/util/LongSparseArray;

    invoke-virtual {v3, v9}, Landroid/support/v4/util/LongSparseArray;->keyAt(I)J

    move-result-wide v6

    .line 4957
    .local v6, "id":J
    move-object/from16 v0, p0

    iget-object v3, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckedIdStates:Landroid/support/v4/util/LongSparseArray;

    invoke-virtual {v3, v9}, Landroid/support/v4/util/LongSparseArray;->valueAt(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Integer;

    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v5

    .line 4959
    .local v5, "lastPos":I
    move-object/from16 v0, p0

    iget-object v3, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v3, v5}, Landroid/widget/ListAdapter;->getItemId(I)J

    move-result-wide v12

    .line 4960
    .local v12, "lastPosId":J
    cmp-long v3, v6, v12

    if-eqz v3, :cond_3

    .line 4962
    const/4 v3, 0x0

    add-int/lit8 v4, v5, -0x14

    invoke-static {v3, v4}, Ljava/lang/Math;->max(II)I

    move-result v17

    .line 4963
    .local v17, "start":I
    add-int/lit8 v3, v5, 0x14

    move-object/from16 v0, p0

    iget v4, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mItemCount:I

    invoke-static {v3, v4}, Ljava/lang/Math;->min(II)I

    move-result v10

    .line 4964
    .local v10, "end":I
    const/4 v11, 0x0

    .line 4965
    .local v11, "found":Z
    move/from16 v16, v17

    .local v16, "searchPos":I
    :goto_1
    move/from16 v0, v16

    if-ge v0, v10, :cond_0

    .line 4966
    move-object/from16 v0, p0

    iget-object v3, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mAdapter:Landroid/widget/ListAdapter;

    move/from16 v0, v16

    invoke-interface {v3, v0}, Landroid/widget/ListAdapter;->getItemId(I)J

    move-result-wide v14

    .line 4967
    .local v14, "searchId":J
    cmp-long v3, v6, v14

    if-nez v3, :cond_2

    .line 4968
    const/4 v11, 0x1

    .line 4969
    move-object/from16 v0, p0

    iget-object v3, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckStates:Landroid/support/v4/util/SparseArrayCompat;

    const/4 v4, 0x1

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    move/from16 v0, v16

    invoke-virtual {v3, v0, v4}, Landroid/support/v4/util/SparseArrayCompat;->put(ILjava/lang/Object;)V

    .line 4970
    move-object/from16 v0, p0

    iget-object v3, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckedIdStates:Landroid/support/v4/util/LongSparseArray;

    invoke-static/range {v16 .. v16}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v3, v9, v4}, Landroid/support/v4/util/LongSparseArray;->setValueAt(ILjava/lang/Object;)V

    .line 4975
    .end local v14    # "searchId":J
    :cond_0
    if-nez v11, :cond_1

    .line 4976
    move-object/from16 v0, p0

    iget-object v3, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckedIdStates:Landroid/support/v4/util/LongSparseArray;

    invoke-virtual {v3, v6, v7}, Landroid/support/v4/util/LongSparseArray;->delete(J)V

    .line 4977
    add-int/lit8 v9, v9, -0x1

    .line 4978
    move-object/from16 v0, p0

    iget v3, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckedItemCount:I

    add-int/lit8 v3, v3, -0x1

    move-object/from16 v0, p0

    iput v3, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckedItemCount:I

    .line 4979
    const/4 v2, 0x1

    .line 4981
    sget v3, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v4, 0xb

    if-le v3, v4, :cond_1

    .line 4982
    move-object/from16 v0, p0

    iget-object v3, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mChoiceActionMode:Ljava/lang/Object;

    if-eqz v3, :cond_1

    move-object/from16 v0, p0

    iget-object v3, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mMultiChoiceModeCallback:Ljava/lang/Object;

    if-eqz v3, :cond_1

    .line 4983
    move-object/from16 v0, p0

    iget-object v3, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mMultiChoiceModeCallback:Ljava/lang/Object;

    check-cast v3, Lit/sephiroth/android/library/util/v11/MultiChoiceModeWrapper;

    move-object/from16 v0, p0

    iget-object v4, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mChoiceActionMode:Ljava/lang/Object;

    check-cast v4, Landroid/view/ActionMode;

    const/4 v8, 0x0

    invoke-virtual/range {v3 .. v8}, Lit/sephiroth/android/library/util/v11/MultiChoiceModeWrapper;->onItemCheckedStateChanged(Landroid/view/ActionMode;IJZ)V

    .line 4955
    .end local v10    # "end":I
    .end local v11    # "found":Z
    .end local v16    # "searchPos":I
    .end local v17    # "start":I
    :cond_1
    :goto_2
    add-int/lit8 v9, v9, 0x1

    goto/16 :goto_0

    .line 4965
    .restart local v10    # "end":I
    .restart local v11    # "found":Z
    .restart local v14    # "searchId":J
    .restart local v16    # "searchPos":I
    .restart local v17    # "start":I
    :cond_2
    add-int/lit8 v16, v16, 0x1

    goto :goto_1

    .line 4988
    .end local v10    # "end":I
    .end local v11    # "found":Z
    .end local v14    # "searchId":J
    .end local v16    # "searchPos":I
    .end local v17    # "start":I
    :cond_3
    move-object/from16 v0, p0

    iget-object v3, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckStates:Landroid/support/v4/util/SparseArrayCompat;

    const/4 v4, 0x1

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    invoke-virtual {v3, v5, v4}, Landroid/support/v4/util/SparseArrayCompat;->put(ILjava/lang/Object;)V

    goto :goto_2

    .line 4992
    .end local v5    # "lastPos":I
    .end local v6    # "id":J
    .end local v12    # "lastPosId":J
    :cond_4
    if-eqz v2, :cond_5

    move-object/from16 v0, p0

    iget-object v3, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mChoiceActionMode:Ljava/lang/Object;

    if-eqz v3, :cond_5

    sget v3, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v4, 0xb

    if-le v3, v4, :cond_5

    .line 4993
    move-object/from16 v0, p0

    iget-object v3, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mChoiceActionMode:Ljava/lang/Object;

    check-cast v3, Landroid/view/ActionMode;

    invoke-virtual {v3}, Landroid/view/ActionMode;->invalidate()V

    .line 4995
    :cond_5
    return-void
.end method

.method createContextMenuInfo(Landroid/view/View;IJ)Landroid/view/ContextMenu$ContextMenuInfo;
    .locals 1
    .param p1, "view"    # Landroid/view/View;
    .param p2, "position"    # I
    .param p3, "id"    # J

    .prologue
    .line 2471
    new-instance v0, Lit/sephiroth/android/library/widget/AdapterView$AdapterContextMenuInfo;

    invoke-direct {v0, p1, p2, p3, p4}, Lit/sephiroth/android/library/widget/AdapterView$AdapterContextMenuInfo;-><init>(Landroid/view/View;IJ)V

    return-object v0
.end method

.method protected dispatchDraw(Landroid/graphics/Canvas;)V
    .locals 1
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 2118
    iget-boolean v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mDrawSelectorOnTop:Z

    .line 2119
    .local v0, "drawSelectorOnTop":Z
    if-nez v0, :cond_0

    .line 2120
    invoke-direct {p0, p1}, Lit/sephiroth/android/library/widget/AbsHListView;->drawSelector(Landroid/graphics/Canvas;)V

    .line 2123
    :cond_0
    invoke-super {p0, p1}, Lit/sephiroth/android/library/widget/AdapterView;->dispatchDraw(Landroid/graphics/Canvas;)V

    .line 2125
    if-eqz v0, :cond_1

    .line 2126
    invoke-direct {p0, p1}, Lit/sephiroth/android/library/widget/AbsHListView;->drawSelector(Landroid/graphics/Canvas;)V

    .line 2132
    :cond_1
    return-void
.end method

.method protected dispatchSetPressed(Z)V
    .locals 0
    .param p1, "pressed"    # Z

    .prologue
    .line 2671
    return-void
.end method

.method public draw(Landroid/graphics/Canvas;)V
    .locals 9
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 3444
    invoke-super {p0, p1}, Lit/sephiroth/android/library/widget/AdapterView;->draw(Landroid/graphics/Canvas;)V

    .line 3445
    iget-object v7, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mEdgeGlowTop:Lit/sephiroth/android/library/widget/EdgeEffect;

    if-eqz v7, :cond_3

    .line 3446
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getScrollX()I

    move-result v4

    .line 3447
    .local v4, "scrollX":I
    iget-object v7, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mEdgeGlowTop:Lit/sephiroth/android/library/widget/EdgeEffect;

    invoke-virtual {v7}, Lit/sephiroth/android/library/widget/EdgeEffect;->isFinished()Z

    move-result v7

    if-nez v7, :cond_1

    .line 3448
    invoke-virtual {p1}, Landroid/graphics/Canvas;->save()I

    move-result v3

    .line 3449
    .local v3, "restoreCount":I
    iget-object v7, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mListPadding:Landroid/graphics/Rect;

    iget v7, v7, Landroid/graphics/Rect;->top:I

    iget v8, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mGlowPaddingTop:I

    add-int v5, v7, v8

    .line 3450
    .local v5, "topPadding":I
    iget-object v7, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mListPadding:Landroid/graphics/Rect;

    iget v7, v7, Landroid/graphics/Rect;->bottom:I

    iget v8, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mGlowPaddingBottom:I

    add-int v0, v7, v8

    .line 3451
    .local v0, "bottomPadding":I
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getHeight()I

    move-result v7

    sub-int/2addr v7, v5

    sub-int v2, v7, v0

    .line 3454
    .local v2, "height":I
    const/4 v7, 0x0

    iget v8, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mFirstPositionDistanceGuess:I

    add-int/2addr v8, v4

    invoke-static {v7, v8}, Ljava/lang/Math;->min(II)I

    move-result v1

    .line 3458
    .local v1, "edgeX":I
    const/high16 v7, -0x3d4c0000    # -90.0f

    invoke-virtual {p1, v7}, Landroid/graphics/Canvas;->rotate(F)V

    .line 3459
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getHeight()I

    move-result v7

    neg-int v7, v7

    add-int/2addr v7, v5

    int-to-float v7, v7

    int-to-float v8, v1

    invoke-virtual {p1, v7, v8}, Landroid/graphics/Canvas;->translate(FF)V

    .line 3460
    iget-object v7, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mEdgeGlowTop:Lit/sephiroth/android/library/widget/EdgeEffect;

    invoke-virtual {v7, v2, v2}, Lit/sephiroth/android/library/widget/EdgeEffect;->setSize(II)V

    .line 3462
    iget-object v7, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mEdgeGlowTop:Lit/sephiroth/android/library/widget/EdgeEffect;

    invoke-virtual {v7, p1}, Lit/sephiroth/android/library/widget/EdgeEffect;->draw(Landroid/graphics/Canvas;)Z

    move-result v7

    if-eqz v7, :cond_0

    .line 3463
    iget-object v7, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mEdgeGlowTop:Lit/sephiroth/android/library/widget/EdgeEffect;

    invoke-virtual {v7, v1, v5}, Lit/sephiroth/android/library/widget/EdgeEffect;->setPosition(II)V

    .line 3465
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->invalidate()V

    .line 3467
    :cond_0
    invoke-virtual {p1, v3}, Landroid/graphics/Canvas;->restoreToCount(I)V

    .line 3469
    .end local v0    # "bottomPadding":I
    .end local v1    # "edgeX":I
    .end local v2    # "height":I
    .end local v3    # "restoreCount":I
    .end local v5    # "topPadding":I
    :cond_1
    iget-object v7, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mEdgeGlowBottom:Lit/sephiroth/android/library/widget/EdgeEffect;

    invoke-virtual {v7}, Lit/sephiroth/android/library/widget/EdgeEffect;->isFinished()Z

    move-result v7

    if-nez v7, :cond_3

    .line 3470
    invoke-virtual {p1}, Landroid/graphics/Canvas;->save()I

    move-result v3

    .line 3471
    .restart local v3    # "restoreCount":I
    iget-object v7, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mListPadding:Landroid/graphics/Rect;

    iget v7, v7, Landroid/graphics/Rect;->left:I

    iget v8, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mGlowPaddingTop:I

    add-int v5, v7, v8

    .line 3472
    .restart local v5    # "topPadding":I
    iget-object v7, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mListPadding:Landroid/graphics/Rect;

    iget v7, v7, Landroid/graphics/Rect;->right:I

    iget v8, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mGlowPaddingBottom:I

    add-int v0, v7, v8

    .line 3473
    .restart local v0    # "bottomPadding":I
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getHeight()I

    move-result v7

    sub-int/2addr v7, v5

    sub-int v2, v7, v0

    .line 3474
    .restart local v2    # "height":I
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getWidth()I

    move-result v6

    .line 3476
    .local v6, "width":I
    iget v7, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mLastPositionDistanceGuess:I

    add-int/2addr v7, v4

    invoke-static {v6, v7}, Ljava/lang/Math;->max(II)I

    move-result v1

    .line 3477
    .restart local v1    # "edgeX":I
    const/high16 v7, 0x42b40000    # 90.0f

    invoke-virtual {p1, v7}, Landroid/graphics/Canvas;->rotate(F)V

    .line 3478
    neg-int v7, v5

    int-to-float v7, v7

    neg-int v8, v1

    int-to-float v8, v8

    invoke-virtual {p1, v7, v8}, Landroid/graphics/Canvas;->translate(FF)V

    .line 3480
    iget-object v7, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mEdgeGlowBottom:Lit/sephiroth/android/library/widget/EdgeEffect;

    invoke-virtual {v7, v2, v2}, Lit/sephiroth/android/library/widget/EdgeEffect;->setSize(II)V

    .line 3482
    iget-object v7, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mEdgeGlowBottom:Lit/sephiroth/android/library/widget/EdgeEffect;

    invoke-virtual {v7, p1}, Lit/sephiroth/android/library/widget/EdgeEffect;->draw(Landroid/graphics/Canvas;)Z

    move-result v7

    if-eqz v7, :cond_2

    .line 3486
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->invalidate()V

    .line 3488
    :cond_2
    invoke-virtual {p1, v3}, Landroid/graphics/Canvas;->restoreToCount(I)V

    .line 3491
    .end local v0    # "bottomPadding":I
    .end local v1    # "edgeX":I
    .end local v2    # "height":I
    .end local v3    # "restoreCount":I
    .end local v4    # "scrollX":I
    .end local v5    # "topPadding":I
    .end local v6    # "width":I
    :cond_3
    return-void
.end method

.method protected drawableStateChanged()V
    .locals 0

    .prologue
    .line 2300
    invoke-super {p0}, Lit/sephiroth/android/library/widget/AdapterView;->drawableStateChanged()V

    .line 2301
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->updateSelectorState()V

    .line 2302
    return-void
.end method

.method protected abstract fillGap(Z)V
.end method

.method protected findClosestMotionCol(I)I
    .locals 3
    .param p1, "x"    # I

    .prologue
    const/4 v2, -0x1

    .line 4803
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildCount()I

    move-result v0

    .line 4804
    .local v0, "childCount":I
    if-nez v0, :cond_1

    move v1, v2

    .line 4809
    :cond_0
    :goto_0
    return v1

    .line 4808
    :cond_1
    invoke-virtual {p0, p1}, Lit/sephiroth/android/library/widget/AbsHListView;->findMotionCol(I)I

    move-result v1

    .line 4809
    .local v1, "motionCol":I
    if-ne v1, v2, :cond_0

    iget v2, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mFirstPosition:I

    add-int/2addr v2, v0

    add-int/lit8 v1, v2, -0x1

    goto :goto_0
.end method

.method protected abstract findMotionCol(I)I
.end method

.method protected generateDefaultLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    .locals 4

    .prologue
    .line 5220
    new-instance v0, Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;

    const/4 v1, -0x2

    const/4 v2, -0x1

    const/4 v3, 0x0

    invoke-direct {v0, v1, v2, v3}, Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;-><init>(III)V

    return-object v0
.end method

.method public bridge synthetic generateLayoutParams(Landroid/util/AttributeSet;)Landroid/view/ViewGroup$LayoutParams;
    .locals 1
    .param p1, "x0"    # Landroid/util/AttributeSet;

    .prologue
    .line 58
    invoke-virtual {p0, p1}, Lit/sephiroth/android/library/widget/AbsHListView;->generateLayoutParams(Landroid/util/AttributeSet;)Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;

    move-result-object v0

    return-object v0
.end method

.method protected generateLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Landroid/view/ViewGroup$LayoutParams;
    .locals 1
    .param p1, "p"    # Landroid/view/ViewGroup$LayoutParams;

    .prologue
    .line 5226
    new-instance v0, Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;

    invoke-direct {v0, p1}, Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;-><init>(Landroid/view/ViewGroup$LayoutParams;)V

    return-object v0
.end method

.method public generateLayoutParams(Landroid/util/AttributeSet;)Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;
    .locals 2
    .param p1, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 5231
    new-instance v0, Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1, p1}, Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    return-object v0
.end method

.method public getCacheColorHint()I
    .locals 1
    .annotation runtime Landroid/view/ViewDebug$ExportedProperty;
        category = "drawing"
    .end annotation

    .prologue
    .line 5296
    iget v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCacheColorHint:I

    return v0
.end method

.method public getCheckedItemCount()I
    .locals 1

    .prologue
    .line 753
    iget v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckedItemCount:I

    return v0
.end method

.method public getCheckedItemIds()[J
    .locals 6

    .prologue
    .line 810
    iget v4, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mChoiceMode:I

    if-eqz v4, :cond_0

    iget-object v4, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckedIdStates:Landroid/support/v4/util/LongSparseArray;

    if-eqz v4, :cond_0

    iget-object v4, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mAdapter:Landroid/widget/ListAdapter;

    if-nez v4, :cond_2

    .line 811
    :cond_0
    const/4 v4, 0x0

    new-array v3, v4, [J

    .line 822
    :cond_1
    return-object v3

    .line 814
    :cond_2
    iget-object v2, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckedIdStates:Landroid/support/v4/util/LongSparseArray;

    .line 815
    .local v2, "idStates":Landroid/support/v4/util/LongSparseArray;, "Landroid/support/v4/util/LongSparseArray<Ljava/lang/Integer;>;"
    invoke-virtual {v2}, Landroid/support/v4/util/LongSparseArray;->size()I

    move-result v0

    .line 816
    .local v0, "count":I
    new-array v3, v0, [J

    .line 818
    .local v3, "ids":[J
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v0, :cond_1

    .line 819
    invoke-virtual {v2, v1}, Landroid/support/v4/util/LongSparseArray;->keyAt(I)J

    move-result-wide v4

    aput-wide v4, v3, v1

    .line 818
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method

.method public getCheckedItemPosition()I
    .locals 2

    .prologue
    const/4 v1, 0x1

    .line 782
    iget v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mChoiceMode:I

    if-ne v0, v1, :cond_0

    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckStates:Landroid/support/v4/util/SparseArrayCompat;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckStates:Landroid/support/v4/util/SparseArrayCompat;

    invoke-virtual {v0}, Landroid/support/v4/util/SparseArrayCompat;->size()I

    move-result v0

    if-ne v0, v1, :cond_0

    .line 783
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckStates:Landroid/support/v4/util/SparseArrayCompat;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v4/util/SparseArrayCompat;->keyAt(I)I

    move-result v0

    .line 786
    :goto_0
    return v0

    :cond_0
    const/4 v0, -0x1

    goto :goto_0
.end method

.method public getCheckedItemPositions()Landroid/support/v4/util/SparseArrayCompat;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Landroid/support/v4/util/SparseArrayCompat",
            "<",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation

    .prologue
    .line 797
    iget v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mChoiceMode:I

    if-eqz v0, :cond_0

    .line 798
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckStates:Landroid/support/v4/util/SparseArrayCompat;

    .line 800
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getChoiceMode()I
    .locals 1

    .prologue
    .line 1004
    iget v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mChoiceMode:I

    return v0
.end method

.method protected getContextMenuInfo()Landroid/view/ContextMenu$ContextMenuInfo;
    .locals 1

    .prologue
    .line 2598
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mContextMenuInfo:Landroid/view/ContextMenu$ContextMenuInfo;

    return-object v0
.end method

.method public getFocusedRect(Landroid/graphics/Rect;)V
    .locals 2
    .param p1, "r"    # Landroid/graphics/Rect;

    .prologue
    .line 1243
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getSelectedView()Landroid/view/View;

    move-result-object v0

    .line 1244
    .local v0, "view":Landroid/view/View;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v1

    if-ne v1, p0, :cond_0

    .line 1247
    invoke-virtual {v0, p1}, Landroid/view/View;->getFocusedRect(Landroid/graphics/Rect;)V

    .line 1248
    invoke-virtual {p0, v0, p1}, Lit/sephiroth/android/library/widget/AbsHListView;->offsetDescendantRectToMyCoords(Landroid/view/View;Landroid/graphics/Rect;)V

    .line 1253
    :goto_0
    return-void

    .line 1251
    :cond_0
    invoke-super {p0, p1}, Lit/sephiroth/android/library/widget/AdapterView;->getFocusedRect(Landroid/graphics/Rect;)V

    goto :goto_0
.end method

.method protected getFooterViewsCount()I
    .locals 1

    .prologue
    .line 4746
    const/4 v0, 0x0

    return v0
.end method

.method protected getHeaderViewsCount()I
    .locals 1

    .prologue
    .line 4736
    const/4 v0, 0x0

    return v0
.end method

.method protected getHorizontalScrollFactor()F
    .locals 5

    .prologue
    .line 3424
    iget v2, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mHorizontalScrollFactor:F

    const/4 v3, 0x0

    cmpl-float v2, v2, v3

    if-nez v2, :cond_0

    .line 3426
    new-instance v0, Landroid/util/TypedValue;

    invoke-direct {v0}, Landroid/util/TypedValue;-><init>()V

    .line 3427
    .local v0, "outValue":Landroid/util/TypedValue;
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getTheme()Landroid/content/res/Resources$Theme;

    move-result-object v2

    sget v3, Lit/sephiroth/android/library/R$attr;->hlv_listPreferredItemWidth:I

    const/4 v4, 0x1

    invoke-virtual {v2, v3, v0, v4}, Landroid/content/res/Resources$Theme;->resolveAttribute(ILandroid/util/TypedValue;Z)Z

    move-result v1

    .line 3429
    .local v1, "success":Z
    if-eqz v1, :cond_1

    .line 3430
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/util/TypedValue;->getDimension(Landroid/util/DisplayMetrics;)F

    move-result v2

    iput v2, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mHorizontalScrollFactor:F

    .line 3436
    .end local v0    # "outValue":Landroid/util/TypedValue;
    .end local v1    # "success":Z
    :cond_0
    iget v2, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mHorizontalScrollFactor:F

    return v2

    .line 3433
    .restart local v0    # "outValue":Landroid/util/TypedValue;
    .restart local v1    # "success":Z
    :cond_1
    new-instance v2, Ljava/lang/IllegalStateException;

    const-string v3, "Expected theme to define hlv_listPreferredItemWidth."

    invoke-direct {v2, v3}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v2
.end method

.method protected getHorizontalScrollbarHeight()I
    .locals 1

    .prologue
    .line 1081
    invoke-super {p0}, Lit/sephiroth/android/library/widget/AdapterView;->getHorizontalScrollbarHeight()I

    move-result v0

    return v0
.end method

.method protected getLeftFadingEdgeStrength()F
    .locals 5

    .prologue
    .line 1721
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildCount()I

    move-result v0

    .line 1722
    .local v0, "count":I
    invoke-super {p0}, Lit/sephiroth/android/library/widget/AdapterView;->getLeftFadingEdgeStrength()F

    move-result v1

    .line 1723
    .local v1, "fadeEdge":F
    if-nez v0, :cond_1

    .line 1732
    .end local v1    # "fadeEdge":F
    :cond_0
    :goto_0
    return v1

    .line 1726
    .restart local v1    # "fadeEdge":F
    :cond_1
    iget v4, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mFirstPosition:I

    if-lez v4, :cond_2

    .line 1727
    const/high16 v1, 0x3f800000    # 1.0f

    goto :goto_0

    .line 1730
    :cond_2
    const/4 v4, 0x0

    invoke-virtual {p0, v4}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildAt(I)Landroid/view/View;

    move-result-object v4

    invoke-virtual {v4}, Landroid/view/View;->getLeft()I

    move-result v3

    .line 1731
    .local v3, "left":I
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getHorizontalFadingEdgeLength()I

    move-result v4

    int-to-float v2, v4

    .line 1732
    .local v2, "fadeLength":F
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getPaddingLeft()I

    move-result v4

    if-ge v3, v4, :cond_0

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getPaddingLeft()I

    move-result v4

    sub-int v4, v3, v4

    neg-int v4, v4

    int-to-float v4, v4

    div-float v1, v4, v2

    goto :goto_0
.end method

.method public getListPaddingBottom()I
    .locals 1

    .prologue
    .line 1878
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mListPadding:Landroid/graphics/Rect;

    iget v0, v0, Landroid/graphics/Rect;->bottom:I

    return v0
.end method

.method public getListPaddingLeft()I
    .locals 1

    .prologue
    .line 1890
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mListPadding:Landroid/graphics/Rect;

    iget v0, v0, Landroid/graphics/Rect;->left:I

    return v0
.end method

.method public getListPaddingRight()I
    .locals 1

    .prologue
    .line 1902
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mListPadding:Landroid/graphics/Rect;

    iget v0, v0, Landroid/graphics/Rect;->right:I

    return v0
.end method

.method public getListPaddingTop()I
    .locals 1

    .prologue
    .line 1866
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mListPadding:Landroid/graphics/Rect;

    iget v0, v0, Landroid/graphics/Rect;->top:I

    return v0
.end method

.method protected getRightFadingEdgeStrength()F
    .locals 7

    .prologue
    .line 1738
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildCount()I

    move-result v0

    .line 1739
    .local v0, "count":I
    invoke-super {p0}, Lit/sephiroth/android/library/widget/AdapterView;->getRightFadingEdgeStrength()F

    move-result v1

    .line 1740
    .local v1, "fadeEdge":F
    if-nez v0, :cond_1

    .line 1750
    .end local v1    # "fadeEdge":F
    :cond_0
    :goto_0
    return v1

    .line 1743
    .restart local v1    # "fadeEdge":F
    :cond_1
    iget v5, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mFirstPosition:I

    add-int/2addr v5, v0

    add-int/lit8 v5, v5, -0x1

    iget v6, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mItemCount:I

    add-int/lit8 v6, v6, -0x1

    if-ge v5, v6, :cond_2

    .line 1744
    const/high16 v1, 0x3f800000    # 1.0f

    goto :goto_0

    .line 1747
    :cond_2
    add-int/lit8 v5, v0, -0x1

    invoke-virtual {p0, v5}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildAt(I)Landroid/view/View;

    move-result-object v5

    invoke-virtual {v5}, Landroid/view/View;->getRight()I

    move-result v3

    .line 1748
    .local v3, "right":I
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getWidth()I

    move-result v4

    .line 1749
    .local v4, "width":I
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getHorizontalFadingEdgeLength()I

    move-result v5

    int-to-float v2, v5

    .line 1750
    .local v2, "fadeLength":F
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getPaddingRight()I

    move-result v5

    sub-int v5, v4, v5

    if-le v3, v5, :cond_0

    sub-int v5, v3, v4

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getPaddingRight()I

    move-result v6

    add-int/2addr v5, v6

    int-to-float v5, v5

    div-float v1, v5, v2

    goto :goto_0
.end method

.method public getSelectedView()Landroid/view/View;
    .locals 2
    .annotation runtime Landroid/view/ViewDebug$ExportedProperty;
    .end annotation

    .prologue
    .line 1850
    iget v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mItemCount:I

    if-lez v0, :cond_0

    iget v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectedPosition:I

    if-ltz v0, :cond_0

    .line 1851
    iget v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectedPosition:I

    iget v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mFirstPosition:I

    sub-int/2addr v0, v1

    invoke-virtual {p0, v0}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 1853
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getSelector()Landroid/graphics/drawable/Drawable;
    .locals 1

    .prologue
    .line 2237
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelector:Landroid/graphics/drawable/Drawable;

    return-object v0
.end method

.method public getSolidColor()I
    .locals 1

    .prologue
    .line 5264
    iget v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCacheColorHint:I

    return v0
.end method

.method public getTranscriptMode()I
    .locals 1

    .prologue
    .line 5259
    iget v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mTranscriptMode:I

    return v0
.end method

.method protected handleDataChanged()V
    .locals 15

    .prologue
    const/4 v14, 0x5

    const/4 v13, -0x1

    const/4 v8, 0x3

    const/4 v9, 0x1

    const/4 v12, 0x0

    .line 5002
    iget v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mItemCount:I

    .line 5003
    .local v1, "count":I
    iget v3, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mLastHandledItemCount:I

    .line 5004
    .local v3, "lastHandledItemCount":I
    iget v10, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mItemCount:I

    iput v10, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mLastHandledItemCount:I

    .line 5006
    iget v10, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mChoiceMode:I

    if-eqz v10, :cond_0

    iget-object v10, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mAdapter:Landroid/widget/ListAdapter;

    if-eqz v10, :cond_0

    iget-object v10, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v10}, Landroid/widget/ListAdapter;->hasStableIds()Z

    move-result v10

    if-eqz v10, :cond_0

    .line 5007
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->confirmCheckedPositionsById()V

    .line 5011
    :cond_0
    iget-object v10, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mRecycler:Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;

    invoke-virtual {v10}, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->clearTransientStateViews()V

    .line 5013
    if-lez v1, :cond_e

    .line 5018
    iget-boolean v10, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mNeedSync:Z

    if-eqz v10, :cond_7

    .line 5020
    iput-boolean v12, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mNeedSync:Z

    .line 5021
    const/4 v10, 0x0

    iput-object v10, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mPendingSync:Lit/sephiroth/android/library/widget/AbsHListView$SavedState;

    .line 5023
    iget v10, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mTranscriptMode:I

    const/4 v11, 0x2

    if-ne v10, v11, :cond_2

    .line 5024
    iput v8, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mLayoutMode:I

    .line 5140
    :cond_1
    :goto_0
    return-void

    .line 5026
    :cond_2
    iget v10, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mTranscriptMode:I

    if-ne v10, v9, :cond_6

    .line 5027
    iget-boolean v10, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mForceTranscriptScroll:Z

    if-eqz v10, :cond_3

    .line 5028
    iput-boolean v12, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mForceTranscriptScroll:Z

    .line 5029
    iput v8, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mLayoutMode:I

    goto :goto_0

    .line 5032
    :cond_3
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildCount()I

    move-result v0

    .line 5033
    .local v0, "childCount":I
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getWidth()I

    move-result v10

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getPaddingRight()I

    move-result v11

    sub-int v5, v10, v11

    .line 5034
    .local v5, "listRight":I
    add-int/lit8 v10, v0, -0x1

    invoke-virtual {p0, v10}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    .line 5035
    .local v2, "lastChild":Landroid/view/View;
    if-eqz v2, :cond_4

    invoke-virtual {v2}, Landroid/view/View;->getBottom()I

    move-result v4

    .line 5036
    .local v4, "lastRight":I
    :goto_1
    iget v10, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mFirstPosition:I

    add-int/2addr v10, v0

    if-lt v10, v3, :cond_5

    if-gt v4, v5, :cond_5

    .line 5038
    iput v8, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mLayoutMode:I

    goto :goto_0

    .end local v4    # "lastRight":I
    :cond_4
    move v4, v5

    .line 5035
    goto :goto_1

    .line 5043
    .restart local v4    # "lastRight":I
    :cond_5
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->awakenScrollBars()Z

    .line 5046
    .end local v0    # "childCount":I
    .end local v2    # "lastChild":Landroid/view/View;
    .end local v4    # "lastRight":I
    .end local v5    # "listRight":I
    :cond_6
    iget v10, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSyncMode:I

    packed-switch v10, :pswitch_data_0

    .line 5094
    :cond_7
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->isInTouchMode()Z

    move-result v10

    if-nez v10, :cond_d

    .line 5096
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getSelectedItemPosition()I

    move-result v6

    .line 5099
    .local v6, "newPos":I
    if-lt v6, v1, :cond_8

    .line 5100
    add-int/lit8 v6, v1, -0x1

    .line 5102
    :cond_8
    if-gez v6, :cond_9

    .line 5103
    const/4 v6, 0x0

    .line 5107
    :cond_9
    invoke-virtual {p0, v6, v9}, Lit/sephiroth/android/library/widget/AbsHListView;->lookForSelectablePosition(IZ)I

    move-result v7

    .line 5109
    .local v7, "selectablePos":I
    if-ltz v7, :cond_c

    .line 5110
    invoke-virtual {p0, v7}, Lit/sephiroth/android/library/widget/AbsHListView;->setNextSelectedPositionInt(I)V

    goto :goto_0

    .line 5048
    .end local v6    # "newPos":I
    .end local v7    # "selectablePos":I
    :pswitch_0
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->isInTouchMode()Z

    move-result v10

    if-eqz v10, :cond_a

    .line 5053
    iput v14, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mLayoutMode:I

    .line 5054
    iget v8, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSyncPosition:I

    invoke-static {v12, v8}, Ljava/lang/Math;->max(II)I

    move-result v8

    add-int/lit8 v9, v1, -0x1

    invoke-static {v8, v9}, Ljava/lang/Math;->min(II)I

    move-result v8

    iput v8, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSyncPosition:I

    goto :goto_0

    .line 5060
    :cond_a
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->findSyncPosition()I

    move-result v6

    .line 5061
    .restart local v6    # "newPos":I
    if-ltz v6, :cond_7

    .line 5063
    invoke-virtual {p0, v6, v9}, Lit/sephiroth/android/library/widget/AbsHListView;->lookForSelectablePosition(IZ)I

    move-result v7

    .line 5064
    .restart local v7    # "selectablePos":I
    if-ne v7, v6, :cond_7

    .line 5066
    iput v6, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSyncPosition:I

    .line 5068
    iget-wide v8, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSyncWidth:J

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getWidth()I

    move-result v10

    int-to-long v10, v10

    cmp-long v8, v8, v10

    if-nez v8, :cond_b

    .line 5071
    iput v14, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mLayoutMode:I

    .line 5079
    :goto_2
    invoke-virtual {p0, v6}, Lit/sephiroth/android/library/widget/AbsHListView;->setNextSelectedPositionInt(I)V

    goto/16 :goto_0

    .line 5075
    :cond_b
    const/4 v8, 0x2

    iput v8, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mLayoutMode:I

    goto :goto_2

    .line 5087
    .end local v6    # "newPos":I
    .end local v7    # "selectablePos":I
    :pswitch_1
    iput v14, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mLayoutMode:I

    .line 5088
    iget v8, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSyncPosition:I

    invoke-static {v12, v8}, Ljava/lang/Math;->max(II)I

    move-result v8

    add-int/lit8 v9, v1, -0x1

    invoke-static {v8, v9}, Ljava/lang/Math;->min(II)I

    move-result v8

    iput v8, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSyncPosition:I

    goto/16 :goto_0

    .line 5114
    .restart local v6    # "newPos":I
    .restart local v7    # "selectablePos":I
    :cond_c
    invoke-virtual {p0, v6, v12}, Lit/sephiroth/android/library/widget/AbsHListView;->lookForSelectablePosition(IZ)I

    move-result v7

    .line 5115
    if-ltz v7, :cond_e

    .line 5116
    invoke-virtual {p0, v7}, Lit/sephiroth/android/library/widget/AbsHListView;->setNextSelectedPositionInt(I)V

    goto/16 :goto_0

    .line 5123
    .end local v6    # "newPos":I
    .end local v7    # "selectablePos":I
    :cond_d
    iget v10, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mResurrectToPosition:I

    if-gez v10, :cond_1

    .line 5131
    :cond_e
    iget-boolean v10, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mStackFromRight:Z

    if-eqz v10, :cond_f

    :goto_3
    iput v8, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mLayoutMode:I

    .line 5132
    iput v13, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectedPosition:I

    .line 5133
    const-wide/high16 v8, -0x8000000000000000L

    iput-wide v8, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectedColId:J

    .line 5134
    iput v13, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mNextSelectedPosition:I

    .line 5135
    const-wide/high16 v8, -0x8000000000000000L

    iput-wide v8, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mNextSelectedColId:J

    .line 5136
    iput-boolean v12, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mNeedSync:Z

    .line 5137
    const/4 v8, 0x0

    iput-object v8, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mPendingSync:Lit/sephiroth/android/library/widget/AbsHListView$SavedState;

    .line 5138
    iput v13, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectorPosition:I

    .line 5139
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->checkSelectionChanged()V

    goto/16 :goto_0

    :cond_f
    move v8, v9

    .line 5131
    goto :goto_3

    .line 5046
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method protected hideSelector()V
    .locals 3

    .prologue
    const/4 v2, -0x1

    .line 4759
    iget v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectedPosition:I

    if-eq v0, v2, :cond_2

    .line 4760
    iget v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mLayoutMode:I

    const/4 v1, 0x4

    if-eq v0, v1, :cond_0

    .line 4761
    iget v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectedPosition:I

    iput v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mResurrectToPosition:I

    .line 4763
    :cond_0
    iget v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mNextSelectedPosition:I

    if-ltz v0, :cond_1

    iget v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mNextSelectedPosition:I

    iget v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectedPosition:I

    if-eq v0, v1, :cond_1

    .line 4764
    iget v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mNextSelectedPosition:I

    iput v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mResurrectToPosition:I

    .line 4766
    :cond_1
    invoke-virtual {p0, v2}, Lit/sephiroth/android/library/widget/AbsHListView;->setSelectedPositionInt(I)V

    .line 4767
    invoke-virtual {p0, v2}, Lit/sephiroth/android/library/widget/AbsHListView;->setNextSelectedPositionInt(I)V

    .line 4768
    const/4 v0, 0x0

    iput v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectedLeft:I

    .line 4770
    :cond_2
    return-void
.end method

.method protected invalidateParentIfNeeded()V
    .locals 1
    .annotation build Landroid/annotation/TargetApi;
        value = 0xb
    .end annotation

    .prologue
    .line 2959
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mViewHelper:Lit/sephiroth/android/library/util/ViewHelperFactory$ViewHelper;

    invoke-virtual {v0}, Lit/sephiroth/android/library/util/ViewHelperFactory$ViewHelper;->isHardwareAccelerated()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    instance-of v0, v0, Landroid/view/View;

    if-eqz v0, :cond_0

    .line 2960
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->invalidate()V

    .line 2962
    :cond_0
    return-void
.end method

.method protected invokeOnItemScrollListener()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 1131
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mOnScrollListener:Lit/sephiroth/android/library/widget/AbsHListView$OnScrollListener;

    if-eqz v0, :cond_0

    .line 1132
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mOnScrollListener:Lit/sephiroth/android/library/widget/AbsHListView$OnScrollListener;

    iget v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mFirstPosition:I

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildCount()I

    move-result v2

    iget v3, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mItemCount:I

    invoke-interface {v0, p0, v1, v2, v3}, Lit/sephiroth/android/library/widget/AbsHListView$OnScrollListener;->onScroll(Lit/sephiroth/android/library/widget/AbsHListView;III)V

    .line 1134
    :cond_0
    invoke-virtual {p0, v4, v4, v4, v4}, Lit/sephiroth/android/library/widget/AbsHListView;->onScrollChanged(IIII)V

    .line 1135
    return-void
.end method

.method public isItemChecked(I)Z
    .locals 2
    .param p1, "position"    # I

    .prologue
    const/4 v0, 0x0

    .line 767
    iget v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mChoiceMode:I

    if-eqz v1, :cond_0

    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckStates:Landroid/support/v4/util/SparseArrayCompat;

    if-eqz v1, :cond_0

    .line 768
    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckStates:Landroid/support/v4/util/SparseArrayCompat;

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v1, p1, v0}, Landroid/support/v4/util/SparseArrayCompat;->get(ILjava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    .line 771
    :cond_0
    return v0
.end method

.method public jumpDrawablesToCurrentState()V
    .locals 1
    .annotation build Landroid/annotation/TargetApi;
        value = 0xb
    .end annotation

    .prologue
    .line 2347
    invoke-super {p0}, Lit/sephiroth/android/library/widget/AdapterView;->jumpDrawablesToCurrentState()V

    .line 2348
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelector:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelector:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->jumpToCurrentState()V

    .line 2349
    :cond_0
    return-void
.end method

.method protected keyPressed()V
    .locals 8

    .prologue
    const/4 v7, 0x1

    .line 2244
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->isEnabled()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->isClickable()Z

    move-result v5

    if-nez v5, :cond_1

    .line 2279
    :cond_0
    :goto_0
    return-void

    .line 2248
    :cond_1
    iget-object v2, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelector:Landroid/graphics/drawable/Drawable;

    .line 2249
    .local v2, "selector":Landroid/graphics/drawable/Drawable;
    iget-object v3, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectorRect:Landroid/graphics/Rect;

    .line 2250
    .local v3, "selectorRect":Landroid/graphics/Rect;
    if-eqz v2, :cond_0

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->isFocused()Z

    move-result v5

    if-nez v5, :cond_2

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->touchModeDrawsInPressedState()Z

    move-result v5

    if-eqz v5, :cond_0

    :cond_2
    invoke-virtual {v3}, Landroid/graphics/Rect;->isEmpty()Z

    move-result v5

    if-nez v5, :cond_0

    .line 2253
    iget v5, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectedPosition:I

    iget v6, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mFirstPosition:I

    sub-int/2addr v5, v6

    invoke-virtual {p0, v5}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildAt(I)Landroid/view/View;

    move-result-object v4

    .line 2255
    .local v4, "v":Landroid/view/View;
    if-eqz v4, :cond_3

    .line 2256
    invoke-virtual {v4}, Landroid/view/View;->hasFocusable()Z

    move-result v5

    if-nez v5, :cond_0

    .line 2257
    invoke-virtual {v4, v7}, Landroid/view/View;->setPressed(Z)V

    .line 2259
    :cond_3
    invoke-virtual {p0, v7}, Lit/sephiroth/android/library/widget/AbsHListView;->setPressed(Z)V

    .line 2261
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->isLongClickable()Z

    move-result v1

    .line 2262
    .local v1, "longClickable":Z
    invoke-virtual {v2}, Landroid/graphics/drawable/Drawable;->getCurrent()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 2263
    .local v0, "d":Landroid/graphics/drawable/Drawable;
    if-eqz v0, :cond_4

    instance-of v5, v0, Landroid/graphics/drawable/TransitionDrawable;

    if-eqz v5, :cond_4

    .line 2264
    if-eqz v1, :cond_6

    .line 2265
    check-cast v0, Landroid/graphics/drawable/TransitionDrawable;

    .end local v0    # "d":Landroid/graphics/drawable/Drawable;
    invoke-static {}, Landroid/view/ViewConfiguration;->getLongPressTimeout()I

    move-result v5

    invoke-virtual {v0, v5}, Landroid/graphics/drawable/TransitionDrawable;->startTransition(I)V

    .line 2271
    :cond_4
    :goto_1
    if-eqz v1, :cond_0

    iget-boolean v5, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mDataChanged:Z

    if-nez v5, :cond_0

    .line 2272
    iget-object v5, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mPendingCheckForKeyLongPress:Lit/sephiroth/android/library/widget/AbsHListView$CheckForKeyLongPress;

    if-nez v5, :cond_5

    .line 2273
    new-instance v5, Lit/sephiroth/android/library/widget/AbsHListView$CheckForKeyLongPress;

    const/4 v6, 0x0

    invoke-direct {v5, p0, v6}, Lit/sephiroth/android/library/widget/AbsHListView$CheckForKeyLongPress;-><init>(Lit/sephiroth/android/library/widget/AbsHListView;Lit/sephiroth/android/library/widget/AbsHListView$1;)V

    iput-object v5, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mPendingCheckForKeyLongPress:Lit/sephiroth/android/library/widget/AbsHListView$CheckForKeyLongPress;

    .line 2275
    :cond_5
    iget-object v5, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mPendingCheckForKeyLongPress:Lit/sephiroth/android/library/widget/AbsHListView$CheckForKeyLongPress;

    invoke-virtual {v5}, Lit/sephiroth/android/library/widget/AbsHListView$CheckForKeyLongPress;->rememberWindowAttachCount()V

    .line 2276
    iget-object v5, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mPendingCheckForKeyLongPress:Lit/sephiroth/android/library/widget/AbsHListView$CheckForKeyLongPress;

    invoke-static {}, Landroid/view/ViewConfiguration;->getLongPressTimeout()I

    move-result v6

    int-to-long v6, v6

    invoke-virtual {p0, v5, v6, v7}, Lit/sephiroth/android/library/widget/AbsHListView;->postDelayed(Ljava/lang/Runnable;J)Z

    goto :goto_0

    .line 2268
    .restart local v0    # "d":Landroid/graphics/drawable/Drawable;
    :cond_6
    check-cast v0, Landroid/graphics/drawable/TransitionDrawable;

    .end local v0    # "d":Landroid/graphics/drawable/Drawable;
    invoke-virtual {v0}, Landroid/graphics/drawable/TransitionDrawable;->resetTransition()V

    goto :goto_1
.end method

.method protected layoutChildren()V
    .locals 0

    .prologue
    .line 1811
    return-void
.end method

.method protected obtainView(I[Z)Landroid/view/View;
    .locals 8
    .param p1, "position"    # I
    .param p2, "isScrap"    # [Z
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi"
        }
    .end annotation

    .prologue
    const/16 v7, 0x10

    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 1920
    aput-boolean v5, p2, v5

    .line 1923
    iget-object v4, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mRecycler:Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;

    invoke-virtual {v4, p1}, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->getTransientStateView(I)Landroid/view/View;

    move-result-object v2

    .line 1924
    .local v2, "scrapView":Landroid/view/View;
    if-eqz v2, :cond_1

    move-object v0, v2

    .line 1988
    :cond_0
    :goto_0
    return-object v0

    .line 1928
    :cond_1
    iget-object v4, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mRecycler:Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;

    invoke-virtual {v4, p1}, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->getScrapView(I)Landroid/view/View;

    move-result-object v2

    .line 1931
    if-eqz v2, :cond_6

    .line 1932
    iget-object v4, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v4, p1, v2, p0}, Landroid/widget/ListAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 1934
    .local v0, "child":Landroid/view/View;
    sget v4, Landroid/os/Build$VERSION;->SDK_INT:I

    if-lt v4, v7, :cond_2

    .line 1935
    invoke-virtual {v0}, Landroid/view/View;->getImportantForAccessibility()I

    move-result v4

    if-nez v4, :cond_2

    .line 1936
    invoke-virtual {v0, v6}, Landroid/view/View;->setImportantForAccessibility(I)V

    .line 1940
    :cond_2
    if-eq v0, v2, :cond_5

    .line 1941
    iget-object v4, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mRecycler:Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;

    invoke-virtual {v4, v2, p1}, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->addScrapView(Landroid/view/View;I)V

    .line 1942
    iget v4, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCacheColorHint:I

    if-eqz v4, :cond_3

    .line 1943
    iget v4, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCacheColorHint:I

    invoke-virtual {v0, v4}, Landroid/view/View;->setDrawingCacheBackgroundColor(I)V

    .line 1963
    :cond_3
    :goto_1
    iget-boolean v4, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mAdapterHasStableIds:Z

    if-eqz v4, :cond_4

    .line 1964
    invoke-virtual {v0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v3

    .line 1966
    .local v3, "vlp":Landroid/view/ViewGroup$LayoutParams;
    if-nez v3, :cond_8

    .line 1967
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->generateDefaultLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    check-cast v1, Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;

    .line 1973
    .local v1, "lp":Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;
    :goto_2
    iget-object v4, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v4, p1}, Landroid/widget/ListAdapter;->getItemId(I)J

    move-result-wide v4

    iput-wide v4, v1, Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;->itemId:J

    .line 1974
    invoke-virtual {v0, v1}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 1977
    .end local v1    # "lp":Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;
    .end local v3    # "vlp":Landroid/view/ViewGroup$LayoutParams;
    :cond_4
    iget-object v4, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mAccessibilityManager:Landroid/view/accessibility/AccessibilityManager;

    invoke-virtual {v4}, Landroid/view/accessibility/AccessibilityManager;->isEnabled()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 1978
    iget-object v4, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mAccessibilityDelegate:Lit/sephiroth/android/library/widget/AbsHListView$ListItemAccessibilityDelegate;

    if-nez v4, :cond_0

    .line 1979
    new-instance v4, Lit/sephiroth/android/library/widget/AbsHListView$ListItemAccessibilityDelegate;

    invoke-direct {v4, p0}, Lit/sephiroth/android/library/widget/AbsHListView$ListItemAccessibilityDelegate;-><init>(Lit/sephiroth/android/library/widget/AbsHListView;)V

    iput-object v4, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mAccessibilityDelegate:Lit/sephiroth/android/library/widget/AbsHListView$ListItemAccessibilityDelegate;

    goto :goto_0

    .line 1946
    :cond_5
    aput-boolean v6, p2, v5

    .line 1947
    invoke-virtual {v0}, Landroid/view/View;->onFinishTemporaryDetach()V

    goto :goto_1

    .line 1950
    .end local v0    # "child":Landroid/view/View;
    :cond_6
    iget-object v4, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mAdapter:Landroid/widget/ListAdapter;

    const/4 v5, 0x0

    invoke-interface {v4, p1, v5, p0}, Landroid/widget/ListAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 1952
    .restart local v0    # "child":Landroid/view/View;
    sget v4, Landroid/os/Build$VERSION;->SDK_INT:I

    if-lt v4, v7, :cond_7

    .line 1953
    invoke-virtual {v0}, Landroid/view/View;->getImportantForAccessibility()I

    move-result v4

    if-nez v4, :cond_7

    .line 1954
    invoke-virtual {v0, v6}, Landroid/view/View;->setImportantForAccessibility(I)V

    .line 1958
    :cond_7
    iget v4, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCacheColorHint:I

    if-eqz v4, :cond_3

    .line 1959
    iget v4, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCacheColorHint:I

    invoke-virtual {v0, v4}, Landroid/view/View;->setDrawingCacheBackgroundColor(I)V

    goto :goto_1

    .line 1968
    .restart local v3    # "vlp":Landroid/view/ViewGroup$LayoutParams;
    :cond_8
    invoke-virtual {p0, v3}, Lit/sephiroth/android/library/widget/AbsHListView;->checkLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Z

    move-result v4

    if-nez v4, :cond_9

    .line 1969
    invoke-virtual {p0, v3}, Lit/sephiroth/android/library/widget/AbsHListView;->generateLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    check-cast v1, Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;

    .restart local v1    # "lp":Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;
    goto :goto_2

    .end local v1    # "lp":Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;
    :cond_9
    move-object v1, v3

    .line 1971
    check-cast v1, Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;

    .restart local v1    # "lp":Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;
    goto :goto_2
.end method

.method public offsetChildrenLeftAndRight(I)V
    .locals 3
    .param p1, "offset"    # I

    .prologue
    .line 4721
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildCount()I

    move-result v0

    .line 4723
    .local v0, "count":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v0, :cond_0

    .line 4724
    invoke-virtual {p0, v1}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    .line 4725
    .local v2, "v":Landroid/view/View;
    invoke-virtual {v2, p1}, Landroid/view/View;->offsetLeftAndRight(I)V

    .line 4723
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 4727
    .end local v2    # "v":Landroid/view/View;
    :cond_0
    return-void
.end method

.method protected onAttachedToWindow()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 2353
    invoke-super {p0}, Lit/sephiroth/android/library/widget/AdapterView;->onAttachedToWindow()V

    .line 2355
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v0

    .line 2356
    .local v0, "treeObserver":Landroid/view/ViewTreeObserver;
    invoke-virtual {v0, p0}, Landroid/view/ViewTreeObserver;->addOnTouchModeChangeListener(Landroid/view/ViewTreeObserver$OnTouchModeChangeListener;)V

    .line 2358
    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mAdapter:Landroid/widget/ListAdapter;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mDataSetObserver:Lit/sephiroth/android/library/widget/AbsHListView$AdapterDataSetObserver;

    if-nez v1, :cond_0

    .line 2359
    new-instance v1, Lit/sephiroth/android/library/widget/AbsHListView$AdapterDataSetObserver;

    invoke-direct {v1, p0}, Lit/sephiroth/android/library/widget/AbsHListView$AdapterDataSetObserver;-><init>(Lit/sephiroth/android/library/widget/AbsHListView;)V

    iput-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mDataSetObserver:Lit/sephiroth/android/library/widget/AbsHListView$AdapterDataSetObserver;

    .line 2360
    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mAdapter:Landroid/widget/ListAdapter;

    iget-object v2, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mDataSetObserver:Lit/sephiroth/android/library/widget/AbsHListView$AdapterDataSetObserver;

    invoke-interface {v1, v2}, Landroid/widget/ListAdapter;->registerDataSetObserver(Landroid/database/DataSetObserver;)V

    .line 2363
    iput-boolean v3, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mDataChanged:Z

    .line 2364
    iget v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mItemCount:I

    iput v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mOldItemCount:I

    .line 2365
    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v1}, Landroid/widget/ListAdapter;->getCount()I

    move-result v1

    iput v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mItemCount:I

    .line 2367
    :cond_0
    iput-boolean v3, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mIsAttached:Z

    .line 2368
    return-void
.end method

.method protected onCreateDrawableState(I)[I
    .locals 6
    .param p1, "extraSpace"    # I
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "Override"
        }
    .end annotation

    .prologue
    .line 2308
    iget-boolean v4, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mIsChildViewEnabled:Z

    if-eqz v4, :cond_1

    .line 2310
    invoke-super {p0, p1}, Lit/sephiroth/android/library/widget/AdapterView;->onCreateDrawableState(I)[I

    move-result-object v3

    .line 2336
    :cond_0
    :goto_0
    return-object v3

    .line 2316
    :cond_1
    sget-object v4, Lit/sephiroth/android/library/widget/AbsHListView;->ENABLED_STATE_SET:[I

    const/4 v5, 0x0

    aget v1, v4, v5

    .line 2321
    .local v1, "enabledState":I
    add-int/lit8 v4, p1, 0x1

    invoke-super {p0, v4}, Lit/sephiroth/android/library/widget/AdapterView;->onCreateDrawableState(I)[I

    move-result-object v3

    .line 2322
    .local v3, "state":[I
    const/4 v0, -0x1

    .line 2323
    .local v0, "enabledPos":I
    array-length v4, v3

    add-int/lit8 v2, v4, -0x1

    .local v2, "i":I
    :goto_1
    if-ltz v2, :cond_2

    .line 2324
    aget v4, v3, v2

    if-ne v4, v1, :cond_3

    .line 2325
    move v0, v2

    .line 2331
    :cond_2
    if-ltz v0, :cond_0

    .line 2332
    add-int/lit8 v4, v0, 0x1

    array-length v5, v3

    sub-int/2addr v5, v0

    add-int/lit8 v5, v5, -0x1

    invoke-static {v3, v4, v3, v0, v5}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    goto :goto_0

    .line 2323
    :cond_3
    add-int/lit8 v2, v2, -0x1

    goto :goto_1
.end method

.method public onCreateInputConnection(Landroid/view/inputmethod/EditorInfo;)Landroid/view/inputmethod/InputConnection;
    .locals 1
    .param p1, "outAttrs"    # Landroid/view/inputmethod/EditorInfo;

    .prologue
    .line 5207
    const/4 v0, 0x0

    return-object v0
.end method

.method protected onDetachedFromWindow()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 2372
    invoke-super {p0}, Lit/sephiroth/android/library/widget/AdapterView;->onDetachedFromWindow()V

    .line 2377
    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mRecycler:Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;

    invoke-virtual {v1}, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->clear()V

    .line 2379
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v0

    .line 2380
    .local v0, "treeObserver":Landroid/view/ViewTreeObserver;
    invoke-virtual {v0, p0}, Landroid/view/ViewTreeObserver;->removeOnTouchModeChangeListener(Landroid/view/ViewTreeObserver$OnTouchModeChangeListener;)V

    .line 2382
    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mAdapter:Landroid/widget/ListAdapter;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mDataSetObserver:Lit/sephiroth/android/library/widget/AbsHListView$AdapterDataSetObserver;

    if-eqz v1, :cond_0

    .line 2383
    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mAdapter:Landroid/widget/ListAdapter;

    iget-object v2, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mDataSetObserver:Lit/sephiroth/android/library/widget/AbsHListView$AdapterDataSetObserver;

    invoke-interface {v1, v2}, Landroid/widget/ListAdapter;->unregisterDataSetObserver(Landroid/database/DataSetObserver;)V

    .line 2384
    iput-object v3, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mDataSetObserver:Lit/sephiroth/android/library/widget/AbsHListView$AdapterDataSetObserver;

    .line 2387
    :cond_0
    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mFlingRunnable:Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;

    if-eqz v1, :cond_1

    .line 2388
    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mFlingRunnable:Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;

    invoke-virtual {p0, v1}, Lit/sephiroth/android/library/widget/AbsHListView;->removeCallbacks(Ljava/lang/Runnable;)Z

    .line 2391
    :cond_1
    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mPositionScroller:Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;

    if-eqz v1, :cond_2

    .line 2392
    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mPositionScroller:Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;

    invoke-virtual {v1}, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->stop()V

    .line 2395
    :cond_2
    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mClearScrollingCache:Ljava/lang/Runnable;

    if-eqz v1, :cond_3

    .line 2396
    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mClearScrollingCache:Ljava/lang/Runnable;

    invoke-virtual {p0, v1}, Lit/sephiroth/android/library/widget/AbsHListView;->removeCallbacks(Ljava/lang/Runnable;)Z

    .line 2399
    :cond_3
    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mPerformClick:Lit/sephiroth/android/library/widget/AbsHListView$PerformClick;

    if-eqz v1, :cond_4

    .line 2400
    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mPerformClick:Lit/sephiroth/android/library/widget/AbsHListView$PerformClick;

    invoke-virtual {p0, v1}, Lit/sephiroth/android/library/widget/AbsHListView;->removeCallbacks(Ljava/lang/Runnable;)Z

    .line 2403
    :cond_4
    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mTouchModeReset:Ljava/lang/Runnable;

    if-eqz v1, :cond_5

    .line 2404
    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mTouchModeReset:Ljava/lang/Runnable;

    invoke-virtual {p0, v1}, Lit/sephiroth/android/library/widget/AbsHListView;->removeCallbacks(Ljava/lang/Runnable;)Z

    .line 2405
    iput-object v3, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mTouchModeReset:Ljava/lang/Runnable;

    .line 2407
    :cond_5
    const/4 v1, 0x0

    iput-boolean v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mIsAttached:Z

    .line 2408
    return-void
.end method

.method protected onFocusChanged(ZILandroid/graphics/Rect;)V
    .locals 1
    .param p1, "gainFocus"    # Z
    .param p2, "direction"    # I
    .param p3, "previouslyFocusedRect"    # Landroid/graphics/Rect;

    .prologue
    .line 1606
    invoke-super {p0, p1, p2, p3}, Lit/sephiroth/android/library/widget/AdapterView;->onFocusChanged(ZILandroid/graphics/Rect;)V

    .line 1607
    if-eqz p1, :cond_1

    iget v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectedPosition:I

    if-gez v0, :cond_1

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->isInTouchMode()Z

    move-result v0

    if-nez v0, :cond_1

    .line 1608
    iget-boolean v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mIsAttached:Z

    if-nez v0, :cond_0

    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mAdapter:Landroid/widget/ListAdapter;

    if-eqz v0, :cond_0

    .line 1611
    const/4 v0, 0x1

    iput-boolean v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mDataChanged:Z

    .line 1612
    iget v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mItemCount:I

    iput v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mOldItemCount:I

    .line 1613
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v0}, Landroid/widget/ListAdapter;->getCount()I

    move-result v0

    iput v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mItemCount:I

    .line 1615
    :cond_0
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->resurrectSelection()Z

    .line 1617
    :cond_1
    return-void
.end method

.method public onGenericMotionEvent(Landroid/view/MotionEvent;)Z
    .locals 4
    .param p1, "event"    # Landroid/view/MotionEvent;
    .annotation build Landroid/annotation/TargetApi;
        value = 0xc
    .end annotation

    .prologue
    .line 3397
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getSource()I

    move-result v2

    and-int/lit8 v2, v2, 0x2

    if-eqz v2, :cond_0

    .line 3398
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v2

    packed-switch v2, :pswitch_data_0

    .line 3412
    :cond_0
    invoke-super {p0, p1}, Lit/sephiroth/android/library/widget/AdapterView;->onGenericMotionEvent(Landroid/view/MotionEvent;)Z

    move-result v2

    :goto_0
    return v2

    .line 3400
    :pswitch_0
    iget v2, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mTouchMode:I

    const/4 v3, -0x1

    if-ne v2, v3, :cond_0

    .line 3401
    const/16 v2, 0xa

    invoke-virtual {p1, v2}, Landroid/view/MotionEvent;->getAxisValue(I)F

    move-result v1

    .line 3402
    .local v1, "hscroll":F
    const/4 v2, 0x0

    cmpl-float v2, v1, v2

    if-eqz v2, :cond_0

    .line 3403
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getHorizontalScrollFactor()F

    move-result v2

    mul-float/2addr v2, v1

    float-to-int v0, v2

    .line 3404
    .local v0, "delta":I
    invoke-virtual {p0, v0, v0}, Lit/sephiroth/android/library/widget/AbsHListView;->trackMotionScroll(II)Z

    move-result v2

    if-nez v2, :cond_0

    .line 3405
    const/4 v2, 0x1

    goto :goto_0

    .line 3398
    :pswitch_data_0
    .packed-switch 0x8
        :pswitch_0
    .end packed-switch
.end method

.method public onInitializeAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)V
    .locals 1
    .param p1, "event"    # Landroid/view/accessibility/AccessibilityEvent;
    .annotation build Landroid/annotation/TargetApi;
        value = 0xe
    .end annotation

    .prologue
    .line 1159
    invoke-super {p0, p1}, Lit/sephiroth/android/library/widget/AdapterView;->onInitializeAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)V

    .line 1160
    const-class v0, Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/view/accessibility/AccessibilityEvent;->setClassName(Ljava/lang/CharSequence;)V

    .line 1161
    return-void
.end method

.method public onInitializeAccessibilityNodeInfo(Landroid/view/accessibility/AccessibilityNodeInfo;)V
    .locals 2
    .param p1, "info"    # Landroid/view/accessibility/AccessibilityNodeInfo;
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "Override"
        }
    .end annotation

    .annotation build Landroid/annotation/TargetApi;
        value = 0xe
    .end annotation

    .prologue
    .line 1167
    invoke-super {p0, p1}, Lit/sephiroth/android/library/widget/AdapterView;->onInitializeAccessibilityNodeInfo(Landroid/view/accessibility/AccessibilityNodeInfo;)V

    .line 1169
    const-class v0, Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/view/accessibility/AccessibilityNodeInfo;->setClassName(Ljava/lang/CharSequence;)V

    .line 1170
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->isEnabled()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1171
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getFirstVisiblePosition()I

    move-result v0

    if-lez v0, :cond_0

    .line 1172
    const/16 v0, 0x2000

    invoke-virtual {p1, v0}, Landroid/view/accessibility/AccessibilityNodeInfo;->addAction(I)V

    .line 1174
    :cond_0
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getLastVisiblePosition()I

    move-result v0

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getCount()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    if-ge v0, v1, :cond_1

    .line 1175
    const/16 v0, 0x1000

    invoke-virtual {p1, v0}, Landroid/view/accessibility/AccessibilityNodeInfo;->addAction(I)V

    .line 1178
    :cond_1
    return-void
.end method

.method public onInterceptTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 12
    .param p1, "ev"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v11, 0x4

    const/4 v8, 0x1

    const/4 v10, -0x1

    const/4 v7, 0x0

    .line 3529
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    .line 3532
    .local v0, "action":I
    iget-object v9, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mPositionScroller:Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;

    if-eqz v9, :cond_0

    .line 3533
    iget-object v9, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mPositionScroller:Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;

    invoke-virtual {v9}, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->stop()V

    .line 3536
    :cond_0
    iget-boolean v9, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mIsAttached:Z

    if-nez v9, :cond_2

    .line 3611
    :cond_1
    :goto_0
    return v7

    .line 3544
    :cond_2
    and-int/lit16 v9, v0, 0xff

    packed-switch v9, :pswitch_data_0

    :pswitch_0
    goto :goto_0

    .line 3546
    :pswitch_1
    iget v3, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mTouchMode:I

    .line 3547
    .local v3, "touchMode":I
    const/4 v9, 0x6

    if-eq v3, v9, :cond_3

    const/4 v9, 0x5

    if-ne v3, v9, :cond_4

    .line 3548
    :cond_3
    iput v7, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mMotionCorrection:I

    move v7, v8

    .line 3549
    goto :goto_0

    .line 3552
    :cond_4
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    float-to-int v5, v9

    .line 3553
    .local v5, "x":I
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    float-to-int v6, v9

    .line 3554
    .local v6, "y":I
    invoke-virtual {p1, v7}, Landroid/view/MotionEvent;->getPointerId(I)I

    move-result v9

    iput v9, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mActivePointerId:I

    .line 3556
    invoke-virtual {p0, v5}, Lit/sephiroth/android/library/widget/AbsHListView;->findMotionCol(I)I

    move-result v1

    .line 3557
    .local v1, "motionPosition":I
    if-eq v3, v11, :cond_5

    if-ltz v1, :cond_5

    .line 3560
    iget v9, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mFirstPosition:I

    sub-int v9, v1, v9

    invoke-virtual {p0, v9}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildAt(I)Landroid/view/View;

    move-result-object v4

    .line 3561
    .local v4, "v":Landroid/view/View;
    invoke-virtual {v4}, Landroid/view/View;->getLeft()I

    move-result v9

    iput v9, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mMotionViewOriginalLeft:I

    .line 3562
    iput v5, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mMotionX:I

    .line 3563
    iput v6, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mMotionY:I

    .line 3564
    iput v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mMotionPosition:I

    .line 3565
    iput v7, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mTouchMode:I

    .line 3566
    invoke-direct {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->clearScrollingCache()V

    .line 3568
    .end local v4    # "v":Landroid/view/View;
    :cond_5
    const/high16 v9, -0x80000000

    iput v9, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mLastX:I

    .line 3569
    invoke-direct {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->initOrResetVelocityTracker()V

    .line 3570
    iget-object v9, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mVelocityTracker:Landroid/view/VelocityTracker;

    invoke-virtual {v9, p1}, Landroid/view/VelocityTracker;->addMovement(Landroid/view/MotionEvent;)V

    .line 3571
    if-ne v3, v11, :cond_1

    move v7, v8

    .line 3572
    goto :goto_0

    .line 3578
    .end local v1    # "motionPosition":I
    .end local v3    # "touchMode":I
    .end local v5    # "x":I
    .end local v6    # "y":I
    :pswitch_2
    iget v9, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mTouchMode:I

    packed-switch v9, :pswitch_data_1

    goto :goto_0

    .line 3580
    :pswitch_3
    iget v9, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mActivePointerId:I

    invoke-virtual {p1, v9}, Landroid/view/MotionEvent;->findPointerIndex(I)I

    move-result v2

    .line 3581
    .local v2, "pointerIndex":I
    if-ne v2, v10, :cond_6

    .line 3582
    const/4 v2, 0x0

    .line 3583
    invoke-virtual {p1, v2}, Landroid/view/MotionEvent;->getPointerId(I)I

    move-result v9

    iput v9, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mActivePointerId:I

    .line 3585
    :cond_6
    invoke-virtual {p1, v2}, Landroid/view/MotionEvent;->getX(I)F

    move-result v9

    float-to-int v5, v9

    .line 3586
    .restart local v5    # "x":I
    invoke-direct {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->initVelocityTrackerIfNotExists()V

    .line 3587
    iget-object v9, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mVelocityTracker:Landroid/view/VelocityTracker;

    invoke-virtual {v9, p1}, Landroid/view/VelocityTracker;->addMovement(Landroid/view/MotionEvent;)V

    .line 3588
    invoke-direct {p0, v5}, Lit/sephiroth/android/library/widget/AbsHListView;->startScrollIfNeeded(I)Z

    move-result v9

    if-eqz v9, :cond_1

    move v7, v8

    .line 3589
    goto :goto_0

    .line 3598
    .end local v2    # "pointerIndex":I
    .end local v5    # "x":I
    :pswitch_4
    iput v10, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mTouchMode:I

    .line 3599
    iput v10, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mActivePointerId:I

    .line 3600
    invoke-direct {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->recycleVelocityTracker()V

    .line 3601
    invoke-virtual {p0, v7}, Lit/sephiroth/android/library/widget/AbsHListView;->reportScrollStateChange(I)V

    goto/16 :goto_0

    .line 3606
    :pswitch_5
    invoke-direct {p0, p1}, Lit/sephiroth/android/library/widget/AbsHListView;->onSecondaryPointerUp(Landroid/view/MotionEvent;)V

    goto/16 :goto_0

    .line 3544
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_4
        :pswitch_2
        :pswitch_4
        :pswitch_0
        :pswitch_0
        :pswitch_5
    .end packed-switch

    .line 3578
    :pswitch_data_1
    .packed-switch 0x0
        :pswitch_3
    .end packed-switch
.end method

.method public onKeyDown(ILandroid/view/KeyEvent;)Z
    .locals 1
    .param p1, "keyCode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;

    .prologue
    .line 2639
    const/4 v0, 0x0

    return v0
.end method

.method public onKeyUp(ILandroid/view/KeyEvent;)Z
    .locals 7
    .param p1, "keyCode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;

    .prologue
    const/4 v1, 0x1

    const/4 v6, 0x0

    .line 2644
    sparse-switch p1, :sswitch_data_0

    .line 2664
    :cond_0
    invoke-super {p0, p1, p2}, Lit/sephiroth/android/library/widget/AdapterView;->onKeyUp(ILandroid/view/KeyEvent;)Z

    move-result v1

    :cond_1
    :goto_0
    return v1

    .line 2647
    :sswitch_0
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->isEnabled()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 2650
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->isClickable()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->isPressed()Z

    move-result v2

    if-eqz v2, :cond_0

    iget v2, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectedPosition:I

    if-ltz v2, :cond_0

    iget-object v2, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mAdapter:Landroid/widget/ListAdapter;

    if-eqz v2, :cond_0

    iget v2, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectedPosition:I

    iget-object v3, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v3}, Landroid/widget/ListAdapter;->getCount()I

    move-result v3

    if-ge v2, v3, :cond_0

    .line 2654
    iget v2, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectedPosition:I

    iget v3, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mFirstPosition:I

    sub-int/2addr v2, v3

    invoke-virtual {p0, v2}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 2655
    .local v0, "view":Landroid/view/View;
    if-eqz v0, :cond_2

    .line 2656
    iget v2, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectedPosition:I

    iget-wide v4, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectedColId:J

    invoke-virtual {p0, v0, v2, v4, v5}, Lit/sephiroth/android/library/widget/AbsHListView;->performItemClick(Landroid/view/View;IJ)Z

    .line 2657
    invoke-virtual {v0, v6}, Landroid/view/View;->setPressed(Z)V

    .line 2659
    :cond_2
    invoke-virtual {p0, v6}, Lit/sephiroth/android/library/widget/AbsHListView;->setPressed(Z)V

    goto :goto_0

    .line 2644
    nop

    :sswitch_data_0
    .sparse-switch
        0x17 -> :sswitch_0
        0x42 -> :sswitch_0
    .end sparse-switch
.end method

.method protected onLayout(ZIIII)V
    .locals 3
    .param p1, "changed"    # Z
    .param p2, "l"    # I
    .param p3, "t"    # I
    .param p4, "r"    # I
    .param p5, "b"    # I

    .prologue
    .line 1781
    invoke-super/range {p0 .. p5}, Lit/sephiroth/android/library/widget/AdapterView;->onLayout(ZIIII)V

    .line 1782
    const/4 v2, 0x1

    iput-boolean v2, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mInLayout:Z

    .line 1783
    if-eqz p1, :cond_1

    .line 1784
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildCount()I

    move-result v0

    .line 1785
    .local v0, "childCount":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v0, :cond_0

    .line 1786
    invoke-virtual {p0, v1}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/View;->forceLayout()V

    .line 1785
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 1788
    :cond_0
    iget-object v2, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mRecycler:Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;

    invoke-virtual {v2}, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->markChildrenDirty()V

    .line 1791
    .end local v0    # "childCount":I
    .end local v1    # "i":I
    :cond_1
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->layoutChildren()V

    .line 1792
    const/4 v2, 0x0

    iput-boolean v2, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mInLayout:Z

    .line 1794
    sub-int v2, p4, p2

    div-int/lit8 v2, v2, 0x3

    iput v2, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mOverscrollMax:I

    .line 1795
    return-void
.end method

.method protected onMeasure(II)V
    .locals 8
    .param p1, "widthMeasureSpec"    # I
    .param p2, "heightMeasureSpec"    # I

    .prologue
    const/4 v5, 0x1

    .line 1757
    iget-object v6, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelector:Landroid/graphics/drawable/Drawable;

    if-nez v6, :cond_0

    .line 1758
    invoke-direct {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->useDefaultSelector()V

    .line 1760
    :cond_0
    iget-object v3, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mListPadding:Landroid/graphics/Rect;

    .line 1761
    .local v3, "listPadding":Landroid/graphics/Rect;
    iget v6, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectionLeftPadding:I

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getPaddingLeft()I

    move-result v7

    add-int/2addr v6, v7

    iput v6, v3, Landroid/graphics/Rect;->left:I

    .line 1762
    iget v6, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectionTopPadding:I

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getPaddingTop()I

    move-result v7

    add-int/2addr v6, v7

    iput v6, v3, Landroid/graphics/Rect;->top:I

    .line 1763
    iget v6, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectionRightPadding:I

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getPaddingRight()I

    move-result v7

    add-int/2addr v6, v7

    iput v6, v3, Landroid/graphics/Rect;->right:I

    .line 1764
    iget v6, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectionBottomPadding:I

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getPaddingBottom()I

    move-result v7

    add-int/2addr v6, v7

    iput v6, v3, Landroid/graphics/Rect;->bottom:I

    .line 1767
    iget v6, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mTranscriptMode:I

    if-ne v6, v5, :cond_1

    .line 1768
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildCount()I

    move-result v0

    .line 1769
    .local v0, "childCount":I
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getWidth()I

    move-result v6

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getPaddingRight()I

    move-result v7

    sub-int v4, v6, v7

    .line 1770
    .local v4, "listRight":I
    add-int/lit8 v6, v0, -0x1

    invoke-virtual {p0, v6}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    .line 1771
    .local v1, "lastChild":Landroid/view/View;
    if-eqz v1, :cond_2

    invoke-virtual {v1}, Landroid/view/View;->getRight()I

    move-result v2

    .line 1772
    .local v2, "lastRight":I
    :goto_0
    iget v6, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mFirstPosition:I

    add-int/2addr v6, v0

    iget v7, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mLastHandledItemCount:I

    if-lt v6, v7, :cond_3

    if-gt v2, v4, :cond_3

    :goto_1
    iput-boolean v5, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mForceTranscriptScroll:Z

    .line 1774
    .end local v0    # "childCount":I
    .end local v1    # "lastChild":Landroid/view/View;
    .end local v2    # "lastRight":I
    .end local v4    # "listRight":I
    :cond_1
    return-void

    .restart local v0    # "childCount":I
    .restart local v1    # "lastChild":Landroid/view/View;
    .restart local v4    # "listRight":I
    :cond_2
    move v2, v4

    .line 1771
    goto :goto_0

    .line 1772
    .restart local v2    # "lastRight":I
    :cond_3
    const/4 v5, 0x0

    goto :goto_1
.end method

.method protected onOverScrolled(IIZZ)V
    .locals 3
    .param p1, "scrollX"    # I
    .param p2, "scrollY"    # I
    .param p3, "clampedX"    # Z
    .param p4, "clampedY"    # Z

    .prologue
    .line 3385
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getScrollX()I

    move-result v0

    if-eq v0, p1, :cond_0

    .line 3386
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getScrollY()I

    move-result v0

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getScrollX()I

    move-result v1

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getScrollY()I

    move-result v2

    invoke-virtual {p0, p1, v0, v1, v2}, Lit/sephiroth/android/library/widget/AbsHListView;->onScrollChanged(IIII)V

    .line 3387
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mViewHelper:Lit/sephiroth/android/library/util/ViewHelperFactory$ViewHelper;

    invoke-virtual {v0, p1}, Lit/sephiroth/android/library/util/ViewHelperFactory$ViewHelper;->setScrollX(I)V

    .line 3388
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->invalidateParentIfNeeded()V

    .line 3390
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->awakenScrollBars()Z

    .line 3392
    :cond_0
    return-void
.end method

.method public onRestoreInstanceState(Landroid/os/Parcelable;)V
    .locals 8
    .param p1, "state"    # Landroid/os/Parcelable;

    .prologue
    const-wide/16 v6, 0x0

    const/4 v5, -0x1

    const/4 v4, 0x1

    .line 1553
    move-object v0, p1

    check-cast v0, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;

    .line 1555
    .local v0, "ss":Lit/sephiroth/android/library/widget/AbsHListView$SavedState;
    invoke-virtual {v0}, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->getSuperState()Landroid/os/Parcelable;

    move-result-object v1

    invoke-super {p0, v1}, Lit/sephiroth/android/library/widget/AdapterView;->onRestoreInstanceState(Landroid/os/Parcelable;)V

    .line 1556
    iput-boolean v4, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mDataChanged:Z

    .line 1558
    iget v1, v0, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->width:I

    int-to-long v2, v1

    iput-wide v2, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSyncWidth:J

    .line 1560
    iget-wide v2, v0, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->selectedId:J

    cmp-long v1, v2, v6

    if-ltz v1, :cond_4

    .line 1561
    iput-boolean v4, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mNeedSync:Z

    .line 1562
    iput-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mPendingSync:Lit/sephiroth/android/library/widget/AbsHListView$SavedState;

    .line 1563
    iget-wide v2, v0, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->selectedId:J

    iput-wide v2, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSyncColId:J

    .line 1564
    iget v1, v0, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->position:I

    iput v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSyncPosition:I

    .line 1565
    iget v1, v0, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->viewLeft:I

    iput v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSpecificLeft:I

    .line 1566
    const/4 v1, 0x0

    iput v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSyncMode:I

    .line 1585
    :cond_0
    :goto_0
    iget-object v1, v0, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->checkState:Landroid/support/v4/util/SparseArrayCompat;

    if-eqz v1, :cond_1

    .line 1586
    iget-object v1, v0, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->checkState:Landroid/support/v4/util/SparseArrayCompat;

    iput-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckStates:Landroid/support/v4/util/SparseArrayCompat;

    .line 1589
    :cond_1
    iget-object v1, v0, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->checkIdState:Landroid/support/v4/util/LongSparseArray;

    if-eqz v1, :cond_2

    .line 1590
    iget-object v1, v0, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->checkIdState:Landroid/support/v4/util/LongSparseArray;

    iput-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckedIdStates:Landroid/support/v4/util/LongSparseArray;

    .line 1593
    :cond_2
    iget v1, v0, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->checkedItemCount:I

    iput v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckedItemCount:I

    .line 1595
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0xb

    if-lt v1, v2, :cond_3

    .line 1596
    iget-boolean v1, v0, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->inActionMode:Z

    if-eqz v1, :cond_3

    iget v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mChoiceMode:I

    const/4 v2, 0x3

    if-ne v1, v2, :cond_3

    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mMultiChoiceModeCallback:Ljava/lang/Object;

    if-eqz v1, :cond_3

    .line 1597
    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mMultiChoiceModeCallback:Ljava/lang/Object;

    check-cast v1, Lit/sephiroth/android/library/util/v11/MultiChoiceModeWrapper;

    invoke-virtual {p0, v1}, Lit/sephiroth/android/library/widget/AbsHListView;->startActionMode(Landroid/view/ActionMode$Callback;)Landroid/view/ActionMode;

    move-result-object v1

    iput-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mChoiceActionMode:Ljava/lang/Object;

    .line 1601
    :cond_3
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->requestLayout()V

    .line 1602
    return-void

    .line 1567
    :cond_4
    iget-wide v2, v0, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->firstId:J

    cmp-long v1, v2, v6

    if-ltz v1, :cond_0

    .line 1568
    invoke-virtual {p0, v5}, Lit/sephiroth/android/library/widget/AbsHListView;->setSelectedPositionInt(I)V

    .line 1570
    invoke-virtual {p0, v5}, Lit/sephiroth/android/library/widget/AbsHListView;->setNextSelectedPositionInt(I)V

    .line 1571
    iput v5, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectorPosition:I

    .line 1572
    iput-boolean v4, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mNeedSync:Z

    .line 1573
    iput-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mPendingSync:Lit/sephiroth/android/library/widget/AbsHListView$SavedState;

    .line 1574
    iget-wide v2, v0, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->firstId:J

    iput-wide v2, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSyncColId:J

    .line 1575
    iget v1, v0, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->position:I

    iput v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSyncPosition:I

    .line 1576
    iget v1, v0, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->viewLeft:I

    iput v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSpecificLeft:I

    .line 1577
    iput v4, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSyncMode:I

    goto :goto_0
.end method

.method public onSaveInstanceState()Landroid/os/Parcelable;
    .locals 14

    .prologue
    .line 1467
    invoke-super {p0}, Lit/sephiroth/android/library/widget/AdapterView;->onSaveInstanceState()Landroid/os/Parcelable;

    move-result-object v9

    .line 1469
    .local v9, "superState":Landroid/os/Parcelable;
    new-instance v8, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;

    invoke-direct {v8, v9}, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;-><init>(Landroid/os/Parcelable;)V

    .line 1472
    .local v8, "ss":Lit/sephiroth/android/library/widget/AbsHListView$SavedState;
    iget-object v11, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mPendingSync:Lit/sephiroth/android/library/widget/AbsHListView$SavedState;

    if-eqz v11, :cond_0

    .line 1474
    iget-object v11, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mPendingSync:Lit/sephiroth/android/library/widget/AbsHListView$SavedState;

    iget-wide v12, v11, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->selectedId:J

    iput-wide v12, v8, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->selectedId:J

    .line 1475
    iget-object v11, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mPendingSync:Lit/sephiroth/android/library/widget/AbsHListView$SavedState;

    iget-wide v12, v11, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->firstId:J

    iput-wide v12, v8, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->firstId:J

    .line 1476
    iget-object v11, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mPendingSync:Lit/sephiroth/android/library/widget/AbsHListView$SavedState;

    iget v11, v11, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->viewLeft:I

    iput v11, v8, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->viewLeft:I

    .line 1477
    iget-object v11, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mPendingSync:Lit/sephiroth/android/library/widget/AbsHListView$SavedState;

    iget v11, v11, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->position:I

    iput v11, v8, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->position:I

    .line 1478
    iget-object v11, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mPendingSync:Lit/sephiroth/android/library/widget/AbsHListView$SavedState;

    iget v11, v11, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->width:I

    iput v11, v8, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->width:I

    .line 1479
    iget-object v11, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mPendingSync:Lit/sephiroth/android/library/widget/AbsHListView$SavedState;

    iget-object v11, v11, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->filter:Ljava/lang/String;

    iput-object v11, v8, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->filter:Ljava/lang/String;

    .line 1480
    iget-object v11, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mPendingSync:Lit/sephiroth/android/library/widget/AbsHListView$SavedState;

    iget-boolean v11, v11, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->inActionMode:Z

    iput-boolean v11, v8, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->inActionMode:Z

    .line 1481
    iget-object v11, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mPendingSync:Lit/sephiroth/android/library/widget/AbsHListView$SavedState;

    iget v11, v11, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->checkedItemCount:I

    iput v11, v8, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->checkedItemCount:I

    .line 1482
    iget-object v11, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mPendingSync:Lit/sephiroth/android/library/widget/AbsHListView$SavedState;

    iget-object v11, v11, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->checkState:Landroid/support/v4/util/SparseArrayCompat;

    iput-object v11, v8, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->checkState:Landroid/support/v4/util/SparseArrayCompat;

    .line 1483
    iget-object v11, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mPendingSync:Lit/sephiroth/android/library/widget/AbsHListView$SavedState;

    iget-object v11, v11, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->checkIdState:Landroid/support/v4/util/LongSparseArray;

    iput-object v11, v8, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->checkIdState:Landroid/support/v4/util/LongSparseArray;

    .line 1545
    :goto_0
    return-object v8

    .line 1487
    :cond_0
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildCount()I

    move-result v11

    if-lez v11, :cond_2

    iget v11, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mItemCount:I

    if-lez v11, :cond_2

    const/4 v3, 0x1

    .line 1488
    .local v3, "haveChildren":Z
    :goto_1
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getSelectedItemId()J

    move-result-wide v6

    .line 1489
    .local v6, "selectedId":J
    iput-wide v6, v8, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->selectedId:J

    .line 1490
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getWidth()I

    move-result v11

    iput v11, v8, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->width:I

    .line 1492
    const-wide/16 v12, 0x0

    cmp-long v11, v6, v12

    if-ltz v11, :cond_3

    .line 1494
    iget v11, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectedLeft:I

    iput v11, v8, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->viewLeft:I

    .line 1495
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getSelectedItemPosition()I

    move-result v11

    iput v11, v8, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->position:I

    .line 1496
    const-wide/16 v12, -0x1

    iput-wide v12, v8, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->firstId:J

    .line 1523
    :goto_2
    const/4 v11, 0x0

    iput-object v11, v8, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->filter:Ljava/lang/String;

    .line 1524
    sget v11, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v12, 0xb

    if-lt v11, v12, :cond_6

    iget v11, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mChoiceMode:I

    const/4 v12, 0x3

    if-ne v11, v12, :cond_6

    iget-object v11, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mChoiceActionMode:Ljava/lang/Object;

    if-eqz v11, :cond_6

    const/4 v11, 0x1

    :goto_3
    iput-boolean v11, v8, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->inActionMode:Z

    .line 1527
    iget-object v11, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckStates:Landroid/support/v4/util/SparseArrayCompat;

    if-eqz v11, :cond_1

    .line 1529
    :try_start_0
    iget-object v11, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckStates:Landroid/support/v4/util/SparseArrayCompat;

    invoke-virtual {v11}, Landroid/support/v4/util/SparseArrayCompat;->clone()Landroid/support/v4/util/SparseArrayCompat;

    move-result-object v11

    iput-object v11, v8, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->checkState:Landroid/support/v4/util/SparseArrayCompat;
    :try_end_0
    .catch Ljava/lang/NoSuchMethodError; {:try_start_0 .. :try_end_0} :catch_0

    .line 1535
    :cond_1
    :goto_4
    iget-object v11, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckedIdStates:Landroid/support/v4/util/LongSparseArray;

    if-eqz v11, :cond_8

    .line 1536
    new-instance v5, Landroid/support/v4/util/LongSparseArray;

    invoke-direct {v5}, Landroid/support/v4/util/LongSparseArray;-><init>()V

    .line 1537
    .local v5, "idState":Landroid/support/v4/util/LongSparseArray;, "Landroid/support/v4/util/LongSparseArray<Ljava/lang/Integer;>;"
    iget-object v11, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckedIdStates:Landroid/support/v4/util/LongSparseArray;

    invoke-virtual {v11}, Landroid/support/v4/util/LongSparseArray;->size()I

    move-result v0

    .line 1538
    .local v0, "count":I
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_5
    if-ge v4, v0, :cond_7

    .line 1539
    iget-object v11, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckedIdStates:Landroid/support/v4/util/LongSparseArray;

    invoke-virtual {v11, v4}, Landroid/support/v4/util/LongSparseArray;->keyAt(I)J

    move-result-wide v12

    iget-object v11, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckedIdStates:Landroid/support/v4/util/LongSparseArray;

    invoke-virtual {v11, v4}, Landroid/support/v4/util/LongSparseArray;->valueAt(I)Ljava/lang/Object;

    move-result-object v11

    invoke-virtual {v5, v12, v13, v11}, Landroid/support/v4/util/LongSparseArray;->put(JLjava/lang/Object;)V

    .line 1538
    add-int/lit8 v4, v4, 0x1

    goto :goto_5

    .line 1487
    .end local v0    # "count":I
    .end local v3    # "haveChildren":Z
    .end local v4    # "i":I
    .end local v5    # "idState":Landroid/support/v4/util/LongSparseArray;, "Landroid/support/v4/util/LongSparseArray<Ljava/lang/Integer;>;"
    .end local v6    # "selectedId":J
    :cond_2
    const/4 v3, 0x0

    goto :goto_1

    .line 1498
    .restart local v3    # "haveChildren":Z
    .restart local v6    # "selectedId":J
    :cond_3
    if-eqz v3, :cond_5

    iget v11, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mFirstPosition:I

    if-lez v11, :cond_5

    .line 1508
    const/4 v11, 0x0

    invoke-virtual {p0, v11}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildAt(I)Landroid/view/View;

    move-result-object v10

    .line 1509
    .local v10, "v":Landroid/view/View;
    invoke-virtual {v10}, Landroid/view/View;->getLeft()I

    move-result v11

    iput v11, v8, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->viewLeft:I

    .line 1510
    iget v2, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mFirstPosition:I

    .line 1511
    .local v2, "firstPos":I
    iget v11, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mItemCount:I

    if-lt v2, v11, :cond_4

    .line 1512
    iget v11, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mItemCount:I

    add-int/lit8 v2, v11, -0x1

    .line 1514
    :cond_4
    iput v2, v8, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->position:I

    .line 1515
    iget-object v11, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v11, v2}, Landroid/widget/ListAdapter;->getItemId(I)J

    move-result-wide v12

    iput-wide v12, v8, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->firstId:J

    goto :goto_2

    .line 1517
    .end local v2    # "firstPos":I
    .end local v10    # "v":Landroid/view/View;
    :cond_5
    const/4 v11, 0x0

    iput v11, v8, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->viewLeft:I

    .line 1518
    const-wide/16 v12, -0x1

    iput-wide v12, v8, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->firstId:J

    .line 1519
    const/4 v11, 0x0

    iput v11, v8, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->position:I

    goto :goto_2

    .line 1524
    :cond_6
    const/4 v11, 0x0

    goto :goto_3

    .line 1530
    :catch_0
    move-exception v1

    .line 1531
    .local v1, "e":Ljava/lang/NoSuchMethodError;
    invoke-virtual {v1}, Ljava/lang/NoSuchMethodError;->printStackTrace()V

    .line 1532
    new-instance v11, Landroid/support/v4/util/SparseArrayCompat;

    invoke-direct {v11}, Landroid/support/v4/util/SparseArrayCompat;-><init>()V

    iput-object v11, v8, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->checkState:Landroid/support/v4/util/SparseArrayCompat;

    goto :goto_4

    .line 1541
    .end local v1    # "e":Ljava/lang/NoSuchMethodError;
    .restart local v0    # "count":I
    .restart local v4    # "i":I
    .restart local v5    # "idState":Landroid/support/v4/util/LongSparseArray;, "Landroid/support/v4/util/LongSparseArray<Ljava/lang/Integer;>;"
    :cond_7
    iput-object v5, v8, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->checkIdState:Landroid/support/v4/util/LongSparseArray;

    .line 1543
    .end local v0    # "count":I
    .end local v4    # "i":I
    .end local v5    # "idState":Landroid/support/v4/util/LongSparseArray;, "Landroid/support/v4/util/LongSparseArray<Ljava/lang/Integer;>;"
    :cond_8
    iget v11, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckedItemCount:I

    iput v11, v8, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->checkedItemCount:I

    goto/16 :goto_0
.end method

.method protected onSizeChanged(IIII)V
    .locals 1
    .param p1, "w"    # I
    .param p2, "h"    # I
    .param p3, "oldw"    # I
    .param p4, "oldh"    # I

    .prologue
    .line 2153
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildCount()I

    move-result v0

    if-lez v0, :cond_0

    .line 2154
    const/4 v0, 0x1

    iput-boolean v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mDataChanged:Z

    .line 2155
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->rememberSyncState()V

    .line 2157
    :cond_0
    return-void
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 28
    .param p1, "ev"    # Landroid/view/MotionEvent;
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "Override"
        }
    .end annotation

    .prologue
    .line 3020
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->isEnabled()Z

    move-result v25

    if-nez v25, :cond_2

    .line 3023
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->isClickable()Z

    move-result v25

    if-nez v25, :cond_0

    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->isLongClickable()Z

    move-result v25

    if-eqz v25, :cond_1

    :cond_0
    const/16 v25, 0x1

    .line 3380
    :goto_0
    return v25

    .line 3023
    :cond_1
    const/16 v25, 0x0

    goto :goto_0

    .line 3026
    :cond_2
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mPositionScroller:Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;

    move-object/from16 v25, v0

    if-eqz v25, :cond_3

    .line 3027
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mPositionScroller:Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;

    move-object/from16 v25, v0

    invoke-virtual/range {v25 .. v25}, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->stop()V

    .line 3030
    :cond_3
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mIsAttached:Z

    move/from16 v25, v0

    if-nez v25, :cond_4

    .line 3035
    const/16 v25, 0x0

    goto :goto_0

    .line 3038
    :cond_4
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v4

    .line 3042
    .local v4, "action":I
    invoke-direct/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->initVelocityTrackerIfNotExists()V

    .line 3043
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mVelocityTracker:Landroid/view/VelocityTracker;

    move-object/from16 v25, v0

    move-object/from16 v0, v25

    move-object/from16 v1, p1

    invoke-virtual {v0, v1}, Landroid/view/VelocityTracker;->addMovement(Landroid/view/MotionEvent;)V

    .line 3045
    and-int/lit16 v0, v4, 0xff

    move/from16 v25, v0

    packed-switch v25, :pswitch_data_0

    .line 3380
    :cond_5
    :goto_1
    :pswitch_0
    const/16 v25, 0x1

    goto :goto_0

    .line 3047
    :pswitch_1
    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mTouchMode:I

    move/from16 v25, v0

    packed-switch v25, :pswitch_data_1

    .line 3063
    const/16 v25, 0x0

    move-object/from16 v0, p1

    move/from16 v1, v25

    invoke-virtual {v0, v1}, Landroid/view/MotionEvent;->getPointerId(I)I

    move-result v25

    move/from16 v0, v25

    move-object/from16 v1, p0

    iput v0, v1, Lit/sephiroth/android/library/widget/AbsHListView;->mActivePointerId:I

    .line 3064
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v25

    move/from16 v0, v25

    float-to-int v0, v0

    move/from16 v23, v0

    .line 3065
    .local v23, "x":I
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v25

    move/from16 v0, v25

    float-to-int v0, v0

    move/from16 v24, v0

    .line 3066
    .local v24, "y":I
    move-object/from16 v0, p0

    move/from16 v1, v23

    move/from16 v2, v24

    invoke-virtual {v0, v1, v2}, Lit/sephiroth/android/library/widget/AbsHListView;->pointToPosition(II)I

    move-result v17

    .line 3067
    .local v17, "motionPosition":I
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mDataChanged:Z

    move/from16 v25, v0

    if-nez v25, :cond_7

    .line 3068
    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mTouchMode:I

    move/from16 v25, v0

    const/16 v26, 0x4

    move/from16 v0, v25

    move/from16 v1, v26

    if-eq v0, v1, :cond_a

    if-ltz v17, :cond_a

    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getAdapter()Landroid/widget/Adapter;

    move-result-object v25

    check-cast v25, Landroid/widget/ListAdapter;

    move-object/from16 v0, v25

    move/from16 v1, v17

    invoke-interface {v0, v1}, Landroid/widget/ListAdapter;->isEnabled(I)Z

    move-result v25

    if-eqz v25, :cond_a

    .line 3073
    const/16 v25, 0x0

    move/from16 v0, v25

    move-object/from16 v1, p0

    iput v0, v1, Lit/sephiroth/android/library/widget/AbsHListView;->mTouchMode:I

    .line 3075
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mPendingCheckForTap:Ljava/lang/Runnable;

    move-object/from16 v25, v0

    if-nez v25, :cond_6

    .line 3076
    new-instance v25, Lit/sephiroth/android/library/widget/AbsHListView$CheckForTap;

    move-object/from16 v0, v25

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lit/sephiroth/android/library/widget/AbsHListView$CheckForTap;-><init>(Lit/sephiroth/android/library/widget/AbsHListView;)V

    move-object/from16 v0, v25

    move-object/from16 v1, p0

    iput-object v0, v1, Lit/sephiroth/android/library/widget/AbsHListView;->mPendingCheckForTap:Ljava/lang/Runnable;

    .line 3078
    :cond_6
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mPendingCheckForTap:Ljava/lang/Runnable;

    move-object/from16 v25, v0

    invoke-static {}, Landroid/view/ViewConfiguration;->getTapTimeout()I

    move-result v26

    move/from16 v0, v26

    int-to-long v0, v0

    move-wide/from16 v26, v0

    move-object/from16 v0, p0

    move-object/from16 v1, v25

    move-wide/from16 v2, v26

    invoke-virtual {v0, v1, v2, v3}, Lit/sephiroth/android/library/widget/AbsHListView;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 3091
    :cond_7
    :goto_2
    if-ltz v17, :cond_8

    .line 3093
    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mFirstPosition:I

    move/from16 v25, v0

    sub-int v25, v17, v25

    move-object/from16 v0, p0

    move/from16 v1, v25

    invoke-virtual {v0, v1}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildAt(I)Landroid/view/View;

    move-result-object v21

    .line 3094
    .local v21, "v":Landroid/view/View;
    invoke-virtual/range {v21 .. v21}, Landroid/view/View;->getLeft()I

    move-result v25

    move/from16 v0, v25

    move-object/from16 v1, p0

    iput v0, v1, Lit/sephiroth/android/library/widget/AbsHListView;->mMotionViewOriginalLeft:I

    .line 3096
    .end local v21    # "v":Landroid/view/View;
    :cond_8
    move/from16 v0, v23

    move-object/from16 v1, p0

    iput v0, v1, Lit/sephiroth/android/library/widget/AbsHListView;->mMotionX:I

    .line 3097
    move/from16 v0, v24

    move-object/from16 v1, p0

    iput v0, v1, Lit/sephiroth/android/library/widget/AbsHListView;->mMotionY:I

    .line 3098
    move/from16 v0, v17

    move-object/from16 v1, p0

    iput v0, v1, Lit/sephiroth/android/library/widget/AbsHListView;->mMotionPosition:I

    .line 3099
    const/high16 v25, -0x80000000

    move/from16 v0, v25

    move-object/from16 v1, p0

    iput v0, v1, Lit/sephiroth/android/library/widget/AbsHListView;->mLastX:I

    .line 3104
    .end local v17    # "motionPosition":I
    .end local v23    # "x":I
    .end local v24    # "y":I
    :goto_3
    invoke-virtual/range {p0 .. p1}, Lit/sephiroth/android/library/widget/AbsHListView;->performButtonActionOnTouchDown(Landroid/view/MotionEvent;)Z

    move-result v25

    if-eqz v25, :cond_5

    .line 3105
    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mTouchMode:I

    move/from16 v25, v0

    if-nez v25, :cond_5

    .line 3106
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mPendingCheckForTap:Ljava/lang/Runnable;

    move-object/from16 v25, v0

    move-object/from16 v0, p0

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lit/sephiroth/android/library/widget/AbsHListView;->removeCallbacks(Ljava/lang/Runnable;)Z

    goto/16 :goto_1

    .line 3049
    :pswitch_2
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mFlingRunnable:Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;

    move-object/from16 v25, v0

    invoke-virtual/range {v25 .. v25}, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->endFling()V

    .line 3050
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mPositionScroller:Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;

    move-object/from16 v25, v0

    if-eqz v25, :cond_9

    .line 3051
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mPositionScroller:Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;

    move-object/from16 v25, v0

    invoke-virtual/range {v25 .. v25}, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->stop()V

    .line 3053
    :cond_9
    const/16 v25, 0x5

    move/from16 v0, v25

    move-object/from16 v1, p0

    iput v0, v1, Lit/sephiroth/android/library/widget/AbsHListView;->mTouchMode:I

    .line 3054
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getY()F

    move-result v25

    move/from16 v0, v25

    float-to-int v0, v0

    move/from16 v25, v0

    move/from16 v0, v25

    move-object/from16 v1, p0

    iput v0, v1, Lit/sephiroth/android/library/widget/AbsHListView;->mMotionY:I

    .line 3055
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v25

    move/from16 v0, v25

    float-to-int v0, v0

    move/from16 v25, v0

    move/from16 v0, v25

    move-object/from16 v1, p0

    iput v0, v1, Lit/sephiroth/android/library/widget/AbsHListView;->mLastX:I

    move/from16 v0, v25

    move-object/from16 v1, p0

    iput v0, v1, Lit/sephiroth/android/library/widget/AbsHListView;->mMotionX:I

    .line 3056
    const/16 v25, 0x0

    move/from16 v0, v25

    move-object/from16 v1, p0

    iput v0, v1, Lit/sephiroth/android/library/widget/AbsHListView;->mMotionCorrection:I

    .line 3057
    const/16 v25, 0x0

    move-object/from16 v0, p1

    move/from16 v1, v25

    invoke-virtual {v0, v1}, Landroid/view/MotionEvent;->getPointerId(I)I

    move-result v25

    move/from16 v0, v25

    move-object/from16 v1, p0

    iput v0, v1, Lit/sephiroth/android/library/widget/AbsHListView;->mActivePointerId:I

    .line 3058
    const/16 v25, 0x0

    move/from16 v0, v25

    move-object/from16 v1, p0

    iput v0, v1, Lit/sephiroth/android/library/widget/AbsHListView;->mDirection:I

    goto/16 :goto_3

    .line 3080
    .restart local v17    # "motionPosition":I
    .restart local v23    # "x":I
    .restart local v24    # "y":I
    :cond_a
    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mTouchMode:I

    move/from16 v25, v0

    const/16 v26, 0x4

    move/from16 v0, v25

    move/from16 v1, v26

    if-ne v0, v1, :cond_7

    .line 3082
    invoke-direct/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->createScrollingCache()V

    .line 3083
    const/16 v25, 0x3

    move/from16 v0, v25

    move-object/from16 v1, p0

    iput v0, v1, Lit/sephiroth/android/library/widget/AbsHListView;->mTouchMode:I

    .line 3084
    const/16 v25, 0x0

    move/from16 v0, v25

    move-object/from16 v1, p0

    iput v0, v1, Lit/sephiroth/android/library/widget/AbsHListView;->mMotionCorrection:I

    .line 3085
    move-object/from16 v0, p0

    move/from16 v1, v23

    invoke-virtual {v0, v1}, Lit/sephiroth/android/library/widget/AbsHListView;->findMotionCol(I)I

    move-result v17

    .line 3086
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mFlingRunnable:Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;

    move-object/from16 v25, v0

    invoke-virtual/range {v25 .. v25}, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->flywheelTouch()V

    goto/16 :goto_2

    .line 3113
    .end local v17    # "motionPosition":I
    .end local v23    # "x":I
    .end local v24    # "y":I
    :pswitch_3
    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mActivePointerId:I

    move/from16 v25, v0

    move-object/from16 v0, p1

    move/from16 v1, v25

    invoke-virtual {v0, v1}, Landroid/view/MotionEvent;->findPointerIndex(I)I

    move-result v20

    .line 3114
    .local v20, "pointerIndex":I
    const/16 v25, -0x1

    move/from16 v0, v20

    move/from16 v1, v25

    if-ne v0, v1, :cond_b

    .line 3115
    const/16 v20, 0x0

    .line 3116
    move-object/from16 v0, p1

    move/from16 v1, v20

    invoke-virtual {v0, v1}, Landroid/view/MotionEvent;->getPointerId(I)I

    move-result v25

    move/from16 v0, v25

    move-object/from16 v1, p0

    iput v0, v1, Lit/sephiroth/android/library/widget/AbsHListView;->mActivePointerId:I

    .line 3118
    :cond_b
    move-object/from16 v0, p1

    move/from16 v1, v20

    invoke-virtual {v0, v1}, Landroid/view/MotionEvent;->getX(I)F

    move-result v25

    move/from16 v0, v25

    float-to-int v0, v0

    move/from16 v23, v0

    .line 3120
    .restart local v23    # "x":I
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mDataChanged:Z

    move/from16 v25, v0

    if-eqz v25, :cond_c

    .line 3123
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->layoutChildren()V

    .line 3126
    :cond_c
    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mTouchMode:I

    move/from16 v25, v0

    packed-switch v25, :pswitch_data_2

    :pswitch_4
    goto/16 :goto_1

    .line 3132
    :pswitch_5
    move-object/from16 v0, p0

    move/from16 v1, v23

    invoke-direct {v0, v1}, Lit/sephiroth/android/library/widget/AbsHListView;->startScrollIfNeeded(I)Z

    goto/16 :goto_1

    .line 3136
    :pswitch_6
    move-object/from16 v0, p0

    move/from16 v1, v23

    invoke-direct {v0, v1}, Lit/sephiroth/android/library/widget/AbsHListView;->scrollIfNeeded(I)V

    goto/16 :goto_1

    .line 3143
    .end local v20    # "pointerIndex":I
    .end local v23    # "x":I
    :pswitch_7
    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mTouchMode:I

    move/from16 v25, v0

    packed-switch v25, :pswitch_data_3

    .line 3284
    :cond_d
    :goto_4
    :pswitch_8
    const/16 v25, 0x0

    move-object/from16 v0, p0

    move/from16 v1, v25

    invoke-virtual {v0, v1}, Lit/sephiroth/android/library/widget/AbsHListView;->setPressed(Z)V

    .line 3286
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mEdgeGlowTop:Lit/sephiroth/android/library/widget/EdgeEffect;

    move-object/from16 v25, v0

    if-eqz v25, :cond_e

    .line 3287
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mEdgeGlowTop:Lit/sephiroth/android/library/widget/EdgeEffect;

    move-object/from16 v25, v0

    invoke-virtual/range {v25 .. v25}, Lit/sephiroth/android/library/widget/EdgeEffect;->onRelease()V

    .line 3288
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mEdgeGlowBottom:Lit/sephiroth/android/library/widget/EdgeEffect;

    move-object/from16 v25, v0

    invoke-virtual/range {v25 .. v25}, Lit/sephiroth/android/library/widget/EdgeEffect;->onRelease()V

    .line 3292
    :cond_e
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->invalidate()V

    .line 3294
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getHandler()Landroid/os/Handler;

    move-result-object v11

    .line 3295
    .local v11, "handler":Landroid/os/Handler;
    if-eqz v11, :cond_f

    .line 3296
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mPendingCheckForLongPress:Lit/sephiroth/android/library/widget/AbsHListView$CheckForLongPress;

    move-object/from16 v25, v0

    move-object/from16 v0, v25

    invoke-virtual {v11, v0}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 3299
    :cond_f
    invoke-direct/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->recycleVelocityTracker()V

    .line 3301
    const/16 v25, -0x1

    move/from16 v0, v25

    move-object/from16 v1, p0

    iput v0, v1, Lit/sephiroth/android/library/widget/AbsHListView;->mActivePointerId:I

    goto/16 :goto_1

    .line 3147
    .end local v11    # "handler":Landroid/os/Handler;
    :pswitch_9
    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mMotionPosition:I

    move/from16 v17, v0

    .line 3148
    .restart local v17    # "motionPosition":I
    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mFirstPosition:I

    move/from16 v25, v0

    sub-int v25, v17, v25

    move-object/from16 v0, p0

    move/from16 v1, v25

    invoke-virtual {v0, v1}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildAt(I)Landroid/view/View;

    move-result-object v5

    .line 3150
    .local v5, "child":Landroid/view/View;
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v23

    .line 3151
    .local v23, "x":F
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mListPadding:Landroid/graphics/Rect;

    move-object/from16 v25, v0

    move-object/from16 v0, v25

    iget v0, v0, Landroid/graphics/Rect;->left:I

    move/from16 v25, v0

    move/from16 v0, v25

    int-to-float v0, v0

    move/from16 v25, v0

    cmpl-float v25, v23, v25

    if-lez v25, :cond_16

    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getWidth()I

    move-result v25

    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mListPadding:Landroid/graphics/Rect;

    move-object/from16 v26, v0

    move-object/from16 v0, v26

    iget v0, v0, Landroid/graphics/Rect;->right:I

    move/from16 v26, v0

    sub-int v25, v25, v26

    move/from16 v0, v25

    int-to-float v0, v0

    move/from16 v25, v0

    cmpg-float v25, v23, v25

    if-gez v25, :cond_16

    const/4 v13, 0x1

    .line 3153
    .local v13, "inList":Z
    :goto_5
    if-eqz v5, :cond_1a

    invoke-virtual {v5}, Landroid/view/View;->hasFocusable()Z

    move-result v25

    if-nez v25, :cond_1a

    if-eqz v13, :cond_1a

    .line 3154
    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mTouchMode:I

    move/from16 v25, v0

    if-eqz v25, :cond_10

    .line 3155
    const/16 v25, 0x0

    move/from16 v0, v25

    invoke-virtual {v5, v0}, Landroid/view/View;->setPressed(Z)V

    .line 3158
    :cond_10
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mPerformClick:Lit/sephiroth/android/library/widget/AbsHListView$PerformClick;

    move-object/from16 v25, v0

    if-nez v25, :cond_11

    .line 3159
    new-instance v25, Lit/sephiroth/android/library/widget/AbsHListView$PerformClick;

    const/16 v26, 0x0

    move-object/from16 v0, v25

    move-object/from16 v1, p0

    move-object/from16 v2, v26

    invoke-direct {v0, v1, v2}, Lit/sephiroth/android/library/widget/AbsHListView$PerformClick;-><init>(Lit/sephiroth/android/library/widget/AbsHListView;Lit/sephiroth/android/library/widget/AbsHListView$1;)V

    move-object/from16 v0, v25

    move-object/from16 v1, p0

    iput-object v0, v1, Lit/sephiroth/android/library/widget/AbsHListView;->mPerformClick:Lit/sephiroth/android/library/widget/AbsHListView$PerformClick;

    .line 3162
    :cond_11
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mPerformClick:Lit/sephiroth/android/library/widget/AbsHListView$PerformClick;

    move-object/from16 v19, v0

    .line 3163
    .local v19, "performClick":Lit/sephiroth/android/library/widget/AbsHListView$PerformClick;
    move/from16 v0, v17

    move-object/from16 v1, v19

    iput v0, v1, Lit/sephiroth/android/library/widget/AbsHListView$PerformClick;->mClickMotionPosition:I

    .line 3164
    invoke-virtual/range {v19 .. v19}, Lit/sephiroth/android/library/widget/AbsHListView$PerformClick;->rememberWindowAttachCount()V

    .line 3166
    move/from16 v0, v17

    move-object/from16 v1, p0

    iput v0, v1, Lit/sephiroth/android/library/widget/AbsHListView;->mResurrectToPosition:I

    .line 3168
    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mTouchMode:I

    move/from16 v25, v0

    if-eqz v25, :cond_12

    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mTouchMode:I

    move/from16 v25, v0

    const/16 v26, 0x1

    move/from16 v0, v25

    move/from16 v1, v26

    if-ne v0, v1, :cond_19

    .line 3169
    :cond_12
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getHandler()Landroid/os/Handler;

    move-result-object v11

    .line 3170
    .restart local v11    # "handler":Landroid/os/Handler;
    if-eqz v11, :cond_13

    .line 3171
    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mTouchMode:I

    move/from16 v25, v0

    if-nez v25, :cond_17

    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mPendingCheckForTap:Ljava/lang/Runnable;

    move-object/from16 v25, v0

    :goto_6
    move-object/from16 v0, v25

    invoke-virtual {v11, v0}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 3174
    :cond_13
    const/16 v25, 0x0

    move/from16 v0, v25

    move-object/from16 v1, p0

    iput v0, v1, Lit/sephiroth/android/library/widget/AbsHListView;->mLayoutMode:I

    .line 3176
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mDataChanged:Z

    move/from16 v25, v0

    if-nez v25, :cond_18

    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mAdapter:Landroid/widget/ListAdapter;

    move-object/from16 v25, v0

    move-object/from16 v0, v25

    move/from16 v1, v17

    invoke-interface {v0, v1}, Landroid/widget/ListAdapter;->isEnabled(I)Z

    move-result v25

    if-eqz v25, :cond_18

    .line 3177
    const/16 v25, 0x1

    move/from16 v0, v25

    move-object/from16 v1, p0

    iput v0, v1, Lit/sephiroth/android/library/widget/AbsHListView;->mTouchMode:I

    .line 3178
    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mMotionPosition:I

    move/from16 v25, v0

    move-object/from16 v0, p0

    move/from16 v1, v25

    invoke-virtual {v0, v1}, Lit/sephiroth/android/library/widget/AbsHListView;->setSelectedPositionInt(I)V

    .line 3179
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->layoutChildren()V

    .line 3180
    const/16 v25, 0x1

    move/from16 v0, v25

    invoke-virtual {v5, v0}, Landroid/view/View;->setPressed(Z)V

    .line 3181
    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mMotionPosition:I

    move/from16 v25, v0

    move-object/from16 v0, p0

    move/from16 v1, v25

    invoke-virtual {v0, v1, v5}, Lit/sephiroth/android/library/widget/AbsHListView;->positionSelector(ILandroid/view/View;)V

    .line 3182
    const/16 v25, 0x1

    move-object/from16 v0, p0

    move/from16 v1, v25

    invoke-virtual {v0, v1}, Lit/sephiroth/android/library/widget/AbsHListView;->setPressed(Z)V

    .line 3183
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelector:Landroid/graphics/drawable/Drawable;

    move-object/from16 v25, v0

    if-eqz v25, :cond_14

    .line 3184
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelector:Landroid/graphics/drawable/Drawable;

    move-object/from16 v25, v0

    invoke-virtual/range {v25 .. v25}, Landroid/graphics/drawable/Drawable;->getCurrent()Landroid/graphics/drawable/Drawable;

    move-result-object v9

    .line 3185
    .local v9, "d":Landroid/graphics/drawable/Drawable;
    if-eqz v9, :cond_14

    instance-of v0, v9, Landroid/graphics/drawable/TransitionDrawable;

    move/from16 v25, v0

    if-eqz v25, :cond_14

    .line 3186
    check-cast v9, Landroid/graphics/drawable/TransitionDrawable;

    .end local v9    # "d":Landroid/graphics/drawable/Drawable;
    invoke-virtual {v9}, Landroid/graphics/drawable/TransitionDrawable;->resetTransition()V

    .line 3189
    :cond_14
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mTouchModeReset:Ljava/lang/Runnable;

    move-object/from16 v25, v0

    if-eqz v25, :cond_15

    .line 3190
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mTouchModeReset:Ljava/lang/Runnable;

    move-object/from16 v25, v0

    move-object/from16 v0, p0

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lit/sephiroth/android/library/widget/AbsHListView;->removeCallbacks(Ljava/lang/Runnable;)Z

    .line 3192
    :cond_15
    new-instance v25, Lit/sephiroth/android/library/widget/AbsHListView$1;

    move-object/from16 v0, v25

    move-object/from16 v1, p0

    move-object/from16 v2, v19

    invoke-direct {v0, v1, v5, v2}, Lit/sephiroth/android/library/widget/AbsHListView$1;-><init>(Lit/sephiroth/android/library/widget/AbsHListView;Landroid/view/View;Lit/sephiroth/android/library/widget/AbsHListView$PerformClick;)V

    move-object/from16 v0, v25

    move-object/from16 v1, p0

    iput-object v0, v1, Lit/sephiroth/android/library/widget/AbsHListView;->mTouchModeReset:Ljava/lang/Runnable;

    .line 3204
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mTouchModeReset:Ljava/lang/Runnable;

    move-object/from16 v25, v0

    invoke-static {}, Landroid/view/ViewConfiguration;->getPressedStateDuration()I

    move-result v26

    move/from16 v0, v26

    int-to-long v0, v0

    move-wide/from16 v26, v0

    move-object/from16 v0, p0

    move-object/from16 v1, v25

    move-wide/from16 v2, v26

    invoke-virtual {v0, v1, v2, v3}, Lit/sephiroth/android/library/widget/AbsHListView;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 3210
    :goto_7
    const/16 v25, 0x1

    goto/16 :goto_0

    .line 3151
    .end local v11    # "handler":Landroid/os/Handler;
    .end local v13    # "inList":Z
    .end local v19    # "performClick":Lit/sephiroth/android/library/widget/AbsHListView$PerformClick;
    :cond_16
    const/4 v13, 0x0

    goto/16 :goto_5

    .line 3171
    .restart local v11    # "handler":Landroid/os/Handler;
    .restart local v13    # "inList":Z
    .restart local v19    # "performClick":Lit/sephiroth/android/library/widget/AbsHListView$PerformClick;
    :cond_17
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mPendingCheckForLongPress:Lit/sephiroth/android/library/widget/AbsHListView$CheckForLongPress;

    move-object/from16 v25, v0

    goto/16 :goto_6

    .line 3207
    :cond_18
    const/16 v25, -0x1

    move/from16 v0, v25

    move-object/from16 v1, p0

    iput v0, v1, Lit/sephiroth/android/library/widget/AbsHListView;->mTouchMode:I

    .line 3208
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->updateSelectorState()V

    goto :goto_7

    .line 3211
    .end local v11    # "handler":Landroid/os/Handler;
    :cond_19
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mDataChanged:Z

    move/from16 v25, v0

    if-nez v25, :cond_1a

    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mAdapter:Landroid/widget/ListAdapter;

    move-object/from16 v25, v0

    move-object/from16 v0, v25

    move/from16 v1, v17

    invoke-interface {v0, v1}, Landroid/widget/ListAdapter;->isEnabled(I)Z

    move-result v25

    if-eqz v25, :cond_1a

    .line 3212
    invoke-virtual/range {v19 .. v19}, Lit/sephiroth/android/library/widget/AbsHListView$PerformClick;->run()V

    .line 3215
    .end local v19    # "performClick":Lit/sephiroth/android/library/widget/AbsHListView$PerformClick;
    :cond_1a
    const/16 v25, -0x1

    move/from16 v0, v25

    move-object/from16 v1, p0

    iput v0, v1, Lit/sephiroth/android/library/widget/AbsHListView;->mTouchMode:I

    .line 3216
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->updateSelectorState()V

    goto/16 :goto_4

    .line 3219
    .end local v5    # "child":Landroid/view/View;
    .end local v13    # "inList":Z
    .end local v17    # "motionPosition":I
    .end local v23    # "x":F
    :pswitch_a
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildCount()I

    move-result v6

    .line 3220
    .local v6, "childCount":I
    if-lez v6, :cond_21

    .line 3221
    const/16 v25, 0x0

    move-object/from16 v0, p0

    move/from16 v1, v25

    invoke-virtual {v0, v1}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildAt(I)Landroid/view/View;

    move-result-object v25

    invoke-virtual/range {v25 .. v25}, Landroid/view/View;->getLeft()I

    move-result v10

    .line 3222
    .local v10, "firstChildLeft":I
    add-int/lit8 v25, v6, -0x1

    move-object/from16 v0, p0

    move/from16 v1, v25

    invoke-virtual {v0, v1}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildAt(I)Landroid/view/View;

    move-result-object v25

    invoke-virtual/range {v25 .. v25}, Landroid/view/View;->getRight()I

    move-result v16

    .line 3223
    .local v16, "lastChildRight":I
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mListPadding:Landroid/graphics/Rect;

    move-object/from16 v25, v0

    move-object/from16 v0, v25

    iget v7, v0, Landroid/graphics/Rect;->left:I

    .line 3224
    .local v7, "contentLeft":I
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getWidth()I

    move-result v25

    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mListPadding:Landroid/graphics/Rect;

    move-object/from16 v26, v0

    move-object/from16 v0, v26

    iget v0, v0, Landroid/graphics/Rect;->right:I

    move/from16 v26, v0

    sub-int v8, v25, v26

    .line 3225
    .local v8, "contentRight":I
    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mFirstPosition:I

    move/from16 v25, v0

    if-nez v25, :cond_1b

    if-lt v10, v7, :cond_1b

    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mFirstPosition:I

    move/from16 v25, v0

    add-int v25, v25, v6

    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mItemCount:I

    move/from16 v26, v0

    move/from16 v0, v25

    move/from16 v1, v26

    if-ge v0, v1, :cond_1b

    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getWidth()I

    move-result v25

    sub-int v25, v25, v8

    move/from16 v0, v16

    move/from16 v1, v25

    if-gt v0, v1, :cond_1b

    .line 3227
    const/16 v25, -0x1

    move/from16 v0, v25

    move-object/from16 v1, p0

    iput v0, v1, Lit/sephiroth/android/library/widget/AbsHListView;->mTouchMode:I

    .line 3228
    const/16 v25, 0x0

    move-object/from16 v0, p0

    move/from16 v1, v25

    invoke-virtual {v0, v1}, Lit/sephiroth/android/library/widget/AbsHListView;->reportScrollStateChange(I)V

    goto/16 :goto_4

    .line 3230
    :cond_1b
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mVelocityTracker:Landroid/view/VelocityTracker;

    move-object/from16 v22, v0

    .line 3231
    .local v22, "velocityTracker":Landroid/view/VelocityTracker;
    const/16 v25, 0x3e8

    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mMaximumVelocity:I

    move/from16 v26, v0

    move/from16 v0, v26

    int-to-float v0, v0

    move/from16 v26, v0

    move-object/from16 v0, v22

    move/from16 v1, v25

    move/from16 v2, v26

    invoke-virtual {v0, v1, v2}, Landroid/view/VelocityTracker;->computeCurrentVelocity(IF)V

    .line 3233
    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mActivePointerId:I

    move/from16 v25, v0

    move-object/from16 v0, v22

    move/from16 v1, v25

    invoke-virtual {v0, v1}, Landroid/view/VelocityTracker;->getXVelocity(I)F

    move-result v25

    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mVelocityScale:F

    move/from16 v26, v0

    mul-float v25, v25, v26

    move/from16 v0, v25

    float-to-int v15, v0

    .line 3238
    .local v15, "initialVelocity":I
    invoke-static {v15}, Ljava/lang/Math;->abs(I)I

    move-result v25

    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mMinimumVelocity:I

    move/from16 v26, v0

    move/from16 v0, v25

    move/from16 v1, v26

    if-le v0, v1, :cond_1f

    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mFirstPosition:I

    move/from16 v25, v0

    if-nez v25, :cond_1c

    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mOverscrollDistance:I

    move/from16 v25, v0

    sub-int v25, v7, v25

    move/from16 v0, v25

    if-eq v10, v0, :cond_1f

    :cond_1c
    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mFirstPosition:I

    move/from16 v25, v0

    add-int v25, v25, v6

    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mItemCount:I

    move/from16 v26, v0

    move/from16 v0, v25

    move/from16 v1, v26

    if-ne v0, v1, :cond_1d

    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mOverscrollDistance:I

    move/from16 v25, v0

    add-int v25, v25, v8

    move/from16 v0, v16

    move/from16 v1, v25

    if-eq v0, v1, :cond_1f

    .line 3243
    :cond_1d
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mFlingRunnable:Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;

    move-object/from16 v25, v0

    if-nez v25, :cond_1e

    .line 3244
    new-instance v25, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;

    move-object/from16 v0, v25

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;-><init>(Lit/sephiroth/android/library/widget/AbsHListView;)V

    move-object/from16 v0, v25

    move-object/from16 v1, p0

    iput-object v0, v1, Lit/sephiroth/android/library/widget/AbsHListView;->mFlingRunnable:Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;

    .line 3246
    :cond_1e
    const/16 v25, 0x2

    move-object/from16 v0, p0

    move/from16 v1, v25

    invoke-virtual {v0, v1}, Lit/sephiroth/android/library/widget/AbsHListView;->reportScrollStateChange(I)V

    .line 3248
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mFlingRunnable:Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;

    move-object/from16 v25, v0

    neg-int v0, v15

    move/from16 v26, v0

    invoke-virtual/range {v25 .. v26}, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->start(I)V

    goto/16 :goto_4

    .line 3250
    :cond_1f
    const/16 v25, -0x1

    move/from16 v0, v25

    move-object/from16 v1, p0

    iput v0, v1, Lit/sephiroth/android/library/widget/AbsHListView;->mTouchMode:I

    .line 3251
    const/16 v25, 0x0

    move-object/from16 v0, p0

    move/from16 v1, v25

    invoke-virtual {v0, v1}, Lit/sephiroth/android/library/widget/AbsHListView;->reportScrollStateChange(I)V

    .line 3252
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mFlingRunnable:Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;

    move-object/from16 v25, v0

    if-eqz v25, :cond_20

    .line 3253
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mFlingRunnable:Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;

    move-object/from16 v25, v0

    invoke-virtual/range {v25 .. v25}, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->endFling()V

    .line 3255
    :cond_20
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mPositionScroller:Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;

    move-object/from16 v25, v0

    if-eqz v25, :cond_d

    .line 3256
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mPositionScroller:Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;

    move-object/from16 v25, v0

    invoke-virtual/range {v25 .. v25}, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->stop()V

    goto/16 :goto_4

    .line 3261
    .end local v7    # "contentLeft":I
    .end local v8    # "contentRight":I
    .end local v10    # "firstChildLeft":I
    .end local v15    # "initialVelocity":I
    .end local v16    # "lastChildRight":I
    .end local v22    # "velocityTracker":Landroid/view/VelocityTracker;
    :cond_21
    const/16 v25, -0x1

    move/from16 v0, v25

    move-object/from16 v1, p0

    iput v0, v1, Lit/sephiroth/android/library/widget/AbsHListView;->mTouchMode:I

    .line 3262
    const/16 v25, 0x0

    move-object/from16 v0, p0

    move/from16 v1, v25

    invoke-virtual {v0, v1}, Lit/sephiroth/android/library/widget/AbsHListView;->reportScrollStateChange(I)V

    goto/16 :goto_4

    .line 3267
    .end local v6    # "childCount":I
    :pswitch_b
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mFlingRunnable:Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;

    move-object/from16 v25, v0

    if-nez v25, :cond_22

    .line 3268
    new-instance v25, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;

    move-object/from16 v0, v25

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;-><init>(Lit/sephiroth/android/library/widget/AbsHListView;)V

    move-object/from16 v0, v25

    move-object/from16 v1, p0

    iput-object v0, v1, Lit/sephiroth/android/library/widget/AbsHListView;->mFlingRunnable:Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;

    .line 3270
    :cond_22
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mVelocityTracker:Landroid/view/VelocityTracker;

    move-object/from16 v22, v0

    .line 3271
    .restart local v22    # "velocityTracker":Landroid/view/VelocityTracker;
    const/16 v25, 0x3e8

    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mMaximumVelocity:I

    move/from16 v26, v0

    move/from16 v0, v26

    int-to-float v0, v0

    move/from16 v26, v0

    move-object/from16 v0, v22

    move/from16 v1, v25

    move/from16 v2, v26

    invoke-virtual {v0, v1, v2}, Landroid/view/VelocityTracker;->computeCurrentVelocity(IF)V

    .line 3272
    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mActivePointerId:I

    move/from16 v25, v0

    move-object/from16 v0, v22

    move/from16 v1, v25

    invoke-virtual {v0, v1}, Landroid/view/VelocityTracker;->getXVelocity(I)F

    move-result v25

    move/from16 v0, v25

    float-to-int v15, v0

    .line 3274
    .restart local v15    # "initialVelocity":I
    const/16 v25, 0x2

    move-object/from16 v0, p0

    move/from16 v1, v25

    invoke-virtual {v0, v1}, Lit/sephiroth/android/library/widget/AbsHListView;->reportScrollStateChange(I)V

    .line 3275
    invoke-static {v15}, Ljava/lang/Math;->abs(I)I

    move-result v25

    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mMinimumVelocity:I

    move/from16 v26, v0

    move/from16 v0, v25

    move/from16 v1, v26

    if-le v0, v1, :cond_23

    .line 3276
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mFlingRunnable:Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;

    move-object/from16 v25, v0

    neg-int v0, v15

    move/from16 v26, v0

    invoke-virtual/range {v25 .. v26}, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->startOverfling(I)V

    goto/16 :goto_4

    .line 3278
    :cond_23
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mFlingRunnable:Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;

    move-object/from16 v25, v0

    invoke-virtual/range {v25 .. v25}, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->startSpringback()V

    goto/16 :goto_4

    .line 3306
    .end local v15    # "initialVelocity":I
    .end local v22    # "velocityTracker":Landroid/view/VelocityTracker;
    :pswitch_c
    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mTouchMode:I

    move/from16 v25, v0

    packed-switch v25, :pswitch_data_4

    .line 3319
    const/16 v25, -0x1

    move/from16 v0, v25

    move-object/from16 v1, p0

    iput v0, v1, Lit/sephiroth/android/library/widget/AbsHListView;->mTouchMode:I

    .line 3320
    const/16 v25, 0x0

    move-object/from16 v0, p0

    move/from16 v1, v25

    invoke-virtual {v0, v1}, Lit/sephiroth/android/library/widget/AbsHListView;->setPressed(Z)V

    .line 3321
    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mMotionPosition:I

    move/from16 v25, v0

    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mFirstPosition:I

    move/from16 v26, v0

    sub-int v25, v25, v26

    move-object/from16 v0, p0

    move/from16 v1, v25

    invoke-virtual {v0, v1}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildAt(I)Landroid/view/View;

    move-result-object v18

    .line 3322
    .local v18, "motionView":Landroid/view/View;
    if-eqz v18, :cond_24

    .line 3323
    const/16 v25, 0x0

    move-object/from16 v0, v18

    move/from16 v1, v25

    invoke-virtual {v0, v1}, Landroid/view/View;->setPressed(Z)V

    .line 3325
    :cond_24
    invoke-direct/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->clearScrollingCache()V

    .line 3327
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getHandler()Landroid/os/Handler;

    move-result-object v11

    .line 3328
    .restart local v11    # "handler":Landroid/os/Handler;
    if-eqz v11, :cond_25

    .line 3329
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mPendingCheckForLongPress:Lit/sephiroth/android/library/widget/AbsHListView$CheckForLongPress;

    move-object/from16 v25, v0

    move-object/from16 v0, v25

    invoke-virtual {v11, v0}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 3332
    :cond_25
    invoke-direct/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->recycleVelocityTracker()V

    .line 3335
    .end local v11    # "handler":Landroid/os/Handler;
    .end local v18    # "motionView":Landroid/view/View;
    :goto_8
    :pswitch_d
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mEdgeGlowTop:Lit/sephiroth/android/library/widget/EdgeEffect;

    move-object/from16 v25, v0

    if-eqz v25, :cond_26

    .line 3336
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mEdgeGlowTop:Lit/sephiroth/android/library/widget/EdgeEffect;

    move-object/from16 v25, v0

    invoke-virtual/range {v25 .. v25}, Lit/sephiroth/android/library/widget/EdgeEffect;->onRelease()V

    .line 3337
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mEdgeGlowBottom:Lit/sephiroth/android/library/widget/EdgeEffect;

    move-object/from16 v25, v0

    invoke-virtual/range {v25 .. v25}, Lit/sephiroth/android/library/widget/EdgeEffect;->onRelease()V

    .line 3339
    :cond_26
    const/16 v25, -0x1

    move/from16 v0, v25

    move-object/from16 v1, p0

    iput v0, v1, Lit/sephiroth/android/library/widget/AbsHListView;->mActivePointerId:I

    goto/16 :goto_1

    .line 3308
    :pswitch_e
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mFlingRunnable:Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;

    move-object/from16 v25, v0

    if-nez v25, :cond_27

    .line 3309
    new-instance v25, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;

    move-object/from16 v0, v25

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;-><init>(Lit/sephiroth/android/library/widget/AbsHListView;)V

    move-object/from16 v0, v25

    move-object/from16 v1, p0

    iput-object v0, v1, Lit/sephiroth/android/library/widget/AbsHListView;->mFlingRunnable:Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;

    .line 3311
    :cond_27
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mFlingRunnable:Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;

    move-object/from16 v25, v0

    invoke-virtual/range {v25 .. v25}, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->startSpringback()V

    goto :goto_8

    .line 3344
    :pswitch_f
    invoke-direct/range {p0 .. p1}, Lit/sephiroth/android/library/widget/AbsHListView;->onSecondaryPointerUp(Landroid/view/MotionEvent;)V

    .line 3345
    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mMotionX:I

    move/from16 v23, v0

    .line 3346
    .local v23, "x":I
    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mMotionY:I

    move/from16 v24, v0

    .line 3347
    .restart local v24    # "y":I
    move-object/from16 v0, p0

    move/from16 v1, v23

    move/from16 v2, v24

    invoke-virtual {v0, v1, v2}, Lit/sephiroth/android/library/widget/AbsHListView;->pointToPosition(II)I

    move-result v17

    .line 3348
    .restart local v17    # "motionPosition":I
    if-ltz v17, :cond_28

    .line 3350
    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mFirstPosition:I

    move/from16 v25, v0

    sub-int v25, v17, v25

    move-object/from16 v0, p0

    move/from16 v1, v25

    invoke-virtual {v0, v1}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildAt(I)Landroid/view/View;

    move-result-object v21

    .line 3351
    .restart local v21    # "v":Landroid/view/View;
    invoke-virtual/range {v21 .. v21}, Landroid/view/View;->getLeft()I

    move-result v25

    move/from16 v0, v25

    move-object/from16 v1, p0

    iput v0, v1, Lit/sephiroth/android/library/widget/AbsHListView;->mMotionViewOriginalLeft:I

    .line 3352
    move/from16 v0, v17

    move-object/from16 v1, p0

    iput v0, v1, Lit/sephiroth/android/library/widget/AbsHListView;->mMotionPosition:I

    .line 3354
    .end local v21    # "v":Landroid/view/View;
    :cond_28
    move/from16 v0, v23

    move-object/from16 v1, p0

    iput v0, v1, Lit/sephiroth/android/library/widget/AbsHListView;->mLastX:I

    goto/16 :goto_1

    .line 3360
    .end local v17    # "motionPosition":I
    .end local v23    # "x":I
    .end local v24    # "y":I
    :pswitch_10
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getActionIndex()I

    move-result v14

    .line 3361
    .local v14, "index":I
    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getPointerId(I)I

    move-result v12

    .line 3362
    .local v12, "id":I
    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getX(I)F

    move-result v25

    move/from16 v0, v25

    float-to-int v0, v0

    move/from16 v23, v0

    .line 3363
    .restart local v23    # "x":I
    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/view/MotionEvent;->getY(I)F

    move-result v25

    move/from16 v0, v25

    float-to-int v0, v0

    move/from16 v24, v0

    .line 3364
    .restart local v24    # "y":I
    const/16 v25, 0x0

    move/from16 v0, v25

    move-object/from16 v1, p0

    iput v0, v1, Lit/sephiroth/android/library/widget/AbsHListView;->mMotionCorrection:I

    .line 3365
    move-object/from16 v0, p0

    iput v12, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mActivePointerId:I

    .line 3366
    move/from16 v0, v23

    move-object/from16 v1, p0

    iput v0, v1, Lit/sephiroth/android/library/widget/AbsHListView;->mMotionX:I

    .line 3367
    move/from16 v0, v24

    move-object/from16 v1, p0

    iput v0, v1, Lit/sephiroth/android/library/widget/AbsHListView;->mMotionY:I

    .line 3368
    move-object/from16 v0, p0

    move/from16 v1, v23

    move/from16 v2, v24

    invoke-virtual {v0, v1, v2}, Lit/sephiroth/android/library/widget/AbsHListView;->pointToPosition(II)I

    move-result v17

    .line 3369
    .restart local v17    # "motionPosition":I
    if-ltz v17, :cond_29

    .line 3371
    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mFirstPosition:I

    move/from16 v25, v0

    sub-int v25, v17, v25

    move-object/from16 v0, p0

    move/from16 v1, v25

    invoke-virtual {v0, v1}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildAt(I)Landroid/view/View;

    move-result-object v21

    .line 3372
    .restart local v21    # "v":Landroid/view/View;
    invoke-virtual/range {v21 .. v21}, Landroid/view/View;->getLeft()I

    move-result v25

    move/from16 v0, v25

    move-object/from16 v1, p0

    iput v0, v1, Lit/sephiroth/android/library/widget/AbsHListView;->mMotionViewOriginalLeft:I

    .line 3373
    move/from16 v0, v17

    move-object/from16 v1, p0

    iput v0, v1, Lit/sephiroth/android/library/widget/AbsHListView;->mMotionPosition:I

    .line 3375
    .end local v21    # "v":Landroid/view/View;
    :cond_29
    move/from16 v0, v23

    move-object/from16 v1, p0

    iput v0, v1, Lit/sephiroth/android/library/widget/AbsHListView;->mLastX:I

    goto/16 :goto_1

    .line 3045
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_7
        :pswitch_3
        :pswitch_c
        :pswitch_0
        :pswitch_10
        :pswitch_f
    .end packed-switch

    .line 3047
    :pswitch_data_1
    .packed-switch 0x6
        :pswitch_2
    .end packed-switch

    .line 3126
    :pswitch_data_2
    .packed-switch 0x0
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_6
        :pswitch_4
        :pswitch_6
    .end packed-switch

    .line 3143
    :pswitch_data_3
    .packed-switch 0x0
        :pswitch_9
        :pswitch_9
        :pswitch_9
        :pswitch_a
        :pswitch_8
        :pswitch_b
    .end packed-switch

    .line 3306
    :pswitch_data_4
    .packed-switch 0x5
        :pswitch_e
        :pswitch_d
    .end packed-switch
.end method

.method public onTouchModeChanged(Z)V
    .locals 3
    .param p1, "isInTouchMode"    # Z

    .prologue
    .line 2966
    if-eqz p1, :cond_2

    .line 2968
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->hideSelector()V

    .line 2972
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getWidth()I

    move-result v1

    if-lez v1, :cond_0

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildCount()I

    move-result v1

    if-lez v1, :cond_0

    .line 2975
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->layoutChildren()V

    .line 2977
    :cond_0
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->updateSelectorState()V

    .line 2995
    :cond_1
    :goto_0
    return-void

    .line 2979
    :cond_2
    iget v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mTouchMode:I

    .line 2980
    .local v0, "touchMode":I
    const/4 v1, 0x5

    if-eq v0, v1, :cond_3

    const/4 v1, 0x6

    if-ne v0, v1, :cond_1

    .line 2981
    :cond_3
    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mFlingRunnable:Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;

    if-eqz v1, :cond_4

    .line 2982
    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mFlingRunnable:Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;

    invoke-virtual {v1}, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->endFling()V

    .line 2984
    :cond_4
    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mPositionScroller:Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;

    if-eqz v1, :cond_5

    .line 2985
    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mPositionScroller:Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;

    invoke-virtual {v1}, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->stop()V

    .line 2988
    :cond_5
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getScrollX()I

    move-result v1

    if-eqz v1, :cond_1

    .line 2989
    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mViewHelper:Lit/sephiroth/android/library/util/ViewHelperFactory$ViewHelper;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lit/sephiroth/android/library/util/ViewHelperFactory$ViewHelper;->setScrollX(I)V

    .line 2990
    invoke-direct {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->finishGlows()V

    .line 2991
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->invalidate()V

    goto :goto_0
.end method

.method public onWindowFocusChanged(Z)V
    .locals 5
    .param p1, "hasWindowFocus"    # Z

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 2412
    invoke-super {p0, p1}, Lit/sephiroth/android/library/widget/AdapterView;->onWindowFocusChanged(Z)V

    .line 2414
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->isInTouchMode()Z

    move-result v3

    if-eqz v3, :cond_3

    move v0, v1

    .line 2416
    .local v0, "touchMode":I
    :goto_0
    if-nez p1, :cond_4

    .line 2417
    invoke-virtual {p0, v1}, Lit/sephiroth/android/library/widget/AbsHListView;->setChildrenDrawingCacheEnabled(Z)V

    .line 2418
    iget-object v3, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mFlingRunnable:Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;

    if-eqz v3, :cond_1

    .line 2419
    iget-object v3, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mFlingRunnable:Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;

    invoke-virtual {p0, v3}, Lit/sephiroth/android/library/widget/AbsHListView;->removeCallbacks(Ljava/lang/Runnable;)Z

    .line 2422
    iget-object v3, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mFlingRunnable:Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;

    invoke-virtual {v3}, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->endFling()V

    .line 2423
    iget-object v3, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mPositionScroller:Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;

    if-eqz v3, :cond_0

    .line 2424
    iget-object v3, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mPositionScroller:Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;

    invoke-virtual {v3}, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->stop()V

    .line 2426
    :cond_0
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getScrollX()I

    move-result v3

    if-eqz v3, :cond_1

    .line 2427
    iget-object v3, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mViewHelper:Lit/sephiroth/android/library/util/ViewHelperFactory$ViewHelper;

    invoke-virtual {v3, v1}, Lit/sephiroth/android/library/util/ViewHelperFactory$ViewHelper;->setScrollX(I)V

    .line 2428
    invoke-direct {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->finishGlows()V

    .line 2429
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->invalidate()V

    .line 2434
    :cond_1
    if-ne v0, v2, :cond_2

    .line 2436
    iget v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectedPosition:I

    iput v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mResurrectToPosition:I

    .line 2455
    :cond_2
    :goto_1
    iput v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mLastTouchMode:I

    .line 2456
    return-void

    .end local v0    # "touchMode":I
    :cond_3
    move v0, v2

    .line 2414
    goto :goto_0

    .line 2440
    .restart local v0    # "touchMode":I
    :cond_4
    iget v3, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mLastTouchMode:I

    if-eq v0, v3, :cond_2

    iget v3, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mLastTouchMode:I

    const/4 v4, -0x1

    if-eq v3, v4, :cond_2

    .line 2442
    if-ne v0, v2, :cond_5

    .line 2444
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->resurrectSelection()Z

    goto :goto_1

    .line 2448
    :cond_5
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->hideSelector()V

    .line 2449
    iput v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mLayoutMode:I

    .line 2450
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->layoutChildren()V

    goto :goto_1
.end method

.method public performAccessibilityAction(ILandroid/os/Bundle;)Z
    .locals 6
    .param p1, "action"    # I
    .param p2, "arguments"    # Landroid/os/Bundle;
    .annotation build Landroid/annotation/TargetApi;
        value = 0x10
    .end annotation

    .prologue
    const/16 v5, 0xc8

    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 1183
    invoke-super {p0, p1, p2}, Lit/sephiroth/android/library/widget/AdapterView;->performAccessibilityAction(ILandroid/os/Bundle;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 1204
    :goto_0
    return v1

    .line 1186
    :cond_0
    sparse-switch p1, :sswitch_data_0

    move v1, v2

    .line 1204
    goto :goto_0

    .line 1188
    :sswitch_0
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->isEnabled()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getLastVisiblePosition()I

    move-result v3

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getCount()I

    move-result v4

    add-int/lit8 v4, v4, -0x1

    if-ge v3, v4, :cond_1

    .line 1189
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getWidth()I

    move-result v2

    iget-object v3, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mListPadding:Landroid/graphics/Rect;

    iget v3, v3, Landroid/graphics/Rect;->left:I

    sub-int/2addr v2, v3

    iget-object v3, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mListPadding:Landroid/graphics/Rect;

    iget v3, v3, Landroid/graphics/Rect;->right:I

    sub-int v0, v2, v3

    .line 1190
    .local v0, "viewportWidth":I
    invoke-virtual {p0, v0, v5}, Lit/sephiroth/android/library/widget/AbsHListView;->smoothScrollBy(II)V

    goto :goto_0

    .end local v0    # "viewportWidth":I
    :cond_1
    move v1, v2

    .line 1194
    goto :goto_0

    .line 1196
    :sswitch_1
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->isEnabled()Z

    move-result v3

    if-eqz v3, :cond_2

    iget v3, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mFirstPosition:I

    if-lez v3, :cond_2

    .line 1197
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getWidth()I

    move-result v2

    iget-object v3, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mListPadding:Landroid/graphics/Rect;

    iget v3, v3, Landroid/graphics/Rect;->left:I

    sub-int/2addr v2, v3

    iget-object v3, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mListPadding:Landroid/graphics/Rect;

    iget v3, v3, Landroid/graphics/Rect;->right:I

    sub-int v0, v2, v3

    .line 1198
    .restart local v0    # "viewportWidth":I
    neg-int v2, v0

    invoke-virtual {p0, v2, v5}, Lit/sephiroth/android/library/widget/AbsHListView;->smoothScrollBy(II)V

    goto :goto_0

    .end local v0    # "viewportWidth":I
    :cond_2
    move v1, v2

    .line 1202
    goto :goto_0

    .line 1186
    nop

    :sswitch_data_0
    .sparse-switch
        0x1000 -> :sswitch_0
        0x2000 -> :sswitch_1
    .end sparse-switch
.end method

.method protected performButtonActionOnTouchDown(Landroid/view/MotionEvent;)Z
    .locals 3
    .param p1, "event"    # Landroid/view/MotionEvent;
    .annotation build Landroid/annotation/TargetApi;
        value = 0xe
    .end annotation

    .prologue
    .line 3007
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0xe

    if-lt v0, v1, :cond_0

    .line 3008
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getButtonState()I

    move-result v0

    and-int/lit8 v0, v0, 0x2

    if-eqz v0, :cond_0

    .line 3009
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v0

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v1

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getMetaState()I

    move-result v2

    invoke-virtual {p0, v0, v1, v2}, Lit/sephiroth/android/library/widget/AbsHListView;->showContextMenu(FFI)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 3010
    const/4 v0, 0x1

    .line 3014
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public performItemClick(Landroid/view/View;IJ)Z
    .locals 9
    .param p1, "view"    # Landroid/view/View;
    .param p2, "position"    # I
    .param p3, "id"    # J

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 920
    const/4 v8, 0x0

    .line 921
    .local v8, "handled":Z
    const/4 v7, 0x1

    .line 923
    .local v7, "dispatchItemClick":Z
    iget v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mChoiceMode:I

    if-eqz v1, :cond_4

    .line 924
    const/4 v8, 0x1

    .line 925
    const/4 v0, 0x0

    .line 927
    .local v0, "checkedStateChanged":Z
    iget v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mChoiceMode:I

    const/4 v4, 0x2

    if-eq v1, v4, :cond_0

    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v4, 0xb

    if-lt v1, v4, :cond_9

    iget v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mChoiceMode:I

    const/4 v4, 0x3

    if-ne v1, v4, :cond_9

    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mChoiceActionMode:Ljava/lang/Object;

    if-eqz v1, :cond_9

    .line 929
    :cond_0
    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckStates:Landroid/support/v4/util/SparseArrayCompat;

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    invoke-virtual {v1, p2, v4}, Landroid/support/v4/util/SparseArrayCompat;->get(ILjava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Boolean;

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    if-nez v1, :cond_6

    move v6, v2

    .line 930
    .local v6, "checked":Z
    :goto_0
    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckStates:Landroid/support/v4/util/SparseArrayCompat;

    invoke-static {v6}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-virtual {v1, p2, v2}, Landroid/support/v4/util/SparseArrayCompat;->put(ILjava/lang/Object;)V

    .line 931
    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckedIdStates:Landroid/support/v4/util/LongSparseArray;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v1}, Landroid/widget/ListAdapter;->hasStableIds()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 932
    if-eqz v6, :cond_7

    .line 933
    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckedIdStates:Landroid/support/v4/util/LongSparseArray;

    iget-object v2, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v2, p2}, Landroid/widget/ListAdapter;->getItemId(I)J

    move-result-wide v2

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v1, v2, v3, v4}, Landroid/support/v4/util/LongSparseArray;->put(JLjava/lang/Object;)V

    .line 938
    :cond_1
    :goto_1
    if-eqz v6, :cond_8

    .line 939
    iget v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckedItemCount:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckedItemCount:I

    .line 944
    :goto_2
    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mChoiceActionMode:Ljava/lang/Object;

    if-eqz v1, :cond_2

    .line 945
    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mMultiChoiceModeCallback:Ljava/lang/Object;

    check-cast v1, Lit/sephiroth/android/library/util/v11/MultiChoiceModeWrapper;

    iget-object v2, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mChoiceActionMode:Ljava/lang/Object;

    check-cast v2, Landroid/view/ActionMode;

    move v3, p2

    move-wide v4, p3

    invoke-virtual/range {v1 .. v6}, Lit/sephiroth/android/library/util/v11/MultiChoiceModeWrapper;->onItemCheckedStateChanged(Landroid/view/ActionMode;IJZ)V

    .line 946
    const/4 v7, 0x0

    .line 949
    :cond_2
    const/4 v0, 0x1

    .line 966
    .end local v6    # "checked":Z
    :cond_3
    :goto_3
    if-eqz v0, :cond_4

    .line 967
    invoke-direct {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->updateOnScreenCheckedViews()V

    .line 971
    .end local v0    # "checkedStateChanged":Z
    :cond_4
    if-eqz v7, :cond_5

    .line 972
    invoke-super {p0, p1, p2, p3, p4}, Lit/sephiroth/android/library/widget/AdapterView;->performItemClick(Landroid/view/View;IJ)Z

    move-result v1

    or-int/2addr v8, v1

    .line 975
    :cond_5
    return v8

    .restart local v0    # "checkedStateChanged":Z
    :cond_6
    move v6, v3

    .line 929
    goto :goto_0

    .line 935
    .restart local v6    # "checked":Z
    :cond_7
    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckedIdStates:Landroid/support/v4/util/LongSparseArray;

    iget-object v2, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v2, p2}, Landroid/widget/ListAdapter;->getItemId(I)J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Landroid/support/v4/util/LongSparseArray;->delete(J)V

    goto :goto_1

    .line 941
    :cond_8
    iget v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckedItemCount:I

    add-int/lit8 v1, v1, -0x1

    iput v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckedItemCount:I

    goto :goto_2

    .line 950
    .end local v6    # "checked":Z
    :cond_9
    iget v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mChoiceMode:I

    if-ne v1, v2, :cond_3

    .line 951
    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckStates:Landroid/support/v4/util/SparseArrayCompat;

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    invoke-virtual {v1, p2, v4}, Landroid/support/v4/util/SparseArrayCompat;->get(ILjava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Boolean;

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    if-nez v1, :cond_c

    move v6, v2

    .line 952
    .restart local v6    # "checked":Z
    :goto_4
    if-eqz v6, :cond_d

    .line 953
    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckStates:Landroid/support/v4/util/SparseArrayCompat;

    invoke-virtual {v1}, Landroid/support/v4/util/SparseArrayCompat;->clear()V

    .line 954
    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckStates:Landroid/support/v4/util/SparseArrayCompat;

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    invoke-virtual {v1, p2, v3}, Landroid/support/v4/util/SparseArrayCompat;->put(ILjava/lang/Object;)V

    .line 955
    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckedIdStates:Landroid/support/v4/util/LongSparseArray;

    if-eqz v1, :cond_a

    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v1}, Landroid/widget/ListAdapter;->hasStableIds()Z

    move-result v1

    if-eqz v1, :cond_a

    .line 956
    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckedIdStates:Landroid/support/v4/util/LongSparseArray;

    invoke-virtual {v1}, Landroid/support/v4/util/LongSparseArray;->clear()V

    .line 957
    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckedIdStates:Landroid/support/v4/util/LongSparseArray;

    iget-object v3, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v3, p2}, Landroid/widget/ListAdapter;->getItemId(I)J

    move-result-wide v4

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v1, v4, v5, v3}, Landroid/support/v4/util/LongSparseArray;->put(JLjava/lang/Object;)V

    .line 959
    :cond_a
    iput v2, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckedItemCount:I

    .line 963
    :cond_b
    :goto_5
    const/4 v0, 0x1

    goto :goto_3

    .end local v6    # "checked":Z
    :cond_c
    move v6, v3

    .line 951
    goto :goto_4

    .line 960
    .restart local v6    # "checked":Z
    :cond_d
    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckStates:Landroid/support/v4/util/SparseArrayCompat;

    invoke-virtual {v1}, Landroid/support/v4/util/SparseArrayCompat;->size()I

    move-result v1

    if-eqz v1, :cond_e

    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckStates:Landroid/support/v4/util/SparseArrayCompat;

    invoke-virtual {v1, v3}, Landroid/support/v4/util/SparseArrayCompat;->valueAt(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Boolean;

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    if-nez v1, :cond_b

    .line 961
    :cond_e
    iput v3, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckedItemCount:I

    goto :goto_5
.end method

.method performLongPress(Landroid/view/View;IJ)Z
    .locals 9
    .param p1, "child"    # Landroid/view/View;
    .param p2, "longPressPosition"    # I
    .param p3, "longPressId"    # J

    .prologue
    const/4 v6, 0x1

    const/4 v7, 0x0

    .line 2570
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0xb

    if-lt v0, v1, :cond_1

    .line 2571
    iget v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mChoiceMode:I

    const/4 v1, 0x3

    if-ne v0, v1, :cond_1

    .line 2572
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mChoiceActionMode:Ljava/lang/Object;

    if-nez v0, :cond_0

    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mMultiChoiceModeCallback:Ljava/lang/Object;

    check-cast v0, Lit/sephiroth/android/library/util/v11/MultiChoiceModeWrapper;

    invoke-virtual {p0, v0}, Lit/sephiroth/android/library/widget/AbsHListView;->startActionMode(Landroid/view/ActionMode$Callback;)Landroid/view/ActionMode;

    move-result-object v0

    iput-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mChoiceActionMode:Ljava/lang/Object;

    if-eqz v0, :cond_0

    .line 2574
    invoke-virtual {p0, p2, v6}, Lit/sephiroth/android/library/widget/AbsHListView;->setItemChecked(IZ)V

    .line 2575
    invoke-virtual {p0, v7}, Lit/sephiroth/android/library/widget/AbsHListView;->performHapticFeedback(I)Z

    .line 2593
    :cond_0
    :goto_0
    return v6

    .line 2581
    :cond_1
    const/4 v6, 0x0

    .line 2582
    .local v6, "handled":Z
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mOnItemLongClickListener:Lit/sephiroth/android/library/widget/AdapterView$OnItemLongClickListener;

    if-eqz v0, :cond_2

    .line 2583
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mOnItemLongClickListener:Lit/sephiroth/android/library/widget/AdapterView$OnItemLongClickListener;

    move-object v1, p0

    move-object v2, p1

    move v3, p2

    move-wide v4, p3

    invoke-interface/range {v0 .. v5}, Lit/sephiroth/android/library/widget/AdapterView$OnItemLongClickListener;->onItemLongClick(Lit/sephiroth/android/library/widget/AdapterView;Landroid/view/View;IJ)Z

    move-result v6

    .line 2586
    :cond_2
    if-nez v6, :cond_3

    .line 2587
    invoke-virtual {p0, p1, p2, p3, p4}, Lit/sephiroth/android/library/widget/AbsHListView;->createContextMenuInfo(Landroid/view/View;IJ)Landroid/view/ContextMenu$ContextMenuInfo;

    move-result-object v0

    iput-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mContextMenuInfo:Landroid/view/ContextMenu$ContextMenuInfo;

    .line 2588
    invoke-super {p0, p0}, Lit/sephiroth/android/library/widget/AdapterView;->showContextMenuForChild(Landroid/view/View;)Z

    move-result v6

    .line 2590
    :cond_3
    if-eqz v6, :cond_0

    .line 2591
    invoke-virtual {p0, v7}, Lit/sephiroth/android/library/widget/AbsHListView;->performHapticFeedback(I)Z

    goto :goto_0
.end method

.method public pointToPosition(II)I
    .locals 5
    .param p1, "x"    # I
    .param p2, "y"    # I

    .prologue
    .line 2684
    iget-object v2, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mTouchFrame:Landroid/graphics/Rect;

    .line 2685
    .local v2, "frame":Landroid/graphics/Rect;
    if-nez v2, :cond_0

    .line 2686
    new-instance v4, Landroid/graphics/Rect;

    invoke-direct {v4}, Landroid/graphics/Rect;-><init>()V

    iput-object v4, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mTouchFrame:Landroid/graphics/Rect;

    .line 2687
    iget-object v2, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mTouchFrame:Landroid/graphics/Rect;

    .line 2690
    :cond_0
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildCount()I

    move-result v1

    .line 2691
    .local v1, "count":I
    add-int/lit8 v3, v1, -0x1

    .local v3, "i":I
    :goto_0
    if-ltz v3, :cond_2

    .line 2692
    invoke-virtual {p0, v3}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 2693
    .local v0, "child":Landroid/view/View;
    invoke-virtual {v0}, Landroid/view/View;->getVisibility()I

    move-result v4

    if-nez v4, :cond_1

    .line 2694
    invoke-virtual {v0, v2}, Landroid/view/View;->getHitRect(Landroid/graphics/Rect;)V

    .line 2695
    invoke-virtual {v2, p1, p2}, Landroid/graphics/Rect;->contains(II)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 2696
    iget v4, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mFirstPosition:I

    add-int/2addr v4, v3

    .line 2700
    .end local v0    # "child":Landroid/view/View;
    :goto_1
    return v4

    .line 2691
    .restart local v0    # "child":Landroid/view/View;
    :cond_1
    add-int/lit8 v3, v3, -0x1

    goto :goto_0

    .line 2700
    .end local v0    # "child":Landroid/view/View;
    :cond_2
    const/4 v4, -0x1

    goto :goto_1
.end method

.method protected positionSelector(ILandroid/view/View;)V
    .locals 7
    .param p1, "position"    # I
    .param p2, "sel"    # Landroid/view/View;

    .prologue
    const/4 v6, -0x1

    .line 2083
    if-eq p1, v6, :cond_0

    .line 2084
    iput p1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectorPosition:I

    .line 2087
    :cond_0
    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectorRect:Landroid/graphics/Rect;

    .line 2088
    .local v1, "selectorRect":Landroid/graphics/Rect;
    invoke-virtual {p2}, Landroid/view/View;->getLeft()I

    move-result v2

    invoke-virtual {p2}, Landroid/view/View;->getTop()I

    move-result v3

    invoke-virtual {p2}, Landroid/view/View;->getRight()I

    move-result v4

    invoke-virtual {p2}, Landroid/view/View;->getBottom()I

    move-result v5

    invoke-virtual {v1, v2, v3, v4, v5}, Landroid/graphics/Rect;->set(IIII)V

    .line 2089
    instance-of v2, p2, Lit/sephiroth/android/library/widget/AbsHListView$SelectionBoundsAdjuster;

    if-eqz v2, :cond_1

    move-object v2, p2

    .line 2090
    check-cast v2, Lit/sephiroth/android/library/widget/AbsHListView$SelectionBoundsAdjuster;

    invoke-interface {v2, v1}, Lit/sephiroth/android/library/widget/AbsHListView$SelectionBoundsAdjuster;->adjustListItemSelectionBounds(Landroid/graphics/Rect;)V

    .line 2092
    :cond_1
    iget v2, v1, Landroid/graphics/Rect;->left:I

    iget v3, v1, Landroid/graphics/Rect;->top:I

    iget v4, v1, Landroid/graphics/Rect;->right:I

    iget v5, v1, Landroid/graphics/Rect;->bottom:I

    invoke-direct {p0, v2, v3, v4, v5}, Lit/sephiroth/android/library/widget/AbsHListView;->positionSelector(IIII)V

    .line 2095
    iget-boolean v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mIsChildViewEnabled:Z

    .line 2096
    .local v0, "isChildViewEnabled":Z
    invoke-virtual {p2}, Landroid/view/View;->isEnabled()Z

    move-result v2

    if-eq v2, v0, :cond_2

    .line 2097
    if-nez v0, :cond_3

    const/4 v2, 0x1

    :goto_0
    iput-boolean v2, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mIsChildViewEnabled:Z

    .line 2098
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getSelectedItemPosition()I

    move-result v2

    if-eq v2, v6, :cond_2

    .line 2099
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->refreshDrawableState()V

    .line 2102
    :cond_2
    return-void

    .line 2097
    :cond_3
    const/4 v2, 0x0

    goto :goto_0
.end method

.method protected reconcileSelectedPosition()I
    .locals 2

    .prologue
    .line 4777
    iget v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectedPosition:I

    .line 4778
    .local v0, "position":I
    if-gez v0, :cond_0

    .line 4779
    iget v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mResurrectToPosition:I

    .line 4781
    :cond_0
    const/4 v1, 0x0

    invoke-static {v1, v0}, Ljava/lang/Math;->max(II)I

    move-result v0

    .line 4782
    iget v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mItemCount:I

    add-int/lit8 v1, v1, -0x1

    invoke-static {v0, v1}, Ljava/lang/Math;->min(II)I

    move-result v0

    .line 4783
    return v0
.end method

.method reportScrollStateChange(I)V
    .locals 1
    .param p1, "newState"    # I

    .prologue
    .line 3660
    iget v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mLastScrollState:I

    if-eq p1, v0, :cond_0

    .line 3661
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mOnScrollListener:Lit/sephiroth/android/library/widget/AbsHListView$OnScrollListener;

    if-eqz v0, :cond_0

    .line 3662
    iput p1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mLastScrollState:I

    .line 3663
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mOnScrollListener:Lit/sephiroth/android/library/widget/AbsHListView$OnScrollListener;

    invoke-interface {v0, p0, p1}, Lit/sephiroth/android/library/widget/AbsHListView$OnScrollListener;->onScrollStateChanged(Lit/sephiroth/android/library/widget/AbsHListView;I)V

    .line 3666
    :cond_0
    return-void
.end method

.method public requestDisallowInterceptTouchEvent(Z)V
    .locals 0
    .param p1, "disallowIntercept"    # Z

    .prologue
    .line 3521
    if-eqz p1, :cond_0

    .line 3522
    invoke-direct {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->recycleVelocityTracker()V

    .line 3524
    :cond_0
    invoke-super {p0, p1}, Lit/sephiroth/android/library/widget/AdapterView;->requestDisallowInterceptTouchEvent(Z)V

    .line 3525
    return-void
.end method

.method public requestLayout()V
    .locals 1

    .prologue
    .line 1621
    iget-boolean v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mBlockLayoutRequests:Z

    if-nez v0, :cond_0

    iget-boolean v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mInLayout:Z

    if-nez v0, :cond_0

    .line 1622
    invoke-super {p0}, Lit/sephiroth/android/library/widget/AdapterView;->requestLayout()V

    .line 1624
    :cond_0
    return-void
.end method

.method requestLayoutIfNecessary()V
    .locals 1

    .prologue
    .line 1282
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildCount()I

    move-result v0

    if-lez v0, :cond_0

    .line 1283
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->resetList()V

    .line 1284
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->requestLayout()V

    .line 1285
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->invalidate()V

    .line 1287
    :cond_0
    return-void
.end method

.method protected resetList()V
    .locals 4

    .prologue
    const/4 v0, 0x0

    const/4 v3, 0x0

    const/4 v2, -0x1

    .line 1630
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->removeAllViewsInLayout()V

    .line 1631
    iput v3, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mFirstPosition:I

    .line 1632
    iput-boolean v3, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mDataChanged:Z

    .line 1633
    iput-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mPositionScrollAfterLayout:Ljava/lang/Runnable;

    .line 1634
    iput-boolean v3, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mNeedSync:Z

    .line 1635
    iput-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mPendingSync:Lit/sephiroth/android/library/widget/AbsHListView$SavedState;

    .line 1636
    iput v2, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mOldSelectedPosition:I

    .line 1637
    const-wide/high16 v0, -0x8000000000000000L

    iput-wide v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mOldSelectedColId:J

    .line 1638
    invoke-virtual {p0, v2}, Lit/sephiroth/android/library/widget/AbsHListView;->setSelectedPositionInt(I)V

    .line 1639
    invoke-virtual {p0, v2}, Lit/sephiroth/android/library/widget/AbsHListView;->setNextSelectedPositionInt(I)V

    .line 1640
    iput v3, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectedLeft:I

    .line 1641
    iput v2, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectorPosition:I

    .line 1642
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectorRect:Landroid/graphics/Rect;

    invoke-virtual {v0}, Landroid/graphics/Rect;->setEmpty()V

    .line 1643
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->invalidate()V

    .line 1644
    return-void
.end method

.method resurrectSelection()Z
    .locals 19

    .prologue
    .line 4847
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildCount()I

    move-result v2

    .line 4849
    .local v2, "childCount":I
    if-gtz v2, :cond_0

    .line 4850
    const/16 v17, 0x0

    .line 4944
    :goto_0
    return v17

    .line 4853
    :cond_0
    const/4 v12, 0x0

    .line 4855
    .local v12, "selectedLeft":I
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mListPadding:Landroid/graphics/Rect;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    iget v3, v0, Landroid/graphics/Rect;->left:I

    .line 4856
    .local v3, "childrenLeft":I
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getRight()I

    move-result v17

    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getLeft()I

    move-result v18

    sub-int v17, v17, v18

    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mListPadding:Landroid/graphics/Rect;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    iget v0, v0, Landroid/graphics/Rect;->right:I

    move/from16 v18, v0

    sub-int v4, v17, v18

    .line 4857
    .local v4, "childrenRight":I
    move-object/from16 v0, p0

    iget v6, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mFirstPosition:I

    .line 4858
    .local v6, "firstPosition":I
    move-object/from16 v0, p0

    iget v15, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mResurrectToPosition:I

    .line 4859
    .local v15, "toPosition":I
    const/4 v5, 0x1

    .line 4861
    .local v5, "down":Z
    if-lt v15, v6, :cond_4

    add-int v17, v6, v2

    move/from16 v0, v17

    if-ge v15, v0, :cond_4

    .line 4862
    move v13, v15

    .line 4864
    .local v13, "selectedPos":I
    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mFirstPosition:I

    move/from16 v17, v0

    sub-int v17, v13, v17

    move-object/from16 v0, p0

    move/from16 v1, v17

    invoke-virtual {v0, v1}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildAt(I)Landroid/view/View;

    move-result-object v11

    .line 4865
    .local v11, "selected":Landroid/view/View;
    invoke-virtual {v11}, Landroid/view/View;->getLeft()I

    move-result v12

    .line 4866
    invoke-virtual {v11}, Landroid/view/View;->getRight()I

    move-result v14

    .line 4869
    .local v14, "selectedRight":I
    if-ge v12, v3, :cond_3

    .line 4870
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getHorizontalFadingEdgeLength()I

    move-result v17

    add-int v12, v3, v17

    .line 4925
    .end local v11    # "selected":Landroid/view/View;
    .end local v14    # "selectedRight":I
    :cond_1
    :goto_1
    const/16 v17, -0x1

    move/from16 v0, v17

    move-object/from16 v1, p0

    iput v0, v1, Lit/sephiroth/android/library/widget/AbsHListView;->mResurrectToPosition:I

    .line 4926
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mFlingRunnable:Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Lit/sephiroth/android/library/widget/AbsHListView;->removeCallbacks(Ljava/lang/Runnable;)Z

    .line 4927
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mPositionScroller:Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;

    move-object/from16 v17, v0

    if-eqz v17, :cond_2

    .line 4928
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mPositionScroller:Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->stop()V

    .line 4930
    :cond_2
    const/16 v17, -0x1

    move/from16 v0, v17

    move-object/from16 v1, p0

    iput v0, v1, Lit/sephiroth/android/library/widget/AbsHListView;->mTouchMode:I

    .line 4931
    invoke-direct/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->clearScrollingCache()V

    .line 4932
    move-object/from16 v0, p0

    iput v12, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mSpecificLeft:I

    .line 4933
    move-object/from16 v0, p0

    invoke-virtual {v0, v13, v5}, Lit/sephiroth/android/library/widget/AbsHListView;->lookForSelectablePosition(IZ)I

    move-result v13

    .line 4934
    if-lt v13, v6, :cond_c

    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getLastVisiblePosition()I

    move-result v17

    move/from16 v0, v17

    if-gt v13, v0, :cond_c

    .line 4935
    const/16 v17, 0x4

    move/from16 v0, v17

    move-object/from16 v1, p0

    iput v0, v1, Lit/sephiroth/android/library/widget/AbsHListView;->mLayoutMode:I

    .line 4936
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->updateSelectorState()V

    .line 4937
    move-object/from16 v0, p0

    invoke-virtual {v0, v13}, Lit/sephiroth/android/library/widget/AbsHListView;->setSelectionInt(I)V

    .line 4938
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->invokeOnItemScrollListener()V

    .line 4942
    :goto_2
    const/16 v17, 0x0

    move-object/from16 v0, p0

    move/from16 v1, v17

    invoke-virtual {v0, v1}, Lit/sephiroth/android/library/widget/AbsHListView;->reportScrollStateChange(I)V

    .line 4944
    if-ltz v13, :cond_d

    const/16 v17, 0x1

    goto/16 :goto_0

    .line 4871
    .restart local v11    # "selected":Landroid/view/View;
    .restart local v14    # "selectedRight":I
    :cond_3
    if-le v14, v4, :cond_1

    .line 4872
    invoke-virtual {v11}, Landroid/view/View;->getMeasuredWidth()I

    move-result v17

    sub-int v17, v4, v17

    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getHorizontalFadingEdgeLength()I

    move-result v18

    sub-int v12, v17, v18

    goto :goto_1

    .line 4875
    .end local v11    # "selected":Landroid/view/View;
    .end local v13    # "selectedPos":I
    .end local v14    # "selectedRight":I
    :cond_4
    if-ge v15, v6, :cond_8

    .line 4877
    move v13, v6

    .line 4878
    .restart local v13    # "selectedPos":I
    const/4 v7, 0x0

    .local v7, "i":I
    :goto_3
    if-ge v7, v2, :cond_1

    .line 4879
    move-object/from16 v0, p0

    invoke-virtual {v0, v7}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildAt(I)Landroid/view/View;

    move-result-object v16

    .line 4880
    .local v16, "v":Landroid/view/View;
    invoke-virtual/range {v16 .. v16}, Landroid/view/View;->getLeft()I

    move-result v9

    .line 4882
    .local v9, "left":I
    if-nez v7, :cond_6

    .line 4884
    move v12, v9

    .line 4886
    if-gtz v6, :cond_5

    if-ge v9, v3, :cond_6

    .line 4889
    :cond_5
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getHorizontalFadingEdgeLength()I

    move-result v17

    add-int v3, v3, v17

    .line 4892
    :cond_6
    if-lt v9, v3, :cond_7

    .line 4894
    add-int v13, v6, v7

    .line 4895
    move v12, v9

    .line 4896
    goto/16 :goto_1

    .line 4878
    :cond_7
    add-int/lit8 v7, v7, 0x1

    goto :goto_3

    .line 4900
    .end local v7    # "i":I
    .end local v9    # "left":I
    .end local v13    # "selectedPos":I
    .end local v16    # "v":Landroid/view/View;
    :cond_8
    move-object/from16 v0, p0

    iget v8, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mItemCount:I

    .line 4901
    .local v8, "itemCount":I
    const/4 v5, 0x0

    .line 4902
    add-int v17, v6, v2

    add-int/lit8 v13, v17, -0x1

    .line 4904
    .restart local v13    # "selectedPos":I
    add-int/lit8 v7, v2, -0x1

    .restart local v7    # "i":I
    :goto_4
    if-ltz v7, :cond_1

    .line 4905
    move-object/from16 v0, p0

    invoke-virtual {v0, v7}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildAt(I)Landroid/view/View;

    move-result-object v16

    .line 4906
    .restart local v16    # "v":Landroid/view/View;
    invoke-virtual/range {v16 .. v16}, Landroid/view/View;->getLeft()I

    move-result v9

    .line 4907
    .restart local v9    # "left":I
    invoke-virtual/range {v16 .. v16}, Landroid/view/View;->getRight()I

    move-result v10

    .line 4909
    .local v10, "right":I
    add-int/lit8 v17, v2, -0x1

    move/from16 v0, v17

    if-ne v7, v0, :cond_a

    .line 4910
    move v12, v9

    .line 4911
    add-int v17, v6, v2

    move/from16 v0, v17

    if-lt v0, v8, :cond_9

    if-le v10, v4, :cond_a

    .line 4912
    :cond_9
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getHorizontalFadingEdgeLength()I

    move-result v17

    sub-int v4, v4, v17

    .line 4916
    :cond_a
    if-gt v10, v4, :cond_b

    .line 4917
    add-int v13, v6, v7

    .line 4918
    move v12, v9

    .line 4919
    goto/16 :goto_1

    .line 4904
    :cond_b
    add-int/lit8 v7, v7, -0x1

    goto :goto_4

    .line 4940
    .end local v7    # "i":I
    .end local v8    # "itemCount":I
    .end local v9    # "left":I
    .end local v10    # "right":I
    .end local v16    # "v":Landroid/view/View;
    :cond_c
    const/4 v13, -0x1

    goto :goto_2

    .line 4944
    :cond_d
    const/16 v17, 0x0

    goto/16 :goto_0
.end method

.method protected resurrectSelectionIfNeeded()Z
    .locals 1

    .prologue
    .line 4826
    iget v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectedPosition:I

    if-gez v0, :cond_0

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->resurrectSelection()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 4827
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->updateSelectorState()V

    .line 4828
    const/4 v0, 0x1

    .line 4830
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public sendAccessibilityEvent(I)V
    .locals 3
    .param p1, "eventType"    # I

    .prologue
    .line 1142
    const/16 v2, 0x1000

    if-ne p1, v2, :cond_1

    .line 1143
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getFirstVisiblePosition()I

    move-result v0

    .line 1144
    .local v0, "firstVisiblePosition":I
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getLastVisiblePosition()I

    move-result v1

    .line 1145
    .local v1, "lastVisiblePosition":I
    iget v2, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mLastAccessibilityScrollEventFromIndex:I

    if-ne v2, v0, :cond_0

    iget v2, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mLastAccessibilityScrollEventToIndex:I

    if-ne v2, v1, :cond_0

    .line 1154
    .end local v0    # "firstVisiblePosition":I
    .end local v1    # "lastVisiblePosition":I
    :goto_0
    return-void

    .line 1149
    .restart local v0    # "firstVisiblePosition":I
    .restart local v1    # "lastVisiblePosition":I
    :cond_0
    iput v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mLastAccessibilityScrollEventFromIndex:I

    .line 1150
    iput v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mLastAccessibilityScrollEventToIndex:I

    .line 1153
    .end local v0    # "firstVisiblePosition":I
    .end local v1    # "lastVisiblePosition":I
    :cond_1
    invoke-super {p0, p1}, Lit/sephiroth/android/library/widget/AdapterView;->sendAccessibilityEvent(I)V

    goto :goto_0
.end method

.method public bridge synthetic setAdapter(Landroid/widget/Adapter;)V
    .locals 0
    .param p1, "x0"    # Landroid/widget/Adapter;

    .prologue
    .line 58
    check-cast p1, Landroid/widget/ListAdapter;

    .end local p1    # "x0":Landroid/widget/Adapter;
    invoke-virtual {p0, p1}, Lit/sephiroth/android/library/widget/AbsHListView;->setAdapter(Landroid/widget/ListAdapter;)V

    return-void
.end method

.method public setAdapter(Landroid/widget/ListAdapter;)V
    .locals 1
    .param p1, "adapter"    # Landroid/widget/ListAdapter;

    .prologue
    .line 722
    if-eqz p1, :cond_0

    .line 723
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v0}, Landroid/widget/ListAdapter;->hasStableIds()Z

    move-result v0

    iput-boolean v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mAdapterHasStableIds:Z

    .line 724
    iget v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mChoiceMode:I

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mAdapterHasStableIds:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckedIdStates:Landroid/support/v4/util/LongSparseArray;

    if-nez v0, :cond_0

    .line 726
    new-instance v0, Landroid/support/v4/util/LongSparseArray;

    invoke-direct {v0}, Landroid/support/v4/util/LongSparseArray;-><init>()V

    iput-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckedIdStates:Landroid/support/v4/util/LongSparseArray;

    .line 730
    :cond_0
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckStates:Landroid/support/v4/util/SparseArrayCompat;

    if-eqz v0, :cond_1

    .line 731
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckStates:Landroid/support/v4/util/SparseArrayCompat;

    invoke-virtual {v0}, Landroid/support/v4/util/SparseArrayCompat;->clear()V

    .line 734
    :cond_1
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckedIdStates:Landroid/support/v4/util/LongSparseArray;

    if-eqz v0, :cond_2

    .line 735
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckedIdStates:Landroid/support/v4/util/LongSparseArray;

    invoke-virtual {v0}, Landroid/support/v4/util/LongSparseArray;->clear()V

    .line 737
    :cond_2
    return-void
.end method

.method public setCacheColorHint(I)V
    .locals 3
    .param p1, "color"    # I

    .prologue
    .line 5278
    iget v2, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCacheColorHint:I

    if-eq p1, v2, :cond_1

    .line 5279
    iput p1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCacheColorHint:I

    .line 5280
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildCount()I

    move-result v0

    .line 5281
    .local v0, "count":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v0, :cond_0

    .line 5282
    invoke-virtual {p0, v1}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    invoke-virtual {v2, p1}, Landroid/view/View;->setDrawingCacheBackgroundColor(I)V

    .line 5281
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 5284
    :cond_0
    iget-object v2, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mRecycler:Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;

    invoke-virtual {v2, p1}, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->setCacheColorHint(I)V

    .line 5286
    .end local v0    # "count":I
    .end local v1    # "i":I
    :cond_1
    return-void
.end method

.method public setChoiceMode(I)V
    .locals 2
    .param p1, "choiceMode"    # I
    .annotation build Landroid/annotation/TargetApi;
        value = 0xb
    .end annotation

    .prologue
    const/16 v1, 0xb

    .line 1017
    iput p1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mChoiceMode:I

    .line 1019
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    if-lt v0, v1, :cond_1

    .line 1020
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mChoiceActionMode:Ljava/lang/Object;

    if-eqz v0, :cond_1

    .line 1022
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    if-lt v0, v1, :cond_0

    .line 1023
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mChoiceActionMode:Ljava/lang/Object;

    check-cast v0, Landroid/view/ActionMode;

    invoke-virtual {v0}, Landroid/view/ActionMode;->finish()V

    .line 1025
    :cond_0
    const/4 v0, 0x0

    iput-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mChoiceActionMode:Ljava/lang/Object;

    .line 1029
    :cond_1
    iget v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mChoiceMode:I

    if-eqz v0, :cond_4

    .line 1030
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckStates:Landroid/support/v4/util/SparseArrayCompat;

    if-nez v0, :cond_2

    .line 1031
    new-instance v0, Landroid/support/v4/util/SparseArrayCompat;

    invoke-direct {v0}, Landroid/support/v4/util/SparseArrayCompat;-><init>()V

    iput-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckStates:Landroid/support/v4/util/SparseArrayCompat;

    .line 1033
    :cond_2
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckedIdStates:Landroid/support/v4/util/LongSparseArray;

    if-nez v0, :cond_3

    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mAdapter:Landroid/widget/ListAdapter;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v0}, Landroid/widget/ListAdapter;->hasStableIds()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 1034
    new-instance v0, Landroid/support/v4/util/LongSparseArray;

    invoke-direct {v0}, Landroid/support/v4/util/LongSparseArray;-><init>()V

    iput-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckedIdStates:Landroid/support/v4/util/LongSparseArray;

    .line 1037
    :cond_3
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    if-lt v0, v1, :cond_4

    .line 1038
    iget v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mChoiceMode:I

    const/4 v1, 0x3

    if-ne v0, v1, :cond_4

    .line 1039
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->clearChoices()V

    .line 1040
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lit/sephiroth/android/library/widget/AbsHListView;->setLongClickable(Z)V

    .line 1044
    :cond_4
    return-void
.end method

.method public setDrawSelectorOnTop(Z)V
    .locals 0
    .param p1, "onTop"    # Z

    .prologue
    .line 2200
    iput-boolean p1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mDrawSelectorOnTop:Z

    .line 2201
    return-void
.end method

.method public setFriction(F)V
    .locals 1
    .param p1, "friction"    # F

    .prologue
    .line 4358
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mFlingRunnable:Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;

    if-nez v0, :cond_0

    .line 4359
    new-instance v0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;

    invoke-direct {v0, p0}, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;-><init>(Lit/sephiroth/android/library/widget/AbsHListView;)V

    iput-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mFlingRunnable:Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;

    .line 4361
    :cond_0
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mFlingRunnable:Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;

    # getter for: Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->mScroller:Lit/sephiroth/android/library/widget/OverScroller;
    invoke-static {v0}, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->access$1000(Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;)Lit/sephiroth/android/library/widget/OverScroller;

    move-result-object v0

    invoke-virtual {v0, p1}, Lit/sephiroth/android/library/widget/OverScroller;->setFriction(F)V

    .line 4362
    return-void
.end method

.method public setItemChecked(IZ)V
    .locals 10
    .param p1, "position"    # I
    .param p2, "value"    # Z

    .prologue
    const/16 v9, 0xb

    const/4 v6, 0x3

    const/4 v8, 0x1

    const/4 v2, 0x0

    .line 848
    iget v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mChoiceMode:I

    if-nez v1, :cond_1

    .line 916
    :cond_0
    :goto_0
    return-void

    .line 853
    :cond_1
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    if-lt v1, v9, :cond_4

    .line 854
    if-eqz p2, :cond_4

    iget v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mChoiceMode:I

    if-ne v1, v6, :cond_4

    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mChoiceActionMode:Ljava/lang/Object;

    if-nez v1, :cond_4

    .line 855
    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mMultiChoiceModeCallback:Ljava/lang/Object;

    if-eqz v1, :cond_2

    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mMultiChoiceModeCallback:Ljava/lang/Object;

    check-cast v1, Lit/sephiroth/android/library/util/v11/MultiChoiceModeWrapper;

    invoke-virtual {v1}, Lit/sephiroth/android/library/util/v11/MultiChoiceModeWrapper;->hasWrappedCallback()Z

    move-result v1

    if-nez v1, :cond_3

    .line 857
    :cond_2
    new-instance v1, Ljava/lang/IllegalStateException;

    const-string v2, "AbsListView: attempted to start selection mode for CHOICE_MODE_MULTIPLE_MODAL but no choice mode callback was supplied. Call setMultiChoiceModeListener to set a callback."

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 861
    :cond_3
    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mMultiChoiceModeCallback:Ljava/lang/Object;

    check-cast v1, Lit/sephiroth/android/library/util/v11/MultiChoiceModeWrapper;

    invoke-virtual {p0, v1}, Lit/sephiroth/android/library/widget/AbsHListView;->startActionMode(Landroid/view/ActionMode$Callback;)Landroid/view/ActionMode;

    move-result-object v1

    iput-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mChoiceActionMode:Ljava/lang/Object;

    .line 865
    :cond_4
    iget v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mChoiceMode:I

    const/4 v3, 0x2

    if-eq v1, v3, :cond_5

    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    if-lt v1, v9, :cond_b

    iget v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mChoiceMode:I

    if-ne v1, v6, :cond_b

    .line 867
    :cond_5
    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckStates:Landroid/support/v4/util/SparseArrayCompat;

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-virtual {v1, p1, v2}, Landroid/support/v4/util/SparseArrayCompat;->get(ILjava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Boolean;

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    .line 868
    .local v0, "oldValue":Z
    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckStates:Landroid/support/v4/util/SparseArrayCompat;

    invoke-static {p2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-virtual {v1, p1, v2}, Landroid/support/v4/util/SparseArrayCompat;->put(ILjava/lang/Object;)V

    .line 869
    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckedIdStates:Landroid/support/v4/util/LongSparseArray;

    if-eqz v1, :cond_6

    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v1}, Landroid/widget/ListAdapter;->hasStableIds()Z

    move-result v1

    if-eqz v1, :cond_6

    .line 870
    if-eqz p2, :cond_9

    .line 871
    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckedIdStates:Landroid/support/v4/util/LongSparseArray;

    iget-object v2, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v2, p1}, Landroid/widget/ListAdapter;->getItemId(I)J

    move-result-wide v2

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v1, v2, v3, v6}, Landroid/support/v4/util/LongSparseArray;->put(JLjava/lang/Object;)V

    .line 876
    :cond_6
    :goto_1
    if-eq v0, p2, :cond_7

    .line 877
    if-eqz p2, :cond_a

    .line 878
    iget v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckedItemCount:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckedItemCount:I

    .line 883
    :cond_7
    :goto_2
    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mChoiceActionMode:Ljava/lang/Object;

    if-eqz v1, :cond_8

    .line 884
    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v1, p1}, Landroid/widget/ListAdapter;->getItemId(I)J

    move-result-wide v4

    .line 885
    .local v4, "id":J
    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mMultiChoiceModeCallback:Ljava/lang/Object;

    check-cast v1, Lit/sephiroth/android/library/util/v11/MultiChoiceModeWrapper;

    iget-object v2, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mChoiceActionMode:Ljava/lang/Object;

    check-cast v2, Landroid/view/ActionMode;

    move v3, p1

    move v6, p2

    invoke-virtual/range {v1 .. v6}, Lit/sephiroth/android/library/util/v11/MultiChoiceModeWrapper;->onItemCheckedStateChanged(Landroid/view/ActionMode;IJZ)V

    .line 911
    .end local v0    # "oldValue":Z
    .end local v4    # "id":J
    :cond_8
    :goto_3
    iget-boolean v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mInLayout:Z

    if-nez v1, :cond_0

    iget-boolean v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mBlockLayoutRequests:Z

    if-nez v1, :cond_0

    .line 912
    iput-boolean v8, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mDataChanged:Z

    .line 913
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->rememberSyncState()V

    .line 914
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->requestLayout()V

    goto/16 :goto_0

    .line 873
    .restart local v0    # "oldValue":Z
    :cond_9
    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckedIdStates:Landroid/support/v4/util/LongSparseArray;

    iget-object v2, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v2, p1}, Landroid/widget/ListAdapter;->getItemId(I)J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Landroid/support/v4/util/LongSparseArray;->delete(J)V

    goto :goto_1

    .line 880
    :cond_a
    iget v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckedItemCount:I

    add-int/lit8 v1, v1, -0x1

    iput v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckedItemCount:I

    goto :goto_2

    .line 888
    .end local v0    # "oldValue":Z
    :cond_b
    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckedIdStates:Landroid/support/v4/util/LongSparseArray;

    if-eqz v1, :cond_f

    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v1}, Landroid/widget/ListAdapter;->hasStableIds()Z

    move-result v1

    if-eqz v1, :cond_f

    move v7, v8

    .line 891
    .local v7, "updateIds":Z
    :goto_4
    if-nez p2, :cond_c

    invoke-virtual {p0, p1}, Lit/sephiroth/android/library/widget/AbsHListView;->isItemChecked(I)Z

    move-result v1

    if-eqz v1, :cond_d

    .line 892
    :cond_c
    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckStates:Landroid/support/v4/util/SparseArrayCompat;

    invoke-virtual {v1}, Landroid/support/v4/util/SparseArrayCompat;->clear()V

    .line 893
    if-eqz v7, :cond_d

    .line 894
    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckedIdStates:Landroid/support/v4/util/LongSparseArray;

    invoke-virtual {v1}, Landroid/support/v4/util/LongSparseArray;->clear()V

    .line 899
    :cond_d
    if-eqz p2, :cond_10

    .line 900
    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckStates:Landroid/support/v4/util/SparseArrayCompat;

    invoke-static {v8}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-virtual {v1, p1, v2}, Landroid/support/v4/util/SparseArrayCompat;->put(ILjava/lang/Object;)V

    .line 901
    if-eqz v7, :cond_e

    .line 902
    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckedIdStates:Landroid/support/v4/util/LongSparseArray;

    iget-object v2, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v2, p1}, Landroid/widget/ListAdapter;->getItemId(I)J

    move-result-wide v2

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v1, v2, v3, v6}, Landroid/support/v4/util/LongSparseArray;->put(JLjava/lang/Object;)V

    .line 904
    :cond_e
    iput v8, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckedItemCount:I

    goto :goto_3

    .end local v7    # "updateIds":Z
    :cond_f
    move v7, v2

    .line 888
    goto :goto_4

    .line 905
    .restart local v7    # "updateIds":Z
    :cond_10
    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckStates:Landroid/support/v4/util/SparseArrayCompat;

    invoke-virtual {v1}, Landroid/support/v4/util/SparseArrayCompat;->size()I

    move-result v1

    if-eqz v1, :cond_11

    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckStates:Landroid/support/v4/util/SparseArrayCompat;

    invoke-virtual {v1, v2}, Landroid/support/v4/util/SparseArrayCompat;->valueAt(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Boolean;

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    if-nez v1, :cond_8

    .line 906
    :cond_11
    iput v2, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mCheckedItemCount:I

    goto :goto_3
.end method

.method public setMultiChoiceModeListener(Lit/sephiroth/android/library/util/v11/MultiChoiceModeListener;)V
    .locals 2
    .param p1, "listener"    # Lit/sephiroth/android/library/util/v11/MultiChoiceModeListener;
    .annotation build Landroid/annotation/TargetApi;
        value = 0xb
    .end annotation

    .prologue
    .line 1057
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0xb

    if-lt v0, v1, :cond_1

    .line 1058
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mMultiChoiceModeCallback:Ljava/lang/Object;

    if-nez v0, :cond_0

    .line 1059
    new-instance v0, Lit/sephiroth/android/library/util/v11/MultiChoiceModeWrapper;

    invoke-direct {v0, p0}, Lit/sephiroth/android/library/util/v11/MultiChoiceModeWrapper;-><init>(Lit/sephiroth/android/library/widget/AbsHListView;)V

    iput-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mMultiChoiceModeCallback:Ljava/lang/Object;

    .line 1061
    :cond_0
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mMultiChoiceModeCallback:Ljava/lang/Object;

    check-cast v0, Lit/sephiroth/android/library/util/v11/MultiChoiceModeWrapper;

    invoke-virtual {v0, p1}, Lit/sephiroth/android/library/util/v11/MultiChoiceModeWrapper;->setWrapped(Lit/sephiroth/android/library/util/v11/MultiChoiceModeListener;)V

    .line 1065
    :goto_0
    return-void

    .line 1063
    :cond_1
    const-string v0, "AbsListView"

    const-string v1, "setMultiChoiceModeListener not supported for this version of Android"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method public setOnScrollListener(Lit/sephiroth/android/library/widget/AbsHListView$OnScrollListener;)V
    .locals 0
    .param p1, "l"    # Lit/sephiroth/android/library/widget/AbsHListView$OnScrollListener;

    .prologue
    .line 1123
    iput-object p1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mOnScrollListener:Lit/sephiroth/android/library/widget/AbsHListView$OnScrollListener;

    .line 1124
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->invokeOnItemScrollListener()V

    .line 1125
    return-void
.end method

.method public setOverScrollMode(I)V
    .locals 4
    .param p1, "mode"    # I

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x1

    .line 704
    const/4 v1, 0x2

    if-eq p1, v1, :cond_1

    .line 705
    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mEdgeGlowTop:Lit/sephiroth/android/library/widget/EdgeEffect;

    if-nez v1, :cond_0

    .line 706
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getContext()Landroid/content/Context;

    move-result-object v0

    .line 707
    .local v0, "context":Landroid/content/Context;
    new-instance v1, Lit/sephiroth/android/library/widget/EdgeEffect;

    invoke-direct {v1, v0, v2}, Lit/sephiroth/android/library/widget/EdgeEffect;-><init>(Landroid/content/Context;I)V

    iput-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mEdgeGlowTop:Lit/sephiroth/android/library/widget/EdgeEffect;

    .line 708
    new-instance v1, Lit/sephiroth/android/library/widget/EdgeEffect;

    invoke-direct {v1, v0, v2}, Lit/sephiroth/android/library/widget/EdgeEffect;-><init>(Landroid/content/Context;I)V

    iput-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mEdgeGlowBottom:Lit/sephiroth/android/library/widget/EdgeEffect;

    .line 714
    .end local v0    # "context":Landroid/content/Context;
    :cond_0
    :goto_0
    invoke-super {p0, p1}, Lit/sephiroth/android/library/widget/AdapterView;->setOverScrollMode(I)V

    .line 715
    return-void

    .line 711
    :cond_1
    iput-object v3, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mEdgeGlowTop:Lit/sephiroth/android/library/widget/EdgeEffect;

    .line 712
    iput-object v3, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mEdgeGlowBottom:Lit/sephiroth/android/library/widget/EdgeEffect;

    goto :goto_0
.end method

.method public setRecyclerListener(Lit/sephiroth/android/library/widget/AbsHListView$RecyclerListener;)V
    .locals 1
    .param p1, "listener"    # Lit/sephiroth/android/library/widget/AbsHListView$RecyclerListener;

    .prologue
    .line 5356
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mRecycler:Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;

    # setter for: Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mRecyclerListener:Lit/sephiroth/android/library/widget/AbsHListView$RecyclerListener;
    invoke-static {v0, p1}, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->access$2202(Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;Lit/sephiroth/android/library/widget/AbsHListView$RecyclerListener;)Lit/sephiroth/android/library/widget/AbsHListView$RecyclerListener;

    .line 5357
    return-void
.end method

.method public setScrollingCacheEnabled(Z)V
    .locals 1
    .param p1, "enabled"    # Z

    .prologue
    .line 1235
    iget-boolean v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mScrollingCacheEnabled:Z

    if-eqz v0, :cond_0

    if-nez p1, :cond_0

    .line 1236
    invoke-direct {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->clearScrollingCache()V

    .line 1238
    :cond_0
    iput-boolean p1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mScrollingCacheEnabled:Z

    .line 1239
    return-void
.end method

.method public abstract setSelectionInt(I)V
.end method

.method public setSelector(I)V
    .locals 1
    .param p1, "resID"    # I

    .prologue
    .line 2212
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    invoke-virtual {p0, v0}, Lit/sephiroth/android/library/widget/AbsHListView;->setSelector(Landroid/graphics/drawable/Drawable;)V

    .line 2213
    return-void
.end method

.method public setSelector(Landroid/graphics/drawable/Drawable;)V
    .locals 3
    .param p1, "sel"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 2216
    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelector:Landroid/graphics/drawable/Drawable;

    if-eqz v1, :cond_0

    .line 2217
    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelector:Landroid/graphics/drawable/Drawable;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/graphics/drawable/Drawable;->setCallback(Landroid/graphics/drawable/Drawable$Callback;)V

    .line 2218
    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelector:Landroid/graphics/drawable/Drawable;

    invoke-virtual {p0, v1}, Lit/sephiroth/android/library/widget/AbsHListView;->unscheduleDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 2220
    :cond_0
    iput-object p1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelector:Landroid/graphics/drawable/Drawable;

    .line 2221
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    .line 2222
    .local v0, "padding":Landroid/graphics/Rect;
    invoke-virtual {p1, v0}, Landroid/graphics/drawable/Drawable;->getPadding(Landroid/graphics/Rect;)Z

    .line 2223
    iget v1, v0, Landroid/graphics/Rect;->left:I

    iput v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectionLeftPadding:I

    .line 2224
    iget v1, v0, Landroid/graphics/Rect;->top:I

    iput v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectionTopPadding:I

    .line 2225
    iget v1, v0, Landroid/graphics/Rect;->right:I

    iput v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectionRightPadding:I

    .line 2226
    iget v1, v0, Landroid/graphics/Rect;->bottom:I

    iput v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectionBottomPadding:I

    .line 2227
    invoke-virtual {p1, p0}, Landroid/graphics/drawable/Drawable;->setCallback(Landroid/graphics/drawable/Drawable$Callback;)V

    .line 2228
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->updateSelectorState()V

    .line 2229
    return-void
.end method

.method public setSmoothScrollbarEnabled(Z)V
    .locals 0
    .param p1, "enabled"    # Z

    .prologue
    .line 1101
    iput-boolean p1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSmoothScrollbarEnabled:Z

    .line 1102
    return-void
.end method

.method public setStackFromRight(Z)V
    .locals 1
    .param p1, "stackFromRight"    # Z

    .prologue
    .line 1275
    iget-boolean v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mStackFromRight:Z

    if-eq v0, p1, :cond_0

    .line 1276
    iput-boolean p1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mStackFromRight:Z

    .line 1277
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->requestLayoutIfNecessary()V

    .line 1279
    :cond_0
    return-void
.end method

.method public setTranscriptMode(I)V
    .locals 0
    .param p1, "mode"    # I

    .prologue
    .line 5250
    iput p1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mTranscriptMode:I

    .line 5251
    return-void
.end method

.method public setVelocityScale(F)V
    .locals 0
    .param p1, "scale"    # F

    .prologue
    .line 4371
    iput p1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mVelocityScale:F

    .line 4372
    return-void
.end method

.method protected setVisibleRangeHint(II)V
    .locals 0
    .param p1, "start"    # I
    .param p2, "end"    # I

    .prologue
    .line 5343
    return-void
.end method

.method protected shouldShowSelector()Z
    .locals 1

    .prologue
    .line 2180
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->hasFocus()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->isInTouchMode()Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->touchModeDrawsInPressedState()Z

    move-result v0

    if-eqz v0, :cond_2

    :cond_1
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_2
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public showContextMenu(FFI)Z
    .locals 6
    .param p1, "x"    # F
    .param p2, "y"    # F
    .param p3, "metaState"    # I

    .prologue
    .line 2602
    float-to-int v4, p1

    float-to-int v5, p2

    invoke-virtual {p0, v4, v5}, Lit/sephiroth/android/library/widget/AbsHListView;->pointToPosition(II)I

    move-result v1

    .line 2603
    .local v1, "position":I
    const/4 v4, -0x1

    if-eq v1, v4, :cond_0

    .line 2604
    iget-object v4, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v4, v1}, Landroid/widget/ListAdapter;->getItemId(I)J

    move-result-wide v2

    .line 2605
    .local v2, "id":J
    iget v4, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mFirstPosition:I

    sub-int v4, v1, v4

    invoke-virtual {p0, v4}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 2606
    .local v0, "child":Landroid/view/View;
    if-eqz v0, :cond_0

    .line 2607
    invoke-virtual {p0, v0, v1, v2, v3}, Lit/sephiroth/android/library/widget/AbsHListView;->createContextMenuInfo(Landroid/view/View;IJ)Landroid/view/ContextMenu$ContextMenuInfo;

    move-result-object v4

    iput-object v4, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mContextMenuInfo:Landroid/view/ContextMenu$ContextMenuInfo;

    .line 2608
    invoke-super {p0, p0}, Lit/sephiroth/android/library/widget/AdapterView;->showContextMenuForChild(Landroid/view/View;)Z

    move-result v4

    .line 2611
    .end local v0    # "child":Landroid/view/View;
    .end local v2    # "id":J
    :goto_0
    return v4

    :cond_0
    invoke-virtual {p0, p1, p2, p3}, Lit/sephiroth/android/library/widget/AbsHListView;->showContextMenu(FFI)Z

    move-result v4

    goto :goto_0
.end method

.method public showContextMenuForChild(Landroid/view/View;)Z
    .locals 7
    .param p1, "originalView"    # Landroid/view/View;

    .prologue
    .line 2616
    invoke-virtual {p0, p1}, Lit/sephiroth/android/library/widget/AbsHListView;->getPositionForView(Landroid/view/View;)I

    move-result v3

    .line 2617
    .local v3, "longPressPosition":I
    if-ltz v3, :cond_2

    .line 2618
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v0, v3}, Landroid/widget/ListAdapter;->getItemId(I)J

    move-result-wide v4

    .line 2619
    .local v4, "longPressId":J
    const/4 v6, 0x0

    .line 2621
    .local v6, "handled":Z
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mOnItemLongClickListener:Lit/sephiroth/android/library/widget/AdapterView$OnItemLongClickListener;

    if-eqz v0, :cond_0

    .line 2622
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mOnItemLongClickListener:Lit/sephiroth/android/library/widget/AdapterView$OnItemLongClickListener;

    move-object v1, p0

    move-object v2, p1

    invoke-interface/range {v0 .. v5}, Lit/sephiroth/android/library/widget/AdapterView$OnItemLongClickListener;->onItemLongClick(Lit/sephiroth/android/library/widget/AdapterView;Landroid/view/View;IJ)Z

    move-result v6

    .line 2625
    :cond_0
    if-nez v6, :cond_1

    .line 2626
    iget v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mFirstPosition:I

    sub-int v0, v3, v0

    invoke-virtual {p0, v0}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {p0, v0, v3, v4, v5}, Lit/sephiroth/android/library/widget/AbsHListView;->createContextMenuInfo(Landroid/view/View;IJ)Landroid/view/ContextMenu$ContextMenuInfo;

    move-result-object v0

    iput-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mContextMenuInfo:Landroid/view/ContextMenu$ContextMenuInfo;

    .line 2629
    invoke-super {p0, p1}, Lit/sephiroth/android/library/widget/AdapterView;->showContextMenuForChild(Landroid/view/View;)Z

    move-result v6

    .line 2634
    .end local v4    # "longPressId":J
    .end local v6    # "handled":Z
    :cond_1
    :goto_0
    return v6

    :cond_2
    const/4 v6, 0x0

    goto :goto_0
.end method

.method public smoothScrollBy(II)V
    .locals 1
    .param p1, "distance"    # I
    .param p2, "duration"    # I

    .prologue
    .line 4449
    const/4 v0, 0x0

    invoke-virtual {p0, p1, p2, v0}, Lit/sephiroth/android/library/widget/AbsHListView;->smoothScrollBy(IIZ)V

    .line 4450
    return-void
.end method

.method public smoothScrollBy(IIZ)V
    .locals 7
    .param p1, "distance"    # I
    .param p2, "duration"    # I
    .param p3, "linear"    # Z

    .prologue
    .line 4453
    iget-object v5, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mFlingRunnable:Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;

    if-nez v5, :cond_0

    .line 4454
    new-instance v5, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;

    invoke-direct {v5, p0}, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;-><init>(Lit/sephiroth/android/library/widget/AbsHListView;)V

    iput-object v5, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mFlingRunnable:Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;

    .line 4458
    :cond_0
    iget v1, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mFirstPosition:I

    .line 4459
    .local v1, "firstPos":I
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildCount()I

    move-result v0

    .line 4460
    .local v0, "childCount":I
    add-int v2, v1, v0

    .line 4461
    .local v2, "lastPos":I
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getPaddingLeft()I

    move-result v3

    .line 4462
    .local v3, "leftLimit":I
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getWidth()I

    move-result v5

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getPaddingRight()I

    move-result v6

    sub-int v4, v5, v6

    .line 4464
    .local v4, "rightLimit":I
    if-eqz p1, :cond_2

    iget v5, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mItemCount:I

    if-eqz v5, :cond_2

    if-eqz v0, :cond_2

    if-nez v1, :cond_1

    const/4 v5, 0x0

    invoke-virtual {p0, v5}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildAt(I)Landroid/view/View;

    move-result-object v5

    invoke-virtual {v5}, Landroid/view/View;->getLeft()I

    move-result v5

    if-ne v5, v3, :cond_1

    if-ltz p1, :cond_2

    :cond_1
    iget v5, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mItemCount:I

    if-ne v2, v5, :cond_4

    add-int/lit8 v5, v0, -0x1

    invoke-virtual {p0, v5}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildAt(I)Landroid/view/View;

    move-result-object v5

    invoke-virtual {v5}, Landroid/view/View;->getRight()I

    move-result v5

    if-ne v5, v4, :cond_4

    if-lez p1, :cond_4

    .line 4468
    :cond_2
    iget-object v5, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mFlingRunnable:Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;

    invoke-virtual {v5}, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->endFling()V

    .line 4469
    iget-object v5, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mPositionScroller:Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;

    if-eqz v5, :cond_3

    .line 4470
    iget-object v5, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mPositionScroller:Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;

    invoke-virtual {v5}, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->stop()V

    .line 4476
    :cond_3
    :goto_0
    return-void

    .line 4473
    :cond_4
    const/4 v5, 0x2

    invoke-virtual {p0, v5}, Lit/sephiroth/android/library/widget/AbsHListView;->reportScrollStateChange(I)V

    .line 4474
    iget-object v5, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mFlingRunnable:Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;

    invoke-virtual {v5, p1, p2, p3}, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->startScroll(IIZ)V

    goto :goto_0
.end method

.method public smoothScrollToPosition(II)V
    .locals 1
    .param p1, "position"    # I
    .param p2, "boundPosition"    # I

    .prologue
    .line 4434
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mPositionScroller:Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;

    if-nez v0, :cond_0

    .line 4435
    new-instance v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;

    invoke-direct {v0, p0}, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;-><init>(Lit/sephiroth/android/library/widget/AbsHListView;)V

    iput-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mPositionScroller:Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;

    .line 4437
    :cond_0
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mPositionScroller:Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;

    invoke-virtual {v0, p1, p2}, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->start(II)V

    .line 4438
    return-void
.end method

.method touchModeDrawsInPressedState()Z
    .locals 1

    .prologue
    .line 2164
    iget v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mTouchMode:I

    packed-switch v0, :pswitch_data_0

    .line 2169
    const/4 v0, 0x0

    :goto_0
    return v0

    .line 2167
    :pswitch_0
    const/4 v0, 0x1

    goto :goto_0

    .line 2164
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_0
    .end packed-switch
.end method

.method trackMotionScroll(II)Z
    .locals 31
    .param p1, "deltaX"    # I
    .param p2, "incrementalDeltaX"    # I

    .prologue
    .line 4557
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildCount()I

    move-result v8

    .line 4558
    .local v8, "childCount":I
    if-nez v8, :cond_0

    .line 4559
    const/16 v29, 0x1

    .line 4714
    :goto_0
    return v29

    .line 4562
    :cond_0
    const/16 v29, 0x0

    move-object/from16 v0, p0

    move/from16 v1, v29

    invoke-virtual {v0, v1}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildAt(I)Landroid/view/View;

    move-result-object v29

    invoke-virtual/range {v29 .. v29}, Landroid/view/View;->getLeft()I

    move-result v15

    .line 4563
    .local v15, "firstLeft":I
    add-int/lit8 v29, v8, -0x1

    move-object/from16 v0, p0

    move/from16 v1, v29

    invoke-virtual {v0, v1}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildAt(I)Landroid/view/View;

    move-result-object v29

    invoke-virtual/range {v29 .. v29}, Landroid/view/View;->getRight()I

    move-result v21

    .line 4565
    .local v21, "lastRight":I
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mListPadding:Landroid/graphics/Rect;

    move-object/from16 v22, v0

    .line 4570
    .local v22, "listPadding":Landroid/graphics/Rect;
    const/4 v12, 0x0

    .line 4571
    .local v12, "effectivePaddingLeft":I
    const/4 v13, 0x0

    .line 4579
    .local v13, "effectivePaddingRight":I
    sub-int v25, v12, v15

    .line 4580
    .local v25, "spaceBefore":I
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getWidth()I

    move-result v29

    sub-int v14, v29, v13

    .line 4581
    .local v14, "end":I
    sub-int v24, v21, v14

    .line 4583
    .local v24, "spaceAfter":I
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getWidth()I

    move-result v29

    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getPaddingRight()I

    move-result v30

    sub-int v29, v29, v30

    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getPaddingLeft()I

    move-result v30

    sub-int v28, v29, v30

    .line 4584
    .local v28, "width":I
    if-gez p1, :cond_2

    .line 4585
    add-int/lit8 v29, v28, -0x1

    move/from16 v0, v29

    neg-int v0, v0

    move/from16 v29, v0

    move/from16 v0, v29

    move/from16 v1, p1

    invoke-static {v0, v1}, Ljava/lang/Math;->max(II)I

    move-result p1

    .line 4590
    :goto_1
    if-gez p2, :cond_3

    .line 4591
    add-int/lit8 v29, v28, -0x1

    move/from16 v0, v29

    neg-int v0, v0

    move/from16 v29, v0

    move/from16 v0, v29

    move/from16 v1, p2

    invoke-static {v0, v1}, Ljava/lang/Math;->max(II)I

    move-result p2

    .line 4596
    :goto_2
    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mFirstPosition:I

    move/from16 v16, v0

    .line 4599
    .local v16, "firstPosition":I
    if-nez v16, :cond_4

    .line 4600
    move-object/from16 v0, v22

    iget v0, v0, Landroid/graphics/Rect;->left:I

    move/from16 v29, v0

    sub-int v29, v15, v29

    move/from16 v0, v29

    move-object/from16 v1, p0

    iput v0, v1, Lit/sephiroth/android/library/widget/AbsHListView;->mFirstPositionDistanceGuess:I

    .line 4604
    :goto_3
    add-int v29, v16, v8

    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mItemCount:I

    move/from16 v30, v0

    move/from16 v0, v29

    move/from16 v1, v30

    if-ne v0, v1, :cond_5

    .line 4605
    move-object/from16 v0, v22

    iget v0, v0, Landroid/graphics/Rect;->right:I

    move/from16 v29, v0

    add-int v29, v29, v21

    move/from16 v0, v29

    move-object/from16 v1, p0

    iput v0, v1, Lit/sephiroth/android/library/widget/AbsHListView;->mLastPositionDistanceGuess:I

    .line 4610
    :goto_4
    if-nez v16, :cond_6

    move-object/from16 v0, v22

    iget v0, v0, Landroid/graphics/Rect;->left:I

    move/from16 v29, v0

    move/from16 v0, v29

    if-lt v15, v0, :cond_6

    if-ltz p2, :cond_6

    const/4 v6, 0x1

    .line 4611
    .local v6, "cannotScrollRight":Z
    :goto_5
    add-int v29, v16, v8

    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mItemCount:I

    move/from16 v30, v0

    move/from16 v0, v29

    move/from16 v1, v30

    if-ne v0, v1, :cond_7

    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getWidth()I

    move-result v29

    move-object/from16 v0, v22

    iget v0, v0, Landroid/graphics/Rect;->right:I

    move/from16 v30, v0

    sub-int v29, v29, v30

    move/from16 v0, v21

    move/from16 v1, v29

    if-gt v0, v1, :cond_7

    if-gtz p2, :cond_7

    const/4 v5, 0x1

    .line 4613
    .local v5, "cannotScrollLeft":Z
    :goto_6
    if-nez v6, :cond_1

    if-eqz v5, :cond_9

    .line 4614
    :cond_1
    if-eqz p2, :cond_8

    const/16 v29, 0x1

    goto/16 :goto_0

    .line 4587
    .end local v5    # "cannotScrollLeft":Z
    .end local v6    # "cannotScrollRight":Z
    .end local v16    # "firstPosition":I
    :cond_2
    add-int/lit8 v29, v28, -0x1

    move/from16 v0, v29

    move/from16 v1, p1

    invoke-static {v0, v1}, Ljava/lang/Math;->min(II)I

    move-result p1

    goto/16 :goto_1

    .line 4593
    :cond_3
    add-int/lit8 v29, v28, -0x1

    move/from16 v0, v29

    move/from16 v1, p2

    invoke-static {v0, v1}, Ljava/lang/Math;->min(II)I

    move-result p2

    goto/16 :goto_2

    .line 4602
    .restart local v16    # "firstPosition":I
    :cond_4
    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mFirstPositionDistanceGuess:I

    move/from16 v29, v0

    add-int v29, v29, p2

    move/from16 v0, v29

    move-object/from16 v1, p0

    iput v0, v1, Lit/sephiroth/android/library/widget/AbsHListView;->mFirstPositionDistanceGuess:I

    goto :goto_3

    .line 4607
    :cond_5
    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mLastPositionDistanceGuess:I

    move/from16 v29, v0

    add-int v29, v29, p2

    move/from16 v0, v29

    move-object/from16 v1, p0

    iput v0, v1, Lit/sephiroth/android/library/widget/AbsHListView;->mLastPositionDistanceGuess:I

    goto :goto_4

    .line 4610
    :cond_6
    const/4 v6, 0x0

    goto :goto_5

    .line 4611
    .restart local v6    # "cannotScrollRight":Z
    :cond_7
    const/4 v5, 0x0

    goto :goto_6

    .line 4614
    .restart local v5    # "cannotScrollLeft":Z
    :cond_8
    const/16 v29, 0x0

    goto/16 :goto_0

    .line 4617
    :cond_9
    if-gez p2, :cond_12

    const/4 v11, 0x1

    .line 4619
    .local v11, "down":Z
    :goto_7
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->isInTouchMode()Z

    move-result v20

    .line 4620
    .local v20, "inTouchMode":Z
    if-eqz v20, :cond_a

    .line 4621
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->hideSelector()V

    .line 4624
    :cond_a
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getHeaderViewsCount()I

    move-result v18

    .line 4625
    .local v18, "headerViewsCount":I
    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mItemCount:I

    move/from16 v29, v0

    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getFooterViewsCount()I

    move-result v30

    sub-int v17, v29, v30

    .line 4627
    .local v17, "footerViewsStart":I
    const/16 v26, 0x0

    .line 4628
    .local v26, "start":I
    const/4 v10, 0x0

    .line 4630
    .local v10, "count":I
    if-eqz v11, :cond_15

    .line 4631
    move/from16 v0, p2

    neg-int v0, v0

    move/from16 v27, v0

    .line 4637
    .local v27, "top":I
    const/16 v19, 0x0

    .local v19, "i":I
    :goto_8
    move/from16 v0, v19

    if-ge v0, v8, :cond_b

    .line 4638
    move-object/from16 v0, p0

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildAt(I)Landroid/view/View;

    move-result-object v7

    .line 4639
    .local v7, "child":Landroid/view/View;
    invoke-virtual {v7}, Landroid/view/View;->getRight()I

    move-result v29

    move/from16 v0, v29

    move/from16 v1, v27

    if-lt v0, v1, :cond_13

    .line 4670
    .end local v7    # "child":Landroid/view/View;
    .end local v27    # "top":I
    :cond_b
    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mMotionViewOriginalLeft:I

    move/from16 v29, v0

    add-int v29, v29, p1

    move/from16 v0, v29

    move-object/from16 v1, p0

    iput v0, v1, Lit/sephiroth/android/library/widget/AbsHListView;->mMotionViewNewLeft:I

    .line 4672
    const/16 v29, 0x1

    move/from16 v0, v29

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lit/sephiroth/android/library/widget/AbsHListView;->mBlockLayoutRequests:Z

    .line 4674
    if-lez v10, :cond_c

    .line 4675
    move-object/from16 v0, p0

    move/from16 v1, v26

    invoke-virtual {v0, v1, v10}, Lit/sephiroth/android/library/widget/AbsHListView;->detachViewsFromParent(II)V

    .line 4676
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mRecycler:Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;

    move-object/from16 v29, v0

    invoke-virtual/range {v29 .. v29}, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->removeSkippedScrap()V

    .line 4681
    :cond_c
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->awakenScrollBars()Z

    move-result v29

    if-nez v29, :cond_d

    .line 4682
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->invalidate()V

    .line 4685
    :cond_d
    move-object/from16 v0, p0

    move/from16 v1, p2

    invoke-virtual {v0, v1}, Lit/sephiroth/android/library/widget/AbsHListView;->offsetChildrenLeftAndRight(I)V

    .line 4687
    if-eqz v11, :cond_e

    .line 4688
    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mFirstPosition:I

    move/from16 v29, v0

    add-int v29, v29, v10

    move/from16 v0, v29

    move-object/from16 v1, p0

    iput v0, v1, Lit/sephiroth/android/library/widget/AbsHListView;->mFirstPosition:I

    .line 4691
    :cond_e
    invoke-static/range {p2 .. p2}, Ljava/lang/Math;->abs(I)I

    move-result v3

    .line 4692
    .local v3, "absIncrementalDeltaX":I
    move/from16 v0, v25

    if-lt v0, v3, :cond_f

    move/from16 v0, v24

    if-ge v0, v3, :cond_10

    .line 4693
    :cond_f
    move-object/from16 v0, p0

    invoke-virtual {v0, v11}, Lit/sephiroth/android/library/widget/AbsHListView;->fillGap(Z)V

    .line 4696
    :cond_10
    if-nez v20, :cond_17

    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectedPosition:I

    move/from16 v29, v0

    const/16 v30, -0x1

    move/from16 v0, v29

    move/from16 v1, v30

    if-eq v0, v1, :cond_17

    .line 4697
    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectedPosition:I

    move/from16 v29, v0

    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mFirstPosition:I

    move/from16 v30, v0

    sub-int v9, v29, v30

    .line 4698
    .local v9, "childIndex":I
    if-ltz v9, :cond_11

    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildCount()I

    move-result v29

    move/from16 v0, v29

    if-ge v9, v0, :cond_11

    .line 4699
    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectedPosition:I

    move/from16 v29, v0

    move-object/from16 v0, p0

    invoke-virtual {v0, v9}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildAt(I)Landroid/view/View;

    move-result-object v30

    move-object/from16 v0, p0

    move/from16 v1, v29

    move-object/from16 v2, v30

    invoke-virtual {v0, v1, v2}, Lit/sephiroth/android/library/widget/AbsHListView;->positionSelector(ILandroid/view/View;)V

    .line 4710
    .end local v9    # "childIndex":I
    :cond_11
    :goto_9
    const/16 v29, 0x0

    move/from16 v0, v29

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lit/sephiroth/android/library/widget/AbsHListView;->mBlockLayoutRequests:Z

    .line 4712
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->invokeOnItemScrollListener()V

    .line 4714
    const/16 v29, 0x0

    goto/16 :goto_0

    .line 4617
    .end local v3    # "absIncrementalDeltaX":I
    .end local v10    # "count":I
    .end local v11    # "down":Z
    .end local v17    # "footerViewsStart":I
    .end local v18    # "headerViewsCount":I
    .end local v19    # "i":I
    .end local v20    # "inTouchMode":Z
    .end local v26    # "start":I
    :cond_12
    const/4 v11, 0x0

    goto/16 :goto_7

    .line 4642
    .restart local v7    # "child":Landroid/view/View;
    .restart local v10    # "count":I
    .restart local v11    # "down":Z
    .restart local v17    # "footerViewsStart":I
    .restart local v18    # "headerViewsCount":I
    .restart local v19    # "i":I
    .restart local v20    # "inTouchMode":Z
    .restart local v26    # "start":I
    .restart local v27    # "top":I
    :cond_13
    add-int/lit8 v10, v10, 0x1

    .line 4643
    add-int v23, v16, v19

    .line 4644
    .local v23, "position":I
    move/from16 v0, v23

    move/from16 v1, v18

    if-lt v0, v1, :cond_14

    move/from16 v0, v23

    move/from16 v1, v17

    if-ge v0, v1, :cond_14

    .line 4645
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mRecycler:Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;

    move-object/from16 v29, v0

    move-object/from16 v0, v29

    move/from16 v1, v23

    invoke-virtual {v0, v7, v1}, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->addScrapView(Landroid/view/View;I)V

    .line 4637
    :cond_14
    add-int/lit8 v19, v19, 0x1

    goto/16 :goto_8

    .line 4650
    .end local v7    # "child":Landroid/view/View;
    .end local v19    # "i":I
    .end local v23    # "position":I
    .end local v27    # "top":I
    :cond_15
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getWidth()I

    move-result v29

    sub-int v4, v29, p2

    .line 4655
    .local v4, "bottom":I
    add-int/lit8 v19, v8, -0x1

    .restart local v19    # "i":I
    :goto_a
    if-ltz v19, :cond_b

    .line 4656
    move-object/from16 v0, p0

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildAt(I)Landroid/view/View;

    move-result-object v7

    .line 4657
    .restart local v7    # "child":Landroid/view/View;
    invoke-virtual {v7}, Landroid/view/View;->getLeft()I

    move-result v29

    move/from16 v0, v29

    if-le v0, v4, :cond_b

    .line 4660
    move/from16 v26, v19

    .line 4661
    add-int/lit8 v10, v10, 0x1

    .line 4662
    add-int v23, v16, v19

    .line 4663
    .restart local v23    # "position":I
    move/from16 v0, v23

    move/from16 v1, v18

    if-lt v0, v1, :cond_16

    move/from16 v0, v23

    move/from16 v1, v17

    if-ge v0, v1, :cond_16

    .line 4664
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mRecycler:Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;

    move-object/from16 v29, v0

    move-object/from16 v0, v29

    move/from16 v1, v23

    invoke-virtual {v0, v7, v1}, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->addScrapView(Landroid/view/View;I)V

    .line 4655
    :cond_16
    add-int/lit8 v19, v19, -0x1

    goto :goto_a

    .line 4701
    .end local v4    # "bottom":I
    .end local v7    # "child":Landroid/view/View;
    .end local v23    # "position":I
    .restart local v3    # "absIncrementalDeltaX":I
    :cond_17
    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectorPosition:I

    move/from16 v29, v0

    const/16 v30, -0x1

    move/from16 v0, v29

    move/from16 v1, v30

    if-eq v0, v1, :cond_18

    .line 4702
    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectorPosition:I

    move/from16 v29, v0

    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mFirstPosition:I

    move/from16 v30, v0

    sub-int v9, v29, v30

    .line 4703
    .restart local v9    # "childIndex":I
    if-ltz v9, :cond_11

    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildCount()I

    move-result v29

    move/from16 v0, v29

    if-ge v9, v0, :cond_11

    .line 4704
    const/16 v29, -0x1

    move-object/from16 v0, p0

    invoke-virtual {v0, v9}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildAt(I)Landroid/view/View;

    move-result-object v30

    move-object/from16 v0, p0

    move/from16 v1, v29

    move-object/from16 v2, v30

    invoke-virtual {v0, v1, v2}, Lit/sephiroth/android/library/widget/AbsHListView;->positionSelector(ILandroid/view/View;)V

    goto/16 :goto_9

    .line 4707
    .end local v9    # "childIndex":I
    :cond_18
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectorRect:Landroid/graphics/Rect;

    move-object/from16 v29, v0

    invoke-virtual/range {v29 .. v29}, Landroid/graphics/Rect;->setEmpty()V

    goto/16 :goto_9
.end method

.method protected updateScrollIndicators()V
    .locals 10

    .prologue
    const/4 v7, 0x4

    const/4 v4, 0x1

    const/4 v5, 0x0

    .line 1814
    iget-object v6, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mScrollLeft:Landroid/view/View;

    if-eqz v6, :cond_1

    .line 1817
    iget v6, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mFirstPosition:I

    if-lez v6, :cond_4

    move v0, v4

    .line 1820
    .local v0, "canScrollLeft":Z
    :goto_0
    if-nez v0, :cond_0

    .line 1821
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildCount()I

    move-result v6

    if-lez v6, :cond_0

    .line 1822
    invoke-virtual {p0, v5}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    .line 1823
    .local v2, "child":Landroid/view/View;
    invoke-virtual {v2}, Landroid/view/View;->getLeft()I

    move-result v6

    iget-object v8, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mListPadding:Landroid/graphics/Rect;

    iget v8, v8, Landroid/graphics/Rect;->left:I

    if-ge v6, v8, :cond_5

    move v0, v4

    .line 1827
    .end local v2    # "child":Landroid/view/View;
    :cond_0
    :goto_1
    iget-object v8, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mScrollLeft:Landroid/view/View;

    if-eqz v0, :cond_6

    move v6, v5

    :goto_2
    invoke-virtual {v8, v6}, Landroid/view/View;->setVisibility(I)V

    .line 1830
    .end local v0    # "canScrollLeft":Z
    :cond_1
    iget-object v6, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mScrollRight:Landroid/view/View;

    if-eqz v6, :cond_3

    .line 1832
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildCount()I

    move-result v3

    .line 1835
    .local v3, "count":I
    iget v6, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mFirstPosition:I

    add-int/2addr v6, v3

    iget v8, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mItemCount:I

    if-ge v6, v8, :cond_7

    move v1, v4

    .line 1838
    .local v1, "canScrollRight":Z
    :goto_3
    if-nez v1, :cond_2

    if-lez v3, :cond_2

    .line 1839
    add-int/lit8 v6, v3, -0x1

    invoke-virtual {p0, v6}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    .line 1840
    .restart local v2    # "child":Landroid/view/View;
    invoke-virtual {v2}, Landroid/view/View;->getRight()I

    move-result v6

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getRight()I

    move-result v8

    iget-object v9, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mListPadding:Landroid/graphics/Rect;

    iget v9, v9, Landroid/graphics/Rect;->right:I

    sub-int/2addr v8, v9

    if-le v6, v8, :cond_8

    move v1, v4

    .line 1843
    .end local v2    # "child":Landroid/view/View;
    :cond_2
    :goto_4
    iget-object v4, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mScrollRight:Landroid/view/View;

    if-eqz v1, :cond_9

    :goto_5
    invoke-virtual {v4, v5}, Landroid/view/View;->setVisibility(I)V

    .line 1845
    .end local v1    # "canScrollRight":Z
    .end local v3    # "count":I
    :cond_3
    return-void

    :cond_4
    move v0, v5

    .line 1817
    goto :goto_0

    .restart local v0    # "canScrollLeft":Z
    .restart local v2    # "child":Landroid/view/View;
    :cond_5
    move v0, v5

    .line 1823
    goto :goto_1

    .end local v2    # "child":Landroid/view/View;
    :cond_6
    move v6, v7

    .line 1827
    goto :goto_2

    .end local v0    # "canScrollLeft":Z
    .restart local v3    # "count":I
    :cond_7
    move v1, v5

    .line 1835
    goto :goto_3

    .restart local v1    # "canScrollRight":Z
    .restart local v2    # "child":Landroid/view/View;
    :cond_8
    move v1, v5

    .line 1840
    goto :goto_4

    .end local v2    # "child":Landroid/view/View;
    :cond_9
    move v5, v7

    .line 1843
    goto :goto_5
.end method

.method updateSelectorState()V
    .locals 2

    .prologue
    .line 2289
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelector:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_0

    .line 2290
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->shouldShowSelector()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 2291
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelector:Landroid/graphics/drawable/Drawable;

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->getDrawableState()[I

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/graphics/drawable/Drawable;->setState([I)Z

    .line 2296
    :cond_0
    :goto_0
    return-void

    .line 2293
    :cond_1
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelector:Landroid/graphics/drawable/Drawable;

    sget-object v1, Lit/sephiroth/android/library/widget/AbsHListView;->STATESET_NOTHING:[I

    invoke-virtual {v0, v1}, Landroid/graphics/drawable/Drawable;->setState([I)Z

    goto :goto_0
.end method

.method public verifyDrawable(Landroid/graphics/drawable/Drawable;)Z
    .locals 1
    .param p1, "dr"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 2341
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView;->mSelector:Landroid/graphics/drawable/Drawable;

    if-eq v0, p1, :cond_0

    invoke-super {p0, p1}, Lit/sephiroth/android/library/widget/AdapterView;->verifyDrawable(Landroid/graphics/drawable/Drawable;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method
