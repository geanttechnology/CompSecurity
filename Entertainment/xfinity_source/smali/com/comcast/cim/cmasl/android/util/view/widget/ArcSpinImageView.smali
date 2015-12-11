.class public Lcom/comcast/cim/cmasl/android/util/view/widget/ArcSpinImageView;
.super Landroid/widget/ImageView;
.source "ArcSpinImageView.java"


# static fields
.field private static final DEFAULT_BACKING_RING_COLOR:Landroid/content/res/ColorStateList;

.field private static final DEFAULT_RING_COLOR:Landroid/content/res/ColorStateList;

.field private static final STATE_ANIMATING:[I


# instance fields
.field private animating:Z

.field paint:Landroid/graphics/Paint;

.field private rectF:Landroid/graphics/RectF;

.field private ringAlpha:F

.field private ringBackingColor:Landroid/content/res/ColorStateList;

.field private ringColor:Landroid/content/res/ColorStateList;

.field private ringStrokeWidth:F

.field private sweep:I


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 18
    const/high16 v0, -0x1000000

    invoke-static {v0}, Landroid/content/res/ColorStateList;->valueOf(I)Landroid/content/res/ColorStateList;

    move-result-object v0

    sput-object v0, Lcom/comcast/cim/cmasl/android/util/view/widget/ArcSpinImageView;->DEFAULT_RING_COLOR:Landroid/content/res/ColorStateList;

    .line 19
    const/high16 v0, 0x64000000

    invoke-static {v0}, Landroid/content/res/ColorStateList;->valueOf(I)Landroid/content/res/ColorStateList;

    move-result-object v0

    sput-object v0, Lcom/comcast/cim/cmasl/android/util/view/widget/ArcSpinImageView;->DEFAULT_BACKING_RING_COLOR:Landroid/content/res/ColorStateList;

    .line 20
    const/4 v0, 0x1

    new-array v0, v0, [I

    const/4 v1, 0x0

    sget v2, Lcom/comcast/cim/cmasl/android/util/R$attr;->state_animating:I

    aput v2, v0, v1

    sput-object v0, Lcom/comcast/cim/cmasl/android/util/view/widget/ArcSpinImageView;->STATE_ANIMATING:[I

    return-void
.end method

.method private setPaintForBacking()V
    .locals 4

    .prologue
    .line 138
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ArcSpinImageView;->paint:Landroid/graphics/Paint;

    iget-object v1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ArcSpinImageView;->ringBackingColor:Landroid/content/res/ColorStateList;

    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/ArcSpinImageView;->getDrawableState()[I

    move-result-object v2

    sget v3, Lcom/comcast/cim/cmasl/android/util/R$color;->translucent_black:I

    invoke-virtual {v1, v2, v3}, Landroid/content/res/ColorStateList;->getColorForState([II)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 139
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ArcSpinImageView;->paint:Landroid/graphics/Paint;

    const/high16 v1, 0x40400000    # 3.0f

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 140
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ArcSpinImageView;->paint:Landroid/graphics/Paint;

    sget-object v1, Landroid/graphics/Paint$Style;->FILL_AND_STROKE:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 141
    return-void
.end method

.method private setPaintForRing()V
    .locals 3

    .prologue
    .line 130
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/ArcSpinImageView;->updateRingColor()V

    .line 131
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ArcSpinImageView;->paint:Landroid/graphics/Paint;

    iget v1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ArcSpinImageView;->ringStrokeWidth:F

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 132
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ArcSpinImageView;->paint:Landroid/graphics/Paint;

    iget v1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ArcSpinImageView;->ringAlpha:F

    const/high16 v2, 0x437f0000    # 255.0f

    mul-float/2addr v1, v2

    float-to-int v1, v1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setAlpha(I)V

    .line 133
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ArcSpinImageView;->paint:Landroid/graphics/Paint;

    sget-object v1, Landroid/graphics/Paint$Style;->STROKE:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 134
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ArcSpinImageView;->paint:Landroid/graphics/Paint;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    .line 135
    return-void
.end method

.method private updateRingColor()V
    .locals 4

    .prologue
    .line 188
    iget-object v1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ArcSpinImageView;->ringColor:Landroid/content/res/ColorStateList;

    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/ArcSpinImageView;->getDrawableState()[I

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/content/res/ColorStateList;->getColorForState([II)I

    move-result v0

    .line 189
    .local v0, "ringPaintColor":I
    iget-object v1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ArcSpinImageView;->paint:Landroid/graphics/Paint;

    invoke-virtual {v1, v0}, Landroid/graphics/Paint;->setColor(I)V

    .line 190
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/ArcSpinImageView;->invalidate()V

    .line 191
    return-void
.end method


# virtual methods
.method protected drawableStateChanged()V
    .locals 0

    .prologue
    .line 183
    invoke-super {p0}, Landroid/widget/ImageView;->drawableStateChanged()V

    .line 184
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/ArcSpinImageView;->updateRingColor()V

    .line 185
    return-void
.end method

.method public getRingAlpha()F
    .locals 1

    .prologue
    .line 167
    iget v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ArcSpinImageView;->ringAlpha:F

    return v0
.end method

.method public getSweep()I
    .locals 1

    .prologue
    .line 157
    iget v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ArcSpinImageView;->sweep:I

    return v0
.end method

.method public onCreateDrawableState(I)[I
    .locals 2
    .param p1, "extraSpace"    # I

    .prologue
    .line 196
    add-int/lit8 v1, p1, 0x1

    invoke-super {p0, v1}, Landroid/widget/ImageView;->onCreateDrawableState(I)[I

    move-result-object v0

    .line 197
    .local v0, "state":[I
    iget-boolean v1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ArcSpinImageView;->animating:Z

    if-eqz v1, :cond_0

    .line 198
    sget-object v1, Lcom/comcast/cim/cmasl/android/util/view/widget/ArcSpinImageView;->STATE_ANIMATING:[I

    invoke-static {v0, v1}, Lcom/comcast/cim/cmasl/android/util/view/widget/ArcSpinImageView;->mergeDrawableStates([I[I)[I

    .line 200
    :cond_0
    return-object v0
.end method

.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 6
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    const/4 v4, 0x0

    const/high16 v3, 0x40000000    # 2.0f

    .line 145
    invoke-super {p0, p1}, Landroid/widget/ImageView;->onDraw(Landroid/graphics/Canvas;)V

    .line 146
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ArcSpinImageView;->rectF:Landroid/graphics/RectF;

    iget v1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ArcSpinImageView;->ringStrokeWidth:F

    div-float/2addr v1, v3

    iput v1, v0, Landroid/graphics/RectF;->top:F

    .line 147
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ArcSpinImageView;->rectF:Landroid/graphics/RectF;

    invoke-virtual {p1}, Landroid/graphics/Canvas;->getHeight()I

    move-result v1

    int-to-float v1, v1

    iget v2, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ArcSpinImageView;->ringStrokeWidth:F

    div-float/2addr v2, v3

    sub-float/2addr v1, v2

    iput v1, v0, Landroid/graphics/RectF;->bottom:F

    .line 148
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ArcSpinImageView;->rectF:Landroid/graphics/RectF;

    iget v1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ArcSpinImageView;->ringStrokeWidth:F

    div-float/2addr v1, v3

    iput v1, v0, Landroid/graphics/RectF;->left:F

    .line 149
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ArcSpinImageView;->rectF:Landroid/graphics/RectF;

    invoke-virtual {p1}, Landroid/graphics/Canvas;->getWidth()I

    move-result v1

    int-to-float v1, v1

    iget v2, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ArcSpinImageView;->ringStrokeWidth:F

    div-float/2addr v2, v3

    sub-float/2addr v1, v2

    iput v1, v0, Landroid/graphics/RectF;->right:F

    .line 150
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/ArcSpinImageView;->setPaintForBacking()V

    .line 151
    iget-object v1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ArcSpinImageView;->rectF:Landroid/graphics/RectF;

    const/4 v2, 0x0

    const/high16 v3, 0x43b40000    # 360.0f

    iget-object v5, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ArcSpinImageView;->paint:Landroid/graphics/Paint;

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawArc(Landroid/graphics/RectF;FFZLandroid/graphics/Paint;)V

    .line 152
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/ArcSpinImageView;->setPaintForRing()V

    .line 153
    iget-object v1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ArcSpinImageView;->rectF:Landroid/graphics/RectF;

    const/high16 v2, -0x3d4c0000    # -90.0f

    iget v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ArcSpinImageView;->sweep:I

    int-to-float v3, v0

    iget-object v5, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ArcSpinImageView;->paint:Landroid/graphics/Paint;

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawArc(Landroid/graphics/RectF;FFZLandroid/graphics/Paint;)V

    .line 154
    return-void
.end method

.method public setRingAlpha(F)V
    .locals 2
    .param p1, "ringAlpha"    # F

    .prologue
    .line 171
    iput p1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ArcSpinImageView;->ringAlpha:F

    .line 172
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ArcSpinImageView;->paint:Landroid/graphics/Paint;

    const/high16 v1, 0x437f0000    # 255.0f

    mul-float/2addr v1, p1

    float-to-int v1, v1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setAlpha(I)V

    .line 173
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/ArcSpinImageView;->invalidate()V

    .line 174
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/ArcSpinImageView;->requestLayout()V

    .line 175
    return-void
.end method

.method public setRingColor(Landroid/content/res/ColorStateList;)V
    .locals 0
    .param p1, "ringColor"    # Landroid/content/res/ColorStateList;

    .prologue
    .line 178
    iput-object p1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ArcSpinImageView;->ringColor:Landroid/content/res/ColorStateList;

    .line 179
    return-void
.end method

.method public setSweep(I)V
    .locals 0
    .param p1, "sweep"    # I

    .prologue
    .line 161
    iput p1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ArcSpinImageView;->sweep:I

    .line 162
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/ArcSpinImageView;->invalidate()V

    .line 163
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/ArcSpinImageView;->requestLayout()V

    .line 164
    return-void
.end method
