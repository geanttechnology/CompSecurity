.class Lnet/singular/sdk/EventStore;
.super Ljava/lang/Object;
.source "EventStore.java"


# static fields
.field private static ALL_COLUMNS:[Ljava/lang/String; = null

.field static final EVENTS_TABLE:Ljava/lang/String; = "events"

.field static final ID_COLUMN:Ljava/lang/String; = "_id"

.field static final JSON_COLUMN:Ljava/lang/String; = "json"


# instance fields
.field private countersLogger:Lnet/singular/sdk/CountersLogger;

.field private final log:Lnet/singular/sdk/SingularLog;

.field private final maxStoreSize:J

.field private final singularSQLiteHelper:Lnet/singular/sdk/SingularSQLiteHelper;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 17
    const/4 v0, 0x2

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "_id"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string v2, "json"

    aput-object v2, v0, v1

    sput-object v0, Lnet/singular/sdk/EventStore;->ALL_COLUMNS:[Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lnet/singular/sdk/SingularLog;Lnet/singular/sdk/SingularSQLiteHelper;Lnet/singular/sdk/ManifestHelper;Lnet/singular/sdk/CountersLogger;)V
    .locals 4
    .param p1, "log"    # Lnet/singular/sdk/SingularLog;
    .param p2, "singularSQLiteHelper"    # Lnet/singular/sdk/SingularSQLiteHelper;
    .param p3, "manifestHelper"    # Lnet/singular/sdk/ManifestHelper;
    .param p4, "countersLogger"    # Lnet/singular/sdk/CountersLogger;

    .prologue
    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    iput-object p1, p0, Lnet/singular/sdk/EventStore;->log:Lnet/singular/sdk/SingularLog;

    .line 26
    iput-object p2, p0, Lnet/singular/sdk/EventStore;->singularSQLiteHelper:Lnet/singular/sdk/SingularSQLiteHelper;

    .line 27
    const-string v0, "net.singular.max_event_store_size"

    const-wide/16 v2, 0x3e8

    invoke-virtual {p3, v0, v2, v3}, Lnet/singular/sdk/ManifestHelper;->tryToGetManifestAttributeLong(Ljava/lang/String;J)J

    move-result-wide v0

    iput-wide v0, p0, Lnet/singular/sdk/EventStore;->maxStoreSize:J

    .line 30
    iput-object p4, p0, Lnet/singular/sdk/EventStore;->countersLogger:Lnet/singular/sdk/CountersLogger;

    .line 31
    return-void
.end method

.method private deleteEvent(J)Z
    .locals 11
    .param p1, "event_id"    # J

    .prologue
    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 83
    :try_start_0
    iget-object v5, p0, Lnet/singular/sdk/EventStore;->singularSQLiteHelper:Lnet/singular/sdk/SingularSQLiteHelper;

    invoke-virtual {v5}, Lnet/singular/sdk/SingularSQLiteHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    .line 84
    .local v1, "database":Landroid/database/sqlite/SQLiteDatabase;
    const/4 v5, 0x1

    new-array v0, v5, [Ljava/lang/String;

    .line 85
    .local v0, "args_array":[Ljava/lang/String;
    iget-object v5, p0, Lnet/singular/sdk/EventStore;->log:Lnet/singular/sdk/SingularLog;

    const-string v6, "singular_sdk"

    const-string v7, "EventStore deleteEvent: %d"

    const/4 v8, 0x1

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v10

    aput-object v10, v8, v9

    invoke-static {v7, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v5, v6, v7}, Lnet/singular/sdk/SingularLog;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 86
    const/4 v5, 0x0

    invoke-static {p1, p2}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v0, v5

    .line 87
    const-string v5, "events"

    const-string v6, "_id = ?"

    instance-of v7, v1, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v7, :cond_0

    invoke-virtual {v1, v5, v6, v0}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_0
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v5

    .end local v1    # "database":Landroid/database/sqlite/SQLiteDatabase;
    :goto_0
    if-ne v5, v3, :cond_1

    .line 93
    :goto_1
    invoke-direct {p0}, Lnet/singular/sdk/EventStore;->updateEventsCounter()V

    .end local v0    # "args_array":[Ljava/lang/String;
    :goto_2
    return v3

    .line 87
    .restart local v0    # "args_array":[Ljava/lang/String;
    .restart local v1    # "database":Landroid/database/sqlite/SQLiteDatabase;
    :cond_0
    :try_start_1
    check-cast v1, Landroid/database/sqlite/SQLiteDatabase;

    .end local v1    # "database":Landroid/database/sqlite/SQLiteDatabase;
    invoke-static {v1, v5, v6, v0}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->delete(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_1
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result v5

    goto :goto_0

    :cond_1
    move v3, v4

    goto :goto_1

    .line 90
    .end local v0    # "args_array":[Ljava/lang/String;
    :catch_0
    move-exception v2

    .line 93
    .local v2, "e":Landroid/database/sqlite/SQLiteException;
    invoke-direct {p0}, Lnet/singular/sdk/EventStore;->updateEventsCounter()V

    move v3, v4

    goto :goto_2

    .end local v2    # "e":Landroid/database/sqlite/SQLiteException;
    :catchall_0
    move-exception v3

    invoke-direct {p0}, Lnet/singular/sdk/EventStore;->updateEventsCounter()V

    throw v3
.end method

.method private getEventCount()I
    .locals 13
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/database/sqlite/SQLiteException;
        }
    .end annotation

    .prologue
    const/4 v3, 0x0

    .line 127
    iget-object v1, p0, Lnet/singular/sdk/EventStore;->singularSQLiteHelper:Lnet/singular/sdk/SingularSQLiteHelper;

    invoke-virtual {v1}, Lnet/singular/sdk/SingularSQLiteHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 129
    .local v0, "database":Landroid/database/sqlite/SQLiteDatabase;
    const-string v1, "events"

    sget-object v2, Lnet/singular/sdk/EventStore;->ALL_COLUMNS:[Ljava/lang/String;

    instance-of v4, v0, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v4, :cond_0

    move-object v4, v3

    move-object v5, v3

    move-object v6, v3

    move-object v7, v3

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v12

    .line 137
    .local v12, "cursor":Landroid/database/Cursor;
    :goto_0
    :try_start_0
    invoke-interface {v12}, Landroid/database/Cursor;->getCount()I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v1

    .line 139
    invoke-interface {v12}, Landroid/database/Cursor;->close()V

    return v1

    .end local v12    # "cursor":Landroid/database/Cursor;
    :cond_0
    move-object v4, v0

    .line 129
    check-cast v4, Landroid/database/sqlite/SQLiteDatabase;

    move-object v5, v1

    move-object v6, v2

    move-object v7, v3

    move-object v8, v3

    move-object v9, v3

    move-object v10, v3

    move-object v11, v3

    invoke-static/range {v4 .. v11}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->query(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v12

    goto :goto_0

    .line 139
    .restart local v12    # "cursor":Landroid/database/Cursor;
    :catchall_0
    move-exception v1

    invoke-interface {v12}, Landroid/database/Cursor;->close()V

    throw v1
.end method

.method private getOldestEvent()J
    .locals 21
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/database/sqlite/SQLiteException;
        }
    .end annotation

    .prologue
    .line 103
    move-object/from16 v0, p0

    iget-object v3, v0, Lnet/singular/sdk/EventStore;->singularSQLiteHelper:Lnet/singular/sdk/SingularSQLiteHelper;

    invoke-virtual {v3}, Lnet/singular/sdk/SingularSQLiteHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v2

    .line 104
    .local v2, "database":Landroid/database/sqlite/SQLiteDatabase;
    move-object/from16 v0, p0

    iget-object v3, v0, Lnet/singular/sdk/EventStore;->log:Lnet/singular/sdk/SingularLog;

    const-string v4, "singular_sdk"

    const-string v5, "EventStore: getOldestEvent"

    const/4 v6, 0x0

    new-array v6, v6, [Ljava/lang/Object;

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Lnet/singular/sdk/SingularLog;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 105
    const-string v3, "events"

    sget-object v4, Lnet/singular/sdk/EventStore;->ALL_COLUMNS:[Ljava/lang/String;

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    const-string v9, "_id ASC"

    const-string v10, "1"

    instance-of v11, v2, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v11, :cond_0

    invoke-virtual/range {v2 .. v10}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v20

    .line 114
    .local v20, "cursor":Landroid/database/Cursor;
    :goto_0
    :try_start_0
    invoke-interface/range {v20 .. v20}, Landroid/database/Cursor;->moveToFirst()Z

    .line 115
    const/4 v3, 0x0

    move-object/from16 v0, v20

    invoke-interface {v0, v3}, Landroid/database/Cursor;->getLong(I)J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-wide v4

    .line 117
    invoke-interface/range {v20 .. v20}, Landroid/database/Cursor;->close()V

    return-wide v4

    .end local v20    # "cursor":Landroid/database/Cursor;
    :cond_0
    move-object v11, v2

    .line 105
    check-cast v11, Landroid/database/sqlite/SQLiteDatabase;

    move-object v12, v3

    move-object v13, v4

    move-object v14, v5

    move-object v15, v6

    move-object/from16 v16, v7

    move-object/from16 v17, v8

    move-object/from16 v18, v9

    move-object/from16 v19, v10

    invoke-static/range {v11 .. v19}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->query(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v20

    goto :goto_0

    .line 117
    .restart local v20    # "cursor":Landroid/database/Cursor;
    :catchall_0
    move-exception v3

    invoke-interface/range {v20 .. v20}, Landroid/database/Cursor;->close()V

    throw v3
.end method

.method public static onCreate(Landroid/database/sqlite/SQLiteDatabase;Lnet/singular/sdk/SingularLog;)V
    .locals 4
    .param p0, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p1, "log"    # Lnet/singular/sdk/SingularLog;

    .prologue
    .line 246
    const-string v1, "singular_sdk"

    const-string v2, "EventStore onCreate"

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Object;

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v1, v2}, Lnet/singular/sdk/SingularLog;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 247
    const-string v0, "create table events(_id INTEGER primary key autoincrement, json text not null);"

    .line 251
    .local v0, "database_create":Ljava/lang/String;
    instance-of v1, p0, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v1, :cond_0

    invoke-virtual {p0, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 252
    .end local p0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :goto_0
    return-void

    .line 251
    .restart local p0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :cond_0
    check-cast p0, Landroid/database/sqlite/SQLiteDatabase;

    .end local p0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    invoke-static {p0, v0}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->execSQL(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static onUpgrade(Landroid/database/sqlite/SQLiteDatabase;IILnet/singular/sdk/SingularLog;)V
    .locals 3
    .param p0, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p1, "oldVersion"    # I
    .param p2, "newVersion"    # I
    .param p3, "log"    # Lnet/singular/sdk/SingularLog;

    .prologue
    .line 255
    const-string v0, "singular_sdk"

    const-string v1, "EventStore onUpgrade"

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Object;

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p3, v0, v1}, Lnet/singular/sdk/SingularLog;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 256
    if-eq p1, p2, :cond_0

    .line 258
    const-string v1, "DROP TABLE IF EXISTS events;"

    instance-of v0, p0, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v0, :cond_1

    invoke-virtual {p0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 259
    :goto_0
    invoke-static {p0, p3}, Lnet/singular/sdk/EventStore;->onCreate(Landroid/database/sqlite/SQLiteDatabase;Lnet/singular/sdk/SingularLog;)V

    .line 261
    :cond_0
    return-void

    :cond_1
    move-object v0, p0

    .line 258
    check-cast v0, Landroid/database/sqlite/SQLiteDatabase;

    invoke-static {v0, v1}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->execSQL(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)V

    goto :goto_0
.end method

.method private updateEventsCounter()V
    .locals 6

    .prologue
    .line 69
    invoke-direct {p0}, Lnet/singular/sdk/EventStore;->getEventCount()I

    move-result v0

    .line 70
    .local v0, "event_count":I
    iget-object v1, p0, Lnet/singular/sdk/EventStore;->countersLogger:Lnet/singular/sdk/CountersLogger;

    if-eqz v1, :cond_0

    .line 71
    iget-object v1, p0, Lnet/singular/sdk/EventStore;->countersLogger:Lnet/singular/sdk/CountersLogger;

    const-string v2, "events_waiting_in_queue"

    int-to-long v4, v0

    invoke-virtual {v1, v2, v4, v5}, Lnet/singular/sdk/CountersLogger;->setCounter(Ljava/lang/String;J)V

    .line 73
    :cond_0
    return-void
.end method


# virtual methods
.method public addEvent(Lorg/json/JSONObject;)Z
    .locals 14
    .param p1, "event"    # Lorg/json/JSONObject;

    .prologue
    const/4 v9, 0x0

    .line 42
    :try_start_0
    iget-object v10, p0, Lnet/singular/sdk/EventStore;->log:Lnet/singular/sdk/SingularLog;

    const-string v11, "singular_sdk"

    const-string v12, "EventStore: addEvent called"

    invoke-virtual {v10, v11, v12}, Lnet/singular/sdk/SingularLog;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 43
    iget-object v10, p0, Lnet/singular/sdk/EventStore;->singularSQLiteHelper:Lnet/singular/sdk/SingularSQLiteHelper;

    invoke-virtual {v10}, Lnet/singular/sdk/SingularSQLiteHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 44
    .local v0, "database":Landroid/database/sqlite/SQLiteDatabase;
    new-instance v8, Landroid/content/ContentValues;

    invoke-direct {v8}, Landroid/content/ContentValues;-><init>()V

    .line 45
    .local v8, "values":Landroid/content/ContentValues;
    const-string v11, "json"

    instance-of v10, p1, Lorg/json/JSONObject;

    if-nez v10, :cond_0

    invoke-virtual {p1}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v10

    .end local p1    # "event":Lorg/json/JSONObject;
    :goto_0
    invoke-virtual {v8, v11, v10}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 46
    invoke-direct {p0}, Lnet/singular/sdk/EventStore;->getEventCount()I

    move-result v2

    .line 47
    .local v2, "event_count":I
    int-to-long v10, v2

    iget-wide v12, p0, Lnet/singular/sdk/EventStore;->maxStoreSize:J

    cmp-long v10, v10, v12

    if-ltz v10, :cond_2

    .line 48
    invoke-direct {p0}, Lnet/singular/sdk/EventStore;->getOldestEvent()J

    move-result-wide v4

    .line 49
    .local v4, "oldest_event_id":J
    invoke-direct {p0, v4, v5}, Lnet/singular/sdk/EventStore;->deleteEvent(J)Z
    :try_end_0
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v10

    if-nez v10, :cond_1

    .line 63
    invoke-direct {p0}, Lnet/singular/sdk/EventStore;->updateEventsCounter()V

    move v3, v9

    .end local v0    # "database":Landroid/database/sqlite/SQLiteDatabase;
    .end local v2    # "event_count":I
    .end local v4    # "oldest_event_id":J
    .end local v8    # "values":Landroid/content/ContentValues;
    :goto_1
    return v3

    .line 45
    .restart local v0    # "database":Landroid/database/sqlite/SQLiteDatabase;
    .restart local v8    # "values":Landroid/content/ContentValues;
    .restart local p1    # "event":Lorg/json/JSONObject;
    :cond_0
    :try_start_1
    check-cast p1, Lorg/json/JSONObject;

    .end local p1    # "event":Lorg/json/JSONObject;
    invoke-static {p1}, Lcom/newrelic/agent/android/instrumentation/JSONObjectInstrumentation;->toString(Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v10

    goto :goto_0

    .line 51
    .restart local v2    # "event_count":I
    .restart local v4    # "oldest_event_id":J
    :cond_1
    iget-object v10, p0, Lnet/singular/sdk/EventStore;->countersLogger:Lnet/singular/sdk/CountersLogger;

    const-string v11, "event_store_was_full"

    invoke-virtual {v10, v11}, Lnet/singular/sdk/CountersLogger;->increaseCounter(Ljava/lang/String;)J

    .line 53
    .end local v4    # "oldest_event_id":J
    :cond_2
    const-string v10, "events"

    const/4 v11, 0x0

    instance-of v12, v0, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v12, :cond_4

    invoke-virtual {v0, v10, v11, v8}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    move-result-wide v6

    .line 54
    .end local v0    # "database":Landroid/database/sqlite/SQLiteDatabase;
    .local v6, "ret":J
    :goto_2
    const-wide/16 v10, -0x1

    cmp-long v10, v6, v10

    if-eqz v10, :cond_5

    const/4 v3, 0x1

    .line 55
    .local v3, "success":Z
    :goto_3
    if-eqz v3, :cond_3

    .line 56
    iget-object v10, p0, Lnet/singular/sdk/EventStore;->countersLogger:Lnet/singular/sdk/CountersLogger;

    const-string v11, "total_events_since_install"

    invoke-virtual {v10, v11}, Lnet/singular/sdk/CountersLogger;->increaseCounter(Ljava/lang/String;)J
    :try_end_1
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 63
    :cond_3
    invoke-direct {p0}, Lnet/singular/sdk/EventStore;->updateEventsCounter()V

    goto :goto_1

    .line 53
    .end local v3    # "success":Z
    .end local v6    # "ret":J
    .restart local v0    # "database":Landroid/database/sqlite/SQLiteDatabase;
    :cond_4
    :try_start_2
    check-cast v0, Landroid/database/sqlite/SQLiteDatabase;

    .end local v0    # "database":Landroid/database/sqlite/SQLiteDatabase;
    invoke-static {v0, v10, v11, v8}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->insert(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    :try_end_2
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    move-result-wide v6

    goto :goto_2

    .restart local v6    # "ret":J
    :cond_5
    move v3, v9

    .line 54
    goto :goto_3

    .line 59
    .end local v2    # "event_count":I
    .end local v6    # "ret":J
    .end local v8    # "values":Landroid/content/ContentValues;
    :catch_0
    move-exception v1

    .line 60
    .local v1, "e":Landroid/database/sqlite/SQLiteException;
    :try_start_3
    iget-object v10, p0, Lnet/singular/sdk/EventStore;->log:Lnet/singular/sdk/SingularLog;

    const-string v11, "singular_sdk"

    const-string v12, "Failed saving event to DB"

    invoke-virtual {v10, v11, v12, v1}, Lnet/singular/sdk/SingularLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 63
    invoke-direct {p0}, Lnet/singular/sdk/EventStore;->updateEventsCounter()V

    move v3, v9

    goto :goto_1

    .end local v1    # "e":Landroid/database/sqlite/SQLiteException;
    :catchall_0
    move-exception v9

    invoke-direct {p0}, Lnet/singular/sdk/EventStore;->updateEventsCounter()V

    throw v9
.end method

.method public deleteAllEvents()Z
    .locals 6

    .prologue
    .line 233
    :try_start_0
    iget-object v2, p0, Lnet/singular/sdk/EventStore;->singularSQLiteHelper:Lnet/singular/sdk/SingularSQLiteHelper;

    invoke-virtual {v2}, Lnet/singular/sdk/SingularSQLiteHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 234
    .local v0, "database":Landroid/database/sqlite/SQLiteDatabase;
    const-string v2, "events"

    const-string v3, "1"

    const/4 v4, 0x0

    instance-of v5, v0, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v5, :cond_0

    invoke-virtual {v0, v2, v3, v4}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_0
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 235
    .end local v0    # "database":Landroid/database/sqlite/SQLiteDatabase;
    :goto_0
    const/4 v2, 0x1

    .line 239
    invoke-direct {p0}, Lnet/singular/sdk/EventStore;->updateEventsCounter()V

    :goto_1
    return v2

    .line 234
    .restart local v0    # "database":Landroid/database/sqlite/SQLiteDatabase;
    :cond_0
    :try_start_1
    check-cast v0, Landroid/database/sqlite/SQLiteDatabase;

    .end local v0    # "database":Landroid/database/sqlite/SQLiteDatabase;
    invoke-static {v0, v2, v3, v4}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->delete(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_1
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 236
    :catch_0
    move-exception v1

    .line 237
    .local v1, "e":Landroid/database/sqlite/SQLiteException;
    const/4 v2, 0x0

    .line 239
    invoke-direct {p0}, Lnet/singular/sdk/EventStore;->updateEventsCounter()V

    goto :goto_1

    .end local v1    # "e":Landroid/database/sqlite/SQLiteException;
    :catchall_0
    move-exception v2

    invoke-direct {p0}, Lnet/singular/sdk/EventStore;->updateEventsCounter()V

    throw v2
.end method

.method public deleteEvents(J)Z
    .locals 11
    .param p1, "maxId"    # J

    .prologue
    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 216
    :try_start_0
    iget-object v5, p0, Lnet/singular/sdk/EventStore;->singularSQLiteHelper:Lnet/singular/sdk/SingularSQLiteHelper;

    invoke-virtual {v5}, Lnet/singular/sdk/SingularSQLiteHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 217
    .local v0, "database":Landroid/database/sqlite/SQLiteDatabase;
    iget-object v5, p0, Lnet/singular/sdk/EventStore;->log:Lnet/singular/sdk/SingularLog;

    const-string v6, "singular_sdk"

    const-string v7, "EventStore deleteEvents: maxId=%d"

    const/4 v8, 0x1

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v10

    aput-object v10, v8, v9

    invoke-static {v7, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v5, v6, v7}, Lnet/singular/sdk/SingularLog;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 218
    const-string v5, "events"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "_id <= "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-static {p1, p2}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    const/4 v7, 0x0

    instance-of v8, v0, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v8, :cond_0

    invoke-virtual {v0, v5, v6, v7}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v1

    .line 221
    .end local v0    # "database":Landroid/database/sqlite/SQLiteDatabase;
    .local v1, "delete_count":I
    :goto_0
    if-lez v1, :cond_1

    .line 223
    .end local v1    # "delete_count":I
    :goto_1
    return v3

    .line 218
    .restart local v0    # "database":Landroid/database/sqlite/SQLiteDatabase;
    :cond_0
    check-cast v0, Landroid/database/sqlite/SQLiteDatabase;

    .end local v0    # "database":Landroid/database/sqlite/SQLiteDatabase;
    invoke-static {v0, v5, v6, v7}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->delete(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_0
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v1

    goto :goto_0

    .restart local v1    # "delete_count":I
    :cond_1
    move v3, v4

    .line 221
    goto :goto_1

    .line 222
    .end local v1    # "delete_count":I
    :catch_0
    move-exception v2

    .local v2, "e":Landroid/database/sqlite/SQLiteException;
    move v3, v4

    .line 223
    goto :goto_1
.end method

.method public getEvents(I)Landroid/util/Pair;
    .locals 28
    .param p1, "limit"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)",
            "Landroid/util/Pair",
            "<",
            "Ljava/lang/Long;",
            "Lorg/json/JSONArray;",
            ">;"
        }
    .end annotation

    .prologue
    .line 155
    :try_start_0
    move-object/from16 v0, p0

    iget-object v5, v0, Lnet/singular/sdk/EventStore;->singularSQLiteHelper:Lnet/singular/sdk/SingularSQLiteHelper;

    invoke-virtual {v5}, Lnet/singular/sdk/SingularSQLiteHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v4

    .line 156
    .local v4, "database":Landroid/database/sqlite/SQLiteDatabase;
    move-object/from16 v0, p0

    iget-object v5, v0, Lnet/singular/sdk/EventStore;->log:Lnet/singular/sdk/SingularLog;

    const-string v6, "singular_sdk"

    const-string v7, "EventStore getEvent: limit=%d"

    const/4 v8, 0x1

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    invoke-static/range {p1 .. p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    aput-object v10, v8, v9

    invoke-static {v7, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v5, v6, v7}, Lnet/singular/sdk/SingularLog;->d(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_0 .. :try_end_0} :catch_0

    .line 157
    const/16 v22, 0x0

    .line 159
    .local v22, "cursor":Landroid/database/Cursor;
    const/4 v5, -0x1

    move/from16 v0, p1

    if-ne v0, v5, :cond_3

    .line 160
    :try_start_1
    const-string v5, "events"

    sget-object v6, Lnet/singular/sdk/EventStore;->ALL_COLUMNS:[Ljava/lang/String;

    const/4 v7, 0x0

    const/4 v8, 0x0

    const/4 v9, 0x0

    const/4 v10, 0x0

    const-string v11, "_id ASC"

    const/4 v12, 0x0

    instance-of v13, v4, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v13, :cond_2

    invoke-virtual/range {v4 .. v12}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v22

    .line 178
    :goto_0
    new-instance v24, Lorg/json/JSONArray;

    invoke-direct/range {v24 .. v24}, Lorg/json/JSONArray;-><init>()V

    .line 179
    .local v24, "events":Lorg/json/JSONArray;
    const-wide/16 v26, 0x0

    .line 181
    .local v26, "last_id":J
    invoke-interface/range {v22 .. v22}, Landroid/database/Cursor;->moveToFirst()Z

    .line 182
    :goto_1
    invoke-interface/range {v22 .. v22}, Landroid/database/Cursor;->isAfterLast()Z

    move-result v5

    if-nez v5, :cond_5

    .line 183
    const/4 v5, 0x0

    move-object/from16 v0, v22

    invoke-interface {v0, v5}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v26

    .line 184
    const/4 v5, 0x1

    move-object/from16 v0, v22

    invoke-interface {v0, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v25

    .line 186
    .local v25, "last_json_encoded":Ljava/lang/String;
    :try_start_2
    new-instance v5, Lorg/json/JSONObject;

    invoke-static/range {v25 .. v25}, Lcom/newrelic/agent/android/instrumentation/JSONObjectInstrumentation;->init(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v5

    move-object/from16 v0, v24

    invoke-virtual {v0, v5}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;
    :try_end_2
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_1
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 193
    :goto_2
    :try_start_3
    invoke-interface/range {v22 .. v22}, Landroid/database/Cursor;->moveToNext()Z
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_1

    .line 197
    .end local v24    # "events":Lorg/json/JSONArray;
    .end local v25    # "last_json_encoded":Ljava/lang/String;
    .end local v26    # "last_id":J
    :catchall_0
    move-exception v5

    if-eqz v22, :cond_0

    .line 198
    :try_start_4
    invoke-interface/range {v22 .. v22}, Landroid/database/Cursor;->close()V

    :cond_0
    throw v5
    :try_end_4
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_4 .. :try_end_4} :catch_0

    .line 201
    .end local v4    # "database":Landroid/database/sqlite/SQLiteDatabase;
    .end local v22    # "cursor":Landroid/database/Cursor;
    :catch_0
    move-exception v23

    .line 202
    .local v23, "e":Landroid/database/sqlite/SQLiteException;
    const/4 v5, 0x0

    .end local v23    # "e":Landroid/database/sqlite/SQLiteException;
    :cond_1
    :goto_3
    return-object v5

    .line 160
    .restart local v4    # "database":Landroid/database/sqlite/SQLiteDatabase;
    .restart local v22    # "cursor":Landroid/database/Cursor;
    :cond_2
    :try_start_5
    move-object v0, v4

    check-cast v0, Landroid/database/sqlite/SQLiteDatabase;

    move-object v13, v0

    move-object v14, v5

    move-object v15, v6

    move-object/from16 v16, v7

    move-object/from16 v17, v8

    move-object/from16 v18, v9

    move-object/from16 v19, v10

    move-object/from16 v20, v11

    move-object/from16 v21, v12

    invoke-static/range {v13 .. v21}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->query(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v22

    goto :goto_0

    .line 169
    :cond_3
    const-string v5, "events"

    sget-object v6, Lnet/singular/sdk/EventStore;->ALL_COLUMNS:[Ljava/lang/String;

    const/4 v7, 0x0

    const/4 v8, 0x0

    const/4 v9, 0x0

    const/4 v10, 0x0

    const-string v11, "_id ASC"

    invoke-static/range {p1 .. p1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v12

    instance-of v13, v4, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v13, :cond_4

    invoke-virtual/range {v4 .. v12}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v22

    :goto_4
    goto :goto_0

    :cond_4
    move-object v0, v4

    check-cast v0, Landroid/database/sqlite/SQLiteDatabase;

    move-object v13, v0

    move-object v14, v5

    move-object v15, v6

    move-object/from16 v16, v7

    move-object/from16 v17, v8

    move-object/from16 v18, v9

    move-object/from16 v19, v10

    move-object/from16 v20, v11

    move-object/from16 v21, v12

    invoke-static/range {v13 .. v21}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->query(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v22

    goto :goto_4

    .line 187
    .restart local v24    # "events":Lorg/json/JSONArray;
    .restart local v25    # "last_json_encoded":Ljava/lang/String;
    .restart local v26    # "last_id":J
    :catch_1
    move-exception v23

    .line 188
    .local v23, "e":Lorg/json/JSONException;
    move-object/from16 v0, p0

    iget-object v5, v0, Lnet/singular/sdk/EventStore;->log:Lnet/singular/sdk/SingularLog;

    const-string v6, "singular_sdk"

    const-string v7, "failed decoding event_id = %d"

    const/4 v8, 0x1

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    invoke-static/range {v26 .. v27}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v10

    aput-object v10, v8, v9

    invoke-static {v7, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v5, v6, v7}, Lnet/singular/sdk/SingularLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 191
    move-object/from16 v0, p0

    move-wide/from16 v1, v26

    invoke-direct {v0, v1, v2}, Lnet/singular/sdk/EventStore;->deleteEvent(J)Z

    goto :goto_2

    .line 195
    .end local v23    # "e":Lorg/json/JSONException;
    .end local v25    # "last_json_encoded":Ljava/lang/String;
    :cond_5
    new-instance v5, Landroid/util/Pair;

    invoke-static/range {v26 .. v27}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    move-object/from16 v0, v24

    invoke-direct {v5, v6, v0}, Landroid/util/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 197
    if-eqz v22, :cond_1

    .line 198
    :try_start_6
    invoke-interface/range {v22 .. v22}, Landroid/database/Cursor;->close()V
    :try_end_6
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_6 .. :try_end_6} :catch_0

    goto :goto_3
.end method
