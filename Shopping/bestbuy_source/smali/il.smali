.class public Lil;
.super Lka;
.source "SourceFile"


# instance fields
.field private a:Ljava/lang/String;

.field private j:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
            ">;"
        }
    .end annotation
.end field

.field private k:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

.field private l:Lcom/bestbuy/android/api/lib/models/pdpaccessories/AccessoriesResponse;


# direct methods
.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;)V
    .locals 1

    .prologue
    .line 25
    invoke-direct {p0, p1, p2}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 26
    iput-object p4, p0, Lil;->k:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    .line 27
    invoke-virtual {p4}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getSkuId()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lil;->a:Ljava/lang/String;

    .line 28
    iput-object p3, p0, Lil;->g:Landroid/view/View;

    .line 29
    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lil;->a:Ljava/lang/String;

    invoke-static {v0}, Lfs;->m(Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/pdpaccessories/AccessoriesResponse;

    move-result-object v0

    iput-object v0, p0, Lil;->l:Lcom/bestbuy/android/api/lib/models/pdpaccessories/AccessoriesResponse;

    .line 43
    iget-object v0, p0, Lil;->l:Lcom/bestbuy/android/api/lib/models/pdpaccessories/AccessoriesResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpaccessories/AccessoriesResponse;->getRequiredAccessories()Ljava/util/ArrayList;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 44
    iget-object v0, p0, Lil;->l:Lcom/bestbuy/android/api/lib/models/pdpaccessories/AccessoriesResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpaccessories/AccessoriesResponse;->getRequiredAccessories()Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lil;->j:Ljava/util/ArrayList;

    .line 46
    :cond_0
    return-void
.end method

.method public b()V
    .locals 2

    .prologue
    .line 62
    iget-object v0, p0, Lil;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 63
    iget-object v0, p0, Lil;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 65
    :cond_0
    iget-object v0, p0, Lil;->j:Ljava/util/ArrayList;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lil;->j:Ljava/util/ArrayList;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lil;->j:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 66
    :cond_1
    invoke-virtual {p0}, Lil;->c()V

    .line 72
    :cond_2
    :goto_0
    return-void

    .line 68
    :cond_3
    iget-object v0, p0, Lil;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPRequiredAccessoriesFragment;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lil;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 69
    iget-object v0, p0, Lil;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPRequiredAccessoriesFragment;

    iget-object v1, p0, Lil;->j:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPRequiredAccessoriesFragment;->a(Ljava/util/ArrayList;)V

    goto :goto_0
.end method

.method public c()V
    .locals 2

    .prologue
    .line 55
    iget-object v0, p0, Lil;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 56
    iget-object v0, p0, Lil;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 58
    :cond_0
    return-void
.end method

.method public d()V
    .locals 5

    .prologue
    .line 50
    new-instance v0, Lil;

    iget-object v1, p0, Lil;->f:Landroid/app/Activity;

    iget-object v2, p0, Lil;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    iget-object v3, p0, Lil;->g:Landroid/view/View;

    iget-object v4, p0, Lil;->k:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-direct {v0, v1, v2, v3, v4}, Lil;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lil;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 51
    return-void
.end method

.method public onPreExecute()V
    .locals 2

    .prologue
    .line 33
    iget-object v0, p0, Lil;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 34
    iget-object v0, p0, Lil;->g:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 36
    :cond_0
    return-void
.end method
