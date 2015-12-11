.class public Lcom/bestbuy/android/api/lib/models/search/RequestInfo;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private appliedFacets:Ljava/util/ArrayList;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "applied_facets"
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/search/AppliedFacets;",
            ">;"
        }
    .end annotation
.end field

.field private categoryFacet:Lcom/bestbuy/android/api/lib/models/search/CategoryFacets;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "category_facet"
    .end annotation
.end field

.field private query:Ljava/lang/String;

.field private sort:Lcom/bestbuy/android/api/lib/models/search/Sort;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAppliedFacets()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/search/AppliedFacets;",
            ">;"
        }
    .end annotation

    .prologue
    .line 63
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/search/RequestInfo;->appliedFacets:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getCategoryFacet()Lcom/bestbuy/android/api/lib/models/search/CategoryFacets;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/search/RequestInfo;->categoryFacet:Lcom/bestbuy/android/api/lib/models/search/CategoryFacets;

    return-object v0
.end method

.method public getQuery()Ljava/lang/String;
    .locals 1

    .prologue
    .line 49
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/search/RequestInfo;->query:Ljava/lang/String;

    return-object v0
.end method

.method public getSort()Lcom/bestbuy/android/api/lib/models/search/Sort;
    .locals 1

    .prologue
    .line 56
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/search/RequestInfo;->sort:Lcom/bestbuy/android/api/lib/models/search/Sort;

    return-object v0
.end method

.method public setAppliedFacets(Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/search/AppliedFacets;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 84
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/search/RequestInfo;->appliedFacets:Ljava/util/ArrayList;

    .line 85
    return-void
.end method

.method public setCategoryFacet(Lcom/bestbuy/android/api/lib/models/search/CategoryFacets;)V
    .locals 0

    .prologue
    .line 42
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/search/RequestInfo;->categoryFacet:Lcom/bestbuy/android/api/lib/models/search/CategoryFacets;

    .line 43
    return-void
.end method

.method public setQuery(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 70
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/search/RequestInfo;->query:Ljava/lang/String;

    .line 71
    return-void
.end method

.method public setSort(Lcom/bestbuy/android/api/lib/models/search/Sort;)V
    .locals 0

    .prologue
    .line 77
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/search/RequestInfo;->sort:Lcom/bestbuy/android/api/lib/models/search/Sort;

    .line 78
    return-void
.end method
