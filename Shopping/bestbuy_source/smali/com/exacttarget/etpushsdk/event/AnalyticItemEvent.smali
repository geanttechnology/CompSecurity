.class public Lcom/exacttarget/etpushsdk/event/AnalyticItemEvent;
.super Ljava/util/ArrayList;
.source "SourceFile"

# interfaces
.implements Lcom/exacttarget/etpushsdk/event/IEventFactory;


# static fields
.field private static final TAG:Ljava/lang/String; = "~!AnalyticItemEvent"

.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private databaseIds:Ljava/util/List;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 34
    invoke-direct {p0}, Ljava/util/ArrayList;-><init>()V

    return-void
.end method


# virtual methods
.method public fromJson(Ljava/lang/String;)Lcom/exacttarget/etpushsdk/event/AnalyticItemEvent;
    .locals 9

    .prologue
    .line 76
    :try_start_0
    new-instance v1, Ljava/text/SimpleDateFormat;

    const-string v0, "yyyy-MM-dd\'T\'HH:mm:ss.SSS\'Z\'"

    sget-object v2, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-direct {v1, v0, v2}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;Ljava/util/Locale;)V

    .line 77
    new-instance v3, Lorg/json/JSONArray;

    invoke-direct {v3, p1}, Lorg/json/JSONArray;-><init>(Ljava/lang/String;)V

    .line 79
    if-eqz v3, :cond_0

    .line 80
    const/4 v0, 0x0

    move v2, v0

    :goto_0
    invoke-virtual {v3}, Lorg/json/JSONArray;->length()I

    move-result v0

    if-ge v2, v0, :cond_0

    .line 81
    invoke-virtual {v3, v2}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v4

    .line 82
    new-instance v5, Lcom/exacttarget/etpushsdk/data/AnalyticItem;

    invoke-direct {v5}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;-><init>()V

    .line 83
    const-string v0, "etAppId"

    invoke-virtual {v5, v0}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->setEtAppId(Ljava/lang/String;)V

    .line 84
    const-string v0, "deviceId"

    invoke-virtual {v5, v0}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->setDeviceId(Ljava/lang/String;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_2

    .line 86
    :try_start_1
    const-string v0, "eventDate"

    invoke-virtual {v4, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/text/DateFormat;->parse(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v0

    invoke-virtual {v5, v0}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->setEventDate(Ljava/util/Date;)V
    :try_end_1
    .catch Ljava/text/ParseException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_4

    .line 99
    :goto_1
    :try_start_2
    const-string v0, "value"

    invoke-virtual {v4, v0}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v5, v0}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->setValue(Ljava/lang/Integer;)V

    .line 100
    const-string v0, "objectIds"

    invoke-virtual {v4, v0}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/util/k;->a(Lorg/json/JSONArray;)Ljava/util/List;

    move-result-object v0

    invoke-virtual {v5, v0}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->setObjectIds(Ljava/util/List;)V

    .line 101
    const-string v0, "analyticTypes"

    invoke-virtual {v4, v0}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/util/k;->a(Lorg/json/JSONArray;)Ljava/util/List;

    move-result-object v0

    invoke-virtual {v5, v0}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->setAnalyticTypes(Ljava/util/List;)V

    .line 102
    invoke-virtual {p0, v5}, Lcom/exacttarget/etpushsdk/event/AnalyticItemEvent;->add(Ljava/lang/Object;)Z
    :try_end_2
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_2

    .line 80
    add-int/lit8 v0, v2, 0x1

    move v2, v0

    goto :goto_0

    .line 87
    :catch_0
    move-exception v0

    .line 89
    :try_start_3
    new-instance v0, Ljava/text/SimpleDateFormat;

    const-string v6, "yyyy-MM-dd\'T\'HH:mm:ss.SSS\'Z\'"

    sget-object v7, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-direct {v0, v6, v7}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;Ljava/util/Locale;)V
    :try_end_3
    .catch Ljava/text/ParseException; {:try_start_3 .. :try_end_3} :catch_1
    .catch Lorg/json/JSONException; {:try_start_3 .. :try_end_3} :catch_3

    .line 90
    :try_start_4
    const-string v1, "eventDate"

    invoke-virtual {v4, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/text/DateFormat;->parse(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v1

    invoke-virtual {v5, v1}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->setEventDate(Ljava/util/Date;)V
    :try_end_4
    .catch Ljava/text/ParseException; {:try_start_4 .. :try_end_4} :catch_6
    .catch Lorg/json/JSONException; {:try_start_4 .. :try_end_4} :catch_5

    :goto_2
    move-object v1, v0

    .line 98
    goto :goto_1

    .line 91
    :catch_1
    move-exception v0

    move-object v8, v0

    move-object v0, v1

    move-object v1, v8

    .line 92
    :goto_3
    :try_start_5
    invoke-virtual {v1}, Ljava/text/ParseException;->printStackTrace()V
    :try_end_5
    .catch Lorg/json/JSONException; {:try_start_5 .. :try_end_5} :catch_2

    goto :goto_2

    .line 106
    :catch_2
    move-exception v0

    .line 107
    const-string v1, "~!AnalyticItemEvent"

    invoke-virtual {v0}, Lorg/json/JSONException;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 108
    const/4 p0, 0x0

    :cond_0
    return-object p0

    .line 93
    :catch_3
    move-exception v0

    move-object v8, v0

    move-object v0, v1

    move-object v1, v8

    .line 94
    :goto_4
    :try_start_6
    invoke-virtual {v1}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_2

    .line 96
    :catch_4
    move-exception v0

    .line 97
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V
    :try_end_6
    .catch Lorg/json/JSONException; {:try_start_6 .. :try_end_6} :catch_2

    goto :goto_1

    .line 93
    :catch_5
    move-exception v1

    goto :goto_4

    .line 91
    :catch_6
    move-exception v1

    goto :goto_3
.end method

.method public bridge synthetic fromJson(Ljava/lang/String;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 34
    invoke-virtual {p0, p1}, Lcom/exacttarget/etpushsdk/event/AnalyticItemEvent;->fromJson(Ljava/lang/String;)Lcom/exacttarget/etpushsdk/event/AnalyticItemEvent;

    move-result-object v0

    return-object v0
.end method

.method public getDatabaseIds()Ljava/util/List;
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/event/AnalyticItemEvent;->databaseIds:Ljava/util/List;

    return-object v0
.end method

.method public setDatabaseIds(Lcom/exacttarget/etpushsdk/event/AnalyticItemEvent;Ljava/util/List;)V
    .locals 0

    .prologue
    .line 114
    invoke-virtual {p1, p2}, Lcom/exacttarget/etpushsdk/event/AnalyticItemEvent;->setDatabaseIds(Ljava/util/List;)V

    .line 115
    return-void
.end method

.method public bridge synthetic setDatabaseIds(Ljava/lang/Object;Ljava/util/List;)V
    .locals 0

    .prologue
    .line 34
    check-cast p1, Lcom/exacttarget/etpushsdk/event/AnalyticItemEvent;

    invoke-virtual {p0, p1, p2}, Lcom/exacttarget/etpushsdk/event/AnalyticItemEvent;->setDatabaseIds(Lcom/exacttarget/etpushsdk/event/AnalyticItemEvent;Ljava/util/List;)V

    return-void
.end method

.method public setDatabaseIds(Ljava/util/List;)V
    .locals 0

    .prologue
    .line 45
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/event/AnalyticItemEvent;->databaseIds:Ljava/util/List;

    .line 46
    return-void
.end method
