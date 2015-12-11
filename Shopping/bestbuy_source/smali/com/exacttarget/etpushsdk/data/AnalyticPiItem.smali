.class public Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private a:Ljava/lang/String;

.field private b:Ljava/lang/String;

.field private c:Ljava/lang/String;

.field private d:Ljava/lang/String;

.field private e:Ljava/lang/String;

.field private f:Ljava/lang/String;

.field private g:Ljava/lang/Boolean;

.field private h:Ljava/lang/Double;

.field private i:Ljava/lang/Double;

.field private j:Ljava/lang/String;

.field private k:Ljava/lang/String;

.field private l:Ljava/lang/String;

.field private m:Ljava/lang/String;

.field private n:Ljava/util/ArrayList;

.field private o:Landroid/content/Context;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 78
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 61
    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->a:Ljava/lang/String;

    .line 62
    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->b:Ljava/lang/String;

    .line 63
    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->c:Ljava/lang/String;

    .line 64
    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->d:Ljava/lang/String;

    .line 65
    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->e:Ljava/lang/String;

    .line 66
    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->f:Ljava/lang/String;

    .line 67
    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->g:Ljava/lang/Boolean;

    .line 68
    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->h:Ljava/lang/Double;

    .line 69
    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->i:Ljava/lang/Double;

    .line 70
    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->j:Ljava/lang/String;

    .line 71
    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->k:Ljava/lang/String;

    .line 72
    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->l:Ljava/lang/String;

    .line 73
    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->m:Ljava/lang/String;

    .line 79
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->o:Landroid/content/Context;

    .line 80
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->o:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->e:Ljava/lang/String;

    .line 81
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->n:Ljava/util/ArrayList;

    .line 82
    return-void
.end method

.method private a(Ljava/util/Date;)V
    .locals 4

    .prologue
    .line 196
    new-instance v0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem$JSON_Event;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem$JSON_Event;-><init>(Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;Lcom/exacttarget/etpushsdk/data/AnalyticPiItem$1;)V

    .line 197
    const-string v1, "track_event"

    iput-object v1, v0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem$JSON_Event;->a:Ljava/lang/String;

    .line 198
    const-string v1, "app_close"

    iput-object v1, v0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem$JSON_Event;->c:Ljava/lang/String;

    .line 199
    new-instance v1, Ljava/util/Date;

    invoke-virtual {p1}, Ljava/util/Date;->getTime()J

    move-result-wide v2

    invoke-direct {v1, v2, v3}, Ljava/util/Date;-><init>(J)V

    iput-object v1, v0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem$JSON_Event;->b:Ljava/util/Date;

    .line 201
    iget-object v1, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->n:Ljava/util/ArrayList;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 202
    return-void
.end method

.method private a(Ljava/util/Date;Z)V
    .locals 4

    .prologue
    .line 186
    new-instance v0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem$JSON_Event;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem$JSON_Event;-><init>(Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;Lcom/exacttarget/etpushsdk/data/AnalyticPiItem$1;)V

    .line 187
    const-string v1, "track_event"

    iput-object v1, v0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem$JSON_Event;->a:Ljava/lang/String;

    .line 188
    const-string v1, "app_open"

    iput-object v1, v0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem$JSON_Event;->c:Ljava/lang/String;

    .line 189
    new-instance v1, Ljava/util/Date;

    invoke-virtual {p1}, Ljava/util/Date;->getTime()J

    move-result-wide v2

    invoke-direct {v1, v2, v3}, Ljava/util/Date;-><init>(J)V

    iput-object v1, v0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem$JSON_Event;->b:Ljava/util/Date;

    .line 190
    invoke-static {p2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    iput-object v1, v0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem$JSON_Event;->d:Ljava/lang/Boolean;

    .line 192
    iget-object v1, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->n:Ljava/util/ArrayList;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 193
    return-void
.end method


# virtual methods
.method public a()Ljava/lang/String;
    .locals 9

    .prologue
    .line 211
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    .line 214
    :try_start_0
    const-string v0, "api_key"

    iget-object v2, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->a:Ljava/lang/String;

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 215
    const-string v0, "app_id"

    iget-object v2, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->b:Ljava/lang/String;

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 217
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->c:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 218
    const-string v0, "user_id"

    iget-object v2, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->c:Ljava/lang/String;

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 221
    :cond_0
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->d:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 222
    const-string v0, "session_id"

    iget-object v2, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->d:Ljava/lang/String;

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 225
    :cond_1
    new-instance v2, Lorg/json/JSONObject;

    invoke-direct {v2}, Lorg/json/JSONObject;-><init>()V

    .line 226
    const-string v0, "app_name"

    iget-object v3, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->e:Ljava/lang/String;

    invoke-virtual {v2, v0, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 229
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    .line 230
    const-string v3, "device_id"

    iget-object v4, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->f:Ljava/lang/String;

    invoke-virtual {v0, v3, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 233
    new-instance v3, Lorg/json/JSONObject;

    invoke-direct {v3}, Lorg/json/JSONObject;-><init>()V

    .line 234
    const-string v4, "push_enabled"

    iget-object v5, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->g:Ljava/lang/Boolean;

    invoke-virtual {v3, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 235
    const-string v4, "details"

    invoke-virtual {v0, v4, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 237
    iget-object v3, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->h:Ljava/lang/Double;

    if-eqz v3, :cond_2

    iget-object v3, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->i:Ljava/lang/Double;

    if-eqz v3, :cond_2

    .line 239
    new-instance v3, Lorg/json/JSONObject;

    invoke-direct {v3}, Lorg/json/JSONObject;-><init>()V

    .line 240
    const-string v4, "latitude"

    iget-object v5, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->h:Ljava/lang/Double;

    invoke-virtual {v3, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 241
    const-string v4, "longitude"

    iget-object v5, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->i:Ljava/lang/Double;

    invoke-virtual {v3, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 242
    const-string v4, "location"

    invoke-virtual {v0, v4, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 246
    :cond_2
    new-instance v3, Lorg/json/JSONObject;

    invoke-direct {v3}, Lorg/json/JSONObject;-><init>()V

    .line 247
    const-string v4, "manufacturer"

    iget-object v5, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->j:Ljava/lang/String;

    invoke-virtual {v3, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 248
    const-string v4, "platform"

    iget-object v5, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->k:Ljava/lang/String;

    invoke-virtual {v3, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 249
    const-string v4, "platform_version"

    iget-object v5, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->l:Ljava/lang/String;

    invoke-virtual {v3, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 250
    const-string v4, "device_type"

    iget-object v5, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->m:Ljava/lang/String;

    invoke-virtual {v3, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 251
    const-string v4, "device"

    invoke-virtual {v0, v4, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 253
    const-string v3, "user_info"

    invoke-virtual {v2, v3, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 256
    new-instance v3, Lorg/json/JSONArray;

    invoke-direct {v3}, Lorg/json/JSONArray;-><init>()V

    .line 258
    new-instance v4, Ljava/text/SimpleDateFormat;

    const-string v0, "yyyy-MM-dd\'T\'HH:mm:ss.SSS\'Z\'"

    sget-object v5, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-direct {v4, v0, v5}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;Ljava/util/Locale;)V

    .line 259
    const-string v0, "UTC"

    invoke-static {v0}, Ljava/util/TimeZone;->getTimeZone(Ljava/lang/String;)Ljava/util/TimeZone;

    move-result-object v0

    invoke-virtual {v4, v0}, Ljava/text/SimpleDateFormat;->setTimeZone(Ljava/util/TimeZone;)V

    .line 260
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->n:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :goto_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_4

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem$JSON_Event;

    .line 261
    new-instance v6, Lorg/json/JSONObject;

    invoke-direct {v6}, Lorg/json/JSONObject;-><init>()V

    .line 262
    const-string v7, "api_endpoint"

    iget-object v8, v0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem$JSON_Event;->a:Ljava/lang/String;

    invoke-virtual {v6, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 263
    const-string v7, "timestamp"

    iget-object v8, v0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem$JSON_Event;->b:Ljava/util/Date;

    invoke-virtual {v4, v8}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v6, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 264
    const-string v7, "event_name"

    iget-object v8, v0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem$JSON_Event;->c:Ljava/lang/String;

    invoke-virtual {v6, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 266
    iget-object v7, v0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem$JSON_Event;->c:Ljava/lang/String;

    const-string v8, "app_open"

    invoke-virtual {v7, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_3

    .line 267
    new-instance v7, Lorg/json/JSONObject;

    invoke-direct {v7}, Lorg/json/JSONObject;-><init>()V

    .line 268
    const-string v8, "open_from_push"

    iget-object v0, v0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem$JSON_Event;->d:Ljava/lang/Boolean;

    invoke-virtual {v7, v8, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 269
    const-string v0, "details"

    invoke-virtual {v6, v0, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 272
    :cond_3
    invoke-virtual {v3, v6}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 280
    :catch_0
    move-exception v0

    .line 281
    const-string v1, "~!AnalyticPIItem"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 282
    const/4 v0, 0x0

    .line 285
    :goto_1
    return-object v0

    .line 275
    :cond_4
    :try_start_1
    const-string v0, "events"

    invoke-virtual {v2, v0, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 277
    const-string v0, "payload"

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    .line 285
    invoke-virtual {v1}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_1
.end method

.method public a(Ljava/util/Date;Ljava/util/Date;Z)V
    .locals 0

    .prologue
    .line 181
    invoke-direct {p0, p1, p3}, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->a(Ljava/util/Date;Z)V

    .line 182
    invoke-direct {p0, p2}, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->a(Ljava/util/Date;)V

    .line 183
    return-void
.end method

.method public getApiKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 85
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->a:Ljava/lang/String;

    return-object v0
.end method

.method public getAppId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 93
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->b:Ljava/lang/String;

    return-object v0
.end method

.method public getDeviceId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 117
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->f:Ljava/lang/String;

    return-object v0
.end method

.method public getDeviceType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 157
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->m:Ljava/lang/String;

    return-object v0
.end method

.method public getLatitude()D
    .locals 2

    .prologue
    .line 165
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->h:Ljava/lang/Double;

    invoke-virtual {v0}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v0

    return-wide v0
.end method

.method public getLongitude()D
    .locals 2

    .prologue
    .line 173
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->i:Ljava/lang/Double;

    invoke-virtual {v0}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v0

    return-wide v0
.end method

.method public getManufacturer()Ljava/lang/String;
    .locals 1

    .prologue
    .line 133
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->j:Ljava/lang/String;

    return-object v0
.end method

.method public getPlatform()Ljava/lang/String;
    .locals 1

    .prologue
    .line 141
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->k:Ljava/lang/String;

    return-object v0
.end method

.method public getPlatformVersion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 149
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->l:Ljava/lang/String;

    return-object v0
.end method

.method public getPushEnabled()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 125
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->g:Ljava/lang/Boolean;

    return-object v0
.end method

.method public getSessionId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 109
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->d:Ljava/lang/String;

    return-object v0
.end method

.method public getUserId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 101
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->c:Ljava/lang/String;

    return-object v0
.end method

.method public setApiKey(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 89
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->a:Ljava/lang/String;

    .line 90
    return-void
.end method

.method public setAppId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 97
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->b:Ljava/lang/String;

    .line 98
    return-void
.end method

.method public setDeviceId(Ljava/lang/String;)Ljava/lang/String;
    .locals 0

    .prologue
    .line 121
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->f:Ljava/lang/String;

    return-object p1
.end method

.method public setDeviceType(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 161
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->m:Ljava/lang/String;

    .line 162
    return-void
.end method

.method public setLatitude(D)V
    .locals 1

    .prologue
    .line 169
    invoke-static {p1, p2}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v0

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->h:Ljava/lang/Double;

    .line 170
    return-void
.end method

.method public setLongitude(D)V
    .locals 1

    .prologue
    .line 177
    invoke-static {p1, p2}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v0

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->i:Ljava/lang/Double;

    .line 178
    return-void
.end method

.method public setManufacturer(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 137
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->j:Ljava/lang/String;

    .line 138
    return-void
.end method

.method public setPlatform(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 145
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->k:Ljava/lang/String;

    .line 146
    return-void
.end method

.method public setPlatformVersion(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 153
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->l:Ljava/lang/String;

    .line 154
    return-void
.end method

.method public setPushEnabled(Ljava/lang/Boolean;)V
    .locals 0

    .prologue
    .line 129
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->g:Ljava/lang/Boolean;

    .line 130
    return-void
.end method

.method public setSessionId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 113
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->d:Ljava/lang/String;

    .line 114
    return-void
.end method

.method public setUserId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 105
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->c:Ljava/lang/String;

    .line 106
    return-void
.end method
