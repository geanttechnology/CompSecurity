.class public Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private count:I

.field private displayText:Ljava/lang/String;

.field private facetTitle:Ljava/lang/String;

.field private filterQuery:Ljava/lang/String;

.field private pathToNavigateOnThisFilter:Ljava/lang/String;

.field private selected:Z

.field private tabSelectedFlag:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static loadDNMFilterData(Lorg/json/JSONArray;Ljava/lang/String;)Ljava/util/ArrayList;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/json/JSONArray;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;",
            ">;"
        }
    .end annotation

    .prologue
    .line 65
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 66
    const/4 v0, 0x0

    :goto_0
    invoke-virtual {p0}, Lorg/json/JSONArray;->length()I

    move-result v1

    if-ge v0, v1, :cond_1

    .line 67
    invoke-virtual {p0, v0}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v3

    .line 68
    if-eqz v3, :cond_0

    .line 69
    new-instance v4, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;

    invoke-direct {v4}, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;-><init>()V

    .line 70
    const-string v1, "count"

    invoke-virtual {v3, v1}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v1

    iput v1, v4, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;->count:I

    .line 71
    const-string v1, "displayText"

    invoke-virtual {v3, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v4, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;->displayText:Ljava/lang/String;

    .line 73
    :try_start_0
    iget-object v1, v4, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;->displayText:Ljava/lang/String;

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v4, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;->displayText:Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 77
    :goto_1
    const-string v1, "tabSelectedFlag"

    invoke-virtual {v3, v1}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v1

    iput-boolean v1, v4, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;->tabSelectedFlag:Z

    .line 78
    const-string v1, "filterQuery"

    invoke-virtual {v3, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v4, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;->filterQuery:Ljava/lang/String;

    .line 79
    const-string v1, "pathToNavigateOnThisFilter"

    invoke-virtual {v3, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v4, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;->pathToNavigateOnThisFilter:Ljava/lang/String;

    .line 80
    const-string v1, "selected"

    invoke-virtual {v3, v1}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v1

    iput-boolean v1, v4, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;->selected:Z

    .line 81
    iput-object p1, v4, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;->facetTitle:Ljava/lang/String;

    .line 82
    invoke-virtual {v2, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 66
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 74
    :catch_0
    move-exception v1

    .line 75
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_1

    .line 85
    :cond_1
    return-object v2
.end method

.method public static loadSelectedFilterData(Lorg/json/JSONArray;)Ljava/util/ArrayList;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/json/JSONArray;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;",
            ">;"
        }
    .end annotation

    .prologue
    .line 89
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 90
    const/4 v0, 0x0

    :goto_0
    invoke-virtual {p0}, Lorg/json/JSONArray;->length()I

    move-result v1

    if-ge v0, v1, :cond_1

    .line 91
    invoke-virtual {p0, v0}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v3

    .line 92
    if-eqz v3, :cond_0

    .line 93
    new-instance v4, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;

    invoke-direct {v4}, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;-><init>()V

    .line 94
    const-string v1, "selectedFilterValue"

    invoke-virtual {v3, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v4, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;->displayText:Ljava/lang/String;

    .line 96
    :try_start_0
    iget-object v1, v4, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;->displayText:Ljava/lang/String;

    const-string v5, "\\"

    const-string v6, ""

    invoke-virtual {v1, v5, v6}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v1

    const-string v5, "\\;"

    const-string v6, ""

    invoke-virtual {v1, v5, v6}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v4, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;->displayText:Ljava/lang/String;

    .line 97
    iget-object v1, v4, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;->displayText:Ljava/lang/String;

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v4, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;->displayText:Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 101
    :goto_1
    const-string v1, "filterQuery"

    invoke-virtual {v3, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v4, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;->filterQuery:Ljava/lang/String;

    .line 102
    const-string v1, "facetTitle"

    invoke-virtual {v3, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v4, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;->facetTitle:Ljava/lang/String;

    .line 103
    invoke-virtual {v2, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 90
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 98
    :catch_0
    move-exception v1

    .line 99
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_1

    .line 106
    :cond_1
    return-object v2
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 37
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;->count:I

    return v0
.end method

.method public getDisplayText()Ljava/lang/String;
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;->displayText:Ljava/lang/String;

    return-object v0
.end method

.method public getFacetTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;->facetTitle:Ljava/lang/String;

    return-object v0
.end method

.method public getFilterQuery()Ljava/lang/String;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;->filterQuery:Ljava/lang/String;

    return-object v0
.end method

.method public getPathToNavigateOnThisFilter()Ljava/lang/String;
    .locals 1

    .prologue
    .line 57
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;->pathToNavigateOnThisFilter:Ljava/lang/String;

    return-object v0
.end method

.method public isSelected()Z
    .locals 1

    .prologue
    .line 61
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;->selected:Z

    return v0
.end method

.method public isTabSelectedFlag()Z
    .locals 1

    .prologue
    .line 45
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;->tabSelectedFlag:Z

    return v0
.end method

.method public setDisplayText(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 49
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;->displayText:Ljava/lang/String;

    .line 50
    return-void
.end method
