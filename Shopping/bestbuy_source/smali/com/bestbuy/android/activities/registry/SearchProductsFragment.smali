.class public Lcom/bestbuy/android/activities/registry/SearchProductsFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"


# instance fields
.field private a:Landroid/view/View;

.field private b:Landroid/app/Activity;

.field private c:Landroid/widget/ListView;

.field private g:Landroid/widget/LinearLayout;


# virtual methods
.method public onAttach(Landroid/app/Activity;)V
    .locals 1

    .prologue
    .line 30
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    move-object v0, p1

    .line 31
    check-cast v0, Landroid/support/v4/app/FragmentActivity;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/SearchProductsFragment;->b:Landroid/app/Activity;

    .line 32
    check-cast p1, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {p1}, Lcom/bestbuy/android/activities/home/HomeActivity;->instantiateSearch()V

    .line 33
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 38
    const v0, 0x7f0300eb

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/SearchProductsFragment;->a:Landroid/view/View;

    .line 39
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/SearchProductsFragment;->a:Landroid/view/View;

    const v1, 0x7f0c03ae

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/SearchProductsFragment;->c:Landroid/widget/ListView;

    .line 40
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/SearchProductsFragment;->a:Landroid/view/View;

    const v1, 0x7f0c02af

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/SearchProductsFragment;->g:Landroid/widget/LinearLayout;

    .line 41
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/SearchProductsFragment;->a:Landroid/view/View;

    return-object v0
.end method
