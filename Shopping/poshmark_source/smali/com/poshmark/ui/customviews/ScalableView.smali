.class public Lcom/poshmark/ui/customviews/ScalableView;
.super Landroid/widget/ImageView;
.source "ScalableView.java"

# interfaces
.implements Landroid/view/View$OnTouchListener;
.implements Landroid/view/ScaleGestureDetector$OnScaleGestureListener;


# static fields
.field private static final CREATE_COVERSHOT:I = 0x1

.field private static final CREATE_THUMBNAIL:I = 0x0

.field private static final DEFAULT_BACKGROUND_COLOR_ID:Ljava/lang/String; = "#99000000"

.field private static final DEFAULT_GRIDLINE_COLOUR_ID:Ljava/lang/String; = "#FFFFFF"

.field private static final GRID_COLUMN_COUNT:I = 0x3

.field private static final GRID_ROW_COUNT:I = 0x3

.field private static final MAX_SCALEFACTOR:F = 3.0f

.field private static final MIN_SCALEFACTOR:F = 0.5f


# instance fields
.field private INVALID_POINTER_ID:I

.field private active_pointer_id:I

.field private backgroundPaint:Landroid/graphics/Paint;

.field private bitmap:Landroid/graphics/Bitmap;

.field private bmpFileName:Ljava/lang/String;

.field private canvas:Landroid/graphics/Canvas;

.field private cropImageWidth:F

.field private cropSpace:Landroid/graphics/RectF;

.field private mCenterX:F

.field private mCenterY:F

.field private mGridLinePaint:Landroid/graphics/Paint;

.field private mLastTouchX:F

.field private mLastTouchY:F

.field private mPosX:F

.field private mPosY:F

.field private mPts:[F

.field private mScaleFactor:F

.field private mTransparentLayerPaint:Landroid/graphics/Paint;

.field private matrix:Landroid/graphics/Matrix;

.field metrics:Landroid/util/DisplayMetrics;

.field private parentHeight:I

.field private parentWidth:I

.field private pivotX:F

.field private pivotY:F

.field private resizedBitmap:Landroid/graphics/Bitmap;

.field private scaleGestureDetector:Landroid/view/ScaleGestureDetector;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v3, 0x0

    .line 61
    invoke-direct {p0, p1, p2}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 42
    const/4 v2, -0x1

    iput v2, p0, Lcom/poshmark/ui/customviews/ScalableView;->INVALID_POINTER_ID:I

    .line 43
    iget v2, p0, Lcom/poshmark/ui/customviews/ScalableView;->INVALID_POINTER_ID:I

    iput v2, p0, Lcom/poshmark/ui/customviews/ScalableView;->active_pointer_id:I

    .line 45
    const/high16 v2, 0x3f800000    # 1.0f

    iput v2, p0, Lcom/poshmark/ui/customviews/ScalableView;->mScaleFactor:F

    .line 46
    iput v3, p0, Lcom/poshmark/ui/customviews/ScalableView;->mPosX:F

    iput v3, p0, Lcom/poshmark/ui/customviews/ScalableView;->mPosY:F

    iput v3, p0, Lcom/poshmark/ui/customviews/ScalableView;->mCenterX:F

    iput v3, p0, Lcom/poshmark/ui/customviews/ScalableView;->mCenterY:F

    .line 63
    new-instance v2, Landroid/view/ScaleGestureDetector;

    invoke-direct {v2, p1, p0}, Landroid/view/ScaleGestureDetector;-><init>(Landroid/content/Context;Landroid/view/ScaleGestureDetector$OnScaleGestureListener;)V

    iput-object v2, p0, Lcom/poshmark/ui/customviews/ScalableView;->scaleGestureDetector:Landroid/view/ScaleGestureDetector;

    .line 64
    invoke-virtual {p0, p0}, Lcom/poshmark/ui/customviews/ScalableView;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 65
    new-instance v2, Landroid/graphics/RectF;

    invoke-direct {v2}, Landroid/graphics/RectF;-><init>()V

    iput-object v2, p0, Lcom/poshmark/ui/customviews/ScalableView;->cropSpace:Landroid/graphics/RectF;

    .line 66
    new-instance v2, Landroid/graphics/Matrix;

    invoke-direct {v2}, Landroid/graphics/Matrix;-><init>()V

    iput-object v2, p0, Lcom/poshmark/ui/customviews/ScalableView;->matrix:Landroid/graphics/Matrix;

    .line 67
    new-instance v2, Landroid/util/DisplayMetrics;

    invoke-direct {v2}, Landroid/util/DisplayMetrics;-><init>()V

    iput-object v2, p0, Lcom/poshmark/ui/customviews/ScalableView;->metrics:Landroid/util/DisplayMetrics;

    .line 69
    new-instance v2, Landroid/graphics/Paint;

    invoke-direct {v2}, Landroid/graphics/Paint;-><init>()V

    iput-object v2, p0, Lcom/poshmark/ui/customviews/ScalableView;->backgroundPaint:Landroid/graphics/Paint;

    .line 70
    new-instance v2, Landroid/graphics/Paint;

    invoke-direct {v2}, Landroid/graphics/Paint;-><init>()V

    iput-object v2, p0, Lcom/poshmark/ui/customviews/ScalableView;->mTransparentLayerPaint:Landroid/graphics/Paint;

    .line 71
    iget-object v2, p0, Lcom/poshmark/ui/customviews/ScalableView;->mTransparentLayerPaint:Landroid/graphics/Paint;

    const-string v3, "#99000000"

    invoke-static {v3}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v3

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setColor(I)V

    .line 72
    new-instance v2, Landroid/graphics/Paint;

    invoke-direct {v2}, Landroid/graphics/Paint;-><init>()V

    iput-object v2, p0, Lcom/poshmark/ui/customviews/ScalableView;->mGridLinePaint:Landroid/graphics/Paint;

    .line 73
    iget-object v2, p0, Lcom/poshmark/ui/customviews/ScalableView;->mGridLinePaint:Landroid/graphics/Paint;

    const-string v3, "#FFFFFF"

    invoke-static {v3}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v3

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setColor(I)V

    .line 74
    const/16 v1, 0x8

    .line 75
    .local v1, "rowLineCount":I
    const/16 v0, 0x8

    .line 76
    .local v0, "columnLineCount":I
    const/16 v2, 0x10

    new-array v2, v2, [F

    iput-object v2, p0, Lcom/poshmark/ui/customviews/ScalableView;->mPts:[F

    .line 78
    return-void
.end method

.method private drawGrid(Landroid/graphics/Canvas;)V
    .locals 9
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    const/4 v8, 0x2

    const/high16 v7, 0x40400000    # 3.0f

    const/high16 v6, 0x3f800000    # 1.0f

    .line 112
    const/4 v1, 0x0

    .line 113
    .local v1, "index":I
    const/4 v0, 0x0

    .local v0, "i":I
    move v2, v1

    .end local v1    # "index":I
    .local v2, "index":I
    :goto_0
    if-ge v0, v8, :cond_0

    .line 114
    iget-object v3, p0, Lcom/poshmark/ui/customviews/ScalableView;->mPts:[F

    add-int/lit8 v1, v2, 0x1

    .end local v2    # "index":I
    .restart local v1    # "index":I
    iget-object v4, p0, Lcom/poshmark/ui/customviews/ScalableView;->cropSpace:Landroid/graphics/RectF;

    iget v4, v4, Landroid/graphics/RectF;->left:F

    aput v4, v3, v2

    .line 115
    iget-object v3, p0, Lcom/poshmark/ui/customviews/ScalableView;->mPts:[F

    add-int/lit8 v2, v1, 0x1

    .end local v1    # "index":I
    .restart local v2    # "index":I
    iget-object v4, p0, Lcom/poshmark/ui/customviews/ScalableView;->cropSpace:Landroid/graphics/RectF;

    invoke-virtual {v4}, Landroid/graphics/RectF;->height()F

    move-result v4

    int-to-float v5, v0

    add-float/2addr v5, v6

    mul-float/2addr v4, v5

    div-float/2addr v4, v7

    iget-object v5, p0, Lcom/poshmark/ui/customviews/ScalableView;->cropSpace:Landroid/graphics/RectF;

    iget v5, v5, Landroid/graphics/RectF;->top:F

    add-float/2addr v4, v5

    aput v4, v3, v1

    .line 116
    iget-object v3, p0, Lcom/poshmark/ui/customviews/ScalableView;->mPts:[F

    add-int/lit8 v1, v2, 0x1

    .end local v2    # "index":I
    .restart local v1    # "index":I
    iget-object v4, p0, Lcom/poshmark/ui/customviews/ScalableView;->cropSpace:Landroid/graphics/RectF;

    iget v4, v4, Landroid/graphics/RectF;->right:F

    aput v4, v3, v2

    .line 117
    iget-object v3, p0, Lcom/poshmark/ui/customviews/ScalableView;->mPts:[F

    add-int/lit8 v2, v1, 0x1

    .end local v1    # "index":I
    .restart local v2    # "index":I
    iget-object v4, p0, Lcom/poshmark/ui/customviews/ScalableView;->cropSpace:Landroid/graphics/RectF;

    invoke-virtual {v4}, Landroid/graphics/RectF;->height()F

    move-result v4

    int-to-float v5, v0

    add-float/2addr v5, v6

    mul-float/2addr v4, v5

    div-float/2addr v4, v7

    iget-object v5, p0, Lcom/poshmark/ui/customviews/ScalableView;->cropSpace:Landroid/graphics/RectF;

    iget v5, v5, Landroid/graphics/RectF;->top:F

    add-float/2addr v4, v5

    aput v4, v3, v1

    .line 113
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 120
    :cond_0
    const/4 v0, 0x0

    :goto_1
    if-ge v0, v8, :cond_1

    .line 121
    iget-object v3, p0, Lcom/poshmark/ui/customviews/ScalableView;->mPts:[F

    add-int/lit8 v1, v2, 0x1

    .end local v2    # "index":I
    .restart local v1    # "index":I
    iget-object v4, p0, Lcom/poshmark/ui/customviews/ScalableView;->cropSpace:Landroid/graphics/RectF;

    invoke-virtual {v4}, Landroid/graphics/RectF;->width()F

    move-result v4

    int-to-float v5, v0

    add-float/2addr v5, v6

    mul-float/2addr v4, v5

    div-float/2addr v4, v7

    iget-object v5, p0, Lcom/poshmark/ui/customviews/ScalableView;->cropSpace:Landroid/graphics/RectF;

    iget v5, v5, Landroid/graphics/RectF;->left:F

    add-float/2addr v4, v5

    aput v4, v3, v2

    .line 122
    iget-object v3, p0, Lcom/poshmark/ui/customviews/ScalableView;->mPts:[F

    add-int/lit8 v2, v1, 0x1

    .end local v1    # "index":I
    .restart local v2    # "index":I
    iget-object v4, p0, Lcom/poshmark/ui/customviews/ScalableView;->cropSpace:Landroid/graphics/RectF;

    iget v4, v4, Landroid/graphics/RectF;->top:F

    aput v4, v3, v1

    .line 123
    iget-object v3, p0, Lcom/poshmark/ui/customviews/ScalableView;->mPts:[F

    add-int/lit8 v1, v2, 0x1

    .end local v2    # "index":I
    .restart local v1    # "index":I
    iget-object v4, p0, Lcom/poshmark/ui/customviews/ScalableView;->cropSpace:Landroid/graphics/RectF;

    invoke-virtual {v4}, Landroid/graphics/RectF;->width()F

    move-result v4

    int-to-float v5, v0

    add-float/2addr v5, v6

    mul-float/2addr v4, v5

    div-float/2addr v4, v7

    iget-object v5, p0, Lcom/poshmark/ui/customviews/ScalableView;->cropSpace:Landroid/graphics/RectF;

    iget v5, v5, Landroid/graphics/RectF;->left:F

    add-float/2addr v4, v5

    aput v4, v3, v2

    .line 124
    iget-object v3, p0, Lcom/poshmark/ui/customviews/ScalableView;->mPts:[F

    add-int/lit8 v2, v1, 0x1

    .end local v1    # "index":I
    .restart local v2    # "index":I
    iget-object v4, p0, Lcom/poshmark/ui/customviews/ScalableView;->cropSpace:Landroid/graphics/RectF;

    iget v4, v4, Landroid/graphics/RectF;->bottom:F

    aput v4, v3, v1

    .line 120
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 126
    :cond_1
    iget-object v3, p0, Lcom/poshmark/ui/customviews/ScalableView;->mPts:[F

    iget-object v4, p0, Lcom/poshmark/ui/customviews/ScalableView;->mGridLinePaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v3, v4}, Landroid/graphics/Canvas;->drawLines([FLandroid/graphics/Paint;)V

    .line 127
    return-void
.end method

.method private drawTransparentLayer(Landroid/graphics/Canvas;)V
    .locals 7
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 103
    new-instance v6, Landroid/graphics/Rect;

    invoke-direct {v6}, Landroid/graphics/Rect;-><init>()V

    .line 104
    .local v6, "r":Landroid/graphics/Rect;
    invoke-virtual {p0, v6}, Lcom/poshmark/ui/customviews/ScalableView;->getLocalVisibleRect(Landroid/graphics/Rect;)Z

    .line 105
    iget v0, v6, Landroid/graphics/Rect;->left:I

    int-to-float v1, v0

    iget v0, v6, Landroid/graphics/Rect;->top:I

    int-to-float v2, v0

    iget v0, v6, Landroid/graphics/Rect;->right:I

    int-to-float v3, v0

    iget-object v0, p0, Lcom/poshmark/ui/customviews/ScalableView;->cropSpace:Landroid/graphics/RectF;

    iget v4, v0, Landroid/graphics/RectF;->top:F

    iget-object v5, p0, Lcom/poshmark/ui/customviews/ScalableView;->mTransparentLayerPaint:Landroid/graphics/Paint;

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 106
    iget v0, v6, Landroid/graphics/Rect;->left:I

    int-to-float v1, v0

    iget-object v0, p0, Lcom/poshmark/ui/customviews/ScalableView;->cropSpace:Landroid/graphics/RectF;

    iget v2, v0, Landroid/graphics/RectF;->bottom:F

    iget-object v0, p0, Lcom/poshmark/ui/customviews/ScalableView;->cropSpace:Landroid/graphics/RectF;

    iget v3, v0, Landroid/graphics/RectF;->right:F

    iget v0, v6, Landroid/graphics/Rect;->bottom:I

    int-to-float v4, v0

    iget-object v5, p0, Lcom/poshmark/ui/customviews/ScalableView;->mTransparentLayerPaint:Landroid/graphics/Paint;

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 107
    iget v0, v6, Landroid/graphics/Rect;->left:I

    int-to-float v1, v0

    iget-object v0, p0, Lcom/poshmark/ui/customviews/ScalableView;->cropSpace:Landroid/graphics/RectF;

    iget v2, v0, Landroid/graphics/RectF;->top:F

    iget-object v0, p0, Lcom/poshmark/ui/customviews/ScalableView;->cropSpace:Landroid/graphics/RectF;

    iget v3, v0, Landroid/graphics/RectF;->left:F

    iget-object v0, p0, Lcom/poshmark/ui/customviews/ScalableView;->cropSpace:Landroid/graphics/RectF;

    iget v4, v0, Landroid/graphics/RectF;->bottom:F

    iget-object v5, p0, Lcom/poshmark/ui/customviews/ScalableView;->mTransparentLayerPaint:Landroid/graphics/Paint;

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 108
    iget-object v0, p0, Lcom/poshmark/ui/customviews/ScalableView;->cropSpace:Landroid/graphics/RectF;

    iget v1, v0, Landroid/graphics/RectF;->right:F

    iget-object v0, p0, Lcom/poshmark/ui/customviews/ScalableView;->cropSpace:Landroid/graphics/RectF;

    iget v2, v0, Landroid/graphics/RectF;->top:F

    iget v0, v6, Landroid/graphics/Rect;->right:I

    int-to-float v3, v0

    iget-object v0, p0, Lcom/poshmark/ui/customviews/ScalableView;->cropSpace:Landroid/graphics/RectF;

    iget v4, v0, Landroid/graphics/RectF;->bottom:F

    iget-object v5, p0, Lcom/poshmark/ui/customviews/ScalableView;->mTransparentLayerPaint:Landroid/graphics/Paint;

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 109
    return-void
.end method

.method private resize(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    .locals 12
    .param p1, "image"    # Landroid/graphics/Bitmap;
    .param p2, "maxWidth"    # I

    .prologue
    const/4 v11, 0x0

    .line 350
    sget-object v9, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    invoke-static {p2, p2, v9}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v2

    .line 352
    .local v2, "correctBmp":Landroid/graphics/Bitmap;
    const/4 v7, 0x0

    .local v7, "xTranslate":F
    const/4 v8, 0x0

    .line 354
    .local v8, "yTranslate":F
    iget v9, p0, Lcom/poshmark/ui/customviews/ScalableView;->cropImageWidth:F

    iget-object v10, p0, Lcom/poshmark/ui/customviews/ScalableView;->cropSpace:Landroid/graphics/RectF;

    invoke-virtual {v10}, Landroid/graphics/RectF;->width()F

    move-result v10

    div-float v6, v9, v10

    .line 355
    .local v6, "scaleFactor":F
    iget v9, p0, Lcom/poshmark/ui/customviews/ScalableView;->cropImageWidth:F

    invoke-virtual {p1}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v10

    int-to-float v10, v10

    div-float v0, v9, v10

    .line 356
    .local v0, "bitmapScaleFactor":F
    new-instance v4, Landroid/graphics/RectF;

    invoke-direct {v4}, Landroid/graphics/RectF;-><init>()V

    .line 357
    .local v4, "r":Landroid/graphics/RectF;
    iget-object v9, p0, Lcom/poshmark/ui/customviews/ScalableView;->matrix:Landroid/graphics/Matrix;

    invoke-virtual {v9, v4}, Landroid/graphics/Matrix;->mapRect(Landroid/graphics/RectF;)Z

    .line 358
    iget v9, v4, Landroid/graphics/RectF;->left:F

    iget-object v10, p0, Lcom/poshmark/ui/customviews/ScalableView;->cropSpace:Landroid/graphics/RectF;

    iget v10, v10, Landroid/graphics/RectF;->left:F

    sub-float v7, v9, v10

    .line 359
    iget v9, v4, Landroid/graphics/RectF;->top:F

    iget-object v10, p0, Lcom/poshmark/ui/customviews/ScalableView;->cropSpace:Landroid/graphics/RectF;

    iget v10, v10, Landroid/graphics/RectF;->top:F

    sub-float v8, v9, v10

    .line 361
    iget v9, v4, Landroid/graphics/RectF;->left:F

    const/high16 v10, 0x41200000    # 10.0f

    cmpl-float v9, v9, v10

    if-lez v9, :cond_0

    .line 362
    mul-float/2addr v7, v6

    .line 366
    :goto_0
    const/4 v9, 0x0

    cmpl-float v9, v8, v9

    if-lez v9, :cond_1

    .line 367
    mul-float/2addr v8, v6

    .line 374
    :goto_1
    new-instance v5, Landroid/graphics/Matrix;

    invoke-direct {v5}, Landroid/graphics/Matrix;-><init>()V

    .line 375
    .local v5, "resizeMatrix":Landroid/graphics/Matrix;
    invoke-virtual {v5, v6, v6}, Landroid/graphics/Matrix;->setScale(FF)V

    .line 376
    invoke-virtual {v5, v7, v8}, Landroid/graphics/Matrix;->postTranslate(FF)Z

    .line 377
    new-instance v1, Landroid/graphics/Canvas;

    invoke-direct {v1, v2}, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V

    .line 378
    .local v1, "canvas":Landroid/graphics/Canvas;
    new-instance v3, Landroid/graphics/Paint;

    invoke-direct {v3}, Landroid/graphics/Paint;-><init>()V

    .line 379
    .local v3, "paint":Landroid/graphics/Paint;
    invoke-virtual {v3, v11}, Landroid/graphics/Paint;->setFilterBitmap(Z)V

    .line 380
    sget-object v9, Landroid/graphics/PorterDuff$Mode;->CLEAR:Landroid/graphics/PorterDuff$Mode;

    invoke-virtual {v1, v11, v9}, Landroid/graphics/Canvas;->drawColor(ILandroid/graphics/PorterDuff$Mode;)V

    .line 381
    invoke-virtual {v1, p1, v5, v3}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;Landroid/graphics/Paint;)V

    .line 382
    return-object v2

    .line 364
    .end local v1    # "canvas":Landroid/graphics/Canvas;
    .end local v3    # "paint":Landroid/graphics/Paint;
    .end local v5    # "resizeMatrix":Landroid/graphics/Matrix;
    :cond_0
    const/4 v7, 0x0

    goto :goto_0

    .line 369
    :cond_1
    const/4 v8, 0x0

    goto :goto_1
.end method


# virtual methods
.method public getCroppedImage()Landroid/net/Uri;
    .locals 22

    .prologue
    .line 292
    new-instance v21, Landroid/graphics/RectF;

    invoke-direct/range {v21 .. v21}, Landroid/graphics/RectF;-><init>()V

    .line 293
    .local v21, "r":Landroid/graphics/RectF;
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/poshmark/ui/customviews/ScalableView;->matrix:Landroid/graphics/Matrix;

    move-object/from16 v0, v21

    invoke-virtual {v2, v0}, Landroid/graphics/Matrix;->mapRect(Landroid/graphics/RectF;)Z

    .line 294
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/poshmark/ui/customviews/ScalableView;->bitmap:Landroid/graphics/Bitmap;

    const/4 v3, 0x0

    const/4 v4, 0x0

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/poshmark/ui/customviews/ScalableView;->bitmap:Landroid/graphics/Bitmap;

    invoke-virtual {v7}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v5

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/poshmark/ui/customviews/ScalableView;->bitmap:Landroid/graphics/Bitmap;

    invoke-virtual {v7}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v6

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/poshmark/ui/customviews/ScalableView;->matrix:Landroid/graphics/Matrix;

    const/4 v8, 0x1

    invoke-static/range {v2 .. v8}, Landroid/graphics/Bitmap;->createBitmap(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;

    move-result-object v2

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/poshmark/ui/customviews/ScalableView;->resizedBitmap:Landroid/graphics/Bitmap;

    .line 295
    move-object/from16 v0, v21

    iget v2, v0, Landroid/graphics/RectF;->left:F

    float-to-int v10, v2

    .line 296
    .local v10, "bLeft":I
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/poshmark/ui/customviews/ScalableView;->cropSpace:Landroid/graphics/RectF;

    iget v2, v2, Landroid/graphics/RectF;->left:F

    float-to-int v15, v2

    .line 297
    .local v15, "cropLeft":I
    sub-int v3, v15, v10

    .line 299
    .local v3, "finalLeft":I
    move-object/from16 v0, v21

    iget v2, v0, Landroid/graphics/RectF;->top:F

    float-to-int v12, v2

    .line 300
    .local v12, "bTop":I
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/poshmark/ui/customviews/ScalableView;->cropSpace:Landroid/graphics/RectF;

    iget v2, v2, Landroid/graphics/RectF;->top:F

    float-to-int v0, v2

    move/from16 v17, v0

    .line 301
    .local v17, "cropTop":I
    sub-int v4, v17, v12

    .line 303
    .local v4, "finalTop":I
    move-object/from16 v0, v21

    iget v2, v0, Landroid/graphics/RectF;->left:F

    float-to-int v2, v2

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/poshmark/ui/customviews/ScalableView;->resizedBitmap:Landroid/graphics/Bitmap;

    invoke-virtual {v7}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v7

    add-int v11, v2, v7

    .line 304
    .local v11, "bRight":I
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/poshmark/ui/customviews/ScalableView;->cropSpace:Landroid/graphics/RectF;

    iget v2, v2, Landroid/graphics/RectF;->right:F

    float-to-int v0, v2

    move/from16 v16, v0

    .line 305
    .local v16, "cropRight":I
    sub-int v20, v16, v11

    .line 307
    .local v20, "finalRight":I
    move-object/from16 v0, v21

    iget v2, v0, Landroid/graphics/RectF;->top:F

    float-to-int v2, v2

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/poshmark/ui/customviews/ScalableView;->resizedBitmap:Landroid/graphics/Bitmap;

    invoke-virtual {v7}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v7

    add-int v9, v2, v7

    .line 308
    .local v9, "bBottom":I
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/poshmark/ui/customviews/ScalableView;->cropSpace:Landroid/graphics/RectF;

    iget v2, v2, Landroid/graphics/RectF;->bottom:F

    float-to-int v14, v2

    .line 309
    .local v14, "cropBottom":I
    sub-int v19, v14, v9

    .line 314
    .local v19, "finalBottom":I
    if-gez v3, :cond_0

    .line 315
    const/4 v3, 0x0

    .line 321
    :goto_0
    if-gez v4, :cond_1

    .line 322
    const/4 v4, 0x0

    .line 328
    :goto_1
    if-lez v20, :cond_2

    .line 329
    move/from16 v20, v3

    .line 336
    :goto_2
    if-lez v19, :cond_3

    .line 337
    move/from16 v19, v4

    .line 342
    :goto_3
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/poshmark/ui/customviews/ScalableView;->resizedBitmap:Landroid/graphics/Bitmap;

    invoke-virtual {v2}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v2

    sub-int v5, v2, v20

    .line 343
    .local v5, "resizedWidth":I
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/poshmark/ui/customviews/ScalableView;->resizedBitmap:Landroid/graphics/Bitmap;

    invoke-virtual {v2}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v2

    sub-int v6, v2, v19

    .line 344
    .local v6, "resiszedHeight":I
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/poshmark/ui/customviews/ScalableView;->resizedBitmap:Landroid/graphics/Bitmap;

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/poshmark/ui/customviews/ScalableView;->matrix:Landroid/graphics/Matrix;

    const/4 v8, 0x1

    invoke-static/range {v2 .. v8}, Landroid/graphics/Bitmap;->createBitmap(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;

    move-result-object v18

    .line 345
    .local v18, "croppedBitmap":Landroid/graphics/Bitmap;
    move-object/from16 v0, p0

    iget v2, v0, Lcom/poshmark/ui/customviews/ScalableView;->cropImageWidth:F

    float-to-int v2, v2

    move-object/from16 v0, p0

    move-object/from16 v1, v18

    invoke-direct {v0, v1, v2}, Lcom/poshmark/ui/customviews/ScalableView;->resize(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;

    move-result-object v13

    .line 346
    .local v13, "correctBmp":Landroid/graphics/Bitmap;
    invoke-static {v13}, Lcom/poshmark/utils/ImageUtils;->saveBitmapToDisk(Landroid/graphics/Bitmap;)Landroid/net/Uri;

    move-result-object v2

    return-object v2

    .line 317
    .end local v5    # "resizedWidth":I
    .end local v6    # "resiszedHeight":I
    .end local v13    # "correctBmp":Landroid/graphics/Bitmap;
    .end local v18    # "croppedBitmap":Landroid/graphics/Bitmap;
    :cond_0
    invoke-static {v3}, Ljava/lang/Math;->abs(I)I

    move-result v3

    goto :goto_0

    .line 324
    :cond_1
    invoke-static {v4}, Ljava/lang/Math;->abs(I)I

    move-result v4

    goto :goto_1

    .line 331
    :cond_2
    invoke-static/range {v20 .. v20}, Ljava/lang/Math;->abs(I)I

    move-result v2

    add-int v20, v2, v3

    goto :goto_2

    .line 339
    :cond_3
    invoke-static/range {v19 .. v19}, Ljava/lang/Math;->abs(I)I

    move-result v2

    add-int v19, v2, v4

    goto :goto_3
.end method

.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 5
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 88
    iput-object p1, p0, Lcom/poshmark/ui/customviews/ScalableView;->canvas:Landroid/graphics/Canvas;

    .line 89
    invoke-virtual {p1}, Landroid/graphics/Canvas;->save()I

    .line 90
    iget-object v0, p0, Lcom/poshmark/ui/customviews/ScalableView;->matrix:Landroid/graphics/Matrix;

    invoke-virtual {v0}, Landroid/graphics/Matrix;->reset()V

    .line 91
    iget-object v0, p0, Lcom/poshmark/ui/customviews/ScalableView;->matrix:Landroid/graphics/Matrix;

    iget v1, p0, Lcom/poshmark/ui/customviews/ScalableView;->mScaleFactor:F

    iget v2, p0, Lcom/poshmark/ui/customviews/ScalableView;->mScaleFactor:F

    iget v3, p0, Lcom/poshmark/ui/customviews/ScalableView;->pivotX:F

    iget v4, p0, Lcom/poshmark/ui/customviews/ScalableView;->pivotY:F

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/graphics/Matrix;->setScale(FFFF)V

    .line 92
    iget-object v0, p0, Lcom/poshmark/ui/customviews/ScalableView;->matrix:Landroid/graphics/Matrix;

    iget v1, p0, Lcom/poshmark/ui/customviews/ScalableView;->mPosX:F

    iget v2, p0, Lcom/poshmark/ui/customviews/ScalableView;->mPosY:F

    invoke-virtual {v0, v1, v2}, Landroid/graphics/Matrix;->postTranslate(FF)Z

    .line 94
    iget-object v0, p0, Lcom/poshmark/ui/customviews/ScalableView;->bitmap:Landroid/graphics/Bitmap;

    iget-object v1, p0, Lcom/poshmark/ui/customviews/ScalableView;->matrix:Landroid/graphics/Matrix;

    iget-object v2, p0, Lcom/poshmark/ui/customviews/ScalableView;->backgroundPaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v0, v1, v2}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;Landroid/graphics/Paint;)V

    .line 96
    invoke-direct {p0, p1}, Lcom/poshmark/ui/customviews/ScalableView;->drawGrid(Landroid/graphics/Canvas;)V

    .line 97
    invoke-virtual {p1}, Landroid/graphics/Canvas;->restore()V

    .line 98
    return-void
.end method

.method protected onMeasure(II)V
    .locals 2
    .param p1, "widthMeasureSpec"    # I
    .param p2, "heightMeasureSpec"    # I

    .prologue
    .line 81
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v0

    iput v0, p0, Lcom/poshmark/ui/customviews/ScalableView;->parentWidth:I

    .line 82
    invoke-static {p2}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v0

    iput v0, p0, Lcom/poshmark/ui/customviews/ScalableView;->parentHeight:I

    .line 83
    iget v0, p0, Lcom/poshmark/ui/customviews/ScalableView;->parentWidth:I

    iget v1, p0, Lcom/poshmark/ui/customviews/ScalableView;->parentHeight:I

    invoke-virtual {p0, v0, v1}, Lcom/poshmark/ui/customviews/ScalableView;->setMeasuredDimension(II)V

    .line 84
    return-void
.end method

.method public onScale(Landroid/view/ScaleGestureDetector;)Z
    .locals 3
    .param p1, "scaleGestureDetector"    # Landroid/view/ScaleGestureDetector;

    .prologue
    .line 156
    const-string v0, "MytextView"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "onScale"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Landroid/view/ScaleGestureDetector;->getScaleFactor()F

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 158
    iget v0, p0, Lcom/poshmark/ui/customviews/ScalableView;->mScaleFactor:F

    invoke-virtual {p1}, Landroid/view/ScaleGestureDetector;->getScaleFactor()F

    move-result v1

    mul-float/2addr v0, v1

    iput v0, p0, Lcom/poshmark/ui/customviews/ScalableView;->mScaleFactor:F

    .line 159
    const/high16 v0, 0x3f000000    # 0.5f

    iget v1, p0, Lcom/poshmark/ui/customviews/ScalableView;->mScaleFactor:F

    const/high16 v2, 0x40400000    # 3.0f

    invoke-static {v1, v2}, Ljava/lang/Math;->min(FF)F

    move-result v1

    invoke-static {v0, v1}, Ljava/lang/Math;->max(FF)F

    move-result v0

    iput v0, p0, Lcom/poshmark/ui/customviews/ScalableView;->mScaleFactor:F

    .line 160
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ScalableView;->invalidate()V

    .line 161
    const/4 v0, 0x1

    return v0
.end method

.method public onScaleBegin(Landroid/view/ScaleGestureDetector;)Z
    .locals 2
    .param p1, "scaleGestureDetector"    # Landroid/view/ScaleGestureDetector;

    .prologue
    .line 166
    const-string v0, "MytextView"

    const-string v1, "onScaleBegin"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 167
    const/4 v0, 0x1

    return v0
.end method

.method public onScaleEnd(Landroid/view/ScaleGestureDetector;)V
    .locals 2
    .param p1, "scaleGestureDetector"    # Landroid/view/ScaleGestureDetector;

    .prologue
    .line 172
    const-string v0, "MytextView"

    const-string v1, "onScaleEnd"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 174
    return-void
.end method

.method public onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .locals 10
    .param p1, "view"    # Landroid/view/View;
    .param p2, "motionEvent"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v8, 0x1

    const/4 v3, 0x0

    .line 207
    iget-object v9, p0, Lcom/poshmark/ui/customviews/ScalableView;->scaleGestureDetector:Landroid/view/ScaleGestureDetector;

    invoke-virtual {v9, p2}, Landroid/view/ScaleGestureDetector;->onTouchEvent(Landroid/view/MotionEvent;)Z

    .line 208
    invoke-static {p2}, Landroid/support/v4/view/MotionEventCompat;->getActionMasked(Landroid/view/MotionEvent;)I

    move-result v0

    .line 209
    .local v0, "action":I
    packed-switch v0, :pswitch_data_0

    .line 271
    :cond_0
    :goto_0
    :pswitch_0
    return v8

    .line 211
    :pswitch_1
    invoke-static {p2}, Landroid/support/v4/view/MotionEventCompat;->getActionIndex(Landroid/view/MotionEvent;)I

    move-result v5

    .line 212
    .local v5, "pointerIndex":I
    invoke-static {p2, v5}, Landroid/support/v4/view/MotionEventCompat;->getX(Landroid/view/MotionEvent;I)F

    move-result v6

    .line 213
    .local v6, "x":F
    invoke-static {p2, v5}, Landroid/support/v4/view/MotionEventCompat;->getY(Landroid/view/MotionEvent;I)F

    move-result v7

    .line 216
    .local v7, "y":F
    iput v6, p0, Lcom/poshmark/ui/customviews/ScalableView;->mLastTouchX:F

    .line 217
    iput v7, p0, Lcom/poshmark/ui/customviews/ScalableView;->mLastTouchY:F

    .line 219
    invoke-static {p2, v3}, Landroid/support/v4/view/MotionEventCompat;->getPointerId(Landroid/view/MotionEvent;I)I

    move-result v9

    iput v9, p0, Lcom/poshmark/ui/customviews/ScalableView;->active_pointer_id:I

    goto :goto_0

    .line 225
    .end local v5    # "pointerIndex":I
    .end local v6    # "x":F
    .end local v7    # "y":F
    :pswitch_2
    iget v9, p0, Lcom/poshmark/ui/customviews/ScalableView;->active_pointer_id:I

    invoke-static {p2, v9}, Landroid/support/v4/view/MotionEventCompat;->findPointerIndex(Landroid/view/MotionEvent;I)I

    move-result v5

    .line 226
    .restart local v5    # "pointerIndex":I
    invoke-static {p2, v5}, Landroid/support/v4/view/MotionEventCompat;->getX(Landroid/view/MotionEvent;I)F

    move-result v6

    .line 227
    .restart local v6    # "x":F
    invoke-static {p2, v5}, Landroid/support/v4/view/MotionEventCompat;->getY(Landroid/view/MotionEvent;I)F

    move-result v7

    .line 229
    .restart local v7    # "y":F
    iget-object v9, p0, Lcom/poshmark/ui/customviews/ScalableView;->scaleGestureDetector:Landroid/view/ScaleGestureDetector;

    invoke-virtual {v9}, Landroid/view/ScaleGestureDetector;->isInProgress()Z

    move-result v9

    if-nez v9, :cond_1

    .line 231
    iget v9, p0, Lcom/poshmark/ui/customviews/ScalableView;->mLastTouchX:F

    sub-float v1, v6, v9

    .line 232
    .local v1, "dx":F
    iget v9, p0, Lcom/poshmark/ui/customviews/ScalableView;->mLastTouchY:F

    sub-float v2, v7, v9

    .line 233
    .local v2, "dy":F
    iget v9, p0, Lcom/poshmark/ui/customviews/ScalableView;->mPosX:F

    add-float/2addr v9, v1

    iput v9, p0, Lcom/poshmark/ui/customviews/ScalableView;->mPosX:F

    .line 234
    iget v9, p0, Lcom/poshmark/ui/customviews/ScalableView;->mPosY:F

    add-float/2addr v9, v2

    iput v9, p0, Lcom/poshmark/ui/customviews/ScalableView;->mPosY:F

    .line 235
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ScalableView;->invalidate()V

    .line 239
    .end local v1    # "dx":F
    .end local v2    # "dy":F
    :cond_1
    iput v6, p0, Lcom/poshmark/ui/customviews/ScalableView;->mLastTouchX:F

    .line 240
    iput v7, p0, Lcom/poshmark/ui/customviews/ScalableView;->mLastTouchY:F

    goto :goto_0

    .line 246
    .end local v5    # "pointerIndex":I
    .end local v6    # "x":F
    .end local v7    # "y":F
    :pswitch_3
    iget v9, p0, Lcom/poshmark/ui/customviews/ScalableView;->INVALID_POINTER_ID:I

    iput v9, p0, Lcom/poshmark/ui/customviews/ScalableView;->active_pointer_id:I

    goto :goto_0

    .line 251
    :pswitch_4
    iget v9, p0, Lcom/poshmark/ui/customviews/ScalableView;->INVALID_POINTER_ID:I

    iput v9, p0, Lcom/poshmark/ui/customviews/ScalableView;->active_pointer_id:I

    goto :goto_0

    .line 257
    :pswitch_5
    invoke-static {p2}, Landroid/support/v4/view/MotionEventCompat;->getActionIndex(Landroid/view/MotionEvent;)I

    move-result v5

    .line 258
    .restart local v5    # "pointerIndex":I
    invoke-static {p2, v5}, Landroid/support/v4/view/MotionEventCompat;->getPointerId(Landroid/view/MotionEvent;I)I

    move-result v4

    .line 260
    .local v4, "pointerId":I
    iget v9, p0, Lcom/poshmark/ui/customviews/ScalableView;->active_pointer_id:I

    if-ne v4, v9, :cond_0

    .line 263
    if-nez v5, :cond_2

    move v3, v8

    .line 264
    .local v3, "newPointerIndex":I
    :cond_2
    invoke-static {p2, v3}, Landroid/support/v4/view/MotionEventCompat;->getX(Landroid/view/MotionEvent;I)F

    move-result v9

    iput v9, p0, Lcom/poshmark/ui/customviews/ScalableView;->mLastTouchX:F

    .line 265
    invoke-static {p2, v3}, Landroid/support/v4/view/MotionEventCompat;->getY(Landroid/view/MotionEvent;I)F

    move-result v9

    iput v9, p0, Lcom/poshmark/ui/customviews/ScalableView;->mLastTouchY:F

    .line 266
    invoke-static {p2, v3}, Landroid/support/v4/view/MotionEventCompat;->getPointerId(Landroid/view/MotionEvent;I)I

    move-result v9

    iput v9, p0, Lcom/poshmark/ui/customviews/ScalableView;->active_pointer_id:I

    goto :goto_0

    .line 209
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_3
        :pswitch_2
        :pswitch_4
        :pswitch_0
        :pswitch_0
        :pswitch_5
    .end packed-switch
.end method

.method public setFileName(Ljava/lang/String;)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 386
    iput-object p1, p0, Lcom/poshmark/ui/customviews/ScalableView;->bmpFileName:Ljava/lang/String;

    .line 387
    return-void
.end method

.method public setMode(I)V
    .locals 1
    .param p1, "creation_mode"    # I

    .prologue
    .line 275
    packed-switch p1, :pswitch_data_0

    .line 284
    :goto_0
    return-void

    .line 277
    :pswitch_0
    const/high16 v0, 0x42c80000    # 100.0f

    iput v0, p0, Lcom/poshmark/ui/customviews/ScalableView;->cropImageWidth:F

    goto :goto_0

    .line 281
    :pswitch_1
    const/high16 v0, 0x44800000    # 1024.0f

    iput v0, p0, Lcom/poshmark/ui/customviews/ScalableView;->cropImageWidth:F

    goto :goto_0

    .line 275
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public setupBitmap(Landroid/graphics/Rect;)V
    .locals 5
    .param p1, "viewPort"    # Landroid/graphics/Rect;

    .prologue
    .line 131
    new-instance v0, Landroid/graphics/BitmapFactory$Options;

    invoke-direct {v0}, Landroid/graphics/BitmapFactory$Options;-><init>()V

    .line 132
    .local v0, "options":Landroid/graphics/BitmapFactory$Options;
    iget v2, p0, Lcom/poshmark/ui/customviews/ScalableView;->parentWidth:I

    iget v3, p0, Lcom/poshmark/ui/customviews/ScalableView;->parentHeight:I

    invoke-static {v0, v2, v3}, Lcom/poshmark/utils/ImageUtils;->calculateInSampleSize(Landroid/graphics/BitmapFactory$Options;II)I

    move-result v1

    .line 133
    .local v1, "sampleSize":I
    const/4 v2, 0x0

    iput-boolean v2, v0, Landroid/graphics/BitmapFactory$Options;->inJustDecodeBounds:Z

    .line 134
    iput v1, v0, Landroid/graphics/BitmapFactory$Options;->inSampleSize:I

    .line 136
    iget-object v2, p0, Lcom/poshmark/ui/customviews/ScalableView;->bmpFileName:Ljava/lang/String;

    invoke-static {v2, v0}, Lcom/newrelic/agent/android/instrumentation/BitmapFactoryInstrumentation;->decodeFile(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/ui/customviews/ScalableView;->bitmap:Landroid/graphics/Bitmap;

    .line 138
    iget v2, p1, Landroid/graphics/Rect;->left:I

    invoke-virtual {p1}, Landroid/graphics/Rect;->width()I

    move-result v3

    div-int/lit8 v3, v3, 0x2

    add-int/2addr v2, v3

    iget-object v3, p0, Lcom/poshmark/ui/customviews/ScalableView;->bitmap:Landroid/graphics/Bitmap;

    invoke-virtual {v3}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v3

    div-int/lit8 v3, v3, 0x2

    sub-int/2addr v2, v3

    int-to-float v2, v2

    iput v2, p0, Lcom/poshmark/ui/customviews/ScalableView;->mCenterX:F

    iput v2, p0, Lcom/poshmark/ui/customviews/ScalableView;->mPosX:F

    .line 139
    iget v2, p1, Landroid/graphics/Rect;->top:I

    invoke-virtual {p1}, Landroid/graphics/Rect;->height()I

    move-result v3

    div-int/lit8 v3, v3, 0x2

    add-int/2addr v2, v3

    iget-object v3, p0, Lcom/poshmark/ui/customviews/ScalableView;->bitmap:Landroid/graphics/Bitmap;

    invoke-virtual {v3}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v3

    div-int/lit8 v3, v3, 0x2

    sub-int/2addr v2, v3

    int-to-float v2, v2

    iput v2, p0, Lcom/poshmark/ui/customviews/ScalableView;->mCenterY:F

    iput v2, p0, Lcom/poshmark/ui/customviews/ScalableView;->mPosY:F

    .line 140
    iget-object v2, p0, Lcom/poshmark/ui/customviews/ScalableView;->bitmap:Landroid/graphics/Bitmap;

    invoke-virtual {v2}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v2

    div-int/lit8 v2, v2, 0x2

    int-to-float v2, v2

    iput v2, p0, Lcom/poshmark/ui/customviews/ScalableView;->pivotX:F

    .line 141
    iget-object v2, p0, Lcom/poshmark/ui/customviews/ScalableView;->bitmap:Landroid/graphics/Bitmap;

    invoke-virtual {v2}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v2

    div-int/lit8 v2, v2, 0x2

    int-to-float v2, v2

    iput v2, p0, Lcom/poshmark/ui/customviews/ScalableView;->pivotY:F

    .line 144
    iget-object v2, p0, Lcom/poshmark/ui/customviews/ScalableView;->cropSpace:Landroid/graphics/RectF;

    iget v3, p1, Landroid/graphics/Rect;->left:I

    int-to-float v3, v3

    iput v3, v2, Landroid/graphics/RectF;->left:F

    .line 145
    iget-object v2, p0, Lcom/poshmark/ui/customviews/ScalableView;->cropSpace:Landroid/graphics/RectF;

    iget v3, p1, Landroid/graphics/Rect;->top:I

    int-to-float v3, v3

    iput v3, v2, Landroid/graphics/RectF;->top:F

    .line 146
    iget-object v2, p0, Lcom/poshmark/ui/customviews/ScalableView;->cropSpace:Landroid/graphics/RectF;

    iget v3, p1, Landroid/graphics/Rect;->left:I

    invoke-virtual {p1}, Landroid/graphics/Rect;->width()I

    move-result v4

    add-int/2addr v3, v4

    int-to-float v3, v3

    iput v3, v2, Landroid/graphics/RectF;->right:F

    .line 147
    iget-object v2, p0, Lcom/poshmark/ui/customviews/ScalableView;->cropSpace:Landroid/graphics/RectF;

    iget v3, p1, Landroid/graphics/Rect;->top:I

    invoke-virtual {p1}, Landroid/graphics/Rect;->height()I

    move-result v4

    add-int/2addr v3, v4

    int-to-float v3, v3

    iput v3, v2, Landroid/graphics/RectF;->bottom:F

    .line 149
    sget-object v2, Landroid/widget/ImageView$ScaleType;->CENTER:Landroid/widget/ImageView$ScaleType;

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/customviews/ScalableView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V

    .line 152
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ScalableView;->invalidate()V

    .line 153
    return-void
.end method
