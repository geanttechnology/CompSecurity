.class public Lcom/comcast/playerplatform/primetime/android/ads/CustomAdvertisingFactory;
.super Lcom/adobe/mediacore/DefaultAdvertisingFactory;
.source "CustomAdvertisingFactory.java"


# instance fields
.field private adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

.field private useResumeLogic:Z


# direct methods
.method public constructor <init>(Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;Z)V
    .locals 1
    .param p1, "adManager"    # Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;
    .param p2, "useResumeLogic"    # Z

    .prologue
    .line 27
    invoke-virtual {p1}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->getSignalingMode()Lcom/adobe/mediacore/metadata/AdSignalingMode;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/adobe/mediacore/DefaultAdvertisingFactory;-><init>(Lcom/adobe/mediacore/metadata/AdSignalingMode;)V

    .line 28
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/ads/CustomAdvertisingFactory;->adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    .line 29
    iput-boolean p2, p0, Lcom/comcast/playerplatform/primetime/android/ads/CustomAdvertisingFactory;->useResumeLogic:Z

    .line 30
    return-void
.end method


# virtual methods
.method public createAdPolicySelector(Lcom/adobe/mediacore/MediaPlayerItem;)Lcom/adobe/mediacore/timeline/advertising/AdPolicySelector;
    .locals 3
    .param p1, "mediaPlayerItem"    # Lcom/adobe/mediacore/MediaPlayerItem;

    .prologue
    .line 35
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/ads/CustomAdBreakPolicySelector;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/ads/CustomAdvertisingFactory;->adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    iget-boolean v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/CustomAdvertisingFactory;->useResumeLogic:Z

    invoke-direct {v0, p1, v1, v2}, Lcom/comcast/playerplatform/primetime/android/ads/CustomAdBreakPolicySelector;-><init>(Lcom/adobe/mediacore/MediaPlayerItem;Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;Z)V

    return-object v0
.end method

.method public createContentResolvers(Lcom/adobe/mediacore/MediaPlayerItem;)Ljava/util/List;
    .locals 4
    .param p1, "item"    # Lcom/adobe/mediacore/MediaPlayerItem;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/adobe/mediacore/MediaPlayerItem;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/timeline/advertising/ContentResolver;",
            ">;"
        }
    .end annotation

    .prologue
    .line 40
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 41
    .local v0, "contentResolvers":Ljava/util/List;, "Ljava/util/List<Lcom/adobe/mediacore/timeline/advertising/ContentResolver;>;"
    invoke-interface {p1}, Lcom/adobe/mediacore/MediaPlayerItem;->getResource()Lcom/adobe/mediacore/MediaResource;

    move-result-object v2

    invoke-virtual {v2}, Lcom/adobe/mediacore/MediaResource;->getMetadata()Lcom/adobe/mediacore/metadata/Metadata;

    move-result-object v1

    .line 43
    .local v1, "metadata":Lcom/adobe/mediacore/metadata/Metadata;
    if-eqz v1, :cond_0

    .line 44
    sget-object v2, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->CUSTOM_AD_MARKERS_METADATA_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v2}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Lcom/adobe/mediacore/metadata/Metadata;->containsKey(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 45
    new-instance v2, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomAdMarkersContentResolver;

    invoke-direct {v2}, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomAdMarkersContentResolver;-><init>()V

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 54
    :cond_0
    :goto_0
    return-object v0

    .line 46
    :cond_1
    sget-object v2, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->AUDITUDE_METADATA_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v2}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Lcom/adobe/mediacore/metadata/Metadata;->containsKey(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 47
    new-instance v2, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;

    invoke-direct {v2}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;-><init>()V

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 48
    :cond_2
    sget-object v2, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->JSON_METADATA_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v2}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Lcom/adobe/mediacore/metadata/Metadata;->containsKey(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 49
    new-instance v2, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;

    invoke-direct {v2}, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;-><init>()V

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 50
    :cond_3
    const-string v2, "FREEWHEEL_AD_KEY"

    invoke-interface {v1, v2}, Lcom/adobe/mediacore/metadata/Metadata;->containsKey(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 51
    new-instance v3, Lcom/comcast/playerplatform/primetime/android/ads/FreewheelAdResolver;

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/CustomAdvertisingFactory;->adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    check-cast v2, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;

    invoke-direct {v3, v2}, Lcom/comcast/playerplatform/primetime/android/ads/FreewheelAdResolver;-><init>(Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;)V

    invoke-interface {v0, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method
