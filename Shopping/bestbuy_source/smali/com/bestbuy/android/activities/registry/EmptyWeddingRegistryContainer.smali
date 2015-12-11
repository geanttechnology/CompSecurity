.class public Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;
.super Lcom/bestbuy/android/base/BaseFragmentContainer;
.source "SourceFile"


# instance fields
.field private a:Lnb;

.field private b:Lcu;

.field private c:Landroid/view/View;

.field private g:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

.field private h:Landroid/view/View;

.field private i:Z

.field private j:Z


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 38
    invoke-direct {p0}, Lcom/bestbuy/android/base/BaseFragmentContainer;-><init>()V

    .line 35
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;->i:Z

    .line 40
    return-void
.end method

.method public constructor <init>(Z)V
    .locals 1

    .prologue
    .line 42
    invoke-direct {p0}, Lcom/bestbuy/android/base/BaseFragmentContainer;-><init>()V

    .line 35
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;->i:Z

    .line 43
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;->i:Z

    .line 44
    return-void
.end method

.method public constructor <init>(ZZ)V
    .locals 1

    .prologue
    .line 46
    invoke-direct {p0}, Lcom/bestbuy/android/base/BaseFragmentContainer;-><init>()V

    .line 35
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;->i:Z

    .line 47
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;->i:Z

    .line 48
    iput-boolean p2, p0, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;->j:Z

    .line 49
    return-void
.end method

.method private f()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 130
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0, v1}, Lnb;->l(Z)V

    .line 131
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0, v1}, Lnb;->j(Z)V

    .line 132
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0, v1}, Lnb;->k(Z)V

    .line 133
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;->a:Lnb;

    invoke-virtual {v0, v1}, Lnb;->b(Z)V

    .line 134
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;->a:Lnb;

    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    invoke-virtual {v0, v1}, Lnb;->a(Ljava/util/ArrayList;)V

    .line 135
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;->a:Lnb;

    const-string v1, ""

    invoke-virtual {v0, v1}, Lnb;->e(Ljava/lang/String;)V

    .line 136
    return-void
.end method


# virtual methods
.method public a(Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;)V
    .locals 0

    .prologue
    .line 139
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;->g:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    .line 142
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;->c()V

    .line 143
    return-void
.end method

.method public a(Ljava/util/ArrayList;)V
    .locals 3
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
    const/4 v2, 0x1

    .line 146
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 147
    sget-object v0, Llu;->aH:Ljava/lang/String;

    invoke-static {v0}, Llu;->a(Ljava/lang/String;)V

    .line 148
    new-instance v0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;->g:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-direct {v0, p0, v1, p1, v2}, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;-><init>(Lcom/bestbuy/android/base/BBYBaseFragment;Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;Ljava/util/ArrayList;Z)V

    .line 149
    const-string v1, "WishListWithProductsFragment"

    invoke-virtual {p0, v0, v2, v1}, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;->a(Landroid/support/v4/app/Fragment;ZLjava/lang/String;)V

    .line 156
    :goto_0
    return-void

    .line 151
    :cond_0
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;->j:Z

    if-nez v0, :cond_1

    .line 152
    sget-object v0, Llu;->az:Ljava/lang/String;

    invoke-static {v0}, Llu;->a(Ljava/lang/String;)V

    .line 153
    :cond_1
    new-instance v0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;->g:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-direct {v0, v1}, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;-><init>(Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;)V

    .line 154
    const-string v1, "MyEmptyWeddingRegistryList"

    invoke-virtual {p0, v0, v2, v1}, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;->a(Landroid/support/v4/app/Fragment;ZLjava/lang/String;)V

    goto :goto_0
.end method

.method public b()Landroid/support/v4/app/Fragment;
    .locals 2

    .prologue
    .line 86
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 87
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const v1, 0x7f0c009e

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 88
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public c()V
    .locals 8

    .prologue
    const/4 v6, 0x0

    .line 159
    new-instance v0, Ljd;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;->d:Landroid/app/Activity;

    invoke-static {}, Lfr;->d()Ljava/lang/String;

    move-result-object v3

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;->g:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getUuid()Ljava/lang/String;

    move-result-object v4

    const-string v5, "weddingregistrylists"

    iget-object v7, p0, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;->h:Landroid/view/View;

    move-object v2, p0

    invoke-direct/range {v0 .. v7}, Ljd;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLandroid/view/View;)V

    sget-object v1, Lnb;->g:Ljava/util/concurrent/Executor;

    new-array v2, v6, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljd;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 160
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 93
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BaseFragmentContainer;->onActivityCreated(Landroid/os/Bundle;)V

    .line 94
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;->a:Lnb;

    .line 96
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 4

    .prologue
    .line 56
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BaseFragmentContainer;->onAttach(Landroid/app/Activity;)V

    .line 57
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;->d:Landroid/app/Activity;

    .line 58
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;->a:Lnb;

    .line 62
    :try_start_0
    check-cast p1, Lcu;

    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;->b:Lcu;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 68
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;->a:Lnb;

    const-string v1, "Registry"

    invoke-virtual {v0, v1}, Lnb;->f(Ljava/lang/String;)V

    .line 69
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lnb;->l(Z)V

    .line 70
    return-void

    .line 63
    :catch_0
    move-exception v0

    .line 64
    const-string v1, "RegistryFragmentContainer"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Calling activity did not implement OnCreateRegistryLaunchListener: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lkf;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 4

    .prologue
    .line 74
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;->c:Landroid/view/View;

    if-nez v0, :cond_0

    .line 75
    const v0, 0x7f030118

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;->c:Landroid/view/View;

    .line 76
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;->c:Landroid/view/View;

    const v1, 0x7f0c009e

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/FrameLayout;

    .line 77
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;->c:Landroid/view/View;

    const v1, 0x7f0c0064

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;->h:Landroid/view/View;

    .line 78
    new-instance v0, Ljj;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;->d:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;->h:Landroid/view/View;

    invoke-static {}, Lfr;->d()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v0, v1, p0, v2, v3}, Ljj;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljj;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 82
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;->c:Landroid/view/View;

    return-object v0

    .line 80
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;->c:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;->c:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    goto :goto_0
.end method

.method public onDestroy()V
    .locals 2

    .prologue
    .line 110
    invoke-super {p0}, Lcom/bestbuy/android/base/BaseFragmentContainer;->onDestroy()V

    .line 111
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;->i:Z

    if-eqz v0, :cond_2

    .line 112
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;->b:Lcu;

    if-eqz v0, :cond_0

    .line 113
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;->b:Lcu;

    invoke-interface {v0}, Lcu;->onCreateRegistryFragmentExit()V

    .line 115
    :cond_0
    invoke-direct {p0}, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;->f()V

    .line 116
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->showActionBarHome()V

    .line 119
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;->a:Lnb;

    invoke-virtual {v0}, Lnb;->T()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;->a:Lnb;

    invoke-virtual {v0}, Lnb;->T()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1

    .line 120
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;->a:Lnb;

    invoke-virtual {v1}, Lnb;->T()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 125
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->hideLifeEventsTopNavigationButton()V

    .line 126
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;->a:Lnb;

    const-string v1, ""

    invoke-virtual {v0, v1}, Lnb;->f(Ljava/lang/String;)V

    .line 127
    return-void

    .line 122
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;->a:Lnb;

    invoke-virtual {v1}, Lnb;->S()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/home/HomeActivity;->updateActionBarTitle(Ljava/lang/String;)V

    goto :goto_0

    .line 124
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const-string v1, "Registry, Gifts & Lists"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onResume()V
    .locals 2

    .prologue
    .line 100
    invoke-super {p0}, Lcom/bestbuy/android/base/BaseFragmentContainer;->onResume()V

    .line 101
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;->d:Landroid/app/Activity;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->hideActionBarHomeAndSearchBox(Landroid/app/Activity;)V

    .line 106
    return-void
.end method
