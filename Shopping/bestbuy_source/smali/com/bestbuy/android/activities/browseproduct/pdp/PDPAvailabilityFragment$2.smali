.class Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->c()V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

.field final synthetic b:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Pickup;

.field final synthetic c:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Pickup;)V
    .locals 0

    .prologue
    .line 207
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment$2;->c:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;

    iput-object p2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment$2;->a:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    iput-object p3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment$2;->b:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Pickup;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5

    .prologue
    const/4 v4, 0x0

    const/4 v3, 0x1

    .line 210
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment$2;->a:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment$2;->a:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getButtonState()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;

    move-result-object v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment$2;->a:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getButtonState()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;->getAvailabilityType()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment$2;->a:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getButtonState()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;->getAvailabilityType()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment$2;->c:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;

    const v2, 0x7f0802ac

    invoke-virtual {v1, v2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 211
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment$2;->b:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Pickup;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment$2;->b:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Pickup;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Pickup;->getCheckStoresLink()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CheckShipLink;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment$2;->b:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Pickup;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Pickup;->getCheckStoresLink()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CheckShipLink;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CheckShipLink;->getUrl()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment$2;->b:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Pickup;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Pickup;->getCheckStoresLink()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CheckShipLink;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CheckShipLink;->getUrl()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 212
    new-instance v0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    invoke-direct {v0, v3, v3}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;-><init>(ZZ)V

    .line 213
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 214
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment$2;->c:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;

    invoke-virtual {v2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f080055

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "http://www.bestbuy.com"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment$2;->b:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Pickup;

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Pickup;->getCheckStoresLink()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CheckShipLink;

    move-result-object v4

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CheckShipLink;->getUrl()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 215
    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->setArguments(Landroid/os/Bundle;)V

    .line 216
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment$2;->c:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;

    invoke-static {v1, v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;Lcom/bestbuy/android/activities/mdot/MdotWebFragment;)V

    .line 234
    :cond_0
    :goto_0
    return-void

    .line 219
    :cond_1
    const-string v0, "ProductAvailabilityFragment"

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment$2;->c:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;)Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    move-result-object v1

    const/4 v2, 0x0

    invoke-static {v0, v4, v1, v4, v2}, Lkb;->a(Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;Z)Lcom/bestbuy/android/base/BBYBaseFragment;

    move-result-object v2

    .line 220
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment$2;->c:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;

    iget-object v0, v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->d:Landroid/app/Activity;

    check-cast v0, Landroid/support/v4/app/FragmentActivity;

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const v1, 0x7f0c0033

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v1

    .line 221
    instance-of v0, v1, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    if-eqz v0, :cond_2

    move-object v0, v1

    .line 222
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    .line 223
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->e()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 224
    check-cast v0, Lcom/bestbuy/android/activities/BaseTabContainer;

    invoke-virtual {v0, v2, v3}, Lcom/bestbuy/android/activities/BaseTabContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 227
    :cond_2
    instance-of v0, v1, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;

    if-eqz v0, :cond_0

    move-object v0, v1

    .line 228
    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;->b()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;

    .line 229
    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;

    if-eqz v0, :cond_0

    .line 230
    check-cast v1, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;

    invoke-virtual {v1, v2, v3}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    goto :goto_0
.end method
