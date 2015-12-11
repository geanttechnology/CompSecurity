.class public Lcom/aio/downloader/views/OverScrollView;
.super Landroid/widget/ScrollView;
.source "OverScrollView.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/views/OverScrollView$MyTimer;,
        Lcom/aio/downloader/views/OverScrollView$OverScrollListener;,
        Lcom/aio/downloader/views/OverScrollView$OverScrollTinyListener;
    }
.end annotation


# static fields
.field public static final TAG:Ljava/lang/String; = "PullToRefreshLayout"

.field private static final TRIGGER_HEIGHT:I = 0x78


# instance fields
.field public MOVE_SPEED:F

.field private canPullDown:Z

.field private canPullUp:Z

.field private downY:F

.field private isLayout:Z

.field private lastY:F

.field private mEvents:I

.field private mOverScrollListener:Lcom/aio/downloader/views/OverScrollView$OverScrollListener;

.field private mOverScrollTinyListener:Lcom/aio/downloader/views/OverScrollView$OverScrollTinyListener;

.field private mOverScrollTrigger:I

.field private overScrollDistance:F

.field public pullDownY:F

.field private pullUpY:F

.field private pullableView:Landroid/view/View;

.field private radio:F

.field private timer:Lcom/aio/downloader/views/OverScrollView$MyTimer;

.field updateHandler:Landroid/os/Handler;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 81
    invoke-direct {p0, p1}, Landroid/widget/ScrollView;-><init>(Landroid/content/Context;)V

    .line 26
    const/16 v0, 0x78

    iput v0, p0, Lcom/aio/downloader/views/OverScrollView;->mOverScrollTrigger:I

    .line 32
    iput v1, p0, Lcom/aio/downloader/views/OverScrollView;->pullDownY:F

    .line 34
    iput v1, p0, Lcom/aio/downloader/views/OverScrollView;->pullUpY:F

    .line 37
    const/high16 v0, 0x41000000    # 8.0f

    iput v0, p0, Lcom/aio/downloader/views/OverScrollView;->MOVE_SPEED:F

    .line 39
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/aio/downloader/views/OverScrollView;->isLayout:Z

    .line 41
    const/high16 v0, 0x40000000    # 2.0f

    iput v0, p0, Lcom/aio/downloader/views/OverScrollView;->radio:F

    .line 47
    iput-boolean v2, p0, Lcom/aio/downloader/views/OverScrollView;->canPullDown:Z

    .line 48
    iput-boolean v2, p0, Lcom/aio/downloader/views/OverScrollView;->canPullUp:Z

    .line 53
    new-instance v0, Lcom/aio/downloader/views/OverScrollView$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/views/OverScrollView$1;-><init>(Lcom/aio/downloader/views/OverScrollView;)V

    iput-object v0, p0, Lcom/aio/downloader/views/OverScrollView;->updateHandler:Landroid/os/Handler;

    .line 82
    invoke-direct {p0, p1}, Lcom/aio/downloader/views/OverScrollView;->initView(Landroid/content/Context;)V

    .line 83
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 86
    invoke-direct {p0, p1, p2}, Landroid/widget/ScrollView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 26
    const/16 v0, 0x78

    iput v0, p0, Lcom/aio/downloader/views/OverScrollView;->mOverScrollTrigger:I

    .line 32
    iput v1, p0, Lcom/aio/downloader/views/OverScrollView;->pullDownY:F

    .line 34
    iput v1, p0, Lcom/aio/downloader/views/OverScrollView;->pullUpY:F

    .line 37
    const/high16 v0, 0x41000000    # 8.0f

    iput v0, p0, Lcom/aio/downloader/views/OverScrollView;->MOVE_SPEED:F

    .line 39
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/aio/downloader/views/OverScrollView;->isLayout:Z

    .line 41
    const/high16 v0, 0x40000000    # 2.0f

    iput v0, p0, Lcom/aio/downloader/views/OverScrollView;->radio:F

    .line 47
    iput-boolean v2, p0, Lcom/aio/downloader/views/OverScrollView;->canPullDown:Z

    .line 48
    iput-boolean v2, p0, Lcom/aio/downloader/views/OverScrollView;->canPullUp:Z

    .line 53
    new-instance v0, Lcom/aio/downloader/views/OverScrollView$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/views/OverScrollView$1;-><init>(Lcom/aio/downloader/views/OverScrollView;)V

    iput-object v0, p0, Lcom/aio/downloader/views/OverScrollView;->updateHandler:Landroid/os/Handler;

    .line 87
    invoke-direct {p0, p1}, Lcom/aio/downloader/views/OverScrollView;->initView(Landroid/content/Context;)V

    .line 88
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 91
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/ScrollView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 26
    const/16 v0, 0x78

    iput v0, p0, Lcom/aio/downloader/views/OverScrollView;->mOverScrollTrigger:I

    .line 32
    iput v1, p0, Lcom/aio/downloader/views/OverScrollView;->pullDownY:F

    .line 34
    iput v1, p0, Lcom/aio/downloader/views/OverScrollView;->pullUpY:F

    .line 37
    const/high16 v0, 0x41000000    # 8.0f

    iput v0, p0, Lcom/aio/downloader/views/OverScrollView;->MOVE_SPEED:F

    .line 39
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/aio/downloader/views/OverScrollView;->isLayout:Z

    .line 41
    const/high16 v0, 0x40000000    # 2.0f

    iput v0, p0, Lcom/aio/downloader/views/OverScrollView;->radio:F

    .line 47
    iput-boolean v2, p0, Lcom/aio/downloader/views/OverScrollView;->canPullDown:Z

    .line 48
    iput-boolean v2, p0, Lcom/aio/downloader/views/OverScrollView;->canPullUp:Z

    .line 53
    new-instance v0, Lcom/aio/downloader/views/OverScrollView$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/views/OverScrollView$1;-><init>(Lcom/aio/downloader/views/OverScrollView;)V

    iput-object v0, p0, Lcom/aio/downloader/views/OverScrollView;->updateHandler:Landroid/os/Handler;

    .line 92
    invoke-direct {p0, p1}, Lcom/aio/downloader/views/OverScrollView;->initView(Landroid/content/Context;)V

    .line 93
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/views/OverScrollView;)F
    .locals 1

    .prologue
    .line 34
    iget v0, p0, Lcom/aio/downloader/views/OverScrollView;->pullUpY:F

    return v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/views/OverScrollView;F)V
    .locals 0

    .prologue
    .line 34
    iput p1, p0, Lcom/aio/downloader/views/OverScrollView;->pullUpY:F

    return-void
.end method

.method static synthetic access$2(Lcom/aio/downloader/views/OverScrollView;)Lcom/aio/downloader/views/OverScrollView$MyTimer;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/aio/downloader/views/OverScrollView;->timer:Lcom/aio/downloader/views/OverScrollView$MyTimer;

    return-object v0
.end method

.method private hide()V
    .locals 3

    .prologue
    .line 101
    iget-object v0, p0, Lcom/aio/downloader/views/OverScrollView;->timer:Lcom/aio/downloader/views/OverScrollView$MyTimer;

    const-wide/16 v1, 0x5

    invoke-virtual {v0, v1, v2}, Lcom/aio/downloader/views/OverScrollView$MyTimer;->schedule(J)V

    .line 102
    return-void
.end method

.method private initView(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 96
    new-instance v0, Lcom/aio/downloader/views/OverScrollView$MyTimer;

    iget-object v1, p0, Lcom/aio/downloader/views/OverScrollView;->updateHandler:Landroid/os/Handler;

    invoke-direct {v0, p0, v1}, Lcom/aio/downloader/views/OverScrollView$MyTimer;-><init>(Lcom/aio/downloader/views/OverScrollView;Landroid/os/Handler;)V

    iput-object v0, p0, Lcom/aio/downloader/views/OverScrollView;->timer:Lcom/aio/downloader/views/OverScrollView$MyTimer;

    .line 97
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/aio/downloader/views/OverScrollView;->setFadingEdgeLength(I)V

    .line 98
    return-void
.end method

.method private isCanPullDown()Z
    .locals 3

    .prologue
    .line 267
    invoke-virtual {p0}, Lcom/aio/downloader/views/OverScrollView;->getScrollY()I

    move-result v0

    if-eqz v0, :cond_0

    .line 268
    iget-object v0, p0, Lcom/aio/downloader/views/OverScrollView;->pullableView:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getHeight()I

    move-result v0

    invoke-virtual {p0}, Lcom/aio/downloader/views/OverScrollView;->getHeight()I

    move-result v1

    invoke-virtual {p0}, Lcom/aio/downloader/views/OverScrollView;->getScrollY()I

    move-result v2

    add-int/2addr v1, v2

    .line 267
    if-lt v0, v1, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method

.method private isCanPullUp()Z
    .locals 3

    .prologue
    .line 275
    iget-object v0, p0, Lcom/aio/downloader/views/OverScrollView;->pullableView:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getHeight()I

    move-result v0

    invoke-virtual {p0}, Lcom/aio/downloader/views/OverScrollView;->getHeight()I

    move-result v1

    invoke-virtual {p0}, Lcom/aio/downloader/views/OverScrollView;->getScrollY()I

    move-result v2

    add-int/2addr v1, v2

    if-gt v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private isOnBottom()Z
    .locals 2

    .prologue
    .line 283
    invoke-virtual {p0}, Lcom/aio/downloader/views/OverScrollView;->getScrollY()I

    move-result v0

    invoke-virtual {p0}, Lcom/aio/downloader/views/OverScrollView;->getHeight()I

    move-result v1

    add-int/2addr v0, v1

    iget-object v1, p0, Lcom/aio/downloader/views/OverScrollView;->pullableView:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getHeight()I

    move-result v1

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private isOnTop()Z
    .locals 1

    .prologue
    .line 279
    invoke-virtual {p0}, Lcom/aio/downloader/views/OverScrollView;->getScrollY()I

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private overScrollTrigger()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 337
    iget-object v0, p0, Lcom/aio/downloader/views/OverScrollView;->mOverScrollListener:Lcom/aio/downloader/views/OverScrollView$OverScrollListener;

    if-nez v0, :cond_1

    .line 348
    :cond_0
    :goto_0
    return-void

    .line 341
    :cond_1
    iget v0, p0, Lcom/aio/downloader/views/OverScrollView;->overScrollDistance:F

    iget v1, p0, Lcom/aio/downloader/views/OverScrollView;->mOverScrollTrigger:I

    int-to-float v1, v1

    cmpl-float v0, v0, v1

    if-lez v0, :cond_2

    iget v0, p0, Lcom/aio/downloader/views/OverScrollView;->overScrollDistance:F

    cmpl-float v0, v0, v2

    if-ltz v0, :cond_2

    .line 342
    iget-object v0, p0, Lcom/aio/downloader/views/OverScrollView;->mOverScrollListener:Lcom/aio/downloader/views/OverScrollView$OverScrollListener;

    invoke-interface {v0}, Lcom/aio/downloader/views/OverScrollView$OverScrollListener;->headerScroll()V

    .line 345
    :cond_2
    iget v0, p0, Lcom/aio/downloader/views/OverScrollView;->overScrollDistance:F

    iget v1, p0, Lcom/aio/downloader/views/OverScrollView;->mOverScrollTrigger:I

    neg-int v1, v1

    int-to-float v1, v1

    cmpg-float v0, v0, v1

    if-gez v0, :cond_0

    iget v0, p0, Lcom/aio/downloader/views/OverScrollView;->overScrollDistance:F

    cmpg-float v0, v0, v2

    if-gez v0, :cond_0

    .line 346
    iget-object v0, p0, Lcom/aio/downloader/views/OverScrollView;->mOverScrollListener:Lcom/aio/downloader/views/OverScrollView$OverScrollListener;

    invoke-interface {v0}, Lcom/aio/downloader/views/OverScrollView$OverScrollListener;->footerScroll()V

    goto :goto_0
.end method

.method private releasePull()V
    .locals 1

    .prologue
    const/4 v0, 0x1

    .line 108
    iput-boolean v0, p0, Lcom/aio/downloader/views/OverScrollView;->canPullDown:Z

    .line 109
    iput-boolean v0, p0, Lcom/aio/downloader/views/OverScrollView;->canPullUp:Z

    .line 110
    return-void
.end method


# virtual methods
.method public dispatchTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 11
    .param p1, "ev"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v10, 0x1

    const/4 v5, 0x0

    const/4 v4, 0x0

    .line 119
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getActionMasked()I

    move-result v2

    packed-switch v2, :pswitch_data_0

    .line 200
    :cond_0
    :goto_0
    :pswitch_0
    :try_start_0
    invoke-super {p0, p1}, Landroid/widget/ScrollView;->dispatchTouchEvent(Landroid/view/MotionEvent;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 205
    :goto_1
    return v10

    .line 121
    :pswitch_1
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v2

    iput v2, p0, Lcom/aio/downloader/views/OverScrollView;->downY:F

    .line 122
    iget v2, p0, Lcom/aio/downloader/views/OverScrollView;->downY:F

    iput v2, p0, Lcom/aio/downloader/views/OverScrollView;->lastY:F

    .line 123
    iget-object v2, p0, Lcom/aio/downloader/views/OverScrollView;->timer:Lcom/aio/downloader/views/OverScrollView$MyTimer;

    invoke-virtual {v2}, Lcom/aio/downloader/views/OverScrollView$MyTimer;->cancel()V

    .line 124
    iput v5, p0, Lcom/aio/downloader/views/OverScrollView;->mEvents:I

    .line 125
    invoke-direct {p0}, Lcom/aio/downloader/views/OverScrollView;->releasePull()V

    goto :goto_0

    .line 130
    :pswitch_2
    const/4 v2, -0x1

    iput v2, p0, Lcom/aio/downloader/views/OverScrollView;->mEvents:I

    goto :goto_0

    .line 133
    :pswitch_3
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v2

    iget v3, p0, Lcom/aio/downloader/views/OverScrollView;->lastY:F

    sub-float v0, v2, v3

    .line 134
    .local v0, "deltaY":F
    iget v2, p0, Lcom/aio/downloader/views/OverScrollView;->mEvents:I

    if-nez v2, :cond_a

    .line 135
    iget-boolean v2, p0, Lcom/aio/downloader/views/OverScrollView;->canPullDown:Z

    if-eqz v2, :cond_5

    invoke-direct {p0}, Lcom/aio/downloader/views/OverScrollView;->isCanPullDown()Z

    move-result v2

    if-eqz v2, :cond_5

    .line 138
    iget v2, p0, Lcom/aio/downloader/views/OverScrollView;->pullDownY:F

    iget v3, p0, Lcom/aio/downloader/views/OverScrollView;->radio:F

    div-float v3, v0, v3

    add-float/2addr v2, v3

    iput v2, p0, Lcom/aio/downloader/views/OverScrollView;->pullDownY:F

    .line 139
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v2

    iget v3, p0, Lcom/aio/downloader/views/OverScrollView;->lastY:F

    sub-float/2addr v2, v3

    cmpg-float v2, v2, v4

    if-gez v2, :cond_1

    .line 140
    iget v2, p0, Lcom/aio/downloader/views/OverScrollView;->pullDownY:F

    add-float/2addr v2, v0

    iput v2, p0, Lcom/aio/downloader/views/OverScrollView;->pullDownY:F

    .line 142
    :cond_1
    iget v2, p0, Lcom/aio/downloader/views/OverScrollView;->pullDownY:F

    cmpg-float v2, v2, v4

    if-gez v2, :cond_2

    .line 143
    iput v4, p0, Lcom/aio/downloader/views/OverScrollView;->pullDownY:F

    .line 144
    iput-boolean v5, p0, Lcom/aio/downloader/views/OverScrollView;->canPullDown:Z

    .line 145
    iput-boolean v10, p0, Lcom/aio/downloader/views/OverScrollView;->canPullUp:Z

    .line 147
    :cond_2
    iget v2, p0, Lcom/aio/downloader/views/OverScrollView;->pullDownY:F

    invoke-virtual {p0}, Lcom/aio/downloader/views/OverScrollView;->getMeasuredHeight()I

    move-result v3

    int-to-float v3, v3

    cmpl-float v2, v2, v3

    if-lez v2, :cond_3

    .line 148
    invoke-virtual {p0}, Lcom/aio/downloader/views/OverScrollView;->getMeasuredHeight()I

    move-result v2

    int-to-float v2, v2

    iput v2, p0, Lcom/aio/downloader/views/OverScrollView;->pullDownY:F

    .line 149
    :cond_3
    iget v2, p0, Lcom/aio/downloader/views/OverScrollView;->pullDownY:F

    iput v2, p0, Lcom/aio/downloader/views/OverScrollView;->overScrollDistance:F

    .line 168
    :goto_2
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v2

    iput v2, p0, Lcom/aio/downloader/views/OverScrollView;->lastY:F

    .line 170
    const-wide/high16 v2, 0x4000000000000000L    # 2.0

    const-wide/high16 v4, 0x4008000000000000L    # 3.0

    const-wide v6, 0x3ff921fb54442d18L    # 1.5707963267948966

    invoke-virtual {p0}, Lcom/aio/downloader/views/OverScrollView;->getMeasuredHeight()I

    move-result v8

    int-to-double v8, v8

    div-double/2addr v6, v8

    .line 171
    iget v8, p0, Lcom/aio/downloader/views/OverScrollView;->pullDownY:F

    iget v9, p0, Lcom/aio/downloader/views/OverScrollView;->pullUpY:F

    invoke-static {v9}, Ljava/lang/Math;->abs(F)F

    move-result v9

    add-float/2addr v8, v9

    float-to-double v8, v8

    mul-double/2addr v6, v8

    .line 170
    invoke-static {v6, v7}, Ljava/lang/Math;->tan(D)D

    move-result-wide v6

    mul-double/2addr v4, v6

    add-double/2addr v2, v4

    double-to-float v2, v2

    iput v2, p0, Lcom/aio/downloader/views/OverScrollView;->radio:F

    .line 172
    invoke-virtual {p0}, Lcom/aio/downloader/views/OverScrollView;->requestLayout()V

    .line 175
    iget v2, p0, Lcom/aio/downloader/views/OverScrollView;->pullDownY:F

    iget v3, p0, Lcom/aio/downloader/views/OverScrollView;->pullUpY:F

    invoke-static {v3}, Ljava/lang/Math;->abs(F)F

    move-result v3

    add-float/2addr v2, v3

    const/high16 v3, 0x41000000    # 8.0f

    cmpl-float v2, v2, v3

    if-lez v2, :cond_4

    .line 177
    const/4 v2, 0x3

    invoke-virtual {p1, v2}, Landroid/view/MotionEvent;->setAction(I)V

    .line 179
    :cond_4
    iget-object v2, p0, Lcom/aio/downloader/views/OverScrollView;->mOverScrollTinyListener:Lcom/aio/downloader/views/OverScrollView$OverScrollTinyListener;

    if-eqz v2, :cond_0

    .line 180
    iget-object v2, p0, Lcom/aio/downloader/views/OverScrollView;->mOverScrollTinyListener:Lcom/aio/downloader/views/OverScrollView$OverScrollTinyListener;

    float-to-int v3, v0

    iget v4, p0, Lcom/aio/downloader/views/OverScrollView;->overScrollDistance:F

    float-to-int v4, v4

    invoke-interface {v2, v3, v4}, Lcom/aio/downloader/views/OverScrollView$OverScrollTinyListener;->scrollDistance(II)V

    goto/16 :goto_0

    .line 150
    :cond_5
    iget-boolean v2, p0, Lcom/aio/downloader/views/OverScrollView;->canPullUp:Z

    if-eqz v2, :cond_9

    invoke-direct {p0}, Lcom/aio/downloader/views/OverScrollView;->isCanPullUp()Z

    move-result v2

    if-eqz v2, :cond_9

    .line 152
    iget v2, p0, Lcom/aio/downloader/views/OverScrollView;->pullUpY:F

    iget v3, p0, Lcom/aio/downloader/views/OverScrollView;->radio:F

    div-float v3, v0, v3

    add-float/2addr v2, v3

    iput v2, p0, Lcom/aio/downloader/views/OverScrollView;->pullUpY:F

    .line 153
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v2

    iget v3, p0, Lcom/aio/downloader/views/OverScrollView;->lastY:F

    sub-float/2addr v2, v3

    cmpl-float v2, v2, v4

    if-lez v2, :cond_6

    .line 154
    iget v2, p0, Lcom/aio/downloader/views/OverScrollView;->pullUpY:F

    add-float/2addr v2, v0

    iput v2, p0, Lcom/aio/downloader/views/OverScrollView;->pullUpY:F

    .line 156
    :cond_6
    iget v2, p0, Lcom/aio/downloader/views/OverScrollView;->pullUpY:F

    cmpl-float v2, v2, v4

    if-lez v2, :cond_7

    .line 157
    iput v4, p0, Lcom/aio/downloader/views/OverScrollView;->pullUpY:F

    .line 158
    iput-boolean v10, p0, Lcom/aio/downloader/views/OverScrollView;->canPullDown:Z

    .line 159
    iput-boolean v5, p0, Lcom/aio/downloader/views/OverScrollView;->canPullUp:Z

    .line 161
    :cond_7
    iget v2, p0, Lcom/aio/downloader/views/OverScrollView;->pullUpY:F

    invoke-virtual {p0}, Lcom/aio/downloader/views/OverScrollView;->getMeasuredHeight()I

    move-result v3

    neg-int v3, v3

    int-to-float v3, v3

    cmpg-float v2, v2, v3

    if-gez v2, :cond_8

    .line 162
    invoke-virtual {p0}, Lcom/aio/downloader/views/OverScrollView;->getMeasuredHeight()I

    move-result v2

    neg-int v2, v2

    int-to-float v2, v2

    iput v2, p0, Lcom/aio/downloader/views/OverScrollView;->pullUpY:F

    .line 163
    :cond_8
    iget v2, p0, Lcom/aio/downloader/views/OverScrollView;->pullUpY:F

    iput v2, p0, Lcom/aio/downloader/views/OverScrollView;->overScrollDistance:F

    goto/16 :goto_2

    .line 165
    :cond_9
    invoke-direct {p0}, Lcom/aio/downloader/views/OverScrollView;->releasePull()V

    goto/16 :goto_2

    .line 167
    :cond_a
    iput v5, p0, Lcom/aio/downloader/views/OverScrollView;->mEvents:I

    goto/16 :goto_2

    .line 184
    .end local v0    # "deltaY":F
    :pswitch_4
    invoke-direct {p0}, Lcom/aio/downloader/views/OverScrollView;->hide()V

    .line 185
    invoke-direct {p0}, Lcom/aio/downloader/views/OverScrollView;->overScrollTrigger()V

    .line 186
    iget-object v2, p0, Lcom/aio/downloader/views/OverScrollView;->mOverScrollTinyListener:Lcom/aio/downloader/views/OverScrollView$OverScrollTinyListener;

    if-eqz v2, :cond_0

    invoke-direct {p0}, Lcom/aio/downloader/views/OverScrollView;->isCanPullDown()Z

    move-result v2

    if-nez v2, :cond_b

    invoke-direct {p0}, Lcom/aio/downloader/views/OverScrollView;->isCanPullUp()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 187
    :cond_b
    iget-object v2, p0, Lcom/aio/downloader/views/OverScrollView;->mOverScrollTinyListener:Lcom/aio/downloader/views/OverScrollView$OverScrollTinyListener;

    invoke-interface {v2}, Lcom/aio/downloader/views/OverScrollView$OverScrollTinyListener;->scrollLoosen()V

    goto/16 :goto_0

    .line 191
    :pswitch_5
    iget-object v2, p0, Lcom/aio/downloader/views/OverScrollView;->mOverScrollTinyListener:Lcom/aio/downloader/views/OverScrollView$OverScrollTinyListener;

    if-eqz v2, :cond_0

    invoke-direct {p0}, Lcom/aio/downloader/views/OverScrollView;->isCanPullDown()Z

    move-result v2

    if-nez v2, :cond_c

    invoke-direct {p0}, Lcom/aio/downloader/views/OverScrollView;->isCanPullUp()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 192
    :cond_c
    iget-object v2, p0, Lcom/aio/downloader/views/OverScrollView;->mOverScrollTinyListener:Lcom/aio/downloader/views/OverScrollView$OverScrollTinyListener;

    invoke-interface {v2}, Lcom/aio/downloader/views/OverScrollView$OverScrollTinyListener;->scrollLoosen()V

    goto/16 :goto_0

    .line 201
    :catch_0
    move-exception v1

    .line 203
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_1

    .line 119
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_4
        :pswitch_3
        :pswitch_5
        :pswitch_0
        :pswitch_2
        :pswitch_2
    .end packed-switch
.end method

.method public getOverScrollListener()Lcom/aio/downloader/views/OverScrollView$OverScrollListener;
    .locals 1

    .prologue
    .line 359
    iget-object v0, p0, Lcom/aio/downloader/views/OverScrollView;->mOverScrollListener:Lcom/aio/downloader/views/OverScrollView$OverScrollListener;

    return-object v0
.end method

.method public getOverScrollTinyListener()Lcom/aio/downloader/views/OverScrollView$OverScrollTinyListener;
    .locals 1

    .prologue
    .line 351
    iget-object v0, p0, Lcom/aio/downloader/views/OverScrollView;->mOverScrollTinyListener:Lcom/aio/downloader/views/OverScrollView$OverScrollTinyListener;

    return-object v0
.end method

.method protected onLayout(ZIIII)V
    .locals 6
    .param p1, "changed"    # Z
    .param p2, "l"    # I
    .param p3, "t"    # I
    .param p4, "r"    # I
    .param p5, "b"    # I

    .prologue
    const/4 v5, 0x0

    .line 211
    iget-boolean v0, p0, Lcom/aio/downloader/views/OverScrollView;->isLayout:Z

    if-nez v0, :cond_0

    .line 213
    invoke-virtual {p0, v5}, Lcom/aio/downloader/views/OverScrollView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/views/OverScrollView;->pullableView:Landroid/view/View;

    .line 214
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/aio/downloader/views/OverScrollView;->isLayout:Z

    .line 217
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/views/OverScrollView;->pullableView:Landroid/view/View;

    iget v1, p0, Lcom/aio/downloader/views/OverScrollView;->pullDownY:F

    iget v2, p0, Lcom/aio/downloader/views/OverScrollView;->pullUpY:F

    add-float/2addr v1, v2

    float-to-int v1, v1

    .line 218
    iget-object v2, p0, Lcom/aio/downloader/views/OverScrollView;->pullableView:Landroid/view/View;

    invoke-virtual {v2}, Landroid/view/View;->getMeasuredWidth()I

    move-result v2

    iget v3, p0, Lcom/aio/downloader/views/OverScrollView;->pullDownY:F

    iget v4, p0, Lcom/aio/downloader/views/OverScrollView;->pullUpY:F

    add-float/2addr v3, v4

    float-to-int v3, v3

    .line 219
    iget-object v4, p0, Lcom/aio/downloader/views/OverScrollView;->pullableView:Landroid/view/View;

    invoke-virtual {v4}, Landroid/view/View;->getMeasuredHeight()I

    move-result v4

    add-int/2addr v3, v4

    .line 217
    invoke-virtual {v0, v5, v1, v2, v3}, Landroid/view/View;->layout(IIII)V

    .line 220
    return-void
.end method

.method public setOverScrollListener(Lcom/aio/downloader/views/OverScrollView$OverScrollListener;)V
    .locals 0
    .param p1, "OverScrollListener"    # Lcom/aio/downloader/views/OverScrollView$OverScrollListener;

    .prologue
    .line 363
    iput-object p1, p0, Lcom/aio/downloader/views/OverScrollView;->mOverScrollListener:Lcom/aio/downloader/views/OverScrollView$OverScrollListener;

    .line 364
    return-void
.end method

.method public setOverScrollTinyListener(Lcom/aio/downloader/views/OverScrollView$OverScrollTinyListener;)V
    .locals 0
    .param p1, "OverScrollTinyListener"    # Lcom/aio/downloader/views/OverScrollView$OverScrollTinyListener;

    .prologue
    .line 355
    iput-object p1, p0, Lcom/aio/downloader/views/OverScrollView;->mOverScrollTinyListener:Lcom/aio/downloader/views/OverScrollView$OverScrollTinyListener;

    .line 356
    return-void
.end method

.method public setOverScrollTrigger(I)V
    .locals 1
    .param p1, "height"    # I

    .prologue
    .line 331
    const/16 v0, 0x1e

    if-lt p1, v0, :cond_0

    .line 332
    iput p1, p0, Lcom/aio/downloader/views/OverScrollView;->mOverScrollTrigger:I

    .line 334
    :cond_0
    return-void
.end method
