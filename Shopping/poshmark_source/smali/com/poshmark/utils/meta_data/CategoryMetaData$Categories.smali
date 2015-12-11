.class Lcom/poshmark/utils/meta_data/CategoryMetaData$Categories;
.super Ljava/lang/Object;
.source "CategoryMetaData.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/utils/meta_data/CategoryMetaData;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "Categories"
.end annotation


# instance fields
.field categories:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation
.end field

.field itemMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation
.end field

.field final synthetic this$0:Lcom/poshmark/utils/meta_data/CategoryMetaData;


# direct methods
.method constructor <init>(Lcom/poshmark/utils/meta_data/CategoryMetaData;)V
    .locals 1

    .prologue
    .line 48
    iput-object p1, p0, Lcom/poshmark/utils/meta_data/CategoryMetaData$Categories;->this$0:Lcom/poshmark/utils/meta_data/CategoryMetaData;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 49
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/meta_data/CategoryMetaData$Categories;->categories:Ljava/util/List;

    .line 50
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/meta_data/CategoryMetaData$Categories;->itemMap:Ljava/util/Map;

    return-void
.end method


# virtual methods
.method public getAllCategories()Ljava/util/List;
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
    .line 119
    iget-object v0, p0, Lcom/poshmark/utils/meta_data/CategoryMetaData$Categories;->categories:Ljava/util/List;

    return-object v0
.end method

.method getMatchingItem(Ljava/lang/String;)Lcom/poshmark/data_model/models/MetaItem;
    .locals 1
    .param p1, "label"    # Ljava/lang/String;

    .prologue
    .line 115
    iget-object v0, p0, Lcom/poshmark/utils/meta_data/CategoryMetaData$Categories;->itemMap:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/MetaItem;

    return-object v0
.end method

.method public loadCategories()V
    .locals 3

    .prologue
    .line 53
    iget-object v1, p0, Lcom/poshmark/utils/meta_data/CategoryMetaData$Categories;->categories:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->clear()V

    .line 56
    new-instance v0, Lcom/poshmark/data_model/models/MetaItem;

    const-string v1, "Accessories"

    const-string v2, "Accessories"

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/MetaItem;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 57
    .local v0, "item":Lcom/poshmark/data_model/models/MetaItem;
    iget-object v1, p0, Lcom/poshmark/utils/meta_data/CategoryMetaData$Categories;->categories:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 58
    iget-object v1, p0, Lcom/poshmark/utils/meta_data/CategoryMetaData$Categories;->itemMap:Ljava/util/Map;

    const-string v2, "Accessories"

    invoke-interface {v1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 60
    new-instance v0, Lcom/poshmark/data_model/models/MetaItem;

    .end local v0    # "item":Lcom/poshmark/data_model/models/MetaItem;
    const-string v1, "Boots"

    const-string v2, "Boots"

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/MetaItem;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 61
    .restart local v0    # "item":Lcom/poshmark/data_model/models/MetaItem;
    iget-object v1, p0, Lcom/poshmark/utils/meta_data/CategoryMetaData$Categories;->categories:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 62
    iget-object v1, p0, Lcom/poshmark/utils/meta_data/CategoryMetaData$Categories;->itemMap:Ljava/util/Map;

    const-string v2, "Boots"

    invoke-interface {v1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 64
    new-instance v0, Lcom/poshmark/data_model/models/MetaItem;

    .end local v0    # "item":Lcom/poshmark/data_model/models/MetaItem;
    const-string v1, "Clutches & Wallets"

    const-string v2, "Clutches & Wallets"

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/MetaItem;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 65
    .restart local v0    # "item":Lcom/poshmark/data_model/models/MetaItem;
    iget-object v1, p0, Lcom/poshmark/utils/meta_data/CategoryMetaData$Categories;->categories:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 66
    iget-object v1, p0, Lcom/poshmark/utils/meta_data/CategoryMetaData$Categories;->itemMap:Ljava/util/Map;

    const-string v2, "Clutches & Wallets"

    invoke-interface {v1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 68
    new-instance v0, Lcom/poshmark/data_model/models/MetaItem;

    .end local v0    # "item":Lcom/poshmark/data_model/models/MetaItem;
    const-string v1, "Denim"

    const-string v2, "Denim"

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/MetaItem;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 69
    .restart local v0    # "item":Lcom/poshmark/data_model/models/MetaItem;
    iget-object v1, p0, Lcom/poshmark/utils/meta_data/CategoryMetaData$Categories;->categories:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 70
    iget-object v1, p0, Lcom/poshmark/utils/meta_data/CategoryMetaData$Categories;->itemMap:Ljava/util/Map;

    const-string v2, "Denim"

    invoke-interface {v1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 72
    new-instance v0, Lcom/poshmark/data_model/models/MetaItem;

    .end local v0    # "item":Lcom/poshmark/data_model/models/MetaItem;
    const-string v1, "Dresses & Skirts"

    const-string v2, "Dresses & Skirts"

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/MetaItem;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 73
    .restart local v0    # "item":Lcom/poshmark/data_model/models/MetaItem;
    iget-object v1, p0, Lcom/poshmark/utils/meta_data/CategoryMetaData$Categories;->categories:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 74
    iget-object v1, p0, Lcom/poshmark/utils/meta_data/CategoryMetaData$Categories;->itemMap:Ljava/util/Map;

    const-string v2, "Dresses & Skirts"

    invoke-interface {v1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 76
    new-instance v0, Lcom/poshmark/data_model/models/MetaItem;

    .end local v0    # "item":Lcom/poshmark/data_model/models/MetaItem;
    const-string v1, "Handbags"

    const-string v2, "Handbags"

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/MetaItem;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 77
    .restart local v0    # "item":Lcom/poshmark/data_model/models/MetaItem;
    iget-object v1, p0, Lcom/poshmark/utils/meta_data/CategoryMetaData$Categories;->categories:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 78
    iget-object v1, p0, Lcom/poshmark/utils/meta_data/CategoryMetaData$Categories;->itemMap:Ljava/util/Map;

    const-string v2, "Handbags"

    invoke-interface {v1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 80
    new-instance v0, Lcom/poshmark/data_model/models/MetaItem;

    .end local v0    # "item":Lcom/poshmark/data_model/models/MetaItem;
    const-string v1, "Jackets & Blazers"

    const-string v2, "Jackets & Blazers"

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/MetaItem;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 81
    .restart local v0    # "item":Lcom/poshmark/data_model/models/MetaItem;
    iget-object v1, p0, Lcom/poshmark/utils/meta_data/CategoryMetaData$Categories;->categories:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 82
    iget-object v1, p0, Lcom/poshmark/utils/meta_data/CategoryMetaData$Categories;->itemMap:Ljava/util/Map;

    const-string v2, "Jackets & Blazers"

    invoke-interface {v1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 84
    new-instance v0, Lcom/poshmark/data_model/models/MetaItem;

    .end local v0    # "item":Lcom/poshmark/data_model/models/MetaItem;
    const-string v1, "Jewelry"

    const-string v2, "Jewelry"

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/MetaItem;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 85
    .restart local v0    # "item":Lcom/poshmark/data_model/models/MetaItem;
    iget-object v1, p0, Lcom/poshmark/utils/meta_data/CategoryMetaData$Categories;->categories:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 86
    iget-object v1, p0, Lcom/poshmark/utils/meta_data/CategoryMetaData$Categories;->itemMap:Ljava/util/Map;

    const-string v2, "Jewelry"

    invoke-interface {v1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 88
    new-instance v0, Lcom/poshmark/data_model/models/MetaItem;

    .end local v0    # "item":Lcom/poshmark/data_model/models/MetaItem;
    const-string v1, "Outerwear"

    const-string v2, "Outerwear"

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/MetaItem;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 89
    .restart local v0    # "item":Lcom/poshmark/data_model/models/MetaItem;
    iget-object v1, p0, Lcom/poshmark/utils/meta_data/CategoryMetaData$Categories;->categories:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 90
    iget-object v1, p0, Lcom/poshmark/utils/meta_data/CategoryMetaData$Categories;->itemMap:Ljava/util/Map;

    const-string v2, "Outerwear"

    invoke-interface {v1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 92
    new-instance v0, Lcom/poshmark/data_model/models/MetaItem;

    .end local v0    # "item":Lcom/poshmark/data_model/models/MetaItem;
    const-string v1, "Pants"

    const-string v2, "Pants"

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/MetaItem;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 93
    .restart local v0    # "item":Lcom/poshmark/data_model/models/MetaItem;
    iget-object v1, p0, Lcom/poshmark/utils/meta_data/CategoryMetaData$Categories;->categories:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 94
    iget-object v1, p0, Lcom/poshmark/utils/meta_data/CategoryMetaData$Categories;->itemMap:Ljava/util/Map;

    const-string v2, "Pants"

    invoke-interface {v1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 96
    new-instance v0, Lcom/poshmark/data_model/models/MetaItem;

    .end local v0    # "item":Lcom/poshmark/data_model/models/MetaItem;
    const-string v1, "Shoes"

    const-string v2, "Shoes"

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/MetaItem;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 97
    .restart local v0    # "item":Lcom/poshmark/data_model/models/MetaItem;
    iget-object v1, p0, Lcom/poshmark/utils/meta_data/CategoryMetaData$Categories;->categories:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 98
    iget-object v1, p0, Lcom/poshmark/utils/meta_data/CategoryMetaData$Categories;->itemMap:Ljava/util/Map;

    const-string v2, "Shoes"

    invoke-interface {v1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 100
    new-instance v0, Lcom/poshmark/data_model/models/MetaItem;

    .end local v0    # "item":Lcom/poshmark/data_model/models/MetaItem;
    const-string v1, "Sweaters"

    const-string v2, "Sweaters"

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/MetaItem;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 101
    .restart local v0    # "item":Lcom/poshmark/data_model/models/MetaItem;
    iget-object v1, p0, Lcom/poshmark/utils/meta_data/CategoryMetaData$Categories;->categories:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 102
    iget-object v1, p0, Lcom/poshmark/utils/meta_data/CategoryMetaData$Categories;->itemMap:Ljava/util/Map;

    const-string v2, "Sweaters"

    invoke-interface {v1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 104
    new-instance v0, Lcom/poshmark/data_model/models/MetaItem;

    .end local v0    # "item":Lcom/poshmark/data_model/models/MetaItem;
    const-string v1, "Tops"

    const-string v2, "Tops"

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/MetaItem;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 105
    .restart local v0    # "item":Lcom/poshmark/data_model/models/MetaItem;
    iget-object v1, p0, Lcom/poshmark/utils/meta_data/CategoryMetaData$Categories;->categories:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 106
    iget-object v1, p0, Lcom/poshmark/utils/meta_data/CategoryMetaData$Categories;->itemMap:Ljava/util/Map;

    const-string v2, "Tops"

    invoke-interface {v1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 108
    new-instance v0, Lcom/poshmark/data_model/models/MetaItem;

    .end local v0    # "item":Lcom/poshmark/data_model/models/MetaItem;
    const-string v1, "Other"

    const-string v2, "Other"

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/MetaItem;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 109
    .restart local v0    # "item":Lcom/poshmark/data_model/models/MetaItem;
    iget-object v1, p0, Lcom/poshmark/utils/meta_data/CategoryMetaData$Categories;->categories:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 110
    iget-object v1, p0, Lcom/poshmark/utils/meta_data/CategoryMetaData$Categories;->itemMap:Ljava/util/Map;

    const-string v2, "Other"

    invoke-interface {v1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 112
    return-void
.end method
