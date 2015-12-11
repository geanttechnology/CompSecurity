.class Les$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Les;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

.field final synthetic b:Les;


# direct methods
.method constructor <init>(Les;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)V
    .locals 0

    .prologue
    .line 182
    iput-object p1, p0, Les$1;->b:Les;

    iput-object p2, p0, Les$1;->a:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 185
    iget-object v0, p0, Les$1;->b:Les;

    invoke-static {v0}, Les;->a(Les;)Landroid/app/Activity;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/home/HomeActivity;->setStoreAvailabilityVisible(Z)V

    .line 186
    iget-object v0, p0, Les$1;->b:Les;

    invoke-static {v0}, Les;->b(Les;)Lcom/bestbuy/android/base/BBYBaseFragment;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    .line 187
    new-instance v1, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPProductAvailabilityContainer;

    const-string v2, " Product Availability "

    invoke-direct {v1, v2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPProductAvailabilityContainer;-><init>(Ljava/lang/String;)V

    .line 188
    new-instance v2, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;

    iget-object v3, p0, Les$1;->a:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-direct {v2, v3}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;-><init>(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)V

    .line 189
    invoke-virtual {v0, v1, v4}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 190
    invoke-virtual {v1, v2, v4}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 191
    return-void
.end method
