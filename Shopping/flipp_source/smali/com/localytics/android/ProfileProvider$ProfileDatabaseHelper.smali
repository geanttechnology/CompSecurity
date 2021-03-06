.class final Lcom/localytics/android/ProfileProvider$ProfileDatabaseHelper;
.super Lcom/localytics/android/BaseProvider$LocalyticsDatabaseHelper;
.source "SourceFile"


# direct methods
.method constructor <init>(Ljava/lang/String;ILcom/localytics/android/LocalyticsDao;)V
    .locals 0

    .prologue
    .line 105
    invoke-direct {p0, p1, p2, p3}, Lcom/localytics/android/BaseProvider$LocalyticsDatabaseHelper;-><init>(Ljava/lang/String;ILcom/localytics/android/LocalyticsDao;)V

    .line 106
    return-void
.end method


# virtual methods
.method protected final migrateV2ToV3(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 11

    .prologue
    const/4 v8, 0x0

    .line 133
    const-string v0, "CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL)"

    const/4 v1, 0x5

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "changes"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string v3, "_id"

    aput-object v3, v1, v2

    const/4 v2, 0x2

    const-string v3, "scope"

    aput-object v3, v1, v2

    const/4 v2, 0x3

    const-string v3, "change"

    aput-object v3, v1, v2

    const/4 v2, 0x4

    const-string v3, "customer_id"

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 144
    sget-object v0, Lcom/localytics/android/ProfileProvider$ProfileDatabaseHelper;->oldDB:Landroid/database/sqlite/SQLiteDatabase;

    if-eqz v0, :cond_3

    .line 146
    sget-object v9, Lcom/localytics/android/ProfileProvider$ProfileDatabaseHelper;->oldDB:Landroid/database/sqlite/SQLiteDatabase;

    monitor-enter v9

    .line 151
    :try_start_0
    new-instance v10, Landroid/content/ContentValues;

    invoke-direct {v10}, Landroid/content/ContentValues;-><init>()V

    .line 152
    sget-object v0, Lcom/localytics/android/ProfileProvider$ProfileDatabaseHelper;->oldDB:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "profile"

    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    const-string v7, "_id ASC"

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_2

    move-result-object v1

    .line 156
    :goto_0
    :try_start_1
    invoke-interface {v1}, Landroid/database/Cursor;->moveToNext()Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result v0

    if-eqz v0, :cond_1

    .line 160
    :try_start_2
    new-instance v2, Lorg/json/JSONObject;

    const-string v0, "attribute"

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-direct {v2, v0}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 161
    new-instance v3, Lorg/json/JSONObject;

    invoke-direct {v3}, Lorg/json/JSONObject;-><init>()V

    .line 162
    const-string v0, "op"

    sget-object v4, Lcom/localytics/android/ProfileHandler$ProfileOperation;->ASSIGN:Lcom/localytics/android/ProfileHandler$ProfileOperation;

    invoke-virtual {v4}, Lcom/localytics/android/ProfileHandler$ProfileOperation;->getOperationString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v0, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 163
    invoke-virtual {v2}, Lorg/json/JSONObject;->keys()Ljava/util/Iterator;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 164
    const-string v4, "attr"

    invoke-virtual {v3, v4, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 165
    const-string v4, "value"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {v3, v4, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 167
    const-string v0, "scope"

    sget-object v2, Lcom/localytics/android/Localytics$ProfileScope;->APPLICATION:Lcom/localytics/android/Localytics$ProfileScope;

    invoke-virtual {v2}, Lcom/localytics/android/Localytics$ProfileScope;->getScope()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v10, v0, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 168
    const-string v0, "change"

    invoke-virtual {v3}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v10, v0, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 169
    const-string v0, "customer_id"

    const-string v2, "customer_id"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v10, v0, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 170
    const-string v0, "changes"

    const/4 v2, 0x0

    invoke-virtual {p1, v0, v2, v10}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    .line 171
    invoke-virtual {v10}, Landroid/content/ContentValues;->clear()V
    :try_end_2
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0

    .line 173
    :catch_0
    move-exception v0

    .line 175
    :try_start_3
    const-string v2, "Caught JSON exception"

    invoke-static {v2, v0}, Lcom/localytics/android/Localytics$Log;->w(Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_0

    .line 183
    :catchall_0
    move-exception v0

    :goto_1
    if-eqz v1, :cond_0

    .line 185
    :try_start_4
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 186
    :cond_0
    throw v0

    .line 189
    :catchall_1
    move-exception v0

    monitor-exit v9
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    throw v0

    .line 179
    :cond_1
    :try_start_5
    invoke-static {}, Lcom/localytics/android/ProfileProvider$ProfileDatabaseHelper;->cleanUpOldDB()V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 183
    if-eqz v1, :cond_2

    .line 185
    :try_start_6
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 189
    :cond_2
    monitor-exit v9
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    .line 191
    :cond_3
    return-void

    .line 183
    :catchall_2
    move-exception v0

    move-object v1, v8

    goto :goto_1
.end method

.method public final onCreate(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 2

    .prologue
    .line 120
    if-nez p1, :cond_0

    .line 122
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "db cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 125
    :cond_0
    const-string v0, "PRAGMA auto_vacuum = INCREMENTAL;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 126
    const/4 v0, 0x0

    const/4 v1, 0x1

    invoke-virtual {p0, p1, v0, v1}, Lcom/localytics/android/ProfileProvider$ProfileDatabaseHelper;->onUpgrade(Landroid/database/sqlite/SQLiteDatabase;II)V

    .line 127
    return-void
.end method

.method public final onOpen(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 5

    .prologue
    .line 205
    invoke-super {p0, p1}, Lcom/localytics/android/BaseProvider$LocalyticsDatabaseHelper;->onOpen(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 207
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

    .line 209
    invoke-virtual {p1}, Landroid/database/sqlite/SQLiteDatabase;->isReadOnly()Z

    move-result v0

    if-nez v0, :cond_0

    .line 214
    const-string v0, "PRAGMA foreign_keys = ON;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 216
    :cond_0
    return-void
.end method

.method public final onUpgrade(Landroid/database/sqlite/SQLiteDatabase;II)V
    .locals 0

    .prologue
    .line 196
    if-gtz p2, :cond_0

    .line 198
    invoke-virtual {p0, p1}, Lcom/localytics/android/ProfileProvider$ProfileDatabaseHelper;->migrateV2ToV3(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 200
    :cond_0
    return-void
.end method
