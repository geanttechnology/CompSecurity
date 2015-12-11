.class final Lcom/wishabi/flipp/app/bi;
.super Landroid/support/v13/app/i;
.source "SourceFile"


# instance fields
.field final synthetic b:Lcom/wishabi/flipp/app/FlyerCarouselFragment;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/FlyerCarouselFragment;Landroid/app/FragmentManager;)V
    .locals 0

    .prologue
    .line 369
    iput-object p1, p0, Lcom/wishabi/flipp/app/bi;->b:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-direct {p0, p2}, Landroid/support/v13/app/i;-><init>(Landroid/app/FragmentManager;)V

    return-void
.end method


# virtual methods
.method public final a(I)Landroid/app/Fragment;
    .locals 4

    .prologue
    .line 372
    new-instance v1, Lcom/wishabi/flipp/app/bo;

    invoke-direct {v1}, Lcom/wishabi/flipp/app/bo;-><init>()V

    .line 375
    new-instance v2, Landroid/graphics/RectF;

    invoke-direct {v2}, Landroid/graphics/RectF;-><init>()V

    .line 376
    iget-object v0, p0, Lcom/wishabi/flipp/app/bi;->b:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->p(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)Landroid/os/Bundle;

    move-result-object v0

    const-string v3, "position"

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v0

    .line 377
    if-ne v0, p1, :cond_0

    .line 378
    iget-object v0, p0, Lcom/wishabi/flipp/app/bi;->b:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->p(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)Landroid/os/Bundle;

    move-result-object v0

    const-string v3, "left"

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->getFloat(Ljava/lang/String;)F

    move-result v0

    iput v0, v2, Landroid/graphics/RectF;->left:F

    .line 379
    iget-object v0, p0, Lcom/wishabi/flipp/app/bi;->b:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->p(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)Landroid/os/Bundle;

    move-result-object v0

    const-string v3, "top"

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->getFloat(Ljava/lang/String;)F

    move-result v0

    iput v0, v2, Landroid/graphics/RectF;->top:F

    .line 380
    iget-object v0, p0, Lcom/wishabi/flipp/app/bi;->b:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->p(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)Landroid/os/Bundle;

    move-result-object v0

    const-string v3, "right"

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->getFloat(Ljava/lang/String;)F

    move-result v0

    iput v0, v2, Landroid/graphics/RectF;->right:F

    .line 381
    iget-object v0, p0, Lcom/wishabi/flipp/app/bi;->b:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->p(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)Landroid/os/Bundle;

    move-result-object v0

    const-string v3, "bottom"

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->getFloat(Ljava/lang/String;)F

    move-result v0

    iput v0, v2, Landroid/graphics/RectF;->bottom:F

    .line 384
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/app/bi;->b:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->e(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)[Landroid/os/Parcelable;

    move-result-object v0

    aget-object v0, v0, p1

    check-cast v0, Lcom/wishabi/flipp/content/Flyer$Model;

    iput-object v0, v1, Lcom/wishabi/flipp/app/bo;->f:Lcom/wishabi/flipp/content/Flyer$Model;

    iput-object v2, v1, Lcom/wishabi/flipp/app/bo;->c:Landroid/graphics/RectF;

    .line 385
    return-object v1
.end method

.method public final a(Landroid/view/ViewGroup;I)Ljava/lang/Object;
    .locals 2

    .prologue
    .line 403
    invoke-super {p0, p1, p2}, Landroid/support/v13/app/i;->a(Landroid/view/ViewGroup;I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/app/bo;

    .line 406
    new-instance v1, Lcom/wishabi/flipp/app/bj;

    invoke-direct {v1, p0}, Lcom/wishabi/flipp/app/bj;-><init>(Lcom/wishabi/flipp/app/bi;)V

    iput-object v1, v0, Lcom/wishabi/flipp/app/bo;->a:Lcom/wishabi/flipp/app/bu;

    .line 478
    return-object v0
.end method

.method public final c()I
    .locals 1

    .prologue
    .line 390
    iget-object v0, p0, Lcom/wishabi/flipp/app/bi;->b:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->e(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)[Landroid/os/Parcelable;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/app/bi;->b:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->e(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)[Landroid/os/Parcelable;

    move-result-object v0

    array-length v0, v0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
