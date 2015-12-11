.class public Lcom/bestbuy/android/activities/registry/MyRegistryDetailsFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"


# instance fields
.field private a:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

.field private b:Landroid/view/View;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 24
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 26
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

    .line 57
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/MyRegistryDetailsFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    .line 59
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-lez v1, :cond_0

    .line 60
    new-instance v1, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/MyRegistryDetailsFragment;->a:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-direct {v1, p0, v2, p1, v3}, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;-><init>(Lcom/bestbuy/android/base/BBYBaseFragment;Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;Ljava/util/ArrayList;Z)V

    .line 61
    const-string v2, "WishListWithProductsFragment"

    invoke-virtual {v0, v1, v3, v2}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;ZLjava/lang/String;)V

    .line 66
    :goto_0
    return-void

    .line 63
    :cond_0
    new-instance v1, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/MyRegistryDetailsFragment;->a:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-direct {v1, v2}, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;-><init>(Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;)V

    .line 64
    const-string v2, "MyEmptyWeddingRegistryList"

    invoke-virtual {v0, v1, v3, v2}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;ZLjava/lang/String;)V

    goto :goto_0
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 8

    .prologue
    const/4 v6, 0x0

    .line 34
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 35
    new-instance v0, Ljd;

    invoke-static {}, Lfr;->d()Ljava/lang/String;

    move-result-object v3

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/MyRegistryDetailsFragment;->a:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getUuid()Ljava/lang/String;

    move-result-object v4

    const-string v5, "weddingregistrylists"

    iget-object v7, p0, Lcom/bestbuy/android/activities/registry/MyRegistryDetailsFragment;->b:Landroid/view/View;

    move-object v1, p1

    move-object v2, p0

    invoke-direct/range {v0 .. v7}, Ljd;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLandroid/view/View;)V

    sget-object v1, Lnb;->g:Ljava/util/concurrent/Executor;

    new-array v2, v6, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljd;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 36
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 41
    const v0, 0x7f030119

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 42
    const v1, 0x7f0c0064

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    iput-object v1, p0, Lcom/bestbuy/android/activities/registry/MyRegistryDetailsFragment;->b:Landroid/view/View;

    .line 43
    return-object v0
.end method

.method public onResume()V
    .locals 8

    .prologue
    const/4 v6, 0x0

    .line 48
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 49
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0}, Lnb;->X()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 50
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0, v6}, Lnb;->l(Z)V

    .line 51
    new-instance v0, Ljd;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/MyRegistryDetailsFragment;->d:Landroid/app/Activity;

    invoke-static {}, Lfr;->d()Ljava/lang/String;

    move-result-object v3

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/MyRegistryDetailsFragment;->a:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getUuid()Ljava/lang/String;

    move-result-object v4

    const-string v5, "weddingregistrylists"

    iget-object v7, p0, Lcom/bestbuy/android/activities/registry/MyRegistryDetailsFragment;->b:Landroid/view/View;

    move-object v2, p0

    invoke-direct/range {v0 .. v7}, Ljd;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLandroid/view/View;)V

    sget-object v1, Lnb;->g:Ljava/util/concurrent/Executor;

    new-array v2, v6, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljd;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 53
    :cond_0
    return-void
.end method
