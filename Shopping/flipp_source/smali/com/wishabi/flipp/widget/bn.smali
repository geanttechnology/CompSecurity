.class public final Lcom/wishabi/flipp/widget/bn;
.super Landroid/view/View;
.source "SourceFile"


# instance fields
.field a:F

.field b:F

.field public c:I

.field public d:I

.field public final e:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Long;",
            "Lcom/wishabi/flipp/widget/bj;",
            ">;"
        }
    .end annotation
.end field

.field public f:Z

.field private g:F


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 24
    invoke-direct {p0, p1}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    .line 19
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/wishabi/flipp/widget/bn;->e:Ljava/util/HashMap;

    .line 25
    return-void
.end method


# virtual methods
.method public final a()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 68
    iput-boolean v4, p0, Lcom/wishabi/flipp/widget/bn;->f:Z

    .line 70
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bn;->e:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 71
    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/bj;

    iget-object v2, v0, Lcom/wishabi/flipp/widget/bj;->g:Landroid/graphics/Matrix;

    invoke-virtual {v2}, Landroid/graphics/Matrix;->reset()V

    iget-object v2, v0, Lcom/wishabi/flipp/widget/bj;->h:Landroid/graphics/RectF;

    invoke-virtual {v2}, Landroid/graphics/RectF;->setEmpty()V

    iget-object v2, v0, Lcom/wishabi/flipp/widget/bj;->i:Landroid/graphics/Rect;

    invoke-virtual {v2}, Landroid/graphics/Rect;->setEmpty()V

    iget-object v2, v0, Lcom/wishabi/flipp/widget/bj;->j:Landroid/graphics/Rect;

    invoke-virtual {v2}, Landroid/graphics/Rect;->setEmpty()V

    iput-boolean v4, v0, Lcom/wishabi/flipp/widget/bj;->l:Z

    const-wide/16 v2, -0x1

    iput-wide v2, v0, Lcom/wishabi/flipp/widget/bj;->n:J

    iput-boolean v4, v0, Lcom/wishabi/flipp/widget/bj;->m:Z

    goto :goto_0

    .line 73
    :cond_0
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/bn;->invalidate()V

    .line 74
    return-void
.end method

.method protected final onDraw(Landroid/graphics/Canvas;)V
    .locals 14

    .prologue
    const/4 v3, 0x0

    const/high16 v4, 0x3f800000    # 1.0f

    const/4 v5, 0x1

    .line 93
    invoke-super {p0, p1}, Landroid/view/View;->onDraw(Landroid/graphics/Canvas;)V

    .line 95
    iget-boolean v0, p0, Lcom/wishabi/flipp/widget/bn;->f:Z

    if-nez v0, :cond_1

    .line 113
    :cond_0
    :goto_0
    return-void

    .line 98
    :cond_1
    invoke-virtual {p1}, Landroid/graphics/Canvas;->save()I

    move-result v6

    .line 99
    iget v0, p0, Lcom/wishabi/flipp/widget/bn;->g:F

    iget v1, p0, Lcom/wishabi/flipp/widget/bn;->g:F

    invoke-virtual {p1, v0, v1}, Landroid/graphics/Canvas;->scale(FF)V

    .line 100
    iget v0, p0, Lcom/wishabi/flipp/widget/bn;->a:F

    neg-float v0, v0

    iget v1, p0, Lcom/wishabi/flipp/widget/bn;->b:F

    neg-float v1, v1

    invoke-virtual {p1, v0, v1}, Landroid/graphics/Canvas;->translate(FF)V

    .line 103
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bn;->e:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v7

    move v2, v3

    :goto_1
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_d

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 104
    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/bj;

    .line 105
    iget v1, p0, Lcom/wishabi/flipp/widget/bn;->g:F

    div-float v1, v4, v1

    iget v8, p0, Lcom/wishabi/flipp/widget/bn;->c:I

    iget v9, p0, Lcom/wishabi/flipp/widget/bn;->d:I

    iget-object v10, v0, Lcom/wishabi/flipp/widget/bj;->g:Landroid/graphics/Matrix;

    iget-object v11, v0, Lcom/wishabi/flipp/widget/bj;->b:Landroid/graphics/PointF;

    iget v11, v11, Landroid/graphics/PointF;->x:F

    neg-float v11, v11

    iget v12, v0, Lcom/wishabi/flipp/widget/bj;->c:F

    add-float/2addr v11, v12

    iget-object v12, v0, Lcom/wishabi/flipp/widget/bj;->b:Landroid/graphics/PointF;

    iget v12, v12, Landroid/graphics/PointF;->y:F

    neg-float v12, v12

    iget v13, v0, Lcom/wishabi/flipp/widget/bj;->d:F

    add-float/2addr v12, v13

    invoke-virtual {v10, v11, v12}, Landroid/graphics/Matrix;->setTranslate(FF)V

    iget-object v10, v0, Lcom/wishabi/flipp/widget/bj;->g:Landroid/graphics/Matrix;

    invoke-virtual {v10, v1, v1}, Landroid/graphics/Matrix;->postScale(FF)Z

    iget-object v1, v0, Lcom/wishabi/flipp/widget/bj;->g:Landroid/graphics/Matrix;

    iget-object v10, v0, Lcom/wishabi/flipp/widget/bj;->b:Landroid/graphics/PointF;

    iget v10, v10, Landroid/graphics/PointF;->x:F

    iget-object v11, v0, Lcom/wishabi/flipp/widget/bj;->b:Landroid/graphics/PointF;

    iget v11, v11, Landroid/graphics/PointF;->y:F

    invoke-virtual {v1, v10, v11}, Landroid/graphics/Matrix;->postTranslate(FF)Z

    iget-object v1, v0, Lcom/wishabi/flipp/widget/bj;->g:Landroid/graphics/Matrix;

    iget-object v10, v0, Lcom/wishabi/flipp/widget/bj;->h:Landroid/graphics/RectF;

    iget-object v11, v0, Lcom/wishabi/flipp/widget/bj;->f:Landroid/graphics/RectF;

    invoke-virtual {v1, v10, v11}, Landroid/graphics/Matrix;->mapRect(Landroid/graphics/RectF;Landroid/graphics/RectF;)Z

    iget-object v1, v0, Lcom/wishabi/flipp/widget/bj;->i:Landroid/graphics/Rect;

    iget-object v10, v0, Lcom/wishabi/flipp/widget/bj;->h:Landroid/graphics/RectF;

    iget v10, v10, Landroid/graphics/RectF;->left:F

    float-to-int v10, v10

    iget-object v11, v0, Lcom/wishabi/flipp/widget/bj;->h:Landroid/graphics/RectF;

    iget v11, v11, Landroid/graphics/RectF;->top:F

    float-to-int v11, v11

    iget-object v12, v0, Lcom/wishabi/flipp/widget/bj;->h:Landroid/graphics/RectF;

    iget v12, v12, Landroid/graphics/RectF;->right:F

    float-to-int v12, v12

    iget-object v13, v0, Lcom/wishabi/flipp/widget/bj;->h:Landroid/graphics/RectF;

    iget v13, v13, Landroid/graphics/RectF;->bottom:F

    float-to-int v13, v13

    invoke-virtual {v1, v10, v11, v12, v13}, Landroid/graphics/Rect;->set(IIII)V

    iget-object v1, v0, Lcom/wishabi/flipp/widget/bj;->j:Landroid/graphics/Rect;

    invoke-virtual {p1, v1}, Landroid/graphics/Canvas;->getClipBounds(Landroid/graphics/Rect;)Z

    iget-boolean v1, v0, Lcom/wishabi/flipp/widget/bj;->l:Z

    if-nez v1, :cond_2

    iget-boolean v1, v0, Lcom/wishabi/flipp/widget/bj;->o:Z

    if-eqz v1, :cond_5

    :cond_2
    iget-object v1, v0, Lcom/wishabi/flipp/widget/bj;->j:Landroid/graphics/Rect;

    iget-object v8, v0, Lcom/wishabi/flipp/widget/bj;->i:Landroid/graphics/Rect;

    iget v8, v8, Landroid/graphics/Rect;->left:I

    iget-object v9, v0, Lcom/wishabi/flipp/widget/bj;->i:Landroid/graphics/Rect;

    iget v9, v9, Landroid/graphics/Rect;->top:I

    iget-object v10, v0, Lcom/wishabi/flipp/widget/bj;->i:Landroid/graphics/Rect;

    iget v10, v10, Landroid/graphics/Rect;->right:I

    iget-object v11, v0, Lcom/wishabi/flipp/widget/bj;->i:Landroid/graphics/Rect;

    iget v11, v11, Landroid/graphics/Rect;->bottom:I

    invoke-virtual {v1, v8, v9, v10, v11}, Landroid/graphics/Rect;->intersects(IIII)Z

    move-result v1

    if-nez v1, :cond_7

    :cond_3
    move v0, v3

    :goto_2
    if-nez v0, :cond_4

    if-eqz v2, :cond_c

    :cond_4
    move v0, v5

    :goto_3
    move v2, v0

    .line 107
    goto/16 :goto_1

    .line 105
    :cond_5
    iget-object v1, v0, Lcom/wishabi/flipp/widget/bj;->i:Landroid/graphics/Rect;

    iget v1, v1, Landroid/graphics/Rect;->left:I

    if-ltz v1, :cond_6

    iget-object v1, v0, Lcom/wishabi/flipp/widget/bj;->i:Landroid/graphics/Rect;

    iget v1, v1, Landroid/graphics/Rect;->top:I

    if-ltz v1, :cond_6

    iget-object v1, v0, Lcom/wishabi/flipp/widget/bj;->i:Landroid/graphics/Rect;

    iget v1, v1, Landroid/graphics/Rect;->right:I

    if-gt v1, v8, :cond_6

    iget-object v1, v0, Lcom/wishabi/flipp/widget/bj;->i:Landroid/graphics/Rect;

    iget v1, v1, Landroid/graphics/Rect;->bottom:I

    if-le v1, v9, :cond_9

    :cond_6
    iget-object v1, v0, Lcom/wishabi/flipp/widget/bj;->j:Landroid/graphics/Rect;

    iget-object v8, v0, Lcom/wishabi/flipp/widget/bj;->i:Landroid/graphics/Rect;

    iget v8, v8, Landroid/graphics/Rect;->left:I

    iget-object v9, v0, Lcom/wishabi/flipp/widget/bj;->i:Landroid/graphics/Rect;

    iget v9, v9, Landroid/graphics/Rect;->top:I

    iget-object v10, v0, Lcom/wishabi/flipp/widget/bj;->i:Landroid/graphics/Rect;

    iget v10, v10, Landroid/graphics/Rect;->right:I

    iget-object v11, v0, Lcom/wishabi/flipp/widget/bj;->i:Landroid/graphics/Rect;

    iget v11, v11, Landroid/graphics/Rect;->bottom:I

    invoke-virtual {v1, v8, v9, v10, v11}, Landroid/graphics/Rect;->intersects(IIII)Z

    move-result v1

    if-eqz v1, :cond_3

    :cond_7
    :goto_4
    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v8

    const-wide/32 v10, 0xf4240

    div-long/2addr v8, v10

    iget-boolean v1, v0, Lcom/wishabi/flipp/widget/bj;->l:Z

    if-nez v1, :cond_8

    iput-boolean v5, v0, Lcom/wishabi/flipp/widget/bj;->l:Z

    iput-wide v8, v0, Lcom/wishabi/flipp/widget/bj;->n:J

    iput-boolean v5, v0, Lcom/wishabi/flipp/widget/bj;->o:Z

    :cond_8
    iget-boolean v1, v0, Lcom/wishabi/flipp/widget/bj;->m:Z

    if-eqz v1, :cond_a

    iget-object v1, v0, Lcom/wishabi/flipp/widget/bj;->a:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    :goto_5
    iget-object v8, v0, Lcom/wishabi/flipp/widget/bj;->a:Ljava/util/List;

    invoke-interface {v8, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/graphics/drawable/Drawable;

    iget-object v8, v0, Lcom/wishabi/flipp/widget/bj;->i:Landroid/graphics/Rect;

    invoke-virtual {v1, v8}, Landroid/graphics/drawable/Drawable;->setBounds(Landroid/graphics/Rect;)V

    invoke-virtual {v1, p1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    iget-boolean v0, v0, Lcom/wishabi/flipp/widget/bj;->m:Z

    if-nez v0, :cond_3

    move v0, v5

    goto :goto_2

    :cond_9
    iget-object v1, v0, Lcom/wishabi/flipp/widget/bj;->j:Landroid/graphics/Rect;

    iget-object v8, v0, Lcom/wishabi/flipp/widget/bj;->i:Landroid/graphics/Rect;

    invoke-virtual {v1, v8}, Landroid/graphics/Rect;->contains(Landroid/graphics/Rect;)Z

    move-result v1

    if-nez v1, :cond_7

    iget-object v1, v0, Lcom/wishabi/flipp/widget/bj;->j:Landroid/graphics/Rect;

    invoke-virtual {v1}, Landroid/graphics/Rect;->width()I

    move-result v1

    iget-object v8, v0, Lcom/wishabi/flipp/widget/bj;->i:Landroid/graphics/Rect;

    invoke-virtual {v8}, Landroid/graphics/Rect;->width()I

    move-result v8

    if-lt v1, v8, :cond_7

    iget-object v1, v0, Lcom/wishabi/flipp/widget/bj;->j:Landroid/graphics/Rect;

    invoke-virtual {v1}, Landroid/graphics/Rect;->height()I

    move-result v1

    iget-object v8, v0, Lcom/wishabi/flipp/widget/bj;->i:Landroid/graphics/Rect;

    invoke-virtual {v8}, Landroid/graphics/Rect;->height()I

    move-result v8

    if-ge v1, v8, :cond_3

    goto :goto_4

    :cond_a
    iget-wide v10, v0, Lcom/wishabi/flipp/widget/bj;->n:J

    sub-long/2addr v8, v10

    long-to-float v1, v8

    iget-wide v8, v0, Lcom/wishabi/flipp/widget/bj;->k:J

    long-to-float v8, v8

    div-float/2addr v1, v8

    cmpl-float v8, v1, v4

    if-lez v8, :cond_b

    iput-boolean v5, v0, Lcom/wishabi/flipp/widget/bj;->m:Z

    move v1, v4

    :cond_b
    iget-object v8, v0, Lcom/wishabi/flipp/widget/bj;->a:Ljava/util/List;

    invoke-interface {v8}, Ljava/util/List;->size()I

    move-result v8

    add-int/lit8 v8, v8, -0x1

    int-to-float v8, v8

    mul-float/2addr v1, v8

    float-to-int v1, v1

    goto :goto_5

    :cond_c
    move v0, v3

    goto/16 :goto_3

    .line 109
    :cond_d
    invoke-virtual {p1, v6}, Landroid/graphics/Canvas;->restoreToCount(I)V

    .line 111
    if-eqz v2, :cond_0

    .line 112
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/bn;->invalidate()V

    goto/16 :goto_0
.end method

.method public final setZoomScale(F)V
    .locals 0

    .prologue
    .line 28
    iput p1, p0, Lcom/wishabi/flipp/widget/bn;->g:F

    .line 29
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/bn;->invalidate()V

    .line 30
    return-void
.end method
