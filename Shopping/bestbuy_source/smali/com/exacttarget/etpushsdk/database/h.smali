.class public Lcom/exacttarget/etpushsdk/database/h;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field public static final a:[Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 18
    const/16 v0, 0x12

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "id"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string v2, "platform"

    aput-object v2, v0, v1

    const/4 v1, 0x2

    const-string v2, "device_id"

    aput-object v2, v0, v1

    const/4 v1, 0x3

    const-string v2, "subscriber_key"

    aput-object v2, v0, v1

    const/4 v1, 0x4

    const-string v2, "et_app_id"

    aput-object v2, v0, v1

    const/4 v1, 0x5

    const-string v2, "email"

    aput-object v2, v0, v1

    const/4 v1, 0x6

    const-string v2, "badge"

    aput-object v2, v0, v1

    const/4 v1, 0x7

    const-string v2, "timezone"

    aput-object v2, v0, v1

    const/16 v1, 0x8

    const-string v2, "dst"

    aput-object v2, v0, v1

    const/16 v1, 0x9

    const-string v2, "tags"

    aput-object v2, v0, v1

    const/16 v1, 0xa

    const-string v2, "attributes"

    aput-object v2, v0, v1

    const/16 v1, 0xb

    const-string v2, "platform_version"

    aput-object v2, v0, v1

    const/16 v1, 0xc

    const-string v2, "push_enabled"

    aput-object v2, v0, v1

    const/16 v1, 0xd

    const-string v2, "location_enabled"

    aput-object v2, v0, v1

    const/16 v1, 0xe

    const-string v2, "last_sent"

    aput-object v2, v0, v1

    const/16 v1, 0xf

    const-string v2, "hwid"

    aput-object v2, v0, v1

    const/16 v1, 0x10

    const-string v2, "gcm_sender_id"

    aput-object v2, v0, v1

    const/16 v1, 0x11

    const-string v2, "locale"

    aput-object v2, v0, v1

    sput-object v0, Lcom/exacttarget/etpushsdk/database/h;->a:[Ljava/lang/String;

    return-void
.end method

.method public static a(Ljava/lang/String;[Ljava/lang/String;)I
    .locals 2

    .prologue
    .line 76
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/i;->a()Lcom/exacttarget/etpushsdk/util/i;

    move-result-object v0

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/util/i;->b()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    const-string v1, "registration"

    invoke-virtual {v0, v1, p0, p1}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method public static a()Lcom/exacttarget/etpushsdk/data/Registration;
    .locals 9

    .prologue
    const/4 v3, 0x0

    .line 45
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/i;->a()Lcom/exacttarget/etpushsdk/util/i;

    move-result-object v0

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/util/i;->b()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    const-string v1, "registration"

    sget-object v2, Lcom/exacttarget/etpushsdk/database/h;->a:[Ljava/lang/String;

    const-string v7, "id DESC "

    const-string v8, "1"

    move-object v4, v3

    move-object v5, v3

    move-object v6, v3

    invoke-virtual/range {v0 .. v8}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 57
    if-eqz v0, :cond_1

    .line 58
    invoke-interface {v0}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 59
    invoke-static {v0}, Lcom/exacttarget/etpushsdk/database/h;->a(Landroid/database/Cursor;)Lcom/exacttarget/etpushsdk/data/Registration;

    move-result-object v3

    .line 61
    :cond_0
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .line 64
    :cond_1
    return-object v3
.end method

.method public static a(Landroid/database/Cursor;)Lcom/exacttarget/etpushsdk/data/Registration;
    .locals 5

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x1

    .line 95
    new-instance v3, Lcom/exacttarget/etpushsdk/data/Registration;

    invoke-direct {v3}, Lcom/exacttarget/etpushsdk/data/Registration;-><init>()V

    .line 96
    const-string v0, "id"

    invoke-interface {p0, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p0, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v3, v0}, Lcom/exacttarget/etpushsdk/data/Registration;->setId(Ljava/lang/Integer;)V

    .line 97
    const-string v0, "platform"

    invoke-interface {p0, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p0, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Lcom/exacttarget/etpushsdk/data/Registration;->setPlatform(Ljava/lang/String;)V

    .line 98
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v0

    const-string v4, "device_id"

    invoke-interface {p0, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {p0, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-static {v0, v4}, Lcom/exacttarget/etpushsdk/util/a;->b(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Lcom/exacttarget/etpushsdk/data/Registration;->setDeviceId(Ljava/lang/String;)V

    .line 99
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v0

    const-string v4, "subscriber_key"

    invoke-interface {p0, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {p0, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-static {v0, v4}, Lcom/exacttarget/etpushsdk/util/a;->b(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Lcom/exacttarget/etpushsdk/data/Registration;->setSubscriberKey(Ljava/lang/String;)V

    .line 100
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v0

    const-string v4, "et_app_id"

    invoke-interface {p0, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {p0, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-static {v0, v4}, Lcom/exacttarget/etpushsdk/util/a;->b(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Lcom/exacttarget/etpushsdk/data/Registration;->setEtAppId(Ljava/lang/String;)V

    .line 101
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v0

    const-string v4, "email"

    invoke-interface {p0, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {p0, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-static {v0, v4}, Lcom/exacttarget/etpushsdk/util/a;->b(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Lcom/exacttarget/etpushsdk/data/Registration;->setEmail(Ljava/lang/String;)V

    .line 102
    const-string v0, "badge"

    invoke-interface {p0, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p0, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v3, v0}, Lcom/exacttarget/etpushsdk/data/Registration;->setBadge(Ljava/lang/Integer;)V

    .line 103
    const-string v0, "timezone"

    invoke-interface {p0, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p0, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v3, v0}, Lcom/exacttarget/etpushsdk/data/Registration;->setTimeZone(Ljava/lang/Integer;)V

    .line 104
    const-string v0, "dst"

    invoke-interface {p0, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p0, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    if-ne v0, v1, :cond_0

    move v0, v1

    :goto_0
    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v3, v0}, Lcom/exacttarget/etpushsdk/data/Registration;->setDst(Ljava/lang/Boolean;)V

    .line 105
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v0

    const-string v4, "tags"

    invoke-interface {p0, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {p0, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-static {v0, v4}, Lcom/exacttarget/etpushsdk/util/a;->b(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/data/Registration;->deserializeTags(Ljava/lang/String;)Ljava/util/TreeSet;

    move-result-object v0

    invoke-virtual {v3, v0}, Lcom/exacttarget/etpushsdk/data/Registration;->setTags(Ljava/util/TreeSet;)V

    .line 106
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v0

    const-string v4, "attributes"

    invoke-interface {p0, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {p0, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-static {v0, v4}, Lcom/exacttarget/etpushsdk/util/a;->b(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/data/Registration;->deserializeAttributes(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v3, v0}, Lcom/exacttarget/etpushsdk/data/Registration;->setAttributes(Ljava/util/ArrayList;)V

    .line 107
    const-string v0, "platform_version"

    invoke-interface {p0, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p0, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Lcom/exacttarget/etpushsdk/data/Registration;->setPlatformVersion(Ljava/lang/String;)V

    .line 108
    const-string v0, "push_enabled"

    invoke-interface {p0, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p0, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    if-ne v0, v1, :cond_1

    move v0, v1

    :goto_1
    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v3, v0}, Lcom/exacttarget/etpushsdk/data/Registration;->setPushEnabled(Ljava/lang/Boolean;)V

    .line 109
    const-string v0, "location_enabled"

    invoke-interface {p0, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p0, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    if-ne v0, v1, :cond_2

    :goto_2
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v3, v0}, Lcom/exacttarget/etpushsdk/data/Registration;->setLocationEnabled(Ljava/lang/Boolean;)V

    .line 110
    const-string v0, "last_sent"

    invoke-interface {p0, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p0, v0}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    invoke-virtual {v3, v0}, Lcom/exacttarget/etpushsdk/data/Registration;->setLastSent(Ljava/lang/Long;)V

    .line 111
    const-string v0, "hwid"

    invoke-interface {p0, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p0, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Lcom/exacttarget/etpushsdk/data/Registration;->setHwid(Ljava/lang/String;)V

    .line 112
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v0

    const-string v1, "gcm_sender_id"

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/a;->b(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Lcom/exacttarget/etpushsdk/data/Registration;->setGcmSenderId(Ljava/lang/String;)V

    .line 113
    const-string v0, "locale"

    invoke-interface {p0, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p0, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Lcom/exacttarget/etpushsdk/data/Registration;->setLocale(Ljava/lang/String;)V

    .line 115
    return-object v3

    :cond_0
    move v0, v2

    .line 104
    goto/16 :goto_0

    :cond_1
    move v0, v2

    .line 108
    goto :goto_1

    :cond_2
    move v1, v2

    .line 109
    goto :goto_2
.end method

.method public static a(Lcom/exacttarget/etpushsdk/data/Registration;)V
    .locals 4

    .prologue
    .line 68
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/i;->a()Lcom/exacttarget/etpushsdk/util/i;

    move-result-object v0

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/util/i;->b()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    const-string v1, "registration"

    const/4 v2, 0x0

    invoke-static {p0}, Lcom/exacttarget/etpushsdk/database/h;->c(Lcom/exacttarget/etpushsdk/data/Registration;)Landroid/content/ContentValues;

    move-result-object v3

    invoke-virtual {v0, v1, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    move-result-wide v0

    .line 72
    long-to-int v0, v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/exacttarget/etpushsdk/data/Registration;->setId(Ljava/lang/Integer;)V

    .line 73
    return-void
.end method

.method public static b(Lcom/exacttarget/etpushsdk/data/Registration;)I
    .locals 5

    .prologue
    .line 84
    const-string v0, "id = ?"

    .line 85
    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Registration;->getId()Ljava/lang/Integer;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    .line 87
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/i;->a()Lcom/exacttarget/etpushsdk/util/i;

    move-result-object v2

    invoke-virtual {v2}, Lcom/exacttarget/etpushsdk/util/i;->b()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v2

    const-string v3, "registration"

    invoke-static {p0}, Lcom/exacttarget/etpushsdk/database/h;->c(Lcom/exacttarget/etpushsdk/data/Registration;)Landroid/content/ContentValues;

    move-result-object v4

    invoke-virtual {v2, v3, v4, v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method private static c(Lcom/exacttarget/etpushsdk/data/Registration;)Landroid/content/ContentValues;
    .locals 6

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 119
    new-instance v3, Landroid/content/ContentValues;

    invoke-direct {v3}, Landroid/content/ContentValues;-><init>()V

    .line 121
    const-string v0, "platform"

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Registration;->getPlatform()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v0, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 122
    const-string v0, "device_id"

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v4

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Registration;->getDeviceId()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/exacttarget/etpushsdk/util/a;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v0, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 123
    const-string v0, "subscriber_key"

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v4

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Registration;->getSubscriberKey()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/exacttarget/etpushsdk/util/a;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v0, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 124
    const-string v0, "et_app_id"

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v4

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Registration;->getEtAppId()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/exacttarget/etpushsdk/util/a;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v0, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 125
    const-string v0, "email"

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v4

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Registration;->getEmail()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/exacttarget/etpushsdk/util/a;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v0, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 126
    const-string v0, "badge"

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Registration;->getBadge()Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v3, v0, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 127
    const-string v0, "timezone"

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Registration;->getTimeZone()Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v3, v0, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 128
    const-string v4, "dst"

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Registration;->getDst()Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_0

    move v0, v1

    :goto_0
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v3, v4, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 129
    const-string v0, "tags"

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v4

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Registration;->getTags()Ljava/util/TreeSet;

    move-result-object v5

    invoke-static {v5}, Lcom/exacttarget/etpushsdk/data/Registration;->serializeTags(Ljava/util/TreeSet;)Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/exacttarget/etpushsdk/util/a;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v0, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 130
    const-string v0, "attributes"

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v4

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Registration;->getAttributes()Ljava/util/ArrayList;

    move-result-object v5

    invoke-static {v5}, Lcom/exacttarget/etpushsdk/data/Registration;->serializeAttributes(Ljava/util/ArrayList;)Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/exacttarget/etpushsdk/util/a;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v0, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 131
    const-string v0, "platform_version"

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Registration;->getPlatformVersion()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v0, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 132
    const-string v4, "push_enabled"

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Registration;->getPushEnabled()Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_1

    move v0, v1

    :goto_1
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v3, v4, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 133
    const-string v0, "location_enabled"

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Registration;->getLocationEnabled()Ljava/lang/Boolean;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v4

    if-eqz v4, :cond_2

    :goto_2
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v3, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 134
    const-string v0, "last_sent"

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Registration;->getLastSent()Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v3, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 135
    const-string v0, "hwid"

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Registration;->getHwid()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v3, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 136
    const-string v0, "gcm_sender_id"

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Registration;->getGcmSenderId()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/exacttarget/etpushsdk/util/a;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v3, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 137
    const-string v0, "locale"

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Registration;->getLocale()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v3, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 139
    return-object v3

    :cond_0
    move v0, v2

    .line 128
    goto/16 :goto_0

    :cond_1
    move v0, v2

    .line 132
    goto :goto_1

    :cond_2
    move v1, v2

    .line 133
    goto :goto_2
.end method
