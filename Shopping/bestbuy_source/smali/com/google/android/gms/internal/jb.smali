.class public final Lcom/google/android/gms/internal/jb;
.super Landroid/widget/ImageView;


# instance fields
.field private a:I

.field private b:Lact;

.field private c:I

.field private d:F


# virtual methods
.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 3

    iget-object v0, p0, Lcom/google/android/gms/internal/jb;->b:Lact;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/jb;->b:Lact;

    invoke-virtual {p0}, Lcom/google/android/gms/internal/jb;->getWidth()I

    move-result v1

    invoke-virtual {p0}, Lcom/google/android/gms/internal/jb;->getHeight()I

    move-result v2

    invoke-interface {v0, v1, v2}, Lact;->a(II)Landroid/graphics/Path;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/graphics/Canvas;->clipPath(Landroid/graphics/Path;)Z

    :cond_0
    invoke-super {p0, p1}, Landroid/widget/ImageView;->onDraw(Landroid/graphics/Canvas;)V

    iget v0, p0, Lcom/google/android/gms/internal/jb;->a:I

    if-eqz v0, :cond_1

    iget v0, p0, Lcom/google/android/gms/internal/jb;->a:I

    invoke-virtual {p1, v0}, Landroid/graphics/Canvas;->drawColor(I)V

    :cond_1
    return-void
.end method

.method protected onMeasure(II)V
    .locals 3

    invoke-super {p0, p1, p2}, Landroid/widget/ImageView;->onMeasure(II)V

    iget v0, p0, Lcom/google/android/gms/internal/jb;->c:I

    packed-switch v0, :pswitch_data_0

    :goto_0
    return-void

    :pswitch_0
    invoke-virtual {p0}, Lcom/google/android/gms/internal/jb;->getMeasuredHeight()I

    move-result v1

    int-to-float v0, v1

    iget v2, p0, Lcom/google/android/gms/internal/jb;->d:F

    mul-float/2addr v0, v2

    float-to-int v0, v0

    :goto_1
    invoke-virtual {p0, v0, v1}, Lcom/google/android/gms/internal/jb;->setMeasuredDimension(II)V

    goto :goto_0

    :pswitch_1
    invoke-virtual {p0}, Lcom/google/android/gms/internal/jb;->getMeasuredWidth()I

    move-result v0

    int-to-float v1, v0

    iget v2, p0, Lcom/google/android/gms/internal/jb;->d:F

    div-float/2addr v1, v2

    float-to-int v1, v1

    goto :goto_1

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method
