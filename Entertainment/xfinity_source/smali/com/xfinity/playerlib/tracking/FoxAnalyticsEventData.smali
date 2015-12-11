.class public Lcom/xfinity/playerlib/tracking/FoxAnalyticsEventData;
.super Lcom/comcast/cim/cmasl/analytics/EventData;
.source "FoxAnalyticsEventData.java"


# direct methods
.method public constructor <init>(Ljava/lang/String;Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)V
    .locals 6
    .param p1, "event"    # Ljava/lang/String;
    .param p2, "videoFacade"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .param p3, "bookmark"    # Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    .prologue
    .line 8
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/analytics/EventData;-><init>()V

    .line 10
    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getDurationInSeconds()I

    move-result v3

    const/16 v4, 0x3c

    if-le v3, v4, :cond_0

    .line 11
    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getDurationInSeconds()I

    move-result v3

    div-int/lit8 v0, v3, 0x3c

    .line 12
    .local v0, "durationMinutes":I
    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getDurationInSeconds()I

    move-result v3

    rem-int/lit8 v1, v3, 0x3c

    .line 13
    .local v1, "durationSeconds":I
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {v0}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ":"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 18
    .end local v0    # "durationMinutes":I
    .end local v1    # "durationSeconds":I
    .local v2, "durationString":Ljava/lang/String;
    :goto_0
    const-string v3, "c_event"

    invoke-virtual {p0, v3, p1}, Lcom/xfinity/playerlib/tracking/FoxAnalyticsEventData;->addData(Ljava/lang/String;Ljava/lang/String;)V

    .line 19
    const-string v3, "c_format"

    const-string v4, "longform"

    invoke-virtual {p0, v3, v4}, Lcom/xfinity/playerlib/tracking/FoxAnalyticsEventData;->addData(Ljava/lang/String;Ljava/lang/String;)V

    .line 20
    const-string v3, "c_rating"

    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getVideoRating()Lcom/comcast/cim/model/Rating;

    move-result-object v4

    invoke-virtual {v4}, Lcom/comcast/cim/model/Rating;->getRating()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0, v3, v4}, Lcom/xfinity/playerlib/tracking/FoxAnalyticsEventData;->addData(Ljava/lang/String;Ljava/lang/String;)V

    .line 21
    const-string v3, "c_network_name"

    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getNetworkInfo()Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    move-result-object v4

    invoke-virtual {v4}, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0, v3, v4}, Lcom/xfinity/playerlib/tracking/FoxAnalyticsEventData;->addData(Ljava/lang/String;Ljava/lang/String;)V

    .line 22
    const-string v3, "c_playerId"

    const-string v4, "xtv app_android"

    invoke-virtual {p0, v3, v4}, Lcom/xfinity/playerlib/tracking/FoxAnalyticsEventData;->addData(Ljava/lang/String;Ljava/lang/String;)V

    .line 23
    const-string v3, "c_contentId"

    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getVideoId()J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0, v3, v4}, Lcom/xfinity/playerlib/tracking/FoxAnalyticsEventData;->addData(Ljava/lang/String;Ljava/lang/String;)V

    .line 24
    const-string v3, "c_title"

    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getTitle()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0, v3, v4}, Lcom/xfinity/playerlib/tracking/FoxAnalyticsEventData;->addData(Ljava/lang/String;Ljava/lang/String;)V

    .line 25
    const-string v3, "c_duration"

    invoke-virtual {p0, v3, v2}, Lcom/xfinity/playerlib/tracking/FoxAnalyticsEventData;->addData(Ljava/lang/String;Ljava/lang/String;)V

    .line 27
    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->isMovie()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 28
    const-string v3, "c_content_type"

    const-string v4, "movie clip"

    invoke-virtual {p0, v3, v4}, Lcom/xfinity/playerlib/tracking/FoxAnalyticsEventData;->addData(Ljava/lang/String;Ljava/lang/String;)V

    .line 29
    const-string v3, "c_show"

    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getTitle()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0, v3, v4}, Lcom/xfinity/playerlib/tracking/FoxAnalyticsEventData;->addData(Ljava/lang/String;Ljava/lang/String;)V

    .line 37
    :goto_1
    const-string v3, "c_MVPD"

    const-string v4, "comcast"

    invoke-virtual {p0, v3, v4}, Lcom/xfinity/playerlib/tracking/FoxAnalyticsEventData;->addData(Ljava/lang/String;Ljava/lang/String;)V

    .line 38
    const-string v3, "c_screensize"

    const-string v4, "standard"

    invoke-virtual {p0, v3, v4}, Lcom/xfinity/playerlib/tracking/FoxAnalyticsEventData;->addData(Ljava/lang/String;Ljava/lang/String;)V

    .line 39
    return-void

    .line 15
    .end local v2    # "durationString":Ljava/lang/String;
    :cond_0
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "0:"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getDurationInSeconds()I

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .restart local v2    # "durationString":Ljava/lang/String;
    goto/16 :goto_0

    .line 31
    :cond_1
    const-string v3, "c_content_type"

    const-string v4, "full episode"

    invoke-virtual {p0, v3, v4}, Lcom/xfinity/playerlib/tracking/FoxAnalyticsEventData;->addData(Ljava/lang/String;Ljava/lang/String;)V

    .line 32
    const-string v3, "c_show"

    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getTitle()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0, v3, v4}, Lcom/xfinity/playerlib/tracking/FoxAnalyticsEventData;->addData(Ljava/lang/String;Ljava/lang/String;)V

    .line 33
    const-string v3, "c_season"

    invoke-virtual {p3}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getSeasonNumber()I

    move-result v4

    invoke-static {v4}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0, v3, v4}, Lcom/xfinity/playerlib/tracking/FoxAnalyticsEventData;->addData(Ljava/lang/String;Ljava/lang/String;)V

    .line 34
    const-string v3, "c_episode"

    invoke-virtual {p3}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getEpisodeNumber()I

    move-result v4

    invoke-static {v4}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0, v3, v4}, Lcom/xfinity/playerlib/tracking/FoxAnalyticsEventData;->addData(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1
.end method
