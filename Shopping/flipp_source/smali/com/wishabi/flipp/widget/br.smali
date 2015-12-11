.class final Lcom/wishabi/flipp/widget/br;
.super Landroid/view/GestureDetector$SimpleOnGestureListener;
.source "SourceFile"


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/widget/FlyerViewGroup;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/widget/FlyerViewGroup;)V
    .locals 0

    .prologue
    .line 250
    iput-object p1, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-direct {p0}, Landroid/view/GestureDetector$SimpleOnGestureListener;-><init>()V

    return-void
.end method


# virtual methods
.method public final onDoubleTap(Landroid/view/MotionEvent;)Z
    .locals 5

    .prologue
    .line 291
    iget-object v0, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->a(Lcom/wishabi/flipp/widget/FlyerViewGroup;)F

    move-result v0

    .line 292
    const/4 v1, 0x0

    iget-object v2, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-virtual {v2}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getWidth()I

    move-result v2

    int-to-float v2, v2

    iget-object v3, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v3}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->c(Lcom/wishabi/flipp/widget/FlyerViewGroup;)I

    move-result v3

    int-to-float v3, v3

    iget-object v4, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v4}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->a(Lcom/wishabi/flipp/widget/FlyerViewGroup;)F

    move-result v4

    mul-float/2addr v3, v4

    sub-float/2addr v2, v3

    invoke-static {v1, v2}, Ljava/lang/Math;->max(FF)F

    move-result v1

    float-to-int v1, v1

    div-int/lit8 v1, v1, 0x2

    .line 294
    iget-object v2, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-virtual {v2}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getScrollX()I

    move-result v2

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v3

    int-to-float v1, v1

    sub-float v1, v3, v1

    div-float/2addr v1, v0

    float-to-int v1, v1

    add-int/2addr v1, v2

    .line 295
    iget-object v2, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-virtual {v2}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getScrollY()I

    move-result v2

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v3

    div-float v0, v3, v0

    float-to-int v0, v0

    add-int/2addr v0, v2

    .line 296
    iget-object v2, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v2}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->e(Lcom/wishabi/flipp/widget/FlyerViewGroup;)Lcom/wishabi/flipp/widget/bt;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 297
    iget-object v2, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v2}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->e(Lcom/wishabi/flipp/widget/FlyerViewGroup;)Lcom/wishabi/flipp/widget/bt;

    move-result-object v2

    iget-object v3, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-interface {v2, v3, v1, v0}, Lcom/wishabi/flipp/widget/bt;->a(Lcom/wishabi/flipp/widget/FlyerViewGroup;II)V

    .line 299
    :cond_0
    const/4 v0, 0x1

    return v0
.end method

.method public final onDown(Landroid/view/MotionEvent;)Z
    .locals 2

    .prologue
    const/4 v1, 0x1

    .line 253
    iget-object v0, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->f(Lcom/wishabi/flipp/widget/FlyerViewGroup;)Lcom/wishabi/flipp/widget/bp;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/bp;->a()V

    .line 254
    iget-object v0, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->g(Lcom/wishabi/flipp/widget/FlyerViewGroup;)Landroid/widget/OverScroller;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/widget/OverScroller;->forceFinished(Z)V

    .line 255
    return v1
.end method

.method public final onFling(Landroid/view/MotionEvent;Landroid/view/MotionEvent;FF)Z
    .locals 3

    .prologue
    .line 355
    iget-object v0, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->f(Lcom/wishabi/flipp/widget/FlyerViewGroup;)Lcom/wishabi/flipp/widget/bp;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/bp;->a()V

    .line 357
    iget-object v0, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    neg-float v1, p3

    float-to-int v1, v1

    neg-float v2, p4

    float-to-int v2, v2

    invoke-static {v0, v1, v2}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->a(Lcom/wishabi/flipp/widget/FlyerViewGroup;II)V

    .line 358
    const/4 v0, 0x1

    return v0
.end method

.method public final onLongPress(Landroid/view/MotionEvent;)V
    .locals 6

    .prologue
    .line 304
    iget-object v0, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->a(Lcom/wishabi/flipp/widget/FlyerViewGroup;)F

    move-result v0

    .line 305
    const/4 v1, 0x0

    iget-object v2, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-virtual {v2}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getWidth()I

    move-result v2

    int-to-float v2, v2

    iget-object v3, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v3}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->c(Lcom/wishabi/flipp/widget/FlyerViewGroup;)I

    move-result v3

    int-to-float v3, v3

    iget-object v4, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v4}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->a(Lcom/wishabi/flipp/widget/FlyerViewGroup;)F

    move-result v4

    mul-float/2addr v3, v4

    sub-float/2addr v2, v3

    invoke-static {v1, v2}, Ljava/lang/Math;->max(FF)F

    move-result v1

    float-to-int v1, v1

    div-int/lit8 v1, v1, 0x2

    .line 307
    iget-object v2, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-virtual {v2}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getScrollX()I

    move-result v2

    int-to-float v2, v2

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v3

    int-to-float v1, v1

    sub-float v1, v3, v1

    div-float/2addr v1, v0

    add-float/2addr v1, v2

    float-to-int v1, v1

    .line 308
    iget-object v2, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-virtual {v2}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getScrollY()I

    move-result v2

    int-to-float v2, v2

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v3

    div-float v0, v3, v0

    add-float/2addr v0, v2

    float-to-int v2, v0

    .line 309
    iget-object v0, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->i(Lcom/wishabi/flipp/widget/FlyerViewGroup;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/bi;

    .line 310
    int-to-float v4, v1

    int-to-float v5, v2

    invoke-virtual {v0, v4, v5}, Lcom/wishabi/flipp/widget/bi;->a(FF)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 311
    iget-object v1, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v1}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->e(Lcom/wishabi/flipp/widget/FlyerViewGroup;)Lcom/wishabi/flipp/widget/bt;

    move-result-object v1

    if-eqz v1, :cond_1

    .line 312
    iget-object v1, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v1}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->e(Lcom/wishabi/flipp/widget/FlyerViewGroup;)Lcom/wishabi/flipp/widget/bt;

    move-result-object v1

    iget-object v2, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-interface {v1, v2, v0}, Lcom/wishabi/flipp/widget/bt;->a(Lcom/wishabi/flipp/widget/FlyerViewGroup;Lcom/wishabi/flipp/widget/bi;)V

    .line 320
    :cond_1
    :goto_0
    return-void

    .line 317
    :cond_2
    iget-object v0, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->e(Lcom/wishabi/flipp/widget/FlyerViewGroup;)Lcom/wishabi/flipp/widget/bt;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 318
    iget-object v0, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->e(Lcom/wishabi/flipp/widget/FlyerViewGroup;)Lcom/wishabi/flipp/widget/bt;

    move-result-object v0

    iget-object v1, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Lcom/wishabi/flipp/widget/bt;->a(Lcom/wishabi/flipp/widget/FlyerViewGroup;Lcom/wishabi/flipp/widget/bi;)V

    goto :goto_0
.end method

.method public final onScroll(Landroid/view/MotionEvent;Landroid/view/MotionEvent;FF)Z
    .locals 8

    .prologue
    const/4 v7, 0x0

    const/4 v6, 0x1

    .line 325
    iget-object v0, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->a(Lcom/wishabi/flipp/widget/FlyerViewGroup;)F

    move-result v0

    .line 326
    iget-object v1, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-virtual {v1}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getScrollX()I

    move-result v1

    int-to-float v1, v1

    div-float v2, p3, v0

    add-float/2addr v1, v2

    float-to-int v1, v1

    .line 327
    iget-object v2, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-virtual {v2}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getScrollY()I

    move-result v2

    int-to-float v2, v2

    div-float v0, p4, v0

    add-float/2addr v0, v2

    float-to-int v0, v0

    .line 329
    if-gez v1, :cond_0

    .line 330
    iget-object v2, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v2}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->f(Lcom/wishabi/flipp/widget/FlyerViewGroup;)Lcom/wishabi/flipp/widget/bp;

    move-result-object v2

    iget-object v3, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-virtual {v3}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getWidth()I

    move-result v3

    int-to-float v3, v3

    div-float v3, p3, v3

    iget-object v4, v2, Lcom/wishabi/flipp/widget/bp;->a:Landroid/widget/EdgeEffect;

    invoke-virtual {v4, v3}, Landroid/widget/EdgeEffect;->onPull(F)V

    iput-boolean v6, v2, Lcom/wishabi/flipp/widget/bp;->e:Z

    invoke-virtual {v2}, Lcom/wishabi/flipp/widget/bp;->invalidate()V

    .line 331
    :cond_0
    int-to-float v2, v1

    iget-object v3, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v3}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->c(Lcom/wishabi/flipp/widget/FlyerViewGroup;)I

    move-result v3

    int-to-float v3, v3

    iget-object v4, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-virtual {v4}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getWidth()I

    move-result v4

    int-to-float v4, v4

    iget-object v5, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v5}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->a(Lcom/wishabi/flipp/widget/FlyerViewGroup;)F

    move-result v5

    div-float/2addr v4, v5

    sub-float/2addr v3, v4

    cmpl-float v2, v2, v3

    if-lez v2, :cond_1

    .line 332
    iget-object v2, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v2}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->f(Lcom/wishabi/flipp/widget/FlyerViewGroup;)Lcom/wishabi/flipp/widget/bp;

    move-result-object v2

    iget-object v3, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-virtual {v3}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getWidth()I

    move-result v3

    int-to-float v3, v3

    div-float v3, p3, v3

    iget-object v4, v2, Lcom/wishabi/flipp/widget/bp;->b:Landroid/widget/EdgeEffect;

    invoke-virtual {v4, v3}, Landroid/widget/EdgeEffect;->onPull(F)V

    iput-boolean v6, v2, Lcom/wishabi/flipp/widget/bp;->f:Z

    invoke-virtual {v2}, Lcom/wishabi/flipp/widget/bp;->invalidate()V

    .line 333
    :cond_1
    if-gez v0, :cond_2

    iget-object v2, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v2}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->a(Lcom/wishabi/flipp/widget/FlyerViewGroup;)F

    move-result v2

    iget-object v3, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v3}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->j(Lcom/wishabi/flipp/widget/FlyerViewGroup;)F

    move-result v3

    cmpl-float v2, v2, v3

    if-lez v2, :cond_2

    .line 334
    iget-object v2, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v2}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->f(Lcom/wishabi/flipp/widget/FlyerViewGroup;)Lcom/wishabi/flipp/widget/bp;

    move-result-object v2

    iget-object v3, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-virtual {v3}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getHeight()I

    move-result v3

    int-to-float v3, v3

    div-float v3, p4, v3

    iget-object v4, v2, Lcom/wishabi/flipp/widget/bp;->c:Landroid/widget/EdgeEffect;

    invoke-virtual {v4, v3}, Landroid/widget/EdgeEffect;->onPull(F)V

    iput-boolean v6, v2, Lcom/wishabi/flipp/widget/bp;->g:Z

    invoke-virtual {v2}, Lcom/wishabi/flipp/widget/bp;->invalidate()V

    .line 335
    :cond_2
    int-to-float v2, v0

    iget-object v3, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v3}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->d(Lcom/wishabi/flipp/widget/FlyerViewGroup;)I

    move-result v3

    int-to-float v3, v3

    iget-object v4, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-virtual {v4}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getHeight()I

    move-result v4

    int-to-float v4, v4

    iget-object v5, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v5}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->a(Lcom/wishabi/flipp/widget/FlyerViewGroup;)F

    move-result v5

    div-float/2addr v4, v5

    sub-float/2addr v3, v4

    cmpl-float v2, v2, v3

    if-lez v2, :cond_3

    iget-object v2, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v2}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->a(Lcom/wishabi/flipp/widget/FlyerViewGroup;)F

    move-result v2

    iget-object v3, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v3}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->j(Lcom/wishabi/flipp/widget/FlyerViewGroup;)F

    move-result v3

    cmpl-float v2, v2, v3

    if-lez v2, :cond_3

    .line 337
    iget-object v2, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v2}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->f(Lcom/wishabi/flipp/widget/FlyerViewGroup;)Lcom/wishabi/flipp/widget/bp;

    move-result-object v2

    iget-object v3, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-virtual {v3}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getHeight()I

    move-result v3

    int-to-float v3, v3

    div-float v3, p4, v3

    iget-object v4, v2, Lcom/wishabi/flipp/widget/bp;->d:Landroid/widget/EdgeEffect;

    invoke-virtual {v4, v3}, Landroid/widget/EdgeEffect;->onPull(F)V

    iput-boolean v6, v2, Lcom/wishabi/flipp/widget/bp;->h:Z

    invoke-virtual {v2}, Lcom/wishabi/flipp/widget/bp;->invalidate()V

    .line 339
    :cond_3
    iget-object v2, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    int-to-float v1, v1

    iget-object v3, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v3}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->c(Lcom/wishabi/flipp/widget/FlyerViewGroup;)I

    move-result v3

    int-to-float v3, v3

    iget-object v4, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-virtual {v4}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getWidth()I

    move-result v4

    int-to-float v4, v4

    iget-object v5, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v5}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->a(Lcom/wishabi/flipp/widget/FlyerViewGroup;)F

    move-result v5

    div-float/2addr v4, v5

    sub-float/2addr v3, v4

    invoke-static {v1, v3}, Ljava/lang/Math;->min(FF)F

    move-result v1

    invoke-static {v7, v1}, Ljava/lang/Math;->max(FF)F

    move-result v1

    float-to-int v1, v1

    int-to-float v0, v0

    iget-object v3, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v3}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->d(Lcom/wishabi/flipp/widget/FlyerViewGroup;)I

    move-result v3

    int-to-float v3, v3

    iget-object v4, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-virtual {v4}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getHeight()I

    move-result v4

    int-to-float v4, v4

    iget-object v5, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v5}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->a(Lcom/wishabi/flipp/widget/FlyerViewGroup;)F

    move-result v5

    div-float/2addr v4, v5

    sub-float/2addr v3, v4

    invoke-static {v0, v3}, Ljava/lang/Math;->min(FF)F

    move-result v0

    invoke-static {v7, v0}, Ljava/lang/Math;->max(FF)F

    move-result v0

    float-to-int v0, v0

    invoke-virtual {v2, v1, v0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->scrollTo(II)V

    .line 345
    iget-object v0, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->e(Lcom/wishabi/flipp/widget/FlyerViewGroup;)Lcom/wishabi/flipp/widget/bt;

    move-result-object v0

    if-eqz v0, :cond_4

    .line 346
    iget-object v0, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->e(Lcom/wishabi/flipp/widget/FlyerViewGroup;)Lcom/wishabi/flipp/widget/bt;

    move-result-object v0

    iget-object v1, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-interface {v0, v1}, Lcom/wishabi/flipp/widget/bt;->a(Lcom/wishabi/flipp/widget/FlyerViewGroup;)V

    .line 348
    :cond_4
    iget-object v0, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->k(Lcom/wishabi/flipp/widget/FlyerViewGroup;)Z

    .line 349
    return v6
.end method

.method public final onSingleTapConfirmed(Landroid/view/MotionEvent;)Z
    .locals 8

    .prologue
    const/4 v7, 0x1

    .line 260
    iget-object v0, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->a(Lcom/wishabi/flipp/widget/FlyerViewGroup;)F

    move-result v0

    .line 261
    const/4 v1, 0x0

    iget-object v2, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-virtual {v2}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getWidth()I

    move-result v2

    int-to-float v2, v2

    iget-object v3, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v3}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->c(Lcom/wishabi/flipp/widget/FlyerViewGroup;)I

    move-result v3

    int-to-float v3, v3

    iget-object v4, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v4}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->a(Lcom/wishabi/flipp/widget/FlyerViewGroup;)F

    move-result v4

    mul-float/2addr v3, v4

    sub-float/2addr v2, v3

    invoke-static {v1, v2}, Ljava/lang/Math;->max(FF)F

    move-result v1

    float-to-int v1, v1

    div-int/lit8 v1, v1, 0x2

    .line 263
    iget-object v2, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-virtual {v2}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getScrollX()I

    move-result v2

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v3

    int-to-float v1, v1

    sub-float v1, v3, v1

    div-float/2addr v1, v0

    float-to-int v1, v1

    add-int/2addr v2, v1

    .line 264
    iget-object v1, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-virtual {v1}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getScrollY()I

    move-result v1

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v3

    div-float v0, v3, v0

    float-to-int v0, v0

    add-int v3, v1, v0

    .line 267
    iget-object v0, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->h(Lcom/wishabi/flipp/widget/FlyerViewGroup;)Lcom/wishabi/flipp/widget/bn;

    move-result-object v0

    int-to-float v4, v2

    int-to-float v5, v3

    iget-object v0, v0, Lcom/wishabi/flipp/widget/bn;->e:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v6

    :cond_0
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/wishabi/flipp/widget/bj;

    iget-object v1, v1, Lcom/wishabi/flipp/widget/bj;->h:Landroid/graphics/RectF;

    invoke-virtual {v1, v4, v5}, Landroid/graphics/RectF;->contains(FF)Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Long;

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v0

    .line 268
    :goto_0
    const-wide/16 v4, 0x0

    cmp-long v4, v0, v4

    if-ltz v4, :cond_3

    .line 269
    iget-object v2, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v2}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->e(Lcom/wishabi/flipp/widget/FlyerViewGroup;)Lcom/wishabi/flipp/widget/bt;

    move-result-object v2

    if-eqz v2, :cond_1

    .line 270
    iget-object v2, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v2}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->e(Lcom/wishabi/flipp/widget/FlyerViewGroup;)Lcom/wishabi/flipp/widget/bt;

    move-result-object v2

    iget-object v3, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-interface {v2, v3, v0, v1}, Lcom/wishabi/flipp/widget/bt;->a(Lcom/wishabi/flipp/widget/FlyerViewGroup;J)V

    .line 286
    :cond_1
    :goto_1
    return v7

    .line 267
    :cond_2
    const-wide/16 v0, -0x1

    goto :goto_0

    .line 275
    :cond_3
    iget-object v0, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->i(Lcom/wishabi/flipp/widget/FlyerViewGroup;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_4
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_5

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/bi;

    .line 276
    int-to-float v4, v2

    int-to-float v5, v3

    invoke-virtual {v0, v4, v5}, Lcom/wishabi/flipp/widget/bi;->a(FF)Z

    move-result v4

    if-eqz v4, :cond_4

    .line 277
    iget-object v1, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v1}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->e(Lcom/wishabi/flipp/widget/FlyerViewGroup;)Lcom/wishabi/flipp/widget/bt;

    move-result-object v1

    if-eqz v1, :cond_1

    .line 278
    iget-object v1, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v1}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->e(Lcom/wishabi/flipp/widget/FlyerViewGroup;)Lcom/wishabi/flipp/widget/bt;

    move-result-object v1

    iget-object v2, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-interface {v1, v2, v0}, Lcom/wishabi/flipp/widget/bt;->b(Lcom/wishabi/flipp/widget/FlyerViewGroup;Lcom/wishabi/flipp/widget/bi;)V

    goto :goto_1

    .line 283
    :cond_5
    iget-object v0, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->e(Lcom/wishabi/flipp/widget/FlyerViewGroup;)Lcom/wishabi/flipp/widget/bt;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 284
    iget-object v0, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->e(Lcom/wishabi/flipp/widget/FlyerViewGroup;)Lcom/wishabi/flipp/widget/bt;

    move-result-object v0

    iget-object v1, p0, Lcom/wishabi/flipp/widget/br;->a:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Lcom/wishabi/flipp/widget/bt;->b(Lcom/wishabi/flipp/widget/FlyerViewGroup;Lcom/wishabi/flipp/widget/bi;)V

    goto :goto_1
.end method
