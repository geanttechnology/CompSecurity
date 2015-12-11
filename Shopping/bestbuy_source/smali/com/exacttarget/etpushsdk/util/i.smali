.class public Lcom/exacttarget/etpushsdk/util/i;
.super Landroid/database/sqlite/SQLiteOpenHelper;
.source "SourceFile"


# static fields
.field private static a:Lcom/exacttarget/etpushsdk/util/i;


# instance fields
.field private b:Landroid/database/sqlite/SQLiteDatabase;

.field private c:Landroid/content/Context;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 51
    const/4 v0, 0x0

    sput-object v0, Lcom/exacttarget/etpushsdk/util/i;->a:Lcom/exacttarget/etpushsdk/util/i;

    return-void
.end method

.method private constructor <init>(Landroid/content/Context;)V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 56
    const-string v0, "etdb.db"

    const/4 v1, 0x7

    invoke-direct {p0, p1, v0, v2, v1}, Landroid/database/sqlite/SQLiteOpenHelper;-><init>(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V

    .line 52
    iput-object v2, p0, Lcom/exacttarget/etpushsdk/util/i;->b:Landroid/database/sqlite/SQLiteDatabase;

    .line 53
    iput-object v2, p0, Lcom/exacttarget/etpushsdk/util/i;->c:Landroid/content/Context;

    .line 57
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/util/i;->c:Landroid/content/Context;

    .line 58
    return-void
.end method

.method public static declared-synchronized a()Lcom/exacttarget/etpushsdk/util/i;
    .locals 3

    .prologue
    .line 71
    const-class v1, Lcom/exacttarget/etpushsdk/util/i;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/exacttarget/etpushsdk/util/i;->a:Lcom/exacttarget/etpushsdk/util/i;

    if-nez v0, :cond_0

    .line 72
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v2, "~!uf is not initialized, call initializeInstance(..) method first."

    invoke-direct {v0, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 71
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0

    .line 76
    :cond_0
    :try_start_1
    sget-object v0, Lcom/exacttarget/etpushsdk/util/i;->a:Lcom/exacttarget/etpushsdk/util/i;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    monitor-exit v1

    return-object v0
.end method

.method public static declared-synchronized a(Landroid/content/Context;)V
    .locals 3

    .prologue
    .line 61
    const-class v1, Lcom/exacttarget/etpushsdk/util/i;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/exacttarget/etpushsdk/util/i;->a:Lcom/exacttarget/etpushsdk/util/i;

    if-nez v0, :cond_0

    .line 62
    const-string v0, "~!uf"

    const-string v2, "New instance of ETSqliteOpenHelper."

    invoke-static {v0, v2}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 63
    new-instance v0, Lcom/exacttarget/etpushsdk/util/i;

    invoke-direct {v0, p0}, Lcom/exacttarget/etpushsdk/util/i;-><init>(Landroid/content/Context;)V

    sput-object v0, Lcom/exacttarget/etpushsdk/util/i;->a:Lcom/exacttarget/etpushsdk/util/i;

    .line 66
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/i;->a()Lcom/exacttarget/etpushsdk/util/i;

    move-result-object v0

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/util/i;->b()Landroid/database/sqlite/SQLiteDatabase;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 68
    :cond_0
    monitor-exit v1

    return-void

    .line 61
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method private a(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 8

    .prologue
    const/4 v3, 0x0

    .line 201
    const-string v1, "analytic_item"

    sget-object v2, Lcom/exacttarget/etpushsdk/database/a;->a:[Ljava/lang/String;

    move-object v0, p1

    move-object v4, v3

    move-object v5, v3

    move-object v6, v3

    move-object v7, v3

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 210
    if-eqz v0, :cond_1

    .line 211
    invoke-interface {v0}, Landroid/database/Cursor;->moveToFirst()Z

    .line 213
    :goto_0
    invoke-interface {v0}, Landroid/database/Cursor;->isAfterLast()Z

    move-result v1

    if-nez v1, :cond_0

    .line 214
    const-string v1, "id"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    .line 215
    const-string v2, "device_id"

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 216
    const-string v3, "et_app_id"

    invoke-interface {v0, v3}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v3

    invoke-interface {v0, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 217
    const-string v4, "pi_app_key"

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 219
    new-instance v5, Landroid/content/ContentValues;

    invoke-direct {v5}, Landroid/content/ContentValues;-><init>()V

    .line 220
    const-string v6, "device_id"

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v7

    invoke-static {v7, v2}, Lcom/exacttarget/etpushsdk/util/a;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v5, v6, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 221
    const-string v2, "et_app_id"

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v6

    invoke-static {v6, v3}, Lcom/exacttarget/etpushsdk/util/a;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v5, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 222
    const-string v2, "pi_app_key"

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3, v4}, Lcom/exacttarget/etpushsdk/util/a;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v5, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 224
    const-string v2, "id = ?"

    .line 225
    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    invoke-static {v1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    aput-object v1, v3, v4

    .line 227
    const-string v1, "analytic_item"

    invoke-virtual {p1, v1, v5, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 233
    invoke-interface {v0}, Landroid/database/Cursor;->moveToNext()Z

    goto :goto_0

    .line 235
    :cond_0
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .line 237
    :cond_1
    return-void
.end method

.method private b(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 8

    .prologue
    const/4 v3, 0x0

    .line 240
    const-string v1, "beacon_request"

    sget-object v2, Lcom/exacttarget/etpushsdk/database/b;->a:[Ljava/lang/String;

    move-object v0, p1

    move-object v4, v3

    move-object v5, v3

    move-object v6, v3

    move-object v7, v3

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 249
    if-eqz v0, :cond_1

    .line 250
    invoke-interface {v0}, Landroid/database/Cursor;->moveToFirst()Z

    .line 252
    :goto_0
    invoke-interface {v0}, Landroid/database/Cursor;->isAfterLast()Z

    move-result v1

    if-nez v1, :cond_0

    .line 253
    const-string v1, "id"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    .line 254
    const-string v2, "device_id"

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 255
    const-string v3, "latitude"

    invoke-interface {v0, v3}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v3

    invoke-interface {v0, v3}, Landroid/database/Cursor;->getDouble(I)D

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v3

    .line 256
    const-string v4, "longitude"

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getDouble(I)D

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v4

    .line 258
    new-instance v5, Landroid/content/ContentValues;

    invoke-direct {v5}, Landroid/content/ContentValues;-><init>()V

    .line 259
    const-string v6, "device_id"

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v7

    invoke-static {v7, v2}, Lcom/exacttarget/etpushsdk/util/a;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v5, v6, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 260
    const-string v2, "latitude"

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v6

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v6, v3}, Lcom/exacttarget/etpushsdk/util/a;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v5, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 261
    const-string v2, "longitude"

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v3

    invoke-static {v4}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/exacttarget/etpushsdk/util/a;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v5, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 263
    const-string v2, "id = ?"

    .line 264
    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    invoke-static {v1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    aput-object v1, v3, v4

    .line 266
    const-string v1, "beacon_request"

    invoke-virtual {p1, v1, v5, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 272
    invoke-interface {v0}, Landroid/database/Cursor;->moveToNext()Z

    goto :goto_0

    .line 274
    :cond_0
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .line 276
    :cond_1
    return-void
.end method

.method private c(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 8

    .prologue
    const/4 v3, 0x0

    .line 279
    const-string v1, "geofence_request"

    sget-object v2, Lcom/exacttarget/etpushsdk/database/c;->a:[Ljava/lang/String;

    move-object v0, p1

    move-object v4, v3

    move-object v5, v3

    move-object v6, v3

    move-object v7, v3

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 288
    if-eqz v0, :cond_1

    .line 289
    invoke-interface {v0}, Landroid/database/Cursor;->moveToFirst()Z

    .line 291
    :goto_0
    invoke-interface {v0}, Landroid/database/Cursor;->isAfterLast()Z

    move-result v1

    if-nez v1, :cond_0

    .line 292
    const-string v1, "id"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    .line 293
    const-string v2, "device_id"

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 294
    const-string v3, "latitude"

    invoke-interface {v0, v3}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v3

    invoke-interface {v0, v3}, Landroid/database/Cursor;->getDouble(I)D

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v3

    .line 295
    const-string v4, "longitude"

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getDouble(I)D

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v4

    .line 297
    new-instance v5, Landroid/content/ContentValues;

    invoke-direct {v5}, Landroid/content/ContentValues;-><init>()V

    .line 298
    const-string v6, "device_id"

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v7

    invoke-static {v7, v2}, Lcom/exacttarget/etpushsdk/util/a;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v5, v6, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 299
    const-string v2, "latitude"

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v6

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v6, v3}, Lcom/exacttarget/etpushsdk/util/a;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v5, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 300
    const-string v2, "longitude"

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v3

    invoke-static {v4}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/exacttarget/etpushsdk/util/a;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v5, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 302
    const-string v2, "id = ?"

    .line 303
    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    invoke-static {v1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    aput-object v1, v3, v4

    .line 305
    const-string v1, "geofence_request"

    invoke-virtual {p1, v1, v5, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 311
    invoke-interface {v0}, Landroid/database/Cursor;->moveToNext()Z

    goto :goto_0

    .line 313
    :cond_0
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .line 315
    :cond_1
    return-void
.end method

.method private d(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 8

    .prologue
    const/4 v3, 0x0

    .line 318
    const-string v1, "location_update"

    sget-object v2, Lcom/exacttarget/etpushsdk/database/d;->a:[Ljava/lang/String;

    move-object v0, p1

    move-object v4, v3

    move-object v5, v3

    move-object v6, v3

    move-object v7, v3

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 327
    if-eqz v0, :cond_1

    .line 328
    invoke-interface {v0}, Landroid/database/Cursor;->moveToFirst()Z

    .line 330
    :goto_0
    invoke-interface {v0}, Landroid/database/Cursor;->isAfterLast()Z

    move-result v1

    if-nez v1, :cond_0

    .line 331
    const-string v1, "id"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    .line 332
    const-string v2, "device_id"

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 333
    const-string v3, "latitude"

    invoke-interface {v0, v3}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v3

    invoke-interface {v0, v3}, Landroid/database/Cursor;->getDouble(I)D

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v3

    .line 334
    const-string v4, "longitude"

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getDouble(I)D

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v4

    .line 336
    new-instance v5, Landroid/content/ContentValues;

    invoke-direct {v5}, Landroid/content/ContentValues;-><init>()V

    .line 337
    const-string v6, "device_id"

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v7

    invoke-static {v7, v2}, Lcom/exacttarget/etpushsdk/util/a;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v5, v6, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 338
    const-string v2, "latitude"

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v6

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v6, v3}, Lcom/exacttarget/etpushsdk/util/a;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v5, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 339
    const-string v2, "longitude"

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v3

    invoke-static {v4}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/exacttarget/etpushsdk/util/a;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v5, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 341
    const-string v2, "id = ?"

    .line 342
    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    invoke-static {v1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    aput-object v1, v3, v4

    .line 344
    const-string v1, "location_update"

    invoke-virtual {p1, v1, v5, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 350
    invoke-interface {v0}, Landroid/database/Cursor;->moveToNext()Z

    goto :goto_0

    .line 352
    :cond_0
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .line 354
    :cond_1
    return-void
.end method

.method private e(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 11

    .prologue
    const/4 v3, 0x0

    .line 357
    const-string v1, "messages"

    sget-object v2, Lcom/exacttarget/etpushsdk/database/e;->a:[Ljava/lang/String;

    move-object v0, p1

    move-object v4, v3

    move-object v5, v3

    move-object v6, v3

    move-object v7, v3

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 366
    if-eqz v0, :cond_1

    .line 367
    invoke-interface {v0}, Landroid/database/Cursor;->moveToFirst()Z

    .line 369
    :goto_0
    invoke-interface {v0}, Landroid/database/Cursor;->isAfterLast()Z

    move-result v1

    if-nez v1, :cond_0

    .line 370
    const-string v1, "id"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 371
    const-string v2, "alert"

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 372
    const-string v3, "open_direct"

    invoke-interface {v0, v3}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v3

    invoke-interface {v0, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 373
    const-string v4, "category"

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 374
    const-string v5, "url"

    invoke-interface {v0, v5}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v0, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    .line 375
    const-string v6, "subject"

    invoke-interface {v0, v6}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v6

    invoke-interface {v0, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v6

    .line 376
    new-instance v7, Ljava/lang/String;

    const-string v8, "keys"

    invoke-interface {v0, v8}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v8

    invoke-interface {v0, v8}, Landroid/database/Cursor;->getBlob(I)[B

    move-result-object v8

    invoke-direct {v7, v8}, Ljava/lang/String;-><init>([B)V

    invoke-static {v7}, Lcom/exacttarget/etpushsdk/data/Registration;->deserializeAttributes(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v7

    .line 378
    new-instance v8, Landroid/content/ContentValues;

    invoke-direct {v8}, Landroid/content/ContentValues;-><init>()V

    .line 379
    const-string v9, "alert"

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v10

    invoke-static {v10, v2}, Lcom/exacttarget/etpushsdk/util/a;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v8, v9, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 380
    const-string v2, "open_direct"

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v9

    invoke-static {v9, v3}, Lcom/exacttarget/etpushsdk/util/a;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v8, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 381
    const-string v2, "category"

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3, v4}, Lcom/exacttarget/etpushsdk/util/a;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v8, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 382
    const-string v2, "url"

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3, v5}, Lcom/exacttarget/etpushsdk/util/a;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v8, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 383
    const-string v2, "subject"

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3, v6}, Lcom/exacttarget/etpushsdk/util/a;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v8, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 384
    const-string v2, "keys"

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v3

    invoke-static {v7}, Lcom/exacttarget/etpushsdk/data/Registration;->serializeAttributes(Ljava/util/ArrayList;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/exacttarget/etpushsdk/util/a;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v8, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 386
    const-string v2, "id = ?"

    .line 387
    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    aput-object v1, v3, v4

    .line 389
    const-string v1, "messages"

    invoke-virtual {p1, v1, v8, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 395
    invoke-interface {v0}, Landroid/database/Cursor;->moveToNext()Z

    goto/16 :goto_0

    .line 397
    :cond_0
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .line 399
    :cond_1
    return-void
.end method

.method private f(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 10

    .prologue
    const/4 v3, 0x0

    .line 402
    const-string v1, "regions"

    sget-object v2, Lcom/exacttarget/etpushsdk/database/g;->a:[Ljava/lang/String;

    move-object v0, p1

    move-object v4, v3

    move-object v5, v3

    move-object v6, v3

    move-object v7, v3

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 411
    if-eqz v0, :cond_1

    .line 412
    invoke-interface {v0}, Landroid/database/Cursor;->moveToFirst()Z

    .line 414
    :goto_0
    invoke-interface {v0}, Landroid/database/Cursor;->isAfterLast()Z

    move-result v1

    if-nez v1, :cond_0

    .line 415
    const-string v1, "id"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 416
    const-string v2, "latitude"

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getDouble(I)D

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v2

    .line 417
    const-string v3, "longitude"

    invoke-interface {v0, v3}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v3

    invoke-interface {v0, v3}, Landroid/database/Cursor;->getDouble(I)D

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v3

    .line 418
    const-string v4, "beacon_guid"

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 419
    const-string v5, "description"

    invoke-interface {v0, v5}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v0, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    .line 420
    const-string v6, "name"

    invoke-interface {v0, v6}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v6

    invoke-interface {v0, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v6

    .line 422
    new-instance v7, Landroid/content/ContentValues;

    invoke-direct {v7}, Landroid/content/ContentValues;-><init>()V

    .line 423
    const-string v8, "latitude"

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v9

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v9, v2}, Lcom/exacttarget/etpushsdk/util/a;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v7, v8, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 424
    const-string v2, "longitude"

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v8

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v8, v3}, Lcom/exacttarget/etpushsdk/util/a;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v7, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 425
    const-string v2, "beacon_guid"

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3, v4}, Lcom/exacttarget/etpushsdk/util/a;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v7, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 426
    const-string v2, "description"

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3, v5}, Lcom/exacttarget/etpushsdk/util/a;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v7, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 427
    const-string v2, "name"

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3, v6}, Lcom/exacttarget/etpushsdk/util/a;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v7, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 429
    const-string v2, "id = ?"

    .line 430
    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    aput-object v1, v3, v4

    .line 432
    const-string v1, "regions"

    invoke-virtual {p1, v1, v7, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 438
    invoke-interface {v0}, Landroid/database/Cursor;->moveToNext()Z

    goto/16 :goto_0

    .line 440
    :cond_0
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .line 442
    :cond_1
    return-void
.end method

.method private g(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 12

    .prologue
    const/4 v3, 0x0

    .line 445
    const-string v1, "registration"

    sget-object v2, Lcom/exacttarget/etpushsdk/database/h;->a:[Ljava/lang/String;

    move-object v0, p1

    move-object v4, v3

    move-object v5, v3

    move-object v6, v3

    move-object v7, v3

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 454
    if-eqz v0, :cond_2

    .line 455
    invoke-interface {v0}, Landroid/database/Cursor;->moveToFirst()Z

    .line 457
    :goto_0
    invoke-interface {v0}, Landroid/database/Cursor;->isAfterLast()Z

    move-result v1

    if-nez v1, :cond_1

    .line 458
    const-string v1, "id"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    .line 459
    const-string v2, "device_id"

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 460
    const-string v3, "subscriber_key"

    invoke-interface {v0, v3}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v3

    invoke-interface {v0, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 461
    const-string v4, "et_app_id"

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 462
    const-string v5, "email"

    invoke-interface {v0, v5}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v0, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    .line 463
    const-string v6, "gcm_sender_id"

    invoke-interface {v0, v6}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v6

    invoke-interface {v0, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v6

    .line 464
    new-instance v7, Ljava/lang/String;

    const-string v8, "tags"

    invoke-interface {v0, v8}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v8

    invoke-interface {v0, v8}, Landroid/database/Cursor;->getBlob(I)[B

    move-result-object v8

    invoke-direct {v7, v8}, Ljava/lang/String;-><init>([B)V

    invoke-static {v7}, Lcom/exacttarget/etpushsdk/data/Registration;->deserializeTags(Ljava/lang/String;)Ljava/util/TreeSet;

    move-result-object v7

    .line 465
    new-instance v8, Ljava/lang/String;

    const-string v9, "attributes"

    invoke-interface {v0, v9}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v9

    invoke-interface {v0, v9}, Landroid/database/Cursor;->getBlob(I)[B

    move-result-object v9

    invoke-direct {v8, v9}, Ljava/lang/String;-><init>([B)V

    invoke-static {v8}, Lcom/exacttarget/etpushsdk/data/Registration;->deserializeAttributes(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v8

    .line 467
    new-instance v9, Landroid/content/ContentValues;

    invoke-direct {v9}, Landroid/content/ContentValues;-><init>()V

    .line 468
    const-string v10, "device_id"

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v11

    invoke-static {v11, v2}, Lcom/exacttarget/etpushsdk/util/a;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v9, v10, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 470
    const-string v2, "device_token"

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    if-ltz v2, :cond_0

    .line 473
    const-string v2, "device_token"

    const-string v10, ""

    invoke-virtual {v9, v2, v10}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 475
    :cond_0
    const-string v2, "subscriber_key"

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v10

    invoke-static {v10, v3}, Lcom/exacttarget/etpushsdk/util/a;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v9, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 476
    const-string v2, "et_app_id"

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3, v4}, Lcom/exacttarget/etpushsdk/util/a;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v9, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 477
    const-string v2, "email"

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3, v5}, Lcom/exacttarget/etpushsdk/util/a;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v9, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 478
    const-string v2, "gcm_sender_id"

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3, v6}, Lcom/exacttarget/etpushsdk/util/a;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v9, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 479
    const-string v2, "tags"

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v3

    invoke-static {v7}, Lcom/exacttarget/etpushsdk/data/Registration;->serializeTags(Ljava/util/TreeSet;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/exacttarget/etpushsdk/util/a;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v9, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 480
    const-string v2, "attributes"

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v3

    invoke-static {v8}, Lcom/exacttarget/etpushsdk/data/Registration;->serializeAttributes(Ljava/util/ArrayList;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/exacttarget/etpushsdk/util/a;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v9, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 482
    const-string v2, "id = ?"

    .line 483
    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    invoke-static {v1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    aput-object v1, v3, v4

    .line 485
    const-string v1, "registration"

    invoke-virtual {p1, v1, v9, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 491
    invoke-interface {v0}, Landroid/database/Cursor;->moveToNext()Z

    goto/16 :goto_0

    .line 493
    :cond_1
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .line 495
    :cond_2
    return-void
.end method


# virtual methods
.method public declared-synchronized b()Landroid/database/sqlite/SQLiteDatabase;
    .locals 2

    .prologue
    .line 99
    monitor-enter p0

    :try_start_0
    sget-object v0, Lcom/exacttarget/etpushsdk/util/i;->a:Lcom/exacttarget/etpushsdk/util/i;

    if-nez v0, :cond_0

    .line 100
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "~!uf is not initialized, call initializeInstance(..) method first."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 99
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    .line 104
    :cond_0
    :try_start_1
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/util/i;->b:Landroid/database/sqlite/SQLiteDatabase;

    if-nez v0, :cond_1

    .line 106
    sget-object v0, Lcom/exacttarget/etpushsdk/util/i;->a:Lcom/exacttarget/etpushsdk/util/i;

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/util/i;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/util/i;->b:Landroid/database/sqlite/SQLiteDatabase;

    .line 109
    :cond_1
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/util/i;->b:Landroid/database/sqlite/SQLiteDatabase;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    monitor-exit p0

    return-object v0
.end method

.method public declared-synchronized c()V
    .locals 2

    .prologue
    .line 113
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/util/i;->b()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    const-string v1, "VACUUM"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 114
    monitor-exit p0

    return-void

    .line 113
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public onCreate(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 3

    .prologue
    .line 82
    :try_start_0
    const-string v0, "~!uf"

    const-string v1, "onCreate"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 84
    const-string v0, "CREATE TABLE registration (id INTEGER PRIMARY KEY AUTOINCREMENT, platform VARCHAR, device_id VARCHAR, subscriber_key VARCHAR, et_app_id VARCHAR, email VARCHAR, badge INTEGER, timezone INTEGER, dst SMALLINT, tags VARCHAR, attributes VARCHAR, platform_version VARCHAR, push_enabled SMALLINT, location_enabled SMALLINT, last_sent BIGINT, hwid VARCHAR, gcm_sender_id VARCHAR, locale VARCHAR );"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 85
    const-string v0, "CREATE TABLE beacon_request (id INTEGER PRIMARY KEY AUTOINCREMENT, device_id VARCHAR, latitude DOUBLE PRECISION, longitude DOUBLE PRECISION );"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 86
    const-string v0, "CREATE TABLE geofence_request (id INTEGER PRIMARY KEY AUTOINCREMENT, device_id VARCHAR, latitude DOUBLE PRECISION, longitude DOUBLE PRECISION );"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 87
    const-string v0, "CREATE TABLE location_update (id INTEGER PRIMARY KEY AUTOINCREMENT, device_id VARCHAR, latitude DOUBLE PRECISION, longitude DOUBLE PRECISION, accuracy INTEGER, timestamp VARCHAR, last_sent BIGINT );"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 88
    const-string v0, "CREATE TABLE messages (id VARCHAR PRIMARY KEY, alert VARCHAR, sound VARCHAR, badge VARCHAR, open_direct VARCHAR, category VARCHAR, start_date VARCHAR, end_date VARCHAR, message_type INTEGER, content_type INTEGER, page_id VARCHAR, url VARCHAR, subject VARCHAR, site_id VARCHAR, read SMALLINT, custom VARCHAR, keys VARCHAR, period_show_count INTEGER, last_shown_date VARCHAR, next_allowed_show VARCHAR, show_count INTEGER, message_limit INTEGER, rolling_period SMALLINT, period_type INTEGER, number_of_periods INTEGER, messages_per_period INTEGER, message_deleted SMALLINT, min_tripped INTEGER, proximity INTEGER, ephemeral_message SMALLINT, has_entered SMALLINT, notify_id INTEGER, loiter_seconds INTEGER, entry_time BIGINT );"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 89
    const-string v0, "CREATE TABLE regions (id VARCHAR PRIMARY KEY, latitude DOUBLE PRECISION, longitude DOUBLE PRECISION, radius INTEGER, active SMALLINT, beacon_guid VARCHAR, beacon_major INTEGER, beacon_minor INTEGER, entry_count INTEGER, exit_count INTEGER, description VARCHAR, name VARCHAR, location_type INTEGER, has_entered SMALLINT );"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 90
    const-string v0, "CREATE TABLE region_message (id INTEGER PRIMARY KEY AUTOINCREMENT, region_id VARCHAR, message_id VARCHAR );"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 91
    const-string v0, "CREATE TABLE analytic_item (id INTEGER PRIMARY KEY AUTOINCREMENT, device_id VARCHAR, et_app_id VARCHAR, event_date VARCHAR, analytic_types VARCHAR, object_ids VARCHAR, value INTEGER, ready_to_send SMALLINT, pi_app_key VARCHAR, last_sent BIGINT );"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 96
    return-void

    .line 92
    :catch_0
    move-exception v0

    .line 93
    const-string v1, "~!uf"

    const-string v2, "Can\'t create database"

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 94
    new-instance v1, Ljava/lang/RuntimeException;

    invoke-direct {v1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method public onUpgrade(Landroid/database/sqlite/SQLiteDatabase;II)V
    .locals 6

    .prologue
    .line 119
    const/4 v0, 0x2

    if-ge p2, v0, :cond_0

    .line 120
    :try_start_0
    const-string v0, "~!uf"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Updating DB from "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " to 2"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 121
    const-string v0, "ALTER TABLE registration ADD COLUMN last_sent BIGINT;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 122
    const-string v0, "ALTER TABLE registration ADD COLUMN hwid VARCHAR;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 123
    const-string v0, "ALTER TABLE registration ADD COLUMN gcm_sender_id VARCHAR;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 124
    const-string v0, "ALTER TABLE location_update ADD COLUMN last_sent BIGINT;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 125
    const-string v0, "ALTER TABLE messages ADD COLUMN message_deleted SMALLINT;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 128
    :cond_0
    const/4 v0, 0x3

    if-ge p2, v0, :cond_1

    .line 129
    const-string v0, "ALTER TABLE regions ADD COLUMN beacon_guid VARCHAR;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 130
    const-string v0, "ALTER TABLE regions ADD COLUMN beacon_major INTEGER;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 131
    const-string v0, "ALTER TABLE regions ADD COLUMN beacon_minor INTEGER;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 132
    const-string v0, "ALTER TABLE regions ADD COLUMN entry_count INTEGER;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 133
    const-string v0, "ALTER TABLE regions ADD COLUMN exit_count INTEGER;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 134
    const-string v0, "ALTER TABLE regions ADD COLUMN description VARCHAR;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 135
    const-string v0, "ALTER TABLE regions ADD COLUMN location_type INTEGER;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 136
    const-string v0, "ALTER TABLE regions ADD COLUMN name VARCHAR;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 137
    const-string v0, "ALTER TABLE regions ADD COLUMN has_entered SMALLINT;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 138
    const-string v0, "ALTER TABLE messages ADD COLUMN min_tripped INTEGER;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 139
    const-string v0, "ALTER TABLE messages ADD COLUMN proximity INTEGER;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 140
    const-string v0, "ALTER TABLE messages ADD COLUMN ephemeral_message SMALLINT;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 141
    const-string v0, "ALTER TABLE messages ADD COLUMN has_entered SMALLINT;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 142
    const-string v0, "ALTER TABLE messages ADD COLUMN notify_id INTEGER;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 143
    const-string v0, "ALTER TABLE messages ADD COLUMN loiter_seconds INTEGER;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 144
    const-string v0, "ALTER TABLE messages ADD COLUMN entry_time BIGINT;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 145
    const-string v0, "CREATE TABLE analytic_item (id INTEGER PRIMARY KEY AUTOINCREMENT, device_id VARCHAR, et_app_id VARCHAR, event_date VARCHAR, analytic_types VARCHAR, object_ids VARCHAR, value INTEGER, ready_to_send SMALLINT, pi_app_key VARCHAR, last_sent BIGINT );"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 146
    const-string v0, "CREATE TABLE beacon_request (id INTEGER PRIMARY KEY AUTOINCREMENT, device_id VARCHAR, latitude DOUBLE PRECISION, longitude DOUBLE PRECISION );"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 149
    :cond_1
    const/4 v0, 0x4

    if-ge p2, v0, :cond_2

    .line 150
    const-string v0, "ALTER TABLE registration ADD COLUMN locale TEXT;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 153
    :cond_2
    const/4 v0, 0x5

    if-ge p2, v0, :cond_3

    .line 154
    const-string v0, "ALTER TABLE messages ADD COLUMN category VARCHAR;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 157
    :cond_3
    const/4 v0, 0x6

    if-ge p2, v0, :cond_4

    .line 158
    const-string v0, "ALTER TABLE analytic_item ADD COLUMN pi_app_key VARCHAR;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 161
    :cond_4
    const/4 v0, 0x7

    if-ge p2, v0, :cond_5

    .line 163
    new-instance v1, Landroid/content/ContentValues;

    invoke-direct {v1}, Landroid/content/ContentValues;-><init>()V

    .line 164
    const-string v2, "pi_app_key"

    const/4 v0, 0x0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v1, v2, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 166
    const-string v0, "analytic_item"

    const-string v2, "pi_app_key = ? "

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    const-string v5, ""

    aput-object v5, v3, v4

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    .line 172
    const-string v1, "~!uf"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "PI App Rows updated to null: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 175
    invoke-direct {p0, p1}, Lcom/exacttarget/etpushsdk/util/i;->a(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 176
    invoke-direct {p0, p1}, Lcom/exacttarget/etpushsdk/util/i;->b(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 177
    invoke-direct {p0, p1}, Lcom/exacttarget/etpushsdk/util/i;->d(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 178
    invoke-direct {p0, p1}, Lcom/exacttarget/etpushsdk/util/i;->c(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 179
    invoke-direct {p0, p1}, Lcom/exacttarget/etpushsdk/util/i;->d(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 180
    invoke-direct {p0, p1}, Lcom/exacttarget/etpushsdk/util/i;->e(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 181
    invoke-direct {p0, p1}, Lcom/exacttarget/etpushsdk/util/i;->f(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 182
    invoke-direct {p0, p1}, Lcom/exacttarget/etpushsdk/util/i;->g(Landroid/database/sqlite/SQLiteDatabase;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 198
    :cond_5
    :goto_0
    return-void

    .line 185
    :catch_0
    move-exception v0

    .line 186
    const-string v1, "~!uf"

    const-string v2, "Can\'t update database. blow it away and re-create"

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 187
    const-string v0, "DROP TABLE IF EXISTS registration"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 188
    const-string v0, "DROP TABLE IF EXISTS beacon_request"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 189
    const-string v0, "DROP TABLE IF EXISTS geofence_request"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 190
    const-string v0, "DROP TABLE IF EXISTS location_update"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 191
    const-string v0, "DROP TABLE IF EXISTS messages"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 192
    const-string v0, "DROP TABLE IF EXISTS regions"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 193
    const-string v0, "DROP TABLE IF EXISTS region_message"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 194
    const-string v0, "DROP TABLE IF EXISTS analytic_item"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 196
    invoke-virtual {p0, p1}, Lcom/exacttarget/etpushsdk/util/i;->onCreate(Landroid/database/sqlite/SQLiteDatabase;)V

    goto :goto_0
.end method
