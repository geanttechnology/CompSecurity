.class public Lcom/comcast/cim/analytics/VideoPlaybackEventData;
.super Lcom/comcast/cim/analytics/XfinityEventData;
.source "VideoPlaybackEventData.java"


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 21
    const-string v0, "videoPlayback"

    invoke-direct {p0, v0}, Lcom/comcast/cim/analytics/XfinityEventData;-><init>(Ljava/lang/String;)V

    .line 22
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "appName"    # Ljava/lang/String;
    .param p2, "appVersion"    # Ljava/lang/String;
    .param p3, "omnitureTrackingKey"    # Ljava/lang/String;
    .param p4, "eventType"    # Ljava/lang/String;
    .param p5, "trackingEntityType"    # Ljava/lang/String;
    .param p6, "networkName"    # Ljava/lang/String;
    .param p7, "mediaId"    # Ljava/lang/String;
    .param p8, "trackingDuration"    # Ljava/lang/String;

    .prologue
    .line 32
    const-string v0, "videoPlayback"

    invoke-direct {p0, v0}, Lcom/comcast/cim/analytics/XfinityEventData;-><init>(Ljava/lang/String;)V

    .line 33
    const-string v0, "appName"

    invoke-virtual {p0, v0, p1}, Lcom/comcast/cim/analytics/VideoPlaybackEventData;->addData(Ljava/lang/String;Ljava/lang/String;)V

    .line 34
    const-string v0, "appVersion"

    invoke-virtual {p0, v0, p2}, Lcom/comcast/cim/analytics/VideoPlaybackEventData;->addData(Ljava/lang/String;Ljava/lang/String;)V

    .line 35
    const-string v0, "omnitureTrackingKey"

    invoke-virtual {p0, v0, p3}, Lcom/comcast/cim/analytics/VideoPlaybackEventData;->addData(Ljava/lang/String;Ljava/lang/String;)V

    .line 36
    const-string v0, "eventType"

    invoke-virtual {p0, v0, p4}, Lcom/comcast/cim/analytics/VideoPlaybackEventData;->addData(Ljava/lang/String;Ljava/lang/String;)V

    .line 37
    const-string v0, "trackingEntityType"

    invoke-virtual {p0, v0, p5}, Lcom/comcast/cim/analytics/VideoPlaybackEventData;->addData(Ljava/lang/String;Ljava/lang/String;)V

    .line 38
    const-string v0, "networkName"

    invoke-virtual {p0, v0, p6}, Lcom/comcast/cim/analytics/VideoPlaybackEventData;->addData(Ljava/lang/String;Ljava/lang/String;)V

    .line 39
    const-string v0, "mediaId"

    invoke-virtual {p0, v0, p7}, Lcom/comcast/cim/analytics/VideoPlaybackEventData;->addData(Ljava/lang/String;Ljava/lang/String;)V

    .line 40
    const-string v0, "trackingDuration"

    invoke-virtual {p0, v0, p8}, Lcom/comcast/cim/analytics/VideoPlaybackEventData;->addData(Ljava/lang/String;Ljava/lang/String;)V

    .line 41
    return-void
.end method
