.class public Lcom/poshmark/data_model/models/Facets;
.super Ljava/lang/Object;
.source "Facets.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/data_model/models/Facets$FacetItem;,
        Lcom/poshmark/data_model/models/Facets$Facet;
    }
.end annotation


# instance fields
.field availability:Lcom/poshmark/data_model/models/Facets$Facet;

.field brand:Lcom/poshmark/data_model/models/Facets$Facet;

.field category_feature:Lcom/poshmark/data_model/models/Facets$Facet;

.field category_v2:Lcom/poshmark/data_model/models/Facets$Facet;

.field color:Lcom/poshmark/data_model/models/Facets$Facet;

.field condition:Lcom/poshmark/data_model/models/Facets$Facet;

.field size:Lcom/poshmark/data_model/models/Facets$Facet;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 8
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 81
    return-void
.end method


# virtual methods
.method public getAvailabilityFacets()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/Facets$FacetItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 50
    iget-object v0, p0, Lcom/poshmark/data_model/models/Facets;->availability:Lcom/poshmark/data_model/models/Facets$Facet;

    if-eqz v0, :cond_0

    .line 51
    iget-object v0, p0, Lcom/poshmark/data_model/models/Facets;->availability:Lcom/poshmark/data_model/models/Facets$Facet;

    iget-object v0, v0, Lcom/poshmark/data_model/models/Facets$Facet;->terms:Ljava/util/List;

    .line 53
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getBrandFacets()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/Facets$FacetItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 26
    iget-object v0, p0, Lcom/poshmark/data_model/models/Facets;->brand:Lcom/poshmark/data_model/models/Facets$Facet;

    if-eqz v0, :cond_0

    .line 27
    iget-object v0, p0, Lcom/poshmark/data_model/models/Facets;->brand:Lcom/poshmark/data_model/models/Facets$Facet;

    iget-object v0, v0, Lcom/poshmark/data_model/models/Facets$Facet;->terms:Ljava/util/List;

    .line 29
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getCategoryFacets()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/Facets$FacetItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 18
    iget-object v0, p0, Lcom/poshmark/data_model/models/Facets;->category_v2:Lcom/poshmark/data_model/models/Facets$Facet;

    if-eqz v0, :cond_0

    .line 19
    iget-object v0, p0, Lcom/poshmark/data_model/models/Facets;->category_v2:Lcom/poshmark/data_model/models/Facets$Facet;

    iget-object v0, v0, Lcom/poshmark/data_model/models/Facets$Facet;->terms:Ljava/util/List;

    .line 21
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getColorFacets()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/Facets$FacetItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 34
    iget-object v0, p0, Lcom/poshmark/data_model/models/Facets;->color:Lcom/poshmark/data_model/models/Facets$Facet;

    if-eqz v0, :cond_0

    .line 35
    iget-object v0, p0, Lcom/poshmark/data_model/models/Facets;->color:Lcom/poshmark/data_model/models/Facets$Facet;

    iget-object v0, v0, Lcom/poshmark/data_model/models/Facets$Facet;->terms:Ljava/util/List;

    .line 37
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getConditionFacets()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/Facets$FacetItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 42
    iget-object v0, p0, Lcom/poshmark/data_model/models/Facets;->condition:Lcom/poshmark/data_model/models/Facets$Facet;

    if-eqz v0, :cond_0

    .line 43
    iget-object v0, p0, Lcom/poshmark/data_model/models/Facets;->condition:Lcom/poshmark/data_model/models/Facets$Facet;

    iget-object v0, v0, Lcom/poshmark/data_model/models/Facets$Facet;->terms:Ljava/util/List;

    .line 45
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getSizeFacets()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/Facets$FacetItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 58
    iget-object v0, p0, Lcom/poshmark/data_model/models/Facets;->size:Lcom/poshmark/data_model/models/Facets$Facet;

    if-eqz v0, :cond_0

    .line 59
    iget-object v0, p0, Lcom/poshmark/data_model/models/Facets;->size:Lcom/poshmark/data_model/models/Facets$Facet;

    iget-object v0, v0, Lcom/poshmark/data_model/models/Facets$Facet;->terms:Ljava/util/List;

    .line 61
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getStyleTagsFacets()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/Facets$FacetItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 66
    iget-object v0, p0, Lcom/poshmark/data_model/models/Facets;->category_feature:Lcom/poshmark/data_model/models/Facets$Facet;

    if-eqz v0, :cond_0

    .line 67
    iget-object v0, p0, Lcom/poshmark/data_model/models/Facets;->category_feature:Lcom/poshmark/data_model/models/Facets$Facet;

    iget-object v0, v0, Lcom/poshmark/data_model/models/Facets$Facet;->terms:Ljava/util/List;

    .line 69
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
