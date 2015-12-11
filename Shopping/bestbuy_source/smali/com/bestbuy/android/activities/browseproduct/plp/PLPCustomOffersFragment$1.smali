.class Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;)V
    .locals 0

    .prologue
    .line 109
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 7
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

    .line 113
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->a(Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0, p3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    move-object v3, v0

    check-cast v3, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    .line 114
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;

    iget-object v0, v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getSkuId()Ljava/lang/String;

    move-result-object v1

    const-string v2, ""

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, ""

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v3

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getProductId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    move v5, v4

    invoke-virtual/range {v0 .. v5}, Lcom/bestbuy/android/activities/home/HomeActivity;->openPDP(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V

    .line 115
    return-void
.end method
