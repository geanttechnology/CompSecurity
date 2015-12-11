.class public Lco/vine/android/drawable/CenteredTextDrawable;
.super Landroid/graphics/drawable/Drawable;
.source "CenteredTextDrawable.java"


# instance fields
.field private final mDrawableBounds:Landroid/graphics/Rect;

.field private mDrawables:[Landroid/graphics/drawable/Drawable;

.field private mDrawablesMinHeight:I

.field private mDrawablesMinWidth:I

.field private final mPaint:Landroid/graphics/Paint;

.field private mText:Ljava/lang/String;

.field private final mTextBounds:Landroid/graphics/Rect;

.field private mTextMinHeight:I

.field private mTextMinWidth:I

.field private final mTextPadding:Landroid/graphics/Rect;


# direct methods
.method public varargs constructor <init>(Landroid/content/res/Resources;[I)V
    .locals 1
    .param p1, "res"    # Landroid/content/res/Resources;
        .annotation build Lorg/jetbrains/annotations/NotNull;
        .end annotation
    .end param
    .param p2, "drawableIds"    # [I
        .annotation build Lorg/jetbrains/annotations/NotNull;
        .end annotation
    .end param

    .prologue
    .line 36
    invoke-static {p1, p2}, Lco/vine/android/drawable/CenteredTextDrawable;->getDrawablesFromIds(Landroid/content/res/Resources;[I)[Landroid/graphics/drawable/Drawable;

    move-result-object v0

    invoke-direct {p0, v0}, Lco/vine/android/drawable/CenteredTextDrawable;-><init>([Landroid/graphics/drawable/Drawable;)V

    .line 37
    return-void
.end method

.method public varargs constructor <init>([Landroid/graphics/drawable/Drawable;)V
    .locals 1
    .param p1, "drawables"    # [Landroid/graphics/drawable/Drawable;
        .annotation build Lorg/jetbrains/annotations/NotNull;
        .end annotation
    .end param

    .prologue
    .line 39
    invoke-direct {p0}, Landroid/graphics/drawable/Drawable;-><init>()V

    .line 40
    invoke-virtual {p0, p1}, Lco/vine/android/drawable/CenteredTextDrawable;->setDrawables([Landroid/graphics/drawable/Drawable;)V

    .line 41
    invoke-direct {p0}, Lco/vine/android/drawable/CenteredTextDrawable;->init()Landroid/graphics/Paint;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/drawable/CenteredTextDrawable;->mPaint:Landroid/graphics/Paint;

    .line 42
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    iput-object v0, p0, Lco/vine/android/drawable/CenteredTextDrawable;->mTextBounds:Landroid/graphics/Rect;

    .line 43
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    iput-object v0, p0, Lco/vine/android/drawable/CenteredTextDrawable;->mTextPadding:Landroid/graphics/Rect;

    .line 44
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    iput-object v0, p0, Lco/vine/android/drawable/CenteredTextDrawable;->mDrawableBounds:Landroid/graphics/Rect;

    .line 45
    return-void
.end method

.method private static varargs getDrawablesFromIds(Landroid/content/res/Resources;[I)[Landroid/graphics/drawable/Drawable;
    .locals 8
    .param p0, "res"    # Landroid/content/res/Resources;
    .param p1, "drawableIds"    # [I

    .prologue
    .line 59
    array-length v7, p1

    new-array v2, v7, [Landroid/graphics/drawable/Drawable;

    .line 60
    .local v2, "drawables":[Landroid/graphics/drawable/Drawable;
    const/4 v3, 0x0

    .line 61
    .local v3, "i":I
    move-object v0, p1

    .local v0, "arr$":[I
    array-length v6, v0

    .local v6, "len$":I
    const/4 v5, 0x0

    .local v5, "i$":I
    move v4, v3

    .end local v3    # "i":I
    .local v4, "i":I
    :goto_0
    if-ge v5, v6, :cond_0

    aget v1, v0, v5

    .line 62
    .local v1, "drawableId":I
    add-int/lit8 v3, v4, 0x1

    .end local v4    # "i":I
    .restart local v3    # "i":I
    invoke-virtual {p0, v1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v7

    aput-object v7, v2, v4

    .line 61
    add-int/lit8 v5, v5, 0x1

    move v4, v3

    .end local v3    # "i":I
    .restart local v4    # "i":I
    goto :goto_0

    .line 64
    .end local v1    # "drawableId":I
    :cond_0
    return-object v2
.end method

.method private init()Landroid/graphics/Paint;
    .locals 2

    .prologue
    .line 90
    new-instance v0, Landroid/graphics/Paint;

    const/16 v1, 0x41

    invoke-direct {v0, v1}, Landroid/graphics/Paint;-><init>(I)V

    .line 91
    .local v0, "paint":Landroid/graphics/Paint;
    const/high16 v1, 0x42000000    # 32.0f

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setTextSize(F)V

    .line 92
    const/high16 v1, -0x1000000

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 93
    sget-object v1, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 94
    sget-object v1, Landroid/graphics/Paint$Align;->CENTER:Landroid/graphics/Paint$Align;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setTextAlign(Landroid/graphics/Paint$Align;)V

    .line 95
    return-object v0
.end method

.method private updateTextBounds()V
    .locals 7

    .prologue
    .line 111
    iget-object v3, p0, Lco/vine/android/drawable/CenteredTextDrawable;->mText:Ljava/lang/String;

    if-nez v3, :cond_0

    const-string v1, ""

    .line 112
    .local v1, "text":Ljava/lang/String;
    :goto_0
    iget-object v3, p0, Lco/vine/android/drawable/CenteredTextDrawable;->mPaint:Landroid/graphics/Paint;

    const/4 v4, 0x0

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v5

    iget-object v6, p0, Lco/vine/android/drawable/CenteredTextDrawable;->mTextBounds:Landroid/graphics/Rect;

    invoke-virtual {v3, v1, v4, v5, v6}, Landroid/graphics/Paint;->getTextBounds(Ljava/lang/String;IILandroid/graphics/Rect;)V

    .line 113
    iget-object v3, p0, Lco/vine/android/drawable/CenteredTextDrawable;->mTextBounds:Landroid/graphics/Rect;

    invoke-virtual {v3}, Landroid/graphics/Rect;->height()I

    move-result v3

    iget-object v4, p0, Lco/vine/android/drawable/CenteredTextDrawable;->mTextPadding:Landroid/graphics/Rect;

    iget v4, v4, Landroid/graphics/Rect;->top:I

    add-int/2addr v3, v4

    iget-object v4, p0, Lco/vine/android/drawable/CenteredTextDrawable;->mTextPadding:Landroid/graphics/Rect;

    iget v4, v4, Landroid/graphics/Rect;->bottom:I

    add-int v0, v3, v4

    .line 114
    .local v0, "height":I
    iget v3, p0, Lco/vine/android/drawable/CenteredTextDrawable;->mDrawablesMinHeight:I

    invoke-static {v0, v3}, Ljava/lang/Math;->max(II)I

    move-result v3

    iput v3, p0, Lco/vine/android/drawable/CenteredTextDrawable;->mTextMinHeight:I

    .line 115
    iget-object v3, p0, Lco/vine/android/drawable/CenteredTextDrawable;->mTextBounds:Landroid/graphics/Rect;

    invoke-virtual {v3}, Landroid/graphics/Rect;->width()I

    move-result v3

    iget-object v4, p0, Lco/vine/android/drawable/CenteredTextDrawable;->mTextPadding:Landroid/graphics/Rect;

    iget v4, v4, Landroid/graphics/Rect;->left:I

    add-int/2addr v3, v4

    iget-object v4, p0, Lco/vine/android/drawable/CenteredTextDrawable;->mTextPadding:Landroid/graphics/Rect;

    iget v4, v4, Landroid/graphics/Rect;->right:I

    add-int v2, v3, v4

    .line 116
    .local v2, "width":I
    iget v3, p0, Lco/vine/android/drawable/CenteredTextDrawable;->mDrawablesMinWidth:I

    invoke-static {v2, v3}, Ljava/lang/Math;->max(II)I

    move-result v3

    iput v3, p0, Lco/vine/android/drawable/CenteredTextDrawable;->mTextMinWidth:I

    .line 117
    return-void

    .line 111
    .end local v0    # "height":I
    .end local v1    # "text":Ljava/lang/String;
    .end local v2    # "width":I
    :cond_0
    iget-object v1, p0, Lco/vine/android/drawable/CenteredTextDrawable;->mText:Ljava/lang/String;

    goto :goto_0
.end method


# virtual methods
.method public draw(Landroid/graphics/Canvas;)V
    .locals 9
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 131
    iget-object v4, p0, Lco/vine/android/drawable/CenteredTextDrawable;->mDrawableBounds:Landroid/graphics/Rect;

    invoke-virtual {p0}, Lco/vine/android/drawable/CenteredTextDrawable;->getBounds()Landroid/graphics/Rect;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/graphics/Rect;->set(Landroid/graphics/Rect;)V

    .line 132
    iget-object v0, p0, Lco/vine/android/drawable/CenteredTextDrawable;->mDrawables:[Landroid/graphics/drawable/Drawable;

    .local v0, "arr$":[Landroid/graphics/drawable/Drawable;
    array-length v3, v0

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_0
    if-ge v2, v3, :cond_0

    aget-object v1, v0, v2

    .line 133
    .local v1, "drawable":Landroid/graphics/drawable/Drawable;
    iget-object v4, p0, Lco/vine/android/drawable/CenteredTextDrawable;->mDrawableBounds:Landroid/graphics/Rect;

    invoke-virtual {v1, v4}, Landroid/graphics/drawable/Drawable;->setBounds(Landroid/graphics/Rect;)V

    .line 134
    invoke-virtual {v1, p1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 132
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 137
    .end local v1    # "drawable":Landroid/graphics/drawable/Drawable;
    :cond_0
    iget-object v4, p0, Lco/vine/android/drawable/CenteredTextDrawable;->mDrawableBounds:Landroid/graphics/Rect;

    iget v5, v4, Landroid/graphics/Rect;->left:I

    iget-object v6, p0, Lco/vine/android/drawable/CenteredTextDrawable;->mTextPadding:Landroid/graphics/Rect;

    iget v6, v6, Landroid/graphics/Rect;->left:I

    add-int/2addr v5, v6

    iput v5, v4, Landroid/graphics/Rect;->left:I

    .line 138
    iget-object v4, p0, Lco/vine/android/drawable/CenteredTextDrawable;->mDrawableBounds:Landroid/graphics/Rect;

    iget v5, v4, Landroid/graphics/Rect;->top:I

    iget-object v6, p0, Lco/vine/android/drawable/CenteredTextDrawable;->mTextPadding:Landroid/graphics/Rect;

    iget v6, v6, Landroid/graphics/Rect;->top:I

    add-int/2addr v5, v6

    iput v5, v4, Landroid/graphics/Rect;->top:I

    .line 139
    iget-object v4, p0, Lco/vine/android/drawable/CenteredTextDrawable;->mDrawableBounds:Landroid/graphics/Rect;

    iget v5, v4, Landroid/graphics/Rect;->bottom:I

    iget-object v6, p0, Lco/vine/android/drawable/CenteredTextDrawable;->mTextPadding:Landroid/graphics/Rect;

    iget v6, v6, Landroid/graphics/Rect;->bottom:I

    sub-int/2addr v5, v6

    iput v5, v4, Landroid/graphics/Rect;->bottom:I

    .line 140
    iget-object v4, p0, Lco/vine/android/drawable/CenteredTextDrawable;->mDrawableBounds:Landroid/graphics/Rect;

    iget v5, v4, Landroid/graphics/Rect;->right:I

    iget-object v6, p0, Lco/vine/android/drawable/CenteredTextDrawable;->mTextPadding:Landroid/graphics/Rect;

    iget v6, v6, Landroid/graphics/Rect;->right:I

    sub-int/2addr v5, v6

    iput v5, v4, Landroid/graphics/Rect;->right:I

    .line 141
    iget-object v4, p0, Lco/vine/android/drawable/CenteredTextDrawable;->mText:Ljava/lang/String;

    iget-object v5, p0, Lco/vine/android/drawable/CenteredTextDrawable;->mDrawableBounds:Landroid/graphics/Rect;

    invoke-virtual {v5}, Landroid/graphics/Rect;->exactCenterX()F

    move-result v5

    iget-object v6, p0, Lco/vine/android/drawable/CenteredTextDrawable;->mDrawableBounds:Landroid/graphics/Rect;

    invoke-virtual {v6}, Landroid/graphics/Rect;->exactCenterY()F

    move-result v6

    iget-object v7, p0, Lco/vine/android/drawable/CenteredTextDrawable;->mTextBounds:Landroid/graphics/Rect;

    invoke-virtual {v7}, Landroid/graphics/Rect;->height()I

    move-result v7

    int-to-float v7, v7

    const/high16 v8, 0x3f000000    # 0.5f

    mul-float/2addr v7, v8

    add-float/2addr v6, v7

    iget-object v7, p0, Lco/vine/android/drawable/CenteredTextDrawable;->mPaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v4, v5, v6, v7}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 142
    return-void
.end method

.method public getIntrinsicHeight()I
    .locals 1

    .prologue
    .line 121
    iget v0, p0, Lco/vine/android/drawable/CenteredTextDrawable;->mTextMinHeight:I

    return v0
.end method

.method public getIntrinsicWidth()I
    .locals 1

    .prologue
    .line 126
    iget v0, p0, Lco/vine/android/drawable/CenteredTextDrawable;->mTextMinWidth:I

    return v0
.end method

.method public getOpacity()I
    .locals 2

    .prologue
    .line 156
    iget-object v0, p0, Lco/vine/android/drawable/CenteredTextDrawable;->mPaint:Landroid/graphics/Paint;

    invoke-virtual {v0}, Landroid/graphics/Paint;->getAlpha()I

    move-result v0

    const/16 v1, 0xff

    if-ge v0, v1, :cond_0

    const/4 v0, -0x3

    :goto_0
    return v0

    :cond_0
    const/4 v0, -0x1

    goto :goto_0
.end method

.method public setAlpha(I)V
    .locals 1
    .param p1, "alpha"    # I

    .prologue
    .line 146
    iget-object v0, p0, Lco/vine/android/drawable/CenteredTextDrawable;->mPaint:Landroid/graphics/Paint;

    invoke-virtual {v0, p1}, Landroid/graphics/Paint;->setAlpha(I)V

    .line 147
    return-void
.end method

.method public setColorFilter(ILandroid/graphics/ColorFilter;)V
    .locals 1
    .param p1, "index"    # I
    .param p2, "cf"    # Landroid/graphics/ColorFilter;

    .prologue
    .line 68
    iget-object v0, p0, Lco/vine/android/drawable/CenteredTextDrawable;->mDrawables:[Landroid/graphics/drawable/Drawable;

    aget-object v0, v0, p1

    invoke-virtual {v0, p2}, Landroid/graphics/drawable/Drawable;->setColorFilter(Landroid/graphics/ColorFilter;)V

    .line 69
    return-void
.end method

.method public setColorFilter(Landroid/graphics/ColorFilter;)V
    .locals 1
    .param p1, "cf"    # Landroid/graphics/ColorFilter;

    .prologue
    .line 151
    iget-object v0, p0, Lco/vine/android/drawable/CenteredTextDrawable;->mPaint:Landroid/graphics/Paint;

    invoke-virtual {v0, p1}, Landroid/graphics/Paint;->setColorFilter(Landroid/graphics/ColorFilter;)Landroid/graphics/ColorFilter;

    .line 152
    return-void
.end method

.method public varargs setDrawables([Landroid/graphics/drawable/Drawable;)V
    .locals 7
    .param p1, "drawables"    # [Landroid/graphics/drawable/Drawable;
        .annotation build Lorg/jetbrains/annotations/NotNull;
        .end annotation
    .end param

    .prologue
    .line 48
    iput-object p1, p0, Lco/vine/android/drawable/CenteredTextDrawable;->mDrawables:[Landroid/graphics/drawable/Drawable;

    .line 49
    const/4 v2, 0x0

    .local v2, "height":I
    const/4 v5, 0x0

    .line 50
    .local v5, "width":I
    iget-object v0, p0, Lco/vine/android/drawable/CenteredTextDrawable;->mDrawables:[Landroid/graphics/drawable/Drawable;

    .local v0, "arr$":[Landroid/graphics/drawable/Drawable;
    array-length v4, v0

    .local v4, "len$":I
    const/4 v3, 0x0

    .local v3, "i$":I
    :goto_0
    if-ge v3, v4, :cond_0

    aget-object v1, v0, v3

    .line 51
    .local v1, "drawable":Landroid/graphics/drawable/Drawable;
    invoke-virtual {v1}, Landroid/graphics/drawable/Drawable;->getMinimumHeight()I

    move-result v6

    invoke-static {v2, v6}, Ljava/lang/Math;->max(II)I

    move-result v2

    .line 52
    invoke-virtual {v1}, Landroid/graphics/drawable/Drawable;->getMinimumWidth()I

    move-result v6

    invoke-static {v5, v6}, Ljava/lang/Math;->max(II)I

    move-result v5

    .line 50
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 54
    .end local v1    # "drawable":Landroid/graphics/drawable/Drawable;
    :cond_0
    iput v2, p0, Lco/vine/android/drawable/CenteredTextDrawable;->mDrawablesMinHeight:I

    .line 55
    iput v5, p0, Lco/vine/android/drawable/CenteredTextDrawable;->mDrawablesMinWidth:I

    .line 56
    return-void
.end method

.method public setText(Ljava/lang/String;)V
    .locals 0
    .param p1, "text"    # Ljava/lang/String;

    .prologue
    .line 72
    iput-object p1, p0, Lco/vine/android/drawable/CenteredTextDrawable;->mText:Ljava/lang/String;

    .line 73
    invoke-direct {p0}, Lco/vine/android/drawable/CenteredTextDrawable;->updateTextBounds()V

    .line 74
    invoke-virtual {p0}, Lco/vine/android/drawable/CenteredTextDrawable;->invalidateSelf()V

    .line 75
    return-void
.end method

.method public setTextColor(I)V
    .locals 1
    .param p1, "color"    # I

    .prologue
    .line 85
    iget-object v0, p0, Lco/vine/android/drawable/CenteredTextDrawable;->mPaint:Landroid/graphics/Paint;

    invoke-virtual {v0, p1}, Landroid/graphics/Paint;->setColor(I)V

    .line 86
    invoke-virtual {p0}, Lco/vine/android/drawable/CenteredTextDrawable;->invalidateSelf()V

    .line 87
    return-void
.end method

.method public setTextPadding(Landroid/graphics/Rect;)V
    .locals 2
    .param p1, "rect"    # Landroid/graphics/Rect;

    .prologue
    .line 78
    iget-object v0, p0, Lco/vine/android/drawable/CenteredTextDrawable;->mTextPadding:Landroid/graphics/Rect;

    iget v1, p1, Landroid/graphics/Rect;->left:I

    iput v1, v0, Landroid/graphics/Rect;->left:I

    .line 79
    iget-object v0, p0, Lco/vine/android/drawable/CenteredTextDrawable;->mTextPadding:Landroid/graphics/Rect;

    iget v1, p1, Landroid/graphics/Rect;->right:I

    iput v1, v0, Landroid/graphics/Rect;->right:I

    .line 80
    iget-object v0, p0, Lco/vine/android/drawable/CenteredTextDrawable;->mTextPadding:Landroid/graphics/Rect;

    iget v1, p1, Landroid/graphics/Rect;->top:I

    iput v1, v0, Landroid/graphics/Rect;->top:I

    .line 81
    iget-object v0, p0, Lco/vine/android/drawable/CenteredTextDrawable;->mTextPadding:Landroid/graphics/Rect;

    iget v1, p1, Landroid/graphics/Rect;->bottom:I

    iput v1, v0, Landroid/graphics/Rect;->bottom:I

    .line 82
    return-void
.end method

.method public setTextSize(F)V
    .locals 1
    .param p1, "textSize"    # F

    .prologue
    .line 105
    iget-object v0, p0, Lco/vine/android/drawable/CenteredTextDrawable;->mPaint:Landroid/graphics/Paint;

    invoke-virtual {v0, p1}, Landroid/graphics/Paint;->setTextSize(F)V

    .line 106
    invoke-direct {p0}, Lco/vine/android/drawable/CenteredTextDrawable;->updateTextBounds()V

    .line 107
    invoke-virtual {p0}, Lco/vine/android/drawable/CenteredTextDrawable;->invalidateSelf()V

    .line 108
    return-void
.end method

.method public setTypeFace(Landroid/graphics/Typeface;)V
    .locals 1
    .param p1, "typeFace"    # Landroid/graphics/Typeface;

    .prologue
    .line 99
    iget-object v0, p0, Lco/vine/android/drawable/CenteredTextDrawable;->mPaint:Landroid/graphics/Paint;

    invoke-virtual {v0, p1}, Landroid/graphics/Paint;->setTypeface(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;

    .line 100
    invoke-direct {p0}, Lco/vine/android/drawable/CenteredTextDrawable;->updateTextBounds()V

    .line 101
    invoke-virtual {p0}, Lco/vine/android/drawable/CenteredTextDrawable;->invalidateSelf()V

    .line 102
    return-void
.end method
