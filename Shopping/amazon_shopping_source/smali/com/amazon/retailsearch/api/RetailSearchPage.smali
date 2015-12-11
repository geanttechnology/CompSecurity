.class public Lcom/amazon/retailsearch/api/RetailSearchPage;
.super Lcom/amazon/retailsearch/android/ui/results/ResultsDisplay;
.source "RetailSearchPage.java"


# annotations
.annotation runtime Ljava/lang/Deprecated;
.end annotation


# instance fields
.field dataSource:Lcom/amazon/retailsearch/interaction/SearchDataSource;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field

.field private searchResultView:Lcom/amazon/retailsearch/android/ui/search/SearchResultView;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 30
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/results/ResultsDisplay;-><init>()V

    return-void
.end method


# virtual methods
.method public onCreate(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 39
    invoke-super {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/ResultsDisplay;->onCreate(Landroid/os/Bundle;)V

    .line 40
    invoke-static {p0}, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->inject(Ljava/lang/Object;)V

    .line 41
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 46
    sget v1, Lcom/amazon/retailsearch/R$layout;->search_page_root:I

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    .line 47
    .local v0, "view":Landroid/view/View;
    sget v1, Lcom/amazon/retailsearch/R$id;->rs_search_result_view:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;

    iput-object v1, p0, Lcom/amazon/retailsearch/api/RetailSearchPage;->searchResultView:Lcom/amazon/retailsearch/android/ui/search/SearchResultView;

    .line 48
    return-object v0
.end method

.method public onPause()V
    .locals 1

    .prologue
    .line 71
    invoke-super {p0}, Lcom/amazon/retailsearch/android/ui/results/ResultsDisplay;->onPause()V

    .line 72
    iget-object v0, p0, Lcom/amazon/retailsearch/api/RetailSearchPage;->searchResultView:Lcom/amazon/retailsearch/android/ui/search/SearchResultView;

    if-eqz v0, :cond_0

    .line 74
    iget-object v0, p0, Lcom/amazon/retailsearch/api/RetailSearchPage;->searchResultView:Lcom/amazon/retailsearch/android/ui/search/SearchResultView;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->onPause()V

    .line 76
    :cond_0
    return-void
.end method

.method public onResume()V
    .locals 1

    .prologue
    .line 61
    invoke-super {p0}, Lcom/amazon/retailsearch/android/ui/results/ResultsDisplay;->onResume()V

    .line 62
    iget-object v0, p0, Lcom/amazon/retailsearch/api/RetailSearchPage;->searchResultView:Lcom/amazon/retailsearch/android/ui/search/SearchResultView;

    if-eqz v0, :cond_0

    .line 64
    iget-object v0, p0, Lcom/amazon/retailsearch/api/RetailSearchPage;->searchResultView:Lcom/amazon/retailsearch/android/ui/search/SearchResultView;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->onResume()V

    .line 66
    :cond_0
    return-void
.end method

.method public onStart()V
    .locals 1

    .prologue
    .line 81
    invoke-super {p0}, Lcom/amazon/retailsearch/android/ui/results/ResultsDisplay;->onStart()V

    .line 82
    iget-object v0, p0, Lcom/amazon/retailsearch/api/RetailSearchPage;->searchResultView:Lcom/amazon/retailsearch/android/ui/search/SearchResultView;

    if-eqz v0, :cond_0

    .line 84
    iget-object v0, p0, Lcom/amazon/retailsearch/api/RetailSearchPage;->searchResultView:Lcom/amazon/retailsearch/android/ui/search/SearchResultView;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->onStart()V

    .line 86
    :cond_0
    return-void
.end method

.method public onStop()V
    .locals 1

    .prologue
    .line 91
    invoke-super {p0}, Lcom/amazon/retailsearch/android/ui/results/ResultsDisplay;->onStop()V

    .line 92
    iget-object v0, p0, Lcom/amazon/retailsearch/api/RetailSearchPage;->searchResultView:Lcom/amazon/retailsearch/android/ui/search/SearchResultView;

    if-eqz v0, :cond_0

    .line 94
    iget-object v0, p0, Lcom/amazon/retailsearch/api/RetailSearchPage;->searchResultView:Lcom/amazon/retailsearch/android/ui/search/SearchResultView;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->onStop()V

    .line 96
    :cond_0
    return-void
.end method

.method public search(Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;)V
    .locals 1
    .param p1, "query"    # Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;

    .prologue
    .line 54
    iget-object v0, p0, Lcom/amazon/retailsearch/api/RetailSearchPage;->dataSource:Lcom/amazon/retailsearch/interaction/SearchDataSource;

    invoke-virtual {v0, p1}, Lcom/amazon/retailsearch/interaction/SearchDataSource;->submitQuery(Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;)Lcom/amazon/retailsearch/data/SearchTask;

    .line 55
    iget-object v0, p0, Lcom/amazon/retailsearch/api/RetailSearchPage;->dataSource:Lcom/amazon/retailsearch/interaction/SearchDataSource;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/interaction/SearchDataSource;->stageLastQuery()V

    .line 56
    return-void
.end method
