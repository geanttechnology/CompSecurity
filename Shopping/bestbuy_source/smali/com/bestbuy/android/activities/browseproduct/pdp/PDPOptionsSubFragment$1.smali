.class Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionsSubFragment$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionsSubFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionsSubFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionsSubFragment;)V
    .locals 0

    .prologue
    .line 63
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionsSubFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionsSubFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 5
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
    const/4 v4, 0x0

    .line 67
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionsSubFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionsSubFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionsSubFragment;->a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionsSubFragment;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 68
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionsSubFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionsSubFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionsSubFragment;->b(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionsSubFragment;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0, p3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdp/ContractOption;

    .line 69
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionsSubFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionsSubFragment;

    invoke-virtual {v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionsSubFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v1

    .line 70
    new-instance v2, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/ContractOption;->getSku()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/ContractOption;->getProductId()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v2, v3, v0, v4}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;-><init>(Ljava/lang/String;Ljava/lang/String;Z)V

    move-object v0, v1

    .line 71
    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;->e()Z

    .line 72
    check-cast v1, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;

    invoke-virtual {v1, v2, v4}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 74
    :cond_0
    return-void
.end method
