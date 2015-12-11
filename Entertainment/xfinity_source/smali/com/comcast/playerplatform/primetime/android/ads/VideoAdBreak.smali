.class public Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
.super Ljava/lang/Object;
.source "VideoAdBreak.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak$1;
    }
.end annotation


# instance fields
.field private duration:J

.field private hasBeenSeen:Z

.field private id:Ljava/lang/String;

.field private isPauseDisabled:Z

.field private isSeekDisabled:Z

.field private markerPosition:J

.field private percentComplete:I

.field private restrictions:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction;",
            ">;"
        }
    .end annotation
.end field

.field private secondsRemaining:J

.field private startTime:J

.field private videoAdsList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 6

    .prologue
    const-wide/16 v4, 0x0

    const-wide/16 v2, -0x1

    const/4 v1, 0x1

    .line 42
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    iput-wide v4, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->secondsRemaining:J

    .line 17
    iput-wide v4, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->duration:J

    .line 18
    iput-wide v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->startTime:J

    .line 20
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->videoAdsList:Ljava/util/List;

    .line 23
    iput-boolean v1, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->isSeekDisabled:Z

    .line 24
    iput-boolean v1, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->isPauseDisabled:Z

    .line 25
    iput-wide v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->markerPosition:J

    .line 43
    return-void
.end method

.method public constructor <init>(Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;)V
    .locals 6
    .param p1, "videoAd"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    .prologue
    const-wide/16 v4, 0x0

    const-wide/16 v2, -0x1

    const/4 v1, 0x1

    .line 50
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    iput-wide v4, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->secondsRemaining:J

    .line 17
    iput-wide v4, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->duration:J

    .line 18
    iput-wide v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->startTime:J

    .line 20
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->videoAdsList:Ljava/util/List;

    .line 23
    iput-boolean v1, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->isSeekDisabled:Z

    .line 24
    iput-boolean v1, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->isPauseDisabled:Z

    .line 25
    iput-wide v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->markerPosition:J

    .line 51
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->videoAdsList:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 52
    iget-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->duration:J

    invoke-virtual {p1}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->getDuration()J

    move-result-wide v2

    add-long/2addr v0, v2

    iput-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->duration:J

    .line 53
    iget-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->duration:J

    iput-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->secondsRemaining:J

    .line 54
    invoke-virtual {p1}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->getStartTime()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->startTime:J

    .line 55
    return-void
.end method

.method private updateInternalValues(Ljava/util/List;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 142
    .local p1, "videoAdsList":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;>;"
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    .line 143
    .local v0, "ad":Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;
    iget-wide v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->duration:J

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->getDuration()J

    move-result-wide v4

    add-long/2addr v2, v4

    iput-wide v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->duration:J

    .line 145
    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->getStartTime()J

    move-result-wide v2

    iget-wide v4, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->startTime:J

    cmp-long v2, v2, v4

    if-gez v2, :cond_0

    .line 146
    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->getStartTime()J

    move-result-wide v2

    iput-wide v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->startTime:J

    .line 147
    iget-wide v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->startTime:J

    iput-wide v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->markerPosition:J

    goto :goto_0

    .line 150
    .end local v0    # "ad":Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;
    :cond_1
    iget-wide v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->duration:J

    iput-wide v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->secondsRemaining:J

    .line 151
    return-void
.end method


# virtual methods
.method public addAd(Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;)V
    .locals 4
    .param p1, "ad"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    .prologue
    .line 261
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->videoAdsList:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 262
    iget-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->duration:J

    invoke-virtual {p1}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->getDuration()J

    move-result-wide v2

    add-long/2addr v0, v2

    iput-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->duration:J

    .line 263
    iget-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->duration:J

    iput-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->secondsRemaining:J

    .line 264
    iget-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->startTime:J

    const-wide/16 v2, -0x1

    cmp-long v0, v0, v2

    if-eqz v0, :cond_0

    iget-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->startTime:J

    invoke-virtual {p1}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->getStartTime()J

    move-result-wide v2

    cmp-long v0, v0, v2

    if-lez v0, :cond_1

    .line 265
    :cond_0
    invoke-virtual {p1}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->getStartTime()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->startTime:J

    .line 266
    iget-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->startTime:J

    iput-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->markerPosition:J

    .line 268
    :cond_1
    return-void
.end method

.method public addRestriction(Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction;)V
    .locals 2
    .param p1, "restriction"    # Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction;

    .prologue
    .line 227
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->restrictions:Ljava/util/List;

    if-nez v0, :cond_0

    .line 228
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->restrictions:Ljava/util/List;

    .line 231
    :cond_0
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->restrictions:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 233
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak$1;->$SwitchMap$com$comcast$playerplatform$primetime$android$ads$AdRestriction$RestrictionType:[I

    invoke-virtual {p1}, Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction;->getType()Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction$RestrictionType;

    move-result-object v1

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction$RestrictionType;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 242
    :goto_0
    return-void

    .line 235
    :pswitch_0
    invoke-virtual {p1}, Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction;->isRestricted()Z

    move-result v0

    iput-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->isSeekDisabled:Z

    goto :goto_0

    .line 238
    :pswitch_1
    invoke-virtual {p1}, Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction;->isRestricted()Z

    move-result v0

    iput-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->isPauseDisabled:Z

    goto :goto_0

    .line 233
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public coversLocation(J)Z
    .locals 7
    .param p1, "location"    # J

    .prologue
    const/4 v0, 0x0

    .line 188
    iget-wide v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->startTime:J

    const-wide/16 v4, -0x1

    cmp-long v1, v2, v4

    if-eqz v1, :cond_0

    iget-wide v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->duration:J

    const-wide/16 v4, 0x0

    cmp-long v1, v2, v4

    if-lez v1, :cond_0

    .line 189
    iget-wide v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->startTime:J

    cmp-long v1, v2, p1

    if-gtz v1, :cond_0

    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->getEndTime()J

    move-result-wide v2

    cmp-long v1, p1, v2

    if-gtz v1, :cond_0

    const/4 v0, 0x1

    .line 191
    :cond_0
    return v0
.end method

.method public getAdAtLocation(J)Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;
    .locals 3
    .param p1, "location"    # J

    .prologue
    .line 200
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->videoAdsList:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    .line 201
    .local v0, "ad":Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;
    invoke-virtual {v0, p1, p2}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->coversLocation(J)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 205
    .end local v0    # "ad":Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;
    :goto_0
    return-object v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getDuration()J
    .locals 2

    .prologue
    .line 78
    iget-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->duration:J

    return-wide v0
.end method

.method public getEndTime()J
    .locals 6

    .prologue
    const-wide/16 v0, -0x1

    .line 174
    iget-wide v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->startTime:J

    cmp-long v2, v2, v0

    if-eqz v2, :cond_0

    iget-wide v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->duration:J

    const-wide/16 v4, 0x0

    cmp-long v2, v2, v4

    if-lez v2, :cond_0

    .line 175
    iget-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->startTime:J

    iget-wide v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->duration:J

    add-long/2addr v0, v2

    .line 178
    :cond_0
    return-wide v0
.end method

.method public getId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->id:Ljava/lang/String;

    return-object v0
.end method

.method public getMarkerPosition()J
    .locals 2

    .prologue
    .line 30
    iget-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->markerPosition:J

    return-wide v0
.end method

.method public getPercentComplete()I
    .locals 1

    .prologue
    .line 223
    iget v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->percentComplete:I

    return v0
.end method

.method public getRestrictions()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction;",
            ">;"
        }
    .end annotation

    .prologue
    .line 245
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->restrictions:Ljava/util/List;

    return-object v0
.end method

.method public getSecondsRemaining()J
    .locals 2

    .prologue
    .line 257
    iget-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->secondsRemaining:J

    return-wide v0
.end method

.method public getStartTime()J
    .locals 2

    .prologue
    .line 96
    iget-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->startTime:J

    return-wide v0
.end method

.method public getVideoAdsList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;",
            ">;"
        }
    .end annotation

    .prologue
    .line 116
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->videoAdsList:Ljava/util/List;

    return-object v0
.end method

.method public hasBeenSeen()Z
    .locals 1

    .prologue
    .line 158
    iget-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->hasBeenSeen:Z

    return v0
.end method

.method public isPauseDisabled()Z
    .locals 1

    .prologue
    .line 253
    iget-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->isPauseDisabled:Z

    return v0
.end method

.method public isSeekDisabled()Z
    .locals 1

    .prologue
    .line 249
    iget-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->isSeekDisabled:Z

    return v0
.end method

.method public setDuration(J)V
    .locals 3
    .param p1, "duration"    # J

    .prologue
    .line 87
    iput-wide p1, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->secondsRemaining:J

    .line 88
    invoke-static {p1, p2}, Ljava/lang/Math;->abs(J)J

    move-result-wide v0

    iput-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->duration:J

    .line 89
    return-void
.end method

.method public setHasBeenSeen(Z)V
    .locals 0
    .param p1, "hasBeenSeen"    # Z

    .prologue
    .line 166
    iput-boolean p1, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->hasBeenSeen:Z

    .line 167
    return-void
.end method

.method public setId(Ljava/lang/String;)V
    .locals 0
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 70
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->id:Ljava/lang/String;

    .line 71
    return-void
.end method

.method public setMarkerPosition(J)V
    .locals 1
    .param p1, "localtime"    # J

    .prologue
    .line 34
    iput-wide p1, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->markerPosition:J

    .line 35
    return-void
.end method

.method public setStartTime(J)V
    .locals 1
    .param p1, "startTime"    # J

    .prologue
    .line 106
    iput-wide p1, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->startTime:J

    .line 107
    iput-wide p1, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->markerPosition:J

    .line 108
    return-void
.end method

.method public setVideoAdsList(Ljava/util/List;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p1, "videoAdsList":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;>;"
    const-wide/16 v0, 0x0

    .line 124
    iput-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->duration:J

    .line 125
    iput-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->secondsRemaining:J

    .line 126
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->startTime:J

    .line 127
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->videoAdsList:Ljava/util/List;

    .line 128
    if-eqz p1, :cond_0

    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 130
    const/4 v0, 0x0

    invoke-interface {p1, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->getStartTime()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->startTime:J

    .line 131
    iget-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->startTime:J

    iput-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->markerPosition:J

    .line 132
    invoke-direct {p0, p1}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->updateInternalValues(Ljava/util/List;)V

    .line 135
    :cond_0
    return-void
.end method

.method public updateProgress(J)V
    .locals 5
    .param p1, "currentPosition"    # J

    .prologue
    .line 213
    invoke-virtual {p0, p1, p2}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->coversLocation(J)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 214
    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->getEndTime()J

    move-result-wide v0

    sub-long/2addr v0, p1

    iput-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->secondsRemaining:J

    .line 215
    iget-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->secondsRemaining:J

    const-wide/16 v2, 0x64

    mul-long/2addr v0, v2

    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->getDuration()J

    move-result-wide v2

    div-long/2addr v0, v2

    long-to-int v0, v0

    rsub-int/lit8 v0, v0, 0x64

    iput v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->percentComplete:I

    .line 220
    :goto_0
    return-void

    .line 217
    :cond_0
    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->getDuration()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->secondsRemaining:J

    .line 218
    const/4 v0, 0x0

    iput v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->percentComplete:I

    goto :goto_0
.end method
