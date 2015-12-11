.class public Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private facetId:I

.field private filters:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;",
            ">;"
        }
    .end annotation
.end field

.field private hasMoreFilters:Z

.field private index:I

.field private name:Ljava/lang/String;

.field private position:I

.field private totalFilterCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static loadDNMFacetsData(Lorg/json/JSONArray;)Ljava/util/ArrayList;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/json/JSONArray;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;",
            ">;"
        }
    .end annotation

    .prologue
    .line 60
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 61
    const/4 v0, 0x0

    :goto_0
    invoke-virtual {p0}, Lorg/json/JSONArray;->length()I

    move-result v2

    if-ge v0, v2, :cond_2

    .line 62
    invoke-virtual {p0, v0}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v2

    .line 63
    if-eqz v2, :cond_1

    .line 64
    new-instance v3, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;

    invoke-direct {v3}, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;-><init>()V

    .line 65
    const-string v4, "name"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, v3, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;->name:Ljava/lang/String;

    .line 66
    const-string v4, "position"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v4

    iput v4, v3, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;->position:I

    .line 67
    const-string v4, "totalFilterCount"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v4

    iput v4, v3, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;->totalFilterCount:I

    .line 68
    const-string v4, "hasMoreFilters"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v4

    iput-boolean v4, v3, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;->hasMoreFilters:Z

    .line 69
    const-string v4, "facetId"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v4

    iput v4, v3, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;->facetId:I

    .line 70
    iput v0, v3, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;->index:I

    .line 71
    const-string v4, "filters"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v4

    if-eqz v4, :cond_0

    .line 72
    const-string v4, "filters"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v2

    iget-object v4, v3, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;->name:Ljava/lang/String;

    invoke-static {v2, v4}, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;->loadDNMFilterData(Lorg/json/JSONArray;Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v2

    iput-object v2, v3, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;->filters:Ljava/util/ArrayList;

    .line 73
    :cond_0
    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 61
    :cond_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 76
    :cond_2
    return-object v1
.end method


# virtual methods
.method public getFacetId()I
    .locals 1

    .prologue
    .line 44
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;->facetId:I

    return v0
.end method

.method public getFilters()Ljava/util/ArrayList;
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
    .line 52
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;->filters:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getIndex()I
    .locals 1

    .prologue
    .line 48
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;->index:I

    return v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getPosition()I
    .locals 1

    .prologue
    .line 32
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;->position:I

    return v0
.end method

.method public getTotalFilterCount()I
    .locals 1

    .prologue
    .line 36
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;->totalFilterCount:I

    return v0
.end method

.method public isHasMoreFilters()Z
    .locals 1

    .prologue
    .line 40
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;->hasMoreFilters:Z

    return v0
.end method

.method public setFilters(Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 56
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;->filters:Ljava/util/ArrayList;

    .line 57
    return-void
.end method
