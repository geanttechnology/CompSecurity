.class Lla$2;
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
    .line 119
    iput-object p1, p0, Lla$2;->a:Lla;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5

    .prologue
    const v4, 0x7f0c0033

    .line 122
    iget-object v0, p0, Lla$2;->a:Lla;

    invoke-virtual {v0}, Lla;->dismiss()V

    .line 123
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 124
    const-string v1, "bb.prevPageLink"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->f()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "pdp: Create a Wishlist"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 125
    sget-object v1, Llu;->be:Ljava/lang/String;

    invoke-static {v1, v0}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 126
    invoke-static {}, Lfr;->c()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_2

    .line 127
    iget-object v1, p0, Lla$2;->a:Lla;

    iget-object v0, p0, Lla$2;->a:Lla;

    invoke-static {v0}, Lla;->a(Lla;)Ljava/util/HashMap;

    move-result-object v0

    const-string v2, "sku"

    invoke-virtual {v0, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-static {v1, v0}, Lla;->a(Lla;Ljava/lang/String;)Ljava/lang/String;

    .line 128
    new-instance v1, Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;

    const/4 v0, 0x1

    iget-object v2, p0, Lla$2;->a:Lla;

    invoke-static {v2}, Lla;->d(Lla;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v0, v2}, Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;-><init>(ZLjava/lang/String;)V

    .line 129
    iget-object v0, p0, Lla$2;->a:Lla;

    invoke-static {v0}, Lla;->f(Lla;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    instance-of v0, v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    if-eqz v0, :cond_1

    .line 130
    iget-object v0, p0, Lla$2;->a:Lla;

    invoke-static {v0}, Lla;->f(Lla;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->e()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 131
    instance-of v0, v0, Lcom/bestbuy/android/activities/BaseTabContainer;

    if-eqz v0, :cond_0

    .line 132
    iget-object v0, p0, Lla$2;->a:Lla;

    invoke-static {v0}, Lla;->e(Lla;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v2, "WishListFragmentContainer"

    invoke-virtual {v0, v4, v1, v2}, Lcom/bestbuy/android/activities/home/HomeActivity;->addFragment(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)V

    .line 142
    :cond_0
    :goto_0
    return-void

    .line 133
    :cond_1
    iget-object v0, p0, Lla$2;->a:Lla;

    invoke-static {v0}, Lla;->f(Lla;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;

    if-eqz v0, :cond_0

    .line 134
    iget-object v0, p0, Lla$2;->a:Lla;

    invoke-static {v0}, Lla;->e(Lla;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v2, "WishListFragmentContainer"

    invoke-virtual {v0, v4, v1, v2}, Lcom/bestbuy/android/activities/home/HomeActivity;->addFragment(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)V

    goto :goto_0

    .line 137
    :cond_2
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v1

    iget-object v0, p0, Lla$2;->a:Lla;

    invoke-static {v0}, Lla;->a(Lla;)Ljava/util/HashMap;

    move-result-object v0

    const-string v2, "sku"

    invoke-virtual {v0, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v1, v0}, Lnb;->k(Ljava/lang/String;)V

    .line 138
    new-instance v1, Landroid/content/Intent;

    iget-object v0, p0, Lla$2;->a:Lla;

    invoke-static {v0}, Lla;->e(Lla;)Landroid/content/Context;

    move-result-object v0

    const-class v2, Lcom/bestbuy/android/activities/mybby/MyBBYHomeActivity;

    invoke-direct {v1, v0, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 139
    iget-object v0, p0, Lla$2;->a:Lla;

    invoke-static {v0}, Lla;->e(Lla;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const/16 v2, 0x1ed3

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/activities/home/HomeActivity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 140
    iget-object v0, p0, Lla$2;->a:Lla;

    invoke-static {v0}, Lla;->e(Lla;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const v1, 0x7f04000e

    const v2, 0x7f040005

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/activities/home/HomeActivity;->overridePendingTransition(II)V

    goto :goto_0
.end method
