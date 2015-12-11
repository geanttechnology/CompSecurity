.class public Lcom/exacttarget/etpushsdk/event/LocationUpdateEvent;
.super Lcom/exacttarget/etpushsdk/data/LocationUpdate;
.source "SourceFile"

# interfaces
.implements Lcom/exacttarget/etpushsdk/event/IEventFactory;


# static fields
.field private static final TAG:Ljava/lang/String; = "~!LocationUpdateEvent"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 37
    invoke-direct {p0}, Lcom/exacttarget/etpushsdk/data/LocationUpdate;-><init>()V

    return-void
.end method


# virtual methods
.method public fromJson(Ljava/lang/String;)Lcom/exacttarget/etpushsdk/event/LocationUpdateEvent;
    .locals 7

    .prologue
    const/4 v0, 0x0

    .line 54
    :try_start_0
    new-instance v1, Ljava/text/SimpleDateFormat;

    const-string v2, "yyyy-MM-dd\'T\'HH:mm:ss.SSS\'Z\'"

    sget-object v3, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-direct {v1, v2, v3}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;Ljava/util/Locale;)V

    .line 55
    new-instance v2, Lorg/json/JSONObject;

    invoke-direct {v2, p1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 56
    const-string v3, "deviceId"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, v3}, Lcom/exacttarget/etpushsdk/event/LocationUpdateEvent;->setDeviceId(Ljava/lang/String;)V

    .line 57
    const-string v3, "latitude"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getDouble(Ljava/lang/String;)D

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v3

    invoke-virtual {p0, v3}, Lcom/exacttarget/etpushsdk/event/LocationUpdateEvent;->setLatitude(Ljava/lang/Double;)V

    .line 58
    const-string v3, "longitude"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getDouble(Ljava/lang/String;)D

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v3

    invoke-virtual {p0, v3}, Lcom/exacttarget/etpushsdk/event/LocationUpdateEvent;->setLongitude(Ljava/lang/Double;)V

    .line 59
    const-string v3, "accuracy"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {p0, v3}, Lcom/exacttarget/etpushsdk/event/LocationUpdateEvent;->setAccuracy(Ljava/lang/Integer;)V

    .line 61
    const-string v3, "1970-01-01T00:00:00.001Z"

    invoke-virtual {v1, v3}, Ljava/text/DateFormat;->parse(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v3

    invoke-virtual {p0, v3}, Lcom/exacttarget/etpushsdk/event/LocationUpdateEvent;->setTimestamp(Ljava/util/Date;)V

    .line 62
    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    const-string v5, "location_DateTime_Utc"

    aput-object v5, v3, v4

    const/4 v4, 0x1

    const-string v5, "location_datetime_utc"

    aput-object v5, v3, v4

    .line 63
    array-length v4, v3

    :goto_0
    if-ge v0, v4, :cond_0

    aget-object v5, v3, v0

    .line 64
    invoke-virtual {v2, v5}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 65
    const-string v0, "~!LocationUpdateEvent"

    const-string v3, "Key: %s"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v6, 0x0

    aput-object v5, v4, v6

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v0, v3}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 66
    invoke-virtual {v2, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/text/DateFormat;->parse(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/exacttarget/etpushsdk/event/LocationUpdateEvent;->setTimestamp(Ljava/util/Date;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 73
    :cond_0
    :goto_1
    return-object p0

    .line 63
    :cond_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 71
    :catch_0
    move-exception v0

    .line 72
    const-string v1, "~!LocationUpdateEvent"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 73
    const/4 p0, 0x0

    goto :goto_1
.end method

.method public bridge synthetic fromJson(Ljava/lang/String;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 37
    invoke-virtual {p0, p1}, Lcom/exacttarget/etpushsdk/event/LocationUpdateEvent;->fromJson(Ljava/lang/String;)Lcom/exacttarget/etpushsdk/event/LocationUpdateEvent;

    move-result-object v0

    return-object v0
.end method

.method public setDatabaseIds(Lcom/exacttarget/etpushsdk/event/LocationUpdateEvent;Ljava/util/List;)V
    .locals 0

    .prologue
    .line 79
    return-void
.end method

.method public bridge synthetic setDatabaseIds(Ljava/lang/Object;Ljava/util/List;)V
    .locals 0

    .prologue
    .line 37
    check-cast p1, Lcom/exacttarget/etpushsdk/event/LocationUpdateEvent;

    invoke-virtual {p0, p1, p2}, Lcom/exacttarget/etpushsdk/event/LocationUpdateEvent;->setDatabaseIds(Lcom/exacttarget/etpushsdk/event/LocationUpdateEvent;Ljava/util/List;)V

    return-void
.end method
