.class Lcom/localytics/android/AnalyticsProvider$AnalyticsDatabaseHelper;
.super Lcom/localytics/android/BaseProvider$LocalyticsDatabaseHelper;
.source "SourceFile"


# direct methods
.method constructor <init>(Ljava/lang/String;ILcom/localytics/android/LocalyticsDao;)V
    .locals 0

    .prologue
    .line 354
    invoke-direct {p0, p1, p2, p3}, Lcom/localytics/android/BaseProvider$LocalyticsDatabaseHelper;-><init>(Ljava/lang/String;ILcom/localytics/android/LocalyticsDao;)V

    .line 355
    return-void
.end method


# virtual methods
.method protected addFirstOpenEventToInfoTable(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 4

    .prologue
    .line 768
    const-string v0, "ALTER TABLE %s ADD COLUMN %s TEXT;"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "info"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string v3, "first_open_event_blob"

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 769
    return-void
.end method

.method protected migrateV2ToV3(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 34

    .prologue
    .line 382
    const-string v4, "CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT NOT NULL, %s INTEGER NOT NULL);"

    const/4 v5, 0x4

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    const-string v7, "events"

    aput-object v7, v5, v6

    const/4 v6, 0x1

    const-string v7, "_id"

    aput-object v7, v5, v6

    const/4 v6, 0x2

    const-string v7, "blob"

    aput-object v7, v5, v6

    const/4 v6, 0x3

    const-string v7, "upload_format"

    aput-object v7, v5, v6

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    move-object/from16 v0, p1

    invoke-virtual {v0, v4}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 392
    const-string v4, "CREATE TABLE %s (%s TEXT PRIMARY KEY, %s TEXT NOT NULL);"

    const/4 v5, 0x3

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    const-string v7, "identifiers"

    aput-object v7, v5, v6

    const/4 v6, 0x1

    const-string v7, "key"

    aput-object v7, v5, v6

    const/4 v6, 0x2

    const-string v7, "value"

    aput-object v7, v5, v6

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    move-object/from16 v0, p1

    invoke-virtual {v0, v4}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 400
    const-string v4, "CREATE TABLE %s (%s TEXT PRIMARY KEY, %s TEXT NOT NULL);"

    const/4 v5, 0x3

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    const-string v7, "custom_dimensions"

    aput-object v7, v5, v6

    const/4 v6, 0x1

    const-string v7, "custom_dimension_key"

    aput-object v7, v5, v6

    const/4 v6, 0x2

    const-string v7, "custom_dimension_value"

    aput-object v7, v5, v6

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    move-object/from16 v0, p1

    invoke-virtual {v0, v4}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 437
    const-string v4, "CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT UNIQUE NOT NULL, %s TEXT UNIQUE NOT NULL, %s INTEGER NOT NULL CHECK (%s >= 0), %s INTEGER NOT NULL CHECK(%s IN (%s, %s)), %s INTEGER NOT NULL CHECK(%s IN (%s, %s)), %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s INTEGER CHECK (%s >= 0), %s INTEGER CHECK (%s >= 0), %s INTEGER NOT NULL CHECK (%s >= 0), %s INTEGER NOT NULL CHECK (%s >= 0), %s TEXT, %s INTEGER);"

    const/16 v5, 0x24

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    const-string v7, "info"

    aput-object v7, v5, v6

    const/4 v6, 0x1

    const-string v7, "_id"

    aput-object v7, v5, v6

    const/4 v6, 0x2

    const-string v7, "api_key"

    aput-object v7, v5, v6

    const/4 v6, 0x3

    const-string v7, "uuid"

    aput-object v7, v5, v6

    const/4 v6, 0x4

    const-string v7, "created_time"

    aput-object v7, v5, v6

    const/4 v6, 0x5

    const-string v7, "created_time"

    aput-object v7, v5, v6

    const/4 v6, 0x6

    const-string v7, "opt_out"

    aput-object v7, v5, v6

    const/4 v6, 0x7

    const-string v7, "opt_out"

    aput-object v7, v5, v6

    const/16 v6, 0x8

    const-string v7, "0"

    aput-object v7, v5, v6

    const/16 v6, 0x9

    const-string v7, "1"

    aput-object v7, v5, v6

    const/16 v6, 0xa

    const-string v7, "push_disabled"

    aput-object v7, v5, v6

    const/16 v6, 0xb

    const-string v7, "push_disabled"

    aput-object v7, v5, v6

    const/16 v6, 0xc

    const-string v7, "0"

    aput-object v7, v5, v6

    const/16 v6, 0xd

    const-string v7, "1"

    aput-object v7, v5, v6

    const/16 v6, 0xe

    const-string v7, "sender_id"

    aput-object v7, v5, v6

    const/16 v6, 0xf

    const-string v7, "registration_id"

    aput-object v7, v5, v6

    const/16 v6, 0x10

    const-string v7, "registration_version"

    aput-object v7, v5, v6

    const/16 v6, 0x11

    const-string v7, "customer_id"

    aput-object v7, v5, v6

    const/16 v6, 0x12

    const-string v7, "user_type"

    aput-object v7, v5, v6

    const/16 v6, 0x13

    const-string v7, "fb_attribution"

    aput-object v7, v5, v6

    const/16 v6, 0x14

    const-string v7, "play_attribution"

    aput-object v7, v5, v6

    const/16 v6, 0x15

    const-string v7, "first_android_id"

    aput-object v7, v5, v6

    const/16 v6, 0x16

    const-string v7, "first_advertising_id"

    aput-object v7, v5, v6

    const/16 v6, 0x17

    const-string v7, "package_name"

    aput-object v7, v5, v6

    const/16 v6, 0x18

    const-string v7, "app_version"

    aput-object v7, v5, v6

    const/16 v6, 0x19

    const-string v7, "current_session_uuid"

    aput-object v7, v5, v6

    const/16 v6, 0x1a

    const-string v7, "last_session_open_time"

    aput-object v7, v5, v6

    const/16 v6, 0x1b

    const-string v7, "last_session_open_time"

    aput-object v7, v5, v6

    const/16 v6, 0x1c

    const-string v7, "last_session_close_time"

    aput-object v7, v5, v6

    const/16 v6, 0x1d

    const-string v7, "last_session_close_time"

    aput-object v7, v5, v6

    const/16 v6, 0x1e

    const-string v7, "next_session_number"

    aput-object v7, v5, v6

    const/16 v6, 0x1f

    const-string v7, "next_session_number"

    aput-object v7, v5, v6

    const/16 v6, 0x20

    const-string v7, "next_header_number"

    aput-object v7, v5, v6

    const/16 v6, 0x21

    const-string v7, "next_header_number"

    aput-object v7, v5, v6

    const/16 v6, 0x22

    const-string v7, "queued_close_session_blob"

    aput-object v7, v5, v6

    const/16 v6, 0x23

    const-string v7, "queued_close_session_blob_upload_format"

    aput-object v7, v5, v6

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    move-object/from16 v0, p1

    invoke-virtual {v0, v4}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 488
    sget-object v4, Lcom/localytics/android/AnalyticsProvider$AnalyticsDatabaseHelper;->oldDB:Landroid/database/sqlite/SQLiteDatabase;

    if-eqz v4, :cond_10

    .line 490
    sget-object v30, Lcom/localytics/android/AnalyticsProvider$AnalyticsDatabaseHelper;->oldDB:Landroid/database/sqlite/SQLiteDatabase;

    monitor-enter v30

    .line 492
    const/4 v12, 0x0

    .line 493
    :try_start_0
    new-instance v31, Landroid/content/ContentValues;

    invoke-direct/range {v31 .. v31}, Landroid/content/ContentValues;-><init>()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 495
    const/16 v27, 0x0

    .line 496
    const/16 v26, 0x0

    .line 497
    const-wide/16 v24, 0x0

    .line 498
    const/16 v19, 0x0

    .line 499
    const-wide/16 v22, 0x1

    .line 500
    const-wide/16 v20, 0x1

    .line 501
    const/4 v15, 0x0

    .line 502
    const-wide/16 v16, 0x0

    .line 503
    const/4 v14, 0x0

    .line 504
    const/16 v18, 0x0

    .line 505
    const/4 v13, 0x0

    .line 509
    :try_start_1
    sget-object v4, Lcom/localytics/android/AnalyticsProvider$AnalyticsDatabaseHelper;->oldDB:Landroid/database/sqlite/SQLiteDatabase;

    const-string v5, "api_keys"

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    const/4 v9, 0x0

    const/4 v10, 0x0

    const/4 v11, 0x0

    invoke-virtual/range {v4 .. v11}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v5

    .line 510
    :try_start_2
    invoke-interface {v5}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v4

    if-eqz v4, :cond_1b

    .line 512
    const-string v4, "api_key"

    invoke-interface {v5, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v5, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v9

    .line 513
    const-string v4, "uuid"

    invoke-interface {v5, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v5, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v8

    .line 514
    const-string v4, "created_time"

    invoke-interface {v5, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v5, v4}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v6

    .line 515
    const-string v4, "opt_out"

    invoke-interface {v5, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v5, v4}, Landroid/database/Cursor;->getInt(I)I

    move-result v4

    const-string v10, "1"

    invoke-static {v10}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/Integer;->intValue()I
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_8

    move-result v10

    if-ne v4, v10, :cond_0

    const/4 v4, 0x1

    :goto_0
    move/from16 v25, v4

    move-wide/from16 v26, v6

    move-object/from16 v28, v8

    move-object/from16 v29, v9

    .line 520
    :goto_1
    if-eqz v5, :cond_1a

    .line 522
    :try_start_3
    invoke-interface {v5}, Landroid/database/Cursor;->close()V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 523
    const/4 v12, 0x0

    .line 529
    :goto_2
    :try_start_4
    sget-object v4, Lcom/localytics/android/AnalyticsProvider$AnalyticsDatabaseHelper;->oldDB:Landroid/database/sqlite/SQLiteDatabase;

    const-string v5, "identifiers"

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    const/4 v9, 0x0

    const/4 v10, 0x0

    const/4 v11, 0x0

    invoke-virtual/range {v4 .. v11}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_3

    move-result-object v5

    move-object/from16 v24, v18

    .line 530
    :goto_3
    :try_start_5
    invoke-interface {v5}, Landroid/database/Cursor;->moveToNext()Z

    move-result v4

    if-eqz v4, :cond_2

    .line 532
    const-string v4, "key"

    invoke-interface {v5, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v5, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v7

    .line 533
    const-string v4, "value"

    invoke-interface {v5, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v5, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v6

    .line 534
    const-string v4, "customer_id"

    invoke-virtual {v7, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_19

    move-object v4, v6

    .line 537
    :goto_4
    const-string v8, "key"

    move-object/from16 v0, v31

    invoke-virtual {v0, v8, v7}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 538
    const-string v7, "value"

    move-object/from16 v0, v31

    invoke-virtual {v0, v7, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 539
    const-string v6, "identifiers"

    const/4 v7, 0x0

    move-object/from16 v0, p1

    move-object/from16 v1, v31

    invoke-virtual {v0, v6, v7, v1}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    .line 540
    invoke-virtual/range {v31 .. v31}, Landroid/content/ContentValues;->clear()V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_7

    move-object/from16 v24, v4

    .line 541
    goto :goto_3

    .line 515
    :cond_0
    const/4 v4, 0x0

    goto :goto_0

    .line 520
    :catchall_0
    move-exception v4

    move-object v5, v12

    :goto_5
    if-eqz v5, :cond_1

    .line 522
    :try_start_6
    invoke-interface {v5}, Landroid/database/Cursor;->close()V

    .line 523
    :cond_1
    throw v4

    .line 730
    :catchall_1
    move-exception v4

    monitor-exit v30
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    throw v4

    .line 545
    :cond_2
    if-eqz v5, :cond_18

    .line 547
    :try_start_7
    invoke-interface {v5}, Landroid/database/Cursor;->close()V
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_1

    .line 548
    const/4 v12, 0x0

    .line 554
    :goto_6
    :try_start_8
    sget-object v4, Lcom/localytics/android/AnalyticsProvider$AnalyticsDatabaseHelper;->oldDB:Landroid/database/sqlite/SQLiteDatabase;

    const-string v5, "custom_dimensions"

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    const/4 v9, 0x0

    const/4 v10, 0x0

    const/4 v11, 0x0

    invoke-virtual/range {v4 .. v11}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_6

    move-result-object v5

    .line 555
    :goto_7
    :try_start_9
    invoke-interface {v5}, Landroid/database/Cursor;->moveToNext()Z

    move-result v4

    if-eqz v4, :cond_5

    .line 557
    const-string v4, "custom_dimension_key"

    invoke-interface {v5, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v5, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 558
    const-string v6, "custom_dimension_key"

    const-string v7, "com.localytics.android:"

    const-string v8, ""

    invoke-virtual {v4, v7, v8}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v4

    move-object/from16 v0, v31

    invoke-virtual {v0, v6, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 559
    const-string v4, "custom_dimension_value"

    const-string v6, "custom_dimension_value"

    invoke-interface {v5, v6}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v6

    invoke-interface {v5, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v6

    move-object/from16 v0, v31

    invoke-virtual {v0, v4, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 560
    const-string v4, "custom_dimensions"

    const/4 v6, 0x0

    move-object/from16 v0, p1

    move-object/from16 v1, v31

    invoke-virtual {v0, v4, v6, v1}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    .line 561
    invoke-virtual/range {v31 .. v31}, Landroid/content/ContentValues;->clear()V
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_2

    goto :goto_7

    .line 566
    :catchall_2
    move-exception v4

    :goto_8
    if-eqz v5, :cond_3

    .line 568
    :try_start_a
    invoke-interface {v5}, Landroid/database/Cursor;->close()V

    .line 569
    :cond_3
    throw v4

    .line 545
    :catchall_3
    move-exception v4

    move-object v5, v12

    :goto_9
    if-eqz v5, :cond_4

    .line 547
    invoke-interface {v5}, Landroid/database/Cursor;->close()V

    .line 548
    :cond_4
    throw v4

    .line 566
    :cond_5
    if-eqz v5, :cond_17

    .line 568
    invoke-interface {v5}, Landroid/database/Cursor;->close()V

    .line 569
    const/16 v18, 0x0

    .line 573
    :goto_a
    if-eqz v29, :cond_16

    .line 575
    sget-object v4, Lcom/localytics/android/AnalyticsProvider$AnalyticsDatabaseHelper;->oldDB:Landroid/database/sqlite/SQLiteDatabase;

    invoke-static {v4}, Lcom/localytics/android/MigrationDatabaseHelper;->preUploadBuildBlobs(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 577
    const/4 v4, 0x0

    move-object v9, v4

    move-object v5, v14

    move-wide/from16 v6, v16

    move-object v8, v15

    move-wide/from16 v10, v20

    move-object v4, v13

    move-wide/from16 v12, v22

    .line 580
    :goto_b
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/localytics/android/AnalyticsProvider$AnalyticsDatabaseHelper;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v14}, Lcom/localytics/android/LocalyticsDao;->getAppContext()Landroid/content/Context;

    move-result-object v14

    sget-object v15, Lcom/localytics/android/AnalyticsProvider$AnalyticsDatabaseHelper;->oldDB:Landroid/database/sqlite/SQLiteDatabase;

    move-object/from16 v0, v29

    invoke-static {v14, v15, v0}, Lcom/localytics/android/MigrationDatabaseHelper;->convertDatabaseToJson(Landroid/content/Context;Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)Ljava/util/List;

    move-result-object v14

    .line 581
    invoke-interface {v14}, Ljava/util/List;->isEmpty()Z

    move-result v15

    if-nez v15, :cond_c

    .line 583
    new-instance v20, Ljava/lang/StringBuilder;

    invoke-direct/range {v20 .. v20}, Ljava/lang/StringBuilder;-><init>()V

    .line 586
    invoke-interface {v14}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v21

    move-object/from16 v19, v9

    move-wide v14, v10

    move-object v9, v5

    move-wide v10, v6

    move-wide v6, v12

    move-object v12, v8

    move-object v8, v4

    :goto_c
    invoke-interface/range {v21 .. v21}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_b

    invoke-interface/range {v21 .. v21}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lorg/json/JSONObject;
    :try_end_a
    .catchall {:try_start_a .. :try_end_a} :catchall_1

    .line 590
    :try_start_b
    const-string v5, "dt"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    const-string v13, "h"

    invoke-virtual {v5, v13}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_7

    .line 592
    if-nez v19, :cond_6

    .line 594
    const-string v5, "seq"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->getLong(Ljava/lang/String;)J

    move-result-wide v6

    :cond_6
    move-object/from16 v19, v4

    .line 596
    goto :goto_c

    .line 600
    :cond_7
    const-string v5, "seq"
    :try_end_b
    .catch Ljava/lang/Exception; {:try_start_b .. :try_end_b} :catch_1
    .catchall {:try_start_b .. :try_end_b} :catchall_1

    const-wide/16 v16, 0x1

    add-long v16, v16, v6

    :try_start_c
    move-object/from16 v0, v19

    invoke-virtual {v0, v5, v6, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 601
    const-string v5, "u"

    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v6

    invoke-virtual {v6}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v6

    move-object/from16 v0, v19

    invoke-virtual {v0, v5, v6}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 603
    invoke-virtual/range {v19 .. v19}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v5

    move-object/from16 v0, v20

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "\n"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v4}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 604
    const-string v5, "dt"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    const-string v6, "c"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_a

    .line 606
    invoke-virtual/range {v20 .. v20}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v13

    .line 607
    const-string v5, "ct"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/Long;

    invoke-virtual {v5}, Ljava/lang/Long;->longValue()J

    move-result-wide v6

    const-wide/16 v22, 0x3e8

    mul-long v6, v6, v22

    .line 611
    if-eqz v12, :cond_8

    .line 615
    new-instance v5, Landroid/content/ContentValues;

    invoke-direct {v5}, Landroid/content/ContentValues;-><init>()V

    .line 616
    const-string v22, "upload_format"

    sget-object v23, Lcom/localytics/android/AnalyticsProvider$EventsV3Columns$UploadFormat;->V2:Lcom/localytics/android/AnalyticsProvider$EventsV3Columns$UploadFormat;

    invoke-virtual/range {v23 .. v23}, Lcom/localytics/android/AnalyticsProvider$EventsV3Columns$UploadFormat;->getValue()I

    move-result v23

    invoke-static/range {v23 .. v23}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v23

    move-object/from16 v0, v22

    move-object/from16 v1, v23

    invoke-virtual {v5, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 619
    cmp-long v22, v6, v10

    if-lez v22, :cond_9

    .line 621
    const-string v22, "blob"

    move-object/from16 v0, v22

    invoke-virtual {v5, v0, v12}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 622
    const-string v22, "events"

    const/16 v23, 0x0

    move-object/from16 v0, p1

    move-object/from16 v1, v22

    move-object/from16 v2, v23

    invoke-virtual {v0, v1, v2, v5}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    :try_end_c
    .catch Ljava/lang/Exception; {:try_start_c .. :try_end_c} :catch_2
    .catchall {:try_start_c .. :try_end_c} :catchall_1

    :cond_8
    move-object v5, v13

    .line 639
    :goto_d
    :try_start_d
    const-string v10, "fl"

    invoke-virtual {v4, v10}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v10

    if-eqz v10, :cond_15

    .line 641
    const-string v10, "fl"

    invoke-virtual {v4, v10}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v4

    const-string v10, ","

    invoke-virtual {v4, v10}, Lorg/json/JSONArray;->join(Ljava/lang/String;)Ljava/lang/String;
    :try_end_d
    .catch Ljava/lang/Exception; {:try_start_d .. :try_end_d} :catch_3
    .catchall {:try_start_d .. :try_end_d} :catchall_1

    move-result-object v4

    :goto_e
    move-object v8, v4

    move-wide v10, v14

    move-object v4, v9

    .line 655
    :goto_f
    :try_start_e
    invoke-virtual/range {v31 .. v31}, Landroid/content/ContentValues;->clear()V

    .line 656
    const/4 v9, 0x0

    invoke-virtual/range {v20 .. v20}, Ljava/lang/StringBuilder;->length()I

    move-result v12

    move-object/from16 v0, v20

    invoke-virtual {v0, v9, v12}, Ljava/lang/StringBuilder;->delete(II)Ljava/lang/StringBuilder;
    :try_end_e
    .catch Ljava/lang/Exception; {:try_start_e .. :try_end_e} :catch_0
    .catchall {:try_start_e .. :try_end_e} :catchall_1

    move-object v9, v4

    move-object v12, v5

    move-wide v14, v10

    move-wide v10, v6

    move-wide/from16 v6, v16

    .line 661
    goto/16 :goto_c

    .line 629
    :cond_9
    :try_start_f
    const-string v6, "blob"

    invoke-virtual {v5, v6, v13}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 630
    const-string v6, "events"

    const/4 v7, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v6, v7, v5}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    move-wide v6, v10

    move-object v5, v12

    .line 633
    goto :goto_d

    .line 646
    :cond_a
    const-string v5, "dt"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    const-string v6, "s"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_14

    .line 648
    const-string v5, "nth"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->getLong(Ljava/lang/String;)J
    :try_end_f
    .catch Ljava/lang/Exception; {:try_start_f .. :try_end_f} :catch_2
    .catchall {:try_start_f .. :try_end_f} :catchall_1

    move-result-wide v6

    .line 649
    :try_start_10
    const-string v5, "u"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;
    :try_end_10
    .catch Ljava/lang/Exception; {:try_start_10 .. :try_end_10} :catch_4
    .catchall {:try_start_10 .. :try_end_10} :catchall_1

    move-result-object v4

    .line 651
    :goto_10
    :try_start_11
    const-string v5, "blob"

    invoke-virtual/range {v20 .. v20}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    move-object/from16 v0, v31

    invoke-virtual {v0, v5, v9}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 652
    const-string v5, "upload_format"

    sget-object v9, Lcom/localytics/android/AnalyticsProvider$EventsV3Columns$UploadFormat;->V2:Lcom/localytics/android/AnalyticsProvider$EventsV3Columns$UploadFormat;

    invoke-virtual {v9}, Lcom/localytics/android/AnalyticsProvider$EventsV3Columns$UploadFormat;->getValue()I

    move-result v9

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    move-object/from16 v0, v31

    invoke-virtual {v0, v5, v9}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 653
    const-string v5, "events"

    const/4 v9, 0x0

    move-object/from16 v0, p1

    move-object/from16 v1, v31

    invoke-virtual {v0, v5, v9, v1}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    :try_end_11
    .catch Ljava/lang/Exception; {:try_start_11 .. :try_end_11} :catch_5
    .catchall {:try_start_11 .. :try_end_11} :catchall_1

    move-object v5, v12

    move-wide/from16 v32, v10

    move-wide v10, v6

    move-wide/from16 v6, v32

    goto :goto_f

    .line 662
    :catch_0
    move-exception v9

    move-wide/from16 v12, v16

    :goto_11
    move-object v9, v4

    move-wide v14, v10

    move-wide v10, v6

    move-wide v6, v12

    move-object v12, v5

    goto/16 :goto_c

    :cond_b
    move-object v4, v8

    move-object v5, v9

    move-object/from16 v9, v19

    move-object v8, v12

    move-wide v12, v6

    move-wide v6, v10

    move-wide v10, v14

    .line 663
    goto/16 :goto_b

    :cond_c
    move-wide v14, v6

    move-object/from16 v16, v8

    move-wide/from16 v20, v10

    move-wide/from16 v22, v12

    move-object v12, v4

    move-object v13, v5

    .line 668
    :goto_12
    :try_start_12
    sget-object v4, Lcom/localytics/android/AnalyticsProvider$AnalyticsDatabaseHelper;->oldDB:Landroid/database/sqlite/SQLiteDatabase;

    const-string v5, "info"

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    const/4 v9, 0x0

    const/4 v10, 0x0

    const/4 v11, 0x0

    invoke-virtual/range {v4 .. v11}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_12
    .catchall {:try_start_12 .. :try_end_12} :catchall_5

    move-result-object v5

    .line 669
    :try_start_13
    invoke-interface {v5}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v4

    if-eqz v4, :cond_e

    .line 671
    const-string v4, "api_key"

    move-object/from16 v0, v31

    move-object/from16 v1, v29

    invoke-virtual {v0, v4, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 672
    const-string v4, "uuid"

    move-object/from16 v0, v31

    move-object/from16 v1, v28

    invoke-virtual {v0, v4, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 673
    const-string v4, "created_time"

    invoke-static/range {v26 .. v27}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    move-object/from16 v0, v31

    invoke-virtual {v0, v4, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 674
    const-string v4, "opt_out"

    invoke-static/range {v25 .. v25}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v6

    move-object/from16 v0, v31

    invoke-virtual {v0, v4, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 675
    const-string v4, "push_disabled"

    const-string v6, "push_disabled"

    invoke-interface {v5, v6}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v6

    invoke-interface {v5, v6}, Landroid/database/Cursor;->getInt(I)I

    move-result v6

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    move-object/from16 v0, v31

    invoke-virtual {v0, v4, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 676
    const-string v4, "sender_id"

    const-string v6, "sender_id"

    invoke-interface {v5, v6}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v6

    invoke-interface {v5, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v6

    move-object/from16 v0, v31

    invoke-virtual {v0, v4, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 677
    const-string v4, "registration_id"

    const-string v6, "registration_id"

    invoke-interface {v5, v6}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v6

    invoke-interface {v5, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v6

    move-object/from16 v0, v31

    invoke-virtual {v0, v4, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 678
    const-string v4, "registration_version"

    const-string v6, "registration_version"

    invoke-interface {v5, v6}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v6

    invoke-interface {v5, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v6

    move-object/from16 v0, v31

    invoke-virtual {v0, v4, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 679
    if-eqz v24, :cond_11

    .line 681
    const-string v4, "customer_id"

    move-object/from16 v0, v31

    move-object/from16 v1, v24

    invoke-virtual {v0, v4, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 682
    const-string v4, "user_type"

    const-string v6, "known"

    move-object/from16 v0, v31

    invoke-virtual {v0, v4, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 689
    :goto_13
    const-string v4, "fb_attribution"

    const-string v6, "fb_attribution"

    invoke-interface {v5, v6}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v6

    invoke-interface {v5, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v6

    move-object/from16 v0, v31

    invoke-virtual {v0, v4, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 690
    const-string v4, "play_attribution"

    const-string v6, "play_attribution"

    invoke-interface {v5, v6}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v6

    invoke-interface {v5, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v6

    move-object/from16 v0, v31

    invoke-virtual {v0, v4, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 691
    const-string v4, "first_android_id"

    const-string v6, "first_android_id"

    invoke-interface {v5, v6}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v6

    invoke-interface {v5, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v6

    move-object/from16 v0, v31

    invoke-virtual {v0, v4, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 692
    const-string v4, "first_advertising_id"

    const-string v6, "first_advertising_id"

    invoke-interface {v5, v6}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v6

    invoke-interface {v5, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v6

    move-object/from16 v0, v31

    invoke-virtual {v0, v4, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 693
    const-string v4, "app_version"

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/localytics/android/AnalyticsProvider$AnalyticsDatabaseHelper;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v6}, Lcom/localytics/android/LocalyticsDao;->getAppContext()Landroid/content/Context;

    move-result-object v6

    invoke-static {v6}, Lcom/localytics/android/DatapointHelper;->getAppVersion(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v6

    move-object/from16 v0, v31

    invoke-virtual {v0, v4, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 694
    const-string v4, "package_name"

    const-string v6, "package_name"

    invoke-interface {v5, v6}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v6

    invoke-interface {v5, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v6

    move-object/from16 v0, v31

    invoke-virtual {v0, v4, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 695
    const-string v4, "current_session_uuid"

    move-object/from16 v0, v31

    invoke-virtual {v0, v4, v13}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 696
    const-string v4, "last_session_open_time"

    invoke-interface {v5, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v5, v4}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v6

    .line 697
    const-string v4, "last_session_open_time"

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v8

    move-object/from16 v0, v31

    invoke-virtual {v0, v4, v8}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 698
    const-string v4, "last_session_close_time"

    invoke-static {v14, v15}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v8

    move-object/from16 v0, v31

    invoke-virtual {v0, v4, v8}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 699
    const-string v4, "next_header_number"

    const-wide/16 v8, 0x1

    add-long v8, v8, v22

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v8

    move-object/from16 v0, v31

    invoke-virtual {v0, v4, v8}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 700
    const-string v4, "next_session_number"

    const-wide/16 v8, 0x1

    add-long v8, v8, v20

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v8

    move-object/from16 v0, v31

    invoke-virtual {v0, v4, v8}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 701
    cmp-long v4, v14, v6

    if-lez v4, :cond_13

    .line 703
    const-string v4, "queued_close_session_blob"

    move-object/from16 v0, v31

    move-object/from16 v1, v16

    invoke-virtual {v0, v4, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 704
    const-string v4, "queued_close_session_blob_upload_format"

    sget-object v6, Lcom/localytics/android/AnalyticsProvider$EventsV3Columns$UploadFormat;->V2:Lcom/localytics/android/AnalyticsProvider$EventsV3Columns$UploadFormat;

    invoke-virtual {v6}, Lcom/localytics/android/AnalyticsProvider$EventsV3Columns$UploadFormat;->getValue()I

    move-result v6

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    move-object/from16 v0, v31

    invoke-virtual {v0, v4, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 705
    if-eqz v12, :cond_d

    .line 707
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/localytics/android/AnalyticsProvider$AnalyticsDatabaseHelper;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    const-string v6, ","

    invoke-virtual {v12, v6}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v6

    invoke-interface {v4, v6}, Lcom/localytics/android/LocalyticsDao;->setScreenFlow(Ljava/util/List;)V

    .line 717
    :cond_d
    :goto_14
    const-string v4, "info"

    const/4 v6, 0x0

    move-object/from16 v0, p1

    move-object/from16 v1, v31

    invoke-virtual {v0, v4, v6, v1}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    .line 718
    invoke-virtual/range {v31 .. v31}, Landroid/content/ContentValues;->clear()V
    :try_end_13
    .catchall {:try_start_13 .. :try_end_13} :catchall_4

    .line 723
    :cond_e
    if-eqz v5, :cond_f

    .line 725
    :try_start_14
    invoke-interface {v5}, Landroid/database/Cursor;->close()V

    .line 729
    :cond_f
    invoke-static {}, Lcom/localytics/android/AnalyticsProvider$AnalyticsDatabaseHelper;->cleanUpOldDB()V

    .line 730
    monitor-exit v30
    :try_end_14
    .catchall {:try_start_14 .. :try_end_14} :catchall_1

    .line 732
    :cond_10
    return-void

    .line 686
    :cond_11
    :try_start_15
    const-string v4, "customer_id"

    move-object/from16 v0, v31

    move-object/from16 v1, v28

    invoke-virtual {v0, v4, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 687
    const-string v4, "user_type"

    const-string v6, "anonymous"

    move-object/from16 v0, v31

    invoke-virtual {v0, v4, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_15
    .catchall {:try_start_15 .. :try_end_15} :catchall_4

    goto/16 :goto_13

    .line 723
    :catchall_4
    move-exception v4

    :goto_15
    if-eqz v5, :cond_12

    .line 725
    :try_start_16
    invoke-interface {v5}, Landroid/database/Cursor;->close()V

    :cond_12
    throw v4
    :try_end_16
    .catchall {:try_start_16 .. :try_end_16} :catchall_1

    .line 710
    :cond_13
    if-eqz v16, :cond_d

    .line 712
    :try_start_17
    new-instance v4, Landroid/content/ContentValues;

    invoke-direct {v4}, Landroid/content/ContentValues;-><init>()V

    .line 713
    const-string v6, "blob"

    move-object/from16 v0, v16

    invoke-virtual {v4, v6, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 714
    const-string v6, "upload_format"

    sget-object v7, Lcom/localytics/android/AnalyticsProvider$EventsV3Columns$UploadFormat;->V2:Lcom/localytics/android/AnalyticsProvider$EventsV3Columns$UploadFormat;

    invoke-virtual {v7}, Lcom/localytics/android/AnalyticsProvider$EventsV3Columns$UploadFormat;->getValue()I

    move-result v7

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    invoke-virtual {v4, v6, v7}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 715
    const-string v6, "events"

    const/4 v7, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v6, v7, v4}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    :try_end_17
    .catchall {:try_start_17 .. :try_end_17} :catchall_4

    goto :goto_14

    .line 723
    :catchall_5
    move-exception v4

    move-object/from16 v5, v18

    goto :goto_15

    .line 662
    :catch_1
    move-exception v4

    move-object v4, v9

    move-object v5, v12

    move-wide v12, v6

    move-wide v6, v10

    move-wide v10, v14

    goto/16 :goto_11

    :catch_2
    move-exception v4

    move-object v4, v9

    move-wide v6, v10

    move-object v5, v12

    move-wide v10, v14

    move-wide/from16 v12, v16

    goto/16 :goto_11

    :catch_3
    move-exception v4

    move-object v4, v9

    move-wide v10, v14

    move-wide/from16 v12, v16

    goto/16 :goto_11

    :catch_4
    move-exception v4

    move-object v4, v9

    move-object v5, v12

    move-wide/from16 v12, v16

    move-wide/from16 v32, v6

    move-wide v6, v10

    move-wide/from16 v10, v32

    goto/16 :goto_11

    :catch_5
    move-exception v5

    move-object v5, v12

    move-wide/from16 v12, v16

    move-wide/from16 v32, v6

    move-wide v6, v10

    move-wide/from16 v10, v32

    goto/16 :goto_11

    .line 566
    :catchall_6
    move-exception v4

    move-object v5, v12

    goto/16 :goto_8

    .line 545
    :catchall_7
    move-exception v4

    goto/16 :goto_9

    .line 520
    :catchall_8
    move-exception v4

    goto/16 :goto_5

    :cond_14
    move-object v4, v9

    move-wide v6, v14

    goto/16 :goto_10

    :cond_15
    move-object v4, v8

    goto/16 :goto_e

    :cond_16
    move-object v12, v13

    move-object v13, v14

    move-wide/from16 v32, v16

    move-object/from16 v16, v15

    move-wide/from16 v14, v32

    goto/16 :goto_12

    :cond_17
    move-object/from16 v18, v5

    goto/16 :goto_a

    :cond_18
    move-object v12, v5

    goto/16 :goto_6

    :cond_19
    move-object/from16 v4, v24

    goto/16 :goto_4

    :cond_1a
    move-object v12, v5

    goto/16 :goto_2

    :cond_1b
    move-object/from16 v28, v26

    move-object/from16 v29, v27

    move-wide/from16 v26, v24

    move/from16 v25, v19

    goto/16 :goto_1
.end method

.method public onCreate(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 2

    .prologue
    .line 369
    if-nez p1, :cond_0

    .line 371
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "db cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 374
    :cond_0
    const-string v0, "PRAGMA auto_vacuum = INCREMENTAL;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 375
    const/4 v0, 0x0

    const/4 v1, 0x2

    invoke-virtual {p0, p1, v0, v1}, Lcom/localytics/android/AnalyticsProvider$AnalyticsDatabaseHelper;->onUpgrade(Landroid/database/sqlite/SQLiteDatabase;II)V

    .line 376
    return-void
.end method

.method public onOpen(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 5

    .prologue
    .line 751
    invoke-super {p0, p1}, Lcom/localytics/android/BaseProvider$LocalyticsDatabaseHelper;->onOpen(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 753
    const-string v0, "SQLite library version is: %s"

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "select sqlite_version()"

    const/4 v4, 0x0

    invoke-static {p1, v3, v4}, Landroid/database/DatabaseUtils;->stringForQuery(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->v(Ljava/lang/String;)I

    .line 755
    invoke-virtual {p1}, Landroid/database/sqlite/SQLiteDatabase;->isReadOnly()Z

    move-result v0

    if-nez v0, :cond_0

    .line 760
    const-string v0, "PRAGMA foreign_keys = ON;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 762
    :cond_0
    return-void
.end method

.method public onUpgrade(Landroid/database/sqlite/SQLiteDatabase;II)V
    .locals 1

    .prologue
    .line 737
    if-gtz p2, :cond_0

    .line 739
    invoke-virtual {p0, p1}, Lcom/localytics/android/AnalyticsProvider$AnalyticsDatabaseHelper;->migrateV2ToV3(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 742
    :cond_0
    const/4 v0, 0x2

    if-ge p2, v0, :cond_1

    .line 744
    invoke-virtual {p0, p1}, Lcom/localytics/android/AnalyticsProvider$AnalyticsDatabaseHelper;->addFirstOpenEventToInfoTable(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 746
    :cond_1
    return-void
.end method
