.class public Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;
.super Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;
.source "ManifestManipulatorTimeline.java"


# instance fields
.field private hasUpcomingAd:Z

.field private hasUpcomingAdBreak:Z

.field private nextAd:Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

.field private nextAdBreak:Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;


# direct methods
.method public constructor <init>(Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;)V
    .locals 1
    .param p1, "adManager"    # Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    .prologue
    const/4 v0, 0x1

    .line 21
    invoke-direct {p0, p1}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;-><init>(Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;)V

    .line 15
    iput-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->hasUpcomingAdBreak:Z

    .line 16
    iput-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->hasUpcomingAd:Z

    .line 22
    return-void
.end method

.method private adBreakComplete()V
    .locals 2

    .prologue
    .line 94
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    if-eqz v0, :cond_0

    .line 95
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->currentAdBreak:Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->triggerAdBreakComplete(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;)V

    .line 96
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->currentAdBreak:Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->markAsSeen(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;)V

    .line 98
    :cond_0
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->currentAdBreak:Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    .line 99
    iget-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->hasUpcomingAdBreak:Z

    iput-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->hasUpcomingAd:Z

    .line 100
    return-void
.end method

.method private adComplete(J)V
    .locals 3
    .param p1, "position"    # J

    .prologue
    .line 103
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    if-eqz v0, :cond_0

    .line 104
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->currentAdBreak:Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->currentAd:Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    invoke-virtual {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->triggerAdComplete(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;)V

    .line 106
    :cond_0
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->currentAd:Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    .line 107
    invoke-direct {p0, p1, p2}, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->checkForAdStart(J)V

    .line 108
    return-void
.end method

.method private checkForAdBreakStart(J)V
    .locals 5
    .param p1, "position"    # J

    .prologue
    .line 111
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->currentAdBreak:Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    if-nez v2, :cond_3

    .line 112
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->nextAdBreak:Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    if-nez v2, :cond_0

    iget-boolean v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->hasUpcomingAdBreak:Z

    if-eqz v2, :cond_0

    .line 113
    invoke-virtual {p0, p1, p2}, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->updateNextAdBreak(J)V

    .line 116
    :cond_0
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->nextAdBreak:Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    if-eqz v2, :cond_3

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->nextAdBreak:Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    invoke-virtual {v2, p1, p2}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->coversLocation(J)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 117
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->nextAdBreak:Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    iput-object v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->currentAdBreak:Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    .line 118
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->adRestrictions:Ljava/util/ArrayList;

    if-eqz v2, :cond_2

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->adRestrictions:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-lez v2, :cond_2

    .line 119
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->adRestrictions:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_1
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_2

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction;

    .line 120
    .local v1, "restriction":Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction;
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->currentAdBreak:Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    invoke-virtual {v2}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->getId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 121
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->currentAdBreak:Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    invoke-virtual {v2, v1}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->addRestriction(Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction;)V

    goto :goto_0

    .line 125
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "restriction":Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction;
    :cond_2
    invoke-direct {p0, p1, p2}, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->updateNextAd(J)V

    .line 126
    const/4 v2, 0x0

    iput-object v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->nextAdBreak:Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    .line 128
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->currentAdBreak:Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    invoke-virtual {v2}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->getEndTime()J

    move-result-wide v2

    invoke-virtual {p0, v2, v3}, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->updateNextAdBreak(J)V

    .line 129
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->currentAdBreak:Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    invoke-virtual {v2, p1, p2}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->updateProgress(J)V

    .line 130
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->nextAd:Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    invoke-virtual {v2, p1, p2}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->updateProgress(J)V

    .line 131
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->currentAdBreak:Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    iget-object v4, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->nextAd:Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    invoke-virtual {v2, v3, v4}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->triggerAdBreakStart(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;)V

    .line 132
    invoke-direct {p0, p1, p2}, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->checkForAdStart(J)V

    .line 135
    :cond_3
    return-void
.end method

.method private checkForAdComplete(J)V
    .locals 3
    .param p1, "position"    # J

    .prologue
    .line 71
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->currentAd:Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    if-eqz v0, :cond_1

    .line 72
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->currentAd:Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    invoke-virtual {v0, p1, p2}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->coversLocation(J)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->currentAd:Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->getEndTime()J

    move-result-wide v0

    cmp-long v0, p1, v0

    if-nez v0, :cond_1

    .line 73
    :cond_0
    invoke-direct {p0, p1, p2}, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->adComplete(J)V

    .line 76
    :cond_1
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->currentAdBreak:Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    if-eqz v0, :cond_3

    .line 77
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->currentAdBreak:Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    invoke-virtual {v0, p1, p2}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->coversLocation(J)Z

    move-result v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->currentAdBreak:Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->getEndTime()J

    move-result-wide v0

    cmp-long v0, p1, v0

    if-nez v0, :cond_3

    .line 78
    :cond_2
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->adBreakComplete()V

    .line 81
    :cond_3
    return-void
.end method

.method private checkForAdProgress(J)V
    .locals 7
    .param p1, "position"    # J

    .prologue
    .line 84
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->currentAdBreak:Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->currentAd:Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    if-eqz v0, :cond_0

    .line 85
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->currentAdBreak:Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    invoke-virtual {v0, p1, p2}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->updateProgress(J)V

    .line 86
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->currentAd:Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    invoke-virtual {v0, p1, p2}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->updateProgress(J)V

    .line 87
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    if-eqz v0, :cond_0

    .line 88
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->currentAdBreak:Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->currentAd:Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->currentAdBreak:Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    invoke-virtual {v3}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->getPercentComplete()I

    move-result v3

    iget-object v4, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->currentAdBreak:Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    invoke-virtual {v4}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->getSecondsRemaining()J

    move-result-wide v4

    invoke-virtual/range {v0 .. v5}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->triggerAdProgress(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;IJ)V

    .line 91
    :cond_0
    return-void
.end method

.method private checkForAdStart(J)V
    .locals 3
    .param p1, "position"    # J

    .prologue
    .line 138
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->nextAd:Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    if-nez v0, :cond_0

    iget-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->hasUpcomingAd:Z

    if-eqz v0, :cond_0

    .line 139
    invoke-direct {p0, p1, p2}, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->updateNextAd(J)V

    .line 142
    :cond_0
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->nextAd:Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->nextAd:Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    invoke-virtual {v0, p1, p2}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->coversLocation(J)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 143
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->nextAd:Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->currentAd:Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    .line 144
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->nextAd:Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    .line 145
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->currentAd:Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->getEndTime()J

    move-result-wide v0

    invoke-direct {p0, v0, v1}, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->updateNextAd(J)V

    .line 146
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->currentAd:Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    invoke-virtual {v0, p1, p2}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->updateProgress(J)V

    .line 147
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->currentAdBreak:Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->currentAd:Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    invoke-virtual {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->triggerAdStart(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;)V

    .line 149
    :cond_1
    return-void
.end method

.method private updateNextAd(J)V
    .locals 9
    .param p1, "position"    # J

    .prologue
    .line 152
    const/4 v2, 0x0

    .line 154
    .local v2, "newNextAd":Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;
    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->currentAdBreak:Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    if-eqz v3, :cond_2

    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->currentAdBreak:Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    invoke-virtual {v3}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->getVideoAdsList()Ljava/util/List;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    if-eqz v3, :cond_2

    .line 155
    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->currentAdBreak:Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    invoke-virtual {v3}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->getVideoAdsList()Ljava/util/List;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    .line 156
    .local v0, "ad":Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;
    invoke-virtual {v0, p1, p2}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->coversLocation(J)Z

    move-result v3

    if-nez v3, :cond_1

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->getStartTime()J

    move-result-wide v4

    cmp-long v3, p1, v4

    if-gtz v3, :cond_0

    if-eqz v2, :cond_1

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->getStartTime()J

    move-result-wide v4

    invoke-virtual {v2}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->getStartTime()J

    move-result-wide v6

    cmp-long v3, v4, v6

    if-gtz v3, :cond_0

    .line 157
    :cond_1
    move-object v2, v0

    goto :goto_0

    .line 161
    .end local v0    # "ad":Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;
    .end local v1    # "i$":Ljava/util/Iterator;
    :cond_2
    if-eqz v2, :cond_3

    const/4 v3, 0x1

    :goto_1
    iput-boolean v3, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->hasUpcomingAd:Z

    .line 162
    iput-object v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->nextAd:Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    .line 163
    return-void

    .line 161
    :cond_3
    const/4 v3, 0x0

    goto :goto_1
.end method


# virtual methods
.method public clear()V
    .locals 0

    .prologue
    .line 238
    return-void
.end method

.method public createAdBreak(Ljava/lang/String;Ljava/lang/Long;J)V
    .locals 11
    .param p1, "id"    # Ljava/lang/String;
    .param p2, "time"    # Ljava/lang/Long;
    .param p3, "duration"    # J

    .prologue
    .line 200
    invoke-static {p1}, Lcom/comcast/playerplatform/util/android/StringUtil;->isNotNullOrEmpty(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_3

    const-wide/16 v6, 0x0

    cmp-long v5, p3, v6

    if-lez v5, :cond_3

    .line 201
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    invoke-direct {v0}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;-><init>()V

    .line 202
    .local v0, "ad":Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;
    invoke-virtual {v0, p1}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->setId(Ljava/lang/String;)V

    .line 203
    invoke-virtual {p2}, Ljava/lang/Long;->longValue()J

    move-result-wide v6

    invoke-virtual {v0, v6, v7}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->setStartTime(J)V

    .line 204
    invoke-virtual {v0, p3, p4}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->setDuration(J)V

    .line 206
    new-instance v1, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    invoke-direct {v1}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;-><init>()V

    .line 207
    .local v1, "adBreak":Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
    invoke-virtual {v1, p1}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->setId(Ljava/lang/String;)V

    .line 209
    iget-object v5, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->adBreaks:Ljava/util/List;

    if-nez v5, :cond_0

    .line 210
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    iput-object v5, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->adBreaks:Ljava/util/List;

    .line 213
    :cond_0
    const/4 v3, 0x1

    .line 214
    .local v3, "newBreakNeedsAdding":Z
    iget-object v5, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->adBreaks:Ljava/util/List;

    invoke-interface {v5}, Ljava/util/List;->size()I

    move-result v5

    if-eqz v5, :cond_2

    .line 215
    iget-object v5, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->adBreaks:Ljava/util/List;

    invoke-interface {v5}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :cond_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_2

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    .line 216
    .local v4, "videoAdBreak":Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
    invoke-virtual {v4}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->getEndTime()J

    move-result-wide v6

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->getStartTime()J

    move-result-wide v8

    cmp-long v5, v6, v8

    if-nez v5, :cond_1

    .line 217
    move-object v1, v4

    .line 218
    const/4 v3, 0x0

    .line 224
    .end local v2    # "i$":Ljava/util/Iterator;
    .end local v4    # "videoAdBreak":Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
    :cond_2
    invoke-virtual {v1, v0}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->addAd(Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;)V

    .line 226
    if-eqz v3, :cond_3

    .line 227
    iget-object v5, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->adBreaks:Ljava/util/List;

    invoke-interface {v5, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 230
    .end local v0    # "ad":Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;
    .end local v1    # "adBreak":Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
    .end local v3    # "newBreakNeedsAdding":Z
    :cond_3
    return-void
.end method

.method public createAdRestriction(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "id"    # Ljava/lang/String;
    .param p2, "type"    # Ljava/lang/String;
    .param p3, "limit"    # Ljava/lang/String;

    .prologue
    .line 187
    invoke-static {p1}, Lcom/comcast/playerplatform/util/android/StringUtil;->isNotNullOrEmpty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-static {p2}, Lcom/comcast/playerplatform/util/android/StringUtil;->isNotNullOrEmpty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 188
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction;

    invoke-direct {v0, p1, p2, p3}, Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 190
    .local v0, "adRestriction":Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction;
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->adRestrictions:Ljava/util/ArrayList;

    if-nez v1, :cond_0

    .line 191
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->adRestrictions:Ljava/util/ArrayList;

    .line 193
    :cond_0
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->adRestrictions:Ljava/util/ArrayList;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 195
    .end local v0    # "adRestriction":Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction;
    :cond_1
    return-void
.end method

.method public getCurrentAd()Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;
    .locals 1

    .prologue
    .line 233
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->currentAd:Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    return-object v0
.end method

.method public onSeekEnd(J)V
    .locals 1
    .param p1, "position"    # J

    .prologue
    .line 32
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->currentAdBreak:Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    if-eqz v0, :cond_2

    .line 33
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->currentAdBreak:Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    invoke-virtual {v0, p1, p2}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->coversLocation(J)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 34
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->currentAd:Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->currentAd:Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    invoke-virtual {v0, p1, p2}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->coversLocation(J)Z

    move-result v0

    if-nez v0, :cond_0

    .line 35
    invoke-direct {p0, p1, p2}, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->adComplete(J)V

    .line 47
    :goto_0
    return-void

    .line 37
    :cond_0
    invoke-direct {p0, p1, p2}, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->updateNextAd(J)V

    .line 38
    invoke-direct {p0, p1, p2}, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->checkForAdStart(J)V

    goto :goto_0

    .line 41
    :cond_1
    invoke-direct {p0, p1, p2}, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->adComplete(J)V

    .line 42
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->adBreakComplete()V

    goto :goto_0

    .line 45
    :cond_2
    invoke-virtual {p0, p1, p2}, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->updateNextAdBreak(J)V

    goto :goto_0
.end method

.method public onSeekStart(J)V
    .locals 0
    .param p1, "position"    # J

    .prologue
    .line 28
    return-void
.end method

.method public streamComplete()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 50
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    if-eqz v0, :cond_0

    .line 51
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->currentAdBreak:Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->currentAd:Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    invoke-virtual {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->triggerAdComplete(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;)V

    .line 53
    :cond_0
    iput-object v3, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->currentAd:Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    .line 55
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    if-eqz v0, :cond_1

    .line 56
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->currentAdBreak:Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->triggerAdBreakComplete(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;)V

    .line 57
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->currentAdBreak:Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->markAsSeen(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;)V

    .line 59
    :cond_1
    iput-object v3, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->currentAdBreak:Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    .line 60
    iget-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->hasUpcomingAdBreak:Z

    iput-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->hasUpcomingAd:Z

    .line 61
    return-void
.end method

.method public updateNextAdBreak(J)V
    .locals 9
    .param p1, "position"    # J

    .prologue
    .line 166
    const/4 v2, 0x0

    .line 168
    .local v2, "newNextAdBreak":Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->adBreaks:Ljava/util/List;

    if-eqz v3, :cond_3

    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->adBreaks:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    if-eqz v3, :cond_3

    .line 169
    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->adBreaks:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_3

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    .line 170
    .local v0, "adBreak":Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->getStartTime()J

    move-result-wide v4

    cmp-long v3, p1, v4

    if-gtz v3, :cond_2

    if-eqz v2, :cond_1

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->getStartTime()J

    move-result-wide v4

    invoke-virtual {v2}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->getStartTime()J

    move-result-wide v6

    cmp-long v3, v4, v6

    if-gtz v3, :cond_2

    .line 171
    :cond_1
    move-object v2, v0

    goto :goto_0

    .line 172
    :cond_2
    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->currentAdBreak:Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    if-nez v3, :cond_0

    invoke-virtual {v0, p1, p2}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->coversLocation(J)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 173
    move-object v2, v0

    .line 179
    .end local v0    # "adBreak":Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
    .end local v1    # "i$":Ljava/util/Iterator;
    :cond_3
    if-eqz v2, :cond_4

    const/4 v3, 0x1

    :goto_1
    iput-boolean v3, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->hasUpcomingAdBreak:Z

    .line 181
    iput-object v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->nextAdBreak:Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    .line 182
    return-void

    .line 179
    :cond_4
    const/4 v3, 0x0

    goto :goto_1
.end method

.method public declared-synchronized updateProgress(J)V
    .locals 1
    .param p1, "position"    # J

    .prologue
    .line 65
    monitor-enter p0

    :try_start_0
    invoke-direct {p0, p1, p2}, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->checkForAdBreakStart(J)V

    .line 66
    invoke-direct {p0, p1, p2}, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->checkForAdComplete(J)V

    .line 67
    invoke-direct {p0, p1, p2}, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;->checkForAdProgress(J)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 68
    monitor-exit p0

    return-void

    .line 65
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method
