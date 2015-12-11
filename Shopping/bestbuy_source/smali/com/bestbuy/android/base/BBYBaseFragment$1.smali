.class Lcom/bestbuy/android/base/BBYBaseFragment$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/base/BBYBaseFragment;->a(Lcom/bestbuy/android/api/lib/models/search/SearchApi;Ljava/lang/String;)V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/api/lib/models/search/SearchApi;

.field final synthetic b:Ljava/lang/String;

.field final synthetic c:Landroid/support/v4/app/Fragment;

.field final synthetic d:Lcom/bestbuy/android/activities/home/HomeTabFragment;

.field final synthetic e:Lcom/bestbuy/android/base/BBYBaseFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/base/BBYBaseFragment;Lcom/bestbuy/android/api/lib/models/search/SearchApi;Ljava/lang/String;Landroid/support/v4/app/Fragment;Lcom/bestbuy/android/activities/home/HomeTabFragment;)V
    .locals 0

    .prologue
    .line 100
    iput-object p1, p0, Lcom/bestbuy/android/base/BBYBaseFragment$1;->e:Lcom/bestbuy/android/base/BBYBaseFragment;

    iput-object p2, p0, Lcom/bestbuy/android/base/BBYBaseFragment$1;->a:Lcom/bestbuy/android/api/lib/models/search/SearchApi;

    iput-object p3, p0, Lcom/bestbuy/android/base/BBYBaseFragment$1;->b:Ljava/lang/String;

    iput-object p4, p0, Lcom/bestbuy/android/base/BBYBaseFragment$1;->c:Landroid/support/v4/app/Fragment;

    iput-object p5, p0, Lcom/bestbuy/android/base/BBYBaseFragment$1;->d:Lcom/bestbuy/android/activities/home/HomeTabFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 10

    .prologue
    const/4 v5, 0x0

    const v9, 0x7f0c0033

    const/4 v8, 0x0

    const/4 v7, 0x1

    .line 103
    .line 105
    const-string v0, ""

    .line 106
    iget-object v0, p0, Lcom/bestbuy/android/base/BBYBaseFragment$1;->a:Lcom/bestbuy/android/api/lib/models/search/SearchApi;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->getSkuDetails()Ljava/util/ArrayList;

    move-result-object v6

    .line 107
    invoke-virtual {v6}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ne v0, v7, :cond_2

    .line 108
    invoke-virtual {v6, v8}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    .line 109
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSkuId()Ljava/lang/String;

    move-result-object v2

    .line 111
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 112
    const-string v3, "bb.searchTerm"

    invoke-virtual {v1, v3, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 113
    const-string v3, "bb.numResults"

    invoke-virtual {v6}, Ljava/util/ArrayList;->size()I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v1, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 114
    sget-object v3, Llu;->bo:Ljava/lang/String;

    const-string v4, "browse,pdp"

    invoke-virtual {v1, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 115
    sget-object v3, Llu;->bp:Ljava/lang/String;

    const-string v4, "PDH"

    invoke-virtual {v1, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 116
    sget-object v3, Llu;->e:Ljava/lang/String;

    invoke-static {v3, v1}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 118
    iget-object v1, p0, Lcom/bestbuy/android/base/BBYBaseFragment$1;->e:Lcom/bestbuy/android/base/BBYBaseFragment;

    iget-object v1, v1, Lcom/bestbuy/android/base/BBYBaseFragment;->d:Landroid/app/Activity;

    check-cast v1, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v1}, Lcom/bestbuy/android/activities/home/HomeActivity;->getCurrentActionBarTitle()Ljava/lang/String;

    move-result-object v3

    .line 119
    new-instance v1, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getProductId()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v2, v0, v8, v8}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;-><init>(Ljava/lang/String;Ljava/lang/String;ZZ)V

    .line 120
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;

    invoke-direct {v0, v3}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;-><init>(Ljava/lang/String;)V

    move-object v4, v0

    .line 124
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/base/BBYBaseFragment$1;->c:Landroid/support/v4/app/Fragment;

    instance-of v0, v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    if-eqz v0, :cond_5

    .line 125
    iget-object v0, p0, Lcom/bestbuy/android/base/BBYBaseFragment$1;->c:Landroid/support/v4/app/Fragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/base/BBYBaseFragment$1;->c:Landroid/support/v4/app/Fragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;

    if-eqz v0, :cond_3

    .line 126
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/base/BBYBaseFragment$1;->c:Landroid/support/v4/app/Fragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;

    if-eqz v0, :cond_1

    .line 127
    instance-of v0, v1, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    if-eqz v0, :cond_1

    move-object v0, v1

    .line 128
    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    invoke-virtual {v0, v7}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->b(Z)V

    move-object v0, v1

    .line 129
    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    invoke-virtual {v0, v7}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->c(Z)V

    .line 132
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/base/BBYBaseFragment$1;->c:Landroid/support/v4/app/Fragment;

    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    invoke-virtual {v0, v1, v7}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 171
    :goto_1
    return-void

    .line 122
    :cond_2
    new-instance v1, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    iget-object v0, p0, Lcom/bestbuy/android/base/BBYBaseFragment$1;->b:Ljava/lang/String;

    iget-object v2, p0, Lcom/bestbuy/android/base/BBYBaseFragment$1;->a:Lcom/bestbuy/android/api/lib/models/search/SearchApi;

    invoke-direct {v1, v0, v2, v7}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;-><init>(Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/search/SearchApi;Z)V

    move-object v4, v5

    goto :goto_0

    .line 134
    :cond_3
    invoke-virtual {v6}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ne v0, v7, :cond_4

    .line 135
    iget-object v0, p0, Lcom/bestbuy/android/base/BBYBaseFragment$1;->e:Lcom/bestbuy/android/base/BBYBaseFragment;

    iget-object v0, v0, Lcom/bestbuy/android/base/BBYBaseFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v2, "PDPFragmentContainer"

    invoke-virtual {v0, v9, v4, v2}, Lcom/bestbuy/android/activities/home/HomeActivity;->addFragment(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)V

    move-object v0, v1

    .line 136
    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;

    invoke-virtual {v0, v7}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->b(Z)V

    .line 137
    invoke-virtual {v4, v1, v7}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    goto :goto_1

    .line 139
    :cond_4
    new-instance v2, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;

    invoke-direct {v2, v8, v7}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;-><init>(ZZ)V

    move-object v0, v1

    .line 140
    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    invoke-virtual {v0, v7}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->b(Z)V

    move-object v0, v1

    .line 141
    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    invoke-virtual {v0, v7}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->c(Z)V

    .line 142
    iget-object v0, p0, Lcom/bestbuy/android/base/BBYBaseFragment$1;->e:Lcom/bestbuy/android/base/BBYBaseFragment;

    iget-object v0, v0, Lcom/bestbuy/android/base/BBYBaseFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v3, "PLPFragmentContainer"

    invoke-virtual {v0, v9, v2, v3}, Lcom/bestbuy/android/activities/home/HomeActivity;->addFragment(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)V

    .line 143
    invoke-virtual {v2, v1, v7}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    goto :goto_1

    .line 147
    :cond_5
    iget-object v0, p0, Lcom/bestbuy/android/base/BBYBaseFragment$1;->d:Lcom/bestbuy/android/activities/home/HomeTabFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const-string v2, "PRODUCTS"

    invoke-virtual {v0, v2}, Landroid/support/v4/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v2

    move-object v0, v2

    .line 148
    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/ProductTabContainer;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/ProductTabContainer;->b()Landroid/support/v4/app/Fragment;

    move-result-object v3

    .line 150
    invoke-virtual {v3}, Landroid/support/v4/app/Fragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    if-eqz v0, :cond_6

    invoke-virtual {v3}, Landroid/support/v4/app/Fragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->getFragments()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_6

    invoke-virtual {v3}, Landroid/support/v4/app/Fragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->getFragments()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_6

    .line 152
    invoke-virtual {v3}, Landroid/support/v4/app/Fragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->getFragments()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v8}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v4/app/Fragment;

    move-object v5, v0

    .line 154
    :cond_6
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;

    invoke-direct {v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;-><init>()V

    .line 155
    if-eqz v5, :cond_7

    instance-of v5, v5, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    if-eqz v5, :cond_7

    move-object v0, v3

    .line 156
    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    invoke-virtual {v0, v1, v8}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    goto/16 :goto_1

    .line 158
    :cond_7
    instance-of v5, v3, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    if-eqz v5, :cond_8

    .line 159
    check-cast v3, Lcom/bestbuy/android/base/BaseFragmentContainer;

    invoke-virtual {v3, v1, v7}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    goto/16 :goto_1

    .line 162
    :cond_8
    invoke-virtual {v6}, Ljava/util/ArrayList;->size()I

    move-result v3

    if-ne v3, v7, :cond_9

    .line 163
    check-cast v2, Lcom/bestbuy/android/activities/BaseTabContainer;

    invoke-virtual {v2, v4, v7}, Lcom/bestbuy/android/activities/BaseTabContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 164
    invoke-virtual {v4, v1, v7}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    goto/16 :goto_1

    .line 166
    :cond_9
    check-cast v2, Lcom/bestbuy/android/activities/BaseTabContainer;

    invoke-virtual {v2, v0, v7}, Lcom/bestbuy/android/activities/BaseTabContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 167
    invoke-virtual {v0, v1, v7}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    goto/16 :goto_1
.end method
