.class final Lmo$3;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lmo;->a(Landroid/content/Context;Lcom/bestbuy/android/base/BBYBaseFragment;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;Lcom/bestbuy/android/api/lib/models/registry/Entities;Lmp;Landroid/view/View;Z)V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/base/BBYBaseFragment;

.field final synthetic b:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/base/BBYBaseFragment;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)V
    .locals 0

    .prologue
    .line 171
    iput-object p1, p0, Lmo$3;->a:Lcom/bestbuy/android/base/BBYBaseFragment;

    iput-object p2, p0, Lmo$3;->b:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 175
    iget-object v0, p0, Lmo$3;->a:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;

    if-eqz v0, :cond_0

    .line 176
    iget-object v0, p0, Lmo$3;->a:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;

    iget-object v1, p0, Lmo$3;->b:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSkuId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->a(Ljava/lang/String;)V

    .line 177
    :cond_0
    return-void
.end method
