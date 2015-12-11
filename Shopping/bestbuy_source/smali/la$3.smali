.class Lla$3;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


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
    .line 157
    iput-object p1, p0, Lla$3;->a:Lla;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)V"
        }
    .end annotation

    .prologue
    const/4 v9, 0x0

    .line 160
    move v8, v9

    :goto_0
    iget-object v0, p0, Lla$3;->a:Lla;

    invoke-static {v0}, Lla;->i(Lla;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v8, v0, :cond_4

    .line 161
    iget-object v0, p0, Lla$3;->a:Lla;

    invoke-static {v0}, Lla;->j(Lla;)[Ljava/lang/String;

    move-result-object v0

    aget-object v1, v0, p3

    iget-object v0, p0, Lla$3;->a:Lla;

    invoke-static {v0}, Lla;->i(Lla;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0, v8}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getUuid()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 162
    iget-object v1, p0, Lla$3;->a:Lla;

    iget-object v0, p0, Lla$3;->a:Lla;

    invoke-static {v0}, Lla;->a(Lla;)Ljava/util/HashMap;

    move-result-object v0

    const-string v2, "sku"

    invoke-virtual {v0, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-static {v1, v0}, Lla;->a(Lla;Ljava/lang/String;)Ljava/lang/String;

    .line 163
    iget-object v0, p0, Lla$3;->a:Lla;

    invoke-static {v0}, Lla;->k(Lla;)Ljava/util/HashMap;

    move-result-object v0

    iget-object v1, p0, Lla$3;->a:Lla;

    invoke-static {v1}, Lla;->j(Lla;)[Ljava/lang/String;

    move-result-object v1

    aget-object v1, v1, p3

    iget-object v2, p0, Lla$3;->a:Lla;

    invoke-static {v2}, Lla;->d(Lla;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 164
    iget-object v1, p0, Lla$3;->a:Lla;

    iget-object v0, p0, Lla$3;->a:Lla;

    invoke-static {v0}, Lla;->a(Lla;)Ljava/util/HashMap;

    move-result-object v0

    const-string v2, "Product"

    invoke-virtual {v0, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-static {v1, v0}, Lla;->a(Lla;Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;)Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    .line 165
    iget-object v1, p0, Lla$3;->a:Lla;

    iget-object v0, p0, Lla$3;->a:Lla;

    invoke-static {v0}, Lla;->a(Lla;)Ljava/util/HashMap;

    move-result-object v0

    const-string v2, "isFromDNM"

    invoke-virtual {v0, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    invoke-static {v1, v0}, Lla;->a(Lla;Z)Z

    .line 166
    iget-object v0, p0, Lla$3;->a:Lla;

    invoke-static {v0}, Lla;->b(Lla;)Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lla$3;->a:Lla;

    invoke-static {v0}, Lla;->b(Lla;)Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getAttributes()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lla$3;->a:Lla;

    invoke-static {v0}, Lla;->b(Lla;)Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getAttributes()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;->isMarketplace()Z

    move-result v0

    if-nez v0, :cond_1

    :cond_0
    iget-object v0, p0, Lla$3;->a:Lla;

    invoke-static {v0}, Lla;->l(Lla;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 167
    :cond_1
    iget-object v0, p0, Lla$3;->a:Lla;

    invoke-virtual {v0}, Lla;->dismiss()V

    .line 168
    iget-object v0, p0, Lla$3;->a:Lla;

    invoke-static {v0}, Lla;->c(Lla;)V

    .line 160
    :cond_2
    :goto_1
    add-int/lit8 v0, v8, 0x1

    move v8, v0

    goto/16 :goto_0

    .line 170
    :cond_3
    iget-object v0, p0, Lla$3;->a:Lla;

    invoke-virtual {v0}, Lla;->dismiss()V

    .line 171
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lnb;->j(Z)V

    .line 172
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 173
    const-string v1, "bb.addToList"

    const-string v2, "1"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 174
    const-string v1, "&&products"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, ";"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lla$3;->a:Lla;

    invoke-static {v3}, Lla;->d(Lla;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ";;;;evar48=PDH-WL"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 175
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

    .line 176
    new-instance v0, Liy;

    iget-object v1, p0, Lla$3;->a:Lla;

    invoke-static {v1}, Lla;->e(Lla;)Landroid/content/Context;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/activities/home/HomeActivity;

    iget-object v2, p0, Lla$3;->a:Lla;

    invoke-static {v2}, Lla;->f(Lla;)Landroid/support/v4/app/Fragment;

    move-result-object v2

    check-cast v2, Lcom/bestbuy/android/base/BBYBaseFragment;

    iget-object v3, p0, Lla$3;->a:Lla;

    invoke-static {v3}, Lla;->g(Lla;)Landroid/view/View;

    move-result-object v3

    iget-object v4, p0, Lla$3;->a:Lla;

    invoke-static {v4}, Lla;->j(Lla;)[Ljava/lang/String;

    move-result-object v4

    aget-object v4, v4, p3

    iget-object v5, p0, Lla$3;->a:Lla;

    invoke-static {v5}, Lla;->d(Lla;)Ljava/lang/String;

    move-result-object v5

    iget-object v6, p0, Lla$3;->a:Lla;

    invoke-static {v6}, Lla;->i(Lla;)Ljava/util/ArrayList;

    move-result-object v6

    invoke-virtual {v6, v8}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v6}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getType()Ljava/lang/String;

    move-result-object v6

    const-string v7, "1"

    invoke-direct/range {v0 .. v7}, Liy;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    sget-object v1, Lnb;->g:Ljava/util/concurrent/Executor;

    new-array v2, v9, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Liy;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_1

    .line 181
    :cond_4
    return-void
.end method
