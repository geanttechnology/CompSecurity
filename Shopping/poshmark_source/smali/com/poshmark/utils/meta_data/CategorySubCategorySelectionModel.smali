.class public Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;
.super Ljava/lang/Object;
.source "CategorySubCategorySelectionModel.java"


# instance fields
.field public categoryFacetList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation
.end field

.field public currentCategory:Lcom/poshmark/data_model/models/MetaItem;

.field public currentGlobalStyleTagsSelection:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation
.end field

.field public currentSubCategorySelection:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation
.end field

.field public globalStyleTags:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation
.end field

.field public scrubbedSubCategoryList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation
.end field

.field public subCategoryFacetList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/Facets$FacetItem;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 13
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->scrubbedSubCategoryList:Ljava/util/List;

    .line 14
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentSubCategorySelection:Ljava/util/List;

    .line 20
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->globalStyleTags:Ljava/util/List;

    return-void
.end method

.method public static clone(Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;)Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;
    .locals 3
    .param p0, "obj"    # Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    .prologue
    .line 25
    new-instance v0, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    invoke-direct {v0}, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;-><init>()V

    .line 26
    .local v0, "info":Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;
    iget-object v1, v0, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->scrubbedSubCategoryList:Ljava/util/List;

    iget-object v2, p0, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->scrubbedSubCategoryList:Ljava/util/List;

    invoke-interface {v1, v2}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 28
    iget-object v1, p0, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentSubCategorySelection:Ljava/util/List;

    if-eqz v1, :cond_0

    .line 29
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, v0, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentSubCategorySelection:Ljava/util/List;

    .line 30
    iget-object v1, v0, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentSubCategorySelection:Ljava/util/List;

    iget-object v2, p0, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentSubCategorySelection:Ljava/util/List;

    invoke-interface {v1, v2}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 33
    :cond_0
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, v0, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->categoryFacetList:Ljava/util/List;

    .line 34
    iget-object v1, p0, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->categoryFacetList:Ljava/util/List;

    if-eqz v1, :cond_1

    .line 35
    iget-object v1, v0, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->categoryFacetList:Ljava/util/List;

    iget-object v2, p0, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->categoryFacetList:Ljava/util/List;

    invoke-interface {v1, v2}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 38
    :cond_1
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, v0, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->subCategoryFacetList:Ljava/util/List;

    .line 39
    iget-object v1, p0, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->subCategoryFacetList:Ljava/util/List;

    if-eqz v1, :cond_2

    .line 40
    iget-object v1, v0, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->subCategoryFacetList:Ljava/util/List;

    iget-object v2, p0, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->subCategoryFacetList:Ljava/util/List;

    invoke-interface {v1, v2}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 43
    :cond_2
    iget-object v1, p0, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentCategory:Lcom/poshmark/data_model/models/MetaItem;

    iput-object v1, v0, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentCategory:Lcom/poshmark/data_model/models/MetaItem;

    .line 44
    return-object v0
.end method


# virtual methods
.method public removeAllSelections()V
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentSubCategorySelection:Ljava/util/List;

    if-eqz v0, :cond_0

    .line 59
    iget-object v0, p0, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentSubCategorySelection:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 62
    :cond_0
    iget-object v0, p0, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentGlobalStyleTagsSelection:Ljava/util/List;

    if-eqz v0, :cond_1

    .line 63
    iget-object v0, p0, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentGlobalStyleTagsSelection:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 65
    :cond_1
    return-void
.end method

.method public selectionsPresent()Z
    .locals 5

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 48
    iget-object v4, p0, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentSubCategorySelection:Ljava/util/List;

    if-eqz v4, :cond_0

    iget-object v4, p0, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentSubCategorySelection:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v4

    if-nez v4, :cond_2

    :cond_0
    move v0, v3

    .line 49
    .local v0, "cond1":Z
    :goto_0
    iget-object v4, p0, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentGlobalStyleTagsSelection:Ljava/util/List;

    if-eqz v4, :cond_1

    iget-object v4, p0, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentGlobalStyleTagsSelection:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v4

    if-nez v4, :cond_3

    :cond_1
    move v1, v3

    .line 50
    .local v1, "cond2":Z
    :goto_1
    if-eqz v0, :cond_4

    if-eqz v1, :cond_4

    .line 53
    :goto_2
    return v2

    .end local v0    # "cond1":Z
    .end local v1    # "cond2":Z
    :cond_2
    move v0, v2

    .line 48
    goto :goto_0

    .restart local v0    # "cond1":Z
    :cond_3
    move v1, v2

    .line 49
    goto :goto_1

    .restart local v1    # "cond2":Z
    :cond_4
    move v2, v3

    .line 53
    goto :goto_2
.end method
