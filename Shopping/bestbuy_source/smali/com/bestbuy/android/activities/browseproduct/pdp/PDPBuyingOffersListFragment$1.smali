.class Lcom/bestbuy/android/activities/browseproduct/pdp/PDPBuyingOffersListFragment$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/browseproduct/pdp/PDPBuyingOffersListFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPBuyingOffersListFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPBuyingOffersListFragment;)V
    .locals 0

    .prologue
    .line 59
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPBuyingOffersListFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPBuyingOffersListFragment;

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
    .line 63
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPBuyingOffersListFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPBuyingOffersListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPBuyingOffersListFragment;->a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPBuyingOffersListFragment;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0, p3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/product/ProductOffer;

    .line 64
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "http://www.bestbuy.com/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/product/ProductOffer;->getUrl()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 65
    new-instance v1, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    invoke-direct {v1}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;-><init>()V

    .line 66
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 67
    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPBuyingOffersListFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPBuyingOffersListFragment;

    invoke-virtual {v3}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPBuyingOffersListFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f080055

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3, v0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 68
    invoke-virtual {v1, v2}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->setArguments(Landroid/os/Bundle;)V

    .line 69
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPBuyingOffersListFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPBuyingOffersListFragment;

    invoke-static {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPBuyingOffersListFragment;->a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPBuyingOffersListFragment;Landroid/support/v4/app/Fragment;)V

    .line 70
    return-void
.end method
