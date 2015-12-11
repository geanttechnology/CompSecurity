.class public Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;
.super Ljava/lang/Object;
.source "VideoAd.java"


# instance fields
.field private adProgressPercent:I

.field private clickTitle:Ljava/lang/String;

.field private clickableUrl:Ljava/lang/String;

.field private duration:J

.field private id:Ljava/lang/String;

.field private isClickable:Z

.field private secondsRemaining:J

.field private startTime:J


# direct methods
.method public constructor <init>()V
    .locals 4

    .prologue
    const-wide/16 v2, -0x1

    const/4 v0, 0x0

    .line 23
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 12
    iput-wide v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->startTime:J

    .line 13
    iput-wide v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->duration:J

    .line 14
    iput-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->isClickable:Z

    .line 17
    iput v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->adProgressPercent:I

    .line 18
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->secondsRemaining:J

    .line 24
    return-void
.end method


# virtual methods
.method public coversLocation(J)Z
    .locals 7
    .param p1, "location"    # J

    .prologue
    const-wide/16 v4, -0x1

    const/4 v0, 0x0

    .line 94
    iget-wide v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->startTime:J

    cmp-long v1, v2, v4

    if-eqz v1, :cond_0

    iget-wide v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->duration:J

    cmp-long v1, v2, v4

    if-eqz v1, :cond_0

    .line 95
    iget-wide v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->startTime:J

    cmp-long v1, v2, p1

    if-gtz v1, :cond_0

    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->getEndTime()J

    move-result-wide v2

    cmp-long v1, p1, v2

    if-gtz v1, :cond_0

    const/4 v0, 0x1

    .line 97
    :cond_0
    return v0
.end method

.method public getAdProgressPercent()I
    .locals 1

    .prologue
    .line 136
    iget v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->adProgressPercent:I

    return v0
.end method

.method public getClickTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 121
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->clickTitle:Ljava/lang/String;

    return-object v0
.end method

.method public getClickUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 113
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->clickableUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getDuration()J
    .locals 2

    .prologue
    .line 63
    iget-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->duration:J

    return-wide v0
.end method

.method public getEndTime()J
    .locals 4

    .prologue
    const-wide/16 v0, -0x1

    .line 80
    iget-wide v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->startTime:J

    cmp-long v2, v2, v0

    if-eqz v2, :cond_0

    iget-wide v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->duration:J

    cmp-long v2, v2, v0

    if-eqz v2, :cond_0

    .line 81
    iget-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->startTime:J

    iget-wide v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->duration:J

    add-long/2addr v0, v2

    .line 84
    :cond_0
    return-wide v0
.end method

.method public getId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->id:Ljava/lang/String;

    return-object v0
.end method

.method public getSecondsRemaining()J
    .locals 2

    .prologue
    .line 140
    iget-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->secondsRemaining:J

    return-wide v0
.end method

.method public getStartTime()J
    .locals 2

    .prologue
    .line 47
    iget-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->startTime:J

    return-wide v0
.end method

.method public isClickable()Z
    .locals 1

    .prologue
    .line 105
    iget-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->isClickable:Z

    return v0
.end method

.method public setClickTitle(Ljava/lang/String;)V
    .locals 0
    .param p1, "clickTitle"    # Ljava/lang/String;

    .prologue
    .line 117
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->clickTitle:Ljava/lang/String;

    .line 118
    return-void
.end method

.method public setClickUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "clickableUrl"    # Ljava/lang/String;

    .prologue
    .line 109
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->clickableUrl:Ljava/lang/String;

    .line 110
    return-void
.end method

.method public setDuration(J)V
    .locals 3
    .param p1, "duration"    # J

    .prologue
    .line 71
    invoke-static {p1, p2}, Ljava/lang/Math;->abs(J)J

    move-result-wide v0

    iput-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->duration:J

    .line 72
    iput-wide p1, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->secondsRemaining:J

    .line 73
    return-void
.end method

.method public setId(Ljava/lang/String;)V
    .locals 0
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 39
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->id:Ljava/lang/String;

    .line 40
    return-void
.end method

.method public setIsClickable(Z)V
    .locals 0
    .param p1, "isClickable"    # Z

    .prologue
    .line 101
    iput-boolean p1, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->isClickable:Z

    .line 102
    return-void
.end method

.method public setStartTime(J)V
    .locals 1
    .param p1, "startTime"    # J

    .prologue
    .line 55
    iput-wide p1, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->startTime:J

    .line 56
    return-void
.end method

.method public updateProgress(J)V
    .locals 5
    .param p1, "currentPosition"    # J

    .prologue
    .line 126
    invoke-virtual {p0, p1, p2}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->coversLocation(J)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 127
    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->getEndTime()J

    move-result-wide v0

    sub-long/2addr v0, p1

    iput-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->secondsRemaining:J

    .line 128
    iget-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->secondsRemaining:J

    const-wide/16 v2, 0x64

    mul-long/2addr v0, v2

    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->getDuration()J

    move-result-wide v2

    div-long/2addr v0, v2

    long-to-int v0, v0

    rsub-int/lit8 v0, v0, 0x64

    iput v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->adProgressPercent:I

    .line 133
    :goto_0
    return-void

    .line 130
    :cond_0
    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->getDuration()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->secondsRemaining:J

    .line 131
    const/4 v0, 0x0

    iput v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->adProgressPercent:I

    goto :goto_0
.end method
