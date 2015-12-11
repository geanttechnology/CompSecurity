.class public Lcom/xfinity/playerlib/model/consumable/MovieFacade;
.super Lcom/xfinity/playerlib/model/consumable/BaseWatchable;
.source "MovieFacade.java"


# instance fields
.field private movieEntity:Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;

.field private final videos:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/VideoFacade;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;)V
    .locals 5
    .param p1, "movieEntity"    # Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;

    .prologue
    .line 23
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/consumable/BaseWatchable;-><init>()V

    .line 24
    invoke-static {p1}, Lorg/apache/commons/lang3/Validate;->notNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 25
    iput-object p1, p0, Lcom/xfinity/playerlib/model/consumable/MovieFacade;->movieEntity:Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;

    .line 27
    invoke-static {}, Lcom/google/common/collect/Sets;->newHashSet()Ljava/util/HashSet;

    move-result-object v1

    .line 28
    .local v1, "videos":Ljava/util/Set;, "Ljava/util/Set<Lcom/xfinity/playerlib/model/consumable/VideoFacade;>;"
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;->getVideos()Ljava/util/List;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;

    .line 29
    .local v0, "video":Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;
    new-instance v3, Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;->getMerlinEntityId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v4

    invoke-direct {v3, v0, v4}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;-><init>(Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;Lcom/xfinity/playerlib/model/MerlinId;)V

    invoke-interface {v1, v3}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 31
    .end local v0    # "video":Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;
    :cond_0
    iput-object v1, p0, Lcom/xfinity/playerlib/model/consumable/MovieFacade;->videos:Ljava/util/Set;

    .line 33
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/consumable/MovieFacade;->initFromVideos()V

    .line 34
    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 5
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 96
    if-ne p0, p1, :cond_1

    .line 113
    :cond_0
    :goto_0
    return v1

    .line 99
    :cond_1
    if-eqz p1, :cond_2

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    if-eq v3, v4, :cond_3

    :cond_2
    move v1, v2

    .line 100
    goto :goto_0

    .line 102
    :cond_3
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/model/consumable/BaseWatchable;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_4

    move v1, v2

    .line 103
    goto :goto_0

    :cond_4
    move-object v0, p1

    .line 105
    check-cast v0, Lcom/xfinity/playerlib/model/consumable/MovieFacade;

    .line 106
    .local v0, "that":Lcom/xfinity/playerlib/model/consumable/MovieFacade;
    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/MovieFacade;->movieEntity:Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;

    if-eqz v3, :cond_6

    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/MovieFacade;->movieEntity:Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;

    iget-object v4, v0, Lcom/xfinity/playerlib/model/consumable/MovieFacade;->movieEntity:Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;

    invoke-virtual {v3, v4}, Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_7

    :cond_5
    move v1, v2

    .line 107
    goto :goto_0

    .line 106
    :cond_6
    iget-object v3, v0, Lcom/xfinity/playerlib/model/consumable/MovieFacade;->movieEntity:Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;

    if-nez v3, :cond_5

    .line 110
    :cond_7
    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/MovieFacade;->videos:Ljava/util/Set;

    if-eqz v3, :cond_8

    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/MovieFacade;->videos:Ljava/util/Set;

    iget-object v4, v0, Lcom/xfinity/playerlib/model/consumable/MovieFacade;->videos:Ljava/util/Set;

    invoke-interface {v3, v4}, Ljava/util/Set;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    :goto_1
    move v1, v2

    .line 111
    goto :goto_0

    .line 110
    :cond_8
    iget-object v3, v0, Lcom/xfinity/playerlib/model/consumable/MovieFacade;->videos:Ljava/util/Set;

    if-eqz v3, :cond_0

    goto :goto_1
.end method

.method public getBackingEntity()Lcom/comcast/cim/cmasl/utils/container/Either;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/utils/container/Either",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;",
            ">;"
        }
    .end annotation

    .prologue
    .line 91
    new-instance v0, Lcom/comcast/cim/cmasl/utils/container/LeftEither;

    iget-object v1, p0, Lcom/xfinity/playerlib/model/consumable/MovieFacade;->movieEntity:Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;

    invoke-direct {v0, v1}, Lcom/comcast/cim/cmasl/utils/container/LeftEither;-><init>(Ljava/lang/Object;)V

    return-object v0
.end method

.method public getCast()Ljava/lang/String;
    .locals 1

    .prologue
    .line 73
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/MovieFacade;->movieEntity:Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;->castListAsString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getDescription()Ljava/lang/String;
    .locals 1

    .prologue
    .line 68
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/MovieFacade;->movieEntity:Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;->getDescription()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getDisplayTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 58
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/consumable/MovieFacade;->getTitle()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getEntityDeeplinkUri(Ljava/lang/String;)Landroid/net/Uri;
    .locals 2
    .param p1, "deepLinkingScheme"    # Ljava/lang/String;

    .prologue
    .line 118
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "://entity/1/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/consumable/MovieFacade;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/MerlinId;->getSimpleId()Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method public getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/MovieFacade;->movieEntity:Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;->getMerlinEntityId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v0

    return-object v0
.end method

.method public getParentMerlinIdIfApplicable()Lcom/xfinity/playerlib/model/MerlinId;
    .locals 1

    .prologue
    .line 48
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/consumable/MovieFacade;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v0

    return-object v0
.end method

.method public getPlaybackDeeplinkUri(Ljava/lang/String;)Landroid/net/Uri;
    .locals 2
    .param p1, "deepLinkingScheme"    # Ljava/lang/String;

    .prologue
    .line 123
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "://playback/1/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/consumable/MovieFacade;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/MerlinId;->getSimpleId()Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method public getReleaseYear()Ljava/lang/String;
    .locals 1

    .prologue
    .line 82
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/MovieFacade;->movieEntity:Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;->getYearPublished()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getReviews()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalReview;",
            ">;"
        }
    .end annotation

    .prologue
    .line 86
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/MovieFacade;->movieEntity:Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;->getReviews()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public getSeriesInfoIfApplicable()Lcom/xfinity/playerlib/model/consumable/SeriesWatchableInfo;
    .locals 1

    .prologue
    .line 53
    const/4 v0, 0x0

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 63
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/MovieFacade;->movieEntity:Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;->getTitle()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getVideos()Ljava/util/Set;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/VideoFacade;",
            ">;"
        }
    .end annotation

    .prologue
    .line 38
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/MovieFacade;->videos:Ljava/util/Set;

    return-object v0
.end method

.method public hashCode()I
    .locals 4

    .prologue
    const/4 v2, 0x0

    .line 128
    invoke-super {p0}, Lcom/xfinity/playerlib/model/consumable/BaseWatchable;->hashCode()I

    move-result v0

    .line 129
    .local v0, "result":I
    mul-int/lit8 v3, v0, 0x1f

    iget-object v1, p0, Lcom/xfinity/playerlib/model/consumable/MovieFacade;->videos:Ljava/util/Set;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/xfinity/playerlib/model/consumable/MovieFacade;->videos:Ljava/util/Set;

    invoke-interface {v1}, Ljava/util/Set;->hashCode()I

    move-result v1

    :goto_0
    add-int v0, v3, v1

    .line 130
    mul-int/lit8 v1, v0, 0x1f

    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/MovieFacade;->movieEntity:Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;

    if-eqz v3, :cond_0

    iget-object v2, p0, Lcom/xfinity/playerlib/model/consumable/MovieFacade;->movieEntity:Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;->hashCode()I

    move-result v2

    :cond_0
    add-int v0, v1, v2

    .line 131
    return v0

    :cond_1
    move v1, v2

    .line 129
    goto :goto_0
.end method

.method public isNew()Z
    .locals 1

    .prologue
    .line 78
    const/4 v0, 0x0

    return v0
.end method
