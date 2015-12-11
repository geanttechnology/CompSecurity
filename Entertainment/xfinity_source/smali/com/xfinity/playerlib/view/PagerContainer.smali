.class public Lcom/xfinity/playerlib/view/PagerContainer;
.super Landroid/widget/FrameLayout;
.source "PagerContainer.java"

# interfaces
.implements Landroid/support/v4/view/ViewPager$OnPageChangeListener;


# instance fields
.field private mCenter:Landroid/graphics/Point;

.field private mInitialTouch:Landroid/graphics/Point;

.field mNeedsRedraw:Z

.field private mPager:Landroid/support/v4/view/ViewPager;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 46
    invoke-direct {p0, p1}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V

    .line 43
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/PagerContainer;->mNeedsRedraw:Z

    .line 79
    new-instance v0, Landroid/graphics/Point;

    invoke-direct {v0}, Landroid/graphics/Point;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/PagerContainer;->mCenter:Landroid/graphics/Point;

    .line 80
    new-instance v0, Landroid/graphics/Point;

    invoke-direct {v0}, Landroid/graphics/Point;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/PagerContainer;->mInitialTouch:Landroid/graphics/Point;

    .line 47
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/PagerContainer;->init()V

    .line 48
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 51
    invoke-direct {p0, p1, p2}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 43
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/PagerContainer;->mNeedsRedraw:Z

    .line 79
    new-instance v0, Landroid/graphics/Point;

    invoke-direct {v0}, Landroid/graphics/Point;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/PagerContainer;->mCenter:Landroid/graphics/Point;

    .line 80
    new-instance v0, Landroid/graphics/Point;

    invoke-direct {v0}, Landroid/graphics/Point;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/PagerContainer;->mInitialTouch:Landroid/graphics/Point;

    .line 52
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/PagerContainer;->init()V

    .line 53
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    .line 56
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 43
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/PagerContainer;->mNeedsRedraw:Z

    .line 79
    new-instance v0, Landroid/graphics/Point;

    invoke-direct {v0}, Landroid/graphics/Point;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/PagerContainer;->mCenter:Landroid/graphics/Point;

    .line 80
    new-instance v0, Landroid/graphics/Point;

    invoke-direct {v0}, Landroid/graphics/Point;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/PagerContainer;->mInitialTouch:Landroid/graphics/Point;

    .line 57
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/PagerContainer;->init()V

    .line 58
    return-void
.end method

.method private init()V
    .locals 1

    .prologue
    .line 62
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/PagerContainer;->setClipChildren(Z)V

    .line 63
    return-void
.end method


# virtual methods
.method public getViewPager()Landroid/support/v4/view/ViewPager;
    .locals 1

    .prologue
    .line 76
    iget-object v0, p0, Lcom/xfinity/playerlib/view/PagerContainer;->mPager:Landroid/support/v4/view/ViewPager;

    return-object v0
.end method

.method protected onFinishInflate()V
    .locals 3

    .prologue
    .line 68
    const/4 v1, 0x0

    :try_start_0
    invoke-virtual {p0, v1}, Lcom/xfinity/playerlib/view/PagerContainer;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/support/v4/view/ViewPager;

    iput-object v1, p0, Lcom/xfinity/playerlib/view/PagerContainer;->mPager:Landroid/support/v4/view/ViewPager;

    .line 69
    iget-object v1, p0, Lcom/xfinity/playerlib/view/PagerContainer;->mPager:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v1, p0}, Landroid/support/v4/view/ViewPager;->setOnPageChangeListener(Landroid/support/v4/view/ViewPager$OnPageChangeListener;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 73
    return-void

    .line 70
    :catch_0
    move-exception v0

    .line 71
    .local v0, "e":Ljava/lang/Exception;
    new-instance v1, Ljava/lang/IllegalStateException;

    const-string v2, "The root child of PagerContainer must be a ViewPager"

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method public onPageScrollStateChanged(I)V
    .locals 1
    .param p1, "state"    # I

    .prologue
    .line 118
    if-eqz p1, :cond_0

    const/4 v0, 0x1

    :goto_0
    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/PagerContainer;->mNeedsRedraw:Z

    .line 119
    return-void

    .line 118
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onPageScrolled(IFI)V
    .locals 1
    .param p1, "position"    # I
    .param p2, "positionOffset"    # F
    .param p3, "positionOffsetPixels"    # I

    .prologue
    .line 108
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/PagerContainer;->mNeedsRedraw:Z

    if-eqz v0, :cond_0

    .line 109
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/PagerContainer;->invalidate()V

    .line 111
    :cond_0
    return-void
.end method

.method public onPageSelected(I)V
    .locals 0
    .param p1, "position"    # I

    .prologue
    .line 114
    return-void
.end method

.method protected onSizeChanged(IIII)V
    .locals 2
    .param p1, "w"    # I
    .param p2, "h"    # I
    .param p3, "oldw"    # I
    .param p4, "oldh"    # I

    .prologue
    .line 84
    iget-object v0, p0, Lcom/xfinity/playerlib/view/PagerContainer;->mCenter:Landroid/graphics/Point;

    div-int/lit8 v1, p1, 0x2

    iput v1, v0, Landroid/graphics/Point;->x:I

    .line 85
    iget-object v0, p0, Lcom/xfinity/playerlib/view/PagerContainer;->mCenter:Landroid/graphics/Point;

    div-int/lit8 v1, p2, 0x2

    iput v1, v0, Landroid/graphics/Point;->y:I

    .line 86
    return-void
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 3
    .param p1, "ev"    # Landroid/view/MotionEvent;

    .prologue
    .line 92
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 97
    :goto_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/PagerContainer;->mCenter:Landroid/graphics/Point;

    iget v0, v0, Landroid/graphics/Point;->x:I

    iget-object v1, p0, Lcom/xfinity/playerlib/view/PagerContainer;->mInitialTouch:Landroid/graphics/Point;

    iget v1, v1, Landroid/graphics/Point;->x:I

    sub-int/2addr v0, v1

    int-to-float v0, v0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/PagerContainer;->mCenter:Landroid/graphics/Point;

    iget v1, v1, Landroid/graphics/Point;->y:I

    iget-object v2, p0, Lcom/xfinity/playerlib/view/PagerContainer;->mInitialTouch:Landroid/graphics/Point;

    iget v2, v2, Landroid/graphics/Point;->y:I

    sub-int/2addr v1, v2

    int-to-float v1, v1

    invoke-virtual {p1, v0, v1}, Landroid/view/MotionEvent;->offsetLocation(FF)V

    .line 101
    iget-object v0, p0, Lcom/xfinity/playerlib/view/PagerContainer;->mPager:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v0, p1}, Landroid/support/v4/view/ViewPager;->dispatchTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    return v0

    .line 94
    :pswitch_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/PagerContainer;->mInitialTouch:Landroid/graphics/Point;

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v1

    float-to-int v1, v1

    iput v1, v0, Landroid/graphics/Point;->x:I

    .line 95
    iget-object v0, p0, Lcom/xfinity/playerlib/view/PagerContainer;->mInitialTouch:Landroid/graphics/Point;

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v1

    float-to-int v1, v1

    iput v1, v0, Landroid/graphics/Point;->y:I

    goto :goto_0

    .line 92
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
    .end packed-switch
.end method
