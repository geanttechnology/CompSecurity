.class public Lcom/poshmark/data_model/models/ListingSocial;
.super Lcom/poshmark/data_model/models/ListingSummary;
.source "ListingSocial.java"


# instance fields
.field comments:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/inner_models/Comment;",
            ">;"
        }
    .end annotation
.end field

.field event_context:Lcom/poshmark/data_model/models/EventContext;

.field feed_context:Lcom/poshmark/data_model/models/inner_models/FeedContext;

.field likes:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/inner_models/Like;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Lcom/poshmark/data_model/models/ListingSummary;-><init>()V

    return-void
.end method

.method private copyComments(Lcom/poshmark/data_model/models/ListingDetails;)V
    .locals 6
    .param p1, "newListing"    # Lcom/poshmark/data_model/models/ListingDetails;

    .prologue
    .line 75
    invoke-virtual {p1}, Lcom/poshmark/data_model/models/ListingDetails;->getComments()Ljava/util/List;

    move-result-object v3

    .line 77
    .local v3, "newCommentsList":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/inner_models/Comment;>;"
    iget-object v5, p0, Lcom/poshmark/data_model/models/ListingSocial;->comments:Ljava/util/List;

    if-eqz v5, :cond_0

    .line 78
    iget-object v5, p0, Lcom/poshmark/data_model/models/ListingSocial;->comments:Ljava/util/List;

    invoke-interface {v5}, Ljava/util/List;->clear()V

    .line 81
    :cond_0
    if-eqz v3, :cond_2

    .line 83
    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v4

    .line 84
    .local v4, "numNewComments":I
    if-lez v4, :cond_2

    .line 85
    iget-object v5, p0, Lcom/poshmark/data_model/models/ListingSocial;->comments:Ljava/util/List;

    if-nez v5, :cond_1

    .line 86
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    iput-object v5, p0, Lcom/poshmark/data_model/models/ListingSocial;->comments:Ljava/util/List;

    .line 88
    :cond_1
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v4, :cond_2

    .line 89
    invoke-interface {v3, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/poshmark/data_model/models/inner_models/Comment;

    .line 90
    .local v2, "newComment":Lcom/poshmark/data_model/models/inner_models/Comment;
    new-instance v0, Lcom/poshmark/data_model/models/inner_models/Comment;

    invoke-direct {v0}, Lcom/poshmark/data_model/models/inner_models/Comment;-><init>()V

    .line 91
    .local v0, "comment":Lcom/poshmark/data_model/models/inner_models/Comment;
    invoke-virtual {v0, v2}, Lcom/poshmark/data_model/models/inner_models/Comment;->copy(Lcom/poshmark/data_model/models/inner_models/Comment;)V

    .line 92
    iget-object v5, p0, Lcom/poshmark/data_model/models/ListingSocial;->comments:Ljava/util/List;

    invoke-interface {v5, v1, v0}, Ljava/util/List;->add(ILjava/lang/Object;)V

    .line 88
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 96
    .end local v0    # "comment":Lcom/poshmark/data_model/models/inner_models/Comment;
    .end local v1    # "i":I
    .end local v2    # "newComment":Lcom/poshmark/data_model/models/inner_models/Comment;
    .end local v4    # "numNewComments":I
    :cond_2
    return-void
.end method

.method private copyLikes(Lcom/poshmark/data_model/models/ListingDetails;)V
    .locals 6
    .param p1, "newListing"    # Lcom/poshmark/data_model/models/ListingDetails;

    .prologue
    .line 99
    invoke-virtual {p1}, Lcom/poshmark/data_model/models/ListingDetails;->getLikes()Ljava/util/List;

    move-result-object v3

    .line 101
    .local v3, "newLikesList":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/inner_models/Like;>;"
    iget-object v5, p0, Lcom/poshmark/data_model/models/ListingSocial;->likes:Ljava/util/List;

    if-eqz v5, :cond_0

    .line 102
    iget-object v5, p0, Lcom/poshmark/data_model/models/ListingSocial;->likes:Ljava/util/List;

    invoke-interface {v5}, Ljava/util/List;->clear()V

    .line 105
    :cond_0
    if-eqz v3, :cond_2

    .line 106
    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v4

    .line 107
    .local v4, "numNewLikes":I
    if-lez v4, :cond_2

    .line 108
    iget-object v5, p0, Lcom/poshmark/data_model/models/ListingSocial;->likes:Ljava/util/List;

    if-nez v5, :cond_1

    .line 109
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    iput-object v5, p0, Lcom/poshmark/data_model/models/ListingSocial;->likes:Ljava/util/List;

    .line 111
    :cond_1
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, v4, :cond_2

    .line 112
    invoke-interface {v3, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/poshmark/data_model/models/inner_models/Like;

    .line 113
    .local v2, "newLike":Lcom/poshmark/data_model/models/inner_models/Like;
    new-instance v1, Lcom/poshmark/data_model/models/inner_models/Like;

    invoke-direct {v1}, Lcom/poshmark/data_model/models/inner_models/Like;-><init>()V

    .line 114
    .local v1, "like":Lcom/poshmark/data_model/models/inner_models/Like;
    invoke-virtual {v1, v2}, Lcom/poshmark/data_model/models/inner_models/Like;->copy(Lcom/poshmark/data_model/models/inner_models/Like;)V

    .line 115
    iget-object v5, p0, Lcom/poshmark/data_model/models/ListingSocial;->likes:Ljava/util/List;

    invoke-interface {v5, v0, v1}, Ljava/util/List;->add(ILjava/lang/Object;)V

    .line 111
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 121
    .end local v0    # "i":I
    .end local v1    # "like":Lcom/poshmark/data_model/models/inner_models/Like;
    .end local v2    # "newLike":Lcom/poshmark/data_model/models/inner_models/Like;
    .end local v4    # "numNewLikes":I
    :cond_2
    return-void
.end method


# virtual methods
.method public addComment(Lcom/poshmark/data_model/models/inner_models/Comment;)V
    .locals 3
    .param p1, "newComment"    # Lcom/poshmark/data_model/models/inner_models/Comment;

    .prologue
    .line 124
    iget-object v1, p0, Lcom/poshmark/data_model/models/ListingSocial;->comments:Ljava/util/List;

    if-nez v1, :cond_0

    .line 125
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, p0, Lcom/poshmark/data_model/models/ListingSocial;->comments:Ljava/util/List;

    .line 127
    :cond_0
    new-instance v0, Lcom/poshmark/data_model/models/inner_models/Comment;

    invoke-direct {v0}, Lcom/poshmark/data_model/models/inner_models/Comment;-><init>()V

    .line 128
    .local v0, "comment":Lcom/poshmark/data_model/models/inner_models/Comment;
    invoke-virtual {v0, p1}, Lcom/poshmark/data_model/models/inner_models/Comment;->copy(Lcom/poshmark/data_model/models/inner_models/Comment;)V

    .line 129
    iget-object v1, p0, Lcom/poshmark/data_model/models/ListingSocial;->comments:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 130
    iget-object v1, p0, Lcom/poshmark/data_model/models/ListingSocial;->aggregates:Lcom/poshmark/data_model/models/inner_models/ListingAggregates;

    iget v2, v1, Lcom/poshmark/data_model/models/inner_models/ListingAggregates;->comments:I

    add-int/lit8 v2, v2, 0x1

    iput v2, v1, Lcom/poshmark/data_model/models/inner_models/ListingAggregates;->comments:I

    .line 131
    return-void
.end method

.method public copy(Lcom/poshmark/data_model/models/ListingDetails;)V
    .locals 2
    .param p1, "listing"    # Lcom/poshmark/data_model/models/ListingDetails;

    .prologue
    .line 59
    invoke-super {p0, p1}, Lcom/poshmark/data_model/models/ListingSummary;->copy(Lcom/poshmark/data_model/models/ListingDetails;)V

    .line 60
    invoke-direct {p0, p1}, Lcom/poshmark/data_model/models/ListingSocial;->copyComments(Lcom/poshmark/data_model/models/ListingDetails;)V

    .line 61
    invoke-direct {p0, p1}, Lcom/poshmark/data_model/models/ListingSocial;->copyLikes(Lcom/poshmark/data_model/models/ListingDetails;)V

    .line 63
    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingSocial;->feed_context:Lcom/poshmark/data_model/models/inner_models/FeedContext;

    if-eqz v0, :cond_0

    .line 64
    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingSocial;->feed_context:Lcom/poshmark/data_model/models/inner_models/FeedContext;

    iget-object v1, p1, Lcom/poshmark/data_model/models/ListingDetails;->feed_context:Lcom/poshmark/data_model/models/inner_models/FeedContext;

    invoke-virtual {v0, v1}, Lcom/poshmark/data_model/models/inner_models/FeedContext;->copy(Lcom/poshmark/data_model/models/inner_models/FeedContext;)V

    .line 67
    :cond_0
    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingSocial;->event_context:Lcom/poshmark/data_model/models/EventContext;

    if-eqz v0, :cond_1

    .line 68
    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingSocial;->event_context:Lcom/poshmark/data_model/models/EventContext;

    iget-object v1, p1, Lcom/poshmark/data_model/models/ListingDetails;->event_context:Lcom/poshmark/data_model/models/EventContext;

    invoke-virtual {v0, v1}, Lcom/poshmark/data_model/models/EventContext;->copy(Lcom/poshmark/data_model/models/EventContext;)V

    .line 71
    :cond_1
    return-void
.end method

.method public deleteComment(I)V
    .locals 2
    .param p1, "index"    # I

    .prologue
    .line 134
    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingSocial;->comments:Ljava/util/List;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingSocial;->comments:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-le v0, p1, :cond_0

    .line 135
    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingSocial;->comments:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    .line 137
    :cond_0
    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingSocial;->aggregates:Lcom/poshmark/data_model/models/inner_models/ListingAggregates;

    iget v1, v0, Lcom/poshmark/data_model/models/inner_models/ListingAggregates;->comments:I

    add-int/lit8 v1, v1, -0x1

    iput v1, v0, Lcom/poshmark/data_model/models/inner_models/ListingAggregates;->comments:I

    .line 138
    return-void
.end method

.method public fillCursorForComments(Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;)V
    .locals 6
    .param p1, "cursor"    # Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    .prologue
    .line 168
    iget-object v2, p0, Lcom/poshmark/data_model/models/ListingSocial;->comments:Ljava/util/List;

    if-eqz v2, :cond_1

    .line 169
    iget-object v3, p0, Lcom/poshmark/data_model/models/ListingSocial;->comments:Ljava/util/List;

    monitor-enter v3

    .line 170
    :try_start_0
    iget-object v2, p0, Lcom/poshmark/data_model/models/ListingSocial;->comments:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/inner_models/Comment;

    .line 171
    .local v0, "c":Lcom/poshmark/data_model/models/inner_models/Comment;
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

    .line 173
    .end local v0    # "c":Lcom/poshmark/data_model/models/inner_models/Comment;
    .end local v1    # "i$":Ljava/util/Iterator;
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2

    .restart local v1    # "i$":Ljava/util/Iterator;
    :cond_0
    :try_start_1
    monitor-exit v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 175
    .end local v1    # "i$":Ljava/util/Iterator;
    :cond_1
    return-void
.end method

.method public getComments()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/inner_models/Comment;",
            ">;"
        }
    .end annotation

    .prologue
    .line 51
    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingSocial;->comments:Ljava/util/List;

    return-object v0
.end method

.method public getEventContext()Lcom/poshmark/data_model/models/EventContext;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingSocial;->event_context:Lcom/poshmark/data_model/models/EventContext;

    return-object v0
.end method

.method public getLikes()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/inner_models/Like;",
            ">;"
        }
    .end annotation

    .prologue
    .line 55
    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingSocial;->likes:Ljava/util/List;

    return-object v0
.end method

.method public getSharedAtTime()Ljava/lang/String;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingSocial;->feed_context:Lcom/poshmark/data_model/models/inner_models/FeedContext;

    if-eqz v0, :cond_0

    .line 30
    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingSocial;->feed_context:Lcom/poshmark/data_model/models/inner_models/FeedContext;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/FeedContext;->shared_at:Ljava/lang/String;

    .line 32
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getSharedByUserName()Ljava/lang/String;
    .locals 2

    .prologue
    .line 21
    const/4 v0, 0x0

    .line 22
    .local v0, "sharedByUserName":Ljava/lang/String;
    iget-object v1, p0, Lcom/poshmark/data_model/models/ListingSocial;->feed_context:Lcom/poshmark/data_model/models/inner_models/FeedContext;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/data_model/models/ListingSocial;->feed_context:Lcom/poshmark/data_model/models/inner_models/FeedContext;

    iget-boolean v1, v1, Lcom/poshmark/data_model/models/inner_models/FeedContext;->shared:Z

    if-eqz v1, :cond_0

    .line 23
    iget-object v1, p0, Lcom/poshmark/data_model/models/ListingSocial;->feed_context:Lcom/poshmark/data_model/models/inner_models/FeedContext;

    iget-object v0, v1, Lcom/poshmark/data_model/models/inner_models/FeedContext;->shared_by_username:Ljava/lang/String;

    .line 25
    :cond_0
    return-object v0
.end method

.method public hasEventContext()Z
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingSocial;->event_context:Lcom/poshmark/data_model/models/EventContext;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public hasFeedContext()Z
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingSocial;->feed_context:Lcom/poshmark/data_model/models/inner_models/FeedContext;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public setListingLikeStatus(Z)V
    .locals 5
    .param p1, "likeStatus"    # Z

    .prologue
    .line 142
    invoke-super {p0, p1}, Lcom/poshmark/data_model/models/ListingSummary;->setListingLikeStatus(Z)V

    .line 145
    iget-object v3, p0, Lcom/poshmark/data_model/models/ListingSocial;->likes:Ljava/util/List;

    if-eqz v3, :cond_0

    .line 146
    if-eqz p1, :cond_1

    .line 148
    new-instance v2, Lcom/poshmark/data_model/models/inner_models/Like;

    invoke-direct {v2}, Lcom/poshmark/data_model/models/inner_models/Like;-><init>()V

    .line 149
    .local v2, "newLike":Lcom/poshmark/data_model/models/inner_models/Like;
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/application/PMApplicationSession;->getDisplayHandle()Ljava/lang/String;

    move-result-object v3

    iput-object v3, v2, Lcom/poshmark/data_model/models/inner_models/Like;->creator_display_handle:Ljava/lang/String;

    .line 150
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v3

    iput-object v3, v2, Lcom/poshmark/data_model/models/inner_models/Like;->creator_id:Ljava/lang/String;

    .line 151
    iget-object v3, p0, Lcom/poshmark/data_model/models/ListingSocial;->likes:Ljava/util/List;

    invoke-interface {v3, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 152
    iget-object v3, p0, Lcom/poshmark/data_model/models/ListingSocial;->aggregates:Lcom/poshmark/data_model/models/inner_models/ListingAggregates;

    iget v4, v3, Lcom/poshmark/data_model/models/inner_models/ListingAggregates;->likes:I

    add-int/lit8 v4, v4, 0x1

    iput v4, v3, Lcom/poshmark/data_model/models/inner_models/ListingAggregates;->likes:I

    .line 165
    .end local v2    # "newLike":Lcom/poshmark/data_model/models/inner_models/Like;
    :cond_0
    return-void

    .line 155
    :cond_1
    iget-object v3, p0, Lcom/poshmark/data_model/models/ListingSocial;->likes:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 156
    .local v0, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/inner_models/Like;>;"
    :cond_2
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 157
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/data_model/models/inner_models/Like;

    .line 158
    .local v1, "like":Lcom/poshmark/data_model/models/inner_models/Like;
    iget-object v3, v1, Lcom/poshmark/data_model/models/inner_models/Like;->creator_id:Ljava/lang/String;

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 159
    invoke-interface {v0}, Ljava/util/Iterator;->remove()V

    .line 160
    iget-object v3, p0, Lcom/poshmark/data_model/models/ListingSocial;->aggregates:Lcom/poshmark/data_model/models/inner_models/ListingAggregates;

    iget v4, v3, Lcom/poshmark/data_model/models/inner_models/ListingAggregates;->likes:I

    add-int/lit8 v4, v4, -0x1

    iput v4, v3, Lcom/poshmark/data_model/models/inner_models/ListingAggregates;->likes:I

    goto :goto_0
.end method
