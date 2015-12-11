.class public Lcom/comcast/cim/analytics/VideoErrorEventData;
.super Lcom/comcast/cim/analytics/XfinityEventData;
.source "VideoErrorEventData.java"


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "ev"    # Ljava/lang/String;
    .param p2, "hashedOmnitureGuid"    # Ljava/lang/String;
    .param p3, "versionNumber"    # Ljava/lang/String;

    .prologue
    .line 25
    invoke-direct {p0, p1}, Lcom/comcast/cim/analytics/XfinityEventData;-><init>(Ljava/lang/String;)V

    .line 26
    invoke-virtual {p0, p2}, Lcom/comcast/cim/analytics/VideoErrorEventData;->setOmnitureTrackingKey(Ljava/lang/String;)V

    .line 27
    invoke-virtual {p0, p3}, Lcom/comcast/cim/analytics/VideoErrorEventData;->setAppVersion(Ljava/lang/String;)V

    .line 28
    return-void
.end method

.method private convertLanguagesListToCsv(Ljava/util/List;)Ljava/lang/String;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 111
    .local p1, "languages":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 112
    .local v1, "languageStringBuilder":Ljava/lang/StringBuilder;
    if-eqz p1, :cond_1

    .line 113
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 114
    .local v0, "language":Ljava/lang/String;
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->length()I

    move-result v3

    if-lez v3, :cond_0

    .line 115
    const-string v3, ","

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 117
    :cond_0
    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 120
    .end local v0    # "language":Ljava/lang/String;
    :cond_1
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method


# virtual methods
.method public setAppVersion(Ljava/lang/String;)V
    .locals 1
    .param p1, "versionNumber"    # Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 61
    const-string v0, "appVersion"

    invoke-virtual {p0, v0, p1}, Lcom/comcast/cim/analytics/VideoErrorEventData;->addData(Ljava/lang/String;Ljava/lang/String;)V

    .line 62
    return-void
.end method

.method public setBitrate(J)V
    .locals 3
    .param p1, "bitrate"    # J
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 97
    const-string v0, "bitrate"

    invoke-static {p1, p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/comcast/cim/analytics/VideoErrorEventData;->addData(Ljava/lang/String;Ljava/lang/String;)V

    .line 98
    return-void
.end method

.method public setCc(Z)V
    .locals 2
    .param p1, "cc"    # Z
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 86
    const-string v0, "cc"

    invoke-static {p1}, Ljava/lang/String;->valueOf(Z)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/comcast/cim/analytics/VideoErrorEventData;->addData(Ljava/lang/String;Ljava/lang/String;)V

    .line 87
    return-void
.end method

.method public setCurrentPlaybackPosition(J)V
    .locals 3
    .param p1, "currentPlaybackPosition"    # J
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 102
    const-string v0, "playbackPosition"

    invoke-static {p1, p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/comcast/cim/analytics/VideoErrorEventData;->addData(Ljava/lang/String;Ljava/lang/String;)V

    .line 103
    return-void
.end method

.method public setErrorCodes(Ljava/lang/String;)V
    .locals 3
    .param p1, "code"    # Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 52
    const-string v1, "\\."

    invoke-virtual {p1, v1}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 53
    .local v0, "codes":[Ljava/lang/String;
    const/4 v1, 0x0

    aget-object v1, v0, v1

    invoke-virtual {p0, v1}, Lcom/comcast/cim/analytics/VideoErrorEventData;->setEventType(Ljava/lang/String;)V

    .line 54
    array-length v1, v0

    const/4 v2, 0x2

    if-ne v1, v2, :cond_0

    .line 55
    const/4 v1, 0x1

    aget-object v1, v0, v1

    invoke-virtual {p0, v1}, Lcom/comcast/cim/analytics/VideoErrorEventData;->setMinorErrorCode(Ljava/lang/String;)V

    .line 57
    :cond_0
    return-void
.end method

.method public setErrorMessage(Ljava/lang/String;)V
    .locals 1
    .param p1, "errorMessage"    # Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 42
    const-string v0, "errorMessage"

    invoke-virtual {p0, v0, p1}, Lcom/comcast/cim/analytics/VideoErrorEventData;->addData(Ljava/lang/String;Ljava/lang/String;)V

    .line 43
    return-void
.end method

.method public setErrorTitle(Ljava/lang/String;)V
    .locals 1
    .param p1, "description"    # Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 37
    const-string v0, "errorTitle"

    invoke-virtual {p0, v0, p1}, Lcom/comcast/cim/analytics/VideoErrorEventData;->addData(Ljava/lang/String;Ljava/lang/String;)V

    .line 38
    return-void
.end method

.method public setEventType(Ljava/lang/String;)V
    .locals 1
    .param p1, "code"    # Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 32
    const-string v0, "eventType"

    invoke-virtual {p0, v0, p1}, Lcom/comcast/cim/analytics/VideoErrorEventData;->addData(Ljava/lang/String;Ljava/lang/String;)V

    .line 33
    return-void
.end method

.method public setInAd(Z)V
    .locals 2
    .param p1, "isInAd"    # Z
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 107
    const-string v0, "inAd"

    invoke-static {p1}, Ljava/lang/String;->valueOf(Z)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/comcast/cim/analytics/VideoErrorEventData;->addData(Ljava/lang/String;Ljava/lang/String;)V

    .line 108
    return-void
.end method

.method public setLanguages(Ljava/util/List;)V
    .locals 2
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 91
    .local p1, "languages":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-direct {p0, p1}, Lcom/comcast/cim/analytics/VideoErrorEventData;->convertLanguagesListToCsv(Ljava/util/List;)Ljava/lang/String;

    move-result-object v0

    .line 92
    .local v0, "languageStr":Ljava/lang/String;
    const-string v1, "languages"

    invoke-virtual {p0, v1, v0}, Lcom/comcast/cim/analytics/VideoErrorEventData;->addData(Ljava/lang/String;Ljava/lang/String;)V

    .line 93
    return-void
.end method

.method public setMinorErrorCode(Ljava/lang/String;)V
    .locals 1
    .param p1, "subCode"    # Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 47
    const-string v0, "errorMinorCode"

    invoke-virtual {p0, v0, p1}, Lcom/comcast/cim/analytics/VideoErrorEventData;->addData(Ljava/lang/String;Ljava/lang/String;)V

    .line 48
    return-void
.end method

.method public setOmnitureTrackingKey(Ljava/lang/String;)V
    .locals 1
    .param p1, "hashedOmnitureGuid"    # Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 76
    const-string v0, "omnitureTrackingKey"

    invoke-virtual {p0, v0, p1}, Lcom/comcast/cim/analytics/VideoErrorEventData;->addData(Ljava/lang/String;Ljava/lang/String;)V

    .line 77
    return-void
.end method

.method public setPid(Ljava/lang/String;)V
    .locals 1
    .param p1, "pid"    # Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 66
    const-string v0, "pid"

    invoke-virtual {p0, v0, p1}, Lcom/comcast/cim/analytics/VideoErrorEventData;->addData(Ljava/lang/String;Ljava/lang/String;)V

    .line 67
    return-void
.end method

.method public setReleaseUrl(Ljava/lang/String;)V
    .locals 1
    .param p1, "releaseUrl"    # Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 81
    const-string v0, "release_url"

    invoke-virtual {p0, v0, p1}, Lcom/comcast/cim/analytics/VideoErrorEventData;->addData(Ljava/lang/String;Ljava/lang/String;)V

    .line 82
    return-void
.end method

.method public setVideoTitle(Ljava/lang/String;)V
    .locals 1
    .param p1, "title"    # Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 71
    const-string v0, "videoTitle"

    invoke-virtual {p0, v0, p1}, Lcom/comcast/cim/analytics/VideoErrorEventData;->addData(Ljava/lang/String;Ljava/lang/String;)V

    .line 72
    return-void
.end method
