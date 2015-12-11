.class final Lcom/wishabi/flipp/app/bj;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/wishabi/flipp/app/bu;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/bi;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/bi;)V
    .locals 0

    .prologue
    .line 407
    iput-object p1, p0, Lcom/wishabi/flipp/app/bj;->a:Lcom/wishabi/flipp/app/bi;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a()V
    .locals 2

    .prologue
    .line 430
    iget-object v0, p0, Lcom/wishabi/flipp/app/bj;->a:Lcom/wishabi/flipp/app/bi;

    iget-object v0, v0, Lcom/wishabi/flipp/app/bi;->b:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->s(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)V

    .line 431
    iget-object v0, p0, Lcom/wishabi/flipp/app/bj;->a:Lcom/wishabi/flipp/app/bi;

    iget-object v0, v0, Lcom/wishabi/flipp/app/bi;->b:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->r(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)Lcom/wishabi/flipp/widget/ShoppingListPopup;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/ShoppingListPopup;->a(Z)V

    .line 432
    return-void
.end method

.method public final a(Lcom/wishabi/flipp/app/bo;Ljava/lang/String;Z)V
    .locals 9

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 446
    iget-object v0, p0, Lcom/wishabi/flipp/app/bj;->a:Lcom/wishabi/flipp/app/bi;

    iget-object v0, v0, Lcom/wishabi/flipp/app/bi;->b:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->l(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 475
    :cond_0
    :goto_0
    return-void

    .line 449
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/app/bj;->a:Lcom/wishabi/flipp/app/bi;

    iget-object v0, v0, Lcom/wishabi/flipp/app/bi;->b:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->o(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)Lcom/wishabi/flipp/widget/FlyerToolbar;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 452
    iget-object v0, p0, Lcom/wishabi/flipp/app/bj;->a:Lcom/wishabi/flipp/app/bi;

    iget-object v0, v0, Lcom/wishabi/flipp/app/bi;->b:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->b(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)Lcom/wishabi/flipp/app/bo;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 455
    iget-object v0, p0, Lcom/wishabi/flipp/app/bj;->a:Lcom/wishabi/flipp/app/bi;

    iget-object v0, v0, Lcom/wishabi/flipp/app/bi;->b:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->o(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)Lcom/wishabi/flipp/widget/FlyerToolbar;

    move-result-object v0

    invoke-virtual {v0, v2}, Lcom/wishabi/flipp/widget/FlyerToolbar;->setProgressVisible(Z)V

    .line 456
    iget-object v0, p0, Lcom/wishabi/flipp/app/bj;->a:Lcom/wishabi/flipp/app/bi;

    iget-object v0, v0, Lcom/wishabi/flipp/app/bi;->b:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->o(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)Lcom/wishabi/flipp/widget/FlyerToolbar;

    move-result-object v3

    iget-object v0, p0, Lcom/wishabi/flipp/app/bj;->a:Lcom/wishabi/flipp/app/bi;

    iget-object v0, v0, Lcom/wishabi/flipp/app/bi;->b:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->b(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)Lcom/wishabi/flipp/app/bo;

    move-result-object v0

    iget v4, v0, Lcom/wishabi/flipp/app/bo;->e:I

    iget-object v0, p0, Lcom/wishabi/flipp/app/bj;->a:Lcom/wishabi/flipp/app/bi;

    iget-object v0, v0, Lcom/wishabi/flipp/app/bi;->b:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->b(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)Lcom/wishabi/flipp/app/bo;

    move-result-object v0

    iget-boolean v0, v0, Lcom/wishabi/flipp/app/bo;->d:Z

    if-nez v0, :cond_4

    move v0, v1

    :goto_1
    invoke-virtual {v3}, Lcom/wishabi/flipp/widget/FlyerToolbar;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    if-eqz v5, :cond_2

    if-nez v0, :cond_5

    :cond_2
    iget-object v0, v3, Lcom/wishabi/flipp/widget/FlyerToolbar;->a:Landroid/widget/TextView;

    const/4 v4, 0x0

    invoke-virtual {v0, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    iput-boolean v1, v3, Lcom/wishabi/flipp/widget/FlyerToolbar;->b:Z

    :goto_2
    invoke-virtual {v3}, Lcom/wishabi/flipp/widget/FlyerToolbar;->a()V

    .line 458
    iget-object v0, p0, Lcom/wishabi/flipp/app/bj;->a:Lcom/wishabi/flipp/app/bi;

    iget-object v0, v0, Lcom/wishabi/flipp/app/bi;->b:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->o(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)Lcom/wishabi/flipp/widget/FlyerToolbar;

    move-result-object v0

    iget-object v3, p1, Lcom/wishabi/flipp/app/bo;->j:Ljava/util/HashSet;

    invoke-virtual {v3}, Ljava/util/HashSet;->size()I

    move-result v3

    invoke-virtual {v0, v3}, Lcom/wishabi/flipp/widget/FlyerToolbar;->setCouponCount(I)V

    .line 459
    iget-object v0, p0, Lcom/wishabi/flipp/app/bj;->a:Lcom/wishabi/flipp/app/bi;

    iget-object v0, v0, Lcom/wishabi/flipp/app/bi;->b:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->t(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)Lcom/wishabi/flipp/widget/bh;

    move-result-object v0

    iget-object v3, p0, Lcom/wishabi/flipp/app/bj;->a:Lcom/wishabi/flipp/app/bi;

    iget-object v3, v3, Lcom/wishabi/flipp/app/bi;->b:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-static {v3}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->o(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)Lcom/wishabi/flipp/widget/FlyerToolbar;

    move-result-object v3

    iget-object v4, p0, Lcom/wishabi/flipp/app/bj;->a:Lcom/wishabi/flipp/app/bi;

    iget-object v4, v4, Lcom/wishabi/flipp/app/bi;->b:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-static {v4}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->c(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)I

    move-result v4

    invoke-interface {v0, v3, v4}, Lcom/wishabi/flipp/widget/bh;->a(Lcom/wishabi/flipp/widget/FlyerToolbar;I)V

    .line 461
    iget-object v0, p0, Lcom/wishabi/flipp/app/bj;->a:Lcom/wishabi/flipp/app/bi;

    iget-object v0, v0, Lcom/wishabi/flipp/app/bi;->b:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    iget-object v3, p0, Lcom/wishabi/flipp/app/bj;->a:Lcom/wishabi/flipp/app/bi;

    iget-object v3, v3, Lcom/wishabi/flipp/app/bi;->b:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-static {v3}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->c(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)I

    move-result v3

    invoke-static {v0, v3, v2, v2}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->a(Lcom/wishabi/flipp/app/FlyerCarouselFragment;IZZ)V

    .line 463
    if-eqz p3, :cond_0

    .line 467
    iget-object v0, p1, Lcom/wishabi/flipp/app/bo;->j:Ljava/util/HashSet;

    invoke-virtual {v0}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_3
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_7

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Long;

    iget-object v4, p1, Lcom/wishabi/flipp/app/bo;->h:Ljava/util/HashMap;

    invoke-virtual {v4, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/bi;

    if-eqz v0, :cond_3

    iget-object v0, v0, Lcom/wishabi/flipp/widget/bi;->c:Ljava/lang/Object;

    check-cast v0, Lcom/wishabi/flipp/app/bt;

    iget v0, v0, Lcom/wishabi/flipp/app/bt;->o:I

    invoke-static {v0}, Lcom/wishabi/flipp/content/ag;->b(I)Z

    move-result v0

    if-nez v0, :cond_3

    .line 468
    :goto_3
    new-instance v0, Lcom/wishabi/flipp/app/bk;

    invoke-direct {v0, p0, v1}, Lcom/wishabi/flipp/app/bk;-><init>(Lcom/wishabi/flipp/app/bj;Z)V

    invoke-static {v0}, Lcom/wishabi/flipp/app/FlippApplication;->a(Ljava/lang/Runnable;)Z

    goto/16 :goto_0

    :cond_4
    move v0, v2

    .line 456
    goto/16 :goto_1

    :cond_5
    if-nez v4, :cond_6

    iget-object v0, v3, Lcom/wishabi/flipp/widget/FlyerToolbar;->a:Landroid/widget/TextView;

    const v4, 0x7f0e00fb

    invoke-virtual {v5, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    iput-boolean v1, v3, Lcom/wishabi/flipp/widget/FlyerToolbar;->b:Z

    goto/16 :goto_2

    :cond_6
    iget-object v0, v3, Lcom/wishabi/flipp/widget/FlyerToolbar;->a:Landroid/widget/TextView;

    const v6, 0x7f0d0007

    new-array v7, v1, [Ljava/lang/Object;

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v7, v2

    invoke-virtual {v5, v6, v4, v7}, Landroid/content/res/Resources;->getQuantityString(II[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    iput-boolean v2, v3, Lcom/wishabi/flipp/widget/FlyerToolbar;->b:Z

    goto/16 :goto_2

    :cond_7
    move v1, v2

    goto :goto_3
.end method

.method public final a(ZLjava/lang/String;I)V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 413
    iget-object v0, p0, Lcom/wishabi/flipp/app/bj;->a:Lcom/wishabi/flipp/app/bi;

    iget-object v0, v0, Lcom/wishabi/flipp/app/bi;->b:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->q(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)I

    move-result v0

    sget v1, Lcom/wishabi/flipp/app/bm;->b:I

    if-ne v0, v1, :cond_0

    .line 426
    :goto_0
    return-void

    .line 419
    :cond_0
    if-eqz p1, :cond_1

    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    invoke-static {p3}, Lcom/wishabi/flipp/content/ag;->b(I)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 421
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/app/bj;->a:Lcom/wishabi/flipp/app/bi;

    iget-object v0, v0, Lcom/wishabi/flipp/app/bi;->b:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->r(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)Lcom/wishabi/flipp/widget/ShoppingListPopup;

    move-result-object v0

    invoke-virtual {v0, v2}, Lcom/wishabi/flipp/widget/ShoppingListPopup;->a(Z)V

    goto :goto_0

    .line 425
    :cond_2
    iget-object v0, p0, Lcom/wishabi/flipp/app/bj;->a:Lcom/wishabi/flipp/app/bi;

    iget-object v0, v0, Lcom/wishabi/flipp/app/bi;->b:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->r(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)Lcom/wishabi/flipp/widget/ShoppingListPopup;

    move-result-object v0

    invoke-virtual {v0, p2, v2}, Lcom/wishabi/flipp/widget/ShoppingListPopup;->a(Ljava/lang/String;Z)V

    goto :goto_0
.end method

.method public final a(Ljava/lang/String;)Z
    .locals 1

    .prologue
    .line 437
    iget-object v0, p0, Lcom/wishabi/flipp/app/bj;->a:Lcom/wishabi/flipp/app/bi;

    iget-object v0, v0, Lcom/wishabi/flipp/app/bi;->b:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-static {v0, p1}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->b(Lcom/wishabi/flipp/app/FlyerCarouselFragment;Ljava/lang/String;)V

    .line 438
    const/4 v0, 0x1

    return v0
.end method
