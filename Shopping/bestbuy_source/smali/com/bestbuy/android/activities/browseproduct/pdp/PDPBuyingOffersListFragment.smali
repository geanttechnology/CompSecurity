.class public Lcom/bestbuy/android/activities/browseproduct/pdp/PDPBuyingOffersListFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"


# instance fields
.field private a:Landroid/view/View;

.field private b:Landroid/widget/ListView;

.field private c:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/ProductOffer;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 31
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 33
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPBuyingOffersListFragment;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 25
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPBuyingOffersListFragment;->c:Ljava/util/ArrayList;

    return-object v0
.end method

.method private a(Landroid/support/v4/app/Fragment;)V
    .locals 3

    .prologue
    .line 80
    const-string v1, ""

    .line 81
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPBuyingOffersListFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    .line 82
    const v2, 0x7f0c0033

    invoke-virtual {v0, v2}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 83
    instance-of v2, v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    if-eqz v2, :cond_0

    .line 84
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    .line 85
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->b()Landroid/support/v4/app/FragmentTabHost;

    move-result-object v2

    invoke-virtual {v2}, Landroid/support/v4/app/FragmentTabHost;->getCurrentTab()I

    move-result v2

    packed-switch v2, :pswitch_data_0

    .line 99
    :goto_0
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 100
    check-cast v0, Lcom/bestbuy/android/activities/BaseTabContainer;

    const/4 v1, 0x1

    invoke-virtual {v0, p1, v1}, Lcom/bestbuy/android/activities/BaseTabContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 102
    :cond_0
    return-void

    .line 87
    :pswitch_0
    const-string v1, "HOME"

    goto :goto_0

    .line 90
    :pswitch_1
    const-string v1, "PRODUCTS"

    goto :goto_0

    .line 93
    :pswitch_2
    const-string v1, "STORES"

    goto :goto_0

    .line 96
    :pswitch_3
    const-string v1, "CART"

    goto :goto_0

    .line 85
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPBuyingOffersListFragment;Landroid/support/v4/app/Fragment;)V
    .locals 0

    .prologue
    .line 25
    invoke-direct {p0, p1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPBuyingOffersListFragment;->a(Landroid/support/v4/app/Fragment;)V

    return-void
.end method


# virtual methods
.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 46
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 47
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 41
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 42
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPBuyingOffersListFragment;->d:Landroid/app/Activity;

    .line 43
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 50
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 51
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 4

    .prologue
    .line 55
    const v0, 0x7f030091

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPBuyingOffersListFragment;->a:Landroid/view/View;

    .line 56
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPBuyingOffersListFragment;->a:Landroid/view/View;

    const v1, 0x7f0c023b

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPBuyingOffersListFragment;->b:Landroid/widget/ListView;

    .line 57
    new-instance v0, Lez;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPBuyingOffersListFragment;->d:Landroid/app/Activity;

    const v2, 0x7f0300d6

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPBuyingOffersListFragment;->c:Ljava/util/ArrayList;

    invoke-direct {v0, v1, v2, v3}, Lez;-><init>(Landroid/app/Activity;ILjava/util/ArrayList;)V

    .line 58
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPBuyingOffersListFragment;->b:Landroid/widget/ListView;

    invoke-virtual {v1, v0}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 59
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPBuyingOffersListFragment;->b:Landroid/widget/ListView;

    new-instance v1, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPBuyingOffersListFragment$1;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPBuyingOffersListFragment$1;-><init>(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPBuyingOffersListFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 72
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPBuyingOffersListFragment;->a:Landroid/view/View;

    return-object v0
.end method

.method public onResume()V
    .locals 0

    .prologue
    .line 76
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 77
    return-void
.end method
