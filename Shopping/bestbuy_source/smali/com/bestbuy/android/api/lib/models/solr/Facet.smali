.class public Lcom/bestbuy/android/api/lib/models/solr/Facet;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final TAG:Ljava/lang/String;

.field private static final serialVersionUID:J = 0x1L


# instance fields
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

.field private deptFacetField:Ljava/lang/String;

.field private deptFacetFieldValue:Ljava/lang/String;

.field private displayContext:Z

.field private displayDepFacet:Z

.field private displayFacetRemoveLink:Z

.field private displayMobileFacet:Z

.field private displayMobileFacetRemoveLink:Z

.field private displayName:Ljava/lang/String;

.field private displayRecurrence:Z

.field private facetDisplay:Z

.field private facetField:Ljava/lang/String;

.field private joinCondition:Ljava/lang/String;

.field private maxVaue:I

.field private minVaue:I

.field private systemName:Ljava/lang/String;

.field private uniqueFacetId:Ljava/lang/String;

.field private values:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/solr/Value;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 28
    const-class v0, Lcom/bestbuy/android/api/lib/models/solr/Facet;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/bestbuy/android/api/lib/models/solr/Facet;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 47
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/solr/Facet;->categoryMap:Ljava/util/HashMap;

    return-void
.end method

.method public static loadData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/solr/Facet;
    .locals 7

    .prologue
    const/4 v1, 0x0

    .line 107
    new-instance v2, Lcom/bestbuy/android/api/lib/models/solr/Facet;

    invoke-direct {v2}, Lcom/bestbuy/android/api/lib/models/solr/Facet;-><init>()V

    .line 108
    const-string v0, "systemName"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v2, Lcom/bestbuy/android/api/lib/models/solr/Facet;->systemName:Ljava/lang/String;

    .line 109
    const-string v0, "displayName"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v3, "(Hidden) DO NOT EDIT"

    const-string v4, ""

    invoke-virtual {v0, v3, v4}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v2, Lcom/bestbuy/android/api/lib/models/solr/Facet;->displayName:Ljava/lang/String;

    .line 110
    const-string v0, "facetField"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v2, Lcom/bestbuy/android/api/lib/models/solr/Facet;->facetField:Ljava/lang/String;

    .line 111
    const-string v0, "facetDisplay"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, v2, Lcom/bestbuy/android/api/lib/models/solr/Facet;->facetDisplay:Z

    .line 112
    const-string v0, "displayRecurrence"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, v2, Lcom/bestbuy/android/api/lib/models/solr/Facet;->displayRecurrence:Z

    .line 113
    const-string v0, "displayFacetRemoveLink"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, v2, Lcom/bestbuy/android/api/lib/models/solr/Facet;->displayFacetRemoveLink:Z

    .line 114
    const-string v0, "displayMobileFacet"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, v2, Lcom/bestbuy/android/api/lib/models/solr/Facet;->displayMobileFacet:Z

    .line 115
    const-string v0, "displayMobileFacetRemoveLink"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, v2, Lcom/bestbuy/android/api/lib/models/solr/Facet;->displayMobileFacetRemoveLink:Z

    .line 116
    const-string v0, "depFacetField"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v2, Lcom/bestbuy/android/api/lib/models/solr/Facet;->deptFacetField:Ljava/lang/String;

    .line 117
    const-string v0, "depFacetFieldValue"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v2, Lcom/bestbuy/android/api/lib/models/solr/Facet;->deptFacetFieldValue:Ljava/lang/String;

    .line 118
    const-string v0, "displayContext"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 119
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v3

    if-lez v3, :cond_2

    .line 120
    const-string v3, "Yes"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    const/4 v0, 0x1

    :goto_0
    iput-boolean v0, v2, Lcom/bestbuy/android/api/lib/models/solr/Facet;->displayContext:Z

    .line 124
    :goto_1
    const-string v0, "displayDepFacet"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, v2, Lcom/bestbuy/android/api/lib/models/solr/Facet;->displayDepFacet:Z

    .line 125
    const-string v0, "minValue"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v0

    iput v0, v2, Lcom/bestbuy/android/api/lib/models/solr/Facet;->minVaue:I

    .line 126
    const-string v0, "maxValue"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v0

    iput v0, v2, Lcom/bestbuy/android/api/lib/models/solr/Facet;->maxVaue:I

    .line 127
    const-string v0, "joinCondition"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v2, Lcom/bestbuy/android/api/lib/models/solr/Facet;->joinCondition:Ljava/lang/String;

    .line 128
    const-string v0, "uniqueFacetId"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v2, Lcom/bestbuy/android/api/lib/models/solr/Facet;->uniqueFacetId:Ljava/lang/String;

    .line 130
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, v2, Lcom/bestbuy/android/api/lib/models/solr/Facet;->values:Ljava/util/ArrayList;

    .line 131
    const-string v0, "values"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v3

    .line 133
    :goto_2
    invoke-virtual {v3}, Lorg/json/JSONArray;->length()I

    move-result v0

    if-ge v1, v0, :cond_3

    .line 135
    :try_start_0
    invoke-virtual {v3, v1}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v0

    invoke-static {v0}, Lcom/bestbuy/android/api/lib/models/solr/Value;->loadData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/solr/Value;

    move-result-object v0

    .line 136
    iget-object v4, v2, Lcom/bestbuy/android/api/lib/models/solr/Facet;->values:Ljava/util/ArrayList;

    invoke-virtual {v4, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 137
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/solr/Value;->getCatPath()Ljava/lang/String;

    move-result-object v4

    if-eqz v4, :cond_0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/solr/Value;->getCatPath()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->isEmpty()Z

    move-result v4

    if-nez v4, :cond_0

    .line 138
    iget-object v4, v2, Lcom/bestbuy/android/api/lib/models/solr/Facet;->categoryMap:Ljava/util/HashMap;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/solr/Value;->getValue()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/solr/Value;->getCatPath()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v4, v5, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 133
    :cond_0
    :goto_3
    add-int/lit8 v1, v1, 0x1

    goto :goto_2

    :cond_1
    move v0, v1

    .line 120
    goto :goto_0

    .line 122
    :cond_2
    iput-boolean v1, v2, Lcom/bestbuy/android/api/lib/models/solr/Facet;->displayContext:Z

    goto :goto_1

    .line 140
    :catch_0
    move-exception v0

    .line 141
    sget-object v4, Lcom/bestbuy/android/api/lib/models/solr/Facet;->TAG:Ljava/lang/String;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Could not parse Facet Value, skipping:"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v0}, Lorg/json/JSONException;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v4, v0}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_3

    .line 144
    :cond_3
    return-object v2
.end method


# virtual methods
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
    .line 50
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/solr/Facet;->categoryMap:Ljava/util/HashMap;

    return-object v0
.end method

.method public getDeptFacetField()Ljava/lang/String;
    .locals 1

    .prologue
    .line 78
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/solr/Facet;->deptFacetField:Ljava/lang/String;

    return-object v0
.end method

.method public getDeptFacetFieldValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 81
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/solr/Facet;->deptFacetFieldValue:Ljava/lang/String;

    return-object v0
.end method

.method public getDisplayName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 57
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/solr/Facet;->displayName:Ljava/lang/String;

    return-object v0
.end method

.method public getFacetField()Ljava/lang/String;
    .locals 1

    .prologue
    .line 60
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/solr/Facet;->facetField:Ljava/lang/String;

    return-object v0
.end method

.method public getJoinCondition()Ljava/lang/String;
    .locals 1

    .prologue
    .line 103
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/solr/Facet;->joinCondition:Ljava/lang/String;

    return-object v0
.end method

.method public getMaxVaue()I
    .locals 1

    .prologue
    .line 93
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/solr/Facet;->maxVaue:I

    return v0
.end method

.method public getMinVaue()I
    .locals 1

    .prologue
    .line 90
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/solr/Facet;->minVaue:I

    return v0
.end method

.method public getSystemName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/solr/Facet;->systemName:Ljava/lang/String;

    return-object v0
.end method

.method public getUniqueFacetId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 96
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/solr/Facet;->uniqueFacetId:Ljava/lang/String;

    return-object v0
.end method

.method public getValues()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/solr/Value;",
            ">;"
        }
    .end annotation

    .prologue
    .line 99
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/solr/Facet;->values:Ljava/util/ArrayList;

    return-object v0
.end method

.method public isDisplayContext()Z
    .locals 1

    .prologue
    .line 84
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/solr/Facet;->displayContext:Z

    return v0
.end method

.method public isDisplayDepFacet()Z
    .locals 1

    .prologue
    .line 87
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/solr/Facet;->displayDepFacet:Z

    return v0
.end method

.method public isDisplayFacetRemoveLink()Z
    .locals 1

    .prologue
    .line 69
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/solr/Facet;->displayFacetRemoveLink:Z

    return v0
.end method

.method public isDisplayMobileFacet()Z
    .locals 1

    .prologue
    .line 72
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/solr/Facet;->displayMobileFacet:Z

    return v0
.end method

.method public isDisplayMobileFacetRemoveLink()Z
    .locals 1

    .prologue
    .line 75
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/solr/Facet;->displayMobileFacetRemoveLink:Z

    return v0
.end method

.method public isDisplayRecurrence()Z
    .locals 1

    .prologue
    .line 66
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/solr/Facet;->displayRecurrence:Z

    return v0
.end method

.method public isFacetDisplay()Z
    .locals 1

    .prologue
    .line 63
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/solr/Facet;->facetDisplay:Z

    return v0
.end method
