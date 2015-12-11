.class Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;)V
    .locals 0

    .prologue
    .line 96
    iput-object p1, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard$2;->a:Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;

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
    .line 100
    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard$2;->a:Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;

    invoke-static {v0}, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->a(Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0, p3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    .line 101
    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard$2;->a:Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;

    iget-object v0, v0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSkuId()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, ""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v4

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getProductId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x1

    const-string v6, "GHP"

    const-string v7, ""

    invoke-virtual/range {v0 .. v7}, Lcom/bestbuy/android/activities/home/HomeActivity;->openPDP(Ljava/lang/String;ZLjava/lang/String;ZLcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;Ljava/lang/String;Ljava/lang/String;)V

    .line 102
    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard$2;->a:Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;

    iget-object v0, v0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v1, "homeclickcustomeralsoviewed"

    const-string v2, "GHP"

    invoke-virtual {v0, v1, v2, v5}, Lcom/bestbuy/android/activities/home/HomeActivity;->sendRecommendations(Ljava/lang/String;Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)V

    .line 103
    return-void
.end method
