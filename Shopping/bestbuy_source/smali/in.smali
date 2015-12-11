.class public Lin;
.super Lka;
.source "SourceFile"


# instance fields
.field private a:Ljava/lang/String;

.field private j:Ljava/lang/String;

.field private k:Ljava/lang/String;

.field private l:Ljava/lang/String;

.field private m:Ljava/lang/String;

.field private n:Ljava/lang/String;

.field private o:Ljava/lang/String;

.field private p:Ljava/lang/String;

.field private q:Lcom/bestbuy/android/api/lib/models/cart/CartResponse;

.field private r:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 46
    invoke-direct {p0, p1, p2}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 35
    const-string v0, ""

    iput-object v0, p0, Lin;->r:Ljava/lang/String;

    .line 47
    iput-object p3, p0, Lin;->g:Landroid/view/View;

    .line 48
    iput-object p4, p0, Lin;->a:Ljava/lang/String;

    .line 49
    iput-object p5, p0, Lin;->l:Ljava/lang/String;

    .line 50
    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 53
    invoke-direct {p0, p1, p2}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 35
    const-string v0, ""

    iput-object v0, p0, Lin;->r:Ljava/lang/String;

    .line 54
    iput-object p3, p0, Lin;->g:Landroid/view/View;

    .line 55
    iput-object p4, p0, Lin;->a:Ljava/lang/String;

    .line 56
    iput-object p5, p0, Lin;->n:Ljava/lang/String;

    .line 57
    iput-object p6, p0, Lin;->o:Ljava/lang/String;

    .line 58
    iput-object p7, p0, Lin;->p:Ljava/lang/String;

    .line 59
    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 62
    invoke-direct {p0, p1, p2}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 35
    const-string v0, ""

    iput-object v0, p0, Lin;->r:Ljava/lang/String;

    .line 63
    iput-object p3, p0, Lin;->g:Landroid/view/View;

    .line 64
    iput-object p4, p0, Lin;->a:Ljava/lang/String;

    .line 65
    iput-object p5, p0, Lin;->j:Ljava/lang/String;

    .line 66
    iput-object p6, p0, Lin;->k:Ljava/lang/String;

    .line 67
    iput-object p7, p0, Lin;->l:Ljava/lang/String;

    .line 68
    iput-object p8, p0, Lin;->m:Ljava/lang/String;

    .line 69
    return-void
.end method


# virtual methods
.method public a()V
    .locals 8

    .prologue
    .line 73
    iget-object v0, p0, Lin;->a:Ljava/lang/String;

    iget-object v1, p0, Lin;->j:Ljava/lang/String;

    iget-object v2, p0, Lin;->k:Ljava/lang/String;

    iget-object v3, p0, Lin;->l:Ljava/lang/String;

    iget-object v4, p0, Lin;->m:Ljava/lang/String;

    iget-object v5, p0, Lin;->n:Ljava/lang/String;

    iget-object v6, p0, Lin;->o:Ljava/lang/String;

    iget-object v7, p0, Lin;->p:Ljava/lang/String;

    invoke-static/range {v0 .. v7}, Lfs;->b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/cart/CartResponse;

    move-result-object v0

    iput-object v0, p0, Lin;->q:Lcom/bestbuy/android/api/lib/models/cart/CartResponse;

    .line 74
    return-void
.end method

.method public b()V
    .locals 5

    .prologue
    const/16 v4, 0x8

    .line 78
    iget-object v0, p0, Lin;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 79
    iget-object v0, p0, Lin;->g:Landroid/view/View;

    invoke-virtual {v0, v4}, Landroid/view/View;->setVisibility(I)V

    .line 81
    :cond_0
    iget-object v0, p0, Lin;->q:Lcom/bestbuy/android/api/lib/models/cart/CartResponse;

    if-eqz v0, :cond_8

    .line 82
    iget-object v0, p0, Lin;->q:Lcom/bestbuy/android/api/lib/models/cart/CartResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/cart/CartResponse;->isError()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 83
    iget-object v0, p0, Lin;->q:Lcom/bestbuy/android/api/lib/models/cart/CartResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/cart/CartResponse;->getMsg()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lin;->r:Ljava/lang/String;

    .line 84
    invoke-virtual {p0}, Lin;->c()V

    .line 118
    :cond_1
    :goto_0
    return-void

    .line 86
    :cond_2
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lnb;->e(Z)V

    .line 87
    iget-object v0, p0, Lin;->q:Lcom/bestbuy/android/api/lib/models/cart/CartResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/cart/CartResponse;->getQuantity()I

    move-result v0

    .line 88
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v1

    invoke-virtual {v1}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    iget-object v2, p0, Lin;->f:Landroid/app/Activity;

    invoke-virtual {v2}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f080031

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2, v0}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 89
    const/4 v1, 0x0

    .line 90
    iget-object v0, p0, Lin;->f:Landroid/app/Activity;

    instance-of v0, v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    if-eqz v0, :cond_9

    .line 91
    iget-object v0, p0, Lin;->f:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    .line 92
    const v2, 0x7f0c0033

    invoke-virtual {v0, v2}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 93
    instance-of v2, v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    if-eqz v2, :cond_9

    .line 94
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    .line 97
    :goto_1
    if-eqz v0, :cond_3

    .line 98
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->d()V

    .line 101
    :cond_3
    iget-object v0, p0, Lin;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;

    if-eqz v0, :cond_4

    iget-object v0, p0, Lin;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 102
    iget-object v0, p0, Lin;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->d()V

    goto :goto_0

    .line 103
    :cond_4
    iget-object v0, p0, Lin;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;

    if-eqz v0, :cond_5

    iget-object v0, p0, Lin;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_5

    .line 104
    iget-object v0, p0, Lin;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->b()V

    goto :goto_0

    .line 105
    :cond_5
    iget-object v0, p0, Lin;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    if-eqz v0, :cond_6

    iget-object v0, p0, Lin;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_6

    .line 106
    iget-object v0, p0, Lin;->g:Landroid/view/View;

    invoke-virtual {v0, v4}, Landroid/view/View;->setVisibility(I)V

    .line 107
    iget-object v0, p0, Lin;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    iget-object v1, p0, Lin;->a:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->a(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 108
    :cond_6
    iget-object v0, p0, Lin;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;

    if-eqz v0, :cond_7

    iget-object v0, p0, Lin;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_7

    .line 109
    iget-object v0, p0, Lin;->g:Landroid/view/View;

    invoke-virtual {v0, v4}, Landroid/view/View;->setVisibility(I)V

    .line 110
    iget-object v0, p0, Lin;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;

    iget-object v1, p0, Lin;->a:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->b(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 112
    :cond_7
    iget-object v0, p0, Lin;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lin;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 113
    iget-object v0, p0, Lin;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->b()V

    goto/16 :goto_0

    .line 116
    :cond_8
    invoke-virtual {p0}, Lin;->c()V

    goto/16 :goto_0

    :cond_9
    move-object v0, v1

    goto/16 :goto_1
.end method

.method public c()V
    .locals 3

    .prologue
    .line 123
    iget-object v0, p0, Lin;->r:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 124
    iget-object v0, p0, Lin;->r:Ljava/lang/String;

    const-string v1, "\\<[^>]*>"

    const-string v2, ""

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lin;->r:Ljava/lang/String;

    .line 126
    :cond_0
    iget-object v0, p0, Lin;->g:Landroid/view/View;

    if-eqz v0, :cond_1

    .line 127
    iget-object v0, p0, Lin;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 129
    :cond_1
    iget-object v0, p0, Lin;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lin;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 130
    iget-object v0, p0, Lin;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;

    iget-object v1, p0, Lin;->r:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->a(Ljava/lang/String;)V

    .line 139
    :cond_2
    :goto_0
    return-void

    .line 131
    :cond_3
    iget-object v0, p0, Lin;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;

    if-eqz v0, :cond_4

    iget-object v0, p0, Lin;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 132
    iget-object v0, p0, Lin;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;

    iget-object v1, p0, Lin;->r:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->b(Ljava/lang/String;)V

    goto :goto_0

    .line 133
    :cond_4
    iget-object v0, p0, Lin;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    if-eqz v0, :cond_5

    iget-object v0, p0, Lin;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_5

    .line 134
    iget-object v0, p0, Lin;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    iget-object v1, p0, Lin;->r:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->b(Ljava/lang/String;)V

    goto :goto_0

    .line 135
    :cond_5
    iget-object v0, p0, Lin;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;

    if-eqz v0, :cond_6

    iget-object v0, p0, Lin;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_6

    .line 136
    iget-object v0, p0, Lin;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;

    iget-object v1, p0, Lin;->r:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->c(Ljava/lang/String;)V

    goto :goto_0

    .line 137
    :cond_6
    iget-object v0, p0, Lin;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lin;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 138
    iget-object v0, p0, Lin;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;

    iget-object v1, p0, Lin;->r:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->d(Ljava/lang/String;)V

    goto :goto_0
.end method
