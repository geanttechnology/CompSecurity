.class public Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private bbyProducts:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
            ">;"
        }
    .end annotation
.end field

.field private categoryMap:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private facets:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/solr/Facet;",
            ">;"
        }
    .end annotation
.end field

.field private requestInfo:Lcom/bestbuy/android/api/lib/models/solr/SolrRequestInfo;

.field private skuList:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private sortOptions:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/solr/SortOption;",
            ">;"
        }
    .end annotation
.end field

.field private totalCount:I


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;->facets:Ljava/util/ArrayList;

    .line 22
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;->skuList:Ljava/util/ArrayList;

    .line 24
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;->bbyProducts:Ljava/util/ArrayList;

    .line 25
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;->sortOptions:Ljava/util/ArrayList;

    .line 26
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;->categoryMap:Ljava/util/HashMap;

    return-void
.end method


# virtual methods
.method public getBbyProducts()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
            ">;"
        }
    .end annotation

    .prologue
    .line 82
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;->bbyProducts:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getCategoryMap()Ljava/util/HashMap;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 78
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;->categoryMap:Ljava/util/HashMap;

    return-object v0
.end method

.method public getFacets()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/solr/Facet;",
            ">;"
        }
    .end annotation

    .prologue
    .line 30
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;->facets:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getRequestInfo()Lcom/bestbuy/android/api/lib/models/solr/SolrRequestInfo;
    .locals 1

    .prologue
    .line 70
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;->requestInfo:Lcom/bestbuy/android/api/lib/models/solr/SolrRequestInfo;

    return-object v0
.end method

.method public getSkuList()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 38
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;->skuList:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getSortOptions()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/solr/SortOption;",
            ">;"
        }
    .end annotation

    .prologue
    .line 54
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;->sortOptions:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getTotalCount()I
    .locals 1

    .prologue
    .line 62
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;->totalCount:I

    return v0
.end method

.method public setBbyProducts(Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 86
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;->bbyProducts:Ljava/util/ArrayList;

    .line 87
    return-void
.end method

.method public setFacets(Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/solr/Facet;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 34
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;->facets:Ljava/util/ArrayList;

    .line 35
    return-void
.end method

.method public setRequestInfo(Lcom/bestbuy/android/api/lib/models/solr/SolrRequestInfo;)V
    .locals 0

    .prologue
    .line 74
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;->requestInfo:Lcom/bestbuy/android/api/lib/models/solr/SolrRequestInfo;

    .line 75
    return-void
.end method

.method public setSkuList(Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 42
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;->skuList:Ljava/util/ArrayList;

    .line 43
    return-void
.end method

.method public setSortOptions(Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/solr/SortOption;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 58
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;->sortOptions:Ljava/util/ArrayList;

    .line 59
    return-void
.end method

.method public setTotalCount(I)V
    .locals 0

    .prologue
    .line 66
    iput p1, p0, Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;->totalCount:I

    .line 67
    return-void
.end method
