.class public Lcom/bestbuy/android/activities/browseproduct/ProductTabContainer;
.super Lcom/bestbuy/android/activities/BaseTabContainer;
.source "SourceFile"


# instance fields
.field private a:Z

.field private b:Lnb;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 22
    invoke-direct {p0}, Lcom/bestbuy/android/activities/BaseTabContainer;-><init>()V

    .line 24
    return-void
.end method

.method private d()V
    .locals 2

    .prologue
    .line 47
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;

    invoke-direct {v0}, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;-><init>()V

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Lcom/bestbuy/android/activities/browseproduct/ProductTabContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 48
    return-void
.end method


# virtual methods
.method public b()Landroid/support/v4/app/Fragment;
    .locals 2

    .prologue
    .line 51
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/ProductTabContainer;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 52
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/ProductTabContainer;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const v1, 0x7f0c009e

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 53
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    const/4 v1, 0x1

    .line 33
    invoke-super {p0, p1}, Lcom/bestbuy/android/activities/BaseTabContainer;->onActivityCreated(Landroid/os/Bundle;)V

    .line 34
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductTabContainer;->b:Lnb;

    .line 35
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductTabContainer;->a:Z

    if-nez v0, :cond_0

    .line 36
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/browseproduct/ProductTabContainer;->a:Z

    .line 37
    invoke-direct {p0}, Lcom/bestbuy/android/activities/browseproduct/ProductTabContainer;->d()V

    .line 39
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductTabContainer;->b:Lnb;

    invoke-virtual {v0}, Lnb;->H()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 40
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductTabContainer;->b:Lnb;

    invoke-virtual {v0}, Lnb;->I()Landroid/support/v4/app/Fragment;

    move-result-object v0

    invoke-virtual {p0, v0, v1}, Lcom/bestbuy/android/activities/browseproduct/ProductTabContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 41
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductTabContainer;->b:Lnb;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lnb;->g(Z)V

    .line 42
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductTabContainer;->b:Lnb;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lnb;->a(Landroid/support/v4/app/Fragment;)V

    .line 44
    :cond_1
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 28
    const v0, 0x7f0300d3

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method
