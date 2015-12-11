.class public Lcom/poshmark/db/DbApi;
.super Ljava/lang/Object;
.source "DbApi.java"


# static fields
.field public static DRESSES_ID:Ljava/lang/String;

.field public static JEANS_ID:Ljava/lang/String;

.field public static OTHER_ID:Ljava/lang/String;

.field public static PANTS_ID:Ljava/lang/String;

.field public static SHOES_ID:Ljava/lang/String;

.field public static SWEATERS_ID:Ljava/lang/String;

.field public static availabilityMetaData:Lcom/poshmark/utils/meta_data/AvailabilityMetaData;

.field public static cannedList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/PriceInfo;",
            ">;"
        }
    .end annotation
.end field

.field public static nwtOptionsMetaData:Lcom/poshmark/utils/meta_data/NWTOptionsMetaData;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 20
    new-instance v1, Lcom/poshmark/utils/meta_data/NWTOptionsMetaData;

    invoke-direct {v1}, Lcom/poshmark/utils/meta_data/NWTOptionsMetaData;-><init>()V

    sput-object v1, Lcom/poshmark/db/DbApi;->nwtOptionsMetaData:Lcom/poshmark/utils/meta_data/NWTOptionsMetaData;

    .line 21
    new-instance v1, Lcom/poshmark/utils/meta_data/AvailabilityMetaData;

    invoke-direct {v1}, Lcom/poshmark/utils/meta_data/AvailabilityMetaData;-><init>()V

    sput-object v1, Lcom/poshmark/db/DbApi;->availabilityMetaData:Lcom/poshmark/utils/meta_data/AvailabilityMetaData;

    .line 22
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    sput-object v1, Lcom/poshmark/db/DbApi;->cannedList:Ljava/util/List;

    .line 32
    new-instance v0, Lcom/poshmark/data_model/models/PriceInfo;

    const-string v1, "25"

    invoke-direct {v0, v3, v1}, Lcom/poshmark/data_model/models/PriceInfo;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 33
    .local v0, "item":Lcom/poshmark/data_model/models/PriceInfo;
    sget-object v1, Lcom/poshmark/db/DbApi;->cannedList:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 35
    new-instance v0, Lcom/poshmark/data_model/models/PriceInfo;

    .end local v0    # "item":Lcom/poshmark/data_model/models/PriceInfo;
    const-string v1, "25"

    const-string v2, "50"

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/PriceInfo;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 36
    .restart local v0    # "item":Lcom/poshmark/data_model/models/PriceInfo;
    sget-object v1, Lcom/poshmark/db/DbApi;->cannedList:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 38
    new-instance v0, Lcom/poshmark/data_model/models/PriceInfo;

    .end local v0    # "item":Lcom/poshmark/data_model/models/PriceInfo;
    const-string v1, "50"

    const-string v2, "100"

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/PriceInfo;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 39
    .restart local v0    # "item":Lcom/poshmark/data_model/models/PriceInfo;
    sget-object v1, Lcom/poshmark/db/DbApi;->cannedList:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 41
    new-instance v0, Lcom/poshmark/data_model/models/PriceInfo;

    .end local v0    # "item":Lcom/poshmark/data_model/models/PriceInfo;
    const-string v1, "100"

    const-string v2, "250"

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/PriceInfo;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 42
    .restart local v0    # "item":Lcom/poshmark/data_model/models/PriceInfo;
    sget-object v1, Lcom/poshmark/db/DbApi;->cannedList:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 44
    new-instance v0, Lcom/poshmark/data_model/models/PriceInfo;

    .end local v0    # "item":Lcom/poshmark/data_model/models/PriceInfo;
    const-string v1, "250"

    const-string v2, "500"

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/PriceInfo;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 45
    .restart local v0    # "item":Lcom/poshmark/data_model/models/PriceInfo;
    sget-object v1, Lcom/poshmark/db/DbApi;->cannedList:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 47
    new-instance v0, Lcom/poshmark/data_model/models/PriceInfo;

    .end local v0    # "item":Lcom/poshmark/data_model/models/PriceInfo;
    const-string v1, "500"

    invoke-direct {v0, v1, v3}, Lcom/poshmark/data_model/models/PriceInfo;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 48
    .restart local v0    # "item":Lcom/poshmark/data_model/models/PriceInfo;
    sget-object v1, Lcom/poshmark/db/DbApi;->cannedList:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 50
    const-string v1, "00108975d97b4e80ef00a955"

    sput-object v1, Lcom/poshmark/db/DbApi;->DRESSES_ID:Ljava/lang/String;

    .line 51
    const-string v1, "00268975d97b4e80ef00a955"

    sput-object v1, Lcom/poshmark/db/DbApi;->SHOES_ID:Ljava/lang/String;

    .line 52
    const-string v1, "001c8975d97b4e80ef00a955"

    sput-object v1, Lcom/poshmark/db/DbApi;->PANTS_ID:Ljava/lang/String;

    .line 53
    const-string v1, "00168975d97b4e80ef00a955"

    sput-object v1, Lcom/poshmark/db/DbApi;->SWEATERS_ID:Ljava/lang/String;

    .line 54
    const-string v1, "001a8975d97b4e80ef00a955"

    sput-object v1, Lcom/poshmark/db/DbApi;->JEANS_ID:Ljava/lang/String;

    .line 55
    const-string v1, "002e8975d97b4e80ef00a955"

    sput-object v1, Lcom/poshmark/db/DbApi;->OTHER_ID:Ljava/lang/String;

    .line 56
    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getAllBrands()Ljava/util/List;
    .locals 1
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
    .line 71
    invoke-static {}, Lcom/poshmark/controllers/GlobalDbController;->getGlobalDbController()Lcom/poshmark/controllers/GlobalDbController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/controllers/GlobalDbController;->getAllBrands()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public static getAllCategories()Ljava/util/List;
    .locals 1
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
    .line 63
    invoke-static {}, Lcom/poshmark/controllers/GlobalDbController;->getGlobalDbController()Lcom/poshmark/controllers/GlobalDbController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/controllers/GlobalDbController;->getAllCategories()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public static getAllColors()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/PMColor;",
            ">;"
        }
    .end annotation

    .prologue
    .line 149
    invoke-static {}, Lcom/poshmark/controllers/GlobalDbController;->getGlobalDbController()Lcom/poshmark/controllers/GlobalDbController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/controllers/GlobalDbController;->getAllColors()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public static getAllConditions()Ljava/util/List;
    .locals 1
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
    .line 67
    sget-object v0, Lcom/poshmark/db/DbApi;->nwtOptionsMetaData:Lcom/poshmark/utils/meta_data/NWTOptionsMetaData;

    invoke-static {}, Lcom/poshmark/utils/meta_data/NWTOptionsMetaData;->getConditionMetaItemsForFilters()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public static getAvailabilityList()Ljava/util/List;
    .locals 1
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
    .line 86
    sget-object v0, Lcom/poshmark/db/DbApi;->availabilityMetaData:Lcom/poshmark/utils/meta_data/AvailabilityMetaData;

    invoke-virtual {v0}, Lcom/poshmark/utils/meta_data/AvailabilityMetaData;->getAvailabilityList()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public static getBrandItemFromLabel(Ljava/lang/String;)Lcom/poshmark/data_model/models/MetaItem;
    .locals 3
    .param p0, "label"    # Ljava/lang/String;

    .prologue
    .line 105
    new-instance v1, Lcom/poshmark/data_model/models/MetaItem;

    invoke-direct {v1}, Lcom/poshmark/data_model/models/MetaItem;-><init>()V

    .line 106
    .local v1, "item":Lcom/poshmark/data_model/models/MetaItem;
    invoke-static {}, Lcom/poshmark/controllers/GlobalDbController;->getGlobalDbController()Lcom/poshmark/controllers/GlobalDbController;

    move-result-object v2

    invoke-virtual {v2, p0}, Lcom/poshmark/controllers/GlobalDbController;->getBrandCanonicalName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 107
    .local v0, "canonicalName":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 108
    invoke-virtual {v1, v0}, Lcom/poshmark/data_model/models/MetaItem;->setDisplay(Ljava/lang/String;)V

    .line 109
    invoke-virtual {v1, v0}, Lcom/poshmark/data_model/models/MetaItem;->setId(Ljava/lang/String;)V

    .line 115
    :goto_0
    return-object v1

    .line 112
    :cond_0
    invoke-virtual {v1, p0}, Lcom/poshmark/data_model/models/MetaItem;->setDisplay(Ljava/lang/String;)V

    .line 113
    invoke-virtual {v1, p0}, Lcom/poshmark/data_model/models/MetaItem;->setId(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static getBrandsForAllCategories()Ljava/util/List;
    .locals 1
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
    .line 100
    invoke-static {}, Lcom/poshmark/controllers/GlobalDbController;->getGlobalDbController()Lcom/poshmark/controllers/GlobalDbController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/controllers/GlobalDbController;->getAllBrands()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public static getBrandsForCategory(Ljava/lang/String;)Ljava/util/List;
    .locals 1
    .param p0, "category"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 142
    invoke-static {}, Lcom/poshmark/db/DbApi;->getBrandsForAllCategories()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public static getCannedPriceRanges()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/PriceInfo;",
            ">;"
        }
    .end annotation

    .prologue
    .line 59
    sget-object v0, Lcom/poshmark/db/DbApi;->cannedList:Ljava/util/List;

    return-object v0
.end method

.method public static getCurrentCategoryFromId(Ljava/lang/String;)Lcom/poshmark/data_model/models/MetaItem;
    .locals 1
    .param p0, "id"    # Ljava/lang/String;

    .prologue
    .line 119
    invoke-static {}, Lcom/poshmark/controllers/GlobalDbController;->getGlobalDbController()Lcom/poshmark/controllers/GlobalDbController;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/poshmark/controllers/GlobalDbController;->getCategoryFromId(Ljava/lang/String;)Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v0

    return-object v0
.end method

.method public static getCurrentCategoryFromLabel(Ljava/lang/String;)Lcom/poshmark/data_model/models/MetaItem;
    .locals 1
    .param p0, "categoryName"    # Ljava/lang/String;

    .prologue
    .line 122
    invoke-static {}, Lcom/poshmark/controllers/GlobalDbController;->getGlobalDbController()Lcom/poshmark/controllers/GlobalDbController;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/poshmark/controllers/GlobalDbController;->getCategoryFromLabel(Ljava/lang/String;)Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v0

    return-object v0
.end method

.method public static getDressSizes()Ljava/util/List;
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
    .line 96
    invoke-static {}, Lcom/poshmark/controllers/GlobalDbController;->getGlobalDbController()Lcom/poshmark/controllers/GlobalDbController;

    move-result-object v0

    sget-object v1, Lcom/poshmark/db/DbApi;->DRESSES_ID:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/poshmark/controllers/GlobalDbController;->getAllSizesForCategory(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public static getNFSListingOptions()Ljava/util/List;
    .locals 5
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
    .line 79
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 80
    .local v0, "availabilityOptions":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    new-instance v1, Lcom/poshmark/data_model/models/MetaItem;

    const-string v2, "available"

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v3

    const v4, 0x7f060135

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Lcom/poshmark/data_model/models/MetaItem;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 81
    new-instance v1, Lcom/poshmark/data_model/models/MetaItem;

    const-string v2, "not_for_sale"

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v3

    const v4, 0x7f0601d4

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Lcom/poshmark/data_model/models/MetaItem;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 82
    return-object v0
.end method

.method public static getNWTFilterOptions()Ljava/util/List;
    .locals 1
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
    .line 75
    sget-object v0, Lcom/poshmark/db/DbApi;->nwtOptionsMetaData:Lcom/poshmark/utils/meta_data/NWTOptionsMetaData;

    invoke-static {}, Lcom/poshmark/utils/meta_data/NWTOptionsMetaData;->getConditionMetaItemsForFilters()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public static getShoeSizes()Ljava/util/List;
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
    .line 92
    invoke-static {}, Lcom/poshmark/controllers/GlobalDbController;->getGlobalDbController()Lcom/poshmark/controllers/GlobalDbController;

    move-result-object v0

    sget-object v1, Lcom/poshmark/db/DbApi;->SHOES_ID:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/poshmark/controllers/GlobalDbController;->getAllSizesForCategory(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public static getSizeForCategoryFromLabel(Ljava/lang/String;Ljava/lang/String;)Lcom/poshmark/data_model/models/MetaItem;
    .locals 1
    .param p0, "categoryId"    # Ljava/lang/String;
    .param p1, "sizeLabel"    # Ljava/lang/String;

    .prologue
    .line 153
    invoke-static {}, Lcom/poshmark/controllers/GlobalDbController;->getGlobalDbController()Lcom/poshmark/controllers/GlobalDbController;

    move-result-object v0

    invoke-virtual {v0, p0, p1}, Lcom/poshmark/controllers/GlobalDbController;->getSizeForCategoryFromLabel(Ljava/lang/String;Ljava/lang/String;)Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v0

    return-object v0
.end method

.method public static getSizesForCategory(Ljava/lang/String;)Ljava/util/List;
    .locals 1
    .param p0, "categoryId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 126
    invoke-static {}, Lcom/poshmark/controllers/GlobalDbController;->getGlobalDbController()Lcom/poshmark/controllers/GlobalDbController;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/poshmark/controllers/GlobalDbController;->getAllSizesForCategory(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public static getSubCategoriesForCategory(Ljava/lang/String;)Ljava/util/List;
    .locals 1
    .param p0, "categoryId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 130
    invoke-static {}, Lcom/poshmark/controllers/GlobalDbController;->getGlobalDbController()Lcom/poshmark/controllers/GlobalDbController;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/poshmark/controllers/GlobalDbController;->getAllSubCategoriesForCategory(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public static getSubCategoryFromId(Ljava/lang/String;)Lcom/poshmark/data_model/models/MetaItem;
    .locals 1
    .param p0, "id"    # Ljava/lang/String;

    .prologue
    .line 134
    invoke-static {}, Lcom/poshmark/controllers/GlobalDbController;->getGlobalDbController()Lcom/poshmark/controllers/GlobalDbController;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/poshmark/controllers/GlobalDbController;->getSubCategoryFromId(Ljava/lang/String;)Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v0

    return-object v0
.end method

.method public static getSubCategoryFromLabel(Ljava/lang/String;)Lcom/poshmark/data_model/models/MetaItem;
    .locals 1
    .param p0, "label"    # Ljava/lang/String;

    .prologue
    .line 138
    invoke-static {}, Lcom/poshmark/controllers/GlobalDbController;->getGlobalDbController()Lcom/poshmark/controllers/GlobalDbController;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/poshmark/controllers/GlobalDbController;->getSubCategoryFromLabel(Ljava/lang/String;)Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v0

    return-object v0
.end method
