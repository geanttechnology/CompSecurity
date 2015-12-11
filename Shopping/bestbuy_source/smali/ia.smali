.class public Lia;
.super Lka;
.source "SourceFile"


# instance fields
.field private a:Ljava/lang/String;

.field private j:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

.field private k:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
            ">;"
        }
    .end annotation
.end field

.field private l:Lcom/bestbuy/android/api/lib/models/pdpaccessories/AccessoriesResponse;


# direct methods
.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;)V
    .locals 1

    .prologue
    .line 26
    invoke-direct {p0, p1, p2}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 27
    iput-object p4, p0, Lia;->j:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    .line 28
    iget-object v0, p0, Lia;->j:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getSkuId()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lia;->a:Ljava/lang/String;

    .line 29
    iput-object p3, p0, Lia;->g:Landroid/view/View;

    .line 30
    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lia;->a:Ljava/lang/String;

    invoke-static {v0}, Lfs;->m(Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/pdpaccessories/AccessoriesResponse;

    move-result-object v0

    iput-object v0, p0, Lia;->l:Lcom/bestbuy/android/api/lib/models/pdpaccessories/AccessoriesResponse;

    .line 44
    iget-object v0, p0, Lia;->l:Lcom/bestbuy/android/api/lib/models/pdpaccessories/AccessoriesResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpaccessories/AccessoriesResponse;->getSuggestedAccessories()Ljava/util/ArrayList;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 45
    iget-object v0, p0, Lia;->l:Lcom/bestbuy/android/api/lib/models/pdpaccessories/AccessoriesResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpaccessories/AccessoriesResponse;->getSuggestedAccessories()Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lia;->k:Ljava/util/ArrayList;

    .line 47
    :cond_0
    return-void
.end method

.method public b()V
    .locals 2

    .prologue
    .line 65
    iget-object v0, p0, Lia;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 66
    iget-object v0, p0, Lia;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 68
    :cond_0
    iget-object v0, p0, Lia;->k:Ljava/util/ArrayList;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lia;->k:Ljava/util/ArrayList;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lia;->k:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 69
    :cond_1
    invoke-virtual {p0}, Lia;->c()V

    .line 74
    :cond_2
    :goto_0
    return-void

    .line 71
    :cond_3
    iget-object v0, p0, Lia;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAccessoriesFragment;

    if-eqz v0, :cond_2

    .line 72
    iget-object v0, p0, Lia;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAccessoriesFragment;

    iget-object v1, p0, Lia;->k:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAccessoriesFragment;->a(Ljava/util/ArrayList;)V

    goto :goto_0
.end method

.method public c()V
    .locals 2

    .prologue
    .line 56
    iget-object v0, p0, Lia;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 57
    iget-object v0, p0, Lia;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 59
    :cond_0
    iget-object v0, p0, Lia;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAccessoriesFragment;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lia;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 60
    iget-object v0, p0, Lia;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAccessoriesFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAccessoriesFragment;->b()V

    .line 61
    :cond_1
    return-void
.end method

.method public d()V
    .locals 5

    .prologue
    .line 51
    new-instance v0, Lia;

    iget-object v1, p0, Lia;->f:Landroid/app/Activity;

    iget-object v2, p0, Lia;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    iget-object v3, p0, Lia;->g:Landroid/view/View;

    iget-object v4, p0, Lia;->j:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-direct {v0, v1, v2, v3, v4}, Lia;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lia;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 52
    return-void
.end method

.method public onPreExecute()V
    .locals 2

    .prologue
    .line 34
    iget-object v0, p0, Lia;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 35
    iget-object v0, p0, Lia;->g:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 37
    :cond_0
    return-void
.end method
