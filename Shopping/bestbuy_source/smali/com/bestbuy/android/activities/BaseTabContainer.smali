.class public Lcom/bestbuy/android/activities/BaseTabContainer;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 25
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Landroid/support/v4/app/Fragment;Z)V
    .locals 2

    .prologue
    .line 32
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    new-instance v1, Lcom/bestbuy/android/activities/BaseTabContainer$1;

    invoke-direct {v1, p0, p2, p1}, Lcom/bestbuy/android/activities/BaseTabContainer$1;-><init>(Lcom/bestbuy/android/activities/BaseTabContainer;ZLandroid/support/v4/app/Fragment;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 45
    return-void
.end method

.method public a(Ljava/lang/String;)Z
    .locals 5

    .prologue
    const v4, 0x7f0c009e

    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 65
    .line 67
    const-string v0, "Cart"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 68
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/BaseTabContainer;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->getBackStackEntryCount()I

    move-result v0

    if-ltz v0, :cond_1

    move v0, v2

    .line 71
    :goto_0
    if-eqz v0, :cond_12

    .line 73
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/BaseTabContainer;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 74
    instance-of v1, v0, Lcom/bestbuy/android/activities/cart/MyCartFragment;

    if-eqz v1, :cond_6

    .line 75
    check-cast v0, Lcom/bestbuy/android/activities/cart/MyCartFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/cart/MyCartFragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const v1, 0x7f0c0171

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 76
    instance-of v1, v0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    if-eqz v1, :cond_5

    .line 77
    check-cast v0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    .line 78
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->d()Z

    move-result v1

    if-eqz v1, :cond_4

    .line 79
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->e()V

    .line 130
    :cond_0
    :goto_1
    return v2

    :cond_1
    move v0, v3

    .line 68
    goto :goto_0

    .line 70
    :cond_2
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/BaseTabContainer;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->getBackStackEntryCount()I

    move-result v0

    if-lez v0, :cond_3

    move v0, v2

    goto :goto_0

    :cond_3
    move v0, v3

    goto :goto_0

    :cond_4
    move v2, v3

    .line 81
    goto :goto_1

    :cond_5
    move v2, v3

    .line 83
    goto :goto_1

    .line 84
    :cond_6
    instance-of v1, v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;

    if-nez v1, :cond_7

    instance-of v1, v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;

    if-nez v1, :cond_7

    instance-of v1, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;

    if-nez v1, :cond_7

    instance-of v1, v0, Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;

    if-nez v1, :cond_7

    instance-of v1, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListContainer;

    if-eqz v1, :cond_c

    .line 89
    :cond_7
    invoke-virtual {v0}, Landroid/support/v4/app/Fragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    invoke-virtual {v1, v4}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v1

    .line 90
    instance-of v4, v1, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    if-eqz v4, :cond_a

    move-object v0, v1

    .line 91
    check-cast v0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    .line 92
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->d()Z

    move-result v1

    if-eqz v1, :cond_8

    .line 93
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->e()V

    goto :goto_1

    .line 95
    :cond_8
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/BaseTabContainer;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->getBackStackEntryCount()I

    move-result v0

    if-nez v0, :cond_9

    move v2, v3

    .line 96
    goto :goto_1

    .line 98
    :cond_9
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/BaseTabContainer;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->popBackStack()V

    goto :goto_1

    .line 100
    :cond_a
    instance-of v3, v1, Lcom/bestbuy/android/base/BaseFragmentContainer;

    if-eqz v3, :cond_b

    .line 101
    check-cast v1, Lcom/bestbuy/android/base/BaseFragmentContainer;

    invoke-virtual {v1}, Lcom/bestbuy/android/base/BaseFragmentContainer;->e()Z

    move-result v1

    if-nez v1, :cond_0

    .line 102
    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BaseFragmentContainer;->e()Z

    move-result v0

    if-nez v0, :cond_0

    .line 103
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/BaseTabContainer;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->popBackStack()V

    goto :goto_1

    .line 106
    :cond_b
    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BaseFragmentContainer;->e()Z

    move-result v0

    if-nez v0, :cond_0

    .line 107
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/BaseTabContainer;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->popBackStack()V

    goto/16 :goto_1

    .line 108
    :cond_c
    instance-of v1, v0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    if-eqz v1, :cond_11

    .line 109
    check-cast v0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    .line 110
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->d()Z

    move-result v1

    if-eqz v1, :cond_f

    .line 111
    sget-boolean v1, Lnu;->a:Z

    if-eqz v1, :cond_e

    .line 112
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/BaseTabContainer;

    .line 113
    instance-of v1, v0, Lcom/bestbuy/android/activities/cart/CartTabContainer;

    if-eqz v1, :cond_d

    .line 114
    check-cast v0, Lcom/bestbuy/android/activities/cart/CartTabContainer;

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/activities/cart/CartTabContainer;->a(Z)V

    .line 116
    :cond_d
    sput-boolean v3, Lnu;->a:Z

    goto/16 :goto_1

    .line 119
    :cond_e
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->e()V

    goto/16 :goto_1

    .line 121
    :cond_f
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/BaseTabContainer;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->getBackStackEntryCount()I

    move-result v0

    if-nez v0, :cond_10

    move v2, v3

    .line 122
    goto/16 :goto_1

    .line 124
    :cond_10
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/BaseTabContainer;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->popBackStack()V

    goto/16 :goto_1

    .line 127
    :cond_11
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/BaseTabContainer;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->popBackStack()V

    goto/16 :goto_1

    :cond_12
    move v2, v3

    goto/16 :goto_1
.end method

.method public a_()V
    .locals 1

    .prologue
    .line 134
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/BaseTabContainer;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->popBackStack()V

    .line 135
    return-void
.end method

.method public b()Landroid/support/v4/app/Fragment;
    .locals 2

    .prologue
    .line 138
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/BaseTabContainer;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 139
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/BaseTabContainer;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const v1, 0x7f0c009e

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 140
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public c()V
    .locals 4

    .prologue
    .line 144
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/BaseTabContainer;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->getFragments()Ljava/util/List;

    move-result-object v1

    .line 145
    const/4 v0, 0x0

    :goto_0
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v2

    if-ge v0, v2, :cond_0

    .line 146
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/BaseTabContainer;->b()Landroid/support/v4/app/Fragment;

    move-result-object v2

    .line 147
    instance-of v3, v2, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;

    if-nez v3, :cond_0

    instance-of v3, v2, Lcom/bestbuy/android/activities/home/HomeFragment;

    if-nez v3, :cond_0

    instance-of v2, v2, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    if-eqz v2, :cond_1

    .line 160
    :cond_0
    return-void

    .line 152
    :cond_1
    new-instance v2, Landroid/os/Handler;

    invoke-direct {v2}, Landroid/os/Handler;-><init>()V

    new-instance v3, Lcom/bestbuy/android/activities/BaseTabContainer$2;

    invoke-direct {v3, p0}, Lcom/bestbuy/android/activities/BaseTabContainer$2;-><init>(Lcom/bestbuy/android/activities/BaseTabContainer;)V

    invoke-virtual {v2, v3}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 145
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method

.method public onResume()V
    .locals 0

    .prologue
    .line 28
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 29
    return-void
.end method
