.class public Lim;
.super Lka;
.source "SourceFile"


# instance fields
.field private a:Ljava/lang/String;

.field private j:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsResponse;


# direct methods
.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 21
    invoke-direct {p0, p1, p2}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 22
    iput-object p4, p0, Lim;->a:Ljava/lang/String;

    .line 23
    iput-object p3, p0, Lim;->g:Landroid/view/View;

    .line 24
    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lim;->a:Ljava/lang/String;

    invoke-static {v0}, Lfs;->h(Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsResponse;

    move-result-object v0

    iput-object v0, p0, Lim;->j:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsResponse;

    .line 37
    return-void
.end method

.method public b()V
    .locals 2

    .prologue
    .line 53
    iget-object v0, p0, Lim;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 54
    iget-object v0, p0, Lim;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 56
    :cond_0
    iget-object v0, p0, Lim;->j:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsResponse;

    if-nez v0, :cond_2

    .line 57
    invoke-virtual {p0}, Lim;->c()V

    .line 70
    :cond_1
    :goto_0
    return-void

    .line 59
    :cond_2
    iget-object v0, p0, Lim;->j:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsResponse;

    if-eqz v0, :cond_1

    .line 60
    iget-object v0, p0, Lim;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lim;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 61
    iget-object v0, p0, Lim;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;

    iget-object v1, p0, Lim;->j:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsResponse;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->a(Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsResponse;)V

    goto :goto_0

    .line 62
    :cond_3
    iget-object v0, p0, Lim;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;

    if-eqz v0, :cond_4

    iget-object v0, p0, Lim;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 63
    iget-object v0, p0, Lim;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;

    iget-object v1, p0, Lim;->j:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsResponse;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->a(Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsResponse;)V

    goto :goto_0

    .line 65
    :cond_4
    iget-object v0, p0, Lim;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lim;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 66
    iget-object v0, p0, Lim;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;

    iget-object v1, p0, Lim;->j:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsResponse;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->a(Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsResponse;)V

    goto :goto_0
.end method

.method public c()V
    .locals 2

    .prologue
    .line 46
    iget-object v0, p0, Lim;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 47
    iget-object v0, p0, Lim;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 49
    :cond_0
    return-void
.end method

.method public d()V
    .locals 5

    .prologue
    .line 41
    new-instance v0, Lim;

    iget-object v1, p0, Lim;->f:Landroid/app/Activity;

    iget-object v2, p0, Lim;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    iget-object v3, p0, Lim;->g:Landroid/view/View;

    iget-object v4, p0, Lim;->a:Ljava/lang/String;

    invoke-direct {v0, v1, v2, v3, v4}, Lim;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lim;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 42
    return-void
.end method

.method public onPreExecute()V
    .locals 2

    .prologue
    .line 28
    iget-object v0, p0, Lim;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 29
    iget-object v0, p0, Lim;->g:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 31
    :cond_0
    return-void
.end method
