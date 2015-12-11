.class public Lcom/poshmark/utils/ListingsFilterUtils;
.super Ljava/lang/Object;
.source "ListingsFilterUtils.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getScrubbedColorList(Ljava/util/List;Ljava/util/List;)Ljava/util/List;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/PMColor;",
            ">;",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/Facets$FacetItem;",
            ">;)",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/PMColor;",
            ">;"
        }
    .end annotation

    .prologue
    .line 49
    .local p0, "colorList":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/PMColor;>;"
    .local p1, "facetList":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/Facets$FacetItem;>;"
    if-eqz p0, :cond_5

    .line 50
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 51
    .local v4, "scrubbedList":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/PMColor;>;"
    if-eqz p1, :cond_0

    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v5

    if-nez v5, :cond_2

    .line 52
    :cond_0
    invoke-interface {v4, p0}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 73
    .end local v4    # "scrubbedList":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/PMColor;>;"
    :cond_1
    :goto_0
    return-object v4

    .line 55
    .restart local v4    # "scrubbedList":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/PMColor;>;"
    :cond_2
    invoke-interface {p0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .line 56
    .local v2, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/PMColor;>;"
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .line 58
    .local v3, "itrFacet":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/Facets$FacetItem;>;"
    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_1

    .line 59
    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/PMColor;

    .line 60
    .local v0, "colorItem":Lcom/poshmark/data_model/models/PMColor;
    :cond_3
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_4

    .line 61
    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/data_model/models/Facets$FacetItem;

    .line 63
    .local v1, "facetItem":Lcom/poshmark/data_model/models/Facets$FacetItem;
    invoke-virtual {v1}, Lcom/poshmark/data_model/models/Facets$FacetItem;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/PMColor;->getName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_3

    .line 64
    invoke-interface {v4, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 68
    .end local v1    # "facetItem":Lcom/poshmark/data_model/models/Facets$FacetItem;
    :cond_4
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .line 69
    goto :goto_1

    .line 73
    .end local v0    # "colorItem":Lcom/poshmark/data_model/models/PMColor;
    .end local v2    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/PMColor;>;"
    .end local v3    # "itrFacet":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/Facets$FacetItem;>;"
    .end local v4    # "scrubbedList":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/PMColor;>;"
    :cond_5
    const/4 v4, 0x0

    goto :goto_0
.end method

.method public static getScrubbedList(Ljava/util/List;Ljava/util/List;)Ljava/util/List;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/Facets$FacetItem;",
            ">;)",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 19
    .local p0, "metaItemList":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    .local p1, "facetList":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/Facets$FacetItem;>;"
    if-eqz p0, :cond_6

    .line 20
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 21
    .local v4, "scrubbedList":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    if-eqz p1, :cond_0

    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v5

    if-nez v5, :cond_2

    .line 22
    :cond_0
    invoke-interface {v4, p0}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 44
    .end local v4    # "scrubbedList":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    :cond_1
    :goto_0
    return-object v4

    .line 25
    .restart local v4    # "scrubbedList":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    :cond_2
    invoke-interface {p0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 26
    .local v1, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/MetaItem;>;"
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .line 28
    .local v2, "itrFacet":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/Facets$FacetItem;>;"
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_1

    .line 29
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/poshmark/data_model/models/MetaItem;

    .line 30
    .local v3, "metaItem":Lcom/poshmark/data_model/models/MetaItem;
    :cond_3
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_5

    .line 31
    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/Facets$FacetItem;

    .line 33
    .local v0, "facetItem":Lcom/poshmark/data_model/models/Facets$FacetItem;
    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Facets$FacetItem;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_4

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Facets$FacetItem;->getDisplay()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/MetaItem;->getDisplay()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_3

    .line 34
    :cond_4
    invoke-interface {v4, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 35
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .line 39
    .end local v0    # "facetItem":Lcom/poshmark/data_model/models/Facets$FacetItem;
    :cond_5
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .line 40
    goto :goto_1

    .line 44
    .end local v1    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/MetaItem;>;"
    .end local v2    # "itrFacet":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/Facets$FacetItem;>;"
    .end local v3    # "metaItem":Lcom/poshmark/data_model/models/MetaItem;
    .end local v4    # "scrubbedList":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    :cond_6
    const/4 v4, 0x0

    goto :goto_0
.end method

.method public static getScrubbedMetaItemList(Ljava/util/List;Ljava/util/List;)Ljava/util/List;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;)",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 78
    .local p0, "metaItemList":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    .local p1, "subList":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 79
    .local v3, "scrubbedList":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    invoke-interface {p0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 80
    .local v0, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/MetaItem;>;"
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 82
    .local v1, "itrSubList":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/MetaItem;>;"
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_3

    .line 83
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/poshmark/data_model/models/MetaItem;

    .line 84
    .local v2, "metaItem":Lcom/poshmark/data_model/models/MetaItem;
    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_2

    .line 85
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/poshmark/data_model/models/MetaItem;

    .line 87
    .local v4, "subListItem":Lcom/poshmark/data_model/models/MetaItem;
    invoke-virtual {v4}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_1

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/MetaItem;->getDisplay()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/MetaItem;->getDisplay()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 88
    :cond_1
    invoke-interface {v3, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 89
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 93
    .end local v4    # "subListItem":Lcom/poshmark/data_model/models/MetaItem;
    :cond_2
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 94
    goto :goto_0

    .line 95
    .end local v2    # "metaItem":Lcom/poshmark/data_model/models/MetaItem;
    :cond_3
    return-object v3
.end method
