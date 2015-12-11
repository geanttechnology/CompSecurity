.class public Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoViewedFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field private a:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

.field private b:Landroid/widget/LinearLayout;

.field private c:Landroid/view/View;

.field private g:Landroid/view/View;

.field private h:Ljava/lang/String;

.field private i:Ljava/lang/String;

.field private j:Lhe;

.field private k:Z

.field private l:Ldy;

.field private m:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 44
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 40
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoViewedFragment;->k:Z

    .line 45
    return-void
.end method

.method public constructor <init>(Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;)V
    .locals 1

    .prologue
    .line 47
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 40
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoViewedFragment;->k:Z

    .line 48
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getSkuId()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoViewedFragment;->h:Ljava/lang/String;

    .line 49
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoViewedFragment;->m:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    .line 50
    return-void
.end method


# virtual methods
.method public a(Ljava/util/ArrayList;)V
    .locals 7
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

    .line 117
    new-instance v0, Ldy;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoViewedFragment;->d:Landroid/app/Activity;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoViewedFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v3

    const-string v5, "customeralsoviewed"

    iget-object v6, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoViewedFragment;->i:Ljava/lang/String;

    move-object v2, p1

    invoke-direct/range {v0 .. v6}, Ldy;-><init>(Landroid/app/Activity;Ljava/util/ArrayList;Landroid/support/v4/app/Fragment;ZLjava/lang/String;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoViewedFragment;->l:Ldy;

    .line 118
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoViewedFragment;->a:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoViewedFragment;->l:Ldy;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;->setAdapter(Landroid/support/v4/view/PagerAdapter;)V

    .line 119
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoViewedFragment;->a:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoViewedFragment;->d:Landroid/app/Activity;

    invoke-static {v1}, Lll;->a(Landroid/app/Activity;)Landroid/view/animation/Animation;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;->startAnimation(Landroid/view/animation/Animation;)V

    .line 120
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ne v0, v4, :cond_0

    .line 121
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoViewedFragment;->a:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;->setPagingEnabled(Z)V

    .line 123
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoViewedFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0, p1}, Lcom/bestbuy/android/activities/home/HomeActivity;->customerAlsoViewedRecommendations(Ljava/util/ArrayList;)V

    .line 124
    return-void
.end method

.method public b()V
    .locals 1

    .prologue
    .line 107
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoViewedFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 108
    invoke-virtual {v0}, Landroid/support/v4/app/Fragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    .line 109
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    .line 110
    invoke-virtual {v0, p0}, Landroid/support/v4/app/FragmentTransaction;->remove(Landroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    .line 111
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTransaction;->commitAllowingStateLoss()I

    .line 112
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 92
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 93
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 67
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 68
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoViewedFragment;->d:Landroid/app/Activity;

    .line 69
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 9

    .prologue
    const/4 v1, 0x1

    .line 128
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoViewedFragment;->b:Landroid/widget/LinearLayout;

    if-ne p1, v0, :cond_0

    .line 129
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoViewedFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoViewedFragment;->d:Landroid/app/Activity;

    const/4 v3, 0x0

    invoke-virtual {v0, v2, v3}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->changeActionBarShareVisibility(Landroid/app/Activity;Z)V

    .line 131
    new-instance v8, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;

    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoViewedFragment;->k:Z

    invoke-direct {v8, v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;-><init>(Z)V

    .line 132
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    const-string v2, "CustomerAlsoViewed"

    const-string v3, "Customers Also Viewed"

    const-string v4, "all"

    iget-object v5, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoViewedFragment;->h:Ljava/lang/String;

    const-string v6, "Home"

    const/16 v7, 0xa

    invoke-direct/range {v0 .. v7}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;-><init>(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V

    .line 134
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoViewedFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v2

    check-cast v2, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;

    .line 135
    invoke-virtual {v2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v2

    check-cast v2, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;

    invoke-virtual {v2, v8, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 136
    invoke-virtual {v8, v0, v1}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 138
    :cond_0
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 57
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 58
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoViewedFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    .line 59
    if-eqz v0, :cond_0

    const-string v1, "isFromMdot"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 60
    const-string v1, "isFromMdot"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v1

    iput-boolean v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoViewedFragment;->k:Z

    .line 61
    const-string v1, "BreadCrumb"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoViewedFragment;->i:Ljava/lang/String;

    .line 63
    :cond_0
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 73
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoViewedFragment;->g:Landroid/view/View;

    if-nez v0, :cond_0

    .line 74
    const v0, 0x7f0300db

    invoke-virtual {p1, v0, p2, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoViewedFragment;->g:Landroid/view/View;

    .line 75
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoViewedFragment;->g:Landroid/view/View;

    const v1, 0x7f0c0064

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoViewedFragment;->c:Landroid/view/View;

    .line 76
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoViewedFragment;->g:Landroid/view/View;

    const v1, 0x7f0c005e

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoViewedFragment;->a:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    .line 77
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoViewedFragment;->a:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    const/16 v1, 0xf

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;->setPageMargin(I)V

    .line 78
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoViewedFragment;->g:Landroid/view/View;

    const v1, 0x7f0c0073

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoViewedFragment;->b:Landroid/widget/LinearLayout;

    .line 79
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoViewedFragment;->b:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 80
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoViewedFragment;->g:Landroid/view/View;

    const v1, 0x7f0c035c

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/view/View;->setVisibility(I)V

    .line 81
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoViewedFragment;->g:Landroid/view/View;

    const v1, 0x7f0c005c

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "CUSTOMERS ALSO VIEWED"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 82
    new-instance v0, Lhe;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoViewedFragment;->d:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoViewedFragment;->c:Landroid/view/View;

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoViewedFragment;->h:Ljava/lang/String;

    invoke-direct {v0, v1, p0, v2, v3}, Lhe;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoViewedFragment;->j:Lhe;

    .line 83
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoViewedFragment;->j:Lhe;

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    new-array v2, v4, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lhe;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 87
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoViewedFragment;->g:Landroid/view/View;

    return-object v0

    .line 86
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoViewedFragment;->g:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoViewedFragment;->g:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    goto :goto_0
.end method

.method public onDestroy()V
    .locals 2

    .prologue
    .line 141
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onDestroy()V

    .line 142
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoViewedFragment;->j:Lhe;

    if-eqz v0, :cond_0

    .line 143
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoViewedFragment;->j:Lhe;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lhe;->cancel(Z)Z

    .line 145
    :cond_0
    return-void
.end method

.method public onResume()V
    .locals 4

    .prologue
    .line 96
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 97
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoViewedFragment;->l()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 98
    new-instance v0, Lhe;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoViewedFragment;->d:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoViewedFragment;->c:Landroid/view/View;

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoViewedFragment;->h:Ljava/lang/String;

    invoke-direct {v0, v1, p0, v2, v3}, Lhe;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoViewedFragment;->j:Lhe;

    .line 99
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoViewedFragment;->j:Lhe;

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lhe;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 101
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoViewedFragment;->l:Ldy;

    if-eqz v0, :cond_1

    .line 102
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoViewedFragment;->l:Ldy;

    invoke-virtual {v0}, Ldy;->notifyDataSetChanged()V

    .line 104
    :cond_1
    return-void
.end method
