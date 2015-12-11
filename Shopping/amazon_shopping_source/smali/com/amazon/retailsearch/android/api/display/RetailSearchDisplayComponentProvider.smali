.class public Lcom/amazon/retailsearch/android/api/display/RetailSearchDisplayComponentProvider;
.super Ljava/lang/Object;
.source "RetailSearchDisplayComponentProvider.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static inflateResultsDisplay(Landroid/view/ViewStub;)Lcom/amazon/retailsearch/android/api/display/results/ResultsDisplay;
    .locals 2
    .param p0, "stub"    # Landroid/view/ViewStub;

    .prologue
    .line 37
    new-instance v0, Lcom/amazon/retailsearch/android/ui/search/FragmentBasedResultsDisplay;

    invoke-direct {v0}, Lcom/amazon/retailsearch/android/ui/search/FragmentBasedResultsDisplay;-><init>()V

    .line 38
    .local v0, "resultsDisplay":Lcom/amazon/retailsearch/android/ui/search/FragmentBasedResultsDisplay;
    invoke-virtual {p0}, Landroid/view/ViewStub;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v0, v1, p0}, Lcom/amazon/retailsearch/android/ui/search/FragmentBasedResultsDisplay;->createDisplay(Landroid/content/Context;Landroid/view/ViewStub;)V

    .line 39
    return-object v0
.end method

.method public static inflateSearchEntry(Landroid/view/ViewStub;)Lcom/amazon/retailsearch/android/api/display/input/SearchEntry;
    .locals 2
    .param p0, "stub"    # Landroid/view/ViewStub;

    .prologue
    .line 52
    sget v1, Lcom/amazon/retailsearch/R$layout;->rs_action_bar_search_entry:I

    invoke-virtual {p0, v1}, Landroid/view/ViewStub;->setLayoutResource(I)V

    .line 53
    invoke-virtual {p0}, Landroid/view/ViewStub;->inflate()Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;

    .line 54
    .local v0, "rsqe":Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;
    return-object v0
.end method
