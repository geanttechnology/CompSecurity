.class public Lcom/bestbuy/android/api/lib/models/solr/SolrRequestInfo;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private categoryFacet:Lcom/bestbuy/android/api/lib/models/solr/CategoryFacet;

.field private queryString:Ljava/lang/String;

.field private requestedFacets:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation
.end field

.field private sortOption:Lcom/bestbuy/android/api/lib/models/solr/SortOption;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getCategoryFacet()Lcom/bestbuy/android/api/lib/models/solr/CategoryFacet;
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/solr/SolrRequestInfo;->categoryFacet:Lcom/bestbuy/android/api/lib/models/solr/CategoryFacet;

    return-object v0
.end method

.method public getQueryString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 25
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/solr/SolrRequestInfo;->queryString:Ljava/lang/String;

    return-object v0
.end method

.method public getRequestedFacets()Ljava/util/HashMap;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 49
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/solr/SolrRequestInfo;->requestedFacets:Ljava/util/HashMap;

    return-object v0
.end method

.method public getSortOption()Lcom/bestbuy/android/api/lib/models/solr/SortOption;
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/solr/SolrRequestInfo;->sortOption:Lcom/bestbuy/android/api/lib/models/solr/SortOption;

    return-object v0
.end method

.method public setCategoryFacet(Lcom/bestbuy/android/api/lib/models/solr/CategoryFacet;)V
    .locals 0

    .prologue
    .line 45
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/solr/SolrRequestInfo;->categoryFacet:Lcom/bestbuy/android/api/lib/models/solr/CategoryFacet;

    .line 46
    return-void
.end method

.method public setQueryString(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 29
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/solr/SolrRequestInfo;->queryString:Ljava/lang/String;

    .line 30
    return-void
.end method

.method public setRequestedFacets(Ljava/util/HashMap;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;>;)V"
        }
    .end annotation

    .prologue
    .line 53
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/solr/SolrRequestInfo;->requestedFacets:Ljava/util/HashMap;

    .line 54
    return-void
.end method

.method public setSortOption(Lcom/bestbuy/android/api/lib/models/solr/SortOption;)V
    .locals 0

    .prologue
    .line 37
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/solr/SolrRequestInfo;->sortOption:Lcom/bestbuy/android/api/lib/models/solr/SortOption;

    .line 38
    return-void
.end method
