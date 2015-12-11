.class public Lcom/poshmark/image_processing/ImageEffects;
.super Ljava/lang/Object;
.source "ImageEffects.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static adjustImage(Landroid/graphics/Bitmap;FFF)Landroid/graphics/Bitmap;
    .locals 24
    .param p0, "src"    # Landroid/graphics/Bitmap;
    .param p1, "contrast"    # F
    .param p2, "saturation"    # F
    .param p3, "brightness"    # F

    .prologue
    .line 54
    invoke-virtual/range {p0 .. p0}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v12

    .line 55
    .local v12, "width":I
    invoke-virtual/range {p0 .. p0}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v8

    .line 57
    .local v8, "height":I
    const/4 v2, 0x0

    .local v2, "A":F
    const/4 v5, 0x0

    .local v5, "R":F
    const/4 v4, 0x0

    .local v4, "G":F
    const/4 v3, 0x0

    .line 60
    .local v3, "B":F
    const/4 v13, 0x0

    .local v13, "x":I
    :goto_0
    if-ge v13, v12, :cond_7

    .line 61
    const/4 v14, 0x0

    .local v14, "y":I
    :goto_1
    if-ge v14, v8, :cond_6

    .line 63
    move-object/from16 v0, p0

    invoke-virtual {v0, v13, v14}, Landroid/graphics/Bitmap;->getPixel(II)I

    move-result v10

    .line 64
    .local v10, "pixel":I
    invoke-static {v10}, Landroid/graphics/Color;->alpha(I)I

    move-result v15

    int-to-float v2, v15

    .line 66
    invoke-static {v10}, Landroid/graphics/Color;->red(I)I

    move-result v15

    int-to-float v15, v15

    mul-float v5, v15, p3

    .line 67
    invoke-static {v10}, Landroid/graphics/Color;->green(I)I

    move-result v15

    int-to-float v15, v15

    mul-float v4, v15, p3

    .line 68
    invoke-static {v10}, Landroid/graphics/Color;->blue(I)I

    move-result v15

    int-to-float v15, v15

    mul-float v3, v15, p3

    .line 70
    float-to-double v0, v5

    move-wide/from16 v16, v0

    const-wide v18, 0x3fcb333333333333L    # 0.2125

    mul-double v16, v16, v18

    float-to-double v0, v4

    move-wide/from16 v18, v0

    const-wide v20, 0x3fe6e48e8a71de6aL    # 0.7154

    mul-double v18, v18, v20

    add-double v16, v16, v18

    float-to-double v0, v3

    move-wide/from16 v18, v0

    const-wide v20, 0x3fb27525460aa64cL    # 0.0721

    mul-double v18, v18, v20

    add-double v16, v16, v18

    move-wide/from16 v0, v16

    double-to-float v9, v0

    .line 72
    .local v9, "intensity":F
    sub-float v15, v5, v9

    mul-float v15, v15, p2

    add-float v5, v9, v15

    .line 73
    sub-float v15, v4, v9

    mul-float v15, v15, p2

    add-float v4, v9, v15

    .line 74
    sub-float v15, v3, v9

    mul-float v15, v15, p2

    add-float v3, v9, v15

    .line 76
    const-wide/high16 v16, 0x3fe0000000000000L    # 0.5

    move/from16 v0, p1

    float-to-double v0, v0

    move-wide/from16 v18, v0

    float-to-double v0, v5

    move-wide/from16 v20, v0

    const-wide/high16 v22, 0x3fe0000000000000L    # 0.5

    sub-double v20, v20, v22

    mul-double v18, v18, v20

    add-double v16, v16, v18

    move-wide/from16 v0, v16

    double-to-float v5, v0

    .line 77
    const-wide/high16 v16, 0x3fe0000000000000L    # 0.5

    move/from16 v0, p1

    float-to-double v0, v0

    move-wide/from16 v18, v0

    float-to-double v0, v4

    move-wide/from16 v20, v0

    const-wide/high16 v22, 0x3fe0000000000000L    # 0.5

    sub-double v20, v20, v22

    mul-double v18, v18, v20

    add-double v16, v16, v18

    move-wide/from16 v0, v16

    double-to-float v4, v0

    .line 78
    const-wide/high16 v16, 0x3fe0000000000000L    # 0.5

    move/from16 v0, p1

    float-to-double v0, v0

    move-wide/from16 v18, v0

    float-to-double v0, v3

    move-wide/from16 v20, v0

    const-wide/high16 v22, 0x3fe0000000000000L    # 0.5

    sub-double v20, v20, v22

    mul-double v18, v18, v20

    add-double v16, v16, v18

    move-wide/from16 v0, v16

    double-to-float v3, v0

    .line 80
    const/4 v15, 0x0

    cmpg-float v15, v5, v15

    if-gez v15, :cond_3

    const/4 v5, 0x0

    .line 81
    :cond_0
    :goto_2
    const/4 v15, 0x0

    cmpg-float v15, v4, v15

    if-gez v15, :cond_4

    const/4 v4, 0x0

    .line 82
    :cond_1
    :goto_3
    const/4 v15, 0x0

    cmpg-float v15, v3, v15

    if-gez v15, :cond_5

    const/4 v3, 0x0

    .line 84
    :cond_2
    :goto_4
    float-to-int v11, v5

    .line 85
    .local v11, "r":I
    float-to-int v7, v4

    .line 86
    .local v7, "g":I
    float-to-int v6, v3

    .line 89
    .local v6, "b":I
    float-to-int v15, v2

    invoke-static {v15, v11, v7, v6}, Landroid/graphics/Color;->argb(IIII)I

    move-result v15

    move-object/from16 v0, p0

    invoke-virtual {v0, v13, v14, v15}, Landroid/graphics/Bitmap;->setPixel(III)V

    .line 61
    add-int/lit8 v14, v14, 0x1

    goto/16 :goto_1

    .line 80
    .end local v6    # "b":I
    .end local v7    # "g":I
    .end local v11    # "r":I
    :cond_3
    const/high16 v15, 0x437f0000    # 255.0f

    cmpl-float v15, v5, v15

    if-lez v15, :cond_0

    const/high16 v5, 0x437f0000    # 255.0f

    goto :goto_2

    .line 81
    :cond_4
    const/high16 v15, 0x437f0000    # 255.0f

    cmpl-float v15, v4, v15

    if-lez v15, :cond_1

    const/high16 v4, 0x437f0000    # 255.0f

    goto :goto_3

    .line 82
    :cond_5
    const/high16 v15, 0x437f0000    # 255.0f

    cmpl-float v15, v3, v15

    if-lez v15, :cond_2

    const/high16 v3, 0x437f0000    # 255.0f

    goto :goto_4

    .line 60
    .end local v9    # "intensity":F
    .end local v10    # "pixel":I
    :cond_6
    add-int/lit8 v13, v13, 0x1

    goto/16 :goto_0

    .line 93
    .end local v14    # "y":I
    :cond_7
    return-object p0
.end method

.method public static applyOverlay(Landroid/graphics/Bitmap;Ljava/lang/String;)Landroid/graphics/Bitmap;
    .locals 12
    .param p0, "src"    # Landroid/graphics/Bitmap;
    .param p1, "overlayImageName"    # Ljava/lang/String;

    .prologue
    const/4 v11, 0x0

    const/4 v10, 0x0

    const/4 v9, 0x0

    .line 37
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    .line 38
    .local v1, "context":Landroid/content/Context;
    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    const-string v7, "drawable"

    invoke-virtual {v1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v6, p1, v7, v8}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v3

    .line 39
    .local v3, "id":I
    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    invoke-static {v6, v3}, Lcom/newrelic/agent/android/instrumentation/BitmapFactoryInstrumentation;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v4

    .line 41
    .local v4, "overlay":Landroid/graphics/Bitmap;
    new-instance v0, Landroid/graphics/Canvas;

    invoke-direct {v0, p0}, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V

    .line 42
    .local v0, "canvas":Landroid/graphics/Canvas;
    new-instance v5, Landroid/graphics/Rect;

    invoke-virtual {v4}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v6

    invoke-virtual {v4}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v7

    invoke-direct {v5, v9, v9, v6, v7}, Landroid/graphics/Rect;-><init>(IIII)V

    .line 43
    .local v5, "srcRect":Landroid/graphics/Rect;
    new-instance v2, Landroid/graphics/Rect;

    invoke-virtual {p0}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v6

    invoke-virtual {p0}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v7

    invoke-direct {v2, v9, v9, v6, v7}, Landroid/graphics/Rect;-><init>(IIII)V

    .line 44
    .local v2, "dstRect":Landroid/graphics/Rect;
    invoke-virtual {v0, p0, v10, v10, v11}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 45
    invoke-virtual {v0, v4, v5, v2, v11}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V

    .line 47
    invoke-virtual {v4}, Landroid/graphics/Bitmap;->recycle()V

    .line 49
    return-object p0
.end method

.method public static balanceColor(Landroid/graphics/Bitmap;DDD)Landroid/graphics/Bitmap;
    .locals 15
    .param p0, "src"    # Landroid/graphics/Bitmap;
    .param p1, "red"    # D
    .param p3, "green"    # D
    .param p5, "blue"    # D

    .prologue
    .line 98
    invoke-virtual {p0}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v9

    .line 99
    .local v9, "width":I
    invoke-virtual {p0}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v6

    .line 101
    .local v6, "height":I
    const/4 v0, 0x0

    .local v0, "A":F
    const/4 v3, 0x0

    .local v3, "R":F
    const/4 v2, 0x0

    .local v2, "G":F
    const/4 v1, 0x0

    .line 104
    .local v1, "B":F
    const/4 v10, 0x0

    .local v10, "x":I
    :goto_0
    if-ge v10, v9, :cond_7

    .line 105
    const/4 v11, 0x0

    .local v11, "y":I
    :goto_1
    if-ge v11, v6, :cond_6

    .line 107
    invoke-virtual {p0, v10, v11}, Landroid/graphics/Bitmap;->getPixel(II)I

    move-result v7

    .line 108
    .local v7, "pixel":I
    invoke-static {v7}, Landroid/graphics/Color;->alpha(I)I

    move-result v12

    int-to-float v0, v12

    .line 110
    invoke-static {v7}, Landroid/graphics/Color;->red(I)I

    move-result v12

    add-int/lit8 v12, v12, 0x1

    int-to-double v12, v12

    mul-double v12, v12, p1

    double-to-int v12, v12

    int-to-float v3, v12

    .line 111
    invoke-static {v7}, Landroid/graphics/Color;->green(I)I

    move-result v12

    add-int/lit8 v12, v12, 0x1

    int-to-double v12, v12

    mul-double v12, v12, p3

    double-to-int v12, v12

    int-to-float v2, v12

    .line 112
    invoke-static {v7}, Landroid/graphics/Color;->blue(I)I

    move-result v12

    add-int/lit8 v12, v12, 0x1

    int-to-double v12, v12

    mul-double v12, v12, p5

    double-to-int v12, v12

    int-to-float v1, v12

    .line 114
    const/4 v12, 0x0

    cmpg-float v12, v3, v12

    if-gez v12, :cond_3

    const/4 v3, 0x0

    .line 115
    :cond_0
    :goto_2
    const/4 v12, 0x0

    cmpg-float v12, v2, v12

    if-gez v12, :cond_4

    const/4 v2, 0x0

    .line 116
    :cond_1
    :goto_3
    const/4 v12, 0x0

    cmpg-float v12, v1, v12

    if-gez v12, :cond_5

    const/4 v1, 0x0

    .line 118
    :cond_2
    :goto_4
    float-to-int v8, v3

    .line 119
    .local v8, "r":I
    float-to-int v5, v2

    .line 120
    .local v5, "g":I
    float-to-int v4, v1

    .line 123
    .local v4, "b":I
    float-to-int v12, v0

    invoke-static {v12, v8, v5, v4}, Landroid/graphics/Color;->argb(IIII)I

    move-result v12

    invoke-virtual {p0, v10, v11, v12}, Landroid/graphics/Bitmap;->setPixel(III)V

    .line 105
    add-int/lit8 v11, v11, 0x1

    goto :goto_1

    .line 114
    .end local v4    # "b":I
    .end local v5    # "g":I
    .end local v8    # "r":I
    :cond_3
    const/high16 v12, 0x437f0000    # 255.0f

    cmpl-float v12, v3, v12

    if-lez v12, :cond_0

    const/high16 v3, 0x437f0000    # 255.0f

    goto :goto_2

    .line 115
    :cond_4
    const/high16 v12, 0x437f0000    # 255.0f

    cmpl-float v12, v2, v12

    if-lez v12, :cond_1

    const/high16 v2, 0x437f0000    # 255.0f

    goto :goto_3

    .line 116
    :cond_5
    const/high16 v12, 0x437f0000    # 255.0f

    cmpl-float v12, v1, v12

    if-lez v12, :cond_2

    const/high16 v1, 0x437f0000    # 255.0f

    goto :goto_4

    .line 104
    .end local v7    # "pixel":I
    :cond_6
    add-int/lit8 v10, v10, 0x1

    goto :goto_0

    .line 128
    .end local v11    # "y":I
    :cond_7
    return-object p0
.end method

.method public static blendColor(Landroid/graphics/Bitmap;ILandroid/graphics/PorterDuff$Mode;)Landroid/graphics/Bitmap;
    .locals 6
    .param p0, "src"    # Landroid/graphics/Bitmap;
    .param p1, "color"    # I
    .param p2, "mode"    # Landroid/graphics/PorterDuff$Mode;

    .prologue
    const/4 v5, 0x0

    .line 133
    invoke-virtual {p0}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v3

    .line 134
    .local v3, "width":I
    invoke-virtual {p0}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v1

    .line 136
    .local v1, "height":I
    new-instance v0, Landroid/graphics/Canvas;

    invoke-direct {v0, p0}, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V

    .line 137
    .local v0, "canvas":Landroid/graphics/Canvas;
    new-instance v2, Landroid/graphics/Paint;

    invoke-direct {v2}, Landroid/graphics/Paint;-><init>()V

    .line 138
    .local v2, "paint":Landroid/graphics/Paint;
    new-instance v4, Landroid/graphics/PorterDuffXfermode;

    invoke-direct {v4, p2}, Landroid/graphics/PorterDuffXfermode;-><init>(Landroid/graphics/PorterDuff$Mode;)V

    invoke-virtual {v2, v4}, Landroid/graphics/Paint;->setXfermode(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;

    .line 139
    invoke-virtual {v2, p1}, Landroid/graphics/Paint;->setColor(I)V

    .line 140
    new-instance v4, Landroid/graphics/Rect;

    invoke-direct {v4, v5, v5, v3, v1}, Landroid/graphics/Rect;-><init>(IIII)V

    invoke-virtual {v0, v4, v2}, Landroid/graphics/Canvas;->drawRect(Landroid/graphics/Rect;Landroid/graphics/Paint;)V

    .line 142
    return-object p0
.end method

.method public static convertImageToGrayScale(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    .locals 5
    .param p0, "src"    # Landroid/graphics/Bitmap;

    .prologue
    const/4 v4, 0x0

    .line 25
    new-instance v0, Landroid/graphics/Canvas;

    invoke-direct {v0, p0}, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V

    .line 26
    .local v0, "c":Landroid/graphics/Canvas;
    new-instance v3, Landroid/graphics/Paint;

    invoke-direct {v3}, Landroid/graphics/Paint;-><init>()V

    .line 27
    .local v3, "paint":Landroid/graphics/Paint;
    new-instance v1, Landroid/graphics/ColorMatrix;

    invoke-direct {v1}, Landroid/graphics/ColorMatrix;-><init>()V

    .line 28
    .local v1, "cm":Landroid/graphics/ColorMatrix;
    invoke-virtual {v1, v4}, Landroid/graphics/ColorMatrix;->setSaturation(F)V

    .line 29
    new-instance v2, Landroid/graphics/ColorMatrixColorFilter;

    invoke-direct {v2, v1}, Landroid/graphics/ColorMatrixColorFilter;-><init>(Landroid/graphics/ColorMatrix;)V

    .line 30
    .local v2, "f":Landroid/graphics/ColorMatrixColorFilter;
    invoke-virtual {v3, v2}, Landroid/graphics/Paint;->setColorFilter(Landroid/graphics/ColorFilter;)Landroid/graphics/ColorFilter;

    .line 31
    invoke-virtual {v0, p0, v4, v4, v3}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 33
    return-object p0
.end method
