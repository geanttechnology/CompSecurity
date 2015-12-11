.class public Lit/sephiroth/android/library/widget/OverScroller;
.super Ljava/lang/Object;
.source "OverScroller.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;
    }
.end annotation


# static fields
.field private static sViscousFluidNormalize:F

.field private static sViscousFluidScale:F


# instance fields
.field private final mFlywheel:Z

.field private mInterpolator:Landroid/view/animation/Interpolator;

.field private mMode:I

.field private final mScrollerX:Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;

.field private final mScrollerY:Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    const/high16 v1, 0x3f800000    # 1.0f

    .line 51
    const/high16 v0, 0x41000000    # 8.0f

    sput v0, Lit/sephiroth/android/library/widget/OverScroller;->sViscousFluidScale:F

    .line 52
    sput v1, Lit/sephiroth/android/library/widget/OverScroller;->sViscousFluidNormalize:F

    .line 53
    invoke-static {v1}, Lit/sephiroth/android/library/widget/OverScroller;->viscousFluid(F)F

    move-result v0

    div-float v0, v1, v0

    sput v0, Lit/sephiroth/android/library/widget/OverScroller;->sViscousFluidNormalize:F

    .line 54
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 61
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lit/sephiroth/android/library/widget/OverScroller;-><init>(Landroid/content/Context;Landroid/view/animation/Interpolator;)V

    .line 62
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/view/animation/Interpolator;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "interpolator"    # Landroid/view/animation/Interpolator;

    .prologue
    .line 86
    const/4 v0, 0x1

    invoke-direct {p0, p1, p2, v0}, Lit/sephiroth/android/library/widget/OverScroller;-><init>(Landroid/content/Context;Landroid/view/animation/Interpolator;Z)V

    .line 87
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/view/animation/Interpolator;Z)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "interpolator"    # Landroid/view/animation/Interpolator;
    .param p3, "flywheel"    # Z

    .prologue
    .line 97
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 98
    iput-object p2, p0, Lit/sephiroth/android/library/widget/OverScroller;->mInterpolator:Landroid/view/animation/Interpolator;

    .line 99
    iput-boolean p3, p0, Lit/sephiroth/android/library/widget/OverScroller;->mFlywheel:Z

    .line 100
    new-instance v0, Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;

    invoke-direct {v0, p1}, Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lit/sephiroth/android/library/widget/OverScroller;->mScrollerX:Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;

    .line 101
    new-instance v0, Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;

    invoke-direct {v0, p1}, Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lit/sephiroth/android/library/widget/OverScroller;->mScrollerY:Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;

    .line 102
    return-void
.end method

.method public static viscousFluid(F)F
    .locals 5
    .param p0, "x"    # F

    .prologue
    const/high16 v4, 0x3f800000    # 1.0f

    .line 67
    sget v1, Lit/sephiroth/android/library/widget/OverScroller;->sViscousFluidScale:F

    mul-float/2addr p0, v1

    .line 68
    cmpg-float v1, p0, v4

    if-gez v1, :cond_0

    .line 69
    neg-float v1, p0

    float-to-double v2, v1

    invoke-static {v2, v3}, Ljava/lang/Math;->exp(D)D

    move-result-wide v2

    double-to-float v1, v2

    sub-float v1, v4, v1

    sub-float/2addr p0, v1

    .line 75
    :goto_0
    sget v1, Lit/sephiroth/android/library/widget/OverScroller;->sViscousFluidNormalize:F

    mul-float/2addr p0, v1

    .line 76
    return p0

    .line 71
    :cond_0
    const v0, 0x3ebc5ab2

    .line 72
    .local v0, "start":F
    sub-float v1, v4, p0

    float-to-double v2, v1

    invoke-static {v2, v3}, Ljava/lang/Math;->exp(D)D

    move-result-wide v2

    double-to-float v1, v2

    sub-float p0, v4, v1

    .line 73
    sub-float v1, v4, v0

    mul-float/2addr v1, p0

    add-float p0, v0, v1

    goto :goto_0
.end method


# virtual methods
.method public abortAnimation()V
    .locals 1

    .prologue
    .line 538
    iget-object v0, p0, Lit/sephiroth/android/library/widget/OverScroller;->mScrollerX:Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;

    invoke-virtual {v0}, Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;->finish()V

    .line 539
    iget-object v0, p0, Lit/sephiroth/android/library/widget/OverScroller;->mScrollerY:Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;

    invoke-virtual {v0}, Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;->finish()V

    .line 540
    return-void
.end method

.method public computeScrollOffset()Z
    .locals 8

    .prologue
    .line 317
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/OverScroller;->isFinished()Z

    move-result v6

    if-eqz v6, :cond_0

    .line 318
    const/4 v6, 0x0

    .line 365
    :goto_0
    return v6

    .line 321
    :cond_0
    iget v6, p0, Lit/sephiroth/android/library/widget/OverScroller;->mMode:I

    packed-switch v6, :pswitch_data_0

    .line 365
    :cond_1
    :goto_1
    const/4 v6, 0x1

    goto :goto_0

    .line 323
    :pswitch_0
    invoke-static {}, Landroid/view/animation/AnimationUtils;->currentAnimationTimeMillis()J

    move-result-wide v4

    .line 326
    .local v4, "time":J
    iget-object v6, p0, Lit/sephiroth/android/library/widget/OverScroller;->mScrollerX:Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;

    # getter for: Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;->mStartTime:J
    invoke-static {v6}, Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;->access$600(Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;)J

    move-result-wide v6

    sub-long v2, v4, v6

    .line 328
    .local v2, "elapsedTime":J
    iget-object v6, p0, Lit/sephiroth/android/library/widget/OverScroller;->mScrollerX:Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;

    # getter for: Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;->mDuration:I
    invoke-static {v6}, Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;->access$500(Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;)I

    move-result v0

    .line 329
    .local v0, "duration":I
    int-to-long v6, v0

    cmp-long v6, v2, v6

    if-gez v6, :cond_3

    .line 330
    long-to-float v6, v2

    int-to-float v7, v0

    div-float v1, v6, v7

    .line 332
    .local v1, "q":F
    iget-object v6, p0, Lit/sephiroth/android/library/widget/OverScroller;->mInterpolator:Landroid/view/animation/Interpolator;

    if-nez v6, :cond_2

    .line 333
    invoke-static {v1}, Lit/sephiroth/android/library/widget/OverScroller;->viscousFluid(F)F

    move-result v1

    .line 338
    :goto_2
    iget-object v6, p0, Lit/sephiroth/android/library/widget/OverScroller;->mScrollerX:Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;

    invoke-virtual {v6, v1}, Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;->updateScroll(F)V

    .line 339
    iget-object v6, p0, Lit/sephiroth/android/library/widget/OverScroller;->mScrollerY:Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;

    invoke-virtual {v6, v1}, Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;->updateScroll(F)V

    goto :goto_1

    .line 335
    :cond_2
    iget-object v6, p0, Lit/sephiroth/android/library/widget/OverScroller;->mInterpolator:Landroid/view/animation/Interpolator;

    invoke-interface {v6, v1}, Landroid/view/animation/Interpolator;->getInterpolation(F)F

    move-result v1

    goto :goto_2

    .line 341
    .end local v1    # "q":F
    :cond_3
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/OverScroller;->abortAnimation()V

    goto :goto_1

    .line 346
    .end local v0    # "duration":I
    .end local v2    # "elapsedTime":J
    .end local v4    # "time":J
    :pswitch_1
    iget-object v6, p0, Lit/sephiroth/android/library/widget/OverScroller;->mScrollerX:Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;

    # getter for: Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;->mFinished:Z
    invoke-static {v6}, Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;->access$000(Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;)Z

    move-result v6

    if-nez v6, :cond_4

    .line 347
    iget-object v6, p0, Lit/sephiroth/android/library/widget/OverScroller;->mScrollerX:Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;

    invoke-virtual {v6}, Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;->update()Z

    move-result v6

    if-nez v6, :cond_4

    .line 348
    iget-object v6, p0, Lit/sephiroth/android/library/widget/OverScroller;->mScrollerX:Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;

    invoke-virtual {v6}, Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;->continueWhenFinished()Z

    move-result v6

    if-nez v6, :cond_4

    .line 349
    iget-object v6, p0, Lit/sephiroth/android/library/widget/OverScroller;->mScrollerX:Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;

    invoke-virtual {v6}, Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;->finish()V

    .line 354
    :cond_4
    iget-object v6, p0, Lit/sephiroth/android/library/widget/OverScroller;->mScrollerY:Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;

    # getter for: Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;->mFinished:Z
    invoke-static {v6}, Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;->access$000(Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;)Z

    move-result v6

    if-nez v6, :cond_1

    .line 355
    iget-object v6, p0, Lit/sephiroth/android/library/widget/OverScroller;->mScrollerY:Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;

    invoke-virtual {v6}, Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;->update()Z

    move-result v6

    if-nez v6, :cond_1

    .line 356
    iget-object v6, p0, Lit/sephiroth/android/library/widget/OverScroller;->mScrollerY:Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;

    invoke-virtual {v6}, Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;->continueWhenFinished()Z

    move-result v6

    if-nez v6, :cond_1

    .line 357
    iget-object v6, p0, Lit/sephiroth/android/library/widget/OverScroller;->mScrollerY:Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;

    invoke-virtual {v6}, Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;->finish()V

    goto :goto_1

    .line 321
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public fling(IIIIIIII)V
    .locals 11
    .param p1, "startX"    # I
    .param p2, "startY"    # I
    .param p3, "velocityX"    # I
    .param p4, "velocityY"    # I
    .param p5, "minX"    # I
    .param p6, "maxX"    # I
    .param p7, "minY"    # I
    .param p8, "maxY"    # I

    .prologue
    .line 428
    const/4 v9, 0x0

    const/4 v10, 0x0

    move-object v0, p0

    move v1, p1

    move v2, p2

    move v3, p3

    move v4, p4

    move/from16 v5, p5

    move/from16 v6, p6

    move/from16 v7, p7

    move/from16 v8, p8

    invoke-virtual/range {v0 .. v10}, Lit/sephiroth/android/library/widget/OverScroller;->fling(IIIIIIIIII)V

    .line 429
    return-void
.end method

.method public fling(IIIIIIIIII)V
    .locals 8
    .param p1, "startX"    # I
    .param p2, "startY"    # I
    .param p3, "velocityX"    # I
    .param p4, "velocityY"    # I
    .param p5, "minX"    # I
    .param p6, "maxX"    # I
    .param p7, "minY"    # I
    .param p8, "maxY"    # I
    .param p9, "overX"    # I
    .param p10, "overY"    # I

    .prologue
    .line 461
    iget-boolean v0, p0, Lit/sephiroth/android/library/widget/OverScroller;->mFlywheel:Z

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/OverScroller;->isFinished()Z

    move-result v0

    if-nez v0, :cond_0

    .line 462
    iget-object v0, p0, Lit/sephiroth/android/library/widget/OverScroller;->mScrollerX:Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;

    # getter for: Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;->mCurrVelocity:F
    invoke-static {v0}, Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;->access$200(Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;)F

    move-result v6

    .line 463
    .local v6, "oldVelocityX":F
    iget-object v0, p0, Lit/sephiroth/android/library/widget/OverScroller;->mScrollerY:Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;

    # getter for: Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;->mCurrVelocity:F
    invoke-static {v0}, Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;->access$200(Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;)F

    move-result v7

    .line 464
    .local v7, "oldVelocityY":F
    int-to-float v0, p3

    invoke-static {v0}, Ljava/lang/Math;->signum(F)F

    move-result v0

    invoke-static {v6}, Ljava/lang/Math;->signum(F)F

    move-result v1

    cmpl-float v0, v0, v1

    if-nez v0, :cond_0

    int-to-float v0, p4

    invoke-static {v0}, Ljava/lang/Math;->signum(F)F

    move-result v0

    invoke-static {v7}, Ljava/lang/Math;->signum(F)F

    move-result v1

    cmpl-float v0, v0, v1

    if-nez v0, :cond_0

    .line 466
    int-to-float v0, p3

    add-float/2addr v0, v6

    float-to-int p3, v0

    .line 467
    int-to-float v0, p4

    add-float/2addr v0, v7

    float-to-int p4, v0

    .line 471
    .end local v6    # "oldVelocityX":F
    .end local v7    # "oldVelocityY":F
    :cond_0
    const/4 v0, 0x1

    iput v0, p0, Lit/sephiroth/android/library/widget/OverScroller;->mMode:I

    .line 472
    iget-object v0, p0, Lit/sephiroth/android/library/widget/OverScroller;->mScrollerX:Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;

    move v1, p1

    move v2, p3

    move v3, p5

    move v4, p6

    move/from16 v5, p9

    invoke-virtual/range {v0 .. v5}, Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;->fling(IIIII)V

    .line 473
    iget-object v0, p0, Lit/sephiroth/android/library/widget/OverScroller;->mScrollerY:Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;

    move v1, p2

    move v2, p4

    move v3, p7

    move/from16 v4, p8

    move/from16 v5, p10

    invoke-virtual/range {v0 .. v5}, Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;->fling(IIIII)V

    .line 474
    return-void
.end method

.method public getCurrVelocity()F
    .locals 3

    .prologue
    .line 201
    iget-object v1, p0, Lit/sephiroth/android/library/widget/OverScroller;->mScrollerX:Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;

    # getter for: Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;->mCurrVelocity:F
    invoke-static {v1}, Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;->access$200(Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;)F

    move-result v1

    iget-object v2, p0, Lit/sephiroth/android/library/widget/OverScroller;->mScrollerX:Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;

    # getter for: Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;->mCurrVelocity:F
    invoke-static {v2}, Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;->access$200(Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;)F

    move-result v2

    mul-float v0, v1, v2

    .line 202
    .local v0, "squaredNorm":F
    iget-object v1, p0, Lit/sephiroth/android/library/widget/OverScroller;->mScrollerY:Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;

    # getter for: Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;->mCurrVelocity:F
    invoke-static {v1}, Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;->access$200(Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;)F

    move-result v1

    iget-object v2, p0, Lit/sephiroth/android/library/widget/OverScroller;->mScrollerY:Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;

    # getter for: Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;->mCurrVelocity:F
    invoke-static {v2}, Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;->access$200(Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;)F

    move-result v2

    mul-float/2addr v1, v2

    add-float/2addr v0, v1

    .line 203
    invoke-static {v0}, Landroid/util/FloatMath;->sqrt(F)F

    move-result v1

    return v1
.end method

.method public final getCurrX()I
    .locals 1

    .prologue
    .line 183
    iget-object v0, p0, Lit/sephiroth/android/library/widget/OverScroller;->mScrollerX:Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;

    # getter for: Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;->mCurrentPosition:I
    invoke-static {v0}, Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;->access$100(Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;)I

    move-result v0

    return v0
.end method

.method public final isFinished()Z
    .locals 1

    .prologue
    .line 162
    iget-object v0, p0, Lit/sephiroth/android/library/widget/OverScroller;->mScrollerX:Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;

    # getter for: Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;->mFinished:Z
    invoke-static {v0}, Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;->access$000(Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lit/sephiroth/android/library/widget/OverScroller;->mScrollerY:Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;

    # getter for: Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;->mFinished:Z
    invoke-static {v0}, Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;->access$000(Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isScrollingInDirection(FF)Z
    .locals 4
    .param p1, "xvel"    # F
    .param p2, "yvel"    # F

    .prologue
    .line 559
    iget-object v2, p0, Lit/sephiroth/android/library/widget/OverScroller;->mScrollerX:Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;

    # getter for: Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;->mFinal:I
    invoke-static {v2}, Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;->access$400(Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;)I

    move-result v2

    iget-object v3, p0, Lit/sephiroth/android/library/widget/OverScroller;->mScrollerX:Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;

    # getter for: Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;->mStart:I
    invoke-static {v3}, Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;->access$300(Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;)I

    move-result v3

    sub-int v0, v2, v3

    .line 560
    .local v0, "dx":I
    iget-object v2, p0, Lit/sephiroth/android/library/widget/OverScroller;->mScrollerY:Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;

    # getter for: Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;->mFinal:I
    invoke-static {v2}, Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;->access$400(Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;)I

    move-result v2

    iget-object v3, p0, Lit/sephiroth/android/library/widget/OverScroller;->mScrollerY:Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;

    # getter for: Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;->mStart:I
    invoke-static {v3}, Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;->access$300(Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;)I

    move-result v3

    sub-int v1, v2, v3

    .line 561
    .local v1, "dy":I
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/OverScroller;->isFinished()Z

    move-result v2

    if-nez v2, :cond_0

    invoke-static {p1}, Ljava/lang/Math;->signum(F)F

    move-result v2

    int-to-float v3, v0

    invoke-static {v3}, Ljava/lang/Math;->signum(F)F

    move-result v3

    cmpl-float v2, v2, v3

    if-nez v2, :cond_0

    invoke-static {p2}, Ljava/lang/Math;->signum(F)F

    move-result v2

    int-to-float v3, v1

    invoke-static {v3}, Ljava/lang/Math;->signum(F)F

    move-result v3

    cmpl-float v2, v2, v3

    if-nez v2, :cond_0

    const/4 v2, 0x1

    :goto_0
    return v2

    :cond_0
    const/4 v2, 0x0

    goto :goto_0
.end method

.method public notifyHorizontalEdgeReached(III)V
    .locals 1
    .param p1, "startX"    # I
    .param p2, "finalX"    # I
    .param p3, "overX"    # I

    .prologue
    .line 490
    iget-object v0, p0, Lit/sephiroth/android/library/widget/OverScroller;->mScrollerX:Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;

    invoke-virtual {v0, p1, p2, p3}, Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;->notifyEdgeReached(III)V

    .line 491
    return-void
.end method

.method public final setFriction(F)V
    .locals 1
    .param p1, "friction"    # F

    .prologue
    .line 151
    iget-object v0, p0, Lit/sephiroth/android/library/widget/OverScroller;->mScrollerX:Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;

    invoke-virtual {v0, p1}, Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;->setFriction(F)V

    .line 152
    iget-object v0, p0, Lit/sephiroth/android/library/widget/OverScroller;->mScrollerY:Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;

    invoke-virtual {v0, p1}, Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;->setFriction(F)V

    .line 153
    return-void
.end method

.method setInterpolator(Landroid/view/animation/Interpolator;)V
    .locals 0
    .param p1, "interpolator"    # Landroid/view/animation/Interpolator;

    .prologue
    .line 140
    iput-object p1, p0, Lit/sephiroth/android/library/widget/OverScroller;->mInterpolator:Landroid/view/animation/Interpolator;

    .line 141
    return-void
.end method

.method public springBack(IIIIII)Z
    .locals 4
    .param p1, "startX"    # I
    .param p2, "startY"    # I
    .param p3, "minX"    # I
    .param p4, "maxX"    # I
    .param p5, "minY"    # I
    .param p6, "maxY"    # I

    .prologue
    const/4 v2, 0x1

    .line 418
    iput v2, p0, Lit/sephiroth/android/library/widget/OverScroller;->mMode:I

    .line 421
    iget-object v3, p0, Lit/sephiroth/android/library/widget/OverScroller;->mScrollerX:Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;

    invoke-virtual {v3, p1, p3, p4}, Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;->springback(III)Z

    move-result v0

    .line 422
    .local v0, "spingbackX":Z
    iget-object v3, p0, Lit/sephiroth/android/library/widget/OverScroller;->mScrollerY:Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;

    invoke-virtual {v3, p2, p5, p6}, Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;->springback(III)Z

    move-result v1

    .line 423
    .local v1, "spingbackY":Z
    if-nez v0, :cond_0

    if-eqz v1, :cond_1

    :cond_0
    :goto_0
    return v2

    :cond_1
    const/4 v2, 0x0

    goto :goto_0
.end method

.method public startScroll(IIIII)V
    .locals 1
    .param p1, "startX"    # I
    .param p2, "startY"    # I
    .param p3, "dx"    # I
    .param p4, "dy"    # I
    .param p5, "duration"    # I

    .prologue
    .line 400
    const/4 v0, 0x0

    iput v0, p0, Lit/sephiroth/android/library/widget/OverScroller;->mMode:I

    .line 401
    iget-object v0, p0, Lit/sephiroth/android/library/widget/OverScroller;->mScrollerX:Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;

    invoke-virtual {v0, p1, p3, p5}, Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;->startScroll(III)V

    .line 402
    iget-object v0, p0, Lit/sephiroth/android/library/widget/OverScroller;->mScrollerY:Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;

    invoke-virtual {v0, p2, p4, p5}, Lit/sephiroth/android/library/widget/OverScroller$SplineOverScroller;->startScroll(III)V

    .line 403
    return-void
.end method
