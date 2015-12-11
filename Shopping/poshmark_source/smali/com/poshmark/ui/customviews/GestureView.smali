.class public Lcom/poshmark/ui/customviews/GestureView;
.super Landroid/view/SurfaceView;
.source "GestureView.java"

# interfaces
.implements Lcom/poshmark/utils/PMGestureDetectorListener;


# static fields
.field private static final CREATE_COVERSHOT:I = 0x1

.field private static final CREATE_THUMBNAIL:I = 0x0

.field private static final DEFAULT_GRIDLINE_COLOUR_ID:Ljava/lang/String; = "#FFFFFF"

.field private static final GRID_COLUMN_COUNT:I = 0x3

.field private static final GRID_ROW_COUNT:I = 0x3

.field private static final MAX_SCALEFACTOR:F = 3.0f

.field private static final MIN_SCALEFACTOR:F = 0.5f

.field private static final TAG:Ljava/lang/String; = "GESTURE VIEW"


# instance fields
.field backgroundPaint:Landroid/graphics/Paint;

.field bitmap:Landroid/graphics/Bitmap;

.field bitmapTopLeft:Landroid/graphics/Point;

.field bmpFileName:Ljava/lang/String;

.field cenX:I

.field cenY:I

.field cropImageWidth:I

.field cropSpace:Landroid/graphics/Rect;

.field currentMatrix:Landroid/graphics/Matrix;

.field dragXOffset:I

.field dragYOffset:I

.field gestureDetector:Lcom/poshmark/utils/PMGestureDetector;

.field holder:Landroid/view/SurfaceHolder;

.field isDragging:Z

.field isPinchZooming:Z

.field mGridLinePaint:Landroid/graphics/Paint;

.field private mPts:[F

.field pivot:Landroid/graphics/Point;

.field utils:Lcom/poshmark/utils/GestureViewUtils;

.field xCurrentScaleFactor:F

.field xPinchDistance:F

.field yPinchDistance:F


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v2, 0x0

    .line 62
    invoke-direct {p0, p1, p2}, Landroid/view/SurfaceView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 45
    iput-boolean v2, p0, Lcom/poshmark/ui/customviews/GestureView;->isDragging:Z

    .line 46
    iput-boolean v2, p0, Lcom/poshmark/ui/customviews/GestureView;->isPinchZooming:Z

    .line 49
    const/4 v2, 0x0

    iput-object v2, p0, Lcom/poshmark/ui/customviews/GestureView;->bitmapTopLeft:Landroid/graphics/Point;

    .line 50
    new-instance v2, Landroid/graphics/Point;

    invoke-direct {v2}, Landroid/graphics/Point;-><init>()V

    iput-object v2, p0, Lcom/poshmark/ui/customviews/GestureView;->pivot:Landroid/graphics/Point;

    .line 55
    const/high16 v2, 0x3f800000    # 1.0f

    iput v2, p0, Lcom/poshmark/ui/customviews/GestureView;->xCurrentScaleFactor:F

    .line 56
    new-instance v2, Landroid/graphics/Matrix;

    invoke-direct {v2}, Landroid/graphics/Matrix;-><init>()V

    iput-object v2, p0, Lcom/poshmark/ui/customviews/GestureView;->currentMatrix:Landroid/graphics/Matrix;

    .line 64
    new-instance v2, Landroid/graphics/Paint;

    invoke-direct {v2}, Landroid/graphics/Paint;-><init>()V

    iput-object v2, p0, Lcom/poshmark/ui/customviews/GestureView;->backgroundPaint:Landroid/graphics/Paint;

    .line 65
    iget-object v2, p0, Lcom/poshmark/ui/customviews/GestureView;->backgroundPaint:Landroid/graphics/Paint;

    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setDither(Z)V

    .line 67
    new-instance v2, Landroid/graphics/Paint;

    invoke-direct {v2}, Landroid/graphics/Paint;-><init>()V

    iput-object v2, p0, Lcom/poshmark/ui/customviews/GestureView;->mGridLinePaint:Landroid/graphics/Paint;

    .line 68
    iget-object v2, p0, Lcom/poshmark/ui/customviews/GestureView;->mGridLinePaint:Landroid/graphics/Paint;

    const-string v3, "#FFFFFF"

    invoke-static {v3}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v3

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setColor(I)V

    .line 69
    const/16 v1, 0x8

    .line 70
    .local v1, "rowLineCount":I
    const/16 v0, 0x8

    .line 71
    .local v0, "columnLineCount":I
    const/16 v2, 0x10

    new-array v2, v2, [F

    iput-object v2, p0, Lcom/poshmark/ui/customviews/GestureView;->mPts:[F

    .line 72
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/GestureView;->getHolder()Landroid/view/SurfaceHolder;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/ui/customviews/GestureView;->holder:Landroid/view/SurfaceHolder;

    .line 73
    new-instance v2, Lcom/poshmark/utils/GestureViewUtils;

    invoke-direct {v2}, Lcom/poshmark/utils/GestureViewUtils;-><init>()V

    iput-object v2, p0, Lcom/poshmark/ui/customviews/GestureView;->utils:Lcom/poshmark/utils/GestureViewUtils;

    .line 74
    return-void
.end method

.method private drawGrid(Landroid/graphics/Canvas;)V
    .locals 9
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    const/4 v8, 0x2

    const/high16 v7, 0x40400000    # 3.0f

    const/high16 v6, 0x3f800000    # 1.0f

    .line 155
    const/4 v1, 0x0

    .line 156
    .local v1, "index":I
    const/4 v0, 0x0

    .local v0, "i":I
    move v2, v1

    .end local v1    # "index":I
    .local v2, "index":I
    :goto_0
    if-ge v0, v8, :cond_0

    .line 157
    iget-object v3, p0, Lcom/poshmark/ui/customviews/GestureView;->mPts:[F

    add-int/lit8 v1, v2, 0x1

    .end local v2    # "index":I
    .restart local v1    # "index":I
    iget-object v4, p0, Lcom/poshmark/ui/customviews/GestureView;->cropSpace:Landroid/graphics/Rect;

    iget v4, v4, Landroid/graphics/Rect;->left:I

    int-to-float v4, v4

    aput v4, v3, v2

    .line 158
    iget-object v3, p0, Lcom/poshmark/ui/customviews/GestureView;->mPts:[F

    add-int/lit8 v2, v1, 0x1

    .end local v1    # "index":I
    .restart local v2    # "index":I
    iget-object v4, p0, Lcom/poshmark/ui/customviews/GestureView;->cropSpace:Landroid/graphics/Rect;

    invoke-virtual {v4}, Landroid/graphics/Rect;->height()I

    move-result v4

    int-to-float v4, v4

    int-to-float v5, v0

    add-float/2addr v5, v6

    mul-float/2addr v4, v5

    div-float/2addr v4, v7

    iget-object v5, p0, Lcom/poshmark/ui/customviews/GestureView;->cropSpace:Landroid/graphics/Rect;

    iget v5, v5, Landroid/graphics/Rect;->top:I

    int-to-float v5, v5

    add-float/2addr v4, v5

    aput v4, v3, v1

    .line 159
    iget-object v3, p0, Lcom/poshmark/ui/customviews/GestureView;->mPts:[F

    add-int/lit8 v1, v2, 0x1

    .end local v2    # "index":I
    .restart local v1    # "index":I
    iget-object v4, p0, Lcom/poshmark/ui/customviews/GestureView;->cropSpace:Landroid/graphics/Rect;

    iget v4, v4, Landroid/graphics/Rect;->right:I

    int-to-float v4, v4

    aput v4, v3, v2

    .line 160
    iget-object v3, p0, Lcom/poshmark/ui/customviews/GestureView;->mPts:[F

    add-int/lit8 v2, v1, 0x1

    .end local v1    # "index":I
    .restart local v2    # "index":I
    iget-object v4, p0, Lcom/poshmark/ui/customviews/GestureView;->cropSpace:Landroid/graphics/Rect;

    invoke-virtual {v4}, Landroid/graphics/Rect;->height()I

    move-result v4

    int-to-float v4, v4

    int-to-float v5, v0

    add-float/2addr v5, v6

    mul-float/2addr v4, v5

    div-float/2addr v4, v7

    iget-object v5, p0, Lcom/poshmark/ui/customviews/GestureView;->cropSpace:Landroid/graphics/Rect;

    iget v5, v5, Landroid/graphics/Rect;->top:I

    int-to-float v5, v5

    add-float/2addr v4, v5

    aput v4, v3, v1

    .line 156
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 163
    :cond_0
    const/4 v0, 0x0

    :goto_1
    if-ge v0, v8, :cond_1

    .line 164
    iget-object v3, p0, Lcom/poshmark/ui/customviews/GestureView;->mPts:[F

    add-int/lit8 v1, v2, 0x1

    .end local v2    # "index":I
    .restart local v1    # "index":I
    iget-object v4, p0, Lcom/poshmark/ui/customviews/GestureView;->cropSpace:Landroid/graphics/Rect;

    invoke-virtual {v4}, Landroid/graphics/Rect;->width()I

    move-result v4

    int-to-float v4, v4

    int-to-float v5, v0

    add-float/2addr v5, v6

    mul-float/2addr v4, v5

    div-float/2addr v4, v7

    iget-object v5, p0, Lcom/poshmark/ui/customviews/GestureView;->cropSpace:Landroid/graphics/Rect;

    iget v5, v5, Landroid/graphics/Rect;->left:I

    int-to-float v5, v5

    add-float/2addr v4, v5

    aput v4, v3, v2

    .line 165
    iget-object v3, p0, Lcom/poshmark/ui/customviews/GestureView;->mPts:[F

    add-int/lit8 v2, v1, 0x1

    .end local v1    # "index":I
    .restart local v2    # "index":I
    iget-object v4, p0, Lcom/poshmark/ui/customviews/GestureView;->cropSpace:Landroid/graphics/Rect;

    iget v4, v4, Landroid/graphics/Rect;->top:I

    int-to-float v4, v4

    aput v4, v3, v1

    .line 166
    iget-object v3, p0, Lcom/poshmark/ui/customviews/GestureView;->mPts:[F

    add-int/lit8 v1, v2, 0x1

    .end local v2    # "index":I
    .restart local v1    # "index":I
    iget-object v4, p0, Lcom/poshmark/ui/customviews/GestureView;->cropSpace:Landroid/graphics/Rect;

    invoke-virtual {v4}, Landroid/graphics/Rect;->width()I

    move-result v4

    int-to-float v4, v4

    int-to-float v5, v0

    add-float/2addr v5, v6

    mul-float/2addr v4, v5

    div-float/2addr v4, v7

    iget-object v5, p0, Lcom/poshmark/ui/customviews/GestureView;->cropSpace:Landroid/graphics/Rect;

    iget v5, v5, Landroid/graphics/Rect;->left:I

    int-to-float v5, v5

    add-float/2addr v4, v5

    aput v4, v3, v2

    .line 167
    iget-object v3, p0, Lcom/poshmark/ui/customviews/GestureView;->mPts:[F

    add-int/lit8 v2, v1, 0x1

    .end local v1    # "index":I
    .restart local v2    # "index":I
    iget-object v4, p0, Lcom/poshmark/ui/customviews/GestureView;->cropSpace:Landroid/graphics/Rect;

    iget v4, v4, Landroid/graphics/Rect;->bottom:I

    int-to-float v4, v4

    aput v4, v3, v1

    .line 163
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 169
    :cond_1
    iget-object v3, p0, Lcom/poshmark/ui/customviews/GestureView;->mPts:[F

    iget-object v4, p0, Lcom/poshmark/ui/customviews/GestureView;->mGridLinePaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v3, v4}, Landroid/graphics/Canvas;->drawLines([FLandroid/graphics/Paint;)V

    .line 170
    return-void
.end method

.method private getBoundingRect(Landroid/graphics/Point;Landroid/graphics/Point;)Landroid/graphics/Rect;
    .locals 3
    .param p1, "majorPointCurrent"    # Landroid/graphics/Point;
    .param p2, "minorPointCurrent"    # Landroid/graphics/Point;

    .prologue
    .line 176
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    .line 178
    .local v0, "boundingRect":Landroid/graphics/Rect;
    iget v1, p1, Landroid/graphics/Point;->x:I

    iget v2, p2, Landroid/graphics/Point;->x:I

    if-le v1, v2, :cond_0

    .line 179
    iget v1, p2, Landroid/graphics/Point;->x:I

    iput v1, v0, Landroid/graphics/Rect;->left:I

    .line 180
    iget v1, p1, Landroid/graphics/Point;->x:I

    iput v1, v0, Landroid/graphics/Rect;->right:I

    .line 186
    :goto_0
    iget v1, p1, Landroid/graphics/Point;->y:I

    iget v2, p2, Landroid/graphics/Point;->y:I

    if-le v1, v2, :cond_1

    .line 187
    iget v1, p2, Landroid/graphics/Point;->y:I

    iput v1, v0, Landroid/graphics/Rect;->top:I

    .line 188
    iget v1, p1, Landroid/graphics/Point;->y:I

    iput v1, v0, Landroid/graphics/Rect;->bottom:I

    .line 194
    :goto_1
    return-object v0

    .line 182
    :cond_0
    iget v1, p1, Landroid/graphics/Point;->x:I

    iput v1, v0, Landroid/graphics/Rect;->left:I

    .line 183
    iget v1, p2, Landroid/graphics/Point;->x:I

    iput v1, v0, Landroid/graphics/Rect;->right:I

    goto :goto_0

    .line 190
    :cond_1
    iget v1, p1, Landroid/graphics/Point;->y:I

    iput v1, v0, Landroid/graphics/Rect;->top:I

    .line 191
    iget v1, p2, Landroid/graphics/Point;->y:I

    iput v1, v0, Landroid/graphics/Rect;->bottom:I

    goto :goto_1
.end method

.method private isSwipableArea(Landroid/graphics/Point;)Z
    .locals 3
    .param p1, "point"    # Landroid/graphics/Point;

    .prologue
    .line 281
    iget-object v0, p0, Lcom/poshmark/ui/customviews/GestureView;->cropSpace:Landroid/graphics/Rect;

    iget v1, p1, Landroid/graphics/Point;->x:I

    iget v2, p1, Landroid/graphics/Point;->y:I

    invoke-virtual {v0, v1, v2}, Landroid/graphics/Rect;->contains(II)Z

    move-result v0

    return v0
.end method

.method private isSwipableArea(Landroid/graphics/Point;Landroid/graphics/Point;)Z
    .locals 3
    .param p1, "majorPointStart"    # Landroid/graphics/Point;
    .param p2, "minorPointStart"    # Landroid/graphics/Point;

    .prologue
    .line 288
    iget-object v0, p0, Lcom/poshmark/ui/customviews/GestureView;->cropSpace:Landroid/graphics/Rect;

    iget v1, p1, Landroid/graphics/Point;->x:I

    iget v2, p1, Landroid/graphics/Point;->y:I

    invoke-virtual {v0, v1, v2}, Landroid/graphics/Rect;->contains(II)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/ui/customviews/GestureView;->cropSpace:Landroid/graphics/Rect;

    iget v1, p2, Landroid/graphics/Point;->x:I

    iget v2, p2, Landroid/graphics/Point;->y:I

    invoke-virtual {v0, v1, v2}, Landroid/graphics/Rect;->contains(II)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private resetImage()V
    .locals 12

    .prologue
    const/4 v11, 0x1

    const/4 v8, 0x0

    const/4 v10, 0x0

    .line 372
    const/4 v1, 0x1

    .line 373
    .local v1, "TRANSLATE":I
    const/4 v2, 0x2

    .line 374
    .local v2, "TRANSLATE_AND_SCALE":I
    const/4 v0, 0x0

    .line 375
    .local v0, "STATE":I
    new-instance v3, Landroid/graphics/Point;

    invoke-direct {v3}, Landroid/graphics/Point;-><init>()V

    .line 376
    .local v3, "from":Landroid/graphics/Point;
    new-instance v5, Landroid/graphics/Point;

    invoke-direct {v5}, Landroid/graphics/Point;-><init>()V

    .line 377
    .local v5, "to":Landroid/graphics/Point;
    new-instance v4, Landroid/graphics/RectF;

    iget-object v6, p0, Lcom/poshmark/ui/customviews/GestureView;->bitmap:Landroid/graphics/Bitmap;

    invoke-virtual {v6}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v6

    int-to-float v6, v6

    iget-object v7, p0, Lcom/poshmark/ui/customviews/GestureView;->bitmap:Landroid/graphics/Bitmap;

    invoke-virtual {v7}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v7

    int-to-float v7, v7

    invoke-direct {v4, v8, v8, v6, v7}, Landroid/graphics/RectF;-><init>(FFFF)V

    .line 378
    .local v4, "r":Landroid/graphics/RectF;
    iget-object v6, p0, Lcom/poshmark/ui/customviews/GestureView;->currentMatrix:Landroid/graphics/Matrix;

    invoke-virtual {v6, v4}, Landroid/graphics/Matrix;->mapRect(Landroid/graphics/RectF;)Z

    .line 380
    iget-object v6, p0, Lcom/poshmark/ui/customviews/GestureView;->cropSpace:Landroid/graphics/Rect;

    invoke-virtual {v6}, Landroid/graphics/Rect;->width()I

    move-result v6

    int-to-float v6, v6

    invoke-virtual {v4}, Landroid/graphics/RectF;->width()F

    move-result v7

    cmpl-float v6, v6, v7

    if-gtz v6, :cond_0

    iget-object v6, p0, Lcom/poshmark/ui/customviews/GestureView;->cropSpace:Landroid/graphics/Rect;

    invoke-virtual {v6}, Landroid/graphics/Rect;->height()I

    move-result v6

    int-to-float v6, v6

    invoke-virtual {v4}, Landroid/graphics/RectF;->height()F

    move-result v7

    cmpl-float v6, v6, v7

    if-lez v6, :cond_3

    .line 381
    :cond_0
    const/4 v0, 0x2

    .line 385
    :goto_0
    const-string v6, "GESTURE VIEW"

    const-string v7, "Reset Image State : %s"

    new-array v8, v11, [Ljava/lang/Object;

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v8, v10

    invoke-static {v7, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 386
    iget-object v6, p0, Lcom/poshmark/ui/customviews/GestureView;->bitmapTopLeft:Landroid/graphics/Point;

    iget v6, v6, Landroid/graphics/Point;->x:I

    iput v6, v5, Landroid/graphics/Point;->x:I

    iput v6, v3, Landroid/graphics/Point;->x:I

    .line 387
    iget-object v6, p0, Lcom/poshmark/ui/customviews/GestureView;->bitmapTopLeft:Landroid/graphics/Point;

    iget v6, v6, Landroid/graphics/Point;->y:I

    iput v6, v5, Landroid/graphics/Point;->y:I

    iput v6, v3, Landroid/graphics/Point;->y:I

    .line 389
    if-ne v0, v11, :cond_6

    .line 390
    iget-object v6, p0, Lcom/poshmark/ui/customviews/GestureView;->cropSpace:Landroid/graphics/Rect;

    iget v6, v6, Landroid/graphics/Rect;->left:I

    int-to-float v6, v6

    iget v7, v4, Landroid/graphics/RectF;->left:F

    cmpg-float v6, v6, v7

    if-gez v6, :cond_4

    .line 392
    iget-object v6, p0, Lcom/poshmark/ui/customviews/GestureView;->bitmapTopLeft:Landroid/graphics/Point;

    iget v6, v6, Landroid/graphics/Point;->x:I

    iget v7, v4, Landroid/graphics/RectF;->left:F

    iget-object v8, p0, Lcom/poshmark/ui/customviews/GestureView;->cropSpace:Landroid/graphics/Rect;

    iget v8, v8, Landroid/graphics/Rect;->left:I

    int-to-float v8, v8

    sub-float/2addr v7, v8

    float-to-int v7, v7

    sub-int/2addr v6, v7

    iput v6, v5, Landroid/graphics/Point;->x:I

    .line 398
    :cond_1
    :goto_1
    iget-object v6, p0, Lcom/poshmark/ui/customviews/GestureView;->cropSpace:Landroid/graphics/Rect;

    iget v6, v6, Landroid/graphics/Rect;->top:I

    int-to-float v6, v6

    iget v7, v4, Landroid/graphics/RectF;->top:F

    cmpg-float v6, v6, v7

    if-gez v6, :cond_5

    .line 400
    iget-object v6, p0, Lcom/poshmark/ui/customviews/GestureView;->bitmapTopLeft:Landroid/graphics/Point;

    iget v6, v6, Landroid/graphics/Point;->y:I

    iget v7, v4, Landroid/graphics/RectF;->top:F

    iget-object v8, p0, Lcom/poshmark/ui/customviews/GestureView;->cropSpace:Landroid/graphics/Rect;

    iget v8, v8, Landroid/graphics/Rect;->top:I

    int-to-float v8, v8

    sub-float/2addr v7, v8

    float-to-int v7, v7

    sub-int/2addr v6, v7

    iput v6, v5, Landroid/graphics/Point;->y:I

    .line 411
    :cond_2
    :goto_2
    iget-object v6, p0, Lcom/poshmark/ui/customviews/GestureView;->utils:Lcom/poshmark/utils/GestureViewUtils;

    invoke-virtual {v6, v3, v5, p0}, Lcom/poshmark/utils/GestureViewUtils;->startTranslationAnimation(Landroid/graphics/Point;Landroid/graphics/Point;Lcom/poshmark/ui/customviews/GestureView;)V

    .line 412
    const-string v6, "GESTURE VIEW"

    const-string v7, "Reset Image Translating"

    new-array v8, v10, [Ljava/lang/Object;

    invoke-static {v7, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 413
    return-void

    .line 383
    :cond_3
    const/4 v0, 0x1

    goto :goto_0

    .line 393
    :cond_4
    iget-object v6, p0, Lcom/poshmark/ui/customviews/GestureView;->cropSpace:Landroid/graphics/Rect;

    iget v6, v6, Landroid/graphics/Rect;->right:I

    int-to-float v6, v6

    iget v7, v4, Landroid/graphics/RectF;->right:F

    cmpl-float v6, v6, v7

    if-lez v6, :cond_1

    .line 395
    iget-object v6, p0, Lcom/poshmark/ui/customviews/GestureView;->bitmapTopLeft:Landroid/graphics/Point;

    iget v6, v6, Landroid/graphics/Point;->x:I

    iget-object v7, p0, Lcom/poshmark/ui/customviews/GestureView;->cropSpace:Landroid/graphics/Rect;

    iget v7, v7, Landroid/graphics/Rect;->right:I

    iget v8, v4, Landroid/graphics/RectF;->right:F

    float-to-int v8, v8

    sub-int/2addr v7, v8

    add-int/2addr v6, v7

    iput v6, v5, Landroid/graphics/Point;->x:I

    goto :goto_1

    .line 401
    :cond_5
    iget-object v6, p0, Lcom/poshmark/ui/customviews/GestureView;->cropSpace:Landroid/graphics/Rect;

    iget v6, v6, Landroid/graphics/Rect;->bottom:I

    int-to-float v6, v6

    iget v7, v4, Landroid/graphics/RectF;->bottom:F

    cmpl-float v6, v6, v7

    if-lez v6, :cond_2

    .line 403
    iget-object v6, p0, Lcom/poshmark/ui/customviews/GestureView;->bitmapTopLeft:Landroid/graphics/Point;

    iget v6, v6, Landroid/graphics/Point;->y:I

    iget-object v7, p0, Lcom/poshmark/ui/customviews/GestureView;->cropSpace:Landroid/graphics/Rect;

    iget v7, v7, Landroid/graphics/Rect;->bottom:I

    iget v8, v4, Landroid/graphics/RectF;->bottom:F

    float-to-int v8, v8

    sub-int/2addr v7, v8

    add-int/2addr v6, v7

    iput v6, v5, Landroid/graphics/Point;->y:I

    goto :goto_2

    .line 405
    :cond_6
    const/4 v6, 0x2

    if-ne v0, v6, :cond_2

    .line 406
    iget v6, p0, Lcom/poshmark/ui/customviews/GestureView;->cenX:I

    iput v6, v5, Landroid/graphics/Point;->x:I

    .line 407
    iget v6, p0, Lcom/poshmark/ui/customviews/GestureView;->cenY:I

    iput v6, v5, Landroid/graphics/Point;->y:I

    .line 408
    iget-object v6, p0, Lcom/poshmark/ui/customviews/GestureView;->utils:Lcom/poshmark/utils/GestureViewUtils;

    iget v7, p0, Lcom/poshmark/ui/customviews/GestureView;->xCurrentScaleFactor:F

    const/high16 v8, 0x3f800000    # 1.0f

    invoke-virtual {v6, v7, v8, p0}, Lcom/poshmark/utils/GestureViewUtils;->startScaleAnimation(FFLcom/poshmark/ui/customviews/GestureView;)V

    .line 409
    const-string v6, "GESTURE VIEW"

    const-string v7, "Reset Image Scaling"

    new-array v8, v10, [Ljava/lang/Object;

    invoke-static {v7, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_2
.end method

.method private setPivotPoints(Landroid/graphics/Point;Landroid/graphics/Point;)V
    .locals 3
    .param p1, "majorPointStart"    # Landroid/graphics/Point;
    .param p2, "minorPointStart"    # Landroid/graphics/Point;

    .prologue
    .line 295
    new-instance v0, Landroid/graphics/RectF;

    invoke-direct {v0}, Landroid/graphics/RectF;-><init>()V

    .line 296
    .local v0, "r":Landroid/graphics/RectF;
    iget-object v1, p0, Lcom/poshmark/ui/customviews/GestureView;->currentMatrix:Landroid/graphics/Matrix;

    invoke-virtual {v1, v0}, Landroid/graphics/Matrix;->mapRect(Landroid/graphics/RectF;)Z

    .line 297
    iget-object v1, p0, Lcom/poshmark/ui/customviews/GestureView;->pivot:Landroid/graphics/Point;

    iget-object v2, p0, Lcom/poshmark/ui/customviews/GestureView;->bitmap:Landroid/graphics/Bitmap;

    invoke-virtual {v2}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v2

    div-int/lit8 v2, v2, 0x2

    iput v2, v1, Landroid/graphics/Point;->x:I

    .line 298
    iget-object v1, p0, Lcom/poshmark/ui/customviews/GestureView;->pivot:Landroid/graphics/Point;

    iget-object v2, p0, Lcom/poshmark/ui/customviews/GestureView;->bitmap:Landroid/graphics/Bitmap;

    invoke-virtual {v2}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v2

    div-int/lit8 v2, v2, 0x2

    iput v2, v1, Landroid/graphics/Point;->y:I

    .line 299
    return-void
.end method


# virtual methods
.method public getCroppedImage()Landroid/net/Uri;
    .locals 29

    .prologue
    .line 310
    const/16 v3, 0x9

    new-array v0, v3, [F

    move-object/from16 v21, v0

    .line 315
    .local v21, "matrixValues":[F
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/poshmark/ui/customviews/GestureView;->currentMatrix:Landroid/graphics/Matrix;

    move-object/from16 v0, v21

    invoke-virtual {v3, v0}, Landroid/graphics/Matrix;->getValues([F)V

    .line 316
    const/4 v3, 0x0

    aget v22, v21, v3

    .line 318
    .local v22, "originalScaledFactor":F
    const-string v3, "GESTURE VIEW"

    const-string v9, "Getting Cropped Image"

    const/16 v26, 0x0

    move/from16 v0, v26

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v26, v0

    move-object/from16 v0, v26

    invoke-static {v9, v0}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v9

    invoke-static {v3, v9}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 319
    new-instance v23, Landroid/graphics/RectF;

    const/4 v3, 0x0

    const/4 v9, 0x0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/customviews/GestureView;->bitmap:Landroid/graphics/Bitmap;

    move-object/from16 v26, v0

    invoke-virtual/range {v26 .. v26}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v26

    move/from16 v0, v26

    int-to-float v0, v0

    move/from16 v26, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/customviews/GestureView;->bitmap:Landroid/graphics/Bitmap;

    move-object/from16 v27, v0

    invoke-virtual/range {v27 .. v27}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v27

    move/from16 v0, v27

    int-to-float v0, v0

    move/from16 v27, v0

    move-object/from16 v0, v23

    move/from16 v1, v26

    move/from16 v2, v27

    invoke-direct {v0, v3, v9, v1, v2}, Landroid/graphics/RectF;-><init>(FFFF)V

    .line 320
    .local v23, "r":Landroid/graphics/RectF;
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/poshmark/ui/customviews/GestureView;->currentMatrix:Landroid/graphics/Matrix;

    move-object/from16 v0, v23

    invoke-virtual {v3, v0}, Landroid/graphics/Matrix;->mapRect(Landroid/graphics/RectF;)Z

    .line 321
    move-object/from16 v0, v23

    iget v3, v0, Landroid/graphics/RectF;->left:F

    float-to-int v11, v3

    .line 322
    .local v11, "bLeft":I
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/poshmark/ui/customviews/GestureView;->cropSpace:Landroid/graphics/Rect;

    iget v15, v3, Landroid/graphics/Rect;->left:I

    .line 323
    .local v15, "cropLeft":I
    sub-int v4, v15, v11

    .line 325
    .local v4, "finalLeft":I
    move-object/from16 v0, v23

    iget v3, v0, Landroid/graphics/RectF;->top:F

    float-to-int v13, v3

    .line 326
    .local v13, "bTop":I
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/poshmark/ui/customviews/GestureView;->cropSpace:Landroid/graphics/Rect;

    iget v0, v3, Landroid/graphics/Rect;->top:I

    move/from16 v17, v0

    .line 327
    .local v17, "cropTop":I
    sub-int v5, v17, v13

    .line 329
    .local v5, "finalTop":I
    move-object/from16 v0, v23

    iget v3, v0, Landroid/graphics/RectF;->right:F

    float-to-int v12, v3

    .line 330
    .local v12, "bRight":I
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/poshmark/ui/customviews/GestureView;->cropSpace:Landroid/graphics/Rect;

    iget v0, v3, Landroid/graphics/Rect;->right:I

    move/from16 v16, v0

    .line 331
    .local v16, "cropRight":I
    sub-int v20, v16, v12

    .line 333
    .local v20, "finalRight":I
    move-object/from16 v0, v23

    iget v3, v0, Landroid/graphics/RectF;->bottom:F

    float-to-int v10, v3

    .line 334
    .local v10, "bBottom":I
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/poshmark/ui/customviews/GestureView;->cropSpace:Landroid/graphics/Rect;

    iget v14, v3, Landroid/graphics/Rect;->bottom:I

    .line 335
    .local v14, "cropBottom":I
    sub-int v19, v14, v10

    .line 337
    .local v19, "finalBottom":I
    invoke-static {v4}, Ljava/lang/Math;->abs(I)I

    move-result v4

    .line 338
    invoke-static {v5}, Ljava/lang/Math;->abs(I)I

    move-result v5

    .line 339
    invoke-virtual/range {v23 .. v23}, Landroid/graphics/RectF;->width()F

    move-result v3

    float-to-int v3, v3

    invoke-static/range {v20 .. v20}, Ljava/lang/Math;->abs(I)I

    move-result v9

    sub-int v20, v3, v9

    .line 340
    invoke-virtual/range {v23 .. v23}, Landroid/graphics/RectF;->height()F

    move-result v3

    float-to-int v3, v3

    invoke-static/range {v19 .. v19}, Ljava/lang/Math;->abs(I)I

    move-result v9

    sub-int v19, v3, v9

    .line 342
    const-string v3, "GESTURE VIEW"

    const-string v9, "Final Crop Values top: %s, right : %s, bottom: %s, left: %s"

    const/16 v26, 0x4

    move/from16 v0, v26

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v26, v0

    const/16 v27, 0x0

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v28

    aput-object v28, v26, v27

    const/16 v27, 0x1

    invoke-static/range {v20 .. v20}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v28

    aput-object v28, v26, v27

    const/16 v27, 0x2

    invoke-static/range {v19 .. v19}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v28

    aput-object v28, v26, v27

    const/16 v27, 0x3

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v28

    aput-object v28, v26, v27

    move-object/from16 v0, v26

    invoke-static {v9, v0}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v9

    invoke-static {v3, v9}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 344
    move/from16 v0, v19

    int-to-float v3, v0

    div-float v3, v3, v22

    float-to-int v0, v3

    move/from16 v19, v0

    .line 345
    int-to-float v3, v5

    div-float v3, v3, v22

    float-to-int v5, v3

    .line 346
    int-to-float v3, v4

    div-float v3, v3, v22

    float-to-int v4, v3

    .line 347
    move/from16 v0, v20

    int-to-float v3, v0

    div-float v3, v3, v22

    float-to-int v0, v3

    move/from16 v20, v0

    .line 348
    sub-int v6, v20, v4

    .line 349
    .local v6, "width":I
    sub-int v7, v19, v5

    .line 351
    .local v7, "height":I
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/poshmark/ui/customviews/GestureView;->bitmap:Landroid/graphics/Bitmap;

    invoke-virtual {v3}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v3

    int-to-float v3, v3

    move-object/from16 v0, p0

    iget v9, v0, Lcom/poshmark/ui/customviews/GestureView;->cropImageWidth:I

    int-to-float v9, v9

    div-float v24, v3, v9

    .line 352
    .local v24, "scaleFactor":F
    new-instance v8, Landroid/graphics/Matrix;

    invoke-direct {v8}, Landroid/graphics/Matrix;-><init>()V

    .line 353
    .local v8, "scaler":Landroid/graphics/Matrix;
    move/from16 v0, v24

    move/from16 v1, v24

    invoke-virtual {v8, v0, v1}, Landroid/graphics/Matrix;->postScale(FF)Z

    .line 355
    const-string v3, "GESTURE VIEW"

    const-string v9, "Bitmap values Width: %s, height: %s"

    const/16 v26, 0x2

    move/from16 v0, v26

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v26, v0

    const/16 v27, 0x0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/customviews/GestureView;->bitmap:Landroid/graphics/Bitmap;

    move-object/from16 v28, v0

    invoke-virtual/range {v28 .. v28}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v28

    invoke-static/range {v28 .. v28}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v28

    aput-object v28, v26, v27

    const/16 v27, 0x1

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/customviews/GestureView;->bitmap:Landroid/graphics/Bitmap;

    move-object/from16 v28, v0

    invoke-virtual/range {v28 .. v28}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v28

    invoke-static/range {v28 .. v28}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v28

    aput-object v28, v26, v27

    move-object/from16 v0, v26

    invoke-static {v9, v0}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v9

    invoke-static {v3, v9}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 356
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/poshmark/ui/customviews/GestureView;->bitmap:Landroid/graphics/Bitmap;

    const/4 v9, 0x1

    invoke-static/range {v3 .. v9}, Landroid/graphics/Bitmap;->createBitmap(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;

    move-result-object v18

    .line 357
    .local v18, "croppedBitmap":Landroid/graphics/Bitmap;
    invoke-static/range {v18 .. v18}, Lcom/poshmark/utils/ImageUtils;->saveBitmapToDisk(Landroid/graphics/Bitmap;)Landroid/net/Uri;

    move-result-object v25

    .line 358
    .local v25, "uri":Landroid/net/Uri;
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/poshmark/ui/customviews/GestureView;->bitmap:Landroid/graphics/Bitmap;

    invoke-virtual {v3}, Landroid/graphics/Bitmap;->recycle()V

    .line 359
    invoke-virtual/range {v18 .. v18}, Landroid/graphics/Bitmap;->recycle()V

    .line 360
    invoke-static {}, Ljava/lang/System;->gc()V

    .line 361
    const-string v3, "GESTURE VIEW"

    const-string v9, "Returning Saved URI : %s"

    const/16 v26, 0x1

    move/from16 v0, v26

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v26, v0

    const/16 v27, 0x0

    invoke-virtual/range {v25 .. v25}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v28

    aput-object v28, v26, v27

    move-object/from16 v0, v26

    invoke-static {v9, v0}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v9

    invoke-static {v3, v9}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 362
    return-object v25
.end method

.method public onActionEnd()V
    .locals 3

    .prologue
    .line 273
    invoke-direct {p0}, Lcom/poshmark/ui/customviews/GestureView;->resetImage()V

    .line 274
    const-string v0, "GESTURE VIEW"

    const-string v1, "Action End!"

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Object;

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 275
    return-void
.end method

.method public onDrag(Landroid/graphics/Point;Landroid/graphics/Point;)V
    .locals 5
    .param p1, "majorPointPrev"    # Landroid/graphics/Point;
    .param p2, "majorPointCurrent"    # Landroid/graphics/Point;

    .prologue
    .line 249
    iget-boolean v0, p0, Lcom/poshmark/ui/customviews/GestureView;->isDragging:Z

    if-eqz v0, :cond_0

    .line 250
    iget v0, p2, Landroid/graphics/Point;->x:I

    iget v1, p1, Landroid/graphics/Point;->x:I

    sub-int/2addr v0, v1

    iput v0, p0, Lcom/poshmark/ui/customviews/GestureView;->dragXOffset:I

    .line 251
    iget v0, p2, Landroid/graphics/Point;->y:I

    iget v1, p1, Landroid/graphics/Point;->y:I

    sub-int/2addr v0, v1

    iput v0, p0, Lcom/poshmark/ui/customviews/GestureView;->dragYOffset:I

    .line 252
    iget-object v0, p0, Lcom/poshmark/ui/customviews/GestureView;->bitmapTopLeft:Landroid/graphics/Point;

    iget v1, v0, Landroid/graphics/Point;->x:I

    iget v2, p0, Lcom/poshmark/ui/customviews/GestureView;->dragXOffset:I

    add-int/2addr v1, v2

    iput v1, v0, Landroid/graphics/Point;->x:I

    .line 253
    iget-object v0, p0, Lcom/poshmark/ui/customviews/GestureView;->bitmapTopLeft:Landroid/graphics/Point;

    iget v1, v0, Landroid/graphics/Point;->y:I

    iget v2, p0, Lcom/poshmark/ui/customviews/GestureView;->dragYOffset:I

    add-int/2addr v1, v2

    iput v1, v0, Landroid/graphics/Point;->y:I

    .line 254
    const-string v0, "GESTURE VIEW"

    const-string v1, "offset: %s, %s"

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    iget v4, p0, Lcom/poshmark/ui/customviews/GestureView;->dragXOffset:I

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x1

    iget v4, p0, Lcom/poshmark/ui/customviews/GestureView;->dragYOffset:I

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 255
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/GestureView;->updateImage()V

    .line 257
    :cond_0
    return-void
.end method

.method public onDragEnd()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 261
    iput-boolean v2, p0, Lcom/poshmark/ui/customviews/GestureView;->isDragging:Z

    .line 262
    const-string v0, "GESTURE VIEW"

    const-string v1, "DRAG End!"

    new-array v2, v2, [Ljava/lang/Object;

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 263
    return-void
.end method

.method public onDragStart(Landroid/graphics/Point;)V
    .locals 3
    .param p1, "startPoint"    # Landroid/graphics/Point;

    .prologue
    const/4 v2, 0x0

    .line 239
    iget-boolean v0, p0, Lcom/poshmark/ui/customviews/GestureView;->isDragging:Z

    if-nez v0, :cond_0

    invoke-direct {p0, p1}, Lcom/poshmark/ui/customviews/GestureView;->isSwipableArea(Landroid/graphics/Point;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 240
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/ui/customviews/GestureView;->isDragging:Z

    .line 241
    const-string v0, "GESTURE VIEW"

    const-string v1, "Dragging TRUE!"

    new-array v2, v2, [Ljava/lang/Object;

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 245
    :goto_0
    return-void

    .line 243
    :cond_0
    const-string v0, "GESTURE VIEW"

    const-string v1, "Dragging FALSE!"

    new-array v2, v2, [Ljava/lang/Object;

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method public onPinchZoom(Landroid/graphics/Point;Landroid/graphics/Point;Landroid/graphics/Point;Landroid/graphics/Point;)V
    .locals 8
    .param p1, "majorPointPrev"    # Landroid/graphics/Point;
    .param p2, "majorPointCurrent"    # Landroid/graphics/Point;
    .param p3, "minorPointPrev"    # Landroid/graphics/Point;
    .param p4, "minorPointCurrent"    # Landroid/graphics/Point;

    .prologue
    .line 215
    iget-boolean v3, p0, Lcom/poshmark/ui/customviews/GestureView;->isPinchZooming:Z

    if-eqz v3, :cond_0

    invoke-direct {p0, p2, p4}, Lcom/poshmark/ui/customviews/GestureView;->isSwipableArea(Landroid/graphics/Point;Landroid/graphics/Point;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 216
    const-string v3, "GESTURE VIEW"

    const-string v4, "Pinch Zooming"

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Object;

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 217
    invoke-direct {p0, p1, p3}, Lcom/poshmark/ui/customviews/GestureView;->getBoundingRect(Landroid/graphics/Point;Landroid/graphics/Point;)Landroid/graphics/Rect;

    move-result-object v1

    .line 218
    .local v1, "prevBoundingBox":Landroid/graphics/Rect;
    invoke-direct {p0, p2, p4}, Lcom/poshmark/ui/customviews/GestureView;->getBoundingRect(Landroid/graphics/Point;Landroid/graphics/Point;)Landroid/graphics/Rect;

    move-result-object v0

    .line 219
    .local v0, "currentBoundingBox":Landroid/graphics/Rect;
    invoke-virtual {v0}, Landroid/graphics/Rect;->width()I

    move-result v3

    invoke-virtual {v1}, Landroid/graphics/Rect;->width()I

    move-result v4

    sub-int/2addr v3, v4

    int-to-float v3, v3

    iput v3, p0, Lcom/poshmark/ui/customviews/GestureView;->xPinchDistance:F

    .line 220
    const-string v3, "GESTURE VIEW"

    const-string v4, "zoom: %s, %s"

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    iget v7, p0, Lcom/poshmark/ui/customviews/GestureView;->xPinchDistance:F

    invoke-static {v7}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v7

    aput-object v7, v5, v6

    const/4 v6, 0x1

    iget v7, p0, Lcom/poshmark/ui/customviews/GestureView;->yPinchDistance:F

    invoke-static {v7}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 221
    const-string v3, "GESTURE VIEW"

    const-string v4, "offset: %s, %s"

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    iget v7, p0, Lcom/poshmark/ui/customviews/GestureView;->dragXOffset:I

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v5, v6

    const/4 v6, 0x1

    iget v7, p0, Lcom/poshmark/ui/customviews/GestureView;->dragYOffset:I

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 222
    iget v3, p0, Lcom/poshmark/ui/customviews/GestureView;->xPinchDistance:F

    const/high16 v4, 0x42c80000    # 100.0f

    div-float/2addr v3, v4

    invoke-static {v3}, Ljava/lang/Math;->abs(F)F

    move-result v2

    .line 223
    .local v2, "xScaleFactor":F
    const-string v3, "GESTURE VIEW"

    const-string v4, "pinchDistance: %s"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    iget v7, p0, Lcom/poshmark/ui/customviews/GestureView;->xPinchDistance:F

    invoke-static {v7}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 224
    iget v3, p0, Lcom/poshmark/ui/customviews/GestureView;->xPinchDistance:F

    const/4 v4, 0x0

    cmpl-float v3, v3, v4

    if-ltz v3, :cond_2

    .line 225
    iget v3, p0, Lcom/poshmark/ui/customviews/GestureView;->xCurrentScaleFactor:F

    add-float/2addr v3, v2

    iput v3, p0, Lcom/poshmark/ui/customviews/GestureView;->xCurrentScaleFactor:F

    .line 226
    iget v3, p0, Lcom/poshmark/ui/customviews/GestureView;->xCurrentScaleFactor:F

    const/high16 v4, 0x40400000    # 3.0f

    cmpl-float v3, v3, v4

    if-lez v3, :cond_1

    const/high16 v3, 0x40400000    # 3.0f

    :goto_0
    iput v3, p0, Lcom/poshmark/ui/customviews/GestureView;->xCurrentScaleFactor:F

    .line 231
    :goto_1
    const-string v3, "GESTURE VIEW"

    const-string v4, "Current Scale Factor: %s"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    iget v7, p0, Lcom/poshmark/ui/customviews/GestureView;->xCurrentScaleFactor:F

    invoke-static {v7}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 232
    const/4 v3, 0x0

    iput v3, p0, Lcom/poshmark/ui/customviews/GestureView;->xPinchDistance:F

    .line 233
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/GestureView;->updateImage()V

    .line 235
    .end local v0    # "currentBoundingBox":Landroid/graphics/Rect;
    .end local v1    # "prevBoundingBox":Landroid/graphics/Rect;
    .end local v2    # "xScaleFactor":F
    :cond_0
    return-void

    .line 226
    .restart local v0    # "currentBoundingBox":Landroid/graphics/Rect;
    .restart local v1    # "prevBoundingBox":Landroid/graphics/Rect;
    .restart local v2    # "xScaleFactor":F
    :cond_1
    iget v3, p0, Lcom/poshmark/ui/customviews/GestureView;->xCurrentScaleFactor:F

    goto :goto_0

    .line 228
    :cond_2
    iget v3, p0, Lcom/poshmark/ui/customviews/GestureView;->xCurrentScaleFactor:F

    sub-float/2addr v3, v2

    iput v3, p0, Lcom/poshmark/ui/customviews/GestureView;->xCurrentScaleFactor:F

    .line 229
    iget v3, p0, Lcom/poshmark/ui/customviews/GestureView;->xCurrentScaleFactor:F

    const/high16 v4, 0x3f000000    # 0.5f

    cmpg-float v3, v3, v4

    if-gez v3, :cond_3

    const/high16 v3, 0x3f000000    # 0.5f

    :goto_2
    iput v3, p0, Lcom/poshmark/ui/customviews/GestureView;->xCurrentScaleFactor:F

    goto :goto_1

    :cond_3
    iget v3, p0, Lcom/poshmark/ui/customviews/GestureView;->xCurrentScaleFactor:F

    goto :goto_2
.end method

.method public onPinchZoomEnd()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 267
    iput-boolean v2, p0, Lcom/poshmark/ui/customviews/GestureView;->isPinchZooming:Z

    .line 268
    const-string v0, "GESTURE VIEW"

    const-string v1, "Pinch Zoom End!"

    new-array v2, v2, [Ljava/lang/Object;

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 269
    return-void
.end method

.method public onPinchZoomStart(Landroid/graphics/Point;Landroid/graphics/Point;)V
    .locals 4
    .param p1, "majorPointStart"    # Landroid/graphics/Point;
    .param p2, "minorPointStart"    # Landroid/graphics/Point;

    .prologue
    const/4 v3, 0x0

    .line 204
    iget-boolean v0, p0, Lcom/poshmark/ui/customviews/GestureView;->isPinchZooming:Z

    if-nez v0, :cond_0

    invoke-direct {p0, p1, p2}, Lcom/poshmark/ui/customviews/GestureView;->isSwipableArea(Landroid/graphics/Point;Landroid/graphics/Point;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 205
    const-string v0, "GESTURE VIEW"

    const-string v1, "pinch_zoom start"

    new-array v2, v3, [Ljava/lang/Object;

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 206
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/ui/customviews/GestureView;->isPinchZooming:Z

    .line 207
    iput-boolean v3, p0, Lcom/poshmark/ui/customviews/GestureView;->isDragging:Z

    .line 209
    :cond_0
    invoke-direct {p0, p1, p2}, Lcom/poshmark/ui/customviews/GestureView;->setPivotPoints(Landroid/graphics/Point;Landroid/graphics/Point;)V

    .line 210
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/GestureView;->updateImage()V

    .line 211
    return-void
.end method

.method public onSingleTap(Landroid/graphics/Point;)V
    .locals 0
    .param p1, "majorPoint"    # Landroid/graphics/Point;

    .prologue
    .line 200
    return-void
.end method

.method public setFileName(Ljava/lang/String;)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 76
    iput-object p1, p0, Lcom/poshmark/ui/customviews/GestureView;->bmpFileName:Ljava/lang/String;

    .line 77
    return-void
.end method

.method public setMode(I)V
    .locals 1
    .param p1, "creation_mode"    # I

    .prologue
    .line 80
    packed-switch p1, :pswitch_data_0

    .line 89
    :goto_0
    return-void

    .line 82
    :pswitch_0
    const/16 v0, 0x64

    iput v0, p0, Lcom/poshmark/ui/customviews/GestureView;->cropImageWidth:I

    goto :goto_0

    .line 86
    :pswitch_1
    const/16 v0, 0x400

    iput v0, p0, Lcom/poshmark/ui/customviews/GestureView;->cropImageWidth:I

    goto :goto_0

    .line 80
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
    .line 98
    const-string v2, "GESTURE VIEW"

    const-string v3, "Setting Bitmap"

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 99
    new-instance v0, Landroid/graphics/BitmapFactory$Options;

    invoke-direct {v0}, Landroid/graphics/BitmapFactory$Options;-><init>()V

    .line 100
    .local v0, "options":Landroid/graphics/BitmapFactory$Options;
    iget v2, p1, Landroid/graphics/Rect;->right:I

    iget v3, p1, Landroid/graphics/Rect;->left:I

    sub-int/2addr v2, v3

    iget v3, p1, Landroid/graphics/Rect;->bottom:I

    iget v4, p1, Landroid/graphics/Rect;->top:I

    sub-int/2addr v3, v4

    invoke-static {v0, v2, v3}, Lcom/poshmark/utils/ImageUtils;->calculateInSampleSize(Landroid/graphics/BitmapFactory$Options;II)I

    move-result v1

    .line 101
    .local v1, "sampleSize":I
    const/4 v2, 0x0

    iput-boolean v2, v0, Landroid/graphics/BitmapFactory$Options;->inJustDecodeBounds:Z

    .line 102
    iput v1, v0, Landroid/graphics/BitmapFactory$Options;->inSampleSize:I

    .line 104
    iget-object v2, p0, Lcom/poshmark/ui/customviews/GestureView;->bmpFileName:Ljava/lang/String;

    invoke-static {v2, v0}, Lcom/newrelic/agent/android/instrumentation/BitmapFactoryInstrumentation;->decodeFile(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/ui/customviews/GestureView;->bitmap:Landroid/graphics/Bitmap;

    .line 105
    iget-object v2, p0, Lcom/poshmark/ui/customviews/GestureView;->utils:Lcom/poshmark/utils/GestureViewUtils;

    iget-object v3, p0, Lcom/poshmark/ui/customviews/GestureView;->bitmap:Landroid/graphics/Bitmap;

    invoke-virtual {v2, p1, v3}, Lcom/poshmark/utils/GestureViewUtils;->getInitialScaledBitmap(Landroid/graphics/Rect;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/ui/customviews/GestureView;->bitmap:Landroid/graphics/Bitmap;

    .line 106
    iget v2, p1, Landroid/graphics/Rect;->left:I

    invoke-virtual {p1}, Landroid/graphics/Rect;->width()I

    move-result v3

    div-int/lit8 v3, v3, 0x2

    add-int/2addr v2, v3

    iget-object v3, p0, Lcom/poshmark/ui/customviews/GestureView;->bitmap:Landroid/graphics/Bitmap;

    invoke-virtual {v3}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v3

    div-int/lit8 v3, v3, 0x2

    sub-int/2addr v2, v3

    iput v2, p0, Lcom/poshmark/ui/customviews/GestureView;->cenX:I

    .line 107
    iget v2, p1, Landroid/graphics/Rect;->top:I

    invoke-virtual {p1}, Landroid/graphics/Rect;->height()I

    move-result v3

    div-int/lit8 v3, v3, 0x2

    add-int/2addr v2, v3

    iget-object v3, p0, Lcom/poshmark/ui/customviews/GestureView;->bitmap:Landroid/graphics/Bitmap;

    invoke-virtual {v3}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v3

    div-int/lit8 v3, v3, 0x2

    sub-int/2addr v2, v3

    iput v2, p0, Lcom/poshmark/ui/customviews/GestureView;->cenY:I

    .line 108
    new-instance v2, Landroid/graphics/Point;

    invoke-direct {v2}, Landroid/graphics/Point;-><init>()V

    iput-object v2, p0, Lcom/poshmark/ui/customviews/GestureView;->bitmapTopLeft:Landroid/graphics/Point;

    .line 109
    iget-object v2, p0, Lcom/poshmark/ui/customviews/GestureView;->bitmapTopLeft:Landroid/graphics/Point;

    iget v3, p0, Lcom/poshmark/ui/customviews/GestureView;->cenX:I

    iput v3, v2, Landroid/graphics/Point;->x:I

    .line 110
    iget-object v2, p0, Lcom/poshmark/ui/customviews/GestureView;->bitmapTopLeft:Landroid/graphics/Point;

    iget v3, p0, Lcom/poshmark/ui/customviews/GestureView;->cenY:I

    iput v3, v2, Landroid/graphics/Point;->y:I

    .line 112
    iput-object p1, p0, Lcom/poshmark/ui/customviews/GestureView;->cropSpace:Landroid/graphics/Rect;

    .line 113
    iget-object v2, p0, Lcom/poshmark/ui/customviews/GestureView;->holder:Landroid/view/SurfaceHolder;

    new-instance v3, Lcom/poshmark/ui/customviews/GestureView$1;

    invoke-direct {v3, p0}, Lcom/poshmark/ui/customviews/GestureView$1;-><init>(Lcom/poshmark/ui/customviews/GestureView;)V

    invoke-interface {v2, v3}, Landroid/view/SurfaceHolder;->addCallback(Landroid/view/SurfaceHolder$Callback;)V

    .line 131
    return-void
.end method

.method public updateImage()V
    .locals 6

    .prologue
    .line 137
    iget-object v1, p0, Lcom/poshmark/ui/customviews/GestureView;->holder:Landroid/view/SurfaceHolder;

    const/4 v2, 0x0

    invoke-interface {v1, v2}, Landroid/view/SurfaceHolder;->lockCanvas(Landroid/graphics/Rect;)Landroid/graphics/Canvas;

    move-result-object v0

    .line 138
    .local v0, "canvas":Landroid/graphics/Canvas;
    const/4 v1, -0x1

    invoke-virtual {v0, v1}, Landroid/graphics/Canvas;->drawColor(I)V

    .line 139
    iget-object v1, p0, Lcom/poshmark/ui/customviews/GestureView;->currentMatrix:Landroid/graphics/Matrix;

    invoke-virtual {v1}, Landroid/graphics/Matrix;->reset()V

    .line 140
    iget-object v1, p0, Lcom/poshmark/ui/customviews/GestureView;->currentMatrix:Landroid/graphics/Matrix;

    iget v2, p0, Lcom/poshmark/ui/customviews/GestureView;->xCurrentScaleFactor:F

    iget v3, p0, Lcom/poshmark/ui/customviews/GestureView;->xCurrentScaleFactor:F

    iget-object v4, p0, Lcom/poshmark/ui/customviews/GestureView;->pivot:Landroid/graphics/Point;

    iget v4, v4, Landroid/graphics/Point;->x:I

    int-to-float v4, v4

    iget-object v5, p0, Lcom/poshmark/ui/customviews/GestureView;->pivot:Landroid/graphics/Point;

    iget v5, v5, Landroid/graphics/Point;->y:I

    int-to-float v5, v5

    invoke-virtual {v1, v2, v3, v4, v5}, Landroid/graphics/Matrix;->setScale(FFFF)V

    .line 141
    iget-object v1, p0, Lcom/poshmark/ui/customviews/GestureView;->currentMatrix:Landroid/graphics/Matrix;

    iget-object v2, p0, Lcom/poshmark/ui/customviews/GestureView;->bitmapTopLeft:Landroid/graphics/Point;

    iget v2, v2, Landroid/graphics/Point;->x:I

    int-to-float v2, v2

    iget-object v3, p0, Lcom/poshmark/ui/customviews/GestureView;->bitmapTopLeft:Landroid/graphics/Point;

    iget v3, v3, Landroid/graphics/Point;->y:I

    int-to-float v3, v3

    invoke-virtual {v1, v2, v3}, Landroid/graphics/Matrix;->postTranslate(FF)Z

    .line 142
    iget-object v1, p0, Lcom/poshmark/ui/customviews/GestureView;->bitmap:Landroid/graphics/Bitmap;

    iget-object v2, p0, Lcom/poshmark/ui/customviews/GestureView;->currentMatrix:Landroid/graphics/Matrix;

    iget-object v3, p0, Lcom/poshmark/ui/customviews/GestureView;->backgroundPaint:Landroid/graphics/Paint;

    invoke-virtual {v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;Landroid/graphics/Paint;)V

    .line 143
    invoke-direct {p0, v0}, Lcom/poshmark/ui/customviews/GestureView;->drawGrid(Landroid/graphics/Canvas;)V

    .line 144
    iget-object v1, p0, Lcom/poshmark/ui/customviews/GestureView;->holder:Landroid/view/SurfaceHolder;

    invoke-interface {v1, v0}, Landroid/view/SurfaceHolder;->unlockCanvasAndPost(Landroid/graphics/Canvas;)V

    .line 145
    return-void
.end method

.method public updateScaleFactor(F)V
    .locals 0
    .param p1, "value"    # F

    .prologue
    .line 424
    iput p1, p0, Lcom/poshmark/ui/customviews/GestureView;->xCurrentScaleFactor:F

    .line 425
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/GestureView;->updateImage()V

    .line 426
    return-void
.end method

.method public updateTranslation(Landroid/graphics/Point;)V
    .locals 2
    .param p1, "p"    # Landroid/graphics/Point;

    .prologue
    .line 417
    iget-object v0, p0, Lcom/poshmark/ui/customviews/GestureView;->bitmapTopLeft:Landroid/graphics/Point;

    iget v1, p1, Landroid/graphics/Point;->x:I

    iput v1, v0, Landroid/graphics/Point;->x:I

    .line 418
    iget-object v0, p0, Lcom/poshmark/ui/customviews/GestureView;->bitmapTopLeft:Landroid/graphics/Point;

    iget v1, p1, Landroid/graphics/Point;->y:I

    iput v1, v0, Landroid/graphics/Point;->y:I

    .line 419
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/GestureView;->updateImage()V

    .line 420
    return-void
.end method
