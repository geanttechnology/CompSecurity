.class public Lcom/xfinity/playerlib/model/consumable/hal/HalEncoding;
.super Ljava/lang/Object;
.source "HalEncoding.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/hal/model/HalParseable;


# instance fields
.field downloadProfiles:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;",
            ">;"
        }
    .end annotation
.end field

.field private hasClosedCaptions:Z
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "hasClosedCaptions"
    .end annotation
.end field

.field private languageCodes:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private pid:Ljava/lang/String;

.field streamingProfiles:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 19
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalEncoding;->downloadProfiles:Ljava/util/List;

    .line 20
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalEncoding;->streamingProfiles:Ljava/util/List;

    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 5
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 73
    if-ne p0, p1, :cond_1

    .line 99
    :cond_0
    :goto_0
    return v1

    .line 76
    :cond_1
    if-eqz p1, :cond_2

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    if-eq v3, v4, :cond_3

    :cond_2
    move v1, v2

    .line 77
    goto :goto_0

    :cond_3
    move-object v0, p1

    .line 80
    check-cast v0, Lcom/xfinity/playerlib/model/consumable/hal/HalEncoding;

    .line 82
    .local v0, "encoding":Lcom/xfinity/playerlib/model/consumable/hal/HalEncoding;
    iget-boolean v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalEncoding;->hasClosedCaptions:Z

    iget-boolean v4, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalEncoding;->hasClosedCaptions:Z

    if-eq v3, v4, :cond_4

    move v1, v2

    .line 83
    goto :goto_0

    .line 85
    :cond_4
    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalEncoding;->downloadProfiles:Ljava/util/List;

    iget-object v4, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalEncoding;->downloadProfiles:Ljava/util/List;

    invoke-interface {v3, v4}, Ljava/util/List;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_5

    move v1, v2

    .line 86
    goto :goto_0

    .line 88
    :cond_5
    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalEncoding;->languageCodes:Ljava/util/List;

    if-eqz v3, :cond_7

    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalEncoding;->languageCodes:Ljava/util/List;

    iget-object v4, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalEncoding;->languageCodes:Ljava/util/List;

    invoke-interface {v3, v4}, Ljava/util/List;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_8

    :cond_6
    move v1, v2

    .line 89
    goto :goto_0

    .line 88
    :cond_7
    iget-object v3, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalEncoding;->languageCodes:Ljava/util/List;

    if-nez v3, :cond_6

    .line 91
    :cond_8
    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalEncoding;->pid:Ljava/lang/String;

    if-eqz v3, :cond_a

    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalEncoding;->pid:Ljava/lang/String;

    iget-object v4, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalEncoding;->pid:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_b

    :cond_9
    move v1, v2

    .line 92
    goto :goto_0

    .line 91
    :cond_a
    iget-object v3, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalEncoding;->pid:Ljava/lang/String;

    if-nez v3, :cond_9

    .line 95
    :cond_b
    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalEncoding;->streamingProfiles:Ljava/util/List;

    iget-object v4, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalEncoding;->streamingProfiles:Ljava/util/List;

    invoke-interface {v3, v4}, Ljava/util/List;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    move v1, v2

    .line 96
    goto :goto_0
.end method

.method public getDownloadProfiles()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;",
            ">;"
        }
    .end annotation

    .prologue
    .line 68
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalEncoding;->downloadProfiles:Ljava/util/List;

    return-object v0
.end method

.method public getLanguageCodes()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 60
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalEncoding;->languageCodes:Ljava/util/List;

    return-object v0
.end method

.method public getPid()Ljava/lang/String;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalEncoding;->pid:Ljava/lang/String;

    return-object v0
.end method

.method public getStreamingProfiles()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;",
            ">;"
        }
    .end annotation

    .prologue
    .line 64
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalEncoding;->streamingProfiles:Ljava/util/List;

    return-object v0
.end method

.method public hasClosedCaptions()Z
    .locals 1

    .prologue
    .line 48
    iget-boolean v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalEncoding;->hasClosedCaptions:Z

    return v0
.end method

.method public hashCode()I
    .locals 4

    .prologue
    const/4 v1, 0x0

    .line 104
    iget-boolean v2, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalEncoding;->hasClosedCaptions:Z

    if-eqz v2, :cond_1

    const/4 v0, 0x1

    .line 105
    .local v0, "result":I
    :goto_0
    mul-int/lit8 v3, v0, 0x1f

    iget-object v2, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalEncoding;->pid:Ljava/lang/String;

    if-eqz v2, :cond_2

    iget-object v2, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalEncoding;->pid:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->hashCode()I

    move-result v2

    :goto_1
    add-int v0, v3, v2

    .line 106
    mul-int/lit8 v2, v0, 0x1f

    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalEncoding;->languageCodes:Ljava/util/List;

    if-eqz v3, :cond_0

    iget-object v1, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalEncoding;->languageCodes:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->hashCode()I

    move-result v1

    :cond_0
    add-int v0, v2, v1

    .line 107
    mul-int/lit8 v1, v0, 0x1f

    iget-object v2, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalEncoding;->downloadProfiles:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->hashCode()I

    move-result v2

    add-int v0, v1, v2

    .line 108
    mul-int/lit8 v1, v0, 0x1f

    iget-object v2, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalEncoding;->streamingProfiles:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->hashCode()I

    move-result v2

    add-int v0, v1, v2

    .line 109
    return v0

    .end local v0    # "result":I
    :cond_1
    move v0, v1

    .line 104
    goto :goto_0

    .restart local v0    # "result":I
    :cond_2
    move v2, v1

    .line 105
    goto :goto_1
.end method

.method public parseHalContent(Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;)V
    .locals 6
    .param p1, "resolver"    # Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;

    .prologue
    .line 24
    const-string v4, "isClosedCaption"

    invoke-virtual {p1, v4}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchBoolean(Ljava/lang/String;)Z

    move-result v4

    iput-boolean v4, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalEncoding;->hasClosedCaptions:Z

    .line 25
    const-string v4, "pid"

    invoke-virtual {p1, v4}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalEncoding;->pid:Ljava/lang/String;

    .line 26
    const-string v4, "inLanguage"

    invoke-virtual {p1, v4}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchOptionalList(Ljava/lang/String;)Ljava/util/List;

    move-result-object v4

    iput-object v4, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalEncoding;->languageCodes:Ljava/util/List;

    .line 28
    const-string v4, "streamProfile"

    invoke-virtual {p1, v4}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchOptionalItemList(Ljava/lang/String;)Ljava/util/List;

    move-result-object v3

    .line 29
    .local v3, "streaming":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/microdata/model/MicrodataItem;>;"
    if-eqz v3, :cond_0

    .line 30
    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/comcast/cim/microdata/model/MicrodataItem;

    .line 31
    .local v1, "item":Lcom/comcast/cim/microdata/model/MicrodataItem;
    new-instance v2, Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;

    invoke-direct {v2}, Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;-><init>()V

    .line 32
    .local v2, "nextProfile":Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;
    invoke-virtual {p1, v1}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->copy(Lcom/comcast/cim/microdata/model/MicrodataItem;)Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;

    move-result-object v5

    invoke-virtual {v2, v5}, Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;->parseHalContent(Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;)V

    .line 33
    iget-object v5, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalEncoding;->streamingProfiles:Ljava/util/List;

    invoke-interface {v5, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 37
    .end local v1    # "item":Lcom/comcast/cim/microdata/model/MicrodataItem;
    .end local v2    # "nextProfile":Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;
    :cond_0
    const-string v4, "downloadProfile"

    invoke-virtual {p1, v4}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchOptionalItemList(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 38
    .local v0, "downloads":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/microdata/model/MicrodataItem;>;"
    if-eqz v0, :cond_1

    .line 39
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_1
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_1

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/comcast/cim/microdata/model/MicrodataItem;

    .line 40
    .restart local v1    # "item":Lcom/comcast/cim/microdata/model/MicrodataItem;
    new-instance v2, Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;

    invoke-direct {v2}, Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;-><init>()V

    .line 41
    .restart local v2    # "nextProfile":Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;
    invoke-virtual {p1, v1}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->copy(Lcom/comcast/cim/microdata/model/MicrodataItem;)Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;

    move-result-object v5

    invoke-virtual {v2, v5}, Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;->parseHalContent(Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;)V

    .line 42
    iget-object v5, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalEncoding;->downloadProfiles:Ljava/util/List;

    invoke-interface {v5, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 45
    .end local v1    # "item":Lcom/comcast/cim/microdata/model/MicrodataItem;
    .end local v2    # "nextProfile":Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;
    :cond_1
    return-void
.end method
