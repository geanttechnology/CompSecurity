.class public Lcom/exacttarget/etpushsdk/event/RegistrationEvent;
.super Lcom/exacttarget/etpushsdk/data/Registration;
.source "SourceFile"

# interfaces
.implements Lcom/exacttarget/etpushsdk/event/IEventFactory;


# static fields
.field private static final TAG:Ljava/lang/String; = "~!RegistrationEvent"

.field private static final serialVersionUID:J = 0x1L


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 41
    invoke-direct {p0}, Lcom/exacttarget/etpushsdk/data/Registration;-><init>()V

    return-void
.end method


# virtual methods
.method public fromJson(Ljava/lang/String;)Lcom/exacttarget/etpushsdk/event/RegistrationEvent;
    .locals 10

    .prologue
    const/4 v0, 0x0

    .line 86
    :try_start_0
    new-instance v2, Lorg/json/JSONObject;

    invoke-direct {v2, p1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 89
    const-string v1, "platform"

    invoke-virtual {v2, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/exacttarget/etpushsdk/event/RegistrationEvent;->setPlatform(Ljava/lang/String;)V

    .line 92
    const-string v1, "deviceID"

    invoke-virtual {v2, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/exacttarget/etpushsdk/event/RegistrationEvent;->setDeviceId(Ljava/lang/String;)V

    .line 95
    const-string v1, "etAppId"

    invoke-virtual {v2, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/exacttarget/etpushsdk/event/RegistrationEvent;->setEtAppId(Ljava/lang/String;)V

    .line 98
    const-string v1, "badge"

    invoke-virtual {v2, v1}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/exacttarget/etpushsdk/event/RegistrationEvent;->setBadge(Ljava/lang/Integer;)V

    .line 101
    const-string v1, "timeZone"

    invoke-virtual {v2, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/exacttarget/etpushsdk/event/RegistrationEvent;->setTimeZone(Ljava/lang/Integer;)V

    .line 104
    const-string v1, "dST"

    invoke-virtual {v2, v1}, Lorg/json/JSONObject;->getBoolean(Ljava/lang/String;)Z

    move-result v1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/exacttarget/etpushsdk/event/RegistrationEvent;->setDst(Ljava/lang/Boolean;)V

    .line 107
    new-instance v3, Ljava/util/TreeSet;

    invoke-direct {v3}, Ljava/util/TreeSet;-><init>()V

    .line 108
    const-string v1, "tags"

    invoke-virtual {v2, v1}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v4

    .line 109
    if-eqz v4, :cond_0

    .line 110
    invoke-virtual {v4}, Lorg/json/JSONArray;->length()I

    move-result v5

    move v1, v0

    .line 111
    :goto_0
    if-ge v1, v5, :cond_0

    .line 112
    invoke-virtual {v4, v1}, Lorg/json/JSONArray;->get(I)Ljava/lang/Object;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v3, v6}, Ljava/util/TreeSet;->add(Ljava/lang/Object;)Z

    .line 111
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 115
    :cond_0
    invoke-virtual {p0, v3}, Lcom/exacttarget/etpushsdk/event/RegistrationEvent;->setTags(Ljava/util/TreeSet;)V

    .line 118
    const-string v1, "attributes"

    invoke-virtual {v2, v1}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v3

    .line 119
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 121
    if-eqz v3, :cond_1

    .line 122
    invoke-virtual {v3}, Lorg/json/JSONArray;->length()I

    move-result v5

    move v1, v0

    .line 123
    :goto_1
    if-ge v1, v5, :cond_1

    .line 124
    invoke-virtual {v3, v1}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v6

    .line 125
    new-instance v7, Lcom/exacttarget/etpushsdk/data/Attribute;

    const-string v8, "key"

    invoke-virtual {v6, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    const-string v9, "value"

    invoke-virtual {v6, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-direct {v7, v8, v6}, Lcom/exacttarget/etpushsdk/data/Attribute;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 126
    invoke-virtual {v4, v7}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 123
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 129
    :cond_1
    invoke-virtual {p0, v4}, Lcom/exacttarget/etpushsdk/event/RegistrationEvent;->setAttributes(Ljava/util/ArrayList;)V

    .line 132
    const-string v1, "subscriberKey"

    invoke-virtual {v2, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 133
    const-string v1, "subscriberKey"

    invoke-virtual {v2, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/exacttarget/etpushsdk/event/RegistrationEvent;->setSubscriberKey(Ljava/lang/String;)V

    .line 137
    :cond_2
    const-string v1, "hwid"

    invoke-virtual {v2, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/exacttarget/etpushsdk/event/RegistrationEvent;->setHwid(Ljava/lang/String;)V

    .line 140
    const-string v1, "1.0"

    invoke-virtual {p0, v1}, Lcom/exacttarget/etpushsdk/event/RegistrationEvent;->setPlatformVersion(Ljava/lang/String;)V

    .line 141
    const/4 v1, 0x3

    new-array v3, v1, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v4, "platformVersion"

    aput-object v4, v3, v1

    const/4 v1, 0x1

    const-string v4, "platform_Version"

    aput-object v4, v3, v1

    const/4 v1, 0x2

    const-string v4, "platform_version"

    aput-object v4, v3, v1

    .line 142
    array-length v4, v3

    move v1, v0

    :goto_2
    if-ge v1, v4, :cond_3

    aget-object v5, v3, v1

    .line 143
    invoke-virtual {v2, v5}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_7

    .line 144
    const-string v1, "~!RegistrationEvent"

    const-string v3, "Key: %s"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v6, 0x0

    aput-object v5, v4, v6

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v1, v3}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 145
    invoke-virtual {v2, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/exacttarget/etpushsdk/event/RegistrationEvent;->setPlatformVersion(Ljava/lang/String;)V

    .line 150
    :cond_3
    const/4 v1, 0x0

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/exacttarget/etpushsdk/event/RegistrationEvent;->setPushEnabled(Ljava/lang/Boolean;)V

    .line 151
    const/4 v1, 0x3

    new-array v3, v1, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v4, "pushEnabled"

    aput-object v4, v3, v1

    const/4 v1, 0x1

    const-string v4, "push_Enabled"

    aput-object v4, v3, v1

    const/4 v1, 0x2

    const-string v4, "push_enabled"

    aput-object v4, v3, v1

    .line 152
    array-length v4, v3

    move v1, v0

    :goto_3
    if-ge v1, v4, :cond_4

    aget-object v5, v3, v1

    .line 153
    invoke-virtual {v2, v5}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_8

    .line 154
    const-string v1, "~!RegistrationEvent"

    const-string v3, "Key: %s"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v6, 0x0

    aput-object v5, v4, v6

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v1, v3}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 155
    invoke-virtual {v2, v5}, Lorg/json/JSONObject;->getBoolean(Ljava/lang/String;)Z

    move-result v1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/exacttarget/etpushsdk/event/RegistrationEvent;->setPushEnabled(Ljava/lang/Boolean;)V

    .line 160
    :cond_4
    const/4 v1, 0x0

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/exacttarget/etpushsdk/event/RegistrationEvent;->setLocationEnabled(Ljava/lang/Boolean;)V

    .line 161
    const/4 v1, 0x3

    new-array v3, v1, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v4, "locationEnabled"

    aput-object v4, v3, v1

    const/4 v1, 0x1

    const-string v4, "location_Enabled"

    aput-object v4, v3, v1

    const/4 v1, 0x2

    const-string v4, "location_enabled"

    aput-object v4, v3, v1

    .line 162
    array-length v4, v3

    move v1, v0

    :goto_4
    if-ge v1, v4, :cond_5

    aget-object v5, v3, v1

    .line 163
    invoke-virtual {v2, v5}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_9

    .line 164
    const-string v1, "~!RegistrationEvent"

    const-string v3, "Key: %s"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v6, 0x0

    aput-object v5, v4, v6

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v1, v3}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 165
    invoke-virtual {v2, v5}, Lorg/json/JSONObject;->getBoolean(Ljava/lang/String;)Z

    move-result v1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/exacttarget/etpushsdk/event/RegistrationEvent;->setLocationEnabled(Ljava/lang/Boolean;)V

    .line 170
    :cond_5
    const-string v1, "en_US"

    invoke-virtual {p0, v1}, Lcom/exacttarget/etpushsdk/event/RegistrationEvent;->setLanguage(Ljava/lang/String;)V

    .line 171
    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, "language"

    aput-object v4, v1, v3

    const/4 v3, 0x1

    const-string v4, "locale"

    aput-object v4, v1, v3

    .line 172
    array-length v3, v1

    :goto_5
    if-ge v0, v3, :cond_6

    aget-object v4, v1, v0

    .line 173
    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_a

    .line 174
    const-string v0, "~!RegistrationEvent"

    const-string v1, "Key: %s"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object v4, v3, v5

    invoke-static {v1, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 175
    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/exacttarget/etpushsdk/event/RegistrationEvent;->setLanguage(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 182
    :cond_6
    :goto_6
    return-object p0

    .line 142
    :cond_7
    add-int/lit8 v1, v1, 0x1

    goto/16 :goto_2

    .line 152
    :cond_8
    add-int/lit8 v1, v1, 0x1

    goto/16 :goto_3

    .line 162
    :cond_9
    add-int/lit8 v1, v1, 0x1

    goto :goto_4

    .line 172
    :cond_a
    add-int/lit8 v0, v0, 0x1

    goto :goto_5

    .line 180
    :catch_0
    move-exception v0

    .line 181
    const-string v1, "~!RegistrationEvent"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 182
    const/4 p0, 0x0

    goto :goto_6
.end method

.method public bridge synthetic fromJson(Ljava/lang/String;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 41
    invoke-virtual {p0, p1}, Lcom/exacttarget/etpushsdk/event/RegistrationEvent;->fromJson(Ljava/lang/String;)Lcom/exacttarget/etpushsdk/event/RegistrationEvent;

    move-result-object v0

    return-object v0
.end method

.method public setDatabaseIds(Lcom/exacttarget/etpushsdk/event/RegistrationEvent;Ljava/util/List;)V
    .locals 0

    .prologue
    .line 189
    return-void
.end method

.method public bridge synthetic setDatabaseIds(Ljava/lang/Object;Ljava/util/List;)V
    .locals 0

    .prologue
    .line 41
    check-cast p1, Lcom/exacttarget/etpushsdk/event/RegistrationEvent;

    invoke-virtual {p0, p1, p2}, Lcom/exacttarget/etpushsdk/event/RegistrationEvent;->setDatabaseIds(Lcom/exacttarget/etpushsdk/event/RegistrationEvent;Ljava/util/List;)V

    return-void
.end method
