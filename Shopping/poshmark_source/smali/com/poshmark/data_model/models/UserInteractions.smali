.class public Lcom/poshmark/data_model/models/UserInteractions;
.super Lcom/poshmark/data_model/models/PMData;
.source "UserInteractions.java"


# instance fields
.field data:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/inner_models/UserReference;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 18
    invoke-direct {p0}, Lcom/poshmark/data_model/models/PMData;-><init>()V

    .line 19
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/data_model/models/UserInteractions;->data:Ljava/util/List;

    return-void
.end method


# virtual methods
.method public addContextualData(Lcom/poshmark/data_model/models/ListingSocial;)V
    .locals 10
    .param p1, "listingDetails"    # Lcom/poshmark/data_model/models/ListingSocial;

    .prologue
    .line 64
    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    .line 65
    .local v2, "contextualInteractions":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/poshmark/data_model/models/inner_models/UserReference;>;"
    if-eqz p1, :cond_0

    iget-object v8, p1, Lcom/poshmark/data_model/models/ListingSocial;->comments:Ljava/util/List;

    if-eqz v8, :cond_0

    .line 66
    iget-object v8, p1, Lcom/poshmark/data_model/models/ListingSocial;->comments:Ljava/util/List;

    invoke-interface {v8}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .line 67
    .local v3, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/inner_models/Comment;>;"
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_0

    .line 68
    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/data_model/models/inner_models/Comment;

    .line 69
    .local v1, "comment":Lcom/poshmark/data_model/models/inner_models/Comment;
    new-instance v7, Lcom/poshmark/data_model/models/inner_models/UserReference;

    invoke-direct {v7}, Lcom/poshmark/data_model/models/inner_models/UserReference;-><init>()V

    .line 70
    .local v7, "reference":Lcom/poshmark/data_model/models/inner_models/UserReference;
    invoke-virtual {v1}, Lcom/poshmark/data_model/models/inner_models/Comment;->getCommenterDisplayHandle()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Lcom/poshmark/data_model/models/inner_models/UserReference;->setDisplayHandle(Ljava/lang/String;)V

    .line 71
    iget-object v8, v1, Lcom/poshmark/data_model/models/inner_models/Comment;->creator_id:Ljava/lang/String;

    invoke-interface {v2, v8, v7}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 76
    .end local v1    # "comment":Lcom/poshmark/data_model/models/inner_models/Comment;
    .end local v3    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/inner_models/Comment;>;"
    .end local v7    # "reference":Lcom/poshmark/data_model/models/inner_models/UserReference;
    :cond_0
    if-eqz p1, :cond_1

    iget-object v8, p1, Lcom/poshmark/data_model/models/ListingSocial;->likes:Ljava/util/List;

    if-eqz v8, :cond_1

    .line 77
    iget-object v8, p1, Lcom/poshmark/data_model/models/ListingSocial;->likes:Ljava/util/List;

    invoke-interface {v8}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v5

    .line 78
    .local v5, "itrLikes":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/inner_models/Like;>;"
    :goto_1
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_1

    .line 80
    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/poshmark/data_model/models/inner_models/Like;

    .line 81
    .local v6, "like":Lcom/poshmark/data_model/models/inner_models/Like;
    new-instance v7, Lcom/poshmark/data_model/models/inner_models/UserReference;

    invoke-direct {v7}, Lcom/poshmark/data_model/models/inner_models/UserReference;-><init>()V

    .line 82
    .restart local v7    # "reference":Lcom/poshmark/data_model/models/inner_models/UserReference;
    invoke-virtual {v6}, Lcom/poshmark/data_model/models/inner_models/Like;->getDisplayHandle()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Lcom/poshmark/data_model/models/inner_models/UserReference;->setDisplayHandle(Ljava/lang/String;)V

    .line 83
    iget-object v8, v6, Lcom/poshmark/data_model/models/inner_models/Like;->creator_id:Ljava/lang/String;

    invoke-interface {v2, v8, v7}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    .line 88
    .end local v5    # "itrLikes":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/inner_models/Like;>;"
    .end local v6    # "like":Lcom/poshmark/data_model/models/inner_models/Like;
    .end local v7    # "reference":Lcom/poshmark/data_model/models/inner_models/UserReference;
    :cond_1
    invoke-interface {v2}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v0

    .line 89
    .local v0, "collection":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/poshmark/data_model/models/inner_models/UserReference;>;"
    invoke-interface {v0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .line 90
    .local v4, "itrFinal":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/inner_models/UserReference;>;"
    :goto_2
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_2

    .line 91
    iget-object v8, p0, Lcom/poshmark/data_model/models/UserInteractions;->data:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v9

    invoke-interface {v8, v9}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_2

    .line 93
    :cond_2
    return-void
.end method

.method public fillCursor(Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;)V
    .locals 6
    .param p1, "cursor"    # Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    .prologue
    .line 35
    iget-object v2, p0, Lcom/poshmark/data_model/models/UserInteractions;->data:Ljava/util/List;

    if-eqz v2, :cond_1

    .line 36
    iget-object v3, p0, Lcom/poshmark/data_model/models/UserInteractions;->data:Ljava/util/List;

    monitor-enter v3

    .line 37
    :try_start_0
    iget-object v2, p0, Lcom/poshmark/data_model/models/UserInteractions;->data:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 38
    .local v0, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/inner_models/UserReference;>;"
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 39
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/data_model/models/inner_models/UserReference;

    .line 40
    .local v1, "userRef":Lcom/poshmark/data_model/models/inner_models/UserReference;
    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v2, v4

    const/4 v4, 0x1

    aput-object v1, v2, v4

    invoke-virtual {p1, v2}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->addRow([Ljava/lang/Object;)V

    goto :goto_0

    .line 43
    .end local v0    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/inner_models/UserReference;>;"
    .end local v1    # "userRef":Lcom/poshmark/data_model/models/inner_models/UserReference;
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2

    .restart local v0    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/inner_models/UserReference;>;"
    :cond_0
    :try_start_1
    monitor-exit v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 45
    .end local v0    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/inner_models/UserReference;>;"
    :cond_1
    return-void
.end method

.method public fillFilteredCursor(Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;Ljava/lang/CharSequence;)V
    .locals 6
    .param p1, "cursor"    # Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;
    .param p2, "text"    # Ljava/lang/CharSequence;

    .prologue
    .line 48
    iget-object v2, p0, Lcom/poshmark/data_model/models/UserInteractions;->data:Ljava/util/List;

    if-eqz v2, :cond_2

    .line 49
    iget-object v3, p0, Lcom/poshmark/data_model/models/UserInteractions;->data:Ljava/util/List;

    monitor-enter v3

    .line 50
    :try_start_0
    iget-object v2, p0, Lcom/poshmark/data_model/models/UserInteractions;->data:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 51
    .local v0, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/inner_models/UserReference;>;"
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 52
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/data_model/models/inner_models/UserReference;

    .line 53
    .local v1, "userRef":Lcom/poshmark/data_model/models/inner_models/UserReference;
    invoke-virtual {v1}, Lcom/poshmark/data_model/models/inner_models/UserReference;->getDisplayHandle()Ljava/lang/String;

    move-result-object v2

    invoke-interface {p2}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 54
    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v2, v4

    const/4 v4, 0x1

    aput-object v1, v2, v4

    invoke-virtual {p1, v2}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->addRow([Ljava/lang/Object;)V

    goto :goto_0

    .line 58
    .end local v0    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/inner_models/UserReference;>;"
    .end local v1    # "userRef":Lcom/poshmark/data_model/models/inner_models/UserReference;
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2

    .restart local v0    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/inner_models/UserReference;>;"
    :cond_1
    :try_start_1
    monitor-exit v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 60
    .end local v0    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/inner_models/UserReference;>;"
    :cond_2
    return-void
.end method

.method public getInteractionArray()[Ljava/lang/String;
    .locals 6

    .prologue
    .line 23
    new-instance v2, Ljava/util/ArrayList;

    iget-object v4, p0, Lcom/poshmark/data_model/models/UserInteractions;->data:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v4

    invoke-direct {v2, v4}, Ljava/util/ArrayList;-><init>(I)V

    .line 24
    .local v2, "stringArray":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iget-object v4, p0, Lcom/poshmark/data_model/models/UserInteractions;->data:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 25
    .local v1, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/inner_models/UserReference;>;"
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 26
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/poshmark/data_model/models/inner_models/UserReference;

    .line 27
    .local v3, "userReference":Lcom/poshmark/data_model/models/inner_models/UserReference;
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "@"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/inner_models/UserReference;->getDisplayHandle()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 29
    .end local v3    # "userReference":Lcom/poshmark/data_model/models/inner_models/UserReference;
    :cond_0
    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/String;

    invoke-interface {v2, v4}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Ljava/lang/String;

    .line 30
    .local v0, "arr":[Ljava/lang/String;
    return-object v0
.end method
