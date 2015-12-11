.class public Lcom/amazon/retailsearch/android/ui/search/CoreResultsFragment;
.super Lcom/amazon/retailsearch/android/fragments/AbstractFragment;
.source "CoreResultsFragment.java"


# instance fields
.field private searchResultView:Lcom/amazon/retailsearch/android/ui/search/SearchResultView;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 23
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/fragments/AbstractFragment;-><init>()V

    return-void
.end method


# virtual methods
.method public onConfigurationChanged(Landroid/content/res/Configuration;)V
    .locals 1
    .param p1, "newConfig"    # Landroid/content/res/Configuration;

    .prologue
    .line 76
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/CoreResultsFragment;->searchResultView:Lcom/amazon/retailsearch/android/ui/search/SearchResultView;

    if-eqz v0, :cond_0

    .line 78
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/CoreResultsFragment;->searchResultView:Lcom/amazon/retailsearch/android/ui/search/SearchResultView;

    invoke-virtual {v0, p1}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->onConfigurationChanged(Landroid/content/res/Configuration;)V

    .line 80
    :cond_0
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 31
    sget v1, Lcom/amazon/retailsearch/R$layout;->search_page_root:I

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    .line 33
    .local v0, "view":Landroid/view/View;
    sget v1, Lcom/amazon/retailsearch/R$id;->rs_search_result_view:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;

    iput-object v1, p0, Lcom/amazon/retailsearch/android/ui/search/CoreResultsFragment;->searchResultView:Lcom/amazon/retailsearch/android/ui/search/SearchResultView;

    .line 35
    return-object v0
.end method

.method public onPause()V
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/CoreResultsFragment;->searchResultView:Lcom/amazon/retailsearch/android/ui/search/SearchResultView;

    if-eqz v0, :cond_0

    .line 52
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/CoreResultsFragment;->searchResultView:Lcom/amazon/retailsearch/android/ui/search/SearchResultView;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->onPause()V

    .line 54
    :cond_0
    return-void
.end method

.method public onResume()V
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/CoreResultsFragment;->searchResultView:Lcom/amazon/retailsearch/android/ui/search/SearchResultView;

    if-eqz v0, :cond_0

    .line 43
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/CoreResultsFragment;->searchResultView:Lcom/amazon/retailsearch/android/ui/search/SearchResultView;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->onResume()V

    .line 45
    :cond_0
    return-void
.end method

.method public onStart()V
    .locals 1

    .prologue
    .line 59
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/CoreResultsFragment;->searchResultView:Lcom/amazon/retailsearch/android/ui/search/SearchResultView;

    if-eqz v0, :cond_0

    .line 61
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/CoreResultsFragment;->searchResultView:Lcom/amazon/retailsearch/android/ui/search/SearchResultView;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->onStart()V

    .line 63
    :cond_0
    return-void
.end method

.method public onStop()V
    .locals 1

    .prologue
    .line 68
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/CoreResultsFragment;->searchResultView:Lcom/amazon/retailsearch/android/ui/search/SearchResultView;

    if-eqz v0, :cond_0

    .line 70
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/CoreResultsFragment;->searchResultView:Lcom/amazon/retailsearch/android/ui/search/SearchResultView;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->onStop()V

    .line 72
    :cond_0
    return-void
.end method
