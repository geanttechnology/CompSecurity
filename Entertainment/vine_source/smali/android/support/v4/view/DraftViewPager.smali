.class public Landroid/support/v4/view/DraftViewPager;
.super Landroid/view/ViewGroup;
.source "DraftViewPager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/support/v4/view/DraftViewPager$LayoutParams;,
        Landroid/support/v4/view/DraftViewPager$PagerObserver;,
        Landroid/support/v4/view/DraftViewPager$SavedState;,
        Landroid/support/v4/view/DraftViewPager$Decor;,
        Landroid/support/v4/view/DraftViewPager$OnAdapterChangeListener;,
        Landroid/support/v4/view/DraftViewPager$OnPageChangeListener;,
        Landroid/support/v4/view/DraftViewPager$ItemInfo;
    }
.end annotation


# static fields
.field private static final COMPARATOR:Ljava/util/Comparator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Comparator",
            "<",
            "Landroid/support/v4/view/DraftViewPager$ItemInfo;",
            ">;"
        }
    .end annotation
.end field

.field private static final DEBUG:Z = false

.field private static final DEFAULT_OFFSCREEN_PAGES:I = 0x1

.field private static final INVALID_POINTER:I = -0x1

.field private static final LAYOUT_ATTRS:[I

.field private static final MAX_SETTLE_DURATION:I = 0x258

.field private static final MIN_DISTANCE_FOR_FLING:I = 0x19

.field public static final SCROLL_STATE_DRAGGING:I = 0x1

.field public static final SCROLL_STATE_IDLE:I = 0x0

.field public static final SCROLL_STATE_SETTLING:I = 0x2

.field private static final TAG:Ljava/lang/String; = "ViewPager"

.field private static final USE_CACHE:Z

.field private static final sInterpolator:Landroid/view/animation/Interpolator;


# instance fields
.field private mActivePointerId:I

.field private mAdapter:Landroid/support/v4/view/DraftPagerAdapter;

.field private mAdapterChangeListener:Landroid/support/v4/view/DraftViewPager$OnAdapterChangeListener;

.field private mBottomPageBounds:I

.field private mCalledSuper:Z

.field private mChildHeightMeasureSpec:I

.field private mChildWidthMeasureSpec:I

.field private mCurItem:I

.field private mDecorChildCount:I

.field private mDraftMargin:I

.field private mFakeDragBeginTime:J

.field private mFakeDragging:Z

.field private mFirstLayout:Z

.field private mFlingDistance:I

.field private mInLayout:Z

.field private mInitialMotionX:F

.field private mInternalPageChangeListener:Landroid/support/v4/view/DraftViewPager$OnPageChangeListener;

.field private mIsBeingDragged:Z

.field private mIsUnableToDrag:Z

.field private final mItems:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/support/v4/view/DraftViewPager$ItemInfo;",
            ">;"
        }
    .end annotation
.end field

.field private mLastMotionX:F

.field private mLastMotionY:F

.field private mLeftEdge:Landroid/support/v4/widget/EdgeEffectCompat;

.field private mMarginDrawable:Landroid/graphics/drawable/Drawable;

.field private mMaximumVelocity:I

.field private mMinimumVelocity:I

.field private mObserver:Landroid/support/v4/view/DraftViewPager$PagerObserver;

.field private mOffscreenPageLimit:I

.field private mOnPageChangeListener:Landroid/support/v4/view/DraftViewPager$OnPageChangeListener;

.field private mPageMargin:I

.field private mPopulatePending:Z

.field private mPreviewRatio:F

.field private mRestoredAdapterState:Landroid/os/Parcelable;

.field private mRestoredClassLoader:Ljava/lang/ClassLoader;

.field private mRestoredCurItem:I

.field private mRightEdge:Landroid/support/v4/widget/EdgeEffectCompat;

.field private mScrollState:I

.field private mScroller:Landroid/widget/Scroller;

.field private mScrolling:Z

.field private mScrollingCacheEnabled:Z

.field private mTopPageBounds:I

.field private mTouchSlop:I

.field private mVelocityTracker:Landroid/view/VelocityTracker;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 97
    const/4 v0, 0x1

    new-array v0, v0, [I

    const/4 v1, 0x0

    const v2, 0x10100b3

    aput v2, v0, v1

    sput-object v0, Landroid/support/v4/view/DraftViewPager;->LAYOUT_ATTRS:[I

    .line 107
    new-instance v0, Landroid/support/v4/view/DraftViewPager$1;

    invoke-direct {v0}, Landroid/support/v4/view/DraftViewPager$1;-><init>()V

    sput-object v0, Landroid/support/v4/view/DraftViewPager;->COMPARATOR:Ljava/util/Comparator;

    .line 114
    new-instance v0, Landroid/support/v4/view/DraftViewPager$2;

    invoke-direct {v0}, Landroid/support/v4/view/DraftViewPager$2;-><init>()V

    sput-object v0, Landroid/support/v4/view/DraftViewPager;->sInterpolator:Landroid/view/animation/Interpolator;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "c"    # Landroid/content/Context;

    .prologue
    .line 260
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Landroid/support/v4/view/DraftViewPager;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 261
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 5
    .param p1, "c"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v4, 0x0

    const/4 v3, 0x1

    const/4 v2, -0x1

    .line 264
    invoke-direct {p0, p1, p2}, Landroid/view/ViewGroup;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 121
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, p0, Landroid/support/v4/view/DraftViewPager;->mItems:Ljava/util/ArrayList;

    .line 125
    iput v2, p0, Landroid/support/v4/view/DraftViewPager;->mRestoredCurItem:I

    .line 126
    iput-object v4, p0, Landroid/support/v4/view/DraftViewPager;->mRestoredAdapterState:Landroid/os/Parcelable;

    .line 127
    iput-object v4, p0, Landroid/support/v4/view/DraftViewPager;->mRestoredClassLoader:Ljava/lang/ClassLoader;

    .line 144
    iput v3, p0, Landroid/support/v4/view/DraftViewPager;->mOffscreenPageLimit:I

    .line 159
    iput v2, p0, Landroid/support/v4/view/DraftViewPager;->mActivePointerId:I

    .line 180
    iput-boolean v3, p0, Landroid/support/v4/view/DraftViewPager;->mFirstLayout:Z

    .line 206
    const/4 v1, 0x0

    iput v1, p0, Landroid/support/v4/view/DraftViewPager;->mScrollState:I

    .line 265
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    .line 266
    .local v0, "res":Landroid/content/res/Resources;
    const v1, 0x7f0c0003

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v1

    int-to-float v1, v1

    const/high16 v2, 0x42c80000    # 100.0f

    div-float/2addr v1, v2

    iput v1, p0, Landroid/support/v4/view/DraftViewPager;->mPreviewRatio:F

    .line 267
    const v1, 0x7f0b0036

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelOffset(I)I

    move-result v1

    iput v1, p0, Landroid/support/v4/view/DraftViewPager;->mDraftMargin:I

    .line 268
    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->initViewPager()V

    .line 269
    return-void
.end method

.method static synthetic access$100()[I
    .locals 1

    .prologue
    .line 89
    sget-object v0, Landroid/support/v4/view/DraftViewPager;->LAYOUT_ATTRS:[I

    return-object v0
.end method

.method private completeScroll()V
    .locals 9

    .prologue
    const/4 v8, 0x0

    .line 1278
    iget-boolean v2, p0, Landroid/support/v4/view/DraftViewPager;->mScrolling:Z

    .line 1279
    .local v2, "needPopulate":Z
    if-eqz v2, :cond_2

    .line 1281
    invoke-direct {p0, v8}, Landroid/support/v4/view/DraftViewPager;->setScrollingCacheEnabled(Z)V

    .line 1282
    iget-object v7, p0, Landroid/support/v4/view/DraftViewPager;->mScroller:Landroid/widget/Scroller;

    invoke-virtual {v7}, Landroid/widget/Scroller;->abortAnimation()V

    .line 1283
    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->getScrollX()I

    move-result v3

    .line 1284
    .local v3, "oldX":I
    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->getScrollY()I

    move-result v4

    .line 1285
    .local v4, "oldY":I
    iget-object v7, p0, Landroid/support/v4/view/DraftViewPager;->mScroller:Landroid/widget/Scroller;

    invoke-virtual {v7}, Landroid/widget/Scroller;->getCurrX()I

    move-result v5

    .line 1286
    .local v5, "x":I
    iget-object v7, p0, Landroid/support/v4/view/DraftViewPager;->mScroller:Landroid/widget/Scroller;

    invoke-virtual {v7}, Landroid/widget/Scroller;->getCurrY()I

    move-result v6

    .line 1287
    .local v6, "y":I
    if-ne v3, v5, :cond_0

    if-eq v4, v6, :cond_1

    .line 1288
    :cond_0
    invoke-virtual {p0, v5, v6}, Landroid/support/v4/view/DraftViewPager;->scrollTo(II)V

    .line 1290
    :cond_1
    invoke-direct {p0, v8}, Landroid/support/v4/view/DraftViewPager;->setScrollState(I)V

    .line 1292
    .end local v3    # "oldX":I
    .end local v4    # "oldY":I
    .end local v5    # "x":I
    .end local v6    # "y":I
    :cond_2
    iput-boolean v8, p0, Landroid/support/v4/view/DraftViewPager;->mPopulatePending:Z

    .line 1293
    iput-boolean v8, p0, Landroid/support/v4/view/DraftViewPager;->mScrolling:Z

    .line 1294
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v7, p0, Landroid/support/v4/view/DraftViewPager;->mItems:Ljava/util/ArrayList;

    invoke-virtual {v7}, Ljava/util/ArrayList;->size()I

    move-result v7

    if-ge v0, v7, :cond_4

    .line 1295
    iget-object v7, p0, Landroid/support/v4/view/DraftViewPager;->mItems:Ljava/util/ArrayList;

    invoke-virtual {v7, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/support/v4/view/DraftViewPager$ItemInfo;

    .line 1296
    .local v1, "ii":Landroid/support/v4/view/DraftViewPager$ItemInfo;
    iget-boolean v7, v1, Landroid/support/v4/view/DraftViewPager$ItemInfo;->scrolling:Z

    if-eqz v7, :cond_3

    .line 1297
    const/4 v2, 0x1

    .line 1298
    iput-boolean v8, v1, Landroid/support/v4/view/DraftViewPager$ItemInfo;->scrolling:Z

    .line 1294
    :cond_3
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 1301
    .end local v1    # "ii":Landroid/support/v4/view/DraftViewPager$ItemInfo;
    :cond_4
    if-eqz v2, :cond_5

    .line 1302
    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->populate()V

    .line 1304
    :cond_5
    return-void
.end method

.method private determineTargetPage(IFII)I
    .locals 3
    .param p1, "currentPage"    # I
    .param p2, "pageOffset"    # F
    .param p3, "velocity"    # I
    .param p4, "deltaX"    # I

    .prologue
    .line 1589
    invoke-static {p4}, Ljava/lang/Math;->abs(I)I

    move-result v1

    iget v2, p0, Landroid/support/v4/view/DraftViewPager;->mFlingDistance:I

    if-le v1, v2, :cond_1

    invoke-static {p3}, Ljava/lang/Math;->abs(I)I

    move-result v1

    iget v2, p0, Landroid/support/v4/view/DraftViewPager;->mMinimumVelocity:I

    if-le v1, v2, :cond_1

    .line 1590
    if-lez p3, :cond_0

    move v0, p1

    .line 1595
    .local v0, "targetPage":I
    :goto_0
    return v0

    .line 1590
    .end local v0    # "targetPage":I
    :cond_0
    add-int/lit8 v0, p1, 0x1

    goto :goto_0

    .line 1592
    :cond_1
    int-to-float v1, p1

    add-float/2addr v1, p2

    const/high16 v2, 0x3f000000    # 0.5f

    add-float/2addr v1, v2

    float-to-int v0, v1

    .restart local v0    # "targetPage":I
    goto :goto_0
.end method

.method private endDrag()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 1790
    iput-boolean v0, p0, Landroid/support/v4/view/DraftViewPager;->mIsBeingDragged:Z

    .line 1791
    iput-boolean v0, p0, Landroid/support/v4/view/DraftViewPager;->mIsUnableToDrag:Z

    .line 1793
    iget-object v0, p0, Landroid/support/v4/view/DraftViewPager;->mVelocityTracker:Landroid/view/VelocityTracker;

    if-eqz v0, :cond_0

    .line 1794
    iget-object v0, p0, Landroid/support/v4/view/DraftViewPager;->mVelocityTracker:Landroid/view/VelocityTracker;

    invoke-virtual {v0}, Landroid/view/VelocityTracker;->recycle()V

    .line 1795
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/support/v4/view/DraftViewPager;->mVelocityTracker:Landroid/view/VelocityTracker;

    .line 1797
    :cond_0
    return-void
.end method

.method private getAdjustedXDestination(I)I
    .locals 3
    .param p1, "item"    # I

    .prologue
    .line 455
    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->getWidth()I

    move-result v1

    int-to-float v1, v1

    iget v2, p0, Landroid/support/v4/view/DraftViewPager;->mPreviewRatio:F

    mul-float/2addr v1, v2

    float-to-int v1, v1

    iget v2, p0, Landroid/support/v4/view/DraftViewPager;->mDraftMargin:I

    mul-int/lit8 v2, v2, 0x2

    add-int v0, v1, v2

    .line 456
    .local v0, "base":I
    mul-int v1, v0, p1

    return v1
.end method

.method private onSecondaryPointerUp(Landroid/view/MotionEvent;)V
    .locals 4
    .param p1, "ev"    # Landroid/view/MotionEvent;

    .prologue
    .line 1775
    invoke-static {p1}, Landroid/support/v4/view/MotionEventCompat;->getActionIndex(Landroid/view/MotionEvent;)I

    move-result v2

    .line 1776
    .local v2, "pointerIndex":I
    invoke-static {p1, v2}, Landroid/support/v4/view/MotionEventCompat;->getPointerId(Landroid/view/MotionEvent;I)I

    move-result v1

    .line 1777
    .local v1, "pointerId":I
    iget v3, p0, Landroid/support/v4/view/DraftViewPager;->mActivePointerId:I

    if-ne v1, v3, :cond_0

    .line 1780
    if-nez v2, :cond_1

    const/4 v0, 0x1

    .line 1781
    .local v0, "newPointerIndex":I
    :goto_0
    invoke-static {p1, v0}, Landroid/support/v4/view/MotionEventCompat;->getX(Landroid/view/MotionEvent;I)F

    move-result v3

    iput v3, p0, Landroid/support/v4/view/DraftViewPager;->mLastMotionX:F

    .line 1782
    invoke-static {p1, v0}, Landroid/support/v4/view/MotionEventCompat;->getPointerId(Landroid/view/MotionEvent;I)I

    move-result v3

    iput v3, p0, Landroid/support/v4/view/DraftViewPager;->mActivePointerId:I

    .line 1783
    iget-object v3, p0, Landroid/support/v4/view/DraftViewPager;->mVelocityTracker:Landroid/view/VelocityTracker;

    if-eqz v3, :cond_0

    .line 1784
    iget-object v3, p0, Landroid/support/v4/view/DraftViewPager;->mVelocityTracker:Landroid/view/VelocityTracker;

    invoke-virtual {v3}, Landroid/view/VelocityTracker;->clear()V

    .line 1787
    .end local v0    # "newPointerIndex":I
    :cond_0
    return-void

    .line 1780
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private pageScrolled(I)V
    .locals 6
    .param p1, "xpos"    # I

    .prologue
    .line 1202
    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->getWidth()I

    move-result v4

    iget v5, p0, Landroid/support/v4/view/DraftViewPager;->mPageMargin:I

    add-int v3, v4, v5

    .line 1203
    .local v3, "widthWithMargin":I
    div-int v2, p1, v3

    .line 1204
    .local v2, "position":I
    rem-int v1, p1, v3

    .line 1205
    .local v1, "offsetPixels":I
    int-to-float v4, v1

    int-to-float v5, v3

    div-float v0, v4, v5

    .line 1207
    .local v0, "offset":F
    const/4 v4, 0x0

    iput-boolean v4, p0, Landroid/support/v4/view/DraftViewPager;->mCalledSuper:Z

    .line 1208
    invoke-virtual {p0, v2, v0, v1}, Landroid/support/v4/view/DraftViewPager;->onPageScrolled(IFI)V

    .line 1209
    iget-boolean v4, p0, Landroid/support/v4/view/DraftViewPager;->mCalledSuper:Z

    if-nez v4, :cond_0

    .line 1210
    new-instance v4, Ljava/lang/IllegalStateException;

    const-string v5, "onPageScrolled did not call superclass implementation"

    invoke-direct {v4, v5}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 1213
    :cond_0
    return-void
.end method

.method private recomputeScrollPosition(IIII)V
    .locals 11
    .param p1, "width"    # I
    .param p2, "oldWidth"    # I
    .param p3, "margin"    # I
    .param p4, "oldMargin"    # I

    .prologue
    const/4 v2, 0x0

    .line 1054
    add-int v10, p1, p3

    .line 1055
    .local v10, "widthWithMargin":I
    if-lez p2, :cond_1

    .line 1056
    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->getScrollX()I

    move-result v7

    .line 1057
    .local v7, "oldScrollPos":I
    add-int v8, p2, p4

    .line 1058
    .local v8, "oldwwm":I
    div-int v6, v7, v8

    .line 1059
    .local v6, "oldScrollItem":I
    rem-int v0, v7, v8

    int-to-float v0, v0

    int-to-float v3, v8

    div-float v9, v0, v3

    .line 1060
    .local v9, "scrollOffset":F
    int-to-float v0, v6

    add-float/2addr v0, v9

    int-to-float v3, v10

    mul-float/2addr v0, v3

    float-to-int v1, v0

    .line 1061
    .local v1, "scrollPos":I
    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->getScrollY()I

    move-result v0

    invoke-virtual {p0, v1, v0}, Landroid/support/v4/view/DraftViewPager;->scrollTo(II)V

    .line 1062
    iget-object v0, p0, Landroid/support/v4/view/DraftViewPager;->mScroller:Landroid/widget/Scroller;

    invoke-virtual {v0}, Landroid/widget/Scroller;->isFinished()Z

    move-result v0

    if-nez v0, :cond_0

    .line 1064
    iget-object v0, p0, Landroid/support/v4/view/DraftViewPager;->mScroller:Landroid/widget/Scroller;

    invoke-virtual {v0}, Landroid/widget/Scroller;->getDuration()I

    move-result v0

    iget-object v3, p0, Landroid/support/v4/view/DraftViewPager;->mScroller:Landroid/widget/Scroller;

    invoke-virtual {v3}, Landroid/widget/Scroller;->timePassed()I

    move-result v3

    sub-int v5, v0, v3

    .line 1065
    .local v5, "newDuration":I
    iget-object v0, p0, Landroid/support/v4/view/DraftViewPager;->mScroller:Landroid/widget/Scroller;

    iget v3, p0, Landroid/support/v4/view/DraftViewPager;->mCurItem:I

    mul-int/2addr v3, v10

    move v4, v2

    invoke-virtual/range {v0 .. v5}, Landroid/widget/Scroller;->startScroll(IIIII)V

    .line 1074
    .end local v5    # "newDuration":I
    .end local v6    # "oldScrollItem":I
    .end local v7    # "oldScrollPos":I
    .end local v8    # "oldwwm":I
    .end local v9    # "scrollOffset":F
    :cond_0
    :goto_0
    return-void

    .line 1068
    .end local v1    # "scrollPos":I
    :cond_1
    iget v0, p0, Landroid/support/v4/view/DraftViewPager;->mCurItem:I

    mul-int v1, v0, v10

    .line 1069
    .restart local v1    # "scrollPos":I
    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->getScrollX()I

    move-result v0

    if-eq v1, v0, :cond_0

    .line 1070
    invoke-direct {p0}, Landroid/support/v4/view/DraftViewPager;->completeScroll()V

    .line 1071
    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->getScrollY()I

    move-result v0

    invoke-virtual {p0, v1, v0}, Landroid/support/v4/view/DraftViewPager;->scrollTo(II)V

    goto :goto_0
.end method

.method private removeNonDecorViews()V
    .locals 4

    .prologue
    .line 345
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->getChildCount()I

    move-result v3

    if-ge v1, v3, :cond_1

    .line 346
    invoke-virtual {p0, v1}, Landroid/support/v4/view/DraftViewPager;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 347
    .local v0, "child":Landroid/view/View;
    invoke-virtual {v0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v2

    check-cast v2, Landroid/support/v4/view/DraftViewPager$LayoutParams;

    .line 348
    .local v2, "lp":Landroid/support/v4/view/DraftViewPager$LayoutParams;
    iget-boolean v3, v2, Landroid/support/v4/view/DraftViewPager$LayoutParams;->isDecor:Z

    if-nez v3, :cond_0

    .line 349
    invoke-virtual {p0, v1}, Landroid/support/v4/view/DraftViewPager;->removeViewAt(I)V

    .line 350
    add-int/lit8 v1, v1, -0x1

    .line 345
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 353
    .end local v0    # "child":Landroid/view/View;
    .end local v2    # "lp":Landroid/support/v4/view/DraftViewPager$LayoutParams;
    :cond_1
    return-void
.end method

.method private setScrollState(I)V
    .locals 1
    .param p1, "newState"    # I

    .prologue
    .line 289
    iget v0, p0, Landroid/support/v4/view/DraftViewPager;->mScrollState:I

    if-ne v0, p1, :cond_1

    .line 297
    :cond_0
    :goto_0
    return-void

    .line 293
    :cond_1
    iput p1, p0, Landroid/support/v4/view/DraftViewPager;->mScrollState:I

    .line 294
    iget-object v0, p0, Landroid/support/v4/view/DraftViewPager;->mOnPageChangeListener:Landroid/support/v4/view/DraftViewPager$OnPageChangeListener;

    if-eqz v0, :cond_0

    .line 295
    iget-object v0, p0, Landroid/support/v4/view/DraftViewPager;->mOnPageChangeListener:Landroid/support/v4/view/DraftViewPager$OnPageChangeListener;

    invoke-interface {v0, p1}, Landroid/support/v4/view/DraftViewPager$OnPageChangeListener;->onPageScrollStateChanged(I)V

    goto :goto_0
.end method

.method private setScrollingCacheEnabled(Z)V
    .locals 1
    .param p1, "enabled"    # Z

    .prologue
    .line 1800
    iget-boolean v0, p0, Landroid/support/v4/view/DraftViewPager;->mScrollingCacheEnabled:Z

    if-eq v0, p1, :cond_0

    .line 1801
    iput-boolean p1, p0, Landroid/support/v4/view/DraftViewPager;->mScrollingCacheEnabled:Z

    .line 1812
    :cond_0
    return-void
.end method


# virtual methods
.method public addFocusables(Ljava/util/ArrayList;II)V
    .locals 7
    .param p1    # Ljava/util/ArrayList;
        .annotation build Lorg/jetbrains/annotations/NotNull;
        .end annotation
    .end param
    .param p2, "direction"    # I
    .param p3, "focusableMode"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Landroid/view/View;",
            ">;II)V"
        }
    .end annotation

    .prologue
    .line 1948
    .local p1, "views":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v2

    .line 1950
    .local v2, "focusableCount":I
    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->getDescendantFocusability()I

    move-result v1

    .line 1952
    .local v1, "descendantFocusability":I
    const/high16 v5, 0x60000

    if-eq v1, v5, :cond_1

    .line 1953
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->getChildCount()I

    move-result v5

    if-ge v3, v5, :cond_1

    .line 1954
    invoke-virtual {p0, v3}, Landroid/support/v4/view/DraftViewPager;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 1955
    .local v0, "child":Landroid/view/View;
    invoke-virtual {v0}, Landroid/view/View;->getVisibility()I

    move-result v5

    if-nez v5, :cond_0

    .line 1956
    invoke-virtual {p0, v0}, Landroid/support/v4/view/DraftViewPager;->infoForChild(Landroid/view/View;)Landroid/support/v4/view/DraftViewPager$ItemInfo;

    move-result-object v4

    .line 1957
    .local v4, "ii":Landroid/support/v4/view/DraftViewPager$ItemInfo;
    if-eqz v4, :cond_0

    iget v5, v4, Landroid/support/v4/view/DraftViewPager$ItemInfo;->position:I

    iget v6, p0, Landroid/support/v4/view/DraftViewPager;->mCurItem:I

    if-ne v5, v6, :cond_0

    .line 1958
    invoke-virtual {v0, p1, p2, p3}, Landroid/view/View;->addFocusables(Ljava/util/ArrayList;II)V

    .line 1953
    .end local v4    # "ii":Landroid/support/v4/view/DraftViewPager$ItemInfo;
    :cond_0
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 1968
    .end local v0    # "child":Landroid/view/View;
    .end local v3    # "i":I
    :cond_1
    const/high16 v5, 0x40000

    if-ne v1, v5, :cond_2

    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v5

    if-ne v2, v5, :cond_3

    .line 1974
    :cond_2
    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->isFocusable()Z

    move-result v5

    if-nez v5, :cond_4

    .line 1985
    :cond_3
    :goto_1
    return-void

    .line 1977
    :cond_4
    and-int/lit8 v5, p3, 0x1

    const/4 v6, 0x1

    if-ne v5, v6, :cond_5

    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->isInTouchMode()Z

    move-result v5

    if-eqz v5, :cond_5

    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->isFocusableInTouchMode()Z

    move-result v5

    if-eqz v5, :cond_3

    .line 1981
    :cond_5
    if-eqz p1, :cond_3

    .line 1982
    invoke-virtual {p1, p0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_1
.end method

.method addNewItem(II)V
    .locals 2
    .param p1, "position"    # I
    .param p2, "index"    # I

    .prologue
    .line 654
    new-instance v0, Landroid/support/v4/view/DraftViewPager$ItemInfo;

    invoke-direct {v0}, Landroid/support/v4/view/DraftViewPager$ItemInfo;-><init>()V

    .line 655
    .local v0, "ii":Landroid/support/v4/view/DraftViewPager$ItemInfo;
    iput p1, v0, Landroid/support/v4/view/DraftViewPager$ItemInfo;->position:I

    .line 656
    iget-object v1, p0, Landroid/support/v4/view/DraftViewPager;->mAdapter:Landroid/support/v4/view/DraftPagerAdapter;

    invoke-virtual {v1, p0, p1}, Landroid/support/v4/view/DraftPagerAdapter;->instantiateItem(Landroid/view/ViewGroup;I)Ljava/lang/Object;

    move-result-object v1

    iput-object v1, v0, Landroid/support/v4/view/DraftViewPager$ItemInfo;->object:Ljava/lang/Object;

    .line 657
    if-gez p2, :cond_0

    .line 658
    iget-object v1, p0, Landroid/support/v4/view/DraftViewPager;->mItems:Ljava/util/ArrayList;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 662
    :goto_0
    return-void

    .line 660
    :cond_0
    iget-object v1, p0, Landroid/support/v4/view/DraftViewPager;->mItems:Ljava/util/ArrayList;

    invoke-virtual {v1, p2, v0}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V

    goto :goto_0
.end method

.method public addTouchables(Ljava/util/ArrayList;)V
    .locals 5
    .param p1    # Ljava/util/ArrayList;
        .annotation build Lorg/jetbrains/annotations/NotNull;
        .end annotation
    .end param
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
    .line 1995
    .local p1, "views":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->getChildCount()I

    move-result v3

    if-ge v1, v3, :cond_1

    .line 1996
    invoke-virtual {p0, v1}, Landroid/support/v4/view/DraftViewPager;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 1997
    .local v0, "child":Landroid/view/View;
    invoke-virtual {v0}, Landroid/view/View;->getVisibility()I

    move-result v3

    if-nez v3, :cond_0

    .line 1998
    invoke-virtual {p0, v0}, Landroid/support/v4/view/DraftViewPager;->infoForChild(Landroid/view/View;)Landroid/support/v4/view/DraftViewPager$ItemInfo;

    move-result-object v2

    .line 1999
    .local v2, "ii":Landroid/support/v4/view/DraftViewPager$ItemInfo;
    if-eqz v2, :cond_0

    iget v3, v2, Landroid/support/v4/view/DraftViewPager$ItemInfo;->position:I

    iget v4, p0, Landroid/support/v4/view/DraftViewPager;->mCurItem:I

    if-ne v3, v4, :cond_0

    .line 2000
    invoke-virtual {v0, p1}, Landroid/view/View;->addTouchables(Ljava/util/ArrayList;)V

    .line 1995
    .end local v2    # "ii":Landroid/support/v4/view/DraftViewPager$ItemInfo;
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 2004
    .end local v0    # "child":Landroid/view/View;
    :cond_1
    return-void
.end method

.method public addView(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V
    .locals 3
    .param p1, "child"    # Landroid/view/View;
        .annotation build Lorg/jetbrains/annotations/NotNull;
        .end annotation
    .end param
    .param p2, "index"    # I
    .param p3, "params"    # Landroid/view/ViewGroup$LayoutParams;

    .prologue
    .line 916
    invoke-virtual {p0, p3}, Landroid/support/v4/view/DraftViewPager;->checkLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 917
    invoke-virtual {p0, p3}, Landroid/support/v4/view/DraftViewPager;->generateLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Landroid/view/ViewGroup$LayoutParams;

    move-result-object p3

    :cond_0
    move-object v0, p3

    .line 919
    check-cast v0, Landroid/support/v4/view/DraftViewPager$LayoutParams;

    .line 920
    .local v0, "lp":Landroid/support/v4/view/DraftViewPager$LayoutParams;
    iget-boolean v1, v0, Landroid/support/v4/view/DraftViewPager$LayoutParams;->isDecor:Z

    instance-of v2, p1, Landroid/support/v4/view/DraftViewPager$Decor;

    or-int/2addr v1, v2

    iput-boolean v1, v0, Landroid/support/v4/view/DraftViewPager$LayoutParams;->isDecor:Z

    .line 921
    iget-boolean v1, p0, Landroid/support/v4/view/DraftViewPager;->mInLayout:Z

    if-eqz v1, :cond_2

    .line 922
    if-eqz v0, :cond_1

    iget-boolean v1, v0, Landroid/support/v4/view/DraftViewPager$LayoutParams;->isDecor:Z

    if-eqz v1, :cond_1

    .line 923
    new-instance v1, Ljava/lang/IllegalStateException;

    const-string v2, "Cannot add pager decor view during layout"

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 925
    :cond_1
    invoke-virtual {p0, p1, p2, p3}, Landroid/support/v4/view/DraftViewPager;->addViewInLayout(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)Z

    .line 926
    iget v1, p0, Landroid/support/v4/view/DraftViewPager;->mChildWidthMeasureSpec:I

    iget v2, p0, Landroid/support/v4/view/DraftViewPager;->mChildHeightMeasureSpec:I

    invoke-virtual {p1, v1, v2}, Landroid/view/View;->measure(II)V

    .line 938
    :goto_0
    return-void

    .line 928
    :cond_2
    invoke-super {p0, p1, p2, p3}, Landroid/view/ViewGroup;->addView(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V

    goto :goto_0
.end method

.method public arrowScroll(I)Z
    .locals 6
    .param p1, "direction"    # I

    .prologue
    const/16 v5, 0x42

    const/16 v4, 0x11

    .line 1889
    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->findFocus()Landroid/view/View;

    move-result-object v0

    .line 1890
    .local v0, "currentFocused":Landroid/view/View;
    if-ne v0, p0, :cond_0

    const/4 v0, 0x0

    .line 1892
    :cond_0
    const/4 v1, 0x0

    .line 1894
    .local v1, "handled":Z
    invoke-static {}, Landroid/view/FocusFinder;->getInstance()Landroid/view/FocusFinder;

    move-result-object v3

    invoke-virtual {v3, p0, v0, p1}, Landroid/view/FocusFinder;->findNextFocus(Landroid/view/ViewGroup;Landroid/view/View;I)Landroid/view/View;

    move-result-object v2

    .line 1896
    .local v2, "nextFocused":Landroid/view/View;
    if-eqz v2, :cond_6

    if-eq v2, v0, :cond_6

    .line 1897
    if-ne p1, v4, :cond_4

    .line 1900
    if-eqz v0, :cond_3

    invoke-virtual {v2}, Landroid/view/View;->getLeft()I

    move-result v3

    invoke-virtual {v0}, Landroid/view/View;->getLeft()I

    move-result v4

    if-lt v3, v4, :cond_3

    .line 1901
    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->pageLeft()Z

    move-result v1

    .line 1921
    :cond_1
    :goto_0
    if-eqz v1, :cond_2

    .line 1922
    invoke-static {p1}, Landroid/view/SoundEffectConstants;->getContantForFocusDirection(I)I

    move-result v3

    invoke-virtual {p0, v3}, Landroid/support/v4/view/DraftViewPager;->playSoundEffect(I)V

    .line 1924
    :cond_2
    return v1

    .line 1903
    :cond_3
    invoke-virtual {v2}, Landroid/view/View;->requestFocus()Z

    move-result v1

    goto :goto_0

    .line 1905
    :cond_4
    if-ne p1, v5, :cond_1

    .line 1908
    if-eqz v0, :cond_5

    invoke-virtual {v2}, Landroid/view/View;->getLeft()I

    move-result v3

    invoke-virtual {v0}, Landroid/view/View;->getLeft()I

    move-result v4

    if-gt v3, v4, :cond_5

    .line 1909
    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->pageRight()Z

    move-result v1

    goto :goto_0

    .line 1911
    :cond_5
    invoke-virtual {v2}, Landroid/view/View;->requestFocus()Z

    move-result v1

    goto :goto_0

    .line 1914
    :cond_6
    if-eq p1, v4, :cond_7

    const/4 v3, 0x1

    if-ne p1, v3, :cond_8

    .line 1916
    :cond_7
    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->pageLeft()Z

    move-result v1

    goto :goto_0

    .line 1917
    :cond_8
    if-eq p1, v5, :cond_9

    const/4 v3, 0x2

    if-ne p1, v3, :cond_1

    .line 1919
    :cond_9
    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->pageRight()Z

    move-result v1

    goto :goto_0
.end method

.method public beginFakeDrag()Z
    .locals 10

    .prologue
    const/4 v9, 0x1

    const/4 v4, 0x0

    const/4 v5, 0x0

    .line 1677
    iget-boolean v2, p0, Landroid/support/v4/view/DraftViewPager;->mIsBeingDragged:Z

    if-eqz v2, :cond_0

    .line 1693
    :goto_0
    return v4

    .line 1680
    :cond_0
    iput-boolean v9, p0, Landroid/support/v4/view/DraftViewPager;->mFakeDragging:Z

    .line 1681
    invoke-direct {p0, v9}, Landroid/support/v4/view/DraftViewPager;->setScrollState(I)V

    .line 1682
    iput v5, p0, Landroid/support/v4/view/DraftViewPager;->mLastMotionX:F

    iput v5, p0, Landroid/support/v4/view/DraftViewPager;->mInitialMotionX:F

    .line 1683
    iget-object v2, p0, Landroid/support/v4/view/DraftViewPager;->mVelocityTracker:Landroid/view/VelocityTracker;

    if-nez v2, :cond_1

    .line 1684
    invoke-static {}, Landroid/view/VelocityTracker;->obtain()Landroid/view/VelocityTracker;

    move-result-object v2

    iput-object v2, p0, Landroid/support/v4/view/DraftViewPager;->mVelocityTracker:Landroid/view/VelocityTracker;

    .line 1688
    :goto_1
    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v0

    .local v0, "time":J
    move-wide v2, v0

    move v6, v5

    move v7, v4

    .line 1689
    invoke-static/range {v0 .. v7}, Landroid/view/MotionEvent;->obtain(JJIFFI)Landroid/view/MotionEvent;

    move-result-object v8

    .line 1690
    .local v8, "ev":Landroid/view/MotionEvent;
    iget-object v2, p0, Landroid/support/v4/view/DraftViewPager;->mVelocityTracker:Landroid/view/VelocityTracker;

    invoke-virtual {v2, v8}, Landroid/view/VelocityTracker;->addMovement(Landroid/view/MotionEvent;)V

    .line 1691
    invoke-virtual {v8}, Landroid/view/MotionEvent;->recycle()V

    .line 1692
    iput-wide v0, p0, Landroid/support/v4/view/DraftViewPager;->mFakeDragBeginTime:J

    move v4, v9

    .line 1693
    goto :goto_0

    .line 1686
    .end local v0    # "time":J
    .end local v8    # "ev":Landroid/view/MotionEvent;
    :cond_1
    iget-object v2, p0, Landroid/support/v4/view/DraftViewPager;->mVelocityTracker:Landroid/view/VelocityTracker;

    invoke-virtual {v2}, Landroid/view/VelocityTracker;->clear()V

    goto :goto_1
.end method

.method protected canScroll(Landroid/view/View;ZIII)Z
    .locals 11
    .param p1, "v"    # Landroid/view/View;
    .param p2, "checkV"    # Z
    .param p3, "dx"    # I
    .param p4, "x"    # I
    .param p5, "y"    # I

    .prologue
    .line 1826
    instance-of v0, p1, Landroid/view/ViewGroup;

    if-eqz v0, :cond_1

    move-object v7, p1

    .line 1827
    check-cast v7, Landroid/view/ViewGroup;

    .line 1828
    .local v7, "group":Landroid/view/ViewGroup;
    invoke-virtual {p1}, Landroid/view/View;->getScrollX()I

    move-result v9

    .line 1829
    .local v9, "scrollX":I
    invoke-virtual {p1}, Landroid/view/View;->getScrollY()I

    move-result v10

    .line 1830
    .local v10, "scrollY":I
    invoke-virtual {v7}, Landroid/view/ViewGroup;->getChildCount()I

    move-result v6

    .line 1832
    .local v6, "count":I
    add-int/lit8 v8, v6, -0x1

    .local v8, "i":I
    :goto_0
    if-ltz v8, :cond_1

    .line 1835
    invoke-virtual {v7, v8}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    .line 1836
    .local v1, "child":Landroid/view/View;
    add-int v0, p4, v9

    invoke-virtual {v1}, Landroid/view/View;->getLeft()I

    move-result v2

    if-lt v0, v2, :cond_0

    add-int v0, p4, v9

    invoke-virtual {v1}, Landroid/view/View;->getRight()I

    move-result v2

    if-ge v0, v2, :cond_0

    add-int v0, p5, v10

    invoke-virtual {v1}, Landroid/view/View;->getTop()I

    move-result v2

    if-lt v0, v2, :cond_0

    add-int v0, p5, v10

    invoke-virtual {v1}, Landroid/view/View;->getBottom()I

    move-result v2

    if-ge v0, v2, :cond_0

    const/4 v2, 0x1

    add-int v0, p4, v9

    invoke-virtual {v1}, Landroid/view/View;->getLeft()I

    move-result v3

    sub-int v4, v0, v3

    add-int v0, p5, v10

    invoke-virtual {v1}, Landroid/view/View;->getTop()I

    move-result v3

    sub-int v5, v0, v3

    move-object v0, p0

    move v3, p3

    invoke-virtual/range {v0 .. v5}, Landroid/support/v4/view/DraftViewPager;->canScroll(Landroid/view/View;ZIII)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1840
    const/4 v0, 0x1

    .line 1845
    .end local v1    # "child":Landroid/view/View;
    .end local v6    # "count":I
    .end local v7    # "group":Landroid/view/ViewGroup;
    .end local v8    # "i":I
    .end local v9    # "scrollX":I
    .end local v10    # "scrollY":I
    :goto_1
    return v0

    .line 1832
    .restart local v1    # "child":Landroid/view/View;
    .restart local v6    # "count":I
    .restart local v7    # "group":Landroid/view/ViewGroup;
    .restart local v8    # "i":I
    .restart local v9    # "scrollX":I
    .restart local v10    # "scrollY":I
    :cond_0
    add-int/lit8 v8, v8, -0x1

    goto :goto_0

    .line 1845
    .end local v1    # "child":Landroid/view/View;
    .end local v6    # "count":I
    .end local v7    # "group":Landroid/view/ViewGroup;
    .end local v8    # "i":I
    .end local v9    # "scrollX":I
    .end local v10    # "scrollY":I
    :cond_1
    if-eqz p2, :cond_2

    neg-int v0, p3

    invoke-static {p1, v0}, Landroid/support/v4/view/ViewCompat;->canScrollHorizontally(Landroid/view/View;I)Z

    move-result v0

    if-eqz v0, :cond_2

    const/4 v0, 0x1

    goto :goto_1

    :cond_2
    const/4 v0, 0x0

    goto :goto_1
.end method

.method protected checkLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Z
    .locals 1
    .param p1, "p"    # Landroid/view/ViewGroup$LayoutParams;

    .prologue
    .line 2073
    instance-of v0, p1, Landroid/support/v4/view/DraftViewPager$LayoutParams;

    if-eqz v0, :cond_0

    invoke-super {p0, p1}, Landroid/view/ViewGroup;->checkLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public computeScroll()V
    .locals 5

    .prologue
    .line 1178
    iget-object v4, p0, Landroid/support/v4/view/DraftViewPager;->mScroller:Landroid/widget/Scroller;

    invoke-virtual {v4}, Landroid/widget/Scroller;->isFinished()Z

    move-result v4

    if-nez v4, :cond_2

    .line 1179
    iget-object v4, p0, Landroid/support/v4/view/DraftViewPager;->mScroller:Landroid/widget/Scroller;

    invoke-virtual {v4}, Landroid/widget/Scroller;->computeScrollOffset()Z

    move-result v4

    if-eqz v4, :cond_2

    .line 1181
    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->getScrollX()I

    move-result v0

    .line 1182
    .local v0, "oldX":I
    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->getScrollY()I

    move-result v1

    .line 1183
    .local v1, "oldY":I
    iget-object v4, p0, Landroid/support/v4/view/DraftViewPager;->mScroller:Landroid/widget/Scroller;

    invoke-virtual {v4}, Landroid/widget/Scroller;->getCurrX()I

    move-result v2

    .line 1184
    .local v2, "x":I
    iget-object v4, p0, Landroid/support/v4/view/DraftViewPager;->mScroller:Landroid/widget/Scroller;

    invoke-virtual {v4}, Landroid/widget/Scroller;->getCurrY()I

    move-result v3

    .line 1186
    .local v3, "y":I
    if-ne v0, v2, :cond_0

    if-eq v1, v3, :cond_1

    .line 1187
    :cond_0
    invoke-virtual {p0, v2, v3}, Landroid/support/v4/view/DraftViewPager;->scrollTo(II)V

    .line 1188
    invoke-direct {p0, v2}, Landroid/support/v4/view/DraftViewPager;->pageScrolled(I)V

    .line 1192
    :cond_1
    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->invalidate()V

    .line 1199
    .end local v0    # "oldX":I
    .end local v1    # "oldY":I
    .end local v2    # "x":I
    .end local v3    # "y":I
    :goto_0
    return-void

    .line 1198
    :cond_2
    invoke-direct {p0}, Landroid/support/v4/view/DraftViewPager;->completeScroll()V

    goto :goto_0
.end method

.method dataSetChanged()V
    .locals 11

    .prologue
    const/4 v6, 0x1

    const/4 v7, 0x0

    .line 667
    iget-object v8, p0, Landroid/support/v4/view/DraftViewPager;->mItems:Ljava/util/ArrayList;

    invoke-virtual {v8}, Ljava/util/ArrayList;->size()I

    move-result v8

    const/4 v9, 0x3

    if-ge v8, v9, :cond_1

    iget-object v8, p0, Landroid/support/v4/view/DraftViewPager;->mItems:Ljava/util/ArrayList;

    invoke-virtual {v8}, Ljava/util/ArrayList;->size()I

    move-result v8

    iget-object v9, p0, Landroid/support/v4/view/DraftViewPager;->mAdapter:Landroid/support/v4/view/DraftPagerAdapter;

    invoke-virtual {v9}, Landroid/support/v4/view/DraftPagerAdapter;->getCount()I

    move-result v9

    if-ge v8, v9, :cond_1

    move v3, v6

    .line 668
    .local v3, "needPopulate":Z
    :goto_0
    const/4 v4, -0x1

    .line 670
    .local v4, "newCurrItem":I
    const/4 v2, 0x0

    .line 671
    .local v2, "isUpdating":Z
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    iget-object v8, p0, Landroid/support/v4/view/DraftViewPager;->mItems:Ljava/util/ArrayList;

    invoke-virtual {v8}, Ljava/util/ArrayList;->size()I

    move-result v8

    if-ge v0, v8, :cond_6

    .line 672
    iget-object v8, p0, Landroid/support/v4/view/DraftViewPager;->mItems:Ljava/util/ArrayList;

    invoke-virtual {v8, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/support/v4/view/DraftViewPager$ItemInfo;

    .line 673
    .local v1, "ii":Landroid/support/v4/view/DraftViewPager$ItemInfo;
    iget-object v8, p0, Landroid/support/v4/view/DraftViewPager;->mAdapter:Landroid/support/v4/view/DraftPagerAdapter;

    iget-object v9, v1, Landroid/support/v4/view/DraftViewPager$ItemInfo;->object:Ljava/lang/Object;

    invoke-virtual {v8, v9}, Landroid/support/v4/view/DraftPagerAdapter;->getItemPosition(Ljava/lang/Object;)I

    move-result v5

    .line 675
    .local v5, "newPos":I
    const/4 v8, -0x1

    if-ne v5, v8, :cond_2

    .line 671
    :cond_0
    :goto_2
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .end local v0    # "i":I
    .end local v1    # "ii":Landroid/support/v4/view/DraftViewPager$ItemInfo;
    .end local v2    # "isUpdating":Z
    .end local v3    # "needPopulate":Z
    .end local v4    # "newCurrItem":I
    .end local v5    # "newPos":I
    :cond_1
    move v3, v7

    .line 667
    goto :goto_0

    .line 679
    .restart local v0    # "i":I
    .restart local v1    # "ii":Landroid/support/v4/view/DraftViewPager$ItemInfo;
    .restart local v2    # "isUpdating":Z
    .restart local v3    # "needPopulate":Z
    .restart local v4    # "newCurrItem":I
    .restart local v5    # "newPos":I
    :cond_2
    const/4 v8, -0x2

    if-ne v5, v8, :cond_4

    .line 680
    iget-object v8, p0, Landroid/support/v4/view/DraftViewPager;->mItems:Ljava/util/ArrayList;

    invoke-virtual {v8, v0}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    .line 681
    add-int/lit8 v0, v0, -0x1

    .line 683
    if-nez v2, :cond_3

    .line 684
    iget-object v8, p0, Landroid/support/v4/view/DraftViewPager;->mAdapter:Landroid/support/v4/view/DraftPagerAdapter;

    invoke-virtual {v8, p0}, Landroid/support/v4/view/DraftPagerAdapter;->startUpdate(Landroid/view/ViewGroup;)V

    .line 685
    const/4 v2, 0x1

    .line 688
    :cond_3
    iget-object v8, p0, Landroid/support/v4/view/DraftViewPager;->mAdapter:Landroid/support/v4/view/DraftPagerAdapter;

    iget v9, v1, Landroid/support/v4/view/DraftViewPager$ItemInfo;->position:I

    iget-object v10, v1, Landroid/support/v4/view/DraftViewPager$ItemInfo;->object:Ljava/lang/Object;

    invoke-virtual {v8, p0, v9, v10}, Landroid/support/v4/view/DraftPagerAdapter;->destroyItem(Landroid/view/ViewGroup;ILjava/lang/Object;)V

    .line 689
    const/4 v3, 0x1

    .line 691
    iget v8, p0, Landroid/support/v4/view/DraftViewPager;->mCurItem:I

    iget v9, v1, Landroid/support/v4/view/DraftViewPager$ItemInfo;->position:I

    if-ne v8, v9, :cond_0

    .line 693
    iget v8, p0, Landroid/support/v4/view/DraftViewPager;->mCurItem:I

    iget-object v9, p0, Landroid/support/v4/view/DraftViewPager;->mAdapter:Landroid/support/v4/view/DraftPagerAdapter;

    invoke-virtual {v9}, Landroid/support/v4/view/DraftPagerAdapter;->getCount()I

    move-result v9

    add-int/lit8 v9, v9, -0x1

    invoke-static {v8, v9}, Ljava/lang/Math;->min(II)I

    move-result v8

    invoke-static {v7, v8}, Ljava/lang/Math;->max(II)I

    move-result v4

    goto :goto_2

    .line 698
    :cond_4
    iget v8, v1, Landroid/support/v4/view/DraftViewPager$ItemInfo;->position:I

    if-eq v8, v5, :cond_0

    .line 699
    iget v8, v1, Landroid/support/v4/view/DraftViewPager$ItemInfo;->position:I

    iget v9, p0, Landroid/support/v4/view/DraftViewPager;->mCurItem:I

    if-ne v8, v9, :cond_5

    .line 701
    move v4, v5

    .line 704
    :cond_5
    iput v5, v1, Landroid/support/v4/view/DraftViewPager$ItemInfo;->position:I

    .line 705
    const/4 v3, 0x1

    goto :goto_2

    .line 709
    .end local v1    # "ii":Landroid/support/v4/view/DraftViewPager$ItemInfo;
    .end local v5    # "newPos":I
    :cond_6
    if-eqz v2, :cond_7

    .line 710
    iget-object v8, p0, Landroid/support/v4/view/DraftViewPager;->mAdapter:Landroid/support/v4/view/DraftPagerAdapter;

    invoke-virtual {v8, p0}, Landroid/support/v4/view/DraftPagerAdapter;->finishUpdate(Landroid/view/ViewGroup;)V

    .line 713
    :cond_7
    iget-object v8, p0, Landroid/support/v4/view/DraftViewPager;->mItems:Ljava/util/ArrayList;

    sget-object v9, Landroid/support/v4/view/DraftViewPager;->COMPARATOR:Ljava/util/Comparator;

    invoke-static {v8, v9}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    .line 715
    if-ltz v4, :cond_8

    .line 717
    invoke-virtual {p0, v4, v7, v6}, Landroid/support/v4/view/DraftViewPager;->setCurrentItemInternal(IZZ)V

    .line 718
    const/4 v3, 0x1

    .line 720
    :cond_8
    if-eqz v3, :cond_9

    .line 721
    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->populate()V

    .line 722
    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->requestLayout()V

    .line 724
    :cond_9
    return-void
.end method

.method public dispatchKeyEvent(Landroid/view/KeyEvent;)Z
    .locals 1
    .param p1, "event"    # Landroid/view/KeyEvent;
        .annotation build Lorg/jetbrains/annotations/NotNull;
        .end annotation
    .end param

    .prologue
    .line 1851
    invoke-super {p0, p1}, Landroid/view/ViewGroup;->dispatchKeyEvent(Landroid/view/KeyEvent;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-virtual {p0, p1}, Landroid/support/v4/view/DraftViewPager;->executeKeyEvent(Landroid/view/KeyEvent;)Z

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

.method public dispatchPopulateAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)Z
    .locals 6
    .param p1, "event"    # Landroid/view/accessibility/AccessibilityEvent;

    .prologue
    .line 2046
    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->getChildCount()I

    move-result v1

    .line 2047
    .local v1, "childCount":I
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    if-ge v2, v1, :cond_1

    .line 2048
    invoke-virtual {p0, v2}, Landroid/support/v4/view/DraftViewPager;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 2049
    .local v0, "child":Landroid/view/View;
    invoke-virtual {v0}, Landroid/view/View;->getVisibility()I

    move-result v4

    if-nez v4, :cond_0

    .line 2050
    invoke-virtual {p0, v0}, Landroid/support/v4/view/DraftViewPager;->infoForChild(Landroid/view/View;)Landroid/support/v4/view/DraftViewPager$ItemInfo;

    move-result-object v3

    .line 2051
    .local v3, "ii":Landroid/support/v4/view/DraftViewPager$ItemInfo;
    if-eqz v3, :cond_0

    iget v4, v3, Landroid/support/v4/view/DraftViewPager$ItemInfo;->position:I

    iget v5, p0, Landroid/support/v4/view/DraftViewPager;->mCurItem:I

    if-ne v4, v5, :cond_0

    invoke-virtual {v0, p1}, Landroid/view/View;->dispatchPopulateAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 2053
    const/4 v4, 0x1

    .line 2058
    .end local v0    # "child":Landroid/view/View;
    .end local v3    # "ii":Landroid/support/v4/view/DraftViewPager$ItemInfo;
    :goto_1
    return v4

    .line 2047
    .restart local v0    # "child":Landroid/view/View;
    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 2058
    .end local v0    # "child":Landroid/view/View;
    :cond_1
    const/4 v4, 0x0

    goto :goto_1
.end method

.method distanceInfluenceForSnapDuration(F)F
    .locals 4
    .param p1, "f"    # F

    .prologue
    .line 599
    const/high16 v0, 0x3f000000    # 0.5f

    sub-float/2addr p1, v0

    .line 600
    float-to-double v0, p1

    const-wide v2, 0x3fde28c7460698c7L    # 0.4712389167638204

    mul-double/2addr v0, v2

    double-to-float p1, v0

    .line 601
    float-to-double v0, p1

    invoke-static {v0, v1}, Ljava/lang/Math;->sin(D)D

    move-result-wide v0

    double-to-float v0, v0

    return v0
.end method

.method public draw(Landroid/graphics/Canvas;)V
    .locals 9
    .param p1, "canvas"    # Landroid/graphics/Canvas;
        .annotation build Lorg/jetbrains/annotations/NotNull;
        .end annotation
    .end param

    .prologue
    const/4 v1, 0x1

    .line 1600
    invoke-super {p0, p1}, Landroid/view/ViewGroup;->draw(Landroid/graphics/Canvas;)V

    .line 1601
    const/4 v2, 0x0

    .line 1603
    .local v2, "needsInvalidate":Z
    invoke-static {p0}, Landroid/support/v4/view/ViewCompat;->getOverScrollMode(Landroid/view/View;)I

    move-result v3

    .line 1604
    .local v3, "overScrollMode":I
    if-eqz v3, :cond_0

    if-ne v3, v1, :cond_5

    iget-object v6, p0, Landroid/support/v4/view/DraftViewPager;->mAdapter:Landroid/support/v4/view/DraftPagerAdapter;

    if-eqz v6, :cond_5

    iget-object v6, p0, Landroid/support/v4/view/DraftViewPager;->mAdapter:Landroid/support/v4/view/DraftPagerAdapter;

    invoke-virtual {v6}, Landroid/support/v4/view/DraftPagerAdapter;->getCount()I

    move-result v6

    if-le v6, v1, :cond_5

    .line 1607
    :cond_0
    iget-object v6, p0, Landroid/support/v4/view/DraftViewPager;->mLeftEdge:Landroid/support/v4/widget/EdgeEffectCompat;

    invoke-virtual {v6}, Landroid/support/v4/widget/EdgeEffectCompat;->isFinished()Z

    move-result v6

    if-nez v6, :cond_1

    .line 1608
    invoke-virtual {p1}, Landroid/graphics/Canvas;->save()I

    move-result v4

    .line 1609
    .local v4, "restoreCount":I
    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->getHeight()I

    move-result v6

    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->getPaddingTop()I

    move-result v7

    sub-int/2addr v6, v7

    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->getPaddingBottom()I

    move-result v7

    sub-int v0, v6, v7

    .line 1611
    .local v0, "height":I
    const/high16 v6, 0x43870000    # 270.0f

    invoke-virtual {p1, v6}, Landroid/graphics/Canvas;->rotate(F)V

    .line 1612
    neg-int v6, v0

    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->getPaddingTop()I

    move-result v7

    add-int/2addr v6, v7

    int-to-float v6, v6

    const/4 v7, 0x0

    invoke-virtual {p1, v6, v7}, Landroid/graphics/Canvas;->translate(FF)V

    .line 1613
    iget-object v6, p0, Landroid/support/v4/view/DraftViewPager;->mLeftEdge:Landroid/support/v4/widget/EdgeEffectCompat;

    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->getWidth()I

    move-result v7

    invoke-virtual {v6, v0, v7}, Landroid/support/v4/widget/EdgeEffectCompat;->setSize(II)V

    .line 1614
    iget-object v6, p0, Landroid/support/v4/view/DraftViewPager;->mLeftEdge:Landroid/support/v4/widget/EdgeEffectCompat;

    invoke-virtual {v6, p1}, Landroid/support/v4/widget/EdgeEffectCompat;->draw(Landroid/graphics/Canvas;)Z

    move-result v6

    or-int/2addr v2, v6

    .line 1615
    invoke-virtual {p1, v4}, Landroid/graphics/Canvas;->restoreToCount(I)V

    .line 1617
    .end local v0    # "height":I
    .end local v4    # "restoreCount":I
    :cond_1
    iget-object v6, p0, Landroid/support/v4/view/DraftViewPager;->mRightEdge:Landroid/support/v4/widget/EdgeEffectCompat;

    invoke-virtual {v6}, Landroid/support/v4/widget/EdgeEffectCompat;->isFinished()Z

    move-result v6

    if-nez v6, :cond_3

    .line 1618
    invoke-virtual {p1}, Landroid/graphics/Canvas;->save()I

    move-result v4

    .line 1619
    .restart local v4    # "restoreCount":I
    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->getWidth()I

    move-result v5

    .line 1620
    .local v5, "width":I
    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->getHeight()I

    move-result v6

    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->getPaddingTop()I

    move-result v7

    sub-int/2addr v6, v7

    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->getPaddingBottom()I

    move-result v7

    sub-int v0, v6, v7

    .line 1621
    .restart local v0    # "height":I
    iget-object v6, p0, Landroid/support/v4/view/DraftViewPager;->mAdapter:Landroid/support/v4/view/DraftPagerAdapter;

    if-eqz v6, :cond_2

    iget-object v6, p0, Landroid/support/v4/view/DraftViewPager;->mAdapter:Landroid/support/v4/view/DraftPagerAdapter;

    invoke-virtual {v6}, Landroid/support/v4/view/DraftPagerAdapter;->getCount()I

    move-result v1

    .line 1623
    .local v1, "itemCount":I
    :cond_2
    const/high16 v6, 0x42b40000    # 90.0f

    invoke-virtual {p1, v6}, Landroid/graphics/Canvas;->rotate(F)V

    .line 1624
    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->getPaddingTop()I

    move-result v6

    neg-int v6, v6

    int-to-float v6, v6

    neg-int v7, v1

    iget v8, p0, Landroid/support/v4/view/DraftViewPager;->mPageMargin:I

    add-int/2addr v8, v5

    mul-int/2addr v7, v8

    iget v8, p0, Landroid/support/v4/view/DraftViewPager;->mPageMargin:I

    add-int/2addr v7, v8

    int-to-float v7, v7

    invoke-virtual {p1, v6, v7}, Landroid/graphics/Canvas;->translate(FF)V

    .line 1626
    iget-object v6, p0, Landroid/support/v4/view/DraftViewPager;->mRightEdge:Landroid/support/v4/widget/EdgeEffectCompat;

    invoke-virtual {v6, v0, v5}, Landroid/support/v4/widget/EdgeEffectCompat;->setSize(II)V

    .line 1627
    iget-object v6, p0, Landroid/support/v4/view/DraftViewPager;->mRightEdge:Landroid/support/v4/widget/EdgeEffectCompat;

    invoke-virtual {v6, p1}, Landroid/support/v4/widget/EdgeEffectCompat;->draw(Landroid/graphics/Canvas;)Z

    move-result v6

    or-int/2addr v2, v6

    .line 1628
    invoke-virtual {p1, v4}, Landroid/graphics/Canvas;->restoreToCount(I)V

    .line 1635
    .end local v0    # "height":I
    .end local v1    # "itemCount":I
    .end local v4    # "restoreCount":I
    .end local v5    # "width":I
    :cond_3
    :goto_0
    if-eqz v2, :cond_4

    .line 1637
    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->invalidate()V

    .line 1639
    :cond_4
    return-void

    .line 1631
    :cond_5
    iget-object v6, p0, Landroid/support/v4/view/DraftViewPager;->mLeftEdge:Landroid/support/v4/widget/EdgeEffectCompat;

    invoke-virtual {v6}, Landroid/support/v4/widget/EdgeEffectCompat;->finish()V

    .line 1632
    iget-object v6, p0, Landroid/support/v4/view/DraftViewPager;->mRightEdge:Landroid/support/v4/widget/EdgeEffectCompat;

    invoke-virtual {v6}, Landroid/support/v4/widget/EdgeEffectCompat;->finish()V

    goto :goto_0
.end method

.method protected drawableStateChanged()V
    .locals 2

    .prologue
    .line 587
    invoke-super {p0}, Landroid/view/ViewGroup;->drawableStateChanged()V

    .line 588
    iget-object v0, p0, Landroid/support/v4/view/DraftViewPager;->mMarginDrawable:Landroid/graphics/drawable/Drawable;

    .line 589
    .local v0, "d":Landroid/graphics/drawable/Drawable;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->isStateful()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 590
    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->getDrawableState()[I

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/graphics/drawable/Drawable;->setState([I)Z

    .line 592
    :cond_0
    return-void
.end method

.method public endFakeDrag()V
    .locals 11

    .prologue
    const/4 v10, 0x1

    .line 1703
    iget-boolean v8, p0, Landroid/support/v4/view/DraftViewPager;->mFakeDragging:Z

    if-nez v8, :cond_0

    .line 1704
    new-instance v8, Ljava/lang/IllegalStateException;

    const-string v9, "No fake drag in progress. Call beginFakeDrag first."

    invoke-direct {v8, v9}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v8

    .line 1707
    :cond_0
    iget-object v6, p0, Landroid/support/v4/view/DraftViewPager;->mVelocityTracker:Landroid/view/VelocityTracker;

    .line 1708
    .local v6, "velocityTracker":Landroid/view/VelocityTracker;
    const/16 v8, 0x3e8

    iget v9, p0, Landroid/support/v4/view/DraftViewPager;->mMaximumVelocity:I

    int-to-float v9, v9

    invoke-virtual {v6, v8, v9}, Landroid/view/VelocityTracker;->computeCurrentVelocity(IF)V

    .line 1709
    iget v8, p0, Landroid/support/v4/view/DraftViewPager;->mActivePointerId:I

    invoke-static {v6, v8}, Landroid/support/v4/view/VelocityTrackerCompat;->getYVelocity(Landroid/view/VelocityTracker;I)F

    move-result v8

    float-to-int v1, v8

    .line 1711
    .local v1, "initialVelocity":I
    iput-boolean v10, p0, Landroid/support/v4/view/DraftViewPager;->mPopulatePending:Z

    .line 1712
    iget v8, p0, Landroid/support/v4/view/DraftViewPager;->mLastMotionX:F

    iget v9, p0, Landroid/support/v4/view/DraftViewPager;->mInitialMotionX:F

    sub-float/2addr v8, v9

    float-to-int v5, v8

    .line 1713
    .local v5, "totalDelta":I
    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->getScrollX()I

    move-result v4

    .line 1714
    .local v4, "scrollX":I
    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->getWidth()I

    move-result v8

    iget v9, p0, Landroid/support/v4/view/DraftViewPager;->mPageMargin:I

    add-int v7, v8, v9

    .line 1715
    .local v7, "widthWithMargin":I
    div-int v0, v4, v7

    .line 1716
    .local v0, "currentPage":I
    rem-int v8, v4, v7

    int-to-float v8, v8

    int-to-float v9, v7

    div-float v3, v8, v9

    .line 1717
    .local v3, "pageOffset":F
    invoke-direct {p0, v0, v3, v1, v5}, Landroid/support/v4/view/DraftViewPager;->determineTargetPage(IFII)I

    move-result v2

    .line 1718
    .local v2, "nextPage":I
    invoke-virtual {p0, v2, v10, v10, v1}, Landroid/support/v4/view/DraftViewPager;->setCurrentItemInternal(IZZI)V

    .line 1719
    invoke-direct {p0}, Landroid/support/v4/view/DraftViewPager;->endDrag()V

    .line 1721
    const/4 v8, 0x0

    iput-boolean v8, p0, Landroid/support/v4/view/DraftViewPager;->mFakeDragging:Z

    .line 1722
    return-void
.end method

.method public executeKeyEvent(Landroid/view/KeyEvent;)Z
    .locals 4
    .param p1, "event"    # Landroid/view/KeyEvent;

    .prologue
    const/4 v3, 0x1

    .line 1863
    const/4 v0, 0x0

    .line 1864
    .local v0, "handled":Z
    invoke-virtual {p1}, Landroid/view/KeyEvent;->getAction()I

    move-result v1

    if-nez v1, :cond_0

    .line 1865
    invoke-virtual {p1}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v1

    sparse-switch v1, :sswitch_data_0

    .line 1885
    :cond_0
    :goto_0
    return v0

    .line 1867
    :sswitch_0
    const/16 v1, 0x11

    invoke-virtual {p0, v1}, Landroid/support/v4/view/DraftViewPager;->arrowScroll(I)Z

    move-result v0

    .line 1868
    goto :goto_0

    .line 1870
    :sswitch_1
    const/16 v1, 0x42

    invoke-virtual {p0, v1}, Landroid/support/v4/view/DraftViewPager;->arrowScroll(I)Z

    move-result v0

    .line 1871
    goto :goto_0

    .line 1873
    :sswitch_2
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0xb

    if-lt v1, v2, :cond_0

    .line 1876
    invoke-static {p1}, Landroid/support/v4/view/KeyEventCompat;->hasNoModifiers(Landroid/view/KeyEvent;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 1877
    const/4 v1, 0x2

    invoke-virtual {p0, v1}, Landroid/support/v4/view/DraftViewPager;->arrowScroll(I)Z

    move-result v0

    goto :goto_0

    .line 1878
    :cond_1
    invoke-static {p1, v3}, Landroid/support/v4/view/KeyEventCompat;->hasModifiers(Landroid/view/KeyEvent;I)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 1879
    invoke-virtual {p0, v3}, Landroid/support/v4/view/DraftViewPager;->arrowScroll(I)Z

    move-result v0

    goto :goto_0

    .line 1865
    nop

    :sswitch_data_0
    .sparse-switch
        0x15 -> :sswitch_0
        0x16 -> :sswitch_1
        0x3d -> :sswitch_2
    .end sparse-switch
.end method

.method public fakeDragBy(F)V
    .locals 14
    .param p1, "xOffset"    # F

    .prologue
    const/4 v7, 0x0

    .line 1732
    iget-boolean v0, p0, Landroid/support/v4/view/DraftViewPager;->mFakeDragging:Z

    if-nez v0, :cond_0

    .line 1733
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "No fake drag in progress. Call beginFakeDrag first."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1736
    :cond_0
    iget v0, p0, Landroid/support/v4/view/DraftViewPager;->mLastMotionX:F

    add-float/2addr v0, p1

    iput v0, p0, Landroid/support/v4/view/DraftViewPager;->mLastMotionX:F

    .line 1737
    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->getScrollX()I

    move-result v0

    int-to-float v0, v0

    sub-float v11, v0, p1

    .line 1738
    .local v11, "scrollX":F
    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->getWidth()I

    move-result v12

    .line 1739
    .local v12, "width":I
    iget v0, p0, Landroid/support/v4/view/DraftViewPager;->mPageMargin:I

    add-int v13, v12, v0

    .line 1741
    .local v13, "widthWithMargin":I
    iget v0, p0, Landroid/support/v4/view/DraftViewPager;->mCurItem:I

    add-int/lit8 v0, v0, -0x1

    mul-int/2addr v0, v13

    invoke-static {v7, v0}, Ljava/lang/Math;->max(II)I

    move-result v0

    int-to-float v9, v0

    .line 1742
    .local v9, "leftBound":F
    iget v0, p0, Landroid/support/v4/view/DraftViewPager;->mCurItem:I

    add-int/lit8 v0, v0, 0x1

    iget-object v1, p0, Landroid/support/v4/view/DraftViewPager;->mAdapter:Landroid/support/v4/view/DraftPagerAdapter;

    invoke-virtual {v1}, Landroid/support/v4/view/DraftPagerAdapter;->getCount()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    invoke-static {v0, v1}, Ljava/lang/Math;->min(II)I

    move-result v0

    mul-int/2addr v0, v13

    int-to-float v10, v0

    .line 1744
    .local v10, "rightBound":F
    cmpg-float v0, v11, v9

    if-gez v0, :cond_2

    .line 1745
    move v11, v9

    .line 1750
    :cond_1
    :goto_0
    iget v0, p0, Landroid/support/v4/view/DraftViewPager;->mLastMotionX:F

    float-to-int v1, v11

    int-to-float v1, v1

    sub-float v1, v11, v1

    add-float/2addr v0, v1

    iput v0, p0, Landroid/support/v4/view/DraftViewPager;->mLastMotionX:F

    .line 1751
    float-to-int v0, v11

    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->getScrollY()I

    move-result v1

    invoke-virtual {p0, v0, v1}, Landroid/support/v4/view/DraftViewPager;->scrollTo(II)V

    .line 1752
    float-to-int v0, v11

    invoke-direct {p0, v0}, Landroid/support/v4/view/DraftViewPager;->pageScrolled(I)V

    .line 1755
    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v2

    .line 1756
    .local v2, "time":J
    iget-wide v0, p0, Landroid/support/v4/view/DraftViewPager;->mFakeDragBeginTime:J

    const/4 v4, 0x2

    iget v5, p0, Landroid/support/v4/view/DraftViewPager;->mLastMotionX:F

    const/4 v6, 0x0

    invoke-static/range {v0 .. v7}, Landroid/view/MotionEvent;->obtain(JJIFFI)Landroid/view/MotionEvent;

    move-result-object v8

    .line 1758
    .local v8, "ev":Landroid/view/MotionEvent;
    iget-object v0, p0, Landroid/support/v4/view/DraftViewPager;->mVelocityTracker:Landroid/view/VelocityTracker;

    invoke-virtual {v0, v8}, Landroid/view/VelocityTracker;->addMovement(Landroid/view/MotionEvent;)V

    .line 1759
    invoke-virtual {v8}, Landroid/view/MotionEvent;->recycle()V

    .line 1760
    return-void

    .line 1746
    .end local v2    # "time":J
    .end local v8    # "ev":Landroid/view/MotionEvent;
    :cond_2
    cmpl-float v0, v11, v10

    if-lez v0, :cond_1

    .line 1747
    move v11, v10

    goto :goto_0
.end method

.method protected generateDefaultLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    .locals 1

    .prologue
    .line 2063
    new-instance v0, Landroid/support/v4/view/DraftViewPager$LayoutParams;

    invoke-direct {v0}, Landroid/support/v4/view/DraftViewPager$LayoutParams;-><init>()V

    return-object v0
.end method

.method public generateLayoutParams(Landroid/util/AttributeSet;)Landroid/view/ViewGroup$LayoutParams;
    .locals 2
    .param p1, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 2078
    new-instance v0, Landroid/support/v4/view/DraftViewPager$LayoutParams;

    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1, p1}, Landroid/support/v4/view/DraftViewPager$LayoutParams;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    return-object v0
.end method

.method protected generateLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Landroid/view/ViewGroup$LayoutParams;
    .locals 1
    .param p1, "p"    # Landroid/view/ViewGroup$LayoutParams;

    .prologue
    .line 2068
    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->generateDefaultLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    return-object v0
.end method

.method public getAdapter()Landroid/support/v4/view/DraftPagerAdapter;
    .locals 1

    .prologue
    .line 361
    iget-object v0, p0, Landroid/support/v4/view/DraftViewPager;->mAdapter:Landroid/support/v4/view/DraftPagerAdapter;

    return-object v0
.end method

.method public getCurrentItem()I
    .locals 1

    .prologue
    .line 392
    iget v0, p0, Landroid/support/v4/view/DraftViewPager;->mCurItem:I

    return v0
.end method

.method public getLeftOfSelectedFragment()I
    .locals 4

    .prologue
    .line 2124
    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->getWidth()I

    move-result v0

    .line 2125
    .local v0, "width":I
    int-to-float v1, v0

    int-to-float v2, v0

    iget v3, p0, Landroid/support/v4/view/DraftViewPager;->mPreviewRatio:F

    mul-float/2addr v2, v3

    sub-float/2addr v1, v2

    float-to-int v1, v1

    div-int/lit8 v1, v1, 0x2

    return v1
.end method

.method public getOffscreenPageLimit()I
    .locals 1

    .prologue
    .line 500
    iget v0, p0, Landroid/support/v4/view/DraftViewPager;->mOffscreenPageLimit:I

    return v0
.end method

.method public getPageMargin()I
    .locals 1

    .prologue
    .line 556
    iget v0, p0, Landroid/support/v4/view/DraftViewPager;->mPageMargin:I

    return v0
.end method

.method infoForAnyChild(Landroid/view/View;)Landroid/support/v4/view/DraftViewPager$ItemInfo;
    .locals 2
    .param p1, "child"    # Landroid/view/View;

    .prologue
    .line 952
    :goto_0
    invoke-virtual {p1}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    .local v0, "parent":Landroid/view/ViewParent;
    if-eq v0, p0, :cond_2

    .line 953
    if-eqz v0, :cond_0

    instance-of v1, v0, Landroid/view/View;

    if-nez v1, :cond_1

    .line 954
    :cond_0
    const/4 v1, 0x0

    .line 958
    :goto_1
    return-object v1

    :cond_1
    move-object p1, v0

    .line 956
    check-cast p1, Landroid/view/View;

    goto :goto_0

    .line 958
    :cond_2
    invoke-virtual {p0, p1}, Landroid/support/v4/view/DraftViewPager;->infoForChild(Landroid/view/View;)Landroid/support/v4/view/DraftViewPager$ItemInfo;

    move-result-object v1

    goto :goto_1
.end method

.method infoForChild(Landroid/view/View;)Landroid/support/v4/view/DraftViewPager$ItemInfo;
    .locals 4
    .param p1, "child"    # Landroid/view/View;

    .prologue
    .line 941
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v2, p0, Landroid/support/v4/view/DraftViewPager;->mItems:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-ge v0, v2, :cond_1

    .line 942
    iget-object v2, p0, Landroid/support/v4/view/DraftViewPager;->mItems:Ljava/util/ArrayList;

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/support/v4/view/DraftViewPager$ItemInfo;

    .line 943
    .local v1, "ii":Landroid/support/v4/view/DraftViewPager$ItemInfo;
    iget-object v2, p0, Landroid/support/v4/view/DraftViewPager;->mAdapter:Landroid/support/v4/view/DraftPagerAdapter;

    iget-object v3, v1, Landroid/support/v4/view/DraftViewPager$ItemInfo;->object:Ljava/lang/Object;

    invoke-virtual {v2, p1, v3}, Landroid/support/v4/view/DraftPagerAdapter;->isViewFromObject(Landroid/view/View;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 947
    .end local v1    # "ii":Landroid/support/v4/view/DraftViewPager$ItemInfo;
    :goto_1
    return-object v1

    .line 941
    .restart local v1    # "ii":Landroid/support/v4/view/DraftViewPager$ItemInfo;
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 947
    .end local v1    # "ii":Landroid/support/v4/view/DraftViewPager$ItemInfo;
    :cond_1
    const/4 v1, 0x0

    goto :goto_1
.end method

.method initViewPager()V
    .locals 5

    .prologue
    .line 272
    const/4 v3, 0x0

    invoke-virtual {p0, v3}, Landroid/support/v4/view/DraftViewPager;->setWillNotDraw(Z)V

    .line 273
    const/high16 v3, 0x40000

    invoke-virtual {p0, v3}, Landroid/support/v4/view/DraftViewPager;->setDescendantFocusability(I)V

    .line 274
    const/4 v3, 0x1

    invoke-virtual {p0, v3}, Landroid/support/v4/view/DraftViewPager;->setFocusable(Z)V

    .line 275
    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->getContext()Landroid/content/Context;

    move-result-object v1

    .line 276
    .local v1, "context":Landroid/content/Context;
    new-instance v3, Landroid/widget/Scroller;

    sget-object v4, Landroid/support/v4/view/DraftViewPager;->sInterpolator:Landroid/view/animation/Interpolator;

    invoke-direct {v3, v1, v4}, Landroid/widget/Scroller;-><init>(Landroid/content/Context;Landroid/view/animation/Interpolator;)V

    iput-object v3, p0, Landroid/support/v4/view/DraftViewPager;->mScroller:Landroid/widget/Scroller;

    .line 277
    invoke-static {v1}, Landroid/view/ViewConfiguration;->get(Landroid/content/Context;)Landroid/view/ViewConfiguration;

    move-result-object v0

    .line 278
    .local v0, "configuration":Landroid/view/ViewConfiguration;
    invoke-static {v0}, Landroid/support/v4/view/ViewConfigurationCompat;->getScaledPagingTouchSlop(Landroid/view/ViewConfiguration;)I

    move-result v3

    iput v3, p0, Landroid/support/v4/view/DraftViewPager;->mTouchSlop:I

    .line 279
    invoke-virtual {v0}, Landroid/view/ViewConfiguration;->getScaledMinimumFlingVelocity()I

    move-result v3

    iput v3, p0, Landroid/support/v4/view/DraftViewPager;->mMinimumVelocity:I

    .line 280
    invoke-virtual {v0}, Landroid/view/ViewConfiguration;->getScaledMaximumFlingVelocity()I

    move-result v3

    iput v3, p0, Landroid/support/v4/view/DraftViewPager;->mMaximumVelocity:I

    .line 281
    new-instance v3, Landroid/support/v4/widget/EdgeEffectCompat;

    invoke-direct {v3, v1}, Landroid/support/v4/widget/EdgeEffectCompat;-><init>(Landroid/content/Context;)V

    iput-object v3, p0, Landroid/support/v4/view/DraftViewPager;->mLeftEdge:Landroid/support/v4/widget/EdgeEffectCompat;

    .line 282
    new-instance v3, Landroid/support/v4/widget/EdgeEffectCompat;

    invoke-direct {v3, v1}, Landroid/support/v4/widget/EdgeEffectCompat;-><init>(Landroid/content/Context;)V

    iput-object v3, p0, Landroid/support/v4/view/DraftViewPager;->mRightEdge:Landroid/support/v4/widget/EdgeEffectCompat;

    .line 284
    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v3

    iget v2, v3, Landroid/util/DisplayMetrics;->density:F

    .line 285
    .local v2, "density":F
    const/high16 v3, 0x41c80000    # 25.0f

    mul-float/2addr v3, v2

    float-to-int v3, v3

    iput v3, p0, Landroid/support/v4/view/DraftViewPager;->mFlingDistance:I

    .line 286
    return-void
.end method

.method public isDrawn()Z
    .locals 1

    .prologue
    .line 467
    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->getWidth()I

    move-result v0

    if-lez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isFakeDragging()Z
    .locals 1

    .prologue
    .line 1771
    iget-boolean v0, p0, Landroid/support/v4/view/DraftViewPager;->mFakeDragging:Z

    return v0
.end method

.method protected onAttachedToWindow()V
    .locals 1

    .prologue
    .line 963
    invoke-super {p0}, Landroid/view/ViewGroup;->onAttachedToWindow()V

    .line 964
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v4/view/DraftViewPager;->mFirstLayout:Z

    .line 965
    return-void
.end method

.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 8
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 1643
    invoke-super {p0, p1}, Landroid/view/ViewGroup;->onDraw(Landroid/graphics/Canvas;)V

    .line 1646
    iget v4, p0, Landroid/support/v4/view/DraftViewPager;->mPageMargin:I

    if-lez v4, :cond_0

    iget-object v4, p0, Landroid/support/v4/view/DraftViewPager;->mMarginDrawable:Landroid/graphics/drawable/Drawable;

    if-eqz v4, :cond_0

    .line 1647
    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->getScrollX()I

    move-result v2

    .line 1648
    .local v2, "scrollX":I
    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->getWidth()I

    move-result v3

    .line 1649
    .local v3, "width":I
    iget v4, p0, Landroid/support/v4/view/DraftViewPager;->mPageMargin:I

    add-int/2addr v4, v3

    rem-int v1, v2, v4

    .line 1650
    .local v1, "offset":I
    if-eqz v1, :cond_0

    .line 1652
    sub-int v4, v2, v1

    add-int v0, v4, v3

    .line 1653
    .local v0, "left":I
    iget-object v4, p0, Landroid/support/v4/view/DraftViewPager;->mMarginDrawable:Landroid/graphics/drawable/Drawable;

    iget v5, p0, Landroid/support/v4/view/DraftViewPager;->mTopPageBounds:I

    iget v6, p0, Landroid/support/v4/view/DraftViewPager;->mPageMargin:I

    add-int/2addr v6, v0

    iget v7, p0, Landroid/support/v4/view/DraftViewPager;->mBottomPageBounds:I

    invoke-virtual {v4, v0, v5, v6, v7}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 1655
    iget-object v4, p0, Landroid/support/v4/view/DraftViewPager;->mMarginDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v4, p1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 1658
    .end local v0    # "left":I
    .end local v1    # "offset":I
    .end local v2    # "scrollX":I
    .end local v3    # "width":I
    :cond_0
    return-void
.end method

.method public onInterceptTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 14
    .param p1, "ev"    # Landroid/view/MotionEvent;

    .prologue
    .line 1314
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    and-int/lit16 v6, v0, 0xff

    .line 1317
    .local v6, "action":I
    const/4 v0, 0x3

    if-eq v6, v0, :cond_0

    const/4 v0, 0x1

    if-ne v6, v0, :cond_2

    .line 1320
    :cond_0
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/support/v4/view/DraftViewPager;->mIsBeingDragged:Z

    .line 1321
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/support/v4/view/DraftViewPager;->mIsUnableToDrag:Z

    .line 1322
    const/4 v0, -0x1

    iput v0, p0, Landroid/support/v4/view/DraftViewPager;->mActivePointerId:I

    .line 1323
    iget-object v0, p0, Landroid/support/v4/view/DraftViewPager;->mVelocityTracker:Landroid/view/VelocityTracker;

    if-eqz v0, :cond_1

    .line 1324
    iget-object v0, p0, Landroid/support/v4/view/DraftViewPager;->mVelocityTracker:Landroid/view/VelocityTracker;

    invoke-virtual {v0}, Landroid/view/VelocityTracker;->recycle()V

    .line 1325
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/support/v4/view/DraftViewPager;->mVelocityTracker:Landroid/view/VelocityTracker;

    .line 1327
    :cond_1
    const/4 v0, 0x0

    .line 1437
    :goto_0
    return v0

    .line 1332
    :cond_2
    if-eqz v6, :cond_4

    .line 1333
    iget-boolean v0, p0, Landroid/support/v4/view/DraftViewPager;->mIsBeingDragged:Z

    if-eqz v0, :cond_3

    .line 1335
    const/4 v0, 0x1

    goto :goto_0

    .line 1337
    :cond_3
    iget-boolean v0, p0, Landroid/support/v4/view/DraftViewPager;->mIsUnableToDrag:Z

    if-eqz v0, :cond_4

    .line 1339
    const/4 v0, 0x0

    goto :goto_0

    .line 1343
    :cond_4
    sparse-switch v6, :sswitch_data_0

    .line 1424
    :cond_5
    :goto_1
    iget-boolean v0, p0, Landroid/support/v4/view/DraftViewPager;->mIsBeingDragged:Z

    if-nez v0, :cond_7

    .line 1427
    iget-object v0, p0, Landroid/support/v4/view/DraftViewPager;->mVelocityTracker:Landroid/view/VelocityTracker;

    if-nez v0, :cond_6

    .line 1428
    invoke-static {}, Landroid/view/VelocityTracker;->obtain()Landroid/view/VelocityTracker;

    move-result-object v0

    iput-object v0, p0, Landroid/support/v4/view/DraftViewPager;->mVelocityTracker:Landroid/view/VelocityTracker;

    .line 1430
    :cond_6
    iget-object v0, p0, Landroid/support/v4/view/DraftViewPager;->mVelocityTracker:Landroid/view/VelocityTracker;

    invoke-virtual {v0, p1}, Landroid/view/VelocityTracker;->addMovement(Landroid/view/MotionEvent;)V

    .line 1437
    :cond_7
    iget-boolean v0, p0, Landroid/support/v4/view/DraftViewPager;->mIsBeingDragged:Z

    goto :goto_0

    .line 1354
    :sswitch_0
    iget v7, p0, Landroid/support/v4/view/DraftViewPager;->mActivePointerId:I

    .line 1355
    .local v7, "activePointerId":I
    const/4 v0, -0x1

    if-eq v7, v0, :cond_5

    .line 1360
    invoke-static {p1, v7}, Landroid/support/v4/view/MotionEventCompat;->findPointerIndex(Landroid/view/MotionEvent;I)I

    move-result v9

    .line 1361
    .local v9, "pointerIndex":I
    invoke-static {p1, v9}, Landroid/support/v4/view/MotionEventCompat;->getX(Landroid/view/MotionEvent;I)F

    move-result v10

    .line 1362
    .local v10, "x":F
    iget v0, p0, Landroid/support/v4/view/DraftViewPager;->mLastMotionX:F

    sub-float v8, v10, v0

    .line 1363
    .local v8, "dx":F
    invoke-static {v8}, Ljava/lang/Math;->abs(F)F

    move-result v11

    .line 1364
    .local v11, "xDiff":F
    invoke-static {p1, v9}, Landroid/support/v4/view/MotionEventCompat;->getY(Landroid/view/MotionEvent;I)F

    move-result v12

    .line 1365
    .local v12, "y":F
    iget v0, p0, Landroid/support/v4/view/DraftViewPager;->mLastMotionY:F

    sub-float v0, v12, v0

    invoke-static {v0}, Ljava/lang/Math;->abs(F)F

    move-result v13

    .line 1368
    .local v13, "yDiff":F
    const/4 v2, 0x0

    float-to-int v3, v8

    float-to-int v4, v10

    float-to-int v5, v12

    move-object v0, p0

    move-object v1, p0

    invoke-virtual/range {v0 .. v5}, Landroid/support/v4/view/DraftViewPager;->canScroll(Landroid/view/View;ZIII)Z

    move-result v0

    if-eqz v0, :cond_8

    .line 1370
    iput v10, p0, Landroid/support/v4/view/DraftViewPager;->mLastMotionX:F

    iput v10, p0, Landroid/support/v4/view/DraftViewPager;->mInitialMotionX:F

    .line 1371
    iput v12, p0, Landroid/support/v4/view/DraftViewPager;->mLastMotionY:F

    .line 1372
    const/4 v0, 0x0

    goto :goto_0

    .line 1374
    :cond_8
    iget v0, p0, Landroid/support/v4/view/DraftViewPager;->mTouchSlop:I

    int-to-float v0, v0

    cmpl-float v0, v11, v0

    if-lez v0, :cond_9

    cmpl-float v0, v11, v13

    if-lez v0, :cond_9

    .line 1376
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v4/view/DraftViewPager;->mIsBeingDragged:Z

    .line 1377
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Landroid/support/v4/view/DraftViewPager;->setScrollState(I)V

    .line 1378
    iput v10, p0, Landroid/support/v4/view/DraftViewPager;->mLastMotionX:F

    .line 1379
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Landroid/support/v4/view/DraftViewPager;->setScrollingCacheEnabled(Z)V

    goto :goto_1

    .line 1381
    :cond_9
    iget v0, p0, Landroid/support/v4/view/DraftViewPager;->mTouchSlop:I

    int-to-float v0, v0

    cmpl-float v0, v13, v0

    if-lez v0, :cond_5

    .line 1387
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v4/view/DraftViewPager;->mIsUnableToDrag:Z

    goto :goto_1

    .line 1398
    .end local v7    # "activePointerId":I
    .end local v8    # "dx":F
    .end local v9    # "pointerIndex":I
    .end local v10    # "x":F
    .end local v11    # "xDiff":F
    .end local v12    # "y":F
    .end local v13    # "yDiff":F
    :sswitch_1
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v0

    iput v0, p0, Landroid/support/v4/view/DraftViewPager;->mInitialMotionX:F

    iput v0, p0, Landroid/support/v4/view/DraftViewPager;->mLastMotionX:F

    .line 1399
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v0

    iput v0, p0, Landroid/support/v4/view/DraftViewPager;->mLastMotionY:F

    .line 1400
    const/4 v0, 0x0

    invoke-static {p1, v0}, Landroid/support/v4/view/MotionEventCompat;->getPointerId(Landroid/view/MotionEvent;I)I

    move-result v0

    iput v0, p0, Landroid/support/v4/view/DraftViewPager;->mActivePointerId:I

    .line 1402
    iget v0, p0, Landroid/support/v4/view/DraftViewPager;->mScrollState:I

    const/4 v1, 0x2

    if-ne v0, v1, :cond_a

    .line 1404
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v4/view/DraftViewPager;->mIsBeingDragged:Z

    .line 1405
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/support/v4/view/DraftViewPager;->mIsUnableToDrag:Z

    .line 1406
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Landroid/support/v4/view/DraftViewPager;->setScrollState(I)V

    goto/16 :goto_1

    .line 1408
    :cond_a
    invoke-direct {p0}, Landroid/support/v4/view/DraftViewPager;->completeScroll()V

    .line 1409
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/support/v4/view/DraftViewPager;->mIsBeingDragged:Z

    .line 1410
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/support/v4/view/DraftViewPager;->mIsUnableToDrag:Z

    goto/16 :goto_1

    .line 1420
    :sswitch_2
    invoke-direct {p0, p1}, Landroid/support/v4/view/DraftViewPager;->onSecondaryPointerUp(Landroid/view/MotionEvent;)V

    goto/16 :goto_1

    .line 1343
    nop

    :sswitch_data_0
    .sparse-switch
        0x0 -> :sswitch_1
        0x2 -> :sswitch_0
        0x6 -> :sswitch_2
    .end sparse-switch
.end method

.method protected onLayout(ZIIII)V
    .locals 28
    .param p1, "changed"    # Z
    .param p2, "l"    # I
    .param p3, "t"    # I
    .param p4, "r"    # I
    .param p5, "b"    # I

    .prologue
    .line 1078
    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/view/DraftViewPager;->getChildCount()I

    move-result v6

    .line 1080
    .local v6, "count":I
    const/16 v25, 0x1

    move/from16 v0, v25

    move-object/from16 v1, p0

    iput-boolean v0, v1, Landroid/support/v4/view/DraftViewPager;->mInLayout:Z

    .line 1081
    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/view/DraftViewPager;->populate()V

    .line 1082
    const/16 v25, 0x0

    move/from16 v0, v25

    move-object/from16 v1, p0

    iput-boolean v0, v1, Landroid/support/v4/view/DraftViewPager;->mInLayout:Z

    .line 1084
    sub-int v24, p4, p2

    .line 1085
    .local v24, "width":I
    sub-int v9, p5, p3

    .line 1086
    .local v9, "height":I
    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/view/DraftViewPager;->getScrollX()I

    move-result v22

    .line 1087
    .local v22, "scrollX":I
    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/view/DraftViewPager;->getPaddingLeft()I

    move-result v18

    .line 1088
    .local v18, "paddingLeft":I
    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/view/DraftViewPager;->getPaddingTop()I

    move-result v20

    .line 1089
    .local v20, "paddingTop":I
    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/view/DraftViewPager;->getPaddingRight()I

    move-result v19

    .line 1090
    .local v19, "paddingRight":I
    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/view/DraftViewPager;->getPaddingBottom()I

    move-result v17

    .line 1092
    .local v17, "paddingBottom":I
    const/4 v7, 0x0

    .line 1094
    .local v7, "decorCount":I
    const/4 v11, 0x0

    .local v11, "i":I
    :goto_0
    if-ge v11, v6, :cond_3

    .line 1095
    move-object/from16 v0, p0

    invoke-virtual {v0, v11}, Landroid/support/v4/view/DraftViewPager;->getChildAt(I)Landroid/view/View;

    move-result-object v3

    .line 1096
    .local v3, "child":Landroid/view/View;
    invoke-virtual {v3}, Landroid/view/View;->getVisibility()I

    move-result v25

    const/16 v26, 0x8

    move/from16 v0, v25

    move/from16 v1, v26

    if-eq v0, v1, :cond_0

    .line 1097
    invoke-virtual {v3}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v14

    check-cast v14, Landroid/support/v4/view/DraftViewPager$LayoutParams;

    .line 1099
    .local v14, "lp":Landroid/support/v4/view/DraftViewPager$LayoutParams;
    const/4 v4, 0x0

    .line 1100
    .local v4, "childLeft":I
    const/4 v5, 0x0

    .line 1101
    .local v5, "childTop":I
    iget-boolean v0, v14, Landroid/support/v4/view/DraftViewPager$LayoutParams;->isDecor:Z

    move/from16 v25, v0

    if-eqz v25, :cond_1

    .line 1102
    iget v0, v14, Landroid/support/v4/view/DraftViewPager$LayoutParams;->gravity:I

    move/from16 v25, v0

    and-int/lit8 v10, v25, 0x7

    .line 1103
    .local v10, "hgrav":I
    iget v0, v14, Landroid/support/v4/view/DraftViewPager$LayoutParams;->gravity:I

    move/from16 v25, v0

    and-int/lit8 v23, v25, 0x70

    .line 1104
    .local v23, "vgrav":I
    packed-switch v10, :pswitch_data_0

    .line 1106
    :pswitch_0
    move/from16 v4, v18

    .line 1121
    :goto_1
    sparse-switch v23, :sswitch_data_0

    .line 1123
    move/from16 v5, v20

    .line 1138
    :goto_2
    add-int v4, v4, v22

    .line 1139
    add-int/lit8 v7, v7, 0x1

    .line 1140
    invoke-virtual {v3}, Landroid/view/View;->getMeasuredWidth()I

    move-result v25

    add-int v25, v25, v4

    invoke-virtual {v3}, Landroid/view/View;->getMeasuredHeight()I

    move-result v26

    add-int v26, v26, v5

    move/from16 v0, v25

    move/from16 v1, v26

    invoke-virtual {v3, v4, v5, v0, v1}, Landroid/view/View;->layout(IIII)V

    .line 1094
    .end local v4    # "childLeft":I
    .end local v5    # "childTop":I
    .end local v10    # "hgrav":I
    .end local v14    # "lp":Landroid/support/v4/view/DraftViewPager$LayoutParams;
    .end local v23    # "vgrav":I
    :cond_0
    :goto_3
    add-int/lit8 v11, v11, 0x1

    goto :goto_0

    .line 1109
    .restart local v4    # "childLeft":I
    .restart local v5    # "childTop":I
    .restart local v10    # "hgrav":I
    .restart local v14    # "lp":Landroid/support/v4/view/DraftViewPager$LayoutParams;
    .restart local v23    # "vgrav":I
    :pswitch_1
    move/from16 v4, v18

    .line 1110
    invoke-virtual {v3}, Landroid/view/View;->getMeasuredWidth()I

    move-result v25

    add-int v18, v18, v25

    .line 1111
    goto :goto_1

    .line 1113
    :pswitch_2
    invoke-virtual {v3}, Landroid/view/View;->getMeasuredWidth()I

    move-result v25

    sub-int v25, v24, v25

    div-int/lit8 v25, v25, 0x2

    move/from16 v0, v25

    move/from16 v1, v18

    invoke-static {v0, v1}, Ljava/lang/Math;->max(II)I

    move-result v4

    .line 1115
    goto :goto_1

    .line 1117
    :pswitch_3
    sub-int v25, v24, v19

    invoke-virtual {v3}, Landroid/view/View;->getMeasuredWidth()I

    move-result v26

    sub-int v4, v25, v26

    .line 1118
    invoke-virtual {v3}, Landroid/view/View;->getMeasuredWidth()I

    move-result v25

    add-int v19, v19, v25

    goto :goto_1

    .line 1126
    :sswitch_0
    move/from16 v5, v20

    .line 1127
    invoke-virtual {v3}, Landroid/view/View;->getMeasuredHeight()I

    move-result v25

    add-int v20, v20, v25

    .line 1128
    goto :goto_2

    .line 1130
    :sswitch_1
    invoke-virtual {v3}, Landroid/view/View;->getMeasuredHeight()I

    move-result v25

    sub-int v25, v9, v25

    div-int/lit8 v25, v25, 0x2

    move/from16 v0, v25

    move/from16 v1, v20

    invoke-static {v0, v1}, Ljava/lang/Math;->max(II)I

    move-result v5

    .line 1132
    goto :goto_2

    .line 1134
    :sswitch_2
    sub-int v25, v9, v17

    invoke-virtual {v3}, Landroid/view/View;->getMeasuredHeight()I

    move-result v26

    sub-int v5, v25, v26

    .line 1135
    invoke-virtual {v3}, Landroid/view/View;->getMeasuredHeight()I

    move-result v25

    add-int v17, v17, v25

    goto :goto_2

    .line 1143
    .end local v10    # "hgrav":I
    .end local v23    # "vgrav":I
    :cond_1
    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Landroid/support/v4/view/DraftViewPager;->infoForChild(Landroid/view/View;)Landroid/support/v4/view/DraftViewPager$ItemInfo;

    move-result-object v12

    .local v12, "ii":Landroid/support/v4/view/DraftViewPager$ItemInfo;
    if-eqz v12, :cond_0

    .line 1144
    move-object/from16 v0, p0

    iget v0, v0, Landroid/support/v4/view/DraftViewPager;->mPageMargin:I

    move/from16 v25, v0

    add-int v25, v25, v24

    iget v0, v12, Landroid/support/v4/view/DraftViewPager$ItemInfo;->position:I

    move/from16 v26, v0

    mul-int v13, v25, v26

    .line 1145
    .local v13, "loff":I
    add-int v4, v18, v13

    .line 1146
    move/from16 v5, v20

    .line 1148
    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/view/DraftViewPager;->getWidth()I

    move-result v25

    move/from16 v0, v25

    int-to-float v0, v0

    move/from16 v25, v0

    const/high16 v26, 0x3f800000    # 1.0f

    move-object/from16 v0, p0

    iget v0, v0, Landroid/support/v4/view/DraftViewPager;->mPreviewRatio:F

    move/from16 v27, v0

    sub-float v26, v26, v27

    mul-float v25, v25, v26

    move/from16 v0, v25

    float-to-int v0, v0

    move/from16 v21, v0

    .line 1151
    .local v21, "rawOffset":I
    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/view/DraftViewPager;->getWidth()I

    move-result v25

    move/from16 v0, v25

    int-to-float v0, v0

    move/from16 v25, v0

    const/high16 v26, 0x3f800000    # 1.0f

    move-object/from16 v0, p0

    iget v0, v0, Landroid/support/v4/view/DraftViewPager;->mPreviewRatio:F

    move/from16 v27, v0

    sub-float v26, v26, v27

    const/high16 v27, 0x40000000    # 2.0f

    div-float v26, v26, v27

    mul-float v25, v25, v26

    move/from16 v0, v25

    float-to-int v8, v0

    .line 1152
    .local v8, "firstChildOffset":I
    iget v0, v12, Landroid/support/v4/view/DraftViewPager$ItemInfo;->position:I

    move/from16 v25, v0

    if-lez v25, :cond_2

    .line 1153
    iget v0, v12, Landroid/support/v4/view/DraftViewPager$ItemInfo;->position:I

    move/from16 v25, v0

    mul-int v16, v21, v25

    .line 1154
    .local v16, "offset":I
    move-object/from16 v0, p0

    iget v0, v0, Landroid/support/v4/view/DraftViewPager;->mDraftMargin:I

    move/from16 v25, v0

    mul-int/lit8 v25, v25, 0x2

    iget v0, v12, Landroid/support/v4/view/DraftViewPager$ItemInfo;->position:I

    move/from16 v26, v0

    mul-int v15, v25, v26

    .line 1156
    .local v15, "margin":I
    sub-int v25, v4, v16

    add-int v25, v25, v8

    add-int v25, v25, v15

    invoke-virtual {v3}, Landroid/view/View;->getMeasuredWidth()I

    move-result v26

    add-int v26, v26, v4

    sub-int v26, v26, v16

    add-int v26, v26, v8

    add-int v26, v26, v15

    invoke-virtual {v3}, Landroid/view/View;->getMeasuredHeight()I

    move-result v27

    add-int v27, v27, v5

    move/from16 v0, v25

    move/from16 v1, v26

    move/from16 v2, v27

    invoke-virtual {v3, v0, v5, v1, v2}, Landroid/view/View;->layout(IIII)V

    goto/16 :goto_3

    .line 1160
    .end local v15    # "margin":I
    .end local v16    # "offset":I
    :cond_2
    add-int v25, v4, v8

    invoke-virtual {v3}, Landroid/view/View;->getMeasuredWidth()I

    move-result v26

    add-int v26, v26, v4

    add-int v26, v26, v8

    invoke-virtual {v3}, Landroid/view/View;->getMeasuredHeight()I

    move-result v27

    add-int v27, v27, v5

    move/from16 v0, v25

    move/from16 v1, v26

    move/from16 v2, v27

    invoke-virtual {v3, v0, v5, v1, v2}, Landroid/view/View;->layout(IIII)V

    goto/16 :goto_3

    .line 1169
    .end local v3    # "child":Landroid/view/View;
    .end local v4    # "childLeft":I
    .end local v5    # "childTop":I
    .end local v8    # "firstChildOffset":I
    .end local v12    # "ii":Landroid/support/v4/view/DraftViewPager$ItemInfo;
    .end local v13    # "loff":I
    .end local v14    # "lp":Landroid/support/v4/view/DraftViewPager$LayoutParams;
    .end local v21    # "rawOffset":I
    :cond_3
    move/from16 v0, v20

    move-object/from16 v1, p0

    iput v0, v1, Landroid/support/v4/view/DraftViewPager;->mTopPageBounds:I

    .line 1170
    sub-int v25, v9, v17

    move/from16 v0, v25

    move-object/from16 v1, p0

    iput v0, v1, Landroid/support/v4/view/DraftViewPager;->mBottomPageBounds:I

    .line 1171
    move-object/from16 v0, p0

    iput v7, v0, Landroid/support/v4/view/DraftViewPager;->mDecorChildCount:I

    .line 1172
    const/16 v25, 0x0

    move/from16 v0, v25

    move-object/from16 v1, p0

    iput-boolean v0, v1, Landroid/support/v4/view/DraftViewPager;->mFirstLayout:Z

    .line 1173
    return-void

    .line 1104
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_2
        :pswitch_0
        :pswitch_1
        :pswitch_0
        :pswitch_3
    .end packed-switch

    .line 1121
    :sswitch_data_0
    .sparse-switch
        0x10 -> :sswitch_1
        0x30 -> :sswitch_0
        0x50 -> :sswitch_2
    .end sparse-switch
.end method

.method protected onMeasure(II)V
    .locals 20
    .param p1, "widthMeasureSpec"    # I
    .param p2, "heightMeasureSpec"    # I

    .prologue
    .line 974
    const/16 v17, 0x0

    move/from16 v0, v17

    move/from16 v1, p1

    invoke-static {v0, v1}, Landroid/support/v4/view/DraftViewPager;->getDefaultSize(II)I

    move-result v17

    const/16 v18, 0x0

    move/from16 v0, v18

    move/from16 v1, p2

    invoke-static {v0, v1}, Landroid/support/v4/view/DraftViewPager;->getDefaultSize(II)I

    move-result v18

    move-object/from16 v0, p0

    move/from16 v1, v17

    move/from16 v2, v18

    invoke-virtual {v0, v1, v2}, Landroid/support/v4/view/DraftViewPager;->setMeasuredDimension(II)V

    .line 978
    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/view/DraftViewPager;->getMeasuredWidth()I

    move-result v17

    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/view/DraftViewPager;->getPaddingLeft()I

    move-result v18

    sub-int v17, v17, v18

    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/view/DraftViewPager;->getPaddingRight()I

    move-result v18

    sub-int v5, v17, v18

    .line 979
    .local v5, "childWidthSize":I
    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/view/DraftViewPager;->getMeasuredHeight()I

    move-result v17

    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/view/DraftViewPager;->getPaddingTop()I

    move-result v18

    sub-int v17, v17, v18

    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/view/DraftViewPager;->getPaddingBottom()I

    move-result v18

    sub-int v4, v17, v18

    .line 986
    .local v4, "childHeightSize":I
    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/view/DraftViewPager;->getChildCount()I

    move-result v13

    .line 987
    .local v13, "size":I
    const/4 v11, 0x0

    .local v11, "i":I
    :goto_0
    if-ge v11, v13, :cond_8

    .line 988
    move-object/from16 v0, p0

    invoke-virtual {v0, v11}, Landroid/support/v4/view/DraftViewPager;->getChildAt(I)Landroid/view/View;

    move-result-object v3

    .line 989
    .local v3, "child":Landroid/view/View;
    invoke-virtual {v3}, Landroid/view/View;->getVisibility()I

    move-result v17

    const/16 v18, 0x8

    move/from16 v0, v17

    move/from16 v1, v18

    if-eq v0, v1, :cond_3

    .line 990
    invoke-virtual {v3}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v12

    check-cast v12, Landroid/support/v4/view/DraftViewPager$LayoutParams;

    .line 991
    .local v12, "lp":Landroid/support/v4/view/DraftViewPager$LayoutParams;
    if-eqz v12, :cond_3

    iget-boolean v0, v12, Landroid/support/v4/view/DraftViewPager$LayoutParams;->isDecor:Z

    move/from16 v17, v0

    if-eqz v17, :cond_3

    .line 992
    iget v0, v12, Landroid/support/v4/view/DraftViewPager$LayoutParams;->gravity:I

    move/from16 v17, v0

    and-int/lit8 v10, v17, 0x7

    .line 993
    .local v10, "hgrav":I
    iget v0, v12, Landroid/support/v4/view/DraftViewPager$LayoutParams;->gravity:I

    move/from16 v17, v0

    and-int/lit8 v14, v17, 0x70

    .line 994
    .local v14, "vgrav":I
    const-string v17, "ViewPager"

    new-instance v18, Ljava/lang/StringBuilder;

    invoke-direct/range {v18 .. v18}, Ljava/lang/StringBuilder;-><init>()V

    const-string v19, "gravity: "

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    iget v0, v12, Landroid/support/v4/view/DraftViewPager$LayoutParams;->gravity:I

    move/from16 v19, v0

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string v19, " hgrav: "

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-virtual {v0, v10}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string v19, " vgrav: "

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-virtual {v0, v14}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    invoke-static/range {v17 .. v18}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 995
    const/high16 v15, -0x80000000

    .line 996
    .local v15, "widthMode":I
    const/high16 v8, -0x80000000

    .line 997
    .local v8, "heightMode":I
    const/16 v17, 0x30

    move/from16 v0, v17

    if-eq v14, v0, :cond_0

    const/16 v17, 0x50

    move/from16 v0, v17

    if-ne v14, v0, :cond_4

    :cond_0
    const/4 v7, 0x1

    .line 998
    .local v7, "consumeVertical":Z
    :goto_1
    const/16 v17, 0x3

    move/from16 v0, v17

    if-eq v10, v0, :cond_1

    const/16 v17, 0x5

    move/from16 v0, v17

    if-ne v10, v0, :cond_5

    :cond_1
    const/4 v6, 0x1

    .line 1000
    .local v6, "consumeHorizontal":Z
    :goto_2
    if-eqz v7, :cond_6

    .line 1001
    const/high16 v15, 0x40000000    # 2.0f

    .line 1006
    :cond_2
    :goto_3
    invoke-static {v5, v15}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v16

    .line 1007
    .local v16, "widthSpec":I
    invoke-static {v4, v8}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v9

    .line 1008
    .local v9, "heightSpec":I
    move/from16 v0, v16

    invoke-virtual {v3, v0, v9}, Landroid/view/View;->measure(II)V

    .line 1010
    if-eqz v7, :cond_7

    .line 1011
    invoke-virtual {v3}, Landroid/view/View;->getMeasuredHeight()I

    move-result v17

    sub-int v4, v4, v17

    .line 987
    .end local v6    # "consumeHorizontal":Z
    .end local v7    # "consumeVertical":Z
    .end local v8    # "heightMode":I
    .end local v9    # "heightSpec":I
    .end local v10    # "hgrav":I
    .end local v12    # "lp":Landroid/support/v4/view/DraftViewPager$LayoutParams;
    .end local v14    # "vgrav":I
    .end local v15    # "widthMode":I
    .end local v16    # "widthSpec":I
    :cond_3
    :goto_4
    add-int/lit8 v11, v11, 0x1

    goto/16 :goto_0

    .line 997
    .restart local v8    # "heightMode":I
    .restart local v10    # "hgrav":I
    .restart local v12    # "lp":Landroid/support/v4/view/DraftViewPager$LayoutParams;
    .restart local v14    # "vgrav":I
    .restart local v15    # "widthMode":I
    :cond_4
    const/4 v7, 0x0

    goto :goto_1

    .line 998
    .restart local v7    # "consumeVertical":Z
    :cond_5
    const/4 v6, 0x0

    goto :goto_2

    .line 1002
    .restart local v6    # "consumeHorizontal":Z
    :cond_6
    if-eqz v6, :cond_2

    .line 1003
    const/high16 v8, 0x40000000    # 2.0f

    goto :goto_3

    .line 1012
    .restart local v9    # "heightSpec":I
    .restart local v16    # "widthSpec":I
    :cond_7
    if-eqz v6, :cond_3

    .line 1013
    invoke-virtual {v3}, Landroid/view/View;->getMeasuredWidth()I

    move-result v17

    sub-int v5, v5, v17

    goto :goto_4

    .line 1019
    .end local v3    # "child":Landroid/view/View;
    .end local v6    # "consumeHorizontal":Z
    .end local v7    # "consumeVertical":Z
    .end local v8    # "heightMode":I
    .end local v9    # "heightSpec":I
    .end local v10    # "hgrav":I
    .end local v12    # "lp":Landroid/support/v4/view/DraftViewPager$LayoutParams;
    .end local v14    # "vgrav":I
    .end local v15    # "widthMode":I
    .end local v16    # "widthSpec":I
    :cond_8
    const/high16 v17, 0x40000000    # 2.0f

    move/from16 v0, v17

    invoke-static {v5, v0}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v17

    move/from16 v0, v17

    move-object/from16 v1, p0

    iput v0, v1, Landroid/support/v4/view/DraftViewPager;->mChildWidthMeasureSpec:I

    .line 1020
    const/high16 v17, 0x40000000    # 2.0f

    move/from16 v0, v17

    invoke-static {v4, v0}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v17

    move/from16 v0, v17

    move-object/from16 v1, p0

    iput v0, v1, Landroid/support/v4/view/DraftViewPager;->mChildHeightMeasureSpec:I

    .line 1023
    const/16 v17, 0x1

    move/from16 v0, v17

    move-object/from16 v1, p0

    iput-boolean v0, v1, Landroid/support/v4/view/DraftViewPager;->mInLayout:Z

    .line 1024
    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/view/DraftViewPager;->populate()V

    .line 1025
    const/16 v17, 0x0

    move/from16 v0, v17

    move-object/from16 v1, p0

    iput-boolean v0, v1, Landroid/support/v4/view/DraftViewPager;->mInLayout:Z

    .line 1028
    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/view/DraftViewPager;->getChildCount()I

    move-result v13

    .line 1029
    const/4 v11, 0x0

    :goto_5
    if-ge v11, v13, :cond_b

    .line 1030
    move-object/from16 v0, p0

    invoke-virtual {v0, v11}, Landroid/support/v4/view/DraftViewPager;->getChildAt(I)Landroid/view/View;

    move-result-object v3

    .line 1031
    .restart local v3    # "child":Landroid/view/View;
    invoke-virtual {v3}, Landroid/view/View;->getVisibility()I

    move-result v17

    const/16 v18, 0x8

    move/from16 v0, v17

    move/from16 v1, v18

    if-eq v0, v1, :cond_a

    .line 1035
    invoke-virtual {v3}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v12

    check-cast v12, Landroid/support/v4/view/DraftViewPager$LayoutParams;

    .line 1036
    .restart local v12    # "lp":Landroid/support/v4/view/DraftViewPager$LayoutParams;
    if-eqz v12, :cond_9

    iget-boolean v0, v12, Landroid/support/v4/view/DraftViewPager$LayoutParams;->isDecor:Z

    move/from16 v17, v0

    if-nez v17, :cond_a

    .line 1037
    :cond_9
    move-object/from16 v0, p0

    iget v0, v0, Landroid/support/v4/view/DraftViewPager;->mChildWidthMeasureSpec:I

    move/from16 v17, v0

    move-object/from16 v0, p0

    iget v0, v0, Landroid/support/v4/view/DraftViewPager;->mChildHeightMeasureSpec:I

    move/from16 v18, v0

    move/from16 v0, v17

    move/from16 v1, v18

    invoke-virtual {v3, v0, v1}, Landroid/view/View;->measure(II)V

    .line 1029
    .end local v12    # "lp":Landroid/support/v4/view/DraftViewPager$LayoutParams;
    :cond_a
    add-int/lit8 v11, v11, 0x1

    goto :goto_5

    .line 1041
    .end local v3    # "child":Landroid/view/View;
    :cond_b
    return-void
.end method

.method protected onPageScrolled(IFI)V
    .locals 16
    .param p1, "position"    # I
    .param p2, "offset"    # F
    .param p3, "offsetPixels"    # I

    .prologue
    .line 1229
    move-object/from16 v0, p0

    iget v14, v0, Landroid/support/v4/view/DraftViewPager;->mDecorChildCount:I

    if-lez v14, :cond_2

    .line 1230
    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/view/DraftViewPager;->getScrollX()I

    move-result v12

    .line 1231
    .local v12, "scrollX":I
    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/view/DraftViewPager;->getPaddingLeft()I

    move-result v10

    .line 1232
    .local v10, "paddingLeft":I
    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/view/DraftViewPager;->getPaddingRight()I

    move-result v11

    .line 1233
    .local v11, "paddingRight":I
    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/view/DraftViewPager;->getWidth()I

    move-result v13

    .line 1234
    .local v13, "width":I
    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/view/DraftViewPager;->getChildCount()I

    move-result v4

    .line 1235
    .local v4, "childCount":I
    const/4 v8, 0x0

    .local v8, "i":I
    :goto_0
    if-ge v8, v4, :cond_2

    .line 1236
    move-object/from16 v0, p0

    invoke-virtual {v0, v8}, Landroid/support/v4/view/DraftViewPager;->getChildAt(I)Landroid/view/View;

    move-result-object v3

    .line 1237
    .local v3, "child":Landroid/view/View;
    invoke-virtual {v3}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v9

    check-cast v9, Landroid/support/v4/view/DraftViewPager$LayoutParams;

    .line 1238
    .local v9, "lp":Landroid/support/v4/view/DraftViewPager$LayoutParams;
    iget-boolean v14, v9, Landroid/support/v4/view/DraftViewPager$LayoutParams;->isDecor:Z

    if-nez v14, :cond_1

    .line 1235
    :cond_0
    :goto_1
    add-int/lit8 v8, v8, 0x1

    goto :goto_0

    .line 1240
    :cond_1
    iget v14, v9, Landroid/support/v4/view/DraftViewPager$LayoutParams;->gravity:I

    and-int/lit8 v7, v14, 0x7

    .line 1241
    .local v7, "hgrav":I
    const/4 v5, 0x0

    .line 1242
    .local v5, "childLeft":I
    packed-switch v7, :pswitch_data_0

    .line 1244
    :pswitch_0
    move v5, v10

    .line 1259
    :goto_2
    add-int/2addr v5, v12

    .line 1261
    invoke-virtual {v3}, Landroid/view/View;->getLeft()I

    move-result v14

    sub-int v6, v5, v14

    .line 1262
    .local v6, "childOffset":I
    if-eqz v6, :cond_0

    .line 1263
    invoke-virtual {v3, v6}, Landroid/view/View;->offsetLeftAndRight(I)V

    goto :goto_1

    .line 1247
    .end local v6    # "childOffset":I
    :pswitch_1
    move v5, v10

    .line 1248
    invoke-virtual {v3}, Landroid/view/View;->getWidth()I

    move-result v14

    add-int/2addr v10, v14

    .line 1249
    goto :goto_2

    .line 1251
    :pswitch_2
    invoke-virtual {v3}, Landroid/view/View;->getMeasuredWidth()I

    move-result v14

    sub-int v14, v13, v14

    div-int/lit8 v14, v14, 0x2

    invoke-static {v14, v10}, Ljava/lang/Math;->max(II)I

    move-result v5

    .line 1253
    goto :goto_2

    .line 1255
    :pswitch_3
    sub-int v14, v13, v11

    invoke-virtual {v3}, Landroid/view/View;->getMeasuredWidth()I

    move-result v15

    sub-int v5, v14, v15

    .line 1256
    invoke-virtual {v3}, Landroid/view/View;->getMeasuredWidth()I

    move-result v14

    add-int/2addr v11, v14

    goto :goto_2

    .line 1268
    .end local v3    # "child":Landroid/view/View;
    .end local v4    # "childCount":I
    .end local v5    # "childLeft":I
    .end local v7    # "hgrav":I
    .end local v8    # "i":I
    .end local v9    # "lp":Landroid/support/v4/view/DraftViewPager$LayoutParams;
    .end local v10    # "paddingLeft":I
    .end local v11    # "paddingRight":I
    .end local v12    # "scrollX":I
    .end local v13    # "width":I
    :cond_2
    move-object/from16 v0, p0

    iget-object v14, v0, Landroid/support/v4/view/DraftViewPager;->mOnPageChangeListener:Landroid/support/v4/view/DraftViewPager$OnPageChangeListener;

    if-eqz v14, :cond_3

    .line 1269
    move-object/from16 v0, p0

    iget-object v14, v0, Landroid/support/v4/view/DraftViewPager;->mOnPageChangeListener:Landroid/support/v4/view/DraftViewPager$OnPageChangeListener;

    move/from16 v0, p1

    move/from16 v1, p2

    move/from16 v2, p3

    invoke-interface {v14, v0, v1, v2}, Landroid/support/v4/view/DraftViewPager$OnPageChangeListener;->onPageScrolled(IFI)V

    .line 1271
    :cond_3
    move-object/from16 v0, p0

    iget-object v14, v0, Landroid/support/v4/view/DraftViewPager;->mInternalPageChangeListener:Landroid/support/v4/view/DraftViewPager$OnPageChangeListener;

    if-eqz v14, :cond_4

    .line 1272
    move-object/from16 v0, p0

    iget-object v14, v0, Landroid/support/v4/view/DraftViewPager;->mInternalPageChangeListener:Landroid/support/v4/view/DraftViewPager$OnPageChangeListener;

    move/from16 v0, p1

    move/from16 v1, p2

    move/from16 v2, p3

    invoke-interface {v14, v0, v1, v2}, Landroid/support/v4/view/DraftViewPager$OnPageChangeListener;->onPageScrolled(IFI)V

    .line 1274
    :cond_4
    const/4 v14, 0x1

    move-object/from16 v0, p0

    iput-boolean v14, v0, Landroid/support/v4/view/DraftViewPager;->mCalledSuper:Z

    .line 1275
    return-void

    .line 1242
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_2
        :pswitch_0
        :pswitch_1
        :pswitch_0
        :pswitch_3
    .end packed-switch
.end method

.method protected onRequestFocusInDescendants(ILandroid/graphics/Rect;)Z
    .locals 9
    .param p1, "direction"    # I
    .param p2, "previouslyFocusedRect"    # Landroid/graphics/Rect;

    .prologue
    .line 2015
    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->getChildCount()I

    move-result v1

    .line 2016
    .local v1, "count":I
    and-int/lit8 v7, p1, 0x2

    if-eqz v7, :cond_0

    .line 2017
    const/4 v6, 0x0

    .line 2018
    .local v6, "index":I
    const/4 v5, 0x1

    .line 2019
    .local v5, "increment":I
    move v2, v1

    .line 2025
    .local v2, "end":I
    :goto_0
    move v3, v6

    .local v3, "i":I
    :goto_1
    if-eq v3, v2, :cond_2

    .line 2026
    invoke-virtual {p0, v3}, Landroid/support/v4/view/DraftViewPager;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 2027
    .local v0, "child":Landroid/view/View;
    invoke-virtual {v0}, Landroid/view/View;->getVisibility()I

    move-result v7

    if-nez v7, :cond_1

    .line 2028
    invoke-virtual {p0, v0}, Landroid/support/v4/view/DraftViewPager;->infoForChild(Landroid/view/View;)Landroid/support/v4/view/DraftViewPager$ItemInfo;

    move-result-object v4

    .line 2029
    .local v4, "ii":Landroid/support/v4/view/DraftViewPager$ItemInfo;
    if-eqz v4, :cond_1

    iget v7, v4, Landroid/support/v4/view/DraftViewPager$ItemInfo;->position:I

    iget v8, p0, Landroid/support/v4/view/DraftViewPager;->mCurItem:I

    if-ne v7, v8, :cond_1

    .line 2030
    invoke-virtual {v0, p1, p2}, Landroid/view/View;->requestFocus(ILandroid/graphics/Rect;)Z

    move-result v7

    if-eqz v7, :cond_1

    .line 2031
    const/4 v7, 0x1

    .line 2036
    .end local v0    # "child":Landroid/view/View;
    .end local v4    # "ii":Landroid/support/v4/view/DraftViewPager$ItemInfo;
    :goto_2
    return v7

    .line 2021
    .end local v2    # "end":I
    .end local v3    # "i":I
    .end local v5    # "increment":I
    .end local v6    # "index":I
    :cond_0
    add-int/lit8 v6, v1, -0x1

    .line 2022
    .restart local v6    # "index":I
    const/4 v5, -0x1

    .line 2023
    .restart local v5    # "increment":I
    const/4 v2, -0x1

    .restart local v2    # "end":I
    goto :goto_0

    .line 2025
    .restart local v0    # "child":Landroid/view/View;
    .restart local v3    # "i":I
    :cond_1
    add-int/2addr v3, v5

    goto :goto_1

    .line 2036
    .end local v0    # "child":Landroid/view/View;
    :cond_2
    const/4 v7, 0x0

    goto :goto_2
.end method

.method public onRestoreInstanceState(Landroid/os/Parcelable;)V
    .locals 4
    .param p1, "state"    # Landroid/os/Parcelable;

    .prologue
    .line 896
    instance-of v1, p1, Landroid/support/v4/view/DraftViewPager$SavedState;

    if-nez v1, :cond_0

    .line 897
    invoke-super {p0, p1}, Landroid/view/ViewGroup;->onRestoreInstanceState(Landroid/os/Parcelable;)V

    .line 912
    :goto_0
    return-void

    :cond_0
    move-object v0, p1

    .line 901
    check-cast v0, Landroid/support/v4/view/DraftViewPager$SavedState;

    .line 902
    .local v0, "ss":Landroid/support/v4/view/DraftViewPager$SavedState;
    invoke-virtual {v0}, Landroid/support/v4/view/DraftViewPager$SavedState;->getSuperState()Landroid/os/Parcelable;

    move-result-object v1

    invoke-super {p0, v1}, Landroid/view/ViewGroup;->onRestoreInstanceState(Landroid/os/Parcelable;)V

    .line 904
    iget-object v1, p0, Landroid/support/v4/view/DraftViewPager;->mAdapter:Landroid/support/v4/view/DraftPagerAdapter;

    if-eqz v1, :cond_1

    .line 905
    iget-object v1, p0, Landroid/support/v4/view/DraftViewPager;->mAdapter:Landroid/support/v4/view/DraftPagerAdapter;

    iget-object v2, v0, Landroid/support/v4/view/DraftViewPager$SavedState;->adapterState:Landroid/os/Parcelable;

    iget-object v3, v0, Landroid/support/v4/view/DraftViewPager$SavedState;->loader:Ljava/lang/ClassLoader;

    invoke-virtual {v1, v2, v3}, Landroid/support/v4/view/DraftPagerAdapter;->restoreState(Landroid/os/Parcelable;Ljava/lang/ClassLoader;)V

    .line 906
    iget v1, v0, Landroid/support/v4/view/DraftViewPager$SavedState;->position:I

    const/4 v2, 0x0

    const/4 v3, 0x1

    invoke-virtual {p0, v1, v2, v3}, Landroid/support/v4/view/DraftViewPager;->setCurrentItemInternal(IZZ)V

    goto :goto_0

    .line 908
    :cond_1
    iget v1, v0, Landroid/support/v4/view/DraftViewPager$SavedState;->position:I

    iput v1, p0, Landroid/support/v4/view/DraftViewPager;->mRestoredCurItem:I

    .line 909
    iget-object v1, v0, Landroid/support/v4/view/DraftViewPager$SavedState;->adapterState:Landroid/os/Parcelable;

    iput-object v1, p0, Landroid/support/v4/view/DraftViewPager;->mRestoredAdapterState:Landroid/os/Parcelable;

    .line 910
    iget-object v1, v0, Landroid/support/v4/view/DraftViewPager$SavedState;->loader:Ljava/lang/ClassLoader;

    iput-object v1, p0, Landroid/support/v4/view/DraftViewPager;->mRestoredClassLoader:Ljava/lang/ClassLoader;

    goto :goto_0
.end method

.method public onSaveInstanceState()Landroid/os/Parcelable;
    .locals 3

    .prologue
    .line 885
    invoke-super {p0}, Landroid/view/ViewGroup;->onSaveInstanceState()Landroid/os/Parcelable;

    move-result-object v1

    .line 886
    .local v1, "superState":Landroid/os/Parcelable;
    new-instance v0, Landroid/support/v4/view/DraftViewPager$SavedState;

    invoke-direct {v0, v1}, Landroid/support/v4/view/DraftViewPager$SavedState;-><init>(Landroid/os/Parcelable;)V

    .line 887
    .local v0, "ss":Landroid/support/v4/view/DraftViewPager$SavedState;
    iget v2, p0, Landroid/support/v4/view/DraftViewPager;->mCurItem:I

    iput v2, v0, Landroid/support/v4/view/DraftViewPager$SavedState;->position:I

    .line 888
    iget-object v2, p0, Landroid/support/v4/view/DraftViewPager;->mAdapter:Landroid/support/v4/view/DraftPagerAdapter;

    if-eqz v2, :cond_0

    .line 889
    iget-object v2, p0, Landroid/support/v4/view/DraftViewPager;->mAdapter:Landroid/support/v4/view/DraftPagerAdapter;

    invoke-virtual {v2}, Landroid/support/v4/view/DraftPagerAdapter;->saveState()Landroid/os/Parcelable;

    move-result-object v2

    iput-object v2, v0, Landroid/support/v4/view/DraftViewPager$SavedState;->adapterState:Landroid/os/Parcelable;

    .line 891
    :cond_0
    return-object v0
.end method

.method protected onSizeChanged(IIII)V
    .locals 2
    .param p1, "w"    # I
    .param p2, "h"    # I
    .param p3, "oldw"    # I
    .param p4, "oldh"    # I

    .prologue
    .line 1045
    invoke-super {p0, p1, p2, p3, p4}, Landroid/view/ViewGroup;->onSizeChanged(IIII)V

    .line 1048
    if-eq p1, p3, :cond_0

    .line 1049
    iget v0, p0, Landroid/support/v4/view/DraftViewPager;->mPageMargin:I

    iget v1, p0, Landroid/support/v4/view/DraftViewPager;->mPageMargin:I

    invoke-direct {p0, p1, p3, v0, v1}, Landroid/support/v4/view/DraftViewPager;->recomputeScrollPosition(IIII)V

    .line 1051
    :cond_0
    return-void
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 31
    .param p1, "ev"    # Landroid/view/MotionEvent;
        .annotation build Lorg/jetbrains/annotations/NotNull;
        .end annotation
    .end param

    .prologue
    .line 1442
    move-object/from16 v0, p0

    iget-boolean v0, v0, Landroid/support/v4/view/DraftViewPager;->mFakeDragging:Z

    move/from16 v28, v0

    if-eqz v28, :cond_0

    .line 1446
    const/16 v28, 0x1

    .line 1584
    :goto_0
    return v28

    .line 1449
    :cond_0
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v28

    if-nez v28, :cond_1

    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getEdgeFlags()I

    move-result v28

    if-eqz v28, :cond_1

    .line 1452
    const/16 v28, 0x0

    goto :goto_0

    .line 1455
    :cond_1
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/support/v4/view/DraftViewPager;->mAdapter:Landroid/support/v4/view/DraftPagerAdapter;

    move-object/from16 v28, v0

    if-eqz v28, :cond_2

    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/support/v4/view/DraftViewPager;->mAdapter:Landroid/support/v4/view/DraftPagerAdapter;

    move-object/from16 v28, v0

    invoke-virtual/range {v28 .. v28}, Landroid/support/v4/view/DraftPagerAdapter;->getCount()I

    move-result v28

    if-nez v28, :cond_3

    .line 1457
    :cond_2
    const/16 v28, 0x0

    goto :goto_0

    .line 1460
    :cond_3
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/support/v4/view/DraftViewPager;->mVelocityTracker:Landroid/view/VelocityTracker;

    move-object/from16 v28, v0

    if-nez v28, :cond_4

    .line 1461
    invoke-static {}, Landroid/view/VelocityTracker;->obtain()Landroid/view/VelocityTracker;

    move-result-object v28

    move-object/from16 v0, v28

    move-object/from16 v1, p0

    iput-object v0, v1, Landroid/support/v4/view/DraftViewPager;->mVelocityTracker:Landroid/view/VelocityTracker;

    .line 1463
    :cond_4
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/support/v4/view/DraftViewPager;->mVelocityTracker:Landroid/view/VelocityTracker;

    move-object/from16 v28, v0

    move-object/from16 v0, v28

    move-object/from16 v1, p1

    invoke-virtual {v0, v1}, Landroid/view/VelocityTracker;->addMovement(Landroid/view/MotionEvent;)V

    .line 1465
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v4

    .line 1466
    .local v4, "action":I
    const/4 v12, 0x0

    .line 1468
    .local v12, "needsInvalidate":Z
    and-int/lit16 v0, v4, 0xff

    move/from16 v28, v0

    packed-switch v28, :pswitch_data_0

    .line 1581
    :cond_5
    :goto_1
    :pswitch_0
    if-eqz v12, :cond_6

    .line 1582
    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/view/DraftViewPager;->invalidate()V

    .line 1584
    :cond_6
    const/16 v28, 0x1

    goto :goto_0

    .line 1474
    :pswitch_1
    invoke-direct/range {p0 .. p0}, Landroid/support/v4/view/DraftViewPager;->completeScroll()V

    .line 1477
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getX()F

    move-result v28

    move/from16 v0, v28

    move-object/from16 v1, p0

    iput v0, v1, Landroid/support/v4/view/DraftViewPager;->mInitialMotionX:F

    move/from16 v0, v28

    move-object/from16 v1, p0

    iput v0, v1, Landroid/support/v4/view/DraftViewPager;->mLastMotionX:F

    .line 1478
    const/16 v28, 0x0

    move-object/from16 v0, p1

    move/from16 v1, v28

    invoke-static {v0, v1}, Landroid/support/v4/view/MotionEventCompat;->getPointerId(Landroid/view/MotionEvent;I)I

    move-result v28

    move/from16 v0, v28

    move-object/from16 v1, p0

    iput v0, v1, Landroid/support/v4/view/DraftViewPager;->mActivePointerId:I

    goto :goto_1

    .line 1482
    :pswitch_2
    move-object/from16 v0, p0

    iget-boolean v0, v0, Landroid/support/v4/view/DraftViewPager;->mIsBeingDragged:Z

    move/from16 v28, v0

    if-nez v28, :cond_7

    .line 1483
    move-object/from16 v0, p0

    iget v0, v0, Landroid/support/v4/view/DraftViewPager;->mActivePointerId:I

    move/from16 v28, v0

    move-object/from16 v0, p1

    move/from16 v1, v28

    invoke-static {v0, v1}, Landroid/support/v4/view/MotionEventCompat;->findPointerIndex(Landroid/view/MotionEvent;I)I

    move-result v17

    .line 1484
    .local v17, "pointerIndex":I
    move-object/from16 v0, p1

    move/from16 v1, v17

    invoke-static {v0, v1}, Landroid/support/v4/view/MotionEventCompat;->getX(Landroid/view/MotionEvent;I)F

    move-result v24

    .line 1485
    .local v24, "x":F
    move-object/from16 v0, p0

    iget v0, v0, Landroid/support/v4/view/DraftViewPager;->mLastMotionX:F

    move/from16 v28, v0

    sub-float v28, v24, v28

    invoke-static/range {v28 .. v28}, Ljava/lang/Math;->abs(F)F

    move-result v25

    .line 1486
    .local v25, "xDiff":F
    move-object/from16 v0, p1

    move/from16 v1, v17

    invoke-static {v0, v1}, Landroid/support/v4/view/MotionEventCompat;->getY(Landroid/view/MotionEvent;I)F

    move-result v26

    .line 1487
    .local v26, "y":F
    move-object/from16 v0, p0

    iget v0, v0, Landroid/support/v4/view/DraftViewPager;->mLastMotionY:F

    move/from16 v28, v0

    sub-float v28, v26, v28

    invoke-static/range {v28 .. v28}, Ljava/lang/Math;->abs(F)F

    move-result v27

    .line 1491
    .local v27, "yDiff":F
    move-object/from16 v0, p0

    iget v0, v0, Landroid/support/v4/view/DraftViewPager;->mTouchSlop:I

    move/from16 v28, v0

    move/from16 v0, v28

    int-to-float v0, v0

    move/from16 v28, v0

    cmpl-float v28, v25, v28

    if-lez v28, :cond_7

    cmpl-float v28, v25, v27

    if-lez v28, :cond_7

    .line 1495
    const/16 v28, 0x1

    move/from16 v0, v28

    move-object/from16 v1, p0

    iput-boolean v0, v1, Landroid/support/v4/view/DraftViewPager;->mIsBeingDragged:Z

    .line 1496
    move/from16 v0, v24

    move-object/from16 v1, p0

    iput v0, v1, Landroid/support/v4/view/DraftViewPager;->mLastMotionX:F

    .line 1497
    const/16 v28, 0x1

    move-object/from16 v0, p0

    move/from16 v1, v28

    invoke-direct {v0, v1}, Landroid/support/v4/view/DraftViewPager;->setScrollState(I)V

    .line 1498
    const/16 v28, 0x1

    move-object/from16 v0, p0

    move/from16 v1, v28

    invoke-direct {v0, v1}, Landroid/support/v4/view/DraftViewPager;->setScrollingCacheEnabled(Z)V

    .line 1501
    .end local v17    # "pointerIndex":I
    .end local v24    # "x":F
    .end local v25    # "xDiff":F
    .end local v26    # "y":F
    .end local v27    # "yDiff":F
    :cond_7
    move-object/from16 v0, p0

    iget-boolean v0, v0, Landroid/support/v4/view/DraftViewPager;->mIsBeingDragged:Z

    move/from16 v28, v0

    if-eqz v28, :cond_5

    .line 1503
    move-object/from16 v0, p0

    iget v0, v0, Landroid/support/v4/view/DraftViewPager;->mActivePointerId:I

    move/from16 v28, v0

    move-object/from16 v0, p1

    move/from16 v1, v28

    invoke-static {v0, v1}, Landroid/support/v4/view/MotionEventCompat;->findPointerIndex(Landroid/view/MotionEvent;I)I

    move-result v5

    .line 1505
    .local v5, "activePointerIndex":I
    move-object/from16 v0, p1

    invoke-static {v0, v5}, Landroid/support/v4/view/MotionEventCompat;->getX(Landroid/view/MotionEvent;I)F

    move-result v24

    .line 1506
    .restart local v24    # "x":F
    move-object/from16 v0, p0

    iget v0, v0, Landroid/support/v4/view/DraftViewPager;->mLastMotionX:F

    move/from16 v28, v0

    sub-float v7, v28, v24

    .line 1507
    .local v7, "deltaX":F
    move/from16 v0, v24

    move-object/from16 v1, p0

    iput v0, v1, Landroid/support/v4/view/DraftViewPager;->mLastMotionX:F

    .line 1508
    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/view/DraftViewPager;->getScrollX()I

    move-result v28

    move/from16 v0, v28

    int-to-float v14, v0

    .line 1509
    .local v14, "oldScrollX":F
    add-float v19, v14, v7

    .line 1510
    .local v19, "scrollX":F
    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/view/DraftViewPager;->getWidth()I

    move-result v28

    move/from16 v0, v28

    int-to-float v0, v0

    move/from16 v28, v0

    move-object/from16 v0, p0

    iget v0, v0, Landroid/support/v4/view/DraftViewPager;->mPreviewRatio:F

    move/from16 v29, v0

    mul-float v28, v28, v29

    move/from16 v0, v28

    float-to-int v0, v0

    move/from16 v22, v0

    .line 1511
    .local v22, "width":I
    move-object/from16 v0, p0

    iget v0, v0, Landroid/support/v4/view/DraftViewPager;->mPageMargin:I

    move/from16 v28, v0

    add-int v23, v22, v28

    .line 1513
    .local v23, "widthWithMargin":I
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/support/v4/view/DraftViewPager;->mAdapter:Landroid/support/v4/view/DraftPagerAdapter;

    move-object/from16 v28, v0

    invoke-virtual/range {v28 .. v28}, Landroid/support/v4/view/DraftPagerAdapter;->getCount()I

    move-result v28

    add-int/lit8 v10, v28, -0x1

    .line 1514
    .local v10, "lastItemIndex":I
    const/16 v28, 0x0

    move-object/from16 v0, p0

    iget v0, v0, Landroid/support/v4/view/DraftViewPager;->mCurItem:I

    move/from16 v29, v0

    add-int/lit8 v29, v29, -0x1

    mul-int v29, v29, v23

    invoke-static/range {v28 .. v29}, Ljava/lang/Math;->max(II)I

    move-result v28

    move/from16 v0, v28

    int-to-float v11, v0

    .line 1515
    .local v11, "leftBound":F
    move-object/from16 v0, p0

    iget v0, v0, Landroid/support/v4/view/DraftViewPager;->mCurItem:I

    move/from16 v28, v0

    add-int/lit8 v28, v28, 0x1

    move/from16 v0, v28

    invoke-static {v0, v10}, Ljava/lang/Math;->min(II)I

    move-result v28

    mul-int v28, v28, v23

    move/from16 v0, v28

    int-to-float v0, v0

    move/from16 v18, v0

    .line 1517
    .local v18, "rightBound":F
    cmpg-float v28, v19, v11

    if-gez v28, :cond_a

    .line 1518
    const/16 v28, 0x0

    cmpl-float v28, v11, v28

    if-nez v28, :cond_8

    .line 1519
    move/from16 v0, v19

    neg-float v15, v0

    .line 1520
    .local v15, "over":F
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/support/v4/view/DraftViewPager;->mLeftEdge:Landroid/support/v4/widget/EdgeEffectCompat;

    move-object/from16 v28, v0

    move/from16 v0, v22

    int-to-float v0, v0

    move/from16 v29, v0

    div-float v29, v15, v29

    invoke-virtual/range {v28 .. v29}, Landroid/support/v4/widget/EdgeEffectCompat;->onPull(F)Z

    move-result v12

    .line 1522
    .end local v15    # "over":F
    :cond_8
    move/from16 v19, v11

    .line 1531
    :cond_9
    :goto_2
    move-object/from16 v0, p0

    iget v0, v0, Landroid/support/v4/view/DraftViewPager;->mLastMotionX:F

    move/from16 v28, v0

    move/from16 v0, v19

    float-to-int v0, v0

    move/from16 v29, v0

    move/from16 v0, v29

    int-to-float v0, v0

    move/from16 v29, v0

    sub-float v29, v19, v29

    add-float v28, v28, v29

    move/from16 v0, v28

    move-object/from16 v1, p0

    iput v0, v1, Landroid/support/v4/view/DraftViewPager;->mLastMotionX:F

    .line 1532
    move/from16 v0, v19

    float-to-int v0, v0

    move/from16 v28, v0

    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/view/DraftViewPager;->getScrollY()I

    move-result v29

    move-object/from16 v0, p0

    move/from16 v1, v28

    move/from16 v2, v29

    invoke-virtual {v0, v1, v2}, Landroid/support/v4/view/DraftViewPager;->scrollTo(II)V

    .line 1533
    move/from16 v0, v19

    float-to-int v0, v0

    move/from16 v28, v0

    move-object/from16 v0, p0

    move/from16 v1, v28

    invoke-direct {v0, v1}, Landroid/support/v4/view/DraftViewPager;->pageScrolled(I)V

    goto/16 :goto_1

    .line 1523
    :cond_a
    cmpl-float v28, v19, v18

    if-lez v28, :cond_9

    .line 1524
    mul-int v28, v10, v23

    move/from16 v0, v28

    int-to-float v0, v0

    move/from16 v28, v0

    cmpl-float v28, v18, v28

    if-nez v28, :cond_b

    .line 1525
    sub-float v15, v19, v18

    .line 1526
    .restart local v15    # "over":F
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/support/v4/view/DraftViewPager;->mRightEdge:Landroid/support/v4/widget/EdgeEffectCompat;

    move-object/from16 v28, v0

    move/from16 v0, v22

    int-to-float v0, v0

    move/from16 v29, v0

    div-float v29, v15, v29

    invoke-virtual/range {v28 .. v29}, Landroid/support/v4/widget/EdgeEffectCompat;->onPull(F)Z

    move-result v12

    .line 1528
    .end local v15    # "over":F
    :cond_b
    move/from16 v19, v18

    goto :goto_2

    .line 1537
    .end local v5    # "activePointerIndex":I
    .end local v7    # "deltaX":F
    .end local v10    # "lastItemIndex":I
    .end local v11    # "leftBound":F
    .end local v14    # "oldScrollX":F
    .end local v18    # "rightBound":F
    .end local v19    # "scrollX":F
    .end local v22    # "width":I
    .end local v23    # "widthWithMargin":I
    .end local v24    # "x":F
    :pswitch_3
    move-object/from16 v0, p0

    iget-boolean v0, v0, Landroid/support/v4/view/DraftViewPager;->mIsBeingDragged:Z

    move/from16 v28, v0

    if-eqz v28, :cond_5

    .line 1538
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/support/v4/view/DraftViewPager;->mVelocityTracker:Landroid/view/VelocityTracker;

    move-object/from16 v21, v0

    .line 1539
    .local v21, "velocityTracker":Landroid/view/VelocityTracker;
    const/16 v28, 0x3e8

    move-object/from16 v0, p0

    iget v0, v0, Landroid/support/v4/view/DraftViewPager;->mMaximumVelocity:I

    move/from16 v29, v0

    move/from16 v0, v29

    int-to-float v0, v0

    move/from16 v29, v0

    move-object/from16 v0, v21

    move/from16 v1, v28

    move/from16 v2, v29

    invoke-virtual {v0, v1, v2}, Landroid/view/VelocityTracker;->computeCurrentVelocity(IF)V

    .line 1540
    move-object/from16 v0, p0

    iget v0, v0, Landroid/support/v4/view/DraftViewPager;->mActivePointerId:I

    move/from16 v28, v0

    move-object/from16 v0, v21

    move/from16 v1, v28

    invoke-static {v0, v1}, Landroid/support/v4/view/VelocityTrackerCompat;->getXVelocity(Landroid/view/VelocityTracker;I)F

    move-result v28

    move/from16 v0, v28

    float-to-int v9, v0

    .line 1542
    .local v9, "initialVelocity":I
    const/16 v28, 0x1

    move/from16 v0, v28

    move-object/from16 v1, p0

    iput-boolean v0, v1, Landroid/support/v4/view/DraftViewPager;->mPopulatePending:Z

    .line 1543
    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/view/DraftViewPager;->getWidth()I

    move-result v28

    move-object/from16 v0, p0

    iget v0, v0, Landroid/support/v4/view/DraftViewPager;->mPageMargin:I

    move/from16 v29, v0

    add-int v23, v28, v29

    .line 1544
    .restart local v23    # "widthWithMargin":I
    invoke-virtual/range {p0 .. p0}, Landroid/support/v4/view/DraftViewPager;->getScrollX()I

    move-result v19

    .line 1545
    .local v19, "scrollX":I
    move/from16 v0, v23

    int-to-float v0, v0

    move/from16 v28, v0

    move-object/from16 v0, p0

    iget v0, v0, Landroid/support/v4/view/DraftViewPager;->mPreviewRatio:F

    move/from16 v29, v0

    mul-float v28, v28, v29

    move/from16 v0, v28

    float-to-int v0, v0

    move/from16 v28, v0

    div-int v6, v19, v28

    .line 1546
    .local v6, "currentPage":I
    rem-int v28, v19, v23

    move/from16 v0, v28

    int-to-float v0, v0

    move/from16 v28, v0

    move/from16 v0, v23

    int-to-float v0, v0

    move/from16 v29, v0

    div-float v16, v28, v29

    .line 1547
    .local v16, "pageOffset":F
    move-object/from16 v0, p0

    iget v0, v0, Landroid/support/v4/view/DraftViewPager;->mActivePointerId:I

    move/from16 v28, v0

    move-object/from16 v0, p1

    move/from16 v1, v28

    invoke-static {v0, v1}, Landroid/support/v4/view/MotionEventCompat;->findPointerIndex(Landroid/view/MotionEvent;I)I

    move-result v5

    .line 1549
    .restart local v5    # "activePointerIndex":I
    move-object/from16 v0, p1

    invoke-static {v0, v5}, Landroid/support/v4/view/MotionEventCompat;->getX(Landroid/view/MotionEvent;I)F

    move-result v24

    .line 1550
    .restart local v24    # "x":F
    move-object/from16 v0, p0

    iget v0, v0, Landroid/support/v4/view/DraftViewPager;->mInitialMotionX:F

    move/from16 v28, v0

    sub-float v28, v24, v28

    move/from16 v0, v28

    float-to-int v0, v0

    move/from16 v20, v0

    .line 1551
    .local v20, "totalDelta":I
    move-object/from16 v0, p0

    move/from16 v1, v16

    move/from16 v2, v20

    invoke-direct {v0, v6, v1, v9, v2}, Landroid/support/v4/view/DraftViewPager;->determineTargetPage(IFII)I

    move-result v13

    .line 1553
    .local v13, "nextPage":I
    const/16 v28, 0x1

    const/16 v29, 0x1

    move-object/from16 v0, p0

    move/from16 v1, v28

    move/from16 v2, v29

    invoke-virtual {v0, v13, v1, v2, v9}, Landroid/support/v4/view/DraftViewPager;->setCurrentItemInternal(IZZI)V

    .line 1555
    const/16 v28, -0x1

    move/from16 v0, v28

    move-object/from16 v1, p0

    iput v0, v1, Landroid/support/v4/view/DraftViewPager;->mActivePointerId:I

    .line 1556
    invoke-direct/range {p0 .. p0}, Landroid/support/v4/view/DraftViewPager;->endDrag()V

    .line 1557
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/support/v4/view/DraftViewPager;->mLeftEdge:Landroid/support/v4/widget/EdgeEffectCompat;

    move-object/from16 v28, v0

    invoke-virtual/range {v28 .. v28}, Landroid/support/v4/widget/EdgeEffectCompat;->onRelease()Z

    move-result v28

    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/support/v4/view/DraftViewPager;->mRightEdge:Landroid/support/v4/widget/EdgeEffectCompat;

    move-object/from16 v29, v0

    invoke-virtual/range {v29 .. v29}, Landroid/support/v4/widget/EdgeEffectCompat;->onRelease()Z

    move-result v29

    or-int v12, v28, v29

    .line 1558
    goto/16 :goto_1

    .line 1561
    .end local v5    # "activePointerIndex":I
    .end local v6    # "currentPage":I
    .end local v9    # "initialVelocity":I
    .end local v13    # "nextPage":I
    .end local v16    # "pageOffset":F
    .end local v19    # "scrollX":I
    .end local v20    # "totalDelta":I
    .end local v21    # "velocityTracker":Landroid/view/VelocityTracker;
    .end local v23    # "widthWithMargin":I
    .end local v24    # "x":F
    :pswitch_4
    move-object/from16 v0, p0

    iget-boolean v0, v0, Landroid/support/v4/view/DraftViewPager;->mIsBeingDragged:Z

    move/from16 v28, v0

    if-eqz v28, :cond_5

    .line 1562
    move-object/from16 v0, p0

    iget v0, v0, Landroid/support/v4/view/DraftViewPager;->mCurItem:I

    move/from16 v28, v0

    const/16 v29, 0x1

    const/16 v30, 0x1

    move-object/from16 v0, p0

    move/from16 v1, v28

    move/from16 v2, v29

    move/from16 v3, v30

    invoke-virtual {v0, v1, v2, v3}, Landroid/support/v4/view/DraftViewPager;->setCurrentItemInternal(IZZ)V

    .line 1563
    const/16 v28, -0x1

    move/from16 v0, v28

    move-object/from16 v1, p0

    iput v0, v1, Landroid/support/v4/view/DraftViewPager;->mActivePointerId:I

    .line 1564
    invoke-direct/range {p0 .. p0}, Landroid/support/v4/view/DraftViewPager;->endDrag()V

    .line 1565
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/support/v4/view/DraftViewPager;->mLeftEdge:Landroid/support/v4/widget/EdgeEffectCompat;

    move-object/from16 v28, v0

    invoke-virtual/range {v28 .. v28}, Landroid/support/v4/widget/EdgeEffectCompat;->onRelease()Z

    move-result v28

    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/support/v4/view/DraftViewPager;->mRightEdge:Landroid/support/v4/widget/EdgeEffectCompat;

    move-object/from16 v29, v0

    invoke-virtual/range {v29 .. v29}, Landroid/support/v4/widget/EdgeEffectCompat;->onRelease()Z

    move-result v29

    or-int v12, v28, v29

    goto/16 :goto_1

    .line 1569
    :pswitch_5
    invoke-static/range {p1 .. p1}, Landroid/support/v4/view/MotionEventCompat;->getActionIndex(Landroid/view/MotionEvent;)I

    move-result v8

    .line 1570
    .local v8, "index":I
    move-object/from16 v0, p1

    invoke-static {v0, v8}, Landroid/support/v4/view/MotionEventCompat;->getX(Landroid/view/MotionEvent;I)F

    move-result v24

    .line 1571
    .restart local v24    # "x":F
    move/from16 v0, v24

    move-object/from16 v1, p0

    iput v0, v1, Landroid/support/v4/view/DraftViewPager;->mLastMotionX:F

    .line 1572
    move-object/from16 v0, p1

    invoke-static {v0, v8}, Landroid/support/v4/view/MotionEventCompat;->getPointerId(Landroid/view/MotionEvent;I)I

    move-result v28

    move/from16 v0, v28

    move-object/from16 v1, p0

    iput v0, v1, Landroid/support/v4/view/DraftViewPager;->mActivePointerId:I

    goto/16 :goto_1

    .line 1576
    .end local v8    # "index":I
    .end local v24    # "x":F
    :pswitch_6
    invoke-direct/range {p0 .. p1}, Landroid/support/v4/view/DraftViewPager;->onSecondaryPointerUp(Landroid/view/MotionEvent;)V

    .line 1577
    move-object/from16 v0, p0

    iget v0, v0, Landroid/support/v4/view/DraftViewPager;->mActivePointerId:I

    move/from16 v28, v0

    move-object/from16 v0, p1

    move/from16 v1, v28

    invoke-static {v0, v1}, Landroid/support/v4/view/MotionEventCompat;->findPointerIndex(Landroid/view/MotionEvent;I)I

    move-result v28

    move-object/from16 v0, p1

    move/from16 v1, v28

    invoke-static {v0, v1}, Landroid/support/v4/view/MotionEventCompat;->getX(Landroid/view/MotionEvent;I)F

    move-result v28

    move/from16 v0, v28

    move-object/from16 v1, p0

    iput v0, v1, Landroid/support/v4/view/DraftViewPager;->mLastMotionX:F

    goto/16 :goto_1

    .line 1468
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_3
        :pswitch_2
        :pswitch_4
        :pswitch_0
        :pswitch_5
        :pswitch_6
    .end packed-switch
.end method

.method pageLeft()Z
    .locals 2

    .prologue
    const/4 v0, 0x1

    .line 1928
    iget v1, p0, Landroid/support/v4/view/DraftViewPager;->mCurItem:I

    if-lez v1, :cond_0

    .line 1929
    iget v1, p0, Landroid/support/v4/view/DraftViewPager;->mCurItem:I

    add-int/lit8 v1, v1, -0x1

    invoke-virtual {p0, v1, v0}, Landroid/support/v4/view/DraftViewPager;->setCurrentItem(IZ)V

    .line 1932
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method pageRight()Z
    .locals 3

    .prologue
    const/4 v0, 0x1

    .line 1936
    iget-object v1, p0, Landroid/support/v4/view/DraftViewPager;->mAdapter:Landroid/support/v4/view/DraftPagerAdapter;

    if-eqz v1, :cond_0

    iget v1, p0, Landroid/support/v4/view/DraftViewPager;->mCurItem:I

    iget-object v2, p0, Landroid/support/v4/view/DraftViewPager;->mAdapter:Landroid/support/v4/view/DraftPagerAdapter;

    invoke-virtual {v2}, Landroid/support/v4/view/DraftPagerAdapter;->getCount()I

    move-result v2

    add-int/lit8 v2, v2, -0x1

    if-ge v1, v2, :cond_0

    .line 1937
    iget v1, p0, Landroid/support/v4/view/DraftViewPager;->mCurItem:I

    add-int/lit8 v1, v1, 0x1

    invoke-virtual {p0, v1, v0}, Landroid/support/v4/view/DraftViewPager;->setCurrentItem(IZ)V

    .line 1940
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public populate()V
    .locals 15

    .prologue
    const/4 v11, 0x0

    const/4 v12, -0x1

    .line 727
    iget-object v10, p0, Landroid/support/v4/view/DraftViewPager;->mAdapter:Landroid/support/v4/view/DraftPagerAdapter;

    if-nez v10, :cond_1

    .line 828
    :cond_0
    return-void

    .line 735
    :cond_1
    iget-boolean v10, p0, Landroid/support/v4/view/DraftViewPager;->mPopulatePending:Z

    if-nez v10, :cond_0

    .line 743
    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->getWindowToken()Landroid/os/IBinder;

    move-result-object v10

    if-eqz v10, :cond_0

    .line 747
    iget-object v10, p0, Landroid/support/v4/view/DraftViewPager;->mAdapter:Landroid/support/v4/view/DraftPagerAdapter;

    invoke-virtual {v10, p0}, Landroid/support/v4/view/DraftPagerAdapter;->startUpdate(Landroid/view/ViewGroup;)V

    .line 749
    iget v8, p0, Landroid/support/v4/view/DraftViewPager;->mOffscreenPageLimit:I

    .line 750
    .local v8, "pageLimit":I
    const/4 v10, 0x0

    iget v13, p0, Landroid/support/v4/view/DraftViewPager;->mCurItem:I

    sub-int/2addr v13, v8

    invoke-static {v10, v13}, Ljava/lang/Math;->max(II)I

    move-result v9

    .line 751
    .local v9, "startPos":I
    iget-object v10, p0, Landroid/support/v4/view/DraftViewPager;->mAdapter:Landroid/support/v4/view/DraftPagerAdapter;

    invoke-virtual {v10}, Landroid/support/v4/view/DraftPagerAdapter;->getCount()I

    move-result v0

    .line 752
    .local v0, "N":I
    add-int/lit8 v10, v0, -0x1

    iget v13, p0, Landroid/support/v4/view/DraftViewPager;->mCurItem:I

    add-int/2addr v13, v8

    invoke-static {v10, v13}, Ljava/lang/Math;->min(II)I

    move-result v4

    .line 757
    .local v4, "endPos":I
    const/4 v7, -0x1

    .line 758
    .local v7, "lastPos":I
    const/4 v5, 0x0

    .local v5, "i":I
    :goto_0
    iget-object v10, p0, Landroid/support/v4/view/DraftViewPager;->mItems:Ljava/util/ArrayList;

    invoke-virtual {v10}, Ljava/util/ArrayList;->size()I

    move-result v10

    if-ge v5, v10, :cond_6

    .line 759
    iget-object v10, p0, Landroid/support/v4/view/DraftViewPager;->mItems:Ljava/util/ArrayList;

    invoke-virtual {v10, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroid/support/v4/view/DraftViewPager$ItemInfo;

    .line 760
    .local v6, "ii":Landroid/support/v4/view/DraftViewPager$ItemInfo;
    iget v10, v6, Landroid/support/v4/view/DraftViewPager$ItemInfo;->position:I

    if-lt v10, v9, :cond_2

    iget v10, v6, Landroid/support/v4/view/DraftViewPager$ItemInfo;->position:I

    if-le v10, v4, :cond_4

    :cond_2
    iget-boolean v10, v6, Landroid/support/v4/view/DraftViewPager$ItemInfo;->scrolling:Z

    if-nez v10, :cond_4

    .line 762
    iget-object v10, p0, Landroid/support/v4/view/DraftViewPager;->mItems:Ljava/util/ArrayList;

    invoke-virtual {v10, v5}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    .line 763
    add-int/lit8 v5, v5, -0x1

    .line 764
    iget-object v10, p0, Landroid/support/v4/view/DraftViewPager;->mAdapter:Landroid/support/v4/view/DraftPagerAdapter;

    iget v13, v6, Landroid/support/v4/view/DraftViewPager$ItemInfo;->position:I

    iget-object v14, v6, Landroid/support/v4/view/DraftViewPager$ItemInfo;->object:Ljava/lang/Object;

    invoke-virtual {v10, p0, v13, v14}, Landroid/support/v4/view/DraftPagerAdapter;->destroyItem(Landroid/view/ViewGroup;ILjava/lang/Object;)V

    .line 780
    :cond_3
    iget v7, v6, Landroid/support/v4/view/DraftViewPager$ItemInfo;->position:I

    .line 758
    add-int/lit8 v5, v5, 0x1

    goto :goto_0

    .line 765
    :cond_4
    if-ge v7, v4, :cond_3

    iget v10, v6, Landroid/support/v4/view/DraftViewPager$ItemInfo;->position:I

    if-le v10, v9, :cond_3

    .line 769
    add-int/lit8 v7, v7, 0x1

    .line 770
    if-ge v7, v9, :cond_5

    .line 771
    move v7, v9

    .line 773
    :cond_5
    :goto_1
    if-gt v7, v4, :cond_3

    iget v10, v6, Landroid/support/v4/view/DraftViewPager$ItemInfo;->position:I

    if-ge v7, v10, :cond_3

    .line 775
    invoke-virtual {p0, v7, v5}, Landroid/support/v4/view/DraftViewPager;->addNewItem(II)V

    .line 776
    add-int/lit8 v7, v7, 0x1

    .line 777
    add-int/lit8 v5, v5, 0x1

    goto :goto_1

    .line 784
    .end local v6    # "ii":Landroid/support/v4/view/DraftViewPager$ItemInfo;
    :cond_6
    iget-object v10, p0, Landroid/support/v4/view/DraftViewPager;->mItems:Ljava/util/ArrayList;

    invoke-virtual {v10}, Ljava/util/ArrayList;->size()I

    move-result v10

    if-lez v10, :cond_7

    iget-object v10, p0, Landroid/support/v4/view/DraftViewPager;->mItems:Ljava/util/ArrayList;

    iget-object v13, p0, Landroid/support/v4/view/DraftViewPager;->mItems:Ljava/util/ArrayList;

    invoke-virtual {v13}, Ljava/util/ArrayList;->size()I

    move-result v13

    add-int/lit8 v13, v13, -0x1

    invoke-virtual {v10, v13}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Landroid/support/v4/view/DraftViewPager$ItemInfo;

    iget v7, v10, Landroid/support/v4/view/DraftViewPager$ItemInfo;->position:I

    .line 785
    :goto_2
    if-ge v7, v4, :cond_9

    .line 786
    add-int/lit8 v7, v7, 0x1

    .line 787
    if-le v7, v9, :cond_8

    .line 788
    :goto_3
    if-gt v7, v4, :cond_9

    .line 790
    invoke-virtual {p0, v7, v12}, Landroid/support/v4/view/DraftViewPager;->addNewItem(II)V

    .line 791
    add-int/lit8 v7, v7, 0x1

    goto :goto_3

    :cond_7
    move v7, v12

    .line 784
    goto :goto_2

    :cond_8
    move v7, v9

    .line 787
    goto :goto_3

    .line 802
    :cond_9
    const/4 v2, 0x0

    .line 803
    .local v2, "curItem":Landroid/support/v4/view/DraftViewPager$ItemInfo;
    const/4 v5, 0x0

    :goto_4
    iget-object v10, p0, Landroid/support/v4/view/DraftViewPager;->mItems:Ljava/util/ArrayList;

    invoke-virtual {v10}, Ljava/util/ArrayList;->size()I

    move-result v10

    if-ge v5, v10, :cond_a

    .line 804
    iget-object v10, p0, Landroid/support/v4/view/DraftViewPager;->mItems:Ljava/util/ArrayList;

    invoke-virtual {v10, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Landroid/support/v4/view/DraftViewPager$ItemInfo;

    iget v10, v10, Landroid/support/v4/view/DraftViewPager$ItemInfo;->position:I

    iget v12, p0, Landroid/support/v4/view/DraftViewPager;->mCurItem:I

    if-ne v10, v12, :cond_d

    .line 805
    iget-object v10, p0, Landroid/support/v4/view/DraftViewPager;->mItems:Ljava/util/ArrayList;

    invoke-virtual {v10, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    .end local v2    # "curItem":Landroid/support/v4/view/DraftViewPager$ItemInfo;
    check-cast v2, Landroid/support/v4/view/DraftViewPager$ItemInfo;

    .line 809
    .restart local v2    # "curItem":Landroid/support/v4/view/DraftViewPager$ItemInfo;
    :cond_a
    iget-object v12, p0, Landroid/support/v4/view/DraftViewPager;->mAdapter:Landroid/support/v4/view/DraftPagerAdapter;

    iget v13, p0, Landroid/support/v4/view/DraftViewPager;->mCurItem:I

    if-eqz v2, :cond_e

    iget-object v10, v2, Landroid/support/v4/view/DraftViewPager$ItemInfo;->object:Ljava/lang/Object;

    :goto_5
    invoke-virtual {v12, p0, v13, v10}, Landroid/support/v4/view/DraftPagerAdapter;->setPrimaryItem(Landroid/view/ViewGroup;ILjava/lang/Object;)V

    .line 811
    iget-object v10, p0, Landroid/support/v4/view/DraftViewPager;->mAdapter:Landroid/support/v4/view/DraftPagerAdapter;

    invoke-virtual {v10, p0}, Landroid/support/v4/view/DraftPagerAdapter;->finishUpdate(Landroid/view/ViewGroup;)V

    .line 813
    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->hasFocus()Z

    move-result v10

    if-eqz v10, :cond_0

    .line 814
    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->findFocus()Landroid/view/View;

    move-result-object v3

    .line 815
    .local v3, "currentFocused":Landroid/view/View;
    if-eqz v3, :cond_f

    invoke-virtual {p0, v3}, Landroid/support/v4/view/DraftViewPager;->infoForAnyChild(Landroid/view/View;)Landroid/support/v4/view/DraftViewPager$ItemInfo;

    move-result-object v6

    .line 816
    .restart local v6    # "ii":Landroid/support/v4/view/DraftViewPager$ItemInfo;
    :goto_6
    if-eqz v6, :cond_b

    iget v10, v6, Landroid/support/v4/view/DraftViewPager$ItemInfo;->position:I

    iget v11, p0, Landroid/support/v4/view/DraftViewPager;->mCurItem:I

    if-eq v10, v11, :cond_0

    .line 817
    :cond_b
    const/4 v5, 0x0

    :goto_7
    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->getChildCount()I

    move-result v10

    if-ge v5, v10, :cond_0

    .line 818
    invoke-virtual {p0, v5}, Landroid/support/v4/view/DraftViewPager;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    .line 819
    .local v1, "child":Landroid/view/View;
    invoke-virtual {p0, v1}, Landroid/support/v4/view/DraftViewPager;->infoForChild(Landroid/view/View;)Landroid/support/v4/view/DraftViewPager$ItemInfo;

    move-result-object v6

    .line 820
    if-eqz v6, :cond_c

    iget v10, v6, Landroid/support/v4/view/DraftViewPager$ItemInfo;->position:I

    iget v11, p0, Landroid/support/v4/view/DraftViewPager;->mCurItem:I

    if-ne v10, v11, :cond_c

    .line 821
    const/4 v10, 0x2

    invoke-virtual {v1, v10}, Landroid/view/View;->requestFocus(I)Z

    move-result v10

    if-nez v10, :cond_0

    .line 817
    :cond_c
    add-int/lit8 v5, v5, 0x1

    goto :goto_7

    .line 803
    .end local v1    # "child":Landroid/view/View;
    .end local v3    # "currentFocused":Landroid/view/View;
    .end local v6    # "ii":Landroid/support/v4/view/DraftViewPager$ItemInfo;
    :cond_d
    add-int/lit8 v5, v5, 0x1

    goto :goto_4

    :cond_e
    move-object v10, v11

    .line 809
    goto :goto_5

    .restart local v3    # "currentFocused":Landroid/view/View;
    :cond_f
    move-object v6, v11

    .line 815
    goto :goto_6
.end method

.method public setAdapter(Landroid/support/v4/app/DraftFragmentStatePagerAdapter;)V
    .locals 8
    .param p1, "adapter"    # Landroid/support/v4/app/DraftFragmentStatePagerAdapter;

    .prologue
    const/4 v7, 0x0

    const/4 v6, 0x0

    .line 305
    iget-object v3, p0, Landroid/support/v4/view/DraftViewPager;->mAdapter:Landroid/support/v4/view/DraftPagerAdapter;

    if-eqz v3, :cond_1

    .line 306
    iget-object v3, p0, Landroid/support/v4/view/DraftViewPager;->mAdapter:Landroid/support/v4/view/DraftPagerAdapter;

    iget-object v4, p0, Landroid/support/v4/view/DraftViewPager;->mObserver:Landroid/support/v4/view/DraftViewPager$PagerObserver;

    invoke-virtual {v3, v4}, Landroid/support/v4/view/DraftPagerAdapter;->unregisterDataSetObserver(Landroid/database/DataSetObserver;)V

    .line 307
    iget-object v3, p0, Landroid/support/v4/view/DraftViewPager;->mAdapter:Landroid/support/v4/view/DraftPagerAdapter;

    invoke-virtual {v3, p0}, Landroid/support/v4/view/DraftPagerAdapter;->startUpdate(Landroid/view/ViewGroup;)V

    .line 308
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v3, p0, Landroid/support/v4/view/DraftViewPager;->mItems:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v3

    if-ge v0, v3, :cond_0

    .line 309
    iget-object v3, p0, Landroid/support/v4/view/DraftViewPager;->mItems:Ljava/util/ArrayList;

    invoke-virtual {v3, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/support/v4/view/DraftViewPager$ItemInfo;

    .line 310
    .local v1, "ii":Landroid/support/v4/view/DraftViewPager$ItemInfo;
    iget-object v3, p0, Landroid/support/v4/view/DraftViewPager;->mAdapter:Landroid/support/v4/view/DraftPagerAdapter;

    iget v4, v1, Landroid/support/v4/view/DraftViewPager$ItemInfo;->position:I

    iget-object v5, v1, Landroid/support/v4/view/DraftViewPager$ItemInfo;->object:Ljava/lang/Object;

    invoke-virtual {v3, p0, v4, v5}, Landroid/support/v4/view/DraftPagerAdapter;->destroyItem(Landroid/view/ViewGroup;ILjava/lang/Object;)V

    .line 308
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 312
    .end local v1    # "ii":Landroid/support/v4/view/DraftViewPager$ItemInfo;
    :cond_0
    iget-object v3, p0, Landroid/support/v4/view/DraftViewPager;->mAdapter:Landroid/support/v4/view/DraftPagerAdapter;

    invoke-virtual {v3, p0}, Landroid/support/v4/view/DraftPagerAdapter;->finishUpdate(Landroid/view/ViewGroup;)V

    .line 313
    iget-object v3, p0, Landroid/support/v4/view/DraftViewPager;->mItems:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->clear()V

    .line 314
    invoke-direct {p0}, Landroid/support/v4/view/DraftViewPager;->removeNonDecorViews()V

    .line 315
    iput v6, p0, Landroid/support/v4/view/DraftViewPager;->mCurItem:I

    .line 316
    invoke-virtual {p0, v6, v6}, Landroid/support/v4/view/DraftViewPager;->scrollTo(II)V

    .line 319
    .end local v0    # "i":I
    :cond_1
    iget-object v2, p0, Landroid/support/v4/view/DraftViewPager;->mAdapter:Landroid/support/v4/view/DraftPagerAdapter;

    .line 320
    .local v2, "oldAdapter":Landroid/support/v4/view/DraftPagerAdapter;
    iput-object p1, p0, Landroid/support/v4/view/DraftViewPager;->mAdapter:Landroid/support/v4/view/DraftPagerAdapter;

    .line 322
    iget-object v3, p0, Landroid/support/v4/view/DraftViewPager;->mAdapter:Landroid/support/v4/view/DraftPagerAdapter;

    if-eqz v3, :cond_3

    .line 323
    iget-object v3, p0, Landroid/support/v4/view/DraftViewPager;->mObserver:Landroid/support/v4/view/DraftViewPager$PagerObserver;

    if-nez v3, :cond_2

    .line 324
    new-instance v3, Landroid/support/v4/view/DraftViewPager$PagerObserver;

    invoke-direct {v3, p0, v7}, Landroid/support/v4/view/DraftViewPager$PagerObserver;-><init>(Landroid/support/v4/view/DraftViewPager;Landroid/support/v4/view/DraftViewPager$1;)V

    iput-object v3, p0, Landroid/support/v4/view/DraftViewPager;->mObserver:Landroid/support/v4/view/DraftViewPager$PagerObserver;

    .line 326
    :cond_2
    iget-object v3, p0, Landroid/support/v4/view/DraftViewPager;->mAdapter:Landroid/support/v4/view/DraftPagerAdapter;

    iget-object v4, p0, Landroid/support/v4/view/DraftViewPager;->mObserver:Landroid/support/v4/view/DraftViewPager$PagerObserver;

    invoke-virtual {v3, v4}, Landroid/support/v4/view/DraftPagerAdapter;->registerDataSetObserver(Landroid/database/DataSetObserver;)V

    .line 327
    iput-boolean v6, p0, Landroid/support/v4/view/DraftViewPager;->mPopulatePending:Z

    .line 328
    iget v3, p0, Landroid/support/v4/view/DraftViewPager;->mRestoredCurItem:I

    if-ltz v3, :cond_5

    .line 329
    iget-object v3, p0, Landroid/support/v4/view/DraftViewPager;->mAdapter:Landroid/support/v4/view/DraftPagerAdapter;

    iget-object v4, p0, Landroid/support/v4/view/DraftViewPager;->mRestoredAdapterState:Landroid/os/Parcelable;

    iget-object v5, p0, Landroid/support/v4/view/DraftViewPager;->mRestoredClassLoader:Ljava/lang/ClassLoader;

    invoke-virtual {v3, v4, v5}, Landroid/support/v4/view/DraftPagerAdapter;->restoreState(Landroid/os/Parcelable;Ljava/lang/ClassLoader;)V

    .line 330
    iget v3, p0, Landroid/support/v4/view/DraftViewPager;->mRestoredCurItem:I

    const/4 v4, 0x1

    invoke-virtual {p0, v3, v6, v4}, Landroid/support/v4/view/DraftViewPager;->setCurrentItemInternal(IZZ)V

    .line 331
    const/4 v3, -0x1

    iput v3, p0, Landroid/support/v4/view/DraftViewPager;->mRestoredCurItem:I

    .line 332
    iput-object v7, p0, Landroid/support/v4/view/DraftViewPager;->mRestoredAdapterState:Landroid/os/Parcelable;

    .line 333
    iput-object v7, p0, Landroid/support/v4/view/DraftViewPager;->mRestoredClassLoader:Ljava/lang/ClassLoader;

    .line 339
    :cond_3
    :goto_1
    iget-object v3, p0, Landroid/support/v4/view/DraftViewPager;->mAdapterChangeListener:Landroid/support/v4/view/DraftViewPager$OnAdapterChangeListener;

    if-eqz v3, :cond_4

    if-eq v2, p1, :cond_4

    .line 340
    iget-object v3, p0, Landroid/support/v4/view/DraftViewPager;->mAdapterChangeListener:Landroid/support/v4/view/DraftViewPager$OnAdapterChangeListener;

    invoke-interface {v3, v2, p1}, Landroid/support/v4/view/DraftViewPager$OnAdapterChangeListener;->onAdapterChanged(Landroid/support/v4/view/DraftPagerAdapter;Landroid/support/v4/view/DraftPagerAdapter;)V

    .line 342
    :cond_4
    return-void

    .line 335
    :cond_5
    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->populate()V

    goto :goto_1
.end method

.method public setCurrentItem(I)V
    .locals 2
    .param p1, "item"    # I

    .prologue
    const/4 v1, 0x0

    .line 376
    iput-boolean v1, p0, Landroid/support/v4/view/DraftViewPager;->mPopulatePending:Z

    .line 377
    iget-boolean v0, p0, Landroid/support/v4/view/DraftViewPager;->mFirstLayout:Z

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    invoke-virtual {p0, p1, v0, v1}, Landroid/support/v4/view/DraftViewPager;->setCurrentItemInternal(IZZ)V

    .line 378
    return-void

    :cond_0
    move v0, v1

    .line 377
    goto :goto_0
.end method

.method public setCurrentItem(IZ)V
    .locals 1
    .param p1, "item"    # I
    .param p2, "smoothScroll"    # Z

    .prologue
    const/4 v0, 0x0

    .line 387
    iput-boolean v0, p0, Landroid/support/v4/view/DraftViewPager;->mPopulatePending:Z

    .line 388
    invoke-virtual {p0, p1, p2, v0}, Landroid/support/v4/view/DraftViewPager;->setCurrentItemInternal(IZZ)V

    .line 389
    return-void
.end method

.method setCurrentItemInternal(IZZ)V
    .locals 1
    .param p1, "item"    # I
    .param p2, "smoothScroll"    # Z
    .param p3, "always"    # Z

    .prologue
    .line 396
    const/4 v0, 0x0

    invoke-virtual {p0, p1, p2, p3, v0}, Landroid/support/v4/view/DraftViewPager;->setCurrentItemInternal(IZZI)V

    .line 397
    return-void
.end method

.method setCurrentItemInternal(IZZI)V
    .locals 6
    .param p1, "item"    # I
    .param p2, "smoothScroll"    # Z
    .param p3, "always"    # Z
    .param p4, "velocity"    # I

    .prologue
    const/4 v1, 0x1

    const/4 v5, 0x0

    .line 400
    iget-object v4, p0, Landroid/support/v4/view/DraftViewPager;->mAdapter:Landroid/support/v4/view/DraftPagerAdapter;

    if-eqz v4, :cond_0

    iget-object v4, p0, Landroid/support/v4/view/DraftViewPager;->mAdapter:Landroid/support/v4/view/DraftPagerAdapter;

    invoke-virtual {v4}, Landroid/support/v4/view/DraftPagerAdapter;->getCount()I

    move-result v4

    if-gtz v4, :cond_2

    .line 401
    :cond_0
    invoke-direct {p0, v5}, Landroid/support/v4/view/DraftViewPager;->setScrollingCacheEnabled(Z)V

    .line 446
    :cond_1
    :goto_0
    return-void

    .line 404
    :cond_2
    if-nez p3, :cond_3

    iget v4, p0, Landroid/support/v4/view/DraftViewPager;->mCurItem:I

    if-ne v4, p1, :cond_3

    iget-object v4, p0, Landroid/support/v4/view/DraftViewPager;->mItems:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v4

    if-eqz v4, :cond_3

    .line 405
    invoke-direct {p0, v5}, Landroid/support/v4/view/DraftViewPager;->setScrollingCacheEnabled(Z)V

    goto :goto_0

    .line 408
    :cond_3
    if-gez p1, :cond_6

    .line 409
    const/4 p1, 0x0

    .line 413
    :cond_4
    :goto_1
    iget v3, p0, Landroid/support/v4/view/DraftViewPager;->mOffscreenPageLimit:I

    .line 414
    .local v3, "pageLimit":I
    iget v4, p0, Landroid/support/v4/view/DraftViewPager;->mCurItem:I

    add-int/2addr v4, v3

    if-gt p1, v4, :cond_5

    iget v4, p0, Landroid/support/v4/view/DraftViewPager;->mCurItem:I

    sub-int/2addr v4, v3

    if-ge p1, v4, :cond_7

    .line 418
    :cond_5
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_2
    iget-object v4, p0, Landroid/support/v4/view/DraftViewPager;->mItems:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v4

    if-ge v2, v4, :cond_7

    .line 419
    iget-object v4, p0, Landroid/support/v4/view/DraftViewPager;->mItems:Ljava/util/ArrayList;

    invoke-virtual {v4, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/support/v4/view/DraftViewPager$ItemInfo;

    iput-boolean v1, v4, Landroid/support/v4/view/DraftViewPager$ItemInfo;->scrolling:Z

    .line 418
    add-int/lit8 v2, v2, 0x1

    goto :goto_2

    .line 410
    .end local v2    # "i":I
    .end local v3    # "pageLimit":I
    :cond_6
    iget-object v4, p0, Landroid/support/v4/view/DraftViewPager;->mAdapter:Landroid/support/v4/view/DraftPagerAdapter;

    invoke-virtual {v4}, Landroid/support/v4/view/DraftPagerAdapter;->getCount()I

    move-result v4

    if-lt p1, v4, :cond_4

    .line 411
    iget-object v4, p0, Landroid/support/v4/view/DraftViewPager;->mAdapter:Landroid/support/v4/view/DraftPagerAdapter;

    invoke-virtual {v4}, Landroid/support/v4/view/DraftPagerAdapter;->getCount()I

    move-result v4

    add-int/lit8 p1, v4, -0x1

    goto :goto_1

    .line 422
    .restart local v3    # "pageLimit":I
    :cond_7
    iget v4, p0, Landroid/support/v4/view/DraftViewPager;->mCurItem:I

    if-eq v4, p1, :cond_9

    .line 423
    .local v1, "dispatchSelected":Z
    :goto_3
    iput p1, p0, Landroid/support/v4/view/DraftViewPager;->mCurItem:I

    .line 424
    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->populate()V

    .line 426
    invoke-direct {p0, p1}, Landroid/support/v4/view/DraftViewPager;->getAdjustedXDestination(I)I

    move-result v0

    .line 428
    .local v0, "destX":I
    if-eqz p2, :cond_a

    .line 429
    invoke-virtual {p0, p1, v0, v5, p4}, Landroid/support/v4/view/DraftViewPager;->smoothScrollTo(IIII)V

    .line 430
    if-eqz v1, :cond_8

    iget-object v4, p0, Landroid/support/v4/view/DraftViewPager;->mOnPageChangeListener:Landroid/support/v4/view/DraftViewPager$OnPageChangeListener;

    if-eqz v4, :cond_8

    .line 431
    iget-object v4, p0, Landroid/support/v4/view/DraftViewPager;->mOnPageChangeListener:Landroid/support/v4/view/DraftViewPager$OnPageChangeListener;

    invoke-interface {v4, p1}, Landroid/support/v4/view/DraftViewPager$OnPageChangeListener;->onPageSelected(I)V

    .line 433
    :cond_8
    if-eqz v1, :cond_1

    iget-object v4, p0, Landroid/support/v4/view/DraftViewPager;->mInternalPageChangeListener:Landroid/support/v4/view/DraftViewPager$OnPageChangeListener;

    if-eqz v4, :cond_1

    .line 434
    iget-object v4, p0, Landroid/support/v4/view/DraftViewPager;->mInternalPageChangeListener:Landroid/support/v4/view/DraftViewPager$OnPageChangeListener;

    invoke-interface {v4, p1}, Landroid/support/v4/view/DraftViewPager$OnPageChangeListener;->onPageSelected(I)V

    goto :goto_0

    .end local v0    # "destX":I
    .end local v1    # "dispatchSelected":Z
    :cond_9
    move v1, v5

    .line 422
    goto :goto_3

    .line 437
    .restart local v0    # "destX":I
    .restart local v1    # "dispatchSelected":Z
    :cond_a
    if-eqz v1, :cond_b

    iget-object v4, p0, Landroid/support/v4/view/DraftViewPager;->mOnPageChangeListener:Landroid/support/v4/view/DraftViewPager$OnPageChangeListener;

    if-eqz v4, :cond_b

    .line 438
    iget-object v4, p0, Landroid/support/v4/view/DraftViewPager;->mOnPageChangeListener:Landroid/support/v4/view/DraftViewPager$OnPageChangeListener;

    invoke-interface {v4, p1}, Landroid/support/v4/view/DraftViewPager$OnPageChangeListener;->onPageSelected(I)V

    .line 440
    :cond_b
    if-eqz v1, :cond_c

    iget-object v4, p0, Landroid/support/v4/view/DraftViewPager;->mInternalPageChangeListener:Landroid/support/v4/view/DraftViewPager$OnPageChangeListener;

    if-eqz v4, :cond_c

    .line 441
    iget-object v4, p0, Landroid/support/v4/view/DraftViewPager;->mInternalPageChangeListener:Landroid/support/v4/view/DraftViewPager$OnPageChangeListener;

    invoke-interface {v4, p1}, Landroid/support/v4/view/DraftViewPager$OnPageChangeListener;->onPageSelected(I)V

    .line 443
    :cond_c
    invoke-direct {p0}, Landroid/support/v4/view/DraftViewPager;->completeScroll()V

    .line 444
    invoke-virtual {p0, v0, v5}, Landroid/support/v4/view/DraftViewPager;->scrollTo(II)V

    goto/16 :goto_0
.end method

.method setInternalPageChangeListener(Landroid/support/v4/view/DraftViewPager$OnPageChangeListener;)Landroid/support/v4/view/DraftViewPager$OnPageChangeListener;
    .locals 1
    .param p1, "listener"    # Landroid/support/v4/view/DraftViewPager$OnPageChangeListener;

    .prologue
    .line 487
    iget-object v0, p0, Landroid/support/v4/view/DraftViewPager;->mInternalPageChangeListener:Landroid/support/v4/view/DraftViewPager$OnPageChangeListener;

    .line 488
    .local v0, "oldListener":Landroid/support/v4/view/DraftViewPager$OnPageChangeListener;
    iput-object p1, p0, Landroid/support/v4/view/DraftViewPager;->mInternalPageChangeListener:Landroid/support/v4/view/DraftViewPager$OnPageChangeListener;

    .line 489
    return-object v0
.end method

.method public setOffscreenPageLimit(I)V
    .locals 4
    .param p1, "limit"    # I

    .prologue
    const/4 v3, 0x1

    .line 521
    if-ge p1, v3, :cond_0

    .line 522
    const-string v0, "ViewPager"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Requested offscreen page limit "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " too small; defaulting to "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 524
    const/4 p1, 0x1

    .line 526
    :cond_0
    iget v0, p0, Landroid/support/v4/view/DraftViewPager;->mOffscreenPageLimit:I

    if-eq p1, v0, :cond_1

    .line 527
    iput p1, p0, Landroid/support/v4/view/DraftViewPager;->mOffscreenPageLimit:I

    .line 528
    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->populate()V

    .line 530
    :cond_1
    return-void
.end method

.method setOnAdapterChangeListener(Landroid/support/v4/view/DraftViewPager$OnAdapterChangeListener;)V
    .locals 0
    .param p1, "listener"    # Landroid/support/v4/view/DraftViewPager$OnAdapterChangeListener;

    .prologue
    .line 365
    iput-object p1, p0, Landroid/support/v4/view/DraftViewPager;->mAdapterChangeListener:Landroid/support/v4/view/DraftViewPager$OnAdapterChangeListener;

    .line 366
    return-void
.end method

.method public setOnPageChangeListener(Landroid/support/v4/view/DraftViewPager$OnPageChangeListener;)V
    .locals 0
    .param p1, "listener"    # Landroid/support/v4/view/DraftViewPager$OnPageChangeListener;

    .prologue
    .line 477
    iput-object p1, p0, Landroid/support/v4/view/DraftViewPager;->mOnPageChangeListener:Landroid/support/v4/view/DraftViewPager$OnPageChangeListener;

    .line 478
    return-void
.end method

.method public setPageMargin(I)V
    .locals 2
    .param p1, "marginPixels"    # I

    .prologue
    .line 541
    iget v0, p0, Landroid/support/v4/view/DraftViewPager;->mPageMargin:I

    .line 542
    .local v0, "oldMargin":I
    iput p1, p0, Landroid/support/v4/view/DraftViewPager;->mPageMargin:I

    .line 544
    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->getWidth()I

    move-result v1

    .line 545
    .local v1, "width":I
    invoke-direct {p0, v1, v1, p1, v0}, Landroid/support/v4/view/DraftViewPager;->recomputeScrollPosition(IIII)V

    .line 547
    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->requestLayout()V

    .line 548
    return-void
.end method

.method public setPageMarginDrawable(I)V
    .locals 1
    .param p1, "resId"    # I

    .prologue
    .line 577
    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    invoke-virtual {p0, v0}, Landroid/support/v4/view/DraftViewPager;->setPageMarginDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 578
    return-void
.end method

.method public setPageMarginDrawable(Landroid/graphics/drawable/Drawable;)V
    .locals 1
    .param p1, "d"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 565
    iput-object p1, p0, Landroid/support/v4/view/DraftViewPager;->mMarginDrawable:Landroid/graphics/drawable/Drawable;

    .line 566
    if-eqz p1, :cond_0

    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->refreshDrawableState()V

    .line 567
    :cond_0
    if-nez p1, :cond_1

    const/4 v0, 0x1

    :goto_0
    invoke-virtual {p0, v0}, Landroid/support/v4/view/DraftViewPager;->setWillNotDraw(Z)V

    .line 568
    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->invalidate()V

    .line 569
    return-void

    .line 567
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method smoothScrollTo(IIII)V
    .locals 14
    .param p1, "position"    # I
    .param p2, "x"    # I
    .param p3, "y"    # I
    .param p4, "velocity"    # I

    .prologue
    .line 612
    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->getChildCount()I

    move-result v1

    if-nez v1, :cond_0

    .line 614
    const/4 v1, 0x0

    invoke-direct {p0, v1}, Landroid/support/v4/view/DraftViewPager;->setScrollingCacheEnabled(Z)V

    .line 651
    :goto_0
    return-void

    .line 618
    :cond_0
    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->getScrollX()I

    move-result v2

    .line 619
    .local v2, "sx":I
    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->getScrollY()I

    move-result v3

    .line 620
    .local v3, "sy":I
    sub-int v4, p2, v2

    .line 621
    .local v4, "dx":I
    sub-int v5, p3, v3

    .line 623
    .local v5, "dy":I
    if-nez v4, :cond_1

    if-nez v5, :cond_1

    .line 624
    invoke-direct {p0}, Landroid/support/v4/view/DraftViewPager;->completeScroll()V

    .line 625
    const/4 v1, 0x0

    invoke-direct {p0, v1}, Landroid/support/v4/view/DraftViewPager;->setScrollState(I)V

    goto :goto_0

    .line 629
    :cond_1
    const/4 v1, 0x1

    invoke-direct {p0, v1}, Landroid/support/v4/view/DraftViewPager;->setScrollingCacheEnabled(Z)V

    .line 630
    const/4 v1, 0x1

    iput-boolean v1, p0, Landroid/support/v4/view/DraftViewPager;->mScrolling:Z

    .line 631
    const/4 v1, 0x2

    invoke-direct {p0, v1}, Landroid/support/v4/view/DraftViewPager;->setScrollState(I)V

    .line 633
    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->getWidth()I

    move-result v11

    .line 634
    .local v11, "width":I
    div-int/lit8 v9, v11, 0x2

    .line 635
    .local v9, "halfWidth":I
    const/high16 v1, 0x3f800000    # 1.0f

    const/high16 v12, 0x3f800000    # 1.0f

    invoke-static {v4}, Ljava/lang/Math;->abs(I)I

    move-result v13

    int-to-float v13, v13

    mul-float/2addr v12, v13

    int-to-float v13, v11

    div-float/2addr v12, v13

    invoke-static {v1, v12}, Ljava/lang/Math;->min(FF)F

    move-result v8

    .line 636
    .local v8, "distanceRatio":F
    int-to-float v1, v9

    int-to-float v12, v9

    invoke-virtual {p0, v8}, Landroid/support/v4/view/DraftViewPager;->distanceInfluenceForSnapDuration(F)F

    move-result v13

    mul-float/2addr v12, v13

    add-float v7, v1, v12

    .line 639
    .local v7, "distance":F
    const/4 v6, 0x0

    .line 640
    .local v6, "duration":I
    invoke-static/range {p4 .. p4}, Ljava/lang/Math;->abs(I)I

    move-result p4

    .line 641
    if-lez p4, :cond_2

    .line 642
    const/high16 v1, 0x447a0000    # 1000.0f

    move/from16 v0, p4

    int-to-float v12, v0

    div-float v12, v7, v12

    invoke-static {v12}, Ljava/lang/Math;->abs(F)F

    move-result v12

    mul-float/2addr v1, v12

    invoke-static {v1}, Ljava/lang/Math;->round(F)I

    move-result v1

    mul-int/lit8 v6, v1, 0x4

    .line 647
    :goto_1
    const/16 v1, 0x258

    invoke-static {v6, v1}, Ljava/lang/Math;->min(II)I

    move-result v6

    .line 649
    iget-object v1, p0, Landroid/support/v4/view/DraftViewPager;->mScroller:Landroid/widget/Scroller;

    invoke-virtual/range {v1 .. v6}, Landroid/widget/Scroller;->startScroll(IIIII)V

    .line 650
    invoke-virtual {p0}, Landroid/support/v4/view/DraftViewPager;->invalidate()V

    goto :goto_0

    .line 644
    :cond_2
    invoke-static {v4}, Ljava/lang/Math;->abs(I)I

    move-result v1

    int-to-float v1, v1

    iget v12, p0, Landroid/support/v4/view/DraftViewPager;->mPageMargin:I

    add-int/2addr v12, v11

    int-to-float v12, v12

    div-float v10, v1, v12

    .line 645
    .local v10, "pageDelta":F
    const/high16 v1, 0x3f800000    # 1.0f

    add-float/2addr v1, v10

    const/high16 v12, 0x42c80000    # 100.0f

    mul-float/2addr v1, v12

    float-to-int v6, v1

    goto :goto_1
.end method

.method protected verifyDrawable(Landroid/graphics/drawable/Drawable;)Z
    .locals 1
    .param p1, "who"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 582
    invoke-super {p0, p1}, Landroid/view/ViewGroup;->verifyDrawable(Landroid/graphics/drawable/Drawable;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Landroid/support/v4/view/DraftViewPager;->mMarginDrawable:Landroid/graphics/drawable/Drawable;

    if-ne p1, v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method
