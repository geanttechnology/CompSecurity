.class public Lcom/comcast/playerplatform/primetime/android/primetime/TimelineMarker;
.super Ljava/lang/Object;
.source "TimelineMarker.java"


# instance fields
.field protected duration:J

.field protected time:J


# direct methods
.method public constructor <init>(JJ)V
    .locals 1
    .param p1, "time"    # J
    .param p3, "duration"    # J

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 11
    iput-wide p3, p0, Lcom/comcast/playerplatform/primetime/android/primetime/TimelineMarker;->duration:J

    .line 12
    iput-wide p1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/TimelineMarker;->time:J

    .line 13
    return-void
.end method


# virtual methods
.method public getDuration()J
    .locals 2

    .prologue
    .line 24
    iget-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/TimelineMarker;->duration:J

    return-wide v0
.end method

.method public getTime()J
    .locals 2

    .prologue
    .line 16
    iget-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/TimelineMarker;->time:J

    return-wide v0
.end method

.method public setDuration(J)V
    .locals 1
    .param p1, "duration"    # J

    .prologue
    .line 28
    iput-wide p1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/TimelineMarker;->duration:J

    .line 29
    return-void
.end method

.method public setTime(J)V
    .locals 1
    .param p1, "time"    # J

    .prologue
    .line 20
    iput-wide p1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/TimelineMarker;->time:J

    .line 21
    return-void
.end method
