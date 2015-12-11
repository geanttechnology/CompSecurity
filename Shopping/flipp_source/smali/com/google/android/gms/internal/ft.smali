.class public final Lcom/google/android/gms/internal/ft;
.super Landroid/widget/ImageView;


# instance fields
.field public a:Landroid/net/Uri;

.field public b:I

.field private c:I


# virtual methods
.method protected final onDraw(Landroid/graphics/Canvas;)V
    .locals 1

    invoke-super {p0, p1}, Landroid/widget/ImageView;->onDraw(Landroid/graphics/Canvas;)V

    iget v0, p0, Lcom/google/android/gms/internal/ft;->c:I

    if-eqz v0, :cond_0

    iget v0, p0, Lcom/google/android/gms/internal/ft;->c:I

    invoke-virtual {p1, v0}, Landroid/graphics/Canvas;->drawColor(I)V

    :cond_0
    return-void
.end method
