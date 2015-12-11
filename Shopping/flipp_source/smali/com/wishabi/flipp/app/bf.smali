.class final Lcom/wishabi/flipp/app/bf;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/wishabi/flipp/widget/bh;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/FlyerCarouselFragment;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)V
    .locals 0

    .prologue
    .line 81
    iput-object p1, p0, Lcom/wishabi/flipp/app/bf;->a:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a()V
    .locals 7

    .prologue
    .line 96
    iget-object v0, p0, Lcom/wishabi/flipp/app/bf;->a:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->b(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)Lcom/wishabi/flipp/app/bo;

    move-result-object v0

    if-nez v0, :cond_1

    .line 121
    :cond_0
    :goto_0
    return-void

    .line 99
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/app/bf;->a:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->b(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)Lcom/wishabi/flipp/app/bo;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/bo;->getView()Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/FlyerViewGroup;

    .line 101
    if-eqz v0, :cond_0

    .line 104
    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getVisibleRect()Landroid/graphics/RectF;

    move-result-object v3

    .line 106
    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getHighlightAnnotations()Ljava/util/List;

    move-result-object v1

    .line 108
    if-eqz v1, :cond_0

    invoke-interface {v1}, Ljava/util/List;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_0

    .line 111
    const/4 v2, 0x0

    .line 112
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_2
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_3

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/wishabi/flipp/widget/bi;

    .line 113
    iget-object v5, v1, Lcom/wishabi/flipp/widget/bi;->a:Landroid/graphics/RectF;

    iget v5, v5, Landroid/graphics/RectF;->left:F

    iget v6, v3, Landroid/graphics/RectF;->right:F

    cmpl-float v5, v5, v6

    if-ltz v5, :cond_2

    .line 114
    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Lcom/wishabi/flipp/widget/bi;->a(Z)Landroid/graphics/RectF;

    move-result-object v1

    .line 119
    :goto_1
    if-eqz v1, :cond_0

    .line 120
    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->a(Landroid/graphics/RectF;)V

    goto :goto_0

    :cond_3
    move-object v1, v2

    goto :goto_1
.end method

.method public final a(Lcom/wishabi/flipp/widget/FlyerToolbar;)V
    .locals 4

    .prologue
    const/4 v1, 0x0

    .line 160
    iget-object v0, p0, Lcom/wishabi/flipp/app/bf;->a:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->b(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)Lcom/wishabi/flipp/app/bo;

    move-result-object v0

    if-nez v0, :cond_1

    .line 175
    :cond_0
    :goto_0
    return-void

    .line 163
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/app/bf;->a:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->b(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)Lcom/wishabi/flipp/app/bo;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/bo;->getView()Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/FlyerViewGroup;

    .line 164
    if-eqz v0, :cond_0

    .line 167
    iget-object v2, p0, Lcom/wishabi/flipp/app/bf;->a:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    iget-object v0, p0, Lcom/wishabi/flipp/app/bf;->a:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->a(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)Z

    move-result v0

    if-nez v0, :cond_3

    const/4 v0, 0x1

    :goto_1
    invoke-static {v2, v0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->a(Lcom/wishabi/flipp/app/FlyerCarouselFragment;Z)Z

    .line 168
    iget-object v0, p0, Lcom/wishabi/flipp/app/bf;->a:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->a(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)Z

    move-result v0

    invoke-virtual {p1, v0}, Lcom/wishabi/flipp/widget/FlyerToolbar;->setShowCoupon(Z)V

    .line 171
    iget-object v0, p0, Lcom/wishabi/flipp/app/bf;->a:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->a(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 172
    invoke-virtual {p1, v1}, Lcom/wishabi/flipp/widget/FlyerToolbar;->setDiscount(I)V

    .line 174
    :cond_2
    iget-object v0, p0, Lcom/wishabi/flipp/app/bf;->a:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    iget-object v2, p0, Lcom/wishabi/flipp/app/bf;->a:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-static {v2}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->c(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)I

    move-result v2

    iget-object v3, p0, Lcom/wishabi/flipp/app/bf;->a:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-static {v3}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->a(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)Z

    move-result v3

    invoke-static {v0, v2, v1, v3}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->a(Lcom/wishabi/flipp/app/FlyerCarouselFragment;IZZ)V

    goto :goto_0

    :cond_3
    move v0, v1

    .line 167
    goto :goto_1
.end method

.method public final a(Lcom/wishabi/flipp/widget/FlyerToolbar;I)V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 86
    if-lez p2, :cond_0

    .line 87
    iget-object v0, p0, Lcom/wishabi/flipp/app/bf;->a:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->a(Lcom/wishabi/flipp/app/FlyerCarouselFragment;Z)Z

    .line 88
    iget-object v0, p0, Lcom/wishabi/flipp/app/bf;->a:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->a(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)Z

    move-result v0

    invoke-virtual {p1, v0}, Lcom/wishabi/flipp/widget/FlyerToolbar;->setShowCoupon(Z)V

    .line 91
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/app/bf;->a:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-static {v0, p2, v2, v2}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->a(Lcom/wishabi/flipp/app/FlyerCarouselFragment;IZZ)V

    .line 92
    return-void
.end method

.method public final b()V
    .locals 9

    .prologue
    const/4 v2, 0x0

    .line 125
    iget-object v0, p0, Lcom/wishabi/flipp/app/bf;->a:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->b(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)Lcom/wishabi/flipp/app/bo;

    move-result-object v0

    if-nez v0, :cond_1

    .line 156
    :cond_0
    :goto_0
    return-void

    .line 128
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/app/bf;->a:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->b(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)Lcom/wishabi/flipp/app/bo;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/bo;->getView()Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/FlyerViewGroup;

    .line 130
    if-eqz v0, :cond_0

    .line 133
    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getVisibleRect()Landroid/graphics/RectF;

    move-result-object v5

    .line 135
    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getHighlightAnnotations()Ljava/util/List;

    move-result-object v6

    .line 137
    if-eqz v6, :cond_0

    invoke-interface {v6}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_0

    .line 140
    const/4 v3, 0x0

    .line 141
    invoke-interface {v6}, Ljava/util/List;->size()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    move v4, v1

    :goto_1
    if-ltz v4, :cond_4

    .line 142
    invoke-interface {v6, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/wishabi/flipp/widget/bi;

    .line 143
    iget-object v7, v1, Lcom/wishabi/flipp/widget/bi;->a:Landroid/graphics/RectF;

    iget v7, v7, Landroid/graphics/RectF;->right:F

    iget v8, v5, Landroid/graphics/RectF;->left:F

    cmpg-float v7, v7, v8

    if-gtz v7, :cond_3

    .line 144
    const/4 v3, 0x1

    invoke-virtual {v1, v3}, Lcom/wishabi/flipp/widget/bi;->a(Z)Landroid/graphics/RectF;

    move-result-object v3

    .line 148
    iget v1, v3, Landroid/graphics/RectF;->right:F

    invoke-virtual {v5}, Landroid/graphics/RectF;->width()F

    move-result v4

    sub-float/2addr v1, v4

    iput v1, v3, Landroid/graphics/RectF;->left:F

    .line 149
    iget v1, v3, Landroid/graphics/RectF;->left:F

    cmpl-float v1, v1, v2

    if-lez v1, :cond_2

    iget v1, v3, Landroid/graphics/RectF;->left:F

    :goto_2
    iput v1, v3, Landroid/graphics/RectF;->left:F

    move-object v1, v3

    .line 154
    :goto_3
    if-eqz v1, :cond_0

    .line 155
    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->a(Landroid/graphics/RectF;)V

    goto :goto_0

    :cond_2
    move v1, v2

    .line 149
    goto :goto_2

    .line 141
    :cond_3
    add-int/lit8 v1, v4, -0x1

    move v4, v1

    goto :goto_1

    :cond_4
    move-object v1, v3

    goto :goto_3
.end method
