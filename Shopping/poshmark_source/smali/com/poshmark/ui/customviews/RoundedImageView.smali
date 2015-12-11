.class public Lcom/poshmark/ui/customviews/RoundedImageView;
.super Lcom/poshmark/ui/customviews/PMAvataarImageView;
.source "RoundedImageView.java"


# instance fields
.field private attachedToWindow:Z

.field private hasBorder:Z

.field private imageBmp:Landroid/graphics/Bitmap;

.field public listener:Lcom/nostra13/universalimageloader/core/listener/ImageLoadingListener;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v0, 0x0

    .line 37
    invoke-direct {p0, p1}, Lcom/poshmark/ui/customviews/PMAvataarImageView;-><init>(Landroid/content/Context;)V

    .line 32
    iput-boolean v0, p0, Lcom/poshmark/ui/customviews/RoundedImageView;->hasBorder:Z

    .line 33
    iput-boolean v0, p0, Lcom/poshmark/ui/customviews/RoundedImageView;->attachedToWindow:Z

    .line 173
    new-instance v0, Lcom/poshmark/ui/customviews/RoundedImageView$1;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/customviews/RoundedImageView$1;-><init>(Lcom/poshmark/ui/customviews/RoundedImageView;)V

    iput-object v0, p0, Lcom/poshmark/ui/customviews/RoundedImageView;->listener:Lcom/nostra13/universalimageloader/core/listener/ImageLoadingListener;

    .line 38
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v3, 0x0

    .line 41
    invoke-direct {p0, p1, p2}, Lcom/poshmark/ui/customviews/PMAvataarImageView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 32
    iput-boolean v3, p0, Lcom/poshmark/ui/customviews/RoundedImageView;->hasBorder:Z

    .line 33
    iput-boolean v3, p0, Lcom/poshmark/ui/customviews/RoundedImageView;->attachedToWindow:Z

    .line 173
    new-instance v1, Lcom/poshmark/ui/customviews/RoundedImageView$1;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/customviews/RoundedImageView$1;-><init>(Lcom/poshmark/ui/customviews/RoundedImageView;)V

    iput-object v1, p0, Lcom/poshmark/ui/customviews/RoundedImageView;->listener:Lcom/nostra13/universalimageloader/core/listener/ImageLoadingListener;

    .line 43
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/RoundedImageView;->getContext()Landroid/content/Context;

    move-result-object v1

    sget-object v2, Lcom/poshmark/app/R$styleable;->RoundedImageView:[I

    invoke-virtual {v1, p2, v2}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 44
    .local v0, "array":Landroid/content/res/TypedArray;
    invoke-virtual {v0, v3, v3}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v1

    iput-boolean v1, p0, Lcom/poshmark/ui/customviews/RoundedImageView;->hasBorder:Z

    .line 45
    return-void
.end method

.method static synthetic access$002(Lcom/poshmark/ui/customviews/RoundedImageView;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/customviews/RoundedImageView;
    .param p1, "x1"    # Landroid/graphics/Bitmap;

    .prologue
    .line 30
    iput-object p1, p0, Lcom/poshmark/ui/customviews/RoundedImageView;->imageBmp:Landroid/graphics/Bitmap;

    return-object p1
.end method

.method static synthetic access$100(Lcom/poshmark/ui/customviews/RoundedImageView;)Z
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/customviews/RoundedImageView;

    .prologue
    .line 30
    iget-boolean v0, p0, Lcom/poshmark/ui/customviews/RoundedImageView;->attachedToWindow:Z

    return v0
.end method

.method public static getCroppedBitmap(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    .locals 11
    .param p0, "bmp"    # Landroid/graphics/Bitmap;
    .param p1, "radius"    # I

    .prologue
    const/4 v10, 0x1

    const/4 v9, 0x0

    .line 144
    const/4 v1, 0x0

    .line 145
    .local v1, "isScaled":Z
    invoke-virtual {p0}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v6

    if-ne v6, p1, :cond_0

    invoke-virtual {p0}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v6

    if-eq v6, p1, :cond_2

    .line 146
    :cond_0
    invoke-static {p0, p1, p1, v9}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object v5

    .line 147
    .local v5, "sbmp":Landroid/graphics/Bitmap;
    const/4 v1, 0x1

    .line 152
    :goto_0
    invoke-virtual {v5}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v6

    invoke-virtual {v5}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v7

    sget-object v8, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    invoke-static {v6, v7, v8}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v2

    .line 153
    .local v2, "output":Landroid/graphics/Bitmap;
    new-instance v0, Landroid/graphics/Canvas;

    invoke-direct {v0, v2}, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V

    .line 155
    .local v0, "canvas":Landroid/graphics/Canvas;
    new-instance v3, Landroid/graphics/Paint;

    invoke-direct {v3}, Landroid/graphics/Paint;-><init>()V

    .line 156
    .local v3, "paint":Landroid/graphics/Paint;
    new-instance v4, Landroid/graphics/Rect;

    invoke-virtual {v5}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v6

    invoke-virtual {v5}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v7

    invoke-direct {v4, v9, v9, v6, v7}, Landroid/graphics/Rect;-><init>(IIII)V

    .line 158
    .local v4, "rect":Landroid/graphics/Rect;
    invoke-virtual {v3, v10}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    .line 159
    invoke-virtual {v3, v10}, Landroid/graphics/Paint;->setFilterBitmap(Z)V

    .line 160
    invoke-virtual {v3, v10}, Landroid/graphics/Paint;->setDither(Z)V

    .line 161
    invoke-virtual {v0, v9, v9, v9, v9}, Landroid/graphics/Canvas;->drawARGB(IIII)V

    .line 162
    const/4 v6, -0x1

    invoke-virtual {v3, v6}, Landroid/graphics/Paint;->setColor(I)V

    .line 163
    invoke-virtual {v5}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v6

    div-int/lit8 v6, v6, 0x2

    int-to-float v6, v6

    invoke-virtual {v5}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v7

    div-int/lit8 v7, v7, 0x2

    int-to-float v7, v7

    invoke-virtual {v5}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v8

    div-int/lit8 v8, v8, 0x2

    int-to-float v8, v8

    invoke-virtual {v0, v6, v7, v8, v3}, Landroid/graphics/Canvas;->drawCircle(FFFLandroid/graphics/Paint;)V

    .line 164
    new-instance v6, Landroid/graphics/PorterDuffXfermode;

    sget-object v7, Landroid/graphics/PorterDuff$Mode;->SRC_IN:Landroid/graphics/PorterDuff$Mode;

    invoke-direct {v6, v7}, Landroid/graphics/PorterDuffXfermode;-><init>(Landroid/graphics/PorterDuff$Mode;)V

    invoke-virtual {v3, v6}, Landroid/graphics/Paint;->setXfermode(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;

    .line 165
    invoke-virtual {v0, v5, v4, v4, v3}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V

    .line 167
    if-eqz v1, :cond_1

    .line 168
    invoke-virtual {v5}, Landroid/graphics/Bitmap;->recycle()V

    .line 170
    :cond_1
    return-object v2

    .line 150
    .end local v0    # "canvas":Landroid/graphics/Canvas;
    .end local v2    # "output":Landroid/graphics/Bitmap;
    .end local v3    # "paint":Landroid/graphics/Paint;
    .end local v4    # "rect":Landroid/graphics/Rect;
    .end local v5    # "sbmp":Landroid/graphics/Bitmap;
    :cond_2
    move-object v5, p0

    .restart local v5    # "sbmp":Landroid/graphics/Bitmap;
    goto :goto_0
.end method


# virtual methods
.method public onAttachedToWindow()V
    .locals 1

    .prologue
    .line 79
    invoke-super {p0}, Lcom/poshmark/ui/customviews/PMAvataarImageView;->onAttachedToWindow()V

    .line 80
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/ui/customviews/RoundedImageView;->attachedToWindow:Z

    .line 81
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/RoundedImageView;->setBitmap()V

    .line 82
    return-void
.end method

.method public onDetachedFromWindow()V
    .locals 1

    .prologue
    .line 86
    invoke-super {p0}, Lcom/poshmark/ui/customviews/PMAvataarImageView;->onDetachedFromWindow()V

    .line 87
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/poshmark/ui/customviews/RoundedImageView;->attachedToWindow:Z

    .line 88
    return-void
.end method

.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 14
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 93
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/RoundedImageView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v3

    .line 95
    .local v3, "drawable":Landroid/graphics/drawable/Drawable;
    if-nez v3, :cond_1

    .line 139
    .end local v3    # "drawable":Landroid/graphics/drawable/Drawable;
    :cond_0
    :goto_0
    return-void

    .line 99
    .restart local v3    # "drawable":Landroid/graphics/drawable/Drawable;
    :cond_1
    sget v10, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v11, 0x12

    if-lt v10, v11, :cond_2

    .line 100
    invoke-super {p0, p1}, Lcom/poshmark/ui/customviews/PMAvataarImageView;->onDraw(Landroid/graphics/Canvas;)V

    goto :goto_0

    .line 104
    :cond_2
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/RoundedImageView;->getWidth()I

    move-result v10

    if-eqz v10, :cond_0

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/RoundedImageView;->getHeight()I

    move-result v10

    if-eqz v10, :cond_0

    .line 107
    check-cast v3, Landroid/graphics/drawable/BitmapDrawable;

    .end local v3    # "drawable":Landroid/graphics/drawable/Drawable;
    invoke-virtual {v3}, Landroid/graphics/drawable/BitmapDrawable;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object v0

    .line 110
    .local v0, "b":Landroid/graphics/Bitmap;
    const/4 v6, 0x0

    .line 111
    .local v6, "isDefaultImage":Z
    if-nez v0, :cond_4

    .line 112
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/RoundedImageView;->getResources()Landroid/content/res/Resources;

    move-result-object v10

    const-string v11, "ic_user_default"

    const-string v12, "drawable"

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v13

    invoke-virtual {v13}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v10, v11, v12, v13}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v5

    .line 113
    .local v5, "id":I
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v10

    invoke-virtual {v10}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v10

    invoke-static {v10, v5}, Lcom/newrelic/agent/android/instrumentation/BitmapFactoryInstrumentation;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v1

    .line 114
    .local v1, "bitmap":Landroid/graphics/Bitmap;
    const/4 v6, 0x1

    .line 120
    .end local v5    # "id":I
    :goto_1
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/RoundedImageView;->getWidth()I

    move-result v9

    .line 121
    .local v9, "w":I
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/RoundedImageView;->getHeight()I

    move-result v4

    .line 123
    .local v4, "h":I
    const/4 v2, 0x0

    .line 124
    .local v2, "borderWidth":F
    iget-boolean v10, p0, Lcom/poshmark/ui/customviews/RoundedImageView;->hasBorder:Z

    if-eqz v10, :cond_3

    .line 125
    const/high16 v2, 0x40000000    # 2.0f

    .line 126
    new-instance v7, Landroid/graphics/Paint;

    invoke-direct {v7}, Landroid/graphics/Paint;-><init>()V

    .line 127
    .local v7, "paint":Landroid/graphics/Paint;
    const/4 v10, 0x1

    invoke-virtual {v7, v10}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    .line 128
    const-string v10, "#99ffffff"

    invoke-static {v10}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v10

    invoke-virtual {v7, v10}, Landroid/graphics/Paint;->setColor(I)V

    .line 129
    div-int/lit8 v10, v9, 0x2

    int-to-float v10, v10

    div-int/lit8 v11, v4, 0x2

    int-to-float v11, v11

    div-int/lit8 v12, v9, 0x2

    int-to-float v12, v12

    invoke-virtual {p1, v10, v11, v12, v7}, Landroid/graphics/Canvas;->drawCircle(FFFLandroid/graphics/Paint;)V

    .line 130
    int-to-float v10, v9

    const/high16 v11, 0x40000000    # 2.0f

    mul-float/2addr v11, v2

    sub-float/2addr v10, v11

    float-to-int v9, v10

    .line 133
    .end local v7    # "paint":Landroid/graphics/Paint;
    :cond_3
    invoke-static {v1, v9}, Lcom/poshmark/ui/customviews/RoundedImageView;->getCroppedBitmap(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;

    move-result-object v8

    .line 134
    .local v8, "roundBitmap":Landroid/graphics/Bitmap;
    const/4 v10, 0x0

    invoke-virtual {p1, v8, v2, v2, v10}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 136
    invoke-virtual {v8}, Landroid/graphics/Bitmap;->recycle()V

    .line 137
    if-nez v6, :cond_0

    .line 138
    invoke-virtual {v1}, Landroid/graphics/Bitmap;->recycle()V

    goto/16 :goto_0

    .line 117
    .end local v1    # "bitmap":Landroid/graphics/Bitmap;
    .end local v2    # "borderWidth":F
    .end local v4    # "h":I
    .end local v8    # "roundBitmap":Landroid/graphics/Bitmap;
    .end local v9    # "w":I
    :cond_4
    sget-object v10, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    const/4 v11, 0x1

    invoke-virtual {v0, v10, v11}, Landroid/graphics/Bitmap;->copy(Landroid/graphics/Bitmap$Config;Z)Landroid/graphics/Bitmap;

    move-result-object v1

    .restart local v1    # "bitmap":Landroid/graphics/Bitmap;
    goto :goto_1
.end method

.method public setBitmap()V
    .locals 3

    .prologue
    .line 66
    iget-object v1, p0, Lcom/poshmark/ui/customviews/RoundedImageView;->imageBmp:Landroid/graphics/Bitmap;

    if-eqz v1, :cond_0

    .line 67
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x12

    if-lt v1, v2, :cond_1

    .line 68
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/customviews/RoundedImageView;->imageBmp:Landroid/graphics/Bitmap;

    invoke-static {v1, v2}, Landroid/support/v4/graphics/drawable/RoundedBitmapDrawableFactory;->create(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)Landroid/support/v4/graphics/drawable/RoundedBitmapDrawable;

    move-result-object v0

    .line 69
    .local v0, "roundedDrawable":Landroid/support/v4/graphics/drawable/RoundedBitmapDrawable;
    iget-object v1, p0, Lcom/poshmark/ui/customviews/RoundedImageView;->imageBmp:Landroid/graphics/Bitmap;

    invoke-virtual {v1}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v1

    iget-object v2, p0, Lcom/poshmark/ui/customviews/RoundedImageView;->imageBmp:Landroid/graphics/Bitmap;

    invoke-virtual {v2}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v2

    invoke-static {v1, v2}, Ljava/lang/Math;->max(II)I

    move-result v1

    int-to-float v1, v1

    const/high16 v2, 0x40000000    # 2.0f

    div-float/2addr v1, v2

    invoke-virtual {v0, v1}, Landroid/support/v4/graphics/drawable/RoundedBitmapDrawable;->setCornerRadius(F)V

    .line 70
    invoke-virtual {p0, v0}, Lcom/poshmark/ui/customviews/RoundedImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 75
    .end local v0    # "roundedDrawable":Landroid/support/v4/graphics/drawable/RoundedBitmapDrawable;
    :cond_0
    :goto_0
    return-void

    .line 72
    :cond_1
    iget-object v1, p0, Lcom/poshmark/ui/customviews/RoundedImageView;->imageBmp:Landroid/graphics/Bitmap;

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/customviews/RoundedImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    goto :goto_0
.end method

.method public setBitmap(I)V
    .locals 1
    .param p1, "id"    # I

    .prologue
    .line 59
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-static {v0, p1}, Lcom/newrelic/agent/android/instrumentation/BitmapFactoryInstrumentation;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/ui/customviews/RoundedImageView;->imageBmp:Landroid/graphics/Bitmap;

    .line 60
    iget-boolean v0, p0, Lcom/poshmark/ui/customviews/RoundedImageView;->attachedToWindow:Z

    if-eqz v0, :cond_0

    .line 61
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/RoundedImageView;->setBitmap()V

    .line 63
    :cond_0
    return-void
.end method

.method public setBitmap(Landroid/graphics/Bitmap;)V
    .locals 1
    .param p1, "bmp"    # Landroid/graphics/Bitmap;

    .prologue
    .line 52
    iput-object p1, p0, Lcom/poshmark/ui/customviews/RoundedImageView;->imageBmp:Landroid/graphics/Bitmap;

    .line 53
    iget-boolean v0, p0, Lcom/poshmark/ui/customviews/RoundedImageView;->attachedToWindow:Z

    if-eqz v0, :cond_0

    .line 54
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/RoundedImageView;->setBitmap()V

    .line 56
    :cond_0
    return-void
.end method

.method public setHasBorder(Z)V
    .locals 0
    .param p1, "border"    # Z

    .prologue
    .line 48
    iput-boolean p1, p0, Lcom/poshmark/ui/customviews/RoundedImageView;->hasBorder:Z

    .line 49
    return-void
.end method
