.class public Lcom/xfinity/playerlib/model/consumable/VideoFacade;
.super Ljava/lang/Object;
.source "VideoFacade.java"

# interfaces
.implements Lcom/xfinity/playerlib/model/consumable/SortableVideo;
.implements Ljava/io/Serializable;


# instance fields
.field private parentMerlinIdIfApplicable:Lcom/xfinity/playerlib/model/MerlinId;

.field private programId:Lcom/xfinity/playerlib/model/MerlinId;

.field private video:Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;


# direct methods
.method public constructor <init>(Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;Lcom/xfinity/playerlib/model/MerlinId;)V
    .locals 0
    .param p1, "video"    # Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;
    .param p2, "merlinId"    # Lcom/xfinity/playerlib/model/MerlinId;

    .prologue
    .line 34
    invoke-direct {p0, p1, p2, p2}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;-><init>(Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;Lcom/xfinity/playerlib/model/MerlinId;Lcom/xfinity/playerlib/model/MerlinId;)V

    .line 35
    return-void
.end method

.method public constructor <init>(Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;Lcom/xfinity/playerlib/model/MerlinId;Lcom/xfinity/playerlib/model/MerlinId;)V
    .locals 0
    .param p1, "video"    # Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;
    .param p2, "programId"    # Lcom/xfinity/playerlib/model/MerlinId;
    .param p3, "parentMerlinIdIfApplicable"    # Lcom/xfinity/playerlib/model/MerlinId;

    .prologue
    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    invoke-static {p1}, Lorg/apache/commons/lang3/Validate;->notNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 26
    invoke-static {p2}, Lorg/apache/commons/lang3/Validate;->notNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 27
    invoke-static {p3}, Lorg/apache/commons/lang3/Validate;->notNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 28
    iput-object p1, p0, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->video:Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;

    .line 29
    iput-object p2, p0, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->programId:Lcom/xfinity/playerlib/model/MerlinId;

    .line 30
    iput-object p3, p0, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->parentMerlinIdIfApplicable:Lcom/xfinity/playerlib/model/MerlinId;

    .line 31
    return-void
.end method

.method private getDownloadProfiles()Ljava/util/List;
    .locals 2
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
    .line 175
    iget-object v1, p0, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->video:Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->getEncoding()Lcom/xfinity/playerlib/model/consumable/hal/HalEncoding;

    move-result-object v0

    .line 176
    .local v0, "encoding":Lcom/xfinity/playerlib/model/consumable/hal/HalEncoding;
    if-nez v0, :cond_0

    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    :goto_0
    return-object v1

    :cond_0
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalEncoding;->getDownloadProfiles()Ljava/util/List;

    move-result-object v1

    goto :goto_0
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 5
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 181
    if-ne p0, p1, :cond_1

    .line 198
    :cond_0
    :goto_0
    return v1

    .line 184
    :cond_1
    if-eqz p1, :cond_2

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    if-eq v3, v4, :cond_3

    :cond_2
    move v1, v2

    .line 185
    goto :goto_0

    :cond_3
    move-object v0, p1

    .line 187
    check-cast v0, Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    .line 188
    .local v0, "that":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->video:Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;

    if-eqz v3, :cond_5

    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->video:Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;

    iget-object v4, v0, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->video:Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;

    invoke-virtual {v3, v4}, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_6

    :cond_4
    move v1, v2

    .line 189
    goto :goto_0

    .line 188
    :cond_5
    iget-object v3, v0, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->video:Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;

    if-nez v3, :cond_4

    .line 191
    :cond_6
    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->parentMerlinIdIfApplicable:Lcom/xfinity/playerlib/model/MerlinId;

    if-eqz v3, :cond_8

    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->parentMerlinIdIfApplicable:Lcom/xfinity/playerlib/model/MerlinId;

    iget-object v4, v0, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->parentMerlinIdIfApplicable:Lcom/xfinity/playerlib/model/MerlinId;

    invoke-virtual {v3, v4}, Lcom/xfinity/playerlib/model/MerlinId;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_9

    :cond_7
    move v1, v2

    .line 192
    goto :goto_0

    .line 191
    :cond_8
    iget-object v3, v0, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->parentMerlinIdIfApplicable:Lcom/xfinity/playerlib/model/MerlinId;

    if-nez v3, :cond_7

    .line 195
    :cond_9
    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->programId:Lcom/xfinity/playerlib/model/MerlinId;

    if-eqz v3, :cond_a

    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->programId:Lcom/xfinity/playerlib/model/MerlinId;

    iget-object v4, v0, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->programId:Lcom/xfinity/playerlib/model/MerlinId;

    invoke-virtual {v3, v4}, Lcom/xfinity/playerlib/model/MerlinId;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    :goto_1
    move v1, v2

    .line 196
    goto :goto_0

    .line 195
    :cond_a
    iget-object v3, v0, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->programId:Lcom/xfinity/playerlib/model/MerlinId;

    if-eqz v3, :cond_0

    goto :goto_1
.end method

.method public getDefaultDownloadProfile()Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;
    .locals 3

    .prologue
    .line 134
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getHighQualityDownloadProfile()Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;

    move-result-object v1

    .line 135
    .local v1, "highQualityProfile":Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;
    if-eqz v1, :cond_0

    .line 139
    .end local v1    # "highQualityProfile":Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;
    :goto_0
    return-object v1

    .line 138
    .restart local v1    # "highQualityProfile":Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;
    :cond_0
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getDownloadProfiles()Ljava/util/List;

    move-result-object v0

    .line 139
    .local v0, "downloadProfiles":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;>;"
    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_1

    const/4 v2, 0x0

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;

    :goto_1
    move-object v1, v2

    goto :goto_0

    :cond_1
    const/4 v2, 0x0

    goto :goto_1
.end method

.method public getDurationInSeconds()I
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->video:Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->getDurationInSeconds()I

    move-result v0

    return v0
.end method

.method public getExpirationDate()Ljava/util/Date;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->video:Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->getExpirationDate()Ljava/util/Date;

    move-result-object v0

    return-object v0
.end method

.method public getHighQualityDownloadProfile()Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;
    .locals 8

    .prologue
    .line 159
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getDownloadProfiles()Ljava/util/List;

    move-result-object v0

    .line 162
    .local v0, "downloadProfiles":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;>;"
    if-eqz v0, :cond_0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v3

    const/4 v4, 0x1

    if-ne v3, v4, :cond_2

    .line 163
    :cond_0
    const/4 v1, 0x0

    .line 171
    :cond_1
    return-object v1

    .line 165
    :cond_2
    const/4 v1, 0x0

    .line 166
    .local v1, "highQualityProfile":Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_3
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;

    .line 167
    .local v2, "thisProfile":Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;
    if-eqz v1, :cond_4

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;->getContentSizeInBytes()J

    move-result-wide v4

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;->getContentSizeInBytes()J

    move-result-wide v6

    cmp-long v4, v4, v6

    if-lez v4, :cond_3

    .line 168
    :cond_4
    move-object v1, v2

    goto :goto_0
.end method

.method public getLanguageCodes()Ljava/util/List;
    .locals 2
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
    .line 125
    iget-object v1, p0, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->video:Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->getEncoding()Lcom/xfinity/playerlib/model/consumable/hal/HalEncoding;

    move-result-object v0

    .line 126
    .local v0, "encoding":Lcom/xfinity/playerlib/model/consumable/hal/HalEncoding;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalEncoding;->getLanguageCodes()Ljava/util/List;

    move-result-object v1

    :goto_0
    return-object v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getLowQualityDownloadProfile()Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;
    .locals 8

    .prologue
    .line 143
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getDownloadProfiles()Ljava/util/List;

    move-result-object v0

    .line 146
    .local v0, "downloadProfiles":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;>;"
    if-eqz v0, :cond_0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v3

    const/4 v4, 0x1

    if-ne v3, v4, :cond_2

    .line 147
    :cond_0
    const/4 v1, 0x0

    .line 155
    :cond_1
    return-object v1

    .line 149
    :cond_2
    const/4 v1, 0x0

    .line 150
    .local v1, "lowQualityProfile":Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_3
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;

    .line 151
    .local v2, "thisProfile":Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;
    if-eqz v1, :cond_4

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;->getContentSizeInBytes()J

    move-result-wide v4

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;->getContentSizeInBytes()J

    move-result-wide v6

    cmp-long v4, v4, v6

    if-gez v4, :cond_3

    .line 152
    :cond_4
    move-object v1, v2

    goto :goto_0
.end method

.method public getNetworkInfo()Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->video:Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->getProvider()Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    move-result-object v0

    return-object v0
.end method

.method public getParentMerlinIdIfApplicable()Lcom/xfinity/playerlib/model/MerlinId;
    .locals 1

    .prologue
    .line 90
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->parentMerlinIdIfApplicable:Lcom/xfinity/playerlib/model/MerlinId;

    return-object v0
.end method

.method public getPid()Ljava/lang/String;
    .locals 2

    .prologue
    .line 77
    iget-object v1, p0, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->video:Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->getEncoding()Lcom/xfinity/playerlib/model/consumable/hal/HalEncoding;

    move-result-object v0

    .line 78
    .local v0, "encoding":Lcom/xfinity/playerlib/model/consumable/hal/HalEncoding;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalEncoding;->getPid()Ljava/lang/String;

    move-result-object v1

    :goto_0
    return-object v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getProgramId()Lcom/xfinity/playerlib/model/MerlinId;
    .locals 1

    .prologue
    .line 86
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->programId:Lcom/xfinity/playerlib/model/MerlinId;

    return-object v0
.end method

.method public getProviderCode()Ljava/lang/String;
    .locals 2

    .prologue
    .line 98
    iget-object v1, p0, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->video:Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->getProvider()Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    move-result-object v0

    .line 99
    .local v0, "provider":Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;
    if-nez v0, :cond_0

    const/4 v1, 0x0

    :goto_0
    return-object v1

    :cond_0
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->getShortCode()Ljava/lang/String;

    move-result-object v1

    goto :goto_0
.end method

.method public getReleaseURL()Ljava/lang/String;
    .locals 4

    .prologue
    const/4 v2, 0x0

    .line 68
    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->video:Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->getEncoding()Lcom/xfinity/playerlib/model/consumable/hal/HalEncoding;

    move-result-object v0

    .line 69
    .local v0, "encoding":Lcom/xfinity/playerlib/model/consumable/hal/HalEncoding;
    if-nez v0, :cond_1

    .line 73
    :cond_0
    :goto_0
    return-object v2

    .line 72
    :cond_1
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalEncoding;->getStreamingProfiles()Ljava/util/List;

    move-result-object v1

    .line 73
    .local v1, "streamingProfiles":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;>;"
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v3

    if-lez v3, :cond_0

    const/4 v2, 0x0

    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;->getManifestUrl()Ljava/lang/String;

    move-result-object v2

    goto :goto_0
.end method

.method public getSecureMetadata()Ljava/lang/String;
    .locals 4

    .prologue
    const/4 v2, 0x0

    .line 58
    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->video:Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->getEncoding()Lcom/xfinity/playerlib/model/consumable/hal/HalEncoding;

    move-result-object v0

    .line 59
    .local v0, "encoding":Lcom/xfinity/playerlib/model/consumable/hal/HalEncoding;
    if-nez v0, :cond_1

    .line 63
    :cond_0
    :goto_0
    return-object v2

    .line 62
    :cond_1
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalEncoding;->getStreamingProfiles()Ljava/util/List;

    move-result-object v1

    .line 63
    .local v1, "streamingProfiles":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;>;"
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v3

    if-lez v3, :cond_0

    const/4 v2, 0x0

    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;->getSecData()Ljava/lang/String;

    move-result-object v2

    goto :goto_0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 94
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->video:Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->getTitle()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getVideoId()J
    .locals 2

    .prologue
    .line 82
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->video:Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->getVideoId()J

    move-result-wide v0

    return-wide v0
.end method

.method public getVideoRating()Lcom/comcast/cim/model/Rating;
    .locals 2

    .prologue
    .line 46
    iget-object v1, p0, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->video:Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->getContentRating()Ljava/lang/String;

    move-result-object v0

    .line 47
    .local v0, "consumableVideoRating":Ljava/lang/String;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 48
    :cond_0
    const/4 v1, 0x0

    .line 50
    :goto_0
    return-object v1

    :cond_1
    new-instance v1, Lcom/comcast/cim/model/Rating;

    invoke-direct {v1, v0}, Lcom/comcast/cim/model/Rating;-><init>(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public getVideoSubRating()Ljava/lang/String;
    .locals 1

    .prologue
    .line 103
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->video:Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->getSubRating()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public hashCode()I
    .locals 4

    .prologue
    const/4 v1, 0x0

    .line 203
    iget-object v2, p0, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->video:Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;

    if-eqz v2, :cond_1

    iget-object v2, p0, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->video:Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->hashCode()I

    move-result v0

    .line 204
    .local v0, "result":I
    :goto_0
    mul-int/lit8 v3, v0, 0x1f

    iget-object v2, p0, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->programId:Lcom/xfinity/playerlib/model/MerlinId;

    if-eqz v2, :cond_2

    iget-object v2, p0, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->programId:Lcom/xfinity/playerlib/model/MerlinId;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/MerlinId;->hashCode()I

    move-result v2

    :goto_1
    add-int v0, v3, v2

    .line 205
    mul-int/lit8 v2, v0, 0x1f

    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->parentMerlinIdIfApplicable:Lcom/xfinity/playerlib/model/MerlinId;

    if-eqz v3, :cond_0

    iget-object v1, p0, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->parentMerlinIdIfApplicable:Lcom/xfinity/playerlib/model/MerlinId;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/MerlinId;->hashCode()I

    move-result v1

    :cond_0
    add-int v0, v2, v1

    .line 206
    return v0

    .end local v0    # "result":I
    :cond_1
    move v0, v1

    .line 203
    goto :goto_0

    .restart local v0    # "result":I
    :cond_2
    move v2, v1

    .line 204
    goto :goto_1
.end method

.method public isAdult()Z
    .locals 1

    .prologue
    .line 117
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->video:Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->isAdult()Z

    move-result v0

    return v0
.end method

.method public isCC()Z
    .locals 2

    .prologue
    .line 111
    iget-object v1, p0, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->video:Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->getEncoding()Lcom/xfinity/playerlib/model/consumable/hal/HalEncoding;

    move-result-object v0

    .line 112
    .local v0, "encoding":Lcom/xfinity/playerlib/model/consumable/hal/HalEncoding;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalEncoding;->hasClosedCaptions()Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public isDownloadable()Z
    .locals 1

    .prologue
    .line 130
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getDownloadProfiles()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isMovie()Z
    .locals 2

    .prologue
    .line 107
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->programId:Lcom/xfinity/playerlib/model/MerlinId;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/MerlinId;->getNamespace()Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    move-result-object v0

    sget-object v1, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->Movie:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method
