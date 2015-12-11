.class public Lcom/comcast/playerplatform/primetime/android/ads/CustomAdBreakPolicySelector;
.super Lcom/adobe/mediacore/DefaultAdPolicySelector;
.source "CustomAdBreakPolicySelector.java"


# instance fields
.field private adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

.field private useResumeLogic:Z


# direct methods
.method public constructor <init>(Lcom/adobe/mediacore/MediaPlayerItem;Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;Z)V
    .locals 0
    .param p1, "_mediaPlayerItem"    # Lcom/adobe/mediacore/MediaPlayerItem;
    .param p2, "adManager"    # Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;
    .param p3, "useResumeLogic"    # Z

    .prologue
    .line 17
    invoke-direct {p0, p1}, Lcom/adobe/mediacore/DefaultAdPolicySelector;-><init>(Lcom/adobe/mediacore/MediaPlayerItem;)V

    .line 18
    iput-object p2, p0, Lcom/comcast/playerplatform/primetime/android/ads/CustomAdBreakPolicySelector;->adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    .line 19
    iput-boolean p3, p0, Lcom/comcast/playerplatform/primetime/android/ads/CustomAdBreakPolicySelector;->useResumeLogic:Z

    .line 20
    return-void
.end method


# virtual methods
.method public selectAdBreaksToPlay(Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;)Ljava/util/List;
    .locals 12
    .param p1, "adPolicyInfo"    # Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;",
            ">;"
        }
    .end annotation

    .prologue
    .line 60
    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;->getAdBreakPlacements()Ljava/util/List;

    move-result-object v3

    .line 61
    .local v3, "adbreaks":Ljava/util/List;, "Ljava/util/List<Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;>;"
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 62
    .local v2, "adBreaksToPlay":Ljava/util/List;, "Ljava/util/List<Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;>;"
    const/4 v5, 0x0

    .line 63
    .local v5, "placement":Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;
    iget-object v7, p0, Lcom/comcast/playerplatform/primetime/android/ads/CustomAdBreakPolicySelector;->adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    if-eqz v7, :cond_4

    if-eqz v3, :cond_4

    .line 64
    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .local v4, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_2

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    .line 65
    .local v1, "adBreakPlacement":Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;
    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;->getSeekToTime()J

    move-result-wide v8

    invoke-virtual {v1}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getTime()J

    move-result-wide v10

    cmp-long v7, v8, v10

    if-ltz v7, :cond_0

    if-eqz v5, :cond_1

    invoke-virtual {v1}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getTime()J

    move-result-wide v8

    invoke-virtual {v5}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getTime()J

    move-result-wide v10

    cmp-long v7, v8, v10

    if-ltz v7, :cond_0

    .line 66
    :cond_1
    move-object v5, v1

    goto :goto_0

    .line 71
    .end local v1    # "adBreakPlacement":Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;
    :cond_2
    if-eqz v5, :cond_4

    invoke-virtual {v5}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v7

    if-eqz v7, :cond_4

    .line 72
    invoke-virtual {v5}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v0

    .line 73
    .local v0, "adBreak":Lcom/adobe/mediacore/timeline/advertising/AdBreak;
    iget-object v7, p0, Lcom/comcast/playerplatform/primetime/android/ads/CustomAdBreakPolicySelector;->adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    invoke-virtual {v7}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->getSkipAdsOnSeek()Z

    move-result v6

    .line 74
    .local v6, "skipAd":Z
    iget-boolean v7, p0, Lcom/comcast/playerplatform/primetime/android/ads/CustomAdBreakPolicySelector;->useResumeLogic:Z

    if-nez v7, :cond_3

    if-eqz v6, :cond_5

    .line 75
    :cond_3
    const/4 v7, 0x0

    iput-boolean v7, p0, Lcom/comcast/playerplatform/primetime/android/ads/CustomAdBreakPolicySelector;->useResumeLogic:Z

    .line 76
    const/4 v7, 0x1

    invoke-static {v7}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v7

    invoke-virtual {v0, v7}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->setIsWatched(Ljava/lang/Boolean;)V

    .line 85
    .end local v0    # "adBreak":Lcom/adobe/mediacore/timeline/advertising/AdBreak;
    .end local v4    # "i$":Ljava/util/Iterator;
    .end local v6    # "skipAd":Z
    :cond_4
    :goto_1
    return-object v2

    .line 77
    .restart local v0    # "adBreak":Lcom/adobe/mediacore/timeline/advertising/AdBreak;
    .restart local v4    # "i$":Ljava/util/Iterator;
    .restart local v6    # "skipAd":Z
    :cond_5
    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->isWatched()Ljava/lang/Boolean;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v7

    if-eqz v7, :cond_6

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->getTime()J

    move-result-wide v8

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;->getSeekToTime()J

    move-result-wide v10

    cmp-long v7, v8, v10

    if-gtz v7, :cond_4

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->getTime()J

    move-result-wide v8

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->getDuration()J

    move-result-wide v10

    add-long/2addr v8, v10

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;->getSeekToTime()J

    move-result-wide v10

    cmp-long v7, v8, v10

    if-lez v7, :cond_4

    .line 80
    :cond_6
    invoke-interface {v2, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1
.end method

.method public selectPolicyForAdBreak(Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;)Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;
    .locals 1
    .param p1, "adPolicyInfo"    # Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;

    .prologue
    .line 39
    sget-object v0, Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;->PLAY:Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;

    return-object v0
.end method

.method public selectPolicyForSeekIntoAd(Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;)Lcom/adobe/mediacore/timeline/advertising/AdPolicy;
    .locals 8
    .param p1, "adPolicyInfo"    # Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;

    .prologue
    .line 44
    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;->getAdBreakPlacements()Ljava/util/List;

    move-result-object v3

    const/4 v4, 0x0

    invoke-interface {v3, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    invoke-virtual {v3}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v0

    .line 45
    .local v0, "adbreak":Lcom/adobe/mediacore/timeline/advertising/AdBreak;
    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/ads/CustomAdBreakPolicySelector;->adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    if-eqz v3, :cond_1

    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/ads/CustomAdBreakPolicySelector;->adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    invoke-virtual {v3}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->getCurrentAdBreak()Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    move-result-object v1

    .line 46
    .local v1, "currentAdBreak":Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
    :goto_0
    const/4 v2, 0x0

    .line 47
    .local v2, "policy":Lcom/adobe/mediacore/timeline/advertising/AdPolicy;
    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->isWatched()Ljava/lang/Boolean;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    if-nez v3, :cond_0

    if-eqz v1, :cond_2

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->getTag()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;->getSeekToTime()J

    move-result-wide v4

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;->getCurrentTime()J

    move-result-wide v6

    cmp-long v3, v4, v6

    if-gez v3, :cond_2

    .line 50
    :cond_0
    sget-object v2, Lcom/adobe/mediacore/timeline/advertising/AdPolicy;->PLAY:Lcom/adobe/mediacore/timeline/advertising/AdPolicy;

    .line 55
    :goto_1
    return-object v2

    .line 45
    .end local v1    # "currentAdBreak":Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
    .end local v2    # "policy":Lcom/adobe/mediacore/timeline/advertising/AdPolicy;
    :cond_1
    const/4 v1, 0x0

    goto :goto_0

    .line 52
    .restart local v1    # "currentAdBreak":Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
    .restart local v2    # "policy":Lcom/adobe/mediacore/timeline/advertising/AdPolicy;
    :cond_2
    sget-object v2, Lcom/adobe/mediacore/timeline/advertising/AdPolicy;->PLAY_FROM_AD_BREAK_BEGIN:Lcom/adobe/mediacore/timeline/advertising/AdPolicy;

    goto :goto_1
.end method

.method public selectWatchedPolicyForAdBreak(Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;)Lcom/adobe/mediacore/metadata/AdBreakAsWatched;
    .locals 2
    .param p1, "adPolicyInfo"    # Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;

    .prologue
    .line 24
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/ads/CustomAdBreakPolicySelector;->adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    if-nez v1, :cond_0

    .line 25
    sget-object v1, Lcom/adobe/mediacore/metadata/AdBreakAsWatched;->AD_BREAK_AS_WATCHED_NEVER:Lcom/adobe/mediacore/metadata/AdBreakAsWatched;

    .line 34
    :goto_0
    return-object v1

    .line 28
    :cond_0
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/ads/CustomAdBreakPolicySelector;->adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->getWatchedPolicy()Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakWatchedPolicy;

    move-result-object v0

    .line 30
    .local v0, "adBreakAsWatched":Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakWatchedPolicy;
    if-eqz v0, :cond_1

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakWatchedPolicy;->MARK_AS_WATCHED:Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakWatchedPolicy;

    if-ne v0, v1, :cond_1

    .line 31
    sget-object v1, Lcom/adobe/mediacore/metadata/AdBreakAsWatched;->AD_BREAK_AS_WATCHED_ON_END:Lcom/adobe/mediacore/metadata/AdBreakAsWatched;

    goto :goto_0

    .line 34
    :cond_1
    sget-object v1, Lcom/adobe/mediacore/metadata/AdBreakAsWatched;->AD_BREAK_AS_WATCHED_NEVER:Lcom/adobe/mediacore/metadata/AdBreakAsWatched;

    goto :goto_0
.end method
