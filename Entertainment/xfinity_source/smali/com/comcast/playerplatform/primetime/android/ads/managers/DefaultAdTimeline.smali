.class public Lcom/comcast/playerplatform/primetime/android/ads/managers/DefaultAdTimeline;
.super Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;
.source "DefaultAdTimeline.java"

# interfaces
.implements Lcom/adobe/mediacore/MediaPlayer$AdPlaybackEventListener;


# direct methods
.method public constructor <init>(Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;)V
    .locals 0
    .param p1, "adManager"    # Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    .prologue
    .line 22
    invoke-direct {p0, p1}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;-><init>(Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;)V

    .line 23
    return-void
.end method


# virtual methods
.method public onAdBreakComplete(Lcom/adobe/mediacore/timeline/advertising/AdBreak;)V
    .locals 6
    .param p1, "adBreak"    # Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    .prologue
    .line 137
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/DefaultAdTimeline;->adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/DefaultAdTimeline;->currentAdBreak:Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    invoke-virtual {v2, v3}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->triggerAdBreakComplete(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;)V

    .line 139
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/DefaultAdTimeline;->adBreaks:Ljava/util/List;

    if-eqz v2, :cond_1

    .line 140
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/DefaultAdTimeline;->adBreaks:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    .line 141
    .local v0, "adBreak1":Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->getTime()J

    move-result-wide v2

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->getStartTime()J

    move-result-wide v4

    cmp-long v2, v2, v4

    if-nez v2, :cond_0

    .line 142
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/DefaultAdTimeline;->adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    invoke-virtual {v2, v0}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->markAsSeen(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;)V

    .line 148
    .end local v0    # "adBreak1":Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
    .end local v1    # "i$":Ljava/util/Iterator;
    :cond_1
    const/4 v2, 0x0

    iput-object v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/DefaultAdTimeline;->currentAdBreak:Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    .line 149
    return-void
.end method

.method public onAdBreakSkipped(Lcom/adobe/mediacore/timeline/advertising/AdBreak;)V
    .locals 0
    .param p1, "adBreak"    # Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    .prologue
    .line 154
    return-void
.end method

.method public onAdBreakStart(Lcom/adobe/mediacore/timeline/advertising/AdBreak;)V
    .locals 24
    .param p1, "adBreak"    # Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    .prologue
    .line 27
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/playerplatform/primetime/android/ads/managers/DefaultAdTimeline;->adBreaks:Ljava/util/List;

    move-object/from16 v20, v0

    if-eqz v20, :cond_1

    .line 28
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/playerplatform/primetime/android/ads/managers/DefaultAdTimeline;->adBreaks:Ljava/util/List;

    move-object/from16 v20, v0

    invoke-interface/range {v20 .. v20}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v9

    .local v9, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v20

    if-eqz v20, :cond_1

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    .line 29
    .local v6, "adBreak1":Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
    invoke-virtual/range {p1 .. p1}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->getTime()J

    move-result-wide v20

    invoke-virtual {v6}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->getStartTime()J

    move-result-wide v22

    cmp-long v20, v20, v22

    if-nez v20, :cond_0

    .line 30
    move-object/from16 v0, p0

    iput-object v6, v0, Lcom/comcast/playerplatform/primetime/android/ads/managers/DefaultAdTimeline;->currentAdBreak:Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    .line 35
    .end local v6    # "adBreak1":Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
    .end local v9    # "i$":Ljava/util/Iterator;
    :cond_1
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/playerplatform/primetime/android/ads/managers/DefaultAdTimeline;->currentAdBreak:Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    move-object/from16 v20, v0

    if-nez v20, :cond_6

    .line 36
    invoke-virtual/range {p1 .. p1}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->adsIterator()Ljava/util/Iterator;

    move-result-object v8

    .line 37
    .local v8, "ads":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/adobe/mediacore/timeline/advertising/Ad;>;"
    new-instance v19, Ljava/util/ArrayList;

    invoke-direct/range {v19 .. v19}, Ljava/util/ArrayList;-><init>()V

    .line 38
    .local v19, "videoAds":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;>;"
    invoke-virtual/range {p1 .. p1}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->getTime()J

    move-result-wide v14

    .line 39
    .local v14, "nextAdStart":J
    :goto_0
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v20

    if-eqz v20, :cond_4

    .line 40
    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Lcom/adobe/mediacore/timeline/advertising/Ad;

    .line 41
    .local v12, "nextAd":Lcom/adobe/mediacore/timeline/advertising/Ad;
    new-instance v18, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    invoke-direct/range {v18 .. v18}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;-><init>()V

    .line 42
    .local v18, "videoAd":Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;
    move-object/from16 v0, v18

    invoke-virtual {v0, v14, v15}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->setStartTime(J)V

    .line 43
    invoke-virtual {v12}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getId()I

    move-result v20

    invoke-static/range {v20 .. v20}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v18

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->setId(Ljava/lang/String;)V

    .line 44
    invoke-virtual {v12}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getDuration()J

    move-result-wide v20

    move-object/from16 v0, v18

    move-wide/from16 v1, v20

    invoke-virtual {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->setDuration(J)V

    .line 45
    invoke-virtual {v12}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getDuration()J

    move-result-wide v20

    add-long v14, v14, v20

    .line 46
    invoke-virtual {v12}, Lcom/adobe/mediacore/timeline/advertising/Ad;->isClickable()Z

    move-result v20

    if-eqz v20, :cond_2

    .line 47
    const/16 v20, 0x1

    move-object/from16 v0, v18

    move/from16 v1, v20

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->setIsClickable(Z)V

    .line 48
    invoke-virtual {v12}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getPrimaryAsset()Lcom/adobe/mediacore/timeline/advertising/AdAsset;

    move-result-object v20

    invoke-virtual/range {v20 .. v20}, Lcom/adobe/mediacore/timeline/advertising/AdAsset;->getAdClick()Lcom/adobe/mediacore/timeline/advertising/AdClick;

    move-result-object v7

    .line 49
    .local v7, "adClick":Lcom/adobe/mediacore/timeline/advertising/AdClick;
    invoke-virtual {v7}, Lcom/adobe/mediacore/timeline/advertising/AdClick;->getTitle()Ljava/lang/String;

    move-result-object v20

    if-eqz v20, :cond_3

    invoke-virtual {v7}, Lcom/adobe/mediacore/timeline/advertising/AdClick;->getTitle()Ljava/lang/String;

    move-result-object v17

    .line 50
    .local v17, "title":Ljava/lang/String;
    :goto_1
    invoke-virtual {v7}, Lcom/adobe/mediacore/timeline/advertising/AdClick;->getUrl()Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v18

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->setClickUrl(Ljava/lang/String;)V

    .line 51
    move-object/from16 v0, v18

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->setClickTitle(Ljava/lang/String;)V

    .line 54
    .end local v7    # "adClick":Lcom/adobe/mediacore/timeline/advertising/AdClick;
    .end local v17    # "title":Ljava/lang/String;
    :cond_2
    move-object/from16 v0, v19

    move-object/from16 v1, v18

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 49
    .restart local v7    # "adClick":Lcom/adobe/mediacore/timeline/advertising/AdClick;
    :cond_3
    const-string v17, ""

    goto :goto_1

    .line 57
    .end local v7    # "adClick":Lcom/adobe/mediacore/timeline/advertising/AdClick;
    .end local v12    # "nextAd":Lcom/adobe/mediacore/timeline/advertising/Ad;
    .end local v18    # "videoAd":Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;
    :cond_4
    new-instance v20, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    invoke-direct/range {v20 .. v20}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;-><init>()V

    move-object/from16 v0, v20

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/comcast/playerplatform/primetime/android/ads/managers/DefaultAdTimeline;->currentAdBreak:Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    .line 58
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/playerplatform/primetime/android/ads/managers/DefaultAdTimeline;->currentAdBreak:Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    move-object/from16 v20, v0

    invoke-virtual/range {p1 .. p1}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->getTag()Ljava/lang/String;

    move-result-object v21

    invoke-virtual/range {v20 .. v21}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->setId(Ljava/lang/String;)V

    .line 59
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/playerplatform/primetime/android/ads/managers/DefaultAdTimeline;->currentAdBreak:Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    move-object/from16 v20, v0

    move-object/from16 v0, v20

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->setVideoAdsList(Ljava/util/List;)V

    .line 62
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/playerplatform/primetime/android/ads/managers/DefaultAdTimeline;->currentAdBreak:Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    move-object/from16 v20, v0

    if-eqz v20, :cond_6

    .line 63
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/playerplatform/primetime/android/ads/managers/DefaultAdTimeline;->currentAdBreak:Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    move-object/from16 v20, v0

    invoke-virtual/range {p1 .. p1}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->isWatched()Ljava/lang/Boolean;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v21

    invoke-virtual/range {v20 .. v21}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->setHasBeenSeen(Z)V

    .line 65
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/playerplatform/primetime/android/ads/managers/DefaultAdTimeline;->adRestrictions:Ljava/util/ArrayList;

    move-object/from16 v20, v0

    if-eqz v20, :cond_6

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/playerplatform/primetime/android/ads/managers/DefaultAdTimeline;->adRestrictions:Ljava/util/ArrayList;

    move-object/from16 v20, v0

    invoke-virtual/range {v20 .. v20}, Ljava/util/ArrayList;->size()I

    move-result v20

    if-lez v20, :cond_6

    .line 66
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/playerplatform/primetime/android/ads/managers/DefaultAdTimeline;->adRestrictions:Ljava/util/ArrayList;

    move-object/from16 v20, v0

    invoke-virtual/range {v20 .. v20}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v9

    .restart local v9    # "i$":Ljava/util/Iterator;
    :cond_5
    :goto_2
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v20

    if-eqz v20, :cond_6

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v16

    check-cast v16, Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction;

    .line 67
    .local v16, "restriction":Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/playerplatform/primetime/android/ads/managers/DefaultAdTimeline;->currentAdBreak:Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    move-object/from16 v20, v0

    invoke-virtual/range {v20 .. v20}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->getId()Ljava/lang/String;

    move-result-object v20

    invoke-virtual/range {v16 .. v16}, Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction;->getId()Ljava/lang/String;

    move-result-object v21

    invoke-virtual/range {v20 .. v21}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v20

    if-eqz v20, :cond_5

    .line 68
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/playerplatform/primetime/android/ads/managers/DefaultAdTimeline;->currentAdBreak:Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    move-object/from16 v20, v0

    move-object/from16 v0, v20

    move-object/from16 v1, v16

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->addRestriction(Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction;)V

    goto :goto_2

    .line 75
    .end local v8    # "ads":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/adobe/mediacore/timeline/advertising/Ad;>;"
    .end local v9    # "i$":Ljava/util/Iterator;
    .end local v14    # "nextAdStart":J
    .end local v16    # "restriction":Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction;
    .end local v19    # "videoAds":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;>;"
    :cond_6
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/playerplatform/primetime/android/ads/managers/DefaultAdTimeline;->adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    move-object/from16 v20, v0

    const/16 v21, 0x0

    invoke-virtual/range {v20 .. v21}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->getPlayerTimeline(Lcom/adobe/mediacore/timeline/Timeline;)Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;

    move-result-object v13

    .line 76
    .local v13, "playerTimeline":Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;
    if-eqz v13, :cond_9

    .line 77
    invoke-virtual {v13}, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;->timelineMarkers()Ljava/util/Iterator;

    move-result-object v11

    .line 78
    .local v11, "markers":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/comcast/playerplatform/primetime/android/primetime/TimelineMarker;>;"
    const-wide/16 v4, -0x1

    .line 79
    .local v4, "actualStartPosition":J
    :cond_7
    :goto_3
    invoke-interface {v11}, Ljava/util/Iterator;->hasNext()Z

    move-result v20

    if-eqz v20, :cond_8

    .line 80
    invoke-interface {v11}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Lcom/comcast/playerplatform/primetime/android/primetime/TimelineMarker;

    .line 81
    .local v10, "marker":Lcom/comcast/playerplatform/primetime/android/primetime/TimelineMarker;
    invoke-virtual {v10}, Lcom/comcast/playerplatform/primetime/android/primetime/TimelineMarker;->getTime()J

    move-result-wide v20

    cmp-long v20, v20, v4

    if-lez v20, :cond_7

    invoke-virtual {v10}, Lcom/comcast/playerplatform/primetime/android/primetime/TimelineMarker;->getTime()J

    move-result-wide v20

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/playerplatform/primetime/android/ads/managers/DefaultAdTimeline;->currentAdBreak:Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    move-object/from16 v22, v0

    invoke-virtual/range {v22 .. v22}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->getStartTime()J

    move-result-wide v22

    cmp-long v20, v20, v22

    if-gtz v20, :cond_7

    .line 82
    invoke-virtual {v10}, Lcom/comcast/playerplatform/primetime/android/primetime/TimelineMarker;->getTime()J

    move-result-wide v4

    goto :goto_3

    .line 86
    .end local v10    # "marker":Lcom/comcast/playerplatform/primetime/android/primetime/TimelineMarker;
    :cond_8
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/playerplatform/primetime/android/ads/managers/DefaultAdTimeline;->currentAdBreak:Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    move-object/from16 v20, v0

    move-object/from16 v0, v20

    invoke-virtual {v0, v4, v5}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->setMarkerPosition(J)V

    .line 89
    .end local v4    # "actualStartPosition":J
    .end local v11    # "markers":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/comcast/playerplatform/primetime/android/primetime/TimelineMarker;>;"
    :cond_9
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/playerplatform/primetime/android/ads/managers/DefaultAdTimeline;->adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    move-object/from16 v20, v0

    if-eqz v20, :cond_a

    .line 90
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/playerplatform/primetime/android/ads/managers/DefaultAdTimeline;->adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    move-object/from16 v21, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/playerplatform/primetime/android/ads/managers/DefaultAdTimeline;->currentAdBreak:Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    move-object/from16 v22, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/playerplatform/primetime/android/ads/managers/DefaultAdTimeline;->currentAdBreak:Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    move-object/from16 v20, v0

    invoke-virtual/range {v20 .. v20}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->getVideoAdsList()Ljava/util/List;

    move-result-object v20

    const/16 v23, 0x0

    move-object/from16 v0, v20

    move/from16 v1, v23

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v20

    check-cast v20, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    move-object/from16 v0, v21

    move-object/from16 v1, v22

    move-object/from16 v2, v20

    invoke-virtual {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->triggerAdBreakStart(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;)V

    .line 92
    :cond_a
    return-void
.end method

.method public onAdComplete(Lcom/adobe/mediacore/timeline/advertising/AdBreak;Lcom/adobe/mediacore/timeline/advertising/Ad;)V
    .locals 3
    .param p1, "adBreak"    # Lcom/adobe/mediacore/timeline/advertising/AdBreak;
    .param p2, "ad"    # Lcom/adobe/mediacore/timeline/advertising/Ad;

    .prologue
    .line 131
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/DefaultAdTimeline;->adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/DefaultAdTimeline;->currentAdBreak:Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/DefaultAdTimeline;->currentAd:Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    invoke-virtual {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->triggerAdComplete(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;)V

    .line 132
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/DefaultAdTimeline;->currentAd:Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    .line 133
    return-void
.end method

.method public onAdProgress(Lcom/adobe/mediacore/timeline/advertising/AdBreak;Lcom/adobe/mediacore/timeline/advertising/Ad;I)V
    .locals 0
    .param p1, "adBreak"    # Lcom/adobe/mediacore/timeline/advertising/AdBreak;
    .param p2, "ad"    # Lcom/adobe/mediacore/timeline/advertising/Ad;
    .param p3, "i"    # I

    .prologue
    .line 127
    return-void
.end method

.method public onAdStart(Lcom/adobe/mediacore/timeline/advertising/AdBreak;Lcom/adobe/mediacore/timeline/advertising/Ad;)V
    .locals 6
    .param p1, "adBreak"    # Lcom/adobe/mediacore/timeline/advertising/AdBreak;
    .param p2, "ad"    # Lcom/adobe/mediacore/timeline/advertising/Ad;

    .prologue
    .line 96
    new-instance v2, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    invoke-direct {v2}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;-><init>()V

    iput-object v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/DefaultAdTimeline;->currentAd:Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    .line 97
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/DefaultAdTimeline;->currentAd:Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    invoke-virtual {p2}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getId()I

    move-result v3

    invoke-static {v3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->setId(Ljava/lang/String;)V

    .line 98
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/DefaultAdTimeline;->currentAd:Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    invoke-virtual {p2}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getDuration()J

    move-result-wide v4

    invoke-virtual {v2, v4, v5}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->setDuration(J)V

    .line 99
    invoke-virtual {p2}, Lcom/adobe/mediacore/timeline/advertising/Ad;->isClickable()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 100
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/DefaultAdTimeline;->currentAd:Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->setIsClickable(Z)V

    .line 101
    invoke-virtual {p2}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getPrimaryAsset()Lcom/adobe/mediacore/timeline/advertising/AdAsset;

    move-result-object v2

    invoke-virtual {v2}, Lcom/adobe/mediacore/timeline/advertising/AdAsset;->getAdClick()Lcom/adobe/mediacore/timeline/advertising/AdClick;

    move-result-object v0

    .line 102
    .local v0, "adClick":Lcom/adobe/mediacore/timeline/advertising/AdClick;
    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdClick;->getTitle()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_2

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdClick;->getTitle()Ljava/lang/String;

    move-result-object v1

    .line 103
    .local v1, "title":Ljava/lang/String;
    :goto_0
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/DefaultAdTimeline;->currentAd:Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdClick;->getUrl()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->setClickUrl(Ljava/lang/String;)V

    .line 104
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/DefaultAdTimeline;->currentAd:Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    invoke-virtual {v2, v1}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->setClickTitle(Ljava/lang/String;)V

    .line 108
    .end local v0    # "adClick":Lcom/adobe/mediacore/timeline/advertising/AdClick;
    .end local v1    # "title":Ljava/lang/String;
    :cond_0
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/DefaultAdTimeline;->adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    if-eqz v2, :cond_1

    .line 109
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/DefaultAdTimeline;->adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/DefaultAdTimeline;->currentAdBreak:Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    iget-object v4, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/DefaultAdTimeline;->currentAd:Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    invoke-virtual {v2, v3, v4}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->triggerAdStart(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;)V

    .line 111
    :cond_1
    return-void

    .line 102
    .restart local v0    # "adClick":Lcom/adobe/mediacore/timeline/advertising/AdClick;
    :cond_2
    const-string v1, ""

    goto :goto_0
.end method

.method public setResumePosition(J)V
    .locals 9
    .param p1, "position"    # J

    .prologue
    .line 158
    const/4 v1, 0x0

    .line 159
    .local v1, "closestAd":Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/DefaultAdTimeline;->adBreaks:Ljava/util/List;

    if-eqz v3, :cond_2

    .line 160
    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/DefaultAdTimeline;->adBreaks:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_2

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    .line 161
    .local v0, "adBreak":Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->getStartTime()J

    move-result-wide v4

    cmp-long v3, p1, v4

    if-ltz v3, :cond_0

    if-eqz v1, :cond_1

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->getStartTime()J

    move-result-wide v4

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->getStartTime()J

    move-result-wide v6

    cmp-long v3, v4, v6

    if-ltz v3, :cond_0

    .line 162
    :cond_1
    move-object v1, v0

    goto :goto_0

    .line 166
    .end local v0    # "adBreak":Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
    .end local v2    # "i$":Ljava/util/Iterator;
    :cond_2
    if-eqz v1, :cond_3

    .line 167
    const/4 v3, 0x1

    invoke-virtual {v1, v3}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->setHasBeenSeen(Z)V

    .line 170
    :cond_3
    invoke-virtual {p0, p1, p2}, Lcom/comcast/playerplatform/primetime/android/ads/managers/DefaultAdTimeline;->updateProgress(J)V

    .line 171
    return-void
.end method

.method public updateProgress(J)V
    .locals 7
    .param p1, "position"    # J

    .prologue
    .line 115
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/DefaultAdTimeline;->currentAdBreak:Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    if-eqz v0, :cond_0

    .line 116
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/DefaultAdTimeline;->currentAdBreak:Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    invoke-virtual {v0, p1, p2}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->updateProgress(J)V

    .line 118
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/DefaultAdTimeline;->adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    if-eqz v0, :cond_0

    .line 119
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/DefaultAdTimeline;->adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/DefaultAdTimeline;->currentAdBreak:Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/DefaultAdTimeline;->currentAd:Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/DefaultAdTimeline;->currentAdBreak:Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    invoke-virtual {v3}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->getPercentComplete()I

    move-result v3

    iget-object v4, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/DefaultAdTimeline;->currentAdBreak:Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    invoke-virtual {v4}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->getSecondsRemaining()J

    move-result-wide v4

    invoke-virtual/range {v0 .. v5}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->triggerAdProgress(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;IJ)V

    .line 122
    :cond_0
    return-void
.end method
