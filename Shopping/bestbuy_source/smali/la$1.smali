.class Lla$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lla;->onCreate(Landroid/os/Bundle;)V
.end annotation


# instance fields
.field final synthetic a:Lla;


# direct methods
.method constructor <init>(Lla;)V
    .locals 0

    .prologue
    .line 88
    iput-object p1, p0, Lla$1;->a:Lla;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 8

    .prologue
    .line 91
    iget-object v1, p0, Lla$1;->a:Lla;

    iget-object v0, p0, Lla$1;->a:Lla;

    invoke-static {v0}, Lla;->a(Lla;)Ljava/util/HashMap;

    move-result-object v0

    const-string v2, "sku"

    invoke-virtual {v0, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-static {v1, v0}, Lla;->a(Lla;Ljava/lang/String;)Ljava/lang/String;

    .line 92
    iget-object v1, p0, Lla$1;->a:Lla;

    iget-object v0, p0, Lla$1;->a:Lla;

    invoke-static {v0}, Lla;->a(Lla;)Ljava/util/HashMap;

    move-result-object v0

    const-string v2, "Product"

    invoke-virtual {v0, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-static {v1, v0}, Lla;->a(Lla;Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;)Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    .line 93
    iget-object v1, p0, Lla$1;->a:Lla;

    iget-object v0, p0, Lla$1;->a:Lla;

    invoke-static {v0}, Lla;->a(Lla;)Ljava/util/HashMap;

    move-result-object v0

    const-string v2, "isFromDNM"

    invoke-virtual {v0, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    invoke-static {v1, v0}, Lla;->a(Lla;Z)Z

    .line 94
    iget-object v0, p0, Lla$1;->a:Lla;

    invoke-static {v0}, Lla;->b(Lla;)Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lla$1;->a:Lla;

    invoke-static {v0}, Lla;->b(Lla;)Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getAttributes()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lla$1;->a:Lla;

    invoke-static {v0}, Lla;->b(Lla;)Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getAttributes()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;->isMarketplace()Z

    move-result v0

    if-nez v0, :cond_2

    :cond_0
    iget-object v0, p0, Lla$1;->a:Lla;

    invoke-static {v0}, Lla;->b(Lla;)Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    move-result-object v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lla$1;->a:Lla;

    invoke-static {v0}, Lla;->b(Lla;)Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getCondition()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lla$1;->a:Lla;

    invoke-static {v0}, Lla;->b(Lla;)Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getCondition()Ljava/lang/String;

    move-result-object v0

    const-string v1, "openbox"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_2

    :cond_1
    iget-object v0, p0, Lla$1;->a:Lla;

    invoke-static {v0}, Lla;->b(Lla;)Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v0

    if-eqz v0, :cond_3

    iget-object v0, p0, Lla$1;->a:Lla;

    invoke-static {v0}, Lla;->b(Lla;)Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getProperties()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Properties;

    move-result-object v0

    if-eqz v0, :cond_3

    iget-object v0, p0, Lla$1;->a:Lla;

    invoke-static {v0}, Lla;->b(Lla;)Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getProperties()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Properties;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Properties;->getContractCondition()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_3

    .line 97
    :cond_2
    iget-object v0, p0, Lla$1;->a:Lla;

    invoke-virtual {v0}, Lla;->dismiss()V

    .line 98
    iget-object v0, p0, Lla$1;->a:Lla;

    invoke-static {v0}, Lla;->c(Lla;)V

    .line 110
    :goto_0
    return-void

    .line 100
    :cond_3
    iget-object v0, p0, Lla$1;->a:Lla;

    invoke-virtual {v0}, Lla;->dismiss()V

    .line 101
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lnb;->l(Z)V

    .line 102
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 103
    const-string v1, "bb.addToList"

    const-string v2, "1"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 104
    const-string v1, "&&products"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, ";"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lla$1;->a:Lla;

    invoke-static {v3}, Lla;->d(Lla;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ";;;;evar48=PDH-WR"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 105
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->f()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "pdp"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, v0}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 106
    new-instance v0, Liy;

    iget-object v1, p0, Lla$1;->a:Lla;

    invoke-static {v1}, Lla;->e(Lla;)Landroid/content/Context;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/activities/home/HomeActivity;

    iget-object v2, p0, Lla$1;->a:Lla;

    invoke-static {v2}, Lla;->f(Lla;)Landroid/support/v4/app/Fragment;

    move-result-object v2

    check-cast v2, Lcom/bestbuy/android/base/BBYBaseFragment;

    iget-object v3, p0, Lla$1;->a:Lla;

    invoke-static {v3}, Lla;->g(Lla;)Landroid/view/View;

    move-result-object v3

    iget-object v4, p0, Lla$1;->a:Lla;

    invoke-static {v4}, Lla;->h(Lla;)Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    move-result-object v4

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getUuid()Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lla$1;->a:Lla;

    invoke-static {v5}, Lla;->d(Lla;)Ljava/lang/String;

    move-result-object v5

    iget-object v6, p0, Lla$1;->a:Lla;

    invoke-static {v6}, Lla;->h(Lla;)Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    move-result-object v6

    invoke-virtual {v6}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getType()Ljava/lang/String;

    move-result-object v6

    const-string v7, "1"

    invoke-direct/range {v0 .. v7}, Liy;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    sget-object v1, Lnb;->g:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Liy;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_0
.end method
