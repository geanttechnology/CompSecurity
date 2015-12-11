.class public Lcom/poshmark/data_model/models/inner_models/Theme;
.super Ljava/lang/Object;
.source "Theme.java"


# instance fields
.field brands:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field categories:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field categories_v2:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field category_features:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field colors:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field max_price:F

.field min_price:F

.field sizes:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/high16 v1, -0x40800000    # -1.0f

    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    invoke-static {v0}, Ljava/util/Collections;->synchronizedList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Theme;->categories:Ljava/util/List;

    .line 18
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    invoke-static {v0}, Ljava/util/Collections;->synchronizedList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Theme;->categories_v2:Ljava/util/List;

    .line 19
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    invoke-static {v0}, Ljava/util/Collections;->synchronizedList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Theme;->category_features:Ljava/util/List;

    .line 20
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    invoke-static {v0}, Ljava/util/Collections;->synchronizedList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Theme;->colors:Ljava/util/List;

    .line 21
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    invoke-static {v0}, Ljava/util/Collections;->synchronizedList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Theme;->sizes:Ljava/util/List;

    .line 22
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    invoke-static {v0}, Ljava/util/Collections;->synchronizedList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Theme;->brands:Ljava/util/List;

    .line 23
    iput v1, p0, Lcom/poshmark/data_model/models/inner_models/Theme;->max_price:F

    .line 24
    iput v1, p0, Lcom/poshmark/data_model/models/inner_models/Theme;->min_price:F

    return-void
.end method


# virtual methods
.method public getBrands()Ljava/util/List;
    .locals 1
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
    .line 57
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Theme;->brands:Ljava/util/List;

    return-object v0
.end method

.method public getCategories()Ljava/util/List;
    .locals 1
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
    .line 27
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Theme;->categories:Ljava/util/List;

    return-object v0
.end method

.method public getCommaSeparatedBrands(Landroid/content/Context;)Ljava/lang/String;
    .locals 5
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 61
    iget-object v4, p0, Lcom/poshmark/data_model/models/inner_models/Theme;->brands:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v4

    if-nez v4, :cond_0

    .line 62
    const v4, 0x7f06003c

    invoke-virtual {p1, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 71
    :goto_0
    return-object v4

    .line 64
    :cond_0
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 65
    .local v0, "brandNames":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iget-object v4, p0, Lcom/poshmark/data_model/models/inner_models/Theme;->brands:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_1
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 66
    .local v3, "label":Ljava/lang/String;
    invoke-static {v3}, Lcom/poshmark/db/DbApi;->getBrandItemFromLabel(Ljava/lang/String;)Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v2

    .line 67
    .local v2, "item":Lcom/poshmark/data_model/models/MetaItem;
    if-eqz v2, :cond_1

    .line 68
    invoke-virtual {v2}, Lcom/poshmark/data_model/models/MetaItem;->getDisplay()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v0, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 71
    .end local v2    # "item":Lcom/poshmark/data_model/models/MetaItem;
    .end local v3    # "label":Ljava/lang/String;
    :cond_2
    const-string v4, ","

    invoke-static {v0, v4}, Lcom/poshmark/utils/StringUtils;->join(Ljava/util/List;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    goto :goto_0
.end method

.method public getCommaSeparatedCategories(Landroid/content/Context;)Ljava/lang/String;
    .locals 5
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 31
    iget-object v4, p0, Lcom/poshmark/data_model/models/inner_models/Theme;->categories_v2:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v4

    if-nez v4, :cond_0

    .line 32
    const v4, 0x7f06003c

    invoke-virtual {p1, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 41
    :goto_0
    return-object v4

    .line 34
    :cond_0
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 35
    .local v0, "catNames":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iget-object v4, p0, Lcom/poshmark/data_model/models/inner_models/Theme;->categories_v2:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_1
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 36
    .local v2, "id":Ljava/lang/String;
    invoke-static {v2}, Lcom/poshmark/db/DbApi;->getCurrentCategoryFromId(Ljava/lang/String;)Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v3

    .line 37
    .local v3, "item":Lcom/poshmark/data_model/models/MetaItem;
    if-eqz v3, :cond_1

    .line 38
    invoke-virtual {v3}, Lcom/poshmark/data_model/models/MetaItem;->getDisplay()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v0, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 41
    .end local v2    # "id":Ljava/lang/String;
    .end local v3    # "item":Lcom/poshmark/data_model/models/MetaItem;
    :cond_2
    const-string v4, ","

    invoke-static {v0, v4}, Lcom/poshmark/utils/StringUtils;->join(Ljava/util/List;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    goto :goto_0
.end method

.method public getCommaSeparatedSizes(Landroid/content/Context;)Ljava/lang/String;
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 50
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Theme;->sizes:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-nez v0, :cond_0

    .line 51
    const v0, 0x7f06003c

    invoke-virtual {p1, v0}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 53
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Theme;->sizes:Ljava/util/List;

    const-string v1, ","

    invoke-static {v0, v1}, Lcom/poshmark/utils/StringUtils;->join(Ljava/util/List;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public getMaxPrice()F
    .locals 1

    .prologue
    .line 76
    iget v0, p0, Lcom/poshmark/data_model/models/inner_models/Theme;->max_price:F

    return v0
.end method

.method public getMinPrice()F
    .locals 1

    .prologue
    .line 80
    iget v0, p0, Lcom/poshmark/data_model/models/inner_models/Theme;->min_price:F

    return v0
.end method

.method public getSizes()Ljava/util/List;
    .locals 1
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
    .line 46
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Theme;->sizes:Ljava/util/List;

    return-object v0
.end method

.method public isMatchingBrand(Ljava/lang/String;)Z
    .locals 4
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 146
    const/4 v2, 0x0

    .line 147
    .local v2, "retVal":Z
    iget-object v3, p0, Lcom/poshmark/data_model/models/inner_models/Theme;->brands:Ljava/util/List;

    if-eqz v3, :cond_2

    iget-object v3, p0, Lcom/poshmark/data_model/models/inner_models/Theme;->brands:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    if-lez v3, :cond_2

    .line 148
    if-eqz p1, :cond_1

    .line 149
    iget-object v3, p0, Lcom/poshmark/data_model/models/inner_models/Theme;->brands:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 150
    .local v1, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 151
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 152
    .local v0, "brand":Ljava/lang/String;
    invoke-virtual {v0, p1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 153
    const/4 v2, 0x1

    .line 161
    .end local v0    # "brand":Ljava/lang/String;
    .end local v1    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :cond_1
    :goto_0
    return v2

    .line 159
    :cond_2
    const/4 v2, 0x1

    goto :goto_0
.end method

.method public isMatchingCategory(Ljava/lang/String;)Z
    .locals 4
    .param p1, "categoryId"    # Ljava/lang/String;

    .prologue
    .line 85
    const/4 v2, 0x0

    .line 86
    .local v2, "retVal":Z
    iget-object v3, p0, Lcom/poshmark/data_model/models/inner_models/Theme;->categories_v2:Ljava/util/List;

    if-eqz v3, :cond_2

    iget-object v3, p0, Lcom/poshmark/data_model/models/inner_models/Theme;->categories_v2:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    if-lez v3, :cond_2

    .line 87
    if-eqz p1, :cond_1

    .line 88
    iget-object v3, p0, Lcom/poshmark/data_model/models/inner_models/Theme;->categories_v2:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 89
    .local v0, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :cond_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 90
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 91
    .local v1, "partyCategory":Ljava/lang/String;
    invoke-virtual {v1, p1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 92
    const/4 v2, 0x1

    .line 100
    .end local v0    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    .end local v1    # "partyCategory":Ljava/lang/String;
    :cond_1
    :goto_0
    return v2

    .line 98
    :cond_2
    const/4 v2, 0x1

    goto :goto_0
.end method

.method public isMatchingColor(Ljava/util/List;)Z
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/PMColor;",
            ">;)Z"
        }
    .end annotation

    .prologue
    .line 190
    .local p1, "colorList":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/PMColor;>;"
    iget-object v3, p0, Lcom/poshmark/data_model/models/inner_models/Theme;->colors:Ljava/util/List;

    if-eqz v3, :cond_3

    iget-object v3, p0, Lcom/poshmark/data_model/models/inner_models/Theme;->colors:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    if-lez v3, :cond_3

    .line 191
    if-eqz p1, :cond_2

    invoke-interface {p1}, Ljava/util/List;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_2

    .line 192
    const/4 v2, 0x1

    .line 193
    .local v2, "retVal":Z
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 194
    .local v1, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/PMColor;>;"
    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 195
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/PMColor;

    .line 196
    .local v0, "color":Lcom/poshmark/data_model/models/PMColor;
    iget-object v3, p0, Lcom/poshmark/data_model/models/inner_models/Theme;->colors:Ljava/util/List;

    iget-object v4, v0, Lcom/poshmark/data_model/models/PMColor;->name:Ljava/lang/String;

    invoke-interface {v3, v4}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 197
    const/4 v2, 0x0

    .line 207
    .end local v0    # "color":Lcom/poshmark/data_model/models/PMColor;
    .end local v1    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/PMColor;>;"
    :cond_1
    :goto_0
    return v2

    .line 202
    .end local v2    # "retVal":Z
    :cond_2
    const/4 v2, 0x1

    .restart local v2    # "retVal":Z
    goto :goto_0

    .line 205
    .end local v2    # "retVal":Z
    :cond_3
    const/4 v2, 0x1

    .restart local v2    # "retVal":Z
    goto :goto_0
.end method

.method public isMatchingPrice(Ljava/lang/String;)Z
    .locals 4
    .param p1, "price"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x0

    .line 165
    const/4 v1, 0x0

    .line 167
    .local v1, "retVal":Z
    iget v2, p0, Lcom/poshmark/data_model/models/inner_models/Theme;->max_price:F

    cmpl-float v2, v2, v3

    if-gtz v2, :cond_0

    iget v2, p0, Lcom/poshmark/data_model/models/inner_models/Theme;->min_price:F

    cmpl-float v2, v2, v3

    if-lez v2, :cond_3

    .line 168
    :cond_0
    if-eqz p1, :cond_2

    .line 169
    invoke-static {p1}, Ljava/lang/Float;->valueOf(Ljava/lang/String;)Ljava/lang/Float;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Float;->floatValue()F

    move-result v0

    .line 170
    .local v0, "numPrice":F
    iget v2, p0, Lcom/poshmark/data_model/models/inner_models/Theme;->max_price:F

    cmpl-float v2, v2, v3

    if-lez v2, :cond_1

    .line 171
    iget v2, p0, Lcom/poshmark/data_model/models/inner_models/Theme;->max_price:F

    cmpg-float v2, v0, v2

    if-gtz v2, :cond_1

    .line 172
    const/4 v1, 0x1

    .line 176
    :cond_1
    iget v2, p0, Lcom/poshmark/data_model/models/inner_models/Theme;->min_price:F

    cmpl-float v2, v2, v3

    if-lez v2, :cond_2

    .line 177
    iget v2, p0, Lcom/poshmark/data_model/models/inner_models/Theme;->min_price:F

    cmpl-float v2, v0, v2

    if-ltz v2, :cond_2

    .line 178
    const/4 v1, 0x1

    .line 185
    .end local v0    # "numPrice":F
    :cond_2
    :goto_0
    return v1

    .line 183
    :cond_3
    const/4 v1, 0x1

    goto :goto_0
.end method

.method public isMatchingSize(Ljava/lang/CharSequence;)Z
    .locals 4
    .param p1, "size"    # Ljava/lang/CharSequence;

    .prologue
    .line 126
    const/4 v2, 0x0

    .line 127
    .local v2, "retVal":Z
    iget-object v3, p0, Lcom/poshmark/data_model/models/inner_models/Theme;->sizes:Ljava/util/List;

    if-eqz v3, :cond_2

    iget-object v3, p0, Lcom/poshmark/data_model/models/inner_models/Theme;->sizes:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    if-lez v3, :cond_2

    .line 128
    if-eqz p1, :cond_1

    .line 129
    iget-object v3, p0, Lcom/poshmark/data_model/models/inner_models/Theme;->sizes:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 130
    .local v0, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :cond_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 131
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 132
    .local v1, "partyCategory":Ljava/lang/String;
    invoke-interface {p1}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 133
    const/4 v2, 0x1

    .line 141
    .end local v0    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    .end local v1    # "partyCategory":Ljava/lang/String;
    :cond_1
    :goto_0
    return v2

    .line 139
    :cond_2
    const/4 v2, 0x1

    goto :goto_0
.end method

.method public isMatchingSubCategory(Ljava/util/List;)Z
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;)Z"
        }
    .end annotation

    .prologue
    .line 105
    .local p1, "subCatList":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    iget-object v3, p0, Lcom/poshmark/data_model/models/inner_models/Theme;->category_features:Ljava/util/List;

    if-eqz v3, :cond_3

    iget-object v3, p0, Lcom/poshmark/data_model/models/inner_models/Theme;->category_features:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    if-lez v3, :cond_3

    .line 106
    if-eqz p1, :cond_2

    invoke-interface {p1}, Ljava/util/List;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_2

    .line 107
    const/4 v1, 0x1

    .line 108
    .local v1, "retVal":Z
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 109
    .local v0, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/MetaItem;>;"
    :cond_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 110
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/poshmark/data_model/models/MetaItem;

    .line 111
    .local v2, "subCat":Lcom/poshmark/data_model/models/MetaItem;
    iget-object v3, p0, Lcom/poshmark/data_model/models/inner_models/Theme;->category_features:Ljava/util/List;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v3, v4}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 112
    const/4 v1, 0x0

    .line 122
    .end local v0    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/MetaItem;>;"
    .end local v2    # "subCat":Lcom/poshmark/data_model/models/MetaItem;
    :cond_1
    :goto_0
    return v1

    .line 117
    .end local v1    # "retVal":Z
    :cond_2
    const/4 v1, 0x1

    .restart local v1    # "retVal":Z
    goto :goto_0

    .line 120
    .end local v1    # "retVal":Z
    :cond_3
    const/4 v1, 0x1

    .restart local v1    # "retVal":Z
    goto :goto_0
.end method
