.class Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->a(Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;)V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;)V
    .locals 0

    .prologue
    .line 135
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 138
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;

    .line 139
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/Fragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BaseFragmentContainer;->d()V

    .line 140
    return-void
.end method
