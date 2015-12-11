.class public Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;
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

.field private corrected:Z

.field private correctedTerm:Ljava/lang/String;

.field private dnmProducts:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;",
            ">;"
        }
    .end annotation
.end field

.field private errorMsg:Ljava/lang/String;

.field private facetsFilters:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;",
            ">;"
        }
    .end annotation
.end field

.field private msvPageType:Ljava/lang/String;

.field private originalTerm:Ljava/lang/String;

.field private pageType:Ljava/lang/String;

.field private phoneNumber:Ljava/lang/String;

.field private productSkus:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private selectedFilters:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;",
            ">;"
        }
    .end annotation
.end field

.field private sortOptions:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/dnm/DNMSortOption;",
            ">;"
        }
    .end annotation
.end field

.field private storeAddress:Ljava/lang/String;

.field private storeName:Ljava/lang/String;

.field private termRemovedSinceNoResults:Z

.field private totalCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static loadDNMData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;
    .locals 4

    .prologue
    .line 121
    new-instance v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;

    invoke-direct {v2}, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;-><init>()V

    .line 122
    const-string v0, "storeName"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;->storeName:Ljava/lang/String;

    .line 123
    const-string v0, "errorMsg"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;->errorMsg:Ljava/lang/String;

    .line 124
    const-string v0, "pageType"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;->pageType:Ljava/lang/String;

    .line 125
    const-string v0, "msvPageType"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;->msvPageType:Ljava/lang/String;

    .line 126
    const-string v0, "phoneNumber"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;->phoneNumber:Ljava/lang/String;

    .line 127
    const-string v0, "totalCount"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v0

    iput v0, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;->totalCount:I

    .line 128
    const-string v0, "itemList"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 129
    const-string v0, "itemList"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    invoke-static {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->loadDNMProducts(Lorg/json/JSONArray;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;->dnmProducts:Ljava/util/ArrayList;

    .line 130
    :cond_0
    const-string v0, "selectedFacets"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 131
    const-string v0, "selectedFacets"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    invoke-static {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;->loadSelectedFilterData(Lorg/json/JSONArray;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;->selectedFilters:Ljava/util/ArrayList;

    .line 132
    :cond_1
    const-string v0, "facets"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    if-eqz v0, :cond_2

    .line 133
    const-string v0, "facets"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    invoke-static {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;->loadDNMFacetsData(Lorg/json/JSONArray;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;->facetsFilters:Ljava/util/ArrayList;

    .line 134
    :cond_2
    invoke-static {}, Lcom/bestbuy/android/api/lib/models/dnm/DNMSortOption;->loadSortOptions()Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;->sortOptions:Ljava/util/ArrayList;

    .line 135
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;->productSkus:Ljava/util/ArrayList;

    .line 136
    iget-object v0, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;->dnmProducts:Ljava/util/ArrayList;

    if-eqz v0, :cond_3

    .line 137
    const/4 v0, 0x0

    move v1, v0

    :goto_0
    iget-object v0, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;->dnmProducts:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v1, v0, :cond_3

    .line 138
    iget-object v0, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;->dnmProducts:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    .line 139
    iget-object v3, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;->productSkus:Ljava/util/ArrayList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getSkuId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 137
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    .line 142
    :cond_3
    const-string v0, "searchTerm"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    if-eqz v0, :cond_4

    .line 143
    const-string v0, "searchTerm"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 144
    const-string v1, "correctedTerm"

    const-string v3, ""

    invoke-virtual {v0, v1, v3}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;->correctedTerm:Ljava/lang/String;

    .line 145
    const-string v1, "originalTerm"

    const-string v3, ""

    invoke-virtual {v0, v1, v3}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;->originalTerm:Ljava/lang/String;

    .line 146
    const-string v1, "corrected"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v1

    iput-boolean v1, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;->corrected:Z

    .line 147
    const-string v1, "termRemovedSinceNoResults"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;->termRemovedSinceNoResults:Z

    .line 149
    :cond_4
    return-object v2
.end method


# virtual methods
.method public getCorrectedTerm()Ljava/lang/String;
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;->correctedTerm:Ljava/lang/String;

    return-object v0
.end method

.method public getDnmProducts()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;",
            ">;"
        }
    .end annotation

    .prologue
    .line 97
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;->dnmProducts:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getErrorMsg()Ljava/lang/String;
    .locals 1

    .prologue
    .line 65
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;->errorMsg:Ljava/lang/String;

    return-object v0
.end method

.method public getFacetsFilters()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;",
            ">;"
        }
    .end annotation

    .prologue
    .line 93
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;->facetsFilters:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getMsvPageType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 73
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;->msvPageType:Ljava/lang/String;

    return-object v0
.end method

.method public getOriginalTerm()Ljava/lang/String;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;->originalTerm:Ljava/lang/String;

    return-object v0
.end method

.method public getPageType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;->pageType:Ljava/lang/String;

    return-object v0
.end method

.method public getPhoneNumber()Ljava/lang/String;
    .locals 1

    .prologue
    .line 77
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;->phoneNumber:Ljava/lang/String;

    return-object v0
.end method

.method public getProductSkus()Ljava/util/ArrayList;
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
    .line 117
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;->productSkus:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getProducts()Ljava/util/ArrayList;
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
    .line 109
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;->bbyProducts:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getSelectedFilters()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;",
            ">;"
        }
    .end annotation

    .prologue
    .line 89
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;->selectedFilters:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getSortOptions()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/dnm/DNMSortOption;",
            ">;"
        }
    .end annotation

    .prologue
    .line 105
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;->sortOptions:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getStoreAddress()Ljava/lang/String;
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;->storeAddress:Ljava/lang/String;

    return-object v0
.end method

.method public getStoreName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 57
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;->storeName:Ljava/lang/String;

    return-object v0
.end method

.method public getTotalCount()I
    .locals 1

    .prologue
    .line 81
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;->totalCount:I

    return v0
.end method

.method public isCorrected()Z
    .locals 1

    .prologue
    .line 45
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;->corrected:Z

    return v0
.end method

.method public isTermRemovedSinceNoResults()Z
    .locals 1

    .prologue
    .line 49
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;->termRemovedSinceNoResults:Z

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
    .line 113
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;->bbyProducts:Ljava/util/ArrayList;

    .line 114
    return-void
.end method

.method public setDnmProducts(Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 101
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;->dnmProducts:Ljava/util/ArrayList;

    .line 102
    return-void
.end method

.method public setTotalCount(I)V
    .locals 0

    .prologue
    .line 85
    iput p1, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;->totalCount:I

    .line 86
    return-void
.end method
