.class public Lco/vine/android/widget/CounterView;
.super Landroid/view/View;
.source "CounterView.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/widget/CounterView$DigitAnimation;,
        Lco/vine/android/widget/CounterView$AnimationMode;
    }
.end annotation


# static fields
.field private static final ANIMATION_DURATION_MAX:I

.field private static final ANIMATION_DURATION_MIN:I

.field private static final DIGIT_SPACING_X:I = 0x3

.field private static final DIGIT_SPACING_Y:I = 0x3

.field private static final FRAME_DELAY:I = 0x14

.field private static final K_INDEX:I = 0xa

.field private static final K_SEPARATOR:Ljava/lang/String; = ","

.field private static final NO_ANIMATE_TO_NEXT_NUMBER:Z = false

.field private static final TAG:Ljava/lang/String; = "CounterView"


# instance fields
.field private mAnimationMode:Lco/vine/android/widget/CounterView$AnimationMode;

.field private mBounds:[Landroid/graphics/Rect;

.field private volatile mCanAnimate:Z

.field private final mDigitAnimations:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/widget/CounterView$DigitAnimation;",
            ">;"
        }
    .end annotation
.end field

.field private mDrawingCount:J

.field private mExtraCount:J

.field private mIsPaused:Z

.field private mKnownCount:J

.field private mKnownCountRefreshTime:J

.field private final mLOCK:[I

.field private mLastAnimationTime:J

.field private mLastDigitCount:I

.field private mLastPrint:Ljava/lang/String;

.field private mMaxAnimationSeparation:J

.field private mMaxTextHeight:I

.field private mMaxTextWidth:I

.field private mMinAnimationSeparation:J

.field private final mPaint:Landroid/graphics/Paint;

.field private mVelocityPerMS:D


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    .line 27
    sget-object v0, Ljava/util/concurrent/TimeUnit;->NANOSECONDS:Ljava/util/concurrent/TimeUnit;

    const-wide/16 v1, 0x96

    sget-object v3, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v0, v1, v2, v3}, Ljava/util/concurrent/TimeUnit;->convert(JLjava/util/concurrent/TimeUnit;)J

    move-result-wide v0

    long-to-int v0, v0

    sput v0, Lco/vine/android/widget/CounterView;->ANIMATION_DURATION_MAX:I

    .line 28
    sget-object v0, Ljava/util/concurrent/TimeUnit;->NANOSECONDS:Ljava/util/concurrent/TimeUnit;

    const-wide/16 v1, 0x14

    sget-object v3, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v0, v1, v2, v3}, Ljava/util/concurrent/TimeUnit;->convert(JLjava/util/concurrent/TimeUnit;)J

    move-result-wide v0

    long-to-int v0, v0

    sput v0, Lco/vine/android/widget/CounterView;->ANIMATION_DURATION_MIN:I

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v2, 0x0

    .line 163
    invoke-direct {p0, p1}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    .line 43
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lco/vine/android/widget/CounterView;->mDigitAnimations:Ljava/util/ArrayList;

    .line 46
    new-instance v0, Lco/vine/android/widget/CounterView$AnimationMode;

    const/4 v1, 0x1

    invoke-direct {v0, v2, v2, v1}, Lco/vine/android/widget/CounterView$AnimationMode;-><init>(ZZZ)V

    iput-object v0, p0, Lco/vine/android/widget/CounterView;->mAnimationMode:Lco/vine/android/widget/CounterView$AnimationMode;

    .line 50
    new-array v0, v2, [I

    iput-object v0, p0, Lco/vine/android/widget/CounterView;->mLOCK:[I

    .line 164
    invoke-direct {p0}, Lco/vine/android/widget/CounterView;->init()Landroid/graphics/Paint;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/widget/CounterView;->mPaint:Landroid/graphics/Paint;

    .line 165
    invoke-direct {p0}, Lco/vine/android/widget/CounterView;->updateTextSizes()V

    .line 166
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v2, 0x0

    .line 209
    invoke-direct {p0, p1, p2}, Landroid/view/View;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 43
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lco/vine/android/widget/CounterView;->mDigitAnimations:Ljava/util/ArrayList;

    .line 46
    new-instance v0, Lco/vine/android/widget/CounterView$AnimationMode;

    const/4 v1, 0x1

    invoke-direct {v0, v2, v2, v1}, Lco/vine/android/widget/CounterView$AnimationMode;-><init>(ZZZ)V

    iput-object v0, p0, Lco/vine/android/widget/CounterView;->mAnimationMode:Lco/vine/android/widget/CounterView$AnimationMode;

    .line 50
    new-array v0, v2, [I

    iput-object v0, p0, Lco/vine/android/widget/CounterView;->mLOCK:[I

    .line 210
    invoke-direct {p0}, Lco/vine/android/widget/CounterView;->init()Landroid/graphics/Paint;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/widget/CounterView;->mPaint:Landroid/graphics/Paint;

    .line 211
    invoke-direct {p0}, Lco/vine/android/widget/CounterView;->updateTextSizes()V

    .line 212
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    const/4 v2, 0x0

    .line 215
    invoke-direct {p0, p1, p2, p3}, Landroid/view/View;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 43
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lco/vine/android/widget/CounterView;->mDigitAnimations:Ljava/util/ArrayList;

    .line 46
    new-instance v0, Lco/vine/android/widget/CounterView$AnimationMode;

    const/4 v1, 0x1

    invoke-direct {v0, v2, v2, v1}, Lco/vine/android/widget/CounterView$AnimationMode;-><init>(ZZZ)V

    iput-object v0, p0, Lco/vine/android/widget/CounterView;->mAnimationMode:Lco/vine/android/widget/CounterView$AnimationMode;

    .line 50
    new-array v0, v2, [I

    iput-object v0, p0, Lco/vine/android/widget/CounterView;->mLOCK:[I

    .line 216
    invoke-direct {p0}, Lco/vine/android/widget/CounterView;->init()Landroid/graphics/Paint;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/widget/CounterView;->mPaint:Landroid/graphics/Paint;

    .line 217
    invoke-direct {p0}, Lco/vine/android/widget/CounterView;->updateTextSizes()V

    .line 218
    return-void
.end method

.method static synthetic access$000(Lco/vine/android/widget/CounterView;)Lco/vine/android/widget/CounterView$AnimationMode;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/widget/CounterView;

    .prologue
    .line 19
    iget-object v0, p0, Lco/vine/android/widget/CounterView;->mAnimationMode:Lco/vine/android/widget/CounterView$AnimationMode;

    return-object v0
.end method

.method static synthetic access$100()I
    .locals 1

    .prologue
    .line 19
    sget v0, Lco/vine/android/widget/CounterView;->ANIMATION_DURATION_MAX:I

    return v0
.end method

.method static synthetic access$200()I
    .locals 1

    .prologue
    .line 19
    sget v0, Lco/vine/android/widget/CounterView;->ANIMATION_DURATION_MIN:I

    return v0
.end method

.method private getIntrinsicHeightForDigit(II)I
    .locals 1
    .param p1, "measuredHeight"    # I
    .param p2, "digit"    # I

    .prologue
    .line 370
    iget-object v0, p0, Lco/vine/android/widget/CounterView;->mBounds:[Landroid/graphics/Rect;

    aget-object v0, v0, p2

    invoke-virtual {v0}, Landroid/graphics/Rect;->height()I

    move-result v0

    add-int/2addr v0, p1

    shr-int/lit8 v0, v0, 0x1

    return v0
.end method

.method private init()Landroid/graphics/Paint;
    .locals 4

    .prologue
    .line 169
    new-instance v0, Landroid/graphics/Paint;

    const/16 v1, 0x41

    invoke-direct {v0, v1}, Landroid/graphics/Paint;-><init>(I)V

    .line 170
    .local v0, "paint":Landroid/graphics/Paint;
    const/16 v1, 0xb

    new-array v1, v1, [Landroid/graphics/Rect;

    const/4 v2, 0x0

    new-instance v3, Landroid/graphics/Rect;

    invoke-direct {v3}, Landroid/graphics/Rect;-><init>()V

    aput-object v3, v1, v2

    const/4 v2, 0x1

    new-instance v3, Landroid/graphics/Rect;

    invoke-direct {v3}, Landroid/graphics/Rect;-><init>()V

    aput-object v3, v1, v2

    const/4 v2, 0x2

    new-instance v3, Landroid/graphics/Rect;

    invoke-direct {v3}, Landroid/graphics/Rect;-><init>()V

    aput-object v3, v1, v2

    const/4 v2, 0x3

    new-instance v3, Landroid/graphics/Rect;

    invoke-direct {v3}, Landroid/graphics/Rect;-><init>()V

    aput-object v3, v1, v2

    const/4 v2, 0x4

    new-instance v3, Landroid/graphics/Rect;

    invoke-direct {v3}, Landroid/graphics/Rect;-><init>()V

    aput-object v3, v1, v2

    const/4 v2, 0x5

    new-instance v3, Landroid/graphics/Rect;

    invoke-direct {v3}, Landroid/graphics/Rect;-><init>()V

    aput-object v3, v1, v2

    const/4 v2, 0x6

    new-instance v3, Landroid/graphics/Rect;

    invoke-direct {v3}, Landroid/graphics/Rect;-><init>()V

    aput-object v3, v1, v2

    const/4 v2, 0x7

    new-instance v3, Landroid/graphics/Rect;

    invoke-direct {v3}, Landroid/graphics/Rect;-><init>()V

    aput-object v3, v1, v2

    const/16 v2, 0x8

    new-instance v3, Landroid/graphics/Rect;

    invoke-direct {v3}, Landroid/graphics/Rect;-><init>()V

    aput-object v3, v1, v2

    const/16 v2, 0x9

    new-instance v3, Landroid/graphics/Rect;

    invoke-direct {v3}, Landroid/graphics/Rect;-><init>()V

    aput-object v3, v1, v2

    const/16 v2, 0xa

    new-instance v3, Landroid/graphics/Rect;

    invoke-direct {v3}, Landroid/graphics/Rect;-><init>()V

    aput-object v3, v1, v2

    iput-object v1, p0, Lco/vine/android/widget/CounterView;->mBounds:[Landroid/graphics/Rect;

    .line 183
    const/high16 v1, 0x42000000    # 32.0f

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setTextSize(F)V

    .line 184
    const/high16 v1, -0x1000000

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 185
    sget-object v1, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 186
    sget-object v1, Landroid/graphics/Paint$Align;->RIGHT:Landroid/graphics/Paint$Align;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setTextAlign(Landroid/graphics/Paint$Align;)V

    .line 187
    return-object v0
.end method

.method private invalidateDigitSize(Z)V
    .locals 25
    .param p1, "forceDigitSizeRecal"    # Z

    .prologue
    .line 386
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/widget/CounterView;->mLOCK:[I

    move-object/from16 v22, v0

    monitor-enter v22

    .line 387
    :try_start_0
    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/widget/CounterView;->mDigitAnimations:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v4

    if-nez v4, :cond_0

    .line 388
    move-object/from16 v0, p0

    iget-object v11, v0, Lco/vine/android/widget/CounterView;->mDigitAnimations:Ljava/util/ArrayList;

    new-instance v4, Lco/vine/android/widget/CounterView$DigitAnimation;

    const/4 v6, 0x0

    move-object/from16 v0, p0

    iget-wide v7, v0, Lco/vine/android/widget/CounterView;->mVelocityPerMS:D

    move-object/from16 v0, p0

    iget-wide v9, v0, Lco/vine/android/widget/CounterView;->mDrawingCount:J

    move-object/from16 v5, p0

    invoke-direct/range {v4 .. v10}, Lco/vine/android/widget/CounterView$DigitAnimation;-><init>(Lco/vine/android/widget/CounterView;IDJ)V

    invoke-virtual {v11, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 390
    :cond_0
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/widget/CounterView;->getCount()J

    move-result-wide v4

    move-object/from16 v0, p0

    iget-wide v8, v0, Lco/vine/android/widget/CounterView;->mExtraCount:J

    add-long v13, v4, v8

    .line 391
    .local v13, "currentCount":J
    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v15

    .line 392
    .local v15, "currentTime":J
    move-object/from16 v0, p0

    iget-wide v4, v0, Lco/vine/android/widget/CounterView;->mDrawingCount:J

    invoke-static {v4, v5}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v19

    .line 393
    .local v19, "digitCount":I
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    move-object/from16 v0, p0

    iget-wide v8, v0, Lco/vine/android/widget/CounterView;->mLastAnimationTime:J

    sub-long v17, v4, v8

    .line 394
    .local v17, "diffTimeMs":J
    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/widget/CounterView;->mDigitAnimations:Ljava/util/ArrayList;

    const/4 v5, 0x0

    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/widget/CounterView$DigitAnimation;

    iget-wide v4, v4, Lco/vine/android/widget/CounterView$DigitAnimation;->mAnimatingCount:J

    cmp-long v4, v13, v4

    if-lez v4, :cond_4

    const/4 v12, 0x1

    .line 395
    .local v12, "shouldAnimateNext":Z
    :goto_0
    if-nez p1, :cond_1

    move-object/from16 v0, p0

    iget-wide v4, v0, Lco/vine/android/widget/CounterView;->mMinAnimationSeparation:J

    cmp-long v4, v17, v4

    if-ltz v4, :cond_8

    move-object/from16 v0, p0

    iget-boolean v4, v0, Lco/vine/android/widget/CounterView;->mCanAnimate:Z

    if-nez v4, :cond_1

    move-object/from16 v0, p0

    iget-wide v4, v0, Lco/vine/android/widget/CounterView;->mMaxAnimationSeparation:J

    cmp-long v4, v17, v4

    if-ltz v4, :cond_8

    .line 398
    :cond_1
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    move-object/from16 v0, p0

    iput-wide v4, v0, Lco/vine/android/widget/CounterView;->mLastAnimationTime:J

    .line 399
    const/4 v6, 0x0

    .line 400
    .local v6, "i":I
    const-wide/16 v20, 0x0

    .line 401
    .local v20, "newDrawingCount":J
    :goto_1
    move/from16 v0, v19

    if-lt v6, v0, :cond_2

    if-eqz v12, :cond_6

    .line 402
    :cond_2
    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/widget/CounterView;->mDigitAnimations:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v4

    if-gt v4, v6, :cond_3

    .line 403
    move-object/from16 v0, p0

    iget-object v11, v0, Lco/vine/android/widget/CounterView;->mDigitAnimations:Ljava/util/ArrayList;

    new-instance v4, Lco/vine/android/widget/CounterView$DigitAnimation;

    move-object/from16 v0, p0

    iget-wide v7, v0, Lco/vine/android/widget/CounterView;->mVelocityPerMS:D

    move-object/from16 v0, p0

    iget-wide v9, v0, Lco/vine/android/widget/CounterView;->mDrawingCount:J

    move-object/from16 v5, p0

    invoke-direct/range {v4 .. v10}, Lco/vine/android/widget/CounterView$DigitAnimation;-><init>(Lco/vine/android/widget/CounterView;IDJ)V

    invoke-virtual {v11, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 405
    :cond_3
    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/widget/CounterView;->mDigitAnimations:Ljava/util/ArrayList;

    invoke-virtual {v4, v6}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lco/vine/android/widget/CounterView$DigitAnimation;

    .local v7, "digitAnim":Lco/vine/android/widget/CounterView$DigitAnimation;
    move-wide v8, v15

    move-wide v10, v13

    .line 406
    invoke-virtual/range {v7 .. v12}, Lco/vine/android/widget/CounterView$DigitAnimation;->invalidate(JJZ)Z

    move-result v12

    .line 410
    move-wide/from16 v0, v20

    long-to-double v8, v0

    if-nez v6, :cond_5

    iget v4, v7, Lco/vine/android/widget/CounterView$DigitAnimation;->mDrawingDigit:I

    int-to-double v4, v4

    :goto_2
    add-double/2addr v4, v8

    double-to-long v0, v4

    move-wide/from16 v20, v0

    .line 411
    add-int/lit8 v6, v6, 0x1

    .line 412
    goto :goto_1

    .line 394
    .end local v6    # "i":I
    .end local v7    # "digitAnim":Lco/vine/android/widget/CounterView$DigitAnimation;
    .end local v12    # "shouldAnimateNext":Z
    .end local v20    # "newDrawingCount":J
    :cond_4
    const/4 v12, 0x0

    goto :goto_0

    .line 410
    .restart local v6    # "i":I
    .restart local v7    # "digitAnim":Lco/vine/android/widget/CounterView$DigitAnimation;
    .restart local v12    # "shouldAnimateNext":Z
    .restart local v20    # "newDrawingCount":J
    :cond_5
    iget v4, v7, Lco/vine/android/widget/CounterView$DigitAnimation;->mDrawingDigit:I

    int-to-double v4, v4

    const-wide/high16 v10, 0x4024000000000000L    # 10.0

    int-to-double v0, v6

    move-wide/from16 v23, v0

    move-wide/from16 v0, v23

    invoke-static {v10, v11, v0, v1}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v10

    mul-double/2addr v4, v10

    goto :goto_2

    .line 413
    .end local v7    # "digitAnim":Lco/vine/android/widget/CounterView$DigitAnimation;
    :cond_6
    move-object/from16 v0, p0

    move-wide/from16 v1, v20

    move/from16 v3, p1

    invoke-direct {v0, v1, v2, v3}, Lco/vine/android/widget/CounterView;->setDrawingCount(JZ)V

    .line 414
    move-object/from16 v0, p0

    iget v4, v0, Lco/vine/android/widget/CounterView;->mLastDigitCount:I

    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/widget/CounterView;->mDigitAnimations:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v5

    if-eq v4, v5, :cond_7

    .line 415
    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/widget/CounterView;->mDigitAnimations:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v4

    move-object/from16 v0, p0

    iput v4, v0, Lco/vine/android/widget/CounterView;->mLastDigitCount:I

    .line 416
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/widget/CounterView;->requestLayout()V

    .line 418
    :cond_7
    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/widget/CounterView;->mAnimationMode:Lco/vine/android/widget/CounterView$AnimationMode;

    iget-boolean v4, v4, Lco/vine/android/widget/CounterView$AnimationMode;->continuousAnimation:Z

    if-nez v4, :cond_8

    .line 419
    const/4 v4, 0x0

    move-object/from16 v0, p0

    iput-boolean v4, v0, Lco/vine/android/widget/CounterView;->mCanAnimate:Z

    .line 422
    .end local v6    # "i":I
    .end local v20    # "newDrawingCount":J
    :cond_8
    monitor-exit v22

    .line 423
    return-void

    .line 422
    .end local v12    # "shouldAnimateNext":Z
    .end local v13    # "currentCount":J
    .end local v15    # "currentTime":J
    .end local v17    # "diffTimeMs":J
    .end local v19    # "digitCount":I
    :catchall_0
    move-exception v4

    monitor-exit v22
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v4
.end method

.method private setDrawingCount(JZ)V
    .locals 0
    .param p1, "newDrawingCount"    # J
    .param p3, "invalidation"    # Z

    .prologue
    .line 426
    iput-wide p1, p0, Lco/vine/android/widget/CounterView;->mDrawingCount:J

    .line 427
    return-void
.end method

.method private updateTextSizes()V
    .locals 6

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 191
    iput v4, p0, Lco/vine/android/widget/CounterView;->mMaxTextWidth:I

    .line 192
    iput v4, p0, Lco/vine/android/widget/CounterView;->mMaxTextHeight:I

    .line 193
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v1, p0, Lco/vine/android/widget/CounterView;->mBounds:[Landroid/graphics/Rect;

    array-length v1, v1

    if-ge v0, v1, :cond_3

    .line 194
    const/16 v1, 0xa

    if-eq v0, v1, :cond_2

    .line 195
    iget-object v1, p0, Lco/vine/android/widget/CounterView;->mPaint:Landroid/graphics/Paint;

    invoke-static {v0}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lco/vine/android/widget/CounterView;->mBounds:[Landroid/graphics/Rect;

    aget-object v3, v3, v0

    invoke-virtual {v1, v2, v4, v5, v3}, Landroid/graphics/Paint;->getTextBounds(Ljava/lang/String;IILandroid/graphics/Rect;)V

    .line 199
    :goto_1
    iget v1, p0, Lco/vine/android/widget/CounterView;->mMaxTextWidth:I

    iget-object v2, p0, Lco/vine/android/widget/CounterView;->mBounds:[Landroid/graphics/Rect;

    aget-object v2, v2, v0

    invoke-virtual {v2}, Landroid/graphics/Rect;->width()I

    move-result v2

    if-ge v1, v2, :cond_0

    .line 200
    iget-object v1, p0, Lco/vine/android/widget/CounterView;->mBounds:[Landroid/graphics/Rect;

    aget-object v1, v1, v0

    invoke-virtual {v1}, Landroid/graphics/Rect;->width()I

    move-result v1

    iput v1, p0, Lco/vine/android/widget/CounterView;->mMaxTextWidth:I

    .line 202
    :cond_0
    iget v1, p0, Lco/vine/android/widget/CounterView;->mMaxTextHeight:I

    iget-object v2, p0, Lco/vine/android/widget/CounterView;->mBounds:[Landroid/graphics/Rect;

    aget-object v2, v2, v0

    invoke-virtual {v2}, Landroid/graphics/Rect;->height()I

    move-result v2

    if-ge v1, v2, :cond_1

    .line 203
    iget-object v1, p0, Lco/vine/android/widget/CounterView;->mBounds:[Landroid/graphics/Rect;

    aget-object v1, v1, v0

    invoke-virtual {v1}, Landroid/graphics/Rect;->height()I

    move-result v1

    iput v1, p0, Lco/vine/android/widget/CounterView;->mMaxTextHeight:I

    .line 193
    :cond_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 197
    :cond_2
    iget-object v1, p0, Lco/vine/android/widget/CounterView;->mPaint:Landroid/graphics/Paint;

    const-string v2, ","

    iget-object v3, p0, Lco/vine/android/widget/CounterView;->mBounds:[Landroid/graphics/Rect;

    aget-object v3, v3, v0

    invoke-virtual {v1, v2, v4, v5, v3}, Landroid/graphics/Paint;->getTextBounds(Ljava/lang/String;IILandroid/graphics/Rect;)V

    goto :goto_1

    .line 206
    :cond_3
    return-void
.end method


# virtual methods
.method public adjustExtraCount(J)V
    .locals 0
    .param p1, "extraCount"    # J

    .prologue
    .line 382
    iput-wide p1, p0, Lco/vine/android/widget/CounterView;->mExtraCount:J

    .line 383
    return-void
.end method

.method public getCount()J
    .locals 8

    .prologue
    .line 268
    iget-wide v0, p0, Lco/vine/android/widget/CounterView;->mKnownCount:J

    long-to-double v2, v0

    iget-wide v0, p0, Lco/vine/android/widget/CounterView;->mKnownCountRefreshTime:J

    const-wide/16 v4, 0x0

    cmp-long v0, v0, v4

    if-lez v0, :cond_0

    iget-wide v0, p0, Lco/vine/android/widget/CounterView;->mVelocityPerMS:D

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    iget-wide v6, p0, Lco/vine/android/widget/CounterView;->mKnownCountRefreshTime:J

    sub-long/2addr v4, v6

    long-to-double v4, v4

    mul-double/2addr v0, v4

    :goto_0
    add-double/2addr v0, v2

    double-to-long v0, v0

    return-wide v0

    :cond_0
    const-wide/16 v0, 0x0

    goto :goto_0
.end method

.method public incrementExtraCount(I)V
    .locals 4
    .param p1, "n"    # I

    .prologue
    .line 67
    iget-wide v0, p0, Lco/vine/android/widget/CounterView;->mExtraCount:J

    int-to-long v2, p1

    add-long/2addr v0, v2

    invoke-virtual {p0, v0, v1}, Lco/vine/android/widget/CounterView;->adjustExtraCount(J)V

    .line 68
    return-void
.end method

.method public invalidateCounterUI()V
    .locals 1

    .prologue
    .line 374
    const/4 v0, 0x1

    iput-boolean v0, p0, Lco/vine/android/widget/CounterView;->mCanAnimate:Z

    .line 375
    return-void
.end method

.method public onDraw(Landroid/graphics/Canvas;)V
    .locals 26
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 273
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/widget/CounterView;->getMeasuredWidth()I

    move-result v18

    .line 274
    .local v18, "x":I
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/widget/CounterView;->getMeasuredHeight()I

    move-result v13

    .line 275
    .local v13, "measuredHeight":I
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/widget/CounterView;->mLOCK:[I

    move-object/from16 v21, v0

    monitor-enter v21

    .line 276
    :try_start_0
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/widget/CounterView;->mDigitAnimations:Ljava/util/ArrayList;

    move-object/from16 v20, v0

    invoke-virtual/range {v20 .. v20}, Ljava/util/ArrayList;->size()I

    move-result v12

    .line 277
    .local v12, "length":I
    const-string v14, ""

    .line 278
    .local v14, "num":Ljava/lang/String;
    const/4 v11, 0x0

    .local v11, "i":I
    :goto_0
    if-ge v11, v12, :cond_8

    .line 279
    const/16 v20, 0x3

    move/from16 v0, v20

    if-lt v11, v0, :cond_0

    rem-int/lit8 v20, v11, 0x3

    if-nez v20, :cond_0

    .line 280
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/widget/CounterView;->mPaint:Landroid/graphics/Paint;

    move-object/from16 v20, v0

    const/16 v22, 0xff

    move-object/from16 v0, v20

    move/from16 v1, v22

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setAlpha(I)V

    .line 281
    const-string v20, ","

    move/from16 v0, v18

    int-to-float v0, v0

    move/from16 v22, v0

    shr-int/lit8 v23, v13, 0x1

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/widget/CounterView;->mBounds:[Landroid/graphics/Rect;

    move-object/from16 v24, v0

    const/16 v25, 0xa

    aget-object v24, v24, v25

    invoke-virtual/range {v24 .. v24}, Landroid/graphics/Rect;->height()I

    move-result v24

    add-int v23, v23, v24

    move/from16 v0, v23

    int-to-float v0, v0

    move/from16 v23, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/widget/CounterView;->mPaint:Landroid/graphics/Paint;

    move-object/from16 v24, v0

    move-object/from16 v0, p1

    move-object/from16 v1, v20

    move/from16 v2, v22

    move/from16 v3, v23

    move-object/from16 v4, v24

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 282
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/widget/CounterView;->mBounds:[Landroid/graphics/Rect;

    move-object/from16 v20, v0

    const/16 v22, 0xa

    aget-object v20, v20, v22

    invoke-virtual/range {v20 .. v20}, Landroid/graphics/Rect;->width()I

    move-result v20

    sub-int v18, v18, v20

    .line 284
    :cond_0
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/widget/CounterView;->mDigitAnimations:Ljava/util/ArrayList;

    move-object/from16 v20, v0

    move-object/from16 v0, v20

    invoke-virtual {v0, v11}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lco/vine/android/widget/CounterView$DigitAnimation;

    .line 285
    .local v9, "digitAnimation":Lco/vine/android/widget/CounterView$DigitAnimation;
    iget v8, v9, Lco/vine/android/widget/CounterView$DigitAnimation;->mDrawingDigit:I

    .line 286
    .local v8, "digit":I
    invoke-static {v8}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v10

    .line 287
    .local v10, "digitText":Ljava/lang/String;
    move-object/from16 v0, p0

    invoke-direct {v0, v13, v8}, Lco/vine/android/widget/CounterView;->getIntrinsicHeightForDigit(II)I

    move-result v19

    .line 288
    .local v19, "y":I
    iget-boolean v0, v9, Lco/vine/android/widget/CounterView$DigitAnimation;->mIsAnimating:Z

    move/from16 v20, v0

    if-eqz v20, :cond_7

    .line 289
    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v22

    iget-wide v0, v9, Lco/vine/android/widget/CounterView$DigitAnimation;->mAnimationStartTime:J

    move-wide/from16 v24, v0

    sub-long v6, v22, v24

    .line 290
    .local v6, "diff":J
    long-to-double v0, v6

    move-wide/from16 v22, v0

    iget-wide v0, v9, Lco/vine/android/widget/CounterView$DigitAnimation;->mAnimationDuration:J

    move-wide/from16 v24, v0

    move-wide/from16 v0, v24

    long-to-double v0, v0

    move-wide/from16 v24, v0

    div-double v15, v22, v24

    .line 291
    .local v15, "progress":D
    iget-wide v0, v9, Lco/vine/android/widget/CounterView$DigitAnimation;->mAnimationDuration:J

    move-wide/from16 v22, v0

    cmp-long v20, v6, v22

    if-gez v20, :cond_1

    iget v0, v9, Lco/vine/android/widget/CounterView$DigitAnimation;->mCurrentAnimatingToDigit:I

    move/from16 v20, v0

    move/from16 v0, v20

    if-ne v0, v8, :cond_2

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/widget/CounterView;->mAnimationMode:Lco/vine/android/widget/CounterView$AnimationMode;

    move-object/from16 v20, v0

    move-object/from16 v0, v20

    iget-boolean v0, v0, Lco/vine/android/widget/CounterView$AnimationMode;->pedometerAnimation:Z

    move/from16 v20, v0

    if-nez v20, :cond_2

    .line 292
    :cond_1
    new-instance v20, Ljava/lang/StringBuilder;

    invoke-direct/range {v20 .. v20}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v20

    invoke-virtual {v0, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    iget v0, v9, Lco/vine/android/widget/CounterView$DigitAnimation;->mCurrentAnimatingToDigit:I

    move/from16 v22, v0

    move-object/from16 v0, v20

    move/from16 v1, v22

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v20

    invoke-virtual/range {v20 .. v20}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v14

    .line 293
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/widget/CounterView;->mPaint:Landroid/graphics/Paint;

    move-object/from16 v20, v0

    const/16 v22, 0xff

    move-object/from16 v0, v20

    move/from16 v1, v22

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setAlpha(I)V

    .line 294
    iget v0, v9, Lco/vine/android/widget/CounterView$DigitAnimation;->mCurrentAnimatingToDigit:I

    move/from16 v20, v0

    invoke-static/range {v20 .. v20}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v20

    move/from16 v0, v18

    int-to-float v0, v0

    move/from16 v22, v0

    move/from16 v0, v19

    int-to-float v0, v0

    move/from16 v23, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/widget/CounterView;->mPaint:Landroid/graphics/Paint;

    move-object/from16 v24, v0

    move-object/from16 v0, p1

    move-object/from16 v1, v20

    move/from16 v2, v22

    move/from16 v3, v23

    move-object/from16 v4, v24

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 315
    .end local v6    # "diff":J
    .end local v15    # "progress":D
    :goto_1
    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/widget/CounterView;->mMaxTextWidth:I

    move/from16 v20, v0

    add-int/lit8 v20, v20, 0x3

    sub-int v18, v18, v20

    .line 278
    add-int/lit8 v11, v11, 0x1

    goto/16 :goto_0

    .line 296
    .restart local v6    # "diff":J
    .restart local v15    # "progress":D
    :cond_2
    move/from16 v0, v19

    int-to-double v0, v0

    move-wide/from16 v22, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/widget/CounterView;->mBounds:[Landroid/graphics/Rect;

    move-object/from16 v20, v0

    aget-object v20, v20, v8

    invoke-virtual/range {v20 .. v20}, Landroid/graphics/Rect;->height()I

    move-result v20

    add-int/lit8 v20, v20, 0x3

    move/from16 v0, v20

    int-to-double v0, v0

    move-wide/from16 v24, v0

    mul-double v24, v24, v15

    sub-double v22, v22, v24

    move-wide/from16 v0, v22

    double-to-int v0, v0

    move/from16 v17, v0

    .line 297
    .local v17, "topY":I
    if-nez v8, :cond_3

    add-int/lit8 v20, v12, -0x1

    move/from16 v0, v20

    if-ne v11, v0, :cond_3

    const/16 v20, 0x1

    move/from16 v0, v20

    if-ne v12, v0, :cond_5

    .line 298
    :cond_3
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/widget/CounterView;->mAnimationMode:Lco/vine/android/widget/CounterView$AnimationMode;

    move-object/from16 v20, v0

    move-object/from16 v0, v20

    iget-boolean v0, v0, Lco/vine/android/widget/CounterView$AnimationMode;->alphaAnimation:Z

    move/from16 v20, v0

    if-eqz v20, :cond_4

    .line 299
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/widget/CounterView;->mPaint:Landroid/graphics/Paint;

    move-object/from16 v20, v0

    const-wide/high16 v22, 0x3ff0000000000000L    # 1.0

    sub-double v22, v22, v15

    const-wide v24, 0x406fe00000000000L    # 255.0

    mul-double v22, v22, v24

    move-wide/from16 v0, v22

    double-to-int v0, v0

    move/from16 v22, v0

    move-object/from16 v0, v20

    move/from16 v1, v22

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setAlpha(I)V

    .line 301
    :cond_4
    move/from16 v0, v18

    int-to-float v0, v0

    move/from16 v20, v0

    move/from16 v0, v17

    int-to-float v0, v0

    move/from16 v22, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/widget/CounterView;->mPaint:Landroid/graphics/Paint;

    move-object/from16 v23, v0

    move-object/from16 v0, p1

    move/from16 v1, v20

    move/from16 v2, v22

    move-object/from16 v3, v23

    invoke-virtual {v0, v10, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 303
    :cond_5
    new-instance v20, Ljava/lang/StringBuilder;

    invoke-direct/range {v20 .. v20}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v20

    invoke-virtual {v0, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    move-object/from16 v0, v20

    invoke-virtual {v0, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    invoke-virtual/range {v20 .. v20}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v14

    .line 304
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/widget/CounterView;->mBounds:[Landroid/graphics/Rect;

    move-object/from16 v20, v0

    aget-object v20, v20, v8

    invoke-virtual/range {v20 .. v20}, Landroid/graphics/Rect;->height()I

    move-result v20

    add-int v20, v20, v17

    add-int/lit8 v5, v20, 0x3

    .line 305
    .local v5, "botY":I
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/widget/CounterView;->mAnimationMode:Lco/vine/android/widget/CounterView$AnimationMode;

    move-object/from16 v20, v0

    move-object/from16 v0, v20

    iget-boolean v0, v0, Lco/vine/android/widget/CounterView$AnimationMode;->alphaAnimation:Z

    move/from16 v20, v0

    if-eqz v20, :cond_6

    .line 306
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/widget/CounterView;->mPaint:Landroid/graphics/Paint;

    move-object/from16 v20, v0

    const-wide v22, 0x406fe00000000000L    # 255.0

    mul-double v22, v22, v15

    move-wide/from16 v0, v22

    double-to-int v0, v0

    move/from16 v22, v0

    move-object/from16 v0, v20

    move/from16 v1, v22

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setAlpha(I)V

    .line 308
    :cond_6
    iget v0, v9, Lco/vine/android/widget/CounterView$DigitAnimation;->mCurrentAnimatingToDigit:I

    move/from16 v20, v0

    invoke-static/range {v20 .. v20}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v20

    move/from16 v0, v18

    int-to-float v0, v0

    move/from16 v22, v0

    int-to-float v0, v5

    move/from16 v23, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/widget/CounterView;->mPaint:Landroid/graphics/Paint;

    move-object/from16 v24, v0

    move-object/from16 v0, p1

    move-object/from16 v1, v20

    move/from16 v2, v22

    move/from16 v3, v23

    move-object/from16 v4, v24

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    goto/16 :goto_1

    .line 320
    .end local v5    # "botY":I
    .end local v6    # "diff":J
    .end local v8    # "digit":I
    .end local v9    # "digitAnimation":Lco/vine/android/widget/CounterView$DigitAnimation;
    .end local v10    # "digitText":Ljava/lang/String;
    .end local v11    # "i":I
    .end local v12    # "length":I
    .end local v14    # "num":Ljava/lang/String;
    .end local v15    # "progress":D
    .end local v17    # "topY":I
    .end local v19    # "y":I
    :catchall_0
    move-exception v20

    monitor-exit v21
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v20

    .line 311
    .restart local v8    # "digit":I
    .restart local v9    # "digitAnimation":Lco/vine/android/widget/CounterView$DigitAnimation;
    .restart local v10    # "digitText":Ljava/lang/String;
    .restart local v11    # "i":I
    .restart local v12    # "length":I
    .restart local v14    # "num":Ljava/lang/String;
    .restart local v19    # "y":I
    :cond_7
    :try_start_1
    new-instance v20, Ljava/lang/StringBuilder;

    invoke-direct/range {v20 .. v20}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v20

    invoke-virtual {v0, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    move-object/from16 v0, v20

    invoke-virtual {v0, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    invoke-virtual/range {v20 .. v20}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v14

    .line 312
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/widget/CounterView;->mPaint:Landroid/graphics/Paint;

    move-object/from16 v20, v0

    const/16 v22, 0xff

    move-object/from16 v0, v20

    move/from16 v1, v22

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setAlpha(I)V

    .line 313
    move/from16 v0, v18

    int-to-float v0, v0

    move/from16 v20, v0

    move/from16 v0, v19

    int-to-float v0, v0

    move/from16 v22, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/widget/CounterView;->mPaint:Landroid/graphics/Paint;

    move-object/from16 v23, v0

    move-object/from16 v0, p1

    move/from16 v1, v20

    move/from16 v2, v22

    move-object/from16 v3, v23

    invoke-virtual {v0, v10, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    goto/16 :goto_1

    .line 317
    .end local v8    # "digit":I
    .end local v9    # "digitAnimation":Lco/vine/android/widget/CounterView$DigitAnimation;
    .end local v10    # "digitText":Ljava/lang/String;
    .end local v19    # "y":I
    :cond_8
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/widget/CounterView;->mLastPrint:Ljava/lang/String;

    move-object/from16 v20, v0

    move-object/from16 v0, v20

    invoke-virtual {v14, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v20

    if-nez v20, :cond_9

    .line 318
    move-object/from16 v0, p0

    iput-object v14, v0, Lco/vine/android/widget/CounterView;->mLastPrint:Ljava/lang/String;

    .line 320
    :cond_9
    monitor-exit v21
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 321
    move-object/from16 v0, p0

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Lco/vine/android/widget/CounterView;->removeCallbacks(Ljava/lang/Runnable;)Z

    .line 322
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lco/vine/android/widget/CounterView;->mIsPaused:Z

    move/from16 v20, v0

    if-nez v20, :cond_a

    .line 323
    const-wide/16 v20, 0x14

    move-object/from16 v0, p0

    move-object/from16 v1, p0

    move-wide/from16 v2, v20

    invoke-virtual {v0, v1, v2, v3}, Lco/vine/android/widget/CounterView;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 325
    :cond_a
    return-void
.end method

.method protected onMeasure(II)V
    .locals 13
    .param p1, "widthMeasureSpec"    # I
    .param p2, "heightMeasureSpec"    # I

    .prologue
    const/high16 v12, 0x40000000    # 2.0f

    const/high16 v11, -0x80000000

    .line 329
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getMode(I)I

    move-result v5

    .line 330
    .local v5, "widthMode":I
    invoke-static {p2}, Landroid/view/View$MeasureSpec;->getMode(I)I

    move-result v2

    .line 331
    .local v2, "heightMode":I
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v6

    .line 332
    .local v6, "widthSize":I
    invoke-static {p2}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v3

    .line 336
    .local v3, "heightSize":I
    invoke-direct {p0}, Lco/vine/android/widget/CounterView;->updateTextSizes()V

    .line 338
    if-ne v5, v12, :cond_0

    .line 339
    const-string v7, "CounterView"

    const-string v8, "onMeasure width exactly"

    invoke-static {v7, v8}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 340
    move v4, v6

    .line 353
    .local v4, "width":I
    :goto_0
    if-ne v2, v12, :cond_2

    .line 354
    const-string v7, "CounterView"

    const-string v8, "onMeasure height exactly"

    invoke-static {v7, v8}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 355
    move v1, v3

    .line 365
    .local v1, "height":I
    :goto_1
    const-string v7, "CounterView"

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "onMeasure "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, " * "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 366
    invoke-virtual {p0, v4, v1}, Lco/vine/android/widget/CounterView;->setMeasuredDimension(II)V

    .line 367
    return-void

    .line 342
    .end local v1    # "height":I
    .end local v4    # "width":I
    :cond_0
    iget v7, p0, Lco/vine/android/widget/CounterView;->mLastDigitCount:I

    iget-wide v8, p0, Lco/vine/android/widget/CounterView;->mDrawingCount:J

    invoke-static {v8, v9}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/String;->length()I

    move-result v8

    invoke-static {v7, v8}, Ljava/lang/Math;->max(II)I

    move-result v0

    .line 343
    .local v0, "digits":I
    iget v7, p0, Lco/vine/android/widget/CounterView;->mMaxTextWidth:I

    add-int/lit8 v7, v7, 0x3

    mul-int/2addr v7, v0

    div-int/lit8 v8, v0, 0x3

    iget-object v9, p0, Lco/vine/android/widget/CounterView;->mBounds:[Landroid/graphics/Rect;

    const/16 v10, 0xa

    aget-object v9, v9, v10

    invoke-virtual {v9}, Landroid/graphics/Rect;->width()I

    move-result v9

    mul-int/2addr v8, v9

    add-int/2addr v7, v8

    invoke-virtual {p0}, Lco/vine/android/widget/CounterView;->getPaddingLeft()I

    move-result v8

    add-int/2addr v7, v8

    invoke-virtual {p0}, Lco/vine/android/widget/CounterView;->getPaddingRight()I

    move-result v8

    add-int v4, v7, v8

    .line 346
    .restart local v4    # "width":I
    if-ne v2, v11, :cond_1

    .line 347
    const-string v7, "CounterView"

    const-string v8, "onMeasure width at most"

    invoke-static {v7, v8}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 348
    invoke-static {v4, v6}, Ljava/lang/Math;->min(II)I

    move-result v4

    goto :goto_0

    .line 350
    :cond_1
    const-string v7, "CounterView"

    const-string v8, "onMeasure width unspecified"

    invoke-static {v7, v8}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 357
    .end local v0    # "digits":I
    :cond_2
    iget v7, p0, Lco/vine/android/widget/CounterView;->mMaxTextHeight:I

    invoke-virtual {p0}, Lco/vine/android/widget/CounterView;->getPaddingTop()I

    move-result v8

    add-int/2addr v7, v8

    invoke-virtual {p0}, Lco/vine/android/widget/CounterView;->getPaddingBottom()I

    move-result v8

    add-int/2addr v7, v8

    add-int/lit8 v1, v7, 0x3

    .line 358
    .restart local v1    # "height":I
    if-ne v2, v11, :cond_3

    .line 359
    const-string v7, "CounterView"

    const-string v8, "onMeasure height at most"

    invoke-static {v7, v8}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 360
    invoke-static {v1, v3}, Ljava/lang/Math;->min(II)I

    move-result v1

    goto/16 :goto_1

    .line 362
    :cond_3
    const-string v7, "CounterView"

    const-string v8, "onMeasure width unspecified"

    invoke-static {v7, v8}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_1
.end method

.method public pause()V
    .locals 1

    .prologue
    .line 256
    const/4 v0, 0x1

    iput-boolean v0, p0, Lco/vine/android/widget/CounterView;->mIsPaused:Z

    .line 257
    invoke-virtual {p0, p0}, Lco/vine/android/widget/CounterView;->removeCallbacks(Ljava/lang/Runnable;)Z

    .line 258
    return-void
.end method

.method public reset()V
    .locals 2

    .prologue
    .line 231
    const/4 v0, 0x0

    iput v0, p0, Lco/vine/android/widget/CounterView;->mLastDigitCount:I

    .line 232
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lco/vine/android/widget/CounterView;->mKnownCount:J

    .line 233
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lco/vine/android/widget/CounterView;->mKnownCountRefreshTime:J

    .line 234
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lco/vine/android/widget/CounterView;->mVelocityPerMS:D

    .line 235
    iget-object v0, p0, Lco/vine/android/widget/CounterView;->mDigitAnimations:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 236
    return-void
.end method

.method public resume()V
    .locals 1

    .prologue
    .line 261
    iget-boolean v0, p0, Lco/vine/android/widget/CounterView;->mIsPaused:Z

    if-eqz v0, :cond_0

    .line 262
    const/4 v0, 0x0

    iput-boolean v0, p0, Lco/vine/android/widget/CounterView;->mIsPaused:Z

    .line 263
    invoke-virtual {p0}, Lco/vine/android/widget/CounterView;->postInvalidate()V

    .line 265
    :cond_0
    return-void
.end method

.method public run()V
    .locals 1

    .prologue
    .line 431
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lco/vine/android/widget/CounterView;->invalidateDigitSize(Z)V

    .line 432
    iget-boolean v0, p0, Lco/vine/android/widget/CounterView;->mIsPaused:Z

    if-nez v0, :cond_0

    invoke-virtual {p0}, Lco/vine/android/widget/CounterView;->isShown()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 433
    invoke-virtual {p0}, Lco/vine/android/widget/CounterView;->postInvalidate()V

    .line 435
    :cond_0
    return-void
.end method

.method public setAnimationMode(Lco/vine/android/widget/CounterView$AnimationMode;)V
    .locals 0
    .param p1, "animationMode"    # Lco/vine/android/widget/CounterView$AnimationMode;

    .prologue
    .line 55
    iput-object p1, p0, Lco/vine/android/widget/CounterView;->mAnimationMode:Lco/vine/android/widget/CounterView$AnimationMode;

    .line 56
    return-void
.end method

.method public setKnownCount(JDJ)J
    .locals 6
    .param p1, "knownCount"    # J
    .param p3, "velocityPerMS"    # D
    .param p5, "knownCountRefreshTime"    # J

    .prologue
    .line 239
    const-wide/16 v2, 0x0

    cmp-long v2, p5, v2

    if-lez v2, :cond_0

    .line 240
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    .line 241
    .local v0, "time":J
    long-to-double v2, p1

    sub-long v4, v0, p5

    long-to-double v4, v4

    mul-double/2addr v4, p3

    add-double/2addr v2, v4

    double-to-long v2, v2

    iput-wide v2, p0, Lco/vine/android/widget/CounterView;->mKnownCount:J

    .line 242
    iput-wide v0, p0, Lco/vine/android/widget/CounterView;->mKnownCountRefreshTime:J

    .line 246
    .end local v0    # "time":J
    :goto_0
    iput-wide p3, p0, Lco/vine/android/widget/CounterView;->mVelocityPerMS:D

    .line 247
    iget-object v3, p0, Lco/vine/android/widget/CounterView;->mLOCK:[I

    monitor-enter v3

    .line 248
    const/4 v2, 0x0

    :try_start_0
    iput v2, p0, Lco/vine/android/widget/CounterView;->mLastDigitCount:I

    .line 249
    iget-object v2, p0, Lco/vine/android/widget/CounterView;->mDigitAnimations:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->clear()V

    .line 250
    const/4 v2, 0x1

    invoke-direct {p0, v2}, Lco/vine/android/widget/CounterView;->invalidateDigitSize(Z)V

    .line 251
    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 252
    iget-wide v2, p0, Lco/vine/android/widget/CounterView;->mKnownCount:J

    return-wide v2

    .line 244
    :cond_0
    iput-wide p1, p0, Lco/vine/android/widget/CounterView;->mKnownCount:J

    goto :goto_0

    .line 251
    :catchall_0
    move-exception v2

    :try_start_1
    monitor-exit v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v2
.end method

.method public setMaxAnimationSeparation(J)V
    .locals 0
    .param p1, "maxAnimationSeparation"    # J

    .prologue
    .line 63
    iput-wide p1, p0, Lco/vine/android/widget/CounterView;->mMaxAnimationSeparation:J

    .line 64
    return-void
.end method

.method public setMinAnimationSeparation(J)V
    .locals 0
    .param p1, "minAnimationSeparation"    # J

    .prologue
    .line 59
    iput-wide p1, p0, Lco/vine/android/widget/CounterView;->mMinAnimationSeparation:J

    .line 60
    return-void
.end method

.method public setTextSize(F)V
    .locals 1
    .param p1, "textSize"    # F

    .prologue
    .line 226
    iget-object v0, p0, Lco/vine/android/widget/CounterView;->mPaint:Landroid/graphics/Paint;

    invoke-virtual {v0, p1}, Landroid/graphics/Paint;->setTextSize(F)V

    .line 227
    invoke-virtual {p0}, Lco/vine/android/widget/CounterView;->requestLayout()V

    .line 228
    return-void
.end method

.method public setTypeFace(Landroid/graphics/Typeface;)V
    .locals 1
    .param p1, "typeFace"    # Landroid/graphics/Typeface;

    .prologue
    .line 221
    iget-object v0, p0, Lco/vine/android/widget/CounterView;->mPaint:Landroid/graphics/Paint;

    invoke-virtual {v0, p1}, Landroid/graphics/Paint;->setTypeface(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;

    .line 222
    invoke-virtual {p0}, Lco/vine/android/widget/CounterView;->requestLayout()V

    .line 223
    return-void
.end method
