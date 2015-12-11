.class public Lcom/amazon/retailsearch/interaction/SearchDataSource;
.super Ljava/lang/Object;
.source "SearchDataSource.java"


# static fields
.field private static final EMPTY_SEARCH_TASK:Lcom/amazon/retailsearch/data/EmptySearchTask;


# instance fields
.field private currentSearchLoader:Lcom/amazon/retailsearch/data/search/SearchLoader;

.field private lastQuery:Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;

.field private lastStagedQuery:Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;

.field private retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

.field private searchChangeListeners:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/amazon/retailsearch/interaction/SearchChangeListener;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 29
    new-instance v0, Lcom/amazon/retailsearch/data/EmptySearchTask;

    invoke-direct {v0}, Lcom/amazon/retailsearch/data/EmptySearchTask;-><init>()V

    sput-object v0, Lcom/amazon/retailsearch/interaction/SearchDataSource;->EMPTY_SEARCH_TASK:Lcom/amazon/retailsearch/data/EmptySearchTask;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 34
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 26
    invoke-static {}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;->getInstance()Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;->getRetailSearchLogger()Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/interaction/SearchDataSource;->retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    .line 28
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lcom/amazon/retailsearch/interaction/SearchDataSource;->searchChangeListeners:Ljava/util/Set;

    .line 35
    invoke-static {p0}, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->inject(Ljava/lang/Object;)V

    .line 36
    return-void
.end method


# virtual methods
.method public addSearchChangeListener(Lcom/amazon/retailsearch/interaction/SearchChangeListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/retailsearch/interaction/SearchChangeListener;

    .prologue
    .line 107
    iget-object v0, p0, Lcom/amazon/retailsearch/interaction/SearchDataSource;->searchChangeListeners:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 108
    return-void
.end method

.method public clear()V
    .locals 1

    .prologue
    .line 154
    iget-object v0, p0, Lcom/amazon/retailsearch/interaction/SearchDataSource;->currentSearchLoader:Lcom/amazon/retailsearch/data/search/SearchLoader;

    if-eqz v0, :cond_0

    .line 156
    iget-object v0, p0, Lcom/amazon/retailsearch/interaction/SearchDataSource;->currentSearchLoader:Lcom/amazon/retailsearch/data/search/SearchLoader;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/data/search/SearchLoader;->close()V

    .line 157
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/retailsearch/interaction/SearchDataSource;->currentSearchLoader:Lcom/amazon/retailsearch/data/search/SearchLoader;

    .line 160
    :cond_0
    iget-object v0, p0, Lcom/amazon/retailsearch/interaction/SearchDataSource;->searchChangeListeners:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->clear()V

    .line 161
    return-void
.end method

.method public getCurrentSearch()Lcom/amazon/retailsearch/data/SearchTask;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/amazon/retailsearch/interaction/SearchDataSource;->currentSearchLoader:Lcom/amazon/retailsearch/data/search/SearchLoader;

    if-nez v0, :cond_0

    .line 47
    sget-object v0, Lcom/amazon/retailsearch/interaction/SearchDataSource;->EMPTY_SEARCH_TASK:Lcom/amazon/retailsearch/data/EmptySearchTask;

    .line 49
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/retailsearch/interaction/SearchDataSource;->currentSearchLoader:Lcom/amazon/retailsearch/data/search/SearchLoader;

    goto :goto_0
.end method

.method public isQueryChangedAfterStaged()Z
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 145
    iget-object v1, p0, Lcom/amazon/retailsearch/interaction/SearchDataSource;->lastStagedQuery:Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;

    if-nez v1, :cond_1

    :cond_0
    :goto_0
    return v0

    :cond_1
    iget-object v1, p0, Lcom/amazon/retailsearch/interaction/SearchDataSource;->lastStagedQuery:Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;

    iget-object v2, p0, Lcom/amazon/retailsearch/interaction/SearchDataSource;->lastQuery:Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;

    invoke-virtual {v1, v2}, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    const/4 v0, 0x1

    goto :goto_0
.end method

.method public removeSearchChangeListener(Lcom/amazon/retailsearch/interaction/SearchChangeListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/retailsearch/interaction/SearchChangeListener;

    .prologue
    .line 112
    iget-object v0, p0, Lcom/amazon/retailsearch/interaction/SearchDataSource;->searchChangeListeners:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 113
    return-void
.end method

.method public stageLastQuery()V
    .locals 1

    .prologue
    .line 120
    iget-object v0, p0, Lcom/amazon/retailsearch/interaction/SearchDataSource;->lastQuery:Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;

    iput-object v0, p0, Lcom/amazon/retailsearch/interaction/SearchDataSource;->lastStagedQuery:Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;

    .line 121
    return-void
.end method

.method public submitQuery(Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;)Lcom/amazon/retailsearch/data/SearchTask;
    .locals 7
    .param p1, "query"    # Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;

    .prologue
    .line 57
    iput-object p1, p0, Lcom/amazon/retailsearch/interaction/SearchDataSource;->lastQuery:Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;

    .line 58
    iget-object v3, p0, Lcom/amazon/retailsearch/interaction/SearchDataSource;->retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    invoke-interface {v3}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;->searchStarted()V

    .line 60
    iget-object v3, p0, Lcom/amazon/retailsearch/interaction/SearchDataSource;->currentSearchLoader:Lcom/amazon/retailsearch/data/search/SearchLoader;

    if-eqz v3, :cond_0

    .line 61
    iget-object v3, p0, Lcom/amazon/retailsearch/interaction/SearchDataSource;->currentSearchLoader:Lcom/amazon/retailsearch/data/search/SearchLoader;

    invoke-virtual {v3}, Lcom/amazon/retailsearch/data/search/SearchLoader;->close()V

    .line 64
    :cond_0
    new-instance v3, Lcom/amazon/retailsearch/data/search/SearchLoader;

    invoke-static {}, Lcom/amazon/retailsearch/client/AndroidRetailSearchClient;->getClient()Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;

    move-result-object v4

    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->toSearchRequest()Lcom/amazon/searchapp/retailsearch/client/SearchRequest;

    move-result-object v5

    const/4 v6, 0x0

    invoke-direct {v3, v4, v5, v6}, Lcom/amazon/retailsearch/data/search/SearchLoader;-><init>(Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;Lcom/amazon/searchapp/retailsearch/client/SearchRequest;Ljava/util/concurrent/ExecutorService;)V

    iput-object v3, p0, Lcom/amazon/retailsearch/interaction/SearchDataSource;->currentSearchLoader:Lcom/amazon/retailsearch/data/search/SearchLoader;

    .line 71
    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->getIssEngagementData()Ljava/util/Map;

    move-result-object v1

    .line 72
    .local v1, "issEngagementData":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    if-eqz v1, :cond_1

    .line 74
    iget-object v3, p0, Lcom/amazon/retailsearch/interaction/SearchDataSource;->currentSearchLoader:Lcom/amazon/retailsearch/data/search/SearchLoader;

    new-instance v4, Lcom/amazon/retailsearch/interaction/SearchDataSource$1;

    invoke-direct {v4, p0, v1}, Lcom/amazon/retailsearch/interaction/SearchDataSource$1;-><init>(Lcom/amazon/retailsearch/interaction/SearchDataSource;Ljava/util/Map;)V

    invoke-virtual {v3, v4}, Lcom/amazon/retailsearch/data/search/SearchLoader;->addListener(Lcom/amazon/retailsearch/data/SearchTask$SearchTaskListener;)V

    .line 89
    :cond_1
    iget-object v3, p0, Lcom/amazon/retailsearch/interaction/SearchDataSource;->currentSearchLoader:Lcom/amazon/retailsearch/data/search/SearchLoader;

    invoke-virtual {v3}, Lcom/amazon/retailsearch/data/search/SearchLoader;->load()V

    .line 91
    iget-object v3, p0, Lcom/amazon/retailsearch/interaction/SearchDataSource;->searchChangeListeners:Ljava/util/Set;

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_2

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/retailsearch/interaction/SearchChangeListener;

    .line 93
    .local v2, "listener":Lcom/amazon/retailsearch/interaction/SearchChangeListener;
    iget-object v3, p0, Lcom/amazon/retailsearch/interaction/SearchDataSource;->currentSearchLoader:Lcom/amazon/retailsearch/data/search/SearchLoader;

    invoke-interface {v2, v3}, Lcom/amazon/retailsearch/interaction/SearchChangeListener;->onNewSearch(Lcom/amazon/retailsearch/data/SearchTask;)V

    goto :goto_0

    .line 96
    .end local v2    # "listener":Lcom/amazon/retailsearch/interaction/SearchChangeListener;
    :cond_2
    iget-object v3, p0, Lcom/amazon/retailsearch/interaction/SearchDataSource;->currentSearchLoader:Lcom/amazon/retailsearch/data/search/SearchLoader;

    return-object v3
.end method

.method public submitQuery(Ljava/lang/String;)Lcom/amazon/retailsearch/data/SearchTask;
    .locals 2
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 101
    invoke-static {p1}, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->fromUrl(Ljava/lang/String;)Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;

    move-result-object v0

    .line 102
    .local v0, "q":Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;
    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/interaction/SearchDataSource;->submitQuery(Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;)Lcom/amazon/retailsearch/data/SearchTask;

    move-result-object v1

    return-object v1
.end method

.method public submitStagedQuery()Lcom/amazon/retailsearch/data/SearchTask;
    .locals 1

    .prologue
    .line 129
    iget-object v0, p0, Lcom/amazon/retailsearch/interaction/SearchDataSource;->lastStagedQuery:Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;

    if-eqz v0, :cond_0

    .line 131
    iget-object v0, p0, Lcom/amazon/retailsearch/interaction/SearchDataSource;->lastStagedQuery:Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/interaction/SearchDataSource;->submitQuery(Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;)Lcom/amazon/retailsearch/data/SearchTask;

    move-result-object v0

    .line 135
    :goto_0
    return-object v0

    :cond_0
    sget-object v0, Lcom/amazon/retailsearch/interaction/SearchDataSource;->EMPTY_SEARCH_TASK:Lcom/amazon/retailsearch/data/EmptySearchTask;

    goto :goto_0
.end method
