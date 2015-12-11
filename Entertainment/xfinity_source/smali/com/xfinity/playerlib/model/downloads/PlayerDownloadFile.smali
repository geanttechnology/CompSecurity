.class public Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
.super Lcom/comcast/cim/downloads/DownloadFile;
.source "PlayerDownloadFile.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile$ExpirationStatus;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/downloads/DownloadFile",
        "<",
        "Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;",
        ">;"
    }
.end annotation


# instance fields
.field private volatile watchable:Lcom/xfinity/playerlib/model/consumable/Watchable;


# direct methods
.method public constructor <init>(Lcom/penthera/virtuososdk/client/IVirtuosoAsset;Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;Lcom/xfinity/playerlib/model/consumable/Watchable;)V
    .locals 0
    .param p1, "asset"    # Lcom/penthera/virtuososdk/client/IVirtuosoAsset;
    .param p2, "metaData"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;
    .param p3, "watchable"    # Lcom/xfinity/playerlib/model/consumable/Watchable;

    .prologue
    .line 38
    invoke-direct {p0, p1, p2}, Lcom/comcast/cim/downloads/DownloadFile;-><init>(Lcom/penthera/virtuososdk/client/IVirtuosoAsset;Lcom/comcast/cim/downloads/DownloadMetaData;)V

    .line 39
    invoke-static {p3}, Lorg/apache/commons/lang3/Validate;->notNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 40
    iput-object p3, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->watchable:Lcom/xfinity/playerlib/model/consumable/Watchable;

    .line 41
    return-void
.end method


# virtual methods
.method public downloadVideoExistsInWatchable(Lcom/xfinity/playerlib/model/consumable/Watchable;)Z
    .locals 6
    .param p1, "otherWatchable"    # Lcom/xfinity/playerlib/model/consumable/Watchable;

    .prologue
    .line 119
    invoke-interface {p1}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getVideos()Ljava/util/Set;

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

    .line 120
    .local v0, "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getVideoId()J

    move-result-wide v2

    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getVideoId()J

    move-result-wide v4

    cmp-long v2, v2, v4

    if-nez v2, :cond_0

    .line 121
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->isDownloadable()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 122
    const/4 v1, 0x1

    .line 127
    .end local v0    # "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    :goto_0
    return v1

    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getAssetExpirationDate()Ljava/util/Date;
    .locals 1

    .prologue
    .line 106
    iget-object v0, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->watchable:Lcom/xfinity/playerlib/model/consumable/Watchable;

    invoke-interface {v0}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getExpiresDate()Ljava/util/Date;

    move-result-object v0

    return-object v0
.end method

.method public getDownloadDate()Ljava/util/Date;
    .locals 1

    .prologue
    .line 110
    iget-object v0, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->metaData:Lcom/comcast/cim/downloads/DownloadMetaData;

    check-cast v0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;->getDownloadDate()Ljava/util/Date;

    move-result-object v0

    return-object v0
.end method

.method public getExpectedFileSizeInMb()I
    .locals 4

    .prologue
    .line 114
    iget-object v2, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->metaData:Lcom/comcast/cim/downloads/DownloadMetaData;

    check-cast v2, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;->getExpectedFileSizeInBytes()J

    move-result-wide v0

    .line 115
    .local v0, "expectedSizeInBytes":J
    const-wide/32 v2, 0x100000

    div-long v2, v0, v2

    long-to-int v2, v2

    return v2
.end method

.method public getExpirationStatus()Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile$ExpirationStatus;
    .locals 2

    .prologue
    .line 68
    new-instance v0, Ljava/util/Date;

    invoke-direct {v0}, Ljava/util/Date;-><init>()V

    .line 69
    .local v0, "now":Ljava/util/Date;
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getAssetExpirationDate()Ljava/util/Date;

    move-result-object v1

    if-eqz v1, :cond_0

    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getAssetExpirationDate()Ljava/util/Date;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/Date;->compareTo(Ljava/util/Date;)I

    move-result v1

    if-ltz v1, :cond_0

    .line 70
    sget-object v1, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile$ExpirationStatus;->AAW_EXPIRED:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile$ExpirationStatus;

    .line 75
    :goto_0
    return-object v1

    .line 72
    :cond_0
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getLicenseExpirationDate()Ljava/util/Date;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/Date;->compareTo(Ljava/util/Date;)I

    move-result v1

    if-ltz v1, :cond_1

    .line 73
    sget-object v1, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile$ExpirationStatus;->OVP_EXPIRED:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile$ExpirationStatus;

    goto :goto_0

    .line 75
    :cond_1
    sget-object v1, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile$ExpirationStatus;->NOT_EXPIRED:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile$ExpirationStatus;

    goto :goto_0
.end method

.method public getLastLicenseRenewalDate()Ljava/util/Date;
    .locals 1

    .prologue
    .line 92
    iget-object v0, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->metaData:Lcom/comcast/cim/downloads/DownloadMetaData;

    check-cast v0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;->getLastLicenseRenewal()Ljava/util/Date;

    move-result-object v0

    return-object v0
.end method

.method public getLicenseExpirationDate()Ljava/util/Date;
    .locals 1

    .prologue
    .line 84
    iget-object v0, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->metaData:Lcom/comcast/cim/downloads/DownloadMetaData;

    check-cast v0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;->getLicenseExpiration()Ljava/util/Date;

    move-result-object v0

    return-object v0
.end method

.method public getPlaylistUri()Ljava/lang/String;
    .locals 2

    .prologue
    .line 131
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getFileDirectory()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "variant.m3u8"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getUuid()Ljava/util/UUID;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->metaData:Lcom/comcast/cim/downloads/DownloadMetaData;

    check-cast v0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;->getUuid()Ljava/util/UUID;

    move-result-object v0

    return-object v0
.end method

.method public getVideo()Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .locals 4

    .prologue
    .line 60
    iget-object v1, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->watchable:Lcom/xfinity/playerlib/model/consumable/Watchable;

    iget-object v0, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->metaData:Lcom/comcast/cim/downloads/DownloadMetaData;

    check-cast v0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;->getVideoId()J

    move-result-wide v2

    invoke-interface {v1, v2, v3}, Lcom/xfinity/playerlib/model/consumable/Watchable;->findVideoById(J)Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    move-result-object v0

    return-object v0
.end method

.method public getVideoId()J
    .locals 2

    .prologue
    .line 56
    iget-object v0, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->metaData:Lcom/comcast/cim/downloads/DownloadMetaData;

    check-cast v0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;->getVideoId()J

    move-result-wide v0

    return-wide v0
.end method

.method public getWatchable()Lcom/xfinity/playerlib/model/consumable/Watchable;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->watchable:Lcom/xfinity/playerlib/model/consumable/Watchable;

    return-object v0
.end method

.method public getWatchableKey()Lcom/xfinity/playerlib/model/consumable/WatchableKey;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->metaData:Lcom/comcast/cim/downloads/DownloadMetaData;

    check-cast v0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;->getWatchableKey()Lcom/xfinity/playerlib/model/consumable/WatchableKey;

    move-result-object v0

    return-object v0
.end method

.method public setLastLicenseRenewalDate(Ljava/util/Date;)V
    .locals 1
    .param p1, "date"    # Ljava/util/Date;

    .prologue
    .line 96
    iget-object v0, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->metaData:Lcom/comcast/cim/downloads/DownloadMetaData;

    check-cast v0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;

    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;->setLastLicenseRenewal(Ljava/util/Date;)V

    .line 97
    return-void
.end method

.method public setLicenseExpirationDate(Ljava/util/Date;)V
    .locals 1
    .param p1, "date"    # Ljava/util/Date;

    .prologue
    .line 88
    iget-object v0, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->metaData:Lcom/comcast/cim/downloads/DownloadMetaData;

    check-cast v0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;

    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;->setLicenseExpiration(Ljava/util/Date;)V

    .line 89
    return-void
.end method

.method public setWatchable(Lcom/xfinity/playerlib/model/consumable/Watchable;)V
    .locals 0
    .param p1, "watchable"    # Lcom/xfinity/playerlib/model/consumable/Watchable;

    .prologue
    .line 64
    iput-object p1, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->watchable:Lcom/xfinity/playerlib/model/consumable/Watchable;

    .line 65
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    .prologue
    .line 136
    new-instance v0, Lorg/apache/commons/lang3/builder/ToStringBuilder;

    sget-object v1, Lorg/apache/commons/lang3/builder/ToStringStyle;->SHORT_PREFIX_STYLE:Lorg/apache/commons/lang3/builder/ToStringStyle;

    invoke-direct {v0, p0, v1}, Lorg/apache/commons/lang3/builder/ToStringBuilder;-><init>(Ljava/lang/Object;Lorg/apache/commons/lang3/builder/ToStringStyle;)V

    const-string v1, "title"

    iget-object v2, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->watchable:Lcom/xfinity/playerlib/model/consumable/Watchable;

    .line 137
    invoke-interface {v2}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getTitle()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lorg/apache/commons/lang3/builder/ToStringBuilder;

    move-result-object v0

    const-string v1, "merlinId"

    iget-object v2, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->watchable:Lcom/xfinity/playerlib/model/consumable/Watchable;

    .line 138
    invoke-interface {v2}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lorg/apache/commons/lang3/builder/ToStringBuilder;

    move-result-object v0

    const-string v1, "uuid"

    iget-object v2, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->asset:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    .line 139
    invoke-interface {v2}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->uuid()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lorg/apache/commons/lang3/builder/ToStringBuilder;

    move-result-object v0

    .line 140
    invoke-virtual {v0}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
