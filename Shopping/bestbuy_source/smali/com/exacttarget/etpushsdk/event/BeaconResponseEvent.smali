.class public Lcom/exacttarget/etpushsdk/event/BeaconResponseEvent;
.super Lcom/exacttarget/etpushsdk/event/BeaconResponse;
.source "SourceFile"

# interfaces
.implements Lcom/exacttarget/etpushsdk/event/IEventFactory;


# static fields
.field private static final TAG:Ljava/lang/String; = "~!BeaconResponseEvent"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 38
    invoke-direct {p0}, Lcom/exacttarget/etpushsdk/event/BeaconResponse;-><init>()V

    return-void
.end method


# virtual methods
.method public fromJson(Ljava/lang/String;)Lcom/exacttarget/etpushsdk/event/BeaconResponseEvent;
    .locals 10

    .prologue
    const/4 v1, 0x0

    .line 97
    :try_start_0
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0, p1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 99
    const-string v2, "beacons"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v3

    .line 100
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 102
    if-eqz v3, :cond_2

    move v2, v1

    .line 103
    :goto_0
    invoke-virtual {v3}, Lorg/json/JSONArray;->length()I

    move-result v0

    if-ge v2, v0, :cond_2

    .line 104
    invoke-virtual {v3, v2}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v0

    .line 105
    new-instance v5, Lcom/exacttarget/etpushsdk/data/Region;

    invoke-direct {v5}, Lcom/exacttarget/etpushsdk/data/Region;-><init>()V

    .line 106
    const-string v6, "id"

    invoke-virtual {v0, v6}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/exacttarget/etpushsdk/data/Region;->setId(Ljava/lang/String;)V

    .line 107
    new-instance v6, Lcom/exacttarget/etpushsdk/util/l;

    const-string v7, "center"

    invoke-virtual {v0, v7}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v7

    const-string v8, "latitude"

    invoke-virtual {v7, v8}, Lorg/json/JSONObject;->getDouble(Ljava/lang/String;)D

    move-result-wide v8

    invoke-static {v8, v9}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v7

    const-string v8, "center"

    invoke-virtual {v0, v8}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v8

    const-string v9, "longitude"

    invoke-virtual {v8, v9}, Lorg/json/JSONObject;->getDouble(Ljava/lang/String;)D

    move-result-wide v8

    invoke-static {v8, v9}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v8

    invoke-direct {v6, v7, v8}, Lcom/exacttarget/etpushsdk/util/l;-><init>(Ljava/lang/Double;Ljava/lang/Double;)V

    invoke-virtual {v5, v6}, Lcom/exacttarget/etpushsdk/data/Region;->setCenter(Lcom/exacttarget/etpushsdk/util/l;)V

    .line 108
    const-string v6, "locationType"

    invoke-virtual {v0, v6}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v6

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/exacttarget/etpushsdk/data/Region;->setLocationType(Ljava/lang/Integer;)V

    .line 109
    const-string v6, "name"

    invoke-virtual {v0, v6}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/exacttarget/etpushsdk/data/Region;->setName(Ljava/lang/String;)V

    .line 110
    const-string v6, "description"

    invoke-virtual {v0, v6}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/exacttarget/etpushsdk/data/Region;->setDescription(Ljava/lang/String;)V

    .line 111
    const-string v6, "major"

    invoke-virtual {v0, v6}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v6

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/exacttarget/etpushsdk/data/Region;->setMajor(Ljava/lang/Integer;)V

    .line 112
    const-string v6, "minor"

    invoke-virtual {v0, v6}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v6

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/exacttarget/etpushsdk/data/Region;->setMinor(Ljava/lang/Integer;)V

    .line 113
    const-string v6, "proximityUuid"

    invoke-virtual {v0, v6}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/exacttarget/etpushsdk/data/Region;->setGuid(Ljava/lang/String;)V

    .line 114
    const-string v6, "messages"

    invoke-virtual {v0, v6}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v6

    .line 115
    new-instance v7, Ljava/util/ArrayList;

    invoke-direct {v7}, Ljava/util/ArrayList;-><init>()V

    .line 117
    if-eqz v6, :cond_1

    move v0, v1

    .line 118
    :goto_1
    invoke-virtual {v6}, Lorg/json/JSONArray;->length()I

    move-result v8

    if-ge v0, v8, :cond_0

    .line 119
    invoke-virtual {v6, v0}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v8

    .line 120
    new-instance v9, Lcom/exacttarget/etpushsdk/data/Message;

    invoke-direct {v9, v8}, Lcom/exacttarget/etpushsdk/data/Message;-><init>(Lorg/json/JSONObject;)V

    .line 121
    invoke-interface {v7, v9}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 118
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 123
    :cond_0
    invoke-virtual {v5, v7}, Lcom/exacttarget/etpushsdk/data/Region;->setMessages(Ljava/util/List;)V

    .line 125
    :cond_1
    invoke-interface {v4, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 103
    add-int/lit8 v0, v2, 0x1

    move v2, v0

    goto/16 :goto_0

    .line 128
    :cond_2
    invoke-virtual {p0, v4}, Lcom/exacttarget/etpushsdk/event/BeaconResponseEvent;->setBeacons(Ljava/util/List;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 132
    :goto_2
    return-object p0

    .line 130
    :catch_0
    move-exception v0

    .line 131
    const-string v1, "~!BeaconResponseEvent"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 132
    const/4 p0, 0x0

    goto :goto_2
.end method

.method public bridge synthetic fromJson(Ljava/lang/String;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 38
    invoke-virtual {p0, p1}, Lcom/exacttarget/etpushsdk/event/BeaconResponseEvent;->fromJson(Ljava/lang/String;)Lcom/exacttarget/etpushsdk/event/BeaconResponseEvent;

    move-result-object v0

    return-object v0
.end method

.method public setDatabaseIds(Lcom/exacttarget/etpushsdk/event/BeaconResponseEvent;Ljava/util/List;)V
    .locals 0

    .prologue
    .line 139
    return-void
.end method

.method public bridge synthetic setDatabaseIds(Ljava/lang/Object;Ljava/util/List;)V
    .locals 0

    .prologue
    .line 38
    check-cast p1, Lcom/exacttarget/etpushsdk/event/BeaconResponseEvent;

    invoke-virtual {p0, p1, p2}, Lcom/exacttarget/etpushsdk/event/BeaconResponseEvent;->setDatabaseIds(Lcom/exacttarget/etpushsdk/event/BeaconResponseEvent;Ljava/util/List;)V

    return-void
.end method
