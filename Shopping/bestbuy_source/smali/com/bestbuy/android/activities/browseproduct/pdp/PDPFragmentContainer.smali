.class public Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;
.super Lcom/bestbuy/android/base/BaseFragmentContainer;
.source "SourceFile"


# instance fields
.field private a:Ljava/lang/String;

.field private b:Lbw;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 23
    invoke-direct {p0}, Lcom/bestbuy/android/base/BaseFragmentContainer;-><init>()V

    .line 25
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 27
    invoke-direct {p0}, Lcom/bestbuy/android/base/BaseFragmentContainer;-><init>()V

    .line 28
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;->a:Ljava/lang/String;

    .line 29
    return-void
.end method


# virtual methods
.method public a(Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 65
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;->b:Lbw;

    if-eqz v0, :cond_0

    .line 66
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;->b:Lbw;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "http://www.bestbuy.com/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lbw;->setShareURL(Ljava/lang/String;)V

    .line 67
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;->b:Lbw;

    invoke-interface {v0}, Lbw;->onPDPFragmentLaunch()V

    .line 69
    :cond_0
    return-void
.end method

.method public b()Landroid/support/v4/app/Fragment;
    .locals 2

    .prologue
    .line 59
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 60
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const v1, 0x7f0c009e

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 61
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 50
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BaseFragmentContainer;->onActivityCreated(Landroid/os/Bundle;)V

    .line 51
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 4

    .prologue
    .line 32
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BaseFragmentContainer;->onAttach(Landroid/app/Activity;)V

    .line 33
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;->d:Landroid/app/Activity;

    move-object v0, p1

    .line 34
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/home/HomeActivity;->fragmentHasOptionsMenu(Z)V

    move-object v0, p1

    .line 35
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/home/HomeActivity;->changeOptionsVisibility(Z)V

    .line 37
    :try_start_0
    check-cast p1, Lbw;

    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;->b:Lbw;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 41
    :goto_0
    return-void

    .line 38
    :catch_0
    move-exception v0

    .line 39
    const-string v1, "PDPFragmentContainer"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Calling activity did not implement OnPDPFragmentLaunchListener: "

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
    .line 45
    const v0, 0x7f0300d3

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onDestroy()V
    .locals 1

    .prologue
    .line 73
    invoke-super {p0}, Lcom/bestbuy/android/base/BaseFragmentContainer;->onDestroy()V

    .line 74
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;->b:Lbw;

    if-eqz v0, :cond_0

    .line 75
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;->b:Lbw;

    invoke-interface {v0}, Lbw;->onPDPFragmentExit()V

    .line 77
    :cond_0
    return-void
.end method

.method public onResume()V
    .locals 0

    .prologue
    .line 55
    invoke-super {p0}, Lcom/bestbuy/android/base/BaseFragmentContainer;->onResume()V

    .line 56
    return-void
.end method
