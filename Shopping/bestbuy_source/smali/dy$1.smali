.class Ldy$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ldy;->instantiateItem(Landroid/view/ViewGroup;I)Ljava/lang/Object;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

.field final synthetic b:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

.field final synthetic c:Ldy;


# direct methods
.method constructor <init>(Ldy;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)V
    .locals 0

    .prologue
    .line 146
    iput-object p1, p0, Ldy$1;->c:Ldy;

    iput-object p2, p0, Ldy$1;->a:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    iput-object p3, p0, Ldy$1;->b:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 13

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 150
    iget-object v0, p0, Ldy$1;->c:Ldy;

    invoke-static {v0}, Ldy;->a(Ldy;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    instance-of v0, v0, Lcom/bestbuy/android/activities/cart/MyCartFragment;

    if-eqz v0, :cond_1

    .line 151
    iget-object v0, p0, Ldy$1;->c:Ldy;

    invoke-static {v0}, Ldy;->b(Ldy;)Landroid/app/Activity;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getCurrentActionBarTitle()Ljava/lang/String;

    move-result-object v7

    .line 152
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;

    iget-object v1, p0, Ldy$1;->a:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getSkuId()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, ""

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v5, p0, Ldy$1;->a:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getProductId()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    iget-object v5, p0, Ldy$1;->b:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    const-string v6, "Checkout: Cart \u2013 Empty"

    invoke-direct/range {v0 .. v6}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;-><init>(Ljava/lang/String;Ljava/lang/String;ZZLcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;Ljava/lang/String;)V

    .line 153
    new-instance v2, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;

    invoke-direct {v2, v7}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;-><init>(Ljava/lang/String;)V

    .line 154
    iget-object v1, p0, Ldy$1;->c:Ldy;

    invoke-static {v1}, Ldy;->b(Ldy;)Landroid/app/Activity;

    move-result-object v1

    check-cast v1, Landroid/support/v4/app/FragmentActivity;

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    const v3, 0x7f0c0033

    invoke-virtual {v1, v3}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v1

    .line 155
    instance-of v3, v1, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    if-eqz v3, :cond_0

    .line 156
    check-cast v1, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    .line 157
    invoke-virtual {v1}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->b()Landroid/support/v4/app/FragmentTabHost;

    move-result-object v3

    invoke-virtual {v3}, Landroid/support/v4/app/FragmentTabHost;->getCurrentTab()I

    move-result v3

    packed-switch v3, :pswitch_data_0

    .line 163
    :goto_0
    :pswitch_0
    new-instance v3, Landroid/os/Handler;

    invoke-direct {v3}, Landroid/os/Handler;-><init>()V

    new-instance v4, Ldy$1$1;

    invoke-direct {v4, p0, v1, v2, v0}, Ldy$1$1;-><init>(Ldy$1;Lcom/bestbuy/android/activities/home/HomeTabFragment;Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;)V

    const-wide/16 v0, 0x1f4

    invoke-virtual {v3, v4, v0, v1}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 172
    :cond_0
    iget-object v0, p0, Ldy$1;->c:Ldy;

    invoke-static {v0}, Ldy;->b(Ldy;)Landroid/app/Activity;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v1, "cartclickmostpopular"

    iget-object v2, p0, Ldy$1;->c:Ldy;

    invoke-static {v2}, Ldy;->c(Ldy;)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Ldy$1;->b:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v0, v1, v2, v3}, Lcom/bestbuy/android/activities/home/HomeActivity;->sendRecommendations(Ljava/lang/String;Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)V

    .line 207
    :goto_1
    return-void

    .line 160
    :pswitch_1
    invoke-virtual {v1, v4}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->a(I)V

    goto :goto_0

    .line 174
    :cond_1
    iget-object v0, p0, Ldy$1;->c:Ldy;

    invoke-static {v0}, Ldy;->c(Ldy;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 175
    iget-object v0, p0, Ldy$1;->b:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSkuId()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Ldy$1;->b:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSkuId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_2

    .line 176
    iget-object v0, p0, Ldy$1;->c:Ldy;

    invoke-static {v0}, Ldy;->b(Ldy;)Landroid/app/Activity;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/activities/home/HomeActivity;

    iget-object v0, p0, Ldy$1;->b:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSkuId()Ljava/lang/String;

    move-result-object v2

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, ""

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v4, p0, Ldy$1;->a:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getProductId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    iget-object v6, p0, Ldy$1;->b:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    iget-object v0, p0, Ldy$1;->c:Ldy;

    invoke-static {v0}, Ldy;->c(Ldy;)Ljava/lang/String;

    move-result-object v7

    const-string v8, ""

    move v5, v3

    invoke-virtual/range {v1 .. v8}, Lcom/bestbuy/android/activities/home/HomeActivity;->openPDP(Ljava/lang/String;ZLjava/lang/String;ZLcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 178
    :cond_2
    iget-object v0, p0, Ldy$1;->c:Ldy;

    invoke-static {v0}, Ldy;->b(Ldy;)Landroid/app/Activity;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/activities/home/HomeActivity;

    iget-object v0, p0, Ldy$1;->a:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getSkuId()Ljava/lang/String;

    move-result-object v2

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, ""

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v4, p0, Ldy$1;->a:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getProductId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    iget-object v6, p0, Ldy$1;->b:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    iget-object v0, p0, Ldy$1;->c:Ldy;

    invoke-static {v0}, Ldy;->c(Ldy;)Ljava/lang/String;

    move-result-object v7

    const-string v8, ""

    move v5, v3

    invoke-virtual/range {v1 .. v8}, Lcom/bestbuy/android/activities/home/HomeActivity;->openPDP(Ljava/lang/String;ZLjava/lang/String;ZLcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_1

    .line 180
    :cond_3
    iget-object v0, p0, Ldy$1;->c:Ldy;

    invoke-static {v0}, Ldy;->c(Ldy;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "customeralsobought"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 181
    iget-object v0, p0, Ldy$1;->c:Ldy;

    invoke-static {v0}, Ldy;->b(Ldy;)Landroid/app/Activity;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v1, "clickcustomeralsobought"

    iget-object v2, p0, Ldy$1;->c:Ldy;

    invoke-static {v2}, Ldy;->c(Ldy;)Ljava/lang/String;

    move-result-object v2

    iget-object v5, p0, Ldy$1;->b:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v0, v1, v2, v5}, Lcom/bestbuy/android/activities/home/HomeActivity;->sendRecommendations(Ljava/lang/String;Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)V

    .line 194
    :cond_4
    :goto_2
    iget-object v0, p0, Ldy$1;->b:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSkuId()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_b

    iget-object v0, p0, Ldy$1;->b:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSkuId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_b

    .line 195
    iget-object v0, p0, Ldy$1;->c:Ldy;

    iget-object v1, p0, Ldy$1;->b:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSkuId()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Ldy;->a(Ldy;Ljava/lang/String;)Ljava/lang/String;

    .line 199
    :goto_3
    iget-object v0, p0, Ldy$1;->c:Ldy;

    invoke-static {v0}, Ldy;->c(Ldy;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "customeralsoviewed"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_5

    iget-object v0, p0, Ldy$1;->c:Ldy;

    invoke-static {v0}, Ldy;->c(Ldy;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "customeralsobought"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_c

    .line 200
    :cond_5
    iget-object v0, p0, Ldy$1;->c:Ldy;

    invoke-static {v0}, Ldy;->b(Ldy;)Landroid/app/Activity;

    move-result-object v5

    check-cast v5, Lcom/bestbuy/android/activities/home/HomeActivity;

    iget-object v0, p0, Ldy$1;->b:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSkuId()Ljava/lang/String;

    move-result-object v6

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, ""

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Ldy$1;->a:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getProductId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    iget-object v10, p0, Ldy$1;->b:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    iget-object v0, p0, Ldy$1;->c:Ldy;

    invoke-static {v0}, Ldy;->c(Ldy;)Ljava/lang/String;

    move-result-object v11

    iget-object v0, p0, Ldy$1;->c:Ldy;

    invoke-static {v0}, Ldy;->d(Ldy;)Ljava/lang/String;

    move-result-object v12

    move v7, v3

    move v9, v4

    invoke-virtual/range {v5 .. v12}, Lcom/bestbuy/android/activities/home/HomeActivity;->openPDP(Ljava/lang/String;ZLjava/lang/String;ZLcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_1

    .line 182
    :cond_6
    iget-object v0, p0, Ldy$1;->c:Ldy;

    invoke-static {v0}, Ldy;->c(Ldy;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "customeralsoviewed"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_7

    .line 183
    iget-object v0, p0, Ldy$1;->c:Ldy;

    invoke-static {v0}, Ldy;->b(Ldy;)Landroid/app/Activity;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v1, "clickcustomeralsoviewed"

    iget-object v2, p0, Ldy$1;->c:Ldy;

    invoke-static {v2}, Ldy;->c(Ldy;)Ljava/lang/String;

    move-result-object v2

    iget-object v5, p0, Ldy$1;->b:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v0, v1, v2, v5}, Lcom/bestbuy/android/activities/home/HomeActivity;->sendRecommendations(Ljava/lang/String;Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)V

    goto/16 :goto_2

    .line 184
    :cond_7
    iget-object v0, p0, Ldy$1;->c:Ldy;

    invoke-static {v0}, Ldy;->c(Ldy;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "product"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_8

    .line 185
    iget-object v0, p0, Ldy$1;->c:Ldy;

    invoke-static {v0}, Ldy;->b(Ldy;)Landroid/app/Activity;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v1, "productsclickmostpopular"

    iget-object v2, p0, Ldy$1;->c:Ldy;

    invoke-static {v2}, Ldy;->c(Ldy;)Ljava/lang/String;

    move-result-object v2

    iget-object v5, p0, Ldy$1;->b:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v0, v1, v2, v5}, Lcom/bestbuy/android/activities/home/HomeActivity;->sendRecommendations(Ljava/lang/String;Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)V

    goto/16 :goto_2

    .line 186
    :cond_8
    iget-object v0, p0, Ldy$1;->c:Ldy;

    invoke-static {v0}, Ldy;->c(Ldy;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "stores"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_9

    .line 187
    iget-object v0, p0, Ldy$1;->c:Ldy;

    invoke-static {v0}, Ldy;->b(Ldy;)Landroid/app/Activity;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v1, "storesclickmostpopular"

    iget-object v2, p0, Ldy$1;->c:Ldy;

    invoke-static {v2}, Ldy;->c(Ldy;)Ljava/lang/String;

    move-result-object v2

    iget-object v5, p0, Ldy$1;->b:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v0, v1, v2, v5}, Lcom/bestbuy/android/activities/home/HomeActivity;->sendRecommendations(Ljava/lang/String;Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)V

    goto/16 :goto_2

    .line 188
    :cond_9
    iget-object v0, p0, Ldy$1;->c:Ldy;

    invoke-static {v0}, Ldy;->c(Ldy;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "recentlyviewed"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_a

    .line 189
    iget-object v0, p0, Ldy$1;->c:Ldy;

    invoke-static {v0}, Ldy;->b(Ldy;)Landroid/app/Activity;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v1, "homeclickrecentlyviewed"

    iget-object v2, p0, Ldy$1;->c:Ldy;

    invoke-static {v2}, Ldy;->c(Ldy;)Ljava/lang/String;

    move-result-object v2

    iget-object v5, p0, Ldy$1;->b:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v0, v1, v2, v5}, Lcom/bestbuy/android/activities/home/HomeActivity;->sendRecommendations(Ljava/lang/String;Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)V

    goto/16 :goto_2

    .line 190
    :cond_a
    iget-object v0, p0, Ldy$1;->c:Ldy;

    invoke-static {v0}, Ldy;->c(Ldy;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "GHP"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 191
    iget-object v0, p0, Ldy$1;->c:Ldy;

    invoke-static {v0}, Ldy;->b(Ldy;)Landroid/app/Activity;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v1, "homeclicktrendingnow"

    iget-object v2, p0, Ldy$1;->c:Ldy;

    invoke-static {v2}, Ldy;->c(Ldy;)Ljava/lang/String;

    move-result-object v2

    iget-object v5, p0, Ldy$1;->b:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v0, v1, v2, v5}, Lcom/bestbuy/android/activities/home/HomeActivity;->sendRecommendations(Ljava/lang/String;Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)V

    goto/16 :goto_2

    .line 197
    :cond_b
    iget-object v0, p0, Ldy$1;->c:Ldy;

    iget-object v1, p0, Ldy$1;->a:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getSkuId()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Ldy;->a(Ldy;Ljava/lang/String;)Ljava/lang/String;

    goto/16 :goto_3

    .line 202
    :cond_c
    iget-object v0, p0, Ldy$1;->c:Ldy;

    invoke-static {v0}, Ldy;->b(Ldy;)Landroid/app/Activity;

    move-result-object v5

    check-cast v5, Lcom/bestbuy/android/activities/home/HomeActivity;

    iget-object v0, p0, Ldy$1;->b:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSkuId()Ljava/lang/String;

    move-result-object v6

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, ""

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Ldy$1;->a:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getProductId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    iget-object v10, p0, Ldy$1;->b:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    iget-object v0, p0, Ldy$1;->c:Ldy;

    invoke-static {v0}, Ldy;->c(Ldy;)Ljava/lang/String;

    move-result-object v11

    const-string v12, ""

    move v7, v3

    move v9, v4

    invoke-virtual/range {v5 .. v12}, Lcom/bestbuy/android/activities/home/HomeActivity;->openPDP(Ljava/lang/String;ZLjava/lang/String;ZLcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_1

    .line 157
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method
