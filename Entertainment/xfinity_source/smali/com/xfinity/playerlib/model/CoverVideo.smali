.class public Lcom/xfinity/playerlib/model/CoverVideo;
.super Lcom/xfinity/playerlib/model/EditorialProgram;
.source "CoverVideo.java"


# instance fields
.field private duration:I

.field private entityType:Ljava/lang/String;

.field private episodeId:Lcom/xfinity/playerlib/model/MerlinId;

.field private releaseUrl:Ljava/lang/String;

.field private secureMetadata:Ljava/lang/String;

.field private videoId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/EditorialProgram;-><init>()V

    return-void
.end method


# virtual methods
.method public getDescription()Ljava/lang/String;
    .locals 1

    .prologue
    .line 66
    const/4 v0, 0x0

    return-object v0
.end method

.method public getDuration()I
    .locals 1

    .prologue
    .line 33
    iget v0, p0, Lcom/xfinity/playerlib/model/CoverVideo;->duration:I

    return v0
.end method

.method public getEntityType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/xfinity/playerlib/model/CoverVideo;->entityType:Ljava/lang/String;

    return-object v0
.end method

.method public getEpisodeMerlinId()Lcom/xfinity/playerlib/model/MerlinId;
    .locals 1

    .prologue
    .line 70
    iget-object v0, p0, Lcom/xfinity/playerlib/model/CoverVideo;->episodeId:Lcom/xfinity/playerlib/model/MerlinId;

    return-object v0
.end method

.method public getMerlinIdNamespace()Lcom/xfinity/playerlib/model/MerlinId$Namespace;
    .locals 1

    .prologue
    .line 112
    iget-object v0, p0, Lcom/xfinity/playerlib/model/CoverVideo;->entityType:Ljava/lang/String;

    invoke-static {v0}, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->valueOf(Ljava/lang/String;)Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    move-result-object v0

    return-object v0
.end method

.method public getReleaseURL()Ljava/lang/String;
    .locals 1

    .prologue
    .line 51
    iget-object v0, p0, Lcom/xfinity/playerlib/model/CoverVideo;->releaseUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getSecureMetadata()Ljava/lang/String;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/xfinity/playerlib/model/CoverVideo;->secureMetadata:Ljava/lang/String;

    return-object v0
.end method

.method public getVideoId()J
    .locals 2

    .prologue
    .line 21
    iget-wide v0, p0, Lcom/xfinity/playerlib/model/CoverVideo;->videoId:J

    return-wide v0
.end method

.method public isMovie()Z
    .locals 2

    .prologue
    .line 107
    iget-object v0, p0, Lcom/xfinity/playerlib/model/CoverVideo;->merlinId:Lcom/xfinity/playerlib/model/MerlinId;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/MerlinId;->getNamespace()Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    move-result-object v0

    sget-object v1, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->Movie:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public parse(Ljava/util/LinkedHashMap;)V
    .locals 7
    .param p1, "cover"    # Ljava/util/LinkedHashMap;

    .prologue
    .line 78
    const-string v4, "imgIpad"

    invoke-virtual {p1, v4}, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-virtual {p0, v4}, Lcom/xfinity/playerlib/model/CoverVideo;->setImageKey(Ljava/lang/String;)V

    .line 79
    iget-object v4, p0, Lcom/xfinity/playerlib/model/CoverVideo;->imageKey:Ljava/lang/String;

    if-eqz v4, :cond_0

    iget-object v4, p0, Lcom/xfinity/playerlib/model/CoverVideo;->imageKey:Ljava/lang/String;

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v4

    if-nez v4, :cond_1

    .line 80
    :cond_0
    new-instance v4, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;

    const-string v5, "the image URL has to be present"

    invoke-direct {v4, v5}, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 83
    :cond_1
    const-string v4, "episodeName"

    invoke-virtual {p1, v4}, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-virtual {p0, v4}, Lcom/xfinity/playerlib/model/CoverVideo;->setEpisodeTitle(Ljava/lang/String;)V

    .line 84
    const-string v4, "name"

    invoke-virtual {p1, v4}, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-virtual {p0, v4}, Lcom/xfinity/playerlib/model/CoverVideo;->setTitle(Ljava/lang/String;)V

    .line 85
    const-string v4, "episodeSeasonNumber"

    invoke-virtual {p1, v4}, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-virtual {p0, v4}, Lcom/xfinity/playerlib/model/CoverVideo;->setSeasonNumber(Ljava/lang/String;)V

    .line 86
    const-string v4, "episodeNumber"

    invoke-virtual {p1, v4}, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-virtual {p0, v4}, Lcom/xfinity/playerlib/model/CoverVideo;->setEpisodeNumber(Ljava/lang/String;)V

    .line 87
    const-string v4, "secData"

    invoke-virtual {p1, v4}, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-virtual {p0, v4}, Lcom/xfinity/playerlib/model/CoverVideo;->setSecureMetadata(Ljava/lang/String;)V

    .line 88
    const-string v4, "videoReleaseUrl"

    invoke-virtual {p1, v4}, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-virtual {p0, v4}, Lcom/xfinity/playerlib/model/CoverVideo;->setReleaseUrl(Ljava/lang/String;)V

    .line 89
    const-string v4, "videoProviderCode"

    invoke-virtual {p1, v4}, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-virtual {p0, v4}, Lcom/xfinity/playerlib/model/CoverVideo;->setProviderCode(Ljava/lang/String;)V

    .line 90
    const-string v4, "entityType"

    invoke-virtual {p1, v4}, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-virtual {p0, v4}, Lcom/xfinity/playerlib/model/CoverVideo;->setEntityType(Ljava/lang/String;)V

    .line 91
    const-string v4, "entityMerlinId"

    invoke-virtual {p1, v4}, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 92
    .local v2, "merlinId":Ljava/lang/String;
    const-string v4, "episodeMerlinId"

    invoke-virtual {p1, v4}, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 93
    .local v1, "episodeMerlinId":Ljava/lang/String;
    const-string v4, "videoBrand"

    invoke-virtual {p1, v4}, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 94
    .local v0, "brand":Ljava/lang/String;
    const-string v4, "videoDuration"

    invoke-virtual {p1, v4}, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 95
    .local v3, "videoDuration":Ljava/lang/String;
    invoke-static {v3}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v4

    iput v4, p0, Lcom/xfinity/playerlib/model/CoverVideo;->duration:I

    .line 96
    const-string v4, "videoGlobalUid"

    invoke-virtual {p1, v4}, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-virtual {p0, v4}, Lcom/xfinity/playerlib/model/CoverVideo;->setVideoId(Ljava/lang/String;)V

    .line 98
    new-instance v4, Lcom/xfinity/playerlib/model/MerlinId;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/CoverVideo;->getEntityType()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->valueOf(Ljava/lang/String;)Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    move-result-object v5

    invoke-static {v2}, Ljava/lang/Long;->valueOf(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v6

    invoke-direct {v4, v5, v6}, Lcom/xfinity/playerlib/model/MerlinId;-><init>(Lcom/xfinity/playerlib/model/MerlinId$Namespace;Ljava/lang/Long;)V

    invoke-virtual {p0, v4}, Lcom/xfinity/playerlib/model/CoverVideo;->setMerlinId(Lcom/xfinity/playerlib/model/MerlinId;)V

    .line 99
    if-eqz v1, :cond_2

    .line 100
    new-instance v4, Lcom/xfinity/playerlib/model/MerlinId;

    sget-object v5, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->TvEpisode:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    invoke-static {v1}, Ljava/lang/Long;->valueOf(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v6

    invoke-direct {v4, v5, v6}, Lcom/xfinity/playerlib/model/MerlinId;-><init>(Lcom/xfinity/playerlib/model/MerlinId$Namespace;Ljava/lang/Long;)V

    invoke-virtual {p0, v4}, Lcom/xfinity/playerlib/model/CoverVideo;->setEpisodeMerlinId(Lcom/xfinity/playerlib/model/MerlinId;)V

    .line 102
    :cond_2
    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/model/CoverVideo;->setBrand(Ljava/lang/String;)V

    .line 103
    return-void
.end method

.method public setDuration(I)V
    .locals 0
    .param p1, "duration"    # I

    .prologue
    .line 37
    iput p1, p0, Lcom/xfinity/playerlib/model/CoverVideo;->duration:I

    .line 38
    return-void
.end method

.method public setEntityType(Ljava/lang/String;)V
    .locals 0
    .param p1, "data"    # Ljava/lang/String;

    .prologue
    .line 62
    iput-object p1, p0, Lcom/xfinity/playerlib/model/CoverVideo;->entityType:Ljava/lang/String;

    .line 63
    return-void
.end method

.method public setEpisodeMerlinId(Lcom/xfinity/playerlib/model/MerlinId;)V
    .locals 0
    .param p1, "merlinId"    # Lcom/xfinity/playerlib/model/MerlinId;

    .prologue
    .line 74
    iput-object p1, p0, Lcom/xfinity/playerlib/model/CoverVideo;->episodeId:Lcom/xfinity/playerlib/model/MerlinId;

    .line 75
    return-void
.end method

.method public setReleaseUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 55
    iput-object p1, p0, Lcom/xfinity/playerlib/model/CoverVideo;->releaseUrl:Ljava/lang/String;

    .line 56
    return-void
.end method

.method public setSecureMetadata(Ljava/lang/String;)V
    .locals 0
    .param p1, "data"    # Ljava/lang/String;

    .prologue
    .line 47
    iput-object p1, p0, Lcom/xfinity/playerlib/model/CoverVideo;->secureMetadata:Ljava/lang/String;

    .line 48
    return-void
.end method

.method public setVideoId(Ljava/lang/String;)V
    .locals 4
    .param p1, "videoId"    # Ljava/lang/String;

    .prologue
    .line 25
    const-string v1, "-"

    invoke-static {p1, v1}, Lorg/apache/commons/lang3/StringUtils;->split(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 26
    .local v0, "split":[Ljava/lang/String;
    array-length v1, v0

    const/4 v2, 0x2

    if-eq v1, v2, :cond_0

    .line 27
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "ID should be in the form namespace-intID (f.e. TvSeries-12345)"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 29
    :cond_0
    const/4 v1, 0x1

    aget-object v1, v0, v1

    invoke-static {v1}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v2

    iput-wide v2, p0, Lcom/xfinity/playerlib/model/CoverVideo;->videoId:J

    .line 30
    return-void
.end method
