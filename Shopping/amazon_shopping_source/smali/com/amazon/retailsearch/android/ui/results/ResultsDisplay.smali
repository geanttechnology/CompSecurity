.class public abstract Lcom/amazon/retailsearch/android/ui/results/ResultsDisplay;
.super Landroid/support/v4/app/Fragment;
.source "ResultsDisplay.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/api/display/results/ResultsDisplayListeners;


# annotations
.annotation runtime Ljava/lang/Deprecated;
.end annotation


# instance fields
.field searchMetricsListenerInvoker:Lcom/amazon/retailsearch/metrics/SearchMetricsListenerInvoker;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field

.field userInteractionListener:Lcom/amazon/retailsearch/interaction/UserInteractionListener;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 30
    invoke-direct {p0}, Landroid/support/v4/app/Fragment;-><init>()V

    return-void
.end method


# virtual methods
.method public addListener(Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemBuildListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemBuildListener;

    .prologue
    .line 52
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/ResultsDisplay;->userInteractionListener:Lcom/amazon/retailsearch/interaction/UserInteractionListener;

    invoke-interface {v0, p1}, Lcom/amazon/retailsearch/interaction/UserInteractionListener;->addListener(Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemBuildListener;)V

    .line 53
    return-void
.end method

.method public addListener(Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemFocusListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemFocusListener;

    .prologue
    .line 64
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/ResultsDisplay;->userInteractionListener:Lcom/amazon/retailsearch/interaction/UserInteractionListener;

    invoke-interface {v0, p1}, Lcom/amazon/retailsearch/interaction/UserInteractionListener;->addListener(Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemFocusListener;)V

    .line 65
    return-void
.end method

.method public addListener(Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemSelectionListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemSelectionListener;

    .prologue
    .line 46
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/ResultsDisplay;->userInteractionListener:Lcom/amazon/retailsearch/interaction/UserInteractionListener;

    invoke-interface {v0, p1}, Lcom/amazon/retailsearch/interaction/UserInteractionListener;->addListener(Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemSelectionListener;)V

    .line 47
    return-void
.end method

.method public addListener(Lcom/amazon/retailsearch/android/api/display/results/listeners/SearchChangedListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/retailsearch/android/api/display/results/listeners/SearchChangedListener;

    .prologue
    .line 70
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/ResultsDisplay;->userInteractionListener:Lcom/amazon/retailsearch/interaction/UserInteractionListener;

    invoke-interface {v0, p1}, Lcom/amazon/retailsearch/interaction/UserInteractionListener;->addListener(Lcom/amazon/retailsearch/android/api/display/results/listeners/SearchChangedListener;)V

    .line 71
    return-void
.end method

.method public addListener(Lcom/amazon/retailsearch/android/api/display/results/listeners/SearchPageLoadListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/retailsearch/android/api/display/results/listeners/SearchPageLoadListener;

    .prologue
    .line 58
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/ResultsDisplay;->userInteractionListener:Lcom/amazon/retailsearch/interaction/UserInteractionListener;

    invoke-interface {v0, p1}, Lcom/amazon/retailsearch/interaction/UserInteractionListener;->addListener(Lcom/amazon/retailsearch/android/api/display/results/listeners/SearchPageLoadListener;)V

    .line 59
    return-void
.end method

.method public addListener(Lcom/amazon/retailsearch/metrics/SearchMetricsListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/retailsearch/metrics/SearchMetricsListener;

    .prologue
    .line 75
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/ResultsDisplay;->searchMetricsListenerInvoker:Lcom/amazon/retailsearch/metrics/SearchMetricsListenerInvoker;

    invoke-virtual {v0, p1}, Lcom/amazon/retailsearch/metrics/SearchMetricsListenerInvoker;->addListener(Lcom/amazon/retailsearch/metrics/SearchMetricsListener;)V

    .line 76
    return-void
.end method

.method public removeAllListeners()V
    .locals 1

    .prologue
    .line 116
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/ResultsDisplay;->userInteractionListener:Lcom/amazon/retailsearch/interaction/UserInteractionListener;

    invoke-interface {v0}, Lcom/amazon/retailsearch/interaction/UserInteractionListener;->removeAllListeners()V

    .line 117
    return-void
.end method

.method public removeListener(Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemBuildListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemBuildListener;

    .prologue
    .line 87
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/ResultsDisplay;->userInteractionListener:Lcom/amazon/retailsearch/interaction/UserInteractionListener;

    invoke-interface {v0, p1}, Lcom/amazon/retailsearch/interaction/UserInteractionListener;->removeListener(Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemBuildListener;)V

    .line 88
    return-void
.end method

.method public removeListener(Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemFocusListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemFocusListener;

    .prologue
    .line 99
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/ResultsDisplay;->userInteractionListener:Lcom/amazon/retailsearch/interaction/UserInteractionListener;

    invoke-interface {v0, p1}, Lcom/amazon/retailsearch/interaction/UserInteractionListener;->removeListener(Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemFocusListener;)V

    .line 100
    return-void
.end method

.method public removeListener(Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemSelectionListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemSelectionListener;

    .prologue
    .line 81
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/ResultsDisplay;->userInteractionListener:Lcom/amazon/retailsearch/interaction/UserInteractionListener;

    invoke-interface {v0, p1}, Lcom/amazon/retailsearch/interaction/UserInteractionListener;->removeListener(Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemSelectionListener;)V

    .line 82
    return-void
.end method

.method public removeListener(Lcom/amazon/retailsearch/android/api/display/results/listeners/SearchChangedListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/retailsearch/android/api/display/results/listeners/SearchChangedListener;

    .prologue
    .line 105
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/ResultsDisplay;->userInteractionListener:Lcom/amazon/retailsearch/interaction/UserInteractionListener;

    invoke-interface {v0, p1}, Lcom/amazon/retailsearch/interaction/UserInteractionListener;->removeListener(Lcom/amazon/retailsearch/android/api/display/results/listeners/SearchChangedListener;)V

    .line 106
    return-void
.end method

.method public removeListener(Lcom/amazon/retailsearch/android/api/display/results/listeners/SearchPageLoadListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/retailsearch/android/api/display/results/listeners/SearchPageLoadListener;

    .prologue
    .line 93
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/ResultsDisplay;->userInteractionListener:Lcom/amazon/retailsearch/interaction/UserInteractionListener;

    invoke-interface {v0, p1}, Lcom/amazon/retailsearch/interaction/UserInteractionListener;->removeListener(Lcom/amazon/retailsearch/android/api/display/results/listeners/SearchPageLoadListener;)V

    .line 94
    return-void
.end method

.method public removeListener(Lcom/amazon/retailsearch/metrics/SearchMetricsListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/retailsearch/metrics/SearchMetricsListener;

    .prologue
    .line 110
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/ResultsDisplay;->searchMetricsListenerInvoker:Lcom/amazon/retailsearch/metrics/SearchMetricsListenerInvoker;

    invoke-virtual {v0, p1}, Lcom/amazon/retailsearch/metrics/SearchMetricsListenerInvoker;->removeListener(Lcom/amazon/retailsearch/metrics/SearchMetricsListener;)V

    .line 111
    return-void
.end method

.method public abstract search(Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;)V
.end method
