.class public Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;
.super Lcom/bestbuy/android/base/BaseFragmentContainer;
.source "SourceFile"


# static fields
.field private static final a:Ljava/lang/String;


# instance fields
.field private b:Lnb;

.field private c:Lcu;

.field private g:Landroid/view/View;

.field private h:Z

.field private i:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 19
    const-class v0, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 27
    invoke-direct {p0}, Lcom/bestbuy/android/base/BaseFragmentContainer;-><init>()V

    .line 29
    return-void
.end method

.method public constructor <init>(ZLjava/lang/String;)V
    .locals 0

    .prologue
    .line 31
    invoke-direct {p0}, Lcom/bestbuy/android/base/BaseFragmentContainer;-><init>()V

    .line 32
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;->h:Z

    .line 33
    iput-object p2, p0, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;->i:Ljava/lang/String;

    .line 34
    return-void
.end method


# virtual methods
.method public b()Landroid/support/v4/app/Fragment;
    .locals 2

    .prologue
    .line 63
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 64
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const v1, 0x7f0c009e

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 65
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 3

    .prologue
    .line 70
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BaseFragmentContainer;->onActivityCreated(Landroid/os/Bundle;)V

    .line 72
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;->h:Z

    if-eqz v0, :cond_0

    .line 73
    new-instance v0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;->i:Ljava/lang/String;

    invoke-direct {v0, v1}, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;-><init>(Ljava/lang/String;)V

    .line 74
    const/4 v1, 0x0

    const-string v2, "CreateWeddingRegistry"

    invoke-virtual {p0, v0, v1, v2}, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;->a(Landroid/support/v4/app/Fragment;ZLjava/lang/String;)V

    .line 76
    :cond_0
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 4

    .prologue
    .line 41
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BaseFragmentContainer;->onAttach(Landroid/app/Activity;)V

    .line 42
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;->d:Landroid/app/Activity;

    .line 43
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;->b:Lnb;

    .line 45
    :try_start_0
    check-cast p1, Lcu;

    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;->c:Lcu;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 49
    :goto_0
    return-void

    .line 46
    :catch_0
    move-exception v0

    .line 47
    sget-object v1, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;->a:Ljava/lang/String;

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
    .locals 2

    .prologue
    .line 53
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;->g:Landroid/view/View;

    if-nez v0, :cond_0

    .line 54
    const v0, 0x7f030118

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;->g:Landroid/view/View;

    .line 55
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;->g:Landroid/view/View;

    const v1, 0x7f0c009e

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/FrameLayout;

    .line 59
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;->g:Landroid/view/View;

    return-object v0

    .line 57
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;->g:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;->g:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    goto :goto_0
.end method

.method public onDestroy()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 85
    invoke-super {p0}, Lcom/bestbuy/android/base/BaseFragmentContainer;->onDestroy()V

    .line 86
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;->c:Lcu;

    if-eqz v0, :cond_0

    .line 87
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;->c:Lcu;

    invoke-interface {v0}, Lcu;->onCreateRegistryFragmentExit()V

    .line 94
    :cond_0
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;->h:Z

    if-eqz v0, :cond_1

    .line 96
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;->d:Landroid/app/Activity;

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->changeActionBarAddToVisibility(Landroid/app/Activity;Z)V

    .line 97
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;->d:Landroid/app/Activity;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->hideActionBarHomeAndSearchBox(Landroid/app/Activity;)V

    .line 98
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const-string v1, ""

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 99
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;->d:Landroid/app/Activity;

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->changeActionBarShareVisibility(Landroid/app/Activity;Z)V

    .line 104
    :goto_0
    return-void

    .line 101
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;->b:Lnb;

    invoke-virtual {v1}, Lnb;->T()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 102
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->showActionBarHome()V

    goto :goto_0
.end method

.method public onResume()V
    .locals 0

    .prologue
    .line 80
    invoke-super {p0}, Lcom/bestbuy/android/base/BaseFragmentContainer;->onResume()V

    .line 81
    return-void
.end method
