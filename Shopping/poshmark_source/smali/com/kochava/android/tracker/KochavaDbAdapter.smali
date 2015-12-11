.class public Lcom/kochava/android/tracker/KochavaDbAdapter;
.super Ljava/lang/Object;
.source "KochavaDbAdapter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/kochava/android/tracker/KochavaDbAdapter$KochavaDatabaseHelper;
    }
.end annotation


# static fields
.field private static final DATABASE_CREATE:Ljava/lang/String; = "CREATE TABLE events (_id INTEGER PRIMARY KEY AUTOINCREMENT, data STRING NOT NULL,created_at INTEGER NOT NULL);"

.field private static final DATABASE_CREATE_2:Ljava/lang/String; = "CREATE TABLE keys (id STRING NOT NULL PRIMARY KEY, data STRING NOT NULL);"

.field private static final DATABASE_INDEX:Ljava/lang/String; = "CREATE INDEX IF NOT EXISTS time_idx ON events (created_at);"

.field private static final DATABASE_NAME:Ljava/lang/String; = "KochavaFeatureTracker"

.field private static final DATABASE_TABLE:Ljava/lang/String; = "events"

.field private static final DATABASE_TABLE_2:Ljava/lang/String; = "keys"

.field private static final DATABASE_VERSION:I = 0x2

.field public static final KEY_CREATED_AT:Ljava/lang/String; = "created_at"

.field public static final KEY_DATA:Ljava/lang/String; = "data"

.field private static final LOGTAG:Ljava/lang/String; = "KochavaDbAdapter"


# instance fields
.field private kDb:Lcom/kochava/android/tracker/KochavaDbAdapter$KochavaDatabaseHelper;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 91
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 92
    new-instance v0, Lcom/kochava/android/tracker/KochavaDbAdapter$KochavaDatabaseHelper;

    invoke-direct {v0, p1}, Lcom/kochava/android/tracker/KochavaDbAdapter$KochavaDatabaseHelper;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/kochava/android/tracker/KochavaDbAdapter;->kDb:Lcom/kochava/android/tracker/KochavaDbAdapter$KochavaDatabaseHelper;

    .line 93
    return-void
.end method


# virtual methods
.method public addEvent(Lorg/json/JSONObject;)I
    .locals 10
    .param p1, "j"    # Lorg/json/JSONObject;

    .prologue
    .line 104
    monitor-enter p0

    .line 106
    :try_start_0
    sget-boolean v7, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v7, :cond_0

    const-string v7, "KochavaDbAdapter"

    const-string v8, "addEvent"

    invoke-static {v7, v8}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 108
    :cond_0
    const/4 v2, 0x0

    .line 109
    .local v2, "c":Landroid/database/Cursor;
    const/4 v3, -0x1

    .line 112
    .local v3, "count":I
    :try_start_1
    iget-object v7, p0, Lcom/kochava/android/tracker/KochavaDbAdapter;->kDb:Lcom/kochava/android/tracker/KochavaDbAdapter$KochavaDatabaseHelper;

    invoke-virtual {v7}, Lcom/kochava/android/tracker/KochavaDbAdapter$KochavaDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v5

    .line 114
    .local v5, "db":Landroid/database/sqlite/SQLiteDatabase;
    new-instance v4, Landroid/content/ContentValues;

    invoke-direct {v4}, Landroid/content/ContentValues;-><init>()V

    .line 115
    .local v4, "cv":Landroid/content/ContentValues;
    const-string v8, "data"

    instance-of v7, p1, Lorg/json/JSONObject;

    if-nez v7, :cond_2

    invoke-virtual {p1}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v7

    .end local p1    # "j":Lorg/json/JSONObject;
    :goto_0
    invoke-virtual {v4, v8, v7}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 116
    const-string v7, "created_at"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v8

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v8

    invoke-virtual {v4, v7, v8}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 117
    const-string v8, "events"

    const/4 v9, 0x0

    instance-of v7, v5, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v7, :cond_3

    invoke-virtual {v5, v8, v9, v4}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    .line 119
    :goto_1
    const-string v7, "SELECT * FROM events"

    const/4 v8, 0x0

    instance-of v9, v5, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v9, :cond_5

    invoke-virtual {v5, v7, v8}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v2

    .line 120
    .end local v5    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :goto_2
    invoke-interface {v2}, Landroid/database/Cursor;->getCount()I
    :try_end_1
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result v3

    .line 124
    :try_start_2
    iget-object v7, p0, Lcom/kochava/android/tracker/KochavaDbAdapter;->kDb:Lcom/kochava/android/tracker/KochavaDbAdapter$KochavaDatabaseHelper;

    invoke-virtual {v7}, Lcom/kochava/android/tracker/KochavaDbAdapter$KochavaDatabaseHelper;->close()V

    .line 125
    if-eqz v2, :cond_1

    .line 126
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    .line 129
    .end local v4    # "cv":Landroid/content/ContentValues;
    :cond_1
    :goto_3
    monitor-exit p0
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    return v3

    .line 115
    .restart local v4    # "cv":Landroid/content/ContentValues;
    .restart local v5    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .restart local p1    # "j":Lorg/json/JSONObject;
    :cond_2
    :try_start_3
    check-cast p1, Lorg/json/JSONObject;

    .end local p1    # "j":Lorg/json/JSONObject;
    invoke-static {p1}, Lcom/newrelic/agent/android/instrumentation/JSONObjectInstrumentation;->toString(Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v7

    goto :goto_0

    .line 117
    :cond_3
    move-object v0, v5

    check-cast v0, Landroid/database/sqlite/SQLiteDatabase;

    move-object v7, v0

    invoke-static {v7, v8, v9, v4}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->insert(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    :try_end_3
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    goto :goto_1

    .line 121
    .end local v4    # "cv":Landroid/content/ContentValues;
    .end local v5    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :catch_0
    move-exception v6

    .line 122
    .local v6, "e":Landroid/database/sqlite/SQLiteException;
    :try_start_4
    sget-boolean v7, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v7, :cond_4

    const-string v7, "KochavaDbAdapter"

    const-string v8, "addEvent"

    invoke-static {v7, v8, v6}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .line 124
    :cond_4
    :try_start_5
    iget-object v7, p0, Lcom/kochava/android/tracker/KochavaDbAdapter;->kDb:Lcom/kochava/android/tracker/KochavaDbAdapter$KochavaDatabaseHelper;

    invoke-virtual {v7}, Lcom/kochava/android/tracker/KochavaDbAdapter$KochavaDatabaseHelper;->close()V

    .line 125
    if-eqz v2, :cond_1

    .line 126
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    goto :goto_3

    .line 104
    .end local v2    # "c":Landroid/database/Cursor;
    .end local v3    # "count":I
    .end local v6    # "e":Landroid/database/sqlite/SQLiteException;
    :catchall_0
    move-exception v7

    monitor-exit p0
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    throw v7

    .line 119
    .restart local v2    # "c":Landroid/database/Cursor;
    .restart local v3    # "count":I
    .restart local v4    # "cv":Landroid/content/ContentValues;
    .restart local v5    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :cond_5
    :try_start_6
    check-cast v5, Landroid/database/sqlite/SQLiteDatabase;

    .end local v5    # "db":Landroid/database/sqlite/SQLiteDatabase;
    invoke-static {v5, v7, v8}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->rawQuery(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_6
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_6 .. :try_end_6} :catch_0
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    move-result-object v2

    goto :goto_2

    .line 123
    .end local v4    # "cv":Landroid/content/ContentValues;
    :catchall_1
    move-exception v7

    .line 124
    :try_start_7
    iget-object v8, p0, Lcom/kochava/android/tracker/KochavaDbAdapter;->kDb:Lcom/kochava/android/tracker/KochavaDbAdapter$KochavaDatabaseHelper;

    invoke-virtual {v8}, Lcom/kochava/android/tracker/KochavaDbAdapter$KochavaDatabaseHelper;->close()V

    .line 125
    if-eqz v2, :cond_6

    .line 126
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    .line 128
    :cond_6
    throw v7
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_0
.end method

.method public cleanupEvents(J)V
    .locals 7
    .param p1, "time"    # J

    .prologue
    .line 139
    monitor-enter p0

    .line 141
    :try_start_0
    sget-boolean v2, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v2, :cond_0

    const-string v2, "KochavaDbAdapter"

    const-string v3, "cleanupEvent"

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 144
    :cond_0
    :try_start_1
    iget-object v2, p0, Lcom/kochava/android/tracker/KochavaDbAdapter;->kDb:Lcom/kochava/android/tracker/KochavaDbAdapter$KochavaDatabaseHelper;

    invoke-virtual {v2}, Lcom/kochava/android/tracker/KochavaDbAdapter$KochavaDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 145
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    const-string v2, "events"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "created_at <= "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, p1, p2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    instance-of v5, v0, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v5, :cond_1

    invoke-virtual {v0, v2, v3, v4}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_1
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 150
    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :goto_0
    :try_start_2
    iget-object v2, p0, Lcom/kochava/android/tracker/KochavaDbAdapter;->kDb:Lcom/kochava/android/tracker/KochavaDbAdapter$KochavaDatabaseHelper;

    invoke-virtual {v2}, Lcom/kochava/android/tracker/KochavaDbAdapter$KochavaDatabaseHelper;->close()V

    .line 139
    :goto_1
    monitor-exit p0
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 153
    return-void

    .line 145
    .restart local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :cond_1
    :try_start_3
    check-cast v0, Landroid/database/sqlite/SQLiteDatabase;

    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    invoke-static {v0, v2, v3, v4}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->delete(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_3
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    goto :goto_0

    .line 146
    :catch_0
    move-exception v1

    .line 148
    .local v1, "e":Landroid/database/sqlite/SQLiteException;
    :try_start_4
    sget-boolean v2, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v2, :cond_2

    const-string v2, "KochavaDbAdapter"

    const-string v3, "cleanupEvents"

    invoke-static {v2, v3, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .line 150
    :cond_2
    :try_start_5
    iget-object v2, p0, Lcom/kochava/android/tracker/KochavaDbAdapter;->kDb:Lcom/kochava/android/tracker/KochavaDbAdapter$KochavaDatabaseHelper;

    invoke-virtual {v2}, Lcom/kochava/android/tracker/KochavaDbAdapter$KochavaDatabaseHelper;->close()V

    goto :goto_1

    .line 139
    .end local v1    # "e":Landroid/database/sqlite/SQLiteException;
    :catchall_0
    move-exception v2

    monitor-exit p0
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    throw v2

    .line 149
    :catchall_1
    move-exception v2

    .line 150
    :try_start_6
    iget-object v3, p0, Lcom/kochava/android/tracker/KochavaDbAdapter;->kDb:Lcom/kochava/android/tracker/KochavaDbAdapter$KochavaDatabaseHelper;

    invoke-virtual {v3}, Lcom/kochava/android/tracker/KochavaDbAdapter$KochavaDatabaseHelper;->close()V

    .line 151
    throw v2
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_0
.end method

.method public generateDataString()Ljava/lang/String;
    .locals 12

    .prologue
    const/4 v9, 0x0

    .line 259
    monitor-enter p0

    .line 260
    const/4 v2, 0x0

    .line 261
    .local v2, "c":Landroid/database/Cursor;
    const/4 v3, 0x0

    .line 262
    .local v3, "data":Ljava/lang/String;
    const/4 v7, 0x0

    .line 265
    .local v7, "timestamp":Ljava/lang/String;
    :try_start_0
    iget-object v8, p0, Lcom/kochava/android/tracker/KochavaDbAdapter;->kDb:Lcom/kochava/android/tracker/KochavaDbAdapter$KochavaDatabaseHelper;

    invoke-virtual {v8}, Lcom/kochava/android/tracker/KochavaDbAdapter$KochavaDatabaseHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v4

    .line 266
    .local v4, "db":Landroid/database/sqlite/SQLiteDatabase;
    const-string v8, "SELECT * FROM events ORDER BY created_at ASC"

    .line 267
    const/4 v10, 0x0

    .line 266
    instance-of v11, v4, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v11, :cond_3

    invoke-virtual {v4, v8, v10}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v2

    .line 268
    .end local v4    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :goto_0
    new-instance v1, Lorg/json/JSONArray;

    invoke-direct {v1}, Lorg/json/JSONArray;-><init>()V

    .line 270
    .local v1, "arr":Lorg/json/JSONArray;
    :goto_1
    invoke-interface {v2}, Landroid/database/Cursor;->moveToNext()Z

    move-result v8

    if-nez v8, :cond_4

    .line 282
    invoke-virtual {v1}, Lorg/json/JSONArray;->length()I

    move-result v8

    if-lez v8, :cond_1

    .line 284
    sget-boolean v8, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v8, :cond_0

    .line 285
    const-string v10, "KochavaDbAdapter"

    new-instance v11, Ljava/lang/StringBuilder;

    const-string v8, "[JSON DATA VER 4] : "

    invoke-direct {v11, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    instance-of v8, v1, Lorg/json/JSONArray;

    if-nez v8, :cond_6

    invoke-virtual {v1}, Lorg/json/JSONArray;->toString()Ljava/lang/String;

    move-result-object v8

    :goto_2
    invoke-virtual {v11, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v10, v8}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 287
    :cond_0
    instance-of v8, v1, Lorg/json/JSONArray;

    if-nez v8, :cond_7

    invoke-virtual {v1}, Lorg/json/JSONArray;->toString()Ljava/lang/String;

    move-result-object v8

    .end local v1    # "arr":Lorg/json/JSONArray;
    :goto_3
    invoke-static {v8}, Lcom/kochava/android/util/Base64Coder;->encodeString(Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    move-result-object v3

    .line 293
    :cond_1
    :try_start_1
    iget-object v8, p0, Lcom/kochava/android/tracker/KochavaDbAdapter;->kDb:Lcom/kochava/android/tracker/KochavaDbAdapter$KochavaDatabaseHelper;

    invoke-virtual {v8}, Lcom/kochava/android/tracker/KochavaDbAdapter$KochavaDatabaseHelper;->close()V

    .line 294
    if-eqz v2, :cond_2

    .line 295
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    .line 299
    :cond_2
    :goto_4
    if-eqz v7, :cond_a

    if-eqz v3, :cond_a

    .line 303
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-static {v7}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v9

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v9, "="

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 305
    :goto_5
    return-object v8

    .line 266
    .restart local v4    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :cond_3
    :try_start_2
    check-cast v4, Landroid/database/sqlite/SQLiteDatabase;

    .end local v4    # "db":Landroid/database/sqlite/SQLiteDatabase;
    invoke-static {v4, v8, v10}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->rawQuery(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v2

    goto :goto_0

    .line 271
    .restart local v1    # "arr":Lorg/json/JSONArray;
    :cond_4
    invoke-interface {v2}, Landroid/database/Cursor;->isLast()Z

    move-result v8

    if-eqz v8, :cond_5

    .line 272
    const-string v8, "created_at"

    invoke-interface {v2, v8}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v8

    invoke-interface {v2, v8}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;
    :try_end_2
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_2 .. :try_end_2} :catch_1
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    move-result-object v7

    .line 275
    :cond_5
    :try_start_3
    new-instance v8, Lorg/json/JSONObject;

    const-string v8, "data"

    invoke-interface {v2, v8}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v8

    invoke-interface {v2, v8}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Lcom/newrelic/agent/android/instrumentation/JSONObjectInstrumentation;->init(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v6

    .line 276
    .local v6, "j":Lorg/json/JSONObject;
    invoke-virtual {v1, v6}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;
    :try_end_3
    .catch Lorg/json/JSONException; {:try_start_3 .. :try_end_3} :catch_0
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_3 .. :try_end_3} :catch_1
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    goto/16 :goto_1

    .line 277
    .end local v6    # "j":Lorg/json/JSONObject;
    :catch_0
    move-exception v8

    goto/16 :goto_1

    .line 285
    :cond_6
    :try_start_4
    move-object v0, v1

    check-cast v0, Lorg/json/JSONArray;

    move-object v8, v0

    invoke-static {v8}, Lcom/newrelic/agent/android/instrumentation/JSONArrayInstrumentation;->toString(Lorg/json/JSONArray;)Ljava/lang/String;

    move-result-object v8

    goto :goto_2

    .line 287
    :cond_7
    check-cast v1, Lorg/json/JSONArray;

    .end local v1    # "arr":Lorg/json/JSONArray;
    invoke-static {v1}, Lcom/newrelic/agent/android/instrumentation/JSONArrayInstrumentation;->toString(Lorg/json/JSONArray;)Ljava/lang/String;
    :try_end_4
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_4 .. :try_end_4} :catch_1
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    move-result-object v8

    goto :goto_3

    .line 290
    :catch_1
    move-exception v5

    .line 291
    .local v5, "e":Landroid/database/sqlite/SQLiteException;
    :try_start_5
    sget-boolean v8, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v8, :cond_8

    const-string v8, "KochavaDbAdapter"

    const-string v10, "generateDataString"

    invoke-static {v8, v10, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    .line 293
    :cond_8
    :try_start_6
    iget-object v8, p0, Lcom/kochava/android/tracker/KochavaDbAdapter;->kDb:Lcom/kochava/android/tracker/KochavaDbAdapter$KochavaDatabaseHelper;

    invoke-virtual {v8}, Lcom/kochava/android/tracker/KochavaDbAdapter$KochavaDatabaseHelper;->close()V

    .line 294
    if-eqz v2, :cond_2

    .line 295
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    goto :goto_4

    .line 259
    .end local v5    # "e":Landroid/database/sqlite/SQLiteException;
    :catchall_0
    move-exception v8

    monitor-exit p0
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    throw v8

    .line 292
    :catchall_1
    move-exception v8

    .line 293
    :try_start_7
    iget-object v9, p0, Lcom/kochava/android/tracker/KochavaDbAdapter;->kDb:Lcom/kochava/android/tracker/KochavaDbAdapter$KochavaDatabaseHelper;

    invoke-virtual {v9}, Lcom/kochava/android/tracker/KochavaDbAdapter$KochavaDatabaseHelper;->close()V

    .line 294
    if-eqz v2, :cond_9

    .line 295
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    .line 297
    :cond_9
    throw v8

    .line 305
    :cond_a
    monitor-exit p0
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    move-object v8, v9

    goto :goto_5
.end method

.method public getApplicationData(Ljava/lang/String;)Ljava/lang/String;
    .locals 7
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x0

    .line 215
    monitor-enter p0

    .line 217
    if-eqz p1, :cond_0

    :try_start_0
    invoke-virtual {p1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v4

    if-nez v4, :cond_1

    .line 218
    :cond_0
    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    const-string v3, ""

    .line 241
    :goto_0
    return-object v3

    .line 219
    :cond_1
    const/4 v0, 0x0

    .line 222
    .local v0, "c":Landroid/database/Cursor;
    :try_start_1
    iget-object v4, p0, Lcom/kochava/android/tracker/KochavaDbAdapter;->kDb:Lcom/kochava/android/tracker/KochavaDbAdapter$KochavaDatabaseHelper;

    invoke-virtual {v4}, Lcom/kochava/android/tracker/KochavaDbAdapter$KochavaDatabaseHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    .line 223
    .local v1, "db":Landroid/database/sqlite/SQLiteDatabase;
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "SELECT * FROM keys WHERE id=\'"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "\'"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x0

    instance-of v6, v1, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v6, :cond_3

    invoke-virtual {v1, v4, v5}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 224
    .end local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :goto_1
    invoke-interface {v0}, Landroid/database/Cursor;->moveToNext()Z

    move-result v4

    if-eqz v4, :cond_7

    .line 226
    const-string v4, "data"

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;
    :try_end_1
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result-object v3

    .line 235
    :try_start_2
    iget-object v4, p0, Lcom/kochava/android/tracker/KochavaDbAdapter;->kDb:Lcom/kochava/android/tracker/KochavaDbAdapter$KochavaDatabaseHelper;

    invoke-virtual {v4}, Lcom/kochava/android/tracker/KochavaDbAdapter$KochavaDatabaseHelper;->close()V

    .line 236
    if-eqz v0, :cond_2

    .line 238
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .line 226
    :cond_2
    monitor-exit p0

    goto :goto_0

    .line 215
    .end local v0    # "c":Landroid/database/Cursor;
    :catchall_0
    move-exception v3

    monitor-exit p0
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v3

    .line 223
    .restart local v0    # "c":Landroid/database/Cursor;
    .restart local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :cond_3
    :try_start_3
    check-cast v1, Landroid/database/sqlite/SQLiteDatabase;

    .end local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    invoke-static {v1, v4, v5}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->rawQuery(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_3
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    move-result-object v0

    goto :goto_1

    .line 229
    :catch_0
    move-exception v2

    .line 231
    .local v2, "e":Landroid/database/sqlite/SQLiteException;
    :try_start_4
    sget-boolean v4, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v4, :cond_4

    const-string v4, "KochavaDbAdapter"

    const-string v5, "generateDataString"

    invoke-static {v4, v5, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .line 235
    :cond_4
    :try_start_5
    iget-object v4, p0, Lcom/kochava/android/tracker/KochavaDbAdapter;->kDb:Lcom/kochava/android/tracker/KochavaDbAdapter$KochavaDatabaseHelper;

    invoke-virtual {v4}, Lcom/kochava/android/tracker/KochavaDbAdapter$KochavaDatabaseHelper;->close()V

    .line 236
    if-eqz v0, :cond_5

    .line 238
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .line 240
    .end local v2    # "e":Landroid/database/sqlite/SQLiteException;
    :cond_5
    :goto_2
    monitor-exit p0

    goto :goto_0

    .line 234
    :catchall_1
    move-exception v3

    .line 235
    iget-object v4, p0, Lcom/kochava/android/tracker/KochavaDbAdapter;->kDb:Lcom/kochava/android/tracker/KochavaDbAdapter$KochavaDatabaseHelper;

    invoke-virtual {v4}, Lcom/kochava/android/tracker/KochavaDbAdapter$KochavaDatabaseHelper;->close()V

    .line 236
    if-eqz v0, :cond_6

    .line 238
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .line 240
    :cond_6
    throw v3

    .line 235
    :cond_7
    iget-object v4, p0, Lcom/kochava/android/tracker/KochavaDbAdapter;->kDb:Lcom/kochava/android/tracker/KochavaDbAdapter$KochavaDatabaseHelper;

    invoke-virtual {v4}, Lcom/kochava/android/tracker/KochavaDbAdapter$KochavaDatabaseHelper;->close()V

    .line 236
    if-eqz v0, :cond_5

    .line 238
    invoke-interface {v0}, Landroid/database/Cursor;->close()V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    goto :goto_2
.end method

.method public insertApplicationData(Ljava/lang/String;Ljava/lang/String;)V
    .locals 7
    .param p1, "id"    # Ljava/lang/String;
    .param p2, "data"    # Ljava/lang/String;

    .prologue
    .line 186
    monitor-enter p0

    .line 188
    if-eqz p1, :cond_0

    :try_start_0
    invoke-virtual {p1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v4

    if-nez v4, :cond_1

    .line 189
    :cond_0
    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 212
    :goto_0
    return-void

    .line 190
    :cond_1
    const/4 v0, 0x0

    .line 193
    .local v0, "c":Landroid/database/Cursor;
    :try_start_1
    iget-object v4, p0, Lcom/kochava/android/tracker/KochavaDbAdapter;->kDb:Lcom/kochava/android/tracker/KochavaDbAdapter$KochavaDatabaseHelper;

    invoke-virtual {v4}, Lcom/kochava/android/tracker/KochavaDbAdapter$KochavaDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v2

    .line 194
    .local v2, "db":Landroid/database/sqlite/SQLiteDatabase;
    new-instance v1, Landroid/content/ContentValues;

    invoke-direct {v1}, Landroid/content/ContentValues;-><init>()V

    .line 195
    .local v1, "cv":Landroid/content/ContentValues;
    const-string v4, "id"

    invoke-virtual {v1, v4, p1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 196
    const-string v4, "data"

    invoke-virtual {v1, v4, p2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 197
    const-string v4, "keys"

    const/4 v5, 0x0

    instance-of v6, v2, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v6, :cond_3

    invoke-virtual {v2, v4, v5, v1}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    :try_end_1
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 205
    .end local v2    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :goto_1
    :try_start_2
    iget-object v4, p0, Lcom/kochava/android/tracker/KochavaDbAdapter;->kDb:Lcom/kochava/android/tracker/KochavaDbAdapter$KochavaDatabaseHelper;

    invoke-virtual {v4}, Lcom/kochava/android/tracker/KochavaDbAdapter$KochavaDatabaseHelper;->close()V

    .line 206
    if-eqz v0, :cond_2

    .line 208
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .line 186
    .end local v1    # "cv":Landroid/content/ContentValues;
    :cond_2
    :goto_2
    monitor-exit p0

    goto :goto_0

    .end local v0    # "c":Landroid/database/Cursor;
    :catchall_0
    move-exception v4

    monitor-exit p0
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v4

    .line 197
    .restart local v0    # "c":Landroid/database/Cursor;
    .restart local v1    # "cv":Landroid/content/ContentValues;
    .restart local v2    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :cond_3
    :try_start_3
    check-cast v2, Landroid/database/sqlite/SQLiteDatabase;

    .end local v2    # "db":Landroid/database/sqlite/SQLiteDatabase;
    invoke-static {v2, v4, v5, v1}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->insert(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    :try_end_3
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    goto :goto_1

    .line 199
    .end local v1    # "cv":Landroid/content/ContentValues;
    :catch_0
    move-exception v3

    .line 201
    .local v3, "e":Landroid/database/sqlite/SQLiteException;
    :try_start_4
    sget-boolean v4, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v4, :cond_4

    const-string v4, "KochavaDbAdapter"

    const-string v5, "addEvent"

    invoke-static {v4, v5, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .line 205
    :cond_4
    :try_start_5
    iget-object v4, p0, Lcom/kochava/android/tracker/KochavaDbAdapter;->kDb:Lcom/kochava/android/tracker/KochavaDbAdapter$KochavaDatabaseHelper;

    invoke-virtual {v4}, Lcom/kochava/android/tracker/KochavaDbAdapter$KochavaDatabaseHelper;->close()V

    .line 206
    if-eqz v0, :cond_2

    .line 208
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    goto :goto_2

    .line 204
    .end local v3    # "e":Landroid/database/sqlite/SQLiteException;
    :catchall_1
    move-exception v4

    .line 205
    iget-object v5, p0, Lcom/kochava/android/tracker/KochavaDbAdapter;->kDb:Lcom/kochava/android/tracker/KochavaDbAdapter$KochavaDatabaseHelper;

    invoke-virtual {v5}, Lcom/kochava/android/tracker/KochavaDbAdapter$KochavaDatabaseHelper;->close()V

    .line 206
    if-eqz v0, :cond_5

    .line 208
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .line 210
    :cond_5
    throw v4
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0
.end method

.method public updateApplicationData(Ljava/lang/String;Ljava/lang/String;)V
    .locals 8
    .param p1, "id"    # Ljava/lang/String;
    .param p2, "data"    # Ljava/lang/String;

    .prologue
    .line 156
    monitor-enter p0

    .line 158
    if-eqz p1, :cond_0

    :try_start_0
    invoke-virtual {p1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/String;->length()I

    move-result v5

    if-nez v5, :cond_1

    .line 159
    :cond_0
    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 183
    :goto_0
    return-void

    .line 160
    :cond_1
    const/4 v0, 0x0

    .line 163
    .local v0, "c":Landroid/database/Cursor;
    :try_start_1
    iget-object v5, p0, Lcom/kochava/android/tracker/KochavaDbAdapter;->kDb:Lcom/kochava/android/tracker/KochavaDbAdapter$KochavaDatabaseHelper;

    invoke-virtual {v5}, Lcom/kochava/android/tracker/KochavaDbAdapter$KochavaDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v2

    .line 164
    .local v2, "db":Landroid/database/sqlite/SQLiteDatabase;
    new-instance v1, Landroid/content/ContentValues;

    invoke-direct {v1}, Landroid/content/ContentValues;-><init>()V

    .line 165
    .local v1, "cv":Landroid/content/ContentValues;
    const-string v5, "data"

    invoke-virtual {v1, v5, p2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 167
    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "id=\'"

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "\'"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 168
    .local v4, "whereClause":Ljava/lang/String;
    const-string v5, "keys"

    const/4 v6, 0x0

    instance-of v7, v2, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v7, :cond_3

    invoke-virtual {v2, v5, v1, v4, v6}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_1
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 176
    .end local v2    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :goto_1
    :try_start_2
    iget-object v5, p0, Lcom/kochava/android/tracker/KochavaDbAdapter;->kDb:Lcom/kochava/android/tracker/KochavaDbAdapter$KochavaDatabaseHelper;

    invoke-virtual {v5}, Lcom/kochava/android/tracker/KochavaDbAdapter$KochavaDatabaseHelper;->close()V

    .line 177
    if-eqz v0, :cond_2

    .line 179
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .line 156
    .end local v1    # "cv":Landroid/content/ContentValues;
    .end local v4    # "whereClause":Ljava/lang/String;
    :cond_2
    :goto_2
    monitor-exit p0

    goto :goto_0

    .end local v0    # "c":Landroid/database/Cursor;
    :catchall_0
    move-exception v5

    monitor-exit p0
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v5

    .line 168
    .restart local v0    # "c":Landroid/database/Cursor;
    .restart local v1    # "cv":Landroid/content/ContentValues;
    .restart local v2    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .restart local v4    # "whereClause":Ljava/lang/String;
    :cond_3
    :try_start_3
    check-cast v2, Landroid/database/sqlite/SQLiteDatabase;

    .end local v2    # "db":Landroid/database/sqlite/SQLiteDatabase;
    invoke-static {v2, v5, v1, v4, v6}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->update(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_3
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    goto :goto_1

    .line 170
    .end local v1    # "cv":Landroid/content/ContentValues;
    .end local v4    # "whereClause":Ljava/lang/String;
    :catch_0
    move-exception v3

    .line 172
    .local v3, "e":Landroid/database/sqlite/SQLiteException;
    :try_start_4
    sget-boolean v5, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v5, :cond_4

    const-string v5, "KochavaDbAdapter"

    const-string v6, "addEvent"

    invoke-static {v5, v6, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .line 176
    :cond_4
    :try_start_5
    iget-object v5, p0, Lcom/kochava/android/tracker/KochavaDbAdapter;->kDb:Lcom/kochava/android/tracker/KochavaDbAdapter$KochavaDatabaseHelper;

    invoke-virtual {v5}, Lcom/kochava/android/tracker/KochavaDbAdapter$KochavaDatabaseHelper;->close()V

    .line 177
    if-eqz v0, :cond_2

    .line 179
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    goto :goto_2

    .line 175
    .end local v3    # "e":Landroid/database/sqlite/SQLiteException;
    :catchall_1
    move-exception v5

    .line 176
    iget-object v6, p0, Lcom/kochava/android/tracker/KochavaDbAdapter;->kDb:Lcom/kochava/android/tracker/KochavaDbAdapter$KochavaDatabaseHelper;

    invoke-virtual {v6}, Lcom/kochava/android/tracker/KochavaDbAdapter$KochavaDatabaseHelper;->close()V

    .line 177
    if-eqz v0, :cond_5

    .line 179
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .line 181
    :cond_5
    throw v5
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0
.end method
