.class public Lcom/bestbuy/android/activities/registry/MyWeddingRegistryFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"


# instance fields
.field private a:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

.field private b:Landroid/view/View;

.field private c:Landroid/view/View;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 32
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 33
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
            "Lcom/bestbuy/android/api/lib/models/registry/Entities;",
            ">;)V"
        }
    .end annotation

    .prologue
    const/4 v3, 0x1

    .line 67
    if-eqz p1, :cond_1

    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lez v0, :cond_1

    .line 68
    new-instance v1, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyWeddingRegistryFragment;->a:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-direct {v1, p0, v0, p1, v3}, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;-><init>(Lcom/bestbuy/android/base/BBYBaseFragment;Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;Ljava/util/ArrayList;Z)V

    .line 70
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/MyWeddingRegistryFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 71
    instance-of v2, v0, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;

    if-eqz v2, :cond_0

    .line 72
    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    invoke-virtual {v0, v1, v3}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 80
    :cond_0
    :goto_0
    return-void

    .line 75
    :cond_1
    new-instance v1, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;

    invoke-direct {v1}, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;-><init>()V

    .line 76
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/MyWeddingRegistryFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 77
    instance-of v2, v0, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;

    if-eqz v2, :cond_0

    .line 78
    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    invoke-virtual {v0, v1, v3}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    goto :goto_0
.end method

.method public b()Z
    .locals 1

    .prologue
    .line 89
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyWeddingRegistryFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    .line 90
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->popBackStack()V

    .line 91
    const/4 v0, 0x1

    return v0
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 43
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 44
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 37
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 38
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/MyWeddingRegistryFragment;->d:Landroid/app/Activity;

    .line 39
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 48
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyWeddingRegistryFragment;->b:Landroid/view/View;

    if-nez v0, :cond_0

    .line 49
    const v0, 0x7f03007f

    invoke-virtual {p1, v0, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/MyWeddingRegistryFragment;->b:Landroid/view/View;

    .line 50
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyWeddingRegistryFragment;->b:Landroid/view/View;

    const v1, 0x7f0c0182

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/FrameLayout;

    .line 51
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyWeddingRegistryFragment;->b:Landroid/view/View;

    const v1, 0x7f0c0064

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/MyWeddingRegistryFragment;->c:Landroid/view/View;

    .line 52
    new-instance v0, Ljj;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/MyWeddingRegistryFragment;->d:Landroid/app/Activity;

    invoke-static {}, Lfr;->d()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, p0, v3, v2}, Ljj;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;)V

    sget-object v1, Lnb;->g:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljj;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 57
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyWeddingRegistryFragment;->b:Landroid/view/View;

    return-object v0

    .line 54
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyWeddingRegistryFragment;->b:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/MyWeddingRegistryFragment;->b:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    goto :goto_0
.end method

.method public onDestroy()V
    .locals 1

    .prologue
    .line 84
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onDestroy()V

    .line 85
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyWeddingRegistryFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->showActionBarHome()V

    .line 86
    return-void
.end method
