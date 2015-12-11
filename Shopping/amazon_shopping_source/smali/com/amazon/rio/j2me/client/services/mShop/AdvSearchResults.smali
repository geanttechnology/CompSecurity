.class public Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;
.super Ljava/lang/Object;
.source "AdvSearchResults.java"


# instance fields
.field private availableCount:Ljava/lang/Integer;

.field private breadcrumbs:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/Breadcrumb;",
            ">;"
        }
    .end annotation
.end field

.field private filters:Ljava/lang/String;

.field private query:Ljava/lang/String;

.field private refinements:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/RefinementBin;",
            ">;"
        }
    .end annotation
.end field

.field private results:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;",
            ">;"
        }
    .end annotation
.end field

.field private resultsDesc:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/HyperText;",
            ">;"
        }
    .end annotation
.end field

.field private sortOptions:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/SortOption;",
            ">;"
        }
    .end annotation
.end field

.field private stubs:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/MinimalItem;",
            ">;"
        }
    .end annotation
.end field

.field private totalCount:Ljava/lang/Integer;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAvailableCount()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;->availableCount:Ljava/lang/Integer;

    return-object v0
.end method

.method public getBreadcrumbs()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/Breadcrumb;",
            ">;"
        }
    .end annotation

    .prologue
    .line 120
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;->breadcrumbs:Ljava/util/List;

    return-object v0
.end method

.method public getFilters()Ljava/lang/String;
    .locals 1

    .prologue
    .line 107
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;->filters:Ljava/lang/String;

    return-object v0
.end method

.method public getQuery()Ljava/lang/String;
    .locals 1

    .prologue
    .line 81
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;->query:Ljava/lang/String;

    return-object v0
.end method

.method public getRefinements()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/RefinementBin;",
            ">;"
        }
    .end annotation

    .prologue
    .line 94
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;->refinements:Ljava/util/List;

    return-object v0
.end method

.method public getResults()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;",
            ">;"
        }
    .end annotation

    .prologue
    .line 55
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;->results:Ljava/util/List;

    return-object v0
.end method

.method public getResultsDesc()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/HyperText;",
            ">;"
        }
    .end annotation

    .prologue
    .line 146
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;->resultsDesc:Ljava/util/List;

    return-object v0
.end method

.method public getSortOptions()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/SortOption;",
            ">;"
        }
    .end annotation

    .prologue
    .line 133
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;->sortOptions:Ljava/util/List;

    return-object v0
.end method

.method public getTotalCount()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;->totalCount:Ljava/lang/Integer;

    return-object v0
.end method

.method public setAvailableCount(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Integer;

    .prologue
    .line 47
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;->availableCount:Ljava/lang/Integer;

    .line 48
    return-void
.end method

.method public setBreadcrumbs(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/Breadcrumb;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 125
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/Breadcrumb;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;->breadcrumbs:Ljava/util/List;

    .line 126
    return-void
.end method

.method public setFilters(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 112
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;->filters:Ljava/lang/String;

    .line 113
    return-void
.end method

.method public setQuery(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 86
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;->query:Ljava/lang/String;

    .line 87
    return-void
.end method

.method public setRefinements(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/RefinementBin;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 99
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/RefinementBin;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;->refinements:Ljava/util/List;

    .line 100
    return-void
.end method

.method public setResults(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 60
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;->results:Ljava/util/List;

    .line 61
    return-void
.end method

.method public setResultsDesc(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/HyperText;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 151
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/HyperText;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;->resultsDesc:Ljava/util/List;

    .line 152
    return-void
.end method

.method public setSortOptions(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/SortOption;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 138
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/SortOption;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;->sortOptions:Ljava/util/List;

    .line 139
    return-void
.end method

.method public setStubs(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/MinimalItem;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 73
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/MinimalItem;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;->stubs:Ljava/util/List;

    .line 74
    return-void
.end method

.method public setTotalCount(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Integer;

    .prologue
    .line 34
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;->totalCount:Ljava/lang/Integer;

    .line 35
    return-void
.end method
