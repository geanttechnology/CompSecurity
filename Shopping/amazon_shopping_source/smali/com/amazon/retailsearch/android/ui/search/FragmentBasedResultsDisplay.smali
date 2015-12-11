.class public Lcom/amazon/retailsearch/android/ui/search/FragmentBasedResultsDisplay;
.super Lcom/amazon/retailsearch/android/ui/search/AbstractResultsDisplay;
.source "FragmentBasedResultsDisplay.java"


# instance fields
.field dataSource:Lcom/amazon/retailsearch/interaction/SearchDataSource;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 35
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/search/AbstractResultsDisplay;-><init>()V

    .line 36
    invoke-static {p0}, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->inject(Ljava/lang/Object;)V

    .line 37
    return-void
.end method


# virtual methods
.method public createDisplay(Landroid/content/Context;Landroid/view/ViewStub;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "stub"    # Landroid/view/ViewStub;

    .prologue
    .line 48
    invoke-static {p1}, Lcom/amazon/retailsearch/android/util/FeatureCompatibilityChecker;->useCompatFragment(Landroid/content/Context;)Ljava/lang/Boolean;

    move-result-object v0

    .line 50
    .local v0, "useCompat":Ljava/lang/Boolean;
    if-nez v0, :cond_0

    .line 52
    new-instance v1, Ljava/lang/RuntimeException;

    const-string/jumbo v2, "Cannot use a Fragment in this context. This device runs on an Android version that is older than Honeycomb but the FragmentActivity is not being used."

    invoke-direct {v1, v2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 56
    :cond_0
    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 58
    sget v1, Lcom/amazon/retailsearch/R$layout;->rs_results_display_fragment_compat:I

    invoke-virtual {p2, v1}, Landroid/view/ViewStub;->setLayoutResource(I)V

    .line 65
    :goto_0
    invoke-virtual {p2}, Landroid/view/ViewStub;->inflate()Landroid/view/View;

    .line 66
    return-void

    .line 62
    :cond_1
    sget v1, Lcom/amazon/retailsearch/R$layout;->rs_results_display_fragment:I

    invoke-virtual {p2, v1}, Landroid/view/ViewStub;->setLayoutResource(I)V

    goto :goto_0
.end method

.method public hide()V
    .locals 0

    .prologue
    .line 122
    return-void
.end method

.method public onBackPressed()V
    .locals 0

    .prologue
    .line 115
    return-void
.end method

.method public onDestroy()V
    .locals 0

    .prologue
    .line 108
    return-void
.end method

.method public onPause()V
    .locals 0

    .prologue
    .line 87
    return-void
.end method

.method public onResume()V
    .locals 0

    .prologue
    .line 80
    return-void
.end method

.method public onStart()V
    .locals 0

    .prologue
    .line 94
    return-void
.end method

.method public onStop()V
    .locals 0

    .prologue
    .line 101
    return-void
.end method

.method public search(Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;)V
    .locals 1
    .param p1, "query"    # Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;

    .prologue
    .line 71
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/FragmentBasedResultsDisplay;->dataSource:Lcom/amazon/retailsearch/interaction/SearchDataSource;

    invoke-virtual {v0, p1}, Lcom/amazon/retailsearch/interaction/SearchDataSource;->submitQuery(Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;)Lcom/amazon/retailsearch/data/SearchTask;

    .line 72
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/FragmentBasedResultsDisplay;->dataSource:Lcom/amazon/retailsearch/interaction/SearchDataSource;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/interaction/SearchDataSource;->stageLastQuery()V

    .line 73
    return-void
.end method

.method public show()V
    .locals 0

    .prologue
    .line 129
    return-void
.end method
