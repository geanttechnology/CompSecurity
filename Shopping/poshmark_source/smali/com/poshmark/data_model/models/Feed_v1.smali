.class public Lcom/poshmark/data_model/models/Feed_v1;
.super Lcom/poshmark/data_model/models/PMData;
.source "Feed_v1.java"


# instance fields
.field data:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/ListingSocial;",
            ">;"
        }
    .end annotation
.end field

.field feedHash:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/poshmark/data_model/models/ListingSocial;",
            ">;"
        }
    .end annotation
.end field

.field feedMap:Ljava/util/LinkedHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/LinkedHashMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/poshmark/data_model/models/ListingSocial;",
            ">;"
        }
    .end annotation
.end field

.field more:Lcom/poshmark/data_model/models/PMData$NextMaxID;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 13
    invoke-direct {p0}, Lcom/poshmark/data_model/models/PMData;-><init>()V

    .line 14
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/data_model/models/Feed_v1;->data:Ljava/util/List;

    .line 15
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/data_model/models/Feed_v1;->more:Lcom/poshmark/data_model/models/PMData$NextMaxID;

    .line 16
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/poshmark/data_model/models/Feed_v1;->feedHash:Ljava/util/HashMap;

    .line 17
    new-instance v0, Ljava/util/LinkedHashMap;

    invoke-direct {v0}, Ljava/util/LinkedHashMap;-><init>()V

    iput-object v0, p0, Lcom/poshmark/data_model/models/Feed_v1;->feedMap:Ljava/util/LinkedHashMap;

    return-void
.end method


# virtual methods
.method public addNewComment(Ljava/lang/String;Lcom/poshmark/data_model/models/inner_models/Comment;)V
    .locals 2
    .param p1, "listingId"    # Ljava/lang/String;
    .param p2, "comment"    # Lcom/poshmark/data_model/models/inner_models/Comment;

    .prologue
    .line 114
    iget-object v1, p0, Lcom/poshmark/data_model/models/Feed_v1;->feedMap:Ljava/util/LinkedHashMap;

    invoke-virtual {v1, p1}, Ljava/util/LinkedHashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 115
    iget-object v1, p0, Lcom/poshmark/data_model/models/Feed_v1;->feedMap:Ljava/util/LinkedHashMap;

    invoke-virtual {v1, p1}, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/ListingSocial;

    .line 116
    .local v0, "currentListing":Lcom/poshmark/data_model/models/ListingSocial;
    invoke-virtual {v0, p2}, Lcom/poshmark/data_model/models/ListingSocial;->addComment(Lcom/poshmark/data_model/models/inner_models/Comment;)V

    .line 118
    .end local v0    # "currentListing":Lcom/poshmark/data_model/models/ListingSocial;
    :cond_0
    return-void
.end method

.method public append(Lcom/poshmark/data_model/models/PMData;)V
    .locals 7
    .param p1, "newData"    # Lcom/poshmark/data_model/models/PMData;

    .prologue
    .line 50
    iget-object v5, p0, Lcom/poshmark/data_model/models/Feed_v1;->data:Ljava/util/List;

    if-eqz v5, :cond_2

    if-eqz p1, :cond_2

    move-object v2, p1

    .line 51
    check-cast v2, Lcom/poshmark/data_model/models/Feed_v1;

    .line 54
    .local v2, "newFeed":Lcom/poshmark/data_model/models/Feed_v1;
    invoke-virtual {v2}, Lcom/poshmark/data_model/models/Feed_v1;->getFeedList()Ljava/util/List;

    move-result-object v4

    .line 55
    .local v4, "newList":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/ListingSocial;>;"
    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 56
    .local v1, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/ListingSocial;>;"
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_1

    .line 57
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/poshmark/data_model/models/ListingSocial;

    .line 58
    .local v3, "newItem":Lcom/poshmark/data_model/models/ListingSocial;
    iget-object v5, p0, Lcom/poshmark/data_model/models/Feed_v1;->feedMap:Ljava/util/LinkedHashMap;

    iget-object v6, v3, Lcom/poshmark/data_model/models/ListingSocial;->id:Ljava/lang/String;

    invoke-virtual {v5, v6, v3}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/ListingSocial;

    .line 59
    .local v0, "existingItem":Lcom/poshmark/data_model/models/ListingSocial;
    if-eqz v0, :cond_0

    .line 61
    invoke-interface {v1}, Ljava/util/Iterator;->remove()V

    goto :goto_0

    .line 64
    .end local v0    # "existingItem":Lcom/poshmark/data_model/models/ListingSocial;
    .end local v3    # "newItem":Lcom/poshmark/data_model/models/ListingSocial;
    :cond_1
    iget-object v5, p0, Lcom/poshmark/data_model/models/Feed_v1;->data:Ljava/util/List;

    iget-object v6, v2, Lcom/poshmark/data_model/models/Feed_v1;->data:Ljava/util/List;

    invoke-interface {v5, v6}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 65
    iget-object v5, v2, Lcom/poshmark/data_model/models/Feed_v1;->more:Lcom/poshmark/data_model/models/PMData$NextMaxID;

    iput-object v5, p0, Lcom/poshmark/data_model/models/Feed_v1;->more:Lcom/poshmark/data_model/models/PMData$NextMaxID;

    .line 67
    .end local v1    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/ListingSocial;>;"
    .end local v2    # "newFeed":Lcom/poshmark/data_model/models/Feed_v1;
    .end local v4    # "newList":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/ListingSocial;>;"
    :cond_2
    return-void
.end method

.method public createHashAndRemoveDups()V
    .locals 5

    .prologue
    .line 21
    iget-object v3, p0, Lcom/poshmark/data_model/models/Feed_v1;->data:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 22
    .local v1, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/ListingSocial;>;"
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 23
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/ListingSocial;

    .line 24
    .local v0, "item":Lcom/poshmark/data_model/models/ListingSocial;
    iget-object v3, p0, Lcom/poshmark/data_model/models/Feed_v1;->feedMap:Ljava/util/LinkedHashMap;

    iget-object v4, v0, Lcom/poshmark/data_model/models/ListingSocial;->id:Ljava/lang/String;

    invoke-virtual {v3, v4, v0}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/poshmark/data_model/models/ListingSocial;

    .line 25
    .local v2, "prevItem":Lcom/poshmark/data_model/models/ListingSocial;
    if-eqz v2, :cond_0

    .line 27
    invoke-interface {v1}, Ljava/util/Iterator;->remove()V

    goto :goto_0

    .line 30
    .end local v0    # "item":Lcom/poshmark/data_model/models/ListingSocial;
    .end local v2    # "prevItem":Lcom/poshmark/data_model/models/ListingSocial;
    :cond_1
    return-void
.end method

.method public deleteListing(Ljava/lang/String;)V
    .locals 1
    .param p1, "listingId"    # Ljava/lang/String;

    .prologue
    .line 128
    iget-object v0, p0, Lcom/poshmark/data_model/models/Feed_v1;->feedMap:Ljava/util/LinkedHashMap;

    invoke-virtual {v0, p1}, Ljava/util/LinkedHashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 129
    iget-object v0, p0, Lcom/poshmark/data_model/models/Feed_v1;->feedMap:Ljava/util/LinkedHashMap;

    invoke-virtual {v0, p1}, Ljava/util/LinkedHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 132
    :cond_0
    return-void
.end method

.method public fillCursor(Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;)V
    .locals 7
    .param p1, "cursor"    # Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    .prologue
    .line 84
    iget-object v3, p0, Lcom/poshmark/data_model/models/Feed_v1;->data:Ljava/util/List;

    if-eqz v3, :cond_1

    .line 85
    iget-object v4, p0, Lcom/poshmark/data_model/models/Feed_v1;->feedMap:Ljava/util/LinkedHashMap;

    monitor-enter v4

    .line 86
    :try_start_0
    iget-object v3, p0, Lcom/poshmark/data_model/models/Feed_v1;->feedMap:Ljava/util/LinkedHashMap;

    invoke-virtual {v3}, Ljava/util/LinkedHashMap;->entrySet()Ljava/util/Set;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 87
    .local v0, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/poshmark/data_model/models/ListingSocial;>;"
    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/data_model/models/ListingSocial;

    .line 88
    .local v1, "feedItem":Lcom/poshmark/data_model/models/ListingSocial;
    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v5, 0x0

    const/4 v6, 0x0

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v3, v5

    const/4 v5, 0x1

    aput-object v1, v3, v5

    invoke-virtual {p1, v3}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->addRow([Ljava/lang/Object;)V

    goto :goto_0

    .line 90
    .end local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/poshmark/data_model/models/ListingSocial;>;"
    .end local v1    # "feedItem":Lcom/poshmark/data_model/models/ListingSocial;
    .end local v2    # "i$":Ljava/util/Iterator;
    :catchall_0
    move-exception v3

    monitor-exit v4
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v3

    .restart local v2    # "i$":Ljava/util/Iterator;
    :cond_0
    :try_start_1
    monitor-exit v4
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 92
    .end local v2    # "i$":Ljava/util/Iterator;
    :cond_1
    return-void
.end method

.method public getFeedList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/ListingSocial;",
            ">;"
        }
    .end annotation

    .prologue
    .line 34
    iget-object v0, p0, Lcom/poshmark/data_model/models/Feed_v1;->data:Ljava/util/List;

    return-object v0
.end method

.method public getNextPageMaxValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 96
    iget-object v0, p0, Lcom/poshmark/data_model/models/Feed_v1;->more:Lcom/poshmark/data_model/models/PMData$NextMaxID;

    if-eqz v0, :cond_0

    .line 97
    iget-object v0, p0, Lcom/poshmark/data_model/models/Feed_v1;->more:Lcom/poshmark/data_model/models/PMData$NextMaxID;

    iget-object v0, v0, Lcom/poshmark/data_model/models/PMData$NextMaxID;->next_max_id:Ljava/lang/String;

    .line 99
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isEmpty()Z
    .locals 1

    .prologue
    .line 135
    iget-object v0, p0, Lcom/poshmark/data_model/models/Feed_v1;->data:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    return v0
.end method

.method public setNextMaxId(Ljava/lang/String;)V
    .locals 1
    .param p1, "nextMaxId"    # Ljava/lang/String;

    .prologue
    .line 45
    iget-object v0, p0, Lcom/poshmark/data_model/models/Feed_v1;->more:Lcom/poshmark/data_model/models/PMData$NextMaxID;

    iput-object p1, v0, Lcom/poshmark/data_model/models/PMData$NextMaxID;->next_max_id:Ljava/lang/String;

    .line 46
    return-void
.end method

.method public updateLikeStatus(Ljava/lang/String;Z)V
    .locals 2
    .param p1, "listingId"    # Ljava/lang/String;
    .param p2, "likeStatus"    # Z

    .prologue
    .line 121
    iget-object v1, p0, Lcom/poshmark/data_model/models/Feed_v1;->feedMap:Ljava/util/LinkedHashMap;

    invoke-virtual {v1, p1}, Ljava/util/LinkedHashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 122
    iget-object v1, p0, Lcom/poshmark/data_model/models/Feed_v1;->feedMap:Ljava/util/LinkedHashMap;

    invoke-virtual {v1, p1}, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/ListingSocial;

    .line 123
    .local v0, "currentListing":Lcom/poshmark/data_model/models/ListingSocial;
    invoke-virtual {v0, p2}, Lcom/poshmark/data_model/models/ListingSocial;->setListingLikeStatus(Z)V

    .line 125
    .end local v0    # "currentListing":Lcom/poshmark/data_model/models/ListingSocial;
    :cond_0
    return-void
.end method

.method public updateListing(Lcom/poshmark/data_model/models/ListingDetails;)V
    .locals 3
    .param p1, "listing"    # Lcom/poshmark/data_model/models/ListingDetails;

    .prologue
    .line 107
    iget-object v1, p0, Lcom/poshmark/data_model/models/Feed_v1;->feedMap:Ljava/util/LinkedHashMap;

    invoke-virtual {p1}, Lcom/poshmark/data_model/models/ListingDetails;->getIdAsString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/LinkedHashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 108
    iget-object v1, p0, Lcom/poshmark/data_model/models/Feed_v1;->feedMap:Ljava/util/LinkedHashMap;

    invoke-virtual {p1}, Lcom/poshmark/data_model/models/ListingDetails;->getIdAsString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/ListingSocial;

    .line 109
    .local v0, "currentListing":Lcom/poshmark/data_model/models/ListingSocial;
    invoke-virtual {v0, p1}, Lcom/poshmark/data_model/models/ListingSocial;->copy(Lcom/poshmark/data_model/models/ListingDetails;)V

    .line 111
    .end local v0    # "currentListing":Lcom/poshmark/data_model/models/ListingSocial;
    :cond_0
    return-void
.end method
