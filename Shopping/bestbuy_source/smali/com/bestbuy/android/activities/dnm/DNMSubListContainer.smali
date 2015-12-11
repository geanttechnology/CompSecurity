.class public Lcom/bestbuy/android/activities/dnm/DNMSubListContainer;
.super Lcom/bestbuy/android/base/BaseFragmentContainer;
.source "SourceFile"


# instance fields
.field private a:Landroid/app/Activity;

.field private b:Lnb;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 21
    invoke-direct {p0}, Lcom/bestbuy/android/base/BaseFragmentContainer;-><init>()V

    .line 23
    return-void
.end method


# virtual methods
.method public b()Landroid/support/v4/app/Fragment;
    .locals 2

    .prologue
    .line 50
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/dnm/DNMSubListContainer;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 51
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/dnm/DNMSubListContainer;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const v1, 0x7f0c009e

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 52
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 38
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BaseFragmentContainer;->onActivityCreated(Landroid/os/Bundle;)V

    .line 39
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListContainer;->b:Lnb;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lnb;->h(Z)V

    .line 40
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 1

    .prologue
    .line 26
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BaseFragmentContainer;->onAttach(Landroid/app/Activity;)V

    .line 27
    iput-object p1, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListContainer;->a:Landroid/app/Activity;

    .line 28
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListContainer;->b:Lnb;

    .line 29
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 33
    const v0, 0x7f0300d3

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onDestroy()V
    .locals 2

    .prologue
    .line 57
    invoke-super {p0}, Lcom/bestbuy/android/base/BaseFragmentContainer;->onDestroy()V

    .line 58
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListContainer;->b:Lnb;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lnb;->h(Z)V

    .line 59
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/dnm/DNMSubListContainer;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f0802ef

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 60
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListContainer;->a:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/home/HomeActivity;->updateSearchHint(Ljava/lang/String;)V

    .line 61
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListContainer;->a:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->showActionBarHome()V

    .line 62
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListContainer;->a:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListContainer;->b:Lnb;

    invoke-virtual {v1}, Lnb;->T()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 63
    return-void
.end method

.method public onResume()V
    .locals 1

    .prologue
    .line 45
    invoke-super {p0}, Lcom/bestbuy/android/base/BaseFragmentContainer;->onResume()V

    .line 46
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListContainer;->a:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->hideActionBarHome()V

    .line 47
    return-void
.end method
