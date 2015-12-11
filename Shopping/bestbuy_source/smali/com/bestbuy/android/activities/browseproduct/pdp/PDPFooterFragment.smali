.class public Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFooterFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 18
    return-void
.end method

.method public constructor <init>(Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;)V
    .locals 0

    .prologue
    .line 20
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 22
    return-void
.end method


# virtual methods
.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 31
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 32
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFooterFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v1, "load"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/home/HomeActivity;->sendRecommendations(Ljava/lang/String;)V

    .line 33
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 26
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 27
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFooterFragment;->d:Landroid/app/Activity;

    .line 28
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 36
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 37
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 41
    const v0, 0x7f03008e

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 42
    return-object v0
.end method
