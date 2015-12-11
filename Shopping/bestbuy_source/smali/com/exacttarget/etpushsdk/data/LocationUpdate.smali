.class public Lcom/exacttarget/etpushsdk/data/LocationUpdate;
.super Lcom/exacttarget/etpushsdk/util/g;
.source "SourceFile"


# static fields
.field protected static final JF_ACCURACY:Ljava/lang/String; = "accuracy"

.field protected static final JF_DEVICE_ID:Ljava/lang/String; = "deviceId"

.field protected static final JF_ISO8601_LOCAL_DATE_FORMAT:Ljava/lang/String; = "yyyy-MM-dd\'T\'HH:mm:ss.SSS\'Z\'"

.field protected static final JF_LAST_SENT_TIME:Ljava/lang/String; = "lastSent"

.field protected static final JF_LATITUDE:Ljava/lang/String; = "latitude"

.field protected static final JF_LOCATION_DATE_TIME_UTC:Ljava/lang/String; = "location_DateTime_Utc"

.field protected static final JF_LOCATION_ID:Ljava/lang/String; = "id"

.field protected static final JF_LONGITUDE:Ljava/lang/String; = "longitude"

.field public static final TAG:Ljava/lang/String; = "~!LocationUpdate"


# instance fields
.field private accuracy:Ljava/lang/Integer;

.field private deviceId:Ljava/lang/String;

.field private id:Ljava/lang/Integer;

.field private lastSent:Ljava/lang/Long;

.field private latitude:Ljava/lang/Double;

.field private longitude:Ljava/lang/Double;

.field private timestamp:Ljava/util/Date;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 52
    invoke-direct {p0}, Lcom/exacttarget/etpushsdk/util/g;-><init>()V

    .line 49
    const-wide/16 v0, 0x0

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/LocationUpdate;->lastSent:Ljava/lang/Long;

    .line 53
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 2

    .prologue
    .line 56
    invoke-direct {p0}, Lcom/exacttarget/etpushsdk/util/g;-><init>()V

    .line 49
    const-wide/16 v0, 0x0

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/LocationUpdate;->lastSent:Ljava/lang/Long;

    .line 57
    invoke-static {p1}, Lcom/exacttarget/etpushsdk/data/LocationUpdate;->uniqueDeviceIdentifier(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/LocationUpdate;->deviceId:Ljava/lang/String;

    .line 58
    return-void
.end method


# virtual methods
.method public getAccuracy()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 93
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/LocationUpdate;->accuracy:Ljava/lang/Integer;

    return-object v0
.end method

.method public getDeviceId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/LocationUpdate;->deviceId:Ljava/lang/String;

    return-object v0
.end method

.method public getId()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/LocationUpdate;->id:Ljava/lang/Integer;

    return-object v0
.end method

.method public getLastSent()Ljava/lang/Long;
    .locals 1

    .prologue
    .line 109
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/LocationUpdate;->lastSent:Ljava/lang/Long;

    return-object v0
.end method

.method public getLatitude()Ljava/lang/Double;
    .locals 1

    .prologue
    .line 77
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/LocationUpdate;->latitude:Ljava/lang/Double;

    return-object v0
.end method

.method public getLongitude()Ljava/lang/Double;
    .locals 1

    .prologue
    .line 85
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/LocationUpdate;->longitude:Ljava/lang/Double;

    return-object v0
.end method

.method public getTimestamp()Ljava/util/Date;
    .locals 1

    .prologue
    .line 101
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/LocationUpdate;->timestamp:Ljava/util/Date;

    return-object v0
.end method

.method public setAccuracy(Ljava/lang/Integer;)V
    .locals 0

    .prologue
    .line 97
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/LocationUpdate;->accuracy:Ljava/lang/Integer;

    .line 98
    return-void
.end method

.method public setDeviceId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 73
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/LocationUpdate;->deviceId:Ljava/lang/String;

    .line 74
    return-void
.end method

.method public setId(Ljava/lang/Integer;)V
    .locals 0

    .prologue
    .line 65
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/LocationUpdate;->id:Ljava/lang/Integer;

    .line 66
    return-void
.end method

.method public setLastSent(Ljava/lang/Long;)V
    .locals 0

    .prologue
    .line 113
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/LocationUpdate;->lastSent:Ljava/lang/Long;

    .line 114
    return-void
.end method

.method public setLatitude(Ljava/lang/Double;)V
    .locals 0

    .prologue
    .line 81
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/LocationUpdate;->latitude:Ljava/lang/Double;

    .line 82
    return-void
.end method

.method public setLongitude(Ljava/lang/Double;)V
    .locals 0

    .prologue
    .line 89
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/LocationUpdate;->longitude:Ljava/lang/Double;

    .line 90
    return-void
.end method

.method public setTimestamp(Ljava/util/Date;)V
    .locals 0

    .prologue
    .line 105
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/LocationUpdate;->timestamp:Ljava/util/Date;

    .line 106
    return-void
.end method

.method public toJson()Ljava/lang/String;
    .locals 6

    .prologue
    .line 129
    :try_start_0
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    .line 130
    const-string v1, "accuracy"

    iget-object v2, p0, Lcom/exacttarget/etpushsdk/data/LocationUpdate;->accuracy:Ljava/lang/Integer;

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 131
    const-string v1, "deviceId"

    iget-object v2, p0, Lcom/exacttarget/etpushsdk/data/LocationUpdate;->deviceId:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 132
    const-string v1, "id"

    iget-object v2, p0, Lcom/exacttarget/etpushsdk/data/LocationUpdate;->id:Ljava/lang/Integer;

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 133
    const-string v1, "lastSent"

    iget-object v2, p0, Lcom/exacttarget/etpushsdk/data/LocationUpdate;->lastSent:Ljava/lang/Long;

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 134
    const-string v1, "latitude"

    iget-object v2, p0, Lcom/exacttarget/etpushsdk/data/LocationUpdate;->latitude:Ljava/lang/Double;

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 135
    const-string v1, "longitude"

    iget-object v2, p0, Lcom/exacttarget/etpushsdk/data/LocationUpdate;->longitude:Ljava/lang/Double;

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 136
    const-string v1, "location_DateTime_Utc"

    new-instance v2, Ljava/text/SimpleDateFormat;

    const-string v3, "yyyy-MM-dd\'T\'HH:mm:ss.SSS\'Z\'"

    sget-object v4, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-direct {v2, v3, v4}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;Ljava/util/Locale;)V

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/text/SimpleDateFormat;->format(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 137
    invoke-virtual {v0}, Lorg/json/JSONObject;->toString()Ljava/lang/String;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 140
    :goto_0
    return-object v0

    .line 138
    :catch_0
    move-exception v0

    .line 139
    const-string v1, "~!LocationUpdate"

    const-string v2, "Error converting AnalyticItem to JSON: %1$s"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-virtual {v0}, Lorg/json/JSONException;->getMessage()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 140
    const/4 v0, 0x0

    goto :goto_0
.end method
