.class public Lcom/amazon/retailsearch/interaction/SearchUserInteractionListener;
.super Ljava/lang/Object;
.source "SearchUserInteractionListener.java"

# interfaces
.implements Lcom/amazon/retailsearch/interaction/UserInteractionListener;


# instance fields
.field dataSource:Lcom/amazon/retailsearch/interaction/SearchDataSource;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field

.field preferenceManager:Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field

.field private resultItemBuildListeners:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemBuildListener;",
            ">;"
        }
    .end annotation
.end field

.field private resultItemFocusListeners:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemFocusListener;",
            ">;"
        }
    .end annotation
.end field

.field private resultItemSelectionListeners:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemSelectionListener;",
            ">;"
        }
    .end annotation
.end field

.field private retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

.field private searchChangedListener:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/amazon/retailsearch/android/api/display/results/listeners/SearchChangedListener;",
            ">;"
        }
    .end annotation
.end field

.field private searchPageLoadListeners:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/amazon/retailsearch/android/api/display/results/listeners/SearchPageLoadListener;",
            ">;"
        }
    .end annotation
.end field

.field private selectedAsin:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x1

    .line 44
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 35
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0, v1}, Ljava/util/HashSet;-><init>(I)V

    iput-object v0, p0, Lcom/amazon/retailsearch/interaction/SearchUserInteractionListener;->resultItemSelectionListeners:Ljava/util/Set;

    .line 36
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0, v1}, Ljava/util/HashSet;-><init>(I)V

    iput-object v0, p0, Lcom/amazon/retailsearch/interaction/SearchUserInteractionListener;->resultItemBuildListeners:Ljava/util/Set;

    .line 37
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0, v1}, Ljava/util/HashSet;-><init>(I)V

    iput-object v0, p0, Lcom/amazon/retailsearch/interaction/SearchUserInteractionListener;->searchPageLoadListeners:Ljava/util/Set;

    .line 38
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lcom/amazon/retailsearch/interaction/SearchUserInteractionListener;->resultItemFocusListeners:Ljava/util/Set;

    .line 39
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lcom/amazon/retailsearch/interaction/SearchUserInteractionListener;->searchChangedListener:Ljava/util/Set;

    .line 41
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/retailsearch/interaction/SearchUserInteractionListener;->selectedAsin:Ljava/lang/String;

    .line 45
    invoke-static {p0}, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->inject(Ljava/lang/Object;)V

    .line 46
    invoke-static {}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;->getInstance()Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;->getRetailSearchLogger()Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/interaction/SearchUserInteractionListener;->retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    .line 47
    return-void
.end method


# virtual methods
.method public addListener(Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemBuildListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemBuildListener;

    .prologue
    .line 119
    iget-object v0, p0, Lcom/amazon/retailsearch/interaction/SearchUserInteractionListener;->resultItemBuildListeners:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 120
    return-void
.end method

.method public addListener(Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemFocusListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemFocusListener;

    .prologue
    .line 131
    iget-object v0, p0, Lcom/amazon/retailsearch/interaction/SearchUserInteractionListener;->resultItemFocusListeners:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 132
    return-void
.end method

.method public addListener(Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemSelectionListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemSelectionListener;

    .prologue
    .line 113
    iget-object v0, p0, Lcom/amazon/retailsearch/interaction/SearchUserInteractionListener;->resultItemSelectionListeners:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 114
    return-void
.end method

.method public addListener(Lcom/amazon/retailsearch/android/api/display/results/listeners/SearchChangedListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/retailsearch/android/api/display/results/listeners/SearchChangedListener;

    .prologue
    .line 137
    iget-object v0, p0, Lcom/amazon/retailsearch/interaction/SearchUserInteractionListener;->searchChangedListener:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 138
    return-void
.end method

.method public addListener(Lcom/amazon/retailsearch/android/api/display/results/listeners/SearchPageLoadListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/retailsearch/android/api/display/results/listeners/SearchPageLoadListener;

    .prologue
    .line 125
    iget-object v0, p0, Lcom/amazon/retailsearch/interaction/SearchUserInteractionListener;->searchPageLoadListeners:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 126
    return-void
.end method

.method public endPage(Landroid/view/View;)V
    .locals 3
    .param p1, "progressView"    # Landroid/view/View;

    .prologue
    .line 104
    iget-object v2, p0, Lcom/amazon/retailsearch/interaction/SearchUserInteractionListener;->searchPageLoadListeners:Ljava/util/Set;

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/retailsearch/android/api/display/results/listeners/SearchPageLoadListener;

    .line 106
    .local v1, "listener":Lcom/amazon/retailsearch/android/api/display/results/listeners/SearchPageLoadListener;
    invoke-interface {v1, p1}, Lcom/amazon/retailsearch/android/api/display/results/listeners/SearchPageLoadListener;->endPage(Landroid/view/View;)V

    goto :goto_0

    .line 108
    .end local v1    # "listener":Lcom/amazon/retailsearch/android/api/display/results/listeners/SearchPageLoadListener;
    :cond_0
    return-void
.end method

.method public getSelectedAsin()Ljava/lang/String;
    .locals 1

    .prologue
    .line 186
    iget-object v0, p0, Lcom/amazon/retailsearch/interaction/SearchUserInteractionListener;->selectedAsin:Ljava/lang/String;

    return-object v0
.end method

.method public removeAllListeners()V
    .locals 1

    .prologue
    .line 173
    iget-object v0, p0, Lcom/amazon/retailsearch/interaction/SearchUserInteractionListener;->resultItemSelectionListeners:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->clear()V

    .line 174
    iget-object v0, p0, Lcom/amazon/retailsearch/interaction/SearchUserInteractionListener;->resultItemBuildListeners:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->clear()V

    .line 175
    iget-object v0, p0, Lcom/amazon/retailsearch/interaction/SearchUserInteractionListener;->searchPageLoadListeners:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->clear()V

    .line 176
    iget-object v0, p0, Lcom/amazon/retailsearch/interaction/SearchUserInteractionListener;->resultItemFocusListeners:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->clear()V

    .line 177
    iget-object v0, p0, Lcom/amazon/retailsearch/interaction/SearchUserInteractionListener;->searchChangedListener:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->clear()V

    .line 178
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/retailsearch/interaction/SearchUserInteractionListener;->selectedAsin:Ljava/lang/String;

    .line 179
    return-void
.end method

.method public removeListener(Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemBuildListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemBuildListener;

    .prologue
    .line 149
    iget-object v0, p0, Lcom/amazon/retailsearch/interaction/SearchUserInteractionListener;->resultItemSelectionListeners:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 150
    return-void
.end method

.method public removeListener(Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemFocusListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemFocusListener;

    .prologue
    .line 161
    iget-object v0, p0, Lcom/amazon/retailsearch/interaction/SearchUserInteractionListener;->resultItemFocusListeners:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 162
    return-void
.end method

.method public removeListener(Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemSelectionListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemSelectionListener;

    .prologue
    .line 143
    iget-object v0, p0, Lcom/amazon/retailsearch/interaction/SearchUserInteractionListener;->resultItemSelectionListeners:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 144
    return-void
.end method

.method public removeListener(Lcom/amazon/retailsearch/android/api/display/results/listeners/SearchChangedListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/retailsearch/android/api/display/results/listeners/SearchChangedListener;

    .prologue
    .line 167
    iget-object v0, p0, Lcom/amazon/retailsearch/interaction/SearchUserInteractionListener;->searchChangedListener:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 168
    return-void
.end method

.method public removeListener(Lcom/amazon/retailsearch/android/api/display/results/listeners/SearchPageLoadListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/retailsearch/android/api/display/results/listeners/SearchPageLoadListener;

    .prologue
    .line 155
    iget-object v0, p0, Lcom/amazon/retailsearch/interaction/SearchUserInteractionListener;->searchPageLoadListeners:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 156
    return-void
.end method

.method public resultItemBuilt(Landroid/view/ViewGroup;Landroid/widget/ImageView;Ljava/lang/String;)V
    .locals 3
    .param p1, "viewGroup"    # Landroid/view/ViewGroup;
    .param p2, "imageView"    # Landroid/widget/ImageView;
    .param p3, "asin"    # Ljava/lang/String;

    .prologue
    .line 86
    iget-object v2, p0, Lcom/amazon/retailsearch/interaction/SearchUserInteractionListener;->resultItemBuildListeners:Ljava/util/Set;

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemBuildListener;

    .line 88
    .local v1, "listener":Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemBuildListener;
    invoke-interface {v1, p1, p2, p3}, Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemBuildListener;->onResultItemBuilt(Landroid/view/ViewGroup;Landroid/widget/ImageView;Ljava/lang/String;)V

    goto :goto_0

    .line 90
    .end local v1    # "listener":Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemBuildListener;
    :cond_0
    return-void
.end method

.method public resultItemSelected(Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;Lcom/amazon/retailsearch/metrics/DetailPageType;)V
    .locals 6
    .param p1, "resultItem"    # Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;
    .param p2, "type"    # Lcom/amazon/retailsearch/metrics/DetailPageType;

    .prologue
    .line 74
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;->getAsin()Ljava/lang/String;

    move-result-object v4

    :goto_0
    iput-object v4, p0, Lcom/amazon/retailsearch/interaction/SearchUserInteractionListener;->selectedAsin:Ljava/lang/String;

    .line 75
    iget-object v4, p0, Lcom/amazon/retailsearch/interaction/SearchUserInteractionListener;->retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    iget-object v5, p0, Lcom/amazon/retailsearch/interaction/SearchUserInteractionListener;->preferenceManager:Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;

    invoke-virtual {v5}, Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;->getViewType()Lcom/amazon/retailsearch/android/ui/results/ViewType;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/retailsearch/android/ui/results/ViewType;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5, p2}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;->recordDetailPageTransition(Ljava/lang/String;Lcom/amazon/retailsearch/metrics/DetailPageType;)V

    .line 77
    iget-object v4, p0, Lcom/amazon/retailsearch/interaction/SearchUserInteractionListener;->resultItemSelectionListeners:Ljava/util/Set;

    invoke-interface {v4}, Ljava/util/Set;->toArray()[Ljava/lang/Object;

    move-result-object v0

    .local v0, "arr$":[Ljava/lang/Object;
    array-length v2, v0

    .local v2, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_1
    if-ge v1, v2, :cond_1

    aget-object v3, v0, v1

    .line 79
    .local v3, "listener":Ljava/lang/Object;
    check-cast v3, Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemSelectionListener;

    .end local v3    # "listener":Ljava/lang/Object;
    invoke-interface {v3, p1}, Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemSelectionListener;->onResultItemSelected(Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;)V

    .line 77
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 74
    .end local v0    # "arr$":[Ljava/lang/Object;
    .end local v1    # "i$":I
    .end local v2    # "len$":I
    :cond_0
    const/4 v4, 0x0

    goto :goto_0

    .line 81
    .restart local v0    # "arr$":[Ljava/lang/Object;
    .restart local v1    # "i$":I
    .restart local v2    # "len$":I
    :cond_1
    return-void
.end method

.method public retrySearch()V
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/amazon/retailsearch/interaction/SearchUserInteractionListener;->dataSource:Lcom/amazon/retailsearch/interaction/SearchDataSource;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/interaction/SearchDataSource;->getCurrentSearch()Lcom/amazon/retailsearch/data/SearchTask;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/retailsearch/data/SearchTask;->retry()V

    .line 53
    return-void
.end method

.method public search(Ljava/lang/String;)V
    .locals 4
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 58
    iget-object v3, p0, Lcom/amazon/retailsearch/interaction/SearchUserInteractionListener;->dataSource:Lcom/amazon/retailsearch/interaction/SearchDataSource;

    invoke-virtual {v3, p1}, Lcom/amazon/retailsearch/interaction/SearchDataSource;->submitQuery(Ljava/lang/String;)Lcom/amazon/retailsearch/data/SearchTask;

    .line 59
    iget-object v3, p0, Lcom/amazon/retailsearch/interaction/SearchUserInteractionListener;->dataSource:Lcom/amazon/retailsearch/interaction/SearchDataSource;

    invoke-virtual {v3}, Lcom/amazon/retailsearch/interaction/SearchDataSource;->stageLastQuery()V

    .line 60
    invoke-static {p1}, Lcom/amazon/retailsearch/util/UrlUtils;->getKeywords(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 61
    .local v1, "keywords":Ljava/lang/String;
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 69
    :cond_0
    return-void

    .line 65
    :cond_1
    iget-object v3, p0, Lcom/amazon/retailsearch/interaction/SearchUserInteractionListener;->searchChangedListener:Ljava/util/Set;

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/retailsearch/android/api/display/results/listeners/SearchChangedListener;

    .line 67
    .local v2, "listener":Lcom/amazon/retailsearch/android/api/display/results/listeners/SearchChangedListener;
    invoke-interface {v2, v1}, Lcom/amazon/retailsearch/android/api/display/results/listeners/SearchChangedListener;->onKeywordChanged(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public startPage(Landroid/view/View;I)V
    .locals 3
    .param p1, "progressView"    # Landroid/view/View;
    .param p2, "productCount"    # I

    .prologue
    .line 95
    iget-object v2, p0, Lcom/amazon/retailsearch/interaction/SearchUserInteractionListener;->searchPageLoadListeners:Ljava/util/Set;

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/retailsearch/android/api/display/results/listeners/SearchPageLoadListener;

    .line 97
    .local v1, "listener":Lcom/amazon/retailsearch/android/api/display/results/listeners/SearchPageLoadListener;
    invoke-interface {v1, p1, p2}, Lcom/amazon/retailsearch/android/api/display/results/listeners/SearchPageLoadListener;->startPage(Landroid/view/View;I)V

    goto :goto_0

    .line 99
    .end local v1    # "listener":Lcom/amazon/retailsearch/android/api/display/results/listeners/SearchPageLoadListener;
    :cond_0
    return-void
.end method
