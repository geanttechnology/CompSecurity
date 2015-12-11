.class Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment$7;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->b()V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;)V
    .locals 0

    .prologue
    .line 388
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment$7;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5

    .prologue
    const/4 v4, 0x0

    const/4 v3, 0x1

    .line 391
    const-string v0, "ProductAvailabilityFragment"

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment$7;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;)Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    move-result-object v1

    const/4 v2, 0x0

    invoke-static {v0, v4, v1, v4, v2}, Lkb;->a(Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;Z)Lcom/bestbuy/android/base/BBYBaseFragment;

    move-result-object v2

    .line 392
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment$7;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;

    iget-object v0, v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->d:Landroid/app/Activity;

    check-cast v0, Landroid/support/v4/app/FragmentActivity;

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const v1, 0x7f0c0033

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v1

    .line 393
    instance-of v0, v1, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    if-eqz v0, :cond_0

    move-object v0, v1

    .line 394
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    .line 395
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->e()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 396
    check-cast v0, Lcom/bestbuy/android/activities/BaseTabContainer;

    invoke-virtual {v0, v2, v3}, Lcom/bestbuy/android/activities/BaseTabContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 398
    :cond_0
    instance-of v0, v1, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;

    if-eqz v0, :cond_1

    move-object v0, v1

    .line 399
    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;->b()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;

    .line 400
    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;

    if-eqz v0, :cond_1

    .line 401
    check-cast v1, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;

    invoke-virtual {v1, v2, v3}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 404
    :cond_1
    return-void
.end method
