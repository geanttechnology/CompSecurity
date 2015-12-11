.class public Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;
.super Ljava/lang/Object;
.source "PlayerTimeline.java"

# interfaces
.implements Lcom/adobe/mediacore/timeline/Timeline;


# instance fields
.field markers:Ljava/util/Vector;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Vector",
            "<",
            "Lcom/comcast/playerplatform/primetime/android/primetime/TimelineMarker;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/util/Iterator;)V
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Iterator",
            "<",
            "Lcom/adobe/mediacore/timeline/TimelineMarker;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 20
    .local p1, "markerIterator":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/adobe/mediacore/timeline/TimelineMarker;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 18
    new-instance v1, Ljava/util/Vector;

    invoke-direct {v1}, Ljava/util/Vector;-><init>()V

    iput-object v1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;->markers:Ljava/util/Vector;

    .line 21
    if-eqz p1, :cond_0

    .line 22
    :goto_0
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 23
    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/TimelineMarker;

    .line 24
    .local v0, "marker":Lcom/adobe/mediacore/timeline/TimelineMarker;
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;->markers:Ljava/util/Vector;

    new-instance v2, Lcom/comcast/playerplatform/primetime/android/primetime/TimelineMarker;

    invoke-interface {v0}, Lcom/adobe/mediacore/timeline/TimelineMarker;->getTime()J

    move-result-wide v4

    invoke-interface {v0}, Lcom/adobe/mediacore/timeline/TimelineMarker;->getDuration()J

    move-result-wide v6

    invoke-direct {v2, v4, v5, v6, v7}, Lcom/comcast/playerplatform/primetime/android/primetime/TimelineMarker;-><init>(JJ)V

    invoke-virtual {v1, v2}, Ljava/util/Vector;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 27
    .end local v0    # "marker":Lcom/adobe/mediacore/timeline/TimelineMarker;
    :cond_0
    return-void
.end method

.method public constructor <init>(Ljava/util/List;)V
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 29
    .local p1, "adBreakList":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 18
    new-instance v2, Ljava/util/Vector;

    invoke-direct {v2}, Ljava/util/Vector;-><init>()V

    iput-object v2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;->markers:Ljava/util/Vector;

    .line 30
    if-eqz p1, :cond_0

    .line 31
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    .line 32
    .local v0, "adBreak":Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;->markers:Ljava/util/Vector;

    new-instance v3, Lcom/comcast/playerplatform/primetime/android/primetime/TimelineMarker;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->getStartTime()J

    move-result-wide v4

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->getDuration()J

    move-result-wide v6

    invoke-direct {v3, v4, v5, v6, v7}, Lcom/comcast/playerplatform/primetime/android/primetime/TimelineMarker;-><init>(JJ)V

    invoke-virtual {v2, v3}, Ljava/util/Vector;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 35
    .end local v0    # "adBreak":Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
    .end local v1    # "i$":Ljava/util/Iterator;
    :cond_0
    return-void
.end method


# virtual methods
.method public timelineMarkers()Ljava/util/Iterator;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Iterator",
            "<",
            "Lcom/comcast/playerplatform/primetime/android/primetime/TimelineMarker;",
            ">;"
        }
    .end annotation

    .prologue
    .line 39
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;->markers:Ljava/util/Vector;

    invoke-virtual {v0}, Ljava/util/Vector;->iterator()Ljava/util/Iterator;

    move-result-object v0

    return-object v0
.end method
