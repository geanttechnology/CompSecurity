.class public Lcom/exacttarget/etpushsdk/data/Registration;
.super Lcom/exacttarget/etpushsdk/util/g;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final ET_ATTRIBUTES_CACHE:Ljava/lang/String; = "et_attributes_cache"

.field public static final ET_DEVICE_ID_CACHE:Ljava/lang/String; = "et_device_id_cache"

.field public static final ET_MANUFACTURER_CACHE:Ljava/lang/String; = "et_manufacturer_cache"

.field public static final ET_MODEL_CACHE:Ljava/lang/String; = "et_model_cache"

.field public static final ET_PLATFORM_CACHE:Ljava/lang/String; = "et_platform_cache"

.field public static final ET_PLATFORM_VERSION_CACHE:Ljava/lang/String; = "et_platform_version_cache"

.field private static final ET_REGISTRATION_CACHE:Ljava/lang/String; = "et_registration_cache"

.field private static final ET_SEPARATOR:Ljava/lang/String; = "^|^"

.field private static final ET_SPLITTER:Ljava/lang/String; = "\\^\\|\\^"

.field public static final ET_SUBSCRIBER_CACHE:Ljava/lang/String; = "et_subscriber_cache"

.field private static final ET_TAGS_CACHE:Ljava/lang/String; = "et_tags_cache"

.field private static final GEO_ENABLED_KEY:Ljava/lang/String; = "et_geo_enabled_key"

.field protected static final JF_APP_VERSION:Ljava/lang/String; = "app_version"

.field protected static final JF_ATTRIBUTES:Ljava/lang/String; = "attributes"

.field protected static final JF_BADGE:Ljava/lang/String; = "badge"

.field protected static final JF_DEVICE_ID:Ljava/lang/String; = "deviceID"

.field protected static final JF_DEVICE_TOKEN:Ljava/lang/String; = "device_Token"

.field protected static final JF_DST:Ljava/lang/String; = "dST"

.field protected static final JF_ET_APP_ID:Ljava/lang/String; = "etAppId"

.field protected static final JF_GCM_SENDER_ID:Ljava/lang/String; = "gcmSenderId"

.field protected static final JF_HWID:Ljava/lang/String; = "hwid"

.field protected static final JF_KEY:Ljava/lang/String; = "key"

.field protected static final JF_LOCALE:Ljava/lang/String; = "locale"

.field protected static final JF_LOCATION_ENABLED:Ljava/lang/String; = "location_enabled"

.field protected static final JF_PLATFORM:Ljava/lang/String; = "platform"

.field protected static final JF_PLATFORM_VERSION:Ljava/lang/String; = "platform_Version"

.field protected static final JF_PUSH_ENABLED:Ljava/lang/String; = "push_enabled"

.field protected static final JF_SDK_VERSION:Ljava/lang/String; = "sdk_version"

.field protected static final JF_SUBSCRIBER_KEY:Ljava/lang/String; = "subscriberKey"

.field protected static final JF_TAGS:Ljava/lang/String; = "tags"

.field protected static final JF_TIME_ZONE:Ljava/lang/String; = "timeZone"

.field protected static final JF_VALUE:Ljava/lang/String; = "value"

.field public static final SYSTEM_TOKEN_KEY:Ljava/lang/String; = "gcm_reg_id_key"

.field public static final TAG:Ljava/lang/String; = "~!Registration"

.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private attributes:Ljava/util/ArrayList;

.field private badge:Ljava/lang/Integer;

.field private deviceId:Ljava/lang/String;

.field private dst:Ljava/lang/Boolean;

.field private email:Ljava/lang/String;

.field private etAppId:Ljava/lang/String;

.field private gcmSenderId:Ljava/lang/String;

.field private hwid:Ljava/lang/String;

.field private id:Ljava/lang/Integer;

.field private language:Ljava/lang/String;

.field private lastSent:Ljava/lang/Long;

.field private locale:Ljava/lang/String;

.field private locationEnabled:Ljava/lang/Boolean;

.field private platform:Ljava/lang/String;

.field private platformVersion:Ljava/lang/String;

.field private pushEnabled:Ljava/lang/Boolean;

.field private subscriberKey:Ljava/lang/String;

.field private tags:Ljava/util/TreeSet;

.field private timeZone:Ljava/lang/Integer;


# direct methods
.method public constructor <init>()V
    .locals 8

    .prologue
    const/4 v7, 0x0

    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 106
    invoke-direct {p0}, Lcom/exacttarget/etpushsdk/util/g;-><init>()V

    .line 100
    const-wide/16 v0, 0x0

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/Registration;->lastSent:Ljava/lang/Long;

    .line 107
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/data/Registration;->uniqueDeviceIdentifier(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/Registration;->deviceId:Ljava/lang/String;

    .line 108
    invoke-static {}, Ljava/util/TimeZone;->getDefault()Ljava/util/TimeZone;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/TimeZone;->getRawOffset()I

    move-result v0

    div-int/lit16 v0, v0, 0x3e8

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/Registration;->timeZone:Ljava/lang/Integer;

    .line 109
    invoke-static {}, Ljava/util/TimeZone;->getDefault()Ljava/util/TimeZone;

    move-result-object v0

    new-instance v1, Ljava/util/Date;

    invoke-direct {v1}, Ljava/util/Date;-><init>()V

    invoke-virtual {v0, v1}, Ljava/util/TimeZone;->inDaylightTime(Ljava/util/Date;)Z

    move-result v0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/Registration;->dst:Ljava/lang/Boolean;

    .line 110
    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/Locale;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/Registration;->locale:Ljava/lang/String;

    .line 112
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->b()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/exacttarget/etpushsdk/data/Registration;->setEtAppId(Ljava/lang/String;)V

    .line 113
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->d()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/exacttarget/etpushsdk/data/Registration;->setGcmSenderId(Ljava/lang/String;)V

    .line 115
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v0

    const-string v1, "et_geo_enabled_key"

    invoke-static {v6}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    new-array v3, v5, [Ljava/lang/Object;

    invoke-static {v0, v1, v2, v3}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/exacttarget/etpushsdk/data/Registration;->setLocationEnabled(Ljava/lang/Boolean;)V

    .line 118
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v0

    const-string v1, "et_tags_cache"

    new-array v2, v6, [Ljava/lang/Object;

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v3

    const-string v4, "et_registration_cache"

    invoke-virtual {v3, v4, v5}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v3

    aput-object v3, v2, v5

    invoke-static {v0, v1, v7, v2}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 119
    invoke-static {v0}, Lcom/exacttarget/etpushsdk/data/Registration;->deserializeTags(Ljava/lang/String;)Ljava/util/TreeSet;

    move-result-object v0

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/Registration;->tags:Ljava/util/TreeSet;

    .line 121
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/b;->a()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 122
    const-string v0, "Amazon"

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/Registration;->platform:Ljava/lang/String;

    .line 123
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Registration;->tags:Ljava/util/TreeSet;

    const-string v1, "Amazon"

    invoke-virtual {v0, v1}, Ljava/util/TreeSet;->add(Ljava/lang/Object;)Z

    .line 129
    :goto_0
    sget-object v0, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/Registration;->platformVersion:Ljava/lang/String;

    .line 131
    const-string v0, "~!Registration"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Platform: \""

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/exacttarget/etpushsdk/data/Registration;->platform:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\", platformVersion: \""

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/exacttarget/etpushsdk/data/Registration;->platformVersion:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\""

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 134
    sget-object v0, Landroid/os/Build;->MANUFACTURER:Ljava/lang/String;

    .line 135
    sget-object v1, Landroid/os/Build;->MODEL:Ljava/lang/String;

    .line 136
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const/16 v3, 0x20

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/exacttarget/etpushsdk/data/Registration;->hwid:Ljava/lang/String;

    .line 137
    const-string v2, "~!Registration"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "hwid: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/exacttarget/etpushsdk/data/Registration;->hwid:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 139
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v2

    const-string v3, "et_device_id_cache"

    iget-object v4, p0, Lcom/exacttarget/etpushsdk/data/Registration;->deviceId:Ljava/lang/String;

    invoke-static {v2, v3, v4}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    .line 140
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v2

    const-string v3, "et_manufacturer_cache"

    invoke-static {v2, v3, v0}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    .line 141
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v0

    const-string v2, "et_platform_cache"

    iget-object v3, p0, Lcom/exacttarget/etpushsdk/data/Registration;->platform:Ljava/lang/String;

    invoke-static {v0, v2, v3}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    .line 142
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v0

    const-string v2, "et_platform_version_cache"

    iget-object v3, p0, Lcom/exacttarget/etpushsdk/data/Registration;->platformVersion:Ljava/lang/String;

    invoke-static {v0, v2, v3}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    .line 143
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v0

    const-string v2, "et_model_cache"

    invoke-static {v0, v2, v1}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    .line 145
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/util/n;->a(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 146
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Registration;->tags:Ljava/util/TreeSet;

    const-string v1, "Debug"

    invoke-virtual {v0, v1}, Ljava/util/TreeSet;->add(Ljava/lang/Object;)Z

    .line 149
    :cond_0
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Registration;->tags:Ljava/util/TreeSet;

    const-string v1, "ALL"

    invoke-virtual {v0, v1}, Ljava/util/TreeSet;->add(Ljava/lang/Object;)Z

    .line 151
    invoke-direct {p0}, Lcom/exacttarget/etpushsdk/data/Registration;->saveTagsToPrefs()V

    .line 153
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v0

    const-string v1, "et_attributes_cache"

    new-array v2, v6, [Ljava/lang/Object;

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v3

    const-string v4, "et_registration_cache"

    invoke-virtual {v3, v4, v5}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v3

    aput-object v3, v2, v5

    invoke-static {v0, v1, v7, v2}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 154
    invoke-static {v0}, Lcom/exacttarget/etpushsdk/data/Registration;->deserializeAttributes(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/Registration;->attributes:Ljava/util/ArrayList;

    .line 156
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Registration;->attributes:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/exacttarget/etpushsdk/data/Attribute;

    .line 157
    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/Attribute;->getKey()Ljava/lang/String;

    move-result-object v2

    const-string v3, "_ETSDKVersion"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 158
    iget-object v1, p0, Lcom/exacttarget/etpushsdk/data/Registration;->attributes:Ljava/util/ArrayList;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 162
    :cond_2
    invoke-direct {p0}, Lcom/exacttarget/etpushsdk/data/Registration;->saveAttributesToPrefs()V

    .line 164
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v0

    const-string v1, "et_subscriber_cache"

    new-array v2, v6, [Ljava/lang/Object;

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v3

    const-string v4, "et_registration_cache"

    invoke-virtual {v3, v4, v5}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v3

    aput-object v3, v2, v5

    invoke-static {v0, v1, v7, v2}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/Registration;->subscriberKey:Ljava/lang/String;

    .line 166
    const-string v0, "~!Registration"

    const-string v1, "Registration() initialization complete"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 168
    return-void

    .line 125
    :cond_3
    const-string v0, "Android"

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/Registration;->platform:Ljava/lang/String;

    .line 126
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Registration;->tags:Ljava/util/TreeSet;

    const-string v1, "Android"

    invoke-virtual {v0, v1}, Ljava/util/TreeSet;->add(Ljava/lang/Object;)Z

    goto/16 :goto_0
.end method

.method public static deserializeAttributes(Ljava/lang/String;)Ljava/util/ArrayList;
    .locals 6

    .prologue
    .line 186
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 187
    if-eqz p0, :cond_3

    .line 188
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_3

    .line 190
    const-string v0, "\\^\\|\\^"

    invoke-virtual {p0, v0}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v2

    .line 191
    const/4 v0, 0x0

    :goto_0
    array-length v3, v2

    if-ge v0, v3, :cond_3

    .line 192
    :goto_1
    aget-object v3, v2, v0

    if-eqz v3, :cond_0

    aget-object v3, v2, v0

    invoke-virtual {v3}, Ljava/lang/String;->isEmpty()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 193
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 196
    :cond_1
    add-int/lit8 v3, v0, 0x1

    array-length v4, v2

    if-lt v3, v4, :cond_2

    .line 197
    new-instance v3, Lcom/exacttarget/etpushsdk/data/Attribute;

    aget-object v4, v2, v0

    const-string v5, ""

    invoke-direct {v3, v4, v5}, Lcom/exacttarget/etpushsdk/data/Attribute;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 191
    :goto_2
    add-int/lit8 v0, v0, 0x2

    goto :goto_0

    .line 199
    :cond_2
    new-instance v3, Lcom/exacttarget/etpushsdk/data/Attribute;

    aget-object v4, v2, v0

    add-int/lit8 v5, v0, 0x1

    aget-object v5, v2, v5

    invoke-direct {v3, v4, v5}, Lcom/exacttarget/etpushsdk/data/Attribute;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_2

    .line 205
    :cond_3
    return-object v1
.end method

.method public static deserializeTags(Ljava/lang/String;)Ljava/util/TreeSet;
    .locals 6

    .prologue
    .line 222
    new-instance v1, Ljava/util/TreeSet;

    invoke-direct {v1}, Ljava/util/TreeSet;-><init>()V

    .line 223
    if-eqz p0, :cond_1

    .line 224
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 226
    const-string v0, "\\^\\|\\^"

    invoke-virtual {p0, v0}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v2

    .line 227
    array-length v3, v2

    const/4 v0, 0x0

    :goto_0
    if-ge v0, v3, :cond_1

    aget-object v4, v2, v0

    .line 228
    if-eqz v4, :cond_0

    invoke-virtual {v4}, Ljava/lang/String;->isEmpty()Z

    move-result v5

    if-nez v5, :cond_0

    .line 229
    invoke-virtual {v1, v4}, Ljava/util/TreeSet;->add(Ljava/lang/Object;)Z

    .line 227
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 235
    :cond_1
    return-object v1
.end method

.method private saveAttributesToPrefs()V
    .locals 3

    .prologue
    .line 267
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v0

    const-string v1, "et_attributes_cache"

    iget-object v2, p0, Lcom/exacttarget/etpushsdk/data/Registration;->attributes:Ljava/util/ArrayList;

    invoke-static {v2}, Lcom/exacttarget/etpushsdk/data/Registration;->serializeAttributes(Ljava/util/ArrayList;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    .line 268
    return-void
.end method

.method private saveTagsToPrefs()V
    .locals 3

    .prologue
    .line 281
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v0

    const-string v1, "et_tags_cache"

    iget-object v2, p0, Lcom/exacttarget/etpushsdk/data/Registration;->tags:Ljava/util/TreeSet;

    invoke-static {v2}, Lcom/exacttarget/etpushsdk/data/Registration;->serializeTags(Ljava/util/TreeSet;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    .line 282
    return-void
.end method

.method public static serializeAttributes(Ljava/util/ArrayList;)Ljava/lang/String;
    .locals 4

    .prologue
    .line 171
    if-nez p0, :cond_0

    .line 172
    const/4 v0, 0x0

    .line 182
    :goto_0
    return-object v0

    .line 174
    :cond_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 175
    invoke-virtual {p0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/exacttarget/etpushsdk/data/Attribute;

    .line 176
    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/Attribute;->getKey()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 177
    const-string v3, "^|^"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 178
    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/Attribute;->getValue()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 179
    const-string v0, "^|^"

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_1

    .line 182
    :cond_1
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public static serializeTags(Ljava/util/TreeSet;)Ljava/lang/String;
    .locals 3

    .prologue
    .line 209
    if-nez p0, :cond_0

    .line 210
    const/4 v0, 0x0

    .line 218
    :goto_0
    return-object v0

    .line 212
    :cond_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 213
    invoke-virtual {p0}, Ljava/util/TreeSet;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 214
    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 215
    const-string v0, "^|^"

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_1

    .line 218
    :cond_1
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method


# virtual methods
.method public addAttribute(Lcom/exacttarget/etpushsdk/data/Attribute;)V
    .locals 1

    .prologue
    .line 252
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Registration;->attributes:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 253
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Registration;->attributes:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 255
    :cond_0
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Registration;->attributes:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 256
    invoke-direct {p0}, Lcom/exacttarget/etpushsdk/data/Registration;->saveAttributesToPrefs()V

    .line 257
    return-void
.end method

.method public addTag(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 271
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Registration;->tags:Ljava/util/TreeSet;

    invoke-virtual {v0, p1}, Ljava/util/TreeSet;->add(Ljava/lang/Object;)Z

    .line 272
    invoke-direct {p0}, Lcom/exacttarget/etpushsdk/data/Registration;->saveTagsToPrefs()V

    .line 273
    return-void
.end method

.method public getAttributes()Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 357
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Registration;->attributes:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getBadge()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 317
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Registration;->badge:Ljava/lang/Integer;

    return-object v0
.end method

.method public getDeviceId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 301
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Registration;->deviceId:Ljava/lang/String;

    return-object v0
.end method

.method public getDst()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 341
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Registration;->dst:Ljava/lang/Boolean;

    return-object v0
.end method

.method public getEmail()Ljava/lang/String;
    .locals 1

    .prologue
    .line 325
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Registration;->email:Ljava/lang/String;

    return-object v0
.end method

.method public getEtAppId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 309
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Registration;->etAppId:Ljava/lang/String;

    return-object v0
.end method

.method public getGcmSenderId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 416
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Registration;->gcmSenderId:Ljava/lang/String;

    return-object v0
.end method

.method public getHwid()Ljava/lang/String;
    .locals 1

    .prologue
    .line 408
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Registration;->hwid:Ljava/lang/String;

    return-object v0
.end method

.method public getId()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 285
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Registration;->id:Ljava/lang/Integer;

    return-object v0
.end method

.method public getLanguage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 239
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Registration;->language:Ljava/lang/String;

    return-object v0
.end method

.method public getLastSent()Ljava/lang/Long;
    .locals 1

    .prologue
    .line 400
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Registration;->lastSent:Ljava/lang/Long;

    return-object v0
.end method

.method public getLocale()Ljava/lang/String;
    .locals 1

    .prologue
    .line 425
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Registration;->locale:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 426
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Registration;->language:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 427
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Registration;->language:Ljava/lang/String;

    .line 430
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Registration;->locale:Ljava/lang/String;

    goto :goto_0
.end method

.method public getLocationEnabled()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 391
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Registration;->locationEnabled:Ljava/lang/Boolean;

    return-object v0
.end method

.method public getPlatform()Ljava/lang/String;
    .locals 1

    .prologue
    .line 293
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Registration;->platform:Ljava/lang/String;

    return-object v0
.end method

.method public getPlatformVersion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 365
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Registration;->platformVersion:Ljava/lang/String;

    return-object v0
.end method

.method public getPushEnabled()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 382
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Registration;->pushEnabled:Ljava/lang/Boolean;

    return-object v0
.end method

.method public getSubscriberKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 373
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Registration;->subscriberKey:Ljava/lang/String;

    return-object v0
.end method

.method public getSystemToken()Ljava/lang/String;
    .locals 1

    .prologue
    .line 248
    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Registration;->getSystemTokenFromCache()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getSystemTokenFromCache()Ljava/lang/String;
    .locals 7

    .prologue
    const/4 v6, 0x0

    .line 521
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v0

    const-string v1, "gcm_reg_id_key"

    const/4 v2, 0x0

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v4

    const-string v5, "~!Registration"

    invoke-virtual {v4, v5, v6}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v4

    aput-object v4, v3, v6

    invoke-static {v0, v1, v2, v3}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    return-object v0
.end method

.method public getTags()Ljava/util/TreeSet;
    .locals 1

    .prologue
    .line 349
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Registration;->tags:Ljava/util/TreeSet;

    return-object v0
.end method

.method public getTimeZone()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 333
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Registration;->timeZone:Ljava/lang/Integer;

    return-object v0
.end method

.method public removeAttribute(Lcom/exacttarget/etpushsdk/data/Attribute;)V
    .locals 1

    .prologue
    .line 260
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Registration;->attributes:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 261
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Registration;->attributes:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 263
    :cond_0
    invoke-direct {p0}, Lcom/exacttarget/etpushsdk/data/Registration;->saveAttributesToPrefs()V

    .line 264
    return-void
.end method

.method public removeTag(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 276
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Registration;->tags:Ljava/util/TreeSet;

    invoke-virtual {v0, p1}, Ljava/util/TreeSet;->remove(Ljava/lang/Object;)Z

    .line 277
    invoke-direct {p0}, Lcom/exacttarget/etpushsdk/data/Registration;->saveTagsToPrefs()V

    .line 278
    return-void
.end method

.method public setAttributes(Ljava/util/ArrayList;)V
    .locals 0

    .prologue
    .line 361
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Registration;->attributes:Ljava/util/ArrayList;

    .line 362
    return-void
.end method

.method public setBadge(Ljava/lang/Integer;)V
    .locals 0

    .prologue
    .line 321
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Registration;->badge:Ljava/lang/Integer;

    .line 322
    return-void
.end method

.method public setDeviceId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 305
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Registration;->deviceId:Ljava/lang/String;

    .line 306
    return-void
.end method

.method public setDst(Ljava/lang/Boolean;)V
    .locals 0

    .prologue
    .line 345
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Registration;->dst:Ljava/lang/Boolean;

    .line 346
    return-void
.end method

.method public setEmail(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 329
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Registration;->email:Ljava/lang/String;

    .line 330
    return-void
.end method

.method public setEtAppId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 313
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Registration;->etAppId:Ljava/lang/String;

    .line 314
    return-void
.end method

.method public setGcmSenderId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 420
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Registration;->gcmSenderId:Ljava/lang/String;

    .line 421
    return-void
.end method

.method public setHwid(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 412
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Registration;->hwid:Ljava/lang/String;

    .line 413
    return-void
.end method

.method public setId(Ljava/lang/Integer;)V
    .locals 0

    .prologue
    .line 289
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Registration;->id:Ljava/lang/Integer;

    .line 290
    return-void
.end method

.method public setLanguage(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 243
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Registration;->language:Ljava/lang/String;

    .line 244
    return-void
.end method

.method public setLastSent(Ljava/lang/Long;)V
    .locals 0

    .prologue
    .line 404
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Registration;->lastSent:Ljava/lang/Long;

    .line 405
    return-void
.end method

.method public setLocale(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 434
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Registration;->locale:Ljava/lang/String;

    .line 435
    return-void
.end method

.method public setLocationEnabled(Ljava/lang/Boolean;)V
    .locals 0

    .prologue
    .line 396
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Registration;->locationEnabled:Ljava/lang/Boolean;

    .line 397
    return-void
.end method

.method public setPlatform(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 297
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Registration;->platform:Ljava/lang/String;

    .line 298
    return-void
.end method

.method public setPlatformVersion(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 369
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Registration;->platformVersion:Ljava/lang/String;

    .line 370
    return-void
.end method

.method public setPushEnabled(Ljava/lang/Boolean;)V
    .locals 0

    .prologue
    .line 386
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Registration;->pushEnabled:Ljava/lang/Boolean;

    .line 387
    return-void
.end method

.method public setSubscriberKey(Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 377
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Registration;->subscriberKey:Ljava/lang/String;

    .line 378
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v0

    const-string v1, "et_subscriber_cache"

    iget-object v2, p0, Lcom/exacttarget/etpushsdk/data/Registration;->subscriberKey:Ljava/lang/String;

    invoke-static {v0, v1, v2}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    .line 379
    return-void
.end method

.method public setSystemTokenInCache(Ljava/lang/String;)V
    .locals 6

    .prologue
    .line 529
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/n;->a()I

    move-result v0

    .line 530
    const-string v1, "~!Registration"

    const-string v2, "Saving regId and app version code : %1$s "

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 532
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v1

    const-string v2, "gcm_reg_id_key"

    invoke-static {v1, v2, p1}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    .line 533
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v1

    const-string v2, "gcm_app_version_key"

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Integer;)V

    .line 534
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v0

    const-string v1, "gcm_sender_id_key"

    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->d()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    .line 535
    return-void
.end method

.method public setTags(Ljava/util/TreeSet;)V
    .locals 0

    .prologue
    .line 353
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Registration;->tags:Ljava/util/TreeSet;

    .line 354
    return-void
.end method

.method public setTimeZone(Ljava/lang/Integer;)V
    .locals 0

    .prologue
    .line 337
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Registration;->timeZone:Ljava/lang/Integer;

    .line 338
    return-void
.end method

.method public toJson()Ljava/lang/String;
    .locals 9

    .prologue
    const/4 v8, 0x1

    const/4 v7, 0x0

    .line 475
    :try_start_0
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    .line 476
    const-string v0, "deviceID"

    iget-object v2, p0, Lcom/exacttarget/etpushsdk/data/Registration;->deviceId:Ljava/lang/String;

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 477
    const-string v0, "device_Token"

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Registration;->getSystemTokenFromCache()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 478
    const-string v0, "sdk_version"

    invoke-static {}, Lcom/exacttarget/etpushsdk/util/o;->a()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 479
    const-string v0, "app_version"

    const-string v2, "%1$s : %2$s"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {}, Lcom/exacttarget/etpushsdk/util/n;->b()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    invoke-static {}, Lcom/exacttarget/etpushsdk/util/n;->a()I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 480
    const-string v0, "gcmSenderId"

    iget-object v2, p0, Lcom/exacttarget/etpushsdk/data/Registration;->gcmSenderId:Ljava/lang/String;

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 481
    const-string v0, "dST"

    iget-object v2, p0, Lcom/exacttarget/etpushsdk/data/Registration;->dst:Ljava/lang/Boolean;

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 482
    const-string v0, "location_enabled"

    iget-object v2, p0, Lcom/exacttarget/etpushsdk/data/Registration;->locationEnabled:Ljava/lang/Boolean;

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 483
    const-string v0, "platform_Version"

    iget-object v2, p0, Lcom/exacttarget/etpushsdk/data/Registration;->platformVersion:Ljava/lang/String;

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 484
    const-string v0, "push_enabled"

    iget-object v2, p0, Lcom/exacttarget/etpushsdk/data/Registration;->pushEnabled:Ljava/lang/Boolean;

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 485
    const-string v0, "timeZone"

    iget-object v2, p0, Lcom/exacttarget/etpushsdk/data/Registration;->timeZone:Ljava/lang/Integer;

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 487
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Registration;->subscriberKey:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 488
    const-string v0, "subscriberKey"

    iget-object v2, p0, Lcom/exacttarget/etpushsdk/data/Registration;->subscriberKey:Ljava/lang/String;

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 491
    :cond_0
    const-string v0, "platform"

    iget-object v2, p0, Lcom/exacttarget/etpushsdk/data/Registration;->platform:Ljava/lang/String;

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 492
    const-string v0, "hwid"

    iget-object v2, p0, Lcom/exacttarget/etpushsdk/data/Registration;->hwid:Ljava/lang/String;

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 493
    const-string v0, "etAppId"

    iget-object v2, p0, Lcom/exacttarget/etpushsdk/data/Registration;->etAppId:Ljava/lang/String;

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 494
    const-string v0, "badge"

    iget-object v2, p0, Lcom/exacttarget/etpushsdk/data/Registration;->badge:Ljava/lang/Integer;

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 495
    const-string v0, "locale"

    iget-object v2, p0, Lcom/exacttarget/etpushsdk/data/Registration;->locale:Ljava/lang/String;

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 496
    new-instance v0, Lorg/json/JSONArray;

    iget-object v2, p0, Lcom/exacttarget/etpushsdk/data/Registration;->tags:Ljava/util/TreeSet;

    invoke-direct {v0, v2}, Lorg/json/JSONArray;-><init>(Ljava/util/Collection;)V

    .line 497
    const-string v2, "tags"

    invoke-virtual {v1, v2, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 499
    new-instance v2, Lorg/json/JSONArray;

    invoke-direct {v2}, Lorg/json/JSONArray;-><init>()V

    .line 500
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Registration;->attributes:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/exacttarget/etpushsdk/data/Attribute;

    .line 501
    new-instance v4, Lorg/json/JSONObject;

    invoke-direct {v4}, Lorg/json/JSONObject;-><init>()V

    .line 502
    const-string v5, "key"

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/Attribute;->getKey()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v5, v6}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 503
    const-string v5, "value"

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/Attribute;->getValue()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v4, v5, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 504
    invoke-virtual {v2, v4}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 508
    :catch_0
    move-exception v0

    .line 509
    const-string v1, "~!Registration"

    const-string v2, "Error converting Registration to JSON: %1$s"

    new-array v3, v8, [Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v7

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 510
    const/4 v0, 0x0

    :goto_1
    return-object v0

    .line 506
    :cond_1
    :try_start_1
    const-string v0, "attributes"

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 507
    invoke-virtual {v1}, Lorg/json/JSONObject;->toString()Ljava/lang/String;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    move-result-object v0

    goto :goto_1
.end method
