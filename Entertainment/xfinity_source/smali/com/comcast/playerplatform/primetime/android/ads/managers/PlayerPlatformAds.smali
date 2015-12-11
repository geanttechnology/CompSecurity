.class public Lcom/comcast/playerplatform/primetime/android/ads/managers/PlayerPlatformAds;
.super Ljava/lang/Object;
.source "PlayerPlatformAds.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/playerplatform/primetime/android/ads/managers/PlayerPlatformAds$1;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 23
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 41
    return-void
.end method

.method public static getAdManager(Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;Lcom/comcast/playerplatform/primetime/android/asset/Asset;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;Landroid/app/Activity;Landroid/content/Context;)Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;
    .locals 6
    .param p0, "playerSettings"    # Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;
    .param p1, "asset"    # Lcom/comcast/playerplatform/primetime/android/asset/Asset;
    .param p2, "httpClient"    # Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;
    .param p3, "activity"    # Landroid/app/Activity;
    .param p4, "applicationContext"    # Landroid/content/Context;

    .prologue
    const/4 v3, 0x0

    .line 26
    const/4 v2, 0x0

    .line 27
    .local v2, "type":Lcom/comcast/playerplatform/primetime/android/enums/AdType;
    :try_start_0
    invoke-virtual {p1}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->getAdData()Lcom/comcast/playerplatform/primetime/android/asset/AdData;

    move-result-object v0

    .line 29
    .local v0, "adData":Lcom/comcast/playerplatform/primetime/android/asset/AdData;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/asset/AdData;->getAdType()Lcom/comcast/playerplatform/primetime/android/enums/AdType;

    move-result-object v2

    .line 31
    :goto_0
    sget-object v4, Lcom/comcast/playerplatform/primetime/android/ads/managers/PlayerPlatformAds$1;->$SwitchMap$com$comcast$playerplatform$primetime$android$enums$AdType:[I

    invoke-virtual {v2}, Lcom/comcast/playerplatform/primetime/android/enums/AdType;->ordinal()I

    move-result v5

    aget v4, v4, v5

    packed-switch v4, :pswitch_data_0

    .line 45
    .end local v0    # "adData":Lcom/comcast/playerplatform/primetime/android/asset/AdData;
    :goto_1
    return-object v3

    .line 29
    .restart local v0    # "adData":Lcom/comcast/playerplatform/primetime/android/asset/AdData;
    :cond_0
    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->getAdType()Lcom/comcast/playerplatform/primetime/android/enums/AdType;

    move-result-object v2

    goto :goto_0

    .line 33
    :pswitch_0
    invoke-static {p1, p4, p0, v0}, Lcom/comcast/playerplatform/primetime/android/ads/managers/PlayerPlatformAds;->getAuditudeAdManager(Lcom/comcast/playerplatform/primetime/android/asset/Asset;Landroid/content/Context;Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;Lcom/comcast/playerplatform/primetime/android/asset/AdData;)Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    move-result-object v3

    goto :goto_1

    .line 35
    :pswitch_1
    invoke-virtual {p1}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->getMoneyTrace()Lcom/comcast/playerplatform/util/android/MoneyTrace;

    move-result-object v4

    invoke-static {p0, p2, v4}, Lcom/comcast/playerplatform/primetime/android/ads/managers/PlayerPlatformAds;->getManafestManipulatorManager(Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;Lcom/comcast/playerplatform/util/android/MoneyTrace;)Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    move-result-object v3

    goto :goto_1

    .line 37
    :pswitch_2
    invoke-static {p0, v0}, Lcom/comcast/playerplatform/primetime/android/ads/managers/PlayerPlatformAds;->getC3Manager(Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;Lcom/comcast/playerplatform/primetime/android/asset/AdData;)Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    move-result-object v3

    goto :goto_1

    .line 39
    :pswitch_3
    invoke-static {p3}, Lcom/comcast/playerplatform/primetime/android/ads/managers/PlayerPlatformAds;->getFreeWheelManager(Landroid/app/Activity;)Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v3

    goto :goto_1

    .line 43
    .end local v0    # "adData":Lcom/comcast/playerplatform/primetime/android/asset/AdData;
    :catch_0
    move-exception v1

    .line 45
    .local v1, "ex":Ljava/lang/Exception;
    goto :goto_1

    .line 31
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method private static getAuditudeAdManager(Lcom/comcast/playerplatform/primetime/android/asset/Asset;Landroid/content/Context;Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;Lcom/comcast/playerplatform/primetime/android/asset/AdData;)Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;
    .locals 6
    .param p0, "asset"    # Lcom/comcast/playerplatform/primetime/android/asset/Asset;
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "playerSettings"    # Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;
    .param p3, "adData"    # Lcom/comcast/playerplatform/primetime/android/asset/AdData;

    .prologue
    .line 61
    new-instance v1, Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;

    invoke-direct {v1, p1}, Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;-><init>(Landroid/content/Context;)V

    .line 62
    .local v1, "configurationHelper":Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;
    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;->getAuditudeZone()Ljava/lang/String;

    move-result-object v4

    .line 63
    .local v4, "zoneId":Ljava/lang/String;
    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;->getAuditudeDomain()Ljava/lang/String;

    move-result-object v2

    .line 64
    .local v2, "domain":Ljava/lang/String;
    invoke-static {p2, p3, v1}, Lcom/comcast/playerplatform/primetime/android/ads/managers/PlayerPlatformAds;->getAuditudeParameters(Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;Lcom/comcast/playerplatform/primetime/android/asset/AdData;Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;)Lcom/adobe/mediacore/metadata/Metadata;

    move-result-object v0

    .line 65
    .local v0, "adParams":Lcom/adobe/mediacore/metadata/Metadata;
    const-string v3, ""

    .line 66
    .local v3, "mediaId":Ljava/lang/String;
    if-eqz p3, :cond_1

    invoke-virtual {p3}, Lcom/comcast/playerplatform/primetime/android/asset/AdData;->getMediaId()Ljava/lang/String;

    move-result-object v5

    if-eqz v5, :cond_1

    .line 67
    invoke-virtual {p3}, Lcom/comcast/playerplatform/primetime/android/asset/AdData;->getMediaId()Ljava/lang/String;

    move-result-object v3

    .line 72
    :cond_0
    :goto_0
    new-instance v5, Lcom/comcast/playerplatform/primetime/android/ads/managers/AuditudeAdManager;

    invoke-direct {v5, v4, v2, v0, v3}, Lcom/comcast/playerplatform/primetime/android/ads/managers/AuditudeAdManager;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/adobe/mediacore/metadata/Metadata;Ljava/lang/String;)V

    return-object v5

    .line 68
    :cond_1
    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->getAssetInfo()Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;

    move-result-object v5

    if-eqz v5, :cond_0

    .line 69
    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->getAssetInfo()Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;

    move-result-object v5

    invoke-virtual {v5}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->getMediaId()Ljava/lang/String;

    move-result-object v3

    goto :goto_0
.end method

.method private static getAuditudeParameters(Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;Lcom/comcast/playerplatform/primetime/android/asset/AdData;Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;)Lcom/adobe/mediacore/metadata/Metadata;
    .locals 5
    .param p0, "playerSettings"    # Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;
    .param p1, "adData"    # Lcom/comcast/playerplatform/primetime/android/asset/AdData;
    .param p2, "configurationHelper"    # Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;

    .prologue
    .line 76
    invoke-virtual {p2}, Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;->getAuditudeParameters()Lcom/adobe/mediacore/metadata/Metadata;

    move-result-object v0

    .line 77
    .local v0, "adParams":Lcom/adobe/mediacore/metadata/Metadata;
    const/4 v3, 0x0

    .line 78
    .local v3, "targetingParameters":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    if-eqz p1, :cond_1

    .line 79
    invoke-virtual {p1}, Lcom/comcast/playerplatform/primetime/android/asset/AdData;->getTargetingParameters()Ljava/util/Map;

    move-result-object v3

    .line 85
    :goto_0
    if-eqz v3, :cond_2

    .line 86
    if-nez v0, :cond_0

    .line 87
    new-instance v0, Lcom/adobe/mediacore/metadata/MetadataNode;

    .end local v0    # "adParams":Lcom/adobe/mediacore/metadata/Metadata;
    invoke-direct {v0}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    .line 90
    .restart local v0    # "adParams":Lcom/adobe/mediacore/metadata/Metadata;
    :cond_0
    invoke-interface {v3}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 91
    .local v2, "key":Ljava/lang/String;
    invoke-interface {v3, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-interface {v0, v2, v4}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 82
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v2    # "key":Ljava/lang/String;
    :cond_1
    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->getTargetingParameters()Ljava/util/Map;

    move-result-object v3

    goto :goto_0

    .line 94
    :cond_2
    return-object v0
.end method

.method private static getC3Manager(Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;Lcom/comcast/playerplatform/primetime/android/asset/AdData;)Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;
    .locals 2
    .param p0, "playerSettings"    # Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;
    .param p1, "adData"    # Lcom/comcast/playerplatform/primetime/android/asset/AdData;

    .prologue
    .line 54
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Lcom/comcast/playerplatform/primetime/android/asset/AdData;->getAdBreaks()Ljava/util/List;

    move-result-object v1

    .line 55
    .local v1, "ads":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;>;"
    :goto_0
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/ads/managers/C3Manager;

    invoke-direct {v0, v1}, Lcom/comcast/playerplatform/primetime/android/ads/managers/C3Manager;-><init>(Ljava/util/List;)V

    .line 56
    .local v0, "adManager":Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;
    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->setAdList(Ljava/util/List;)V

    .line 57
    return-object v0

    .line 54
    .end local v0    # "adManager":Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;
    .end local v1    # "ads":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;>;"
    :cond_0
    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->getC3Ads()Ljava/util/List;

    move-result-object v1

    goto :goto_0
.end method

.method private static getFreeWheelManager(Landroid/app/Activity;)Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;
    .locals 1
    .param p0, "activity"    # Landroid/app/Activity;

    .prologue
    .line 50
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;

    invoke-direct {v0, p0}, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;-><init>(Landroid/app/Activity;)V

    return-object v0
.end method

.method private static getManafestManipulatorManager(Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;Lcom/comcast/playerplatform/util/android/MoneyTrace;)Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;
    .locals 2
    .param p0, "playerSettings"    # Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;
    .param p1, "httpClient"    # Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;
    .param p2, "moneyTrace"    # Lcom/comcast/playerplatform/util/android/MoneyTrace;

    .prologue
    .line 98
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;

    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->getDeviceId()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1, p1, p2}, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;-><init>(Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;Lcom/comcast/playerplatform/util/android/MoneyTrace;)V

    return-object v0
.end method
