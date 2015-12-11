.class public Lcom/poshmark/data_model/models/ShowroomListings;
.super Lcom/poshmark/data_model/models/PMData;
.source "ShowroomListings.java"


# instance fields
.field data:Ljava/util/List;
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

.field more:Lcom/poshmark/data_model/models/PMData$NextMaxID;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 11
    invoke-direct {p0}, Lcom/poshmark/data_model/models/PMData;-><init>()V

    .line 14
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/data_model/models/ShowroomListings;->more:Lcom/poshmark/data_model/models/PMData$NextMaxID;

    return-void
.end method


# virtual methods
.method public append(Lcom/poshmark/data_model/models/PMData;)V
    .locals 3
    .param p1, "newData"    # Lcom/poshmark/data_model/models/PMData;

    .prologue
    .line 18
    iget-object v1, p0, Lcom/poshmark/data_model/models/ShowroomListings;->data:Ljava/util/List;

    if-eqz v1, :cond_0

    if-eqz p1, :cond_0

    move-object v0, p1

    .line 19
    check-cast v0, Lcom/poshmark/data_model/models/ShowroomListings;

    .line 20
    .local v0, "newListings":Lcom/poshmark/data_model/models/ShowroomListings;
    iget-object v1, p0, Lcom/poshmark/data_model/models/ShowroomListings;->data:Ljava/util/List;

    iget-object v2, v0, Lcom/poshmark/data_model/models/ShowroomListings;->data:Ljava/util/List;

    invoke-interface {v1, v2}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 21
    iget-object v1, v0, Lcom/poshmark/data_model/models/ShowroomListings;->more:Lcom/poshmark/data_model/models/PMData$NextMaxID;

    iput-object v1, p0, Lcom/poshmark/data_model/models/ShowroomListings;->more:Lcom/poshmark/data_model/models/PMData$NextMaxID;

    .line 23
    .end local v0    # "newListings":Lcom/poshmark/data_model/models/ShowroomListings;
    :cond_0
    return-void
.end method

.method public fillCursor(Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;)V
    .locals 11
    .param p1, "cursor"    # Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    .prologue
    .line 27
    iget-object v7, p0, Lcom/poshmark/data_model/models/ShowroomListings;->data:Ljava/util/List;

    if-eqz v7, :cond_2

    .line 28
    iget-object v8, p0, Lcom/poshmark/data_model/models/ShowroomListings;->data:Ljava/util/List;

    monitor-enter v8

    .line 29
    :try_start_0
    iget-object v7, p0, Lcom/poshmark/data_model/models/ShowroomListings;->data:Ljava/util/List;

    invoke-interface {v7}, Ljava/util/List;->size()I

    move-result v6

    .line 31
    .local v6, "totalItems":I
    div-int/lit8 v3, v6, 0x2

    .line 32
    .local v3, "numPairs":I
    rem-int/lit8 v5, v6, 0x2

    .line 33
    .local v5, "residue":I
    const/4 v0, 0x0

    .line 34
    .local v0, "index":I
    :goto_0
    mul-int/lit8 v7, v3, 0x2

    if-ge v0, v7, :cond_0

    .line 35
    iget-object v7, p0, Lcom/poshmark/data_model/models/ShowroomListings;->data:Ljava/util/List;

    invoke-interface {v7, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/data_model/models/ListingSummary;

    .line 36
    .local v1, "item1":Lcom/poshmark/data_model/models/ListingSummary;
    iget-object v7, p0, Lcom/poshmark/data_model/models/ShowroomListings;->data:Ljava/util/List;

    add-int/lit8 v9, v0, 0x1

    invoke-interface {v7, v9}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/poshmark/data_model/models/ListingSummary;

    .line 37
    .local v2, "item2":Lcom/poshmark/data_model/models/ListingSummary;
    new-instance v4, Lcom/poshmark/utils/ItemPair;

    invoke-direct {v4, v1, v2}, Lcom/poshmark/utils/ItemPair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 38
    .local v4, "pair":Lcom/poshmark/utils/ItemPair;, "Lcom/poshmark/utils/ItemPair<Lcom/poshmark/data_model/models/ListingSummary;>;"
    const/4 v7, 0x2

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v9, 0x0

    const/4 v10, 0x0

    invoke-static {v10}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    aput-object v10, v7, v9

    const/4 v9, 0x1

    aput-object v4, v7, v9

    invoke-virtual {p1, v7}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->addRow([Ljava/lang/Object;)V

    .line 39
    add-int/lit8 v0, v0, 0x2

    .line 40
    goto :goto_0

    .line 42
    .end local v1    # "item1":Lcom/poshmark/data_model/models/ListingSummary;
    .end local v2    # "item2":Lcom/poshmark/data_model/models/ListingSummary;
    .end local v4    # "pair":Lcom/poshmark/utils/ItemPair;, "Lcom/poshmark/utils/ItemPair<Lcom/poshmark/data_model/models/ListingSummary;>;"
    :cond_0
    if-eqz v5, :cond_1

    .line 43
    iget-object v7, p0, Lcom/poshmark/data_model/models/ShowroomListings;->data:Ljava/util/List;

    add-int/lit8 v9, v6, -0x1

    invoke-interface {v7, v9}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/data_model/models/ListingSummary;

    .line 44
    .restart local v1    # "item1":Lcom/poshmark/data_model/models/ListingSummary;
    new-instance v4, Lcom/poshmark/utils/ItemPair;

    const/4 v7, 0x0

    invoke-direct {v4, v1, v7}, Lcom/poshmark/utils/ItemPair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 45
    .restart local v4    # "pair":Lcom/poshmark/utils/ItemPair;, "Lcom/poshmark/utils/ItemPair<Lcom/poshmark/data_model/models/ListingSummary;>;"
    const/4 v7, 0x2

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v9, 0x0

    const/4 v10, 0x0

    invoke-static {v10}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    aput-object v10, v7, v9

    const/4 v9, 0x1

    aput-object v4, v7, v9

    invoke-virtual {p1, v7}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->addRow([Ljava/lang/Object;)V

    .line 47
    .end local v1    # "item1":Lcom/poshmark/data_model/models/ListingSummary;
    .end local v4    # "pair":Lcom/poshmark/utils/ItemPair;, "Lcom/poshmark/utils/ItemPair<Lcom/poshmark/data_model/models/ListingSummary;>;"
    :cond_1
    monitor-exit v8

    .line 49
    .end local v0    # "index":I
    .end local v3    # "numPairs":I
    .end local v5    # "residue":I
    .end local v6    # "totalItems":I
    :cond_2
    return-void

    .line 47
    :catchall_0
    move-exception v7

    monitor-exit v8
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v7
.end method

.method public getFacets()Lcom/poshmark/data_model/models/Facets;
    .locals 1

    .prologue
    .line 67
    iget-object v0, p0, Lcom/poshmark/data_model/models/ShowroomListings;->facets:Lcom/poshmark/data_model/models/Facets;

    return-object v0
.end method

.method public getNextPageMaxValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/poshmark/data_model/models/ShowroomListings;->more:Lcom/poshmark/data_model/models/PMData$NextMaxID;

    if-eqz v0, :cond_0

    .line 54
    iget-object v0, p0, Lcom/poshmark/data_model/models/ShowroomListings;->more:Lcom/poshmark/data_model/models/PMData$NextMaxID;

    iget-object v0, v0, Lcom/poshmark/data_model/models/PMData$NextMaxID;->next_max_id:Ljava/lang/String;

    .line 56
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isEmpty()Z
    .locals 1

    .prologue
    .line 63
    iget-object v0, p0, Lcom/poshmark/data_model/models/ShowroomListings;->data:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    return v0
.end method
