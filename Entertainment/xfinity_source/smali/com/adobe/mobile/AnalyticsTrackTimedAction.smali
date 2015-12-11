.class final Lcom/adobe/mobile/AnalyticsTrackTimedAction;
.super Lcom/adobe/mobile/AbstractDatabaseBacking;
.source "AnalyticsTrackTimedAction.java"


# static fields
.field private static final TIMED_ACTION_IN_APP_TIME_KEY:Ljava/lang/String; = "a.action.time.inapp"

.field private static final TIMED_ACTION_TOTAL_TIME_KEY:Ljava/lang/String; = "a.action.time.total"

.field private static _instance:Lcom/adobe/mobile/AnalyticsTrackTimedAction;

.field private static final _instanceMutex:Ljava/lang/Object;


# instance fields
.field private sqlDeleteAction:Landroid/database/sqlite/SQLiteStatement;

.field private sqlDeleteContextDataForAction:Landroid/database/sqlite/SQLiteStatement;

.field private sqlExistsAction:Ljava/lang/String;

.field private sqlExistsContextDataByActionAndKey:Ljava/lang/String;

.field private sqlInsertAction:Landroid/database/sqlite/SQLiteStatement;

.field private sqlInsertContextData:Landroid/database/sqlite/SQLiteStatement;

.field private sqlSelectAction:Ljava/lang/String;

.field private sqlSelectContextDataForAction:Ljava/lang/String;

.field private sqlUpdateAction:Landroid/database/sqlite/SQLiteStatement;

.field private sqlUpdateActionsClearAdjustedTime:Landroid/database/sqlite/SQLiteStatement;

.field private sqlUpdateContextData:Landroid/database/sqlite/SQLiteStatement;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 52
    const/4 v0, 0x0

    sput-object v0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->_instance:Lcom/adobe/mobile/AnalyticsTrackTimedAction;

    .line 53
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->_instanceMutex:Ljava/lang/Object;

    return-void
.end method

.method private constructor <init>()V
    .locals 3

    .prologue
    .line 64
    invoke-direct {p0}, Lcom/adobe/mobile/AbstractDatabaseBacking;-><init>()V

    .line 65
    const-string v0, "ADBMobileTimedActionsCache.sqlite"

    iput-object v0, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->fileName:Ljava/lang/String;

    .line 66
    const-string v0, "Analytics"

    iput-object v0, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->logPrefix:Ljava/lang/String;

    .line 67
    new-instance v0, Ljava/io/File;

    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getCacheDirectory()Ljava/io/File;

    move-result-object v1

    iget-object v2, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->fileName:Ljava/lang/String;

    invoke-direct {v0, v1, v2}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    invoke-virtual {p0, v0}, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->initDatabaseBacking(Ljava/io/File;)V

    .line 68
    return-void
.end method

.method private deleteTimedAction(I)V
    .locals 6
    .param p1, "timedActionID"    # I

    .prologue
    .line 521
    iget-object v2, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->dbMutex:Ljava/lang/Object;

    monitor-enter v2

    .line 524
    :try_start_0
    iget-object v1, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->sqlDeleteContextDataForAction:Landroid/database/sqlite/SQLiteStatement;

    const/4 v3, 0x1

    int-to-long v4, p1

    invoke-virtual {v1, v3, v4, v5}, Landroid/database/sqlite/SQLiteStatement;->bindLong(IJ)V

    .line 525
    iget-object v1, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->sqlDeleteContextDataForAction:Landroid/database/sqlite/SQLiteStatement;

    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteStatement;->execute()V

    .line 528
    iget-object v1, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->sqlDeleteAction:Landroid/database/sqlite/SQLiteStatement;

    const/4 v3, 0x1

    int-to-long v4, p1

    invoke-virtual {v1, v3, v4, v5}, Landroid/database/sqlite/SQLiteStatement;->bindLong(IJ)V

    .line 529
    iget-object v1, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->sqlDeleteAction:Landroid/database/sqlite/SQLiteStatement;

    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteStatement;->execute()V

    .line 532
    iget-object v1, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->sqlDeleteContextDataForAction:Landroid/database/sqlite/SQLiteStatement;

    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteStatement;->clearBindings()V

    .line 533
    iget-object v1, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->sqlDeleteAction:Landroid/database/sqlite/SQLiteStatement;

    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteStatement;->clearBindings()V
    :try_end_0
    .catch Landroid/database/SQLException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 542
    :goto_0
    :try_start_1
    monitor-exit v2

    .line 543
    return-void

    .line 534
    :catch_0
    move-exception v0

    .line 536
    .local v0, "e":Landroid/database/SQLException;
    const-string v1, "Analytics - Unable to delete the timed action (ID = %d, Exception: %s)"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    invoke-virtual {v0}, Landroid/database/SQLException;->getMessage()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v1, v3}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 538
    invoke-virtual {p0, v0}, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->resetDatabase(Ljava/lang/Exception;)V

    goto :goto_0

    .line 542
    .end local v0    # "e":Landroid/database/SQLException;
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v1

    .line 539
    :catch_1
    move-exception v0

    .line 540
    .local v0, "e":Ljava/lang/Exception;
    :try_start_2
    const-string v1, "Analytics - Unknown error deleting timed action (%s)"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v1, v3}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0
.end method

.method private getTimedAction(Ljava/lang/String;)Lcom/adobe/mobile/AnalyticsTimedAction;
    .locals 12
    .param p1, "timedActionName"    # Ljava/lang/String;

    .prologue
    const/4 v0, 0x0

    const/4 v2, 0x0

    .line 463
    if-eqz p1, :cond_0

    .line 464
    invoke-virtual {p1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-nez v1, :cond_1

    .line 466
    :cond_0
    const-string v1, "Analytics - Unable to get timed action (timed action name was null or empty)"

    new-array v2, v2, [Ljava/lang/Object;

    invoke-static {v1, v2}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 517
    :goto_0
    return-object v0

    .line 470
    :cond_1
    const/4 v10, 0x0

    .line 472
    .local v10, "timedAction":Lcom/adobe/mobile/AnalyticsTimedAction;
    iget-object v11, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->dbMutex:Ljava/lang/Object;

    monitor-enter v11

    .line 475
    :try_start_0
    iget-object v1, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->database:Landroid/database/sqlite/SQLiteDatabase;

    if-nez v1, :cond_2

    .line 476
    monitor-exit v11
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 515
    :catchall_0
    move-exception v1

    move-object v0, v10

    .end local v10    # "timedAction":Lcom/adobe/mobile/AnalyticsTimedAction;
    .local v0, "timedAction":Lcom/adobe/mobile/AnalyticsTimedAction;
    :goto_1
    :try_start_1
    monitor-exit v11
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    throw v1

    .line 481
    .end local v0    # "timedAction":Lcom/adobe/mobile/AnalyticsTimedAction;
    .restart local v10    # "timedAction":Lcom/adobe/mobile/AnalyticsTimedAction;
    :cond_2
    :try_start_2
    iget-object v1, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->database:Landroid/database/sqlite/SQLiteDatabase;

    iget-object v2, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->sqlSelectAction:Ljava/lang/String;

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    aput-object p1, v3, v4

    invoke-virtual {v1, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v7

    .line 483
    .local v7, "actionCursor":Landroid/database/Cursor;
    invoke-interface {v7}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    if-eqz v1, :cond_5

    .line 486
    new-instance v0, Lcom/adobe/mobile/AnalyticsTimedAction;

    const/4 v1, 0x0

    const/4 v2, 0x1

    invoke-interface {v7, v2}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v2

    const/4 v4, 0x2

    invoke-interface {v7, v4}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v4

    const/4 v6, 0x0

    invoke-interface {v7, v6}, Landroid/database/Cursor;->getInt(I)I

    move-result v6

    invoke-direct/range {v0 .. v6}, Lcom/adobe/mobile/AnalyticsTimedAction;-><init>(Ljava/util/Map;JJI)V
    :try_end_2
    .catch Landroid/database/SQLException; {:try_start_2 .. :try_end_2} :catch_0
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 489
    .end local v10    # "timedAction":Lcom/adobe/mobile/AnalyticsTimedAction;
    .restart local v0    # "timedAction":Lcom/adobe/mobile/AnalyticsTimedAction;
    :try_start_3
    iget-object v1, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->database:Landroid/database/sqlite/SQLiteDatabase;

    iget-object v2, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->sqlSelectContextDataForAction:Ljava/lang/String;

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    iget v5, v0, Lcom/adobe/mobile/AnalyticsTimedAction;->databaseID:I

    invoke-static {v5}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-virtual {v1, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v8

    .line 491
    .local v8, "contextDataCursor":Landroid/database/Cursor;
    invoke-interface {v8}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    if-eqz v1, :cond_4

    .line 494
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    iput-object v1, v0, Lcom/adobe/mobile/AnalyticsTimedAction;->contextData:Ljava/util/Map;

    .line 498
    :cond_3
    iget-object v1, v0, Lcom/adobe/mobile/AnalyticsTimedAction;->contextData:Ljava/util/Map;

    const/4 v2, 0x0

    invoke-interface {v8, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x1

    invoke-interface {v8, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 499
    invoke-interface {v8}, Landroid/database/Cursor;->moveToNext()Z

    move-result v1

    if-nez v1, :cond_3

    .line 502
    :cond_4
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    .line 505
    .end local v8    # "contextDataCursor":Landroid/database/Cursor;
    :goto_2
    invoke-interface {v7}, Landroid/database/Cursor;->close()V
    :try_end_3
    .catch Landroid/database/SQLException; {:try_start_3 .. :try_end_3} :catch_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_2
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 515
    .end local v7    # "actionCursor":Landroid/database/Cursor;
    :goto_3
    :try_start_4
    monitor-exit v11

    goto :goto_0

    :catchall_1
    move-exception v1

    goto :goto_1

    .line 508
    .end local v0    # "timedAction":Lcom/adobe/mobile/AnalyticsTimedAction;
    .restart local v10    # "timedAction":Lcom/adobe/mobile/AnalyticsTimedAction;
    :catch_0
    move-exception v9

    move-object v0, v10

    .line 509
    .end local v10    # "timedAction":Lcom/adobe/mobile/AnalyticsTimedAction;
    .restart local v0    # "timedAction":Lcom/adobe/mobile/AnalyticsTimedAction;
    .local v9, "e":Landroid/database/SQLException;
    :goto_4
    const-string v1, "Analytics - Unable to read from timed actions database (%s)"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-virtual {v9}, Landroid/database/SQLException;->getMessage()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 510
    invoke-virtual {p0, v9}, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->resetDatabase(Ljava/lang/Exception;)V

    goto :goto_3

    .line 512
    .end local v0    # "timedAction":Lcom/adobe/mobile/AnalyticsTimedAction;
    .end local v9    # "e":Landroid/database/SQLException;
    .restart local v10    # "timedAction":Lcom/adobe/mobile/AnalyticsTimedAction;
    :catch_1
    move-exception v9

    move-object v0, v10

    .line 513
    .end local v10    # "timedAction":Lcom/adobe/mobile/AnalyticsTimedAction;
    .restart local v0    # "timedAction":Lcom/adobe/mobile/AnalyticsTimedAction;
    .local v9, "e":Ljava/lang/Exception;
    :goto_5
    const-string v1, "Analytics - Unknown error reading from timed actions database (%s)"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-virtual {v9}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    goto :goto_3

    .line 512
    .end local v9    # "e":Ljava/lang/Exception;
    .restart local v7    # "actionCursor":Landroid/database/Cursor;
    :catch_2
    move-exception v9

    goto :goto_5

    .line 508
    :catch_3
    move-exception v9

    goto :goto_4

    .end local v0    # "timedAction":Lcom/adobe/mobile/AnalyticsTimedAction;
    .restart local v10    # "timedAction":Lcom/adobe/mobile/AnalyticsTimedAction;
    :cond_5
    move-object v0, v10

    .end local v10    # "timedAction":Lcom/adobe/mobile/AnalyticsTimedAction;
    .restart local v0    # "timedAction":Lcom/adobe/mobile/AnalyticsTimedAction;
    goto :goto_2
.end method

.method private insertTimedAction(Ljava/lang/String;Ljava/util/Map;J)V
    .locals 9
    .param p1, "timedActionName"    # Ljava/lang/String;
    .param p3, "startTime"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;J)V"
        }
    .end annotation

    .prologue
    .local p2, "contextData":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    const/4 v2, 0x0

    .line 324
    if-eqz p1, :cond_0

    .line 325
    invoke-virtual {p1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-nez v1, :cond_1

    .line 327
    :cond_0
    const-string v1, "Analytics - Unable to insert timed action (timed action name was null or empty)"

    new-array v2, v2, [Ljava/lang/Object;

    invoke-static {v1, v2}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 356
    :goto_0
    return-void

    .line 331
    :cond_1
    iget-object v2, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->dbMutex:Ljava/lang/Object;

    monitor-enter v2

    .line 334
    :try_start_0
    iget-object v1, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->sqlInsertAction:Landroid/database/sqlite/SQLiteStatement;

    const/4 v3, 0x1

    invoke-virtual {v1, v3, p1}, Landroid/database/sqlite/SQLiteStatement;->bindString(ILjava/lang/String;)V

    .line 335
    iget-object v1, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->sqlInsertAction:Landroid/database/sqlite/SQLiteStatement;

    const/4 v3, 0x2

    invoke-virtual {v1, v3, p3, p4}, Landroid/database/sqlite/SQLiteStatement;->bindLong(IJ)V

    .line 338
    iget-object v1, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->sqlInsertAction:Landroid/database/sqlite/SQLiteStatement;

    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteStatement;->executeInsert()J

    move-result-wide v4

    const-wide/16 v6, -0x1

    cmp-long v1, v4, v6

    if-nez v1, :cond_2

    .line 339
    const-string v1, "Analytics - Unable to insert the timed action (%s)"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p1, v3, v4

    invoke-static {v1, v3}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 343
    :cond_2
    iget-object v1, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->sqlInsertAction:Landroid/database/sqlite/SQLiteStatement;

    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteStatement;->clearBindings()V
    :try_end_0
    .catch Landroid/database/SQLException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 352
    :goto_1
    :try_start_1
    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 355
    invoke-direct {p0, p1, p2}, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->saveContextDataForTimedAction(Ljava/lang/String;Ljava/util/Map;)V

    goto :goto_0

    .line 345
    :catch_0
    move-exception v0

    .line 346
    .local v0, "e":Landroid/database/SQLException;
    :try_start_2
    const-string v1, "Analytics - Unable to bind prepared statement values for inserting the timed action (%s)"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p1, v3, v4

    invoke-static {v1, v3}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 347
    invoke-virtual {p0, v0}, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->resetDatabase(Ljava/lang/Exception;)V

    goto :goto_1

    .line 352
    .end local v0    # "e":Landroid/database/SQLException;
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v1

    .line 349
    :catch_1
    move-exception v0

    .line 350
    .local v0, "e":Ljava/lang/Exception;
    :try_start_3
    const-string v1, "Analyitcs - Unknown error when inserting timed action (%s)"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v1, v3}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_1
.end method

.method private saveContextDataForTimedAction(Ljava/lang/String;Ljava/util/Map;)V
    .locals 14
    .param p1, "timedActionName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 360
    .local p2, "contextData":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    if-eqz p1, :cond_0

    .line 361
    invoke-virtual {p1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/String;->length()I

    move-result v7

    if-nez v7, :cond_1

    .line 363
    :cond_0
    const-string v7, "Analytics - Unable to save context data (timed action name was null or empty)"

    const/4 v8, 0x0

    new-array v8, v8, [Ljava/lang/Object;

    invoke-static {v7, v8}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 456
    :goto_0
    return-void

    .line 368
    :cond_1
    if-eqz p2, :cond_2

    .line 369
    invoke-interface/range {p2 .. p2}, Ljava/util/Map;->isEmpty()Z

    move-result v7

    if-eqz v7, :cond_3

    .line 371
    :cond_2
    const-string v7, "Analytics - Unable to save context data (context data was null or empty)"

    const/4 v8, 0x0

    new-array v8, v8, [Ljava/lang/Object;

    invoke-static {v7, v8}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0

    .line 375
    :cond_3
    iget-object v8, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->dbMutex:Ljava/lang/Object;

    monitor-enter v8

    .line 377
    :try_start_0
    iget-object v7, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->database:Landroid/database/sqlite/SQLiteDatabase;

    if-nez v7, :cond_4

    .line 378
    const-string v7, "Analytics - Null Database Object, unable to save context data for timed action"

    const/4 v9, 0x0

    new-array v9, v9, [Ljava/lang/Object;

    invoke-static {v7, v9}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_0
    .catch Landroid/database/SQLException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 379
    :try_start_1
    monitor-exit v8

    goto :goto_0

    .line 455
    :catchall_0
    move-exception v7

    monitor-exit v8
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v7

    .line 386
    :cond_4
    :try_start_2
    iget-object v7, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->database:Landroid/database/sqlite/SQLiteDatabase;

    iget-object v9, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->sqlSelectAction:Ljava/lang/String;

    const/4 v10, 0x1

    new-array v10, v10, [Ljava/lang/String;

    const/4 v11, 0x0

    aput-object p1, v10, v11

    invoke-virtual {v7, v9, v10}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v1

    .line 388
    .local v1, "cursor":Landroid/database/Cursor;
    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v7

    if-eqz v7, :cond_7

    .line 391
    const/4 v7, 0x0

    invoke-interface {v1, v7}, Landroid/database/Cursor;->getInt(I)I

    move-result v5

    .line 394
    .local v5, "timedActionID":I
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 403
    invoke-interface/range {p2 .. p2}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v7

    invoke-interface {v7}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v9

    :cond_5
    :goto_1
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_6

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/Map$Entry;

    .line 404
    .local v3, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/Object;>;"
    invoke-interface {v3}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    .line 405
    .local v4, "key":Ljava/lang/String;
    invoke-interface {v3}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v6

    .line 408
    .local v6, "value":Ljava/lang/Object;
    if-eqz v4, :cond_5

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v7

    if-lez v7, :cond_5

    .line 413
    iget-object v10, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->database:Landroid/database/sqlite/SQLiteDatabase;

    iget-object v11, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->sqlExistsContextDataByActionAndKey:Ljava/lang/String;

    const/4 v7, 0x2

    new-array v12, v7, [Ljava/lang/String;

    const/4 v7, 0x0

    invoke-static {v5}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v13

    aput-object v13, v12, v7

    const/4 v13, 0x1

    invoke-interface {v3}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/String;

    aput-object v7, v12, v13

    invoke-virtual {v10, v11, v12}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v1

    .line 416
    if-nez v6, :cond_8

    const-string v0, ""

    .line 418
    .local v0, "cDataValue":Ljava/lang/String;
    :goto_2
    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v7

    if-eqz v7, :cond_9

    const/4 v7, 0x0

    invoke-interface {v1, v7}, Landroid/database/Cursor;->getInt(I)I

    move-result v7

    if-lez v7, :cond_9

    .line 422
    iget-object v7, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->sqlUpdateContextData:Landroid/database/sqlite/SQLiteStatement;

    const/4 v10, 0x1

    invoke-virtual {v7, v10, v0}, Landroid/database/sqlite/SQLiteStatement;->bindString(ILjava/lang/String;)V

    .line 423
    iget-object v7, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->sqlUpdateContextData:Landroid/database/sqlite/SQLiteStatement;

    const/4 v10, 0x2

    int-to-long v12, v5

    invoke-virtual {v7, v10, v12, v13}, Landroid/database/sqlite/SQLiteStatement;->bindLong(IJ)V

    .line 424
    iget-object v10, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->sqlUpdateContextData:Landroid/database/sqlite/SQLiteStatement;

    const/4 v11, 0x3

    invoke-interface {v3}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/String;

    invoke-virtual {v10, v11, v7}, Landroid/database/sqlite/SQLiteStatement;->bindString(ILjava/lang/String;)V

    .line 426
    iget-object v7, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->sqlUpdateContextData:Landroid/database/sqlite/SQLiteStatement;

    invoke-virtual {v7}, Landroid/database/sqlite/SQLiteStatement;->execute()V

    .line 429
    iget-object v7, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->sqlUpdateContextData:Landroid/database/sqlite/SQLiteStatement;

    invoke-virtual {v7}, Landroid/database/sqlite/SQLiteStatement;->clearBindings()V

    .line 446
    :goto_3
    invoke-interface {v1}, Landroid/database/Cursor;->close()V
    :try_end_2
    .catch Landroid/database/SQLException; {:try_start_2 .. :try_end_2} :catch_0
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_1

    .line 449
    .end local v0    # "cDataValue":Ljava/lang/String;
    .end local v1    # "cursor":Landroid/database/Cursor;
    .end local v3    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/Object;>;"
    .end local v4    # "key":Ljava/lang/String;
    .end local v5    # "timedActionID":I
    .end local v6    # "value":Ljava/lang/Object;
    :catch_0
    move-exception v2

    .line 450
    .local v2, "e":Landroid/database/SQLException;
    :try_start_3
    const-string v7, "Analytics - SQL exception when attempting to update context data for timed action (%s)"

    const/4 v9, 0x1

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    invoke-virtual {v2}, Landroid/database/SQLException;->getMessage()Ljava/lang/String;

    move-result-object v11

    aput-object v11, v9, v10

    invoke-static {v7, v9}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 455
    .end local v2    # "e":Landroid/database/SQLException;
    :cond_6
    :goto_4
    monitor-exit v8
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto/16 :goto_0

    .line 397
    .restart local v1    # "cursor":Landroid/database/Cursor;
    :cond_7
    :try_start_4
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 398
    const-string v7, "Analytics - Unable to save context data (no timed action was found matching the name %s)"

    const/4 v9, 0x1

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    aput-object p1, v9, v10

    invoke-static {v7, v9}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_4
    .catch Landroid/database/SQLException; {:try_start_4 .. :try_end_4} :catch_0
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_1
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 399
    :try_start_5
    monitor-exit v8
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    goto/16 :goto_0

    .line 416
    .restart local v3    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/Object;>;"
    .restart local v4    # "key":Ljava/lang/String;
    .restart local v5    # "timedActionID":I
    .restart local v6    # "value":Ljava/lang/Object;
    :cond_8
    :try_start_6
    invoke-virtual {v6}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_2

    .line 432
    .restart local v0    # "cDataValue":Ljava/lang/String;
    :cond_9
    iget-object v7, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->sqlInsertContextData:Landroid/database/sqlite/SQLiteStatement;

    const/4 v10, 0x1

    int-to-long v12, v5

    invoke-virtual {v7, v10, v12, v13}, Landroid/database/sqlite/SQLiteStatement;->bindLong(IJ)V

    .line 433
    iget-object v10, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->sqlInsertContextData:Landroid/database/sqlite/SQLiteStatement;

    const/4 v11, 0x2

    invoke-interface {v3}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/String;

    invoke-virtual {v10, v11, v7}, Landroid/database/sqlite/SQLiteStatement;->bindString(ILjava/lang/String;)V

    .line 434
    iget-object v7, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->sqlInsertContextData:Landroid/database/sqlite/SQLiteStatement;

    const/4 v10, 0x3

    invoke-virtual {v7, v10, v0}, Landroid/database/sqlite/SQLiteStatement;->bindString(ILjava/lang/String;)V

    .line 437
    iget-object v7, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->sqlInsertContextData:Landroid/database/sqlite/SQLiteStatement;

    invoke-virtual {v7}, Landroid/database/sqlite/SQLiteStatement;->executeInsert()J

    move-result-wide v10

    const-wide/16 v12, -0x1

    cmp-long v7, v10, v12

    if-nez v7, :cond_a

    .line 438
    const-string v7, "Analytics - Unable to insert the timed action\'s context data (%s)"

    const/4 v10, 0x1

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    aput-object p1, v10, v11

    invoke-static {v7, v10}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 442
    :cond_a
    iget-object v7, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->sqlInsertContextData:Landroid/database/sqlite/SQLiteStatement;

    invoke-virtual {v7}, Landroid/database/sqlite/SQLiteStatement;->clearBindings()V
    :try_end_6
    .catch Landroid/database/SQLException; {:try_start_6 .. :try_end_6} :catch_0
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_1
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    goto :goto_3

    .line 452
    .end local v0    # "cDataValue":Ljava/lang/String;
    .end local v1    # "cursor":Landroid/database/Cursor;
    .end local v3    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/Object;>;"
    .end local v4    # "key":Ljava/lang/String;
    .end local v5    # "timedActionID":I
    .end local v6    # "value":Ljava/lang/Object;
    :catch_1
    move-exception v2

    .line 453
    .local v2, "e":Ljava/lang/Exception;
    :try_start_7
    const-string v7, "Analytics - Unexpected exception when attempting to update context data for timed action (%s)"

    const/4 v9, 0x1

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    invoke-virtual {v2}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v11

    aput-object v11, v9, v10

    invoke-static {v7, v9}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    goto :goto_4
.end method

.method public static sharedInstance()Lcom/adobe/mobile/AnalyticsTrackTimedAction;
    .locals 2

    .prologue
    .line 55
    sget-object v1, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->_instanceMutex:Ljava/lang/Object;

    monitor-enter v1

    .line 56
    :try_start_0
    sget-object v0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->_instance:Lcom/adobe/mobile/AnalyticsTrackTimedAction;

    if-nez v0, :cond_0

    .line 57
    new-instance v0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;

    invoke-direct {v0}, Lcom/adobe/mobile/AnalyticsTrackTimedAction;-><init>()V

    sput-object v0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->_instance:Lcom/adobe/mobile/AnalyticsTrackTimedAction;

    .line 60
    :cond_0
    sget-object v0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->_instance:Lcom/adobe/mobile/AnalyticsTrackTimedAction;

    monitor-exit v1

    return-object v0

    .line 61
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method


# virtual methods
.method protected initializeDatabase()V
    .locals 6

    .prologue
    const/4 v3, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 281
    :try_start_0
    iget-object v1, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->database:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "CREATE TABLE IF NOT EXISTS TIMEDACTIONS (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, STARTTIME INTEGER, ADJSTARTTIME INTEGER)"

    invoke-virtual {v1, v2}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 282
    iget-object v1, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->database:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "CREATE TABLE IF NOT EXISTS CONTEXTDATA (ID INTEGER PRIMARY KEY AUTOINCREMENT, ACTIONID INTEGER, KEY TEXT, VALUE TEXT, FOREIGN KEY(ACTIONID) REFERENCES TIMEDACTIONS(ID))"

    invoke-virtual {v1, v2}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V
    :try_end_0
    .catch Landroid/database/SQLException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 290
    :goto_0
    return-void

    .line 284
    :catch_0
    move-exception v0

    .line 285
    .local v0, "e":Landroid/database/SQLException;
    const-string v1, "%s - Unable to open or create timed actions database (%s)"

    new-array v2, v3, [Ljava/lang/Object;

    iget-object v3, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->logPrefix:Ljava/lang/String;

    aput-object v3, v2, v4

    invoke-virtual {v0}, Landroid/database/SQLException;->getMessage()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v5

    invoke-static {v1, v2}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0

    .line 287
    .end local v0    # "e":Landroid/database/SQLException;
    :catch_1
    move-exception v0

    .line 288
    .local v0, "e":Ljava/lang/Exception;
    const-string v1, "%s - Uknown error creating timed actions database (%s)"

    new-array v2, v3, [Ljava/lang/Object;

    iget-object v3, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->logPrefix:Ljava/lang/String;

    aput-object v3, v2, v4

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v5

    invoke-static {v1, v2}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method

.method protected postMigrate()V
    .locals 0

    .prologue
    .line 273
    return-void
.end method

.method protected postReset()V
    .locals 0

    .prologue
    .line 276
    return-void
.end method

.method protected preMigrate()V
    .locals 9

    .prologue
    const/4 v8, 0x1

    const/4 v7, 0x0

    .line 257
    new-instance v2, Ljava/io/File;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getCacheDirectory()Ljava/io/File;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "ADBMobileDataCache.sqlite"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->fileName:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 258
    .local v2, "oldFile":Ljava/io/File;
    new-instance v1, Ljava/io/File;

    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getCacheDirectory()Ljava/io/File;

    move-result-object v3

    iget-object v4, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->fileName:Ljava/lang/String;

    invoke-direct {v1, v3, v4}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 261
    .local v1, "newFile":Ljava/io/File;
    invoke-virtual {v2}, Ljava/io/File;->exists()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v3

    if-nez v3, :cond_0

    .line 263
    :try_start_0
    invoke-virtual {v2, v1}, Ljava/io/File;->renameTo(Ljava/io/File;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 264
    const-string v3, "%s - Unable to migrate old Timed Actions db, creating new Timed Actions db (move file returned false)"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    iget-object v6, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->logPrefix:Ljava/lang/String;

    aput-object v6, v4, v5

    invoke-static {v3, v4}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 270
    :cond_0
    :goto_0
    return-void

    .line 266
    :catch_0
    move-exception v0

    .line 267
    .local v0, "e":Ljava/lang/Exception;
    const-string v3, "%s - Unable to migrate old Timed Actions db, creating new Timed Actions db (%s)"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    iget-object v5, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->logPrefix:Ljava/lang/String;

    aput-object v5, v4, v7

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v8

    invoke-static {v3, v4}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method

.method protected prepareStatements()V
    .locals 5

    .prologue
    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 295
    const-string v1, "SELECT ID, STARTTIME, ADJSTARTTIME FROM TIMEDACTIONS WHERE NAME=?"

    iput-object v1, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->sqlSelectAction:Ljava/lang/String;

    .line 296
    const-string v1, "SELECT COUNT(*) FROM TIMEDACTIONS WHERE NAME=?"

    iput-object v1, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->sqlExistsAction:Ljava/lang/String;

    .line 297
    const-string v1, "SELECT KEY, VALUE FROM CONTEXTDATA WHERE ACTIONID=?"

    iput-object v1, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->sqlSelectContextDataForAction:Ljava/lang/String;

    .line 298
    const-string v1, "SELECT COUNT(*) FROM CONTEXTDATA WHERE ACTIONID=? AND KEY=?"

    iput-object v1, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->sqlExistsContextDataByActionAndKey:Ljava/lang/String;

    .line 303
    :try_start_0
    iget-object v1, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->database:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "INSERT INTO TIMEDACTIONS (NAME, STARTTIME, ADJSTARTTIME) VALUES (@NAME, @START, @START)"

    invoke-virtual {v1, v2}, Landroid/database/sqlite/SQLiteDatabase;->compileStatement(Ljava/lang/String;)Landroid/database/sqlite/SQLiteStatement;

    move-result-object v1

    iput-object v1, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->sqlInsertAction:Landroid/database/sqlite/SQLiteStatement;

    .line 304
    iget-object v1, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->database:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "UPDATE TIMEDACTIONS SET ADJSTARTTIME=ADJSTARTTIME+@DELTA WHERE ADJSTARTTIME!=0"

    invoke-virtual {v1, v2}, Landroid/database/sqlite/SQLiteDatabase;->compileStatement(Ljava/lang/String;)Landroid/database/sqlite/SQLiteStatement;

    move-result-object v1

    iput-object v1, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->sqlUpdateAction:Landroid/database/sqlite/SQLiteStatement;

    .line 305
    iget-object v1, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->database:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "UPDATE TIMEDACTIONS SET ADJSTARTTIME=0"

    invoke-virtual {v1, v2}, Landroid/database/sqlite/SQLiteDatabase;->compileStatement(Ljava/lang/String;)Landroid/database/sqlite/SQLiteStatement;

    move-result-object v1

    iput-object v1, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->sqlUpdateActionsClearAdjustedTime:Landroid/database/sqlite/SQLiteStatement;

    .line 306
    iget-object v1, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->database:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "DELETE FROM TIMEDACTIONS WHERE ID=@ID"

    invoke-virtual {v1, v2}, Landroid/database/sqlite/SQLiteDatabase;->compileStatement(Ljava/lang/String;)Landroid/database/sqlite/SQLiteStatement;

    move-result-object v1

    iput-object v1, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->sqlDeleteAction:Landroid/database/sqlite/SQLiteStatement;

    .line 307
    iget-object v1, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->database:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "INSERT INTO CONTEXTDATA(ACTIONID, KEY, VALUE) VALUES (@ACTIONID, @KEY, @VALUE)"

    invoke-virtual {v1, v2}, Landroid/database/sqlite/SQLiteDatabase;->compileStatement(Ljava/lang/String;)Landroid/database/sqlite/SQLiteStatement;

    move-result-object v1

    iput-object v1, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->sqlInsertContextData:Landroid/database/sqlite/SQLiteStatement;

    .line 308
    iget-object v1, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->database:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "UPDATE CONTEXTDATA SET VALUE=@VALUE WHERE ACTIONID=@ACTIONID AND KEY=@KEY"

    invoke-virtual {v1, v2}, Landroid/database/sqlite/SQLiteDatabase;->compileStatement(Ljava/lang/String;)Landroid/database/sqlite/SQLiteStatement;

    move-result-object v1

    iput-object v1, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->sqlUpdateContextData:Landroid/database/sqlite/SQLiteStatement;

    .line 309
    iget-object v1, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->database:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "DELETE FROM CONTEXTDATA WHERE ACTIONID=@ACTIONID"

    invoke-virtual {v1, v2}, Landroid/database/sqlite/SQLiteDatabase;->compileStatement(Ljava/lang/String;)Landroid/database/sqlite/SQLiteStatement;

    move-result-object v1

    iput-object v1, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->sqlDeleteContextDataForAction:Landroid/database/sqlite/SQLiteStatement;
    :try_end_0
    .catch Landroid/database/SQLException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 317
    :goto_0
    return-void

    .line 311
    :catch_0
    move-exception v0

    .line 312
    .local v0, "e":Landroid/database/SQLException;
    const-string v1, "Analytics - unable to prepare the needed SQL statements for interacting with the timed actions database (%s)"

    new-array v2, v3, [Ljava/lang/Object;

    invoke-virtual {v0}, Landroid/database/SQLException;->getMessage()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v4

    invoke-static {v1, v2}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0

    .line 314
    .end local v0    # "e":Landroid/database/SQLException;
    :catch_1
    move-exception v0

    .line 315
    .local v0, "e":Ljava/lang/Exception;
    const-string v1, "Analytics - Unknown error preparing sql statements (%s)"

    new-array v2, v3, [Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v4

    invoke-static {v1, v2}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method

.method protected trackTimedActionEnd(Ljava/lang/String;Lcom/adobe/mobile/Analytics$TimedActionBlock;)V
    .locals 12
    .param p1, "timedActionName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/adobe/mobile/Analytics$TimedActionBlock",
            "<",
            "Ljava/lang/Boolean;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 124
    .local p2, "logicBlock":Lcom/adobe/mobile/Analytics$TimedActionBlock;, "Lcom/adobe/mobile/Analytics$TimedActionBlock<Ljava/lang/Boolean;>;"
    if-eqz p1, :cond_0

    .line 125
    invoke-virtual {p1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-nez v1, :cond_1

    .line 127
    :cond_0
    const-string v1, "%s - Unable to end the timed action (timed action name was null or empty)"

    const/4 v8, 0x1

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    iget-object v10, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->logPrefix:Ljava/lang/String;

    aput-object v10, v8, v9

    invoke-static {v1, v8}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 168
    :goto_0
    return-void

    .line 131
    :cond_1
    invoke-direct {p0, p1}, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->getTimedAction(Ljava/lang/String;)Lcom/adobe/mobile/AnalyticsTimedAction;

    move-result-object v7

    .line 133
    .local v7, "timedAction":Lcom/adobe/mobile/AnalyticsTimedAction;
    if-eqz v7, :cond_7

    .line 135
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getTimeSince1970()J

    move-result-wide v8

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    .line 136
    .local v0, "now":Ljava/lang/Long;
    iget-wide v8, v7, Lcom/adobe/mobile/AnalyticsTimedAction;->adjustedStartTime:J

    const-wide/16 v10, 0x0

    cmp-long v1, v8, v10

    if-nez v1, :cond_4

    const-wide/16 v2, 0x0

    .line 137
    .local v2, "inAppDuration":J
    :goto_1
    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v8

    iget-wide v10, v7, Lcom/adobe/mobile/AnalyticsTimedAction;->startTime:J

    sub-long v4, v8, v10

    .line 139
    .local v4, "totalDuration":J
    iget-object v1, v7, Lcom/adobe/mobile/AnalyticsTimedAction;->contextData:Ljava/util/Map;

    if-eqz v1, :cond_5

    new-instance v6, Ljava/util/HashMap;

    iget-object v1, v7, Lcom/adobe/mobile/AnalyticsTimedAction;->contextData:Ljava/util/Map;

    invoke-direct {v6, v1}, Ljava/util/HashMap;-><init>(Ljava/util/Map;)V

    .line 142
    .local v6, "contextData":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    :goto_2
    if-eqz p2, :cond_2

    move-object v1, p2

    .line 143
    invoke-interface/range {v1 .. v6}, Lcom/adobe/mobile/Analytics$TimedActionBlock;->call(JJLjava/util/Map;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Boolean;

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    if-eqz v1, :cond_6

    .line 144
    :cond_2
    const-string v1, "a.action.time.total"

    invoke-static {v4, v5}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v6, v1, v8}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 147
    iget-wide v8, v7, Lcom/adobe/mobile/AnalyticsTimedAction;->adjustedStartTime:J

    const-wide/16 v10, 0x0

    cmp-long v1, v8, v10

    if-eqz v1, :cond_3

    .line 148
    const-string v1, "a.action.time.inapp"

    invoke-static {v2, v3}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v6, v1, v8}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 151
    :cond_3
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getAnalyticsExecutor()Ljava/util/concurrent/ExecutorService;

    move-result-object v1

    new-instance v8, Lcom/adobe/mobile/AnalyticsTrackTimedAction$1;

    invoke-direct {v8, p0, p1, v6}, Lcom/adobe/mobile/AnalyticsTrackTimedAction$1;-><init>(Lcom/adobe/mobile/AnalyticsTrackTimedAction;Ljava/lang/String;Ljava/util/HashMap;)V

    invoke-interface {v1, v8}, Ljava/util/concurrent/ExecutorService;->execute(Ljava/lang/Runnable;)V

    .line 162
    :goto_3
    iget v1, v7, Lcom/adobe/mobile/AnalyticsTimedAction;->databaseID:I

    invoke-direct {p0, v1}, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->deleteTimedAction(I)V

    goto :goto_0

    .line 136
    .end local v2    # "inAppDuration":J
    .end local v4    # "totalDuration":J
    .end local v6    # "contextData":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    :cond_4
    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v8

    iget-wide v10, v7, Lcom/adobe/mobile/AnalyticsTimedAction;->adjustedStartTime:J

    sub-long v2, v8, v10

    goto :goto_1

    .line 139
    .restart local v2    # "inAppDuration":J
    .restart local v4    # "totalDuration":J
    :cond_5
    new-instance v6, Ljava/util/HashMap;

    invoke-direct {v6}, Ljava/util/HashMap;-><init>()V

    goto :goto_2

    .line 158
    .restart local v6    # "contextData":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    :cond_6
    const-string v1, "%s - Not sending hit for timed action due to block cancellation (%s)"

    const/4 v8, 0x2

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    iget-object v10, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->logPrefix:Ljava/lang/String;

    aput-object v10, v8, v9

    const/4 v9, 0x1

    aput-object p1, v8, v9

    invoke-static {v1, v8}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_3

    .line 166
    .end local v0    # "now":Ljava/lang/Long;
    .end local v2    # "inAppDuration":J
    .end local v4    # "totalDuration":J
    .end local v6    # "contextData":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    :cond_7
    const-string v1, "%s - Unable to end a timed action that has not yet begun (no timed action was found matching the name %s)"

    const/4 v8, 0x2

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    iget-object v10, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->logPrefix:Ljava/lang/String;

    aput-object v10, v8, v9

    const/4 v9, 0x1

    aput-object p1, v8, v9

    invoke-static {v1, v8}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto/16 :goto_0
.end method

.method protected trackTimedActionExists(Ljava/lang/String;)Z
    .locals 10
    .param p1, "timedActionName"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 215
    if-eqz p1, :cond_0

    .line 216
    invoke-virtual {p1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/String;->length()I

    move-result v5

    if-nez v5, :cond_1

    .line 218
    :cond_0
    const-string v5, "%s - Unable to verify the existence of timed action (timed action name was null or empty)"

    new-array v3, v3, [Ljava/lang/Object;

    iget-object v6, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->logPrefix:Ljava/lang/String;

    aput-object v6, v3, v4

    invoke-static {v5, v3}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 248
    :goto_0
    return v4

    .line 222
    :cond_1
    const/4 v2, 0x0

    .line 224
    .local v2, "timedActionExists":Z
    iget-object v5, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->dbMutex:Ljava/lang/Object;

    monitor-enter v5

    .line 225
    :try_start_0
    iget-object v6, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->database:Landroid/database/sqlite/SQLiteDatabase;

    if-nez v6, :cond_2

    .line 226
    monitor-exit v5

    goto :goto_0

    .line 246
    :catchall_0
    move-exception v3

    monitor-exit v5
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v3

    .line 231
    :cond_2
    :try_start_1
    iget-object v6, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->database:Landroid/database/sqlite/SQLiteDatabase;

    iget-object v7, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->sqlExistsAction:Ljava/lang/String;

    const/4 v8, 0x1

    new-array v8, v8, [Ljava/lang/String;

    const/4 v9, 0x0

    aput-object p1, v8, v9

    invoke-virtual {v6, v7, v8}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 233
    .local v0, "cursor":Landroid/database/Cursor;
    invoke-interface {v0}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v6

    if-eqz v6, :cond_3

    .line 234
    const/4 v6, 0x0

    invoke-interface {v0, v6}, Landroid/database/Cursor;->getInt(I)I

    move-result v6

    if-lez v6, :cond_4

    move v2, v3

    .line 238
    :cond_3
    :goto_1
    invoke-interface {v0}, Landroid/database/Cursor;->close()V
    :try_end_1
    .catch Landroid/database/SQLException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 246
    .end local v0    # "cursor":Landroid/database/Cursor;
    :goto_2
    :try_start_2
    monitor-exit v5

    move v4, v2

    .line 248
    goto :goto_0

    .restart local v0    # "cursor":Landroid/database/Cursor;
    :cond_4
    move v2, v4

    .line 234
    goto :goto_1

    .line 240
    .end local v0    # "cursor":Landroid/database/Cursor;
    :catch_0
    move-exception v1

    .line 241
    .local v1, "e":Landroid/database/SQLException;
    const-string v3, "%s - Unable to query timed actions database (%s)"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v6, 0x0

    iget-object v7, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->logPrefix:Ljava/lang/String;

    aput-object v7, v4, v6

    const/4 v6, 0x1

    invoke-virtual {v1}, Landroid/database/SQLException;->getMessage()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v4, v6

    invoke-static {v3, v4}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_2

    .line 243
    .end local v1    # "e":Landroid/database/SQLException;
    :catch_1
    move-exception v1

    .line 244
    .local v1, "e":Ljava/lang/Exception;
    const-string v3, "%s - Unknown error checking for timed action (%s)"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v6, 0x0

    iget-object v7, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->logPrefix:Ljava/lang/String;

    aput-object v7, v4, v6

    const/4 v6, 0x1

    invoke-virtual {v1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v4, v6

    invoke-static {v3, v4}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_2
.end method

.method protected trackTimedActionStart(Ljava/lang/String;Ljava/util/Map;)V
    .locals 7
    .param p1, "timedActionName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 77
    .local p2, "contextData":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    if-eqz p1, :cond_0

    .line 78
    invoke-virtual {p1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    if-nez v3, :cond_1

    .line 81
    :cond_0
    const-string v3, "%s - trackTimedActionStart() failed(the required parameter actionName was null or empty.)"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    iget-object v6, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->logPrefix:Ljava/lang/String;

    aput-object v6, v4, v5

    invoke-static {v3, v4}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 98
    :goto_0
    return-void

    .line 86
    :cond_1
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getTimeSince1970()J

    move-result-wide v0

    .line 89
    .local v0, "startTime":J
    invoke-direct {p0, p1}, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->getTimedAction(Ljava/lang/String;)Lcom/adobe/mobile/AnalyticsTimedAction;

    move-result-object v2

    .line 91
    .local v2, "timedAction":Lcom/adobe/mobile/AnalyticsTimedAction;
    if-eqz v2, :cond_2

    .line 93
    iget v3, v2, Lcom/adobe/mobile/AnalyticsTimedAction;->databaseID:I

    invoke-direct {p0, v3}, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->deleteTimedAction(I)V

    .line 97
    :cond_2
    invoke-direct {p0, p1, p2, v0, v1}, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->insertTimedAction(Ljava/lang/String;Ljava/util/Map;J)V

    goto :goto_0
.end method

.method protected trackTimedActionUpdate(Ljava/lang/String;Ljava/util/Map;)V
    .locals 4
    .param p1, "timedActionName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p2, "contextData":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    const/4 v1, 0x1

    const/4 v3, 0x0

    .line 102
    if-eqz p1, :cond_0

    .line 103
    invoke-virtual {p1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_1

    .line 105
    :cond_0
    const-string v0, "%s - Unable to update the timed action (timed action name was null or empty)"

    new-array v1, v1, [Ljava/lang/Object;

    iget-object v2, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->logPrefix:Ljava/lang/String;

    aput-object v2, v1, v3

    invoke-static {v0, v1}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 119
    :goto_0
    return-void

    .line 110
    :cond_1
    if-eqz p2, :cond_2

    .line 111
    invoke-interface {p2}, Ljava/util/Map;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 113
    :cond_2
    const-string v0, "%s - Unable to update the timed action (context data was null or empty)"

    new-array v1, v1, [Ljava/lang/Object;

    iget-object v2, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->logPrefix:Ljava/lang/String;

    aput-object v2, v1, v3

    invoke-static {v0, v1}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0

    .line 118
    :cond_3
    invoke-direct {p0, p1, p2}, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->saveContextDataForTimedAction(Ljava/lang/String;Ljava/util/Map;)V

    goto :goto_0
.end method

.method protected trackTimedActionUpdateActionsClearAdjustedStartTime()V
    .locals 6

    .prologue
    .line 191
    iget-object v2, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->dbMutex:Ljava/lang/Object;

    monitor-enter v2

    .line 193
    :try_start_0
    iget-object v1, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->sqlUpdateActionsClearAdjustedTime:Landroid/database/sqlite/SQLiteStatement;

    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteStatement;->execute()V

    .line 194
    iget-object v1, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->sqlUpdateActionsClearAdjustedTime:Landroid/database/sqlite/SQLiteStatement;

    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteStatement;->clearBindings()V
    :try_end_0
    .catch Landroid/database/SQLException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 208
    :goto_0
    :try_start_1
    monitor-exit v2

    .line 209
    return-void

    .line 196
    :catch_0
    move-exception v0

    .line 197
    .local v0, "e":Landroid/database/SQLException;
    const-string v1, "%s - Unable to update adjusted time for timed actions after crash (%s)"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    iget-object v5, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->logPrefix:Ljava/lang/String;

    aput-object v5, v3, v4

    const/4 v4, 0x1

    invoke-virtual {v0}, Landroid/database/SQLException;->getMessage()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v1, v3}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 200
    invoke-virtual {p0, v0}, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->resetDatabase(Ljava/lang/Exception;)V

    goto :goto_0

    .line 208
    .end local v0    # "e":Landroid/database/SQLException;
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v1

    .line 202
    :catch_1
    move-exception v0

    .line 203
    .local v0, "e":Ljava/lang/Exception;
    :try_start_2
    const-string v1, "%s - Unknown error clearing adjusted start times for timed actions (%s)"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    iget-object v5, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->logPrefix:Ljava/lang/String;

    aput-object v5, v3, v4

    const/4 v4, 0x1

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v1, v3}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 206
    invoke-virtual {p0, v0}, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->resetDatabase(Ljava/lang/Exception;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0
.end method

.method protected trackTimedActionUpdateAdjustedStartTime(J)V
    .locals 7
    .param p1, "timeDelta"    # J

    .prologue
    .line 172
    iget-object v2, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->dbMutex:Ljava/lang/Object;

    monitor-enter v2

    .line 174
    :try_start_0
    iget-object v1, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->sqlUpdateAction:Landroid/database/sqlite/SQLiteStatement;

    const/4 v3, 0x1

    invoke-virtual {v1, v3, p1, p2}, Landroid/database/sqlite/SQLiteStatement;->bindLong(IJ)V

    .line 175
    iget-object v1, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->sqlUpdateAction:Landroid/database/sqlite/SQLiteStatement;

    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteStatement;->execute()V

    .line 176
    iget-object v1, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->sqlUpdateAction:Landroid/database/sqlite/SQLiteStatement;

    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteStatement;->clearBindings()V
    :try_end_0
    .catch Landroid/database/SQLException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 187
    :goto_0
    :try_start_1
    monitor-exit v2

    .line 188
    return-void

    .line 178
    :catch_0
    move-exception v0

    .line 179
    .local v0, "e":Landroid/database/SQLException;
    const-string v1, "%s - Unable to bind prepared statement values for updating the adjusted start time for timed action (%s)"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    iget-object v5, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->logPrefix:Ljava/lang/String;

    aput-object v5, v3, v4

    const/4 v4, 0x1

    invoke-virtual {v0}, Landroid/database/SQLException;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v1, v3}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 182
    invoke-virtual {p0, v0}, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->resetDatabase(Ljava/lang/Exception;)V

    goto :goto_0

    .line 187
    .end local v0    # "e":Landroid/database/SQLException;
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v1

    .line 184
    :catch_1
    move-exception v0

    .line 185
    .local v0, "e":Ljava/lang/Exception;
    :try_start_2
    const-string v1, "%s - Unable to adjust start times for timed actions (%s)"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    iget-object v5, p0, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->logPrefix:Ljava/lang/String;

    aput-object v5, v3, v4

    const/4 v4, 0x1

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v1, v3}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0
.end method
