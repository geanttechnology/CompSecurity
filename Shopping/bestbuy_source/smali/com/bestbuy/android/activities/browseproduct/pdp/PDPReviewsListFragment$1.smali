.class Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/AdapterView$OnItemSelectedListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;)V
    .locals 0

    .prologue
    .line 160
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemSelected(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 9
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
    const/4 v8, 0x0

    .line 165
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    const/4 v1, 0x1

    invoke-static {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;Z)Z

    .line 166
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    invoke-static {v0, v8}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;I)I

    .line 167
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    invoke-static {v0, v8}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->b(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;I)I

    .line 168
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;)Lcom/bestbuy/android/activities/stores/DialogSpinner;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/stores/DialogSpinner;->getAdapter()Landroid/widget/SpinnerAdapter;

    move-result-object v0

    invoke-interface {v0, p3}, Landroid/widget/SpinnerAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 169
    const-string v1, "Newest"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 170
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    const-string v1, "SubmissionTime:desc"

    invoke-static {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;Ljava/lang/String;)Ljava/lang/String;

    .line 180
    :cond_0
    :goto_0
    new-instance v0, Lhi;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    iget-object v1, v1, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->d:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    invoke-static {v3}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->b(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;)Landroid/view/View;

    move-result-object v3

    iget-object v4, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    invoke-static {v4}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->c(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;)Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    move-result-object v4

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getSkuId()Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    invoke-static {v5}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->d(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;)I

    move-result v5

    iget-object v6, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    invoke-static {v6}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->e(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;)I

    move-result v6

    iget-object v7, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    invoke-static {v7}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->f(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;)Ljava/lang/String;

    move-result-object v7

    invoke-direct/range {v0 .. v7}, Lhi;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;IILjava/lang/String;)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    new-array v2, v8, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lhi;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 181
    return-void

    .line 171
    :cond_1
    const-string v1, "Oldest"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 172
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    const-string v1, "SubmissionTime:asc"

    invoke-static {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;Ljava/lang/String;)Ljava/lang/String;

    goto :goto_0

    .line 173
    :cond_2
    const-string v1, "Most Helpful"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 174
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    const-string v1, "Helpfulness:desc,SubmissionTime:desc"

    invoke-static {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;Ljava/lang/String;)Ljava/lang/String;

    goto :goto_0

    .line 175
    :cond_3
    const-string v1, "Highest Rated"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 176
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    const-string v1, "Rating:desc,SubmissionTime:desc"

    invoke-static {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;Ljava/lang/String;)Ljava/lang/String;

    goto :goto_0

    .line 177
    :cond_4
    const-string v1, "Lowest Rated"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 178
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    const-string v1, "Rating:asc,SubmissionTime:desc"

    invoke-static {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;Ljava/lang/String;)Ljava/lang/String;

    goto :goto_0
.end method

.method public onNothingSelected(Landroid/widget/AdapterView;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .line 185
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;Z)Z

    .line 186
    return-void
.end method
