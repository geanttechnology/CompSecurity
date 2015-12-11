.class public abstract Lcom/amazon/retailsearch/android/ui/search/AbstractResultsDisplay;
.super Ljava/lang/Object;
.source "AbstractResultsDisplay.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/api/display/results/ResultsDisplay;


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
    .line 26
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public addListener(Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemBuildListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemBuildListener;

    .prologue
    .line 42
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/AbstractResultsDisplay;->userInteractionListener:Lcom/amazon/retailsearch/interaction/UserInteractionListener;

    invoke-interface {v0, p1}, Lcom/amazon/retailsearch/interaction/UserInteractionListener;->addListener(Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemBuildListener;)V

    .line 43
    return-void
.end method

.method public addListener(Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemFocusListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemFocusListener;

    .prologue
    .line 54
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/AbstractResultsDisplay;->userInteractionListener:Lcom/amazon/retailsearch/interaction/UserInteractionListener;

    invoke-interface {v0, p1}, Lcom/amazon/retailsearch/interaction/UserInteractionListener;->addListener(Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemFocusListener;)V

    .line 55
    return-void
.end method

.method public addListener(Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemSelectionListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemSelectionListener;

    .prologue
    .line 36
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/AbstractResultsDisplay;->userInteractionListener:Lcom/amazon/retailsearch/interaction/UserInteractionListener;

    invoke-interface {v0, p1}, Lcom/amazon/retailsearch/interaction/UserInteractionListener;->addListener(Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemSelectionListener;)V

    .line 37
    return-void
.end method

.method public addListener(Lcom/amazon/retailsearch/android/api/display/results/listeners/SearchChangedListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/retailsearch/android/api/display/results/listeners/SearchChangedListener;

    .prologue
    .line 60
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/AbstractResultsDisplay;->userInteractionListener:Lcom/amazon/retailsearch/interaction/UserInteractionListener;

    invoke-interface {v0, p1}, Lcom/amazon/retailsearch/interaction/UserInteractionListener;->addListener(Lcom/amazon/retailsearch/android/api/display/results/listeners/SearchChangedListener;)V

    .line 61
    return-void
.end method

.method public addListener(Lcom/amazon/retailsearch/android/api/display/results/listeners/SearchPageLoadListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/retailsearch/android/api/display/results/listeners/SearchPageLoadListener;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/AbstractResultsDisplay;->userInteractionListener:Lcom/amazon/retailsearch/interaction/UserInteractionListener;

    invoke-interface {v0, p1}, Lcom/amazon/retailsearch/interaction/UserInteractionListener;->addListener(Lcom/amazon/retailsearch/android/api/display/results/listeners/SearchPageLoadListener;)V

    .line 49
    return-void
.end method

.method public addListener(Lcom/amazon/retailsearch/metrics/SearchMetricsListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/retailsearch/metrics/SearchMetricsListener;

    .prologue
    .line 66
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/AbstractResultsDisplay;->searchMetricsListenerInvoker:Lcom/amazon/retailsearch/metrics/SearchMetricsListenerInvoker;

    invoke-virtual {v0, p1}, Lcom/amazon/retailsearch/metrics/SearchMetricsListenerInvoker;->addListener(Lcom/amazon/retailsearch/metrics/SearchMetricsListener;)V

    .line 67
    return-void
.end method

.method public removeAllListeners()V
    .locals 1

    .prologue
    .line 108
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/AbstractResultsDisplay;->userInteractionListener:Lcom/amazon/retailsearch/interaction/UserInteractionListener;

    invoke-interface {v0}, Lcom/amazon/retailsearch/interaction/UserInteractionListener;->removeAllListeners()V

    .line 109
    return-void
.end method

.method public removeListener(Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemBuildListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemBuildListener;

    .prologue
    .line 78
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/AbstractResultsDisplay;->userInteractionListener:Lcom/amazon/retailsearch/interaction/UserInteractionListener;

    invoke-interface {v0, p1}, Lcom/amazon/retailsearch/interaction/UserInteractionListener;->removeListener(Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemBuildListener;)V

    .line 79
    return-void
.end method

.method public removeListener(Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemFocusListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemFocusListener;

    .prologue
    .line 90
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/AbstractResultsDisplay;->userInteractionListener:Lcom/amazon/retailsearch/interaction/UserInteractionListener;

    invoke-interface {v0, p1}, Lcom/amazon/retailsearch/interaction/UserInteractionListener;->removeListener(Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemFocusListener;)V

    .line 91
    return-void
.end method

.method public removeListener(Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemSelectionListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemSelectionListener;

    .prologue
    .line 72
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/AbstractResultsDisplay;->userInteractionListener:Lcom/amazon/retailsearch/interaction/UserInteractionListener;

    invoke-interface {v0, p1}, Lcom/amazon/retailsearch/interaction/UserInteractionListener;->removeListener(Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemSelectionListener;)V

    .line 73
    return-void
.end method

.method public removeListener(Lcom/amazon/retailsearch/android/api/display/results/listeners/SearchChangedListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/retailsearch/android/api/display/results/listeners/SearchChangedListener;

    .prologue
    .line 96
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/AbstractResultsDisplay;->userInteractionListener:Lcom/amazon/retailsearch/interaction/UserInteractionListener;

    invoke-interface {v0, p1}, Lcom/amazon/retailsearch/interaction/UserInteractionListener;->removeListener(Lcom/amazon/retailsearch/android/api/display/results/listeners/SearchChangedListener;)V

    .line 97
    return-void
.end method

.method public removeListener(Lcom/amazon/retailsearch/android/api/display/results/listeners/SearchPageLoadListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/retailsearch/android/api/display/results/listeners/SearchPageLoadListener;

    .prologue
    .line 84
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/AbstractResultsDisplay;->userInteractionListener:Lcom/amazon/retailsearch/interaction/UserInteractionListener;

    invoke-interface {v0, p1}, Lcom/amazon/retailsearch/interaction/UserInteractionListener;->removeListener(Lcom/amazon/retailsearch/android/api/display/results/listeners/SearchPageLoadListener;)V

    .line 85
    return-void
.end method

.method public removeListener(Lcom/amazon/retailsearch/metrics/SearchMetricsListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/retailsearch/metrics/SearchMetricsListener;

    .prologue
    .line 102
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/AbstractResultsDisplay;->searchMetricsListenerInvoker:Lcom/amazon/retailsearch/metrics/SearchMetricsListenerInvoker;

    invoke-virtual {v0, p1}, Lcom/amazon/retailsearch/metrics/SearchMetricsListenerInvoker;->removeListener(Lcom/amazon/retailsearch/metrics/SearchMetricsListener;)V

    .line 103
    return-void
.end method
