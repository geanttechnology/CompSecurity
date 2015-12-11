.class public Lcom/poshmark/utils/meta_data/ListingMetaDataController;
.super Ljava/lang/Object;
.source "ListingMetaDataController.java"


# instance fields
.field private currentAvailability:Lcom/poshmark/data_model/models/MetaItem;

.field private currentBrand:Lcom/poshmark/data_model/models/MetaItem;

.field private currentCategory:Lcom/poshmark/data_model/models/MetaItem;

.field private currentNWTOption:Lcom/poshmark/data_model/models/MetaItem;

.field private currentSize:Lcom/poshmark/data_model/models/MetaItem;

.field private currentSubCategories:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 22
    return-void
.end method


# virtual methods
.method public getCurrentAvailability()Lcom/poshmark/data_model/models/MetaItem;
    .locals 1

    .prologue
    .line 94
    iget-object v0, p0, Lcom/poshmark/utils/meta_data/ListingMetaDataController;->currentAvailability:Lcom/poshmark/data_model/models/MetaItem;

    return-object v0
.end method

.method public getCurrentBrand()Lcom/poshmark/data_model/models/MetaItem;
    .locals 1

    .prologue
    .line 86
    iget-object v0, p0, Lcom/poshmark/utils/meta_data/ListingMetaDataController;->currentBrand:Lcom/poshmark/data_model/models/MetaItem;

    return-object v0
.end method

.method public getCurrentCategory()Lcom/poshmark/data_model/models/MetaItem;
    .locals 1

    .prologue
    .line 78
    iget-object v0, p0, Lcom/poshmark/utils/meta_data/ListingMetaDataController;->currentCategory:Lcom/poshmark/data_model/models/MetaItem;

    return-object v0
.end method

.method public getCurrentNWTOption()Lcom/poshmark/data_model/models/MetaItem;
    .locals 1

    .prologue
    .line 90
    iget-object v0, p0, Lcom/poshmark/utils/meta_data/ListingMetaDataController;->currentNWTOption:Lcom/poshmark/data_model/models/MetaItem;

    return-object v0
.end method

.method public getCurrentSize()Lcom/poshmark/data_model/models/MetaItem;
    .locals 1

    .prologue
    .line 82
    iget-object v0, p0, Lcom/poshmark/utils/meta_data/ListingMetaDataController;->currentSize:Lcom/poshmark/data_model/models/MetaItem;

    return-object v0
.end method

.method public getSizeListForCurrentCategory()Ljava/util/List;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 99
    iget-object v0, p0, Lcom/poshmark/utils/meta_data/ListingMetaDataController;->currentCategory:Lcom/poshmark/data_model/models/MetaItem;

    if-eqz v0, :cond_0

    .line 100
    invoke-static {}, Lcom/poshmark/controllers/GlobalDbController;->getGlobalDbController()Lcom/poshmark/controllers/GlobalDbController;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/utils/meta_data/ListingMetaDataController;->currentCategory:Lcom/poshmark/data_model/models/MetaItem;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/controllers/GlobalDbController;->getAllSizesForCategory(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 102
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public setCurrentAvailability(Lcom/poshmark/data_model/models/MetaItem;)V
    .locals 0
    .param p1, "availability"    # Lcom/poshmark/data_model/models/MetaItem;

    .prologue
    .line 74
    iput-object p1, p0, Lcom/poshmark/utils/meta_data/ListingMetaDataController;->currentAvailability:Lcom/poshmark/data_model/models/MetaItem;

    .line 75
    return-void
.end method

.method public setCurrentAvailabilityOption(Ljava/lang/String;)V
    .locals 1
    .param p1, "label"    # Ljava/lang/String;

    .prologue
    .line 58
    sget-object v0, Lcom/poshmark/db/DbApi;->availabilityMetaData:Lcom/poshmark/utils/meta_data/AvailabilityMetaData;

    invoke-virtual {v0, p1}, Lcom/poshmark/utils/meta_data/AvailabilityMetaData;->getAvailabilityItem(Ljava/lang/String;)Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/utils/meta_data/ListingMetaDataController;->currentAvailability:Lcom/poshmark/data_model/models/MetaItem;

    .line 59
    return-void
.end method

.method public setCurrentBrand(Lcom/poshmark/data_model/models/MetaItem;)V
    .locals 0
    .param p1, "brand"    # Lcom/poshmark/data_model/models/MetaItem;

    .prologue
    .line 66
    iput-object p1, p0, Lcom/poshmark/utils/meta_data/ListingMetaDataController;->currentBrand:Lcom/poshmark/data_model/models/MetaItem;

    .line 67
    return-void
.end method

.method public setCurrentBrand(Ljava/lang/String;)V
    .locals 2
    .param p1, "label"    # Ljava/lang/String;

    .prologue
    .line 35
    invoke-static {}, Lcom/poshmark/controllers/GlobalDbController;->getGlobalDbController()Lcom/poshmark/controllers/GlobalDbController;

    move-result-object v1

    invoke-virtual {v1, p1}, Lcom/poshmark/controllers/GlobalDbController;->getBrandCanonicalName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 36
    .local v0, "canonicalName":Ljava/lang/String;
    if-eqz v0, :cond_1

    .line 37
    iget-object v1, p0, Lcom/poshmark/utils/meta_data/ListingMetaDataController;->currentBrand:Lcom/poshmark/data_model/models/MetaItem;

    if-nez v1, :cond_0

    .line 38
    new-instance v1, Lcom/poshmark/data_model/models/MetaItem;

    invoke-direct {v1}, Lcom/poshmark/data_model/models/MetaItem;-><init>()V

    iput-object v1, p0, Lcom/poshmark/utils/meta_data/ListingMetaDataController;->currentBrand:Lcom/poshmark/data_model/models/MetaItem;

    .line 40
    :cond_0
    iget-object v1, p0, Lcom/poshmark/utils/meta_data/ListingMetaDataController;->currentBrand:Lcom/poshmark/data_model/models/MetaItem;

    invoke-virtual {v1, v0}, Lcom/poshmark/data_model/models/MetaItem;->setDisplay(Ljava/lang/String;)V

    .line 41
    iget-object v1, p0, Lcom/poshmark/utils/meta_data/ListingMetaDataController;->currentBrand:Lcom/poshmark/data_model/models/MetaItem;

    invoke-virtual {v1, v0}, Lcom/poshmark/data_model/models/MetaItem;->setId(Ljava/lang/String;)V

    .line 43
    :cond_1
    return-void
.end method

.method public setCurrentCategory(Lcom/poshmark/data_model/models/MetaItem;)V
    .locals 3
    .param p1, "category"    # Lcom/poshmark/data_model/models/MetaItem;

    .prologue
    const/4 v2, 0x0

    .line 50
    iget-object v0, p0, Lcom/poshmark/utils/meta_data/ListingMetaDataController;->currentCategory:Lcom/poshmark/data_model/models/MetaItem;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/utils/meta_data/ListingMetaDataController;->currentCategory:Lcom/poshmark/data_model/models/MetaItem;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 51
    :cond_0
    iput-object p1, p0, Lcom/poshmark/utils/meta_data/ListingMetaDataController;->currentCategory:Lcom/poshmark/data_model/models/MetaItem;

    .line 52
    iput-object v2, p0, Lcom/poshmark/utils/meta_data/ListingMetaDataController;->currentSize:Lcom/poshmark/data_model/models/MetaItem;

    .line 53
    iput-object v2, p0, Lcom/poshmark/utils/meta_data/ListingMetaDataController;->currentNWTOption:Lcom/poshmark/data_model/models/MetaItem;

    .line 55
    :cond_1
    return-void
.end method

.method public setCurrentCategory(Ljava/lang/String;)V
    .locals 1
    .param p1, "label"    # Ljava/lang/String;

    .prologue
    .line 25
    invoke-static {}, Lcom/poshmark/controllers/GlobalDbController;->getGlobalDbController()Lcom/poshmark/controllers/GlobalDbController;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/poshmark/controllers/GlobalDbController;->getCategoryFromLabel(Ljava/lang/String;)Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/utils/meta_data/ListingMetaDataController;->currentCategory:Lcom/poshmark/data_model/models/MetaItem;

    .line 27
    return-void
.end method

.method public setCurrentNWTOption(Lcom/poshmark/data_model/models/MetaItem;)V
    .locals 0
    .param p1, "currentNWT"    # Lcom/poshmark/data_model/models/MetaItem;

    .prologue
    .line 70
    iput-object p1, p0, Lcom/poshmark/utils/meta_data/ListingMetaDataController;->currentNWTOption:Lcom/poshmark/data_model/models/MetaItem;

    .line 71
    return-void
.end method

.method public setCurrentNWTOption(Ljava/lang/String;)V
    .locals 1
    .param p1, "label"    # Ljava/lang/String;

    .prologue
    .line 46
    sget-object v0, Lcom/poshmark/db/DbApi;->nwtOptionsMetaData:Lcom/poshmark/utils/meta_data/NWTOptionsMetaData;

    invoke-static {p1}, Lcom/poshmark/utils/meta_data/NWTOptionsMetaData;->getConditionMetaItemForFilters(Ljava/lang/String;)Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/utils/meta_data/ListingMetaDataController;->currentNWTOption:Lcom/poshmark/data_model/models/MetaItem;

    .line 47
    return-void
.end method

.method public setCurrentSize(Ljava/lang/String;)Lcom/poshmark/data_model/models/MetaItem;
    .locals 2
    .param p1, "label"    # Ljava/lang/String;

    .prologue
    .line 30
    invoke-static {}, Lcom/poshmark/controllers/GlobalDbController;->getGlobalDbController()Lcom/poshmark/controllers/GlobalDbController;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/utils/meta_data/ListingMetaDataController;->currentCategory:Lcom/poshmark/data_model/models/MetaItem;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1, p1}, Lcom/poshmark/controllers/GlobalDbController;->getSizeForCategoryFromLabel(Ljava/lang/String;Ljava/lang/String;)Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/utils/meta_data/ListingMetaDataController;->currentSize:Lcom/poshmark/data_model/models/MetaItem;

    .line 31
    iget-object v0, p0, Lcom/poshmark/utils/meta_data/ListingMetaDataController;->currentSize:Lcom/poshmark/data_model/models/MetaItem;

    return-object v0
.end method

.method public setCurrentSize(Lcom/poshmark/data_model/models/MetaItem;)V
    .locals 0
    .param p1, "size"    # Lcom/poshmark/data_model/models/MetaItem;

    .prologue
    .line 62
    iput-object p1, p0, Lcom/poshmark/utils/meta_data/ListingMetaDataController;->currentSize:Lcom/poshmark/data_model/models/MetaItem;

    .line 63
    return-void
.end method

.method public setCurrentSubCategories(Ljava/util/List;)V
    .locals 0
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
    .line 107
    .local p1, "newSubCategories":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    iput-object p1, p0, Lcom/poshmark/utils/meta_data/ListingMetaDataController;->currentSubCategories:Ljava/util/List;

    .line 108
    return-void
.end method
