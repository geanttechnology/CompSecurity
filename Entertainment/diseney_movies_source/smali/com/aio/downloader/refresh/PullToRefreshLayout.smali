.class public Lcom/aio/downloader/refresh/PullToRefreshLayout;
.super Landroid/widget/RelativeLayout;
.source "PullToRefreshLayout.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/refresh/PullToRefreshLayout$MyTimer;,
        Lcom/aio/downloader/refresh/PullToRefreshLayout$OnRefreshListener;
    }
.end annotation


# static fields
.field public static final DONE:I = 0x3

.field public static final FAIL:I = 0x1

.field public static final INIT:I = 0x0

.field public static final REFRESHING:I = 0x2

.field public static final RELEASE_TO_REFRESH:I = 0x1

.field public static final SUCCEED:I = 0x0

.field public static final TAG:Ljava/lang/String; = "PullToRefreshLayout"


# instance fields
.field public MOVE_SPEED:F

.field private downY:F

.field private isLayout:Z

.field private isTouch:Z

.field private lastY:F

.field private mEvents:I

.field private mListener:Lcom/aio/downloader/refresh/PullToRefreshLayout$OnRefreshListener;

.field public pullDownY:F

.field private pullView:Landroid/view/View;

.field private pullableView:Landroid/view/View;

.field private radio:F

.field private refreshDist:F

.field private refreshStateImageView:Landroid/view/View;

.field private refreshStateTextView:Landroid/widget/TextView;

.field private refreshView:Landroid/view/View;

.field private refreshingAnimation:Landroid/view/animation/RotateAnimation;

.field private refreshingView:Landroid/view/View;

.field private rotateAnimation:Landroid/view/animation/RotateAnimation;

.field private state:I

.field private timer:Lcom/aio/downloader/refresh/PullToRefreshLayout$MyTimer;

.field updateHandler:Landroid/os/Handler;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v1, 0x0

    .line 124
    invoke-direct {p0, p1}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;)V

    .line 37
    iput v1, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->state:I

    .line 48
    const/4 v0, 0x0

    iput v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->pullDownY:F

    .line 51
    const/high16 v0, 0x43480000    # 200.0f

    iput v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->refreshDist:F

    .line 55
    const/high16 v0, 0x41000000    # 8.0f

    iput v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->MOVE_SPEED:F

    .line 57
    iput-boolean v1, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->isLayout:Z

    .line 59
    iput-boolean v1, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->isTouch:Z

    .line 61
    const/high16 v0, 0x40000000    # 2.0f

    iput v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->radio:F

    .line 87
    new-instance v0, Lcom/aio/downloader/refresh/PullToRefreshLayout$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/refresh/PullToRefreshLayout$1;-><init>(Lcom/aio/downloader/refresh/PullToRefreshLayout;)V

    iput-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->updateHandler:Landroid/os/Handler;

    .line 125
    invoke-direct {p0, p1}, Lcom/aio/downloader/refresh/PullToRefreshLayout;->initView(Landroid/content/Context;)V

    .line 126
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v1, 0x0

    .line 129
    invoke-direct {p0, p1, p2}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 37
    iput v1, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->state:I

    .line 48
    const/4 v0, 0x0

    iput v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->pullDownY:F

    .line 51
    const/high16 v0, 0x43480000    # 200.0f

    iput v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->refreshDist:F

    .line 55
    const/high16 v0, 0x41000000    # 8.0f

    iput v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->MOVE_SPEED:F

    .line 57
    iput-boolean v1, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->isLayout:Z

    .line 59
    iput-boolean v1, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->isTouch:Z

    .line 61
    const/high16 v0, 0x40000000    # 2.0f

    iput v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->radio:F

    .line 87
    new-instance v0, Lcom/aio/downloader/refresh/PullToRefreshLayout$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/refresh/PullToRefreshLayout$1;-><init>(Lcom/aio/downloader/refresh/PullToRefreshLayout;)V

    iput-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->updateHandler:Landroid/os/Handler;

    .line 130
    invoke-direct {p0, p1}, Lcom/aio/downloader/refresh/PullToRefreshLayout;->initView(Landroid/content/Context;)V

    .line 131
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    const/4 v1, 0x0

    .line 134
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 37
    iput v1, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->state:I

    .line 48
    const/4 v0, 0x0

    iput v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->pullDownY:F

    .line 51
    const/high16 v0, 0x43480000    # 200.0f

    iput v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->refreshDist:F

    .line 55
    const/high16 v0, 0x41000000    # 8.0f

    iput v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->MOVE_SPEED:F

    .line 57
    iput-boolean v1, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->isLayout:Z

    .line 59
    iput-boolean v1, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->isTouch:Z

    .line 61
    const/high16 v0, 0x40000000    # 2.0f

    iput v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->radio:F

    .line 87
    new-instance v0, Lcom/aio/downloader/refresh/PullToRefreshLayout$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/refresh/PullToRefreshLayout$1;-><init>(Lcom/aio/downloader/refresh/PullToRefreshLayout;)V

    iput-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->updateHandler:Landroid/os/Handler;

    .line 135
    invoke-direct {p0, p1}, Lcom/aio/downloader/refresh/PullToRefreshLayout;->initView(Landroid/content/Context;)V

    .line 136
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/refresh/PullToRefreshLayout;)Z
    .locals 1

    .prologue
    .line 59
    iget-boolean v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->isTouch:Z

    return v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/refresh/PullToRefreshLayout;)I
    .locals 1

    .prologue
    .line 37
    iget v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->state:I

    return v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/refresh/PullToRefreshLayout;)F
    .locals 1

    .prologue
    .line 51
    iget v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->refreshDist:F

    return v0
.end method

.method static synthetic access$3(Lcom/aio/downloader/refresh/PullToRefreshLayout;)Lcom/aio/downloader/refresh/PullToRefreshLayout$MyTimer;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->timer:Lcom/aio/downloader/refresh/PullToRefreshLayout$MyTimer;

    return-object v0
.end method

.method static synthetic access$4(Lcom/aio/downloader/refresh/PullToRefreshLayout;)Landroid/view/View;
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->pullView:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$5(Lcom/aio/downloader/refresh/PullToRefreshLayout;I)V
    .locals 0

    .prologue
    .line 193
    invoke-direct {p0, p1}, Lcom/aio/downloader/refresh/PullToRefreshLayout;->changeState(I)V

    return-void
.end method

.method static synthetic access$6(Lcom/aio/downloader/refresh/PullToRefreshLayout;)V
    .locals 0

    .prologue
    .line 150
    invoke-direct {p0}, Lcom/aio/downloader/refresh/PullToRefreshLayout;->hide()V

    return-void
.end method

.method private changeState(I)V
    .locals 4
    .param p1, "to"    # I

    .prologue
    const/4 v3, 0x0

    .line 194
    iput p1, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->state:I

    .line 195
    iget v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->state:I

    packed-switch v0, :pswitch_data_0

    .line 221
    :goto_0
    return-void

    .line 198
    :pswitch_0
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->refreshStateImageView:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 199
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->refreshStateTextView:Landroid/widget/TextView;

    const v1, 0x7f0b005b

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 200
    iget-object v1, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->pullView:Landroid/view/View;

    .line 201
    invoke-virtual {p0}, Lcom/aio/downloader/refresh/PullToRefreshLayout;->getContext()Landroid/content/Context;

    move-result-object v0

    const v2, 0x7f04001c

    invoke-static {v0, v2}, Landroid/view/animation/AnimationUtils;->loadAnimation(Landroid/content/Context;I)Landroid/view/animation/Animation;

    move-result-object v0

    .line 200
    check-cast v0, Landroid/view/animation/RotateAnimation;

    invoke-virtual {v1, v0}, Landroid/view/View;->startAnimation(Landroid/view/animation/Animation;)V

    .line 202
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->pullView:Landroid/view/View;

    invoke-virtual {v0, v3}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0

    .line 206
    :pswitch_1
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->refreshStateTextView:Landroid/widget/TextView;

    const v1, 0x7f0b005c

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 207
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->pullView:Landroid/view/View;

    iget-object v1, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->rotateAnimation:Landroid/view/animation/RotateAnimation;

    invoke-virtual {v0, v1}, Landroid/view/View;->startAnimation(Landroid/view/animation/Animation;)V

    goto :goto_0

    .line 211
    :pswitch_2
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->pullView:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->clearAnimation()V

    .line 212
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->refreshingView:Landroid/view/View;

    invoke-virtual {v0, v3}, Landroid/view/View;->setVisibility(I)V

    .line 213
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->pullView:Landroid/view/View;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 214
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->refreshingView:Landroid/view/View;

    iget-object v1, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->refreshingAnimation:Landroid/view/animation/RotateAnimation;

    invoke-virtual {v0, v1}, Landroid/view/View;->startAnimation(Landroid/view/animation/Animation;)V

    .line 215
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->refreshStateTextView:Landroid/widget/TextView;

    const v1, 0x7f0b005d

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    goto :goto_0

    .line 195
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method private hide()V
    .locals 3

    .prologue
    .line 151
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->timer:Lcom/aio/downloader/refresh/PullToRefreshLayout$MyTimer;

    const-wide/16 v1, 0x5

    invoke-virtual {v0, v1, v2}, Lcom/aio/downloader/refresh/PullToRefreshLayout$MyTimer;->schedule(J)V

    .line 152
    return-void
.end method

.method private initView()V
    .locals 2

    .prologue
    .line 304
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->refreshView:Landroid/view/View;

    const v1, 0x7f07038a

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->pullView:Landroid/view/View;

    .line 305
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->refreshView:Landroid/view/View;

    .line 306
    const v1, 0x7f070388

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 305
    iput-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->refreshStateTextView:Landroid/widget/TextView;

    .line 307
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->refreshView:Landroid/view/View;

    const v1, 0x7f070386

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->refreshingView:Landroid/view/View;

    .line 308
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->refreshView:Landroid/view/View;

    const v1, 0x7f070389

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->refreshStateImageView:Landroid/view/View;

    .line 309
    return-void
.end method

.method private initView(Landroid/content/Context;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 139
    new-instance v1, Lcom/aio/downloader/refresh/PullToRefreshLayout$MyTimer;

    iget-object v2, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->updateHandler:Landroid/os/Handler;

    invoke-direct {v1, p0, v2}, Lcom/aio/downloader/refresh/PullToRefreshLayout$MyTimer;-><init>(Lcom/aio/downloader/refresh/PullToRefreshLayout;Landroid/os/Handler;)V

    iput-object v1, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->timer:Lcom/aio/downloader/refresh/PullToRefreshLayout$MyTimer;

    .line 141
    const v1, 0x7f04001b

    .line 140
    invoke-static {p1, v1}, Landroid/view/animation/AnimationUtils;->loadAnimation(Landroid/content/Context;I)Landroid/view/animation/Animation;

    move-result-object v1

    check-cast v1, Landroid/view/animation/RotateAnimation;

    iput-object v1, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->rotateAnimation:Landroid/view/animation/RotateAnimation;

    .line 143
    const v1, 0x7f04001d

    .line 142
    invoke-static {p1, v1}, Landroid/view/animation/AnimationUtils;->loadAnimation(Landroid/content/Context;I)Landroid/view/animation/Animation;

    move-result-object v1

    check-cast v1, Landroid/view/animation/RotateAnimation;

    iput-object v1, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->refreshingAnimation:Landroid/view/animation/RotateAnimation;

    .line 145
    new-instance v0, Landroid/view/animation/LinearInterpolator;

    invoke-direct {v0}, Landroid/view/animation/LinearInterpolator;-><init>()V

    .line 146
    .local v0, "lir":Landroid/view/animation/LinearInterpolator;
    iget-object v1, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->rotateAnimation:Landroid/view/animation/RotateAnimation;

    invoke-virtual {v1, v0}, Landroid/view/animation/RotateAnimation;->setInterpolator(Landroid/view/animation/Interpolator;)V

    .line 147
    iget-object v1, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->refreshingAnimation:Landroid/view/animation/RotateAnimation;

    invoke-virtual {v1, v0}, Landroid/view/animation/RotateAnimation;->setInterpolator(Landroid/view/animation/Interpolator;)V

    .line 148
    return-void
.end method


# virtual methods
.method public dispatchTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 11
    .param p1, "ev"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v10, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x0

    const/4 v9, 0x0

    const/4 v8, 0x1

    .line 230
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getActionMasked()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 298
    :cond_0
    :goto_0
    :pswitch_0
    invoke-super {p0, p1}, Landroid/widget/RelativeLayout;->dispatchTouchEvent(Landroid/view/MotionEvent;)Z

    .line 299
    return v8

    .line 232
    :pswitch_1
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v0

    iput v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->downY:F

    .line 233
    iget v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->downY:F

    iput v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->lastY:F

    .line 234
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->timer:Lcom/aio/downloader/refresh/PullToRefreshLayout$MyTimer;

    invoke-virtual {v0}, Lcom/aio/downloader/refresh/PullToRefreshLayout$MyTimer;->cancel()V

    .line 235
    iput v9, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->mEvents:I

    goto :goto_0

    .line 240
    :pswitch_2
    const/4 v0, -0x1

    iput v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->mEvents:I

    goto :goto_0

    .line 243
    :pswitch_3
    iget v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->mEvents:I

    if-nez v0, :cond_8

    .line 244
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->pullableView:Landroid/view/View;

    check-cast v0, Lcom/aio/downloader/refresh/Pullable;

    invoke-interface {v0}, Lcom/aio/downloader/refresh/Pullable;->canPullDown()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 247
    iget v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->pullDownY:F

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v1

    iget v2, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->lastY:F

    sub-float/2addr v1, v2

    iget v2, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->radio:F

    div-float/2addr v1, v2

    add-float/2addr v0, v1

    iput v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->pullDownY:F

    .line 248
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v0

    iget v1, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->lastY:F

    sub-float/2addr v0, v1

    cmpg-float v0, v0, v3

    if-gez v0, :cond_1

    .line 249
    iget v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->pullDownY:F

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v1

    iget v2, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->lastY:F

    sub-float/2addr v1, v2

    add-float/2addr v0, v1

    iput v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->pullDownY:F

    .line 251
    :cond_1
    iget v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->pullDownY:F

    cmpg-float v0, v0, v3

    if-gez v0, :cond_2

    .line 252
    iput v3, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->pullDownY:F

    .line 254
    :cond_2
    iget v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->pullDownY:F

    invoke-virtual {p0}, Lcom/aio/downloader/refresh/PullToRefreshLayout;->getMeasuredHeight()I

    move-result v1

    int-to-float v1, v1

    cmpl-float v0, v0, v1

    if-lez v0, :cond_3

    .line 255
    invoke-virtual {p0}, Lcom/aio/downloader/refresh/PullToRefreshLayout;->getMeasuredHeight()I

    move-result v0

    int-to-float v0, v0

    iput v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->pullDownY:F

    .line 256
    :cond_3
    iget v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->state:I

    if-ne v0, v4, :cond_4

    .line 258
    iput-boolean v8, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->isTouch:Z

    .line 263
    :cond_4
    :goto_1
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v0

    iput v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->lastY:F

    .line 265
    const-wide/high16 v0, 0x4000000000000000L    # 2.0

    const-wide/high16 v2, 0x4008000000000000L    # 3.0

    const-wide v4, 0x3ff921fb54442d18L    # 1.5707963267948966

    invoke-virtual {p0}, Lcom/aio/downloader/refresh/PullToRefreshLayout;->getMeasuredHeight()I

    move-result v6

    int-to-double v6, v6

    div-double/2addr v4, v6

    .line 266
    iget v6, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->pullDownY:F

    float-to-double v6, v6

    mul-double/2addr v4, v6

    .line 265
    invoke-static {v4, v5}, Ljava/lang/Math;->tan(D)D

    move-result-wide v4

    mul-double/2addr v2, v4

    add-double/2addr v0, v2

    double-to-float v0, v0

    iput v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->radio:F

    .line 267
    invoke-virtual {p0}, Lcom/aio/downloader/refresh/PullToRefreshLayout;->requestLayout()V

    .line 268
    iget v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->pullDownY:F

    iget v1, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->refreshDist:F

    cmpg-float v0, v0, v1

    if-gtz v0, :cond_6

    iget v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->state:I

    if-eq v0, v8, :cond_5

    iget v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->state:I

    if-ne v0, v10, :cond_6

    .line 270
    :cond_5
    invoke-direct {p0, v9}, Lcom/aio/downloader/refresh/PullToRefreshLayout;->changeState(I)V

    .line 272
    :cond_6
    iget v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->pullDownY:F

    iget v1, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->refreshDist:F

    cmpl-float v0, v0, v1

    if-ltz v0, :cond_7

    iget v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->state:I

    if-nez v0, :cond_7

    .line 274
    invoke-direct {p0, v8}, Lcom/aio/downloader/refresh/PullToRefreshLayout;->changeState(I)V

    .line 278
    :cond_7
    iget v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->pullDownY:F

    const/high16 v1, 0x41000000    # 8.0f

    cmpl-float v0, v0, v1

    if-lez v0, :cond_0

    .line 280
    invoke-virtual {p1, v10}, Landroid/view/MotionEvent;->setAction(I)V

    goto/16 :goto_0

    .line 262
    :cond_8
    iput v9, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->mEvents:I

    goto :goto_1

    .line 284
    :pswitch_4
    iget v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->pullDownY:F

    iget v1, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->refreshDist:F

    cmpl-float v0, v0, v1

    if-lez v0, :cond_9

    .line 286
    iput-boolean v9, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->isTouch:Z

    .line 287
    :cond_9
    iget v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->state:I

    if-ne v0, v8, :cond_a

    .line 288
    invoke-direct {p0, v4}, Lcom/aio/downloader/refresh/PullToRefreshLayout;->changeState(I)V

    .line 290
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->mListener:Lcom/aio/downloader/refresh/PullToRefreshLayout$OnRefreshListener;

    if-eqz v0, :cond_a

    .line 291
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->mListener:Lcom/aio/downloader/refresh/PullToRefreshLayout$OnRefreshListener;

    invoke-interface {v0, p0}, Lcom/aio/downloader/refresh/PullToRefreshLayout$OnRefreshListener;->onRefresh(Lcom/aio/downloader/refresh/PullToRefreshLayout;)V

    .line 293
    :cond_a
    invoke-direct {p0}, Lcom/aio/downloader/refresh/PullToRefreshLayout;->hide()V

    goto/16 :goto_0

    .line 230
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_4
        :pswitch_3
        :pswitch_0
        :pswitch_0
        :pswitch_2
        :pswitch_2
    .end packed-switch
.end method

.method protected onLayout(ZIIII)V
    .locals 6
    .param p1, "changed"    # Z
    .param p2, "l"    # I
    .param p3, "t"    # I
    .param p4, "r"    # I
    .param p5, "b"    # I

    .prologue
    const/4 v1, 0x1

    const/4 v5, 0x0

    .line 313
    iget-boolean v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->isLayout:Z

    if-nez v0, :cond_0

    .line 315
    invoke-virtual {p0, v5}, Lcom/aio/downloader/refresh/PullToRefreshLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->refreshView:Landroid/view/View;

    .line 316
    invoke-virtual {p0, v1}, Lcom/aio/downloader/refresh/PullToRefreshLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->pullableView:Landroid/view/View;

    .line 317
    iput-boolean v1, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->isLayout:Z

    .line 318
    invoke-direct {p0}, Lcom/aio/downloader/refresh/PullToRefreshLayout;->initView()V

    .line 319
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->refreshView:Landroid/view/View;

    check-cast v0, Landroid/view/ViewGroup;

    invoke-virtual {v0, v5}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 320
    invoke-virtual {v0}, Landroid/view/View;->getMeasuredHeight()I

    move-result v0

    int-to-float v0, v0

    .line 319
    iput v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->refreshDist:F

    .line 323
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->refreshView:Landroid/view/View;

    .line 324
    iget v1, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->pullDownY:F

    float-to-int v1, v1

    iget-object v2, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->refreshView:Landroid/view/View;

    invoke-virtual {v2}, Landroid/view/View;->getMeasuredHeight()I

    move-result v2

    sub-int/2addr v1, v2

    .line 325
    iget-object v2, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->refreshView:Landroid/view/View;

    invoke-virtual {v2}, Landroid/view/View;->getMeasuredWidth()I

    move-result v2

    iget v3, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->pullDownY:F

    float-to-int v3, v3

    .line 323
    invoke-virtual {v0, v5, v1, v2, v3}, Landroid/view/View;->layout(IIII)V

    .line 326
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->pullableView:Landroid/view/View;

    iget v1, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->pullDownY:F

    float-to-int v1, v1

    .line 327
    iget-object v2, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->pullableView:Landroid/view/View;

    invoke-virtual {v2}, Landroid/view/View;->getMeasuredWidth()I

    move-result v2

    iget v3, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->pullDownY:F

    float-to-int v3, v3

    .line 328
    iget-object v4, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->pullableView:Landroid/view/View;

    invoke-virtual {v4}, Landroid/view/View;->getMeasuredHeight()I

    move-result v4

    add-int/2addr v3, v4

    .line 326
    invoke-virtual {v0, v5, v1, v2, v3}, Landroid/view/View;->layout(IIII)V

    .line 329
    return-void
.end method

.method public refreshFinish(I)V
    .locals 4
    .param p1, "refreshResult"    # I

    .prologue
    const/4 v3, 0x0

    .line 162
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->refreshingView:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->clearAnimation()V

    .line 163
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->refreshingView:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 164
    packed-switch p1, :pswitch_data_0

    .line 175
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->refreshStateImageView:Landroid/view/View;

    invoke-virtual {v0, v3}, Landroid/view/View;->setVisibility(I)V

    .line 176
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->refreshStateTextView:Landroid/widget/TextView;

    const v1, 0x7f0b005f

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 177
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->refreshStateImageView:Landroid/view/View;

    .line 178
    const v1, 0x7f020168

    invoke-virtual {v0, v1}, Landroid/view/View;->setBackgroundResource(I)V

    .line 182
    :goto_0
    new-instance v0, Lcom/aio/downloader/refresh/PullToRefreshLayout$2;

    invoke-direct {v0, p0}, Lcom/aio/downloader/refresh/PullToRefreshLayout$2;-><init>(Lcom/aio/downloader/refresh/PullToRefreshLayout;)V

    .line 190
    const-wide/16 v1, 0x3e8

    invoke-virtual {v0, v3, v1, v2}, Lcom/aio/downloader/refresh/PullToRefreshLayout$2;->sendEmptyMessageDelayed(IJ)Z

    .line 191
    return-void

    .line 167
    :pswitch_0
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->refreshStateImageView:Landroid/view/View;

    invoke-virtual {v0, v3}, Landroid/view/View;->setVisibility(I)V

    .line 168
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->refreshStateTextView:Landroid/widget/TextView;

    const v1, 0x7f0b005e

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 169
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->refreshStateImageView:Landroid/view/View;

    .line 170
    const v1, 0x7f020169

    invoke-virtual {v0, v1}, Landroid/view/View;->setBackgroundResource(I)V

    goto :goto_0

    .line 164
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
    .end packed-switch
.end method

.method public setOnRefreshListener(Lcom/aio/downloader/refresh/PullToRefreshLayout$OnRefreshListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/aio/downloader/refresh/PullToRefreshLayout$OnRefreshListener;

    .prologue
    .line 120
    iput-object p1, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->mListener:Lcom/aio/downloader/refresh/PullToRefreshLayout$OnRefreshListener;

    .line 121
    return-void
.end method
