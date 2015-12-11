.class public Lcom/comcast/playerplatform/primetime/android/ads/FreewheelAdResolver;
.super Lcom/adobe/mediacore/timeline/advertising/ContentResolver;
.source "FreewheelAdResolver.java"


# instance fields
.field freewheelManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;


# direct methods
.method public constructor <init>(Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;)V
    .locals 0
    .param p1, "adManager"    # Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;

    .prologue
    .line 22
    invoke-direct {p0}, Lcom/adobe/mediacore/timeline/advertising/ContentResolver;-><init>()V

    .line 23
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/ads/FreewheelAdResolver;->freewheelManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;

    .line 24
    return-void
.end method

.method static synthetic access$000(Lcom/comcast/playerplatform/primetime/android/ads/FreewheelAdResolver;Ljava/util/List;)V
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/ads/FreewheelAdResolver;
    .param p1, "x1"    # Ljava/util/List;

    .prologue
    .line 19
    invoke-virtual {p0, p1}, Lcom/comcast/playerplatform/primetime/android/ads/FreewheelAdResolver;->notifyResolveComplete(Ljava/util/List;)V

    return-void
.end method


# virtual methods
.method protected doCanResolve(Lcom/adobe/mediacore/timeline/PlacementOpportunity;)Z
    .locals 1
    .param p1, "placementOpportunity"    # Lcom/adobe/mediacore/timeline/PlacementOpportunity;

    .prologue
    .line 45
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/FreewheelAdResolver;->freewheelManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected doProvideAdTracker()Lcom/adobe/mediacore/timeline/advertising/ContentTracker;
    .locals 1

    .prologue
    .line 50
    const/4 v0, 0x0

    return-object v0
.end method

.method protected doResolveAds(Lcom/adobe/mediacore/metadata/Metadata;Lcom/adobe/mediacore/timeline/PlacementOpportunity;)V
    .locals 2
    .param p1, "metadata"    # Lcom/adobe/mediacore/metadata/Metadata;
    .param p2, "placementOpportunity"    # Lcom/adobe/mediacore/timeline/PlacementOpportunity;

    .prologue
    .line 28
    const-string v0, "Pauk"

    const-string v1, "doResolveAds was called"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 29
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;

    move-result-object v0

    new-instance v1, Lcom/comcast/playerplatform/primetime/android/ads/FreewheelAdResolver$1;

    invoke-direct {v1, p0}, Lcom/comcast/playerplatform/primetime/android/ads/FreewheelAdResolver$1;-><init>(Lcom/comcast/playerplatform/primetime/android/ads/FreewheelAdResolver;)V

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->executeRunnable(Ljava/lang/Runnable;)V

    .line 41
    return-void
.end method
