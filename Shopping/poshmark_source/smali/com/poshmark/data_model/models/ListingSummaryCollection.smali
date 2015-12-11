.class public Lcom/poshmark/data_model/models/ListingSummaryCollection;
.super Lcom/poshmark/data_model/models/PMData;
.source "ListingSummaryCollection.java"


# instance fields
.field private data:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/ListingSummary;",
            ">;"
        }
    .end annotation
.end field

.field facets:Lcom/poshmark/data_model/models/Facets;

.field listingSummaryMap:Ljava/util/LinkedHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/LinkedHashMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/poshmark/data_model/models/ListingSummary;",
            ">;"
        }
    .end annotation
.end field

.field more:Lcom/poshmark/data_model/models/PMData$NextMaxID;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 12
    invoke-direct {p0}, Lcom/poshmark/data_model/models/PMData;-><init>()V

    .line 13
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/data_model/models/ListingSummaryCollection;->data:Ljava/util/List;

    .line 15
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/data_model/models/ListingSummaryCollection;->more:Lcom/poshmark/data_model/models/PMData$NextMaxID;

    .line 16
    new-instance v0, Ljava/util/LinkedHashMap;

    invoke-direct {v0}, Ljava/util/LinkedHashMap;-><init>()V

    iput-object v0, p0, Lcom/poshmark/data_model/models/ListingSummaryCollection;->listingSummaryMap:Ljava/util/LinkedHashMap;

    return-void
.end method


# virtual methods
.method public append(Lcom/poshmark/data_model/models/PMData;)V
    .locals 6
    .param p1, "newData"    # Lcom/poshmark/data_model/models/PMData;

    .prologue
    .line 32
    iget-object v4, p0, Lcom/poshmark/data_model/models/ListingSummaryCollection;->data:Ljava/util/List;

    if-eqz v4, :cond_2

    if-eqz p1, :cond_2

    move-object v3, p1

    .line 33
    check-cast v3, Lcom/poshmark/data_model/models/ListingSummaryCollection;

    .line 34
    .local v3, "summaryDataCollection":Lcom/poshmark/data_model/models/ListingSummaryCollection;
    check-cast p1, Lcom/poshmark/data_model/models/ListingSummaryCollection;

    .end local p1    # "newData":Lcom/poshmark/data_model/models/PMData;
    iget-object v1, p1, Lcom/poshmark/data_model/models/ListingSummaryCollection;->data:Ljava/util/List;

    .line 35
    .local v1, "newDataList":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/ListingSummary;>;"
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 36
    .local v0, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/ListingSummary;>;"
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 37
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/poshmark/data_model/models/ListingSummary;

    .line 38
    .local v2, "newItem":Lcom/poshmark/data_model/models/ListingSummary;
    iget-object v4, p0, Lcom/poshmark/data_model/models/ListingSummaryCollection;->listingSummaryMap:Ljava/util/LinkedHashMap;

    iget-object v5, v2, Lcom/poshmark/data_model/models/ListingSummary;->id:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/util/LinkedHashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 39
    invoke-interface {v0}, Ljava/util/Iterator;->remove()V

    goto :goto_0

    .line 41
    :cond_0
    iget-object v4, p0, Lcom/poshmark/data_model/models/ListingSummaryCollection;->listingSummaryMap:Ljava/util/LinkedHashMap;

    iget-object v5, v2, Lcom/poshmark/data_model/models/ListingSummary;->id:Ljava/lang/String;

    invoke-virtual {v4, v5, v2}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 44
    .end local v2    # "newItem":Lcom/poshmark/data_model/models/ListingSummary;
    :cond_1
    iget-object v4, p0, Lcom/poshmark/data_model/models/ListingSummaryCollection;->data:Ljava/util/List;

    iget-object v5, v3, Lcom/poshmark/data_model/models/ListingSummaryCollection;->data:Ljava/util/List;

    invoke-interface {v4, v5}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 45
    iget-object v4, v3, Lcom/poshmark/data_model/models/ListingSummaryCollection;->more:Lcom/poshmark/data_model/models/PMData$NextMaxID;

    iput-object v4, p0, Lcom/poshmark/data_model/models/ListingSummaryCollection;->more:Lcom/poshmark/data_model/models/PMData$NextMaxID;

    .line 47
    .end local v0    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/ListingSummary;>;"
    .end local v1    # "newDataList":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/ListingSummary;>;"
    .end local v3    # "summaryDataCollection":Lcom/poshmark/data_model/models/ListingSummaryCollection;
    :cond_2
    return-void
.end method

.method public createHashAndRemoveDups()V
    .locals 4

    .prologue
    .line 19
    iget-object v2, p0, Lcom/poshmark/data_model/models/ListingSummaryCollection;->data:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 20
    .local v1, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/ListingSummary;>;"
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 21
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/ListingSummary;

    .line 22
    .local v0, "item":Lcom/poshmark/data_model/models/ListingSummary;
    iget-object v2, p0, Lcom/poshmark/data_model/models/ListingSummaryCollection;->listingSummaryMap:Ljava/util/LinkedHashMap;

    iget-object v3, v0, Lcom/poshmark/data_model/models/ListingSummary;->id:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/util/LinkedHashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 23
    invoke-interface {v1}, Ljava/util/Iterator;->remove()V

    goto :goto_0

    .line 25
    :cond_0
    iget-object v2, p0, Lcom/poshmark/data_model/models/ListingSummaryCollection;->listingSummaryMap:Ljava/util/LinkedHashMap;

    iget-object v3, v0, Lcom/poshmark/data_model/models/ListingSummary;->id:Ljava/lang/String;

    invoke-virtual {v2, v3, v0}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 28
    .end local v0    # "item":Lcom/poshmark/data_model/models/ListingSummary;
    :cond_1
    return-void
.end method

.method public fillCursor(Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;)V
    .locals 13
    .param p1, "cursor"    # Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    .prologue
    .line 77
    iget-object v9, p0, Lcom/poshmark/data_model/models/ListingSummaryCollection;->data:Ljava/util/List;

    if-eqz v9, :cond_2

    .line 78
    iget-object v10, p0, Lcom/poshmark/data_model/models/ListingSummaryCollection;->listingSummaryMap:Ljava/util/LinkedHashMap;

    monitor-enter v10

    .line 79
    :try_start_0
    iget-object v9, p0, Lcom/poshmark/data_model/models/ListingSummaryCollection;->listingSummaryMap:Ljava/util/LinkedHashMap;

    invoke-virtual {v9}, Ljava/util/LinkedHashMap;->size()I

    move-result v8

    .line 81
    .local v8, "totalItems":I
    div-int/lit8 v5, v8, 0x2

    .line 82
    .local v5, "numPairs":I
    rem-int/lit8 v7, v8, 0x2

    .line 83
    .local v7, "residue":I
    const/4 v2, 0x0

    .line 84
    .local v2, "index":I
    iget-object v9, p0, Lcom/poshmark/data_model/models/ListingSummaryCollection;->listingSummaryMap:Ljava/util/LinkedHashMap;

    invoke-virtual {v9}, Ljava/util/LinkedHashMap;->values()Ljava/util/Collection;

    move-result-object v1

    .line 85
    .local v1, "collection":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/poshmark/data_model/models/ListingSummary;>;"
    invoke-interface {v1}, Ljava/util/Collection;->toArray()[Ljava/lang/Object;

    move-result-object v0

    .line 86
    .local v0, "arr":[Ljava/lang/Object;
    :goto_0
    mul-int/lit8 v9, v5, 0x2

    if-ge v2, v9, :cond_0

    .line 88
    aget-object v3, v0, v2

    check-cast v3, Lcom/poshmark/data_model/models/ListingSummary;

    .line 89
    .local v3, "item1":Lcom/poshmark/data_model/models/ListingSummary;
    add-int/lit8 v9, v2, 0x1

    aget-object v4, v0, v9

    check-cast v4, Lcom/poshmark/data_model/models/ListingSummary;

    .line 90
    .local v4, "item2":Lcom/poshmark/data_model/models/ListingSummary;
    new-instance v6, Lcom/poshmark/utils/ItemPair;

    invoke-direct {v6, v3, v4}, Lcom/poshmark/utils/ItemPair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 91
    .local v6, "pair":Lcom/poshmark/utils/ItemPair;, "Lcom/poshmark/utils/ItemPair<Lcom/poshmark/data_model/models/ListingSummary;>;"
    const/4 v9, 0x2

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v11, 0x0

    const/4 v12, 0x0

    invoke-static {v12}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v12

    aput-object v12, v9, v11

    const/4 v11, 0x1

    aput-object v6, v9, v11

    invoke-virtual {p1, v9}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->addRow([Ljava/lang/Object;)V

    .line 92
    add-int/lit8 v2, v2, 0x2

    .line 93
    goto :goto_0

    .line 95
    .end local v3    # "item1":Lcom/poshmark/data_model/models/ListingSummary;
    .end local v4    # "item2":Lcom/poshmark/data_model/models/ListingSummary;
    .end local v6    # "pair":Lcom/poshmark/utils/ItemPair;, "Lcom/poshmark/utils/ItemPair<Lcom/poshmark/data_model/models/ListingSummary;>;"
    :cond_0
    if-eqz v7, :cond_1

    .line 96
    add-int/lit8 v9, v8, -0x1

    aget-object v3, v0, v9

    check-cast v3, Lcom/poshmark/data_model/models/ListingSummary;

    .line 97
    .restart local v3    # "item1":Lcom/poshmark/data_model/models/ListingSummary;
    new-instance v6, Lcom/poshmark/utils/ItemPair;

    const/4 v9, 0x0

    invoke-direct {v6, v3, v9}, Lcom/poshmark/utils/ItemPair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 98
    .restart local v6    # "pair":Lcom/poshmark/utils/ItemPair;, "Lcom/poshmark/utils/ItemPair<Lcom/poshmark/data_model/models/ListingSummary;>;"
    const/4 v9, 0x2

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v11, 0x0

    const/4 v12, 0x0

    invoke-static {v12}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v12

    aput-object v12, v9, v11

    const/4 v11, 0x1

    aput-object v6, v9, v11

    invoke-virtual {p1, v9}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->addRow([Ljava/lang/Object;)V

    .line 100
    .end local v3    # "item1":Lcom/poshmark/data_model/models/ListingSummary;
    .end local v6    # "pair":Lcom/poshmark/utils/ItemPair;, "Lcom/poshmark/utils/ItemPair<Lcom/poshmark/data_model/models/ListingSummary;>;"
    :cond_1
    monitor-exit v10

    .line 102
    .end local v0    # "arr":[Ljava/lang/Object;
    .end local v1    # "collection":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/poshmark/data_model/models/ListingSummary;>;"
    .end local v2    # "index":I
    .end local v5    # "numPairs":I
    .end local v7    # "residue":I
    .end local v8    # "totalItems":I
    :cond_2
    return-void

    .line 100
    :catchall_0
    move-exception v9

    monitor-exit v10
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v9
.end method

.method public getFacets()Lcom/poshmark/data_model/models/Facets;
    .locals 1

    .prologue
    .line 120
    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingSummaryCollection;->facets:Lcom/poshmark/data_model/models/Facets;

    return-object v0
.end method

.method public getNextPageMaxValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 106
    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingSummaryCollection;->more:Lcom/poshmark/data_model/models/PMData$NextMaxID;

    if-eqz v0, :cond_0

    .line 107
    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingSummaryCollection;->more:Lcom/poshmark/data_model/models/PMData$NextMaxID;

    iget-object v0, v0, Lcom/poshmark/data_model/models/PMData$NextMaxID;->next_max_id:Ljava/lang/String;

    .line 109
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public hasListing(Ljava/lang/String;)Z
    .locals 1
    .param p1, "listingId"    # Ljava/lang/String;

    .prologue
    .line 124
    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingSummaryCollection;->listingSummaryMap:Ljava/util/LinkedHashMap;

    invoke-virtual {v0, p1}, Ljava/util/LinkedHashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 125
    const/4 v0, 0x1

    .line 127
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isEmpty()Z
    .locals 1

    .prologue
    .line 116
    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingSummaryCollection;->listingSummaryMap:Ljava/util/LinkedHashMap;

    invoke-virtual {v0}, Ljava/util/LinkedHashMap;->isEmpty()Z

    move-result v0

    return v0
.end method

.method public removeListing(Ljava/lang/String;)V
    .locals 1
    .param p1, "listingId"    # Ljava/lang/String;

    .prologue
    .line 132
    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingSummaryCollection;->listingSummaryMap:Ljava/util/LinkedHashMap;

    invoke-virtual {v0, p1}, Ljava/util/LinkedHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 133
    return-void
.end method
