.class final Lcom/wishabi/flipp/widget/bq;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/ScaleGestureDetector$OnScaleGestureListener;


# instance fields
.field a:F

.field b:F

.field final synthetic c:Lcom/wishabi/flipp/widget/FlyerViewGroup;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/widget/FlyerViewGroup;)V
    .locals 0

    .prologue
    .line 183
    iput-object p1, p0, Lcom/wishabi/flipp/widget/bq;->c:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onScale(Landroid/view/ScaleGestureDetector;)Z
    .locals 12

    .prologue
    const/4 v11, 0x1

    const/4 v10, 0x0

    .line 189
    invoke-virtual {p1}, Landroid/view/ScaleGestureDetector;->getFocusX()F

    move-result v0

    .line 190
    invoke-virtual {p1}, Landroid/view/ScaleGestureDetector;->getFocusY()F

    move-result v1

    .line 192
    invoke-virtual {p1}, Landroid/view/ScaleGestureDetector;->getFocusX()F

    move-result v2

    iget-object v3, p0, Lcom/wishabi/flipp/widget/bq;->c:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-virtual {v3}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getWidth()I

    move-result v3

    int-to-float v3, v3

    div-float/2addr v2, v3

    .line 193
    invoke-virtual {p1}, Landroid/view/ScaleGestureDetector;->getFocusY()F

    move-result v3

    iget-object v4, p0, Lcom/wishabi/flipp/widget/bq;->c:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-virtual {v4}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getHeight()I

    move-result v4

    int-to-float v4, v4

    div-float/2addr v3, v4

    .line 194
    invoke-virtual {p1}, Landroid/view/ScaleGestureDetector;->getFocusX()F

    move-result v4

    iget-object v5, p0, Lcom/wishabi/flipp/widget/bq;->c:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v5}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->a(Lcom/wishabi/flipp/widget/FlyerViewGroup;)F

    move-result v5

    div-float/2addr v4, v5

    iget-object v5, p0, Lcom/wishabi/flipp/widget/bq;->c:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-virtual {v5}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getScrollX()I

    move-result v5

    int-to-float v5, v5

    add-float/2addr v4, v5

    .line 196
    invoke-virtual {p1}, Landroid/view/ScaleGestureDetector;->getFocusY()F

    move-result v5

    iget-object v6, p0, Lcom/wishabi/flipp/widget/bq;->c:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v6}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->a(Lcom/wishabi/flipp/widget/FlyerViewGroup;)F

    move-result v6

    div-float/2addr v5, v6

    iget-object v6, p0, Lcom/wishabi/flipp/widget/bq;->c:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-virtual {v6}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getScrollY()I

    move-result v6

    int-to-float v6, v6

    add-float/2addr v5, v6

    .line 199
    iget-object v6, p0, Lcom/wishabi/flipp/widget/bq;->c:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v6}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->a(Lcom/wishabi/flipp/widget/FlyerViewGroup;)F

    move-result v6

    .line 200
    iget-object v7, p0, Lcom/wishabi/flipp/widget/bq;->c:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-virtual {p1}, Landroid/view/ScaleGestureDetector;->getScaleFactor()F

    move-result v8

    iget-object v9, p0, Lcom/wishabi/flipp/widget/bq;->c:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v9}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->a(Lcom/wishabi/flipp/widget/FlyerViewGroup;)F

    move-result v9

    mul-float/2addr v8, v9

    invoke-virtual {v7, v8}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->setZoomScale(F)V

    .line 203
    iget-object v7, p0, Lcom/wishabi/flipp/widget/bq;->c:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v7}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->a(Lcom/wishabi/flipp/widget/FlyerViewGroup;)F

    move-result v7

    cmpl-float v6, v6, v7

    if-eqz v6, :cond_0

    .line 204
    iget-object v6, p0, Lcom/wishabi/flipp/widget/bq;->c:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v6}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->b(Lcom/wishabi/flipp/widget/FlyerViewGroup;)Lcom/wishabi/flipp/widget/dw;

    move-result-object v6

    invoke-virtual {v6, v11}, Lcom/wishabi/flipp/widget/dw;->setZooming(Z)V

    .line 206
    :cond_0
    iget v6, p0, Lcom/wishabi/flipp/widget/bq;->a:F

    sub-float/2addr v6, v0

    iget-object v7, p0, Lcom/wishabi/flipp/widget/bq;->c:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v7}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->a(Lcom/wishabi/flipp/widget/FlyerViewGroup;)F

    move-result v7

    div-float/2addr v6, v7

    .line 207
    iget v7, p0, Lcom/wishabi/flipp/widget/bq;->b:F

    sub-float/2addr v7, v1

    iget-object v8, p0, Lcom/wishabi/flipp/widget/bq;->c:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v8}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->a(Lcom/wishabi/flipp/widget/FlyerViewGroup;)F

    move-result v8

    div-float/2addr v7, v8

    .line 209
    add-float/2addr v4, v6

    iget-object v6, p0, Lcom/wishabi/flipp/widget/bq;->c:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-virtual {v6}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getWidth()I

    move-result v6

    int-to-float v6, v6

    mul-float/2addr v2, v6

    iget-object v6, p0, Lcom/wishabi/flipp/widget/bq;->c:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v6}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->a(Lcom/wishabi/flipp/widget/FlyerViewGroup;)F

    move-result v6

    div-float/2addr v2, v6

    sub-float v2, v4, v2

    float-to-int v2, v2

    .line 211
    add-float v4, v5, v7

    iget-object v5, p0, Lcom/wishabi/flipp/widget/bq;->c:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-virtual {v5}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getHeight()I

    move-result v5

    int-to-float v5, v5

    mul-float/2addr v3, v5

    iget-object v5, p0, Lcom/wishabi/flipp/widget/bq;->c:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v5}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->a(Lcom/wishabi/flipp/widget/FlyerViewGroup;)F

    move-result v5

    div-float/2addr v3, v5

    sub-float v3, v4, v3

    float-to-int v3, v3

    .line 213
    iget-object v4, p0, Lcom/wishabi/flipp/widget/bq;->c:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    int-to-float v2, v2

    iget-object v5, p0, Lcom/wishabi/flipp/widget/bq;->c:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v5}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->c(Lcom/wishabi/flipp/widget/FlyerViewGroup;)I

    move-result v5

    int-to-float v5, v5

    iget-object v6, p0, Lcom/wishabi/flipp/widget/bq;->c:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-virtual {v6}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getWidth()I

    move-result v6

    int-to-float v6, v6

    iget-object v7, p0, Lcom/wishabi/flipp/widget/bq;->c:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v7}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->a(Lcom/wishabi/flipp/widget/FlyerViewGroup;)F

    move-result v7

    div-float/2addr v6, v7

    sub-float/2addr v5, v6

    invoke-static {v2, v5}, Ljava/lang/Math;->min(FF)F

    move-result v2

    invoke-static {v10, v2}, Ljava/lang/Math;->max(FF)F

    move-result v2

    float-to-int v2, v2

    int-to-float v3, v3

    iget-object v5, p0, Lcom/wishabi/flipp/widget/bq;->c:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v5}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->d(Lcom/wishabi/flipp/widget/FlyerViewGroup;)I

    move-result v5

    int-to-float v5, v5

    iget-object v6, p0, Lcom/wishabi/flipp/widget/bq;->c:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-virtual {v6}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getHeight()I

    move-result v6

    int-to-float v6, v6

    iget-object v7, p0, Lcom/wishabi/flipp/widget/bq;->c:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v7}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->a(Lcom/wishabi/flipp/widget/FlyerViewGroup;)F

    move-result v7

    div-float/2addr v6, v7

    sub-float/2addr v5, v6

    invoke-static {v3, v5}, Ljava/lang/Math;->min(FF)F

    move-result v3

    invoke-static {v10, v3}, Ljava/lang/Math;->max(FF)F

    move-result v3

    float-to-int v3, v3

    invoke-virtual {v4, v2, v3}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->scrollTo(II)V

    .line 219
    iget-object v2, p0, Lcom/wishabi/flipp/widget/bq;->c:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v2}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->e(Lcom/wishabi/flipp/widget/FlyerViewGroup;)Lcom/wishabi/flipp/widget/bt;

    move-result-object v2

    if-eqz v2, :cond_1

    .line 220
    iget-object v2, p0, Lcom/wishabi/flipp/widget/bq;->c:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v2}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->e(Lcom/wishabi/flipp/widget/FlyerViewGroup;)Lcom/wishabi/flipp/widget/bt;

    move-result-object v2

    iget-object v3, p0, Lcom/wishabi/flipp/widget/bq;->c:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-interface {v2, v3}, Lcom/wishabi/flipp/widget/bt;->a(Lcom/wishabi/flipp/widget/FlyerViewGroup;)V

    .line 223
    :cond_1
    iput v0, p0, Lcom/wishabi/flipp/widget/bq;->a:F

    .line 224
    iput v1, p0, Lcom/wishabi/flipp/widget/bq;->b:F

    .line 226
    return v11
.end method

.method public final onScaleBegin(Landroid/view/ScaleGestureDetector;)Z
    .locals 1

    .prologue
    .line 231
    invoke-virtual {p1}, Landroid/view/ScaleGestureDetector;->getFocusX()F

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/widget/bq;->a:F

    .line 232
    invoke-virtual {p1}, Landroid/view/ScaleGestureDetector;->getFocusY()F

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/widget/bq;->b:F

    .line 233
    const/4 v0, 0x1

    return v0
.end method

.method public final onScaleEnd(Landroid/view/ScaleGestureDetector;)V
    .locals 2

    .prologue
    .line 238
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bq;->c:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->b(Lcom/wishabi/flipp/widget/FlyerViewGroup;)Lcom/wishabi/flipp/widget/dw;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/dw;->setZooming(Z)V

    .line 240
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bq;->c:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->e(Lcom/wishabi/flipp/widget/FlyerViewGroup;)Lcom/wishabi/flipp/widget/bt;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 241
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bq;->c:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->e(Lcom/wishabi/flipp/widget/FlyerViewGroup;)Lcom/wishabi/flipp/widget/bt;

    move-result-object v0

    invoke-interface {v0}, Lcom/wishabi/flipp/widget/bt;->a()V

    .line 243
    :cond_0
    return-void
.end method
