.class public Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;
.super Ljava/lang/Object;
.source "BaseAdTimeline.java"

# interfaces
.implements Lcom/adobe/mediacore/MediaPlayer$AdPlaybackEventListener;
.implements Lcom/comcast/playerplatform/primetime/android/ads/managers/AdTimeline;


# instance fields
.field protected adBreaks:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;",
            ">;"
        }
    .end annotation
.end field

.field protected adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

.field protected adRestrictions:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction;",
            ">;"
        }
    .end annotation
.end field

.field protected currentAd:Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

.field protected currentAdBreak:Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

.field protected currentPosition:J


# direct methods
.method public constructor <init>(Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;)V
    .locals 2
    .param p1, "adManager"    # Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    .prologue
    .line 26
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;->currentPosition:J

    .line 27
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;->adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    .line 28
    return-void
.end method


# virtual methods
.method public addAd(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;)V
    .locals 0
    .param p1, "adbreak"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    .prologue
    .line 43
    return-void
.end method

.method public clear()V
    .locals 0

    .prologue
    .line 89
    return-void
.end method

.method public createAdBreak(Ljava/lang/String;Ljava/lang/Long;J)V
    .locals 0
    .param p1, "id"    # Ljava/lang/String;
    .param p2, "time"    # Ljava/lang/Long;
    .param p3, "duration"    # J

    .prologue
    .line 99
    return-void
.end method

.method public createAdRestriction(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "id"    # Ljava/lang/String;
    .param p2, "type"    # Ljava/lang/String;
    .param p3, "limit"    # Ljava/lang/String;

    .prologue
    .line 94
    return-void
.end method

.method public getAdList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;",
            ">;"
        }
    .end annotation

    .prologue
    .line 32
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;->adBreaks:Ljava/util/List;

    return-object v0
.end method

.method public getCurrentAd()Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;
    .locals 1

    .prologue
    .line 73
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;->currentAd:Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    return-object v0
.end method

.method public getCurrentAdBreak()Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
    .locals 1

    .prologue
    .line 68
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;->currentAdBreak:Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    return-object v0
.end method

.method public isAdPlaying()Z
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;->currentAdBreak:Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onAdBreakComplete(Lcom/adobe/mediacore/timeline/advertising/AdBreak;)V
    .locals 0
    .param p1, "adBreak"    # Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    .prologue
    .line 129
    return-void
.end method

.method public onAdBreakSkipped(Lcom/adobe/mediacore/timeline/advertising/AdBreak;)V
    .locals 0
    .param p1, "adBreak"    # Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    .prologue
    .line 134
    return-void
.end method

.method public onAdBreakStart(Lcom/adobe/mediacore/timeline/advertising/AdBreak;)V
    .locals 0
    .param p1, "adBreak"    # Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    .prologue
    .line 109
    return-void
.end method

.method public onAdClick(Lcom/adobe/mediacore/timeline/advertising/AdBreak;Lcom/adobe/mediacore/timeline/advertising/Ad;Lcom/adobe/mediacore/timeline/advertising/AdClick;)V
    .locals 0
    .param p1, "adBreak"    # Lcom/adobe/mediacore/timeline/advertising/AdBreak;
    .param p2, "ad"    # Lcom/adobe/mediacore/timeline/advertising/Ad;
    .param p3, "adClick"    # Lcom/adobe/mediacore/timeline/advertising/AdClick;

    .prologue
    .line 139
    return-void
.end method

.method public onAdComplete(Lcom/adobe/mediacore/timeline/advertising/AdBreak;Lcom/adobe/mediacore/timeline/advertising/Ad;)V
    .locals 0
    .param p1, "adBreak"    # Lcom/adobe/mediacore/timeline/advertising/AdBreak;
    .param p2, "ad"    # Lcom/adobe/mediacore/timeline/advertising/Ad;

    .prologue
    .line 124
    return-void
.end method

.method public onAdProgress(Lcom/adobe/mediacore/timeline/advertising/AdBreak;Lcom/adobe/mediacore/timeline/advertising/Ad;I)V
    .locals 0
    .param p1, "adBreak"    # Lcom/adobe/mediacore/timeline/advertising/AdBreak;
    .param p2, "ad"    # Lcom/adobe/mediacore/timeline/advertising/Ad;
    .param p3, "i"    # I

    .prologue
    .line 119
    return-void
.end method

.method public onAdStart(Lcom/adobe/mediacore/timeline/advertising/AdBreak;Lcom/adobe/mediacore/timeline/advertising/Ad;)V
    .locals 0
    .param p1, "adBreak"    # Lcom/adobe/mediacore/timeline/advertising/AdBreak;
    .param p2, "ad"    # Lcom/adobe/mediacore/timeline/advertising/Ad;

    .prologue
    .line 114
    return-void
.end method

.method public onSeekEnd(J)V
    .locals 0
    .param p1, "position"    # J

    .prologue
    .line 64
    return-void
.end method

.method public onSeekStart(J)V
    .locals 0
    .param p1, "position"    # J

    .prologue
    .line 59
    return-void
.end method

.method public setAdList(Ljava/util/List;)V
    .locals 0
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
    .line 37
    .local p1, "adList":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;>;"
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;->adBreaks:Ljava/util/List;

    .line 38
    return-void
.end method

.method public setResumePosition(J)V
    .locals 0
    .param p1, "position"    # J

    .prologue
    .line 104
    return-void
.end method

.method public streamComplete()V
    .locals 0

    .prologue
    .line 84
    return-void
.end method

.method public updateProgress(J)V
    .locals 0
    .param p1, "position"    # J

    .prologue
    .line 79
    return-void
.end method
