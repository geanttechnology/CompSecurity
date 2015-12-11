.class public Lcom/bestbuy/android/activities/error/ServiceMaintananceErrorFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"


# instance fields
.field private a:Landroid/app/Activity;

.field private b:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 21
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 23
    return-void
.end method


# virtual methods
.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 62
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 63
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 31
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 32
    check-cast p1, Landroid/support/v4/app/FragmentActivity;

    iput-object p1, p0, Lcom/bestbuy/android/activities/error/ServiceMaintananceErrorFragment;->a:Landroid/app/Activity;

    .line 33
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3

    .prologue
    .line 37
    const v0, 0x7f0300ed

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 38
    const v1, 0x7f0c03b0

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    new-instance v2, Lcom/bestbuy/android/activities/error/ServiceMaintananceErrorFragment$1;

    invoke-direct {v2, p0}, Lcom/bestbuy/android/activities/error/ServiceMaintananceErrorFragment$1;-><init>(Lcom/bestbuy/android/activities/error/ServiceMaintananceErrorFragment;)V

    invoke-virtual {v1, v2}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 47
    return-object v0
.end method

.method public onDestroy()V
    .locals 2

    .prologue
    .line 67
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onDestroy()V

    .line 68
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/error/ServiceMaintananceErrorFragment;->b:Z

    if-eqz v0, :cond_0

    .line 69
    iget-object v0, p0, Lcom/bestbuy/android/activities/error/ServiceMaintananceErrorFragment;->a:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->showActionBarHome()V

    .line 71
    iget-object v0, p0, Lcom/bestbuy/android/activities/error/ServiceMaintananceErrorFragment;->a:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/error/ServiceMaintananceErrorFragment;->f:Lnb;

    invoke-virtual {v1}, Lnb;->T()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 73
    :cond_0
    return-void
.end method

.method public onPause()V
    .locals 0

    .prologue
    .line 57
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onPause()V

    .line 58
    return-void
.end method

.method public onResume()V
    .locals 0

    .prologue
    .line 52
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 53
    return-void
.end method
