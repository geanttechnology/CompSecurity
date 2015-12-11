.class Lcom/bestbuy/android/activities/home/HomeTabFragment$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/TabHost$OnTabChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/home/HomeTabFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/home/HomeTabFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/home/HomeTabFragment;)V
    .locals 0

    .prologue
    .line 83
    iput-object p1, p0, Lcom/bestbuy/android/activities/home/HomeTabFragment$1;->a:Lcom/bestbuy/android/activities/home/HomeTabFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onTabChanged(Ljava/lang/String;)V
    .locals 5

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x1

    .line 87
    .line 88
    sput-boolean v3, Lcom/bestbuy/android/activities/home/HomeTabContainer;->a:Z

    .line 89
    const-string v0, "PRODUCTS"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 90
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 91
    sget-object v1, Llu;->bo:Ljava/lang/String;

    const-string v4, "browse,products"

    invoke-virtual {v0, v1, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 92
    sget-object v1, Llu;->bp:Ljava/lang/String;

    const-string v4, "PRD"

    invoke-virtual {v0, v1, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 93
    sget-object v1, Llu;->D:Ljava/lang/String;

    invoke-static {v1, v0}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 94
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeTabFragment$1;->a:Lcom/bestbuy/android/activities/home/HomeTabFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const-string v1, "PRODUCTS"

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v1

    .line 95
    instance-of v0, v1, Lcom/bestbuy/android/activities/browseproduct/ProductTabContainer;

    if-eqz v0, :cond_5

    move-object v0, v1

    .line 96
    check-cast v0, Lcom/bestbuy/android/activities/BaseTabContainer;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/BaseTabContainer;->c()V

    .line 97
    check-cast v1, Lcom/bestbuy/android/activities/browseproduct/ProductTabContainer;

    invoke-virtual {v1}, Lcom/bestbuy/android/activities/browseproduct/ProductTabContainer;->b()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 98
    instance-of v1, v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;

    if-nez v1, :cond_0

    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;

    if-eqz v0, :cond_5

    :cond_0
    move v0, v3

    .line 116
    :goto_0
    invoke-virtual {p1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v1

    .line 117
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v3, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v1, v2}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 118
    iget-object v2, p0, Lcom/bestbuy/android/activities/home/HomeTabFragment$1;->a:Lcom/bestbuy/android/activities/home/HomeTabFragment;

    invoke-static {v2}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->a(Lcom/bestbuy/android/activities/home/HomeTabFragment;)Lnb;

    move-result-object v2

    invoke-virtual {v2, v1}, Lnb;->h(Ljava/lang/String;)V

    .line 119
    if-eqz v0, :cond_1

    .line 120
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeTabFragment$1;->a:Lcom/bestbuy/android/activities/home/HomeTabFragment;

    iget-object v0, v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/home/HomeActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 121
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeTabFragment$1;->a:Lcom/bestbuy/android/activities/home/HomeTabFragment;

    iget-object v0, v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getCurrentActionBarTitle()Ljava/lang/String;

    move-result-object v0

    .line 122
    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeTabFragment$1;->a:Lcom/bestbuy/android/activities/home/HomeTabFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->a(Lcom/bestbuy/android/activities/home/HomeTabFragment;)Lnb;

    move-result-object v1

    invoke-virtual {v1}, Lnb;->U()Ljava/util/Stack;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/Stack;->clear()V

    .line 123
    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeTabFragment$1;->a:Lcom/bestbuy/android/activities/home/HomeTabFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->a(Lcom/bestbuy/android/activities/home/HomeTabFragment;)Lnb;

    move-result-object v1

    invoke-virtual {v1, v0}, Lnb;->i(Ljava/lang/String;)V

    .line 124
    const-string v1, "Products"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_2

    const-string v1, "Home"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_2

    const-string v1, "Stores"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_2

    const-string v1, "Cart"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 128
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeTabFragment$1;->a:Lcom/bestbuy/android/activities/home/HomeTabFragment;

    iget-object v0, v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->showActionBarHome()V

    .line 131
    :goto_1
    return-void

    .line 103
    :cond_3
    const-string v0, "HOME"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 104
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeTabFragment$1;->a:Lcom/bestbuy/android/activities/home/HomeTabFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const-string v1, "HOME"

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 105
    check-cast v0, Lcom/bestbuy/android/activities/BaseTabContainer;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/BaseTabContainer;->c()V

    .line 106
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 107
    sget-object v1, Llu;->bo:Ljava/lang/String;

    const-string v4, "browse,home"

    invoke-virtual {v0, v1, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 108
    sget-object v1, Llu;->bp:Ljava/lang/String;

    const-string v4, "GHP"

    invoke-virtual {v0, v1, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 109
    sget-object v1, Llu;->a:Ljava/lang/String;

    invoke-static {v1, v0}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 110
    sput-boolean v2, Lcom/bestbuy/android/activities/home/HomeTabContainer;->a:Z

    move v0, v2

    .line 111
    goto/16 :goto_0

    :cond_4
    const-string v0, "STORES"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 112
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeTabFragment$1;->a:Lcom/bestbuy/android/activities/home/HomeTabFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const-string v1, "STORES"

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 113
    if-eqz v0, :cond_5

    .line 114
    check-cast v0, Lcom/bestbuy/android/activities/BaseTabContainer;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/BaseTabContainer;->c()V

    :cond_5
    move v0, v2

    goto/16 :goto_0

    .line 130
    :cond_6
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeTabFragment$1;->a:Lcom/bestbuy/android/activities/home/HomeTabFragment;

    iget-object v0, v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->hideActionBarHome()V

    goto :goto_1
.end method
