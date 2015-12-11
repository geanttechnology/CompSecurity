.class public Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;
.super Landroid/view/ViewGroup;
.source "ViewItSlidingDrawer.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer$1;,
        Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer$SlidingHandler;,
        Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer$DrawerToggler;,
        Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer$OnDrawerScrollListener;,
        Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer$OnDrawerCloseListener;,
        Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer$OnDrawerOpenListener;
    }
.end annotation


# instance fields
.field private mActionMoveThreshold:F

.field private mAllowSingleTap:Z

.field private mAnimateOnClick:Z

.field private mAnimatedAcceleration:F

.field private mAnimatedVelocity:F

.field private mAnimating:Z

.field private mAnimationLastTime:J

.field private mAnimationPosition:F

.field protected mBottomOffset:I

.field private mContent:Landroid/view/View;

.field private final mContentId:I

.field private mCurrentAnimationTime:J

.field private mExpanded:Z

.field private final mFrame:Landroid/graphics/Rect;

.field private mHandle:Landroid/view/View;

.field private final mHandleId:I

.field private final mHandler:Landroid/os/Handler;

.field private final mInvalidate:Landroid/graphics/Rect;

.field private mLastMotionPositionY:F

.field private mLocked:Z

.field private final mMaximumAcceleration:I

.field private final mMaximumMajorVelocity:I

.field private final mMaximumTapVelocity:I

.field private mOnDrawerCloseListener:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer$OnDrawerCloseListener;

.field private mOnDrawerOpenListener:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer$OnDrawerOpenListener;

.field private mOnDrawerScrollListener:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer$OnDrawerScrollListener;

.field private mRequestInterceptTouchEvent:Z

.field private mShowContentAfterClose:Z

.field private final mTapThreshold:I

.field private mTopOffset:I

.field private mTouchDelta:I

.field private mTracking:Z

.field private mVelocityTracker:Landroid/view/VelocityTracker;

.field private final mVelocityUnits:I

.field protected mVertical:Z


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 198
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 199
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 12
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    const/high16 v11, 0x447a0000    # 1000.0f

    const/4 v10, 0x0

    const/high16 v9, 0x3f000000    # 0.5f

    const/4 v6, 0x1

    const/4 v7, 0x0

    .line 209
    invoke-direct {p0, p1, p2, p3}, Landroid/view/ViewGroup;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 105
    new-instance v5, Landroid/graphics/Rect;

    invoke-direct {v5}, Landroid/graphics/Rect;-><init>()V

    iput-object v5, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mFrame:Landroid/graphics/Rect;

    .line 106
    new-instance v5, Landroid/graphics/Rect;

    invoke-direct {v5}, Landroid/graphics/Rect;-><init>()V

    iput-object v5, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mInvalidate:Landroid/graphics/Rect;

    .line 108
    iput-boolean v7, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mLocked:Z

    .line 121
    new-instance v5, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer$SlidingHandler;

    const/4 v8, 0x0

    invoke-direct {v5, p0, v8}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer$SlidingHandler;-><init>(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer$1;)V

    iput-object v5, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mHandler:Landroid/os/Handler;

    .line 140
    iput v10, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mLastMotionPositionY:F

    .line 148
    iput-boolean v7, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mRequestInterceptTouchEvent:Z

    .line 381
    const/high16 v5, 0x41200000    # 10.0f

    iput v5, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mActionMoveThreshold:F

    .line 211
    sget-object v5, Lcom/amazon/mShop/android/lib/R$styleable;->AmazonSlidingDrawer:[I

    invoke-virtual {p1, p2, v5, p3, v7}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 213
    .local v0, "a":Landroid/content/res/TypedArray;
    const/4 v5, 0x2

    invoke-virtual {v0, v5, v6}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v4

    .line 214
    .local v4, "orientation":I
    if-ne v4, v6, :cond_0

    move v5, v6

    :goto_0
    iput-boolean v5, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mVertical:Z

    .line 216
    const/4 v5, 0x3

    invoke-virtual {v0, v5, v10}, Landroid/content/res/TypedArray;->getDimension(IF)F

    move-result v5

    float-to-int v5, v5

    iput v5, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mBottomOffset:I

    .line 217
    const/4 v5, 0x4

    invoke-virtual {v0, v5, v10}, Landroid/content/res/TypedArray;->getDimension(IF)F

    move-result v5

    float-to-int v5, v5

    iput v5, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mTopOffset:I

    .line 218
    const/4 v5, 0x5

    invoke-virtual {v0, v5, v6}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v5

    iput-boolean v5, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mAllowSingleTap:Z

    .line 219
    const/4 v5, 0x6

    invoke-virtual {v0, v5, v6}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v5

    iput-boolean v5, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mAnimateOnClick:Z

    .line 220
    const/4 v5, 0x7

    invoke-virtual {v0, v5, v7}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v5

    iput-boolean v5, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mShowContentAfterClose:Z

    .line 222
    invoke-virtual {v0, v7, v7}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v3

    .line 223
    .local v3, "handleId":I
    if-nez v3, :cond_1

    .line 224
    new-instance v5, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v6, "The handle attribute is required and must refer to a valid child."

    invoke-direct {v5, v6}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v5

    .end local v3    # "handleId":I
    :cond_0
    move v5, v7

    .line 214
    goto :goto_0

    .line 228
    .restart local v3    # "handleId":I
    :cond_1
    invoke-virtual {v0, v6, v7}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v1

    .line 229
    .local v1, "contentId":I
    if-nez v1, :cond_2

    .line 230
    new-instance v5, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v6, "The content attribute is required and must refer to a valid child."

    invoke-direct {v5, v6}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 234
    :cond_2
    if-ne v3, v1, :cond_3

    .line 235
    new-instance v5, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v6, "The content and handle attributes must refer to different children."

    invoke-direct {v5, v6}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 239
    :cond_3
    iput v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mHandleId:I

    .line 240
    iput v1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mContentId:I

    .line 242
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    invoke-virtual {v5}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v5

    iget v2, v5, Landroid/util/DisplayMetrics;->density:F

    .line 243
    .local v2, "density":F
    const/high16 v5, 0x3f800000    # 1.0f

    mul-float/2addr v5, v2

    add-float/2addr v5, v9

    float-to-int v5, v5

    iput v5, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mTapThreshold:I

    .line 244
    const/high16 v5, 0x43960000    # 300.0f

    mul-float/2addr v5, v2

    add-float/2addr v5, v9

    float-to-int v5, v5

    iput v5, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mMaximumTapVelocity:I

    .line 246
    const/high16 v5, 0x43480000    # 200.0f

    mul-float/2addr v5, v2

    add-float/2addr v5, v9

    float-to-int v5, v5

    iput v5, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mMaximumMajorVelocity:I

    .line 247
    mul-float v5, v11, v2

    add-float/2addr v5, v9

    float-to-int v5, v5

    iput v5, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mMaximumAcceleration:I

    .line 248
    mul-float v5, v11, v2

    add-float/2addr v5, v9

    float-to-int v5, v5

    iput v5, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mVelocityUnits:I

    .line 250
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 252
    invoke-virtual {p0, v7}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->setAlwaysDrawnWithCacheEnabled(Z)V

    .line 253
    return-void
.end method

.method static synthetic access$200(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;

    .prologue
    .line 80
    iget-boolean v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mLocked:Z

    return v0
.end method

.method static synthetic access$300(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;

    .prologue
    .line 80
    iget-boolean v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mAnimateOnClick:Z

    return v0
.end method

.method static synthetic access$400(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;

    .prologue
    .line 80
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->doAnimation()V

    return-void
.end method

.method private animateClose(I)V
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 941
    invoke-direct {p0, p1}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->prepareTracking(I)V

    .line 942
    iget-boolean v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mVertical:Z

    if-eqz v0, :cond_0

    iget v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mMaximumAcceleration:I

    int-to-float v0, v0

    :goto_0
    const/4 v1, 0x1

    invoke-direct {p0, p1, v0, v1}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->performFling(IFZ)V

    .line 943
    return-void

    .line 942
    :cond_0
    iget v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mMaximumAcceleration:I

    neg-int v0, v0

    int-to-float v0, v0

    goto :goto_0
.end method

.method private animateOpen(I)V
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 946
    invoke-direct {p0, p1}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->prepareTracking(I)V

    .line 947
    iget-boolean v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mVertical:Z

    if-eqz v0, :cond_0

    iget v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mMaximumAcceleration:I

    neg-int v0, v0

    int-to-float v0, v0

    :goto_0
    const/4 v1, 0x1

    invoke-direct {p0, p1, v0, v1}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->performFling(IFZ)V

    .line 948
    return-void

    .line 947
    :cond_0
    iget v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mMaximumAcceleration:I

    int-to-float v0, v0

    goto :goto_0
.end method

.method private closeDrawer()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 832
    iput-boolean v2, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mExpanded:Z

    .line 833
    const/16 v0, -0x2712

    invoke-direct {p0, v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->moveHandle(I)V

    .line 834
    iget-boolean v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mShowContentAfterClose:Z

    if-eqz v0, :cond_1

    iget v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mBottomOffset:I

    int-to-float v0, v0

    const/4 v1, 0x0

    cmpl-float v0, v0, v1

    if-eqz v0, :cond_1

    .line 835
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mContent:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 841
    :goto_0
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mOnDrawerCloseListener:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer$OnDrawerCloseListener;

    if-eqz v0, :cond_0

    .line 842
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mOnDrawerCloseListener:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer$OnDrawerCloseListener;

    invoke-interface {v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer$OnDrawerCloseListener;->onDrawerClosed()V

    .line 844
    :cond_0
    return-void

    .line 837
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mContent:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0
.end method

.method private doAnimation()V
    .locals 7

    .prologue
    const-wide/16 v5, 0x10

    const/16 v4, 0x3e8

    const/4 v3, 0x0

    .line 762
    iget-boolean v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mAnimating:Z

    if-eqz v0, :cond_0

    .line 763
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->incrementAnimation()V

    .line 764
    iget-boolean v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mVertical:Z

    if-eqz v0, :cond_3

    .line 765
    iget v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mAnimationPosition:F

    iget v1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mBottomOffset:I

    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->getHeight()I

    move-result v2

    add-int/2addr v1, v2

    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mHandle:Landroid/view/View;

    invoke-virtual {v2}, Landroid/view/View;->getHeight()I

    move-result v2

    sub-int/2addr v1, v2

    int-to-float v1, v1

    cmpl-float v0, v0, v1

    if-ltz v0, :cond_1

    .line 766
    iput-boolean v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mAnimating:Z

    .line 767
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->closeDrawer()V

    .line 790
    :cond_0
    :goto_0
    return-void

    .line 768
    :cond_1
    iget v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mAnimationPosition:F

    iget v1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mTopOffset:I

    int-to-float v1, v1

    cmpg-float v0, v0, v1

    if-gtz v0, :cond_2

    .line 769
    iput-boolean v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mAnimating:Z

    .line 770
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->openDrawer()V

    goto :goto_0

    .line 772
    :cond_2
    iget v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mAnimationPosition:F

    float-to-int v0, v0

    invoke-direct {p0, v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->moveHandle(I)V

    .line 773
    iget-wide v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mCurrentAnimationTime:J

    add-long/2addr v0, v5

    iput-wide v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mCurrentAnimationTime:J

    .line 774
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mHandler:Landroid/os/Handler;

    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mHandler:Landroid/os/Handler;

    invoke-virtual {v1, v4}, Landroid/os/Handler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v1

    iget-wide v2, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mCurrentAnimationTime:J

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->sendMessageAtTime(Landroid/os/Message;J)Z

    goto :goto_0

    .line 777
    :cond_3
    iget v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mAnimationPosition:F

    iget v1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mBottomOffset:I

    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mHandle:Landroid/view/View;

    invoke-virtual {v2}, Landroid/view/View;->getWidth()I

    move-result v2

    add-int/2addr v1, v2

    int-to-float v1, v1

    cmpg-float v0, v0, v1

    if-gtz v0, :cond_4

    .line 778
    iput-boolean v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mAnimating:Z

    .line 779
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->closeDrawer()V

    goto :goto_0

    .line 780
    :cond_4
    iget v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mAnimationPosition:F

    iget v1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mTopOffset:I

    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->getWidth()I

    move-result v2

    add-int/2addr v1, v2

    int-to-float v1, v1

    cmpl-float v0, v0, v1

    if-ltz v0, :cond_5

    .line 781
    iput-boolean v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mAnimating:Z

    .line 782
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->openDrawer()V

    goto :goto_0

    .line 784
    :cond_5
    iget v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mAnimationPosition:F

    float-to-int v0, v0

    invoke-direct {p0, v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->moveHandle(I)V

    .line 785
    iget-wide v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mCurrentAnimationTime:J

    add-long/2addr v0, v5

    iput-wide v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mCurrentAnimationTime:J

    .line 786
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mHandler:Landroid/os/Handler;

    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mHandler:Landroid/os/Handler;

    invoke-virtual {v1, v4}, Landroid/os/Handler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v1

    iget-wide v2, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mCurrentAnimationTime:J

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->sendMessageAtTime(Landroid/os/Message;J)Z

    goto :goto_0
.end method

.method private incrementAnimation()V
    .locals 8

    .prologue
    .line 793
    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v1

    .line 794
    .local v1, "now":J
    iget-wide v6, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mAnimationLastTime:J

    sub-long v6, v1, v6

    long-to-float v6, v6

    const/high16 v7, 0x447a0000    # 1000.0f

    div-float v4, v6, v7

    .line 795
    .local v4, "t":F
    iget v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mAnimationPosition:F

    .line 796
    .local v3, "position":F
    iget v5, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mAnimatedVelocity:F

    .line 797
    .local v5, "v":F
    iget v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mAnimatedAcceleration:F

    .line 798
    .local v0, "a":F
    mul-float v6, v5, v4

    add-float/2addr v6, v3

    const/high16 v7, 0x3f000000    # 0.5f

    mul-float/2addr v7, v0

    mul-float/2addr v7, v4

    mul-float/2addr v7, v4

    add-float/2addr v6, v7

    iput v6, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mAnimationPosition:F

    .line 799
    mul-float v6, v0, v4

    add-float/2addr v6, v5

    iput v6, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mAnimatedVelocity:F

    .line 800
    iput-wide v1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mAnimationLastTime:J

    .line 801
    return-void
.end method

.method private moveHandle(I)V
    .locals 17
    .param p1, "position"    # I

    .prologue
    .line 629
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mHandle:Landroid/view/View;

    .line 630
    .local v5, "handle":Landroid/view/View;
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mContent:Landroid/view/View;

    .line 631
    .local v1, "content":Landroid/view/View;
    const/4 v7, 0x0

    .line 632
    .local v7, "percent":F
    const/16 v12, -0x2711

    move/from16 v0, p1

    if-ne v0, v12, :cond_0

    .line 633
    const/4 v7, 0x0

    .line 639
    :goto_0
    move-object/from16 v0, p0

    invoke-virtual {v0, v7}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->updateHandleBackground(F)V

    .line 641
    move-object/from16 v0, p0

    iget-boolean v12, v0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mVertical:Z

    if-eqz v12, :cond_6

    .line 642
    const/16 v12, -0x2711

    move/from16 v0, p1

    if-ne v0, v12, :cond_2

    .line 643
    move-object/from16 v0, p0

    iget v12, v0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mTopOffset:I

    invoke-virtual {v5}, Landroid/view/View;->getTop()I

    move-result v13

    sub-int/2addr v12, v13

    invoke-virtual {v5, v12}, Landroid/view/View;->offsetTopAndBottom(I)V

    .line 644
    const/4 v12, 0x0

    invoke-virtual {v5}, Landroid/view/View;->getBottom()I

    move-result v13

    invoke-virtual {v1}, Landroid/view/View;->getMeasuredWidth()I

    move-result v14

    invoke-virtual {v5}, Landroid/view/View;->getBottom()I

    move-result v15

    invoke-virtual {v1}, Landroid/view/View;->getMeasuredHeight()I

    move-result v16

    add-int v15, v15, v16

    invoke-virtual {v1, v12, v13, v14, v15}, Landroid/view/View;->layout(IIII)V

    .line 645
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->invalidate()V

    .line 712
    :goto_1
    return-void

    .line 634
    :cond_0
    const/16 v12, -0x2712

    move/from16 v0, p1

    if-ne v0, v12, :cond_1

    .line 635
    const/high16 v7, 0x3f800000    # 1.0f

    goto :goto_0

    .line 637
    :cond_1
    invoke-virtual {v5}, Landroid/view/View;->getTop()I

    move-result v12

    int-to-float v12, v12

    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->getHeight()I

    move-result v13

    move-object/from16 v0, p0

    iget v14, v0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mTopOffset:I

    sub-int/2addr v13, v14

    move-object/from16 v0, p0

    iget v14, v0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mBottomOffset:I

    add-int/2addr v13, v14

    invoke-virtual {v5}, Landroid/view/View;->getHeight()I

    move-result v14

    sub-int/2addr v13, v14

    int-to-float v13, v13

    div-float v7, v12, v13

    goto :goto_0

    .line 646
    :cond_2
    const/16 v12, -0x2712

    move/from16 v0, p1

    if-ne v0, v12, :cond_3

    .line 647
    move-object/from16 v0, p0

    iget v12, v0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mBottomOffset:I

    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->getBottom()I

    move-result v13

    add-int/2addr v12, v13

    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->getTop()I

    move-result v13

    sub-int/2addr v12, v13

    invoke-virtual {v5}, Landroid/view/View;->getHeight()I

    move-result v13

    sub-int/2addr v12, v13

    invoke-virtual {v5}, Landroid/view/View;->getTop()I

    move-result v13

    sub-int/2addr v12, v13

    invoke-virtual {v5, v12}, Landroid/view/View;->offsetTopAndBottom(I)V

    .line 649
    const/4 v12, 0x0

    invoke-virtual {v5}, Landroid/view/View;->getBottom()I

    move-result v13

    invoke-virtual {v1}, Landroid/view/View;->getMeasuredWidth()I

    move-result v14

    invoke-virtual {v5}, Landroid/view/View;->getBottom()I

    move-result v15

    invoke-virtual {v1}, Landroid/view/View;->getMeasuredHeight()I

    move-result v16

    add-int v15, v15, v16

    invoke-virtual {v1, v12, v13, v14, v15}, Landroid/view/View;->layout(IIII)V

    .line 650
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->invalidate()V

    goto :goto_1

    .line 652
    :cond_3
    invoke-virtual {v5}, Landroid/view/View;->getTop()I

    move-result v10

    .line 653
    .local v10, "top":I
    sub-int v3, p1, v10

    .line 654
    .local v3, "deltaY":I
    move-object/from16 v0, p0

    iget v12, v0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mTopOffset:I

    move/from16 v0, p1

    if-ge v0, v12, :cond_5

    .line 655
    move-object/from16 v0, p0

    iget v12, v0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mTopOffset:I

    sub-int v3, v12, v10

    .line 659
    :cond_4
    :goto_2
    invoke-virtual {v5, v3}, Landroid/view/View;->offsetTopAndBottom(I)V

    .line 661
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->getBottom()I

    move-result v12

    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mHandle:Landroid/view/View;

    invoke-virtual {v13}, Landroid/view/View;->getBottom()I

    move-result v13

    sub-int v6, v12, v13

    .line 662
    .local v6, "height":I
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->getRight()I

    move-result v12

    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->getLeft()I

    move-result v13

    sub-int/2addr v12, v13

    const/high16 v13, 0x40000000    # 2.0f

    invoke-static {v12, v13}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v12

    const/high16 v13, 0x40000000    # 2.0f

    invoke-static {v6, v13}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v13

    invoke-virtual {v1, v12, v13}, Landroid/view/View;->measure(II)V

    .line 664
    const/4 v12, 0x0

    invoke-virtual {v5}, Landroid/view/View;->getBottom()I

    move-result v13

    invoke-virtual {v1}, Landroid/view/View;->getMeasuredWidth()I

    move-result v14

    invoke-virtual {v5}, Landroid/view/View;->getBottom()I

    move-result v15

    invoke-virtual {v1}, Landroid/view/View;->getMeasuredHeight()I

    move-result v16

    add-int v15, v15, v16

    invoke-virtual {v1, v12, v13, v14, v15}, Landroid/view/View;->layout(IIII)V

    .line 666
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mFrame:Landroid/graphics/Rect;

    .line 667
    .local v4, "frame":Landroid/graphics/Rect;
    move-object/from16 v0, p0

    iget-object v8, v0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mInvalidate:Landroid/graphics/Rect;

    .line 669
    .local v8, "region":Landroid/graphics/Rect;
    invoke-virtual {v5, v4}, Landroid/view/View;->getHitRect(Landroid/graphics/Rect;)V

    .line 670
    invoke-virtual {v8, v4}, Landroid/graphics/Rect;->set(Landroid/graphics/Rect;)V

    .line 672
    iget v12, v4, Landroid/graphics/Rect;->left:I

    iget v13, v4, Landroid/graphics/Rect;->top:I

    sub-int/2addr v13, v3

    iget v14, v4, Landroid/graphics/Rect;->right:I

    iget v15, v4, Landroid/graphics/Rect;->bottom:I

    sub-int/2addr v15, v3

    invoke-virtual {v8, v12, v13, v14, v15}, Landroid/graphics/Rect;->union(IIII)V

    .line 673
    const/4 v12, 0x0

    iget v13, v4, Landroid/graphics/Rect;->bottom:I

    sub-int/2addr v13, v3

    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->getWidth()I

    move-result v14

    iget v15, v4, Landroid/graphics/Rect;->bottom:I

    sub-int/2addr v15, v3

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mContent:Landroid/view/View;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Landroid/view/View;->getHeight()I

    move-result v16

    add-int v15, v15, v16

    invoke-virtual {v8, v12, v13, v14, v15}, Landroid/graphics/Rect;->union(IIII)V

    .line 675
    move-object/from16 v0, p0

    invoke-virtual {v0, v8}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->invalidate(Landroid/graphics/Rect;)V

    goto/16 :goto_1

    .line 656
    .end local v4    # "frame":Landroid/graphics/Rect;
    .end local v6    # "height":I
    .end local v8    # "region":Landroid/graphics/Rect;
    :cond_5
    move-object/from16 v0, p0

    iget v12, v0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mBottomOffset:I

    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->getBottom()I

    move-result v13

    add-int/2addr v12, v13

    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->getTop()I

    move-result v13

    sub-int/2addr v12, v13

    invoke-virtual {v5}, Landroid/view/View;->getHeight()I

    move-result v13

    sub-int/2addr v12, v13

    sub-int/2addr v12, v10

    if-le v3, v12, :cond_4

    .line 657
    move-object/from16 v0, p0

    iget v12, v0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mBottomOffset:I

    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->getBottom()I

    move-result v13

    add-int/2addr v12, v13

    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->getTop()I

    move-result v13

    sub-int/2addr v12, v13

    invoke-virtual {v5}, Landroid/view/View;->getHeight()I

    move-result v13

    sub-int/2addr v12, v13

    sub-int v3, v12, v10

    goto/16 :goto_2

    .line 678
    .end local v3    # "deltaY":I
    .end local v10    # "top":I
    :cond_6
    const/16 v12, -0x2711

    move/from16 v0, p1

    if-ne v0, v12, :cond_7

    .line 679
    move-object/from16 v0, p0

    iget v12, v0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mTopOffset:I

    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->getRight()I

    move-result v13

    add-int/2addr v12, v13

    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->getLeft()I

    move-result v13

    sub-int/2addr v12, v13

    invoke-virtual {v5}, Landroid/view/View;->getRight()I

    move-result v13

    sub-int/2addr v12, v13

    invoke-virtual {v5, v12}, Landroid/view/View;->offsetLeftAndRight(I)V

    .line 680
    invoke-virtual {v5}, Landroid/view/View;->getRight()I

    move-result v12

    const/4 v13, 0x0

    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->getWidth()I

    move-result v14

    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->getHeight()I

    move-result v15

    invoke-virtual {v1, v12, v13, v14, v15}, Landroid/view/View;->layout(IIII)V

    .line 681
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->invalidate()V

    goto/16 :goto_1

    .line 682
    :cond_7
    const/16 v12, -0x2712

    move/from16 v0, p1

    if-ne v0, v12, :cond_8

    .line 683
    move-object/from16 v0, p0

    iget v12, v0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mBottomOffset:I

    invoke-virtual {v5}, Landroid/view/View;->getWidth()I

    move-result v13

    add-int/2addr v12, v13

    invoke-virtual {v5}, Landroid/view/View;->getRight()I

    move-result v13

    sub-int/2addr v12, v13

    invoke-virtual {v5, v12}, Landroid/view/View;->offsetLeftAndRight(I)V

    .line 684
    invoke-virtual {v5}, Landroid/view/View;->getRight()I

    move-result v12

    const/4 v13, 0x0

    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->getWidth()I

    move-result v14

    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->getHeight()I

    move-result v15

    invoke-virtual {v1, v12, v13, v14, v15}, Landroid/view/View;->layout(IIII)V

    .line 685
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->invalidate()V

    goto/16 :goto_1

    .line 687
    :cond_8
    invoke-virtual {v5}, Landroid/view/View;->getRight()I

    move-result v9

    .line 688
    .local v9, "right":I
    sub-int v2, p1, v9

    .line 689
    .local v2, "deltaX":I
    move-object/from16 v0, p0

    iget v12, v0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mBottomOffset:I

    invoke-virtual {v5}, Landroid/view/View;->getWidth()I

    move-result v13

    add-int/2addr v12, v13

    move/from16 v0, p1

    if-ge v0, v12, :cond_a

    .line 690
    move-object/from16 v0, p0

    iget v12, v0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mBottomOffset:I

    invoke-virtual {v5}, Landroid/view/View;->getWidth()I

    move-result v13

    add-int/2addr v12, v13

    sub-int v2, v12, v9

    .line 694
    :cond_9
    :goto_3
    invoke-virtual {v5, v2}, Landroid/view/View;->offsetLeftAndRight(I)V

    .line 696
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->getRight()I

    move-result v12

    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mHandle:Landroid/view/View;

    invoke-virtual {v13}, Landroid/view/View;->getRight()I

    move-result v13

    sub-int v11, v12, v13

    .line 697
    .local v11, "width":I
    const/high16 v12, 0x40000000    # 2.0f

    invoke-static {v11, v12}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v12

    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->getBottom()I

    move-result v13

    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->getTop()I

    move-result v14

    sub-int/2addr v13, v14

    const/high16 v14, 0x40000000    # 2.0f

    invoke-static {v13, v14}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v13

    invoke-virtual {v1, v12, v13}, Landroid/view/View;->measure(II)V

    .line 699
    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mHandle:Landroid/view/View;

    invoke-virtual {v12}, Landroid/view/View;->getRight()I

    move-result v12

    const/4 v13, 0x0

    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->getWidth()I

    move-result v14

    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->getHeight()I

    move-result v15

    invoke-virtual {v1, v12, v13, v14, v15}, Landroid/view/View;->layout(IIII)V

    .line 701
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mFrame:Landroid/graphics/Rect;

    .line 702
    .restart local v4    # "frame":Landroid/graphics/Rect;
    move-object/from16 v0, p0

    iget-object v8, v0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mInvalidate:Landroid/graphics/Rect;

    .line 704
    .restart local v8    # "region":Landroid/graphics/Rect;
    invoke-virtual {v5, v4}, Landroid/view/View;->getHitRect(Landroid/graphics/Rect;)V

    .line 705
    invoke-virtual {v8, v4}, Landroid/graphics/Rect;->set(Landroid/graphics/Rect;)V

    .line 707
    iget v12, v4, Landroid/graphics/Rect;->left:I

    sub-int/2addr v12, v2

    iget v13, v4, Landroid/graphics/Rect;->top:I

    iget v14, v4, Landroid/graphics/Rect;->right:I

    sub-int/2addr v14, v2

    iget v15, v4, Landroid/graphics/Rect;->bottom:I

    invoke-virtual {v8, v12, v13, v14, v15}, Landroid/graphics/Rect;->union(IIII)V

    .line 709
    move-object/from16 v0, p0

    invoke-virtual {v0, v8}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->invalidate(Landroid/graphics/Rect;)V

    goto/16 :goto_1

    .line 691
    .end local v4    # "frame":Landroid/graphics/Rect;
    .end local v8    # "region":Landroid/graphics/Rect;
    .end local v11    # "width":I
    :cond_a
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->getRight()I

    move-result v12

    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->getLeft()I

    move-result v13

    sub-int/2addr v12, v13

    move-object/from16 v0, p0

    iget v13, v0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mTopOffset:I

    add-int/2addr v12, v13

    move/from16 v0, p1

    if-le v0, v12, :cond_9

    .line 692
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->getRight()I

    move-result v12

    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->getLeft()I

    move-result v13

    sub-int/2addr v12, v13

    move-object/from16 v0, p0

    iget v13, v0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mTopOffset:I

    add-int/2addr v12, v13

    sub-int v2, v12, v9

    goto/16 :goto_3
.end method

.method private openDrawer()V
    .locals 2

    .prologue
    .line 847
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mExpanded:Z

    .line 848
    const/16 v0, -0x2711

    invoke-direct {p0, v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->moveHandle(I)V

    .line 849
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mContent:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 851
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mOnDrawerOpenListener:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer$OnDrawerOpenListener;

    if-eqz v0, :cond_0

    .line 852
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mOnDrawerOpenListener:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer$OnDrawerOpenListener;

    invoke-interface {v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer$OnDrawerOpenListener;->onDrawerOpened()V

    .line 854
    :cond_0
    return-void
.end method

.method private performFling(IFZ)V
    .locals 6
    .param p1, "position"    # I
    .param p2, "velocity"    # F
    .param p3, "always"    # Z

    .prologue
    const/16 v4, 0x3e8

    const/4 v3, 0x0

    .line 518
    int-to-float v2, p1

    iput v2, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mAnimationPosition:F

    .line 519
    iput p2, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mAnimatedVelocity:F

    .line 521
    iget-boolean v2, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mExpanded:Z

    if-eqz v2, :cond_6

    .line 522
    iget-boolean v2, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mVertical:Z

    if-eqz v2, :cond_3

    .line 523
    if-nez p3, :cond_0

    iget v2, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mMaximumMajorVelocity:I

    int-to-float v2, v2

    cmpl-float v2, p2, v2

    if-gtz v2, :cond_0

    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->getHeight()I

    move-result v2

    div-int/lit8 v2, v2, 0x2

    if-le p1, v2, :cond_2

    iget v2, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mMaximumMajorVelocity:I

    neg-int v2, v2

    int-to-float v2, v2

    cmpl-float v2, p2, v2

    if-lez v2, :cond_2

    .line 526
    :cond_0
    iget v2, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mMaximumAcceleration:I

    int-to-float v2, v2

    iput v2, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mAnimatedAcceleration:F

    .line 527
    cmpg-float v2, p2, v3

    if-gez v2, :cond_1

    .line 528
    iput v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mAnimatedVelocity:F

    .line 591
    :cond_1
    :goto_0
    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v0

    .line 592
    .local v0, "now":J
    iput-wide v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mAnimationLastTime:J

    .line 593
    const-wide/16 v2, 0x10

    add-long/2addr v2, v0

    iput-wide v2, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mCurrentAnimationTime:J

    .line 594
    const/4 v2, 0x1

    iput-boolean v2, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mAnimating:Z

    .line 595
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mHandler:Landroid/os/Handler;

    invoke-virtual {v2, v4}, Landroid/os/Handler;->removeMessages(I)V

    .line 596
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mHandler:Landroid/os/Handler;

    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mHandler:Landroid/os/Handler;

    invoke-virtual {v3, v4}, Landroid/os/Handler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v3

    iget-wide v4, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mCurrentAnimationTime:J

    invoke-virtual {v2, v3, v4, v5}, Landroid/os/Handler;->sendMessageAtTime(Landroid/os/Message;J)Z

    .line 597
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->stopTracking()V

    .line 598
    return-void

    .line 533
    .end local v0    # "now":J
    :cond_2
    iget v2, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mMaximumAcceleration:I

    neg-int v2, v2

    int-to-float v2, v2

    iput v2, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mAnimatedAcceleration:F

    .line 534
    cmpl-float v2, p2, v3

    if-lez v2, :cond_1

    .line 535
    iput v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mAnimatedVelocity:F

    goto :goto_0

    .line 539
    :cond_3
    if-nez p3, :cond_4

    iget v2, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mMaximumMajorVelocity:I

    neg-int v2, v2

    int-to-float v2, v2

    cmpg-float v2, p2, v2

    if-ltz v2, :cond_4

    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->getWidth()I

    move-result v2

    div-int/lit8 v2, v2, 0x2

    if-ge p1, v2, :cond_5

    iget v2, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mMaximumMajorVelocity:I

    int-to-float v2, v2

    cmpg-float v2, p2, v2

    if-gez v2, :cond_5

    .line 542
    :cond_4
    iget v2, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mMaximumAcceleration:I

    neg-int v2, v2

    int-to-float v2, v2

    iput v2, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mAnimatedAcceleration:F

    .line 543
    cmpl-float v2, p2, v3

    if-lez v2, :cond_1

    .line 544
    iput v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mAnimatedVelocity:F

    goto :goto_0

    .line 549
    :cond_5
    iget v2, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mMaximumAcceleration:I

    int-to-float v2, v2

    iput v2, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mAnimatedAcceleration:F

    .line 550
    cmpg-float v2, p2, v3

    if-gez v2, :cond_1

    .line 551
    iput v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mAnimatedVelocity:F

    goto :goto_0

    .line 556
    :cond_6
    iget-boolean v2, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mVertical:Z

    if-eqz v2, :cond_9

    .line 557
    if-nez p3, :cond_8

    iget v2, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mMaximumMajorVelocity:I

    int-to-float v2, v2

    cmpl-float v2, p2, v2

    if-gtz v2, :cond_7

    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->getHeight()I

    move-result v2

    div-int/lit8 v2, v2, 0x2

    if-le p1, v2, :cond_8

    iget v2, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mMaximumMajorVelocity:I

    neg-int v2, v2

    int-to-float v2, v2

    cmpl-float v2, p2, v2

    if-lez v2, :cond_8

    .line 561
    :cond_7
    iget v2, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mMaximumAcceleration:I

    int-to-float v2, v2

    iput v2, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mAnimatedAcceleration:F

    .line 562
    cmpg-float v2, p2, v3

    if-gez v2, :cond_1

    .line 563
    iput v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mAnimatedVelocity:F

    goto/16 :goto_0

    .line 567
    :cond_8
    iget v2, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mMaximumAcceleration:I

    neg-int v2, v2

    int-to-float v2, v2

    iput v2, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mAnimatedAcceleration:F

    .line 568
    cmpl-float v2, p2, v3

    if-lez v2, :cond_1

    .line 569
    iput v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mAnimatedVelocity:F

    goto/16 :goto_0

    .line 573
    :cond_9
    if-nez p3, :cond_b

    iget v2, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mMaximumMajorVelocity:I

    neg-int v2, v2

    int-to-float v2, v2

    cmpg-float v2, p2, v2

    if-ltz v2, :cond_a

    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->getWidth()I

    move-result v2

    div-int/lit8 v2, v2, 0x2

    if-ge p1, v2, :cond_b

    iget v2, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mMaximumMajorVelocity:I

    int-to-float v2, v2

    cmpg-float v2, p2, v2

    if-gez v2, :cond_b

    .line 577
    :cond_a
    iget v2, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mMaximumAcceleration:I

    neg-int v2, v2

    int-to-float v2, v2

    iput v2, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mAnimatedAcceleration:F

    .line 578
    cmpl-float v2, p2, v3

    if-lez v2, :cond_1

    .line 579
    iput v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mAnimatedVelocity:F

    goto/16 :goto_0

    .line 583
    :cond_b
    iget v2, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mMaximumAcceleration:I

    int-to-float v2, v2

    iput v2, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mAnimatedAcceleration:F

    .line 584
    cmpg-float v2, p2, v3

    if-gez v2, :cond_1

    .line 585
    iput v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mAnimatedVelocity:F

    goto/16 :goto_0
.end method

.method private prepareTracking(I)V
    .locals 7
    .param p1, "position"    # I

    .prologue
    const/16 v6, 0x3e8

    const/4 v3, 0x0

    const/4 v4, 0x1

    .line 601
    iput-boolean v4, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mTracking:Z

    .line 602
    invoke-static {}, Landroid/view/VelocityTracker;->obtain()Landroid/view/VelocityTracker;

    move-result-object v5

    iput-object v5, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mVelocityTracker:Landroid/view/VelocityTracker;

    .line 603
    iget-boolean v5, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mExpanded:Z

    if-nez v5, :cond_2

    move v2, v4

    .line 604
    .local v2, "opening":Z
    :goto_0
    if-eqz v2, :cond_5

    .line 605
    iget v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mMaximumAcceleration:I

    int-to-float v3, v3

    iput v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mAnimatedAcceleration:F

    .line 606
    iget v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mMaximumMajorVelocity:I

    int-to-float v3, v3

    iput v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mAnimatedVelocity:F

    .line 607
    iget-boolean v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mVertical:Z

    if-eqz v3, :cond_3

    iget v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mBottomOffset:I

    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->getHeight()I

    move-result v5

    add-int/2addr v3, v5

    iget-object v5, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mHandle:Landroid/view/View;

    invoke-virtual {v5}, Landroid/view/View;->getHeight()I

    move-result v5

    sub-int/2addr v3, v5

    :goto_1
    int-to-float v3, v3

    iput v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mAnimationPosition:F

    .line 608
    iget v5, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mAnimationPosition:F

    iget-boolean v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mVertical:Z

    if-eqz v3, :cond_4

    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mHandle:Landroid/view/View;

    invoke-virtual {v3}, Landroid/view/View;->getTop()I

    move-result v3

    :goto_2
    int-to-float v3, v3

    cmpl-float v3, v5, v3

    if-eqz v3, :cond_0

    .line 609
    iget v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mAnimationPosition:F

    float-to-int v3, v3

    invoke-direct {p0, v3}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->moveHandle(I)V

    .line 611
    :cond_0
    iput-boolean v4, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mAnimating:Z

    .line 612
    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mHandler:Landroid/os/Handler;

    invoke-virtual {v3, v6}, Landroid/os/Handler;->removeMessages(I)V

    .line 613
    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v0

    .line 614
    .local v0, "now":J
    iput-wide v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mAnimationLastTime:J

    .line 615
    const-wide/16 v5, 0x10

    add-long/2addr v5, v0

    iput-wide v5, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mCurrentAnimationTime:J

    .line 616
    iput-boolean v4, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mAnimating:Z

    .line 626
    .end local v0    # "now":J
    :cond_1
    :goto_3
    return-void

    .end local v2    # "opening":Z
    :cond_2
    move v2, v3

    .line 603
    goto :goto_0

    .line 607
    .restart local v2    # "opening":Z
    :cond_3
    iget v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mBottomOffset:I

    iget-object v5, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mHandle:Landroid/view/View;

    invoke-virtual {v5}, Landroid/view/View;->getWidth()I

    move-result v5

    add-int/2addr v3, v5

    goto :goto_1

    .line 608
    :cond_4
    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mHandle:Landroid/view/View;

    invoke-virtual {v3}, Landroid/view/View;->getRight()I

    move-result v3

    goto :goto_2

    .line 618
    :cond_5
    iget-boolean v4, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mAnimating:Z

    if-eqz v4, :cond_6

    .line 619
    iput-boolean v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mAnimating:Z

    .line 620
    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mHandler:Landroid/os/Handler;

    invoke-virtual {v3, v6}, Landroid/os/Handler;->removeMessages(I)V

    .line 622
    :cond_6
    iget-boolean v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mVertical:Z

    if-eqz v3, :cond_7

    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mHandle:Landroid/view/View;

    invoke-virtual {v3}, Landroid/view/View;->getTop()I

    move-result v3

    :goto_4
    if-eq p1, v3, :cond_1

    .line 623
    invoke-direct {p0, p1}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->moveHandle(I)V

    goto :goto_3

    .line 622
    :cond_7
    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mHandle:Landroid/view/View;

    invoke-virtual {v3}, Landroid/view/View;->getRight()I

    move-result v3

    goto :goto_4
.end method

.method private stopTracking()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 748
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mHandle:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setPressed(Z)V

    .line 749
    iput-boolean v1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mTracking:Z

    .line 751
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mOnDrawerScrollListener:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer$OnDrawerScrollListener;

    if-eqz v0, :cond_0

    .line 752
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mOnDrawerScrollListener:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer$OnDrawerScrollListener;

    invoke-interface {v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer$OnDrawerScrollListener;->onScrollEnded()V

    .line 755
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mVelocityTracker:Landroid/view/VelocityTracker;

    if-eqz v0, :cond_1

    .line 756
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mVelocityTracker:Landroid/view/VelocityTracker;

    invoke-virtual {v0}, Landroid/view/VelocityTracker;->recycle()V

    .line 757
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mVelocityTracker:Landroid/view/VelocityTracker;

    .line 759
    :cond_1
    return-void
.end method


# virtual methods
.method public animateClose()V
    .locals 2

    .prologue
    .line 902
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mTracking:Z

    .line 903
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->prepareContent()V

    .line 904
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mOnDrawerScrollListener:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer$OnDrawerScrollListener;

    .line 905
    .local v0, "scrollListener":Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer$OnDrawerScrollListener;
    if-eqz v0, :cond_0

    .line 906
    invoke-interface {v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer$OnDrawerScrollListener;->onScrollStarted()V

    .line 908
    :cond_0
    iget-boolean v1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mVertical:Z

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mHandle:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getTop()I

    move-result v1

    :goto_0
    invoke-direct {p0, v1}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->animateClose(I)V

    .line 910
    if-eqz v0, :cond_1

    .line 911
    invoke-interface {v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer$OnDrawerScrollListener;->onScrollEnded()V

    .line 913
    :cond_1
    return-void

    .line 908
    :cond_2
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mHandle:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getRight()I

    move-result v1

    goto :goto_0
.end method

.method public animateOpen()V
    .locals 2

    .prologue
    .line 925
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mTracking:Z

    .line 926
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->prepareContent()V

    .line 927
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mOnDrawerScrollListener:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer$OnDrawerScrollListener;

    .line 928
    .local v0, "scrollListener":Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer$OnDrawerScrollListener;
    if-eqz v0, :cond_0

    .line 929
    invoke-interface {v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer$OnDrawerScrollListener;->onScrollStarted()V

    .line 931
    :cond_0
    iget-boolean v1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mVertical:Z

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mHandle:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getTop()I

    move-result v1

    :goto_0
    invoke-direct {p0, v1}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->animateOpen(I)V

    .line 933
    const/16 v1, 0x20

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->sendAccessibilityEvent(I)V

    .line 935
    if-eqz v0, :cond_1

    .line 936
    invoke-interface {v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer$OnDrawerScrollListener;->onScrollEnded()V

    .line 938
    :cond_1
    return-void

    .line 931
    :cond_2
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mHandle:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getRight()I

    move-result v1

    goto :goto_0
.end method

.method public animateToggle()V
    .locals 1

    .prologue
    .line 885
    iget-boolean v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mExpanded:Z

    if-nez v0, :cond_0

    .line 886
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->animateOpen()V

    .line 890
    :goto_0
    return-void

    .line 888
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->animateClose()V

    goto :goto_0
.end method

.method public close()V
    .locals 0

    .prologue
    .line 826
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->closeDrawer()V

    .line 827
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->invalidate()V

    .line 828
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->requestLayout()V

    .line 829
    return-void
.end method

.method protected dispatchDraw(Landroid/graphics/Canvas;)V
    .locals 5
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 278
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->getDrawingTime()J

    move-result-wide v0

    .line 279
    .local v0, "drawingTime":J
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mHandle:Landroid/view/View;

    .line 281
    .local v2, "handle":Landroid/view/View;
    invoke-virtual {p0, p1, v2, v0, v1}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->drawChild(Landroid/graphics/Canvas;Landroid/view/View;J)Z

    .line 283
    iget-boolean v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mTracking:Z

    if-nez v3, :cond_0

    iget-boolean v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mAnimating:Z

    if-eqz v3, :cond_1

    .line 285
    :cond_0
    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mContent:Landroid/view/View;

    invoke-virtual {p0, p1, v3, v0, v1}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->drawChild(Landroid/graphics/Canvas;Landroid/view/View;J)Z

    .line 297
    :goto_0
    return-void

    .line 286
    :cond_1
    iget-boolean v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mExpanded:Z

    if-eqz v3, :cond_2

    .line 287
    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mContent:Landroid/view/View;

    invoke-virtual {p0, p1, v3, v0, v1}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->drawChild(Landroid/graphics/Canvas;Landroid/view/View;J)Z

    goto :goto_0

    .line 289
    :cond_2
    iget-boolean v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mShowContentAfterClose:Z

    if-eqz v3, :cond_3

    iget v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mBottomOffset:I

    int-to-float v3, v3

    const/4 v4, 0x0

    cmpl-float v3, v3, v4

    if-eqz v3, :cond_3

    .line 290
    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mContent:Landroid/view/View;

    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Landroid/view/View;->setVisibility(I)V

    .line 292
    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mContent:Landroid/view/View;

    invoke-virtual {p0, p1, v3, v0, v1}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->drawChild(Landroid/graphics/Canvas;Landroid/view/View;J)Z

    goto :goto_0

    .line 294
    :cond_3
    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mContent:Landroid/view/View;

    const/16 v4, 0x8

    invoke-virtual {v3, v4}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0
.end method

.method public dispatchTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 368
    iget-boolean v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mRequestInterceptTouchEvent:Z

    if-eqz v0, :cond_1

    .line 369
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mRequestInterceptTouchEvent:Z

    .line 370
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->onInterceptTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 371
    const/4 v0, 0x3

    invoke-virtual {p1, v0}, Landroid/view/MotionEvent;->setAction(I)V

    .line 373
    :cond_0
    invoke-super {p0, p1}, Landroid/view/ViewGroup;->dispatchTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    .line 376
    :goto_0
    return v0

    :cond_1
    invoke-super {p0, p1}, Landroid/view/ViewGroup;->dispatchTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    goto :goto_0
.end method

.method public getContent()Landroid/view/View;
    .locals 1

    .prologue
    .line 997
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mContent:Landroid/view/View;

    return-object v0
.end method

.method public getHandle()Landroid/view/View;
    .locals 1

    .prologue
    .line 987
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mHandle:Landroid/view/View;

    return-object v0
.end method

.method public isClosed()Z
    .locals 1

    .prologue
    .line 1042
    iget-boolean v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mExpanded:Z

    if-nez v0, :cond_0

    iget-boolean v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mTracking:Z

    if-nez v0, :cond_0

    iget-boolean v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mAnimating:Z

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isMoving()Z
    .locals 1

    .prologue
    .line 1033
    iget-boolean v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mTracking:Z

    if-nez v0, :cond_0

    iget-boolean v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mAnimating:Z

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isOpened()Z
    .locals 1

    .prologue
    .line 1024
    iget-boolean v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mExpanded:Z

    return v0
.end method

.method protected isScrolledToTop()Z
    .locals 1

    .prologue
    .line 145
    const/4 v0, 0x0

    return v0
.end method

.method protected onFinishInflate()V
    .locals 3

    .prologue
    .line 257
    iget v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mHandleId:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mHandle:Landroid/view/View;

    .line 258
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mHandle:Landroid/view/View;

    if-nez v0, :cond_0

    .line 259
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "The handle attribute is must refer to an existing child."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 265
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mHandle:Landroid/view/View;

    new-instance v1, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer$DrawerToggler;

    const/4 v2, 0x0

    invoke-direct {v1, p0, v2}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer$DrawerToggler;-><init>(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer$1;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 267
    iget v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mContentId:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mContent:Landroid/view/View;

    .line 268
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mContent:Landroid/view/View;

    if-nez v0, :cond_1

    .line 269
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "The content attribute is must refer to an existing child."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 273
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mContent:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 274
    return-void
.end method

.method public onInterceptTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 12
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 384
    iget-boolean v10, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mLocked:Z

    if-eqz v10, :cond_0

    .line 385
    const/4 v10, 0x0

    .line 453
    :goto_0
    return v10

    .line 388
    :cond_0
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    .line 390
    .local v0, "action":I
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v8

    .line 391
    .local v8, "x":F
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    .line 392
    .local v9, "y":F
    const/4 v3, 0x0

    .line 393
    .local v3, "isMoveDown":Z
    const/4 v4, 0x0

    .line 394
    .local v4, "isMoveUp":Z
    if-nez v0, :cond_1

    .line 395
    iput v9, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mLastMotionPositionY:F

    .line 397
    :cond_1
    const/4 v10, 0x2

    if-ne v0, v10, :cond_3

    .line 398
    iget v10, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mLastMotionPositionY:F

    sub-float v10, v9, v10

    iget v11, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mActionMoveThreshold:F

    cmpl-float v10, v10, v11

    if-lez v10, :cond_5

    const/4 v3, 0x1

    .line 399
    :goto_1
    iget v10, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mLastMotionPositionY:F

    sub-float/2addr v10, v9

    iget v11, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mActionMoveThreshold:F

    cmpl-float v10, v10, v11

    if-lez v10, :cond_6

    const/4 v4, 0x1

    .line 400
    :goto_2
    if-nez v3, :cond_2

    if-eqz v4, :cond_3

    .line 401
    :cond_2
    iput v9, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mLastMotionPositionY:F

    .line 405
    :cond_3
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mFrame:Landroid/graphics/Rect;

    .line 406
    .local v1, "frame":Landroid/graphics/Rect;
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mHandle:Landroid/view/View;

    .line 407
    .local v2, "handle":Landroid/view/View;
    invoke-virtual {v2, v1}, Landroid/view/View;->getHitRect(Landroid/graphics/Rect;)V

    .line 409
    const/4 v6, 0x0

    .line 410
    .local v6, "shouldInterceptTouchEvent":Z
    iget-boolean v10, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mTracking:Z

    if-nez v10, :cond_4

    iget-boolean v10, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mAnimating:Z

    if-eqz v10, :cond_7

    .line 411
    :cond_4
    const/4 v10, 0x0

    goto :goto_0

    .line 398
    .end local v1    # "frame":Landroid/graphics/Rect;
    .end local v2    # "handle":Landroid/view/View;
    .end local v6    # "shouldInterceptTouchEvent":Z
    :cond_5
    const/4 v3, 0x0

    goto :goto_1

    .line 399
    :cond_6
    const/4 v4, 0x0

    goto :goto_2

    .line 412
    .restart local v1    # "frame":Landroid/graphics/Rect;
    .restart local v2    # "handle":Landroid/view/View;
    .restart local v6    # "shouldInterceptTouchEvent":Z
    :cond_7
    float-to-int v10, v8

    float-to-int v11, v9

    invoke-virtual {v1, v10, v11}, Landroid/graphics/Rect;->contains(II)Z

    move-result v10

    if-nez v10, :cond_c

    .line 413
    const/4 v10, 0x2

    if-ne v0, v10, :cond_8

    .line 414
    iget-boolean v10, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mExpanded:Z

    if-eqz v10, :cond_b

    .line 415
    if-eqz v3, :cond_8

    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->isScrolledToTop()Z

    move-result v10

    if-eqz v10, :cond_8

    .line 416
    const/4 v6, 0x1

    .line 426
    :cond_8
    :goto_3
    if-eqz v0, :cond_9

    const/4 v10, 0x2

    if-ne v0, v10, :cond_e

    :cond_9
    if-eqz v6, :cond_e

    .line 427
    const/4 v10, 0x1

    iput-boolean v10, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mTracking:Z

    .line 429
    const/4 v10, 0x1

    invoke-virtual {v2, v10}, Landroid/view/View;->setPressed(Z)V

    .line 431
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->prepareContent()V

    .line 434
    iget-object v10, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mOnDrawerScrollListener:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer$OnDrawerScrollListener;

    if-eqz v10, :cond_a

    .line 435
    iget-object v10, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mOnDrawerScrollListener:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer$OnDrawerScrollListener;

    invoke-interface {v10}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer$OnDrawerScrollListener;->onScrollStarted()V

    .line 438
    :cond_a
    iget-boolean v10, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mVertical:Z

    if-eqz v10, :cond_d

    .line 439
    iget-object v10, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mHandle:Landroid/view/View;

    invoke-virtual {v10}, Landroid/view/View;->getTop()I

    move-result v7

    .line 440
    .local v7, "top":I
    float-to-int v10, v9

    sub-int/2addr v10, v7

    iput v10, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mTouchDelta:I

    .line 441
    invoke-direct {p0, v7}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->prepareTracking(I)V

    .line 447
    .end local v7    # "top":I
    :goto_4
    iget-object v10, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mVelocityTracker:Landroid/view/VelocityTracker;

    invoke-virtual {v10, p1}, Landroid/view/VelocityTracker;->addMovement(Landroid/view/MotionEvent;)V

    .line 449
    const/4 v10, 0x1

    goto/16 :goto_0

    .line 418
    :cond_b
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->isMoving()Z

    move-result v10

    if-nez v10, :cond_8

    if-eqz v4, :cond_8

    .line 419
    const/4 v6, 0x1

    goto :goto_3

    .line 423
    :cond_c
    const/4 v6, 0x1

    goto :goto_3

    .line 443
    :cond_d
    iget-object v10, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mHandle:Landroid/view/View;

    invoke-virtual {v10}, Landroid/view/View;->getRight()I

    move-result v5

    .line 444
    .local v5, "right":I
    float-to-int v10, v8

    sub-int/2addr v10, v5

    iput v10, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mTouchDelta:I

    .line 445
    invoke-direct {p0, v5}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->prepareTracking(I)V

    goto :goto_4

    .line 453
    .end local v5    # "right":I
    :cond_e
    invoke-super {p0, p1}, Landroid/view/ViewGroup;->onInterceptTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v10

    goto/16 :goto_0
.end method

.method protected onLayout(ZIIII)V
    .locals 13
    .param p1, "changed"    # Z
    .param p2, "l"    # I
    .param p3, "t"    # I
    .param p4, "r"    # I
    .param p5, "b"    # I

    .prologue
    .line 335
    iget-boolean v8, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mTracking:Z

    if-eqz v8, :cond_0

    .line 364
    :goto_0
    return-void

    .line 339
    :cond_0
    sub-int v7, p4, p2

    .line 340
    .local v7, "width":I
    sub-int v6, p5, p3

    .line 342
    .local v6, "height":I
    iget-object v5, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mHandle:Landroid/view/View;

    .line 344
    .local v5, "handle":Landroid/view/View;
    invoke-virtual {v5}, Landroid/view/View;->getMeasuredWidth()I

    move-result v3

    .line 345
    .local v3, "childWidth":I
    invoke-virtual {v5}, Landroid/view/View;->getMeasuredHeight()I

    move-result v0

    .line 350
    .local v0, "childHeight":I
    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mContent:Landroid/view/View;

    .line 352
    .local v4, "content":Landroid/view/View;
    iget-boolean v8, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mVertical:Z

    if-eqz v8, :cond_2

    .line 353
    sub-int v8, v7, v3

    div-int/lit8 v1, v8, 0x2

    .line 354
    .local v1, "childLeft":I
    iget-boolean v8, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mExpanded:Z

    if-eqz v8, :cond_1

    iget v2, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mTopOffset:I

    .line 355
    .local v2, "childTop":I
    :goto_1
    const/4 v8, 0x0

    add-int v9, v2, v0

    invoke-virtual {v4}, Landroid/view/View;->getMeasuredWidth()I

    move-result v10

    iget v11, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mTopOffset:I

    add-int/2addr v11, v0

    invoke-virtual {v4}, Landroid/view/View;->getMeasuredHeight()I

    move-result v12

    add-int/2addr v11, v12

    invoke-virtual {v4, v8, v9, v10, v11}, Landroid/view/View;->layout(IIII)V

    .line 363
    :goto_2
    add-int v8, v1, v3

    add-int v9, v2, v0

    invoke-virtual {v5, v1, v2, v8, v9}, Landroid/view/View;->layout(IIII)V

    goto :goto_0

    .line 354
    .end local v2    # "childTop":I
    :cond_1
    sub-int v8, v6, v0

    iget v9, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mBottomOffset:I

    add-int v2, v8, v9

    goto :goto_1

    .line 358
    .end local v1    # "childLeft":I
    :cond_2
    iget-boolean v8, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mExpanded:Z

    if-eqz v8, :cond_3

    sub-int v8, v7, v3

    iget v9, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mTopOffset:I

    add-int v1, v8, v9

    .line 359
    .restart local v1    # "childLeft":I
    :goto_3
    sub-int v8, v6, v0

    div-int/lit8 v2, v8, 0x2

    .line 360
    .restart local v2    # "childTop":I
    const/4 v8, 0x0

    const/4 v9, 0x0

    invoke-virtual {v4}, Landroid/view/View;->getMeasuredWidth()I

    move-result v10

    invoke-virtual {v4}, Landroid/view/View;->getMeasuredHeight()I

    move-result v11

    invoke-virtual {v4, v8, v9, v10, v11}, Landroid/view/View;->layout(IIII)V

    goto :goto_2

    .line 358
    .end local v1    # "childLeft":I
    .end local v2    # "childTop":I
    :cond_3
    iget v1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mBottomOffset:I

    goto :goto_3
.end method

.method protected onMeasure(II)V
    .locals 10
    .param p1, "widthMeasureSpec"    # I
    .param p2, "heightMeasureSpec"    # I

    .prologue
    const/high16 v9, 0x40000000    # 2.0f

    .line 301
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getMode(I)I

    move-result v5

    .line 302
    .local v5, "widthSpecMode":I
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v6

    .line 304
    .local v6, "widthSpecSize":I
    invoke-static {p2}, Landroid/view/View$MeasureSpec;->getMode(I)I

    move-result v2

    .line 305
    .local v2, "heightSpecMode":I
    invoke-static {p2}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v3

    .line 307
    .local v3, "heightSpecSize":I
    if-eqz v5, :cond_0

    if-nez v2, :cond_1

    .line 308
    :cond_0
    new-instance v7, Ljava/lang/RuntimeException;

    const-string/jumbo v8, "SlidingDrawer cannot have UNSPECIFIED dimensions"

    invoke-direct {v7, v8}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v7

    .line 311
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mHandle:Landroid/view/View;

    .line 312
    .local v0, "handle":Landroid/view/View;
    invoke-virtual {p0, v0, p1, p2}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->measureChild(Landroid/view/View;II)V

    .line 314
    iget-boolean v7, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mVertical:Z

    if-eqz v7, :cond_3

    .line 315
    invoke-virtual {v0}, Landroid/view/View;->getMeasuredHeight()I

    move-result v7

    sub-int v7, v3, v7

    iget v8, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mTopOffset:I

    sub-int v8, v7, v8

    iget-boolean v7, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mShowContentAfterClose:Z

    if-eqz v7, :cond_2

    const/4 v7, 0x0

    :goto_0
    add-int v1, v8, v7

    .line 316
    .local v1, "height":I
    iget-object v7, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mContent:Landroid/view/View;

    invoke-static {v6, v9}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v8

    invoke-static {v1, v9}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v9

    invoke-virtual {v7, v8, v9}, Landroid/view/View;->measure(II)V

    .line 330
    .end local v1    # "height":I
    :goto_1
    invoke-virtual {p0, v6, v3}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->setMeasuredDimension(II)V

    .line 331
    return-void

    .line 315
    :cond_2
    iget v7, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mBottomOffset:I

    goto :goto_0

    .line 319
    :cond_3
    iget-boolean v7, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mExpanded:Z

    if-nez v7, :cond_4

    iget-boolean v7, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mTracking:Z

    if-nez v7, :cond_4

    iget-boolean v7, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mAnimating:Z

    if-nez v7, :cond_4

    .line 320
    iget v4, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mBottomOffset:I

    .line 321
    .local v4, "width":I
    iget-object v7, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mContent:Landroid/view/View;

    invoke-static {v4, v9}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v8

    invoke-static {v3, v9}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v9

    invoke-virtual {v7, v8, v9}, Landroid/view/View;->measure(II)V

    goto :goto_1

    .line 324
    .end local v4    # "width":I
    :cond_4
    invoke-virtual {v0}, Landroid/view/View;->getMeasuredWidth()I

    move-result v7

    sub-int v7, v6, v7

    iget v8, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mTopOffset:I

    add-int v4, v7, v8

    .line 325
    .restart local v4    # "width":I
    iget-object v7, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mContent:Landroid/view/View;

    invoke-static {v4, v9}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v8

    invoke-static {v3, v9}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v9

    invoke-virtual {v7, v8, v9}, Landroid/view/View;->measure(II)V

    goto :goto_1
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 12
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v10, 0x1

    const/4 v9, 0x0

    .line 461
    iget-boolean v8, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mLocked:Z

    if-eqz v8, :cond_0

    .line 514
    :goto_0
    return v10

    .line 465
    :cond_0
    iget-boolean v8, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mTracking:Z

    if-eqz v8, :cond_1

    .line 466
    iget-object v8, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mVelocityTracker:Landroid/view/VelocityTracker;

    invoke-virtual {v8, p1}, Landroid/view/VelocityTracker;->addMovement(Landroid/view/MotionEvent;)V

    .line 467
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    .line 468
    .local v0, "action":I
    packed-switch v0, :pswitch_data_0

    .line 514
    .end local v0    # "action":I
    :cond_1
    :goto_1
    iget-boolean v8, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mTracking:Z

    if-nez v8, :cond_2

    iget-boolean v8, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mAnimating:Z

    if-nez v8, :cond_2

    invoke-super {p0, p1}, Landroid/view/ViewGroup;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v8

    if-eqz v8, :cond_12

    :cond_2
    move v8, v10

    :goto_2
    move v10, v8

    goto :goto_0

    .line 470
    .restart local v0    # "action":I
    :pswitch_0
    iget-boolean v8, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mVertical:Z

    if-eqz v8, :cond_3

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v8

    :goto_3
    float-to-int v8, v8

    iget v11, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mTouchDelta:I

    sub-int/2addr v8, v11

    invoke-direct {p0, v8}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->moveHandle(I)V

    goto :goto_1

    :cond_3
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v8

    goto :goto_3

    .line 474
    :pswitch_1
    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mVelocityTracker:Landroid/view/VelocityTracker;

    .line 475
    .local v4, "velocityTracker":Landroid/view/VelocityTracker;
    iget v8, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mVelocityUnits:I

    invoke-virtual {v4, v8}, Landroid/view/VelocityTracker;->computeCurrentVelocity(I)V

    .line 477
    invoke-virtual {v4}, Landroid/view/VelocityTracker;->getYVelocity()F

    move-result v7

    .line 478
    .local v7, "yVelocity":F
    invoke-virtual {v4}, Landroid/view/VelocityTracker;->getXVelocity()F

    move-result v6

    .line 479
    .local v6, "xVelocity":F
    iget-boolean v5, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mVertical:Z

    .line 480
    .local v5, "vertical":Z
    iget-boolean v8, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mVertical:Z

    if-eqz v8, :cond_6

    move v3, v7

    .line 482
    .local v3, "velocity":F
    :goto_4
    iget-object v8, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mHandle:Landroid/view/View;

    invoke-virtual {v8}, Landroid/view/View;->getTop()I

    move-result v2

    .line 483
    .local v2, "top":I
    iget-object v8, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mHandle:Landroid/view/View;

    invoke-virtual {v8}, Landroid/view/View;->getRight()I

    move-result v1

    .line 485
    .local v1, "right":I
    invoke-static {v3}, Ljava/lang/Math;->abs(F)F

    move-result v8

    iget v11, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mMaximumTapVelocity:I

    int-to-float v11, v11

    cmpg-float v8, v8, v11

    if-gez v8, :cond_10

    .line 486
    if-eqz v5, :cond_7

    iget-boolean v8, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mExpanded:Z

    if-eqz v8, :cond_4

    iget v8, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mTapThreshold:I

    iget v11, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mTopOffset:I

    add-int/2addr v8, v11

    if-lt v2, v8, :cond_5

    :cond_4
    iget-boolean v8, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mExpanded:Z

    if-nez v8, :cond_9

    iget v8, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mBottomOffset:I

    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->getBottom()I

    move-result v11

    add-int/2addr v8, v11

    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->getTop()I

    move-result v11

    sub-int/2addr v8, v11

    iget-object v11, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mHandle:Landroid/view/View;

    invoke-virtual {v11}, Landroid/view/View;->getHeight()I

    move-result v11

    sub-int/2addr v8, v11

    iget v11, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mTapThreshold:I

    sub-int/2addr v8, v11

    if-le v2, v8, :cond_9

    .line 492
    :cond_5
    iget-boolean v8, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mAllowSingleTap:Z

    if-eqz v8, :cond_d

    .line 494
    iget-boolean v8, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mExpanded:Z

    if-eqz v8, :cond_b

    .line 495
    if-eqz v5, :cond_a

    .end local v2    # "top":I
    :goto_5
    invoke-direct {p0, v2}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->animateClose(I)V

    goto/16 :goto_1

    .end local v1    # "right":I
    .end local v3    # "velocity":F
    :cond_6
    move v3, v6

    .line 480
    goto :goto_4

    .line 486
    .restart local v1    # "right":I
    .restart local v2    # "top":I
    .restart local v3    # "velocity":F
    :cond_7
    iget-boolean v8, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mExpanded:Z

    if-eqz v8, :cond_8

    iget v8, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mTopOffset:I

    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->getRight()I

    move-result v11

    add-int/2addr v8, v11

    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->getLeft()I

    move-result v11

    sub-int/2addr v8, v11

    iget v11, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mTapThreshold:I

    sub-int/2addr v8, v11

    if-gt v1, v8, :cond_5

    :cond_8
    iget-boolean v8, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mExpanded:Z

    if-nez v8, :cond_9

    iget v8, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mBottomOffset:I

    iget-object v11, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mHandle:Landroid/view/View;

    invoke-virtual {v11}, Landroid/view/View;->getWidth()I

    move-result v11

    add-int/2addr v8, v11

    iget v11, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mTapThreshold:I

    add-int/2addr v8, v11

    if-lt v1, v8, :cond_5

    .line 504
    :cond_9
    if-eqz v5, :cond_f

    .end local v2    # "top":I
    :goto_6
    invoke-direct {p0, v2, v3, v9}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->performFling(IFZ)V

    goto/16 :goto_1

    .restart local v2    # "top":I
    :cond_a
    move v2, v1

    .line 495
    goto :goto_5

    .line 497
    :cond_b
    if-eqz v5, :cond_c

    .end local v2    # "top":I
    :goto_7
    invoke-direct {p0, v2}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->animateOpen(I)V

    goto/16 :goto_1

    .restart local v2    # "top":I
    :cond_c
    move v2, v1

    goto :goto_7

    .line 500
    :cond_d
    if-eqz v5, :cond_e

    .end local v2    # "top":I
    :goto_8
    invoke-direct {p0, v2, v3, v9}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->performFling(IFZ)V

    goto/16 :goto_1

    .restart local v2    # "top":I
    :cond_e
    move v2, v1

    goto :goto_8

    :cond_f
    move v2, v1

    .line 504
    goto :goto_6

    .line 507
    :cond_10
    if-eqz v5, :cond_11

    .end local v2    # "top":I
    :goto_9
    invoke-direct {p0, v2, v3, v9}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->performFling(IFZ)V

    goto/16 :goto_1

    .restart local v2    # "top":I
    :cond_11
    move v2, v1

    goto :goto_9

    .end local v0    # "action":I
    .end local v1    # "right":I
    .end local v2    # "top":I
    .end local v3    # "velocity":F
    .end local v4    # "velocityTracker":Landroid/view/VelocityTracker;
    .end local v5    # "vertical":Z
    .end local v6    # "xVelocity":F
    .end local v7    # "yVelocity":F
    :cond_12
    move v8, v9

    .line 514
    goto/16 :goto_2

    .line 468
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method protected prepareContent()V
    .locals 10

    .prologue
    const/high16 v9, 0x40000000    # 2.0f

    const/4 v5, 0x0

    .line 715
    iget-boolean v4, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mAnimating:Z

    if-eqz v4, :cond_0

    .line 745
    :goto_0
    return-void

    .line 722
    :cond_0
    iget-boolean v4, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mVertical:Z

    if-eqz v4, :cond_2

    .line 723
    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mHandle:Landroid/view/View;

    invoke-virtual {v4}, Landroid/view/View;->getHeight()I

    move-result v0

    .line 724
    .local v0, "childHeight":I
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->getBottom()I

    move-result v4

    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->getTop()I

    move-result v6

    sub-int/2addr v4, v6

    sub-int/2addr v4, v0

    iget v6, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mTopOffset:I

    sub-int v6, v4, v6

    iget-boolean v4, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mShowContentAfterClose:Z

    if-eqz v4, :cond_1

    move v4, v5

    :goto_1
    add-int v2, v6, v4

    .line 725
    .local v2, "height":I
    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mContent:Landroid/view/View;

    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->getRight()I

    move-result v6

    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->getLeft()I

    move-result v7

    sub-int/2addr v6, v7

    invoke-static {v6, v9}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v6

    invoke-static {v2, v9}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v7

    invoke-virtual {v4, v6, v7}, Landroid/view/View;->measure(II)V

    .line 729
    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mContent:Landroid/view/View;

    iget-object v6, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mHandle:Landroid/view/View;

    invoke-virtual {v6}, Landroid/view/View;->getBottom()I

    move-result v6

    iget-object v7, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mContent:Landroid/view/View;

    invoke-virtual {v7}, Landroid/view/View;->getMeasuredWidth()I

    move-result v7

    iget-object v8, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mHandle:Landroid/view/View;

    invoke-virtual {v8}, Landroid/view/View;->getBottom()I

    move-result v8

    iget-object v9, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mContent:Landroid/view/View;

    invoke-virtual {v9}, Landroid/view/View;->getMeasuredHeight()I

    move-result v9

    add-int/2addr v8, v9

    invoke-virtual {v4, v5, v6, v7, v8}, Landroid/view/View;->layout(IIII)V

    .line 744
    .end local v0    # "childHeight":I
    .end local v2    # "height":I
    :goto_2
    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mContent:Landroid/view/View;

    const/16 v5, 0x8

    invoke-virtual {v4, v5}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0

    .line 724
    .restart local v0    # "childHeight":I
    :cond_1
    iget v4, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mBottomOffset:I

    goto :goto_1

    .line 731
    .end local v0    # "childHeight":I
    :cond_2
    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mHandle:Landroid/view/View;

    invoke-virtual {v4}, Landroid/view/View;->getWidth()I

    move-result v1

    .line 732
    .local v1, "childWidth":I
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->getRight()I

    move-result v4

    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->getLeft()I

    move-result v6

    sub-int/2addr v4, v6

    sub-int/2addr v4, v1

    iget v6, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mTopOffset:I

    add-int v3, v4, v6

    .line 733
    .local v3, "width":I
    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mContent:Landroid/view/View;

    invoke-static {v3, v9}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v6

    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->getBottom()I

    move-result v7

    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->getTop()I

    move-result v8

    sub-int/2addr v7, v8

    invoke-static {v7, v9}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v7

    invoke-virtual {v4, v6, v7}, Landroid/view/View;->measure(II)V

    .line 735
    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mContent:Landroid/view/View;

    iget-object v6, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mContent:Landroid/view/View;

    invoke-virtual {v6}, Landroid/view/View;->getMeasuredWidth()I

    move-result v6

    iget-object v7, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mContent:Landroid/view/View;

    invoke-virtual {v7}, Landroid/view/View;->getMeasuredHeight()I

    move-result v7

    invoke-virtual {v4, v5, v5, v6, v7}, Landroid/view/View;->layout(IIII)V

    goto :goto_2
.end method

.method protected requestInterceptTouchEvent()V
    .locals 1

    .prologue
    .line 153
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mRequestInterceptTouchEvent:Z

    .line 154
    return-void
.end method

.method public setOnDrawerCloseListener(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer$OnDrawerCloseListener;)V
    .locals 0
    .param p1, "onDrawerCloseListener"    # Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer$OnDrawerCloseListener;

    .prologue
    .line 965
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mOnDrawerCloseListener:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer$OnDrawerCloseListener;

    .line 966
    return-void
.end method

.method public setOnDrawerOpenListener(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer$OnDrawerOpenListener;)V
    .locals 0
    .param p1, "onDrawerOpenListener"    # Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer$OnDrawerOpenListener;

    .prologue
    .line 956
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mOnDrawerOpenListener:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer$OnDrawerOpenListener;

    .line 957
    return-void
.end method

.method public setOnDrawerScrollListener(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer$OnDrawerScrollListener;)V
    .locals 0
    .param p1, "onDrawerScrollListener"    # Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer$OnDrawerScrollListener;

    .prologue
    .line 977
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mOnDrawerScrollListener:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer$OnDrawerScrollListener;

    .line 978
    return-void
.end method

.method public toggle()V
    .locals 1

    .prologue
    .line 866
    iget-boolean v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->mExpanded:Z

    if-nez v0, :cond_0

    .line 867
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->openDrawer()V

    .line 871
    :goto_0
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->invalidate()V

    .line 872
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->requestLayout()V

    .line 873
    return-void

    .line 869
    :cond_0
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer;->closeDrawer()V

    goto :goto_0
.end method

.method public updateHandleBackground(F)V
    .locals 0
    .param p1, "percent"    # F

    .prologue
    .line 1080
    return-void
.end method
