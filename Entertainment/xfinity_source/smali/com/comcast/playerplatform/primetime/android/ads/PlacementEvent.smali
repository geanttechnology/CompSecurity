.class public abstract Lcom/comcast/playerplatform/primetime/android/ads/PlacementEvent;
.super Ljava/lang/Object;
.source "PlacementEvent.java"


# static fields
.field private static sessionUUID:Ljava/lang/String;


# instance fields
.field private psn:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getSessionUUID()Ljava/lang/String;
    .locals 1

    .prologue
    .line 75
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/ads/PlacementEvent;->sessionUUID:Ljava/lang/String;

    return-object v0
.end method

.method public static refreshSessionUUID()Ljava/lang/String;
    .locals 1

    .prologue
    .line 70
    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/ads/PlacementEvent;->sessionUUID:Ljava/lang/String;

    .line 71
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/ads/PlacementEvent;->sessionUUID:Ljava/lang/String;

    return-object v0
.end method


# virtual methods
.method public buildEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 8
    .param p1, "trackingId"    # Ljava/lang/String;
    .param p2, "deviceId"    # Ljava/lang/String;
    .param p3, "identityADS"    # Ljava/lang/String;
    .param p4, "messageId"    # Ljava/lang/String;
    .param p5, "assetId"    # Ljava/lang/String;
    .param p6, "providerId"    # Ljava/lang/String;
    .param p7, "timestamp"    # Ljava/lang/String;

    .prologue
    const/4 v7, 0x2

    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 16
    invoke-static {p3}, Lcom/comcast/playerplatform/util/android/StringUtil;->isNotNullOrEmpty(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 17
    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p3

    .line 20
    :cond_0
    invoke-static {p4}, Lcom/comcast/playerplatform/util/android/StringUtil;->isNotNullOrEmpty(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 21
    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p4

    .line 26
    :cond_1
    const-string v0, "86CF2E98-AEBA-4C3A-A3D4-616CF7D74A79"

    .line 28
    .local v0, "identity":Ljava/lang/String;
    new-instance v1, Ljava/lang/StringBuffer;

    invoke-direct {v1}, Ljava/lang/StringBuffer;-><init>()V

    .line 30
    .local v1, "stringBuffer":Ljava/lang/StringBuffer;
    const-string v2, "<PlacementStatusNotification identity=\"%s\" version=\"1.1\" messageId=\"%s\" system=\"IP_Player\" xmlns=\"http://www.scte.org/schemas/130-3/2008a/adm\" xmlns:core=\"http://www.scte.org/schemas/130-2/2008a/core\">"

    new-array v3, v7, [Ljava/lang/Object;

    aput-object v0, v3, v5

    aput-object p4, v3, v6

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 36
    const-string v2, "<PlayData >"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 37
    const-string v2, "<SystemContext>"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 38
    const-string v2, "<Session>%s</Session>"

    new-array v3, v6, [Ljava/lang/Object;

    sget-object v4, Lcom/comcast/playerplatform/primetime/android/ads/PlacementEvent;->sessionUUID:Ljava/lang/String;

    aput-object v4, v3, v5

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 40
    const-string v2, "</SystemContext>"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 41
    const-string v2, "<Client>"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 42
    const-string v2, "<TerminalAddress type=\"DEVICEID\">%s</TerminalAddress>"

    new-array v3, v6, [Ljava/lang/Object;

    aput-object p2, v3, v5

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 43
    const-string v2, "</Client>"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 45
    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/ads/PlacementEvent;->isEndAll()Ljava/lang/Boolean;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-nez v2, :cond_3

    .line 46
    const-string v2, "<SpotScopedEvents>"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 47
    const-string v2, "<Spot>"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 48
    const-string v2, "<core:Content>"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 49
    invoke-static {p5}, Lcom/comcast/playerplatform/util/android/StringUtil;->isNotNullOrEmpty(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_2

    invoke-static {p6}, Lcom/comcast/playerplatform/util/android/StringUtil;->isNotNullOrEmpty(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 50
    const-string v2, "<core:AssetRef assetID=\"%s\" providerID=\"%s\"/>"

    new-array v3, v7, [Ljava/lang/Object;

    aput-object p5, v3, v5

    aput-object p6, v3, v6

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 52
    :cond_2
    const-string v2, "<core:Tracking>%s</core:Tracking>"

    new-array v3, v6, [Ljava/lang/Object;

    aput-object p1, v3, v5

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 53
    const-string v2, "</core:Content>"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 54
    const-string v2, "</Spot>"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 56
    :cond_3
    const-string v2, "<Events>"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 57
    invoke-virtual {p0, v1, p7}, Lcom/comcast/playerplatform/primetime/android/ads/PlacementEvent;->getEventData(Ljava/lang/StringBuffer;Ljava/lang/String;)V

    .line 58
    const-string v2, "</Events>"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 60
    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/ads/PlacementEvent;->isEndAll()Ljava/lang/Boolean;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-nez v2, :cond_4

    .line 61
    const-string v2, "</SpotScopedEvents>"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 63
    :cond_4
    const-string v2, "</PlayData>"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 64
    const-string v2, "</PlacementStatusNotification>"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 66
    invoke-virtual {v1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/PlacementEvent;->psn:Ljava/lang/String;

    .line 67
    return-void
.end method

.method public abstract getEventData(Ljava/lang/StringBuffer;Ljava/lang/String;)V
.end method

.method public getPsn()Ljava/lang/String;
    .locals 1

    .prologue
    .line 78
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/PlacementEvent;->psn:Ljava/lang/String;

    return-object v0
.end method

.method public abstract isEndAll()Ljava/lang/Boolean;
.end method
