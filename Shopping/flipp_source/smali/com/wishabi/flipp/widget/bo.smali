.class public final Lcom/wishabi/flipp/widget/bo;
.super Landroid/view/View;
.source "SourceFile"


# instance fields
.field a:F

.field b:F

.field public final c:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Long;",
            "Landroid/graphics/drawable/Drawable;",
            ">;"
        }
    .end annotation
.end field

.field private d:F


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 25
    invoke-direct {p0, p1}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    .line 22
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/wishabi/flipp/widget/bo;->c:Ljava/util/HashMap;

    .line 26
    return-void
.end method


# virtual methods
.method protected final onDraw(Landroid/graphics/Canvas;)V
    .locals 3

    .prologue
    .line 70
    invoke-super {p0, p1}, Landroid/view/View;->onDraw(Landroid/graphics/Canvas;)V

    .line 72
    invoke-virtual {p1}, Landroid/graphics/Canvas;->save()I

    move-result v1

    .line 73
    iget v0, p0, Lcom/wishabi/flipp/widget/bo;->d:F

    iget v2, p0, Lcom/wishabi/flipp/widget/bo;->d:F

    invoke-virtual {p1, v0, v2}, Landroid/graphics/Canvas;->scale(FF)V

    .line 74
    iget v0, p0, Lcom/wishabi/flipp/widget/bo;->a:F

    neg-float v0, v0

    iget v2, p0, Lcom/wishabi/flipp/widget/bo;->b:F

    neg-float v2, v2

    invoke-virtual {p1, v0, v2}, Landroid/graphics/Canvas;->translate(FF)V

    .line 76
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bo;->c:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 77
    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0, p1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    goto :goto_0

    .line 79
    :cond_0
    invoke-virtual {p1, v1}, Landroid/graphics/Canvas;->restoreToCount(I)V

    .line 80
    return-void
.end method

.method public final setZoomScale(F)V
    .locals 0

    .prologue
    .line 29
    iput p1, p0, Lcom/wishabi/flipp/widget/bo;->d:F

    .line 30
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/bo;->invalidate()V

    .line 31
    return-void
.end method
