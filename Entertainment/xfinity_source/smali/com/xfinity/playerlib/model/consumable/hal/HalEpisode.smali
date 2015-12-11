.class public Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;
.super Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;
.source "HalEpisode.java"


# instance fields
.field private episodeNumber:I

.field private isNew:Z

.field private originalAirdate:Ljava/util/Date;

.field videos:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 11
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;-><init>()V

    .line 17
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;->videos:Ljava/util/List;

    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 5
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 64
    if-ne p0, p1, :cond_1

    .line 90
    :cond_0
    :goto_0
    return v1

    .line 67
    :cond_1
    if-eqz p1, :cond_2

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    if-eq v3, v4, :cond_3

    :cond_2
    move v1, v2

    .line 68
    goto :goto_0

    .line 70
    :cond_3
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_4

    move v1, v2

    .line 71
    goto :goto_0

    :cond_4
    move-object v0, p1

    .line 74
    check-cast v0, Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;

    .line 76
    .local v0, "that":Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;
    iget v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;->episodeNumber:I

    iget v4, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;->episodeNumber:I

    if-eq v3, v4, :cond_5

    move v1, v2

    .line 77
    goto :goto_0

    .line 79
    :cond_5
    iget-boolean v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;->isNew:Z

    iget-boolean v4, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;->isNew:Z

    if-eq v3, v4, :cond_6

    move v1, v2

    .line 80
    goto :goto_0

    .line 82
    :cond_6
    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;->originalAirdate:Ljava/util/Date;

    if-eqz v3, :cond_8

    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;->originalAirdate:Ljava/util/Date;

    iget-object v4, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;->originalAirdate:Ljava/util/Date;

    invoke-virtual {v3, v4}, Ljava/util/Date;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_9

    :cond_7
    move v1, v2

    .line 83
    goto :goto_0

    .line 82
    :cond_8
    iget-object v3, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;->originalAirdate:Ljava/util/Date;

    if-nez v3, :cond_7

    .line 86
    :cond_9
    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;->videos:Ljava/util/List;

    iget-object v4, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;->videos:Ljava/util/List;

    invoke-interface {v3, v4}, Ljava/util/List;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    move v1, v2

    .line 87
    goto :goto_0
.end method

.method public getEpisodeNumber()I
    .locals 1

    .prologue
    .line 38
    iget v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;->episodeNumber:I

    return v0
.end method

.method public getNamespace()Lcom/xfinity/playerlib/model/MerlinId$Namespace;
    .locals 1

    .prologue
    .line 59
    sget-object v0, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->TvEpisode:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    return-object v0
.end method

.method public getOriginalAirdate()Ljava/util/Date;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;->originalAirdate:Ljava/util/Date;

    return-object v0
.end method

.method public getVideos()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;",
            ">;"
        }
    .end annotation

    .prologue
    .line 54
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;->videos:Ljava/util/List;

    return-object v0
.end method

.method public hashCode()I
    .locals 4

    .prologue
    const/4 v2, 0x0

    .line 95
    invoke-super {p0}, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;->hashCode()I

    move-result v0

    .line 96
    .local v0, "result":I
    mul-int/lit8 v1, v0, 0x1f

    iget v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;->episodeNumber:I

    add-int v0, v1, v3

    .line 97
    mul-int/lit8 v3, v0, 0x1f

    iget-boolean v1, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;->isNew:Z

    if-eqz v1, :cond_1

    const/4 v1, 0x1

    :goto_0
    add-int v0, v3, v1

    .line 98
    mul-int/lit8 v1, v0, 0x1f

    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;->originalAirdate:Ljava/util/Date;

    if-eqz v3, :cond_0

    iget-object v2, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;->originalAirdate:Ljava/util/Date;

    invoke-virtual {v2}, Ljava/util/Date;->hashCode()I

    move-result v2

    :cond_0
    add-int v0, v1, v2

    .line 99
    mul-int/lit8 v1, v0, 0x1f

    iget-object v2, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;->videos:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->hashCode()I

    move-result v2

    add-int v0, v1, v2

    .line 100
    return v0

    :cond_1
    move v1, v2

    .line 97
    goto :goto_0
.end method

.method public isNew()Z
    .locals 1

    .prologue
    .line 42
    iget-boolean v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;->isNew:Z

    return v0
.end method

.method public parseHalContent(Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;)V
    .locals 5
    .param p1, "resolver"    # Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;

    .prologue
    .line 21
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;->parseHalContent(Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;)V

    .line 23
    const-string v3, "episodeNumber"

    invoke-virtual {p1, v3}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchInt(Ljava/lang/String;)I

    move-result v3

    iput v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;->episodeNumber:I

    .line 24
    const-string v3, "isNew"

    const/4 v4, 0x0

    invoke-virtual {p1, v3, v4}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchOptionalBoolean(Ljava/lang/String;Z)Z

    move-result v3

    iput-boolean v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;->isNew:Z

    .line 25
    const-string v3, "datePublished/originalAirDate"

    invoke-virtual {p1, v3}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchOptionalString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, v3}, Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;->parseDate(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v3

    iput-object v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;->originalAirdate:Ljava/util/Date;

    .line 27
    const-string v3, "video"

    invoke-virtual {p1, v3}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchOptionalItemList(Ljava/lang/String;)Ljava/util/List;

    move-result-object v1

    .line 28
    .local v1, "items":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/microdata/model/MicrodataItem;>;"
    if-eqz v1, :cond_0

    .line 29
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/microdata/model/MicrodataItem;

    .line 30
    .local v0, "item":Lcom/comcast/cim/microdata/model/MicrodataItem;
    new-instance v2, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;

    invoke-direct {v2}, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;-><init>()V

    .line 31
    .local v2, "video":Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;
    invoke-virtual {p1, v0}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->copy(Lcom/comcast/cim/microdata/model/MicrodataItem;)Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;

    move-result-object v4

    invoke-virtual {v2, v4}, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->parseHalContent(Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;)V

    .line 32
    iget-object v4, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;->videos:Ljava/util/List;

    invoke-interface {v4, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 35
    .end local v0    # "item":Lcom/comcast/cim/microdata/model/MicrodataItem;
    .end local v2    # "video":Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;
    :cond_0
    return-void
.end method

.method public setVideos(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 50
    .local p1, "videos":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;>;"
    iput-object p1, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;->videos:Ljava/util/List;

    .line 51
    return-void
.end method
