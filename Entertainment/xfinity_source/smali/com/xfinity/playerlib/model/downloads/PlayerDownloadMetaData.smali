.class public Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;
.super Lcom/comcast/cim/downloads/DownloadMetaData;
.source "PlayerDownloadMetaData.java"


# annotations
.annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnoreProperties;
    ignoreUnknown = true
.end annotation


# instance fields
.field private final downloadDate:Ljava/util/Date;

.field private final expectedFileSizeInBytes:J

.field private volatile lastLicenseRenewal:Ljava/util/Date;

.field private volatile licenseExpiration:Ljava/util/Date;

.field private final uuid:Ljava/util/UUID;

.field private final videoId:J

.field private final watchableKey:Lcom/xfinity/playerlib/model/consumable/WatchableKey;


# direct methods
.method public constructor <init>(Ljava/util/UUID;Lcom/xfinity/playerlib/model/consumable/WatchableKey;JLjava/util/Date;JLjava/util/Date;Ljava/util/Date;)V
    .locals 0
    .param p1, "uuid"    # Ljava/util/UUID;
        .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
            value = "uuid"
        .end annotation
    .end param
    .param p2, "watchableKey"    # Lcom/xfinity/playerlib/model/consumable/WatchableKey;
        .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
            value = "watchableKey"
        .end annotation
    .end param
    .param p3, "videoId"    # J
        .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
            value = "videoId"
        .end annotation
    .end param
    .param p5, "downloadDate"    # Ljava/util/Date;
        .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
            value = "downloadDate"
        .end annotation
    .end param
    .param p6, "expectedFileSizeInBytes"    # J
        .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
            value = "expectedFileSizeInBytes"
        .end annotation
    .end param
    .param p8, "lastLicenseRenewal"    # Ljava/util/Date;
        .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
            value = "lastLicenseRenewal"
        .end annotation
    .end param
    .param p9, "licenseExpiration"    # Ljava/util/Date;
        .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
            value = "licenseExpiration"
        .end annotation
    .end param

    .prologue
    .line 27
    invoke-direct {p0}, Lcom/comcast/cim/downloads/DownloadMetaData;-><init>()V

    .line 28
    iput-object p1, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;->uuid:Ljava/util/UUID;

    .line 29
    iput-object p2, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;->watchableKey:Lcom/xfinity/playerlib/model/consumable/WatchableKey;

    .line 30
    iput-wide p3, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;->videoId:J

    .line 31
    iput-object p5, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;->downloadDate:Ljava/util/Date;

    .line 32
    iput-wide p6, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;->expectedFileSizeInBytes:J

    .line 33
    iput-object p8, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;->lastLicenseRenewal:Ljava/util/Date;

    .line 34
    iput-object p9, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;->licenseExpiration:Ljava/util/Date;

    .line 35
    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 8
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 75
    if-ne p0, p1, :cond_1

    .line 105
    :cond_0
    :goto_0
    return v1

    .line 78
    :cond_1
    if-eqz p1, :cond_2

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    if-eq v3, v4, :cond_3

    :cond_2
    move v1, v2

    .line 79
    goto :goto_0

    :cond_3
    move-object v0, p1

    .line 81
    check-cast v0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;

    .line 82
    .local v0, "metaData":Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;
    iget-wide v4, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;->expectedFileSizeInBytes:J

    iget-wide v6, v0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;->expectedFileSizeInBytes:J

    cmp-long v3, v4, v6

    if-eqz v3, :cond_4

    move v1, v2

    .line 83
    goto :goto_0

    .line 85
    :cond_4
    iget-wide v4, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;->videoId:J

    iget-wide v6, v0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;->videoId:J

    cmp-long v3, v4, v6

    if-eqz v3, :cond_5

    move v1, v2

    .line 86
    goto :goto_0

    .line 88
    :cond_5
    iget-object v3, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;->downloadDate:Ljava/util/Date;

    if-eqz v3, :cond_7

    iget-object v3, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;->downloadDate:Ljava/util/Date;

    iget-object v4, v0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;->downloadDate:Ljava/util/Date;

    invoke-virtual {v3, v4}, Ljava/util/Date;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_8

    :cond_6
    move v1, v2

    .line 89
    goto :goto_0

    .line 88
    :cond_7
    iget-object v3, v0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;->downloadDate:Ljava/util/Date;

    if-nez v3, :cond_6

    .line 92
    :cond_8
    iget-object v3, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;->watchableKey:Lcom/xfinity/playerlib/model/consumable/WatchableKey;

    if-eqz v3, :cond_a

    iget-object v3, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;->watchableKey:Lcom/xfinity/playerlib/model/consumable/WatchableKey;

    iget-object v4, v0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;->watchableKey:Lcom/xfinity/playerlib/model/consumable/WatchableKey;

    invoke-virtual {v3, v4}, Lcom/xfinity/playerlib/model/consumable/WatchableKey;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_b

    :cond_9
    move v1, v2

    .line 93
    goto :goto_0

    .line 92
    :cond_a
    iget-object v3, v0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;->watchableKey:Lcom/xfinity/playerlib/model/consumable/WatchableKey;

    if-nez v3, :cond_9

    .line 96
    :cond_b
    iget-object v3, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;->lastLicenseRenewal:Ljava/util/Date;

    if-eqz v3, :cond_d

    iget-object v3, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;->lastLicenseRenewal:Ljava/util/Date;

    iget-object v4, v0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;->lastLicenseRenewal:Ljava/util/Date;

    invoke-virtual {v3, v4}, Ljava/util/Date;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_e

    :cond_c
    move v1, v2

    .line 97
    goto :goto_0

    .line 96
    :cond_d
    iget-object v3, v0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;->lastLicenseRenewal:Ljava/util/Date;

    if-nez v3, :cond_c

    .line 101
    :cond_e
    iget-object v3, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;->licenseExpiration:Ljava/util/Date;

    if-eqz v3, :cond_f

    iget-object v3, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;->licenseExpiration:Ljava/util/Date;

    iget-object v4, v0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;->licenseExpiration:Ljava/util/Date;

    invoke-virtual {v3, v4}, Ljava/util/Date;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    :goto_1
    move v1, v2

    .line 102
    goto :goto_0

    .line 101
    :cond_f
    iget-object v3, v0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;->licenseExpiration:Ljava/util/Date;

    if-eqz v3, :cond_0

    goto :goto_1
.end method

.method public getDownloadDate()Ljava/util/Date;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;->downloadDate:Ljava/util/Date;

    return-object v0
.end method

.method public getExpectedFileSizeInBytes()J
    .locals 2

    .prologue
    .line 54
    iget-wide v0, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;->expectedFileSizeInBytes:J

    return-wide v0
.end method

.method public getLastLicenseRenewal()Ljava/util/Date;
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;->lastLicenseRenewal:Ljava/util/Date;

    return-object v0
.end method

.method public getLicenseExpiration()Ljava/util/Date;
    .locals 1

    .prologue
    .line 66
    iget-object v0, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;->licenseExpiration:Ljava/util/Date;

    return-object v0
.end method

.method public getUuid()Ljava/util/UUID;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;->uuid:Ljava/util/UUID;

    return-object v0
.end method

.method public getVideoId()J
    .locals 2

    .prologue
    .line 46
    iget-wide v0, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;->videoId:J

    return-wide v0
.end method

.method public getWatchableKey()Lcom/xfinity/playerlib/model/consumable/WatchableKey;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;->watchableKey:Lcom/xfinity/playerlib/model/consumable/WatchableKey;

    return-object v0
.end method

.method public hashCode()I
    .locals 9

    .prologue
    const/16 v8, 0x20

    const/4 v1, 0x0

    .line 110
    iget-object v2, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;->uuid:Ljava/util/UUID;

    if-eqz v2, :cond_1

    iget-object v2, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;->uuid:Ljava/util/UUID;

    invoke-virtual {v2}, Ljava/util/UUID;->hashCode()I

    move-result v0

    .line 111
    .local v0, "result":I
    :goto_0
    mul-int/lit8 v3, v0, 0x1f

    iget-object v2, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;->watchableKey:Lcom/xfinity/playerlib/model/consumable/WatchableKey;

    if-eqz v2, :cond_2

    iget-object v2, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;->watchableKey:Lcom/xfinity/playerlib/model/consumable/WatchableKey;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/consumable/WatchableKey;->hashCode()I

    move-result v2

    :goto_1
    add-int v0, v3, v2

    .line 112
    mul-int/lit8 v2, v0, 0x1f

    iget-wide v4, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;->videoId:J

    iget-wide v6, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;->videoId:J

    ushr-long/2addr v6, v8

    xor-long/2addr v4, v6

    long-to-int v3, v4

    add-int v0, v2, v3

    .line 113
    mul-int/lit8 v3, v0, 0x1f

    iget-object v2, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;->downloadDate:Ljava/util/Date;

    if-eqz v2, :cond_3

    iget-object v2, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;->downloadDate:Ljava/util/Date;

    invoke-virtual {v2}, Ljava/util/Date;->hashCode()I

    move-result v2

    :goto_2
    add-int v0, v3, v2

    .line 114
    mul-int/lit8 v2, v0, 0x1f

    iget-wide v4, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;->expectedFileSizeInBytes:J

    iget-wide v6, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;->expectedFileSizeInBytes:J

    ushr-long/2addr v6, v8

    xor-long/2addr v4, v6

    long-to-int v3, v4

    add-int v0, v2, v3

    .line 115
    mul-int/lit8 v3, v0, 0x1f

    iget-object v2, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;->lastLicenseRenewal:Ljava/util/Date;

    if-eqz v2, :cond_4

    iget-object v2, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;->lastLicenseRenewal:Ljava/util/Date;

    invoke-virtual {v2}, Ljava/util/Date;->hashCode()I

    move-result v2

    :goto_3
    add-int v0, v3, v2

    .line 116
    mul-int/lit8 v2, v0, 0x1f

    iget-object v3, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;->licenseExpiration:Ljava/util/Date;

    if-eqz v3, :cond_0

    iget-object v1, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;->licenseExpiration:Ljava/util/Date;

    invoke-virtual {v1}, Ljava/util/Date;->hashCode()I

    move-result v1

    :cond_0
    add-int v0, v2, v1

    .line 117
    return v0

    .end local v0    # "result":I
    :cond_1
    move v0, v1

    .line 110
    goto :goto_0

    .restart local v0    # "result":I
    :cond_2
    move v2, v1

    .line 111
    goto :goto_1

    :cond_3
    move v2, v1

    .line 113
    goto :goto_2

    :cond_4
    move v2, v1

    .line 115
    goto :goto_3
.end method

.method public setLastLicenseRenewal(Ljava/util/Date;)V
    .locals 0
    .param p1, "lastLicenseRenewal"    # Ljava/util/Date;

    .prologue
    .line 62
    iput-object p1, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;->lastLicenseRenewal:Ljava/util/Date;

    .line 63
    return-void
.end method

.method public setLicenseExpiration(Ljava/util/Date;)V
    .locals 0
    .param p1, "licenseExpiration"    # Ljava/util/Date;

    .prologue
    .line 70
    iput-object p1, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;->licenseExpiration:Ljava/util/Date;

    .line 71
    return-void
.end method
