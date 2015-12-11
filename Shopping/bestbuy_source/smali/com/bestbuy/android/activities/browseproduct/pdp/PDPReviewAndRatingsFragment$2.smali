.class Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->a(Ljava/lang/String;Ljava/util/ArrayList;Landroid/widget/LinearLayout;)V
.end annotation


# instance fields
.field final synthetic a:Ljava/lang/String;

.field final synthetic b:Ljava/util/ArrayList;

.field final synthetic c:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;Ljava/lang/String;Ljava/util/ArrayList;)V
    .locals 0

    .prologue
    .line 215
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment$2;->c:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;

    iput-object p2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment$2;->a:Ljava/lang/String;

    iput-object p3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment$2;->b:Ljava/util/ArrayList;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 6

    .prologue
    .line 218
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 219
    const-string v1, "&&products"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, ";"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment$2;->c:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;

    invoke-static {v3}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->b(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;)Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    move-result-object v3

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getSkuId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 220
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment$2;->a:Ljava/lang/String;

    const-string v2, "Cons"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 221
    const-string v1, "bb.distilledReviewCon"

    const-string v2, "1"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 222
    const-string v1, "bb.prevPageLink"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment$2;->c:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;

    invoke-static {v3}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "pdp: distilled review: con"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 223
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment$2;->c:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;

    invoke-static {v2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "pdp: reviews: con"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, v0}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 229
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment$2;->c:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;

    .line 230
    new-instance v2, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment$2;->c:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->b(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;)Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    move-result-object v3

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment$2;->c:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->c(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;)Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

    move-result-object v4

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment$2;->b:Ljava/util/ArrayList;

    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v5

    invoke-virtual {v1, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewFeaturesDetails;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewFeaturesDetails;->getFeature()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v2, v3, v4, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;-><init>(Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;Ljava/lang/String;)V

    .line 231
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 232
    const-string v3, "BreadCrumb"

    iget-object v4, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment$2;->c:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;

    invoke-static {v4}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 233
    const-string v3, "PDPOverviewResponseRoot"

    iget-object v4, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment$2;->c:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;

    invoke-static {v4}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->d(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;)Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponseRoot;

    move-result-object v4

    invoke-virtual {v1, v3, v4}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 234
    invoke-virtual {v2, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->setArguments(Landroid/os/Bundle;)V

    .line 235
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;

    const/4 v1, 0x1

    invoke-virtual {v0, v2, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 236
    return-void

    .line 224
    :cond_1
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment$2;->a:Ljava/lang/String;

    const-string v2, "Pros"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 225
    const-string v1, "bb.distilledReviewPro"

    const-string v2, "1"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 226
    const-string v1, "bb.prevPageLink"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment$2;->c:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;

    invoke-static {v3}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "pdp: distilled review: pro"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 227
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment$2;->c:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;

    invoke-static {v2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "pdp: reviews: pro"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, v0}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    goto/16 :goto_0
.end method
