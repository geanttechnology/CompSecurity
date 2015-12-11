.class final Lcom/wishabi/flipp/widget/bs;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/animation/ValueAnimator$AnimatorUpdateListener;


# instance fields
.field final synthetic a:Landroid/graphics/RectF;

.field final synthetic b:F

.field final synthetic c:Lcom/wishabi/flipp/widget/FlyerViewGroup;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/widget/FlyerViewGroup;Landroid/graphics/RectF;F)V
    .locals 0

    .prologue
    .line 617
    iput-object p1, p0, Lcom/wishabi/flipp/widget/bs;->c:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    iput-object p2, p0, Lcom/wishabi/flipp/widget/bs;->a:Landroid/graphics/RectF;

    iput p3, p0, Lcom/wishabi/flipp/widget/bs;->b:F

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onAnimationUpdate(Landroid/animation/ValueAnimator;)V
    .locals 4

    .prologue
    .line 620
    invoke-virtual {p1}, Landroid/animation/ValueAnimator;->getAnimatedFraction()F

    move-result v0

    const/high16 v1, 0x3f800000    # 1.0f

    cmpl-float v0, v0, v1

    if-ltz v0, :cond_1

    .line 621
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bs;->c:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->b(Lcom/wishabi/flipp/widget/FlyerViewGroup;)Lcom/wishabi/flipp/widget/dw;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/dw;->setZooming(Z)V

    .line 622
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bs;->c:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    iget-object v1, p0, Lcom/wishabi/flipp/widget/bs;->a:Landroid/graphics/RectF;

    iget v1, v1, Landroid/graphics/RectF;->left:F

    float-to-int v1, v1

    iget-object v2, p0, Lcom/wishabi/flipp/widget/bs;->a:Landroid/graphics/RectF;

    iget v2, v2, Landroid/graphics/RectF;->top:F

    float-to-int v2, v2

    invoke-virtual {v0, v1, v2}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->scrollTo(II)V

    .line 623
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bs;->c:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    iget v1, p0, Lcom/wishabi/flipp/widget/bs;->b:F

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->setZoomScale(F)V

    .line 625
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bs;->c:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->e(Lcom/wishabi/flipp/widget/FlyerViewGroup;)Lcom/wishabi/flipp/widget/bt;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 626
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bs;->c:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->e(Lcom/wishabi/flipp/widget/FlyerViewGroup;)Lcom/wishabi/flipp/widget/bt;

    move-result-object v0

    iget-object v1, p0, Lcom/wishabi/flipp/widget/bs;->c:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-interface {v0, v1}, Lcom/wishabi/flipp/widget/bt;->a(Lcom/wishabi/flipp/widget/FlyerViewGroup;)V

    .line 640
    :cond_0
    :goto_0
    return-void

    .line 630
    :cond_1
    invoke-virtual {p1}, Landroid/animation/ValueAnimator;->getAnimatedValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/graphics/RectF;

    .line 631
    if-eqz v0, :cond_0

    .line 634
    iget-object v1, p0, Lcom/wishabi/flipp/widget/bs;->c:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    iget v2, v0, Landroid/graphics/RectF;->left:F

    float-to-int v2, v2

    iget v3, v0, Landroid/graphics/RectF;->top:F

    float-to-int v3, v3

    invoke-virtual {v1, v2, v3}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->scrollTo(II)V

    .line 635
    iget-object v1, p0, Lcom/wishabi/flipp/widget/bs;->c:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    iget-object v2, p0, Lcom/wishabi/flipp/widget/bs;->c:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-virtual {v2}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getWidth()I

    move-result v2

    int-to-float v2, v2

    invoke-virtual {v0}, Landroid/graphics/RectF;->width()F

    move-result v3

    div-float/2addr v2, v3

    iget-object v3, p0, Lcom/wishabi/flipp/widget/bs;->c:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-virtual {v3}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getHeight()I

    move-result v3

    int-to-float v3, v3

    invoke-virtual {v0}, Landroid/graphics/RectF;->height()F

    move-result v0

    div-float v0, v3, v0

    invoke-static {v2, v0}, Ljava/lang/Math;->max(FF)F

    move-result v0

    invoke-virtual {v1, v0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->setZoomScale(F)V

    .line 638
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bs;->c:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->e(Lcom/wishabi/flipp/widget/FlyerViewGroup;)Lcom/wishabi/flipp/widget/bt;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 639
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bs;->c:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->e(Lcom/wishabi/flipp/widget/FlyerViewGroup;)Lcom/wishabi/flipp/widget/bt;

    move-result-object v0

    iget-object v1, p0, Lcom/wishabi/flipp/widget/bs;->c:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-interface {v0, v1}, Lcom/wishabi/flipp/widget/bt;->a(Lcom/wishabi/flipp/widget/FlyerViewGroup;)V

    goto :goto_0
.end method
