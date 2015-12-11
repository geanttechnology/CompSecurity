.class public Lcom/exacttarget/etpushsdk/database/c;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field public static final a:[Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 22
    const/4 v0, 0x4

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "id"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string v2, "device_id"

    aput-object v2, v0, v1

    const/4 v1, 0x2

    const-string v2, "latitude"

    aput-object v2, v0, v1

    const/4 v1, 0x3

    const-string v2, "longitude"

    aput-object v2, v0, v1

    sput-object v0, Lcom/exacttarget/etpushsdk/database/c;->a:[Ljava/lang/String;

    return-void
.end method

.method public static a(Ljava/util/List;)I
    .locals 7

    .prologue
    const/4 v6, 0x0

    .line 37
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 39
    invoke-interface {p0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/exacttarget/etpushsdk/event/GeofenceRequest;

    .line 40
    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/event/GeofenceRequest;->getId()Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 43
    :cond_0
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/i;->a()Lcom/exacttarget/etpushsdk/util/i;

    move-result-object v0

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/util/i;->b()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    const-string v2, "geofence_request"

    const-string v3, "id IN (%s)"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const-string v5, ","

    invoke-static {v5, v1}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;

    move-result-object v1

    aput-object v1, v4, v6

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    new-array v3, v6, [Ljava/lang/String;

    invoke-virtual {v0, v2, v1, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method public static a(Landroid/database/Cursor;)Lcom/exacttarget/etpushsdk/event/GeofenceRequest;
    .locals 3

    .prologue
    .line 77
    new-instance v0, Lcom/exacttarget/etpushsdk/event/GeofenceRequest;

    invoke-direct {v0}, Lcom/exacttarget/etpushsdk/event/GeofenceRequest;-><init>()V

    .line 79
    :try_start_0
    const-string v1, "id"

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/event/GeofenceRequest;->setId(Ljava/lang/Integer;)V

    .line 80
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v1

    const-string v2, "device_id"

    invoke-interface {p0, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {p0, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/exacttarget/etpushsdk/util/a;->b(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/event/GeofenceRequest;->setDeviceId(Ljava/lang/String;)V

    .line 81
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v1

    const-string v2, "latitude"

    invoke-interface {p0, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {p0, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/exacttarget/etpushsdk/util/a;->b(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/lang/Double;->valueOf(Ljava/lang/String;)Ljava/lang/Double;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/event/GeofenceRequest;->setLatitude(Ljava/lang/Double;)V

    .line 82
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v1

    const-string v2, "longitude"

    invoke-interface {p0, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {p0, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/exacttarget/etpushsdk/util/a;->b(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/lang/Double;->valueOf(Ljava/lang/String;)Ljava/lang/Double;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/event/GeofenceRequest;->setLongitude(Ljava/lang/Double;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 87
    :goto_0
    return-object v0

    .line 83
    :catch_0
    move-exception v0

    .line 84
    const-string v1, "~!dc"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 85
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static a(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    .locals 8

    .prologue
    .line 52
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/i;->a()Lcom/exacttarget/etpushsdk/util/i;

    move-result-object v0

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/util/i;->b()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    const-string v1, "geofence_request"

    sget-object v2, Lcom/exacttarget/etpushsdk/database/c;->a:[Ljava/lang/String;

    move-object v3, p0

    move-object v4, p1

    move-object v5, p2

    move-object v6, p3

    move-object v7, p4

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 61
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 63
    if-eqz v0, :cond_1

    .line 64
    invoke-interface {v0}, Landroid/database/Cursor;->moveToFirst()Z

    .line 65
    :goto_0
    invoke-interface {v0}, Landroid/database/Cursor;->isAfterLast()Z

    move-result v2

    if-nez v2, :cond_0

    .line 66
    invoke-static {v0}, Lcom/exacttarget/etpushsdk/database/c;->a(Landroid/database/Cursor;)Lcom/exacttarget/etpushsdk/event/GeofenceRequest;

    move-result-object v2

    .line 67
    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 68
    invoke-interface {v0}, Landroid/database/Cursor;->moveToNext()Z

    goto :goto_0

    .line 70
    :cond_0
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .line 73
    :cond_1
    return-object v1
.end method

.method public static a(Lcom/exacttarget/etpushsdk/event/GeofenceRequest;)V
    .locals 4

    .prologue
    .line 30
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/i;->a()Lcom/exacttarget/etpushsdk/util/i;

    move-result-object v0

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/util/i;->b()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    const-string v1, "geofence_request"

    const/4 v2, 0x0

    invoke-static {p0}, Lcom/exacttarget/etpushsdk/database/c;->b(Lcom/exacttarget/etpushsdk/event/GeofenceRequest;)Landroid/content/ContentValues;

    move-result-object v3

    invoke-virtual {v0, v1, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    .line 34
    return-void
.end method

.method private static b(Lcom/exacttarget/etpushsdk/event/GeofenceRequest;)Landroid/content/ContentValues;
    .locals 4

    .prologue
    .line 91
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 93
    const-string v1, "id"

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/event/GeofenceRequest;->getId()Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 94
    const-string v1, "device_id"

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/event/GeofenceRequest;->getDeviceId()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/exacttarget/etpushsdk/util/a;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 95
    const-string v1, "latitude"

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/event/GeofenceRequest;->getLatitude()Ljava/lang/Double;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/exacttarget/etpushsdk/util/a;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 96
    const-string v1, "longitude"

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/event/GeofenceRequest;->getLongitude()Ljava/lang/Double;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/exacttarget/etpushsdk/util/a;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 98
    return-object v0
.end method
