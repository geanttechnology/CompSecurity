.class public Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;
.super Lcom/bestbuy/android/base/BaseFragmentContainer;
.source "SourceFile"


# instance fields
.field private a:Z

.field private b:Z


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 26
    invoke-direct {p0}, Lcom/bestbuy/android/base/BaseFragmentContainer;-><init>()V

    .line 23
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;->a:Z

    .line 24
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;->b:Z

    .line 27
    return-void
.end method

.method public constructor <init>(Z)V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 29
    invoke-direct {p0}, Lcom/bestbuy/android/base/BaseFragmentContainer;-><init>()V

    .line 23
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;->a:Z

    .line 24
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;->b:Z

    .line 30
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;->a:Z

    .line 31
    return-void
.end method

.method public constructor <init>(ZZ)V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 33
    invoke-direct {p0}, Lcom/bestbuy/android/base/BaseFragmentContainer;-><init>()V

    .line 23
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;->a:Z

    .line 24
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;->b:Z

    .line 34
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;->a:Z

    .line 35
    iput-boolean p2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;->b:Z

    .line 36
    return-void
.end method


# virtual methods
.method public b()Landroid/support/v4/app/Fragment;
    .locals 2

    .prologue
    .line 60
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 61
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const v1, 0x7f0c009e

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 62
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 50
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BaseFragmentContainer;->onActivityCreated(Landroid/os/Bundle;)V

    .line 51
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->hideActionBarHome()V

    .line 52
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 39
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BaseFragmentContainer;->onAttach(Landroid/app/Activity;)V

    .line 40
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;->d:Landroid/app/Activity;

    .line 41
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 45
    const v0, 0x7f0300d3

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onDestroy()V
    .locals 3

    .prologue
    .line 67
    invoke-super {p0}, Lcom/bestbuy/android/base/BaseFragmentContainer;->onDestroy()V

    .line 68
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;->b:Z

    if-eqz v0, :cond_4

    .line 69
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;->f:Lnb;

    invoke-virtual {v1}, Lnb;->T()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 70
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;->d:Landroid/app/Activity;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->hideActionBarHomeAndSearchBox(Landroid/app/Activity;)V

    .line 71
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    .line 72
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;->f:Lnb;

    invoke-virtual {v1}, Lnb;->C()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 73
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;->f:Lnb;

    invoke-virtual {v1}, Lnb;->D()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Registry"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 74
    const-string v1, "EmptyWeddingRegistryContainer"

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;

    .line 75
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;->b()Landroid/support/v4/app/Fragment;

    move-result-object v1

    .line 76
    instance-of v2, v1, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;

    if-eqz v2, :cond_1

    move-object v0, v1

    .line 77
    check-cast v0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->c()V

    .line 99
    :cond_0
    :goto_0
    return-void

    .line 78
    :cond_1
    instance-of v1, v1, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;

    if-nez v1, :cond_0

    .line 80
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;->c()V

    goto :goto_0

    .line 83
    :cond_2
    const-string v1, "WishListFragmentContainer"

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;

    .line 84
    if-eqz v0, :cond_3

    .line 85
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;->b()Landroid/support/v4/app/Fragment;

    move-result-object v1

    .line 86
    instance-of v1, v1, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;

    if-nez v1, :cond_0

    .line 88
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;->e()Z

    goto :goto_0

    .line 91
    :cond_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->onBackPressed()V

    goto :goto_0

    .line 95
    :cond_4
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;->a:Z

    if-nez v0, :cond_0

    .line 96
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;->f:Lnb;

    invoke-virtual {v1}, Lnb;->T()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 97
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->showActionBarHome()V

    goto :goto_0
.end method

.method public onResume()V
    .locals 0

    .prologue
    .line 56
    invoke-super {p0}, Lcom/bestbuy/android/base/BaseFragmentContainer;->onResume()V

    .line 57
    return-void
.end method
