.class public Lkx;
.super Landroid/app/Dialog;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field private a:Landroid/content/Context;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 29
    const v0, 0x7f0e002b

    invoke-direct {p0, p1, v0}, Landroid/app/Dialog;-><init>(Landroid/content/Context;I)V

    .line 30
    iput-object p1, p0, Lkx;->a:Landroid/content/Context;

    .line 31
    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 7

    .prologue
    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v6, 0x1

    .line 48
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    const v1, 0x7f0c01cd

    if-ne v0, v1, :cond_5

    .line 49
    invoke-virtual {p0}, Lkx;->dismiss()V

    .line 57
    iget-object v0, p0, Lkx;->a:Landroid/content/Context;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->closeSideMenu()V

    .line 58
    iget-object v0, p0, Lkx;->a:Landroid/content/Context;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const v1, 0x7f0c0033

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v1

    .line 60
    instance-of v0, v1, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    if-eqz v0, :cond_6

    move-object v0, v1

    .line 61
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    .line 63
    :goto_0
    new-instance v2, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    invoke-direct {v2, v6, v6}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;-><init>(ZZ)V

    .line 64
    new-instance v3, Landroid/os/Bundle;

    invoke-direct {v3}, Landroid/os/Bundle;-><init>()V

    .line 65
    const-string v4, "mDotURL"

    const-string v5, "https://www-ssl.bestbuy.com/profile/c/myaccount"

    invoke-virtual {v3, v4, v5}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 67
    invoke-virtual {v2, v3}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->setArguments(Landroid/os/Bundle;)V

    .line 68
    if-eqz v0, :cond_4

    .line 69
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->b()Landroid/support/v4/app/FragmentTabHost;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTabHost;->getCurrentTabTag()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/support/v4/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v1

    .line 70
    if-eqz v1, :cond_3

    .line 71
    instance-of v0, v1, Lcom/bestbuy/android/activities/home/HomeTabContainer;

    if-eqz v0, :cond_0

    move-object v0, v1

    .line 72
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeTabContainer;

    invoke-virtual {v0, v2, v6}, Lcom/bestbuy/android/activities/home/HomeTabContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 74
    :cond_0
    instance-of v0, v1, Lcom/bestbuy/android/activities/browseproduct/ProductTabContainer;

    if-eqz v0, :cond_1

    move-object v0, v1

    .line 75
    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/ProductTabContainer;

    invoke-virtual {v0, v2, v6}, Lcom/bestbuy/android/activities/browseproduct/ProductTabContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 77
    :cond_1
    instance-of v0, v1, Lcom/bestbuy/android/activities/stores/StoreTabContainer;

    if-eqz v0, :cond_2

    move-object v0, v1

    .line 78
    check-cast v0, Lcom/bestbuy/android/activities/stores/StoreTabContainer;

    invoke-virtual {v0, v2, v6}, Lcom/bestbuy/android/activities/stores/StoreTabContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 80
    :cond_2
    instance-of v0, v1, Lcom/bestbuy/android/activities/cart/CartTabContainer;

    if-eqz v0, :cond_3

    .line 81
    check-cast v1, Lcom/bestbuy/android/activities/cart/CartTabContainer;

    invoke-virtual {v1, v2, v6}, Lcom/bestbuy/android/activities/cart/CartTabContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 104
    :cond_3
    :goto_1
    return-void

    .line 85
    :cond_4
    instance-of v0, v1, Lcom/bestbuy/android/base/BaseFragmentContainer;

    if-eqz v0, :cond_3

    .line 86
    check-cast v1, Lcom/bestbuy/android/base/BaseFragmentContainer;

    invoke-virtual {v1, v2, v6}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    goto :goto_1

    .line 90
    :cond_5
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    const v1, 0x7f0c01ce

    if-ne v0, v1, :cond_3

    .line 92
    new-instance v1, Lhr;

    iget-object v0, p0, Lkx;->a:Landroid/content/Context;

    check-cast v0, Landroid/app/Activity;

    invoke-direct {v1, v0}, Lhr;-><init>(Landroid/app/Activity;)V

    new-array v0, v3, [Ljava/lang/Void;

    invoke-virtual {v1, v0}, Lhr;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 93
    invoke-static {}, Lfr;->a()V

    .line 94
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0, v3}, Lnb;->d(Z)V

    .line 95
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0, v6}, Lnb;->e(Z)V

    .line 96
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    const-string v1, ".bestbuy.com"

    iget-object v3, p0, Lkx;->a:Landroid/content/Context;

    invoke-virtual {v0, v1, v3}, Lnb;->a(Ljava/lang/String;Landroid/content/Context;)V

    .line 97
    iget-object v0, p0, Lkx;->a:Landroid/content/Context;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->buildSideMenu()V

    .line 99
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0, v2}, Lnb;->a(Lmr;)V

    .line 100
    iget-object v0, p0, Lkx;->a:Landroid/content/Context;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0, v6}, Lcom/bestbuy/android/activities/home/HomeActivity;->recreateHomeScreen(Z)V

    .line 101
    invoke-virtual {p0}, Lkx;->dismiss()V

    goto :goto_1

    :cond_6
    move-object v0, v2

    goto/16 :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 34
    invoke-super {p0, p1}, Landroid/app/Dialog;->onCreate(Landroid/os/Bundle;)V

    .line 35
    const v0, 0x7f03007a

    invoke-virtual {p0, v0}, Lkx;->setContentView(I)V

    .line 36
    const v0, 0x7f0c01cd

    invoke-virtual {p0, v0}, Lkx;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 37
    const v0, 0x7f0c01ce

    invoke-virtual {p0, v0}, Lkx;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 38
    new-instance v0, Lkx$1;

    invoke-direct {v0, p0}, Lkx$1;-><init>(Lkx;)V

    invoke-virtual {p0, v0}, Lkx;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)V

    .line 44
    return-void
.end method
