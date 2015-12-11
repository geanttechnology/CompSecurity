.class public Lcom/exacttarget/etpushsdk/data/AnalyticItem;
.super Lcom/exacttarget/etpushsdk/util/g;
.source "SourceFile"


# instance fields
.field private a:Ljava/lang/Integer;

.field private b:Ljava/lang/String;

.field private c:Ljava/lang/String;

.field private d:Ljava/util/Date;

.field private e:Ljava/util/List;

.field private f:Ljava/util/List;

.field private g:Ljava/lang/Integer;

.field private h:Ljava/lang/Long;

.field private i:Ljava/lang/Boolean;

.field private j:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 61
    invoke-direct {p0}, Lcom/exacttarget/etpushsdk/util/g;-><init>()V

    .line 53
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->e:Ljava/util/List;

    .line 54
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->f:Ljava/util/List;

    .line 56
    const-wide/16 v0, 0x0

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->h:Ljava/lang/Long;

    .line 57
    sget-object v0, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->i:Ljava/lang/Boolean;

    .line 62
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->b()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->b:Ljava/lang/String;

    .line 63
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 2

    .prologue
    .line 71
    invoke-direct {p0}, Lcom/exacttarget/etpushsdk/util/g;-><init>()V

    .line 53
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->e:Ljava/util/List;

    .line 54
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->f:Ljava/util/List;

    .line 56
    const-wide/16 v0, 0x0

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->h:Ljava/lang/Long;

    .line 57
    sget-object v0, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->i:Ljava/lang/Boolean;

    .line 72
    invoke-static {p1}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->uniqueDeviceIdentifier(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->c:Ljava/lang/String;

    .line 73
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->b()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->b:Ljava/lang/String;

    .line 74
    return-void
.end method

.method public constructor <init>(Lcom/exacttarget/etpushsdk/data/AnalyticItem;)V
    .locals 2

    .prologue
    .line 66
    invoke-direct {p0}, Lcom/exacttarget/etpushsdk/util/g;-><init>()V

    .line 53
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->e:Ljava/util/List;

    .line 54
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->f:Ljava/util/List;

    .line 56
    const-wide/16 v0, 0x0

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->h:Ljava/lang/Long;

    .line 57
    sget-object v0, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->i:Ljava/lang/Boolean;

    .line 67
    invoke-direct {p0, p1}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->a(Lcom/exacttarget/etpushsdk/data/AnalyticItem;)V

    .line 68
    return-void
.end method

.method private a(Lcom/exacttarget/etpushsdk/data/AnalyticItem;)V
    .locals 1

    .prologue
    .line 77
    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->getEtAppId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->setEtAppId(Ljava/lang/String;)V

    .line 78
    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->getDeviceId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->setDeviceId(Ljava/lang/String;)V

    .line 79
    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->getEventDate()Ljava/util/Date;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->setEventDate(Ljava/util/Date;)V

    .line 80
    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->getAnalyticTypes()Ljava/util/List;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->setAnalyticTypes(Ljava/util/List;)V

    .line 81
    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->getObjectIds()Ljava/util/List;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->setObjectIds(Ljava/util/List;)V

    .line 82
    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->getValue()Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->setValue(Ljava/lang/Integer;)V

    .line 83
    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->getLastSent()Ljava/lang/Long;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->setLastSent(Ljava/lang/Long;)V

    .line 84
    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->getReadyToSend()Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->setReadyToSend(Ljava/lang/Boolean;)V

    .line 85
    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->getPiAppKey()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->setPiAppKey(Ljava/lang/String;)V

    .line 86
    return-void
.end method


# virtual methods
.method public a()Ljava/lang/String;
    .locals 6

    .prologue
    .line 221
    :try_start_0
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    .line 222
    const-string v1, "deviceId"

    iget-object v2, p0, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->c:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 223
    const-string v1, "etAppId"

    iget-object v2, p0, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->b:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 224
    new-instance v1, Ljava/text/SimpleDateFormat;

    const-string v2, "yyyy-MM-dd\'T\'HH:mm:ss.SSS\'Z\'"

    sget-object v3, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-direct {v1, v2, v3}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;Ljava/util/Locale;)V

    .line 225
    const-string v2, "eventDate"

    iget-object v3, p0, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->d:Ljava/util/Date;

    invoke-virtual {v1, v3}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v2, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 226
    const-string v1, "value"

    iget-object v2, p0, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->g:Ljava/lang/Integer;

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 227
    const-string v1, "piAppKey"

    iget-object v2, p0, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->j:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 228
    new-instance v1, Lorg/json/JSONArray;

    iget-object v2, p0, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->f:Ljava/util/List;

    invoke-direct {v1, v2}, Lorg/json/JSONArray;-><init>(Ljava/util/Collection;)V

    .line 229
    const-string v2, "objectIds"

    invoke-virtual {v0, v2, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 230
    new-instance v1, Lorg/json/JSONArray;

    iget-object v2, p0, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->e:Ljava/util/List;

    invoke-direct {v1, v2}, Lorg/json/JSONArray;-><init>(Ljava/util/Collection;)V

    .line 231
    const-string v2, "analyticTypes"

    invoke-virtual {v0, v2, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 232
    invoke-virtual {v0}, Lorg/json/JSONObject;->toString()Ljava/lang/String;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 235
    :goto_0
    return-object v0

    .line 233
    :catch_0
    move-exception v0

    .line 234
    const-string v1, "~!AnalyticItem"

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

    .line 235
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public a(I)V
    .locals 2

    .prologue
    .line 169
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->e:Ljava/util/List;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 170
    return-void
.end method

.method public a(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 173
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->f:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 174
    return-void
.end method

.method public getAnalyticTypes()Ljava/util/List;
    .locals 1

    .prologue
    .line 121
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->e:Ljava/util/List;

    return-object v0
.end method

.method public getDeviceId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 105
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->c:Ljava/lang/String;

    return-object v0
.end method

.method public getEtAppId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 97
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->b:Ljava/lang/String;

    return-object v0
.end method

.method public getEventDate()Ljava/util/Date;
    .locals 1

    .prologue
    .line 113
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->d:Ljava/util/Date;

    return-object v0
.end method

.method public getId()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 89
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->a:Ljava/lang/Integer;

    return-object v0
.end method

.method public getLastSent()Ljava/lang/Long;
    .locals 1

    .prologue
    .line 145
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->h:Ljava/lang/Long;

    return-object v0
.end method

.method public getObjectIds()Ljava/util/List;
    .locals 1

    .prologue
    .line 129
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->f:Ljava/util/List;

    return-object v0
.end method

.method public getPiAppKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 161
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->j:Ljava/lang/String;

    return-object v0
.end method

.method public getReadyToSend()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 153
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->i:Ljava/lang/Boolean;

    return-object v0
.end method

.method public getValue()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 137
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->g:Ljava/lang/Integer;

    return-object v0
.end method

.method public setAnalyticTypes(Ljava/util/List;)V
    .locals 1

    .prologue
    .line 125
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0, p1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->e:Ljava/util/List;

    .line 126
    return-void
.end method

.method public setDeviceId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 109
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->c:Ljava/lang/String;

    .line 110
    return-void
.end method

.method public setEtAppId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 101
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->b:Ljava/lang/String;

    .line 102
    return-void
.end method

.method public setEventDate(Ljava/util/Date;)V
    .locals 0

    .prologue
    .line 117
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->d:Ljava/util/Date;

    .line 118
    return-void
.end method

.method public setId(Ljava/lang/Integer;)V
    .locals 0

    .prologue
    .line 93
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->a:Ljava/lang/Integer;

    .line 94
    return-void
.end method

.method public setLastSent(Ljava/lang/Long;)V
    .locals 0

    .prologue
    .line 149
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->h:Ljava/lang/Long;

    .line 150
    return-void
.end method

.method public setObjectIds(Ljava/util/List;)V
    .locals 1

    .prologue
    .line 133
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0, p1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->f:Ljava/util/List;

    .line 134
    return-void
.end method

.method public setPiAppKey(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 165
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->j:Ljava/lang/String;

    .line 166
    return-void
.end method

.method public setReadyToSend(Ljava/lang/Boolean;)V
    .locals 0

    .prologue
    .line 157
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->i:Ljava/lang/Boolean;

    .line 158
    return-void
.end method

.method public setValue(Ljava/lang/Integer;)V
    .locals 0

    .prologue
    .line 141
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->g:Ljava/lang/Integer;

    .line 142
    return-void
.end method
