.class public Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeason;
.super Ljava/lang/Object;
.source "HalTvSeason.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/hal/model/HalParseable;


# instance fields
.field private episodes:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;",
            ">;"
        }
    .end annotation
.end field

.field private seasonNumber:I


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 13
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeason;->episodes:Ljava/util/List;

    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 5
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 39
    if-ne p0, p1, :cond_1

    .line 56
    :cond_0
    :goto_0
    return v1

    .line 42
    :cond_1
    if-eqz p1, :cond_2

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    if-eq v3, v4, :cond_3

    :cond_2
    move v1, v2

    .line 43
    goto :goto_0

    :cond_3
    move-object v0, p1

    .line 46
    check-cast v0, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeason;

    .line 48
    .local v0, "that":Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeason;
    iget v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeason;->seasonNumber:I

    iget v4, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeason;->seasonNumber:I

    if-eq v3, v4, :cond_4

    move v1, v2

    .line 49
    goto :goto_0

    .line 52
    :cond_4
    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeason;->episodes:Ljava/util/List;

    iget-object v4, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeason;->episodes:Ljava/util/List;

    invoke-interface {v3, v4}, Ljava/util/List;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    move v1, v2

    .line 53
    goto :goto_0
.end method

.method public getEpisodes()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;",
            ">;"
        }
    .end annotation

    .prologue
    .line 34
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeason;->episodes:Ljava/util/List;

    return-object v0
.end method

.method public getSeasonNumber()I
    .locals 1

    .prologue
    .line 30
    iget v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeason;->seasonNumber:I

    return v0
.end method

.method public hashCode()I
    .locals 3

    .prologue
    .line 61
    iget v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeason;->seasonNumber:I

    .line 62
    .local v0, "result":I
    mul-int/lit8 v1, v0, 0x1f

    iget-object v2, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeason;->episodes:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->hashCode()I

    move-result v2

    add-int v0, v1, v2

    .line 63
    return v0
.end method

.method public parseHalContent(Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;)V
    .locals 5
    .param p1, "resolver"    # Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;

    .prologue
    .line 17
    const-string v3, "seasonNumber"

    invoke-virtual {p1, v3}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchInt(Ljava/lang/String;)I

    move-result v3

    iput v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeason;->seasonNumber:I

    .line 19
    const-string v3, "episode"

    invoke-virtual {p1, v3}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchOptionalItemList(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 20
    .local v0, "episodeList":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/microdata/model/MicrodataItem;>;"
    if-eqz v0, :cond_0

    .line 21
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/comcast/cim/microdata/model/MicrodataItem;

    .line 22
    .local v1, "item":Lcom/comcast/cim/microdata/model/MicrodataItem;
    new-instance v2, Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;

    invoke-direct {v2}, Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;-><init>()V

    .line 23
    .local v2, "nextEpisode":Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;
    invoke-virtual {p1, v1}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->copy(Lcom/comcast/cim/microdata/model/MicrodataItem;)Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;

    move-result-object v4

    invoke-virtual {v2, v4}, Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;->parseHalContent(Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;)V

    .line 24
    iget-object v4, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeason;->episodes:Ljava/util/List;

    invoke-interface {v4, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 27
    .end local v1    # "item":Lcom/comcast/cim/microdata/model/MicrodataItem;
    .end local v2    # "nextEpisode":Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;
    :cond_0
    return-void
.end method
