.class Lcom/localytics/android/MarketingProvider$MarketingDatabaseHelper;
.super Lcom/localytics/android/BaseProvider$LocalyticsDatabaseHelper;
.source "SourceFile"


# direct methods
.method constructor <init>(Ljava/lang/String;ILcom/localytics/android/LocalyticsDao;)V
    .locals 0

    .prologue
    .line 719
    invoke-direct {p0, p1, p2, p3}, Lcom/localytics/android/BaseProvider$LocalyticsDatabaseHelper;-><init>(Ljava/lang/String;ILcom/localytics/android/LocalyticsDao;)V

    .line 720
    return-void
.end method


# virtual methods
.method protected addControlGroup(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 4

    .prologue
    .line 1011
    const-string v0, "ALTER TABLE %s ADD COLUMN %s INTEGER DEFAULT 0;"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "marketing_rules"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string v3, "control_group"

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 1012
    return-void
.end method

.method protected addNonUniqueRuleName(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 6

    .prologue
    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 996
    const-string v0, "ALTER TABLE %s ADD COLUMN %s TEXT;"

    new-array v1, v5, [Ljava/lang/Object;

    const-string v2, "marketing_rules"

    aput-object v2, v1, v3

    const-string v2, "rule_name_non_unique"

    aput-object v2, v1, v4

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 1002
    const-string v0, "UPDATE %s SET %s = %s;"

    const/4 v1, 0x3

    new-array v1, v1, [Ljava/lang/Object;

    const-string v2, "marketing_rules"

    aput-object v2, v1, v3

    const-string v2, "rule_name_non_unique"

    aput-object v2, v1, v4

    const-string v2, "rule_name"

    aput-object v2, v1, v5

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 1006
    return-void
.end method

.method protected addSchemaVersion(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 4

    .prologue
    .line 1017
    const-string v0, "ALTER TABLE %s ADD COLUMN %s INTEGER DEFAULT 1;"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "marketing_rules"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string v3, "schema_version"

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 1018
    return-void
.end method

.method protected migrateV2ToV3(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 13

    .prologue
    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x0

    const/4 v12, 0x1

    const/4 v8, 0x0

    .line 746
    const-string v0, "CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s INTEGER NOT NULL, %s INTEGER NOT NULL, %s INTEGER, %s INTEGER, %s TEXT NOT NULL, %s TEXT NOT NULL, %s INTEGER NOT NULL, %s INTEGER NOT NULL, %s TEXT NOT NULL, %s INTEGER NOT NULL, %s INTEGER NOT NULL, %s INTEGER, %s INTEGER NOT NULL, %s TEXT, %s TEXT UNIQUE NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL)"

    const/16 v1, 0x13

    new-array v1, v1, [Ljava/lang/Object;

    const-string v2, "marketing_rules"

    aput-object v2, v1, v4

    const-string v2, "_id"

    aput-object v2, v1, v12

    const-string v2, "campaign_id"

    aput-object v2, v1, v5

    const-string v2, "expiration"

    aput-object v2, v1, v6

    const/4 v2, 0x4

    const-string v3, "display_seconds"

    aput-object v3, v1, v2

    const/4 v2, 0x5

    const-string v3, "display_session"

    aput-object v3, v1, v2

    const/4 v2, 0x6

    const-string v3, "version"

    aput-object v3, v1, v2

    const/4 v2, 0x7

    const-string v3, "phone_location"

    aput-object v3, v1, v2

    const/16 v2, 0x8

    const-string v3, "phone_size_width"

    aput-object v3, v1, v2

    const/16 v2, 0x9

    const-string v3, "phone_size_height"

    aput-object v3, v1, v2

    const/16 v2, 0xa

    const-string v3, "tablet_location"

    aput-object v3, v1, v2

    const/16 v2, 0xb

    const-string v3, "tablet_size_width"

    aput-object v3, v1, v2

    const/16 v2, 0xc

    const-string v3, "tablet_size_height"

    aput-object v3, v1, v2

    const/16 v2, 0xd

    const-string v3, "time_to_display"

    aput-object v3, v1, v2

    const/16 v2, 0xe

    const-string v3, "internet_required"

    aput-object v3, v1, v2

    const/16 v2, 0xf

    const-string v3, "ab_test"

    aput-object v3, v1, v2

    const/16 v2, 0x10

    const-string v3, "rule_name"

    aput-object v3, v1, v2

    const/16 v2, 0x11

    const-string v3, "location"

    aput-object v3, v1, v2

    const/16 v2, 0x12

    const-string v3, "devices"

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 786
    const-string v0, "CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT NOT NULL, %s INTEGER REFERENCES %s(%s) NOT NULL);"

    const/4 v1, 0x6

    new-array v1, v1, [Ljava/lang/Object;

    const-string v2, "marketing_ruleevent"

    aput-object v2, v1, v4

    const-string v2, "_id"

    aput-object v2, v1, v12

    const-string v2, "event_name"

    aput-object v2, v1, v5

    const-string v2, "rule_id_ref"

    aput-object v2, v1, v6

    const/4 v2, 0x4

    const-string v3, "marketing_rules"

    aput-object v3, v1, v2

    const/4 v2, 0x5

    const-string v3, "_id"

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 796
    const-string v0, "CREATE TABLE %s (%s INTEGER PRIMARY KEY);"

    new-array v1, v5, [Ljava/lang/Object;

    const-string v2, "marketing_displayed"

    aput-object v2, v1, v4

    const-string v2, "campaign_id"

    aput-object v2, v1, v12

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 802
    const-string v0, "CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT NOT NULL, %s TEXT NOT NULL, %s INTEGER REFERENCES %s(%s) NOT NULL);"

    const/4 v1, 0x7

    new-array v1, v1, [Ljava/lang/Object;

    const-string v2, "marketing_conditions"

    aput-object v2, v1, v4

    const-string v2, "_id"

    aput-object v2, v1, v12

    const-string v2, "attribute_name"

    aput-object v2, v1, v5

    const-string v2, "operator"

    aput-object v2, v1, v6

    const/4 v2, 0x4

    const-string v3, "rule_id_ref"

    aput-object v3, v1, v2

    const/4 v2, 0x5

    const-string v3, "marketing_rules"

    aput-object v3, v1, v2

    const/4 v2, 0x6

    const-string v3, "_id"

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 814
    const-string v0, "CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT NOT NULL, %s INTEGER REFERENCES %s(%s) NOT NULL);"

    const/4 v1, 0x6

    new-array v1, v1, [Ljava/lang/Object;

    const-string v2, "marketing_condition_values"

    aput-object v2, v1, v4

    const-string v2, "_id"

    aput-object v2, v1, v12

    const-string v2, "value"

    aput-object v2, v1, v5

    const-string v2, "condition_id_ref"

    aput-object v2, v1, v6

    const/4 v2, 0x4

    const-string v3, "marketing_conditions"

    aput-object v3, v1, v2

    const/4 v2, 0x5

    const-string v3, "_id"

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 823
    sget-object v0, Lcom/localytics/android/MarketingProvider$MarketingDatabaseHelper;->oldDB:Landroid/database/sqlite/SQLiteDatabase;

    if-eqz v0, :cond_c

    .line 825
    sget-object v10, Lcom/localytics/android/MarketingProvider$MarketingDatabaseHelper;->oldDB:Landroid/database/sqlite/SQLiteDatabase;

    monitor-enter v10

    .line 828
    :try_start_0
    new-instance v11, Landroid/content/ContentValues;

    invoke-direct {v11}, Landroid/content/ContentValues;-><init>()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 831
    :try_start_1
    sget-object v0, Lcom/localytics/android/MarketingProvider$MarketingDatabaseHelper;->oldDB:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "amp_rules"

    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    const-string v7, "_id ASC"

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_a

    move-result-object v1

    .line 832
    :goto_0
    :try_start_2
    invoke-interface {v1}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 834
    const-string v0, "_id"

    const-string v2, "_id"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getInt(I)I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v11, v0, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 835
    const-string v0, "campaign_id"

    const-string v2, "campaign_id"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getInt(I)I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v11, v0, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 836
    const-string v0, "expiration"

    const-string v2, "expiration"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getInt(I)I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v11, v0, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 837
    const-string v0, "display_seconds"

    const-string v2, "display_seconds"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getInt(I)I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v11, v0, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 838
    const-string v0, "display_session"

    const-string v2, "display_session"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getInt(I)I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v11, v0, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 839
    const-string v0, "version"

    const-string v2, "version"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v11, v0, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 840
    const-string v0, "phone_location"

    const-string v2, "phone_location"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v11, v0, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 841
    const-string v0, "phone_size_width"

    const-string v2, "phone_size_width"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getInt(I)I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v11, v0, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 842
    const-string v0, "phone_size_height"

    const-string v2, "phone_size_height"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getInt(I)I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v11, v0, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 843
    const-string v0, "tablet_location"

    const-string v2, "tablet_location"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v11, v0, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 844
    const-string v0, "tablet_size_width"

    const-string v2, "tablet_size_width"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getInt(I)I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v11, v0, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 845
    const-string v0, "tablet_size_height"

    const-string v2, "tablet_size_height"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getInt(I)I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v11, v0, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 846
    const-string v0, "time_to_display"

    const-string v2, "time_to_display"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getInt(I)I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v11, v0, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 847
    const-string v0, "internet_required"

    const-string v2, "internet_required"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getInt(I)I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v11, v0, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 848
    const-string v0, "ab_test"

    const-string v2, "ab_test"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v11, v0, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 849
    const-string v0, "rule_name"

    const-string v2, "rule_name"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v11, v0, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 850
    const-string v0, "location"

    const-string v2, "location"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v11, v0, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 851
    const-string v0, "devices"

    const-string v2, "devices"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v11, v0, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 852
    const-string v0, "marketing_rules"

    const/4 v2, 0x0

    invoke-virtual {p1, v0, v2, v11}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    .line 853
    invoke-virtual {v11}, Landroid/content/ContentValues;->clear()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto/16 :goto_0

    .line 858
    :catchall_0
    move-exception v0

    :goto_1
    if-eqz v1, :cond_0

    .line 860
    :try_start_3
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 861
    :cond_0
    throw v0

    .line 952
    :catchall_1
    move-exception v0

    monitor-exit v10
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    throw v0

    .line 858
    :cond_1
    if-eqz v1, :cond_10

    .line 860
    :try_start_4
    invoke-interface {v1}, Landroid/database/Cursor;->close()V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    move-object v9, v8

    .line 867
    :goto_2
    :try_start_5
    sget-object v0, Lcom/localytics/android/MarketingProvider$MarketingDatabaseHelper;->oldDB:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "amp_ruleevent"

    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    const-string v7, "_id ASC"

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_9

    move-result-object v1

    .line 868
    :goto_3
    :try_start_6
    invoke-interface {v1}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 870
    const-string v0, "_id"

    const-string v2, "_id"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getInt(I)I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v11, v0, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 871
    const-string v0, "event_name"

    const-string v2, "event_name"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v11, v0, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 872
    const-string v0, "rule_id_ref"

    const-string v2, "rule_id_ref"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getInt(I)I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v11, v0, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 873
    const-string v0, "marketing_ruleevent"

    const/4 v2, 0x0

    invoke-virtual {p1, v0, v2, v11}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    .line 874
    invoke-virtual {v11}, Landroid/content/ContentValues;->clear()V
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_2

    goto :goto_3

    .line 879
    :catchall_2
    move-exception v0

    :goto_4
    if-eqz v1, :cond_2

    .line 881
    :try_start_7
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 882
    :cond_2
    throw v0

    .line 879
    :cond_3
    if-eqz v1, :cond_f

    .line 881
    invoke-interface {v1}, Landroid/database/Cursor;->close()V
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_1

    move-object v9, v8

    .line 888
    :goto_5
    :try_start_8
    sget-object v0, Lcom/localytics/android/MarketingProvider$MarketingDatabaseHelper;->oldDB:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "amp_displayed"

    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    const-string v7, "_id ASC"

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_8

    move-result-object v1

    .line 889
    :cond_4
    :goto_6
    :try_start_9
    invoke-interface {v1}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0

    if-eqz v0, :cond_6

    .line 891
    const-string v0, "displayed"

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    if-ne v0, v12, :cond_4

    .line 893
    const-string v0, "campaign_id"

    const-string v2, "campaign_id"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getInt(I)I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v11, v0, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 894
    const-string v0, "marketing_displayed"

    const/4 v2, 0x0

    invoke-virtual {p1, v0, v2, v11}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    .line 895
    invoke-virtual {v11}, Landroid/content/ContentValues;->clear()V
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_3

    goto :goto_6

    .line 901
    :catchall_3
    move-exception v0

    :goto_7
    if-eqz v1, :cond_5

    .line 903
    :try_start_a
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 904
    :cond_5
    throw v0

    .line 901
    :cond_6
    if-eqz v1, :cond_e

    .line 903
    invoke-interface {v1}, Landroid/database/Cursor;->close()V
    :try_end_a
    .catchall {:try_start_a .. :try_end_a} :catchall_1

    move-object v9, v8

    .line 910
    :goto_8
    :try_start_b
    sget-object v0, Lcom/localytics/android/MarketingProvider$MarketingDatabaseHelper;->oldDB:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "amp_conditions"

    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    const-string v7, "_id ASC"

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_b
    .catchall {:try_start_b .. :try_end_b} :catchall_7

    move-result-object v1

    .line 911
    :goto_9
    :try_start_c
    invoke-interface {v1}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0

    if-eqz v0, :cond_8

    .line 913
    const-string v0, "_id"

    const-string v2, "_id"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getInt(I)I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v11, v0, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 914
    const-string v0, "attribute_name"

    const-string v2, "attribute_name"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v11, v0, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 915
    const-string v0, "operator"

    const-string v2, "operator"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v11, v0, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 916
    const-string v0, "rule_id_ref"

    const-string v2, "rule_id_ref"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getInt(I)I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v11, v0, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 917
    const-string v0, "marketing_conditions"

    const/4 v2, 0x0

    invoke-virtual {p1, v0, v2, v11}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    .line 918
    invoke-virtual {v11}, Landroid/content/ContentValues;->clear()V
    :try_end_c
    .catchall {:try_start_c .. :try_end_c} :catchall_4

    goto :goto_9

    .line 923
    :catchall_4
    move-exception v0

    :goto_a
    if-eqz v1, :cond_7

    .line 925
    :try_start_d
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 926
    :cond_7
    throw v0

    .line 923
    :cond_8
    if-eqz v1, :cond_d

    .line 925
    invoke-interface {v1}, Landroid/database/Cursor;->close()V
    :try_end_d
    .catchall {:try_start_d .. :try_end_d} :catchall_1

    .line 932
    :goto_b
    :try_start_e
    sget-object v0, Lcom/localytics/android/MarketingProvider$MarketingDatabaseHelper;->oldDB:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "amp_condition_values"

    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    const-string v7, "_id ASC"

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_e
    .catchall {:try_start_e .. :try_end_e} :catchall_6

    move-result-object v1

    .line 933
    :goto_c
    :try_start_f
    invoke-interface {v1}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0

    if-eqz v0, :cond_a

    .line 935
    const-string v0, "_id"

    const-string v2, "_id"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getInt(I)I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v11, v0, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 936
    const-string v0, "value"

    const-string v2, "value"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v11, v0, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 937
    const-string v0, "condition_id_ref"

    const-string v2, "condition_id_ref"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getInt(I)I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v11, v0, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 938
    const-string v0, "marketing_condition_values"

    const/4 v2, 0x0

    invoke-virtual {p1, v0, v2, v11}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    .line 939
    invoke-virtual {v11}, Landroid/content/ContentValues;->clear()V
    :try_end_f
    .catchall {:try_start_f .. :try_end_f} :catchall_5

    goto :goto_c

    .line 944
    :catchall_5
    move-exception v0

    :goto_d
    if-eqz v1, :cond_9

    .line 946
    :try_start_10
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 947
    :cond_9
    throw v0

    .line 944
    :cond_a
    if-eqz v1, :cond_b

    .line 946
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 951
    :cond_b
    invoke-static {}, Lcom/localytics/android/MarketingProvider$MarketingDatabaseHelper;->cleanUpOldDB()V

    .line 952
    monitor-exit v10
    :try_end_10
    .catchall {:try_start_10 .. :try_end_10} :catchall_1

    .line 954
    :cond_c
    return-void

    .line 944
    :catchall_6
    move-exception v0

    move-object v1, v8

    goto :goto_d

    .line 923
    :catchall_7
    move-exception v0

    move-object v1, v9

    goto :goto_a

    .line 901
    :catchall_8
    move-exception v0

    move-object v1, v9

    goto/16 :goto_7

    .line 879
    :catchall_9
    move-exception v0

    move-object v1, v9

    goto/16 :goto_4

    .line 858
    :catchall_a
    move-exception v0

    move-object v1, v8

    goto/16 :goto_1

    :cond_d
    move-object v8, v1

    goto :goto_b

    :cond_e
    move-object v9, v1

    goto/16 :goto_8

    :cond_f
    move-object v9, v1

    goto/16 :goto_5

    :cond_10
    move-object v9, v1

    goto/16 :goto_2
.end method

.method public onCreate(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 2

    .prologue
    .line 734
    if-nez p1, :cond_0

    .line 736
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "db cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 739
    :cond_0
    const/4 v0, 0x0

    const/4 v1, 0x3

    invoke-virtual {p0, p1, v0, v1}, Lcom/localytics/android/MarketingProvider$MarketingDatabaseHelper;->onUpgrade(Landroid/database/sqlite/SQLiteDatabase;II)V

    .line 740
    return-void
.end method

.method public onOpen(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 5

    .prologue
    .line 980
    invoke-super {p0, p1}, Lcom/localytics/android/BaseProvider$LocalyticsDatabaseHelper;->onOpen(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 982
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

    .line 984
    invoke-virtual {p1}, Landroid/database/sqlite/SQLiteDatabase;->isReadOnly()Z

    move-result v0

    if-nez v0, :cond_0

    .line 989
    const-string v0, "PRAGMA foreign_keys = ON;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 991
    :cond_0
    return-void
.end method

.method public onUpgrade(Landroid/database/sqlite/SQLiteDatabase;II)V
    .locals 1

    .prologue
    .line 959
    if-gtz p2, :cond_0

    .line 961
    invoke-virtual {p0, p1}, Lcom/localytics/android/MarketingProvider$MarketingDatabaseHelper;->migrateV2ToV3(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 964
    :cond_0
    const/4 v0, 0x2

    if-ge p2, v0, :cond_1

    .line 966
    invoke-virtual {p0, p1}, Lcom/localytics/android/MarketingProvider$MarketingDatabaseHelper;->addNonUniqueRuleName(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 969
    :cond_1
    const/4 v0, 0x3

    if-ge p2, v0, :cond_2

    .line 971
    invoke-virtual {p0, p1}, Lcom/localytics/android/MarketingProvider$MarketingDatabaseHelper;->setUpFrequencyCappingTables(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 972
    invoke-virtual {p0, p1}, Lcom/localytics/android/MarketingProvider$MarketingDatabaseHelper;->addControlGroup(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 973
    invoke-virtual {p0, p1}, Lcom/localytics/android/MarketingProvider$MarketingDatabaseHelper;->addSchemaVersion(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 975
    :cond_2
    return-void
.end method

.method protected setUpFrequencyCappingTables(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 10

    .prologue
    .line 1023
    const-string v0, "CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s INTEGER UNIQUE, %s INTEGER, %s INTEGER);"

    const/4 v1, 0x5

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "frequency_capping_rules"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string v3, "_id"

    aput-object v3, v1, v2

    const/4 v2, 0x2

    const-string v3, "campaign_id"

    aput-object v3, v1, v2

    const/4 v2, 0x3

    const-string v3, "max_display_count"

    aput-object v3, v1, v2

    const/4 v2, 0x4

    const-string v3, "ignore_global"

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 1034
    const-string v0, "CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s INTEGER NOT NULL, %s INTEGER NOT NULL, %s INTEGER NOT NULL, FOREIGN KEY(%s) REFERENCES %s(%s) ON DELETE CASCADE);"

    const/16 v1, 0x8

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "frequency_capping_display_frequencies"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string v3, "_id"

    aput-object v3, v1, v2

    const/4 v2, 0x2

    const-string v3, "frequency_id"

    aput-object v3, v1, v2

    const/4 v2, 0x3

    const-string v3, "count"

    aput-object v3, v1, v2

    const/4 v2, 0x4

    const-string v3, "days"

    aput-object v3, v1, v2

    const/4 v2, 0x5

    const-string v3, "frequency_id"

    aput-object v3, v1, v2

    const/4 v2, 0x6

    const-string v3, "frequency_capping_rules"

    aput-object v3, v1, v2

    const/4 v2, 0x7

    const-string v3, "_id"

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 1047
    const-string v0, "CREATE TABLE %s (%s INTEGER NOT NULL, %s INTEGER NOT NULL, %s INTEGER NOT NULL, %s INTEGER NOT NULL, FOREIGN KEY(%s) REFERENCES %s(%s) ON DELETE CASCADE);"

    const/16 v1, 0x8

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "frequency_capping_blackout_dates"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string v3, "frequency_id"

    aput-object v3, v1, v2

    const/4 v2, 0x2

    const-string v3, "rule_group_id"

    aput-object v3, v1, v2

    const/4 v2, 0x3

    const-string v3, "start"

    aput-object v3, v1, v2

    const/4 v2, 0x4

    const-string v3, "end"

    aput-object v3, v1, v2

    const/4 v2, 0x5

    const-string v3, "frequency_id"

    aput-object v3, v1, v2

    const/4 v2, 0x6

    const-string v3, "frequency_capping_rules"

    aput-object v3, v1, v2

    const/4 v2, 0x7

    const-string v3, "_id"

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 1060
    const-string v0, "CREATE TABLE %s (%s INTEGER NOT NULL, %s INTEGER NOT NULL, %s INTEGER NOT NULL, FOREIGN KEY(%s) REFERENCES %s(%s) ON DELETE CASCADE);"

    const/4 v1, 0x7

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "frequency_capping_blackout_weekdays"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string v3, "frequency_id"

    aput-object v3, v1, v2

    const/4 v2, 0x2

    const-string v3, "rule_group_id"

    aput-object v3, v1, v2

    const/4 v2, 0x3

    const-string v3, "day"

    aput-object v3, v1, v2

    const/4 v2, 0x4

    const-string v3, "frequency_id"

    aput-object v3, v1, v2

    const/4 v2, 0x5

    const-string v3, "frequency_capping_rules"

    aput-object v3, v1, v2

    const/4 v2, 0x6

    const-string v3, "_id"

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 1071
    const-string v0, "CREATE TABLE %s (%s INTEGER NOT NULL, %s INTEGER NOT NULL, %s INTEGER NOT NULL, %s INTEGER NOT NULL, FOREIGN KEY(%s) REFERENCES %s(%s) ON DELETE CASCADE);"

    const/16 v1, 0x8

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "frequency_capping_blackout_times"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string v3, "frequency_id"

    aput-object v3, v1, v2

    const/4 v2, 0x2

    const-string v3, "rule_group_id"

    aput-object v3, v1, v2

    const/4 v2, 0x3

    const-string v3, "start"

    aput-object v3, v1, v2

    const/4 v2, 0x4

    const-string v3, "end"

    aput-object v3, v1, v2

    const/4 v2, 0x5

    const-string v3, "frequency_id"

    aput-object v3, v1, v2

    const/4 v2, 0x6

    const-string v3, "frequency_capping_rules"

    aput-object v3, v1, v2

    const/4 v2, 0x7

    const-string v3, "_id"

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 1084
    new-instance v9, Ljava/util/ArrayList;

    invoke-direct {v9}, Ljava/util/ArrayList;-><init>()V

    .line 1085
    const/4 v8, 0x0

    .line 1088
    :try_start_0
    const-string v1, "marketing_displayed"

    const/4 v0, 0x1

    new-array v2, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    const-string v3, "campaign_id"

    aput-object v3, v2, v0

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    move-object v0, p1

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    move-result-object v1

    .line 1089
    :goto_0
    :try_start_1
    invoke-interface {v1}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1091
    const-string v0, "campaign_id"

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-interface {v9, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 1096
    :catchall_0
    move-exception v0

    :goto_1
    if-eqz v1, :cond_0

    .line 1098
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    :cond_0
    throw v0

    .line 1096
    :cond_1
    if-eqz v1, :cond_2

    .line 1098
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 1102
    :cond_2
    const-string v0, "CREATE TABLE %s (%s INTEGER NOT NULL, %s INTEGER NOT NULL, %s INTEGER NOT NULL);"

    const/4 v1, 0x4

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "campaigns_displayed"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string v3, "campaign_id"

    aput-object v3, v1, v2

    const/4 v2, 0x2

    const-string v3, "date"

    aput-object v3, v1, v2

    const/4 v2, 0x3

    const-string v3, "ignore_global"

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 1111
    invoke-interface {v9}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_2
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    .line 1113
    const-string v2, "INSERT INTO %s VALUES (?, datetime(0,\'unixepoch\'), ?);"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    const-string v5, "campaigns_displayed"

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Integer;

    const/4 v4, 0x0

    aput-object v0, v3, v4

    const/4 v0, 0x1

    const/4 v4, 0x1

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v3, v0

    invoke-virtual {p1, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_2

    .line 1121
    :cond_3
    const-string v0, "DROP TABLE %s"

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "marketing_displayed"

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 1123
    const-string v0, "DELETE FROM %s"

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "marketing_rules"

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 1126
    new-instance v0, Ljava/io/File;

    iget-object v1, p0, Lcom/localytics/android/MarketingProvider$MarketingDatabaseHelper;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v1}, Lcom/localytics/android/LocalyticsDao;->getAppContext()Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/localytics/android/MarketingProvider$MarketingDatabaseHelper;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v2}, Lcom/localytics/android/LocalyticsDao;->getApiKey()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/localytics/android/MarketingDownloader;->getMarketingDataDirectory(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-static {v0}, Lcom/localytics/android/BaseProvider;->deleteDirectory(Ljava/io/File;)Z

    .line 1127
    return-void

    .line 1096
    :catchall_1
    move-exception v0

    move-object v1, v8

    goto/16 :goto_1
.end method
