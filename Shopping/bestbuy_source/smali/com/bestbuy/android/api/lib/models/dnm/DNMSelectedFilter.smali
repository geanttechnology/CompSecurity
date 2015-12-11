.class public Lcom/bestbuy/android/api/lib/models/dnm/DNMSelectedFilter;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private facetTitle:Ljava/lang/String;

.field private filterQuery:Ljava/lang/String;

.field private removeLinkFlag:Z

.field private selectedFilterValue:Ljava/lang/String;

.field private unselectPath:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static loadSelectedFilterData(Lorg/json/JSONArray;)Ljava/util/ArrayList;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/json/JSONArray;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/dnm/DNMSelectedFilter;",
            ">;"
        }
    .end annotation

    .prologue
    .line 48
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 49
    const/4 v0, 0x0

    :goto_0
    invoke-virtual {p0}, Lorg/json/JSONArray;->length()I

    move-result v2

    if-ge v0, v2, :cond_1

    .line 50
    invoke-virtual {p0, v0}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v2

    .line 51
    if-eqz v2, :cond_0

    .line 52
    new-instance v3, Lcom/bestbuy/android/api/lib/models/dnm/DNMSelectedFilter;

    invoke-direct {v3}, Lcom/bestbuy/android/api/lib/models/dnm/DNMSelectedFilter;-><init>()V

    .line 53
    const-string v4, "selectedFilterValue"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, v3, Lcom/bestbuy/android/api/lib/models/dnm/DNMSelectedFilter;->selectedFilterValue:Ljava/lang/String;

    .line 54
    const-string v4, "unselectPath"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, v3, Lcom/bestbuy/android/api/lib/models/dnm/DNMSelectedFilter;->unselectPath:Ljava/lang/String;

    .line 55
    const-string v4, "filterQuery"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, v3, Lcom/bestbuy/android/api/lib/models/dnm/DNMSelectedFilter;->filterQuery:Ljava/lang/String;

    .line 56
    const-string v4, "facetTitle"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, v3, Lcom/bestbuy/android/api/lib/models/dnm/DNMSelectedFilter;->facetTitle:Ljava/lang/String;

    .line 57
    const-string v4, "removeLinkFlag"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v2

    iput-boolean v2, v3, Lcom/bestbuy/android/api/lib/models/dnm/DNMSelectedFilter;->removeLinkFlag:Z

    .line 58
    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 49
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 61
    :cond_1
    return-object v1
.end method


# virtual methods
.method public getFacetTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMSelectedFilter;->facetTitle:Ljava/lang/String;

    return-object v0
.end method

.method public getFilterQuery()Ljava/lang/String;
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMSelectedFilter;->filterQuery:Ljava/lang/String;

    return-object v0
.end method

.method public getSelectedFilterValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMSelectedFilter;->selectedFilterValue:Ljava/lang/String;

    return-object v0
.end method

.method public getUnselectPath()Ljava/lang/String;
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMSelectedFilter;->unselectPath:Ljava/lang/String;

    return-object v0
.end method

.method public isRemoveLinkFlag()Z
    .locals 1

    .prologue
    .line 44
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMSelectedFilter;->removeLinkFlag:Z

    return v0
.end method
