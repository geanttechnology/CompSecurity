.class public Lcom/poshmark/data_model/models/NewListing;
.super Ljava/lang/Object;
.source "NewListing.java"


# instance fields
.field brand:Ljava/lang/String;

.field category_v2:Lcom/poshmark/data_model/models/MetaItem;

.field colors:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/PMColor;",
            ">;"
        }
    .end annotation
.end field

.field condition:Ljava/lang/String;

.field description:Ljava/lang/String;

.field inventory_status:Ljava/lang/String;

.field listingInfoHash:Ljava/util/HashMap;
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

.field original_price:Ljava/lang/String;

.field price:Ljava/lang/String;

.field size:Ljava/lang/String;

.field subcategories:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation
.end field

.field title:Ljava/lang/String;

.field web_command_info:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    const-string v0, ""

    iput-object v0, p0, Lcom/poshmark/data_model/models/NewListing;->price:Ljava/lang/String;

    .line 21
    const-string v0, ""

    iput-object v0, p0, Lcom/poshmark/data_model/models/NewListing;->size:Ljava/lang/String;

    .line 22
    const-string v0, ""

    iput-object v0, p0, Lcom/poshmark/data_model/models/NewListing;->original_price:Ljava/lang/String;

    .line 23
    const-string v0, ""

    iput-object v0, p0, Lcom/poshmark/data_model/models/NewListing;->description:Ljava/lang/String;

    .line 25
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/data_model/models/NewListing;->subcategories:Ljava/util/List;

    .line 26
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/data_model/models/NewListing;->colors:Ljava/util/List;

    .line 27
    const-string v0, ""

    iput-object v0, p0, Lcom/poshmark/data_model/models/NewListing;->brand:Ljava/lang/String;

    .line 28
    const-string v0, ""

    iput-object v0, p0, Lcom/poshmark/data_model/models/NewListing;->condition:Ljava/lang/String;

    .line 29
    const-string v0, ""

    iput-object v0, p0, Lcom/poshmark/data_model/models/NewListing;->title:Ljava/lang/String;

    .line 30
    const-string v0, ""

    iput-object v0, p0, Lcom/poshmark/data_model/models/NewListing;->inventory_status:Ljava/lang/String;

    .line 31
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/poshmark/data_model/models/NewListing;->listingInfoHash:Ljava/util/HashMap;

    .line 32
    const-string v0, ""

    iput-object v0, p0, Lcom/poshmark/data_model/models/NewListing;->web_command_info:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public clearSubCategories()V
    .locals 1

    .prologue
    .line 67
    iget-object v0, p0, Lcom/poshmark/data_model/models/NewListing;->subcategories:Ljava/util/List;

    if-eqz v0, :cond_0

    .line 68
    iget-object v0, p0, Lcom/poshmark/data_model/models/NewListing;->subcategories:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 70
    :cond_0
    return-void
.end method

.method public getBrand()Ljava/lang/String;
    .locals 1

    .prologue
    .line 242
    iget-object v0, p0, Lcom/poshmark/data_model/models/NewListing;->brand:Ljava/lang/String;

    return-object v0
.end method

.method public getCategory()Lcom/poshmark/data_model/models/MetaItem;
    .locals 1

    .prologue
    .line 221
    iget-object v0, p0, Lcom/poshmark/data_model/models/NewListing;->category_v2:Lcom/poshmark/data_model/models/MetaItem;

    return-object v0
.end method

.method public getColors()Ljava/util/List;
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
    .line 289
    iget-object v0, p0, Lcom/poshmark/data_model/models/NewListing;->colors:Ljava/util/List;

    return-object v0
.end method

.method public getCondition()Ljava/lang/String;
    .locals 1

    .prologue
    .line 246
    iget-object v0, p0, Lcom/poshmark/data_model/models/NewListing;->condition:Ljava/lang/String;

    return-object v0
.end method

.method public getConditionDisplayString(Landroid/content/Context;)Ljava/lang/String;
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 258
    iget-object v0, p0, Lcom/poshmark/data_model/models/NewListing;->condition:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/data_model/models/NewListing;->condition:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_1

    .line 259
    :cond_0
    const-string v0, ""

    .line 266
    :goto_0
    return-object v0

    .line 260
    :cond_1
    iget-object v0, p0, Lcom/poshmark/data_model/models/NewListing;->condition:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v0

    const-string v1, "nwt"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 261
    const v0, 0x7f0602cd

    invoke-virtual {p1, v0}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 262
    :cond_2
    iget-object v0, p0, Lcom/poshmark/data_model/models/NewListing;->condition:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v0

    const-string v1, "ret"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 263
    const v0, 0x7f0602ce

    invoke-virtual {p1, v0}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 266
    :cond_3
    const v0, 0x7f0601ce

    invoke-virtual {p1, v0}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public getDescription()Ljava/lang/String;
    .locals 1

    .prologue
    .line 217
    iget-object v0, p0, Lcom/poshmark/data_model/models/NewListing;->description:Ljava/lang/String;

    return-object v0
.end method

.method public getFirstSubCategory()Lcom/poshmark/data_model/models/MetaItem;
    .locals 2

    .prologue
    .line 226
    iget-object v0, p0, Lcom/poshmark/data_model/models/NewListing;->subcategories:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 227
    iget-object v0, p0, Lcom/poshmark/data_model/models/NewListing;->subcategories:Ljava/util/List;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/MetaItem;

    .line 229
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getInputError()Ljava/lang/String;
    .locals 4

    .prologue
    .line 148
    const-string v0, ""

    .line 149
    .local v0, "errorMessage":Ljava/lang/String;
    iget-object v1, p0, Lcom/poshmark/data_model/models/NewListing;->title:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-nez v1, :cond_0

    .line 150
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v2

    const v3, 0x7f06017d

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 151
    :cond_0
    iget-object v1, p0, Lcom/poshmark/data_model/models/NewListing;->description:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-nez v1, :cond_1

    .line 152
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v2

    const v3, 0x7f060179

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 153
    :cond_1
    iget-object v1, p0, Lcom/poshmark/data_model/models/NewListing;->category_v2:Lcom/poshmark/data_model/models/MetaItem;

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcom/poshmark/data_model/models/NewListing;->category_v2:Lcom/poshmark/data_model/models/MetaItem;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v1

    if-nez v1, :cond_3

    .line 154
    :cond_2
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v2

    const v3, 0x7f060178

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 155
    :cond_3
    iget-object v1, p0, Lcom/poshmark/data_model/models/NewListing;->size:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-nez v1, :cond_4

    .line 156
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v2

    const v3, 0x7f06017c

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 157
    :cond_4
    iget-object v1, p0, Lcom/poshmark/data_model/models/NewListing;->original_price:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-nez v1, :cond_5

    .line 158
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v2

    const v3, 0x7f06017a

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 159
    :cond_5
    iget-object v1, p0, Lcom/poshmark/data_model/models/NewListing;->price:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-nez v1, :cond_6

    .line 160
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v2

    const v3, 0x7f06017b

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 162
    :cond_6
    return-object v0
.end method

.method public getInventoryStatus()Ljava/lang/String;
    .locals 1

    .prologue
    .line 277
    iget-object v0, p0, Lcom/poshmark/data_model/models/NewListing;->inventory_status:Ljava/lang/String;

    return-object v0
.end method

.method public getInventoryStatusDisplayString(Landroid/content/Context;)Ljava/lang/String;
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 270
    iget-object v0, p0, Lcom/poshmark/data_model/models/NewListing;->inventory_status:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/data_model/models/NewListing;->inventory_status:Ljava/lang/String;

    const-string v1, "not_for_sale"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 271
    const v0, 0x7f0601d4

    invoke-virtual {p1, v0}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 273
    :goto_0
    return-object v0

    :cond_0
    const v0, 0x7f060135

    invoke-virtual {p1, v0}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public getListingInfoHash()Ljava/util/Map;
    .locals 11
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 89
    new-instance v0, Lcom/google/gson/GsonBuilder;

    invoke-direct {v0}, Lcom/google/gson/GsonBuilder;-><init>()V

    .line 90
    .local v0, "b":Lcom/google/gson/GsonBuilder;
    invoke-virtual {v0}, Lcom/google/gson/GsonBuilder;->create()Lcom/google/gson/Gson;

    move-result-object v4

    .line 92
    .local v4, "gson":Lcom/google/gson/Gson;
    iget-object v8, p0, Lcom/poshmark/data_model/models/NewListing;->listingInfoHash:Ljava/util/HashMap;

    const-string v9, "title"

    iget-object v10, p0, Lcom/poshmark/data_model/models/NewListing;->title:Ljava/lang/String;

    invoke-virtual {v8, v9, v10}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 93
    iget-object v8, p0, Lcom/poshmark/data_model/models/NewListing;->listingInfoHash:Ljava/util/HashMap;

    const-string v9, "description"

    iget-object v10, p0, Lcom/poshmark/data_model/models/NewListing;->description:Ljava/lang/String;

    invoke-virtual {v8, v9, v10}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 94
    iget-object v8, p0, Lcom/poshmark/data_model/models/NewListing;->listingInfoHash:Ljava/util/HashMap;

    const-string v9, "category_v2"

    iget-object v10, p0, Lcom/poshmark/data_model/models/NewListing;->category_v2:Lcom/poshmark/data_model/models/MetaItem;

    invoke-virtual {v10}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v8, v9, v10}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 98
    new-instance v6, Ljava/util/ArrayList;

    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    .line 99
    .local v6, "subCatIds":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    iget-object v8, p0, Lcom/poshmark/data_model/models/NewListing;->subcategories:Ljava/util/List;

    invoke-interface {v8}, Ljava/util/List;->isEmpty()Z

    move-result v8

    if-nez v8, :cond_0

    .line 100
    iget-object v8, p0, Lcom/poshmark/data_model/models/NewListing;->subcategories:Ljava/util/List;

    const/4 v9, 0x0

    invoke-interface {v8, v9}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lcom/poshmark/data_model/models/MetaItem;

    invoke-virtual {v8}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v6, v8}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 102
    :cond_0
    const-class v9, Ljava/util/List;

    instance-of v8, v4, Lcom/google/gson/Gson;

    if-nez v8, :cond_1

    invoke-virtual {v4, v6, v9}, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v7

    .line 103
    .local v7, "subCategoriesString":Ljava/lang/String;
    :goto_0
    iget-object v8, p0, Lcom/poshmark/data_model/models/NewListing;->listingInfoHash:Ljava/util/HashMap;

    const-string v9, "category_features"

    invoke-virtual {v8, v9, v7}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 105
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 106
    .local v2, "colorNames":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    iget-object v8, p0, Lcom/poshmark/data_model/models/NewListing;->colors:Ljava/util/List;

    invoke-interface {v8}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v5

    .line 107
    .local v5, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/PMColor;>;"
    :goto_1
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_2

    .line 108
    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/data_model/models/PMColor;

    .line 109
    .local v1, "color":Lcom/poshmark/data_model/models/PMColor;
    iget-object v8, v1, Lcom/poshmark/data_model/models/PMColor;->name:Ljava/lang/String;

    invoke-virtual {v2, v8}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .end local v1    # "color":Lcom/poshmark/data_model/models/PMColor;
    .end local v2    # "colorNames":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    .end local v5    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/PMColor;>;"
    .end local v7    # "subCategoriesString":Ljava/lang/String;
    :cond_1
    move-object v8, v4

    .line 102
    check-cast v8, Lcom/google/gson/Gson;

    invoke-static {v8, v6, v9}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->toJson(Lcom/google/gson/Gson;Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v7

    goto :goto_0

    .line 111
    .restart local v2    # "colorNames":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    .restart local v5    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/PMColor;>;"
    .restart local v7    # "subCategoriesString":Ljava/lang/String;
    :cond_2
    const-class v8, Ljava/util/List;

    instance-of v9, v4, Lcom/google/gson/Gson;

    if-nez v9, :cond_3

    invoke-virtual {v4, v2, v8}, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v3

    .line 114
    .end local v4    # "gson":Lcom/google/gson/Gson;
    .local v3, "colorsJson":Ljava/lang/String;
    :goto_2
    iget-object v8, p0, Lcom/poshmark/data_model/models/NewListing;->listingInfoHash:Ljava/util/HashMap;

    const-string v9, "size"

    iget-object v10, p0, Lcom/poshmark/data_model/models/NewListing;->size:Ljava/lang/String;

    invoke-virtual {v8, v9, v10}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 115
    iget-object v8, p0, Lcom/poshmark/data_model/models/NewListing;->listingInfoHash:Ljava/util/HashMap;

    const-string v9, "brand"

    iget-object v10, p0, Lcom/poshmark/data_model/models/NewListing;->brand:Ljava/lang/String;

    invoke-virtual {v8, v9, v10}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 116
    iget-object v8, p0, Lcom/poshmark/data_model/models/NewListing;->listingInfoHash:Ljava/util/HashMap;

    const-string v9, "condition"

    iget-object v10, p0, Lcom/poshmark/data_model/models/NewListing;->condition:Ljava/lang/String;

    invoke-virtual {v8, v9, v10}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 117
    iget-object v8, p0, Lcom/poshmark/data_model/models/NewListing;->listingInfoHash:Ljava/util/HashMap;

    const-string v9, "original_price"

    iget-object v10, p0, Lcom/poshmark/data_model/models/NewListing;->original_price:Ljava/lang/String;

    invoke-virtual {v8, v9, v10}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 118
    iget-object v8, p0, Lcom/poshmark/data_model/models/NewListing;->listingInfoHash:Ljava/util/HashMap;

    const-string v9, "price"

    iget-object v10, p0, Lcom/poshmark/data_model/models/NewListing;->price:Ljava/lang/String;

    invoke-virtual {v8, v9, v10}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 119
    iget-object v8, p0, Lcom/poshmark/data_model/models/NewListing;->listingInfoHash:Ljava/util/HashMap;

    const-string v9, "inventory_status"

    iget-object v10, p0, Lcom/poshmark/data_model/models/NewListing;->inventory_status:Ljava/lang/String;

    invoke-virtual {v8, v9, v10}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 120
    iget-object v8, p0, Lcom/poshmark/data_model/models/NewListing;->listingInfoHash:Ljava/util/HashMap;

    const-string v9, "colors"

    invoke-virtual {v8, v9, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 122
    iget-object v8, p0, Lcom/poshmark/data_model/models/NewListing;->listingInfoHash:Ljava/util/HashMap;

    return-object v8

    .line 111
    .end local v3    # "colorsJson":Ljava/lang/String;
    .restart local v4    # "gson":Lcom/google/gson/Gson;
    :cond_3
    check-cast v4, Lcom/google/gson/Gson;

    .end local v4    # "gson":Lcom/google/gson/Gson;
    invoke-static {v4, v2, v8}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->toJson(Lcom/google/gson/Gson;Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v3

    goto :goto_2
.end method

.method public getOriginalPrice()Ljava/lang/String;
    .locals 1

    .prologue
    .line 254
    iget-object v0, p0, Lcom/poshmark/data_model/models/NewListing;->original_price:Ljava/lang/String;

    return-object v0
.end method

.method public getPrice()Ljava/lang/String;
    .locals 1

    .prologue
    .line 250
    iget-object v0, p0, Lcom/poshmark/data_model/models/NewListing;->price:Ljava/lang/String;

    return-object v0
.end method

.method public getSize()Ljava/lang/String;
    .locals 1

    .prologue
    .line 238
    iget-object v0, p0, Lcom/poshmark/data_model/models/NewListing;->size:Ljava/lang/String;

    return-object v0
.end method

.method public getSubCategoryList()Ljava/util/List;
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
    .line 234
    iget-object v0, p0, Lcom/poshmark/data_model/models/NewListing;->subcategories:Ljava/util/List;

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 213
    iget-object v0, p0, Lcom/poshmark/data_model/models/NewListing;->title:Ljava/lang/String;

    return-object v0
.end method

.method public getWebCommandInfo()Ljava/lang/String;
    .locals 1

    .prologue
    .line 281
    iget-object v0, p0, Lcom/poshmark/data_model/models/NewListing;->web_command_info:Ljava/lang/String;

    return-object v0
.end method

.method public isValidListing()Z
    .locals 3

    .prologue
    const/4 v1, 0x0

    .line 126
    iget-object v2, p0, Lcom/poshmark/data_model/models/NewListing;->title:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    if-nez v2, :cond_1

    .line 144
    :cond_0
    :goto_0
    return v1

    .line 128
    :cond_1
    iget-object v2, p0, Lcom/poshmark/data_model/models/NewListing;->description:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    if-eqz v2, :cond_0

    .line 130
    iget-object v2, p0, Lcom/poshmark/data_model/models/NewListing;->category_v2:Lcom/poshmark/data_model/models/MetaItem;

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/poshmark/data_model/models/NewListing;->category_v2:Lcom/poshmark/data_model/models/MetaItem;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 132
    iget-object v2, p0, Lcom/poshmark/data_model/models/NewListing;->size:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    if-eqz v2, :cond_0

    .line 134
    iget-object v2, p0, Lcom/poshmark/data_model/models/NewListing;->original_price:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    if-eqz v2, :cond_0

    .line 136
    iget-object v2, p0, Lcom/poshmark/data_model/models/NewListing;->price:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    if-eqz v2, :cond_0

    .line 139
    invoke-static {}, Lcom/poshmark/utils/FeatureManager;->getGlobalFeatureManager()Lcom/poshmark/utils/FeatureManager;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/utils/FeatureManager;->getListingFeature()Lcom/poshmark/data_model/models/inner_models/ListingFeature;

    move-result-object v0

    .line 140
    .local v0, "listingFeature":Lcom/poshmark/data_model/models/inner_models/ListingFeature;
    if-eqz v0, :cond_2

    .line 141
    iget-object v2, p0, Lcom/poshmark/data_model/models/NewListing;->price:Ljava/lang/String;

    invoke-virtual {v0, v2}, Lcom/poshmark/data_model/models/inner_models/ListingFeature;->isValidListingPrice(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 144
    :cond_2
    const/4 v1, 0x1

    goto :goto_0
.end method

.method public setBrand(Ljava/lang/String;)V
    .locals 0
    .param p1, "brand"    # Ljava/lang/String;

    .prologue
    .line 73
    iput-object p1, p0, Lcom/poshmark/data_model/models/NewListing;->brand:Ljava/lang/String;

    .line 74
    return-void
.end method

.method public setCategory(Lcom/poshmark/data_model/models/MetaItem;)V
    .locals 0
    .param p1, "category"    # Lcom/poshmark/data_model/models/MetaItem;

    .prologue
    .line 55
    iput-object p1, p0, Lcom/poshmark/data_model/models/NewListing;->category_v2:Lcom/poshmark/data_model/models/MetaItem;

    .line 56
    return-void
.end method

.method public setColors(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/PMColor;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 293
    .local p1, "colors":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/PMColor;>;"
    iput-object p1, p0, Lcom/poshmark/data_model/models/NewListing;->colors:Ljava/util/List;

    .line 294
    return-void
.end method

.method public setCondition(Ljava/lang/String;)V
    .locals 0
    .param p1, "condition"    # Ljava/lang/String;

    .prologue
    .line 77
    iput-object p1, p0, Lcom/poshmark/data_model/models/NewListing;->condition:Ljava/lang/String;

    .line 78
    return-void
.end method

.method public setDescription(Ljava/lang/String;)V
    .locals 0
    .param p1, "description"    # Ljava/lang/String;

    .prologue
    .line 51
    iput-object p1, p0, Lcom/poshmark/data_model/models/NewListing;->description:Ljava/lang/String;

    .line 52
    return-void
.end method

.method public setInventoryStatus(Ljava/lang/String;)V
    .locals 0
    .param p1, "status"    # Ljava/lang/String;

    .prologue
    .line 81
    iput-object p1, p0, Lcom/poshmark/data_model/models/NewListing;->inventory_status:Ljava/lang/String;

    .line 82
    return-void
.end method

.method public setKeyValuePair(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 85
    iget-object v0, p0, Lcom/poshmark/data_model/models/NewListing;->listingInfoHash:Ljava/util/HashMap;

    invoke-virtual {v0, p1, p2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 86
    return-void
.end method

.method public setListingPrice(Ljava/lang/String;)V
    .locals 0
    .param p1, "price"    # Ljava/lang/String;

    .prologue
    .line 39
    iput-object p1, p0, Lcom/poshmark/data_model/models/NewListing;->price:Ljava/lang/String;

    .line 40
    return-void
.end method

.method public setOriginalPrice(Ljava/lang/String;)V
    .locals 0
    .param p1, "orgPrice"    # Ljava/lang/String;

    .prologue
    .line 47
    iput-object p1, p0, Lcom/poshmark/data_model/models/NewListing;->original_price:Ljava/lang/String;

    .line 48
    return-void
.end method

.method public setSize(Ljava/lang/String;)V
    .locals 0
    .param p1, "size"    # Ljava/lang/String;

    .prologue
    .line 43
    iput-object p1, p0, Lcom/poshmark/data_model/models/NewListing;->size:Ljava/lang/String;

    .line 44
    return-void
.end method

.method public setSubcategories(Lcom/poshmark/data_model/models/MetaItem;)V
    .locals 1
    .param p1, "subCategory"    # Lcom/poshmark/data_model/models/MetaItem;

    .prologue
    .line 59
    iget-object v0, p0, Lcom/poshmark/data_model/models/NewListing;->subcategories:Ljava/util/List;

    if-nez v0, :cond_0

    .line 60
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/data_model/models/NewListing;->subcategories:Ljava/util/List;

    .line 62
    :cond_0
    iget-object v0, p0, Lcom/poshmark/data_model/models/NewListing;->subcategories:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 63
    iget-object v0, p0, Lcom/poshmark/data_model/models/NewListing;->subcategories:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 64
    return-void
.end method

.method public setTitle(Ljava/lang/String;)V
    .locals 0
    .param p1, "title"    # Ljava/lang/String;

    .prologue
    .line 35
    iput-object p1, p0, Lcom/poshmark/data_model/models/NewListing;->title:Ljava/lang/String;

    .line 36
    return-void
.end method

.method public setWebCommandInfo(Ljava/lang/String;)V
    .locals 0
    .param p1, "info"    # Ljava/lang/String;

    .prologue
    .line 285
    iput-object p1, p0, Lcom/poshmark/data_model/models/NewListing;->web_command_info:Ljava/lang/String;

    .line 286
    return-void
.end method

.method public updateFromListingDetails(Lcom/poshmark/data_model/models/ListingDetails;)V
    .locals 3
    .param p1, "listingDetails"    # Lcom/poshmark/data_model/models/ListingDetails;

    .prologue
    .line 166
    invoke-virtual {p1}, Lcom/poshmark/data_model/models/ListingDetails;->getTitle()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 167
    invoke-virtual {p1}, Lcom/poshmark/data_model/models/ListingDetails;->getTitle()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/data_model/models/NewListing;->title:Ljava/lang/String;

    .line 170
    :cond_0
    invoke-virtual {p1}, Lcom/poshmark/data_model/models/ListingDetails;->getDescription()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_1

    .line 171
    invoke-virtual {p1}, Lcom/poshmark/data_model/models/ListingDetails;->getDescription()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/data_model/models/NewListing;->description:Ljava/lang/String;

    .line 174
    :cond_1
    invoke-virtual {p1}, Lcom/poshmark/data_model/models/ListingDetails;->getCategoryLabel()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_2

    .line 175
    invoke-virtual {p1}, Lcom/poshmark/data_model/models/ListingDetails;->getCategory()Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/data_model/models/NewListing;->category_v2:Lcom/poshmark/data_model/models/MetaItem;

    .line 178
    :cond_2
    invoke-virtual {p1}, Lcom/poshmark/data_model/models/ListingDetails;->getSubCategoryList()Ljava/util/List;

    move-result-object v1

    if-eqz v1, :cond_3

    .line 179
    iget-object v1, p0, Lcom/poshmark/data_model/models/NewListing;->subcategories:Ljava/util/List;

    invoke-virtual {p1}, Lcom/poshmark/data_model/models/ListingDetails;->getSubCategoryList()Ljava/util/List;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 182
    :cond_3
    invoke-virtual {p1}, Lcom/poshmark/data_model/models/ListingDetails;->getColorList()Ljava/util/List;

    move-result-object v1

    if-eqz v1, :cond_4

    .line 183
    iget-object v1, p0, Lcom/poshmark/data_model/models/NewListing;->colors:Ljava/util/List;

    invoke-virtual {p1}, Lcom/poshmark/data_model/models/ListingDetails;->getColorList()Ljava/util/List;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 186
    :cond_4
    invoke-virtual {p1}, Lcom/poshmark/data_model/models/ListingDetails;->getSize()Ljava/lang/CharSequence;

    move-result-object v0

    .line 187
    .local v0, "sizeCharSequence":Ljava/lang/CharSequence;
    if-eqz v0, :cond_5

    .line 188
    invoke-interface {v0}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/data_model/models/NewListing;->size:Ljava/lang/String;

    .line 191
    :cond_5
    invoke-virtual {p1}, Lcom/poshmark/data_model/models/ListingDetails;->getCondition()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_6

    .line 192
    invoke-virtual {p1}, Lcom/poshmark/data_model/models/ListingDetails;->getCondition()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/data_model/models/NewListing;->condition:Ljava/lang/String;

    .line 195
    :cond_6
    invoke-virtual {p1}, Lcom/poshmark/data_model/models/ListingDetails;->getOriginalPrice()Ljava/math/BigDecimal;

    move-result-object v1

    if-eqz v1, :cond_7

    .line 196
    invoke-virtual {p1}, Lcom/poshmark/data_model/models/ListingDetails;->getOriginalPrice()Ljava/math/BigDecimal;

    move-result-object v1

    invoke-virtual {v1}, Ljava/math/BigDecimal;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/data_model/models/NewListing;->original_price:Ljava/lang/String;

    .line 199
    :cond_7
    invoke-virtual {p1}, Lcom/poshmark/data_model/models/ListingDetails;->getPrice()Ljava/math/BigDecimal;

    move-result-object v1

    if-eqz v1, :cond_8

    .line 200
    invoke-virtual {p1}, Lcom/poshmark/data_model/models/ListingDetails;->getPrice()Ljava/math/BigDecimal;

    move-result-object v1

    invoke-virtual {v1}, Ljava/math/BigDecimal;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/data_model/models/NewListing;->price:Ljava/lang/String;

    .line 203
    :cond_8
    invoke-virtual {p1}, Lcom/poshmark/data_model/models/ListingDetails;->getBrand()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_9

    .line 204
    invoke-virtual {p1}, Lcom/poshmark/data_model/models/ListingDetails;->getBrand()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/data_model/models/NewListing;->brand:Ljava/lang/String;

    .line 207
    :cond_9
    invoke-virtual {p1}, Lcom/poshmark/data_model/models/ListingDetails;->getInventory()Lcom/poshmark/data_model/models/inner_models/Inventory;

    move-result-object v1

    if-eqz v1, :cond_a

    .line 208
    invoke-virtual {p1}, Lcom/poshmark/data_model/models/ListingDetails;->getInventory()Lcom/poshmark/data_model/models/inner_models/Inventory;

    move-result-object v1

    iget-object v1, v1, Lcom/poshmark/data_model/models/inner_models/Inventory;->status:Ljava/lang/String;

    iput-object v1, p0, Lcom/poshmark/data_model/models/NewListing;->inventory_status:Ljava/lang/String;

    .line 210
    :cond_a
    return-void
.end method
