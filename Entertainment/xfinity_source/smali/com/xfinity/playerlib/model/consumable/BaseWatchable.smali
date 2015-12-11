.class public abstract Lcom/xfinity/playerlib/model/consumable/BaseWatchable;
.super Ljava/lang/Object;
.source "BaseWatchable.java"

# interfaces
.implements Lcom/xfinity/playerlib/model/consumable/Watchable;


# instance fields
.field private expiresDate:Ljava/util/Date;

.field private hasDownloadableVideo:Z

.field private sortTitle:Ljava/lang/String;

.field private videoRating:Lcom/comcast/cim/model/Rating;

.field private videoSubRatings:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/xfinity/playerlib/model/consumable/BaseWatchable;->hasDownloadableVideo:Z

    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 5
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 119
    if-ne p0, p1, :cond_1

    .line 139
    :cond_0
    :goto_0
    return v1

    .line 122
    :cond_1
    if-eqz p1, :cond_2

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    if-eq v3, v4, :cond_3

    :cond_2
    move v1, v2

    .line 123
    goto :goto_0

    :cond_3
    move-object v0, p1

    .line 125
    check-cast v0, Lcom/xfinity/playerlib/model/consumable/BaseWatchable;

    .line 126
    .local v0, "that":Lcom/xfinity/playerlib/model/consumable/BaseWatchable;
    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/BaseWatchable;->expiresDate:Ljava/util/Date;

    if-eqz v3, :cond_5

    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/BaseWatchable;->expiresDate:Ljava/util/Date;

    iget-object v4, v0, Lcom/xfinity/playerlib/model/consumable/BaseWatchable;->expiresDate:Ljava/util/Date;

    invoke-virtual {v3, v4}, Ljava/util/Date;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_6

    :cond_4
    move v1, v2

    .line 127
    goto :goto_0

    .line 126
    :cond_5
    iget-object v3, v0, Lcom/xfinity/playerlib/model/consumable/BaseWatchable;->expiresDate:Ljava/util/Date;

    if-nez v3, :cond_4

    .line 129
    :cond_6
    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/BaseWatchable;->sortTitle:Ljava/lang/String;

    if-eqz v3, :cond_8

    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/BaseWatchable;->sortTitle:Ljava/lang/String;

    iget-object v4, v0, Lcom/xfinity/playerlib/model/consumable/BaseWatchable;->sortTitle:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_9

    :cond_7
    move v1, v2

    .line 130
    goto :goto_0

    .line 129
    :cond_8
    iget-object v3, v0, Lcom/xfinity/playerlib/model/consumable/BaseWatchable;->sortTitle:Ljava/lang/String;

    if-nez v3, :cond_7

    .line 132
    :cond_9
    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/BaseWatchable;->videoRating:Lcom/comcast/cim/model/Rating;

    if-eqz v3, :cond_b

    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/BaseWatchable;->videoRating:Lcom/comcast/cim/model/Rating;

    iget-object v4, v0, Lcom/xfinity/playerlib/model/consumable/BaseWatchable;->videoRating:Lcom/comcast/cim/model/Rating;

    invoke-virtual {v3, v4}, Lcom/comcast/cim/model/Rating;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_c

    :cond_a
    move v1, v2

    .line 133
    goto :goto_0

    .line 132
    :cond_b
    iget-object v3, v0, Lcom/xfinity/playerlib/model/consumable/BaseWatchable;->videoRating:Lcom/comcast/cim/model/Rating;

    if-nez v3, :cond_a

    .line 136
    :cond_c
    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/BaseWatchable;->videoSubRatings:Ljava/lang/String;

    if-eqz v3, :cond_d

    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/BaseWatchable;->videoSubRatings:Ljava/lang/String;

    iget-object v4, v0, Lcom/xfinity/playerlib/model/consumable/BaseWatchable;->videoSubRatings:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    :goto_1
    move v1, v2

    .line 137
    goto :goto_0

    .line 136
    :cond_d
    iget-object v3, v0, Lcom/xfinity/playerlib/model/consumable/BaseWatchable;->videoSubRatings:Ljava/lang/String;

    if-eqz v3, :cond_0

    goto :goto_1
.end method

.method public findVideoById(J)Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .locals 5
    .param p1, "id"    # J

    .prologue
    .line 104
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/consumable/BaseWatchable;->getVideos()Ljava/util/Set;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    .line 105
    .local v0, "videoFacade":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getVideoId()J

    move-result-wide v2

    cmp-long v2, v2, p1

    if-nez v2, :cond_0

    .line 109
    .end local v0    # "videoFacade":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    :goto_0
    return-object v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getExpiresDate()Ljava/util/Date;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/BaseWatchable;->expiresDate:Ljava/util/Date;

    return-object v0
.end method

.method public getLanguageCodes()Ljava/util/Set;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 45
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    .line 47
    .local v0, "languages":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/consumable/BaseWatchable;->getVideos()Ljava/util/Set;

    move-result-object v2

    if-eqz v2, :cond_1

    .line 48
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/consumable/BaseWatchable;->getVideos()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    .line 49
    .local v1, "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getLanguageCodes()Ljava/util/List;

    move-result-object v3

    if-eqz v3, :cond_0

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getLanguageCodes()Ljava/util/List;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/List;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_0

    .line 50
    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getLanguageCodes()Ljava/util/List;

    move-result-object v3

    const/4 v4, 0x0

    invoke-interface {v3, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    invoke-interface {v0, v3}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 54
    .end local v1    # "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    :cond_1
    return-object v0
.end method

.method public getNextItemDisplayTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 100
    const/4 v0, 0x0

    return-object v0
.end method

.method public getNextVideoItem(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Ljava/lang/String;)Lcom/comcast/cim/cmasl/utils/container/Tuple;
    .locals 1
    .param p1, "videoFacade"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .param p2, "language"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/xfinity/playerlib/model/consumable/VideoFacade;",
            "Ljava/lang/String;",
            ")",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/VideoFacade;",
            "Lcom/xfinity/playerlib/model/consumable/Watchable;",
            ">;"
        }
    .end annotation

    .prologue
    .line 95
    const/4 v0, 0x0

    return-object v0
.end method

.method public getSortTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 86
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/BaseWatchable;->sortTitle:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 87
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/consumable/BaseWatchable;->getDisplayTitle()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/comcast/cim/utils/UIPresentationUtil;->getSortStringFromTitle(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/consumable/BaseWatchable;->sortTitle:Ljava/lang/String;

    .line 90
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/BaseWatchable;->sortTitle:Ljava/lang/String;

    return-object v0
.end method

.method public getVideoRating()Lcom/comcast/cim/model/Rating;
    .locals 1

    .prologue
    .line 59
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/BaseWatchable;->videoRating:Lcom/comcast/cim/model/Rating;

    return-object v0
.end method

.method public getVideoSubRatings()Ljava/lang/String;
    .locals 1

    .prologue
    .line 64
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/BaseWatchable;->videoSubRatings:Ljava/lang/String;

    return-object v0
.end method

.method public hasDownloadableVideo()Z
    .locals 1

    .prologue
    .line 114
    iget-boolean v0, p0, Lcom/xfinity/playerlib/model/consumable/BaseWatchable;->hasDownloadableVideo:Z

    return v0
.end method

.method public hashCode()I
    .locals 4

    .prologue
    const/4 v1, 0x0

    .line 144
    iget-object v2, p0, Lcom/xfinity/playerlib/model/consumable/BaseWatchable;->videoRating:Lcom/comcast/cim/model/Rating;

    if-eqz v2, :cond_1

    iget-object v2, p0, Lcom/xfinity/playerlib/model/consumable/BaseWatchable;->videoRating:Lcom/comcast/cim/model/Rating;

    invoke-virtual {v2}, Lcom/comcast/cim/model/Rating;->hashCode()I

    move-result v0

    .line 145
    .local v0, "result":I
    :goto_0
    mul-int/lit8 v3, v0, 0x1f

    iget-object v2, p0, Lcom/xfinity/playerlib/model/consumable/BaseWatchable;->videoSubRatings:Ljava/lang/String;

    if-eqz v2, :cond_2

    iget-object v2, p0, Lcom/xfinity/playerlib/model/consumable/BaseWatchable;->videoSubRatings:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->hashCode()I

    move-result v2

    :goto_1
    add-int v0, v3, v2

    .line 146
    mul-int/lit8 v3, v0, 0x1f

    iget-object v2, p0, Lcom/xfinity/playerlib/model/consumable/BaseWatchable;->expiresDate:Ljava/util/Date;

    if-eqz v2, :cond_3

    iget-object v2, p0, Lcom/xfinity/playerlib/model/consumable/BaseWatchable;->expiresDate:Ljava/util/Date;

    invoke-virtual {v2}, Ljava/util/Date;->hashCode()I

    move-result v2

    :goto_2
    add-int v0, v3, v2

    .line 147
    mul-int/lit8 v2, v0, 0x1f

    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/BaseWatchable;->sortTitle:Ljava/lang/String;

    if-eqz v3, :cond_0

    iget-object v1, p0, Lcom/xfinity/playerlib/model/consumable/BaseWatchable;->sortTitle:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    :cond_0
    add-int v0, v2, v1

    .line 148
    return v0

    .end local v0    # "result":I
    :cond_1
    move v0, v1

    .line 144
    goto :goto_0

    .restart local v0    # "result":I
    :cond_2
    move v2, v1

    .line 145
    goto :goto_1

    :cond_3
    move v2, v1

    .line 146
    goto :goto_2
.end method

.method protected initFromVideos()V
    .locals 4

    .prologue
    .line 23
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/consumable/BaseWatchable;->getVideos()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_3

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    .line 25
    .local v0, "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getVideoRating()Lcom/comcast/cim/model/Rating;

    move-result-object v3

    iput-object v3, p0, Lcom/xfinity/playerlib/model/consumable/BaseWatchable;->videoRating:Lcom/comcast/cim/model/Rating;

    .line 26
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getVideoSubRating()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lcom/xfinity/playerlib/model/consumable/BaseWatchable;->videoSubRatings:Ljava/lang/String;

    .line 28
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getExpirationDate()Ljava/util/Date;

    move-result-object v1

    .line 29
    .local v1, "videoExpirationDate":Ljava/util/Date;
    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/BaseWatchable;->expiresDate:Ljava/util/Date;

    if-eqz v3, :cond_1

    if-eqz v1, :cond_2

    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/BaseWatchable;->expiresDate:Ljava/util/Date;

    invoke-virtual {v1, v3}, Ljava/util/Date;->after(Ljava/util/Date;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 30
    :cond_1
    iput-object v1, p0, Lcom/xfinity/playerlib/model/consumable/BaseWatchable;->expiresDate:Ljava/util/Date;

    .line 33
    :cond_2
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->isDownloadable()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 34
    const/4 v3, 0x1

    iput-boolean v3, p0, Lcom/xfinity/playerlib/model/consumable/BaseWatchable;->hasDownloadableVideo:Z

    goto :goto_0

    .line 37
    .end local v0    # "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .end local v1    # "videoExpirationDate":Ljava/util/Date;
    :cond_3
    return-void
.end method
