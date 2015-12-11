.class Lla$4;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lla;->b()V
.end annotation


# instance fields
.field final synthetic a:Lla;


# direct methods
.method constructor <init>(Lla;)V
    .locals 0

    .prologue
    .line 211
    iput-object p1, p0, Lla$4;->a:Lla;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5

    .prologue
    const v4, 0x7f0c0033

    .line 214
    iget-object v0, p0, Lla$4;->a:Lla;

    invoke-virtual {v0}, Lla;->dismiss()V

    .line 215
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 216
    const-string v1, "bb.prevPageLink"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->f()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "pdp: Create a Registry"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 217
    sget-object v1, Llu;->bf:Ljava/lang/String;

    invoke-static {v1, v0}, Llu;->a(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 218
    invoke-static {}, Lfr;->c()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_3

    .line 219
    iget-object v1, p0, Lla$4;->a:Lla;

    iget-object v0, p0, Lla$4;->a:Lla;

    invoke-static {v0}, Lla;->a(Lla;)Ljava/util/HashMap;

    move-result-object v0

    const-string v2, "sku"

    invoke-virtual {v0, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-static {v1, v0}, Lla;->a(Lla;Ljava/lang/String;)Ljava/lang/String;

    .line 220
    new-instance v1, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;

    const/4 v0, 0x1

    iget-object v2, p0, Lla$4;->a:Lla;

    invoke-static {v2}, Lla;->d(Lla;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v0, v2}, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;-><init>(ZLjava/lang/String;)V

    .line 221
    iget-object v0, p0, Lla$4;->a:Lla;

    invoke-static {v0}, Lla;->f(Lla;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    instance-of v0, v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    if-eqz v0, :cond_2

    .line 222
    iget-object v0, p0, Lla$4;->a:Lla;

    invoke-static {v0}, Lla;->f(Lla;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->e()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 223
    instance-of v2, v0, Lcom/bestbuy/android/activities/home/HomeTabContainer;

    if-nez v2, :cond_0

    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/ProductTabContainer;

    if-eqz v0, :cond_1

    .line 224
    :cond_0
    iget-object v0, p0, Lla$4;->a:Lla;

    invoke-static {v0}, Lla;->e(Lla;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v2, "RegistryFragmentContainer"

    invoke-virtual {v0, v4, v1, v2}, Lcom/bestbuy/android/activities/home/HomeActivity;->addFragment(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)V

    .line 234
    :cond_1
    :goto_0
    return-void

    .line 225
    :cond_2
    iget-object v0, p0, Lla$4;->a:Lla;

    invoke-static {v0}, Lla;->f(Lla;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;

    if-eqz v0, :cond_1

    .line 226
    iget-object v0, p0, Lla$4;->a:Lla;

    invoke-static {v0}, Lla;->e(Lla;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v2, "RegistryFragmentContainer"

    invoke-virtual {v0, v4, v1, v2}, Lcom/bestbuy/android/activities/home/HomeActivity;->addFragment(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)V

    goto :goto_0

    .line 229
    :cond_3
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v1

    iget-object v0, p0, Lla$4;->a:Lla;

    invoke-static {v0}, Lla;->a(Lla;)Ljava/util/HashMap;

    move-result-object v0

    const-string v2, "sku"

    invoke-virtual {v0, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v1, v0}, Lnb;->k(Ljava/lang/String;)V

    .line 230
    new-instance v1, Landroid/content/Intent;

    iget-object v0, p0, Lla$4;->a:Lla;

    invoke-static {v0}, Lla;->e(Lla;)Landroid/content/Context;

    move-result-object v0

    const-class v2, Lcom/bestbuy/android/activities/mybby/MyBBYHomeActivity;

    invoke-direct {v1, v0, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 231
    iget-object v0, p0, Lla$4;->a:Lla;

    invoke-static {v0}, Lla;->e(Lla;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const/16 v2, 0x1ed4

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/activities/home/HomeActivity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 232
    iget-object v0, p0, Lla$4;->a:Lla;

    invoke-static {v0}, Lla;->e(Lla;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const v1, 0x7f04000e

    const v2, 0x7f040005

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/activities/home/HomeActivity;->overridePendingTransition(II)V

    goto :goto_0
.end method
