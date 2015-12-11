.class public final Lcom/wishabi/flipp/widget/bv;
.super Landroid/view/View;
.source "SourceFile"


# instance fields
.field public a:Landroid/graphics/Bitmap;

.field public b:Landroid/graphics/Canvas;

.field c:F

.field d:F

.field private final e:Landroid/graphics/Paint;

.field private final f:Landroid/graphics/Paint;

.field private final g:Landroid/graphics/Matrix;

.field private h:F

.field private i:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/wishabi/flipp/widget/bi;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 4

    .prologue
    const/high16 v3, 0x40000000    # 2.0f

    const/4 v2, 0x0

    .line 36
    invoke-direct {p0, p1}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    .line 18
    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    iput-object v0, p0, Lcom/wishabi/flipp/widget/bv;->e:Landroid/graphics/Paint;

    .line 19
    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    iput-object v0, p0, Lcom/wishabi/flipp/widget/bv;->f:Landroid/graphics/Paint;

    .line 20
    new-instance v0, Landroid/graphics/Matrix;

    invoke-direct {v0}, Landroid/graphics/Matrix;-><init>()V

    iput-object v0, p0, Lcom/wishabi/flipp/widget/bv;->g:Landroid/graphics/Matrix;

    .line 37
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bv;->e:Landroid/graphics/Paint;

    const/16 v1, 0x80

    invoke-virtual {v0, v1, v2, v2, v2}, Landroid/graphics/Paint;->setARGB(IIII)V

    .line 38
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bv;->f:Landroid/graphics/Paint;

    new-instance v1, Landroid/graphics/PorterDuffXfermode;

    sget-object v2, Landroid/graphics/PorterDuff$Mode;->CLEAR:Landroid/graphics/PorterDuff$Mode;

    invoke-direct {v1, v2}, Landroid/graphics/PorterDuffXfermode;-><init>(Landroid/graphics/PorterDuff$Mode;)V

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setXfermode(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;

    .line 39
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bv;->g:Landroid/graphics/Matrix;

    invoke-virtual {v0, v3, v3}, Landroid/graphics/Matrix;->setScale(FF)V

    .line 40
    return-void
.end method


# virtual methods
.method public final getHighlightAnnotations()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/wishabi/flipp/widget/bi;",
            ">;"
        }
    .end annotation

    .prologue
    .line 83
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bv;->i:Ljava/util/List;

    return-object v0
.end method

.method protected final onDraw(Landroid/graphics/Canvas;)V
    .locals 9

    .prologue
    const/high16 v8, 0x41200000    # 10.0f

    const/high16 v3, 0x3f000000    # 0.5f

    .line 88
    invoke-super {p0, p1}, Landroid/view/View;->onDraw(Landroid/graphics/Canvas;)V

    .line 89
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bv;->i:Ljava/util/List;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/widget/bv;->a:Landroid/graphics/Bitmap;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/widget/bv;->b:Landroid/graphics/Canvas;

    if-nez v0, :cond_1

    .line 106
    :cond_0
    :goto_0
    return-void

    .line 92
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bv;->b:Landroid/graphics/Canvas;

    invoke-virtual {v0}, Landroid/graphics/Canvas;->save()I

    move-result v6

    .line 93
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bv;->b:Landroid/graphics/Canvas;

    iget v1, p0, Lcom/wishabi/flipp/widget/bv;->h:F

    mul-float/2addr v1, v3

    iget v2, p0, Lcom/wishabi/flipp/widget/bv;->h:F

    mul-float/2addr v2, v3

    invoke-virtual {v0, v1, v2}, Landroid/graphics/Canvas;->scale(FF)V

    .line 94
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bv;->b:Landroid/graphics/Canvas;

    iget v1, p0, Lcom/wishabi/flipp/widget/bv;->c:F

    neg-float v1, v1

    iget v2, p0, Lcom/wishabi/flipp/widget/bv;->d:F

    neg-float v2, v2

    invoke-virtual {v0, v1, v2}, Landroid/graphics/Canvas;->translate(FF)V

    .line 95
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bv;->b:Landroid/graphics/Canvas;

    iget v1, p0, Lcom/wishabi/flipp/widget/bv;->c:F

    iget v2, p0, Lcom/wishabi/flipp/widget/bv;->d:F

    iget v3, p0, Lcom/wishabi/flipp/widget/bv;->c:F

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/bv;->getWidth()I

    move-result v4

    int-to-float v4, v4

    iget v5, p0, Lcom/wishabi/flipp/widget/bv;->h:F

    div-float/2addr v4, v5

    add-float/2addr v3, v4

    iget v4, p0, Lcom/wishabi/flipp/widget/bv;->d:F

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/bv;->getHeight()I

    move-result v5

    int-to-float v5, v5

    iget v7, p0, Lcom/wishabi/flipp/widget/bv;->h:F

    div-float/2addr v5, v7

    add-float/2addr v4, v5

    iget-object v5, p0, Lcom/wishabi/flipp/widget/bv;->f:Landroid/graphics/Paint;

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 98
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bv;->b:Landroid/graphics/Canvas;

    iget v1, p0, Lcom/wishabi/flipp/widget/bv;->c:F

    iget v2, p0, Lcom/wishabi/flipp/widget/bv;->d:F

    iget v3, p0, Lcom/wishabi/flipp/widget/bv;->c:F

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/bv;->getWidth()I

    move-result v4

    int-to-float v4, v4

    iget v5, p0, Lcom/wishabi/flipp/widget/bv;->h:F

    div-float/2addr v4, v5

    add-float/2addr v3, v4

    iget v4, p0, Lcom/wishabi/flipp/widget/bv;->d:F

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/bv;->getHeight()I

    move-result v5

    int-to-float v5, v5

    iget v7, p0, Lcom/wishabi/flipp/widget/bv;->h:F

    div-float/2addr v5, v7

    add-float/2addr v4, v5

    iget-object v5, p0, Lcom/wishabi/flipp/widget/bv;->e:Landroid/graphics/Paint;

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 101
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bv;->i:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/bi;

    .line 102
    iget-object v2, p0, Lcom/wishabi/flipp/widget/bv;->b:Landroid/graphics/Canvas;

    const/4 v3, 0x0

    invoke-virtual {v0, v3}, Lcom/wishabi/flipp/widget/bi;->a(Z)Landroid/graphics/RectF;

    move-result-object v0

    iget-object v3, p0, Lcom/wishabi/flipp/widget/bv;->f:Landroid/graphics/Paint;

    invoke-virtual {v2, v0, v8, v8, v3}, Landroid/graphics/Canvas;->drawRoundRect(Landroid/graphics/RectF;FFLandroid/graphics/Paint;)V

    goto :goto_1

    .line 103
    :cond_2
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bv;->b:Landroid/graphics/Canvas;

    invoke-virtual {v0, v6}, Landroid/graphics/Canvas;->restoreToCount(I)V

    .line 105
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bv;->a:Landroid/graphics/Bitmap;

    iget-object v1, p0, Lcom/wishabi/flipp/widget/bv;->g:Landroid/graphics/Matrix;

    const/4 v2, 0x0

    invoke-virtual {p1, v0, v1, v2}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;Landroid/graphics/Paint;)V

    goto/16 :goto_0
.end method

.method protected final onSizeChanged(IIII)V
    .locals 3

    .prologue
    const/4 v1, 0x0

    .line 44
    invoke-super {p0, p1, p2, p3, p4}, Landroid/view/View;->onSizeChanged(IIII)V

    .line 46
    div-int/lit8 v0, p1, 0x2

    if-lez v0, :cond_0

    div-int/lit8 v0, p2, 0x2

    if-lez v0, :cond_0

    .line 47
    div-int/lit8 v0, p1, 0x2

    div-int/lit8 v1, p2, 0x2

    sget-object v2, Landroid/graphics/Bitmap$Config;->ALPHA_8:Landroid/graphics/Bitmap$Config;

    invoke-static {v0, v1, v2}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/widget/bv;->a:Landroid/graphics/Bitmap;

    .line 48
    new-instance v0, Landroid/graphics/Canvas;

    iget-object v1, p0, Lcom/wishabi/flipp/widget/bv;->a:Landroid/graphics/Bitmap;

    invoke-direct {v0, v1}, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V

    iput-object v0, p0, Lcom/wishabi/flipp/widget/bv;->b:Landroid/graphics/Canvas;

    .line 53
    :goto_0
    return-void

    .line 50
    :cond_0
    iput-object v1, p0, Lcom/wishabi/flipp/widget/bv;->a:Landroid/graphics/Bitmap;

    .line 51
    iput-object v1, p0, Lcom/wishabi/flipp/widget/bv;->b:Landroid/graphics/Canvas;

    goto :goto_0
.end method

.method public final setHighlightAnnotations(Ljava/util/List;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/wishabi/flipp/widget/bi;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 72
    if-nez p1, :cond_1

    .line 73
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/wishabi/flipp/widget/bv;->i:Ljava/util/List;

    .line 79
    :cond_0
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/bv;->invalidate()V

    .line 80
    return-void

    .line 75
    :cond_1
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/wishabi/flipp/widget/bv;->i:Ljava/util/List;

    .line 76
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/bi;

    .line 77
    iget-object v2, p0, Lcom/wishabi/flipp/widget/bv;->i:Ljava/util/List;

    invoke-interface {v2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method public final setZoomScale(F)V
    .locals 0

    .prologue
    .line 61
    iput p1, p0, Lcom/wishabi/flipp/widget/bv;->h:F

    .line 62
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/bv;->invalidate()V

    .line 63
    return-void
.end method
