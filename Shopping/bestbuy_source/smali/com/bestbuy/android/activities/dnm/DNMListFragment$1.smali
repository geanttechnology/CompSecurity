.class Lcom/bestbuy/android/activities/dnm/DNMListFragment$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/dnm/DNMListFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/dnm/DNMListFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/dnm/DNMListFragment;)V
    .locals 0

    .prologue
    .line 149
    iput-object p1, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment$1;->a:Lcom/bestbuy/android/activities/dnm/DNMListFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 13
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
    .line 153
    if-lez p3, :cond_0

    .line 154
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment$1;->a:Lcom/bestbuy/android/activities/dnm/DNMListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->a(Lcom/bestbuy/android/activities/dnm/DNMListFragment;)Ljava/util/ArrayList;

    move-result-object v0

    add-int/lit8 v1, p3, -0x1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    move-object v10, v0

    check-cast v10, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    .line 155
    invoke-virtual {v10}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getNoOfStoresItemAvlbl()I

    move-result v0

    const/4 v1, 0x1

    if-le v0, v1, :cond_1

    .line 156
    new-instance v1, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;

    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment$1;->a:Lcom/bestbuy/android/activities/dnm/DNMListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->b(Lcom/bestbuy/android/activities/dnm/DNMListFragment;)Ljava/util/ArrayList;

    move-result-object v0

    add-int/lit8 v2, p3, -0x1

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment$1;->a:Lcom/bestbuy/android/activities/dnm/DNMListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->c(Lcom/bestbuy/android/activities/dnm/DNMListFragment;)Ljava/lang/String;

    move-result-object v3

    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment$1;->a:Lcom/bestbuy/android/activities/dnm/DNMListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->d(Lcom/bestbuy/android/activities/dnm/DNMListFragment;)D

    move-result-wide v4

    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment$1;->a:Lcom/bestbuy/android/activities/dnm/DNMListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->e(Lcom/bestbuy/android/activities/dnm/DNMListFragment;)D

    move-result-wide v6

    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment$1;->a:Lcom/bestbuy/android/activities/dnm/DNMListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->f(Lcom/bestbuy/android/activities/dnm/DNMListFragment;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v10}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getNoOfStoresItemAvlbl()I

    move-result v9

    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment$1;->a:Lcom/bestbuy/android/activities/dnm/DNMListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->g(Lcom/bestbuy/android/activities/dnm/DNMListFragment;)Ljava/util/ArrayList;

    move-result-object v10

    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment$1;->a:Lcom/bestbuy/android/activities/dnm/DNMListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->h(Lcom/bestbuy/android/activities/dnm/DNMListFragment;)Ljava/lang/String;

    move-result-object v11

    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment$1;->a:Lcom/bestbuy/android/activities/dnm/DNMListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->i(Lcom/bestbuy/android/activities/dnm/DNMListFragment;)Ljava/lang/String;

    move-result-object v12

    invoke-direct/range {v1 .. v12}, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;-><init>(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;Ljava/lang/String;DDLjava/lang/String;ILjava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;)V

    .line 157
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment$1;->a:Lcom/bestbuy/android/activities/dnm/DNMListFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 162
    :cond_0
    :goto_0
    return-void

    .line 159
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment$1;->a:Lcom/bestbuy/android/activities/dnm/DNMListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->j(Lcom/bestbuy/android/activities/dnm/DNMListFragment;)Landroid/app/Activity;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v10}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getSkuId()Ljava/lang/String;

    move-result-object v1

    const-string v2, ""

    invoke-virtual {v10}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getProductId()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x1

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    const-string v9, ""

    move-object v5, v10

    invoke-virtual/range {v0 .. v9}, Lcom/bestbuy/android/activities/home/HomeActivity;->openPDP(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/bestbuy/android/api/lib/models/dnm/DNMProduct;ZZZLjava/lang/String;)V

    goto :goto_0
.end method
