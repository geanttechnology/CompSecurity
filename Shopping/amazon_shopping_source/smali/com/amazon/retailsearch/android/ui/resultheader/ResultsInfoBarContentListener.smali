.class public Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBarContentListener;
.super Ljava/lang/Object;
.source "ResultsInfoBarContentListener.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/ui/resultheader/IHeaderContentListener;


# instance fields
.field private retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

.field searchDataSource:Lcom/amazon/retailsearch/interaction/SearchDataSource;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    invoke-static {}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;->getInstance()Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;->getRetailSearchLogger()Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBarContentListener;->retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    .line 20
    invoke-static {p0}, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->inject(Ljava/lang/Object;)V

    .line 21
    return-void
.end method


# virtual methods
.method public OnClearAllClick()V
    .locals 1

    .prologue
    .line 49
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBarContentListener;->searchDataSource:Lcom/amazon/retailsearch/interaction/SearchDataSource;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/interaction/SearchDataSource;->submitStagedQuery()Lcom/amazon/retailsearch/data/SearchTask;

    .line 50
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBarContentListener;->retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    invoke-interface {v0}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;->filterMenuSearch()V

    .line 51
    return-void
.end method

.method public onDepartmentLabelUpdated()V
    .locals 0

    .prologue
    .line 61
    return-void
.end method

.method public onFilterCountUpdated()V
    .locals 0

    .prologue
    .line 71
    return-void
.end method

.method public onHide()V
    .locals 0

    .prologue
    .line 44
    return-void
.end method

.method public onRefinementClick(Ljava/lang/String;)V
    .locals 1
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 32
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBarContentListener;->searchDataSource:Lcom/amazon/retailsearch/interaction/SearchDataSource;

    invoke-virtual {v0, p1}, Lcom/amazon/retailsearch/interaction/SearchDataSource;->submitQuery(Ljava/lang/String;)Lcom/amazon/retailsearch/data/SearchTask;

    .line 33
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBarContentListener;->retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    invoke-interface {v0}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;->filterMenuSearch()V

    .line 34
    return-void
.end method

.method public onResultCountUpdated()V
    .locals 0

    .prologue
    .line 66
    return-void
.end method

.method public onUpdate(Lcom/amazon/searchapp/retailsearch/model/Refinements;)V
    .locals 0
    .param p1, "refinements"    # Lcom/amazon/searchapp/retailsearch/model/Refinements;

    .prologue
    .line 27
    return-void
.end method

.method public onViewSizeChanged()V
    .locals 0

    .prologue
    .line 39
    return-void
.end method

.method public onViewTypeUpdated(Lcom/amazon/retailsearch/android/ui/results/ViewType;)V
    .locals 0
    .param p1, "viewType"    # Lcom/amazon/retailsearch/android/ui/results/ViewType;

    .prologue
    .line 56
    return-void
.end method
