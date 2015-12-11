.class public Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;
.super Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;
.source "HalMovieConsumable.java"


# instance fields
.field private videos:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;",
            ">;"
        }
    .end annotation
.end field

.field private yearPublished:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 10
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;-><init>()V

    .line 15
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;->videos:Ljava/util/List;

    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 5
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 51
    if-ne p0, p1, :cond_1

    .line 71
    :cond_0
    :goto_0
    return v1

    .line 54
    :cond_1
    if-eqz p1, :cond_2

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    if-eq v3, v4, :cond_3

    :cond_2
    move v1, v2

    .line 55
    goto :goto_0

    .line 57
    :cond_3
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_4

    move v1, v2

    .line 58
    goto :goto_0

    :cond_4
    move-object v0, p1

    .line 61
    check-cast v0, Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;

    .line 63
    .local v0, "that":Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;
    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;->yearPublished:Ljava/lang/String;

    iget-object v4, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;->yearPublished:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_5

    move v1, v2

    .line 64
    goto :goto_0

    .line 67
    :cond_5
    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;->videos:Ljava/util/List;

    iget-object v4, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;->videos:Ljava/util/List;

    invoke-interface {v3, v4}, Ljava/util/List;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    move v1, v2

    .line 68
    goto :goto_0
.end method

.method public getNamespace()Lcom/xfinity/playerlib/model/MerlinId$Namespace;
    .locals 1

    .prologue
    .line 42
    sget-object v0, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->Movie:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

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
    .line 38
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;->videos:Ljava/util/List;

    return-object v0
.end method

.method public getYearPublished()Ljava/lang/String;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;->yearPublished:Ljava/lang/String;

    return-object v0
.end method

.method public hashCode()I
    .locals 3

    .prologue
    .line 76
    invoke-super {p0}, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;->hashCode()I

    move-result v0

    .line 77
    .local v0, "result":I
    mul-int/lit8 v1, v0, 0x1f

    iget-object v2, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;->yearPublished:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->hashCode()I

    move-result v2

    add-int v0, v1, v2

    .line 78
    mul-int/lit8 v1, v0, 0x1f

    iget-object v2, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;->videos:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->hashCode()I

    move-result v2

    add-int v0, v1, v2

    .line 79
    return v0
.end method

.method public parseHalContent(Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;)V
    .locals 5
    .param p1, "resolver"    # Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;

    .prologue
    .line 19
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;->parseHalContent(Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;)V

    .line 21
    const-string v3, "yearPublished"

    invoke-virtual {p1, v3}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchOptionalString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;->yearPublished:Ljava/lang/String;

    .line 23
    const-string v3, "video"

    invoke-virtual {p1, v3}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchOptionalItemList(Ljava/lang/String;)Ljava/util/List;

    move-result-object v2

    .line 24
    .local v2, "videoList":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/microdata/model/MicrodataItem;>;"
    if-eqz v2, :cond_0

    .line 25
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/microdata/model/MicrodataItem;

    .line 26
    .local v0, "item":Lcom/comcast/cim/microdata/model/MicrodataItem;
    new-instance v1, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;

    invoke-direct {v1}, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;-><init>()V

    .line 27
    .local v1, "video":Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;
    invoke-virtual {p1, v0}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->copy(Lcom/comcast/cim/microdata/model/MicrodataItem;)Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;

    move-result-object v4

    invoke-virtual {v1, v4}, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->parseHalContent(Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;)V

    .line 28
    iget-object v4, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;->videos:Ljava/util/List;

    invoke-interface {v4, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 31
    .end local v0    # "item":Lcom/comcast/cim/microdata/model/MicrodataItem;
    .end local v1    # "video":Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;
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
    .line 46
    .local p1, "videos":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;>;"
    iput-object p1, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;->videos:Ljava/util/List;

    .line 47
    return-void
.end method
