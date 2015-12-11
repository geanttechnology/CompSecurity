.class public Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent;
.super Lcom/comcast/playerplatform/primetime/android/ads/PlacementEvent;
.source "PlacementStatusEvent.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$1;,
        Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;
    }
.end annotation


# instance fields
.field private spotNPT:Ljava/lang/String;

.field private type:Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;


# direct methods
.method public constructor <init>(Ljava/lang/String;FLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;)V
    .locals 10
    .param p1, "trackingId"    # Ljava/lang/String;
    .param p2, "spotNPT"    # F
    .param p3, "deviceId"    # Ljava/lang/String;
    .param p4, "identityADS"    # Ljava/lang/String;
    .param p5, "messageId"    # Ljava/lang/String;
    .param p6, "assetId"    # Ljava/lang/String;
    .param p7, "providerId"    # Ljava/lang/String;
    .param p8, "timestamp"    # Ljava/lang/String;
    .param p9, "type"    # Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;

    .prologue
    .line 12
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/ads/PlacementEvent;-><init>()V

    .line 13
    move-object/from16 v0, p9

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent;->type:Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;

    .line 14
    const/high16 v1, 0x3f800000    # 1.0f

    cmpg-float v1, p2, v1

    if-gez v1, :cond_0

    const/4 v9, 0x0

    .line 15
    .local v9, "percisionFloat":F
    :goto_0
    const-string v1, "%.3f"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-static {v9}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent;->spotNPT:Ljava/lang/String;

    move-object v1, p0

    move-object v2, p1

    move-object v3, p3

    move-object v4, p4

    move-object v5, p5

    move-object/from16 v6, p6

    move-object/from16 v7, p7

    move-object/from16 v8, p8

    .line 16
    invoke-virtual/range {v1 .. v8}, Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent;->buildEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 17
    return-void

    .line 14
    .end local v9    # "percisionFloat":F
    :cond_0
    const/high16 v1, 0x447a0000    # 1000.0f

    div-float v9, p2, v1

    goto :goto_0
.end method

.method private getPSNTypeString(Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;)Ljava/lang/String;
    .locals 3
    .param p1, "type"    # Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;

    .prologue
    .line 45
    const-string v0, ""

    .line 46
    .local v0, "psnType":Ljava/lang/String;
    sget-object v1, Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$1;->$SwitchMap$com$comcast$playerplatform$primetime$android$ads$PlacementStatusEvent$Type:[I

    invoke-virtual {p1}, Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    .line 69
    :goto_0
    return-object v0

    .line 48
    :pswitch_0
    const-string v0, "startPlacement"

    .line 49
    goto :goto_0

    .line 51
    :pswitch_1
    const-string v0, "status"

    .line 52
    goto :goto_0

    .line 54
    :pswitch_2
    const-string v0, "endPlacement"

    .line 55
    goto :goto_0

    .line 57
    :pswitch_3
    const-string v0, "endAll"

    .line 58
    goto :goto_0

    .line 60
    :pswitch_4
    const-string v0, "private:firstQuartile"

    .line 61
    goto :goto_0

    .line 63
    :pswitch_5
    const-string v0, "private:midpoint"

    .line 64
    goto :goto_0

    .line 66
    :pswitch_6
    const-string v0, "private:thirdQuartile"

    goto :goto_0

    .line 46
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
    .end packed-switch
.end method


# virtual methods
.method public getEventData(Ljava/lang/StringBuffer;Ljava/lang/String;)V
    .locals 5
    .param p1, "stringBuffer"    # Ljava/lang/StringBuffer;
    .param p2, "timestamp"    # Ljava/lang/String;

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 21
    const-string v0, "<PlacementStatusEvent time=\"%s\" type=\"%s\" >"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    aput-object p2, v1, v3

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent;->type:Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;

    invoke-direct {p0, v2}, Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent;->getPSNTypeString(Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;)Ljava/lang/String;

    move-result-object v2

    aput-object v2, v1, v4

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 23
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent;->type:Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;->END_ALL:Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;

    if-eq v0, v1, :cond_0

    .line 24
    const-string v0, "<SpotNPT scale=\"1.0\">%s</SpotNPT>"

    new-array v1, v4, [Ljava/lang/Object;

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent;->spotNPT:Ljava/lang/String;

    aput-object v2, v1, v3

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 26
    :cond_0
    const-string v0, "</PlacementStatusEvent>"

    invoke-virtual {p1, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 27
    return-void
.end method

.method public isEndAll()Ljava/lang/Boolean;
    .locals 2

    .prologue
    .line 31
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent;->type:Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent;->type:Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;->END_ALL:Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
