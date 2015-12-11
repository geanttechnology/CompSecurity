.class public final Lcom/amazon/retailsearch/android/ui/results/views/ArrowView;
.super Ljava/lang/Object;
.source "ArrowView.java"


# instance fields
.field context:Landroid/content/Context;

.field fillColor:I

.field landscapeHeight:F

.field landscapeWidth:F

.field metrics:Landroid/util/DisplayMetrics;

.field offset:F

.field portraitHeight:F

.field portraitWidth:F

.field strokeColor:I

.field strokeWidth:F


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 39
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 40
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/ArrowView;->context:Landroid/content/Context;

    .line 41
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/retailsearch/R$dimen;->rs_split_view_indicator_landscape_width:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v0

    iput v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/ArrowView;->landscapeWidth:F

    .line 42
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/retailsearch/R$dimen;->rs_split_view_indicator_landscape_height:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v0

    iput v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/ArrowView;->landscapeHeight:F

    .line 43
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/retailsearch/R$dimen;->rs_split_view_indicator_portrait_width:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v0

    iput v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/ArrowView;->portraitWidth:F

    .line 44
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/retailsearch/R$dimen;->rs_split_view_indicator_portrait_height:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v0

    iput v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/ArrowView;->portraitHeight:F

    .line 46
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/retailsearch/R$dimen;->rs_split_view_indicator_stroke_width:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v0

    iput v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/ArrowView;->strokeWidth:F

    .line 47
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/retailsearch/R$color;->aui_tertiary:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v0

    iput v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/ArrowView;->strokeColor:I

    .line 48
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/retailsearch/R$color;->rs_white:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v0

    iput v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/ArrowView;->fillColor:I

    .line 50
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/retailsearch/R$dimen;->rs_split_view_indicator_offset:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v0

    iput v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/ArrowView;->offset:F

    .line 52
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/ArrowView;->metrics:Landroid/util/DisplayMetrics;

    .line 53
    return-void
.end method


# virtual methods
.method public getArrow(I)Landroid/graphics/drawable/BitmapDrawable;
    .locals 12
    .param p1, "orientation"    # I

    .prologue
    .line 65
    new-instance v5, Landroid/graphics/Paint;

    invoke-direct {v5}, Landroid/graphics/Paint;-><init>()V

    .line 66
    .local v5, "paintStroke":Landroid/graphics/Paint;
    sget-object v9, Landroid/graphics/Paint$Style;->STROKE:Landroid/graphics/Paint$Style;

    invoke-virtual {v5, v9}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 67
    iget v9, p0, Lcom/amazon/retailsearch/android/ui/results/views/ArrowView;->strokeWidth:F

    invoke-virtual {v5, v9}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 68
    iget v9, p0, Lcom/amazon/retailsearch/android/ui/results/views/ArrowView;->strokeColor:I

    invoke-virtual {v5, v9}, Landroid/graphics/Paint;->setColor(I)V

    .line 70
    new-instance v4, Landroid/graphics/Paint;

    invoke-direct {v4}, Landroid/graphics/Paint;-><init>()V

    .line 71
    .local v4, "paintFill":Landroid/graphics/Paint;
    sget-object v9, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    invoke-virtual {v4, v9}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 72
    iget v9, p0, Lcom/amazon/retailsearch/android/ui/results/views/ArrowView;->fillColor:I

    invoke-virtual {v4, v9}, Landroid/graphics/Paint;->setColor(I)V

    .line 74
    new-instance v7, Landroid/graphics/Path;

    invoke-direct {v7}, Landroid/graphics/Path;-><init>()V

    .line 75
    .local v7, "pathStroke":Landroid/graphics/Path;
    new-instance v6, Landroid/graphics/Path;

    invoke-direct {v6}, Landroid/graphics/Path;-><init>()V

    .line 77
    .local v6, "pathFill":Landroid/graphics/Path;
    const/4 v8, 0x0

    .line 78
    .local v8, "width":F
    const/4 v2, 0x0

    .line 79
    .local v2, "height":F
    const/4 v9, 0x2

    if-ne p1, v9, :cond_4

    .line 81
    iget v8, p0, Lcom/amazon/retailsearch/android/ui/results/views/ArrowView;->landscapeWidth:F

    .line 82
    iget v2, p0, Lcom/amazon/retailsearch/android/ui/results/views/ArrowView;->landscapeHeight:F

    .line 90
    :cond_0
    :goto_0
    float-to-int v9, v8

    float-to-int v10, v2

    sget-object v11, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    invoke-static {v9, v10, v11}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 91
    .local v0, "bg":Landroid/graphics/Bitmap;
    new-instance v1, Landroid/graphics/Canvas;

    invoke-direct {v1, v0}, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V

    .line 93
    .local v1, "canvas":Landroid/graphics/Canvas;
    const/4 v9, 0x2

    if-ne p1, v9, :cond_5

    .line 98
    iget-object v9, p0, Lcom/amazon/retailsearch/android/ui/results/views/ArrowView;->metrics:Landroid/util/DisplayMetrics;

    iget v9, v9, Landroid/util/DisplayMetrics;->xdpi:F

    const/high16 v10, 0x43700000    # 240.0f

    cmpl-float v9, v9, v10

    if-eqz v9, :cond_1

    iget-object v9, p0, Lcom/amazon/retailsearch/android/ui/results/views/ArrowView;->metrics:Landroid/util/DisplayMetrics;

    iget v9, v9, Landroid/util/DisplayMetrics;->xdpi:F

    const/high16 v10, 0x43580000    # 216.0f

    cmpl-float v9, v9, v10

    if-nez v9, :cond_2

    :cond_1
    iget-object v9, p0, Lcom/amazon/retailsearch/android/ui/results/views/ArrowView;->metrics:Landroid/util/DisplayMetrics;

    iget v9, v9, Landroid/util/DisplayMetrics;->densityDpi:I

    const/16 v10, 0xf0

    if-ne v9, v10, :cond_2

    .line 100
    iget v9, p0, Lcom/amazon/retailsearch/android/ui/results/views/ArrowView;->offset:F

    const/high16 v10, 0x3f800000    # 1.0f

    sub-float/2addr v9, v10

    iput v9, p0, Lcom/amazon/retailsearch/android/ui/results/views/ArrowView;->offset:F

    .line 102
    :cond_2
    iget v9, p0, Lcom/amazon/retailsearch/android/ui/results/views/ArrowView;->offset:F

    iget v10, p0, Lcom/amazon/retailsearch/android/ui/results/views/ArrowView;->offset:F

    invoke-virtual {v7, v9, v10}, Landroid/graphics/Path;->moveTo(FF)V

    .line 103
    const/high16 v9, 0x40000000    # 2.0f

    div-float v9, v2, v9

    invoke-virtual {v7, v8, v9}, Landroid/graphics/Path;->lineTo(FF)V

    .line 104
    iget v9, p0, Lcom/amazon/retailsearch/android/ui/results/views/ArrowView;->offset:F

    iget v10, p0, Lcom/amazon/retailsearch/android/ui/results/views/ArrowView;->offset:F

    sub-float v10, v2, v10

    invoke-virtual {v7, v9, v10}, Landroid/graphics/Path;->lineTo(FF)V

    .line 106
    const/4 v9, 0x0

    const/4 v10, 0x0

    invoke-virtual {v6, v9, v10}, Landroid/graphics/Path;->moveTo(FF)V

    .line 107
    const/high16 v9, 0x40000000    # 2.0f

    div-float v9, v2, v9

    invoke-virtual {v6, v8, v9}, Landroid/graphics/Path;->lineTo(FF)V

    .line 108
    const/4 v9, 0x0

    invoke-virtual {v6, v9, v2}, Landroid/graphics/Path;->lineTo(FF)V

    .line 109
    invoke-virtual {v6}, Landroid/graphics/Path;->close()V

    .line 122
    :cond_3
    :goto_1
    invoke-virtual {v1, v6, v4}, Landroid/graphics/Canvas;->drawPath(Landroid/graphics/Path;Landroid/graphics/Paint;)V

    .line 123
    invoke-virtual {v1, v7, v5}, Landroid/graphics/Canvas;->drawPath(Landroid/graphics/Path;Landroid/graphics/Paint;)V

    .line 125
    iget-object v9, p0, Lcom/amazon/retailsearch/android/ui/results/views/ArrowView;->context:Landroid/content/Context;

    invoke-virtual {v9}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v9

    invoke-virtual {v9}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v3

    .line 126
    .local v3, "metrics":Landroid/util/DisplayMetrics;
    iget v9, v3, Landroid/util/DisplayMetrics;->densityDpi:I

    invoke-virtual {v0, v9}, Landroid/graphics/Bitmap;->setDensity(I)V

    .line 127
    new-instance v9, Landroid/graphics/drawable/BitmapDrawable;

    invoke-direct {v9, v0}, Landroid/graphics/drawable/BitmapDrawable;-><init>(Landroid/graphics/Bitmap;)V

    return-object v9

    .line 84
    .end local v0    # "bg":Landroid/graphics/Bitmap;
    .end local v1    # "canvas":Landroid/graphics/Canvas;
    .end local v3    # "metrics":Landroid/util/DisplayMetrics;
    :cond_4
    const/4 v9, 0x1

    if-ne p1, v9, :cond_0

    .line 86
    iget v8, p0, Lcom/amazon/retailsearch/android/ui/results/views/ArrowView;->portraitWidth:F

    .line 87
    iget v2, p0, Lcom/amazon/retailsearch/android/ui/results/views/ArrowView;->portraitHeight:F

    goto :goto_0

    .line 111
    .restart local v0    # "bg":Landroid/graphics/Bitmap;
    .restart local v1    # "canvas":Landroid/graphics/Canvas;
    :cond_5
    const/4 v9, 0x1

    if-ne p1, v9, :cond_3

    .line 113
    iget v9, p0, Lcom/amazon/retailsearch/android/ui/results/views/ArrowView;->offset:F

    iget v10, p0, Lcom/amazon/retailsearch/android/ui/results/views/ArrowView;->offset:F

    invoke-virtual {v7, v9, v10}, Landroid/graphics/Path;->moveTo(FF)V

    .line 114
    const/high16 v9, 0x40000000    # 2.0f

    div-float v9, v8, v9

    invoke-virtual {v7, v9, v2}, Landroid/graphics/Path;->lineTo(FF)V

    .line 115
    iget v9, p0, Lcom/amazon/retailsearch/android/ui/results/views/ArrowView;->offset:F

    sub-float v9, v8, v9

    iget v10, p0, Lcom/amazon/retailsearch/android/ui/results/views/ArrowView;->offset:F

    invoke-virtual {v7, v9, v10}, Landroid/graphics/Path;->lineTo(FF)V

    .line 117
    const/4 v9, 0x0

    const/4 v10, 0x0

    invoke-virtual {v6, v9, v10}, Landroid/graphics/Path;->moveTo(FF)V

    .line 118
    const/high16 v9, 0x40000000    # 2.0f

    div-float v9, v8, v9

    invoke-virtual {v6, v9, v2}, Landroid/graphics/Path;->lineTo(FF)V

    .line 119
    const/4 v9, 0x0

    invoke-virtual {v6, v8, v9}, Landroid/graphics/Path;->lineTo(FF)V

    .line 120
    invoke-virtual {v6}, Landroid/graphics/Path;->close()V

    goto :goto_1
.end method
