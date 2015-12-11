.class public Lcom/bestbuy/android/activities/cart/CartTabContainer;
.super Lcom/bestbuy/android/activities/BaseTabContainer;
.source "SourceFile"


# instance fields
.field private a:Landroid/view/View;

.field private b:Landroid/view/View;

.field private c:Z

.field private g:Lnb;

.field private h:Landroid/app/Activity;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 28
    invoke-direct {p0}, Lcom/bestbuy/android/activities/BaseTabContainer;-><init>()V

    .line 33
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/cart/CartTabContainer;->c:Z

    return-void
.end method


# virtual methods
.method public a(Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;Ljava/lang/String;)V
    .locals 7

    .prologue
    const/4 v3, 0x1

    .line 121
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getSkuId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getProductId()Ljava/lang/String;

    move-result-object v2

    const/4 v5, 0x0

    move-object v4, p1

    move v6, v3

    invoke-direct/range {v0 .. v6}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;-><init>(Ljava/lang/String;Ljava/lang/String;ZLcom/bestbuy/android/api/lib/models/dnm/DNMProduct;ZI)V

    .line 122
    new-instance v1, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;

    invoke-direct {v1, p2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;-><init>(Ljava/lang/String;)V

    .line 123
    invoke-virtual {p0, v1, v3}, Lcom/bestbuy/android/activities/cart/CartTabContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 124
    invoke-virtual {v1, v0, v3}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 125
    return-void
.end method

.method public a(Z)V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 64
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/cart/CartTabContainer;->c:Z

    .line 66
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v0

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/cart/CartTabContainer;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080031

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1, v3}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v0

    .line 67
    if-lez v0, :cond_0

    .line 68
    iput-boolean v3, p0, Lcom/bestbuy/android/activities/cart/CartTabContainer;->c:Z

    .line 70
    :cond_0
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/cart/CartTabContainer;->c:Z

    if-eqz v0, :cond_1

    invoke-static {}, Lfr;->d()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_3

    .line 71
    :cond_1
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/cart/CartTabContainer;->b()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 72
    instance-of v0, v0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    if-nez v0, :cond_2

    .line 73
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/cart/CartTabContainer;->e()V

    .line 86
    :cond_2
    :goto_0
    return-void

    .line 76
    :cond_3
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 77
    sget-object v1, Llu;->bo:Ljava/lang/String;

    const-string v2, "cart"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 78
    sget-object v1, Llu;->bp:Ljava/lang/String;

    const-string v2, "CRT"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 79
    invoke-static {}, Lfr;->c()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_4

    invoke-static {}, Lfr;->c()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_4

    .line 80
    sget-object v1, Llu;->G:Ljava/lang/String;

    invoke-static {v1, v0}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 84
    :goto_1
    new-instance v0, Lcom/bestbuy/android/activities/cart/MyCartFragment;

    invoke-direct {v0}, Lcom/bestbuy/android/activities/cart/MyCartFragment;-><init>()V

    invoke-virtual {p0, v0, v3}, Lcom/bestbuy/android/activities/cart/CartTabContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    goto :goto_0

    .line 82
    :cond_4
    sget-object v1, Llu;->F:Ljava/lang/String;

    invoke-static {v1, v0}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    goto :goto_1
.end method

.method public d()V
    .locals 2

    .prologue
    .line 58
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/cart/CartTabContainer;->g:Lnb;

    .line 59
    iget-object v0, p0, Lcom/bestbuy/android/activities/cart/CartTabContainer;->b:Landroid/view/View;

    const v1, 0x7f0c0064

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/cart/CartTabContainer;->a:Landroid/view/View;

    .line 60
    const/4 v0, 0x0

    sput-boolean v0, Lnu;->a:Z

    .line 61
    return-void
.end method

.method public e()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 90
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v0

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/cart/CartTabContainer;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080031

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1, v4}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v0

    .line 91
    if-lez v0, :cond_0

    .line 92
    iget-object v0, p0, Lcom/bestbuy/android/activities/cart/CartTabContainer;->h:Landroid/app/Activity;

    const-string v1, "sharedPrefs"

    invoke-virtual {v0, v1, v4}, Landroid/app/Activity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 93
    const-string v1, "skusInCart"

    const-string v2, ""

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 94
    const-string v1, " "

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 95
    const-string v1, " "

    const-string v2, ";"

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    .line 98
    :cond_0
    new-instance v0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    invoke-direct {v0, v4}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;-><init>(Z)V

    .line 99
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 100
    const-string v2, "mDotURL"

    iget-object v3, p0, Lcom/bestbuy/android/activities/cart/CartTabContainer;->g:Lnb;

    invoke-virtual {v3}, Lnb;->g()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 101
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/cart/CartTabContainer;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f080059

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    iget-boolean v3, p0, Lcom/bestbuy/android/activities/cart/CartTabContainer;->c:Z

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 102
    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->setArguments(Landroid/os/Bundle;)V

    .line 103
    invoke-virtual {p0, v0, v4}, Lcom/bestbuy/android/activities/cart/CartTabContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 104
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 51
    invoke-super {p0, p1}, Lcom/bestbuy/android/activities/BaseTabContainer;->onActivityCreated(Landroid/os/Bundle;)V

    .line 52
    iget-object v0, p0, Lcom/bestbuy/android/activities/cart/CartTabContainer;->h:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->showActionBarHome()V

    .line 53
    iget-object v0, p0, Lcom/bestbuy/android/activities/cart/CartTabContainer;->h:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const-string v1, "Cart"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 54
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/cart/CartTabContainer;->d()V

    .line 55
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 39
    invoke-super {p0, p1}, Lcom/bestbuy/android/activities/BaseTabContainer;->onAttach(Landroid/app/Activity;)V

    .line 40
    iput-object p1, p0, Lcom/bestbuy/android/activities/cart/CartTabContainer;->h:Landroid/app/Activity;

    .line 41
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 45
    const v0, 0x7f03001f

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/cart/CartTabContainer;->b:Landroid/view/View;

    .line 46
    iget-object v0, p0, Lcom/bestbuy/android/activities/cart/CartTabContainer;->b:Landroid/view/View;

    return-object v0
.end method

.method public onResume()V
    .locals 1

    .prologue
    .line 107
    invoke-super {p0}, Lcom/bestbuy/android/activities/BaseTabContainer;->onResume()V

    .line 108
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/cart/CartTabContainer;->a(Z)V

    .line 109
    return-void
.end method
