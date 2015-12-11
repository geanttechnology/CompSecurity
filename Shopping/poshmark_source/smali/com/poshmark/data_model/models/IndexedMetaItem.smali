.class public Lcom/poshmark/data_model/models/IndexedMetaItem;
.super Ljava/lang/Object;
.source "IndexedMetaItem.java"


# instance fields
.field index:I

.field isRecentItem:Z

.field item:Lcom/poshmark/data_model/models/MetaItem;


# direct methods
.method public constructor <init>(Lcom/poshmark/data_model/models/MetaItem;I)V
    .locals 0
    .param p1, "item"    # Lcom/poshmark/data_model/models/MetaItem;
    .param p2, "index"    # I

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 14
    iput p2, p0, Lcom/poshmark/data_model/models/IndexedMetaItem;->index:I

    .line 15
    iput-object p1, p0, Lcom/poshmark/data_model/models/IndexedMetaItem;->item:Lcom/poshmark/data_model/models/MetaItem;

    .line 16
    return-void
.end method

.method public constructor <init>(Lcom/poshmark/data_model/models/MetaItem;IZ)V
    .locals 0
    .param p1, "item"    # Lcom/poshmark/data_model/models/MetaItem;
    .param p2, "index"    # I
    .param p3, "isRecent"    # Z

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 19
    iput p2, p0, Lcom/poshmark/data_model/models/IndexedMetaItem;->index:I

    .line 20
    iput-object p1, p0, Lcom/poshmark/data_model/models/IndexedMetaItem;->item:Lcom/poshmark/data_model/models/MetaItem;

    .line 21
    iput-boolean p3, p0, Lcom/poshmark/data_model/models/IndexedMetaItem;->isRecentItem:Z

    .line 22
    return-void
.end method

.method public static convertIndexedBrandsToIndexMetaItemList(Ljava/util/ArrayList;Ljava/util/ArrayList;)Ljava/util/ArrayList;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/poshmark/data_model/models/IndexedMetaItem;",
            ">;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;)",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/poshmark/data_model/models/IndexedMetaItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 73
    .local p0, "data":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/poshmark/data_model/models/IndexedMetaItem;>;"
    .local p1, "recentBrands":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/poshmark/data_model/models/MetaItem;>;"
    if-nez p0, :cond_1

    .line 74
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 89
    :cond_0
    return-object v4

    .line 76
    :cond_1
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 77
    .local v4, "newArray":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/poshmark/data_model/models/IndexedMetaItem;>;"
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v6

    if-ge v0, v6, :cond_2

    .line 78
    invoke-virtual {p1, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/poshmark/data_model/models/MetaItem;

    .line 79
    .local v2, "item":Lcom/poshmark/data_model/models/MetaItem;
    new-instance v1, Lcom/poshmark/data_model/models/IndexedMetaItem;

    invoke-direct {v1, v2, v0}, Lcom/poshmark/data_model/models/IndexedMetaItem;-><init>(Lcom/poshmark/data_model/models/MetaItem;I)V

    .line 80
    .local v1, "indexedItem":Lcom/poshmark/data_model/models/IndexedMetaItem;
    invoke-virtual {v4, v0, v1}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V

    .line 77
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 84
    .end local v1    # "indexedItem":Lcom/poshmark/data_model/models/IndexedMetaItem;
    .end local v2    # "item":Lcom/poshmark/data_model/models/MetaItem;
    :cond_2
    invoke-virtual {p0}, Ljava/util/ArrayList;->size()I

    move-result v5

    .line 85
    .local v5, "size":I
    const/4 v3, 0x0

    .local v3, "j":I
    :goto_1
    if-ge v3, v5, :cond_0

    .line 86
    invoke-virtual {p0, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/poshmark/data_model/models/IndexedMetaItem;

    .line 87
    .local v2, "item":Lcom/poshmark/data_model/models/IndexedMetaItem;
    add-int v6, v0, v3

    invoke-virtual {v4, v6, v2}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V

    .line 85
    add-int/lit8 v3, v3, 0x1

    goto :goto_1
.end method

.method public static convertRecentBrandsToIndexMetaItemList(Ljava/util/ArrayList;Ljava/util/ArrayList;)Ljava/util/ArrayList;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;)",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/poshmark/data_model/models/IndexedMetaItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 49
    .local p0, "data":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/poshmark/data_model/models/MetaItem;>;"
    .local p1, "recentBrands":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/poshmark/data_model/models/MetaItem;>;"
    if-nez p0, :cond_1

    .line 50
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 68
    :cond_0
    return-object v4

    .line 51
    :cond_1
    const/4 v0, 0x0

    .line 52
    .local v0, "i":I
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 53
    .local v4, "newArray":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/poshmark/data_model/models/IndexedMetaItem;>;"
    if-eqz p1, :cond_2

    .line 55
    const/4 v0, 0x0

    :goto_0
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v6

    if-ge v0, v6, :cond_2

    .line 56
    invoke-virtual {p1, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/poshmark/data_model/models/MetaItem;

    .line 57
    .local v2, "item":Lcom/poshmark/data_model/models/MetaItem;
    new-instance v1, Lcom/poshmark/data_model/models/IndexedMetaItem;

    invoke-direct {v1, v2, v0}, Lcom/poshmark/data_model/models/IndexedMetaItem;-><init>(Lcom/poshmark/data_model/models/MetaItem;I)V

    .line 58
    .local v1, "indexedItem":Lcom/poshmark/data_model/models/IndexedMetaItem;
    invoke-virtual {v4, v0, v1}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V

    .line 55
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 62
    .end local v1    # "indexedItem":Lcom/poshmark/data_model/models/IndexedMetaItem;
    .end local v2    # "item":Lcom/poshmark/data_model/models/MetaItem;
    :cond_2
    invoke-virtual {p0}, Ljava/util/ArrayList;->size()I

    move-result v5

    .line 63
    .local v5, "size":I
    const/4 v3, 0x0

    .local v3, "j":I
    :goto_1
    if-ge v3, v5, :cond_0

    .line 64
    invoke-virtual {p0, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/poshmark/data_model/models/MetaItem;

    .line 65
    .restart local v2    # "item":Lcom/poshmark/data_model/models/MetaItem;
    new-instance v1, Lcom/poshmark/data_model/models/IndexedMetaItem;

    add-int v6, v0, v3

    invoke-direct {v1, v2, v6}, Lcom/poshmark/data_model/models/IndexedMetaItem;-><init>(Lcom/poshmark/data_model/models/MetaItem;I)V

    .line 66
    .restart local v1    # "indexedItem":Lcom/poshmark/data_model/models/IndexedMetaItem;
    add-int v6, v0, v3

    invoke-virtual {v4, v6, v1}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V

    .line 63
    add-int/lit8 v3, v3, 0x1

    goto :goto_1
.end method

.method public static convertToIndexMetaItemList(Ljava/util/ArrayList;)Ljava/util/ArrayList;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;)",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/poshmark/data_model/models/IndexedMetaItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 34
    .local p0, "data":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/poshmark/data_model/models/MetaItem;>;"
    if-nez p0, :cond_1

    .line 35
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 44
    :cond_0
    return-object v3

    .line 37
    :cond_1
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 38
    .local v3, "newArray":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/poshmark/data_model/models/IndexedMetaItem;>;"
    invoke-virtual {p0}, Ljava/util/ArrayList;->size()I

    move-result v4

    .line 39
    .local v4, "size":I
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, v4, :cond_0

    .line 40
    invoke-virtual {p0, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/poshmark/data_model/models/MetaItem;

    .line 41
    .local v2, "item":Lcom/poshmark/data_model/models/MetaItem;
    new-instance v1, Lcom/poshmark/data_model/models/IndexedMetaItem;

    invoke-direct {v1, v2, v0}, Lcom/poshmark/data_model/models/IndexedMetaItem;-><init>(Lcom/poshmark/data_model/models/MetaItem;I)V

    .line 42
    .local v1, "indexedItem":Lcom/poshmark/data_model/models/IndexedMetaItem;
    invoke-virtual {v3, v0, v1}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V

    .line 39
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method


# virtual methods
.method public getIndex()I
    .locals 1

    .prologue
    .line 30
    iget v0, p0, Lcom/poshmark/data_model/models/IndexedMetaItem;->index:I

    return v0
.end method

.method public getMetaItem()Lcom/poshmark/data_model/models/MetaItem;
    .locals 1

    .prologue
    .line 26
    iget-object v0, p0, Lcom/poshmark/data_model/models/IndexedMetaItem;->item:Lcom/poshmark/data_model/models/MetaItem;

    return-object v0
.end method
