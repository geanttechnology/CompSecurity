.class final Llp$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Llp;->a(Landroid/app/Activity;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;IZLcom/bestbuy/android/api/lib/models/dnm/DNMProduct;ZLjava/lang/String;)Landroid/view/View;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;

.field final synthetic b:Z

.field final synthetic c:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

.field final synthetic d:I

.field final synthetic e:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

.field final synthetic f:Ljava/lang/String;

.field final synthetic g:Landroid/app/Activity;

.field final synthetic h:Z


# direct methods
.method constructor <init>(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;ZLcom/bestbuy/android/api/lib/models/dnm/DNMProduct;ILcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;Ljava/lang/String;Landroid/app/Activity;Z)V
    .locals 0

    .prologue
    .line 471
    iput-object p1, p0, Llp$1;->a:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;

    iput-boolean p2, p0, Llp$1;->b:Z

    iput-object p3, p0, Llp$1;->c:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    iput p4, p0, Llp$1;->d:I

    iput-object p5, p0, Llp$1;->e:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    iput-object p6, p0, Llp$1;->f:Ljava/lang/String;

    iput-object p7, p0, Llp$1;->g:Landroid/app/Activity;

    iput-boolean p8, p0, Llp$1;->h:Z

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 9

    .prologue
    const v2, 0x7f0801e4

    const v6, 0x7f0801e3

    const v5, 0x7f0801e2

    const v3, 0x7f0801e1

    const/4 v4, 0x4

    .line 474
    const/4 v7, 0x0

    .line 475
    iget-object v0, p0, Llp$1;->a:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;

    if-eqz v0, :cond_0

    iget-object v0, p0, Llp$1;->a:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;->getPricingType()Ljava/lang/String;

    move-result-object v0

    const-string v1, "ICR-noPrice"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    iget-object v0, p0, Llp$1;->a:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;->getPricingType()Ljava/lang/String;

    move-result-object v0

    const-string v1, "ICR-strikeThrough"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    :cond_0
    iget-boolean v0, p0, Llp$1;->b:Z

    if-eqz v0, :cond_7

    iget-object v0, p0, Llp$1;->c:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    if-eqz v0, :cond_7

    iget-object v0, p0, Llp$1;->c:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->isICRPrice()Z

    move-result v0

    if-nez v0, :cond_1

    iget-object v0, p0, Llp$1;->c:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->isICRStrike()Z

    move-result v0

    if-eqz v0, :cond_7

    .line 476
    :cond_1
    iget v0, p0, Llp$1;->d:I

    if-ne v0, v4, :cond_6

    .line 477
    iget-object v0, p0, Llp$1;->a:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;->getPricingType()Ljava/lang/String;

    move-result-object v0

    const-string v1, "ICR-noPrice"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 478
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 479
    const-string v1, "bb.pdpTap"

    const-string v4, "1"

    invoke-virtual {v0, v1, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 480
    const-string v1, "&&products"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, ";"

    invoke-virtual {v4, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v8, p0, Llp$1;->e:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v8}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v8

    invoke-virtual {v8}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getSkuId()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v4, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v8, ";;"

    invoke-virtual {v4, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v1, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 481
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v4, p0, Llp$1;->f:Ljava/lang/String;

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v4, "pdp"

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, v0}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 483
    :cond_2
    iget-object v0, p0, Llp$1;->e:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getRestrictedPrice()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;

    move-result-object v0

    .line 484
    if-eqz v0, :cond_5

    .line 485
    iget-object v1, p0, Llp$1;->e:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v1

    .line 486
    invoke-virtual {v1, v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->setPrice(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;)V

    .line 487
    iget-object v0, p0, Llp$1;->g:Landroid/app/Activity;

    iget-object v1, p0, Llp$1;->e:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    iget v2, p0, Llp$1;->d:I

    iget-boolean v3, p0, Llp$1;->b:Z

    iget-object v4, p0, Llp$1;->c:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    iget-boolean v5, p0, Llp$1;->h:Z

    iget-object v6, p0, Llp$1;->f:Ljava/lang/String;

    invoke-static/range {v0 .. v6}, Llp;->a(Landroid/app/Activity;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;IZLcom/bestbuy/android/api/lib/models/dnm/DNMProduct;ZLjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 488
    sget-object v1, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->a:Landroid/widget/LinearLayout;

    invoke-virtual {v1}, Landroid/widget/LinearLayout;->removeAllViewsInLayout()V

    .line 489
    sget-object v1, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->a:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v0}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    move-object v0, v7

    :goto_0
    move-object v7, v0

    .line 516
    :cond_3
    :goto_1
    if-eqz v7, :cond_4

    .line 517
    invoke-virtual {v7}, Llb;->show()V

    .line 518
    :cond_4
    return-void

    .line 491
    :cond_5
    new-instance v0, Llb;

    iget-object v1, p0, Llp$1;->g:Landroid/app/Activity;

    const v4, 0x7f0801e5

    invoke-direct/range {v0 .. v6}, Llb;-><init>(Landroid/content/Context;IIIII)V

    goto :goto_0

    .line 493
    :cond_6
    new-instance v0, Llb;

    iget-object v1, p0, Llp$1;->g:Landroid/app/Activity;

    const v4, 0x7f0801e5

    invoke-direct/range {v0 .. v6}, Llb;-><init>(Landroid/content/Context;IIIII)V

    move-object v7, v0

    goto :goto_1

    .line 495
    :cond_7
    iget-object v0, p0, Llp$1;->a:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;

    if-eqz v0, :cond_8

    iget-object v0, p0, Llp$1;->a:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;->getPricingType()Ljava/lang/String;

    move-result-object v0

    const-string v1, "MAP"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_9

    :cond_8
    iget-boolean v0, p0, Llp$1;->b:Z

    if-eqz v0, :cond_3

    iget-object v0, p0, Llp$1;->c:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    if-eqz v0, :cond_3

    iget-object v0, p0, Llp$1;->c:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->isMapFlag()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 496
    :cond_9
    iget v0, p0, Llp$1;->d:I

    if-ne v0, v4, :cond_c

    .line 497
    iget-object v0, p0, Llp$1;->a:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;->getPricingType()Ljava/lang/String;

    move-result-object v0

    const-string v1, "MAP"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_a

    .line 498
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 499
    const-string v1, "bb.pdpTap"

    const-string v2, "1"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 500
    const-string v1, "&&products"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, ";"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Llp$1;->e:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v3

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getSkuId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ";;"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 501
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Llp$1;->f:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "pdp"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, v0}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 503
    :cond_a
    iget-object v0, p0, Llp$1;->e:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getRestrictedPrice()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;

    move-result-object v0

    .line 504
    if-eqz v0, :cond_b

    .line 505
    iget-object v1, p0, Llp$1;->e:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v1

    .line 506
    invoke-virtual {v1, v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->setPrice(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;)V

    .line 507
    iget-object v0, p0, Llp$1;->g:Landroid/app/Activity;

    iget-object v1, p0, Llp$1;->e:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    iget v2, p0, Llp$1;->d:I

    iget-boolean v3, p0, Llp$1;->b:Z

    iget-object v4, p0, Llp$1;->c:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    iget-boolean v5, p0, Llp$1;->h:Z

    iget-object v6, p0, Llp$1;->f:Ljava/lang/String;

    invoke-static/range {v0 .. v6}, Llp;->a(Landroid/app/Activity;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;IZLcom/bestbuy/android/api/lib/models/dnm/DNMProduct;ZLjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 508
    sget-object v1, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->a:Landroid/widget/LinearLayout;

    invoke-virtual {v1}, Landroid/widget/LinearLayout;->removeAllViewsInLayout()V

    .line 509
    sget-object v1, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->a:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v0}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    goto/16 :goto_1

    .line 511
    :cond_b
    new-instance v0, Llb;

    iget-object v1, p0, Llp$1;->g:Landroid/app/Activity;

    const v2, 0x7f080224

    const v3, 0x7f080222

    const v4, 0x7f080225

    const v5, 0x7f080223

    iget-boolean v6, p0, Llp$1;->h:Z

    iget-object v7, p0, Llp$1;->c:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    iget-object v8, p0, Llp$1;->e:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-direct/range {v0 .. v8}, Llb;-><init>(Landroid/content/Context;IIIIZLcom/bestbuy/android/api/lib/models/dnm/DNMProduct;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)V

    move-object v7, v0

    goto/16 :goto_1

    .line 513
    :cond_c
    new-instance v0, Llb;

    iget-object v1, p0, Llp$1;->g:Landroid/app/Activity;

    const v2, 0x7f080224

    const v3, 0x7f080222

    const v4, 0x7f080225

    const v5, 0x7f080223

    iget-boolean v6, p0, Llp$1;->h:Z

    iget-object v7, p0, Llp$1;->c:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    iget-object v8, p0, Llp$1;->e:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-direct/range {v0 .. v8}, Llb;-><init>(Landroid/content/Context;IIIIZLcom/bestbuy/android/api/lib/models/dnm/DNMProduct;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)V

    move-object v7, v0

    goto/16 :goto_1
.end method
