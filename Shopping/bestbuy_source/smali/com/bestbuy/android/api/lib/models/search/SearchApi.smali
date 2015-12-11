.class public Lcom/bestbuy/android/api/lib/models/search/SearchApi;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private banners:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/search/Banners;",
            ">;"
        }
    .end annotation
.end field

.field public categoryMap:Ljava/util/HashMap;
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

.field private documents:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/search/Documents;",
            ">;"
        }
    .end annotation
.end field

.field private facets:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/search/Facets;",
            ">;"
        }
    .end annotation
.end field

.field private plpAvailabilityEnabled:Z

.field private requestInfo:Lcom/bestbuy/android/api/lib/models/search/RequestInfo;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "request_info"
    .end annotation
.end field

.field public requestedFacets:Ljava/util/HashMap;
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

.field private skuDetails:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
            ">;"
        }
    .end annotation
.end field

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
            "Lcom/bestbuy/android/api/lib/models/search/SortOptions;",
            ">;"
        }
    .end annotation
.end field

.field private storeDetails:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

.field private suggestQueryInfo:Lcom/bestbuy/android/api/lib/models/search/SuggestQueryInfo;

.field private total:I
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "num_found"
    .end annotation
.end field

.field private track:Lcom/bestbuy/android/api/lib/models/search/Track;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 42
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->categoryMap:Ljava/util/HashMap;

    .line 43
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->requestedFacets:Ljava/util/HashMap;

    return-void
.end method


# virtual methods
.method public getBanners()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/search/Banners;",
            ">;"
        }
    .end annotation

    .prologue
    .line 134
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->banners:Ljava/util/ArrayList;

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
    .line 83
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->categoryMap:Ljava/util/HashMap;

    return-object v0
.end method

.method public getDocuments()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/search/Documents;",
            ">;"
        }
    .end annotation

    .prologue
    .line 120
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->documents:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getFacets()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/search/Facets;",
            ">;"
        }
    .end annotation

    .prologue
    .line 127
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->facets:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getRequestInfo()Lcom/bestbuy/android/api/lib/models/search/RequestInfo;
    .locals 1

    .prologue
    .line 155
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->requestInfo:Lcom/bestbuy/android/api/lib/models/search/RequestInfo;

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
    .line 69
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->requestedFacets:Ljava/util/HashMap;

    return-object v0
.end method

.method public getSkuDetails()Ljava/util/ArrayList;
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
    .line 99
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->skuDetails:Ljava/util/ArrayList;

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
    .line 221
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->skuList:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getSortOptions()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/search/SortOptions;",
            ">;"
        }
    .end annotation

    .prologue
    .line 141
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->sortOptions:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/BBYStore;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->storeDetails:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    return-object v0
.end method

.method public getSuggestQueryInfo()Lcom/bestbuy/android/api/lib/models/search/SuggestQueryInfo;
    .locals 1

    .prologue
    .line 148
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->suggestQueryInfo:Lcom/bestbuy/android/api/lib/models/search/SuggestQueryInfo;

    return-object v0
.end method

.method public getTotal()I
    .locals 1

    .prologue
    .line 113
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->total:I

    return v0
.end method

.method public getTrack()Lcom/bestbuy/android/api/lib/models/search/Track;
    .locals 1

    .prologue
    .line 162
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->track:Lcom/bestbuy/android/api/lib/models/search/Track;

    return-object v0
.end method

.method public isPlpAvailabilityEnabled()Z
    .locals 1

    .prologue
    .line 58
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->plpAvailabilityEnabled:Z

    return v0
.end method

.method public setBanners(Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/search/Banners;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 190
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->banners:Ljava/util/ArrayList;

    .line 191
    return-void
.end method

.method public setCategoryMap(Ljava/util/HashMap;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 90
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->categoryMap:Ljava/util/HashMap;

    .line 91
    return-void
.end method

.method public setDocuments(Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/search/Documents;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 176
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->documents:Ljava/util/ArrayList;

    .line 177
    return-void
.end method

.method public setFacets(Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/search/Facets;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 183
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->facets:Ljava/util/ArrayList;

    .line 184
    return-void
.end method

.method public setPlpAvailabilityEnabled(Z)V
    .locals 0

    .prologue
    .line 62
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->plpAvailabilityEnabled:Z

    .line 63
    return-void
.end method

.method public setRequestInfo(Lcom/bestbuy/android/api/lib/models/search/RequestInfo;)V
    .locals 0

    .prologue
    .line 211
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->requestInfo:Lcom/bestbuy/android/api/lib/models/search/RequestInfo;

    .line 212
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
    .line 76
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->requestedFacets:Ljava/util/HashMap;

    .line 77
    return-void
.end method

.method public setSkuDetails(Ljava/util/ArrayList;)V
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
    .line 106
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->skuDetails:Ljava/util/ArrayList;

    .line 107
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
    .line 225
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->skuList:Ljava/util/ArrayList;

    .line 226
    return-void
.end method

.method public setSortOptions(Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/search/SortOptions;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 197
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->sortOptions:Ljava/util/ArrayList;

    .line 198
    return-void
.end method

.method public setStoreDetails(Lcom/bestbuy/android/api/lib/models/store/BBYStore;)V
    .locals 0

    .prologue
    .line 54
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->storeDetails:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    .line 55
    return-void
.end method

.method public setSuggestQueryInfo(Lcom/bestbuy/android/api/lib/models/search/SuggestQueryInfo;)V
    .locals 0

    .prologue
    .line 204
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->suggestQueryInfo:Lcom/bestbuy/android/api/lib/models/search/SuggestQueryInfo;

    .line 205
    return-void
.end method

.method public setTotal(I)V
    .locals 0

    .prologue
    .line 169
    iput p1, p0, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->total:I

    .line 170
    return-void
.end method

.method public setTrack(Lcom/bestbuy/android/api/lib/models/search/Track;)V
    .locals 0

    .prologue
    .line 218
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->track:Lcom/bestbuy/android/api/lib/models/search/Track;

    .line 219
    return-void
.end method
