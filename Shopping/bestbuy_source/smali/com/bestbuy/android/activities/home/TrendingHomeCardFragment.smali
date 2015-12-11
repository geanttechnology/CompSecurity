.class public Lcom/bestbuy/android/activities/home/TrendingHomeCardFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field private a:Lhn;

.field private b:Landroid/app/Activity;

.field private c:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

.field private g:Landroid/widget/LinearLayout;

.field private h:Landroid/view/View;

.field private i:Landroid/view/View;

.field private j:Landroid/view/View;

.field private k:Ldy;

.field private l:Lcom/bestbuy/android/api/lib/models/home/Recommendation;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 45
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 46
    return-void
.end method


# virtual methods
.method public a(Lgu;)V
    .locals 0

    .prologue
    .line 55
    check-cast p1, Lcom/bestbuy/android/api/lib/models/home/Recommendation;

    iput-object p1, p0, Lcom/bestbuy/android/activities/home/TrendingHomeCardFragment;->l:Lcom/bestbuy/android/api/lib/models/home/Recommendation;

    .line 56
    return-void
.end method

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
    const/4 v4, 0x1

    .line 100
    new-instance v0, Ldy;

    iget-object v1, p0, Lcom/bestbuy/android/activities/home/TrendingHomeCardFragment;->b:Landroid/app/Activity;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/TrendingHomeCardFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v3

    const-string v5, "GHP"

    move-object v2, p1

    invoke-direct/range {v0 .. v5}, Ldy;-><init>(Landroid/app/Activity;Ljava/util/ArrayList;Landroid/support/v4/app/Fragment;ZLjava/lang/String;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/TrendingHomeCardFragment;->k:Ldy;

    .line 101
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/TrendingHomeCardFragment;->c:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    iget-object v1, p0, Lcom/bestbuy/android/activities/home/TrendingHomeCardFragment;->k:Ldy;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;->setAdapter(Landroid/support/v4/view/PagerAdapter;)V

    .line 102
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/TrendingHomeCardFragment;->c:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    iget-object v1, p0, Lcom/bestbuy/android/activities/home/TrendingHomeCardFragment;->b:Landroid/app/Activity;

    invoke-static {v1}, Lll;->a(Landroid/app/Activity;)Landroid/view/animation/Animation;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;->startAnimation(Landroid/view/animation/Animation;)V

    .line 103
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ne v0, v4, :cond_0

    .line 104
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/TrendingHomeCardFragment;->c:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;->setPagingEnabled(Z)V

    .line 105
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/TrendingHomeCardFragment;->b:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v1, "GHP"

    const-string v2, "homeloadtrendingnow"

    invoke-virtual {v0, v1, v2, p1}, Lcom/bestbuy/android/activities/home/HomeActivity;->loadTrendingNowRecommendations(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V

    .line 106
    return-void
.end method

.method public b()V
    .locals 1

    .prologue
    .line 92
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/TrendingHomeCardFragment;->j:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 93
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/TrendingHomeCardFragment;->j:Landroid/view/View;

    invoke-static {v0}, Lll;->a(Landroid/view/View;)V

    .line 95
    :cond_0
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 77
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 78
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 50
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 51
    iput-object p1, p0, Lcom/bestbuy/android/activities/home/TrendingHomeCardFragment;->b:Landroid/app/Activity;

    .line 52
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 9

    .prologue
    const/4 v1, 0x1

    .line 110
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/TrendingHomeCardFragment;->g:Landroid/widget/LinearLayout;

    if-ne p1, v0, :cond_0

    .line 111
    new-instance v8, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;

    invoke-direct {v8}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;-><init>()V

    .line 112
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    const-string v2, "Trending"

    const-string v3, "Trending Now"

    const-string v4, "all"

    const/4 v5, 0x0

    const-string v6, "Home"

    const/16 v7, 0xa

    invoke-direct/range {v0 .. v7}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;-><init>(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V

    .line 113
    iget-object v2, p0, Lcom/bestbuy/android/activities/home/TrendingHomeCardFragment;->b:Landroid/app/Activity;

    check-cast v2, Landroid/support/v4/app/FragmentActivity;

    invoke-virtual {v2}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v2

    const v3, 0x7f0c0033

    invoke-virtual {v2, v3}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v2

    .line 114
    instance-of v3, v2, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    if-eqz v3, :cond_0

    .line 115
    check-cast v2, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    .line 116
    invoke-virtual {v2}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->e()Landroid/support/v4/app/Fragment;

    move-result-object v2

    .line 117
    check-cast v2, Lcom/bestbuy/android/activities/BaseTabContainer;

    invoke-virtual {v2, v8, v1}, Lcom/bestbuy/android/activities/BaseTabContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 118
    invoke-virtual {v8, v0, v1}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 121
    :cond_0
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 59
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/TrendingHomeCardFragment;->i:Landroid/view/View;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/home/TrendingHomeCardFragment;->i:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getVisibility()I

    move-result v0

    if-eqz v0, :cond_1

    .line 60
    :cond_0
    iput-object p2, p0, Lcom/bestbuy/android/activities/home/TrendingHomeCardFragment;->j:Landroid/view/View;

    .line 61
    const v0, 0x7f03010e

    invoke-virtual {p1, v0, p2, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/TrendingHomeCardFragment;->i:Landroid/view/View;

    .line 62
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/TrendingHomeCardFragment;->i:Landroid/view/View;

    const v1, 0x7f0c0064

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/TrendingHomeCardFragment;->h:Landroid/view/View;

    .line 63
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/TrendingHomeCardFragment;->i:Landroid/view/View;

    const v1, 0x7f0c005e

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/TrendingHomeCardFragment;->c:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    .line 64
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/TrendingHomeCardFragment;->c:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    const/16 v1, 0xf

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;->setPageMargin(I)V

    .line 65
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/TrendingHomeCardFragment;->i:Landroid/view/View;

    const v1, 0x7f0c0073

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/TrendingHomeCardFragment;->g:Landroid/widget/LinearLayout;

    .line 66
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/TrendingHomeCardFragment;->g:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 67
    new-instance v0, Lhn;

    iget-object v1, p0, Lcom/bestbuy/android/activities/home/TrendingHomeCardFragment;->b:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/home/TrendingHomeCardFragment;->h:Landroid/view/View;

    iget-object v3, p0, Lcom/bestbuy/android/activities/home/TrendingHomeCardFragment;->l:Lcom/bestbuy/android/api/lib/models/home/Recommendation;

    invoke-direct {v0, v1, p0, v2, v3}, Lhn;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Lcom/bestbuy/android/api/lib/models/home/Recommendation;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/TrendingHomeCardFragment;->a:Lhn;

    .line 68
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/TrendingHomeCardFragment;->a:Lhn;

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    new-array v2, v4, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lhn;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 72
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/TrendingHomeCardFragment;->i:Landroid/view/View;

    return-object v0

    .line 71
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/TrendingHomeCardFragment;->i:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iget-object v1, p0, Lcom/bestbuy/android/activities/home/TrendingHomeCardFragment;->i:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    goto :goto_0
.end method

.method public onResume()V
    .locals 3

    .prologue
    .line 81
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 82
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/TrendingHomeCardFragment;->l()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 83
    new-instance v0, Lhn;

    iget-object v1, p0, Lcom/bestbuy/android/activities/home/TrendingHomeCardFragment;->b:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/home/TrendingHomeCardFragment;->h:Landroid/view/View;

    invoke-direct {v0, v1, p0, v2}, Lhn;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/TrendingHomeCardFragment;->a:Lhn;

    .line 84
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/TrendingHomeCardFragment;->a:Lhn;

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lhn;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 86
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/TrendingHomeCardFragment;->k:Ldy;

    if-eqz v0, :cond_1

    .line 87
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/TrendingHomeCardFragment;->k:Ldy;

    invoke-virtual {v0}, Ldy;->notifyDataSetChanged()V

    .line 89
    :cond_1
    return-void
.end method
