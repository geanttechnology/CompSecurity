.class public Lcom/bestbuy/android/api/lib/models/search/Facets;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private depFacetField:Ljava/lang/String;

.field private depFacetFieldValue:Ljava/lang/String;

.field private displayContext:Ljava/lang/String;

.field private displayDepFacet:Ljava/lang/String;

.field private displayFacetRemoveLink:Z

.field private displayMobileFacet:Z

.field private displayMobileFacetRemoveLink:Z

.field private displayName:Ljava/lang/String;

.field private displayRecurrence:Z

.field private facetDisplay:Z

.field private facetField:Ljava/lang/String;

.field private joinCondition:Ljava/lang/String;

.field private maxValue:I

.field private systemName:Ljava/lang/String;

.field private uniqueFacetId:Ljava/lang/String;

.field private values:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/search/FacetValues;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getDepFacetField()Ljava/lang/String;
    .locals 1

    .prologue
    .line 78
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/search/Facets;->depFacetField:Ljava/lang/String;

    return-object v0
.end method

.method public getDepFacetFieldValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 85
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/search/Facets;->depFacetFieldValue:Ljava/lang/String;

    return-object v0
.end method

.method public getDisplayName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 183
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/search/Facets;->displayName:Ljava/lang/String;

    return-object v0
.end method

.method public getFacetField()Ljava/lang/String;
    .locals 1

    .prologue
    .line 190
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/search/Facets;->facetField:Ljava/lang/String;

    return-object v0
.end method

.method public getJoinCondition()Ljava/lang/String;
    .locals 1

    .prologue
    .line 204
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/search/Facets;->joinCondition:Ljava/lang/String;

    return-object v0
.end method

.method public getMaxValue()I
    .locals 1

    .prologue
    .line 106
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/search/Facets;->maxValue:I

    return v0
.end method

.method public getSystemName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/search/Facets;->systemName:Ljava/lang/String;

    return-object v0
.end method

.method public getUniqueFacetId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 211
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/search/Facets;->uniqueFacetId:Ljava/lang/String;

    return-object v0
.end method

.method public getValues()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/search/FacetValues;",
            ">;"
        }
    .end annotation

    .prologue
    .line 218
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/search/Facets;->values:Ljava/util/ArrayList;

    return-object v0
.end method

.method public isDisplayContext()Ljava/lang/String;
    .locals 1

    .prologue
    .line 92
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/search/Facets;->displayContext:Ljava/lang/String;

    return-object v0
.end method

.method public isDisplayDepFacet()Ljava/lang/String;
    .locals 1

    .prologue
    .line 99
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/search/Facets;->displayDepFacet:Ljava/lang/String;

    return-object v0
.end method

.method public isDisplayFacetRemoveLink()Z
    .locals 1

    .prologue
    .line 57
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/search/Facets;->displayFacetRemoveLink:Z

    return v0
.end method

.method public isDisplayMobileFacet()Z
    .locals 1

    .prologue
    .line 64
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/search/Facets;->displayMobileFacet:Z

    return v0
.end method

.method public isDisplayMobileFacetRemoveLink()Z
    .locals 1

    .prologue
    .line 71
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/search/Facets;->displayMobileFacetRemoveLink:Z

    return v0
.end method

.method public isDisplayRecurrence()Z
    .locals 1

    .prologue
    .line 50
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/search/Facets;->displayRecurrence:Z

    return v0
.end method

.method public isFacetDisplay()Z
    .locals 1

    .prologue
    .line 197
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/search/Facets;->facetDisplay:Z

    return v0
.end method

.method public setDepFacetField(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 148
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/search/Facets;->depFacetField:Ljava/lang/String;

    .line 149
    return-void
.end method

.method public setDepFacetFieldValue(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 155
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/search/Facets;->depFacetFieldValue:Ljava/lang/String;

    .line 156
    return-void
.end method

.method public setDisplayContext(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 162
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/search/Facets;->displayContext:Ljava/lang/String;

    .line 163
    return-void
.end method

.method public setDisplayDepFacet(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 169
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/search/Facets;->displayDepFacet:Ljava/lang/String;

    .line 170
    return-void
.end method

.method public setDisplayFacetRemoveLink(Z)V
    .locals 0

    .prologue
    .line 127
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/search/Facets;->displayFacetRemoveLink:Z

    .line 128
    return-void
.end method

.method public setDisplayMobileFacet(Z)V
    .locals 0

    .prologue
    .line 134
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/search/Facets;->displayMobileFacet:Z

    .line 135
    return-void
.end method

.method public setDisplayMobileFacetRemoveLink(Z)V
    .locals 0

    .prologue
    .line 141
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/search/Facets;->displayMobileFacetRemoveLink:Z

    .line 142
    return-void
.end method

.method public setDisplayName(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 225
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/search/Facets;->displayName:Ljava/lang/String;

    .line 226
    return-void
.end method

.method public setDisplayRecurrence(Z)V
    .locals 0

    .prologue
    .line 120
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/search/Facets;->displayRecurrence:Z

    .line 121
    return-void
.end method

.method public setFacetDisplay(Z)V
    .locals 0

    .prologue
    .line 239
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/search/Facets;->facetDisplay:Z

    .line 240
    return-void
.end method

.method public setFacetField(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 232
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/search/Facets;->facetField:Ljava/lang/String;

    .line 233
    return-void
.end method

.method public setJoinCondition(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 246
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/search/Facets;->joinCondition:Ljava/lang/String;

    .line 247
    return-void
.end method

.method public setMaxValue(I)V
    .locals 0

    .prologue
    .line 176
    iput p1, p0, Lcom/bestbuy/android/api/lib/models/search/Facets;->maxValue:I

    .line 177
    return-void
.end method

.method public setSystemName(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 113
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/search/Facets;->systemName:Ljava/lang/String;

    .line 114
    return-void
.end method

.method public setUniqueFacetId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 253
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/search/Facets;->uniqueFacetId:Ljava/lang/String;

    .line 254
    return-void
.end method

.method public setValues(Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/search/FacetValues;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 260
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/search/Facets;->values:Ljava/util/ArrayList;

    .line 261
    return-void
.end method
