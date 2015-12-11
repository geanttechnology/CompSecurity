.class Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;)V
    .locals 0

    .prologue
    .line 136
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5

    .prologue
    .line 140
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 141
    const-string v1, "bb.ratingsReviews"

    const-string v2, "1"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 142
    const-string v1, "bb.reviewsInteraction"

    const-string v2, "Ratings & Reviews: PDP: Tab"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 143
    const-string v1, "bb.prevPageLink"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;

    invoke-static {v3}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "pdp: reviews tab"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 144
    const-string v1, "&&products"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, ";"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;

    invoke-static {v3}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->b(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;)Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    move-result-object v3

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getSkuId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 145
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;

    invoke-static {v2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "pdp: reviews"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, v0}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 146
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;

    .line 147
    new-instance v1, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;

    invoke-static {v2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->b(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;)Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    move-result-object v2

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;

    invoke-static {v3}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->c(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;)Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

    move-result-object v3

    invoke-direct {v1, v2, v3, v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;-><init>(Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;)V

    .line 148
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 149
    const-string v3, "BreadCrumb"

    iget-object v4, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;

    invoke-static {v4}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 150
    const-string v3, "PDPOverviewResponseRoot"

    iget-object v4, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;

    invoke-static {v4}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->d(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;)Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponseRoot;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 151
    invoke-virtual {v1, v2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->setArguments(Landroid/os/Bundle;)V

    .line 152
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 153
    return-void
.end method
