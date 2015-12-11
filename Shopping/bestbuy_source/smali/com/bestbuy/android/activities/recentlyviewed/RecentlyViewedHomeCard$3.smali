.class Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard$3;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/support/v4/view/ViewPager$OnPageChangeListener;


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
    .line 105
    iput-object p1, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard$3;->a:Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onPageScrollStateChanged(I)V
    .locals 0

    .prologue
    .line 139
    return-void
.end method

.method public onPageScrolled(IFI)V
    .locals 0

    .prologue
    .line 134
    return-void
.end method

.method public onPageSelected(I)V
    .locals 7

    .prologue
    const/16 v2, 0x8

    const/4 v6, 0x0

    .line 109
    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard$3;->a:Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;

    invoke-static {v0}, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->b(Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;)Ljava/util/ArrayList;

    move-result-object v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard$3;->a:Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;

    invoke-static {v0}, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->b(Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_2

    .line 110
    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard$3;->a:Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;

    invoke-static {v0}, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->c(Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;)Landroid/widget/LinearLayout;

    move-result-object v0

    invoke-virtual {v0, v6}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 111
    iget-object v1, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard$3;->a:Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;

    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard$3;->a:Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;

    invoke-static {v0}, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->b(Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-static {v1, v0}, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->a(Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    .line 112
    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard$3;->a:Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;

    invoke-static {v0}, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->d(Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 113
    iget-object v1, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard$3;->a:Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;

    invoke-static {v1}, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->e(Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;)Landroid/widget/ListView;

    move-result-object v1

    invoke-virtual {v1, v2}, Landroid/widget/ListView;->setVisibility(I)V

    .line 114
    iget-object v1, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard$3;->a:Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;

    invoke-static {v1}, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->f(Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;)Landroid/widget/RelativeLayout;

    move-result-object v1

    invoke-virtual {v1, v2}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 115
    iget-object v1, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard$3;->a:Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;

    invoke-static {v1}, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->g(Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;)Lhe;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 116
    iget-object v1, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard$3;->a:Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;

    invoke-static {v1}, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->g(Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;)Lhe;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Lhe;->cancel(Z)Z

    .line 118
    :cond_0
    iget-object v1, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard$3;->a:Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;

    invoke-static {v1}, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->h(Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;)Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    move-result-object v1

    if-eqz v1, :cond_1

    .line 119
    iget-object v1, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard$3;->a:Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;

    iget-object v1, v1, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->d:Landroid/app/Activity;

    check-cast v1, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v2, "homeloadrecentlyviewed"

    const-string v3, "GHP"

    iget-object v4, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard$3;->a:Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;

    iget-object v5, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard$3;->a:Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;

    invoke-static {v5}, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->b(Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;)Ljava/util/ArrayList;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->a(Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;Ljava/util/ArrayList;)Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard$3;->a:Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;

    invoke-static {v5}, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->h(Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;)Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    move-result-object v5

    invoke-virtual {v1, v2, v3, v4, v5}, Lcom/bestbuy/android/activities/home/HomeActivity;->sendRecommendations(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)V

    .line 121
    :cond_1
    if-nez p1, :cond_3

    .line 123
    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard$3;->a:Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;

    iget-object v1, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard$3;->a:Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;

    invoke-static {v1}, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->i(Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;)Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedResponse;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->a(Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedResponse;)V

    .line 129
    :cond_2
    :goto_0
    return-void

    .line 125
    :cond_3
    iget-object v1, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard$3;->a:Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;

    new-instance v2, Lhe;

    iget-object v3, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard$3;->a:Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;

    iget-object v3, v3, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->d:Landroid/app/Activity;

    iget-object v4, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard$3;->a:Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;

    iget-object v5, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard$3;->a:Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;

    invoke-static {v5}, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->j(Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;)Landroid/view/View;

    move-result-object v5

    invoke-direct {v2, v3, v4, v0, v5}, Lhe;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Ljava/lang/String;Landroid/view/View;)V

    invoke-static {v1, v2}, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->a(Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;Lhe;)Lhe;

    .line 126
    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard$3;->a:Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;

    invoke-static {v0}, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->g(Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;)Lhe;

    move-result-object v0

    new-array v1, v6, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lhe;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0
.end method
