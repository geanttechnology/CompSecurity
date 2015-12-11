.class public Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsAssetUtil;
.super Ljava/lang/Object;
.source "AnalyticsAssetUtil.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static convertPlayerAssetToXuaAsset(Lcom/comcast/playerplatform/primetime/android/asset/Asset;)Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;
    .locals 8
    .param p0, "asset"    # Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    .prologue
    .line 21
    const/4 v0, 0x0

    .line 23
    .local v0, "abstractXuaAsset":Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;
    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->getAssetInfo()Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;

    move-result-object v1

    .line 24
    .local v1, "assetInfo":Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;
    if-eqz v1, :cond_0

    .line 25
    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->getProviderId()Ljava/lang/String;

    move-result-object v4

    if-eqz v4, :cond_1

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->getAssetId()Ljava/lang/String;

    move-result-object v4

    if-eqz v4, :cond_1

    .line 26
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/assets/PAIDAsset;

    .end local v0    # "abstractXuaAsset":Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;
    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->getStreamType()Lcom/comcast/playerplatform/primetime/android/enums/StreamType;

    move-result-object v4

    invoke-virtual {v4}, Lcom/comcast/playerplatform/primetime/android/enums/StreamType;->name()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->getProviderId()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->getAssetId()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->getMediaGuid()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v0, v4, v5, v6, v7}, Lcom/comcast/playerplatform/analytics/java/xua/assets/PAIDAsset;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 52
    .restart local v0    # "abstractXuaAsset":Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;
    :cond_0
    :goto_0
    return-object v0

    .line 28
    :cond_1
    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->getRecordingId()Ljava/lang/String;

    move-result-object v4

    if-eqz v4, :cond_2

    .line 29
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/assets/RecordingAsset;

    .end local v0    # "abstractXuaAsset":Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;
    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->getRecordingId()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v0, v4}, Lcom/comcast/playerplatform/analytics/java/xua/assets/RecordingAsset;-><init>(Ljava/lang/String;)V

    .restart local v0    # "abstractXuaAsset":Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;
    goto :goto_0

    .line 30
    :cond_2
    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->getStreamId()Ljava/lang/String;

    move-result-object v4

    if-eqz v4, :cond_3

    .line 31
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/assets/StreamingAsset;

    .end local v0    # "abstractXuaAsset":Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;
    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->getStreamId()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v0, v4}, Lcom/comcast/playerplatform/analytics/java/xua/assets/StreamingAsset;-><init>(Ljava/lang/String;)V

    .restart local v0    # "abstractXuaAsset":Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;
    goto :goto_0

    .line 32
    :cond_3
    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->getMediaId()Ljava/lang/String;

    move-result-object v4

    if-eqz v4, :cond_4

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->gettId()Ljava/lang/String;

    move-result-object v4

    if-eqz v4, :cond_4

    .line 33
    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    .line 34
    .local v2, "ids":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v4, "TP_ID"

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->gettId()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v2, v4, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 35
    const-string v4, "MEDIA_ID"

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->getMediaId()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v2, v4, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 36
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/assets/GenericAsset;

    .end local v0    # "abstractXuaAsset":Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;
    const-string v4, "VOD"

    const-string v5, "CIM"

    invoke-direct {v0, v4, v5, v2}, Lcom/comcast/playerplatform/analytics/java/xua/assets/GenericAsset;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V

    .line 37
    .restart local v0    # "abstractXuaAsset":Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;
    goto :goto_0

    .end local v2    # "ids":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_4
    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->getNamespace()Ljava/lang/String;

    move-result-object v4

    if-eqz v4, :cond_5

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->getChannel()Ljava/lang/String;

    move-result-object v4

    if-eqz v4, :cond_5

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->getEpisode()Ljava/lang/String;

    move-result-object v4

    if-eqz v4, :cond_5

    .line 38
    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    .line 39
    .restart local v2    # "ids":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v4, "PROGRAM"

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->getProgram()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v2, v4, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 40
    const-string v4, "EPISODE"

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->getEpisode()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v2, v4, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 41
    const-string v4, "CHANNEL"

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->getChannel()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v2, v4, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 42
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/assets/GenericAsset;

    .end local v0    # "abstractXuaAsset":Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;
    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->getStreamType()Lcom/comcast/playerplatform/primetime/android/enums/StreamType;

    move-result-object v4

    invoke-virtual {v4}, Lcom/comcast/playerplatform/primetime/android/enums/StreamType;->name()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->getNamespace()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v0, v4, v5, v2}, Lcom/comcast/playerplatform/analytics/java/xua/assets/GenericAsset;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V

    .line 43
    .restart local v0    # "abstractXuaAsset":Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;
    goto/16 :goto_0

    .line 44
    .end local v2    # "ids":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_5
    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->getNamespace()Ljava/lang/String;

    move-result-object v3

    .line 45
    .local v3, "namepace":Ljava/lang/String;
    invoke-static {v3}, Lcom/comcast/playerplatform/util/android/StringUtil;->isNotNullOrEmpty(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_6

    .line 46
    const-string v3, "Unknown"

    .line 48
    :cond_6
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/assets/GenericAsset;

    .end local v0    # "abstractXuaAsset":Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;
    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->getStreamType()Lcom/comcast/playerplatform/primetime/android/enums/StreamType;

    move-result-object v4

    invoke-virtual {v4}, Lcom/comcast/playerplatform/primetime/android/enums/StreamType;->name()Ljava/lang/String;

    move-result-object v4

    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsAssetUtil;->getIdMap(Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;)Ljava/util/Map;

    move-result-object v5

    invoke-direct {v0, v4, v3, v5}, Lcom/comcast/playerplatform/analytics/java/xua/assets/GenericAsset;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V

    .restart local v0    # "abstractXuaAsset":Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;
    goto/16 :goto_0
.end method

.method private static getIdMap(Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;)Ljava/util/Map;
    .locals 3
    .param p0, "assetInfo"    # Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;",
            ")",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 56
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 58
    .local v0, "dictionary":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->getAssetId()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 59
    const-string v1, "assetId"

    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->getAssetId()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 62
    :cond_0
    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->getProviderId()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_1

    .line 63
    const-string v1, "providerId"

    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->getProviderId()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 66
    :cond_1
    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->getMediaId()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_2

    .line 67
    const-string v1, "mediaId"

    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->getMediaId()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 70
    :cond_2
    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->gettId()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_3

    .line 71
    const-string v1, "tPID"

    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->gettId()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 74
    :cond_3
    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->getRecordingId()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_4

    .line 75
    const-string v1, "recordingId"

    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->getRecordingId()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 78
    :cond_4
    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->getStreamId()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_5

    .line 79
    const-string v1, "streamId"

    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->getStreamId()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 82
    :cond_5
    return-object v0
.end method
