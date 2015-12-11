.class public Lcom/amazon/sdk/availability/Measurement;
.super Ljava/lang/Object;
.source "Measurement.java"


# static fields
.field private static final GLOBAL_METADATA:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static defaultClientId:Ljava/lang/String;

.field private static defaultClientVersion:Ljava/lang/String;


# instance fields
.field private clientId:Ljava/lang/String;

.field private clientVersion:Ljava/lang/String;

.field private measurement:Lorg/json/JSONObject;

.field private measurementId:Ljava/lang/String;

.field private measurementName:Ljava/lang/String;

.field private measurementTimestamp:Ljava/lang/Long;

.field private measurementValueNumber:Ljava/lang/Number;

.field private metadata:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 28
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/amazon/sdk/availability/Measurement;->GLOBAL_METADATA:Ljava/util/Map;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 59
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 60
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/sdk/availability/Measurement;->metadata:Ljava/util/Map;

    .line 61
    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/sdk/availability/Measurement;->measurementId:Ljava/lang/String;

    .line 62
    return-void
.end method

.method public static setDefaultClientId(Ljava/lang/String;)V
    .locals 0
    .param p0, "clientId"    # Ljava/lang/String;

    .prologue
    .line 72
    sput-object p0, Lcom/amazon/sdk/availability/Measurement;->defaultClientId:Ljava/lang/String;

    .line 73
    return-void
.end method

.method public static setDefaultClientVersion(Ljava/lang/String;)V
    .locals 0
    .param p0, "version"    # Ljava/lang/String;

    .prologue
    .line 81
    sput-object p0, Lcom/amazon/sdk/availability/Measurement;->defaultClientVersion:Ljava/lang/String;

    .line 82
    return-void
.end method

.method public static setGlobalMetadata(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p0, "key"    # Ljava/lang/String;
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    .line 92
    sget-object v0, Lcom/amazon/sdk/availability/Measurement;->GLOBAL_METADATA:Ljava/util/Map;

    invoke-interface {v0, p0, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 93
    return-void
.end method


# virtual methods
.method public build()Lorg/json/JSONObject;
    .locals 12

    .prologue
    .line 260
    invoke-virtual {p0}, Lcom/amazon/sdk/availability/Measurement;->getClientId()Ljava/lang/String;

    move-result-object v2

    .line 261
    .local v2, "id":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/amazon/sdk/availability/Measurement;->getClientVersion()Ljava/lang/String;

    move-result-object v6

    .line 264
    .local v6, "version":Ljava/lang/String;
    invoke-static {v2}, Lcom/amazon/sdk/availability/StringUtil;->isEmpty(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_0

    .line 265
    new-instance v7, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v8, "missing client id"

    invoke-direct {v7, v8}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v7

    .line 267
    :cond_0
    invoke-static {v6}, Lcom/amazon/sdk/availability/StringUtil;->isEmpty(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_1

    .line 268
    new-instance v7, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v8, "missing client version"

    invoke-direct {v7, v8}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v7

    .line 270
    :cond_1
    iget-object v7, p0, Lcom/amazon/sdk/availability/Measurement;->measurementName:Ljava/lang/String;

    invoke-static {v7}, Lcom/amazon/sdk/availability/StringUtil;->isEmpty(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_2

    .line 271
    new-instance v7, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v8, "missing measurement name"

    invoke-direct {v7, v8}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v7

    .line 275
    :cond_2
    iget-object v7, p0, Lcom/amazon/sdk/availability/Measurement;->measurementValueNumber:Ljava/lang/Number;

    if-nez v7, :cond_3

    .line 276
    const-wide/16 v7, 0x0

    invoke-static {v7, v8}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v7

    iput-object v7, p0, Lcom/amazon/sdk/availability/Measurement;->measurementValueNumber:Ljava/lang/Number;

    .line 278
    :cond_3
    iget-object v7, p0, Lcom/amazon/sdk/availability/Measurement;->measurementTimestamp:Ljava/lang/Long;

    if-nez v7, :cond_4

    .line 279
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v7

    invoke-static {v7, v8}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v7

    iput-object v7, p0, Lcom/amazon/sdk/availability/Measurement;->measurementTimestamp:Ljava/lang/Long;

    .line 283
    :cond_4
    new-instance v7, Lorg/json/JSONObject;

    invoke-direct {v7}, Lorg/json/JSONObject;-><init>()V

    iput-object v7, p0, Lcom/amazon/sdk/availability/Measurement;->measurement:Lorg/json/JSONObject;

    .line 287
    :try_start_0
    iget-object v7, p0, Lcom/amazon/sdk/availability/Measurement;->measurement:Lorg/json/JSONObject;

    const-string/jumbo v8, "clientId"

    invoke-virtual {v7, v8, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 288
    iget-object v7, p0, Lcom/amazon/sdk/availability/Measurement;->measurement:Lorg/json/JSONObject;

    const-string/jumbo v8, "clientVersion"

    invoke-virtual {v7, v8, v6}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 289
    iget-object v7, p0, Lcom/amazon/sdk/availability/Measurement;->measurement:Lorg/json/JSONObject;

    const-string/jumbo v8, "measurementName"

    iget-object v9, p0, Lcom/amazon/sdk/availability/Measurement;->measurementName:Ljava/lang/String;

    invoke-virtual {v7, v8, v9}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 290
    iget-object v7, p0, Lcom/amazon/sdk/availability/Measurement;->measurement:Lorg/json/JSONObject;

    const-string/jumbo v8, "measurementValueNumber"

    iget-object v9, p0, Lcom/amazon/sdk/availability/Measurement;->measurementValueNumber:Ljava/lang/Number;

    invoke-virtual {v7, v8, v9}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 291
    iget-object v7, p0, Lcom/amazon/sdk/availability/Measurement;->measurement:Lorg/json/JSONObject;

    const-string/jumbo v8, "measurementId"

    iget-object v9, p0, Lcom/amazon/sdk/availability/Measurement;->measurementId:Ljava/lang/String;

    invoke-virtual {v7, v8, v9}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 294
    new-instance v5, Ljava/text/SimpleDateFormat;

    const-string/jumbo v7, "yyyy-MM-dd\'T\'HH:mm:ss.SSSZ"

    invoke-direct {v5, v7}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    .line 295
    .local v5, "sdf":Ljava/text/SimpleDateFormat;
    iget-object v7, p0, Lcom/amazon/sdk/availability/Measurement;->measurement:Lorg/json/JSONObject;

    const-string/jumbo v8, "measurementTimestamp"

    new-instance v9, Ljava/util/Date;

    iget-object v10, p0, Lcom/amazon/sdk/availability/Measurement;->measurementTimestamp:Ljava/lang/Long;

    invoke-virtual {v10}, Ljava/lang/Long;->longValue()J

    move-result-wide v10

    invoke-direct {v9, v10, v11}, Ljava/util/Date;-><init>(J)V

    invoke-virtual {v5, v9}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v7, v8, v9}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 298
    new-instance v4, Lorg/json/JSONObject;

    invoke-direct {v4}, Lorg/json/JSONObject;-><init>()V

    .line 299
    .local v4, "measurementMetadata":Lorg/json/JSONObject;
    sget-object v7, Lcom/amazon/sdk/availability/Measurement;->GLOBAL_METADATA:Ljava/util/Map;

    invoke-interface {v7}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v7

    invoke-interface {v7}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_5

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 300
    .local v3, "key":Ljava/lang/String;
    sget-object v7, Lcom/amazon/sdk/availability/Measurement;->GLOBAL_METADATA:Ljava/util/Map;

    invoke-interface {v7, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    invoke-virtual {v4, v3, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 306
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v3    # "key":Ljava/lang/String;
    .end local v4    # "measurementMetadata":Lorg/json/JSONObject;
    .end local v5    # "sdf":Ljava/text/SimpleDateFormat;
    :catch_0
    move-exception v0

    .line 307
    .local v0, "e":Lorg/json/JSONException;
    new-instance v7, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v8, "unable to serialize measurement"

    invoke-direct {v7, v8, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v7

    .line 302
    .end local v0    # "e":Lorg/json/JSONException;
    .restart local v1    # "i$":Ljava/util/Iterator;
    .restart local v4    # "measurementMetadata":Lorg/json/JSONObject;
    .restart local v5    # "sdf":Ljava/text/SimpleDateFormat;
    :cond_5
    :try_start_1
    iget-object v7, p0, Lcom/amazon/sdk/availability/Measurement;->metadata:Ljava/util/Map;

    invoke-interface {v7}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v7

    invoke-interface {v7}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_6

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 303
    .restart local v3    # "key":Ljava/lang/String;
    iget-object v7, p0, Lcom/amazon/sdk/availability/Measurement;->metadata:Ljava/util/Map;

    invoke-interface {v7, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    invoke-virtual {v4, v3, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto :goto_1

    .line 305
    .end local v3    # "key":Ljava/lang/String;
    :cond_6
    iget-object v7, p0, Lcom/amazon/sdk/availability/Measurement;->measurement:Lorg/json/JSONObject;

    const-string/jumbo v8, "metadata"

    invoke-virtual {v7, v8, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0

    .line 310
    iget-object v7, p0, Lcom/amazon/sdk/availability/Measurement;->measurement:Lorg/json/JSONObject;

    return-object v7
.end method

.method public getClientId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 184
    iget-object v0, p0, Lcom/amazon/sdk/availability/Measurement;->clientId:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 185
    sget-object v0, Lcom/amazon/sdk/availability/Measurement;->defaultClientId:Ljava/lang/String;

    .line 187
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/sdk/availability/Measurement;->clientId:Ljava/lang/String;

    goto :goto_0
.end method

.method public getClientVersion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 196
    iget-object v0, p0, Lcom/amazon/sdk/availability/Measurement;->clientVersion:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 197
    sget-object v0, Lcom/amazon/sdk/availability/Measurement;->defaultClientVersion:Ljava/lang/String;

    .line 199
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/sdk/availability/Measurement;->clientVersion:Ljava/lang/String;

    goto :goto_0
.end method

.method public setClientId(Ljava/lang/String;)Lcom/amazon/sdk/availability/Measurement;
    .locals 0
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 104
    iput-object p1, p0, Lcom/amazon/sdk/availability/Measurement;->clientId:Ljava/lang/String;

    .line 105
    return-object p0
.end method

.method public setClientVersion(Ljava/lang/String;)Lcom/amazon/sdk/availability/Measurement;
    .locals 0
    .param p1, "version"    # Ljava/lang/String;

    .prologue
    .line 115
    iput-object p1, p0, Lcom/amazon/sdk/availability/Measurement;->clientVersion:Ljava/lang/String;

    .line 116
    return-object p0
.end method

.method public setMeasurementName(Ljava/lang/String;)Lcom/amazon/sdk/availability/Measurement;
    .locals 0
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 126
    iput-object p1, p0, Lcom/amazon/sdk/availability/Measurement;->measurementName:Ljava/lang/String;

    .line 127
    return-object p0
.end method

.method public setMeasurementTimestamp(J)Lcom/amazon/sdk/availability/Measurement;
    .locals 1
    .param p1, "timestamp"    # J

    .prologue
    .line 148
    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/sdk/availability/Measurement;->measurementTimestamp:Ljava/lang/Long;

    .line 149
    return-object p0
.end method

.method public setMeasurementValueNumber(Ljava/lang/Number;)Lcom/amazon/sdk/availability/Measurement;
    .locals 0
    .param p1, "valueNumber"    # Ljava/lang/Number;

    .prologue
    .line 137
    iput-object p1, p0, Lcom/amazon/sdk/availability/Measurement;->measurementValueNumber:Ljava/lang/Number;

    .line 138
    return-object p0
.end method

.method public setMetadata(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/sdk/availability/Measurement;
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 161
    iget-object v0, p0, Lcom/amazon/sdk/availability/Measurement;->metadata:Ljava/util/Map;

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 162
    return-object p0
.end method

.method public toString()Ljava/lang/String;
    .locals 10

    .prologue
    const/4 v9, 0x2

    const/4 v8, 0x1

    const/4 v7, 0x0

    .line 318
    new-instance v2, Ljava/lang/StringBuffer;

    invoke-direct {v2}, Ljava/lang/StringBuffer;-><init>()V

    .line 319
    .local v2, "sb":Ljava/lang/StringBuffer;
    const-string/jumbo v3, "{\n\t\"clientId\" : \"%s\",\n\t\"clientVersion\" : \"%s\",\n\t\"measurementName\" : \"%s\",\n\t\"measurementValueNumber\" : %d,\n\t\"measurementTimestamp\" : %d,\n\t\"metadata\" : {\n"

    const/4 v4, 0x5

    new-array v4, v4, [Ljava/lang/Object;

    iget-object v5, p0, Lcom/amazon/sdk/availability/Measurement;->clientId:Ljava/lang/String;

    aput-object v5, v4, v7

    iget-object v5, p0, Lcom/amazon/sdk/availability/Measurement;->clientVersion:Ljava/lang/String;

    aput-object v5, v4, v8

    iget-object v5, p0, Lcom/amazon/sdk/availability/Measurement;->measurementName:Ljava/lang/String;

    aput-object v5, v4, v9

    const/4 v5, 0x3

    iget-object v6, p0, Lcom/amazon/sdk/availability/Measurement;->measurementValueNumber:Ljava/lang/Number;

    aput-object v6, v4, v5

    const/4 v5, 0x4

    iget-object v6, p0, Lcom/amazon/sdk/availability/Measurement;->measurementTimestamp:Ljava/lang/Long;

    aput-object v6, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 324
    sget-object v3, Lcom/amazon/sdk/availability/Measurement;->GLOBAL_METADATA:Ljava/util/Map;

    invoke-interface {v3}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 325
    .local v1, "key":Ljava/lang/String;
    const-string/jumbo v3, "\t\t\"%s\" : \"%s\",\n"

    new-array v4, v9, [Ljava/lang/Object;

    aput-object v1, v4, v7

    sget-object v5, Lcom/amazon/sdk/availability/Measurement;->GLOBAL_METADATA:Ljava/util/Map;

    invoke-interface {v5, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    aput-object v5, v4, v8

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_0

    .line 327
    .end local v1    # "key":Ljava/lang/String;
    :cond_0
    iget-object v3, p0, Lcom/amazon/sdk/availability/Measurement;->metadata:Ljava/util/Map;

    invoke-interface {v3}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 328
    .restart local v1    # "key":Ljava/lang/String;
    const-string/jumbo v3, "\t\t\"%s\" : \"%s\",\n"

    new-array v4, v9, [Ljava/lang/Object;

    aput-object v1, v4, v7

    iget-object v5, p0, Lcom/amazon/sdk/availability/Measurement;->metadata:Ljava/util/Map;

    invoke-interface {v5, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    aput-object v5, v4, v8

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_1

    .line 330
    .end local v1    # "key":Ljava/lang/String;
    :cond_1
    const-string/jumbo v3, "\t}\n}"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 331
    invoke-virtual {v2}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v3

    return-object v3
.end method
