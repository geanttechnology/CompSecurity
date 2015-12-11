.class public Lcom/auditude/ads/model/LinearAsset;
.super Lcom/auditude/ads/model/Asset;
.source "LinearAsset.java"

# interfaces
.implements Lcom/auditude/ads/model/ILinearAsset;


# direct methods
.method public constructor <init>(Lcom/auditude/ads/model/BaseElement;)V
    .locals 0
    .param p1, "parent"    # Lcom/auditude/ads/model/BaseElement;

    .prologue
    .line 14
    invoke-direct {p0, p1}, Lcom/auditude/ads/model/Asset;-><init>(Lcom/auditude/ads/model/BaseElement;)V

    .line 15
    return-void
.end method


# virtual methods
.method public CopyTo(Lcom/auditude/ads/model/Asset;)V
    .locals 2
    .param p1, "asset"    # Lcom/auditude/ads/model/Asset;

    .prologue
    const/4 v1, 0x0

    .line 43
    invoke-super {p0, p1}, Lcom/auditude/ads/model/Asset;->CopyTo(Lcom/auditude/ads/model/Asset;)V

    .line 45
    if-eqz p1, :cond_0

    .line 48
    const-string v0, "start"

    invoke-virtual {p0, p1, v0, v1}, Lcom/auditude/ads/model/LinearAsset;->copyTrackingEventsTo(Lcom/auditude/ads/model/BaseElement;Ljava/lang/String;Ljava/lang/String;)V

    .line 49
    const-string v0, "firstquartile"

    invoke-virtual {p0, p1, v0, v1}, Lcom/auditude/ads/model/LinearAsset;->copyTrackingEventsTo(Lcom/auditude/ads/model/BaseElement;Ljava/lang/String;Ljava/lang/String;)V

    .line 50
    const-string v0, "midpoint"

    invoke-virtual {p0, p1, v0, v1}, Lcom/auditude/ads/model/LinearAsset;->copyTrackingEventsTo(Lcom/auditude/ads/model/BaseElement;Ljava/lang/String;Ljava/lang/String;)V

    .line 51
    const-string v0, "thirdquartile"

    invoke-virtual {p0, p1, v0, v1}, Lcom/auditude/ads/model/LinearAsset;->copyTrackingEventsTo(Lcom/auditude/ads/model/BaseElement;Ljava/lang/String;Ljava/lang/String;)V

    .line 52
    const-string v0, "complete"

    invoke-virtual {p0, p1, v0, v1}, Lcom/auditude/ads/model/LinearAsset;->copyTrackingEventsTo(Lcom/auditude/ads/model/BaseElement;Ljava/lang/String;Ljava/lang/String;)V

    .line 54
    :cond_0
    return-void
.end method

.method public getType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 20
    const-string v0, "linear"

    return-object v0
.end method

.method public getUrl()Ljava/lang/String;
    .locals 3

    .prologue
    .line 26
    invoke-virtual {p0}, Lcom/auditude/ads/model/LinearAsset;->getApiFramework()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/auditude/ads/util/StringUtil;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    invoke-virtual {p0}, Lcom/auditude/ads/model/LinearAsset;->getApiFramework()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v1

    const-string v2, "vpaid"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 28
    invoke-super {p0}, Lcom/auditude/ads/model/Asset;->getUrl()Ljava/lang/String;

    move-result-object v1

    .line 37
    :goto_0
    return-object v1

    .line 31
    :cond_0
    invoke-virtual {p0}, Lcom/auditude/ads/model/LinearAsset;->getMediaFiles()Ljava/util/ArrayList;

    move-result-object v1

    invoke-static {}, Lcom/auditude/ads/core/AuditudeEnv;->getInstance()Lcom/auditude/ads/core/AuditudeEnv;

    move-result-object v2

    invoke-virtual {v2}, Lcom/auditude/ads/core/AuditudeEnv;->getAdSettings()Lcom/auditude/ads/core/AdSettings;

    move-result-object v2

    invoke-virtual {v2}, Lcom/auditude/ads/core/AdSettings;->getBitRate()I

    move-result v2

    invoke-static {v1, v2}, Lcom/auditude/ads/model/media/MediaStreamSet;->Search(Ljava/util/ArrayList;I)Lcom/auditude/ads/model/media/MediaFile;

    move-result-object v0

    .line 32
    .local v0, "mediaFile":Lcom/auditude/ads/model/media/MediaFile;
    if-eqz v0, :cond_1

    iget-object v1, v0, Lcom/auditude/ads/model/media/MediaFile;->source:Ljava/lang/String;

    invoke-static {v1}, Lcom/auditude/ads/util/StringUtil;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 34
    iget-object v1, v0, Lcom/auditude/ads/model/media/MediaFile;->source:Ljava/lang/String;

    goto :goto_0

    .line 37
    :cond_1
    invoke-super {p0}, Lcom/auditude/ads/model/Asset;->getUrl()Ljava/lang/String;

    move-result-object v1

    goto :goto_0
.end method
