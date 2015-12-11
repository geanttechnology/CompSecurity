.class Lcom/bestbuy/android/activities/browseproduct/plp/PLPAccessoriesFragment$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/browseproduct/plp/PLPAccessoriesFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPAccessoriesFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/browseproduct/plp/PLPAccessoriesFragment;)V
    .locals 0

    .prologue
    .line 62
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPAccessoriesFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPAccessoriesFragment;

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
    .line 65
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPAccessoriesFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPAccessoriesFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPAccessoriesFragment;->a(Lcom/bestbuy/android/activities/browseproduct/plp/PLPAccessoriesFragment;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0, p3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    .line 66
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPAccessoriesFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPAccessoriesFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPAccessoriesFragment;->b(Lcom/bestbuy/android/activities/browseproduct/plp/PLPAccessoriesFragment;)Landroid/app/Activity;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSkuId()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, ""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getProductId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v0, v3}, Lcom/bestbuy/android/activities/home/HomeActivity;->openPDP(Ljava/lang/String;Ljava/lang/String;Z)V

    .line 82
    return-void
.end method
