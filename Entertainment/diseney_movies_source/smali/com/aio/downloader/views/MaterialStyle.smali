.class public Lcom/aio/downloader/views/MaterialStyle;
.super Ljava/lang/Object;
.source "MaterialStyle.java"


# static fields
.field public static final TYPE_HEADBAR_BACK_BTN:I = 0x1

.field public static final TYPE_HEADBAR_RIGHT_BTN:I = 0x2

.field public static final TYPE_HEADER_CENTER_BTN:I = 0x3

.field public static final TYPE_NORMAL_BTN:I


# instance fields
.field private ANIM_FAST_TIME:I

.field private final ANIM_SLEEP_TIME:I

.field private final ANIM_SLOW_TIME:I

.field private final SHAPE_MODE_EQUAL:I

.field private final SHAPE_MODE_HEIGHT:I

.field private final SHAPE_MODE_WIDTH:I

.field private final STATUS_ANIM_FAST:I

.field private final STATUS_ANIM_SLOWLY:I

.field private final STATUS_NORMAL:I

.field private final STATUS_PRESSED:I

.field private final STATUS_TO_NORMAL:I

.field private actionDownX:F

.field private actionDownY:F

.field private animFastTimes:I

.field private animSlowTimes:I

.field private drawFilter:Landroid/graphics/PaintFlagsDrawFilter;

.field private hasClick:Z

.field private mAnimBottomPaint:Landroid/graphics/Paint;

.field private mAnimColorAlpha:I

.field private mAnimColorAlphaFastSpeed:I

.field private mAnimColorAlphaMax:I

.field private mAnimColorAlphaSlowSpeed:I

.field private mAnimColorAlphaToNormalSpeed:I

.field private mAnimFullColor:I

.field private mAnimMode:I

.field private mBackgroundColor:I

.field private mBackgroundDrawable:Landroid/graphics/drawable/Drawable;

.field private mBackgroundHeight:I

.field private mBackgroundWidth:I

.field private mCallBack:Lcom/aio/downloader/views/IMaterial;

.field private mCirRSpeedFast:F

.field private mCirRSpeedSlow:F

.field private mCirclePaint:Landroid/graphics/Paint;

.field private mCircleRadius:F

.field private mCircleRadiusMax:F

.field private mDependView:Landroid/view/View;

.field private mNeedDelayClick:Z

.field private mPath:Landroid/graphics/Path;

.field private status:I

.field private type:I


# direct methods
.method public constructor <init>(Landroid/view/View;Landroid/util/AttributeSet;)V
    .locals 8
    .param p1, "view"    # Landroid/view/View;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi"
        }
    .end annotation

    .prologue
    const/4 v7, -0x1

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 93
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    iput v3, p0, Lcom/aio/downloader/views/MaterialStyle;->STATUS_NORMAL:I

    .line 25
    iput v4, p0, Lcom/aio/downloader/views/MaterialStyle;->STATUS_ANIM_FAST:I

    .line 27
    iput v5, p0, Lcom/aio/downloader/views/MaterialStyle;->STATUS_ANIM_SLOWLY:I

    .line 29
    iput v6, p0, Lcom/aio/downloader/views/MaterialStyle;->STATUS_PRESSED:I

    .line 31
    const/4 v1, 0x4

    iput v1, p0, Lcom/aio/downloader/views/MaterialStyle;->STATUS_TO_NORMAL:I

    .line 32
    iput v3, p0, Lcom/aio/downloader/views/MaterialStyle;->status:I

    .line 34
    iput v3, p0, Lcom/aio/downloader/views/MaterialStyle;->SHAPE_MODE_EQUAL:I

    .line 35
    iput v4, p0, Lcom/aio/downloader/views/MaterialStyle;->SHAPE_MODE_WIDTH:I

    .line 36
    iput v5, p0, Lcom/aio/downloader/views/MaterialStyle;->SHAPE_MODE_HEIGHT:I

    .line 37
    iput v3, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimMode:I

    .line 39
    const/16 v1, 0x7d

    iput v1, p0, Lcom/aio/downloader/views/MaterialStyle;->ANIM_FAST_TIME:I

    .line 40
    const/16 v1, 0xc8

    iput v1, p0, Lcom/aio/downloader/views/MaterialStyle;->ANIM_SLOW_TIME:I

    .line 41
    const/16 v1, 0xa

    iput v1, p0, Lcom/aio/downloader/views/MaterialStyle;->ANIM_SLEEP_TIME:I

    .line 46
    iput v3, p0, Lcom/aio/downloader/views/MaterialStyle;->mBackgroundColor:I

    .line 47
    iput v3, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimColorAlpha:I

    .line 48
    const/16 v1, 0xf

    iput v1, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimColorAlphaMax:I

    .line 53
    new-instance v1, Landroid/graphics/Path;

    invoke-direct {v1}, Landroid/graphics/Path;-><init>()V

    iput-object v1, p0, Lcom/aio/downloader/views/MaterialStyle;->mPath:Landroid/graphics/Path;

    .line 55
    new-instance v1, Landroid/graphics/Paint;

    invoke-direct {v1}, Landroid/graphics/Paint;-><init>()V

    iput-object v1, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimBottomPaint:Landroid/graphics/Paint;

    .line 57
    new-instance v1, Landroid/graphics/Paint;

    invoke-direct {v1}, Landroid/graphics/Paint;-><init>()V

    iput-object v1, p0, Lcom/aio/downloader/views/MaterialStyle;->mCirclePaint:Landroid/graphics/Paint;

    .line 82
    iput v7, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimFullColor:I

    .line 84
    new-instance v1, Landroid/graphics/PaintFlagsDrawFilter;

    .line 85
    invoke-direct {v1, v3, v6}, Landroid/graphics/PaintFlagsDrawFilter;-><init>(II)V

    iput-object v1, p0, Lcom/aio/downloader/views/MaterialStyle;->drawFilter:Landroid/graphics/PaintFlagsDrawFilter;

    .line 87
    iput v3, p0, Lcom/aio/downloader/views/MaterialStyle;->type:I

    .line 88
    iput-boolean v4, p0, Lcom/aio/downloader/views/MaterialStyle;->mNeedDelayClick:Z

    .line 421
    iput-boolean v3, p0, Lcom/aio/downloader/views/MaterialStyle;->hasClick:Z

    move-object v1, p1

    .line 94
    check-cast v1, Lcom/aio/downloader/views/IMaterial;

    iput-object v1, p0, Lcom/aio/downloader/views/MaterialStyle;->mCallBack:Lcom/aio/downloader/views/IMaterial;

    .line 95
    iput-object p1, p0, Lcom/aio/downloader/views/MaterialStyle;->mDependView:Landroid/view/View;

    .line 96
    invoke-virtual {p1, v4}, Landroid/view/View;->setClickable(Z)V

    .line 97
    invoke-virtual {p0, v3}, Lcom/aio/downloader/views/MaterialStyle;->setBackgroundColor(I)V

    .line 98
    const/16 v1, 0x14

    iput v1, p0, Lcom/aio/downloader/views/MaterialStyle;->animSlowTimes:I

    .line 99
    iget v1, p0, Lcom/aio/downloader/views/MaterialStyle;->ANIM_FAST_TIME:I

    div-int/lit8 v1, v1, 0xa

    iput v1, p0, Lcom/aio/downloader/views/MaterialStyle;->animFastTimes:I

    .line 100
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0xb

    if-lt v1, v2, :cond_0

    .line 101
    const/4 v1, 0x0

    invoke-virtual {p1, v4, v1}, Landroid/view/View;->setLayerType(ILandroid/graphics/Paint;)V

    .line 103
    :cond_0
    invoke-virtual {p1, v3}, Landroid/view/View;->setWillNotDraw(Z)V

    .line 104
    if-eqz p2, :cond_2

    .line 105
    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v1

    .line 106
    sget-object v2, Lcom/aio/downloader/R$styleable;->LButtonStyle:[I

    .line 105
    invoke-virtual {v1, p2, v2}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 107
    .local v0, "a":Landroid/content/res/TypedArray;
    invoke-virtual {v0, v5, v4}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v1

    iput-boolean v1, p0, Lcom/aio/downloader/views/MaterialStyle;->mNeedDelayClick:Z

    .line 109
    invoke-virtual {v0, v3, v7}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v1

    iput v1, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimFullColor:I

    .line 112
    invoke-virtual {v0, v4}, Landroid/content/res/TypedArray;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    .line 111
    iput-object v1, p0, Lcom/aio/downloader/views/MaterialStyle;->mBackgroundDrawable:Landroid/graphics/drawable/Drawable;

    .line 113
    iget-object v1, p0, Lcom/aio/downloader/views/MaterialStyle;->mBackgroundDrawable:Landroid/graphics/drawable/Drawable;

    if-eqz v1, :cond_1

    .line 114
    iget-object v1, p0, Lcom/aio/downloader/views/MaterialStyle;->mBackgroundDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v1}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v1

    iput v1, p0, Lcom/aio/downloader/views/MaterialStyle;->mBackgroundWidth:I

    .line 115
    iget-object v1, p0, Lcom/aio/downloader/views/MaterialStyle;->mBackgroundDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v1}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v1

    iput v1, p0, Lcom/aio/downloader/views/MaterialStyle;->mBackgroundHeight:I

    .line 119
    :cond_1
    invoke-virtual {v0, v6, v3}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v1

    iput v1, p0, Lcom/aio/downloader/views/MaterialStyle;->type:I

    .line 120
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 122
    .end local v0    # "a":Landroid/content/res/TypedArray;
    :cond_2
    return-void
.end method

.method private getHeight()I
    .locals 1

    .prologue
    .line 217
    iget-object v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mDependView:Landroid/view/View;

    if-nez v0, :cond_0

    .line 218
    const/4 v0, 0x0

    .line 219
    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mDependView:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getHeight()I

    move-result v0

    goto :goto_0
.end method

.method private getWidth()I
    .locals 1

    .prologue
    .line 211
    iget-object v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mDependView:Landroid/view/View;

    if-nez v0, :cond_0

    .line 212
    const/4 v0, 0x0

    .line 213
    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mDependView:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getWidth()I

    move-result v0

    goto :goto_0
.end method

.method private init()V
    .locals 9

    .prologue
    const/4 v3, 0x0

    const/high16 v8, 0x40800000    # 4.0f

    const/4 v5, 0x0

    const/4 v7, -0x1

    const/high16 v6, 0x40000000    # 2.0f

    .line 136
    iget-object v4, p0, Lcom/aio/downloader/views/MaterialStyle;->mDependView:Landroid/view/View;

    invoke-virtual {v4}, Landroid/view/View;->getWidth()I

    move-result v4

    int-to-float v2, v4

    .line 137
    .local v2, "width":F
    iget-object v4, p0, Lcom/aio/downloader/views/MaterialStyle;->mDependView:Landroid/view/View;

    invoke-virtual {v4}, Landroid/view/View;->getHeight()I

    move-result v4

    int-to-float v0, v4

    .line 138
    .local v0, "heigh":F
    cmpg-float v4, v2, v5

    if-lez v4, :cond_0

    cmpg-float v4, v0, v5

    if-gtz v4, :cond_1

    .line 181
    :cond_0
    :goto_0
    return-void

    .line 141
    :cond_1
    invoke-static {v2, v0}, Ljava/lang/Math;->min(FF)F

    move-result v4

    invoke-static {v2, v0}, Ljava/lang/Math;->max(FF)F

    move-result v5

    div-float/2addr v4, v5

    const v5, 0x3f4ccccd    # 0.8f

    cmpl-float v4, v4, v5

    if-lez v4, :cond_3

    const/4 v1, 0x1

    .line 142
    .local v1, "inNormalSize":Z
    :goto_1
    if-eqz v1, :cond_4

    .line 143
    iput v3, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimMode:I

    .line 149
    :goto_2
    iget v3, p0, Lcom/aio/downloader/views/MaterialStyle;->type:I

    packed-switch v3, :pswitch_data_0

    .line 178
    :cond_2
    :goto_3
    iget v3, p0, Lcom/aio/downloader/views/MaterialStyle;->mCircleRadiusMax:F

    iget v4, p0, Lcom/aio/downloader/views/MaterialStyle;->mCircleRadius:F

    sub-float/2addr v3, v4

    iget v4, p0, Lcom/aio/downloader/views/MaterialStyle;->animSlowTimes:I

    int-to-float v4, v4

    div-float/2addr v3, v4

    iput v3, p0, Lcom/aio/downloader/views/MaterialStyle;->mCirRSpeedSlow:F

    .line 179
    iget v3, p0, Lcom/aio/downloader/views/MaterialStyle;->mCircleRadiusMax:F

    iget v4, p0, Lcom/aio/downloader/views/MaterialStyle;->mCircleRadius:F

    sub-float/2addr v3, v4

    iget v4, p0, Lcom/aio/downloader/views/MaterialStyle;->animFastTimes:I

    int-to-float v4, v4

    div-float/2addr v3, v4

    iput v3, p0, Lcom/aio/downloader/views/MaterialStyle;->mCirRSpeedFast:F

    .line 180
    invoke-direct {p0}, Lcom/aio/downloader/views/MaterialStyle;->initColorInfo()V

    goto :goto_0

    .end local v1    # "inNormalSize":Z
    :cond_3
    move v1, v3

    .line 141
    goto :goto_1

    .line 144
    .restart local v1    # "inNormalSize":Z
    :cond_4
    cmpl-float v3, v2, v0

    if-lez v3, :cond_5

    .line 145
    const/4 v3, 0x1

    iput v3, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimMode:I

    goto :goto_2

    .line 147
    :cond_5
    const/4 v3, 0x2

    iput v3, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimMode:I

    goto :goto_2

    .line 152
    :pswitch_0
    div-float v3, v0, v6

    iput v3, p0, Lcom/aio/downloader/views/MaterialStyle;->mCircleRadius:F

    .line 153
    iput v2, p0, Lcom/aio/downloader/views/MaterialStyle;->mCircleRadiusMax:F

    .line 154
    iget v3, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimFullColor:I

    if-ne v3, v7, :cond_2

    .line 155
    const v3, 0x30ffffff

    iput v3, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimFullColor:I

    goto :goto_3

    .line 159
    :pswitch_1
    invoke-static {v2, v0}, Ljava/lang/Math;->min(FF)F

    move-result v3

    div-float/2addr v3, v8

    iput v3, p0, Lcom/aio/downloader/views/MaterialStyle;->mCircleRadius:F

    .line 160
    iget v3, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimMode:I

    if-nez v3, :cond_6

    .line 162
    invoke-static {v2, v0}, Ljava/lang/Math;->min(FF)F

    move-result v3

    div-float/2addr v3, v6

    iput v3, p0, Lcom/aio/downloader/views/MaterialStyle;->mCircleRadiusMax:F

    .line 166
    :goto_4
    iget v3, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimFullColor:I

    if-ne v3, v7, :cond_2

    .line 167
    const/high16 v3, 0x30000000

    iput v3, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimFullColor:I

    goto :goto_3

    .line 164
    :cond_6
    invoke-static {v2, v0}, Ljava/lang/Math;->max(FF)F

    move-result v3

    div-float/2addr v3, v6

    iput v3, p0, Lcom/aio/downloader/views/MaterialStyle;->mCircleRadiusMax:F

    goto :goto_4

    .line 171
    :pswitch_2
    invoke-static {v2, v0}, Ljava/lang/Math;->min(FF)F

    move-result v3

    div-float/2addr v3, v8

    iput v3, p0, Lcom/aio/downloader/views/MaterialStyle;->mCircleRadius:F

    .line 172
    invoke-static {v2, v0}, Ljava/lang/Math;->max(FF)F

    move-result v3

    div-float/2addr v3, v6

    iput v3, p0, Lcom/aio/downloader/views/MaterialStyle;->mCircleRadiusMax:F

    .line 173
    iget v3, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimFullColor:I

    if-ne v3, v7, :cond_2

    .line 174
    const v3, 0x30ffffff

    iput v3, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimFullColor:I

    goto :goto_3

    .line 149
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_0
        :pswitch_0
        :pswitch_2
    .end packed-switch
.end method

.method private initColorInfo()V
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 185
    iget-object v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimBottomPaint:Landroid/graphics/Paint;

    iget v1, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimFullColor:I

    invoke-static {v1}, Landroid/graphics/Color;->red(I)I

    move-result v1

    .line 186
    iget v2, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimFullColor:I

    invoke-static {v2}, Landroid/graphics/Color;->green(I)I

    move-result v2

    iget v3, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimFullColor:I

    invoke-static {v3}, Landroid/graphics/Color;->blue(I)I

    move-result v3

    .line 185
    invoke-static {v1, v2, v3}, Landroid/graphics/Color;->rgb(III)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 187
    iget v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimFullColor:I

    invoke-static {v0}, Landroid/graphics/Color;->alpha(I)I

    move-result v0

    iput v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimColorAlphaMax:I

    .line 188
    iget-object v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mCirclePaint:Landroid/graphics/Paint;

    iget v1, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimFullColor:I

    invoke-static {v1}, Landroid/graphics/Color;->red(I)I

    move-result v1

    .line 189
    iget v2, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimFullColor:I

    invoke-static {v2}, Landroid/graphics/Color;->green(I)I

    move-result v2

    iget v3, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimFullColor:I

    invoke-static {v3}, Landroid/graphics/Color;->blue(I)I

    move-result v3

    .line 188
    invoke-static {v1, v2, v3}, Landroid/graphics/Color;->rgb(III)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 190
    iget-object v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mCirclePaint:Landroid/graphics/Paint;

    iget v1, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimColorAlphaMax:I

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setAlpha(I)V

    .line 198
    iget-object v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimBottomPaint:Landroid/graphics/Paint;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setAlpha(I)V

    .line 199
    iget v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimColorAlphaMax:I

    iget v1, p0, Lcom/aio/downloader/views/MaterialStyle;->animSlowTimes:I

    div-int/2addr v0, v1

    iput v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimColorAlphaSlowSpeed:I

    .line 200
    iget v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimColorAlphaMax:I

    iget v1, p0, Lcom/aio/downloader/views/MaterialStyle;->animFastTimes:I

    div-int/2addr v0, v1

    iput v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimColorAlphaFastSpeed:I

    .line 201
    iget v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimColorAlphaSlowSpeed:I

    if-ge v0, v4, :cond_0

    .line 202
    iput v4, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimColorAlphaSlowSpeed:I

    .line 204
    :cond_0
    iget v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimColorAlphaFastSpeed:I

    if-ge v0, v4, :cond_1

    .line 205
    iput v4, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimColorAlphaFastSpeed:I

    .line 207
    :cond_1
    iget v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimColorAlphaFastSpeed:I

    iput v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimColorAlphaToNormalSpeed:I

    .line 208
    return-void
.end method

.method private move()V
    .locals 2

    .prologue
    .line 364
    iget v0, p0, Lcom/aio/downloader/views/MaterialStyle;->status:I

    if-eqz v0, :cond_0

    iget v0, p0, Lcom/aio/downloader/views/MaterialStyle;->status:I

    const/4 v1, 0x3

    if-ne v0, v1, :cond_1

    .line 392
    :cond_0
    :goto_0
    return-void

    .line 366
    :cond_1
    iget v0, p0, Lcom/aio/downloader/views/MaterialStyle;->status:I

    const/4 v1, 0x2

    if-ne v0, v1, :cond_8

    .line 367
    iget v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimColorAlpha:I

    iget v1, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimColorAlphaSlowSpeed:I

    add-int/2addr v0, v1

    iput v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimColorAlpha:I

    .line 368
    iget v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mCircleRadius:F

    iget v1, p0, Lcom/aio/downloader/views/MaterialStyle;->mCirRSpeedSlow:F

    add-float/2addr v0, v1

    iput v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mCircleRadius:F

    .line 376
    :cond_2
    :goto_1
    iget v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimColorAlpha:I

    iget v1, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimColorAlphaMax:I

    if-lt v0, v1, :cond_3

    .line 377
    iget v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimColorAlphaMax:I

    iput v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimColorAlpha:I

    .line 379
    :cond_3
    iget v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimColorAlpha:I

    if-gez v0, :cond_4

    .line 380
    const/4 v0, 0x0

    iput v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimColorAlpha:I

    .line 382
    :cond_4
    iget-object v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimBottomPaint:Landroid/graphics/Paint;

    iget v1, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimColorAlpha:I

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setAlpha(I)V

    .line 385
    iget v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mCircleRadius:F

    iget v1, p0, Lcom/aio/downloader/views/MaterialStyle;->mCircleRadiusMax:F

    cmpl-float v0, v0, v1

    if-lez v0, :cond_5

    .line 386
    iget v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mCircleRadiusMax:F

    iput v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mCircleRadius:F

    .line 388
    :cond_5
    iget v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimColorAlpha:I

    if-lez v0, :cond_6

    iget v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimColorAlpha:I

    iget v1, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimColorAlphaMax:I

    if-lt v0, v1, :cond_7

    .line 389
    :cond_6
    invoke-direct {p0}, Lcom/aio/downloader/views/MaterialStyle;->reset()V

    .line 391
    :cond_7
    iget-object v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mDependView:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->invalidate()V

    goto :goto_0

    .line 369
    :cond_8
    iget v0, p0, Lcom/aio/downloader/views/MaterialStyle;->status:I

    const/4 v1, 0x1

    if-ne v0, v1, :cond_9

    .line 370
    iget v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimColorAlpha:I

    iget v1, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimColorAlphaFastSpeed:I

    add-int/2addr v0, v1

    iput v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimColorAlpha:I

    .line 371
    iget v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mCircleRadius:F

    iget v1, p0, Lcom/aio/downloader/views/MaterialStyle;->mCirRSpeedFast:F

    add-float/2addr v0, v1

    iput v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mCircleRadius:F

    goto :goto_1

    .line 372
    :cond_9
    iget v0, p0, Lcom/aio/downloader/views/MaterialStyle;->status:I

    const/4 v1, 0x4

    if-ne v0, v1, :cond_2

    .line 373
    iget v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimColorAlpha:I

    iget v1, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimColorAlphaToNormalSpeed:I

    sub-int/2addr v0, v1

    iput v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimColorAlpha:I

    .line 374
    iget v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mCircleRadiusMax:F

    iput v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mCircleRadius:F

    goto :goto_1
.end method

.method private reset()V
    .locals 2

    .prologue
    .line 395
    iget v0, p0, Lcom/aio/downloader/views/MaterialStyle;->status:I

    packed-switch v0, :pswitch_data_0

    .line 418
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mDependView:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->invalidate()V

    .line 419
    return-void

    .line 398
    :pswitch_0
    iget v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mCircleRadiusMax:F

    iput v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mCircleRadius:F

    .line 399
    const/4 v0, 0x4

    iput v0, p0, Lcom/aio/downloader/views/MaterialStyle;->status:I

    goto :goto_0

    .line 402
    :pswitch_1
    const/4 v0, 0x3

    iput v0, p0, Lcom/aio/downloader/views/MaterialStyle;->status:I

    .line 403
    iget v0, p0, Lcom/aio/downloader/views/MaterialStyle;->type:I

    const/4 v1, 0x1

    if-eq v0, v1, :cond_1

    iget v0, p0, Lcom/aio/downloader/views/MaterialStyle;->type:I

    const/4 v1, 0x2

    if-ne v0, v1, :cond_0

    .line 404
    :cond_1
    invoke-direct {p0}, Lcom/aio/downloader/views/MaterialStyle;->getWidth()I

    move-result v0

    int-to-float v0, v0

    iput v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mCircleRadius:F

    goto :goto_0

    .line 408
    :pswitch_2
    iget-boolean v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mNeedDelayClick:Z

    if-eqz v0, :cond_3

    iget-boolean v0, p0, Lcom/aio/downloader/views/MaterialStyle;->hasClick:Z

    if-eqz v0, :cond_3

    .line 409
    iget-object v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mCallBack:Lcom/aio/downloader/views/IMaterial;

    if-eqz v0, :cond_2

    .line 410
    iget-object v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mCallBack:Lcom/aio/downloader/views/IMaterial;

    invoke-interface {v0}, Lcom/aio/downloader/views/IMaterial;->perfirmSuperClick()V

    .line 411
    :cond_2
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/aio/downloader/views/MaterialStyle;->hasClick:Z

    .line 413
    :cond_3
    invoke-virtual {p0}, Lcom/aio/downloader/views/MaterialStyle;->resetStatus()V

    goto :goto_0

    .line 395
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_0
        :pswitch_2
    .end packed-switch
.end method


# virtual methods
.method public dispatchKeyEvent()V
    .locals 0

    .prologue
    .line 448
    return-void
.end method

.method public doDraw(Landroid/graphics/Canvas;)V
    .locals 5
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    const/4 v3, 0x0

    const/4 v4, 0x0

    .line 223
    iget v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mCircleRadius:F

    cmpl-float v0, v0, v4

    if-eqz v0, :cond_0

    iget v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mCircleRadiusMax:F

    cmpl-float v0, v0, v4

    if-nez v0, :cond_1

    .line 224
    :cond_0
    invoke-direct {p0}, Lcom/aio/downloader/views/MaterialStyle;->init()V

    .line 226
    :cond_1
    iget-object v0, p0, Lcom/aio/downloader/views/MaterialStyle;->drawFilter:Landroid/graphics/PaintFlagsDrawFilter;

    invoke-virtual {p1, v0}, Landroid/graphics/Canvas;->setDrawFilter(Landroid/graphics/DrawFilter;)V

    .line 227
    invoke-virtual {p1}, Landroid/graphics/Canvas;->save()I

    .line 233
    iget-object v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mBackgroundDrawable:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_3

    .line 234
    iget-object v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mBackgroundDrawable:Landroid/graphics/drawable/Drawable;

    invoke-direct {p0}, Lcom/aio/downloader/views/MaterialStyle;->getWidth()I

    move-result v1

    invoke-direct {p0}, Lcom/aio/downloader/views/MaterialStyle;->getHeight()I

    move-result v2

    invoke-virtual {v0, v3, v3, v1, v2}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 235
    iget-object v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mBackgroundDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0, p1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 239
    :cond_2
    :goto_0
    iget v0, p0, Lcom/aio/downloader/views/MaterialStyle;->status:I

    packed-switch v0, :pswitch_data_0

    .line 359
    :goto_1
    :pswitch_0
    invoke-virtual {p1}, Landroid/graphics/Canvas;->restore()V

    .line 360
    invoke-direct {p0}, Lcom/aio/downloader/views/MaterialStyle;->move()V

    .line 361
    return-void

    .line 236
    :cond_3
    iget v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mBackgroundColor:I

    if-eqz v0, :cond_2

    .line 237
    iget v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mBackgroundColor:I

    invoke-virtual {p1, v0}, Landroid/graphics/Canvas;->drawColor(I)V

    goto :goto_0

    .line 243
    :pswitch_1
    iget v0, p0, Lcom/aio/downloader/views/MaterialStyle;->type:I

    packed-switch v0, :pswitch_data_1

    goto :goto_1

    .line 253
    :pswitch_2
    iget v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimMode:I

    if-nez v0, :cond_4

    .line 254
    invoke-direct {p0}, Lcom/aio/downloader/views/MaterialStyle;->getWidth()I

    move-result v0

    div-int/lit8 v0, v0, 0x2

    int-to-float v0, v0

    invoke-direct {p0}, Lcom/aio/downloader/views/MaterialStyle;->getHeight()I

    move-result v1

    div-int/lit8 v1, v1, 0x2

    int-to-float v1, v1

    .line 255
    invoke-direct {p0}, Lcom/aio/downloader/views/MaterialStyle;->getWidth()I

    move-result v2

    invoke-direct {p0}, Lcom/aio/downloader/views/MaterialStyle;->getHeight()I

    move-result v3

    invoke-static {v2, v3}, Ljava/lang/Math;->min(II)I

    move-result v2

    div-int/lit8 v2, v2, 0x2

    int-to-float v2, v2

    .line 256
    iget-object v3, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimBottomPaint:Landroid/graphics/Paint;

    .line 254
    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawCircle(FFFLandroid/graphics/Paint;)V

    goto :goto_1

    .line 245
    :pswitch_3
    invoke-direct {p0}, Lcom/aio/downloader/views/MaterialStyle;->getHeight()I

    move-result v0

    div-int/lit8 v0, v0, 0x2

    int-to-float v0, v0

    invoke-direct {p0}, Lcom/aio/downloader/views/MaterialStyle;->getWidth()I

    move-result v1

    int-to-float v1, v1

    .line 246
    iget-object v2, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimBottomPaint:Landroid/graphics/Paint;

    .line 245
    invoke-virtual {p1, v4, v0, v1, v2}, Landroid/graphics/Canvas;->drawCircle(FFFLandroid/graphics/Paint;)V

    goto :goto_1

    .line 249
    :pswitch_4
    invoke-direct {p0}, Lcom/aio/downloader/views/MaterialStyle;->getWidth()I

    move-result v0

    int-to-float v0, v0

    invoke-direct {p0}, Lcom/aio/downloader/views/MaterialStyle;->getHeight()I

    move-result v1

    div-int/lit8 v1, v1, 0x2

    int-to-float v1, v1

    invoke-direct {p0}, Lcom/aio/downloader/views/MaterialStyle;->getWidth()I

    move-result v2

    int-to-float v2, v2

    .line 250
    iget-object v3, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimBottomPaint:Landroid/graphics/Paint;

    .line 249
    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawCircle(FFFLandroid/graphics/Paint;)V

    goto :goto_1

    .line 258
    :cond_4
    iget-object v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimBottomPaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v0}, Landroid/graphics/Canvas;->drawPaint(Landroid/graphics/Paint;)V

    goto :goto_1

    .line 262
    :pswitch_5
    invoke-direct {p0}, Lcom/aio/downloader/views/MaterialStyle;->getWidth()I

    move-result v0

    div-int/lit8 v0, v0, 0x2

    int-to-float v0, v0

    invoke-direct {p0}, Lcom/aio/downloader/views/MaterialStyle;->getHeight()I

    move-result v1

    div-int/lit8 v1, v1, 0x2

    int-to-float v1, v1

    .line 263
    invoke-direct {p0}, Lcom/aio/downloader/views/MaterialStyle;->getWidth()I

    move-result v2

    invoke-direct {p0}, Lcom/aio/downloader/views/MaterialStyle;->getHeight()I

    move-result v3

    invoke-static {v2, v3}, Ljava/lang/Math;->max(II)I

    move-result v2

    div-int/lit8 v2, v2, 0x2

    int-to-float v2, v2

    iget-object v3, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimBottomPaint:Landroid/graphics/Paint;

    .line 262
    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawCircle(FFFLandroid/graphics/Paint;)V

    goto/16 :goto_1

    .line 269
    :pswitch_6
    iget v0, p0, Lcom/aio/downloader/views/MaterialStyle;->type:I

    packed-switch v0, :pswitch_data_2

    goto/16 :goto_1

    .line 300
    :pswitch_7
    iget-object v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mPath:Landroid/graphics/Path;

    invoke-virtual {v0}, Landroid/graphics/Path;->reset()V

    .line 301
    iget-object v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mPath:Landroid/graphics/Path;

    iget v1, p0, Lcom/aio/downloader/views/MaterialStyle;->actionDownX:F

    iget v2, p0, Lcom/aio/downloader/views/MaterialStyle;->actionDownY:F

    iget v3, p0, Lcom/aio/downloader/views/MaterialStyle;->mCircleRadius:F

    .line 302
    sget-object v4, Landroid/graphics/Path$Direction;->CCW:Landroid/graphics/Path$Direction;

    .line 301
    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/graphics/Path;->addCircle(FFFLandroid/graphics/Path$Direction;)V

    .line 303
    iget-object v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mPath:Landroid/graphics/Path;

    iget-object v1, p0, Lcom/aio/downloader/views/MaterialStyle;->mCirclePaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v0, v1}, Landroid/graphics/Canvas;->drawPath(Landroid/graphics/Path;Landroid/graphics/Paint;)V

    .line 304
    iget-object v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mPath:Landroid/graphics/Path;

    sget-object v1, Landroid/graphics/Region$Op;->XOR:Landroid/graphics/Region$Op;

    invoke-virtual {p1, v0, v1}, Landroid/graphics/Canvas;->clipPath(Landroid/graphics/Path;Landroid/graphics/Region$Op;)Z

    .line 305
    iget v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimMode:I

    if-nez v0, :cond_5

    .line 306
    invoke-direct {p0}, Lcom/aio/downloader/views/MaterialStyle;->getWidth()I

    move-result v0

    div-int/lit8 v0, v0, 0x2

    int-to-float v0, v0

    invoke-direct {p0}, Lcom/aio/downloader/views/MaterialStyle;->getHeight()I

    move-result v1

    div-int/lit8 v1, v1, 0x2

    int-to-float v1, v1

    .line 307
    iget v2, p0, Lcom/aio/downloader/views/MaterialStyle;->mCircleRadiusMax:F

    iget-object v3, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimBottomPaint:Landroid/graphics/Paint;

    .line 306
    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawCircle(FFFLandroid/graphics/Paint;)V

    goto/16 :goto_1

    .line 272
    :pswitch_8
    iget-object v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mPath:Landroid/graphics/Path;

    invoke-virtual {v0}, Landroid/graphics/Path;->reset()V

    .line 273
    iget-object v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mPath:Landroid/graphics/Path;

    invoke-direct {p0}, Lcom/aio/downloader/views/MaterialStyle;->getHeight()I

    move-result v1

    div-int/lit8 v1, v1, 0x2

    int-to-float v1, v1

    iget v2, p0, Lcom/aio/downloader/views/MaterialStyle;->mCircleRadius:F

    .line 274
    sget-object v3, Landroid/graphics/Path$Direction;->CCW:Landroid/graphics/Path$Direction;

    .line 273
    invoke-virtual {v0, v4, v1, v2, v3}, Landroid/graphics/Path;->addCircle(FFFLandroid/graphics/Path$Direction;)V

    .line 275
    iget-object v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mPath:Landroid/graphics/Path;

    iget-object v1, p0, Lcom/aio/downloader/views/MaterialStyle;->mCirclePaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v0, v1}, Landroid/graphics/Canvas;->drawPath(Landroid/graphics/Path;Landroid/graphics/Paint;)V

    .line 276
    iget-object v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mPath:Landroid/graphics/Path;

    sget-object v1, Landroid/graphics/Region$Op;->XOR:Landroid/graphics/Region$Op;

    invoke-virtual {p1, v0, v1}, Landroid/graphics/Canvas;->clipPath(Landroid/graphics/Path;Landroid/graphics/Region$Op;)Z

    .line 277
    invoke-direct {p0}, Lcom/aio/downloader/views/MaterialStyle;->getHeight()I

    move-result v0

    div-int/lit8 v0, v0, 0x2

    int-to-float v0, v0

    iget v1, p0, Lcom/aio/downloader/views/MaterialStyle;->mCircleRadiusMax:F

    .line 278
    iget-object v2, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimBottomPaint:Landroid/graphics/Paint;

    .line 277
    invoke-virtual {p1, v4, v0, v1, v2}, Landroid/graphics/Canvas;->drawCircle(FFFLandroid/graphics/Paint;)V

    goto/16 :goto_1

    .line 286
    :pswitch_9
    iget-object v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mPath:Landroid/graphics/Path;

    invoke-virtual {v0}, Landroid/graphics/Path;->reset()V

    .line 287
    iget-object v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mPath:Landroid/graphics/Path;

    invoke-direct {p0}, Lcom/aio/downloader/views/MaterialStyle;->getWidth()I

    move-result v1

    int-to-float v1, v1

    invoke-direct {p0}, Lcom/aio/downloader/views/MaterialStyle;->getHeight()I

    move-result v2

    div-int/lit8 v2, v2, 0x2

    int-to-float v2, v2

    iget v3, p0, Lcom/aio/downloader/views/MaterialStyle;->mCircleRadius:F

    .line 288
    sget-object v4, Landroid/graphics/Path$Direction;->CCW:Landroid/graphics/Path$Direction;

    .line 287
    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/graphics/Path;->addCircle(FFFLandroid/graphics/Path$Direction;)V

    .line 289
    iget-object v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mPath:Landroid/graphics/Path;

    iget-object v1, p0, Lcom/aio/downloader/views/MaterialStyle;->mCirclePaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v0, v1}, Landroid/graphics/Canvas;->drawPath(Landroid/graphics/Path;Landroid/graphics/Paint;)V

    .line 290
    iget-object v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mPath:Landroid/graphics/Path;

    sget-object v1, Landroid/graphics/Region$Op;->XOR:Landroid/graphics/Region$Op;

    invoke-virtual {p1, v0, v1}, Landroid/graphics/Canvas;->clipPath(Landroid/graphics/Path;Landroid/graphics/Region$Op;)Z

    .line 291
    invoke-direct {p0}, Lcom/aio/downloader/views/MaterialStyle;->getWidth()I

    move-result v0

    int-to-float v0, v0

    invoke-direct {p0}, Lcom/aio/downloader/views/MaterialStyle;->getHeight()I

    move-result v1

    div-int/lit8 v1, v1, 0x2

    int-to-float v1, v1

    .line 292
    iget v2, p0, Lcom/aio/downloader/views/MaterialStyle;->mCircleRadiusMax:F

    iget-object v3, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimBottomPaint:Landroid/graphics/Paint;

    .line 291
    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawCircle(FFFLandroid/graphics/Paint;)V

    goto/16 :goto_1

    .line 309
    :cond_5
    iget-object v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimBottomPaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v0}, Landroid/graphics/Canvas;->drawPaint(Landroid/graphics/Paint;)V

    goto/16 :goto_1

    .line 318
    :pswitch_a
    iget-object v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mPath:Landroid/graphics/Path;

    invoke-virtual {v0}, Landroid/graphics/Path;->reset()V

    .line 319
    iget-object v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mPath:Landroid/graphics/Path;

    invoke-direct {p0}, Lcom/aio/downloader/views/MaterialStyle;->getWidth()I

    move-result v1

    div-int/lit8 v1, v1, 0x2

    int-to-float v1, v1

    invoke-direct {p0}, Lcom/aio/downloader/views/MaterialStyle;->getHeight()I

    move-result v2

    div-int/lit8 v2, v2, 0x2

    int-to-float v2, v2

    iget v3, p0, Lcom/aio/downloader/views/MaterialStyle;->mCircleRadius:F

    .line 320
    sget-object v4, Landroid/graphics/Path$Direction;->CCW:Landroid/graphics/Path$Direction;

    .line 319
    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/graphics/Path;->addCircle(FFFLandroid/graphics/Path$Direction;)V

    .line 321
    iget-object v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mPath:Landroid/graphics/Path;

    iget-object v1, p0, Lcom/aio/downloader/views/MaterialStyle;->mCirclePaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v0, v1}, Landroid/graphics/Canvas;->drawPath(Landroid/graphics/Path;Landroid/graphics/Paint;)V

    .line 322
    iget-object v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mPath:Landroid/graphics/Path;

    sget-object v1, Landroid/graphics/Region$Op;->XOR:Landroid/graphics/Region$Op;

    invoke-virtual {p1, v0, v1}, Landroid/graphics/Canvas;->clipPath(Landroid/graphics/Path;Landroid/graphics/Region$Op;)Z

    .line 323
    invoke-direct {p0}, Lcom/aio/downloader/views/MaterialStyle;->getWidth()I

    move-result v0

    div-int/lit8 v0, v0, 0x2

    int-to-float v0, v0

    invoke-direct {p0}, Lcom/aio/downloader/views/MaterialStyle;->getHeight()I

    move-result v1

    div-int/lit8 v1, v1, 0x2

    int-to-float v1, v1

    .line 324
    iget v2, p0, Lcom/aio/downloader/views/MaterialStyle;->mCircleRadiusMax:F

    iget-object v3, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimBottomPaint:Landroid/graphics/Paint;

    .line 323
    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawCircle(FFFLandroid/graphics/Paint;)V

    goto/16 :goto_1

    .line 333
    :pswitch_b
    iget v0, p0, Lcom/aio/downloader/views/MaterialStyle;->type:I

    packed-switch v0, :pswitch_data_3

    goto/16 :goto_1

    .line 343
    :pswitch_c
    iget v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimMode:I

    if-nez v0, :cond_6

    .line 344
    invoke-direct {p0}, Lcom/aio/downloader/views/MaterialStyle;->getWidth()I

    move-result v0

    div-int/lit8 v0, v0, 0x2

    int-to-float v0, v0

    invoke-direct {p0}, Lcom/aio/downloader/views/MaterialStyle;->getHeight()I

    move-result v1

    div-int/lit8 v1, v1, 0x2

    int-to-float v1, v1

    .line 345
    iget v2, p0, Lcom/aio/downloader/views/MaterialStyle;->mCircleRadius:F

    iget-object v3, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimBottomPaint:Landroid/graphics/Paint;

    .line 344
    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawCircle(FFFLandroid/graphics/Paint;)V

    goto/16 :goto_1

    .line 335
    :pswitch_d
    invoke-direct {p0}, Lcom/aio/downloader/views/MaterialStyle;->getHeight()I

    move-result v0

    div-int/lit8 v0, v0, 0x2

    int-to-float v0, v0

    iget v1, p0, Lcom/aio/downloader/views/MaterialStyle;->mCircleRadius:F

    .line 336
    iget-object v2, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimBottomPaint:Landroid/graphics/Paint;

    .line 335
    invoke-virtual {p1, v4, v0, v1, v2}, Landroid/graphics/Canvas;->drawCircle(FFFLandroid/graphics/Paint;)V

    goto/16 :goto_1

    .line 339
    :pswitch_e
    invoke-direct {p0}, Lcom/aio/downloader/views/MaterialStyle;->getWidth()I

    move-result v0

    int-to-float v0, v0

    invoke-direct {p0}, Lcom/aio/downloader/views/MaterialStyle;->getHeight()I

    move-result v1

    div-int/lit8 v1, v1, 0x2

    int-to-float v1, v1

    iget v2, p0, Lcom/aio/downloader/views/MaterialStyle;->mCircleRadius:F

    .line 340
    iget-object v3, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimBottomPaint:Landroid/graphics/Paint;

    .line 339
    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawCircle(FFFLandroid/graphics/Paint;)V

    goto/16 :goto_1

    .line 347
    :cond_6
    iget-object v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimBottomPaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v0}, Landroid/graphics/Canvas;->drawPaint(Landroid/graphics/Paint;)V

    goto/16 :goto_1

    .line 351
    :pswitch_f
    invoke-direct {p0}, Lcom/aio/downloader/views/MaterialStyle;->getWidth()I

    move-result v0

    div-int/lit8 v0, v0, 0x2

    int-to-float v0, v0

    invoke-direct {p0}, Lcom/aio/downloader/views/MaterialStyle;->getHeight()I

    move-result v1

    div-int/lit8 v1, v1, 0x2

    int-to-float v1, v1

    .line 352
    iget v2, p0, Lcom/aio/downloader/views/MaterialStyle;->mCircleRadius:F

    iget-object v3, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimBottomPaint:Landroid/graphics/Paint;

    .line 351
    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawCircle(FFFLandroid/graphics/Paint;)V

    goto/16 :goto_1

    .line 239
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_6
        :pswitch_6
        :pswitch_1
        :pswitch_b
    .end packed-switch

    .line 243
    :pswitch_data_1
    .packed-switch 0x0
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
    .end packed-switch

    .line 269
    :pswitch_data_2
    .packed-switch 0x0
        :pswitch_7
        :pswitch_8
        :pswitch_9
        :pswitch_a
    .end packed-switch

    .line 333
    :pswitch_data_3
    .packed-switch 0x0
        :pswitch_c
        :pswitch_d
        :pswitch_e
        :pswitch_f
    .end packed-switch
.end method

.method public getMeasureSize(II)[I
    .locals 9
    .param p1, "widthMeasureSpec"    # I
    .param p2, "heightMeasureSpec"    # I

    .prologue
    const/high16 v8, 0x40000000    # 2.0f

    const/high16 v7, -0x80000000

    .line 505
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getMode(I)I

    move-result v4

    .line 506
    .local v4, "widthMode":I
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v5

    .line 507
    .local v5, "widthSize":I
    invoke-static {p2}, Landroid/view/View$MeasureSpec;->getMode(I)I

    move-result v1

    .line 508
    .local v1, "heightMode":I
    invoke-static {p2}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v2

    .line 513
    .local v2, "heightSize":I
    if-ne v4, v8, :cond_0

    .line 514
    move v3, v5

    .line 521
    .local v3, "width":I
    :goto_0
    if-ne v1, v8, :cond_2

    .line 522
    move v0, v2

    .line 528
    .local v0, "height":I
    :goto_1
    const/4 v6, 0x2

    new-array v6, v6, [I

    const/4 v7, 0x0

    aput v3, v6, v7

    const/4 v7, 0x1

    aput v0, v6, v7

    return-object v6

    .line 515
    .end local v0    # "height":I
    .end local v3    # "width":I
    :cond_0
    if-ne v4, v7, :cond_1

    .line 516
    iget v6, p0, Lcom/aio/downloader/views/MaterialStyle;->mBackgroundWidth:I

    invoke-static {v6, v5}, Ljava/lang/Math;->min(II)I

    move-result v3

    .line 517
    .restart local v3    # "width":I
    goto :goto_0

    .line 518
    .end local v3    # "width":I
    :cond_1
    iget v3, p0, Lcom/aio/downloader/views/MaterialStyle;->mBackgroundWidth:I

    .restart local v3    # "width":I
    goto :goto_0

    .line 523
    :cond_2
    if-ne v1, v7, :cond_3

    .line 524
    iget v6, p0, Lcom/aio/downloader/views/MaterialStyle;->mBackgroundHeight:I

    invoke-static {v6, v2}, Ljava/lang/Math;->min(II)I

    move-result v0

    .line 525
    .restart local v0    # "height":I
    goto :goto_1

    .line 526
    .end local v0    # "height":I
    :cond_3
    iget v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mBackgroundHeight:I

    .restart local v0    # "height":I
    goto :goto_1
.end method

.method public needBackgroundMeasure()Z
    .locals 1

    .prologue
    .line 498
    iget v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mBackgroundWidth:I

    if-lez v0, :cond_0

    iget v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mBackgroundHeight:I

    if-gtz v0, :cond_1

    .line 499
    :cond_0
    const/4 v0, 0x0

    .line 501
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)V
    .locals 4
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x2

    .line 451
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 494
    :cond_0
    :goto_0
    :pswitch_0
    iget-object v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mDependView:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->invalidate()V

    .line 495
    return-void

    .line 454
    :pswitch_1
    iget v0, p0, Lcom/aio/downloader/views/MaterialStyle;->status:I

    if-eqz v0, :cond_1

    .line 455
    invoke-virtual {p0}, Lcom/aio/downloader/views/MaterialStyle;->resetStatus()V

    .line 457
    :cond_1
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v0

    iput v0, p0, Lcom/aio/downloader/views/MaterialStyle;->actionDownX:F

    .line 458
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v0

    iput v0, p0, Lcom/aio/downloader/views/MaterialStyle;->actionDownY:F

    .line 459
    iget v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimMode:I

    packed-switch v0, :pswitch_data_1

    .line 474
    :goto_1
    iput v2, p0, Lcom/aio/downloader/views/MaterialStyle;->status:I

    goto :goto_0

    .line 461
    :pswitch_2
    invoke-direct {p0}, Lcom/aio/downloader/views/MaterialStyle;->getWidth()I

    move-result v0

    div-int/lit8 v0, v0, 0x2

    int-to-float v0, v0

    iput v0, p0, Lcom/aio/downloader/views/MaterialStyle;->actionDownX:F

    .line 462
    invoke-direct {p0}, Lcom/aio/downloader/views/MaterialStyle;->getHeight()I

    move-result v0

    div-int/lit8 v0, v0, 0x2

    int-to-float v0, v0

    iput v0, p0, Lcom/aio/downloader/views/MaterialStyle;->actionDownY:F

    goto :goto_1

    .line 465
    :pswitch_3
    invoke-direct {p0}, Lcom/aio/downloader/views/MaterialStyle;->getHeight()I

    move-result v0

    div-int/lit8 v0, v0, 0x2

    int-to-float v0, v0

    iput v0, p0, Lcom/aio/downloader/views/MaterialStyle;->actionDownY:F

    goto :goto_1

    .line 468
    :pswitch_4
    invoke-direct {p0}, Lcom/aio/downloader/views/MaterialStyle;->getWidth()I

    move-result v0

    div-int/lit8 v0, v0, 0x2

    int-to-float v0, v0

    iput v0, p0, Lcom/aio/downloader/views/MaterialStyle;->actionDownX:F

    goto :goto_1

    .line 480
    :pswitch_5
    iget v0, p0, Lcom/aio/downloader/views/MaterialStyle;->status:I

    if-ne v0, v2, :cond_2

    .line 481
    iput v3, p0, Lcom/aio/downloader/views/MaterialStyle;->status:I

    .line 484
    :cond_2
    :pswitch_6
    iget v0, p0, Lcom/aio/downloader/views/MaterialStyle;->status:I

    const/4 v1, 0x3

    if-ne v0, v1, :cond_3

    .line 485
    invoke-direct {p0}, Lcom/aio/downloader/views/MaterialStyle;->reset()V

    goto :goto_0

    .line 486
    :cond_3
    iget v0, p0, Lcom/aio/downloader/views/MaterialStyle;->status:I

    if-ne v0, v2, :cond_0

    .line 487
    iput v3, p0, Lcom/aio/downloader/views/MaterialStyle;->status:I

    goto :goto_0

    .line 451
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_6
        :pswitch_0
        :pswitch_5
        :pswitch_5
    .end packed-switch

    .line 459
    :pswitch_data_1
    .packed-switch 0x0
        :pswitch_2
        :pswitch_3
        :pswitch_4
    .end packed-switch
.end method

.method public onVisibilityChanged(Landroid/view/View;I)V
    .locals 0
    .param p1, "changedView"    # Landroid/view/View;
    .param p2, "visibility"    # I

    .prologue
    .line 560
    if-eqz p2, :cond_0

    .line 561
    invoke-virtual {p0}, Lcom/aio/downloader/views/MaterialStyle;->resetStatus()V

    .line 563
    :cond_0
    return-void
.end method

.method public onWindowFocusChanged(Z)V
    .locals 0
    .param p1, "hasWindowFocus"    # Z

    .prologue
    .line 554
    if-nez p1, :cond_0

    .line 555
    invoke-virtual {p0}, Lcom/aio/downloader/views/MaterialStyle;->resetStatus()V

    .line 557
    :cond_0
    return-void
.end method

.method public performClick()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 431
    iget v0, p0, Lcom/aio/downloader/views/MaterialStyle;->status:I

    const/4 v1, 0x4

    if-eq v0, v1, :cond_0

    .line 432
    iput v2, p0, Lcom/aio/downloader/views/MaterialStyle;->status:I

    .line 433
    :cond_0
    iget-boolean v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mNeedDelayClick:Z

    if-nez v0, :cond_2

    .line 434
    iget-object v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mCallBack:Lcom/aio/downloader/views/IMaterial;

    if-eqz v0, :cond_1

    .line 435
    iget-object v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mCallBack:Lcom/aio/downloader/views/IMaterial;

    invoke-interface {v0}, Lcom/aio/downloader/views/IMaterial;->perfirmSuperClick()V

    .line 444
    :cond_1
    :goto_0
    return-void

    .line 437
    :cond_2
    iget v0, p0, Lcom/aio/downloader/views/MaterialStyle;->status:I

    const/4 v1, 0x3

    if-ne v0, v1, :cond_3

    .line 438
    iget-object v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mCallBack:Lcom/aio/downloader/views/IMaterial;

    if-eqz v0, :cond_1

    .line 439
    iget-object v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mCallBack:Lcom/aio/downloader/views/IMaterial;

    invoke-interface {v0}, Lcom/aio/downloader/views/IMaterial;->perfirmSuperClick()V

    goto :goto_0

    .line 441
    :cond_3
    iput-boolean v2, p0, Lcom/aio/downloader/views/MaterialStyle;->hasClick:Z

    goto :goto_0
.end method

.method public resetStatus()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 424
    iput v1, p0, Lcom/aio/downloader/views/MaterialStyle;->status:I

    .line 425
    iput-boolean v1, p0, Lcom/aio/downloader/views/MaterialStyle;->hasClick:Z

    .line 426
    invoke-direct {p0}, Lcom/aio/downloader/views/MaterialStyle;->getHeight()I

    move-result v0

    div-int/lit8 v0, v0, 0x4

    int-to-float v0, v0

    iput v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mCircleRadius:F

    .line 427
    iput v1, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimColorAlpha:I

    .line 428
    return-void
.end method

.method public setBackground(Landroid/graphics/drawable/Drawable;)V
    .locals 1
    .param p1, "background"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 537
    iput-object p1, p0, Lcom/aio/downloader/views/MaterialStyle;->mBackgroundDrawable:Landroid/graphics/drawable/Drawable;

    .line 538
    const/4 v0, 0x0

    iput v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mBackgroundColor:I

    .line 539
    iget-object v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mBackgroundDrawable:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_0

    .line 540
    iget-object v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mBackgroundDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v0

    iput v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mBackgroundWidth:I

    .line 541
    iget-object v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mBackgroundDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v0

    iput v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mBackgroundHeight:I

    .line 543
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mDependView:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->requestLayout()V

    .line 544
    iget-object v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mDependView:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->invalidate()V

    .line 545
    return-void
.end method

.method public setBackgroundColor(I)V
    .locals 1
    .param p1, "color"    # I

    .prologue
    .line 549
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/aio/downloader/views/MaterialStyle;->mBackgroundDrawable:Landroid/graphics/drawable/Drawable;

    .line 550
    iput p1, p0, Lcom/aio/downloader/views/MaterialStyle;->mBackgroundColor:I

    .line 551
    return-void
.end method

.method public setColor(I)V
    .locals 0
    .param p1, "fullColor"    # I

    .prologue
    .line 125
    iput p1, p0, Lcom/aio/downloader/views/MaterialStyle;->mAnimFullColor:I

    .line 126
    invoke-direct {p0}, Lcom/aio/downloader/views/MaterialStyle;->initColorInfo()V

    .line 127
    return-void
.end method

.method public setDelayClick(Z)V
    .locals 0
    .param p1, "delayClick"    # Z

    .prologue
    .line 533
    iput-boolean p1, p0, Lcom/aio/downloader/views/MaterialStyle;->mNeedDelayClick:Z

    .line 534
    return-void
.end method

.method public setType(I)V
    .locals 0
    .param p1, "widgetType"    # I

    .prologue
    .line 130
    iput p1, p0, Lcom/aio/downloader/views/MaterialStyle;->type:I

    .line 131
    invoke-direct {p0}, Lcom/aio/downloader/views/MaterialStyle;->init()V

    .line 132
    return-void
.end method
