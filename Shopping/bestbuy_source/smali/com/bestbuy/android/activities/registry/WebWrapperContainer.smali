.class public Lcom/bestbuy/android/activities/registry/WebWrapperContainer;
.super Lcom/bestbuy/android/base/BaseFragmentContainer;
.source "SourceFile"


# instance fields
.field private a:Lnb;

.field private b:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 27
    invoke-direct {p0}, Lcom/bestbuy/android/base/BaseFragmentContainer;-><init>()V

    .line 25
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WebWrapperContainer;->b:Ljava/lang/String;

    .line 29
    return-void
.end method

.method public constructor <init>(Lcom/bestbuy/android/api/lib/models/offers/Offer;)V
    .locals 1

    .prologue
    .line 31
    invoke-direct {p0}, Lcom/bestbuy/android/base/BaseFragmentContainer;-><init>()V

    .line 25
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WebWrapperContainer;->b:Ljava/lang/String;

    .line 32
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/offers/Offer;->getUrl()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WebWrapperContainer;->b:Ljava/lang/String;

    .line 33
    return-void
.end method


# virtual methods
.method public b()Landroid/support/v4/app/Fragment;
    .locals 2

    .prologue
    .line 63
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WebWrapperContainer;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 64
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WebWrapperContainer;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

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
    .locals 6

    .prologue
    const/4 v2, 0x1

    .line 70
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BaseFragmentContainer;->onActivityCreated(Landroid/os/Bundle;)V

    .line 71
    new-instance v0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    const/4 v1, 0x0

    const v3, 0x7f0800ca

    invoke-virtual {p0, v3}, Lcom/bestbuy/android/activities/registry/WebWrapperContainer;->getString(I)Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lcom/bestbuy/android/activities/registry/WebWrapperContainer;->b:Ljava/lang/String;

    move v3, v2

    invoke-direct/range {v0 .. v5}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;-><init>(ZZZLjava/lang/String;Ljava/lang/String;)V

    .line 72
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 73
    const-string v3, "mDotURL"

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/WebWrapperContainer;->b:Ljava/lang/String;

    invoke-virtual {v1, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 74
    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->setArguments(Landroid/os/Bundle;)V

    .line 75
    invoke-virtual {p0, v0, v2}, Lcom/bestbuy/android/activities/registry/WebWrapperContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 76
    sget-object v0, Llu;->V:Ljava/lang/String;

    invoke-static {v0}, Llu;->a(Ljava/lang/String;)V

    .line 77
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 2

    .prologue
    .line 45
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BaseFragmentContainer;->onAttach(Landroid/app/Activity;)V

    .line 46
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/WebWrapperContainer;->d:Landroid/app/Activity;

    .line 49
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WebWrapperContainer;->a:Lnb;

    .line 50
    check-cast p1, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {p1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getCurrentActionBarTitle()Ljava/lang/String;

    move-result-object v0

    .line 51
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_0

    .line 53
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WebWrapperContainer;->a:Lnb;

    invoke-virtual {v1, v0}, Lnb;->i(Ljava/lang/String;)V

    .line 55
    :cond_0
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 40
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BaseFragmentContainer;->onCreate(Landroid/os/Bundle;)V

    .line 42
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 59
    const v0, 0x7f030118

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onDestroy()V
    .locals 2

    .prologue
    .line 92
    invoke-super {p0}, Lcom/bestbuy/android/base/BaseFragmentContainer;->onDestroy()V

    .line 94
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WebWrapperContainer;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WebWrapperContainer;->a:Lnb;

    invoke-virtual {v1}, Lnb;->T()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 95
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WebWrapperContainer;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/home/HomeActivity;->fragmentHasOptionsMenu(Z)V

    .line 96
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WebWrapperContainer;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/home/HomeActivity;->changeOptionsVisibility(Z)V

    .line 97
    return-void
.end method

.method public onPause()V
    .locals 0

    .prologue
    .line 80
    invoke-super {p0}, Lcom/bestbuy/android/base/BaseFragmentContainer;->onPause()V

    .line 81
    return-void
.end method

.method public onResume()V
    .locals 2

    .prologue
    .line 84
    invoke-super {p0}, Lcom/bestbuy/android/base/BaseFragmentContainer;->onResume()V

    .line 87
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WebWrapperContainer;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const v1, 0x7f0800ca

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/registry/WebWrapperContainer;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 88
    return-void
.end method
