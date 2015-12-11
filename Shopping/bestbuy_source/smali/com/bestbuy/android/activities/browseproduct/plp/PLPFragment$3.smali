.class Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$3;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)V
    .locals 0

    .prologue
    .line 597
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$3;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 8
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
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 601
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$3;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->a(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)Landroid/widget/RelativeLayout;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 602
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$3;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->a(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)Landroid/widget/RelativeLayout;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 603
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$3;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->b(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 604
    if-lt p3, v5, :cond_4

    .line 605
    add-int/lit8 p3, p3, -0x1

    .line 610
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$3;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->c(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0, p3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    move-object v3, v0

    check-cast v3, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    .line 611
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$3;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 612
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$3;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->e(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "Products"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 613
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$3;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    iget-object v0, v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v1, "productsclickmostpopular"

    const-string v2, "product"

    invoke-virtual {v0, v1, v2, v3}, Lcom/bestbuy/android/activities/home/HomeActivity;->sendRecommendations(Ljava/lang/String;Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)V

    .line 618
    :cond_2
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$3;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    iget-object v0, v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0, v4}, Lcom/bestbuy/android/activities/home/HomeActivity;->setStoreAvailabilityVisible(Z)V

    .line 619
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v0

    const-string v1, "availability_storeid"

    const-string v2, ""

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 620
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$3;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    iget-object v0, v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSkuId()Ljava/lang/String;

    move-result-object v1

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, ""

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v3

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getProductId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v6, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    iget-object v6, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$3;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    invoke-static {v6}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->f(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)Z

    move-result v6

    if-nez v6, :cond_3

    iget-object v6, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$3;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    invoke-static {v6}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->g(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)Z

    move-result v6

    if-eqz v6, :cond_6

    :cond_3
    :goto_1
    invoke-virtual/range {v0 .. v5}, Lcom/bestbuy/android/activities/home/HomeActivity;->openPDP(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V

    .line 621
    :goto_2
    return-void

    .line 606
    :cond_4
    if-nez p3, :cond_1

    goto :goto_2

    .line 614
    :cond_5
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$3;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->e(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "Cart"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 615
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$3;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    iget-object v0, v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v1, "cartclickmostpopular"

    const-string v2, "cart"

    invoke-virtual {v0, v1, v2, v3}, Lcom/bestbuy/android/activities/home/HomeActivity;->sendRecommendations(Ljava/lang/String;Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)V

    goto :goto_0

    :cond_6
    move v5, v4

    .line 620
    goto :goto_1
.end method
