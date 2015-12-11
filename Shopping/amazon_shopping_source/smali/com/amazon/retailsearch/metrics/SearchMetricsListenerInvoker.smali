.class public Lcom/amazon/retailsearch/metrics/SearchMetricsListenerInvoker;
.super Ljava/lang/Object;
.source "SearchMetricsListenerInvoker.java"


# instance fields
.field private searchMetricsListeners:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/amazon/retailsearch/metrics/SearchMetricsListener;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 19
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lcom/amazon/retailsearch/metrics/SearchMetricsListenerInvoker;->searchMetricsListeners:Ljava/util/Set;

    return-void
.end method


# virtual methods
.method public addListener(Lcom/amazon/retailsearch/metrics/SearchMetricsListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/retailsearch/metrics/SearchMetricsListener;

    .prologue
    .line 27
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/SearchMetricsListenerInvoker;->searchMetricsListeners:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 28
    return-void
.end method

.method public removeListener(Lcom/amazon/retailsearch/metrics/SearchMetricsListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/retailsearch/metrics/SearchMetricsListener;

    .prologue
    .line 36
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/SearchMetricsListenerInvoker;->searchMetricsListeners:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 37
    return-void
.end method

.method public searchATFReached()V
    .locals 3

    .prologue
    .line 55
    iget-object v2, p0, Lcom/amazon/retailsearch/metrics/SearchMetricsListenerInvoker;->searchMetricsListeners:Ljava/util/Set;

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/retailsearch/metrics/SearchMetricsListener;

    .line 57
    .local v1, "listener":Lcom/amazon/retailsearch/metrics/SearchMetricsListener;
    invoke-interface {v1}, Lcom/amazon/retailsearch/metrics/SearchMetricsListener;->onSearchATFReached()V

    goto :goto_0

    .line 59
    .end local v1    # "listener":Lcom/amazon/retailsearch/metrics/SearchMetricsListener;
    :cond_0
    return-void
.end method

.method public searchSRDSCompleted()V
    .locals 3

    .prologue
    .line 77
    iget-object v2, p0, Lcom/amazon/retailsearch/metrics/SearchMetricsListenerInvoker;->searchMetricsListeners:Ljava/util/Set;

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/retailsearch/metrics/SearchMetricsListener;

    .line 79
    .local v1, "listener":Lcom/amazon/retailsearch/metrics/SearchMetricsListener;
    invoke-interface {v1}, Lcom/amazon/retailsearch/metrics/SearchMetricsListener;->onSearchSRDSCompleted()V

    goto :goto_0

    .line 81
    .end local v1    # "listener":Lcom/amazon/retailsearch/metrics/SearchMetricsListener;
    :cond_0
    return-void
.end method

.method public searchSRDSStarted()V
    .locals 3

    .prologue
    .line 66
    iget-object v2, p0, Lcom/amazon/retailsearch/metrics/SearchMetricsListenerInvoker;->searchMetricsListeners:Ljava/util/Set;

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/retailsearch/metrics/SearchMetricsListener;

    .line 68
    .local v1, "listener":Lcom/amazon/retailsearch/metrics/SearchMetricsListener;
    invoke-interface {v1}, Lcom/amazon/retailsearch/metrics/SearchMetricsListener;->onSearchSRDSStarted()V

    goto :goto_0

    .line 70
    .end local v1    # "listener":Lcom/amazon/retailsearch/metrics/SearchMetricsListener;
    :cond_0
    return-void
.end method

.method public searchStarted()V
    .locals 3

    .prologue
    .line 44
    iget-object v2, p0, Lcom/amazon/retailsearch/metrics/SearchMetricsListenerInvoker;->searchMetricsListeners:Ljava/util/Set;

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/retailsearch/metrics/SearchMetricsListener;

    .line 46
    .local v1, "listener":Lcom/amazon/retailsearch/metrics/SearchMetricsListener;
    invoke-interface {v1}, Lcom/amazon/retailsearch/metrics/SearchMetricsListener;->onSearchStarted()V

    goto :goto_0

    .line 48
    .end local v1    # "listener":Lcom/amazon/retailsearch/metrics/SearchMetricsListener;
    :cond_0
    return-void
.end method
