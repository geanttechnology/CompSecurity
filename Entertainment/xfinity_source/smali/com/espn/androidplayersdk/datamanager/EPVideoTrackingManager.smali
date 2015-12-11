.class public Lcom/espn/androidplayersdk/datamanager/EPVideoTrackingManager;
.super Ljava/lang/Object;
.source "EPVideoTrackingManager.java"


# static fields
.field private static CUSTOMER_KEY:Ljava/lang/String;

.field private static mAffiliate:Ljava/lang/String;

.field private static mEPEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

.field private static mEPStream:Lcom/espn/androidplayersdk/datamanager/EPStream;

.field private static mPartner:Ljava/lang/String;

.field private static playerName:Ljava/lang/String;

.field private static sessionId:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 25
    const-string v0, ""

    sput-object v0, Lcom/espn/androidplayersdk/datamanager/EPVideoTrackingManager;->CUSTOMER_KEY:Ljava/lang/String;

    .line 26
    const/4 v0, -0x1

    sput v0, Lcom/espn/androidplayersdk/datamanager/EPVideoTrackingManager;->sessionId:I

    .line 27
    const-string v0, "WatchESPN-Android"

    sput-object v0, Lcom/espn/androidplayersdk/datamanager/EPVideoTrackingManager;->playerName:Ljava/lang/String;

    .line 28
    const-string v0, ""

    sput-object v0, Lcom/espn/androidplayersdk/datamanager/EPVideoTrackingManager;->mPartner:Ljava/lang/String;

    .line 29
    const-string v0, ""

    sput-object v0, Lcom/espn/androidplayersdk/datamanager/EPVideoTrackingManager;->mAffiliate:Ljava/lang/String;

    .line 31
    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 23
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static attachMediaPlayer(Ljava/lang/Object;)V
    .locals 1
    .param p0, "mediaPlayer"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 183
    sget v0, Lcom/espn/androidplayersdk/datamanager/EPVideoTrackingManager;->sessionId:I

    invoke-static {v0, p0}, Lcom/conviva/LivePass;->attachStreamer(ILjava/lang/Object;)V

    .line 184
    return-void
.end method

.method public static cleanUpSesstion()V
    .locals 1

    .prologue
    .line 204
    sget v0, Lcom/espn/androidplayersdk/datamanager/EPVideoTrackingManager;->sessionId:I

    invoke-static {v0}, Lcom/conviva/LivePass;->cleanupSession(I)V

    .line 205
    return-void
.end method

.method public static creatMonitoringSession(Ljava/lang/Object;Ljava/lang/String;)V
    .locals 6
    .param p0, "mediaPlayer"    # Ljava/lang/Object;
    .param p1, "playerVersion"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 106
    sget-object v4, Lcom/espn/androidplayersdk/datamanager/EPVideoTrackingManager;->mEPEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    if-eqz v4, :cond_0

    sget-object v4, Lcom/espn/androidplayersdk/datamanager/EPVideoTrackingManager;->mEPStream:Lcom/espn/androidplayersdk/datamanager/EPStream;

    if-nez v4, :cond_1

    .line 107
    :cond_0
    new-instance v4, Ljava/lang/RuntimeException;

    const-string v5, "No Video asset found"

    invoke-direct {v4, v5}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 110
    :cond_1
    :try_start_0
    new-instance v3, Ljava/util/HashMap;

    invoke-direct {v3}, Ljava/util/HashMap;-><init>()V

    .line 111
    .local v3, "tags":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    sget-object v4, Lcom/espn/androidplayersdk/datamanager/EPVideoTrackingManager;->mAffiliate:Ljava/lang/String;

    invoke-virtual {v4}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->isEmpty()Z

    move-result v4

    if-nez v4, :cond_2

    .line 112
    const-string v4, "affiliate"

    sget-object v5, Lcom/espn/androidplayersdk/datamanager/EPVideoTrackingManager;->mAffiliate:Ljava/lang/String;

    invoke-interface {v3, v4, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 114
    :cond_2
    sget-object v4, Lcom/espn/androidplayersdk/datamanager/EPVideoTrackingManager;->mEPEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    invoke-virtual {v4}, Lcom/espn/androidplayersdk/datamanager/EPEvents;->getEventId()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_3

    .line 115
    const-string v4, "eventId"

    sget-object v5, Lcom/espn/androidplayersdk/datamanager/EPVideoTrackingManager;->mEPEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    invoke-virtual {v5}, Lcom/espn/androidplayersdk/datamanager/EPEvents;->getEventId()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v3, v4, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 117
    :cond_3
    sget-object v4, Lcom/espn/androidplayersdk/datamanager/EPVideoTrackingManager;->mEPEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    invoke-virtual {v4}, Lcom/espn/androidplayersdk/datamanager/EPEvents;->getEventName()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_4

    .line 118
    const-string v4, "eventName"

    sget-object v5, Lcom/espn/androidplayersdk/datamanager/EPVideoTrackingManager;->mEPEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    invoke-virtual {v5}, Lcom/espn/androidplayersdk/datamanager/EPEvents;->getEventName()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v3, v4, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 120
    :cond_4
    sget-object v4, Lcom/espn/androidplayersdk/datamanager/EPVideoTrackingManager;->mEPEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    invoke-virtual {v4}, Lcom/espn/androidplayersdk/datamanager/EPEvents;->getType()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_5

    .line 121
    const-string v4, "eventType"

    sget-object v5, Lcom/espn/androidplayersdk/datamanager/EPVideoTrackingManager;->mEPEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    invoke-virtual {v5}, Lcom/espn/androidplayersdk/datamanager/EPEvents;->getType()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v3, v4, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 123
    :cond_5
    sget-object v4, Lcom/espn/androidplayersdk/datamanager/EPVideoTrackingManager;->mEPEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    invoke-virtual {v4}, Lcom/espn/androidplayersdk/datamanager/EPEvents;->getLeagueName()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_6

    .line 124
    const-string v4, "league"

    sget-object v5, Lcom/espn/androidplayersdk/datamanager/EPVideoTrackingManager;->mEPEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    invoke-virtual {v5}, Lcom/espn/androidplayersdk/datamanager/EPEvents;->getLeagueName()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v3, v4, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 126
    :cond_6
    sget-object v4, Lcom/espn/androidplayersdk/datamanager/EPVideoTrackingManager;->mEPEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    invoke-virtual {v4}, Lcom/espn/androidplayersdk/datamanager/EPEvents;->getNetworkId()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_7

    .line 127
    const-string v4, "network"

    sget-object v5, Lcom/espn/androidplayersdk/datamanager/EPVideoTrackingManager;->mEPEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    invoke-virtual {v5}, Lcom/espn/androidplayersdk/datamanager/EPEvents;->getNetworkId()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v3, v4, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 129
    :cond_7
    sget-object v4, Lcom/espn/androidplayersdk/datamanager/EPVideoTrackingManager;->mEPEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    invoke-virtual {v4}, Lcom/espn/androidplayersdk/datamanager/EPEvents;->getSport()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_8

    .line 130
    const-string v4, "sport"

    sget-object v5, Lcom/espn/androidplayersdk/datamanager/EPVideoTrackingManager;->mEPEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    invoke-virtual {v5}, Lcom/espn/androidplayersdk/datamanager/EPEvents;->getSport()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v3, v4, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 132
    :cond_8
    sget-object v4, Lcom/espn/androidplayersdk/datamanager/EPVideoTrackingManager;->mPartner:Ljava/lang/String;

    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_9

    .line 133
    const-string v4, "partner"

    sget-object v5, Lcom/espn/androidplayersdk/datamanager/EPVideoTrackingManager;->mPartner:Ljava/lang/String;

    invoke-interface {v3, v4, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 135
    :cond_9
    const-string v4, "streamType"

    const-string v5, "hls"

    invoke-interface {v3, v4, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 136
    const-string v4, "connectionType"

    invoke-static {}, Lcom/espn/androidplayersdk/utilities/Utils;->getConnectionType()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v3, v4, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 137
    if-eqz p1, :cond_a

    .line 138
    const-string v4, "playerVersion"

    invoke-interface {v3, v4, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 142
    :cond_a
    const-string v0, ""

    .line 143
    .local v0, "assetName":Ljava/lang/String;
    sget-object v4, Lcom/espn/androidplayersdk/datamanager/EPVideoTrackingManager;->mEPEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    invoke-virtual {v4}, Lcom/espn/androidplayersdk/datamanager/EPEvents;->getLeagueName()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_b

    .line 144
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v5, Lcom/espn/androidplayersdk/datamanager/EPVideoTrackingManager;->mEPEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    invoke-virtual {v5}, Lcom/espn/androidplayersdk/datamanager/EPEvents;->getLeagueName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " : "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 145
    :cond_b
    sget-object v4, Lcom/espn/androidplayersdk/datamanager/EPVideoTrackingManager;->mEPEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    invoke-virtual {v4}, Lcom/espn/androidplayersdk/datamanager/EPEvents;->getShowName()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_c

    .line 146
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v5, Lcom/espn/androidplayersdk/datamanager/EPVideoTrackingManager;->mEPEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    invoke-virtual {v5}, Lcom/espn/androidplayersdk/datamanager/EPEvents;->getShowName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " - "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 147
    :cond_c
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v5, Lcom/espn/androidplayersdk/datamanager/EPVideoTrackingManager;->mEPEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    invoke-virtual {v5}, Lcom/espn/androidplayersdk/datamanager/EPEvents;->getEventId()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 149
    const/4 v4, 0x2

    const/4 v5, 0x0

    invoke-static {v0, v4, v5}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 151
    new-instance v1, Lcom/conviva/ConvivaContentInfo;

    invoke-direct {v1, v0, v3}, Lcom/conviva/ConvivaContentInfo;-><init>(Ljava/lang/String;Ljava/util/Map;)V

    .line 153
    .local v1, "convivaMetaData":Lcom/conviva/ConvivaContentInfo;
    const-string v4, "AKAMAI"

    sget-object v5, Lcom/espn/androidplayersdk/datamanager/EPVideoTrackingManager;->mEPStream:Lcom/espn/androidplayersdk/datamanager/EPStream;

    invoke-virtual {v5}, Lcom/espn/androidplayersdk/datamanager/EPStream;->getCdn()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_d

    .line 154
    const-string v4, "AKAMAI"

    iput-object v4, v1, Lcom/conviva/ConvivaContentInfo;->defaultReportingCdnName:Ljava/lang/String;

    .line 157
    :goto_0
    sget-object v4, Lcom/espn/androidplayersdk/datamanager/EPVideoTrackingManager;->mEPStream:Lcom/espn/androidplayersdk/datamanager/EPStream;

    invoke-virtual {v4}, Lcom/espn/androidplayersdk/datamanager/EPStream;->getCdnResource()Ljava/lang/String;

    move-result-object v4

    iput-object v4, v1, Lcom/conviva/ConvivaContentInfo;->defaultReportingResource:Ljava/lang/String;

    .line 158
    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getUUID()Ljava/lang/String;

    move-result-object v4

    iput-object v4, v1, Lcom/conviva/ConvivaContentInfo;->viewerId:Ljava/lang/String;

    .line 159
    sget-object v4, Lcom/espn/androidplayersdk/datamanager/EPVideoTrackingManager;->mEPStream:Lcom/espn/androidplayersdk/datamanager/EPStream;

    invoke-virtual {v4}, Lcom/espn/androidplayersdk/datamanager/EPStream;->getPlaybackUrl()Ljava/lang/String;

    move-result-object v4

    iput-object v4, v1, Lcom/conviva/ConvivaContentInfo;->streamUrl:Ljava/lang/String;

    .line 160
    sget-object v4, Lcom/espn/androidplayersdk/datamanager/EPVideoTrackingManager;->playerName:Ljava/lang/String;

    iput-object v4, v1, Lcom/conviva/ConvivaContentInfo;->playerName:Ljava/lang/String;

    .line 161
    const-string v4, "live"

    sget-object v5, Lcom/espn/androidplayersdk/datamanager/EPVideoTrackingManager;->mEPEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    invoke-virtual {v5}, Lcom/espn/androidplayersdk/datamanager/EPEvents;->getType()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_e

    .line 162
    const/4 v4, 0x1

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    iput-object v4, v1, Lcom/conviva/ConvivaContentInfo;->isLive:Ljava/lang/Boolean;

    .line 166
    :goto_1
    invoke-static {p0, v1}, Lcom/conviva/LivePass;->createSession(Ljava/lang/Object;Lcom/conviva/ConvivaContentInfo;)I

    move-result v4

    sput v4, Lcom/espn/androidplayersdk/datamanager/EPVideoTrackingManager;->sessionId:I

    .line 171
    return-void

    .line 156
    :cond_d
    const-string v4, "LEVEL3"

    iput-object v4, v1, Lcom/conviva/ConvivaContentInfo;->defaultReportingCdnName:Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 167
    .end local v0    # "assetName":Ljava/lang/String;
    .end local v1    # "convivaMetaData":Lcom/conviva/ConvivaContentInfo;
    .end local v3    # "tags":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    :catch_0
    move-exception v2

    .line 168
    .local v2, "e":Ljava/lang/Exception;
    const-string v4, "Conviva error:"

    const/4 v5, 0x5

    invoke-static {v4, v5, v2}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 169
    new-instance v4, Ljava/lang/RuntimeException;

    const-string v5, "Unable to create session for tracking"

    invoke-direct {v4, v5}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 164
    .end local v2    # "e":Ljava/lang/Exception;
    .restart local v0    # "assetName":Ljava/lang/String;
    .restart local v1    # "convivaMetaData":Lcom/conviva/ConvivaContentInfo;
    .restart local v3    # "tags":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_e
    const/4 v4, 0x0

    :try_start_1
    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    iput-object v4, v1, Lcom/conviva/ConvivaContentInfo;->isLive:Ljava/lang/Boolean;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_1
.end method

.method public static getSessionID()I
    .locals 1

    .prologue
    .line 221
    sget v0, Lcom/espn/androidplayersdk/datamanager/EPVideoTrackingManager;->sessionId:I

    return v0
.end method

.method public static init()V
    .locals 3

    .prologue
    .line 40
    :try_start_0
    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getApiConfigConvivaCustomerKey()Ljava/lang/String;

    move-result-object v1

    sput-object v1, Lcom/espn/androidplayersdk/datamanager/EPVideoTrackingManager;->CUSTOMER_KEY:Ljava/lang/String;

    .line 41
    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getApiConfigConvivPlayerName()Ljava/lang/String;

    move-result-object v1

    sput-object v1, Lcom/espn/androidplayersdk/datamanager/EPVideoTrackingManager;->playerName:Ljava/lang/String;

    .line 42
    sget-object v1, Lcom/espn/androidplayersdk/datamanager/EPVideoTrackingManager;->CUSTOMER_KEY:Ljava/lang/String;

    sget-object v2, Lcom/espn/androidplayersdk/datamanager/ESPNPlayerSdk;->mCtx:Landroid/content/Context;

    invoke-static {v1, v2}, Lcom/conviva/LivePass;->init(Ljava/lang/String;Landroid/content/Context;)V

    .line 43
    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getApiPartnerName()Ljava/lang/String;

    move-result-object v1

    sput-object v1, Lcom/espn/androidplayersdk/datamanager/EPVideoTrackingManager;->mPartner:Ljava/lang/String;

    .line 44
    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getApiPartnerName()Ljava/lang/String;

    move-result-object v1

    sput-object v1, Lcom/espn/androidplayersdk/datamanager/EPVideoTrackingManager;->mAffiliate:Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 48
    .local v0, "e":Ljava/lang/Exception;
    :goto_0
    return-void

    .line 45
    .end local v0    # "e":Ljava/lang/Exception;
    :catch_0
    move-exception v0

    .line 46
    .restart local v0    # "e":Ljava/lang/Exception;
    const-string v1, " Unable to init conviva"

    const/4 v2, 0x5

    invoke-static {v1, v2, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method public static pauseSessionMonitor()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 216
    sget v0, Lcom/espn/androidplayersdk/datamanager/EPVideoTrackingManager;->sessionId:I

    invoke-static {v0}, Lcom/conviva/LivePass;->pauseMonitor(I)V

    .line 217
    return-void
.end method

.method public static reportError(Ljava/lang/String;)V
    .locals 2
    .param p0, "errorString"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 193
    sget v0, Lcom/espn/androidplayersdk/datamanager/EPVideoTrackingManager;->sessionId:I

    const/4 v1, -0x1

    if-ne v0, v1, :cond_0

    .line 194
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "Create Monitoring session before reporting errors "

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 195
    :cond_0
    sget v0, Lcom/espn/androidplayersdk/datamanager/EPVideoTrackingManager;->sessionId:I

    const/4 v1, 0x1

    invoke-static {v0, p0, v1}, Lcom/conviva/LivePass;->reportError(ILjava/lang/String;I)V

    .line 196
    return-void
.end method

.method public static resetSessionID()V
    .locals 1

    .prologue
    .line 268
    const/4 v0, -0x1

    sput v0, Lcom/espn/androidplayersdk/datamanager/EPVideoTrackingManager;->sessionId:I

    .line 269
    return-void
.end method

.method public static setAffiliate(Ljava/lang/String;)V
    .locals 0
    .param p0, "affiliate"    # Ljava/lang/String;

    .prologue
    .line 59
    sput-object p0, Lcom/espn/androidplayersdk/datamanager/EPVideoTrackingManager;->mAffiliate:Ljava/lang/String;

    .line 60
    return-void
.end method

.method protected static setEventObj(Lcom/espn/androidplayersdk/datamanager/EPEvents;)V
    .locals 0
    .param p0, "epEvents"    # Lcom/espn/androidplayersdk/datamanager/EPEvents;

    .prologue
    .line 64
    sput-object p0, Lcom/espn/androidplayersdk/datamanager/EPVideoTrackingManager;->mEPEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    .line 65
    return-void
.end method

.method protected static setStreamObj(Lcom/espn/androidplayersdk/datamanager/EPStream;)V
    .locals 0
    .param p0, "epStream"    # Lcom/espn/androidplayersdk/datamanager/EPStream;

    .prologue
    .line 69
    sput-object p0, Lcom/espn/androidplayersdk/datamanager/EPVideoTrackingManager;->mEPStream:Lcom/espn/androidplayersdk/datamanager/EPStream;

    .line 70
    return-void
.end method
