.class public Lcom/poshmark/utils/SearchFilterModel;
.super Ljava/lang/Object;
.source "SearchFilterModel.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/utils/SearchFilterModel$PriceRange;,
        Lcom/poshmark/utils/SearchFilterModel$SearchFilters;,
        Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;
    }
.end annotation


# instance fields
.field collection:Ljava/lang/String;

.field count:Ljava/lang/String;

.field facets:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

.field max_id:Ljava/lang/String;

.field query:Ljava/lang/String;

.field query_and_facet_filters:Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;

.field transient searchTrigger:Ljava/lang/String;

.field sort_by:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 29
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 22
    new-instance v0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    invoke-direct {v0, p0}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;-><init>(Lcom/poshmark/utils/SearchFilterModel;)V

    iput-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    .line 23
    new-instance v0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;

    invoke-direct {v0, p0}, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;-><init>(Lcom/poshmark/utils/SearchFilterModel;)V

    iput-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->query_and_facet_filters:Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;

    .line 24
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->facets:Ljava/util/List;

    .line 26
    new-instance v0, Ljava/lang/String;

    const-string v1, ""

    invoke-direct {v0, v1}, Ljava/lang/String;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->searchTrigger:Ljava/lang/String;

    .line 30
    return-void
.end method

.method public constructor <init>(Lcom/poshmark/utils/SearchFilterModel;)V
    .locals 3
    .param p1, "model"    # Lcom/poshmark/utils/SearchFilterModel;

    .prologue
    .line 32
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 22
    new-instance v0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    invoke-direct {v0, p0}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;-><init>(Lcom/poshmark/utils/SearchFilterModel;)V

    iput-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    .line 23
    new-instance v0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;

    invoke-direct {v0, p0}, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;-><init>(Lcom/poshmark/utils/SearchFilterModel;)V

    iput-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->query_and_facet_filters:Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;

    .line 24
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->facets:Ljava/util/List;

    .line 26
    new-instance v0, Ljava/lang/String;

    const-string v1, ""

    invoke-direct {v0, v1}, Ljava/lang/String;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->searchTrigger:Ljava/lang/String;

    .line 33
    iget-object v0, p1, Lcom/poshmark/utils/SearchFilterModel;->collection:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 34
    new-instance v0, Ljava/lang/String;

    iget-object v1, p1, Lcom/poshmark/utils/SearchFilterModel;->collection:Ljava/lang/String;

    invoke-direct {v0, v1}, Ljava/lang/String;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->collection:Ljava/lang/String;

    .line 36
    :cond_0
    iget-object v0, p1, Lcom/poshmark/utils/SearchFilterModel;->count:Ljava/lang/String;

    if-eqz v0, :cond_1

    .line 37
    new-instance v0, Ljava/lang/String;

    iget-object v1, p1, Lcom/poshmark/utils/SearchFilterModel;->count:Ljava/lang/String;

    invoke-direct {v0, v1}, Ljava/lang/String;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->count:Ljava/lang/String;

    .line 39
    :cond_1
    iget-object v0, p1, Lcom/poshmark/utils/SearchFilterModel;->query:Ljava/lang/String;

    if-eqz v0, :cond_2

    .line 40
    new-instance v0, Ljava/lang/String;

    iget-object v1, p1, Lcom/poshmark/utils/SearchFilterModel;->query:Ljava/lang/String;

    invoke-direct {v0, v1}, Ljava/lang/String;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->query:Ljava/lang/String;

    .line 43
    :cond_2
    iget-object v0, p1, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    iget-object v0, v0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->category_v2:Ljava/util/List;

    if-eqz v0, :cond_3

    .line 44
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    new-instance v1, Ljava/util/ArrayList;

    iget-object v2, p1, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    iget-object v2, v2, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->category_v2:Ljava/util/List;

    invoke-direct {v1, v2}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v1, v0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->category_v2:Ljava/util/List;

    .line 46
    :cond_3
    iget-object v0, p1, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    iget-object v0, v0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->brand:Ljava/util/List;

    if-eqz v0, :cond_4

    .line 47
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    new-instance v1, Ljava/util/ArrayList;

    iget-object v2, p1, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    iget-object v2, v2, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->brand:Ljava/util/List;

    invoke-direct {v1, v2}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v1, v0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->brand:Ljava/util/List;

    .line 49
    :cond_4
    iget-object v0, p1, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    iget-object v0, v0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->condition:Ljava/util/List;

    if-eqz v0, :cond_5

    .line 50
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    new-instance v1, Ljava/util/ArrayList;

    iget-object v2, p1, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    iget-object v2, v2, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->condition:Ljava/util/List;

    invoke-direct {v1, v2}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v1, v0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->condition:Ljava/util/List;

    .line 52
    :cond_5
    iget-object v0, p1, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    iget-object v0, v0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->inventory_status:Ljava/util/List;

    if-eqz v0, :cond_6

    .line 53
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    new-instance v1, Ljava/util/ArrayList;

    iget-object v2, p1, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    iget-object v2, v2, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->inventory_status:Ljava/util/List;

    invoke-direct {v1, v2}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v1, v0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->inventory_status:Ljava/util/List;

    .line 55
    :cond_6
    iget-object v0, p1, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    iget-object v0, v0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->price_range:Ljava/util/List;

    if-eqz v0, :cond_7

    .line 56
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    new-instance v1, Ljava/util/ArrayList;

    iget-object v2, p1, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    iget-object v2, v2, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->price_range:Ljava/util/List;

    invoke-direct {v1, v2}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v1, v0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->price_range:Ljava/util/List;

    .line 58
    :cond_7
    iget-object v0, p1, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    iget-object v0, v0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->color:Ljava/util/List;

    if-eqz v0, :cond_8

    .line 59
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    new-instance v1, Ljava/util/ArrayList;

    iget-object v2, p1, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    iget-object v2, v2, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->color:Ljava/util/List;

    invoke-direct {v1, v2}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v1, v0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->color:Ljava/util/List;

    .line 61
    :cond_8
    iget-object v0, p1, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    iget-object v0, v0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->category_feature:Ljava/util/List;

    if-eqz v0, :cond_9

    .line 62
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    new-instance v1, Ljava/util/ArrayList;

    iget-object v2, p1, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    iget-object v2, v2, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->category_feature:Ljava/util/List;

    invoke-direct {v1, v2}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v1, v0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->category_feature:Ljava/util/List;

    .line 64
    :cond_9
    iget-object v0, p1, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    iget-object v0, v0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->size:Lcom/poshmark/data_model/models/SizeFilter;

    if-eqz v0, :cond_a

    .line 65
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    new-instance v1, Lcom/poshmark/data_model/models/SizeFilter;

    iget-object v2, p1, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    iget-object v2, v2, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->size:Lcom/poshmark/data_model/models/SizeFilter;

    invoke-direct {v1, v2}, Lcom/poshmark/data_model/models/SizeFilter;-><init>(Lcom/poshmark/data_model/models/SizeFilter;)V

    iput-object v1, v0, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->size:Lcom/poshmark/data_model/models/SizeFilter;

    .line 67
    :cond_a
    iget-object v0, p1, Lcom/poshmark/utils/SearchFilterModel;->query_and_facet_filters:Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;

    iget-object v0, v0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->brand:Ljava/util/List;

    if-eqz v0, :cond_b

    .line 68
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->query_and_facet_filters:Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;

    new-instance v1, Ljava/util/ArrayList;

    iget-object v2, p1, Lcom/poshmark/utils/SearchFilterModel;->query_and_facet_filters:Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;

    iget-object v2, v2, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->brand:Ljava/util/List;

    invoke-direct {v1, v2}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v1, v0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->brand:Ljava/util/List;

    .line 70
    :cond_b
    iget-object v0, p1, Lcom/poshmark/utils/SearchFilterModel;->query_and_facet_filters:Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;

    iget-object v0, v0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->category_v2:Ljava/util/List;

    if-eqz v0, :cond_c

    .line 71
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->query_and_facet_filters:Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;

    new-instance v1, Ljava/util/ArrayList;

    iget-object v2, p1, Lcom/poshmark/utils/SearchFilterModel;->query_and_facet_filters:Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;

    iget-object v2, v2, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->category_v2:Ljava/util/List;

    invoke-direct {v1, v2}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v1, v0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->category_v2:Ljava/util/List;

    .line 73
    :cond_c
    iget-object v0, p1, Lcom/poshmark/utils/SearchFilterModel;->query_and_facet_filters:Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;

    iget-object v0, v0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->category_feature:Ljava/util/List;

    if-eqz v0, :cond_d

    .line 74
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->query_and_facet_filters:Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;

    new-instance v1, Ljava/util/ArrayList;

    iget-object v2, p1, Lcom/poshmark/utils/SearchFilterModel;->query_and_facet_filters:Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;

    iget-object v2, v2, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->category_feature:Ljava/util/List;

    invoke-direct {v1, v2}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v1, v0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->category_feature:Ljava/util/List;

    .line 76
    :cond_d
    iget-object v0, p1, Lcom/poshmark/utils/SearchFilterModel;->query_and_facet_filters:Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;

    iget-object v0, v0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->color:Ljava/util/List;

    if-eqz v0, :cond_e

    .line 77
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->query_and_facet_filters:Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;

    new-instance v1, Ljava/util/ArrayList;

    iget-object v2, p1, Lcom/poshmark/utils/SearchFilterModel;->query_and_facet_filters:Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;

    iget-object v2, v2, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->color:Ljava/util/List;

    invoke-direct {v1, v2}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v1, v0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->color:Ljava/util/List;

    .line 79
    :cond_e
    iget-object v0, p1, Lcom/poshmark/utils/SearchFilterModel;->query_and_facet_filters:Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;

    iget-object v0, v0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->condition:Ljava/util/List;

    if-eqz v0, :cond_f

    .line 80
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->query_and_facet_filters:Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;

    new-instance v1, Ljava/util/ArrayList;

    iget-object v2, p1, Lcom/poshmark/utils/SearchFilterModel;->query_and_facet_filters:Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;

    iget-object v2, v2, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->condition:Ljava/util/List;

    invoke-direct {v1, v2}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v1, v0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->condition:Ljava/util/List;

    .line 82
    :cond_f
    iget-object v0, p1, Lcom/poshmark/utils/SearchFilterModel;->query_and_facet_filters:Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;

    iget-object v0, v0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->availability:Ljava/util/List;

    if-eqz v0, :cond_10

    .line 83
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->query_and_facet_filters:Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;

    new-instance v1, Ljava/util/ArrayList;

    iget-object v2, p1, Lcom/poshmark/utils/SearchFilterModel;->query_and_facet_filters:Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;

    iget-object v2, v2, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->availability:Ljava/util/List;

    invoke-direct {v1, v2}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v1, v0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->availability:Ljava/util/List;

    .line 85
    :cond_10
    iget-object v0, p1, Lcom/poshmark/utils/SearchFilterModel;->query_and_facet_filters:Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;

    iget-object v0, v0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->event:Ljava/util/List;

    if-eqz v0, :cond_11

    .line 86
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->query_and_facet_filters:Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;

    new-instance v1, Ljava/util/ArrayList;

    iget-object v2, p1, Lcom/poshmark/utils/SearchFilterModel;->query_and_facet_filters:Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;

    iget-object v2, v2, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->event:Ljava/util/List;

    invoke-direct {v1, v2}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v1, v0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->event:Ljava/util/List;

    .line 88
    :cond_11
    iget-object v0, p1, Lcom/poshmark/utils/SearchFilterModel;->query_and_facet_filters:Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;

    iget-object v0, v0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->creator_id:Ljava/util/List;

    if-eqz v0, :cond_12

    .line 89
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->query_and_facet_filters:Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;

    new-instance v1, Ljava/util/ArrayList;

    iget-object v2, p1, Lcom/poshmark/utils/SearchFilterModel;->query_and_facet_filters:Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;

    iget-object v2, v2, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->creator_id:Ljava/util/List;

    invoke-direct {v1, v2}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v1, v0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->creator_id:Ljava/util/List;

    .line 92
    :cond_12
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->facets:Ljava/util/List;

    if-eqz v0, :cond_13

    .line 93
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->facets:Ljava/util/List;

    iget-object v1, p1, Lcom/poshmark/utils/SearchFilterModel;->facets:Ljava/util/List;

    invoke-interface {v0, v1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 96
    :cond_13
    iget-object v0, p1, Lcom/poshmark/utils/SearchFilterModel;->max_id:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->max_id:Ljava/lang/String;

    .line 97
    iget-object v0, p1, Lcom/poshmark/utils/SearchFilterModel;->searchTrigger:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->searchTrigger:Ljava/lang/String;

    .line 98
    iget-object v0, p1, Lcom/poshmark/utils/SearchFilterModel;->sort_by:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->sort_by:Ljava/lang/String;

    .line 99
    return-void
.end method


# virtual methods
.method public addColor(Ljava/lang/String;)V
    .locals 2
    .param p1, "color"    # Ljava/lang/String;

    .prologue
    .line 263
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->searchTrigger:Ljava/lang/String;

    const-string v1, "clr"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 264
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->query_and_facet_filters:Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;

    invoke-virtual {v0, p1}, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->setColor(Ljava/lang/String;)V

    .line 269
    :goto_0
    return-void

    .line 266
    :cond_0
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->clearColorList()V

    .line 267
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    invoke-virtual {v0, p1}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->addColor(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public adjustCategorySubCategory()V
    .locals 3

    .prologue
    .line 203
    iget-object v1, p0, Lcom/poshmark/utils/SearchFilterModel;->searchTrigger:Ljava/lang/String;

    const-string v2, "ct"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 204
    iget-object v1, p0, Lcom/poshmark/utils/SearchFilterModel;->query_and_facet_filters:Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;

    invoke-virtual {v1}, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->getSubCategoryList()Ljava/util/List;

    move-result-object v0

    .line 205
    .local v0, "subCats":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    if-eqz v0, :cond_0

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_0

    .line 207
    iget-object v1, p0, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    iget-object v2, p0, Lcom/poshmark/utils/SearchFilterModel;->query_and_facet_filters:Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;

    invoke-virtual {v2}, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->getCategory()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->addCategory(Ljava/lang/String;)V

    .line 208
    iget-object v1, p0, Lcom/poshmark/utils/SearchFilterModel;->query_and_facet_filters:Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;

    invoke-virtual {v1}, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->clearCategoryList()V

    .line 212
    .end local v0    # "subCats":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :cond_0
    return-void
.end method

.method public clearAllFacets()V
    .locals 1

    .prologue
    .line 443
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->facets:Ljava/util/List;

    if-eqz v0, :cond_0

    .line 444
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->facets:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 446
    :cond_0
    return-void
.end method

.method public clearAvailability()V
    .locals 1

    .prologue
    .line 318
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->clearAvailabilityList()V

    .line 319
    return-void
.end method

.method public clearBrand()V
    .locals 2

    .prologue
    .line 138
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->searchTrigger:Ljava/lang/String;

    const-string v1, "br"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->searchTrigger:Ljava/lang/String;

    const-string v1, "brj"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->searchTrigger:Ljava/lang/String;

    const-string v1, "brpd"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 139
    :cond_0
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->query_and_facet_filters:Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;

    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->clearBrandList()V

    .line 143
    :goto_0
    return-void

    .line 141
    :cond_1
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->clearBrandList()V

    goto :goto_0
.end method

.method public clearCategory()V
    .locals 2

    .prologue
    .line 177
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->searchTrigger:Ljava/lang/String;

    const-string v1, "ct"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 178
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->query_and_facet_filters:Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;

    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->clearCategoryList()V

    .line 182
    :goto_0
    return-void

    .line 180
    :cond_0
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->clearCategoryList()V

    goto :goto_0
.end method

.method public clearColors()V
    .locals 2

    .prologue
    .line 457
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->searchTrigger:Ljava/lang/String;

    const-string v1, "clr"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 458
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->query_and_facet_filters:Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;

    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->clearColorList()V

    .line 462
    :goto_0
    return-void

    .line 460
    :cond_0
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->clearColorList()V

    goto :goto_0
.end method

.method public clearCondition()V
    .locals 1

    .prologue
    .line 284
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->clearConditionList()V

    .line 285
    return-void
.end method

.method public clearCount()V
    .locals 1

    .prologue
    .line 118
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->count:Ljava/lang/String;

    .line 119
    return-void
.end method

.method public clearNextPageId()V
    .locals 1

    .prologue
    .line 110
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->max_id:Ljava/lang/String;

    .line 111
    return-void
.end method

.method public clearPrices()V
    .locals 1

    .prologue
    .line 335
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->clearPriceRangeList()V

    .line 336
    return-void
.end method

.method public clearSizes()V
    .locals 1

    .prologue
    .line 331
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->clearSizeList()V

    .line 332
    return-void
.end method

.method public clearSortBy()V
    .locals 1

    .prologue
    .line 280
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->sort_by:Ljava/lang/String;

    .line 281
    return-void
.end method

.method public clearSubCategories()V
    .locals 2

    .prologue
    .line 339
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->searchTrigger:Ljava/lang/String;

    const-string v1, "ct"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 340
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->query_and_facet_filters:Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;

    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->clearSubCategoryList()V

    .line 344
    :goto_0
    return-void

    .line 342
    :cond_0
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->clearSubCategoryList()V

    goto :goto_0
.end method

.method public enableMySizeFilter(Z)V
    .locals 1
    .param p1, "enable"    # Z

    .prologue
    .line 410
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    invoke-virtual {v0, p1}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->enableMySize(Z)V

    .line 411
    return-void
.end method

.method public enableUnsoldOption(Z)V
    .locals 1
    .param p1, "enable"    # Z

    .prologue
    .line 414
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    invoke-virtual {v0, p1}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->enableUnsoldOption(Z)V

    .line 415
    return-void
.end method

.method public getAvailability()Ljava/lang/String;
    .locals 1

    .prologue
    .line 322
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->getInventory_status()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getAvailabilityAsMetaItem()Lcom/poshmark/data_model/models/MetaItem;
    .locals 3

    .prologue
    .line 302
    new-instance v1, Lcom/poshmark/utils/meta_data/AvailabilityMetaData;

    invoke-direct {v1}, Lcom/poshmark/utils/meta_data/AvailabilityMetaData;-><init>()V

    .line 303
    .local v1, "availabilityOptionsMetaData":Lcom/poshmark/utils/meta_data/AvailabilityMetaData;
    iget-object v2, p0, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    invoke-virtual {v2}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->getInventory_status()Ljava/lang/String;

    move-result-object v0

    .line 305
    .local v0, "availString":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 306
    invoke-static {v0}, Lcom/poshmark/utils/meta_data/AvailabilityMetaData;->getAvailabilityMetaItemFromLabel(Ljava/lang/String;)Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v2

    .line 308
    :goto_0
    return-object v2

    :cond_0
    sget-object v2, Lcom/poshmark/utils/meta_data/AvailabilityMetaData$AVAILABILITY_TYPE;->ALL:Lcom/poshmark/utils/meta_data/AvailabilityMetaData$AVAILABILITY_TYPE;

    invoke-virtual {v1, v2}, Lcom/poshmark/utils/meta_data/AvailabilityMetaData;->getAvailabilityMetaItem(Lcom/poshmark/utils/meta_data/AvailabilityMetaData$AVAILABILITY_TYPE;)Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v2

    goto :goto_0
.end method

.method public getBrand()Ljava/lang/String;
    .locals 2

    .prologue
    .line 146
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->searchTrigger:Ljava/lang/String;

    const-string v1, "br"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->searchTrigger:Ljava/lang/String;

    const-string v1, "brj"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->searchTrigger:Ljava/lang/String;

    const-string v1, "brpd"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 147
    :cond_0
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->query_and_facet_filters:Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;

    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->getBrand()Ljava/lang/String;

    move-result-object v0

    .line 149
    :goto_0
    return-object v0

    :cond_1
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->getBrand()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public getCategory()Ljava/lang/String;
    .locals 2

    .prologue
    .line 185
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->searchTrigger:Ljava/lang/String;

    const-string v1, "ct"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 186
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->query_and_facet_filters:Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;

    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->getCategory()Ljava/lang/String;

    move-result-object v0

    .line 188
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->getCategory_v2()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public getCollectionString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 126
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->collection:Ljava/lang/String;

    return-object v0
.end method

.method public getColorList()Ljava/util/List;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 449
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->searchTrigger:Ljava/lang/String;

    const-string v1, "clr"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 450
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->query_and_facet_filters:Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;

    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->getColors()Ljava/util/List;

    move-result-object v0

    .line 452
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->getColorList()Ljava/util/List;

    move-result-object v0

    goto :goto_0
.end method

.method public getCommaSeparatedSizes()Ljava/lang/String;
    .locals 2

    .prologue
    .line 347
    iget-object v1, p0, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    if-eqz v1, :cond_0

    .line 348
    iget-object v1, p0, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    invoke-virtual {v1}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->getSizeList()Ljava/util/List;

    move-result-object v0

    .line 349
    .local v0, "sizes":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    if-eqz v0, :cond_0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    if-lez v1, :cond_0

    .line 350
    const-string v1, ","

    invoke-static {v0, v1}, Lcom/poshmark/utils/StringUtils;->join(Ljava/util/List;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 353
    .end local v0    # "sizes":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :goto_0
    return-object v1

    :cond_0
    const-string v1, ""

    goto :goto_0
.end method

.method public getCommaSeparatedTags()Ljava/lang/String;
    .locals 2

    .prologue
    .line 357
    iget-object v1, p0, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    if-eqz v1, :cond_0

    .line 358
    iget-object v1, p0, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    invoke-virtual {v1}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->getSubCategoryList()Ljava/util/List;

    move-result-object v0

    .line 359
    .local v0, "tags":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    if-eqz v0, :cond_0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    if-lez v1, :cond_0

    .line 360
    const-string v1, ","

    invoke-static {v0, v1}, Lcom/poshmark/utils/StringUtils;->join(Ljava/util/List;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 363
    .end local v0    # "tags":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :goto_0
    return-object v1

    :cond_0
    const-string v1, ""

    goto :goto_0
.end method

.method public getCondition()Ljava/lang/String;
    .locals 1

    .prologue
    .line 288
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->getCondition()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getConditionAsMetaItem()Lcom/poshmark/data_model/models/MetaItem;
    .locals 3

    .prologue
    .line 292
    new-instance v1, Lcom/poshmark/utils/meta_data/NWTOptionsMetaData;

    invoke-direct {v1}, Lcom/poshmark/utils/meta_data/NWTOptionsMetaData;-><init>()V

    .line 293
    .local v1, "nwtOptionsMetaData":Lcom/poshmark/utils/meta_data/NWTOptionsMetaData;
    iget-object v2, p0, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    invoke-virtual {v2}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->getCondition()Ljava/lang/String;

    move-result-object v0

    .line 294
    .local v0, "condition":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 295
    invoke-static {v0}, Lcom/poshmark/utils/meta_data/NWTOptionsMetaData;->getConditionMetaItemForFilters(Ljava/lang/String;)Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v2

    .line 297
    :goto_0
    return-object v2

    :cond_0
    invoke-virtual {v1}, Lcom/poshmark/utils/meta_data/NWTOptionsMetaData;->getAllConditionMetaItemForFilters()Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v2

    goto :goto_0
.end method

.method public getFilters()Lcom/poshmark/utils/SearchFilterModel$SearchFilters;
    .locals 1

    .prologue
    .line 367
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    return-object v0
.end method

.method public getLabelForAnalytics()Ljava/lang/String;
    .locals 4

    .prologue
    .line 375
    const-string v0, ""

    .line 376
    .local v0, "label":Ljava/lang/String;
    iget-object v1, p0, Lcom/poshmark/utils/SearchFilterModel;->query:Ljava/lang/String;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/SearchFilterModel;->query:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-lez v1, :cond_0

    .line 377
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/utils/SearchFilterModel;->query:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 379
    :cond_0
    iget-object v1, p0, Lcom/poshmark/utils/SearchFilterModel;->collection:Ljava/lang/String;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/poshmark/utils/SearchFilterModel;->collection:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-lez v1, :cond_1

    .line 380
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/utils/SearchFilterModel;->collection:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 382
    :cond_1
    iget-object v1, p0, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    invoke-virtual {v1}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->getCategoryList()Ljava/util/List;

    move-result-object v1

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    invoke-virtual {v1}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->getCategoryList()Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-lez v1, :cond_2

    .line 383
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "category_v2/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v1, p0, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    invoke-virtual {v1}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->getCategoryList()Ljava/util/List;

    move-result-object v1

    const/4 v3, 0x0

    invoke-interface {v1, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 386
    :cond_2
    iget-object v1, p0, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    invoke-virtual {v1}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->getSizeList()Ljava/util/List;

    move-result-object v1

    if-eqz v1, :cond_3

    iget-object v1, p0, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    invoke-virtual {v1}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->getSizeList()Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-lez v1, :cond_3

    .line 387
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "size/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    invoke-virtual {v2}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->getSizeList()Ljava/util/List;

    move-result-object v2

    const-string v3, ","

    invoke-static {v2, v3}, Lcom/poshmark/utils/StringUtils;->join(Ljava/util/List;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 390
    :cond_3
    iget-object v1, p0, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    invoke-virtual {v1}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->getBrandList()Ljava/util/List;

    move-result-object v1

    if-eqz v1, :cond_4

    iget-object v1, p0, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    invoke-virtual {v1}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->getBrandList()Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-lez v1, :cond_4

    .line 391
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "brand/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    invoke-virtual {v2}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->getBrandList()Ljava/util/List;

    move-result-object v2

    const-string v3, ","

    invoke-static {v2, v3}, Lcom/poshmark/utils/StringUtils;->join(Ljava/util/List;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 394
    :cond_4
    iget-object v1, p0, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    invoke-virtual {v1}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->getPriceRangeDisplayList()Ljava/util/List;

    move-result-object v1

    if-eqz v1, :cond_5

    iget-object v1, p0, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    invoke-virtual {v1}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->getPriceRangeDisplayList()Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-lez v1, :cond_5

    .line 395
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "price/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    invoke-virtual {v2}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->getPriceRangeDisplayList()Ljava/util/List;

    move-result-object v2

    const-string v3, ","

    invoke-static {v2, v3}, Lcom/poshmark/utils/StringUtils;->join(Ljava/util/List;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 398
    :cond_5
    iget-object v1, p0, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    invoke-virtual {v1}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->getConditionList()Ljava/util/List;

    move-result-object v1

    if-eqz v1, :cond_6

    iget-object v1, p0, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    invoke-virtual {v1}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->getConditionList()Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-lez v1, :cond_6

    .line 399
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "condition/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    invoke-virtual {v2}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->getConditionList()Ljava/util/List;

    move-result-object v2

    const-string v3, ","

    invoke-static {v2, v3}, Lcom/poshmark/utils/StringUtils;->join(Ljava/util/List;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 402
    :cond_6
    iget-object v1, p0, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    invoke-virtual {v1}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->getAvailabilityList()Ljava/util/List;

    move-result-object v1

    if-eqz v1, :cond_7

    iget-object v1, p0, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    invoke-virtual {v1}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->getAvailabilityList()Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-lez v1, :cond_7

    .line 403
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "inventory_status/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    invoke-virtual {v2}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->getAvailabilityList()Ljava/util/List;

    move-result-object v2

    const-string v3, ","

    invoke-static {v2, v3}, Lcom/poshmark/utils/StringUtils;->join(Ljava/util/List;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 406
    :cond_7
    return-object v0
.end method

.method public getPrimaryFilters()Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;
    .locals 1

    .prologue
    .line 371
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->query_and_facet_filters:Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;

    return-object v0
.end method

.method public getQueryText()Ljava/lang/String;
    .locals 1

    .prologue
    .line 134
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->query:Ljava/lang/String;

    return-object v0
.end method

.method public getSearchTrigger()Ljava/lang/String;
    .locals 1

    .prologue
    .line 422
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->searchTrigger:Ljava/lang/String;

    return-object v0
.end method

.method public getSortBy()Ljava/lang/String;
    .locals 1

    .prologue
    .line 272
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->sort_by:Ljava/lang/String;

    return-object v0
.end method

.method public getSubCategories()Ljava/util/List;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 255
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->searchTrigger:Ljava/lang/String;

    const-string v1, "ct"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 256
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->query_and_facet_filters:Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;

    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->getSubCategoryList()Ljava/util/List;

    move-result-object v0

    .line 258
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->getSubCategoryList()Ljava/util/List;

    move-result-object v0

    goto :goto_0
.end method

.method public getSubCategory()Ljava/lang/String;
    .locals 2

    .prologue
    .line 233
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->searchTrigger:Ljava/lang/String;

    const-string v1, "ct"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 234
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->query_and_facet_filters:Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;

    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->getSubCategory()Ljava/lang/String;

    move-result-object v0

    .line 236
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->getCategoryFeature()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public setAvailability(Ljava/lang/String;)V
    .locals 1
    .param p1, "newAvailability"    # Ljava/lang/String;

    .prologue
    .line 326
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    invoke-virtual {v0, p1}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->addAvailability(Ljava/lang/String;)V

    .line 327
    return-void
.end method

.method public setBrand(Ljava/lang/String;)V
    .locals 2
    .param p1, "newBrand"    # Ljava/lang/String;

    .prologue
    .line 154
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->searchTrigger:Ljava/lang/String;

    const-string v1, "br"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->searchTrigger:Ljava/lang/String;

    const-string v1, "brj"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->searchTrigger:Ljava/lang/String;

    const-string v1, "brpd"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 155
    :cond_0
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->query_and_facet_filters:Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;

    invoke-virtual {v0, p1}, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->addBrand(Ljava/lang/String;)V

    .line 160
    :goto_0
    return-void

    .line 157
    :cond_1
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    invoke-virtual {v0, p1}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->addBrand(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public setBrand(Ljava/util/List;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 163
    .local p1, "newBrands":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    if-eqz p1, :cond_2

    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v2

    if-lez v2, :cond_2

    .line 164
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 165
    .local v1, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 166
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 167
    .local v0, "brandName":Ljava/lang/String;
    iget-object v2, p0, Lcom/poshmark/utils/SearchFilterModel;->searchTrigger:Ljava/lang/String;

    const-string v3, "br"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    iget-object v2, p0, Lcom/poshmark/utils/SearchFilterModel;->searchTrigger:Ljava/lang/String;

    const-string v3, "brj"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    iget-object v2, p0, Lcom/poshmark/utils/SearchFilterModel;->searchTrigger:Ljava/lang/String;

    const-string v3, "brpd"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 168
    :cond_0
    iget-object v2, p0, Lcom/poshmark/utils/SearchFilterModel;->query_and_facet_filters:Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;

    invoke-virtual {v2, v0}, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->addBrand(Ljava/lang/String;)V

    goto :goto_0

    .line 170
    :cond_1
    iget-object v2, p0, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    invoke-virtual {v2, v0}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->addBrand(Ljava/lang/String;)V

    goto :goto_0

    .line 174
    .end local v0    # "brandName":Ljava/lang/String;
    .end local v1    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :cond_2
    return-void
.end method

.method public setCategory(Ljava/lang/String;)V
    .locals 2
    .param p1, "newCategory"    # Ljava/lang/String;

    .prologue
    .line 215
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->searchTrigger:Ljava/lang/String;

    const-string v1, "ct"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 216
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->query_and_facet_filters:Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;

    invoke-virtual {v0, p1}, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->addCategory(Ljava/lang/String;)V

    .line 220
    :goto_0
    return-void

    .line 218
    :cond_0
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    invoke-virtual {v0, p1}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->addCategory(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public setCategory(Ljava/util/List;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 223
    .local p1, "newCategories":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    if-eqz p1, :cond_0

    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v2

    if-lez v2, :cond_0

    .line 224
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 225
    .local v0, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 226
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 227
    .local v1, "newCategory":Ljava/lang/String;
    invoke-virtual {p0, v1}, Lcom/poshmark/utils/SearchFilterModel;->setCategory(Ljava/lang/String;)V

    goto :goto_0

    .line 230
    .end local v0    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    .end local v1    # "newCategory":Ljava/lang/String;
    :cond_0
    return-void
.end method

.method public setCollectionString(Ljava/lang/String;)V
    .locals 0
    .param p1, "collectionString"    # Ljava/lang/String;

    .prologue
    .line 122
    iput-object p1, p0, Lcom/poshmark/utils/SearchFilterModel;->collection:Ljava/lang/String;

    .line 123
    return-void
.end method

.method public setCondition(Ljava/lang/String;)V
    .locals 1
    .param p1, "newCondition"    # Ljava/lang/String;

    .prologue
    .line 313
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    invoke-virtual {v0, p1}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->addCondition(Ljava/lang/String;)V

    .line 314
    return-void
.end method

.method public setCount(Ljava/lang/String;)V
    .locals 0
    .param p1, "count"    # Ljava/lang/String;

    .prologue
    .line 114
    iput-object p1, p0, Lcom/poshmark/utils/SearchFilterModel;->count:Ljava/lang/String;

    .line 115
    return-void
.end method

.method public setFacet(Ljava/lang/String;)V
    .locals 1
    .param p1, "facet"    # Ljava/lang/String;

    .prologue
    .line 426
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->facets:Ljava/util/List;

    if-nez v0, :cond_0

    .line 427
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->facets:Ljava/util/List;

    .line 429
    :cond_0
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->facets:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 430
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->facets:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 432
    :cond_1
    return-void
.end method

.method public setNextPageId(Ljava/lang/String;)V
    .locals 1
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 102
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->max_id:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 103
    new-instance v0, Ljava/lang/String;

    invoke-direct {v0, p1}, Ljava/lang/String;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->max_id:Ljava/lang/String;

    .line 107
    :goto_0
    return-void

    .line 105
    :cond_0
    iput-object p1, p0, Lcom/poshmark/utils/SearchFilterModel;->max_id:Ljava/lang/String;

    goto :goto_0
.end method

.method public setQueryText(Ljava/lang/String;)V
    .locals 0
    .param p1, "queryText"    # Ljava/lang/String;

    .prologue
    .line 130
    iput-object p1, p0, Lcom/poshmark/utils/SearchFilterModel;->query:Ljava/lang/String;

    .line 131
    return-void
.end method

.method public setSearchTrigger(Ljava/lang/String;)V
    .locals 0
    .param p1, "trigger"    # Ljava/lang/String;

    .prologue
    .line 418
    iput-object p1, p0, Lcom/poshmark/utils/SearchFilterModel;->searchTrigger:Ljava/lang/String;

    .line 419
    return-void
.end method

.method public setSingleFacet(Ljava/lang/String;)V
    .locals 1
    .param p1, "facet"    # Ljava/lang/String;

    .prologue
    .line 435
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->facets:Ljava/util/List;

    if-nez v0, :cond_0

    .line 436
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->facets:Ljava/util/List;

    .line 438
    :cond_0
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->facets:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 439
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->facets:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 440
    return-void
.end method

.method public setSortBy(Ljava/lang/String;)V
    .locals 0
    .param p1, "sort"    # Ljava/lang/String;

    .prologue
    .line 276
    iput-object p1, p0, Lcom/poshmark/utils/SearchFilterModel;->sort_by:Ljava/lang/String;

    .line 277
    return-void
.end method

.method public setSubCategories(Ljava/util/List;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 241
    .local p1, "subCategories":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    if-eqz p1, :cond_1

    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v2

    if-lez v2, :cond_1

    .line 242
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 243
    .local v0, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/MetaItem;>;"
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 244
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/data_model/models/MetaItem;

    .line 245
    .local v1, "subCat":Lcom/poshmark/data_model/models/MetaItem;
    iget-object v2, p0, Lcom/poshmark/utils/SearchFilterModel;->searchTrigger:Ljava/lang/String;

    const-string v3, "ct"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 246
    iget-object v2, p0, Lcom/poshmark/utils/SearchFilterModel;->query_and_facet_filters:Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->addSubCategory(Ljava/lang/String;)V

    goto :goto_0

    .line 248
    :cond_0
    iget-object v2, p0, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->addSubCategory(Ljava/lang/String;)V

    goto :goto_0

    .line 252
    .end local v0    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/MetaItem;>;"
    .end local v1    # "subCat":Lcom/poshmark/data_model/models/MetaItem;
    :cond_1
    return-void
.end method

.method public setSubCategoryList(Ljava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 466
    .local p1, "subCategoryList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel;->filters:Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    invoke-virtual {v0, p1}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->setSubCategories(Ljava/util/List;)V

    .line 467
    return-void
.end method
