.class Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/AbsListView$OnScrollListener;


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
    .line 276
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onScroll(Landroid/widget/AbsListView;III)V
    .locals 9

    .prologue
    const/4 v3, 0x0

    const/4 v8, 0x0

    .line 290
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->g(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->g(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1

    .line 291
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->h(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;)Landroid/widget/RelativeLayout;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 294
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    invoke-static {v0, v8}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;Z)Z

    .line 295
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->i(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;)Z

    move-result v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->j(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;)Landroid/widget/ListView;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/ListView;->getHeaderViewsCount()I

    move-result v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->j(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;)Landroid/widget/ListView;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/ListView;->getFooterViewsCount()I

    move-result v1

    add-int/2addr v0, v1

    sub-int v0, p4, v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->k(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;)I

    move-result v1

    if-ge v0, v1, :cond_2

    .line 296
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->e(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;)I

    move-result v1

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    invoke-static {v2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->d(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;)I

    move-result v2

    add-int/2addr v1, v2

    invoke-static {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;I)I

    .line 297
    new-instance v0, Lhi;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    iget-object v1, v1, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->d:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    iget-object v4, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    invoke-static {v4}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->c(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;)Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    move-result-object v4

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getSkuId()Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    invoke-static {v5}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->d(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;)I

    move-result v5

    iget-object v6, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    invoke-static {v6}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->e(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;)I

    move-result v6

    iget-object v7, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    invoke-static {v7}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->f(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;)Ljava/lang/String;

    move-result-object v7

    invoke-direct/range {v0 .. v7}, Lhi;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;IILjava/lang/String;)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    new-array v2, v8, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lhi;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 298
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    invoke-static {v0, v8}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->b(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;Z)Z

    .line 305
    :cond_0
    :goto_1
    return-void

    .line 293
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->h(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;)Landroid/widget/RelativeLayout;

    move-result-object v0

    invoke-virtual {v0, v8}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    goto :goto_0

    .line 299
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->i(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->l(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->m(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;)I

    move-result v0

    sub-int v0, p4, v0

    sub-int/2addr v0, p3

    if-ne p2, v0, :cond_0

    .line 300
    new-instance v0, Lig;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    iget-object v1, v1, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->d:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    iget-object v4, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    invoke-static {v4}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->n(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;)Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

    move-result-object v4

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;->getOverview()Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    move-result-object v4

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getSkuId()Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    invoke-static {v5}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->g(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;)Ljava/lang/String;

    move-result-object v5

    iget-object v6, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    invoke-static {v6}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->e(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;)I

    move-result v6

    iget-object v7, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    invoke-static {v7}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->l(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;)Ljava/lang/String;

    move-result-object v7

    invoke-direct/range {v0 .. v7}, Lig;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    new-array v2, v8, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lig;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 302
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->o(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;)I

    .line 303
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    invoke-static {v0, v8}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->b(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;Z)Z

    goto :goto_1
.end method

.method public onScrollStateChanged(Landroid/widget/AbsListView;I)V
    .locals 2

    .prologue
    .line 279
    if-nez p2, :cond_0

    .line 280
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->b(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;Z)Z

    .line 284
    :goto_0
    return-void

    .line 282
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    const/4 v1, 0x1

    invoke-static {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->b(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;Z)Z

    goto :goto_0
.end method
