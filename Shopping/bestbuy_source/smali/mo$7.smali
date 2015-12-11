.class final Lmo$7;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lmo;->a(Landroid/content/Context;Lcom/bestbuy/android/base/BBYBaseFragment;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;Lcom/bestbuy/android/api/lib/models/registry/Entities;Lmp;Landroid/view/View;Landroid/widget/LinearLayout;Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;Z)V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

.field final synthetic b:Lcom/bestbuy/android/base/BBYBaseFragment;

.field final synthetic c:Landroid/content/Context;

.field final synthetic d:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

.field final synthetic e:Lcom/bestbuy/android/api/lib/models/registry/Entities;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/content/Context;Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;Lcom/bestbuy/android/api/lib/models/registry/Entities;)V
    .locals 0

    .prologue
    .line 265
    iput-object p1, p0, Lmo$7;->a:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    iput-object p2, p0, Lmo$7;->b:Lcom/bestbuy/android/base/BBYBaseFragment;

    iput-object p3, p0, Lmo$7;->c:Landroid/content/Context;

    iput-object p4, p0, Lmo$7;->d:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    iput-object p5, p0, Lmo$7;->e:Lcom/bestbuy/android/api/lib/models/registry/Entities;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 8

    .prologue
    .line 268
    iget-object v0, p0, Lmo$7;->a:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getButtonState()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;->isCommerceUnavailable()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 269
    iget-object v0, p0, Lmo$7;->b:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lmo$7;->b:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 270
    iget-object v0, p0, Lmo$7;->b:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    iget-object v1, p0, Lmo$7;->c:Landroid/content/Context;

    check-cast v1, Landroid/app/Activity;

    const v2, 0x7f08009f

    invoke-virtual {v1, v2}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->b(Ljava/lang/String;)V

    .line 279
    :cond_0
    :goto_0
    return-void

    .line 273
    :cond_1
    iget-object v0, p0, Lmo$7;->b:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->c()Landroid/view/View;

    move-result-object v3

    .line 274
    if-eqz v3, :cond_2

    .line 275
    invoke-virtual {v3}, Landroid/view/View;->bringToFront()V

    .line 276
    :cond_2
    iget-object v0, p0, Lmo$7;->d:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getType()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lnk;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 277
    new-instance v0, Lin;

    iget-object v1, p0, Lmo$7;->c:Landroid/content/Context;

    check-cast v1, Landroid/app/Activity;

    iget-object v2, p0, Lmo$7;->b:Lcom/bestbuy/android/base/BBYBaseFragment;

    iget-object v4, p0, Lmo$7;->a:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSkuId()Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lmo$7;->d:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getUuid()Ljava/lang/String;

    move-result-object v5

    iget-object v6, p0, Lmo$7;->e:Lcom/bestbuy/android/api/lib/models/registry/Entities;

    invoke-virtual {v6}, Lcom/bestbuy/android/api/lib/models/registry/Entities;->getUuid()Ljava/lang/String;

    move-result-object v6

    invoke-direct/range {v0 .. v7}, Lin;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lin;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0
.end method
