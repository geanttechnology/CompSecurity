.class public Lcom/poshmark/data_model/models/MyBundles;
.super Lcom/poshmark/data_model/models/PMData;
.source "MyBundles.java"


# instance fields
.field data:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/PMBundle;",
            ">;"
        }
    .end annotation
.end field

.field more:Lcom/poshmark/data_model/models/PMData$NextMaxID;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 14
    invoke-direct {p0}, Lcom/poshmark/data_model/models/PMData;-><init>()V

    .line 15
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/data_model/models/MyBundles;->data:Ljava/util/List;

    .line 16
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/data_model/models/MyBundles;->more:Lcom/poshmark/data_model/models/PMData$NextMaxID;

    return-void
.end method


# virtual methods
.method public append(Lcom/poshmark/data_model/models/PMData;)V
    .locals 3
    .param p1, "newData"    # Lcom/poshmark/data_model/models/PMData;

    .prologue
    .line 20
    iget-object v1, p0, Lcom/poshmark/data_model/models/MyBundles;->data:Ljava/util/List;

    if-eqz v1, :cond_0

    if-eqz p1, :cond_0

    move-object v0, p1

    .line 21
    check-cast v0, Lcom/poshmark/data_model/models/MyBundles;

    .line 22
    .local v0, "newBundles":Lcom/poshmark/data_model/models/MyBundles;
    iget-object v1, p0, Lcom/poshmark/data_model/models/MyBundles;->data:Ljava/util/List;

    iget-object v2, v0, Lcom/poshmark/data_model/models/MyBundles;->data:Ljava/util/List;

    invoke-interface {v1, v2}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 23
    iget-object v1, v0, Lcom/poshmark/data_model/models/MyBundles;->more:Lcom/poshmark/data_model/models/PMData$NextMaxID;

    iput-object v1, p0, Lcom/poshmark/data_model/models/MyBundles;->more:Lcom/poshmark/data_model/models/PMData$NextMaxID;

    .line 25
    .end local v0    # "newBundles":Lcom/poshmark/data_model/models/MyBundles;
    :cond_0
    return-void
.end method

.method public fillCursor(Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;)V
    .locals 6
    .param p1, "cursor"    # Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    .prologue
    .line 29
    iget-object v2, p0, Lcom/poshmark/data_model/models/MyBundles;->data:Ljava/util/List;

    if-eqz v2, :cond_1

    .line 30
    iget-object v3, p0, Lcom/poshmark/data_model/models/MyBundles;->data:Ljava/util/List;

    monitor-enter v3

    .line 31
    :try_start_0
    iget-object v2, p0, Lcom/poshmark/data_model/models/MyBundles;->data:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 32
    .local v1, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/PMBundle;>;"
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 33
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/PMBundle;

    .line 34
    .local v0, "bundle":Lcom/poshmark/data_model/models/PMBundle;
    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v2, v4

    const/4 v4, 0x1

    aput-object v0, v2, v4

    invoke-virtual {p1, v2}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->addRow([Ljava/lang/Object;)V

    goto :goto_0

    .line 36
    .end local v0    # "bundle":Lcom/poshmark/data_model/models/PMBundle;
    .end local v1    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/PMBundle;>;"
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2

    .restart local v1    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/PMBundle;>;"
    :cond_0
    :try_start_1
    monitor-exit v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 38
    .end local v1    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/PMBundle;>;"
    :cond_1
    return-void
.end method

.method public getNextPageMaxValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/poshmark/data_model/models/MyBundles;->more:Lcom/poshmark/data_model/models/PMData$NextMaxID;

    if-eqz v0, :cond_0

    .line 44
    iget-object v0, p0, Lcom/poshmark/data_model/models/MyBundles;->more:Lcom/poshmark/data_model/models/PMData$NextMaxID;

    iget-object v0, v0, Lcom/poshmark/data_model/models/PMData$NextMaxID;->next_max_id:Ljava/lang/String;

    .line 46
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isEmpty()Z
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/poshmark/data_model/models/MyBundles;->data:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    return v0
.end method
