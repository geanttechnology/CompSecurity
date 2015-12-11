.class public Lcom/aio/downloader/views/TouchImageView;
.super Landroid/widget/ImageView;
.source "TouchImageView.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/views/TouchImageView$CompatScroller;,
        Lcom/aio/downloader/views/TouchImageView$DoubleTapZoom;,
        Lcom/aio/downloader/views/TouchImageView$Fling;,
        Lcom/aio/downloader/views/TouchImageView$GestureListener;,
        Lcom/aio/downloader/views/TouchImageView$OnTouchImageViewListener;,
        Lcom/aio/downloader/views/TouchImageView$PrivateOnTouchListener;,
        Lcom/aio/downloader/views/TouchImageView$ScaleListener;,
        Lcom/aio/downloader/views/TouchImageView$State;,
        Lcom/aio/downloader/views/TouchImageView$ZoomVariables;
    }
.end annotation


# static fields
.field private static synthetic $SWITCH_TABLE$android$widget$ImageView$ScaleType:[I = null

.field private static final DEBUG:Ljava/lang/String; = "DEBUG"

.field private static final SUPER_MAX_MULTIPLIER:F = 1.25f

.field private static final SUPER_MIN_MULTIPLIER:F = 0.75f


# instance fields
.field private context:Landroid/content/Context;

.field private delayedZoomVariables:Lcom/aio/downloader/views/TouchImageView$ZoomVariables;

.field private doubleTapListener:Landroid/view/GestureDetector$OnDoubleTapListener;

.field private fling:Lcom/aio/downloader/views/TouchImageView$Fling;

.field private imageRenderedAtLeastOnce:Z

.field private m:[F

.field private mGestureDetector:Landroid/view/GestureDetector;

.field private mScaleDetector:Landroid/view/ScaleGestureDetector;

.field private mScaleType:Landroid/widget/ImageView$ScaleType;

.field private matchViewHeight:F

.field private matchViewWidth:F

.field private matrix:Landroid/graphics/Matrix;

.field private maxScale:F

.field private minScale:F

.field private normalizedScale:F

.field private onDrawReady:Z

.field private prevMatchViewHeight:F

.field private prevMatchViewWidth:F

.field private prevMatrix:Landroid/graphics/Matrix;

.field private prevViewHeight:I

.field private prevViewWidth:I

.field private state:Lcom/aio/downloader/views/TouchImageView$State;

.field private superMaxScale:F

.field private superMinScale:F

.field private touchImageViewListener:Lcom/aio/downloader/views/TouchImageView$OnTouchImageViewListener;

.field private userTouchListener:Landroid/view/View$OnTouchListener;

.field private viewHeight:I

.field private viewWidth:I


# direct methods
.method static synthetic $SWITCH_TABLE$android$widget$ImageView$ScaleType()[I
    .locals 3

    .prologue
    .line 41
    sget-object v0, Lcom/aio/downloader/views/TouchImageView;->$SWITCH_TABLE$android$widget$ImageView$ScaleType:[I

    if-eqz v0, :cond_0

    :goto_0
    return-object v0

    :cond_0
    invoke-static {}, Landroid/widget/ImageView$ScaleType;->values()[Landroid/widget/ImageView$ScaleType;

    move-result-object v0

    array-length v0, v0

    new-array v0, v0, [I

    :try_start_0
    sget-object v1, Landroid/widget/ImageView$ScaleType;->CENTER:Landroid/widget/ImageView$ScaleType;

    invoke-virtual {v1}, Landroid/widget/ImageView$ScaleType;->ordinal()I

    move-result v1

    const/4 v2, 0x1

    aput v2, v0, v1
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_7

    :goto_1
    :try_start_1
    sget-object v1, Landroid/widget/ImageView$ScaleType;->CENTER_CROP:Landroid/widget/ImageView$ScaleType;

    invoke-virtual {v1}, Landroid/widget/ImageView$ScaleType;->ordinal()I

    move-result v1

    const/4 v2, 0x2

    aput v2, v0, v1
    :try_end_1
    .catch Ljava/lang/NoSuchFieldError; {:try_start_1 .. :try_end_1} :catch_6

    :goto_2
    :try_start_2
    sget-object v1, Landroid/widget/ImageView$ScaleType;->CENTER_INSIDE:Landroid/widget/ImageView$ScaleType;

    invoke-virtual {v1}, Landroid/widget/ImageView$ScaleType;->ordinal()I

    move-result v1

    const/4 v2, 0x3

    aput v2, v0, v1
    :try_end_2
    .catch Ljava/lang/NoSuchFieldError; {:try_start_2 .. :try_end_2} :catch_5

    :goto_3
    :try_start_3
    sget-object v1, Landroid/widget/ImageView$ScaleType;->FIT_CENTER:Landroid/widget/ImageView$ScaleType;

    invoke-virtual {v1}, Landroid/widget/ImageView$ScaleType;->ordinal()I

    move-result v1

    const/4 v2, 0x4

    aput v2, v0, v1
    :try_end_3
    .catch Ljava/lang/NoSuchFieldError; {:try_start_3 .. :try_end_3} :catch_4

    :goto_4
    :try_start_4
    sget-object v1, Landroid/widget/ImageView$ScaleType;->FIT_END:Landroid/widget/ImageView$ScaleType;

    invoke-virtual {v1}, Landroid/widget/ImageView$ScaleType;->ordinal()I

    move-result v1

    const/4 v2, 0x5

    aput v2, v0, v1
    :try_end_4
    .catch Ljava/lang/NoSuchFieldError; {:try_start_4 .. :try_end_4} :catch_3

    :goto_5
    :try_start_5
    sget-object v1, Landroid/widget/ImageView$ScaleType;->FIT_START:Landroid/widget/ImageView$ScaleType;

    invoke-virtual {v1}, Landroid/widget/ImageView$ScaleType;->ordinal()I

    move-result v1

    const/4 v2, 0x6

    aput v2, v0, v1
    :try_end_5
    .catch Ljava/lang/NoSuchFieldError; {:try_start_5 .. :try_end_5} :catch_2

    :goto_6
    :try_start_6
    sget-object v1, Landroid/widget/ImageView$ScaleType;->FIT_XY:Landroid/widget/ImageView$ScaleType;

    invoke-virtual {v1}, Landroid/widget/ImageView$ScaleType;->ordinal()I

    move-result v1

    const/4 v2, 0x7

    aput v2, v0, v1
    :try_end_6
    .catch Ljava/lang/NoSuchFieldError; {:try_start_6 .. :try_end_6} :catch_1

    :goto_7
    :try_start_7
    sget-object v1, Landroid/widget/ImageView$ScaleType;->MATRIX:Landroid/widget/ImageView$ScaleType;

    invoke-virtual {v1}, Landroid/widget/ImageView$ScaleType;->ordinal()I

    move-result v1

    const/16 v2, 0x8

    aput v2, v0, v1
    :try_end_7
    .catch Ljava/lang/NoSuchFieldError; {:try_start_7 .. :try_end_7} :catch_0

    :goto_8
    sput-object v0, Lcom/aio/downloader/views/TouchImageView;->$SWITCH_TABLE$android$widget$ImageView$ScaleType:[I

    goto :goto_0

    :catch_0
    move-exception v1

    goto :goto_8

    :catch_1
    move-exception v1

    goto :goto_7

    :catch_2
    move-exception v1

    goto :goto_6

    :catch_3
    move-exception v1

    goto :goto_5

    :catch_4
    move-exception v1

    goto :goto_4

    :catch_5
    move-exception v1

    goto :goto_3

    :catch_6
    move-exception v1

    goto :goto_2

    :catch_7
    move-exception v1

    goto :goto_1
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v0, 0x0

    .line 102
    invoke-direct {p0, p1}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V

    .line 97
    iput-object v0, p0, Lcom/aio/downloader/views/TouchImageView;->doubleTapListener:Landroid/view/GestureDetector$OnDoubleTapListener;

    .line 98
    iput-object v0, p0, Lcom/aio/downloader/views/TouchImageView;->userTouchListener:Landroid/view/View$OnTouchListener;

    .line 99
    iput-object v0, p0, Lcom/aio/downloader/views/TouchImageView;->touchImageViewListener:Lcom/aio/downloader/views/TouchImageView$OnTouchImageViewListener;

    .line 103
    invoke-direct {p0, p1}, Lcom/aio/downloader/views/TouchImageView;->sharedConstructing(Landroid/content/Context;)V

    .line 104
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v0, 0x0

    .line 107
    invoke-direct {p0, p1, p2}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 97
    iput-object v0, p0, Lcom/aio/downloader/views/TouchImageView;->doubleTapListener:Landroid/view/GestureDetector$OnDoubleTapListener;

    .line 98
    iput-object v0, p0, Lcom/aio/downloader/views/TouchImageView;->userTouchListener:Landroid/view/View$OnTouchListener;

    .line 99
    iput-object v0, p0, Lcom/aio/downloader/views/TouchImageView;->touchImageViewListener:Lcom/aio/downloader/views/TouchImageView$OnTouchImageViewListener;

    .line 108
    invoke-direct {p0, p1}, Lcom/aio/downloader/views/TouchImageView;->sharedConstructing(Landroid/content/Context;)V

    .line 109
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    const/4 v0, 0x0

    .line 112
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 97
    iput-object v0, p0, Lcom/aio/downloader/views/TouchImageView;->doubleTapListener:Landroid/view/GestureDetector$OnDoubleTapListener;

    .line 98
    iput-object v0, p0, Lcom/aio/downloader/views/TouchImageView;->userTouchListener:Landroid/view/View$OnTouchListener;

    .line 99
    iput-object v0, p0, Lcom/aio/downloader/views/TouchImageView;->touchImageViewListener:Lcom/aio/downloader/views/TouchImageView$OnTouchImageViewListener;

    .line 113
    invoke-direct {p0, p1}, Lcom/aio/downloader/views/TouchImageView;->sharedConstructing(Landroid/content/Context;)V

    .line 114
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/views/TouchImageView;)Landroid/view/GestureDetector$OnDoubleTapListener;
    .locals 1

    .prologue
    .line 97
    iget-object v0, p0, Lcom/aio/downloader/views/TouchImageView;->doubleTapListener:Landroid/view/GestureDetector$OnDoubleTapListener;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/views/TouchImageView;)Lcom/aio/downloader/views/TouchImageView$Fling;
    .locals 1

    .prologue
    .line 76
    iget-object v0, p0, Lcom/aio/downloader/views/TouchImageView;->fling:Lcom/aio/downloader/views/TouchImageView$Fling;

    return-object v0
.end method

.method static synthetic access$10(Lcom/aio/downloader/views/TouchImageView;Lcom/aio/downloader/views/TouchImageView$State;)V
    .locals 0

    .prologue
    .line 719
    invoke-direct {p0, p1}, Lcom/aio/downloader/views/TouchImageView;->setState(Lcom/aio/downloader/views/TouchImageView$State;)V

    return-void
.end method

.method static synthetic access$11(Lcom/aio/downloader/views/TouchImageView;)I
    .locals 1

    .prologue
    .line 88
    iget v0, p0, Lcom/aio/downloader/views/TouchImageView;->viewWidth:I

    return v0
.end method

.method static synthetic access$12(Lcom/aio/downloader/views/TouchImageView;)F
    .locals 1

    .prologue
    .line 505
    invoke-direct {p0}, Lcom/aio/downloader/views/TouchImageView;->getImageWidth()F

    move-result v0

    return v0
.end method

.method static synthetic access$13(Lcom/aio/downloader/views/TouchImageView;FFF)F
    .locals 1

    .prologue
    .line 498
    invoke-direct {p0, p1, p2, p3}, Lcom/aio/downloader/views/TouchImageView;->getFixDragTrans(FFF)F

    move-result v0

    return v0
.end method

.method static synthetic access$14(Lcom/aio/downloader/views/TouchImageView;)I
    .locals 1

    .prologue
    .line 88
    iget v0, p0, Lcom/aio/downloader/views/TouchImageView;->viewHeight:I

    return v0
.end method

.method static synthetic access$15(Lcom/aio/downloader/views/TouchImageView;)F
    .locals 1

    .prologue
    .line 509
    invoke-direct {p0}, Lcom/aio/downloader/views/TouchImageView;->getImageHeight()F

    move-result v0

    return v0
.end method

.method static synthetic access$16(Lcom/aio/downloader/views/TouchImageView;)Landroid/graphics/Matrix;
    .locals 1

    .prologue
    .line 64
    iget-object v0, p0, Lcom/aio/downloader/views/TouchImageView;->matrix:Landroid/graphics/Matrix;

    return-object v0
.end method

.method static synthetic access$17(Lcom/aio/downloader/views/TouchImageView;)V
    .locals 0

    .prologue
    .line 446
    invoke-direct {p0}, Lcom/aio/downloader/views/TouchImageView;->fixTrans()V

    return-void
.end method

.method static synthetic access$18(Lcom/aio/downloader/views/TouchImageView;)Landroid/view/View$OnTouchListener;
    .locals 1

    .prologue
    .line 98
    iget-object v0, p0, Lcom/aio/downloader/views/TouchImageView;->userTouchListener:Landroid/view/View$OnTouchListener;

    return-object v0
.end method

.method static synthetic access$19(Lcom/aio/downloader/views/TouchImageView;)Lcom/aio/downloader/views/TouchImageView$OnTouchImageViewListener;
    .locals 1

    .prologue
    .line 99
    iget-object v0, p0, Lcom/aio/downloader/views/TouchImageView;->touchImageViewListener:Lcom/aio/downloader/views/TouchImageView$OnTouchImageViewListener;

    return-object v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/views/TouchImageView;Lcom/aio/downloader/views/TouchImageView$Fling;)V
    .locals 0

    .prologue
    .line 76
    iput-object p1, p0, Lcom/aio/downloader/views/TouchImageView;->fling:Lcom/aio/downloader/views/TouchImageView$Fling;

    return-void
.end method

.method static synthetic access$20(Lcom/aio/downloader/views/TouchImageView;DFFZ)V
    .locals 0

    .prologue
    .line 928
    invoke-direct/range {p0 .. p5}, Lcom/aio/downloader/views/TouchImageView;->scaleImage(DFFZ)V

    return-void
.end method

.method static synthetic access$21(Lcom/aio/downloader/views/TouchImageView;FFZ)Landroid/graphics/PointF;
    .locals 1

    .prologue
    .line 1064
    invoke-direct {p0, p1, p2, p3}, Lcom/aio/downloader/views/TouchImageView;->transformCoordTouchToBitmap(FFZ)Landroid/graphics/PointF;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$22(Lcom/aio/downloader/views/TouchImageView;FF)Landroid/graphics/PointF;
    .locals 1

    .prologue
    .line 1088
    invoke-direct {p0, p1, p2}, Lcom/aio/downloader/views/TouchImageView;->transformCoordBitmapToTouch(FF)Landroid/graphics/PointF;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$23(Lcom/aio/downloader/views/TouchImageView;)V
    .locals 0

    .prologue
    .line 466
    invoke-direct {p0}, Lcom/aio/downloader/views/TouchImageView;->fixScaleTrans()V

    return-void
.end method

.method static synthetic access$24(Lcom/aio/downloader/views/TouchImageView;)Landroid/content/Context;
    .locals 1

    .prologue
    .line 75
    iget-object v0, p0, Lcom/aio/downloader/views/TouchImageView;->context:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic access$25(Lcom/aio/downloader/views/TouchImageView;)[F
    .locals 1

    .prologue
    .line 73
    iget-object v0, p0, Lcom/aio/downloader/views/TouchImageView;->m:[F

    return-object v0
.end method

.method static synthetic access$3(Lcom/aio/downloader/views/TouchImageView;Ljava/lang/Runnable;)V
    .locals 0

    .prologue
    .line 1248
    invoke-direct {p0, p1}, Lcom/aio/downloader/views/TouchImageView;->compatPostOnAnimation(Ljava/lang/Runnable;)V

    return-void
.end method

.method static synthetic access$4(Lcom/aio/downloader/views/TouchImageView;)Lcom/aio/downloader/views/TouchImageView$State;
    .locals 1

    .prologue
    .line 67
    iget-object v0, p0, Lcom/aio/downloader/views/TouchImageView;->state:Lcom/aio/downloader/views/TouchImageView$State;

    return-object v0
.end method

.method static synthetic access$5(Lcom/aio/downloader/views/TouchImageView;)F
    .locals 1

    .prologue
    .line 57
    iget v0, p0, Lcom/aio/downloader/views/TouchImageView;->normalizedScale:F

    return v0
.end method

.method static synthetic access$6(Lcom/aio/downloader/views/TouchImageView;)F
    .locals 1

    .prologue
    .line 69
    iget v0, p0, Lcom/aio/downloader/views/TouchImageView;->minScale:F

    return v0
.end method

.method static synthetic access$7(Lcom/aio/downloader/views/TouchImageView;)F
    .locals 1

    .prologue
    .line 70
    iget v0, p0, Lcom/aio/downloader/views/TouchImageView;->maxScale:F

    return v0
.end method

.method static synthetic access$8(Lcom/aio/downloader/views/TouchImageView;)Landroid/view/ScaleGestureDetector;
    .locals 1

    .prologue
    .line 95
    iget-object v0, p0, Lcom/aio/downloader/views/TouchImageView;->mScaleDetector:Landroid/view/ScaleGestureDetector;

    return-object v0
.end method

.method static synthetic access$9(Lcom/aio/downloader/views/TouchImageView;)Landroid/view/GestureDetector;
    .locals 1

    .prologue
    .line 96
    iget-object v0, p0, Lcom/aio/downloader/views/TouchImageView;->mGestureDetector:Landroid/view/GestureDetector;

    return-object v0
.end method

.method private compatPostOnAnimation(Ljava/lang/Runnable;)V
    .locals 2
    .param p1, "runnable"    # Ljava/lang/Runnable;
    .annotation build Landroid/annotation/TargetApi;
        value = 0x10
    .end annotation

    .prologue
    .line 1249
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x10

    if-lt v0, v1, :cond_0

    .line 1250
    invoke-virtual {p0, p1}, Lcom/aio/downloader/views/TouchImageView;->postOnAnimation(Ljava/lang/Runnable;)V

    .line 1255
    :goto_0
    return-void

    .line 1253
    :cond_0
    const-wide/16 v0, 0x10

    invoke-virtual {p0, p1, v0, v1}, Lcom/aio/downloader/views/TouchImageView;->postDelayed(Ljava/lang/Runnable;J)Z

    goto :goto_0
.end method

.method private fitImageToView()V
    .locals 23

    .prologue
    .line 547
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/views/TouchImageView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v18

    .line 548
    .local v18, "drawable":Landroid/graphics/drawable/Drawable;
    if-eqz v18, :cond_0

    invoke-virtual/range {v18 .. v18}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v2

    if-eqz v2, :cond_0

    invoke-virtual/range {v18 .. v18}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v2

    if-nez v2, :cond_1

    .line 651
    :cond_0
    :goto_0
    return-void

    .line 551
    :cond_1
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/aio/downloader/views/TouchImageView;->matrix:Landroid/graphics/Matrix;

    if-eqz v2, :cond_0

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/aio/downloader/views/TouchImageView;->prevMatrix:Landroid/graphics/Matrix;

    if-eqz v2, :cond_0

    .line 555
    invoke-virtual/range {v18 .. v18}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v9

    .line 556
    .local v9, "drawableWidth":I
    invoke-virtual/range {v18 .. v18}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v17

    .line 561
    .local v17, "drawableHeight":I
    move-object/from16 v0, p0

    iget v2, v0, Lcom/aio/downloader/views/TouchImageView;->viewWidth:I

    int-to-float v2, v2

    int-to-float v3, v9

    div-float v21, v2, v3

    .line 562
    .local v21, "scaleX":F
    move-object/from16 v0, p0

    iget v2, v0, Lcom/aio/downloader/views/TouchImageView;->viewHeight:I

    int-to-float v2, v2

    move/from16 v0, v17

    int-to-float v3, v0

    div-float v22, v2, v3

    .line 564
    .local v22, "scaleY":F
    invoke-static {}, Lcom/aio/downloader/views/TouchImageView;->$SWITCH_TABLE$android$widget$ImageView$ScaleType()[I

    move-result-object v2

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/views/TouchImageView;->mScaleType:Landroid/widget/ImageView$ScaleType;

    invoke-virtual {v3}, Landroid/widget/ImageView$ScaleType;->ordinal()I

    move-result v3

    aget v2, v2, v3

    packed-switch v2, :pswitch_data_0

    .line 587
    :pswitch_0
    new-instance v2, Ljava/lang/UnsupportedOperationException;

    const-string v3, "TouchImageView does not support FIT_START or FIT_END"

    invoke-direct {v2, v3}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 566
    :pswitch_1
    const/high16 v22, 0x3f800000    # 1.0f

    move/from16 v21, v22

    .line 594
    :goto_1
    :pswitch_2
    move-object/from16 v0, p0

    iget v2, v0, Lcom/aio/downloader/views/TouchImageView;->viewWidth:I

    int-to-float v2, v2

    int-to-float v3, v9

    mul-float v3, v3, v21

    sub-float v19, v2, v3

    .line 595
    .local v19, "redundantXSpace":F
    move-object/from16 v0, p0

    iget v2, v0, Lcom/aio/downloader/views/TouchImageView;->viewHeight:I

    int-to-float v2, v2

    move/from16 v0, v17

    int-to-float v3, v0

    mul-float v3, v3, v22

    sub-float v20, v2, v3

    .line 596
    .local v20, "redundantYSpace":F
    move-object/from16 v0, p0

    iget v2, v0, Lcom/aio/downloader/views/TouchImageView;->viewWidth:I

    int-to-float v2, v2

    sub-float v2, v2, v19

    move-object/from16 v0, p0

    iput v2, v0, Lcom/aio/downloader/views/TouchImageView;->matchViewWidth:F

    .line 597
    move-object/from16 v0, p0

    iget v2, v0, Lcom/aio/downloader/views/TouchImageView;->viewHeight:I

    int-to-float v2, v2

    sub-float v2, v2, v20

    move-object/from16 v0, p0

    iput v2, v0, Lcom/aio/downloader/views/TouchImageView;->matchViewHeight:F

    .line 598
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/views/TouchImageView;->isZoomed()Z

    move-result v2

    if-nez v2, :cond_2

    move-object/from16 v0, p0

    iget-boolean v2, v0, Lcom/aio/downloader/views/TouchImageView;->imageRenderedAtLeastOnce:Z

    if-nez v2, :cond_2

    .line 602
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/aio/downloader/views/TouchImageView;->matrix:Landroid/graphics/Matrix;

    move/from16 v0, v21

    move/from16 v1, v22

    invoke-virtual {v2, v0, v1}, Landroid/graphics/Matrix;->setScale(FF)V

    .line 603
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/aio/downloader/views/TouchImageView;->matrix:Landroid/graphics/Matrix;

    const/high16 v3, 0x40000000    # 2.0f

    div-float v3, v19, v3

    const/high16 v7, 0x40000000    # 2.0f

    div-float v7, v20, v7

    invoke-virtual {v2, v3, v7}, Landroid/graphics/Matrix;->postTranslate(FF)Z

    .line 604
    const/high16 v2, 0x3f800000    # 1.0f

    move-object/from16 v0, p0

    iput v2, v0, Lcom/aio/downloader/views/TouchImageView;->normalizedScale:F

    .line 649
    :goto_2
    invoke-direct/range {p0 .. p0}, Lcom/aio/downloader/views/TouchImageView;->fixTrans()V

    .line 650
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/aio/downloader/views/TouchImageView;->matrix:Landroid/graphics/Matrix;

    move-object/from16 v0, p0

    invoke-virtual {v0, v2}, Lcom/aio/downloader/views/TouchImageView;->setImageMatrix(Landroid/graphics/Matrix;)V

    goto/16 :goto_0

    .line 570
    .end local v19    # "redundantXSpace":F
    .end local v20    # "redundantYSpace":F
    :pswitch_3
    invoke-static/range {v21 .. v22}, Ljava/lang/Math;->max(FF)F

    move-result v22

    move/from16 v21, v22

    .line 571
    goto :goto_1

    .line 574
    :pswitch_4
    const/high16 v2, 0x3f800000    # 1.0f

    invoke-static/range {v21 .. v22}, Ljava/lang/Math;->min(FF)F

    move-result v3

    invoke-static {v2, v3}, Ljava/lang/Math;->min(FF)F

    move-result v22

    move/from16 v21, v22

    .line 577
    :pswitch_5
    invoke-static/range {v21 .. v22}, Ljava/lang/Math;->min(FF)F

    move-result v22

    move/from16 v21, v22

    .line 578
    goto :goto_1

    .line 612
    .restart local v19    # "redundantXSpace":F
    .restart local v20    # "redundantYSpace":F
    :cond_2
    move-object/from16 v0, p0

    iget v2, v0, Lcom/aio/downloader/views/TouchImageView;->prevMatchViewWidth:F

    const/4 v3, 0x0

    cmpl-float v2, v2, v3

    if-eqz v2, :cond_3

    move-object/from16 v0, p0

    iget v2, v0, Lcom/aio/downloader/views/TouchImageView;->prevMatchViewHeight:F

    const/4 v3, 0x0

    cmpl-float v2, v2, v3

    if-nez v2, :cond_4

    .line 613
    :cond_3
    invoke-direct/range {p0 .. p0}, Lcom/aio/downloader/views/TouchImageView;->savePreviousImageValues()V

    .line 616
    :cond_4
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/aio/downloader/views/TouchImageView;->prevMatrix:Landroid/graphics/Matrix;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/views/TouchImageView;->m:[F

    invoke-virtual {v2, v3}, Landroid/graphics/Matrix;->getValues([F)V

    .line 621
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/aio/downloader/views/TouchImageView;->m:[F

    const/4 v3, 0x0

    move-object/from16 v0, p0

    iget v7, v0, Lcom/aio/downloader/views/TouchImageView;->matchViewWidth:F

    int-to-float v8, v9

    div-float/2addr v7, v8

    move-object/from16 v0, p0

    iget v8, v0, Lcom/aio/downloader/views/TouchImageView;->normalizedScale:F

    mul-float/2addr v7, v8

    aput v7, v2, v3

    .line 622
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/aio/downloader/views/TouchImageView;->m:[F

    const/4 v3, 0x4

    move-object/from16 v0, p0

    iget v7, v0, Lcom/aio/downloader/views/TouchImageView;->matchViewHeight:F

    move/from16 v0, v17

    int-to-float v8, v0

    div-float/2addr v7, v8

    move-object/from16 v0, p0

    iget v8, v0, Lcom/aio/downloader/views/TouchImageView;->normalizedScale:F

    mul-float/2addr v7, v8

    aput v7, v2, v3

    .line 627
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/aio/downloader/views/TouchImageView;->m:[F

    const/4 v3, 0x2

    aget v4, v2, v3

    .line 628
    .local v4, "transX":F
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/aio/downloader/views/TouchImageView;->m:[F

    const/4 v3, 0x5

    aget v12, v2, v3

    .line 633
    .local v12, "transY":F
    move-object/from16 v0, p0

    iget v2, v0, Lcom/aio/downloader/views/TouchImageView;->prevMatchViewWidth:F

    move-object/from16 v0, p0

    iget v3, v0, Lcom/aio/downloader/views/TouchImageView;->normalizedScale:F

    mul-float v5, v2, v3

    .line 634
    .local v5, "prevActualWidth":F
    invoke-direct/range {p0 .. p0}, Lcom/aio/downloader/views/TouchImageView;->getImageWidth()F

    move-result v6

    .line 635
    .local v6, "actualWidth":F
    const/4 v3, 0x2

    move-object/from16 v0, p0

    iget v7, v0, Lcom/aio/downloader/views/TouchImageView;->prevViewWidth:I

    move-object/from16 v0, p0

    iget v8, v0, Lcom/aio/downloader/views/TouchImageView;->viewWidth:I

    move-object/from16 v2, p0

    invoke-direct/range {v2 .. v9}, Lcom/aio/downloader/views/TouchImageView;->translateMatrixAfterRotate(IFFFIII)V

    .line 640
    move-object/from16 v0, p0

    iget v2, v0, Lcom/aio/downloader/views/TouchImageView;->prevMatchViewHeight:F

    move-object/from16 v0, p0

    iget v3, v0, Lcom/aio/downloader/views/TouchImageView;->normalizedScale:F

    mul-float v13, v2, v3

    .line 641
    .local v13, "prevActualHeight":F
    invoke-direct/range {p0 .. p0}, Lcom/aio/downloader/views/TouchImageView;->getImageHeight()F

    move-result v14

    .line 642
    .local v14, "actualHeight":F
    const/4 v11, 0x5

    move-object/from16 v0, p0

    iget v15, v0, Lcom/aio/downloader/views/TouchImageView;->prevViewHeight:I

    move-object/from16 v0, p0

    iget v0, v0, Lcom/aio/downloader/views/TouchImageView;->viewHeight:I

    move/from16 v16, v0

    move-object/from16 v10, p0

    invoke-direct/range {v10 .. v17}, Lcom/aio/downloader/views/TouchImageView;->translateMatrixAfterRotate(IFFFIII)V

    .line 647
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/aio/downloader/views/TouchImageView;->matrix:Landroid/graphics/Matrix;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/views/TouchImageView;->m:[F

    invoke-virtual {v2, v3}, Landroid/graphics/Matrix;->setValues([F)V

    goto/16 :goto_2

    .line 564
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_0
        :pswitch_0
        :pswitch_2
    .end packed-switch
.end method

.method private fixScaleTrans()V
    .locals 5

    .prologue
    const/high16 v4, 0x40000000    # 2.0f

    .line 467
    invoke-direct {p0}, Lcom/aio/downloader/views/TouchImageView;->fixTrans()V

    .line 468
    iget-object v0, p0, Lcom/aio/downloader/views/TouchImageView;->matrix:Landroid/graphics/Matrix;

    iget-object v1, p0, Lcom/aio/downloader/views/TouchImageView;->m:[F

    invoke-virtual {v0, v1}, Landroid/graphics/Matrix;->getValues([F)V

    .line 469
    invoke-direct {p0}, Lcom/aio/downloader/views/TouchImageView;->getImageWidth()F

    move-result v0

    iget v1, p0, Lcom/aio/downloader/views/TouchImageView;->viewWidth:I

    int-to-float v1, v1

    cmpg-float v0, v0, v1

    if-gez v0, :cond_0

    .line 470
    iget-object v0, p0, Lcom/aio/downloader/views/TouchImageView;->m:[F

    const/4 v1, 0x2

    iget v2, p0, Lcom/aio/downloader/views/TouchImageView;->viewWidth:I

    int-to-float v2, v2

    invoke-direct {p0}, Lcom/aio/downloader/views/TouchImageView;->getImageWidth()F

    move-result v3

    sub-float/2addr v2, v3

    div-float/2addr v2, v4

    aput v2, v0, v1

    .line 473
    :cond_0
    invoke-direct {p0}, Lcom/aio/downloader/views/TouchImageView;->getImageHeight()F

    move-result v0

    iget v1, p0, Lcom/aio/downloader/views/TouchImageView;->viewHeight:I

    int-to-float v1, v1

    cmpg-float v0, v0, v1

    if-gez v0, :cond_1

    .line 474
    iget-object v0, p0, Lcom/aio/downloader/views/TouchImageView;->m:[F

    const/4 v1, 0x5

    iget v2, p0, Lcom/aio/downloader/views/TouchImageView;->viewHeight:I

    int-to-float v2, v2

    invoke-direct {p0}, Lcom/aio/downloader/views/TouchImageView;->getImageHeight()F

    move-result v3

    sub-float/2addr v2, v3

    div-float/2addr v2, v4

    aput v2, v0, v1

    .line 476
    :cond_1
    iget-object v0, p0, Lcom/aio/downloader/views/TouchImageView;->matrix:Landroid/graphics/Matrix;

    iget-object v1, p0, Lcom/aio/downloader/views/TouchImageView;->m:[F

    invoke-virtual {v0, v1}, Landroid/graphics/Matrix;->setValues([F)V

    .line 477
    return-void
.end method

.method private fixTrans()V
    .locals 7

    .prologue
    const/4 v6, 0x0

    .line 447
    iget-object v4, p0, Lcom/aio/downloader/views/TouchImageView;->matrix:Landroid/graphics/Matrix;

    iget-object v5, p0, Lcom/aio/downloader/views/TouchImageView;->m:[F

    invoke-virtual {v4, v5}, Landroid/graphics/Matrix;->getValues([F)V

    .line 448
    iget-object v4, p0, Lcom/aio/downloader/views/TouchImageView;->m:[F

    const/4 v5, 0x2

    aget v2, v4, v5

    .line 449
    .local v2, "transX":F
    iget-object v4, p0, Lcom/aio/downloader/views/TouchImageView;->m:[F

    const/4 v5, 0x5

    aget v3, v4, v5

    .line 451
    .local v3, "transY":F
    iget v4, p0, Lcom/aio/downloader/views/TouchImageView;->viewWidth:I

    int-to-float v4, v4

    invoke-direct {p0}, Lcom/aio/downloader/views/TouchImageView;->getImageWidth()F

    move-result v5

    invoke-direct {p0, v2, v4, v5}, Lcom/aio/downloader/views/TouchImageView;->getFixTrans(FFF)F

    move-result v0

    .line 452
    .local v0, "fixTransX":F
    iget v4, p0, Lcom/aio/downloader/views/TouchImageView;->viewHeight:I

    int-to-float v4, v4

    invoke-direct {p0}, Lcom/aio/downloader/views/TouchImageView;->getImageHeight()F

    move-result v5

    invoke-direct {p0, v3, v4, v5}, Lcom/aio/downloader/views/TouchImageView;->getFixTrans(FFF)F

    move-result v1

    .line 454
    .local v1, "fixTransY":F
    cmpl-float v4, v0, v6

    if-nez v4, :cond_0

    cmpl-float v4, v1, v6

    if-eqz v4, :cond_1

    .line 455
    :cond_0
    iget-object v4, p0, Lcom/aio/downloader/views/TouchImageView;->matrix:Landroid/graphics/Matrix;

    invoke-virtual {v4, v0, v1}, Landroid/graphics/Matrix;->postTranslate(FF)Z

    .line 457
    :cond_1
    return-void
.end method

.method private getFixDragTrans(FFF)F
    .locals 1
    .param p1, "delta"    # F
    .param p2, "viewSize"    # F
    .param p3, "contentSize"    # F

    .prologue
    .line 499
    cmpg-float v0, p3, p2

    if-gtz v0, :cond_0

    .line 500
    const/4 p1, 0x0

    .line 502
    .end local p1    # "delta":F
    :cond_0
    return p1
.end method

.method private getFixTrans(FFF)F
    .locals 3
    .param p1, "trans"    # F
    .param p2, "viewSize"    # F
    .param p3, "contentSize"    # F

    .prologue
    .line 482
    cmpg-float v2, p3, p2

    if-gtz v2, :cond_0

    .line 483
    const/4 v1, 0x0

    .line 484
    .local v1, "minTrans":F
    sub-float v0, p2, p3

    .line 491
    .local v0, "maxTrans":F
    :goto_0
    cmpg-float v2, p1, v1

    if-gez v2, :cond_1

    .line 492
    neg-float v2, p1

    add-float/2addr v2, v1

    .line 495
    :goto_1
    return v2

    .line 487
    .end local v0    # "maxTrans":F
    .end local v1    # "minTrans":F
    :cond_0
    sub-float v1, p2, p3

    .line 488
    .restart local v1    # "minTrans":F
    const/4 v0, 0x0

    .restart local v0    # "maxTrans":F
    goto :goto_0

    .line 493
    :cond_1
    cmpl-float v2, p1, v0

    if-lez v2, :cond_2

    .line 494
    neg-float v2, p1

    add-float/2addr v2, v0

    goto :goto_1

    .line 495
    :cond_2
    const/4 v2, 0x0

    goto :goto_1
.end method

.method private getImageHeight()F
    .locals 2

    .prologue
    .line 510
    iget v0, p0, Lcom/aio/downloader/views/TouchImageView;->matchViewHeight:F

    iget v1, p0, Lcom/aio/downloader/views/TouchImageView;->normalizedScale:F

    mul-float/2addr v0, v1

    return v0
.end method

.method private getImageWidth()F
    .locals 2

    .prologue
    .line 506
    iget v0, p0, Lcom/aio/downloader/views/TouchImageView;->matchViewWidth:F

    iget v1, p0, Lcom/aio/downloader/views/TouchImageView;->normalizedScale:F

    mul-float/2addr v0, v1

    return v0
.end method

.method private printMatrixInfo()V
    .locals 4

    .prologue
    .line 1272
    const/16 v1, 0x9

    new-array v0, v1, [F

    .line 1273
    .local v0, "n":[F
    iget-object v1, p0, Lcom/aio/downloader/views/TouchImageView;->matrix:Landroid/graphics/Matrix;

    invoke-virtual {v1, v0}, Landroid/graphics/Matrix;->getValues([F)V

    .line 1274
    const-string v1, "DEBUG"

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Scale: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const/4 v3, 0x0

    aget v3, v0, v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " TransX: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const/4 v3, 0x2

    aget v3, v0, v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " TransY: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const/4 v3, 0x5

    aget v3, v0, v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 1275
    return-void
.end method

.method private savePreviousImageValues()V
    .locals 2

    .prologue
    .line 234
    iget-object v0, p0, Lcom/aio/downloader/views/TouchImageView;->matrix:Landroid/graphics/Matrix;

    if-eqz v0, :cond_0

    iget v0, p0, Lcom/aio/downloader/views/TouchImageView;->viewHeight:I

    if-eqz v0, :cond_0

    iget v0, p0, Lcom/aio/downloader/views/TouchImageView;->viewWidth:I

    if-eqz v0, :cond_0

    .line 235
    iget-object v0, p0, Lcom/aio/downloader/views/TouchImageView;->matrix:Landroid/graphics/Matrix;

    iget-object v1, p0, Lcom/aio/downloader/views/TouchImageView;->m:[F

    invoke-virtual {v0, v1}, Landroid/graphics/Matrix;->getValues([F)V

    .line 236
    iget-object v0, p0, Lcom/aio/downloader/views/TouchImageView;->prevMatrix:Landroid/graphics/Matrix;

    iget-object v1, p0, Lcom/aio/downloader/views/TouchImageView;->m:[F

    invoke-virtual {v0, v1}, Landroid/graphics/Matrix;->setValues([F)V

    .line 237
    iget v0, p0, Lcom/aio/downloader/views/TouchImageView;->matchViewHeight:F

    iput v0, p0, Lcom/aio/downloader/views/TouchImageView;->prevMatchViewHeight:F

    .line 238
    iget v0, p0, Lcom/aio/downloader/views/TouchImageView;->matchViewWidth:F

    iput v0, p0, Lcom/aio/downloader/views/TouchImageView;->prevMatchViewWidth:F

    .line 239
    iget v0, p0, Lcom/aio/downloader/views/TouchImageView;->viewHeight:I

    iput v0, p0, Lcom/aio/downloader/views/TouchImageView;->prevViewHeight:I

    .line 240
    iget v0, p0, Lcom/aio/downloader/views/TouchImageView;->viewWidth:I

    iput v0, p0, Lcom/aio/downloader/views/TouchImageView;->prevViewWidth:I

    .line 242
    :cond_0
    return-void
.end method

.method private scaleImage(DFFZ)V
    .locals 6
    .param p1, "deltaScale"    # D
    .param p3, "focusX"    # F
    .param p4, "focusY"    # F
    .param p5, "stretchImageToSuper"    # Z

    .prologue
    .line 931
    if-eqz p5, :cond_1

    .line 932
    iget v0, p0, Lcom/aio/downloader/views/TouchImageView;->superMinScale:F

    .line 933
    .local v0, "lowerScale":F
    iget v2, p0, Lcom/aio/downloader/views/TouchImageView;->superMaxScale:F

    .line 940
    .local v2, "upperScale":F
    :goto_0
    iget v1, p0, Lcom/aio/downloader/views/TouchImageView;->normalizedScale:F

    .line 941
    .local v1, "origScale":F
    iget v3, p0, Lcom/aio/downloader/views/TouchImageView;->normalizedScale:F

    float-to-double v3, v3

    mul-double/2addr v3, p1

    double-to-float v3, v3

    iput v3, p0, Lcom/aio/downloader/views/TouchImageView;->normalizedScale:F

    .line 942
    iget v3, p0, Lcom/aio/downloader/views/TouchImageView;->normalizedScale:F

    cmpl-float v3, v3, v2

    if-lez v3, :cond_2

    .line 943
    iput v2, p0, Lcom/aio/downloader/views/TouchImageView;->normalizedScale:F

    .line 944
    div-float v3, v2, v1

    float-to-double p1, v3

    .line 950
    :cond_0
    :goto_1
    iget-object v3, p0, Lcom/aio/downloader/views/TouchImageView;->matrix:Landroid/graphics/Matrix;

    double-to-float v4, p1

    double-to-float v5, p1

    invoke-virtual {v3, v4, v5, p3, p4}, Landroid/graphics/Matrix;->postScale(FFFF)Z

    .line 951
    invoke-direct {p0}, Lcom/aio/downloader/views/TouchImageView;->fixScaleTrans()V

    .line 952
    return-void

    .line 936
    .end local v0    # "lowerScale":F
    .end local v1    # "origScale":F
    .end local v2    # "upperScale":F
    :cond_1
    iget v0, p0, Lcom/aio/downloader/views/TouchImageView;->minScale:F

    .line 937
    .restart local v0    # "lowerScale":F
    iget v2, p0, Lcom/aio/downloader/views/TouchImageView;->maxScale:F

    .restart local v2    # "upperScale":F
    goto :goto_0

    .line 945
    .restart local v1    # "origScale":F
    :cond_2
    iget v3, p0, Lcom/aio/downloader/views/TouchImageView;->normalizedScale:F

    cmpg-float v3, v3, v0

    if-gez v3, :cond_0

    .line 946
    iput v0, p0, Lcom/aio/downloader/views/TouchImageView;->normalizedScale:F

    .line 947
    div-float v3, v0, v1

    float-to-double p1, v3

    goto :goto_1
.end method

.method private setState(Lcom/aio/downloader/views/TouchImageView$State;)V
    .locals 0
    .param p1, "state"    # Lcom/aio/downloader/views/TouchImageView$State;

    .prologue
    .line 720
    iput-object p1, p0, Lcom/aio/downloader/views/TouchImageView;->state:Lcom/aio/downloader/views/TouchImageView$State;

    .line 721
    return-void
.end method

.method private setViewSize(III)I
    .locals 1
    .param p1, "mode"    # I
    .param p2, "size"    # I
    .param p3, "drawableWidth"    # I

    .prologue
    .line 663
    sparse-switch p1, :sswitch_data_0

    .line 677
    move v0, p2

    .line 680
    .local v0, "viewSize":I
    :goto_0
    return v0

    .line 665
    .end local v0    # "viewSize":I
    :sswitch_0
    move v0, p2

    .line 666
    .restart local v0    # "viewSize":I
    goto :goto_0

    .line 669
    .end local v0    # "viewSize":I
    :sswitch_1
    invoke-static {p3, p2}, Ljava/lang/Math;->min(II)I

    move-result v0

    .line 670
    .restart local v0    # "viewSize":I
    goto :goto_0

    .line 673
    .end local v0    # "viewSize":I
    :sswitch_2
    move v0, p3

    .line 674
    .restart local v0    # "viewSize":I
    goto :goto_0

    .line 663
    :sswitch_data_0
    .sparse-switch
        -0x80000000 -> :sswitch_1
        0x0 -> :sswitch_2
        0x40000000 -> :sswitch_0
    .end sparse-switch
.end method

.method private sharedConstructing(Landroid/content/Context;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/high16 v3, 0x3f800000    # 1.0f

    const/4 v2, 0x0

    .line 117
    const/4 v0, 0x1

    invoke-super {p0, v0}, Landroid/widget/ImageView;->setClickable(Z)V

    .line 118
    iput-object p1, p0, Lcom/aio/downloader/views/TouchImageView;->context:Landroid/content/Context;

    .line 119
    new-instance v0, Landroid/view/ScaleGestureDetector;

    new-instance v1, Lcom/aio/downloader/views/TouchImageView$ScaleListener;

    invoke-direct {v1, p0, v2}, Lcom/aio/downloader/views/TouchImageView$ScaleListener;-><init>(Lcom/aio/downloader/views/TouchImageView;Lcom/aio/downloader/views/TouchImageView$ScaleListener;)V

    invoke-direct {v0, p1, v1}, Landroid/view/ScaleGestureDetector;-><init>(Landroid/content/Context;Landroid/view/ScaleGestureDetector$OnScaleGestureListener;)V

    iput-object v0, p0, Lcom/aio/downloader/views/TouchImageView;->mScaleDetector:Landroid/view/ScaleGestureDetector;

    .line 120
    new-instance v0, Landroid/view/GestureDetector;

    new-instance v1, Lcom/aio/downloader/views/TouchImageView$GestureListener;

    invoke-direct {v1, p0, v2}, Lcom/aio/downloader/views/TouchImageView$GestureListener;-><init>(Lcom/aio/downloader/views/TouchImageView;Lcom/aio/downloader/views/TouchImageView$GestureListener;)V

    invoke-direct {v0, p1, v1}, Landroid/view/GestureDetector;-><init>(Landroid/content/Context;Landroid/view/GestureDetector$OnGestureListener;)V

    iput-object v0, p0, Lcom/aio/downloader/views/TouchImageView;->mGestureDetector:Landroid/view/GestureDetector;

    .line 121
    new-instance v0, Landroid/graphics/Matrix;

    invoke-direct {v0}, Landroid/graphics/Matrix;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/views/TouchImageView;->matrix:Landroid/graphics/Matrix;

    .line 122
    new-instance v0, Landroid/graphics/Matrix;

    invoke-direct {v0}, Landroid/graphics/Matrix;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/views/TouchImageView;->prevMatrix:Landroid/graphics/Matrix;

    .line 123
    const/16 v0, 0x9

    new-array v0, v0, [F

    iput-object v0, p0, Lcom/aio/downloader/views/TouchImageView;->m:[F

    .line 124
    iput v3, p0, Lcom/aio/downloader/views/TouchImageView;->normalizedScale:F

    .line 125
    iget-object v0, p0, Lcom/aio/downloader/views/TouchImageView;->mScaleType:Landroid/widget/ImageView$ScaleType;

    if-nez v0, :cond_0

    .line 126
    sget-object v0, Landroid/widget/ImageView$ScaleType;->FIT_CENTER:Landroid/widget/ImageView$ScaleType;

    iput-object v0, p0, Lcom/aio/downloader/views/TouchImageView;->mScaleType:Landroid/widget/ImageView$ScaleType;

    .line 128
    :cond_0
    iput v3, p0, Lcom/aio/downloader/views/TouchImageView;->minScale:F

    .line 129
    const/high16 v0, 0x40400000    # 3.0f

    iput v0, p0, Lcom/aio/downloader/views/TouchImageView;->maxScale:F

    .line 130
    const/high16 v0, 0x3f400000    # 0.75f

    iget v1, p0, Lcom/aio/downloader/views/TouchImageView;->minScale:F

    mul-float/2addr v0, v1

    iput v0, p0, Lcom/aio/downloader/views/TouchImageView;->superMinScale:F

    .line 131
    const/high16 v0, 0x3fa00000    # 1.25f

    iget v1, p0, Lcom/aio/downloader/views/TouchImageView;->maxScale:F

    mul-float/2addr v0, v1

    iput v0, p0, Lcom/aio/downloader/views/TouchImageView;->superMaxScale:F

    .line 132
    iget-object v0, p0, Lcom/aio/downloader/views/TouchImageView;->matrix:Landroid/graphics/Matrix;

    invoke-virtual {p0, v0}, Lcom/aio/downloader/views/TouchImageView;->setImageMatrix(Landroid/graphics/Matrix;)V

    .line 133
    sget-object v0, Landroid/widget/ImageView$ScaleType;->MATRIX:Landroid/widget/ImageView$ScaleType;

    invoke-virtual {p0, v0}, Lcom/aio/downloader/views/TouchImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V

    .line 134
    sget-object v0, Lcom/aio/downloader/views/TouchImageView$State;->NONE:Lcom/aio/downloader/views/TouchImageView$State;

    invoke-direct {p0, v0}, Lcom/aio/downloader/views/TouchImageView;->setState(Lcom/aio/downloader/views/TouchImageView$State;)V

    .line 135
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/aio/downloader/views/TouchImageView;->onDrawReady:Z

    .line 136
    new-instance v0, Lcom/aio/downloader/views/TouchImageView$PrivateOnTouchListener;

    invoke-direct {v0, p0, v2}, Lcom/aio/downloader/views/TouchImageView$PrivateOnTouchListener;-><init>(Lcom/aio/downloader/views/TouchImageView;Lcom/aio/downloader/views/TouchImageView$PrivateOnTouchListener;)V

    invoke-super {p0, v0}, Landroid/widget/ImageView;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 137
    return-void
.end method

.method private transformCoordBitmapToTouch(FF)Landroid/graphics/PointF;
    .locals 8
    .param p1, "bx"    # F
    .param p2, "by"    # F

    .prologue
    .line 1089
    iget-object v6, p0, Lcom/aio/downloader/views/TouchImageView;->matrix:Landroid/graphics/Matrix;

    iget-object v7, p0, Lcom/aio/downloader/views/TouchImageView;->m:[F

    invoke-virtual {v6, v7}, Landroid/graphics/Matrix;->getValues([F)V

    .line 1090
    invoke-virtual {p0}, Lcom/aio/downloader/views/TouchImageView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v6

    invoke-virtual {v6}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v6

    int-to-float v3, v6

    .line 1091
    .local v3, "origW":F
    invoke-virtual {p0}, Lcom/aio/downloader/views/TouchImageView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v6

    invoke-virtual {v6}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v6

    int-to-float v2, v6

    .line 1092
    .local v2, "origH":F
    div-float v4, p1, v3

    .line 1093
    .local v4, "px":F
    div-float v5, p2, v2

    .line 1094
    .local v5, "py":F
    iget-object v6, p0, Lcom/aio/downloader/views/TouchImageView;->m:[F

    const/4 v7, 0x2

    aget v6, v6, v7

    invoke-direct {p0}, Lcom/aio/downloader/views/TouchImageView;->getImageWidth()F

    move-result v7

    mul-float/2addr v7, v4

    add-float v0, v6, v7

    .line 1095
    .local v0, "finalX":F
    iget-object v6, p0, Lcom/aio/downloader/views/TouchImageView;->m:[F

    const/4 v7, 0x5

    aget v6, v6, v7

    invoke-direct {p0}, Lcom/aio/downloader/views/TouchImageView;->getImageHeight()F

    move-result v7

    mul-float/2addr v7, v5

    add-float v1, v6, v7

    .line 1096
    .local v1, "finalY":F
    new-instance v6, Landroid/graphics/PointF;

    invoke-direct {v6, v0, v1}, Landroid/graphics/PointF;-><init>(FF)V

    return-object v6
.end method

.method private transformCoordTouchToBitmap(FFZ)Landroid/graphics/PointF;
    .locals 9
    .param p1, "x"    # F
    .param p2, "y"    # F
    .param p3, "clipToBitmap"    # Z

    .prologue
    const/4 v8, 0x0

    .line 1065
    iget-object v6, p0, Lcom/aio/downloader/views/TouchImageView;->matrix:Landroid/graphics/Matrix;

    iget-object v7, p0, Lcom/aio/downloader/views/TouchImageView;->m:[F

    invoke-virtual {v6, v7}, Landroid/graphics/Matrix;->getValues([F)V

    .line 1066
    invoke-virtual {p0}, Lcom/aio/downloader/views/TouchImageView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v6

    invoke-virtual {v6}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v6

    int-to-float v3, v6

    .line 1067
    .local v3, "origW":F
    invoke-virtual {p0}, Lcom/aio/downloader/views/TouchImageView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v6

    invoke-virtual {v6}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v6

    int-to-float v2, v6

    .line 1068
    .local v2, "origH":F
    iget-object v6, p0, Lcom/aio/downloader/views/TouchImageView;->m:[F

    const/4 v7, 0x2

    aget v4, v6, v7

    .line 1069
    .local v4, "transX":F
    iget-object v6, p0, Lcom/aio/downloader/views/TouchImageView;->m:[F

    const/4 v7, 0x5

    aget v5, v6, v7

    .line 1070
    .local v5, "transY":F
    sub-float v6, p1, v4

    mul-float/2addr v6, v3

    invoke-direct {p0}, Lcom/aio/downloader/views/TouchImageView;->getImageWidth()F

    move-result v7

    div-float v0, v6, v7

    .line 1071
    .local v0, "finalX":F
    sub-float v6, p2, v5

    mul-float/2addr v6, v2

    invoke-direct {p0}, Lcom/aio/downloader/views/TouchImageView;->getImageHeight()F

    move-result v7

    div-float v1, v6, v7

    .line 1073
    .local v1, "finalY":F
    if-eqz p3, :cond_0

    .line 1074
    invoke-static {v0, v8}, Ljava/lang/Math;->max(FF)F

    move-result v6

    invoke-static {v6, v3}, Ljava/lang/Math;->min(FF)F

    move-result v0

    .line 1075
    invoke-static {v1, v8}, Ljava/lang/Math;->max(FF)F

    move-result v6

    invoke-static {v6, v2}, Ljava/lang/Math;->min(FF)F

    move-result v1

    .line 1078
    :cond_0
    new-instance v6, Landroid/graphics/PointF;

    invoke-direct {v6, v0, v1}, Landroid/graphics/PointF;-><init>(FF)V

    return-object v6
.end method

.method private translateMatrixAfterRotate(IFFFIII)V
    .locals 7
    .param p1, "axis"    # I
    .param p2, "trans"    # F
    .param p3, "prevImageSize"    # F
    .param p4, "imageSize"    # F
    .param p5, "prevViewSize"    # I
    .param p6, "viewSize"    # I
    .param p7, "drawableSize"    # I

    .prologue
    const/high16 v6, 0x3f000000    # 0.5f

    .line 696
    int-to-float v1, p6

    cmpg-float v1, p4, v1

    if-gez v1, :cond_0

    .line 700
    iget-object v1, p0, Lcom/aio/downloader/views/TouchImageView;->m:[F

    int-to-float v2, p6

    int-to-float v3, p7

    iget-object v4, p0, Lcom/aio/downloader/views/TouchImageView;->m:[F

    const/4 v5, 0x0

    aget v4, v4, v5

    mul-float/2addr v3, v4

    sub-float/2addr v2, v3

    mul-float/2addr v2, v6

    aput v2, v1, p1

    .line 717
    :goto_0
    return-void

    .line 702
    :cond_0
    const/4 v1, 0x0

    cmpl-float v1, p2, v1

    if-lez v1, :cond_1

    .line 706
    iget-object v1, p0, Lcom/aio/downloader/views/TouchImageView;->m:[F

    int-to-float v2, p6

    sub-float v2, p4, v2

    mul-float/2addr v2, v6

    neg-float v2, v2

    aput v2, v1, p1

    goto :goto_0

    .line 714
    :cond_1
    invoke-static {p2}, Ljava/lang/Math;->abs(F)F

    move-result v1

    int-to-float v2, p5

    mul-float/2addr v2, v6

    add-float/2addr v1, v2

    div-float v0, v1, p3

    .line 715
    .local v0, "percentage":F
    iget-object v1, p0, Lcom/aio/downloader/views/TouchImageView;->m:[F

    mul-float v2, v0, p4

    int-to-float v3, p6

    mul-float/2addr v3, v6

    sub-float/2addr v2, v3

    neg-float v2, v2

    aput v2, v1, p1

    goto :goto_0
.end method


# virtual methods
.method public canScrollHorizontally(I)Z
    .locals 4
    .param p1, "direction"    # I

    .prologue
    const/4 v1, 0x0

    .line 729
    iget-object v2, p0, Lcom/aio/downloader/views/TouchImageView;->matrix:Landroid/graphics/Matrix;

    iget-object v3, p0, Lcom/aio/downloader/views/TouchImageView;->m:[F

    invoke-virtual {v2, v3}, Landroid/graphics/Matrix;->getValues([F)V

    .line 730
    iget-object v2, p0, Lcom/aio/downloader/views/TouchImageView;->m:[F

    const/4 v3, 0x2

    aget v0, v2, v3

    .line 732
    .local v0, "x":F
    invoke-direct {p0}, Lcom/aio/downloader/views/TouchImageView;->getImageWidth()F

    move-result v2

    iget v3, p0, Lcom/aio/downloader/views/TouchImageView;->viewWidth:I

    int-to-float v3, v3

    cmpg-float v2, v2, v3

    if-gez v2, :cond_1

    .line 742
    :cond_0
    :goto_0
    return v1

    .line 735
    :cond_1
    const/high16 v2, -0x40800000    # -1.0f

    cmpl-float v2, v0, v2

    if-ltz v2, :cond_2

    if-ltz p1, :cond_0

    .line 738
    :cond_2
    invoke-static {v0}, Ljava/lang/Math;->abs(F)F

    move-result v2

    iget v3, p0, Lcom/aio/downloader/views/TouchImageView;->viewWidth:I

    int-to-float v3, v3

    add-float/2addr v2, v3

    const/high16 v3, 0x3f800000    # 1.0f

    add-float/2addr v2, v3

    invoke-direct {p0}, Lcom/aio/downloader/views/TouchImageView;->getImageWidth()F

    move-result v3

    cmpl-float v2, v2, v3

    if-ltz v2, :cond_3

    if-gtz p1, :cond_0

    .line 742
    :cond_3
    const/4 v1, 0x1

    goto :goto_0
.end method

.method public canScrollHorizontallyFroyo(I)Z
    .locals 1
    .param p1, "direction"    # I

    .prologue
    .line 724
    invoke-virtual {p0, p1}, Lcom/aio/downloader/views/TouchImageView;->canScrollHorizontally(I)Z

    move-result v0

    return v0
.end method

.method public getCurrentZoom()F
    .locals 1

    .prologue
    .line 326
    iget v0, p0, Lcom/aio/downloader/views/TouchImageView;->normalizedScale:F

    return v0
.end method

.method public getMaxZoom()F
    .locals 1

    .prologue
    .line 300
    iget v0, p0, Lcom/aio/downloader/views/TouchImageView;->maxScale:F

    return v0
.end method

.method public getMinZoom()F
    .locals 1

    .prologue
    .line 317
    iget v0, p0, Lcom/aio/downloader/views/TouchImageView;->minScale:F

    return v0
.end method

.method public getScaleType()Landroid/widget/ImageView$ScaleType;
    .locals 1

    .prologue
    .line 202
    iget-object v0, p0, Lcom/aio/downloader/views/TouchImageView;->mScaleType:Landroid/widget/ImageView$ScaleType;

    return-object v0
.end method

.method public getScrollPosition()Landroid/graphics/PointF;
    .locals 7

    .prologue
    .line 419
    invoke-virtual {p0}, Lcom/aio/downloader/views/TouchImageView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 420
    .local v0, "drawable":Landroid/graphics/drawable/Drawable;
    if-nez v0, :cond_0

    .line 421
    const/4 v3, 0x0

    .line 429
    :goto_0
    return-object v3

    .line 423
    :cond_0
    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v2

    .line 424
    .local v2, "drawableWidth":I
    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v1

    .line 426
    .local v1, "drawableHeight":I
    iget v4, p0, Lcom/aio/downloader/views/TouchImageView;->viewWidth:I

    div-int/lit8 v4, v4, 0x2

    int-to-float v4, v4

    iget v5, p0, Lcom/aio/downloader/views/TouchImageView;->viewHeight:I

    div-int/lit8 v5, v5, 0x2

    int-to-float v5, v5

    const/4 v6, 0x1

    invoke-direct {p0, v4, v5, v6}, Lcom/aio/downloader/views/TouchImageView;->transformCoordTouchToBitmap(FFZ)Landroid/graphics/PointF;

    move-result-object v3

    .line 427
    .local v3, "point":Landroid/graphics/PointF;
    iget v4, v3, Landroid/graphics/PointF;->x:F

    int-to-float v5, v2

    div-float/2addr v4, v5

    iput v4, v3, Landroid/graphics/PointF;->x:F

    .line 428
    iget v4, v3, Landroid/graphics/PointF;->y:F

    int-to-float v5, v1

    div-float/2addr v4, v5

    iput v4, v3, Landroid/graphics/PointF;->y:F

    goto :goto_0
.end method

.method public getZoomedRect()Landroid/graphics/RectF;
    .locals 9

    .prologue
    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 218
    iget-object v4, p0, Lcom/aio/downloader/views/TouchImageView;->mScaleType:Landroid/widget/ImageView$ScaleType;

    sget-object v5, Landroid/widget/ImageView$ScaleType;->FIT_XY:Landroid/widget/ImageView$ScaleType;

    if-ne v4, v5, :cond_0

    .line 219
    new-instance v4, Ljava/lang/UnsupportedOperationException;

    const-string v5, "getZoomedRect() not supported with FIT_XY"

    invoke-direct {v4, v5}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 221
    :cond_0
    invoke-direct {p0, v6, v6, v7}, Lcom/aio/downloader/views/TouchImageView;->transformCoordTouchToBitmap(FFZ)Landroid/graphics/PointF;

    move-result-object v2

    .line 222
    .local v2, "topLeft":Landroid/graphics/PointF;
    iget v4, p0, Lcom/aio/downloader/views/TouchImageView;->viewWidth:I

    int-to-float v4, v4

    iget v5, p0, Lcom/aio/downloader/views/TouchImageView;->viewHeight:I

    int-to-float v5, v5

    invoke-direct {p0, v4, v5, v7}, Lcom/aio/downloader/views/TouchImageView;->transformCoordTouchToBitmap(FFZ)Landroid/graphics/PointF;

    move-result-object v0

    .line 224
    .local v0, "bottomRight":Landroid/graphics/PointF;
    invoke-virtual {p0}, Lcom/aio/downloader/views/TouchImageView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v4}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v4

    int-to-float v3, v4

    .line 225
    .local v3, "w":F
    invoke-virtual {p0}, Lcom/aio/downloader/views/TouchImageView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v4}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v4

    int-to-float v1, v4

    .line 226
    .local v1, "h":F
    new-instance v4, Landroid/graphics/RectF;

    iget v5, v2, Landroid/graphics/PointF;->x:F

    div-float/2addr v5, v3

    iget v6, v2, Landroid/graphics/PointF;->y:F

    div-float/2addr v6, v1

    iget v7, v0, Landroid/graphics/PointF;->x:F

    div-float/2addr v7, v3

    iget v8, v0, Landroid/graphics/PointF;->y:F

    div-float/2addr v8, v1

    invoke-direct {v4, v5, v6, v7, v8}, Landroid/graphics/RectF;-><init>(FFFF)V

    return-object v4
.end method

.method public isZoomed()Z
    .locals 2

    .prologue
    .line 210
    iget v0, p0, Lcom/aio/downloader/views/TouchImageView;->normalizedScale:F

    const/high16 v1, 0x3f800000    # 1.0f

    cmpl-float v0, v0, v1

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onConfigurationChanged(Landroid/content/res/Configuration;)V
    .locals 0
    .param p1, "newConfig"    # Landroid/content/res/Configuration;

    .prologue
    .line 291
    invoke-super {p0, p1}, Landroid/widget/ImageView;->onConfigurationChanged(Landroid/content/res/Configuration;)V

    .line 292
    invoke-direct {p0}, Lcom/aio/downloader/views/TouchImageView;->savePreviousImageValues()V

    .line 293
    return-void
.end method

.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 4
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    const/4 v0, 0x1

    .line 280
    iput-boolean v0, p0, Lcom/aio/downloader/views/TouchImageView;->onDrawReady:Z

    .line 281
    iput-boolean v0, p0, Lcom/aio/downloader/views/TouchImageView;->imageRenderedAtLeastOnce:Z

    .line 282
    iget-object v0, p0, Lcom/aio/downloader/views/TouchImageView;->delayedZoomVariables:Lcom/aio/downloader/views/TouchImageView$ZoomVariables;

    if-eqz v0, :cond_0

    .line 283
    iget-object v0, p0, Lcom/aio/downloader/views/TouchImageView;->delayedZoomVariables:Lcom/aio/downloader/views/TouchImageView$ZoomVariables;

    iget v0, v0, Lcom/aio/downloader/views/TouchImageView$ZoomVariables;->scale:F

    iget-object v1, p0, Lcom/aio/downloader/views/TouchImageView;->delayedZoomVariables:Lcom/aio/downloader/views/TouchImageView$ZoomVariables;

    iget v1, v1, Lcom/aio/downloader/views/TouchImageView$ZoomVariables;->focusX:F

    iget-object v2, p0, Lcom/aio/downloader/views/TouchImageView;->delayedZoomVariables:Lcom/aio/downloader/views/TouchImageView$ZoomVariables;

    iget v2, v2, Lcom/aio/downloader/views/TouchImageView$ZoomVariables;->focusY:F

    iget-object v3, p0, Lcom/aio/downloader/views/TouchImageView;->delayedZoomVariables:Lcom/aio/downloader/views/TouchImageView$ZoomVariables;

    iget-object v3, v3, Lcom/aio/downloader/views/TouchImageView$ZoomVariables;->scaleType:Landroid/widget/ImageView$ScaleType;

    invoke-virtual {p0, v0, v1, v2, v3}, Lcom/aio/downloader/views/TouchImageView;->setZoom(FFFLandroid/widget/ImageView$ScaleType;)V

    .line 284
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/aio/downloader/views/TouchImageView;->delayedZoomVariables:Lcom/aio/downloader/views/TouchImageView$ZoomVariables;

    .line 286
    :cond_0
    invoke-super {p0, p1}, Landroid/widget/ImageView;->onDraw(Landroid/graphics/Canvas;)V

    .line 287
    return-void
.end method

.method protected onMeasure(II)V
    .locals 9
    .param p1, "widthMeasureSpec"    # I
    .param p2, "heightMeasureSpec"    # I

    .prologue
    const/4 v8, 0x0

    .line 515
    invoke-virtual {p0}, Lcom/aio/downloader/views/TouchImageView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 516
    .local v0, "drawable":Landroid/graphics/drawable/Drawable;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v7

    if-eqz v7, :cond_0

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v7

    if-nez v7, :cond_1

    .line 517
    :cond_0
    invoke-virtual {p0, v8, v8}, Lcom/aio/downloader/views/TouchImageView;->setMeasuredDimension(II)V

    .line 539
    :goto_0
    return-void

    .line 521
    :cond_1
    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v2

    .line 522
    .local v2, "drawableWidth":I
    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v1

    .line 523
    .local v1, "drawableHeight":I
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v6

    .line 524
    .local v6, "widthSize":I
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getMode(I)I

    move-result v5

    .line 525
    .local v5, "widthMode":I
    invoke-static {p2}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v4

    .line 526
    .local v4, "heightSize":I
    invoke-static {p2}, Landroid/view/View$MeasureSpec;->getMode(I)I

    move-result v3

    .line 527
    .local v3, "heightMode":I
    invoke-direct {p0, v5, v6, v2}, Lcom/aio/downloader/views/TouchImageView;->setViewSize(III)I

    move-result v7

    iput v7, p0, Lcom/aio/downloader/views/TouchImageView;->viewWidth:I

    .line 528
    invoke-direct {p0, v3, v4, v1}, Lcom/aio/downloader/views/TouchImageView;->setViewSize(III)I

    move-result v7

    iput v7, p0, Lcom/aio/downloader/views/TouchImageView;->viewHeight:I

    .line 533
    iget v7, p0, Lcom/aio/downloader/views/TouchImageView;->viewWidth:I

    iget v8, p0, Lcom/aio/downloader/views/TouchImageView;->viewHeight:I

    invoke-virtual {p0, v7, v8}, Lcom/aio/downloader/views/TouchImageView;->setMeasuredDimension(II)V

    .line 538
    invoke-direct {p0}, Lcom/aio/downloader/views/TouchImageView;->fitImageToView()V

    goto :goto_0
.end method

.method public onRestoreInstanceState(Landroid/os/Parcelable;)V
    .locals 3
    .param p1, "state"    # Landroid/os/Parcelable;

    .prologue
    .line 261
    instance-of v1, p1, Landroid/os/Bundle;

    if-eqz v1, :cond_0

    move-object v0, p1

    .line 262
    check-cast v0, Landroid/os/Bundle;

    .line 263
    .local v0, "bundle":Landroid/os/Bundle;
    const-string v1, "saveScale"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getFloat(Ljava/lang/String;)F

    move-result v1

    iput v1, p0, Lcom/aio/downloader/views/TouchImageView;->normalizedScale:F

    .line 264
    const-string v1, "matrix"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getFloatArray(Ljava/lang/String;)[F

    move-result-object v1

    iput-object v1, p0, Lcom/aio/downloader/views/TouchImageView;->m:[F

    .line 265
    iget-object v1, p0, Lcom/aio/downloader/views/TouchImageView;->prevMatrix:Landroid/graphics/Matrix;

    iget-object v2, p0, Lcom/aio/downloader/views/TouchImageView;->m:[F

    invoke-virtual {v1, v2}, Landroid/graphics/Matrix;->setValues([F)V

    .line 266
    const-string v1, "matchViewHeight"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getFloat(Ljava/lang/String;)F

    move-result v1

    iput v1, p0, Lcom/aio/downloader/views/TouchImageView;->prevMatchViewHeight:F

    .line 267
    const-string v1, "matchViewWidth"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getFloat(Ljava/lang/String;)F

    move-result v1

    iput v1, p0, Lcom/aio/downloader/views/TouchImageView;->prevMatchViewWidth:F

    .line 268
    const-string v1, "viewHeight"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v1

    iput v1, p0, Lcom/aio/downloader/views/TouchImageView;->prevViewHeight:I

    .line 269
    const-string v1, "viewWidth"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v1

    iput v1, p0, Lcom/aio/downloader/views/TouchImageView;->prevViewWidth:I

    .line 270
    const-string v1, "imageRendered"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v1

    iput-boolean v1, p0, Lcom/aio/downloader/views/TouchImageView;->imageRenderedAtLeastOnce:Z

    .line 271
    const-string v1, "instanceState"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v1

    invoke-super {p0, v1}, Landroid/widget/ImageView;->onRestoreInstanceState(Landroid/os/Parcelable;)V

    .line 276
    .end local v0    # "bundle":Landroid/os/Bundle;
    :goto_0
    return-void

    .line 275
    :cond_0
    invoke-super {p0, p1}, Landroid/widget/ImageView;->onRestoreInstanceState(Landroid/os/Parcelable;)V

    goto :goto_0
.end method

.method public onSaveInstanceState()Landroid/os/Parcelable;
    .locals 3

    .prologue
    .line 246
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 247
    .local v0, "bundle":Landroid/os/Bundle;
    const-string v1, "instanceState"

    invoke-super {p0}, Landroid/widget/ImageView;->onSaveInstanceState()Landroid/os/Parcelable;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 248
    const-string v1, "saveScale"

    iget v2, p0, Lcom/aio/downloader/views/TouchImageView;->normalizedScale:F

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putFloat(Ljava/lang/String;F)V

    .line 249
    const-string v1, "matchViewHeight"

    iget v2, p0, Lcom/aio/downloader/views/TouchImageView;->matchViewHeight:F

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putFloat(Ljava/lang/String;F)V

    .line 250
    const-string v1, "matchViewWidth"

    iget v2, p0, Lcom/aio/downloader/views/TouchImageView;->matchViewWidth:F

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putFloat(Ljava/lang/String;F)V

    .line 251
    const-string v1, "viewWidth"

    iget v2, p0, Lcom/aio/downloader/views/TouchImageView;->viewWidth:I

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 252
    const-string v1, "viewHeight"

    iget v2, p0, Lcom/aio/downloader/views/TouchImageView;->viewHeight:I

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 253
    iget-object v1, p0, Lcom/aio/downloader/views/TouchImageView;->matrix:Landroid/graphics/Matrix;

    iget-object v2, p0, Lcom/aio/downloader/views/TouchImageView;->m:[F

    invoke-virtual {v1, v2}, Landroid/graphics/Matrix;->getValues([F)V

    .line 254
    const-string v1, "matrix"

    iget-object v2, p0, Lcom/aio/downloader/views/TouchImageView;->m:[F

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putFloatArray(Ljava/lang/String;[F)V

    .line 255
    const-string v1, "imageRendered"

    iget-boolean v2, p0, Lcom/aio/downloader/views/TouchImageView;->imageRenderedAtLeastOnce:Z

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 256
    return-object v0
.end method

.method public resetZoom()V
    .locals 1

    .prologue
    .line 342
    const/high16 v0, 0x3f800000    # 1.0f

    iput v0, p0, Lcom/aio/downloader/views/TouchImageView;->normalizedScale:F

    .line 343
    invoke-direct {p0}, Lcom/aio/downloader/views/TouchImageView;->fitImageToView()V

    .line 344
    return-void
.end method

.method public setImageBitmap(Landroid/graphics/Bitmap;)V
    .locals 0
    .param p1, "bm"    # Landroid/graphics/Bitmap;

    .prologue
    .line 161
    invoke-super {p0, p1}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 162
    invoke-direct {p0}, Lcom/aio/downloader/views/TouchImageView;->savePreviousImageValues()V

    .line 163
    invoke-direct {p0}, Lcom/aio/downloader/views/TouchImageView;->fitImageToView()V

    .line 164
    return-void
.end method

.method public setImageDrawable(Landroid/graphics/drawable/Drawable;)V
    .locals 0
    .param p1, "drawable"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 168
    invoke-super {p0, p1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 169
    invoke-direct {p0}, Lcom/aio/downloader/views/TouchImageView;->savePreviousImageValues()V

    .line 170
    invoke-direct {p0}, Lcom/aio/downloader/views/TouchImageView;->fitImageToView()V

    .line 171
    return-void
.end method

.method public setImageResource(I)V
    .locals 0
    .param p1, "resId"    # I

    .prologue
    .line 154
    invoke-super {p0, p1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 155
    invoke-direct {p0}, Lcom/aio/downloader/views/TouchImageView;->savePreviousImageValues()V

    .line 156
    invoke-direct {p0}, Lcom/aio/downloader/views/TouchImageView;->fitImageToView()V

    .line 157
    return-void
.end method

.method public setImageURI(Landroid/net/Uri;)V
    .locals 0
    .param p1, "uri"    # Landroid/net/Uri;

    .prologue
    .line 175
    invoke-super {p0, p1}, Landroid/widget/ImageView;->setImageURI(Landroid/net/Uri;)V

    .line 176
    invoke-direct {p0}, Lcom/aio/downloader/views/TouchImageView;->savePreviousImageValues()V

    .line 177
    invoke-direct {p0}, Lcom/aio/downloader/views/TouchImageView;->fitImageToView()V

    .line 178
    return-void
.end method

.method public setMaxZoom(F)V
    .locals 2
    .param p1, "max"    # F

    .prologue
    .line 308
    iput p1, p0, Lcom/aio/downloader/views/TouchImageView;->maxScale:F

    .line 309
    const/high16 v0, 0x3fa00000    # 1.25f

    iget v1, p0, Lcom/aio/downloader/views/TouchImageView;->maxScale:F

    mul-float/2addr v0, v1

    iput v0, p0, Lcom/aio/downloader/views/TouchImageView;->superMaxScale:F

    .line 310
    return-void
.end method

.method public setMinZoom(F)V
    .locals 2
    .param p1, "min"    # F

    .prologue
    .line 334
    iput p1, p0, Lcom/aio/downloader/views/TouchImageView;->minScale:F

    .line 335
    const/high16 v0, 0x3f400000    # 0.75f

    iget v1, p0, Lcom/aio/downloader/views/TouchImageView;->minScale:F

    mul-float/2addr v0, v1

    iput v0, p0, Lcom/aio/downloader/views/TouchImageView;->superMinScale:F

    .line 336
    return-void
.end method

.method public setOnDoubleTapListener(Landroid/view/GestureDetector$OnDoubleTapListener;)V
    .locals 0
    .param p1, "l"    # Landroid/view/GestureDetector$OnDoubleTapListener;

    .prologue
    .line 149
    iput-object p1, p0, Lcom/aio/downloader/views/TouchImageView;->doubleTapListener:Landroid/view/GestureDetector$OnDoubleTapListener;

    .line 150
    return-void
.end method

.method public setOnTouchImageViewListener(Lcom/aio/downloader/views/TouchImageView$OnTouchImageViewListener;)V
    .locals 0
    .param p1, "l"    # Lcom/aio/downloader/views/TouchImageView$OnTouchImageViewListener;

    .prologue
    .line 145
    iput-object p1, p0, Lcom/aio/downloader/views/TouchImageView;->touchImageViewListener:Lcom/aio/downloader/views/TouchImageView$OnTouchImageViewListener;

    .line 146
    return-void
.end method

.method public setOnTouchListener(Landroid/view/View$OnTouchListener;)V
    .locals 0
    .param p1, "l"    # Landroid/view/View$OnTouchListener;

    .prologue
    .line 141
    iput-object p1, p0, Lcom/aio/downloader/views/TouchImageView;->userTouchListener:Landroid/view/View$OnTouchListener;

    .line 142
    return-void
.end method

.method public setScaleType(Landroid/widget/ImageView$ScaleType;)V
    .locals 2
    .param p1, "type"    # Landroid/widget/ImageView$ScaleType;

    .prologue
    .line 182
    sget-object v0, Landroid/widget/ImageView$ScaleType;->FIT_START:Landroid/widget/ImageView$ScaleType;

    if-eq p1, v0, :cond_0

    sget-object v0, Landroid/widget/ImageView$ScaleType;->FIT_END:Landroid/widget/ImageView$ScaleType;

    if-ne p1, v0, :cond_1

    .line 183
    :cond_0
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "TouchImageView does not support FIT_START or FIT_END"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 185
    :cond_1
    sget-object v0, Landroid/widget/ImageView$ScaleType;->MATRIX:Landroid/widget/ImageView$ScaleType;

    if-ne p1, v0, :cond_3

    .line 186
    sget-object v0, Landroid/widget/ImageView$ScaleType;->MATRIX:Landroid/widget/ImageView$ScaleType;

    invoke-super {p0, v0}, Landroid/widget/ImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V

    .line 198
    :cond_2
    :goto_0
    return-void

    .line 189
    :cond_3
    iput-object p1, p0, Lcom/aio/downloader/views/TouchImageView;->mScaleType:Landroid/widget/ImageView$ScaleType;

    .line 190
    iget-boolean v0, p0, Lcom/aio/downloader/views/TouchImageView;->onDrawReady:Z

    if-eqz v0, :cond_2

    .line 195
    invoke-virtual {p0, p0}, Lcom/aio/downloader/views/TouchImageView;->setZoom(Lcom/aio/downloader/views/TouchImageView;)V

    goto :goto_0
.end method

.method public setScrollPosition(FF)V
    .locals 1
    .param p1, "focusX"    # F
    .param p2, "focusY"    # F

    .prologue
    .line 439
    iget v0, p0, Lcom/aio/downloader/views/TouchImageView;->normalizedScale:F

    invoke-virtual {p0, v0, p1, p2}, Lcom/aio/downloader/views/TouchImageView;->setZoom(FFF)V

    .line 440
    return-void
.end method

.method public setZoom(F)V
    .locals 1
    .param p1, "scale"    # F

    .prologue
    const/high16 v0, 0x3f000000    # 0.5f

    .line 351
    invoke-virtual {p0, p1, v0, v0}, Lcom/aio/downloader/views/TouchImageView;->setZoom(FFF)V

    .line 352
    return-void
.end method

.method public setZoom(FFF)V
    .locals 1
    .param p1, "scale"    # F
    .param p2, "focusX"    # F
    .param p3, "focusY"    # F

    .prologue
    .line 364
    iget-object v0, p0, Lcom/aio/downloader/views/TouchImageView;->mScaleType:Landroid/widget/ImageView$ScaleType;

    invoke-virtual {p0, p1, p2, p3, v0}, Lcom/aio/downloader/views/TouchImageView;->setZoom(FFFLandroid/widget/ImageView$ScaleType;)V

    .line 365
    return-void
.end method

.method public setZoom(FFFLandroid/widget/ImageView$ScaleType;)V
    .locals 7
    .param p1, "scale"    # F
    .param p2, "focusX"    # F
    .param p3, "focusY"    # F
    .param p4, "scaleType"    # Landroid/widget/ImageView$ScaleType;

    .prologue
    const/high16 v6, 0x3f000000    # 0.5f

    .line 383
    iget-boolean v0, p0, Lcom/aio/downloader/views/TouchImageView;->onDrawReady:Z

    if-nez v0, :cond_0

    .line 384
    new-instance v0, Lcom/aio/downloader/views/TouchImageView$ZoomVariables;

    move-object v1, p0

    move v2, p1

    move v3, p2

    move v4, p3

    move-object v5, p4

    invoke-direct/range {v0 .. v5}, Lcom/aio/downloader/views/TouchImageView$ZoomVariables;-><init>(Lcom/aio/downloader/views/TouchImageView;FFFLandroid/widget/ImageView$ScaleType;)V

    iput-object v0, p0, Lcom/aio/downloader/views/TouchImageView;->delayedZoomVariables:Lcom/aio/downloader/views/TouchImageView$ZoomVariables;

    .line 399
    :goto_0
    return-void

    .line 388
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/views/TouchImageView;->mScaleType:Landroid/widget/ImageView$ScaleType;

    if-eq p4, v0, :cond_1

    .line 389
    invoke-virtual {p0, p4}, Lcom/aio/downloader/views/TouchImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V

    .line 391
    :cond_1
    invoke-virtual {p0}, Lcom/aio/downloader/views/TouchImageView;->resetZoom()V

    .line 392
    float-to-double v1, p1

    iget v0, p0, Lcom/aio/downloader/views/TouchImageView;->viewWidth:I

    div-int/lit8 v0, v0, 0x2

    int-to-float v3, v0

    iget v0, p0, Lcom/aio/downloader/views/TouchImageView;->viewHeight:I

    div-int/lit8 v0, v0, 0x2

    int-to-float v4, v0

    const/4 v5, 0x1

    move-object v0, p0

    invoke-direct/range {v0 .. v5}, Lcom/aio/downloader/views/TouchImageView;->scaleImage(DFFZ)V

    .line 393
    iget-object v0, p0, Lcom/aio/downloader/views/TouchImageView;->matrix:Landroid/graphics/Matrix;

    iget-object v1, p0, Lcom/aio/downloader/views/TouchImageView;->m:[F

    invoke-virtual {v0, v1}, Landroid/graphics/Matrix;->getValues([F)V

    .line 394
    iget-object v0, p0, Lcom/aio/downloader/views/TouchImageView;->m:[F

    const/4 v1, 0x2

    invoke-direct {p0}, Lcom/aio/downloader/views/TouchImageView;->getImageWidth()F

    move-result v2

    mul-float/2addr v2, p2

    iget v3, p0, Lcom/aio/downloader/views/TouchImageView;->viewWidth:I

    int-to-float v3, v3

    mul-float/2addr v3, v6

    sub-float/2addr v2, v3

    neg-float v2, v2

    aput v2, v0, v1

    .line 395
    iget-object v0, p0, Lcom/aio/downloader/views/TouchImageView;->m:[F

    const/4 v1, 0x5

    invoke-direct {p0}, Lcom/aio/downloader/views/TouchImageView;->getImageHeight()F

    move-result v2

    mul-float/2addr v2, p3

    iget v3, p0, Lcom/aio/downloader/views/TouchImageView;->viewHeight:I

    int-to-float v3, v3

    mul-float/2addr v3, v6

    sub-float/2addr v2, v3

    neg-float v2, v2

    aput v2, v0, v1

    .line 396
    iget-object v0, p0, Lcom/aio/downloader/views/TouchImageView;->matrix:Landroid/graphics/Matrix;

    iget-object v1, p0, Lcom/aio/downloader/views/TouchImageView;->m:[F

    invoke-virtual {v0, v1}, Landroid/graphics/Matrix;->setValues([F)V

    .line 397
    invoke-direct {p0}, Lcom/aio/downloader/views/TouchImageView;->fixTrans()V

    .line 398
    iget-object v0, p0, Lcom/aio/downloader/views/TouchImageView;->matrix:Landroid/graphics/Matrix;

    invoke-virtual {p0, v0}, Lcom/aio/downloader/views/TouchImageView;->setImageMatrix(Landroid/graphics/Matrix;)V

    goto :goto_0
.end method

.method public setZoom(Lcom/aio/downloader/views/TouchImageView;)V
    .locals 5
    .param p1, "img"    # Lcom/aio/downloader/views/TouchImageView;

    .prologue
    .line 407
    invoke-virtual {p1}, Lcom/aio/downloader/views/TouchImageView;->getScrollPosition()Landroid/graphics/PointF;

    move-result-object v0

    .line 408
    .local v0, "center":Landroid/graphics/PointF;
    invoke-virtual {p1}, Lcom/aio/downloader/views/TouchImageView;->getCurrentZoom()F

    move-result v1

    iget v2, v0, Landroid/graphics/PointF;->x:F

    iget v3, v0, Landroid/graphics/PointF;->y:F

    invoke-virtual {p1}, Lcom/aio/downloader/views/TouchImageView;->getScaleType()Landroid/widget/ImageView$ScaleType;

    move-result-object v4

    invoke-virtual {p0, v1, v2, v3, v4}, Lcom/aio/downloader/views/TouchImageView;->setZoom(FFFLandroid/widget/ImageView$ScaleType;)V

    .line 409
    return-void
.end method
