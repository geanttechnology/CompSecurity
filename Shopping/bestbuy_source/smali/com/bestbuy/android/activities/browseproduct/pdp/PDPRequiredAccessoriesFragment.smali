.class public Lcom/bestbuy/android/activities/browseproduct/pdp/PDPRequiredAccessoriesFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"


# instance fields
.field private a:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

.field private b:Landroid/app/Activity;

.field private c:Landroid/view/View;

.field private g:Landroid/view/View;

.field private h:Landroid/view/View;

.field private i:Landroid/widget/LinearLayout;

.field private j:Landroid/widget/RelativeLayout;

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

.field private l:Lil;

.field private m:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

.field private n:Ldy;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 36
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 38
    return-void
.end method

.method public constructor <init>(Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;)V
    .locals 2

    .prologue
    .line 40
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 41
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPRequiredAccessoriesFragment;->a:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    .line 43
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 44
    const-string v1, "product"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 45
    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPRequiredAccessoriesFragment;->setArguments(Landroid/os/Bundle;)V

    .line 46
    return-void
.end method


# virtual methods
.method public a(Ljava/util/ArrayList;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
            ">;)V"
        }
    .end annotation

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 91
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPRequiredAccessoriesFragment;->k:Ljava/util/ArrayList;

    .line 92
    new-instance v0, Ldy;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPRequiredAccessoriesFragment;->b:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPRequiredAccessoriesFragment;->k:Ljava/util/ArrayList;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPRequiredAccessoriesFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3, v5}, Ldy;-><init>(Landroid/app/Activity;Ljava/util/ArrayList;Landroid/support/v4/app/Fragment;Z)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPRequiredAccessoriesFragment;->n:Ldy;

    .line 93
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPRequiredAccessoriesFragment;->m:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPRequiredAccessoriesFragment;->n:Ldy;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;->setAdapter(Landroid/support/v4/view/PagerAdapter;)V

    .line 94
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPRequiredAccessoriesFragment;->m:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPRequiredAccessoriesFragment;->b:Landroid/app/Activity;

    invoke-static {v1}, Lll;->a(Landroid/app/Activity;)Landroid/view/animation/Animation;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;->startAnimation(Landroid/view/animation/Animation;)V

    .line 95
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPRequiredAccessoriesFragment;->k:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ne v0, v5, :cond_0

    .line 96
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPRequiredAccessoriesFragment;->m:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    invoke-virtual {v0, v4}, Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;->setPagingEnabled(Z)V

    .line 98
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPRequiredAccessoriesFragment;->i:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v4}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 99
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 83
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 84
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 50
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 51
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPRequiredAccessoriesFragment;->b:Landroid/app/Activity;

    .line 52
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 57
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPRequiredAccessoriesFragment;->a:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    if-nez v0, :cond_0

    .line 58
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPRequiredAccessoriesFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    .line 59
    const-string v1, "product"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getSerializable(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPRequiredAccessoriesFragment;->a:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    .line 62
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPRequiredAccessoriesFragment;->c:Landroid/view/View;

    if-nez v0, :cond_2

    .line 63
    const v0, 0x7f0300ad

    invoke-virtual {p1, v0, p2, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPRequiredAccessoriesFragment;->c:Landroid/view/View;

    .line 64
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPRequiredAccessoriesFragment;->c:Landroid/view/View;

    const v1, 0x7f0c02ac

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPRequiredAccessoriesFragment;->i:Landroid/widget/LinearLayout;

    .line 65
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPRequiredAccessoriesFragment;->c:Landroid/view/View;

    const v1, 0x7f0c02ad

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPRequiredAccessoriesFragment;->g:Landroid/view/View;

    .line 66
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPRequiredAccessoriesFragment;->c:Landroid/view/View;

    const v1, 0x7f0c02ae

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPRequiredAccessoriesFragment;->h:Landroid/view/View;

    .line 67
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPRequiredAccessoriesFragment;->c:Landroid/view/View;

    const v1, 0x7f0c005e

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPRequiredAccessoriesFragment;->m:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    .line 68
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPRequiredAccessoriesFragment;->m:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    const/16 v1, 0xf

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;->setPageMargin(I)V

    .line 69
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPRequiredAccessoriesFragment;->c:Landroid/view/View;

    const v1, 0x7f0c02af

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPRequiredAccessoriesFragment;->j:Landroid/widget/RelativeLayout;

    .line 70
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPRequiredAccessoriesFragment;->a:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    if-eqz v0, :cond_1

    .line 71
    new-instance v0, Lil;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPRequiredAccessoriesFragment;->b:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPRequiredAccessoriesFragment;->h:Landroid/view/View;

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPRequiredAccessoriesFragment;->a:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-direct {v0, v1, p0, v2, v3}, Lil;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPRequiredAccessoriesFragment;->l:Lil;

    .line 72
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPRequiredAccessoriesFragment;->l:Lil;

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    new-array v2, v4, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lil;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 77
    :cond_1
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPRequiredAccessoriesFragment;->c:Landroid/view/View;

    return-object v0

    .line 75
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPRequiredAccessoriesFragment;->c:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPRequiredAccessoriesFragment;->c:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    goto :goto_0
.end method

.method public onDestroy()V
    .locals 2

    .prologue
    .line 110
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onDestroy()V

    .line 111
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPRequiredAccessoriesFragment;->l:Lil;

    if-eqz v0, :cond_0

    .line 112
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPRequiredAccessoriesFragment;->l:Lil;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lil;->cancel(Z)Z

    .line 114
    :cond_0
    return-void
.end method

.method public onPause()V
    .locals 0

    .prologue
    .line 87
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onPause()V

    .line 88
    return-void
.end method

.method public onResume()V
    .locals 1

    .prologue
    .line 103
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 104
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPRequiredAccessoriesFragment;->n:Ldy;

    if-eqz v0, :cond_0

    .line 105
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPRequiredAccessoriesFragment;->n:Ldy;

    invoke-virtual {v0}, Ldy;->notifyDataSetChanged()V

    .line 107
    :cond_0
    return-void
.end method
