.class public Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;
.super Lcom/bestbuy/android/base/BaseFragmentContainer;
.source "SourceFile"


# static fields
.field private static final a:Ljava/lang/String;


# instance fields
.field private b:Ljava/lang/String;

.field private c:Lnb;

.field private g:Lcv;

.field private h:Z

.field private i:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 21
    const-class v0, Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 29
    invoke-direct {p0}, Lcom/bestbuy/android/base/BaseFragmentContainer;-><init>()V

    .line 31
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 38
    invoke-direct {p0}, Lcom/bestbuy/android/base/BaseFragmentContainer;-><init>()V

    .line 39
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;->b:Ljava/lang/String;

    .line 40
    return-void
.end method

.method public constructor <init>(ZLjava/lang/String;)V
    .locals 0

    .prologue
    .line 33
    invoke-direct {p0}, Lcom/bestbuy/android/base/BaseFragmentContainer;-><init>()V

    .line 34
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;->h:Z

    .line 35
    iput-object p2, p0, Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;->i:Ljava/lang/String;

    .line 36
    return-void
.end method

.method private c()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 104
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0, v1}, Lnb;->l(Z)V

    .line 105
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0, v1}, Lnb;->j(Z)V

    .line 106
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0, v1}, Lnb;->k(Z)V

    .line 107
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;->c:Lnb;

    invoke-virtual {v0, v1}, Lnb;->b(Z)V

    .line 108
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;->c:Lnb;

    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    invoke-virtual {v0, v1}, Lnb;->a(Ljava/util/ArrayList;)V

    .line 109
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;->c:Lnb;

    const-string v1, ""

    invoke-virtual {v0, v1}, Lnb;->e(Ljava/lang/String;)V

    .line 110
    return-void
.end method


# virtual methods
.method public b()Landroid/support/v4/app/Fragment;
    .locals 2

    .prologue
    .line 60
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 61
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

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
    .locals 3

    .prologue
    .line 67
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BaseFragmentContainer;->onActivityCreated(Landroid/os/Bundle;)V

    .line 68
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getCurrentActionBarTitle()Ljava/lang/String;

    move-result-object v0

    .line 70
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;->c:Lnb;

    invoke-virtual {v1, v0}, Lnb;->i(Ljava/lang/String;)V

    .line 71
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const-string v1, "My Wish Lists"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 72
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;->d:Landroid/app/Activity;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->hideActionBarHomeAndSearchBox(Landroid/app/Activity;)V

    .line 74
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;->h:Z

    if-eqz v0, :cond_0

    .line 75
    new-instance v0, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;

    iget-boolean v1, p0, Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;->h:Z

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;->i:Ljava/lang/String;

    invoke-direct {v0, v1, v2}, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;-><init>(ZLjava/lang/String;)V

    .line 76
    const/4 v1, 0x0

    const-string v2, "MyWishListsFragment"

    invoke-virtual {p0, v0, v1, v2}, Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;->a(Landroid/support/v4/app/Fragment;ZLjava/lang/String;)V

    .line 81
    :goto_0
    return-void

    .line 78
    :cond_0
    new-instance v0, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;

    invoke-direct {v0}, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;-><init>()V

    .line 79
    const/4 v1, 0x1

    const-string v2, "MyWishListsFragment"

    invoke-virtual {p0, v0, v1, v2}, Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;->a(Landroid/support/v4/app/Fragment;ZLjava/lang/String;)V

    goto :goto_0
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 4

    .prologue
    .line 43
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BaseFragmentContainer;->onAttach(Landroid/app/Activity;)V

    .line 44
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;->d:Landroid/app/Activity;

    .line 45
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;->c:Lnb;

    .line 47
    :try_start_0
    check-cast p1, Lcv;

    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;->g:Lcv;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 51
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;->c:Lnb;

    const-string v1, "WishList"

    invoke-virtual {v0, v1}, Lnb;->f(Ljava/lang/String;)V

    .line 52
    return-void

    .line 48
    :catch_0
    move-exception v0

    .line 49
    sget-object v1, Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;->a:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Calling activity did not implement OnCreateWishListLaunchListener: "

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
    .locals 2

    .prologue
    .line 56
    const v0, 0x7f030118

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onDestroy()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 85
    invoke-super {p0}, Lcom/bestbuy/android/base/BaseFragmentContainer;->onDestroy()V

    .line 86
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;->g:Lcv;

    if-eqz v0, :cond_0

    .line 87
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;->g:Lcv;

    invoke-interface {v0}, Lcv;->onCreateWishListFragmentExit()V

    .line 89
    :cond_0
    invoke-direct {p0}, Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;->c()V

    .line 91
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;->h:Z

    if-eqz v0, :cond_2

    .line 92
    invoke-static {}, Lfr;->d()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_1

    invoke-static {}, Lfr;->d()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1

    .line 93
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;->d:Landroid/app/Activity;

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->changeActionBarAddToVisibility(Landroid/app/Activity;Z)V

    .line 94
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;->d:Landroid/app/Activity;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->hideActionBarHomeAndSearchBox(Landroid/app/Activity;)V

    .line 95
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const-string v1, ""

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 96
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;->d:Landroid/app/Activity;

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->changeActionBarShareVisibility(Landroid/app/Activity;Z)V

    .line 101
    :goto_0
    return-void

    .line 98
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;->c:Lnb;

    invoke-virtual {v1}, Lnb;->T()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 99
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->showActionBarHome()V

    goto :goto_0
.end method
