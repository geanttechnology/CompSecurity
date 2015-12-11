.class public abstract Lcom/comcast/cim/cmasl/hls/HlsPlaylist;
.super Ljava/lang/Object;
.source "HlsPlaylist.java"


# instance fields
.field unknownTags:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field urlPathPrefix:Ljava/lang/String;

.field version:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 8
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 11
    const-string v0, "1"

    iput-object v0, p0, Lcom/comcast/cim/cmasl/hls/HlsPlaylist;->version:Ljava/lang/String;

    .line 13
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/cmasl/hls/HlsPlaylist;->unknownTags:Ljava/util/List;

    return-void
.end method


# virtual methods
.method public addUnknownTag(Ljava/lang/String;)V
    .locals 1
    .param p1, "tagInfo"    # Ljava/lang/String;

    .prologue
    .line 32
    iget-object v0, p0, Lcom/comcast/cim/cmasl/hls/HlsPlaylist;->unknownTags:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 33
    return-void
.end method

.method protected getAllUnknownTags()Ljava/lang/String;
    .locals 5

    .prologue
    .line 44
    const-string v2, ""

    .line 45
    .local v2, "unknowns":Ljava/lang/String;
    iget-object v3, p0, Lcom/comcast/cim/cmasl/hls/HlsPlaylist;->unknownTags:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 46
    .local v1, "unknownTag":Ljava/lang/String;
    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v3

    if-nez v3, :cond_0

    .line 47
    move-object v2, v1

    goto :goto_0

    .line 49
    :cond_0
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\n"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 53
    .end local v1    # "unknownTag":Ljava/lang/String;
    :cond_1
    return-object v2
.end method

.method protected getStartAndVersionString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 40
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "#EXTM3U\n#EXT-X-VERSION:"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/cim/cmasl/hls/HlsPlaylist;->version:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getUnknownTags()Ljava/util/List;
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
    .line 36
    iget-object v0, p0, Lcom/comcast/cim/cmasl/hls/HlsPlaylist;->unknownTags:Ljava/util/List;

    return-object v0
.end method

.method public getUrlPathPrefix()Ljava/lang/String;
    .locals 1

    .prologue
    .line 20
    iget-object v0, p0, Lcom/comcast/cim/cmasl/hls/HlsPlaylist;->urlPathPrefix:Ljava/lang/String;

    return-object v0
.end method

.method public getVersion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/comcast/cim/cmasl/hls/HlsPlaylist;->version:Ljava/lang/String;

    return-object v0
.end method

.method public setUrlPathPrefix(Ljava/lang/String;)V
    .locals 0
    .param p1, "urlPathPrefix"    # Ljava/lang/String;

    .prologue
    .line 16
    iput-object p1, p0, Lcom/comcast/cim/cmasl/hls/HlsPlaylist;->urlPathPrefix:Ljava/lang/String;

    .line 17
    return-void
.end method

.method public setVersion(Ljava/lang/String;)V
    .locals 0
    .param p1, "version"    # Ljava/lang/String;

    .prologue
    .line 24
    iput-object p1, p0, Lcom/comcast/cim/cmasl/hls/HlsPlaylist;->version:Ljava/lang/String;

    .line 25
    return-void
.end method
