.class public Lco/vine/android/util/ViewBehindTouchListener;
.super Ljava/lang/Object;
.source "ViewBehindTouchListener.java"

# interfaces
.implements Lco/vine/android/views/TouchableRelativeLayout$TouchListener;


# instance fields
.field private mActivePointerId:I

.field private mInitialX:F

.field private final mInvalidateTarget:Landroid/view/View;

.field private mIsScrolling:Z

.field private mSetInitials:Z

.field private final mSlideController:Lcom/jeremyfeinstein/slidingmenu/lib/CustomViewAbove;

.field private final mTouchSlop:I


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "sm"    # Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;

    .prologue
    .line 29
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 30
    invoke-static {p1}, Landroid/view/ViewConfiguration;->get(Landroid/content/Context;)Landroid/view/ViewConfiguration;

    move-result-object v0

    .line 31
    .local v0, "configuration":Landroid/view/ViewConfiguration;
    invoke-static {v0}, Landroid/support/v4/view/ViewConfigurationCompat;->getScaledPagingTouchSlop(Landroid/view/ViewConfiguration;)I

    move-result v1

    iput v1, p0, Lco/vine/android/util/ViewBehindTouchListener;->mTouchSlop:I

    .line 32
    invoke-virtual {p2}, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;->getViewAbove()Lcom/jeremyfeinstein/slidingmenu/lib/CustomViewAbove;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/util/ViewBehindTouchListener;->mSlideController:Lcom/jeremyfeinstein/slidingmenu/lib/CustomViewAbove;

    .line 33
    invoke-virtual {p2}, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;->getViewBehind()Landroid/view/View;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/util/ViewBehindTouchListener;->mInvalidateTarget:Landroid/view/View;

    .line 34
    return-void
.end method


# virtual methods
.method public onInterceptTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 7
    .param p1, "ev"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v4, 0x0

    const/4 v3, 0x1

    .line 38
    const-string v5, "onInterceptTouchEvent!!!!"

    invoke-static {v5}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 46
    invoke-static {p1}, Landroid/support/v4/view/MotionEventCompat;->getActionMasked(Landroid/view/MotionEvent;)I

    move-result v0

    .line 49
    .local v0, "action":I
    const/4 v5, 0x3

    if-eq v0, v5, :cond_0

    if-ne v0, v3, :cond_1

    .line 51
    :cond_0
    iput-boolean v4, p0, Lco/vine/android/util/ViewBehindTouchListener;->mIsScrolling:Z

    move v3, v4

    .line 94
    :goto_0
    return v3

    .line 55
    :cond_1
    packed-switch v0, :pswitch_data_0

    .line 88
    :cond_2
    :goto_1
    :pswitch_0
    iget-object v3, p0, Lco/vine/android/util/ViewBehindTouchListener;->mSlideController:Lcom/jeremyfeinstein/slidingmenu/lib/CustomViewAbove;

    invoke-virtual {v3, p1}, Lcom/jeremyfeinstein/slidingmenu/lib/CustomViewAbove;->addMovement(Landroid/view/MotionEvent;)V

    .line 90
    iget-object v3, p0, Lco/vine/android/util/ViewBehindTouchListener;->mInvalidateTarget:Landroid/view/View;

    const-wide/16 v5, 0x64

    invoke-virtual {v3, v5, v6}, Landroid/view/View;->postInvalidateDelayed(J)V

    move v3, v4

    .line 94
    goto :goto_0

    .line 57
    :pswitch_1
    iget-boolean v5, p0, Lco/vine/android/util/ViewBehindTouchListener;->mIsScrolling:Z

    if-eqz v5, :cond_3

    .line 58
    const-string v4, "Scrolling 2"

    invoke-static {v4}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    goto :goto_0

    .line 67
    :cond_3
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v5

    iget v6, p0, Lco/vine/android/util/ViewBehindTouchListener;->mInitialX:F

    sub-float/2addr v5, v6

    float-to-int v5, v5

    invoke-static {v5}, Ljava/lang/Math;->abs(I)I

    move-result v2

    .line 71
    .local v2, "xDiff":I
    iget v5, p0, Lco/vine/android/util/ViewBehindTouchListener;->mTouchSlop:I

    if-le v2, v5, :cond_2

    .line 73
    const-string v4, "Scrolling"

    invoke-static {v4}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 74
    iput-boolean v3, p0, Lco/vine/android/util/ViewBehindTouchListener;->mIsScrolling:Z

    goto :goto_0

    .line 80
    .end local v2    # "xDiff":I
    :pswitch_2
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v5

    iput v5, p0, Lco/vine/android/util/ViewBehindTouchListener;->mInitialX:F

    .line 81
    invoke-static {p1}, Landroid/support/v4/view/MotionEventCompat;->getActionIndex(Landroid/view/MotionEvent;)I

    move-result v1

    .line 82
    .local v1, "index":I
    invoke-static {p1, v1}, Landroid/support/v4/view/MotionEventCompat;->getPointerId(Landroid/view/MotionEvent;I)I

    move-result v5

    iput v5, p0, Lco/vine/android/util/ViewBehindTouchListener;->mActivePointerId:I

    .line 83
    iput-boolean v3, p0, Lco/vine/android/util/ViewBehindTouchListener;->mSetInitials:Z

    goto :goto_1

    .line 55
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_2
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 4
    .param p1, "ev"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v3, 0x0

    .line 99
    const-string v0, "onTouchEvent!!"

    invoke-static {v0}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 100
    iget-boolean v0, p0, Lco/vine/android/util/ViewBehindTouchListener;->mSetInitials:Z

    if-eqz v0, :cond_0

    .line 101
    iget-object v0, p0, Lco/vine/android/util/ViewBehindTouchListener;->mSlideController:Lcom/jeremyfeinstein/slidingmenu/lib/CustomViewAbove;

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v1

    iget v2, p0, Lco/vine/android/util/ViewBehindTouchListener;->mActivePointerId:I

    invoke-virtual {v0, v1, v2}, Lcom/jeremyfeinstein/slidingmenu/lib/CustomViewAbove;->setInitialTouchEvents(FI)V

    .line 102
    iget-object v0, p0, Lco/vine/android/util/ViewBehindTouchListener;->mSlideController:Lcom/jeremyfeinstein/slidingmenu/lib/CustomViewAbove;

    invoke-virtual {v0, p1}, Lcom/jeremyfeinstein/slidingmenu/lib/CustomViewAbove;->determineDrag(Landroid/view/MotionEvent;)V

    .line 103
    iput-boolean v3, p0, Lco/vine/android/util/ViewBehindTouchListener;->mSetInitials:Z

    .line 105
    :cond_0
    iget-object v0, p0, Lco/vine/android/util/ViewBehindTouchListener;->mSlideController:Lcom/jeremyfeinstein/slidingmenu/lib/CustomViewAbove;

    invoke-virtual {v0, p1}, Lcom/jeremyfeinstein/slidingmenu/lib/CustomViewAbove;->onTouchEvent(Landroid/view/MotionEvent;)Z

    .line 111
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 120
    :goto_0
    :pswitch_0
    const/4 v0, 0x1

    return v0

    .line 114
    :pswitch_1
    iput-boolean v3, p0, Lco/vine/android/util/ViewBehindTouchListener;->mIsScrolling:Z

    goto :goto_0

    .line 111
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method
