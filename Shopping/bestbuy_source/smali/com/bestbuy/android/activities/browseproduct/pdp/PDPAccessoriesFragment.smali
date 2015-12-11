.class public Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAccessoriesFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field private a:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

.field private b:Landroid/view/View;

.field private c:Landroid/widget/LinearLayout;

.field private g:Landroid/view/View;

.field private h:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

.field private i:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
            ">;"
        }
    .end annotation
.end field

.field private j:Lia;

.field private k:Ldy;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 45
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 46
    return-void
.end method

.method public constructor <init>(Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;)V
    .locals 2

    .prologue
    .line 48
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 49
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAccessoriesFragment;->h:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    .line 51
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 52
    const-string v1, "product"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 53
    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAccessoriesFragment;->setArguments(Landroid/os/Bundle;)V

    .line 54
    return-void
.end method


# virtual methods
.method public a(Ljava/util/ArrayList;)V
    .locals 4
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
    const/4 v3, 0x1

    .line 109
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAccessoriesFragment;->i:Ljava/util/ArrayList;

    .line 110
    new-instance v0, Ldy;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAccessoriesFragment;->d:Landroid/app/Activity;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAccessoriesFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v2

    invoke-direct {v0, v1, p1, v2, v3}, Ldy;-><init>(Landroid/app/Activity;Ljava/util/ArrayList;Landroid/support/v4/app/Fragment;Z)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAccessoriesFragment;->k:Ldy;

    .line 111
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAccessoriesFragment;->a:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAccessoriesFragment;->k:Ldy;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;->setAdapter(Landroid/support/v4/view/PagerAdapter;)V

    .line 112
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAccessoriesFragment;->a:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAccessoriesFragment;->d:Landroid/app/Activity;

    invoke-static {v1}, Lll;->a(Landroid/app/Activity;)Landroid/view/animation/Animation;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;->startAnimation(Landroid/view/animation/Animation;)V

    .line 113
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ne v0, v3, :cond_0

    .line 114
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAccessoriesFragment;->a:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;->setPagingEnabled(Z)V

    .line 115
    :cond_0
    return-void
.end method

.method public b()V
    .locals 1

    .prologue
    .line 101
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAccessoriesFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 102
    invoke-virtual {v0}, Landroid/support/v4/app/Fragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    .line 103
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    .line 104
    invoke-virtual {v0, p0}, Landroid/support/v4/app/FragmentTransaction;->remove(Landroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    .line 105
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTransaction;->commitAllowingStateLoss()I

    .line 106
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 86
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 87
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 58
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 59
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAccessoriesFragment;->d:Landroid/app/Activity;

    .line 60
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 119
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAccessoriesFragment;->c:Landroid/widget/LinearLayout;

    if-ne p1, v0, :cond_0

    .line 120
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAccessoriesFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAccessoriesFragment;->d:Landroid/app/Activity;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->changeActionBarShareVisibility(Landroid/app/Activity;Z)V

    .line 121
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 122
    sget-object v1, Llu;->ao:Ljava/lang/String;

    const-string v2, "PLP Accessories List"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 123
    sget-object v1, Llu;->ao:Ljava/lang/String;

    invoke-static {v1, v0}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 125
    new-instance v1, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;

    invoke-direct {v1}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;-><init>()V

    .line 126
    new-instance v2, Lcom/bestbuy/android/activities/browseproduct/plp/PLPAccessoriesFragment;

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAccessoriesFragment;->d:Landroid/app/Activity;

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAccessoriesFragment;->i:Ljava/util/ArrayList;

    invoke-direct {v2, v0, v3}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPAccessoriesFragment;-><init>(Landroid/app/Activity;Ljava/util/ArrayList;)V

    .line 128
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAccessoriesFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;

    .line 129
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;

    const-string v3, "PDPFragmentContainer"

    invoke-virtual {v0, v1, v4, v3}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;->a(Landroid/support/v4/app/Fragment;ZLjava/lang/String;)V

    .line 130
    const-string v0, "PLPAccessoriesFragment"

    invoke-virtual {v1, v2, v4, v0}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;ZLjava/lang/String;)V

    .line 133
    :cond_0
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 64
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAccessoriesFragment;->h:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    if-nez v0, :cond_0

    .line 65
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAccessoriesFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    .line 66
    const-string v1, "product"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getSerializable(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAccessoriesFragment;->h:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    .line 68
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAccessoriesFragment;->g:Landroid/view/View;

    if-nez v0, :cond_1

    .line 69
    const v0, 0x7f0300db

    invoke-virtual {p1, v0, p2, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAccessoriesFragment;->g:Landroid/view/View;

    .line 70
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAccessoriesFragment;->g:Landroid/view/View;

    const v1, 0x7f0c0064

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAccessoriesFragment;->b:Landroid/view/View;

    .line 71
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAccessoriesFragment;->g:Landroid/view/View;

    const v1, 0x7f0c005e

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAccessoriesFragment;->a:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    .line 72
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAccessoriesFragment;->a:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    const/16 v1, 0xf

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;->setPageMargin(I)V

    .line 73
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAccessoriesFragment;->g:Landroid/view/View;

    const v1, 0x7f0c0073

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAccessoriesFragment;->c:Landroid/widget/LinearLayout;

    .line 74
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAccessoriesFragment;->c:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 75
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAccessoriesFragment;->g:Landroid/view/View;

    const v1, 0x7f0c035c

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/view/View;->setVisibility(I)V

    .line 76
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAccessoriesFragment;->g:Landroid/view/View;

    const v1, 0x7f0c005c

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "ADDITIONAL ACCESSORIES"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 77
    new-instance v0, Lia;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAccessoriesFragment;->d:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAccessoriesFragment;->b:Landroid/view/View;

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAccessoriesFragment;->h:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-direct {v0, v1, p0, v2, v3}, Lia;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAccessoriesFragment;->j:Lia;

    .line 78
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAccessoriesFragment;->j:Lia;

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    new-array v2, v4, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lia;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 81
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAccessoriesFragment;->g:Landroid/view/View;

    return-object v0

    .line 80
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAccessoriesFragment;->g:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAccessoriesFragment;->g:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    goto :goto_0
.end method

.method public onDestroy()V
    .locals 2

    .prologue
    .line 136
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onDestroy()V

    .line 137
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAccessoriesFragment;->j:Lia;

    if-eqz v0, :cond_0

    .line 138
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAccessoriesFragment;->j:Lia;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lia;->cancel(Z)Z

    .line 140
    :cond_0
    return-void
.end method

.method public onResume()V
    .locals 4

    .prologue
    .line 90
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 91
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAccessoriesFragment;->l()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 92
    new-instance v0, Lia;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAccessoriesFragment;->d:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAccessoriesFragment;->b:Landroid/view/View;

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAccessoriesFragment;->h:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-direct {v0, v1, p0, v2, v3}, Lia;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAccessoriesFragment;->j:Lia;

    .line 93
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAccessoriesFragment;->j:Lia;

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lia;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 95
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAccessoriesFragment;->k:Ldy;

    if-eqz v0, :cond_1

    .line 96
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAccessoriesFragment;->k:Ldy;

    invoke-virtual {v0}, Ldy;->notifyDataSetChanged()V

    .line 98
    :cond_1
    return-void
.end method
